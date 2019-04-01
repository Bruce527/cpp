/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MCodeDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MCodeSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String codeType;
/*     */   private String code;
/*     */   private String codeName;
/*     */   private String codeAlias;
/*     */   private String comCode;
/*     */   private String otherSign;
/*     */   private int codeOrder;
/*     */   public static final int FIELDNUM = 7;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MCodeSchema()
/*     */   {
/*  43 */     this.mErrors = new CErrors();
/*     */ 
/*  45 */     String[] pk = new String[0];
/*     */ 
/*  47 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  54 */     MCodeSchema cloned = (MCodeSchema)super.clone();
/*  55 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  56 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  62 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getCodeType()
/*     */   {
/*  67 */     return this.codeType;
/*     */   }
/*     */ 
/*     */   public void setCodeType(String aCodeType) {
/*  71 */     this.codeType = aCodeType;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  75 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String aCode) {
/*  79 */     this.code = aCode;
/*     */   }
/*     */ 
/*     */   public String getCodeName() {
/*  83 */     return this.codeName;
/*     */   }
/*     */ 
/*     */   public void setCodeName(String aCodeName) {
/*  87 */     this.codeName = aCodeName;
/*     */   }
/*     */ 
/*     */   public String getCodeAlias() {
/*  91 */     return this.codeAlias;
/*     */   }
/*     */ 
/*     */   public void setCodeAlias(String aCodeAlias) {
/*  95 */     this.codeAlias = aCodeAlias;
/*     */   }
/*     */ 
/*     */   public String getComCode() {
/*  99 */     return this.comCode;
/*     */   }
/*     */ 
/*     */   public void setComCode(String aComCode) {
/* 103 */     this.comCode = aComCode;
/*     */   }
/*     */ 
/*     */   public String getOtherSign() {
/* 107 */     return this.otherSign;
/*     */   }
/*     */ 
/*     */   public void setOtherSign(String aOtherSign) {
/* 111 */     this.otherSign = aOtherSign;
/*     */   }
/*     */ 
/*     */   public int getCodeOrder() {
/* 115 */     return this.codeOrder;
/*     */   }
/*     */ 
/*     */   public void setCodeOrder(int aCodeOrder) {
/* 119 */     this.codeOrder = aCodeOrder;
/*     */   }
/*     */ 
/*     */   public void setCodeOrder(String aCodeOrder) {
/* 123 */     if ((aCodeOrder != null) && (!aCodeOrder.equals("")))
/*     */     {
/* 125 */       Integer tInteger = new Integer(aCodeOrder);
/* 126 */       int i = tInteger.intValue();
/* 127 */       this.codeOrder = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(MCodeSchema aMCodeSchema)
/*     */   {
/* 135 */     this.codeType = aMCodeSchema.getCodeType();
/* 136 */     this.code = aMCodeSchema.getCode();
/* 137 */     this.codeName = aMCodeSchema.getCodeName();
/* 138 */     this.codeAlias = aMCodeSchema.getCodeAlias();
/* 139 */     this.comCode = aMCodeSchema.getComCode();
/* 140 */     this.otherSign = aMCodeSchema.getOtherSign();
/* 141 */     this.codeOrder = aMCodeSchema.getCodeOrder();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 150 */       if (rs.getString("CodeType") == null)
/* 151 */         this.codeType = null;
/*     */       else {
/* 153 */         this.codeType = rs.getString("CodeType").trim();
/*     */       }
/* 155 */       if (rs.getString("Code") == null)
/* 156 */         this.code = null;
/*     */       else {
/* 158 */         this.code = rs.getString("Code").trim();
/*     */       }
/* 160 */       if (rs.getString("CodeName") == null)
/* 161 */         this.codeName = null;
/*     */       else {
/* 163 */         this.codeName = rs.getString("CodeName").trim();
/*     */       }
/* 165 */       if (rs.getString("CodeAlias") == null)
/* 166 */         this.codeAlias = null;
/*     */       else {
/* 168 */         this.codeAlias = rs.getString("CodeAlias").trim();
/*     */       }
/* 170 */       if (rs.getString("ComCode") == null)
/* 171 */         this.comCode = null;
/*     */       else {
/* 173 */         this.comCode = rs.getString("ComCode").trim();
/*     */       }
/* 175 */       if (rs.getString("OtherSign") == null)
/* 176 */         this.otherSign = null;
/*     */       else {
/* 178 */         this.otherSign = rs.getString("OtherSign").trim();
/*     */       }
/* 180 */       this.codeOrder = rs.getInt("CodeOrder");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 184 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MCode\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 186 */       CError tError = new CError();
/* 187 */       tError.moduleName = "MCodeSchema";
/* 188 */       tError.functionName = "setSchema";
/* 189 */       tError.errorMessage = sqle.toString();
/* 190 */       this.mErrors.addOneError(tError);
/* 191 */       return false;
/*     */     }
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   public MCodeSchema getSchema()
/*     */   {
/* 198 */     MCodeSchema aMCodeSchema = new MCodeSchema();
/* 199 */     aMCodeSchema.setSchema(this);
/* 200 */     return aMCodeSchema;
/*     */   }
/*     */ 
/*     */   public MCodeDB getDB()
/*     */   {
/* 205 */     MCodeDB aDBOper = new MCodeDB();
/* 206 */     aDBOper.setSchema(this);
/* 207 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 214 */     StringBuffer strReturn = new StringBuffer(256);
/* 215 */     strReturn.append(StrTool.cTrim(this.codeType)); strReturn.append("|");
/* 216 */     strReturn.append(StrTool.cTrim(this.code)); strReturn.append("|");
/* 217 */     strReturn.append(StrTool.cTrim(this.codeName)); strReturn.append("|");
/* 218 */     strReturn.append(StrTool.cTrim(this.codeAlias)); strReturn.append("|");
/* 219 */     strReturn.append(StrTool.cTrim(this.comCode)); strReturn.append("|");
/* 220 */     strReturn.append(StrTool.cTrim(this.otherSign)); strReturn.append("|");
/* 221 */     strReturn.append(ChgData.chgData(this.codeOrder));
/* 222 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 230 */       this.codeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 231 */       this.code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 232 */       this.codeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 233 */       this.codeAlias = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 234 */       this.comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 235 */       this.otherSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 236 */       this.codeOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 241 */       CError tError = new CError();
/* 242 */       tError.moduleName = "MCodeSchema";
/* 243 */       tError.functionName = "decode";
/* 244 */       tError.errorMessage = ex.toString();
/* 245 */       this.mErrors.addOneError(tError);
/*     */ 
/* 247 */       return false;
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 255 */     String strReturn = "";
/* 256 */     if (FCode.equalsIgnoreCase("codeType"))
/*     */     {
/* 258 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeType));
/*     */     }
/* 260 */     if (FCode.equalsIgnoreCase("code"))
/*     */     {
/* 262 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.code));
/*     */     }
/* 264 */     if (FCode.equalsIgnoreCase("codeName"))
/*     */     {
/* 266 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeName));
/*     */     }
/* 268 */     if (FCode.equalsIgnoreCase("codeAlias"))
/*     */     {
/* 270 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeAlias));
/*     */     }
/* 272 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 274 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCode));
/*     */     }
/* 276 */     if (FCode.equalsIgnoreCase("otherSign"))
/*     */     {
/* 278 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherSign));
/*     */     }
/* 280 */     if (FCode.equalsIgnoreCase("codeOrder"))
/*     */     {
/* 282 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeOrder));
/*     */     }
/* 284 */     if (strReturn.equals(""))
/*     */     {
/* 286 */       strReturn = "null";
/*     */     }
/*     */ 
/* 289 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 296 */     String strFieldValue = "";
/* 297 */     switch (nFieldIndex) {
/*     */     case 0:
/* 299 */       strFieldValue = StrTool.GBKToUnicode(this.codeType);
/* 300 */       break;
/*     */     case 1:
/* 302 */       strFieldValue = StrTool.GBKToUnicode(this.code);
/* 303 */       break;
/*     */     case 2:
/* 305 */       strFieldValue = StrTool.GBKToUnicode(this.codeName);
/* 306 */       break;
/*     */     case 3:
/* 308 */       strFieldValue = StrTool.GBKToUnicode(this.codeAlias);
/* 309 */       break;
/*     */     case 4:
/* 311 */       strFieldValue = StrTool.GBKToUnicode(this.comCode);
/* 312 */       break;
/*     */     case 5:
/* 314 */       strFieldValue = StrTool.GBKToUnicode(this.otherSign);
/* 315 */       break;
/*     */     case 6:
/* 317 */       strFieldValue = String.valueOf(this.codeOrder);
/* 318 */       break;
/*     */     default:
/* 320 */       strFieldValue = "";
/*     */     }
/* 322 */     if (strFieldValue.equals("")) {
/* 323 */       strFieldValue = "null";
/*     */     }
/* 325 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 331 */     if (StrTool.cTrim(FCode).equals("")) {
/* 332 */       return false;
/*     */     }
/* 334 */     if (FCode.equalsIgnoreCase("codeType"))
/*     */     {
/* 336 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 338 */         this.codeType = FValue.trim();
/*     */       }
/*     */       else
/* 341 */         this.codeType = null;
/*     */     }
/* 343 */     if (FCode.equalsIgnoreCase("code"))
/*     */     {
/* 345 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 347 */         this.code = FValue.trim();
/*     */       }
/*     */       else
/* 350 */         this.code = null;
/*     */     }
/* 352 */     if (FCode.equalsIgnoreCase("codeName"))
/*     */     {
/* 354 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 356 */         this.codeName = FValue.trim();
/*     */       }
/*     */       else
/* 359 */         this.codeName = null;
/*     */     }
/* 361 */     if (FCode.equalsIgnoreCase("codeAlias"))
/*     */     {
/* 363 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 365 */         this.codeAlias = FValue.trim();
/*     */       }
/*     */       else
/* 368 */         this.codeAlias = null;
/*     */     }
/* 370 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 372 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 374 */         this.comCode = FValue.trim();
/*     */       }
/*     */       else
/* 377 */         this.comCode = null;
/*     */     }
/* 379 */     if (FCode.equalsIgnoreCase("otherSign"))
/*     */     {
/* 381 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 383 */         this.otherSign = FValue.trim();
/*     */       }
/*     */       else
/* 386 */         this.otherSign = null;
/*     */     }
/* 388 */     if (FCode.equalsIgnoreCase("codeOrder"))
/*     */     {
/* 390 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 392 */         Integer tInteger = new Integer(FValue);
/* 393 */         int i = tInteger.intValue();
/* 394 */         this.codeOrder = i;
/*     */       }
/*     */     }
/* 397 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 402 */     if (otherObject == null) return false;
/* 403 */     if (this == otherObject) return true;
/* 404 */     if (getClass() != otherObject.getClass()) return false;
/* 405 */     MCodeSchema other = (MCodeSchema)otherObject;
/* 406 */     if ((this.codeType == null) && (other.getCodeType() != null)) return false;
/* 407 */     if ((this.codeType != null) && (!this.codeType.equals(other.getCodeType()))) return false;
/* 408 */     if ((this.code == null) && (other.getCode() != null)) return false;
/* 409 */     if ((this.code != null) && (!this.code.equals(other.getCode()))) return false;
/* 410 */     if ((this.codeName == null) && (other.getCodeName() != null)) return false;
/* 411 */     if ((this.codeName != null) && (!this.codeName.equals(other.getCodeName()))) return false;
/* 412 */     if ((this.codeAlias == null) && (other.getCodeAlias() != null)) return false;
/* 413 */     if ((this.codeAlias != null) && (!this.codeAlias.equals(other.getCodeAlias()))) return false;
/* 414 */     if ((this.comCode == null) && (other.getComCode() != null)) return false;
/* 415 */     if ((this.comCode != null) && (!this.comCode.equals(other.getComCode()))) return false;
/* 416 */     if ((this.otherSign == null) && (other.getOtherSign() != null)) return false;
/* 417 */     if ((this.otherSign != null) && (!this.otherSign.equals(other.getOtherSign()))) return false;
/* 418 */     return this.codeOrder == other.getCodeOrder();
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 425 */     return 7;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 431 */     if (strFieldName.equals("codeType")) {
/* 432 */       return 0;
/*     */     }
/* 434 */     if (strFieldName.equals("code")) {
/* 435 */       return 1;
/*     */     }
/* 437 */     if (strFieldName.equals("codeName")) {
/* 438 */       return 2;
/*     */     }
/* 440 */     if (strFieldName.equals("codeAlias")) {
/* 441 */       return 3;
/*     */     }
/* 443 */     if (strFieldName.equals("comCode")) {
/* 444 */       return 4;
/*     */     }
/* 446 */     if (strFieldName.equals("otherSign")) {
/* 447 */       return 5;
/*     */     }
/* 449 */     if (strFieldName.equals("codeOrder")) {
/* 450 */       return 6;
/*     */     }
/* 452 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 458 */     String strFieldName = "";
/* 459 */     switch (nFieldIndex) {
/*     */     case 0:
/* 461 */       strFieldName = "codeType";
/* 462 */       break;
/*     */     case 1:
/* 464 */       strFieldName = "code";
/* 465 */       break;
/*     */     case 2:
/* 467 */       strFieldName = "codeName";
/* 468 */       break;
/*     */     case 3:
/* 470 */       strFieldName = "codeAlias";
/* 471 */       break;
/*     */     case 4:
/* 473 */       strFieldName = "comCode";
/* 474 */       break;
/*     */     case 5:
/* 476 */       strFieldName = "otherSign";
/* 477 */       break;
/*     */     case 6:
/* 479 */       strFieldName = "codeOrder";
/* 480 */       break;
/*     */     default:
/* 482 */       strFieldName = "";
/*     */     }
/* 484 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 490 */     if (strFieldName.equals("codeType")) {
/* 491 */       return 0;
/*     */     }
/* 493 */     if (strFieldName.equals("code")) {
/* 494 */       return 0;
/*     */     }
/* 496 */     if (strFieldName.equals("codeName")) {
/* 497 */       return 0;
/*     */     }
/* 499 */     if (strFieldName.equals("codeAlias")) {
/* 500 */       return 0;
/*     */     }
/* 502 */     if (strFieldName.equals("comCode")) {
/* 503 */       return 0;
/*     */     }
/* 505 */     if (strFieldName.equals("otherSign")) {
/* 506 */       return 0;
/*     */     }
/* 508 */     if (strFieldName.equals("codeOrder")) {
/* 509 */       return 3;
/*     */     }
/* 511 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 517 */     int nFieldType = -1;
/* 518 */     switch (nFieldIndex) {
/*     */     case 0:
/* 520 */       nFieldType = 0;
/* 521 */       break;
/*     */     case 1:
/* 523 */       nFieldType = 0;
/* 524 */       break;
/*     */     case 2:
/* 526 */       nFieldType = 0;
/* 527 */       break;
/*     */     case 3:
/* 529 */       nFieldType = 0;
/* 530 */       break;
/*     */     case 4:
/* 532 */       nFieldType = 0;
/* 533 */       break;
/*     */     case 5:
/* 535 */       nFieldType = 0;
/* 536 */       break;
/*     */     case 6:
/* 538 */       nFieldType = 3;
/* 539 */       break;
/*     */     default:
/* 541 */       nFieldType = -1;
/*     */     }
/* 543 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MCodeSchema
 * JD-Core Version:    0.6.0
 */