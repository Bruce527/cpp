/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public final class CommonArray
/*    */ {
/*  7 */   private static final Logger logger = Logger.getLogger(CommonArray.class);
/*    */ 
/*    */   public static float[] stringToFloat(String[] strArray)
/*    */   {
/* 12 */     float[] ftArray = new float[strArray.length];
/*    */     try {
/* 14 */       for (int i = 0; i < strArray.length; i++)
/* 15 */         ftArray[i] = Float.parseFloat(strArray[i]);
/*    */     }
/*    */     catch (Exception e) {
/* 18 */       logger.error("changetofloat(String[])", e);
/* 19 */       if (logger.isDebugEnabled()) {
/* 20 */         logger.debug("changetofloat(String[]) - end");
/*    */       }
/* 22 */       return null;
/*    */     }
/*    */ 
/* 25 */     if (logger.isDebugEnabled()) {
/* 26 */       logger.debug("changetofloat(String[]) - end");
/*    */     }
/* 28 */     return ftArray;
/*    */   }
/*    */ 
/*    */   public static int[] stringToInt(String[] strArray)
/*    */   {
/* 33 */     int[] intArray = new int[strArray.length];
/*    */     try {
/* 35 */       for (int i = 0; i < strArray.length; i++)
/* 36 */         intArray[i] = Integer.parseInt(strArray[i]);
/*    */     }
/*    */     catch (Exception e) {
/* 39 */       logger.error("changetoInt(String[])", e);
/* 40 */       if (logger.isDebugEnabled()) {
/* 41 */         logger.debug("changetoInt(String[]) - end");
/*    */       }
/* 43 */       return null;
/*    */     }
/* 45 */     if (logger.isDebugEnabled()) {
/* 46 */       logger.debug("changetoInt(String[]) - end");
/*    */     }
/* 48 */     return intArray;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CommonArray
 * JD-Core Version:    0.6.0
 */