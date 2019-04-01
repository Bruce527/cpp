/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPComGrpToComDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPComGrpToComSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String comGrpCode;
/*     */   private String comCode;
/*     */   private String comCodeType;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPComGrpToComSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[2];
/*  41 */     pk[0] = "ComGrpCode";
/*  42 */     pk[1] = "ComCode";
/*     */ 
/*  44 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  51 */     LNPComGrpToComSchema cloned = (LNPComGrpToComSchema)super.clone();
/*  52 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  53 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  59 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getComGrpCode()
/*     */   {
/*  64 */     return this.comGrpCode;
/*     */   }
/*     */ 
/*     */   public void setComGrpCode(String aComGrpCode) {
/*  68 */     this.comGrpCode = aComGrpCode;
/*     */   }
/*     */ 
/*     */   public String getComCode() {
/*  72 */     return this.comCode;
/*     */   }
/*     */ 
/*     */   public void setComCode(String aComCode) {
/*  76 */     this.comCode = aComCode;
/*     */   }
/*     */ 
/*     */   public String getComCodeType() {
/*  80 */     return this.comCodeType;
/*     */   }
/*     */ 
/*     */   public void setComCodeType(String aComCodeType) {
/*  84 */     this.comCodeType = aComCodeType;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPComGrpToComSchema aLNPComGrpToComSchema)
/*     */   {
/*  90 */     this.comGrpCode = aLNPComGrpToComSchema.getComGrpCode();
/*  91 */     this.comCode = aLNPComGrpToComSchema.getComCode();
/*  92 */     this.comCodeType = aLNPComGrpToComSchema.getComCodeType();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 101 */       if (rs.getString("ComGrpCode") == null)
/* 102 */         this.comGrpCode = null;
/*     */       else {
/* 104 */         this.comGrpCode = rs.getString("ComGrpCode").trim();
/*     */       }
/* 106 */       if (rs.getString("ComCode") == null)
/* 107 */         this.comCode = null;
/*     */       else {
/* 109 */         this.comCode = rs.getString("ComCode").trim();
/*     */       }
/* 111 */       if (rs.getString("ComCodeType") == null)
/* 112 */         this.comCodeType = null;
/*     */       else {
/* 114 */         this.comCodeType = rs.getString("ComCodeType").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 119 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPComGrpToCom\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 121 */       CError tError = new CError();
/* 122 */       tError.moduleName = "LNPComGrpToComSchema";
/* 123 */       tError.functionName = "setSchema";
/* 124 */       tError.errorMessage = sqle.toString();
/* 125 */       this.mErrors.addOneError(tError);
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSchema getSchema()
/*     */   {
/* 133 */     LNPComGrpToComSchema aLNPComGrpToComSchema = new LNPComGrpToComSchema();
/* 134 */     aLNPComGrpToComSchema.setSchema(this);
/* 135 */     return aLNPComGrpToComSchema;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComDB getDB()
/*     */   {
/* 140 */     LNPComGrpToComDB aDBOper = new LNPComGrpToComDB();
/* 141 */     aDBOper.setSchema(this);
/* 142 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 149 */     StringBuffer strReturn = new StringBuffer(256);
/* 150 */     strReturn.append(StrTool.cTrim(this.comGrpCode)); strReturn.append("|");
/* 151 */     strReturn.append(StrTool.cTrim(this.comCode)); strReturn.append("|");
/* 152 */     strReturn.append(StrTool.cTrim(this.comCodeType));
/* 153 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       this.comGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 162 */       this.comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 163 */       this.comCodeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 168 */       CError tError = new CError();
/* 169 */       tError.moduleName = "LNPComGrpToComSchema";
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
/* 183 */     if (FCode.equalsIgnoreCase("comGrpCode"))
/*     */     {
/* 185 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comGrpCode));
/*     */     }
/* 187 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 189 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCode));
/*     */     }
/* 191 */     if (FCode.equalsIgnoreCase("comCodeType"))
/*     */     {
/* 193 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCodeType));
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
/* 210 */       strFieldValue = StrTool.GBKToUnicode(this.comGrpCode);
/* 211 */       break;
/*     */     case 1:
/* 213 */       strFieldValue = StrTool.GBKToUnicode(this.comCode);
/* 214 */       break;
/*     */     case 2:
/* 216 */       strFieldValue = StrTool.GBKToUnicode(this.comCodeType);
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
/* 233 */     if (FCode.equalsIgnoreCase("comGrpCode"))
/*     */     {
/* 235 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 237 */         this.comGrpCode = FValue.trim();
/*     */       }
/*     */       else
/* 240 */         this.comGrpCode = null;
/*     */     }
/* 242 */     if (FCode.equalsIgnoreCase("comCode"))
/*     */     {
/* 244 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 246 */         this.comCode = FValue.trim();
/*     */       }
/*     */       else
/* 249 */         this.comCode = null;
/*     */     }
/* 251 */     if (FCode.equalsIgnoreCase("comCodeType"))
/*     */     {
/* 253 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 255 */         this.comCodeType = FValue.trim();
/*     */       }
/*     */       else
/* 258 */         this.comCodeType = null;
/*     */     }
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 265 */     if (otherObject == null) return false;
/* 266 */     if (this == otherObject) return true;
/* 267 */     if (getClass() != otherObject.getClass()) return false;
/* 268 */     LNPComGrpToComSchema other = (LNPComGrpToComSchema)otherObject;
/* 269 */     if ((this.comGrpCode == null) && (other.getComGrpCode() != null)) return false;
/* 270 */     if ((this.comGrpCode != null) && (!this.comGrpCode.equals(other.getComGrpCode()))) return false;
/* 271 */     if ((this.comCode == null) && (other.getComCode() != null)) return false;
/* 272 */     if ((this.comCode != null) && (!this.comCode.equals(other.getComCode()))) return false;
/* 273 */     if ((this.comCodeType == null) && (other.getComCodeType() != null)) return false;
/* 274 */     return (this.comCodeType == null) || (this.comCodeType.equals(other.getComCodeType()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 281 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 287 */     if (strFieldName.equals("comGrpCode")) {
/* 288 */       return 0;
/*     */     }
/* 290 */     if (strFieldName.equals("comCode")) {
/* 291 */       return 1;
/*     */     }
/* 293 */     if (strFieldName.equals("comCodeType")) {
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
/* 305 */       strFieldName = "comGrpCode";
/* 306 */       break;
/*     */     case 1:
/* 308 */       strFieldName = "comCode";
/* 309 */       break;
/*     */     case 2:
/* 311 */       strFieldName = "comCodeType";
/* 312 */       break;
/*     */     default:
/* 314 */       strFieldName = "";
/*     */     }
/* 316 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 322 */     if (strFieldName.equals("comGrpCode")) {
/* 323 */       return 0;
/*     */     }
/* 325 */     if (strFieldName.equals("comCode")) {
/* 326 */       return 0;
/*     */     }
/* 328 */     if (strFieldName.equals("comCodeType")) {
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema
 * JD-Core Version:    0.6.0
 */