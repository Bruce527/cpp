/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPDutyGetRelaDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPDutyGetRelaSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String dutyCode;
/*     */   private String getDutyCode;
/*     */   private String getDutyName;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPDutyGetRelaSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[2];
/*  41 */     pk[0] = "DutyCode";
/*  42 */     pk[1] = "GetDutyCode";
/*     */ 
/*  44 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  51 */     LNPDutyGetRelaSchema cloned = (LNPDutyGetRelaSchema)super.clone();
/*  52 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  53 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  59 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getDutyCode()
/*     */   {
/*  64 */     return this.dutyCode;
/*     */   }
/*     */ 
/*     */   public void setDutyCode(String aDutyCode) {
/*  68 */     this.dutyCode = aDutyCode;
/*     */   }
/*     */ 
/*     */   public String getGetDutyCode() {
/*  72 */     return this.getDutyCode;
/*     */   }
/*     */ 
/*     */   public void setGetDutyCode(String aGetDutyCode) {
/*  76 */     this.getDutyCode = aGetDutyCode;
/*     */   }
/*     */ 
/*     */   public String getGetDutyName() {
/*  80 */     return this.getDutyName;
/*     */   }
/*     */ 
/*     */   public void setGetDutyName(String aGetDutyName) {
/*  84 */     this.getDutyName = aGetDutyName;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPDutyGetRelaSchema aLNPDutyGetRelaSchema)
/*     */   {
/*  90 */     this.dutyCode = aLNPDutyGetRelaSchema.getDutyCode();
/*  91 */     this.getDutyCode = aLNPDutyGetRelaSchema.getGetDutyCode();
/*  92 */     this.getDutyName = aLNPDutyGetRelaSchema.getGetDutyName();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 101 */       if (rs.getString("DutyCode") == null)
/* 102 */         this.dutyCode = null;
/*     */       else {
/* 104 */         this.dutyCode = rs.getString("DutyCode").trim();
/*     */       }
/* 106 */       if (rs.getString("GetDutyCode") == null)
/* 107 */         this.getDutyCode = null;
/*     */       else {
/* 109 */         this.getDutyCode = rs.getString("GetDutyCode").trim();
/*     */       }
/* 111 */       if (rs.getString("GetDutyName") == null)
/* 112 */         this.getDutyName = null;
/*     */       else {
/* 114 */         this.getDutyName = rs.getString("GetDutyName").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 119 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPDutyGetRela\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 121 */       CError tError = new CError();
/* 122 */       tError.moduleName = "LNPDutyGetRelaSchema";
/* 123 */       tError.functionName = "setSchema";
/* 124 */       tError.errorMessage = sqle.toString();
/* 125 */       this.mErrors.addOneError(tError);
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPDutyGetRelaSchema getSchema()
/*     */   {
/* 133 */     LNPDutyGetRelaSchema aLNPDutyGetRelaSchema = new LNPDutyGetRelaSchema();
/* 134 */     aLNPDutyGetRelaSchema.setSchema(this);
/* 135 */     return aLNPDutyGetRelaSchema;
/*     */   }
/*     */ 
/*     */   public LNPDutyGetRelaDB getDB()
/*     */   {
/* 140 */     LNPDutyGetRelaDB aDBOper = new LNPDutyGetRelaDB();
/* 141 */     aDBOper.setSchema(this);
/* 142 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 149 */     StringBuffer strReturn = new StringBuffer(256);
/* 150 */     strReturn.append(StrTool.cTrim(this.dutyCode)); strReturn.append("|");
/* 151 */     strReturn.append(StrTool.cTrim(this.getDutyCode)); strReturn.append("|");
/* 152 */     strReturn.append(StrTool.cTrim(this.getDutyName));
/* 153 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       this.dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 162 */       this.getDutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 163 */       this.getDutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 168 */       CError tError = new CError();
/* 169 */       tError.moduleName = "LNPDutyGetRelaSchema";
/* 170 */       tError.functionName = "decode";
/* 171 */       tError.errorMessage = ex.toString();
/* 172 */       this.mErrors.addOneError(tError);
/*     */ 
/* 174 */       return false;
/*     */     }
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 182 */     String strReturn = "";
/* 183 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*     */     {
/* 185 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dutyCode));
/*     */     }
/* 187 */     if (FCode.equalsIgnoreCase("getDutyCode"))
/*     */     {
/* 189 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getDutyCode));
/*     */     }
/* 191 */     if (FCode.equalsIgnoreCase("getDutyName"))
/*     */     {
/* 193 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getDutyName));
/*     */     }
/* 195 */     if (strReturn.equals(""))
/*     */     {
/* 197 */       strReturn = "null";
/*     */     }
/*     */ 
/* 200 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 207 */     String strFieldValue = "";
/* 208 */     switch (nFieldIndex) {
/*     */     case 0:
/* 210 */       strFieldValue = StrTool.GBKToUnicode(this.dutyCode);
/* 211 */       break;
/*     */     case 1:
/* 213 */       strFieldValue = StrTool.GBKToUnicode(this.getDutyCode);
/* 214 */       break;
/*     */     case 2:
/* 216 */       strFieldValue = StrTool.GBKToUnicode(this.getDutyName);
/* 217 */       break;
/*     */     default:
/* 219 */       strFieldValue = "";
/*     */     }
/* 221 */     if (strFieldValue.equals("")) {
/* 222 */       strFieldValue = "null";
/*     */     }
/* 224 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 230 */     if (StrTool.cTrim(FCode).equals("")) {
/* 231 */       return false;
/*     */     }
/* 233 */     if (FCode.equalsIgnoreCase("dutyCode"))
/*     */     {
/* 235 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 237 */         this.dutyCode = FValue.trim();
/*     */       }
/*     */       else
/* 240 */         this.dutyCode = null;
/*     */     }
/* 242 */     if (FCode.equalsIgnoreCase("getDutyCode"))
/*     */     {
/* 244 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 246 */         this.getDutyCode = FValue.trim();
/*     */       }
/*     */       else
/* 249 */         this.getDutyCode = null;
/*     */     }
/* 251 */     if (FCode.equalsIgnoreCase("getDutyName"))
/*     */     {
/* 253 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 255 */         this.getDutyName = FValue.trim();
/*     */       }
/*     */       else
/* 258 */         this.getDutyName = null;
/*     */     }
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 265 */     if (otherObject == null) return false;
/* 266 */     if (this == otherObject) return true;
/* 267 */     if (getClass() != otherObject.getClass()) return false;
/* 268 */     LNPDutyGetRelaSchema other = (LNPDutyGetRelaSchema)otherObject;
/* 269 */     if ((this.dutyCode == null) && (other.getDutyCode() != null)) return false;
/* 270 */     if ((this.dutyCode != null) && (!this.dutyCode.equals(other.getDutyCode()))) return false;
/* 271 */     if ((this.getDutyCode == null) && (other.getGetDutyCode() != null)) return false;
/* 272 */     if ((this.getDutyCode != null) && (!this.getDutyCode.equals(other.getGetDutyCode()))) return false;
/* 273 */     if ((this.getDutyName == null) && (other.getGetDutyName() != null)) return false;
/* 274 */     return (this.getDutyName == null) || (this.getDutyName.equals(other.getGetDutyName()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 281 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 287 */     if (strFieldName.equals("dutyCode")) {
/* 288 */       return 0;
/*     */     }
/* 290 */     if (strFieldName.equals("getDutyCode")) {
/* 291 */       return 1;
/*     */     }
/* 293 */     if (strFieldName.equals("getDutyName")) {
/* 294 */       return 2;
/*     */     }
/* 296 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 302 */     String strFieldName = "";
/* 303 */     switch (nFieldIndex) {
/*     */     case 0:
/* 305 */       strFieldName = "dutyCode";
/* 306 */       break;
/*     */     case 1:
/* 308 */       strFieldName = "getDutyCode";
/* 309 */       break;
/*     */     case 2:
/* 311 */       strFieldName = "getDutyName";
/* 312 */       break;
/*     */     default:
/* 314 */       strFieldName = "";
/*     */     }
/* 316 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 322 */     if (strFieldName.equals("dutyCode")) {
/* 323 */       return 0;
/*     */     }
/* 325 */     if (strFieldName.equals("getDutyCode")) {
/* 326 */       return 0;
/*     */     }
/* 328 */     if (strFieldName.equals("getDutyName")) {
/* 329 */       return 0;
/*     */     }
/* 331 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 337 */     int nFieldType = -1;
/* 338 */     switch (nFieldIndex) {
/*     */     case 0:
/* 340 */       nFieldType = 0;
/* 341 */       break;
/*     */     case 1:
/* 343 */       nFieldType = 0;
/* 344 */       break;
/*     */     case 2:
/* 346 */       nFieldType = 0;
/* 347 */       break;
/*     */     default:
/* 349 */       nFieldType = -1;
/*     */     }
/* 351 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPDutyGetRelaSchema
 * JD-Core Version:    0.6.0
 */