package com.aires.springbootredis.controller;

/**
 * Created by 10183966 on 2017/2/16.
 */
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringRedisController {

    protected static Logger logger=LoggerFactory.getLogger(StringRedisController.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @RequestMapping("set")
    public String setKeyAndValue(String key,String value){
        logger.debug("Interview set:key={},value={}",key,value);
        valOpsStr.set(key, value);
        return "Set Ok";
    }

    @RequestMapping("get")
    public String getKey(String key){
        logger.debug("Interview get:key={}",key);
        return valOpsStr.get(key);
    }
}
