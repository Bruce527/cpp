/*      */ package com.sinosoft.map.lis.pubfun;
/*      */ 
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.ExeSQL;
/*      */ import com.sinosoft.map.utility.JdbcUrl;
/*      */ import com.sinosoft.map.utility.Reflections;
/*      */ import com.sinosoft.map.utility.SSRS;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.SchemaSet;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.reflect.Method;
/*      */ import java.math.BigDecimal;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URL;
/*      */ import java.security.CodeSource;
/*      */ import java.security.ProtectionDomain;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.Vector;
/*      */ 
/*      */ public class PubFun
/*      */ {
/*   39 */   public static boolean iswait = false;
/*      */ 
/*      */   public static Date calDate(Date baseDate, int interval, String unit, Date compareDate)
/*      */   {
/*   44 */     Date returnDate = null;
/*      */ 
/*   46 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*   47 */     mCalendar.setTime(baseDate);
/*   48 */     if (unit.equals("Y"))
/*      */     {
/*   50 */       mCalendar.add(1, interval);
/*      */     }
/*   52 */     if (unit.equals("M"))
/*      */     {
/*   54 */       mCalendar.add(2, interval);
/*      */     }
/*   56 */     if (unit.equals("D"))
/*      */     {
/*   58 */       mCalendar.add(5, interval);
/*      */     }
/*      */ 
/*   61 */     if (compareDate != null)
/*      */     {
/*   63 */       GregorianCalendar cCalendar = new GregorianCalendar();
/*   64 */       cCalendar.setTime(compareDate);
/*      */ 
/*   66 */       int mYears = mCalendar.get(1);
/*   67 */       int mMonths = mCalendar.get(2);
/*   68 */       int cMonths = cCalendar.get(2);
/*   69 */       int cDays = cCalendar.get(5);
/*      */ 
/*   71 */       if (unit.equals("Y"))
/*      */       {
/*   73 */         cCalendar.set(mYears, cMonths, cDays);
/*   74 */         if (cCalendar.before(mCalendar))
/*      */         {
/*   76 */           mCalendar.set(mYears + 1, cMonths, cDays);
/*   77 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else
/*      */         {
/*   81 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*   84 */       if (unit.equals("M"))
/*      */       {
/*   86 */         cCalendar.set(mYears, mMonths, cDays);
/*   87 */         if (cCalendar.before(mCalendar))
/*      */         {
/*   89 */           mCalendar.set(mYears, mMonths + 1, cDays);
/*   90 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else
/*      */         {
/*   94 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*   97 */       if (unit.equals("D"))
/*      */       {
/*   99 */         returnDate = mCalendar.getTime();
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  104 */       returnDate = mCalendar.getTime();
/*      */     }
/*      */ 
/*  107 */     return returnDate;
/*      */   }
/*      */ 
/*      */   public static String calDate(String baseDate, int interval, String unit, String compareDate)
/*      */   {
/*      */     try
/*      */     {
/*  116 */       FDate tFDate = new FDate();
/*  117 */       Date bDate = tFDate.getDate(baseDate);
/*  118 */       Date cDate = tFDate.getDate(compareDate);
/*  119 */       return tFDate.getString(calDate(bDate, interval, unit, cDate));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  123 */       ex.printStackTrace();
/*  124 */     }return null;
/*      */   }
/*      */ 
/*      */   public static int calInterval(Date startDate, Date endDate, String unit)
/*      */   {
/*  131 */     int interval = 0;
/*      */ 
/*  133 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  134 */     sCalendar.setTime(startDate);
/*  135 */     int sYears = sCalendar.get(1);
/*  136 */     int sMonths = sCalendar.get(2);
/*  137 */     int sDays = sCalendar.get(5);
/*  138 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  140 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  141 */     eCalendar.setTime(endDate);
/*  142 */     int eYears = eCalendar.get(1);
/*  143 */     int eMonths = eCalendar.get(2);
/*  144 */     int eDays = eCalendar.get(5);
/*  145 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  147 */     if (unit.equals("Y"))
/*      */     {
/*  149 */       interval = eYears - sYears;
/*  150 */       if (eMonths < sMonths)
/*      */       {
/*  152 */         interval--;
/*      */       }
/*  156 */       else if ((eMonths == sMonths) && (eDays < sDays))
/*      */       {
/*  158 */         interval--;
/*  159 */         if (eMonths == 1)
/*      */         {
/*  161 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  163 */             if (eDays == 28)
/*      */             {
/*  165 */               interval++;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  172 */     if (unit.equals("M"))
/*      */     {
/*  174 */       interval = eYears - sYears;
/*      */ 
/*  176 */       interval *= 12;
/*      */ 
/*  179 */       interval += eMonths - sMonths;
/*  180 */       if (eDays < sDays)
/*      */       {
/*  182 */         interval--;
/*      */ 
/*  184 */         int maxDate = eCalendar.getActualMaximum(5);
/*  185 */         if (eDays == maxDate)
/*      */         {
/*  187 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  191 */     if (unit.equals("D"))
/*      */     {
/*  193 */       interval = eYears - sYears;
/*      */ 
/*  195 */       interval *= 365;
/*      */ 
/*  197 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  200 */       int n = 0;
/*  201 */       eYears--;
/*      */ 
/*  203 */       if (eYears > sYears)
/*      */       {
/*  205 */         int i = sYears % 4;
/*  206 */         if (i == 0)
/*      */         {
/*  208 */           n++;
/*      */         }
/*      */       }
/*  211 */       int eYears1 = eYears;
/*  212 */       while (eYears1 > sYears)
/*      */       {
/*  214 */         int j = eYears1 % 4;
/*  215 */         if (j == 0)
/*      */         {
/*  217 */           n++;
/*      */         }
/*  219 */         eYears1--;
/*      */       }
/*  221 */       if (eYears == sYears)
/*      */       {
/*  223 */         int i = sYears % 4;
/*  224 */         if (i == 0)
/*      */         {
/*  226 */           n++;
/*      */         }
/*      */       }
/*  229 */       interval += n;
/*      */     }
/*  231 */     return interval;
/*      */   }
/*      */ 
/*      */   public static String formatSql(String sIn)
/*      */   {
/*  237 */     int n = sIn.length();
/*  238 */     int j = 0;
/*  239 */     String Str1 = null;
/*  240 */     String Str2 = null;
/*  241 */     String sOut = null;
/*  242 */     int i = 0;
/*      */ 
/*  245 */     while (i < n)
/*      */     {
/*  247 */       j = sIn.indexOf("%25", i);
/*  248 */       if (j == -1)
/*      */         break;
/*  250 */       Str1 = sIn.substring(0, j + 1);
/*  251 */       Str2 = sIn.substring(j + 3);
/*  252 */       sIn = String.valueOf(Str1) + String.valueOf(Str2);
/*  253 */       i = j;
/*      */     }
/*  255 */     sOut = sIn;
/*  256 */     System.out.println(sOut);
/*  257 */     return sOut;
/*      */   }
/*      */ 
/*      */   public static int calInterval(String cstartDate, String cendDate, String unit)
/*      */   {
/*  263 */     FDate fDate = new FDate();
/*  264 */     Date startDate = fDate.getDate(cstartDate);
/*  265 */     Date endDate = fDate.getDate(cendDate);
/*  266 */     if (fDate.mErrors.needDealError())
/*      */     {
/*  268 */       return 0;
/*      */     }
/*      */ 
/*  271 */     int interval = 0;
/*      */ 
/*  273 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  274 */     sCalendar.setTime(startDate);
/*  275 */     int sYears = sCalendar.get(1);
/*  276 */     int sMonths = sCalendar.get(2);
/*  277 */     int sDays = sCalendar.get(5);
/*  278 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  280 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  281 */     eCalendar.setTime(endDate);
/*  282 */     int eYears = eCalendar.get(1);
/*  283 */     int eMonths = eCalendar.get(2);
/*  284 */     int eDays = eCalendar.get(5);
/*  285 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  287 */     if (StrTool.cTrim(unit).equals("Y"))
/*      */     {
/*  289 */       interval = eYears - sYears;
/*      */ 
/*  291 */       if (eMonths < sMonths)
/*      */       {
/*  293 */         interval--;
/*      */       }
/*  297 */       else if ((eMonths == sMonths) && (eDays < sDays))
/*      */       {
/*  299 */         interval--;
/*  300 */         if (eMonths == 1)
/*      */         {
/*  302 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  304 */             if (eDays == 28)
/*      */             {
/*  306 */               interval++;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  313 */     if (StrTool.cTrim(unit).equals("M"))
/*      */     {
/*  315 */       interval = eYears - sYears;
/*      */ 
/*  317 */       interval *= 12;
/*      */ 
/*  319 */       interval += eMonths - sMonths;
/*      */ 
/*  321 */       if (eDays < sDays)
/*      */       {
/*  323 */         interval--;
/*      */ 
/*  325 */         int maxDate = eCalendar.getActualMaximum(5);
/*  326 */         if (eDays == maxDate)
/*      */         {
/*  328 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  332 */     if (StrTool.cTrim(unit).equals("D"))
/*      */     {
/*  334 */       interval = eYears - sYears;
/*      */ 
/*  336 */       interval *= 365;
/*      */ 
/*  338 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  341 */       int n = 0;
/*  342 */       eYears--;
/*      */ 
/*  346 */       if (eYears > sYears)
/*      */       {
/*  348 */         int i = sYears % 4;
/*  349 */         if (i == 0)
/*      */         {
/*  351 */           n++;
/*      */         }
/*      */       }
/*  354 */       int eYears1 = eYears;
/*  355 */       while (eYears1 > sYears)
/*      */       {
/*  357 */         int j = eYears1 % 4;
/*  358 */         if (j == 0)
/*      */         {
/*  360 */           n++;
/*      */         }
/*  362 */         eYears1--;
/*      */       }
/*  364 */       if (eYears == sYears)
/*      */       {
/*  366 */         int i = sYears % 4;
/*  367 */         if (i == 0)
/*      */         {
/*  369 */           n++;
/*      */         }
/*      */       }
/*  372 */       interval += n;
/*      */     }
/*  374 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval2(String cstartDate, String cendDate, String unit)
/*      */   {
/*  381 */     FDate fDate = new FDate();
/*  382 */     Date startDate = fDate.getDate(cstartDate);
/*  383 */     Date endDate = fDate.getDate(cendDate);
/*  384 */     if (fDate.mErrors.needDealError())
/*      */     {
/*  386 */       return 0;
/*      */     }
/*      */ 
/*  389 */     int interval = 0;
/*      */ 
/*  391 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  392 */     sCalendar.setTime(startDate);
/*  393 */     int sYears = sCalendar.get(1);
/*  394 */     int sMonths = sCalendar.get(2);
/*  395 */     int sDays = sCalendar.get(5);
/*  396 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  398 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  399 */     eCalendar.setTime(endDate);
/*  400 */     int eYears = eCalendar.get(1);
/*  401 */     int eMonths = eCalendar.get(2);
/*  402 */     int eDays = eCalendar.get(5);
/*  403 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  405 */     if (StrTool.cTrim(unit).equals("Y"))
/*      */     {
/*  407 */       interval = eYears - sYears;
/*      */ 
/*  409 */       if (eMonths > sMonths)
/*      */       {
/*  411 */         interval++;
/*      */       }
/*  415 */       else if ((eMonths == sMonths) && (eDays > sDays))
/*      */       {
/*  417 */         interval++;
/*  418 */         if (eMonths == 1)
/*      */         {
/*  420 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  422 */             if (eDays == 28)
/*      */             {
/*  424 */               interval--;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  431 */     if (StrTool.cTrim(unit).equals("M"))
/*      */     {
/*  433 */       interval = eYears - sYears;
/*      */ 
/*  435 */       interval *= 12;
/*      */ 
/*  437 */       interval += eMonths - sMonths;
/*      */ 
/*  439 */       if (eDays > sDays)
/*      */       {
/*  441 */         interval++;
/*      */ 
/*  443 */         int maxDate = eCalendar.getActualMaximum(5);
/*  444 */         if (eDays == maxDate)
/*      */         {
/*  446 */           interval--;
/*      */         }
/*      */       }
/*      */     }
/*  450 */     if (StrTool.cTrim(unit).equals("D"))
/*      */     {
/*  452 */       interval = eYears - sYears;
/*      */ 
/*  454 */       interval *= 365;
/*      */ 
/*  456 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  459 */       int n = 0;
/*  460 */       eYears--;
/*      */ 
/*  464 */       if (eYears > sYears)
/*      */       {
/*  466 */         int i = sYears % 4;
/*  467 */         if (i == 0)
/*      */         {
/*  469 */           n++;
/*      */         }
/*      */       }
/*  472 */       int eYears1 = eYears;
/*  473 */       while (eYears1 > sYears)
/*      */       {
/*  475 */         int j = eYears1 % 4;
/*  476 */         if (j == 0)
/*      */         {
/*  478 */           n++;
/*      */         }
/*  480 */         eYears1--;
/*      */       }
/*  482 */       if (eYears == sYears)
/*      */       {
/*  484 */         int i = sYears % 4;
/*  485 */         if (i == 0)
/*      */         {
/*  487 */           n++;
/*      */         }
/*      */       }
/*  490 */       interval += n;
/*      */     }
/*  492 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval3(String cstartDate, String cendDate, String unit)
/*      */   {
/*  499 */     FDate fDate = new FDate();
/*  500 */     Date startDate = fDate.getDate(cstartDate);
/*  501 */     Date endDate = fDate.getDate(cendDate);
/*  502 */     if (fDate.mErrors.needDealError())
/*      */     {
/*  504 */       return 0;
/*      */     }
/*      */ 
/*  507 */     int interval = 0;
/*      */ 
/*  509 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  510 */     sCalendar.setTime(startDate);
/*  511 */     int sYears = sCalendar.get(1);
/*  512 */     int sMonths = sCalendar.get(2);
/*  513 */     int sDays = sCalendar.get(5);
/*  514 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  516 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  517 */     eCalendar.setTime(endDate);
/*  518 */     int eYears = eCalendar.get(1);
/*  519 */     int eMonths = eCalendar.get(2);
/*  520 */     int eDays = eCalendar.get(5);
/*  521 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  523 */     if (StrTool.cTrim(unit).equals("Y"))
/*      */     {
/*  525 */       interval = eYears - sYears;
/*      */ 
/*  527 */       if (eMonths > sMonths)
/*      */       {
/*  529 */         interval++;
/*      */       }
/*  533 */       else if ((eMonths == sMonths) && (eDays > sDays))
/*      */       {
/*  535 */         interval++;
/*  536 */         if (eMonths == 1)
/*      */         {
/*  538 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  540 */             if (eDays == 28)
/*      */             {
/*  542 */               interval--;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  549 */     if (StrTool.cTrim(unit).equals("M"))
/*      */     {
/*  551 */       interval = eYears - sYears;
/*      */ 
/*  553 */       interval *= 12;
/*      */ 
/*  555 */       interval += eMonths - sMonths;
/*      */ 
/*  557 */       if (eDays > sDays)
/*      */       {
/*  559 */         interval++;
/*      */ 
/*  561 */         int maxsDate = sCalendar.getActualMaximum(5);
/*  562 */         int maxeDate = eCalendar.getActualMaximum(5);
/*  563 */         if ((sDays == maxsDate) && (eDays == maxeDate))
/*      */         {
/*  565 */           interval--;
/*      */         }
/*      */       }
/*      */     }
/*  569 */     if (StrTool.cTrim(unit).equals("D"))
/*      */     {
/*  571 */       interval = eYears - sYears;
/*      */ 
/*  573 */       interval *= 365;
/*      */ 
/*  575 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  578 */       int n = 0;
/*  579 */       eYears--;
/*      */ 
/*  582 */       if (eYears > sYears)
/*      */       {
/*  584 */         int i = sYears % 4;
/*  585 */         if (i == 0)
/*      */         {
/*  587 */           n++;
/*      */         }
/*      */       }
/*  590 */       int eYears1 = eYears;
/*  591 */       while (eYears1 > sYears)
/*      */       {
/*  593 */         int j = eYears1 % 4;
/*  594 */         if (j == 0)
/*      */         {
/*  596 */           n++;
/*      */         }
/*  598 */         eYears1--;
/*      */       }
/*  600 */       if (eYears == sYears)
/*      */       {
/*  602 */         int i = sYears % 4;
/*  603 */         if (i == 0)
/*      */         {
/*  605 */           n++;
/*      */         }
/*      */       }
/*  608 */       interval += n;
/*      */     }
/*  610 */     return interval;
/*      */   }
/*      */ 
/*      */   public static String[] calFLDate(String tDate)
/*      */   {
/*  617 */     String[] MonDate = new String[2];
/*  618 */     FDate fDate = new FDate();
/*  619 */     Date CurDate = fDate.getDate(tDate);
/*  620 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*  621 */     mCalendar.setTime(CurDate);
/*  622 */     int Years = mCalendar.get(1);
/*  623 */     int Months = mCalendar.get(2);
/*  624 */     int FirstDay = mCalendar.getActualMinimum(5);
/*  625 */     int LastDay = mCalendar.getActualMaximum(5);
/*  626 */     mCalendar.set(Years, Months, FirstDay);
/*  627 */     MonDate[0] = fDate.getString(mCalendar.getTime());
/*  628 */     mCalendar.set(Years, Months, LastDay);
/*  629 */     MonDate[1] = fDate.getString(mCalendar.getTime());
/*  630 */     return MonDate;
/*      */   }
/*      */ 
/*      */   public static JdbcUrl getDefaultUrl()
/*      */   {
/*  636 */     JdbcUrl tUrl = new JdbcUrl();
/*  637 */     return tUrl;
/*      */   }
/*      */ 
/*      */   public static String SecurNum(String tStr)
/*      */   {
/*  645 */     String tmp = "";
/*  646 */     String s1 = "";
/*  647 */     for (int i = 0; i < tStr.length(); i++)
/*      */     {
/*  649 */       s1 = tStr.substring(i, i + 1);
/*  650 */       if ((s1.equals("0")) || (s1.equals("1")) || (s1.equals("2")) || 
/*  651 */         (s1.equals("3")) || (s1.equals("4")) || (s1.equals("5")) || 
/*  652 */         (s1.equals("6")) || (s1.equals("7")) || (s1.equals("8")) || 
/*  653 */         (s1.equals("9")))
/*      */       {
/*  655 */         tmp = tmp + s1;
/*      */       }
/*      */       else
/*      */       {
/*  659 */         tmp = tmp + "0";
/*      */       }
/*      */     }
/*  662 */     int t = Integer.parseInt(tmp);
/*  663 */     int iResult = (t % 1000000 * 17 + 1) % 1000000 * 41 % 1000000;
/*  664 */     String sResult = Integer.toString(iResult);
/*  665 */     sResult = LCh(sResult, "0", 6);
/*  666 */     return sResult;
/*      */   }
/*      */ 
/*      */   public static String TransID(String tStrID)
/*      */   {
/*  674 */     String tStrIDtmp = "";
/*  675 */     String tStrIDnew = "";
/*  676 */     String tChkLetter = "10X98765432";
/*  677 */     int r1 = 0;
/*  678 */     int w1 = 1;
/*  679 */     tStrIDtmp = tStrID.substring(0, 6) + "19" + tStrID.substring(6, 15);
/*  680 */     for (int i = 17; i >= 1; i--)
/*      */     {
/*  682 */       int a = Integer.parseInt(tStrIDtmp.substring(i - 1, i));
/*  683 */       w1 *= 2;
/*  684 */       int w = w1 % 11;
/*  685 */       r1 += w * a;
/*      */     }
/*  687 */     int j = r1 % 11;
/*  688 */     if ((j >= 0) && (j <= 10))
/*      */     {
/*  690 */       j++;
/*  691 */       tStrIDnew = tStrIDtmp + tChkLetter.substring(j - 1, j);
/*      */     }
/*      */     else
/*      */     {
/*  695 */       tStrIDnew = tStrIDtmp + "E";
/*      */     }
/*  697 */     return tStrIDnew;
/*      */   }
/*      */ 
/*      */   public static String TrimSpace(String tStr)
/*      */   {
/*  705 */     String tStrnew = "";
/*  706 */     String tStr1 = "";
/*  707 */     int j = 0;
/*  708 */     tStr = tStr.trim();
/*  709 */     j = tStr.length();
/*  710 */     for (int i = 0; i < j; i++)
/*      */     {
/*  712 */       tStr1 = tStr.substring(i, i + 1);
/*  713 */       if (tStr1.equals(" "))
/*      */         continue;
/*  715 */       tStrnew = tStrnew + tStr1;
/*      */     }
/*      */ 
/*  718 */     return tStrnew;
/*      */   }
/*      */ 
/*      */   public static int getASCII(char tchar)
/*      */   {
/*  724 */     int k = 0;
/*  725 */     for (int i = -128; i <= 256; i++)
/*      */     {
/*  727 */       char tchar1 = (char)i;
/*  728 */       if (tchar1 != tchar)
/*      */         continue;
/*  730 */       k = i;
/*  731 */       break;
/*      */     }
/*      */ 
/*  734 */     return k;
/*      */   }
/*      */ 
/*      */   public static String filterCH(String tStr)
/*      */   {
/*  741 */     String tStr1 = "";
/*  742 */     String tStrtmp = "";
/*  743 */     int j = 0;
/*  744 */     int k = 1;
/*  745 */     int tSwitch = 0;
/*  746 */     for (int i = 1; i <= tStr.length(); i++)
/*      */     {
/*  748 */       j = getASCII(tStr.charAt(i - 1));
/*  749 */       System.out.println(j);
/*  750 */       if (j < 0)
/*      */       {
/*  752 */         if (tSwitch == 1)
/*      */         {
/*  754 */           tSwitch = 0;
/*  755 */           tStr1 = tStr1 + tStr.substring(i - 2, i);
/*      */         }
/*      */         else
/*      */         {
/*  759 */           tSwitch = 1;
/*      */         }
/*      */ 
/*      */       }
/*  764 */       else if (tSwitch == 1)
/*      */       {
/*  766 */         tSwitch = 0;
/*  767 */         tStr1 = tStr1 + tStr.substring(i - 1, i);
/*      */       }
/*      */       else
/*      */       {
/*  771 */         tStr1 = tStr1 + tStr.substring(i - 1, i);
/*      */       }
/*      */     }
/*      */ 
/*  775 */     return tStr1;
/*      */   }
/*      */ 
/*      */   public static String RCh(String sourString, String cChar, int cLen)
/*      */   {
/*  782 */     int tLen = sourString.length();
/*      */ 
/*  784 */     String tReturn = "";
/*  785 */     if (tLen >= cLen)
/*      */     {
/*  787 */       return sourString;
/*      */     }
/*  789 */     int iMax = cLen - tLen;
/*  790 */     for (int i = 0; i < iMax; i++)
/*      */     {
/*  792 */       tReturn = tReturn + cChar;
/*      */     }
/*  794 */     tReturn = sourString.trim() + tReturn.trim();
/*  795 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String LCh(String sourString, String cChar, int cLen)
/*      */   {
/*  803 */     int tLen = sourString.length();
/*      */ 
/*  805 */     String tReturn = "";
/*  806 */     if (tLen >= cLen)
/*      */     {
/*  808 */       return sourString;
/*      */     }
/*  810 */     int iMax = cLen - tLen;
/*  811 */     for (int i = 0; i < iMax; i++)
/*      */     {
/*  813 */       tReturn = tReturn + cChar;
/*      */     }
/*  815 */     tReturn = tReturn.trim() + sourString.trim();
/*  816 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String getLaterDate(String date1, String date2)
/*      */   {
/*      */     try
/*      */     {
/*  824 */       date1 = StrTool.cTrim(date1);
/*  825 */       date2 = StrTool.cTrim(date2);
/*  826 */       if (date1.equals(""))
/*      */       {
/*  828 */         return date2;
/*      */       }
/*  830 */       if (date2.equals(""))
/*      */       {
/*  832 */         return date1;
/*      */       }
/*  834 */       FDate fd = new FDate();
/*  835 */       Date d1 = fd.getDate(date1);
/*  836 */       Date d2 = fd.getDate(date2);
/*  837 */       if (d1.after(d2))
/*      */       {
/*  839 */         return date1;
/*      */       }
/*  841 */       return date2;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  845 */       e.printStackTrace();
/*  846 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getBeforeDate(String date1, String date2)
/*      */   {
/*      */     try
/*      */     {
/*  856 */       date1 = StrTool.cTrim(date1);
/*  857 */       date2 = StrTool.cTrim(date2);
/*  858 */       if (date1.equals(""))
/*      */       {
/*  860 */         return date2;
/*      */       }
/*  862 */       if (date2.equals(""))
/*      */       {
/*  864 */         return date1;
/*      */       }
/*  866 */       FDate fd = new FDate();
/*  867 */       Date d1 = fd.getDate(date1);
/*  868 */       Date d2 = fd.getDate(date2);
/*  869 */       if (d1.before(d2))
/*      */       {
/*  871 */         return date1;
/*      */       }
/*  873 */       return date2;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  877 */       e.printStackTrace();
/*  878 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getCurrentDate()
/*      */   {
/*  886 */     String pattern = "yyyy-MM-dd";
/*  887 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*  888 */     Date today = new Date();
/*      */ 
/*  890 */     String tString = "";
/*  891 */     tString = df.format(today);
/*      */ 
/*  893 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String claimApplyDate(String clmDate)
/*      */   {
/*  898 */     String pattern = "yyyy\u5E74MM\u6708dd\u65E5";
/*  899 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*      */ 
/*  901 */     FDate tFDate = new FDate();
/*  902 */     Date tDate = tFDate.getDate(clmDate);
/*  903 */     String tString = df.format(tDate);
/*  904 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String claimConfirmDate(String clmConDate)
/*      */   {
/*  909 */     String pattern = "yyyy\u5E74MM\u6708dd\u65E5";
/*  910 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*      */ 
/*  912 */     FDate tFDate = new FDate();
/*  913 */     Date tDate = tFDate.getDate(clmConDate);
/*  914 */     String tString = df.format(tDate);
/*  915 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getCurrentTime()
/*      */   {
/*  921 */     String pattern = "HH:mm:ss";
/*  922 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*  923 */     Date today = new Date();
/*  924 */     String tString = df.format(today);
/*  925 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getNoLimit(String comCode)
/*      */   {
/*  931 */     comCode = comCode.trim();
/*  932 */     int tLen = comCode.length();
/*  933 */     if (tLen > 6)
/*      */     {
/*  935 */       comCode = comCode.substring(0, 6);
/*      */     }
/*  937 */     if (tLen < 6)
/*      */     {
/*  939 */       comCode = RCh(comCode, "0", 6);
/*      */     }
/*  941 */     String tString = "";
/*  942 */     tString = comCode + getCurrentDate().substring(0, 4);
/*  943 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getPiccNoLimit(String comCode)
/*      */   {
/*  949 */     comCode = comCode.trim();
/*  950 */     System.out.println("comCode :" + comCode);
/*  951 */     int tLen = comCode.length();
/*  952 */     if (tLen == 8)
/*      */     {
/*  954 */       comCode = comCode.substring(2, 6);
/*      */     }
/*  956 */     if (tLen == 4)
/*      */     {
/*  958 */       comCode = comCode.substring(2, 4) + "00";
/*      */     }
/*  960 */     System.out.println("SubComCode :" + comCode);
/*  961 */     String tString = "";
/*  962 */     tString = comCode + getCurrentDate().substring(2, 4) + 
/*  963 */       getCurrentDate().substring(5, 7) + 
/*  964 */       getCurrentDate().substring(8, 10);
/*  965 */     System.out.println("PubFun getPiccNoLimit : " + tString);
/*  966 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getTenLengNo(String tNo)
/*      */   {
/*  971 */     String tRetrunValue = "";
/*  972 */     int tLength = tNo.length();
/*  973 */     if (tLength < 12)
/*      */     {
/*  975 */       int t = 12 - tLength;
/*  976 */       String tempAdd = "";
/*  977 */       for (int i = 1; i <= t; i++)
/*      */       {
/*  979 */         tempAdd = tempAdd + "0";
/*      */       }
/*  981 */       tRetrunValue = tempAdd + tNo;
/*      */     }
/*  983 */     return tRetrunValue;
/*      */   }
/*      */ 
/*      */   public static String getStr(String c_Str, int c_i, String c_Split)
/*      */   {
/*  989 */     String t_Str1 = ""; String t_Str2 = ""; String t_strOld = "";
/*  990 */     int i = 0; int i_Start = 0;
/*      */ 
/*  992 */     t_Str1 = c_Str;
/*  993 */     t_Str2 = c_Split;
/*  994 */     i = 0;
/*      */     try
/*      */     {
/*  997 */       while (i < c_i)
/*      */       {
/*  999 */         i_Start = t_Str1.indexOf(t_Str2, 0);
/* 1000 */         if (i_Start >= 0)
/*      */         {
/* 1002 */           i++;
/* 1003 */           t_strOld = t_Str1;
/* 1004 */           t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), 
/* 1005 */             t_Str1.length());
/*      */         }
/*      */         else
/*      */         {
/* 1009 */           if (i == c_i - 1)
/*      */             break;
/* 1011 */           t_Str1 = "";
/*      */ 
/* 1013 */           break;
/*      */         }
/*      */       }
/*      */ 
/* 1017 */       if (i_Start >= 0)
/*      */       {
/* 1019 */         t_Str1 = t_strOld.substring(0, i_Start);
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1024 */       t_Str1 = "";
/*      */     }
/* 1026 */     return t_Str1;
/*      */   }
/*      */ 
/*      */   public static String getChnMoney(double money)
/*      */   {
/* 1032 */     String ChnMoney = "";
/* 1033 */     String s0 = "";
/*      */ 
/* 1037 */     if (money == 0.0D)
/*      */     {
/* 1039 */       ChnMoney = "\u96F6\u5143\u6574";
/* 1040 */       return ChnMoney;
/*      */     }
/*      */ 
/* 1043 */     if (money < 0.0D)
/*      */     {
/* 1045 */       s0 = "\u8D1F";
/* 1046 */       money *= -1.0D;
/*      */     }
/*      */ 
/* 1049 */     String sMoney = new DecimalFormat("0").format(money * 100.0D);
/*      */ 
/* 1051 */     int nLen = sMoney.length();
/*      */     String sDot;
/*      */     String sInteger;
/*      */     String sDot;
/* 1054 */     if (nLen < 2)
/*      */     {
/* 1057 */       String sInteger = "";
/*      */       String sDot;
/* 1058 */       if (nLen == 1)
/*      */       {
/* 1060 */         sDot = "0" + sMoney.substring(nLen - 1, nLen);
/*      */       }
/*      */       else
/*      */       {
/* 1064 */         sDot = "0";
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1069 */       sInteger = sMoney.substring(0, nLen - 2);
/* 1070 */       sDot = sMoney.substring(nLen - 2, nLen);
/*      */     }
/*      */ 
/* 1073 */     String sFormatStr = formatStr(sInteger);
/*      */ 
/* 1075 */     String s1 = getChnM(sFormatStr.substring(0, 4), "\u4EBF");
/*      */ 
/* 1077 */     String s2 = getChnM(sFormatStr.substring(4, 8), "\u4E07");
/*      */ 
/* 1079 */     String s3 = getChnM(sFormatStr.substring(8, 12), "");
/*      */ 
/* 1081 */     String s4 = getDotM(sDot);
/*      */ 
/* 1083 */     if ((s1.length() > 0) && (s1.substring(0, 1).equals("0")))
/*      */     {
/* 1085 */       s1 = s1.substring(1, 
/* 1086 */         s1.length());
/*      */     }
/* 1088 */     if ((s1.length() > 0) && 
/* 1089 */       (s1.substring(s1.length() - 1, s1.length()).equals("0")) && 
/* 1090 */       (s2.length() > 0) && (s2.substring(0, 1).equals("0")))
/*      */     {
/* 1092 */       s1 = s1.substring(0, s1.length() - 1);
/*      */     }
/* 1094 */     if ((s2.length() > 0) && 
/* 1095 */       (s2.substring(s2.length() - 1, s2.length()).equals("0")) && 
/* 1096 */       (s3.length() > 0) && (s3.substring(0, 1).equals("0")))
/*      */     {
/* 1098 */       s2 = s2.substring(0, s2.length() - 1);
/*      */     }
/* 1100 */     if (s4.equals("00"))
/*      */     {
/* 1102 */       s4 = "";
/* 1103 */       if ((s3.length() > 0) && 
/* 1104 */         (s3.substring(s3.length() - 1, s3.length()).equals("0")))
/*      */       {
/* 1106 */         s3 = s3.substring(0, s3.length() - 1);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1113 */     if ((s3.length() > 0) && 
/* 1114 */       (s3.substring(s3.length() - 1, s3.length()).equals("0")) && 
/* 1115 */       (s4.length() > 0))
/*      */     {
/* 1117 */       s3 = s3.substring(0, s3.length() - 1);
/*      */     }
/*      */ 
/* 1120 */     if ((s4.length() > 0) && 
/* 1121 */       (s4.substring(s4.length() - 1, s4.length()).equals("0")))
/*      */     {
/* 1123 */       s4 = s4.substring(0, s4.length() - 1);
/*      */     }
/* 1125 */     if (s3.equals("0"))
/*      */     {
/* 1127 */       s3 = "";
/* 1128 */       s4 = "0" + s4;
/*      */     }
/*      */ 
/* 1131 */     String tmpMoney = s0 + s1 + s2 + s3;
/* 1132 */     if ("".equals(tmpMoney.trim()))
/*      */     {
/* 1134 */       ChnMoney = s4;
/*      */     }
/*      */     else
/*      */     {
/* 1138 */       ChnMoney = s0 + s1 + s2 + s3 + "\u5143" + s4;
/*      */     }
/*      */ 
/* 1141 */     if (ChnMoney.substring(0, 1).equals("0"))
/*      */     {
/* 1143 */       ChnMoney = ChnMoney.substring(1, 
/* 1144 */         ChnMoney.length());
/*      */     }
/* 1146 */     for (int i = 0; i < ChnMoney.length(); i++)
/*      */     {
/* 1148 */       if (!ChnMoney.substring(i, i + 1).equals("0"))
/*      */         continue;
/* 1150 */       ChnMoney = ChnMoney.substring(0, i) + "\u96F6" + 
/* 1151 */         ChnMoney.substring(i + 1, ChnMoney.length());
/*      */     }
/*      */ 
/* 1155 */     if ((sDot.substring(1, 2).equals("0")) && (sDot.substring(0, 1).equals("0")))
/*      */     {
/* 1157 */       ChnMoney = ChnMoney + "\u6574";
/*      */     }
/*      */ 
/* 1160 */     return ChnMoney;
/*      */   }
/*      */ 
/*      */   private static String getDotM(String sIn)
/*      */   {
/* 1166 */     String sMoney = "";
/* 1167 */     if (!sIn.substring(0, 1).equals("0"))
/*      */     {
/* 1169 */       sMoney = sMoney + getNum(sIn.substring(0, 1)) + "\u89D2";
/*      */     }
/*      */     else
/*      */     {
/* 1173 */       sMoney = sMoney + "0";
/*      */     }
/* 1175 */     if (!sIn.substring(1, 2).equals("0"))
/*      */     {
/* 1177 */       sMoney = sMoney + getNum(sIn.substring(1, 2)) + "\u5206";
/*      */     }
/*      */     else
/*      */     {
/* 1181 */       sMoney = sMoney + "0";
/*      */     }
/*      */ 
/* 1184 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String getChnM(String strUnit, String digit)
/*      */   {
/* 1190 */     String sMoney = "";
/* 1191 */     boolean flag = false;
/*      */ 
/* 1193 */     if (strUnit.equals("0000"))
/*      */     {
/* 1195 */       sMoney = sMoney + "0";
/* 1196 */       return sMoney;
/*      */     }
/* 1198 */     if (!strUnit.substring(0, 1).equals("0"))
/*      */     {
/* 1200 */       sMoney = sMoney + getNum(strUnit.substring(0, 1)) + "\u4EDF";
/*      */     }
/*      */     else
/*      */     {
/* 1204 */       sMoney = sMoney + "0";
/* 1205 */       flag = true;
/*      */     }
/* 1207 */     if (!strUnit.substring(1, 2).equals("0"))
/*      */     {
/* 1209 */       sMoney = sMoney + getNum(strUnit.substring(1, 2)) + "\u4F70";
/* 1210 */       flag = false;
/*      */     }
/* 1214 */     else if (!flag)
/*      */     {
/* 1216 */       sMoney = sMoney + "0";
/* 1217 */       flag = true;
/*      */     }
/*      */ 
/* 1220 */     if (!strUnit.substring(2, 3).equals("0"))
/*      */     {
/* 1222 */       sMoney = sMoney + getNum(strUnit.substring(2, 3)) + "\u62FE";
/* 1223 */       flag = false;
/*      */     }
/* 1227 */     else if (!flag)
/*      */     {
/* 1229 */       sMoney = sMoney + "0";
/* 1230 */       flag = true;
/*      */     }
/*      */ 
/* 1233 */     if (!strUnit.substring(3, 4).equals("0"))
/*      */     {
/* 1235 */       sMoney = sMoney + getNum(strUnit.substring(3, 4));
/*      */     }
/* 1239 */     else if (!flag)
/*      */     {
/* 1241 */       sMoney = sMoney + "0";
/* 1242 */       flag = true;
/*      */     }
/*      */ 
/* 1246 */     if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0"))
/*      */     {
/* 1248 */       sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim() + 
/* 1249 */         "0";
/*      */     }
/*      */     else
/*      */     {
/* 1253 */       sMoney = sMoney + digit.trim();
/*      */     }
/* 1255 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String formatStr(String sIn)
/*      */   {
/* 1261 */     int n = sIn.length();
/* 1262 */     String sOut = sIn;
/*      */ 
/* 1265 */     for (int k = 1; k <= 12 - n; k++)
/*      */     {
/* 1267 */       sOut = "0" + sOut;
/*      */     }
/* 1269 */     return sOut;
/*      */   }
/*      */ 
/*      */   private static String getNum(String value)
/*      */   {
/* 1275 */     String sNum = "";
/* 1276 */     Integer I = new Integer(value);
/* 1277 */     int iValue = I.intValue();
/* 1278 */     switch (iValue)
/*      */     {
/*      */     case 0:
/* 1281 */       sNum = "\u96F6";
/* 1282 */       break;
/*      */     case 1:
/* 1284 */       sNum = "\u58F9";
/* 1285 */       break;
/*      */     case 2:
/* 1287 */       sNum = "\u8D30";
/* 1288 */       break;
/*      */     case 3:
/* 1290 */       sNum = "\u53C1";
/* 1291 */       break;
/*      */     case 4:
/* 1293 */       sNum = "\u8086";
/* 1294 */       break;
/*      */     case 5:
/* 1296 */       sNum = "\u4F0D";
/* 1297 */       break;
/*      */     case 6:
/* 1299 */       sNum = "\u9646";
/* 1300 */       break;
/*      */     case 7:
/* 1302 */       sNum = "\u67D2";
/* 1303 */       break;
/*      */     case 8:
/* 1305 */       sNum = "\u634C";
/* 1306 */       break;
/*      */     case 9:
/* 1308 */       sNum = "\u7396";
/*      */     }
/*      */ 
/* 1311 */     return sNum;
/*      */   }
/*      */ 
/*      */   public static String getInt(String Value)
/*      */   {
/* 1317 */     if (Value == null)
/*      */     {
/* 1319 */       return null;
/*      */     }
/* 1321 */     String result = "";
/* 1322 */     boolean mflag = true;
/* 1323 */     int m = 0;
/* 1324 */     m = Value.lastIndexOf(".");
/* 1325 */     if (m == -1)
/*      */     {
/* 1327 */       result = Value;
/*      */     }
/*      */     else
/*      */     {
/* 1331 */       for (int i = m + 1; i <= Value.length() - 1; i++)
/*      */       {
/* 1333 */         if (Value.charAt(i) == '0')
/*      */           continue;
/* 1335 */         result = Value;
/* 1336 */         mflag = false;
/* 1337 */         break;
/*      */       }
/*      */ 
/* 1340 */       if (mflag)
/*      */       {
/* 1342 */         result = Value.substring(0, m);
/*      */       }
/*      */     }
/* 1345 */     return result;
/*      */   }
/*      */ 
/*      */   public static double getApproximation(double aValue)
/*      */   {
/* 1351 */     if (Math.abs(aValue) <= 0.01D)
/*      */     {
/* 1353 */       aValue = 0.0D;
/*      */     }
/* 1355 */     return aValue;
/*      */   }
/*      */ 
/*      */   public static String[] split(String strMain, String strDelimiters)
/*      */   {
/* 1362 */     int intIndex = 0;
/* 1363 */     Vector vResult = new Vector();
/* 1364 */     String strSub = "";
/*      */ 
/* 1366 */     strMain = strMain.trim();
/*      */ 
/* 1369 */     if (strMain.length() <= strDelimiters.length())
/*      */     {
/* 1371 */       System.out.println("\u5206\u9694\u7B26\u4E32\u957F\u5EA6\u5927\u4E8E\u7B49\u4E8E\u4E3B\u5B57\u7B26\u4E32\u957F\u5EA6\uFF0C\u4E0D\u80FD\u8FDB\u884C\u62C6\u5206\uFF01");
/* 1372 */       return null;
/*      */     }
/*      */ 
/* 1376 */     intIndex = strMain.indexOf(strDelimiters);
/*      */ 
/* 1379 */     if (intIndex == -1)
/*      */     {
/* 1381 */       String[] arrResult = 
/* 1382 */         { 
/* 1383 */         strMain };
/* 1384 */       return arrResult;
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/* 1390 */       strSub = strMain.substring(0, intIndex);
/* 1391 */       if (intIndex != 0)
/*      */       {
/* 1393 */         vResult.add(strSub);
/*      */       }
/*      */       else
/*      */       {
/* 1398 */         vResult.add("");
/*      */       }
/*      */ 
/* 1401 */       strMain = strMain.substring(intIndex + strDelimiters.length()).trim();
/* 1402 */       intIndex = strMain.indexOf(strDelimiters);
/*      */     }
/* 1388 */     while (intIndex != -1);
/*      */ 
/* 1407 */     if (!strMain.equals(""))
/*      */     {
/* 1409 */       vResult.add(strMain);
/*      */     }
/*      */ 
/* 1412 */     String[] arrResult = new String[vResult.size()];
/* 1413 */     for (int i = 0; i < vResult.size(); i++)
/*      */     {
/* 1415 */       arrResult[i] = ((String)vResult.get(i));
/*      */     }
/*      */ 
/* 1418 */     return arrResult;
/*      */   }
/*      */ 
/*      */   public static double setPrecision(float value, String precision)
/*      */   {
/* 1424 */     return Float.parseFloat(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static double setPrecision(double value, String precision)
/*      */   {
/* 1430 */     return Double.parseDouble(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static SchemaSet copySchemaSet(SchemaSet srcSet)
/*      */   {
/* 1436 */     Reflections reflect = new Reflections();
/*      */     try
/*      */     {
/* 1439 */       if ((srcSet != null) && (srcSet.size() > 0))
/*      */       {
/* 1441 */         if (srcSet.getObj(1) == null)
/*      */         {
/* 1443 */           return null;
/*      */         }
/* 1445 */         Class cls = srcSet.getClass();
/* 1446 */         Schema schema = 
/* 1447 */           (Schema)srcSet.getObj(1).getClass()
/* 1447 */           .newInstance();
/* 1448 */         SchemaSet obj = (SchemaSet)cls.newInstance();
/* 1449 */         obj.add(schema);
/* 1450 */         reflect.transFields(obj, srcSet);
/* 1451 */         return obj;
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1456 */       ex.printStackTrace();
/*      */     }
/* 1458 */     return null;
/*      */   }
/*      */ 
/*      */   public static boolean exchangeSchema(Schema source, Schema object)
/*      */   {
/*      */     try
/*      */     {
/* 1467 */       Reflections tReflections = new Reflections();
/* 1468 */       tReflections.transFields(object, source);
/*      */ 
/* 1471 */       Method m = object.getClass().getMethod("getDB", null);
/* 1472 */       Schema schemaDB = (Schema)m.invoke(object, null);
/*      */ 
/* 1474 */       m = schemaDB.getClass().getMethod("getInfo", null);
/* 1475 */       m.invoke(schemaDB, null);
/* 1476 */       m = schemaDB.getClass().getMethod("getSchema", null);
/* 1477 */       object = (Schema)m.invoke(schemaDB, null);
/*      */ 
/* 1480 */       m = object.getClass().getMethod("getSchema", null);
/* 1481 */       Schema tSchema = (Schema)m.invoke(object, null);
/*      */ 
/* 1484 */       tReflections.transFields(object, source);
/* 1485 */       tReflections.transFields(source, tSchema);
/*      */ 
/* 1487 */       return true;
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1491 */       ex.printStackTrace();
/* 1492 */     }return false;
/*      */   }
/*      */ 
/*      */   public static Vector formUpdateSql(String[] tables, String condition, String wherepart)
/*      */   {
/* 1500 */     Vector sqlVec = new Vector();
/* 1501 */     for (int i = 0; i < tables.length; i++)
/*      */     {
/* 1503 */       sqlVec.add("update " + tables[i] + " set " + condition + " where " + 
/* 1504 */         wherepart);
/*      */     }
/* 1506 */     return sqlVec;
/*      */   }
/*      */ 
/*      */   public static String DeleteZero(String sIn)
/*      */   {
/* 1512 */     int n = sIn.length();
/* 1513 */     String sOut = sIn;
/* 1514 */     int k = 0;
/*      */ 
/* 1516 */     while ((sOut.substring(0, 1).equals("0")) && (n > 1))
/*      */     {
/* 1518 */       sOut = sOut.substring(1, n);
/* 1519 */       n = sOut.length();
/* 1520 */       System.out.println(sOut);
/*      */     }
/*      */ 
/* 1523 */     if (sOut.equals("0"))
/*      */     {
/* 1525 */       return "";
/*      */     }
/*      */ 
/* 1529 */     return sOut;
/*      */   }
/*      */ 
/*      */   public static String CreateSeq(String seq)
/*      */   {
/* 1536 */     String tt = null;
/* 1537 */     ExeSQL tExeSQL = new ExeSQL();
/*      */     try
/*      */     {
/* 1540 */       tt = tExeSQL.getOneValue("select " + seq + ".nextval from dual");
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1544 */       System.out.println(ex.toString());
/*      */     }
/* 1546 */     return tt;
/*      */   }
/*      */ 
/*      */   public static String CreateSeq(String seq, int len) {
/* 1550 */     String tt = CreateSeq(seq);
/* 1551 */     tt = LCh(tt, "0", len);
/* 1552 */     return tt;
/*      */   }
/*      */ 
/*      */   public static String changForJavaScript(String s)
/*      */   {
/* 1562 */     char[] arr = s.toCharArray();
/* 1563 */     s = "";
/* 1564 */     for (int i = 0; i < arr.length; i++)
/*      */     {
/* 1566 */       if ((arr[i] == '"') || (arr[i] == '\'') || (arr[i] == '\n'))
/*      */       {
/* 1568 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1571 */       s = s + arr[i];
/*      */     }
/*      */ 
/* 1574 */     return s;
/*      */   }
/*      */ 
/*      */   public static String changForHTML(String s)
/*      */   {
/* 1580 */     char[] arr = s.toCharArray();
/* 1581 */     s = "";
/*      */ 
/* 1583 */     for (int i = 0; i < arr.length; i++)
/*      */     {
/* 1585 */       if ((arr[i] == '"') || (arr[i] == '\''))
/*      */       {
/* 1587 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1590 */       if (arr[i] == '\n')
/*      */       {
/* 1592 */         s = s + "<br>";
/*      */       }
/*      */       else
/*      */       {
/* 1596 */         s = s + arr[i];
/*      */       }
/*      */     }
/* 1599 */     return s;
/*      */   }
/*      */ 
/*      */   public static String getClassFileName(Object o)
/*      */   {
/* 1604 */     String fileName = o.getClass().getName();
/* 1605 */     fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
/* 1606 */     return fileName;
/*      */   }
/*      */ 
/*      */   public static void out(Object o, String s)
/*      */   {
/* 1611 */     System.out.println(getClassFileName(o) + " : " + s);
/*      */   }
/*      */ 
/*      */   public static int calPolYear(String cstartDate, String cendDate)
/*      */   {
/* 1617 */     FDate fDate = new FDate();
/* 1618 */     Date startDate = fDate.getDate(cstartDate);
/* 1619 */     Date endDate = fDate.getDate(cendDate);
/* 1620 */     if (fDate.mErrors.needDealError())
/*      */     {
/* 1622 */       return 0;
/*      */     }
/*      */ 
/* 1625 */     int interval = 0;
/*      */ 
/* 1627 */     GregorianCalendar sCalendar = new GregorianCalendar();
/* 1628 */     sCalendar.setTime(startDate);
/* 1629 */     int sYears = sCalendar.get(1);
/*      */ 
/* 1632 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/* 1634 */     GregorianCalendar eCalendar = new GregorianCalendar();
/* 1635 */     eCalendar.setTime(endDate);
/* 1636 */     int eYears = eCalendar.get(1);
/*      */ 
/* 1639 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/* 1641 */     interval = eYears - sYears;
/*      */ 
/* 1643 */     interval *= 365;
/*      */ 
/* 1645 */     interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/* 1648 */     int n = 0;
/* 1649 */     eYears--;
/* 1650 */     if (eYears > sYears)
/*      */     {
/* 1652 */       int i = sYears % 4;
/* 1653 */       if (i == 0)
/*      */       {
/* 1655 */         sYears++;
/* 1656 */         n++;
/*      */       }
/* 1658 */       int j = eYears % 4;
/* 1659 */       if (j == 0)
/*      */       {
/* 1661 */         eYears--;
/* 1662 */         n++;
/*      */       }
/* 1664 */       n += (eYears - sYears) / 4;
/*      */     }
/* 1666 */     if (eYears == sYears)
/*      */     {
/* 1668 */       int i = sYears % 4;
/* 1669 */       if (i == 0)
/*      */       {
/* 1671 */         n++;
/*      */       }
/*      */     }
/* 1674 */     interval += n;
/*      */ 
/* 1676 */     int x = 365;
/* 1677 */     int PolYear = 1;
/* 1678 */     while (x < interval)
/*      */     {
/* 1681 */       x += 365;
/*      */ 
/* 1683 */       PolYear++;
/*      */     }
/*      */ 
/* 1686 */     return PolYear;
/*      */   }
/*      */ 
/*      */   public static String getBirthdayFromId(String IdNo)
/*      */   {
/* 1692 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1693 */     String birthday = "";
/* 1694 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18))
/*      */     {
/* 1696 */       return "";
/*      */     }
/* 1698 */     if (tIdNo.length() == 18)
/*      */     {
/* 1700 */       birthday = tIdNo.substring(6, 14);
/* 1701 */       birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + 
/* 1702 */         "-" + birthday.substring(6);
/*      */     }
/* 1704 */     if (tIdNo.length() == 15)
/*      */     {
/* 1706 */       birthday = tIdNo.substring(6, 12);
/* 1707 */       birthday = birthday.substring(0, 2) + "-" + birthday.substring(2, 4) + 
/* 1708 */         "-" + birthday.substring(4);
/* 1709 */       birthday = "19" + birthday;
/*      */     }
/* 1711 */     return birthday;
/*      */   }
/*      */ 
/*      */   public static String getSexFromId(String IdNo)
/*      */   {
/* 1718 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1719 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18))
/*      */     {
/* 1721 */       return "";
/*      */     }
/* 1723 */     String sex = "";
/* 1724 */     if (tIdNo.length() == 15)
/*      */     {
/* 1726 */       sex = tIdNo.substring(14, 15);
/*      */     }
/*      */     else
/*      */     {
/* 1730 */       sex = tIdNo.substring(16, 17);
/*      */     }
/*      */     try
/*      */     {
/* 1734 */       int iSex = Integer.parseInt(sex);
/*      */ 
/* 1736 */       iSex %= 2;
/* 1737 */       if (iSex == 0)
/*      */       {
/* 1739 */         return "F";
/*      */       }
/* 1741 */       if (iSex == 1)
/*      */       {
/* 1743 */         return "M";
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1748 */       return "";
/*      */     }
/* 1750 */     return "";
/*      */   }
/*      */ 
/*      */   public static boolean canIDo(GlobalInput cGlobalInput, String RunScript)
/*      */   {
/* 1756 */     String Operator = cGlobalInput.Operator;
/*      */ 
/* 1760 */     String sqlStr = "select * from LDMenu";
/* 1761 */     sqlStr = sqlStr + 
/* 1762 */       "where NodeSign = 2 and RunScript = '" + RunScript + "' ";
/* 1763 */     sqlStr = sqlStr + 
/* 1764 */       "and NodeCode in ( select NodeCode from LDMenuGrpToMenu ";
/* 1765 */     sqlStr = sqlStr + 
/* 1766 */       "where MenuGrpCode in ( select MenuGrpCode from LDMenuGrp ";
/* 1767 */     sqlStr = sqlStr + 
/* 1768 */       "where MenuGrpCode in (select MenuGrpCode from LDUserToMenuGrp where UserCode = '";
/* 1769 */     sqlStr = sqlStr + Operator;
/* 1770 */     sqlStr = sqlStr + "') ) ) order by nodeorder";
/*      */ 
/* 1772 */     ExeSQL tExeSQL = new ExeSQL();
/* 1773 */     SSRS tSSRS = tExeSQL.execSQL(sqlStr);
/*      */ 
/* 1777 */     return (tSSRS != null) && (!tSSRS.equals(""));
/*      */   }
/*      */ 
/*      */   public static String moneyFormat(double value, int precision)
/*      */   {
/* 1785 */     double inData = round(value, precision);
/*      */ 
/* 1787 */     int dealData = (int)inData;
/*      */ 
/* 1789 */     String a = round(inData - dealData, precision);
/*      */ 
/* 1791 */     String outData = "";
/*      */ 
/* 1793 */     while (dealData > 1000) {
/* 1794 */       int data = dealData % 1000;
/* 1795 */       dealData /= 1000;
/* 1796 */       String temp = data;
/* 1797 */       System.out.println("temp=" + temp);
/* 1798 */       if (temp.length() != 3)
/*      */       {
/* 1800 */         for (int m = 0; m <= 3 - temp.length(); m++)
/*      */         {
/* 1802 */           temp = "0" + temp;
/*      */         }
/*      */       }
/*      */ 
/* 1806 */       outData = "," + temp + outData;
/* 1807 */       System.out.println("outData=" + outData);
/*      */     }
/*      */ 
/* 1810 */     outData = dealData + outData;
/* 1811 */     if (precision != 0)
/*      */     {
/* 1814 */       if (a.length() >= precision + 2)
/*      */       {
/* 1816 */         outData = outData + a.substring(1, precision + 2);
/*      */       }
/*      */       else
/*      */       {
/* 1820 */         outData = outData + a.substring(1, a.length());
/* 1821 */         for (int m = 0; m < precision + 2 - a.length(); m++)
/*      */         {
/* 1823 */           outData = outData + "0";
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1828 */     return outData;
/*      */   }
/*      */ 
/*      */   public static String getChineseYear(String date)
/*      */   {
/* 1833 */     if ((date != null) && (!date.equals(""))) {
/* 1834 */       String t = "";
/* 1835 */       String t1 = date.substring(0, 4);
/*      */       String t2;
/*      */       String t2;
/* 1837 */       if (date.substring(5, 6).equals("0"))
/* 1838 */         t2 = date.substring(6, 7);
/*      */       else
/* 1840 */         t2 = date.substring(5, 7);
/*      */       String t3;
/*      */       String t3;
/* 1843 */       if (date.substring(8, 9).equals("0"))
/* 1844 */         t3 = date.substring(9, 10);
/*      */       else {
/* 1846 */         t3 = date.substring(8, 10);
/*      */       }
/* 1848 */       t = t1 + "\u5E74" + t2 + "\u6708" + t3 + "\u65E5";
/* 1849 */       return t;
/*      */     }
/* 1851 */     return "";
/*      */   }
/*      */ 
/*      */   public static double round(double value, int precision)
/*      */   {
/* 1860 */     if (precision < 0)
/*      */     {
/* 1862 */       throw new IllegalArgumentException("The precision must be a positive integer or zero");
/*      */     }
/*      */ 
/* 1865 */     BigDecimal calNum = new BigDecimal(Double.toString(value));
/*      */ 
/* 1867 */     BigDecimal strType = new BigDecimal("1");
/*      */ 
/* 1869 */     return calNum.divide(strType, precision, 4).doubleValue();
/*      */   }
/*      */ 
/*      */   public static String calDateIntev(String strDate, int interval, String unit)
/*      */   {
/* 1876 */     String date = "";
/*      */     try {
/* 1878 */       GregorianCalendar mCalendar = new GregorianCalendar();
/* 1879 */       FDate tFDate = new FDate();
/* 1880 */       Date bDate = tFDate.getDate(strDate);
/* 1881 */       mCalendar.setTime(bDate);
/* 1882 */       if (unit.equals("Y")) {
/* 1883 */         mCalendar.add(1, interval);
/*      */       }
/* 1885 */       if (unit.equals("M")) {
/* 1886 */         mCalendar.add(2, interval);
/*      */       }
/* 1888 */       if (unit.equals("D")) {
/* 1889 */         mCalendar.add(5, interval);
/*      */       }
/* 1891 */       String Year = mCalendar.get(1);
/* 1892 */       String Month = mCalendar.get(2) + 1;
/* 1893 */       String Days = mCalendar.get(5);
/* 1894 */       date = Year + "-" + Month + "-" + Days;
/*      */     } catch (Exception ex) {
/* 1896 */       ex.printStackTrace();
/*      */     }
/* 1898 */     return date;
/*      */   }
/*      */ 
/*      */   public static String getRealPath()
/*      */   {
/*      */     try
/*      */     {
/* 1905 */       return getFullPathRelateClass("../../../../../..", PubFun.class);
/*      */     } catch (IOException ex) {
/*      */     }
/* 1908 */     return "Error!getFilePath Fail!";
/*      */   }
/*      */ 
/*      */   public static String getFullPathRelateClass(String relatedPath, Class cls)
/*      */     throws IOException
/*      */   {
/* 1914 */     String path = null;
/* 1915 */     if (relatedPath == null) {
/* 1916 */       throw new NullPointerException();
/*      */     }
/* 1918 */     String clsPath = getPathFromClass(cls);
/* 1919 */     File clsFile = new File(clsPath);
/* 1920 */     String tempPath = clsFile.getParent() + File.separator + relatedPath;
/* 1921 */     File file = new File(tempPath);
/* 1922 */     path = file.getCanonicalPath();
/* 1923 */     return path;
/*      */   }
/*      */ 
/*      */   public static String getPathFromClass(Class cls) throws IOException {
/* 1927 */     String path = null;
/* 1928 */     if (cls == null) {
/* 1929 */       throw new NullPointerException();
/*      */     }
/* 1931 */     URL url = getClassLocationURL(cls);
/* 1932 */     if (url != null) {
/* 1933 */       path = url.getPath();
/* 1934 */       if ("jar".equalsIgnoreCase(url.getProtocol())) {
/*      */         try {
/* 1936 */           path = new URL(path).getPath();
/*      */         } catch (MalformedURLException localMalformedURLException) {
/*      */         }
/* 1939 */         int location = path.indexOf("!/");
/* 1940 */         if (location != -1) {
/* 1941 */           path = path.substring(0, location);
/*      */         }
/*      */       }
/* 1944 */       File file = new File(path);
/* 1945 */       path = file.getCanonicalPath();
/*      */     }
/* 1947 */     return path;
/*      */   }
/*      */ 
/*      */   private static URL getClassLocationURL(Class cls) {
/* 1951 */     if (cls == null)
/* 1952 */       throw new IllegalArgumentException("null input: cls");
/* 1953 */     URL result = null;
/* 1954 */     String clsAsResource = cls.getName().replace('.', '/').concat(
/* 1955 */       ".class");
/* 1956 */     ProtectionDomain pd = cls.getProtectionDomain();
/*      */ 
/* 1962 */     if (pd != null) {
/* 1963 */       CodeSource cs = pd.getCodeSource();
/*      */ 
/* 1966 */       if (cs != null) {
/* 1967 */         result = cs.getLocation();
/*      */       }
/* 1969 */       if (result != null)
/*      */       {
/* 1973 */         if ("file".equals(result.getProtocol()))
/*      */           try {
/* 1975 */             if ((result.toExternalForm().endsWith(".jar")) || 
/* 1976 */               (result.toExternalForm().endsWith(".zip")))
/* 1977 */               result = new URL("jar:".concat(
/* 1978 */                 result.toExternalForm()).concat("!/")
/* 1979 */                 .concat(clsAsResource));
/* 1980 */             else if (new File(result.getFile()).isDirectory())
/* 1981 */               result = new URL(result, clsAsResource);
/*      */           }
/*      */           catch (MalformedURLException localMalformedURLException)
/*      */           {
/*      */           }
/*      */       }
/*      */     }
/* 1988 */     if (result == null)
/*      */     {
/* 1993 */       ClassLoader clsLoader = cls.getClassLoader();
/* 1994 */       result = clsLoader != null ? clsLoader.getResource(clsAsResource) : 
/* 1995 */         ClassLoader.getSystemResource(clsAsResource);
/*      */     }
/* 1997 */     return result;
/*      */   }
/*      */ 
/*      */   public static Object getClassForName(String sPackageClass) {
/*      */     Object obj;
/*      */     try {
/* 2004 */       obj = Class.forName(sPackageClass).newInstance();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */       Object obj;
/* 2008 */       obj = null;
/* 2009 */       ex.printStackTrace();
/*      */     }
/* 2011 */     return obj;
/*      */   }
/*      */ 
/*      */   public static Object getClassForName(String sPackage, String sClass) {
/*      */     Object obj;
/*      */     try {
/* 2018 */       obj = Class.forName(sPackage + "." + sClass).newInstance();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */       Object obj;
/* 2022 */       obj = null;
/* 2023 */       ex.printStackTrace();
/*      */     }
/* 2025 */     return obj;
/*      */   }
/*      */ 
/*      */   public static String DealContNoMappingState(String PrtNo, String oriState, String newState)
/*      */   {
/* 2031 */     String sql = "update lccontnomapping set state='" + newState + "', modifydate='" + getCurrentDate() + 
/* 2032 */       "', modifytime='" + getCurrentTime() + "'  where prtno='" + PrtNo + "' and state='" + oriState + "'";
/* 2033 */     return sql;
/*      */   }
/*      */ 
/*      */   public static String DealContNoMappingState(String PrtNo, String oriState, String newState, String accno)
/*      */   {
/* 2040 */     String sql = "update lccontnomapping set state='" + newState + "', modifydate='" + getCurrentDate() + 
/* 2041 */       "', modifytime='" + getCurrentTime() + "' ,standbyflag2 ='" + accno + "'  where prtno='" + PrtNo + "' and state='" + oriState + "'";
/* 2042 */     return sql;
/*      */   }
/*      */ 
/*      */   public static boolean checkGrpAccMoney(String tCustomerNo, double tMoney, String tOtherNo, String tBussType)
/*      */   {
/*      */     try
/*      */     {
/* 2053 */       StringBuffer tSql = new StringBuffer(16);
/* 2054 */       tSql.append("select count(1) from ljgrpacctrace where customerno = '" + tCustomerNo + "' and otherno = '" + tOtherNo + 
/* 2055 */         "' and moneytype = '" + tBussType + "' and money = -" + tMoney);
/* 2056 */       ExeSQL tExeSql = new ExeSQL();
/* 2057 */       String tCount = tExeSql.getOneValue(tSql.toString());
/* 2058 */       if ((tCount != null) && (!"0".equals(tCount)))
/*      */       {
/* 2060 */         return true;
/*      */       }
/*      */ 
/* 2064 */       tSql = new StringBuffer(16);
/* 2065 */       tSql.append("select nvl(sum(money),0) from ljgrpacctrace where customerno = '" + tCustomerNo + "'");
/* 2066 */       tExeSql = new ExeSQL();
/*      */ 
/* 2068 */       double tAccMoney = Double.parseDouble(tExeSql.getOneValue(tSql.toString()));
/*      */ 
/* 2071 */       return tAccMoney >= tMoney;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 2080 */       e.printStackTrace();
/* 2081 */     }return false;
/*      */   }
/*      */ 
/*      */   public static String DeleteTailZero(String tNum)
/*      */   {
/* 2089 */     String tmpNum = tNum;
/* 2090 */     int pos = tmpNum.length();
/* 2091 */     boolean flag = false;
/*      */     do {
/* 2093 */       pos = tmpNum.length();
/* 2094 */       flag = false;
/*      */ 
/* 2096 */       int t1 = tmpNum.lastIndexOf(".");
/* 2097 */       int t2 = tmpNum.lastIndexOf("0");
/* 2098 */       if ((t1 > 0) && (t2 > t1 + 1) && (pos == t2 + 1)) {
/* 2099 */         tmpNum = tmpNum.substring(0, t2);
/* 2100 */         flag = true;
/*      */       }
/* 2102 */       if ((t1 > 0) && (t2 == t1 + 1) && (pos == t2 + 1)) {
/* 2103 */         tmpNum = tmpNum.substring(0, t1);
/* 2104 */         flag = true;
/*      */       }
/*      */     }
/* 2107 */     while (flag);
/*      */ 
/* 2109 */     return tmpNum;
/*      */   }
/*      */ 
/*      */   public static boolean CheckChargeRate(String tGrpContNo)
/*      */   {
/* 2115 */     String tSql = "select agentcom from lcgrpcont where grpcontno = '" + tGrpContNo + "' ";
/* 2116 */     ExeSQL exeSql = new ExeSQL();
/*      */ 
/* 2118 */     String tResult = exeSql.getOneValue(tSql);
/*      */ 
/* 2121 */     return (tResult != null) && (!tResult.equals(""));
/*      */   }
/*      */ 
/*      */   public static String[][] decodeEasyQueryResult(String strResult)
/*      */   {
/* 2133 */     String[][] Result = new String[1024][];
/*      */ 
/* 2136 */     String RECORDDELIMITER = "\\^";
/* 2137 */     String FIELDDELIMITER = "\\|";
/*      */     try
/*      */     {
/* 2147 */       strResult = strResult.substring(strResult.indexOf("^") + 1);
/*      */ 
/* 2149 */       int RowLen = strResult.split(RECORDDELIMITER).length;
/*      */ 
/* 2151 */       String[] arrResult = new String[RowLen];
/*      */ 
/* 2153 */       arrResult = strResult.split(RECORDDELIMITER);
/*      */ 
/* 2156 */       String numOneLine = arrResult[0];
/*      */ 
/* 2158 */       int ColumnLen = arrResult[0].split(FIELDDELIMITER).length;
/*      */ 
/* 2160 */       if (numOneLine.endsWith("|"))
/*      */       {
/* 2162 */         ColumnLen++;
/*      */       }
/*      */ 
/* 2165 */       Result = new String[RowLen][ColumnLen];
/*      */ 
/* 2168 */       for (int X = 0; X < RowLen; X++)
/*      */       {
/* 2171 */         int cellLen = arrResult[X].split(FIELDDELIMITER).length;
/*      */ 
/* 2174 */         String[] arrField = new String[ColumnLen];
/*      */ 
/* 2177 */         if (cellLen < ColumnLen)
/*      */         {
/*      */           int tmp127_125 = X;
/*      */           String[] tmp127_123 = arrResult; tmp127_123[tmp127_125] = tmp127_123[tmp127_125];
/*      */         }
/*      */ 
/* 2182 */         arrField = arrResult[X].split(FIELDDELIMITER);
/*      */ 
/* 2185 */         for (int Y = 0; Y < cellLen; Y++)
/*      */         {
/* 2187 */           String str = arrField[Y];
/*      */ 
/* 2189 */           if (str == null)
/* 2190 */             Result[X][Y] = "";
/*      */           else {
/* 2192 */             Result[X][Y] = arrField[Y];
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2199 */       System.out.println("PubFun.decodeEasyQueryResult Error::" + ex.toString());
/*      */     }
/*      */ 
/* 2202 */     return Result;
/*      */   }
/*      */ 
/*      */   public static String getPageCtrl(String nodecode, String userCode, String buttonType)
/*      */   {
/* 2207 */     String roleSQL = " select b.nodecode,a.menugrpcode from ledusertomenugrp a,ledmenugrptomenu b where a.usercode='" + 
/* 2208 */       userCode + "'  and a.menugrpcode=b.menugrpcode and b.nodecode='" + nodecode + "'";
/* 2209 */     ExeSQL tExeSQL = new ExeSQL();
/* 2210 */     SSRS tSSRS = tExeSQL.execSQL(roleSQL);
/* 2211 */     if ((tSSRS == null) && (tSSRS.MaxRow < 1))
/*      */     {
/* 2213 */       return "";
/*      */     }
/* 2215 */     String menuGrpCode = tSSRS.GetText(1, 2);
/* 2216 */     String pageCtrl = "   select p.buttonid from ledpagectrl p where p.menugrpcode='" + 
/* 2217 */       menuGrpCode + "' and p.nodecode='" + nodecode + "' and p.buttontype='" + buttonType + "' and p.buttonswitch=1";
/* 2218 */     SSRS ctrlSSRS = tExeSQL.execSQL(pageCtrl);
/* 2219 */     if ((ctrlSSRS == null) && (ctrlSSRS.MaxRow < 1))
/*      */     {
/* 2221 */       return "";
/*      */     }
/* 2223 */     String treturn = "";
/* 2224 */     for (int i = 1; i <= ctrlSSRS.MaxRow; i++)
/*      */     {
/* 2226 */       treturn = treturn + ctrlSSRS.GetText(i, 1) + "|";
/*      */     }
/* 2228 */     return treturn;
/*      */   }
/*      */ 
/*      */   public static String getLastAccDate(String tPolNo)
/*      */   {
/* 2236 */     ExeSQL tExeSQL = new ExeSQL();
/* 2237 */     String tSQL = "select to_char(enddate, 'YYYY-MM-DD') from lcpol where polno='" + tPolNo + "'";
/* 2238 */     String tEndDate = tExeSQL.getOneValue(tSQL);
/* 2239 */     String tCurrentDate = getCurrentDate();
/* 2240 */     String tLastAccDate = getBeforeDate(tEndDate, tCurrentDate);
/*      */ 
/* 2242 */     return tLastAccDate;
/*      */   }
/*      */ 
/*      */   public static String isPolClaim(String contno, String edortype)
/*      */   {
/* 2248 */     String treturn = "";
/* 2249 */     ExeSQL tExeSQL = new ExeSQL();
/* 2250 */     String SQL = " select count(1) from llcase a, llclaim b, lcpol c  where b.clmno(+) = a.caseno and c.contno='" + contno + "' " + 
/* 2251 */       " and a.contno=c.contno and (b.clmstate not in ('60', '70', '80') or b.clmstate is null) ";
/* 2252 */     String tResuit = tExeSQL.getOneValue(SQL);
/*      */ 
/* 2255 */     System.out.println("tianxh---" + SQL);
/* 2256 */     System.out.println("tianxh---" + tResuit);
/* 2257 */     if (Integer.parseInt(tResuit) > 0)
/*      */     {
/* 2260 */       treturn = "\u8BE5\u4FDD\u5355\u53D1\u751F\u7406\u8D54\u8FD8\u672A\u7ED3\u6848\uFF0C\u8BF7\u7406\u8D54\u7ED3\u6848\u540E\u518D\u7533\u8BF7\u4FDD\u5168\uFF01";
/*      */     }
/* 2262 */     return treturn;
/*      */   }
/*      */ 
/*      */   public static String filterSQLParam(String content)
/*      */   {
/* 2267 */     String flt = "'|drop|and|exec|insert|select|delete|update|count|*|chr|mid|master|truncate|char|declare|;|or|-|+|,";
/* 2268 */     String[] filter = flt.split("|");
/* 2269 */     for (int i = 0; i < filter.length; i++) {
/* 2270 */       content = content.replace(filter[i], "");
/*      */     }
/* 2272 */     return content;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/* 2278 */     String tContPlanCode = "ContPlanCode=0000000005";
/* 2279 */     System.out.println("resss======" + filterSQLParam(tContPlanCode));
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.PubFun
 * JD-Core Version:    0.6.0
 */