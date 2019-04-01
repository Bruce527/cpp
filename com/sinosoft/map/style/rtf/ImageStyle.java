/*     */ package com.sinosoft.map.style.rtf;
/*     */ 
/*     */ public class ImageStyle
/*     */ {
/*     */   public static final int ALIGN_CENTER = 1;
/*     */   public static final int ALIGN_LEFT = 0;
/*     */   public static final int ALIGN_RIGHT = 2;
/*     */   public static final int ALIGN_TOP = 4;
/*     */   public static final int ALIGN_BOTTOM = 6;
/*  20 */   private String type = "";
/*  21 */   private int align = 0;
/*     */   private float size;
/*     */   private float px;
/*     */   private float py;
/*     */   private float sx;
/*     */   private float sy;
/*  27 */   private boolean absolute = false;
/*  28 */   private boolean fixScale = true;
/*     */ 
/*     */   public void setImageType(String type)
/*     */   {
/*  35 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getImageType()
/*     */   {
/*  40 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setAlign(int align)
/*     */   {
/*  45 */     this.align = align;
/*     */   }
/*     */ 
/*     */   public int getAlign()
/*     */   {
/*  50 */     return this.align;
/*     */   }
/*     */ 
/*     */   public void setPx(float px)
/*     */   {
/*  55 */     this.px = px;
/*  56 */     this.absolute = true;
/*     */   }
/*     */ 
/*     */   public void setPy(float py)
/*     */   {
/*  61 */     this.py = py;
/*  62 */     this.absolute = true;
/*     */   }
/*     */ 
/*     */   public float getPx()
/*     */   {
/*  67 */     return this.px;
/*     */   }
/*     */ 
/*     */   public float getPy()
/*     */   {
/*  72 */     return this.py;
/*     */   }
/*     */ 
/*     */   public void setScalePercent(float size)
/*     */   {
/*  77 */     this.size = size;
/*     */   }
/*     */ 
/*     */   public float getScalePercent()
/*     */   {
/*  82 */     return this.size;
/*     */   }
/*     */ 
/*     */   public boolean getAbsolute()
/*     */   {
/*  87 */     return this.absolute;
/*     */   }
/*     */ 
/*     */   public boolean getfixScale()
/*     */   {
/*  93 */     return this.fixScale;
/*     */   }
/*     */ 
/*     */   public void setSx(float sx)
/*     */   {
/* 100 */     this.sx = sx;
/* 101 */     this.fixScale = false;
/*     */   }
/*     */ 
/*     */   public void setSy(float sy)
/*     */   {
/* 106 */     this.sy = sy;
/* 107 */     this.fixScale = false;
/*     */   }
/*     */ 
/*     */   public float getSx()
/*     */   {
/* 112 */     return this.sx;
/*     */   }
/*     */ 
/*     */   public float getSy()
/*     */   {
/* 117 */     return this.sy;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.ImageStyle
 * JD-Core Version:    0.6.0
 */