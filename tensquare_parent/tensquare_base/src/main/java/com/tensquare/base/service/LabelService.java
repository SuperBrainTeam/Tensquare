package com.tensquare.base.service;

import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

/**
 * 标签管理的业务
 */
@Service
public class LabelService {
    //注入dao
    @Autowired
    private LabelRepository labelRepository;
    //注入id生成器
    @Autowired
    private IdWorker idWorker;

    /**
     * 标签的保存
     * @param label
     */
    public void saveLabel(Label label){
        //设置主键
        label.setId(idWorker.nextId()+"");
        //调用dao
        labelRepository.save(label);
    }

    /**
     * 更新一个标签
     * @param label
     */
    public void updateLabel(Label label){
        labelRepository.save(label);
    }

    /**
     * 删除一个标签
     * @param id
     */
    public void deleteLabelById(String id){
        labelRepository.deleteById(id);
    }

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findLabelList() {
        return labelRepository.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @return
     */
    public Label findLabelById(String id) {
        return labelRepository.findById(id).get();
    }
}
