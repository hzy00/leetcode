package com.leetcode;

import java.util.List;

/**
 * Created by hzy on 18/5/23.
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
