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
/*     */ public class SysMaxNoTK
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  29 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit)
/*     */   {
/*  36 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/*  37 */       (cNoLimit == null))
/*     */     {
/*  39 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*     */ 
/*  41 */       return null;
/*     */     }
/*     */ 
/*  45 */     int serialLen = 6;
/*  46 */     String tReturn = null;
/*  47 */     cNoType = cNoType.toUpperCase();
/*  48 */     System.out.println("-----------cNoType:" + cNoType + "  cNoLimit:" + cNoLimit);
/*     */ 
/*  51 */     if (cNoLimit.trim().toUpperCase().equals("SN"))
/*     */     {
/*  54 */       System.out.println("sssssssssscNOLimit====" + cNoLimit);
/*  55 */       System.out.println("===========" + cNoType);
/*  56 */       if ((cNoType.equals("COMMISIONSN")) || 
/*  58 */         (cNoType.equals("GRPNO")) || 
/*  59 */         (cNoType.equals("SUGDATAITEMCODE")) || 
/*  60 */         (cNoType.equals("SUGITEMCODE")) || 
/*  61 */         (cNoType.equals("SUGMODELCODE")) || 
/*  62 */         (cNoType.equals("SUGCODE")) || 
/*  63 */         (cNoType.equals("ACCNO")))
/*     */       {
/*  66 */         serialLen = 10;
/*     */       }
/*  68 */       else if (cNoType.equals("CUSTOMERNO"))
/*     */       {
/*  70 */         serialLen = 8;
/*     */       }
/*     */       else
/*     */       {
/*  75 */         System.out.println("\u9519\u8BEF\u7684NoLimit");
/*     */ 
/*  77 */         return null;
/*     */       }
/*  79 */       System.out.println("---------serialLen----" + serialLen);
/*     */     }
/*     */ 
/*  83 */     if (cNoType.equals("GRPBRANCHGROUP"))
/*     */     {
/*  85 */       serialLen = 2;
/*     */     }
/*  88 */     else if (cNoType.equals("CtrlLevel"))
/*     */     {
/*  90 */       serialLen = 10;
/*     */     }
/*  93 */     else if (cNoType.equals("BCtrl"))
/*     */     {
/*  95 */       serialLen = 10;
/*     */     }
/*  98 */     else if (cNoType.equals("BCtrlLevel"))
/*     */     {
/* 100 */       serialLen = 10;
/*     */     }
/*     */ 
/* 104 */     if (cNoType.equals("AIRPOLNO"))
/*     */     {
/* 106 */       serialLen = 6;
/*     */     }
/*     */ 
/* 109 */     if ((cNoType.equals("ATCODE")) || (cNoType.equals("MANAGECOM")))
/*     */     {
/* 111 */       serialLen = 4;
/*     */     }
/*     */ 
/* 114 */     tReturn = cNoLimit.trim();
/*     */ 
/* 117 */     String tCom = "";
/* 118 */     if (tReturn.length() >= 4)
/*     */     {
/* 120 */       tCom = tReturn.substring(0, 4);
/*     */     }
/*     */ 
/* 127 */     if (cNoType.equals("PROPOSALNO"))
/*     */     {
/* 129 */       tReturn = "26" + tCom;
/*     */     }
/* 133 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 135 */       tReturn = "27" + tCom;
/*     */     }
/* 140 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 142 */       tReturn = "28" + tCom;
/*     */     }
/* 146 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 148 */       tReturn = "28" + tCom;
/*     */     }
/* 152 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 154 */       tReturn = "26" + tCom;
/*     */     }
/* 158 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 160 */       tReturn = "27" + tCom;
/*     */     }
/* 164 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 170 */       tReturn = "20" + tCom;
/*     */     }
/* 174 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 176 */       tReturn = "28" + tCom;
/*     */     }
/* 180 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 182 */       tReturn = "97" + tCom;
/*     */ 
/* 184 */       serialLen = 8;
/*     */     }
/* 188 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 190 */       tReturn = "36" + tCom;
/* 191 */       serialLen = 8;
/*     */     }
/* 195 */     else if (cNoType.equals("TEMPFEENO"))
/*     */     {
/* 197 */       tReturn = "37" + tCom;
/* 198 */       serialLen = 8;
/*     */     }
/* 202 */     else if (cNoType.equals("ORITEMPFEENO"))
/*     */     {
/* 204 */       tReturn = "35" + tCom;
/* 205 */       serialLen = 8;
/*     */     }
/* 210 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 212 */       tReturn = "96" + tCom;
/* 213 */       serialLen = 8;
/*     */     }
/* 217 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 219 */       tReturn = "39" + tCom;
/* 220 */       serialLen = 8;
/*     */     }
/* 224 */     else if (cNoType.equals("CLIENTID"))
/*     */     {
/* 227 */       tReturn = "17" + tCom;
/* 228 */       serialLen = 8;
/*     */     }
/* 231 */     else if (cNoType.equals("SERVICENO"))
/*     */     {
/* 233 */       tReturn = "15" + tCom;
/* 234 */       serialLen = 8;
/*     */     }
/* 238 */     else if (cNoType.equals("EDORACCEPTNO"))
/*     */     {
/* 243 */       tReturn = "46" + tCom;
/*     */     }
/* 246 */     else if (cNoType.equals("TRIALNO"))
/*     */     {
/* 251 */       tReturn = "66" + tCom;
/* 252 */       System.out.println("SysMaxNoTK:TrialNO===========274=========" + tReturn);
/*     */     }
/* 257 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 262 */       tReturn = "42" + tCom;
/*     */     }
/* 267 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 272 */       tReturn = "46" + tCom;
/*     */     }
/* 288 */     else if (cNoType.equals("RPTNO"))
/*     */     {
/* 290 */       tReturn = "58" + tCom;
/*     */     }
/* 294 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 296 */       tReturn = "58" + tCom;
/*     */     }
/* 299 */     else if (cNoType.equals("RPTONLYNO"))
/*     */     {
/* 301 */       tReturn = "58" + tCom;
/*     */     }
/* 306 */     else if (cNoType.equals("CLMNO"))
/*     */     {
/* 308 */       tReturn = "58" + tCom;
/*     */     }
/* 312 */     else if (cNoType.equals("DECLINENO"))
/*     */     {
/* 314 */       tReturn = "57" + tCom;
/*     */     }
/* 318 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 320 */       tReturn = "72" + tCom;
/*     */     }
/* 324 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 326 */       tReturn = "80" + tCom;
/*     */     }
/* 330 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 332 */       tReturn = "81" + tCom;
/*     */     }
/* 336 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 338 */       tReturn = "82" + tCom;
/*     */     }
/* 341 */     else if (cNoType.equals("CONTPRTSEQ"))
/*     */     {
/* 343 */       tReturn = "83" + tCom;
/* 344 */       serialLen = 6;
/*     */     }
/* 349 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 351 */       tReturn = "65" + tCom;
/*     */     }
/* 355 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 357 */       tReturn = "64" + tCom;
/*     */     }
/* 361 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 363 */       tReturn = "68" + tCom;
/*     */     }
/* 367 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 369 */       tReturn = "90" + tCom;
/*     */     }
/* 373 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 375 */       tReturn = "98" + tCom;
/* 376 */       serialLen = 10;
/*     */     }
/*     */ 
/* 386 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 388 */     if (conn == null)
/*     */     {
/* 390 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 392 */       return tReturn;
/*     */     }
/*     */ 
/* 395 */     int tMaxNo = 0;
/* 396 */     if (cNoType.equals("CUSTOMERNO"))
/*     */     {
/* 398 */       cNoLimit = "unique";
/*     */     }
/*     */     else
/*     */     {
/* 402 */       cNoLimit = tReturn;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 412 */       conn.setAutoCommit(false);
/*     */ 
/* 422 */       StringBuffer tSBql = new StringBuffer(256);
/* 423 */       if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */       {
/* 425 */         tSBql.append("select MaxNo from LDMaxNo1 where notype='");
/*     */       }
/* 427 */       else if (cNoType.equals("PROPOSALNO"))
/*     */       {
/* 429 */         tSBql.append("select MaxNo from LDMaxNo2 where notype='");
/*     */       }
/*     */       else
/*     */       {
/* 433 */         tSBql.append("select MaxNo from LDMaxNo where notype='");
/*     */       }
/* 435 */       tSBql.append(cNoType);
/* 436 */       tSBql.append("' and nolimit='");
/* 437 */       tSBql.append(cNoLimit);
/* 438 */       tSBql.append("' for update");
/*     */ 
/* 445 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 446 */       String result = null;
/* 447 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 450 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 452 */         System.out.println("\u67E5\u8BE2LDMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/* 453 */         conn.rollback();
/* 454 */         conn.close();
/*     */ 
/* 456 */         return null;
/*     */       }
/*     */ 
/* 459 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 463 */         tSBql = new StringBuffer(256);
/* 464 */         if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */         {
/* 466 */           tSBql.append("insert into ldmaxno1(notype, nolimit, maxno) values('");
/*     */         }
/* 468 */         else if (cNoType.equals("PROPOSALNO"))
/*     */         {
/* 470 */           tSBql.append("insert into ldmaxno2(notype, nolimit, maxno) values('");
/*     */         }
/*     */         else
/*     */         {
/* 474 */           tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/*     */         }
/* 476 */         tSBql.append(cNoType);
/* 477 */         tSBql.append("', '");
/* 478 */         tSBql.append(cNoLimit);
/* 479 */         tSBql.append("', 1)");
/*     */ 
/* 481 */         exeSQL = new ExeSQL(conn);
/* 482 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 484 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 485 */           conn.rollback();
/* 486 */           conn.close();
/*     */ 
/* 488 */           return null;
/*     */         }
/*     */ 
/* 492 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 499 */         tSBql = new StringBuffer(256);
/* 500 */         if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */         {
/* 502 */           tSBql.append("update ldmaxno1 set maxno = maxno + 1 where notype = '");
/*     */         }
/* 504 */         else if (cNoType.equals("PROPOSALNO"))
/*     */         {
/* 506 */           tSBql.append("update ldmaxno2 set maxno = maxno + 1 where notype = '");
/*     */         }
/*     */         else
/*     */         {
/* 510 */           tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/*     */         }
/* 512 */         tSBql.append(cNoType);
/* 513 */         tSBql.append("' and nolimit = '");
/* 514 */         tSBql.append(cNoLimit);
/* 515 */         tSBql.append("'");
/*     */ 
/* 517 */         exeSQL = new ExeSQL(conn);
/* 518 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 520 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 521 */           conn.rollback();
/* 522 */           conn.close();
/*     */ 
/* 524 */           return null;
/*     */         }
/*     */ 
/* 528 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 532 */       conn.commit();
/* 533 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 539 */         conn.rollback();
/* 540 */         conn.close();
/*     */ 
/* 542 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 546 */         e1.printStackTrace();
/*     */ 
/* 548 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 553 */     String tStr = String.valueOf(tMaxNo);
/* 554 */     System.out.println("-----1----tStr:" + tStr);
/* 555 */     System.out.println("-------seriallent----" + serialLen);
/* 556 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 558 */     System.out.println("-----2----tStr:" + tStr);
/* 559 */     if (tReturn.equals("SN"))
/*     */     {
/* 562 */       tReturn = tStr.trim();
/*     */     }
/*     */     else
/*     */     {
/* 566 */       tReturn = tReturn.trim() + tStr.trim();
/*     */     }
/* 568 */     if (cNoType.equals("CUSTOMERNO"))
/*     */     {
/* 570 */       tReturn = GetAccountId(tReturn);
/* 571 */       System.out.println("----------" + tReturn);
/*     */     }
/*     */ 
/* 574 */     System.out.println("------tReturn:" + tReturn);
/* 575 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String GetAccountId(String tStr)
/*     */   {
/* 580 */     String tMod = "109876532";
/* 581 */     String tStr1 = "";
/* 582 */     String tStr2 = "";
/* 583 */     String tReturn = "";
/* 584 */     tStr1 = PubFun.LCh(tStr, "0", 9);
/* 585 */     double j = 0.0D;
/* 586 */     int k = 0;
/* 587 */     for (int i = 1; i <= 9; i++)
/*     */     {
/* 589 */       j += Integer.parseInt(tStr1.substring(i - 1, i)) * Math.pow(2.0D, i - 1);
/*     */     }
/*     */ 
/* 592 */     k = (int)Math.floor(j) % 9;
/* 593 */     k++;
/* 594 */     tStr2 = tStr1.trim() + tMod.substring(k - 1, k);
/* 595 */     tReturn = tStr2;
/* 596 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 602 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 603 */       (cNoLength <= 0))
/*     */     {
/* 605 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/* 607 */       return null;
/*     */     }
/*     */ 
/* 610 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 613 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/* 615 */     if (conn == null)
/*     */     {
/* 617 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/* 619 */       return null;
/*     */     }
/*     */ 
/* 622 */     String tReturn = "";
/* 623 */     String cNoLimit = "SN";
/*     */ 
/* 625 */     if ((cNoType.equals("COMMISIONSN")) || 
/* 626 */       (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 627 */       (cNoType.equals("SUGDATAITEMCODE")) || 
/* 628 */       (cNoType.equals("SUGITEMCODE")) || 
/* 629 */       (cNoType.equals("SUGMODELCODE")) || 
/* 630 */       (cNoType.equals("SUGCODE")))
/*     */     {
/* 633 */       System.out.println("\u8BE5\u7C7B\u578B\u6D41\u6C34\u53F7\uFF0C\u8BF7\u91C7\u7528CreateMaxNo('" + cNoType + 
/* 634 */         "','SN')\u65B9\u5F0F\u751F\u6210");
/* 635 */       return null;
/*     */     }
/* 637 */     BigInteger tMaxNo = new BigInteger("0");
/* 638 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 643 */       conn.setAutoCommit(false);
/*     */ 
/* 653 */       StringBuffer tSBql = new StringBuffer(256);
/* 654 */       if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */       {
/* 656 */         tSBql.append("select MaxNo from LDMaxNo1 where notype='");
/*     */       }
/* 658 */       else if (cNoType.equals("PROPOSALNO"))
/*     */       {
/* 660 */         tSBql.append("select MaxNo from LDMaxNo2 where notype='");
/*     */       }
/*     */       else
/*     */       {
/* 664 */         tSBql.append("select MaxNo from LDMaxNo where notype='");
/*     */       }
/* 666 */       tSBql.append(cNoType);
/* 667 */       tSBql.append("' and nolimit='");
/* 668 */       tSBql.append(cNoLimit);
/* 669 */       tSBql.append("' for update");
/*     */ 
/* 676 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 677 */       String result = null;
/* 678 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 680 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 682 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 683 */         conn.rollback();
/* 684 */         conn.close();
/*     */ 
/* 686 */         return null;
/*     */       }
/*     */ 
/* 689 */       if (result.equals(""))
/*     */       {
/* 693 */         tSBql = new StringBuffer(256);
/* 694 */         if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */         {
/* 696 */           tSBql.append("insert into ldmaxno1(notype, nolimit, maxno) values('");
/*     */         }
/* 698 */         else if (cNoType.equals("PROPOSALNO"))
/*     */         {
/* 700 */           tSBql.append("insert into ldmaxno2(notype, nolimit, maxno) values('");
/*     */         }
/*     */         else
/*     */         {
/* 704 */           tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/*     */         }
/* 706 */         tSBql.append(cNoType);
/* 707 */         tSBql.append("', '");
/* 708 */         tSBql.append(cNoLimit);
/* 709 */         tSBql.append("', 1)");
/*     */ 
/* 711 */         exeSQL = new ExeSQL(conn);
/* 712 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 714 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 715 */           conn.rollback();
/* 716 */           conn.close();
/*     */ 
/* 718 */           return null;
/*     */         }
/*     */ 
/* 722 */         tMaxNo = new BigInteger("1");
/*     */       }
/*     */       else
/*     */       {
/* 729 */         tSBql = new StringBuffer(256);
/* 730 */         if ((cNoType.equals("CUSTOMERNO")) || (cNoType.equals("CONTNO")))
/*     */         {
/* 732 */           tSBql.append("update ldmaxno1 set maxno = maxno + 1 where notype = '");
/*     */         }
/* 734 */         else if (cNoType.equals("PROPOSALNO"))
/*     */         {
/* 736 */           tSBql.append("update ldmaxno2 set maxno = maxno + 1 where notype = '");
/*     */         }
/*     */         else
/*     */         {
/* 740 */           tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/*     */         }
/* 742 */         tSBql.append(cNoType);
/* 743 */         tSBql.append("' and nolimit = '");
/* 744 */         tSBql.append(cNoLimit);
/* 745 */         tSBql.append("'");
/*     */ 
/* 747 */         exeSQL = new ExeSQL(conn);
/* 748 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 750 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 751 */           conn.rollback();
/* 752 */           conn.close();
/*     */ 
/* 754 */           return null;
/*     */         }
/*     */ 
/* 758 */         tMaxNo = new BigInteger(result).add(new BigInteger("1"));
/*     */       }
/*     */ 
/* 762 */       conn.commit();
/* 763 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 769 */         conn.rollback();
/* 770 */         conn.close();
/*     */ 
/* 772 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 776 */         e1.printStackTrace();
/*     */ 
/* 778 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 782 */     String tStr = tMaxNo.toString();
/* 783 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 784 */     tReturn = tStr.trim();
/*     */ 
/* 786 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 804 */     String newGrpContNo = "";
/* 805 */     String limitNo = PubFun.getNoLimit("SN");
/* 806 */     newGrpContNo = PubFun1.CreateMaxNo("CUSTOMERNO", "SN");
/* 807 */     System.out.println(newGrpContNo);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoTK
 * JD-Core Version:    0.6.0
 */