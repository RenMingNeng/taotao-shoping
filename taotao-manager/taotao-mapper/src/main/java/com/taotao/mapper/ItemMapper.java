package com.taotao.mapper;

import com.taotao.pojo.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {

    Item selectOneItem(@Param(value = "intId") String id);
}
