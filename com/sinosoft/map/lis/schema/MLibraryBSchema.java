/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLibraryBDB;
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
/*      */ public class MLibraryBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
/*      */   private String fileID;
/*      */   private String name;
/*      */   private String displayName;
/*      */   private String fileDescription;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String nodeID;
/*      */   private String fileType;
/*      */   private String filePath;
/*      */   private String documentType;
/*      */   private Date startDisplayDate;
/*      */   private Date endDisplayDate;
/*      */   private String minDisplayGrade;
/*      */   private String startDisplayTime;
/*      */   private String endDisplayTime;
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
/*      */   private String state;
/*      */   public static final int FIELDNUM = 38;
/*      */   private static String[] PK;
/*  100 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLibraryBSchema()
/*      */   {
/*  107 */     this.mErrors = new CErrors();
/*      */ 
/*  109 */     String[] pk = new String[1];
/*  110 */     pk[0] = "EdorNo";
/*      */ 
/*  112 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  119 */     MLibraryBSchema cloned = (MLibraryBSchema)super.clone();
/*  120 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  121 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  122 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  128 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  133 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  137 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  141 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  145 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  149 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  153 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  157 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  161 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  165 */     if (this.makeDate2 != null) {
/*  166 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  168 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  172 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  176 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  178 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  181 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  186 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  190 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public String getFileID() {
/*  194 */     return this.fileID;
/*      */   }
/*      */ 
/*      */   public void setFileID(String aFileID) {
/*  198 */     this.fileID = aFileID;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  202 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  206 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getDisplayName() {
/*  210 */     return this.displayName;
/*      */   }
/*      */ 
/*      */   public void setDisplayName(String aDisplayName) {
/*  214 */     this.displayName = aDisplayName;
/*      */   }
/*      */ 
/*      */   public String getFileDescription() {
/*  218 */     return this.fileDescription;
/*      */   }
/*      */ 
/*      */   public void setFileDescription(String aFileDescription) {
/*  222 */     this.fileDescription = aFileDescription;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  226 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  230 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  234 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  238 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getNodeID() {
/*  242 */     return this.nodeID;
/*      */   }
/*      */ 
/*      */   public void setNodeID(String aNodeID) {
/*  246 */     this.nodeID = aNodeID;
/*      */   }
/*      */ 
/*      */   public String getFileType() {
/*  250 */     return this.fileType;
/*      */   }
/*      */ 
/*      */   public void setFileType(String aFileType) {
/*  254 */     this.fileType = aFileType;
/*      */   }
/*      */ 
/*      */   public String getFilePath() {
/*  258 */     return this.filePath;
/*      */   }
/*      */ 
/*      */   public void setFilePath(String aFilePath) {
/*  262 */     this.filePath = aFilePath;
/*      */   }
/*      */ 
/*      */   public String getDocumentType() {
/*  266 */     return this.documentType;
/*      */   }
/*      */ 
/*      */   public void setDocumentType(String aDocumentType) {
/*  270 */     this.documentType = aDocumentType;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayDate() {
/*  274 */     if (this.startDisplayDate != null) {
/*  275 */       return this.fDate.getString(this.startDisplayDate);
/*      */     }
/*  277 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(Date aStartDisplayDate) {
/*  281 */     this.startDisplayDate = aStartDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(String aStartDisplayDate) {
/*  285 */     if ((aStartDisplayDate != null) && (!aStartDisplayDate.equals("")))
/*      */     {
/*  287 */       this.startDisplayDate = this.fDate.getDate(aStartDisplayDate);
/*      */     }
/*      */     else
/*  290 */       this.startDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayDate()
/*      */   {
/*  295 */     if (this.endDisplayDate != null) {
/*  296 */       return this.fDate.getString(this.endDisplayDate);
/*      */     }
/*  298 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(Date aEndDisplayDate) {
/*  302 */     this.endDisplayDate = aEndDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(String aEndDisplayDate) {
/*  306 */     if ((aEndDisplayDate != null) && (!aEndDisplayDate.equals("")))
/*      */     {
/*  308 */       this.endDisplayDate = this.fDate.getDate(aEndDisplayDate);
/*      */     }
/*      */     else
/*  311 */       this.endDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getMinDisplayGrade()
/*      */   {
/*  316 */     return this.minDisplayGrade;
/*      */   }
/*      */ 
/*      */   public void setMinDisplayGrade(String aMinDisplayGrade) {
/*  320 */     this.minDisplayGrade = aMinDisplayGrade;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayTime() {
/*  324 */     return this.startDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayTime(String aStartDisplayTime) {
/*  328 */     this.startDisplayTime = aStartDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayTime() {
/*  332 */     return this.endDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayTime(String aEndDisplayTime) {
/*  336 */     this.endDisplayTime = aEndDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  340 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  344 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  348 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  352 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  356 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  360 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  364 */     if (this.checkDate != null) {
/*  365 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  367 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  371 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  375 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  377 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  380 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  385 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  389 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  393 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  397 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  401 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  405 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  409 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  413 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  417 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  419 */       Integer tInteger = new Integer(aIF01);
/*  420 */       int i = tInteger.intValue();
/*  421 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  427 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  431 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  435 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  437 */       Double tDouble = new Double(aDF02);
/*  438 */       double d = tDouble.doubleValue();
/*  439 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  445 */     if (this.date01 != null) {
/*  446 */       return this.fDate.getString(this.date01);
/*      */     }
/*  448 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  452 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  456 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  458 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  461 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  466 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  470 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  474 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  478 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  482 */     if (this.makeDate != null) {
/*  483 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  485 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  489 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  493 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  495 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  498 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  503 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  507 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  511 */     if (this.modifyDate != null) {
/*  512 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  514 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  518 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  522 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  524 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  527 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  532 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  536 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  540 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  544 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLibraryBSchema aMLibraryBSchema)
/*      */   {
/*  550 */     this.edorNo = aMLibraryBSchema.getEdorNo();
/*  551 */     this.edorType = aMLibraryBSchema.getEdorType();
/*  552 */     this.edorCase = aMLibraryBSchema.getEdorCase();
/*  553 */     this.operator2 = aMLibraryBSchema.getOperator2();
/*  554 */     this.makeDate2 = this.fDate.getDate(aMLibraryBSchema.getMakeDate2());
/*  555 */     this.makeTime2 = aMLibraryBSchema.getMakeTime2();
/*  556 */     this.fileID = aMLibraryBSchema.getFileID();
/*  557 */     this.name = aMLibraryBSchema.getName();
/*  558 */     this.displayName = aMLibraryBSchema.getDisplayName();
/*  559 */     this.fileDescription = aMLibraryBSchema.getFileDescription();
/*  560 */     this.manageCom = aMLibraryBSchema.getManageCom();
/*  561 */     this.branchType = aMLibraryBSchema.getBranchType();
/*  562 */     this.nodeID = aMLibraryBSchema.getNodeID();
/*  563 */     this.fileType = aMLibraryBSchema.getFileType();
/*  564 */     this.filePath = aMLibraryBSchema.getFilePath();
/*  565 */     this.documentType = aMLibraryBSchema.getDocumentType();
/*  566 */     this.startDisplayDate = this.fDate.getDate(aMLibraryBSchema.getStartDisplayDate());
/*  567 */     this.endDisplayDate = this.fDate.getDate(aMLibraryBSchema.getEndDisplayDate());
/*  568 */     this.minDisplayGrade = aMLibraryBSchema.getMinDisplayGrade();
/*  569 */     this.startDisplayTime = aMLibraryBSchema.getStartDisplayTime();
/*  570 */     this.endDisplayTime = aMLibraryBSchema.getEndDisplayTime();
/*  571 */     this.checkState = aMLibraryBSchema.getCheckState();
/*  572 */     this.checkOperator = aMLibraryBSchema.getCheckOperator();
/*  573 */     this.checkReason = aMLibraryBSchema.getCheckReason();
/*  574 */     this.checkDate = this.fDate.getDate(aMLibraryBSchema.getCheckDate());
/*  575 */     this.checkTime = aMLibraryBSchema.getCheckTime();
/*  576 */     this.vF01 = aMLibraryBSchema.getVF01();
/*  577 */     this.nF01 = aMLibraryBSchema.getNF01();
/*  578 */     this.iF01 = aMLibraryBSchema.getIF01();
/*  579 */     this.dF02 = aMLibraryBSchema.getDF02();
/*  580 */     this.date01 = this.fDate.getDate(aMLibraryBSchema.getDate01());
/*  581 */     this.modifyOperator = aMLibraryBSchema.getModifyOperator();
/*  582 */     this.operator = aMLibraryBSchema.getOperator();
/*  583 */     this.makeDate = this.fDate.getDate(aMLibraryBSchema.getMakeDate());
/*  584 */     this.makeTime = aMLibraryBSchema.getMakeTime();
/*  585 */     this.modifyDate = this.fDate.getDate(aMLibraryBSchema.getModifyDate());
/*  586 */     this.modifyTime = aMLibraryBSchema.getModifyTime();
/*  587 */     this.state = aMLibraryBSchema.getState();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  596 */       if (rs.getString("EdorNo") == null)
/*  597 */         this.edorNo = null;
/*      */       else {
/*  599 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  601 */       if (rs.getString("EdorType") == null)
/*  602 */         this.edorType = null;
/*      */       else {
/*  604 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  606 */       if (rs.getString("EdorCase") == null)
/*  607 */         this.edorCase = null;
/*      */       else {
/*  609 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  611 */       if (rs.getString("Operator2") == null)
/*  612 */         this.operator2 = null;
/*      */       else {
/*  614 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  616 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  617 */       if (rs.getString("MakeTime2") == null)
/*  618 */         this.makeTime2 = null;
/*      */       else {
/*  620 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  622 */       if (rs.getString("FileID") == null)
/*  623 */         this.fileID = null;
/*      */       else {
/*  625 */         this.fileID = rs.getString("FileID").trim();
/*      */       }
/*  627 */       if (rs.getString("Name") == null)
/*  628 */         this.name = null;
/*      */       else {
/*  630 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  632 */       if (rs.getString("DisplayName") == null)
/*  633 */         this.displayName = null;
/*      */       else {
/*  635 */         this.displayName = rs.getString("DisplayName").trim();
/*      */       }
/*  637 */       if (rs.getString("FileDescription") == null)
/*  638 */         this.fileDescription = null;
/*      */       else {
/*  640 */         this.fileDescription = rs.getString("FileDescription").trim();
/*      */       }
/*  642 */       if (rs.getString("ManageCom") == null)
/*  643 */         this.manageCom = null;
/*      */       else {
/*  645 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  647 */       if (rs.getString("BranchType") == null)
/*  648 */         this.branchType = null;
/*      */       else {
/*  650 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  652 */       if (rs.getString("NodeID") == null)
/*  653 */         this.nodeID = null;
/*      */       else {
/*  655 */         this.nodeID = rs.getString("NodeID").trim();
/*      */       }
/*  657 */       if (rs.getString("FileType") == null)
/*  658 */         this.fileType = null;
/*      */       else {
/*  660 */         this.fileType = rs.getString("FileType").trim();
/*      */       }
/*  662 */       if (rs.getString("FilePath") == null)
/*  663 */         this.filePath = null;
/*      */       else {
/*  665 */         this.filePath = rs.getString("FilePath").trim();
/*      */       }
/*  667 */       if (rs.getString("DocumentType") == null)
/*  668 */         this.documentType = null;
/*      */       else {
/*  670 */         this.documentType = rs.getString("DocumentType").trim();
/*      */       }
/*  672 */       this.startDisplayDate = rs.getDate("StartDisplayDate");
/*  673 */       this.endDisplayDate = rs.getDate("EndDisplayDate");
/*  674 */       if (rs.getString("MinDisplayGrade") == null)
/*  675 */         this.minDisplayGrade = null;
/*      */       else {
/*  677 */         this.minDisplayGrade = rs.getString("MinDisplayGrade").trim();
/*      */       }
/*  679 */       if (rs.getString("StartDisplayTime") == null)
/*  680 */         this.startDisplayTime = null;
/*      */       else {
/*  682 */         this.startDisplayTime = rs.getString("StartDisplayTime").trim();
/*      */       }
/*  684 */       if (rs.getString("EndDisplayTime") == null)
/*  685 */         this.endDisplayTime = null;
/*      */       else {
/*  687 */         this.endDisplayTime = rs.getString("EndDisplayTime").trim();
/*      */       }
/*  689 */       if (rs.getString("CheckState") == null)
/*  690 */         this.checkState = null;
/*      */       else {
/*  692 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  694 */       if (rs.getString("CheckOperator") == null)
/*  695 */         this.checkOperator = null;
/*      */       else {
/*  697 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  699 */       if (rs.getString("CheckReason") == null)
/*  700 */         this.checkReason = null;
/*      */       else {
/*  702 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  704 */       this.checkDate = rs.getDate("CheckDate");
/*  705 */       if (rs.getString("CheckTime") == null)
/*  706 */         this.checkTime = null;
/*      */       else {
/*  708 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  710 */       if (rs.getString("VF01") == null)
/*  711 */         this.vF01 = null;
/*      */       else {
/*  713 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  715 */       if (rs.getString("NF01") == null)
/*  716 */         this.nF01 = null;
/*      */       else {
/*  718 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  720 */       this.iF01 = rs.getInt("IF01");
/*  721 */       this.dF02 = rs.getDouble("DF02");
/*  722 */       this.date01 = rs.getDate("Date01");
/*  723 */       if (rs.getString("ModifyOperator") == null)
/*  724 */         this.modifyOperator = null;
/*      */       else {
/*  726 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  728 */       if (rs.getString("Operator") == null)
/*  729 */         this.operator = null;
/*      */       else {
/*  731 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  733 */       this.makeDate = rs.getDate("MakeDate");
/*  734 */       if (rs.getString("MakeTime") == null)
/*  735 */         this.makeTime = null;
/*      */       else {
/*  737 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  739 */       this.modifyDate = rs.getDate("ModifyDate");
/*  740 */       if (rs.getString("ModifyTime") == null)
/*  741 */         this.modifyTime = null;
/*      */       else {
/*  743 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  745 */       if (rs.getString("State") == null)
/*  746 */         this.state = null;
/*      */       else {
/*  748 */         this.state = rs.getString("State").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  753 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLibraryB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  755 */       CError tError = new CError();
/*  756 */       tError.moduleName = "MLibraryBSchema";
/*  757 */       tError.functionName = "setSchema";
/*  758 */       tError.errorMessage = sqle.toString();
/*  759 */       this.mErrors.addOneError(tError);
/*  760 */       return false;
/*      */     }
/*  762 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryBSchema getSchema()
/*      */   {
/*  767 */     MLibraryBSchema aMLibraryBSchema = new MLibraryBSchema();
/*  768 */     aMLibraryBSchema.setSchema(this);
/*  769 */     return aMLibraryBSchema;
/*      */   }
/*      */ 
/*      */   public MLibraryBDB getDB()
/*      */   {
/*  774 */     MLibraryBDB aDBOper = new MLibraryBDB();
/*  775 */     aDBOper.setSchema(this);
/*  776 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  783 */     StringBuffer strReturn = new StringBuffer(256);
/*  784 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  785 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  786 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  787 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  788 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  789 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  790 */     strReturn.append(StrTool.cTrim(this.fileID)); strReturn.append("|");
/*  791 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  792 */     strReturn.append(StrTool.cTrim(this.displayName)); strReturn.append("|");
/*  793 */     strReturn.append(StrTool.cTrim(this.fileDescription)); strReturn.append("|");
/*  794 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  795 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  796 */     strReturn.append(StrTool.cTrim(this.nodeID)); strReturn.append("|");
/*  797 */     strReturn.append(StrTool.cTrim(this.fileType)); strReturn.append("|");
/*  798 */     strReturn.append(StrTool.cTrim(this.filePath)); strReturn.append("|");
/*  799 */     strReturn.append(StrTool.cTrim(this.documentType)); strReturn.append("|");
/*  800 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDisplayDate))); strReturn.append("|");
/*  801 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDisplayDate))); strReturn.append("|");
/*  802 */     strReturn.append(StrTool.cTrim(this.minDisplayGrade)); strReturn.append("|");
/*  803 */     strReturn.append(StrTool.cTrim(this.startDisplayTime)); strReturn.append("|");
/*  804 */     strReturn.append(StrTool.cTrim(this.endDisplayTime)); strReturn.append("|");
/*  805 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  806 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  807 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  808 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  809 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  810 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  811 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  812 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  813 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  814 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  815 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  816 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  817 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  818 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  819 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  820 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  821 */     strReturn.append(StrTool.cTrim(this.state));
/*  822 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  830 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  831 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  832 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  833 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  834 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  835 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  836 */       this.fileID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  837 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  838 */       this.displayName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  839 */       this.fileDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  840 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  841 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  842 */       this.nodeID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  843 */       this.fileType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  844 */       this.filePath = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  845 */       this.documentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  846 */       this.startDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  847 */       this.endDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  848 */       this.minDisplayGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  849 */       this.startDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  850 */       this.endDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  851 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  852 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  853 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  854 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  855 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  856 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  857 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  858 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).intValue();
/*  859 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).doubleValue();
/*  860 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
/*  861 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  862 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/*  863 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
/*  864 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/*  865 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
/*  866 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/*  867 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  872 */       CError tError = new CError();
/*  873 */       tError.moduleName = "MLibraryBSchema";
/*  874 */       tError.functionName = "decode";
/*  875 */       tError.errorMessage = ex.toString();
/*  876 */       this.mErrors.addOneError(tError);
/*      */ 
/*  878 */       return false;
/*      */     }
/*  880 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  886 */     String strReturn = "";
/*  887 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  889 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  891 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  893 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  897 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  901 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  905 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  909 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("fileID"))
/*      */     {
/*  913 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileID));
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  917 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("displayName"))
/*      */     {
/*  921 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.displayName));
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("fileDescription"))
/*      */     {
/*  925 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileDescription));
/*      */     }
/*  927 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  929 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  933 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  935 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/*  937 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeID));
/*      */     }
/*  939 */     if (FCode.equalsIgnoreCase("fileType"))
/*      */     {
/*  941 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileType));
/*      */     }
/*  943 */     if (FCode.equalsIgnoreCase("filePath"))
/*      */     {
/*  945 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.filePath));
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("documentType"))
/*      */     {
/*  949 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.documentType));
/*      */     }
/*  951 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/*  953 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*      */     }
/*  955 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/*  957 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*      */     }
/*  959 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/*  961 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minDisplayGrade));
/*      */     }
/*  963 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/*  965 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDisplayTime));
/*      */     }
/*  967 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/*  969 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDisplayTime));
/*      */     }
/*  971 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  973 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  975 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  977 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  979 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  981 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  983 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  985 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  987 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  989 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  991 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  993 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  995 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  997 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  999 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1001 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/* 1003 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1005 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/* 1007 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1009 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/* 1011 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1013 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/* 1015 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1017 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1019 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1021 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1023 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1025 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1027 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1029 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1031 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1033 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1037 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/* 1039 */     if (strReturn.equals(""))
/*      */     {
/* 1041 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1044 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1051 */     String strFieldValue = "";
/* 1052 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1054 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/* 1055 */       break;
/*      */     case 1:
/* 1057 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/* 1058 */       break;
/*      */     case 2:
/* 1060 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/* 1061 */       break;
/*      */     case 3:
/* 1063 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/* 1064 */       break;
/*      */     case 4:
/* 1066 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/* 1067 */       break;
/*      */     case 5:
/* 1069 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/* 1070 */       break;
/*      */     case 6:
/* 1072 */       strFieldValue = StrTool.GBKToUnicode(this.fileID);
/* 1073 */       break;
/*      */     case 7:
/* 1075 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/* 1076 */       break;
/*      */     case 8:
/* 1078 */       strFieldValue = StrTool.GBKToUnicode(this.displayName);
/* 1079 */       break;
/*      */     case 9:
/* 1081 */       strFieldValue = StrTool.GBKToUnicode(this.fileDescription);
/* 1082 */       break;
/*      */     case 10:
/* 1084 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1085 */       break;
/*      */     case 11:
/* 1087 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/* 1088 */       break;
/*      */     case 12:
/* 1090 */       strFieldValue = StrTool.GBKToUnicode(this.nodeID);
/* 1091 */       break;
/*      */     case 13:
/* 1093 */       strFieldValue = StrTool.GBKToUnicode(this.fileType);
/* 1094 */       break;
/*      */     case 14:
/* 1096 */       strFieldValue = StrTool.GBKToUnicode(this.filePath);
/* 1097 */       break;
/*      */     case 15:
/* 1099 */       strFieldValue = StrTool.GBKToUnicode(this.documentType);
/* 1100 */       break;
/*      */     case 16:
/* 1102 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/* 1103 */       break;
/*      */     case 17:
/* 1105 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/* 1106 */       break;
/*      */     case 18:
/* 1108 */       strFieldValue = StrTool.GBKToUnicode(this.minDisplayGrade);
/* 1109 */       break;
/*      */     case 19:
/* 1111 */       strFieldValue = StrTool.GBKToUnicode(this.startDisplayTime);
/* 1112 */       break;
/*      */     case 20:
/* 1114 */       strFieldValue = StrTool.GBKToUnicode(this.endDisplayTime);
/* 1115 */       break;
/*      */     case 21:
/* 1117 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/* 1118 */       break;
/*      */     case 22:
/* 1120 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/* 1121 */       break;
/*      */     case 23:
/* 1123 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/* 1124 */       break;
/*      */     case 24:
/* 1126 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/* 1127 */       break;
/*      */     case 25:
/* 1129 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/* 1130 */       break;
/*      */     case 26:
/* 1132 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/* 1133 */       break;
/*      */     case 27:
/* 1135 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/* 1136 */       break;
/*      */     case 28:
/* 1138 */       strFieldValue = String.valueOf(this.iF01);
/* 1139 */       break;
/*      */     case 29:
/* 1141 */       strFieldValue = String.valueOf(this.dF02);
/* 1142 */       break;
/*      */     case 30:
/* 1144 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/* 1145 */       break;
/*      */     case 31:
/* 1147 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1148 */       break;
/*      */     case 32:
/* 1150 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1151 */       break;
/*      */     case 33:
/* 1153 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1154 */       break;
/*      */     case 34:
/* 1156 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1157 */       break;
/*      */     case 35:
/* 1159 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1160 */       break;
/*      */     case 36:
/* 1162 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1163 */       break;
/*      */     case 37:
/* 1165 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1166 */       break;
/*      */     default:
/* 1168 */       strFieldValue = "";
/*      */     }
/* 1170 */     if (strFieldValue.equals("")) {
/* 1171 */       strFieldValue = "null";
/*      */     }
/* 1173 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1179 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1180 */       return false;
/*      */     }
/* 1182 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1184 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1186 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1189 */         this.edorNo = null;
/*      */     }
/* 1191 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1193 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1195 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1198 */         this.edorType = null;
/*      */     }
/* 1200 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1202 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1204 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1207 */         this.edorCase = null;
/*      */     }
/* 1209 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1211 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1213 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1216 */         this.operator2 = null;
/*      */     }
/* 1218 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1220 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1222 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1225 */         this.makeDate2 = null;
/*      */     }
/* 1227 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1229 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1231 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1234 */         this.makeTime2 = null;
/*      */     }
/* 1236 */     if (FCode.equalsIgnoreCase("fileID"))
/*      */     {
/* 1238 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1240 */         this.fileID = FValue.trim();
/*      */       }
/*      */       else
/* 1243 */         this.fileID = null;
/*      */     }
/* 1245 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1247 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1249 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1252 */         this.name = null;
/*      */     }
/* 1254 */     if (FCode.equalsIgnoreCase("displayName"))
/*      */     {
/* 1256 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1258 */         this.displayName = FValue.trim();
/*      */       }
/*      */       else
/* 1261 */         this.displayName = null;
/*      */     }
/* 1263 */     if (FCode.equalsIgnoreCase("fileDescription"))
/*      */     {
/* 1265 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1267 */         this.fileDescription = FValue.trim();
/*      */       }
/*      */       else
/* 1270 */         this.fileDescription = null;
/*      */     }
/* 1272 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1274 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1276 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1279 */         this.manageCom = null;
/*      */     }
/* 1281 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1283 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1285 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1288 */         this.branchType = null;
/*      */     }
/* 1290 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/* 1292 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1294 */         this.nodeID = FValue.trim();
/*      */       }
/*      */       else
/* 1297 */         this.nodeID = null;
/*      */     }
/* 1299 */     if (FCode.equalsIgnoreCase("fileType"))
/*      */     {
/* 1301 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1303 */         this.fileType = FValue.trim();
/*      */       }
/*      */       else
/* 1306 */         this.fileType = null;
/*      */     }
/* 1308 */     if (FCode.equalsIgnoreCase("filePath"))
/*      */     {
/* 1310 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1312 */         this.filePath = FValue.trim();
/*      */       }
/*      */       else
/* 1315 */         this.filePath = null;
/*      */     }
/* 1317 */     if (FCode.equalsIgnoreCase("documentType"))
/*      */     {
/* 1319 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1321 */         this.documentType = FValue.trim();
/*      */       }
/*      */       else
/* 1324 */         this.documentType = null;
/*      */     }
/* 1326 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/* 1328 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1330 */         this.startDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1333 */         this.startDisplayDate = null;
/*      */     }
/* 1335 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/* 1337 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1339 */         this.endDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1342 */         this.endDisplayDate = null;
/*      */     }
/* 1344 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/* 1346 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1348 */         this.minDisplayGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1351 */         this.minDisplayGrade = null;
/*      */     }
/* 1353 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/* 1355 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1357 */         this.startDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1360 */         this.startDisplayTime = null;
/*      */     }
/* 1362 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/* 1364 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1366 */         this.endDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1369 */         this.endDisplayTime = null;
/*      */     }
/* 1371 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1373 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1375 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1378 */         this.checkState = null;
/*      */     }
/* 1380 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1382 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1384 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1387 */         this.checkOperator = null;
/*      */     }
/* 1389 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1391 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1393 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1396 */         this.checkReason = null;
/*      */     }
/* 1398 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1400 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1402 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1405 */         this.checkDate = null;
/*      */     }
/* 1407 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1409 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1411 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1414 */         this.checkTime = null;
/*      */     }
/* 1416 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1418 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1420 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1423 */         this.vF01 = null;
/*      */     }
/* 1425 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1427 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1429 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1432 */         this.nF01 = null;
/*      */     }
/* 1434 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1436 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1438 */         Integer tInteger = new Integer(FValue);
/* 1439 */         int i = tInteger.intValue();
/* 1440 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1443 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1445 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1447 */         Double tDouble = new Double(FValue);
/* 1448 */         double d = tDouble.doubleValue();
/* 1449 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1452 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1454 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1456 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1459 */         this.date01 = null;
/*      */     }
/* 1461 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1463 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1465 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1468 */         this.modifyOperator = null;
/*      */     }
/* 1470 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1472 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1474 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1477 */         this.operator = null;
/*      */     }
/* 1479 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1481 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1483 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1486 */         this.makeDate = null;
/*      */     }
/* 1488 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1490 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1492 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1495 */         this.makeTime = null;
/*      */     }
/* 1497 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1499 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1501 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1504 */         this.modifyDate = null;
/*      */     }
/* 1506 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1508 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1510 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1513 */         this.modifyTime = null;
/*      */     }
/* 1515 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1517 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1519 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1522 */         this.state = null;
/*      */     }
/* 1524 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1529 */     if (otherObject == null) return false;
/* 1530 */     if (this == otherObject) return true;
/* 1531 */     if (getClass() != otherObject.getClass()) return false;
/* 1532 */     MLibraryBSchema other = (MLibraryBSchema)otherObject;
/* 1533 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1534 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1535 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1536 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1537 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1538 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1539 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1540 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1541 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1542 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1543 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1544 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1545 */     if ((this.fileID == null) && (other.getFileID() != null)) return false;
/* 1546 */     if ((this.fileID != null) && (!this.fileID.equals(other.getFileID()))) return false;
/* 1547 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1548 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1549 */     if ((this.displayName == null) && (other.getDisplayName() != null)) return false;
/* 1550 */     if ((this.displayName != null) && (!this.displayName.equals(other.getDisplayName()))) return false;
/* 1551 */     if ((this.fileDescription == null) && (other.getFileDescription() != null)) return false;
/* 1552 */     if ((this.fileDescription != null) && (!this.fileDescription.equals(other.getFileDescription()))) return false;
/* 1553 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1554 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1555 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1556 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1557 */     if ((this.nodeID == null) && (other.getNodeID() != null)) return false;
/* 1558 */     if ((this.nodeID != null) && (!this.nodeID.equals(other.getNodeID()))) return false;
/* 1559 */     if ((this.fileType == null) && (other.getFileType() != null)) return false;
/* 1560 */     if ((this.fileType != null) && (!this.fileType.equals(other.getFileType()))) return false;
/* 1561 */     if ((this.filePath == null) && (other.getFilePath() != null)) return false;
/* 1562 */     if ((this.filePath != null) && (!this.filePath.equals(other.getFilePath()))) return false;
/* 1563 */     if ((this.documentType == null) && (other.getDocumentType() != null)) return false;
/* 1564 */     if ((this.documentType != null) && (!this.documentType.equals(other.getDocumentType()))) return false;
/* 1565 */     if ((this.startDisplayDate == null) && (other.getStartDisplayDate() != null)) return false;
/* 1566 */     if ((this.startDisplayDate != null) && (!this.fDate.getString(this.startDisplayDate).equals(other.getStartDisplayDate()))) return false;
/* 1567 */     if ((this.endDisplayDate == null) && (other.getEndDisplayDate() != null)) return false;
/* 1568 */     if ((this.endDisplayDate != null) && (!this.fDate.getString(this.endDisplayDate).equals(other.getEndDisplayDate()))) return false;
/* 1569 */     if ((this.minDisplayGrade == null) && (other.getMinDisplayGrade() != null)) return false;
/* 1570 */     if ((this.minDisplayGrade != null) && (!this.minDisplayGrade.equals(other.getMinDisplayGrade()))) return false;
/* 1571 */     if ((this.startDisplayTime == null) && (other.getStartDisplayTime() != null)) return false;
/* 1572 */     if ((this.startDisplayTime != null) && (!this.startDisplayTime.equals(other.getStartDisplayTime()))) return false;
/* 1573 */     if ((this.endDisplayTime == null) && (other.getEndDisplayTime() != null)) return false;
/* 1574 */     if ((this.endDisplayTime != null) && (!this.endDisplayTime.equals(other.getEndDisplayTime()))) return false;
/* 1575 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1576 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1577 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1578 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1579 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1580 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1581 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1582 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1583 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1584 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1585 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1586 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1587 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1588 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1589 */     if (this.iF01 != other.getIF01()) return false;
/* 1590 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1591 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1592 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1593 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1594 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1595 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1596 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1597 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1598 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1599 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1600 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1601 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1602 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1603 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1604 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1605 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1606 */     return (this.state == null) || (this.state.equals(other.getState()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1613 */     return 38;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1619 */     if (strFieldName.equals("edorNo")) {
/* 1620 */       return 0;
/*      */     }
/* 1622 */     if (strFieldName.equals("edorType")) {
/* 1623 */       return 1;
/*      */     }
/* 1625 */     if (strFieldName.equals("edorCase")) {
/* 1626 */       return 2;
/*      */     }
/* 1628 */     if (strFieldName.equals("operator2")) {
/* 1629 */       return 3;
/*      */     }
/* 1631 */     if (strFieldName.equals("makeDate2")) {
/* 1632 */       return 4;
/*      */     }
/* 1634 */     if (strFieldName.equals("makeTime2")) {
/* 1635 */       return 5;
/*      */     }
/* 1637 */     if (strFieldName.equals("fileID")) {
/* 1638 */       return 6;
/*      */     }
/* 1640 */     if (strFieldName.equals("name")) {
/* 1641 */       return 7;
/*      */     }
/* 1643 */     if (strFieldName.equals("displayName")) {
/* 1644 */       return 8;
/*      */     }
/* 1646 */     if (strFieldName.equals("fileDescription")) {
/* 1647 */       return 9;
/*      */     }
/* 1649 */     if (strFieldName.equals("manageCom")) {
/* 1650 */       return 10;
/*      */     }
/* 1652 */     if (strFieldName.equals("branchType")) {
/* 1653 */       return 11;
/*      */     }
/* 1655 */     if (strFieldName.equals("nodeID")) {
/* 1656 */       return 12;
/*      */     }
/* 1658 */     if (strFieldName.equals("fileType")) {
/* 1659 */       return 13;
/*      */     }
/* 1661 */     if (strFieldName.equals("filePath")) {
/* 1662 */       return 14;
/*      */     }
/* 1664 */     if (strFieldName.equals("documentType")) {
/* 1665 */       return 15;
/*      */     }
/* 1667 */     if (strFieldName.equals("startDisplayDate")) {
/* 1668 */       return 16;
/*      */     }
/* 1670 */     if (strFieldName.equals("endDisplayDate")) {
/* 1671 */       return 17;
/*      */     }
/* 1673 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1674 */       return 18;
/*      */     }
/* 1676 */     if (strFieldName.equals("startDisplayTime")) {
/* 1677 */       return 19;
/*      */     }
/* 1679 */     if (strFieldName.equals("endDisplayTime")) {
/* 1680 */       return 20;
/*      */     }
/* 1682 */     if (strFieldName.equals("checkState")) {
/* 1683 */       return 21;
/*      */     }
/* 1685 */     if (strFieldName.equals("checkOperator")) {
/* 1686 */       return 22;
/*      */     }
/* 1688 */     if (strFieldName.equals("checkReason")) {
/* 1689 */       return 23;
/*      */     }
/* 1691 */     if (strFieldName.equals("checkDate")) {
/* 1692 */       return 24;
/*      */     }
/* 1694 */     if (strFieldName.equals("checkTime")) {
/* 1695 */       return 25;
/*      */     }
/* 1697 */     if (strFieldName.equals("vF01")) {
/* 1698 */       return 26;
/*      */     }
/* 1700 */     if (strFieldName.equals("nF01")) {
/* 1701 */       return 27;
/*      */     }
/* 1703 */     if (strFieldName.equals("iF01")) {
/* 1704 */       return 28;
/*      */     }
/* 1706 */     if (strFieldName.equals("dF02")) {
/* 1707 */       return 29;
/*      */     }
/* 1709 */     if (strFieldName.equals("date01")) {
/* 1710 */       return 30;
/*      */     }
/* 1712 */     if (strFieldName.equals("modifyOperator")) {
/* 1713 */       return 31;
/*      */     }
/* 1715 */     if (strFieldName.equals("operator")) {
/* 1716 */       return 32;
/*      */     }
/* 1718 */     if (strFieldName.equals("makeDate")) {
/* 1719 */       return 33;
/*      */     }
/* 1721 */     if (strFieldName.equals("makeTime")) {
/* 1722 */       return 34;
/*      */     }
/* 1724 */     if (strFieldName.equals("modifyDate")) {
/* 1725 */       return 35;
/*      */     }
/* 1727 */     if (strFieldName.equals("modifyTime")) {
/* 1728 */       return 36;
/*      */     }
/* 1730 */     if (strFieldName.equals("state")) {
/* 1731 */       return 37;
/*      */     }
/* 1733 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1739 */     String strFieldName = "";
/* 1740 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1742 */       strFieldName = "edorNo";
/* 1743 */       break;
/*      */     case 1:
/* 1745 */       strFieldName = "edorType";
/* 1746 */       break;
/*      */     case 2:
/* 1748 */       strFieldName = "edorCase";
/* 1749 */       break;
/*      */     case 3:
/* 1751 */       strFieldName = "operator2";
/* 1752 */       break;
/*      */     case 4:
/* 1754 */       strFieldName = "makeDate2";
/* 1755 */       break;
/*      */     case 5:
/* 1757 */       strFieldName = "makeTime2";
/* 1758 */       break;
/*      */     case 6:
/* 1760 */       strFieldName = "fileID";
/* 1761 */       break;
/*      */     case 7:
/* 1763 */       strFieldName = "name";
/* 1764 */       break;
/*      */     case 8:
/* 1766 */       strFieldName = "displayName";
/* 1767 */       break;
/*      */     case 9:
/* 1769 */       strFieldName = "fileDescription";
/* 1770 */       break;
/*      */     case 10:
/* 1772 */       strFieldName = "manageCom";
/* 1773 */       break;
/*      */     case 11:
/* 1775 */       strFieldName = "branchType";
/* 1776 */       break;
/*      */     case 12:
/* 1778 */       strFieldName = "nodeID";
/* 1779 */       break;
/*      */     case 13:
/* 1781 */       strFieldName = "fileType";
/* 1782 */       break;
/*      */     case 14:
/* 1784 */       strFieldName = "filePath";
/* 1785 */       break;
/*      */     case 15:
/* 1787 */       strFieldName = "documentType";
/* 1788 */       break;
/*      */     case 16:
/* 1790 */       strFieldName = "startDisplayDate";
/* 1791 */       break;
/*      */     case 17:
/* 1793 */       strFieldName = "endDisplayDate";
/* 1794 */       break;
/*      */     case 18:
/* 1796 */       strFieldName = "minDisplayGrade";
/* 1797 */       break;
/*      */     case 19:
/* 1799 */       strFieldName = "startDisplayTime";
/* 1800 */       break;
/*      */     case 20:
/* 1802 */       strFieldName = "endDisplayTime";
/* 1803 */       break;
/*      */     case 21:
/* 1805 */       strFieldName = "checkState";
/* 1806 */       break;
/*      */     case 22:
/* 1808 */       strFieldName = "checkOperator";
/* 1809 */       break;
/*      */     case 23:
/* 1811 */       strFieldName = "checkReason";
/* 1812 */       break;
/*      */     case 24:
/* 1814 */       strFieldName = "checkDate";
/* 1815 */       break;
/*      */     case 25:
/* 1817 */       strFieldName = "checkTime";
/* 1818 */       break;
/*      */     case 26:
/* 1820 */       strFieldName = "vF01";
/* 1821 */       break;
/*      */     case 27:
/* 1823 */       strFieldName = "nF01";
/* 1824 */       break;
/*      */     case 28:
/* 1826 */       strFieldName = "iF01";
/* 1827 */       break;
/*      */     case 29:
/* 1829 */       strFieldName = "dF02";
/* 1830 */       break;
/*      */     case 30:
/* 1832 */       strFieldName = "date01";
/* 1833 */       break;
/*      */     case 31:
/* 1835 */       strFieldName = "modifyOperator";
/* 1836 */       break;
/*      */     case 32:
/* 1838 */       strFieldName = "operator";
/* 1839 */       break;
/*      */     case 33:
/* 1841 */       strFieldName = "makeDate";
/* 1842 */       break;
/*      */     case 34:
/* 1844 */       strFieldName = "makeTime";
/* 1845 */       break;
/*      */     case 35:
/* 1847 */       strFieldName = "modifyDate";
/* 1848 */       break;
/*      */     case 36:
/* 1850 */       strFieldName = "modifyTime";
/* 1851 */       break;
/*      */     case 37:
/* 1853 */       strFieldName = "state";
/* 1854 */       break;
/*      */     default:
/* 1856 */       strFieldName = "";
/*      */     }
/* 1858 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1864 */     if (strFieldName.equals("edorNo")) {
/* 1865 */       return 0;
/*      */     }
/* 1867 */     if (strFieldName.equals("edorType")) {
/* 1868 */       return 0;
/*      */     }
/* 1870 */     if (strFieldName.equals("edorCase")) {
/* 1871 */       return 0;
/*      */     }
/* 1873 */     if (strFieldName.equals("operator2")) {
/* 1874 */       return 0;
/*      */     }
/* 1876 */     if (strFieldName.equals("makeDate2")) {
/* 1877 */       return 1;
/*      */     }
/* 1879 */     if (strFieldName.equals("makeTime2")) {
/* 1880 */       return 0;
/*      */     }
/* 1882 */     if (strFieldName.equals("fileID")) {
/* 1883 */       return 0;
/*      */     }
/* 1885 */     if (strFieldName.equals("name")) {
/* 1886 */       return 0;
/*      */     }
/* 1888 */     if (strFieldName.equals("displayName")) {
/* 1889 */       return 0;
/*      */     }
/* 1891 */     if (strFieldName.equals("fileDescription")) {
/* 1892 */       return 0;
/*      */     }
/* 1894 */     if (strFieldName.equals("manageCom")) {
/* 1895 */       return 0;
/*      */     }
/* 1897 */     if (strFieldName.equals("branchType")) {
/* 1898 */       return 0;
/*      */     }
/* 1900 */     if (strFieldName.equals("nodeID")) {
/* 1901 */       return 0;
/*      */     }
/* 1903 */     if (strFieldName.equals("fileType")) {
/* 1904 */       return 0;
/*      */     }
/* 1906 */     if (strFieldName.equals("filePath")) {
/* 1907 */       return 0;
/*      */     }
/* 1909 */     if (strFieldName.equals("documentType")) {
/* 1910 */       return 0;
/*      */     }
/* 1912 */     if (strFieldName.equals("startDisplayDate")) {
/* 1913 */       return 1;
/*      */     }
/* 1915 */     if (strFieldName.equals("endDisplayDate")) {
/* 1916 */       return 1;
/*      */     }
/* 1918 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1919 */       return 0;
/*      */     }
/* 1921 */     if (strFieldName.equals("startDisplayTime")) {
/* 1922 */       return 0;
/*      */     }
/* 1924 */     if (strFieldName.equals("endDisplayTime")) {
/* 1925 */       return 0;
/*      */     }
/* 1927 */     if (strFieldName.equals("checkState")) {
/* 1928 */       return 0;
/*      */     }
/* 1930 */     if (strFieldName.equals("checkOperator")) {
/* 1931 */       return 0;
/*      */     }
/* 1933 */     if (strFieldName.equals("checkReason")) {
/* 1934 */       return 0;
/*      */     }
/* 1936 */     if (strFieldName.equals("checkDate")) {
/* 1937 */       return 1;
/*      */     }
/* 1939 */     if (strFieldName.equals("checkTime")) {
/* 1940 */       return 0;
/*      */     }
/* 1942 */     if (strFieldName.equals("vF01")) {
/* 1943 */       return 0;
/*      */     }
/* 1945 */     if (strFieldName.equals("nF01")) {
/* 1946 */       return 0;
/*      */     }
/* 1948 */     if (strFieldName.equals("iF01")) {
/* 1949 */       return 3;
/*      */     }
/* 1951 */     if (strFieldName.equals("dF02")) {
/* 1952 */       return 4;
/*      */     }
/* 1954 */     if (strFieldName.equals("date01")) {
/* 1955 */       return 1;
/*      */     }
/* 1957 */     if (strFieldName.equals("modifyOperator")) {
/* 1958 */       return 0;
/*      */     }
/* 1960 */     if (strFieldName.equals("operator")) {
/* 1961 */       return 0;
/*      */     }
/* 1963 */     if (strFieldName.equals("makeDate")) {
/* 1964 */       return 1;
/*      */     }
/* 1966 */     if (strFieldName.equals("makeTime")) {
/* 1967 */       return 0;
/*      */     }
/* 1969 */     if (strFieldName.equals("modifyDate")) {
/* 1970 */       return 1;
/*      */     }
/* 1972 */     if (strFieldName.equals("modifyTime")) {
/* 1973 */       return 0;
/*      */     }
/* 1975 */     if (strFieldName.equals("state")) {
/* 1976 */       return 0;
/*      */     }
/* 1978 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1984 */     int nFieldType = -1;
/* 1985 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1987 */       nFieldType = 0;
/* 1988 */       break;
/*      */     case 1:
/* 1990 */       nFieldType = 0;
/* 1991 */       break;
/*      */     case 2:
/* 1993 */       nFieldType = 0;
/* 1994 */       break;
/*      */     case 3:
/* 1996 */       nFieldType = 0;
/* 1997 */       break;
/*      */     case 4:
/* 1999 */       nFieldType = 1;
/* 2000 */       break;
/*      */     case 5:
/* 2002 */       nFieldType = 0;
/* 2003 */       break;
/*      */     case 6:
/* 2005 */       nFieldType = 0;
/* 2006 */       break;
/*      */     case 7:
/* 2008 */       nFieldType = 0;
/* 2009 */       break;
/*      */     case 8:
/* 2011 */       nFieldType = 0;
/* 2012 */       break;
/*      */     case 9:
/* 2014 */       nFieldType = 0;
/* 2015 */       break;
/*      */     case 10:
/* 2017 */       nFieldType = 0;
/* 2018 */       break;
/*      */     case 11:
/* 2020 */       nFieldType = 0;
/* 2021 */       break;
/*      */     case 12:
/* 2023 */       nFieldType = 0;
/* 2024 */       break;
/*      */     case 13:
/* 2026 */       nFieldType = 0;
/* 2027 */       break;
/*      */     case 14:
/* 2029 */       nFieldType = 0;
/* 2030 */       break;
/*      */     case 15:
/* 2032 */       nFieldType = 0;
/* 2033 */       break;
/*      */     case 16:
/* 2035 */       nFieldType = 1;
/* 2036 */       break;
/*      */     case 17:
/* 2038 */       nFieldType = 1;
/* 2039 */       break;
/*      */     case 18:
/* 2041 */       nFieldType = 0;
/* 2042 */       break;
/*      */     case 19:
/* 2044 */       nFieldType = 0;
/* 2045 */       break;
/*      */     case 20:
/* 2047 */       nFieldType = 0;
/* 2048 */       break;
/*      */     case 21:
/* 2050 */       nFieldType = 0;
/* 2051 */       break;
/*      */     case 22:
/* 2053 */       nFieldType = 0;
/* 2054 */       break;
/*      */     case 23:
/* 2056 */       nFieldType = 0;
/* 2057 */       break;
/*      */     case 24:
/* 2059 */       nFieldType = 1;
/* 2060 */       break;
/*      */     case 25:
/* 2062 */       nFieldType = 0;
/* 2063 */       break;
/*      */     case 26:
/* 2065 */       nFieldType = 0;
/* 2066 */       break;
/*      */     case 27:
/* 2068 */       nFieldType = 0;
/* 2069 */       break;
/*      */     case 28:
/* 2071 */       nFieldType = 3;
/* 2072 */       break;
/*      */     case 29:
/* 2074 */       nFieldType = 4;
/* 2075 */       break;
/*      */     case 30:
/* 2077 */       nFieldType = 1;
/* 2078 */       break;
/*      */     case 31:
/* 2080 */       nFieldType = 0;
/* 2081 */       break;
/*      */     case 32:
/* 2083 */       nFieldType = 0;
/* 2084 */       break;
/*      */     case 33:
/* 2086 */       nFieldType = 1;
/* 2087 */       break;
/*      */     case 34:
/* 2089 */       nFieldType = 0;
/* 2090 */       break;
/*      */     case 35:
/* 2092 */       nFieldType = 1;
/* 2093 */       break;
/*      */     case 36:
/* 2095 */       nFieldType = 0;
/* 2096 */       break;
/*      */     case 37:
/* 2098 */       nFieldType = 0;
/* 2099 */       break;
/*      */     default:
/* 2101 */       nFieldType = -1;
/*      */     }
/* 2103 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLibraryBSchema
 * JD-Core Version:    0.6.0
 */