package com.tensquare.base.dao;

import com.tensquare.base.po.Label;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签管理的dao接口
 */
public interface LabelRepository extends JpaRepository<Label,String> {
}
