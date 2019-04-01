/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class ValidateTools
/*     */ {
/*  15 */   public static String validString1ErrorMessage = "\u8F93\u5165\u9519\u8BEF\uFF0C\u53EF\u4EE5\u5305\u542B\u4E2D\u82F1\u6587\uFF0C\u6570\u5B57\u53CA\u201C-\u201D\u201C_\u201D\u201C#\u201D\u7B49\u5B57\u7B26";
/*  16 */   public static String validZipCodeErrorMessage = "\u8F93\u5165\u5E94\u8BE5\u4E3A6\u4F4D\u6570\u5B57";
/*  17 */   public static String validTelCode2ErrorMessage = "\u957F\u5EA6\u4E3A6-19\u4F4D\u6570\u5B57";
/*     */ 
/*  19 */   public static int calcAge(String aBirthday) { if (aBirthday == null)
/*  20 */       return -1;
/*  21 */     if (!isDate(aBirthday))
/*  22 */       return -1;
/*  23 */     int iAge = 0;
/*  24 */     Calendar today = new GregorianCalendar();
/*  25 */     int iThisYear = today.get(1);
/*  26 */     int iThisMonth = today.get(2);
/*  27 */     int iThisDate = today.get(5);
/*  28 */     Calendar birthday = Calendar.getInstance();
/*  29 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  30 */     Date inputDate = null;
/*     */     try {
/*  32 */       inputDate = df.parse(aBirthday);
/*     */     } catch (ParseException ex) {
/*  34 */       ex.printStackTrace();
/*  35 */       return -1;
/*     */     }
/*  37 */     birthday.setTime(inputDate);
/*  38 */     int iBirthYear = birthday.get(1);
/*  39 */     int iBirthMonth = birthday.get(2);
/*  40 */     int iBirthDate = birthday.get(5);
/*  41 */     iAge = iThisYear - iBirthYear;
/*  42 */     if (iAge >= 0) {
/*  43 */       if (iThisMonth != iBirthMonth) {
/*  44 */         if (iThisMonth < iBirthMonth)
/*  45 */           iAge--;
/*     */       }
/*  47 */       else if (iThisDate < iBirthDate) {
/*  48 */         iAge--;
/*     */       }
/*     */     }
/*     */ 
/*  52 */     return iAge; }
/*     */ 
/*     */   public static boolean isDate(String aValue) {
/*  55 */     if (aValue == null)
/*  56 */       return false;
/*  57 */     if (!aValue.equals("")) {
/*  58 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*     */       try {
/*  60 */         Date tempDate = df.parse(aValue);
/*  61 */         String sTemp = df.format(tempDate);
/*  62 */         if (aValue.length() < 10) {
/*  63 */           String[] temp = aValue.split("-");
/*  64 */           if (temp.length == 3) {
/*  65 */             if (temp[0].length() < 4)
/*  66 */               return false;
/*  67 */             if (temp[1].length() < 2)
/*  68 */               temp[1] = ("0" + temp[1]);
/*  69 */             if (temp[2].length() < 4)
/*  70 */               temp[2] = ("0" + temp[2]);
/*  71 */             aValue = temp[0] + "-" + temp[1] + "-" + temp[2];
/*     */           }
/*     */         }
/*     */ 
/*  75 */         return sTemp.equals(aValue);
/*     */       }
/*     */       catch (ParseException ex)
/*     */       {
/*  80 */         ex.printStackTrace();
/*  81 */         return false;
/*     */       }
/*     */     }
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isNumeric(String aValue)
/*     */   {
/*  89 */     if (aValue == null)
/*  90 */       return false;
/*  91 */     if (!"".equals(aValue)) {
/*  92 */       Pattern pattern = Pattern.compile("[0-9]*\\.{0,1}[0-9]{1,2}");
/*  93 */       Matcher isNum = pattern.matcher(aValue);
/*     */ 
/*  95 */       return isNum.matches();
/*     */     }
/*     */ 
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidPwd(String aValue)
/*     */   {
/* 105 */     if (aValue == null)
/* 106 */       return false;
/* 107 */     if (!"".equals(aValue)) {
/* 108 */       Pattern pattern = 
/* 109 */         Pattern.compile("([0-9]+[a-zA-Z]+)*|([a-zA-Z]+[0-9]+)*");
/* 110 */       Matcher isPwd = pattern.matcher(aValue);
/* 111 */       if (!isPwd.matches()) {
/* 112 */         return false;
/*     */       }
/*     */ 
/* 115 */       return aValue.length() == 6;
/*     */     }
/*     */ 
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidEMail(String aValue)
/*     */   {
/* 126 */     if (aValue == null)
/* 127 */       return false;
/* 128 */     if (!"".equals(aValue)) {
/* 129 */       Pattern pattern = 
/* 130 */         Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
/* 131 */       Matcher isEMail = pattern.matcher(aValue);
/*     */ 
/* 133 */       return isEMail.matches();
/*     */     }
/*     */ 
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidTelePhone(String aValue)
/*     */   {
/* 143 */     if (aValue == null)
/* 144 */       return false;
/* 145 */     if (!"".equals(aValue)) {
/* 146 */       Pattern pattern = 
/* 147 */         Pattern.compile("(\\d{3}-\\d{8}|\\d{4}-\\d{7,8}|\\d{7,11})+([/]{0,1}\\d)*([-]{0,1}\\d)*");
/* 148 */       Matcher isTelePhone = pattern.matcher(aValue);
/*     */ 
/* 150 */       return isTelePhone.matches();
/*     */     }
/*     */ 
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidString1(String aValue)
/*     */   {
/* 161 */     if (aValue == null)
/* 162 */       return false;
/* 163 */     if (!"".equals(aValue)) {
/* 164 */       Pattern pattern = 
/* 165 */         Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#.])*$");
/* 166 */       Matcher isName = pattern.matcher(aValue);
/*     */ 
/* 168 */       return isName.matches();
/*     */     }
/*     */ 
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidString3(String aValue)
/*     */   {
/* 178 */     if (aValue == null)
/* 179 */       return false;
/* 180 */     if (!"".equals(aValue)) {
/* 181 */       Pattern pattern = 
/* 182 */         Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#\uFF08\uFF09().])*$");
/* 183 */       Matcher isName = pattern.matcher(aValue);
/*     */ 
/* 185 */       return isName.matches();
/*     */     }
/*     */ 
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidString4(String aValue)
/*     */   {
/* 195 */     if (aValue == null)
/* 196 */       return false;
/* 197 */     if (!"".equals(aValue)) {
/* 198 */       Pattern pattern = 
/* 199 */         Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#\uFFFD\uFFFD\uFFFD\uFFFD().@])*$");
/* 200 */       Matcher isName = pattern.matcher(aValue);
/*     */ 
/* 202 */       return isName.matches();
/*     */     }
/*     */ 
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidString2(String aValue)
/*     */   {
/* 212 */     if (aValue == null)
/* 213 */       return false;
/* 214 */     if (!"".equals(aValue)) {
/* 215 */       Pattern pattern = Pattern.compile("^[A-Za-z0-9]+");
/* 216 */       Matcher isName = pattern.matcher(aValue);
/*     */ 
/* 218 */       return isName.matches();
/*     */     }
/*     */ 
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidZipCode(String aValue)
/*     */   {
/* 228 */     if (aValue == null)
/* 229 */       return false;
/* 230 */     if (!"".equals(aValue)) {
/* 231 */       Pattern pattern = Pattern.compile("\\d{6}");
/* 232 */       Matcher isZipCode = pattern.matcher(aValue);
/*     */ 
/* 234 */       return isZipCode.matches();
/*     */     }
/*     */ 
/* 239 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidDate(String aValue)
/*     */   {
/* 244 */     if (aValue == null)
/* 245 */       return false;
/* 246 */     if (!"".equals(aValue)) {
/* 247 */       Calendar today = new GregorianCalendar();
/* 248 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*     */       try {
/* 250 */         Date inputDate = df.parse(aValue);
/* 251 */         if (df.format(inputDate).equals(aValue)) {
/* 252 */           return today.getTime().after(inputDate);
/*     */         }
/* 254 */         return false;
/*     */       }
/*     */       catch (ParseException e) {
/* 257 */         e.printStackTrace();
/* 258 */         return false;
/*     */       }
/*     */     }
/* 261 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidDate(String aValue1, String aValue2)
/*     */   {
/* 266 */     if ((aValue1 == null) && (aValue2 == null)) return false;
/* 267 */     if ((!isDate(aValue1)) || (!isDate(aValue2))) return false;
/* 268 */     if ((!"".equals(aValue1)) && (!"".equals(aValue2))) {
/* 269 */       if (aValue1.equals(aValue2)) {
/* 270 */         return true;
/*     */       }
/* 272 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*     */       try {
/* 274 */         Date inputDate1 = df.parse(aValue1);
/* 275 */         Date inputDate2 = df.parse(aValue2);
/* 276 */         return inputDate2.after(inputDate1);
/*     */       } catch (ParseException e) {
/* 278 */         e.printStackTrace();
/* 279 */         return false;
/*     */       }
/*     */     }
/* 282 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidTelCode2(String aValue) {
/* 286 */     if (aValue == null)
/* 287 */       return false;
/* 288 */     if (!"".equals(aValue)) {
/* 289 */       Pattern pattern = Pattern.compile("[0-9]\\d{6,19}");
/* 290 */       Matcher isZipCode = pattern.matcher(aValue);
/*     */ 
/* 292 */       return isZipCode.matches();
/*     */     }
/*     */ 
/* 297 */     return true;
/*     */   }
/*     */ 
/*     */   public static String isValidIDNo(String aIDNo, String aBirthday, String aSex) {
/* 301 */     if ((aIDNo == null) || (aBirthday == null) || (aSex == null))
/* 302 */       return "\u975E\u6CD5\u53C2\u6570\uFF0C\u8EAB\u4EFD\u8BC1\u53F7\u6216\u751F\u65E5\u65E5\u671F\u6216\u6027\u522B\u4E3Anull";
/* 303 */     String tmpStr = "";
/* 304 */     int tmpInt = 0;
/* 305 */     String sReturn = "";
/*     */ 
/* 307 */     aIDNo = aIDNo.trim();
/* 308 */     aBirthday = aBirthday.trim();
/* 309 */     aSex = aSex.trim();
/*     */ 
/* 312 */     if ((aIDNo.length() != 15) && (aIDNo.length() != 18)) {
/* 313 */       sReturn = "\u8F93\u5165\u7684\u8EAB\u4EFD\u8BC1\u53F7\u4F4D\u6570\u9519\u8BEF";
/* 314 */       return sReturn;
/*     */     }
/*     */ 
/* 317 */     if (aIDNo.length() == 15) {
/* 318 */       Pattern pattern = Pattern.compile("[0-9]{15}");
/*     */ 
/* 320 */       Matcher isNum = pattern.matcher(aIDNo);
/* 321 */       if (!isNum.matches()) {
/* 322 */         sReturn = "\u8EAB\u4EFD\u8BC1\u683C\u5F0F\u9519\u8BEF";
/* 323 */         return sReturn;
/*     */       }
/*     */     }
/* 326 */     if (aIDNo.length() == 18) {
/* 327 */       Pattern pattern = Pattern.compile("[0-9]{17}[a-zA-Z0-9]{1}");
/*     */ 
/* 329 */       Matcher isNum = pattern.matcher(aIDNo);
/* 330 */       if (!isNum.matches()) {
/* 331 */         sReturn = "\u8EAB\u4EFD\u8BC1\u683C\u5F0F\u9519\u8BEF";
/* 332 */         return sReturn;
/*     */       }
/*     */     }
/*     */ 
/* 336 */     if ((!"".equals(aBirthday)) && 
/* 337 */       (!isDate(aBirthday))) {
/* 338 */       return "\u751F\u65E5\u8F93\u5165\u9519\u8BEF";
/*     */     }
/*     */ 
/* 341 */     if ((!"0".equals(aSex)) && (!"1".equals(aSex))) {
/* 342 */       sReturn = "\u8F93\u5165\u7684\u6027\u522B\u4E0D\u660E\u786E";
/* 343 */       return sReturn;
/*     */     }
/*     */ 
/* 346 */     if (aIDNo.length() == 15) {
/* 347 */       tmpStr = aIDNo.substring(6, 12);
/* 348 */       tmpStr = "19" + tmpStr;
/* 349 */       tmpStr = tmpStr.substring(0, 4) + "-" + tmpStr.substring(4, 6) + 
/* 350 */         "-" + tmpStr.substring(6);
/* 351 */       if (isDate(tmpStr)) {
/* 352 */         if ((aBirthday.equals(tmpStr)) || ("".equals(aBirthday))) {
/* 353 */           if (aSex.equals("0"))
/*     */           {
/* 355 */             tmpInt = Integer.parseInt(aIDNo.substring(14));
/* 356 */             tmpInt %= 2;
/* 357 */             if (tmpInt == 0) {
/* 358 */               sReturn = "\u8F93\u5165\u7684\u6027\u522B\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 359 */               return sReturn;
/*     */             }
/*     */           }
/*     */           else {
/* 363 */             tmpInt = Integer.parseInt(aIDNo.substring(14));
/* 364 */             tmpInt %= 2;
/* 365 */             if (tmpInt != 0) {
/* 366 */               sReturn = "\u8F93\u5165\u7684\u6027\u522B\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 367 */               return sReturn;
/*     */             }
/*     */           }
/*     */         } else {
/* 371 */           sReturn = "\u8F93\u5165\u7684\u751F\u65E5\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 372 */           return sReturn;
/*     */         }
/*     */       } else {
/* 375 */         sReturn = "\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\u4E2D\u7684\u751F\u65E5\u65E5\u671F\u4FE1\u606F\u4E0D\u6B63\u786E";
/* 376 */         return sReturn;
/*     */       }
/*     */     } else {
/* 378 */       if (aIDNo.length() == 18) {
/* 379 */         tmpStr = aIDNo.substring(6, 14);
/* 380 */         tmpStr = tmpStr.substring(0, 4) + "-" + tmpStr.substring(4, 6) + 
/* 381 */           "-" + tmpStr.substring(6);
/* 382 */         if (isDate(tmpStr)) {
/* 383 */           if ((aBirthday.equals(tmpStr)) || ("".equals(aBirthday))) {
/* 384 */             if (aSex.equals("0")) {
/* 385 */               tmpInt = Integer.parseInt(aIDNo.substring(16, 17));
/* 386 */               tmpInt %= 2;
/* 387 */               if (tmpInt == 0) {
/* 388 */                 sReturn = "\u8F93\u5165\u7684\u6027\u522B\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 389 */                 return sReturn;
/*     */               }
/*     */             } else {
/* 392 */               tmpInt = Integer.parseInt(aIDNo.substring(16, 17));
/*     */ 
/* 394 */               tmpInt %= 2;
/* 395 */               if (tmpInt != 0) {
/* 396 */                 sReturn = "\u8F93\u5165\u7684\u6027\u522B\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 397 */                 return sReturn;
/*     */               }
/*     */             }
/*     */           } else {
/* 401 */             sReturn = "\u8F93\u5165\u7684\u751F\u65E5\u4E0E\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4FE1\u606F\u4E0D\u4E00\u81F4";
/* 402 */             return sReturn;
/*     */           }
/*     */         } else {
/* 405 */           sReturn = "\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\u4E2D\u7684\u751F\u65E5\u65E5\u671F\u4FE1\u606F\u4E0D\u6B63\u786E";
/* 406 */           return sReturn;
/*     */         }
/*     */ 
/* 410 */         return sReturn;
/*     */       }
/*     */ 
/* 413 */       sReturn = "\u8F93\u5165\u7684\u8EAB\u4EFD\u8BC1\u53F7\u7684\u4F4D\u6570\u4E0D\u5BF9";
/* 414 */       return sReturn;
/*     */     }
/* 416 */     return sReturn;
/*     */   }
/*     */ 
/*     */   public static boolean isExistUselessChar(String aValue)
/*     */   {
/* 421 */     if (aValue == null)
/* 422 */       return false;
/* 423 */     if (!"".equals(aValue))
/*     */     {
/* 425 */       return aValue.indexOf("'") == -1;
/*     */     }
/*     */ 
/* 430 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.ValidateTools
 * JD-Core Version:    0.6.0
 */