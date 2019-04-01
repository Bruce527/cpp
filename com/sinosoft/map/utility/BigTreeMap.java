/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.Arith;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.LinkedList;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ public class BigTreeMap<K, V> extends TreeMap<K, V>
/*     */ {
/*     */   public SSRS doubleArryToSsrs(LinkedList<K> strArryTableName)
/*     */   {
/*  18 */     if (strArryTableName == null) {
/*  19 */       throw new RuntimeException("\u4E0D\u80FD\u5BF9\u6CA1\u6709\u8868\u540D\u7684\u6570\u636E\u5BB9\u5668\uFF0C\u7EC4\u7EC7\u8868\u4F53");
/*     */     }
/*  21 */     DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
/*  22 */     DecimalFormat format = new DecimalFormat("###,##0");
/*  23 */     SSRS ssrs = new SSRS(strArryTableName.size());
/*     */ 
/*  25 */     int length = 0;
/*     */     int intMiddlength;
/*  26 */     for (Object a : strArryTableName) {
/*  27 */       intMiddlength = ((double[])get(a)).length;
/*  28 */       if (intMiddlength > length) {
/*  29 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/*  33 */     if (get("LJYJ") != null) {
/*  34 */       put("LJYJ", get("JBBF"));
/*     */     }
/*  36 */     if (get("TLJYJ") != null) {
/*  37 */       String[] strHeadName = { "TJBDJBF", "TEWTZ" };
/*     */ 
/*  39 */       double[] douAryTLJYJ = getNColSum(this, strHeadName);
/*  40 */       put("TLJYJ", douAryTLJYJ);
/*     */     }
/*  42 */     if (get("WLJYJ") != null) {
/*  43 */       String[] strHeadName = { "WJBBF", "WBEWQJBF", "WEWTZ" };
/*     */ 
/*  45 */       double[] douAryWLJYJ = getNColSum(this, strHeadName);
/*  46 */       put("WLJYJ", douAryWLJYJ);
/*     */     }
/*  48 */     for (int i = 0; i < length; i++)
/*     */     {
/*  50 */       for (Object a : strArryTableName) {
/*  51 */         double[] douArryaValue = (double[])get(a);
/*  52 */         if (i >= douArryaValue.length) {
/*  53 */           ssrs.SetText("");
/*     */         }
/*     */         else
/*     */         {
/*  57 */           if (((a.equals("LJYJ")) || (a.equals("TLJYJ")) || (a.equals("WLJYJ"))) && 
/*  58 */             (i != 0)) {
/*  59 */             douArryaValue[i] += douArryaValue[(i - 1)];
/*     */           }
/*     */ 
/*  62 */           if (douArryaValue[i] <= 0.0D)
/*     */           {
/*  64 */             if ((a.equals("BDND")) || (a.equals("NMYDNL")))
/*  65 */               ssrs.SetText("0");
/*     */             else {
/*  67 */               ssrs.SetText("--");
/*     */             }
/*     */ 
/*     */           }
/*  71 */           else if ((a.equals("BDND")) || (a.equals("NMYDNL")) || (a.equals("HG")) || (a.equals("HN"))) {
/*  72 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
/*     */           }
/*  76 */           else if ((a.equals("JBBF")) || (a.equals("LJYJ"))) {
/*  77 */             ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
/*     */           }
/*  81 */           else if ((a.equals("XJHLH")) || (a.equals("XJHLM")) || (a.equals("XJHLL")) || (a.equals("XJJZ")) || (a.equals("LJSXM")) || (a.equals("LJSXL")) || (a.equals("LJSXH"))) {
/*  82 */             ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
/*     */           }
/*     */           else
/*  85 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0))); 
/*     */         }
/*     */       }
/*     */     }
/*  88 */     return ssrs;
/*     */   }
/*     */   public SSRS doubleArryToSsrs(LinkedList<K> strArryTableName, boolean flage) {
/*  91 */     remove("WLJYJ");
/*     */ 
/*  93 */     if (strArryTableName == null) {
/*  94 */       throw new RuntimeException("\u4E0D\u80FD\u5BF9\u6CA1\u6709\u8868\u540D\u7684\u6570\u636E\u5BB9\u5668\uFF0C\u7EC4\u7EC7\u8868\u4F53");
/*     */     }
/*  96 */     DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
/*  97 */     DecimalFormat format = new DecimalFormat("###,##0");
/*  98 */     SSRS ssrs = new SSRS(strArryTableName.size());
/*     */ 
/* 100 */     int length = 0;
/*     */     int intMiddlength;
/* 101 */     for (Object a : strArryTableName) {
/* 102 */       intMiddlength = ((double[])get(a)).length;
/* 103 */       if (intMiddlength > length) {
/* 104 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/* 108 */     if (get("LJYJ") != null) {
/* 109 */       put("LJYJ", get("JBBF"));
/*     */     }
/* 111 */     if (get("TLJYJ") != null) {
/* 112 */       String[] strHeadName = { "TJBDJBF", "TEWTZ" };
/*     */ 
/* 114 */       double[] douAryTLJYJ = getNColSum(this, strHeadName);
/* 115 */       put("TLJYJ", douAryTLJYJ);
/*     */     }
/* 117 */     if (get("WLJYJ") != null) {
/* 118 */       String[] strHeadName = { "WJBBF", "WBEWQJBF", "WEWTZ" };
/*     */ 
/* 120 */       double[] douAryWLJYJ = getNColSum(this, strHeadName);
/* 121 */       put("WLJYJ", douAryWLJYJ);
/*     */     }
/* 123 */     for (int i = 0; i < length; i++)
/*     */     {
/* 125 */       for (Object a : strArryTableName) {
/* 126 */         double[] douArryaValue = (double[])get(a);
/* 127 */         if (i >= douArryaValue.length) {
/* 128 */           ssrs.SetText("");
/*     */         }
/*     */         else
/*     */         {
/* 132 */           if (((a.equals("LJYJ")) || (a.equals("TLJYJ")) || (a.equals("WLJYJ"))) && 
/* 133 */             (i != 0)) {
/* 134 */             douArryaValue[i] += douArryaValue[(i - 1)];
/*     */           }
/*     */ 
/* 137 */           if (douArryaValue[i] <= 0.0D)
/*     */           {
/* 139 */             if ((a.equals("BDND")) || (a.equals("NMYDNL")))
/* 140 */               ssrs.SetText("0");
/*     */             else {
/* 142 */               ssrs.SetText("--");
/*     */             }
/*     */ 
/*     */           }
/* 146 */           else if ((a.equals("BDND")) || (a.equals("NMYDNL")) || (a.equals("HG")) || (a.equals("HN"))) {
/* 147 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
/*     */           }
/* 151 */           else if ((a.equals("JBBF")) || (a.equals("LJYJ"))) {
/* 152 */             ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
/*     */           }
/* 156 */           else if ((a.equals("LJSXH")) || (a.equals("LJSXM")) || (a.equals("LJSXL")) || (a.equals("XJJZ"))) {
/* 157 */             ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
/*     */           }
/*     */           else
/* 160 */             ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0))); 
/*     */         }
/*     */       }
/*     */     }
/* 163 */     return ssrs;
/*     */   }
/*     */ 
/*     */   private double[] getNColSum(BigTreeMap<String, double[]> bigTreeMap, String[] strHeadName)
/*     */   {
/* 169 */     double[] douAryReData = new double[((double[])bigTreeMap.get("BDND")).length];
/* 170 */     for (int i = 0; i < douAryReData.length; i++) {
/* 171 */       for (int j = 0; j < strHeadName.length; j++) {
/* 172 */         if (i >= ((double[])bigTreeMap.get(strHeadName[j])).length) {
/*     */           continue;
/*     */         }
/* 175 */         douAryReData[i] += ((double[])bigTreeMap.get(strHeadName[j]))[i];
/*     */       }
/*     */     }
/*     */ 
/* 179 */     return douAryReData;
/*     */   }
/*     */ 
/*     */   public void doubleArryToSum(String[] headName)
/*     */   {
/* 184 */     int length = 0;
/*     */     int intMiddlength;
/* 185 */     for (String a : headName) {
/* 186 */       intMiddlength = ((double[])get(a)).length;
/* 187 */       if (intMiddlength > length) {
/* 188 */         length = intMiddlength;
/*     */       }
/*     */     }
/*     */ 
/* 192 */     for (int i = 0; i < length; i++)
/* 193 */       for (String a : headName) {
/* 194 */         double[] douArryaValue = (double[])get(a);
/* 195 */         if ((a.equals("BT")) && 
/* 196 */           (length - 1 != i)) {
/* 197 */           douArryaValue[i] = 0.0D;
/*     */         }
/*     */ 
/* 200 */         if (i >= douArryaValue.length)
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 205 */         if (i != 0)
/* 206 */           douArryaValue[i] += douArryaValue[(i - 1)];
/*     */       }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.BigTreeMap
 * JD-Core Version:    0.6.0
 */