package com.vivk.study.stringutils;

import org.springframework.util.StringUtils;

public class StringUtilsTest {

    public static void main(String[] args) {
        String str=" abcd an";
        System.out.println(StringUtils.trimAllWhitespace(str));

        System.out.println(StringUtils.isEmpty(null));//true
        System.out.println(StringUtils.isEmpty(""));//true
        System.out.println(StringUtils.isEmpty(" "));//false





    }

}
