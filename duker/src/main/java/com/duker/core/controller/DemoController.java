package com.duker.core.controller;

import com.duker.core.annotation.Security;
import com.duker.core.idgenerator.GuuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiebq
 * @create 2019/9/12 0012
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class DemoController {

    @Resource
    private GuuidUtil guuid;

//    @Autowired
//    private IdService idService;
//
//    @RequestMapping(value = "/create")
//    public void createId(){
//        long genId = idService.genId();
//        log.info("*************** 生成ID ******************");
//        log.info("result={}",genId);
//        log.info("*************** 生成ID ******************");
//    }

    @RequestMapping(value = "/annotation")
    @Security(value = true)
    public void testAnnotation(){
        log.info("*************** 测试自定义注解 ******************");
    }

    @RequestMapping(value = "/getCuInfo")
    public void testUri(HttpServletRequest request, HttpServletResponse response){
        String requestURI = request.getRequestURI();
        System.out.println("URI:" + requestURI);
        System.out.println("NONCESTR:" + request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1));
    }


    @RequestMapping(value = "/createid")
    public void createid(HttpServletRequest request, HttpServletResponse response){
        System.out.println(guuid.getUUID());
    }

}
