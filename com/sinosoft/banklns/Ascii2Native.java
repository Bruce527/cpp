/*    */ package com.sinosoft.banklns;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class Ascii2Native
/*    */ {
/* 11 */   private static String PREFIX = "\\u";
/*    */ 
/*    */   public static String native2Ascii(String str)
/*    */   {
/* 15 */     char[] chars = str.toCharArray();
/* 16 */     StringBuffer sb = new StringBuffer();
/* 17 */     for (int i = 0; i < chars.length; i++) {
/* 18 */       sb.append(char2Ascii(chars[i]));
/*    */     }
/* 20 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   private static String char2Ascii(char c)
/*    */   {
/* 25 */     if (c > '\u00FF') {
/* 26 */       StringBuffer sb = new StringBuffer();
/* 27 */       sb.append(PREFIX);
/* 28 */       int code = c >> '\b';
/* 29 */       String tmp = Integer.toHexString(code);
/* 30 */       if (tmp.length() == 1) {
/* 31 */         sb.append("0");
/*    */       }
/* 33 */       sb.append(tmp);
/* 34 */       code = c & 0xFF;
/* 35 */       tmp = Integer.toHexString(code);
/* 36 */       if (tmp.length() == 1) {
/* 37 */         sb.append("0");
/*    */       }
/* 39 */       sb.append(tmp);
/* 40 */       return sb.toString();
/*    */     }
/* 42 */     return Character.toString(c);
/*    */   }
/*    */ 
/*    */   public static String ascii2Native(String str)
/*    */   {
/* 48 */     StringBuffer sb = new StringBuffer();
/* 49 */     int begin = 0;
/* 50 */     int index = str.indexOf(PREFIX);
/* 51 */     while (index != -1) {
/* 52 */       sb.append(str.substring(begin, index));
/* 53 */       sb.append(ascii2Char(str.substring(index, index + 6)));
/* 54 */       begin = index + 6;
/* 55 */       index = str.indexOf(PREFIX, begin);
/*    */     }
/* 57 */     sb.append(str.substring(begin));
/* 58 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   private static char ascii2Char(String str)
/*    */   {
/* 63 */     if (str.length() != 6) {
/* 64 */       throw new IllegalArgumentException(
/* 65 */         "Ascii string of a native character must be 6 character.");
/*    */     }
/* 67 */     if (!PREFIX.equals(str.substring(0, 2))) {
/* 68 */       throw new IllegalArgumentException(
/* 69 */         "Ascii string of a native character must start with \"\\u\".");
/*    */     }
/* 71 */     String tmp = str.substring(2, 4);
/* 72 */     int code = Integer.parseInt(tmp, 16) << 8;
/* 73 */     tmp = str.substring(4, 6);
/* 74 */     code += Integer.parseInt(tmp, 16);
/* 75 */     return (char)code;
/*    */   }
/*    */   public static void main(String[] args) {
/* 78 */     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*    */     try
/*    */     {
/*    */       while (true) {
/* 82 */         String str = br.readLine();
/* 83 */         System.out.println(ascii2Native(str));
/* 84 */         System.out.println(native2Ascii(str));
/*    */       }
/*    */     }
/*    */     catch (IOException e) {
/* 88 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.Ascii2Native
 * JD-Core Version:    0.6.0
 */