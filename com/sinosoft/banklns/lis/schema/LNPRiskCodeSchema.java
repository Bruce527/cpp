/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskCodeDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskCodeSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String riskVer;
/*     */   private String riskName;
/*     */   private String kindCode;
/*     */   private String riskType;
/*     */   private String sysRiskCode;
/*     */   private String mappingRiskCode;
/*     */   private String riskCodeBy1;
/*     */   private String riskCodeBy2;
/*     */   private String riskCodeBy3;
/*     */   private String riskCodeBy4;
/*     */   private String riskCodeBy5;
/*     */   public static final int FIELDNUM = 12;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskCodeSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[1];
/*  59 */     pk[0] = "RiskCode";
/*     */ 
/*  61 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  68 */     LNPRiskCodeSchema cloned = (LNPRiskCodeSchema)super.clone();
/*  69 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  70 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  76 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/*  81 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  85 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskVer() {
/*  89 */     return this.riskVer;
/*     */   }
/*     */ 
/*     */   public void setRiskVer(String aRiskVer) {
/*  93 */     this.riskVer = aRiskVer;
/*     */   }
/*     */ 
/*     */   public String getRiskName() {
/*  97 */     return this.riskName;
/*     */   }
/*     */ 
/*     */   public void setRiskName(String aRiskName) {
/* 101 */     this.riskName = aRiskName;
/*     */   }
/*     */ 
/*     */   public String getKindCode() {
/* 105 */     return this.kindCode;
/*     */   }
/*     */ 
/*     */   public void setKindCode(String aKindCode) {
/* 109 */     this.kindCode = aKindCode;
/*     */   }
/*     */ 
/*     */   public String getRiskType() {
/* 113 */     return this.riskType;
/*     */   }
/*     */ 
/*     */   public void setRiskType(String aRiskType) {
/* 117 */     this.riskType = aRiskType;
/*     */   }
/*     */ 
/*     */   public String getSysRiskCode() {
/* 121 */     return this.sysRiskCode;
/*     */   }
/*     */ 
/*     */   public void setSysRiskCode(String aSysRiskCode) {
/* 125 */     this.sysRiskCode = aSysRiskCode;
/*     */   }
/*     */ 
/*     */   public String getMappingRiskCode() {
/* 129 */     return this.mappingRiskCode;
/*     */   }
/*     */ 
/*     */   public void setMappingRiskCode(String aMappingRiskCode) {
/* 133 */     this.mappingRiskCode = aMappingRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCodeBy1() {
/* 137 */     return this.riskCodeBy1;
/*     */   }
/*     */ 
/*     */   public void setRiskCodeBy1(String aRiskCodeBy1) {
/* 141 */     this.riskCodeBy1 = aRiskCodeBy1;
/*     */   }
/*     */ 
/*     */   public String getRiskCodeBy2() {
/* 145 */     return this.riskCodeBy2;
/*     */   }
/*     */ 
/*     */   public void setRiskCodeBy2(String aRiskCodeBy2) {
/* 149 */     this.riskCodeBy2 = aRiskCodeBy2;
/*     */   }
/*     */ 
/*     */   public String getRiskCodeBy3() {
/* 153 */     return this.riskCodeBy3;
/*     */   }
/*     */ 
/*     */   public void setRiskCodeBy3(String aRiskCodeBy3) {
/* 157 */     this.riskCodeBy3 = aRiskCodeBy3;
/*     */   }
/*     */ 
/*     */   public String getRiskCodeBy4() {
/* 161 */     return this.riskCodeBy4;
/*     */   }
/*     */ 
/*     */   public void setRiskCodeBy4(String aRiskCodeBy4) {
/* 165 */     this.riskCodeBy4 = aRiskCodeBy4;
/*     */   }
/*     */ 
/*     */   public String getRiskCodeBy5() {
/* 169 */     return this.riskCodeBy5;
/*     */   }
/*     */ 
/*     */   public void setRiskCodeBy5(String aRiskCodeBy5) {
/* 173 */     this.riskCodeBy5 = aRiskCodeBy5;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskCodeSchema aLNPRiskCodeSchema)
/*     */   {
/* 179 */     this.riskCode = aLNPRiskCodeSchema.getRiskCode();
/* 180 */     this.riskVer = aLNPRiskCodeSchema.getRiskVer();
/* 181 */     this.riskName = aLNPRiskCodeSchema.getRiskName();
/* 182 */     this.kindCode = aLNPRiskCodeSchema.getKindCode();
/* 183 */     this.riskType = aLNPRiskCodeSchema.getRiskType();
/* 184 */     this.sysRiskCode = aLNPRiskCodeSchema.getSysRiskCode();
/* 185 */     this.mappingRiskCode = aLNPRiskCodeSchema.getMappingRiskCode();
/* 186 */     this.riskCodeBy1 = aLNPRiskCodeSchema.getRiskCodeBy1();
/* 187 */     this.riskCodeBy2 = aLNPRiskCodeSchema.getRiskCodeBy2();
/* 188 */     this.riskCodeBy3 = aLNPRiskCodeSchema.getRiskCodeBy3();
/* 189 */     this.riskCodeBy4 = aLNPRiskCodeSchema.getRiskCodeBy4();
/* 190 */     this.riskCodeBy5 = aLNPRiskCodeSchema.getRiskCodeBy5();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 199 */       if (rs.getString("RiskCode") == null)
/* 200 */         this.riskCode = null;
/*     */       else {
/* 202 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 204 */       if (rs.getString("RiskVer") == null)
/* 205 */         this.riskVer = null;
/*     */       else {
/* 207 */         this.riskVer = rs.getString("RiskVer").trim();
/*     */       }
/* 209 */       if (rs.getString("RiskName") == null)
/* 210 */         this.riskName = null;
/*     */       else {
/* 212 */         this.riskName = rs.getString("RiskName").trim();
/*     */       }
/* 214 */       if (rs.getString("KindCode") == null)
/* 215 */         this.kindCode = null;
/*     */       else {
/* 217 */         this.kindCode = rs.getString("KindCode").trim();
/*     */       }
/* 219 */       if (rs.getString("RiskType") == null)
/* 220 */         this.riskType = null;
/*     */       else {
/* 222 */         this.riskType = rs.getString("RiskType").trim();
/*     */       }
/* 224 */       if (rs.getString("SysRiskCode") == null)
/* 225 */         this.sysRiskCode = null;
/*     */       else {
/* 227 */         this.sysRiskCode = rs.getString("SysRiskCode").trim();
/*     */       }
/* 229 */       if (rs.getString("MappingRiskCode") == null)
/* 230 */         this.mappingRiskCode = null;
/*     */       else {
/* 232 */         this.mappingRiskCode = rs.getString("MappingRiskCode").trim();
/*     */       }
/* 234 */       if (rs.getString("RiskCodeBy1") == null)
/* 235 */         this.riskCodeBy1 = null;
/*     */       else {
/* 237 */         this.riskCodeBy1 = rs.getString("RiskCodeBy1").trim();
/*     */       }
/* 239 */       if (rs.getString("RiskCodeBy2") == null)
/* 240 */         this.riskCodeBy2 = null;
/*     */       else {
/* 242 */         this.riskCodeBy2 = rs.getString("RiskCodeBy2").trim();
/*     */       }
/* 244 */       if (rs.getString("RiskCodeBy3") == null)
/* 245 */         this.riskCodeBy3 = null;
/*     */       else {
/* 247 */         this.riskCodeBy3 = rs.getString("RiskCodeBy3").trim();
/*     */       }
/* 249 */       if (rs.getString("RiskCodeBy4") == null)
/* 250 */         this.riskCodeBy4 = null;
/*     */       else {
/* 252 */         this.riskCodeBy4 = rs.getString("RiskCodeBy4").trim();
/*     */       }
/* 254 */       if (rs.getString("RiskCodeBy5") == null)
/* 255 */         this.riskCodeBy5 = null;
/*     */       else {
/* 257 */         this.riskCodeBy5 = rs.getString("RiskCodeBy5").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 262 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskCode\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 264 */       CError tError = new CError();
/* 265 */       tError.moduleName = "LNPRiskCodeSchema";
/* 266 */       tError.functionName = "setSchema";
/* 267 */       tError.errorMessage = sqle.toString();
/* 268 */       this.mErrors.addOneError(tError);
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskCodeSchema getSchema()
/*     */   {
/* 276 */     LNPRiskCodeSchema aLNPRiskCodeSchema = new LNPRiskCodeSchema();
/* 277 */     aLNPRiskCodeSchema.setSchema(this);
/* 278 */     return aLNPRiskCodeSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskCodeDB getDB()
/*     */   {
/* 283 */     LNPRiskCodeDB aDBOper = new LNPRiskCodeDB();
/* 284 */     aDBOper.setSchema(this);
/* 285 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 292 */     StringBuffer strReturn = new StringBuffer(256);
/* 293 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 294 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/* 295 */     strReturn.append(StrTool.cTrim(this.riskName)); strReturn.append("|");
/* 296 */     strReturn.append(StrTool.cTrim(this.kindCode)); strReturn.append("|");
/* 297 */     strReturn.append(StrTool.cTrim(this.riskType)); strReturn.append("|");
/* 298 */     strReturn.append(StrTool.cTrim(this.sysRiskCode)); strReturn.append("|");
/* 299 */     strReturn.append(StrTool.cTrim(this.mappingRiskCode)); strReturn.append("|");
/* 300 */     strReturn.append(StrTool.cTrim(this.riskCodeBy1)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.riskCodeBy2)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.riskCodeBy3)); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.riskCodeBy4)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.riskCodeBy5));
/* 305 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 313 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 314 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 315 */       this.riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 316 */       this.kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 317 */       this.riskType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 318 */       this.sysRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 319 */       this.mappingRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 320 */       this.riskCodeBy1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 321 */       this.riskCodeBy2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 322 */       this.riskCodeBy3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 323 */       this.riskCodeBy4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 324 */       this.riskCodeBy5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 329 */       CError tError = new CError();
/* 330 */       tError.moduleName = "LNPRiskCodeSchema";
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
/* 344 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 346 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 348 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 350 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*     */     }
/* 352 */     if (FCode.equalsIgnoreCase("riskName"))
/*     */     {
/* 354 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskName));
/*     */     }
/* 356 */     if (FCode.equalsIgnoreCase("kindCode"))
/*     */     {
/* 358 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.kindCode));
/*     */     }
/* 360 */     if (FCode.equalsIgnoreCase("riskType"))
/*     */     {
/* 362 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskType));
/*     */     }
/* 364 */     if (FCode.equalsIgnoreCase("sysRiskCode"))
/*     */     {
/* 366 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sysRiskCode));
/*     */     }
/* 368 */     if (FCode.equalsIgnoreCase("mappingRiskCode"))
/*     */     {
/* 370 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mappingRiskCode));
/*     */     }
/* 372 */     if (FCode.equalsIgnoreCase("riskCodeBy1"))
/*     */     {
/* 374 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCodeBy1));
/*     */     }
/* 376 */     if (FCode.equalsIgnoreCase("riskCodeBy2"))
/*     */     {
/* 378 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCodeBy2));
/*     */     }
/* 380 */     if (FCode.equalsIgnoreCase("riskCodeBy3"))
/*     */     {
/* 382 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCodeBy3));
/*     */     }
/* 384 */     if (FCode.equalsIgnoreCase("riskCodeBy4"))
/*     */     {
/* 386 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCodeBy4));
/*     */     }
/* 388 */     if (FCode.equalsIgnoreCase("riskCodeBy5"))
/*     */     {
/* 390 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCodeBy5));
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
/* 407 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 408 */       break;
/*     */     case 1:
/* 410 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/* 411 */       break;
/*     */     case 2:
/* 413 */       strFieldValue = StrTool.GBKToUnicode(this.riskName);
/* 414 */       break;
/*     */     case 3:
/* 416 */       strFieldValue = StrTool.GBKToUnicode(this.kindCode);
/* 417 */       break;
/*     */     case 4:
/* 419 */       strFieldValue = StrTool.GBKToUnicode(this.riskType);
/* 420 */       break;
/*     */     case 5:
/* 422 */       strFieldValue = StrTool.GBKToUnicode(this.sysRiskCode);
/* 423 */       break;
/*     */     case 6:
/* 425 */       strFieldValue = StrTool.GBKToUnicode(this.mappingRiskCode);
/* 426 */       break;
/*     */     case 7:
/* 428 */       strFieldValue = StrTool.GBKToUnicode(this.riskCodeBy1);
/* 429 */       break;
/*     */     case 8:
/* 431 */       strFieldValue = StrTool.GBKToUnicode(this.riskCodeBy2);
/* 432 */       break;
/*     */     case 9:
/* 434 */       strFieldValue = StrTool.GBKToUnicode(this.riskCodeBy3);
/* 435 */       break;
/*     */     case 10:
/* 437 */       strFieldValue = StrTool.GBKToUnicode(this.riskCodeBy4);
/* 438 */       break;
/*     */     case 11:
/* 440 */       strFieldValue = StrTool.GBKToUnicode(this.riskCodeBy5);
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
/* 457 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 459 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 461 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 464 */         this.riskCode = null;
/*     */     }
/* 466 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 468 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 470 */         this.riskVer = FValue.trim();
/*     */       }
/*     */       else
/* 473 */         this.riskVer = null;
/*     */     }
/* 475 */     if (FCode.equalsIgnoreCase("riskName"))
/*     */     {
/* 477 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 479 */         this.riskName = FValue.trim();
/*     */       }
/*     */       else
/* 482 */         this.riskName = null;
/*     */     }
/* 484 */     if (FCode.equalsIgnoreCase("kindCode"))
/*     */     {
/* 486 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 488 */         this.kindCode = FValue.trim();
/*     */       }
/*     */       else
/* 491 */         this.kindCode = null;
/*     */     }
/* 493 */     if (FCode.equalsIgnoreCase("riskType"))
/*     */     {
/* 495 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 497 */         this.riskType = FValue.trim();
/*     */       }
/*     */       else
/* 500 */         this.riskType = null;
/*     */     }
/* 502 */     if (FCode.equalsIgnoreCase("sysRiskCode"))
/*     */     {
/* 504 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 506 */         this.sysRiskCode = FValue.trim();
/*     */       }
/*     */       else
/* 509 */         this.sysRiskCode = null;
/*     */     }
/* 511 */     if (FCode.equalsIgnoreCase("mappingRiskCode"))
/*     */     {
/* 513 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 515 */         this.mappingRiskCode = FValue.trim();
/*     */       }
/*     */       else
/* 518 */         this.mappingRiskCode = null;
/*     */     }
/* 520 */     if (FCode.equalsIgnoreCase("riskCodeBy1"))
/*     */     {
/* 522 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 524 */         this.riskCodeBy1 = FValue.trim();
/*     */       }
/*     */       else
/* 527 */         this.riskCodeBy1 = null;
/*     */     }
/* 529 */     if (FCode.equalsIgnoreCase("riskCodeBy2"))
/*     */     {
/* 531 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 533 */         this.riskCodeBy2 = FValue.trim();
/*     */       }
/*     */       else
/* 536 */         this.riskCodeBy2 = null;
/*     */     }
/* 538 */     if (FCode.equalsIgnoreCase("riskCodeBy3"))
/*     */     {
/* 540 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 542 */         this.riskCodeBy3 = FValue.trim();
/*     */       }
/*     */       else
/* 545 */         this.riskCodeBy3 = null;
/*     */     }
/* 547 */     if (FCode.equalsIgnoreCase("riskCodeBy4"))
/*     */     {
/* 549 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 551 */         this.riskCodeBy4 = FValue.trim();
/*     */       }
/*     */       else
/* 554 */         this.riskCodeBy4 = null;
/*     */     }
/* 556 */     if (FCode.equalsIgnoreCase("riskCodeBy5"))
/*     */     {
/* 558 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 560 */         this.riskCodeBy5 = FValue.trim();
/*     */       }
/*     */       else
/* 563 */         this.riskCodeBy5 = null;
/*     */     }
/* 565 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 570 */     if (otherObject == null) return false;
/* 571 */     if (this == otherObject) return true;
/* 572 */     if (getClass() != otherObject.getClass()) return false;
/* 573 */     LNPRiskCodeSchema other = (LNPRiskCodeSchema)otherObject;
/* 574 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 575 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 576 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/* 577 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/* 578 */     if ((this.riskName == null) && (other.getRiskName() != null)) return false;
/* 579 */     if ((this.riskName != null) && (!this.riskName.equals(other.getRiskName()))) return false;
/* 580 */     if ((this.kindCode == null) && (other.getKindCode() != null)) return false;
/* 581 */     if ((this.kindCode != null) && (!this.kindCode.equals(other.getKindCode()))) return false;
/* 582 */     if ((this.riskType == null) && (other.getRiskType() != null)) return false;
/* 583 */     if ((this.riskType != null) && (!this.riskType.equals(other.getRiskType()))) return false;
/* 584 */     if ((this.sysRiskCode == null) && (other.getSysRiskCode() != null)) return false;
/* 585 */     if ((this.sysRiskCode != null) && (!this.sysRiskCode.equals(other.getSysRiskCode()))) return false;
/* 586 */     if ((this.mappingRiskCode == null) && (other.getMappingRiskCode() != null)) return false;
/* 587 */     if ((this.mappingRiskCode != null) && (!this.mappingRiskCode.equals(other.getMappingRiskCode()))) return false;
/* 588 */     if ((this.riskCodeBy1 == null) && (other.getRiskCodeBy1() != null)) return false;
/* 589 */     if ((this.riskCodeBy1 != null) && (!this.riskCodeBy1.equals(other.getRiskCodeBy1()))) return false;
/* 590 */     if ((this.riskCodeBy2 == null) && (other.getRiskCodeBy2() != null)) return false;
/* 591 */     if ((this.riskCodeBy2 != null) && (!this.riskCodeBy2.equals(other.getRiskCodeBy2()))) return false;
/* 592 */     if ((this.riskCodeBy3 == null) && (other.getRiskCodeBy3() != null)) return false;
/* 593 */     if ((this.riskCodeBy3 != null) && (!this.riskCodeBy3.equals(other.getRiskCodeBy3()))) return false;
/* 594 */     if ((this.riskCodeBy4 == null) && (other.getRiskCodeBy4() != null)) return false;
/* 595 */     if ((this.riskCodeBy4 != null) && (!this.riskCodeBy4.equals(other.getRiskCodeBy4()))) return false;
/* 596 */     if ((this.riskCodeBy5 == null) && (other.getRiskCodeBy5() != null)) return false;
/* 597 */     return (this.riskCodeBy5 == null) || (this.riskCodeBy5.equals(other.getRiskCodeBy5()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 604 */     return 12;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 610 */     if (strFieldName.equals("riskCode")) {
/* 611 */       return 0;
/*     */     }
/* 613 */     if (strFieldName.equals("riskVer")) {
/* 614 */       return 1;
/*     */     }
/* 616 */     if (strFieldName.equals("riskName")) {
/* 617 */       return 2;
/*     */     }
/* 619 */     if (strFieldName.equals("kindCode")) {
/* 620 */       return 3;
/*     */     }
/* 622 */     if (strFieldName.equals("riskType")) {
/* 623 */       return 4;
/*     */     }
/* 625 */     if (strFieldName.equals("sysRiskCode")) {
/* 626 */       return 5;
/*     */     }
/* 628 */     if (strFieldName.equals("mappingRiskCode")) {
/* 629 */       return 6;
/*     */     }
/* 631 */     if (strFieldName.equals("riskCodeBy1")) {
/* 632 */       return 7;
/*     */     }
/* 634 */     if (strFieldName.equals("riskCodeBy2")) {
/* 635 */       return 8;
/*     */     }
/* 637 */     if (strFieldName.equals("riskCodeBy3")) {
/* 638 */       return 9;
/*     */     }
/* 640 */     if (strFieldName.equals("riskCodeBy4")) {
/* 641 */       return 10;
/*     */     }
/* 643 */     if (strFieldName.equals("riskCodeBy5")) {
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
/* 655 */       strFieldName = "riskCode";
/* 656 */       break;
/*     */     case 1:
/* 658 */       strFieldName = "riskVer";
/* 659 */       break;
/*     */     case 2:
/* 661 */       strFieldName = "riskName";
/* 662 */       break;
/*     */     case 3:
/* 664 */       strFieldName = "kindCode";
/* 665 */       break;
/*     */     case 4:
/* 667 */       strFieldName = "riskType";
/* 668 */       break;
/*     */     case 5:
/* 670 */       strFieldName = "sysRiskCode";
/* 671 */       break;
/*     */     case 6:
/* 673 */       strFieldName = "mappingRiskCode";
/* 674 */       break;
/*     */     case 7:
/* 676 */       strFieldName = "riskCodeBy1";
/* 677 */       break;
/*     */     case 8:
/* 679 */       strFieldName = "riskCodeBy2";
/* 680 */       break;
/*     */     case 9:
/* 682 */       strFieldName = "riskCodeBy3";
/* 683 */       break;
/*     */     case 10:
/* 685 */       strFieldName = "riskCodeBy4";
/* 686 */       break;
/*     */     case 11:
/* 688 */       strFieldName = "riskCodeBy5";
/* 689 */       break;
/*     */     default:
/* 691 */       strFieldName = "";
/*     */     }
/* 693 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 699 */     if (strFieldName.equals("riskCode")) {
/* 700 */       return 0;
/*     */     }
/* 702 */     if (strFieldName.equals("riskVer")) {
/* 703 */       return 0;
/*     */     }
/* 705 */     if (strFieldName.equals("riskName")) {
/* 706 */       return 0;
/*     */     }
/* 708 */     if (strFieldName.equals("kindCode")) {
/* 709 */       return 0;
/*     */     }
/* 711 */     if (strFieldName.equals("riskType")) {
/* 712 */       return 0;
/*     */     }
/* 714 */     if (strFieldName.equals("sysRiskCode")) {
/* 715 */       return 0;
/*     */     }
/* 717 */     if (strFieldName.equals("mappingRiskCode")) {
/* 718 */       return 0;
/*     */     }
/* 720 */     if (strFieldName.equals("riskCodeBy1")) {
/* 721 */       return 0;
/*     */     }
/* 723 */     if (strFieldName.equals("riskCodeBy2")) {
/* 724 */       return 0;
/*     */     }
/* 726 */     if (strFieldName.equals("riskCodeBy3")) {
/* 727 */       return 0;
/*     */     }
/* 729 */     if (strFieldName.equals("riskCodeBy4")) {
/* 730 */       return 0;
/*     */     }
/* 732 */     if (strFieldName.equals("riskCodeBy5")) {
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskCodeSchema
 * JD-Core Version:    0.6.0
 */