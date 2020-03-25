package 多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName： 按序打印
 * @description:
 * @author: lisheng
 * @create: 2020-03-24 16:31
 **/
public class 按序打印 {
//    volatile int i=0;
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        i+=1;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        while (i==0);
//        printSecond.run();
//        i+=1;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        while (i<2);
//        printThird.run();
//    }
    CountDownLatch first=new CountDownLatch(1);
    CountDownLatch two=new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    first.countDown();
   }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        first.await();
        printSecond.run();
        two.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        two.await();
        printThird.run();
    }
}
