/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCheckFieldDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPCheckFieldSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String riskVer;
/*     */   private String fieldName;
/*     */   private String serialNo;
/*     */   private String calCode;
/*     */   private String pageLocation;
/*     */   private String location;
/*     */   private String msg;
/*     */   private String msgFlag;
/*     */   private String updFlag;
/*     */   private String valiFlag;
/*     */   private String returnValiFlag;
/*     */   public static final int FIELDNUM = 12;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPCheckFieldSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[4];
/*  59 */     pk[0] = "RiskCode";
/*  60 */     pk[1] = "RiskVer";
/*  61 */     pk[2] = "FieldName";
/*  62 */     pk[3] = "SerialNo";
/*     */ 
/*  64 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  71 */     LNPCheckFieldSchema cloned = (LNPCheckFieldSchema)super.clone();
/*  72 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  73 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  79 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/*  84 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  88 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskVer() {
/*  92 */     return this.riskVer;
/*     */   }
/*     */ 
/*     */   public void setRiskVer(String aRiskVer) {
/*  96 */     this.riskVer = aRiskVer;
/*     */   }
/*     */ 
/*     */   public String getFieldName() {
/* 100 */     return this.fieldName;
/*     */   }
/*     */ 
/*     */   public void setFieldName(String aFieldName) {
/* 104 */     this.fieldName = aFieldName;
/*     */   }
/*     */ 
/*     */   public String getSerialNo() {
/* 108 */     return this.serialNo;
/*     */   }
/*     */ 
/*     */   public void setSerialNo(String aSerialNo) {
/* 112 */     this.serialNo = aSerialNo;
/*     */   }
/*     */ 
/*     */   public String getCalCode() {
/* 116 */     return this.calCode;
/*     */   }
/*     */ 
/*     */   public void setCalCode(String aCalCode) {
/* 120 */     this.calCode = aCalCode;
/*     */   }
/*     */ 
/*     */   public String getPageLocation() {
/* 124 */     return this.pageLocation;
/*     */   }
/*     */ 
/*     */   public void setPageLocation(String aPageLocation) {
/* 128 */     this.pageLocation = aPageLocation;
/*     */   }
/*     */ 
/*     */   public String getLocation() {
/* 132 */     return this.location;
/*     */   }
/*     */ 
/*     */   public void setLocation(String aLocation) {
/* 136 */     this.location = aLocation;
/*     */   }
/*     */ 
/*     */   public String getMsg() {
/* 140 */     return this.msg;
/*     */   }
/*     */ 
/*     */   public void setMsg(String aMsg) {
/* 144 */     this.msg = aMsg;
/*     */   }
/*     */ 
/*     */   public String getMsgFlag() {
/* 148 */     return this.msgFlag;
/*     */   }
/*     */ 
/*     */   public void setMsgFlag(String aMsgFlag) {
/* 152 */     this.msgFlag = aMsgFlag;
/*     */   }
/*     */ 
/*     */   public String getUpdFlag() {
/* 156 */     return this.updFlag;
/*     */   }
/*     */ 
/*     */   public void setUpdFlag(String aUpdFlag) {
/* 160 */     this.updFlag = aUpdFlag;
/*     */   }
/*     */ 
/*     */   public String getValiFlag() {
/* 164 */     return this.valiFlag;
/*     */   }
/*     */ 
/*     */   public void setValiFlag(String aValiFlag) {
/* 168 */     this.valiFlag = aValiFlag;
/*     */   }
/*     */ 
/*     */   public String getReturnValiFlag() {
/* 172 */     return this.returnValiFlag;
/*     */   }
/*     */ 
/*     */   public void setReturnValiFlag(String aReturnValiFlag) {
/* 176 */     this.returnValiFlag = aReturnValiFlag;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPCheckFieldSchema aLNPCheckFieldSchema)
/*     */   {
/* 182 */     this.riskCode = aLNPCheckFieldSchema.getRiskCode();
/* 183 */     this.riskVer = aLNPCheckFieldSchema.getRiskVer();
/* 184 */     this.fieldName = aLNPCheckFieldSchema.getFieldName();
/* 185 */     this.serialNo = aLNPCheckFieldSchema.getSerialNo();
/* 186 */     this.calCode = aLNPCheckFieldSchema.getCalCode();
/* 187 */     this.pageLocation = aLNPCheckFieldSchema.getPageLocation();
/* 188 */     this.location = aLNPCheckFieldSchema.getLocation();
/* 189 */     this.msg = aLNPCheckFieldSchema.getMsg();
/* 190 */     this.msgFlag = aLNPCheckFieldSchema.getMsgFlag();
/* 191 */     this.updFlag = aLNPCheckFieldSchema.getUpdFlag();
/* 192 */     this.valiFlag = aLNPCheckFieldSchema.getValiFlag();
/* 193 */     this.returnValiFlag = aLNPCheckFieldSchema.getReturnValiFlag();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 202 */       if (rs.getString("RiskCode") == null)
/* 203 */         this.riskCode = null;
/*     */       else {
/* 205 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 207 */       if (rs.getString("RiskVer") == null)
/* 208 */         this.riskVer = null;
/*     */       else {
/* 210 */         this.riskVer = rs.getString("RiskVer").trim();
/*     */       }
/* 212 */       if (rs.getString("FieldName") == null)
/* 213 */         this.fieldName = null;
/*     */       else {
/* 215 */         this.fieldName = rs.getString("FieldName").trim();
/*     */       }
/* 217 */       if (rs.getString("SerialNo") == null)
/* 218 */         this.serialNo = null;
/*     */       else {
/* 220 */         this.serialNo = rs.getString("SerialNo").trim();
/*     */       }
/* 222 */       if (rs.getString("CalCode") == null)
/* 223 */         this.calCode = null;
/*     */       else {
/* 225 */         this.calCode = rs.getString("CalCode").trim();
/*     */       }
/* 227 */       if (rs.getString("PageLocation") == null)
/* 228 */         this.pageLocation = null;
/*     */       else {
/* 230 */         this.pageLocation = rs.getString("PageLocation").trim();
/*     */       }
/* 232 */       if (rs.getString("Location") == null)
/* 233 */         this.location = null;
/*     */       else {
/* 235 */         this.location = rs.getString("Location").trim();
/*     */       }
/* 237 */       if (rs.getString("Msg") == null)
/* 238 */         this.msg = null;
/*     */       else {
/* 240 */         this.msg = rs.getString("Msg").trim();
/*     */       }
/* 242 */       if (rs.getString("MsgFlag") == null)
/* 243 */         this.msgFlag = null;
/*     */       else {
/* 245 */         this.msgFlag = rs.getString("MsgFlag").trim();
/*     */       }
/* 247 */       if (rs.getString("UpdFlag") == null)
/* 248 */         this.updFlag = null;
/*     */       else {
/* 250 */         this.updFlag = rs.getString("UpdFlag").trim();
/*     */       }
/* 252 */       if (rs.getString("ValiFlag") == null)
/* 253 */         this.valiFlag = null;
/*     */       else {
/* 255 */         this.valiFlag = rs.getString("ValiFlag").trim();
/*     */       }
/* 257 */       if (rs.getString("ReturnValiFlag") == null)
/* 258 */         this.returnValiFlag = null;
/*     */       else {
/* 260 */         this.returnValiFlag = rs.getString("ReturnValiFlag").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 265 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCheckField\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 267 */       CError tError = new CError();
/* 268 */       tError.moduleName = "LNPCheckFieldSchema";
/* 269 */       tError.functionName = "setSchema";
/* 270 */       tError.errorMessage = sqle.toString();
/* 271 */       this.mErrors.addOneError(tError);
/* 272 */       return false;
/*     */     }
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCheckFieldSchema getSchema()
/*     */   {
/* 279 */     LNPCheckFieldSchema aLNPCheckFieldSchema = new LNPCheckFieldSchema();
/* 280 */     aLNPCheckFieldSchema.setSchema(this);
/* 281 */     return aLNPCheckFieldSchema;
/*     */   }
/*     */ 
/*     */   public LNPCheckFieldDB getDB()
/*     */   {
/* 286 */     LNPCheckFieldDB aDBOper = new LNPCheckFieldDB();
/* 287 */     aDBOper.setSchema(this);
/* 288 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 295 */     StringBuffer strReturn = new StringBuffer(256);
/* 296 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 297 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/* 298 */     strReturn.append(StrTool.cTrim(this.fieldName)); strReturn.append("|");
/* 299 */     strReturn.append(StrTool.cTrim(this.serialNo)); strReturn.append("|");
/* 300 */     strReturn.append(StrTool.cTrim(this.calCode)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.pageLocation)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.location)); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.msg)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.msgFlag)); strReturn.append("|");
/* 305 */     strReturn.append(StrTool.cTrim(this.updFlag)); strReturn.append("|");
/* 306 */     strReturn.append(StrTool.cTrim(this.valiFlag)); strReturn.append("|");
/* 307 */     strReturn.append(StrTool.cTrim(this.returnValiFlag));
/* 308 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 316 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 317 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 318 */       this.fieldName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 319 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 320 */       this.calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 321 */       this.pageLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 322 */       this.location = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 323 */       this.msg = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 324 */       this.msgFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 325 */       this.updFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 326 */       this.valiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 327 */       this.returnValiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 332 */       CError tError = new CError();
/* 333 */       tError.moduleName = "LNPCheckFieldSchema";
/* 334 */       tError.functionName = "decode";
/* 335 */       tError.errorMessage = ex.toString();
/* 336 */       this.mErrors.addOneError(tError);
/*     */ 
/* 338 */       return false;
/*     */     }
/* 340 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 346 */     String strReturn = "";
/* 347 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 349 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 351 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 353 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*     */     }
/* 355 */     if (FCode.equalsIgnoreCase("fieldName"))
/*     */     {
/* 357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fieldName));
/*     */     }
/* 359 */     if (FCode.equalsIgnoreCase("serialNo"))
/*     */     {
/* 361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*     */     }
/* 363 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calCode));
/*     */     }
/* 367 */     if (FCode.equalsIgnoreCase("pageLocation"))
/*     */     {
/* 369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pageLocation));
/*     */     }
/* 371 */     if (FCode.equalsIgnoreCase("location"))
/*     */     {
/* 373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.location));
/*     */     }
/* 375 */     if (FCode.equalsIgnoreCase("msg"))
/*     */     {
/* 377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.msg));
/*     */     }
/* 379 */     if (FCode.equalsIgnoreCase("msgFlag"))
/*     */     {
/* 381 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.msgFlag));
/*     */     }
/* 383 */     if (FCode.equalsIgnoreCase("updFlag"))
/*     */     {
/* 385 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.updFlag));
/*     */     }
/* 387 */     if (FCode.equalsIgnoreCase("valiFlag"))
/*     */     {
/* 389 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.valiFlag));
/*     */     }
/* 391 */     if (FCode.equalsIgnoreCase("returnValiFlag"))
/*     */     {
/* 393 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.returnValiFlag));
/*     */     }
/* 395 */     if (strReturn.equals(""))
/*     */     {
/* 397 */       strReturn = "null";
/*     */     }
/*     */ 
/* 400 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 407 */     String strFieldValue = "";
/* 408 */     switch (nFieldIndex) {
/*     */     case 0:
/* 410 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 411 */       break;
/*     */     case 1:
/* 413 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/* 414 */       break;
/*     */     case 2:
/* 416 */       strFieldValue = StrTool.GBKToUnicode(this.fieldName);
/* 417 */       break;
/*     */     case 3:
/* 419 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 420 */       break;
/*     */     case 4:
/* 422 */       strFieldValue = StrTool.GBKToUnicode(this.calCode);
/* 423 */       break;
/*     */     case 5:
/* 425 */       strFieldValue = StrTool.GBKToUnicode(this.pageLocation);
/* 426 */       break;
/*     */     case 6:
/* 428 */       strFieldValue = StrTool.GBKToUnicode(this.location);
/* 429 */       break;
/*     */     case 7:
/* 431 */       strFieldValue = StrTool.GBKToUnicode(this.msg);
/* 432 */       break;
/*     */     case 8:
/* 434 */       strFieldValue = StrTool.GBKToUnicode(this.msgFlag);
/* 435 */       break;
/*     */     case 9:
/* 437 */       strFieldValue = StrTool.GBKToUnicode(this.updFlag);
/* 438 */       break;
/*     */     case 10:
/* 440 */       strFieldValue = StrTool.GBKToUnicode(this.valiFlag);
/* 441 */       break;
/*     */     case 11:
/* 443 */       strFieldValue = StrTool.GBKToUnicode(this.returnValiFlag);
/* 444 */       break;
/*     */     default:
/* 446 */       strFieldValue = "";
/*     */     }
/* 448 */     if (strFieldValue.equals("")) {
/* 449 */       strFieldValue = "null";
/*     */     }
/* 451 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 457 */     if (StrTool.cTrim(FCode).equals("")) {
/* 458 */       return false;
/*     */     }
/* 460 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 462 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 464 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 467 */         this.riskCode = null;
/*     */     }
/* 469 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 471 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 473 */         this.riskVer = FValue.trim();
/*     */       }
/*     */       else
/* 476 */         this.riskVer = null;
/*     */     }
/* 478 */     if (FCode.equalsIgnoreCase("fieldName"))
/*     */     {
/* 480 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 482 */         this.fieldName = FValue.trim();
/*     */       }
/*     */       else
/* 485 */         this.fieldName = null;
/*     */     }
/* 487 */     if (FCode.equalsIgnoreCase("serialNo"))
/*     */     {
/* 489 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 491 */         this.serialNo = FValue.trim();
/*     */       }
/*     */       else
/* 494 */         this.serialNo = null;
/*     */     }
/* 496 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 498 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 500 */         this.calCode = FValue.trim();
/*     */       }
/*     */       else
/* 503 */         this.calCode = null;
/*     */     }
/* 505 */     if (FCode.equalsIgnoreCase("pageLocation"))
/*     */     {
/* 507 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 509 */         this.pageLocation = FValue.trim();
/*     */       }
/*     */       else
/* 512 */         this.pageLocation = null;
/*     */     }
/* 514 */     if (FCode.equalsIgnoreCase("location"))
/*     */     {
/* 516 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 518 */         this.location = FValue.trim();
/*     */       }
/*     */       else
/* 521 */         this.location = null;
/*     */     }
/* 523 */     if (FCode.equalsIgnoreCase("msg"))
/*     */     {
/* 525 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 527 */         this.msg = FValue.trim();
/*     */       }
/*     */       else
/* 530 */         this.msg = null;
/*     */     }
/* 532 */     if (FCode.equalsIgnoreCase("msgFlag"))
/*     */     {
/* 534 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 536 */         this.msgFlag = FValue.trim();
/*     */       }
/*     */       else
/* 539 */         this.msgFlag = null;
/*     */     }
/* 541 */     if (FCode.equalsIgnoreCase("updFlag"))
/*     */     {
/* 543 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 545 */         this.updFlag = FValue.trim();
/*     */       }
/*     */       else
/* 548 */         this.updFlag = null;
/*     */     }
/* 550 */     if (FCode.equalsIgnoreCase("valiFlag"))
/*     */     {
/* 552 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 554 */         this.valiFlag = FValue.trim();
/*     */       }
/*     */       else
/* 557 */         this.valiFlag = null;
/*     */     }
/* 559 */     if (FCode.equalsIgnoreCase("returnValiFlag"))
/*     */     {
/* 561 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 563 */         this.returnValiFlag = FValue.trim();
/*     */       }
/*     */       else
/* 566 */         this.returnValiFlag = null;
/*     */     }
/* 568 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 573 */     if (otherObject == null) return false;
/* 574 */     if (this == otherObject) return true;
/* 575 */     if (getClass() != otherObject.getClass()) return false;
/* 576 */     LNPCheckFieldSchema other = (LNPCheckFieldSchema)otherObject;
/* 577 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 578 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 579 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/* 580 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/* 581 */     if ((this.fieldName == null) && (other.getFieldName() != null)) return false;
/* 582 */     if ((this.fieldName != null) && (!this.fieldName.equals(other.getFieldName()))) return false;
/* 583 */     if ((this.serialNo == null) && (other.getSerialNo() != null)) return false;
/* 584 */     if ((this.serialNo != null) && (!this.serialNo.equals(other.getSerialNo()))) return false;
/* 585 */     if ((this.calCode == null) && (other.getCalCode() != null)) return false;
/* 586 */     if ((this.calCode != null) && (!this.calCode.equals(other.getCalCode()))) return false;
/* 587 */     if ((this.pageLocation == null) && (other.getPageLocation() != null)) return false;
/* 588 */     if ((this.pageLocation != null) && (!this.pageLocation.equals(other.getPageLocation()))) return false;
/* 589 */     if ((this.location == null) && (other.getLocation() != null)) return false;
/* 590 */     if ((this.location != null) && (!this.location.equals(other.getLocation()))) return false;
/* 591 */     if ((this.msg == null) && (other.getMsg() != null)) return false;
/* 592 */     if ((this.msg != null) && (!this.msg.equals(other.getMsg()))) return false;
/* 593 */     if ((this.msgFlag == null) && (other.getMsgFlag() != null)) return false;
/* 594 */     if ((this.msgFlag != null) && (!this.msgFlag.equals(other.getMsgFlag()))) return false;
/* 595 */     if ((this.updFlag == null) && (other.getUpdFlag() != null)) return false;
/* 596 */     if ((this.updFlag != null) && (!this.updFlag.equals(other.getUpdFlag()))) return false;
/* 597 */     if ((this.valiFlag == null) && (other.getValiFlag() != null)) return false;
/* 598 */     if ((this.valiFlag != null) && (!this.valiFlag.equals(other.getValiFlag()))) return false;
/* 599 */     if ((this.returnValiFlag == null) && (other.getReturnValiFlag() != null)) return false;
/* 600 */     return (this.returnValiFlag == null) || (this.returnValiFlag.equals(other.getReturnValiFlag()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 607 */     return 12;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 613 */     if (strFieldName.equals("riskCode")) {
/* 614 */       return 0;
/*     */     }
/* 616 */     if (strFieldName.equals("riskVer")) {
/* 617 */       return 1;
/*     */     }
/* 619 */     if (strFieldName.equals("fieldName")) {
/* 620 */       return 2;
/*     */     }
/* 622 */     if (strFieldName.equals("serialNo")) {
/* 623 */       return 3;
/*     */     }
/* 625 */     if (strFieldName.equals("calCode")) {
/* 626 */       return 4;
/*     */     }
/* 628 */     if (strFieldName.equals("pageLocation")) {
/* 629 */       return 5;
/*     */     }
/* 631 */     if (strFieldName.equals("location")) {
/* 632 */       return 6;
/*     */     }
/* 634 */     if (strFieldName.equals("msg")) {
/* 635 */       return 7;
/*     */     }
/* 637 */     if (strFieldName.equals("msgFlag")) {
/* 638 */       return 8;
/*     */     }
/* 640 */     if (strFieldName.equals("updFlag")) {
/* 641 */       return 9;
/*     */     }
/* 643 */     if (strFieldName.equals("valiFlag")) {
/* 644 */       return 10;
/*     */     }
/* 646 */     if (strFieldName.equals("returnValiFlag")) {
/* 647 */       return 11;
/*     */     }
/* 649 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 655 */     String strFieldName = "";
/* 656 */     switch (nFieldIndex) {
/*     */     case 0:
/* 658 */       strFieldName = "riskCode";
/* 659 */       break;
/*     */     case 1:
/* 661 */       strFieldName = "riskVer";
/* 662 */       break;
/*     */     case 2:
/* 664 */       strFieldName = "fieldName";
/* 665 */       break;
/*     */     case 3:
/* 667 */       strFieldName = "serialNo";
/* 668 */       break;
/*     */     case 4:
/* 670 */       strFieldName = "calCode";
/* 671 */       break;
/*     */     case 5:
/* 673 */       strFieldName = "pageLocation";
/* 674 */       break;
/*     */     case 6:
/* 676 */       strFieldName = "location";
/* 677 */       break;
/*     */     case 7:
/* 679 */       strFieldName = "msg";
/* 680 */       break;
/*     */     case 8:
/* 682 */       strFieldName = "msgFlag";
/* 683 */       break;
/*     */     case 9:
/* 685 */       strFieldName = "updFlag";
/* 686 */       break;
/*     */     case 10:
/* 688 */       strFieldName = "valiFlag";
/* 689 */       break;
/*     */     case 11:
/* 691 */       strFieldName = "returnValiFlag";
/* 692 */       break;
/*     */     default:
/* 694 */       strFieldName = "";
/*     */     }
/* 696 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 702 */     if (strFieldName.equals("riskCode")) {
/* 703 */       return 0;
/*     */     }
/* 705 */     if (strFieldName.equals("riskVer")) {
/* 706 */       return 0;
/*     */     }
/* 708 */     if (strFieldName.equals("fieldName")) {
/* 709 */       return 0;
/*     */     }
/* 711 */     if (strFieldName.equals("serialNo")) {
/* 712 */       return 0;
/*     */     }
/* 714 */     if (strFieldName.equals("calCode")) {
/* 715 */       return 0;
/*     */     }
/* 717 */     if (strFieldName.equals("pageLocation")) {
/* 718 */       return 0;
/*     */     }
/* 720 */     if (strFieldName.equals("location")) {
/* 721 */       return 0;
/*     */     }
/* 723 */     if (strFieldName.equals("msg")) {
/* 724 */       return 0;
/*     */     }
/* 726 */     if (strFieldName.equals("msgFlag")) {
/* 727 */       return 0;
/*     */     }
/* 729 */     if (strFieldName.equals("updFlag")) {
/* 730 */       return 0;
/*     */     }
/* 732 */     if (strFieldName.equals("valiFlag")) {
/* 733 */       return 0;
/*     */     }
/* 735 */     if (strFieldName.equals("returnValiFlag")) {
/* 736 */       return 0;
/*     */     }
/* 738 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 744 */     int nFieldType = -1;
/* 745 */     switch (nFieldIndex) {
/*     */     case 0:
/* 747 */       nFieldType = 0;
/* 748 */       break;
/*     */     case 1:
/* 750 */       nFieldType = 0;
/* 751 */       break;
/*     */     case 2:
/* 753 */       nFieldType = 0;
/* 754 */       break;
/*     */     case 3:
/* 756 */       nFieldType = 0;
/* 757 */       break;
/*     */     case 4:
/* 759 */       nFieldType = 0;
/* 760 */       break;
/*     */     case 5:
/* 762 */       nFieldType = 0;
/* 763 */       break;
/*     */     case 6:
/* 765 */       nFieldType = 0;
/* 766 */       break;
/*     */     case 7:
/* 768 */       nFieldType = 0;
/* 769 */       break;
/*     */     case 8:
/* 771 */       nFieldType = 0;
/* 772 */       break;
/*     */     case 9:
/* 774 */       nFieldType = 0;
/* 775 */       break;
/*     */     case 10:
/* 777 */       nFieldType = 0;
/* 778 */       break;
/*     */     case 11:
/* 780 */       nFieldType = 0;
/* 781 */       break;
/*     */     default:
/* 783 */       nFieldType = -1;
/*     */     }
/* 785 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema
 * JD-Core Version:    0.6.0
 */