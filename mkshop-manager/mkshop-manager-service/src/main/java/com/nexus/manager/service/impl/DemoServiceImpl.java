package com.nexus.manager.service.impl;

import com.nexus.manager.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName DemoServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-11 19:11
 * @Version 1.0
 **/
@Service("demoService")
@Transactional
@Slf4j
public class DemoServiceImpl implements DemoService {


    @Override
    public String hello(String words) {
        return words+" lmk";
    }
}
