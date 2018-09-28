package com.belazy.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {

 static String testStr = "PER 20 COUPON CHARGE GBP 30.00.";

 public static void main(String[] args) {
  // PER COUPON CHARGE GBP 30.00.
  String str = "(^|\\s+|[^a-zA-Z0-9]+)";
  String str2 = "([^a-zA-Z0-9]+|\\s+|$)";
  Pattern p = Pattern.compile(str + "([a-zA-Z]{3})" + str2);
  Matcher m = p.matcher(testStr);
  List<String> allMatches = new ArrayList<String>();

  Pattern p1 = Pattern.compile("[a-zA-Z]{3}");
  while (m.find()) {
   // allMatches.add(m.group());
   Matcher m1 = p1.matcher(m.group());
   while (m1.find()) {
    allMatches.add(m1.group());
   }
  }
  System.out.println(allMatches);

  // PER COUPON CHARGE GBP 30.00.
  Pattern p3 = Pattern.compile("(\\d+(?:[.]\\d+)?)");
  Matcher m3 = p3.matcher(testStr);
  List<String> allMatches3 = new ArrayList<String>();

  // Pattern p4 = Pattern.compile("\\d?");
  while (m3.find()) {
   allMatches3.add(m3.group());
   // Matcher m4 = p4.matcher(m3.group());
   // while (m4.find())
   // allMatches.add(m4.group());
  }
  System.out.println(allMatches3);
 }

 private static boolean getcurrency(String currency) {
  List<String> currencyList = new ArrayList<String>();
  currencyList.add("AED");
  currencyList.add("USD");
  currencyList.add("INR");
  currencyList.add("GBP");
  currencyList.add("EUR");
  currencyList.add("MUR");

  // List<String> currencies =

  if (currencyList.contains(currency))
   return true;
  return false;
 }

}