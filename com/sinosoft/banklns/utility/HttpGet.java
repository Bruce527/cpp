/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class HttpGet
/*     */ {
/*     */   public static final boolean DEBUG = true;
/*  11 */   private static int BUFFER_SIZE = 8096;
/*     */ 
/*  13 */   private Vector vDownLoad = new Vector();
/*  14 */   private Vector vFileList = new Vector();
/*     */ 
/*     */   public void resetList()
/*     */   {
/*  24 */     this.vDownLoad.clear();
/*  25 */     this.vFileList.clear();
/*     */   }
/*     */ 
/*     */   public void addItem(String url, String filename)
/*     */   {
/*  30 */     this.vDownLoad.add(url);
/*  31 */     this.vFileList.add(filename);
/*     */   }
/*     */ 
/*     */   public void downLoadByList()
/*     */   {
/*  36 */     String url = null;
/*  37 */     String filename = null;
/*     */ 
/*  40 */     for (int i = 0; i < this.vDownLoad.size(); i++) {
/*  41 */       url = (String)this.vDownLoad.get(i);
/*  42 */       filename = (String)this.vFileList.get(i);
/*     */       try
/*     */       {
/*  45 */         saveToFile(url, filename);
/*     */       }
/*     */       catch (IOException err)
/*     */       {
/*  49 */         System.out.println("\u951F\u65A4\u62F7\u6E90[" + url + "]\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!!!");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  55 */     System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD!!!");
/*     */   }
/*     */ 
/*     */   public void saveToFile(String destUrl, String fileName)
/*     */     throws IOException
/*     */   {
/*  62 */     FileOutputStream fos = null;
/*  63 */     BufferedInputStream bis = null;
/*  64 */     HttpURLConnection httpUrl = null;
/*  65 */     URL url = null;
/*  66 */     byte[] buf = new byte[BUFFER_SIZE];
/*  67 */     int size = 0;
/*     */ 
/*  70 */     url = new URL(destUrl);
/*  71 */     httpUrl = (HttpURLConnection)url.openConnection();
/*     */ 
/*  73 */     httpUrl.connect();
/*     */ 
/*  75 */     bis = new BufferedInputStream(httpUrl.getInputStream());
/*     */ 
/*  77 */     fos = new FileOutputStream(fileName);
/*     */ 
/*  80 */     System.out.println("\u951F\u65A4\u62F7\u951F\u8282\u4F19\u62F7\u53D6t\u951F\u65A4\u62F7[" + destUrl + "]\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7...\n\u951F\u65A4\u62F7\u951F\u6212\u4FDD\u951F\u65A4\u62F7\u4E3A\u951F\u4FA5\u7877\u62F7[" + fileName + "]");
/*     */ 
/*  83 */     while ((size = bis.read(buf)) != -1) {
/*  84 */       fos.write(buf, 0, size);
/*     */     }
/*  86 */     fos.close();
/*  87 */     bis.close();
/*  88 */     httpUrl.disconnect();
/*     */   }
/*     */ 
/*     */   public void setProxyServer(String proxy, String proxyPort)
/*     */   {
/*  95 */     System.getProperties().put("proxySet", "true");
/*  96 */     System.getProperties().put("proxyHost", proxy);
/*  97 */     System.getProperties().put("proxyPort", proxyPort);
/*     */   }
/*     */ 
/*     */   public static void main(String[] argv)
/*     */   {
/* 110 */     Date dat = new Date();
/*     */ 
/* 112 */     HttpGet oInstance = new HttpGet();
/*     */     try
/*     */     {
/* 115 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7001.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F71.zip");
/* 116 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7002.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F72.zip");
/* 117 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7003.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F73.zip");
/* 118 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7004.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F74.zip");
/* 119 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7005.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F75.zip");
/* 120 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7006.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F76.zip");
/* 121 */       oInstance.addItem("http://www.ebook.com/java/\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7007.zip", "./\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F77.zip");
/*     */ 
/* 124 */       oInstance.downLoadByList();
/*     */     }
/*     */     catch (Exception err) {
/* 127 */       System.out.println(err.getMessage());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.HttpGet
 * JD-Core Version:    0.6.0
 */