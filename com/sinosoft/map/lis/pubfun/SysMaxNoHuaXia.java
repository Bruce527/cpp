/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ 
/*     */ public class SysMaxNoHuaXia
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
/*  43 */     int serialLen = 9;
/*     */ 
/*  45 */     if ((cNoType != null) && (cNoType.trim().toUpperCase().equals("GRPCONTNO"))) {
/*  46 */       serialLen = 7;
/*     */     }
/*  48 */     String tReturn = null;
/*  49 */     String tYear = PubFun.getCurrentDate().substring(0, 4);
/*  50 */     cNoType = cNoType.toUpperCase();
/*     */ 
/*  53 */     String prtBatch = "01";
/*     */ 
/*  56 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/*  60 */       if ((cNoType.equals("COMMISIONSN")) || 
/*  63 */         (cNoType.equals("CUSTOMERNO")) || 
/*  64 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/*  65 */         (cNoType.equals("SUGITEMCODE")) || 
/*  66 */         (cNoType.equals("SUGMODELCODE")) || 
/*  67 */         (cNoType.equals("SUGCODE")))
/*     */       {
/*  69 */         serialLen = 9;
/*     */       }
/*  73 */       else if (cNoType.equals("GRPNO"))
/*     */       {
/*  75 */         serialLen = 8;
/*     */       }
/*     */       else
/*     */       {
/*  79 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/*  80 */         return null;
/*     */       }
/*     */     }
/*  83 */     else if (cNoLimit.trim().toUpperCase().equals("SYS_PRT"))
/*     */     {
/*  85 */       serialLen = 8;
/*     */     }
/*     */ 
/*  89 */     if (cNoType.equals("AIRPOLNO"))
/*     */     {
/*  91 */       serialLen = 7;
/*     */     }
/*     */ 
/*  94 */     if ((cNoType.equals("AGENTCODE")) || (cNoType.equals("MANAGECOM")))
/*     */     {
/*  96 */       serialLen = 4;
/*     */     }
/*     */ 
/*  99 */     tReturn = cNoLimit.trim();
/*     */ 
/* 103 */     if (cNoType.equals("PROPOSALNO"))
/*     */     {
/* 105 */       tReturn = "11";
/*     */     }
/* 109 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 111 */       tReturn = "12";
/*     */     }
/* 115 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 117 */       tReturn = "13";
/*     */     }
/* 121 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 123 */       tReturn = "14";
/*     */     }
/* 127 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 129 */       tReturn = "21";
/*     */     }
/* 133 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 135 */       tReturn = "22";
/*     */     }
/* 139 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 141 */       tReturn = "88";
/*     */     }
/* 145 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 147 */       tReturn = "99";
/*     */     }
/* 151 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 153 */       tReturn = "31";
/*     */     }
/* 157 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 159 */       tReturn = "32";
/*     */     }
/* 163 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 165 */       tReturn = "36";
/*     */     }
/* 169 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 171 */       tReturn = "37";
/*     */     }
/* 175 */     else if (cNoType.equals("EDORAPPNO"))
/*     */     {
/* 177 */       tReturn = "41";
/*     */     }
/* 181 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 183 */       tReturn = "42";
/*     */     }
/* 187 */     else if (cNoType.equals("EDORGRPAPPNO"))
/*     */     {
/* 189 */       tReturn = "43";
/*     */     }
/* 193 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 195 */       tReturn = "44";
/*     */     }
/* 199 */     else if (cNoType.equals("RPTNO"))
/*     */     {
/* 201 */       tReturn = "50";
/*     */     }
/* 205 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 207 */       tReturn = "51";
/*     */     }
/* 211 */     else if (cNoType.equals("CLMNO"))
/*     */     {
/* 213 */       tReturn = "52";
/*     */     }
/* 217 */     else if (cNoType.equals("DECLINENO"))
/*     */     {
/* 219 */       tReturn = "53";
/*     */     }
/* 223 */     else if (cNoType.equals("SUBRPTNO"))
/*     */     {
/* 225 */       tReturn = "54";
/*     */     }
/* 229 */     else if (cNoType.equals("CASENO"))
/*     */     {
/* 231 */       tReturn = "55";
/*     */     }
/* 235 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 237 */       tReturn = "71";
/*     */     }
/* 241 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 243 */       tReturn = "80";
/*     */     }
/* 247 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 249 */       tReturn = "81";
/*     */     }
/* 253 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 255 */       tReturn = "82";
/*     */     }
/* 259 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 261 */       tReturn = "61";
/*     */     }
/* 265 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 267 */       tReturn = "62";
/*     */     }
/* 271 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 273 */       tReturn = "63";
/*     */     }
/* 277 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 279 */       tReturn = "90";
/*     */     }
/* 283 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 285 */       tReturn = "98";
/*     */     }
/* 289 */     else if (cNoType.equals("SPNO_TJ"))
/*     */     {
/* 291 */       tReturn = "1101";
/*     */     }
/* 293 */     else if (cNoType.equals("SPNO_TJCB"))
/*     */     {
/* 295 */       tReturn = "1102";
/*     */     }
/* 297 */     else if (cNoType.equals("SPNO_MJ"))
/*     */     {
/* 299 */       tReturn = "1103";
/*     */     }
/* 301 */     else if (cNoType.equals("SPNO_MJCB"))
/*     */     {
/* 303 */       tReturn = "1104";
/*     */     }
/* 305 */     else if (cNoType.equals("SPNO_HB"))
/*     */     {
/* 307 */       tReturn = "1105";
/*     */     }
/* 309 */     else if (cNoType.equals("SPNO_HBCB"))
/*     */     {
/* 311 */       tReturn = "1106";
/*     */     }
/* 313 */     else if (cNoType.equals("SPNO_KHWTJ"))
/*     */     {
/* 315 */       tReturn = "1107";
/*     */     }
/* 317 */     else if (cNoType.equals("SPNO_KHWTJCB"))
/*     */     {
/* 319 */       tReturn = "1108";
/*     */     }
/* 321 */     else if (cNoType.equals("SPNO_YWYWTJ"))
/*     */     {
/* 323 */       tReturn = "1109";
/*     */     }
/* 325 */     else if (cNoType.equals("SPNO_YWYWTJCB"))
/*     */     {
/* 327 */       tReturn = "1110";
/*     */     }
/* 329 */     else if (cNoType.equals("SPNO_SQJF"))
/*     */     {
/* 331 */       tReturn = "1111";
/*     */     }
/* 333 */     else if (cNoType.equals("SPNO_JFCB"))
/*     */     {
/* 335 */       tReturn = "1112";
/*     */     }
/* 337 */     else if (cNoType.equals("SPNO_XJTB"))
/*     */     {
/* 339 */       tReturn = "1113";
/*     */     }
/* 341 */     else if (cNoType.equals("SPNO_YQTB"))
/*     */     {
/* 343 */       tReturn = "1114";
/*     */     }
/* 345 */     else if (cNoType.equals("SPNO_CXSQ"))
/*     */     {
/* 347 */       tReturn = "1115";
/*     */     }
/* 349 */     else if (cNoType.equals("SPNO_XQYTF"))
/*     */     {
/* 351 */       tReturn = "1116";
/*     */     }
/*     */ 
/* 355 */     if (tReturn.length() == 10)
/*     */     {
/* 358 */       tReturn = "00";
/*     */     }
/*     */ 
/* 362 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 364 */     if (conn == null)
/*     */     {
/* 366 */       System.out.println("CreateMaxNo : fail to get db connection");
/* 367 */       return tReturn;
/*     */     }
/*     */ 
/* 370 */     int tMaxNo = 0;
/*     */ 
/* 372 */     if ((!cNoLimit.trim().toUpperCase().equals("SN")) && (!cNoLimit.trim().toUpperCase().equals("SYS_PRT")))
/*     */     {
/* 374 */       cNoLimit = tYear + tReturn;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 383 */       conn.setAutoCommit(false);
/*     */ 
/* 393 */       StringBuffer tSBql = new StringBuffer(128);
/* 394 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 395 */       tSBql.append(cNoType);
/* 396 */       tSBql.append("' and nolimit='");
/* 397 */       tSBql.append(cNoLimit);
/* 398 */       tSBql.append("' for update");
/*     */ 
/* 400 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 402 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 405 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 406 */       String result = null;
/* 407 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 410 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 412 */         System.out.println("\u67E5\u8BE2LDMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/* 413 */         conn.rollback();
/* 414 */         conn.close();
/*     */ 
/* 416 */         return null;
/*     */       }
/*     */ 
/* 419 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 423 */         tSBql = new StringBuffer(128);
/* 424 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 425 */         tSBql.append(cNoType);
/* 426 */         tSBql.append("', '");
/* 427 */         tSBql.append(cNoLimit);
/* 428 */         tSBql.append("', 1)");
/*     */ 
/* 430 */         exeSQL = new ExeSQL(conn);
/* 431 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 433 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 434 */           conn.rollback();
/* 435 */           conn.close();
/*     */ 
/* 437 */           return null;
/*     */         }
/*     */ 
/* 441 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 448 */         tSBql = new StringBuffer(128);
/* 449 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 450 */         tSBql.append(cNoType);
/* 451 */         tSBql.append("' and nolimit = '");
/* 452 */         tSBql.append(cNoLimit);
/* 453 */         tSBql.append("'");
/*     */ 
/* 455 */         exeSQL = new ExeSQL(conn);
/* 456 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 458 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 459 */           conn.rollback();
/* 460 */           conn.close();
/*     */ 
/* 462 */           return null;
/*     */         }
/*     */ 
/* 466 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 470 */       conn.commit();
/* 471 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 477 */         conn.rollback();
/* 478 */         conn.close();
/*     */ 
/* 480 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 484 */         e1.printStackTrace();
/*     */ 
/* 486 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 490 */     String tStr = String.valueOf(tMaxNo);
/* 491 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 494 */     String tCheck = "0";
/*     */ 
/* 496 */     if (cNoLimit.equals("SN"))
/*     */     {
/* 499 */       tReturn = tStr.trim() + "0";
/*     */     }
/* 501 */     else if (cNoLimit.equals("SYS_PRT"))
/*     */     {
/* 504 */       tReturn = tReturn + prtBatch + tStr.trim();
/*     */     }
/* 506 */     else if ((cNoType != null) && (cNoType.toUpperCase().equals("GRPCONTNO")))
/*     */     {
/* 508 */       tReturn = "5" + tStr.trim();
/*     */     }
/*     */     else
/*     */     {
/* 513 */       tReturn = tYear + tStr.trim() + tCheck + tReturn;
/*     */     }
/* 515 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 521 */     StringBuffer tSBql = null;
/* 522 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 523 */       (cNoLength <= 0))
/*     */     {
/* 525 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/* 526 */       return null;
/*     */     }
/*     */ 
/* 529 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 531 */     Connection conn = DBConnPool.getConnection();
/* 532 */     if (conn == null)
/*     */     {
/* 534 */       System.out.println("CreateMaxNo : fail to get db connection");
/* 535 */       return null;
/*     */     }
/*     */ 
/* 538 */     String tReturn = "";
/* 539 */     String cNoLimit = "SN";
/*     */ 
/* 541 */     if ((cNoType.equals("COMMISIONSN")) || 
/* 542 */       (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 543 */       (cNoType.equals("SUGDATAITEMCODE")) || 
/* 544 */       (cNoType.equals("SUGITEMCODE")) || 
/* 545 */       (cNoType.equals("SUGMODELCODE")) || 
/* 546 */       (cNoType.equals("SUGCODE")))
/*     */     {
/* 548 */       tSBql = new StringBuffer(128);
/* 549 */       tSBql.append("\u8BE5\u7C7B\u578B\u6D41\u6C34\u53F7\uFF0C\u8BF7\u91C7\u7528CreateMaxNo('");
/* 550 */       tSBql.append(cNoType);
/* 551 */       tSBql.append("','SN')\u65B9\u5F0F\u751F\u6210");
/* 552 */       System.out.println(tSBql.toString());
/* 553 */       return null;
/*     */     }
/* 555 */     int tMaxNo = 0;
/* 556 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 561 */       conn.setAutoCommit(false);
/*     */ 
/* 571 */       tSBql = new StringBuffer(128);
/* 572 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 573 */       tSBql.append(cNoType);
/* 574 */       tSBql.append("' and nolimit='");
/* 575 */       tSBql.append(cNoLimit);
/* 576 */       tSBql.append("' for update");
/*     */ 
/* 578 */       if ("ORACLE".compareTo("ORACLE") == 0)
/*     */       {
/* 580 */         tSBql.append(" nowait");
/*     */       }
/*     */ 
/* 583 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 584 */       String result = null;
/* 585 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 587 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 589 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 590 */         conn.rollback();
/* 591 */         conn.close();
/*     */ 
/* 593 */         return null;
/*     */       }
/*     */ 
/* 596 */       if (result.equals(""))
/*     */       {
/* 600 */         tSBql = new StringBuffer(128);
/* 601 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 602 */         tSBql.append(cNoType);
/* 603 */         tSBql.append("', '");
/* 604 */         tSBql.append(cNoLimit);
/* 605 */         tSBql.append("', 1)");
/*     */ 
/* 607 */         exeSQL = new ExeSQL(conn);
/* 608 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 610 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 611 */           conn.rollback();
/* 612 */           conn.close();
/*     */ 
/* 614 */           return null;
/*     */         }
/*     */ 
/* 618 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 625 */         tSBql = new StringBuffer(128);
/* 626 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 627 */         tSBql.append(cNoType);
/* 628 */         tSBql.append("' and nolimit = '");
/* 629 */         tSBql.append(cNoLimit);
/* 630 */         tSBql.append("'");
/*     */ 
/* 632 */         exeSQL = new ExeSQL(conn);
/* 633 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 635 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 636 */           conn.rollback();
/* 637 */           conn.close();
/*     */ 
/* 639 */           return null;
/*     */         }
/*     */ 
/* 643 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 647 */       conn.commit();
/* 648 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 654 */         conn.rollback();
/* 655 */         conn.close();
/*     */ 
/* 657 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 661 */         e1.printStackTrace();
/* 662 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 666 */     String tStr = String.valueOf(tMaxNo);
/* 667 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 668 */     tReturn = tStr.trim();
/*     */ 
/* 670 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 675 */     SysMaxNoHuaXia sysMaxNoHuaXia1 = new SysMaxNoHuaXia();
/*     */ 
/* 677 */     String tLimit = PubFun.getNoLimit("86");
/* 678 */     String prtSeqNo = PubFun1.CreateMaxNo("PRTNO", tLimit);
/* 679 */     System.out.println("\n\n\n prtSeqNo = " + prtSeqNo + "\n\n\n");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoHuaXia
 * JD-Core Version:    0.6.0
 */