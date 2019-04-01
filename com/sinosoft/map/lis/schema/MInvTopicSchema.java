/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvTopicDB;
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
/*      */ public class MInvTopicSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String topicID;
/*      */   private String topic;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String depiction;
/*      */   private String author;
/*      */   private int population;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String invType;
/*      */   private String state;
/*      */   private String invState;
/*      */   private String checkState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
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
/*      */   public static final int FIELDNUM = 28;
/*      */   private static String[] PK;
/*   80 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvTopicSchema()
/*      */   {
/*   87 */     this.mErrors = new CErrors();
/*      */ 
/*   89 */     String[] pk = new String[1];
/*   90 */     pk[0] = "TopicID";
/*      */ 
/*   92 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   99 */     MInvTopicSchema cloned = (MInvTopicSchema)super.clone();
/*  100 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  101 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  102 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  108 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getTopicID()
/*      */   {
/*  113 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  117 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getTopic() {
/*  121 */     return this.topic;
/*      */   }
/*      */ 
/*      */   public void setTopic(String aTopic) {
/*  125 */     this.topic = aTopic;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  129 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  133 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  137 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  141 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getDepiction() {
/*  145 */     return this.depiction;
/*      */   }
/*      */ 
/*      */   public void setDepiction(String aDepiction) {
/*  149 */     this.depiction = aDepiction;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  153 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  157 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public int getPopulation() {
/*  161 */     return this.population;
/*      */   }
/*      */ 
/*      */   public void setPopulation(int aPopulation) {
/*  165 */     this.population = aPopulation;
/*      */   }
/*      */ 
/*      */   public void setPopulation(String aPopulation) {
/*  169 */     if ((aPopulation != null) && (!aPopulation.equals("")))
/*      */     {
/*  171 */       Integer tInteger = new Integer(aPopulation);
/*  172 */       int i = tInteger.intValue();
/*  173 */       this.population = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  179 */     if (this.startDate != null) {
/*  180 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  182 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  186 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  190 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  192 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  195 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  200 */     if (this.endDate != null) {
/*  201 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  203 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  207 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  211 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  213 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  216 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getInvType()
/*      */   {
/*  221 */     return this.invType;
/*      */   }
/*      */ 
/*      */   public void setInvType(String aInvType) {
/*  225 */     this.invType = aInvType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  229 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  233 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getInvState() {
/*  237 */     return this.invState;
/*      */   }
/*      */ 
/*      */   public void setInvState(String aInvState) {
/*  241 */     this.invState = aInvState;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  245 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  249 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  253 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  257 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  261 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  265 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  269 */     if (this.checkDate != null) {
/*  270 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  272 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  276 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  280 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  282 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  285 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  290 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  294 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  298 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  302 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  306 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  310 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  314 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  318 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  322 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  324 */       Integer tInteger = new Integer(aIF01);
/*  325 */       int i = tInteger.intValue();
/*  326 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  332 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  336 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  340 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  342 */       Double tDouble = new Double(aDF02);
/*  343 */       double d = tDouble.doubleValue();
/*  344 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  350 */     if (this.date01 != null) {
/*  351 */       return this.fDate.getString(this.date01);
/*      */     }
/*  353 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  357 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  361 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  363 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  366 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  371 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  375 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  379 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  383 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  387 */     if (this.makeDate != null) {
/*  388 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  390 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  394 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  398 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  400 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  403 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  408 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  412 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  416 */     if (this.modifyDate != null) {
/*  417 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  419 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  423 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  427 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  429 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  432 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  437 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  441 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvTopicSchema aMInvTopicSchema)
/*      */   {
/*  447 */     this.topicID = aMInvTopicSchema.getTopicID();
/*  448 */     this.topic = aMInvTopicSchema.getTopic();
/*  449 */     this.manageCom = aMInvTopicSchema.getManageCom();
/*  450 */     this.branchType = aMInvTopicSchema.getBranchType();
/*  451 */     this.depiction = aMInvTopicSchema.getDepiction();
/*  452 */     this.author = aMInvTopicSchema.getAuthor();
/*  453 */     this.population = aMInvTopicSchema.getPopulation();
/*  454 */     this.startDate = this.fDate.getDate(aMInvTopicSchema.getStartDate());
/*  455 */     this.endDate = this.fDate.getDate(aMInvTopicSchema.getEndDate());
/*  456 */     this.invType = aMInvTopicSchema.getInvType();
/*  457 */     this.state = aMInvTopicSchema.getState();
/*  458 */     this.invState = aMInvTopicSchema.getInvState();
/*  459 */     this.checkState = aMInvTopicSchema.getCheckState();
/*  460 */     this.checkOperator = aMInvTopicSchema.getCheckOperator();
/*  461 */     this.checkReason = aMInvTopicSchema.getCheckReason();
/*  462 */     this.checkDate = this.fDate.getDate(aMInvTopicSchema.getCheckDate());
/*  463 */     this.checkTime = aMInvTopicSchema.getCheckTime();
/*  464 */     this.vF01 = aMInvTopicSchema.getVF01();
/*  465 */     this.nF01 = aMInvTopicSchema.getNF01();
/*  466 */     this.iF01 = aMInvTopicSchema.getIF01();
/*  467 */     this.dF02 = aMInvTopicSchema.getDF02();
/*  468 */     this.date01 = this.fDate.getDate(aMInvTopicSchema.getDate01());
/*  469 */     this.modifyOperator = aMInvTopicSchema.getModifyOperator();
/*  470 */     this.operator = aMInvTopicSchema.getOperator();
/*  471 */     this.makeDate = this.fDate.getDate(aMInvTopicSchema.getMakeDate());
/*  472 */     this.makeTime = aMInvTopicSchema.getMakeTime();
/*  473 */     this.modifyDate = this.fDate.getDate(aMInvTopicSchema.getModifyDate());
/*  474 */     this.modifyTime = aMInvTopicSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  483 */       if (rs.getString("TopicID") == null)
/*  484 */         this.topicID = null;
/*      */       else {
/*  486 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  488 */       if (rs.getString("Topic") == null)
/*  489 */         this.topic = null;
/*      */       else {
/*  491 */         this.topic = rs.getString("Topic").trim();
/*      */       }
/*  493 */       if (rs.getString("ManageCom") == null)
/*  494 */         this.manageCom = null;
/*      */       else {
/*  496 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  498 */       if (rs.getString("BranchType") == null)
/*  499 */         this.branchType = null;
/*      */       else {
/*  501 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  503 */       if (rs.getString("Depiction") == null)
/*  504 */         this.depiction = null;
/*      */       else {
/*  506 */         this.depiction = rs.getString("Depiction").trim();
/*      */       }
/*  508 */       if (rs.getString("Author") == null)
/*  509 */         this.author = null;
/*      */       else {
/*  511 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  513 */       this.population = rs.getInt("Population");
/*  514 */       this.startDate = rs.getDate("StartDate");
/*  515 */       this.endDate = rs.getDate("EndDate");
/*  516 */       if (rs.getString("InvType") == null)
/*  517 */         this.invType = null;
/*      */       else {
/*  519 */         this.invType = rs.getString("InvType").trim();
/*      */       }
/*  521 */       if (rs.getString("State") == null)
/*  522 */         this.state = null;
/*      */       else {
/*  524 */         this.state = rs.getString("State").trim();
/*      */       }
/*  526 */       if (rs.getString("InvState") == null)
/*  527 */         this.invState = null;
/*      */       else {
/*  529 */         this.invState = rs.getString("InvState").trim();
/*      */       }
/*  531 */       if (rs.getString("CheckState") == null)
/*  532 */         this.checkState = null;
/*      */       else {
/*  534 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  536 */       if (rs.getString("CheckOperator") == null)
/*  537 */         this.checkOperator = null;
/*      */       else {
/*  539 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  541 */       if (rs.getString("CheckReason") == null)
/*  542 */         this.checkReason = null;
/*      */       else {
/*  544 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  546 */       this.checkDate = rs.getDate("CheckDate");
/*  547 */       if (rs.getString("CheckTime") == null)
/*  548 */         this.checkTime = null;
/*      */       else {
/*  550 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  552 */       if (rs.getString("VF01") == null)
/*  553 */         this.vF01 = null;
/*      */       else {
/*  555 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  557 */       if (rs.getString("NF01") == null)
/*  558 */         this.nF01 = null;
/*      */       else {
/*  560 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  562 */       this.iF01 = rs.getInt("IF01");
/*  563 */       this.dF02 = rs.getDouble("DF02");
/*  564 */       this.date01 = rs.getDate("Date01");
/*  565 */       if (rs.getString("ModifyOperator") == null)
/*  566 */         this.modifyOperator = null;
/*      */       else {
/*  568 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  570 */       if (rs.getString("Operator") == null)
/*  571 */         this.operator = null;
/*      */       else {
/*  573 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  575 */       this.makeDate = rs.getDate("MakeDate");
/*  576 */       if (rs.getString("MakeTime") == null)
/*  577 */         this.makeTime = null;
/*      */       else {
/*  579 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  581 */       this.modifyDate = rs.getDate("ModifyDate");
/*  582 */       if (rs.getString("ModifyTime") == null)
/*  583 */         this.modifyTime = null;
/*      */       else {
/*  585 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  590 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvTopic\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  592 */       CError tError = new CError();
/*  593 */       tError.moduleName = "MInvTopicSchema";
/*  594 */       tError.functionName = "setSchema";
/*  595 */       tError.errorMessage = sqle.toString();
/*  596 */       this.mErrors.addOneError(tError);
/*  597 */       return false;
/*      */     }
/*  599 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvTopicSchema getSchema()
/*      */   {
/*  604 */     MInvTopicSchema aMInvTopicSchema = new MInvTopicSchema();
/*  605 */     aMInvTopicSchema.setSchema(this);
/*  606 */     return aMInvTopicSchema;
/*      */   }
/*      */ 
/*      */   public MInvTopicDB getDB()
/*      */   {
/*  611 */     MInvTopicDB aDBOper = new MInvTopicDB();
/*  612 */     aDBOper.setSchema(this);
/*  613 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  620 */     StringBuffer strReturn = new StringBuffer(256);
/*  621 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  622 */     strReturn.append(StrTool.cTrim(this.topic)); strReturn.append("|");
/*  623 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  624 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  625 */     strReturn.append(StrTool.cTrim(this.depiction)); strReturn.append("|");
/*  626 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  627 */     strReturn.append(ChgData.chgData(this.population)); strReturn.append("|");
/*  628 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  629 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  630 */     strReturn.append(StrTool.cTrim(this.invType)); strReturn.append("|");
/*  631 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  632 */     strReturn.append(StrTool.cTrim(this.invState)); strReturn.append("|");
/*  633 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  634 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  635 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  636 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  637 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  638 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  640 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  641 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  642 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  643 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  644 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  645 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  646 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  647 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  648 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  649 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  657 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  658 */       this.topic = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  659 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  660 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  661 */       this.depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  662 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  663 */       this.population = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  664 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  665 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  666 */       this.invType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  667 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  668 */       this.invState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  669 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  670 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  671 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  672 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  673 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  674 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  675 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  676 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/*  677 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/*  678 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  679 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  680 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  681 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  682 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  683 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  684 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  689 */       CError tError = new CError();
/*  690 */       tError.moduleName = "MInvTopicSchema";
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
/*  704 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  706 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  708 */     if (FCode.equalsIgnoreCase("topic"))
/*      */     {
/*  710 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topic));
/*      */     }
/*  712 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  714 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  716 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  718 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  722 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depiction));
/*      */     }
/*  724 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  726 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("population"))
/*      */     {
/*  730 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.population));
/*      */     }
/*  732 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  734 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  736 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  738 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  740 */     if (FCode.equalsIgnoreCase("invType"))
/*      */     {
/*  742 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.invType));
/*      */     }
/*  744 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  746 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  748 */     if (FCode.equalsIgnoreCase("invState"))
/*      */     {
/*  750 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.invState));
/*      */     }
/*  752 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  754 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  758 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  760 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  762 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  766 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  768 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  770 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  772 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  774 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  776 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  778 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  780 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  782 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  784 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  786 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  788 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  790 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  794 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  796 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  798 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  800 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  802 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  806 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  808 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  810 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  812 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  814 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  816 */     if (strReturn.equals(""))
/*      */     {
/*  818 */       strReturn = "null";
/*      */     }
/*      */ 
/*  821 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  828 */     String strFieldValue = "";
/*  829 */     switch (nFieldIndex) {
/*      */     case 0:
/*  831 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  832 */       break;
/*      */     case 1:
/*  834 */       strFieldValue = StrTool.GBKToUnicode(this.topic);
/*  835 */       break;
/*      */     case 2:
/*  837 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  838 */       break;
/*      */     case 3:
/*  840 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  841 */       break;
/*      */     case 4:
/*  843 */       strFieldValue = StrTool.GBKToUnicode(this.depiction);
/*  844 */       break;
/*      */     case 5:
/*  846 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/*  847 */       break;
/*      */     case 6:
/*  849 */       strFieldValue = String.valueOf(this.population);
/*  850 */       break;
/*      */     case 7:
/*  852 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  853 */       break;
/*      */     case 8:
/*  855 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  856 */       break;
/*      */     case 9:
/*  858 */       strFieldValue = StrTool.GBKToUnicode(this.invType);
/*  859 */       break;
/*      */     case 10:
/*  861 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  862 */       break;
/*      */     case 11:
/*  864 */       strFieldValue = StrTool.GBKToUnicode(this.invState);
/*  865 */       break;
/*      */     case 12:
/*  867 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  868 */       break;
/*      */     case 13:
/*  870 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  871 */       break;
/*      */     case 14:
/*  873 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  874 */       break;
/*      */     case 15:
/*  876 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  877 */       break;
/*      */     case 16:
/*  879 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  880 */       break;
/*      */     case 17:
/*  882 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  883 */       break;
/*      */     case 18:
/*  885 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  886 */       break;
/*      */     case 19:
/*  888 */       strFieldValue = String.valueOf(this.iF01);
/*  889 */       break;
/*      */     case 20:
/*  891 */       strFieldValue = String.valueOf(this.dF02);
/*  892 */       break;
/*      */     case 21:
/*  894 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  895 */       break;
/*      */     case 22:
/*  897 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  898 */       break;
/*      */     case 23:
/*  900 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  901 */       break;
/*      */     case 24:
/*  903 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  904 */       break;
/*      */     case 25:
/*  906 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  907 */       break;
/*      */     case 26:
/*  909 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  910 */       break;
/*      */     case 27:
/*  912 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  913 */       break;
/*      */     default:
/*  915 */       strFieldValue = "";
/*      */     }
/*  917 */     if (strFieldValue.equals("")) {
/*  918 */       strFieldValue = "null";
/*      */     }
/*  920 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  926 */     if (StrTool.cTrim(FCode).equals("")) {
/*  927 */       return false;
/*      */     }
/*  929 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  931 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  933 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/*  936 */         this.topicID = null;
/*      */     }
/*  938 */     if (FCode.equalsIgnoreCase("topic"))
/*      */     {
/*  940 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  942 */         this.topic = FValue.trim();
/*      */       }
/*      */       else
/*  945 */         this.topic = null;
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  949 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  951 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  954 */         this.manageCom = null;
/*      */     }
/*  956 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  958 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  960 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  963 */         this.branchType = null;
/*      */     }
/*  965 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  967 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  969 */         this.depiction = FValue.trim();
/*      */       }
/*      */       else
/*  972 */         this.depiction = null;
/*      */     }
/*  974 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  976 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  978 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/*  981 */         this.author = null;
/*      */     }
/*  983 */     if (FCode.equalsIgnoreCase("population"))
/*      */     {
/*  985 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  987 */         Integer tInteger = new Integer(FValue);
/*  988 */         int i = tInteger.intValue();
/*  989 */         this.population = i;
/*      */       }
/*      */     }
/*  992 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  994 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  996 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  999 */         this.startDate = null;
/*      */     }
/* 1001 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1003 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1005 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1008 */         this.endDate = null;
/*      */     }
/* 1010 */     if (FCode.equalsIgnoreCase("invType"))
/*      */     {
/* 1012 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1014 */         this.invType = FValue.trim();
/*      */       }
/*      */       else
/* 1017 */         this.invType = null;
/*      */     }
/* 1019 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1021 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1023 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1026 */         this.state = null;
/*      */     }
/* 1028 */     if (FCode.equalsIgnoreCase("invState"))
/*      */     {
/* 1030 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1032 */         this.invState = FValue.trim();
/*      */       }
/*      */       else
/* 1035 */         this.invState = null;
/*      */     }
/* 1037 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1039 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1041 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1044 */         this.checkState = null;
/*      */     }
/* 1046 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1048 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1050 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1053 */         this.checkOperator = null;
/*      */     }
/* 1055 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1057 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1059 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1062 */         this.checkReason = null;
/*      */     }
/* 1064 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1066 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1068 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1071 */         this.checkDate = null;
/*      */     }
/* 1073 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1075 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1077 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1080 */         this.checkTime = null;
/*      */     }
/* 1082 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1084 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1086 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1089 */         this.vF01 = null;
/*      */     }
/* 1091 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1093 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1095 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1098 */         this.nF01 = null;
/*      */     }
/* 1100 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1102 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1104 */         Integer tInteger = new Integer(FValue);
/* 1105 */         int i = tInteger.intValue();
/* 1106 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1109 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1111 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1113 */         Double tDouble = new Double(FValue);
/* 1114 */         double d = tDouble.doubleValue();
/* 1115 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1118 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1120 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1122 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1125 */         this.date01 = null;
/*      */     }
/* 1127 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1129 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1131 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1134 */         this.modifyOperator = null;
/*      */     }
/* 1136 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1138 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1140 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1143 */         this.operator = null;
/*      */     }
/* 1145 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1147 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1149 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1152 */         this.makeDate = null;
/*      */     }
/* 1154 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1156 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1158 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1161 */         this.makeTime = null;
/*      */     }
/* 1163 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1165 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1167 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1170 */         this.modifyDate = null;
/*      */     }
/* 1172 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1174 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1176 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1179 */         this.modifyTime = null;
/*      */     }
/* 1181 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1186 */     if (otherObject == null) return false;
/* 1187 */     if (this == otherObject) return true;
/* 1188 */     if (getClass() != otherObject.getClass()) return false;
/* 1189 */     MInvTopicSchema other = (MInvTopicSchema)otherObject;
/* 1190 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/* 1191 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/* 1192 */     if ((this.topic == null) && (other.getTopic() != null)) return false;
/* 1193 */     if ((this.topic != null) && (!this.topic.equals(other.getTopic()))) return false;
/* 1194 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1195 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1196 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1197 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1198 */     if ((this.depiction == null) && (other.getDepiction() != null)) return false;
/* 1199 */     if ((this.depiction != null) && (!this.depiction.equals(other.getDepiction()))) return false;
/* 1200 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1201 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1202 */     if (this.population != other.getPopulation()) return false;
/* 1203 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1204 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1205 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1206 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1207 */     if ((this.invType == null) && (other.getInvType() != null)) return false;
/* 1208 */     if ((this.invType != null) && (!this.invType.equals(other.getInvType()))) return false;
/* 1209 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1210 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1211 */     if ((this.invState == null) && (other.getInvState() != null)) return false;
/* 1212 */     if ((this.invState != null) && (!this.invState.equals(other.getInvState()))) return false;
/* 1213 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1214 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1215 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1216 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1217 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1218 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1219 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1220 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1221 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1222 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1223 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1224 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1225 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1226 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1227 */     if (this.iF01 != other.getIF01()) return false;
/* 1228 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1229 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1230 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1231 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1232 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1233 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1234 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1235 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1236 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1237 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1238 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1239 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1240 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1241 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1242 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1249 */     return 28;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1255 */     if (strFieldName.equals("topicID")) {
/* 1256 */       return 0;
/*      */     }
/* 1258 */     if (strFieldName.equals("topic")) {
/* 1259 */       return 1;
/*      */     }
/* 1261 */     if (strFieldName.equals("manageCom")) {
/* 1262 */       return 2;
/*      */     }
/* 1264 */     if (strFieldName.equals("branchType")) {
/* 1265 */       return 3;
/*      */     }
/* 1267 */     if (strFieldName.equals("depiction")) {
/* 1268 */       return 4;
/*      */     }
/* 1270 */     if (strFieldName.equals("author")) {
/* 1271 */       return 5;
/*      */     }
/* 1273 */     if (strFieldName.equals("population")) {
/* 1274 */       return 6;
/*      */     }
/* 1276 */     if (strFieldName.equals("startDate")) {
/* 1277 */       return 7;
/*      */     }
/* 1279 */     if (strFieldName.equals("endDate")) {
/* 1280 */       return 8;
/*      */     }
/* 1282 */     if (strFieldName.equals("invType")) {
/* 1283 */       return 9;
/*      */     }
/* 1285 */     if (strFieldName.equals("state")) {
/* 1286 */       return 10;
/*      */     }
/* 1288 */     if (strFieldName.equals("invState")) {
/* 1289 */       return 11;
/*      */     }
/* 1291 */     if (strFieldName.equals("checkState")) {
/* 1292 */       return 12;
/*      */     }
/* 1294 */     if (strFieldName.equals("checkOperator")) {
/* 1295 */       return 13;
/*      */     }
/* 1297 */     if (strFieldName.equals("checkReason")) {
/* 1298 */       return 14;
/*      */     }
/* 1300 */     if (strFieldName.equals("checkDate")) {
/* 1301 */       return 15;
/*      */     }
/* 1303 */     if (strFieldName.equals("checkTime")) {
/* 1304 */       return 16;
/*      */     }
/* 1306 */     if (strFieldName.equals("vF01")) {
/* 1307 */       return 17;
/*      */     }
/* 1309 */     if (strFieldName.equals("nF01")) {
/* 1310 */       return 18;
/*      */     }
/* 1312 */     if (strFieldName.equals("iF01")) {
/* 1313 */       return 19;
/*      */     }
/* 1315 */     if (strFieldName.equals("dF02")) {
/* 1316 */       return 20;
/*      */     }
/* 1318 */     if (strFieldName.equals("date01")) {
/* 1319 */       return 21;
/*      */     }
/* 1321 */     if (strFieldName.equals("modifyOperator")) {
/* 1322 */       return 22;
/*      */     }
/* 1324 */     if (strFieldName.equals("operator")) {
/* 1325 */       return 23;
/*      */     }
/* 1327 */     if (strFieldName.equals("makeDate")) {
/* 1328 */       return 24;
/*      */     }
/* 1330 */     if (strFieldName.equals("makeTime")) {
/* 1331 */       return 25;
/*      */     }
/* 1333 */     if (strFieldName.equals("modifyDate")) {
/* 1334 */       return 26;
/*      */     }
/* 1336 */     if (strFieldName.equals("modifyTime")) {
/* 1337 */       return 27;
/*      */     }
/* 1339 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1345 */     String strFieldName = "";
/* 1346 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1348 */       strFieldName = "topicID";
/* 1349 */       break;
/*      */     case 1:
/* 1351 */       strFieldName = "topic";
/* 1352 */       break;
/*      */     case 2:
/* 1354 */       strFieldName = "manageCom";
/* 1355 */       break;
/*      */     case 3:
/* 1357 */       strFieldName = "branchType";
/* 1358 */       break;
/*      */     case 4:
/* 1360 */       strFieldName = "depiction";
/* 1361 */       break;
/*      */     case 5:
/* 1363 */       strFieldName = "author";
/* 1364 */       break;
/*      */     case 6:
/* 1366 */       strFieldName = "population";
/* 1367 */       break;
/*      */     case 7:
/* 1369 */       strFieldName = "startDate";
/* 1370 */       break;
/*      */     case 8:
/* 1372 */       strFieldName = "endDate";
/* 1373 */       break;
/*      */     case 9:
/* 1375 */       strFieldName = "invType";
/* 1376 */       break;
/*      */     case 10:
/* 1378 */       strFieldName = "state";
/* 1379 */       break;
/*      */     case 11:
/* 1381 */       strFieldName = "invState";
/* 1382 */       break;
/*      */     case 12:
/* 1384 */       strFieldName = "checkState";
/* 1385 */       break;
/*      */     case 13:
/* 1387 */       strFieldName = "checkOperator";
/* 1388 */       break;
/*      */     case 14:
/* 1390 */       strFieldName = "checkReason";
/* 1391 */       break;
/*      */     case 15:
/* 1393 */       strFieldName = "checkDate";
/* 1394 */       break;
/*      */     case 16:
/* 1396 */       strFieldName = "checkTime";
/* 1397 */       break;
/*      */     case 17:
/* 1399 */       strFieldName = "vF01";
/* 1400 */       break;
/*      */     case 18:
/* 1402 */       strFieldName = "nF01";
/* 1403 */       break;
/*      */     case 19:
/* 1405 */       strFieldName = "iF01";
/* 1406 */       break;
/*      */     case 20:
/* 1408 */       strFieldName = "dF02";
/* 1409 */       break;
/*      */     case 21:
/* 1411 */       strFieldName = "date01";
/* 1412 */       break;
/*      */     case 22:
/* 1414 */       strFieldName = "modifyOperator";
/* 1415 */       break;
/*      */     case 23:
/* 1417 */       strFieldName = "operator";
/* 1418 */       break;
/*      */     case 24:
/* 1420 */       strFieldName = "makeDate";
/* 1421 */       break;
/*      */     case 25:
/* 1423 */       strFieldName = "makeTime";
/* 1424 */       break;
/*      */     case 26:
/* 1426 */       strFieldName = "modifyDate";
/* 1427 */       break;
/*      */     case 27:
/* 1429 */       strFieldName = "modifyTime";
/* 1430 */       break;
/*      */     default:
/* 1432 */       strFieldName = "";
/*      */     }
/* 1434 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1440 */     if (strFieldName.equals("topicID")) {
/* 1441 */       return 0;
/*      */     }
/* 1443 */     if (strFieldName.equals("topic")) {
/* 1444 */       return 0;
/*      */     }
/* 1446 */     if (strFieldName.equals("manageCom")) {
/* 1447 */       return 0;
/*      */     }
/* 1449 */     if (strFieldName.equals("branchType")) {
/* 1450 */       return 0;
/*      */     }
/* 1452 */     if (strFieldName.equals("depiction")) {
/* 1453 */       return 0;
/*      */     }
/* 1455 */     if (strFieldName.equals("author")) {
/* 1456 */       return 0;
/*      */     }
/* 1458 */     if (strFieldName.equals("population")) {
/* 1459 */       return 3;
/*      */     }
/* 1461 */     if (strFieldName.equals("startDate")) {
/* 1462 */       return 1;
/*      */     }
/* 1464 */     if (strFieldName.equals("endDate")) {
/* 1465 */       return 1;
/*      */     }
/* 1467 */     if (strFieldName.equals("invType")) {
/* 1468 */       return 0;
/*      */     }
/* 1470 */     if (strFieldName.equals("state")) {
/* 1471 */       return 0;
/*      */     }
/* 1473 */     if (strFieldName.equals("invState")) {
/* 1474 */       return 0;
/*      */     }
/* 1476 */     if (strFieldName.equals("checkState")) {
/* 1477 */       return 0;
/*      */     }
/* 1479 */     if (strFieldName.equals("checkOperator")) {
/* 1480 */       return 0;
/*      */     }
/* 1482 */     if (strFieldName.equals("checkReason")) {
/* 1483 */       return 0;
/*      */     }
/* 1485 */     if (strFieldName.equals("checkDate")) {
/* 1486 */       return 1;
/*      */     }
/* 1488 */     if (strFieldName.equals("checkTime")) {
/* 1489 */       return 0;
/*      */     }
/* 1491 */     if (strFieldName.equals("vF01")) {
/* 1492 */       return 0;
/*      */     }
/* 1494 */     if (strFieldName.equals("nF01")) {
/* 1495 */       return 0;
/*      */     }
/* 1497 */     if (strFieldName.equals("iF01")) {
/* 1498 */       return 3;
/*      */     }
/* 1500 */     if (strFieldName.equals("dF02")) {
/* 1501 */       return 4;
/*      */     }
/* 1503 */     if (strFieldName.equals("date01")) {
/* 1504 */       return 1;
/*      */     }
/* 1506 */     if (strFieldName.equals("modifyOperator")) {
/* 1507 */       return 0;
/*      */     }
/* 1509 */     if (strFieldName.equals("operator")) {
/* 1510 */       return 0;
/*      */     }
/* 1512 */     if (strFieldName.equals("makeDate")) {
/* 1513 */       return 1;
/*      */     }
/* 1515 */     if (strFieldName.equals("makeTime")) {
/* 1516 */       return 0;
/*      */     }
/* 1518 */     if (strFieldName.equals("modifyDate")) {
/* 1519 */       return 1;
/*      */     }
/* 1521 */     if (strFieldName.equals("modifyTime")) {
/* 1522 */       return 0;
/*      */     }
/* 1524 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1530 */     int nFieldType = -1;
/* 1531 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1533 */       nFieldType = 0;
/* 1534 */       break;
/*      */     case 1:
/* 1536 */       nFieldType = 0;
/* 1537 */       break;
/*      */     case 2:
/* 1539 */       nFieldType = 0;
/* 1540 */       break;
/*      */     case 3:
/* 1542 */       nFieldType = 0;
/* 1543 */       break;
/*      */     case 4:
/* 1545 */       nFieldType = 0;
/* 1546 */       break;
/*      */     case 5:
/* 1548 */       nFieldType = 0;
/* 1549 */       break;
/*      */     case 6:
/* 1551 */       nFieldType = 3;
/* 1552 */       break;
/*      */     case 7:
/* 1554 */       nFieldType = 1;
/* 1555 */       break;
/*      */     case 8:
/* 1557 */       nFieldType = 1;
/* 1558 */       break;
/*      */     case 9:
/* 1560 */       nFieldType = 0;
/* 1561 */       break;
/*      */     case 10:
/* 1563 */       nFieldType = 0;
/* 1564 */       break;
/*      */     case 11:
/* 1566 */       nFieldType = 0;
/* 1567 */       break;
/*      */     case 12:
/* 1569 */       nFieldType = 0;
/* 1570 */       break;
/*      */     case 13:
/* 1572 */       nFieldType = 0;
/* 1573 */       break;
/*      */     case 14:
/* 1575 */       nFieldType = 0;
/* 1576 */       break;
/*      */     case 15:
/* 1578 */       nFieldType = 1;
/* 1579 */       break;
/*      */     case 16:
/* 1581 */       nFieldType = 0;
/* 1582 */       break;
/*      */     case 17:
/* 1584 */       nFieldType = 0;
/* 1585 */       break;
/*      */     case 18:
/* 1587 */       nFieldType = 0;
/* 1588 */       break;
/*      */     case 19:
/* 1590 */       nFieldType = 3;
/* 1591 */       break;
/*      */     case 20:
/* 1593 */       nFieldType = 4;
/* 1594 */       break;
/*      */     case 21:
/* 1596 */       nFieldType = 1;
/* 1597 */       break;
/*      */     case 22:
/* 1599 */       nFieldType = 0;
/* 1600 */       break;
/*      */     case 23:
/* 1602 */       nFieldType = 0;
/* 1603 */       break;
/*      */     case 24:
/* 1605 */       nFieldType = 1;
/* 1606 */       break;
/*      */     case 25:
/* 1608 */       nFieldType = 0;
/* 1609 */       break;
/*      */     case 26:
/* 1611 */       nFieldType = 1;
/* 1612 */       break;
/*      */     case 27:
/* 1614 */       nFieldType = 0;
/* 1615 */       break;
/*      */     default:
/* 1617 */       nFieldType = -1;
/*      */     }
/* 1619 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvTopicSchema
 * JD-Core Version:    0.6.0
 */