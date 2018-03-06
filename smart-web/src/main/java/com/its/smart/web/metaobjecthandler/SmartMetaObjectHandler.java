package com.its.smart.web.metaobjecthandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import lombok.extern.java.Log;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 注入公共字段自动填充,任选注入方式即可
 * @author mq
 */
@Log
public class SmartMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新增的时候干点不可描述的事情");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新的时候干点不可描述的事情");
    }
}

