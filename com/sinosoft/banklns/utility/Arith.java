/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class Arith
/*    */ {
/*    */   private static final int DEF_DIV_SCALE = 10;
/*    */ 
/*    */   public static double add(double v1, double v2)
/*    */   {
/* 13 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/* 14 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/* 15 */     return b1.add(b2).doubleValue();
/*    */   }
/*    */ 
/*    */   public static double sub(double v1, double v2) {
/* 19 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/* 20 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/* 21 */     return b1.subtract(b2).doubleValue();
/*    */   }
/*    */ 
/*    */   public static double mul(double v1, double v2)
/*    */   {
/* 26 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/* 27 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/* 28 */     return b1.multiply(b2).doubleValue();
/*    */   }
/*    */ 
/*    */   public static double div(double v1, double v2)
/*    */   {
/* 33 */     return div(v1, v2, 10);
/*    */   }
/*    */ 
/*    */   public static double div(double v1, double v2, int scale)
/*    */   {
/* 38 */     if (scale < 0) {
/* 39 */       throw new IllegalArgumentException(
/* 40 */         "The   scale   must   be   a   positive   integer   or   zero");
/*    */     }
/* 42 */     BigDecimal b1 = new BigDecimal(Double.toString(v1));
/* 43 */     BigDecimal b2 = new BigDecimal(Double.toString(v2));
/* 44 */     return b1.divide(b2, scale, 4).doubleValue();
/*    */   }
/*    */ 
/*    */   public static double round(double v, int scale)
/*    */   {
/* 49 */     if (scale < 0) {
/* 50 */       throw new IllegalArgumentException(
/* 51 */         "The   scale   must   be   a   positive   integer   or   zero");
/*    */     }
/* 53 */     BigDecimal b = new BigDecimal(Double.toString(v));
/* 54 */     BigDecimal one = new BigDecimal("1");
/* 55 */     return b.divide(one, scale, 4).doubleValue();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.Arith
 * JD-Core Version:    0.6.0
 */