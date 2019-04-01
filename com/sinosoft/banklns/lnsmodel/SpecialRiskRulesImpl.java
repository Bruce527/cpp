/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SpecialRiskRulesImpl
/*     */ {
/*     */   public List checkApp(String appage, String age, String degree, String value)
/*     */   {
/*  11 */     List result = new ArrayList();
/*  12 */     String msg = "";
/*  13 */     if ((age == null) || (age.equals("")) || 
/*  14 */       (degree == null) || (degree.equals("")) || 
/*  15 */       (value == null) || (value.equals(""))) {
/*  16 */       msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\u02B1\uFFFD\uFFFD\u0577\u0461\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\u02BF\uFFFD\u02BC\uFFFD\uFFFD\uFFFD\u4862\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uE8E1";
/*  17 */       result.add(msg);
/*     */     } else {
/*  19 */       int iappage = Integer.parseInt(appage);
/*  20 */       int iage = Integer.parseInt(age);
/*  21 */       int idegree = Integer.parseInt(degree);
/*  22 */       int ivalue = Integer.parseInt(value);
/*  23 */       if (iage < iappage) {
/*  24 */         msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\u02BF\uFFFD\u02BC\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\u03AA\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\u48E1";
/*  25 */         result.add(msg);
/*     */       }
/*  27 */       if (ivalue < 2000) {
/*  28 */         msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\u02B1\uFFFD\uFFFD\u0577\uFFFD\u00FF\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD2000\u052A\uFFFD\uFFFD";
/*  29 */         result.add(msg);
/*     */       }
/*  31 */       if (ivalue % 1000 != 0) {
/*  32 */         msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\u02B1\uFFFD\uFFFD\u0577\uFFFD\uFFFD\uFFFD1000\u03AA\uFFFD\uFFFD\u03BB\uFFFD\uFFFD\u04E3\uFFFD";
/*  33 */         result.add(msg);
/*     */       }
/*     */     }
/*  36 */     return result;
/*     */   }
/*     */ 
/*     */   public List checkGet(String appage, String age, String degree, String value) {
/*  40 */     List result = new ArrayList();
/*  41 */     String msg = "";
/*  42 */     if ((age == null) || (age.equals("")) || 
/*  43 */       (degree == null) || (degree.equals("")) || 
/*  44 */       (value == null) || (value.equals(""))) {
/*  45 */       msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0221\uFFFD\uFFFD\uE862\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0221\uFFFD\uFFFD\u02BC\uFFFD\uFFFD\uFFFD\u4862\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0221\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uE8E1";
/*  46 */       result.add(msg);
/*     */     } else {
/*  48 */       int tappage = Integer.parseInt(appage);
/*  49 */       int tage = Integer.parseInt(age);
/*  50 */       int tdegree = Integer.parseInt(degree);
/*  51 */       int tvalue = Integer.parseInt(value);
/*  52 */       if (tage < tappage) {
/*  53 */         msg = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0221\uFFFD\uFFFD\u02BC\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\u03AA\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\u48E1";
/*  54 */         result.add(msg);
/*     */       }
/*     */     }
/*  57 */     return result;
/*     */   }
/*     */ 
/*     */   public List checkAccount(String appage, String age, String protagonist, String exponent, String balance, String solidity, String prevent, String AccountStr)
/*     */   {
/*  62 */     List result = new ArrayList();
/*  63 */     String msg = "";
/*  64 */     if ((age == null) || (age.equals("")) || (
/*  65 */       (protagonist.equals("0")) && (exponent.equals("0")) && 
/*  66 */       (balance.equals("0")) && (solidity.equals("0")) && 
/*  67 */       (prevent
/*  67 */       .equals("0")))) {
/*  68 */       msg = "\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\u02BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0138\uFFFD\uFFFD\uE8E1";
/*  69 */       result.add(msg);
/*     */     } else {
/*  71 */       int aappage = Integer.parseInt(appage);
/*  72 */       int aage = Integer.parseInt(age);
/*  73 */       int aprotagonist = Integer.parseInt(protagonist);
/*  74 */       int aexponent = Integer.parseInt(exponent);
/*  75 */       int abalance = Integer.parseInt(balance);
/*  76 */       int asolidity = Integer.parseInt(solidity);
/*  77 */       int aprevent = Integer.parseInt(prevent);
/*  78 */       int a = aprotagonist + aexponent + abalance + asolidity + aprevent;
/*     */       String[] temp;
/*     */       int k;
/*  79 */       if ((AccountStr != null) && (AccountStr.length() > 0))
/*     */       {
/*  81 */         temp = AccountStr.split("\\$");
/*  82 */         k = 0;
/*     */       }while (true) { String[] acc = temp[k].split("@");
/*  84 */         String accAge = acc[0];
/*  85 */         if (age.equals(accAge)) {
/*  86 */           msg = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u047E\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02BB\uFFFD\uFFFD\uFFFD\uFFFD\uBCBB\u04AA\uFFFD\u0638\uFFFD\uFFFD\uFFFD\uFFFD\u48E1\uFFFD\uFFFD";
/*  87 */           result.add(msg);
/*     */         }
/*     */         else
/*     */         {
/*  82 */           k++; if (k < temp.length)
/*     */           {
/*     */             continue;
/*     */           }
/*     */ 
/*  91 */           break;
/*  92 */           if (aage == aappage) break;
/*  93 */           msg = "\uFFFD\u02BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD";
/*  94 */           result.add(msg);
/*     */         }
/*     */       }
/*  97 */       if (aage < aappage) {
/*  98 */         msg = "\uFFFD\u02BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\u03AA\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\u48E1";
/*  99 */         result.add(msg);
/*     */       }
/* 101 */       if (a != 100) {
/* 102 */         msg = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02BB\uFFFD\uFFFD\u013A\uFFFD\u04E6\u03AA100%\uFFFD\uFFFD";
/* 103 */         result.add(msg);
/*     */       }
/*     */     }
/* 106 */     return result;
/*     */   }
/*     */ 
/*     */   public List checkRules(PolElementSchema inPolElementSchema)
/*     */   {
/* 111 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.SpecialRiskRulesImpl
 * JD-Core Version:    0.6.0
 */