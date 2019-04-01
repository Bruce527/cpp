/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLinkDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.ChgData;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MLinkSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String agentCode;
/*      */   private String refURL;
/*      */   private String target;
/*      */   private String name;
/*      */   private int linkOrder;
/*      */   private String state;
/*      */   private String type;
/*      */   private String icon;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String modifyOperator;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String description;
/*      */   public static final int FIELDNUM = 23;
/*      */   private static String[] PK;
/*   70 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLinkSchema()
/*      */   {
/*   77 */     this.mErrors = new CErrors();
/*      */ 
/*   79 */     String[] pk = new String[1];
/*   80 */     pk[0] = "ID";
/*      */ 
/*   82 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   89 */     MLinkSchema cloned = (MLinkSchema)super.clone();
/*   90 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   91 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   92 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   98 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  103 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  107 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  111 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  115 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getRefURL() {
/*  119 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  123 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getTarget() {
/*  127 */     return this.target;
/*      */   }
/*      */ 
/*      */   public void setTarget(String aTarget) {
/*  131 */     this.target = aTarget;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  135 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  139 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public int getLinkOrder() {
/*  143 */     return this.linkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(int aLinkOrder) {
/*  147 */     this.linkOrder = aLinkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(String aLinkOrder) {
/*  151 */     if ((aLinkOrder != null) && (!aLinkOrder.equals("")))
/*      */     {
/*  153 */       Integer tInteger = new Integer(aLinkOrder);
/*  154 */       int i = tInteger.intValue();
/*  155 */       this.linkOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/*  161 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  165 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  169 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  173 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getIcon() {
/*  177 */     return this.icon;
/*      */   }
/*      */ 
/*      */   public void setIcon(String aIcon) {
/*  181 */     this.icon = aIcon;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  185 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  189 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  193 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  197 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  201 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  205 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  209 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  213 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  217 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  221 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  225 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  227 */       Integer tInteger = new Integer(aIF01);
/*  228 */       int i = tInteger.intValue();
/*  229 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  235 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  239 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  243 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  245 */       Double tDouble = new Double(aDF02);
/*  246 */       double d = tDouble.doubleValue();
/*  247 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  253 */     if (this.date01 != null) {
/*  254 */       return this.fDate.getString(this.date01);
/*      */     }
/*  256 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  260 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  264 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  266 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  269 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  274 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  278 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  282 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  286 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  290 */     if (this.makeDate != null) {
/*  291 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  293 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  297 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  301 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  303 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  306 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  311 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  315 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  319 */     if (this.modifyDate != null) {
/*  320 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  322 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  326 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  330 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  332 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  335 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  340 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  344 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getDescription() {
/*  348 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String aDescription) {
/*  352 */     this.description = aDescription;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLinkSchema aMLinkSchema)
/*      */   {
/*  358 */     this.iD = aMLinkSchema.getID();
/*  359 */     this.agentCode = aMLinkSchema.getAgentCode();
/*  360 */     this.refURL = aMLinkSchema.getRefURL();
/*  361 */     this.target = aMLinkSchema.getTarget();
/*  362 */     this.name = aMLinkSchema.getName();
/*  363 */     this.linkOrder = aMLinkSchema.getLinkOrder();
/*  364 */     this.state = aMLinkSchema.getState();
/*  365 */     this.type = aMLinkSchema.getType();
/*  366 */     this.icon = aMLinkSchema.getIcon();
/*  367 */     this.manageCom = aMLinkSchema.getManageCom();
/*  368 */     this.branchType = aMLinkSchema.getBranchType();
/*  369 */     this.vF01 = aMLinkSchema.getVF01();
/*  370 */     this.nF01 = aMLinkSchema.getNF01();
/*  371 */     this.iF01 = aMLinkSchema.getIF01();
/*  372 */     this.dF02 = aMLinkSchema.getDF02();
/*  373 */     this.date01 = this.fDate.getDate(aMLinkSchema.getDate01());
/*  374 */     this.modifyOperator = aMLinkSchema.getModifyOperator();
/*  375 */     this.operator = aMLinkSchema.getOperator();
/*  376 */     this.makeDate = this.fDate.getDate(aMLinkSchema.getMakeDate());
/*  377 */     this.makeTime = aMLinkSchema.getMakeTime();
/*  378 */     this.modifyDate = this.fDate.getDate(aMLinkSchema.getModifyDate());
/*  379 */     this.modifyTime = aMLinkSchema.getModifyTime();
/*  380 */     this.description = aMLinkSchema.getDescription();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  389 */       if (rs.getString("ID") == null)
/*  390 */         this.iD = null;
/*      */       else {
/*  392 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  394 */       if (rs.getString("AgentCode") == null)
/*  395 */         this.agentCode = null;
/*      */       else {
/*  397 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  399 */       if (rs.getString("RefURL") == null)
/*  400 */         this.refURL = null;
/*      */       else {
/*  402 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  404 */       if (rs.getString("Target") == null)
/*  405 */         this.target = null;
/*      */       else {
/*  407 */         this.target = rs.getString("Target").trim();
/*      */       }
/*  409 */       if (rs.getString("Name") == null)
/*  410 */         this.name = null;
/*      */       else {
/*  412 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  414 */       this.linkOrder = rs.getInt("LinkOrder");
/*  415 */       if (rs.getString("State") == null)
/*  416 */         this.state = null;
/*      */       else {
/*  418 */         this.state = rs.getString("State").trim();
/*      */       }
/*  420 */       if (rs.getString("Type") == null)
/*  421 */         this.type = null;
/*      */       else {
/*  423 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  425 */       if (rs.getString("Icon") == null)
/*  426 */         this.icon = null;
/*      */       else {
/*  428 */         this.icon = rs.getString("Icon").trim();
/*      */       }
/*  430 */       if (rs.getString("ManageCom") == null)
/*  431 */         this.manageCom = null;
/*      */       else {
/*  433 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  435 */       if (rs.getString("BranchType") == null)
/*  436 */         this.branchType = null;
/*      */       else {
/*  438 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  440 */       if (rs.getString("VF01") == null)
/*  441 */         this.vF01 = null;
/*      */       else {
/*  443 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  445 */       if (rs.getString("NF01") == null)
/*  446 */         this.nF01 = null;
/*      */       else {
/*  448 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  450 */       this.iF01 = rs.getInt("IF01");
/*  451 */       this.dF02 = rs.getDouble("DF02");
/*  452 */       this.date01 = rs.getDate("Date01");
/*  453 */       if (rs.getString("ModifyOperator") == null)
/*  454 */         this.modifyOperator = null;
/*      */       else {
/*  456 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  458 */       if (rs.getString("Operator") == null)
/*  459 */         this.operator = null;
/*      */       else {
/*  461 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  463 */       this.makeDate = rs.getDate("MakeDate");
/*  464 */       if (rs.getString("MakeTime") == null)
/*  465 */         this.makeTime = null;
/*      */       else {
/*  467 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  469 */       this.modifyDate = rs.getDate("ModifyDate");
/*  470 */       if (rs.getString("ModifyTime") == null)
/*  471 */         this.modifyTime = null;
/*      */       else {
/*  473 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  475 */       if (rs.getString("Description") == null)
/*  476 */         this.description = null;
/*      */       else {
/*  478 */         this.description = rs.getString("Description").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  483 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLink\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  485 */       CError tError = new CError();
/*  486 */       tError.moduleName = "MLinkSchema";
/*  487 */       tError.functionName = "setSchema";
/*  488 */       tError.errorMessage = sqle.toString();
/*  489 */       this.mErrors.addOneError(tError);
/*  490 */       return false;
/*      */     }
/*  492 */     return true;
/*      */   }
/*      */ 
/*      */   public MLinkSchema getSchema()
/*      */   {
/*  497 */     MLinkSchema aMLinkSchema = new MLinkSchema();
/*  498 */     aMLinkSchema.setSchema(this);
/*  499 */     return aMLinkSchema;
/*      */   }
/*      */ 
/*      */   public MLinkDB getDB()
/*      */   {
/*  504 */     MLinkDB aDBOper = new MLinkDB();
/*  505 */     aDBOper.setSchema(this);
/*  506 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  513 */     StringBuffer strReturn = new StringBuffer(256);
/*  514 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  515 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  516 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  517 */     strReturn.append(StrTool.cTrim(this.target)); strReturn.append("|");
/*  518 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  519 */     strReturn.append(ChgData.chgData(this.linkOrder)); strReturn.append("|");
/*  520 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  521 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  522 */     strReturn.append(StrTool.cTrim(this.icon)); strReturn.append("|");
/*  523 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  524 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  525 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  526 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  527 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  528 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  529 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  530 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  531 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  532 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  533 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  534 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  535 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  536 */     strReturn.append(StrTool.cTrim(this.description));
/*  537 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  545 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  546 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  547 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  548 */       this.target = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  549 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  550 */       this.linkOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).intValue();
/*  551 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  552 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  553 */       this.icon = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  554 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  555 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  556 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  557 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  558 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  559 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/*  560 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  561 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  562 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  563 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  564 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  565 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  566 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  567 */       this.description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  572 */       CError tError = new CError();
/*  573 */       tError.moduleName = "MLinkSchema";
/*  574 */       tError.functionName = "decode";
/*  575 */       tError.errorMessage = ex.toString();
/*  576 */       this.mErrors.addOneError(tError);
/*      */ 
/*  578 */       return false;
/*      */     }
/*  580 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  586 */     String strReturn = "";
/*  587 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  589 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  591 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  593 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  595 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  601 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.target));
/*      */     }
/*  603 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  605 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  607 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  609 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.linkOrder));
/*      */     }
/*  611 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  613 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  615 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  617 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  619 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/*  621 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.icon));
/*      */     }
/*  623 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  625 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  627 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  629 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  631 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  633 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  635 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  637 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  639 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  641 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  643 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  645 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  647 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  649 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  651 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  653 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  655 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  657 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  659 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  661 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  663 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  665 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  667 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  669 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  671 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  673 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  675 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  677 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.description));
/*      */     }
/*  679 */     if (strReturn.equals(""))
/*      */     {
/*  681 */       strReturn = "null";
/*      */     }
/*      */ 
/*  684 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  691 */     String strFieldValue = "";
/*  692 */     switch (nFieldIndex) {
/*      */     case 0:
/*  694 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  695 */       break;
/*      */     case 1:
/*  697 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  698 */       break;
/*      */     case 2:
/*  700 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  701 */       break;
/*      */     case 3:
/*  703 */       strFieldValue = StrTool.GBKToUnicode(this.target);
/*  704 */       break;
/*      */     case 4:
/*  706 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  707 */       break;
/*      */     case 5:
/*  709 */       strFieldValue = String.valueOf(this.linkOrder);
/*  710 */       break;
/*      */     case 6:
/*  712 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  713 */       break;
/*      */     case 7:
/*  715 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  716 */       break;
/*      */     case 8:
/*  718 */       strFieldValue = StrTool.GBKToUnicode(this.icon);
/*  719 */       break;
/*      */     case 9:
/*  721 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  722 */       break;
/*      */     case 10:
/*  724 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  725 */       break;
/*      */     case 11:
/*  727 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  728 */       break;
/*      */     case 12:
/*  730 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  731 */       break;
/*      */     case 13:
/*  733 */       strFieldValue = String.valueOf(this.iF01);
/*  734 */       break;
/*      */     case 14:
/*  736 */       strFieldValue = String.valueOf(this.dF02);
/*  737 */       break;
/*      */     case 15:
/*  739 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  740 */       break;
/*      */     case 16:
/*  742 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  743 */       break;
/*      */     case 17:
/*  745 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  746 */       break;
/*      */     case 18:
/*  748 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  749 */       break;
/*      */     case 19:
/*  751 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  752 */       break;
/*      */     case 20:
/*  754 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  755 */       break;
/*      */     case 21:
/*  757 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  758 */       break;
/*      */     case 22:
/*  760 */       strFieldValue = StrTool.GBKToUnicode(this.description);
/*  761 */       break;
/*      */     default:
/*  763 */       strFieldValue = "";
/*      */     }
/*  765 */     if (strFieldValue.equals("")) {
/*  766 */       strFieldValue = "null";
/*      */     }
/*  768 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  774 */     if (StrTool.cTrim(FCode).equals("")) {
/*  775 */       return false;
/*      */     }
/*  777 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  779 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  781 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  784 */         this.iD = null;
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  788 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  790 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  793 */         this.agentCode = null;
/*      */     }
/*  795 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  797 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  799 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  802 */         this.refURL = null;
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  806 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  808 */         this.target = FValue.trim();
/*      */       }
/*      */       else
/*  811 */         this.target = null;
/*      */     }
/*  813 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  815 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  817 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  820 */         this.name = null;
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  824 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  826 */         Integer tInteger = new Integer(FValue);
/*  827 */         int i = tInteger.intValue();
/*  828 */         this.linkOrder = i;
/*      */       }
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  833 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  835 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  838 */         this.state = null;
/*      */     }
/*  840 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  842 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  844 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  847 */         this.type = null;
/*      */     }
/*  849 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/*  851 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  853 */         this.icon = FValue.trim();
/*      */       }
/*      */       else
/*  856 */         this.icon = null;
/*      */     }
/*  858 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  860 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  862 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  865 */         this.manageCom = null;
/*      */     }
/*  867 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  869 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  871 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  874 */         this.branchType = null;
/*      */     }
/*  876 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  878 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  880 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/*  883 */         this.vF01 = null;
/*      */     }
/*  885 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  887 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  889 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/*  892 */         this.nF01 = null;
/*      */     }
/*  894 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  896 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  898 */         Integer tInteger = new Integer(FValue);
/*  899 */         int i = tInteger.intValue();
/*  900 */         this.iF01 = i;
/*      */       }
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  905 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  907 */         Double tDouble = new Double(FValue);
/*  908 */         double d = tDouble.doubleValue();
/*  909 */         this.dF02 = d;
/*      */       }
/*      */     }
/*  912 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  914 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  916 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  919 */         this.date01 = null;
/*      */     }
/*  921 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  923 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  925 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  928 */         this.modifyOperator = null;
/*      */     }
/*  930 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  932 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  934 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  937 */         this.operator = null;
/*      */     }
/*  939 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  941 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  943 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  946 */         this.makeDate = null;
/*      */     }
/*  948 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  950 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  952 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  955 */         this.makeTime = null;
/*      */     }
/*  957 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  959 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  961 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  964 */         this.modifyDate = null;
/*      */     }
/*  966 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  968 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  970 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  973 */         this.modifyTime = null;
/*      */     }
/*  975 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  977 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  979 */         this.description = FValue.trim();
/*      */       }
/*      */       else
/*  982 */         this.description = null;
/*      */     }
/*  984 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  989 */     if (otherObject == null) return false;
/*  990 */     if (this == otherObject) return true;
/*  991 */     if (getClass() != otherObject.getClass()) return false;
/*  992 */     MLinkSchema other = (MLinkSchema)otherObject;
/*  993 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  994 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  995 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/*  996 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/*  997 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/*  998 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/*  999 */     if ((this.target == null) && (other.getTarget() != null)) return false;
/* 1000 */     if ((this.target != null) && (!this.target.equals(other.getTarget()))) return false;
/* 1001 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1002 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1003 */     if (this.linkOrder != other.getLinkOrder()) return false;
/* 1004 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1005 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1006 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1007 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1008 */     if ((this.icon == null) && (other.getIcon() != null)) return false;
/* 1009 */     if ((this.icon != null) && (!this.icon.equals(other.getIcon()))) return false;
/* 1010 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1011 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1012 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1013 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1014 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1015 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1016 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1017 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1018 */     if (this.iF01 != other.getIF01()) return false;
/* 1019 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1020 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1021 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1022 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1023 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1024 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1025 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1026 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1027 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1028 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1029 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1030 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1031 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1032 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1033 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1034 */     if ((this.description == null) && (other.getDescription() != null)) return false;
/* 1035 */     return (this.description == null) || (this.description.equals(other.getDescription()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1042 */     return 23;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1048 */     if (strFieldName.equals("iD")) {
/* 1049 */       return 0;
/*      */     }
/* 1051 */     if (strFieldName.equals("agentCode")) {
/* 1052 */       return 1;
/*      */     }
/* 1054 */     if (strFieldName.equals("refURL")) {
/* 1055 */       return 2;
/*      */     }
/* 1057 */     if (strFieldName.equals("target")) {
/* 1058 */       return 3;
/*      */     }
/* 1060 */     if (strFieldName.equals("name")) {
/* 1061 */       return 4;
/*      */     }
/* 1063 */     if (strFieldName.equals("linkOrder")) {
/* 1064 */       return 5;
/*      */     }
/* 1066 */     if (strFieldName.equals("state")) {
/* 1067 */       return 6;
/*      */     }
/* 1069 */     if (strFieldName.equals("type")) {
/* 1070 */       return 7;
/*      */     }
/* 1072 */     if (strFieldName.equals("icon")) {
/* 1073 */       return 8;
/*      */     }
/* 1075 */     if (strFieldName.equals("manageCom")) {
/* 1076 */       return 9;
/*      */     }
/* 1078 */     if (strFieldName.equals("branchType")) {
/* 1079 */       return 10;
/*      */     }
/* 1081 */     if (strFieldName.equals("vF01")) {
/* 1082 */       return 11;
/*      */     }
/* 1084 */     if (strFieldName.equals("nF01")) {
/* 1085 */       return 12;
/*      */     }
/* 1087 */     if (strFieldName.equals("iF01")) {
/* 1088 */       return 13;
/*      */     }
/* 1090 */     if (strFieldName.equals("dF02")) {
/* 1091 */       return 14;
/*      */     }
/* 1093 */     if (strFieldName.equals("date01")) {
/* 1094 */       return 15;
/*      */     }
/* 1096 */     if (strFieldName.equals("modifyOperator")) {
/* 1097 */       return 16;
/*      */     }
/* 1099 */     if (strFieldName.equals("operator")) {
/* 1100 */       return 17;
/*      */     }
/* 1102 */     if (strFieldName.equals("makeDate")) {
/* 1103 */       return 18;
/*      */     }
/* 1105 */     if (strFieldName.equals("makeTime")) {
/* 1106 */       return 19;
/*      */     }
/* 1108 */     if (strFieldName.equals("modifyDate")) {
/* 1109 */       return 20;
/*      */     }
/* 1111 */     if (strFieldName.equals("modifyTime")) {
/* 1112 */       return 21;
/*      */     }
/* 1114 */     if (strFieldName.equals("description")) {
/* 1115 */       return 22;
/*      */     }
/* 1117 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1123 */     String strFieldName = "";
/* 1124 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1126 */       strFieldName = "iD";
/* 1127 */       break;
/*      */     case 1:
/* 1129 */       strFieldName = "agentCode";
/* 1130 */       break;
/*      */     case 2:
/* 1132 */       strFieldName = "refURL";
/* 1133 */       break;
/*      */     case 3:
/* 1135 */       strFieldName = "target";
/* 1136 */       break;
/*      */     case 4:
/* 1138 */       strFieldName = "name";
/* 1139 */       break;
/*      */     case 5:
/* 1141 */       strFieldName = "linkOrder";
/* 1142 */       break;
/*      */     case 6:
/* 1144 */       strFieldName = "state";
/* 1145 */       break;
/*      */     case 7:
/* 1147 */       strFieldName = "type";
/* 1148 */       break;
/*      */     case 8:
/* 1150 */       strFieldName = "icon";
/* 1151 */       break;
/*      */     case 9:
/* 1153 */       strFieldName = "manageCom";
/* 1154 */       break;
/*      */     case 10:
/* 1156 */       strFieldName = "branchType";
/* 1157 */       break;
/*      */     case 11:
/* 1159 */       strFieldName = "vF01";
/* 1160 */       break;
/*      */     case 12:
/* 1162 */       strFieldName = "nF01";
/* 1163 */       break;
/*      */     case 13:
/* 1165 */       strFieldName = "iF01";
/* 1166 */       break;
/*      */     case 14:
/* 1168 */       strFieldName = "dF02";
/* 1169 */       break;
/*      */     case 15:
/* 1171 */       strFieldName = "date01";
/* 1172 */       break;
/*      */     case 16:
/* 1174 */       strFieldName = "modifyOperator";
/* 1175 */       break;
/*      */     case 17:
/* 1177 */       strFieldName = "operator";
/* 1178 */       break;
/*      */     case 18:
/* 1180 */       strFieldName = "makeDate";
/* 1181 */       break;
/*      */     case 19:
/* 1183 */       strFieldName = "makeTime";
/* 1184 */       break;
/*      */     case 20:
/* 1186 */       strFieldName = "modifyDate";
/* 1187 */       break;
/*      */     case 21:
/* 1189 */       strFieldName = "modifyTime";
/* 1190 */       break;
/*      */     case 22:
/* 1192 */       strFieldName = "description";
/* 1193 */       break;
/*      */     default:
/* 1195 */       strFieldName = "";
/*      */     }
/* 1197 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1203 */     if (strFieldName.equals("iD")) {
/* 1204 */       return 0;
/*      */     }
/* 1206 */     if (strFieldName.equals("agentCode")) {
/* 1207 */       return 0;
/*      */     }
/* 1209 */     if (strFieldName.equals("refURL")) {
/* 1210 */       return 0;
/*      */     }
/* 1212 */     if (strFieldName.equals("target")) {
/* 1213 */       return 0;
/*      */     }
/* 1215 */     if (strFieldName.equals("name")) {
/* 1216 */       return 0;
/*      */     }
/* 1218 */     if (strFieldName.equals("linkOrder")) {
/* 1219 */       return 3;
/*      */     }
/* 1221 */     if (strFieldName.equals("state")) {
/* 1222 */       return 0;
/*      */     }
/* 1224 */     if (strFieldName.equals("type")) {
/* 1225 */       return 0;
/*      */     }
/* 1227 */     if (strFieldName.equals("icon")) {
/* 1228 */       return 0;
/*      */     }
/* 1230 */     if (strFieldName.equals("manageCom")) {
/* 1231 */       return 0;
/*      */     }
/* 1233 */     if (strFieldName.equals("branchType")) {
/* 1234 */       return 0;
/*      */     }
/* 1236 */     if (strFieldName.equals("vF01")) {
/* 1237 */       return 0;
/*      */     }
/* 1239 */     if (strFieldName.equals("nF01")) {
/* 1240 */       return 0;
/*      */     }
/* 1242 */     if (strFieldName.equals("iF01")) {
/* 1243 */       return 3;
/*      */     }
/* 1245 */     if (strFieldName.equals("dF02")) {
/* 1246 */       return 4;
/*      */     }
/* 1248 */     if (strFieldName.equals("date01")) {
/* 1249 */       return 1;
/*      */     }
/* 1251 */     if (strFieldName.equals("modifyOperator")) {
/* 1252 */       return 0;
/*      */     }
/* 1254 */     if (strFieldName.equals("operator")) {
/* 1255 */       return 0;
/*      */     }
/* 1257 */     if (strFieldName.equals("makeDate")) {
/* 1258 */       return 1;
/*      */     }
/* 1260 */     if (strFieldName.equals("makeTime")) {
/* 1261 */       return 0;
/*      */     }
/* 1263 */     if (strFieldName.equals("modifyDate")) {
/* 1264 */       return 1;
/*      */     }
/* 1266 */     if (strFieldName.equals("modifyTime")) {
/* 1267 */       return 0;
/*      */     }
/* 1269 */     if (strFieldName.equals("description")) {
/* 1270 */       return 0;
/*      */     }
/* 1272 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1278 */     int nFieldType = -1;
/* 1279 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1281 */       nFieldType = 0;
/* 1282 */       break;
/*      */     case 1:
/* 1284 */       nFieldType = 0;
/* 1285 */       break;
/*      */     case 2:
/* 1287 */       nFieldType = 0;
/* 1288 */       break;
/*      */     case 3:
/* 1290 */       nFieldType = 0;
/* 1291 */       break;
/*      */     case 4:
/* 1293 */       nFieldType = 0;
/* 1294 */       break;
/*      */     case 5:
/* 1296 */       nFieldType = 3;
/* 1297 */       break;
/*      */     case 6:
/* 1299 */       nFieldType = 0;
/* 1300 */       break;
/*      */     case 7:
/* 1302 */       nFieldType = 0;
/* 1303 */       break;
/*      */     case 8:
/* 1305 */       nFieldType = 0;
/* 1306 */       break;
/*      */     case 9:
/* 1308 */       nFieldType = 0;
/* 1309 */       break;
/*      */     case 10:
/* 1311 */       nFieldType = 0;
/* 1312 */       break;
/*      */     case 11:
/* 1314 */       nFieldType = 0;
/* 1315 */       break;
/*      */     case 12:
/* 1317 */       nFieldType = 0;
/* 1318 */       break;
/*      */     case 13:
/* 1320 */       nFieldType = 3;
/* 1321 */       break;
/*      */     case 14:
/* 1323 */       nFieldType = 4;
/* 1324 */       break;
/*      */     case 15:
/* 1326 */       nFieldType = 1;
/* 1327 */       break;
/*      */     case 16:
/* 1329 */       nFieldType = 0;
/* 1330 */       break;
/*      */     case 17:
/* 1332 */       nFieldType = 0;
/* 1333 */       break;
/*      */     case 18:
/* 1335 */       nFieldType = 1;
/* 1336 */       break;
/*      */     case 19:
/* 1338 */       nFieldType = 0;
/* 1339 */       break;
/*      */     case 20:
/* 1341 */       nFieldType = 1;
/* 1342 */       break;
/*      */     case 21:
/* 1344 */       nFieldType = 0;
/* 1345 */       break;
/*      */     case 22:
/* 1347 */       nFieldType = 0;
/* 1348 */       break;
/*      */     default:
/* 1350 */       nFieldType = -1;
/*      */     }
/* 1352 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLinkSchema
 * JD-Core Version:    0.6.0
 */