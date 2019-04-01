/*     */ package com.sinosoft.map.style.rtf;
/*     */ 
/*     */ public class TableHeadStyle extends FontStyle
/*     */ {
/*     */   private float[] c;
/*     */   private float width;
/*     */   private int col;
/*   7 */   private int border = 1;
/*   8 */   private int pad = 1;
/*   9 */   private int spa = 1;
/*  10 */   private int align = 1;
/*  11 */   private int R = 255;
/*  12 */   private int G = 255;
/*  13 */   private int B = 255;
/*     */ 
/*     */   public void setWidths(float[] c)
/*     */   {
/*  20 */     this.c = c;
/*     */   }
/*     */ 
/*     */   public float[] getWidths()
/*     */   {
/*  25 */     return this.c;
/*     */   }
/*     */ 
/*     */   public void setWidth(float width)
/*     */   {
/*  30 */     this.width = width;
/*     */   }
/*     */ 
/*     */   public float getWidth()
/*     */   {
/*  35 */     return this.width;
/*     */   }
/*     */ 
/*     */   public void setCol(int col)
/*     */   {
/*  40 */     this.col = col;
/*     */   }
/*     */ 
/*     */   public int getCol()
/*     */   {
/*  45 */     return this.col;
/*     */   }
/*     */ 
/*     */   public void setBorder(int boder)
/*     */   {
/*  50 */     this.border = this.border;
/*     */   }
/*     */ 
/*     */   public int getBorder()
/*     */   {
/*  55 */     return this.border;
/*     */   }
/*     */ 
/*     */   public void setPadding(int pad)
/*     */   {
/*  60 */     this.pad = pad;
/*     */   }
/*     */ 
/*     */   public int getPadding()
/*     */   {
/*  65 */     return this.pad;
/*     */   }
/*     */ 
/*     */   public void setSpacing(int spa)
/*     */   {
/*  70 */     this.spa = spa;
/*     */   }
/*     */ 
/*     */   public int getSpacing()
/*     */   {
/*  75 */     return this.spa;
/*     */   }
/*     */ 
/*     */   public void setAlign(int align)
/*     */   {
/*  80 */     this.align = align;
/*     */   }
/*     */ 
/*     */   public int getAlign()
/*     */   {
/*  85 */     return this.align;
/*     */   }
/*     */ 
/*     */   public void setR(int R)
/*     */   {
/*  90 */     this.R = R;
/*     */   }
/*     */ 
/*     */   public int getR() {
/*  94 */     return this.R;
/*     */   }
/*     */ 
/*     */   public void setG(int G) {
/*  98 */     this.G = G;
/*     */   }
/*     */ 
/*     */   public int getG() {
/* 102 */     return this.G;
/*     */   }
/*     */ 
/*     */   public void setB(int B) {
/* 106 */     this.B = B;
/*     */   }
/*     */ 
/*     */   public int getB() {
/* 110 */     return this.B;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.TableHeadStyle
 * JD-Core Version:    0.6.0
 */