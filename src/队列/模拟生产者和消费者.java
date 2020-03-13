package 队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName： 模拟生产者和消费者
 * @description:
 * @author: lisheng
 * @create: 2020-03-07 10:51
 **/
public class 模拟生产者和消费者 {
    BlockingQueue<Object> queue=new ArrayBlockingQueue<Object>(2);

    public void produce(){
        int num=0;
        while (true) {
            try {
                queue.put(Thread.currentThread().getName()+num);
                System.out.println("生产了一个消息:"+Thread.currentThread().getName()+num++);
                Thread.sleep(3000);
                if(num==5)return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void comsumer(){
        while (true){
            try {
                Object take = queue.take();
                System.out.println("消费了一个消息"+take.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        模拟生产者和消费者  mq=new 模拟生产者和消费者();
        new Thread(()->mq.produce()).start();
        new Thread(()->mq.comsumer()).start();

    }

}
