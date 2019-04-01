/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MMaxNoDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MMaxNoSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String noType;
/*     */   private String noLimit;
/*     */   private int maxNo;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MMaxNoSchema()
/*     */   {
/*  35 */     this.mErrors = new CErrors();
/*     */ 
/*  37 */     String[] pk = new String[2];
/*  38 */     pk[0] = "NoType";
/*  39 */     pk[1] = "NoLimit";
/*     */ 
/*  41 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  48 */     MMaxNoSchema cloned = (MMaxNoSchema)super.clone();
/*  49 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  50 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  56 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getNoType()
/*     */   {
/*  61 */     return this.noType;
/*     */   }
/*     */ 
/*     */   public void setNoType(String aNoType) {
/*  65 */     this.noType = aNoType;
/*     */   }
/*     */ 
/*     */   public String getNoLimit() {
/*  69 */     return this.noLimit;
/*     */   }
/*     */ 
/*     */   public void setNoLimit(String aNoLimit) {
/*  73 */     this.noLimit = aNoLimit;
/*     */   }
/*     */ 
/*     */   public int getMaxNo() {
/*  77 */     return this.maxNo;
/*     */   }
/*     */ 
/*     */   public void setMaxNo(int aMaxNo) {
/*  81 */     this.maxNo = aMaxNo;
/*     */   }
/*     */ 
/*     */   public void setMaxNo(String aMaxNo) {
/*  85 */     if ((aMaxNo != null) && (!aMaxNo.equals("")))
/*     */     {
/*  87 */       Integer tInteger = new Integer(aMaxNo);
/*  88 */       int i = tInteger.intValue();
/*  89 */       this.maxNo = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(MMaxNoSchema aMMaxNoSchema)
/*     */   {
/*  97 */     this.noType = aMMaxNoSchema.getNoType();
/*  98 */     this.noLimit = aMMaxNoSchema.getNoLimit();
/*  99 */     this.maxNo = aMMaxNoSchema.getMaxNo();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 108 */       if (rs.getString("NoType") == null)
/* 109 */         this.noType = null;
/*     */       else {
/* 111 */         this.noType = rs.getString("NoType").trim();
/*     */       }
/* 113 */       if (rs.getString("NoLimit") == null)
/* 114 */         this.noLimit = null;
/*     */       else {
/* 116 */         this.noLimit = rs.getString("NoLimit").trim();
/*     */       }
/* 118 */       this.maxNo = rs.getInt("MaxNo");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 122 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MMaxNo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 124 */       CError tError = new CError();
/* 125 */       tError.moduleName = "MMaxNoSchema";
/* 126 */       tError.functionName = "setSchema";
/* 127 */       tError.errorMessage = sqle.toString();
/* 128 */       this.mErrors.addOneError(tError);
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */   public MMaxNoSchema getSchema()
/*     */   {
/* 136 */     MMaxNoSchema aMMaxNoSchema = new MMaxNoSchema();
/* 137 */     aMMaxNoSchema.setSchema(this);
/* 138 */     return aMMaxNoSchema;
/*     */   }
/*     */ 
/*     */   public MMaxNoDB getDB()
/*     */   {
/* 143 */     MMaxNoDB aDBOper = new MMaxNoDB();
/* 144 */     aDBOper.setSchema(this);
/* 145 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 152 */     StringBuffer strReturn = new StringBuffer(256);
/* 153 */     strReturn.append(StrTool.cTrim(this.noType)); strReturn.append("|");
/* 154 */     strReturn.append(StrTool.cTrim(this.noLimit)); strReturn.append("|");
/* 155 */     strReturn.append(ChgData.chgData(this.maxNo));
/* 156 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 164 */       this.noType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 165 */       this.noLimit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 166 */       this.maxNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|"))).intValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 171 */       CError tError = new CError();
/* 172 */       tError.moduleName = "MMaxNoSchema";
/* 173 */       tError.functionName = "decode";
/* 174 */       tError.errorMessage = ex.toString();
/* 175 */       this.mErrors.addOneError(tError);
/*     */ 
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 185 */     String strReturn = "";
/* 186 */     if (FCode.equalsIgnoreCase("noType"))
/*     */     {
/* 188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noType));
/*     */     }
/* 190 */     if (FCode.equalsIgnoreCase("noLimit"))
/*     */     {
/* 192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noLimit));
/*     */     }
/* 194 */     if (FCode.equalsIgnoreCase("maxNo"))
/*     */     {
/* 196 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maxNo));
/*     */     }
/* 198 */     if (strReturn.equals(""))
/*     */     {
/* 200 */       strReturn = "null";
/*     */     }
/*     */ 
/* 203 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 210 */     String strFieldValue = "";
/* 211 */     switch (nFieldIndex) {
/*     */     case 0:
/* 213 */       strFieldValue = StrTool.GBKToUnicode(this.noType);
/* 214 */       break;
/*     */     case 1:
/* 216 */       strFieldValue = StrTool.GBKToUnicode(this.noLimit);
/* 217 */       break;
/*     */     case 2:
/* 219 */       strFieldValue = String.valueOf(this.maxNo);
/* 220 */       break;
/*     */     default:
/* 222 */       strFieldValue = "";
/*     */     }
/* 224 */     if (strFieldValue.equals("")) {
/* 225 */       strFieldValue = "null";
/*     */     }
/* 227 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 233 */     if (StrTool.cTrim(FCode).equals("")) {
/* 234 */       return false;
/*     */     }
/* 236 */     if (FCode.equalsIgnoreCase("noType"))
/*     */     {
/* 238 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 240 */         this.noType = FValue.trim();
/*     */       }
/*     */       else
/* 243 */         this.noType = null;
/*     */     }
/* 245 */     if (FCode.equalsIgnoreCase("noLimit"))
/*     */     {
/* 247 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 249 */         this.noLimit = FValue.trim();
/*     */       }
/*     */       else
/* 252 */         this.noLimit = null;
/*     */     }
/* 254 */     if (FCode.equalsIgnoreCase("maxNo"))
/*     */     {
/* 256 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 258 */         Integer tInteger = new Integer(FValue);
/* 259 */         int i = tInteger.intValue();
/* 260 */         this.maxNo = i;
/*     */       }
/*     */     }
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 268 */     if (otherObject == null) return false;
/* 269 */     if (this == otherObject) return true;
/* 270 */     if (getClass() != otherObject.getClass()) return false;
/* 271 */     MMaxNoSchema other = (MMaxNoSchema)otherObject;
/* 272 */     if ((this.noType == null) && (other.getNoType() != null)) return false;
/* 273 */     if ((this.noType != null) && (!this.noType.equals(other.getNoType()))) return false;
/* 274 */     if ((this.noLimit == null) && (other.getNoLimit() != null)) return false;
/* 275 */     if ((this.noLimit != null) && (!this.noLimit.equals(other.getNoLimit()))) return false;
/* 276 */     return this.maxNo == other.getMaxNo();
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 283 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 289 */     if (strFieldName.equals("noType")) {
/* 290 */       return 0;
/*     */     }
/* 292 */     if (strFieldName.equals("noLimit")) {
/* 293 */       return 1;
/*     */     }
/* 295 */     if (strFieldName.equals("maxNo")) {
/* 296 */       return 2;
/*     */     }
/* 298 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 304 */     String strFieldName = "";
/* 305 */     switch (nFieldIndex) {
/*     */     case 0:
/* 307 */       strFieldName = "noType";
/* 308 */       break;
/*     */     case 1:
/* 310 */       strFieldName = "noLimit";
/* 311 */       break;
/*     */     case 2:
/* 313 */       strFieldName = "maxNo";
/* 314 */       break;
/*     */     default:
/* 316 */       strFieldName = "";
/*     */     }
/* 318 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 324 */     if (strFieldName.equals("noType")) {
/* 325 */       return 0;
/*     */     }
/* 327 */     if (strFieldName.equals("noLimit")) {
/* 328 */       return 0;
/*     */     }
/* 330 */     if (strFieldName.equals("maxNo")) {
/* 331 */       return 3;
/*     */     }
/* 333 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 339 */     int nFieldType = -1;
/* 340 */     switch (nFieldIndex) {
/*     */     case 0:
/* 342 */       nFieldType = 0;
/* 343 */       break;
/*     */     case 1:
/* 345 */       nFieldType = 0;
/* 346 */       break;
/*     */     case 2:
/* 348 */       nFieldType = 3;
/* 349 */       break;
/*     */     default:
/* 351 */       nFieldType = -1;
/*     */     }
/* 353 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MMaxNoSchema
 * JD-Core Version:    0.6.0
 */