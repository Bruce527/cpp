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
/*     */ public class SysMaxNoHASL
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
/*     */ 
/*  39 */       return null;
/*     */     }
/*     */ 
/*  43 */     int serialLen = 9;
/*  44 */     String tReturn = null;
/*  45 */     String nNolimit = cNoLimit;
/*  46 */     String tYear = PubFun.getCurrentDate().substring(0, 4);
/*  47 */     cNoType = cNoType.toUpperCase();
/*  48 */     System.out.println("-----------cNoType:" + cNoType + "  cNoLimit:" + cNoLimit);
/*     */ 
/*  51 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/*  53 */       if ((cNoType.equals("COMMISIONSN")) || 
/*  54 */         (cNoType.equals("CUSTOMERNO")) || (cNoType.equals("MEETINGNO")) || 
/*  55 */         (cNoType.equals("PRECUSTOMERNO")) || 
/*  56 */         (cNoType.equals("RISKCURNO")) || 
/*  57 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/*  58 */         (cNoType.equals("SUGITEMCODE")) || (cNoType.equals("RELATIONCODE")) || 
/*  59 */         (cNoType.equals("SUGMODELCODE")) || (cNoType.equals("PROJECTCODE")) || 
/*  60 */         (cNoType.equals("SUGCODE")) || 
/*  61 */         (cNoType.equals("ACCNO")))
/*     */       {
/*  63 */         serialLen = 9;
/*     */       }
/*  65 */       else if (cNoType.equals("GRPNO"))
/*     */       {
/*  67 */         serialLen = 8;
/*     */       }
/*  70 */       else if (cNoType.equals("ACCIDETAIL"))
/*     */       {
/*  72 */         serialLen = 5;
/*     */       }
/*  75 */       else if (cNoType.equals("BANKPROCODE"))
/*     */       {
/*  77 */         serialLen = 2;
/*     */       }
/*  80 */       else if (cNoType.equals("SHORTBANKCODE"))
/*     */       {
/*  82 */         serialLen = 2;
/*     */       }
/*     */       else
/*     */       {
/*  86 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/*     */ 
/*  88 */         return null;
/*     */       }
/*     */     }
/*     */ 
/*  92 */     if (cNoType.equals("GRPCONTNO"))
/*     */     {
/*  94 */       serialLen = 7;
/*     */     }
/*     */ 
/*  97 */     if (cNoType.equals("PLANBIDPROTOCOLNO"))
/*     */     {
/*  99 */       serialLen = 3;
/*     */     }
/*     */ 
/* 102 */     if (cNoType.equals("PLANBIDPROTOCOLNO4"))
/*     */     {
/* 104 */       serialLen = 4;
/*     */     }
/*     */ 
/* 107 */     if (cNoType.equals("PROJECTMANAGE"))
/*     */     {
/* 109 */       serialLen = 3;
/*     */     }
/*     */ 
/* 112 */     if (cNoType.equals("PROMANAGEAGENTCODE"))
/*     */     {
/* 114 */       serialLen = 10;
/*     */     }
/*     */ 
/* 117 */     if (cNoType.equals("NEWGRPCONTNO"))
/*     */     {
/* 119 */       serialLen = 5;
/*     */     }
/* 122 */     else if (cNoType.equals("CREATEBANK")) {
/* 123 */       serialLen = 4;
/*     */     }
/* 126 */     else if (cNoType.equals("BANKCITYCODE"))
/*     */     {
/* 128 */       serialLen = 2;
/*     */     }
/* 132 */     else if (cNoType.equals("ERRORPIECESSERIALNO")) {
/* 133 */       serialLen = 10;
/*     */     }
/* 137 */     else if (cNoType.equals("GRPBRANCHGROUP"))
/*     */     {
/* 139 */       serialLen = 2;
/*     */     }
/* 142 */     else if (cNoType.equals("CtrlLevel"))
/*     */     {
/* 144 */       serialLen = 10;
/*     */     }
/* 146 */     else if (cNoType.equals("BCtrl"))
/*     */     {
/* 148 */       serialLen = 10;
/*     */     }
/* 150 */     else if (cNoType.equals("BCtrlLevel"))
/*     */     {
/* 152 */       serialLen = 10;
/*     */     }
/*     */ 
/* 156 */     if (cNoType.equals("AIRPOLNO"))
/*     */     {
/* 158 */       serialLen = 7;
/*     */     }
/*     */ 
/* 161 */     if ((cNoType.equals("ATCODE")) || (cNoType.equals("MANAGECOM")))
/*     */     {
/* 163 */       serialLen = 4;
/*     */     }
/*     */ 
/* 166 */     tReturn = cNoLimit.trim();
/*     */ 
/* 170 */     if (cNoType.equals("PROPOSALNO"))
/*     */     {
/* 172 */       tReturn = "11";
/*     */     }
/* 175 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 177 */       tReturn = "12";
/*     */     }
/* 180 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 182 */       tReturn = "13";
/*     */     }
/* 185 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 187 */       tReturn = "14";
/*     */     }
/* 190 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 192 */       tReturn = "21";
/*     */     }
/* 195 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 197 */       tReturn = "22";
/*     */     }
/* 200 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 202 */       tReturn = "88";
/*     */     }
/* 205 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 207 */       tReturn = "99";
/*     */     }
/* 210 */     else if (cNoType.equals("NEWGRPCONTNO"))
/*     */     {
/* 212 */       tReturn = "99";
/*     */     }
/* 216 */     else if (cNoType.equals("ERRORPIECESSERIALNO")) {
/* 217 */       tReturn = "91";
/*     */     }
/* 220 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 222 */       tReturn = "31";
/*     */     }
/* 225 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 227 */       tReturn = "32";
/*     */     }
/* 230 */     else if (cNoType.equals("TEMPFEENO"))
/*     */     {
/* 232 */       tReturn = "33";
/*     */     }
/* 235 */     else if (cNoType.equals("ORITEMPFEENO"))
/*     */     {
/* 237 */       tReturn = "34";
/*     */     }
/* 240 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 242 */       tReturn = "36";
/*     */     }
/* 245 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 247 */       tReturn = "37";
/*     */     }
/* 250 */     else if (cNoType.equals("CLIENTID"))
/*     */     {
/* 252 */       tReturn = "17";
/*     */     }
/* 255 */     else if (cNoType.equals("SERVICENO"))
/*     */     {
/* 257 */       tReturn = "15";
/*     */     }
/* 260 */     else if (cNoType.equals("EDORACCEPTNO"))
/*     */     {
/* 262 */       tReturn = "46";
/*     */     }
/* 265 */     else if ("NEWEDORNO".equals(cNoType))
/*     */     {
/* 267 */       serialLen = 5;
/*     */     }
/* 269 */     else if ("MANO".equals(cNoType))
/*     */     {
/* 271 */       serialLen = 5;
/*     */     }
/* 274 */     else if (cNoType.equals("TRIALNO"))
/*     */     {
/* 276 */       tReturn = "66";
/*     */     }
/* 279 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 281 */       tReturn = "42";
/*     */     }
/* 284 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 286 */       tReturn = "46";
/*     */     }
/* 289 */     else if (cNoType.equals("EDORECLOGNO"))
/*     */     {
/* 291 */       tReturn = "26";
/*     */     }
/* 295 */     else if (cNoType.equals("RPTNO"))
/*     */     {
/* 299 */       serialLen = 5;
/*     */     }
/* 302 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 306 */       serialLen = 5;
/*     */     }
/* 308 */     else if (cNoType.equals("RPTONLYNO"))
/*     */     {
/* 312 */       serialLen = 5;
/*     */     }
/* 315 */     else if (cNoType.equals("CLMNO"))
/*     */     {
/* 319 */       serialLen = 5;
/*     */     }
/* 322 */     else if (cNoType.equals("DECLINENO"))
/*     */     {
/* 324 */       tReturn = "57";
/*     */     }
/* 327 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 329 */       tReturn = "72";
/*     */     }
/* 332 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 334 */       tReturn = "80";
/*     */     }
/* 337 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 339 */       tReturn = "81";
/*     */     }
/* 342 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 344 */       tReturn = "82";
/*     */     }
/* 347 */     else if (cNoType.equals("CONTPRTSEQ"))
/*     */     {
/* 349 */       tReturn = "83";
/* 350 */       serialLen = 6;
/*     */     }
/* 353 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 355 */       tReturn = "65";
/*     */     }
/* 358 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 360 */       tReturn = "64";
/*     */     }
/* 363 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 365 */       tReturn = "68";
/*     */     }
/* 368 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 370 */       tReturn = "90";
/*     */     }
/* 373 */     else if (cNoType.equals("BALANCEALLNO"))
/*     */     {
/* 375 */       tReturn = "85";
/*     */     }
/* 378 */     else if (cNoType.equalsIgnoreCase("CouNo"))
/*     */     {
/* 380 */       tReturn = "75";
/*     */     }
/* 383 */     else if (cNoType.equals("PRICINGNO"))
/*     */     {
/* 385 */       tReturn = "95";
/*     */     }
/* 389 */     else if (cNoType.equals("PRICINGLOGNO"))
/*     */     {
/* 391 */       tReturn = "45";
/*     */     }
/* 396 */     else if (cNoType.equals("REBALANCENO"))
/*     */     {
/* 398 */       tReturn = "39";
/*     */     }
/* 401 */     else if (cNoType.equals("REBALANCELOGNO"))
/*     */     {
/* 403 */       tReturn = "30";
/*     */     }
/* 406 */     else if (cNoType.equals("REBALANCELISTNO"))
/*     */     {
/* 408 */       tReturn = "74";
/*     */     }
/* 411 */     else if (cNoType.equals("FUNDSWITCHNO"))
/*     */     {
/* 413 */       tReturn = "55";
/*     */     }
/* 417 */     else if (cNoType.equals("COU"))
/*     */     {
/* 419 */       tReturn = "35";
/*     */     }
/* 423 */     else if (cNoType.equals("ROLLBACKNO"))
/*     */     {
/* 425 */       tReturn = "50";
/*     */     }
/* 429 */     else if (cNoType.equals("MATURITYNO"))
/*     */     {
/* 431 */       tReturn = "56";
/*     */     }
/* 435 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 437 */       tReturn = "98";
/* 438 */       serialLen = 10;
/*     */     }
/* 441 */     else if (cNoType.equals("CIRCERRORSEQ"))
/*     */     {
/* 443 */       tReturn = "44";
/*     */     }
/* 446 */     else if (cNoType.equals("BANKCODE"))
/*     */     {
/* 448 */       tReturn = "8";
/* 449 */       serialLen = 6;
/*     */     }
/* 452 */     else if (cNoType.equals("MOVENO"))
/*     */     {
/* 454 */       tReturn = "16";
/* 455 */       serialLen = 10;
/*     */     }
/* 458 */     else if (cNoType.equals("RISKASSESS"))
/*     */     {
/* 460 */       serialLen = 5;
/*     */     }
/* 463 */     else if (cNoType.equals("LLGRANTNO"))
/*     */     {
/* 465 */       tReturn = "25";
/*     */     }
/*     */ 
/* 469 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 471 */     if (conn == null)
/*     */     {
/* 473 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 475 */       return tReturn;
/*     */     }
/*     */ 
/* 478 */     int tMaxNo = 0;
/*     */ 
/* 480 */     if ((!cNoLimit.trim().toUpperCase().equals("SN")) && (!cNoLimit.trim().toUpperCase().equals("SYS_PRT")))
/*     */     {
/* 482 */       if (cNoType.equals("GRPCONTNO"))
/*     */       {
/* 484 */         cNoLimit = "5";
/*     */       }
/* 487 */       else if ((cNoType.equals("RPTNO")) || (cNoType.equals("RGTNO")) || 
/* 488 */         (cNoType.equals("RPTONLYNO")) || (cNoType.equals("CLMNO")))
/*     */       {
/* 490 */         String subYear = tYear.substring(2, 4);
/* 491 */         String subCom = cNoLimit.substring(2);
/* 492 */         cNoLimit = subYear + subCom;
/*     */       }
/* 495 */       else if (!cNoType.equals("CREATEBANK"))
/*     */       {
/* 499 */         if (!cNoType.equals("BANKCITYCODE"))
/*     */         {
/* 504 */           if (cNoType.equals("NEWGRPCONTNO"))
/*     */           {
/* 506 */             String year = cNoLimit.substring(8, 10);
/* 507 */             String tcom = cNoLimit.substring(2, 6);
/* 508 */             cNoLimit = year.trim() + tcom.trim();
/*     */           }
/* 511 */           else if (cNoType.equals("GRPBRANCHGROUP"))
/*     */           {
/* 513 */             cNoLimit = tReturn;
/*     */           }
/* 516 */           else if ("NEWEDORNO".equals(cNoType))
/*     */           {
/* 519 */             String year = cNoLimit.substring(8, 10);
/* 520 */             String com = cNoLimit.substring(2, 6);
/* 521 */             cNoLimit = year.trim() + com.trim();
/*     */           }
/* 524 */           else if ("MANO".equals(cNoType))
/*     */           {
/* 526 */             String year = cNoLimit.substring(8, 10);
/* 527 */             String com = cNoLimit.substring(2, 6);
/* 528 */             cNoLimit = year.trim() + com.trim();
/*     */           }
/* 531 */           else if ("RISKASSESS".equals(cNoType))
/*     */           {
/* 534 */             cNoLimit = PubFun.LCh(cNoLimit, "0", 10);
/*     */ 
/* 536 */             String year = cNoLimit.substring(8, 10);
/* 537 */             String com = cNoLimit.substring(2, 6);
/* 538 */             cNoLimit = com.trim() + year.trim();
/*     */           }
/*     */           else
/*     */           {
/* 543 */             cNoLimit = tYear + tReturn;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 554 */       conn.setAutoCommit(false);
/*     */ 
/* 556 */       StringBuffer tSBql = new StringBuffer(256);
/*     */ 
/* 559 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 560 */       tSBql.append(cNoType);
/* 561 */       tSBql.append("' and nolimit='");
/* 562 */       tSBql.append(cNoLimit);
/* 563 */       tSBql.append("' for update");
/*     */ 
/* 567 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 568 */       String result = null;
/* 569 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 572 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 574 */         System.out.println("\u67E5\u8BE2LDMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/* 575 */         conn.rollback();
/* 576 */         conn.close();
/*     */ 
/* 578 */         return null;
/*     */       }
/*     */ 
/* 581 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 583 */         tSBql = new StringBuffer(256);
/*     */ 
/* 586 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 587 */         tSBql.append(cNoType);
/* 588 */         tSBql.append("', '");
/* 589 */         tSBql.append(cNoLimit);
/* 590 */         tSBql.append("', 1)");
/*     */ 
/* 592 */         exeSQL = new ExeSQL(conn);
/* 593 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 595 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 596 */           conn.rollback();
/* 597 */           conn.close();
/*     */ 
/* 599 */           return null;
/*     */         }
/*     */ 
/* 603 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 608 */         tSBql = new StringBuffer(256);
/*     */ 
/* 611 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 612 */         tSBql.append(cNoType);
/* 613 */         tSBql.append("' and nolimit = '");
/* 614 */         tSBql.append(cNoLimit);
/* 615 */         tSBql.append("'");
/*     */ 
/* 617 */         exeSQL = new ExeSQL(conn);
/* 618 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 620 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 621 */           conn.rollback();
/* 622 */           conn.close();
/*     */ 
/* 624 */           return null;
/*     */         }
/*     */ 
/* 628 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 632 */       conn.commit();
/* 633 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 641 */         conn.rollback();
/* 642 */         conn.close();
/*     */ 
/* 644 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 648 */         e1.printStackTrace();
/*     */ 
/* 650 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 654 */     String tStr = String.valueOf(tMaxNo);
/* 655 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 658 */     String tCheck = "0";
/*     */ 
/* 660 */     if (tReturn.equals("SN"))
/*     */     {
/* 662 */       tReturn = tStr.trim() + "0";
/*     */     }
/* 665 */     else if ((cNoType.equals("RPTNO")) || (cNoType.equals("RGTNO")) || 
/* 666 */       (cNoType.equals("RPTONLYNO")) || (cNoType.equals("CLMNO")))
/*     */     {
/* 668 */       tReturn = "C" + cNoLimit + tStr;
/*     */     }
/* 670 */     else if ((cNoType != null) && (cNoType.toUpperCase().equals("GRPCONTNO")))
/*     */     {
/* 672 */       tReturn = "5" + tStr.trim();
/*     */     }
/* 676 */     else if ((cNoType != null) && (cNoType.toUpperCase().equals("NEWGRPCONTNO")))
/*     */     {
/* 678 */       String NYear = PubFun.getCurrentDate().substring(2, 4);
/* 679 */       String comcode = (String)nNolimit.subSequence(2, 6);
/* 680 */       tReturn = "P" + NYear.trim() + comcode.trim() + tStr.trim();
/*     */     }
/* 684 */     else if ((cNoType != null) && (cNoType.toUpperCase().equals("ERRORPIECESSERIALNO"))) {
/* 685 */       tReturn = cNoLimit.trim() + tStr.trim() + tReturn.trim();
/*     */     }
/* 688 */     else if (cNoType.equals("BANKCODE"))
/*     */     {
/* 691 */       tReturn = tYear + tStr.trim();
/*     */     }
/* 694 */     else if (cNoType.equals("GRPBRANCHGROUP"))
/*     */     {
/* 696 */       tReturn = tReturn + tStr.trim();
/*     */     }
/* 699 */     else if ("NEWEDORNO".equals(cNoType))
/*     */     {
/* 701 */       String head = "S";
/* 702 */       tReturn = head.trim() + cNoLimit.trim() + tStr.trim();
/*     */     }
/* 704 */     else if ("MANO".equals(cNoType))
/*     */     {
/* 706 */       String head = "M";
/* 707 */       tReturn = head.trim() + cNoLimit.trim() + tStr.trim();
/*     */     }
/* 710 */     else if ("RISKASSESS".equals(cNoType))
/*     */     {
/* 712 */       String head = "R";
/* 713 */       tReturn = head.trim() + cNoLimit.trim() + tStr.trim();
/*     */     }
/*     */     else
/*     */     {
/* 718 */       tReturn = tYear + tStr.trim() + tCheck + tReturn;
/*     */     }
/*     */ 
/* 722 */     if ("ACCIDETAIL".equals(cNoType)) {
/* 723 */       tReturn = "ZZN" + tStr.trim();
/*     */     }
/*     */ 
/* 727 */     if ("CREATEBANK".equals(cNoType)) {
/* 728 */       tReturn = cNoLimit + tStr.trim();
/*     */     }
/* 730 */     if ("BANKPROCODE".equals(cNoType)) {
/* 731 */       tReturn = tStr.trim().substring(0, 2);
/*     */     }
/* 733 */     if ("BANKCITYCODE".equals(cNoType)) {
/* 734 */       tReturn = tStr.trim().substring(0, 2);
/*     */     }
/*     */ 
/* 737 */     if ("SHORTBANKCODE".equals(cNoType))
/*     */     {
/* 739 */       tReturn = tStr.trim().substring(0, 2);
/*     */     }
/*     */ 
/* 744 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String GetAccountId(String tStr)
/*     */   {
/* 749 */     String tMod = "109876532";
/* 750 */     String tStr1 = "";
/* 751 */     String tStr2 = "";
/* 752 */     String tReturn = "";
/* 753 */     tStr1 = PubFun.LCh(tStr, "0", 9);
/* 754 */     double j = 0.0D;
/* 755 */     int k = 0;
/* 756 */     for (int i = 1; i <= 9; i++)
/*     */     {
/* 758 */       j += Integer.parseInt(tStr1.substring(i - 1, i)) * Math.pow(2.0D, i - 1);
/*     */     }
/*     */ 
/* 761 */     k = (int)Math.floor(j) % 9;
/* 762 */     k++;
/* 763 */     tStr2 = tStr1.trim() + tMod.substring(k - 1, k);
/* 764 */     tReturn = tStr2;
/* 765 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 771 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 772 */       (cNoLength <= 0))
/*     */     {
/* 774 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/* 776 */       return null;
/*     */     }
/*     */ 
/* 779 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 781 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 783 */     if (conn == null)
/*     */     {
/* 785 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 787 */       return null;
/*     */     }
/*     */ 
/* 790 */     String tReturn = "";
/* 791 */     String cNoLimit = "SN";
/*     */ 
/* 804 */     BigInteger tMaxNo = new BigInteger("0");
/* 805 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 810 */       conn.setAutoCommit(false);
/*     */ 
/* 820 */       StringBuffer tSBql = new StringBuffer(256);
/*     */ 
/* 823 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 824 */       tSBql.append(cNoType);
/* 825 */       tSBql.append("' and nolimit='");
/* 826 */       tSBql.append(cNoLimit);
/* 827 */       tSBql.append("' for update");
/*     */ 
/* 832 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 833 */       String result = null;
/* 834 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 836 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 838 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 839 */         conn.rollback();
/* 840 */         conn.close();
/*     */ 
/* 842 */         return null;
/*     */       }
/*     */ 
/* 845 */       if (result.equals(""))
/*     */       {
/* 847 */         tSBql = new StringBuffer(256);
/*     */ 
/* 850 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 851 */         tSBql.append(cNoType);
/* 852 */         tSBql.append("', '");
/* 853 */         tSBql.append(cNoLimit);
/* 854 */         tSBql.append("', 1)");
/*     */ 
/* 856 */         exeSQL = new ExeSQL(conn);
/* 857 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 859 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 860 */           conn.rollback();
/* 861 */           conn.close();
/*     */ 
/* 863 */           return null;
/*     */         }
/*     */ 
/* 867 */         tMaxNo = new BigInteger("1");
/*     */       }
/*     */       else
/*     */       {
/* 872 */         tSBql = new StringBuffer(256);
/*     */ 
/* 875 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 876 */         tSBql.append(cNoType);
/* 877 */         tSBql.append("' and nolimit = '");
/* 878 */         tSBql.append(cNoLimit);
/* 879 */         tSBql.append("'");
/*     */ 
/* 881 */         exeSQL = new ExeSQL(conn);
/* 882 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 884 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 885 */           conn.rollback();
/* 886 */           conn.close();
/*     */ 
/* 888 */           return null;
/*     */         }
/*     */ 
/* 892 */         tMaxNo = new BigInteger(result).add(new BigInteger("1"));
/*     */       }
/*     */ 
/* 896 */       conn.commit();
/* 897 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 903 */         conn.rollback();
/* 904 */         conn.close();
/*     */ 
/* 906 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 910 */         e1.printStackTrace();
/*     */ 
/* 912 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 916 */     String tStr = tMaxNo.toString();
/* 917 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 918 */     tReturn = tStr.trim();
/*     */ 
/* 920 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 941 */     String strLimit = PubFun.getNoLimit("860401");
/* 942 */     String strRiskAssessNo = PubFun1.CreateMaxNo("RISKASSESS", strLimit);
/* 943 */     System.out.println("=============RiskAssessNo:" + strRiskAssessNo + "==============");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoHASL
 * JD-Core Version:    0.6.0
 */