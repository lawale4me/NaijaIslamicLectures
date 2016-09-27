/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ahmed
 */
public class Util {
    public static String getVideoId(String url){
    String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

    Pattern compiledPattern = Pattern.compile(pattern);
    Matcher matcher = compiledPattern.matcher(url);

    if(matcher.find()){
        return matcher.group();
    }
        return null;
    }
}
