/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPInvestmentAccountInfoBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
/*      */   private String ContNo;
/*      */   private String RiskCode;
/*      */   private String InvestAccountCode;
/*      */   private double InvestAccountRate;
/*      */   private String Operator;
/*      */   private String MakeDate;
/*      */   private String MakeTime;
/*      */   private String ModifyDate;
/*      */   private String ModifyTime;
/*      */   private String Remark;
/*      */   private String Varc1;
/*      */   private String Varc2;
/*      */   private String Varc3;
/*      */   private String Varc4;
/*      */   private Date DateTime1;
/*      */   private Date DateTime2;
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*   61 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPInvestmentAccountInfoBSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[2];
/*   71 */     pk[0] = "EdorNo";
/*   72 */     pk[1] = "serialNo";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   80 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*   85 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*   89 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*   93 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*   97 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  101 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  105 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  109 */     if (this.ContNo != null) this.ContNo.equals("");
/*      */ 
/*  113 */     return this.ContNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  117 */     this.ContNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getRiskCode() {
/*  121 */     if (this.RiskCode != null) this.RiskCode.equals("");
/*      */ 
/*  125 */     return this.RiskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*  129 */     this.RiskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public String getInvestAccountCode() {
/*  133 */     if (this.InvestAccountCode != null) this.InvestAccountCode.equals("");
/*      */ 
/*  137 */     return this.InvestAccountCode;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountCode(String aInvestAccountCode) {
/*  141 */     this.InvestAccountCode = aInvestAccountCode;
/*      */   }
/*      */ 
/*      */   public double getInvestAccountRate() {
/*  145 */     return this.InvestAccountRate;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountRate(double aInvestAccountRate) {
/*  149 */     this.InvestAccountRate = aInvestAccountRate;
/*      */   }
/*      */ 
/*      */   public void setInvestAccountRate(String aInvestAccountRate) {
/*  153 */     if ((aInvestAccountRate != null) && (!aInvestAccountRate.equals("")))
/*      */     {
/*  155 */       Double tDouble = new Double(aInvestAccountRate);
/*  156 */       double d = tDouble.doubleValue();
/*  157 */       this.InvestAccountRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  163 */     if (this.Operator != null) this.Operator.equals("");
/*      */ 
/*  167 */     return this.Operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  171 */     this.Operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  175 */     if (this.MakeDate != null) this.MakeDate.equals("");
/*      */ 
/*  179 */     return this.MakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  183 */     this.MakeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public String getMakeTime() {
/*  187 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*      */ 
/*  191 */     return this.MakeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  195 */     this.MakeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  199 */     if (this.ModifyDate != null) this.ModifyDate.equals("");
/*      */ 
/*  203 */     return this.ModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  207 */     this.ModifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public String getModifyTime() {
/*  211 */     if (this.ModifyTime != null) this.ModifyTime.equals("");
/*      */ 
/*  215 */     return this.ModifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  219 */     this.ModifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  223 */     if (this.Remark != null) this.Remark.equals("");
/*      */ 
/*  227 */     return this.Remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String aRemark) {
/*  231 */     this.Remark = aRemark;
/*      */   }
/*      */ 
/*      */   public String getVarc1() {
/*  235 */     if (this.Varc1 != null) this.Varc1.equals("");
/*      */ 
/*  239 */     return this.Varc1;
/*      */   }
/*      */ 
/*      */   public void setVarc1(String aVarc1) {
/*  243 */     this.Varc1 = aVarc1;
/*      */   }
/*      */ 
/*      */   public String getVarc2() {
/*  247 */     if (this.Varc2 != null) this.Varc2.equals("");
/*      */ 
/*  251 */     return this.Varc2;
/*      */   }
/*      */ 
/*      */   public void setVarc2(String aVarc2) {
/*  255 */     this.Varc2 = aVarc2;
/*      */   }
/*      */ 
/*      */   public String getVarc3() {
/*  259 */     if (this.Varc3 != null) this.Varc3.equals("");
/*      */ 
/*  263 */     return this.Varc3;
/*      */   }
/*      */ 
/*      */   public void setVarc3(String aVarc3) {
/*  267 */     this.Varc3 = aVarc3;
/*      */   }
/*      */ 
/*      */   public String getVarc4() {
/*  271 */     if (this.Varc4 != null) this.Varc4.equals("");
/*      */ 
/*  275 */     return this.Varc4;
/*      */   }
/*      */ 
/*      */   public void setVarc4(String aVarc4) {
/*  279 */     this.Varc4 = aVarc4;
/*      */   }
/*      */ 
/*      */   public String getDateTime1() {
/*  283 */     if (this.DateTime1 != null) {
/*  284 */       return this.fDate.getString(this.DateTime1);
/*      */     }
/*  286 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(Date aDateTime1) {
/*  290 */     this.DateTime1 = aDateTime1;
/*      */   }
/*      */ 
/*      */   public void setDateTime1(String aDateTime1) {
/*  294 */     if ((aDateTime1 != null) && (!aDateTime1.equals("")))
/*      */     {
/*  296 */       this.DateTime1 = this.fDate.getDate(aDateTime1);
/*      */     }
/*      */     else
/*  299 */       this.DateTime1 = null;
/*      */   }
/*      */ 
/*      */   public String getDateTime2()
/*      */   {
/*  304 */     if (this.DateTime2 != null) {
/*  305 */       return this.fDate.getString(this.DateTime2);
/*      */     }
/*  307 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(Date aDateTime2) {
/*  311 */     this.DateTime2 = aDateTime2;
/*      */   }
/*      */ 
/*      */   public void setDateTime2(String aDateTime2) {
/*  315 */     if ((aDateTime2 != null) && (!aDateTime2.equals("")))
/*      */     {
/*  317 */       this.DateTime2 = this.fDate.getDate(aDateTime2);
/*      */     }
/*      */     else
/*  320 */       this.DateTime2 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPInvestmentAccountInfoBSchema aLNPInvestmentAccountInfoBSchema)
/*      */   {
/*  327 */     this.EdorNo = aLNPInvestmentAccountInfoBSchema.getEdorNo();
/*  328 */     this.serialNo = aLNPInvestmentAccountInfoBSchema.getserialNo();
/*  329 */     this.ContNo = aLNPInvestmentAccountInfoBSchema.getContNo();
/*  330 */     this.RiskCode = aLNPInvestmentAccountInfoBSchema.getRiskCode();
/*  331 */     this.InvestAccountCode = aLNPInvestmentAccountInfoBSchema.getInvestAccountCode();
/*  332 */     this.InvestAccountRate = aLNPInvestmentAccountInfoBSchema.getInvestAccountRate();
/*  333 */     this.Operator = aLNPInvestmentAccountInfoBSchema.getOperator();
/*  334 */     this.MakeDate = aLNPInvestmentAccountInfoBSchema.getMakeDate();
/*  335 */     this.MakeTime = aLNPInvestmentAccountInfoBSchema.getMakeTime();
/*  336 */     this.ModifyDate = aLNPInvestmentAccountInfoBSchema.getModifyDate();
/*  337 */     this.ModifyTime = aLNPInvestmentAccountInfoBSchema.getModifyTime();
/*  338 */     this.Remark = aLNPInvestmentAccountInfoBSchema.getRemark();
/*  339 */     this.Varc1 = aLNPInvestmentAccountInfoBSchema.getVarc1();
/*  340 */     this.Varc2 = aLNPInvestmentAccountInfoBSchema.getVarc2();
/*  341 */     this.Varc3 = aLNPInvestmentAccountInfoBSchema.getVarc3();
/*  342 */     this.Varc4 = aLNPInvestmentAccountInfoBSchema.getVarc4();
/*  343 */     this.DateTime1 = this.fDate.getDate(aLNPInvestmentAccountInfoBSchema.getDateTime1());
/*  344 */     this.DateTime2 = this.fDate.getDate(aLNPInvestmentAccountInfoBSchema.getDateTime2());
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  353 */       if (rs.getString("EdorNo") == null)
/*  354 */         this.EdorNo = null;
/*      */       else {
/*  356 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  358 */       if (rs.getString("serialNo") == null)
/*  359 */         this.serialNo = null;
/*      */       else {
/*  361 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  363 */       if (rs.getString("ContNo") == null)
/*  364 */         this.ContNo = null;
/*      */       else {
/*  366 */         this.ContNo = rs.getString("ContNo").trim();
/*      */       }
/*  368 */       if (rs.getString("RiskCode") == null)
/*  369 */         this.RiskCode = null;
/*      */       else {
/*  371 */         this.RiskCode = rs.getString("RiskCode").trim();
/*      */       }
/*  373 */       if (rs.getString("InvestAccountCode") == null)
/*  374 */         this.InvestAccountCode = null;
/*      */       else {
/*  376 */         this.InvestAccountCode = rs.getString("InvestAccountCode").trim();
/*      */       }
/*  378 */       this.InvestAccountRate = rs.getDouble("InvestAccountRate");
/*  379 */       if (rs.getString("Operator") == null)
/*  380 */         this.Operator = null;
/*      */       else {
/*  382 */         this.Operator = rs.getString("Operator").trim();
/*      */       }
/*  384 */       if (rs.getString("MakeDate") == null)
/*  385 */         this.MakeDate = null;
/*      */       else {
/*  387 */         this.MakeDate = rs.getString("MakeDate").trim();
/*      */       }
/*  389 */       if (rs.getString("MakeTime") == null)
/*  390 */         this.MakeTime = null;
/*      */       else {
/*  392 */         this.MakeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  394 */       if (rs.getString("ModifyDate") == null)
/*  395 */         this.ModifyDate = null;
/*      */       else {
/*  397 */         this.ModifyDate = rs.getString("ModifyDate").trim();
/*      */       }
/*  399 */       if (rs.getString("ModifyTime") == null)
/*  400 */         this.ModifyTime = null;
/*      */       else {
/*  402 */         this.ModifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  404 */       if (rs.getString("Remark") == null)
/*  405 */         this.Remark = null;
/*      */       else {
/*  407 */         this.Remark = rs.getString("Remark").trim();
/*      */       }
/*  409 */       if (rs.getString("Varc1") == null)
/*  410 */         this.Varc1 = null;
/*      */       else {
/*  412 */         this.Varc1 = rs.getString("Varc1").trim();
/*      */       }
/*  414 */       if (rs.getString("Varc2") == null)
/*  415 */         this.Varc2 = null;
/*      */       else {
/*  417 */         this.Varc2 = rs.getString("Varc2").trim();
/*      */       }
/*  419 */       if (rs.getString("Varc3") == null)
/*  420 */         this.Varc3 = null;
/*      */       else {
/*  422 */         this.Varc3 = rs.getString("Varc3").trim();
/*      */       }
/*  424 */       if (rs.getString("Varc4") == null)
/*  425 */         this.Varc4 = null;
/*      */       else {
/*  427 */         this.Varc4 = rs.getString("Varc4").trim();
/*      */       }
/*  429 */       this.DateTime1 = rs.getDate("DateTime1");
/*  430 */       this.DateTime2 = rs.getDate("DateTime2");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  435 */       CError tError = new CError();
/*  436 */       tError.moduleName = "LNPInvestmentAccountInfoBSchema";
/*  437 */       tError.functionName = "setSchema";
/*  438 */       tError.errorMessage = sqle.toString();
/*  439 */       this.mErrors.addOneError(tError);
/*      */ 
/*  441 */       return false;
/*      */     }
/*  443 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentAccountInfoBSchema getSchema()
/*      */   {
/*  448 */     LNPInvestmentAccountInfoBSchema aLNPInvestmentAccountInfoBSchema = new LNPInvestmentAccountInfoBSchema();
/*  449 */     aLNPInvestmentAccountInfoBSchema.setSchema(this);
/*  450 */     return aLNPInvestmentAccountInfoBSchema;
/*      */   }
/*      */ 
/*      */   public LNPInvestmentAccountInfoBDB getDB()
/*      */   {
/*  455 */     LNPInvestmentAccountInfoBDB aDBOper = new LNPInvestmentAccountInfoBDB();
/*  456 */     aDBOper.setSchema(this);
/*  457 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  464 */     String strReturn = "";
/*  465 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  466 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  467 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/*  468 */       StrTool.cTrim(StrTool.unicodeToGBK(this.RiskCode)) + "|" + 
/*  469 */       StrTool.cTrim(StrTool.unicodeToGBK(this.InvestAccountCode)) + "|" + 
/*  470 */       ChgData.chgData(this.InvestAccountRate) + "|" + 
/*  471 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/*  472 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeDate)) + "|" + 
/*  473 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/*  474 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyDate)) + "|" + 
/*  475 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ModifyTime)) + "|" + 
/*  476 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Remark)) + "|" + 
/*  477 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc1)) + "|" + 
/*  478 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc2)) + "|" + 
/*  479 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc3)) + "|" + 
/*  480 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Varc4)) + "|" + 
/*  481 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime1))) + "|" + 
/*  482 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.DateTime2)));
/*  483 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  491 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  492 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  493 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  494 */       this.RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  495 */       this.InvestAccountCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  496 */       this.InvestAccountRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).doubleValue();
/*  497 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  498 */       this.MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  499 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  500 */       this.ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  501 */       this.ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  502 */       this.Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  503 */       this.Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  504 */       this.Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  505 */       this.Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  506 */       this.Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  507 */       this.DateTime1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  508 */       this.DateTime2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  513 */       CError tError = new CError();
/*  514 */       tError.moduleName = "LNPInvestmentAccountInfoBSchema";
/*  515 */       tError.functionName = "decode";
/*  516 */       tError.errorMessage = ex.toString();
/*  517 */       this.mErrors.addOneError(tError);
/*      */ 
/*  519 */       return false;
/*      */     }
/*  521 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  527 */     String strReturn = "";
/*  528 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  532 */     if (FCode.equals("serialNo"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  536 */     if (FCode.equals("ContNo"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*      */     }
/*  540 */     if (FCode.equals("RiskCode"))
/*      */     {
/*  542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.RiskCode));
/*      */     }
/*  544 */     if (FCode.equals("InvestAccountCode"))
/*      */     {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InvestAccountCode));
/*      */     }
/*  548 */     if (FCode.equals("InvestAccountRate"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.InvestAccountRate));
/*      */     }
/*  552 */     if (FCode.equals("Operator"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*      */     }
/*  556 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeDate));
/*      */     }
/*  560 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*      */     }
/*  564 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyDate));
/*      */     }
/*  568 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ModifyTime));
/*      */     }
/*  572 */     if (FCode.equals("Remark"))
/*      */     {
/*  574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Remark));
/*      */     }
/*  576 */     if (FCode.equals("Varc1"))
/*      */     {
/*  578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc1));
/*      */     }
/*  580 */     if (FCode.equals("Varc2"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc2));
/*      */     }
/*  584 */     if (FCode.equals("Varc3"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc3));
/*      */     }
/*  588 */     if (FCode.equals("Varc4"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Varc4));
/*      */     }
/*  592 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*      */     }
/*  596 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*      */     }
/*  600 */     if (strReturn.equals(""))
/*      */     {
/*  602 */       strReturn = "null";
/*      */     }
/*      */ 
/*  605 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  612 */     String strFieldValue = "";
/*  613 */     switch (nFieldIndex) {
/*      */     case 0:
/*  615 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/*  616 */       break;
/*      */     case 1:
/*  618 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/*  619 */       break;
/*      */     case 2:
/*  621 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/*  622 */       break;
/*      */     case 3:
/*  624 */       strFieldValue = StrTool.GBKToUnicode(this.RiskCode);
/*  625 */       break;
/*      */     case 4:
/*  627 */       strFieldValue = StrTool.GBKToUnicode(this.InvestAccountCode);
/*  628 */       break;
/*      */     case 5:
/*  630 */       strFieldValue = String.valueOf(this.InvestAccountRate);
/*  631 */       break;
/*      */     case 6:
/*  633 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/*  634 */       break;
/*      */     case 7:
/*  636 */       strFieldValue = StrTool.GBKToUnicode(this.MakeDate);
/*  637 */       break;
/*      */     case 8:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/*  640 */       break;
/*      */     case 9:
/*  642 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyDate);
/*  643 */       break;
/*      */     case 10:
/*  645 */       strFieldValue = StrTool.GBKToUnicode(this.ModifyTime);
/*  646 */       break;
/*      */     case 11:
/*  648 */       strFieldValue = StrTool.GBKToUnicode(this.Remark);
/*  649 */       break;
/*      */     case 12:
/*  651 */       strFieldValue = StrTool.GBKToUnicode(this.Varc1);
/*  652 */       break;
/*      */     case 13:
/*  654 */       strFieldValue = StrTool.GBKToUnicode(this.Varc2);
/*  655 */       break;
/*      */     case 14:
/*  657 */       strFieldValue = StrTool.GBKToUnicode(this.Varc3);
/*  658 */       break;
/*      */     case 15:
/*  660 */       strFieldValue = StrTool.GBKToUnicode(this.Varc4);
/*  661 */       break;
/*      */     case 16:
/*  663 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
/*  664 */       break;
/*      */     case 17:
/*  666 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
/*  667 */       break;
/*      */     default:
/*  669 */       strFieldValue = "";
/*      */     }
/*  671 */     if (strFieldValue.equals("")) {
/*  672 */       strFieldValue = "null";
/*      */     }
/*  674 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  680 */     if (StrTool.cTrim(FCode).equals("")) {
/*  681 */       return false;
/*      */     }
/*  683 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/*  690 */         this.EdorNo = null;
/*      */     }
/*  692 */     if (FCode.equals("serialNo"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/*  699 */         this.serialNo = null;
/*      */     }
/*  701 */     if (FCode.equals("ContNo"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         this.ContNo = FValue.trim();
/*      */       }
/*      */       else
/*  708 */         this.ContNo = null;
/*      */     }
/*  710 */     if (FCode.equals("RiskCode"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.RiskCode = FValue.trim();
/*      */       }
/*      */       else
/*  717 */         this.RiskCode = null;
/*      */     }
/*  719 */     if (FCode.equals("InvestAccountCode"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.InvestAccountCode = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.InvestAccountCode = null;
/*      */     }
/*  728 */     if (FCode.equals("InvestAccountRate"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         Double tDouble = new Double(FValue);
/*  733 */         double d = tDouble.doubleValue();
/*  734 */         this.InvestAccountRate = d;
/*      */       }
/*      */     }
/*  737 */     if (FCode.equals("Operator"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.Operator = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.Operator = null;
/*      */     }
/*  746 */     if (FCode.equals("MakeDate"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.MakeDate = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.MakeDate = null;
/*      */     }
/*  755 */     if (FCode.equals("MakeTime"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         this.MakeTime = FValue.trim();
/*      */       }
/*      */       else
/*  762 */         this.MakeTime = null;
/*      */     }
/*  764 */     if (FCode.equals("ModifyDate"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.ModifyDate = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.ModifyDate = null;
/*      */     }
/*  773 */     if (FCode.equals("ModifyTime"))
/*      */     {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  777 */         this.ModifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  780 */         this.ModifyTime = null;
/*      */     }
/*  782 */     if (FCode.equals("Remark"))
/*      */     {
/*  784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  786 */         this.Remark = FValue.trim();
/*      */       }
/*      */       else
/*  789 */         this.Remark = null;
/*      */     }
/*  791 */     if (FCode.equals("Varc1"))
/*      */     {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  795 */         this.Varc1 = FValue.trim();
/*      */       }
/*      */       else
/*  798 */         this.Varc1 = null;
/*      */     }
/*  800 */     if (FCode.equals("Varc2"))
/*      */     {
/*  802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  804 */         this.Varc2 = FValue.trim();
/*      */       }
/*      */       else
/*  807 */         this.Varc2 = null;
/*      */     }
/*  809 */     if (FCode.equals("Varc3"))
/*      */     {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  813 */         this.Varc3 = FValue.trim();
/*      */       }
/*      */       else
/*  816 */         this.Varc3 = null;
/*      */     }
/*  818 */     if (FCode.equals("Varc4"))
/*      */     {
/*  820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  822 */         this.Varc4 = FValue.trim();
/*      */       }
/*      */       else
/*  825 */         this.Varc4 = null;
/*      */     }
/*  827 */     if (FCode.equals("DateTime1"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         this.DateTime1 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  834 */         this.DateTime1 = null;
/*      */     }
/*  836 */     if (FCode.equals("DateTime2"))
/*      */     {
/*  838 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  840 */         this.DateTime2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  843 */         this.DateTime2 = null;
/*      */     }
/*  845 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  850 */     if (this == otherObject) return true;
/*  851 */     if (otherObject == null) return false;
/*  852 */     if (getClass() != otherObject.getClass()) return false;
/*  853 */     LNPInvestmentAccountInfoBSchema other = (LNPInvestmentAccountInfoBSchema)otherObject;
/*  854 */     return 
/*  855 */       (this.EdorNo.equals(other.getEdorNo())) && 
/*  856 */       (this.serialNo.equals(other.getserialNo())) && 
/*  857 */       (this.ContNo.equals(other.getContNo())) && 
/*  858 */       (this.RiskCode.equals(other.getRiskCode())) && 
/*  859 */       (this.InvestAccountCode.equals(other.getInvestAccountCode())) && 
/*  860 */       (this.InvestAccountRate == other.getInvestAccountRate()) && 
/*  861 */       (this.Operator.equals(other.getOperator())) && 
/*  862 */       (this.MakeDate.equals(other.getMakeDate())) && 
/*  863 */       (this.MakeTime.equals(other.getMakeTime())) && 
/*  864 */       (this.ModifyDate.equals(other.getModifyDate())) && 
/*  865 */       (this.ModifyTime.equals(other.getModifyTime())) && 
/*  866 */       (this.Remark.equals(other.getRemark())) && 
/*  867 */       (this.Varc1.equals(other.getVarc1())) && 
/*  868 */       (this.Varc2.equals(other.getVarc2())) && 
/*  869 */       (this.Varc3.equals(other.getVarc3())) && 
/*  870 */       (this.Varc4.equals(other.getVarc4())) && 
/*  871 */       (this.fDate.getString(this.DateTime1).equals(other.getDateTime1())) && 
/*  872 */       (this.fDate.getString(this.DateTime2).equals(other.getDateTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  878 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  884 */     if (strFieldName.equals("EdorNo")) {
/*  885 */       return 0;
/*      */     }
/*  887 */     if (strFieldName.equals("serialNo")) {
/*  888 */       return 1;
/*      */     }
/*  890 */     if (strFieldName.equals("ContNo")) {
/*  891 */       return 2;
/*      */     }
/*  893 */     if (strFieldName.equals("RiskCode")) {
/*  894 */       return 3;
/*      */     }
/*  896 */     if (strFieldName.equals("InvestAccountCode")) {
/*  897 */       return 4;
/*      */     }
/*  899 */     if (strFieldName.equals("InvestAccountRate")) {
/*  900 */       return 5;
/*      */     }
/*  902 */     if (strFieldName.equals("Operator")) {
/*  903 */       return 6;
/*      */     }
/*  905 */     if (strFieldName.equals("MakeDate")) {
/*  906 */       return 7;
/*      */     }
/*  908 */     if (strFieldName.equals("MakeTime")) {
/*  909 */       return 8;
/*      */     }
/*  911 */     if (strFieldName.equals("ModifyDate")) {
/*  912 */       return 9;
/*      */     }
/*  914 */     if (strFieldName.equals("ModifyTime")) {
/*  915 */       return 10;
/*      */     }
/*  917 */     if (strFieldName.equals("Remark")) {
/*  918 */       return 11;
/*      */     }
/*  920 */     if (strFieldName.equals("Varc1")) {
/*  921 */       return 12;
/*      */     }
/*  923 */     if (strFieldName.equals("Varc2")) {
/*  924 */       return 13;
/*      */     }
/*  926 */     if (strFieldName.equals("Varc3")) {
/*  927 */       return 14;
/*      */     }
/*  929 */     if (strFieldName.equals("Varc4")) {
/*  930 */       return 15;
/*      */     }
/*  932 */     if (strFieldName.equals("DateTime1")) {
/*  933 */       return 16;
/*      */     }
/*  935 */     if (strFieldName.equals("DateTime2")) {
/*  936 */       return 17;
/*      */     }
/*  938 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  944 */     String strFieldName = "";
/*  945 */     switch (nFieldIndex) {
/*      */     case 0:
/*  947 */       strFieldName = "EdorNo";
/*  948 */       break;
/*      */     case 1:
/*  950 */       strFieldName = "serialNo";
/*  951 */       break;
/*      */     case 2:
/*  953 */       strFieldName = "ContNo";
/*  954 */       break;
/*      */     case 3:
/*  956 */       strFieldName = "RiskCode";
/*  957 */       break;
/*      */     case 4:
/*  959 */       strFieldName = "InvestAccountCode";
/*  960 */       break;
/*      */     case 5:
/*  962 */       strFieldName = "InvestAccountRate";
/*  963 */       break;
/*      */     case 6:
/*  965 */       strFieldName = "Operator";
/*  966 */       break;
/*      */     case 7:
/*  968 */       strFieldName = "MakeDate";
/*  969 */       break;
/*      */     case 8:
/*  971 */       strFieldName = "MakeTime";
/*  972 */       break;
/*      */     case 9:
/*  974 */       strFieldName = "ModifyDate";
/*  975 */       break;
/*      */     case 10:
/*  977 */       strFieldName = "ModifyTime";
/*  978 */       break;
/*      */     case 11:
/*  980 */       strFieldName = "Remark";
/*  981 */       break;
/*      */     case 12:
/*  983 */       strFieldName = "Varc1";
/*  984 */       break;
/*      */     case 13:
/*  986 */       strFieldName = "Varc2";
/*  987 */       break;
/*      */     case 14:
/*  989 */       strFieldName = "Varc3";
/*  990 */       break;
/*      */     case 15:
/*  992 */       strFieldName = "Varc4";
/*  993 */       break;
/*      */     case 16:
/*  995 */       strFieldName = "DateTime1";
/*  996 */       break;
/*      */     case 17:
/*  998 */       strFieldName = "DateTime2";
/*  999 */       break;
/*      */     default:
/* 1001 */       strFieldName = "";
/*      */     }
/* 1003 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1009 */     if (strFieldName.equals("EdorNo")) {
/* 1010 */       return 0;
/*      */     }
/* 1012 */     if (strFieldName.equals("serialNo")) {
/* 1013 */       return 0;
/*      */     }
/* 1015 */     if (strFieldName.equals("ContNo")) {
/* 1016 */       return 0;
/*      */     }
/* 1018 */     if (strFieldName.equals("RiskCode")) {
/* 1019 */       return 0;
/*      */     }
/* 1021 */     if (strFieldName.equals("InvestAccountCode")) {
/* 1022 */       return 0;
/*      */     }
/* 1024 */     if (strFieldName.equals("InvestAccountRate")) {
/* 1025 */       return 4;
/*      */     }
/* 1027 */     if (strFieldName.equals("Operator")) {
/* 1028 */       return 0;
/*      */     }
/* 1030 */     if (strFieldName.equals("MakeDate")) {
/* 1031 */       return 0;
/*      */     }
/* 1033 */     if (strFieldName.equals("MakeTime")) {
/* 1034 */       return 0;
/*      */     }
/* 1036 */     if (strFieldName.equals("ModifyDate")) {
/* 1037 */       return 0;
/*      */     }
/* 1039 */     if (strFieldName.equals("ModifyTime")) {
/* 1040 */       return 0;
/*      */     }
/* 1042 */     if (strFieldName.equals("Remark")) {
/* 1043 */       return 0;
/*      */     }
/* 1045 */     if (strFieldName.equals("Varc1")) {
/* 1046 */       return 0;
/*      */     }
/* 1048 */     if (strFieldName.equals("Varc2")) {
/* 1049 */       return 0;
/*      */     }
/* 1051 */     if (strFieldName.equals("Varc3")) {
/* 1052 */       return 0;
/*      */     }
/* 1054 */     if (strFieldName.equals("Varc4")) {
/* 1055 */       return 0;
/*      */     }
/* 1057 */     if (strFieldName.equals("DateTime1")) {
/* 1058 */       return 1;
/*      */     }
/* 1060 */     if (strFieldName.equals("DateTime2")) {
/* 1061 */       return 1;
/*      */     }
/* 1063 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1069 */     int nFieldType = -1;
/* 1070 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1072 */       nFieldType = 0;
/* 1073 */       break;
/*      */     case 1:
/* 1075 */       nFieldType = 0;
/* 1076 */       break;
/*      */     case 2:
/* 1078 */       nFieldType = 0;
/* 1079 */       break;
/*      */     case 3:
/* 1081 */       nFieldType = 0;
/* 1082 */       break;
/*      */     case 4:
/* 1084 */       nFieldType = 0;
/* 1085 */       break;
/*      */     case 5:
/* 1087 */       nFieldType = 4;
/* 1088 */       break;
/*      */     case 6:
/* 1090 */       nFieldType = 0;
/* 1091 */       break;
/*      */     case 7:
/* 1093 */       nFieldType = 0;
/* 1094 */       break;
/*      */     case 8:
/* 1096 */       nFieldType = 0;
/* 1097 */       break;
/*      */     case 9:
/* 1099 */       nFieldType = 0;
/* 1100 */       break;
/*      */     case 10:
/* 1102 */       nFieldType = 0;
/* 1103 */       break;
/*      */     case 11:
/* 1105 */       nFieldType = 0;
/* 1106 */       break;
/*      */     case 12:
/* 1108 */       nFieldType = 0;
/* 1109 */       break;
/*      */     case 13:
/* 1111 */       nFieldType = 0;
/* 1112 */       break;
/*      */     case 14:
/* 1114 */       nFieldType = 0;
/* 1115 */       break;
/*      */     case 15:
/* 1117 */       nFieldType = 0;
/* 1118 */       break;
/*      */     case 16:
/* 1120 */       nFieldType = 1;
/* 1121 */       break;
/*      */     case 17:
/* 1123 */       nFieldType = 1;
/* 1124 */       break;
/*      */     default:
/* 1126 */       nFieldType = -1;
/*      */     }
/* 1128 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoBSchema
 * JD-Core Version:    0.6.0
 */