/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class SysMaxNoMETLIFE
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  28 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public synchronized String CreateMaxNo(String cNoType, String cNoLimit)
/*     */   {
/*  35 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || (cNoLimit == null))
/*     */     {
/*  37 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*  38 */       return null;
/*     */     }
/*     */ 
/*  42 */     int serialLen = 9;
/*  43 */     String tReturn = "";
/*  44 */     String nNolimit = cNoLimit;
/*  45 */     String tYear = PubFun.getCurrentDate().substring(0, 4);
/*  46 */     cNoType = cNoType.toUpperCase();
/*  47 */     System.out.println("-----------cNoType:" + cNoType + "  cNoLimit:" + cNoLimit);
/*     */ 
/*  50 */     if (cNoType.equals("ORDERNO")) {
/*  51 */       serialLen = 14;
/*  52 */       tReturn = "22";
/*  53 */     } else if (cNoType.equals("POLNO")) {
/*  54 */       serialLen = 14;
/*  55 */       tReturn = "33";
/*  56 */     } else if (cNoType.equals("CUSTOMERNO")) {
/*  57 */       serialLen = 16;
/*  58 */       tReturn = "55";
/*  59 */     } else if ("TRADENO".equals(cNoType)) {
/*  60 */       serialLen = 14;
/*  61 */       tReturn = "66";
/*  62 */     } else if ("BNFNo".equals(cNoType)) {
/*  63 */       serialLen = 15;
/*  64 */       tReturn = "77";
/*     */     }
/*  66 */     else if ("APPSERIALNO".equals(cNoType)) {
/*  67 */       serialLen = 14;
/*  68 */       tReturn = "44";
/*     */     }
/*     */ 
/*  73 */     String nextSeq = null;
/*     */     try
/*     */     {
/*  76 */       ExeSQL tExeSQL = new ExeSQL();
/*  77 */       StringBuffer seqSQL = new StringBuffer();
/*  78 */       seqSQL.append("select sequence_name from user_sequences where sequence_name='");
/*  79 */       seqSQL.append("SEQ_");
/*  80 */       seqSQL.append(cNoType);
/*  81 */       seqSQL.append("_");
/*  82 */       seqSQL.append(cNoLimit);
/*  83 */       seqSQL.append("'");
/*  84 */       String exist = tExeSQL.getOneValue(seqSQL.toString());
/*     */ 
/*  86 */       StringBuffer queryStrBuf = new StringBuffer(128);
/*  87 */       queryStrBuf.append("select SEQ_");
/*  88 */       queryStrBuf.append(cNoType);
/*  89 */       queryStrBuf.append("_");
/*  90 */       queryStrBuf.append(cNoLimit);
/*  91 */       queryStrBuf.append(".nextval from dual");
/*     */ 
/*  93 */       if ((exist != null) && (!"".equals(exist))) {
/*  94 */         nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
/*  95 */         if ((nextSeq == null) || ("".equals(nextSeq))) {
/*  96 */           System.out.println("\u67E5\u8BE2\u6570\u636E\u5E93\u5E8F\u5217\u65F6\u51FA\u9519\uFF01");
/*  97 */           return null;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 102 */         StringBuffer createStrBuf = new StringBuffer(128);
/* 103 */         createStrBuf.append("create sequence SEQ_");
/* 104 */         createStrBuf.append(cNoType);
/* 105 */         createStrBuf.append("_");
/* 106 */         createStrBuf.append(cNoLimit);
/* 107 */         createStrBuf.append(" minvalue 1 maxvalue 999999999999 start with 1 increment by 1 nocache");
/* 108 */         boolean createFlag = tExeSQL.execUpdateSQL(createStrBuf.toString());
/* 109 */         if (createFlag) {
/* 110 */           nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
/* 111 */           if ((nextSeq == null) || ("".equals(nextSeq))) {
/* 112 */             System.out.println("\u67E5\u8BE2\u6570\u636E\u5E93\u5E8F\u5217\u65F6\u51FA\u9519\uFF01");
/* 113 */             return null;
/*     */           }
/*     */         }
/*     */         else {
/* 117 */           System.out.println("\u6570\u636E\u5E93\u521B\u5EFA\u5E8F\u5217\u5BF9\u8C61\u51FA\u9519\uFF01");
/* 118 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception tStr) {
/* 123 */       System.out.println("\u6570\u636E\u5E93\u521B\u5EFA\u5E8F\u5217\u6216\u67E5\u8BE2\u5E8F\u5217\u5BF9\u8C61\u8FC7\u7A0B\u4E2D\u53D1\u751F\u5F02\u5E38\uFF01");
/* 124 */       ex.printStackTrace();
/*     */ 
/* 274 */       String tStr = new String(nextSeq);
/* 275 */       tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 277 */       if (cNoLimit.equals("SN"))
/*     */       {
/* 279 */         tReturn = tReturn + tYear + tStr.trim();
/*     */       }
/*     */     }
/* 282 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String GetAccountId(String tStr)
/*     */   {
/* 287 */     String tMod = "109876532";
/* 288 */     String tStr1 = "";
/* 289 */     String tStr2 = "";
/* 290 */     String tReturn = "";
/* 291 */     tStr1 = PubFun.LCh(tStr, "0", 9);
/* 292 */     double j = 0.0D;
/* 293 */     int k = 0;
/* 294 */     for (int i = 1; i <= 9; i++)
/*     */     {
/* 296 */       j += Integer.parseInt(tStr1.substring(i - 1, i)) * Math.pow(2.0D, i - 1);
/*     */     }
/*     */ 
/* 299 */     k = (int)Math.floor(j) % 9;
/* 300 */     k++;
/* 301 */     tStr2 = tStr1.trim() + tMod.substring(k - 1, k);
/* 302 */     tReturn = tStr2;
/* 303 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 309 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 310 */       (cNoLength <= 0))
/*     */     {
/* 312 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/* 314 */       return null;
/*     */     }
/*     */ 
/* 317 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 328 */     String tReturn = "";
/* 329 */     String cNoLimit = "SN";
/*     */ 
/* 346 */     String nextSeq = null;
/*     */     try
/*     */     {
/* 349 */       ExeSQL tExeSQL = new ExeSQL();
/* 350 */       StringBuffer seqSQL = new StringBuffer();
/* 351 */       seqSQL.append("select sequence_name from user_sequences where sequence_name='");
/* 352 */       seqSQL.append("SEQ_");
/* 353 */       seqSQL.append(cNoType);
/* 354 */       seqSQL.append("_");
/* 355 */       seqSQL.append(cNoLimit);
/* 356 */       seqSQL.append("'");
/* 357 */       String exist = tExeSQL.getOneValue(seqSQL.toString());
/*     */ 
/* 359 */       StringBuffer queryStrBuf = new StringBuffer(128);
/* 360 */       queryStrBuf.append("select SEQ_");
/* 361 */       queryStrBuf.append(cNoType);
/* 362 */       queryStrBuf.append("_");
/* 363 */       queryStrBuf.append(cNoLimit);
/* 364 */       queryStrBuf.append(".nextval from dual");
/*     */ 
/* 366 */       if ((exist != null) && (!"".equals(exist))) {
/* 367 */         nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
/* 368 */         if ((nextSeq == null) || ("".equals(nextSeq))) {
/* 369 */           System.out.println("\u67E5\u8BE2\u6570\u636E\u5E93\u5E8F\u5217\u65F6\u51FA\u9519\uFF01");
/* 370 */           return null;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 375 */         StringBuffer createStrBuf = new StringBuffer(128);
/* 376 */         createStrBuf.append("create sequence SEQ_");
/* 377 */         createStrBuf.append(cNoType);
/* 378 */         createStrBuf.append("_");
/* 379 */         createStrBuf.append(cNoLimit);
/* 380 */         createStrBuf.append(" minvalue 1 maxvalue 999999999999 start with 1 increment by 1 nocache");
/* 381 */         boolean createFlag = tExeSQL.execUpdateSQL(createStrBuf.toString());
/* 382 */         if (createFlag) {
/* 383 */           nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
/* 384 */           if ((nextSeq == null) || ("".equals(nextSeq))) {
/* 385 */             System.out.println("\u67E5\u8BE2\u6570\u636E\u5E93\u5E8F\u5217\u65F6\u51FA\u9519\uFF01");
/* 386 */             return null;
/*     */           }
/*     */         }
/*     */         else {
/* 390 */           System.out.println("\u6570\u636E\u5E93\u521B\u5EFA\u5E8F\u5217\u5BF9\u8C61\u51FA\u9519\uFF01");
/* 391 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception tStr) {
/* 396 */       System.out.println("\u6570\u636E\u5E93\u521B\u5EFA\u5E8F\u5217\u6216\u67E5\u8BE2\u5E8F\u5217\u5BF9\u8C61\u8FC7\u7A0B\u4E2D\u53D1\u751F\u5F02\u5E38\uFF01");
/* 397 */       ex.printStackTrace();
/*     */ 
/* 538 */       String tStr = new String(nextSeq);
/* 539 */       tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 540 */       tReturn = tStr.trim();
/*     */     }
/* 542 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 563 */     String strLimit = PubFun.getNoLimit("860401");
/* 564 */     String strRiskAssessNo = PubFun1.CreateMaxNo("ORDERNO", "SN");
/* 565 */     System.out.println("=============RiskAssessNo:" + strRiskAssessNo + "==============");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE
 * JD-Core Version:    0.6.0
 */