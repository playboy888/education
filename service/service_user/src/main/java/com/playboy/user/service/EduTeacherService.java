package com.playboy.user.service;

import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduJude;
import com.playboy.user.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
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

    /**
     * 分页查询
     *
     * @return
     */
    JsonResult queryList(EduJude eduJude) throws ParseException;

    /**
     * 文件上传
     * @param zipFile
     * @return
     */
    public JsonResult uploadFileTest(MultipartFile zipFile) throws IOException;
}
