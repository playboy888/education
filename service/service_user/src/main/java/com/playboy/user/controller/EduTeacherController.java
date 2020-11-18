package com.playboy.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduJude;
import com.playboy.user.entity.EduTeacher;
import com.playboy.user.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
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
    @RequestMapping(value = "/findAll", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    private JsonResult findAll() {
        return eduTeacherServiceImpl.findAll();
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/findById", produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult findById(String id) {
        return eduTeacherServiceImpl.findById(id);
    }

    /**
     * 添加用户
     *
     * @param eduTeacher 用户信息
     * @return
     */
    @RequestMapping(value = "/insertUser", produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult insertUser(EduTeacher eduTeacher) {
        return eduTeacherServiceImpl.insertUser(eduTeacher);
    }

    /**
     * 分页条件查询
     * @param size
     * @param current
     * @return
     */
    @RequestMapping(value = "/queryList", produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult queryList(int size, int current,@RequestBody(required = false) EduJude eduJude) {
        return eduTeacherServiceImpl.queryList(size, current,eduJude);
    }

    /**
     * 更新用户
     *
     * @param eduTeacher
     * @return
     */
    @RequestMapping(value = "/updateUser", produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult updateUser(EduTeacher eduTeacher) {
        return eduTeacherServiceImpl.updateUser(eduTeacher);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findAll", produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult deleteUser(String id) {
        return eduTeacherServiceImpl.deleteUser(id);
    }
}

