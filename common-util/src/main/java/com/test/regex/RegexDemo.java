package com.test.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式的常见操作
 * 1. 匹配
 * 2. 切割
 * 3. 替换
 * 4. 获取
 */
public class RegexDemo {

    @Test
    public void test_matchers(){
        String tel = "13888888999";
        String regex = "1[358]\\d{9}";
        boolean matches = tel.matches(regex);
        System.out.println(matches);
    }

    @Test
    public void test_split(){
        String str1 = "xiaoxi   meimei         xuxu";
        String[] strs1 = str1.split(" +");
        for (String str : strs1) {
            System.out.println("====" + str);
        }

        //组应用(拆分叠词)
        String str2 = "xiaoxiaaaameimeibbbbbbxuxu";
        String[] strs2 = str2.split("(.)\\1+"); //(.)以任意字符分组， \\1表示引用匹配的第1组的内容，  +表示至少出现1次
        for (String str : strs2) {
            System.out.println("----" + str);
        }
    }

    @Test
    public void test_replace(){
        String str1 = "xiaoxiaaaameimeibbbbbbxuxu";
        //把所有叠词过滤掉只剩1个字母
        str1 = str1.replaceAll("(.)\\1+", "$1");//第2个参数想使用第1个参数中的分组内容，可以用$引用
        System.out.println(str1);

        //将手机号的中间4个隐藏
        String str2 = "13888888999";
        str2 = str2.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str2);
    }

    /**
     * 获取
     */
    @Test
    public void test_get(){
        String str1 = "ni hao ma, wo hen hao haha!";
        //查找3个字母的单词，会截取3个字母以上的单词
        String regex = "[a-z]{3}";
        //1. 将正则封装成对象
        Pattern pattern = Pattern.compile(regex);
        //2. 通过正则对象获取匹配对象
        Matcher matcher = pattern.matcher(str1);
        //3. 使用matcher方法操作字符串
        //查找.find()
        while(matcher.find()){
            //打印匹配的子序列
            System.out.println(matcher.group());
        }

        System.out.println("=============");
        String str2 = "ni hao ma, wo hen hao haha!";
        String regex2 = "\\b[a-z]{3}\\b";       // b代表单词边界，这里只查找3个字母为边界的单词
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(str2);
        while(matcher2.find()){
            System.out.println(matcher2.group());
        }
    }
}
