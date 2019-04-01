/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskDutyDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskDutySchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String riskVer;
/*     */   private String dutyCode;
/*     */   private String choFlag;
/*     */   private String specFlag;
/*     */   public static final int FIELDNUM = 5;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskDutySchema()
/*     */   {
/*  42 */     this.mErrors = new CErrors();
/*     */ 
/*  44 */     String[] pk = new String[2];
/*  45 */     pk[0] = "RiskCode";
/*  46 */     pk[1] = "DutyCode";
/*     */ 
/*  48 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  55 */     LNPRiskDutySchema cloned = (LNPRiskDutySchema)super.clone();
/*  56 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  57 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  63 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getRiskCode()
/*     */   {
/*  68 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  72 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getRiskVer() {
/*  76 */     return this.riskVer;
/*     */   }
/*     */ 
/*     */   public void setRiskVer(String aRiskVer) {
/*  80 */     this.riskVer = aRiskVer;
/*     */   }
/*     */ 
/*     */   public String getDutyCode() {
/*  84 */     return this.dutyCode;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String aDutyCode) {
/*  88 */     this.dutyCode = aDutyCode;
/*     */   }
/*     */ 
/*     */   public String getChoFlag() {
/*  92 */     return this.choFlag;
/*     */   }
/*     */ 
/*     */   public void setChoFlag(String aChoFlag) {
/*  96 */     this.choFlag = aChoFlag;
/*     */   }
/*     */ 
/*     */   public String getSpecFlag() {
/* 100 */     return this.specFlag;
/*     */   }
/*     */ 
/*     */   public void setSpecFlag(String aSpecFlag) {
/* 104 */     this.specFlag = aSpecFlag;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskDutySchema aLNPRiskDutySchema)
/*     */   {
/* 110 */     this.riskCode = aLNPRiskDutySchema.getRiskCode();
/* 111 */     this.riskVer = aLNPRiskDutySchema.getRiskVer();
/* 112 */     this.dutyCode = aLNPRiskDutySchema.getDutyCode();
/* 113 */     this.choFlag = aLNPRiskDutySchema.getChoFlag();
/* 114 */     this.specFlag = aLNPRiskDutySchema.getSpecFlag();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 123 */       if (rs.getString("RiskCode") == null)
/* 124 */         this.riskCode = null;
/*     */       else {
/* 126 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 128 */       if (rs.getString("RiskVer") == null)
/* 129 */         this.riskVer = null;
/*     */       else {
/* 131 */         this.riskVer = rs.getString("RiskVer").trim();
/*     */       }
/* 133 */       if (rs.getString("DutyCode") == null)
/* 134 */         this.dutyCode = null;
/*     */       else {
/* 136 */         this.dutyCode = rs.getString("DutyCode").trim();
/*     */       }
/* 138 */       if (rs.getString("ChoFlag") == null)
/* 139 */         this.choFlag = null;
/*     */       else {
/* 141 */         this.choFlag = rs.getString("ChoFlag").trim();
/*     */       }
/* 143 */       if (rs.getString("SpecFlag") == null)
/* 144 */         this.specFlag = null;
/*     */       else {
/* 146 */         this.specFlag = rs.getString("SpecFlag").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 151 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskDuty\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 153 */       CError tError = new CError();
/* 154 */       tError.moduleName = "LNPRiskDutySchema";
/* 155 */       tError.functionName = "setSchema";
/* 156 */       tError.errorMessage = sqle.toString();
/* 157 */       this.mErrors.addOneError(tError);
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySchema getSchema()
/*     */   {
/* 165 */     LNPRiskDutySchema aLNPRiskDutySchema = new LNPRiskDutySchema();
/* 166 */     aLNPRiskDutySchema.setSchema(this);
/* 167 */     return aLNPRiskDutySchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutyDB getDB()
/*     */   {
/* 172 */     LNPRiskDutyDB aDBOper = new LNPRiskDutyDB();
/* 173 */     aDBOper.setSchema(this);
/* 174 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 181 */     StringBuffer strReturn = new StringBuffer(256);
/* 182 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 183 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/* 184 */     strReturn.append(StrTool.cTrim(this.dutyCode)); strReturn.append("|");
/* 185 */     strReturn.append(StrTool.cTrim(this.choFlag)); strReturn.append("|");
/* 186 */     strReturn.append(StrTool.cTrim(this.specFlag));
/* 187 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 195 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 196 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 197 */       this.dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 198 */       this.choFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 199 */       this.specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 204 */       CError tError = new CError();
/* 205 */       tError.moduleName = "LNPRiskDutySchema";
/* 206 */       tError.functionName = "decode";
/* 207 */       tError.errorMessage = ex.toString();
/* 208 */       this.mErrors.addOneError(tError);
/*     */ 
/* 210 */       return false;
/*     */     }
/* 212 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 218 */     String strReturn = "";
/* 219 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 221 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 223 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 225 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*     */     }
/* 227 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*     */     {
/* 229 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dutyCode));
/*     */     }
/* 231 */     if (FCode.equalsIgnoreCase("choFlag"))
/*     */     {
/* 233 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.choFlag));
/*     */     }
/* 235 */     if (FCode.equalsIgnoreCase("specFlag"))
/*     */     {
/* 237 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.specFlag));
/*     */     }
/* 239 */     if (strReturn.equals(""))
/*     */     {
/* 241 */       strReturn = "null";
/*     */     }
/*     */ 
/* 244 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 251 */     String strFieldValue = "";
/* 252 */     switch (nFieldIndex) {
/*     */     case 0:
/* 254 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 255 */       break;
/*     */     case 1:
/* 257 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/* 258 */       break;
/*     */     case 2:
/* 260 */       strFieldValue = StrTool.GBKToUnicode(this.dutyCode);
/* 261 */       break;
/*     */     case 3:
/* 263 */       strFieldValue = StrTool.GBKToUnicode(this.choFlag);
/* 264 */       break;
/*     */     case 4:
/* 266 */       strFieldValue = StrTool.GBKToUnicode(this.specFlag);
/* 267 */       break;
/*     */     default:
/* 269 */       strFieldValue = "";
/*     */     }
/* 271 */     if (strFieldValue.equals("")) {
/* 272 */       strFieldValue = "null";
/*     */     }
/* 274 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 280 */     if (StrTool.cTrim(FCode).equals("")) {
/* 281 */       return false;
/*     */     }
/* 283 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 285 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 287 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 290 */         this.riskCode = null;
/*     */     }
/* 292 */     if (FCode.equalsIgnoreCase("riskVer"))
/*     */     {
/* 294 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 296 */         this.riskVer = FValue.trim();
/*     */       }
/*     */       else
/* 299 */         this.riskVer = null;
/*     */     }
/* 301 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*     */     {
/* 303 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 305 */         this.dutyCode = FValue.trim();
/*     */       }
/*     */       else
/* 308 */         this.dutyCode = null;
/*     */     }
/* 310 */     if (FCode.equalsIgnoreCase("choFlag"))
/*     */     {
/* 312 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 314 */         this.choFlag = FValue.trim();
/*     */       }
/*     */       else
/* 317 */         this.choFlag = null;
/*     */     }
/* 319 */     if (FCode.equalsIgnoreCase("specFlag"))
/*     */     {
/* 321 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 323 */         this.specFlag = FValue.trim();
/*     */       }
/*     */       else
/* 326 */         this.specFlag = null;
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 333 */     if (otherObject == null) return false;
/* 334 */     if (this == otherObject) return true;
/* 335 */     if (getClass() != otherObject.getClass()) return false;
/* 336 */     LNPRiskDutySchema other = (LNPRiskDutySchema)otherObject;
/* 337 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 338 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 339 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/* 340 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/* 341 */     if ((this.dutyCode == null) && (other.getDutyCode() != null)) return false;
/* 342 */     if ((this.dutyCode != null) && (!this.dutyCode.equals(other.getDutyCode()))) return false;
/* 343 */     if ((this.choFlag == null) && (other.getChoFlag() != null)) return false;
/* 344 */     if ((this.choFlag != null) && (!this.choFlag.equals(other.getChoFlag()))) return false;
/* 345 */     if ((this.specFlag == null) && (other.getSpecFlag() != null)) return false;
/* 346 */     return (this.specFlag == null) || (this.specFlag.equals(other.getSpecFlag()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 353 */     return 5;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 359 */     if (strFieldName.equals("riskCode")) {
/* 360 */       return 0;
/*     */     }
/* 362 */     if (strFieldName.equals("riskVer")) {
/* 363 */       return 1;
/*     */     }
/* 365 */     if (strFieldName.equals("dutyCode")) {
/* 366 */       return 2;
/*     */     }
/* 368 */     if (strFieldName.equals("choFlag")) {
/* 369 */       return 3;
/*     */     }
/* 371 */     if (strFieldName.equals("specFlag")) {
/* 372 */       return 4;
/*     */     }
/* 374 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 380 */     String strFieldName = "";
/* 381 */     switch (nFieldIndex) {
/*     */     case 0:
/* 383 */       strFieldName = "riskCode";
/* 384 */       break;
/*     */     case 1:
/* 386 */       strFieldName = "riskVer";
/* 387 */       break;
/*     */     case 2:
/* 389 */       strFieldName = "dutyCode";
/* 390 */       break;
/*     */     case 3:
/* 392 */       strFieldName = "choFlag";
/* 393 */       break;
/*     */     case 4:
/* 395 */       strFieldName = "specFlag";
/* 396 */       break;
/*     */     default:
/* 398 */       strFieldName = "";
/*     */     }
/* 400 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 406 */     if (strFieldName.equals("riskCode")) {
/* 407 */       return 0;
/*     */     }
/* 409 */     if (strFieldName.equals("riskVer")) {
/* 410 */       return 0;
/*     */     }
/* 412 */     if (strFieldName.equals("dutyCode")) {
/* 413 */       return 0;
/*     */     }
/* 415 */     if (strFieldName.equals("choFlag")) {
/* 416 */       return 0;
/*     */     }
/* 418 */     if (strFieldName.equals("specFlag")) {
/* 419 */       return 0;
/*     */     }
/* 421 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 427 */     int nFieldType = -1;
/* 428 */     switch (nFieldIndex) {
/*     */     case 0:
/* 430 */       nFieldType = 0;
/* 431 */       break;
/*     */     case 1:
/* 433 */       nFieldType = 0;
/* 434 */       break;
/*     */     case 2:
/* 436 */       nFieldType = 0;
/* 437 */       break;
/*     */     case 3:
/* 439 */       nFieldType = 0;
/* 440 */       break;
/*     */     case 4:
/* 442 */       nFieldType = 0;
/* 443 */       break;
/*     */     default:
/* 445 */       nFieldType = -1;
/*     */     }
/* 447 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskDutySchema
 * JD-Core Version:    0.6.0
 */