/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPMaxNoDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPMaxNoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPMaxNoSet;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ 
/*     */ public class PubFun1
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  46 */     PubFun1 tPF1 = new PubFun1();
/*  47 */     String tUpGroup = "0000000003";
/*     */   }
/*     */ 
/*     */   public static synchronized String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/*  52 */     String tReturn = "";
/*  53 */     String cNoLimit = "SN";
/*  54 */     Connection conn = DBConnPool.getConnection();
/*  55 */     boolean flag = true;
/*     */     try {
/*  57 */       flag = conn.getAutoCommit();
/*     */     } catch (Exception de) {
/*  59 */       de.printStackTrace();
/*     */     }
/*  61 */     if (conn == null) {
/*  62 */       System.out.println("CreateMaxNo : fail to get db connection");
/*  63 */       return tReturn;
/*     */     }
/*     */ 
/*  66 */     cNoType = cNoType.toUpperCase();
/*  67 */     if ((cNoType.trim().length() <= 0) || (cNoLength <= 0)) {
/*  68 */       return tReturn;
/*     */     }
/*     */ 
/*  71 */     cNoType = cNoType.toUpperCase();
/*  72 */     LNPMaxNoDB tDB = new LNPMaxNoDB(conn);
/*  73 */     LNPMaxNoSchema tSch = new LNPMaxNoSchema();
/*  74 */     LNPMaxNoSet tSet = new LNPMaxNoSet();
/*  75 */     int tMaxNo = 0;
/*     */ 
/*  77 */     tReturn = cNoLimit.trim();
/*     */ 
/*  79 */     tSch.setNoType(cNoType);
/*  80 */     tSch.setNoLimit(cNoLimit);
/*  81 */     tDB.setSchema(tSch);
/*     */     try
/*     */     {
/*  84 */       conn.setAutoCommit(false);
/*     */ 
/*  86 */       tSet = tDB.query();
/*  87 */       if (tSet.size() <= 0) {
/*  88 */         tMaxNo = 1;
/*  89 */         tDB.setNoType(cNoType);
/*  90 */         tDB.setNoLimit(cNoLimit);
/*  91 */         tDB.setMaxNo(tMaxNo);
/*  92 */         tDB.insert();
/*  93 */         if (tDB.mErrors.needDealError()) {
/*  94 */           conn.rollback();
/*     */ 
/*  96 */           System.out.println(tDB.mErrors.getFirstError());
/*  97 */           return "";
/*     */         }
/*  99 */         conn.commit();
/*     */       }
/*     */       else
/*     */       {
/* 103 */         tMaxNo = tSet.get(1).getMaxNo();
/* 104 */         tMaxNo++;
/* 105 */         tDB.setNoType(cNoType);
/* 106 */         tDB.setNoLimit(cNoLimit);
/* 107 */         tDB.setMaxNo(tMaxNo);
/* 108 */         tDB.update();
/* 109 */         if (tDB.mErrors.needDealError()) {
/* 110 */           conn.rollback();
/*     */ 
/* 112 */           return "";
/*     */         }
/* 114 */         conn.commit();
/*     */       }
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 121 */         conn.rollback();
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 126 */         conn.setAutoCommit(flag);
/* 127 */         conn.close();
/*     */       } catch (Exception wew) {
/* 129 */         wew.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 126 */         conn.setAutoCommit(flag);
/* 127 */         conn.close();
/*     */       } catch (Exception wew) {
/* 129 */         wew.printStackTrace();
/*     */       }
/*     */     }
/* 132 */     String tStr = "";
/* 133 */     tStr = String.valueOf(tMaxNo);
/* 134 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 135 */     tReturn = tStr.trim();
/* 136 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static String CreateMaxNo(String cNoType, String cNoLimit) {
/* 140 */     int serialLen = 7;
/* 141 */     String tReturn = "";
/* 142 */     Connection conn = DBConnPool.getConnection();
/* 143 */     boolean flag = true;
/*     */     try {
/* 145 */       flag = conn.getAutoCommit();
/*     */     } catch (Exception de) {
/* 147 */       de.printStackTrace();
/*     */     }
/*     */ 
/* 150 */     if (conn == null) {
/* 151 */       System.out.println("CreateMaxNo : fail to get db connection");
/* 152 */       return tReturn;
/*     */     }
/* 154 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 156 */     if (cNoType.trim().length() <= 0) {
/* 157 */       return tReturn;
/*     */     }
/*     */ 
/* 160 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/* 162 */       if ((cNoType.equals("COMMISIONSN")) || (cNoType.equals("AGENTCODE")) || 
/* 163 */         (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 164 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/* 165 */         (cNoType.equals("SUGITEMCODE")) || (cNoType.equals("SUGMODELCODE")) || 
/* 166 */         (cNoType.equals("SUGCODE")) || (cNoType.equals("PERSUGCODE"))) {
/* 167 */         serialLen = 10;
/*     */       } else {
/* 169 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/* 170 */         return tReturn;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 175 */     cNoType = cNoType.toUpperCase();
/* 176 */     LNPMaxNoDB tDB = new LNPMaxNoDB(conn);
/* 177 */     LNPMaxNoSchema tSch = new LNPMaxNoSchema();
/* 178 */     LNPMaxNoSet tSet = new LNPMaxNoSet();
/* 179 */     int tMaxNo = 0;
/*     */ 
/* 181 */     tReturn = cNoLimit.trim();
/* 182 */     if (cNoType.equals("PROPOSALNO")) {
/* 183 */       tReturn = tReturn + "11";
/*     */     }
/* 185 */     if (cNoType.equals("GRPPROPOSALNO")) {
/* 186 */       tReturn = tReturn + "12";
/*     */     }
/* 188 */     if (cNoType.equals("CONTPROPOSALNO")) {
/* 189 */       tReturn = tReturn + "13";
/*     */     }
/*     */ 
/* 192 */     if (cNoType.equals("POLNO")) {
/* 193 */       tReturn = tReturn + "21";
/*     */     }
/* 195 */     if (cNoType.equals("GRPPOLNO")) {
/* 196 */       tReturn = tReturn + "22";
/*     */     }
/* 198 */     if (cNoType.equals("CONTNO")) {
/* 199 */       tReturn = tReturn + "23";
/*     */     }
/*     */ 
/* 202 */     if (cNoType.equals("PAYNOTICENO")) {
/* 203 */       tReturn = tReturn + "31";
/*     */     }
/*     */ 
/* 206 */     if (cNoType.equals("PAYNO")) {
/* 207 */       tReturn = tReturn + "32";
/*     */     }
/*     */ 
/* 210 */     if (cNoType.equals("GETNOTICENO")) {
/* 211 */       tReturn = tReturn + "36";
/*     */     }
/*     */ 
/* 214 */     if (cNoType.equals("GETNO")) {
/* 215 */       tReturn = tReturn + "37";
/*     */     }
/*     */ 
/* 218 */     if (cNoType.equals("EDORAPPNO")) {
/* 219 */       tReturn = tReturn + "41";
/*     */     }
/* 221 */     if (cNoType.equals("EDORNO")) {
/* 222 */       tReturn = tReturn + "42";
/*     */     }
/*     */ 
/* 225 */     if (cNoType.equals("EDORGRPNO")) {
/* 226 */       tReturn = tReturn + "43";
/*     */     }
/*     */ 
/* 230 */     if (cNoType.equals("RPTNO")) {
/* 231 */       tReturn = tReturn + "50";
/*     */     }
/*     */ 
/* 234 */     if (cNoType.equals("RGTNO")) {
/* 235 */       tReturn = tReturn + "51";
/*     */     }
/*     */ 
/* 238 */     if (cNoType.equals("CLMNO")) {
/* 239 */       tReturn = tReturn + "52";
/*     */     }
/*     */ 
/* 242 */     if (cNoType.equals("DECLINENO")) {
/* 243 */       tReturn = tReturn + "53";
/*     */     }
/*     */ 
/* 246 */     if (cNoType.equals("SUBRPTNO")) {
/* 247 */       tReturn = tReturn + "54";
/*     */     }
/*     */ 
/* 250 */     if (cNoType.equals("CASENO")) {
/* 251 */       tReturn = tReturn + "55";
/*     */     }
/*     */ 
/* 255 */     if (cNoType.equals("PROTOCOLNO")) {
/* 256 */       tReturn = tReturn + "71";
/*     */     }
/*     */ 
/* 259 */     if (cNoType.equals("PRTNO")) {
/* 260 */       tReturn = tReturn + "80";
/*     */     }
/* 262 */     if (cNoType.equals("PRTSEQNO")) {
/* 263 */       tReturn = tReturn + "81";
/*     */     }
/* 265 */     if (cNoType.equals("PRTSEQ2NO")) {
/* 266 */       tReturn = tReturn + "82";
/*     */     }
/*     */ 
/* 274 */     if (cNoType.equals("TAKEBACKNO")) {
/* 275 */       tReturn = tReturn + "61";
/*     */     }
/* 277 */     if (cNoType.equals("BATCHNO")) {
/* 278 */       tReturn = tReturn + "62";
/*     */     }
/*     */ 
/* 281 */     if (cNoType.equals("WAGENO")) {
/* 282 */       tReturn = tReturn + "90";
/*     */     }
/*     */ 
/* 286 */     if (cNoType.equals("SERIALNO")) {
/* 287 */       tReturn = tReturn + "98";
/*     */     }
/*     */ 
/* 292 */     if (tReturn.length() == 10) {
/* 293 */       tReturn = tReturn + "99";
/*     */     }
/* 295 */     cNoLimit = tReturn;
/*     */ 
/* 297 */     tSch.setNoType(cNoType);
/* 298 */     tSch.setNoLimit(cNoLimit);
/* 299 */     tDB.setSchema(tSch);
/*     */     try
/*     */     {
/* 303 */       tSet = tDB.query();
/* 304 */       if (tSet.size() <= 0)
/*     */       {
/* 306 */         tMaxNo = 1;
/* 307 */         tDB.setNoType(cNoType);
/* 308 */         tDB.setNoLimit(cNoLimit);
/* 309 */         tDB.setMaxNo(tMaxNo);
/* 310 */         tDB.insert();
/* 311 */         if (tDB.mErrors.needDealError())
/*     */         {
/* 313 */           conn.rollback();
/*     */ 
/* 315 */           System.out.println(tDB.mErrors.getFirstError());
/* 316 */           return "";
/*     */         }
/*     */ 
/* 319 */         conn.commit();
/*     */       }
/*     */       else
/*     */       {
/* 323 */         tMaxNo = tSet.get(1).getMaxNo();
/* 324 */         tMaxNo++;
/* 325 */         tDB.setNoType(cNoType);
/* 326 */         tDB.setNoLimit(cNoLimit);
/* 327 */         tDB.setMaxNo(tMaxNo);
/* 328 */         tDB.update();
/* 329 */         if (tDB.mErrors.needDealError())
/*     */         {
/* 331 */           conn.rollback();
/*     */ 
/* 333 */           return "";
/*     */         }
/*     */ 
/* 336 */         conn.commit();
/*     */       }
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 343 */         conn.rollback();
/* 344 */         conn.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 348 */         conn.setAutoCommit(flag);
/* 349 */         conn.close();
/*     */       } catch (Exception wew) {
/* 351 */         wew.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 348 */         conn.setAutoCommit(flag);
/* 349 */         conn.close();
/*     */       } catch (Exception wew) {
/* 351 */         wew.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 362 */     String len = Integer.toString(tMaxNo);
/* 363 */     if (len.length() < 10) {
/* 364 */       len = PubFun.LCh(len, "0", 10);
/*     */     }
/*     */ 
/* 369 */     String tStr = "";
/* 370 */     tStr = String.valueOf(tMaxNo);
/* 371 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 373 */     if (cNoType.equals("CUSNO")) {
/* 374 */       System.out.println("len=" + len);
/* 375 */       tReturn = tReturn + len;
/* 376 */       System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq=" + 
/* 377 */         tReturn);
/*     */     }
/* 379 */     else if (tReturn.equals("SN")) {
/* 380 */       tReturn = tStr.trim();
/*     */     } else {
/* 382 */       tReturn = tReturn.trim() + tStr.trim();
/*     */     }
/*     */ 
/* 385 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static String CreateMaxNo(String cNoType, String cNoLimit, int cNoLength)
/*     */   {
/* 391 */     String tReturn = "";
/*     */ 
/* 393 */     Connection conn = DBConnPool.getConnection();
/* 394 */     boolean flag = true;
/*     */     try {
/* 396 */       flag = conn.getAutoCommit();
/*     */     } catch (Exception de) {
/* 398 */       de.printStackTrace();
/*     */     }
/*     */ 
/* 402 */     if (conn == null) {
/* 403 */       System.out.println("CreateMaxNo : fail to get db connection");
/* 404 */       return tReturn;
/*     */     }
/* 406 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 408 */     if ((cNoType.trim().length() <= 0) || (cNoLength <= 0)) {
/* 409 */       return tReturn;
/*     */     }
/*     */ 
/* 412 */     cNoType = cNoType.toUpperCase();
/* 413 */     LNPMaxNoDB tDB = new LNPMaxNoDB(conn);
/* 414 */     LNPMaxNoSchema tSch = new LNPMaxNoSchema();
/* 415 */     LNPMaxNoSet tSet = new LNPMaxNoSet();
/* 416 */     int tMaxNo = 0;
/* 417 */     long tMaxLenNo = getMaxLenNo(cNoLength);
/* 418 */     tReturn = cNoLimit.trim();
/*     */ 
/* 420 */     tSch.setNoType(cNoType);
/* 421 */     tSch.setNoLimit(cNoLimit);
/* 422 */     tDB.setSchema(tSch);
/*     */     try
/*     */     {
/* 426 */       tSet = tDB.query();
/* 427 */       if (tSet.size() <= 0)
/*     */       {
/* 429 */         tMaxNo = 1;
/* 430 */         tDB.setNoType(cNoType);
/* 431 */         tDB.setNoLimit(cNoLimit);
/* 432 */         tDB.setMaxNo(tMaxNo);
/* 433 */         tDB.insert();
/* 434 */         if (tDB.mErrors.needDealError())
/*     */         {
/* 436 */           conn.rollback();
/*     */ 
/* 438 */           System.out.println(tDB.mErrors.getFirstError());
/* 439 */           return "";
/*     */         }
/*     */ 
/* 442 */         conn.commit();
/*     */       }
/*     */       else
/*     */       {
/* 446 */         tMaxNo = tSet.get(1).getMaxNo();
/* 447 */         tMaxNo++;
/* 448 */         if (tMaxNo == tMaxLenNo) {
/* 449 */           tMaxNo = 1;
/*     */         }
/* 451 */         tDB.setMaxNo(tMaxNo);
/* 452 */         tDB.setNoType(cNoType);
/* 453 */         tDB.setNoLimit(cNoLimit);
/*     */ 
/* 455 */         tDB.update();
/* 456 */         if (tDB.mErrors.needDealError())
/*     */         {
/* 458 */           conn.rollback();
/*     */ 
/* 460 */           return "";
/*     */         }
/*     */ 
/* 463 */         conn.commit();
/*     */       }
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 470 */         conn.rollback();
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 475 */         conn.setAutoCommit(flag);
/* 476 */         conn.close();
/*     */       } catch (Exception wew) {
/* 478 */         wew.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 475 */         conn.setAutoCommit(flag);
/* 476 */         conn.close();
/*     */       } catch (Exception wew) {
/* 478 */         wew.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/* 482 */     String tStr = "";
/*     */ 
/* 484 */     tStr = String.valueOf(tMaxNo);
/* 485 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 486 */     tReturn = tStr.trim();
/* 487 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static String getSQL(String strSql, Calculator calculator)
/*     */     throws Exception
/*     */   {
/* 493 */     LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*     */ 
/* 496 */     String strSQL = strSql.replace('\'', '@');
/* 497 */     strSQL = "select ''" + strSQL + "'' from dual";
/*     */ 
/* 499 */     tLNPCalModeDB.setCalCode("XXX");
/* 500 */     tLNPCalModeDB.setRiskCode("0");
/* 501 */     tLNPCalModeDB.setType("F");
/* 502 */     tLNPCalModeDB.setCalSQL(strSQL);
/*     */ 
/* 504 */     if (!tLNPCalModeDB.update()) {
/* 505 */       throw new Exception("\u8BBE\u7F6E\u8BA1\u7B97\u516C\u5F0F\u65F6\u51FA\u9519");
/*     */     }
/*     */ 
/* 508 */     calculator.setCalCode("XXX");
/*     */ 
/* 511 */     if (strSQL.equals("")) {
/* 512 */       throw new Exception("\u89E3\u6790SQL\u8BED\u53E5\u65F6\u51FA\u9519");
/*     */     }
/*     */ 
/* 515 */     return strSQL.replace('@', '\'');
/*     */   }
/*     */ 
/*     */   public static String[] calFLDate(String tDate)
/*     */   {
/* 520 */     String[] MonDate = new String[2];
/* 521 */     String asql = "select startdate,enddate from LAStatSegment where stattype='5' and startdate<='" + 
/* 522 */       tDate + "' and enddate>='" + tDate + "'";
/* 523 */     ExeSQL aExeSQL = new ExeSQL();
/* 524 */     SSRS aSSRS = new SSRS();
/* 525 */     aSSRS = aExeSQL.execSQL(asql);
/* 526 */     MonDate[0] = aSSRS.GetText(1, 1);
/* 527 */     MonDate[1] = aSSRS.GetText(1, 2);
/* 528 */     return MonDate;
/*     */   }
/*     */ 
/*     */   public static String getString(String key, ResourceBundle Bundle)
/*     */   {
/* 533 */     String value = null;
/*     */     try {
/* 535 */       value = getResourceBundle(Bundle).getString(key);
/*     */     } catch (MissingResourceException e) {
/* 537 */       System.out.println(
/* 538 */         "java.util.MissingResourceException: Couldn't find value for: " + 
/* 539 */         key);
/*     */     }
/* 541 */     if (value == null) {
/* 542 */       value = "Could not find resource: " + key + "  ";
/*     */     }
/* 544 */     return value;
/*     */   }
/*     */ 
/*     */   private static ResourceBundle getResourceBundle(ResourceBundle bundle)
/*     */   {
/* 549 */     if (bundle == null) {
/* 550 */       bundle = ResourceBundle.getBundle("resources.suggest");
/*     */     }
/* 552 */     return bundle;
/*     */   }
/*     */ 
/*     */   public static long getMaxLenNo(int len)
/*     */   {
/* 589 */     String no = "1";
/* 590 */     for (int i = 0; i < len; i++) {
/* 591 */       no = no + "0";
/*     */     }
/* 593 */     long MaxLenNo = Long.parseLong(no);
/*     */ 
/* 595 */     return MaxLenNo - 1L;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.PubFun1
 * JD-Core Version:    0.6.0
 */