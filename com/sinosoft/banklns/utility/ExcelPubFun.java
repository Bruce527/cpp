/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.text.DecimalFormat;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ 
/*     */ public class ExcelPubFun
/*     */ {
/*  30 */   public CErrors mErrors = new CErrors();
/*     */   public SSRS tResult;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean ReadExcelData(String tExcelName, String tExcelPath, String tSheetName, String tStartPosition, int tColCount)
/*     */   {
/*     */     try
/*     */     {
/*  42 */       tExcelPath = tExcelPath.charAt(tExcelPath.length() - 1) != '/' ? tExcelPath + "/" : tExcelPath;
/*     */ 
/*  46 */       String tCheckFile = CheckFilePath(tExcelName, tExcelPath);
/*  47 */       if (!tCheckFile.equals("Succ")) {
/*  48 */         CError tError = new CError();
/*  49 */         tError.moduleName = "LAAddSubImportBL";
/*  50 */         tError.functionName = "readExcelFile";
/*  51 */         tError.errorMessage = tCheckFile;
/*  52 */         this.mErrors.addOneError(tError);
/*  53 */         return false;
/*     */       }
/*     */ 
/*  59 */       tExcelPath = tExcelPath.charAt(tExcelPath.length() - 1) != '/' ? tExcelPath + "/" : tExcelPath;
/*     */ 
/*  62 */       POIFSFileSystem tInputFile = new POIFSFileSystem(new FileInputStream(tExcelPath + tExcelName));
/*     */ 
/*  65 */       HSSFWorkbook tWorkBook = new HSSFWorkbook(tInputFile);
/*     */ 
/*  68 */       HSSFSheet tWorkSheet = tWorkBook.getSheet(tSheetName);
/*  69 */       if (tWorkSheet == null) {
/*  70 */         tWorkSheet = tWorkBook.getSheetAt(0);
/*     */       }
/*     */ 
/*  73 */       HSSFRow tWorkRow = null;
/*     */ 
/*  75 */       HSSFCell tWorkCell = null;
/*     */ 
/*  79 */       if (!CheckCoordinate(tStartPosition)) {
/*  80 */         CError tError = new CError();
/*  81 */         tError.moduleName = "LAAddSubImportBL";
/*  82 */         tError.functionName = "readExcelFile";
/*  83 */         tError.errorMessage = "\u951F\u501F\u5B9A\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u8F96\u951F\u65A4\u62F7\u951F\u75A5\u4E0D\u951F\u65A4\u62F7\u786E,\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u9732\u951F\u997A\uE4CBxcel";
/*  84 */         this.mErrors.addOneError(tError);
/*  85 */         return false;
/*     */       }
/*     */ 
/*  89 */       double[][] tRealTargetStart = GetCoordinate(tStartPosition);
/*     */ 
/*  93 */       this.tResult = new SSRS(tColCount);
/*  94 */       DecimalFormat df = new DecimalFormat("############.#####");
/*     */ 
/*  96 */       boolean tReadFlag = true;
/*  97 */       int i = (int)tRealTargetStart[0][1] - 1;
/*  98 */       while (tReadFlag)
/*     */       {
/* 102 */         tWorkRow = tWorkSheet.getRow(i);
/* 103 */         if (tWorkRow == null)
/*     */         {
/* 105 */           tReadFlag = false;
/* 106 */           break;
/*     */         }
/* 108 */         for (int j = 0; j < tColCount; j++)
/*     */         {
/* 110 */           tWorkCell = tWorkRow.getCell((short)((int)tRealTargetStart[0][0] + j - 1));
/* 111 */           if (tWorkCell == null)
/*     */           {
/* 113 */             this.tResult.SetText("");
/*     */           }
/*     */           else {
/* 116 */             switch (tWorkCell.getCellType())
/*     */             {
/*     */             case 1:
/* 119 */               this.tResult.SetText(tWorkCell.getStringCellValue());
/* 120 */               break;
/*     */             case 0:
/* 122 */               this.tResult.SetText(df.format(tWorkCell.getNumericCellValue()));
/* 123 */               break;
/*     */             case 2:
/* 125 */               this.tResult.SetText(df.format(tWorkCell.getNumericCellValue()));
/* 126 */               break;
/*     */             case 3:
/* 128 */               this.tResult.SetText("");
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 133 */         i++;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 137 */       e.printStackTrace();
/* 138 */       CError tError = new CError();
/* 139 */       tError.moduleName = "LAAddSubImportBL";
/* 140 */       tError.functionName = "readExcelFile";
/* 141 */       tError.errorMessage = ("\u951F\u65A4\u62F7\u951F\u65A4\u62F7Excel\u951F\u65A4\u62F7\u83A9\u951F\u65A4\u62F7,\u539F\u951F\u65A4\u62F7\u951F\u65A4\u62F7" + e);
/* 142 */       this.mErrors.addOneError(tError);
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean CheckCoordinate(String tTargetString)
/*     */   {
/* 155 */     if ((tTargetString == null) || (tTargetString.equals("")))
/*     */     {
/* 157 */       return false;
/*     */     }
/*     */ 
/* 161 */     char[] tCode = tTargetString.toUpperCase().toCharArray();
/*     */ 
/* 163 */     for (int i = 0; i < tCode.length; i++)
/*     */     {
/* 167 */       int tASC = tCode[i];
/*     */ 
/* 169 */       if ((tASC < 48) || (tASC > 90) || ((tASC > 57) && (tASC < 65)))
/*     */       {
/* 171 */         return false;
/*     */       }
/*     */ 
/* 174 */       if ((i == 0) && (tASC < 65))
/*     */       {
/* 176 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 180 */     return true;
/*     */   }
/*     */ 
/*     */   public double[][] GetCoordinate(String tTargetString)
/*     */   {
/* 186 */     double[][] tResult = { { 0.0D, 0.0D } };
/* 187 */     char[] tCode = tTargetString.toUpperCase().toCharArray();
/* 188 */     int tSplitKey = 0;
/* 189 */     int tASC = 0;
/* 190 */     double tMI = 0.0D;
/* 191 */     for (int i = 0; i < tCode.length; i++) {
/* 192 */       tASC = tCode[i];
/*     */ 
/* 195 */       if (tASC < 65) {
/* 196 */         tSplitKey = i;
/* 197 */         break;
/*     */       }
/*     */     }
/* 200 */     char[] tCol = tTargetString.substring(0, tSplitKey).toCharArray();
/* 201 */     for (int i = 0; i < tCol.length; i++) {
/* 202 */       tASC = tCode[i];
/* 203 */       int tColint = tCol.length - i - 1;
/* 204 */       tMI = tColint;
/*     */ 
/* 206 */       tResult[0][0] += Math.pow(26.0D, tMI) * (tASC - 64);
/*     */     }
/* 208 */     tResult[0][1] = Double.parseDouble(tTargetString.substring(tSplitKey, 
/* 209 */       tTargetString.length()));
/* 210 */     return tResult;
/*     */   }
/*     */ 
/*     */   private static String CheckFilePath(String tReportFile, String tFilePath)
/*     */   {
/* 216 */     File file = new File(tFilePath);
/* 217 */     if (!file.exists()) {
/* 218 */       return "\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u951F\u94F0\u51E4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u51A2\u951F\u65A4\u62F7\u951F\u997A\u51E4\u62F7\u6D17\u951F\u65A4\u62F7\u8DEF\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u786E\u951F\u65A4\u62F7 ";
/*     */     }
/*     */ 
/* 221 */     File file2 = new File(tFilePath, tReportFile);
/* 222 */     if (!file2.exists()) {
/* 223 */       return "Excel\u951F\u4FA5\u7877\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8282\uFF4F\u62F7\u951F\u65A4\u62F7\u786E\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7\u951F\u7A96\u6485\u62F7\u951F\u65A4\u62F7\u786E\u951F\u8F83\u8FBE\u62F7\u951F\u65A4\u62F7 ";
/*     */     }
/*     */ 
/* 226 */     return "Succ";
/*     */   }
/*     */ 
/*     */   public SSRS getExcelData()
/*     */   {
/* 233 */     return this.tResult;
/*     */   }
/*     */ 
/*     */   public CErrors getErrors()
/*     */   {
/* 238 */     return this.mErrors;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ExcelPubFun
 * JD-Core Version:    0.6.0
 */