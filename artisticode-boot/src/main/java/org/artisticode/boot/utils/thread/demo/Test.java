package org.artisticode.boot.utils.thread.demo;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.artisticode.boot.utils.thread.state.ThreadStateManager;
import sun.awt.windows.ThemeReader;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZH
 * @date 2021/10/2 11:57
 * @since jdk1.8
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService delegate1 = get("delegate1");

        ExecutorService delegate2 = get("delegate2");

        new Thread(() -> {
            delegate1.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "-executor----------");

                delegate2.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "-executor----------");
                });
            });

            System.out.println(delegate1);
            System.out.println(delegate2);
        }).start();

        for (Thread thread : stateTest()) {
            System.out.println(thread.getName()+":"+thread.getState());
            System.out.println(thread.getName()+":"+ThreadStateManager.getThreadPool(thread));

            ThreadStateManager.executeOtherPool(thread,() -> {
                System.out.println("main thread submit:"+thread.getName());
            });
            Thread.sleep(1000L);
        }

        Thread.sleep(3000L);

        delegate1.shutdown();
        delegate2.shutdown();
        //预期输出结果 实际结果可能与下面不一致,以实际测试情况为准
        //delegate1-pool-1-thread-1-executor----------
        //delegate2-pool-2-thread-1-executor----------
        //java.util.concurrent.ThreadPoolExecutor@delegate1地址
        //java.util.concurrent.ThreadPoolExecutor@delegate2地址
        // for
        //delegate1-pool-1-thread-1:threadStatus
        //delegate1-pool-1-thread-1:java.util.concurrent.ThreadPoolExecutor@delegate1地址
        //main thread submit:delegate1-pool-1-thread-1

        //delegate2-pool-2-thread-1:threadStatus
        //delegate2-pool-2-thread-1:java.util.concurrent.ThreadPoolExecutor@delegate2地址
        //main thread submit:delegate2-pool-2-thread-1


    }

    public static LinkedList<Thread> stateTest() {
        return ThreadStateManager.getSoftLinkThread();
    }

    public static ExecutorService get(String name) {
        return new ThreadPoolExecutor(2,
                2,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadFactoryName(name));
    }

    public static class ThreadFactoryName implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        ThreadFactoryName(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + "-pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(group, runnable,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
