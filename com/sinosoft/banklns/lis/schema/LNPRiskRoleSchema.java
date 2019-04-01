/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskRoleDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskRoleSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String riskVer;
/*     */   private String riskRole;
/*     */   private String riskRoleSex;
/*     */   private String riskRoleNo;
/*     */   private String minAppAgeFlag;
/*     */   private int minAppAge;
/*     */   private String mAXAppAgeFlag;
/*     */   private int mAXAppAge;
/*     */   public static final int FIELDNUM = 9;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskRoleSchema()
/*     */   {
/*  50 */     this.mErrors = new CErrors();
/*     */ 
/*  52 */     String[] pk = new String[4];
/*  53 */     pk[0] = "RiskCode";
/*  54 */     pk[1] = "RiskRole";
/*  55 */     pk[2] = "RiskRoleSex";
/*  56 */     pk[3] = "RiskRoleNo";
/*     */ 
/*  58 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  65 */     LNPRiskRoleSchema cloned = (LNPRiskRoleSchema)super.clone();
/*  66 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  67 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  73 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/*  78 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  82 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskVer() {
/*  86 */     return this.riskVer;
/*     */   }
/*     */ 
/*     */   public void setRiskVer(String aRiskVer) {
/*  90 */     this.riskVer = aRiskVer;
/*     */   }
/*     */ 
/*     */   public String getRiskRole() {
/*  94 */     return this.riskRole;
/*     */   }
/*     */ 
/*     */   public void setRiskRole(String aRiskRole) {
/*  98 */     this.riskRole = aRiskRole;
/*     */   }
/*     */ 
/*     */   public String getRiskRoleSex() {
/* 102 */     return this.riskRoleSex;
/*     */   }
/*     */ 
/*     */   public void setRiskRoleSex(String aRiskRoleSex) {
/* 106 */     this.riskRoleSex = aRiskRoleSex;
/*     */   }
/*     */ 
/*     */   public String getRiskRoleNo() {
/* 110 */     return this.riskRoleNo;
/*     */   }
/*     */ 
/*     */   public void setRiskRoleNo(String aRiskRoleNo) {
/* 114 */     this.riskRoleNo = aRiskRoleNo;
/*     */   }
/*     */ 
/*     */   public String getMinAppAgeFlag() {
/* 118 */     return this.minAppAgeFlag;
/*     */   }
/*     */ 
/*     */   public void setMinAppAgeFlag(String aMinAppAgeFlag) {
/* 122 */     this.minAppAgeFlag = aMinAppAgeFlag;
/*     */   }
/*     */ 
/*     */   public int getMinAppAge() {
/* 126 */     return this.minAppAge;
/*     */   }
/*     */ 
/*     */   public void setMinAppAge(int aMinAppAge) {
/* 130 */     this.minAppAge = aMinAppAge;
/*     */   }
/*     */ 
/*     */   public void setMinAppAge(String aMinAppAge) {
/* 134 */     if ((aMinAppAge != null) && (!aMinAppAge.equals("")))
/*     */     {
/* 136 */       Integer tInteger = new Integer(aMinAppAge);
/* 137 */       int i = tInteger.intValue();
/* 138 */       this.minAppAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getMAXAppAgeFlag()
/*     */   {
/* 144 */     return this.mAXAppAgeFlag;
/*     */   }
/*     */ 
/*     */   public void setMAXAppAgeFlag(String aMAXAppAgeFlag) {
/* 148 */     this.mAXAppAgeFlag = aMAXAppAgeFlag;
/*     */   }
/*     */ 
/*     */   public int getMAXAppAge() {
/* 152 */     return this.mAXAppAge;
/*     */   }
/*     */ 
/*     */   public void setMAXAppAge(int aMAXAppAge) {
/* 156 */     this.mAXAppAge = aMAXAppAge;
/*     */   }
/*     */ 
/*     */   public void setMAXAppAge(String aMAXAppAge) {
/* 160 */     if ((aMAXAppAge != null) && (!aMAXAppAge.equals("")))
/*     */     {
/* 162 */       Integer tInteger = new Integer(aMAXAppAge);
/* 163 */       int i = tInteger.intValue();
/* 164 */       this.mAXAppAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskRoleSchema aLNPRiskRoleSchema)
/*     */   {
/* 172 */     this.riskCode = aLNPRiskRoleSchema.getRiskCode();
/* 173 */     this.riskVer = aLNPRiskRoleSchema.getRiskVer();
/* 174 */     this.riskRole = aLNPRiskRoleSchema.getRiskRole();
/* 175 */     this.riskRoleSex = aLNPRiskRoleSchema.getRiskRoleSex();
/* 176 */     this.riskRoleNo = aLNPRiskRoleSchema.getRiskRoleNo();
/* 177 */     this.minAppAgeFlag = aLNPRiskRoleSchema.getMinAppAgeFlag();
/* 178 */     this.minAppAge = aLNPRiskRoleSchema.getMinAppAge();
/* 179 */     this.mAXAppAgeFlag = aLNPRiskRoleSchema.getMAXAppAgeFlag();
/* 180 */     this.mAXAppAge = aLNPRiskRoleSchema.getMAXAppAge();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 189 */       if (rs.getString("RiskCode") == null)
/* 190 */         this.riskCode = null;
/*     */       else {
/* 192 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 194 */       if (rs.getString("RiskVer") == null)
/* 195 */         this.riskVer = null;
/*     */       else {
/* 197 */         this.riskVer = rs.getString("RiskVer").trim();
/*     */       }
/* 199 */       if (rs.getString("RiskRole") == null)
/* 200 */         this.riskRole = null;
/*     */       else {
/* 202 */         this.riskRole = rs.getString("RiskRole").trim();
/*     */       }
/* 204 */       if (rs.getString("RiskRoleSex") == null)
/* 205 */         this.riskRoleSex = null;
/*     */       else {
/* 207 */         this.riskRoleSex = rs.getString("RiskRoleSex").trim();
/*     */       }
/* 209 */       if (rs.getString("RiskRoleNo") == null)
/* 210 */         this.riskRoleNo = null;
/*     */       else {
/* 212 */         this.riskRoleNo = rs.getString("RiskRoleNo").trim();
/*     */       }
/* 214 */       if (rs.getString("MinAppAgeFlag") == null)
/* 215 */         this.minAppAgeFlag = null;
/*     */       else {
/* 217 */         this.minAppAgeFlag = rs.getString("MinAppAgeFlag").trim();
/*     */       }
/* 219 */       this.minAppAge = rs.getInt("MinAppAge");
/* 220 */       if (rs.getString("MAXAppAgeFlag") == null)
/* 221 */         this.mAXAppAgeFlag = null;
/*     */       else {
/* 223 */         this.mAXAppAgeFlag = rs.getString("MAXAppAgeFlag").trim();
/*     */       }
/* 225 */       this.mAXAppAge = rs.getInt("MAXAppAge");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 229 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskRole\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 231 */       CError tError = new CError();
/* 232 */       tError.moduleName = "LNPRiskRoleSchema";
/* 233 */       tError.functionName = "setSchema";
/* 234 */       tError.errorMessage = sqle.toString();
/* 235 */       this.mErrors.addOneError(tError);
/* 236 */       return false;
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskRoleSchema getSchema()
/*     */   {
/* 243 */     LNPRiskRoleSchema aLNPRiskRoleSchema = new LNPRiskRoleSchema();
/* 244 */     aLNPRiskRoleSchema.setSchema(this);
/* 245 */     return aLNPRiskRoleSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskRoleDB getDB()
/*     */   {
/* 250 */     LNPRiskRoleDB aDBOper = new LNPRiskRoleDB();
/* 251 */     aDBOper.setSchema(this);
/* 252 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 259 */     StringBuffer strReturn = new StringBuffer(256);
/* 260 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 261 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/* 262 */     strReturn.append(StrTool.cTrim(this.riskRole)); strReturn.append("|");
/* 263 */     strReturn.append(StrTool.cTrim(this.riskRoleSex)); strReturn.append("|");
/* 264 */     strReturn.append(StrTool.cTrim(this.riskRoleNo)); strReturn.append("|");
/* 265 */     strReturn.append(StrTool.cTrim(this.minAppAgeFlag)); strReturn.append("|");
/* 266 */     strReturn.append(ChgData.chgData(this.minAppAge)); strReturn.append("|");
/* 267 */     strReturn.append(StrTool.cTrim(this.mAXAppAgeFlag)); strReturn.append("|");
/* 268 */     strReturn.append(ChgData.chgData(this.mAXAppAge));
/* 269 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 277 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 278 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 279 */       this.riskRole = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 280 */       this.riskRoleSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 281 */       this.riskRoleNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 282 */       this.minAppAgeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 283 */       this.minAppAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/* 284 */       this.mAXAppAgeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 285 */       this.mAXAppAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 290 */       CError tError = new CError();
/* 291 */       tError.moduleName = "LNPRiskRoleSchema";
/* 292 */       tError.functionName = "decode";
/* 293 */       tError.errorMessage = ex.toString();
/* 294 */       this.mErrors.addOneError(tError);
/*     */ 
/* 296 */       return false;
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 304 */     String strReturn = "";
/* 305 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 307 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 309 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 311 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*     */     }
/* 313 */     if (FCode.equalsIgnoreCase("riskRole"))
/*     */     {
/* 315 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskRole));
/*     */     }
/* 317 */     if (FCode.equalsIgnoreCase("riskRoleSex"))
/*     */     {
/* 319 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskRoleSex));
/*     */     }
/* 321 */     if (FCode.equalsIgnoreCase("riskRoleNo"))
/*     */     {
/* 323 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskRoleNo));
/*     */     }
/* 325 */     if (FCode.equalsIgnoreCase("minAppAgeFlag"))
/*     */     {
/* 327 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minAppAgeFlag));
/*     */     }
/* 329 */     if (FCode.equalsIgnoreCase("minAppAge"))
/*     */     {
/* 331 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minAppAge));
/*     */     }
/* 333 */     if (FCode.equalsIgnoreCase("mAXAppAgeFlag"))
/*     */     {
/* 335 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mAXAppAgeFlag));
/*     */     }
/* 337 */     if (FCode.equalsIgnoreCase("mAXAppAge"))
/*     */     {
/* 339 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mAXAppAge));
/*     */     }
/* 341 */     if (strReturn.equals(""))
/*     */     {
/* 343 */       strReturn = "null";
/*     */     }
/*     */ 
/* 346 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 353 */     String strFieldValue = "";
/* 354 */     switch (nFieldIndex) {
/*     */     case 0:
/* 356 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 357 */       break;
/*     */     case 1:
/* 359 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/* 360 */       break;
/*     */     case 2:
/* 362 */       strFieldValue = StrTool.GBKToUnicode(this.riskRole);
/* 363 */       break;
/*     */     case 3:
/* 365 */       strFieldValue = StrTool.GBKToUnicode(this.riskRoleSex);
/* 366 */       break;
/*     */     case 4:
/* 368 */       strFieldValue = StrTool.GBKToUnicode(this.riskRoleNo);
/* 369 */       break;
/*     */     case 5:
/* 371 */       strFieldValue = StrTool.GBKToUnicode(this.minAppAgeFlag);
/* 372 */       break;
/*     */     case 6:
/* 374 */       strFieldValue = String.valueOf(this.minAppAge);
/* 375 */       break;
/*     */     case 7:
/* 377 */       strFieldValue = StrTool.GBKToUnicode(this.mAXAppAgeFlag);
/* 378 */       break;
/*     */     case 8:
/* 380 */       strFieldValue = String.valueOf(this.mAXAppAge);
/* 381 */       break;
/*     */     default:
/* 383 */       strFieldValue = "";
/*     */     }
/* 385 */     if (strFieldValue.equals("")) {
/* 386 */       strFieldValue = "null";
/*     */     }
/* 388 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 394 */     if (StrTool.cTrim(FCode).equals("")) {
/* 395 */       return false;
/*     */     }
/* 397 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 399 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 401 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 404 */         this.riskCode = null;
/*     */     }
/* 406 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 408 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 410 */         this.riskVer = FValue.trim();
/*     */       }
/*     */       else
/* 413 */         this.riskVer = null;
/*     */     }
/* 415 */     if (FCode.equalsIgnoreCase("riskRole"))
/*     */     {
/* 417 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 419 */         this.riskRole = FValue.trim();
/*     */       }
/*     */       else
/* 422 */         this.riskRole = null;
/*     */     }
/* 424 */     if (FCode.equalsIgnoreCase("riskRoleSex"))
/*     */     {
/* 426 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 428 */         this.riskRoleSex = FValue.trim();
/*     */       }
/*     */       else
/* 431 */         this.riskRoleSex = null;
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("riskRoleNo"))
/*     */     {
/* 435 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 437 */         this.riskRoleNo = FValue.trim();
/*     */       }
/*     */       else
/* 440 */         this.riskRoleNo = null;
/*     */     }
/* 442 */     if (FCode.equalsIgnoreCase("minAppAgeFlag"))
/*     */     {
/* 444 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 446 */         this.minAppAgeFlag = FValue.trim();
/*     */       }
/*     */       else
/* 449 */         this.minAppAgeFlag = null;
/*     */     }
/* 451 */     if (FCode.equalsIgnoreCase("minAppAge"))
/*     */     {
/* 453 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 455 */         Integer tInteger = new Integer(FValue);
/* 456 */         int i = tInteger.intValue();
/* 457 */         this.minAppAge = i;
/*     */       }
/*     */     }
/* 460 */     if (FCode.equalsIgnoreCase("mAXAppAgeFlag"))
/*     */     {
/* 462 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 464 */         this.mAXAppAgeFlag = FValue.trim();
/*     */       }
/*     */       else
/* 467 */         this.mAXAppAgeFlag = null;
/*     */     }
/* 469 */     if (FCode.equalsIgnoreCase("mAXAppAge"))
/*     */     {
/* 471 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 473 */         Integer tInteger = new Integer(FValue);
/* 474 */         int i = tInteger.intValue();
/* 475 */         this.mAXAppAge = i;
/*     */       }
/*     */     }
/* 478 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 483 */     if (otherObject == null) return false;
/* 484 */     if (this == otherObject) return true;
/* 485 */     if (getClass() != otherObject.getClass()) return false;
/* 486 */     LNPRiskRoleSchema other = (LNPRiskRoleSchema)otherObject;
/* 487 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 488 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 489 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/* 490 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/* 491 */     if ((this.riskRole == null) && (other.getRiskRole() != null)) return false;
/* 492 */     if ((this.riskRole != null) && (!this.riskRole.equals(other.getRiskRole()))) return false;
/* 493 */     if ((this.riskRoleSex == null) && (other.getRiskRoleSex() != null)) return false;
/* 494 */     if ((this.riskRoleSex != null) && (!this.riskRoleSex.equals(other.getRiskRoleSex()))) return false;
/* 495 */     if ((this.riskRoleNo == null) && (other.getRiskRoleNo() != null)) return false;
/* 496 */     if ((this.riskRoleNo != null) && (!this.riskRoleNo.equals(other.getRiskRoleNo()))) return false;
/* 497 */     if ((this.minAppAgeFlag == null) && (other.getMinAppAgeFlag() != null)) return false;
/* 498 */     if ((this.minAppAgeFlag != null) && (!this.minAppAgeFlag.equals(other.getMinAppAgeFlag()))) return false;
/* 499 */     if (this.minAppAge != other.getMinAppAge()) return false;
/* 500 */     if ((this.mAXAppAgeFlag == null) && (other.getMAXAppAgeFlag() != null)) return false;
/* 501 */     if ((this.mAXAppAgeFlag != null) && (!this.mAXAppAgeFlag.equals(other.getMAXAppAgeFlag()))) return false;
/* 502 */     return this.mAXAppAge == other.getMAXAppAge();
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 509 */     return 9;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 515 */     if (strFieldName.equals("riskCode")) {
/* 516 */       return 0;
/*     */     }
/* 518 */     if (strFieldName.equals("riskVer")) {
/* 519 */       return 1;
/*     */     }
/* 521 */     if (strFieldName.equals("riskRole")) {
/* 522 */       return 2;
/*     */     }
/* 524 */     if (strFieldName.equals("riskRoleSex")) {
/* 525 */       return 3;
/*     */     }
/* 527 */     if (strFieldName.equals("riskRoleNo")) {
/* 528 */       return 4;
/*     */     }
/* 530 */     if (strFieldName.equals("minAppAgeFlag")) {
/* 531 */       return 5;
/*     */     }
/* 533 */     if (strFieldName.equals("minAppAge")) {
/* 534 */       return 6;
/*     */     }
/* 536 */     if (strFieldName.equals("mAXAppAgeFlag")) {
/* 537 */       return 7;
/*     */     }
/* 539 */     if (strFieldName.equals("mAXAppAge")) {
/* 540 */       return 8;
/*     */     }
/* 542 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 548 */     String strFieldName = "";
/* 549 */     switch (nFieldIndex) {
/*     */     case 0:
/* 551 */       strFieldName = "riskCode";
/* 552 */       break;
/*     */     case 1:
/* 554 */       strFieldName = "riskVer";
/* 555 */       break;
/*     */     case 2:
/* 557 */       strFieldName = "riskRole";
/* 558 */       break;
/*     */     case 3:
/* 560 */       strFieldName = "riskRoleSex";
/* 561 */       break;
/*     */     case 4:
/* 563 */       strFieldName = "riskRoleNo";
/* 564 */       break;
/*     */     case 5:
/* 566 */       strFieldName = "minAppAgeFlag";
/* 567 */       break;
/*     */     case 6:
/* 569 */       strFieldName = "minAppAge";
/* 570 */       break;
/*     */     case 7:
/* 572 */       strFieldName = "mAXAppAgeFlag";
/* 573 */       break;
/*     */     case 8:
/* 575 */       strFieldName = "mAXAppAge";
/* 576 */       break;
/*     */     default:
/* 578 */       strFieldName = "";
/*     */     }
/* 580 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 586 */     if (strFieldName.equals("riskCode")) {
/* 587 */       return 0;
/*     */     }
/* 589 */     if (strFieldName.equals("riskVer")) {
/* 590 */       return 0;
/*     */     }
/* 592 */     if (strFieldName.equals("riskRole")) {
/* 593 */       return 0;
/*     */     }
/* 595 */     if (strFieldName.equals("riskRoleSex")) {
/* 596 */       return 0;
/*     */     }
/* 598 */     if (strFieldName.equals("riskRoleNo")) {
/* 599 */       return 0;
/*     */     }
/* 601 */     if (strFieldName.equals("minAppAgeFlag")) {
/* 602 */       return 0;
/*     */     }
/* 604 */     if (strFieldName.equals("minAppAge")) {
/* 605 */       return 3;
/*     */     }
/* 607 */     if (strFieldName.equals("mAXAppAgeFlag")) {
/* 608 */       return 0;
/*     */     }
/* 610 */     if (strFieldName.equals("mAXAppAge")) {
/* 611 */       return 3;
/*     */     }
/* 613 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 619 */     int nFieldType = -1;
/* 620 */     switch (nFieldIndex) {
/*     */     case 0:
/* 622 */       nFieldType = 0;
/* 623 */       break;
/*     */     case 1:
/* 625 */       nFieldType = 0;
/* 626 */       break;
/*     */     case 2:
/* 628 */       nFieldType = 0;
/* 629 */       break;
/*     */     case 3:
/* 631 */       nFieldType = 0;
/* 632 */       break;
/*     */     case 4:
/* 634 */       nFieldType = 0;
/* 635 */       break;
/*     */     case 5:
/* 637 */       nFieldType = 0;
/* 638 */       break;
/*     */     case 6:
/* 640 */       nFieldType = 3;
/* 641 */       break;
/*     */     case 7:
/* 643 */       nFieldType = 0;
/* 644 */       break;
/*     */     case 8:
/* 646 */       nFieldType = 3;
/* 647 */       break;
/*     */     default:
/* 649 */       nFieldType = -1;
/*     */     }
/* 651 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema
 * JD-Core Version:    0.6.0
 */