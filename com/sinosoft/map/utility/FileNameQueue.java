/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FileNameQueue
/*     */ {
/*     */   public static final String LINE = "/";
/*     */   public static final String LINE2 = "-";
/*     */   public static final String PATTERN = "yyMMddHHmm";
/*     */   public static final String XML = ".xml";
/*     */   public static final String PRE = "Pre";
/*     */   public static final String XML_PRE = ".xmlPre";
/*  18 */   private static int nHead = 0;
/*     */ 
/*     */   public static synchronized String getFileName(String filepath, String templateOp)
/*     */   {
/*  27 */     StringBuffer sb = new StringBuffer(0);
/*  28 */     SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
/*  29 */     String dateStr = sdf.format(new Date());
/*  30 */     String fileName = null;
/*     */     do
/*     */     {
/*  34 */       if (nHead != 2147483647)
/*     */       {
/*  36 */         nHead += 1;
/*     */       }
/*     */       else
/*     */       {
/*  40 */         nHead = 0;
/*     */       }
/*     */ 
/*  44 */       sb.setLength(0);
/*  45 */       sb.append(templateOp);
/*     */ 
/*  47 */       sb.append(dateStr);
/*  48 */       sb.append("-");
/*  49 */       sb.append(nHead);
/*     */ 
/*  51 */       fileName = sb.toString();
/*     */     }
/*  53 */     while (!canUseName(filepath, fileName));
/*     */ 
/*  56 */     return fileName;
/*     */   }
/*     */ 
/*     */   public static synchronized boolean canUseName(String filepath, String fileName)
/*     */   {
/*  61 */     StringBuffer sb = new StringBuffer(0);
/*  62 */     sb.setLength(0);
/*  63 */     sb.append(filepath);
/*  64 */     sb.append("/");
/*  65 */     sb.append(fileName);
/*  66 */     sb.append(".xml");
/*  67 */     String fullFileName = sb.toString();
/*  68 */     sb.append("Pre");
/*  69 */     String fullFileNamePre = sb.toString();
/*  70 */     sb.setLength(0);
/*     */ 
/*  72 */     File f = new File(fullFileName);
/*  73 */     File fPre = new File(fullFileNamePre);
/*     */ 
/*  75 */     return (!f.exists()) && (!fPre.exists());
/*     */   }
/*     */ 
/*     */   public static synchronized boolean rename(String filepath, String fileName)
/*     */   {
/*  80 */     boolean b = false;
/*  81 */     StringBuffer sb = new StringBuffer(0);
/*  82 */     sb.setLength(0);
/*  83 */     sb.append(filepath);
/*  84 */     sb.append("/");
/*  85 */     sb.append(fileName);
/*  86 */     sb.append(".xml");
/*  87 */     String fullFileName = sb.toString();
/*  88 */     sb.append("Pre");
/*  89 */     String fullFileNamePre = sb.toString();
/*  90 */     sb.setLength(0);
/*     */ 
/*  92 */     File f = new File(fullFileName);
/*  93 */     File fPre = new File(fullFileNamePre);
/*  94 */     if (fPre.exists())
/*     */     {
/*  97 */       b = fPre.renameTo(f);
/*     */     }
/*     */ 
/* 103 */     return b;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 108 */     System.out.println(rename("C:\\nclprint", "Contract-001-2005-08-29-14-06-1"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.FileNameQueue
 * JD-Core Version:    0.6.0
 */