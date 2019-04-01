/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MNewsContentBDB;
/*     */ import com.sinosoft.map.lis.pubfun.FDate;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class MNewsContentBSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String contentID;
/*     */   private String newsID;
/*     */   private String content;
/*     */   private int contOrder;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   private String edorNo;
/*     */   private String edorType;
/*     */   private String edorCase;
/*     */   private String operator2;
/*     */   private Date makeDate2;
/*     */   private String makeTime2;
/*     */   public static final int FIELDNUM = 15;
/*     */   private static String[] PK;
/*  54 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MNewsContentBSchema()
/*     */   {
/*  61 */     this.mErrors = new CErrors();
/*     */ 
/*  63 */     String[] pk = new String[1];
/*  64 */     pk[0] = "EdorNo";
/*     */ 
/*  66 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  73 */     MNewsContentBSchema cloned = (MNewsContentBSchema)super.clone();
/*  74 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  75 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  76 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  82 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getContentID()
/*     */   {
/*  87 */     return this.contentID;
/*     */   }
/*     */ 
/*     */   public void setContentID(String aContentID) {
/*  91 */     this.contentID = aContentID;
/*     */   }
/*     */ 
/*     */   public String getNewsID() {
/*  95 */     return this.newsID;
/*     */   }
/*     */ 
/*     */   public void setNewsID(String aNewsID) {
/*  99 */     this.newsID = aNewsID;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/* 103 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String aContent) {
/* 107 */     this.content = aContent;
/*     */   }
/*     */ 
/*     */   public int getContOrder() {
/* 111 */     return this.contOrder;
/*     */   }
/*     */ 
/*     */   public void setContOrder(int aContOrder) {
/* 115 */     this.contOrder = aContOrder;
/*     */   }
/*     */ 
/*     */   public void setContOrder(String aContOrder) {
/* 119 */     if ((aContOrder != null) && (!aContOrder.equals("")))
/*     */     {
/* 121 */       Integer tInteger = new Integer(aContOrder);
/* 122 */       int i = tInteger.intValue();
/* 123 */       this.contOrder = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 129 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 133 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 137 */     if (this.makeDate != null) {
/* 138 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 144 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 148 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 150 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 153 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 158 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 162 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 166 */     if (this.modifyDate != null) {
/* 167 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 173 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 177 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 179 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 182 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 187 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 191 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public String getEdorNo() {
/* 195 */     return this.edorNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String aEdorNo) {
/* 199 */     this.edorNo = aEdorNo;
/*     */   }
/*     */ 
/*     */   public String getEdorType() {
/* 203 */     return this.edorType;
/*     */   }
/*     */ 
/*     */   public void setEdorType(String aEdorType) {
/* 207 */     this.edorType = aEdorType;
/*     */   }
/*     */ 
/*     */   public String getEdorCase() {
/* 211 */     return this.edorCase;
/*     */   }
/*     */ 
/*     */   public void setEdorCase(String aEdorCase) {
/* 215 */     this.edorCase = aEdorCase;
/*     */   }
/*     */ 
/*     */   public String getOperator2() {
/* 219 */     return this.operator2;
/*     */   }
/*     */ 
/*     */   public void setOperator2(String aOperator2) {
/* 223 */     this.operator2 = aOperator2;
/*     */   }
/*     */ 
/*     */   public String getMakeDate2() {
/* 227 */     if (this.makeDate2 != null) {
/* 228 */       return this.fDate.getString(this.makeDate2);
/*     */     }
/* 230 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate2(Date aMakeDate2) {
/* 234 */     this.makeDate2 = aMakeDate2;
/*     */   }
/*     */ 
/*     */   public void setMakeDate2(String aMakeDate2) {
/* 238 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*     */     {
/* 240 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*     */     }
/*     */     else
/* 243 */       this.makeDate2 = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime2()
/*     */   {
/* 248 */     return this.makeTime2;
/*     */   }
/*     */ 
/*     */   public void setMakeTime2(String aMakeTime2) {
/* 252 */     this.makeTime2 = aMakeTime2;
/*     */   }
/*     */ 
/*     */   public void setSchema(MNewsContentBSchema aMNewsContentBSchema)
/*     */   {
/* 258 */     this.contentID = aMNewsContentBSchema.getContentID();
/* 259 */     this.newsID = aMNewsContentBSchema.getNewsID();
/* 260 */     this.content = aMNewsContentBSchema.getContent();
/* 261 */     this.contOrder = aMNewsContentBSchema.getContOrder();
/* 262 */     this.operator = aMNewsContentBSchema.getOperator();
/* 263 */     this.makeDate = this.fDate.getDate(aMNewsContentBSchema.getMakeDate());
/* 264 */     this.makeTime = aMNewsContentBSchema.getMakeTime();
/* 265 */     this.modifyDate = this.fDate.getDate(aMNewsContentBSchema.getModifyDate());
/* 266 */     this.modifyTime = aMNewsContentBSchema.getModifyTime();
/* 267 */     this.edorNo = aMNewsContentBSchema.getEdorNo();
/* 268 */     this.edorType = aMNewsContentBSchema.getEdorType();
/* 269 */     this.edorCase = aMNewsContentBSchema.getEdorCase();
/* 270 */     this.operator2 = aMNewsContentBSchema.getOperator2();
/* 271 */     this.makeDate2 = this.fDate.getDate(aMNewsContentBSchema.getMakeDate2());
/* 272 */     this.makeTime2 = aMNewsContentBSchema.getMakeTime2();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 281 */       if (rs.getString("ContentID") == null)
/* 282 */         this.contentID = null;
/*     */       else {
/* 284 */         this.contentID = rs.getString("ContentID").trim();
/*     */       }
/* 286 */       if (rs.getString("NewsID") == null)
/* 287 */         this.newsID = null;
/*     */       else {
/* 289 */         this.newsID = rs.getString("NewsID").trim();
/*     */       }
/* 291 */       if (rs.getString("Content") == null)
/* 292 */         this.content = null;
/*     */       else {
/* 294 */         this.content = rs.getString("Content").trim();
/*     */       }
/* 296 */       this.contOrder = rs.getInt("ContOrder");
/* 297 */       if (rs.getString("Operator") == null)
/* 298 */         this.operator = null;
/*     */       else {
/* 300 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 302 */       this.makeDate = rs.getDate("MakeDate");
/* 303 */       if (rs.getString("MakeTime") == null)
/* 304 */         this.makeTime = null;
/*     */       else {
/* 306 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 308 */       this.modifyDate = rs.getDate("ModifyDate");
/* 309 */       if (rs.getString("ModifyTime") == null)
/* 310 */         this.modifyTime = null;
/*     */       else {
/* 312 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 314 */       if (rs.getString("EdorNo") == null)
/* 315 */         this.edorNo = null;
/*     */       else {
/* 317 */         this.edorNo = rs.getString("EdorNo").trim();
/*     */       }
/* 319 */       if (rs.getString("EdorType") == null)
/* 320 */         this.edorType = null;
/*     */       else {
/* 322 */         this.edorType = rs.getString("EdorType").trim();
/*     */       }
/* 324 */       if (rs.getString("EdorCase") == null)
/* 325 */         this.edorCase = null;
/*     */       else {
/* 327 */         this.edorCase = rs.getString("EdorCase").trim();
/*     */       }
/* 329 */       if (rs.getString("Operator2") == null)
/* 330 */         this.operator2 = null;
/*     */       else {
/* 332 */         this.operator2 = rs.getString("Operator2").trim();
/*     */       }
/* 334 */       this.makeDate2 = rs.getDate("MakeDate2");
/* 335 */       if (rs.getString("MakeTime2") == null)
/* 336 */         this.makeTime2 = null;
/*     */       else {
/* 338 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 343 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNewsContentB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 345 */       CError tError = new CError();
/* 346 */       tError.moduleName = "MNewsContentBSchema";
/* 347 */       tError.functionName = "setSchema";
/* 348 */       tError.errorMessage = sqle.toString();
/* 349 */       this.mErrors.addOneError(tError);
/* 350 */       return false;
/*     */     }
/* 352 */     return true;
/*     */   }
/*     */ 
/*     */   public MNewsContentBSchema getSchema()
/*     */   {
/* 357 */     MNewsContentBSchema aMNewsContentBSchema = new MNewsContentBSchema();
/* 358 */     aMNewsContentBSchema.setSchema(this);
/* 359 */     return aMNewsContentBSchema;
/*     */   }
/*     */ 
/*     */   public MNewsContentBDB getDB()
/*     */   {
/* 364 */     MNewsContentBDB aDBOper = new MNewsContentBDB();
/* 365 */     aDBOper.setSchema(this);
/* 366 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 373 */     StringBuffer strReturn = new StringBuffer(256);
/* 374 */     strReturn.append(StrTool.cTrim(this.contentID)); strReturn.append("|");
/* 375 */     strReturn.append(StrTool.cTrim(this.newsID)); strReturn.append("|");
/* 376 */     strReturn.append(StrTool.cTrim(this.content)); strReturn.append("|");
/* 377 */     strReturn.append(ChgData.chgData(this.contOrder)); strReturn.append("|");
/* 378 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 379 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 380 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 381 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 382 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 383 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/* 384 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/* 385 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/* 386 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/* 387 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/* 388 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/* 389 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 397 */       this.contentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 398 */       this.newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 399 */       this.content = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 400 */       this.contOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/* 401 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 402 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 403 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 404 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 405 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 406 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 407 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 408 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 409 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 410 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/* 411 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 416 */       CError tError = new CError();
/* 417 */       tError.moduleName = "MNewsContentBSchema";
/* 418 */       tError.functionName = "decode";
/* 419 */       tError.errorMessage = ex.toString();
/* 420 */       this.mErrors.addOneError(tError);
/*     */ 
/* 422 */       return false;
/*     */     }
/* 424 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 430 */     String strReturn = "";
/* 431 */     if (FCode.equalsIgnoreCase("contentID"))
/*     */     {
/* 433 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contentID));
/*     */     }
/* 435 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 437 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsID));
/*     */     }
/* 439 */     if (FCode.equalsIgnoreCase("content"))
/*     */     {
/* 441 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.content));
/*     */     }
/* 443 */     if (FCode.equalsIgnoreCase("contOrder"))
/*     */     {
/* 445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contOrder));
/*     */     }
/* 447 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 449 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 451 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 453 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 455 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 457 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 459 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 461 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 463 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 465 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 467 */     if (FCode.equalsIgnoreCase("edorNo"))
/*     */     {
/* 469 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*     */     }
/* 471 */     if (FCode.equalsIgnoreCase("edorType"))
/*     */     {
/* 473 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*     */     }
/* 475 */     if (FCode.equalsIgnoreCase("edorCase"))
/*     */     {
/* 477 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*     */     }
/* 479 */     if (FCode.equalsIgnoreCase("operator2"))
/*     */     {
/* 481 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*     */     }
/* 483 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*     */     {
/* 485 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*     */     }
/* 487 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*     */     {
/* 489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*     */     }
/* 491 */     if (strReturn.equals(""))
/*     */     {
/* 493 */       strReturn = "null";
/*     */     }
/*     */ 
/* 496 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 503 */     String strFieldValue = "";
/* 504 */     switch (nFieldIndex) {
/*     */     case 0:
/* 506 */       strFieldValue = StrTool.GBKToUnicode(this.contentID);
/* 507 */       break;
/*     */     case 1:
/* 509 */       strFieldValue = StrTool.GBKToUnicode(this.newsID);
/* 510 */       break;
/*     */     case 2:
/* 512 */       strFieldValue = StrTool.GBKToUnicode(this.content);
/* 513 */       break;
/*     */     case 3:
/* 515 */       strFieldValue = String.valueOf(this.contOrder);
/* 516 */       break;
/*     */     case 4:
/* 518 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 519 */       break;
/*     */     case 5:
/* 521 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 522 */       break;
/*     */     case 6:
/* 524 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 525 */       break;
/*     */     case 7:
/* 527 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 528 */       break;
/*     */     case 8:
/* 530 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 531 */       break;
/*     */     case 9:
/* 533 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/* 534 */       break;
/*     */     case 10:
/* 536 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/* 537 */       break;
/*     */     case 11:
/* 539 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/* 540 */       break;
/*     */     case 12:
/* 542 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/* 543 */       break;
/*     */     case 13:
/* 545 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/* 546 */       break;
/*     */     case 14:
/* 548 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/* 549 */       break;
/*     */     default:
/* 551 */       strFieldValue = "";
/*     */     }
/* 553 */     if (strFieldValue.equals("")) {
/* 554 */       strFieldValue = "null";
/*     */     }
/* 556 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 562 */     if (StrTool.cTrim(FCode).equals("")) {
/* 563 */       return false;
/*     */     }
/* 565 */     if (FCode.equalsIgnoreCase("contentID"))
/*     */     {
/* 567 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 569 */         this.contentID = FValue.trim();
/*     */       }
/*     */       else
/* 572 */         this.contentID = null;
/*     */     }
/* 574 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 576 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 578 */         this.newsID = FValue.trim();
/*     */       }
/*     */       else
/* 581 */         this.newsID = null;
/*     */     }
/* 583 */     if (FCode.equalsIgnoreCase("content"))
/*     */     {
/* 585 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 587 */         this.content = FValue.trim();
/*     */       }
/*     */       else
/* 590 */         this.content = null;
/*     */     }
/* 592 */     if (FCode.equalsIgnoreCase("contOrder"))
/*     */     {
/* 594 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 596 */         Integer tInteger = new Integer(FValue);
/* 597 */         int i = tInteger.intValue();
/* 598 */         this.contOrder = i;
/*     */       }
/*     */     }
/* 601 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 603 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 605 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 608 */         this.operator = null;
/*     */     }
/* 610 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 612 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 614 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 617 */         this.makeDate = null;
/*     */     }
/* 619 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 621 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 623 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 626 */         this.makeTime = null;
/*     */     }
/* 628 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 630 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 632 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 635 */         this.modifyDate = null;
/*     */     }
/* 637 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 639 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 641 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 644 */         this.modifyTime = null;
/*     */     }
/* 646 */     if (FCode.equalsIgnoreCase("edorNo"))
/*     */     {
/* 648 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 650 */         this.edorNo = FValue.trim();
/*     */       }
/*     */       else
/* 653 */         this.edorNo = null;
/*     */     }
/* 655 */     if (FCode.equalsIgnoreCase("edorType"))
/*     */     {
/* 657 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 659 */         this.edorType = FValue.trim();
/*     */       }
/*     */       else
/* 662 */         this.edorType = null;
/*     */     }
/* 664 */     if (FCode.equalsIgnoreCase("edorCase"))
/*     */     {
/* 666 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 668 */         this.edorCase = FValue.trim();
/*     */       }
/*     */       else
/* 671 */         this.edorCase = null;
/*     */     }
/* 673 */     if (FCode.equalsIgnoreCase("operator2"))
/*     */     {
/* 675 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 677 */         this.operator2 = FValue.trim();
/*     */       }
/*     */       else
/* 680 */         this.operator2 = null;
/*     */     }
/* 682 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*     */     {
/* 684 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 686 */         this.makeDate2 = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 689 */         this.makeDate2 = null;
/*     */     }
/* 691 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*     */     {
/* 693 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 695 */         this.makeTime2 = FValue.trim();
/*     */       }
/*     */       else
/* 698 */         this.makeTime2 = null;
/*     */     }
/* 700 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 705 */     if (otherObject == null) return false;
/* 706 */     if (this == otherObject) return true;
/* 707 */     if (getClass() != otherObject.getClass()) return false;
/* 708 */     MNewsContentBSchema other = (MNewsContentBSchema)otherObject;
/* 709 */     if ((this.contentID == null) && (other.getContentID() != null)) return false;
/* 710 */     if ((this.contentID != null) && (!this.contentID.equals(other.getContentID()))) return false;
/* 711 */     if ((this.newsID == null) && (other.getNewsID() != null)) return false;
/* 712 */     if ((this.newsID != null) && (!this.newsID.equals(other.getNewsID()))) return false;
/* 713 */     if ((this.content == null) && (other.getContent() != null)) return false;
/* 714 */     if ((this.content != null) && (!this.content.equals(other.getContent()))) return false;
/* 715 */     if (this.contOrder != other.getContOrder()) return false;
/* 716 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 717 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 718 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 719 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 720 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 721 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 722 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 723 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 724 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 725 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 726 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 727 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 728 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 729 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 730 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 731 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 732 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 733 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 734 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 735 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 736 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 737 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 744 */     return 15;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 750 */     if (strFieldName.equals("contentID")) {
/* 751 */       return 0;
/*     */     }
/* 753 */     if (strFieldName.equals("newsID")) {
/* 754 */       return 1;
/*     */     }
/* 756 */     if (strFieldName.equals("content")) {
/* 757 */       return 2;
/*     */     }
/* 759 */     if (strFieldName.equals("contOrder")) {
/* 760 */       return 3;
/*     */     }
/* 762 */     if (strFieldName.equals("operator")) {
/* 763 */       return 4;
/*     */     }
/* 765 */     if (strFieldName.equals("makeDate")) {
/* 766 */       return 5;
/*     */     }
/* 768 */     if (strFieldName.equals("makeTime")) {
/* 769 */       return 6;
/*     */     }
/* 771 */     if (strFieldName.equals("modifyDate")) {
/* 772 */       return 7;
/*     */     }
/* 774 */     if (strFieldName.equals("modifyTime")) {
/* 775 */       return 8;
/*     */     }
/* 777 */     if (strFieldName.equals("edorNo")) {
/* 778 */       return 9;
/*     */     }
/* 780 */     if (strFieldName.equals("edorType")) {
/* 781 */       return 10;
/*     */     }
/* 783 */     if (strFieldName.equals("edorCase")) {
/* 784 */       return 11;
/*     */     }
/* 786 */     if (strFieldName.equals("operator2")) {
/* 787 */       return 12;
/*     */     }
/* 789 */     if (strFieldName.equals("makeDate2")) {
/* 790 */       return 13;
/*     */     }
/* 792 */     if (strFieldName.equals("makeTime2")) {
/* 793 */       return 14;
/*     */     }
/* 795 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 801 */     String strFieldName = "";
/* 802 */     switch (nFieldIndex) {
/*     */     case 0:
/* 804 */       strFieldName = "contentID";
/* 805 */       break;
/*     */     case 1:
/* 807 */       strFieldName = "newsID";
/* 808 */       break;
/*     */     case 2:
/* 810 */       strFieldName = "content";
/* 811 */       break;
/*     */     case 3:
/* 813 */       strFieldName = "contOrder";
/* 814 */       break;
/*     */     case 4:
/* 816 */       strFieldName = "operator";
/* 817 */       break;
/*     */     case 5:
/* 819 */       strFieldName = "makeDate";
/* 820 */       break;
/*     */     case 6:
/* 822 */       strFieldName = "makeTime";
/* 823 */       break;
/*     */     case 7:
/* 825 */       strFieldName = "modifyDate";
/* 826 */       break;
/*     */     case 8:
/* 828 */       strFieldName = "modifyTime";
/* 829 */       break;
/*     */     case 9:
/* 831 */       strFieldName = "edorNo";
/* 832 */       break;
/*     */     case 10:
/* 834 */       strFieldName = "edorType";
/* 835 */       break;
/*     */     case 11:
/* 837 */       strFieldName = "edorCase";
/* 838 */       break;
/*     */     case 12:
/* 840 */       strFieldName = "operator2";
/* 841 */       break;
/*     */     case 13:
/* 843 */       strFieldName = "makeDate2";
/* 844 */       break;
/*     */     case 14:
/* 846 */       strFieldName = "makeTime2";
/* 847 */       break;
/*     */     default:
/* 849 */       strFieldName = "";
/*     */     }
/* 851 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 857 */     if (strFieldName.equals("contentID")) {
/* 858 */       return 0;
/*     */     }
/* 860 */     if (strFieldName.equals("newsID")) {
/* 861 */       return 0;
/*     */     }
/* 863 */     if (strFieldName.equals("content")) {
/* 864 */       return 0;
/*     */     }
/* 866 */     if (strFieldName.equals("contOrder")) {
/* 867 */       return 3;
/*     */     }
/* 869 */     if (strFieldName.equals("operator")) {
/* 870 */       return 0;
/*     */     }
/* 872 */     if (strFieldName.equals("makeDate")) {
/* 873 */       return 1;
/*     */     }
/* 875 */     if (strFieldName.equals("makeTime")) {
/* 876 */       return 0;
/*     */     }
/* 878 */     if (strFieldName.equals("modifyDate")) {
/* 879 */       return 1;
/*     */     }
/* 881 */     if (strFieldName.equals("modifyTime")) {
/* 882 */       return 0;
/*     */     }
/* 884 */     if (strFieldName.equals("edorNo")) {
/* 885 */       return 0;
/*     */     }
/* 887 */     if (strFieldName.equals("edorType")) {
/* 888 */       return 0;
/*     */     }
/* 890 */     if (strFieldName.equals("edorCase")) {
/* 891 */       return 0;
/*     */     }
/* 893 */     if (strFieldName.equals("operator2")) {
/* 894 */       return 0;
/*     */     }
/* 896 */     if (strFieldName.equals("makeDate2")) {
/* 897 */       return 1;
/*     */     }
/* 899 */     if (strFieldName.equals("makeTime2")) {
/* 900 */       return 0;
/*     */     }
/* 902 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 908 */     int nFieldType = -1;
/* 909 */     switch (nFieldIndex) {
/*     */     case 0:
/* 911 */       nFieldType = 0;
/* 912 */       break;
/*     */     case 1:
/* 914 */       nFieldType = 0;
/* 915 */       break;
/*     */     case 2:
/* 917 */       nFieldType = 0;
/* 918 */       break;
/*     */     case 3:
/* 920 */       nFieldType = 3;
/* 921 */       break;
/*     */     case 4:
/* 923 */       nFieldType = 0;
/* 924 */       break;
/*     */     case 5:
/* 926 */       nFieldType = 1;
/* 927 */       break;
/*     */     case 6:
/* 929 */       nFieldType = 0;
/* 930 */       break;
/*     */     case 7:
/* 932 */       nFieldType = 1;
/* 933 */       break;
/*     */     case 8:
/* 935 */       nFieldType = 0;
/* 936 */       break;
/*     */     case 9:
/* 938 */       nFieldType = 0;
/* 939 */       break;
/*     */     case 10:
/* 941 */       nFieldType = 0;
/* 942 */       break;
/*     */     case 11:
/* 944 */       nFieldType = 0;
/* 945 */       break;
/*     */     case 12:
/* 947 */       nFieldType = 0;
/* 948 */       break;
/*     */     case 13:
/* 950 */       nFieldType = 1;
/* 951 */       break;
/*     */     case 14:
/* 953 */       nFieldType = 0;
/* 954 */       break;
/*     */     default:
/* 956 */       nFieldType = -1;
/*     */     }
/* 958 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewsContentBSchema
 * JD-Core Version:    0.6.0
 */