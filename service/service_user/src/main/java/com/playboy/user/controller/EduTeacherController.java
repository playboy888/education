package com.playboy.user.controller;


import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduTeacher;
import com.playboy.user.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/user")
@Api(tags = "接口所在的类")
@ApiModel("edu数据库表相关操作")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherServiceImpl;

    /**
     * 查询所有
     */
    @ApiOperation("查询所有")
    @RequestMapping("/findAll")
    private JsonResult findAll() {
        return eduTeacherServiceImpl.findAll();
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/findById")
    public JsonResult findById(String id) {
        return eduTeacherServiceImpl.findById(id);
    }

//    /**
//     * 添加用户
//     *
//     * @param eduTeacher 用户信息
//     * @return
//     */
//    @RequestMapping("/insertUser")
//    public JsonResult insertUser(EduTeacher eduTeacher) {
//        return eduTeacherServiceImpl.insertUser(eduTeacher);
//    }
//
//    /**
//     * 更新用户
//     *
//     * @param eduTeacher
//     * @return
//     */
//    @RequestMapping("/updateUser")
//    public JsonResult updateUser(EduTeacher eduTeacher) {
//        return eduTeacherServiceImpl.updateUser(eduTeacher);
//    }
//
//    /**
//     * 删除用户
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping("/deleteUser")
//    public JsonResult deleteUser(String id) {
//        return eduTeacherServiceImpl.deleteUser(id);
//    }
}

