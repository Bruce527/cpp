/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPIndUWPEMasterDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPIndUWPEMasterSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private int uWNo;
/*      */   private String manageCom;
/*      */   private Date uMDate;
/*      */   private String uMTime;
/*      */   private String insuredId;
/*      */   private String uWPENo;
/*      */   private String pEName;
/*      */   private String pECode;
/*      */   private String pEStatus;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 17;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPIndUWPEMasterSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[3];
/*   71 */     pk[0] = "ContNo";
/*   72 */     pk[1] = "InsuredId";
/*   73 */     pk[2] = "UWPENo";
/*      */ 
/*   75 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   82 */     LNPIndUWPEMasterSchema cloned = (LNPIndUWPEMasterSchema)super.clone();
/*   83 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   84 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   85 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   91 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo()
/*      */   {
/*   96 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  100 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  104 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  108 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  112 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  116 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public int getUWNo() {
/*  120 */     return this.uWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(int aUWNo) {
/*  124 */     this.uWNo = aUWNo;
/*      */   }
/*      */ 
/*      */   public void setUWNo(String aUWNo) {
/*  128 */     if ((aUWNo != null) && (!aUWNo.equals("")))
/*      */     {
/*  130 */       Integer tInteger = new Integer(aUWNo);
/*  131 */       int i = tInteger.intValue();
/*  132 */       this.uWNo = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/*  138 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  142 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getUMDate() {
/*  146 */     if (this.uMDate != null) {
/*  147 */       return this.fDate.getString(this.uMDate);
/*      */     }
/*  149 */     return null;
/*      */   }
/*      */ 
/*      */   public void setUMDate(Date aUMDate) {
/*  153 */     this.uMDate = aUMDate;
/*      */   }
/*      */ 
/*      */   public void setUMDate(String aUMDate) {
/*  157 */     if ((aUMDate != null) && (!aUMDate.equals("")))
/*      */     {
/*  159 */       this.uMDate = this.fDate.getDate(aUMDate);
/*      */     }
/*      */     else
/*  162 */       this.uMDate = null;
/*      */   }
/*      */ 
/*      */   public String getUMTime()
/*      */   {
/*  167 */     return this.uMTime;
/*      */   }
/*      */ 
/*      */   public void setUMTime(String aUMTime) {
/*  171 */     this.uMTime = aUMTime;
/*      */   }
/*      */ 
/*      */   public String getInsuredId() {
/*  175 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String aInsuredId) {
/*  179 */     this.insuredId = aInsuredId;
/*      */   }
/*      */ 
/*      */   public String getUWPENo() {
/*  183 */     return this.uWPENo;
/*      */   }
/*      */ 
/*      */   public void setUWPENo(String aUWPENo) {
/*  187 */     this.uWPENo = aUWPENo;
/*      */   }
/*      */ 
/*      */   public String getPEName() {
/*  191 */     return this.pEName;
/*      */   }
/*      */ 
/*      */   public void setPEName(String aPEName) {
/*  195 */     this.pEName = aPEName;
/*      */   }
/*      */ 
/*      */   public String getPECode() {
/*  199 */     return this.pECode;
/*      */   }
/*      */ 
/*      */   public void setPECode(String aPECode) {
/*  203 */     this.pECode = aPECode;
/*      */   }
/*      */ 
/*      */   public String getPEStatus() {
/*  207 */     return this.pEStatus;
/*      */   }
/*      */ 
/*      */   public void setPEStatus(String aPEStatus) {
/*  211 */     this.pEStatus = aPEStatus;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  215 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  219 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  223 */     if (this.makeDate != null) {
/*  224 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  226 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  230 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  234 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  236 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  239 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  244 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  248 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  252 */     if (this.modifyDate != null) {
/*  253 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  255 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  259 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  263 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  265 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  268 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  273 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  277 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPIndUWPEMasterSchema aLNPIndUWPEMasterSchema)
/*      */   {
/*  283 */     this.grpContNo = aLNPIndUWPEMasterSchema.getGrpContNo();
/*  284 */     this.contNo = aLNPIndUWPEMasterSchema.getContNo();
/*  285 */     this.proposalContNo = aLNPIndUWPEMasterSchema.getProposalContNo();
/*  286 */     this.uWNo = aLNPIndUWPEMasterSchema.getUWNo();
/*  287 */     this.manageCom = aLNPIndUWPEMasterSchema.getManageCom();
/*  288 */     this.uMDate = this.fDate.getDate(aLNPIndUWPEMasterSchema.getUMDate());
/*  289 */     this.uMTime = aLNPIndUWPEMasterSchema.getUMTime();
/*  290 */     this.insuredId = aLNPIndUWPEMasterSchema.getInsuredId();
/*  291 */     this.uWPENo = aLNPIndUWPEMasterSchema.getUWPENo();
/*  292 */     this.pEName = aLNPIndUWPEMasterSchema.getPEName();
/*  293 */     this.pECode = aLNPIndUWPEMasterSchema.getPECode();
/*  294 */     this.pEStatus = aLNPIndUWPEMasterSchema.getPEStatus();
/*  295 */     this.operator = aLNPIndUWPEMasterSchema.getOperator();
/*  296 */     this.makeDate = this.fDate.getDate(aLNPIndUWPEMasterSchema.getMakeDate());
/*  297 */     this.makeTime = aLNPIndUWPEMasterSchema.getMakeTime();
/*  298 */     this.modifyDate = this.fDate.getDate(aLNPIndUWPEMasterSchema.getModifyDate());
/*  299 */     this.modifyTime = aLNPIndUWPEMasterSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  308 */       if (rs.getString("GrpContNo") == null)
/*  309 */         this.grpContNo = null;
/*      */       else {
/*  311 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  313 */       if (rs.getString("ContNo") == null)
/*  314 */         this.contNo = null;
/*      */       else {
/*  316 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  318 */       if (rs.getString("ProposalContNo") == null)
/*  319 */         this.proposalContNo = null;
/*      */       else {
/*  321 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  323 */       this.uWNo = rs.getInt("UWNo");
/*  324 */       if (rs.getString("ManageCom") == null)
/*  325 */         this.manageCom = null;
/*      */       else {
/*  327 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  329 */       this.uMDate = rs.getDate("UMDate");
/*  330 */       if (rs.getString("UMTime") == null)
/*  331 */         this.uMTime = null;
/*      */       else {
/*  333 */         this.uMTime = rs.getString("UMTime").trim();
/*      */       }
/*  335 */       if (rs.getString("InsuredId") == null)
/*  336 */         this.insuredId = null;
/*      */       else {
/*  338 */         this.insuredId = rs.getString("InsuredId").trim();
/*      */       }
/*  340 */       if (rs.getString("UWPENo") == null)
/*  341 */         this.uWPENo = null;
/*      */       else {
/*  343 */         this.uWPENo = rs.getString("UWPENo").trim();
/*      */       }
/*  345 */       if (rs.getString("PEName") == null)
/*  346 */         this.pEName = null;
/*      */       else {
/*  348 */         this.pEName = rs.getString("PEName").trim();
/*      */       }
/*  350 */       if (rs.getString("PECode") == null)
/*  351 */         this.pECode = null;
/*      */       else {
/*  353 */         this.pECode = rs.getString("PECode").trim();
/*      */       }
/*  355 */       if (rs.getString("PEStatus") == null)
/*  356 */         this.pEStatus = null;
/*      */       else {
/*  358 */         this.pEStatus = rs.getString("PEStatus").trim();
/*      */       }
/*  360 */       if (rs.getString("Operator") == null)
/*  361 */         this.operator = null;
/*      */       else {
/*  363 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  365 */       this.makeDate = rs.getDate("MakeDate");
/*  366 */       if (rs.getString("MakeTime") == null)
/*  367 */         this.makeTime = null;
/*      */       else {
/*  369 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  371 */       this.modifyDate = rs.getDate("ModifyDate");
/*  372 */       if (rs.getString("ModifyTime") == null)
/*  373 */         this.modifyTime = null;
/*      */       else {
/*  375 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  380 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPIndUWPEMaster\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  382 */       CError tError = new CError();
/*  383 */       tError.moduleName = "LNPIndUWPEMasterSchema";
/*  384 */       tError.functionName = "setSchema";
/*  385 */       tError.errorMessage = sqle.toString();
/*  386 */       this.mErrors.addOneError(tError);
/*  387 */       return false;
/*      */     }
/*  389 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterSchema getSchema()
/*      */   {
/*  394 */     LNPIndUWPEMasterSchema aLNPIndUWPEMasterSchema = new LNPIndUWPEMasterSchema();
/*  395 */     aLNPIndUWPEMasterSchema.setSchema(this);
/*  396 */     return aLNPIndUWPEMasterSchema;
/*      */   }
/*      */ 
/*      */   public LNPIndUWPEMasterDB getDB()
/*      */   {
/*  401 */     LNPIndUWPEMasterDB aDBOper = new LNPIndUWPEMasterDB();
/*  402 */     aDBOper.setSchema(this);
/*  403 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  410 */     StringBuffer strReturn = new StringBuffer(256);
/*  411 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  413 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  414 */     strReturn.append(ChgData.chgData(this.uWNo)); strReturn.append("|");
/*  415 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  416 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.uMDate))); strReturn.append("|");
/*  417 */     strReturn.append(StrTool.cTrim(this.uMTime)); strReturn.append("|");
/*  418 */     strReturn.append(StrTool.cTrim(this.insuredId)); strReturn.append("|");
/*  419 */     strReturn.append(StrTool.cTrim(this.uWPENo)); strReturn.append("|");
/*  420 */     strReturn.append(StrTool.cTrim(this.pEName)); strReturn.append("|");
/*  421 */     strReturn.append(StrTool.cTrim(this.pECode)); strReturn.append("|");
/*  422 */     strReturn.append(StrTool.cTrim(this.pEStatus)); strReturn.append("|");
/*  423 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  424 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  425 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  426 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  427 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  428 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  436 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  437 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  438 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  439 */       this.uWNo = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|"))).intValue();
/*  440 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  441 */       this.uMDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
/*  442 */       this.uMTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  443 */       this.insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  444 */       this.uWPENo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  445 */       this.pEName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  446 */       this.pECode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  447 */       this.pEStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  448 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  449 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  450 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  451 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  452 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  457 */       CError tError = new CError();
/*  458 */       tError.moduleName = "LNPIndUWPEMasterSchema";
/*  459 */       tError.functionName = "decode";
/*  460 */       tError.errorMessage = ex.toString();
/*  461 */       this.mErrors.addOneError(tError);
/*      */ 
/*  463 */       return false;
/*      */     }
/*  465 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  471 */     String strReturn = "";
/*  472 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  474 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  476 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  478 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  480 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  482 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  484 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/*  486 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWNo));
/*      */     }
/*  488 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  490 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  492 */     if (FCode.equalsIgnoreCase("uMDate"))
/*      */     {
/*  494 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getUMDate()));
/*      */     }
/*  496 */     if (FCode.equalsIgnoreCase("uMTime"))
/*      */     {
/*  498 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uMTime));
/*      */     }
/*  500 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/*  502 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuredId));
/*      */     }
/*  504 */     if (FCode.equalsIgnoreCase("uWPENo"))
/*      */     {
/*  506 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWPENo));
/*      */     }
/*  508 */     if (FCode.equalsIgnoreCase("pEName"))
/*      */     {
/*  510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pEName));
/*      */     }
/*  512 */     if (FCode.equalsIgnoreCase("pECode"))
/*      */     {
/*  514 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pECode));
/*      */     }
/*  516 */     if (FCode.equalsIgnoreCase("pEStatus"))
/*      */     {
/*  518 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.pEStatus));
/*      */     }
/*  520 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  524 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  526 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  528 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  532 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  540 */     if (strReturn.equals(""))
/*      */     {
/*  542 */       strReturn = "null";
/*      */     }
/*      */ 
/*  545 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  552 */     String strFieldValue = "";
/*  553 */     switch (nFieldIndex) {
/*      */     case 0:
/*  555 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/*  556 */       break;
/*      */     case 1:
/*  558 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  559 */       break;
/*      */     case 2:
/*  561 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/*  562 */       break;
/*      */     case 3:
/*  564 */       strFieldValue = String.valueOf(this.uWNo);
/*  565 */       break;
/*      */     case 4:
/*  567 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  568 */       break;
/*      */     case 5:
/*  570 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUMDate()));
/*  571 */       break;
/*      */     case 6:
/*  573 */       strFieldValue = StrTool.GBKToUnicode(this.uMTime);
/*  574 */       break;
/*      */     case 7:
/*  576 */       strFieldValue = StrTool.GBKToUnicode(this.insuredId);
/*  577 */       break;
/*      */     case 8:
/*  579 */       strFieldValue = StrTool.GBKToUnicode(this.uWPENo);
/*  580 */       break;
/*      */     case 9:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(this.pEName);
/*  583 */       break;
/*      */     case 10:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.pECode);
/*  586 */       break;
/*      */     case 11:
/*  588 */       strFieldValue = StrTool.GBKToUnicode(this.pEStatus);
/*  589 */       break;
/*      */     case 12:
/*  591 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  592 */       break;
/*      */     case 13:
/*  594 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  595 */       break;
/*      */     case 14:
/*  597 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  598 */       break;
/*      */     case 15:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  601 */       break;
/*      */     case 16:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  604 */       break;
/*      */     default:
/*  606 */       strFieldValue = "";
/*      */     }
/*  608 */     if (strFieldValue.equals("")) {
/*  609 */       strFieldValue = "null";
/*      */     }
/*  611 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  617 */     if (StrTool.cTrim(FCode).equals("")) {
/*  618 */       return false;
/*      */     }
/*  620 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  622 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  624 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/*  627 */         this.grpContNo = null;
/*      */     }
/*  629 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  631 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  633 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/*  636 */         this.contNo = null;
/*      */     }
/*  638 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  640 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  642 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/*  645 */         this.proposalContNo = null;
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("uWNo"))
/*      */     {
/*  649 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  651 */         Integer tInteger = new Integer(FValue);
/*  652 */         int i = tInteger.intValue();
/*  653 */         this.uWNo = i;
/*      */       }
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  660 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  663 */         this.manageCom = null;
/*      */     }
/*  665 */     if (FCode.equalsIgnoreCase("uMDate"))
/*      */     {
/*  667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  669 */         this.uMDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  672 */         this.uMDate = null;
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("uMTime"))
/*      */     {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  678 */         this.uMTime = FValue.trim();
/*      */       }
/*      */       else
/*  681 */         this.uMTime = null;
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("insuredId"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         this.insuredId = FValue.trim();
/*      */       }
/*      */       else
/*  690 */         this.insuredId = null;
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("uWPENo"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         this.uWPENo = FValue.trim();
/*      */       }
/*      */       else
/*  699 */         this.uWPENo = null;
/*      */     }
/*  701 */     if (FCode.equalsIgnoreCase("pEName"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         this.pEName = FValue.trim();
/*      */       }
/*      */       else
/*  708 */         this.pEName = null;
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("pECode"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.pECode = FValue.trim();
/*      */       }
/*      */       else
/*  717 */         this.pECode = null;
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("pEStatus"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.pEStatus = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.pEStatus = null;
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  735 */         this.operator = null;
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  744 */         this.makeDate = null;
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.makeTime = null;
/*      */     }
/*  755 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  762 */         this.modifyDate = null;
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.modifyTime = null;
/*      */     }
/*  773 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  778 */     if (otherObject == null) return false;
/*  779 */     if (this == otherObject) return true;
/*  780 */     if (getClass() != otherObject.getClass()) return false;
/*  781 */     LNPIndUWPEMasterSchema other = (LNPIndUWPEMasterSchema)otherObject;
/*  782 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/*  783 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/*  784 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/*  785 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/*  786 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/*  787 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/*  788 */     if (this.uWNo != other.getUWNo()) return false;
/*  789 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  790 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  791 */     if ((this.uMDate == null) && (other.getUMDate() != null)) return false;
/*  792 */     if ((this.uMDate != null) && (!this.fDate.getString(this.uMDate).equals(other.getUMDate()))) return false;
/*  793 */     if ((this.uMTime == null) && (other.getUMTime() != null)) return false;
/*  794 */     if ((this.uMTime != null) && (!this.uMTime.equals(other.getUMTime()))) return false;
/*  795 */     if ((this.insuredId == null) && (other.getInsuredId() != null)) return false;
/*  796 */     if ((this.insuredId != null) && (!this.insuredId.equals(other.getInsuredId()))) return false;
/*  797 */     if ((this.uWPENo == null) && (other.getUWPENo() != null)) return false;
/*  798 */     if ((this.uWPENo != null) && (!this.uWPENo.equals(other.getUWPENo()))) return false;
/*  799 */     if ((this.pEName == null) && (other.getPEName() != null)) return false;
/*  800 */     if ((this.pEName != null) && (!this.pEName.equals(other.getPEName()))) return false;
/*  801 */     if ((this.pECode == null) && (other.getPECode() != null)) return false;
/*  802 */     if ((this.pECode != null) && (!this.pECode.equals(other.getPECode()))) return false;
/*  803 */     if ((this.pEStatus == null) && (other.getPEStatus() != null)) return false;
/*  804 */     if ((this.pEStatus != null) && (!this.pEStatus.equals(other.getPEStatus()))) return false;
/*  805 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  806 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  807 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  808 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  809 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  810 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  811 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  812 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  813 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  814 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  821 */     return 17;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  827 */     if (strFieldName.equals("grpContNo")) {
/*  828 */       return 0;
/*      */     }
/*  830 */     if (strFieldName.equals("contNo")) {
/*  831 */       return 1;
/*      */     }
/*  833 */     if (strFieldName.equals("proposalContNo")) {
/*  834 */       return 2;
/*      */     }
/*  836 */     if (strFieldName.equals("uWNo")) {
/*  837 */       return 3;
/*      */     }
/*  839 */     if (strFieldName.equals("manageCom")) {
/*  840 */       return 4;
/*      */     }
/*  842 */     if (strFieldName.equals("uMDate")) {
/*  843 */       return 5;
/*      */     }
/*  845 */     if (strFieldName.equals("uMTime")) {
/*  846 */       return 6;
/*      */     }
/*  848 */     if (strFieldName.equals("insuredId")) {
/*  849 */       return 7;
/*      */     }
/*  851 */     if (strFieldName.equals("uWPENo")) {
/*  852 */       return 8;
/*      */     }
/*  854 */     if (strFieldName.equals("pEName")) {
/*  855 */       return 9;
/*      */     }
/*  857 */     if (strFieldName.equals("pECode")) {
/*  858 */       return 10;
/*      */     }
/*  860 */     if (strFieldName.equals("pEStatus")) {
/*  861 */       return 11;
/*      */     }
/*  863 */     if (strFieldName.equals("operator")) {
/*  864 */       return 12;
/*      */     }
/*  866 */     if (strFieldName.equals("makeDate")) {
/*  867 */       return 13;
/*      */     }
/*  869 */     if (strFieldName.equals("makeTime")) {
/*  870 */       return 14;
/*      */     }
/*  872 */     if (strFieldName.equals("modifyDate")) {
/*  873 */       return 15;
/*      */     }
/*  875 */     if (strFieldName.equals("modifyTime")) {
/*  876 */       return 16;
/*      */     }
/*  878 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  884 */     String strFieldName = "";
/*  885 */     switch (nFieldIndex) {
/*      */     case 0:
/*  887 */       strFieldName = "grpContNo";
/*  888 */       break;
/*      */     case 1:
/*  890 */       strFieldName = "contNo";
/*  891 */       break;
/*      */     case 2:
/*  893 */       strFieldName = "proposalContNo";
/*  894 */       break;
/*      */     case 3:
/*  896 */       strFieldName = "uWNo";
/*  897 */       break;
/*      */     case 4:
/*  899 */       strFieldName = "manageCom";
/*  900 */       break;
/*      */     case 5:
/*  902 */       strFieldName = "uMDate";
/*  903 */       break;
/*      */     case 6:
/*  905 */       strFieldName = "uMTime";
/*  906 */       break;
/*      */     case 7:
/*  908 */       strFieldName = "insuredId";
/*  909 */       break;
/*      */     case 8:
/*  911 */       strFieldName = "uWPENo";
/*  912 */       break;
/*      */     case 9:
/*  914 */       strFieldName = "pEName";
/*  915 */       break;
/*      */     case 10:
/*  917 */       strFieldName = "pECode";
/*  918 */       break;
/*      */     case 11:
/*  920 */       strFieldName = "pEStatus";
/*  921 */       break;
/*      */     case 12:
/*  923 */       strFieldName = "operator";
/*  924 */       break;
/*      */     case 13:
/*  926 */       strFieldName = "makeDate";
/*  927 */       break;
/*      */     case 14:
/*  929 */       strFieldName = "makeTime";
/*  930 */       break;
/*      */     case 15:
/*  932 */       strFieldName = "modifyDate";
/*  933 */       break;
/*      */     case 16:
/*  935 */       strFieldName = "modifyTime";
/*  936 */       break;
/*      */     default:
/*  938 */       strFieldName = "";
/*      */     }
/*  940 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  946 */     if (strFieldName.equals("grpContNo")) {
/*  947 */       return 0;
/*      */     }
/*  949 */     if (strFieldName.equals("contNo")) {
/*  950 */       return 0;
/*      */     }
/*  952 */     if (strFieldName.equals("proposalContNo")) {
/*  953 */       return 0;
/*      */     }
/*  955 */     if (strFieldName.equals("uWNo")) {
/*  956 */       return 3;
/*      */     }
/*  958 */     if (strFieldName.equals("manageCom")) {
/*  959 */       return 0;
/*      */     }
/*  961 */     if (strFieldName.equals("uMDate")) {
/*  962 */       return 1;
/*      */     }
/*  964 */     if (strFieldName.equals("uMTime")) {
/*  965 */       return 0;
/*      */     }
/*  967 */     if (strFieldName.equals("insuredId")) {
/*  968 */       return 0;
/*      */     }
/*  970 */     if (strFieldName.equals("uWPENo")) {
/*  971 */       return 0;
/*      */     }
/*  973 */     if (strFieldName.equals("pEName")) {
/*  974 */       return 0;
/*      */     }
/*  976 */     if (strFieldName.equals("pECode")) {
/*  977 */       return 0;
/*      */     }
/*  979 */     if (strFieldName.equals("pEStatus")) {
/*  980 */       return 0;
/*      */     }
/*  982 */     if (strFieldName.equals("operator")) {
/*  983 */       return 0;
/*      */     }
/*  985 */     if (strFieldName.equals("makeDate")) {
/*  986 */       return 1;
/*      */     }
/*  988 */     if (strFieldName.equals("makeTime")) {
/*  989 */       return 0;
/*      */     }
/*  991 */     if (strFieldName.equals("modifyDate")) {
/*  992 */       return 1;
/*      */     }
/*  994 */     if (strFieldName.equals("modifyTime")) {
/*  995 */       return 0;
/*      */     }
/*  997 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1003 */     int nFieldType = -1;
/* 1004 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1006 */       nFieldType = 0;
/* 1007 */       break;
/*      */     case 1:
/* 1009 */       nFieldType = 0;
/* 1010 */       break;
/*      */     case 2:
/* 1012 */       nFieldType = 0;
/* 1013 */       break;
/*      */     case 3:
/* 1015 */       nFieldType = 3;
/* 1016 */       break;
/*      */     case 4:
/* 1018 */       nFieldType = 0;
/* 1019 */       break;
/*      */     case 5:
/* 1021 */       nFieldType = 1;
/* 1022 */       break;
/*      */     case 6:
/* 1024 */       nFieldType = 0;
/* 1025 */       break;
/*      */     case 7:
/* 1027 */       nFieldType = 0;
/* 1028 */       break;
/*      */     case 8:
/* 1030 */       nFieldType = 0;
/* 1031 */       break;
/*      */     case 9:
/* 1033 */       nFieldType = 0;
/* 1034 */       break;
/*      */     case 10:
/* 1036 */       nFieldType = 0;
/* 1037 */       break;
/*      */     case 11:
/* 1039 */       nFieldType = 0;
/* 1040 */       break;
/*      */     case 12:
/* 1042 */       nFieldType = 0;
/* 1043 */       break;
/*      */     case 13:
/* 1045 */       nFieldType = 1;
/* 1046 */       break;
/*      */     case 14:
/* 1048 */       nFieldType = 0;
/* 1049 */       break;
/*      */     case 15:
/* 1051 */       nFieldType = 1;
/* 1052 */       break;
/*      */     case 16:
/* 1054 */       nFieldType = 0;
/* 1055 */       break;
/*      */     default:
/* 1057 */       nFieldType = -1;
/*      */     }
/* 1059 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPIndUWPEMasterSchema
 * JD-Core Version:    0.6.0
 */