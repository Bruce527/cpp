/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPMaxNoDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPMaxNoSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String noType;
/*     */   private String noLimit;
/*     */   private int maxNo;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPMaxNoSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[2];
/*  41 */     pk[0] = "NoType";
/*  42 */     pk[1] = "NoLimit";
/*     */ 
/*  44 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  51 */     LNPMaxNoSchema cloned = (LNPMaxNoSchema)super.clone();
/*  52 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  53 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  59 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getNoType()
/*     */   {
/*  64 */     return this.noType;
/*     */   }
/*     */ 
/*     */   public void setNoType(String aNoType) {
/*  68 */     this.noType = aNoType;
/*     */   }
/*     */ 
/*     */   public String getNoLimit() {
/*  72 */     return this.noLimit;
/*     */   }
/*     */ 
/*     */   public void setNoLimit(String aNoLimit) {
/*  76 */     this.noLimit = aNoLimit;
/*     */   }
/*     */ 
/*     */   public int getMaxNo() {
/*  80 */     return this.maxNo;
/*     */   }
/*     */ 
/*     */   public void setMaxNo(int aMaxNo) {
/*  84 */     this.maxNo = aMaxNo;
/*     */   }
/*     */ 
/*     */   public void setMaxNo(String aMaxNo) {
/*  88 */     if ((aMaxNo != null) && (!aMaxNo.equals("")))
/*     */     {
/*  90 */       Integer tInteger = new Integer(aMaxNo);
/*  91 */       int i = tInteger.intValue();
/*  92 */       this.maxNo = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPMaxNoSchema aLNPMaxNoSchema)
/*     */   {
/* 100 */     this.noType = aLNPMaxNoSchema.getNoType();
/* 101 */     this.noLimit = aLNPMaxNoSchema.getNoLimit();
/* 102 */     this.maxNo = aLNPMaxNoSchema.getMaxNo();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 111 */       if (rs.getString("NoType") == null)
/* 112 */         this.noType = null;
/*     */       else {
/* 114 */         this.noType = rs.getString("NoType").trim();
/*     */       }
/* 116 */       if (rs.getString("NoLimit") == null)
/* 117 */         this.noLimit = null;
/*     */       else {
/* 119 */         this.noLimit = rs.getString("NoLimit").trim();
/*     */       }
/* 121 */       this.maxNo = rs.getInt("MaxNo");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 125 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPMaxNo\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 127 */       CError tError = new CError();
/* 128 */       tError.moduleName = "LNPMaxNoSchema";
/* 129 */       tError.functionName = "setSchema";
/* 130 */       tError.errorMessage = sqle.toString();
/* 131 */       this.mErrors.addOneError(tError);
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSchema getSchema()
/*     */   {
/* 139 */     LNPMaxNoSchema aLNPMaxNoSchema = new LNPMaxNoSchema();
/* 140 */     aLNPMaxNoSchema.setSchema(this);
/* 141 */     return aLNPMaxNoSchema;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoDB getDB()
/*     */   {
/* 146 */     LNPMaxNoDB aDBOper = new LNPMaxNoDB();
/* 147 */     aDBOper.setSchema(this);
/* 148 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 155 */     StringBuffer strReturn = new StringBuffer(256);
/* 156 */     strReturn.append(StrTool.cTrim(this.noType)); strReturn.append("|");
/* 157 */     strReturn.append(StrTool.cTrim(this.noLimit)); strReturn.append("|");
/* 158 */     strReturn.append(ChgData.chgData(this.maxNo));
/* 159 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 167 */       this.noType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 168 */       this.noLimit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 169 */       this.maxNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|"))).intValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 174 */       CError tError = new CError();
/* 175 */       tError.moduleName = "LNPMaxNoSchema";
/* 176 */       tError.functionName = "decode";
/* 177 */       tError.errorMessage = ex.toString();
/* 178 */       this.mErrors.addOneError(tError);
/*     */ 
/* 180 */       return false;
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 188 */     String strReturn = "";
/* 189 */     if (FCode.equalsIgnoreCase("noType"))
/*     */     {
/* 191 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noType));
/*     */     }
/* 193 */     if (FCode.equalsIgnoreCase("noLimit"))
/*     */     {
/* 195 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noLimit));
/*     */     }
/* 197 */     if (FCode.equalsIgnoreCase("maxNo"))
/*     */     {
/* 199 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxNo));
/*     */     }
/* 201 */     if (strReturn.equals(""))
/*     */     {
/* 203 */       strReturn = "null";
/*     */     }
/*     */ 
/* 206 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 213 */     String strFieldValue = "";
/* 214 */     switch (nFieldIndex) {
/*     */     case 0:
/* 216 */       strFieldValue = StrTool.GBKToUnicode(this.noType);
/* 217 */       break;
/*     */     case 1:
/* 219 */       strFieldValue = StrTool.GBKToUnicode(this.noLimit);
/* 220 */       break;
/*     */     case 2:
/* 222 */       strFieldValue = String.valueOf(this.maxNo);
/* 223 */       break;
/*     */     default:
/* 225 */       strFieldValue = "";
/*     */     }
/* 227 */     if (strFieldValue.equals("")) {
/* 228 */       strFieldValue = "null";
/*     */     }
/* 230 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 236 */     if (StrTool.cTrim(FCode).equals("")) {
/* 237 */       return false;
/*     */     }
/* 239 */     if (FCode.equalsIgnoreCase("noType"))
/*     */     {
/* 241 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 243 */         this.noType = FValue.trim();
/*     */       }
/*     */       else
/* 246 */         this.noType = null;
/*     */     }
/* 248 */     if (FCode.equalsIgnoreCase("noLimit"))
/*     */     {
/* 250 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 252 */         this.noLimit = FValue.trim();
/*     */       }
/*     */       else
/* 255 */         this.noLimit = null;
/*     */     }
/* 257 */     if (FCode.equalsIgnoreCase("maxNo"))
/*     */     {
/* 259 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 261 */         Integer tInteger = new Integer(FValue);
/* 262 */         int i = tInteger.intValue();
/* 263 */         this.maxNo = i;
/*     */       }
/*     */     }
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 271 */     if (otherObject == null) return false;
/* 272 */     if (this == otherObject) return true;
/* 273 */     if (getClass() != otherObject.getClass()) return false;
/* 274 */     LNPMaxNoSchema other = (LNPMaxNoSchema)otherObject;
/* 275 */     if ((this.noType == null) && (other.getNoType() != null)) return false;
/* 276 */     if ((this.noType != null) && (!this.noType.equals(other.getNoType()))) return false;
/* 277 */     if ((this.noLimit == null) && (other.getNoLimit() != null)) return false;
/* 278 */     if ((this.noLimit != null) && (!this.noLimit.equals(other.getNoLimit()))) return false;
/* 279 */     return this.maxNo == other.getMaxNo();
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 286 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 292 */     if (strFieldName.equals("noType")) {
/* 293 */       return 0;
/*     */     }
/* 295 */     if (strFieldName.equals("noLimit")) {
/* 296 */       return 1;
/*     */     }
/* 298 */     if (strFieldName.equals("maxNo")) {
/* 299 */       return 2;
/*     */     }
/* 301 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 307 */     String strFieldName = "";
/* 308 */     switch (nFieldIndex) {
/*     */     case 0:
/* 310 */       strFieldName = "noType";
/* 311 */       break;
/*     */     case 1:
/* 313 */       strFieldName = "noLimit";
/* 314 */       break;
/*     */     case 2:
/* 316 */       strFieldName = "maxNo";
/* 317 */       break;
/*     */     default:
/* 319 */       strFieldName = "";
/*     */     }
/* 321 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 327 */     if (strFieldName.equals("noType")) {
/* 328 */       return 0;
/*     */     }
/* 330 */     if (strFieldName.equals("noLimit")) {
/* 331 */       return 0;
/*     */     }
/* 333 */     if (strFieldName.equals("maxNo")) {
/* 334 */       return 3;
/*     */     }
/* 336 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 342 */     int nFieldType = -1;
/* 343 */     switch (nFieldIndex) {
/*     */     case 0:
/* 345 */       nFieldType = 0;
/* 346 */       break;
/*     */     case 1:
/* 348 */       nFieldType = 0;
/* 349 */       break;
/*     */     case 2:
/* 351 */       nFieldType = 3;
/* 352 */       break;
/*     */     default:
/* 354 */       nFieldType = -1;
/*     */     }
/* 356 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPMaxNoSchema
 * JD-Core Version:    0.6.0
 */