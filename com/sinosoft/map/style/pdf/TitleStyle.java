/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class TitleStyle extends FontStyle
/*    */ {
/*  9 */   private float size = -1.0F;
/* 10 */   private float px = 0.0F;
/* 11 */   private float py = 0.0F;
/* 12 */   private int align = 0;
/*    */   public static final int ALIGN_CENTER = 1;
/*    */   public static final int ALIGN_LEFT = 0;
/*    */   public static final int ALIGN_RIGHT = 2;
/*    */ 
/*    */   public void setSize(float size)
/*    */   {
/* 28 */     this.size = size;
/*    */   }
/*    */ 
/*    */   public float getSize() {
/* 32 */     return this.size;
/*    */   }
/*    */ 
/*    */   public void setPx(float px) {
/* 36 */     this.px = px;
/*    */   }
/*    */ 
/*    */   public void setPy(float py) {
/* 40 */     this.py = py;
/*    */   }
/*    */ 
/*    */   public float getPx() {
/* 44 */     return this.px;
/*    */   }
/*    */ 
/*    */   public float getPy() {
/* 48 */     return this.py;
/*    */   }
/*    */ 
/*    */   public void setAlign(int align) {
/* 52 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign() {
/* 56 */     return this.align;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.TitleStyle
 * JD-Core Version:    0.6.0
 */