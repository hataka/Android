//package com.example.mynavi.regex;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Regex {
  public static void main(String[] args) {
    String msg = "お問い合わせは、 sample@examples.com 、" + 
      "または、examples@mcn.ne.jpまで";
    Pattern p = Pattern.compile(
      "[\w\.\-]+@([\w\-]+\.)+[\w\-]+", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(msg);
    while (m.find()) {
      System.out.println("マッチング位置：" + m.start());
      System.out.println("マッチング終了位置：" + m.end());
      System.out.println("マッチング文字列：" + m.group());
      System.out.println("------------------------------");
    }
  }
}
