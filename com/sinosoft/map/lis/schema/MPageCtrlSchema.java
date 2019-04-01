/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MPageCtrlDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MPageCtrlSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String roleID;
/*     */   private String menuID;
/*     */   private String buttonType;
/*     */   private String buttonID;
/*     */   private String buttonName;
/*     */   private int buttonSwitch;
/*     */   private String controlFlag;
/*     */   private String buttonDescription;
/*     */   public static final int FIELDNUM = 9;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MPageCtrlSchema()
/*     */   {
/*  47 */     this.mErrors = new CErrors();
/*     */ 
/*  49 */     String[] pk = new String[1];
/*  50 */     pk[0] = "ID";
/*     */ 
/*  52 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  59 */     MPageCtrlSchema cloned = (MPageCtrlSchema)super.clone();
/*  60 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  61 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  67 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  72 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  76 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getRoleID() {
/*  80 */     return this.roleID;
/*     */   }
/*     */ 
/*     */   public void setRoleID(String aRoleID) {
/*  84 */     this.roleID = aRoleID;
/*     */   }
/*     */ 
/*     */   public String getMenuID() {
/*  88 */     return this.menuID;
/*     */   }
/*     */ 
/*     */   public void setMenuID(String aMenuID) {
/*  92 */     this.menuID = aMenuID;
/*     */   }
/*     */ 
/*     */   public String getButtonType() {
/*  96 */     return this.buttonType;
/*     */   }
/*     */ 
/*     */   public void setButtonType(String aButtonType) {
/* 100 */     this.buttonType = aButtonType;
/*     */   }
/*     */ 
/*     */   public String getButtonID() {
/* 104 */     return this.buttonID;
/*     */   }
/*     */ 
/*     */   public void setButtonID(String aButtonID) {
/* 108 */     this.buttonID = aButtonID;
/*     */   }
/*     */ 
/*     */   public String getButtonName() {
/* 112 */     return this.buttonName;
/*     */   }
/*     */ 
/*     */   public void setButtonName(String aButtonName) {
/* 116 */     this.buttonName = aButtonName;
/*     */   }
/*     */ 
/*     */   public int getButtonSwitch() {
/* 120 */     return this.buttonSwitch;
/*     */   }
/*     */ 
/*     */   public void setButtonSwitch(int aButtonSwitch) {
/* 124 */     this.buttonSwitch = aButtonSwitch;
/*     */   }
/*     */ 
/*     */   public void setButtonSwitch(String aButtonSwitch) {
/* 128 */     if ((aButtonSwitch != null) && (!aButtonSwitch.equals("")))
/*     */     {
/* 130 */       Integer tInteger = new Integer(aButtonSwitch);
/* 131 */       int i = tInteger.intValue();
/* 132 */       this.buttonSwitch = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getControlFlag()
/*     */   {
/* 138 */     return this.controlFlag;
/*     */   }
/*     */ 
/*     */   public void setControlFlag(String aControlFlag) {
/* 142 */     this.controlFlag = aControlFlag;
/*     */   }
/*     */ 
/*     */   public String getButtonDescription() {
/* 146 */     return this.buttonDescription;
/*     */   }
/*     */ 
/*     */   public void setButtonDescription(String aButtonDescription) {
/* 150 */     this.buttonDescription = aButtonDescription;
/*     */   }
/*     */ 
/*     */   public void setSchema(MPageCtrlSchema aMPageCtrlSchema)
/*     */   {
/* 156 */     this.iD = aMPageCtrlSchema.getID();
/* 157 */     this.roleID = aMPageCtrlSchema.getRoleID();
/* 158 */     this.menuID = aMPageCtrlSchema.getMenuID();
/* 159 */     this.buttonType = aMPageCtrlSchema.getButtonType();
/* 160 */     this.buttonID = aMPageCtrlSchema.getButtonID();
/* 161 */     this.buttonName = aMPageCtrlSchema.getButtonName();
/* 162 */     this.buttonSwitch = aMPageCtrlSchema.getButtonSwitch();
/* 163 */     this.controlFlag = aMPageCtrlSchema.getControlFlag();
/* 164 */     this.buttonDescription = aMPageCtrlSchema.getButtonDescription();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 173 */       if (rs.getString("ID") == null)
/* 174 */         this.iD = null;
/*     */       else {
/* 176 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 178 */       if (rs.getString("RoleID") == null)
/* 179 */         this.roleID = null;
/*     */       else {
/* 181 */         this.roleID = rs.getString("RoleID").trim();
/*     */       }
/* 183 */       if (rs.getString("MenuID") == null)
/* 184 */         this.menuID = null;
/*     */       else {
/* 186 */         this.menuID = rs.getString("MenuID").trim();
/*     */       }
/* 188 */       if (rs.getString("ButtonType") == null)
/* 189 */         this.buttonType = null;
/*     */       else {
/* 191 */         this.buttonType = rs.getString("ButtonType").trim();
/*     */       }
/* 193 */       if (rs.getString("ButtonID") == null)
/* 194 */         this.buttonID = null;
/*     */       else {
/* 196 */         this.buttonID = rs.getString("ButtonID").trim();
/*     */       }
/* 198 */       if (rs.getString("ButtonName") == null)
/* 199 */         this.buttonName = null;
/*     */       else {
/* 201 */         this.buttonName = rs.getString("ButtonName").trim();
/*     */       }
/* 203 */       this.buttonSwitch = rs.getInt("ButtonSwitch");
/* 204 */       if (rs.getString("ControlFlag") == null)
/* 205 */         this.controlFlag = null;
/*     */       else {
/* 207 */         this.controlFlag = rs.getString("ControlFlag").trim();
/*     */       }
/* 209 */       if (rs.getString("ButtonDescription") == null)
/* 210 */         this.buttonDescription = null;
/*     */       else {
/* 212 */         this.buttonDescription = rs.getString("ButtonDescription").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 217 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MPageCtrl\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 219 */       CError tError = new CError();
/* 220 */       tError.moduleName = "MPageCtrlSchema";
/* 221 */       tError.functionName = "setSchema";
/* 222 */       tError.errorMessage = sqle.toString();
/* 223 */       this.mErrors.addOneError(tError);
/* 224 */       return false;
/*     */     }
/* 226 */     return true;
/*     */   }
/*     */ 
/*     */   public MPageCtrlSchema getSchema()
/*     */   {
/* 231 */     MPageCtrlSchema aMPageCtrlSchema = new MPageCtrlSchema();
/* 232 */     aMPageCtrlSchema.setSchema(this);
/* 233 */     return aMPageCtrlSchema;
/*     */   }
/*     */ 
/*     */   public MPageCtrlDB getDB()
/*     */   {
/* 238 */     MPageCtrlDB aDBOper = new MPageCtrlDB();
/* 239 */     aDBOper.setSchema(this);
/* 240 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 247 */     StringBuffer strReturn = new StringBuffer(256);
/* 248 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 249 */     strReturn.append(StrTool.cTrim(this.roleID)); strReturn.append("|");
/* 250 */     strReturn.append(StrTool.cTrim(this.menuID)); strReturn.append("|");
/* 251 */     strReturn.append(StrTool.cTrim(this.buttonType)); strReturn.append("|");
/* 252 */     strReturn.append(StrTool.cTrim(this.buttonID)); strReturn.append("|");
/* 253 */     strReturn.append(StrTool.cTrim(this.buttonName)); strReturn.append("|");
/* 254 */     strReturn.append(ChgData.chgData(this.buttonSwitch)); strReturn.append("|");
/* 255 */     strReturn.append(StrTool.cTrim(this.controlFlag)); strReturn.append("|");
/* 256 */     strReturn.append(StrTool.cTrim(this.buttonDescription));
/* 257 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 265 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 266 */       this.roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 267 */       this.menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 268 */       this.buttonType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 269 */       this.buttonID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 270 */       this.buttonName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 271 */       this.buttonSwitch = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/* 272 */       this.controlFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 273 */       this.buttonDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 278 */       CError tError = new CError();
/* 279 */       tError.moduleName = "MPageCtrlSchema";
/* 280 */       tError.functionName = "decode";
/* 281 */       tError.errorMessage = ex.toString();
/* 282 */       this.mErrors.addOneError(tError);
/*     */ 
/* 284 */       return false;
/*     */     }
/* 286 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 292 */     String strReturn = "";
/* 293 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 295 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 297 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 299 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.roleID));
/*     */     }
/* 301 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 303 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.menuID));
/*     */     }
/* 305 */     if (FCode.equalsIgnoreCase("buttonType"))
/*     */     {
/* 307 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buttonType));
/*     */     }
/* 309 */     if (FCode.equalsIgnoreCase("buttonID"))
/*     */     {
/* 311 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buttonID));
/*     */     }
/* 313 */     if (FCode.equalsIgnoreCase("buttonName"))
/*     */     {
/* 315 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buttonName));
/*     */     }
/* 317 */     if (FCode.equalsIgnoreCase("buttonSwitch"))
/*     */     {
/* 319 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buttonSwitch));
/*     */     }
/* 321 */     if (FCode.equalsIgnoreCase("controlFlag"))
/*     */     {
/* 323 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.controlFlag));
/*     */     }
/* 325 */     if (FCode.equalsIgnoreCase("buttonDescription"))
/*     */     {
/* 327 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.buttonDescription));
/*     */     }
/* 329 */     if (strReturn.equals(""))
/*     */     {
/* 331 */       strReturn = "null";
/*     */     }
/*     */ 
/* 334 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 341 */     String strFieldValue = "";
/* 342 */     switch (nFieldIndex) {
/*     */     case 0:
/* 344 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 345 */       break;
/*     */     case 1:
/* 347 */       strFieldValue = StrTool.GBKToUnicode(this.roleID);
/* 348 */       break;
/*     */     case 2:
/* 350 */       strFieldValue = StrTool.GBKToUnicode(this.menuID);
/* 351 */       break;
/*     */     case 3:
/* 353 */       strFieldValue = StrTool.GBKToUnicode(this.buttonType);
/* 354 */       break;
/*     */     case 4:
/* 356 */       strFieldValue = StrTool.GBKToUnicode(this.buttonID);
/* 357 */       break;
/*     */     case 5:
/* 359 */       strFieldValue = StrTool.GBKToUnicode(this.buttonName);
/* 360 */       break;
/*     */     case 6:
/* 362 */       strFieldValue = String.valueOf(this.buttonSwitch);
/* 363 */       break;
/*     */     case 7:
/* 365 */       strFieldValue = StrTool.GBKToUnicode(this.controlFlag);
/* 366 */       break;
/*     */     case 8:
/* 368 */       strFieldValue = StrTool.GBKToUnicode(this.buttonDescription);
/* 369 */       break;
/*     */     default:
/* 371 */       strFieldValue = "";
/*     */     }
/* 373 */     if (strFieldValue.equals("")) {
/* 374 */       strFieldValue = "null";
/*     */     }
/* 376 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 382 */     if (StrTool.cTrim(FCode).equals("")) {
/* 383 */       return false;
/*     */     }
/* 385 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 387 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 389 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 392 */         this.iD = null;
/*     */     }
/* 394 */     if (FCode.equalsIgnoreCase("roleID"))
/*     */     {
/* 396 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 398 */         this.roleID = FValue.trim();
/*     */       }
/*     */       else
/* 401 */         this.roleID = null;
/*     */     }
/* 403 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 405 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 407 */         this.menuID = FValue.trim();
/*     */       }
/*     */       else
/* 410 */         this.menuID = null;
/*     */     }
/* 412 */     if (FCode.equalsIgnoreCase("buttonType"))
/*     */     {
/* 414 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 416 */         this.buttonType = FValue.trim();
/*     */       }
/*     */       else
/* 419 */         this.buttonType = null;
/*     */     }
/* 421 */     if (FCode.equalsIgnoreCase("buttonID"))
/*     */     {
/* 423 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 425 */         this.buttonID = FValue.trim();
/*     */       }
/*     */       else
/* 428 */         this.buttonID = null;
/*     */     }
/* 430 */     if (FCode.equalsIgnoreCase("buttonName"))
/*     */     {
/* 432 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 434 */         this.buttonName = FValue.trim();
/*     */       }
/*     */       else
/* 437 */         this.buttonName = null;
/*     */     }
/* 439 */     if (FCode.equalsIgnoreCase("buttonSwitch"))
/*     */     {
/* 441 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 443 */         Integer tInteger = new Integer(FValue);
/* 444 */         int i = tInteger.intValue();
/* 445 */         this.buttonSwitch = i;
/*     */       }
/*     */     }
/* 448 */     if (FCode.equalsIgnoreCase("controlFlag"))
/*     */     {
/* 450 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 452 */         this.controlFlag = FValue.trim();
/*     */       }
/*     */       else
/* 455 */         this.controlFlag = null;
/*     */     }
/* 457 */     if (FCode.equalsIgnoreCase("buttonDescription"))
/*     */     {
/* 459 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 461 */         this.buttonDescription = FValue.trim();
/*     */       }
/*     */       else
/* 464 */         this.buttonDescription = null;
/*     */     }
/* 466 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 471 */     if (otherObject == null) return false;
/* 472 */     if (this == otherObject) return true;
/* 473 */     if (getClass() != otherObject.getClass()) return false;
/* 474 */     MPageCtrlSchema other = (MPageCtrlSchema)otherObject;
/* 475 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 476 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 477 */     if ((this.roleID == null) && (other.getRoleID() != null)) return false;
/* 478 */     if ((this.roleID != null) && (!this.roleID.equals(other.getRoleID()))) return false;
/* 479 */     if ((this.menuID == null) && (other.getMenuID() != null)) return false;
/* 480 */     if ((this.menuID != null) && (!this.menuID.equals(other.getMenuID()))) return false;
/* 481 */     if ((this.buttonType == null) && (other.getButtonType() != null)) return false;
/* 482 */     if ((this.buttonType != null) && (!this.buttonType.equals(other.getButtonType()))) return false;
/* 483 */     if ((this.buttonID == null) && (other.getButtonID() != null)) return false;
/* 484 */     if ((this.buttonID != null) && (!this.buttonID.equals(other.getButtonID()))) return false;
/* 485 */     if ((this.buttonName == null) && (other.getButtonName() != null)) return false;
/* 486 */     if ((this.buttonName != null) && (!this.buttonName.equals(other.getButtonName()))) return false;
/* 487 */     if (this.buttonSwitch != other.getButtonSwitch()) return false;
/* 488 */     if ((this.controlFlag == null) && (other.getControlFlag() != null)) return false;
/* 489 */     if ((this.controlFlag != null) && (!this.controlFlag.equals(other.getControlFlag()))) return false;
/* 490 */     if ((this.buttonDescription == null) && (other.getButtonDescription() != null)) return false;
/* 491 */     return (this.buttonDescription == null) || (this.buttonDescription.equals(other.getButtonDescription()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 498 */     return 9;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 504 */     if (strFieldName.equals("iD")) {
/* 505 */       return 0;
/*     */     }
/* 507 */     if (strFieldName.equals("roleID")) {
/* 508 */       return 1;
/*     */     }
/* 510 */     if (strFieldName.equals("menuID")) {
/* 511 */       return 2;
/*     */     }
/* 513 */     if (strFieldName.equals("buttonType")) {
/* 514 */       return 3;
/*     */     }
/* 516 */     if (strFieldName.equals("buttonID")) {
/* 517 */       return 4;
/*     */     }
/* 519 */     if (strFieldName.equals("buttonName")) {
/* 520 */       return 5;
/*     */     }
/* 522 */     if (strFieldName.equals("buttonSwitch")) {
/* 523 */       return 6;
/*     */     }
/* 525 */     if (strFieldName.equals("controlFlag")) {
/* 526 */       return 7;
/*     */     }
/* 528 */     if (strFieldName.equals("buttonDescription")) {
/* 529 */       return 8;
/*     */     }
/* 531 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 537 */     String strFieldName = "";
/* 538 */     switch (nFieldIndex) {
/*     */     case 0:
/* 540 */       strFieldName = "iD";
/* 541 */       break;
/*     */     case 1:
/* 543 */       strFieldName = "roleID";
/* 544 */       break;
/*     */     case 2:
/* 546 */       strFieldName = "menuID";
/* 547 */       break;
/*     */     case 3:
/* 549 */       strFieldName = "buttonType";
/* 550 */       break;
/*     */     case 4:
/* 552 */       strFieldName = "buttonID";
/* 553 */       break;
/*     */     case 5:
/* 555 */       strFieldName = "buttonName";
/* 556 */       break;
/*     */     case 6:
/* 558 */       strFieldName = "buttonSwitch";
/* 559 */       break;
/*     */     case 7:
/* 561 */       strFieldName = "controlFlag";
/* 562 */       break;
/*     */     case 8:
/* 564 */       strFieldName = "buttonDescription";
/* 565 */       break;
/*     */     default:
/* 567 */       strFieldName = "";
/*     */     }
/* 569 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 575 */     if (strFieldName.equals("iD")) {
/* 576 */       return 0;
/*     */     }
/* 578 */     if (strFieldName.equals("roleID")) {
/* 579 */       return 0;
/*     */     }
/* 581 */     if (strFieldName.equals("menuID")) {
/* 582 */       return 0;
/*     */     }
/* 584 */     if (strFieldName.equals("buttonType")) {
/* 585 */       return 0;
/*     */     }
/* 587 */     if (strFieldName.equals("buttonID")) {
/* 588 */       return 0;
/*     */     }
/* 590 */     if (strFieldName.equals("buttonName")) {
/* 591 */       return 0;
/*     */     }
/* 593 */     if (strFieldName.equals("buttonSwitch")) {
/* 594 */       return 3;
/*     */     }
/* 596 */     if (strFieldName.equals("controlFlag")) {
/* 597 */       return 0;
/*     */     }
/* 599 */     if (strFieldName.equals("buttonDescription")) {
/* 600 */       return 0;
/*     */     }
/* 602 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 608 */     int nFieldType = -1;
/* 609 */     switch (nFieldIndex) {
/*     */     case 0:
/* 611 */       nFieldType = 0;
/* 612 */       break;
/*     */     case 1:
/* 614 */       nFieldType = 0;
/* 615 */       break;
/*     */     case 2:
/* 617 */       nFieldType = 0;
/* 618 */       break;
/*     */     case 3:
/* 620 */       nFieldType = 0;
/* 621 */       break;
/*     */     case 4:
/* 623 */       nFieldType = 0;
/* 624 */       break;
/*     */     case 5:
/* 626 */       nFieldType = 0;
/* 627 */       break;
/*     */     case 6:
/* 629 */       nFieldType = 3;
/* 630 */       break;
/*     */     case 7:
/* 632 */       nFieldType = 0;
/* 633 */       break;
/*     */     case 8:
/* 635 */       nFieldType = 0;
/* 636 */       break;
/*     */     default:
/* 638 */       nFieldType = -1;
/*     */     }
/* 640 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MPageCtrlSchema
 * JD-Core Version:    0.6.0
 */