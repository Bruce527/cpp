/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRoleInfoDB;
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
/*     */ public class LNPRoleInfoSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String roleCode;
/*     */   private String name;
/*     */   private String describe;
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
/*     */   public static final int FIELDNUM = 14;
/*     */   private static String[] PK;
/*  55 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRoleInfoSchema()
/*     */   {
/*  62 */     this.mErrors = new CErrors();
/*     */ 
/*  64 */     String[] pk = new String[1];
/*  65 */     pk[0] = "ID";
/*     */ 
/*  67 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  74 */     LNPRoleInfoSchema cloned = (LNPRoleInfoSchema)super.clone();
/*  75 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  76 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  77 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  83 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  88 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  92 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getRoleCode() {
/*  96 */     return this.roleCode;
/*     */   }
/*     */ 
/*     */   public void setRoleCode(String aRoleCode) {
/* 100 */     this.roleCode = aRoleCode;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 104 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String aName) {
/* 108 */     this.name = aName;
/*     */   }
/*     */ 
/*     */   public String getDescribe() {
/* 112 */     return this.describe;
/*     */   }
/*     */ 
/*     */   public void setDescribe(String aDescribe) {
/* 116 */     this.describe = aDescribe;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 120 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 124 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 128 */     if (this.makeDate != null) {
/* 129 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 135 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 139 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 141 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 144 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 149 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 153 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 157 */     if (this.modifyDate != null) {
/* 158 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 164 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 168 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 170 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 173 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 178 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 182 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public int getInt1() {
/* 186 */     return this.int1;
/*     */   }
/*     */ 
/*     */   public void setInt1(int aInt1) {
/* 190 */     this.int1 = aInt1;
/*     */   }
/*     */ 
/*     */   public void setInt1(String aInt1) {
/* 194 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*     */     {
/* 196 */       Integer tInteger = new Integer(aInt1);
/* 197 */       int i = tInteger.intValue();
/* 198 */       this.int1 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getInt2()
/*     */   {
/* 204 */     return this.int2;
/*     */   }
/*     */ 
/*     */   public void setInt2(int aInt2) {
/* 208 */     this.int2 = aInt2;
/*     */   }
/*     */ 
/*     */   public void setInt2(String aInt2) {
/* 212 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*     */     {
/* 214 */       Integer tInteger = new Integer(aInt2);
/* 215 */       int i = tInteger.intValue();
/* 216 */       this.int2 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getVarc1()
/*     */   {
/* 222 */     return this.varc1;
/*     */   }
/*     */ 
/*     */   public void setVarc1(String aVarc1) {
/* 226 */     this.varc1 = aVarc1;
/*     */   }
/*     */ 
/*     */   public String getVarc2() {
/* 230 */     return this.varc2;
/*     */   }
/*     */ 
/*     */   public void setVarc2(String aVarc2) {
/* 234 */     this.varc2 = aVarc2;
/*     */   }
/*     */ 
/*     */   public String getVarc3() {
/* 238 */     return this.varc3;
/*     */   }
/*     */ 
/*     */   public void setVarc3(String aVarc3) {
/* 242 */     this.varc3 = aVarc3;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRoleInfoSchema aLNPRoleInfoSchema)
/*     */   {
/* 248 */     this.iD = aLNPRoleInfoSchema.getID();
/* 249 */     this.roleCode = aLNPRoleInfoSchema.getRoleCode();
/* 250 */     this.name = aLNPRoleInfoSchema.getName();
/* 251 */     this.describe = aLNPRoleInfoSchema.getDescribe();
/* 252 */     this.operator = aLNPRoleInfoSchema.getOperator();
/* 253 */     this.makeDate = this.fDate.getDate(aLNPRoleInfoSchema.getMakeDate());
/* 254 */     this.makeTime = aLNPRoleInfoSchema.getMakeTime();
/* 255 */     this.modifyDate = this.fDate.getDate(aLNPRoleInfoSchema.getModifyDate());
/* 256 */     this.modifyTime = aLNPRoleInfoSchema.getModifyTime();
/* 257 */     this.int1 = aLNPRoleInfoSchema.getInt1();
/* 258 */     this.int2 = aLNPRoleInfoSchema.getInt2();
/* 259 */     this.varc1 = aLNPRoleInfoSchema.getVarc1();
/* 260 */     this.varc2 = aLNPRoleInfoSchema.getVarc2();
/* 261 */     this.varc3 = aLNPRoleInfoSchema.getVarc3();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 270 */       if (rs.getString("ID") == null)
/* 271 */         this.iD = null;
/*     */       else {
/* 273 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 275 */       if (rs.getString("RoleCode") == null)
/* 276 */         this.roleCode = null;
/*     */       else {
/* 278 */         this.roleCode = rs.getString("RoleCode").trim();
/*     */       }
/* 280 */       if (rs.getString("Name") == null)
/* 281 */         this.name = null;
/*     */       else {
/* 283 */         this.name = rs.getString("Name").trim();
/*     */       }
/* 285 */       if (rs.getString("Describe") == null)
/* 286 */         this.describe = null;
/*     */       else {
/* 288 */         this.describe = rs.getString("Describe").trim();
/*     */       }
/* 290 */       if (rs.getString("Operator") == null)
/* 291 */         this.operator = null;
/*     */       else {
/* 293 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 295 */       this.makeDate = rs.getDate("MakeDate");
/* 296 */       if (rs.getString("MakeTime") == null)
/* 297 */         this.makeTime = null;
/*     */       else {
/* 299 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 301 */       this.modifyDate = rs.getDate("ModifyDate");
/* 302 */       if (rs.getString("ModifyTime") == null)
/* 303 */         this.modifyTime = null;
/*     */       else {
/* 305 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 307 */       this.int1 = rs.getInt("Int1");
/* 308 */       this.int2 = rs.getInt("Int2");
/* 309 */       if (rs.getString("Varc1") == null)
/* 310 */         this.varc1 = null;
/*     */       else {
/* 312 */         this.varc1 = rs.getString("Varc1").trim();
/*     */       }
/* 314 */       if (rs.getString("Varc2") == null)
/* 315 */         this.varc2 = null;
/*     */       else {
/* 317 */         this.varc2 = rs.getString("Varc2").trim();
/*     */       }
/* 319 */       if (rs.getString("Varc3") == null)
/* 320 */         this.varc3 = null;
/*     */       else {
/* 322 */         this.varc3 = rs.getString("Varc3").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 327 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRoleInfo\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 329 */       CError tError = new CError();
/* 330 */       tError.moduleName = "LNPRoleInfoSchema";
/* 331 */       tError.functionName = "setSchema";
/* 332 */       tError.errorMessage = sqle.toString();
/* 333 */       this.mErrors.addOneError(tError);
/* 334 */       return false;
/*     */     }
/* 336 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRoleInfoSchema getSchema()
/*     */   {
/* 341 */     LNPRoleInfoSchema aLNPRoleInfoSchema = new LNPRoleInfoSchema();
/* 342 */     aLNPRoleInfoSchema.setSchema(this);
/* 343 */     return aLNPRoleInfoSchema;
/*     */   }
/*     */ 
/*     */   public LNPRoleInfoDB getDB()
/*     */   {
/* 348 */     LNPRoleInfoDB aDBOper = new LNPRoleInfoDB();
/* 349 */     aDBOper.setSchema(this);
/* 350 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 357 */     StringBuffer strReturn = new StringBuffer(256);
/* 358 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 359 */     strReturn.append(StrTool.cTrim(this.roleCode)); strReturn.append("|");
/* 360 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/* 361 */     strReturn.append(StrTool.cTrim(this.describe)); strReturn.append("|");
/* 362 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 363 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 364 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 365 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 366 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 367 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/* 368 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/* 369 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/* 370 */     strReturn.append(StrTool.cTrim(this.varc2)); strReturn.append("|");
/* 371 */     strReturn.append(StrTool.cTrim(this.varc3));
/* 372 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 380 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 381 */       this.roleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 382 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 383 */       this.describe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 384 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 385 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 386 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 387 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 388 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 389 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/* 390 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/* 391 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 392 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 393 */       this.varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 398 */       CError tError = new CError();
/* 399 */       tError.moduleName = "LNPRoleInfoSchema";
/* 400 */       tError.functionName = "decode";
/* 401 */       tError.errorMessage = ex.toString();
/* 402 */       this.mErrors.addOneError(tError);
/*     */ 
/* 404 */       return false;
/*     */     }
/* 406 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 412 */     String strReturn = "";
/* 413 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 415 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 417 */     if (FCode.equalsIgnoreCase("roleCode"))
/*     */     {
/* 419 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleCode));
/*     */     }
/* 421 */     if (FCode.equalsIgnoreCase("name"))
/*     */     {
/* 423 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*     */     }
/* 425 */     if (FCode.equalsIgnoreCase("describe"))
/*     */     {
/* 427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.describe));
/*     */     }
/* 429 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 431 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 435 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 437 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 439 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 441 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 443 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 445 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 447 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 449 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 451 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*     */     }
/* 453 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 455 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*     */     }
/* 457 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 459 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*     */     }
/* 461 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 463 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*     */     }
/* 465 */     if (FCode.equalsIgnoreCase("varc3"))
/*     */     {
/* 467 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc3));
/*     */     }
/* 469 */     if (strReturn.equals(""))
/*     */     {
/* 471 */       strReturn = "null";
/*     */     }
/*     */ 
/* 474 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 481 */     String strFieldValue = "";
/* 482 */     switch (nFieldIndex) {
/*     */     case 0:
/* 484 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 485 */       break;
/*     */     case 1:
/* 487 */       strFieldValue = StrTool.GBKToUnicode(this.roleCode);
/* 488 */       break;
/*     */     case 2:
/* 490 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 491 */       break;
/*     */     case 3:
/* 493 */       strFieldValue = StrTool.GBKToUnicode(this.describe);
/* 494 */       break;
/*     */     case 4:
/* 496 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 497 */       break;
/*     */     case 5:
/* 499 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 500 */       break;
/*     */     case 6:
/* 502 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 503 */       break;
/*     */     case 7:
/* 505 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 506 */       break;
/*     */     case 8:
/* 508 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 509 */       break;
/*     */     case 9:
/* 511 */       strFieldValue = String.valueOf(this.int1);
/* 512 */       break;
/*     */     case 10:
/* 514 */       strFieldValue = String.valueOf(this.int2);
/* 515 */       break;
/*     */     case 11:
/* 517 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/* 518 */       break;
/*     */     case 12:
/* 520 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/* 521 */       break;
/*     */     case 13:
/* 523 */       strFieldValue = StrTool.GBKToUnicode(this.varc3);
/* 524 */       break;
/*     */     default:
/* 526 */       strFieldValue = "";
/*     */     }
/* 528 */     if (strFieldValue.equals("")) {
/* 529 */       strFieldValue = "null";
/*     */     }
/* 531 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 537 */     if (StrTool.cTrim(FCode).equals("")) {
/* 538 */       return false;
/*     */     }
/* 540 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 542 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 544 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 547 */         this.iD = null;
/*     */     }
/* 549 */     if (FCode.equalsIgnoreCase("roleCode"))
/*     */     {
/* 551 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 553 */         this.roleCode = FValue.trim();
/*     */       }
/*     */       else
/* 556 */         this.roleCode = null;
/*     */     }
/* 558 */     if (FCode.equalsIgnoreCase("name"))
/*     */     {
/* 560 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 562 */         this.name = FValue.trim();
/*     */       }
/*     */       else
/* 565 */         this.name = null;
/*     */     }
/* 567 */     if (FCode.equalsIgnoreCase("describe"))
/*     */     {
/* 569 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 571 */         this.describe = FValue.trim();
/*     */       }
/*     */       else
/* 574 */         this.describe = null;
/*     */     }
/* 576 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 578 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 580 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 583 */         this.operator = null;
/*     */     }
/* 585 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 587 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 589 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 592 */         this.makeDate = null;
/*     */     }
/* 594 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 596 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 598 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 601 */         this.makeTime = null;
/*     */     }
/* 603 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 605 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 607 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 610 */         this.modifyDate = null;
/*     */     }
/* 612 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 614 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 616 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 619 */         this.modifyTime = null;
/*     */     }
/* 621 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 623 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 625 */         Integer tInteger = new Integer(FValue);
/* 626 */         int i = tInteger.intValue();
/* 627 */         this.int1 = i;
/*     */       }
/*     */     }
/* 630 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 632 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 634 */         Integer tInteger = new Integer(FValue);
/* 635 */         int i = tInteger.intValue();
/* 636 */         this.int2 = i;
/*     */       }
/*     */     }
/* 639 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 641 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 643 */         this.varc1 = FValue.trim();
/*     */       }
/*     */       else
/* 646 */         this.varc1 = null;
/*     */     }
/* 648 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 650 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 652 */         this.varc2 = FValue.trim();
/*     */       }
/*     */       else
/* 655 */         this.varc2 = null;
/*     */     }
/* 657 */     if (FCode.equalsIgnoreCase("varc3"))
/*     */     {
/* 659 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 661 */         this.varc3 = FValue.trim();
/*     */       }
/*     */       else
/* 664 */         this.varc3 = null;
/*     */     }
/* 666 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 671 */     if (otherObject == null) return false;
/* 672 */     if (this == otherObject) return true;
/* 673 */     if (getClass() != otherObject.getClass()) return false;
/* 674 */     LNPRoleInfoSchema other = (LNPRoleInfoSchema)otherObject;
/* 675 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 676 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 677 */     if ((this.roleCode == null) && (other.getRoleCode() != null)) return false;
/* 678 */     if ((this.roleCode != null) && (!this.roleCode.equals(other.getRoleCode()))) return false;
/* 679 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 680 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 681 */     if ((this.describe == null) && (other.getDescribe() != null)) return false;
/* 682 */     if ((this.describe != null) && (!this.describe.equals(other.getDescribe()))) return false;
/* 683 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 684 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 685 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 686 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 687 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 688 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 689 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 690 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 691 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 692 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 693 */     if (this.int1 != other.getInt1()) return false;
/* 694 */     if (this.int2 != other.getInt2()) return false;
/* 695 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/* 696 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/* 697 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/* 698 */     if ((this.varc2 != null) && (!this.varc2.equals(other.getVarc2()))) return false;
/* 699 */     if ((this.varc3 == null) && (other.getVarc3() != null)) return false;
/* 700 */     return (this.varc3 == null) || (this.varc3.equals(other.getVarc3()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 707 */     return 14;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 713 */     if (strFieldName.equals("iD")) {
/* 714 */       return 0;
/*     */     }
/* 716 */     if (strFieldName.equals("roleCode")) {
/* 717 */       return 1;
/*     */     }
/* 719 */     if (strFieldName.equals("name")) {
/* 720 */       return 2;
/*     */     }
/* 722 */     if (strFieldName.equals("describe")) {
/* 723 */       return 3;
/*     */     }
/* 725 */     if (strFieldName.equals("operator")) {
/* 726 */       return 4;
/*     */     }
/* 728 */     if (strFieldName.equals("makeDate")) {
/* 729 */       return 5;
/*     */     }
/* 731 */     if (strFieldName.equals("makeTime")) {
/* 732 */       return 6;
/*     */     }
/* 734 */     if (strFieldName.equals("modifyDate")) {
/* 735 */       return 7;
/*     */     }
/* 737 */     if (strFieldName.equals("modifyTime")) {
/* 738 */       return 8;
/*     */     }
/* 740 */     if (strFieldName.equals("int1")) {
/* 741 */       return 9;
/*     */     }
/* 743 */     if (strFieldName.equals("int2")) {
/* 744 */       return 10;
/*     */     }
/* 746 */     if (strFieldName.equals("varc1")) {
/* 747 */       return 11;
/*     */     }
/* 749 */     if (strFieldName.equals("varc2")) {
/* 750 */       return 12;
/*     */     }
/* 752 */     if (strFieldName.equals("varc3")) {
/* 753 */       return 13;
/*     */     }
/* 755 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 761 */     String strFieldName = "";
/* 762 */     switch (nFieldIndex) {
/*     */     case 0:
/* 764 */       strFieldName = "iD";
/* 765 */       break;
/*     */     case 1:
/* 767 */       strFieldName = "roleCode";
/* 768 */       break;
/*     */     case 2:
/* 770 */       strFieldName = "name";
/* 771 */       break;
/*     */     case 3:
/* 773 */       strFieldName = "describe";
/* 774 */       break;
/*     */     case 4:
/* 776 */       strFieldName = "operator";
/* 777 */       break;
/*     */     case 5:
/* 779 */       strFieldName = "makeDate";
/* 780 */       break;
/*     */     case 6:
/* 782 */       strFieldName = "makeTime";
/* 783 */       break;
/*     */     case 7:
/* 785 */       strFieldName = "modifyDate";
/* 786 */       break;
/*     */     case 8:
/* 788 */       strFieldName = "modifyTime";
/* 789 */       break;
/*     */     case 9:
/* 791 */       strFieldName = "int1";
/* 792 */       break;
/*     */     case 10:
/* 794 */       strFieldName = "int2";
/* 795 */       break;
/*     */     case 11:
/* 797 */       strFieldName = "varc1";
/* 798 */       break;
/*     */     case 12:
/* 800 */       strFieldName = "varc2";
/* 801 */       break;
/*     */     case 13:
/* 803 */       strFieldName = "varc3";
/* 804 */       break;
/*     */     default:
/* 806 */       strFieldName = "";
/*     */     }
/* 808 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 814 */     if (strFieldName.equals("iD")) {
/* 815 */       return 0;
/*     */     }
/* 817 */     if (strFieldName.equals("roleCode")) {
/* 818 */       return 0;
/*     */     }
/* 820 */     if (strFieldName.equals("name")) {
/* 821 */       return 0;
/*     */     }
/* 823 */     if (strFieldName.equals("describe")) {
/* 824 */       return 0;
/*     */     }
/* 826 */     if (strFieldName.equals("operator")) {
/* 827 */       return 0;
/*     */     }
/* 829 */     if (strFieldName.equals("makeDate")) {
/* 830 */       return 1;
/*     */     }
/* 832 */     if (strFieldName.equals("makeTime")) {
/* 833 */       return 0;
/*     */     }
/* 835 */     if (strFieldName.equals("modifyDate")) {
/* 836 */       return 1;
/*     */     }
/* 838 */     if (strFieldName.equals("modifyTime")) {
/* 839 */       return 0;
/*     */     }
/* 841 */     if (strFieldName.equals("int1")) {
/* 842 */       return 3;
/*     */     }
/* 844 */     if (strFieldName.equals("int2")) {
/* 845 */       return 3;
/*     */     }
/* 847 */     if (strFieldName.equals("varc1")) {
/* 848 */       return 0;
/*     */     }
/* 850 */     if (strFieldName.equals("varc2")) {
/* 851 */       return 0;
/*     */     }
/* 853 */     if (strFieldName.equals("varc3")) {
/* 854 */       return 0;
/*     */     }
/* 856 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 862 */     int nFieldType = -1;
/* 863 */     switch (nFieldIndex) {
/*     */     case 0:
/* 865 */       nFieldType = 0;
/* 866 */       break;
/*     */     case 1:
/* 868 */       nFieldType = 0;
/* 869 */       break;
/*     */     case 2:
/* 871 */       nFieldType = 0;
/* 872 */       break;
/*     */     case 3:
/* 874 */       nFieldType = 0;
/* 875 */       break;
/*     */     case 4:
/* 877 */       nFieldType = 0;
/* 878 */       break;
/*     */     case 5:
/* 880 */       nFieldType = 1;
/* 881 */       break;
/*     */     case 6:
/* 883 */       nFieldType = 0;
/* 884 */       break;
/*     */     case 7:
/* 886 */       nFieldType = 1;
/* 887 */       break;
/*     */     case 8:
/* 889 */       nFieldType = 0;
/* 890 */       break;
/*     */     case 9:
/* 892 */       nFieldType = 3;
/* 893 */       break;
/*     */     case 10:
/* 895 */       nFieldType = 3;
/* 896 */       break;
/*     */     case 11:
/* 898 */       nFieldType = 0;
/* 899 */       break;
/*     */     case 12:
/* 901 */       nFieldType = 0;
/* 902 */       break;
/*     */     case 13:
/* 904 */       nFieldType = 0;
/* 905 */       break;
/*     */     default:
/* 907 */       nFieldType = -1;
/*     */     }
/* 909 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRoleInfoSchema
 * JD-Core Version:    0.6.0
 */