/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.CaseFileDownlLogDB;
/*     */ import com.sinosoft.map.lis.pubfun.FDate;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class CaseFileDownlLogSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String id;
/*     */   private Date fileDate;
/*     */   private Date fDownDate;
/*     */   private String fDownTime;
/*     */   private String flag;
/*     */   private Date modifyDate;
/*     */   private String modityTime;
/*     */   private String lastOperator;
/*     */   private Date bY1;
/*     */   private Date bY2;
/*     */   private String bY3;
/*     */   private String bY4;
/*     */   public static final int FIELDNUM = 12;
/*     */   private static String[] PK;
/*  48 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public CaseFileDownlLogSchema()
/*     */   {
/*  55 */     this.mErrors = new CErrors();
/*     */ 
/*  57 */     String[] pk = new String[1];
/*  58 */     pk[0] = "Id";
/*     */ 
/*  60 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  67 */     CaseFileDownlLogSchema cloned = (CaseFileDownlLogSchema)super.clone();
/*  68 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  69 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  70 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  76 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/*  81 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String aId) {
/*  85 */     this.id = aId;
/*     */   }
/*     */ 
/*     */   public String getFileDate() {
/*  89 */     if (this.fileDate != null) {
/*  90 */       return this.fDate.getString(this.fileDate);
/*     */     }
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   public void setFileDate(Date aFileDate) {
/*  96 */     this.fileDate = aFileDate;
/*     */   }
/*     */ 
/*     */   public void setFileDate(String aFileDate) {
/* 100 */     if ((aFileDate != null) && (!aFileDate.equals("")))
/*     */     {
/* 102 */       this.fileDate = this.fDate.getDate(aFileDate);
/*     */     }
/*     */     else
/* 105 */       this.fileDate = null;
/*     */   }
/*     */ 
/*     */   public String getFDownDate()
/*     */   {
/* 110 */     if (this.fDownDate != null) {
/* 111 */       return this.fDate.getString(this.fDownDate);
/*     */     }
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   public void setFDownDate(Date aFDownDate) {
/* 117 */     this.fDownDate = aFDownDate;
/*     */   }
/*     */ 
/*     */   public void setFDownDate(String aFDownDate) {
/* 121 */     if ((aFDownDate != null) && (!aFDownDate.equals("")))
/*     */     {
/* 123 */       this.fDownDate = this.fDate.getDate(aFDownDate);
/*     */     }
/*     */     else
/* 126 */       this.fDownDate = null;
/*     */   }
/*     */ 
/*     */   public String getFDownTime()
/*     */   {
/* 131 */     return this.fDownTime;
/*     */   }
/*     */ 
/*     */   public void setFDownTime(String aFDownTime) {
/* 135 */     this.fDownTime = aFDownTime;
/*     */   }
/*     */ 
/*     */   public String getFlag() {
/* 139 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(String aFlag) {
/* 143 */     this.flag = aFlag;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 147 */     if (this.modifyDate != null) {
/* 148 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 154 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 158 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 160 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 163 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModityTime()
/*     */   {
/* 168 */     return this.modityTime;
/*     */   }
/*     */ 
/*     */   public void setModityTime(String aModityTime) {
/* 172 */     this.modityTime = aModityTime;
/*     */   }
/*     */ 
/*     */   public String getLastOperator() {
/* 176 */     return this.lastOperator;
/*     */   }
/*     */ 
/*     */   public void setLastOperator(String aLastOperator) {
/* 180 */     this.lastOperator = aLastOperator;
/*     */   }
/*     */ 
/*     */   public String getBY1() {
/* 184 */     if (this.bY1 != null) {
/* 185 */       return this.fDate.getString(this.bY1);
/*     */     }
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */   public void setBY1(Date aBY1) {
/* 191 */     this.bY1 = aBY1;
/*     */   }
/*     */ 
/*     */   public void setBY1(String aBY1) {
/* 195 */     if ((aBY1 != null) && (!aBY1.equals("")))
/*     */     {
/* 197 */       this.bY1 = this.fDate.getDate(aBY1);
/*     */     }
/*     */     else
/* 200 */       this.bY1 = null;
/*     */   }
/*     */ 
/*     */   public String getBY2()
/*     */   {
/* 205 */     if (this.bY2 != null) {
/* 206 */       return this.fDate.getString(this.bY2);
/*     */     }
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */   public void setBY2(Date aBY2) {
/* 212 */     this.bY2 = aBY2;
/*     */   }
/*     */ 
/*     */   public void setBY2(String aBY2) {
/* 216 */     if ((aBY2 != null) && (!aBY2.equals("")))
/*     */     {
/* 218 */       this.bY2 = this.fDate.getDate(aBY2);
/*     */     }
/*     */     else
/* 221 */       this.bY2 = null;
/*     */   }
/*     */ 
/*     */   public String getBY3()
/*     */   {
/* 226 */     return this.bY3;
/*     */   }
/*     */ 
/*     */   public void setBY3(String aBY3) {
/* 230 */     this.bY3 = aBY3;
/*     */   }
/*     */ 
/*     */   public String getBY4() {
/* 234 */     return this.bY4;
/*     */   }
/*     */ 
/*     */   public void setBY4(String aBY4) {
/* 238 */     this.bY4 = aBY4;
/*     */   }
/*     */ 
/*     */   public void setSchema(CaseFileDownlLogSchema aCaseFileDownlLogSchema)
/*     */   {
/* 244 */     this.id = aCaseFileDownlLogSchema.getId();
/* 245 */     this.fileDate = this.fDate.getDate(aCaseFileDownlLogSchema.getFileDate());
/* 246 */     this.fDownDate = this.fDate.getDate(aCaseFileDownlLogSchema.getFDownDate());
/* 247 */     this.fDownTime = aCaseFileDownlLogSchema.getFDownTime();
/* 248 */     this.flag = aCaseFileDownlLogSchema.getFlag();
/* 249 */     this.modifyDate = this.fDate.getDate(aCaseFileDownlLogSchema.getModifyDate());
/* 250 */     this.modityTime = aCaseFileDownlLogSchema.getModityTime();
/* 251 */     this.lastOperator = aCaseFileDownlLogSchema.getLastOperator();
/* 252 */     this.bY1 = this.fDate.getDate(aCaseFileDownlLogSchema.getBY1());
/* 253 */     this.bY2 = this.fDate.getDate(aCaseFileDownlLogSchema.getBY2());
/* 254 */     this.bY3 = aCaseFileDownlLogSchema.getBY3();
/* 255 */     this.bY4 = aCaseFileDownlLogSchema.getBY4();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 264 */       if (rs.getString("Id") == null)
/* 265 */         this.id = null;
/*     */       else {
/* 267 */         this.id = rs.getString("Id").trim();
/*     */       }
/* 269 */       this.fileDate = rs.getDate("FileDate");
/* 270 */       this.fDownDate = rs.getDate("FDownDate");
/* 271 */       if (rs.getString("FDownTime") == null)
/* 272 */         this.fDownTime = null;
/*     */       else {
/* 274 */         this.fDownTime = rs.getString("FDownTime").trim();
/*     */       }
/* 276 */       if (rs.getString("Flag") == null)
/* 277 */         this.flag = null;
/*     */       else {
/* 279 */         this.flag = rs.getString("Flag").trim();
/*     */       }
/* 281 */       this.modifyDate = rs.getDate("ModifyDate");
/* 282 */       if (rs.getString("ModityTime") == null)
/* 283 */         this.modityTime = null;
/*     */       else {
/* 285 */         this.modityTime = rs.getString("ModityTime").trim();
/*     */       }
/* 287 */       if (rs.getString("LastOperator") == null)
/* 288 */         this.lastOperator = null;
/*     */       else {
/* 290 */         this.lastOperator = rs.getString("LastOperator").trim();
/*     */       }
/* 292 */       this.bY1 = rs.getDate("BY1");
/* 293 */       this.bY2 = rs.getDate("BY2");
/* 294 */       if (rs.getString("BY3") == null)
/* 295 */         this.bY3 = null;
/*     */       else {
/* 297 */         this.bY3 = rs.getString("BY3").trim();
/*     */       }
/* 299 */       if (rs.getString("BY4") == null)
/* 300 */         this.bY4 = null;
/*     */       else {
/* 302 */         this.bY4 = rs.getString("BY4").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 307 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684CaseFileDownlLog\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 309 */       CError tError = new CError();
/* 310 */       tError.moduleName = "CaseFileDownlLogSchema";
/* 311 */       tError.functionName = "setSchema";
/* 312 */       tError.errorMessage = sqle.toString();
/* 313 */       this.mErrors.addOneError(tError);
/* 314 */       return false;
/*     */     }
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */   public CaseFileDownlLogSchema getSchema()
/*     */   {
/* 321 */     CaseFileDownlLogSchema aCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/* 322 */     aCaseFileDownlLogSchema.setSchema(this);
/* 323 */     return aCaseFileDownlLogSchema;
/*     */   }
/*     */ 
/*     */   public CaseFileDownlLogDB getDB()
/*     */   {
/* 328 */     CaseFileDownlLogDB aDBOper = new CaseFileDownlLogDB();
/* 329 */     aDBOper.setSchema(this);
/* 330 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 337 */     StringBuffer strReturn = new StringBuffer(256);
/* 338 */     strReturn.append(StrTool.cTrim(this.id)); strReturn.append("|");
/* 339 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.fileDate))); strReturn.append("|");
/* 340 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.fDownDate))); strReturn.append("|");
/* 341 */     strReturn.append(StrTool.cTrim(this.fDownTime)); strReturn.append("|");
/* 342 */     strReturn.append(StrTool.cTrim(this.flag)); strReturn.append("|");
/* 343 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 344 */     strReturn.append(StrTool.cTrim(this.modityTime)); strReturn.append("|");
/* 345 */     strReturn.append(StrTool.cTrim(this.lastOperator)); strReturn.append("|");
/* 346 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.bY1))); strReturn.append("|");
/* 347 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.bY2))); strReturn.append("|");
/* 348 */     strReturn.append(StrTool.cTrim(this.bY3)); strReturn.append("|");
/* 349 */     strReturn.append(StrTool.cTrim(this.bY4));
/* 350 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 358 */       this.id = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 359 */       this.fileDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|"));
/* 360 */       this.fDownDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|"));
/* 361 */       this.fDownTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 362 */       this.flag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 363 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 364 */       this.modityTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 365 */       this.lastOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 366 */       this.bY1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/* 367 */       this.bY2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 368 */       this.bY3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 369 */       this.bY4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "CaseFileDownlLogSchema";
/* 376 */       tError.functionName = "decode";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */ 
/* 380 */       return false;
/*     */     }
/* 382 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 388 */     String strReturn = "";
/* 389 */     if (FCode.equalsIgnoreCase("id"))
/*     */     {
/* 391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.id));
/*     */     }
/* 393 */     if (FCode.equalsIgnoreCase("fileDate"))
/*     */     {
/* 395 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getFileDate()));
/*     */     }
/* 397 */     if (FCode.equalsIgnoreCase("fDownDate"))
/*     */     {
/* 399 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getFDownDate()));
/*     */     }
/* 401 */     if (FCode.equalsIgnoreCase("fDownTime"))
/*     */     {
/* 403 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fDownTime));
/*     */     }
/* 405 */     if (FCode.equalsIgnoreCase("flag"))
/*     */     {
/* 407 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.flag));
/*     */     }
/* 409 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 411 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 413 */     if (FCode.equalsIgnoreCase("modityTime"))
/*     */     {
/* 415 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modityTime));
/*     */     }
/* 417 */     if (FCode.equalsIgnoreCase("lastOperator"))
/*     */     {
/* 419 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lastOperator));
/*     */     }
/* 421 */     if (FCode.equalsIgnoreCase("bY1"))
/*     */     {
/* 423 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBY1()));
/*     */     }
/* 425 */     if (FCode.equalsIgnoreCase("bY2"))
/*     */     {
/* 427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getBY2()));
/*     */     }
/* 429 */     if (FCode.equalsIgnoreCase("bY3"))
/*     */     {
/* 431 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bY3));
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("bY4"))
/*     */     {
/* 435 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bY4));
/*     */     }
/* 437 */     if (strReturn.equals(""))
/*     */     {
/* 439 */       strReturn = "null";
/*     */     }
/*     */ 
/* 442 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 449 */     String strFieldValue = "";
/* 450 */     switch (nFieldIndex) {
/*     */     case 0:
/* 452 */       strFieldValue = StrTool.GBKToUnicode(this.id);
/* 453 */       break;
/*     */     case 1:
/* 455 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFileDate()));
/* 456 */       break;
/*     */     case 2:
/* 458 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFDownDate()));
/* 459 */       break;
/*     */     case 3:
/* 461 */       strFieldValue = StrTool.GBKToUnicode(this.fDownTime);
/* 462 */       break;
/*     */     case 4:
/* 464 */       strFieldValue = StrTool.GBKToUnicode(this.flag);
/* 465 */       break;
/*     */     case 5:
/* 467 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 468 */       break;
/*     */     case 6:
/* 470 */       strFieldValue = StrTool.GBKToUnicode(this.modityTime);
/* 471 */       break;
/*     */     case 7:
/* 473 */       strFieldValue = StrTool.GBKToUnicode(this.lastOperator);
/* 474 */       break;
/*     */     case 8:
/* 476 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBY1()));
/* 477 */       break;
/*     */     case 9:
/* 479 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBY2()));
/* 480 */       break;
/*     */     case 10:
/* 482 */       strFieldValue = StrTool.GBKToUnicode(this.bY3);
/* 483 */       break;
/*     */     case 11:
/* 485 */       strFieldValue = StrTool.GBKToUnicode(this.bY4);
/* 486 */       break;
/*     */     default:
/* 488 */       strFieldValue = "";
/*     */     }
/* 490 */     if (strFieldValue.equals("")) {
/* 491 */       strFieldValue = "null";
/*     */     }
/* 493 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 499 */     if (StrTool.cTrim(FCode).equals("")) {
/* 500 */       return false;
/*     */     }
/* 502 */     if (FCode.equalsIgnoreCase("id"))
/*     */     {
/* 504 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 506 */         this.id = FValue.trim();
/*     */       }
/*     */       else
/* 509 */         this.id = null;
/*     */     }
/* 511 */     if (FCode.equalsIgnoreCase("fileDate"))
/*     */     {
/* 513 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 515 */         this.fileDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 518 */         this.fileDate = null;
/*     */     }
/* 520 */     if (FCode.equalsIgnoreCase("fDownDate"))
/*     */     {
/* 522 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 524 */         this.fDownDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 527 */         this.fDownDate = null;
/*     */     }
/* 529 */     if (FCode.equalsIgnoreCase("fDownTime"))
/*     */     {
/* 531 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 533 */         this.fDownTime = FValue.trim();
/*     */       }
/*     */       else
/* 536 */         this.fDownTime = null;
/*     */     }
/* 538 */     if (FCode.equalsIgnoreCase("flag"))
/*     */     {
/* 540 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 542 */         this.flag = FValue.trim();
/*     */       }
/*     */       else
/* 545 */         this.flag = null;
/*     */     }
/* 547 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 549 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 551 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 554 */         this.modifyDate = null;
/*     */     }
/* 556 */     if (FCode.equalsIgnoreCase("modityTime"))
/*     */     {
/* 558 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 560 */         this.modityTime = FValue.trim();
/*     */       }
/*     */       else
/* 563 */         this.modityTime = null;
/*     */     }
/* 565 */     if (FCode.equalsIgnoreCase("lastOperator"))
/*     */     {
/* 567 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 569 */         this.lastOperator = FValue.trim();
/*     */       }
/*     */       else
/* 572 */         this.lastOperator = null;
/*     */     }
/* 574 */     if (FCode.equalsIgnoreCase("bY1"))
/*     */     {
/* 576 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 578 */         this.bY1 = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 581 */         this.bY1 = null;
/*     */     }
/* 583 */     if (FCode.equalsIgnoreCase("bY2"))
/*     */     {
/* 585 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 587 */         this.bY2 = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 590 */         this.bY2 = null;
/*     */     }
/* 592 */     if (FCode.equalsIgnoreCase("bY3"))
/*     */     {
/* 594 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 596 */         this.bY3 = FValue.trim();
/*     */       }
/*     */       else
/* 599 */         this.bY3 = null;
/*     */     }
/* 601 */     if (FCode.equalsIgnoreCase("bY4"))
/*     */     {
/* 603 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 605 */         this.bY4 = FValue.trim();
/*     */       }
/*     */       else
/* 608 */         this.bY4 = null;
/*     */     }
/* 610 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 615 */     if (otherObject == null) return false;
/* 616 */     if (this == otherObject) return true;
/* 617 */     if (getClass() != otherObject.getClass()) return false;
/* 618 */     CaseFileDownlLogSchema other = (CaseFileDownlLogSchema)otherObject;
/* 619 */     if ((this.id == null) && (other.getId() != null)) return false;
/* 620 */     if ((this.id != null) && (!this.id.equals(other.getId()))) return false;
/* 621 */     if ((this.fileDate == null) && (other.getFileDate() != null)) return false;
/* 622 */     if ((this.fileDate != null) && (!this.fDate.getString(this.fileDate).equals(other.getFileDate()))) return false;
/* 623 */     if ((this.fDownDate == null) && (other.getFDownDate() != null)) return false;
/* 624 */     if ((this.fDownDate != null) && (!this.fDate.getString(this.fDownDate).equals(other.getFDownDate()))) return false;
/* 625 */     if ((this.fDownTime == null) && (other.getFDownTime() != null)) return false;
/* 626 */     if ((this.fDownTime != null) && (!this.fDownTime.equals(other.getFDownTime()))) return false;
/* 627 */     if ((this.flag == null) && (other.getFlag() != null)) return false;
/* 628 */     if ((this.flag != null) && (!this.flag.equals(other.getFlag()))) return false;
/* 629 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 630 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 631 */     if ((this.modityTime == null) && (other.getModityTime() != null)) return false;
/* 632 */     if ((this.modityTime != null) && (!this.modityTime.equals(other.getModityTime()))) return false;
/* 633 */     if ((this.lastOperator == null) && (other.getLastOperator() != null)) return false;
/* 634 */     if ((this.lastOperator != null) && (!this.lastOperator.equals(other.getLastOperator()))) return false;
/* 635 */     if ((this.bY1 == null) && (other.getBY1() != null)) return false;
/* 636 */     if ((this.bY1 != null) && (!this.fDate.getString(this.bY1).equals(other.getBY1()))) return false;
/* 637 */     if ((this.bY2 == null) && (other.getBY2() != null)) return false;
/* 638 */     if ((this.bY2 != null) && (!this.fDate.getString(this.bY2).equals(other.getBY2()))) return false;
/* 639 */     if ((this.bY3 == null) && (other.getBY3() != null)) return false;
/* 640 */     if ((this.bY3 != null) && (!this.bY3.equals(other.getBY3()))) return false;
/* 641 */     if ((this.bY4 == null) && (other.getBY4() != null)) return false;
/* 642 */     return (this.bY4 == null) || (this.bY4.equals(other.getBY4()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 649 */     return 12;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 655 */     if (strFieldName.equals("id")) {
/* 656 */       return 0;
/*     */     }
/* 658 */     if (strFieldName.equals("fileDate")) {
/* 659 */       return 1;
/*     */     }
/* 661 */     if (strFieldName.equals("fDownDate")) {
/* 662 */       return 2;
/*     */     }
/* 664 */     if (strFieldName.equals("fDownTime")) {
/* 665 */       return 3;
/*     */     }
/* 667 */     if (strFieldName.equals("flag")) {
/* 668 */       return 4;
/*     */     }
/* 670 */     if (strFieldName.equals("modifyDate")) {
/* 671 */       return 5;
/*     */     }
/* 673 */     if (strFieldName.equals("modityTime")) {
/* 674 */       return 6;
/*     */     }
/* 676 */     if (strFieldName.equals("lastOperator")) {
/* 677 */       return 7;
/*     */     }
/* 679 */     if (strFieldName.equals("bY1")) {
/* 680 */       return 8;
/*     */     }
/* 682 */     if (strFieldName.equals("bY2")) {
/* 683 */       return 9;
/*     */     }
/* 685 */     if (strFieldName.equals("bY3")) {
/* 686 */       return 10;
/*     */     }
/* 688 */     if (strFieldName.equals("bY4")) {
/* 689 */       return 11;
/*     */     }
/* 691 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 697 */     String strFieldName = "";
/* 698 */     switch (nFieldIndex) {
/*     */     case 0:
/* 700 */       strFieldName = "id";
/* 701 */       break;
/*     */     case 1:
/* 703 */       strFieldName = "fileDate";
/* 704 */       break;
/*     */     case 2:
/* 706 */       strFieldName = "fDownDate";
/* 707 */       break;
/*     */     case 3:
/* 709 */       strFieldName = "fDownTime";
/* 710 */       break;
/*     */     case 4:
/* 712 */       strFieldName = "flag";
/* 713 */       break;
/*     */     case 5:
/* 715 */       strFieldName = "modifyDate";
/* 716 */       break;
/*     */     case 6:
/* 718 */       strFieldName = "modityTime";
/* 719 */       break;
/*     */     case 7:
/* 721 */       strFieldName = "lastOperator";
/* 722 */       break;
/*     */     case 8:
/* 724 */       strFieldName = "bY1";
/* 725 */       break;
/*     */     case 9:
/* 727 */       strFieldName = "bY2";
/* 728 */       break;
/*     */     case 10:
/* 730 */       strFieldName = "bY3";
/* 731 */       break;
/*     */     case 11:
/* 733 */       strFieldName = "bY4";
/* 734 */       break;
/*     */     default:
/* 736 */       strFieldName = "";
/*     */     }
/* 738 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 744 */     if (strFieldName.equals("id")) {
/* 745 */       return 0;
/*     */     }
/* 747 */     if (strFieldName.equals("fileDate")) {
/* 748 */       return 1;
/*     */     }
/* 750 */     if (strFieldName.equals("fDownDate")) {
/* 751 */       return 1;
/*     */     }
/* 753 */     if (strFieldName.equals("fDownTime")) {
/* 754 */       return 0;
/*     */     }
/* 756 */     if (strFieldName.equals("flag")) {
/* 757 */       return 0;
/*     */     }
/* 759 */     if (strFieldName.equals("modifyDate")) {
/* 760 */       return 1;
/*     */     }
/* 762 */     if (strFieldName.equals("modityTime")) {
/* 763 */       return 0;
/*     */     }
/* 765 */     if (strFieldName.equals("lastOperator")) {
/* 766 */       return 0;
/*     */     }
/* 768 */     if (strFieldName.equals("bY1")) {
/* 769 */       return 1;
/*     */     }
/* 771 */     if (strFieldName.equals("bY2")) {
/* 772 */       return 1;
/*     */     }
/* 774 */     if (strFieldName.equals("bY3")) {
/* 775 */       return 0;
/*     */     }
/* 777 */     if (strFieldName.equals("bY4")) {
/* 778 */       return 0;
/*     */     }
/* 780 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 786 */     int nFieldType = -1;
/* 787 */     switch (nFieldIndex) {
/*     */     case 0:
/* 789 */       nFieldType = 0;
/* 790 */       break;
/*     */     case 1:
/* 792 */       nFieldType = 1;
/* 793 */       break;
/*     */     case 2:
/* 795 */       nFieldType = 1;
/* 796 */       break;
/*     */     case 3:
/* 798 */       nFieldType = 0;
/* 799 */       break;
/*     */     case 4:
/* 801 */       nFieldType = 0;
/* 802 */       break;
/*     */     case 5:
/* 804 */       nFieldType = 1;
/* 805 */       break;
/*     */     case 6:
/* 807 */       nFieldType = 0;
/* 808 */       break;
/*     */     case 7:
/* 810 */       nFieldType = 0;
/* 811 */       break;
/*     */     case 8:
/* 813 */       nFieldType = 1;
/* 814 */       break;
/*     */     case 9:
/* 816 */       nFieldType = 1;
/* 817 */       break;
/*     */     case 10:
/* 819 */       nFieldType = 0;
/* 820 */       break;
/*     */     case 11:
/* 822 */       nFieldType = 0;
/* 823 */       break;
/*     */     default:
/* 825 */       nFieldType = -1;
/*     */     }
/* 827 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.CaseFileDownlLogSchema
 * JD-Core Version:    0.6.0
 */