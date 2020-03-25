package 多线程;

import sun.misc.Unsafe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @ClassName： 交替打印字符串
 * @description:
 * @author: lisheng
 * @create: 2020-03-24 16:49
 **/
public class 交替打印字符串 {
    private int n;

    public 交替打印字符串(int n) {
        this.n = n;

    }
//    AtomicInteger flag=new AtomicInteger(1);
//    // printFizz.run() outputs "fizz".
//    public void fizz(Runnable printFizz) throws InterruptedException {
//        while (flag.get()<=n){
//            int i = flag.get();
//            if(i>n){
//                break;
//            }
//            if(i%3==0&&i%5!=0){
//                printFizz.run();
//                flag.incrementAndGet();
//            }
//        }
//    }
//    // printBuzz.run() outputs "buzz".
//    public void buzz(Runnable printBuzz) throws InterruptedException {
//        while (flag.get()<=n){
//            int i = flag.get();
//            if(i>n){
//                break;
//            }
//            if(i%3!=0&&i%5==0){
//                printBuzz.run();
//                flag.incrementAndGet();
//            }
//        }
//    }
//    // printFizzBuzz.run() outputs "fizzbuzz".
//    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        while (flag.get()<=n){
//            int i = flag.get();
//            if(i>n){
//                break;
//            }
//            if(i%3==0&&i%5==0){
//                printFizzBuzz.run();
//                flag.incrementAndGet();
//            }
//        }
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void number(IntConsumer printNumber) throws InterruptedException {
//        while (flag.get()<=n){
//            int i = flag.get();
//            if(i>n){
//                break;
//            }
//            if(i%3!=0&&i%5!=0){
//                printNumber.accept(i);
//                flag.incrementAndGet();
//            }
//        }
//    }

    // printFizz.run() outputs "fizz".
    volatile int i=1;
    Semaphore semaphore=new Semaphore(1,true);
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;){
            semaphore.acquire();
            if(i>n){
                semaphore.release();
                return;
            }
            if(i%3==0&&i%5!=0){
                printFizz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;){
            semaphore.acquire();
            if(i>n){
                semaphore.release();
                return;
            }
            if(i%3!=0&&i%5==0){
                printBuzz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;){
            semaphore.acquire();
            if(i>n){
                semaphore.release();
                return;
            }
            if(i%3==0&&i%5==0){
                printFizzBuzz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;){
            semaphore.acquire();
            if(i>n){
                semaphore.release();
                return;
            }
            if(i%3!=0&&i%5!=0){
                printNumber.accept(i);
                i++;
            }
            semaphore.release();
        }
    }
}
