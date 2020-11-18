package com.playboy.user.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Autofill implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //填充创建时间
        setFieldValByName("gmtCreate", new Date(), metaObject);
        //填充更新时间
        setFieldValByName("gmtModified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //修改更新时间
        setFieldValByName("gmtModified", new Date(), metaObject);

    }
}
