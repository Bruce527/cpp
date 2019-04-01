/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.Arith;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.LinkedList;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ public class BigTreeMap<K, V> extends TreeMap<K, V>
/*     */ {
/*     */   public SSRS doubleArryToSsrs(LinkedList<K> strArryTableName)
/*     */   {
/*  16 */     if (strArryTableName == null) {
/*  17 */       throw new RuntimeException("\u6D93\u5D88\u5158\u7035\u89C4\u75C5\u93C8\u590E\u3003\u935A\u5D87\u6B91\u93C1\u7248\u5D41\u7039\u7470\u6AD2\u951B\u5C80\u7C8D\u7F01\u56EA\u3003\u6D63\uFFFD");
/*     */     }
/*  19 */     DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
/*  20 */     DecimalFormat format = new DecimalFormat("###,##0");
/*  21 */     SSRS ssrs = new SSRS(strArryTableName.size());
/*     */ 
/*  23 */     int length = 0;
/*     */     int intMiddlength;
/*  24 */     for (Object a : strArryTableName) {
/*  25 */       intMiddlength = ((double[])get(a)).length;
/*  26 */       if (intMiddlength > length) {
/*  27 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/*  31 */     if (get("LJYJ") != null) {
/*  32 */       put("LJYJ", get("JBBF"));
/*     */     }
/*  34 */     if (get("TLJYJ") != null) {
/*  35 */       String[] strHeadName = { "TJBDJBF", "TEWTZ" };
/*  36 */       double[] douAryTLJYJ = getNColSum(this, strHeadName);
/*  37 */       put("TLJYJ", douAryTLJYJ);
/*     */     }
/*  39 */     if (get("WLJYJ") != null) {
/*  40 */       String[] strHeadName = { "WJBBF", "WBEWQJBF", "WEWTZ" };
/*  41 */       double[] douAryWLJYJ = getNColSum(this, strHeadName);
/*  42 */       put("WLJYJ", douAryWLJYJ);
/*     */     }
/*  44 */     for (int i = 0; i < length; i++)
/*     */     {
/*  46 */       for (Object a : strArryTableName) {
/*  47 */         double[] douArryaValue = (double[])get(a);
/*  48 */         if (i >= douArryaValue.length) {
/*  49 */           ssrs.SetText("");
/*     */         }
/*     */         else {
/*  52 */           if (((a.equals("LJYJ")) || (a.equals("TLJYJ")) || (a.equals("WLJYJ"))) && 
/*  53 */             (i != 0)) {
/*  54 */             douArryaValue[i] += douArryaValue[(i - 1)];
/*     */           }
/*     */ 
/*  57 */           if (douArryaValue[i] <= 0.0D) {
/*  58 */             if ((a.equals("BDND")) || (a.equals("NMYDNL")))
/*  59 */               ssrs.SetText("0");
/*     */             else {
/*  61 */               ssrs.SetText("--");
/*     */             }
/*     */           }
/*  64 */           else if ((a.equals("BDND")) || (a.equals("NMYDNL")) || (a.equals("HG")) || (a.equals("HN"))) {
/*  65 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
/*     */           }
/*  68 */           else if ((a.equals("JBBF")) || (a.equals("LJYJ"))) {
/*  69 */             ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
/*     */           }
/*  73 */           else if ((a.equals("LJSXH")) || (a.equals("LJSXM")) || (a.equals("LJSXL")) || (a.equals("XJJZ"))) {
/*  74 */             ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
/*     */           }
/*     */           else
/*  77 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0))); 
/*     */         }
/*     */       }
/*     */     }
/*  80 */     return ssrs;
/*     */   }
/*     */   public SSRS doubleArryToSsrs(LinkedList<K> strArryTableName, boolean flage) {
/*  83 */     remove("WLJYJ");
/*  84 */     if (strArryTableName == null) {
/*  85 */       throw new RuntimeException("\u6D93\u5D88\u5158\u7035\u89C4\u75C5\u93C8\u590E\u3003\u935A\u5D87\u6B91\u93C1\u7248\u5D41\u7039\u7470\u6AD2\u951B\u5C80\u7C8D\u7F01\u56EA\u3003\u6D63\uFFFD");
/*     */     }
/*  87 */     DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
/*  88 */     DecimalFormat format = new DecimalFormat("###,##0");
/*  89 */     SSRS ssrs = new SSRS(strArryTableName.size());
/*  90 */     int length = 0;
/*     */     int intMiddlength;
/*  91 */     for (Object a : strArryTableName) {
/*  92 */       intMiddlength = ((double[])get(a)).length;
/*  93 */       if (intMiddlength > length) {
/*  94 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/*  98 */     if (get("LJYJ") != null) {
/*  99 */       put("LJYJ", get("JBBF"));
/*     */     }
/* 101 */     if (get("TLJYJ") != null) {
/* 102 */       String[] strHeadName = { "TJBDJBF", "TEWTZ" };
/* 103 */       double[] douAryTLJYJ = getNColSum(this, strHeadName);
/* 104 */       put("TLJYJ", douAryTLJYJ);
/*     */     }
/* 106 */     if (get("WLJYJ") != null) {
/* 107 */       String[] strHeadName = { "WJBBF", "WBEWQJBF", "WEWTZ" };
/* 108 */       double[] douAryWLJYJ = getNColSum(this, strHeadName);
/* 109 */       put("WLJYJ", douAryWLJYJ);
/*     */     }
/* 111 */     for (int i = 0; i < length; i++)
/*     */     {
/* 113 */       for (Object a : strArryTableName) {
/* 114 */         double[] douArryaValue = (double[])get(a);
/* 115 */         if (i >= douArryaValue.length) {
/* 116 */           ssrs.SetText("");
/*     */         }
/*     */         else {
/* 119 */           if (((a.equals("LJYJ")) || (a.equals("TLJYJ")) || (a.equals("WLJYJ"))) && 
/* 120 */             (i != 0)) {
/* 121 */             douArryaValue[i] += douArryaValue[(i - 1)];
/*     */           }
/*     */ 
/* 124 */           if (douArryaValue[i] <= 0.0D) {
/* 125 */             if ((a.equals("BDND")) || (a.equals("NMYDNL")))
/* 126 */               ssrs.SetText("0");
/*     */             else {
/* 128 */               ssrs.SetText("--");
/*     */             }
/*     */           }
/* 131 */           else if ((a.equals("BDND")) || (a.equals("NMYDNL")) || (a.equals("HG")) || (a.equals("HN"))) {
/* 132 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
/*     */           }
/* 135 */           else if ((a.equals("JBBF")) || (a.equals("LJYJ"))) {
/* 136 */             ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
/*     */           }
/* 140 */           else if ((a.equals("LJSXH")) || (a.equals("LJSXM")) || (a.equals("LJSXL")) || (a.equals("XJJZ"))) {
/* 141 */             ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
/*     */           }
/*     */           else
/* 144 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0))); 
/*     */         }
/*     */       }
/*     */     }
/* 147 */     return ssrs;
/*     */   }
/*     */ 
/*     */   private double[] getNColSum(BigTreeMap<String, double[]> bigTreeMap, String[] strHeadName) {
/* 151 */     double[] douAryReData = new double[((double[])bigTreeMap.get("BDND")).length];
/* 152 */     for (int i = 0; i < douAryReData.length; i++) {
/* 153 */       for (int j = 0; j < strHeadName.length; j++) {
/* 154 */         if (i >= ((double[])bigTreeMap.get(strHeadName[j])).length) {
/*     */           continue;
/*     */         }
/* 157 */         douAryReData[i] += ((double[])bigTreeMap.get(strHeadName[j]))[i];
/*     */       }
/*     */     }
/*     */ 
/* 161 */     return douAryReData;
/*     */   }
/*     */ 
/*     */   public void doubleArryToSum(String[] headName) {
/* 165 */     int length = 0;
/*     */     int intMiddlength;
/* 166 */     for (String a : headName) {
/* 167 */       intMiddlength = ((double[])get(a)).length;
/* 168 */       if (intMiddlength > length) {
/* 169 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/* 173 */     for (int i = 0; i < length; i++)
/* 174 */       for (String a : headName) {
/* 175 */         double[] douArryaValue = (double[])get(a);
/* 176 */         if ((a.equals("BT")) && 
/* 177 */           (length - 1 != i)) {
/* 178 */           douArryaValue[i] = 0.0D;
/*     */         }
/*     */ 
/* 181 */         if (i >= douArryaValue.length)
/*     */         {
/*     */           continue;
/*     */         }
/* 185 */         if (i != 0)
/* 186 */           douArryaValue[i] += douArryaValue[(i - 1)];
/*     */       }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.BigTreeMap
 * JD-Core Version:    0.6.0
 */