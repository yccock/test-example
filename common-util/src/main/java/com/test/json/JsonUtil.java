package com.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

/**
 * json性能： jackson > gson > fastjson
 */
public class JsonUtil {

    //gson
    private JsonParser googleJsonParse = new JsonParser();

    //jackson
    private JsonFactory jsonFactory = new JsonFactory();

    public String[] fastJsonParse(String str){
        String[] result = new String[3];
        StringBuilder orderSb = new StringBuilder();
        StringBuilder skuSb = new StringBuilder();
        JSONObject root = JSON.parseObject(str);
        JSONArray orderList = root.getJSONArray("orderList");
        if (orderList != null && orderList.size() > 0){
            for (Object object : orderList){
                final JSONObject obj = (JSONObject) object;
                final String orderId = obj.getString("orderId");
                orderSb.append(orderId).append(",");
                JSONArray orderItems = obj.getJSONArray("orderItems");
                if (orderItems != null && orderItems.size() > 0){
                    for (Object object2 : orderItems){
                        final JSONObject obj2 = (JSONObject) object2;
                        final String skuId = obj2.getString("skuId");
                        skuSb.append(skuId).append(",");
                    }
                }
            }
        }
        String orderIds = orderSb.toString();
        if (orderIds.length() > 0){
            result[0] = orderIds.substring(0, orderIds.length() - 1);
        }
        String skuIds = skuSb.toString();
        if (skuIds.length() > 0){
            result[1] = skuIds.substring(0, skuIds.length() - 1);
        }
        return result;
    }

    public String[] gsonParse(String str){
        String[] result = new String[3];
        StringBuilder orderSb = new StringBuilder();
        StringBuilder skuSb = new StringBuilder();
        JsonObject root = googleJsonParse.parse(str).getAsJsonObject();
        JsonArray orderList = root.getAsJsonArray("orderList");
        if (orderList != null && orderList.size() > 0){
            for (JsonElement order : orderList){
                JsonObject jsonObject = order.getAsJsonObject();
                final String orderId = jsonObject.get("orderId").getAsString();
                orderSb.append(orderId).append(",");
                final JsonArray orderItems = jsonObject.getAsJsonArray("orderItems");
                for (JsonElement orderItem : orderItems) {
                    String skuId = orderItem.getAsJsonObject().get("skuId").getAsString();
                    skuSb.append(skuId).append(",");
                }
            }
        }
        String orderIds = orderSb.toString();
        if (orderIds.length() > 0){
            result[0] = orderIds.substring(0, orderIds.length() - 1);
        }
        String skuIds = skuSb.toString();
        if (skuIds.length() > 0){
            result[1] = skuIds.substring(0, skuIds.length() - 1);
        }
        return result;
    }

    public String[] jacksonParse(String str) throws IOException {
        String[] result = new String[3];
        StringBuilder orderSb = new StringBuilder();
        StringBuilder skuSb = new StringBuilder();

        final com.fasterxml.jackson.core.JsonParser jsonParser = jsonFactory.createParser(str);
        while (!jsonParser.isClosed()){
            JsonToken jsonToken = jsonParser.nextToken();
            //如果当前指针指在对象的键处，获取键的值
            if (JsonToken.FIELD_NAME.equals(jsonToken)){
                String currentName = jsonParser.currentName();
                //将指针移动到该键的值处
                jsonToken = jsonParser.nextToken();
                if (currentName.equals("orderId")) {
                    orderSb.append(jsonParser.getValueAsString()).append(",");
                }
                if (currentName.equals("skuId")) {
                    skuSb.append(jsonParser.getValueAsString()).append(",");
                }
            }
        }

        jsonParser.close();
        String orderIds = orderSb.toString();
        if (orderIds.length() > 0){
            result[0] = orderIds.substring(0, orderIds.length() - 1);
        }
        String skuIds = skuSb.toString();
        if (skuIds.length() > 0){
            result[1] = skuIds.substring(0, skuIds.length() - 1);
        }
        return result;
    }
}
