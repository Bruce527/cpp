/*    */ package com.sinosoft.map.style.rtf;
/*    */ 
/*    */ public class TitleStyle extends FontStyle
/*    */ {
/* 10 */   private float size = -1.0F;
/* 11 */   private int px = 0;
/* 12 */   private int py = 0;
/* 13 */   private int align = 0;
/*    */   public static final int ALIGN_CENTER = 1;
/*    */   public static final int ALIGN_LEFT = 0;
/*    */   public static final int ALIGN_RIGHT = 2;
/*    */ 
/*    */   public void setSize(float size)
/*    */   {
/* 29 */     this.size = size;
/*    */   }
/*    */ 
/*    */   public float getSize() {
/* 33 */     return this.size;
/*    */   }
/*    */ 
/*    */   public void setPx(int px) {
/* 37 */     this.px = px;
/*    */   }
/*    */ 
/*    */   public void setPy(int py) {
/* 41 */     this.py = py;
/*    */   }
/*    */ 
/*    */   public int getPx() {
/* 45 */     return this.px;
/*    */   }
/*    */ 
/*    */   public int getPy() {
/* 49 */     return this.py;
/*    */   }
/*    */ 
/*    */   public void setAlign(int align) {
/* 53 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign() {
/* 57 */     return this.align;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.TitleStyle
 * JD-Core Version:    0.6.0
 */