package com.example.SustechStore.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    public static List getSubList(List list, int pageNum, int pageSize) {
        if (list != null
                && pageNum >= 0
                && pageSize > 0
                && pageNum * pageSize < list.size()) {
            List list2 = list.subList(pageNum * pageSize, Math.min((pageNum + 1) * pageSize, list.size()));
            return list2;
        }
        return new ArrayList<>();
    }
}
