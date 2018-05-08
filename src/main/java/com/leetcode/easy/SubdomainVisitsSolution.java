package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 75623 on 2018/5/8.
 */
public class SubdomainVisitsSolution {

    @Test
    public void test(){
        Assert.assertEquals(3,subdomainVisits(new String[]{"90 test.leetcode.com"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null
                || cpdomains.length <= 0) {
            return null;
        }

        Map<String, Integer> visitTimesMap = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            String domain = cpdomain.split("\\s")[1];
            Integer times = Integer.valueOf(cpdomain.split("\\s")[0]);
            putDomainTimes(visitTimesMap, domain, times);
            while (domain.contains(".")) {
                domain = domain.substring(domain.indexOf(".") + 1);
                putDomainTimes(visitTimesMap, domain, times);
            }
        }
        List<String> visitList = new ArrayList<String>();
        for (String key:visitTimesMap.keySet()){
            visitList.add(String.valueOf(visitTimesMap.get(key))+" "+key);
        }
        return visitList;
    }

    private void putDomainTimes(Map<String, Integer> visitTimesMap, String domain, Integer times) {
        if (visitTimesMap.containsKey(domain)) {
            visitTimesMap.put(domain, visitTimesMap.get(domain) + times);
        } else {
            visitTimesMap.put(domain, times);
        }
    }
}
