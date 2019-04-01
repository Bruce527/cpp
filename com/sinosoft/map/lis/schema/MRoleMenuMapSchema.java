/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MRoleMenuMapDB;
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
/*     */ public class MRoleMenuMapSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String roleID;
/*     */   private String menuID;
/*     */   private String type;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   private int int1;
/*     */   private int int2;
/*     */   private String varc1;
/*     */   private String varc2;
/*     */   public static final int FIELDNUM = 13;
/*     */   private static String[] PK;
/*  50 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MRoleMenuMapSchema()
/*     */   {
/*  57 */     this.mErrors = new CErrors();
/*     */ 
/*  59 */     String[] pk = new String[1];
/*  60 */     pk[0] = "ID";
/*     */ 
/*  62 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  69 */     MRoleMenuMapSchema cloned = (MRoleMenuMapSchema)super.clone();
/*  70 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  71 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  72 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  78 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  83 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  87 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getRoleID() {
/*  91 */     return this.roleID;
/*     */   }
/*     */ 
/*     */   public void setRoleID(String aRoleID) {
/*  95 */     this.roleID = aRoleID;
/*     */   }
/*     */ 
/*     */   public String getMenuID() {
/*  99 */     return this.menuID;
/*     */   }
/*     */ 
/*     */   public void setMenuID(String aMenuID) {
/* 103 */     this.menuID = aMenuID;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 107 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String aType) {
/* 111 */     this.type = aType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 115 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 119 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 123 */     if (this.makeDate != null) {
/* 124 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 130 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 134 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 136 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 139 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 144 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 148 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 152 */     if (this.modifyDate != null) {
/* 153 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 155 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 159 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 163 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 165 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 168 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 173 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 177 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public int getInt1() {
/* 181 */     return this.int1;
/*     */   }
/*     */ 
/*     */   public void setInt1(int aInt1) {
/* 185 */     this.int1 = aInt1;
/*     */   }
/*     */ 
/*     */   public void setInt1(String aInt1) {
/* 189 */     if ((aInt1 != null) && (!aInt1.equals("")))
/*     */     {
/* 191 */       Integer tInteger = new Integer(aInt1);
/* 192 */       int i = tInteger.intValue();
/* 193 */       this.int1 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getInt2()
/*     */   {
/* 199 */     return this.int2;
/*     */   }
/*     */ 
/*     */   public void setInt2(int aInt2) {
/* 203 */     this.int2 = aInt2;
/*     */   }
/*     */ 
/*     */   public void setInt2(String aInt2) {
/* 207 */     if ((aInt2 != null) && (!aInt2.equals("")))
/*     */     {
/* 209 */       Integer tInteger = new Integer(aInt2);
/* 210 */       int i = tInteger.intValue();
/* 211 */       this.int2 = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getVarc1()
/*     */   {
/* 217 */     return this.varc1;
/*     */   }
/*     */ 
/*     */   public void setVarc1(String aVarc1) {
/* 221 */     this.varc1 = aVarc1;
/*     */   }
/*     */ 
/*     */   public String getVarc2() {
/* 225 */     return this.varc2;
/*     */   }
/*     */ 
/*     */   public void setVarc2(String aVarc2) {
/* 229 */     this.varc2 = aVarc2;
/*     */   }
/*     */ 
/*     */   public void setSchema(MRoleMenuMapSchema aMRoleMenuMapSchema)
/*     */   {
/* 235 */     this.iD = aMRoleMenuMapSchema.getID();
/* 236 */     this.roleID = aMRoleMenuMapSchema.getRoleID();
/* 237 */     this.menuID = aMRoleMenuMapSchema.getMenuID();
/* 238 */     this.type = aMRoleMenuMapSchema.getType();
/* 239 */     this.operator = aMRoleMenuMapSchema.getOperator();
/* 240 */     this.makeDate = this.fDate.getDate(aMRoleMenuMapSchema.getMakeDate());
/* 241 */     this.makeTime = aMRoleMenuMapSchema.getMakeTime();
/* 242 */     this.modifyDate = this.fDate.getDate(aMRoleMenuMapSchema.getModifyDate());
/* 243 */     this.modifyTime = aMRoleMenuMapSchema.getModifyTime();
/* 244 */     this.int1 = aMRoleMenuMapSchema.getInt1();
/* 245 */     this.int2 = aMRoleMenuMapSchema.getInt2();
/* 246 */     this.varc1 = aMRoleMenuMapSchema.getVarc1();
/* 247 */     this.varc2 = aMRoleMenuMapSchema.getVarc2();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 256 */       if (rs.getString("ID") == null)
/* 257 */         this.iD = null;
/*     */       else {
/* 259 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 261 */       if (rs.getString("RoleID") == null)
/* 262 */         this.roleID = null;
/*     */       else {
/* 264 */         this.roleID = rs.getString("RoleID").trim();
/*     */       }
/* 266 */       if (rs.getString("MenuID") == null)
/* 267 */         this.menuID = null;
/*     */       else {
/* 269 */         this.menuID = rs.getString("MenuID").trim();
/*     */       }
/* 271 */       if (rs.getString("Type") == null)
/* 272 */         this.type = null;
/*     */       else {
/* 274 */         this.type = rs.getString("Type").trim();
/*     */       }
/* 276 */       if (rs.getString("Operator") == null)
/* 277 */         this.operator = null;
/*     */       else {
/* 279 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 281 */       this.makeDate = rs.getDate("MakeDate");
/* 282 */       if (rs.getString("MakeTime") == null)
/* 283 */         this.makeTime = null;
/*     */       else {
/* 285 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 287 */       this.modifyDate = rs.getDate("ModifyDate");
/* 288 */       if (rs.getString("ModifyTime") == null)
/* 289 */         this.modifyTime = null;
/*     */       else {
/* 291 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 293 */       this.int1 = rs.getInt("Int1");
/* 294 */       this.int2 = rs.getInt("Int2");
/* 295 */       if (rs.getString("Varc1") == null)
/* 296 */         this.varc1 = null;
/*     */       else {
/* 298 */         this.varc1 = rs.getString("Varc1").trim();
/*     */       }
/* 300 */       if (rs.getString("Varc2") == null)
/* 301 */         this.varc2 = null;
/*     */       else {
/* 303 */         this.varc2 = rs.getString("Varc2").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 308 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MRoleMenuMap\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 310 */       CError tError = new CError();
/* 311 */       tError.moduleName = "MRoleMenuMapSchema";
/* 312 */       tError.functionName = "setSchema";
/* 313 */       tError.errorMessage = sqle.toString();
/* 314 */       this.mErrors.addOneError(tError);
/* 315 */       return false;
/*     */     }
/* 317 */     return true;
/*     */   }
/*     */ 
/*     */   public MRoleMenuMapSchema getSchema()
/*     */   {
/* 322 */     MRoleMenuMapSchema aMRoleMenuMapSchema = new MRoleMenuMapSchema();
/* 323 */     aMRoleMenuMapSchema.setSchema(this);
/* 324 */     return aMRoleMenuMapSchema;
/*     */   }
/*     */ 
/*     */   public MRoleMenuMapDB getDB()
/*     */   {
/* 329 */     MRoleMenuMapDB aDBOper = new MRoleMenuMapDB();
/* 330 */     aDBOper.setSchema(this);
/* 331 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 338 */     StringBuffer strReturn = new StringBuffer(256);
/* 339 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 340 */     strReturn.append(StrTool.cTrim(this.roleID)); strReturn.append("|");
/* 341 */     strReturn.append(StrTool.cTrim(this.menuID)); strReturn.append("|");
/* 342 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/* 343 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 344 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 345 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 346 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 347 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 348 */     strReturn.append(ChgData.chgData(this.int1)); strReturn.append("|");
/* 349 */     strReturn.append(ChgData.chgData(this.int2)); strReturn.append("|");
/* 350 */     strReturn.append(StrTool.cTrim(this.varc1)); strReturn.append("|");
/* 351 */     strReturn.append(StrTool.cTrim(this.varc2));
/* 352 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 360 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 361 */       this.roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 362 */       this.menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 363 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 364 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 365 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/* 366 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 367 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 368 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 369 */       this.int1 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/* 370 */       this.int2 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/* 371 */       this.varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 372 */       this.varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 377 */       CError tError = new CError();
/* 378 */       tError.moduleName = "MRoleMenuMapSchema";
/* 379 */       tError.functionName = "decode";
/* 380 */       tError.errorMessage = ex.toString();
/* 381 */       this.mErrors.addOneError(tError);
/*     */ 
/* 383 */       return false;
/*     */     }
/* 385 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 391 */     String strReturn = "";
/* 392 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 394 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 396 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 398 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleID));
/*     */     }
/* 400 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 402 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.menuID));
/*     */     }
/* 404 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 406 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*     */     }
/* 408 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 410 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 412 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 414 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 416 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 418 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 420 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 422 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 424 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 426 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 428 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 430 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int1));
/*     */     }
/* 432 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 434 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.int2));
/*     */     }
/* 436 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 438 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc1));
/*     */     }
/* 440 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 442 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varc2));
/*     */     }
/* 444 */     if (strReturn.equals(""))
/*     */     {
/* 446 */       strReturn = "null";
/*     */     }
/*     */ 
/* 449 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 456 */     String strFieldValue = "";
/* 457 */     switch (nFieldIndex) {
/*     */     case 0:
/* 459 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 460 */       break;
/*     */     case 1:
/* 462 */       strFieldValue = StrTool.GBKToUnicode(this.roleID);
/* 463 */       break;
/*     */     case 2:
/* 465 */       strFieldValue = StrTool.GBKToUnicode(this.menuID);
/* 466 */       break;
/*     */     case 3:
/* 468 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 469 */       break;
/*     */     case 4:
/* 471 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 472 */       break;
/*     */     case 5:
/* 474 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 475 */       break;
/*     */     case 6:
/* 477 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 478 */       break;
/*     */     case 7:
/* 480 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 481 */       break;
/*     */     case 8:
/* 483 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 484 */       break;
/*     */     case 9:
/* 486 */       strFieldValue = String.valueOf(this.int1);
/* 487 */       break;
/*     */     case 10:
/* 489 */       strFieldValue = String.valueOf(this.int2);
/* 490 */       break;
/*     */     case 11:
/* 492 */       strFieldValue = StrTool.GBKToUnicode(this.varc1);
/* 493 */       break;
/*     */     case 12:
/* 495 */       strFieldValue = StrTool.GBKToUnicode(this.varc2);
/* 496 */       break;
/*     */     default:
/* 498 */       strFieldValue = "";
/*     */     }
/* 500 */     if (strFieldValue.equals("")) {
/* 501 */       strFieldValue = "null";
/*     */     }
/* 503 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 509 */     if (StrTool.cTrim(FCode).equals("")) {
/* 510 */       return false;
/*     */     }
/* 512 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 514 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 516 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 519 */         this.iD = null;
/*     */     }
/* 521 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 523 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 525 */         this.roleID = FValue.trim();
/*     */       }
/*     */       else
/* 528 */         this.roleID = null;
/*     */     }
/* 530 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 532 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 534 */         this.menuID = FValue.trim();
/*     */       }
/*     */       else
/* 537 */         this.menuID = null;
/*     */     }
/* 539 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 541 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 543 */         this.type = FValue.trim();
/*     */       }
/*     */       else
/* 546 */         this.type = null;
/*     */     }
/* 548 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 550 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 552 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 555 */         this.operator = null;
/*     */     }
/* 557 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 559 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 561 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 564 */         this.makeDate = null;
/*     */     }
/* 566 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 568 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 570 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 573 */         this.makeTime = null;
/*     */     }
/* 575 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 577 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 579 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 582 */         this.modifyDate = null;
/*     */     }
/* 584 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 586 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 588 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 591 */         this.modifyTime = null;
/*     */     }
/* 593 */     if (FCode.equalsIgnoreCase("int1"))
/*     */     {
/* 595 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 597 */         Integer tInteger = new Integer(FValue);
/* 598 */         int i = tInteger.intValue();
/* 599 */         this.int1 = i;
/*     */       }
/*     */     }
/* 602 */     if (FCode.equalsIgnoreCase("int2"))
/*     */     {
/* 604 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 606 */         Integer tInteger = new Integer(FValue);
/* 607 */         int i = tInteger.intValue();
/* 608 */         this.int2 = i;
/*     */       }
/*     */     }
/* 611 */     if (FCode.equalsIgnoreCase("varc1"))
/*     */     {
/* 613 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 615 */         this.varc1 = FValue.trim();
/*     */       }
/*     */       else
/* 618 */         this.varc1 = null;
/*     */     }
/* 620 */     if (FCode.equalsIgnoreCase("varc2"))
/*     */     {
/* 622 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 624 */         this.varc2 = FValue.trim();
/*     */       }
/*     */       else
/* 627 */         this.varc2 = null;
/*     */     }
/* 629 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 634 */     if (otherObject == null) return false;
/* 635 */     if (this == otherObject) return true;
/* 636 */     if (getClass() != otherObject.getClass()) return false;
/* 637 */     MRoleMenuMapSchema other = (MRoleMenuMapSchema)otherObject;
/* 638 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 639 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 640 */     if ((this.roleID == null) && (other.getRoleID() != null)) return false;
/* 641 */     if ((this.roleID != null) && (!this.roleID.equals(other.getRoleID()))) return false;
/* 642 */     if ((this.menuID == null) && (other.getMenuID() != null)) return false;
/* 643 */     if ((this.menuID != null) && (!this.menuID.equals(other.getMenuID()))) return false;
/* 644 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 645 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 646 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 647 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 648 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 649 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 650 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 651 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 652 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 653 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 654 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 655 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 656 */     if (this.int1 != other.getInt1()) return false;
/* 657 */     if (this.int2 != other.getInt2()) return false;
/* 658 */     if ((this.varc1 == null) && (other.getVarc1() != null)) return false;
/* 659 */     if ((this.varc1 != null) && (!this.varc1.equals(other.getVarc1()))) return false;
/* 660 */     if ((this.varc2 == null) && (other.getVarc2() != null)) return false;
/* 661 */     return (this.varc2 == null) || (this.varc2.equals(other.getVarc2()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 668 */     return 13;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 674 */     if (strFieldName.equals("iD")) {
/* 675 */       return 0;
/*     */     }
/* 677 */     if (strFieldName.equals("roleID")) {
/* 678 */       return 1;
/*     */     }
/* 680 */     if (strFieldName.equals("menuID")) {
/* 681 */       return 2;
/*     */     }
/* 683 */     if (strFieldName.equals("type")) {
/* 684 */       return 3;
/*     */     }
/* 686 */     if (strFieldName.equals("operator")) {
/* 687 */       return 4;
/*     */     }
/* 689 */     if (strFieldName.equals("makeDate")) {
/* 690 */       return 5;
/*     */     }
/* 692 */     if (strFieldName.equals("makeTime")) {
/* 693 */       return 6;
/*     */     }
/* 695 */     if (strFieldName.equals("modifyDate")) {
/* 696 */       return 7;
/*     */     }
/* 698 */     if (strFieldName.equals("modifyTime")) {
/* 699 */       return 8;
/*     */     }
/* 701 */     if (strFieldName.equals("int1")) {
/* 702 */       return 9;
/*     */     }
/* 704 */     if (strFieldName.equals("int2")) {
/* 705 */       return 10;
/*     */     }
/* 707 */     if (strFieldName.equals("varc1")) {
/* 708 */       return 11;
/*     */     }
/* 710 */     if (strFieldName.equals("varc2")) {
/* 711 */       return 12;
/*     */     }
/* 713 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 719 */     String strFieldName = "";
/* 720 */     switch (nFieldIndex) {
/*     */     case 0:
/* 722 */       strFieldName = "iD";
/* 723 */       break;
/*     */     case 1:
/* 725 */       strFieldName = "roleID";
/* 726 */       break;
/*     */     case 2:
/* 728 */       strFieldName = "menuID";
/* 729 */       break;
/*     */     case 3:
/* 731 */       strFieldName = "type";
/* 732 */       break;
/*     */     case 4:
/* 734 */       strFieldName = "operator";
/* 735 */       break;
/*     */     case 5:
/* 737 */       strFieldName = "makeDate";
/* 738 */       break;
/*     */     case 6:
/* 740 */       strFieldName = "makeTime";
/* 741 */       break;
/*     */     case 7:
/* 743 */       strFieldName = "modifyDate";
/* 744 */       break;
/*     */     case 8:
/* 746 */       strFieldName = "modifyTime";
/* 747 */       break;
/*     */     case 9:
/* 749 */       strFieldName = "int1";
/* 750 */       break;
/*     */     case 10:
/* 752 */       strFieldName = "int2";
/* 753 */       break;
/*     */     case 11:
/* 755 */       strFieldName = "varc1";
/* 756 */       break;
/*     */     case 12:
/* 758 */       strFieldName = "varc2";
/* 759 */       break;
/*     */     default:
/* 761 */       strFieldName = "";
/*     */     }
/* 763 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 769 */     if (strFieldName.equals("iD")) {
/* 770 */       return 0;
/*     */     }
/* 772 */     if (strFieldName.equals("roleID")) {
/* 773 */       return 0;
/*     */     }
/* 775 */     if (strFieldName.equals("menuID")) {
/* 776 */       return 0;
/*     */     }
/* 778 */     if (strFieldName.equals("type")) {
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
/* 808 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 814 */     int nFieldType = -1;
/* 815 */     switch (nFieldIndex) {
/*     */     case 0:
/* 817 */       nFieldType = 0;
/* 818 */       break;
/*     */     case 1:
/* 820 */       nFieldType = 0;
/* 821 */       break;
/*     */     case 2:
/* 823 */       nFieldType = 0;
/* 824 */       break;
/*     */     case 3:
/* 826 */       nFieldType = 0;
/* 827 */       break;
/*     */     case 4:
/* 829 */       nFieldType = 0;
/* 830 */       break;
/*     */     case 5:
/* 832 */       nFieldType = 1;
/* 833 */       break;
/*     */     case 6:
/* 835 */       nFieldType = 0;
/* 836 */       break;
/*     */     case 7:
/* 838 */       nFieldType = 1;
/* 839 */       break;
/*     */     case 8:
/* 841 */       nFieldType = 0;
/* 842 */       break;
/*     */     case 9:
/* 844 */       nFieldType = 3;
/* 845 */       break;
/*     */     case 10:
/* 847 */       nFieldType = 3;
/* 848 */       break;
/*     */     case 11:
/* 850 */       nFieldType = 0;
/* 851 */       break;
/*     */     case 12:
/* 853 */       nFieldType = 0;
/* 854 */       break;
/*     */     default:
/* 856 */       nFieldType = -1;
/*     */     }
/* 858 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MRoleMenuMapSchema
 * JD-Core Version:    0.6.0
 */