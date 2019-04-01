/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Blob;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class XmlFun
/*     */ {
/*  21 */   private static boolean firstLineFlag = true;
/*     */ 
/* 121 */   public static int num = 0;
/*     */ 
/*     */   public static String getYearMonth(String value)
/*     */   {
/*  29 */     String tYearMonth = "";
/*  30 */     tYearMonth = value.substring(2, 6);
/*  31 */     return tYearMonth;
/*     */   }
/*     */ 
/*     */   public static String getChinaLen(String value, String len) {
/*  35 */     int n = Integer.parseInt(len);
/*  36 */     char[] arr = value.toCharArray();
/*  37 */     int result = 0;
/*     */ 
/*  39 */     for (int i = 0; i < n; i++)
/*     */     {
/*  41 */       if (arr[i] <= '\u01FF')
/*     */         continue;
/*  43 */       System.out.println(arr[i]);
/*  44 */       result++;
/*     */     }
/*     */ 
/*  48 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getChinaLen(String value) {
/*  52 */     char[] arr = value.toCharArray();
/*  53 */     int result = 0;
/*     */ 
/*  55 */     for (int i = 0; i < arr.length; i++)
/*     */     {
/*  57 */       if (arr[i] <= '\u01FF')
/*     */         continue;
/*  59 */       System.out.println(arr[i]);
/*  60 */       result++;
/*     */     }
/*     */ 
/*  64 */     return result;
/*     */   }
/*     */ 
/*     */   public static int getChinaLength(String value) {
/*  68 */     char[] arr = value.toCharArray();
/*  69 */     int result = 0;
/*     */ 
/*  71 */     for (int i = 0; i < arr.length; i++)
/*     */     {
/*  73 */       if (arr[i] > '\u01FF')
/*     */       {
/*  76 */         result += 2;
/*     */       }
/*     */       else
/*     */       {
/*  81 */         result++;
/*     */       }
/*     */     }
/*     */ 
/*  85 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getCurrentDate()
/*     */   {
/*  90 */     String pattern = "yyyy-MM-dd";
/*  91 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*  92 */     Date today = new Date();
/*  93 */     return df.format(today);
/*     */   }
/*     */ 
/*     */   public static String getCurrentTime()
/*     */   {
/*  98 */     String pattern = "HH:mm:ss";
/*  99 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/* 100 */     Date today = new Date();
/* 101 */     return df.format(today);
/*     */   }
/*     */ 
/*     */   public static void setFirstLine()
/*     */   {
/* 106 */     firstLineFlag = true;
/*     */   }
/*     */ 
/*     */   public static boolean isFirstLine()
/*     */   {
/* 111 */     if (firstLineFlag)
/*     */     {
/* 113 */       firstLineFlag = false;
/* 114 */       return true;
/*     */     }
/*     */ 
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   public static void displayDocument(Node d)
/*     */   {
/* 125 */     num += 2;
/*     */ 
/* 127 */     if (d.hasChildNodes())
/*     */     {
/* 129 */       NodeList nl = d.getChildNodes();
/*     */ 
/* 131 */       for (int i = 0; i < nl.getLength(); i++)
/*     */       {
/* 133 */         Node n = nl.item(i);
/*     */ 
/* 135 */         for (int j = 0; j < num; j++)
/*     */         {
/* 137 */           System.out.print(" ");
/*     */         }
/* 139 */         if (n.getNodeValue() == null)
/*     */         {
/* 141 */           System.out.println("<" + n.getNodeName() + ">");
/*     */         }
/*     */         else
/*     */         {
/* 145 */           System.out.println(n.getNodeValue());
/*     */         }
/*     */ 
/* 148 */         displayDocument(n);
/*     */ 
/* 150 */         num -= 2;
/*     */ 
/* 153 */         if (n.getNodeValue() != null)
/*     */           continue;
/* 155 */         for (int j = 0; j < num; j++)
/*     */         {
/* 157 */           System.out.print(" ");
/*     */         }
/* 159 */         System.out.println("</" + n.getNodeName() + ">");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void displayStream(InputStream in)
/*     */   {
/*     */     try
/*     */     {
/* 172 */       BufferedReader brin = new BufferedReader(new InputStreamReader(in));
/* 173 */       String s = "";
/*     */ 
/* 175 */       System.out.println("");
/* 176 */       while ((s = brin.readLine()) != null)
/*     */       {
/* 178 */         System.out.println(s);
/*     */       }
/* 180 */       System.out.println("");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 185 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void displayBlob(Blob blob)
/*     */   {
/*     */     try
/*     */     {
/* 193 */       InputStream in = blob.getBinaryStream();
/*     */ 
/* 195 */       displayStream(in);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 199 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 205 */     System.out.println(getChinaLength("\u6D4B\u8BD5TSR3\u4EBA200408\u6708\u5E94\u4ED8\u4F63\u91D1"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.XmlFun
 * JD-Core Version:    0.6.0
 */