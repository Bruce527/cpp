/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ 
/*     */ public class FileDeal
/*     */ {
/*   8 */   public CErrors mErrors = new CErrors();
/*     */   private String OriPathName;
/*     */   private String DesPathName;
/*     */   private File mFile;
/*     */   private String DesDir;
/*     */ 
/*     */   public FileDeal()
/*     */   {
/*     */   }
/*     */ 
/*     */   public FileDeal(String aStr)
/*     */   {
/*  19 */     this.OriPathName = aStr;
/*     */   }
/*     */ 
/*     */   public boolean FileCopy(String aStr)
/*     */   {
/*     */     try {
/*  25 */       if (!createDir(aStr))
/*     */       {
/*  27 */         CError tError = new CError();
/*  28 */         tError.moduleName = "FileDeal";
/*  29 */         tError.functionName = "FileCopy";
/*  30 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u53EB\u7B79\u62F7\u951F\uFFFD!";
/*  31 */         this.mErrors.addOneError(tError);
/*  32 */         return false;
/*     */       }
/*  34 */       this.DesPathName = aStr;
/*  35 */       int nChar = -1;
/*  36 */       FileInputStream in = new FileInputStream(this.OriPathName);
/*  37 */       FileOutputStream out = new FileOutputStream(this.DesPathName);
/*  38 */       while ((nChar = in.read()) != -1) {
/*  39 */         out.write(nChar);
/*     */       }
/*  41 */       out.flush();
/*  42 */       in.close();
/*  43 */       out.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  47 */       ex.printStackTrace();
/*     */ 
/*  49 */       CError tError = new CError();
/*  50 */       tError.moduleName = "FileDeal";
/*  51 */       tError.functionName = "FileCopy";
/*  52 */       tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u7B79\u62F7\u951F\uFFFD!";
/*  53 */       this.mErrors.addOneError(tError);
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean FileMove(String aStr)
/*     */   {
/*     */     try
/*     */     {
/*  63 */       if (!createDir(aStr))
/*     */       {
/*  65 */         CError tError = new CError();
/*  66 */         tError.moduleName = "FileDeal";
/*  67 */         tError.functionName = "FileCopy";
/*  68 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u53EB\u7B79\u62F7\u951F\uFFFD!";
/*  69 */         this.mErrors.addOneError(tError);
/*  70 */         return false;
/*     */       }
/*  72 */       this.DesPathName = aStr;
/*  73 */       this.mFile = new File(this.OriPathName);
/*  74 */       File tFile = new File(this.DesPathName);
/*  75 */       if (!this.mFile.renameTo(tFile))
/*     */       {
/*  78 */         CError tError = new CError();
/*  79 */         tError.moduleName = "FileDeal";
/*  80 */         tError.functionName = "FileMove";
/*  81 */         tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u951F\u72E1\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\uFFFD!";
/*  82 */         this.mErrors.addOneError(tError);
/*  83 */         return false;
/*     */       }
/*  85 */       if (!this.mFile.createNewFile())
/*     */       {
/*  88 */         CError tError = new CError();
/*  89 */         tError.moduleName = "FileDeal";
/*  90 */         tError.functionName = "FileMove";
/*  91 */         tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u951F\u72E1\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\uFFFD!";
/*  92 */         this.mErrors.addOneError(tError);
/*  93 */         return false;
/*     */       }
/*  95 */       tFile = new File(this.OriPathName);
/*  96 */       if (!tFile.delete())
/*     */       {
/*  99 */         CError tError = new CError();
/* 100 */         tError.moduleName = "FileDeal";
/* 101 */         tError.functionName = "FileMove";
/* 102 */         tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u951F\u72E1\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\uFFFD!";
/* 103 */         this.mErrors.addOneError(tError);
/* 104 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 109 */       ex.printStackTrace();
/*     */ 
/* 111 */       CError tError = new CError();
/* 112 */       tError.moduleName = "FileDeal";
/* 113 */       tError.functionName = "FileMove";
/* 114 */       tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u951F\u72E1\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\uFFFD!";
/* 115 */       this.mErrors.addOneError(tError);
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean FileDel()
/*     */   {
/*     */     try {
/* 124 */       File tFile = new File(this.OriPathName);
/* 125 */       if (!tFile.delete())
/*     */       {
/* 128 */         CError tError = new CError();
/* 129 */         tError.moduleName = "FileDeal";
/* 130 */         tError.functionName = "FileDel";
/* 131 */         tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u5220\u951F\u65A4\u62F7\u951F\u65A4\u62F7!";
/* 132 */         this.mErrors.addOneError(tError);
/* 133 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 138 */       ex.printStackTrace();
/*     */ 
/* 140 */       CError tError = new CError();
/* 141 */       tError.moduleName = "FileDeal";
/* 142 */       tError.functionName = "FileDel";
/* 143 */       tError.errorMessage = "\u951F\u4FA5\u7877\u62F7\u5220\u951F\u65A4\u62F7\u951F\u65A4\u62F7!";
/* 144 */       this.mErrors.addOneError(tError);
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean createDir(String aStr)
/*     */   {
/* 152 */     int index = aStr.lastIndexOf("\\");
/* 153 */     if (index == -1)
/* 154 */       index = aStr.lastIndexOf("/");
/* 155 */     this.DesDir = aStr.substring(0, index);
/* 156 */     File tDir = new File(this.DesDir);
/*     */ 
/* 159 */     if (!tDir.exists())
/*     */     {
/*     */       try
/*     */       {
/* 164 */         tDir.mkdirs();
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 168 */         ex.printStackTrace();
/* 169 */         CError tError = new CError();
/* 170 */         tError.moduleName = "FileDeal";
/* 171 */         tError.functionName = "FileCopy";
/* 172 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u53EB\u7B79\u62F7\u951F\uFFFD!";
/* 173 */         this.mErrors.addOneError(tError);
/* 174 */         return false;
/*     */       }
/*     */     }
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 181 */     FileDeal fileDeal1 = new FileDeal("\\test.xml");
/*     */ 
/* 183 */     fileDeal1.FileCopy(".\\uia\\test.xml");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.FileDeal
 * JD-Core Version:    0.6.0
 */