package com.taotao.mapper;

import com.taotao.pojo.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {

    Item selectOneItem(@Param(value = "intId") String id);

    List<Item> selectListByParams(Map params);

    long selectCountByParams(Map params);
}
