/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MWebLoginLogDB;
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
/*     */ public class MWebLoginLogSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String sessionId;
/*     */   private String userCode;
/*     */   private String userType;
/*     */   private String clientName;
/*     */   private String clientType;
/*     */   private String clientIP;
/*     */   private Date loginDate;
/*     */   private String loginTime;
/*     */   private Date logoutDate;
/*     */   private String logoutTime;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  46 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MWebLoginLogSchema()
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
/*  65 */     MWebLoginLogSchema cloned = (MWebLoginLogSchema)super.clone();
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
/*     */   public String getSessionId() {
/*  87 */     return this.sessionId;
/*     */   }
/*     */ 
/*     */   public void setSessionId(String aSessionId) {
/*  91 */     this.sessionId = aSessionId;
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
/*     */   public String getUserType() {
/* 103 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(String aUserType) {
/* 107 */     this.userType = aUserType;
/*     */   }
/*     */ 
/*     */   public String getClientName() {
/* 111 */     return this.clientName;
/*     */   }
/*     */ 
/*     */   public void setClientName(String aClientName) {
/* 115 */     this.clientName = aClientName;
/*     */   }
/*     */ 
/*     */   public String getClientType() {
/* 119 */     return this.clientType;
/*     */   }
/*     */ 
/*     */   public void setClientType(String aClientType) {
/* 123 */     this.clientType = aClientType;
/*     */   }
/*     */ 
/*     */   public String getClientIP() {
/* 127 */     return this.clientIP;
/*     */   }
/*     */ 
/*     */   public void setClientIP(String aClientIP) {
/* 131 */     this.clientIP = aClientIP;
/*     */   }
/*     */ 
/*     */   public String getLoginDate() {
/* 135 */     if (this.loginDate != null) {
/* 136 */       return this.fDate.getString(this.loginDate);
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */   public void setLoginDate(Date aLoginDate) {
/* 142 */     this.loginDate = aLoginDate;
/*     */   }
/*     */ 
/*     */   public void setLoginDate(String aLoginDate) {
/* 146 */     if ((aLoginDate != null) && (!aLoginDate.equals("")))
/*     */     {
/* 148 */       this.loginDate = this.fDate.getDate(aLoginDate);
/*     */     }
/*     */     else
/* 151 */       this.loginDate = null;
/*     */   }
/*     */ 
/*     */   public String getLoginTime()
/*     */   {
/* 156 */     return this.loginTime;
/*     */   }
/*     */ 
/*     */   public void setLoginTime(String aLoginTime) {
/* 160 */     this.loginTime = aLoginTime;
/*     */   }
/*     */ 
/*     */   public String getLogoutDate() {
/* 164 */     if (this.logoutDate != null) {
/* 165 */       return this.fDate.getString(this.logoutDate);
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   public void setLogoutDate(Date aLogoutDate) {
/* 171 */     this.logoutDate = aLogoutDate;
/*     */   }
/*     */ 
/*     */   public void setLogoutDate(String aLogoutDate) {
/* 175 */     if ((aLogoutDate != null) && (!aLogoutDate.equals("")))
/*     */     {
/* 177 */       this.logoutDate = this.fDate.getDate(aLogoutDate);
/*     */     }
/*     */     else
/* 180 */       this.logoutDate = null;
/*     */   }
/*     */ 
/*     */   public String getLogoutTime()
/*     */   {
/* 185 */     return this.logoutTime;
/*     */   }
/*     */ 
/*     */   public void setLogoutTime(String aLogoutTime) {
/* 189 */     this.logoutTime = aLogoutTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(MWebLoginLogSchema aMWebLoginLogSchema)
/*     */   {
/* 195 */     this.iD = aMWebLoginLogSchema.getID();
/* 196 */     this.sessionId = aMWebLoginLogSchema.getSessionId();
/* 197 */     this.userCode = aMWebLoginLogSchema.getUserCode();
/* 198 */     this.userType = aMWebLoginLogSchema.getUserType();
/* 199 */     this.clientName = aMWebLoginLogSchema.getClientName();
/* 200 */     this.clientType = aMWebLoginLogSchema.getClientType();
/* 201 */     this.clientIP = aMWebLoginLogSchema.getClientIP();
/* 202 */     this.loginDate = this.fDate.getDate(aMWebLoginLogSchema.getLoginDate());
/* 203 */     this.loginTime = aMWebLoginLogSchema.getLoginTime();
/* 204 */     this.logoutDate = this.fDate.getDate(aMWebLoginLogSchema.getLogoutDate());
/* 205 */     this.logoutTime = aMWebLoginLogSchema.getLogoutTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 214 */       if (rs.getString("ID") == null)
/* 215 */         this.iD = null;
/*     */       else {
/* 217 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 219 */       if (rs.getString("SessionId") == null)
/* 220 */         this.sessionId = null;
/*     */       else {
/* 222 */         this.sessionId = rs.getString("SessionId").trim();
/*     */       }
/* 224 */       if (rs.getString("UserCode") == null)
/* 225 */         this.userCode = null;
/*     */       else {
/* 227 */         this.userCode = rs.getString("UserCode").trim();
/*     */       }
/* 229 */       if (rs.getString("UserType") == null)
/* 230 */         this.userType = null;
/*     */       else {
/* 232 */         this.userType = rs.getString("UserType").trim();
/*     */       }
/* 234 */       if (rs.getString("ClientName") == null)
/* 235 */         this.clientName = null;
/*     */       else {
/* 237 */         this.clientName = rs.getString("ClientName").trim();
/*     */       }
/* 239 */       if (rs.getString("ClientType") == null)
/* 240 */         this.clientType = null;
/*     */       else {
/* 242 */         this.clientType = rs.getString("ClientType").trim();
/*     */       }
/* 244 */       if (rs.getString("ClientIP") == null)
/* 245 */         this.clientIP = null;
/*     */       else {
/* 247 */         this.clientIP = rs.getString("ClientIP").trim();
/*     */       }
/* 249 */       this.loginDate = rs.getDate("LoginDate");
/* 250 */       if (rs.getString("LoginTime") == null)
/* 251 */         this.loginTime = null;
/*     */       else {
/* 253 */         this.loginTime = rs.getString("LoginTime").trim();
/*     */       }
/* 255 */       this.logoutDate = rs.getDate("LogoutDate");
/* 256 */       if (rs.getString("LogoutTime") == null)
/* 257 */         this.logoutTime = null;
/*     */       else {
/* 259 */         this.logoutTime = rs.getString("LogoutTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 264 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MWebLoginLog\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 266 */       CError tError = new CError();
/* 267 */       tError.moduleName = "MWebLoginLogSchema";
/* 268 */       tError.functionName = "setSchema";
/* 269 */       tError.errorMessage = sqle.toString();
/* 270 */       this.mErrors.addOneError(tError);
/* 271 */       return false;
/*     */     }
/* 273 */     return true;
/*     */   }
/*     */ 
/*     */   public MWebLoginLogSchema getSchema()
/*     */   {
/* 278 */     MWebLoginLogSchema aMWebLoginLogSchema = new MWebLoginLogSchema();
/* 279 */     aMWebLoginLogSchema.setSchema(this);
/* 280 */     return aMWebLoginLogSchema;
/*     */   }
/*     */ 
/*     */   public MWebLoginLogDB getDB()
/*     */   {
/* 285 */     MWebLoginLogDB aDBOper = new MWebLoginLogDB();
/* 286 */     aDBOper.setSchema(this);
/* 287 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 294 */     StringBuffer strReturn = new StringBuffer(256);
/* 295 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 296 */     strReturn.append(StrTool.cTrim(this.sessionId)); strReturn.append("|");
/* 297 */     strReturn.append(StrTool.cTrim(this.userCode)); strReturn.append("|");
/* 298 */     strReturn.append(StrTool.cTrim(this.userType)); strReturn.append("|");
/* 299 */     strReturn.append(StrTool.cTrim(this.clientName)); strReturn.append("|");
/* 300 */     strReturn.append(StrTool.cTrim(this.clientType)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.clientIP)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.loginDate))); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.loginTime)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.logoutDate))); strReturn.append("|");
/* 305 */     strReturn.append(StrTool.cTrim(this.logoutTime));
/* 306 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 314 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 315 */       this.sessionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 316 */       this.userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 317 */       this.userType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 318 */       this.clientName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 319 */       this.clientType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 320 */       this.clientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 321 */       this.loginDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 322 */       this.loginTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 323 */       this.logoutDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 324 */       this.logoutTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 329 */       CError tError = new CError();
/* 330 */       tError.moduleName = "MWebLoginLogSchema";
/* 331 */       tError.functionName = "decode";
/* 332 */       tError.errorMessage = ex.toString();
/* 333 */       this.mErrors.addOneError(tError);
/*     */ 
/* 335 */       return false;
/*     */     }
/* 337 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 343 */     String strReturn = "";
/* 344 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 346 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 348 */     if (FCode.equalsIgnoreCase("sessionId"))
/*     */     {
/* 350 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sessionId));
/*     */     }
/* 352 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 354 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userCode));
/*     */     }
/* 356 */     if (FCode.equalsIgnoreCase("userType"))
/*     */     {
/* 358 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.userType));
/*     */     }
/* 360 */     if (FCode.equalsIgnoreCase("clientName"))
/*     */     {
/* 362 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clientName));
/*     */     }
/* 364 */     if (FCode.equalsIgnoreCase("clientType"))
/*     */     {
/* 366 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clientType));
/*     */     }
/* 368 */     if (FCode.equalsIgnoreCase("clientIP"))
/*     */     {
/* 370 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clientIP));
/*     */     }
/* 372 */     if (FCode.equalsIgnoreCase("loginDate"))
/*     */     {
/* 374 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLoginDate()));
/*     */     }
/* 376 */     if (FCode.equalsIgnoreCase("loginTime"))
/*     */     {
/* 378 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.loginTime));
/*     */     }
/* 380 */     if (FCode.equalsIgnoreCase("logoutDate"))
/*     */     {
/* 382 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getLogoutDate()));
/*     */     }
/* 384 */     if (FCode.equalsIgnoreCase("logoutTime"))
/*     */     {
/* 386 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.logoutTime));
/*     */     }
/* 388 */     if (strReturn.equals(""))
/*     */     {
/* 390 */       strReturn = "null";
/*     */     }
/*     */ 
/* 393 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 400 */     String strFieldValue = "";
/* 401 */     switch (nFieldIndex) {
/*     */     case 0:
/* 403 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 404 */       break;
/*     */     case 1:
/* 406 */       strFieldValue = StrTool.GBKToUnicode(this.sessionId);
/* 407 */       break;
/*     */     case 2:
/* 409 */       strFieldValue = StrTool.GBKToUnicode(this.userCode);
/* 410 */       break;
/*     */     case 3:
/* 412 */       strFieldValue = StrTool.GBKToUnicode(this.userType);
/* 413 */       break;
/*     */     case 4:
/* 415 */       strFieldValue = StrTool.GBKToUnicode(this.clientName);
/* 416 */       break;
/*     */     case 5:
/* 418 */       strFieldValue = StrTool.GBKToUnicode(this.clientType);
/* 419 */       break;
/*     */     case 6:
/* 421 */       strFieldValue = StrTool.GBKToUnicode(this.clientIP);
/* 422 */       break;
/*     */     case 7:
/* 424 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLoginDate()));
/* 425 */       break;
/*     */     case 8:
/* 427 */       strFieldValue = StrTool.GBKToUnicode(this.loginTime);
/* 428 */       break;
/*     */     case 9:
/* 430 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLogoutDate()));
/* 431 */       break;
/*     */     case 10:
/* 433 */       strFieldValue = StrTool.GBKToUnicode(this.logoutTime);
/* 434 */       break;
/*     */     default:
/* 436 */       strFieldValue = "";
/*     */     }
/* 438 */     if (strFieldValue.equals("")) {
/* 439 */       strFieldValue = "null";
/*     */     }
/* 441 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 447 */     if (StrTool.cTrim(FCode).equals("")) {
/* 448 */       return false;
/*     */     }
/* 450 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 452 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 454 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 457 */         this.iD = null;
/*     */     }
/* 459 */     if (FCode.equalsIgnoreCase("sessionId"))
/*     */     {
/* 461 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 463 */         this.sessionId = FValue.trim();
/*     */       }
/*     */       else
/* 466 */         this.sessionId = null;
/*     */     }
/* 468 */     if (FCode.equalsIgnoreCase("userCode"))
/*     */     {
/* 470 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 472 */         this.userCode = FValue.trim();
/*     */       }
/*     */       else
/* 475 */         this.userCode = null;
/*     */     }
/* 477 */     if (FCode.equalsIgnoreCase("userType"))
/*     */     {
/* 479 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 481 */         this.userType = FValue.trim();
/*     */       }
/*     */       else
/* 484 */         this.userType = null;
/*     */     }
/* 486 */     if (FCode.equalsIgnoreCase("clientName"))
/*     */     {
/* 488 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 490 */         this.clientName = FValue.trim();
/*     */       }
/*     */       else
/* 493 */         this.clientName = null;
/*     */     }
/* 495 */     if (FCode.equalsIgnoreCase("clientType"))
/*     */     {
/* 497 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 499 */         this.clientType = FValue.trim();
/*     */       }
/*     */       else
/* 502 */         this.clientType = null;
/*     */     }
/* 504 */     if (FCode.equalsIgnoreCase("clientIP"))
/*     */     {
/* 506 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 508 */         this.clientIP = FValue.trim();
/*     */       }
/*     */       else
/* 511 */         this.clientIP = null;
/*     */     }
/* 513 */     if (FCode.equalsIgnoreCase("loginDate"))
/*     */     {
/* 515 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 517 */         this.loginDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 520 */         this.loginDate = null;
/*     */     }
/* 522 */     if (FCode.equalsIgnoreCase("loginTime"))
/*     */     {
/* 524 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 526 */         this.loginTime = FValue.trim();
/*     */       }
/*     */       else
/* 529 */         this.loginTime = null;
/*     */     }
/* 531 */     if (FCode.equalsIgnoreCase("logoutDate"))
/*     */     {
/* 533 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 535 */         this.logoutDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 538 */         this.logoutDate = null;
/*     */     }
/* 540 */     if (FCode.equalsIgnoreCase("logoutTime"))
/*     */     {
/* 542 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 544 */         this.logoutTime = FValue.trim();
/*     */       }
/*     */       else
/* 547 */         this.logoutTime = null;
/*     */     }
/* 549 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 554 */     if (otherObject == null) return false;
/* 555 */     if (this == otherObject) return true;
/* 556 */     if (getClass() != otherObject.getClass()) return false;
/* 557 */     MWebLoginLogSchema other = (MWebLoginLogSchema)otherObject;
/* 558 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 559 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 560 */     if ((this.sessionId == null) && (other.getSessionId() != null)) return false;
/* 561 */     if ((this.sessionId != null) && (!this.sessionId.equals(other.getSessionId()))) return false;
/* 562 */     if ((this.userCode == null) && (other.getUserCode() != null)) return false;
/* 563 */     if ((this.userCode != null) && (!this.userCode.equals(other.getUserCode()))) return false;
/* 564 */     if ((this.userType == null) && (other.getUserType() != null)) return false;
/* 565 */     if ((this.userType != null) && (!this.userType.equals(other.getUserType()))) return false;
/* 566 */     if ((this.clientName == null) && (other.getClientName() != null)) return false;
/* 567 */     if ((this.clientName != null) && (!this.clientName.equals(other.getClientName()))) return false;
/* 568 */     if ((this.clientType == null) && (other.getClientType() != null)) return false;
/* 569 */     if ((this.clientType != null) && (!this.clientType.equals(other.getClientType()))) return false;
/* 570 */     if ((this.clientIP == null) && (other.getClientIP() != null)) return false;
/* 571 */     if ((this.clientIP != null) && (!this.clientIP.equals(other.getClientIP()))) return false;
/* 572 */     if ((this.loginDate == null) && (other.getLoginDate() != null)) return false;
/* 573 */     if ((this.loginDate != null) && (!this.fDate.getString(this.loginDate).equals(other.getLoginDate()))) return false;
/* 574 */     if ((this.loginTime == null) && (other.getLoginTime() != null)) return false;
/* 575 */     if ((this.loginTime != null) && (!this.loginTime.equals(other.getLoginTime()))) return false;
/* 576 */     if ((this.logoutDate == null) && (other.getLogoutDate() != null)) return false;
/* 577 */     if ((this.logoutDate != null) && (!this.fDate.getString(this.logoutDate).equals(other.getLogoutDate()))) return false;
/* 578 */     if ((this.logoutTime == null) && (other.getLogoutTime() != null)) return false;
/* 579 */     return (this.logoutTime == null) || (this.logoutTime.equals(other.getLogoutTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 586 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 592 */     if (strFieldName.equals("iD")) {
/* 593 */       return 0;
/*     */     }
/* 595 */     if (strFieldName.equals("sessionId")) {
/* 596 */       return 1;
/*     */     }
/* 598 */     if (strFieldName.equals("userCode")) {
/* 599 */       return 2;
/*     */     }
/* 601 */     if (strFieldName.equals("userType")) {
/* 602 */       return 3;
/*     */     }
/* 604 */     if (strFieldName.equals("clientName")) {
/* 605 */       return 4;
/*     */     }
/* 607 */     if (strFieldName.equals("clientType")) {
/* 608 */       return 5;
/*     */     }
/* 610 */     if (strFieldName.equals("clientIP")) {
/* 611 */       return 6;
/*     */     }
/* 613 */     if (strFieldName.equals("loginDate")) {
/* 614 */       return 7;
/*     */     }
/* 616 */     if (strFieldName.equals("loginTime")) {
/* 617 */       return 8;
/*     */     }
/* 619 */     if (strFieldName.equals("logoutDate")) {
/* 620 */       return 9;
/*     */     }
/* 622 */     if (strFieldName.equals("logoutTime")) {
/* 623 */       return 10;
/*     */     }
/* 625 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 631 */     String strFieldName = "";
/* 632 */     switch (nFieldIndex) {
/*     */     case 0:
/* 634 */       strFieldName = "iD";
/* 635 */       break;
/*     */     case 1:
/* 637 */       strFieldName = "sessionId";
/* 638 */       break;
/*     */     case 2:
/* 640 */       strFieldName = "userCode";
/* 641 */       break;
/*     */     case 3:
/* 643 */       strFieldName = "userType";
/* 644 */       break;
/*     */     case 4:
/* 646 */       strFieldName = "clientName";
/* 647 */       break;
/*     */     case 5:
/* 649 */       strFieldName = "clientType";
/* 650 */       break;
/*     */     case 6:
/* 652 */       strFieldName = "clientIP";
/* 653 */       break;
/*     */     case 7:
/* 655 */       strFieldName = "loginDate";
/* 656 */       break;
/*     */     case 8:
/* 658 */       strFieldName = "loginTime";
/* 659 */       break;
/*     */     case 9:
/* 661 */       strFieldName = "logoutDate";
/* 662 */       break;
/*     */     case 10:
/* 664 */       strFieldName = "logoutTime";
/* 665 */       break;
/*     */     default:
/* 667 */       strFieldName = "";
/*     */     }
/* 669 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 675 */     if (strFieldName.equals("iD")) {
/* 676 */       return 0;
/*     */     }
/* 678 */     if (strFieldName.equals("sessionId")) {
/* 679 */       return 0;
/*     */     }
/* 681 */     if (strFieldName.equals("userCode")) {
/* 682 */       return 0;
/*     */     }
/* 684 */     if (strFieldName.equals("userType")) {
/* 685 */       return 0;
/*     */     }
/* 687 */     if (strFieldName.equals("clientName")) {
/* 688 */       return 0;
/*     */     }
/* 690 */     if (strFieldName.equals("clientType")) {
/* 691 */       return 0;
/*     */     }
/* 693 */     if (strFieldName.equals("clientIP")) {
/* 694 */       return 0;
/*     */     }
/* 696 */     if (strFieldName.equals("loginDate")) {
/* 697 */       return 1;
/*     */     }
/* 699 */     if (strFieldName.equals("loginTime")) {
/* 700 */       return 0;
/*     */     }
/* 702 */     if (strFieldName.equals("logoutDate")) {
/* 703 */       return 1;
/*     */     }
/* 705 */     if (strFieldName.equals("logoutTime")) {
/* 706 */       return 0;
/*     */     }
/* 708 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 714 */     int nFieldType = -1;
/* 715 */     switch (nFieldIndex) {
/*     */     case 0:
/* 717 */       nFieldType = 0;
/* 718 */       break;
/*     */     case 1:
/* 720 */       nFieldType = 0;
/* 721 */       break;
/*     */     case 2:
/* 723 */       nFieldType = 0;
/* 724 */       break;
/*     */     case 3:
/* 726 */       nFieldType = 0;
/* 727 */       break;
/*     */     case 4:
/* 729 */       nFieldType = 0;
/* 730 */       break;
/*     */     case 5:
/* 732 */       nFieldType = 0;
/* 733 */       break;
/*     */     case 6:
/* 735 */       nFieldType = 0;
/* 736 */       break;
/*     */     case 7:
/* 738 */       nFieldType = 1;
/* 739 */       break;
/*     */     case 8:
/* 741 */       nFieldType = 0;
/* 742 */       break;
/*     */     case 9:
/* 744 */       nFieldType = 1;
/* 745 */       break;
/*     */     case 10:
/* 747 */       nFieldType = 0;
/* 748 */       break;
/*     */     default:
/* 750 */       nFieldType = -1;
/*     */     }
/* 752 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MWebLoginLogSchema
 * JD-Core Version:    0.6.0
 */