/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPStaticMsgUrlDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LNPStaticMsgUrlSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private int staMsgID;
/*     */   private String assuranceCode;
/*     */   private String msgUrl;
/*     */   private String flag;
/*     */   private String remarks;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private Date makeTime;
/*     */   private Date modifyDate;
/*     */   private Date modifyTime;
/*     */   public static final int FIELDNUM = 10;
/*     */   private static String[] PK;
/*  47 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPStaticMsgUrlSchema()
/*     */   {
/*  54 */     this.mErrors = new CErrors();
/*     */ 
/*  56 */     String[] pk = new String[1];
/*  57 */     pk[0] = "StaMsgID";
/*     */ 
/*  59 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  66 */     LNPStaticMsgUrlSchema cloned = (LNPStaticMsgUrlSchema)super.clone();
/*  67 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  68 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  69 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  75 */     return PK;
/*     */   }
/*     */ 
/*     */   public int getStaMsgID()
/*     */   {
/*  80 */     return this.staMsgID;
/*     */   }
/*     */ 
/*     */   public void setStaMsgID(int aStaMsgID) {
/*  84 */     this.staMsgID = aStaMsgID;
/*     */   }
/*     */ 
/*     */   public void setStaMsgID(String aStaMsgID) {
/*  88 */     if ((aStaMsgID != null) && (!aStaMsgID.equals("")))
/*     */     {
/*  90 */       Integer tInteger = new Integer(aStaMsgID);
/*  91 */       int i = tInteger.intValue();
/*  92 */       this.staMsgID = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getAssuranceCode()
/*     */   {
/*  98 */     return this.assuranceCode;
/*     */   }
/*     */ 
/*     */   public void setAssuranceCode(String aAssuranceCode) {
/* 102 */     this.assuranceCode = aAssuranceCode;
/*     */   }
/*     */ 
/*     */   public String getMsgUrl() {
/* 106 */     return this.msgUrl;
/*     */   }
/*     */ 
/*     */   public void setMsgUrl(String aMsgUrl) {
/* 110 */     this.msgUrl = aMsgUrl;
/*     */   }
/*     */ 
/*     */   public String getFlag() {
/* 114 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(String aFlag) {
/* 118 */     this.flag = aFlag;
/*     */   }
/*     */ 
/*     */   public String getRemarks() {
/* 122 */     return this.remarks;
/*     */   }
/*     */ 
/*     */   public void setRemarks(String aRemarks) {
/* 126 */     this.remarks = aRemarks;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 130 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 134 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 138 */     if (this.makeDate != null) {
/* 139 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 145 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 149 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 151 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 154 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 159 */     if (this.makeTime != null) {
/* 160 */       return this.fDate.getString(this.makeTime);
/*     */     }
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(Date aMakeTime) {
/* 166 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 170 */     if ((aMakeTime != null) && (!aMakeTime.equals("")))
/*     */     {
/* 172 */       this.makeTime = this.fDate.getDate(aMakeTime);
/*     */     }
/*     */     else
/* 175 */       this.makeTime = null;
/*     */   }
/*     */ 
/*     */   public String getModifyDate()
/*     */   {
/* 180 */     if (this.modifyDate != null) {
/* 181 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 187 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 191 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 193 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 196 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 201 */     if (this.modifyTime != null) {
/* 202 */       return this.fDate.getString(this.modifyTime);
/*     */     }
/* 204 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(Date aModifyTime) {
/* 208 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 212 */     if ((aModifyTime != null) && (!aModifyTime.equals("")))
/*     */     {
/* 214 */       this.modifyTime = this.fDate.getDate(aModifyTime);
/*     */     }
/*     */     else
/* 217 */       this.modifyTime = null;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPStaticMsgUrlSchema aLNPStaticMsgUrlSchema)
/*     */   {
/* 224 */     this.staMsgID = aLNPStaticMsgUrlSchema.getStaMsgID();
/* 225 */     this.assuranceCode = aLNPStaticMsgUrlSchema.getAssuranceCode();
/* 226 */     this.msgUrl = aLNPStaticMsgUrlSchema.getMsgUrl();
/* 227 */     this.flag = aLNPStaticMsgUrlSchema.getFlag();
/* 228 */     this.remarks = aLNPStaticMsgUrlSchema.getRemarks();
/* 229 */     this.operator = aLNPStaticMsgUrlSchema.getOperator();
/* 230 */     this.makeDate = this.fDate.getDate(aLNPStaticMsgUrlSchema.getMakeDate());
/* 231 */     this.makeTime = this.fDate.getDate(aLNPStaticMsgUrlSchema.getMakeTime());
/* 232 */     this.modifyDate = this.fDate.getDate(aLNPStaticMsgUrlSchema.getModifyDate());
/* 233 */     this.modifyTime = this.fDate.getDate(aLNPStaticMsgUrlSchema.getModifyTime());
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 242 */       this.staMsgID = rs.getInt("StaMsgID");
/* 243 */       if (rs.getString("AssuranceCode") == null)
/* 244 */         this.assuranceCode = null;
/*     */       else {
/* 246 */         this.assuranceCode = rs.getString("AssuranceCode").trim();
/*     */       }
/* 248 */       if (rs.getString("MsgUrl") == null)
/* 249 */         this.msgUrl = null;
/*     */       else {
/* 251 */         this.msgUrl = rs.getString("MsgUrl").trim();
/*     */       }
/* 253 */       if (rs.getString("flag") == null)
/* 254 */         this.flag = null;
/*     */       else {
/* 256 */         this.flag = rs.getString("flag").trim();
/*     */       }
/* 258 */       if (rs.getString("Remarks") == null)
/* 259 */         this.remarks = null;
/*     */       else {
/* 261 */         this.remarks = rs.getString("Remarks").trim();
/*     */       }
/* 263 */       if (rs.getString("Operator") == null)
/* 264 */         this.operator = null;
/*     */       else {
/* 266 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 268 */       this.makeDate = rs.getDate("MakeDate");
/* 269 */       this.makeTime = rs.getDate("MakeTime");
/* 270 */       this.modifyDate = rs.getDate("ModifyDate");
/* 271 */       this.modifyTime = rs.getDate("ModifyTime");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 275 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPStaticMsgUrl\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 277 */       CError tError = new CError();
/* 278 */       tError.moduleName = "LNPStaticMsgUrlSchema";
/* 279 */       tError.functionName = "setSchema";
/* 280 */       tError.errorMessage = sqle.toString();
/* 281 */       this.mErrors.addOneError(tError);
/* 282 */       return false;
/*     */     }
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPStaticMsgUrlSchema getSchema()
/*     */   {
/* 289 */     LNPStaticMsgUrlSchema aLNPStaticMsgUrlSchema = new LNPStaticMsgUrlSchema();
/* 290 */     aLNPStaticMsgUrlSchema.setSchema(this);
/* 291 */     return aLNPStaticMsgUrlSchema;
/*     */   }
/*     */ 
/*     */   public LNPStaticMsgUrlDB getDB()
/*     */   {
/* 296 */     LNPStaticMsgUrlDB aDBOper = new LNPStaticMsgUrlDB();
/* 297 */     aDBOper.setSchema(this);
/* 298 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 305 */     StringBuffer strReturn = new StringBuffer(256);
/* 306 */     strReturn.append(ChgData.chgData(this.staMsgID)); strReturn.append("|");
/* 307 */     strReturn.append(StrTool.cTrim(this.assuranceCode)); strReturn.append("|");
/* 308 */     strReturn.append(StrTool.cTrim(this.msgUrl)); strReturn.append("|");
/* 309 */     strReturn.append(StrTool.cTrim(this.flag)); strReturn.append("|");
/* 310 */     strReturn.append(StrTool.cTrim(this.remarks)); strReturn.append("|");
/* 311 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 312 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 313 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeTime))); strReturn.append("|");
/* 314 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 315 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyTime)));
/* 316 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 324 */       this.staMsgID = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 1, "|"))).intValue();
/* 325 */       this.assuranceCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 326 */       this.msgUrl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 327 */       this.flag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 328 */       this.remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 329 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 330 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 331 */       this.makeTime = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 332 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/* 333 */       this.modifyTime = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 338 */       CError tError = new CError();
/* 339 */       tError.moduleName = "LNPStaticMsgUrlSchema";
/* 340 */       tError.functionName = "decode";
/* 341 */       tError.errorMessage = ex.toString();
/* 342 */       this.mErrors.addOneError(tError);
/*     */ 
/* 344 */       return false;
/*     */     }
/* 346 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 352 */     String strReturn = "";
/* 353 */     if (FCode.equalsIgnoreCase("staMsgID"))
/*     */     {
/* 355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.staMsgID));
/*     */     }
/* 357 */     if (FCode.equalsIgnoreCase("assuranceCode"))
/*     */     {
/* 359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.assuranceCode));
/*     */     }
/* 361 */     if (FCode.equalsIgnoreCase("msgUrl"))
/*     */     {
/* 363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.msgUrl));
/*     */     }
/* 365 */     if (FCode.equalsIgnoreCase("flag"))
/*     */     {
/* 367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.flag));
/*     */     }
/* 369 */     if (FCode.equalsIgnoreCase("remarks"))
/*     */     {
/* 371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remarks));
/*     */     }
/* 373 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 377 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 381 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeTime()));
/*     */     }
/* 385 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 389 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyTime()));
/*     */     }
/* 393 */     if (strReturn.equals(""))
/*     */     {
/* 395 */       strReturn = "null";
/*     */     }
/*     */ 
/* 398 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 405 */     String strFieldValue = "";
/* 406 */     switch (nFieldIndex) {
/*     */     case 0:
/* 408 */       strFieldValue = String.valueOf(this.staMsgID);
/* 409 */       break;
/*     */     case 1:
/* 411 */       strFieldValue = StrTool.GBKToUnicode(this.assuranceCode);
/* 412 */       break;
/*     */     case 2:
/* 414 */       strFieldValue = StrTool.GBKToUnicode(this.msgUrl);
/* 415 */       break;
/*     */     case 3:
/* 417 */       strFieldValue = StrTool.GBKToUnicode(this.flag);
/* 418 */       break;
/*     */     case 4:
/* 420 */       strFieldValue = StrTool.GBKToUnicode(this.remarks);
/* 421 */       break;
/*     */     case 5:
/* 423 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 424 */       break;
/*     */     case 6:
/* 426 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 427 */       break;
/*     */     case 7:
/* 429 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeTime()));
/* 430 */       break;
/*     */     case 8:
/* 432 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 433 */       break;
/*     */     case 9:
/* 435 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyTime()));
/* 436 */       break;
/*     */     default:
/* 438 */       strFieldValue = "";
/*     */     }
/* 440 */     if (strFieldValue.equals("")) {
/* 441 */       strFieldValue = "null";
/*     */     }
/* 443 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 449 */     if (StrTool.cTrim(FCode).equals("")) {
/* 450 */       return false;
/*     */     }
/* 452 */     if (FCode.equalsIgnoreCase("staMsgID"))
/*     */     {
/* 454 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 456 */         Integer tInteger = new Integer(FValue);
/* 457 */         int i = tInteger.intValue();
/* 458 */         this.staMsgID = i;
/*     */       }
/*     */     }
/* 461 */     if (FCode.equalsIgnoreCase("assuranceCode"))
/*     */     {
/* 463 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 465 */         this.assuranceCode = FValue.trim();
/*     */       }
/*     */       else
/* 468 */         this.assuranceCode = null;
/*     */     }
/* 470 */     if (FCode.equalsIgnoreCase("msgUrl"))
/*     */     {
/* 472 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 474 */         this.msgUrl = FValue.trim();
/*     */       }
/*     */       else
/* 477 */         this.msgUrl = null;
/*     */     }
/* 479 */     if (FCode.equalsIgnoreCase("flag"))
/*     */     {
/* 481 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 483 */         this.flag = FValue.trim();
/*     */       }
/*     */       else
/* 486 */         this.flag = null;
/*     */     }
/* 488 */     if (FCode.equalsIgnoreCase("remarks"))
/*     */     {
/* 490 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 492 */         this.remarks = FValue.trim();
/*     */       }
/*     */       else
/* 495 */         this.remarks = null;
/*     */     }
/* 497 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 499 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 501 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 504 */         this.operator = null;
/*     */     }
/* 506 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 508 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 510 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 513 */         this.makeDate = null;
/*     */     }
/* 515 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 517 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 519 */         this.makeTime = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 522 */         this.makeTime = null;
/*     */     }
/* 524 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 526 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 528 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 531 */         this.modifyDate = null;
/*     */     }
/* 533 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 535 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 537 */         this.modifyTime = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 540 */         this.modifyTime = null;
/*     */     }
/* 542 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 547 */     if (otherObject == null) return false;
/* 548 */     if (this == otherObject) return true;
/* 549 */     if (getClass() != otherObject.getClass()) return false;
/* 550 */     LNPStaticMsgUrlSchema other = (LNPStaticMsgUrlSchema)otherObject;
/* 551 */     if (this.staMsgID != other.getStaMsgID()) return false;
/* 552 */     if ((this.assuranceCode == null) && (other.getAssuranceCode() != null)) return false;
/* 553 */     if ((this.assuranceCode != null) && (!this.assuranceCode.equals(other.getAssuranceCode()))) return false;
/* 554 */     if ((this.msgUrl == null) && (other.getMsgUrl() != null)) return false;
/* 555 */     if ((this.msgUrl != null) && (!this.msgUrl.equals(other.getMsgUrl()))) return false;
/* 556 */     if ((this.flag == null) && (other.getFlag() != null)) return false;
/* 557 */     if ((this.flag != null) && (!this.flag.equals(other.getFlag()))) return false;
/* 558 */     if ((this.remarks == null) && (other.getRemarks() != null)) return false;
/* 559 */     if ((this.remarks != null) && (!this.remarks.equals(other.getRemarks()))) return false;
/* 560 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 561 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 562 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 563 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 564 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 565 */     if ((this.makeTime != null) && (!this.fDate.getString(this.makeTime).equals(other.getMakeTime()))) return false;
/* 566 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 567 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 568 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 569 */     return (this.modifyTime == null) || (this.fDate.getString(this.modifyTime).equals(other.getModifyTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 576 */     return 10;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 582 */     if (strFieldName.equals("staMsgID")) {
/* 583 */       return 0;
/*     */     }
/* 585 */     if (strFieldName.equals("assuranceCode")) {
/* 586 */       return 1;
/*     */     }
/* 588 */     if (strFieldName.equals("msgUrl")) {
/* 589 */       return 2;
/*     */     }
/* 591 */     if (strFieldName.equals("flag")) {
/* 592 */       return 3;
/*     */     }
/* 594 */     if (strFieldName.equals("remarks")) {
/* 595 */       return 4;
/*     */     }
/* 597 */     if (strFieldName.equals("operator")) {
/* 598 */       return 5;
/*     */     }
/* 600 */     if (strFieldName.equals("makeDate")) {
/* 601 */       return 6;
/*     */     }
/* 603 */     if (strFieldName.equals("makeTime")) {
/* 604 */       return 7;
/*     */     }
/* 606 */     if (strFieldName.equals("modifyDate")) {
/* 607 */       return 8;
/*     */     }
/* 609 */     if (strFieldName.equals("modifyTime")) {
/* 610 */       return 9;
/*     */     }
/* 612 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 618 */     String strFieldName = "";
/* 619 */     switch (nFieldIndex) {
/*     */     case 0:
/* 621 */       strFieldName = "staMsgID";
/* 622 */       break;
/*     */     case 1:
/* 624 */       strFieldName = "assuranceCode";
/* 625 */       break;
/*     */     case 2:
/* 627 */       strFieldName = "msgUrl";
/* 628 */       break;
/*     */     case 3:
/* 630 */       strFieldName = "flag";
/* 631 */       break;
/*     */     case 4:
/* 633 */       strFieldName = "remarks";
/* 634 */       break;
/*     */     case 5:
/* 636 */       strFieldName = "operator";
/* 637 */       break;
/*     */     case 6:
/* 639 */       strFieldName = "makeDate";
/* 640 */       break;
/*     */     case 7:
/* 642 */       strFieldName = "makeTime";
/* 643 */       break;
/*     */     case 8:
/* 645 */       strFieldName = "modifyDate";
/* 646 */       break;
/*     */     case 9:
/* 648 */       strFieldName = "modifyTime";
/* 649 */       break;
/*     */     default:
/* 651 */       strFieldName = "";
/*     */     }
/* 653 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 659 */     if (strFieldName.equals("staMsgID")) {
/* 660 */       return 3;
/*     */     }
/* 662 */     if (strFieldName.equals("assuranceCode")) {
/* 663 */       return 0;
/*     */     }
/* 665 */     if (strFieldName.equals("msgUrl")) {
/* 666 */       return 0;
/*     */     }
/* 668 */     if (strFieldName.equals("flag")) {
/* 669 */       return 0;
/*     */     }
/* 671 */     if (strFieldName.equals("remarks")) {
/* 672 */       return 0;
/*     */     }
/* 674 */     if (strFieldName.equals("operator")) {
/* 675 */       return 0;
/*     */     }
/* 677 */     if (strFieldName.equals("makeDate")) {
/* 678 */       return 1;
/*     */     }
/* 680 */     if (strFieldName.equals("makeTime")) {
/* 681 */       return 1;
/*     */     }
/* 683 */     if (strFieldName.equals("modifyDate")) {
/* 684 */       return 1;
/*     */     }
/* 686 */     if (strFieldName.equals("modifyTime")) {
/* 687 */       return 1;
/*     */     }
/* 689 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 695 */     int nFieldType = -1;
/* 696 */     switch (nFieldIndex) {
/*     */     case 0:
/* 698 */       nFieldType = 3;
/* 699 */       break;
/*     */     case 1:
/* 701 */       nFieldType = 0;
/* 702 */       break;
/*     */     case 2:
/* 704 */       nFieldType = 0;
/* 705 */       break;
/*     */     case 3:
/* 707 */       nFieldType = 0;
/* 708 */       break;
/*     */     case 4:
/* 710 */       nFieldType = 0;
/* 711 */       break;
/*     */     case 5:
/* 713 */       nFieldType = 0;
/* 714 */       break;
/*     */     case 6:
/* 716 */       nFieldType = 1;
/* 717 */       break;
/*     */     case 7:
/* 719 */       nFieldType = 1;
/* 720 */       break;
/*     */     case 8:
/* 722 */       nFieldType = 1;
/* 723 */       break;
/*     */     case 9:
/* 725 */       nFieldType = 1;
/* 726 */       break;
/*     */     default:
/* 728 */       nFieldType = -1;
/*     */     }
/* 730 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPStaticMsgUrlSchema
 * JD-Core Version:    0.6.0
 */