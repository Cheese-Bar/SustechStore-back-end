package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.SearchService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Api(tags = "搜索接口")
@RestController
@RequestMapping("/Search")
public class SearchController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "简单模糊搜索")
    @NeedEncrypt
    @RequestMapping(value = "/fuzzy/{time}/{string}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseBean<Object> fuzzySearch(@PathVariable String string, @PathVariable String time,
                                            @PathVariable String pageNum, @PathVariable String pageSize) {
        AESUtil aesUtil = new AESUtil();
        string = aesUtil.decryptHex(string, key);
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(searchService.searchGoodsByString(timestamp, string, Integer.parseInt(pageNum), Integer.parseInt(pageSize)));
    }

    @ApiOperation(value = "带有筛选与排序的模糊搜索")
    @NeedEncrypt
    @RequestMapping(value = "/fuzzyPlus/{time}/{string}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}", method = RequestMethod.GET)
    public ResponseBean<Object> fuzzySearchPlusOrder(@PathVariable String string, @PathVariable String time,
                                                     @PathVariable String pageNum, @PathVariable String pageSize,
                                                     @PathVariable String orderNum, @PathVariable String goodState,
                                                     @PathVariable String type) {
        AESUtil aesUtil = new AESUtil();
        string = aesUtil.decryptHex(string, key);
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);
        type = aesUtil.decryptHex(type, key);

        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(
                searchService.searchGoods(
                        timestamp, string, Integer.parseInt(pageNum), Integer.parseInt(pageSize),
                        Integer.parseInt(orderNum), Integer.parseInt(goodState), Integer.parseInt(type)
                )
        );
    }
}
