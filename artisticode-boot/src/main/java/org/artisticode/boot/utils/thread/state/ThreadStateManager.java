package org.artisticode.boot.utils.thread.state;

import org.artisticode.boot.utils.validate.Assert;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ZH impossible911@163.com
 * @date 2021/10/2 12:34
 * @since jdk1.8
 */
public abstract class ThreadStateManager {

    /**
     * 获取当前线程状态
     * @return 线程状态
     */
    public static Thread.State getCurrentThreadState() {
        return Thread.currentThread().getState();
    }

    /**
     *
     * @param thread 指定线程
     * @return 线程状态
     */
    public static Thread.State getThreadState(Thread thread) {
        Assert.notNull(thread, "### ThreadStateManager#setInterrupt thread must not be null");
        return thread.getState();
    }

    /**
     *  获取当前线程所在的线程池
     * @return ExecutorService
     */
    public static ExecutorService getCurrentThreadPool() {
        return null;
    }

    /**
     * 指定的线程也可能没有线程池,或线程池已被销毁
     * @param thread 指定线程
     * @return 返回线程所在的线程池
     */
    public static ExecutorService getThreadPool(Thread thread) {
        return null;
    }

    /**
     * 判断线程执行的任务是否和自己是同一业务线(即线程执行的内容是否是当前线程提交的)
     * @param thread 多个线程
     * @return bool
     */
    public static boolean check(Thread... thread) {
        return true;
    }

    /**
     * 获取软链接的所有线程
     * @return LinkedList
     */
    public static LinkedList<Thread> getSoftLinkThread() {
        return null;
    }

    /**
     * 将某个线程中断
     * @param thread 操作的线程
     */
    public static void setInterrupt(Thread thread) {
        Assert.notNull(thread, "### ThreadStateManager#setInterrupt thread must not be null");
        thread.interrupt();
    }

    /**
     * 将任务提交给指定线程所在线程池的任意线程执行
     * @param thread 指定线程
     * @param runnable 任务
     */
    public static void executeOtherPool(Thread thread, Runnable runnable) {
        Optional.ofNullable(getThreadPool(thread)).orElse(getDefaultPool()).execute(runnable);
    }

    /**
     * 将任务提交给指定线程所在线程池的任意线程执行
     * @param thread 指定线程
     * @param runnable 任务
     * @return Future
     */
    public static Future<?> submitOtherPool(Thread thread, Runnable runnable) {
        return Optional.ofNullable(getThreadPool(thread)).orElse(getDefaultPool()).submit(runnable);
    }

    /**
     * 获取默认线程池
     * @return ExecutorService
     */
    public static ExecutorService getDefaultPool() {
        return Executors.newCachedThreadPool();
    }
}
