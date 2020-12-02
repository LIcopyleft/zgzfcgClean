import javolution.util.ReentrantLock;
import lombok.SneakyThrows;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/4
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        //   test();
        //    hwNum();
        //      dg(5);
        //     System.out.println(dg(100));
        //    bubbleSort();
        //   threadTest();
        reentrantLockTest();
    }


    public static void reentrantLockTest() throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (; ; ) {
                    lock.lock();
                    if (count > 0) {
                        //    Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "拿到第" + count + "张票");
                        count = count - 1;
                        lock.unlock();
                    } else {
                        break;
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.join();


        System.err.println(Thread.currentThread().getName());
        //    System.exit(0);
    }

    public static int dg(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + dg(num - 1);
        }
    }


    static int count = 100;

    public static void threadTest() {
        Thread thread = Thread.currentThread();
        //  thread.setDaemon(false);

        System.err.println(thread.getName() + "主线程开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (; ; ) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "拿到第" + count + "张票");
                    count = count - 1;
                } else {
                    break;
                }
            }
        }, "t-1").start();


        new Thread(() -> {
            for (; ; ) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "拿到第" + count + "张票");
                    count = count - 1;
                } else {
                    break;
                }
            }
        }, "t-2").start();
        new Thread(() -> {
            for (; ; ) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "拿到第" + count + "张票");
                    count = count - 1;
                } else {
                    break;
                }
            }
        }, "t-3").start();

        System.err.println("主线程结束--------------------------===========================================================================================================-");
    }

    public static void bubbleSort() {

        int[] arr = new int[]{1, 2, 3, 4, 9, 8, 10, 15, 7, 5, 6, 7, 20, 21};
// 1 3 4 2
        // 第一次  3 1 4 2
        // 第二次  4 1 3 2
        // 第三次  4 1 3 2
        //
        //   4 3 1 2
        //   4 3 1 2
        //
        //   4321
        int temp;
        int count = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int m = 0; m < arr.length - 1 - j; m++) {
                if (arr[m + 1] > arr[m]) {
                    temp = arr[m];
                    arr[m] = arr[m + 1];
                    arr[m + 1] = temp;
                }
                count++;
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count + "次");
        System.out.println("=======================");
        count = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int m = 0; m < arr.length - 1; m++) {
                if (arr[m + 1] > arr[m]) {
                    temp = arr[m];
                    arr[m] = arr[m + 1];
                    arr[m + 1] = temp;
                }
                count++;
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count + "次");
        //    return arr;


    }

    public static void hwNum() {

        System.out.println("请输入一串整数数字");
        String next = "";
        Scanner scan = null;
        while (next.length() != 32) {
            System.out.println("请输入32位数字");
            scan = new Scanner(System.in);
            if (scan.hasNextBigInteger()) {
                next = String.valueOf(scan.nextBigInteger());
                System.out.println("输入数字长度为" + next.length());
            } else {
                System.err.println("请输入数字...");
            }
        }
        char[] chars = next.toCharArray();
        int midNumIndex = chars.length / 2;
        System.out.println("中间索引(循环次数):" + midNumIndex);
        for (int i = 0; i < midNumIndex; i++) {
            if (chars[i] != chars[next.length() - 1 - i]) {
                System.out.println(next + "\t:不是回文数");
                return;
            }
        }
        scan.close();
        System.out.println(next + "\t:是回文数");

    }

    public static void test() throws UnsupportedEncodingException {
        //   getResource();
        StringUtils.reverse("10000");
        String regionCode = "123333";

        regionCode = regionCode.substring(0, 2) + "0000";
        System.out.println(regionCode);
        String a = "9999999999999999";

        String s = "0000000000000000";

        String urlId = null;
        for (int i = 1; i < 10; i++) {
            urlId = i + "";

            if (urlId.length() < 16) {
                String s1 = s.substring(0, 16 - urlId.length()) + urlId;
                //   System.out.println(s1);

                String reverse = StringUtils.reverse(s1);
                System.out.println(s1);
                System.out.println(reverse);
            }
        }


        String aa = "_";
        String aaa = "1";
        System.out.println("utf-8编码下'hello'所占的字节数:" + a.getBytes("utf-8").length);
        System.out.println("utf-8编码下'hello'所占的字节数:" + aa.getBytes("utf-8").length);
        System.out.println("utf-8编码下'hello'所占的字节数:" + aaa.getBytes("utf-8").length);
    }


}
