package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by hzy on 18/7/11.
 */
public class BinaryWatchSolution {
    String[] str = new String[]{"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};

    @Test
    public void test(){
        Assert.assertEquals(str.length,readBinaryWatch(2).size());
    }

    public List<String> readBinaryWatch(int num) {
        if(num<=0){
            return Arrays.asList("0:00");
        }
        Queue<BinarySet> queue = new ArrayDeque<>();
        if(num>0){
            BinarySet set = new BinarySet();
            set.str = new StringBuilder("1");
            set.sum = 1;
            queue.add(set);
        }
        if(num<10){
            BinarySet set = new BinarySet();
            set.str = new StringBuilder("0");
            set.sum = 0;
            queue.add(set);
        }
        for(int i=1;i<10;i++){
            final int size = queue.size();
            for(int j=0;j<size;j++){
                BinarySet set = queue.poll();
                int pot = potentail(set,num);
                if(pot<=0){
                    BinarySet tmp = new BinarySet();
                    tmp.str = new StringBuilder(set.str).append("0");
                    tmp.sum = set.sum;
                    queue.add(tmp);
                }
                if(pot>=0){
                    BinarySet tmp = new BinarySet();
                    tmp.str = set.str.append("1");
                    tmp.sum = set.sum+1;
                    queue.add(tmp);
                }
            }
        }
        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()){
            BinarySet set = queue.poll();
            String t = buildTime(set.str);
            if(t != null) {
                list.add(t);
            }
        }
        return list;
    }

    private int potentail(BinarySet bs,int num){
        int sum = num - bs.sum;
        int pos = 10 - bs.str.length();
        if(pos == sum){
            return 1;
        }else if(sum == 0){
            return -1;
        }else{
            return 0;
        }
    }

    private String buildTime(StringBuilder str){
        int h = Integer.parseInt(str.substring(0,4),2);
        if(h>=12){
            return null;
        }
        int m = Integer.parseInt(str.substring(4),2);
        if(m>=60){
            return null;
        }
        str = new StringBuilder().append(h).append(":");
        if(m<10){
            str.append("0");
        }
        str.append(m);
        return str.toString();
    }

    class BinarySet{
        public StringBuilder str;
        public int sum;
    }
}
