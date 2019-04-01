/*     */ package com.sinosoft.map.style.pdf;
/*     */ 
/*     */ import java.awt.Color;
/*     */ 
/*     */ public class FontStyle
/*     */ {
/*     */   public static final int COURIER = 0;
/*     */   public static final int HELVETICA = 1;
/*     */   public static final int TIMES_ROMAN = 2;
/*     */   public static final int SYMBOL = 3;
/*     */   public static final int ZAPFDINGBATS = 4;
/*     */   public static final int NORMAL = 0;
/*     */   public static final int BOLD = 1;
/*     */   public static final int ITALIC = 2;
/*     */   public static final int UNDERLINE = 4;
/*     */   public static final int STRIKETHRU = 8;
/*     */   public static final int BOLDITALIC = 3;
/*     */   public static final int UNDEFINED = -1;
/*     */   public static final int DEFAULTSIZE = 12;
/*     */   public static final int \u5B8B\u4F53 = 0;
/*     */   public static final int \u4EFF\u5B8B = 1;
/*     */   public static final int \u6977\u4F53 = 2;
/*     */   public static final int \u9ED1\u4F53 = 3;
/*     */   public static final int Arial = 4;
/*     */   public static final int Arial_BOLD = 5;
/*     */   public static final int Arial_ITALIC = 6;
/*     */   public static final int Arial_BOLDITALIC = 7;
/*     */   public static final int TAHOMA = 8;
/*  88 */   private int family = -1;
/*     */ 
/*  91 */   private float size = -1.0F;
/*     */ 
/*  94 */   private int style = -1;
/*     */ 
/*  97 */   private Color color = null;
/*     */ 
/*  99 */   private int fontName = 0;
/*     */ 
/*     */   public void setColor(Color color)
/*     */   {
/* 108 */     this.color = color;
/*     */   }
/*     */ 
/*     */   public void setColor(int red, int green, int blue)
/*     */   {
/* 114 */     this.color = new Color(red, green, blue);
/*     */   }
/*     */ 
/*     */   public void setSize(float size)
/*     */   {
/* 120 */     this.size = size;
/*     */   }
/*     */ 
/*     */   public void setStyle(int style)
/*     */   {
/* 126 */     if (style == -1)
/*     */     {
/* 128 */       this.style = 0;
/*     */     }
/*     */     else
/*     */     {
/* 132 */       this.style = style;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getStyle()
/*     */   {
/* 138 */     return this.style;
/*     */   }
/*     */ 
/*     */   public float getSize() {
/* 142 */     return this.size;
/*     */   }
/*     */ 
/*     */   public Color getColor() {
/* 146 */     return this.color;
/*     */   }
/*     */ 
/*     */   public void setFontName(int fontName)
/*     */   {
/* 151 */     this.fontName = fontName;
/*     */   }
/*     */ 
/*     */   public int getFontName()
/*     */   {
/* 156 */     return this.fontName;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.FontStyle
 * JD-Core Version:    0.6.0
 */