/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MUserRoleMapDB;
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
/*     */ public class MUserRoleMapSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String userCode;
/*     */   private String roleID;
/*     */   private String type;
/*     */   private Date startDate;
/*     */   private Date endDate;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   private int int1;
/*     */   private int int2;
/*     */   private String varc1;
/*     */   private String varc2;
/*     */   public static final int FIELDNUM = 15;
/*     */   private static String[] PK;
/*  54 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MUserRoleMapSchema()
/*     */   {
/*  61 */     this.mErrors = new CErrors();
/*     */ 
/*  63 */     String[] pk = new String[1];
/*  64 */     pk[0] = "ID";
/*     */ 
/*  66 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  73 */     MUserRoleMapSchema cloned = (MUserRoleMapSchema)super.clone();
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
/*     */   public String getID()
/*     */   {
/*  87 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  91 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/*  95 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String aUserCode) {
/*  99 */     this.userCode = aUserCode;
/*     */   }
/*     */ 
/*     */   public String getRoleID() {
/* 103 */     return this.roleID;
/*     */   }
/*     */ 
/*     */   public void setRoleID(String aRoleID) {
/* 107 */     this.roleID = aRoleID;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 111 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String aType) {
/* 115 */     this.type = aType;
/*     */   }
/*     */ 
/*     */   public String getStartDate() {
/* 119 */     if (this.startDate != null) {
/* 120 */       return this.fDate.getString(this.startDate);
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   public void setStartDate(Date aStartDate) {
/* 126 */     this.startDate = aStartDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String aStartDate) {
/* 130 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*     */     {
/* 132 */       this.startDate = this.fDate.getDate(aStartDate);
/*     */     }
/*     */     else
/* 135 */       this.startDate = null;
/*     */   }
/*     */ 
/*     */   public String getEndDate()
/*     */   {
/* 140 */     if (this.endDate != null) {
/* 141 */       return this.fDate.getString(this.endDate);
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   public void setEndDate(Date aEndDate) {
/* 147 */     this.endDate = aEndDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String aEndDate) {
/* 151 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*     */     {
/* 153 */       this.endDate = this.fDate.getDate(aEndDate);
/*     */     }
/*     */     else
/* 156 */       this.endDate = null;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 161 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 165 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 169 */     if (this.makeDate != null) {
/* 170 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 176 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 180 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 182 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 185 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 190 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 194 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 198 */     if (this.modifyDate != null) {
/* 199 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 201 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 205 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 209 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 211 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 214 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 219 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 223 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public int getInt1() {
/* 227 */     return this.int1;
/*     */   }
/*     */ 
/*     */   public void setInt1(int aInt1) {
/* 231 */     this.int1 = aInt1;
/*     */   }
/*     */ 
/*     */   public void setInt1(String aInt1) {
/* 235 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*     */     {
/* 237 */       Integer tInteger = new Integer(aInt1);
/* 238 */       int i = tInteger.intValue();
/* 239 */       this.int1 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getInt2()
/*     */   {
/* 245 */     return this.int2;
/*     */   }
/*     */ 
/*     */   public void setInt2(int aInt2) {
/* 249 */     this.int2 = aInt2;
/*     */   }
/*     */ 
/*     */   public void setInt2(String aInt2) {
/* 253 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*     */     {
/* 255 */       Integer tInteger = new Integer(aInt2);
/* 256 */       int i = tInteger.intValue();
/* 257 */       this.int2 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getVarc1()
/*     */   {
/* 263 */     return this.varc1;
/*     */   }
/*     */ 
/*     */   public void setVarc1(String aVarc1) {
/* 267 */     this.varc1 = aVarc1;
/*     */   }
/*     */ 
/*     */   public String getVarc2() {
/* 271 */     return this.varc2;
/*     */   }
/*     */ 
/*     */   public void setVarc2(String aVarc2) {
/* 275 */     this.varc2 = aVarc2;
/*     */   }
/*     */ 
/*     */   public void setSchema(MUserRoleMapSchema aMUserRoleMapSchema)
/*     */   {
/* 281 */     this.iD = aMUserRoleMapSchema.getID();
/* 282 */     this.userCode = aMUserRoleMapSchema.getUserCode();
/* 283 */     this.roleID = aMUserRoleMapSchema.getRoleID();
/* 284 */     this.type = aMUserRoleMapSchema.getType();
/* 285 */     this.startDate = this.fDate.getDate(aMUserRoleMapSchema.getStartDate());
/* 286 */     this.endDate = this.fDate.getDate(aMUserRoleMapSchema.getEndDate());
/* 287 */     this.operator = aMUserRoleMapSchema.getOperator();
/* 288 */     this.makeDate = this.fDate.getDate(aMUserRoleMapSchema.getMakeDate());
/* 289 */     this.makeTime = aMUserRoleMapSchema.getMakeTime();
/* 290 */     this.modifyDate = this.fDate.getDate(aMUserRoleMapSchema.getModifyDate());
/* 291 */     this.modifyTime = aMUserRoleMapSchema.getModifyTime();
/* 292 */     this.int1 = aMUserRoleMapSchema.getInt1();
/* 293 */     this.int2 = aMUserRoleMapSchema.getInt2();
/* 294 */     this.varc1 = aMUserRoleMapSchema.getVarc1();
/* 295 */     this.varc2 = aMUserRoleMapSchema.getVarc2();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 304 */       if (rs.getString("ID") == null)
/* 305 */         this.iD = null;
/*     */       else {
/* 307 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 309 */       if (rs.getString("UserCode") == null)
/* 310 */         this.userCode = null;
/*     */       else {
/* 312 */         this.userCode = rs.getString("UserCode").trim();
/*     */       }
/* 314 */       if (rs.getString("RoleID") == null)
/* 315 */         this.roleID = null;
/*     */       else {
/* 317 */         this.roleID = rs.getString("RoleID").trim();
/*     */       }
/* 319 */       if (rs.getString("Type") == null)
/* 320 */         this.type = null;
/*     */       else {
/* 322 */         this.type = rs.getString("Type").trim();
/*     */       }
/* 324 */       this.startDate = rs.getDate("StartDate");
/* 325 */       this.endDate = rs.getDate("EndDate");
/* 326 */       if (rs.getString("Operator") == null)
/* 327 */         this.operator = null;
/*     */       else {
/* 329 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 331 */       this.makeDate = rs.getDate("MakeDate");
/* 332 */       if (rs.getString("MakeTime") == null)
/* 333 */         this.makeTime = null;
/*     */       else {
/* 335 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 337 */       this.modifyDate = rs.getDate("ModifyDate");
/* 338 */       if (rs.getString("ModifyTime") == null)
/* 339 */         this.modifyTime = null;
/*     */       else {
/* 341 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 343 */       this.int1 = rs.getInt("Int1");
/* 344 */       this.int2 = rs.getInt("Int2");
/* 345 */       if (rs.getString("Varc1") == null)
/* 346 */         this.varc1 = null;
/*     */       else {
/* 348 */         this.varc1 = rs.getString("Varc1").trim();
/*     */       }
/* 350 */       if (rs.getString("Varc2") == null)
/* 351 */         this.varc2 = null;
/*     */       else {
/* 353 */         this.varc2 = rs.getString("Varc2").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 358 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MUserRoleMap\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 360 */       CError tError = new CError();
/* 361 */       tError.moduleName = "MUserRoleMapSchema";
/* 362 */       tError.functionName = "setSchema";
/* 363 */       tError.errorMessage = sqle.toString();
/* 364 */       this.mErrors.addOneError(tError);
/* 365 */       return false;
/*     */     }
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */   public MUserRoleMapSchema getSchema()
/*     */   {
/* 372 */     MUserRoleMapSchema aMUserRoleMapSchema = new MUserRoleMapSchema();
/* 373 */     aMUserRoleMapSchema.setSchema(this);
/* 374 */     return aMUserRoleMapSchema;
/*     */   }
/*     */ 
/*     */   public MUserRoleMapDB getDB()
/*     */   {
/* 379 */     MUserRoleMapDB aDBOper = new MUserRoleMapDB();
/* 380 */     aDBOper.setSchema(this);
/* 381 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 388 */     StringBuffer strReturn = new StringBuffer(256);
/* 389 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 390 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/* 391 */     strReturn.append(StrTool.cTrim(this.roleID)); strReturn.append("|");
/* 392 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/* 393 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/* 394 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/* 395 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 396 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 397 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 398 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 399 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 400 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/* 401 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/* 402 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/* 403 */     strReturn.append(StrTool.cTrim(this.varc2));
/* 404 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 412 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 413 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 414 */       this.roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 415 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 416 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/* 417 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 418 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 419 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 420 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 421 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 422 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 423 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/* 424 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/* 425 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 426 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 431 */       CError tError = new CError();
/* 432 */       tError.moduleName = "MUserRoleMapSchema";
/* 433 */       tError.functionName = "decode";
/* 434 */       tError.errorMessage = ex.toString();
/* 435 */       this.mErrors.addOneError(tError);
/*     */ 
/* 437 */       return false;
/*     */     }
/* 439 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 445 */     String strReturn = "";
/* 446 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 448 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 450 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 452 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*     */     }
/* 454 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 456 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleID));
/*     */     }
/* 458 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*     */     }
/* 462 */     if (FCode.equalsIgnoreCase("startDate"))
/*     */     {
/* 464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*     */     }
/* 466 */     if (FCode.equalsIgnoreCase("endDate"))
/*     */     {
/* 468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*     */     }
/* 470 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 474 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 478 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 482 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 486 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 490 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*     */     }
/* 494 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*     */     }
/* 498 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*     */     }
/* 502 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*     */     }
/* 506 */     if (strReturn.equals(""))
/*     */     {
/* 508 */       strReturn = "null";
/*     */     }
/*     */ 
/* 511 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 518 */     String strFieldValue = "";
/* 519 */     switch (nFieldIndex) {
/*     */     case 0:
/* 521 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 522 */       break;
/*     */     case 1:
/* 524 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/* 525 */       break;
/*     */     case 2:
/* 527 */       strFieldValue = StrTool.GBKToUnicode(this.roleID);
/* 528 */       break;
/*     */     case 3:
/* 530 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 531 */       break;
/*     */     case 4:
/* 533 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 534 */       break;
/*     */     case 5:
/* 536 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 537 */       break;
/*     */     case 6:
/* 539 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 540 */       break;
/*     */     case 7:
/* 542 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 543 */       break;
/*     */     case 8:
/* 545 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 546 */       break;
/*     */     case 9:
/* 548 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 549 */       break;
/*     */     case 10:
/* 551 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 552 */       break;
/*     */     case 11:
/* 554 */       strFieldValue = String.valueOf(this.int1);
/* 555 */       break;
/*     */     case 12:
/* 557 */       strFieldValue = String.valueOf(this.int2);
/* 558 */       break;
/*     */     case 13:
/* 560 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/* 561 */       break;
/*     */     case 14:
/* 563 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/* 564 */       break;
/*     */     default:
/* 566 */       strFieldValue = "";
/*     */     }
/* 568 */     if (strFieldValue.equals("")) {
/* 569 */       strFieldValue = "null";
/*     */     }
/* 571 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 577 */     if (StrTool.cTrim(FCode).equals("")) {
/* 578 */       return false;
/*     */     }
/* 580 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 582 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 584 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 587 */         this.iD = null;
/*     */     }
/* 589 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 591 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 593 */         this.userCode = FValue.trim();
/*     */       }
/*     */       else
/* 596 */         this.userCode = null;
/*     */     }
/* 598 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 600 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 602 */         this.roleID = FValue.trim();
/*     */       }
/*     */       else
/* 605 */         this.roleID = null;
/*     */     }
/* 607 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 609 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 611 */         this.type = FValue.trim();
/*     */       }
/*     */       else
/* 614 */         this.type = null;
/*     */     }
/* 616 */     if (FCode.equalsIgnoreCase("startDate"))
/*     */     {
/* 618 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 620 */         this.startDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 623 */         this.startDate = null;
/*     */     }
/* 625 */     if (FCode.equalsIgnoreCase("endDate"))
/*     */     {
/* 627 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 629 */         this.endDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 632 */         this.endDate = null;
/*     */     }
/* 634 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 636 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 638 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 641 */         this.operator = null;
/*     */     }
/* 643 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 645 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 647 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 650 */         this.makeDate = null;
/*     */     }
/* 652 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 654 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 656 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 659 */         this.makeTime = null;
/*     */     }
/* 661 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 663 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 665 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 668 */         this.modifyDate = null;
/*     */     }
/* 670 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 672 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 674 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 677 */         this.modifyTime = null;
/*     */     }
/* 679 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 681 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 683 */         Integer tInteger = new Integer(FValue);
/* 684 */         int i = tInteger.intValue();
/* 685 */         this.int1 = i;
/*     */       }
/*     */     }
/* 688 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 690 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 692 */         Integer tInteger = new Integer(FValue);
/* 693 */         int i = tInteger.intValue();
/* 694 */         this.int2 = i;
/*     */       }
/*     */     }
/* 697 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 699 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 701 */         this.varc1 = FValue.trim();
/*     */       }
/*     */       else
/* 704 */         this.varc1 = null;
/*     */     }
/* 706 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 708 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 710 */         this.varc2 = FValue.trim();
/*     */       }
/*     */       else
/* 713 */         this.varc2 = null;
/*     */     }
/* 715 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 720 */     if (otherObject == null) return false;
/* 721 */     if (this == otherObject) return true;
/* 722 */     if (getClass() != otherObject.getClass()) return false;
/* 723 */     MUserRoleMapSchema other = (MUserRoleMapSchema)otherObject;
/* 724 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 725 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 726 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/* 727 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/* 728 */     if ((this.roleID == null) && (other.getRoleID() != null)) return false;
/* 729 */     if ((this.roleID != null) && (!this.roleID.equals(other.getRoleID()))) return false;
/* 730 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 731 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 732 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 733 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 734 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 735 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 736 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 737 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 738 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 739 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 740 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 741 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 742 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 743 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 744 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 745 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 746 */     if (this.int1 != other.getInt1()) return false;
/* 747 */     if (this.int2 != other.getInt2()) return false;
/* 748 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/* 749 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/* 750 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/* 751 */     return (this.varc2 == null) || (this.varc2.equals(other.getVarc2()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 758 */     return 15;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 764 */     if (strFieldName.equals("iD")) {
/* 765 */       return 0;
/*     */     }
/* 767 */     if (strFieldName.equals("userCode")) {
/* 768 */       return 1;
/*     */     }
/* 770 */     if (strFieldName.equals("roleID")) {
/* 771 */       return 2;
/*     */     }
/* 773 */     if (strFieldName.equals("type")) {
/* 774 */       return 3;
/*     */     }
/* 776 */     if (strFieldName.equals("startDate")) {
/* 777 */       return 4;
/*     */     }
/* 779 */     if (strFieldName.equals("endDate")) {
/* 780 */       return 5;
/*     */     }
/* 782 */     if (strFieldName.equals("operator")) {
/* 783 */       return 6;
/*     */     }
/* 785 */     if (strFieldName.equals("makeDate")) {
/* 786 */       return 7;
/*     */     }
/* 788 */     if (strFieldName.equals("makeTime")) {
/* 789 */       return 8;
/*     */     }
/* 791 */     if (strFieldName.equals("modifyDate")) {
/* 792 */       return 9;
/*     */     }
/* 794 */     if (strFieldName.equals("modifyTime")) {
/* 795 */       return 10;
/*     */     }
/* 797 */     if (strFieldName.equals("int1")) {
/* 798 */       return 11;
/*     */     }
/* 800 */     if (strFieldName.equals("int2")) {
/* 801 */       return 12;
/*     */     }
/* 803 */     if (strFieldName.equals("varc1")) {
/* 804 */       return 13;
/*     */     }
/* 806 */     if (strFieldName.equals("varc2")) {
/* 807 */       return 14;
/*     */     }
/* 809 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 815 */     String strFieldName = "";
/* 816 */     switch (nFieldIndex) {
/*     */     case 0:
/* 818 */       strFieldName = "iD";
/* 819 */       break;
/*     */     case 1:
/* 821 */       strFieldName = "userCode";
/* 822 */       break;
/*     */     case 2:
/* 824 */       strFieldName = "roleID";
/* 825 */       break;
/*     */     case 3:
/* 827 */       strFieldName = "type";
/* 828 */       break;
/*     */     case 4:
/* 830 */       strFieldName = "startDate";
/* 831 */       break;
/*     */     case 5:
/* 833 */       strFieldName = "endDate";
/* 834 */       break;
/*     */     case 6:
/* 836 */       strFieldName = "operator";
/* 837 */       break;
/*     */     case 7:
/* 839 */       strFieldName = "makeDate";
/* 840 */       break;
/*     */     case 8:
/* 842 */       strFieldName = "makeTime";
/* 843 */       break;
/*     */     case 9:
/* 845 */       strFieldName = "modifyDate";
/* 846 */       break;
/*     */     case 10:
/* 848 */       strFieldName = "modifyTime";
/* 849 */       break;
/*     */     case 11:
/* 851 */       strFieldName = "int1";
/* 852 */       break;
/*     */     case 12:
/* 854 */       strFieldName = "int2";
/* 855 */       break;
/*     */     case 13:
/* 857 */       strFieldName = "varc1";
/* 858 */       break;
/*     */     case 14:
/* 860 */       strFieldName = "varc2";
/* 861 */       break;
/*     */     default:
/* 863 */       strFieldName = "";
/*     */     }
/* 865 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 871 */     if (strFieldName.equals("iD")) {
/* 872 */       return 0;
/*     */     }
/* 874 */     if (strFieldName.equals("userCode")) {
/* 875 */       return 0;
/*     */     }
/* 877 */     if (strFieldName.equals("roleID")) {
/* 878 */       return 0;
/*     */     }
/* 880 */     if (strFieldName.equals("type")) {
/* 881 */       return 0;
/*     */     }
/* 883 */     if (strFieldName.equals("startDate")) {
/* 884 */       return 1;
/*     */     }
/* 886 */     if (strFieldName.equals("endDate")) {
/* 887 */       return 1;
/*     */     }
/* 889 */     if (strFieldName.equals("operator")) {
/* 890 */       return 0;
/*     */     }
/* 892 */     if (strFieldName.equals("makeDate")) {
/* 893 */       return 1;
/*     */     }
/* 895 */     if (strFieldName.equals("makeTime")) {
/* 896 */       return 0;
/*     */     }
/* 898 */     if (strFieldName.equals("modifyDate")) {
/* 899 */       return 1;
/*     */     }
/* 901 */     if (strFieldName.equals("modifyTime")) {
/* 902 */       return 0;
/*     */     }
/* 904 */     if (strFieldName.equals("int1")) {
/* 905 */       return 3;
/*     */     }
/* 907 */     if (strFieldName.equals("int2")) {
/* 908 */       return 3;
/*     */     }
/* 910 */     if (strFieldName.equals("varc1")) {
/* 911 */       return 0;
/*     */     }
/* 913 */     if (strFieldName.equals("varc2")) {
/* 914 */       return 0;
/*     */     }
/* 916 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 922 */     int nFieldType = -1;
/* 923 */     switch (nFieldIndex) {
/*     */     case 0:
/* 925 */       nFieldType = 0;
/* 926 */       break;
/*     */     case 1:
/* 928 */       nFieldType = 0;
/* 929 */       break;
/*     */     case 2:
/* 931 */       nFieldType = 0;
/* 932 */       break;
/*     */     case 3:
/* 934 */       nFieldType = 0;
/* 935 */       break;
/*     */     case 4:
/* 937 */       nFieldType = 1;
/* 938 */       break;
/*     */     case 5:
/* 940 */       nFieldType = 1;
/* 941 */       break;
/*     */     case 6:
/* 943 */       nFieldType = 0;
/* 944 */       break;
/*     */     case 7:
/* 946 */       nFieldType = 1;
/* 947 */       break;
/*     */     case 8:
/* 949 */       nFieldType = 0;
/* 950 */       break;
/*     */     case 9:
/* 952 */       nFieldType = 1;
/* 953 */       break;
/*     */     case 10:
/* 955 */       nFieldType = 0;
/* 956 */       break;
/*     */     case 11:
/* 958 */       nFieldType = 3;
/* 959 */       break;
/*     */     case 12:
/* 961 */       nFieldType = 3;
/* 962 */       break;
/*     */     case 13:
/* 964 */       nFieldType = 0;
/* 965 */       break;
/*     */     case 14:
/* 967 */       nFieldType = 0;
/* 968 */       break;
/*     */     default:
/* 970 */       nFieldType = -1;
/*     */     }
/* 972 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MUserRoleMapSchema
 * JD-Core Version:    0.6.0
 */