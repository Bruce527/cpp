/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MInvTopicBDB;
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
/*      */ public class MInvTopicBSchema
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
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   public static final int FIELDNUM = 34;
/*      */   private static String[] PK;
/*   92 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MInvTopicBSchema()
/*      */   {
/*   99 */     this.mErrors = new CErrors();
/*      */ 
/*  101 */     String[] pk = new String[1];
/*  102 */     pk[0] = "EdorNo";
/*      */ 
/*  104 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  111 */     MInvTopicBSchema cloned = (MInvTopicBSchema)super.clone();
/*  112 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  113 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  114 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  120 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getTopicID()
/*      */   {
/*  125 */     return this.topicID;
/*      */   }
/*      */ 
/*      */   public void setTopicID(String aTopicID) {
/*  129 */     this.topicID = aTopicID;
/*      */   }
/*      */ 
/*      */   public String getTopic() {
/*  133 */     return this.topic;
/*      */   }
/*      */ 
/*      */   public void setTopic(String aTopic) {
/*  137 */     this.topic = aTopic;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  141 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  145 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  149 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  153 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getDepiction() {
/*  157 */     return this.depiction;
/*      */   }
/*      */ 
/*      */   public void setDepiction(String aDepiction) {
/*  161 */     this.depiction = aDepiction;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  165 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  169 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public int getPopulation() {
/*  173 */     return this.population;
/*      */   }
/*      */ 
/*      */   public void setPopulation(int aPopulation) {
/*  177 */     this.population = aPopulation;
/*      */   }
/*      */ 
/*      */   public void setPopulation(String aPopulation) {
/*  181 */     if ((aPopulation != null) && (!aPopulation.equals("")))
/*      */     {
/*  183 */       Integer tInteger = new Integer(aPopulation);
/*  184 */       int i = tInteger.intValue();
/*  185 */       this.population = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  191 */     if (this.startDate != null) {
/*  192 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  194 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  198 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  202 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  204 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  207 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  212 */     if (this.endDate != null) {
/*  213 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  215 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  219 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  223 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  225 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  228 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getInvType()
/*      */   {
/*  233 */     return this.invType;
/*      */   }
/*      */ 
/*      */   public void setInvType(String aInvType) {
/*  237 */     this.invType = aInvType;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  241 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  245 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getInvState() {
/*  249 */     return this.invState;
/*      */   }
/*      */ 
/*      */   public void setInvState(String aInvState) {
/*  253 */     this.invState = aInvState;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  257 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  261 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  265 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  269 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  273 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  277 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  281 */     if (this.checkDate != null) {
/*  282 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  284 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  288 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  292 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  294 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  297 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  302 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  306 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  310 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  314 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  318 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  322 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  326 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  330 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  334 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  336 */       Integer tInteger = new Integer(aIF01);
/*  337 */       int i = tInteger.intValue();
/*  338 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  344 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  348 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  352 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  354 */       Double tDouble = new Double(aDF02);
/*  355 */       double d = tDouble.doubleValue();
/*  356 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  362 */     if (this.date01 != null) {
/*  363 */       return this.fDate.getString(this.date01);
/*      */     }
/*  365 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  369 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  373 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  375 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  378 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  383 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  387 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  391 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  395 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  399 */     if (this.makeDate != null) {
/*  400 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  402 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  406 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  410 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  412 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  415 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  420 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  424 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  428 */     if (this.modifyDate != null) {
/*  429 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  431 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  435 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  439 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  441 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  444 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  449 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  453 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  457 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  461 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  465 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  469 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  473 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  477 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  481 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  485 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  489 */     if (this.makeDate2 != null) {
/*  490 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  492 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  496 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  500 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  502 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  505 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  510 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  514 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MInvTopicBSchema aMInvTopicBSchema)
/*      */   {
/*  520 */     this.topicID = aMInvTopicBSchema.getTopicID();
/*  521 */     this.topic = aMInvTopicBSchema.getTopic();
/*  522 */     this.manageCom = aMInvTopicBSchema.getManageCom();
/*  523 */     this.branchType = aMInvTopicBSchema.getBranchType();
/*  524 */     this.depiction = aMInvTopicBSchema.getDepiction();
/*  525 */     this.author = aMInvTopicBSchema.getAuthor();
/*  526 */     this.population = aMInvTopicBSchema.getPopulation();
/*  527 */     this.startDate = this.fDate.getDate(aMInvTopicBSchema.getStartDate());
/*  528 */     this.endDate = this.fDate.getDate(aMInvTopicBSchema.getEndDate());
/*  529 */     this.invType = aMInvTopicBSchema.getInvType();
/*  530 */     this.state = aMInvTopicBSchema.getState();
/*  531 */     this.invState = aMInvTopicBSchema.getInvState();
/*  532 */     this.checkState = aMInvTopicBSchema.getCheckState();
/*  533 */     this.checkOperator = aMInvTopicBSchema.getCheckOperator();
/*  534 */     this.checkReason = aMInvTopicBSchema.getCheckReason();
/*  535 */     this.checkDate = this.fDate.getDate(aMInvTopicBSchema.getCheckDate());
/*  536 */     this.checkTime = aMInvTopicBSchema.getCheckTime();
/*  537 */     this.vF01 = aMInvTopicBSchema.getVF01();
/*  538 */     this.nF01 = aMInvTopicBSchema.getNF01();
/*  539 */     this.iF01 = aMInvTopicBSchema.getIF01();
/*  540 */     this.dF02 = aMInvTopicBSchema.getDF02();
/*  541 */     this.date01 = this.fDate.getDate(aMInvTopicBSchema.getDate01());
/*  542 */     this.modifyOperator = aMInvTopicBSchema.getModifyOperator();
/*  543 */     this.operator = aMInvTopicBSchema.getOperator();
/*  544 */     this.makeDate = this.fDate.getDate(aMInvTopicBSchema.getMakeDate());
/*  545 */     this.makeTime = aMInvTopicBSchema.getMakeTime();
/*  546 */     this.modifyDate = this.fDate.getDate(aMInvTopicBSchema.getModifyDate());
/*  547 */     this.modifyTime = aMInvTopicBSchema.getModifyTime();
/*  548 */     this.edorNo = aMInvTopicBSchema.getEdorNo();
/*  549 */     this.edorType = aMInvTopicBSchema.getEdorType();
/*  550 */     this.edorCase = aMInvTopicBSchema.getEdorCase();
/*  551 */     this.operator2 = aMInvTopicBSchema.getOperator2();
/*  552 */     this.makeDate2 = this.fDate.getDate(aMInvTopicBSchema.getMakeDate2());
/*  553 */     this.makeTime2 = aMInvTopicBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  562 */       if (rs.getString("TopicID") == null)
/*  563 */         this.topicID = null;
/*      */       else {
/*  565 */         this.topicID = rs.getString("TopicID").trim();
/*      */       }
/*  567 */       if (rs.getString("Topic") == null)
/*  568 */         this.topic = null;
/*      */       else {
/*  570 */         this.topic = rs.getString("Topic").trim();
/*      */       }
/*  572 */       if (rs.getString("ManageCom") == null)
/*  573 */         this.manageCom = null;
/*      */       else {
/*  575 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  577 */       if (rs.getString("BranchType") == null)
/*  578 */         this.branchType = null;
/*      */       else {
/*  580 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  582 */       if (rs.getString("Depiction") == null)
/*  583 */         this.depiction = null;
/*      */       else {
/*  585 */         this.depiction = rs.getString("Depiction").trim();
/*      */       }
/*  587 */       if (rs.getString("Author") == null)
/*  588 */         this.author = null;
/*      */       else {
/*  590 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  592 */       this.population = rs.getInt("Population");
/*  593 */       this.startDate = rs.getDate("StartDate");
/*  594 */       this.endDate = rs.getDate("EndDate");
/*  595 */       if (rs.getString("InvType") == null)
/*  596 */         this.invType = null;
/*      */       else {
/*  598 */         this.invType = rs.getString("InvType").trim();
/*      */       }
/*  600 */       if (rs.getString("State") == null)
/*  601 */         this.state = null;
/*      */       else {
/*  603 */         this.state = rs.getString("State").trim();
/*      */       }
/*  605 */       if (rs.getString("InvState") == null)
/*  606 */         this.invState = null;
/*      */       else {
/*  608 */         this.invState = rs.getString("InvState").trim();
/*      */       }
/*  610 */       if (rs.getString("CheckState") == null)
/*  611 */         this.checkState = null;
/*      */       else {
/*  613 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  615 */       if (rs.getString("CheckOperator") == null)
/*  616 */         this.checkOperator = null;
/*      */       else {
/*  618 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  620 */       if (rs.getString("CheckReason") == null)
/*  621 */         this.checkReason = null;
/*      */       else {
/*  623 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  625 */       this.checkDate = rs.getDate("CheckDate");
/*  626 */       if (rs.getString("CheckTime") == null)
/*  627 */         this.checkTime = null;
/*      */       else {
/*  629 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  631 */       if (rs.getString("VF01") == null)
/*  632 */         this.vF01 = null;
/*      */       else {
/*  634 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  636 */       if (rs.getString("NF01") == null)
/*  637 */         this.nF01 = null;
/*      */       else {
/*  639 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  641 */       this.iF01 = rs.getInt("IF01");
/*  642 */       this.dF02 = rs.getDouble("DF02");
/*  643 */       this.date01 = rs.getDate("Date01");
/*  644 */       if (rs.getString("ModifyOperator") == null)
/*  645 */         this.modifyOperator = null;
/*      */       else {
/*  647 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  649 */       if (rs.getString("Operator") == null)
/*  650 */         this.operator = null;
/*      */       else {
/*  652 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  654 */       this.makeDate = rs.getDate("MakeDate");
/*  655 */       if (rs.getString("MakeTime") == null)
/*  656 */         this.makeTime = null;
/*      */       else {
/*  658 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  660 */       this.modifyDate = rs.getDate("ModifyDate");
/*  661 */       if (rs.getString("ModifyTime") == null)
/*  662 */         this.modifyTime = null;
/*      */       else {
/*  664 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  666 */       if (rs.getString("EdorNo") == null)
/*  667 */         this.edorNo = null;
/*      */       else {
/*  669 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  671 */       if (rs.getString("EdorType") == null)
/*  672 */         this.edorType = null;
/*      */       else {
/*  674 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  676 */       if (rs.getString("EdorCase") == null)
/*  677 */         this.edorCase = null;
/*      */       else {
/*  679 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  681 */       if (rs.getString("Operator2") == null)
/*  682 */         this.operator2 = null;
/*      */       else {
/*  684 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  686 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  687 */       if (rs.getString("MakeTime2") == null)
/*  688 */         this.makeTime2 = null;
/*      */       else {
/*  690 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  695 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MInvTopicB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  697 */       CError tError = new CError();
/*  698 */       tError.moduleName = "MInvTopicBSchema";
/*  699 */       tError.functionName = "setSchema";
/*  700 */       tError.errorMessage = sqle.toString();
/*  701 */       this.mErrors.addOneError(tError);
/*  702 */       return false;
/*      */     }
/*  704 */     return true;
/*      */   }
/*      */ 
/*      */   public MInvTopicBSchema getSchema()
/*      */   {
/*  709 */     MInvTopicBSchema aMInvTopicBSchema = new MInvTopicBSchema();
/*  710 */     aMInvTopicBSchema.setSchema(this);
/*  711 */     return aMInvTopicBSchema;
/*      */   }
/*      */ 
/*      */   public MInvTopicBDB getDB()
/*      */   {
/*  716 */     MInvTopicBDB aDBOper = new MInvTopicBDB();
/*  717 */     aDBOper.setSchema(this);
/*  718 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  725 */     StringBuffer strReturn = new StringBuffer(256);
/*  726 */     strReturn.append(StrTool.cTrim(this.topicID)); strReturn.append("|");
/*  727 */     strReturn.append(StrTool.cTrim(this.topic)); strReturn.append("|");
/*  728 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  729 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  730 */     strReturn.append(StrTool.cTrim(this.depiction)); strReturn.append("|");
/*  731 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  732 */     strReturn.append(ChgData.chgData(this.population)); strReturn.append("|");
/*  733 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  734 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  735 */     strReturn.append(StrTool.cTrim(this.invType)); strReturn.append("|");
/*  736 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  737 */     strReturn.append(StrTool.cTrim(this.invState)); strReturn.append("|");
/*  738 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  739 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  740 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  741 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  742 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  743 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  744 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  745 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  746 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  747 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  748 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  749 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  750 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  751 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  752 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  753 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  754 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  755 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  756 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  757 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  758 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  759 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  760 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  768 */       this.topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  769 */       this.topic = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  770 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  771 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  772 */       this.depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  773 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  774 */       this.population = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  775 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/*  776 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  777 */       this.invType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  778 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  779 */       this.invState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  780 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  781 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  782 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  783 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  784 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  785 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  786 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  787 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/*  788 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/*  789 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  790 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  791 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  792 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  793 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  794 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  795 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  796 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  797 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  798 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  799 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  800 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/*  801 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  806 */       CError tError = new CError();
/*  807 */       tError.moduleName = "MInvTopicBSchema";
/*  808 */       tError.functionName = "decode";
/*  809 */       tError.errorMessage = ex.toString();
/*  810 */       this.mErrors.addOneError(tError);
/*      */ 
/*  812 */       return false;
/*      */     }
/*  814 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  820 */     String strReturn = "";
/*  821 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/*  823 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topicID));
/*      */     }
/*  825 */     if (FCode.equalsIgnoreCase("topic"))
/*      */     {
/*  827 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.topic));
/*      */     }
/*  829 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  831 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  833 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  835 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/*  839 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.depiction));
/*      */     }
/*  841 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  843 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  845 */     if (FCode.equalsIgnoreCase("population"))
/*      */     {
/*  847 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.population));
/*      */     }
/*  849 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  851 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  853 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  855 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  857 */     if (FCode.equalsIgnoreCase("invType"))
/*      */     {
/*  859 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.invType));
/*      */     }
/*  861 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  863 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  865 */     if (FCode.equalsIgnoreCase("invState"))
/*      */     {
/*  867 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.invState));
/*      */     }
/*  869 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  871 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  873 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  875 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  877 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  879 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  881 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  883 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  885 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  887 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  889 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  891 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  893 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  895 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  897 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  899 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  901 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  903 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  905 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  907 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  909 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  911 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  913 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  915 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  917 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  919 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  921 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  923 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  925 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  927 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  929 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  931 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  933 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  935 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  937 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  939 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  943 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  945 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  947 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  949 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  951 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  953 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  955 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  957 */     if (strReturn.equals(""))
/*      */     {
/*  959 */       strReturn = "null";
/*      */     }
/*      */ 
/*  962 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  969 */     String strFieldValue = "";
/*  970 */     switch (nFieldIndex) {
/*      */     case 0:
/*  972 */       strFieldValue = StrTool.GBKToUnicode(this.topicID);
/*  973 */       break;
/*      */     case 1:
/*  975 */       strFieldValue = StrTool.GBKToUnicode(this.topic);
/*  976 */       break;
/*      */     case 2:
/*  978 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  979 */       break;
/*      */     case 3:
/*  981 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  982 */       break;
/*      */     case 4:
/*  984 */       strFieldValue = StrTool.GBKToUnicode(this.depiction);
/*  985 */       break;
/*      */     case 5:
/*  987 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/*  988 */       break;
/*      */     case 6:
/*  990 */       strFieldValue = String.valueOf(this.population);
/*  991 */       break;
/*      */     case 7:
/*  993 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  994 */       break;
/*      */     case 8:
/*  996 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  997 */       break;
/*      */     case 9:
/*  999 */       strFieldValue = StrTool.GBKToUnicode(this.invType);
/* 1000 */       break;
/*      */     case 10:
/* 1002 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1003 */       break;
/*      */     case 11:
/* 1005 */       strFieldValue = StrTool.GBKToUnicode(this.invState);
/* 1006 */       break;
/*      */     case 12:
/* 1008 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/* 1009 */       break;
/*      */     case 13:
/* 1011 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/* 1012 */       break;
/*      */     case 14:
/* 1014 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/* 1015 */       break;
/*      */     case 15:
/* 1017 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/* 1018 */       break;
/*      */     case 16:
/* 1020 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/* 1021 */       break;
/*      */     case 17:
/* 1023 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/* 1024 */       break;
/*      */     case 18:
/* 1026 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/* 1027 */       break;
/*      */     case 19:
/* 1029 */       strFieldValue = String.valueOf(this.iF01);
/* 1030 */       break;
/*      */     case 20:
/* 1032 */       strFieldValue = String.valueOf(this.dF02);
/* 1033 */       break;
/*      */     case 21:
/* 1035 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/* 1036 */       break;
/*      */     case 22:
/* 1038 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1039 */       break;
/*      */     case 23:
/* 1041 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1042 */       break;
/*      */     case 24:
/* 1044 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1045 */       break;
/*      */     case 25:
/* 1047 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1048 */       break;
/*      */     case 26:
/* 1050 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1051 */       break;
/*      */     case 27:
/* 1053 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1054 */       break;
/*      */     case 28:
/* 1056 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/* 1057 */       break;
/*      */     case 29:
/* 1059 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/* 1060 */       break;
/*      */     case 30:
/* 1062 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/* 1063 */       break;
/*      */     case 31:
/* 1065 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/* 1066 */       break;
/*      */     case 32:
/* 1068 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/* 1069 */       break;
/*      */     case 33:
/* 1071 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/* 1072 */       break;
/*      */     default:
/* 1074 */       strFieldValue = "";
/*      */     }
/* 1076 */     if (strFieldValue.equals("")) {
/* 1077 */       strFieldValue = "null";
/*      */     }
/* 1079 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1085 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1086 */       return false;
/*      */     }
/* 1088 */     if (FCode.equalsIgnoreCase("topicID"))
/*      */     {
/* 1090 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1092 */         this.topicID = FValue.trim();
/*      */       }
/*      */       else
/* 1095 */         this.topicID = null;
/*      */     }
/* 1097 */     if (FCode.equalsIgnoreCase("topic"))
/*      */     {
/* 1099 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1101 */         this.topic = FValue.trim();
/*      */       }
/*      */       else
/* 1104 */         this.topic = null;
/*      */     }
/* 1106 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1108 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1110 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1113 */         this.manageCom = null;
/*      */     }
/* 1115 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1117 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1119 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1122 */         this.branchType = null;
/*      */     }
/* 1124 */     if (FCode.equalsIgnoreCase("depiction"))
/*      */     {
/* 1126 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1128 */         this.depiction = FValue.trim();
/*      */       }
/*      */       else
/* 1131 */         this.depiction = null;
/*      */     }
/* 1133 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/* 1135 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1137 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/* 1140 */         this.author = null;
/*      */     }
/* 1142 */     if (FCode.equalsIgnoreCase("population"))
/*      */     {
/* 1144 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1146 */         Integer tInteger = new Integer(FValue);
/* 1147 */         int i = tInteger.intValue();
/* 1148 */         this.population = i;
/*      */       }
/*      */     }
/* 1151 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1153 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1155 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1158 */         this.startDate = null;
/*      */     }
/* 1160 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1162 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1164 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1167 */         this.endDate = null;
/*      */     }
/* 1169 */     if (FCode.equalsIgnoreCase("invType"))
/*      */     {
/* 1171 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1173 */         this.invType = FValue.trim();
/*      */       }
/*      */       else
/* 1176 */         this.invType = null;
/*      */     }
/* 1178 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1180 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1182 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1185 */         this.state = null;
/*      */     }
/* 1187 */     if (FCode.equalsIgnoreCase("invState"))
/*      */     {
/* 1189 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1191 */         this.invState = FValue.trim();
/*      */       }
/*      */       else
/* 1194 */         this.invState = null;
/*      */     }
/* 1196 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1198 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1200 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1203 */         this.checkState = null;
/*      */     }
/* 1205 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1207 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1209 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1212 */         this.checkOperator = null;
/*      */     }
/* 1214 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1216 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1218 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1221 */         this.checkReason = null;
/*      */     }
/* 1223 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1225 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1227 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1230 */         this.checkDate = null;
/*      */     }
/* 1232 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1234 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1236 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1239 */         this.checkTime = null;
/*      */     }
/* 1241 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1243 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1245 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1248 */         this.vF01 = null;
/*      */     }
/* 1250 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1252 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1254 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1257 */         this.nF01 = null;
/*      */     }
/* 1259 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1261 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1263 */         Integer tInteger = new Integer(FValue);
/* 1264 */         int i = tInteger.intValue();
/* 1265 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1268 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1270 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1272 */         Double tDouble = new Double(FValue);
/* 1273 */         double d = tDouble.doubleValue();
/* 1274 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1277 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1279 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1281 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1284 */         this.date01 = null;
/*      */     }
/* 1286 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1288 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1290 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1293 */         this.modifyOperator = null;
/*      */     }
/* 1295 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1297 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1299 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1302 */         this.operator = null;
/*      */     }
/* 1304 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1306 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1308 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1311 */         this.makeDate = null;
/*      */     }
/* 1313 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1315 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1317 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1320 */         this.makeTime = null;
/*      */     }
/* 1322 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1324 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1326 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1329 */         this.modifyDate = null;
/*      */     }
/* 1331 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1333 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1335 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1338 */         this.modifyTime = null;
/*      */     }
/* 1340 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1342 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1344 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1347 */         this.edorNo = null;
/*      */     }
/* 1349 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1351 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1353 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1356 */         this.edorType = null;
/*      */     }
/* 1358 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1360 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1362 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1365 */         this.edorCase = null;
/*      */     }
/* 1367 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1369 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1371 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1374 */         this.operator2 = null;
/*      */     }
/* 1376 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1378 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1380 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1383 */         this.makeDate2 = null;
/*      */     }
/* 1385 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1387 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1389 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1392 */         this.makeTime2 = null;
/*      */     }
/* 1394 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1399 */     if (otherObject == null) return false;
/* 1400 */     if (this == otherObject) return true;
/* 1401 */     if (getClass() != otherObject.getClass()) return false;
/* 1402 */     MInvTopicBSchema other = (MInvTopicBSchema)otherObject;
/* 1403 */     if ((this.topicID == null) && (other.getTopicID() != null)) return false;
/* 1404 */     if ((this.topicID != null) && (!this.topicID.equals(other.getTopicID()))) return false;
/* 1405 */     if ((this.topic == null) && (other.getTopic() != null)) return false;
/* 1406 */     if ((this.topic != null) && (!this.topic.equals(other.getTopic()))) return false;
/* 1407 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1408 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1409 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1410 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1411 */     if ((this.depiction == null) && (other.getDepiction() != null)) return false;
/* 1412 */     if ((this.depiction != null) && (!this.depiction.equals(other.getDepiction()))) return false;
/* 1413 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1414 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1415 */     if (this.population != other.getPopulation()) return false;
/* 1416 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1417 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1418 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1419 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1420 */     if ((this.invType == null) && (other.getInvType() != null)) return false;
/* 1421 */     if ((this.invType != null) && (!this.invType.equals(other.getInvType()))) return false;
/* 1422 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1423 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1424 */     if ((this.invState == null) && (other.getInvState() != null)) return false;
/* 1425 */     if ((this.invState != null) && (!this.invState.equals(other.getInvState()))) return false;
/* 1426 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1427 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1428 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1429 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1430 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1431 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1432 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1433 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1434 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1435 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1436 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1437 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1438 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1439 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1440 */     if (this.iF01 != other.getIF01()) return false;
/* 1441 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1442 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1443 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1444 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1445 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1446 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1447 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1448 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1449 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1450 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1451 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1452 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1453 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1454 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1455 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1456 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1457 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1458 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1459 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1460 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1461 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1462 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1463 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1464 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1465 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1466 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1467 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1474 */     return 34;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1480 */     if (strFieldName.equals("topicID")) {
/* 1481 */       return 0;
/*      */     }
/* 1483 */     if (strFieldName.equals("topic")) {
/* 1484 */       return 1;
/*      */     }
/* 1486 */     if (strFieldName.equals("manageCom")) {
/* 1487 */       return 2;
/*      */     }
/* 1489 */     if (strFieldName.equals("branchType")) {
/* 1490 */       return 3;
/*      */     }
/* 1492 */     if (strFieldName.equals("depiction")) {
/* 1493 */       return 4;
/*      */     }
/* 1495 */     if (strFieldName.equals("author")) {
/* 1496 */       return 5;
/*      */     }
/* 1498 */     if (strFieldName.equals("population")) {
/* 1499 */       return 6;
/*      */     }
/* 1501 */     if (strFieldName.equals("startDate")) {
/* 1502 */       return 7;
/*      */     }
/* 1504 */     if (strFieldName.equals("endDate")) {
/* 1505 */       return 8;
/*      */     }
/* 1507 */     if (strFieldName.equals("invType")) {
/* 1508 */       return 9;
/*      */     }
/* 1510 */     if (strFieldName.equals("state")) {
/* 1511 */       return 10;
/*      */     }
/* 1513 */     if (strFieldName.equals("invState")) {
/* 1514 */       return 11;
/*      */     }
/* 1516 */     if (strFieldName.equals("checkState")) {
/* 1517 */       return 12;
/*      */     }
/* 1519 */     if (strFieldName.equals("checkOperator")) {
/* 1520 */       return 13;
/*      */     }
/* 1522 */     if (strFieldName.equals("checkReason")) {
/* 1523 */       return 14;
/*      */     }
/* 1525 */     if (strFieldName.equals("checkDate")) {
/* 1526 */       return 15;
/*      */     }
/* 1528 */     if (strFieldName.equals("checkTime")) {
/* 1529 */       return 16;
/*      */     }
/* 1531 */     if (strFieldName.equals("vF01")) {
/* 1532 */       return 17;
/*      */     }
/* 1534 */     if (strFieldName.equals("nF01")) {
/* 1535 */       return 18;
/*      */     }
/* 1537 */     if (strFieldName.equals("iF01")) {
/* 1538 */       return 19;
/*      */     }
/* 1540 */     if (strFieldName.equals("dF02")) {
/* 1541 */       return 20;
/*      */     }
/* 1543 */     if (strFieldName.equals("date01")) {
/* 1544 */       return 21;
/*      */     }
/* 1546 */     if (strFieldName.equals("modifyOperator")) {
/* 1547 */       return 22;
/*      */     }
/* 1549 */     if (strFieldName.equals("operator")) {
/* 1550 */       return 23;
/*      */     }
/* 1552 */     if (strFieldName.equals("makeDate")) {
/* 1553 */       return 24;
/*      */     }
/* 1555 */     if (strFieldName.equals("makeTime")) {
/* 1556 */       return 25;
/*      */     }
/* 1558 */     if (strFieldName.equals("modifyDate")) {
/* 1559 */       return 26;
/*      */     }
/* 1561 */     if (strFieldName.equals("modifyTime")) {
/* 1562 */       return 27;
/*      */     }
/* 1564 */     if (strFieldName.equals("edorNo")) {
/* 1565 */       return 28;
/*      */     }
/* 1567 */     if (strFieldName.equals("edorType")) {
/* 1568 */       return 29;
/*      */     }
/* 1570 */     if (strFieldName.equals("edorCase")) {
/* 1571 */       return 30;
/*      */     }
/* 1573 */     if (strFieldName.equals("operator2")) {
/* 1574 */       return 31;
/*      */     }
/* 1576 */     if (strFieldName.equals("makeDate2")) {
/* 1577 */       return 32;
/*      */     }
/* 1579 */     if (strFieldName.equals("makeTime2")) {
/* 1580 */       return 33;
/*      */     }
/* 1582 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1588 */     String strFieldName = "";
/* 1589 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1591 */       strFieldName = "topicID";
/* 1592 */       break;
/*      */     case 1:
/* 1594 */       strFieldName = "topic";
/* 1595 */       break;
/*      */     case 2:
/* 1597 */       strFieldName = "manageCom";
/* 1598 */       break;
/*      */     case 3:
/* 1600 */       strFieldName = "branchType";
/* 1601 */       break;
/*      */     case 4:
/* 1603 */       strFieldName = "depiction";
/* 1604 */       break;
/*      */     case 5:
/* 1606 */       strFieldName = "author";
/* 1607 */       break;
/*      */     case 6:
/* 1609 */       strFieldName = "population";
/* 1610 */       break;
/*      */     case 7:
/* 1612 */       strFieldName = "startDate";
/* 1613 */       break;
/*      */     case 8:
/* 1615 */       strFieldName = "endDate";
/* 1616 */       break;
/*      */     case 9:
/* 1618 */       strFieldName = "invType";
/* 1619 */       break;
/*      */     case 10:
/* 1621 */       strFieldName = "state";
/* 1622 */       break;
/*      */     case 11:
/* 1624 */       strFieldName = "invState";
/* 1625 */       break;
/*      */     case 12:
/* 1627 */       strFieldName = "checkState";
/* 1628 */       break;
/*      */     case 13:
/* 1630 */       strFieldName = "checkOperator";
/* 1631 */       break;
/*      */     case 14:
/* 1633 */       strFieldName = "checkReason";
/* 1634 */       break;
/*      */     case 15:
/* 1636 */       strFieldName = "checkDate";
/* 1637 */       break;
/*      */     case 16:
/* 1639 */       strFieldName = "checkTime";
/* 1640 */       break;
/*      */     case 17:
/* 1642 */       strFieldName = "vF01";
/* 1643 */       break;
/*      */     case 18:
/* 1645 */       strFieldName = "nF01";
/* 1646 */       break;
/*      */     case 19:
/* 1648 */       strFieldName = "iF01";
/* 1649 */       break;
/*      */     case 20:
/* 1651 */       strFieldName = "dF02";
/* 1652 */       break;
/*      */     case 21:
/* 1654 */       strFieldName = "date01";
/* 1655 */       break;
/*      */     case 22:
/* 1657 */       strFieldName = "modifyOperator";
/* 1658 */       break;
/*      */     case 23:
/* 1660 */       strFieldName = "operator";
/* 1661 */       break;
/*      */     case 24:
/* 1663 */       strFieldName = "makeDate";
/* 1664 */       break;
/*      */     case 25:
/* 1666 */       strFieldName = "makeTime";
/* 1667 */       break;
/*      */     case 26:
/* 1669 */       strFieldName = "modifyDate";
/* 1670 */       break;
/*      */     case 27:
/* 1672 */       strFieldName = "modifyTime";
/* 1673 */       break;
/*      */     case 28:
/* 1675 */       strFieldName = "edorNo";
/* 1676 */       break;
/*      */     case 29:
/* 1678 */       strFieldName = "edorType";
/* 1679 */       break;
/*      */     case 30:
/* 1681 */       strFieldName = "edorCase";
/* 1682 */       break;
/*      */     case 31:
/* 1684 */       strFieldName = "operator2";
/* 1685 */       break;
/*      */     case 32:
/* 1687 */       strFieldName = "makeDate2";
/* 1688 */       break;
/*      */     case 33:
/* 1690 */       strFieldName = "makeTime2";
/* 1691 */       break;
/*      */     default:
/* 1693 */       strFieldName = "";
/*      */     }
/* 1695 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1701 */     if (strFieldName.equals("topicID")) {
/* 1702 */       return 0;
/*      */     }
/* 1704 */     if (strFieldName.equals("topic")) {
/* 1705 */       return 0;
/*      */     }
/* 1707 */     if (strFieldName.equals("manageCom")) {
/* 1708 */       return 0;
/*      */     }
/* 1710 */     if (strFieldName.equals("branchType")) {
/* 1711 */       return 0;
/*      */     }
/* 1713 */     if (strFieldName.equals("depiction")) {
/* 1714 */       return 0;
/*      */     }
/* 1716 */     if (strFieldName.equals("author")) {
/* 1717 */       return 0;
/*      */     }
/* 1719 */     if (strFieldName.equals("population")) {
/* 1720 */       return 3;
/*      */     }
/* 1722 */     if (strFieldName.equals("startDate")) {
/* 1723 */       return 1;
/*      */     }
/* 1725 */     if (strFieldName.equals("endDate")) {
/* 1726 */       return 1;
/*      */     }
/* 1728 */     if (strFieldName.equals("invType")) {
/* 1729 */       return 0;
/*      */     }
/* 1731 */     if (strFieldName.equals("state")) {
/* 1732 */       return 0;
/*      */     }
/* 1734 */     if (strFieldName.equals("invState")) {
/* 1735 */       return 0;
/*      */     }
/* 1737 */     if (strFieldName.equals("checkState")) {
/* 1738 */       return 0;
/*      */     }
/* 1740 */     if (strFieldName.equals("checkOperator")) {
/* 1741 */       return 0;
/*      */     }
/* 1743 */     if (strFieldName.equals("checkReason")) {
/* 1744 */       return 0;
/*      */     }
/* 1746 */     if (strFieldName.equals("checkDate")) {
/* 1747 */       return 1;
/*      */     }
/* 1749 */     if (strFieldName.equals("checkTime")) {
/* 1750 */       return 0;
/*      */     }
/* 1752 */     if (strFieldName.equals("vF01")) {
/* 1753 */       return 0;
/*      */     }
/* 1755 */     if (strFieldName.equals("nF01")) {
/* 1756 */       return 0;
/*      */     }
/* 1758 */     if (strFieldName.equals("iF01")) {
/* 1759 */       return 3;
/*      */     }
/* 1761 */     if (strFieldName.equals("dF02")) {
/* 1762 */       return 4;
/*      */     }
/* 1764 */     if (strFieldName.equals("date01")) {
/* 1765 */       return 1;
/*      */     }
/* 1767 */     if (strFieldName.equals("modifyOperator")) {
/* 1768 */       return 0;
/*      */     }
/* 1770 */     if (strFieldName.equals("operator")) {
/* 1771 */       return 0;
/*      */     }
/* 1773 */     if (strFieldName.equals("makeDate")) {
/* 1774 */       return 1;
/*      */     }
/* 1776 */     if (strFieldName.equals("makeTime")) {
/* 1777 */       return 0;
/*      */     }
/* 1779 */     if (strFieldName.equals("modifyDate")) {
/* 1780 */       return 1;
/*      */     }
/* 1782 */     if (strFieldName.equals("modifyTime")) {
/* 1783 */       return 0;
/*      */     }
/* 1785 */     if (strFieldName.equals("edorNo")) {
/* 1786 */       return 0;
/*      */     }
/* 1788 */     if (strFieldName.equals("edorType")) {
/* 1789 */       return 0;
/*      */     }
/* 1791 */     if (strFieldName.equals("edorCase")) {
/* 1792 */       return 0;
/*      */     }
/* 1794 */     if (strFieldName.equals("operator2")) {
/* 1795 */       return 0;
/*      */     }
/* 1797 */     if (strFieldName.equals("makeDate2")) {
/* 1798 */       return 1;
/*      */     }
/* 1800 */     if (strFieldName.equals("makeTime2")) {
/* 1801 */       return 0;
/*      */     }
/* 1803 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1809 */     int nFieldType = -1;
/* 1810 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1812 */       nFieldType = 0;
/* 1813 */       break;
/*      */     case 1:
/* 1815 */       nFieldType = 0;
/* 1816 */       break;
/*      */     case 2:
/* 1818 */       nFieldType = 0;
/* 1819 */       break;
/*      */     case 3:
/* 1821 */       nFieldType = 0;
/* 1822 */       break;
/*      */     case 4:
/* 1824 */       nFieldType = 0;
/* 1825 */       break;
/*      */     case 5:
/* 1827 */       nFieldType = 0;
/* 1828 */       break;
/*      */     case 6:
/* 1830 */       nFieldType = 3;
/* 1831 */       break;
/*      */     case 7:
/* 1833 */       nFieldType = 1;
/* 1834 */       break;
/*      */     case 8:
/* 1836 */       nFieldType = 1;
/* 1837 */       break;
/*      */     case 9:
/* 1839 */       nFieldType = 0;
/* 1840 */       break;
/*      */     case 10:
/* 1842 */       nFieldType = 0;
/* 1843 */       break;
/*      */     case 11:
/* 1845 */       nFieldType = 0;
/* 1846 */       break;
/*      */     case 12:
/* 1848 */       nFieldType = 0;
/* 1849 */       break;
/*      */     case 13:
/* 1851 */       nFieldType = 0;
/* 1852 */       break;
/*      */     case 14:
/* 1854 */       nFieldType = 0;
/* 1855 */       break;
/*      */     case 15:
/* 1857 */       nFieldType = 1;
/* 1858 */       break;
/*      */     case 16:
/* 1860 */       nFieldType = 0;
/* 1861 */       break;
/*      */     case 17:
/* 1863 */       nFieldType = 0;
/* 1864 */       break;
/*      */     case 18:
/* 1866 */       nFieldType = 0;
/* 1867 */       break;
/*      */     case 19:
/* 1869 */       nFieldType = 3;
/* 1870 */       break;
/*      */     case 20:
/* 1872 */       nFieldType = 4;
/* 1873 */       break;
/*      */     case 21:
/* 1875 */       nFieldType = 1;
/* 1876 */       break;
/*      */     case 22:
/* 1878 */       nFieldType = 0;
/* 1879 */       break;
/*      */     case 23:
/* 1881 */       nFieldType = 0;
/* 1882 */       break;
/*      */     case 24:
/* 1884 */       nFieldType = 1;
/* 1885 */       break;
/*      */     case 25:
/* 1887 */       nFieldType = 0;
/* 1888 */       break;
/*      */     case 26:
/* 1890 */       nFieldType = 1;
/* 1891 */       break;
/*      */     case 27:
/* 1893 */       nFieldType = 0;
/* 1894 */       break;
/*      */     case 28:
/* 1896 */       nFieldType = 0;
/* 1897 */       break;
/*      */     case 29:
/* 1899 */       nFieldType = 0;
/* 1900 */       break;
/*      */     case 30:
/* 1902 */       nFieldType = 0;
/* 1903 */       break;
/*      */     case 31:
/* 1905 */       nFieldType = 0;
/* 1906 */       break;
/*      */     case 32:
/* 1908 */       nFieldType = 1;
/* 1909 */       break;
/*      */     case 33:
/* 1911 */       nFieldType = 0;
/* 1912 */       break;
/*      */     default:
/* 1914 */       nFieldType = -1;
/*      */     }
/* 1916 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MInvTopicBSchema
 * JD-Core Version:    0.6.0
 */