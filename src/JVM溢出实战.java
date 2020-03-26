import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： JVM
 * @description:
 * @author: lisheng
 * @create: 2020-03-26 15:13
 **/
public class JVM溢出实战 {
    public static void main(String[] args) {
//        //堆溢出  --Xms1m
////        List<JVM溢出实战> list=new ArrayList<>();
////        for (;;)list.add(new JVM溢出实战());
//        //栈溢出  栈帧超出长度限制  定义大量局部变量
//        main(args);
//        //元数据溢出(本地方法区) MetaSpace  -XX:MaxMetaSpace10m  1.7以前可以通过string::intern()实现永久代溢出
//        List<Class> list2=new ArrayList<>();
//        for(;;){
//            Enhancer enhancer=new Enhancer();
//            enhancer.setSuperclass(JVM溢出实战.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,args));
//            enhancer.create();
//        }
//        //本地直接内存溢出 -XX:MaxDirectMemorySize1m
//        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            Unsafe o = (Unsafe) theUnsafe.get(null);
//            for(;;)o.allocateMemory(1021 * 1024 * 1024);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
