/*      */ package com.sinosoft.map.utility;
/*      */ 
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Vector;
/*      */ 
/*      */ public class StrTool
/*      */ {
/*      */   public static final String EQUAL = "=";
/*      */   public static final String GREATER = ">";
/*      */   public static final String GREATGE_EQUAL = ">=";
/*      */   public static final String LESS = "<";
/*      */   public static final String LESS_EQUAL = "<=";
/*      */   public static final String NOT_EQUAL = "!=";
/*      */   public static final String CONTAIN = "*";
/*      */   public static final String BETWEEN = ":";
/*      */   public static final String DATEDELIMITER = "/";
/*      */   public static final String VISADATEDELIMITER = "-";
/*      */   public static final String TIMEDELIMITER = ":";
/*      */   public static final String ADDRESSDELIMITER = "$$";
/*      */   public static final String DELIMITER = "^";
/*      */   public static final String PACKAGESPILTER = "|";
/*      */   public static final String OR = "~!";
/*      */   public static final int LENGTH_OR = 2;
/*      */   public static final String BETWEEN_AND = ":";
/*      */   public static final String BLANK = "?";
/*      */   public static final String DIRECTMODE = "Direct Mode!^^";
/*      */ 
/*      */   public static String decodeStr(String strMain, String strDelimiters, int intSerialNo)
/*      */   {
/*   46 */     int intIndex = 0;
/*   47 */     int intCount = 0;
/*   48 */     String strReturn = "";
/*      */ 
/*   50 */     if (strMain.length() < strDelimiters.length())
/*      */     {
/*   52 */       return "";
/*      */     }
/*      */ 
/*   55 */     intIndex = strMain.indexOf(strDelimiters);
/*   56 */     if (intIndex == -1)
/*      */     {
/*   58 */       return "";
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/*   63 */       strReturn = strMain.substring(0, intIndex);
/*   64 */       intCount++;
/*   65 */       if (intCount == intSerialNo)
/*      */       {
/*   67 */         if (intIndex == 0)
/*      */         {
/*   69 */           return "";
/*      */         }
/*      */ 
/*   73 */         return strReturn.trim();
/*      */       }
/*      */ 
/*   76 */       strMain = strMain.substring(intIndex + 1);
/*   77 */       intIndex = strMain.indexOf(strDelimiters);
/*      */     }
/*   61 */     while (intIndex != -1);
/*      */ 
/*   80 */     return "";
/*      */   }
/*      */ 
/*      */   public static int getPos(String strMain, String strSub, int intTimes)
/*      */   {
/*   86 */     int intCounter = 0;
/*   87 */     int intPosition = 0;
/*   88 */     int intLength = strSub.length();
/*      */ 
/*   90 */     if (intTimes <= 0)
/*      */     {
/*   92 */       return -1;
/*      */     }
/*      */     do
/*      */     {
/*   96 */       intPosition = strMain.indexOf(strSub, intPosition);
/*   97 */       if (intPosition == -1)
/*      */       {
/*   99 */         return -1;
/*      */       }
/*  101 */       intCounter++;
/*  102 */       intPosition += intLength;
/*      */     }
/*   94 */     while (intCounter < intTimes);
/*      */ 
/*  104 */     return intPosition - intLength;
/*      */   }
/*      */ 
/*      */   public static int getPos(String strMain, String strSub, int intStartIndex, int intTimes)
/*      */   {
/*  111 */     if (strMain.length() - 1 < intStartIndex)
/*      */     {
/*  113 */       return -1;
/*      */     }
/*  115 */     int intPosition = getPos(strMain.substring(intStartIndex), strSub, 
/*  116 */       intTimes);
/*  117 */     if (intPosition != -1)
/*      */     {
/*  119 */       intPosition += intStartIndex;
/*      */     }
/*  121 */     return intPosition;
/*      */   }
/*      */ 
/*      */   public static String makeCondition(String strMessage)
/*      */   {
/*  127 */     String strSegment = "";
/*  128 */     String strField = "";
/*  129 */     String strOperator = "";
/*  130 */     String strValue = "";
/*  131 */     String strRemain = "";
/*  132 */     String strReturn = "1=1";
/*  133 */     int intPosition = 0;
/*      */ 
/*  135 */     if (strMessage.indexOf("^") < 0)
/*      */     {
/*  137 */       return strMessage;
/*      */     }
/*  139 */     strRemain = strMessage;
/*      */ 
/*  141 */     if (!strRemain.endsWith("Direct Mode!^^^"))
/*      */     {
/*      */       while (true)
/*      */       {
/*  145 */         intPosition = getPos(strRemain, "^", 3);
/*  146 */         if (intPosition < 0)
/*      */         {
/*  148 */           return strReturn;
/*      */         }
/*  150 */         strSegment = strRemain.substring(0, intPosition + 1).trim();
/*  151 */         strRemain = strRemain.substring(intPosition + 1);
/*  152 */         if (strSegment.length() < 1)
/*      */         {
/*      */           break;
/*      */         }
/*  156 */         strField = decodeStr(strSegment, "^", 1);
/*  157 */         strOperator = decodeStr(strSegment, "^", 2);
/*  158 */         strValue = decodeStr(strSegment, "^", 3);
/*  159 */         if (strValue.equals("?"))
/*      */         {
/*  161 */           strValue = " ";
/*      */         }
/*  163 */         strReturn = strReturn + " AND " + "(";
/*      */ 
/*  165 */         if (strOperator.equals(":"))
/*      */         {
/*  167 */           intPosition = strValue.indexOf(":");
/*  168 */           strReturn = strReturn + strField + " BETWEEN '" + 
/*  169 */             strValue.substring(0, intPosition).trim() + "'" + 
/*  170 */             " AND  '" + 
/*  171 */             strValue.substring(intPosition + 1).trim() + 
/*  172 */             "' ";
/*      */         }
/*  174 */         else if (strOperator.equals("*"))
/*      */         {
/*  176 */           strReturn = strReturn + strField + " matches '" + strValue + 
/*  177 */             "*' ";
/*      */         }
/*      */         else
/*      */         {
/*  181 */           strSegment = "";
/*      */           while (true)
/*      */           {
/*  184 */             intPosition = strValue.indexOf("~!");
/*  185 */             if (intPosition < 0)
/*      */             {
/*  187 */               if (strSegment.equals(""))
/*      */               {
/*  189 */                 strReturn = strReturn + strField + " " + 
/*  190 */                   strOperator + " '" + strValue + 
/*  191 */                   "' ";
/*  192 */                 break;
/*      */               }
/*      */ 
/*  195 */               strReturn = strReturn + 
/*  196 */                 strSegment + 
/*  197 */                 " OR " + 
/*  198 */                 strField + 
/*  199 */                 " " + strOperator + 
/*  200 */                 " '" + strValue.trim() + "' ";
/*      */ 
/*  202 */               break;
/*      */             }
/*  204 */             if (!strSegment.equals(""))
/*      */             {
/*  206 */               strSegment = strSegment + " OR ";
/*      */             }
/*      */ 
/*  209 */             strSegment = strSegment + 
/*  210 */               strField + 
/*  211 */               " " + strOperator + 
/*  212 */               " '" + 
/*  213 */               strValue.substring(0, intPosition).trim() + 
/*  214 */               "' ";
/*  215 */             strValue = strValue.substring(intPosition + 2);
/*      */           }
/*      */         }
/*  218 */         strReturn = strReturn + ") ";
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  224 */     strRemain = strRemain.substring(0, 
/*  225 */       strRemain.length() - 
/*  226 */       "Direct Mode!^^".length() - 
/*  227 */       "^".length());
/*  228 */     if (strRemain.trim().equals(""))
/*      */     {
/*  230 */       strRemain = "1=1";
/*      */     }
/*  232 */     strReturn = strRemain;
/*      */ 
/*  234 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String unicodeToGBK(String strOriginal)
/*      */   {
/*  240 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  244 */         if (!isGBKString(strOriginal))
/*      */         {
/*  246 */           return new String(strOriginal.getBytes("ISO8859_1"), "GBK");
/*      */         }
/*      */ 
/*  250 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  256 */         System.out.println(exception.getMessage());
/*  257 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  262 */     return "";
/*      */   }
/*      */ 
/*      */   public static String GBKToUnicode(String strOriginal)
/*      */   {
/*  271 */     return unicodeToGBK(strOriginal);
/*      */ 
/*  273 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  277 */         if (isGBKString(strOriginal))
/*      */         {
/*  279 */           return new String(strOriginal.getBytes("GBK"), "ISO8859_1");
/*      */         }
/*      */ 
/*  283 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  288 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  293 */     return null;
/*      */   }
/*      */ 
/*      */   public static String GBKToUnicode(String strOriginal, boolean realConvert)
/*      */   {
/*  300 */     if (!realConvert)
/*      */     {
/*  302 */       return unicodeToGBK(strOriginal);
/*      */     }
/*  304 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  308 */         if (isGBKString(strOriginal))
/*      */         {
/*  310 */           return new String(strOriginal.getBytes("GBK"), "ISO8859_1");
/*      */         }
/*      */ 
/*  314 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  319 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  324 */     return null;
/*      */   }
/*      */ 
/*      */   public static boolean isGBKString(String tStr)
/*      */   {
/*  331 */     int tlength = tStr.length();
/*  332 */     Integer t = new Integer(0);
/*  333 */     int t1 = 0;
/*  334 */     for (int i = 0; i < tlength; i++)
/*      */     {
/*  336 */       t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
/*  337 */       if (t1 > 511)
/*      */       {
/*  339 */         return true;
/*      */       }
/*      */     }
/*  342 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean isUnicodeString(String tStr)
/*      */   {
/*  348 */     int tlength = tStr.length();
/*  349 */     Integer t = new Integer(0);
/*  350 */     int t1 = 0;
/*  351 */     for (int i = 0; i < tlength; i++)
/*      */     {
/*  353 */       t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
/*  354 */       if (t1 > 511)
/*      */       {
/*  356 */         return false;
/*      */       }
/*      */     }
/*  359 */     return true;
/*      */   }
/*      */ 
/*      */   public static Vector stringToVector(String strMessage, int intCount, Class cl)
/*      */     throws Exception
/*      */   {
/*  366 */     int intFieldNum = 0;
/*  367 */     Object object = null;
/*  368 */     Vector vec = new Vector();
/*  369 */     int intPosition = 0;
/*  370 */     Class[] parameters = 
/*  371 */       { 
/*  372 */       String.class };
/*  373 */     Method method = null;
/*  374 */     Field field = null;
/*  375 */     String[] therecord = 
/*  376 */       { 
/*  377 */       new String() };
/*      */     try
/*      */     {
/*  380 */       object = cl.newInstance();
/*  381 */       method = cl.getMethod("decode", parameters);
/*  382 */       field = cl.getField("FIELDNUM");
/*  383 */       intFieldNum = field.getInt(object);
/*      */ 
/*  385 */       for (int i = 0; i < intCount; i++)
/*      */       {
/*  387 */         object = cl.newInstance();
/*  388 */         intPosition = getPos(strMessage, "|", 
/*  389 */           intFieldNum);
/*      */ 
/*  391 */         if (intPosition == strMessage.length() - 1)
/*      */         {
/*  393 */           therecord[0] = strMessage;
/*  394 */           method.invoke(object, therecord);
/*  395 */           vec.addElement(object);
/*  396 */           break;
/*      */         }
/*      */ 
/*  400 */         therecord[0] = strMessage.substring(0, intPosition + 1);
/*      */ 
/*  402 */         method.invoke(object, therecord);
/*  403 */         vec.addElement(object);
/*  404 */         strMessage = strMessage.substring(intPosition + 1);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  410 */       throw exception;
/*      */     }
/*      */ 
/*  414 */     return vec;
/*      */   }
/*      */ 
/*      */   public static String replace(String strMain, String strFind, String strReplaceWith)
/*      */   {
/*  421 */     String strReturn = "";
/*  422 */     int intStartIndex = 0;
/*  423 */     int intEndIndex = 0;
/*      */ 
/*  425 */     if ((strMain == null) || (strMain.equals("")))
/*      */     {
/*  427 */       return "";
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/*  432 */       strReturn = strReturn + 
/*  433 */         strMain.substring(intStartIndex, intEndIndex) + 
/*  434 */         strReplaceWith;
/*  435 */       intStartIndex = intEndIndex + strFind.length();
/*      */     }
/*  430 */     while ((intEndIndex = strMain.indexOf(strFind, intStartIndex)) > -1);
/*      */ 
/*  437 */     strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
/*  438 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDate(String strYear, String strMonth, String strDay)
/*      */   {
/*  444 */     String strReturn = "";
/*  445 */     int intYear = 0;
/*  446 */     int intMonth = 0;
/*  447 */     int intDay = 0;
/*  448 */     if ((strYear != null) && (strMonth != null) && (strDay != null) && 
/*  449 */       (strYear.trim().length() > 0) && (strMonth.trim().length() > 0) && 
/*  450 */       (strDay.trim().length() > 0))
/*      */     {
/*      */       try
/*      */       {
/*  454 */         intYear = new Integer(strYear).intValue();
/*  455 */         intMonth = new Integer(strMonth).intValue();
/*  456 */         intDay = new Integer(strDay).intValue();
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  460 */         return strReturn;
/*      */       }
/*      */ 
/*  463 */       if ((intYear <= 0) || (intMonth <= 0) || (intMonth > 12) || 
/*  464 */         (intDay <= 0) || (intDay > 31))
/*      */       {
/*  466 */         strReturn = "";
/*      */       }
/*      */       else
/*      */       {
/*  470 */         strReturn = intYear;
/*      */ 
/*  472 */         if (intMonth < 10)
/*      */         {
/*  474 */           strReturn = strReturn + "/0" + intMonth;
/*      */         }
/*      */         else
/*      */         {
/*  478 */           strReturn = strReturn + "/" + intMonth;
/*      */         }
/*      */ 
/*  481 */         if (intDay < 10)
/*      */         {
/*  483 */           strReturn = strReturn + "/0" + intDay;
/*      */         }
/*      */         else
/*      */         {
/*  487 */           strReturn = strReturn + "/" + intDay;
/*      */         }
/*      */       }
/*      */     }
/*  491 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDate()
/*      */   {
/*  497 */     String strReturn = "";
/*  498 */     int intYear = Calendar.getInstance().get(1);
/*  499 */     int intMonth = Calendar.getInstance().get(2) + 1;
/*  500 */     int intDate = Calendar.getInstance().get(5);
/*  501 */     strReturn = intYear;
/*      */ 
/*  503 */     if (intMonth < 10)
/*      */     {
/*  505 */       strReturn = strReturn + "/0" + intMonth;
/*      */     }
/*      */     else
/*      */     {
/*  509 */       strReturn = strReturn + "/" + intMonth;
/*      */     }
/*      */ 
/*  512 */     if (intDate < 10)
/*      */     {
/*  514 */       strReturn = strReturn + "/0" + intDate;
/*      */     }
/*      */     else
/*      */     {
/*  518 */       strReturn = strReturn + "/" + intDate;
/*      */     }
/*  520 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDate(String strYear, String strMonth)
/*      */   {
/*  526 */     String strReturn = "";
/*  527 */     int intYear = 0;
/*  528 */     int intMonth = 0;
/*  529 */     if ((strYear != null) && (strMonth != null) && 
/*  530 */       (strYear.trim().length() > 0) && (strMonth.trim().length() > 0))
/*      */     {
/*  532 */       intYear = new Integer(strYear).intValue();
/*  533 */       intMonth = new Integer(strMonth).intValue();
/*  534 */       if ((intYear <= 0) || (intMonth <= 0) || (intMonth > 12))
/*      */       {
/*  536 */         strReturn = "";
/*      */       }
/*      */       else
/*      */       {
/*  540 */         strReturn = intYear + "/" + intMonth;
/*      */       }
/*      */     }
/*  543 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getYear(String strDate)
/*      */   {
/*  549 */     int intPosition = 0;
/*  550 */     String strReturn = "";
/*  551 */     int intYear = 0;
/*      */ 
/*  553 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  555 */       intPosition = getPos(strDate, "/", 1);
/*  556 */       if (intPosition > 0)
/*      */       {
/*  558 */         strReturn = strDate.substring(0, intPosition);
/*  559 */         intYear = new Integer(strReturn).intValue();
/*  560 */         if (intYear <= 0)
/*      */         {
/*  562 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  566 */           strReturn = intYear;
/*      */         }
/*      */ 
/*  569 */         if ((intYear < 10) && (!strReturn.equals("")))
/*      */         {
/*  571 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  575 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getYear()
/*      */   {
/*  581 */     String strReturn = "";
/*  582 */     int intYear = Calendar.getInstance().get(1);
/*  583 */     strReturn = intYear;
/*  584 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMonth(String strDate)
/*      */   {
/*  590 */     int intPosition1 = 0; int intPosition2 = 0;
/*  591 */     String strReturn = "";
/*  592 */     int intMonth = 0;
/*  593 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  595 */       intPosition1 = getPos(strDate, "/", 1);
/*  596 */       intPosition2 = getPos(strDate, "/", 2);
/*  597 */       if ((intPosition1 > 0) && (intPosition2 > intPosition1))
/*      */       {
/*  600 */         strReturn = strDate.substring(intPosition1 + 1, intPosition2);
/*      */ 
/*  602 */         intMonth = new Integer(strReturn).intValue();
/*  603 */         if ((intMonth <= 0) || (intMonth > 12))
/*      */         {
/*  605 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  609 */           strReturn = intMonth;
/*      */         }
/*      */ 
/*  612 */         if ((intMonth < 10) && (!strReturn.equals("")))
/*      */         {
/*  614 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  618 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMonth()
/*      */   {
/*  624 */     String strReturn = "";
/*  625 */     int intMonth = Calendar.getInstance().get(2) + 1;
/*  626 */     if (intMonth < 10)
/*      */     {
/*  628 */       strReturn = "0" + intMonth;
/*      */     }
/*      */     else
/*      */     {
/*  632 */       strReturn = intMonth;
/*      */     }
/*  634 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDay(String strDate)
/*      */   {
/*  640 */     int intPosition = 0;
/*  641 */     String strReturn = "";
/*  642 */     int intDay = 0;
/*  643 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  645 */       intPosition = getPos(strDate, "/", 2);
/*  646 */       if (intPosition > 0)
/*      */       {
/*  649 */         strReturn = strDate.substring(intPosition + 1);
/*      */ 
/*  651 */         intDay = new Integer(strReturn).intValue();
/*      */ 
/*  653 */         if ((intDay <= 0) || (intDay > 31))
/*      */         {
/*  655 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  659 */           strReturn = intDay;
/*      */         }
/*      */ 
/*  662 */         if ((intDay < 10) && (!strReturn.equals("")))
/*      */         {
/*  664 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  668 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDay()
/*      */   {
/*  674 */     String strReturn = "";
/*  675 */     int intDate = Calendar.getInstance().get(5);
/*  676 */     if (intDate < 10)
/*      */     {
/*  678 */       strReturn = "0" + intDate;
/*      */     }
/*      */     else
/*      */     {
/*  682 */       strReturn = intDate;
/*      */     }
/*      */ 
/*  685 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getTime()
/*      */   {
/*  691 */     return getHour() + ":" + getMinute() + ":" + 
/*  692 */       getSecond();
/*      */   }
/*      */ 
/*      */   public static String getHour()
/*      */   {
/*  698 */     String strReturn = "";
/*  699 */     int intHour = Calendar.getInstance().get(10) + 
/*  700 */       12 * 
/*  701 */       Calendar.getInstance().get(9);
/*  702 */     if (intHour < 10)
/*      */     {
/*  704 */       strReturn = "0" + intHour;
/*      */     }
/*      */     else
/*      */     {
/*  708 */       strReturn = intHour;
/*      */     }
/*      */ 
/*  711 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMinute()
/*      */   {
/*  717 */     String strReturn = "";
/*  718 */     int intMinute = Calendar.getInstance().get(12);
/*  719 */     if (intMinute < 10)
/*      */     {
/*  721 */       strReturn = "0" + intMinute;
/*      */     }
/*      */     else
/*      */     {
/*  725 */       strReturn = intMinute;
/*      */     }
/*      */ 
/*  728 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getSecond()
/*      */   {
/*  734 */     String strReturn = "";
/*  735 */     int intSecond = Calendar.getInstance().get(13);
/*  736 */     if (intSecond < 10)
/*      */     {
/*  738 */       strReturn = "0" + intSecond;
/*      */     }
/*      */     else
/*      */     {
/*  742 */       strReturn = intSecond;
/*      */     }
/*      */ 
/*  745 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaYear(String strDate)
/*      */   {
/*  751 */     int intPosition = 0;
/*  752 */     String strReturn = "";
/*  753 */     int intYear = 0;
/*      */ 
/*  755 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  757 */       intPosition = getPos(strDate, "-", 1);
/*  758 */       if (intPosition > 0)
/*      */       {
/*  760 */         strReturn = strDate.substring(0, intPosition);
/*  761 */         intYear = new Integer(strReturn).intValue();
/*  762 */         if (intYear <= 0)
/*      */         {
/*  764 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  768 */           strReturn = intYear;
/*      */         }
/*      */ 
/*  771 */         if ((intYear < 10) && (!strReturn.equals("")))
/*      */         {
/*  773 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  777 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaMonth(String strDate)
/*      */   {
/*  783 */     int intPosition1 = 0; int intPosition2 = 0;
/*  784 */     String strReturn = "";
/*  785 */     int intMonth = 0;
/*  786 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  788 */       intPosition1 = getPos(strDate, "-", 1);
/*  789 */       intPosition2 = getPos(strDate, "-", 2);
/*  790 */       if ((intPosition1 > 0) && (intPosition2 > intPosition1))
/*      */       {
/*  793 */         strReturn = strDate.substring(intPosition1 + 1, intPosition2);
/*      */ 
/*  795 */         intMonth = new Integer(strReturn).intValue();
/*  796 */         if ((intMonth <= 0) || (intMonth > 12))
/*      */         {
/*  798 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  802 */           strReturn = intMonth;
/*      */         }
/*      */ 
/*  805 */         if ((intMonth < 10) && (!strReturn.equals("")))
/*      */         {
/*  807 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  811 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaDay(String strDate)
/*      */   {
/*  817 */     int intPosition = 0;
/*  818 */     String strReturn = "";
/*  819 */     int intDay = 0;
/*  820 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  822 */       intPosition = getPos(strDate, "-", 2);
/*  823 */       if (intPosition > 0)
/*      */       {
/*  826 */         strReturn = strDate.substring(intPosition + 1);
/*      */ 
/*  828 */         intDay = new Integer(strReturn).intValue();
/*      */ 
/*  830 */         if ((intDay <= 0) || (intDay > 31))
/*      */         {
/*  832 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  836 */           strReturn = intDay;
/*      */         }
/*      */ 
/*  839 */         if ((intDay < 10) && (!strReturn.equals("")))
/*      */         {
/*  841 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  845 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getChnDate(String strDate)
/*      */   {
/*  851 */     String strReturn = getVisaYear(strDate) + "\u5E74" + getVisaMonth(strDate) + "\u6708" + getVisaDay(strDate) + "\u65E5";
/*  852 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String toHTMLFormat(String strInValue)
/*      */   {
/*  858 */     String strOutValue = "";
/*      */ 
/*  861 */     for (int i = 0; i < strInValue.length(); i++)
/*      */     {
/*  863 */       char c = strInValue.charAt(i);
/*  864 */       switch (c)
/*      */       {
/*      */       case '<':
/*  867 */         strOutValue = strOutValue + "&lt;";
/*  868 */         break;
/*      */       case '>':
/*  870 */         strOutValue = strOutValue + "&gt;";
/*  871 */         break;
/*      */       case '\n':
/*  873 */         strOutValue = strOutValue + "<br>";
/*  874 */         break;
/*      */       case '\r':
/*  876 */         break;
/*      */       case ' ':
/*  878 */         strOutValue = strOutValue + "&nbsp;";
/*  879 */         break;
/*      */       default:
/*  881 */         strOutValue = strOutValue + c;
/*      */       }
/*      */     }
/*      */ 
/*  885 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String encode(String strInValue)
/*      */   {
/*  891 */     String strOutValue = "";
/*      */ 
/*  894 */     for (int i = 0; i < strInValue.length(); i++)
/*      */     {
/*  896 */       char c = strInValue.charAt(i);
/*  897 */       switch (c)
/*      */       {
/*      */       case ':':
/*  900 */         strOutValue = strOutValue + "\uFF1A";
/*  901 */         break;
/*      */       case '|':
/*  903 */         strOutValue = strOutValue + "\u2503";
/*  904 */         break;
/*      */       case '\n':
/*  906 */         strOutValue = strOutValue + "\\n";
/*  907 */         break;
/*      */       case '\r':
/*  909 */         strOutValue = strOutValue + "\\r";
/*  910 */         break;
/*      */       case '"':
/*  912 */         strOutValue = strOutValue + "\\\"";
/*  913 */         break;
/*      */       case '\'':
/*  915 */         strOutValue = strOutValue + "\\'";
/*  916 */         break;
/*      */       case '\b':
/*  918 */         strOutValue = strOutValue + "\\b";
/*  919 */         break;
/*      */       case '\t':
/*  921 */         strOutValue = strOutValue + "\\t";
/*  922 */         break;
/*      */       case '\f':
/*  924 */         strOutValue = strOutValue + "\\f";
/*  925 */         break;
/*      */       case '\\':
/*  927 */         strOutValue = strOutValue + "\\\\";
/*  928 */         break;
/*      */       case '<':
/*  930 */         strOutValue = strOutValue + "\\<";
/*  931 */         break;
/*      */       case '>':
/*  933 */         strOutValue = strOutValue + "\\>";
/*  934 */         break;
/*      */       default:
/*  936 */         strOutValue = strOutValue + c;
/*      */       }
/*      */     }
/*      */ 
/*  940 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String encode(String[][] arr)
/*      */   {
/*  946 */     System.out.println("\u4F7F\u7528StrTool\u4E0B\u7684encode\u65B9\u6CD5\u6253\u5305");
/*  947 */     String strReturn = "";
/*  948 */     int rowcount = arr.length;
/*  949 */     int colcount = arr[0].length;
/*  950 */     int eleCount = rowcount * colcount;
/*      */ 
/*  952 */     if (eleCount != 0)
/*      */     {
/*  954 */       strReturn = "0|" + String.valueOf(rowcount) + 
/*  955 */         "^";
/*  956 */       for (int i = 0; i < rowcount; i++)
/*      */       {
/*  958 */         for (int j = 0; j < colcount; j++)
/*      */         {
/*  960 */           if (j == colcount - 1)
/*      */             continue;
/*  962 */           strReturn = strReturn + arr[i][j] + 
/*  963 */             "|";
/*      */         }
/*      */ 
/*  966 */         if (i == rowcount - 1)
/*      */           continue;
/*  968 */         strReturn = strReturn + "^";
/*      */       }
/*      */     }
/*      */ 
/*  972 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String space(int intLength)
/*      */   {
/*  978 */     StringBuffer strReturn = new StringBuffer();
/*  979 */     for (int i = 0; i < intLength; i++)
/*      */     {
/*  981 */       strReturn.append(" ");
/*      */     }
/*  983 */     return new String(strReturn);
/*      */   }
/*      */ 
/*      */   public static String space(String strValue, int intLength)
/*      */   {
/*  989 */     int strLen = strValue.length();
/*      */ 
/*  991 */     StringBuffer strReturn = new StringBuffer();
/*  992 */     if (strLen > intLength)
/*      */     {
/*  994 */       strReturn.append(strValue.substring(0, intLength));
/*      */     }
/*      */     else
/*      */     {
/*  998 */       if (strLen == 0)
/*      */       {
/* 1000 */         strReturn.append(" ");
/*      */       }
/*      */       else
/*      */       {
/* 1004 */         strReturn.append(strValue);
/*      */       }
/*      */ 
/* 1007 */       for (int i = strLen; i < intLength; i++)
/*      */       {
/* 1009 */         strReturn.append(" ");
/*      */       }
/*      */     }
/* 1012 */     return new String(strReturn);
/*      */   }
/*      */ 
/*      */   public static int getLength(String strSource)
/*      */   {
/* 1018 */     return strSource.getBytes().length;
/*      */   }
/*      */ 
/*      */   public static void copyFile(String fromFile, String toFile)
/*      */     throws FileNotFoundException, IOException, Exception
/*      */   {
/* 1025 */     FileInputStream in = new FileInputStream(fromFile);
/* 1026 */     FileOutputStream out = new FileOutputStream(toFile);
/*      */ 
/* 1028 */     byte[] b = new byte[1024];
/*      */     int len;
/* 1031 */     while ((len = in.read(b)) != -1)
/*      */     {
/*      */       int len;
/* 1033 */       out.write(b, 0, len);
/*      */     }
/* 1035 */     out.close();
/* 1036 */     in.close();
/*      */   }
/*      */ 
/*      */   public static String toUpper(int intValue)
/*      */   {
/* 1042 */     String strOutValue = "";
/* 1043 */     String[] strTemp = 
/* 1044 */       { 
/* 1045 */       "\u96F6", "\u58F9", "\u8D30", "\u53C1", "\u8086", "\u4F0D", "\u9646", "\u67D2", "\u634C", "\u7396" };
/*      */     try
/*      */     {
/* 1048 */       strOutValue = strTemp[intValue];
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1053 */       strOutValue = "";
/*      */     }
/* 1055 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String getUnit(int intValue)
/*      */   {
/* 1061 */     String strOutValue = "";
/* 1062 */     String[] strTemp = 
/* 1063 */       { 
/* 1064 */       "\u4EDF", "\u4F70", "\u62FE", "\u4EBF", "\u4EDF", "\u4F70", "\u62FE", "\u4E07", "\u4EDF", "\u4F70", 
/* 1065 */       "\u62FE", "", "", "" };
/*      */     try
/*      */     {
/* 1069 */       strOutValue = strTemp[intValue];
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1074 */       strOutValue = "";
/*      */     }
/* 1076 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String toChinese(double dblInValue)
/*      */   {
/* 1082 */     String strOutValue = "";
/* 1083 */     String strValue = new DecimalFormat("0").format(dblInValue * 100.0D);
/* 1084 */     String strTemp = "                 ";
/* 1085 */     String strThat = "";
/* 1086 */     int i = 0;
/* 1087 */     int j = 0;
/* 1088 */     int k = 0;
/*      */ 
/* 1090 */     k = strValue.length();
/* 1091 */     if (k > 14)
/*      */     {
/* 1094 */       return "";
/*      */     }
/*      */ 
/* 1097 */     strValue = strTemp.substring(0, 14 - k) + strValue;
/*      */ 
/* 1099 */     for (i = 14 - k; i < 14; i++)
/*      */     {
/* 1102 */       j = new Integer(strValue.substring(i, i + 1)).intValue();
/* 1103 */       if (j > 0)
/*      */       {
/* 1105 */         strOutValue = strOutValue + strThat + toUpper(j) + getUnit(i);
/* 1106 */         strThat = "";
/*      */       }
/*      */       else
/*      */       {
/* 1110 */         if (i == 11)
/*      */         {
/* 1112 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1115 */         if ((i == 7) && (!strValue.substring(4, 8).equals("0000")))
/*      */         {
/* 1117 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1120 */         if ((i == 3) && (!strValue.substring(0, 4).equals("0000")))
/*      */         {
/* 1122 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1125 */         if (i < 11)
/*      */         {
/* 1127 */           strThat = toUpper(0);
/*      */         }
/*      */ 
/* 1130 */         if (i != 12)
/*      */           continue;
/* 1132 */         strThat = toUpper(0);
/*      */       }
/*      */     }
/*      */ 
/* 1136 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String toChinese(int intInValue)
/*      */   {
/* 1142 */     return toChinese(intInValue);
/*      */   }
/*      */ 
/*      */   public static String toChinese(long longInValue)
/*      */   {
/* 1148 */     return toChinese(longInValue);
/*      */   }
/*      */ 
/*      */   public static String cTrim(String tStr)
/*      */   {
/* 1154 */     String ttStr = "";
/* 1155 */     if (tStr == null)
/*      */     {
/* 1157 */       ttStr = "";
/*      */     }
/*      */     else
/*      */     {
/* 1161 */       ttStr = tStr.trim();
/*      */     }
/* 1163 */     return ttStr;
/*      */   }
/*      */ 
/*      */   public static String LCh(String sourString, String cChar, int cLen)
/*      */   {
/* 1169 */     int tLen = sourString.length();
/*      */ 
/* 1171 */     String tReturn = "";
/* 1172 */     if (tLen >= cLen)
/*      */     {
/* 1174 */       return sourString;
/*      */     }
/* 1176 */     int iMax = cLen - tLen;
/* 1177 */     for (int i = 0; i < iMax; i++)
/*      */     {
/* 1179 */       tReturn = tReturn + cChar;
/*      */     }
/* 1181 */     tReturn = tReturn.trim() + sourString.trim();
/* 1182 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String RCh(String sourString, String cChar, int cLen)
/*      */   {
/* 1188 */     int tLen = sourString.length();
/*      */ 
/* 1190 */     String tReturn = "";
/* 1191 */     if (tLen >= cLen)
/*      */     {
/* 1193 */       return sourString;
/*      */     }
/* 1195 */     int iMax = cLen - tLen;
/* 1196 */     for (int i = 0; i < iMax; i++)
/*      */     {
/* 1198 */       tReturn = tReturn + cChar;
/*      */     }
/* 1200 */     tReturn = tReturn.trim() + sourString.trim();
/* 1201 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String getStr(String c_Str, int c_i, String c_Split)
/*      */   {
/* 1207 */     String t_Str1 = ""; String t_Str2 = ""; String t_strOld = "";
/* 1208 */     int i = 0; int i_Start = 0; int j_End = 0;
/* 1209 */     t_Str1 = c_Str;
/* 1210 */     t_Str2 = c_Split;
/* 1211 */     i = 0;
/*      */     try
/*      */     {
/* 1214 */       while (i < c_i)
/*      */       {
/* 1216 */         i_Start = t_Str1.indexOf(t_Str2, 0);
/* 1217 */         if (i_Start >= 0)
/*      */         {
/* 1219 */           i++;
/* 1220 */           t_strOld = t_Str1;
/* 1221 */           t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), 
/* 1222 */             t_Str1.length());
/*      */         }
/*      */         else
/*      */         {
/* 1226 */           if (i == c_i - 1)
/*      */             break;
/* 1228 */           t_Str1 = "";
/*      */ 
/* 1230 */           break;
/*      */         }
/*      */       }
/*      */ 
/* 1234 */       if (i_Start >= 0)
/*      */       {
/* 1236 */         t_Str1 = t_strOld.substring(0, i_Start);
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1241 */       t_Str1 = "";
/*      */     }
/* 1243 */     return t_Str1;
/*      */   }
/*      */ 
/*      */   public static String Conversion(String strIn, String pathname)
/*      */   {
/* 1250 */     String strOut = "";
/*      */     try
/*      */     {
/* 1254 */       ConfigInfo.SetConfigPath(pathname);
/* 1255 */       SSRS tSSRS = ConfigInfo.GetValuebyCon();
/* 1256 */       for (int i = 0; i < tSSRS.MaxRow; i++)
/*      */       {
/* 1258 */         strOut = replace(strIn, tSSRS.GetText(i + 1, 1), 
/* 1259 */           tSSRS.GetText(i + 1, 2));
/* 1260 */         if (i == tSSRS.MaxRow - 1)
/*      */           continue;
/* 1262 */         strIn = strOut;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1268 */       strOut = "";
/*      */     }
/*      */ 
/* 1276 */     return strOut;
/*      */   }
/*      */ 
/*      */   public static String replaceEx(String strMain, String strFind, String strReplaceWith)
/*      */   {
/* 1283 */     String strReturn = "";
/* 1284 */     String tStrMain = strMain.toLowerCase();
/* 1285 */     String tStrFind = strFind.toLowerCase();
/* 1286 */     int intStartIndex = 0;
/* 1287 */     int intEndIndex = 0;
/*      */ 
/* 1289 */     if ((strMain == null) || (strMain.equals("")))
/*      */     {
/* 1291 */       return "";
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/* 1296 */       strReturn = strReturn + 
/* 1297 */         strMain.substring(intStartIndex, intEndIndex) + 
/* 1298 */         strReplaceWith;
/* 1299 */       intStartIndex = intEndIndex + strFind.length();
/*      */     }
/* 1294 */     while ((intEndIndex = tStrMain.indexOf(tStrFind, intStartIndex)) > -1);
/*      */ 
/* 1301 */     strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
/* 1302 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static boolean compareString(String a, String b)
/*      */   {
/* 1311 */     return unicodeToGBK(cTrim(a)).equals(unicodeToGBK(
/* 1309 */       cTrim(b)));
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.StrTool
 * JD-Core Version:    0.6.0
 */