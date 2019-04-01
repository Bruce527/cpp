/*     */ package com.sinosoft.map.style.pdf;
/*     */ 
/*     */ public class TableBodyStyle extends FontStyle
/*     */ {
/*     */   private int align;
/*   9 */   private int border = 15;
/*  10 */   private int R = 255;
/*  11 */   private int G = 255;
/*  12 */   private int B = 255;
/*  13 */   private int bodyType = 0;
/*  14 */   private boolean isPdfpTable = false;
/*     */ 
/*  17 */   private boolean hasHead = true;
/*     */   private float pad;
/*     */   private float[] widths;
/*     */ 
/*     */   public void setBorder(int border)
/*     */   {
/*  29 */     this.border = border;
/*     */   }
/*     */ 
/*     */   public int getBorder()
/*     */   {
/*  34 */     return this.border;
/*     */   }
/*     */ 
/*     */   public void setAlign(int align)
/*     */   {
/*  41 */     this.align = align;
/*     */   }
/*     */ 
/*     */   public int getAlign()
/*     */   {
/*  46 */     return this.align;
/*     */   }
/*     */ 
/*     */   public void setR(int R)
/*     */   {
/*  51 */     this.R = R;
/*     */   }
/*     */   public int getR() {
/*  54 */     return this.R;
/*     */   }
/*     */   public void setG(int G) {
/*  57 */     this.G = G;
/*     */   }
/*     */   public int getG() {
/*  60 */     return this.G;
/*     */   }
/*     */   public void setB(int B) {
/*  63 */     this.B = B;
/*     */   }
/*     */   public int getB() {
/*  66 */     return this.B;
/*     */   }
/*     */ 
/*     */   public void setBodyType(int bodytype)
/*     */   {
/*  73 */     this.bodyType = bodytype;
/*     */   }
/*     */ 
/*     */   public int getBodyType()
/*     */   {
/*  78 */     return this.bodyType;
/*     */   }
/*     */ 
/*     */   public void setUsePdfPTable(boolean pdfpTable)
/*     */   {
/*  83 */     this.isPdfpTable = pdfpTable;
/*     */   }
/*     */ 
/*     */   public boolean isUsePdfPTable()
/*     */   {
/*  88 */     return this.isPdfpTable;
/*     */   }
/*     */   public boolean isHasHead() {
/*  91 */     return this.hasHead;
/*     */   }
/*     */   public void setHasHead(boolean hasHead) {
/*  94 */     this.hasHead = hasHead;
/*     */   }
/*     */   public float[] getWidths() {
/*  97 */     return this.widths;
/*     */   }
/*     */   public void setWidths(float[] widths) {
/* 100 */     this.widths = widths;
/*     */   }
/*     */   public float getPad() {
/* 103 */     return this.pad;
/*     */   }
/*     */   public void setPad(float pad) {
/* 106 */     this.pad = pad;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.TableBodyStyle
 * JD-Core Version:    0.6.0
 */