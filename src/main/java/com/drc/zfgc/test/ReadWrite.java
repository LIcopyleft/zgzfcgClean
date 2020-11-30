package com.drc.zfgc.test;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/11
 */
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReadWrite
 * @Descriiption 读写锁
 * @Author yanjiantao
 * @Date 2019/8/21 10:42
 **/
public class ReadWrite {

    /**
     * 共享数据
     */
    private int data = 0;

    /**
     * 读写锁
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {

        // 上读锁
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "----->读锁开始执行...");
            Thread.sleep((long)(Math.random() * 10));
            System.out.println(Thread.currentThread().getName() + "----->读锁得到数据data=" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.readLock().unlock();
        }
    }

    public void set() {

        // 上写锁
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "----->写锁开始执行...");
            Thread.sleep((long)(Math.random() * 10));
            data++;
            System.out.println(Thread.currentThread().getName() + "----->写锁得到数据data=" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放写锁
            lock.writeLock().unlock();
        }

    }
}

/**
 * 测试类
 */
class Main{

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        // 创建100个读写线程
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                readWrite.get();
            }).start();

            new Thread(() -> {
                readWrite.set();
            }).start();
        }
    }

}

