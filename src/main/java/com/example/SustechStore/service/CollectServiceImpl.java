package com.example.SustechStore.service;

import com.example.SustechStore.mapper.BrowsingRecordMapper;
import com.example.SustechStore.mapper.FavouriteMapper;
import com.example.SustechStore.mapper.GoodsMapper;
import com.example.SustechStore.mapper.UsersMapper;
import com.example.SustechStore.pojo.*;
import com.example.SustechStore.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private FavouriteMapper favouriteMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsImageService goodsImageService;
    @Autowired
    private BrowsingRecordMapper browsingRecordMapper;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Map<String, Object>> getFavorite(Timestamp timestamp, int userId, int pageNum, int pageSize,
                                                 int orderNum, int goodState, int type) {
        FavouriteExample favouriteExample = new FavouriteExample();

        FavouriteExample.Criteria criteria = favouriteExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(true);
        criteria.andFavouriteTimeLessThanOrEqualTo(timestamp);
        // TODO: 时间排序
        switch (orderNum) {
            case 10:
                favouriteExample.setOrderByClause("favourite_time desc");
                break;
            case 11:
                favouriteExample.setOrderByClause("favourite_time asc");
                break;
        }

        // TODO: 得到收藏的商品的编号List
        List<Favourite> temp = favouriteMapper.selectByExample(favouriteExample);

        // TODO: 根据商品id 获得商品信息
        List<Goods> goodsList = new ArrayList<>();
        for (Favourite favourite : temp) {
            goodsList.add(goodsMapper.selectByPrimaryKey(favourite.getGoodsId()));
        }

        // TODO: 价格排序
        switch (orderNum) {
            case 20:
                goodsList.sort(new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return -o1.getPrice().compareTo(o2.getPrice());
                    }
                });
                break;
            case 21:
                goodsList.sort(new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                });
                break;
        }

        // TODO: 删除不符合筛选条件的商品
        if (goodState != -1) {
            goodsList.removeIf(g -> g.getGoodsState() != goodState);
        }
        if (type != -1) {
            goodsList.removeIf(g -> g.getType() != type);
        }

        // TODO: 添加good 简略信息
        List<Map<String, Object>> result = new ArrayList<>();
        result = goodService.transGoodToBrief(goodsList);

        // TODO: 根据page截取部分
        return PageUtils.getSubList(result, pageNum, pageSize);
    }

    @Override
    public List<Map<String, Object>> getFootPrint(Timestamp timestamp, int userId, int pageNum, int pageSize,
                                                  int orderNum, int goodState, int type) {
        List<BrowsingRecord> browsingRecordList = new ArrayList();
        BrowsingRecordExample browsingRecordExample = new BrowsingRecordExample();
//        browsingRecordExample.setOrderByClause("view_time desc");
        BrowsingRecordExample.Criteria criteria = browsingRecordExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andViewTimeLessThanOrEqualTo(timestamp);

        //TODO:
        switch (orderNum) {
            case 10:
                browsingRecordExample.setOrderByClause("view_time desc");
                break;
            case 11:
                browsingRecordExample.setOrderByClause("view_time asc");
                break;
        }


        //得到足迹的商品的编号List 并选取部分
        List<BrowsingRecord> temp = browsingRecordMapper.selectByExample(browsingRecordExample);
//        browsingRecordList = PageUtils.getSubList(temp, pageNum, pageSize);

        //根据商品id 获得商品信息
        List<Goods> goodsList = new ArrayList<>();
        for (BrowsingRecord browsingRecord : temp) {
            goodsList.add(goodsMapper.selectByPrimaryKey(browsingRecord.getGoodsId()));
        }

        // TODO: 价格排序
        switch (orderNum) {
            case 20:
                goodsList.sort(new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return -o1.getPrice().compareTo(o2.getPrice());
                    }
                });
                break;
            case 21:
                goodsList.sort(new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                });
                break;
        }

        // TODO: 删除不符合筛选条件的商品
        if (goodState != -1) {
            goodsList.removeIf(g -> g.getGoodsState() != goodState);
        }
        if (type != -1) {
            goodsList.removeIf(g -> g.getType() != type);
        }

        //添加good 简略信息
        List<Map<String, Object>> result = new ArrayList<>();
        result = goodService.transGoodToBrief(goodsList);

        // TODO: 根据page截取部分
        return PageUtils.getSubList(result, pageNum, pageSize);
    }

    @Override
    public boolean updateFavorite(int userId, int goodId) {
        FavouriteKey favouriteKey = new FavouriteKey();
        favouriteKey.setUserId(userId);
        favouriteKey.setGoodsId(goodId);
        boolean isExist = favouriteMapper.selectByPrimaryKey(favouriteKey) != null;

        Favourite favouriteNew = new Favourite();
        favouriteNew.setGoodsId(goodId);
        favouriteNew.setUserId(userId);
        favouriteNew.setFavouriteTime(new Date(System.currentTimeMillis()));
        favouriteNew.setStatus(true);

        if (isExist) {//更新 取反
            Favourite favourite = favouriteMapper.selectByPrimaryKey(favouriteKey);
            favouriteNew.setStatus(!favourite.getStatus());
            favouriteMapper.updateByPrimaryKey(favouriteNew);
        } else {
            favouriteMapper.insert(favouriteNew);
        }
        return true;
    }


    public boolean deleteGood(int userId, int goodId) {
        try {
            Goods good = goodsMapper.selectByPrimaryKey(goodId);
            if (good.getSellerId() == userId) {
                good.setGoodsState(3);
                goodsMapper.updateByPrimaryKey(good);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean resubmitGood(int userId, int goodId) {
        Goods good = goodsMapper.selectByPrimaryKey(goodId);
        if (good.getSellerId() == userId && good.getGoodsState() == 2 || good.getGoodsState() == 3) {
            good.setGoodsState(1);
            good.setUploadTime(new Date(System.currentTimeMillis()));
            goodsMapper.updateByPrimaryKey(good);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> collectInit(Timestamp timestamp, int userId) {
        Users user = usersMapper.selectByPrimaryKey(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("credit", user.getCreditScore());
        map.put("balance", user.getBalance());

        FavouriteExample favouriteExample = new FavouriteExample();
        FavouriteExample.Criteria criteria = favouriteExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(true);
        criteria.andFavouriteTimeLessThanOrEqualTo(timestamp);
        List<Favourite> temp = favouriteMapper.selectByExample(favouriteExample);
        map.put("favouriteNum", temp.size());

        BrowsingRecordExample browsingRecordExample = new BrowsingRecordExample();
        BrowsingRecordExample.Criteria criteria2 = browsingRecordExample.createCriteria();
        criteria2.andUserIdEqualTo(userId);
        criteria2.andViewTimeLessThanOrEqualTo(timestamp);
        List<BrowsingRecord> temp2 = browsingRecordMapper.selectByExample(browsingRecordExample);
        map.put("footNum", temp2.size());

        return map;
    }
}
