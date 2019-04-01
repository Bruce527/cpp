/*     */ package com.sinosoft.map.lis.excel;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ReportHelper
/*     */ {
/*  12 */   private SimpleWorkbook workbook = null;
/*     */ 
/*  14 */   private ExcelInfo result = null;
/*     */   private String templetPath;
/*     */ 
/*     */   public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith, long invalidationSec)
/*     */   {
/*  34 */     this.result = ExcelUtil.prepare(reportFileName, usefullLifeSec);
/*  35 */     this.result.excelName = reportFileName;
/*  36 */     this.templetPath = ExcelUtil.getTempletPath(templetFileName);
/*     */ 
/*  40 */     System.out.println("templetPath:" + this.templetPath);
/*  41 */     ExcelUtil.removeStartWithExcept(rvFNStartWith, this.result.excelPath, 
/*  42 */       invalidationSec);
/*     */   }
/*     */ 
/*     */   public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith, long invalidationSec, String str)
/*     */   {
/*  57 */     System.out.println("enter into ReportHelper");
/*  58 */     this.result = ExcelUtil.prepare1(reportFileName, usefullLifeSec, str);
/*  59 */     this.result.excelName = reportFileName;
/*  60 */     this.templetPath = ExcelUtil.getTempletPath(templetFileName);
/*     */ 
/*  64 */     System.out.println("templetPath:" + this.templetPath);
/*  65 */     ExcelUtil.removeStartWithExcept(rvFNStartWith, this.result.excelPath, 
/*  66 */       invalidationSec);
/*     */   }
/*     */ 
/*     */   public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith)
/*     */   {
/*  81 */     this(templetFileName, reportFileName, usefullLifeSec, rvFNStartWith, 
/*  81 */       usefullLifeSec * 2L);
/*     */   }
/*     */ 
/*     */   public ExcelInfo getInfo()
/*     */   {
/*  86 */     return this.result;
/*     */   }
/*     */ 
/*     */   public SimpleWorkbook createWorkbook()
/*     */   {
/*     */     try
/*     */     {
/*  97 */       this.workbook = new SimpleWorkbook(this.result.excelPath, this.templetPath);
/*  98 */       System.out.println("workbook created: " + this.workbook);
/*  99 */       System.out.println("excelPath: " + this.result.excelPath);
/* 100 */       System.out.println("templetPath: " + this.templetPath);
/*     */     } catch (Exception e) {
/* 102 */       e.printStackTrace();
/*     */     }
/* 104 */     return this.workbook;
/*     */   }
/*     */ 
/*     */   public static boolean remove(String reportName) {
/* 108 */     return ExcelUtil.remove(reportName);
/*     */   }
/*     */   public static boolean remove(String reportName, String reportpath) {
/* 111 */     return ExcelUtil.remove(reportName, reportpath);
/*     */   }
/*     */   public static String getReportPath(String fileName) {
/* 114 */     return ExcelUtil.getExcelPath(fileName);
/*     */   }
/*     */ 
/*     */   public static void download(OutputStream out, String filePath)
/*     */   {
/* 124 */     DownloadUtil.writeTo(out, filePath);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.ReportHelper
 * JD-Core Version:    0.6.0
 */