/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import sun.net.TelnetInputStream;
/*     */ import sun.net.TelnetOutputStream;
/*     */ import sun.net.ftp.FtpClient;
/*     */ import sun.net.ftp.FtpLoginException;
/*     */ import sun.net.ftp.FtpProtocolException;
/*     */ 
/*     */ public class FtpFun
/*     */ {
/*  17 */   private FtpClient mFtpClient = null;
/*     */ 
/*     */   public FtpClient connectFtpServer(String hostname, int port, String username, String password)
/*     */   {
/*     */     try
/*     */     {
/*  30 */       this.mFtpClient = new FtpClient(hostname, port);
/*  31 */       this.mFtpClient.login(username, password);
/*     */     }
/*     */     catch (FtpLoginException e1) {
/*  34 */       System.out.print("...... \u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD ......");
/*  35 */       e1.printStackTrace();
/*  36 */       return null;
/*     */     }
/*     */     catch (IOException e2) {
/*  39 */       System.out.println("...... \u672A\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7 ......");
/*  40 */       e2.printStackTrace();
/*  41 */       return null;
/*     */     }
/*     */     catch (SecurityException e3) {
/*  44 */       System.out.print("...... \u6743\u951F\u776B\u8BE7\u62F7\u951F\u65A4\u62F7 ......");
/*  45 */       e3.printStackTrace();
/*  46 */       return null;
/*     */     }
/*  48 */     return this.mFtpClient;
/*     */   }
/*     */ 
/*     */   public void downloadFile(String path, String filename)
/*     */   {
/*     */     try
/*     */     {
/*  56 */       if (path.length() != 0)
/*     */       {
/*  58 */         this.mFtpClient.cd(path);
/*     */       }
/*  60 */       this.mFtpClient.binary();
/*  61 */       TelnetInputStream tis = this.mFtpClient.get(filename);
/*  62 */       File outFile = new File("d:\\" + filename);
/*  63 */       FileOutputStream fos = new FileOutputStream(outFile);
/*  64 */       byte[] bytes = new byte[2048];
/*     */       int c;
/*  66 */       while ((c = tis.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/*  68 */         fos.write(bytes, 0, c);
/*     */       }
/*  70 */       tis.close();
/*  71 */       fos.close();
/*  72 */       this.mFtpClient.closeServer();
/*     */     }
/*     */     catch (IOException ex) {
/*  75 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u5931\u951F\u65A4\u62F7 ......");
/*  76 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean uploadFile(String inPath, String inFilename, String outPath, String outFilename)
/*     */   {
/*     */     try
/*     */     {
/*  86 */       if (outPath.length() != 0)
/*     */       {
/*  88 */         this.mFtpClient.cd(outPath);
/*     */       }
/*  90 */       this.mFtpClient.binary();
/*  91 */       TelnetOutputStream tos = this.mFtpClient.put(outFilename);
/*  92 */       File inFile = new File(inPath + inFilename);
/*  93 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u5C0F:" + inFile.length() / 1024L + "K ......");
/*  94 */       FileInputStream fis = new FileInputStream(inFile);
/*  95 */       byte[] bytes = new byte[2048];
/*     */       int c;
/*  97 */       while ((c = fis.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/*  99 */         tos.write(bytes, 0, c);
/*     */       }
/* 101 */       fis.close();
/* 102 */       tos.close();
/* 103 */       this.mFtpClient.closeServer();
/*     */     }
/*     */     catch (FtpProtocolException ex1)
/*     */     {
/* 108 */       System.out.println("...... \u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8282\u9769\u62F7\u76EE\u5F55\u951F\u94F0\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7 ......");
/* 109 */       ex1.printStackTrace();
/* 110 */       return false;
/*     */     }
/*     */     catch (IOException ex2) {
/* 113 */       System.out.println("...... \u672A\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7 ......");
/* 114 */       ex2.printStackTrace();
/* 115 */       return false;
/*     */     }
/*     */ 
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   public String getSystemInfo()
/*     */   {
/* 124 */     String systemInfo = null;
/*     */     try
/*     */     {
/* 127 */       systemInfo = this.mFtpClient.system();
/*     */     }
/*     */     catch (IOException ex) {
/* 130 */       System.out.println("......\u951F\u77EB\u7889\u62F7\u7CFB\u7EDF\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\uFFFD......");
/* 131 */       ex.printStackTrace();
/*     */     }
/*     */ 
/* 134 */     return systemInfo;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 139 */     FtpFun tFtpFun = new FtpFun();
/* 140 */     FtpClient tFtpClient = tFtpFun.connectFtpServer("172.19.1.43", 21, "oracle", "oracle");
/*     */ 
/* 142 */     if (tFtpClient != null)
/*     */     {
/* 144 */       System.out.println("\u951F\u7A96\u6485\u62F7l\u951F\u65A4\u62F7\u951F\u65A4\u62F7ftp server" + tFtpFun.getSystemInfo());
/* 145 */       tFtpFun.downloadFile("/app/uploadfile/lisfile/", "DE2007-01-03_Mov.txt");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.FtpFun
 * JD-Core Version:    0.6.0
 */