/*    */ package com.sinosoft.map.style.xls;
/*    */ 
/*    */ public class SheetStyle extends FontStyle
/*    */ {
/*  5 */   private String sheetName = "";
/*  6 */   private int sheetNo = 0;
/*    */ 
/*    */   public void setSheetName(String name)
/*    */   {
/* 13 */     this.sheetName = name;
/*    */   }
/*    */ 
/*    */   public String getSheetName() {
/* 17 */     return this.sheetName;
/*    */   }
/*    */ 
/*    */   public void setSheetNo(int no) {
/* 21 */     this.sheetNo = no;
/*    */   }
/*    */ 
/*    */   public int getSheetNo() {
/* 25 */     return this.sheetNo;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.xls.SheetStyle
 * JD-Core Version:    0.6.0
 */