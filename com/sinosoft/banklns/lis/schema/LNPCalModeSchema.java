/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPCalModeSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String calCode;
/*     */   private String riskCode;
/*     */   private String type;
/*     */   private String calSQL;
/*     */   private String remark;
/*     */   public static final int FIELDNUM = 5;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPCalModeSchema()
/*     */   {
/*  42 */     this.mErrors = new CErrors();
/*     */ 
/*  44 */     String[] pk = new String[1];
/*  45 */     pk[0] = "CalCode";
/*     */ 
/*  47 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  54 */     LNPCalModeSchema cloned = (LNPCalModeSchema)super.clone();
/*  55 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  56 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  62 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getCalCode()
/*     */   {
/*  67 */     return this.calCode;
/*     */   }
/*     */ 
/*     */   public void setCalCode(String aCalCode) {
/*  71 */     this.calCode = aCalCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/*  75 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  79 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  83 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String aType) {
/*  87 */     this.type = aType;
/*     */   }
/*     */ 
/*     */   public String getCalSQL() {
/*  91 */     return this.calSQL;
/*     */   }
/*     */ 
/*     */   public void setCalSQL(String aCalSQL) {
/*  95 */     this.calSQL = aCalSQL;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/*  99 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String aRemark) {
/* 103 */     this.remark = aRemark;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPCalModeSchema aLNPCalModeSchema)
/*     */   {
/* 109 */     this.calCode = aLNPCalModeSchema.getCalCode();
/* 110 */     this.riskCode = aLNPCalModeSchema.getRiskCode();
/* 111 */     this.type = aLNPCalModeSchema.getType();
/* 112 */     this.calSQL = aLNPCalModeSchema.getCalSQL();
/* 113 */     this.remark = aLNPCalModeSchema.getRemark();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 122 */       if (rs.getString("CalCode") == null)
/* 123 */         this.calCode = null;
/*     */       else {
/* 125 */         this.calCode = rs.getString("CalCode").trim();
/*     */       }
/* 127 */       if (rs.getString("RiskCode") == null)
/* 128 */         this.riskCode = null;
/*     */       else {
/* 130 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 132 */       if (rs.getString("Type") == null)
/* 133 */         this.type = null;
/*     */       else {
/* 135 */         this.type = rs.getString("Type").trim();
/*     */       }
/* 137 */       if (rs.getString("CalSQL") == null)
/* 138 */         this.calSQL = null;
/*     */       else {
/* 140 */         this.calSQL = rs.getString("CalSQL").trim();
/*     */       }
/* 142 */       if (rs.getString("Remark") == null)
/* 143 */         this.remark = null;
/*     */       else {
/* 145 */         this.remark = rs.getString("Remark").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 150 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCalMode\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 152 */       CError tError = new CError();
/* 153 */       tError.moduleName = "LNPCalModeSchema";
/* 154 */       tError.functionName = "setSchema";
/* 155 */       tError.errorMessage = sqle.toString();
/* 156 */       this.mErrors.addOneError(tError);
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSchema getSchema()
/*     */   {
/* 164 */     LNPCalModeSchema aLNPCalModeSchema = new LNPCalModeSchema();
/* 165 */     aLNPCalModeSchema.setSchema(this);
/* 166 */     return aLNPCalModeSchema;
/*     */   }
/*     */ 
/*     */   public LNPCalModeDB getDB()
/*     */   {
/* 171 */     LNPCalModeDB aDBOper = new LNPCalModeDB();
/* 172 */     aDBOper.setSchema(this);
/* 173 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 180 */     StringBuffer strReturn = new StringBuffer(256);
/* 181 */     strReturn.append(StrTool.cTrim(this.calCode)); strReturn.append("|");
/* 182 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 183 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/* 184 */     strReturn.append(StrTool.cTrim(this.calSQL)); strReturn.append("|");
/* 185 */     strReturn.append(StrTool.cTrim(this.remark));
/* 186 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 194 */       this.calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 195 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 196 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 197 */       this.calSQL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 198 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 203 */       CError tError = new CError();
/* 204 */       tError.moduleName = "LNPCalModeSchema";
/* 205 */       tError.functionName = "decode";
/* 206 */       tError.errorMessage = ex.toString();
/* 207 */       this.mErrors.addOneError(tError);
/*     */ 
/* 209 */       return false;
/*     */     }
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 217 */     String strReturn = "";
/* 218 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 220 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calCode));
/*     */     }
/* 222 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 224 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 226 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 228 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*     */     }
/* 230 */     if (FCode.equalsIgnoreCase("calSQL"))
/*     */     {
/* 232 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.calSQL));
/*     */     }
/* 234 */     if (FCode.equalsIgnoreCase("remark"))
/*     */     {
/* 236 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*     */     }
/* 238 */     if (strReturn.equals(""))
/*     */     {
/* 240 */       strReturn = "null";
/*     */     }
/*     */ 
/* 243 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 250 */     String strFieldValue = "";
/* 251 */     switch (nFieldIndex) {
/*     */     case 0:
/* 253 */       strFieldValue = StrTool.GBKToUnicode(this.calCode);
/* 254 */       break;
/*     */     case 1:
/* 256 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 257 */       break;
/*     */     case 2:
/* 259 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 260 */       break;
/*     */     case 3:
/* 262 */       strFieldValue = StrTool.GBKToUnicode(this.calSQL);
/* 263 */       break;
/*     */     case 4:
/* 265 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 266 */       break;
/*     */     default:
/* 268 */       strFieldValue = "";
/*     */     }
/* 270 */     if (strFieldValue.equals("")) {
/* 271 */       strFieldValue = "null";
/*     */     }
/* 273 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 279 */     if (StrTool.cTrim(FCode).equals("")) {
/* 280 */       return false;
/*     */     }
/* 282 */     if (FCode.equalsIgnoreCase("calCode"))
/*     */     {
/* 284 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 286 */         this.calCode = FValue.trim();
/*     */       }
/*     */       else
/* 289 */         this.calCode = null;
/*     */     }
/* 291 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 293 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 295 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 298 */         this.riskCode = null;
/*     */     }
/* 300 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 302 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 304 */         this.type = FValue.trim();
/*     */       }
/*     */       else
/* 307 */         this.type = null;
/*     */     }
/* 309 */     if (FCode.equalsIgnoreCase("calSQL"))
/*     */     {
/* 311 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 313 */         this.calSQL = FValue.trim();
/*     */       }
/*     */       else
/* 316 */         this.calSQL = null;
/*     */     }
/* 318 */     if (FCode.equalsIgnoreCase("remark"))
/*     */     {
/* 320 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 322 */         this.remark = FValue.trim();
/*     */       }
/*     */       else
/* 325 */         this.remark = null;
/*     */     }
/* 327 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 332 */     if (otherObject == null) return false;
/* 333 */     if (this == otherObject) return true;
/* 334 */     if (getClass() != otherObject.getClass()) return false;
/* 335 */     LNPCalModeSchema other = (LNPCalModeSchema)otherObject;
/* 336 */     if ((this.calCode == null) && (other.getCalCode() != null)) return false;
/* 337 */     if ((this.calCode != null) && (!this.calCode.equals(other.getCalCode()))) return false;
/* 338 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 339 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 340 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 341 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 342 */     if ((this.calSQL == null) && (other.getCalSQL() != null)) return false;
/* 343 */     if ((this.calSQL != null) && (!this.calSQL.equals(other.getCalSQL()))) return false;
/* 344 */     if ((this.remark == null) && (other.getRemark() != null)) return false;
/* 345 */     return (this.remark == null) || (this.remark.equals(other.getRemark()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 352 */     return 5;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 358 */     if (strFieldName.equals("calCode")) {
/* 359 */       return 0;
/*     */     }
/* 361 */     if (strFieldName.equals("riskCode")) {
/* 362 */       return 1;
/*     */     }
/* 364 */     if (strFieldName.equals("type")) {
/* 365 */       return 2;
/*     */     }
/* 367 */     if (strFieldName.equals("calSQL")) {
/* 368 */       return 3;
/*     */     }
/* 370 */     if (strFieldName.equals("remark")) {
/* 371 */       return 4;
/*     */     }
/* 373 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 379 */     String strFieldName = "";
/* 380 */     switch (nFieldIndex) {
/*     */     case 0:
/* 382 */       strFieldName = "calCode";
/* 383 */       break;
/*     */     case 1:
/* 385 */       strFieldName = "riskCode";
/* 386 */       break;
/*     */     case 2:
/* 388 */       strFieldName = "type";
/* 389 */       break;
/*     */     case 3:
/* 391 */       strFieldName = "calSQL";
/* 392 */       break;
/*     */     case 4:
/* 394 */       strFieldName = "remark";
/* 395 */       break;
/*     */     default:
/* 397 */       strFieldName = "";
/*     */     }
/* 399 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 405 */     if (strFieldName.equals("calCode")) {
/* 406 */       return 0;
/*     */     }
/* 408 */     if (strFieldName.equals("riskCode")) {
/* 409 */       return 0;
/*     */     }
/* 411 */     if (strFieldName.equals("type")) {
/* 412 */       return 0;
/*     */     }
/* 414 */     if (strFieldName.equals("calSQL")) {
/* 415 */       return 0;
/*     */     }
/* 417 */     if (strFieldName.equals("remark")) {
/* 418 */       return 0;
/*     */     }
/* 420 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 426 */     int nFieldType = -1;
/* 427 */     switch (nFieldIndex) {
/*     */     case 0:
/* 429 */       nFieldType = 0;
/* 430 */       break;
/*     */     case 1:
/* 432 */       nFieldType = 0;
/* 433 */       break;
/*     */     case 2:
/* 435 */       nFieldType = 0;
/* 436 */       break;
/*     */     case 3:
/* 438 */       nFieldType = 0;
/* 439 */       break;
/*     */     case 4:
/* 441 */       nFieldType = 0;
/* 442 */       break;
/*     */     default:
/* 444 */       nFieldType = -1;
/*     */     }
/* 446 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPCalModeSchema
 * JD-Core Version:    0.6.0
 */