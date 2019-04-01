/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class Arith
/*     */ {
/*     */   private static final int DEF_DIV_SCALE = 10;
/*     */ 
/*     */   public static double add(double v1, double v2)
/*     */   {
/*  18 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  20 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  22 */     return b1.add(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double sub(double v1, double v2)
/*     */   {
/*  30 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  32 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  34 */     return b1.subtract(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double mul(double v1, double v2)
/*     */   {
/*  43 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  45 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  47 */     return b1.multiply(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double div(double v1, double v2)
/*     */   {
/*  59 */     return div(v1, v2, 10);
/*     */   }
/*     */ 
/*     */   public static double div(double v1, double v2, int scale)
/*     */   {
/*  66 */     if (scale < 0)
/*     */     {
/*  68 */       throw new IllegalArgumentException(
/*  69 */         "The scale must be a positive integer or zero");
/*     */     }
/*     */ 
/*  73 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/*     */ 
/*  75 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/*     */ 
/*  77 */     return b1.divide(b2, scale, 4).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double round(double v, int scale)
/*     */   {
/*  85 */     if (scale < 0)
/*     */     {
/*  87 */       throw new IllegalArgumentException(
/*  88 */         "The scale must be a positive integer or zero");
/*     */     }
/*     */ 
/*  92 */     BigDecimal b = new BigDecimal(Double.toString(v));
/*     */ 
/*  94 */     BigDecimal one = new BigDecimal("1");
/*     */ 
/*  96 */     return b.divide(one, scale, 4).doubleValue();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 101 */     System.out.println((int)round(123.407D, 0));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.Arith
 * JD-Core Version:    0.6.0
 */