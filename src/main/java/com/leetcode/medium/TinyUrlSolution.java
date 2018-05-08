package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 75623 on 2018/5/8.
 * 主要是尽量保证短链的唯一性，碰撞也是有可能的
 */
public class TinyUrlSolution {

    Map<String,String> urlMap = new HashMap<String, String>();
    private String host = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(longUrl.hashCode());
        urlMap.put(key,longUrl);
        return host+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(host,"");
        return urlMap.get(key);
    }
}
