package com.drc.zfgc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tengchao.li
 * @description 任务队列
 * @date 2020/11/11
 */
public class TaskQueen {

    private volatile BlockingQueue<List<Map<String, String>>> taskQueen = new LinkedBlockingQueue();
    //  private volatile LinkedList<Map<String,String>> taskList = new LinkedList();

    private static final Logger logger = LoggerFactory.getLogger("TaskQueen");

    public BlockingQueue<List<Map<String, String>>> getTaskQueen() {
        return taskQueen;
    }

    // 生产苹果，放入篮子
    public void produce(List<Map<String, String>> list) {
        // put方法放入一个苹果，若basket满了，等到basket有位置
        //    Connection hivCon = hivePool.getConnection();
        // hivCon.p
        logger.info("添加数据到队列...");
        try {
            taskQueen.put(list);
            logger.info("添加数据到队列完成...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 消费苹果，从篮子中取走
    public List<Map<String, String>> consume() throws InterruptedException {
        // take方法取出一个苹果，若basket为空，等到basket有苹果为止(获取并移除此队列的头部)
        return taskQueen.take();
    }

   /* public void produce(String instance) throws InterruptedException {
        synchronized (this) {

           *//* int i = integer.addAndGet(1);
            basket.put("An apple" + i);
            System.out.println(instance + "生产 An apple" + i + "完成");*//*
        }
    }*/
}
