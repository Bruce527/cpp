/*     */ package com.sinosoft.map.lis.pubfun;
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
/* 132 */   public static int num = 0;
/*     */ 
/*     */   public static String getYearMonth(String value)
/*     */   {
/*  30 */     String tYearMonth = "";
/*  31 */     tYearMonth = value.substring(2, 6);
/*  32 */     return tYearMonth;
/*     */   }
/*     */ 
/*     */   public static String getChinaLen(String value, String len)
/*     */   {
/*  38 */     int n = Integer.parseInt(len);
/*  39 */     char[] arr = value.toCharArray();
/*  40 */     int result = 0;
/*     */ 
/*  42 */     for (int i = 0; i < n; i++)
/*     */     {
/*  44 */       if (arr[i] <= '\u01FF')
/*     */         continue;
/*  46 */       System.out.println(arr[i]);
/*  47 */       result++;
/*     */     }
/*     */ 
/*  51 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getChinaLen(String value)
/*     */   {
/*  57 */     char[] arr = value.toCharArray();
/*  58 */     int result = 0;
/*     */ 
/*  60 */     for (int i = 0; i < arr.length; i++)
/*     */     {
/*  62 */       if (arr[i] <= '\u01FF')
/*     */         continue;
/*  64 */       System.out.println(arr[i]);
/*  65 */       result++;
/*     */     }
/*     */ 
/*  69 */     return result;
/*     */   }
/*     */ 
/*     */   public static int getChinaLength(String value)
/*     */   {
/*  75 */     char[] arr = value.toCharArray();
/*  76 */     int result = 0;
/*     */ 
/*  78 */     for (int i = 0; i < arr.length; i++)
/*     */     {
/*  80 */       if (arr[i] > '\u01FF')
/*     */       {
/*  83 */         result += 2;
/*     */       }
/*     */       else
/*     */       {
/*  88 */         result++;
/*     */       }
/*     */     }
/*     */ 
/*  92 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getCurrentDate()
/*     */   {
/*  98 */     String pattern = "yyyy-MM-dd";
/*  99 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/* 100 */     Date today = new Date();
/* 101 */     return df.format(today);
/*     */   }
/*     */ 
/*     */   public static String getCurrentTime()
/*     */   {
/* 107 */     String pattern = "HH:mm:ss";
/* 108 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/* 109 */     Date today = new Date();
/* 110 */     return df.format(today);
/*     */   }
/*     */ 
/*     */   public static void setFirstLine()
/*     */   {
/* 116 */     firstLineFlag = true;
/*     */   }
/*     */ 
/*     */   public static boolean isFirstLine()
/*     */   {
/* 122 */     if (firstLineFlag)
/*     */     {
/* 124 */       firstLineFlag = false;
/* 125 */       return true;
/*     */     }
/*     */ 
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   public static void displayDocument(Node d)
/*     */   {
/* 137 */     num += 2;
/*     */ 
/* 139 */     if (d.hasChildNodes())
/*     */     {
/* 141 */       NodeList nl = d.getChildNodes();
/*     */ 
/* 143 */       for (int i = 0; i < nl.getLength(); i++)
/*     */       {
/* 145 */         Node n = nl.item(i);
/*     */ 
/* 147 */         for (int j = 0; j < num; j++)
/*     */         {
/* 149 */           System.out.print(" ");
/*     */         }
/* 151 */         if (n.getNodeValue() == null)
/*     */         {
/* 153 */           System.out.println("<" + n.getNodeName() + ">");
/*     */         }
/*     */         else
/*     */         {
/* 157 */           System.out.println(n.getNodeValue());
/*     */         }
/*     */ 
/* 160 */         displayDocument(n);
/*     */ 
/* 162 */         num -= 2;
/*     */ 
/* 165 */         if (n.getNodeValue() != null)
/*     */           continue;
/* 167 */         for (int j = 0; j < num; j++)
/*     */         {
/* 169 */           System.out.print(" ");
/*     */         }
/* 171 */         System.out.println("</" + n.getNodeName() + ">");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void displayStream(InputStream in)
/*     */   {
/*     */     try
/*     */     {
/* 185 */       BufferedReader brin = new BufferedReader(new InputStreamReader(in));
/* 186 */       String s = "";
/*     */ 
/* 188 */       System.out.println("");
/* 189 */       while ((s = brin.readLine()) != null)
/*     */       {
/* 191 */         System.out.println(s);
/*     */       }
/* 193 */       System.out.println("");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 198 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void displayBlob(Blob blob)
/*     */   {
/*     */     try
/*     */     {
/* 207 */       InputStream in = blob.getBinaryStream();
/*     */ 
/* 209 */       displayStream(in);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 213 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 219 */     System.out.println(getChinaLength("\u6D4B\u8BD5TSR3\u4EBA200408\u6708\u5E94\u4ED8\u4F63\u91D1"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.XmlFun
 * JD-Core Version:    0.6.0
 */