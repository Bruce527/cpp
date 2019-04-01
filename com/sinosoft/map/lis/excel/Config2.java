/*     */ package com.sinosoft.map.lis.excel;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Properties;
/*     */ 
/*     */ class Config2
/*     */ {
/*     */   public static String getTempletPath()
/*     */   {
/*  47 */     return get("TEMPLET_PATH");
/*     */   }
/*     */ 
/*     */   public static String getWorkPath()
/*     */   {
/*  52 */     return get("WORK_PATH");
/*     */   }
/*     */ 
/*     */   public static String get(String name) {
/*  56 */     File f = new File("s");
/*  57 */     int i = f.getAbsolutePath().lastIndexOf(File.separator);
/*  58 */     System.out.println("\u5F53\u524D\u8DEF\u5F84\uFF1A" + f.getAbsolutePath().substring(0, i));
/*     */ 
/*  65 */     f = null;
/*     */ 
/*  67 */     String value = null;
/*  68 */     File file = new File("report.properties");
/*  69 */     if (!file.exists()) {
/*  70 */       System.out.println("\u5728\u5F53\u524D\u76EE\u5F55\u4E0B\u627E\u4E0D\u5230" + file.getName() + "\u6587\u4EF6");
/*     */     }
/*  72 */     Properties p = new Properties();
/*  73 */     FileInputStream in = null;
/*     */     try {
/*  75 */       in = new FileInputStream(file);
/*  76 */       p.load(in);
/*  77 */       value = p.getProperty(name);
/*     */     } catch (FileNotFoundException e) {
/*  79 */       e.printStackTrace();
/*     */ 
/*  83 */       if (in != null)
/*     */         try {
/*  85 */           in.close();
/*     */         } catch (IOException e) {
/*  87 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  81 */       e.printStackTrace();
/*     */ 
/*  83 */       if (in != null)
/*     */         try {
/*  85 */           in.close();
/*     */         } catch (IOException e) {
/*  87 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     finally
/*     */     {
/*  83 */       if (in != null)
/*     */         try {
/*  85 */           in.close();
/*     */         } catch (IOException e) {
/*  87 */           e.printStackTrace();
/*     */         }
/*     */     }
/*  90 */     return value;
/*     */   }
/*     */   public static void main(String[] args) {
/*  93 */     File f = new File("sfd");
/*  94 */     int i = f.getAbsolutePath().lastIndexOf(File.separator);
/*     */ 
/*  96 */     System.out.println("\u5F53\u524D\u8DEF\u5F84\uFF1A" + f.getAbsolutePath().substring(0, i));
/*  97 */     File file = new File(f.getAbsolutePath().substring(0, i));
/*  98 */     File[] files = file.listFiles();
/*  99 */     System.out.println(files.length);
/*     */ 
/* 101 */     EvanLog logger = EvanLog.getLoger();
/* 102 */     logger.log("Config2------for start");
/* 103 */     for (int i2 = 0; i2 < files.length; i2++) {
/* 104 */       System.out.println(files[i2].getName());
/*     */     }
/* 106 */     logger.log("Config2------for end");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.Config2
 * JD-Core Version:    0.6.0
 */