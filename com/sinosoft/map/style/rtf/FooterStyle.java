/*    */ package com.sinosoft.map.style.rtf;
/*    */ 
/*    */ public class FooterStyle extends FontStyle
/*    */ {
/*  7 */   private int align = 1;
/*  8 */   private boolean numbered = false;
/*  9 */   private int border = 0;
/*    */ 
/*    */   public void setAlign(int align)
/*    */   {
/* 16 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign()
/*    */   {
/* 21 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setNumbered(boolean numbered)
/*    */   {
/* 26 */     this.numbered = numbered;
/*    */   }
/*    */ 
/*    */   public boolean getBumbered()
/*    */   {
/* 31 */     return this.numbered;
/*    */   }
/*    */ 
/*    */   public void setBorder(int border)
/*    */   {
/* 36 */     this.border = border;
/*    */   }
/*    */ 
/*    */   public int getBorder()
/*    */   {
/* 41 */     return this.border;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.FooterStyle
 * JD-Core Version:    0.6.0
 */