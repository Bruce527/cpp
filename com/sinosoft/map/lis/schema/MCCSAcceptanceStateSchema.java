/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MCCSAcceptanceStateDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MCCSAcceptanceStateSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String serviceNo;
/*     */   private String agentCode;
/*     */   private String status;
/*     */   private String bY1;
/*     */   private String bY2;
/*     */   private String bY3;
/*     */   public static final int FIELDNUM = 6;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MCCSAcceptanceStateSchema()
/*     */   {
/*  41 */     this.mErrors = new CErrors();
/*     */ 
/*  43 */     String[] pk = new String[2];
/*  44 */     pk[0] = "ServiceNo";
/*  45 */     pk[1] = "AgentCode";
/*     */ 
/*  47 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  54 */     MCCSAcceptanceStateSchema cloned = (MCCSAcceptanceStateSchema)super.clone();
/*  55 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  56 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  62 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getServiceNo()
/*     */   {
/*  67 */     return this.serviceNo;
/*     */   }
/*     */ 
/*     */   public void setServiceNo(String aServiceNo) {
/*  71 */     this.serviceNo = aServiceNo;
/*     */   }
/*     */ 
/*     */   public String getAgentCode() {
/*  75 */     return this.agentCode;
/*     */   }
/*     */ 
/*     */   public void setAgentCode(String aAgentCode) {
/*  79 */     this.agentCode = aAgentCode;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  83 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String aStatus) {
/*  87 */     this.status = aStatus;
/*     */   }
/*     */ 
/*     */   public String getBY1() {
/*  91 */     return this.bY1;
/*     */   }
/*     */ 
/*     */   public void setBY1(String aBY1) {
/*  95 */     this.bY1 = aBY1;
/*     */   }
/*     */ 
/*     */   public String getBY2() {
/*  99 */     return this.bY2;
/*     */   }
/*     */ 
/*     */   public void setBY2(String aBY2) {
/* 103 */     this.bY2 = aBY2;
/*     */   }
/*     */ 
/*     */   public String getBY3() {
/* 107 */     return this.bY3;
/*     */   }
/*     */ 
/*     */   public void setBY3(String aBY3) {
/* 111 */     this.bY3 = aBY3;
/*     */   }
/*     */ 
/*     */   public void setSchema(MCCSAcceptanceStateSchema aMCCSAcceptanceStateSchema)
/*     */   {
/* 117 */     this.serviceNo = aMCCSAcceptanceStateSchema.getServiceNo();
/* 118 */     this.agentCode = aMCCSAcceptanceStateSchema.getAgentCode();
/* 119 */     this.status = aMCCSAcceptanceStateSchema.getStatus();
/* 120 */     this.bY1 = aMCCSAcceptanceStateSchema.getBY1();
/* 121 */     this.bY2 = aMCCSAcceptanceStateSchema.getBY2();
/* 122 */     this.bY3 = aMCCSAcceptanceStateSchema.getBY3();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 131 */       if (rs.getString("ServiceNo") == null)
/* 132 */         this.serviceNo = null;
/*     */       else {
/* 134 */         this.serviceNo = rs.getString("ServiceNo").trim();
/*     */       }
/* 136 */       if (rs.getString("AgentCode") == null)
/* 137 */         this.agentCode = null;
/*     */       else {
/* 139 */         this.agentCode = rs.getString("AgentCode").trim();
/*     */       }
/* 141 */       if (rs.getString("Status") == null)
/* 142 */         this.status = null;
/*     */       else {
/* 144 */         this.status = rs.getString("Status").trim();
/*     */       }
/* 146 */       if (rs.getString("BY1") == null)
/* 147 */         this.bY1 = null;
/*     */       else {
/* 149 */         this.bY1 = rs.getString("BY1").trim();
/*     */       }
/* 151 */       if (rs.getString("BY2") == null)
/* 152 */         this.bY2 = null;
/*     */       else {
/* 154 */         this.bY2 = rs.getString("BY2").trim();
/*     */       }
/* 156 */       if (rs.getString("BY3") == null)
/* 157 */         this.bY3 = null;
/*     */       else {
/* 159 */         this.bY3 = rs.getString("BY3").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 164 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MCCSAcceptanceState\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 166 */       CError tError = new CError();
/* 167 */       tError.moduleName = "MCCSAcceptanceStateSchema";
/* 168 */       tError.functionName = "setSchema";
/* 169 */       tError.errorMessage = sqle.toString();
/* 170 */       this.mErrors.addOneError(tError);
/* 171 */       return false;
/*     */     }
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateSchema getSchema()
/*     */   {
/* 178 */     MCCSAcceptanceStateSchema aMCCSAcceptanceStateSchema = new MCCSAcceptanceStateSchema();
/* 179 */     aMCCSAcceptanceStateSchema.setSchema(this);
/* 180 */     return aMCCSAcceptanceStateSchema;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateDB getDB()
/*     */   {
/* 185 */     MCCSAcceptanceStateDB aDBOper = new MCCSAcceptanceStateDB();
/* 186 */     aDBOper.setSchema(this);
/* 187 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 194 */     StringBuffer strReturn = new StringBuffer(256);
/* 195 */     strReturn.append(StrTool.cTrim(this.serviceNo)); strReturn.append("|");
/* 196 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/* 197 */     strReturn.append(StrTool.cTrim(this.status)); strReturn.append("|");
/* 198 */     strReturn.append(StrTool.cTrim(this.bY1)); strReturn.append("|");
/* 199 */     strReturn.append(StrTool.cTrim(this.bY2)); strReturn.append("|");
/* 200 */     strReturn.append(StrTool.cTrim(this.bY3));
/* 201 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 209 */       this.serviceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 210 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 211 */       this.status = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 212 */       this.bY1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 213 */       this.bY2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 214 */       this.bY3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 219 */       CError tError = new CError();
/* 220 */       tError.moduleName = "MCCSAcceptanceStateSchema";
/* 221 */       tError.functionName = "decode";
/* 222 */       tError.errorMessage = ex.toString();
/* 223 */       this.mErrors.addOneError(tError);
/*     */ 
/* 225 */       return false;
/*     */     }
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 233 */     String strReturn = "";
/* 234 */     if (FCode.equalsIgnoreCase("serviceNo"))
/*     */     {
/* 236 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serviceNo));
/*     */     }
/* 238 */     if (FCode.equalsIgnoreCase("agentCode"))
/*     */     {
/* 240 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*     */     }
/* 242 */     if (FCode.equalsIgnoreCase("status"))
/*     */     {
/* 244 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.status));
/*     */     }
/* 246 */     if (FCode.equalsIgnoreCase("bY1"))
/*     */     {
/* 248 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bY1));
/*     */     }
/* 250 */     if (FCode.equalsIgnoreCase("bY2"))
/*     */     {
/* 252 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bY2));
/*     */     }
/* 254 */     if (FCode.equalsIgnoreCase("bY3"))
/*     */     {
/* 256 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bY3));
/*     */     }
/* 258 */     if (strReturn.equals(""))
/*     */     {
/* 260 */       strReturn = "null";
/*     */     }
/*     */ 
/* 263 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 270 */     String strFieldValue = "";
/* 271 */     switch (nFieldIndex) {
/*     */     case 0:
/* 273 */       strFieldValue = StrTool.GBKToUnicode(this.serviceNo);
/* 274 */       break;
/*     */     case 1:
/* 276 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/* 277 */       break;
/*     */     case 2:
/* 279 */       strFieldValue = StrTool.GBKToUnicode(this.status);
/* 280 */       break;
/*     */     case 3:
/* 282 */       strFieldValue = StrTool.GBKToUnicode(this.bY1);
/* 283 */       break;
/*     */     case 4:
/* 285 */       strFieldValue = StrTool.GBKToUnicode(this.bY2);
/* 286 */       break;
/*     */     case 5:
/* 288 */       strFieldValue = StrTool.GBKToUnicode(this.bY3);
/* 289 */       break;
/*     */     default:
/* 291 */       strFieldValue = "";
/*     */     }
/* 293 */     if (strFieldValue.equals("")) {
/* 294 */       strFieldValue = "null";
/*     */     }
/* 296 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 302 */     if (StrTool.cTrim(FCode).equals("")) {
/* 303 */       return false;
/*     */     }
/* 305 */     if (FCode.equalsIgnoreCase("serviceNo"))
/*     */     {
/* 307 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 309 */         this.serviceNo = FValue.trim();
/*     */       }
/*     */       else
/* 312 */         this.serviceNo = null;
/*     */     }
/* 314 */     if (FCode.equalsIgnoreCase("agentCode"))
/*     */     {
/* 316 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 318 */         this.agentCode = FValue.trim();
/*     */       }
/*     */       else
/* 321 */         this.agentCode = null;
/*     */     }
/* 323 */     if (FCode.equalsIgnoreCase("status"))
/*     */     {
/* 325 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 327 */         this.status = FValue.trim();
/*     */       }
/*     */       else
/* 330 */         this.status = null;
/*     */     }
/* 332 */     if (FCode.equalsIgnoreCase("bY1"))
/*     */     {
/* 334 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 336 */         this.bY1 = FValue.trim();
/*     */       }
/*     */       else
/* 339 */         this.bY1 = null;
/*     */     }
/* 341 */     if (FCode.equalsIgnoreCase("bY2"))
/*     */     {
/* 343 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 345 */         this.bY2 = FValue.trim();
/*     */       }
/*     */       else
/* 348 */         this.bY2 = null;
/*     */     }
/* 350 */     if (FCode.equalsIgnoreCase("bY3"))
/*     */     {
/* 352 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 354 */         this.bY3 = FValue.trim();
/*     */       }
/*     */       else
/* 357 */         this.bY3 = null;
/*     */     }
/* 359 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 364 */     if (otherObject == null) return false;
/* 365 */     if (this == otherObject) return true;
/* 366 */     if (getClass() != otherObject.getClass()) return false;
/* 367 */     MCCSAcceptanceStateSchema other = (MCCSAcceptanceStateSchema)otherObject;
/* 368 */     if ((this.serviceNo == null) && (other.getServiceNo() != null)) return false;
/* 369 */     if ((this.serviceNo != null) && (!this.serviceNo.equals(other.getServiceNo()))) return false;
/* 370 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 371 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 372 */     if ((this.status == null) && (other.getStatus() != null)) return false;
/* 373 */     if ((this.status != null) && (!this.status.equals(other.getStatus()))) return false;
/* 374 */     if ((this.bY1 == null) && (other.getBY1() != null)) return false;
/* 375 */     if ((this.bY1 != null) && (!this.bY1.equals(other.getBY1()))) return false;
/* 376 */     if ((this.bY2 == null) && (other.getBY2() != null)) return false;
/* 377 */     if ((this.bY2 != null) && (!this.bY2.equals(other.getBY2()))) return false;
/* 378 */     if ((this.bY3 == null) && (other.getBY3() != null)) return false;
/* 379 */     return (this.bY3 == null) || (this.bY3.equals(other.getBY3()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 386 */     return 6;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 392 */     if (strFieldName.equals("serviceNo")) {
/* 393 */       return 0;
/*     */     }
/* 395 */     if (strFieldName.equals("agentCode")) {
/* 396 */       return 1;
/*     */     }
/* 398 */     if (strFieldName.equals("status")) {
/* 399 */       return 2;
/*     */     }
/* 401 */     if (strFieldName.equals("bY1")) {
/* 402 */       return 3;
/*     */     }
/* 404 */     if (strFieldName.equals("bY2")) {
/* 405 */       return 4;
/*     */     }
/* 407 */     if (strFieldName.equals("bY3")) {
/* 408 */       return 5;
/*     */     }
/* 410 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 416 */     String strFieldName = "";
/* 417 */     switch (nFieldIndex) {
/*     */     case 0:
/* 419 */       strFieldName = "serviceNo";
/* 420 */       break;
/*     */     case 1:
/* 422 */       strFieldName = "agentCode";
/* 423 */       break;
/*     */     case 2:
/* 425 */       strFieldName = "status";
/* 426 */       break;
/*     */     case 3:
/* 428 */       strFieldName = "bY1";
/* 429 */       break;
/*     */     case 4:
/* 431 */       strFieldName = "bY2";
/* 432 */       break;
/*     */     case 5:
/* 434 */       strFieldName = "bY3";
/* 435 */       break;
/*     */     default:
/* 437 */       strFieldName = "";
/*     */     }
/* 439 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 445 */     if (strFieldName.equals("serviceNo")) {
/* 446 */       return 0;
/*     */     }
/* 448 */     if (strFieldName.equals("agentCode")) {
/* 449 */       return 0;
/*     */     }
/* 451 */     if (strFieldName.equals("status")) {
/* 452 */       return 0;
/*     */     }
/* 454 */     if (strFieldName.equals("bY1")) {
/* 455 */       return 0;
/*     */     }
/* 457 */     if (strFieldName.equals("bY2")) {
/* 458 */       return 0;
/*     */     }
/* 460 */     if (strFieldName.equals("bY3")) {
/* 461 */       return 0;
/*     */     }
/* 463 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 469 */     int nFieldType = -1;
/* 470 */     switch (nFieldIndex) {
/*     */     case 0:
/* 472 */       nFieldType = 0;
/* 473 */       break;
/*     */     case 1:
/* 475 */       nFieldType = 0;
/* 476 */       break;
/*     */     case 2:
/* 478 */       nFieldType = 0;
/* 479 */       break;
/*     */     case 3:
/* 481 */       nFieldType = 0;
/* 482 */       break;
/*     */     case 4:
/* 484 */       nFieldType = 0;
/* 485 */       break;
/*     */     case 5:
/* 487 */       nFieldType = 0;
/* 488 */       break;
/*     */     default:
/* 490 */       nFieldType = -1;
/*     */     }
/* 492 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MCCSAcceptanceStateSchema
 * JD-Core Version:    0.6.0
 */