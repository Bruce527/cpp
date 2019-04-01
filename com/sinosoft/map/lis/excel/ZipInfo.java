/*    */ package com.sinosoft.map.lis.excel;
/*    */ 
/*    */ public class ZipInfo
/*    */ {
/* 15 */   String zipPath = null;
/*    */ 
/* 17 */   boolean zipExists = false;
/*    */ 
/* 19 */   long modifyTime = 0L;
/*    */ 
/* 21 */   String zipName = null;
/*    */ 
/*    */   public String getReportName()
/*    */   {
/* 28 */     return this.zipName;
/*    */   }
/*    */ 
/*    */   public String getReportPath() {
/* 32 */     return this.zipPath;
/*    */   }
/*    */ 
/*    */   public boolean exists() {
/* 36 */     return this.zipExists;
/*    */   }
/*    */ 
/*    */   public long getModifyTime() {
/* 40 */     return this.modifyTime;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.ZipInfo
 * JD-Core Version:    0.6.0
 */