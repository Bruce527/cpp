/*    */ package com.sinosoft.map.style.rtf;
/*    */ 
/*    */ import com.lowagie.text.Rectangle;
/*    */ 
/*    */ public class FileStyle
/*    */ {
/*  5 */   private float margin_left = 1.95F;
/*  6 */   private float margin_right = 1.95F;
/*  7 */   private float margin_top = 1.95F;
/*  8 */   private float margin_bottom = 0.75F;
/*  9 */   private float ratio = 2.54F;
/* 10 */   private float points = 72.0F;
/*    */   private Rectangle rect;
/*    */ 
/*    */   public void setMarginLeft(float ml)
/*    */   {
/* 18 */     this.margin_left = ml;
/*    */   }
/*    */ 
/*    */   public void setMarginRight(float mr)
/*    */   {
/* 23 */     this.margin_right = mr;
/*    */   }
/*    */ 
/*    */   public void setMarginTop(float mt)
/*    */   {
/* 29 */     this.margin_top = mt;
/*    */   }
/*    */ 
/*    */   public void setMarginBottom(float mb)
/*    */   {
/* 34 */     this.margin_bottom = mb;
/*    */   }
/*    */ 
/*    */   public float getMarginLeft()
/*    */   {
/* 39 */     return this.margin_left * this.points / this.ratio;
/*    */   }
/*    */ 
/*    */   public float getMarginRight()
/*    */   {
/* 44 */     return this.margin_right * this.points / this.ratio;
/*    */   }
/*    */ 
/*    */   public float getMarginTop()
/*    */   {
/* 49 */     return this.margin_top * this.points / this.ratio;
/*    */   }
/*    */ 
/*    */   public float getMarginBottom()
/*    */   {
/* 54 */     return this.margin_bottom * this.points / this.ratio;
/*    */   }
/*    */ 
/*    */   public void setPageSize(Rectangle rect)
/*    */   {
/* 59 */     this.rect = rect;
/*    */   }
/*    */ 
/*    */   public Rectangle getPageSize()
/*    */   {
/* 64 */     return this.rect;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.FileStyle
 * JD-Core Version:    0.6.0
 */