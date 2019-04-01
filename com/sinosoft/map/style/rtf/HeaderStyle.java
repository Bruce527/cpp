/*    */ package com.sinosoft.map.style.rtf;
/*    */ 
/*    */ public class HeaderStyle extends FontStyle
/*    */ {
/*  7 */   private int align = 1;
/*  8 */   private float leading = (0.0F / 0.0F);
/*  9 */   private boolean numbered = false;
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
/*    */   public void setLeading(float leading)
/*    */   {
/* 26 */     this.leading = leading;
/*    */   }
/*    */ 
/*    */   public float getLeading()
/*    */   {
/* 31 */     return this.leading;
/*    */   }
/*    */ 
/*    */   public void setNumbered(boolean numbered)
/*    */   {
/* 36 */     this.numbered = numbered;
/*    */   }
/*    */ 
/*    */   public boolean getBumbered()
/*    */   {
/* 41 */     return this.numbered;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.HeaderStyle
 * JD-Core Version:    0.6.0
 */