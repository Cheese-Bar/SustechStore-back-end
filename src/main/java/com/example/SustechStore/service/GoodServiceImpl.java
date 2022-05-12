package com.example.SustechStore.service;

import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.mapper.*;
import com.example.SustechStore.pojo.*;
import com.example.SustechStore.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private BrowsingRecordMapper browsingRecordMapper;
    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private LabelsMapper labelsMapper;

    @Autowired
    private GoodsLabelsMapper goodsLabelsMapper;

    @Autowired
    private FavouriteMapper favouriteMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserServiceImpl userService;

    public List<Goods> selectGoodBySellerId(int id, Timestamp timestamp, int type,int orderNum,int goodState) {
        GoodsExample goodsExample = new GoodsExample();

        switch (orderNum) {
            case 10:
                goodsExample.setOrderByClause("upload_time desc");
                break;
            case 11:
                goodsExample.setOrderByClause("upload_time asc");
                break;
            case 20:
                goodsExample.setOrderByClause("price desc");
                break;
            case 21:
                goodsExample.setOrderByClause("price asc");
                break;
        }
        goodsExample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
        GoodsExample.Criteria criteria = goodsExample.createCriteria(); //构造自定义查询条件
        criteria.andSellerIdEqualTo(id);
        if (goodState!=-1)
            criteria.andGoodsStateEqualTo(goodState);
        criteria.andUploadTimeLessThanOrEqualTo(timestamp);
        if (type != -1)
            criteria.andTypeEqualTo(type);

        return goodsMapper.selectByExample(goodsExample);
    }

    @Override
    public List<Map<String, Object>> findMyRelease(int id, int pageNum, int pageSize, Timestamp timestamp, int type,int orderNum, int goodState) {
        List<Goods> goodsList = selectGoodBySellerId(id, timestamp, type,orderNum,goodState);
        List<Map<String,Object>> tempList = goodsAddUrl(goodsList);

        //加入icon,labels
        List<Map<String,Object>> outList = new ArrayList<>();
        for (Map<String,Object> map: tempList) {
            int goodsId=(int)map.get("goodsId");
            map.put("goodIcon",goodsImageService.selectIcon(goodsId));

            GoodsLabelsExample goodsLabelsExample = new GoodsLabelsExample();
            GoodsLabelsExample.Criteria criteria = goodsLabelsExample.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);
            List<GoodsLabelsKey> labels = goodsLabelsMapper.selectByExample(goodsLabelsExample);

            List<String> labelsName = new ArrayList();
            for (GoodsLabelsKey goodsLabelsKey : labels) {
                labelsName.add(labelsMapper.selectByPrimaryKey(goodsLabelsKey.getLabelsId()).getLabelsName());
            }
            map.put("labels", labelsName);

            Address address = addressMapper.selectByPrimaryKey(map.get("addressId")==null?0:(int)map.get("addressId"));
            if (address != null) {
                map.put("addressId", address.getAddressName());
            } else {
                map.put("addressId", "");
            }

            Address address2 = addressMapper.selectByPrimaryKey(map.get("addressId2")==null?0:(int)map.get("addressId2"));
            if (address2 != null) {
                map.put("addressId2", address2.getAddressName());
            } else {
                map.put("addressId2", "");
            }


            outList.add(map);
        }


        return PageUtils.getSubList(outList, pageNum, pageSize);

    }

    @Override
    public List<Map<String, Object>> selectGoodByPage(Timestamp timestamp, int pageNum, int pageSize) {
        List<Goods> pageGoods;
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("upload_time desc");
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsStateEqualTo(1);
        criteria.andUploadTimeLessThanOrEqualTo(timestamp);
        List<Goods> goods=goodsMapper.selectByExample(goodsExample);
        goods.removeIf(goods1 -> userService.isLogout(goods1.getSellerId()));

        pageGoods = PageUtils.getSubList(goods, pageNum, pageSize);
        List<Map<String, Object>> result;
        result = transGoodToBrief(pageGoods);

        return result;
    }

    @Override
    public Map<String, Object> findGoodDetail(int user_id, int good_id) {
        List<Goods> list = new ArrayList<>();
        Goods goods = goodsMapper.selectByPrimaryKey(good_id);
        if (goods == null) return new HashMap();
        list.add(goods);

        Map map = goodsAddUrl(list).get(0);

        //添加labels
        List<GoodsLabelsKey> labels = new ArrayList();
        GoodsLabelsExample goodsLabelsExample = new GoodsLabelsExample();
        GoodsLabelsExample.Criteria criteria = goodsLabelsExample.createCriteria();
        criteria.andGoodsIdEqualTo(good_id);
        labels = goodsLabelsMapper.selectByExample(goodsLabelsExample);

        List<String> labelsName = new ArrayList();
        for (GoodsLabelsKey goodsLabelsKey : labels) {
            labelsName.add(labelsMapper.selectByPrimaryKey(goodsLabelsKey.getLabelsId()).getLabelsName());
        }
        map.put("labelsDetail", labelsName);

        //添加喜欢
        FavouriteExample favouriteExample = new FavouriteExample();
        FavouriteExample.Criteria criteria1 = favouriteExample.createCriteria();
        criteria1.andUserIdEqualTo(user_id);
        criteria1.andGoodsIdEqualTo(good_id);

        List<Favourite> favourite = favouriteMapper.selectByExample(favouriteExample);
        if (favourite != null && !favourite.isEmpty() && favourite.get(0).getStatus() == Boolean.TRUE) {
            map.put("favourite", true);
        } else {
            map.put("favourite", false);
        }

        //添加地址
        Address address = addressMapper.selectByPrimaryKey(goods.getAddressId());
        if (address != null) {
            map.put("address", address.getAddressName());
        } else {
            map.put("address", "");
        }

        Address address2 = addressMapper.selectByPrimaryKey(goods.getAddressId2());
        if (address2 != null) {
            map.put("address2", address2.getAddressName());
        } else {
            map.put("address2", "");
        }

        //添加发布者名字
        Users users = usersMapper.selectByPrimaryKey(goods.getSellerId());
        if (users != null) {
            map.put("sellerName", users.getUserNickname());
            map.put("credit", users.getCreditScore());
        } else {
            map.put("sellerName", "");
        }

        //添加缩略图
        map.put("good_icon", goodsImageService.selectIcon(goods.getGoodsId()));

        //足迹记录
        BrowsingRecordKey browsingRecordKey = new BrowsingRecordKey();
        browsingRecordKey.setGoodsId(good_id);
        browsingRecordKey.setUserId(user_id);

        BrowsingRecord browsingRecord = new BrowsingRecord();
        browsingRecord.setUserId(user_id);
        browsingRecord.setGoodsId(good_id);
        browsingRecord.setViewTime(new Date(System.currentTimeMillis()));
        if (browsingRecordMapper.selectByPrimaryKey(browsingRecordKey) != null) {
            browsingRecordMapper.updateByPrimaryKey(browsingRecord);
        }else {
            browsingRecordMapper.insert(browsingRecord);
        }

        return map;

    }

    @Override
    public boolean deleteGood(int goodsId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        goods.setGoodsState(4);
        try {
            goodsMapper.updateByPrimaryKeySelective(goods);
        }catch (Exception ignored){
            return false;
        }
        return true;
    }


    public List<Map<String, Object>> goodsAddUrl(List<Goods> goodsList) {
        if (goodsList == null) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> releases = new ArrayList<>();
        for (Goods goods : goodsList) {
            String json = JSONObject.toJSONString(goods);
            Map map = JSONObject.parseObject(json, Map.class);
            map.put("image_detail", goodsImageService.selectImage(goods.getGoodsId()));
            releases.add(map);
        }
        return releases;
    }

    public List<Map<String, Object>> transGoodToBrief(List<Goods> goodsList) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Goods goods : goodsList) {
            Map map = new HashMap();
            map.put("good_price", goods.getPrice());
            map.put("good_icon", goodsImageService.selectIcon(goods.getGoodsId()));
            map.put("good_id", goods.getGoodsId());
            map.put("good_name", goods.getName());
            map.put("type",goods.getType());
            result.add(map);
        }
        return result;
    }
}
