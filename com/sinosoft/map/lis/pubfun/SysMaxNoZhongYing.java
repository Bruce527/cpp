/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ 
/*     */ public class SysMaxNoZhongYing
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  27 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit)
/*     */   {
/*  34 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/*  35 */       (cNoLimit == null))
/*     */     {
/*  37 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*     */ 
/*  39 */       return null;
/*     */     }
/*     */ 
/*  43 */     int serialLen = 10;
/*  44 */     String tReturn = null;
/*  45 */     cNoType = cNoType.toUpperCase();
/*     */ 
/*  49 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/*  52 */       if ((cNoType.equals("COMMISIONSN")) || 
/*  53 */         (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/*  54 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/*  55 */         (cNoType.equals("SUGITEMCODE")) || 
/*  56 */         (cNoType.equals("SUGMODELCODE")) || 
/*  57 */         (cNoType.equals("SUGCODE")) || 
/*  58 */         (cNoType.equals("ACCNO")) || (cNoType.equals("RPTONLYNO")))
/*     */       {
/*  60 */         serialLen = 9;
/*     */       }
/*     */       else
/*     */       {
/*  64 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/*     */ 
/*  66 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  71 */     if (cNoType.equals("AIRPOLNO"))
/*     */     {
/*  73 */       serialLen = 6;
/*     */     }
/*     */ 
/*  76 */     if ((cNoType.equals("AGENTCODE")) || (cNoType.equals("MANAGECOM")))
/*     */     {
/*  78 */       serialLen = 4;
/*     */     }
/*     */ 
/*  81 */     tReturn = cNoLimit.trim();
/*     */ 
/*  84 */     String tCom = "";
/*  85 */     if (tReturn.length() >= 4)
/*     */     {
/*  87 */       tCom = tReturn.substring(2, 4);
/*  88 */       tCom = "0" + tCom;
/*  89 */       tReturn = tReturn.substring(0, 4);
/*     */     }
/*     */ 
/*  94 */     if (cNoType.equals("PROPOSALNO"))
/*     */     {
/*  96 */       tReturn = "11" + tCom;
/*     */     }
/* 100 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 102 */       tReturn = "12" + tCom;
/*     */     }
/* 106 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 108 */       tReturn = "13" + tCom;
/*     */     }
/* 112 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 114 */       tReturn = "14" + tCom;
/*     */     }
/* 118 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 120 */       tReturn = "21" + tCom;
/*     */     }
/* 124 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 126 */       tReturn = "22" + tCom;
/*     */     }
/* 130 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 132 */       tReturn = "0";
/*     */     }
/* 138 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 140 */       tReturn = "24" + tCom;
/*     */     }
/* 144 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 146 */       tReturn = "31" + tCom;
/*     */     }
/* 150 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 152 */       tReturn = "32" + tCom;
/*     */     }
/* 156 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 158 */       tReturn = "36" + tCom;
/*     */     }
/* 162 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 164 */       tReturn = "37" + tCom;
/*     */     }
/* 168 */     else if (cNoType.equals("EDORAPPNO"))
/*     */     {
/* 170 */       tReturn = "41" + tCom;
/*     */     }
/* 174 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 176 */       tReturn = "42" + tCom;
/*     */     }
/* 180 */     else if (cNoType.equals("EDORGRPAPPNO"))
/*     */     {
/* 182 */       tReturn = "43" + tCom;
/*     */     }
/* 186 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 188 */       tReturn = "44" + tCom;
/*     */     }
/* 204 */     else if (cNoType.equals("RPTNO"))
/*     */     {
/* 206 */       tReturn = "50" + tCom;
/*     */     }
/* 210 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 212 */       tReturn = "51" + tCom;
/*     */     }
/* 216 */     else if (cNoType.equals("CLMNO"))
/*     */     {
/* 218 */       tReturn = "52" + tCom;
/*     */     }
/* 222 */     else if (cNoType.equals("DECLINENO"))
/*     */     {
/* 224 */       tReturn = "53" + tCom;
/*     */     }
/* 228 */     else if (cNoType.equals("SUBRPTNO"))
/*     */     {
/* 230 */       tReturn = "54" + tCom;
/*     */     }
/* 234 */     else if (cNoType.equals("CASENO"))
/*     */     {
/* 236 */       tReturn = "55" + tCom;
/*     */     }
/* 240 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 242 */       tReturn = "71" + tCom;
/*     */     }
/* 246 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 248 */       tReturn = "80" + tCom;
/*     */     }
/* 252 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 254 */       tReturn = "81" + tCom;
/*     */     }
/* 258 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 260 */       tReturn = "82" + tCom;
/*     */     }
/* 264 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 266 */       tReturn = "61" + tCom;
/*     */     }
/* 270 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 272 */       tReturn = "62" + tCom;
/*     */     }
/* 276 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 278 */       tReturn = "63" + tCom;
/*     */     }
/* 282 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 284 */       tReturn = "90" + tCom;
/*     */     }
/* 288 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 290 */       tReturn = "98" + tCom;
/*     */     }
/*     */ 
/* 293 */     if (tReturn.length() == 10)
/*     */     {
/* 295 */       tReturn = tReturn + "99";
/*     */     }
/*     */ 
/* 299 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 301 */     if (conn == null)
/*     */     {
/* 303 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 305 */       return tReturn;
/*     */     }
/*     */ 
/* 308 */     int tMaxNo = 0;
/* 309 */     cNoLimit = tReturn;
/*     */     try
/*     */     {
/* 318 */       conn.setAutoCommit(false);
/*     */ 
/* 328 */       StringBuffer tSBql = new StringBuffer(256);
/* 329 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 330 */       tSBql.append(cNoType);
/* 331 */       tSBql.append("' and nolimit='");
/* 332 */       tSBql.append(cNoLimit);
/* 333 */       tSBql.append("' for update");
/*     */ 
/* 335 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 337 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 340 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 341 */       String result = null;
/* 342 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 345 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 347 */         System.out.println("\u67E5\u8BE2LDMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/* 348 */         conn.rollback();
/* 349 */         conn.close();
/*     */ 
/* 351 */         return null;
/*     */       }
/*     */ 
/* 354 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 358 */         tSBql = new StringBuffer(256);
/* 359 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 360 */         tSBql.append(cNoType);
/* 361 */         tSBql.append("', '");
/* 362 */         tSBql.append(cNoLimit);
/* 363 */         tSBql.append("', 1)");
/*     */ 
/* 365 */         exeSQL = new ExeSQL(conn);
/* 366 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 368 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 369 */           conn.rollback();
/* 370 */           conn.close();
/*     */ 
/* 372 */           return null;
/*     */         }
/*     */ 
/* 376 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 383 */         tSBql = new StringBuffer(256);
/* 384 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 385 */         tSBql.append(cNoType);
/* 386 */         tSBql.append("' and nolimit = '");
/* 387 */         tSBql.append(cNoLimit);
/* 388 */         tSBql.append("'");
/*     */ 
/* 390 */         exeSQL = new ExeSQL(conn);
/* 391 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 393 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 394 */           conn.rollback();
/* 395 */           conn.close();
/*     */ 
/* 397 */           return null;
/*     */         }
/*     */ 
/* 401 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 405 */       conn.commit();
/* 406 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 412 */         conn.rollback();
/* 413 */         conn.close();
/*     */ 
/* 415 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 419 */         e1.printStackTrace();
/*     */ 
/* 421 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 426 */     String tStr = String.valueOf(tMaxNo);
/* 427 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 430 */     if (tReturn.equals("SN"))
/*     */     {
/* 432 */       tReturn = tStr.trim() + "0";
/*     */     }
/*     */     else
/*     */     {
/* 436 */       tReturn = tReturn.trim() + tStr.trim();
/*     */     }
/*     */ 
/* 439 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 445 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 446 */       (cNoLength <= 0))
/*     */     {
/* 448 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/* 450 */       return null;
/*     */     }
/*     */ 
/* 453 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 456 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 458 */     if (conn == null)
/*     */     {
/* 460 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 462 */       return null;
/*     */     }
/*     */ 
/* 465 */     String tReturn = "";
/* 466 */     String cNoLimit = "SN";
/*     */ 
/* 468 */     if ((cNoType.equals("COMMISIONSN")) || 
/* 469 */       (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 470 */       (cNoType.equals("SUGDATAITEMCODE")) || 
/* 471 */       (cNoType.equals("SUGITEMCODE")) || 
/* 472 */       (cNoType.equals("SUGMODELCODE")) || 
/* 473 */       (cNoType.equals("SUGCODE")))
/*     */     {
/* 476 */       System.out.println("\u8BE5\u7C7B\u578B\u6D41\u6C34\u53F7\uFF0C\u8BF7\u91C7\u7528CreateMaxNo('" + cNoType + 
/* 477 */         "','SN')\u65B9\u5F0F\u751F\u6210");
/* 478 */       return null;
/*     */     }
/* 480 */     int tMaxNo = 0;
/* 481 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 486 */       conn.setAutoCommit(false);
/*     */ 
/* 496 */       StringBuffer tSBql = new StringBuffer(256);
/* 497 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 498 */       tSBql.append(cNoType);
/* 499 */       tSBql.append("' and nolimit='");
/* 500 */       tSBql.append(cNoLimit);
/* 501 */       tSBql.append("' for update");
/*     */ 
/* 503 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 505 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 508 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 509 */       String result = null;
/* 510 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 512 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 514 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 515 */         conn.rollback();
/* 516 */         conn.close();
/*     */ 
/* 518 */         return null;
/*     */       }
/*     */ 
/* 521 */       if (result.equals(""))
/*     */       {
/* 525 */         tSBql = new StringBuffer(256);
/* 526 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 527 */         tSBql.append(cNoType);
/* 528 */         tSBql.append("', '");
/* 529 */         tSBql.append(cNoLimit);
/* 530 */         tSBql.append("', 1)");
/*     */ 
/* 532 */         exeSQL = new ExeSQL(conn);
/* 533 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 535 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 536 */           conn.rollback();
/* 537 */           conn.close();
/*     */ 
/* 539 */           return null;
/*     */         }
/*     */ 
/* 543 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 550 */         tSBql = new StringBuffer(256);
/* 551 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 552 */         tSBql.append(cNoType);
/* 553 */         tSBql.append("' and nolimit = '");
/* 554 */         tSBql.append(cNoLimit);
/* 555 */         tSBql.append("'");
/*     */ 
/* 557 */         exeSQL = new ExeSQL(conn);
/* 558 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 560 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 561 */           conn.rollback();
/* 562 */           conn.close();
/*     */ 
/* 564 */           return null;
/*     */         }
/*     */ 
/* 568 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 572 */       conn.commit();
/* 573 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 579 */         conn.rollback();
/* 580 */         conn.close();
/*     */ 
/* 582 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 586 */         e1.printStackTrace();
/*     */ 
/* 588 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 592 */     String tStr = String.valueOf(tMaxNo);
/* 593 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 594 */     tReturn = tStr.trim();
/*     */ 
/* 596 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 601 */     SysMaxNoZhongYing sysMaxNoZhongYing1 = new SysMaxNoZhongYing();
/* 602 */     System.out.println(sysMaxNoZhongYing1.CreateMaxNo("GRPNO", "SN"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoZhongYing
 * JD-Core Version:    0.6.0
 */