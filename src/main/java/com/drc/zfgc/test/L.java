package com.drc.zfgc.test;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/11
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-16 14:20
 */
public class L {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        String lock = "lock";

        // 生产者
        new Thread(() ->{
            try{
                synchronized (lock) {
                    for (int i = 0; i < 100000000; i++) {
                        System.out.println("生产者开始生产：" + i);
                        list.add("" + i);
                        if (list.size() >= 10) {
                            System.out.println("生产者停止");
                            lock.notify();
                            lock.wait();
                        }
                    }
                }
            } catch (Exception e) {
                //
            }
        }).start();

        // 消费者
        new Thread(() ->{
            try{
                synchronized (lock) {
                    while (true) {
                        if (list.size() < 10) {
                            lock.wait();
                            System.out.println("消费等待");
                            System.out.println(" ");
                        }
                        System.out.println("消费者开始消费");
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                            it.remove();
                        }
                        System.out.println("消费完了");
                        lock.notify();
                    }
                }
            } catch (Exception e) {

            }

        }).start();


        System.out.println("完成----");
    }




}
