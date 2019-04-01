/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class TextStyle extends FontStyle
/*    */ {
/*  7 */   private int align = 0;
/*    */ 
/*  9 */   private float leading = 0.0F;
/*    */ 
/* 12 */   private boolean isAlone = true;
/*    */ 
/* 14 */   private boolean isStart = true;
/*    */ 
/* 16 */   private boolean isEnd = true;
/*    */ 
/*    */   public void setAlign(int align)
/*    */   {
/* 23 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign() {
/* 27 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setLeading(float leading)
/*    */   {
/* 32 */     this.leading = leading;
/*    */   }
/*    */ 
/*    */   public float getLeading()
/*    */   {
/* 37 */     return this.leading;
/*    */   }
/*    */   public boolean isAlone() {
/* 40 */     return this.isAlone;
/*    */   }
/*    */   public void setAlone(boolean isAlone) {
/* 43 */     this.isAlone = isAlone;
/*    */   }
/*    */   public boolean isEnd() {
/* 46 */     return this.isEnd;
/*    */   }
/*    */   public void setEnd(boolean isEnd) {
/* 49 */     this.isEnd = isEnd;
/*    */   }
/*    */   public boolean isStart() {
/* 52 */     return this.isStart;
/*    */   }
/*    */   public void setStart(boolean isStart) {
/* 55 */     this.isStart = isStart;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.TextStyle
 * JD-Core Version:    0.6.0
 */