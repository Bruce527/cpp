/*      */ package com.sinosoft.banklns.utility;
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
/*      */ 
/*  134 */     int intPosition = 0;
/*      */ 
/*  136 */     if (strMessage.indexOf("^") < 0)
/*      */     {
/*  138 */       return strMessage;
/*      */     }
/*  140 */     strRemain = strMessage;
/*      */ 
/*  142 */     if (!strRemain.endsWith("Direct Mode!^^^"))
/*      */     {
/*      */       while (true)
/*      */       {
/*  146 */         intPosition = getPos(strRemain, "^", 3);
/*  147 */         if (intPosition < 0)
/*      */         {
/*  150 */           return strReturn;
/*      */         }
/*  152 */         strSegment = strRemain.substring(0, intPosition + 1).trim();
/*  153 */         strRemain = strRemain.substring(intPosition + 1);
/*  154 */         if (strSegment.length() < 1)
/*      */         {
/*      */           break;
/*      */         }
/*  158 */         strField = decodeStr(strSegment, "^", 1);
/*  159 */         strOperator = decodeStr(strSegment, "^", 2);
/*  160 */         strValue = decodeStr(strSegment, "^", 3);
/*  161 */         if (strValue.equals("?"))
/*      */         {
/*  163 */           strValue = " ";
/*      */         }
/*  165 */         strReturn = strReturn + " AND " + "(";
/*      */ 
/*  168 */         if (strOperator.equals(":"))
/*      */         {
/*  170 */           intPosition = strValue.indexOf(":");
/*  171 */           strReturn = strReturn + strField + " BETWEEN '" + 
/*  172 */             strValue.substring(0, intPosition).trim() + "'" + 
/*  173 */             " AND  '" + 
/*  174 */             strValue.substring(intPosition + 1).trim() + 
/*  175 */             "' ";
/*      */         }
/*  177 */         else if (strOperator.equals("*"))
/*      */         {
/*  179 */           strReturn = strReturn + strField + " matches '" + strValue + 
/*  180 */             "*' ";
/*      */         }
/*      */         else
/*      */         {
/*  184 */           strSegment = "";
/*      */           while (true)
/*      */           {
/*  187 */             intPosition = strValue.indexOf("~!");
/*  188 */             if (intPosition < 0)
/*      */             {
/*  190 */               if (strSegment.equals(""))
/*      */               {
/*  192 */                 strReturn = strReturn + strField + " " + 
/*  193 */                   strOperator + " '" + strValue + 
/*  194 */                   "' ";
/*  195 */                 break;
/*      */               }
/*      */ 
/*  198 */               strReturn = strReturn + 
/*  199 */                 strSegment + 
/*  200 */                 " OR " + 
/*  201 */                 strField + 
/*  202 */                 " " + strOperator + 
/*  203 */                 " '" + strValue.trim() + "' ";
/*      */ 
/*  205 */               break;
/*      */             }
/*  207 */             if (!strSegment.equals(""))
/*      */             {
/*  209 */               strSegment = strSegment + " OR ";
/*      */             }
/*      */ 
/*  212 */             strSegment = strSegment + 
/*  213 */               strField + 
/*  214 */               " " + strOperator + 
/*  215 */               " '" + 
/*  216 */               strValue.substring(0, intPosition).trim() + 
/*  217 */               "' ";
/*  218 */             strValue = strValue.substring(intPosition + 2);
/*      */           }
/*      */         }
/*  221 */         strReturn = strReturn + ") ";
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  227 */     strRemain = strRemain.substring(0, 
/*  228 */       strRemain.length() - 
/*  229 */       "Direct Mode!^^".length() - 
/*  230 */       "^".length());
/*  231 */     if (strRemain.trim().equals(""))
/*      */     {
/*  233 */       strRemain = "1=1";
/*      */     }
/*  235 */     strReturn = strRemain;
/*      */ 
/*  237 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String unicodeToGBK(String strOriginal)
/*      */   {
/*  243 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  247 */         if (!isGBKString(strOriginal))
/*      */         {
/*  249 */           return new String(strOriginal.getBytes("ISO8859_1"), "GBK");
/*      */         }
/*      */ 
/*  253 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  259 */         System.out.println(exception.getMessage());
/*  260 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  265 */     return "";
/*      */   }
/*      */ 
/*      */   public static String GBKToUnicode(String strOriginal)
/*      */   {
/*  274 */     return unicodeToGBK(strOriginal);
/*      */ 
/*  276 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  280 */         if (isGBKString(strOriginal))
/*      */         {
/*  282 */           return new String(strOriginal.getBytes("GBK"), "ISO8859_1");
/*      */         }
/*      */ 
/*  286 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  291 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  296 */     return null;
/*      */   }
/*      */ 
/*      */   public static String GBKToUnicode(String strOriginal, boolean realConvert)
/*      */   {
/*  303 */     if (!realConvert)
/*      */     {
/*  305 */       return unicodeToGBK(strOriginal);
/*      */     }
/*  307 */     if (strOriginal != null)
/*      */     {
/*      */       try
/*      */       {
/*  311 */         if (isGBKString(strOriginal))
/*      */         {
/*  313 */           return new String(strOriginal.getBytes("GBK"), "ISO8859_1");
/*      */         }
/*      */ 
/*  317 */         return strOriginal;
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  322 */         return strOriginal;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  327 */     return null;
/*      */   }
/*      */ 
/*      */   public static boolean isGBKString(String tStr)
/*      */   {
/*  334 */     int tlength = tStr.length();
/*  335 */     Integer t = new Integer(0);
/*  336 */     int t1 = 0;
/*  337 */     for (int i = 0; i < tlength; i++)
/*      */     {
/*  339 */       t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
/*  340 */       if (t1 > 511)
/*      */       {
/*  342 */         return true;
/*      */       }
/*      */     }
/*  345 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean isUnicodeString(String tStr)
/*      */   {
/*  351 */     int tlength = tStr.length();
/*  352 */     Integer t = new Integer(0);
/*  353 */     int t1 = 0;
/*  354 */     for (int i = 0; i < tlength; i++)
/*      */     {
/*  356 */       t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
/*  357 */       if (t1 > 511)
/*      */       {
/*  359 */         return false;
/*      */       }
/*      */     }
/*  362 */     return true;
/*      */   }
/*      */ 
/*      */   public static Vector stringToVector(String strMessage, int intCount, Class cl)
/*      */     throws Exception
/*      */   {
/*  369 */     int intFieldNum = 0;
/*  370 */     Object object = null;
/*  371 */     Vector vec = new Vector();
/*  372 */     int intPosition = 0;
/*  373 */     Class[] parameters = 
/*  374 */       { 
/*  375 */       String.class };
/*  376 */     Method method = null;
/*  377 */     Field field = null;
/*  378 */     String[] therecord = 
/*  379 */       { 
/*  380 */       new String() };
/*      */     try
/*      */     {
/*  383 */       object = cl.newInstance();
/*  384 */       method = cl.getMethod("decode", parameters);
/*  385 */       field = cl.getField("FIELDNUM");
/*  386 */       intFieldNum = field.getInt(object);
/*      */ 
/*  388 */       for (int i = 0; i < intCount; i++)
/*      */       {
/*  390 */         object = cl.newInstance();
/*  391 */         intPosition = getPos(strMessage, "|", 
/*  392 */           intFieldNum);
/*      */ 
/*  394 */         if (intPosition == strMessage.length() - 1)
/*      */         {
/*  396 */           therecord[0] = strMessage;
/*  397 */           method.invoke(object, therecord);
/*  398 */           vec.addElement(object);
/*  399 */           break;
/*      */         }
/*      */ 
/*  403 */         therecord[0] = strMessage.substring(0, intPosition + 1);
/*      */ 
/*  405 */         method.invoke(object, therecord);
/*  406 */         vec.addElement(object);
/*  407 */         strMessage = strMessage.substring(intPosition + 1);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  413 */       throw exception;
/*      */     }
/*      */ 
/*  417 */     return vec;
/*      */   }
/*      */ 
/*      */   public static String replace(String strMain, String strFind, String strReplaceWith)
/*      */   {
/*  442 */     StringBuffer sb = new StringBuffer("");
/*  443 */     int startIndex = 0;
/*  444 */     int endIndex = 0;
/*  445 */     if ((strMain == null) || (strMain.equals("")))
/*  446 */       return "";
/*      */     do
/*      */     {
/*  449 */       sb.append(strMain.substring(startIndex, endIndex));
/*  450 */       sb.append(strReplaceWith);
/*  451 */       startIndex = endIndex + strFind.length();
/*      */     }
/*  448 */     while ((endIndex = strMain.indexOf(strFind, startIndex)) > -1);
/*      */ 
/*  454 */     sb.append(strMain.substring(startIndex, strMain.length()));
/*  455 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   public static String getDate(String strYear, String strMonth, String strDay)
/*      */   {
/*  461 */     String strReturn = "";
/*  462 */     int intYear = 0;
/*  463 */     int intMonth = 0;
/*  464 */     int intDay = 0;
/*  465 */     if ((strYear != null) && (strMonth != null) && (strDay != null) && 
/*  466 */       (strYear.trim().length() > 0) && (strMonth.trim().length() > 0) && 
/*  467 */       (strDay.trim().length() > 0))
/*      */     {
/*      */       try
/*      */       {
/*  471 */         intYear = new Integer(strYear).intValue();
/*  472 */         intMonth = new Integer(strMonth).intValue();
/*  473 */         intDay = new Integer(strDay).intValue();
/*      */       }
/*      */       catch (Exception exception)
/*      */       {
/*  477 */         return strReturn;
/*      */       }
/*      */ 
/*  480 */       if ((intYear <= 0) || (intMonth <= 0) || (intMonth > 12) || 
/*  481 */         (intDay <= 0) || (intDay > 31))
/*      */       {
/*  483 */         strReturn = "";
/*      */       }
/*      */       else
/*      */       {
/*  487 */         strReturn = intYear;
/*      */ 
/*  489 */         if (intMonth < 10)
/*      */         {
/*  491 */           strReturn = strReturn + "/0" + intMonth;
/*      */         }
/*      */         else
/*      */         {
/*  495 */           strReturn = strReturn + "/" + intMonth;
/*      */         }
/*      */ 
/*  498 */         if (intDay < 10)
/*      */         {
/*  500 */           strReturn = strReturn + "/0" + intDay;
/*      */         }
/*      */         else
/*      */         {
/*  504 */           strReturn = strReturn + "/" + intDay;
/*      */         }
/*      */       }
/*      */     }
/*  508 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDate()
/*      */   {
/*  514 */     String strReturn = "";
/*  515 */     int intYear = Calendar.getInstance().get(1);
/*  516 */     int intMonth = Calendar.getInstance().get(2) + 1;
/*  517 */     int intDate = Calendar.getInstance().get(5);
/*  518 */     strReturn = intYear;
/*      */ 
/*  520 */     if (intMonth < 10)
/*      */     {
/*  522 */       strReturn = strReturn + "/0" + intMonth;
/*      */     }
/*      */     else
/*      */     {
/*  526 */       strReturn = strReturn + "/" + intMonth;
/*      */     }
/*      */ 
/*  529 */     if (intDate < 10)
/*      */     {
/*  531 */       strReturn = strReturn + "/0" + intDate;
/*      */     }
/*      */     else
/*      */     {
/*  535 */       strReturn = strReturn + "/" + intDate;
/*      */     }
/*  537 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDate(String strYear, String strMonth)
/*      */   {
/*  543 */     String strReturn = "";
/*  544 */     int intYear = 0;
/*  545 */     int intMonth = 0;
/*  546 */     if ((strYear != null) && (strMonth != null) && 
/*  547 */       (strYear.trim().length() > 0) && (strMonth.trim().length() > 0))
/*      */     {
/*  549 */       intYear = new Integer(strYear).intValue();
/*  550 */       intMonth = new Integer(strMonth).intValue();
/*  551 */       if ((intYear <= 0) || (intMonth <= 0) || (intMonth > 12))
/*      */       {
/*  553 */         strReturn = "";
/*      */       }
/*      */       else
/*      */       {
/*  557 */         strReturn = intYear + "/" + intMonth;
/*      */       }
/*      */     }
/*  560 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getYear(String strDate)
/*      */   {
/*  566 */     int intPosition = 0;
/*  567 */     String strReturn = "";
/*  568 */     int intYear = 0;
/*      */ 
/*  570 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  572 */       intPosition = getPos(strDate, "/", 1);
/*  573 */       if (intPosition > 0)
/*      */       {
/*  575 */         strReturn = strDate.substring(0, intPosition);
/*  576 */         intYear = new Integer(strReturn).intValue();
/*  577 */         if (intYear <= 0)
/*      */         {
/*  579 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  583 */           strReturn = intYear;
/*      */         }
/*      */ 
/*  586 */         if ((intYear < 10) && (!strReturn.equals("")))
/*      */         {
/*  588 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  592 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getYear()
/*      */   {
/*  598 */     String strReturn = "";
/*  599 */     int intYear = Calendar.getInstance().get(1);
/*  600 */     strReturn = intYear;
/*  601 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMonth(String strDate)
/*      */   {
/*  607 */     int intPosition1 = 0; int intPosition2 = 0;
/*  608 */     String strReturn = "";
/*  609 */     int intMonth = 0;
/*  610 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  612 */       intPosition1 = getPos(strDate, "/", 1);
/*  613 */       intPosition2 = getPos(strDate, "/", 2);
/*  614 */       if ((intPosition1 > 0) && (intPosition2 > intPosition1))
/*      */       {
/*  617 */         strReturn = strDate.substring(intPosition1 + 1, intPosition2);
/*      */ 
/*  619 */         intMonth = new Integer(strReturn).intValue();
/*  620 */         if ((intMonth <= 0) || (intMonth > 12))
/*      */         {
/*  622 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  626 */           strReturn = intMonth;
/*      */         }
/*      */ 
/*  629 */         if ((intMonth < 10) && (!strReturn.equals("")))
/*      */         {
/*  631 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  635 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMonth()
/*      */   {
/*  641 */     String strReturn = "";
/*  642 */     int intMonth = Calendar.getInstance().get(2) + 1;
/*  643 */     if (intMonth < 10)
/*      */     {
/*  645 */       strReturn = "0" + intMonth;
/*      */     }
/*      */     else
/*      */     {
/*  649 */       strReturn = intMonth;
/*      */     }
/*  651 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDay(String strDate)
/*      */   {
/*  657 */     int intPosition = 0;
/*  658 */     String strReturn = "";
/*  659 */     int intDay = 0;
/*  660 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  662 */       intPosition = getPos(strDate, "/", 2);
/*  663 */       if (intPosition > 0)
/*      */       {
/*  666 */         strReturn = strDate.substring(intPosition + 1);
/*      */ 
/*  668 */         intDay = new Integer(strReturn).intValue();
/*      */ 
/*  670 */         if ((intDay <= 0) || (intDay > 31))
/*      */         {
/*  672 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  676 */           strReturn = intDay;
/*      */         }
/*      */ 
/*  679 */         if ((intDay < 10) && (!strReturn.equals("")))
/*      */         {
/*  681 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  685 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getDay()
/*      */   {
/*  691 */     String strReturn = "";
/*  692 */     int intDate = Calendar.getInstance().get(5);
/*  693 */     if (intDate < 10)
/*      */     {
/*  695 */       strReturn = "0" + intDate;
/*      */     }
/*      */     else
/*      */     {
/*  699 */       strReturn = intDate;
/*      */     }
/*      */ 
/*  702 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getTime()
/*      */   {
/*  708 */     return getHour() + ":" + getMinute() + ":" + 
/*  709 */       getSecond();
/*      */   }
/*      */ 
/*      */   public static String getHour()
/*      */   {
/*  715 */     String strReturn = "";
/*  716 */     int intHour = Calendar.getInstance().get(10) + 
/*  717 */       12 * 
/*  718 */       Calendar.getInstance().get(9);
/*  719 */     if (intHour < 10)
/*      */     {
/*  721 */       strReturn = "0" + intHour;
/*      */     }
/*      */     else
/*      */     {
/*  725 */       strReturn = intHour;
/*      */     }
/*      */ 
/*  728 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getMinute()
/*      */   {
/*  734 */     String strReturn = "";
/*  735 */     int intMinute = Calendar.getInstance().get(12);
/*  736 */     if (intMinute < 10)
/*      */     {
/*  738 */       strReturn = "0" + intMinute;
/*      */     }
/*      */     else
/*      */     {
/*  742 */       strReturn = intMinute;
/*      */     }
/*      */ 
/*  745 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getSecond()
/*      */   {
/*  751 */     String strReturn = "";
/*  752 */     int intSecond = Calendar.getInstance().get(13);
/*  753 */     if (intSecond < 10)
/*      */     {
/*  755 */       strReturn = "0" + intSecond;
/*      */     }
/*      */     else
/*      */     {
/*  759 */       strReturn = intSecond;
/*      */     }
/*      */ 
/*  762 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaYear(String strDate)
/*      */   {
/*  768 */     int intPosition = 0;
/*  769 */     String strReturn = "";
/*  770 */     int intYear = 0;
/*      */ 
/*  772 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  774 */       intPosition = getPos(strDate, "-", 1);
/*  775 */       if (intPosition > 0)
/*      */       {
/*  777 */         strReturn = strDate.substring(0, intPosition);
/*  778 */         intYear = new Integer(strReturn).intValue();
/*  779 */         if (intYear <= 0)
/*      */         {
/*  781 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  785 */           strReturn = intYear;
/*      */         }
/*      */ 
/*  788 */         if ((intYear < 10) && (!strReturn.equals("")))
/*      */         {
/*  790 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  794 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaMonth(String strDate)
/*      */   {
/*  800 */     int intPosition1 = 0; int intPosition2 = 0;
/*  801 */     String strReturn = "";
/*  802 */     int intMonth = 0;
/*  803 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  805 */       intPosition1 = getPos(strDate, "-", 1);
/*  806 */       intPosition2 = getPos(strDate, "-", 2);
/*  807 */       if ((intPosition1 > 0) && (intPosition2 > intPosition1))
/*      */       {
/*  810 */         strReturn = strDate.substring(intPosition1 + 1, intPosition2);
/*      */ 
/*  812 */         intMonth = new Integer(strReturn).intValue();
/*  813 */         if ((intMonth <= 0) || (intMonth > 12))
/*      */         {
/*  815 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  819 */           strReturn = intMonth;
/*      */         }
/*      */ 
/*  822 */         if ((intMonth < 10) && (!strReturn.equals("")))
/*      */         {
/*  824 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  828 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String getVisaDay(String strDate)
/*      */   {
/*  834 */     int intPosition = 0;
/*  835 */     String strReturn = "";
/*  836 */     int intDay = 0;
/*  837 */     if ((strDate != null) && (strDate.trim().length() > 0))
/*      */     {
/*  839 */       intPosition = getPos(strDate, "-", 2);
/*  840 */       if (intPosition > 0)
/*      */       {
/*  843 */         strReturn = strDate.substring(intPosition + 1);
/*      */ 
/*  845 */         intDay = new Integer(strReturn).intValue();
/*      */ 
/*  847 */         if ((intDay <= 0) || (intDay > 31))
/*      */         {
/*  849 */           strReturn = "";
/*      */         }
/*      */         else
/*      */         {
/*  853 */           strReturn = intDay;
/*      */         }
/*      */ 
/*  856 */         if ((intDay < 10) && (!strReturn.equals("")))
/*      */         {
/*  858 */           strReturn = "0" + strReturn;
/*      */         }
/*      */       }
/*      */     }
/*  862 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String toHTMLFormat(String strInValue)
/*      */   {
/*  868 */     String strOutValue = "";
/*      */ 
/*  871 */     for (int i = 0; i < strInValue.length(); i++)
/*      */     {
/*  873 */       char c = strInValue.charAt(i);
/*  874 */       switch (c)
/*      */       {
/*      */       case '\n':
/*  878 */         strOutValue = strOutValue + "<BR>";
/*  879 */         break;
/*      */       case '\r':
/*  881 */         break;
/*      */       case '\013':
/*      */       case '\f':
/*      */       default:
/*  884 */         strOutValue = strOutValue + c;
/*      */       }
/*      */     }
/*      */ 
/*  888 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String encode(String strInValue)
/*      */   {
/*  894 */     String strOutValue = "";
/*      */ 
/*  897 */     for (int i = 0; i < strInValue.length(); i++)
/*      */     {
/*  899 */       char c = strInValue.charAt(i);
/*  900 */       switch (c)
/*      */       {
/*      */       case ':':
/*  904 */         strOutValue = strOutValue + "\u951F\u65A4\u62F7";
/*  905 */         break;
/*      */       case '|':
/*  907 */         strOutValue = strOutValue + "\u951F\u65A4\u62F7";
/*  908 */         break;
/*      */       case '\n':
/*  910 */         strOutValue = strOutValue + "\\n";
/*  911 */         break;
/*      */       case '\r':
/*  913 */         strOutValue = strOutValue + "\\r";
/*  914 */         break;
/*      */       case '"':
/*  916 */         strOutValue = strOutValue + "\\\"";
/*  917 */         break;
/*      */       case '\'':
/*  919 */         strOutValue = strOutValue + "\\'";
/*  920 */         break;
/*      */       case '\b':
/*  922 */         strOutValue = strOutValue + "\\b";
/*  923 */         break;
/*      */       case '\t':
/*  925 */         strOutValue = strOutValue + "\\t";
/*  926 */         break;
/*      */       case '\f':
/*  928 */         strOutValue = strOutValue + "\\f";
/*  929 */         break;
/*      */       case '\\':
/*  931 */         strOutValue = strOutValue + "\\\\";
/*  932 */         break;
/*      */       case '<':
/*  934 */         strOutValue = strOutValue + "\\<";
/*  935 */         break;
/*      */       case '>':
/*  937 */         strOutValue = strOutValue + "\\>";
/*  938 */         break;
/*      */       default:
/*  940 */         strOutValue = strOutValue + c;
/*      */       }
/*      */     }
/*      */ 
/*  944 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String encode(String[][] arr)
/*      */   {
/*  950 */     System.out.println("\u4F7F\u951F\u65A4\u62F7StrTool\u951F\u94F0\u7889\u62F7encode\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD");
/*  951 */     String strReturn = "";
/*  952 */     int rowcount = arr.length;
/*      */ 
/*  954 */     int colcount = arr[0].length;
/*      */ 
/*  956 */     int eleCount = rowcount * colcount;
/*      */ 
/*  958 */     if (eleCount != 0)
/*      */     {
/*  960 */       strReturn = "0|" + String.valueOf(rowcount) + 
/*  961 */         "^";
/*  962 */       for (int i = 0; i < rowcount; i++)
/*      */       {
/*  964 */         for (int j = 0; j < colcount; j++)
/*      */         {
/*  966 */           if (j == colcount - 1)
/*      */             continue;
/*  968 */           strReturn = strReturn + arr[i][j] + 
/*  969 */             "|";
/*      */         }
/*      */ 
/*  972 */         if (i == rowcount - 1)
/*      */           continue;
/*  974 */         strReturn = strReturn + "^";
/*      */       }
/*      */     }
/*      */ 
/*  978 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String space(int intLength)
/*      */   {
/*  984 */     StringBuffer strReturn = new StringBuffer();
/*  985 */     for (int i = 0; i < intLength; i++)
/*      */     {
/*  987 */       strReturn.append(" ");
/*      */     }
/*  989 */     return new String(strReturn);
/*      */   }
/*      */ 
/*      */   public static String space(String strValue, int intLength)
/*      */   {
/*  995 */     int strLen = strValue.length();
/*      */ 
/*  997 */     StringBuffer strReturn = new StringBuffer();
/*  998 */     if (strLen > intLength)
/*      */     {
/* 1000 */       strReturn.append(strValue.substring(0, intLength));
/*      */     }
/*      */     else
/*      */     {
/* 1004 */       if (strLen == 0)
/*      */       {
/* 1006 */         strReturn.append(" ");
/*      */       }
/*      */       else
/*      */       {
/* 1010 */         strReturn.append(strValue);
/*      */       }
/*      */ 
/* 1013 */       for (int i = strLen; i < intLength; i++)
/*      */       {
/* 1015 */         strReturn.append(" ");
/*      */       }
/*      */     }
/* 1018 */     return new String(strReturn);
/*      */   }
/*      */ 
/*      */   public static int getLength(String strSource)
/*      */   {
/* 1024 */     return strSource.getBytes().length;
/*      */   }
/*      */ 
/*      */   public static void copyFile(String fromFile, String toFile)
/*      */     throws FileNotFoundException, IOException, Exception
/*      */   {
/* 1031 */     FileInputStream in = new FileInputStream(fromFile);
/* 1032 */     FileOutputStream out = new FileOutputStream(toFile);
/*      */ 
/* 1034 */     byte[] b = new byte[1024];
/*      */     int len;
/* 1037 */     while ((len = in.read(b)) != -1)
/*      */     {
/*      */       int len;
/* 1039 */       out.write(b, 0, len);
/*      */     }
/* 1041 */     out.close();
/* 1042 */     in.close();
/*      */   }
/*      */ 
/*      */   public static String toUpper(int intValue)
/*      */   {
/* 1048 */     String strOutValue = "";
/* 1049 */     String[] strTemp = 
/* 1050 */       { 
/* 1051 */       "\u951F\u65A4\u62F7", "\u58F9", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u9646", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7" };
/*      */     try
/*      */     {
/* 1054 */       strOutValue = strTemp[intValue];
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1059 */       strOutValue = "";
/*      */     }
/* 1061 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String getUnit(int intValue)
/*      */   {
/* 1067 */     String strOutValue = "";
/* 1068 */     String[] strTemp = 
/* 1069 */       { 
/* 1070 */       "\u4EDF", "\u951F\u65A4\u62F7", "\u62FE", "\u951F\u65A4\u62F7", "\u4EDF", "\u951F\u65A4\u62F7", "\u62FE", "\u951F\u65A4\u62F7", "\u4EDF", "\u951F\u65A4\u62F7", 
/* 1071 */       "\u62FE", "", "", "" };
/*      */     try
/*      */     {
/* 1075 */       strOutValue = strTemp[intValue];
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1080 */       strOutValue = "";
/*      */     }
/* 1082 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String toChinese(double dblInValue)
/*      */   {
/* 1088 */     String strOutValue = "";
/* 1089 */     String strValue = new DecimalFormat("0").format(dblInValue * 100.0D);
/* 1090 */     String strTemp = "                 ";
/* 1091 */     String strThat = "";
/* 1092 */     int i = 0;
/* 1093 */     int j = 0;
/* 1094 */     int k = 0;
/*      */ 
/* 1096 */     k = strValue.length();
/* 1097 */     if (k > 14)
/*      */     {
/* 1100 */       return "";
/*      */     }
/*      */ 
/* 1103 */     strValue = strTemp.substring(0, 14 - k) + strValue;
/*      */ 
/* 1105 */     for (i = 14 - k; i < 14; i++)
/*      */     {
/* 1108 */       j = new Integer(strValue.substring(i, i + 1)).intValue();
/* 1109 */       if (j > 0)
/*      */       {
/* 1111 */         strOutValue = strOutValue + strThat + toUpper(j) + getUnit(i);
/* 1112 */         strThat = "";
/*      */       }
/*      */       else
/*      */       {
/* 1116 */         if (i == 11)
/*      */         {
/* 1118 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1121 */         if ((i == 7) && (!strValue.substring(4, 8).equals("0000")))
/*      */         {
/* 1123 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1126 */         if ((i == 3) && (!strValue.substring(0, 4).equals("0000")))
/*      */         {
/* 1128 */           strOutValue = strOutValue + getUnit(i);
/*      */         }
/*      */ 
/* 1131 */         if (i < 11)
/*      */         {
/* 1133 */           strThat = toUpper(0);
/*      */         }
/*      */ 
/* 1136 */         if (i != 12)
/*      */           continue;
/* 1138 */         strThat = toUpper(0);
/*      */       }
/*      */     }
/*      */ 
/* 1142 */     return strOutValue;
/*      */   }
/*      */ 
/*      */   public static String toChinese(int intInValue)
/*      */   {
/* 1148 */     return toChinese(intInValue);
/*      */   }
/*      */ 
/*      */   public static String toChinese(long longInValue)
/*      */   {
/* 1154 */     return toChinese(longInValue);
/*      */   }
/*      */ 
/*      */   public static String cTrim(String tStr)
/*      */   {
/* 1160 */     String ttStr = "";
/* 1161 */     if (tStr == null)
/*      */     {
/* 1163 */       ttStr = "";
/*      */     }
/*      */     else
/*      */     {
/* 1167 */       ttStr = tStr.trim();
/*      */     }
/* 1169 */     return ttStr;
/*      */   }
/*      */ 
/*      */   public static String LCh(String sourString, String cChar, int cLen)
/*      */   {
/* 1175 */     int tLen = sourString.length();
/*      */ 
/* 1177 */     String tReturn = "";
/* 1178 */     if (tLen >= cLen)
/*      */     {
/* 1180 */       return sourString;
/*      */     }
/* 1182 */     int iMax = cLen - tLen;
/* 1183 */     for (int i = 0; i < iMax; i++)
/*      */     {
/* 1185 */       tReturn = tReturn + cChar;
/*      */     }
/* 1187 */     tReturn = tReturn.trim() + sourString.trim();
/* 1188 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String RCh(String sourString, String cChar, int cLen)
/*      */   {
/* 1194 */     int tLen = sourString.length();
/*      */ 
/* 1196 */     String tReturn = "";
/* 1197 */     if (tLen >= cLen)
/*      */     {
/* 1199 */       return sourString;
/*      */     }
/* 1201 */     int iMax = cLen - tLen;
/* 1202 */     for (int i = 0; i < iMax; i++)
/*      */     {
/* 1204 */       tReturn = tReturn + cChar;
/*      */     }
/* 1206 */     tReturn = tReturn.trim() + sourString.trim();
/* 1207 */     return tReturn;
/*      */   }
/*      */ 
/*      */   public static String getStr(String c_Str, int c_i, String c_Split)
/*      */   {
/* 1213 */     String t_Str1 = ""; String t_Str2 = ""; String t_strOld = "";
/* 1214 */     int i = 0; int i_Start = 0; int j_End = 0;
/* 1215 */     t_Str1 = c_Str;
/* 1216 */     t_Str2 = c_Split;
/* 1217 */     i = 0;
/*      */     try
/*      */     {
/* 1220 */       while (i < c_i)
/*      */       {
/* 1222 */         i_Start = t_Str1.indexOf(t_Str2, 0);
/* 1223 */         if (i_Start >= 0)
/*      */         {
/* 1225 */           i++;
/* 1226 */           t_strOld = t_Str1;
/* 1227 */           t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), 
/* 1228 */             t_Str1.length());
/*      */         }
/*      */         else
/*      */         {
/* 1232 */           if (i == c_i - 1)
/*      */             break;
/* 1234 */           t_Str1 = "";
/*      */ 
/* 1236 */           break;
/*      */         }
/*      */       }
/*      */ 
/* 1240 */       if (i_Start >= 0)
/*      */       {
/* 1242 */         t_Str1 = t_strOld.substring(0, i_Start);
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1247 */       t_Str1 = "";
/*      */     }
/* 1249 */     return t_Str1;
/*      */   }
/*      */ 
/*      */   public static String Conversion(String strIn, String pathname)
/*      */   {
/* 1256 */     String strOut = "";
/*      */     try
/*      */     {
/* 1260 */       ConfigInfo.SetConfigPath(pathname);
/* 1261 */       SSRS tSSRS = ConfigInfo.GetValuebyCon();
/* 1262 */       for (int i = 0; i < tSSRS.MaxRow; i++)
/*      */       {
/* 1264 */         strOut = replace(strIn, tSSRS.GetText(i + 1, 1), 
/* 1265 */           tSSRS.GetText(i + 1, 2));
/* 1266 */         if (i == tSSRS.MaxRow - 1)
/*      */           continue;
/* 1268 */         strIn = strOut;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1274 */       strOut = "";
/*      */     }
/*      */ 
/* 1282 */     return strOut;
/*      */   }
/*      */ 
/*      */   public static String replaceEx(String strMain, String strFind, String strReplaceWith)
/*      */   {
/* 1289 */     String strReturn = "";
/* 1290 */     String tStrMain = strMain.toLowerCase();
/* 1291 */     String tStrFind = strFind.toLowerCase();
/* 1292 */     int intStartIndex = 0;
/* 1293 */     int intEndIndex = 0;
/*      */ 
/* 1295 */     if ((strMain == null) || (strMain.equals("")))
/*      */     {
/* 1297 */       return "";
/*      */     }
/*      */ 
/*      */     do
/*      */     {
/* 1302 */       strReturn = strReturn + 
/* 1303 */         strMain.substring(intStartIndex, intEndIndex) + 
/* 1304 */         strReplaceWith;
/* 1305 */       intStartIndex = intEndIndex + strFind.length();
/*      */     }
/* 1300 */     while ((intEndIndex = tStrMain.indexOf(tStrFind, intStartIndex)) > -1);
/*      */ 
/* 1307 */     strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
/* 1308 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static boolean compareString(String a, String b)
/*      */   {
/* 1317 */     return unicodeToGBK(cTrim(a)).equals(unicodeToGBK(
/* 1315 */       cTrim(b)));
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.StrTool
 * JD-Core Version:    0.6.0
 */