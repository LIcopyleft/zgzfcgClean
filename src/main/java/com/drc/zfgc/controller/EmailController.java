//package com.drc.zfgc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
//
///**
// * @author tengchao.li
// * @description
// * @date 2020/9/1
// */
//@Controller
//@RequestMapping("/app")
//public class EmailController {
//    @Autowired//获取ApplicationContext对象方式有多种,这种最简单,其它的大家自行了解一下
//    private ApplicationContext applicationContext;
//
//    @RequestMapping(value = "/email/asyncCall", method = GET)
//    @ResponseBody
//    public Map<String, Object> asyncCall() {
//        Map<String, Object> resMap = new HashMap<String, Object>();
//        try {
//
//            //这样调用同类下的异步方法是不起作用的               //this.testAsyncTask();             //通过上下文获取自己的代理对象调用异步方法
//            EmailController emailController = (EmailController) applicationContext.getBean(EmailController.class);
//            emailController.testAsyncTask();
//            resMap.put("code", 200);
//        } catch (Exception e) {
//            resMap.put("code", 400);
//         //   logger.error("error!", e);
//        }
//        return resMap;
//    }
//    //注意一定是public,且是非static方法
//    @Async
//    public void testAsyncTask() throws InterruptedException {
//        Thread.sleep(10000);
//        System.out.println("异步任务执行完成！");
//    }
//}
