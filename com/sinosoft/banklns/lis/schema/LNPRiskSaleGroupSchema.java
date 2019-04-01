/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskSaleGroupDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPRiskSaleGroupSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String groupCode;
/*     */   private String groupName;
/*     */   private String groupDescribe;
/*     */   public static final int FIELDNUM = 3;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskSaleGroupSchema()
/*     */   {
/*  38 */     this.mErrors = new CErrors();
/*     */ 
/*  40 */     String[] pk = new String[1];
/*  41 */     pk[0] = "GroupCode";
/*     */ 
/*  43 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  50 */     LNPRiskSaleGroupSchema cloned = (LNPRiskSaleGroupSchema)super.clone();
/*  51 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  52 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  58 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getGroupCode()
/*     */   {
/*  63 */     return this.groupCode;
/*     */   }
/*     */ 
/*     */   public void setGroupCode(String aGroupCode) {
/*  67 */     this.groupCode = aGroupCode;
/*     */   }
/*     */ 
/*     */   public String getGroupName() {
/*  71 */     return this.groupName;
/*     */   }
/*     */ 
/*     */   public void setGroupName(String aGroupName) {
/*  75 */     this.groupName = aGroupName;
/*     */   }
/*     */ 
/*     */   public String getGroupDescribe() {
/*  79 */     return this.groupDescribe;
/*     */   }
/*     */ 
/*     */   public void setGroupDescribe(String aGroupDescribe) {
/*  83 */     this.groupDescribe = aGroupDescribe;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskSaleGroupSchema aLNPRiskSaleGroupSchema)
/*     */   {
/*  89 */     this.groupCode = aLNPRiskSaleGroupSchema.getGroupCode();
/*  90 */     this.groupName = aLNPRiskSaleGroupSchema.getGroupName();
/*  91 */     this.groupDescribe = aLNPRiskSaleGroupSchema.getGroupDescribe();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       if (rs.getString("GroupCode") == null)
/* 101 */         this.groupCode = null;
/*     */       else {
/* 103 */         this.groupCode = rs.getString("GroupCode").trim();
/*     */       }
/* 105 */       if (rs.getString("GroupName") == null)
/* 106 */         this.groupName = null;
/*     */       else {
/* 108 */         this.groupName = rs.getString("GroupName").trim();
/*     */       }
/* 110 */       if (rs.getString("GroupDescribe") == null)
/* 111 */         this.groupDescribe = null;
/*     */       else {
/* 113 */         this.groupDescribe = rs.getString("GroupDescribe").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 118 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskSaleGroup\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 120 */       CError tError = new CError();
/* 121 */       tError.moduleName = "LNPRiskSaleGroupSchema";
/* 122 */       tError.functionName = "setSchema";
/* 123 */       tError.errorMessage = sqle.toString();
/* 124 */       this.mErrors.addOneError(tError);
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSchema getSchema()
/*     */   {
/* 132 */     LNPRiskSaleGroupSchema aLNPRiskSaleGroupSchema = new LNPRiskSaleGroupSchema();
/* 133 */     aLNPRiskSaleGroupSchema.setSchema(this);
/* 134 */     return aLNPRiskSaleGroupSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupDB getDB()
/*     */   {
/* 139 */     LNPRiskSaleGroupDB aDBOper = new LNPRiskSaleGroupDB();
/* 140 */     aDBOper.setSchema(this);
/* 141 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 148 */     StringBuffer strReturn = new StringBuffer(256);
/* 149 */     strReturn.append(StrTool.cTrim(this.groupCode)); strReturn.append("|");
/* 150 */     strReturn.append(StrTool.cTrim(this.groupName)); strReturn.append("|");
/* 151 */     strReturn.append(StrTool.cTrim(this.groupDescribe));
/* 152 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 160 */       this.groupCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 161 */       this.groupName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 162 */       this.groupDescribe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 167 */       CError tError = new CError();
/* 168 */       tError.moduleName = "LNPRiskSaleGroupSchema";
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
/* 182 */     if (FCode.equalsIgnoreCase("groupCode"))
/*     */     {
/* 184 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.groupCode));
/*     */     }
/* 186 */     if (FCode.equalsIgnoreCase("groupName"))
/*     */     {
/* 188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.groupName));
/*     */     }
/* 190 */     if (FCode.equalsIgnoreCase("groupDescribe"))
/*     */     {
/* 192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.groupDescribe));
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
/* 209 */       strFieldValue = StrTool.GBKToUnicode(this.groupCode);
/* 210 */       break;
/*     */     case 1:
/* 212 */       strFieldValue = StrTool.GBKToUnicode(this.groupName);
/* 213 */       break;
/*     */     case 2:
/* 215 */       strFieldValue = StrTool.GBKToUnicode(this.groupDescribe);
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
/* 232 */     if (FCode.equalsIgnoreCase("groupCode"))
/*     */     {
/* 234 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 236 */         this.groupCode = FValue.trim();
/*     */       }
/*     */       else
/* 239 */         this.groupCode = null;
/*     */     }
/* 241 */     if (FCode.equalsIgnoreCase("groupName"))
/*     */     {
/* 243 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 245 */         this.groupName = FValue.trim();
/*     */       }
/*     */       else
/* 248 */         this.groupName = null;
/*     */     }
/* 250 */     if (FCode.equalsIgnoreCase("groupDescribe"))
/*     */     {
/* 252 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 254 */         this.groupDescribe = FValue.trim();
/*     */       }
/*     */       else
/* 257 */         this.groupDescribe = null;
/*     */     }
/* 259 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 264 */     if (otherObject == null) return false;
/* 265 */     if (this == otherObject) return true;
/* 266 */     if (getClass() != otherObject.getClass()) return false;
/* 267 */     LNPRiskSaleGroupSchema other = (LNPRiskSaleGroupSchema)otherObject;
/* 268 */     if ((this.groupCode == null) && (other.getGroupCode() != null)) return false;
/* 269 */     if ((this.groupCode != null) && (!this.groupCode.equals(other.getGroupCode()))) return false;
/* 270 */     if ((this.groupName == null) && (other.getGroupName() != null)) return false;
/* 271 */     if ((this.groupName != null) && (!this.groupName.equals(other.getGroupName()))) return false;
/* 272 */     if ((this.groupDescribe == null) && (other.getGroupDescribe() != null)) return false;
/* 273 */     return (this.groupDescribe == null) || (this.groupDescribe.equals(other.getGroupDescribe()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 280 */     return 3;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 286 */     if (strFieldName.equals("groupCode")) {
/* 287 */       return 0;
/*     */     }
/* 289 */     if (strFieldName.equals("groupName")) {
/* 290 */       return 1;
/*     */     }
/* 292 */     if (strFieldName.equals("groupDescribe")) {
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
/* 304 */       strFieldName = "groupCode";
/* 305 */       break;
/*     */     case 1:
/* 307 */       strFieldName = "groupName";
/* 308 */       break;
/*     */     case 2:
/* 310 */       strFieldName = "groupDescribe";
/* 311 */       break;
/*     */     default:
/* 313 */       strFieldName = "";
/*     */     }
/* 315 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 321 */     if (strFieldName.equals("groupCode")) {
/* 322 */       return 0;
/*     */     }
/* 324 */     if (strFieldName.equals("groupName")) {
/* 325 */       return 0;
/*     */     }
/* 327 */     if (strFieldName.equals("groupDescribe")) {
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
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupSchema
 * JD-Core Version:    0.6.0
 */