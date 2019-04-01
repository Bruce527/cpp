/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPDutyPayRelaDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPDutyPayRelaSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String dutyCode;
/*     */   private String payPlanCode;
/*     */   private String payPlanName;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPDutyPayRelaSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[2];
/*  41 */     pk[0] = "DutyCode";
/*  42 */     pk[1] = "PayPlanCode";
/*     */ 
/*  44 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  51 */     LNPDutyPayRelaSchema cloned = (LNPDutyPayRelaSchema)super.clone();
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
/*     */   public String getPayPlanCode() {
/*  72 */     return this.payPlanCode;
/*     */   }
/*     */ 
/*     */   public void setPayPlanCode(String aPayPlanCode) {
/*  76 */     this.payPlanCode = aPayPlanCode;
/*     */   }
/*     */ 
/*     */   public String getPayPlanName() {
/*  80 */     return this.payPlanName;
/*     */   }
/*     */ 
/*     */   public void setPayPlanName(String aPayPlanName) {
/*  84 */     this.payPlanName = aPayPlanName;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPDutyPayRelaSchema aLNPDutyPayRelaSchema)
/*     */   {
/*  90 */     this.dutyCode = aLNPDutyPayRelaSchema.getDutyCode();
/*  91 */     this.payPlanCode = aLNPDutyPayRelaSchema.getPayPlanCode();
/*  92 */     this.payPlanName = aLNPDutyPayRelaSchema.getPayPlanName();
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
/* 106 */       if (rs.getString("PayPlanCode") == null)
/* 107 */         this.payPlanCode = null;
/*     */       else {
/* 109 */         this.payPlanCode = rs.getString("PayPlanCode").trim();
/*     */       }
/* 111 */       if (rs.getString("PayPlanName") == null)
/* 112 */         this.payPlanName = null;
/*     */       else {
/* 114 */         this.payPlanName = rs.getString("PayPlanName").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 119 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPDutyPayRela\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 121 */       CError tError = new CError();
/* 122 */       tError.moduleName = "LNPDutyPayRelaSchema";
/* 123 */       tError.functionName = "setSchema";
/* 124 */       tError.errorMessage = sqle.toString();
/* 125 */       this.mErrors.addOneError(tError);
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPDutyPayRelaSchema getSchema()
/*     */   {
/* 133 */     LNPDutyPayRelaSchema aLNPDutyPayRelaSchema = new LNPDutyPayRelaSchema();
/* 134 */     aLNPDutyPayRelaSchema.setSchema(this);
/* 135 */     return aLNPDutyPayRelaSchema;
/*     */   }
/*     */ 
/*     */   public LNPDutyPayRelaDB getDB()
/*     */   {
/* 140 */     LNPDutyPayRelaDB aDBOper = new LNPDutyPayRelaDB();
/* 141 */     aDBOper.setSchema(this);
/* 142 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 149 */     StringBuffer strReturn = new StringBuffer(256);
/* 150 */     strReturn.append(StrTool.cTrim(this.dutyCode)); strReturn.append("|");
/* 151 */     strReturn.append(StrTool.cTrim(this.payPlanCode)); strReturn.append("|");
/* 152 */     strReturn.append(StrTool.cTrim(this.payPlanName));
/* 153 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       this.dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 162 */       this.payPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 163 */       this.payPlanName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 168 */       CError tError = new CError();
/* 169 */       tError.moduleName = "LNPDutyPayRelaSchema";
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
/* 187 */     if (FCode.equalsIgnoreCase("payPlanCode"))
/*     */     {
/* 189 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payPlanCode));
/*     */     }
/* 191 */     if (FCode.equalsIgnoreCase("payPlanName"))
/*     */     {
/* 193 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.payPlanName));
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
/* 213 */       strFieldValue = StrTool.GBKToUnicode(this.payPlanCode);
/* 214 */       break;
/*     */     case 2:
/* 216 */       strFieldValue = StrTool.GBKToUnicode(this.payPlanName);
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
/* 242 */     if (FCode.equalsIgnoreCase("payPlanCode"))
/*     */     {
/* 244 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 246 */         this.payPlanCode = FValue.trim();
/*     */       }
/*     */       else
/* 249 */         this.payPlanCode = null;
/*     */     }
/* 251 */     if (FCode.equalsIgnoreCase("payPlanName"))
/*     */     {
/* 253 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 255 */         this.payPlanName = FValue.trim();
/*     */       }
/*     */       else
/* 258 */         this.payPlanName = null;
/*     */     }
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 265 */     if (otherObject == null) return false;
/* 266 */     if (this == otherObject) return true;
/* 267 */     if (getClass() != otherObject.getClass()) return false;
/* 268 */     LNPDutyPayRelaSchema other = (LNPDutyPayRelaSchema)otherObject;
/* 269 */     if ((this.dutyCode == null) && (other.getDutyCode() != null)) return false;
/* 270 */     if ((this.dutyCode != null) && (!this.dutyCode.equals(other.getDutyCode()))) return false;
/* 271 */     if ((this.payPlanCode == null) && (other.getPayPlanCode() != null)) return false;
/* 272 */     if ((this.payPlanCode != null) && (!this.payPlanCode.equals(other.getPayPlanCode()))) return false;
/* 273 */     if ((this.payPlanName == null) && (other.getPayPlanName() != null)) return false;
/* 274 */     return (this.payPlanName == null) || (this.payPlanName.equals(other.getPayPlanName()));
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
/* 290 */     if (strFieldName.equals("payPlanCode")) {
/* 291 */       return 1;
/*     */     }
/* 293 */     if (strFieldName.equals("payPlanName")) {
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
/* 308 */       strFieldName = "payPlanCode";
/* 309 */       break;
/*     */     case 2:
/* 311 */       strFieldName = "payPlanName";
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
/* 325 */     if (strFieldName.equals("payPlanCode")) {
/* 326 */       return 0;
/*     */     }
/* 328 */     if (strFieldName.equals("payPlanName")) {
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPDutyPayRelaSchema
 * JD-Core Version:    0.6.0
 */