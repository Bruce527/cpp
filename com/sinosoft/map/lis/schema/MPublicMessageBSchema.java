/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MPublicMessageBDB;
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
/*      */ public class MPublicMessageBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   private String iD;
/*      */   private String receiveBranch;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String message;
/*      */   private String type;
/*      */   private String author;
/*      */   private String state;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String startTime;
/*      */   private String endTime;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String operator;
/*      */   private String modifyOperator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String checkState;
/*      */   private String checkOperator;
/*      */   private String checkReason;
/*      */   private Date checkDate;
/*      */   private String checkTime;
/*      */   public static final int FIELDNUM = 34;
/*      */   private static String[] PK;
/*   92 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MPublicMessageBSchema()
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
/*  111 */     MPublicMessageBSchema cloned = (MPublicMessageBSchema)super.clone();
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
/*      */   public String getEdorNo()
/*      */   {
/*  125 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  129 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  133 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  137 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  141 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  145 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  149 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  153 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  157 */     if (this.makeDate2 != null) {
/*  158 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  160 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  164 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  168 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  170 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  173 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  178 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  182 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public String getID() {
/*  186 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  190 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getReceiveBranch() {
/*  194 */     return this.receiveBranch;
/*      */   }
/*      */ 
/*      */   public void setReceiveBranch(String aReceiveBranch) {
/*  198 */     this.receiveBranch = aReceiveBranch;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  202 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  206 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  210 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  214 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/*  218 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String aMessage) {
/*  222 */     this.message = aMessage;
/*      */   }
/*      */ 
/*      */   public String getType() {
/*  226 */     return this.type;
/*      */   }
/*      */ 
/*      */   public void setType(String aType) {
/*  230 */     this.type = aType;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  234 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  238 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  242 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  246 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public String getStartDate() {
/*  250 */     if (this.startDate != null) {
/*  251 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  253 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  257 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  261 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  263 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  266 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  271 */     if (this.endDate != null) {
/*  272 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  274 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  278 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  282 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  284 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  287 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartTime()
/*      */   {
/*  292 */     return this.startTime;
/*      */   }
/*      */ 
/*      */   public void setStartTime(String aStartTime) {
/*  296 */     this.startTime = aStartTime;
/*      */   }
/*      */ 
/*      */   public String getEndTime() {
/*  300 */     return this.endTime;
/*      */   }
/*      */ 
/*      */   public void setEndTime(String aEndTime) {
/*  304 */     this.endTime = aEndTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  308 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  312 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  316 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  320 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  324 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  328 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  332 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  334 */       Integer tInteger = new Integer(aIF01);
/*  335 */       int i = tInteger.intValue();
/*  336 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  342 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  346 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  350 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  352 */       Double tDouble = new Double(aDF02);
/*  353 */       double d = tDouble.doubleValue();
/*  354 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  360 */     if (this.date01 != null) {
/*  361 */       return this.fDate.getString(this.date01);
/*      */     }
/*  363 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  367 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  371 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  373 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  376 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  381 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  385 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  389 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  393 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  397 */     if (this.makeDate != null) {
/*  398 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  400 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  404 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  408 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  410 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  413 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  418 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  422 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  426 */     if (this.modifyDate != null) {
/*  427 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  429 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  433 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  437 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  439 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  442 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  447 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  451 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  455 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  459 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  463 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  467 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  471 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  475 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  479 */     if (this.checkDate != null) {
/*  480 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  482 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  486 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  490 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  492 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  495 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  500 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  504 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MPublicMessageBSchema aMPublicMessageBSchema)
/*      */   {
/*  510 */     this.edorNo = aMPublicMessageBSchema.getEdorNo();
/*  511 */     this.edorType = aMPublicMessageBSchema.getEdorType();
/*  512 */     this.edorCase = aMPublicMessageBSchema.getEdorCase();
/*  513 */     this.operator2 = aMPublicMessageBSchema.getOperator2();
/*  514 */     this.makeDate2 = this.fDate.getDate(aMPublicMessageBSchema.getMakeDate2());
/*  515 */     this.makeTime2 = aMPublicMessageBSchema.getMakeTime2();
/*  516 */     this.iD = aMPublicMessageBSchema.getID();
/*  517 */     this.receiveBranch = aMPublicMessageBSchema.getReceiveBranch();
/*  518 */     this.manageCom = aMPublicMessageBSchema.getManageCom();
/*  519 */     this.branchType = aMPublicMessageBSchema.getBranchType();
/*  520 */     this.message = aMPublicMessageBSchema.getMessage();
/*  521 */     this.type = aMPublicMessageBSchema.getType();
/*  522 */     this.author = aMPublicMessageBSchema.getAuthor();
/*  523 */     this.state = aMPublicMessageBSchema.getState();
/*  524 */     this.startDate = this.fDate.getDate(aMPublicMessageBSchema.getStartDate());
/*  525 */     this.endDate = this.fDate.getDate(aMPublicMessageBSchema.getEndDate());
/*  526 */     this.startTime = aMPublicMessageBSchema.getStartTime();
/*  527 */     this.endTime = aMPublicMessageBSchema.getEndTime();
/*  528 */     this.vF01 = aMPublicMessageBSchema.getVF01();
/*  529 */     this.nF01 = aMPublicMessageBSchema.getNF01();
/*  530 */     this.iF01 = aMPublicMessageBSchema.getIF01();
/*  531 */     this.dF02 = aMPublicMessageBSchema.getDF02();
/*  532 */     this.date01 = this.fDate.getDate(aMPublicMessageBSchema.getDate01());
/*  533 */     this.operator = aMPublicMessageBSchema.getOperator();
/*  534 */     this.modifyOperator = aMPublicMessageBSchema.getModifyOperator();
/*  535 */     this.makeDate = this.fDate.getDate(aMPublicMessageBSchema.getMakeDate());
/*  536 */     this.makeTime = aMPublicMessageBSchema.getMakeTime();
/*  537 */     this.modifyDate = this.fDate.getDate(aMPublicMessageBSchema.getModifyDate());
/*  538 */     this.modifyTime = aMPublicMessageBSchema.getModifyTime();
/*  539 */     this.checkState = aMPublicMessageBSchema.getCheckState();
/*  540 */     this.checkOperator = aMPublicMessageBSchema.getCheckOperator();
/*  541 */     this.checkReason = aMPublicMessageBSchema.getCheckReason();
/*  542 */     this.checkDate = this.fDate.getDate(aMPublicMessageBSchema.getCheckDate());
/*  543 */     this.checkTime = aMPublicMessageBSchema.getCheckTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  552 */       if (rs.getString("EdorNo") == null)
/*  553 */         this.edorNo = null;
/*      */       else {
/*  555 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  557 */       if (rs.getString("EdorType") == null)
/*  558 */         this.edorType = null;
/*      */       else {
/*  560 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  562 */       if (rs.getString("EdorCase") == null)
/*  563 */         this.edorCase = null;
/*      */       else {
/*  565 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  567 */       if (rs.getString("Operator2") == null)
/*  568 */         this.operator2 = null;
/*      */       else {
/*  570 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  572 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  573 */       if (rs.getString("MakeTime2") == null)
/*  574 */         this.makeTime2 = null;
/*      */       else {
/*  576 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  578 */       if (rs.getString("ID") == null)
/*  579 */         this.iD = null;
/*      */       else {
/*  581 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  583 */       if (rs.getString("ReceiveBranch") == null)
/*  584 */         this.receiveBranch = null;
/*      */       else {
/*  586 */         this.receiveBranch = rs.getString("ReceiveBranch").trim();
/*      */       }
/*  588 */       if (rs.getString("ManageCom") == null)
/*  589 */         this.manageCom = null;
/*      */       else {
/*  591 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  593 */       if (rs.getString("BranchType") == null)
/*  594 */         this.branchType = null;
/*      */       else {
/*  596 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  598 */       if (rs.getString("Message") == null)
/*  599 */         this.message = null;
/*      */       else {
/*  601 */         this.message = rs.getString("Message").trim();
/*      */       }
/*  603 */       if (rs.getString("Type") == null)
/*  604 */         this.type = null;
/*      */       else {
/*  606 */         this.type = rs.getString("Type").trim();
/*      */       }
/*  608 */       if (rs.getString("Author") == null)
/*  609 */         this.author = null;
/*      */       else {
/*  611 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  613 */       if (rs.getString("State") == null)
/*  614 */         this.state = null;
/*      */       else {
/*  616 */         this.state = rs.getString("State").trim();
/*      */       }
/*  618 */       this.startDate = rs.getDate("StartDate");
/*  619 */       this.endDate = rs.getDate("EndDate");
/*  620 */       if (rs.getString("StartTime") == null)
/*  621 */         this.startTime = null;
/*      */       else {
/*  623 */         this.startTime = rs.getString("StartTime").trim();
/*      */       }
/*  625 */       if (rs.getString("EndTime") == null)
/*  626 */         this.endTime = null;
/*      */       else {
/*  628 */         this.endTime = rs.getString("EndTime").trim();
/*      */       }
/*  630 */       if (rs.getString("VF01") == null)
/*  631 */         this.vF01 = null;
/*      */       else {
/*  633 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  635 */       if (rs.getString("NF01") == null)
/*  636 */         this.nF01 = null;
/*      */       else {
/*  638 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  640 */       this.iF01 = rs.getInt("IF01");
/*  641 */       this.dF02 = rs.getDouble("DF02");
/*  642 */       this.date01 = rs.getDate("Date01");
/*  643 */       if (rs.getString("Operator") == null)
/*  644 */         this.operator = null;
/*      */       else {
/*  646 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  648 */       if (rs.getString("ModifyOperator") == null)
/*  649 */         this.modifyOperator = null;
/*      */       else {
/*  651 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  653 */       this.makeDate = rs.getDate("MakeDate");
/*  654 */       if (rs.getString("MakeTime") == null)
/*  655 */         this.makeTime = null;
/*      */       else {
/*  657 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  659 */       this.modifyDate = rs.getDate("ModifyDate");
/*  660 */       if (rs.getString("ModifyTime") == null)
/*  661 */         this.modifyTime = null;
/*      */       else {
/*  663 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  665 */       if (rs.getString("CheckState") == null)
/*  666 */         this.checkState = null;
/*      */       else {
/*  668 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  670 */       if (rs.getString("CheckOperator") == null)
/*  671 */         this.checkOperator = null;
/*      */       else {
/*  673 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  675 */       if (rs.getString("CheckReason") == null)
/*  676 */         this.checkReason = null;
/*      */       else {
/*  678 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  680 */       this.checkDate = rs.getDate("CheckDate");
/*  681 */       if (rs.getString("CheckTime") == null)
/*  682 */         this.checkTime = null;
/*      */       else {
/*  684 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  689 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MPublicMessageB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  691 */       CError tError = new CError();
/*  692 */       tError.moduleName = "MPublicMessageBSchema";
/*  693 */       tError.functionName = "setSchema";
/*  694 */       tError.errorMessage = sqle.toString();
/*  695 */       this.mErrors.addOneError(tError);
/*  696 */       return false;
/*      */     }
/*  698 */     return true;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBSchema getSchema()
/*      */   {
/*  703 */     MPublicMessageBSchema aMPublicMessageBSchema = new MPublicMessageBSchema();
/*  704 */     aMPublicMessageBSchema.setSchema(this);
/*  705 */     return aMPublicMessageBSchema;
/*      */   }
/*      */ 
/*      */   public MPublicMessageBDB getDB()
/*      */   {
/*  710 */     MPublicMessageBDB aDBOper = new MPublicMessageBDB();
/*  711 */     aDBOper.setSchema(this);
/*  712 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  719 */     StringBuffer strReturn = new StringBuffer(256);
/*  720 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  721 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  722 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  723 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  724 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  725 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  726 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  727 */     strReturn.append(StrTool.cTrim(this.receiveBranch)); strReturn.append("|");
/*  728 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  729 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  730 */     strReturn.append(StrTool.cTrim(this.message)); strReturn.append("|");
/*  731 */     strReturn.append(StrTool.cTrim(this.type)); strReturn.append("|");
/*  732 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  733 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  734 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  735 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  736 */     strReturn.append(StrTool.cTrim(this.startTime)); strReturn.append("|");
/*  737 */     strReturn.append(StrTool.cTrim(this.endTime)); strReturn.append("|");
/*  738 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  739 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  740 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  741 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  742 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  743 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  744 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  745 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  746 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  747 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  748 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  749 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  750 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  751 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  752 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  753 */     strReturn.append(StrTool.cTrim(this.checkTime));
/*  754 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  762 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  763 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  764 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  765 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  766 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  767 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  768 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  769 */       this.receiveBranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  770 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  771 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  772 */       this.message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  773 */       this.type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  774 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  775 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  776 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  777 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  778 */       this.startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  779 */       this.endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  780 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  781 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  782 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).intValue();
/*  783 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|"))).doubleValue();
/*  784 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  785 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  786 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  787 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  788 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  789 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  790 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  791 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  792 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  793 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  794 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/*  795 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  800 */       CError tError = new CError();
/*  801 */       tError.moduleName = "MPublicMessageBSchema";
/*  802 */       tError.functionName = "decode";
/*  803 */       tError.errorMessage = ex.toString();
/*  804 */       this.mErrors.addOneError(tError);
/*      */ 
/*  806 */       return false;
/*      */     }
/*  808 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  814 */     String strReturn = "";
/*  815 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  817 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  821 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  825 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  829 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  833 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  835 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  837 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  841 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  843 */     if (FCode.equalsIgnoreCase("receiveBranch"))
/*      */     {
/*  845 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.receiveBranch));
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  849 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  853 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/*  857 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.message));
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/*  861 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.type));
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  865 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  867 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  869 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  871 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  873 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  875 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  877 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/*  881 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startTime));
/*      */     }
/*  883 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/*  885 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endTime));
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  889 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  891 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  893 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  897 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  901 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  905 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  909 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  913 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  917 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  921 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  925 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  927 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  929 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  933 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  935 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  937 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  939 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  941 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  943 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  945 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  949 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  951 */     if (strReturn.equals(""))
/*      */     {
/*  953 */       strReturn = "null";
/*      */     }
/*      */ 
/*  956 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  963 */     String strFieldValue = "";
/*  964 */     switch (nFieldIndex) {
/*      */     case 0:
/*  966 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/*  967 */       break;
/*      */     case 1:
/*  969 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/*  970 */       break;
/*      */     case 2:
/*  972 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/*  973 */       break;
/*      */     case 3:
/*  975 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/*  976 */       break;
/*      */     case 4:
/*  978 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*  979 */       break;
/*      */     case 5:
/*  981 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/*  982 */       break;
/*      */     case 6:
/*  984 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  985 */       break;
/*      */     case 7:
/*  987 */       strFieldValue = StrTool.GBKToUnicode(this.receiveBranch);
/*  988 */       break;
/*      */     case 8:
/*  990 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  991 */       break;
/*      */     case 9:
/*  993 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  994 */       break;
/*      */     case 10:
/*  996 */       strFieldValue = StrTool.GBKToUnicode(this.message);
/*  997 */       break;
/*      */     case 11:
/*  999 */       strFieldValue = StrTool.GBKToUnicode(this.type);
/* 1000 */       break;
/*      */     case 12:
/* 1002 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/* 1003 */       break;
/*      */     case 13:
/* 1005 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1006 */       break;
/*      */     case 14:
/* 1008 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 1009 */       break;
/*      */     case 15:
/* 1011 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 1012 */       break;
/*      */     case 16:
/* 1014 */       strFieldValue = StrTool.GBKToUnicode(this.startTime);
/* 1015 */       break;
/*      */     case 17:
/* 1017 */       strFieldValue = StrTool.GBKToUnicode(this.endTime);
/* 1018 */       break;
/*      */     case 18:
/* 1020 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/* 1021 */       break;
/*      */     case 19:
/* 1023 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/* 1024 */       break;
/*      */     case 20:
/* 1026 */       strFieldValue = String.valueOf(this.iF01);
/* 1027 */       break;
/*      */     case 21:
/* 1029 */       strFieldValue = String.valueOf(this.dF02);
/* 1030 */       break;
/*      */     case 22:
/* 1032 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/* 1033 */       break;
/*      */     case 23:
/* 1035 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1036 */       break;
/*      */     case 24:
/* 1038 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1039 */       break;
/*      */     case 25:
/* 1041 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1042 */       break;
/*      */     case 26:
/* 1044 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1045 */       break;
/*      */     case 27:
/* 1047 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1048 */       break;
/*      */     case 28:
/* 1050 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1051 */       break;
/*      */     case 29:
/* 1053 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/* 1054 */       break;
/*      */     case 30:
/* 1056 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/* 1057 */       break;
/*      */     case 31:
/* 1059 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/* 1060 */       break;
/*      */     case 32:
/* 1062 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/* 1063 */       break;
/*      */     case 33:
/* 1065 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/* 1066 */       break;
/*      */     default:
/* 1068 */       strFieldValue = "";
/*      */     }
/* 1070 */     if (strFieldValue.equals("")) {
/* 1071 */       strFieldValue = "null";
/*      */     }
/* 1073 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1079 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1080 */       return false;
/*      */     }
/* 1082 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1084 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1086 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1089 */         this.edorNo = null;
/*      */     }
/* 1091 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1093 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1095 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1098 */         this.edorType = null;
/*      */     }
/* 1100 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1102 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1104 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1107 */         this.edorCase = null;
/*      */     }
/* 1109 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1111 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1113 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1116 */         this.operator2 = null;
/*      */     }
/* 1118 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1120 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1122 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1125 */         this.makeDate2 = null;
/*      */     }
/* 1127 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1129 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1131 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1134 */         this.makeTime2 = null;
/*      */     }
/* 1136 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/* 1138 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1140 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/* 1143 */         this.iD = null;
/*      */     }
/* 1145 */     if (FCode.equalsIgnoreCase("receiveBranch"))
/*      */     {
/* 1147 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1149 */         this.receiveBranch = FValue.trim();
/*      */       }
/*      */       else
/* 1152 */         this.receiveBranch = null;
/*      */     }
/* 1154 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1156 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1158 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1161 */         this.manageCom = null;
/*      */     }
/* 1163 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1165 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1167 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1170 */         this.branchType = null;
/*      */     }
/* 1172 */     if (FCode.equalsIgnoreCase("message"))
/*      */     {
/* 1174 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1176 */         this.message = FValue.trim();
/*      */       }
/*      */       else
/* 1179 */         this.message = null;
/*      */     }
/* 1181 */     if (FCode.equalsIgnoreCase("type"))
/*      */     {
/* 1183 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1185 */         this.type = FValue.trim();
/*      */       }
/*      */       else
/* 1188 */         this.type = null;
/*      */     }
/* 1190 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/* 1192 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1194 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/* 1197 */         this.author = null;
/*      */     }
/* 1199 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1201 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1203 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1206 */         this.state = null;
/*      */     }
/* 1208 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/* 1210 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1212 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1215 */         this.startDate = null;
/*      */     }
/* 1217 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/* 1219 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1221 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1224 */         this.endDate = null;
/*      */     }
/* 1226 */     if (FCode.equalsIgnoreCase("startTime"))
/*      */     {
/* 1228 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1230 */         this.startTime = FValue.trim();
/*      */       }
/*      */       else
/* 1233 */         this.startTime = null;
/*      */     }
/* 1235 */     if (FCode.equalsIgnoreCase("endTime"))
/*      */     {
/* 1237 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1239 */         this.endTime = FValue.trim();
/*      */       }
/*      */       else
/* 1242 */         this.endTime = null;
/*      */     }
/* 1244 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1246 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1248 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1251 */         this.vF01 = null;
/*      */     }
/* 1253 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1255 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1257 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1260 */         this.nF01 = null;
/*      */     }
/* 1262 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1264 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1266 */         Integer tInteger = new Integer(FValue);
/* 1267 */         int i = tInteger.intValue();
/* 1268 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1271 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1273 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1275 */         Double tDouble = new Double(FValue);
/* 1276 */         double d = tDouble.doubleValue();
/* 1277 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1280 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1282 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1284 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1287 */         this.date01 = null;
/*      */     }
/* 1289 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1291 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1293 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1296 */         this.operator = null;
/*      */     }
/* 1298 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1300 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1302 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1305 */         this.modifyOperator = null;
/*      */     }
/* 1307 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1309 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1311 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1314 */         this.makeDate = null;
/*      */     }
/* 1316 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1318 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1320 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1323 */         this.makeTime = null;
/*      */     }
/* 1325 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1327 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1329 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1332 */         this.modifyDate = null;
/*      */     }
/* 1334 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1336 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1338 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1341 */         this.modifyTime = null;
/*      */     }
/* 1343 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1345 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1347 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1350 */         this.checkState = null;
/*      */     }
/* 1352 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1354 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1356 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1359 */         this.checkOperator = null;
/*      */     }
/* 1361 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1363 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1365 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1368 */         this.checkReason = null;
/*      */     }
/* 1370 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1372 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1374 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1377 */         this.checkDate = null;
/*      */     }
/* 1379 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1381 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1383 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1386 */         this.checkTime = null;
/*      */     }
/* 1388 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1393 */     if (otherObject == null) return false;
/* 1394 */     if (this == otherObject) return true;
/* 1395 */     if (getClass() != otherObject.getClass()) return false;
/* 1396 */     MPublicMessageBSchema other = (MPublicMessageBSchema)otherObject;
/* 1397 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1398 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1399 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1400 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1401 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1402 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1403 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1404 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1405 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1406 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1407 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1408 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1409 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1410 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1411 */     if ((this.receiveBranch == null) && (other.getReceiveBranch() != null)) return false;
/* 1412 */     if ((this.receiveBranch != null) && (!this.receiveBranch.equals(other.getReceiveBranch()))) return false;
/* 1413 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1414 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1415 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1416 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1417 */     if ((this.message == null) && (other.getMessage() != null)) return false;
/* 1418 */     if ((this.message != null) && (!this.message.equals(other.getMessage()))) return false;
/* 1419 */     if ((this.type == null) && (other.getType() != null)) return false;
/* 1420 */     if ((this.type != null) && (!this.type.equals(other.getType()))) return false;
/* 1421 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1422 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1423 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1424 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/* 1425 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1426 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1427 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1428 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1429 */     if ((this.startTime == null) && (other.getStartTime() != null)) return false;
/* 1430 */     if ((this.startTime != null) && (!this.startTime.equals(other.getStartTime()))) return false;
/* 1431 */     if ((this.endTime == null) && (other.getEndTime() != null)) return false;
/* 1432 */     if ((this.endTime != null) && (!this.endTime.equals(other.getEndTime()))) return false;
/* 1433 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1434 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1435 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1436 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1437 */     if (this.iF01 != other.getIF01()) return false;
/* 1438 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1439 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1440 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1441 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1442 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1443 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1444 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1445 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1446 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1447 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1448 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1449 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1450 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1451 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1452 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1453 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1454 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1455 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1456 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1457 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1458 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1459 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1460 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1461 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1462 */     return (this.checkTime == null) || (this.checkTime.equals(other.getCheckTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1469 */     return 34;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1475 */     if (strFieldName.equals("edorNo")) {
/* 1476 */       return 0;
/*      */     }
/* 1478 */     if (strFieldName.equals("edorType")) {
/* 1479 */       return 1;
/*      */     }
/* 1481 */     if (strFieldName.equals("edorCase")) {
/* 1482 */       return 2;
/*      */     }
/* 1484 */     if (strFieldName.equals("operator2")) {
/* 1485 */       return 3;
/*      */     }
/* 1487 */     if (strFieldName.equals("makeDate2")) {
/* 1488 */       return 4;
/*      */     }
/* 1490 */     if (strFieldName.equals("makeTime2")) {
/* 1491 */       return 5;
/*      */     }
/* 1493 */     if (strFieldName.equals("iD")) {
/* 1494 */       return 6;
/*      */     }
/* 1496 */     if (strFieldName.equals("receiveBranch")) {
/* 1497 */       return 7;
/*      */     }
/* 1499 */     if (strFieldName.equals("manageCom")) {
/* 1500 */       return 8;
/*      */     }
/* 1502 */     if (strFieldName.equals("branchType")) {
/* 1503 */       return 9;
/*      */     }
/* 1505 */     if (strFieldName.equals("message")) {
/* 1506 */       return 10;
/*      */     }
/* 1508 */     if (strFieldName.equals("type")) {
/* 1509 */       return 11;
/*      */     }
/* 1511 */     if (strFieldName.equals("author")) {
/* 1512 */       return 12;
/*      */     }
/* 1514 */     if (strFieldName.equals("state")) {
/* 1515 */       return 13;
/*      */     }
/* 1517 */     if (strFieldName.equals("startDate")) {
/* 1518 */       return 14;
/*      */     }
/* 1520 */     if (strFieldName.equals("endDate")) {
/* 1521 */       return 15;
/*      */     }
/* 1523 */     if (strFieldName.equals("startTime")) {
/* 1524 */       return 16;
/*      */     }
/* 1526 */     if (strFieldName.equals("endTime")) {
/* 1527 */       return 17;
/*      */     }
/* 1529 */     if (strFieldName.equals("vF01")) {
/* 1530 */       return 18;
/*      */     }
/* 1532 */     if (strFieldName.equals("nF01")) {
/* 1533 */       return 19;
/*      */     }
/* 1535 */     if (strFieldName.equals("iF01")) {
/* 1536 */       return 20;
/*      */     }
/* 1538 */     if (strFieldName.equals("dF02")) {
/* 1539 */       return 21;
/*      */     }
/* 1541 */     if (strFieldName.equals("date01")) {
/* 1542 */       return 22;
/*      */     }
/* 1544 */     if (strFieldName.equals("operator")) {
/* 1545 */       return 23;
/*      */     }
/* 1547 */     if (strFieldName.equals("modifyOperator")) {
/* 1548 */       return 24;
/*      */     }
/* 1550 */     if (strFieldName.equals("makeDate")) {
/* 1551 */       return 25;
/*      */     }
/* 1553 */     if (strFieldName.equals("makeTime")) {
/* 1554 */       return 26;
/*      */     }
/* 1556 */     if (strFieldName.equals("modifyDate")) {
/* 1557 */       return 27;
/*      */     }
/* 1559 */     if (strFieldName.equals("modifyTime")) {
/* 1560 */       return 28;
/*      */     }
/* 1562 */     if (strFieldName.equals("checkState")) {
/* 1563 */       return 29;
/*      */     }
/* 1565 */     if (strFieldName.equals("checkOperator")) {
/* 1566 */       return 30;
/*      */     }
/* 1568 */     if (strFieldName.equals("checkReason")) {
/* 1569 */       return 31;
/*      */     }
/* 1571 */     if (strFieldName.equals("checkDate")) {
/* 1572 */       return 32;
/*      */     }
/* 1574 */     if (strFieldName.equals("checkTime")) {
/* 1575 */       return 33;
/*      */     }
/* 1577 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1583 */     String strFieldName = "";
/* 1584 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1586 */       strFieldName = "edorNo";
/* 1587 */       break;
/*      */     case 1:
/* 1589 */       strFieldName = "edorType";
/* 1590 */       break;
/*      */     case 2:
/* 1592 */       strFieldName = "edorCase";
/* 1593 */       break;
/*      */     case 3:
/* 1595 */       strFieldName = "operator2";
/* 1596 */       break;
/*      */     case 4:
/* 1598 */       strFieldName = "makeDate2";
/* 1599 */       break;
/*      */     case 5:
/* 1601 */       strFieldName = "makeTime2";
/* 1602 */       break;
/*      */     case 6:
/* 1604 */       strFieldName = "iD";
/* 1605 */       break;
/*      */     case 7:
/* 1607 */       strFieldName = "receiveBranch";
/* 1608 */       break;
/*      */     case 8:
/* 1610 */       strFieldName = "manageCom";
/* 1611 */       break;
/*      */     case 9:
/* 1613 */       strFieldName = "branchType";
/* 1614 */       break;
/*      */     case 10:
/* 1616 */       strFieldName = "message";
/* 1617 */       break;
/*      */     case 11:
/* 1619 */       strFieldName = "type";
/* 1620 */       break;
/*      */     case 12:
/* 1622 */       strFieldName = "author";
/* 1623 */       break;
/*      */     case 13:
/* 1625 */       strFieldName = "state";
/* 1626 */       break;
/*      */     case 14:
/* 1628 */       strFieldName = "startDate";
/* 1629 */       break;
/*      */     case 15:
/* 1631 */       strFieldName = "endDate";
/* 1632 */       break;
/*      */     case 16:
/* 1634 */       strFieldName = "startTime";
/* 1635 */       break;
/*      */     case 17:
/* 1637 */       strFieldName = "endTime";
/* 1638 */       break;
/*      */     case 18:
/* 1640 */       strFieldName = "vF01";
/* 1641 */       break;
/*      */     case 19:
/* 1643 */       strFieldName = "nF01";
/* 1644 */       break;
/*      */     case 20:
/* 1646 */       strFieldName = "iF01";
/* 1647 */       break;
/*      */     case 21:
/* 1649 */       strFieldName = "dF02";
/* 1650 */       break;
/*      */     case 22:
/* 1652 */       strFieldName = "date01";
/* 1653 */       break;
/*      */     case 23:
/* 1655 */       strFieldName = "operator";
/* 1656 */       break;
/*      */     case 24:
/* 1658 */       strFieldName = "modifyOperator";
/* 1659 */       break;
/*      */     case 25:
/* 1661 */       strFieldName = "makeDate";
/* 1662 */       break;
/*      */     case 26:
/* 1664 */       strFieldName = "makeTime";
/* 1665 */       break;
/*      */     case 27:
/* 1667 */       strFieldName = "modifyDate";
/* 1668 */       break;
/*      */     case 28:
/* 1670 */       strFieldName = "modifyTime";
/* 1671 */       break;
/*      */     case 29:
/* 1673 */       strFieldName = "checkState";
/* 1674 */       break;
/*      */     case 30:
/* 1676 */       strFieldName = "checkOperator";
/* 1677 */       break;
/*      */     case 31:
/* 1679 */       strFieldName = "checkReason";
/* 1680 */       break;
/*      */     case 32:
/* 1682 */       strFieldName = "checkDate";
/* 1683 */       break;
/*      */     case 33:
/* 1685 */       strFieldName = "checkTime";
/* 1686 */       break;
/*      */     default:
/* 1688 */       strFieldName = "";
/*      */     }
/* 1690 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1696 */     if (strFieldName.equals("edorNo")) {
/* 1697 */       return 0;
/*      */     }
/* 1699 */     if (strFieldName.equals("edorType")) {
/* 1700 */       return 0;
/*      */     }
/* 1702 */     if (strFieldName.equals("edorCase")) {
/* 1703 */       return 0;
/*      */     }
/* 1705 */     if (strFieldName.equals("operator2")) {
/* 1706 */       return 0;
/*      */     }
/* 1708 */     if (strFieldName.equals("makeDate2")) {
/* 1709 */       return 1;
/*      */     }
/* 1711 */     if (strFieldName.equals("makeTime2")) {
/* 1712 */       return 0;
/*      */     }
/* 1714 */     if (strFieldName.equals("iD")) {
/* 1715 */       return 0;
/*      */     }
/* 1717 */     if (strFieldName.equals("receiveBranch")) {
/* 1718 */       return 0;
/*      */     }
/* 1720 */     if (strFieldName.equals("manageCom")) {
/* 1721 */       return 0;
/*      */     }
/* 1723 */     if (strFieldName.equals("branchType")) {
/* 1724 */       return 0;
/*      */     }
/* 1726 */     if (strFieldName.equals("message")) {
/* 1727 */       return 0;
/*      */     }
/* 1729 */     if (strFieldName.equals("type")) {
/* 1730 */       return 0;
/*      */     }
/* 1732 */     if (strFieldName.equals("author")) {
/* 1733 */       return 0;
/*      */     }
/* 1735 */     if (strFieldName.equals("state")) {
/* 1736 */       return 0;
/*      */     }
/* 1738 */     if (strFieldName.equals("startDate")) {
/* 1739 */       return 1;
/*      */     }
/* 1741 */     if (strFieldName.equals("endDate")) {
/* 1742 */       return 1;
/*      */     }
/* 1744 */     if (strFieldName.equals("startTime")) {
/* 1745 */       return 0;
/*      */     }
/* 1747 */     if (strFieldName.equals("endTime")) {
/* 1748 */       return 0;
/*      */     }
/* 1750 */     if (strFieldName.equals("vF01")) {
/* 1751 */       return 0;
/*      */     }
/* 1753 */     if (strFieldName.equals("nF01")) {
/* 1754 */       return 0;
/*      */     }
/* 1756 */     if (strFieldName.equals("iF01")) {
/* 1757 */       return 3;
/*      */     }
/* 1759 */     if (strFieldName.equals("dF02")) {
/* 1760 */       return 4;
/*      */     }
/* 1762 */     if (strFieldName.equals("date01")) {
/* 1763 */       return 1;
/*      */     }
/* 1765 */     if (strFieldName.equals("operator")) {
/* 1766 */       return 0;
/*      */     }
/* 1768 */     if (strFieldName.equals("modifyOperator")) {
/* 1769 */       return 0;
/*      */     }
/* 1771 */     if (strFieldName.equals("makeDate")) {
/* 1772 */       return 1;
/*      */     }
/* 1774 */     if (strFieldName.equals("makeTime")) {
/* 1775 */       return 0;
/*      */     }
/* 1777 */     if (strFieldName.equals("modifyDate")) {
/* 1778 */       return 1;
/*      */     }
/* 1780 */     if (strFieldName.equals("modifyTime")) {
/* 1781 */       return 0;
/*      */     }
/* 1783 */     if (strFieldName.equals("checkState")) {
/* 1784 */       return 0;
/*      */     }
/* 1786 */     if (strFieldName.equals("checkOperator")) {
/* 1787 */       return 0;
/*      */     }
/* 1789 */     if (strFieldName.equals("checkReason")) {
/* 1790 */       return 0;
/*      */     }
/* 1792 */     if (strFieldName.equals("checkDate")) {
/* 1793 */       return 1;
/*      */     }
/* 1795 */     if (strFieldName.equals("checkTime")) {
/* 1796 */       return 0;
/*      */     }
/* 1798 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1804 */     int nFieldType = -1;
/* 1805 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1807 */       nFieldType = 0;
/* 1808 */       break;
/*      */     case 1:
/* 1810 */       nFieldType = 0;
/* 1811 */       break;
/*      */     case 2:
/* 1813 */       nFieldType = 0;
/* 1814 */       break;
/*      */     case 3:
/* 1816 */       nFieldType = 0;
/* 1817 */       break;
/*      */     case 4:
/* 1819 */       nFieldType = 1;
/* 1820 */       break;
/*      */     case 5:
/* 1822 */       nFieldType = 0;
/* 1823 */       break;
/*      */     case 6:
/* 1825 */       nFieldType = 0;
/* 1826 */       break;
/*      */     case 7:
/* 1828 */       nFieldType = 0;
/* 1829 */       break;
/*      */     case 8:
/* 1831 */       nFieldType = 0;
/* 1832 */       break;
/*      */     case 9:
/* 1834 */       nFieldType = 0;
/* 1835 */       break;
/*      */     case 10:
/* 1837 */       nFieldType = 0;
/* 1838 */       break;
/*      */     case 11:
/* 1840 */       nFieldType = 0;
/* 1841 */       break;
/*      */     case 12:
/* 1843 */       nFieldType = 0;
/* 1844 */       break;
/*      */     case 13:
/* 1846 */       nFieldType = 0;
/* 1847 */       break;
/*      */     case 14:
/* 1849 */       nFieldType = 1;
/* 1850 */       break;
/*      */     case 15:
/* 1852 */       nFieldType = 1;
/* 1853 */       break;
/*      */     case 16:
/* 1855 */       nFieldType = 0;
/* 1856 */       break;
/*      */     case 17:
/* 1858 */       nFieldType = 0;
/* 1859 */       break;
/*      */     case 18:
/* 1861 */       nFieldType = 0;
/* 1862 */       break;
/*      */     case 19:
/* 1864 */       nFieldType = 0;
/* 1865 */       break;
/*      */     case 20:
/* 1867 */       nFieldType = 3;
/* 1868 */       break;
/*      */     case 21:
/* 1870 */       nFieldType = 4;
/* 1871 */       break;
/*      */     case 22:
/* 1873 */       nFieldType = 1;
/* 1874 */       break;
/*      */     case 23:
/* 1876 */       nFieldType = 0;
/* 1877 */       break;
/*      */     case 24:
/* 1879 */       nFieldType = 0;
/* 1880 */       break;
/*      */     case 25:
/* 1882 */       nFieldType = 1;
/* 1883 */       break;
/*      */     case 26:
/* 1885 */       nFieldType = 0;
/* 1886 */       break;
/*      */     case 27:
/* 1888 */       nFieldType = 1;
/* 1889 */       break;
/*      */     case 28:
/* 1891 */       nFieldType = 0;
/* 1892 */       break;
/*      */     case 29:
/* 1894 */       nFieldType = 0;
/* 1895 */       break;
/*      */     case 30:
/* 1897 */       nFieldType = 0;
/* 1898 */       break;
/*      */     case 31:
/* 1900 */       nFieldType = 0;
/* 1901 */       break;
/*      */     case 32:
/* 1903 */       nFieldType = 1;
/* 1904 */       break;
/*      */     case 33:
/* 1906 */       nFieldType = 0;
/* 1907 */       break;
/*      */     default:
/* 1909 */       nFieldType = -1;
/*      */     }
/* 1911 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MPublicMessageBSchema
 * JD-Core Version:    0.6.0
 */