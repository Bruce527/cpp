/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MNewsContentDB;
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
/*     */ public class MNewsContentSchema
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
/*     */   public static final int FIELDNUM = 9;
/*     */   private static String[] PK;
/*  42 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MNewsContentSchema()
/*     */   {
/*  49 */     this.mErrors = new CErrors();
/*     */ 
/*  51 */     String[] pk = new String[1];
/*  52 */     pk[0] = "ContentID";
/*     */ 
/*  54 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  61 */     MNewsContentSchema cloned = (MNewsContentSchema)super.clone();
/*  62 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  63 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  64 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  70 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getContentID()
/*     */   {
/*  75 */     return this.contentID;
/*     */   }
/*     */ 
/*     */   public void setContentID(String aContentID) {
/*  79 */     this.contentID = aContentID;
/*     */   }
/*     */ 
/*     */   public String getNewsID() {
/*  83 */     return this.newsID;
/*     */   }
/*     */ 
/*     */   public void setNewsID(String aNewsID) {
/*  87 */     this.newsID = aNewsID;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/*  91 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String aContent) {
/*  95 */     this.content = aContent;
/*     */   }
/*     */ 
/*     */   public int getContOrder() {
/*  99 */     return this.contOrder;
/*     */   }
/*     */ 
/*     */   public void setContOrder(int aContOrder) {
/* 103 */     this.contOrder = aContOrder;
/*     */   }
/*     */ 
/*     */   public void setContOrder(String aContOrder) {
/* 107 */     if ((aContOrder != null) && (!aContOrder.equals("")))
/*     */     {
/* 109 */       Integer tInteger = new Integer(aContOrder);
/* 110 */       int i = tInteger.intValue();
/* 111 */       this.contOrder = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 117 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 121 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 125 */     if (this.makeDate != null) {
/* 126 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 132 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 136 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 138 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 141 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 146 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 150 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 154 */     if (this.modifyDate != null) {
/* 155 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 157 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 161 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 165 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 167 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 170 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 175 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 179 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(MNewsContentSchema aMNewsContentSchema)
/*     */   {
/* 185 */     this.contentID = aMNewsContentSchema.getContentID();
/* 186 */     this.newsID = aMNewsContentSchema.getNewsID();
/* 187 */     this.content = aMNewsContentSchema.getContent();
/* 188 */     this.contOrder = aMNewsContentSchema.getContOrder();
/* 189 */     this.operator = aMNewsContentSchema.getOperator();
/* 190 */     this.makeDate = this.fDate.getDate(aMNewsContentSchema.getMakeDate());
/* 191 */     this.makeTime = aMNewsContentSchema.getMakeTime();
/* 192 */     this.modifyDate = this.fDate.getDate(aMNewsContentSchema.getModifyDate());
/* 193 */     this.modifyTime = aMNewsContentSchema.getModifyTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 202 */       if (rs.getString("ContentID") == null)
/* 203 */         this.contentID = null;
/*     */       else {
/* 205 */         this.contentID = rs.getString("ContentID").trim();
/*     */       }
/* 207 */       if (rs.getString("NewsID") == null)
/* 208 */         this.newsID = null;
/*     */       else {
/* 210 */         this.newsID = rs.getString("NewsID").trim();
/*     */       }
/* 212 */       if (rs.getString("Content") == null)
/* 213 */         this.content = null;
/*     */       else {
/* 215 */         this.content = rs.getString("Content").trim();
/*     */       }
/* 217 */       this.contOrder = rs.getInt("ContOrder");
/* 218 */       if (rs.getString("Operator") == null)
/* 219 */         this.operator = null;
/*     */       else {
/* 221 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 223 */       this.makeDate = rs.getDate("MakeDate");
/* 224 */       if (rs.getString("MakeTime") == null)
/* 225 */         this.makeTime = null;
/*     */       else {
/* 227 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 229 */       this.modifyDate = rs.getDate("ModifyDate");
/* 230 */       if (rs.getString("ModifyTime") == null)
/* 231 */         this.modifyTime = null;
/*     */       else {
/* 233 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 238 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNewsContent\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 240 */       CError tError = new CError();
/* 241 */       tError.moduleName = "MNewsContentSchema";
/* 242 */       tError.functionName = "setSchema";
/* 243 */       tError.errorMessage = sqle.toString();
/* 244 */       this.mErrors.addOneError(tError);
/* 245 */       return false;
/*     */     }
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   public MNewsContentSchema getSchema()
/*     */   {
/* 252 */     MNewsContentSchema aMNewsContentSchema = new MNewsContentSchema();
/* 253 */     aMNewsContentSchema.setSchema(this);
/* 254 */     return aMNewsContentSchema;
/*     */   }
/*     */ 
/*     */   public MNewsContentDB getDB()
/*     */   {
/* 259 */     MNewsContentDB aDBOper = new MNewsContentDB();
/* 260 */     aDBOper.setSchema(this);
/* 261 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 268 */     StringBuffer strReturn = new StringBuffer(256);
/* 269 */     strReturn.append(StrTool.cTrim(this.contentID)); strReturn.append("|");
/* 270 */     strReturn.append(StrTool.cTrim(this.newsID)); strReturn.append("|");
/* 271 */     strReturn.append(StrTool.cTrim(this.content)); strReturn.append("|");
/* 272 */     strReturn.append(ChgData.chgData(this.contOrder)); strReturn.append("|");
/* 273 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 274 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 275 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 276 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 277 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 278 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 286 */       this.contentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 287 */       this.newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 288 */       this.content = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 289 */       this.contOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/* 290 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 291 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 292 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 293 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 294 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 299 */       CError tError = new CError();
/* 300 */       tError.moduleName = "MNewsContentSchema";
/* 301 */       tError.functionName = "decode";
/* 302 */       tError.errorMessage = ex.toString();
/* 303 */       this.mErrors.addOneError(tError);
/*     */ 
/* 305 */       return false;
/*     */     }
/* 307 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 313 */     String strReturn = "";
/* 314 */     if (FCode.equalsIgnoreCase("contentID"))
/*     */     {
/* 316 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contentID));
/*     */     }
/* 318 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 320 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsID));
/*     */     }
/* 322 */     if (FCode.equalsIgnoreCase("content"))
/*     */     {
/* 324 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.content));
/*     */     }
/* 326 */     if (FCode.equalsIgnoreCase("contOrder"))
/*     */     {
/* 328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contOrder));
/*     */     }
/* 330 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 334 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 338 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 342 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 346 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 350 */     if (strReturn.equals(""))
/*     */     {
/* 352 */       strReturn = "null";
/*     */     }
/*     */ 
/* 355 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 362 */     String strFieldValue = "";
/* 363 */     switch (nFieldIndex) {
/*     */     case 0:
/* 365 */       strFieldValue = StrTool.GBKToUnicode(this.contentID);
/* 366 */       break;
/*     */     case 1:
/* 368 */       strFieldValue = StrTool.GBKToUnicode(this.newsID);
/* 369 */       break;
/*     */     case 2:
/* 371 */       strFieldValue = StrTool.GBKToUnicode(this.content);
/* 372 */       break;
/*     */     case 3:
/* 374 */       strFieldValue = String.valueOf(this.contOrder);
/* 375 */       break;
/*     */     case 4:
/* 377 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 378 */       break;
/*     */     case 5:
/* 380 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 381 */       break;
/*     */     case 6:
/* 383 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 384 */       break;
/*     */     case 7:
/* 386 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 387 */       break;
/*     */     case 8:
/* 389 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 390 */       break;
/*     */     default:
/* 392 */       strFieldValue = "";
/*     */     }
/* 394 */     if (strFieldValue.equals("")) {
/* 395 */       strFieldValue = "null";
/*     */     }
/* 397 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 403 */     if (StrTool.cTrim(FCode).equals("")) {
/* 404 */       return false;
/*     */     }
/* 406 */     if (FCode.equalsIgnoreCase("contentID"))
/*     */     {
/* 408 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 410 */         this.contentID = FValue.trim();
/*     */       }
/*     */       else
/* 413 */         this.contentID = null;
/*     */     }
/* 415 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 417 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 419 */         this.newsID = FValue.trim();
/*     */       }
/*     */       else
/* 422 */         this.newsID = null;
/*     */     }
/* 424 */     if (FCode.equalsIgnoreCase("content"))
/*     */     {
/* 426 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 428 */         this.content = FValue.trim();
/*     */       }
/*     */       else
/* 431 */         this.content = null;
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("contOrder"))
/*     */     {
/* 435 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 437 */         Integer tInteger = new Integer(FValue);
/* 438 */         int i = tInteger.intValue();
/* 439 */         this.contOrder = i;
/*     */       }
/*     */     }
/* 442 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 444 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 446 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 449 */         this.operator = null;
/*     */     }
/* 451 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 453 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 455 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 458 */         this.makeDate = null;
/*     */     }
/* 460 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 462 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 464 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 467 */         this.makeTime = null;
/*     */     }
/* 469 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 471 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 473 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 476 */         this.modifyDate = null;
/*     */     }
/* 478 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 480 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 482 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 485 */         this.modifyTime = null;
/*     */     }
/* 487 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 492 */     if (otherObject == null) return false;
/* 493 */     if (this == otherObject) return true;
/* 494 */     if (getClass() != otherObject.getClass()) return false;
/* 495 */     MNewsContentSchema other = (MNewsContentSchema)otherObject;
/* 496 */     if ((this.contentID == null) && (other.getContentID() != null)) return false;
/* 497 */     if ((this.contentID != null) && (!this.contentID.equals(other.getContentID()))) return false;
/* 498 */     if ((this.newsID == null) && (other.getNewsID() != null)) return false;
/* 499 */     if ((this.newsID != null) && (!this.newsID.equals(other.getNewsID()))) return false;
/* 500 */     if ((this.content == null) && (other.getContent() != null)) return false;
/* 501 */     if ((this.content != null) && (!this.content.equals(other.getContent()))) return false;
/* 502 */     if (this.contOrder != other.getContOrder()) return false;
/* 503 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 504 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 505 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 506 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 507 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 508 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 509 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 510 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 511 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 512 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 519 */     return 9;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 525 */     if (strFieldName.equals("contentID")) {
/* 526 */       return 0;
/*     */     }
/* 528 */     if (strFieldName.equals("newsID")) {
/* 529 */       return 1;
/*     */     }
/* 531 */     if (strFieldName.equals("content")) {
/* 532 */       return 2;
/*     */     }
/* 534 */     if (strFieldName.equals("contOrder")) {
/* 535 */       return 3;
/*     */     }
/* 537 */     if (strFieldName.equals("operator")) {
/* 538 */       return 4;
/*     */     }
/* 540 */     if (strFieldName.equals("makeDate")) {
/* 541 */       return 5;
/*     */     }
/* 543 */     if (strFieldName.equals("makeTime")) {
/* 544 */       return 6;
/*     */     }
/* 546 */     if (strFieldName.equals("modifyDate")) {
/* 547 */       return 7;
/*     */     }
/* 549 */     if (strFieldName.equals("modifyTime")) {
/* 550 */       return 8;
/*     */     }
/* 552 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 558 */     String strFieldName = "";
/* 559 */     switch (nFieldIndex) {
/*     */     case 0:
/* 561 */       strFieldName = "contentID";
/* 562 */       break;
/*     */     case 1:
/* 564 */       strFieldName = "newsID";
/* 565 */       break;
/*     */     case 2:
/* 567 */       strFieldName = "content";
/* 568 */       break;
/*     */     case 3:
/* 570 */       strFieldName = "contOrder";
/* 571 */       break;
/*     */     case 4:
/* 573 */       strFieldName = "operator";
/* 574 */       break;
/*     */     case 5:
/* 576 */       strFieldName = "makeDate";
/* 577 */       break;
/*     */     case 6:
/* 579 */       strFieldName = "makeTime";
/* 580 */       break;
/*     */     case 7:
/* 582 */       strFieldName = "modifyDate";
/* 583 */       break;
/*     */     case 8:
/* 585 */       strFieldName = "modifyTime";
/* 586 */       break;
/*     */     default:
/* 588 */       strFieldName = "";
/*     */     }
/* 590 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 596 */     if (strFieldName.equals("contentID")) {
/* 597 */       return 0;
/*     */     }
/* 599 */     if (strFieldName.equals("newsID")) {
/* 600 */       return 0;
/*     */     }
/* 602 */     if (strFieldName.equals("content")) {
/* 603 */       return 0;
/*     */     }
/* 605 */     if (strFieldName.equals("contOrder")) {
/* 606 */       return 3;
/*     */     }
/* 608 */     if (strFieldName.equals("operator")) {
/* 609 */       return 0;
/*     */     }
/* 611 */     if (strFieldName.equals("makeDate")) {
/* 612 */       return 1;
/*     */     }
/* 614 */     if (strFieldName.equals("makeTime")) {
/* 615 */       return 0;
/*     */     }
/* 617 */     if (strFieldName.equals("modifyDate")) {
/* 618 */       return 1;
/*     */     }
/* 620 */     if (strFieldName.equals("modifyTime")) {
/* 621 */       return 0;
/*     */     }
/* 623 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 629 */     int nFieldType = -1;
/* 630 */     switch (nFieldIndex) {
/*     */     case 0:
/* 632 */       nFieldType = 0;
/* 633 */       break;
/*     */     case 1:
/* 635 */       nFieldType = 0;
/* 636 */       break;
/*     */     case 2:
/* 638 */       nFieldType = 0;
/* 639 */       break;
/*     */     case 3:
/* 641 */       nFieldType = 3;
/* 642 */       break;
/*     */     case 4:
/* 644 */       nFieldType = 0;
/* 645 */       break;
/*     */     case 5:
/* 647 */       nFieldType = 1;
/* 648 */       break;
/*     */     case 6:
/* 650 */       nFieldType = 0;
/* 651 */       break;
/*     */     case 7:
/* 653 */       nFieldType = 1;
/* 654 */       break;
/*     */     case 8:
/* 656 */       nFieldType = 0;
/* 657 */       break;
/*     */     default:
/* 659 */       nFieldType = -1;
/*     */     }
/* 661 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewsContentSchema
 * JD-Core Version:    0.6.0
 */