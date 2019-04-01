/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPCodeSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String codeType;
/*     */   private String code;
/*     */   private String codeName;
/*     */   private String codeAlias;
/*     */   private String comCode;
/*     */   private String otherSign;
/*     */   public static final int FIELDNUM = 6;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPCodeSchema()
/*     */   {
/*  44 */     this.mErrors = new CErrors();
/*     */ 
/*  46 */     String[] pk = new String[2];
/*  47 */     pk[0] = "CodeType";
/*  48 */     pk[1] = "Code";
/*     */ 
/*  50 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  57 */     LNPCodeSchema cloned = (LNPCodeSchema)super.clone();
/*  58 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  59 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  65 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getCodeType()
/*     */   {
/*  70 */     return this.codeType;
/*     */   }
/*     */ 
/*     */   public void setCodeType(String aCodeType) {
/*  74 */     this.codeType = aCodeType;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  78 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String aCode) {
/*  82 */     this.code = aCode;
/*     */   }
/*     */ 
/*     */   public String getCodeName() {
/*  86 */     return this.codeName;
/*     */   }
/*     */ 
/*     */   public void setCodeName(String aCodeName) {
/*  90 */     this.codeName = aCodeName;
/*     */   }
/*     */ 
/*     */   public String getCodeAlias() {
/*  94 */     return this.codeAlias;
/*     */   }
/*     */ 
/*     */   public void setCodeAlias(String aCodeAlias) {
/*  98 */     this.codeAlias = aCodeAlias;
/*     */   }
/*     */ 
/*     */   public String getComCode() {
/* 102 */     return this.comCode;
/*     */   }
/*     */ 
/*     */   public void setComCode(String aComCode) {
/* 106 */     this.comCode = aComCode;
/*     */   }
/*     */ 
/*     */   public String getOtherSign() {
/* 110 */     return this.otherSign;
/*     */   }
/*     */ 
/*     */   public void setOtherSign(String aOtherSign) {
/* 114 */     this.otherSign = aOtherSign;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPCodeSchema aLNPCodeSchema)
/*     */   {
/* 120 */     this.codeType = aLNPCodeSchema.getCodeType();
/* 121 */     this.code = aLNPCodeSchema.getCode();
/* 122 */     this.codeName = aLNPCodeSchema.getCodeName();
/* 123 */     this.codeAlias = aLNPCodeSchema.getCodeAlias();
/* 124 */     this.comCode = aLNPCodeSchema.getComCode();
/* 125 */     this.otherSign = aLNPCodeSchema.getOtherSign();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 134 */       if (rs.getString("CodeType") == null)
/* 135 */         this.codeType = null;
/*     */       else {
/* 137 */         this.codeType = rs.getString("CodeType").trim();
/*     */       }
/* 139 */       if (rs.getString("Code") == null)
/* 140 */         this.code = null;
/*     */       else {
/* 142 */         this.code = rs.getString("Code").trim();
/*     */       }
/* 144 */       if (rs.getString("CodeName") == null)
/* 145 */         this.codeName = null;
/*     */       else {
/* 147 */         this.codeName = rs.getString("CodeName").trim();
/*     */       }
/* 149 */       if (rs.getString("CodeAlias") == null)
/* 150 */         this.codeAlias = null;
/*     */       else {
/* 152 */         this.codeAlias = rs.getString("CodeAlias").trim();
/*     */       }
/* 154 */       if (rs.getString("ComCode") == null)
/* 155 */         this.comCode = null;
/*     */       else {
/* 157 */         this.comCode = rs.getString("ComCode").trim();
/*     */       }
/* 159 */       if (rs.getString("OtherSign") == null)
/* 160 */         this.otherSign = null;
/*     */       else {
/* 162 */         this.otherSign = rs.getString("OtherSign").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 167 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCode\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 169 */       CError tError = new CError();
/* 170 */       tError.moduleName = "LNPCodeSchema";
/* 171 */       tError.functionName = "setSchema";
/* 172 */       tError.errorMessage = sqle.toString();
/* 173 */       this.mErrors.addOneError(tError);
/* 174 */       return false;
/*     */     }
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCodeSchema getSchema()
/*     */   {
/* 181 */     LNPCodeSchema aLNPCodeSchema = new LNPCodeSchema();
/* 182 */     aLNPCodeSchema.setSchema(this);
/* 183 */     return aLNPCodeSchema;
/*     */   }
/*     */ 
/*     */   public LNPCodeDB getDB()
/*     */   {
/* 188 */     LNPCodeDB aDBOper = new LNPCodeDB();
/* 189 */     aDBOper.setSchema(this);
/* 190 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 197 */     StringBuffer strReturn = new StringBuffer(256);
/* 198 */     strReturn.append(StrTool.cTrim(this.codeType)); strReturn.append("|");
/* 199 */     strReturn.append(StrTool.cTrim(this.code)); strReturn.append("|");
/* 200 */     strReturn.append(StrTool.cTrim(this.codeName)); strReturn.append("|");
/* 201 */     strReturn.append(StrTool.cTrim(this.codeAlias)); strReturn.append("|");
/* 202 */     strReturn.append(StrTool.cTrim(this.comCode)); strReturn.append("|");
/* 203 */     strReturn.append(StrTool.cTrim(this.otherSign));
/* 204 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 212 */       this.codeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 213 */       this.code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 214 */       this.codeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 215 */       this.codeAlias = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 216 */       this.comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 217 */       this.otherSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 222 */       CError tError = new CError();
/* 223 */       tError.moduleName = "LNPCodeSchema";
/* 224 */       tError.functionName = "decode";
/* 225 */       tError.errorMessage = ex.toString();
/* 226 */       this.mErrors.addOneError(tError);
/*     */ 
/* 228 */       return false;
/*     */     }
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 236 */     String strReturn = "";
/* 237 */     if (FCode.equalsIgnoreCase("codeType"))
/*     */     {
/* 239 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeType));
/*     */     }
/* 241 */     if (FCode.equalsIgnoreCase("code"))
/*     */     {
/* 243 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.code));
/*     */     }
/* 245 */     if (FCode.equalsIgnoreCase("codeName"))
/*     */     {
/* 247 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeName));
/*     */     }
/* 249 */     if (FCode.equalsIgnoreCase("codeAlias"))
/*     */     {
/* 251 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.codeAlias));
/*     */     }
/* 253 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 255 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCode));
/*     */     }
/* 257 */     if (FCode.equalsIgnoreCase("otherSign"))
/*     */     {
/* 259 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherSign));
/*     */     }
/* 261 */     if (strReturn.equals(""))
/*     */     {
/* 263 */       strReturn = "null";
/*     */     }
/*     */ 
/* 266 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 273 */     String strFieldValue = "";
/* 274 */     switch (nFieldIndex) {
/*     */     case 0:
/* 276 */       strFieldValue = StrTool.GBKToUnicode(this.codeType);
/* 277 */       break;
/*     */     case 1:
/* 279 */       strFieldValue = StrTool.GBKToUnicode(this.code);
/* 280 */       break;
/*     */     case 2:
/* 282 */       strFieldValue = StrTool.GBKToUnicode(this.codeName);
/* 283 */       break;
/*     */     case 3:
/* 285 */       strFieldValue = StrTool.GBKToUnicode(this.codeAlias);
/* 286 */       break;
/*     */     case 4:
/* 288 */       strFieldValue = StrTool.GBKToUnicode(this.comCode);
/* 289 */       break;
/*     */     case 5:
/* 291 */       strFieldValue = StrTool.GBKToUnicode(this.otherSign);
/* 292 */       break;
/*     */     default:
/* 294 */       strFieldValue = "";
/*     */     }
/* 296 */     if (strFieldValue.equals("")) {
/* 297 */       strFieldValue = "null";
/*     */     }
/* 299 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 305 */     if (StrTool.cTrim(FCode).equals("")) {
/* 306 */       return false;
/*     */     }
/* 308 */     if (FCode.equalsIgnoreCase("codeType"))
/*     */     {
/* 310 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 312 */         this.codeType = FValue.trim();
/*     */       }
/*     */       else
/* 315 */         this.codeType = null;
/*     */     }
/* 317 */     if (FCode.equalsIgnoreCase("code"))
/*     */     {
/* 319 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 321 */         this.code = FValue.trim();
/*     */       }
/*     */       else
/* 324 */         this.code = null;
/*     */     }
/* 326 */     if (FCode.equalsIgnoreCase("codeName"))
/*     */     {
/* 328 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 330 */         this.codeName = FValue.trim();
/*     */       }
/*     */       else
/* 333 */         this.codeName = null;
/*     */     }
/* 335 */     if (FCode.equalsIgnoreCase("codeAlias"))
/*     */     {
/* 337 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 339 */         this.codeAlias = FValue.trim();
/*     */       }
/*     */       else
/* 342 */         this.codeAlias = null;
/*     */     }
/* 344 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 346 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 348 */         this.comCode = FValue.trim();
/*     */       }
/*     */       else
/* 351 */         this.comCode = null;
/*     */     }
/* 353 */     if (FCode.equalsIgnoreCase("otherSign"))
/*     */     {
/* 355 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 357 */         this.otherSign = FValue.trim();
/*     */       }
/*     */       else
/* 360 */         this.otherSign = null;
/*     */     }
/* 362 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 367 */     if (otherObject == null) return false;
/* 368 */     if (this == otherObject) return true;
/* 369 */     if (getClass() != otherObject.getClass()) return false;
/* 370 */     LNPCodeSchema other = (LNPCodeSchema)otherObject;
/* 371 */     if ((this.codeType == null) && (other.getCodeType() != null)) return false;
/* 372 */     if ((this.codeType != null) && (!this.codeType.equals(other.getCodeType()))) return false;
/* 373 */     if ((this.code == null) && (other.getCode() != null)) return false;
/* 374 */     if ((this.code != null) && (!this.code.equals(other.getCode()))) return false;
/* 375 */     if ((this.codeName == null) && (other.getCodeName() != null)) return false;
/* 376 */     if ((this.codeName != null) && (!this.codeName.equals(other.getCodeName()))) return false;
/* 377 */     if ((this.codeAlias == null) && (other.getCodeAlias() != null)) return false;
/* 378 */     if ((this.codeAlias != null) && (!this.codeAlias.equals(other.getCodeAlias()))) return false;
/* 379 */     if ((this.comCode == null) && (other.getComCode() != null)) return false;
/* 380 */     if ((this.comCode != null) && (!this.comCode.equals(other.getComCode()))) return false;
/* 381 */     if ((this.otherSign == null) && (other.getOtherSign() != null)) return false;
/* 382 */     return (this.otherSign == null) || (this.otherSign.equals(other.getOtherSign()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 389 */     return 6;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 395 */     if (strFieldName.equals("codeType")) {
/* 396 */       return 0;
/*     */     }
/* 398 */     if (strFieldName.equals("code")) {
/* 399 */       return 1;
/*     */     }
/* 401 */     if (strFieldName.equals("codeName")) {
/* 402 */       return 2;
/*     */     }
/* 404 */     if (strFieldName.equals("codeAlias")) {
/* 405 */       return 3;
/*     */     }
/* 407 */     if (strFieldName.equals("comCode")) {
/* 408 */       return 4;
/*     */     }
/* 410 */     if (strFieldName.equals("otherSign")) {
/* 411 */       return 5;
/*     */     }
/* 413 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 419 */     String strFieldName = "";
/* 420 */     switch (nFieldIndex) {
/*     */     case 0:
/* 422 */       strFieldName = "codeType";
/* 423 */       break;
/*     */     case 1:
/* 425 */       strFieldName = "code";
/* 426 */       break;
/*     */     case 2:
/* 428 */       strFieldName = "codeName";
/* 429 */       break;
/*     */     case 3:
/* 431 */       strFieldName = "codeAlias";
/* 432 */       break;
/*     */     case 4:
/* 434 */       strFieldName = "comCode";
/* 435 */       break;
/*     */     case 5:
/* 437 */       strFieldName = "otherSign";
/* 438 */       break;
/*     */     default:
/* 440 */       strFieldName = "";
/*     */     }
/* 442 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 448 */     if (strFieldName.equals("codeType")) {
/* 449 */       return 0;
/*     */     }
/* 451 */     if (strFieldName.equals("code")) {
/* 452 */       return 0;
/*     */     }
/* 454 */     if (strFieldName.equals("codeName")) {
/* 455 */       return 0;
/*     */     }
/* 457 */     if (strFieldName.equals("codeAlias")) {
/* 458 */       return 0;
/*     */     }
/* 460 */     if (strFieldName.equals("comCode")) {
/* 461 */       return 0;
/*     */     }
/* 463 */     if (strFieldName.equals("otherSign")) {
/* 464 */       return 0;
/*     */     }
/* 466 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 472 */     int nFieldType = -1;
/* 473 */     switch (nFieldIndex) {
/*     */     case 0:
/* 475 */       nFieldType = 0;
/* 476 */       break;
/*     */     case 1:
/* 478 */       nFieldType = 0;
/* 479 */       break;
/*     */     case 2:
/* 481 */       nFieldType = 0;
/* 482 */       break;
/*     */     case 3:
/* 484 */       nFieldType = 0;
/* 485 */       break;
/*     */     case 4:
/* 487 */       nFieldType = 0;
/* 488 */       break;
/*     */     case 5:
/* 490 */       nFieldType = 0;
/* 491 */       break;
/*     */     default:
/* 493 */       nFieldType = -1;
/*     */     }
/* 495 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCodeSchema
 * JD-Core Version:    0.6.0
 */