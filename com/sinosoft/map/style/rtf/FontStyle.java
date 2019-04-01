/*     */ package com.sinosoft.map.style.rtf;
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
/*  59 */   private int family = -1;
/*     */ 
/*  62 */   private float size = -1.0F;
/*     */ 
/*  65 */   private int style = -1;
/*     */ 
/*  68 */   private Color color = null;
/*     */ 
/*  73 */   private String familyName = "Comic Sans MS";
/*     */ 
/*     */   public void setColor(Color color)
/*     */   {
/*  78 */     this.color = color;
/*     */   }
/*     */ 
/*     */   public void setColor(int red, int green, int blue)
/*     */   {
/*  84 */     this.color = new Color(red, green, blue);
/*     */   }
/*     */ 
/*     */   public void setSize(float size)
/*     */   {
/*  90 */     this.size = size;
/*     */   }
/*     */ 
/*     */   public void setStyle(int style)
/*     */   {
/*  99 */     if (style == -1)
/* 100 */       this.style = 0;
/*     */     else
/* 102 */       this.style = getStyleValue(style);
/*     */   }
/*     */ 
/*     */   public int getStyle()
/*     */   {
/* 108 */     return this.style;
/*     */   }
/*     */ 
/*     */   public float getSize() {
/* 112 */     return this.size;
/*     */   }
/*     */ 
/*     */   public Color getColor() {
/* 116 */     return this.color;
/*     */   }
/*     */ 
/*     */   public String getFamilyName() {
/* 120 */     return this.familyName;
/*     */   }
/*     */ 
/*     */   private int getStyleValue(int style) {
/* 124 */     switch (style) {
/*     */     case 1:
/* 126 */       return 1;
/*     */     case 2:
/* 128 */       return 2;
/*     */     }
/* 130 */     return 0;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.rtf.FontStyle
 * JD-Core Version:    0.6.0
 */