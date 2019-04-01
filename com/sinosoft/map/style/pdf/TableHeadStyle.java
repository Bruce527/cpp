/*     */ package com.sinosoft.map.style.pdf;
/*     */ 
/*     */ public class TableHeadStyle extends FontStyle
/*     */ {
/*     */   private float[] c;
/*     */   private float width;
/*     */   private int col;
/*  11 */   private int border = 15;
/*  12 */   private int pad = 1;
/*  13 */   private int spa = 1;
/*  14 */   private int align = 1;
/*  15 */   private int tablealign = 1;
/*  16 */   private int R = 255;
/*  17 */   private int G = 255;
/*  18 */   private int B = 255;
/*  19 */   private int headType = 0;
/*  20 */   private int headRows = 1;
/*  21 */   private boolean tablebody = true;
/*     */ 
/*  24 */   private float px = 0.0F;
/*  25 */   private float py = 0.0F;
/*  26 */   private boolean absolutTable = false;
/*     */ 
/*     */   public void setWidths(float[] c)
/*     */   {
/*  35 */     this.c = c;
/*     */   }
/*     */ 
/*     */   public float[] getWidths()
/*     */   {
/*  40 */     return this.c;
/*     */   }
/*     */ 
/*     */   public void setWidth(float width)
/*     */   {
/*  45 */     this.width = width;
/*     */   }
/*     */ 
/*     */   public float getWidth()
/*     */   {
/*  50 */     return this.width;
/*     */   }
/*     */ 
/*     */   public void setCol(int col)
/*     */   {
/*  55 */     this.col = col;
/*     */   }
/*     */ 
/*     */   public int getCol()
/*     */   {
/*  60 */     return this.col;
/*     */   }
/*     */ 
/*     */   public void setBorder(int boder)
/*     */   {
/*  65 */     this.border = boder;
/*     */   }
/*     */ 
/*     */   public int getBorder()
/*     */   {
/*  70 */     return this.border;
/*     */   }
/*     */ 
/*     */   public void setPadding(int pad)
/*     */   {
/*  75 */     this.pad = pad;
/*     */   }
/*     */ 
/*     */   public int getPadding()
/*     */   {
/*  80 */     return this.pad;
/*     */   }
/*     */ 
/*     */   public void setSpacing(int spa)
/*     */   {
/*  85 */     this.spa = spa;
/*     */   }
/*     */ 
/*     */   public int getSpacing()
/*     */   {
/*  90 */     return this.spa;
/*     */   }
/*     */ 
/*     */   public void setAlign(int align)
/*     */   {
/*  95 */     this.align = align;
/*     */   }
/*     */ 
/*     */   public int getAlign()
/*     */   {
/* 100 */     return this.align;
/*     */   }
/*     */ 
/*     */   public void setR(int R)
/*     */   {
/* 105 */     this.R = R;
/*     */   }
/*     */   public int getR() {
/* 108 */     return this.R;
/*     */   }
/*     */   public void setG(int G) {
/* 111 */     this.G = G;
/*     */   }
/*     */   public int getG() {
/* 114 */     return this.G;
/*     */   }
/*     */   public void setB(int B) {
/* 117 */     this.B = B;
/*     */   }
/*     */   public int getB() {
/* 120 */     return this.B;
/*     */   }
/*     */ 
/*     */   public void setTableAlign(int align)
/*     */   {
/* 125 */     this.tablealign = align;
/*     */   }
/*     */ 
/*     */   public int getTableAlign()
/*     */   {
/* 130 */     return this.tablealign;
/*     */   }
/*     */ 
/*     */   public void setheadType(int headType)
/*     */   {
/* 136 */     this.headType = headType;
/*     */   }
/*     */ 
/*     */   public int getheadType()
/*     */   {
/* 141 */     return this.headType;
/*     */   }
/*     */ 
/*     */   public void setHeaderRows(int rows)
/*     */   {
/* 146 */     this.headRows = rows;
/*     */   }
/*     */ 
/*     */   public int getHeaderRows() {
/* 150 */     return this.headRows;
/*     */   }
/*     */ 
/*     */   public void setTableBodyFalg(boolean haveBody)
/*     */   {
/* 155 */     this.tablebody = haveBody;
/*     */   }
/*     */ 
/*     */   public boolean haveTableBody()
/*     */   {
/* 160 */     return this.tablebody;
/*     */   }
/*     */ 
/*     */   public void setAbsolutTable(float x, float y)
/*     */   {
/* 165 */     this.px = x;
/* 166 */     this.py = y;
/* 167 */     this.absolutTable = true;
/*     */   }
/*     */ 
/*     */   public boolean isAbsolutTable() {
/* 171 */     return this.absolutTable;
/*     */   }
/*     */ 
/*     */   public float getX() {
/* 175 */     return this.px;
/*     */   }
/*     */ 
/*     */   public float getY() {
/* 179 */     return this.py;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.TableHeadStyle
 * JD-Core Version:    0.6.0
 */