/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class OnlyTableBodyStyle extends TableBodyStyle
/*    */ {
/*  5 */   private float width = 100.0F;
/*    */   private int col;
/*  9 */   private int pad = 10;
/*    */ 
/* 11 */   private int spa = 0;
/*    */ 
/* 13 */   private int tablealign = 1;
/*    */ 
/* 15 */   private int fontName = 0;
/*    */ 
/*    */   public void setWidth(float width)
/*    */   {
/* 22 */     this.width = width;
/*    */   }
/*    */ 
/*    */   public float getWidth()
/*    */   {
/* 27 */     return this.width;
/*    */   }
/*    */ 
/*    */   public void setCol(int col)
/*    */   {
/* 32 */     this.col = col;
/*    */   }
/*    */ 
/*    */   public int getCol()
/*    */   {
/* 37 */     return this.col;
/*    */   }
/*    */ 
/*    */   public void setPadding(int pad)
/*    */   {
/* 42 */     this.pad = pad;
/*    */   }
/*    */ 
/*    */   public int getPadding()
/*    */   {
/* 47 */     return this.pad;
/*    */   }
/*    */ 
/*    */   public void setSpacing(int spa)
/*    */   {
/* 52 */     this.spa = spa;
/*    */   }
/*    */ 
/*    */   public int getSpacing()
/*    */   {
/* 57 */     return this.spa;
/*    */   }
/*    */ 
/*    */   public void setTableAlign(int align)
/*    */   {
/* 62 */     this.tablealign = align;
/*    */   }
/*    */ 
/*    */   public int getTableAlign()
/*    */   {
/* 67 */     return this.tablealign;
/*    */   }
/*    */ 
/*    */   public void setFontName(int fontnmae)
/*    */   {
/* 72 */     this.fontName = fontnmae;
/*    */   }
/*    */ 
/*    */   public int getFontName()
/*    */   {
/* 77 */     return this.fontName;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.OnlyTableBodyStyle
 * JD-Core Version:    0.6.0
 */