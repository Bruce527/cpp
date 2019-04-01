/*    */ package com.sinosoft.map.style.xls;
/*    */ 
/*    */ public class TableHeadStyle extends FontStyle
/*    */ {
/*    */   private int[] c;
/*    */   private int col;
/*    */ 
/*    */   public void setWidths(int[] c)
/*    */   {
/* 13 */     this.c = c;
/*    */   }
/*    */ 
/*    */   public int[] getWidths()
/*    */   {
/* 18 */     return this.c;
/*    */   }
/*    */ 
/*    */   public void setCol(int col)
/*    */   {
/* 23 */     this.col = col;
/*    */   }
/*    */ 
/*    */   public int getCol()
/*    */   {
/* 28 */     return this.col;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.xls.TableHeadStyle
 * JD-Core Version:    0.6.0
 */