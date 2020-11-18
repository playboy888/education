package com.playboy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduTeacher;
import com.playboy.user.mapper.EduTeacherMapper;
import com.playboy.user.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-17
 */
@Service()
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Autowired
    EduTeacherMapper eduTeacherMapper;

    /**
     * 查询所有
     *
     * @return
     */
    public JsonResult findAll() {
        List<EduTeacher> eduTeachers = eduTeacherMapper.selectList(null);
        return JsonResult.ok(eduTeachers);
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户ID
     * @return
     */
    @Override
    public JsonResult findById(String id) {
        EduTeacher eduTeacher = eduTeacherMapper.selectById(id);
        return JsonResult.ok(eduTeacher);
    }

    /**
     * 添加用户
     *
     * @param eduTeacher 用户信息
     * @return
     */
    @Override
    public JsonResult insertUser(EduTeacher eduTeacher) {
        int insert = eduTeacherMapper.insert(eduTeacher);
        if(insert!=0) return JsonResult.ok();
        else return  JsonResult.errorException("插入不成功");

    }

    /**
     * 更新用户
     *
     * @param eduTeacher
     * @return
     */
    @Override
    public JsonResult updateUser(EduTeacher eduTeacher) {
        int update = eduTeacherMapper.update(eduTeacher, null);
        return JsonResult.ok();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult deleteUser(String id) {
        return JsonResult.ok();
    }
}
