/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipInputStream;
/*     */ 
/*     */ public class DealRiskSyn
/*     */ {
/*  18 */   public CErrors mErrors = new CErrors();
/*  19 */   private String mFileName = null;
/*     */ 
/*  25 */   private ZipInputStream mZIn = null;
/*  26 */   private FileInputStream mFIn = null;
/*  27 */   private ZipEntry ze = null;
/*  28 */   private ZipFile zf = null;
/*     */ 
/*  30 */   private LinkedList mLinkedList = new LinkedList();
/*     */ 
/*     */   public LinkedList getLinkedList()
/*     */   {
/*  37 */     return this.mLinkedList;
/*     */   }
/*     */ 
/*     */   public void setFileName(String aFileName)
/*     */   {
/*  47 */     this.mFileName = aFileName;
/*     */   }
/*     */ 
/*     */   public boolean parseZipFile()
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.zf = new ZipFile(this.mFileName);
/*  55 */       this.mFIn = new FileInputStream(this.mFileName);
/*  56 */       this.mZIn = new ZipInputStream(this.mFIn);
/*     */ 
/*  58 */       while ((this.ze = this.mZIn.getNextEntry()) != null)
/*     */       {
/*  60 */         System.out.println(this.ze.getName());
/*  61 */         this.mLinkedList.add(this.ze.getName());
/*  62 */         this.mZIn.closeEntry();
/*     */       }
/*  64 */       this.mZIn.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  68 */       ex.printStackTrace();
/*  69 */       buildError("parseZipFile", "\u951F\u65A4\u62F7\u951F\u65A4\u62F7Zip\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7?");
/*  70 */       return false;
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   public InputStream getEntInp(String aEnFileName)
/*     */   {
/*  77 */     InputStream ins = null;
/*     */     try
/*     */     {
/*  82 */       this.ze = this.zf.getEntry(aEnFileName);
/*  83 */       if (this.ze == null)
/*     */       {
/*  85 */         buildError("getEntInp", "\u951F\u65A4\u62F7\u951F\u65A4\u62F7Zip\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7?");
/*  86 */         return ins;
/*     */       }
/*     */ 
/*  89 */       ins = this.zf.getInputStream(this.ze);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  93 */       buildError("getEntInp", ex.toString());
/*  94 */       return ins;
/*     */     }
/*  96 */     return ins;
/*     */   }
/*     */ 
/*     */   public boolean closeEntry()
/*     */   {
/*     */     try
/*     */     {
/* 103 */       this.mZIn.closeEntry();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 107 */       ex.printStackTrace();
/* 108 */       buildError("closeEntry", "\u951F\u622A\u618B\u62F7Zip\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7?");
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean close()
/*     */   {
/*     */     try
/*     */     {
/* 118 */       this.mZIn.close();
/* 119 */       this.mFIn.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 123 */       ex.printStackTrace();
/* 124 */       buildError("close", "\u951F\u622A\u618B\u62F7Zip\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7?");
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   private void buildError(String szFunc, String szErrMsg)
/*     */   {
/* 132 */     CError cError = new CError();
/*     */ 
/* 134 */     cError.moduleName = "DealRiskSyn";
/* 135 */     cError.functionName = szFunc;
/* 136 */     cError.errorMessage = szErrMsg;
/* 137 */     this.mErrors.addOneError(cError);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 145 */       String tFileName = "e:\\112201.zip";
/* 146 */       ZipInputStream zin = new ZipInputStream(new FileInputStream(tFileName));
/*     */       ZipEntry ze;
/* 148 */       while ((ze = zin.getNextEntry()) != null)
/*     */       {
/*     */         ZipEntry ze;
/* 150 */         System.out.println(ze.getName());
/* 151 */         zin.closeEntry();
/*     */       }
/* 153 */       zin.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 157 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DealRiskSyn
 * JD-Core Version:    0.6.0
 */