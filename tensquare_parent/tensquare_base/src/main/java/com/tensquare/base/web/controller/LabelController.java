package com.tensquare.base.web.controller;

import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签管理的表现层
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/label")
@CrossOrigin//允许跨域请求
public class LabelController {
    //注入Service
    @Autowired
    private LabelService labelService;

    /**
     * 添加一个标签
     * @param label
     * @return
     */
//    @PostMapping("/label")
    @PostMapping
//    @ResponseBody
    public ResultDTO add(@RequestBody Label label){
        //调用service
        labelService.saveLabel(label);
        //返回结果
        return new ResultDTO(true, StatusCode.OK,"添加成功");
    }

    /**
     * 修改一个
     * @param label
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResultDTO edit(@RequestBody Label label,@PathVariable String id){
        //设置id
        label.setId(id);
        //调用service
        labelService.updateLabel(label);
        //返回结果
        return new ResultDTO(true, StatusCode.OK,"修改成功");
    }

    /**
     * 删除一个
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultDTO remove(@PathVariable String id){
        //调用service
        labelService.deleteLabelById(id);
        //返回结果
        return new ResultDTO(true, StatusCode.OK,"删除成功");
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public ResultDTO list(){
        //制造异常
        int d =1/0;
        //调用service
//        List<Label> list = labelService.findLabelList();
        //返回结果
//        return new ResultDTO(true, StatusCode.OK,"查询成功",list);
        return new ResultDTO(true, StatusCode.OK,"查询成功"
                ,labelService.findLabelList());
    }


    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultDTO listById(@PathVariable String id){
        //调用service
//        Label label = labelService.findLabelById(id);
        //返回结果
//        return new ResultDTO(true, StatusCode.OK,"删除成功",label);
        return new ResultDTO(true, StatusCode.OK,"查询成功",labelService.findLabelById(id));
    }

}
