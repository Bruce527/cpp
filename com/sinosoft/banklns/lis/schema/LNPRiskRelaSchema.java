/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskRelaDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskRelaSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String relaRiskCode;
/*     */   private String relaCode;
/*     */   private String manageComGrp;
/*     */   private String saleChnl;
/*     */   private int minAppntAge;
/*     */   private int maxAppntAge;
/*     */   private int maxInsuredAge;
/*     */   private int minInsuredAge;
/*     */   public static final int FIELDNUM = 9;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskRelaSchema()
/*     */   {
/*  50 */     this.mErrors = new CErrors();
/*     */ 
/*  52 */     String[] pk = new String[5];
/*  53 */     pk[0] = "RiskCode";
/*  54 */     pk[1] = "RelaRiskCode";
/*  55 */     pk[2] = "RelaCode";
/*  56 */     pk[3] = "ManageComGrp";
/*  57 */     pk[4] = "SaleChnl";
/*     */ 
/*  59 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  66 */     LNPRiskRelaSchema cloned = (LNPRiskRelaSchema)super.clone();
/*  67 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  68 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  74 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/*  79 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  83 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRelaRiskCode() {
/*  87 */     return this.relaRiskCode;
/*     */   }
/*     */ 
/*     */   public void setRelaRiskCode(String aRelaRiskCode) {
/*  91 */     this.relaRiskCode = aRelaRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRelaCode() {
/*  95 */     return this.relaCode;
/*     */   }
/*     */ 
/*     */   public void setRelaCode(String aRelaCode) {
/*  99 */     this.relaCode = aRelaCode;
/*     */   }
/*     */ 
/*     */   public String getManageComGrp() {
/* 103 */     return this.manageComGrp;
/*     */   }
/*     */ 
/*     */   public void setManageComGrp(String aManageComGrp) {
/* 107 */     this.manageComGrp = aManageComGrp;
/*     */   }
/*     */ 
/*     */   public String getSaleChnl() {
/* 111 */     return this.saleChnl;
/*     */   }
/*     */ 
/*     */   public void setSaleChnl(String aSaleChnl) {
/* 115 */     this.saleChnl = aSaleChnl;
/*     */   }
/*     */ 
/*     */   public int getMinAppntAge() {
/* 119 */     return this.minAppntAge;
/*     */   }
/*     */ 
/*     */   public void setMinAppntAge(int aMinAppntAge) {
/* 123 */     this.minAppntAge = aMinAppntAge;
/*     */   }
/*     */ 
/*     */   public void setMinAppntAge(String aMinAppntAge) {
/* 127 */     if ((aMinAppntAge != null) && (!aMinAppntAge.equals("")))
/*     */     {
/* 129 */       Integer tInteger = new Integer(aMinAppntAge);
/* 130 */       int i = tInteger.intValue();
/* 131 */       this.minAppntAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getMaxAppntAge()
/*     */   {
/* 137 */     return this.maxAppntAge;
/*     */   }
/*     */ 
/*     */   public void setMaxAppntAge(int aMaxAppntAge) {
/* 141 */     this.maxAppntAge = aMaxAppntAge;
/*     */   }
/*     */ 
/*     */   public void setMaxAppntAge(String aMaxAppntAge) {
/* 145 */     if ((aMaxAppntAge != null) && (!aMaxAppntAge.equals("")))
/*     */     {
/* 147 */       Integer tInteger = new Integer(aMaxAppntAge);
/* 148 */       int i = tInteger.intValue();
/* 149 */       this.maxAppntAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getMaxInsuredAge()
/*     */   {
/* 155 */     return this.maxInsuredAge;
/*     */   }
/*     */ 
/*     */   public void setMaxInsuredAge(int aMaxInsuredAge) {
/* 159 */     this.maxInsuredAge = aMaxInsuredAge;
/*     */   }
/*     */ 
/*     */   public void setMaxInsuredAge(String aMaxInsuredAge) {
/* 163 */     if ((aMaxInsuredAge != null) && (!aMaxInsuredAge.equals("")))
/*     */     {
/* 165 */       Integer tInteger = new Integer(aMaxInsuredAge);
/* 166 */       int i = tInteger.intValue();
/* 167 */       this.maxInsuredAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getMinInsuredAge()
/*     */   {
/* 173 */     return this.minInsuredAge;
/*     */   }
/*     */ 
/*     */   public void setMinInsuredAge(int aMinInsuredAge) {
/* 177 */     this.minInsuredAge = aMinInsuredAge;
/*     */   }
/*     */ 
/*     */   public void setMinInsuredAge(String aMinInsuredAge) {
/* 181 */     if ((aMinInsuredAge != null) && (!aMinInsuredAge.equals("")))
/*     */     {
/* 183 */       Integer tInteger = new Integer(aMinInsuredAge);
/* 184 */       int i = tInteger.intValue();
/* 185 */       this.minInsuredAge = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskRelaSchema aLNPRiskRelaSchema)
/*     */   {
/* 193 */     this.riskCode = aLNPRiskRelaSchema.getRiskCode();
/* 194 */     this.relaRiskCode = aLNPRiskRelaSchema.getRelaRiskCode();
/* 195 */     this.relaCode = aLNPRiskRelaSchema.getRelaCode();
/* 196 */     this.manageComGrp = aLNPRiskRelaSchema.getManageComGrp();
/* 197 */     this.saleChnl = aLNPRiskRelaSchema.getSaleChnl();
/* 198 */     this.minAppntAge = aLNPRiskRelaSchema.getMinAppntAge();
/* 199 */     this.maxAppntAge = aLNPRiskRelaSchema.getMaxAppntAge();
/* 200 */     this.maxInsuredAge = aLNPRiskRelaSchema.getMaxInsuredAge();
/* 201 */     this.minInsuredAge = aLNPRiskRelaSchema.getMinInsuredAge();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 210 */       if (rs.getString("RiskCode") == null)
/* 211 */         this.riskCode = null;
/*     */       else {
/* 213 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 215 */       if (rs.getString("RelaRiskCode") == null)
/* 216 */         this.relaRiskCode = null;
/*     */       else {
/* 218 */         this.relaRiskCode = rs.getString("RelaRiskCode").trim();
/*     */       }
/* 220 */       if (rs.getString("RelaCode") == null)
/* 221 */         this.relaCode = null;
/*     */       else {
/* 223 */         this.relaCode = rs.getString("RelaCode").trim();
/*     */       }
/* 225 */       if (rs.getString("ManageComGrp") == null)
/* 226 */         this.manageComGrp = null;
/*     */       else {
/* 228 */         this.manageComGrp = rs.getString("ManageComGrp").trim();
/*     */       }
/* 230 */       if (rs.getString("SaleChnl") == null)
/* 231 */         this.saleChnl = null;
/*     */       else {
/* 233 */         this.saleChnl = rs.getString("SaleChnl").trim();
/*     */       }
/* 235 */       this.minAppntAge = rs.getInt("MinAppntAge");
/* 236 */       this.maxAppntAge = rs.getInt("MaxAppntAge");
/* 237 */       this.maxInsuredAge = rs.getInt("MaxInsuredAge");
/* 238 */       this.minInsuredAge = rs.getInt("MinInsuredAge");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 242 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskRela\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 244 */       CError tError = new CError();
/* 245 */       tError.moduleName = "LNPRiskRelaSchema";
/* 246 */       tError.functionName = "setSchema";
/* 247 */       tError.errorMessage = sqle.toString();
/* 248 */       this.mErrors.addOneError(tError);
/* 249 */       return false;
/*     */     }
/* 251 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskRelaSchema getSchema()
/*     */   {
/* 256 */     LNPRiskRelaSchema aLNPRiskRelaSchema = new LNPRiskRelaSchema();
/* 257 */     aLNPRiskRelaSchema.setSchema(this);
/* 258 */     return aLNPRiskRelaSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskRelaDB getDB()
/*     */   {
/* 263 */     LNPRiskRelaDB aDBOper = new LNPRiskRelaDB();
/* 264 */     aDBOper.setSchema(this);
/* 265 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 272 */     StringBuffer strReturn = new StringBuffer(256);
/* 273 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 274 */     strReturn.append(StrTool.cTrim(this.relaRiskCode)); strReturn.append("|");
/* 275 */     strReturn.append(StrTool.cTrim(this.relaCode)); strReturn.append("|");
/* 276 */     strReturn.append(StrTool.cTrim(this.manageComGrp)); strReturn.append("|");
/* 277 */     strReturn.append(StrTool.cTrim(this.saleChnl)); strReturn.append("|");
/* 278 */     strReturn.append(ChgData.chgData(this.minAppntAge)); strReturn.append("|");
/* 279 */     strReturn.append(ChgData.chgData(this.maxAppntAge)); strReturn.append("|");
/* 280 */     strReturn.append(ChgData.chgData(this.maxInsuredAge)); strReturn.append("|");
/* 281 */     strReturn.append(ChgData.chgData(this.minInsuredAge));
/* 282 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 290 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 291 */       this.relaRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 292 */       this.relaCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 293 */       this.manageComGrp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 294 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 295 */       this.minAppntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/* 296 */       this.maxAppntAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/* 297 */       this.maxInsuredAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).intValue();
/* 298 */       this.minInsuredAge = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 303 */       CError tError = new CError();
/* 304 */       tError.moduleName = "LNPRiskRelaSchema";
/* 305 */       tError.functionName = "decode";
/* 306 */       tError.errorMessage = ex.toString();
/* 307 */       this.mErrors.addOneError(tError);
/*     */ 
/* 309 */       return false;
/*     */     }
/* 311 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 317 */     String strReturn = "";
/* 318 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 320 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 322 */     if (FCode.equalsIgnoreCase("relaRiskCode"))
/*     */     {
/* 324 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaRiskCode));
/*     */     }
/* 326 */     if (FCode.equalsIgnoreCase("relaCode"))
/*     */     {
/* 328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaCode));
/*     */     }
/* 330 */     if (FCode.equalsIgnoreCase("manageComGrp"))
/*     */     {
/* 332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageComGrp));
/*     */     }
/* 334 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*     */     {
/* 336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*     */     }
/* 338 */     if (FCode.equalsIgnoreCase("minAppntAge"))
/*     */     {
/* 340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minAppntAge));
/*     */     }
/* 342 */     if (FCode.equalsIgnoreCase("maxAppntAge"))
/*     */     {
/* 344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxAppntAge));
/*     */     }
/* 346 */     if (FCode.equalsIgnoreCase("maxInsuredAge"))
/*     */     {
/* 348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxInsuredAge));
/*     */     }
/* 350 */     if (FCode.equalsIgnoreCase("minInsuredAge"))
/*     */     {
/* 352 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minInsuredAge));
/*     */     }
/* 354 */     if (strReturn.equals(""))
/*     */     {
/* 356 */       strReturn = "null";
/*     */     }
/*     */ 
/* 359 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 366 */     String strFieldValue = "";
/* 367 */     switch (nFieldIndex) {
/*     */     case 0:
/* 369 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 370 */       break;
/*     */     case 1:
/* 372 */       strFieldValue = StrTool.GBKToUnicode(this.relaRiskCode);
/* 373 */       break;
/*     */     case 2:
/* 375 */       strFieldValue = StrTool.GBKToUnicode(this.relaCode);
/* 376 */       break;
/*     */     case 3:
/* 378 */       strFieldValue = StrTool.GBKToUnicode(this.manageComGrp);
/* 379 */       break;
/*     */     case 4:
/* 381 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 382 */       break;
/*     */     case 5:
/* 384 */       strFieldValue = String.valueOf(this.minAppntAge);
/* 385 */       break;
/*     */     case 6:
/* 387 */       strFieldValue = String.valueOf(this.maxAppntAge);
/* 388 */       break;
/*     */     case 7:
/* 390 */       strFieldValue = String.valueOf(this.maxInsuredAge);
/* 391 */       break;
/*     */     case 8:
/* 393 */       strFieldValue = String.valueOf(this.minInsuredAge);
/* 394 */       break;
/*     */     default:
/* 396 */       strFieldValue = "";
/*     */     }
/* 398 */     if (strFieldValue.equals("")) {
/* 399 */       strFieldValue = "null";
/*     */     }
/* 401 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 407 */     if (StrTool.cTrim(FCode).equals("")) {
/* 408 */       return false;
/*     */     }
/* 410 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 412 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 414 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 417 */         this.riskCode = null;
/*     */     }
/* 419 */     if (FCode.equalsIgnoreCase("relaRiskCode"))
/*     */     {
/* 421 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 423 */         this.relaRiskCode = FValue.trim();
/*     */       }
/*     */       else
/* 426 */         this.relaRiskCode = null;
/*     */     }
/* 428 */     if (FCode.equalsIgnoreCase("relaCode"))
/*     */     {
/* 430 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 432 */         this.relaCode = FValue.trim();
/*     */       }
/*     */       else
/* 435 */         this.relaCode = null;
/*     */     }
/* 437 */     if (FCode.equalsIgnoreCase("manageComGrp"))
/*     */     {
/* 439 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 441 */         this.manageComGrp = FValue.trim();
/*     */       }
/*     */       else
/* 444 */         this.manageComGrp = null;
/*     */     }
/* 446 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*     */     {
/* 448 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 450 */         this.saleChnl = FValue.trim();
/*     */       }
/*     */       else
/* 453 */         this.saleChnl = null;
/*     */     }
/* 455 */     if (FCode.equalsIgnoreCase("minAppntAge"))
/*     */     {
/* 457 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 459 */         Integer tInteger = new Integer(FValue);
/* 460 */         int i = tInteger.intValue();
/* 461 */         this.minAppntAge = i;
/*     */       }
/*     */     }
/* 464 */     if (FCode.equalsIgnoreCase("maxAppntAge"))
/*     */     {
/* 466 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 468 */         Integer tInteger = new Integer(FValue);
/* 469 */         int i = tInteger.intValue();
/* 470 */         this.maxAppntAge = i;
/*     */       }
/*     */     }
/* 473 */     if (FCode.equalsIgnoreCase("maxInsuredAge"))
/*     */     {
/* 475 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 477 */         Integer tInteger = new Integer(FValue);
/* 478 */         int i = tInteger.intValue();
/* 479 */         this.maxInsuredAge = i;
/*     */       }
/*     */     }
/* 482 */     if (FCode.equalsIgnoreCase("minInsuredAge"))
/*     */     {
/* 484 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 486 */         Integer tInteger = new Integer(FValue);
/* 487 */         int i = tInteger.intValue();
/* 488 */         this.minInsuredAge = i;
/*     */       }
/*     */     }
/* 491 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 496 */     if (otherObject == null) return false;
/* 497 */     if (this == otherObject) return true;
/* 498 */     if (getClass() != otherObject.getClass()) return false;
/* 499 */     LNPRiskRelaSchema other = (LNPRiskRelaSchema)otherObject;
/* 500 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 501 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 502 */     if ((this.relaRiskCode == null) && (other.getRelaRiskCode() != null)) return false;
/* 503 */     if ((this.relaRiskCode != null) && (!this.relaRiskCode.equals(other.getRelaRiskCode()))) return false;
/* 504 */     if ((this.relaCode == null) && (other.getRelaCode() != null)) return false;
/* 505 */     if ((this.relaCode != null) && (!this.relaCode.equals(other.getRelaCode()))) return false;
/* 506 */     if ((this.manageComGrp == null) && (other.getManageComGrp() != null)) return false;
/* 507 */     if ((this.manageComGrp != null) && (!this.manageComGrp.equals(other.getManageComGrp()))) return false;
/* 508 */     if ((this.saleChnl == null) && (other.getSaleChnl() != null)) return false;
/* 509 */     if ((this.saleChnl != null) && (!this.saleChnl.equals(other.getSaleChnl()))) return false;
/* 510 */     if (this.minAppntAge != other.getMinAppntAge()) return false;
/* 511 */     if (this.maxAppntAge != other.getMaxAppntAge()) return false;
/* 512 */     if (this.maxInsuredAge != other.getMaxInsuredAge()) return false;
/* 513 */     return this.minInsuredAge == other.getMinInsuredAge();
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 520 */     return 9;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 526 */     if (strFieldName.equals("riskCode")) {
/* 527 */       return 0;
/*     */     }
/* 529 */     if (strFieldName.equals("relaRiskCode")) {
/* 530 */       return 1;
/*     */     }
/* 532 */     if (strFieldName.equals("relaCode")) {
/* 533 */       return 2;
/*     */     }
/* 535 */     if (strFieldName.equals("manageComGrp")) {
/* 536 */       return 3;
/*     */     }
/* 538 */     if (strFieldName.equals("saleChnl")) {
/* 539 */       return 4;
/*     */     }
/* 541 */     if (strFieldName.equals("minAppntAge")) {
/* 542 */       return 5;
/*     */     }
/* 544 */     if (strFieldName.equals("maxAppntAge")) {
/* 545 */       return 6;
/*     */     }
/* 547 */     if (strFieldName.equals("maxInsuredAge")) {
/* 548 */       return 7;
/*     */     }
/* 550 */     if (strFieldName.equals("minInsuredAge")) {
/* 551 */       return 8;
/*     */     }
/* 553 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 559 */     String strFieldName = "";
/* 560 */     switch (nFieldIndex) {
/*     */     case 0:
/* 562 */       strFieldName = "riskCode";
/* 563 */       break;
/*     */     case 1:
/* 565 */       strFieldName = "relaRiskCode";
/* 566 */       break;
/*     */     case 2:
/* 568 */       strFieldName = "relaCode";
/* 569 */       break;
/*     */     case 3:
/* 571 */       strFieldName = "manageComGrp";
/* 572 */       break;
/*     */     case 4:
/* 574 */       strFieldName = "saleChnl";
/* 575 */       break;
/*     */     case 5:
/* 577 */       strFieldName = "minAppntAge";
/* 578 */       break;
/*     */     case 6:
/* 580 */       strFieldName = "maxAppntAge";
/* 581 */       break;
/*     */     case 7:
/* 583 */       strFieldName = "maxInsuredAge";
/* 584 */       break;
/*     */     case 8:
/* 586 */       strFieldName = "minInsuredAge";
/* 587 */       break;
/*     */     default:
/* 589 */       strFieldName = "";
/*     */     }
/* 591 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 597 */     if (strFieldName.equals("riskCode")) {
/* 598 */       return 0;
/*     */     }
/* 600 */     if (strFieldName.equals("relaRiskCode")) {
/* 601 */       return 0;
/*     */     }
/* 603 */     if (strFieldName.equals("relaCode")) {
/* 604 */       return 0;
/*     */     }
/* 606 */     if (strFieldName.equals("manageComGrp")) {
/* 607 */       return 0;
/*     */     }
/* 609 */     if (strFieldName.equals("saleChnl")) {
/* 610 */       return 0;
/*     */     }
/* 612 */     if (strFieldName.equals("minAppntAge")) {
/* 613 */       return 3;
/*     */     }
/* 615 */     if (strFieldName.equals("maxAppntAge")) {
/* 616 */       return 3;
/*     */     }
/* 618 */     if (strFieldName.equals("maxInsuredAge")) {
/* 619 */       return 3;
/*     */     }
/* 621 */     if (strFieldName.equals("minInsuredAge")) {
/* 622 */       return 3;
/*     */     }
/* 624 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 630 */     int nFieldType = -1;
/* 631 */     switch (nFieldIndex) {
/*     */     case 0:
/* 633 */       nFieldType = 0;
/* 634 */       break;
/*     */     case 1:
/* 636 */       nFieldType = 0;
/* 637 */       break;
/*     */     case 2:
/* 639 */       nFieldType = 0;
/* 640 */       break;
/*     */     case 3:
/* 642 */       nFieldType = 0;
/* 643 */       break;
/*     */     case 4:
/* 645 */       nFieldType = 0;
/* 646 */       break;
/*     */     case 5:
/* 648 */       nFieldType = 3;
/* 649 */       break;
/*     */     case 6:
/* 651 */       nFieldType = 3;
/* 652 */       break;
/*     */     case 7:
/* 654 */       nFieldType = 3;
/* 655 */       break;
/*     */     case 8:
/* 657 */       nFieldType = 3;
/* 658 */       break;
/*     */     default:
/* 660 */       nFieldType = -1;
/*     */     }
/* 662 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskRelaSchema
 * JD-Core Version:    0.6.0
 */