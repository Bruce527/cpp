/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class VData extends Vector
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public String encode()
/*     */   {
/*  24 */     String strReturn = "";
/*  25 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public Object getObjectByObjectName(String cObjectName, int cStartPos)
/*     */   {
/*  35 */     int i = 0;
/*  36 */     int iMax = 0;
/*  37 */     String tStr1 = "";
/*  38 */     String tStr2 = "";
/*  39 */     Object tReturn = null;
/*  40 */     if (cStartPos < 0)
/*     */     {
/*  42 */       cStartPos = 0;
/*     */     }
/*  44 */     iMax = size();
/*     */     try
/*     */     {
/*  47 */       for (i = cStartPos; i < iMax; i++)
/*     */       {
/*  49 */         if (get(i) == null)
/*     */         {
/*     */           continue;
/*     */         }
/*  53 */         tStr1 = get(i).getClass().getName().toUpperCase();
/*  54 */         tStr2 = cObjectName.toUpperCase();
/*  55 */         if ((!tStr1.equals(tStr2)) && (!getLastWord(tStr1, ".").equals(tStr2)))
/*     */           continue;
/*  57 */         tReturn = get(i);
/*  58 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  64 */       tReturn = null;
/*     */     }
/*  66 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public Object getObjectByObjectName(String cObjectName, int cStartPos, int cPos)
/*     */   {
/*  76 */     int i = 0;
/*  77 */     int j = 0;
/*  78 */     int iMax = 0;
/*  79 */     String tStr1 = "";
/*  80 */     String tStr2 = "";
/*  81 */     Object tReturn = null;
/*  82 */     if (cStartPos < 0)
/*     */     {
/*  84 */       cStartPos = 0;
/*     */     }
/*  86 */     iMax = size();
/*     */     try
/*     */     {
/*  89 */       for (i = cStartPos; i < iMax; i++)
/*     */       {
/*  91 */         if (get(i) == null)
/*     */         {
/*     */           continue;
/*     */         }
/*  95 */         tStr1 = get(i).getClass().getName().toUpperCase();
/*  96 */         tStr2 = cObjectName.toUpperCase();
/*  97 */         if ((!tStr1.equals(tStr2)) && (!getLastWord(tStr1, ".").equals(tStr2)))
/*     */           continue;
/*  99 */         j++;
/* 100 */         if (j < cPos)
/*     */         {
/*     */           continue;
/*     */         }
/* 104 */         tReturn = get(i);
/* 105 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 111 */       tReturn = null;
/*     */     }
/* 113 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String getLastWord(String cStr, String splitStr)
/*     */   {
/* 122 */     int tIndex = -1;
/* 123 */     int tIndexOld = -1;
/* 124 */     String tReturn = cStr;
/*     */     try
/*     */     {
/*     */       while (true)
/*     */       {
/* 129 */         tIndex = tReturn.indexOf(splitStr, tIndex + 1);
/* 130 */         if (tIndex <= 0)
/*     */           break;
/* 132 */         tIndexOld = tIndex;
/*     */       }
/*     */ 
/* 139 */       if (tIndexOld > 0)
/*     */       {
/* 141 */         tReturn = cStr.substring(tIndexOld + 1, cStr.length());
/*     */       }
/*     */       else
/*     */       {
/* 145 */         tReturn = cStr;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 150 */       tReturn = "";
/*     */     }
/* 152 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public Object getObject(int cIndex)
/*     */   {
/* 161 */     Object tReturn = null;
/* 162 */     if (cIndex < 0)
/*     */     {
/* 164 */       cIndex = 0;
/*     */     }
/*     */     try
/*     */     {
/* 168 */       tReturn = get(cIndex);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 172 */       tReturn = null;
/*     */     }
/* 174 */     return tReturn;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.VData
 * JD-Core Version:    0.6.0
 */