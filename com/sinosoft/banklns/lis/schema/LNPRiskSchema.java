/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.ChgData;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPRiskSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String riskCode;
/*      */   private String riskVer;
/*      */   private String riskName;
/*      */   private String riskShortName;
/*      */   private String riskEnName;
/*      */   private String riskEnShortName;
/*      */   private String choDutyFlag;
/*      */   private String cPayFlag;
/*      */   private String getFlag;
/*      */   private String edorFlag;
/*      */   private String rnewFlag;
/*      */   private String uWFlag;
/*      */   private String rinsFlag;
/*      */   private String insuAccFlag;
/*      */   private double destRate;
/*      */   private String origRiskCode;
/*      */   private String subRiskVer;
/*      */   private String riskStatName;
/*      */   public static final int FIELDNUM = 18;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPRiskSchema()
/*      */   {
/*   68 */     this.mErrors = new CErrors();
/*      */ 
/*   70 */     String[] pk = new String[1];
/*   71 */     pk[0] = "RiskCode";
/*      */ 
/*   73 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   80 */     LNPRiskSchema cloned = (LNPRiskSchema)super.clone();
/*   81 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   82 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   88 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getRiskCode()
/*      */   {
/*   93 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String aRiskCode) {
/*   97 */     this.riskCode = aRiskCode;
/*      */   }
/*      */ 
/*      */   public String getRiskVer() {
/*  101 */     return this.riskVer;
/*      */   }
/*      */ 
/*      */   public void setRiskVer(String aRiskVer) {
/*  105 */     this.riskVer = aRiskVer;
/*      */   }
/*      */ 
/*      */   public String getRiskName() {
/*  109 */     return this.riskName;
/*      */   }
/*      */ 
/*      */   public void setRiskName(String aRiskName) {
/*  113 */     this.riskName = aRiskName;
/*      */   }
/*      */ 
/*      */   public String getRiskShortName() {
/*  117 */     return this.riskShortName;
/*      */   }
/*      */ 
/*      */   public void setRiskShortName(String aRiskShortName) {
/*  121 */     this.riskShortName = aRiskShortName;
/*      */   }
/*      */ 
/*      */   public String getRiskEnName() {
/*  125 */     return this.riskEnName;
/*      */   }
/*      */ 
/*      */   public void setRiskEnName(String aRiskEnName) {
/*  129 */     this.riskEnName = aRiskEnName;
/*      */   }
/*      */ 
/*      */   public String getRiskEnShortName() {
/*  133 */     return this.riskEnShortName;
/*      */   }
/*      */ 
/*      */   public void setRiskEnShortName(String aRiskEnShortName) {
/*  137 */     this.riskEnShortName = aRiskEnShortName;
/*      */   }
/*      */ 
/*      */   public String getChoDutyFlag() {
/*  141 */     return this.choDutyFlag;
/*      */   }
/*      */ 
/*      */   public void setChoDutyFlag(String aChoDutyFlag) {
/*  145 */     this.choDutyFlag = aChoDutyFlag;
/*      */   }
/*      */ 
/*      */   public String getCPayFlag() {
/*  149 */     return this.cPayFlag;
/*      */   }
/*      */ 
/*      */   public void setCPayFlag(String aCPayFlag) {
/*  153 */     this.cPayFlag = aCPayFlag;
/*      */   }
/*      */ 
/*      */   public String getGetFlag() {
/*  157 */     return this.getFlag;
/*      */   }
/*      */ 
/*      */   public void setGetFlag(String aGetFlag) {
/*  161 */     this.getFlag = aGetFlag;
/*      */   }
/*      */ 
/*      */   public String getEdorFlag() {
/*  165 */     return this.edorFlag;
/*      */   }
/*      */ 
/*      */   public void setEdorFlag(String aEdorFlag) {
/*  169 */     this.edorFlag = aEdorFlag;
/*      */   }
/*      */ 
/*      */   public String getRnewFlag() {
/*  173 */     return this.rnewFlag;
/*      */   }
/*      */ 
/*      */   public void setRnewFlag(String aRnewFlag) {
/*  177 */     this.rnewFlag = aRnewFlag;
/*      */   }
/*      */ 
/*      */   public String getUWFlag() {
/*  181 */     return this.uWFlag;
/*      */   }
/*      */ 
/*      */   public void setUWFlag(String aUWFlag) {
/*  185 */     this.uWFlag = aUWFlag;
/*      */   }
/*      */ 
/*      */   public String getRinsFlag() {
/*  189 */     return this.rinsFlag;
/*      */   }
/*      */ 
/*      */   public void setRinsFlag(String aRinsFlag) {
/*  193 */     this.rinsFlag = aRinsFlag;
/*      */   }
/*      */ 
/*      */   public String getInsuAccFlag() {
/*  197 */     return this.insuAccFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuAccFlag(String aInsuAccFlag) {
/*  201 */     this.insuAccFlag = aInsuAccFlag;
/*      */   }
/*      */ 
/*      */   public double getDestRate() {
/*  205 */     return this.destRate;
/*      */   }
/*      */ 
/*      */   public void setDestRate(double aDestRate) {
/*  209 */     this.destRate = aDestRate;
/*      */   }
/*      */ 
/*      */   public void setDestRate(String aDestRate) {
/*  213 */     if ((aDestRate != null) && (!aDestRate.equals("")))
/*      */     {
/*  215 */       Double tDouble = new Double(aDestRate);
/*  216 */       double d = tDouble.doubleValue();
/*  217 */       this.destRate = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOrigRiskCode()
/*      */   {
/*  223 */     return this.origRiskCode;
/*      */   }
/*      */ 
/*      */   public void setOrigRiskCode(String aOrigRiskCode) {
/*  227 */     this.origRiskCode = aOrigRiskCode;
/*      */   }
/*      */ 
/*      */   public String getSubRiskVer() {
/*  231 */     return this.subRiskVer;
/*      */   }
/*      */ 
/*      */   public void setSubRiskVer(String aSubRiskVer) {
/*  235 */     this.subRiskVer = aSubRiskVer;
/*      */   }
/*      */ 
/*      */   public String getRiskStatName() {
/*  239 */     return this.riskStatName;
/*      */   }
/*      */ 
/*      */   public void setRiskStatName(String aRiskStatName) {
/*  243 */     this.riskStatName = aRiskStatName;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPRiskSchema aLNPRiskSchema)
/*      */   {
/*  249 */     this.riskCode = aLNPRiskSchema.getRiskCode();
/*  250 */     this.riskVer = aLNPRiskSchema.getRiskVer();
/*  251 */     this.riskName = aLNPRiskSchema.getRiskName();
/*  252 */     this.riskShortName = aLNPRiskSchema.getRiskShortName();
/*  253 */     this.riskEnName = aLNPRiskSchema.getRiskEnName();
/*  254 */     this.riskEnShortName = aLNPRiskSchema.getRiskEnShortName();
/*  255 */     this.choDutyFlag = aLNPRiskSchema.getChoDutyFlag();
/*  256 */     this.cPayFlag = aLNPRiskSchema.getCPayFlag();
/*  257 */     this.getFlag = aLNPRiskSchema.getGetFlag();
/*  258 */     this.edorFlag = aLNPRiskSchema.getEdorFlag();
/*  259 */     this.rnewFlag = aLNPRiskSchema.getRnewFlag();
/*  260 */     this.uWFlag = aLNPRiskSchema.getUWFlag();
/*  261 */     this.rinsFlag = aLNPRiskSchema.getRinsFlag();
/*  262 */     this.insuAccFlag = aLNPRiskSchema.getInsuAccFlag();
/*  263 */     this.destRate = aLNPRiskSchema.getDestRate();
/*  264 */     this.origRiskCode = aLNPRiskSchema.getOrigRiskCode();
/*  265 */     this.subRiskVer = aLNPRiskSchema.getSubRiskVer();
/*  266 */     this.riskStatName = aLNPRiskSchema.getRiskStatName();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  275 */       if (rs.getString("RiskCode") == null)
/*  276 */         this.riskCode = null;
/*      */       else {
/*  278 */         this.riskCode = rs.getString("RiskCode").trim();
/*      */       }
/*  280 */       if (rs.getString("RiskVer") == null)
/*  281 */         this.riskVer = null;
/*      */       else {
/*  283 */         this.riskVer = rs.getString("RiskVer").trim();
/*      */       }
/*  285 */       if (rs.getString("RiskName") == null)
/*  286 */         this.riskName = null;
/*      */       else {
/*  288 */         this.riskName = rs.getString("RiskName").trim();
/*      */       }
/*  290 */       if (rs.getString("RiskShortName") == null)
/*  291 */         this.riskShortName = null;
/*      */       else {
/*  293 */         this.riskShortName = rs.getString("RiskShortName").trim();
/*      */       }
/*  295 */       if (rs.getString("RiskEnName") == null)
/*  296 */         this.riskEnName = null;
/*      */       else {
/*  298 */         this.riskEnName = rs.getString("RiskEnName").trim();
/*      */       }
/*  300 */       if (rs.getString("RiskEnShortName") == null)
/*  301 */         this.riskEnShortName = null;
/*      */       else {
/*  303 */         this.riskEnShortName = rs.getString("RiskEnShortName").trim();
/*      */       }
/*  305 */       if (rs.getString("ChoDutyFlag") == null)
/*  306 */         this.choDutyFlag = null;
/*      */       else {
/*  308 */         this.choDutyFlag = rs.getString("ChoDutyFlag").trim();
/*      */       }
/*  310 */       if (rs.getString("CPayFlag") == null)
/*  311 */         this.cPayFlag = null;
/*      */       else {
/*  313 */         this.cPayFlag = rs.getString("CPayFlag").trim();
/*      */       }
/*  315 */       if (rs.getString("GetFlag") == null)
/*  316 */         this.getFlag = null;
/*      */       else {
/*  318 */         this.getFlag = rs.getString("GetFlag").trim();
/*      */       }
/*  320 */       if (rs.getString("EdorFlag") == null)
/*  321 */         this.edorFlag = null;
/*      */       else {
/*  323 */         this.edorFlag = rs.getString("EdorFlag").trim();
/*      */       }
/*  325 */       if (rs.getString("RnewFlag") == null)
/*  326 */         this.rnewFlag = null;
/*      */       else {
/*  328 */         this.rnewFlag = rs.getString("RnewFlag").trim();
/*      */       }
/*  330 */       if (rs.getString("UWFlag") == null)
/*  331 */         this.uWFlag = null;
/*      */       else {
/*  333 */         this.uWFlag = rs.getString("UWFlag").trim();
/*      */       }
/*  335 */       if (rs.getString("RinsFlag") == null)
/*  336 */         this.rinsFlag = null;
/*      */       else {
/*  338 */         this.rinsFlag = rs.getString("RinsFlag").trim();
/*      */       }
/*  340 */       if (rs.getString("InsuAccFlag") == null)
/*  341 */         this.insuAccFlag = null;
/*      */       else {
/*  343 */         this.insuAccFlag = rs.getString("InsuAccFlag").trim();
/*      */       }
/*  345 */       this.destRate = rs.getDouble("DestRate");
/*  346 */       if (rs.getString("OrigRiskCode") == null)
/*  347 */         this.origRiskCode = null;
/*      */       else {
/*  349 */         this.origRiskCode = rs.getString("OrigRiskCode").trim();
/*      */       }
/*  351 */       if (rs.getString("SubRiskVer") == null)
/*  352 */         this.subRiskVer = null;
/*      */       else {
/*  354 */         this.subRiskVer = rs.getString("SubRiskVer").trim();
/*      */       }
/*  356 */       if (rs.getString("RiskStatName") == null)
/*  357 */         this.riskStatName = null;
/*      */       else {
/*  359 */         this.riskStatName = rs.getString("RiskStatName").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  364 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRisk\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  366 */       CError tError = new CError();
/*  367 */       tError.moduleName = "LNPRiskSchema";
/*  368 */       tError.functionName = "setSchema";
/*  369 */       tError.errorMessage = sqle.toString();
/*  370 */       this.mErrors.addOneError(tError);
/*  371 */       return false;
/*      */     }
/*  373 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskSchema getSchema()
/*      */   {
/*  378 */     LNPRiskSchema aLNPRiskSchema = new LNPRiskSchema();
/*  379 */     aLNPRiskSchema.setSchema(this);
/*  380 */     return aLNPRiskSchema;
/*      */   }
/*      */ 
/*      */   public LNPRiskDB getDB()
/*      */   {
/*  385 */     LNPRiskDB aDBOper = new LNPRiskDB();
/*  386 */     aDBOper.setSchema(this);
/*  387 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  394 */     StringBuffer strReturn = new StringBuffer(256);
/*  395 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/*  396 */     strReturn.append(StrTool.cTrim(this.riskVer)); strReturn.append("|");
/*  397 */     strReturn.append(StrTool.cTrim(this.riskName)); strReturn.append("|");
/*  398 */     strReturn.append(StrTool.cTrim(this.riskShortName)); strReturn.append("|");
/*  399 */     strReturn.append(StrTool.cTrim(this.riskEnName)); strReturn.append("|");
/*  400 */     strReturn.append(StrTool.cTrim(this.riskEnShortName)); strReturn.append("|");
/*  401 */     strReturn.append(StrTool.cTrim(this.choDutyFlag)); strReturn.append("|");
/*  402 */     strReturn.append(StrTool.cTrim(this.cPayFlag)); strReturn.append("|");
/*  403 */     strReturn.append(StrTool.cTrim(this.getFlag)); strReturn.append("|");
/*  404 */     strReturn.append(StrTool.cTrim(this.edorFlag)); strReturn.append("|");
/*  405 */     strReturn.append(StrTool.cTrim(this.rnewFlag)); strReturn.append("|");
/*  406 */     strReturn.append(StrTool.cTrim(this.uWFlag)); strReturn.append("|");
/*  407 */     strReturn.append(StrTool.cTrim(this.rinsFlag)); strReturn.append("|");
/*  408 */     strReturn.append(StrTool.cTrim(this.insuAccFlag)); strReturn.append("|");
/*  409 */     strReturn.append(ChgData.chgData(this.destRate)); strReturn.append("|");
/*  410 */     strReturn.append(StrTool.cTrim(this.origRiskCode)); strReturn.append("|");
/*  411 */     strReturn.append(StrTool.cTrim(this.subRiskVer)); strReturn.append("|");
/*  412 */     strReturn.append(StrTool.cTrim(this.riskStatName));
/*  413 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  421 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  422 */       this.riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  423 */       this.riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  424 */       this.riskShortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  425 */       this.riskEnName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  426 */       this.riskEnShortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  427 */       this.choDutyFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  428 */       this.cPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  429 */       this.getFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  430 */       this.edorFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  431 */       this.rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  432 */       this.uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  433 */       this.rinsFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  434 */       this.insuAccFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  435 */       this.destRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/*  436 */       this.origRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  437 */       this.subRiskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  438 */       this.riskStatName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  443 */       CError tError = new CError();
/*  444 */       tError.moduleName = "LNPRiskSchema";
/*  445 */       tError.functionName = "decode";
/*  446 */       tError.errorMessage = ex.toString();
/*  447 */       this.mErrors.addOneError(tError);
/*      */ 
/*  449 */       return false;
/*      */     }
/*  451 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  457 */     String strReturn = "";
/*  458 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/*  460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*      */     }
/*  462 */     if (FCode.equalsIgnoreCase("riskVer"))
/*      */     {
/*  464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskVer));
/*      */     }
/*  466 */     if (FCode.equalsIgnoreCase("riskName"))
/*      */     {
/*  468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskName));
/*      */     }
/*  470 */     if (FCode.equalsIgnoreCase("riskShortName"))
/*      */     {
/*  472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskShortName));
/*      */     }
/*  474 */     if (FCode.equalsIgnoreCase("riskEnName"))
/*      */     {
/*  476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskEnName));
/*      */     }
/*  478 */     if (FCode.equalsIgnoreCase("riskEnShortName"))
/*      */     {
/*  480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskEnShortName));
/*      */     }
/*  482 */     if (FCode.equalsIgnoreCase("choDutyFlag"))
/*      */     {
/*  484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.choDutyFlag));
/*      */     }
/*  486 */     if (FCode.equalsIgnoreCase("cPayFlag"))
/*      */     {
/*  488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.cPayFlag));
/*      */     }
/*  490 */     if (FCode.equalsIgnoreCase("getFlag"))
/*      */     {
/*  492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.getFlag));
/*      */     }
/*  494 */     if (FCode.equalsIgnoreCase("edorFlag"))
/*      */     {
/*  496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorFlag));
/*      */     }
/*  498 */     if (FCode.equalsIgnoreCase("rnewFlag"))
/*      */     {
/*  500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rnewFlag));
/*      */     }
/*  502 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/*  504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.uWFlag));
/*      */     }
/*  506 */     if (FCode.equalsIgnoreCase("rinsFlag"))
/*      */     {
/*  508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.rinsFlag));
/*      */     }
/*  510 */     if (FCode.equalsIgnoreCase("insuAccFlag"))
/*      */     {
/*  512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuAccFlag));
/*      */     }
/*  514 */     if (FCode.equalsIgnoreCase("destRate"))
/*      */     {
/*  516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.destRate));
/*      */     }
/*  518 */     if (FCode.equalsIgnoreCase("origRiskCode"))
/*      */     {
/*  520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.origRiskCode));
/*      */     }
/*  522 */     if (FCode.equalsIgnoreCase("subRiskVer"))
/*      */     {
/*  524 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subRiskVer));
/*      */     }
/*  526 */     if (FCode.equalsIgnoreCase("riskStatName"))
/*      */     {
/*  528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskStatName));
/*      */     }
/*  530 */     if (strReturn.equals(""))
/*      */     {
/*  532 */       strReturn = "null";
/*      */     }
/*      */ 
/*  535 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  542 */     String strFieldValue = "";
/*  543 */     switch (nFieldIndex) {
/*      */     case 0:
/*  545 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/*  546 */       break;
/*      */     case 1:
/*  548 */       strFieldValue = StrTool.GBKToUnicode(this.riskVer);
/*  549 */       break;
/*      */     case 2:
/*  551 */       strFieldValue = StrTool.GBKToUnicode(this.riskName);
/*  552 */       break;
/*      */     case 3:
/*  554 */       strFieldValue = StrTool.GBKToUnicode(this.riskShortName);
/*  555 */       break;
/*      */     case 4:
/*  557 */       strFieldValue = StrTool.GBKToUnicode(this.riskEnName);
/*  558 */       break;
/*      */     case 5:
/*  560 */       strFieldValue = StrTool.GBKToUnicode(this.riskEnShortName);
/*  561 */       break;
/*      */     case 6:
/*  563 */       strFieldValue = StrTool.GBKToUnicode(this.choDutyFlag);
/*  564 */       break;
/*      */     case 7:
/*  566 */       strFieldValue = StrTool.GBKToUnicode(this.cPayFlag);
/*  567 */       break;
/*      */     case 8:
/*  569 */       strFieldValue = StrTool.GBKToUnicode(this.getFlag);
/*  570 */       break;
/*      */     case 9:
/*  572 */       strFieldValue = StrTool.GBKToUnicode(this.edorFlag);
/*  573 */       break;
/*      */     case 10:
/*  575 */       strFieldValue = StrTool.GBKToUnicode(this.rnewFlag);
/*  576 */       break;
/*      */     case 11:
/*  578 */       strFieldValue = StrTool.GBKToUnicode(this.uWFlag);
/*  579 */       break;
/*      */     case 12:
/*  581 */       strFieldValue = StrTool.GBKToUnicode(this.rinsFlag);
/*  582 */       break;
/*      */     case 13:
/*  584 */       strFieldValue = StrTool.GBKToUnicode(this.insuAccFlag);
/*  585 */       break;
/*      */     case 14:
/*  587 */       strFieldValue = String.valueOf(this.destRate);
/*  588 */       break;
/*      */     case 15:
/*  590 */       strFieldValue = StrTool.GBKToUnicode(this.origRiskCode);
/*  591 */       break;
/*      */     case 16:
/*  593 */       strFieldValue = StrTool.GBKToUnicode(this.subRiskVer);
/*  594 */       break;
/*      */     case 17:
/*  596 */       strFieldValue = StrTool.GBKToUnicode(this.riskStatName);
/*  597 */       break;
/*      */     default:
/*  599 */       strFieldValue = "";
/*      */     }
/*  601 */     if (strFieldValue.equals("")) {
/*  602 */       strFieldValue = "null";
/*      */     }
/*  604 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  610 */     if (StrTool.cTrim(FCode).equals("")) {
/*  611 */       return false;
/*      */     }
/*  613 */     if (FCode.equalsIgnoreCase("riskCode"))
/*      */     {
/*  615 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  617 */         this.riskCode = FValue.trim();
/*      */       }
/*      */       else
/*  620 */         this.riskCode = null;
/*      */     }
/*  622 */     if (FCode.equalsIgnoreCase("riskVer"))
/*      */     {
/*  624 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  626 */         this.riskVer = FValue.trim();
/*      */       }
/*      */       else
/*  629 */         this.riskVer = null;
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("riskName"))
/*      */     {
/*  633 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  635 */         this.riskName = FValue.trim();
/*      */       }
/*      */       else
/*  638 */         this.riskName = null;
/*      */     }
/*  640 */     if (FCode.equalsIgnoreCase("riskShortName"))
/*      */     {
/*  642 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  644 */         this.riskShortName = FValue.trim();
/*      */       }
/*      */       else
/*  647 */         this.riskShortName = null;
/*      */     }
/*  649 */     if (FCode.equalsIgnoreCase("riskEnName"))
/*      */     {
/*  651 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  653 */         this.riskEnName = FValue.trim();
/*      */       }
/*      */       else
/*  656 */         this.riskEnName = null;
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("riskEnShortName"))
/*      */     {
/*  660 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  662 */         this.riskEnShortName = FValue.trim();
/*      */       }
/*      */       else
/*  665 */         this.riskEnShortName = null;
/*      */     }
/*  667 */     if (FCode.equalsIgnoreCase("choDutyFlag"))
/*      */     {
/*  669 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  671 */         this.choDutyFlag = FValue.trim();
/*      */       }
/*      */       else
/*  674 */         this.choDutyFlag = null;
/*      */     }
/*  676 */     if (FCode.equalsIgnoreCase("cPayFlag"))
/*      */     {
/*  678 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  680 */         this.cPayFlag = FValue.trim();
/*      */       }
/*      */       else
/*  683 */         this.cPayFlag = null;
/*      */     }
/*  685 */     if (FCode.equalsIgnoreCase("getFlag"))
/*      */     {
/*  687 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  689 */         this.getFlag = FValue.trim();
/*      */       }
/*      */       else
/*  692 */         this.getFlag = null;
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("edorFlag"))
/*      */     {
/*  696 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  698 */         this.edorFlag = FValue.trim();
/*      */       }
/*      */       else
/*  701 */         this.edorFlag = null;
/*      */     }
/*  703 */     if (FCode.equalsIgnoreCase("rnewFlag"))
/*      */     {
/*  705 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  707 */         this.rnewFlag = FValue.trim();
/*      */       }
/*      */       else
/*  710 */         this.rnewFlag = null;
/*      */     }
/*  712 */     if (FCode.equalsIgnoreCase("uWFlag"))
/*      */     {
/*  714 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  716 */         this.uWFlag = FValue.trim();
/*      */       }
/*      */       else
/*  719 */         this.uWFlag = null;
/*      */     }
/*  721 */     if (FCode.equalsIgnoreCase("rinsFlag"))
/*      */     {
/*  723 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  725 */         this.rinsFlag = FValue.trim();
/*      */       }
/*      */       else
/*  728 */         this.rinsFlag = null;
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("insuAccFlag"))
/*      */     {
/*  732 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  734 */         this.insuAccFlag = FValue.trim();
/*      */       }
/*      */       else
/*  737 */         this.insuAccFlag = null;
/*      */     }
/*  739 */     if (FCode.equalsIgnoreCase("destRate"))
/*      */     {
/*  741 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  743 */         Double tDouble = new Double(FValue);
/*  744 */         double d = tDouble.doubleValue();
/*  745 */         this.destRate = d;
/*      */       }
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("origRiskCode"))
/*      */     {
/*  750 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  752 */         this.origRiskCode = FValue.trim();
/*      */       }
/*      */       else
/*  755 */         this.origRiskCode = null;
/*      */     }
/*  757 */     if (FCode.equalsIgnoreCase("subRiskVer"))
/*      */     {
/*  759 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  761 */         this.subRiskVer = FValue.trim();
/*      */       }
/*      */       else
/*  764 */         this.subRiskVer = null;
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("riskStatName"))
/*      */     {
/*  768 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  770 */         this.riskStatName = FValue.trim();
/*      */       }
/*      */       else
/*  773 */         this.riskStatName = null;
/*      */     }
/*  775 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  780 */     if (otherObject == null) return false;
/*  781 */     if (this == otherObject) return true;
/*  782 */     if (getClass() != otherObject.getClass()) return false;
/*  783 */     LNPRiskSchema other = (LNPRiskSchema)otherObject;
/*  784 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/*  785 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/*  786 */     if ((this.riskVer == null) && (other.getRiskVer() != null)) return false;
/*  787 */     if ((this.riskVer != null) && (!this.riskVer.equals(other.getRiskVer()))) return false;
/*  788 */     if ((this.riskName == null) && (other.getRiskName() != null)) return false;
/*  789 */     if ((this.riskName != null) && (!this.riskName.equals(other.getRiskName()))) return false;
/*  790 */     if ((this.riskShortName == null) && (other.getRiskShortName() != null)) return false;
/*  791 */     if ((this.riskShortName != null) && (!this.riskShortName.equals(other.getRiskShortName()))) return false;
/*  792 */     if ((this.riskEnName == null) && (other.getRiskEnName() != null)) return false;
/*  793 */     if ((this.riskEnName != null) && (!this.riskEnName.equals(other.getRiskEnName()))) return false;
/*  794 */     if ((this.riskEnShortName == null) && (other.getRiskEnShortName() != null)) return false;
/*  795 */     if ((this.riskEnShortName != null) && (!this.riskEnShortName.equals(other.getRiskEnShortName()))) return false;
/*  796 */     if ((this.choDutyFlag == null) && (other.getChoDutyFlag() != null)) return false;
/*  797 */     if ((this.choDutyFlag != null) && (!this.choDutyFlag.equals(other.getChoDutyFlag()))) return false;
/*  798 */     if ((this.cPayFlag == null) && (other.getCPayFlag() != null)) return false;
/*  799 */     if ((this.cPayFlag != null) && (!this.cPayFlag.equals(other.getCPayFlag()))) return false;
/*  800 */     if ((this.getFlag == null) && (other.getGetFlag() != null)) return false;
/*  801 */     if ((this.getFlag != null) && (!this.getFlag.equals(other.getGetFlag()))) return false;
/*  802 */     if ((this.edorFlag == null) && (other.getEdorFlag() != null)) return false;
/*  803 */     if ((this.edorFlag != null) && (!this.edorFlag.equals(other.getEdorFlag()))) return false;
/*  804 */     if ((this.rnewFlag == null) && (other.getRnewFlag() != null)) return false;
/*  805 */     if ((this.rnewFlag != null) && (!this.rnewFlag.equals(other.getRnewFlag()))) return false;
/*  806 */     if ((this.uWFlag == null) && (other.getUWFlag() != null)) return false;
/*  807 */     if ((this.uWFlag != null) && (!this.uWFlag.equals(other.getUWFlag()))) return false;
/*  808 */     if ((this.rinsFlag == null) && (other.getRinsFlag() != null)) return false;
/*  809 */     if ((this.rinsFlag != null) && (!this.rinsFlag.equals(other.getRinsFlag()))) return false;
/*  810 */     if ((this.insuAccFlag == null) && (other.getInsuAccFlag() != null)) return false;
/*  811 */     if ((this.insuAccFlag != null) && (!this.insuAccFlag.equals(other.getInsuAccFlag()))) return false;
/*  812 */     if (Double.doubleToLongBits(this.destRate) != Double.doubleToLongBits(other.getDestRate())) return false;
/*  813 */     if ((this.origRiskCode == null) && (other.getOrigRiskCode() != null)) return false;
/*  814 */     if ((this.origRiskCode != null) && (!this.origRiskCode.equals(other.getOrigRiskCode()))) return false;
/*  815 */     if ((this.subRiskVer == null) && (other.getSubRiskVer() != null)) return false;
/*  816 */     if ((this.subRiskVer != null) && (!this.subRiskVer.equals(other.getSubRiskVer()))) return false;
/*  817 */     if ((this.riskStatName == null) && (other.getRiskStatName() != null)) return false;
/*  818 */     return (this.riskStatName == null) || (this.riskStatName.equals(other.getRiskStatName()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  825 */     return 18;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  831 */     if (strFieldName.equals("riskCode")) {
/*  832 */       return 0;
/*      */     }
/*  834 */     if (strFieldName.equals("riskVer")) {
/*  835 */       return 1;
/*      */     }
/*  837 */     if (strFieldName.equals("riskName")) {
/*  838 */       return 2;
/*      */     }
/*  840 */     if (strFieldName.equals("riskShortName")) {
/*  841 */       return 3;
/*      */     }
/*  843 */     if (strFieldName.equals("riskEnName")) {
/*  844 */       return 4;
/*      */     }
/*  846 */     if (strFieldName.equals("riskEnShortName")) {
/*  847 */       return 5;
/*      */     }
/*  849 */     if (strFieldName.equals("choDutyFlag")) {
/*  850 */       return 6;
/*      */     }
/*  852 */     if (strFieldName.equals("cPayFlag")) {
/*  853 */       return 7;
/*      */     }
/*  855 */     if (strFieldName.equals("getFlag")) {
/*  856 */       return 8;
/*      */     }
/*  858 */     if (strFieldName.equals("edorFlag")) {
/*  859 */       return 9;
/*      */     }
/*  861 */     if (strFieldName.equals("rnewFlag")) {
/*  862 */       return 10;
/*      */     }
/*  864 */     if (strFieldName.equals("uWFlag")) {
/*  865 */       return 11;
/*      */     }
/*  867 */     if (strFieldName.equals("rinsFlag")) {
/*  868 */       return 12;
/*      */     }
/*  870 */     if (strFieldName.equals("insuAccFlag")) {
/*  871 */       return 13;
/*      */     }
/*  873 */     if (strFieldName.equals("destRate")) {
/*  874 */       return 14;
/*      */     }
/*  876 */     if (strFieldName.equals("origRiskCode")) {
/*  877 */       return 15;
/*      */     }
/*  879 */     if (strFieldName.equals("subRiskVer")) {
/*  880 */       return 16;
/*      */     }
/*  882 */     if (strFieldName.equals("riskStatName")) {
/*  883 */       return 17;
/*      */     }
/*  885 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  891 */     String strFieldName = "";
/*  892 */     switch (nFieldIndex) {
/*      */     case 0:
/*  894 */       strFieldName = "riskCode";
/*  895 */       break;
/*      */     case 1:
/*  897 */       strFieldName = "riskVer";
/*  898 */       break;
/*      */     case 2:
/*  900 */       strFieldName = "riskName";
/*  901 */       break;
/*      */     case 3:
/*  903 */       strFieldName = "riskShortName";
/*  904 */       break;
/*      */     case 4:
/*  906 */       strFieldName = "riskEnName";
/*  907 */       break;
/*      */     case 5:
/*  909 */       strFieldName = "riskEnShortName";
/*  910 */       break;
/*      */     case 6:
/*  912 */       strFieldName = "choDutyFlag";
/*  913 */       break;
/*      */     case 7:
/*  915 */       strFieldName = "cPayFlag";
/*  916 */       break;
/*      */     case 8:
/*  918 */       strFieldName = "getFlag";
/*  919 */       break;
/*      */     case 9:
/*  921 */       strFieldName = "edorFlag";
/*  922 */       break;
/*      */     case 10:
/*  924 */       strFieldName = "rnewFlag";
/*  925 */       break;
/*      */     case 11:
/*  927 */       strFieldName = "uWFlag";
/*  928 */       break;
/*      */     case 12:
/*  930 */       strFieldName = "rinsFlag";
/*  931 */       break;
/*      */     case 13:
/*  933 */       strFieldName = "insuAccFlag";
/*  934 */       break;
/*      */     case 14:
/*  936 */       strFieldName = "destRate";
/*  937 */       break;
/*      */     case 15:
/*  939 */       strFieldName = "origRiskCode";
/*  940 */       break;
/*      */     case 16:
/*  942 */       strFieldName = "subRiskVer";
/*  943 */       break;
/*      */     case 17:
/*  945 */       strFieldName = "riskStatName";
/*  946 */       break;
/*      */     default:
/*  948 */       strFieldName = "";
/*      */     }
/*  950 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/*  956 */     if (strFieldName.equals("riskCode")) {
/*  957 */       return 0;
/*      */     }
/*  959 */     if (strFieldName.equals("riskVer")) {
/*  960 */       return 0;
/*      */     }
/*  962 */     if (strFieldName.equals("riskName")) {
/*  963 */       return 0;
/*      */     }
/*  965 */     if (strFieldName.equals("riskShortName")) {
/*  966 */       return 0;
/*      */     }
/*  968 */     if (strFieldName.equals("riskEnName")) {
/*  969 */       return 0;
/*      */     }
/*  971 */     if (strFieldName.equals("riskEnShortName")) {
/*  972 */       return 0;
/*      */     }
/*  974 */     if (strFieldName.equals("choDutyFlag")) {
/*  975 */       return 0;
/*      */     }
/*  977 */     if (strFieldName.equals("cPayFlag")) {
/*  978 */       return 0;
/*      */     }
/*  980 */     if (strFieldName.equals("getFlag")) {
/*  981 */       return 0;
/*      */     }
/*  983 */     if (strFieldName.equals("edorFlag")) {
/*  984 */       return 0;
/*      */     }
/*  986 */     if (strFieldName.equals("rnewFlag")) {
/*  987 */       return 0;
/*      */     }
/*  989 */     if (strFieldName.equals("uWFlag")) {
/*  990 */       return 0;
/*      */     }
/*  992 */     if (strFieldName.equals("rinsFlag")) {
/*  993 */       return 0;
/*      */     }
/*  995 */     if (strFieldName.equals("insuAccFlag")) {
/*  996 */       return 0;
/*      */     }
/*  998 */     if (strFieldName.equals("destRate")) {
/*  999 */       return 4;
/*      */     }
/* 1001 */     if (strFieldName.equals("origRiskCode")) {
/* 1002 */       return 0;
/*      */     }
/* 1004 */     if (strFieldName.equals("subRiskVer")) {
/* 1005 */       return 0;
/*      */     }
/* 1007 */     if (strFieldName.equals("riskStatName")) {
/* 1008 */       return 0;
/*      */     }
/* 1010 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1016 */     int nFieldType = -1;
/* 1017 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1019 */       nFieldType = 0;
/* 1020 */       break;
/*      */     case 1:
/* 1022 */       nFieldType = 0;
/* 1023 */       break;
/*      */     case 2:
/* 1025 */       nFieldType = 0;
/* 1026 */       break;
/*      */     case 3:
/* 1028 */       nFieldType = 0;
/* 1029 */       break;
/*      */     case 4:
/* 1031 */       nFieldType = 0;
/* 1032 */       break;
/*      */     case 5:
/* 1034 */       nFieldType = 0;
/* 1035 */       break;
/*      */     case 6:
/* 1037 */       nFieldType = 0;
/* 1038 */       break;
/*      */     case 7:
/* 1040 */       nFieldType = 0;
/* 1041 */       break;
/*      */     case 8:
/* 1043 */       nFieldType = 0;
/* 1044 */       break;
/*      */     case 9:
/* 1046 */       nFieldType = 0;
/* 1047 */       break;
/*      */     case 10:
/* 1049 */       nFieldType = 0;
/* 1050 */       break;
/*      */     case 11:
/* 1052 */       nFieldType = 0;
/* 1053 */       break;
/*      */     case 12:
/* 1055 */       nFieldType = 0;
/* 1056 */       break;
/*      */     case 13:
/* 1058 */       nFieldType = 0;
/* 1059 */       break;
/*      */     case 14:
/* 1061 */       nFieldType = 4;
/* 1062 */       break;
/*      */     case 15:
/* 1064 */       nFieldType = 0;
/* 1065 */       break;
/*      */     case 16:
/* 1067 */       nFieldType = 0;
/* 1068 */       break;
/*      */     case 17:
/* 1070 */       nFieldType = 0;
/* 1071 */       break;
/*      */     default:
/* 1073 */       nFieldType = -1;
/*      */     }
/* 1075 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskSchema
 * JD-Core Version:    0.6.0
 */