/*    */ package com.sinosoft.map.style.xls;
/*    */ 
/*    */ import com.sinosoft.map.utility.VData;
/*    */ 
/*    */ public class FileStyle extends FontStyle
/*    */ {
/*  6 */   private VData sheetName = new VData();
/*  7 */   private String modelPath = "";
/*  8 */   private int numSheets = 0;
/*    */ 
/*    */   public void setNumSheets(int num) {
/* 11 */     this.numSheets = num;
/*    */   }
/*    */ 
/*    */   public int getNumSheets() {
/* 15 */     return this.numSheets;
/*    */   }
/*    */ 
/*    */   public void setSheetName(String name) {
/* 19 */     this.sheetName.add(name);
/*    */   }
/*    */ 
/*    */   public String getSheetName(int i) {
/* 23 */     return (String)this.sheetName.get(i);
/*    */   }
/*    */ 
/*    */   public void setModelPath(String path) {
/* 27 */     this.modelPath = path;
/*    */   }
/*    */ 
/*    */   public String getModelPath() {
/* 31 */     return this.modelPath;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.xls.FileStyle
 * JD-Core Version:    0.6.0
 */