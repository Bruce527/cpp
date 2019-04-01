/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ public class Header
/*    */ {
/*    */   private String name;
/*    */   private int col;
/*    */   private int row;
/*    */   private int order;
/*    */   private int wsorder;
/* 11 */   private int excit = 0;
/* 12 */   private int parentIndex = -1;
/*    */   private String codeName;
/*    */ 
/*    */   public String getCodeName()
/*    */   {
/* 15 */     return this.codeName;
/*    */   }
/*    */   public void setCodeName(String codeName) {
/* 18 */     this.codeName = codeName;
/*    */   }
/*    */   public int getCol() {
/* 21 */     return this.col;
/*    */   }
/*    */   public void setCol(int col) {
/* 24 */     this.col = col;
/*    */   }
/*    */   public int isExcit() {
/* 27 */     return this.excit;
/*    */   }
/*    */   public void setExcit(int excit) {
/* 30 */     this.excit = excit;
/*    */   }
/*    */   public String getName() {
/* 33 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 36 */     this.name = name;
/*    */   }
/*    */   public int getOrder() {
/* 39 */     return this.order;
/*    */   }
/*    */   public void setOrder(int order) {
/* 42 */     this.order = order;
/*    */   }
/*    */   public int getParentIndex() {
/* 45 */     return this.parentIndex;
/*    */   }
/*    */   public void setParentIndex(int parentIndex) {
/* 48 */     this.parentIndex = parentIndex;
/*    */   }
/*    */   public int getRow() {
/* 51 */     return this.row;
/*    */   }
/*    */   public void setRow(int row) {
/* 54 */     this.row = row;
/*    */   }
/*    */   public int getExcit() {
/* 57 */     return this.excit;
/*    */   }
/*    */   public int getWsorder() {
/* 60 */     return this.wsorder;
/*    */   }
/*    */   public void setWsorder(int wsorder) {
/* 63 */     this.wsorder = wsorder;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.Header
 * JD-Core Version:    0.6.0
 */