package com.taotao.dao;

import com.taotao.pojo.ContentCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    ContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentCategory record);

    int updateByPrimaryKey(ContentCategory record);
}