/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskSaleGroupToRiskDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskSaleGroupToRiskSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String groupCode;
/*     */   private String riskCode;
/*     */   public static final int FIELDNUM = 2;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSchema()
/*     */   {
/*  36 */     this.mErrors = new CErrors();
/*     */ 
/*  38 */     String[] pk = new String[2];
/*  39 */     pk[0] = "GroupCode";
/*  40 */     pk[1] = "RiskCode";
/*     */ 
/*  42 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  49 */     LNPRiskSaleGroupToRiskSchema cloned = (LNPRiskSaleGroupToRiskSchema)super.clone();
/*  50 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  51 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  57 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getGroupCode()
/*     */   {
/*  62 */     return this.groupCode;
/*     */   }
/*     */ 
/*     */   public void setGroupCode(String aGroupCode) {
/*  66 */     this.groupCode = aGroupCode;
/*     */   }
/*     */ 
/*     */   public String getRiskCode() {
/*  70 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  74 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskSaleGroupToRiskSchema aLNPRiskSaleGroupToRiskSchema)
/*     */   {
/*  80 */     this.groupCode = aLNPRiskSaleGroupToRiskSchema.getGroupCode();
/*  81 */     this.riskCode = aLNPRiskSaleGroupToRiskSchema.getRiskCode();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/*  90 */       if (rs.getString("GroupCode") == null)
/*  91 */         this.groupCode = null;
/*     */       else {
/*  93 */         this.groupCode = rs.getString("GroupCode").trim();
/*     */       }
/*  95 */       if (rs.getString("RiskCode") == null)
/*  96 */         this.riskCode = null;
/*     */       else {
/*  98 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 103 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskSaleGroupToRisk\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 105 */       CError tError = new CError();
/* 106 */       tError.moduleName = "LNPRiskSaleGroupToRiskSchema";
/* 107 */       tError.functionName = "setSchema";
/* 108 */       tError.errorMessage = sqle.toString();
/* 109 */       this.mErrors.addOneError(tError);
/* 110 */       return false;
/*     */     }
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSchema getSchema()
/*     */   {
/* 117 */     LNPRiskSaleGroupToRiskSchema aLNPRiskSaleGroupToRiskSchema = new LNPRiskSaleGroupToRiskSchema();
/* 118 */     aLNPRiskSaleGroupToRiskSchema.setSchema(this);
/* 119 */     return aLNPRiskSaleGroupToRiskSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskDB getDB()
/*     */   {
/* 124 */     LNPRiskSaleGroupToRiskDB aDBOper = new LNPRiskSaleGroupToRiskDB();
/* 125 */     aDBOper.setSchema(this);
/* 126 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 133 */     StringBuffer strReturn = new StringBuffer(256);
/* 134 */     strReturn.append(StrTool.cTrim(this.groupCode)); strReturn.append("|");
/* 135 */     strReturn.append(StrTool.cTrim(this.riskCode));
/* 136 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 144 */       this.groupCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 145 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 150 */       CError tError = new CError();
/* 151 */       tError.moduleName = "LNPRiskSaleGroupToRiskSchema";
/* 152 */       tError.functionName = "decode";
/* 153 */       tError.errorMessage = ex.toString();
/* 154 */       this.mErrors.addOneError(tError);
/*     */ 
/* 156 */       return false;
/*     */     }
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 164 */     String strReturn = "";
/* 165 */     if (FCode.equalsIgnoreCase("groupCode"))
/*     */     {
/* 167 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.groupCode));
/*     */     }
/* 169 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 171 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 173 */     if (strReturn.equals(""))
/*     */     {
/* 175 */       strReturn = "null";
/*     */     }
/*     */ 
/* 178 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 185 */     String strFieldValue = "";
/* 186 */     switch (nFieldIndex) {
/*     */     case 0:
/* 188 */       strFieldValue = StrTool.GBKToUnicode(this.groupCode);
/* 189 */       break;
/*     */     case 1:
/* 191 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 192 */       break;
/*     */     default:
/* 194 */       strFieldValue = "";
/*     */     }
/* 196 */     if (strFieldValue.equals("")) {
/* 197 */       strFieldValue = "null";
/*     */     }
/* 199 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 205 */     if (StrTool.cTrim(FCode).equals("")) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (FCode.equalsIgnoreCase("groupCode"))
/*     */     {
/* 210 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 212 */         this.groupCode = FValue.trim();
/*     */       }
/*     */       else
/* 215 */         this.groupCode = null;
/*     */     }
/* 217 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 219 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 221 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 224 */         this.riskCode = null;
/*     */     }
/* 226 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 231 */     if (otherObject == null) return false;
/* 232 */     if (this == otherObject) return true;
/* 233 */     if (getClass() != otherObject.getClass()) return false;
/* 234 */     LNPRiskSaleGroupToRiskSchema other = (LNPRiskSaleGroupToRiskSchema)otherObject;
/* 235 */     if ((this.groupCode == null) && (other.getGroupCode() != null)) return false;
/* 236 */     if ((this.groupCode != null) && (!this.groupCode.equals(other.getGroupCode()))) return false;
/* 237 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 238 */     return (this.riskCode == null) || (this.riskCode.equals(other.getRiskCode()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 245 */     return 2;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 251 */     if (strFieldName.equals("groupCode")) {
/* 252 */       return 0;
/*     */     }
/* 254 */     if (strFieldName.equals("riskCode")) {
/* 255 */       return 1;
/*     */     }
/* 257 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 263 */     String strFieldName = "";
/* 264 */     switch (nFieldIndex) {
/*     */     case 0:
/* 266 */       strFieldName = "groupCode";
/* 267 */       break;
/*     */     case 1:
/* 269 */       strFieldName = "riskCode";
/* 270 */       break;
/*     */     default:
/* 272 */       strFieldName = "";
/*     */     }
/* 274 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 280 */     if (strFieldName.equals("groupCode")) {
/* 281 */       return 0;
/*     */     }
/* 283 */     if (strFieldName.equals("riskCode")) {
/* 284 */       return 0;
/*     */     }
/* 286 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 292 */     int nFieldType = -1;
/* 293 */     switch (nFieldIndex) {
/*     */     case 0:
/* 295 */       nFieldType = 0;
/* 296 */       break;
/*     */     case 1:
/* 298 */       nFieldType = 0;
/* 299 */       break;
/*     */     default:
/* 301 */       nFieldType = -1;
/*     */     }
/* 303 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupToRiskSchema
 * JD-Core Version:    0.6.0
 */