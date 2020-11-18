package com.playboy.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.playboy.result.JsonResult;
import com.playboy.user.entity.EduJude;
import com.playboy.user.entity.EduTeacher;
import com.playboy.user.mapper.EduTeacherMapper;
import com.playboy.user.service.EduTeacherService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        if (insert != 0) return JsonResult.ok();
        else return JsonResult.errorException("插入不成功");

    }

    /**
     * 更新用户
     *
     * @param eduTeacher
     * @return
     */
    @Override
    public JsonResult updateUser(EduTeacher eduTeacher) {
        int update = eduTeacherMapper.updateById(eduTeacher);
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
        int i = eduTeacherMapper.deleteById(id);
        if (i != 0) {
            return JsonResult.ok();
        } else {
            return JsonResult.errorMsg("删除失败");
        }
    }

    @Override
    public JsonResult queryList(int size, int current, EduJude eduJude) {
        //条件查询
        QueryWrapper<EduTeacher> qw = new QueryWrapper<>();
        String name = eduJude.getName();
        Integer level = eduJude.getLevel();
        String gmtCreate = eduJude.getGmtCreate();
        String gmtModified = eduJude.getGmtModified();
        if (!StringUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        if (level != null) {
            qw.eq("level", level);
        }
        if (gmtCreate != null) {
            qw.ge("gmt_create", gmtCreate);
        }
        if (gmtModified != null) {
            qw.le("gmt_modified", gmtModified);
        }
        //获取页数
        Page<EduTeacher> page = new Page<>(current, size);
        IPage<Map<String, Object>> mapIPage = eduTeacherMapper.selectMapsPage(page, qw);
        return JsonResult.ok(mapIPage);
    }
}
