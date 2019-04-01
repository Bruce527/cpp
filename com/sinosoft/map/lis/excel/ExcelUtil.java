/*     */ package com.sinosoft.map.lis.excel;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ class ExcelUtil
/*     */ {
/*     */   public static ExcelInfo prepare(String name, long usefulLifeSecs)
/*     */   {
/*  22 */     ExcelInfo result = new ExcelInfo();
/*     */ 
/*  25 */     StringBuffer sb = new StringBuffer();
/*  26 */     File file = new File(Config.getWorkPath());
/*  27 */     String workPath = file.getAbsolutePath();
/*     */ 
/*  29 */     if (!file.exists()) {
/*  30 */       file.mkdirs();
/*     */     }
/*     */ 
/*  33 */     sb.append(workPath);
/*  34 */     sb.append(File.separator);
/*  35 */     sb.append(name);
/*     */ 
/*  37 */     File file2 = new File(sb.toString());
/*  38 */     if (file2.exists()) {
/*  39 */       long modifyTime = file2.lastModified();
/*  40 */       long now = System.currentTimeMillis();
/*  41 */       long diff = now - modifyTime;
/*     */ 
/*  43 */       if (diff < usefulLifeSecs * 1000L) {
/*  44 */         result.excelExists = true;
/*  45 */         result.modifyTime = modifyTime;
/*     */       } else {
/*  47 */         result.excelExists = false;
/*     */       }
/*     */     } else {
/*  50 */       result.excelExists = false;
/*     */     }
/*  52 */     result.excelPath = sb.toString();
/*  53 */     if (result.excelExists)
/*  54 */       System.out.println("\u627E\u5230\u6709\u6548\u7684Excel\u6587\u4EF6----" + name);
/*     */     else {
/*  56 */       System.out.println("\u6CA1\u627E\u5230\u6709\u6548\u7684Excel\u6587\u4EF6----" + name);
/*     */     }
/*     */ 
/*  59 */     return result;
/*     */   }
/*     */ 
/*     */   public static ExcelInfo prepare1(String name, long usefulLifeSecs, String filepath)
/*     */   {
/*  68 */     System.out.println("enter into prepare1");
/*  69 */     ExcelInfo result = new ExcelInfo();
/*     */ 
/*  72 */     StringBuffer sb = new StringBuffer();
/*     */ 
/*  74 */     File file = new File(filepath);
/*  75 */     String workPath = file.getAbsolutePath();
/*     */ 
/*  77 */     if (!file.exists()) {
/*  78 */       file.mkdirs();
/*     */     }
/*     */ 
/*  81 */     sb.append(workPath);
/*  82 */     sb.append(File.separator);
/*  83 */     sb.append(name);
/*     */ 
/*  85 */     File file2 = new File(sb.toString());
/*  86 */     if (file2.exists()) {
/*  87 */       long modifyTime = file2.lastModified();
/*  88 */       long now = System.currentTimeMillis();
/*  89 */       long diff = now - modifyTime;
/*     */ 
/*  91 */       if (diff < usefulLifeSecs * 1000L) {
/*  92 */         result.excelExists = true;
/*  93 */         result.modifyTime = modifyTime;
/*     */       } else {
/*  95 */         result.excelExists = false;
/*     */       }
/*     */     } else {
/*  98 */       result.excelExists = false;
/*     */     }
/* 100 */     result.excelPath = sb.toString();
/* 101 */     if (result.excelExists)
/* 102 */       System.out.println("\u627E\u5230\u6709\u6548\u7684Excel\u6587\u4EF6----" + name);
/*     */     else {
/* 104 */       System.out.println("\u6CA1\u627E\u5230\u6709\u6548\u7684Excel\u6587\u4EF6----" + name);
/*     */     }
/*     */ 
/* 107 */     return result;
/*     */   }
/*     */ 
/*     */   public static ZipInfo prepare1(String name, long usefulLifeSecs)
/*     */   {
/* 114 */     ZipInfo result = new ZipInfo();
/*     */ 
/* 116 */     StringBuffer sb = new StringBuffer();
/* 117 */     File file = new File(Config.getWorkPath());
/* 118 */     String workPath = file.getAbsolutePath();
/*     */ 
/* 120 */     if (!file.exists()) {
/* 121 */       file.mkdirs();
/*     */     }
/*     */ 
/* 124 */     sb.append(workPath);
/* 125 */     sb.append(File.separator);
/* 126 */     sb.append(name);
/*     */ 
/* 128 */     File file2 = new File(sb.toString());
/* 129 */     if (file2.exists()) {
/* 130 */       long modifyTime = file2.lastModified();
/* 131 */       long now = System.currentTimeMillis();
/* 132 */       long diff = now - modifyTime;
/*     */ 
/* 134 */       if (diff < usefulLifeSecs * 1000L) {
/* 135 */         result.zipExists = true;
/* 136 */         result.modifyTime = modifyTime;
/*     */       } else {
/* 138 */         result.zipExists = false;
/*     */       }
/*     */     } else {
/* 141 */       result.zipExists = false;
/*     */     }
/* 143 */     result.zipName = name;
/* 144 */     result.zipPath = sb.toString();
/* 145 */     if (result.zipExists)
/* 146 */       System.out.println("\u627E\u5230\u6709\u6548\u7684zip\u6587\u4EF6----" + name);
/*     */     else {
/* 148 */       System.out.println("\u6CA1\u627E\u5230\u6709\u6548\u7684zip\u6587\u4EF6----" + name);
/*     */     }
/*     */ 
/* 151 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getTempletPath(String templetName)
/*     */   {
/* 158 */     StringBuffer path = new StringBuffer();
/*     */ 
/* 161 */     File file = new File(Config.getTempletPath());
/*     */ 
/* 163 */     path.append(file.getAbsolutePath());
/* 164 */     path.append(File.separator);
/* 165 */     path.append(templetName);
/*     */ 
/* 167 */     return path.toString();
/*     */   }
/*     */ 
/*     */   public static String getExcelPath(String fileName) {
/* 171 */     StringBuffer path = new StringBuffer();
/*     */ 
/* 174 */     File file = new File(Config.getWorkPath());
/*     */ 
/* 176 */     path.append(file.getAbsolutePath());
/* 177 */     path.append(File.separator);
/* 178 */     path.append(fileName);
/*     */ 
/* 180 */     return path.toString();
/*     */   }
/*     */ 
/*     */   public static void removeStartWithExcept(String startOfFileName, String exceptedFileName, long beforeSecs)
/*     */   {
/* 193 */     if (startOfFileName != null)
/* 194 */       startOfFileName = startOfFileName.trim();
/* 195 */     if (exceptedFileName != null)
/* 196 */       exceptedFileName = exceptedFileName.trim();
/* 197 */     File file = new File(Config.getWorkPath());
/* 198 */     if (file.isDirectory()) {
/* 199 */       File[] files = file.listFiles();
/*     */ 
/* 201 */       EvanLog logger = EvanLog.getLoger();
/* 202 */       logger.log("ExcelUtil------for start");
/* 203 */       for (int i = 0; i < files.length; i++) {
/* 204 */         if ((!files[i].getName().trim().startsWith(startOfFileName)) || (
/* 205 */           (exceptedFileName != null) && 
/* 207 */           (exceptedFileName.equals(files[i].getName()
/* 207 */           .trim())))) {
/*     */           continue;
/*     */         }
/* 210 */         if (beforeSecs * 1000L <= System.currentTimeMillis() - 
/* 210 */           files[i].lastModified()) {
/* 211 */           boolean deleted = files[i].delete();
/*     */ 
/* 213 */           if (deleted)
/* 214 */             System.out.println(files[i].getName() + " \u88AB\u5220\u9664");
/*     */           else {
/* 216 */             System.out.println(files[i].getName() + " \u65E0\u6CD5\u5220\u9664");
/*     */           }
/*     */         }
/*     */       }
/* 220 */       logger.log("ExcelUtil------for end");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean remove(String fileName) {
/* 225 */     boolean flag = false;
/* 226 */     String path = Config.getWorkPath();
/* 227 */     path = path + File.separator + fileName;
/* 228 */     File f = new File(path);
/* 229 */     if (f.exists()) {
/* 230 */       flag = f.delete();
/* 231 */       if (!flag)
/* 232 */         System.out.println("\u65E0\u6CD5\u5220\u9664 " + fileName);
/*     */       else {
/* 234 */         System.out.println("\u5220\u9664 " + fileName);
/*     */       }
/*     */     }
/* 237 */     return flag;
/*     */   }
/*     */ 
/*     */   public static boolean remove(String fileName, String filepath)
/*     */   {
/* 242 */     boolean flag = false;
/* 243 */     String path = filepath;
/* 244 */     path = path + File.separator + fileName;
/* 245 */     File f = new File(path);
/* 246 */     if (f.exists()) {
/* 247 */       flag = f.delete();
/* 248 */       if (!flag)
/* 249 */         System.out.println("\u65E0\u6CD5\u5220\u9664 " + fileName);
/*     */       else {
/* 251 */         System.out.println("\u5220\u9664 " + fileName);
/*     */       }
/*     */     }
/* 254 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.ExcelUtil
 * JD-Core Version:    0.6.0
 */