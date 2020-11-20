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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wxt
 * @version 1.0
 * @date 2020/11/18 11:58
 */
@Service()
@Slf4j
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Autowired
    EduTeacherMapper eduTeacherMapper;
    @Value("${baseUrl}")
    String baseUrl;

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
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("a", 12);
        return JsonResult.ok(i);
    }

    @Override
    public JsonResult queryList(EduJude eduJude) throws ParseException {
        //条件查询
        QueryWrapper<EduTeacher> qw = new QueryWrapper<>();
        int size = eduJude.getSize();
        int current = eduJude.getCurrent();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        if (eduJude != null) {
            String name = eduJude.getName();
            Integer level = eduJude.getLevel();
            String gmtCreate = eduJude.getGmtCreate();
            String gmtModified = eduJude.getGmtModified();
            if (StringUtils.isNotEmpty(name)) {
                qw.like("name", name);
            }
            if (level != null) {
                qw.eq("level", level);
            }
            if (StringUtils.isNotEmpty(gmtCreate)) {
                Date gmtCreate1 = dateFormat.parse(gmtCreate);
                qw.ge("gmt_create", gmtCreate1);

            }
            if (StringUtils.isNotEmpty(gmtModified)) {
                Date gmtModified2 = dateFormat.parse(gmtModified);
                qw.le("gmt_modified", gmtModified2);
            }
        }

        //获取页数
        Page<EduTeacher> page = new Page<>(current, size);
        IPage<Map<String, Object>> mapIPage = eduTeacherMapper.selectMapsPage(page, qw);
        return JsonResult.ok(mapIPage);
    }

    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) {    // 无后缀
            return null;
        } else {                    // 存在后缀
            return fileName.substring(suffixIndex, fileName.length());
        }
    }

    /**
     * 文件上传
     *
     * @param zipFile
     * @return
     */
    @Override
    public JsonResult uploadFileTest(MultipartFile zipFile) throws IOException {
        System.out.println(baseUrl);
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        String encode = encoder.encode(zipFile.getBytes());
        return JsonResult.ok(encode);

//        String targetFilePath = "D:\\test\\uploadTest";
//        String fileName = UUID.randomUUID().toString().replace("-", "");
//
//        String fileSuffix = getFileSuffix(zipFile);
//
//        if (fileSuffix != null) {   // 拼接后缀
//            fileName += fileSuffix;
//        }
//        File targetFile = new File(targetFilePath + File.separator + fileName);
//
//
////        File targetFile = new File(targetFilePath + File.separator + fileName);
//        String path = targetFile.getPath();
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(targetFile);
//            IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
//            log.info("------>>>>>>uploaded a file successfully!<<<<<<------");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return JsonResult.errorException("上传文件不正确");
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                log.error("", e);
//            }
//        }
//        return JsonResult.ok(path);
    }
}
