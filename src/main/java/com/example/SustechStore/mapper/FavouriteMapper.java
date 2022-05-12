package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.Favourite;
import com.example.SustechStore.pojo.FavouriteExample;
import com.example.SustechStore.pojo.FavouriteKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteMapper {
    long countByExample(FavouriteExample example);

    int deleteByExample(FavouriteExample example);

    int deleteByPrimaryKey(FavouriteKey key);

    int insert(Favourite record);

    int insertSelective(Favourite record);

    List<Favourite> selectByExample(FavouriteExample example);

    Favourite selectByPrimaryKey(FavouriteKey key);

    int updateByExampleSelective(@Param("record") Favourite record, @Param("example") FavouriteExample example);

    int updateByExample(@Param("record") Favourite record, @Param("example") FavouriteExample example);

    int updateByPrimaryKeySelective(Favourite record);

    int updateByPrimaryKey(Favourite record);
}