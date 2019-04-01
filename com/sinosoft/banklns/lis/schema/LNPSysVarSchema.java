/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPSysVarDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPSysVarSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String sysVar;
/*     */   private String sysVarType;
/*     */   private String sysVarValue;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPSysVarSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[1];
/*  41 */     pk[0] = "SysVar";
/*     */ 
/*  43 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  50 */     LNPSysVarSchema cloned = (LNPSysVarSchema)super.clone();
/*  51 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  52 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  58 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getSysVar()
/*     */   {
/*  63 */     return this.sysVar;
/*     */   }
/*     */ 
/*     */   public void setSysVar(String aSysVar) {
/*  67 */     this.sysVar = aSysVar;
/*     */   }
/*     */ 
/*     */   public String getSysVarType() {
/*  71 */     return this.sysVarType;
/*     */   }
/*     */ 
/*     */   public void setSysVarType(String aSysVarType) {
/*  75 */     this.sysVarType = aSysVarType;
/*     */   }
/*     */ 
/*     */   public String getSysVarValue() {
/*  79 */     return this.sysVarValue;
/*     */   }
/*     */ 
/*     */   public void setSysVarValue(String aSysVarValue) {
/*  83 */     this.sysVarValue = aSysVarValue;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPSysVarSchema aLNPSysVarSchema)
/*     */   {
/*  89 */     this.sysVar = aLNPSysVarSchema.getSysVar();
/*  90 */     this.sysVarType = aLNPSysVarSchema.getSysVarType();
/*  91 */     this.sysVarValue = aLNPSysVarSchema.getSysVarValue();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       if (rs.getString("SysVar") == null)
/* 101 */         this.sysVar = null;
/*     */       else {
/* 103 */         this.sysVar = rs.getString("SysVar").trim();
/*     */       }
/* 105 */       if (rs.getString("SysVarType") == null)
/* 106 */         this.sysVarType = null;
/*     */       else {
/* 108 */         this.sysVarType = rs.getString("SysVarType").trim();
/*     */       }
/* 110 */       if (rs.getString("SysVarValue") == null)
/* 111 */         this.sysVarValue = null;
/*     */       else {
/* 113 */         this.sysVarValue = rs.getString("SysVarValue").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 118 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPSysVar\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 120 */       CError tError = new CError();
/* 121 */       tError.moduleName = "LNPSysVarSchema";
/* 122 */       tError.functionName = "setSchema";
/* 123 */       tError.errorMessage = sqle.toString();
/* 124 */       this.mErrors.addOneError(tError);
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPSysVarSchema getSchema()
/*     */   {
/* 132 */     LNPSysVarSchema aLNPSysVarSchema = new LNPSysVarSchema();
/* 133 */     aLNPSysVarSchema.setSchema(this);
/* 134 */     return aLNPSysVarSchema;
/*     */   }
/*     */ 
/*     */   public LNPSysVarDB getDB()
/*     */   {
/* 139 */     LNPSysVarDB aDBOper = new LNPSysVarDB();
/* 140 */     aDBOper.setSchema(this);
/* 141 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 148 */     StringBuffer strReturn = new StringBuffer(256);
/* 149 */     strReturn.append(StrTool.cTrim(this.sysVar)); strReturn.append("|");
/* 150 */     strReturn.append(StrTool.cTrim(this.sysVarType)); strReturn.append("|");
/* 151 */     strReturn.append(StrTool.cTrim(this.sysVarValue));
/* 152 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 160 */       this.sysVar = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 161 */       this.sysVarType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 162 */       this.sysVarValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 167 */       CError tError = new CError();
/* 168 */       tError.moduleName = "LNPSysVarSchema";
/* 169 */       tError.functionName = "decode";
/* 170 */       tError.errorMessage = ex.toString();
/* 171 */       this.mErrors.addOneError(tError);
/*     */ 
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 181 */     String strReturn = "";
/* 182 */     if (FCode.equalsIgnoreCase("sysVar"))
/*     */     {
/* 184 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sysVar));
/*     */     }
/* 186 */     if (FCode.equalsIgnoreCase("sysVarType"))
/*     */     {
/* 188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sysVarType));
/*     */     }
/* 190 */     if (FCode.equalsIgnoreCase("sysVarValue"))
/*     */     {
/* 192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sysVarValue));
/*     */     }
/* 194 */     if (strReturn.equals(""))
/*     */     {
/* 196 */       strReturn = "null";
/*     */     }
/*     */ 
/* 199 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 206 */     String strFieldValue = "";
/* 207 */     switch (nFieldIndex) {
/*     */     case 0:
/* 209 */       strFieldValue = StrTool.GBKToUnicode(this.sysVar);
/* 210 */       break;
/*     */     case 1:
/* 212 */       strFieldValue = StrTool.GBKToUnicode(this.sysVarType);
/* 213 */       break;
/*     */     case 2:
/* 215 */       strFieldValue = StrTool.GBKToUnicode(this.sysVarValue);
/* 216 */       break;
/*     */     default:
/* 218 */       strFieldValue = "";
/*     */     }
/* 220 */     if (strFieldValue.equals("")) {
/* 221 */       strFieldValue = "null";
/*     */     }
/* 223 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 229 */     if (StrTool.cTrim(FCode).equals("")) {
/* 230 */       return false;
/*     */     }
/* 232 */     if (FCode.equalsIgnoreCase("sysVar"))
/*     */     {
/* 234 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 236 */         this.sysVar = FValue.trim();
/*     */       }
/*     */       else
/* 239 */         this.sysVar = null;
/*     */     }
/* 241 */     if (FCode.equalsIgnoreCase("sysVarType"))
/*     */     {
/* 243 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 245 */         this.sysVarType = FValue.trim();
/*     */       }
/*     */       else
/* 248 */         this.sysVarType = null;
/*     */     }
/* 250 */     if (FCode.equalsIgnoreCase("sysVarValue"))
/*     */     {
/* 252 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 254 */         this.sysVarValue = FValue.trim();
/*     */       }
/*     */       else
/* 257 */         this.sysVarValue = null;
/*     */     }
/* 259 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 264 */     if (otherObject == null) return false;
/* 265 */     if (this == otherObject) return true;
/* 266 */     if (getClass() != otherObject.getClass()) return false;
/* 267 */     LNPSysVarSchema other = (LNPSysVarSchema)otherObject;
/* 268 */     if ((this.sysVar == null) && (other.getSysVar() != null)) return false;
/* 269 */     if ((this.sysVar != null) && (!this.sysVar.equals(other.getSysVar()))) return false;
/* 270 */     if ((this.sysVarType == null) && (other.getSysVarType() != null)) return false;
/* 271 */     if ((this.sysVarType != null) && (!this.sysVarType.equals(other.getSysVarType()))) return false;
/* 272 */     if ((this.sysVarValue == null) && (other.getSysVarValue() != null)) return false;
/* 273 */     return (this.sysVarValue == null) || (this.sysVarValue.equals(other.getSysVarValue()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 280 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 286 */     if (strFieldName.equals("sysVar")) {
/* 287 */       return 0;
/*     */     }
/* 289 */     if (strFieldName.equals("sysVarType")) {
/* 290 */       return 1;
/*     */     }
/* 292 */     if (strFieldName.equals("sysVarValue")) {
/* 293 */       return 2;
/*     */     }
/* 295 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 301 */     String strFieldName = "";
/* 302 */     switch (nFieldIndex) {
/*     */     case 0:
/* 304 */       strFieldName = "sysVar";
/* 305 */       break;
/*     */     case 1:
/* 307 */       strFieldName = "sysVarType";
/* 308 */       break;
/*     */     case 2:
/* 310 */       strFieldName = "sysVarValue";
/* 311 */       break;
/*     */     default:
/* 313 */       strFieldName = "";
/*     */     }
/* 315 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 321 */     if (strFieldName.equals("sysVar")) {
/* 322 */       return 0;
/*     */     }
/* 324 */     if (strFieldName.equals("sysVarType")) {
/* 325 */       return 0;
/*     */     }
/* 327 */     if (strFieldName.equals("sysVarValue")) {
/* 328 */       return 0;
/*     */     }
/* 330 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 336 */     int nFieldType = -1;
/* 337 */     switch (nFieldIndex) {
/*     */     case 0:
/* 339 */       nFieldType = 0;
/* 340 */       break;
/*     */     case 1:
/* 342 */       nFieldType = 0;
/* 343 */       break;
/*     */     case 2:
/* 345 */       nFieldType = 0;
/* 346 */       break;
/*     */     default:
/* 348 */       nFieldType = -1;
/*     */     }
/* 350 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPSysVarSchema
 * JD-Core Version:    0.6.0
 */