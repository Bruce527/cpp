/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import java.sql.Connection;
/*     */ 
/*     */ public class SysMaxNoNCL
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  28 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit)
/*     */   {
/*  35 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/*  36 */       (cNoLimit == null))
/*     */     {
/*  38 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*     */ 
/*  40 */       return null;
/*     */     }
/*     */ 
/*  44 */     int serialLen = 10;
/*  45 */     String tReturn = null;
/*  46 */     cNoType = cNoType.toUpperCase();
/*     */ 
/*  50 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/*  53 */       if ((cNoType.equals("COMMISIONSN")) || 
/*  54 */         (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/*  55 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/*  56 */         (cNoType.equals("SUGITEMCODE")) || 
/*  57 */         (cNoType.equals("SUGMODELCODE")) || 
/*  58 */         (cNoType.equals("SUGCODE")) || 
/*  59 */         (cNoType.equals("ACCNO")) || (cNoType.equals("RPTONLYNO")))
/*     */       {
/*  61 */         serialLen = 9;
/*     */       }
/*     */       else
/*     */       {
/*  65 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/*     */ 
/*  67 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  72 */     if (cNoType.equals("AIRPOLNO"))
/*     */     {
/*  74 */       serialLen = 6;
/*     */     }
/*     */ 
/*  77 */     if ((cNoType.equals("AGENTCODE")) || (cNoType.equals("MANAGECOM")))
/*     */     {
/*  79 */       serialLen = 4;
/*     */     }
/*     */ 
/*  82 */     tReturn = cNoLimit.trim();
/*     */ 
/*  85 */     String tCom = "";
/*  86 */     if (tReturn.length() >= 4)
/*     */     {
/*  88 */       tCom = tReturn.substring(2, 4);
/*  89 */       tCom = "0" + tCom;
/*  90 */       tReturn = tReturn.substring(0, 4);
/*     */     }
/*     */ 
/*  95 */     if (cNoType.equals("PROPOSALNO"))
/*     */     {
/*  97 */       tReturn = "11" + tCom;
/*     */     }
/* 101 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 103 */       tReturn = "12" + tCom;
/*     */     }
/* 107 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 109 */       tReturn = "13" + tCom;
/*     */     }
/* 113 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 115 */       tReturn = "14" + tCom;
/*     */     }
/* 119 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 121 */       tReturn = "21" + tCom;
/*     */     }
/* 125 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 127 */       tReturn = "22" + tCom;
/*     */     }
/* 131 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 136 */       tReturn = "0";
/*     */     }
/* 140 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 142 */       tReturn = "24" + tCom;
/*     */     }
/* 146 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 149 */       tReturn = tCom.substring(1);
/* 150 */       serialLen = 8;
/*     */     }
/* 154 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 156 */       tReturn = "32" + tCom;
/*     */     }
/* 160 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 162 */       tReturn = "36" + tCom;
/*     */     }
/* 166 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 168 */       tReturn = "37" + tCom;
/*     */     }
/* 172 */     else if (cNoType.equals("EDORACCEPTNO"))
/*     */     {
/* 174 */       String tStr = PubFun.getCurrentDate();
/* 175 */       tReturn = "61" + tStr.substring(0, 4) + tStr.substring(5, 7) + tStr.substring(8, 10);
/* 176 */       serialLen = 6;
/*     */     }
/* 180 */     else if (cNoType.equals("EDORAPPNO"))
/*     */     {
/* 182 */       String tStr = PubFun.getCurrentDate();
/* 183 */       tReturn = "60" + tStr.substring(0, 4) + tStr.substring(5, 7) + tStr.substring(8, 10);
/* 184 */       serialLen = 6;
/*     */     }
/* 188 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 190 */       String tStr = PubFun.getCurrentDate();
/* 191 */       tReturn = "60" + tStr.substring(0, 4) + tStr.substring(5, 7) + tStr.substring(8, 10);
/* 192 */       serialLen = 6;
/*     */     }
/* 196 */     else if (cNoType.equals("EDORGRPAPPNO"))
/*     */     {
/* 198 */       String tStr = PubFun.getCurrentDate();
/* 199 */       tReturn = "63" + tStr.substring(0, 4) + tStr.substring(5, 7) + tStr.substring(8, 10);
/* 200 */       serialLen = 6;
/*     */     }
/* 204 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 206 */       String tStr = PubFun.getCurrentDate();
/* 207 */       tReturn = "63" + tStr.substring(0, 4) + tStr.substring(5, 7) + tStr.substring(8, 10);
/* 208 */       serialLen = 6;
/*     */     }
/* 224 */     else if (cNoType.equals("RPTNO"))
/*     */     {
/* 226 */       tReturn = "50" + tCom;
/*     */     }
/* 230 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 232 */       tReturn = "51" + tCom;
/*     */     }
/* 236 */     else if (cNoType.equals("CLMNO"))
/*     */     {
/* 238 */       tReturn = "52" + tCom;
/*     */     }
/* 242 */     else if (cNoType.equals("DECLINENO"))
/*     */     {
/* 244 */       tReturn = "53" + tCom;
/*     */     }
/* 248 */     else if (cNoType.equals("SUBRPTNO"))
/*     */     {
/* 250 */       tReturn = "54" + tCom;
/*     */     }
/* 254 */     else if (cNoType.equals("CASENO"))
/*     */     {
/* 256 */       tReturn = "55" + tCom;
/*     */     }
/* 260 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 262 */       tReturn = "71" + tCom;
/*     */     }
/* 266 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 268 */       tReturn = "80" + tCom;
/*     */     }
/* 272 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 274 */       tReturn = "81" + tCom;
/*     */     }
/* 278 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 280 */       tReturn = "82" + tCom;
/*     */     }
/* 283 */     else if (cNoType.equals("CONTPRTSEQ"))
/*     */     {
/* 285 */       tReturn = "83" + tCom;
/* 286 */       serialLen = 6;
/*     */     }
/* 291 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 293 */       tReturn = "61" + tCom;
/*     */     }
/* 297 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 299 */       tReturn = "62" + tCom;
/*     */     }
/* 303 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 305 */       tReturn = "63" + tCom;
/*     */     }
/* 309 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 311 */       tReturn = "90" + tCom;
/*     */     }
/* 315 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 317 */       tReturn = "98" + tCom;
/*     */     }
/*     */ 
/* 326 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 328 */     if (conn == null)
/*     */     {
/* 330 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 332 */       return tReturn;
/*     */     }
/*     */ 
/* 335 */     int tMaxNo = 0;
/* 336 */     cNoLimit = tReturn;
/*     */     try
/*     */     {
/* 345 */       conn.setAutoCommit(false);
/*     */ 
/* 355 */       StringBuffer tSBql = new StringBuffer(256);
/* 356 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 357 */       tSBql.append(cNoType);
/* 358 */       tSBql.append("' and nolimit='");
/* 359 */       tSBql.append(cNoLimit);
/* 360 */       tSBql.append("' for update");
/*     */ 
/* 362 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 364 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 367 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 368 */       String result = null;
/* 369 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 372 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 374 */         System.out.println("\u67E5\u8BE2LDMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/* 375 */         conn.rollback();
/* 376 */         conn.close();
/*     */ 
/* 378 */         return null;
/*     */       }
/*     */ 
/* 381 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 385 */         tSBql = new StringBuffer(256);
/* 386 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 387 */         tSBql.append(cNoType);
/* 388 */         tSBql.append("', '");
/* 389 */         tSBql.append(cNoLimit);
/* 390 */         tSBql.append("', 1)");
/*     */ 
/* 392 */         exeSQL = new ExeSQL(conn);
/* 393 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 395 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 396 */           conn.rollback();
/* 397 */           conn.close();
/*     */ 
/* 399 */           return null;
/*     */         }
/*     */ 
/* 403 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 410 */         tSBql = new StringBuffer(256);
/* 411 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 412 */         tSBql.append(cNoType);
/* 413 */         tSBql.append("' and nolimit = '");
/* 414 */         tSBql.append(cNoLimit);
/* 415 */         tSBql.append("'");
/*     */ 
/* 417 */         exeSQL = new ExeSQL(conn);
/* 418 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 420 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 421 */           conn.rollback();
/* 422 */           conn.close();
/*     */ 
/* 424 */           return null;
/*     */         }
/*     */ 
/* 428 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 432 */       conn.commit();
/* 433 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 439 */         conn.rollback();
/* 440 */         conn.close();
/*     */ 
/* 442 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 446 */         e1.printStackTrace();
/*     */ 
/* 448 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 453 */     String tStr = String.valueOf(tMaxNo);
/* 454 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 457 */     if (tReturn.equals("SN"))
/*     */     {
/* 459 */       tReturn = tStr.trim() + "0";
/*     */     }
/*     */     else
/*     */     {
/* 463 */       tReturn = tReturn.trim() + tStr.trim();
/*     */     }
/*     */ 
/* 466 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 472 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 473 */       (cNoLength <= 0))
/*     */     {
/* 475 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/* 477 */       return null;
/*     */     }
/*     */ 
/* 480 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 483 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 485 */     if (conn == null)
/*     */     {
/* 487 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 489 */       return null;
/*     */     }
/*     */ 
/* 492 */     String tReturn = "";
/* 493 */     String cNoLimit = "SN";
/*     */ 
/* 495 */     if ((cNoType.equals("COMMISIONSN")) || 
/* 496 */       (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 497 */       (cNoType.equals("SUGDATAITEMCODE")) || 
/* 498 */       (cNoType.equals("SUGITEMCODE")) || 
/* 499 */       (cNoType.equals("SUGMODELCODE")) || 
/* 500 */       (cNoType.equals("SUGCODE")))
/*     */     {
/* 503 */       System.out.println("\u8BE5\u7C7B\u578B\u6D41\u6C34\u53F7\uFF0C\u8BF7\u91C7\u7528CreateMaxNo('" + cNoType + 
/* 504 */         "','SN')\u65B9\u5F0F\u751F\u6210");
/* 505 */       return null;
/*     */     }
/* 507 */     BigInteger tMaxNo = new BigInteger("0");
/* 508 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 513 */       conn.setAutoCommit(false);
/*     */ 
/* 523 */       StringBuffer tSBql = new StringBuffer(256);
/* 524 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 525 */       tSBql.append(cNoType);
/* 526 */       tSBql.append("' and nolimit='");
/* 527 */       tSBql.append(cNoLimit);
/* 528 */       tSBql.append("' for update");
/*     */ 
/* 530 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 532 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 535 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 536 */       String result = null;
/* 537 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 539 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 541 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 542 */         conn.rollback();
/* 543 */         conn.close();
/*     */ 
/* 545 */         return null;
/*     */       }
/*     */ 
/* 548 */       if (result.equals(""))
/*     */       {
/* 552 */         tSBql = new StringBuffer(256);
/* 553 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 554 */         tSBql.append(cNoType);
/* 555 */         tSBql.append("', '");
/* 556 */         tSBql.append(cNoLimit);
/* 557 */         tSBql.append("', 1)");
/*     */ 
/* 559 */         exeSQL = new ExeSQL(conn);
/* 560 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 562 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 563 */           conn.rollback();
/* 564 */           conn.close();
/*     */ 
/* 566 */           return null;
/*     */         }
/*     */ 
/* 570 */         tMaxNo = new BigInteger("1");
/*     */       }
/*     */       else
/*     */       {
/* 577 */         tSBql = new StringBuffer(256);
/* 578 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 579 */         tSBql.append(cNoType);
/* 580 */         tSBql.append("' and nolimit = '");
/* 581 */         tSBql.append(cNoLimit);
/* 582 */         tSBql.append("'");
/*     */ 
/* 584 */         exeSQL = new ExeSQL(conn);
/* 585 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 587 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 588 */           conn.rollback();
/* 589 */           conn.close();
/*     */ 
/* 591 */           return null;
/*     */         }
/*     */ 
/* 595 */         tMaxNo = new BigInteger(result).add(new BigInteger("1"));
/*     */       }
/*     */ 
/* 599 */       conn.commit();
/* 600 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 606 */         conn.rollback();
/* 607 */         conn.close();
/*     */ 
/* 609 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 613 */         e1.printStackTrace();
/*     */ 
/* 615 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 619 */     String tStr = tMaxNo.toString();
/* 620 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 621 */     tReturn = tStr.trim();
/*     */ 
/* 623 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 639 */     String tAgentGroup = PubFun1.CreateMaxNo("AgentGroup", 12);
/* 640 */     System.out.println("AgentGroup:" + tAgentGroup);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoNCL
 * JD-Core Version:    0.6.0
 */