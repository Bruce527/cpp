/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLinkBDB;
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
/*      */ public class MLinkBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String refURL;
/*      */   private String target;
/*      */   private String name;
/*      */   private int linkOrder;
/*      */   private String state;
/*      */   private String type;
/*      */   private String agentCode;
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
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 29;
/*      */   private static String[] PK;
/*   82 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLinkBSchema()
/*      */   {
/*   89 */     this.mErrors = new CErrors();
/*      */ 
/*   91 */     String[] pk = new String[1];
/*   92 */     pk[0] = "EdorNo";
/*      */ 
/*   94 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  101 */     MLinkBSchema cloned = (MLinkBSchema)super.clone();
/*  102 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  103 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  104 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  110 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  115 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  119 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getRefURL() {
/*  123 */     return this.refURL;
/*      */   }
/*      */ 
/*      */   public void setRefURL(String aRefURL) {
/*  127 */     this.refURL = aRefURL;
/*      */   }
/*      */ 
/*      */   public String getTarget() {
/*  131 */     return this.target;
/*      */   }
/*      */ 
/*      */   public void setTarget(String aTarget) {
/*  135 */     this.target = aTarget;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  139 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  143 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public int getLinkOrder() {
/*  147 */     return this.linkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(int aLinkOrder) {
/*  151 */     this.linkOrder = aLinkOrder;
/*      */   }
/*      */ 
/*      */   public void setLinkOrder(String aLinkOrder) {
/*  155 */     if ((aLinkOrder != null) && (!aLinkOrder.equals("")))
/*      */     {
/*  157 */       Integer tInteger = new Integer(aLinkOrder);
/*  158 */       int i = tInteger.intValue();
/*  159 */       this.linkOrder = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getState()
/*      */   {
/*  165 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  169 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  173 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  177 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  181 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  185 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getIcon() {
/*  189 */     return this.icon;
/*      */   }
/*      */ 
/*      */   public void setIcon(String aIcon) {
/*  193 */     this.icon = aIcon;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  197 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  201 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  205 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  209 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  213 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  217 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  221 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  225 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  229 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  233 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  237 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  239 */       Integer tInteger = new Integer(aIF01);
/*  240 */       int i = tInteger.intValue();
/*  241 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  247 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  251 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  255 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  257 */       Double tDouble = new Double(aDF02);
/*  258 */       double d = tDouble.doubleValue();
/*  259 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  265 */     if (this.date01 != null) {
/*  266 */       return this.fDate.getString(this.date01);
/*      */     }
/*  268 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  272 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  276 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  278 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  281 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  286 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  290 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  294 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  298 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  302 */     if (this.makeDate != null) {
/*  303 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  305 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  309 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  313 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  315 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  318 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  323 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  327 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  331 */     if (this.modifyDate != null) {
/*  332 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  334 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  338 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  342 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  344 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  347 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  352 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  356 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getDescription() {
/*  360 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String aDescription) {
/*  364 */     this.description = aDescription;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  368 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  372 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  376 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  380 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  384 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  388 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  392 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  396 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  400 */     if (this.makeDate2 != null) {
/*  401 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  403 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  407 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  411 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  413 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  416 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  421 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  425 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLinkBSchema aMLinkBSchema)
/*      */   {
/*  431 */     this.iD = aMLinkBSchema.getID();
/*  432 */     this.refURL = aMLinkBSchema.getRefURL();
/*  433 */     this.target = aMLinkBSchema.getTarget();
/*  434 */     this.name = aMLinkBSchema.getName();
/*  435 */     this.linkOrder = aMLinkBSchema.getLinkOrder();
/*  436 */     this.state = aMLinkBSchema.getState();
/*  437 */     this.type = aMLinkBSchema.getType();
/*  438 */     this.agentCode = aMLinkBSchema.getAgentCode();
/*  439 */     this.icon = aMLinkBSchema.getIcon();
/*  440 */     this.manageCom = aMLinkBSchema.getManageCom();
/*  441 */     this.branchType = aMLinkBSchema.getBranchType();
/*  442 */     this.vF01 = aMLinkBSchema.getVF01();
/*  443 */     this.nF01 = aMLinkBSchema.getNF01();
/*  444 */     this.iF01 = aMLinkBSchema.getIF01();
/*  445 */     this.dF02 = aMLinkBSchema.getDF02();
/*  446 */     this.date01 = this.fDate.getDate(aMLinkBSchema.getDate01());
/*  447 */     this.modifyOperator = aMLinkBSchema.getModifyOperator();
/*  448 */     this.operator = aMLinkBSchema.getOperator();
/*  449 */     this.makeDate = this.fDate.getDate(aMLinkBSchema.getMakeDate());
/*  450 */     this.makeTime = aMLinkBSchema.getMakeTime();
/*  451 */     this.modifyDate = this.fDate.getDate(aMLinkBSchema.getModifyDate());
/*  452 */     this.modifyTime = aMLinkBSchema.getModifyTime();
/*  453 */     this.description = aMLinkBSchema.getDescription();
/*  454 */     this.edorNo = aMLinkBSchema.getEdorNo();
/*  455 */     this.edorType = aMLinkBSchema.getEdorType();
/*  456 */     this.edorCase = aMLinkBSchema.getEdorCase();
/*  457 */     this.operator2 = aMLinkBSchema.getOperator2();
/*  458 */     this.makeDate2 = this.fDate.getDate(aMLinkBSchema.getMakeDate2());
/*  459 */     this.makeTime2 = aMLinkBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  468 */       if (rs.getString("ID") == null)
/*  469 */         this.iD = null;
/*      */       else {
/*  471 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  473 */       if (rs.getString("RefURL") == null)
/*  474 */         this.refURL = null;
/*      */       else {
/*  476 */         this.refURL = rs.getString("RefURL").trim();
/*      */       }
/*  478 */       if (rs.getString("Target") == null)
/*  479 */         this.target = null;
/*      */       else {
/*  481 */         this.target = rs.getString("Target").trim();
/*      */       }
/*  483 */       if (rs.getString("Name") == null)
/*  484 */         this.name = null;
/*      */       else {
/*  486 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  488 */       this.linkOrder = rs.getInt("LinkOrder");
/*  489 */       if (rs.getString("State") == null)
/*  490 */         this.state = null;
/*      */       else {
/*  492 */         this.state = rs.getString("State").trim();
/*      */       }
/*  494 */       if (rs.getString("Type") == null)
/*  495 */         this.type = null;
/*      */       else {
/*  497 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  499 */       if (rs.getString("AgentCode") == null)
/*  500 */         this.agentCode = null;
/*      */       else {
/*  502 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  504 */       if (rs.getString("Icon") == null)
/*  505 */         this.icon = null;
/*      */       else {
/*  507 */         this.icon = rs.getString("Icon").trim();
/*      */       }
/*  509 */       if (rs.getString("ManageCom") == null)
/*  510 */         this.manageCom = null;
/*      */       else {
/*  512 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  514 */       if (rs.getString("BranchType") == null)
/*  515 */         this.branchType = null;
/*      */       else {
/*  517 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  519 */       if (rs.getString("VF01") == null)
/*  520 */         this.vF01 = null;
/*      */       else {
/*  522 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  524 */       if (rs.getString("NF01") == null)
/*  525 */         this.nF01 = null;
/*      */       else {
/*  527 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  529 */       this.iF01 = rs.getInt("IF01");
/*  530 */       this.dF02 = rs.getDouble("DF02");
/*  531 */       this.date01 = rs.getDate("Date01");
/*  532 */       if (rs.getString("ModifyOperator") == null)
/*  533 */         this.modifyOperator = null;
/*      */       else {
/*  535 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  537 */       if (rs.getString("Operator") == null)
/*  538 */         this.operator = null;
/*      */       else {
/*  540 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  542 */       this.makeDate = rs.getDate("MakeDate");
/*  543 */       if (rs.getString("MakeTime") == null)
/*  544 */         this.makeTime = null;
/*      */       else {
/*  546 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  548 */       this.modifyDate = rs.getDate("ModifyDate");
/*  549 */       if (rs.getString("ModifyTime") == null)
/*  550 */         this.modifyTime = null;
/*      */       else {
/*  552 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  554 */       if (rs.getString("Description") == null)
/*  555 */         this.description = null;
/*      */       else {
/*  557 */         this.description = rs.getString("Description").trim();
/*      */       }
/*  559 */       if (rs.getString("EdorNo") == null)
/*  560 */         this.edorNo = null;
/*      */       else {
/*  562 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  564 */       if (rs.getString("EdorType") == null)
/*  565 */         this.edorType = null;
/*      */       else {
/*  567 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  569 */       if (rs.getString("EdorCase") == null)
/*  570 */         this.edorCase = null;
/*      */       else {
/*  572 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  574 */       if (rs.getString("Operator2") == null)
/*  575 */         this.operator2 = null;
/*      */       else {
/*  577 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  579 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  580 */       if (rs.getString("MakeTime2") == null)
/*  581 */         this.makeTime2 = null;
/*      */       else {
/*  583 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  588 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLinkB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  590 */       CError tError = new CError();
/*  591 */       tError.moduleName = "MLinkBSchema";
/*  592 */       tError.functionName = "setSchema";
/*  593 */       tError.errorMessage = sqle.toString();
/*  594 */       this.mErrors.addOneError(tError);
/*  595 */       return false;
/*      */     }
/*  597 */     return true;
/*      */   }
/*      */ 
/*      */   public MLinkBSchema getSchema()
/*      */   {
/*  602 */     MLinkBSchema aMLinkBSchema = new MLinkBSchema();
/*  603 */     aMLinkBSchema.setSchema(this);
/*  604 */     return aMLinkBSchema;
/*      */   }
/*      */ 
/*      */   public MLinkBDB getDB()
/*      */   {
/*  609 */     MLinkBDB aDBOper = new MLinkBDB();
/*  610 */     aDBOper.setSchema(this);
/*  611 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  618 */     StringBuffer strReturn = new StringBuffer(256);
/*  619 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  620 */     strReturn.append(StrTool.cTrim(this.refURL)); strReturn.append("|");
/*  621 */     strReturn.append(StrTool.cTrim(this.target)); strReturn.append("|");
/*  622 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  623 */     strReturn.append(ChgData.chgData(this.linkOrder)); strReturn.append("|");
/*  624 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  625 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  626 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  627 */     strReturn.append(StrTool.cTrim(this.icon)); strReturn.append("|");
/*  628 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  629 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  630 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  631 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  632 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  633 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  634 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  635 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  636 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  637 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  638 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  640 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  641 */     strReturn.append(StrTool.cTrim(this.description)); strReturn.append("|");
/*  642 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  643 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  644 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  645 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  646 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  647 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  648 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  656 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  657 */       this.refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  658 */       this.target = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  659 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  660 */       this.linkOrder = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).intValue();
/*  661 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  662 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  663 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  664 */       this.icon = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  665 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  666 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  667 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  668 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  669 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|"))).intValue();
/*  670 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|"))).doubleValue();
/*  671 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  672 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  673 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  674 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  675 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  676 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  677 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  678 */       this.description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  679 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  680 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  681 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  682 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  683 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  684 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  689 */       CError tError = new CError();
/*  690 */       tError.moduleName = "MLinkBSchema";
/*  691 */       tError.functionName = "decode";
/*  692 */       tError.errorMessage = ex.toString();
/*  693 */       this.mErrors.addOneError(tError);
/*      */ 
/*  695 */       return false;
/*      */     }
/*  697 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  703 */     String strReturn = "";
/*  704 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  708 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.refURL));
/*      */     }
/*  712 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.target));
/*      */     }
/*  716 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.linkOrder));
/*      */     }
/*  724 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  732 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/*  738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.icon));
/*      */     }
/*  740 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  744 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  752 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  760 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  768 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  776 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  778 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  780 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  782 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  784 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  786 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  790 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/*  794 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.description));
/*      */     }
/*  796 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  798 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  800 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  802 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  806 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  808 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  810 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  812 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  814 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  816 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  818 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  820 */     if (strReturn.equals(""))
/*      */     {
/*  822 */       strReturn = "null";
/*      */     }
/*      */ 
/*  825 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  832 */     String strFieldValue = "";
/*  833 */     switch (nFieldIndex) {
/*      */     case 0:
/*  835 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  836 */       break;
/*      */     case 1:
/*  838 */       strFieldValue = StrTool.GBKToUnicode(this.refURL);
/*  839 */       break;
/*      */     case 2:
/*  841 */       strFieldValue = StrTool.GBKToUnicode(this.target);
/*  842 */       break;
/*      */     case 3:
/*  844 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  845 */       break;
/*      */     case 4:
/*  847 */       strFieldValue = String.valueOf(this.linkOrder);
/*  848 */       break;
/*      */     case 5:
/*  850 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  851 */       break;
/*      */     case 6:
/*  853 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/*  854 */       break;
/*      */     case 7:
/*  856 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  857 */       break;
/*      */     case 8:
/*  859 */       strFieldValue = StrTool.GBKToUnicode(this.icon);
/*  860 */       break;
/*      */     case 9:
/*  862 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  863 */       break;
/*      */     case 10:
/*  865 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  866 */       break;
/*      */     case 11:
/*  868 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  869 */       break;
/*      */     case 12:
/*  871 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  872 */       break;
/*      */     case 13:
/*  874 */       strFieldValue = String.valueOf(this.iF01);
/*  875 */       break;
/*      */     case 14:
/*  877 */       strFieldValue = String.valueOf(this.dF02);
/*  878 */       break;
/*      */     case 15:
/*  880 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  881 */       break;
/*      */     case 16:
/*  883 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  884 */       break;
/*      */     case 17:
/*  886 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  887 */       break;
/*      */     case 18:
/*  889 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  890 */       break;
/*      */     case 19:
/*  892 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  893 */       break;
/*      */     case 20:
/*  895 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  896 */       break;
/*      */     case 21:
/*  898 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  899 */       break;
/*      */     case 22:
/*  901 */       strFieldValue = StrTool.GBKToUnicode(this.description);
/*  902 */       break;
/*      */     case 23:
/*  904 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  905 */       break;
/*      */     case 24:
/*  907 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  908 */       break;
/*      */     case 25:
/*  910 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  911 */       break;
/*      */     case 26:
/*  913 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  914 */       break;
/*      */     case 27:
/*  916 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  917 */       break;
/*      */     case 28:
/*  919 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  920 */       break;
/*      */     default:
/*  922 */       strFieldValue = "";
/*      */     }
/*  924 */     if (strFieldValue.equals("")) {
/*  925 */       strFieldValue = "null";
/*      */     }
/*  927 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  933 */     if (StrTool.cTrim(FCode).equals("")) {
/*  934 */       return false;
/*      */     }
/*  936 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  938 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  940 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  943 */         this.iD = null;
/*      */     }
/*  945 */     if (FCode.equalsIgnoreCase("refURL"))
/*      */     {
/*  947 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  949 */         this.refURL = FValue.trim();
/*      */       }
/*      */       else
/*  952 */         this.refURL = null;
/*      */     }
/*  954 */     if (FCode.equalsIgnoreCase("target"))
/*      */     {
/*  956 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  958 */         this.target = FValue.trim();
/*      */       }
/*      */       else
/*  961 */         this.target = null;
/*      */     }
/*  963 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  965 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  967 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  970 */         this.name = null;
/*      */     }
/*  972 */     if (FCode.equalsIgnoreCase("linkOrder"))
/*      */     {
/*  974 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  976 */         Integer tInteger = new Integer(FValue);
/*  977 */         int i = tInteger.intValue();
/*  978 */         this.linkOrder = i;
/*      */       }
/*      */     }
/*  981 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  983 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  985 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/*  988 */         this.state = null;
/*      */     }
/*  990 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  992 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  994 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/*  997 */         this.type = null;
/*      */     }
/*  999 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/* 1001 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1003 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/* 1006 */         this.agentCode = null;
/*      */     }
/* 1008 */     if (FCode.equalsIgnoreCase("icon"))
/*      */     {
/* 1010 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1012 */         this.icon = FValue.trim();
/*      */       }
/*      */       else
/* 1015 */         this.icon = null;
/*      */     }
/* 1017 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1019 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1021 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1024 */         this.manageCom = null;
/*      */     }
/* 1026 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1028 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1030 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1033 */         this.branchType = null;
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1039 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1042 */         this.vF01 = null;
/*      */     }
/* 1044 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1048 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1051 */         this.nF01 = null;
/*      */     }
/* 1053 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1057 */         Integer tInteger = new Integer(FValue);
/* 1058 */         int i = tInteger.intValue();
/* 1059 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1062 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1066 */         Double tDouble = new Double(FValue);
/* 1067 */         double d = tDouble.doubleValue();
/* 1068 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1071 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1075 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1078 */         this.date01 = null;
/*      */     }
/* 1080 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1084 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1087 */         this.modifyOperator = null;
/*      */     }
/* 1089 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1093 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1096 */         this.operator = null;
/*      */     }
/* 1098 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1102 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1105 */         this.makeDate = null;
/*      */     }
/* 1107 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1111 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1114 */         this.makeTime = null;
/*      */     }
/* 1116 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1120 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1123 */         this.modifyDate = null;
/*      */     }
/* 1125 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1129 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1132 */         this.modifyTime = null;
/*      */     }
/* 1134 */     if (FCode.equalsIgnoreCase("description"))
/*      */     {
/* 1136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1138 */         this.description = FValue.trim();
/*      */       }
/*      */       else
/* 1141 */         this.description = null;
/*      */     }
/* 1143 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1147 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1150 */         this.edorNo = null;
/*      */     }
/* 1152 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1156 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1159 */         this.edorType = null;
/*      */     }
/* 1161 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1165 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1168 */         this.edorCase = null;
/*      */     }
/* 1170 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1174 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1177 */         this.operator2 = null;
/*      */     }
/* 1179 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1181 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1183 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1186 */         this.makeDate2 = null;
/*      */     }
/* 1188 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1190 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1192 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1195 */         this.makeTime2 = null;
/*      */     }
/* 1197 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1202 */     if (otherObject == null) return false;
/* 1203 */     if (this == otherObject) return true;
/* 1204 */     if (getClass() != otherObject.getClass()) return false;
/* 1205 */     MLinkBSchema other = (MLinkBSchema)otherObject;
/* 1206 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1207 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1208 */     if ((this.refURL == null) && (other.getRefURL() != null)) return false;
/* 1209 */     if ((this.refURL != null) && (!this.refURL.equals(other.getRefURL()))) return false;
/* 1210 */     if ((this.target == null) && (other.getTarget() != null)) return false;
/* 1211 */     if ((this.target != null) && (!this.target.equals(other.getTarget()))) return false;
/* 1212 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1213 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1214 */     if (this.linkOrder != other.getLinkOrder()) return false;
/* 1215 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1216 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1217 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1218 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1219 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/* 1220 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/* 1221 */     if ((this.icon == null) && (other.getIcon() != null)) return false;
/* 1222 */     if ((this.icon != null) && (!this.icon.equals(other.getIcon()))) return false;
/* 1223 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1224 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1225 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1226 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1227 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1228 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1229 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1230 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1231 */     if (this.iF01 != other.getIF01()) return false;
/* 1232 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1233 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1234 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1235 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1236 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1237 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1238 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1239 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1240 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1241 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1242 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1243 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1244 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1245 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1246 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1247 */     if ((this.description == null) && (other.getDescription() != null)) return false;
/* 1248 */     if ((this.description != null) && (!this.description.equals(other.getDescription()))) return false;
/* 1249 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1250 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1251 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1252 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1253 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1254 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1255 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1256 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1257 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1258 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1259 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1260 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1267 */     return 29;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1273 */     if (strFieldName.equals("iD")) {
/* 1274 */       return 0;
/*      */     }
/* 1276 */     if (strFieldName.equals("refURL")) {
/* 1277 */       return 1;
/*      */     }
/* 1279 */     if (strFieldName.equals("target")) {
/* 1280 */       return 2;
/*      */     }
/* 1282 */     if (strFieldName.equals("name")) {
/* 1283 */       return 3;
/*      */     }
/* 1285 */     if (strFieldName.equals("linkOrder")) {
/* 1286 */       return 4;
/*      */     }
/* 1288 */     if (strFieldName.equals("state")) {
/* 1289 */       return 5;
/*      */     }
/* 1291 */     if (strFieldName.equals("type")) {
/* 1292 */       return 6;
/*      */     }
/* 1294 */     if (strFieldName.equals("agentCode")) {
/* 1295 */       return 7;
/*      */     }
/* 1297 */     if (strFieldName.equals("icon")) {
/* 1298 */       return 8;
/*      */     }
/* 1300 */     if (strFieldName.equals("manageCom")) {
/* 1301 */       return 9;
/*      */     }
/* 1303 */     if (strFieldName.equals("branchType")) {
/* 1304 */       return 10;
/*      */     }
/* 1306 */     if (strFieldName.equals("vF01")) {
/* 1307 */       return 11;
/*      */     }
/* 1309 */     if (strFieldName.equals("nF01")) {
/* 1310 */       return 12;
/*      */     }
/* 1312 */     if (strFieldName.equals("iF01")) {
/* 1313 */       return 13;
/*      */     }
/* 1315 */     if (strFieldName.equals("dF02")) {
/* 1316 */       return 14;
/*      */     }
/* 1318 */     if (strFieldName.equals("date01")) {
/* 1319 */       return 15;
/*      */     }
/* 1321 */     if (strFieldName.equals("modifyOperator")) {
/* 1322 */       return 16;
/*      */     }
/* 1324 */     if (strFieldName.equals("operator")) {
/* 1325 */       return 17;
/*      */     }
/* 1327 */     if (strFieldName.equals("makeDate")) {
/* 1328 */       return 18;
/*      */     }
/* 1330 */     if (strFieldName.equals("makeTime")) {
/* 1331 */       return 19;
/*      */     }
/* 1333 */     if (strFieldName.equals("modifyDate")) {
/* 1334 */       return 20;
/*      */     }
/* 1336 */     if (strFieldName.equals("modifyTime")) {
/* 1337 */       return 21;
/*      */     }
/* 1339 */     if (strFieldName.equals("description")) {
/* 1340 */       return 22;
/*      */     }
/* 1342 */     if (strFieldName.equals("edorNo")) {
/* 1343 */       return 23;
/*      */     }
/* 1345 */     if (strFieldName.equals("edorType")) {
/* 1346 */       return 24;
/*      */     }
/* 1348 */     if (strFieldName.equals("edorCase")) {
/* 1349 */       return 25;
/*      */     }
/* 1351 */     if (strFieldName.equals("operator2")) {
/* 1352 */       return 26;
/*      */     }
/* 1354 */     if (strFieldName.equals("makeDate2")) {
/* 1355 */       return 27;
/*      */     }
/* 1357 */     if (strFieldName.equals("makeTime2")) {
/* 1358 */       return 28;
/*      */     }
/* 1360 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1366 */     String strFieldName = "";
/* 1367 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1369 */       strFieldName = "iD";
/* 1370 */       break;
/*      */     case 1:
/* 1372 */       strFieldName = "refURL";
/* 1373 */       break;
/*      */     case 2:
/* 1375 */       strFieldName = "target";
/* 1376 */       break;
/*      */     case 3:
/* 1378 */       strFieldName = "name";
/* 1379 */       break;
/*      */     case 4:
/* 1381 */       strFieldName = "linkOrder";
/* 1382 */       break;
/*      */     case 5:
/* 1384 */       strFieldName = "state";
/* 1385 */       break;
/*      */     case 6:
/* 1387 */       strFieldName = "type";
/* 1388 */       break;
/*      */     case 7:
/* 1390 */       strFieldName = "agentCode";
/* 1391 */       break;
/*      */     case 8:
/* 1393 */       strFieldName = "icon";
/* 1394 */       break;
/*      */     case 9:
/* 1396 */       strFieldName = "manageCom";
/* 1397 */       break;
/*      */     case 10:
/* 1399 */       strFieldName = "branchType";
/* 1400 */       break;
/*      */     case 11:
/* 1402 */       strFieldName = "vF01";
/* 1403 */       break;
/*      */     case 12:
/* 1405 */       strFieldName = "nF01";
/* 1406 */       break;
/*      */     case 13:
/* 1408 */       strFieldName = "iF01";
/* 1409 */       break;
/*      */     case 14:
/* 1411 */       strFieldName = "dF02";
/* 1412 */       break;
/*      */     case 15:
/* 1414 */       strFieldName = "date01";
/* 1415 */       break;
/*      */     case 16:
/* 1417 */       strFieldName = "modifyOperator";
/* 1418 */       break;
/*      */     case 17:
/* 1420 */       strFieldName = "operator";
/* 1421 */       break;
/*      */     case 18:
/* 1423 */       strFieldName = "makeDate";
/* 1424 */       break;
/*      */     case 19:
/* 1426 */       strFieldName = "makeTime";
/* 1427 */       break;
/*      */     case 20:
/* 1429 */       strFieldName = "modifyDate";
/* 1430 */       break;
/*      */     case 21:
/* 1432 */       strFieldName = "modifyTime";
/* 1433 */       break;
/*      */     case 22:
/* 1435 */       strFieldName = "description";
/* 1436 */       break;
/*      */     case 23:
/* 1438 */       strFieldName = "edorNo";
/* 1439 */       break;
/*      */     case 24:
/* 1441 */       strFieldName = "edorType";
/* 1442 */       break;
/*      */     case 25:
/* 1444 */       strFieldName = "edorCase";
/* 1445 */       break;
/*      */     case 26:
/* 1447 */       strFieldName = "operator2";
/* 1448 */       break;
/*      */     case 27:
/* 1450 */       strFieldName = "makeDate2";
/* 1451 */       break;
/*      */     case 28:
/* 1453 */       strFieldName = "makeTime2";
/* 1454 */       break;
/*      */     default:
/* 1456 */       strFieldName = "";
/*      */     }
/* 1458 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1464 */     if (strFieldName.equals("iD")) {
/* 1465 */       return 0;
/*      */     }
/* 1467 */     if (strFieldName.equals("refURL")) {
/* 1468 */       return 0;
/*      */     }
/* 1470 */     if (strFieldName.equals("target")) {
/* 1471 */       return 0;
/*      */     }
/* 1473 */     if (strFieldName.equals("name")) {
/* 1474 */       return 0;
/*      */     }
/* 1476 */     if (strFieldName.equals("linkOrder")) {
/* 1477 */       return 3;
/*      */     }
/* 1479 */     if (strFieldName.equals("state")) {
/* 1480 */       return 0;
/*      */     }
/* 1482 */     if (strFieldName.equals("type")) {
/* 1483 */       return 0;
/*      */     }
/* 1485 */     if (strFieldName.equals("agentCode")) {
/* 1486 */       return 0;
/*      */     }
/* 1488 */     if (strFieldName.equals("icon")) {
/* 1489 */       return 0;
/*      */     }
/* 1491 */     if (strFieldName.equals("manageCom")) {
/* 1492 */       return 0;
/*      */     }
/* 1494 */     if (strFieldName.equals("branchType")) {
/* 1495 */       return 0;
/*      */     }
/* 1497 */     if (strFieldName.equals("vF01")) {
/* 1498 */       return 0;
/*      */     }
/* 1500 */     if (strFieldName.equals("nF01")) {
/* 1501 */       return 0;
/*      */     }
/* 1503 */     if (strFieldName.equals("iF01")) {
/* 1504 */       return 3;
/*      */     }
/* 1506 */     if (strFieldName.equals("dF02")) {
/* 1507 */       return 4;
/*      */     }
/* 1509 */     if (strFieldName.equals("date01")) {
/* 1510 */       return 1;
/*      */     }
/* 1512 */     if (strFieldName.equals("modifyOperator")) {
/* 1513 */       return 0;
/*      */     }
/* 1515 */     if (strFieldName.equals("operator")) {
/* 1516 */       return 0;
/*      */     }
/* 1518 */     if (strFieldName.equals("makeDate")) {
/* 1519 */       return 1;
/*      */     }
/* 1521 */     if (strFieldName.equals("makeTime")) {
/* 1522 */       return 0;
/*      */     }
/* 1524 */     if (strFieldName.equals("modifyDate")) {
/* 1525 */       return 1;
/*      */     }
/* 1527 */     if (strFieldName.equals("modifyTime")) {
/* 1528 */       return 0;
/*      */     }
/* 1530 */     if (strFieldName.equals("description")) {
/* 1531 */       return 0;
/*      */     }
/* 1533 */     if (strFieldName.equals("edorNo")) {
/* 1534 */       return 0;
/*      */     }
/* 1536 */     if (strFieldName.equals("edorType")) {
/* 1537 */       return 0;
/*      */     }
/* 1539 */     if (strFieldName.equals("edorCase")) {
/* 1540 */       return 0;
/*      */     }
/* 1542 */     if (strFieldName.equals("operator2")) {
/* 1543 */       return 0;
/*      */     }
/* 1545 */     if (strFieldName.equals("makeDate2")) {
/* 1546 */       return 1;
/*      */     }
/* 1548 */     if (strFieldName.equals("makeTime2")) {
/* 1549 */       return 0;
/*      */     }
/* 1551 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1557 */     int nFieldType = -1;
/* 1558 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1560 */       nFieldType = 0;
/* 1561 */       break;
/*      */     case 1:
/* 1563 */       nFieldType = 0;
/* 1564 */       break;
/*      */     case 2:
/* 1566 */       nFieldType = 0;
/* 1567 */       break;
/*      */     case 3:
/* 1569 */       nFieldType = 0;
/* 1570 */       break;
/*      */     case 4:
/* 1572 */       nFieldType = 3;
/* 1573 */       break;
/*      */     case 5:
/* 1575 */       nFieldType = 0;
/* 1576 */       break;
/*      */     case 6:
/* 1578 */       nFieldType = 0;
/* 1579 */       break;
/*      */     case 7:
/* 1581 */       nFieldType = 0;
/* 1582 */       break;
/*      */     case 8:
/* 1584 */       nFieldType = 0;
/* 1585 */       break;
/*      */     case 9:
/* 1587 */       nFieldType = 0;
/* 1588 */       break;
/*      */     case 10:
/* 1590 */       nFieldType = 0;
/* 1591 */       break;
/*      */     case 11:
/* 1593 */       nFieldType = 0;
/* 1594 */       break;
/*      */     case 12:
/* 1596 */       nFieldType = 0;
/* 1597 */       break;
/*      */     case 13:
/* 1599 */       nFieldType = 3;
/* 1600 */       break;
/*      */     case 14:
/* 1602 */       nFieldType = 4;
/* 1603 */       break;
/*      */     case 15:
/* 1605 */       nFieldType = 1;
/* 1606 */       break;
/*      */     case 16:
/* 1608 */       nFieldType = 0;
/* 1609 */       break;
/*      */     case 17:
/* 1611 */       nFieldType = 0;
/* 1612 */       break;
/*      */     case 18:
/* 1614 */       nFieldType = 1;
/* 1615 */       break;
/*      */     case 19:
/* 1617 */       nFieldType = 0;
/* 1618 */       break;
/*      */     case 20:
/* 1620 */       nFieldType = 1;
/* 1621 */       break;
/*      */     case 21:
/* 1623 */       nFieldType = 0;
/* 1624 */       break;
/*      */     case 22:
/* 1626 */       nFieldType = 0;
/* 1627 */       break;
/*      */     case 23:
/* 1629 */       nFieldType = 0;
/* 1630 */       break;
/*      */     case 24:
/* 1632 */       nFieldType = 0;
/* 1633 */       break;
/*      */     case 25:
/* 1635 */       nFieldType = 0;
/* 1636 */       break;
/*      */     case 26:
/* 1638 */       nFieldType = 0;
/* 1639 */       break;
/*      */     case 27:
/* 1641 */       nFieldType = 1;
/* 1642 */       break;
/*      */     case 28:
/* 1644 */       nFieldType = 0;
/* 1645 */       break;
/*      */     default:
/* 1647 */       nFieldType = -1;
/*      */     }
/* 1649 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLinkBSchema
 * JD-Core Version:    0.6.0
 */