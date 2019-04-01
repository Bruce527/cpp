/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ public class ExcelInfo
/*    */ {
/* 10 */   String excelPath = null;
/*    */ 
/* 12 */   boolean excelExists = false;
/*    */ 
/* 14 */   long modifyTime = 0L;
/*    */ 
/* 16 */   String excelName = null;
/*    */ 
/*    */   public String getReportName()
/*    */   {
/* 23 */     return this.excelName;
/*    */   }
/*    */ 
/*    */   public String getReportPath() {
/* 27 */     return this.excelPath;
/*    */   }
/*    */ 
/*    */   public boolean exists() {
/* 31 */     return this.excelExists;
/*    */   }
/*    */ 
/*    */   public long getModifyTime() {
/* 35 */     return this.modifyTime;
/*    */   }
/*    */ 
/*    */   public void setReportName(String name) {
/* 39 */     this.excelName = name;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.ExcelInfo
 * JD-Core Version:    0.6.0
 */