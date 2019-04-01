/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPUserRoleMapDB;
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
/*     */ public class LNPUserRoleMapSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String userCode;
/*     */   private String roleCode;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   private int int1;
/*     */   private int int2;
/*     */   private String varc1;
/*     */   private String varc2;
/*     */   private String varc3;
/*     */   public static final int FIELDNUM = 13;
/*     */   private static String[] PK;
/*  53 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPUserRoleMapSchema()
/*     */   {
/*  60 */     this.mErrors = new CErrors();
/*     */ 
/*  62 */     String[] pk = new String[1];
/*  63 */     pk[0] = "ID";
/*     */ 
/*  65 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  72 */     LNPUserRoleMapSchema cloned = (LNPUserRoleMapSchema)super.clone();
/*  73 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  74 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  75 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  81 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  86 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  90 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/*  94 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String aUserCode) {
/*  98 */     this.userCode = aUserCode;
/*     */   }
/*     */ 
/*     */   public String getRoleCode() {
/* 102 */     return this.roleCode;
/*     */   }
/*     */ 
/*     */   public void setRoleCode(String aRoleCode) {
/* 106 */     this.roleCode = aRoleCode;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 110 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 114 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 118 */     if (this.makeDate != null) {
/* 119 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 125 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 129 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 131 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 134 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 139 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 143 */     this.makeTime = aMakeTime;
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
/*     */   public String getModifyTime()
/*     */   {
/* 168 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 172 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public int getInt1() {
/* 176 */     return this.int1;
/*     */   }
/*     */ 
/*     */   public void setInt1(int aInt1) {
/* 180 */     this.int1 = aInt1;
/*     */   }
/*     */ 
/*     */   public void setInt1(String aInt1) {
/* 184 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*     */     {
/* 186 */       Integer tInteger = new Integer(aInt1);
/* 187 */       int i = tInteger.intValue();
/* 188 */       this.int1 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getInt2()
/*     */   {
/* 194 */     return this.int2;
/*     */   }
/*     */ 
/*     */   public void setInt2(int aInt2) {
/* 198 */     this.int2 = aInt2;
/*     */   }
/*     */ 
/*     */   public void setInt2(String aInt2) {
/* 202 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*     */     {
/* 204 */       Integer tInteger = new Integer(aInt2);
/* 205 */       int i = tInteger.intValue();
/* 206 */       this.int2 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getVarc1()
/*     */   {
/* 212 */     return this.varc1;
/*     */   }
/*     */ 
/*     */   public void setVarc1(String aVarc1) {
/* 216 */     this.varc1 = aVarc1;
/*     */   }
/*     */ 
/*     */   public String getVarc2() {
/* 220 */     return this.varc2;
/*     */   }
/*     */ 
/*     */   public void setVarc2(String aVarc2) {
/* 224 */     this.varc2 = aVarc2;
/*     */   }
/*     */ 
/*     */   public String getVarc3() {
/* 228 */     return this.varc3;
/*     */   }
/*     */ 
/*     */   public void setVarc3(String aVarc3) {
/* 232 */     this.varc3 = aVarc3;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPUserRoleMapSchema aLNPUserRoleMapSchema)
/*     */   {
/* 238 */     this.iD = aLNPUserRoleMapSchema.getID();
/* 239 */     this.userCode = aLNPUserRoleMapSchema.getUserCode();
/* 240 */     this.roleCode = aLNPUserRoleMapSchema.getRoleCode();
/* 241 */     this.operator = aLNPUserRoleMapSchema.getOperator();
/* 242 */     this.makeDate = this.fDate.getDate(aLNPUserRoleMapSchema.getMakeDate());
/* 243 */     this.makeTime = aLNPUserRoleMapSchema.getMakeTime();
/* 244 */     this.modifyDate = this.fDate.getDate(aLNPUserRoleMapSchema.getModifyDate());
/* 245 */     this.modifyTime = aLNPUserRoleMapSchema.getModifyTime();
/* 246 */     this.int1 = aLNPUserRoleMapSchema.getInt1();
/* 247 */     this.int2 = aLNPUserRoleMapSchema.getInt2();
/* 248 */     this.varc1 = aLNPUserRoleMapSchema.getVarc1();
/* 249 */     this.varc2 = aLNPUserRoleMapSchema.getVarc2();
/* 250 */     this.varc3 = aLNPUserRoleMapSchema.getVarc3();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 259 */       if (rs.getString("ID") == null)
/* 260 */         this.iD = null;
/*     */       else {
/* 262 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 264 */       if (rs.getString("UserCode") == null)
/* 265 */         this.userCode = null;
/*     */       else {
/* 267 */         this.userCode = rs.getString("UserCode").trim();
/*     */       }
/* 269 */       if (rs.getString("RoleCode") == null)
/* 270 */         this.roleCode = null;
/*     */       else {
/* 272 */         this.roleCode = rs.getString("RoleCode").trim();
/*     */       }
/* 274 */       if (rs.getString("Operator") == null)
/* 275 */         this.operator = null;
/*     */       else {
/* 277 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 279 */       this.makeDate = rs.getDate("MakeDate");
/* 280 */       if (rs.getString("MakeTime") == null)
/* 281 */         this.makeTime = null;
/*     */       else {
/* 283 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 285 */       this.modifyDate = rs.getDate("ModifyDate");
/* 286 */       if (rs.getString("ModifyTime") == null)
/* 287 */         this.modifyTime = null;
/*     */       else {
/* 289 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 291 */       this.int1 = rs.getInt("Int1");
/* 292 */       this.int2 = rs.getInt("Int2");
/* 293 */       if (rs.getString("Varc1") == null)
/* 294 */         this.varc1 = null;
/*     */       else {
/* 296 */         this.varc1 = rs.getString("Varc1").trim();
/*     */       }
/* 298 */       if (rs.getString("Varc2") == null)
/* 299 */         this.varc2 = null;
/*     */       else {
/* 301 */         this.varc2 = rs.getString("Varc2").trim();
/*     */       }
/* 303 */       if (rs.getString("Varc3") == null)
/* 304 */         this.varc3 = null;
/*     */       else {
/* 306 */         this.varc3 = rs.getString("Varc3").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 311 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPUserRoleMap\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 313 */       CError tError = new CError();
/* 314 */       tError.moduleName = "LNPUserRoleMapSchema";
/* 315 */       tError.functionName = "setSchema";
/* 316 */       tError.errorMessage = sqle.toString();
/* 317 */       this.mErrors.addOneError(tError);
/* 318 */       return false;
/*     */     }
/* 320 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPUserRoleMapSchema getSchema()
/*     */   {
/* 325 */     LNPUserRoleMapSchema aLNPUserRoleMapSchema = new LNPUserRoleMapSchema();
/* 326 */     aLNPUserRoleMapSchema.setSchema(this);
/* 327 */     return aLNPUserRoleMapSchema;
/*     */   }
/*     */ 
/*     */   public LNPUserRoleMapDB getDB()
/*     */   {
/* 332 */     LNPUserRoleMapDB aDBOper = new LNPUserRoleMapDB();
/* 333 */     aDBOper.setSchema(this);
/* 334 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 341 */     StringBuffer strReturn = new StringBuffer(256);
/* 342 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 343 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/* 344 */     strReturn.append(StrTool.cTrim(this.roleCode)); strReturn.append("|");
/* 345 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 346 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 347 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 348 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 349 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 350 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/* 351 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/* 352 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/* 353 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/* 354 */     strReturn.append(StrTool.cTrim(this.varc3));
/* 355 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 363 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 364 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 365 */       this.roleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 366 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 367 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/* 368 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 369 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 370 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 371 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/* 372 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/* 373 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 374 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 375 */       this.varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 380 */       CError tError = new CError();
/* 381 */       tError.moduleName = "LNPUserRoleMapSchema";
/* 382 */       tError.functionName = "decode";
/* 383 */       tError.errorMessage = ex.toString();
/* 384 */       this.mErrors.addOneError(tError);
/*     */ 
/* 386 */       return false;
/*     */     }
/* 388 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 394 */     String strReturn = "";
/* 395 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 397 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 399 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 401 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*     */     }
/* 403 */     if (FCode.equalsIgnoreCase("roleCode"))
/*     */     {
/* 405 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleCode));
/*     */     }
/* 407 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 409 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 411 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 413 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 415 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 417 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 419 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 421 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 423 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 425 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 427 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 429 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*     */     }
/* 431 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 433 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*     */     }
/* 435 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 437 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*     */     }
/* 439 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 441 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*     */     }
/* 443 */     if (FCode.equalsIgnoreCase("varc3"))
/*     */     {
/* 445 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc3));
/*     */     }
/* 447 */     if (strReturn.equals(""))
/*     */     {
/* 449 */       strReturn = "null";
/*     */     }
/*     */ 
/* 452 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 459 */     String strFieldValue = "";
/* 460 */     switch (nFieldIndex) {
/*     */     case 0:
/* 462 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 463 */       break;
/*     */     case 1:
/* 465 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/* 466 */       break;
/*     */     case 2:
/* 468 */       strFieldValue = StrTool.GBKToUnicode(this.roleCode);
/* 469 */       break;
/*     */     case 3:
/* 471 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 472 */       break;
/*     */     case 4:
/* 474 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 475 */       break;
/*     */     case 5:
/* 477 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 478 */       break;
/*     */     case 6:
/* 480 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 481 */       break;
/*     */     case 7:
/* 483 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 484 */       break;
/*     */     case 8:
/* 486 */       strFieldValue = String.valueOf(this.int1);
/* 487 */       break;
/*     */     case 9:
/* 489 */       strFieldValue = String.valueOf(this.int2);
/* 490 */       break;
/*     */     case 10:
/* 492 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/* 493 */       break;
/*     */     case 11:
/* 495 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/* 496 */       break;
/*     */     case 12:
/* 498 */       strFieldValue = StrTool.GBKToUnicode(this.varc3);
/* 499 */       break;
/*     */     default:
/* 501 */       strFieldValue = "";
/*     */     }
/* 503 */     if (strFieldValue.equals("")) {
/* 504 */       strFieldValue = "null";
/*     */     }
/* 506 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 512 */     if (StrTool.cTrim(FCode).equals("")) {
/* 513 */       return false;
/*     */     }
/* 515 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 517 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 519 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 522 */         this.iD = null;
/*     */     }
/* 524 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 526 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 528 */         this.userCode = FValue.trim();
/*     */       }
/*     */       else
/* 531 */         this.userCode = null;
/*     */     }
/* 533 */     if (FCode.equalsIgnoreCase("roleCode"))
/*     */     {
/* 535 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 537 */         this.roleCode = FValue.trim();
/*     */       }
/*     */       else
/* 540 */         this.roleCode = null;
/*     */     }
/* 542 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 544 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 546 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 549 */         this.operator = null;
/*     */     }
/* 551 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 553 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 555 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 558 */         this.makeDate = null;
/*     */     }
/* 560 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 562 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 564 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 567 */         this.makeTime = null;
/*     */     }
/* 569 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 571 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 573 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 576 */         this.modifyDate = null;
/*     */     }
/* 578 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 580 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 582 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 585 */         this.modifyTime = null;
/*     */     }
/* 587 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 589 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 591 */         Integer tInteger = new Integer(FValue);
/* 592 */         int i = tInteger.intValue();
/* 593 */         this.int1 = i;
/*     */       }
/*     */     }
/* 596 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 598 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 600 */         Integer tInteger = new Integer(FValue);
/* 601 */         int i = tInteger.intValue();
/* 602 */         this.int2 = i;
/*     */       }
/*     */     }
/* 605 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 607 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 609 */         this.varc1 = FValue.trim();
/*     */       }
/*     */       else
/* 612 */         this.varc1 = null;
/*     */     }
/* 614 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 616 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 618 */         this.varc2 = FValue.trim();
/*     */       }
/*     */       else
/* 621 */         this.varc2 = null;
/*     */     }
/* 623 */     if (FCode.equalsIgnoreCase("varc3"))
/*     */     {
/* 625 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 627 */         this.varc3 = FValue.trim();
/*     */       }
/*     */       else
/* 630 */         this.varc3 = null;
/*     */     }
/* 632 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 637 */     if (otherObject == null) return false;
/* 638 */     if (this == otherObject) return true;
/* 639 */     if (getClass() != otherObject.getClass()) return false;
/* 640 */     LNPUserRoleMapSchema other = (LNPUserRoleMapSchema)otherObject;
/* 641 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 642 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 643 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/* 644 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/* 645 */     if ((this.roleCode == null) && (other.getRoleCode() != null)) return false;
/* 646 */     if ((this.roleCode != null) && (!this.roleCode.equals(other.getRoleCode()))) return false;
/* 647 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 648 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 649 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 650 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 651 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 652 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 653 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 654 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 655 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 656 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 657 */     if (this.int1 != other.getInt1()) return false;
/* 658 */     if (this.int2 != other.getInt2()) return false;
/* 659 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/* 660 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/* 661 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/* 662 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/* 663 */     if ((this.varc3 == null) && (other.getVarc3() != null)) return false;
/* 664 */     return (this.varc3 == null) || (this.varc3.equals(other.getVarc3()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 671 */     return 13;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 677 */     if (strFieldName.equals("iD")) {
/* 678 */       return 0;
/*     */     }
/* 680 */     if (strFieldName.equals("userCode")) {
/* 681 */       return 1;
/*     */     }
/* 683 */     if (strFieldName.equals("roleCode")) {
/* 684 */       return 2;
/*     */     }
/* 686 */     if (strFieldName.equals("operator")) {
/* 687 */       return 3;
/*     */     }
/* 689 */     if (strFieldName.equals("makeDate")) {
/* 690 */       return 4;
/*     */     }
/* 692 */     if (strFieldName.equals("makeTime")) {
/* 693 */       return 5;
/*     */     }
/* 695 */     if (strFieldName.equals("modifyDate")) {
/* 696 */       return 6;
/*     */     }
/* 698 */     if (strFieldName.equals("modifyTime")) {
/* 699 */       return 7;
/*     */     }
/* 701 */     if (strFieldName.equals("int1")) {
/* 702 */       return 8;
/*     */     }
/* 704 */     if (strFieldName.equals("int2")) {
/* 705 */       return 9;
/*     */     }
/* 707 */     if (strFieldName.equals("varc1")) {
/* 708 */       return 10;
/*     */     }
/* 710 */     if (strFieldName.equals("varc2")) {
/* 711 */       return 11;
/*     */     }
/* 713 */     if (strFieldName.equals("varc3")) {
/* 714 */       return 12;
/*     */     }
/* 716 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 722 */     String strFieldName = "";
/* 723 */     switch (nFieldIndex) {
/*     */     case 0:
/* 725 */       strFieldName = "iD";
/* 726 */       break;
/*     */     case 1:
/* 728 */       strFieldName = "userCode";
/* 729 */       break;
/*     */     case 2:
/* 731 */       strFieldName = "roleCode";
/* 732 */       break;
/*     */     case 3:
/* 734 */       strFieldName = "operator";
/* 735 */       break;
/*     */     case 4:
/* 737 */       strFieldName = "makeDate";
/* 738 */       break;
/*     */     case 5:
/* 740 */       strFieldName = "makeTime";
/* 741 */       break;
/*     */     case 6:
/* 743 */       strFieldName = "modifyDate";
/* 744 */       break;
/*     */     case 7:
/* 746 */       strFieldName = "modifyTime";
/* 747 */       break;
/*     */     case 8:
/* 749 */       strFieldName = "int1";
/* 750 */       break;
/*     */     case 9:
/* 752 */       strFieldName = "int2";
/* 753 */       break;
/*     */     case 10:
/* 755 */       strFieldName = "varc1";
/* 756 */       break;
/*     */     case 11:
/* 758 */       strFieldName = "varc2";
/* 759 */       break;
/*     */     case 12:
/* 761 */       strFieldName = "varc3";
/* 762 */       break;
/*     */     default:
/* 764 */       strFieldName = "";
/*     */     }
/* 766 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 772 */     if (strFieldName.equals("iD")) {
/* 773 */       return 0;
/*     */     }
/* 775 */     if (strFieldName.equals("userCode")) {
/* 776 */       return 0;
/*     */     }
/* 778 */     if (strFieldName.equals("roleCode")) {
/* 779 */       return 0;
/*     */     }
/* 781 */     if (strFieldName.equals("operator")) {
/* 782 */       return 0;
/*     */     }
/* 784 */     if (strFieldName.equals("makeDate")) {
/* 785 */       return 1;
/*     */     }
/* 787 */     if (strFieldName.equals("makeTime")) {
/* 788 */       return 0;
/*     */     }
/* 790 */     if (strFieldName.equals("modifyDate")) {
/* 791 */       return 1;
/*     */     }
/* 793 */     if (strFieldName.equals("modifyTime")) {
/* 794 */       return 0;
/*     */     }
/* 796 */     if (strFieldName.equals("int1")) {
/* 797 */       return 3;
/*     */     }
/* 799 */     if (strFieldName.equals("int2")) {
/* 800 */       return 3;
/*     */     }
/* 802 */     if (strFieldName.equals("varc1")) {
/* 803 */       return 0;
/*     */     }
/* 805 */     if (strFieldName.equals("varc2")) {
/* 806 */       return 0;
/*     */     }
/* 808 */     if (strFieldName.equals("varc3")) {
/* 809 */       return 0;
/*     */     }
/* 811 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 817 */     int nFieldType = -1;
/* 818 */     switch (nFieldIndex) {
/*     */     case 0:
/* 820 */       nFieldType = 0;
/* 821 */       break;
/*     */     case 1:
/* 823 */       nFieldType = 0;
/* 824 */       break;
/*     */     case 2:
/* 826 */       nFieldType = 0;
/* 827 */       break;
/*     */     case 3:
/* 829 */       nFieldType = 0;
/* 830 */       break;
/*     */     case 4:
/* 832 */       nFieldType = 1;
/* 833 */       break;
/*     */     case 5:
/* 835 */       nFieldType = 0;
/* 836 */       break;
/*     */     case 6:
/* 838 */       nFieldType = 1;
/* 839 */       break;
/*     */     case 7:
/* 841 */       nFieldType = 0;
/* 842 */       break;
/*     */     case 8:
/* 844 */       nFieldType = 3;
/* 845 */       break;
/*     */     case 9:
/* 847 */       nFieldType = 3;
/* 848 */       break;
/*     */     case 10:
/* 850 */       nFieldType = 0;
/* 851 */       break;
/*     */     case 11:
/* 853 */       nFieldType = 0;
/* 854 */       break;
/*     */     case 12:
/* 856 */       nFieldType = 0;
/* 857 */       break;
/*     */     default:
/* 859 */       nFieldType = -1;
/*     */     }
/* 861 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPUserRoleMapSchema
 * JD-Core Version:    0.6.0
 */