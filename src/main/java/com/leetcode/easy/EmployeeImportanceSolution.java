package com.leetcode.easy;

import com.leetcode.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by hzy on 18/5/23.
 */
public class EmployeeImportanceSolution {

    @Test
    public void test(){
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 5;
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(2);
        sub.add(3);
        employee.subordinates = sub;
        employees.add(employee);
        employee = new Employee();
        employee.id = 2;
        employee.importance = 3;
        employees.add(employee);
        employee = new Employee();
        employee.id = 3;
        employee.importance = 3;
        employees.add(employee);
        Assert.assertEquals(11,getImportance(employees,1));
    }

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.isEmpty()){
            return 0;
        }
        int sum = 0;
        Map<Integer,Employee> cacheMap = new HashMap<Integer,Employee>();
        for(Employee employee:employees){
            cacheMap.put(employee.id,employee);
        }
        if(cacheMap.containsKey(id)){
            Queue<Employee> queue = new ArrayDeque<Employee>();
            queue.add(cacheMap.get(id));
            while(!queue.isEmpty()){
                Employee employee = queue.poll();
                sum+=employee.importance;
                if(employee.subordinates != null) {
                    for (Integer i : employee.subordinates) {
                        queue.add(cacheMap.get(i));
                    }
                }
            }
        }
        return sum;
    }
}
