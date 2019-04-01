/*     */ package com.sinosoft.map.style.pdf;
/*     */ 
/*     */ import com.lowagie.text.Rectangle;
/*     */ 
/*     */ public class FileStyle
/*     */ {
/*   7 */   private float margin_left = 1.95F;
/*   8 */   private float margin_right = 1.95F;
/*   9 */   private float margin_top = 1.95F;
/*  10 */   private float margin_bottom = 0.75F;
/*  11 */   private float ratio = 2.54F;
/*  12 */   private float points = 72.0F;
/*     */   private Rectangle rect;
/*  17 */   private String password = null;
/*  18 */   private boolean havePassword = false;
/*  19 */   private boolean isAllowCopy = false;
/*  20 */   private boolean isAllowPrint = true;
/*     */ 
/*  22 */   private boolean headerOrFooterInFirst = false;
/*     */ 
/*     */   public void setMarginLeft(float ml)
/*     */   {
/*  30 */     this.margin_left = ml;
/*     */   }
/*     */ 
/*     */   public void setMarginRight(float mr)
/*     */   {
/*  35 */     this.margin_right = mr;
/*     */   }
/*     */ 
/*     */   public void setMarginTop(float mt)
/*     */   {
/*  41 */     this.margin_top = mt;
/*     */   }
/*     */ 
/*     */   public void setMarginBottom(float mb)
/*     */   {
/*  46 */     this.margin_bottom = mb;
/*     */   }
/*     */ 
/*     */   public float getMarginLeft()
/*     */   {
/*  51 */     return this.margin_left * this.points / this.ratio;
/*     */   }
/*     */ 
/*     */   public float getMarginRight()
/*     */   {
/*  56 */     return this.margin_right * this.points / this.ratio;
/*     */   }
/*     */ 
/*     */   public float getMarginTop()
/*     */   {
/*  61 */     return this.margin_top * this.points / this.ratio;
/*     */   }
/*     */ 
/*     */   public float getMarginBottom()
/*     */   {
/*  66 */     return this.margin_bottom * this.points / this.ratio;
/*     */   }
/*     */ 
/*     */   public void setPageSize(Rectangle rect)
/*     */   {
/*  71 */     this.rect = rect;
/*     */   }
/*     */ 
/*     */   public Rectangle getPageSize()
/*     */   {
/*  76 */     return this.rect;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/*  81 */     this.password = password;
/*  82 */     this.havePassword = true;
/*     */   }
/*     */ 
/*     */   public boolean isHavaPassword()
/*     */   {
/*  87 */     return this.havePassword;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  92 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setAllowPrint(boolean allowPrint)
/*     */   {
/*  97 */     this.isAllowPrint = allowPrint;
/*     */   }
/*     */ 
/*     */   public boolean isAllowPrint()
/*     */   {
/* 102 */     return this.isAllowPrint;
/*     */   }
/*     */ 
/*     */   public void setAllowCopy(boolean allowCopy)
/*     */   {
/* 107 */     this.isAllowCopy = allowCopy;
/*     */   }
/*     */ 
/*     */   public boolean isAllowCopy()
/*     */   {
/* 112 */     return this.isAllowCopy;
/*     */   }
/*     */ 
/*     */   public void setHeaderOrFooterInFirstPage(boolean inFirst)
/*     */   {
/* 117 */     this.headerOrFooterInFirst = inFirst;
/*     */   }
/*     */ 
/*     */   public boolean isHeaderOrFooterInFirstPage()
/*     */   {
/* 122 */     return this.headerOrFooterInFirst;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.FileStyle
 * JD-Core Version:    0.6.0
 */