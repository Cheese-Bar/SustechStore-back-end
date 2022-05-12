package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.Binding;
import com.example.SustechStore.pojo.BindingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BindingMapper {
    long countByExample(BindingExample example);

    int deleteByExample(BindingExample example);

    int insert(Binding record);

    int insertSelective(Binding record);

    List<Binding> selectByExample(BindingExample example);

    int updateByExampleSelective(@Param("record") Binding record, @Param("example") BindingExample example);

    int updateByExample(@Param("record") Binding record, @Param("example") BindingExample example);
}