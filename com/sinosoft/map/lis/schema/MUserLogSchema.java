/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MUserLogDB;
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
/*     */ public class MUserLogSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String userCode;
/*     */   private String userType;
/*     */   private String traceType;
/*     */   private String menuID;
/*     */   private String menuName;
/*     */   private String operation;
/*     */   private String discription;
/*     */   private String cientIP;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  46 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MUserLogSchema()
/*     */   {
/*  53 */     this.mErrors = new CErrors();
/*     */ 
/*  55 */     String[] pk = new String[1];
/*  56 */     pk[0] = "ID";
/*     */ 
/*  58 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  65 */     MUserLogSchema cloned = (MUserLogSchema)super.clone();
/*  66 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  67 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  68 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  74 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  79 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  83 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/*  87 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String aUserCode) {
/*  91 */     this.userCode = aUserCode;
/*     */   }
/*     */ 
/*     */   public String getUserType() {
/*  95 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(String aUserType) {
/*  99 */     this.userType = aUserType;
/*     */   }
/*     */ 
/*     */   public String getTraceType() {
/* 103 */     return this.traceType;
/*     */   }
/*     */ 
/*     */   public void setTraceType(String aTraceType) {
/* 107 */     this.traceType = aTraceType;
/*     */   }
/*     */ 
/*     */   public String getMenuID() {
/* 111 */     return this.menuID;
/*     */   }
/*     */ 
/*     */   public void setMenuID(String aMenuID) {
/* 115 */     this.menuID = aMenuID;
/*     */   }
/*     */ 
/*     */   public String getMenuName() {
/* 119 */     return this.menuName;
/*     */   }
/*     */ 
/*     */   public void setMenuName(String aMenuName) {
/* 123 */     this.menuName = aMenuName;
/*     */   }
/*     */ 
/*     */   public String getOperation() {
/* 127 */     return this.operation;
/*     */   }
/*     */ 
/*     */   public void setOperation(String aOperation) {
/* 131 */     this.operation = aOperation;
/*     */   }
/*     */ 
/*     */   public String getDiscription() {
/* 135 */     return this.discription;
/*     */   }
/*     */ 
/*     */   public void setDiscription(String aDiscription) {
/* 139 */     this.discription = aDiscription;
/*     */   }
/*     */ 
/*     */   public String getCientIP() {
/* 143 */     return this.cientIP;
/*     */   }
/*     */ 
/*     */   public void setCientIP(String aCientIP) {
/* 147 */     this.cientIP = aCientIP;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 151 */     if (this.makeDate != null) {
/* 152 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 154 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 158 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 162 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 164 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 167 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 172 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 176 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(MUserLogSchema aMUserLogSchema)
/*     */   {
/* 182 */     this.iD = aMUserLogSchema.getID();
/* 183 */     this.userCode = aMUserLogSchema.getUserCode();
/* 184 */     this.userType = aMUserLogSchema.getUserType();
/* 185 */     this.traceType = aMUserLogSchema.getTraceType();
/* 186 */     this.menuID = aMUserLogSchema.getMenuID();
/* 187 */     this.menuName = aMUserLogSchema.getMenuName();
/* 188 */     this.operation = aMUserLogSchema.getOperation();
/* 189 */     this.discription = aMUserLogSchema.getDiscription();
/* 190 */     this.cientIP = aMUserLogSchema.getCientIP();
/* 191 */     this.makeDate = this.fDate.getDate(aMUserLogSchema.getMakeDate());
/* 192 */     this.makeTime = aMUserLogSchema.getMakeTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 201 */       if (rs.getString("ID") == null)
/* 202 */         this.iD = null;
/*     */       else {
/* 204 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 206 */       if (rs.getString("UserCode") == null)
/* 207 */         this.userCode = null;
/*     */       else {
/* 209 */         this.userCode = rs.getString("UserCode").trim();
/*     */       }
/* 211 */       if (rs.getString("UserType") == null)
/* 212 */         this.userType = null;
/*     */       else {
/* 214 */         this.userType = rs.getString("UserType").trim();
/*     */       }
/* 216 */       if (rs.getString("TraceType") == null)
/* 217 */         this.traceType = null;
/*     */       else {
/* 219 */         this.traceType = rs.getString("TraceType").trim();
/*     */       }
/* 221 */       if (rs.getString("MenuID") == null)
/* 222 */         this.menuID = null;
/*     */       else {
/* 224 */         this.menuID = rs.getString("MenuID").trim();
/*     */       }
/* 226 */       if (rs.getString("MenuName") == null)
/* 227 */         this.menuName = null;
/*     */       else {
/* 229 */         this.menuName = rs.getString("MenuName").trim();
/*     */       }
/* 231 */       if (rs.getString("Operation") == null)
/* 232 */         this.operation = null;
/*     */       else {
/* 234 */         this.operation = rs.getString("Operation").trim();
/*     */       }
/* 236 */       if (rs.getString("Discription") == null)
/* 237 */         this.discription = null;
/*     */       else {
/* 239 */         this.discription = rs.getString("Discription").trim();
/*     */       }
/* 241 */       if (rs.getString("CientIP") == null)
/* 242 */         this.cientIP = null;
/*     */       else {
/* 244 */         this.cientIP = rs.getString("CientIP").trim();
/*     */       }
/* 246 */       this.makeDate = rs.getDate("MakeDate");
/* 247 */       if (rs.getString("MakeTime") == null)
/* 248 */         this.makeTime = null;
/*     */       else {
/* 250 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 255 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MUserLog\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 257 */       CError tError = new CError();
/* 258 */       tError.moduleName = "MUserLogSchema";
/* 259 */       tError.functionName = "setSchema";
/* 260 */       tError.errorMessage = sqle.toString();
/* 261 */       this.mErrors.addOneError(tError);
/* 262 */       return false;
/*     */     }
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   public MUserLogSchema getSchema()
/*     */   {
/* 269 */     MUserLogSchema aMUserLogSchema = new MUserLogSchema();
/* 270 */     aMUserLogSchema.setSchema(this);
/* 271 */     return aMUserLogSchema;
/*     */   }
/*     */ 
/*     */   public MUserLogDB getDB()
/*     */   {
/* 276 */     MUserLogDB aDBOper = new MUserLogDB();
/* 277 */     aDBOper.setSchema(this);
/* 278 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 285 */     StringBuffer strReturn = new StringBuffer(256);
/* 286 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 287 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/* 288 */     strReturn.append(StrTool.cTrim(this.userType)); strReturn.append("|");
/* 289 */     strReturn.append(StrTool.cTrim(this.traceType)); strReturn.append("|");
/* 290 */     strReturn.append(StrTool.cTrim(this.menuID)); strReturn.append("|");
/* 291 */     strReturn.append(StrTool.cTrim(this.menuName)); strReturn.append("|");
/* 292 */     strReturn.append(StrTool.cTrim(this.operation)); strReturn.append("|");
/* 293 */     strReturn.append(StrTool.cTrim(this.discription)); strReturn.append("|");
/* 294 */     strReturn.append(StrTool.cTrim(this.cientIP)); strReturn.append("|");
/* 295 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 296 */     strReturn.append(StrTool.cTrim(this.makeTime));
/* 297 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 305 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 306 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 307 */       this.userType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 308 */       this.traceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 309 */       this.menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 310 */       this.menuName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 311 */       this.operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 312 */       this.discription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 313 */       this.cientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 314 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 315 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 320 */       CError tError = new CError();
/* 321 */       tError.moduleName = "MUserLogSchema";
/* 322 */       tError.functionName = "decode";
/* 323 */       tError.errorMessage = ex.toString();
/* 324 */       this.mErrors.addOneError(tError);
/*     */ 
/* 326 */       return false;
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 334 */     String strReturn = "";
/* 335 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 337 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 339 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 341 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*     */     }
/* 343 */     if (FCode.equalsIgnoreCase("userType"))
/*     */     {
/* 345 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userType));
/*     */     }
/* 347 */     if (FCode.equalsIgnoreCase("traceType"))
/*     */     {
/* 349 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.traceType));
/*     */     }
/* 351 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 353 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.menuID));
/*     */     }
/* 355 */     if (FCode.equalsIgnoreCase("menuName"))
/*     */     {
/* 357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.menuName));
/*     */     }
/* 359 */     if (FCode.equalsIgnoreCase("operation"))
/*     */     {
/* 361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operation));
/*     */     }
/* 363 */     if (FCode.equalsIgnoreCase("discription"))
/*     */     {
/* 365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.discription));
/*     */     }
/* 367 */     if (FCode.equalsIgnoreCase("cientIP"))
/*     */     {
/* 369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cientIP));
/*     */     }
/* 371 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 375 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 379 */     if (strReturn.equals(""))
/*     */     {
/* 381 */       strReturn = "null";
/*     */     }
/*     */ 
/* 384 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 391 */     String strFieldValue = "";
/* 392 */     switch (nFieldIndex) {
/*     */     case 0:
/* 394 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 395 */       break;
/*     */     case 1:
/* 397 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/* 398 */       break;
/*     */     case 2:
/* 400 */       strFieldValue = StrTool.GBKToUnicode(this.userType);
/* 401 */       break;
/*     */     case 3:
/* 403 */       strFieldValue = StrTool.GBKToUnicode(this.traceType);
/* 404 */       break;
/*     */     case 4:
/* 406 */       strFieldValue = StrTool.GBKToUnicode(this.menuID);
/* 407 */       break;
/*     */     case 5:
/* 409 */       strFieldValue = StrTool.GBKToUnicode(this.menuName);
/* 410 */       break;
/*     */     case 6:
/* 412 */       strFieldValue = StrTool.GBKToUnicode(this.operation);
/* 413 */       break;
/*     */     case 7:
/* 415 */       strFieldValue = StrTool.GBKToUnicode(this.discription);
/* 416 */       break;
/*     */     case 8:
/* 418 */       strFieldValue = StrTool.GBKToUnicode(this.cientIP);
/* 419 */       break;
/*     */     case 9:
/* 421 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 422 */       break;
/*     */     case 10:
/* 424 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 425 */       break;
/*     */     default:
/* 427 */       strFieldValue = "";
/*     */     }
/* 429 */     if (strFieldValue.equals("")) {
/* 430 */       strFieldValue = "null";
/*     */     }
/* 432 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 438 */     if (StrTool.cTrim(FCode).equals("")) {
/* 439 */       return false;
/*     */     }
/* 441 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 443 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 445 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 448 */         this.iD = null;
/*     */     }
/* 450 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 452 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 454 */         this.userCode = FValue.trim();
/*     */       }
/*     */       else
/* 457 */         this.userCode = null;
/*     */     }
/* 459 */     if (FCode.equalsIgnoreCase("userType"))
/*     */     {
/* 461 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 463 */         this.userType = FValue.trim();
/*     */       }
/*     */       else
/* 466 */         this.userType = null;
/*     */     }
/* 468 */     if (FCode.equalsIgnoreCase("traceType"))
/*     */     {
/* 470 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 472 */         this.traceType = FValue.trim();
/*     */       }
/*     */       else
/* 475 */         this.traceType = null;
/*     */     }
/* 477 */     if (FCode.equalsIgnoreCase("menuID"))
/*     */     {
/* 479 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 481 */         this.menuID = FValue.trim();
/*     */       }
/*     */       else
/* 484 */         this.menuID = null;
/*     */     }
/* 486 */     if (FCode.equalsIgnoreCase("menuName"))
/*     */     {
/* 488 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 490 */         this.menuName = FValue.trim();
/*     */       }
/*     */       else
/* 493 */         this.menuName = null;
/*     */     }
/* 495 */     if (FCode.equalsIgnoreCase("operation"))
/*     */     {
/* 497 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 499 */         this.operation = FValue.trim();
/*     */       }
/*     */       else
/* 502 */         this.operation = null;
/*     */     }
/* 504 */     if (FCode.equalsIgnoreCase("discription"))
/*     */     {
/* 506 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 508 */         this.discription = FValue.trim();
/*     */       }
/*     */       else
/* 511 */         this.discription = null;
/*     */     }
/* 513 */     if (FCode.equalsIgnoreCase("cientIP"))
/*     */     {
/* 515 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 517 */         this.cientIP = FValue.trim();
/*     */       }
/*     */       else
/* 520 */         this.cientIP = null;
/*     */     }
/* 522 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 524 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 526 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 529 */         this.makeDate = null;
/*     */     }
/* 531 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 533 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 535 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 538 */         this.makeTime = null;
/*     */     }
/* 540 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 545 */     if (otherObject == null) return false;
/* 546 */     if (this == otherObject) return true;
/* 547 */     if (getClass() != otherObject.getClass()) return false;
/* 548 */     MUserLogSchema other = (MUserLogSchema)otherObject;
/* 549 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 550 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 551 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/* 552 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/* 553 */     if ((this.userType == null) && (other.getUserType() != null)) return false;
/* 554 */     if ((this.userType != null) && (!this.userType.equals(other.getUserType()))) return false;
/* 555 */     if ((this.traceType == null) && (other.getTraceType() != null)) return false;
/* 556 */     if ((this.traceType != null) && (!this.traceType.equals(other.getTraceType()))) return false;
/* 557 */     if ((this.menuID == null) && (other.getMenuID() != null)) return false;
/* 558 */     if ((this.menuID != null) && (!this.menuID.equals(other.getMenuID()))) return false;
/* 559 */     if ((this.menuName == null) && (other.getMenuName() != null)) return false;
/* 560 */     if ((this.menuName != null) && (!this.menuName.equals(other.getMenuName()))) return false;
/* 561 */     if ((this.operation == null) && (other.getOperation() != null)) return false;
/* 562 */     if ((this.operation != null) && (!this.operation.equals(other.getOperation()))) return false;
/* 563 */     if ((this.discription == null) && (other.getDiscription() != null)) return false;
/* 564 */     if ((this.discription != null) && (!this.discription.equals(other.getDiscription()))) return false;
/* 565 */     if ((this.cientIP == null) && (other.getCientIP() != null)) return false;
/* 566 */     if ((this.cientIP != null) && (!this.cientIP.equals(other.getCientIP()))) return false;
/* 567 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 568 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 569 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 570 */     return (this.makeTime == null) || (this.makeTime.equals(other.getMakeTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 577 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 583 */     if (strFieldName.equals("iD")) {
/* 584 */       return 0;
/*     */     }
/* 586 */     if (strFieldName.equals("userCode")) {
/* 587 */       return 1;
/*     */     }
/* 589 */     if (strFieldName.equals("userType")) {
/* 590 */       return 2;
/*     */     }
/* 592 */     if (strFieldName.equals("traceType")) {
/* 593 */       return 3;
/*     */     }
/* 595 */     if (strFieldName.equals("menuID")) {
/* 596 */       return 4;
/*     */     }
/* 598 */     if (strFieldName.equals("menuName")) {
/* 599 */       return 5;
/*     */     }
/* 601 */     if (strFieldName.equals("operation")) {
/* 602 */       return 6;
/*     */     }
/* 604 */     if (strFieldName.equals("discription")) {
/* 605 */       return 7;
/*     */     }
/* 607 */     if (strFieldName.equals("cientIP")) {
/* 608 */       return 8;
/*     */     }
/* 610 */     if (strFieldName.equals("makeDate")) {
/* 611 */       return 9;
/*     */     }
/* 613 */     if (strFieldName.equals("makeTime")) {
/* 614 */       return 10;
/*     */     }
/* 616 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 622 */     String strFieldName = "";
/* 623 */     switch (nFieldIndex) {
/*     */     case 0:
/* 625 */       strFieldName = "iD";
/* 626 */       break;
/*     */     case 1:
/* 628 */       strFieldName = "userCode";
/* 629 */       break;
/*     */     case 2:
/* 631 */       strFieldName = "userType";
/* 632 */       break;
/*     */     case 3:
/* 634 */       strFieldName = "traceType";
/* 635 */       break;
/*     */     case 4:
/* 637 */       strFieldName = "menuID";
/* 638 */       break;
/*     */     case 5:
/* 640 */       strFieldName = "menuName";
/* 641 */       break;
/*     */     case 6:
/* 643 */       strFieldName = "operation";
/* 644 */       break;
/*     */     case 7:
/* 646 */       strFieldName = "discription";
/* 647 */       break;
/*     */     case 8:
/* 649 */       strFieldName = "cientIP";
/* 650 */       break;
/*     */     case 9:
/* 652 */       strFieldName = "makeDate";
/* 653 */       break;
/*     */     case 10:
/* 655 */       strFieldName = "makeTime";
/* 656 */       break;
/*     */     default:
/* 658 */       strFieldName = "";
/*     */     }
/* 660 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 666 */     if (strFieldName.equals("iD")) {
/* 667 */       return 0;
/*     */     }
/* 669 */     if (strFieldName.equals("userCode")) {
/* 670 */       return 0;
/*     */     }
/* 672 */     if (strFieldName.equals("userType")) {
/* 673 */       return 0;
/*     */     }
/* 675 */     if (strFieldName.equals("traceType")) {
/* 676 */       return 0;
/*     */     }
/* 678 */     if (strFieldName.equals("menuID")) {
/* 679 */       return 0;
/*     */     }
/* 681 */     if (strFieldName.equals("menuName")) {
/* 682 */       return 0;
/*     */     }
/* 684 */     if (strFieldName.equals("operation")) {
/* 685 */       return 0;
/*     */     }
/* 687 */     if (strFieldName.equals("discription")) {
/* 688 */       return 0;
/*     */     }
/* 690 */     if (strFieldName.equals("cientIP")) {
/* 691 */       return 0;
/*     */     }
/* 693 */     if (strFieldName.equals("makeDate")) {
/* 694 */       return 1;
/*     */     }
/* 696 */     if (strFieldName.equals("makeTime")) {
/* 697 */       return 0;
/*     */     }
/* 699 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 705 */     int nFieldType = -1;
/* 706 */     switch (nFieldIndex) {
/*     */     case 0:
/* 708 */       nFieldType = 0;
/* 709 */       break;
/*     */     case 1:
/* 711 */       nFieldType = 0;
/* 712 */       break;
/*     */     case 2:
/* 714 */       nFieldType = 0;
/* 715 */       break;
/*     */     case 3:
/* 717 */       nFieldType = 0;
/* 718 */       break;
/*     */     case 4:
/* 720 */       nFieldType = 0;
/* 721 */       break;
/*     */     case 5:
/* 723 */       nFieldType = 0;
/* 724 */       break;
/*     */     case 6:
/* 726 */       nFieldType = 0;
/* 727 */       break;
/*     */     case 7:
/* 729 */       nFieldType = 0;
/* 730 */       break;
/*     */     case 8:
/* 732 */       nFieldType = 0;
/* 733 */       break;
/*     */     case 9:
/* 735 */       nFieldType = 1;
/* 736 */       break;
/*     */     case 10:
/* 738 */       nFieldType = 0;
/* 739 */       break;
/*     */     default:
/* 741 */       nFieldType = -1;
/*     */     }
/* 743 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MUserLogSchema
 * JD-Core Version:    0.6.0
 */