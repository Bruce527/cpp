/*      */ package com.sinosoft.banklns.utility;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.sug.lis.pubfun.GlobalInput;
/*      */ import java.io.File;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.reflect.Method;
/*      */ import java.text.DateFormat;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.TimeZone;
/*      */ import java.util.Vector;
/*      */ 
/*      */ public class PubFun
/*      */ {
/*      */   private static final int MAX_YEAR = 9999;
/*      */   private static final int MIN_YEAR = 1800;
/*      */   private static final int MAX_MONTH = 12;
/*      */   private static final int MIN_MONTH = 1;
/*      */   private static final int MAX_DAY = 31;
/*      */   private static final int MIN_DAY = 1;
/*      */   private static final String DATE_LIST = "0123456789-";
/*      */ 
/*      */   public static Object getClassForName(String sPackage, String sClass)
/*      */   {
/*      */     Object obj;
/*      */     try
/*      */     {
/*   50 */       obj = Class.forName(sPackage + "." + sClass).newInstance();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */       Object obj;
/*   53 */       obj = null;
/*   54 */       ex.printStackTrace();
/*      */     }
/*   56 */     return obj;
/*      */   }
/*      */ 
/*      */   public static Date calDate(Date baseDate, int interval, String unit, Date compareDate)
/*      */   {
/*   62 */     Date returnDate = null;
/*      */ 
/*   64 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*   65 */     mCalendar.setTime(baseDate);
/*   66 */     if (unit.equals("Y")) {
/*   67 */       mCalendar.add(1, interval);
/*      */     }
/*   69 */     if (unit.equals("M")) {
/*   70 */       mCalendar.add(2, interval);
/*      */     }
/*   72 */     if (unit.equals("D")) {
/*   73 */       mCalendar.add(5, interval);
/*      */     }
/*      */ 
/*   76 */     if (compareDate != null) {
/*   77 */       GregorianCalendar cCalendar = new GregorianCalendar();
/*   78 */       cCalendar.setTime(compareDate);
/*      */ 
/*   80 */       int mYears = mCalendar.get(1);
/*   81 */       int mMonths = mCalendar.get(2);
/*   82 */       int cMonths = cCalendar.get(2);
/*   83 */       int cDays = cCalendar.get(5);
/*      */ 
/*   85 */       if (unit.equals("Y")) {
/*   86 */         cCalendar.set(mYears, cMonths, cDays);
/*   87 */         if (cCalendar.before(mCalendar)) {
/*   88 */           mCalendar.set(mYears + 1, cMonths, cDays);
/*   89 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/*   92 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*   95 */       if (unit.equals("M")) {
/*   96 */         cCalendar.set(mYears, mMonths, cDays);
/*   97 */         if (cCalendar.before(mCalendar)) {
/*   98 */           mCalendar.set(mYears, mMonths + 1, cDays);
/*   99 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/*  102 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/*  105 */       if (unit.equals("D"))
/*  106 */         returnDate = mCalendar.getTime();
/*      */     }
/*      */     else
/*      */     {
/*  110 */       returnDate = mCalendar.getTime();
/*      */     }
/*      */ 
/*  113 */     return returnDate;
/*      */   }
/*      */ 
/*      */   public static String calDate(String baseDate, int interval, String unit, String compareDate)
/*      */   {
/*      */     try
/*      */     {
/*  120 */       FDate tFDate = new FDate();
/*  121 */       Date bDate = tFDate.getDate(baseDate);
/*  122 */       Date cDate = tFDate.getDate(compareDate);
/*  123 */       return tFDate.getString(calDate(bDate, interval, unit, cDate));
/*      */     }
/*      */     catch (Exception ex) {
/*  126 */       ex.printStackTrace();
/*  127 */     }return null;
/*      */   }
/*      */ 
/*      */   public static int calInterval(Date startDate, Date endDate, String unit)
/*      */   {
/*  133 */     int interval = 0;
/*      */ 
/*  135 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  136 */     sCalendar.setTime(startDate);
/*  137 */     int sYears = sCalendar.get(1);
/*  138 */     int sMonths = sCalendar.get(2);
/*  139 */     int sDays = sCalendar.get(5);
/*  140 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  142 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  143 */     eCalendar.setTime(endDate);
/*  144 */     int eYears = eCalendar.get(1);
/*  145 */     int eMonths = eCalendar.get(2);
/*  146 */     int eDays = eCalendar.get(5);
/*  147 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  149 */     if (unit.equals("Y")) {
/*  150 */       interval = eYears - sYears;
/*  151 */       if (eMonths < sMonths) {
/*  152 */         interval--;
/*      */       }
/*  155 */       else if ((eMonths == sMonths) && (eDays < sDays)) {
/*  156 */         interval--;
/*  157 */         if (eMonths == 1)
/*      */         {
/*  159 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  162 */             if (eDays == 28)
/*      */             {
/*  164 */               interval++;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  171 */     if (unit.equals("M")) {
/*  172 */       interval = eYears - sYears;
/*  173 */       interval *= 12;
/*  174 */       interval += eMonths - sMonths;
/*  175 */       if (eDays < sDays) {
/*  176 */         interval--;
/*      */ 
/*  179 */         int maxDate = eCalendar.getActualMaximum(5);
/*  180 */         if (eDays == maxDate) {
/*  181 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  185 */     if (unit.equals("D")) {
/*  186 */       interval = eYears - sYears;
/*  187 */       interval *= 365;
/*  188 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  191 */       int n = 0;
/*  192 */       eYears--;
/*  193 */       if (eYears > sYears) {
/*  194 */         int i = sYears % 4;
/*  195 */         if (i == 0) {
/*  196 */           sYears++;
/*  197 */           n++;
/*      */         }
/*  199 */         int j = eYears % 4;
/*  200 */         if (j == 0) {
/*  201 */           eYears--;
/*  202 */           n++;
/*      */         }
/*  204 */         n += (eYears - sYears) / 4;
/*      */       }
/*  206 */       if (eYears == sYears) {
/*  207 */         int i = sYears % 4;
/*  208 */         if (i == 0) {
/*  209 */           n++;
/*      */         }
/*      */       }
/*  212 */       interval += n;
/*      */     }
/*  214 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval(String cstartDate, String cendDate, String unit)
/*      */   {
/*  220 */     FDate fDate = new FDate();
/*  221 */     Date startDate = fDate.getDate(cstartDate);
/*  222 */     Date endDate = fDate.getDate(cendDate);
/*  223 */     if (fDate.mErrors.needDealError()) {
/*  224 */       return 0;
/*      */     }
/*      */ 
/*  227 */     int interval = 0;
/*      */ 
/*  229 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  230 */     sCalendar.setTime(startDate);
/*  231 */     int sYears = sCalendar.get(1);
/*  232 */     int sMonths = sCalendar.get(2);
/*  233 */     int sDays = sCalendar.get(5);
/*  234 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  236 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  237 */     eCalendar.setTime(endDate);
/*  238 */     int eYears = eCalendar.get(1);
/*  239 */     int eMonths = eCalendar.get(2);
/*  240 */     int eDays = eCalendar.get(5);
/*  241 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  243 */     if (StrTool.cTrim(unit).equals("Y")) {
/*  244 */       interval = eYears - sYears;
/*      */ 
/*  246 */       if (eMonths < sMonths) {
/*  247 */         interval--;
/*      */       }
/*  250 */       else if ((eMonths == sMonths) && (eDays < sDays)) {
/*  251 */         interval--;
/*  252 */         if (eMonths == 1)
/*      */         {
/*  254 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  257 */             if (eDays == 28)
/*      */             {
/*  259 */               interval++;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  266 */     if (StrTool.cTrim(unit).equals("M")) {
/*  267 */       interval = eYears - sYears;
/*  268 */       interval *= 12;
/*  269 */       interval += eMonths - sMonths;
/*      */ 
/*  271 */       if (eDays < sDays) {
/*  272 */         interval--;
/*      */ 
/*  275 */         int maxDate = eCalendar.getActualMaximum(5);
/*  276 */         if (eDays == maxDate) {
/*  277 */           interval++;
/*      */         }
/*      */       }
/*      */     }
/*  281 */     if (StrTool.cTrim(unit).equals("D")) {
/*  282 */       interval = eYears - sYears;
/*  283 */       interval *= 365;
/*  284 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  287 */       int n = 0;
/*  288 */       eYears--;
/*  289 */       if (eYears > sYears) {
/*  290 */         int i = sYears % 4;
/*  291 */         if (i == 0) {
/*  292 */           sYears++;
/*  293 */           n++;
/*      */         }
/*  295 */         int j = eYears % 4;
/*  296 */         if (j == 0) {
/*  297 */           eYears--;
/*  298 */           n++;
/*      */         }
/*  300 */         n += (eYears - sYears) / 4;
/*      */       }
/*  302 */       if (eYears == sYears) {
/*  303 */         int i = sYears % 4;
/*  304 */         if (i == 0) {
/*  305 */           n++;
/*      */         }
/*      */       }
/*  308 */       interval += n;
/*      */     }
/*  310 */     return interval;
/*      */   }
/*      */ 
/*      */   public static int calInterval2(String cstartDate, String cendDate, String unit)
/*      */   {
/*  316 */     FDate fDate = new FDate();
/*  317 */     Date startDate = fDate.getDate(cstartDate);
/*  318 */     Date endDate = fDate.getDate(cendDate);
/*  319 */     if (fDate.mErrors.needDealError()) {
/*  320 */       return 0;
/*      */     }
/*      */ 
/*  323 */     int interval = 0;
/*      */ 
/*  325 */     GregorianCalendar sCalendar = new GregorianCalendar();
/*  326 */     sCalendar.setTime(startDate);
/*  327 */     int sYears = sCalendar.get(1);
/*  328 */     int sMonths = sCalendar.get(2);
/*  329 */     int sDays = sCalendar.get(5);
/*  330 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/*  332 */     GregorianCalendar eCalendar = new GregorianCalendar();
/*  333 */     eCalendar.setTime(endDate);
/*  334 */     int eYears = eCalendar.get(1);
/*  335 */     int eMonths = eCalendar.get(2);
/*  336 */     int eDays = eCalendar.get(5);
/*  337 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/*  339 */     if (StrTool.cTrim(unit).equals("Y")) {
/*  340 */       interval = eYears - sYears;
/*      */ 
/*  342 */       if (eMonths > sMonths) {
/*  343 */         interval++;
/*      */       }
/*  346 */       else if ((eMonths == sMonths) && (eDays > sDays)) {
/*  347 */         interval++;
/*  348 */         if (eMonths == 1)
/*      */         {
/*  350 */           if ((sYears % 4 == 0) && (eYears % 4 != 0))
/*      */           {
/*  353 */             if (eDays == 28)
/*      */             {
/*  355 */               interval--;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  362 */     if (StrTool.cTrim(unit).equals("M")) {
/*  363 */       interval = eYears - sYears;
/*  364 */       interval *= 12;
/*  365 */       interval += eMonths - sMonths;
/*      */ 
/*  367 */       if (eDays > sDays) {
/*  368 */         interval++;
/*      */ 
/*  371 */         int maxDate = eCalendar.getActualMaximum(5);
/*  372 */         if (eDays == maxDate) {
/*  373 */           interval--;
/*      */         }
/*      */       }
/*      */     }
/*  377 */     if (StrTool.cTrim(unit).equals("D")) {
/*  378 */       interval = eYears - sYears;
/*  379 */       interval *= 365;
/*  380 */       interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/*  383 */       int n = 0;
/*  384 */       eYears--;
/*  385 */       if (eYears > sYears) {
/*  386 */         int i = sYears % 4;
/*  387 */         if (i == 0) {
/*  388 */           sYears++;
/*  389 */           n++;
/*      */         }
/*  391 */         int j = eYears % 4;
/*  392 */         if (j == 0) {
/*  393 */           eYears--;
/*  394 */           n++;
/*      */         }
/*  396 */         n += (eYears - sYears) / 4;
/*      */       }
/*  398 */       if (eYears == sYears) {
/*  399 */         int i = sYears % 4;
/*  400 */         if (i == 0) {
/*  401 */           n++;
/*      */         }
/*      */       }
/*  404 */       interval += n;
/*      */     }
/*  406 */     return interval;
/*      */   }
/*      */ 
/*      */   public static String[] calFLDate(String tDate)
/*      */   {
/*  411 */     String[] MonDate = new String[2];
/*  412 */     FDate fDate = new FDate();
/*  413 */     Date CurDate = fDate.getDate(tDate);
/*  414 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*  415 */     mCalendar.setTime(CurDate);
/*  416 */     int Years = mCalendar.get(1);
/*  417 */     int Months = mCalendar.get(2);
/*  418 */     int FirstDay = mCalendar.getActualMinimum(5);
/*  419 */     int LastDay = mCalendar.getActualMaximum(5);
/*  420 */     mCalendar.set(Years, Months, FirstDay);
/*  421 */     MonDate[0] = fDate.getString(mCalendar.getTime());
/*  422 */     mCalendar.set(Years, Months, LastDay);
/*  423 */     MonDate[1] = fDate.getString(mCalendar.getTime());
/*  424 */     return MonDate;
/*      */   }
/*      */ 
/*      */   public static JdbcUrl getDefaultUrl() {
/*  428 */     JdbcUrl tUrl = new JdbcUrl();
/*  429 */     return tUrl;
/*      */   }
/*      */ 
/*      */   public static String RCh(String sourString, String cChar, int cLen)
/*      */   {
/*  434 */     int tLen = sourString.length();
/*      */ 
/*  436 */     StringBuffer tReturn = new StringBuffer();
/*  437 */     if (tLen >= cLen) {
/*  438 */       return sourString;
/*      */     }
/*  440 */     int iMax = cLen - tLen;
/*  441 */     tReturn.append(sourString.trim());
/*  442 */     for (int i = 0; i < iMax; i++) {
/*  443 */       tReturn.append(cChar);
/*      */     }
/*  445 */     return tReturn.toString();
/*      */   }
/*      */ 
/*      */   public static String LCh(String sourString, String cChar, int cLen)
/*      */   {
/*  450 */     int tLen = sourString.length();
/*      */ 
/*  452 */     StringBuffer tReturn = new StringBuffer();
/*  453 */     if (tLen >= cLen) {
/*  454 */       return sourString;
/*      */     }
/*  456 */     int iMax = cLen - tLen;
/*  457 */     for (int i = 0; i < iMax; i++) {
/*  458 */       tReturn.append(cChar);
/*      */     }
/*  460 */     tReturn.append(sourString.trim());
/*  461 */     return tReturn.toString();
/*      */   }
/*      */ 
/*      */   public static String getLaterDate(String date1, String date2)
/*      */   {
/*      */     try {
/*  467 */       date1 = StrTool.cTrim(date1);
/*  468 */       date2 = StrTool.cTrim(date2);
/*  469 */       if (date1.equals("")) {
/*  470 */         return date2;
/*      */       }
/*  472 */       if (date2.equals("")) {
/*  473 */         return date1;
/*      */       }
/*  475 */       FDate fd = new FDate();
/*  476 */       Date d1 = fd.getDate(date1);
/*  477 */       Date d2 = fd.getDate(date2);
/*  478 */       if (d1.after(d2)) {
/*  479 */         return date1;
/*      */       }
/*  481 */       return date2;
/*      */     }
/*      */     catch (Exception e) {
/*  484 */       e.printStackTrace();
/*  485 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getBeforeDate(String date1, String date2)
/*      */   {
/*      */     try
/*      */     {
/*  493 */       date1 = StrTool.cTrim(date1);
/*  494 */       date2 = StrTool.cTrim(date2);
/*  495 */       if (date1.equals("")) {
/*  496 */         return date2;
/*      */       }
/*  498 */       if (date2.equals("")) {
/*  499 */         return date1;
/*      */       }
/*  501 */       FDate fd = new FDate();
/*  502 */       Date d1 = fd.getDate(date1);
/*  503 */       Date d2 = fd.getDate(date2);
/*  504 */       if (d1.before(d2)) {
/*  505 */         return date1;
/*      */       }
/*  507 */       return date2;
/*      */     }
/*      */     catch (Exception e) {
/*  510 */       e.printStackTrace();
/*  511 */     }return "";
/*      */   }
/*      */ 
/*      */   public static String getCurrentDate()
/*      */   {
/*  519 */     TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
/*      */ 
/*  521 */     String pattern = "yyyy-MM-dd";
/*      */ 
/*  523 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*      */ 
/*  525 */     df.setTimeZone(timeZone);
/*      */ 
/*  527 */     Date today = new Date();
/*      */ 
/*  529 */     String tString = df.format(today);
/*      */ 
/*  531 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getCurrentTime()
/*      */   {
/*  538 */     TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
/*      */ 
/*  540 */     String pattern = "HH:mm:ss";
/*      */ 
/*  542 */     SimpleDateFormat df = new SimpleDateFormat(pattern);
/*      */ 
/*  544 */     df.setTimeZone(timeZone);
/*      */ 
/*  546 */     Date today = new Date();
/*      */ 
/*  548 */     String tString = df.format(today);
/*      */ 
/*  550 */     return tString;
/*      */   }
/*      */ 
/*      */   public static String getOldDate(int month)
/*      */   {
/*  556 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*  557 */     Calendar now = Calendar.getInstance();
/*  558 */     now.add(2, -month);
/*  559 */     String newdate = formatter.format(now.getTime());
/*  560 */     return newdate;
/*      */   }
/*      */ 
/*      */   public static String getOldYear(int year)
/*      */   {
/*  565 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*  566 */     Calendar now = Calendar.getInstance();
/*  567 */     now.add(6, -(365 * year));
/*  568 */     String newdate = formatter.format(now.getTime());
/*  569 */     return newdate;
/*      */   }
/*      */ 
/*      */   public static String getOldMonth(int year, int month, int day, int mark)
/*      */   {
/*  574 */     GregorianCalendar worldTour = new GregorianCalendar(year, month, day);
/*  575 */     worldTour.add(2, -(mark + 1));
/*  576 */     Date d = worldTour.getTime();
/*  577 */     DateFormat df = DateFormat.getDateInstance();
/*  578 */     String s = df.format(d);
/*  579 */     return s;
/*      */   }
/*      */ 
/*      */   public static boolean canIDo(GlobalInput cGlobalInput, String RunScript, String pagesign)
/*      */   {
/*  585 */     String Operator = cGlobalInput.Operator;
/*      */ 
/*  589 */     String sqlStr = "select count(*) from LDMenu ";
/*  590 */     sqlStr = sqlStr + 
/*  591 */       "where RunScript like '%" + RunScript + "%' ";
/*      */ 
/*  593 */     if (pagesign.equals("page")) {
/*  594 */       sqlStr = sqlStr + 
/*  595 */         "and parentnodecode in ( select distinct NodeCode from LDMenuGrpToMenu ";
/*      */     }
/*  597 */     if (pagesign.equals("menu")) {
/*  598 */       sqlStr = sqlStr + 
/*  599 */         "and NodeCode in ( select distinct NodeCode from LDMenuGrpToMenu ";
/*      */     }
/*  601 */     sqlStr = sqlStr + 
/*  602 */       "where MenuGrpCode in ( select distinct MenuGrpCode from LDMenuGrp ";
/*  603 */     sqlStr = sqlStr + 
/*  604 */       "where MenuGrpCode in (select distinct MenuGrpCode from LDUserToMenuGrp where UserCode = '";
/*  605 */     sqlStr = sqlStr + Operator;
/*  606 */     sqlStr = sqlStr + "') ) ) ";
/*  607 */     ExeSQL tExeSQL = new ExeSQL();
/*  608 */     SSRS tSSRS = tExeSQL.execSQL(sqlStr);
/*  609 */     if (tSSRS != null) {
/*  610 */       String[] tt = tSSRS.getRowData(1);
/*  611 */       if (tt[0].equals("0")) {
/*  612 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  616 */     return true;
/*      */   }
/*      */ 
/*      */   public static String getNoLimit(String comCode)
/*      */   {
/*  621 */     comCode = comCode.trim();
/*  622 */     int tLen = comCode.length();
/*  623 */     if (tLen > 6) {
/*  624 */       comCode = comCode.substring(0, 6);
/*      */     }
/*  626 */     if (tLen < 6) {
/*  627 */       comCode = RCh(comCode, "0", 6);
/*      */     }
/*  629 */     StringBuffer tString = new StringBuffer();
/*  630 */     tString.append(comCode);
/*  631 */     tString.append(getCurrentDate().substring(0, 4));
/*      */ 
/*  633 */     return tString.toString();
/*      */   }
/*      */ 
/*      */   public static String getPiccNoLimit(String comCode)
/*      */   {
/*  638 */     comCode = comCode.trim();
/*      */ 
/*  640 */     int tLen = comCode.length();
/*  641 */     if (tLen == 8) {
/*  642 */       comCode = comCode.substring(2, 6);
/*      */     }
/*  644 */     if (tLen == 4)
/*      */     {
/*  646 */       comCode = comCode.substring(2, 4);
/*      */     }
/*      */ 
/*  649 */     StringBuffer tString = new StringBuffer();
/*      */ 
/*  652 */     tString.append(comCode);
/*  653 */     if (tLen == 4) {
/*  654 */       tString.append("00");
/*      */     }
/*  656 */     tString.append(getCurrentDate().substring(2, 4));
/*  657 */     tString.append(getCurrentDate().substring(5, 7));
/*  658 */     tString.append(getCurrentDate().substring(8, 10));
/*      */ 
/*  660 */     return tString.toString();
/*      */   }
/*      */ 
/*      */   public static String getStr(String c_Str, int c_i, String c_Split)
/*      */   {
/*  665 */     String t_Str1 = "";
/*  666 */     String t_Str2 = "";
/*  667 */     String t_strOld = "";
/*  668 */     int i = 0;
/*  669 */     int i_Start = 0;
/*      */ 
/*  671 */     t_Str1 = c_Str;
/*  672 */     t_Str2 = c_Split;
/*  673 */     i = 0;
/*      */     try {
/*  675 */       while (i < c_i) {
/*  676 */         i_Start = t_Str1.indexOf(t_Str2, 0);
/*  677 */         if (i_Start >= 0) {
/*  678 */           i++;
/*  679 */           t_strOld = t_Str1;
/*  680 */           t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), t_Str1.length());
/*      */         }
/*      */         else {
/*  683 */           if (i == c_i - 1) break;
/*  684 */           t_Str1 = "";
/*      */ 
/*  686 */           break;
/*      */         }
/*      */       }
/*      */ 
/*  690 */       if (i_Start >= 0)
/*  691 */         t_Str1 = t_strOld.substring(0, i_Start);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  695 */       t_Str1 = "";
/*      */     }
/*  697 */     return t_Str1;
/*      */   }
/*      */ 
/*      */   public static String getChnMoney(double money)
/*      */   {
/*  702 */     String ChnMoney = "";
/*  703 */     String s0 = "";
/*      */ 
/*  707 */     if (money == 0.0D) {
/*  708 */       ChnMoney = "\u951F\u65A4\u62F7\u5143\u951F\u65A4\u62F7";
/*  709 */       return ChnMoney;
/*      */     }
/*      */ 
/*  712 */     if (money < 0.0D) {
/*  713 */       s0 = "\u951F\u65A4\u62F7";
/*  714 */       money *= -1.0D;
/*      */     }
/*      */ 
/*  717 */     String sMoney = new DecimalFormat("0").format(money * 100.0D);
/*      */ 
/*  719 */     int nLen = sMoney.length();
/*      */     String sDot;
/*      */     String sInteger;
/*      */     String sDot;
/*  722 */     if (nLen < 2)
/*      */     {
/*  724 */       String sInteger = "";
/*      */       String sDot;
/*  725 */       if (nLen == 1) {
/*  726 */         sDot = "0" + sMoney.substring(nLen - 1, nLen);
/*      */       }
/*      */       else
/*  729 */         sDot = "0";
/*      */     }
/*      */     else
/*      */     {
/*  733 */       sInteger = sMoney.substring(0, nLen - 2);
/*  734 */       sDot = sMoney.substring(nLen - 2, nLen);
/*      */     }
/*      */ 
/*  737 */     String sFormatStr = formatStr(sInteger);
/*      */ 
/*  739 */     String s1 = getChnM(sFormatStr.substring(0, 4), "\u951F\u65A4\u62F7");
/*      */ 
/*  741 */     String s2 = getChnM(sFormatStr.substring(4, 8), "\u951F\u65A4\u62F7");
/*      */ 
/*  743 */     String s3 = getChnM(sFormatStr.substring(8, 12), "");
/*      */ 
/*  745 */     String s4 = getDotM(sDot);
/*      */ 
/*  747 */     if ((s1.length() > 0) && (s1.substring(0, 1).equals("0"))) {
/*  748 */       s1 = s1.substring(1, 
/*  749 */         s1.length());
/*      */     }
/*  751 */     if ((s1.length() > 0) && 
/*  752 */       (s1.substring(s1.length() - 1, s1.length()).equals("0")) && 
/*  753 */       (s2.length() > 0) && (s2.substring(0, 1).equals("0"))) {
/*  754 */       s1 = s1.substring(0, s1.length() - 1);
/*      */     }
/*  756 */     if ((s2.length() > 0) && 
/*  757 */       (s2.substring(s2.length() - 1, s2.length()).equals("0")) && 
/*  758 */       (s3.length() > 0) && (s3.substring(0, 1).equals("0"))) {
/*  759 */       s2 = s2.substring(0, s2.length() - 1);
/*      */     }
/*  761 */     if (s4.equals("00")) {
/*  762 */       s4 = "";
/*  763 */       if ((s3.length() > 0) && 
/*  764 */         (s3.substring(s3.length() - 1, s3.length()).equals("0"))) {
/*  765 */         s3 = s3.substring(0, s3.length() - 1);
/*      */       }
/*      */     }
/*  768 */     if ((s3.length() > 0) && 
/*  769 */       (s3.substring(s3.length() - 1, s3.length()).equals("0")) && 
/*  770 */       (s4.length() > 0) && (s4.substring(0, 1).equals("0"))) {
/*  771 */       s3 = s3.substring(0, s3.length() - 1);
/*      */     }
/*  773 */     if ((s4.length() > 0) && 
/*  774 */       (s4.substring(s4.length() - 1, s4.length()).equals("0"))) {
/*  775 */       s4 = s4.substring(0, s4.length() - 1);
/*      */     }
/*  777 */     if (s3.equals("0")) {
/*  778 */       s3 = "";
/*  779 */       s4 = "0" + s4;
/*      */     }
/*      */ 
/*  782 */     ChnMoney = s0 + s1 + s2 + s3 + "\u5143" + s4;
/*  783 */     if (ChnMoney.substring(0, 1).equals("0")) {
/*  784 */       ChnMoney = ChnMoney.substring(1, 
/*  785 */         ChnMoney.length());
/*      */     }
/*  787 */     for (int i = 0; i < ChnMoney.length(); i++) {
/*  788 */       if (ChnMoney.substring(i, i + 1).equals("0")) {
/*  789 */         ChnMoney = ChnMoney.substring(0, i) + "\u951F\u65A4\u62F7" + 
/*  790 */           ChnMoney.substring(i + 1, ChnMoney.length());
/*      */       }
/*      */     }
/*      */ 
/*  794 */     if (sDot.substring(1, 2).equals("0")) {
/*  795 */       ChnMoney = ChnMoney + "\u951F\u65A4\u62F7";
/*      */     }
/*      */ 
/*  798 */     return ChnMoney;
/*      */   }
/*      */ 
/*      */   private static String getDotM(String sIn)
/*      */   {
/*  803 */     String sMoney = "";
/*  804 */     if (!sIn.substring(0, 1).equals("0")) {
/*  805 */       sMoney = sMoney + getNum(sIn.substring(0, 1)) + "\u951F\u65A4\u62F7";
/*      */     }
/*      */     else {
/*  808 */       sMoney = sMoney + "0";
/*      */     }
/*  810 */     if (!sIn.substring(1, 2).equals("0")) {
/*  811 */       sMoney = sMoney + getNum(sIn.substring(1, 2)) + "\u951F\u65A4\u62F7";
/*      */     }
/*      */     else {
/*  814 */       sMoney = sMoney + "0";
/*      */     }
/*      */ 
/*  817 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String getChnM(String strUnit, String digit)
/*      */   {
/*  822 */     String sMoney = "";
/*  823 */     boolean flag = false;
/*      */ 
/*  825 */     if (strUnit.equals("0000")) {
/*  826 */       sMoney = sMoney + "0";
/*  827 */       return sMoney;
/*      */     }
/*  829 */     if (!strUnit.substring(0, 1).equals("0")) {
/*  830 */       sMoney = sMoney + getNum(strUnit.substring(0, 1)) + "\u4EDF";
/*      */     }
/*      */     else {
/*  833 */       sMoney = sMoney + "0";
/*  834 */       flag = true;
/*      */     }
/*  836 */     if (!strUnit.substring(1, 2).equals("0")) {
/*  837 */       sMoney = sMoney + getNum(strUnit.substring(1, 2)) + "\u951F\u65A4\u62F7";
/*  838 */       flag = false;
/*      */     }
/*  841 */     else if (!flag) {
/*  842 */       sMoney = sMoney + "0";
/*  843 */       flag = true;
/*      */     }
/*      */ 
/*  846 */     if (!strUnit.substring(2, 3).equals("0")) {
/*  847 */       sMoney = sMoney + getNum(strUnit.substring(2, 3)) + "\u62FE";
/*  848 */       flag = false;
/*      */     }
/*  851 */     else if (!flag) {
/*  852 */       sMoney = sMoney + "0";
/*  853 */       flag = true;
/*      */     }
/*      */ 
/*  856 */     if (!strUnit.substring(3, 4).equals("0")) {
/*  857 */       sMoney = sMoney + getNum(strUnit.substring(3, 4));
/*      */     }
/*  860 */     else if (!flag) {
/*  861 */       sMoney = sMoney + "0";
/*  862 */       flag = true;
/*      */     }
/*      */ 
/*  866 */     if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0")) {
/*  867 */       sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim() + 
/*  868 */         "0";
/*      */     }
/*      */     else {
/*  871 */       sMoney = sMoney + digit.trim();
/*      */     }
/*  873 */     return sMoney;
/*      */   }
/*      */ 
/*      */   private static String formatStr(String sIn)
/*      */   {
/*  878 */     int n = sIn.length();
/*      */ 
/*  880 */     StringBuffer sOut = new StringBuffer();
/*      */ 
/*  882 */     for (int k = 1; k <= 12 - n; k++)
/*      */     {
/*  884 */       sOut.append("0");
/*      */     }
/*  886 */     sOut.append(sIn);
/*  887 */     return sOut.toString();
/*      */   }
/*      */ 
/*      */   private static String getNum(String value)
/*      */   {
/*  892 */     String sNum = "";
/*  893 */     Integer I = new Integer(value);
/*  894 */     int iValue = I.intValue();
/*  895 */     switch (iValue) {
/*      */     case 0:
/*  897 */       sNum = "\u951F\u65A4\u62F7";
/*  898 */       break;
/*      */     case 1:
/*  900 */       sNum = "\u58F9";
/*  901 */       break;
/*      */     case 2:
/*  903 */       sNum = "\u951F\u65A4\u62F7";
/*  904 */       break;
/*      */     case 3:
/*  906 */       sNum = "\u951F\u65A4\u62F7";
/*  907 */       break;
/*      */     case 4:
/*  909 */       sNum = "\u951F\u65A4\u62F7";
/*  910 */       break;
/*      */     case 5:
/*  912 */       sNum = "\u951F\u65A4\u62F7";
/*  913 */       break;
/*      */     case 6:
/*  915 */       sNum = "\u9646";
/*  916 */       break;
/*      */     case 7:
/*  918 */       sNum = "\u951F\u65A4\u62F7";
/*  919 */       break;
/*      */     case 8:
/*  921 */       sNum = "\u951F\u65A4\u62F7";
/*  922 */       break;
/*      */     case 9:
/*  924 */       sNum = "\u951F\u65A4\u62F7";
/*      */     }
/*      */ 
/*  927 */     return sNum;
/*      */   }
/*      */ 
/*      */   public static String getInt(String Value)
/*      */   {
/*  933 */     if (Value == null) {
/*  934 */       return null;
/*      */     }
/*      */ 
/*  939 */     if (Value.equals("null")) {
/*  940 */       return "";
/*      */     }
/*  942 */     String result = "";
/*  943 */     boolean mflag = true;
/*  944 */     int m = 0;
/*  945 */     m = Value.lastIndexOf(".");
/*  946 */     if (m == -1) {
/*  947 */       result = Value;
/*      */     }
/*      */     else {
/*  950 */       for (int i = m + 1; i <= Value.length() - 1; i++) {
/*  951 */         if (Value.charAt(i) != '0') {
/*  952 */           result = Value;
/*  953 */           mflag = false;
/*  954 */           break;
/*      */         }
/*      */       }
/*  957 */       if (mflag) {
/*  958 */         result = Value.substring(0, m);
/*      */       }
/*      */     }
/*  961 */     return result;
/*      */   }
/*      */ 
/*      */   public static double getApproximation(double aValue)
/*      */   {
/*  966 */     if (Math.abs(aValue) <= 0.01D) {
/*  967 */       aValue = 0.0D;
/*      */     }
/*  969 */     return aValue;
/*      */   }
/*      */ 
/*      */   public static String[] split(String strMain, String strDelimiters)
/*      */   {
/*  975 */     int intIndex = 0;
/*      */ 
/*  977 */     Vector vResult = new Vector();
/*  978 */     String strSub = "";
/*      */ 
/*  980 */     strMain = strMain.trim();
/*      */ 
/*  983 */     if (strMain.length() <= strDelimiters.length()) {
/*  984 */       System.out.println("\u951F\u8857\u9769\u62F7\u951F\u65A4\u62F7\u5374\u951F\u65A4\u62F7\u8BD8\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5740\u951F\u65A4\u62F7\u9F8B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u8299\u951F\u65A4\u62F7\u80C1\u951F\u8857\uFF4F\u62F7");
/*  985 */       return null;
/*      */     }
/*      */ 
/*  990 */     intIndex = strMain.indexOf(strDelimiters);
/*      */ 
/*  994 */     if (intIndex == -1) {
/*  995 */       String[] arrResult = { 
/*  996 */         strMain };
/*  997 */       return arrResult;
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/* 1003 */       strSub = strMain.substring(0, intIndex);
/* 1004 */       if (intIndex != 0) {
/* 1005 */         vResult.add(strSub);
/*      */       }
/*      */       else
/*      */       {
/* 1009 */         vResult.add("");
/*      */       }
/*      */ 
/* 1012 */       strMain = strMain.substring(intIndex + strDelimiters.length()).trim();
/* 1013 */       intIndex = strMain.indexOf(strDelimiters);
/*      */     }
/* 1002 */     while (intIndex != -1);
/*      */ 
/* 1018 */     if (!strMain.equals("")) {
/* 1019 */       vResult.add(strMain);
/*      */     }
/*      */ 
/* 1022 */     String[] arrResult = new String[vResult.size()];
/* 1023 */     for (int i = 0; i < vResult.size(); i++) {
/* 1024 */       arrResult[i] = ((String)vResult.get(i));
/*      */     }
/*      */ 
/* 1027 */     return arrResult;
/*      */   }
/*      */ 
/*      */   public static double setPrecision(float value, String precision)
/*      */   {
/* 1032 */     return Float.parseFloat(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static double setPrecision(double value, String precision)
/*      */   {
/* 1037 */     return Double.parseDouble(new DecimalFormat(precision).format(value));
/*      */   }
/*      */ 
/*      */   public static String chgPrecision(double value, String precision)
/*      */   {
/* 1042 */     String str2 = new DecimalFormat(precision).format(Double.valueOf(
/* 1043 */       String.valueOf(value)));
/* 1044 */     return str2;
/*      */   }
/*      */ 
/*      */   public static SchemaSet copySchemaSet(SchemaSet srcSet)
/*      */   {
/* 1049 */     Reflections reflect = new Reflections();
/*      */     try {
/* 1051 */       if ((srcSet != null) && (srcSet.size() > 0)) {
/* 1052 */         if (srcSet.getObj(1) == null) {
/* 1053 */           return null;
/*      */         }
/* 1055 */         Class cls = srcSet.getClass();
/* 1056 */         Schema schema = 
/* 1057 */           (Schema)srcSet.getObj(1).getClass()
/* 1057 */           .newInstance();
/* 1058 */         SchemaSet obj = (SchemaSet)cls.newInstance();
/* 1059 */         obj.add(schema);
/* 1060 */         reflect.transFields(obj, srcSet);
/* 1061 */         return obj;
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/* 1065 */       ex.printStackTrace();
/*      */     }
/* 1067 */     return null;
/*      */   }
/*      */ 
/*      */   public static boolean exchangeSchema(Schema source, Schema object)
/*      */   {
/*      */     try
/*      */     {
/* 1074 */       Reflections tReflections = new Reflections();
/* 1075 */       tReflections.transFields(object, source);
/*      */ 
/* 1078 */       Method m = object.getClass().getMethod("getDB", null);
/* 1079 */       Schema schemaDB = (Schema)m.invoke(object, null);
/*      */ 
/* 1082 */       m = schemaDB.getClass().getMethod("getInfo", null);
/* 1083 */       m.invoke(schemaDB, null);
/* 1084 */       m = schemaDB.getClass().getMethod("getSchema", null);
/* 1085 */       object = (Schema)m.invoke(schemaDB, null);
/*      */ 
/* 1089 */       m = object.getClass().getMethod("getSchema", null);
/* 1090 */       Schema tSchema = (Schema)m.invoke(object, null);
/*      */ 
/* 1094 */       tReflections.transFields(object, source);
/* 1095 */       tReflections.transFields(source, tSchema);
/*      */ 
/* 1097 */       return true;
/*      */     }
/*      */     catch (Exception ex) {
/* 1100 */       ex.printStackTrace();
/* 1101 */     }return false;
/*      */   }
/*      */ 
/*      */   public static Vector formUpdateSql(String[] tables, String condition, String wherepart)
/*      */   {
/* 1108 */     Vector sqlVec = new Vector();
/* 1109 */     StringBuffer tSBql = null;
/* 1110 */     for (int i = 0; i < tables.length; i++) {
/* 1111 */       tSBql = new StringBuffer(128);
/* 1112 */       tSBql.append("update ");
/* 1113 */       tSBql.append(tables[i]);
/* 1114 */       tSBql.append(" set ");
/* 1115 */       tSBql.append(condition);
/* 1116 */       tSBql.append(" where ");
/* 1117 */       tSBql.append(wherepart);
/* 1118 */       sqlVec.add(tSBql.toString());
/*      */     }
/* 1120 */     return sqlVec;
/*      */   }
/*      */ 
/*      */   public static String DeleteZero(String sIn)
/*      */   {
/* 1125 */     int n = sIn.length();
/* 1126 */     String sOut = sIn;
/*      */ 
/* 1128 */     while ((sOut.substring(0, 1).equals("0")) && (n > 1)) {
/* 1129 */       sOut = sOut.substring(1, n);
/* 1130 */       n = sOut.length();
/*      */     }
/* 1132 */     if (sOut.equals("0")) {
/* 1133 */       return "";
/*      */     }
/*      */ 
/* 1136 */     return sOut;
/*      */   }
/*      */ 
/*      */   public static String getClassFileName(Object o)
/*      */   {
/* 1144 */     String fileName = o.getClass().getName();
/* 1145 */     fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
/* 1146 */     return fileName;
/*      */   }
/*      */ 
/*      */   public static void out(Object o, String s) {
/* 1150 */     System.out.println(getClassFileName(o) + " : " + s);
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
/*      */ 
/* 1162 */     int interval = 0;
/*      */ 
/* 1164 */     GregorianCalendar sCalendar = new GregorianCalendar();
/* 1165 */     sCalendar.setTime(startDate);
/* 1166 */     int sYears = sCalendar.get(1);
/*      */ 
/* 1169 */     int sDaysOfYear = sCalendar.get(6);
/*      */ 
/* 1171 */     GregorianCalendar eCalendar = new GregorianCalendar();
/* 1172 */     eCalendar.setTime(endDate);
/* 1173 */     int eYears = eCalendar.get(1);
/*      */ 
/* 1176 */     int eDaysOfYear = eCalendar.get(6);
/*      */ 
/* 1178 */     interval = eYears - sYears;
/* 1179 */     interval *= 365;
/* 1180 */     interval += eDaysOfYear - sDaysOfYear;
/*      */ 
/* 1183 */     int n = 0;
/* 1184 */     eYears--;
/* 1185 */     if (eYears > sYears) {
/* 1186 */       int i = sYears % 4;
/* 1187 */       if (i == 0) {
/* 1188 */         sYears++;
/* 1189 */         n++;
/*      */       }
/* 1191 */       int j = eYears % 4;
/* 1192 */       if (j == 0) {
/* 1193 */         eYears--;
/* 1194 */         n++;
/*      */       }
/* 1196 */       n += (eYears - sYears) / 4;
/*      */     }
/* 1198 */     if (eYears == sYears) {
/* 1199 */       int i = sYears % 4;
/* 1200 */       if (i == 0) {
/* 1201 */         n++;
/*      */       }
/*      */     }
/* 1204 */     interval += n;
/*      */ 
/* 1206 */     int x = 365;
/* 1207 */     int PolYear = 1;
/* 1208 */     while (x < interval) {
/* 1209 */       x += 365;
/* 1210 */       PolYear++;
/*      */     }
/*      */ 
/* 1213 */     return PolYear;
/*      */   }
/*      */ 
/*      */   public static String getBirthdayFromId(String IdNo)
/*      */   {
/* 1218 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1219 */     String birthday = "";
/* 1220 */     StringBuffer tReturn = new StringBuffer();
/* 1221 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18)) {
/* 1222 */       return "";
/*      */     }
/* 1224 */     if (tIdNo.length() == 18) {
/* 1225 */       birthday = tIdNo.substring(6, 14);
/* 1226 */       tReturn.append(birthday.substring(0, 4));
/* 1227 */       tReturn.append("-");
/* 1228 */       tReturn.append(birthday.substring(4, 6));
/* 1229 */       tReturn.append("-");
/* 1230 */       tReturn.append(birthday.substring(6));
/*      */     }
/* 1232 */     if (tIdNo.length() == 15) {
/* 1233 */       birthday = tIdNo.substring(6, 12);
/* 1234 */       tReturn.append("19");
/* 1235 */       tReturn.append(birthday.substring(0, 2));
/* 1236 */       tReturn.append("-");
/* 1237 */       tReturn.append(birthday.substring(2, 4));
/* 1238 */       tReturn.append("-");
/* 1239 */       tReturn.append(birthday.substring(4));
/*      */     }
/* 1241 */     return tReturn.toString();
/*      */   }
/*      */ 
/*      */   public static String getSexFromId(String IdNo)
/*      */   {
/* 1246 */     String tIdNo = StrTool.cTrim(IdNo);
/* 1247 */     if ((tIdNo.length() != 15) && (tIdNo.length() != 18)) {
/* 1248 */       return "";
/*      */     }
/* 1250 */     String sex = "";
/* 1251 */     if (tIdNo.length() == 15) {
/* 1252 */       sex = tIdNo.substring(14, 15);
/*      */     }
/*      */     else
/* 1255 */       sex = tIdNo.substring(16, 17);
/*      */     try
/*      */     {
/* 1258 */       int iSex = Integer.parseInt(sex);
/* 1259 */       iSex %= 2;
/* 1260 */       if (iSex == 0) {
/* 1261 */         return "1";
/*      */       }
/* 1263 */       if (iSex == 1)
/* 1264 */         return "0";
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1268 */       return "";
/*      */     }
/*      */ 
/* 1271 */     return "";
/*      */   }
/*      */ 
/*      */   public static String getTomorrow()
/*      */   {
/* 1278 */     String tFormatDate = "yyyy-MM-dd";
/*      */ 
/* 1280 */     SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
/*      */ 
/* 1282 */     Calendar tCalendar = Calendar.getInstance();
/*      */ 
/* 1284 */     int tDay = tCalendar.get(5);
/*      */ 
/* 1286 */     tDay++;
/*      */ 
/* 1288 */     tCalendar.set(5, tDay);
/* 1289 */     return tSimpleDateFormat.format(tCalendar.getTime());
/*      */   }
/*      */ 
/*      */   public static String getLastDate(String cDate, int cInterval, String cUnit)
/*      */   {
/* 1295 */     String tFormatDate = "yyyy-MM-dd";
/*      */ 
/* 1297 */     SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
/*      */ 
/* 1299 */     FDate tFDate = new FDate();
/* 1300 */     Date CurDate = tFDate.getDate(cDate);
/*      */ 
/* 1302 */     GregorianCalendar tCalendar = new GregorianCalendar();
/*      */ 
/* 1305 */     tCalendar.setTime(CurDate);
/*      */ 
/* 1307 */     if (cUnit.equals("D"))
/*      */     {
/* 1309 */       int tDay = tCalendar.get(5);
/*      */ 
/* 1312 */       tCalendar.set(5, tDay + cInterval);
/*      */ 
/* 1314 */       return tSimpleDateFormat.format(tCalendar.getTime());
/*      */     }
/* 1316 */     if (cUnit.equals("M"))
/*      */     {
/* 1318 */       int tMonth = tCalendar.get(2);
/*      */ 
/* 1321 */       tCalendar.set(2, tMonth + cInterval);
/*      */ 
/* 1323 */       return tSimpleDateFormat.format(tCalendar.getTime());
/*      */     }
/* 1325 */     if (cUnit.equals("Y"))
/*      */     {
/* 1327 */       int tYear = tCalendar.get(1);
/*      */ 
/* 1329 */       tCalendar.set(1, tYear + cInterval);
/*      */ 
/* 1331 */       return tSimpleDateFormat.format(tCalendar.getTime());
/*      */     }
/*      */ 
/* 1334 */     return "";
/*      */   }
/*      */ 
/*      */   public static String[] getPrevMonth(String cDate)
/*      */   {
/* 1341 */     String tFormatDate = "yyyy-MM-dd";
/*      */ 
/* 1343 */     SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
/* 1344 */     FDate tFDate = new FDate();
/* 1345 */     Date CurDate = tFDate.getDate(cDate);
/* 1346 */     GregorianCalendar tCalendar = new GregorianCalendar();
/*      */ 
/* 1349 */     tCalendar.setTime(CurDate);
/*      */ 
/* 1351 */     int tMonth = tCalendar.get(2);
/*      */ 
/* 1353 */     tCalendar.set(2, tMonth - 1);
/* 1354 */     return calFLDate(tSimpleDateFormat.format(tCalendar.getTime()));
/*      */   }
/*      */ 
/*      */   public static String getYesterday()
/*      */   {
/* 1360 */     String tFormatDate = "yyyy-MM-dd";
/*      */ 
/* 1362 */     SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
/*      */ 
/* 1364 */     Calendar tCalendar = Calendar.getInstance();
/*      */ 
/* 1366 */     int tDay = tCalendar.get(5);
/*      */ 
/* 1368 */     tDay--;
/*      */ 
/* 1370 */     tCalendar.set(5, tDay);
/* 1371 */     return tSimpleDateFormat.format(tCalendar.getTime());
/*      */   }
/*      */ 
/*      */   public static boolean validateNumber(String str)
/*      */   {
/* 1376 */     String tmp = null;
/* 1377 */     for (int i = 0; i < str.length(); i++) {
/* 1378 */       tmp = str.substring(i, i + 1);
/* 1379 */       if ("0123456789-".indexOf(tmp) == -1) {
/* 1380 */         return false;
/*      */       }
/*      */     }
/* 1383 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean validateDate(String strDate)
/*      */   {
/* 1388 */     int yyyy = 0;
/* 1389 */     int mm = 0;
/* 1390 */     int dd = 0;
/*      */ 
/* 1392 */     if (!validateNumber(strDate)) {
/* 1393 */       return false;
/*      */     }
/*      */ 
/* 1396 */     if (strDate.indexOf("-") >= 0) {
/* 1397 */       StringTokenizer token = new StringTokenizer(strDate, "-");
/* 1398 */       int i = 0;
/* 1399 */       while (token.hasMoreElements()) {
/* 1400 */         if (i == 0) {
/* 1401 */           yyyy = Integer.parseInt(token.nextToken());
/*      */         }
/* 1403 */         if (i == 1) {
/* 1404 */           mm = Integer.parseInt(token.nextToken());
/*      */         }
/* 1406 */         if (i == 2) {
/* 1407 */           dd = Integer.parseInt(token.nextToken());
/*      */         }
/* 1409 */         i++;
/*      */       }
/*      */     }
/*      */     else {
/* 1413 */       if (strDate.length() != 8) {
/* 1414 */         return false;
/*      */       }
/* 1416 */       yyyy = Integer.parseInt(strDate.substring(0, 4));
/* 1417 */       mm = Integer.parseInt(strDate.substring(4, 6));
/* 1418 */       dd = Integer.parseInt(strDate.substring(6, 8));
/*      */     }
/* 1420 */     if ((yyyy > 9999) || (yyyy < 1800)) {
/* 1421 */       return false;
/*      */     }
/* 1423 */     if ((mm > 12) || (mm < 1)) {
/* 1424 */       return false;
/*      */     }
/* 1426 */     if ((dd > 31) || (dd < 1)) {
/* 1427 */       return false;
/*      */     }
/* 1429 */     if (((mm == 4) || (mm == 6) || (mm == 9) || (mm == 11)) && (dd == 31)) {
/* 1430 */       return false;
/*      */     }
/* 1432 */     if (mm == 2)
/*      */     {
/* 1434 */       boolean leap = (yyyy % 4 == 0) && ((yyyy % 100 != 0) || (yyyy % 400 == 0));
/* 1435 */       if ((dd > 29) || ((dd == 29) && (!leap))) {
/* 1436 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1441 */     FDate myFDate = new FDate();
/* 1442 */     Date validateDate = myFDate.getDate(strDate);
/* 1443 */     Date now = new Date();
/*      */ 
/* 1445 */     return calInterval(validateDate, now, "D") >= 0;
/*      */   }
/*      */ 
/*      */   public static final String getNewId(String id, String type)
/*      */   {
/* 1453 */     String newid = "";
/* 1454 */     if (type.equals("0")) {
/* 1455 */       int[] W = { 
/* 1456 */         7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
/*      */ 
/* 1458 */       String[] A = { 
/* 1459 */         "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
/*      */ 
/* 1461 */       int s = 0;
/* 1462 */       newid = id;
/* 1463 */       newid = newid.substring(0, 6) + "19" + newid.substring(6, id.length());
/* 1464 */       for (int i = 0; i < newid.length(); i++)
/*      */       {
/* 1466 */         int j = Integer.parseInt(newid.substring(i, i + 1)) * W[i];
/* 1467 */         s += j;
/*      */       }
/* 1469 */       s %= 11;
/* 1470 */       newid = newid + A[s];
/*      */     }
/* 1472 */     if (type.equals("1")) {
/* 1473 */       newid = id.substring(0, 6) + id.substring(8, 17);
/*      */     }
/*      */ 
/* 1476 */     return newid;
/*      */   }
/*      */ 
/*      */   public static boolean CompareId(String id1, String id2)
/*      */   {
/* 1482 */     if (id1.length() == id2.length()) {
/* 1483 */       if (id1.equals(id2)) {
/* 1484 */         return true;
/*      */       }
/*      */     }
/* 1487 */     else if ((id1.length() == 15) && (id2.length() == 18)) {
/* 1488 */       if (getNewId(id1, "0").equals(id2)) {
/* 1489 */         return true;
/*      */       }
/*      */     }
/* 1492 */     else if ((id1.length() == 18) && (id2.length() == 15) && 
/* 1493 */       (getNewId(id1, "1").equals(id2))) {
/* 1494 */       return true;
/*      */     }
/*      */ 
/* 1497 */     return false;
/*      */   }
/*      */ 
/*      */   public static String format(double dValue)
/*      */   {
/* 1502 */     return new DecimalFormat("0.00").format(dValue);
/*      */   }
/*      */ 
/*      */   public static String FormatDate(String cDate)
/*      */   {
/* 1507 */     if ((cDate == null) || ("".equals(cDate))) {
/* 1508 */       return "";
/*      */     }
/*      */ 
/* 1511 */     cDate = cDate.replaceFirst("-", "\u951F\u65A4\u62F7");
/* 1512 */     cDate = cDate.replaceFirst("-", "\u951F\u65A4\u62F7");
/*      */ 
/* 1514 */     StringBuffer tSBql = new StringBuffer();
/* 1515 */     tSBql.append(cDate);
/* 1516 */     tSBql.append("\u951F\u65A4\u62F7");
/*      */ 
/* 1518 */     return tSBql.toString();
/*      */   }
/*      */ 
/*      */   public static String formatDateEx(String cDate)
/*      */   {
/* 1523 */     if ((cDate == null) || ("".equals(cDate))) {
/* 1524 */       return "";
/*      */     }
/*      */ 
/* 1528 */     String year = cDate.substring(0, cDate.indexOf("-"));
/* 1529 */     String month = cDate.substring(cDate.indexOf("-") + 1, 
/* 1530 */       cDate.lastIndexOf("-"));
/* 1531 */     String day = cDate.substring(cDate.lastIndexOf("-") + 1);
/*      */ 
/* 1534 */     if (month.startsWith("0")) {
/* 1535 */       month = month.substring(1);
/*      */     }
/*      */ 
/* 1539 */     if (day.startsWith("0")) {
/* 1540 */       day = day.substring(1);
/*      */     }
/*      */ 
/* 1543 */     cDate = year + "\u951F\u65A4\u62F7" + month + "\u951F\u65A4\u62F7" + day + "\u951F\u65A4\u62F7";
/* 1544 */     return cDate;
/*      */   }
/*      */ 
/*      */   public static String calOFDate(String baseDate, int interval, String unit, String compareDate)
/*      */   {
/*      */     try
/*      */     {
/* 1551 */       FDate tFDate = new FDate();
/* 1552 */       Date bDate = tFDate.getDate(baseDate);
/* 1553 */       Date cDate = tFDate.getDate(compareDate);
/* 1554 */       return tFDate.getString(calOFDate(bDate, interval, unit, cDate));
/*      */     }
/*      */     catch (Exception ex) {
/* 1557 */       ex.printStackTrace();
/* 1558 */     }return null;
/*      */   }
/*      */ 
/*      */   public static Date calOFDate(Date baseDate, int interval, String unit, Date compareDate)
/*      */   {
/* 1565 */     Date returnDate = null;
/*      */ 
/* 1567 */     GregorianCalendar mCalendar = new GregorianCalendar();
/*      */ 
/* 1569 */     mCalendar.setTime(baseDate);
/* 1570 */     if (unit.equals("Y")) {
/* 1571 */       mCalendar.add(1, interval);
/*      */     }
/* 1573 */     if (unit.equals("M"))
/*      */     {
/* 1576 */       mCalendar.add(2, interval);
/*      */     }
/* 1578 */     if (unit.equals("D")) {
/* 1579 */       mCalendar.add(5, interval);
/*      */     }
/*      */ 
/* 1582 */     if (compareDate != null) {
/* 1583 */       GregorianCalendar cCalendar = new GregorianCalendar();
/*      */ 
/* 1586 */       cCalendar.setTime(compareDate);
/*      */ 
/* 1588 */       int mYears = mCalendar.get(1);
/* 1589 */       int mMonths = mCalendar.get(2);
/* 1590 */       int cMonths = cCalendar.get(2);
/* 1591 */       int cDays = cCalendar.get(5);
/*      */ 
/* 1593 */       if (unit.equals("Y")) {
/* 1594 */         cCalendar.set(mYears, cMonths, cDays);
/* 1595 */         if (mMonths < cCalendar.get(2)) {
/* 1596 */           cCalendar.set(mYears, mMonths + 1, 0);
/*      */         }
/*      */ 
/* 1599 */         if (cCalendar.before(mCalendar)) {
/* 1600 */           mCalendar.set(mYears + 1, cMonths, cDays);
/* 1601 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/* 1604 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/* 1607 */       if (unit.equals("M")) {
/* 1608 */         cCalendar.set(mYears, mMonths, cDays);
/*      */ 
/* 1610 */         if (mMonths < cCalendar.get(2))
/*      */         {
/* 1618 */           cCalendar.set(mYears, mMonths + 1, 0);
/*      */         }
/*      */ 
/* 1621 */         if (cCalendar.before(mCalendar)) {
/* 1622 */           mCalendar.set(mYears, mMonths + 1, cDays);
/* 1623 */           returnDate = mCalendar.getTime();
/*      */         }
/*      */         else {
/* 1626 */           returnDate = cCalendar.getTime();
/*      */         }
/*      */       }
/* 1629 */       if (unit.equals("D"))
/* 1630 */         returnDate = mCalendar.getTime();
/*      */     }
/*      */     else
/*      */     {
/* 1634 */       returnDate = mCalendar.getTime();
/*      */     }
/*      */ 
/* 1637 */     return returnDate;
/*      */   }
/*      */ 
/*      */   public static String GetDateTime(String cDate, String cTime)
/*      */   {
/* 1642 */     String[] tDate = cDate.split("-");
/* 1643 */     String[] tTime = cTime.split(":");
/* 1644 */     StringBuffer tSBql = new StringBuffer();
/* 1645 */     tSBql.append(tDate[0]);
/* 1646 */     tSBql.append(tDate[1]);
/* 1647 */     tSBql.append(tDate[2]);
/* 1648 */     tSBql.append(tTime[0]);
/* 1649 */     tSBql.append(tTime[1]);
/* 1650 */     tSBql.append(tTime[2]);
/* 1651 */     return tSBql.toString();
/*      */   }
/*      */ 
/*      */   public static SSRS Add_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
/*      */   {
/* 1657 */     SSRS rSSRS = new SSRS(1);
/*      */ 
/* 1661 */     int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
/*      */     try {
/* 1663 */       for (int r = 1; r <= length; r++)
/*      */       {
/*      */         double d1;
/*      */         double d1;
/* 1664 */         if (firstSSRS.GetText(r, firstIndex).equals("")) {
/* 1665 */           d1 = 0.0D;
/*      */         }
/*      */         else
/* 1668 */           d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
/*      */         double d2;
/*      */         double d2;
/* 1670 */         if (secondSSRS.GetText(r, secondIndex).equals("")) {
/* 1671 */           d2 = 0.0D;
/*      */         }
/*      */         else {
/* 1674 */           d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
/*      */         }
/* 1676 */         double temp = d1 + d2;
/* 1677 */         rSSRS.SetText(String.valueOf(temp));
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1681 */       e.printStackTrace();
/*      */     }
/* 1683 */     return rSSRS;
/*      */   }
/*      */ 
/*      */   public static SSRS Subtract_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
/*      */   {
/* 1689 */     SSRS rSSRS = new SSRS(1);
/*      */ 
/* 1693 */     int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
/*      */     try {
/* 1695 */       for (int r = 1; r <= length; r++)
/*      */       {
/*      */         double d1;
/*      */         double d1;
/* 1696 */         if (firstSSRS.GetText(r, firstIndex).equals("")) {
/* 1697 */           d1 = 0.0D;
/*      */         }
/*      */         else
/* 1700 */           d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
/*      */         double d2;
/*      */         double d2;
/* 1702 */         if (secondSSRS.GetText(r, secondIndex).equals("")) {
/* 1703 */           d2 = 0.0D;
/*      */         }
/*      */         else {
/* 1706 */           d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
/*      */         }
/* 1708 */         double temp = d1 - d2;
/* 1709 */         rSSRS.SetText(String.valueOf(temp));
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1713 */       e.printStackTrace();
/*      */     }
/* 1715 */     return rSSRS;
/*      */   }
/*      */ 
/*      */   public static SSRS Mul_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
/*      */   {
/* 1721 */     SSRS rSSRS = new SSRS(1);
/*      */ 
/* 1725 */     int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
/*      */     try {
/* 1727 */       for (int r = 1; r <= length; r++)
/*      */       {
/*      */         double d1;
/*      */         double d1;
/* 1728 */         if (firstSSRS.GetText(r, firstIndex).equals("")) {
/* 1729 */           d1 = 0.0D;
/*      */         }
/*      */         else
/* 1732 */           d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
/*      */         double d2;
/*      */         double d2;
/* 1734 */         if (secondSSRS.GetText(r, secondIndex).equals("")) {
/* 1735 */           d2 = 0.0D;
/*      */         }
/*      */         else {
/* 1738 */           d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
/*      */         }
/* 1740 */         double temp = d1 * d2;
/* 1741 */         rSSRS.SetText(String.valueOf(temp));
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1745 */       e.printStackTrace();
/*      */     }
/* 1747 */     return rSSRS;
/*      */   }
/*      */ 
/*      */   public static SSRS Div_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
/*      */   {
/* 1753 */     SSRS rSSRS = new SSRS(1);
/*      */ 
/* 1757 */     int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
/*      */     try {
/* 1759 */       for (int r = 1; r <= length; r++)
/*      */       {
/*      */         double d1;
/*      */         double d1;
/* 1760 */         if (firstSSRS.GetText(r, firstIndex).equals("")) {
/* 1761 */           d1 = 0.0D;
/*      */         }
/*      */         else
/* 1764 */           d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
/*      */         double d2;
/*      */         double d2;
/* 1766 */         if ((secondSSRS.GetText(r, secondIndex).equals("")) || 
/* 1767 */           (secondSSRS.GetText(r, secondIndex).equals("1"))) {
/* 1768 */           d2 = 1.0D;
/*      */         }
/*      */         else {
/* 1771 */           d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
/*      */         }
/* 1773 */         double temp = d1 / d2;
/* 1774 */         rSSRS.SetText(String.valueOf(temp));
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1778 */       e.printStackTrace();
/*      */     }
/* 1780 */     return rSSRS;
/*      */   }
/*      */ 
/*      */   public static SSRS changValue_SSRS(SSRS source, int row, int col, String value)
/*      */   {
/* 1786 */     if ((source == null) || (row > source.getMaxRow()) || (col > source.getMaxCol())) {
/* 1787 */       return null;
/*      */     }
/* 1789 */     SSRS rSSRS = new SSRS();
/* 1790 */     rSSRS.setMaxCol(source.getMaxCol());
/* 1791 */     rSSRS.setMaxRow(source.getMaxRow());
/* 1792 */     for (int r = 1; r <= source.getMaxRow(); r++) {
/* 1793 */       for (int c = 1; c <= source.getMaxCol(); c++) {
/* 1794 */         if ((r == row) && (c == col)) {
/* 1795 */           rSSRS.SetText(value);
/*      */         }
/*      */         else {
/* 1798 */           rSSRS.SetText(source.GetText(r, c));
/*      */         }
/*      */       }
/*      */     }
/* 1802 */     return rSSRS;
/*      */   }
/*      */ 
/*      */   public static int getDays(String strdate)
/*      */   {
/* 1807 */     Date date = null;
/* 1808 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 1809 */     Calendar calendar = new GregorianCalendar();
/*      */     try {
/* 1811 */       date = sdf.parse(strdate);
/*      */     }
/*      */     catch (Exception e) {
/* 1814 */       e.printStackTrace();
/*      */     }
/* 1816 */     calendar.setTime(date);
/* 1817 */     int day = calendar.getActualMaximum(5);
/* 1818 */     return day;
/*      */   }
/*      */ 
/*      */   public static String changForJavaScript(String s)
/*      */   {
/* 1823 */     char[] arr = s.toCharArray();
/* 1824 */     s = "";
/* 1825 */     for (int i = 0; i < arr.length; i++) {
/* 1826 */       if ((arr[i] == '"') || (arr[i] == '\'') || (arr[i] == '\n')) {
/* 1827 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1830 */       s = s + arr[i];
/*      */     }
/*      */ 
/* 1833 */     return s;
/*      */   }
/*      */ 
/*      */   public static String changForHTML(String s)
/*      */   {
/* 1838 */     char[] arr = s.toCharArray();
/* 1839 */     s = "";
/*      */ 
/* 1841 */     for (int i = 0; i < arr.length; i++) {
/* 1842 */       if ((arr[i] == '"') || (arr[i] == '\'')) {
/* 1843 */         s = s + "\\";
/*      */       }
/*      */ 
/* 1846 */       if (arr[i] == '\n') {
/* 1847 */         s = s + "<br>";
/*      */       }
/*      */       else
/*      */       {
/* 1851 */         s = s + arr[i];
/*      */       }
/*      */     }
/* 1854 */     return s;
/*      */   }
/*      */ 
/*      */   public HashMap getLaagent(String AgentCode)
/*      */   {
/* 1912 */     ExeSQL query = new ExeSQL();
/* 1913 */     String agentsql = "select Name,Mobile,ManageCom from LAAgent where agentcode = '" + 
/* 1914 */       AgentCode + 
/* 1915 */       "'";
/* 1916 */     SSRS agentSSRS = query.execSQL(agentsql);
/*      */ 
/* 1918 */     HashMap agentHashMap = new HashMap();
/* 1919 */     if (agentSSRS.MaxRow > 0) {
/* 1920 */       String AgentName = agentSSRS.GetText(1, 1);
/* 1921 */       String AgentMobile = agentSSRS.GetText(1, 2);
/* 1922 */       String ManageCom = agentSSRS.GetText(1, 3);
/*      */ 
/* 1924 */       agentHashMap.put("AgentName", AgentName);
/* 1925 */       agentHashMap.put("AgentMobile", AgentMobile);
/* 1926 */       agentHashMap.put("ManageCom", ManageCom);
/* 1927 */       String Addresssql = "select address,Phone from MCom where Comcode=" + ManageCom;
/* 1928 */       SSRS AddressSSRS = query.execSQL(Addresssql);
/* 1929 */       String ComAddress = "";
/* 1930 */       String AgentPhone = "";
/* 1931 */       if (AddressSSRS.MaxRow > 0) {
/* 1932 */         ComAddress = AddressSSRS.GetText(1, 1);
/* 1933 */         AgentPhone = AddressSSRS.GetText(1, 2);
/*      */       }
/* 1935 */       if (ComAddress.length() > 15) {
/* 1936 */         ComAddress = ComAddress.substring(0, 15) + "<br>            " + ComAddress.substring(15, ComAddress.length());
/*      */       }
/*      */ 
/* 1939 */       agentHashMap.put("AgentComAddress", ComAddress);
/* 1940 */       agentHashMap.put("AgentPhone", AgentPhone);
/*      */     }
/* 1942 */     return agentHashMap;
/*      */   }
/*      */ 
/*      */   public static void cleanUpdatePackage(String[] rootdir)
/*      */   {
/* 1947 */     StringBuffer sb = new StringBuffer();
/*      */ 
/* 1949 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*      */ 
/* 1951 */     for (int j = 0; j < rootdir.length; j++)
/*      */       try {
/* 1953 */         File root = new File(rootdir[j]);
/* 1954 */         if (!root.exists()) {
/* 1955 */           return;
/*      */         }
/* 1957 */         boolean isdir = root.isDirectory();
/* 1958 */         if (!isdir) {
/* 1959 */           return;
/*      */         }
/*      */ 
/* 1962 */         String[] allfiles = root.list();
/* 1963 */         if ((allfiles != null) && (allfiles.length >= 0))
/*      */         {
/* 1965 */           for (int i = 0; i < allfiles.length; i++)
/*      */           {
/* 1967 */             File file = new File(rootdir[j] + "/" + allfiles[i]);
/*      */ 
/* 1969 */             String modifyTime = df.format(new Date(file.lastModified()));
/*      */ 
/* 1971 */             String nowTime = df.format(new Date());
/*      */ 
/* 1973 */             if (getQuot(nowTime, modifyTime) < 24L) {
/*      */               continue;
/*      */             }
/* 1976 */             file.delete();
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 1984 */         root = null;
/*      */       } catch (Exception e) {
/* 1986 */         e.printStackTrace();
/*      */       }
/*      */   }
/*      */ 
/*      */   public static long getQuot(String time1, String time2)
/*      */   {
/* 1994 */     long quot = 0L;
/* 1995 */     SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*      */     try {
/* 1997 */       Date date1 = ft.parse(time1);
/* 1998 */       Date date2 = ft.parse(time2);
/* 1999 */       quot = date1.getTime() - date2.getTime();
/* 2000 */       quot = quot / 1000L / 60L / 60L;
/*      */     } catch (Exception e) {
/* 2002 */       e.printStackTrace();
/*      */     }
/* 2004 */     return quot;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.PubFun
 * JD-Core Version:    0.6.0
 */