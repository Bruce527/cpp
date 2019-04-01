/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class VData extends Vector
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/*  36 */     String strReturn = "";
/*     */ 
/*  38 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public Object getObjectByObjectName(String cObjectName, int cStartPos)
/*     */   {
/*  49 */     int i = 0; int iMax = 0;
/*  50 */     String tStr1 = ""; String tStr2 = "";
/*  51 */     Object tReturn = null;
/*  52 */     if (cStartPos < 0)
/*     */     {
/*  54 */       cStartPos = 0;
/*     */     }
/*  56 */     iMax = size();
/*     */     try
/*     */     {
/*  59 */       for (i = cStartPos; i < iMax; i++)
/*     */       {
/*  61 */         tStr1 = get(i).getClass().getName().toUpperCase();
/*  62 */         tStr2 = cObjectName.toUpperCase();
/*  63 */         if ((!tStr1.equals(tStr2)) && (!getLastWord(tStr1, ".").equals(tStr2)))
/*     */           continue;
/*  65 */         tReturn = get(i);
/*  66 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  72 */       tReturn = null;
/*     */     }
/*  74 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String getLastWord(String cStr, String splitStr)
/*     */   {
/*  82 */     int tIndex = -1; int tIndexOld = -1;
/*  83 */     String tReturn = cStr;
/*     */     try
/*     */     {
/*     */       while (true)
/*     */       {
/*  88 */         tIndex = tReturn.indexOf(splitStr, tIndex + 1);
/*  89 */         if (tIndex <= 0) break;
/*  90 */         tIndexOld = tIndex;
/*     */       }
/*     */ 
/*  94 */       if (tIndexOld > 0)
/*     */       {
/*  96 */         tReturn = cStr.substring(tIndexOld + 1, cStr.length());
/*     */       }
/*     */       else
/*     */       {
/* 100 */         tReturn = cStr;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 105 */       tReturn = "";
/*     */     }
/* 107 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public Object getObject(int cIndex)
/*     */   {
/* 115 */     Object tReturn = null;
/* 116 */     if (cIndex < 0)
/*     */     {
/* 118 */       cIndex = 0;
/*     */     }
/*     */     try
/*     */     {
/* 122 */       tReturn = get(cIndex);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 126 */       tReturn = null;
/*     */     }
/* 128 */     return tReturn;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.VData
 * JD-Core Version:    0.6.0
 */