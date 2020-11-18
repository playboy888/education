package com.playboy.user.service;

import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-17
 */

public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * 查询所有
     * @return
     */
    JsonResult findAll();

    /**
     * 根据id查询用户
     * @param id 用户ID
     * @return
     */
    JsonResult findById(String id);

    /**
     * 添加用户
     * @param eduTeacher 用户信息
     * @return
     */
    JsonResult insertUser(EduTeacher eduTeacher);

    /**
     * 更新用户
     * @param eduTeacher
     * @return
     */
    JsonResult updateUser(EduTeacher eduTeacher);

    /**
     * 删除用户
     * @param id
     * @return
     */
    JsonResult deleteUser(String id);
}
