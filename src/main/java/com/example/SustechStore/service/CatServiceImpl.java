package com.example.SustechStore.service;

import com.example.SustechStore.mapper.ClassificationMapper;
import com.example.SustechStore.pojo.Classification;
import com.example.SustechStore.pojo.ClassificationExample;
import com.example.SustechStore.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private ClassificationMapper classificationMapper;
    @Autowired
    private UserServiceImpl userService;


    public List<Map<String, Object>> findGoodByCat(int cat_id, Timestamp t,int type) {
        List<Map<String, Object>> ans=classificationMapper.findGoodByCat(cat_id, t,type);
        ans.removeIf(map -> userService.isLogout((int) map.get("seller_id")));
        return ans;

    }


    public String findGood_icon(int id) {
        List<String> list = classificationMapper.findGood_icon(id);
        if (list == null || list.isEmpty()) return "";
        return list.get(0);
    }

    public Map<String, Object> findCatDetail(int id,int type) {
        Classification cat = classificationMapper.selectByPrimaryKey(id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Map<String, Object>> list = findGoodByCat(id, timestamp,type);
        for (Map<String, Object> m : list) {
            m.put("good_icon", findGood_icon((Integer) m.get("good_id")));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("cat_id", cat.getClassificationId());
        map.put("cat_name", cat.getClassificationName());
        map.put("children", PageUtils.getSubList(list, 0, 10));
        return map;
    }

    @Override
    public List<Map<String, Object>> findCatPageDetail(String cat, Timestamp timestamp, int pageNum, int pageSize,int type) {
        int cat_id=findCat_id(cat);
        List<Map<String, Object>> list = findGoodByCat(cat_id, timestamp,type);

        for (Map<String, Object> m : list) {
            m.put("good_icon", findGood_icon((Integer) m.get("good_id")));
        }
        return PageUtils.getSubList(list, pageNum, pageSize);
    }

    @Override
    public List<Map<String, Object>> init(int type) {
        List<Map<String, Object>> ans = new ArrayList<>();
        ClassificationExample classificationExample = new ClassificationExample();
        List<Classification> catList = classificationMapper.selectByExample(classificationExample);
        for (Classification classification : catList) {
            ans.add(findCatDetail(classification.getClassificationId(),type));
        }
        return ans;
    }

    public int findCat_id(String cat){
        ClassificationExample classificationExample = new ClassificationExample();
        ClassificationExample.Criteria criteria =classificationExample.createCriteria();
        criteria.andClassificationNameEqualTo(cat);
        List<Classification> catList = classificationMapper.selectByExample(classificationExample);
        if (catList==null)return -1;
        else return catList.get(0).getClassificationId();
    }


}
