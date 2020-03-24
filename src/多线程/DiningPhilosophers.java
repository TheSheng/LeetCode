package 多线程;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName： 哲学家进餐
 * @description:
 * @author: lisheng
 * @create: 2020-03-24 09:55
 **/
public class DiningPhilosophers {
//
//    ReentrantLock[]  list={new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock()};
//    Semaphore semaphore=new Semaphore(4);
//    public DiningPhilosophers(){
//
//    }
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//        semaphore.acquire();
//        ReentrantLock thisDP = list[philosopher];
//        ReentrantLock nextDP = list[(philosopher+1)%5];
//        thisDP.lock();
//        nextDP.lock();
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putLeftFork.run();
//        putRightFork.run();
//        thisDP.unlock();
//        nextDP.unlock();
//        semaphore.release();
//    }
//    private volatile  boolean[] flag=new boolean[5];
//    private Semaphore semaphore=new Semaphore(4);
//    public DiningPhilosophers() {
//
//    }
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//        semaphore.acquire();
//        int leftIndex=philosopher;
//        int rightIndex=(philosopher+1)%5;
//        while (flag[leftIndex])Thread.sleep(1);
//        flag[leftIndex]=true;//相当于拿到左面的锁
//        while (flag[rightIndex])Thread.sleep(1);
//        flag[rightIndex]=true;
//        pickRightFork.run();
//        pickLeftFork.run();
//        eat.run();
//        putLeftFork.run();
//        putRightFork.run();
//        flag[leftIndex]=false;
//        flag[rightIndex]=false;
//        semaphore.release();
//    }
    public volatile int flag=0;
    public Semaphore semaphore=new Semaphore(4);
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
          semaphore.acquire();
          int rightIndex=1<<philosopher;
          int leftIndex=1<<((philosopher+1)%5);
          while ((flag&rightIndex)!=0)Thread.sleep(1);
          flag^=rightIndex;
          while ((flag&leftIndex)!=0)Thread.sleep(1);
          flag^=leftIndex;
          pickLeftFork.run();
          pickRightFork.run();
          eat.run();
          putLeftFork.run();
          putRightFork.run();
          flag^=rightIndex;
          flag^=leftIndex;
          semaphore.release();
    }

}
