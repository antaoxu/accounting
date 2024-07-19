package com.xat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 淡漠
 */
public class MyTest {
    public static void main(String[] args) {
        String jsonString = "{\"certNo\":\"987654321\",\"enterNo\":\"99999\"}";

        // 解析传入的 JSON 字符串
        JSONObject inputData = JSON.parseObject(jsonString);

        // 给定的 JSON 数组
        String jsonArrayString = "[{\"chineseName\":\"中国\",\"englishName\":\"hhh\",\"value\":\"1234\"}," +
                "{\"chineseName\":\"中国\",\"englishName\":\"certNo\",\"value\":\"987654321\"}," +
                "{\"chineseName\":\"中国\",\"englishName\":\"enterNo\",\"value\":\"99999\"}]";

        // 解析 JSON 数组
        JSONArray jsonArray = JSON.parseArray(jsonArrayString);

        // 遍历数组，查找匹配的数据
        boolean matchFound = false;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            boolean match = true;
            for (String key : inputData.keySet()) {
                if (!(obj.containsKey("englishName") && obj.getString("englishName").equals(key) &&
                        obj.containsKey("value") && obj.getString("value").equals(inputData.getString(key)))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                matchFound = true;
                System.out.println("Match found:");
                System.out.println(obj);
                break; // 只要找到一个匹配就跳出循环
            }
        }

        if (!matchFound) {
            System.out.println("No match found");
        }
    }
}
