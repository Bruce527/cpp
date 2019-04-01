/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskScreenValidateDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskScreenValidateSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String controlId;
/*     */   private String riskCode;
/*     */   private String controlCode;
/*     */   private String controlValue;
/*     */   private String functionType;
/*     */   private String relaDivCode;
/*     */   private String relaDivShow;
/*     */   private String relaControlCode;
/*     */   private String relaControlType;
/*     */   private String relaValueSql;
/*     */   private String calCode;
/*     */   private String noti;
/*     */   public static final int FIELDNUM = 12;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskScreenValidateSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[1];
/*  59 */     pk[0] = "ControlId";
/*     */ 
/*  61 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  68 */     LNPRiskScreenValidateSchema cloned = (LNPRiskScreenValidateSchema)super.clone();
/*  69 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  70 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  76 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getControlId()
/*     */   {
/*  81 */     return this.controlId;
/*     */   }
/*     */ 
/*     */   public void setControlId(String aControlId) {
/*  85 */     this.controlId = aControlId;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/*  89 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  93 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getControlCode() {
/*  97 */     return this.controlCode;
/*     */   }
/*     */ 
/*     */   public void setControlCode(String aControlCode) {
/* 101 */     this.controlCode = aControlCode;
/*     */   }
/*     */ 
/*     */   public String getControlValue() {
/* 105 */     return this.controlValue;
/*     */   }
/*     */ 
/*     */   public void setControlValue(String aControlValue) {
/* 109 */     this.controlValue = aControlValue;
/*     */   }
/*     */ 
/*     */   public String getFunctionType() {
/* 113 */     return this.functionType;
/*     */   }
/*     */ 
/*     */   public void setFunctionType(String aFunctionType) {
/* 117 */     this.functionType = aFunctionType;
/*     */   }
/*     */ 
/*     */   public String getRelaDivCode() {
/* 121 */     return this.relaDivCode;
/*     */   }
/*     */ 
/*     */   public void setRelaDivCode(String aRelaDivCode) {
/* 125 */     this.relaDivCode = aRelaDivCode;
/*     */   }
/*     */ 
/*     */   public String getRelaDivShow() {
/* 129 */     return this.relaDivShow;
/*     */   }
/*     */ 
/*     */   public void setRelaDivShow(String aRelaDivShow) {
/* 133 */     this.relaDivShow = aRelaDivShow;
/*     */   }
/*     */ 
/*     */   public String getRelaControlCode() {
/* 137 */     return this.relaControlCode;
/*     */   }
/*     */ 
/*     */   public void setRelaControlCode(String aRelaControlCode) {
/* 141 */     this.relaControlCode = aRelaControlCode;
/*     */   }
/*     */ 
/*     */   public String getRelaControlType() {
/* 145 */     return this.relaControlType;
/*     */   }
/*     */ 
/*     */   public void setRelaControlType(String aRelaControlType) {
/* 149 */     this.relaControlType = aRelaControlType;
/*     */   }
/*     */ 
/*     */   public String getRelaValueSql() {
/* 153 */     return this.relaValueSql;
/*     */   }
/*     */ 
/*     */   public void setRelaValueSql(String aRelaValueSql) {
/* 157 */     this.relaValueSql = aRelaValueSql;
/*     */   }
/*     */ 
/*     */   public String getCalCode() {
/* 161 */     return this.calCode;
/*     */   }
/*     */ 
/*     */   public void setCalCode(String aCalCode) {
/* 165 */     this.calCode = aCalCode;
/*     */   }
/*     */ 
/*     */   public String getNoti() {
/* 169 */     return this.noti;
/*     */   }
/*     */ 
/*     */   public void setNoti(String aNoti) {
/* 173 */     this.noti = aNoti;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskScreenValidateSchema aLNPRiskScreenValidateSchema)
/*     */   {
/* 179 */     this.controlId = aLNPRiskScreenValidateSchema.getControlId();
/* 180 */     this.riskCode = aLNPRiskScreenValidateSchema.getRiskCode();
/* 181 */     this.controlCode = aLNPRiskScreenValidateSchema.getControlCode();
/* 182 */     this.controlValue = aLNPRiskScreenValidateSchema.getControlValue();
/* 183 */     this.functionType = aLNPRiskScreenValidateSchema.getFunctionType();
/* 184 */     this.relaDivCode = aLNPRiskScreenValidateSchema.getRelaDivCode();
/* 185 */     this.relaDivShow = aLNPRiskScreenValidateSchema.getRelaDivShow();
/* 186 */     this.relaControlCode = aLNPRiskScreenValidateSchema.getRelaControlCode();
/* 187 */     this.relaControlType = aLNPRiskScreenValidateSchema.getRelaControlType();
/* 188 */     this.relaValueSql = aLNPRiskScreenValidateSchema.getRelaValueSql();
/* 189 */     this.calCode = aLNPRiskScreenValidateSchema.getCalCode();
/* 190 */     this.noti = aLNPRiskScreenValidateSchema.getNoti();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 199 */       if (rs.getString("ControlId") == null)
/* 200 */         this.controlId = null;
/*     */       else {
/* 202 */         this.controlId = rs.getString("ControlId").trim();
/*     */       }
/* 204 */       if (rs.getString("RiskCode") == null)
/* 205 */         this.riskCode = null;
/*     */       else {
/* 207 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 209 */       if (rs.getString("ControlCode") == null)
/* 210 */         this.controlCode = null;
/*     */       else {
/* 212 */         this.controlCode = rs.getString("ControlCode").trim();
/*     */       }
/* 214 */       if (rs.getString("ControlValue") == null)
/* 215 */         this.controlValue = null;
/*     */       else {
/* 217 */         this.controlValue = rs.getString("ControlValue").trim();
/*     */       }
/* 219 */       if (rs.getString("FunctionType") == null)
/* 220 */         this.functionType = null;
/*     */       else {
/* 222 */         this.functionType = rs.getString("FunctionType").trim();
/*     */       }
/* 224 */       if (rs.getString("RelaDivCode") == null)
/* 225 */         this.relaDivCode = null;
/*     */       else {
/* 227 */         this.relaDivCode = rs.getString("RelaDivCode").trim();
/*     */       }
/* 229 */       if (rs.getString("RelaDivShow") == null)
/* 230 */         this.relaDivShow = null;
/*     */       else {
/* 232 */         this.relaDivShow = rs.getString("RelaDivShow").trim();
/*     */       }
/* 234 */       if (rs.getString("RelaControlCode") == null)
/* 235 */         this.relaControlCode = null;
/*     */       else {
/* 237 */         this.relaControlCode = rs.getString("RelaControlCode").trim();
/*     */       }
/* 239 */       if (rs.getString("RelaControlType") == null)
/* 240 */         this.relaControlType = null;
/*     */       else {
/* 242 */         this.relaControlType = rs.getString("RelaControlType").trim();
/*     */       }
/* 244 */       if (rs.getString("RelaValueSql") == null)
/* 245 */         this.relaValueSql = null;
/*     */       else {
/* 247 */         this.relaValueSql = rs.getString("RelaValueSql").trim();
/*     */       }
/* 249 */       if (rs.getString("CalCode") == null)
/* 250 */         this.calCode = null;
/*     */       else {
/* 252 */         this.calCode = rs.getString("CalCode").trim();
/*     */       }
/* 254 */       if (rs.getString("Noti") == null)
/* 255 */         this.noti = null;
/*     */       else {
/* 257 */         this.noti = rs.getString("Noti").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 262 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskScreenValidate\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 264 */       CError tError = new CError();
/* 265 */       tError.moduleName = "LNPRiskScreenValidateSchema";
/* 266 */       tError.functionName = "setSchema";
/* 267 */       tError.errorMessage = sqle.toString();
/* 268 */       this.mErrors.addOneError(tError);
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskScreenValidateSchema getSchema()
/*     */   {
/* 276 */     LNPRiskScreenValidateSchema aLNPRiskScreenValidateSchema = new LNPRiskScreenValidateSchema();
/* 277 */     aLNPRiskScreenValidateSchema.setSchema(this);
/* 278 */     return aLNPRiskScreenValidateSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskScreenValidateDB getDB()
/*     */   {
/* 283 */     LNPRiskScreenValidateDB aDBOper = new LNPRiskScreenValidateDB();
/* 284 */     aDBOper.setSchema(this);
/* 285 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 292 */     StringBuffer strReturn = new StringBuffer(256);
/* 293 */     strReturn.append(StrTool.cTrim(this.controlId)); strReturn.append("|");
/* 294 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 295 */     strReturn.append(StrTool.cTrim(this.controlCode)); strReturn.append("|");
/* 296 */     strReturn.append(StrTool.cTrim(this.controlValue)); strReturn.append("|");
/* 297 */     strReturn.append(StrTool.cTrim(this.functionType)); strReturn.append("|");
/* 298 */     strReturn.append(StrTool.cTrim(this.relaDivCode)); strReturn.append("|");
/* 299 */     strReturn.append(StrTool.cTrim(this.relaDivShow)); strReturn.append("|");
/* 300 */     strReturn.append(StrTool.cTrim(this.relaControlCode)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.relaControlType)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.relaValueSql)); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.calCode)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.noti));
/* 305 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 313 */       this.controlId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 314 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 315 */       this.controlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 316 */       this.controlValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 317 */       this.functionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 318 */       this.relaDivCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 319 */       this.relaDivShow = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 320 */       this.relaControlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 321 */       this.relaControlType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 322 */       this.relaValueSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 323 */       this.calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 324 */       this.noti = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 329 */       CError tError = new CError();
/* 330 */       tError.moduleName = "LNPRiskScreenValidateSchema";
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
/* 344 */     if (FCode.equalsIgnoreCase("controlId"))
/*     */     {
/* 346 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.controlId));
/*     */     }
/* 348 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 350 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 352 */     if (FCode.equalsIgnoreCase("controlCode"))
/*     */     {
/* 354 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.controlCode));
/*     */     }
/* 356 */     if (FCode.equalsIgnoreCase("controlValue"))
/*     */     {
/* 358 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.controlValue));
/*     */     }
/* 360 */     if (FCode.equalsIgnoreCase("functionType"))
/*     */     {
/* 362 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.functionType));
/*     */     }
/* 364 */     if (FCode.equalsIgnoreCase("relaDivCode"))
/*     */     {
/* 366 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaDivCode));
/*     */     }
/* 368 */     if (FCode.equalsIgnoreCase("relaDivShow"))
/*     */     {
/* 370 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaDivShow));
/*     */     }
/* 372 */     if (FCode.equalsIgnoreCase("relaControlCode"))
/*     */     {
/* 374 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaControlCode));
/*     */     }
/* 376 */     if (FCode.equalsIgnoreCase("relaControlType"))
/*     */     {
/* 378 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaControlType));
/*     */     }
/* 380 */     if (FCode.equalsIgnoreCase("relaValueSql"))
/*     */     {
/* 382 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaValueSql));
/*     */     }
/* 384 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 386 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calCode));
/*     */     }
/* 388 */     if (FCode.equalsIgnoreCase("noti"))
/*     */     {
/* 390 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noti));
/*     */     }
/* 392 */     if (strReturn.equals(""))
/*     */     {
/* 394 */       strReturn = "null";
/*     */     }
/*     */ 
/* 397 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 404 */     String strFieldValue = "";
/* 405 */     switch (nFieldIndex) {
/*     */     case 0:
/* 407 */       strFieldValue = StrTool.GBKToUnicode(this.controlId);
/* 408 */       break;
/*     */     case 1:
/* 410 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 411 */       break;
/*     */     case 2:
/* 413 */       strFieldValue = StrTool.GBKToUnicode(this.controlCode);
/* 414 */       break;
/*     */     case 3:
/* 416 */       strFieldValue = StrTool.GBKToUnicode(this.controlValue);
/* 417 */       break;
/*     */     case 4:
/* 419 */       strFieldValue = StrTool.GBKToUnicode(this.functionType);
/* 420 */       break;
/*     */     case 5:
/* 422 */       strFieldValue = StrTool.GBKToUnicode(this.relaDivCode);
/* 423 */       break;
/*     */     case 6:
/* 425 */       strFieldValue = StrTool.GBKToUnicode(this.relaDivShow);
/* 426 */       break;
/*     */     case 7:
/* 428 */       strFieldValue = StrTool.GBKToUnicode(this.relaControlCode);
/* 429 */       break;
/*     */     case 8:
/* 431 */       strFieldValue = StrTool.GBKToUnicode(this.relaControlType);
/* 432 */       break;
/*     */     case 9:
/* 434 */       strFieldValue = StrTool.GBKToUnicode(this.relaValueSql);
/* 435 */       break;
/*     */     case 10:
/* 437 */       strFieldValue = StrTool.GBKToUnicode(this.calCode);
/* 438 */       break;
/*     */     case 11:
/* 440 */       strFieldValue = StrTool.GBKToUnicode(this.noti);
/* 441 */       break;
/*     */     default:
/* 443 */       strFieldValue = "";
/*     */     }
/* 445 */     if (strFieldValue.equals("")) {
/* 446 */       strFieldValue = "null";
/*     */     }
/* 448 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 454 */     if (StrTool.cTrim(FCode).equals("")) {
/* 455 */       return false;
/*     */     }
/* 457 */     if (FCode.equalsIgnoreCase("controlId"))
/*     */     {
/* 459 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 461 */         this.controlId = FValue.trim();
/*     */       }
/*     */       else
/* 464 */         this.controlId = null;
/*     */     }
/* 466 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 468 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 470 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 473 */         this.riskCode = null;
/*     */     }
/* 475 */     if (FCode.equalsIgnoreCase("controlCode"))
/*     */     {
/* 477 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 479 */         this.controlCode = FValue.trim();
/*     */       }
/*     */       else
/* 482 */         this.controlCode = null;
/*     */     }
/* 484 */     if (FCode.equalsIgnoreCase("controlValue"))
/*     */     {
/* 486 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 488 */         this.controlValue = FValue.trim();
/*     */       }
/*     */       else
/* 491 */         this.controlValue = null;
/*     */     }
/* 493 */     if (FCode.equalsIgnoreCase("functionType"))
/*     */     {
/* 495 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 497 */         this.functionType = FValue.trim();
/*     */       }
/*     */       else
/* 500 */         this.functionType = null;
/*     */     }
/* 502 */     if (FCode.equalsIgnoreCase("relaDivCode"))
/*     */     {
/* 504 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 506 */         this.relaDivCode = FValue.trim();
/*     */       }
/*     */       else
/* 509 */         this.relaDivCode = null;
/*     */     }
/* 511 */     if (FCode.equalsIgnoreCase("relaDivShow"))
/*     */     {
/* 513 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 515 */         this.relaDivShow = FValue.trim();
/*     */       }
/*     */       else
/* 518 */         this.relaDivShow = null;
/*     */     }
/* 520 */     if (FCode.equalsIgnoreCase("relaControlCode"))
/*     */     {
/* 522 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 524 */         this.relaControlCode = FValue.trim();
/*     */       }
/*     */       else
/* 527 */         this.relaControlCode = null;
/*     */     }
/* 529 */     if (FCode.equalsIgnoreCase("relaControlType"))
/*     */     {
/* 531 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 533 */         this.relaControlType = FValue.trim();
/*     */       }
/*     */       else
/* 536 */         this.relaControlType = null;
/*     */     }
/* 538 */     if (FCode.equalsIgnoreCase("relaValueSql"))
/*     */     {
/* 540 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 542 */         this.relaValueSql = FValue.trim();
/*     */       }
/*     */       else
/* 545 */         this.relaValueSql = null;
/*     */     }
/* 547 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 549 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 551 */         this.calCode = FValue.trim();
/*     */       }
/*     */       else
/* 554 */         this.calCode = null;
/*     */     }
/* 556 */     if (FCode.equalsIgnoreCase("noti"))
/*     */     {
/* 558 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 560 */         this.noti = FValue.trim();
/*     */       }
/*     */       else
/* 563 */         this.noti = null;
/*     */     }
/* 565 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 570 */     if (otherObject == null) return false;
/* 571 */     if (this == otherObject) return true;
/* 572 */     if (getClass() != otherObject.getClass()) return false;
/* 573 */     LNPRiskScreenValidateSchema other = (LNPRiskScreenValidateSchema)otherObject;
/* 574 */     if ((this.controlId == null) && (other.getControlId() != null)) return false;
/* 575 */     if ((this.controlId != null) && (!this.controlId.equals(other.getControlId()))) return false;
/* 576 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 577 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 578 */     if ((this.controlCode == null) && (other.getControlCode() != null)) return false;
/* 579 */     if ((this.controlCode != null) && (!this.controlCode.equals(other.getControlCode()))) return false;
/* 580 */     if ((this.controlValue == null) && (other.getControlValue() != null)) return false;
/* 581 */     if ((this.controlValue != null) && (!this.controlValue.equals(other.getControlValue()))) return false;
/* 582 */     if ((this.functionType == null) && (other.getFunctionType() != null)) return false;
/* 583 */     if ((this.functionType != null) && (!this.functionType.equals(other.getFunctionType()))) return false;
/* 584 */     if ((this.relaDivCode == null) && (other.getRelaDivCode() != null)) return false;
/* 585 */     if ((this.relaDivCode != null) && (!this.relaDivCode.equals(other.getRelaDivCode()))) return false;
/* 586 */     if ((this.relaDivShow == null) && (other.getRelaDivShow() != null)) return false;
/* 587 */     if ((this.relaDivShow != null) && (!this.relaDivShow.equals(other.getRelaDivShow()))) return false;
/* 588 */     if ((this.relaControlCode == null) && (other.getRelaControlCode() != null)) return false;
/* 589 */     if ((this.relaControlCode != null) && (!this.relaControlCode.equals(other.getRelaControlCode()))) return false;
/* 590 */     if ((this.relaControlType == null) && (other.getRelaControlType() != null)) return false;
/* 591 */     if ((this.relaControlType != null) && (!this.relaControlType.equals(other.getRelaControlType()))) return false;
/* 592 */     if ((this.relaValueSql == null) && (other.getRelaValueSql() != null)) return false;
/* 593 */     if ((this.relaValueSql != null) && (!this.relaValueSql.equals(other.getRelaValueSql()))) return false;
/* 594 */     if ((this.calCode == null) && (other.getCalCode() != null)) return false;
/* 595 */     if ((this.calCode != null) && (!this.calCode.equals(other.getCalCode()))) return false;
/* 596 */     if ((this.noti == null) && (other.getNoti() != null)) return false;
/* 597 */     return (this.noti == null) || (this.noti.equals(other.getNoti()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 604 */     return 12;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 610 */     if (strFieldName.equals("controlId")) {
/* 611 */       return 0;
/*     */     }
/* 613 */     if (strFieldName.equals("riskCode")) {
/* 614 */       return 1;
/*     */     }
/* 616 */     if (strFieldName.equals("controlCode")) {
/* 617 */       return 2;
/*     */     }
/* 619 */     if (strFieldName.equals("controlValue")) {
/* 620 */       return 3;
/*     */     }
/* 622 */     if (strFieldName.equals("functionType")) {
/* 623 */       return 4;
/*     */     }
/* 625 */     if (strFieldName.equals("relaDivCode")) {
/* 626 */       return 5;
/*     */     }
/* 628 */     if (strFieldName.equals("relaDivShow")) {
/* 629 */       return 6;
/*     */     }
/* 631 */     if (strFieldName.equals("relaControlCode")) {
/* 632 */       return 7;
/*     */     }
/* 634 */     if (strFieldName.equals("relaControlType")) {
/* 635 */       return 8;
/*     */     }
/* 637 */     if (strFieldName.equals("relaValueSql")) {
/* 638 */       return 9;
/*     */     }
/* 640 */     if (strFieldName.equals("calCode")) {
/* 641 */       return 10;
/*     */     }
/* 643 */     if (strFieldName.equals("noti")) {
/* 644 */       return 11;
/*     */     }
/* 646 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 652 */     String strFieldName = "";
/* 653 */     switch (nFieldIndex) {
/*     */     case 0:
/* 655 */       strFieldName = "controlId";
/* 656 */       break;
/*     */     case 1:
/* 658 */       strFieldName = "riskCode";
/* 659 */       break;
/*     */     case 2:
/* 661 */       strFieldName = "controlCode";
/* 662 */       break;
/*     */     case 3:
/* 664 */       strFieldName = "controlValue";
/* 665 */       break;
/*     */     case 4:
/* 667 */       strFieldName = "functionType";
/* 668 */       break;
/*     */     case 5:
/* 670 */       strFieldName = "relaDivCode";
/* 671 */       break;
/*     */     case 6:
/* 673 */       strFieldName = "relaDivShow";
/* 674 */       break;
/*     */     case 7:
/* 676 */       strFieldName = "relaControlCode";
/* 677 */       break;
/*     */     case 8:
/* 679 */       strFieldName = "relaControlType";
/* 680 */       break;
/*     */     case 9:
/* 682 */       strFieldName = "relaValueSql";
/* 683 */       break;
/*     */     case 10:
/* 685 */       strFieldName = "calCode";
/* 686 */       break;
/*     */     case 11:
/* 688 */       strFieldName = "noti";
/* 689 */       break;
/*     */     default:
/* 691 */       strFieldName = "";
/*     */     }
/* 693 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 699 */     if (strFieldName.equals("controlId")) {
/* 700 */       return 0;
/*     */     }
/* 702 */     if (strFieldName.equals("riskCode")) {
/* 703 */       return 0;
/*     */     }
/* 705 */     if (strFieldName.equals("controlCode")) {
/* 706 */       return 0;
/*     */     }
/* 708 */     if (strFieldName.equals("controlValue")) {
/* 709 */       return 0;
/*     */     }
/* 711 */     if (strFieldName.equals("functionType")) {
/* 712 */       return 0;
/*     */     }
/* 714 */     if (strFieldName.equals("relaDivCode")) {
/* 715 */       return 0;
/*     */     }
/* 717 */     if (strFieldName.equals("relaDivShow")) {
/* 718 */       return 0;
/*     */     }
/* 720 */     if (strFieldName.equals("relaControlCode")) {
/* 721 */       return 0;
/*     */     }
/* 723 */     if (strFieldName.equals("relaControlType")) {
/* 724 */       return 0;
/*     */     }
/* 726 */     if (strFieldName.equals("relaValueSql")) {
/* 727 */       return 0;
/*     */     }
/* 729 */     if (strFieldName.equals("calCode")) {
/* 730 */       return 0;
/*     */     }
/* 732 */     if (strFieldName.equals("noti")) {
/* 733 */       return 0;
/*     */     }
/* 735 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 741 */     int nFieldType = -1;
/* 742 */     switch (nFieldIndex) {
/*     */     case 0:
/* 744 */       nFieldType = 0;
/* 745 */       break;
/*     */     case 1:
/* 747 */       nFieldType = 0;
/* 748 */       break;
/*     */     case 2:
/* 750 */       nFieldType = 0;
/* 751 */       break;
/*     */     case 3:
/* 753 */       nFieldType = 0;
/* 754 */       break;
/*     */     case 4:
/* 756 */       nFieldType = 0;
/* 757 */       break;
/*     */     case 5:
/* 759 */       nFieldType = 0;
/* 760 */       break;
/*     */     case 6:
/* 762 */       nFieldType = 0;
/* 763 */       break;
/*     */     case 7:
/* 765 */       nFieldType = 0;
/* 766 */       break;
/*     */     case 8:
/* 768 */       nFieldType = 0;
/* 769 */       break;
/*     */     case 9:
/* 771 */       nFieldType = 0;
/* 772 */       break;
/*     */     case 10:
/* 774 */       nFieldType = 0;
/* 775 */       break;
/*     */     case 11:
/* 777 */       nFieldType = 0;
/* 778 */       break;
/*     */     default:
/* 780 */       nFieldType = -1;
/*     */     }
/* 782 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskScreenValidateSchema
 * JD-Core Version:    0.6.0
 */