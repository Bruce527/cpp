/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPUWQuestionSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String contNo;
/*     */   private String uRL;
/*     */   public static final int FIELDNUM = 2;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPUWQuestionSchema()
/*     */   {
/*  36 */     this.mErrors = new CErrors();
/*     */ 
/*  38 */     String[] pk = new String[1];
/*  39 */     pk[0] = "ContNo";
/*     */ 
/*  41 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  48 */     LNPUWQuestionSchema cloned = (LNPUWQuestionSchema)super.clone();
/*  49 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  50 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  56 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getContNo()
/*     */   {
/*  61 */     return this.contNo;
/*     */   }
/*     */ 
/*     */   public void setContNo(String aContNo) {
/*  65 */     this.contNo = aContNo;
/*     */   }
/*     */ 
/*     */   public String getURL() {
/*  69 */     return this.uRL;
/*     */   }
/*     */ 
/*     */   public void setURL(String aURL) {
/*  73 */     this.uRL = aURL;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPUWQuestionSchema aLNPUWQuestionSchema)
/*     */   {
/*  79 */     this.contNo = aLNPUWQuestionSchema.getContNo();
/*  80 */     this.uRL = aLNPUWQuestionSchema.getURL();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       if (rs.getString("ContNo") == null)
/*  90 */         this.contNo = null;
/*     */       else {
/*  92 */         this.contNo = rs.getString("ContNo").trim();
/*     */       }
/*  94 */       if (rs.getString("URL") == null)
/*  95 */         this.uRL = null;
/*     */       else {
/*  97 */         this.uRL = rs.getString("URL").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 102 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPUWQuestion\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 104 */       CError tError = new CError();
/* 105 */       tError.moduleName = "LNPUWQuestionSchema";
/* 106 */       tError.functionName = "setSchema";
/* 107 */       tError.errorMessage = sqle.toString();
/* 108 */       this.mErrors.addOneError(tError);
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSchema getSchema()
/*     */   {
/* 116 */     LNPUWQuestionSchema aLNPUWQuestionSchema = new LNPUWQuestionSchema();
/* 117 */     aLNPUWQuestionSchema.setSchema(this);
/* 118 */     return aLNPUWQuestionSchema;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionDB getDB()
/*     */   {
/* 123 */     LNPUWQuestionDB aDBOper = new LNPUWQuestionDB();
/* 124 */     aDBOper.setSchema(this);
/* 125 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 132 */     StringBuffer strReturn = new StringBuffer(256);
/* 133 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/* 134 */     strReturn.append(StrTool.cTrim(this.uRL));
/* 135 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 143 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 144 */       this.uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 149 */       CError tError = new CError();
/* 150 */       tError.moduleName = "LNPUWQuestionSchema";
/* 151 */       tError.functionName = "decode";
/* 152 */       tError.errorMessage = ex.toString();
/* 153 */       this.mErrors.addOneError(tError);
/*     */ 
/* 155 */       return false;
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 163 */     String strReturn = "";
/* 164 */     if (FCode.equalsIgnoreCase("contNo"))
/*     */     {
/* 166 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*     */     }
/* 168 */     if (FCode.equalsIgnoreCase("uRL"))
/*     */     {
/* 170 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uRL));
/*     */     }
/* 172 */     if (strReturn.equals(""))
/*     */     {
/* 174 */       strReturn = "null";
/*     */     }
/*     */ 
/* 177 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 184 */     String strFieldValue = "";
/* 185 */     switch (nFieldIndex) {
/*     */     case 0:
/* 187 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 188 */       break;
/*     */     case 1:
/* 190 */       strFieldValue = StrTool.GBKToUnicode(this.uRL);
/* 191 */       break;
/*     */     default:
/* 193 */       strFieldValue = "";
/*     */     }
/* 195 */     if (strFieldValue.equals("")) {
/* 196 */       strFieldValue = "null";
/*     */     }
/* 198 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 204 */     if (StrTool.cTrim(FCode).equals("")) {
/* 205 */       return false;
/*     */     }
/* 207 */     if (FCode.equalsIgnoreCase("contNo"))
/*     */     {
/* 209 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 211 */         this.contNo = FValue.trim();
/*     */       }
/*     */       else
/* 214 */         this.contNo = null;
/*     */     }
/* 216 */     if (FCode.equalsIgnoreCase("uRL"))
/*     */     {
/* 218 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 220 */         this.uRL = FValue.trim();
/*     */       }
/*     */       else
/* 223 */         this.uRL = null;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 230 */     if (otherObject == null) return false;
/* 231 */     if (this == otherObject) return true;
/* 232 */     if (getClass() != otherObject.getClass()) return false;
/* 233 */     LNPUWQuestionSchema other = (LNPUWQuestionSchema)otherObject;
/* 234 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 235 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 236 */     if ((this.uRL == null) && (other.getURL() != null)) return false;
/* 237 */     return (this.uRL == null) || (this.uRL.equals(other.getURL()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 244 */     return 2;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 250 */     if (strFieldName.equals("contNo")) {
/* 251 */       return 0;
/*     */     }
/* 253 */     if (strFieldName.equals("uRL")) {
/* 254 */       return 1;
/*     */     }
/* 256 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 262 */     String strFieldName = "";
/* 263 */     switch (nFieldIndex) {
/*     */     case 0:
/* 265 */       strFieldName = "contNo";
/* 266 */       break;
/*     */     case 1:
/* 268 */       strFieldName = "uRL";
/* 269 */       break;
/*     */     default:
/* 271 */       strFieldName = "";
/*     */     }
/* 273 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 279 */     if (strFieldName.equals("contNo")) {
/* 280 */       return 0;
/*     */     }
/* 282 */     if (strFieldName.equals("uRL")) {
/* 283 */       return 0;
/*     */     }
/* 285 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 291 */     int nFieldType = -1;
/* 292 */     switch (nFieldIndex) {
/*     */     case 0:
/* 294 */       nFieldType = 0;
/* 295 */       break;
/*     */     case 1:
/* 297 */       nFieldType = 0;
/* 298 */       break;
/*     */     default:
/* 300 */       nFieldType = -1;
/*     */     }
/* 302 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPUWQuestionSchema
 * JD-Core Version:    0.6.0
 */