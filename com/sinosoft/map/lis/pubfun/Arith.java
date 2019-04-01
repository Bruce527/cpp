/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class Arith
/*     */ {
/*     */   private static final int DEF_DIV_SCALE = 10;
/*     */ 
/*     */   public static double add(double v1, double v2)
/*     */   {
/*  36 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  38 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  40 */     return b1.add(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double sub(double v1, double v2)
/*     */   {
/*  53 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  55 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  57 */     return b1.subtract(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double mul(double v1, double v2)
/*     */   {
/*  70 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  72 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  74 */     return b1.multiply(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double div(double v1, double v2)
/*     */   {
/*  88 */     return div(v1, v2, 10);
/*     */   }
/*     */ 
/*     */   public static double div(double v1, double v2, int scale)
/*     */   {
/* 103 */     if (scale < 0)
/*     */     {
/* 106 */       throw new IllegalArgumentException(
/* 108 */         "The scale must be a positive integer or zero");
/*     */     }
/*     */ 
/* 112 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/* 114 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/* 116 */     return b1.divide(b2, scale, 4).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double round(double v, int scale)
/*     */   {
/* 129 */     if (scale < 0)
/*     */     {
/* 132 */       throw new IllegalArgumentException(
/* 134 */         "The scale must be a positive integer or zero");
/*     */     }
/*     */ 
/* 138 */     BigDecimal b = new BigDecimal(Double.toString(v));
/*     */ 
/* 140 */     BigDecimal one = new BigDecimal("1");
/*     */ 
/* 142 */     return b.divide(one, scale, 4).doubleValue();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.Arith
 * JD-Core Version:    0.6.0
 */