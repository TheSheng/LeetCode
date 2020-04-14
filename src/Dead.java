/**
 * @ClassName： Dead
 * @description: 对象什么时候死亡
 * @author: lisheng
 * @create: 2020-03-26 16:57
 **/
public class Dead {
    public static  Dead dead=null;
    public  void alive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("我要自救");
        Dead.dead=this;
    }
    //根节点枚举时  Oopmp 添加引用  在安全点和安全区域添加引用地址   如何让所有线程在垃圾收集时跑到安全点  抢先式中断和主动式中断  安全区域是让某些sleep之类的线程确保在gcroot时在区域
    //防止跨代引用 引入了记忆表与卡表  卡页的地址2^9  并发修改卡页的时候加入写屏障  解决伪共享问题 加入标志 如果标志为0 标志更新为1 再去加入写屏障
    //并发可达性分析时 可能出现对象消失  两个必要条件：在黑节点和白节点之间添加引用  删除灰节点到白节点的引用  措施 增量更新破坏第一个条件插入完重新扫描这个黑节点  原始快照  记录删除引用的灰色节点 并发扫描结束后 在重新扫描这个灰色节点
    public static void main(String[] args) throws InterruptedException {
//        dead=new Dead();
//        dead=null;
//        System.gc();
//        Thread.sleep(500);
//        String a=new String("a")+new String("b");
//        String b=a.intern();
//        System.out.println(a==b);
//
//        if(dead!=null) System.out.println("我还活着");
//        else System.out.println("我已经死了");
        int i='c';
        System.out.println(i);


    }
}
