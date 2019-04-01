/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ 
/*     */ public class FileDeal
/*     */ {
/*  15 */   public CErrors mErrors = new CErrors();
/*     */   private String OriPathName;
/*     */   private String DesPathName;
/*     */   private File mFile;
/*     */ 
/*     */   public FileDeal(String aStr)
/*     */   {
/*  25 */     this.OriPathName = aStr;
/*     */   }
/*     */ 
/*     */   public boolean FileCopy(String aStr)
/*     */   {
/*     */     try
/*     */     {
/*  32 */       this.DesPathName = aStr;
/*  33 */       int nChar = -1;
/*  34 */       FileInputStream in = new FileInputStream(this.OriPathName);
/*  35 */       FileOutputStream out = new FileOutputStream(this.DesPathName);
/*  36 */       while ((nChar = in.read()) != -1)
/*     */       {
/*  38 */         out.write(nChar);
/*     */       }
/*  40 */       out.flush();
/*  41 */       in.close();
/*  42 */       out.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  46 */       ex.printStackTrace();
/*     */ 
/*  48 */       CError tError = new CError();
/*  49 */       tError.moduleName = "FileDeal";
/*  50 */       tError.functionName = "FileCopy";
/*  51 */       tError.errorMessage = "\u6587\u4EF6\u590D\u5236\u51FA\u9519!";
/*  52 */       this.mErrors.addOneError(tError);
/*  53 */       return false;
/*     */     }
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean FileMove(String aStr)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       this.DesPathName = aStr;
/*  63 */       this.mFile = new File(this.OriPathName);
/*  64 */       File tFile = new File(this.DesPathName);
/*  65 */       if (!this.mFile.renameTo(tFile))
/*     */       {
/*  68 */         CError tError = new CError();
/*  69 */         tError.moduleName = "FileDeal";
/*  70 */         tError.functionName = "FileMove";
/*  71 */         tError.errorMessage = "\u6587\u4EF6\u79FB\u52A8\u51FA\u9519!";
/*  72 */         this.mErrors.addOneError(tError);
/*  73 */         return false;
/*     */       }
/*  75 */       if (!this.mFile.createNewFile())
/*     */       {
/*  78 */         CError tError = new CError();
/*  79 */         tError.moduleName = "FileDeal";
/*  80 */         tError.functionName = "FileMove";
/*  81 */         tError.errorMessage = "\u6587\u4EF6\u79FB\u52A8\u51FA\u9519!";
/*  82 */         this.mErrors.addOneError(tError);
/*  83 */         return false;
/*     */       }
/*  85 */       tFile = new File(this.OriPathName);
/*  86 */       if (!tFile.delete())
/*     */       {
/*  89 */         CError tError = new CError();
/*  90 */         tError.moduleName = "FileDeal";
/*  91 */         tError.functionName = "FileMove";
/*  92 */         tError.errorMessage = "\u6587\u4EF6\u79FB\u52A8\u51FA\u9519!";
/*  93 */         this.mErrors.addOneError(tError);
/*  94 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  99 */       ex.printStackTrace();
/*     */ 
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "FileDeal";
/* 103 */       tError.functionName = "FileMove";
/* 104 */       tError.errorMessage = "\u6587\u4EF6\u79FB\u52A8\u51FA\u9519!";
/* 105 */       this.mErrors.addOneError(tError);
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean FileDel()
/*     */   {
/* 113 */     File tFile = new File(this.OriPathName);
/* 114 */     if (!tFile.delete())
/*     */     {
/* 117 */       CError tError = new CError();
/* 118 */       tError.moduleName = "FileDeal";
/* 119 */       tError.functionName = "FileDel";
/* 120 */       tError.errorMessage = "\u6587\u4EF6\u5220\u9664\u51FA\u9519!";
/* 121 */       this.mErrors.addOneError(tError);
/* 122 */       return false;
/*     */     }
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 129 */     FileDeal fileDeal1 = new FileDeal("E:\\test.xml");
/*     */ 
/* 131 */     fileDeal1.FileCopy("E:\\ui\\test.xml");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.FileDeal
 * JD-Core Version:    0.6.0
 */