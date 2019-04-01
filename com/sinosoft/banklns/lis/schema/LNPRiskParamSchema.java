/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskParamSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String type;
/*     */   private String riskCode;
/*     */   private String param;
/*     */   private String expression;
/*     */   private String remark;
/*     */   public static final int FIELDNUM = 5;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskParamSchema()
/*     */   {
/*  42 */     this.mErrors = new CErrors();
/*     */ 
/*  44 */     String[] pk = new String[3];
/*  45 */     pk[0] = "Type";
/*  46 */     pk[1] = "RiskCode";
/*  47 */     pk[2] = "Param";
/*     */ 
/*  49 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  56 */     LNPRiskParamSchema cloned = (LNPRiskParamSchema)super.clone();
/*  57 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  58 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  64 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  69 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String aType) {
/*  73 */     this.type = aType;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/*  77 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  81 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getParam() {
/*  85 */     return this.param;
/*     */   }
/*     */ 
/*     */   public void setParam(String aParam) {
/*  89 */     this.param = aParam;
/*     */   }
/*     */ 
/*     */   public String getExpression() {
/*  93 */     return this.expression;
/*     */   }
/*     */ 
/*     */   public void setExpression(String aExpression) {
/*  97 */     this.expression = aExpression;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 101 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String aRemark) {
/* 105 */     this.remark = aRemark;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskParamSchema aLNPRiskParamSchema)
/*     */   {
/* 111 */     this.type = aLNPRiskParamSchema.getType();
/* 112 */     this.riskCode = aLNPRiskParamSchema.getRiskCode();
/* 113 */     this.param = aLNPRiskParamSchema.getParam();
/* 114 */     this.expression = aLNPRiskParamSchema.getExpression();
/* 115 */     this.remark = aLNPRiskParamSchema.getRemark();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 124 */       if (rs.getString("Type") == null)
/* 125 */         this.type = null;
/*     */       else {
/* 127 */         this.type = rs.getString("Type").trim();
/*     */       }
/* 129 */       if (rs.getString("RiskCode") == null)
/* 130 */         this.riskCode = null;
/*     */       else {
/* 132 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 134 */       if (rs.getString("Param") == null)
/* 135 */         this.param = null;
/*     */       else {
/* 137 */         this.param = rs.getString("Param").trim();
/*     */       }
/* 139 */       if (rs.getString("Expression") == null)
/* 140 */         this.expression = null;
/*     */       else {
/* 142 */         this.expression = rs.getString("Expression").trim();
/*     */       }
/* 144 */       if (rs.getString("Remark") == null)
/* 145 */         this.remark = null;
/*     */       else {
/* 147 */         this.remark = rs.getString("Remark").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 152 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskParam\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 154 */       CError tError = new CError();
/* 155 */       tError.moduleName = "LNPRiskParamSchema";
/* 156 */       tError.functionName = "setSchema";
/* 157 */       tError.errorMessage = sqle.toString();
/* 158 */       this.mErrors.addOneError(tError);
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskParamSchema getSchema()
/*     */   {
/* 166 */     LNPRiskParamSchema aLNPRiskParamSchema = new LNPRiskParamSchema();
/* 167 */     aLNPRiskParamSchema.setSchema(this);
/* 168 */     return aLNPRiskParamSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskParamDB getDB()
/*     */   {
/* 173 */     LNPRiskParamDB aDBOper = new LNPRiskParamDB();
/* 174 */     aDBOper.setSchema(this);
/* 175 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 182 */     StringBuffer strReturn = new StringBuffer(256);
/* 183 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/* 184 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 185 */     strReturn.append(StrTool.cTrim(this.param)); strReturn.append("|");
/* 186 */     strReturn.append(StrTool.cTrim(this.expression)); strReturn.append("|");
/* 187 */     strReturn.append(StrTool.cTrim(this.remark));
/* 188 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 196 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 197 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 198 */       this.param = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 199 */       this.expression = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 200 */       this.remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 205 */       CError tError = new CError();
/* 206 */       tError.moduleName = "LNPRiskParamSchema";
/* 207 */       tError.functionName = "decode";
/* 208 */       tError.errorMessage = ex.toString();
/* 209 */       this.mErrors.addOneError(tError);
/*     */ 
/* 211 */       return false;
/*     */     }
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 219 */     String strReturn = "";
/* 220 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 222 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*     */     }
/* 224 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 226 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 228 */     if (FCode.equalsIgnoreCase("param"))
/*     */     {
/* 230 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.param));
/*     */     }
/* 232 */     if (FCode.equalsIgnoreCase("expression"))
/*     */     {
/* 234 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.expression));
/*     */     }
/* 236 */     if (FCode.equalsIgnoreCase("remark"))
/*     */     {
/* 238 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.remark));
/*     */     }
/* 240 */     if (strReturn.equals(""))
/*     */     {
/* 242 */       strReturn = "null";
/*     */     }
/*     */ 
/* 245 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 252 */     String strFieldValue = "";
/* 253 */     switch (nFieldIndex) {
/*     */     case 0:
/* 255 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 256 */       break;
/*     */     case 1:
/* 258 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 259 */       break;
/*     */     case 2:
/* 261 */       strFieldValue = StrTool.GBKToUnicode(this.param);
/* 262 */       break;
/*     */     case 3:
/* 264 */       strFieldValue = StrTool.GBKToUnicode(this.expression);
/* 265 */       break;
/*     */     case 4:
/* 267 */       strFieldValue = StrTool.GBKToUnicode(this.remark);
/* 268 */       break;
/*     */     default:
/* 270 */       strFieldValue = "";
/*     */     }
/* 272 */     if (strFieldValue.equals("")) {
/* 273 */       strFieldValue = "null";
/*     */     }
/* 275 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 281 */     if (StrTool.cTrim(FCode).equals("")) {
/* 282 */       return false;
/*     */     }
/* 284 */     if (FCode.equalsIgnoreCase("type"))
/*     */     {
/* 286 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 288 */         this.type = FValue.trim();
/*     */       }
/*     */       else
/* 291 */         this.type = null;
/*     */     }
/* 293 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 295 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 297 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 300 */         this.riskCode = null;
/*     */     }
/* 302 */     if (FCode.equalsIgnoreCase("param"))
/*     */     {
/* 304 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 306 */         this.param = FValue.trim();
/*     */       }
/*     */       else
/* 309 */         this.param = null;
/*     */     }
/* 311 */     if (FCode.equalsIgnoreCase("expression"))
/*     */     {
/* 313 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 315 */         this.expression = FValue.trim();
/*     */       }
/*     */       else
/* 318 */         this.expression = null;
/*     */     }
/* 320 */     if (FCode.equalsIgnoreCase("remark"))
/*     */     {
/* 322 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 324 */         this.remark = FValue.trim();
/*     */       }
/*     */       else
/* 327 */         this.remark = null;
/*     */     }
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 334 */     if (otherObject == null) return false;
/* 335 */     if (this == otherObject) return true;
/* 336 */     if (getClass() != otherObject.getClass()) return false;
/* 337 */     LNPRiskParamSchema other = (LNPRiskParamSchema)otherObject;
/* 338 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 339 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 340 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 341 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 342 */     if ((this.param == null) && (other.getParam() != null)) return false;
/* 343 */     if ((this.param != null) && (!this.param.equals(other.getParam()))) return false;
/* 344 */     if ((this.expression == null) && (other.getExpression() != null)) return false;
/* 345 */     if ((this.expression != null) && (!this.expression.equals(other.getExpression()))) return false;
/* 346 */     if ((this.remark == null) && (other.getRemark() != null)) return false;
/* 347 */     return (this.remark == null) || (this.remark.equals(other.getRemark()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 354 */     return 5;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 360 */     if (strFieldName.equals("type")) {
/* 361 */       return 0;
/*     */     }
/* 363 */     if (strFieldName.equals("riskCode")) {
/* 364 */       return 1;
/*     */     }
/* 366 */     if (strFieldName.equals("param")) {
/* 367 */       return 2;
/*     */     }
/* 369 */     if (strFieldName.equals("expression")) {
/* 370 */       return 3;
/*     */     }
/* 372 */     if (strFieldName.equals("remark")) {
/* 373 */       return 4;
/*     */     }
/* 375 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 381 */     String strFieldName = "";
/* 382 */     switch (nFieldIndex) {
/*     */     case 0:
/* 384 */       strFieldName = "type";
/* 385 */       break;
/*     */     case 1:
/* 387 */       strFieldName = "riskCode";
/* 388 */       break;
/*     */     case 2:
/* 390 */       strFieldName = "param";
/* 391 */       break;
/*     */     case 3:
/* 393 */       strFieldName = "expression";
/* 394 */       break;
/*     */     case 4:
/* 396 */       strFieldName = "remark";
/* 397 */       break;
/*     */     default:
/* 399 */       strFieldName = "";
/*     */     }
/* 401 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 407 */     if (strFieldName.equals("type")) {
/* 408 */       return 0;
/*     */     }
/* 410 */     if (strFieldName.equals("riskCode")) {
/* 411 */       return 0;
/*     */     }
/* 413 */     if (strFieldName.equals("param")) {
/* 414 */       return 0;
/*     */     }
/* 416 */     if (strFieldName.equals("expression")) {
/* 417 */       return 0;
/*     */     }
/* 419 */     if (strFieldName.equals("remark")) {
/* 420 */       return 0;
/*     */     }
/* 422 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 428 */     int nFieldType = -1;
/* 429 */     switch (nFieldIndex) {
/*     */     case 0:
/* 431 */       nFieldType = 0;
/* 432 */       break;
/*     */     case 1:
/* 434 */       nFieldType = 0;
/* 435 */       break;
/*     */     case 2:
/* 437 */       nFieldType = 0;
/* 438 */       break;
/*     */     case 3:
/* 440 */       nFieldType = 0;
/* 441 */       break;
/*     */     case 4:
/* 443 */       nFieldType = 0;
/* 444 */       break;
/*     */     default:
/* 446 */       nFieldType = -1;
/*     */     }
/* 448 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskParamSchema
 * JD-Core Version:    0.6.0
 */