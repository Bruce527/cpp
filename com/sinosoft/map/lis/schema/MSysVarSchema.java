/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MSysVarDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MSysVarSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String varType;
/*     */   private String varValue;
/*     */   public static final int FIELDNUM = 2;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MSysVarSchema()
/*     */   {
/*  33 */     this.mErrors = new CErrors();
/*     */ 
/*  35 */     String[] pk = new String[1];
/*  36 */     pk[0] = "VarType";
/*     */ 
/*  38 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  45 */     MSysVarSchema cloned = (MSysVarSchema)super.clone();
/*  46 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  47 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  53 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getVarType()
/*     */   {
/*  58 */     return this.varType;
/*     */   }
/*     */ 
/*     */   public void setVarType(String aVarType) {
/*  62 */     this.varType = aVarType;
/*     */   }
/*     */ 
/*     */   public String getVarValue() {
/*  66 */     return this.varValue;
/*     */   }
/*     */ 
/*     */   public void setVarValue(String aVarValue) {
/*  70 */     this.varValue = aVarValue;
/*     */   }
/*     */ 
/*     */   public void setSchema(MSysVarSchema aMSysVarSchema)
/*     */   {
/*  76 */     this.varType = aMSysVarSchema.getVarType();
/*  77 */     this.varValue = aMSysVarSchema.getVarValue();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/*  86 */       if (rs.getString("VarType") == null)
/*  87 */         this.varType = null;
/*     */       else {
/*  89 */         this.varType = rs.getString("VarType").trim();
/*     */       }
/*  91 */       if (rs.getString("VarValue") == null)
/*  92 */         this.varValue = null;
/*     */       else {
/*  94 */         this.varValue = rs.getString("VarValue").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/*  99 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MSysVar\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "MSysVarSchema";
/* 103 */       tError.functionName = "setSchema";
/* 104 */       tError.errorMessage = sqle.toString();
/* 105 */       this.mErrors.addOneError(tError);
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   public MSysVarSchema getSchema()
/*     */   {
/* 113 */     MSysVarSchema aMSysVarSchema = new MSysVarSchema();
/* 114 */     aMSysVarSchema.setSchema(this);
/* 115 */     return aMSysVarSchema;
/*     */   }
/*     */ 
/*     */   public MSysVarDB getDB()
/*     */   {
/* 120 */     MSysVarDB aDBOper = new MSysVarDB();
/* 121 */     aDBOper.setSchema(this);
/* 122 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 129 */     StringBuffer strReturn = new StringBuffer(256);
/* 130 */     strReturn.append(StrTool.cTrim(this.varType)); strReturn.append("|");
/* 131 */     strReturn.append(StrTool.cTrim(this.varValue));
/* 132 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 140 */       this.varType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 141 */       this.varValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 146 */       CError tError = new CError();
/* 147 */       tError.moduleName = "MSysVarSchema";
/* 148 */       tError.functionName = "decode";
/* 149 */       tError.errorMessage = ex.toString();
/* 150 */       this.mErrors.addOneError(tError);
/*     */ 
/* 152 */       return false;
/*     */     }
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 160 */     String strReturn = "";
/* 161 */     if (FCode.equalsIgnoreCase("varType"))
/*     */     {
/* 163 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varType));
/*     */     }
/* 165 */     if (FCode.equalsIgnoreCase("varValue"))
/*     */     {
/* 167 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.varValue));
/*     */     }
/* 169 */     if (strReturn.equals(""))
/*     */     {
/* 171 */       strReturn = "null";
/*     */     }
/*     */ 
/* 174 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 181 */     String strFieldValue = "";
/* 182 */     switch (nFieldIndex) {
/*     */     case 0:
/* 184 */       strFieldValue = StrTool.GBKToUnicode(this.varType);
/* 185 */       break;
/*     */     case 1:
/* 187 */       strFieldValue = StrTool.GBKToUnicode(this.varValue);
/* 188 */       break;
/*     */     default:
/* 190 */       strFieldValue = "";
/*     */     }
/* 192 */     if (strFieldValue.equals("")) {
/* 193 */       strFieldValue = "null";
/*     */     }
/* 195 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 201 */     if (StrTool.cTrim(FCode).equals("")) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (FCode.equalsIgnoreCase("varType"))
/*     */     {
/* 206 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 208 */         this.varType = FValue.trim();
/*     */       }
/*     */       else
/* 211 */         this.varType = null;
/*     */     }
/* 213 */     if (FCode.equalsIgnoreCase("varValue"))
/*     */     {
/* 215 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 217 */         this.varValue = FValue.trim();
/*     */       }
/*     */       else
/* 220 */         this.varValue = null;
/*     */     }
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 227 */     if (otherObject == null) return false;
/* 228 */     if (this == otherObject) return true;
/* 229 */     if (getClass() != otherObject.getClass()) return false;
/* 230 */     MSysVarSchema other = (MSysVarSchema)otherObject;
/* 231 */     if ((this.varType == null) && (other.getVarType() != null)) return false;
/* 232 */     if ((this.varType != null) && (!this.varType.equals(other.getVarType()))) return false;
/* 233 */     if ((this.varValue == null) && (other.getVarValue() != null)) return false;
/* 234 */     return (this.varValue == null) || (this.varValue.equals(other.getVarValue()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 241 */     return 2;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 247 */     if (strFieldName.equals("varType")) {
/* 248 */       return 0;
/*     */     }
/* 250 */     if (strFieldName.equals("varValue")) {
/* 251 */       return 1;
/*     */     }
/* 253 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 259 */     String strFieldName = "";
/* 260 */     switch (nFieldIndex) {
/*     */     case 0:
/* 262 */       strFieldName = "varType";
/* 263 */       break;
/*     */     case 1:
/* 265 */       strFieldName = "varValue";
/* 266 */       break;
/*     */     default:
/* 268 */       strFieldName = "";
/*     */     }
/* 270 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 276 */     if (strFieldName.equals("varType")) {
/* 277 */       return 0;
/*     */     }
/* 279 */     if (strFieldName.equals("varValue")) {
/* 280 */       return 0;
/*     */     }
/* 282 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 288 */     int nFieldType = -1;
/* 289 */     switch (nFieldIndex) {
/*     */     case 0:
/* 291 */       nFieldType = 0;
/* 292 */       break;
/*     */     case 1:
/* 294 */       nFieldType = 0;
/* 295 */       break;
/*     */     default:
/* 297 */       nFieldType = -1;
/*     */     }
/* 299 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MSysVarSchema
 * JD-Core Version:    0.6.0
 */