package com.example.SustechStore.service;

import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.mapper.GoodsMapper;
import com.example.SustechStore.pojo.GoodBrief;
import com.example.SustechStore.pojo.Goods;
import com.example.SustechStore.pojo.GoodsExample;
import com.example.SustechStore.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsImageService goodsImageService;
    @Autowired
    private GoodService goodService;

    @Override
    public List<Map<String, Object>> searchGoodsByString(Timestamp timestamp, String s,
                                                         int pageNum, int pageSize) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("upload_time desc");
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameLike("%" + s + "%");
        criteria.andUploadTimeLessThanOrEqualTo(timestamp);

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<Map<String, Object>> result = new ArrayList<>();
        result = goodService.transGoodToBrief(goodsList);
        List<Map<String, Object>> result0 = PageUtils.getSubList(result, pageNum, pageSize);
        return result0;
    }

    public List<Map<String, Object>> searchGoodsByStringAndSort(Timestamp timestamp, String s,
                                                                int pageNum, int pageSize, int sortMethod) {
        String sort;
        if (sortMethod == 1) {
            sort = "price";
        } else {
            sort = "upload_time";
        }
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " desc");
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameLike("%" + s + "%");
        criteria.andUploadTimeLessThanOrEqualTo(timestamp);

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<Map<String, Object>> result;
        result = goodService.transGoodToBrief(goodsList);

        List<Map<String, Object>> result0 = PageUtils.getSubList(result, pageNum, pageSize);
        return result0;
    }

    @Override
    public List<GoodBrief> searchGoods(Timestamp timestamp, String s,
                                       int pageNum, int pageSize,
                                       int orderNum, int goodState, int type) {
        /* TODO: 实现1个order排序 + 3个 状态筛选的搜索功能
                orderNum: （使用非以下编号 则为不使用排序功能）
                         10 时间降序
                         11 时间升序
                         20 价格降序
                         21 价格升序
                         30 信誉积分降序
                         31 信誉积分升序
                goodState: -1 (不使用该属性筛选）
                           1 在售商品
                           2 已完成交易的商品
                           3 主动下架的商品
                type: -1（不使用该属性筛选）
                      1 货架商品
                      2 求购商品
         */
        // TODO: 根据状态码排序
        List<GoodBrief> goodsList = new ArrayList<>();
        String searchInfo = "%" + s + "%";
//        switch (orderNum) {
//            case 10: goodsList = goodsMapper.selectBriefByUploadTimeDesc(searchInfo, goodState, type, timestamp);break;
//            case 11: goodsList = goodsMapper.selectBriefByUploadTimeAsc(searchInfo, goodState, type, timestamp);break;
//            case 20: goodsList = goodsMapper.selectBriefByPriceDesc(searchInfo, goodState, type, timestamp);break;
//            case 21: goodsList = goodsMapper.selectBriefByPriceAsc(searchInfo, goodState, type, timestamp);break;
//            case 30: goodsList = goodsMapper.selectBriefByCreditDesc(searchInfo, goodState, type, timestamp);break;
//            case 31: goodsList = goodsMapper.selectBriefByCreditAsc(searchInfo, goodState, type, timestamp);break;
//        }
        goodsList = goodsMapper.selectBriefByOrderNum(orderNum, searchInfo, goodState, type, timestamp);
        List<GoodBrief> tempList = PageUtils.getSubList(goodsList, pageNum, pageSize);
        for (int i = 0; i < tempList.size(); i++) {
            int tempGoodId = tempList.get(i).getGoodId();
            tempList.get(i).setGoodIcon(goodsImageService.selectIcon(tempGoodId));
        }
        return tempList;
    }
}
