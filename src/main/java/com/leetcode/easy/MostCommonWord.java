package com.leetcode.easy;

import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MostCommonWord {

    private boolean flag = true;
    private Object obj = new Object();

    @Test
    public void test() throws InterruptedException, ExecutionException {
        char b = '1' ^ '0';
        System.out.println(b);
        retry:
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.println("j"+j);
                continue retry;
            }
            System.out.println("i");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);
        queue.offer(7);
        queue.offer(6);
        queue.offer(0);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }


        System.out.println(-1 << 29);
        System.out.println(Integer.toBinaryString(-1)+" "+Integer.toBinaryString(-1 << 29));
        final AtomicInteger integer = new AtomicInteger();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("holding");
            }
        },10,TimeUnit.SECONDS);
        for(int i=0;i<10;i++){
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            },(10-i)*1,TimeUnit.SECONDS);
        }
        executorService.shutdown();

        System.out.println(executorService.isShutdown()+" "+executorService.isTerminated());
        System.out.println("shutdown");
        TimeUnit.SECONDS.sleep(15);
        System.out.println(executorService.isShutdown()+" "+executorService.isTerminated());

        System.out.println("shutdown finish");
    }

    public static int countSegments(String s) {
        if(s == null || s.length() < 1) return 0;
        int sum = 0;
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' ' && flag){
                sum++;
                flag = false;
            }else if(s.charAt(i) == ' '){
                flag = true;
            }
        }
        return flag?sum+1:sum;
    }
}