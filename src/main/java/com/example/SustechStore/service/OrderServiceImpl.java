package com.example.SustechStore.service;

import cn.hutool.db.sql.Order;
import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.mapper.GoodsMapper;
import com.example.SustechStore.mapper.OrdersMapper;
import com.example.SustechStore.mapper.UsersMapper;
import com.example.SustechStore.pojo.Goods;
import com.example.SustechStore.pojo.Orders;
import com.example.SustechStore.pojo.OrdersExample;
import com.example.SustechStore.pojo.Users;
import com.example.SustechStore.util.PageUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Map<String, Object>> selectBySellerId(int id, int pageNum, int pageSize,
                                                      Timestamp timestamp, int type,
                                                      int orderNum, int goodState) {
        List<Map<String, Object>> ans = new ArrayList<>();
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andSellerIdEqualTo(id);
        criteria.andOrderTimeLessThanOrEqualTo(timestamp);

        switch (orderNum) {
            case 10:
                ordersExample.setOrderByClause("order_time desc");
                break;
            case 11:
                ordersExample.setOrderByClause("order_time asc");
                break;
            case 20:
                ordersExample.setOrderByClause("order_price desc");
                break;
            case 21:
                ordersExample.setOrderByClause("order_price asc");
                break;
        }

        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);


        for (Orders order : ordersList) {
            String json = JSONObject.toJSONString(order);
            Map map = JSONObject.parseObject(json, Map.class);
            Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodsId());
            map.put("goodsIcon", goodsImageService.selectIcon(goods.getGoodsId()));
            map.put("goodsName", goods.getName());
            map.put("goodClass", goods.getClassificationId());
            map.put("type", goods.getType());
            map.put("tradeMethod", goods.getTradeMethod());
//            map.put("buyerHeadImage", getHeadImg(order.getBuyerId()));
            Users users = usersMapper.selectByPrimaryKey(order.getBuyerId());
            map.put("buyerName", users.getUserNickname());
            map.put("buyerIcon", users.getHeadImage());
            map.put("buyerCredit", users.getCreditScore());
            if ((type == -1 || goods.getType() == type)
                    && (goodState == -1 || goodState == goods.getGoodsState())) {
                ans.add(map);
            }
        }

        return PageUtils.getSubList(ans, pageNum, pageSize);
    }

    @Override
    public List<Map<String, Object>> selectByBuyerId(int id, int pageNum, int pageSize,
                                                     Timestamp timestamp, int type,
                                                     int orderNum, int goodState) {
        List<Map<String, Object>> ans = new ArrayList<>();
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andBuyerIdEqualTo(id);
        criteria.andOrderTimeLessThanOrEqualTo(timestamp);

        switch (orderNum) {
            case 10:
                ordersExample.setOrderByClause("order_time desc");
                break;
            case 11:
                ordersExample.setOrderByClause("order_time asc");
                break;
            case 20:
                ordersExample.setOrderByClause("order_price desc");
                break;
            case 21:
                ordersExample.setOrderByClause("order_price asc");
                break;
        }

        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        for (Orders order : ordersList) {
            String json = JSONObject.toJSONString(order);
            Map map = JSONObject.parseObject(json, Map.class);
            Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodsId());
            map.put("goodsIcon", goodsImageService.selectIcon(goods.getGoodsId()));
            map.put("goodsName", goods.getName());
            map.put("goodClass", goods.getClassificationId());
            map.put("type", goods.getType());
            map.put("tradeMethod", goods.getTradeMethod());
//            map.put("seller_head_image", getHeadImg(order.getSellerId()));
//            map.put("sellerName", usersMapper.selectByPrimaryKey(order.getSellerId()).getUserNickname());
            Users users = usersMapper.selectByPrimaryKey(order.getSellerId());
            map.put("sellerName", users.getUserNickname());
            map.put("sellerIcon", users.getHeadImage());
            map.put("sellerCredit", users.getCreditScore());
            if ((type == -1 || goods.getType() == type)
                    && (goodState == -1 || goodState == goods.getGoodsState())) {
                ans.add(map);
            }
        }
        return PageUtils.getSubList(ans, pageNum, pageSize);
    }

    @Override
    public Map<String, Object> buyGood(int userId, int goodId) {
        Goods good = goodsMapper.selectByPrimaryKey(goodId);
        Users user = usersMapper.selectByPrimaryKey(userId);
        Users seller = usersMapper.selectByPrimaryKey(good.getSellerId());

        Map map = new HashMap();
        if (user.getBalance() <= good.getPrice()) {
            map.put("status", false);
            map.put("balance", user.getBalance());
            map.put("orderUuid", "创建订单失败");
        } else {
            //新建订单
            Orders order = new Orders();
            order.setGoodsId(goodId);
            order.setBuyerId(userId);
            order.setSellerId(good.getSellerId());
            order.setOrderTime(new Date(System.currentTimeMillis()));
            order.setOrderPrice(good.getPrice());
            //生成订单编号
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            order.setOrderUuid(uuid);

            //更新 user和seller的信息
            good.setGoodsState(2);
            user.setBalance(user.getBalance() - good.getPrice());
            seller.setBalance(seller.getBalance() + good.getPrice());

            // 更新信誉积分 卖家+5分 买家+2分
            user.setCreditScore(user.getCreditScore() + 2);
            seller.setCreditScore(seller.getCreditScore() + 5);

            // 更新数据库
            ordersMapper.insertSelective(order);
            usersMapper.updateByPrimaryKey(user);
            goodsMapper.updateByPrimaryKey(good);
            map.put("status", true);
            map.put("balance", user.getBalance());
            map.put("orderUuid", uuid);
        }
        return map;
    }

    String getHeadImg(int user_id) {
        return usersMapper.selectByPrimaryKey(user_id).getHeadImage();
    }
}
