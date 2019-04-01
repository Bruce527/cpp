/*      */ package com.sinosoft.banklns.lis.pubfun;
/*      */ 
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.JdbcUrl;
/*      */ import com.sinosoft.banklns.utility.Reflections;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.SchemaSet;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.reflect.Method;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Vector;
/*      */ 
/*      */ public class PubFun
/*      */ {
/*   19 */   public static HashMap riskDataHashMap = null;
/*   20 */   public static HashMap riskFlagDataHashMap = null;
/*      */ 
/*      */   public static Date calDate(Date baseDate, int interval, String unit, Date compareDate)
/*      */   {
/*   25 */     Date returnDate = null;
/*      */ 
/*   27 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*   28 */     mCalendar.setTime(baseDate);
/*   29 */     if (unit.equals("Y")) mCalendar.add(1, interval);
/*   30 */     if (unit.equals("M")) mCalendar.add(2, interval);
/*   31 */     if (unit.equals("D")) mCalendar.add(5, interval);
/*      */ 
/*   33 */     if (compareDate != null) {
/*   34 */       GregorianCalendar cCalendar = new GregorianCalendar();
/*   35 */       cCalendar.setTime(compareDate);
/*      */ 
/*   37 */       int mYears = mCalendar.get(1);
/*   38 */       int mMonths = mCalendar.get(2);
/*   39 */       int cMonths = cCalendar.get(2);
/*   40 */       int cDays = cCalendar.get(5);
/*      */ 
/*   42 */       if (unit.equals("Y")) {
/*   43 */         cCalendar.set(mYears, cMonths, cDays);
/*   44 */         if (cCalendar.before(mCalendar)) {
/*   45 */           mCalendar.set(mYears + 1, cMonths, cDays);
/*   46 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/*   49 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*   51 */       if (unit.equals("M")) {
/*   52 */         cCalendar.set(mYears, mMonths, cDays);
/*   53 */         if (cCalendar.before(mCalendar)) {
/*   54 */           mCalendar.set(mYears, mMonths + 1, cDays);
/*   55 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/*   58 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*   60 */       if (unit.equals("D"))
/*   61 */         returnDate = mCalendar.getTime();
/*      */     }
/*      */     else {
/*   64 */       returnDate = mCalendar.getTime();
/*      */     }
/*   66 */     return returnDate;
/*      */   }
/*      */ 
/*      */   public static String calDate(String baseDate, int interval, String unit, String compareDate) {
/*      */     try {
/*   71 */       FDate tFDate = new FDate();
/*   72 */       Date bDate = tFDate.getDate(baseDate);
/*   73 */       Date cDate = tFDate.getDate(compareDate);
/*   74 */       return tFDate.getString(calDate(bDate, interval, unit, cDate));
/*      */     }
/*      */     catch (Exception ex) {
/*   77 */       ex.printStackTrace();
/*   78 */     }return null;
/*      */   }
/*      */ 
/*      */   public static int calInterval(Date startDate, Date endDate, String unit)
/*      */   {
/*   83 */     int interval = 0;
/*      */ 
/*   85 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*   86 */     sCalendar.setTime(startDate);
/*   87 */     int sYears = sCalendar.get(1);
/*   88 */     int sMonths = sCalendar.get(2);
/*   89 */     int sDays = sCalendar.get(5);
/*   90 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*   92 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*   93 */     eCalendar.setTime(endDate);
/*   94 */     int eYears = eCalendar.get(1);
/*   95 */     int eMonths = eCalendar.get(2);
/*   96 */     int eDays = eCalendar.get(5);
/*   97 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*   99 */     if (unit.equals("Y")) {
/*  100 */       interval = eYears - sYears;
/*  101 */       if (eMonths < sMonths) {
/*  102 */         interval--;
/*      */       }
/*  105 */       else if ((eMonths == sMonths) && (eDays < sDays)) {
/*  106 */         interval--;
/*  107 */         if ((eMonths == 1) && 
/*  108 */           (sYears % 4 == 0) && (eYears % 4 != 0))
/*      */         {
/*  110 */           if (eDays == 28) {
/*  111 */             interval++;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  118 */     if (unit.equals("M")) {
/*  119 */       interval = eYears - sYears;
/*  120 */       interval *= 12;
/*      */ 
/*  122 */       interval = eMonths - sMonths + interval;
/*  123 */       if (eDays < sDays) {
/*  124 */         interval--;
/*      */ 
/*  126 */         int maxDate = eCalendar.getActualMaximum(5);
/*  127 */         if (eDays == maxDate) {
/*  128 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  132 */     if (unit.equals("D")) {
/*  133 */       interval = eYears - sYears;
/*  134 */       interval *= 365;
/*  135 */       interval = eDaysOfYear - sDaysOfYear + interval;
/*      */ 
/*  137 */       int n = 0;
/*  138 */       eYears--;
/*  139 */       if (eYears > sYears) {
/*  140 */         int i = sYears % 4;
/*  141 */         if (i == 0) {
/*  142 */           sYears++;
/*  143 */           n++;
/*      */         }
/*  145 */         int j = eYears % 4;
/*  146 */         if (j == 0) {
/*  147 */           eYears--;
/*  148 */           n++;
/*      */         }
/*  150 */         n += (eYears - sYears) / 4;
/*      */       }
/*  152 */       if (eYears == sYears) {
/*  153 */         int i = sYears % 4;
/*  154 */         if (i == 0)
/*  155 */           n++;
/*      */       }
/*  157 */       interval += n;
/*      */     }
/*  159 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval(String cstartDate, String cendDate, String unit) {
/*  163 */     FDate fDate = new FDate();
/*  164 */     Date startDate = fDate.getDate(cstartDate);
/*  165 */     Date endDate = fDate.getDate(cendDate);
/*  166 */     if (fDate.mErrors.needDealError()) {
/*  167 */       return 0;
/*      */     }
/*  169 */     int interval = 0;
/*      */ 
/*  171 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  172 */     sCalendar.setTime(startDate);
/*  173 */     int sYears = sCalendar.get(1);
/*  174 */     int sMonths = sCalendar.get(2);
/*  175 */     int sDays = sCalendar.get(5);
/*  176 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  178 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  179 */     eCalendar.setTime(endDate);
/*  180 */     int eYears = eCalendar.get(1);
/*  181 */     int eMonths = eCalendar.get(2);
/*  182 */     int eDays = eCalendar.get(5);
/*  183 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  185 */     if (StrTool.cTrim(unit).equals("Y")) {
/*  186 */       interval = eYears - sYears;
/*      */ 
/*  188 */       if (eMonths < sMonths) {
/*  189 */         interval--;
/*      */       }
/*  192 */       else if ((eMonths == sMonths) && (eDays < sDays)) {
/*  193 */         interval--;
/*  194 */         if ((eMonths == 1) && 
/*  195 */           (sYears % 4 == 0) && (eYears % 4 != 0))
/*      */         {
/*  197 */           if (eDays == 28) {
/*  198 */             interval++;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  205 */     if (StrTool.cTrim(unit).equals("M")) {
/*  206 */       interval = eYears - sYears;
/*  207 */       interval *= 12;
/*  208 */       interval = eMonths - sMonths + interval;
/*      */ 
/*  210 */       if (eDays < sDays) {
/*  211 */         interval--;
/*      */ 
/*  213 */         int maxDate = eCalendar.getActualMaximum(5);
/*  214 */         if (eDays == maxDate) {
/*  215 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  219 */     if (StrTool.cTrim(unit).equals("D")) {
/*  220 */       interval = eYears - sYears;
/*  221 */       interval *= 365;
/*      */ 
/*  223 */       interval = eDaysOfYear - sDaysOfYear + interval;
/*      */ 
/*  225 */       int n = 0;
/*  226 */       eYears--;
/*  227 */       if (eYears > sYears) {
/*  228 */         int i = sYears % 4;
/*  229 */         if (i == 0) {
/*  230 */           sYears++;
/*  231 */           n++;
/*      */         }
/*  233 */         int j = eYears % 4;
/*  234 */         if (j == 0) {
/*  235 */           eYears--;
/*  236 */           n++;
/*      */         }
/*  238 */         n += (eYears - sYears) / 4;
/*      */       }
/*  240 */       if (eYears == sYears) {
/*  241 */         int i = sYears % 4;
/*  242 */         if (i == 0)
/*  243 */           n++;
/*      */       }
/*  245 */       interval += n;
/*      */     }
/*  247 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval2(String cstartDate, String cendDate, String unit)
/*      */   {
/*  252 */     FDate fDate = new FDate();
/*  253 */     Date startDate = fDate.getDate(cstartDate);
/*  254 */     Date endDate = fDate.getDate(cendDate);
/*  255 */     if (fDate.mErrors.needDealError()) {
/*  256 */       return 0;
/*      */     }
/*  258 */     int interval = 0;
/*      */ 
/*  260 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  261 */     sCalendar.setTime(startDate);
/*  262 */     int sYears = sCalendar.get(1);
/*  263 */     int sMonths = sCalendar.get(2);
/*  264 */     int sDays = sCalendar.get(5);
/*  265 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  267 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  268 */     eCalendar.setTime(endDate);
/*  269 */     int eYears = eCalendar.get(1);
/*  270 */     int eMonths = eCalendar.get(2);
/*  271 */     int eDays = eCalendar.get(5);
/*  272 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  274 */     if (StrTool.cTrim(unit).equals("Y")) {
/*  275 */       interval = eYears - sYears;
/*      */ 
/*  277 */       if (eMonths > sMonths) {
/*  278 */         interval++;
/*      */       }
/*  281 */       else if ((eMonths == sMonths) && (eDays > sDays)) {
/*  282 */         interval++;
/*  283 */         if ((eMonths == 1) && 
/*  284 */           (sYears % 4 == 0) && (eYears % 4 != 0))
/*      */         {
/*  286 */           if (eDays == 28) {
/*  287 */             interval--;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  294 */     if (StrTool.cTrim(unit).equals("M")) {
/*  295 */       interval = eYears - sYears;
/*  296 */       interval *= 12;
/*  297 */       interval = eMonths - sMonths + interval;
/*      */ 
/*  299 */       if (eDays > sDays) {
/*  300 */         interval++;
/*      */ 
/*  302 */         int maxDate = eCalendar.getActualMaximum(5);
/*  303 */         if (eDays == maxDate) {
/*  304 */           interval--;
/*      */         }
/*      */       }
/*      */     }
/*  308 */     if (StrTool.cTrim(unit).equals("D")) {
/*  309 */       interval = eYears - sYears;
/*  310 */       interval *= 365;
/*      */ 
/*  312 */       interval = eDaysOfYear - sDaysOfYear + interval;
/*      */ 
/*  314 */       int n = 0;
/*  315 */       eYears--;
/*  316 */       if (eYears > sYears) {
/*  317 */         int i = sYears % 4;
/*  318 */         if (i == 0) {
/*  319 */           sYears++;
/*  320 */           n++;
/*      */         }
/*  322 */         int j = eYears % 4;
/*  323 */         if (j == 0) {
/*  324 */           eYears--;
/*  325 */           n++;
/*      */         }
/*  327 */         n += (eYears - sYears) / 4;
/*      */       }
/*  329 */       if (eYears == sYears) {
/*  330 */         int i = sYears % 4;
/*  331 */         if (i == 0)
/*  332 */           n++;
/*      */       }
/*  334 */       interval += n;
/*      */     }
/*  336 */     return interval;
/*      */   }
/*      */ 
/*      */   public static String[] calFLDate(String tDate) {
/*  340 */     String[] MonDate = new String[2];
/*  341 */     FDate fDate = new FDate();
/*  342 */     Date CurDate = fDate.getDate(tDate);
/*  343 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*  344 */     mCalendar.setTime(CurDate);
/*  345 */     int Years = mCalendar.get(1);
/*  346 */     int Months = mCalendar.get(2);
/*  347 */     int FirstDay = mCalendar.getActualMinimum(5);
/*  348 */     int LastDay = mCalendar.getActualMaximum(5);
/*  349 */     mCalendar.set(Years, Months, FirstDay);
/*  350 */     MonDate[0] = fDate.getString(mCalendar.getTime());
/*  351 */     mCalendar.set(Years, Months, LastDay);
/*  352 */     MonDate[1] = fDate.getString(mCalendar.getTime());
/*  353 */     return MonDate;
/*      */   }
/*      */ 
/*      */   public static Date stringConverttoDetailDate(String cDate)
/*      */   {
/*  359 */     Calendar tCalendar = Calendar.getInstance();
/*      */     try
/*      */     {
/*  362 */       int _year = Integer.parseInt(cDate.substring(0, 4));
/*  363 */       int _month = Integer.parseInt(cDate.substring(5, 7)) - 1;
/*  364 */       int _day = Integer.parseInt(cDate.substring(8, 10));
/*  365 */       int _hour = Integer.parseInt(cDate.substring(11, 13));
/*  366 */       int _min = Integer.parseInt(cDate.substring(14, 16));
/*  367 */       int _sec = Integer.parseInt(cDate.substring(17));
/*      */ 
/*  370 */       tCalendar.set(1, _year);
/*      */ 
/*  372 */       tCalendar.set(2, _month);
/*      */ 
/*  374 */       tCalendar.set(5, _day);
/*  375 */       if (_hour <= 12)
/*  376 */         tCalendar.set(10, _hour);
/*      */       else
/*  378 */         tCalendar.set(10, _hour - 12);
/*  379 */       if (_hour < 12)
/*  380 */         tCalendar.set(9, 0);
/*      */       else
/*  382 */         tCalendar.set(9, 1);
/*  383 */       tCalendar.set(12, _min);
/*  384 */       tCalendar.set(13, _sec);
/*      */ 
/*  386 */       return tCalendar.getTime();
/*      */     }
/*      */     catch (Exception e) {
/*      */     }
/*  390 */     return null;
/*      */   }
/*      */ 
/*      */   public static JdbcUrl getDefaultUrl()
/*      */   {
/*  467 */     JdbcUrl tUrl = new JdbcUrl();
/*  468 */     return tUrl;
/*      */   }
/*      */ 
/*      */   public static String RCh(String sourString, String cChar, int cLen) {
/*  472 */     int tLen = sourString.length();
/*      */ 
/*  474 */     String tReturn = "";
/*  475 */     if (tLen >= cLen)
/*  476 */       return sourString;
/*  477 */     int iMax = cLen - tLen;
/*  478 */     for (int i = 0; i < iMax; i++) {
/*  479 */       tReturn = tReturn + cChar;
/*      */     }
/*  481 */     tReturn = sourString.trim() + tReturn.trim();
/*  482 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String LCh(String sourString, String cChar, int cLen) {
/*  486 */     int tLen = sourString.length();
/*      */ 
/*  488 */     String tReturn = "";
/*  489 */     if (tLen >= cLen)
/*  490 */       return sourString;
/*  491 */     int iMax = cLen - tLen;
/*  492 */     for (int i = 0; i < iMax; i++) {
/*  493 */       tReturn = cChar + tReturn;
/*      */     }
/*  495 */     tReturn = tReturn.trim() + sourString.trim();
/*  496 */     return tReturn;
/*      */   }
/*      */   public static String getLaterDate(String date1, String date2) {
/*      */     try {
/*  500 */       date1 = StrTool.cTrim(date1);
/*  501 */       date2 = StrTool.cTrim(date2);
/*  502 */       if (date1.equals("")) return date2;
/*  503 */       if (date2.equals("")) return date1;
/*  504 */       FDate fd = new FDate();
/*  505 */       Date d1 = fd.getDate(date1);
/*  506 */       Date d2 = fd.getDate(date2);
/*  507 */       if (d1.after(d2)) return date1;
/*  508 */       return date2;
/*      */     } catch (Exception e) {
/*  510 */       e.printStackTrace();
/*  511 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getBeforeDate(String date1, String date2)
/*      */   {
/*      */     try {
/*  517 */       date1 = StrTool.cTrim(date1);
/*  518 */       date2 = StrTool.cTrim(date2);
/*  519 */       if (date1.equals("")) return date2;
/*  520 */       if (date2.equals("")) return date1;
/*  521 */       FDate fd = new FDate();
/*  522 */       Date d1 = fd.getDate(date1);
/*  523 */       Date d2 = fd.getDate(date2);
/*  524 */       if (d1.before(d2)) return date1;
/*  525 */       return date2;
/*      */     } catch (Exception e) {
/*  527 */       e.printStackTrace();
/*  528 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getCurrentDate()
/*      */   {
/*  534 */     String pattern = "yyyy-MM-dd";
/*  535 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*  536 */     Date today = new Date();
/*  537 */     String tString = df.format(today);
/*  538 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getCurrentTime() {
/*  542 */     String pattern = "HH:mm:ss";
/*  543 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*  544 */     Date today = new Date();
/*  545 */     String tString = df.format(today);
/*  546 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getNoLimit(String comCode) {
/*  550 */     comCode = comCode.trim();
/*  551 */     int tLen = comCode.length();
/*  552 */     if (tLen > 6) comCode = comCode.substring(0, 6);
/*  553 */     if (tLen < 6) comCode = RCh(comCode, "0", 6);
/*  554 */     String tString = "";
/*  555 */     tString = comCode + getCurrentDate().substring(0, 4);
/*  556 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getStr(String c_Str, int c_i, String c_Split) {
/*  560 */     String t_Str1 = ""; String t_Str2 = ""; String t_strOld = "";
/*  561 */     int i = 0; int i_Start = 0; int j_End = 0;
/*  562 */     t_Str1 = c_Str;
/*  563 */     t_Str2 = c_Split;
/*  564 */     i = 0;
/*      */     try {
/*  566 */       while (i < c_i) {
/*  567 */         i_Start = t_Str1.indexOf(t_Str2, 0);
/*  568 */         if (i_Start >= 0) {
/*  569 */           i++;
/*  570 */           t_strOld = t_Str1;
/*  571 */           t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), t_Str1.length());
/*      */         }
/*      */         else {
/*  574 */           if (i == c_i - 1) break;
/*  575 */           t_Str1 = "";
/*      */ 
/*  577 */           break;
/*      */         }
/*      */       }
/*      */ 
/*  581 */       if (i_Start >= 0)
/*  582 */         t_Str1 = t_strOld.substring(0, i_Start);
/*      */     }
/*      */     catch (Exception ex) {
/*  585 */       t_Str1 = "";
/*      */     }
/*  587 */     return t_Str1;
/*      */   }
/*      */ 
/*      */   public static String getChnMoney(double money) {
/*  591 */     String ChnMoney = "";
/*  592 */     String s0 = "";
/*      */ 
/*  596 */     if (money == 0.0D) {
/*  597 */       ChnMoney = "\u96F6\u5143\u6574";
/*  598 */       return ChnMoney;
/*      */     }
/*      */ 
/*  601 */     if (money < 0.0D) {
/*  602 */       s0 = "\u8D1F";
/*  603 */       money *= -1.0D;
/*      */     }
/*      */ 
/*  606 */     String sMoney = new DecimalFormat("0").format(money * 100.0D);
/*      */ 
/*  608 */     int nLen = sMoney.length();
/*      */     String sDot;
/*      */     String sInteger;
/*      */     String sDot;
/*  611 */     if (nLen < 2) {
/*  612 */       String sInteger = "";
/*      */       String sDot;
/*  613 */       if (nLen == 1) {
/*  614 */         sDot = "0" + sMoney.substring(nLen - 1, nLen);
/*      */       }
/*      */       else
/*  617 */         sDot = "0";
/*      */     }
/*      */     else
/*      */     {
/*  621 */       sInteger = sMoney.substring(0, nLen - 2);
/*  622 */       sDot = sMoney.substring(nLen - 2, nLen);
/*      */     }
/*      */ 
/*  625 */     String sFormatStr = formatStr(sInteger);
/*      */ 
/*  627 */     String s1 = getChnM(sFormatStr.substring(0, 4), "\u4EBF");
/*      */ 
/*  629 */     String s2 = getChnM(sFormatStr.substring(4, 8), "\u4E07");
/*      */ 
/*  631 */     String s3 = getChnM(sFormatStr.substring(8, 12), "");
/*      */ 
/*  633 */     String s4 = getDotM(sDot);
/*      */ 
/*  635 */     if ((s1.length() > 0) && (s1.substring(0, 1).equals("0"))) s1 = s1.substring(1, 
/*  636 */         s1.length());
/*  637 */     if ((s1.length() > 0) && 
/*  638 */       (s1.substring(s1.length() - 1, s1.length()).equals("0")) && 
/*  639 */       (s2.length() > 0) && (s2.substring(0, 1).equals("0")))
/*  640 */       s1 = s1.substring(0, s1.length() - 1);
/*  641 */     if ((s2.length() > 0) && 
/*  642 */       (s2.substring(s2.length() - 1, s2.length()).equals("0")) && 
/*  643 */       (s3.length() > 0) && (s3.substring(0, 1).equals("0")))
/*  644 */       s2 = s2.substring(0, s2.length() - 1);
/*  645 */     if (s4.equals("00")) {
/*  646 */       s4 = "";
/*  647 */       if ((s3.length() > 0) && 
/*  648 */         (s3.substring(s3.length() - 1, s3.length()).equals("0")))
/*  649 */         s3 = s3.substring(0, s3.length() - 1);
/*      */     }
/*  651 */     if ((s3.length() > 0) && 
/*  652 */       (s3.substring(s3.length() - 1, s3.length()).equals("0")) && 
/*  653 */       (s4.length() > 0) && (s4.substring(0, 1).equals("0")))
/*  654 */       s3 = s3.substring(0, s3.length() - 1);
/*  655 */     if ((s4.length() > 0) && 
/*  656 */       (s4.substring(s4.length() - 1, s4.length()).equals("0")))
/*  657 */       s4 = s4.substring(0, s4.length() - 1);
/*  658 */     if (s3.equals("0")) {
/*  659 */       s3 = "";
/*  660 */       s4 = "0" + s4;
/*      */     }
/*      */ 
/*  663 */     ChnMoney = s0 + s1 + s2 + s3 + "\u5143" + s4;
/*  664 */     if (ChnMoney.substring(0, 1).equals("0")) ChnMoney = ChnMoney.substring(1, 
/*  665 */         ChnMoney.length());
/*  666 */     for (int i = 0; i < ChnMoney.length(); i++) {
/*  667 */       if (ChnMoney.substring(i, i + 1).equals("0")) {
/*  668 */         ChnMoney = ChnMoney.substring(0, i) + "\u96F6" + 
/*  669 */           ChnMoney.substring(i + 1, ChnMoney.length());
/*      */       }
/*      */     }
/*  672 */     if (sDot.substring(1, 2).equals("0")) {
/*  673 */       ChnMoney = ChnMoney + "\u6574";
/*      */     }
/*  675 */     return ChnMoney;
/*      */   }
/*      */ 
/*      */   private static String getDotM(String sIn) {
/*  679 */     String sMoney = "";
/*  680 */     if (!sIn.substring(0, 1).equals("0"))
/*  681 */       sMoney = sMoney + getNum(sIn.substring(0, 1)) + "\u89D2";
/*      */     else
/*  683 */       sMoney = sMoney + "0";
/*  684 */     if (!sIn.substring(1, 2).equals("0"))
/*  685 */       sMoney = sMoney + getNum(sIn.substring(1, 2)) + "\u5206";
/*      */     else {
/*  687 */       sMoney = sMoney + "0";
/*      */     }
/*  689 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String getChnM(String strUnit, String digit) {
/*  693 */     String sMoney = "";
/*  694 */     boolean flag = false;
/*      */ 
/*  696 */     if (strUnit.equals("0000")) {
/*  697 */       sMoney = sMoney + "0";
/*  698 */       return sMoney;
/*      */     }
/*  700 */     if (!strUnit.substring(0, 1).equals("0")) {
/*  701 */       sMoney = sMoney + getNum(strUnit.substring(0, 1)) + "\u4EDF";
/*      */     } else {
/*  703 */       sMoney = sMoney + "0";
/*  704 */       flag = true;
/*      */     }
/*  706 */     if (!strUnit.substring(1, 2).equals("0")) {
/*  707 */       sMoney = sMoney + getNum(strUnit.substring(1, 2)) + "\u4F70";
/*  708 */       flag = false;
/*      */     }
/*  711 */     else if (!flag) {
/*  712 */       sMoney = sMoney + "0";
/*  713 */       flag = true;
/*      */     }
/*      */ 
/*  716 */     if (!strUnit.substring(2, 3).equals("0")) {
/*  717 */       sMoney = sMoney + getNum(strUnit.substring(2, 3)) + "\u62FE";
/*  718 */       flag = false;
/*      */     }
/*  721 */     else if (!flag) {
/*  722 */       sMoney = sMoney + "0";
/*  723 */       flag = true;
/*      */     }
/*      */ 
/*  726 */     if (!strUnit.substring(3, 4).equals("0")) {
/*  727 */       sMoney = sMoney + getNum(strUnit.substring(3, 4));
/*      */     }
/*  729 */     else if (!flag) {
/*  730 */       sMoney = sMoney + "0";
/*  731 */       flag = true;
/*      */     }
/*      */ 
/*  735 */     if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0"))
/*  736 */       sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim() + "0";
/*      */     else
/*  738 */       sMoney = sMoney + digit.trim();
/*  739 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String formatStr(String sIn) {
/*  743 */     int n = sIn.length();
/*  744 */     String sOut = sIn;
/*  745 */     int i = n % 4;
/*      */ 
/*  747 */     for (int k = 1; k <= 12 - n; k++) {
/*  748 */       sOut = "0" + sOut;
/*      */     }
/*  750 */     return sOut;
/*      */   }
/*      */ 
/*      */   private static String getNum(String value) {
/*  754 */     String sNum = "";
/*  755 */     Integer I = new Integer(value);
/*  756 */     int iValue = I.intValue();
/*  757 */     switch (iValue) {
/*      */     case 0:
/*  759 */       sNum = "\u96F6";
/*  760 */       break;
/*      */     case 1:
/*  762 */       sNum = "\u58F9";
/*  763 */       break;
/*      */     case 2:
/*  765 */       sNum = "\u8D30";
/*  766 */       break;
/*      */     case 3:
/*  768 */       sNum = "\u53C1";
/*  769 */       break;
/*      */     case 4:
/*  771 */       sNum = "\u8086";
/*  772 */       break;
/*      */     case 5:
/*  774 */       sNum = "\u4F0D";
/*  775 */       break;
/*      */     case 6:
/*  777 */       sNum = "\u9646";
/*  778 */       break;
/*      */     case 7:
/*  780 */       sNum = "\u67D2";
/*  781 */       break;
/*      */     case 8:
/*  783 */       sNum = "\u634C";
/*  784 */       break;
/*      */     case 9:
/*  786 */       sNum = "\u7396";
/*      */     }
/*      */ 
/*  789 */     return sNum;
/*      */   }
/*      */ 
/*      */   public static String getInt(String Value)
/*      */   {
/*  794 */     if (Value == null)
/*  795 */       return null;
/*  796 */     String result = "";
/*  797 */     boolean mflag = true;
/*  798 */     int m = 0;
/*  799 */     m = Value.lastIndexOf(".");
/*  800 */     if (m == -1) {
/*  801 */       result = Value;
/*      */     }
/*      */     else {
/*  804 */       for (int i = m + 1; i <= Value.length() - 1; i++) {
/*  805 */         if (Value.charAt(i) != '0') {
/*  806 */           result = Value;
/*  807 */           mflag = false;
/*  808 */           break;
/*      */         }
/*      */       }
/*  811 */       if (mflag) {
/*  812 */         result = Value.substring(0, m);
/*      */       }
/*      */     }
/*  815 */     return result;
/*      */   }
/*      */ 
/*      */   public static double getApproximation(double aValue) {
/*  819 */     if (Math.abs(aValue) <= 0.01D) {
/*  820 */       aValue = 0.0D;
/*      */     }
/*  822 */     return aValue;
/*      */   }
/*      */ 
/*      */   public static boolean dateBefore(Date date1, Date date2)
/*      */   {
/*  827 */     Calendar calendar1 = Calendar.getInstance();
/*  828 */     Calendar calendar2 = Calendar.getInstance();
/*  829 */     dateConverttoDetailString(date1);
/*  830 */     dateConverttoDetailString(date2);
/*  831 */     calendar1.setTime(date1);
/*  832 */     calendar2.setTime(date2);
/*      */ 
/*  834 */     return calendar1.before(calendar2);
/*      */   }
/*      */ 
/*      */   public static String dateConverttoDetailString(Date cdate)
/*      */   {
/*  840 */     Calendar tCalendar = Calendar.getInstance();
/*  841 */     tCalendar.setTime(cdate);
/*  842 */     StringBuffer sb = new StringBuffer();
/*  843 */     sb.append(tCalendar.get(1));
/*  844 */     sb.append("-");
/*  845 */     sb.append(format(tCalendar.get(2) + 1, 2));
/*  846 */     sb.append("-");
/*  847 */     sb.append(format(tCalendar.get(5), 2));
/*  848 */     sb.append(" ");
/*  849 */     sb.append(tCalendar.get(9) == 0 ? format(tCalendar.get(10), 2) : format(tCalendar.get(10) + 12, 2));
/*  850 */     sb.append(":");
/*  851 */     sb.append(format(tCalendar.get(12), 2));
/*  852 */     sb.append(":");
/*  853 */     sb.append(format(tCalendar.get(13), 2));
/*  854 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   public static String format(int num, int len)
/*      */   {
/*  859 */     String result = "";
/*  860 */     int i = 1;
/*  861 */     int s = 10;
/*  862 */     while (i <= len)
/*      */     {
/*  864 */       if (num < s)
/*      */       {
/*  866 */         for (int j = 0; j < len - i; j++)
/*  867 */           result = result.concat("0");
/*  868 */         result = result + num;
/*  869 */         return result;
/*      */       }
/*      */ 
/*  873 */       s *= 10;
/*  874 */       i++;
/*      */     }
/*      */ 
/*  878 */     for (int j = 0; j < len - i; j++)
/*  879 */       result = result.concat("-");
/*  880 */     return result;
/*      */   }
/*      */ 
/*      */   public static String[] split(String strMain, String strDelimiters)
/*      */   {
/*  886 */     int intIndex = 0;
/*      */ 
/*  888 */     Vector vResult = new Vector();
/*  889 */     String strSub = "";
/*      */ 
/*  891 */     strMain = strMain.trim();
/*      */ 
/*  893 */     if (strMain.length() <= strDelimiters.length()) {
/*  894 */       System.out.println("\u5206\u9694\u7B26\u4E32\u957F\u5EA6\u5927\u4E8E\u7B49\u4E8E\u4E3B\u5B57\u7B26\u4E32\u957F\u5EA6\uFF0C\u4E0D\u80FD\u8FDB\u884C\u62C6\u5206\uFF01");
/*  895 */       return null;
/*      */     }
/*      */ 
/*  899 */     intIndex = strMain.indexOf(strDelimiters);
/*      */ 
/*  902 */     if (intIndex == -1) {
/*  903 */       String[] arrResult = { 
/*  904 */         strMain };
/*  905 */       return arrResult;
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/*  910 */       strSub = strMain.substring(0, intIndex);
/*  911 */       if (intIndex != 0) {
/*  912 */         vResult.add(strSub);
/*      */       }
/*      */       else
/*      */       {
/*  916 */         vResult.add("");
/*      */       }
/*      */ 
/*  919 */       strMain = strMain.substring(intIndex + strDelimiters.length()).trim();
/*  920 */       intIndex = strMain.indexOf(strDelimiters);
/*      */     }
/*  909 */     while (intIndex != -1);
/*      */ 
/*  923 */     if ((!strMain.equals("")) && (strMain != null)) {
/*  924 */       vResult.add(strMain);
/*      */     }
/*      */ 
/*  927 */     String[] arrResult = new String[vResult.size()];
/*  928 */     for (int i = 0; i < vResult.size(); i++) {
/*  929 */       arrResult[i] = ((String)vResult.get(i));
/*      */     }
/*      */ 
/*  932 */     return arrResult;
/*      */   }
/*      */ 
/*      */   public static double setPrecision(float value, String precision) {
/*  936 */     return Float.parseFloat(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static double setPrecision(double value, String precision) {
/*  940 */     return Double.parseDouble(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static SchemaSet copySchemaSet(SchemaSet srcSet) {
/*  944 */     Reflections reflect = new Reflections();
/*      */     try {
/*  946 */       if ((srcSet != null) && (srcSet.size() > 0)) {
/*  947 */         if (srcSet.getObj(1) == null) return null;
/*  948 */         Class cls = srcSet.getClass();
/*  949 */         Schema schema = (Schema)srcSet.getObj(1).getClass().newInstance();
/*  950 */         SchemaSet obj = (SchemaSet)cls.newInstance();
/*  951 */         obj.add(schema);
/*  952 */         reflect.transFields(obj, srcSet);
/*  953 */         return obj;
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/*  957 */       ex.printStackTrace();
/*      */     }
/*  959 */     return null;
/*      */   }
/*      */ 
/*      */   public static boolean exchangeSchema(Schema source, Schema object) {
/*      */     try {
/*  964 */       Reflections tReflections = new Reflections();
/*  965 */       tReflections.transFields(object, source);
/*      */ 
/*  967 */       Method m = object.getClass().getMethod("getDB", null);
/*  968 */       Schema schemaDB = (Schema)m.invoke(object, null);
/*      */ 
/*  970 */       m = schemaDB.getClass().getMethod("getInfo", null);
/*  971 */       m.invoke(schemaDB, null);
/*  972 */       m = schemaDB.getClass().getMethod("getSchema", null);
/*  973 */       object = (Schema)m.invoke(schemaDB, null);
/*      */ 
/*  976 */       m = object.getClass().getMethod("getSchema", null);
/*  977 */       Schema tSchema = (Schema)m.invoke(object, null);
/*      */ 
/*  980 */       tReflections.transFields(object, source);
/*  981 */       tReflections.transFields(source, tSchema);
/*      */ 
/*  983 */       return true;
/*      */     }
/*      */     catch (Exception ex) {
/*  986 */       ex.printStackTrace();
/*  987 */     }return false;
/*      */   }
/*      */ 
/*      */   public static Vector formUpdateSql(String[] tables, String condition, String wherepart) {
/*  991 */     Vector sqlVec = new Vector();
/*  992 */     for (int i = 0; i < tables.length; i++) {
/*  993 */       sqlVec.add("update " + tables[i] + " set " + condition + " where " + wherepart);
/*      */     }
/*  995 */     return sqlVec;
/*      */   }
/*      */ 
/*      */   public static String DeleteZero(String sIn) {
/*  999 */     int n = sIn.length();
/* 1000 */     String sOut = sIn;
/* 1001 */     int k = 0;
/*      */ 
/* 1003 */     while ((sOut.substring(0, 1).equals("0")) && (n > 1)) {
/* 1004 */       sOut = sOut.substring(1, n);
/* 1005 */       n = sOut.length();
/* 1006 */       System.out.println(sOut);
/*      */     }
/*      */ 
/* 1009 */     if (sOut.equals("0")) {
/* 1010 */       return "";
/*      */     }
/* 1012 */     return sOut;
/*      */   }
/*      */ 
/*      */   public static String changForJavaScript(String s) {
/* 1016 */     char[] arr = s.toCharArray();
/* 1017 */     s = "";
/* 1018 */     for (int i = 0; i < arr.length; i++) {
/* 1019 */       if ((arr[i] == '"') || (arr[i] == '\'') || (arr[i] == '\n')) {
/* 1020 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1023 */       s = s + arr[i];
/*      */     }
/*      */ 
/* 1026 */     return s;
/*      */   }
/*      */ 
/*      */   public static String changForHTML(String s) {
/* 1030 */     char[] arr = s.toCharArray();
/* 1031 */     s = "";
/*      */ 
/* 1033 */     for (int i = 0; i < arr.length; i++) {
/* 1034 */       if ((arr[i] == '"') || (arr[i] == '\'')) {
/* 1035 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1038 */       if (arr[i] == '\n') {
/* 1039 */         s = s + "<br>";
/*      */       }
/*      */       else
/*      */       {
/* 1043 */         s = s + arr[i];
/*      */       }
/*      */     }
/* 1046 */     return s;
/*      */   }
/*      */ 
/*      */   public static String getClassFileName(Object o) {
/* 1050 */     String fileName = o.getClass().getName();
/* 1051 */     fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
/* 1052 */     return fileName;
/*      */   }
/*      */ 
/*      */   public static void out(Object o, String s) {
/* 1056 */     System.out.println(getClassFileName(o) + " : " + s);
/*      */   }
/*      */ 
/*      */   public static void main(String[] args) {
/* 1060 */     String DSumMoney = "";
/* 1061 */     double SumGetMoney = 0.21D;
/* 1062 */     System.out.println("==> test_1");
/* 1063 */     System.out.println("==> test_1_1 : " + SumGetMoney);
/* 1064 */     DSumMoney = getChnMoney(SumGetMoney);
/* 1065 */     System.out.println("==> test_2" + DSumMoney);
/*      */   }
/*      */ 
/*      */   public static int calPolYear(String cstartDate, String cendDate)
/*      */   {
/* 1155 */     FDate fDate = new FDate();
/* 1156 */     Date startDate = fDate.getDate(cstartDate);
/* 1157 */     Date endDate = fDate.getDate(cendDate);
/* 1158 */     if (fDate.mErrors.needDealError()) {
/* 1159 */       return 0;
/*      */     }
/* 1161 */     int interval = 0;
/*      */ 
/* 1163 */     GregorianCalendar sCalendar = new GregorianCalendar();
/* 1164 */     sCalendar.setTime(startDate);
/* 1165 */     int sYears = sCalendar.get(1);
/* 1166 */     int sMonths = sCalendar.get(2);
/* 1167 */     int sDays = sCalendar.get(5);
/* 1168 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/* 1170 */     GregorianCalendar eCalendar = new GregorianCalendar();
/* 1171 */     eCalendar.setTime(endDate);
/* 1172 */     int eYears = eCalendar.get(1);
/* 1173 */     int eMonths = eCalendar.get(2);
/* 1174 */     int eDays = eCalendar.get(5);
/* 1175 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/* 1177 */     interval = eYears - sYears;
/* 1178 */     interval *= 365;
/* 1179 */     interval = eDaysOfYear - sDaysOfYear + interval;
/*      */ 
/* 1181 */     int n = 0;
/* 1182 */     eYears--;
/* 1183 */     if (eYears > sYears) {
/* 1184 */       int i = sYears % 4;
/* 1185 */       if (i == 0) {
/* 1186 */         sYears++;
/* 1187 */         n++;
/*      */       }
/* 1189 */       int j = eYears % 4;
/* 1190 */       if (j == 0) {
/* 1191 */         eYears--;
/* 1192 */         n++;
/*      */       }
/* 1194 */       n += (eYears - sYears) / 4;
/*      */     }
/* 1196 */     if (eYears == sYears) {
/* 1197 */       int i = sYears % 4;
/* 1198 */       if (i == 0)
/* 1199 */         n++;
/*      */     }
/* 1201 */     interval += n;
/*      */ 
/* 1203 */     int x = 365;
/* 1204 */     int PolYear = 1;
/* 1205 */     while (x < interval) {
/* 1206 */       x += 365;
/* 1207 */       PolYear++;
/*      */     }
/*      */ 
/* 1210 */     return PolYear;
/*      */   }
/*      */ 
/*      */   public static String getBirthdayFromId(String IdNo)
/*      */   {
/* 1215 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1216 */     String birthday = "";
/* 1217 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18))
/*      */     {
/* 1219 */       return "";
/*      */     }
/* 1221 */     if (tIdNo.length() == 18)
/*      */     {
/* 1223 */       birthday = tIdNo.substring(6, 14);
/* 1224 */       birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + "-" + birthday.substring(6);
/*      */     }
/* 1226 */     if (tIdNo.length() == 15)
/*      */     {
/* 1228 */       birthday = tIdNo.substring(6, 12);
/* 1229 */       birthday = birthday.substring(0, 2) + "-" + birthday.substring(2, 4) + 
/* 1230 */         "-" + birthday.substring(4);
/* 1231 */       birthday = "19" + birthday;
/*      */     }
/* 1233 */     return birthday;
/*      */   }
/*      */ 
/*      */   public static String getSexFromId(String IdNo)
/*      */   {
/* 1239 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1240 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18))
/*      */     {
/* 1242 */       return "";
/*      */     }
/* 1244 */     String sex = "";
/* 1245 */     if (tIdNo.length() == 15)
/*      */     {
/* 1247 */       sex = tIdNo.substring(14, 15);
/*      */     }
/*      */     else
/*      */     {
/* 1251 */       sex = tIdNo.substring(16, 17);
/*      */     }
/*      */     try
/*      */     {
/* 1255 */       int iSex = Integer.parseInt(sex);
/* 1256 */       iSex %= 2;
/* 1257 */       if (iSex == 0) return "1";
/* 1258 */       if (iSex == 1) return "0";
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1262 */       return "";
/*      */     }
/*      */ 
/* 1265 */     return "";
/*      */   }
/*      */ 
/*      */   public static String getRiskNameOrSubflag(String RiskCode, String type)
/*      */   {
/* 1271 */     if ("getRiskName".equals(type)) {
/* 1272 */       if (riskDataHashMap == null)
/*      */       {
/* 1274 */         ExeSQL query = new ExeSQL();
/* 1275 */         SSRS riskSSRS = null;
/* 1276 */         String risksql = "SELECT riskcode,riskshortname FROM lmrisk WHERE 1 = 1";
/* 1277 */         riskSSRS = query.execSQL(risksql);
/*      */ 
/* 1279 */         if (riskSSRS.MaxRow > 0) {
/* 1280 */           riskDataHashMap = new HashMap();
/* 1281 */           for (int i = 1; i <= riskSSRS.MaxRow; i++) {
/* 1282 */             riskDataHashMap.put(riskSSRS.GetText(i, 1), riskSSRS.GetText(i, 2));
/*      */           }
/*      */         }
/* 1285 */         return (String)riskDataHashMap.get(RiskCode);
/*      */       }
/* 1287 */       return (String)riskDataHashMap.get(RiskCode);
/*      */     }
/*      */ 
/* 1291 */     if ("getRiskFlag".equals(type)) {
/* 1292 */       if (riskFlagDataHashMap == null) {
/* 1293 */         ExeSQL query = new ExeSQL();
/* 1294 */         SSRS riskSSRS = null;
/* 1295 */         String risksql = "SELECT riskcode,SubriskFlag FROM lmriskapp WHERE 1 = 1";
/* 1296 */         riskSSRS = query.execSQL(risksql);
/*      */ 
/* 1298 */         if (riskSSRS.MaxRow > 0) {
/* 1299 */           riskFlagDataHashMap = new HashMap();
/* 1300 */           for (int i = 1; i <= riskSSRS.MaxRow; i++)
/*      */           {
/* 1302 */             String SubriskFlag = riskSSRS.GetText(i, 2);
/* 1303 */             if ("M".equals(SubriskFlag))
/* 1304 */               SubriskFlag = "\u4E3B\u7EA6";
/*      */             else {
/* 1306 */               SubriskFlag = "\u9644\u7EA6";
/*      */             }
/* 1308 */             riskFlagDataHashMap.put(riskSSRS.GetText(i, 1), SubriskFlag);
/*      */           }
/*      */         }
/* 1311 */         return (String)riskFlagDataHashMap.get(RiskCode);
/*      */       }
/* 1313 */       return (String)riskFlagDataHashMap.get(RiskCode);
/*      */     }
/*      */ 
/* 1318 */     return "";
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.PubFun
 * JD-Core Version:    0.6.0
 */