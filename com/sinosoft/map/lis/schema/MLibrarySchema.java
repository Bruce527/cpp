/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLibraryDB;
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
/*      */ public class MLibrarySchema
/*      */   implements Schema, Cloneable
/*      */ {
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
/*      */   public static final int FIELDNUM = 32;
/*      */   private static String[] PK;
/*   88 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLibrarySchema()
/*      */   {
/*   95 */     this.mErrors = new CErrors();
/*      */ 
/*   97 */     String[] pk = new String[1];
/*   98 */     pk[0] = "FileID";
/*      */ 
/*  100 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  107 */     MLibrarySchema cloned = (MLibrarySchema)super.clone();
/*  108 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  109 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  110 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  116 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getFileID()
/*      */   {
/*  121 */     return this.fileID;
/*      */   }
/*      */ 
/*      */   public void setFileID(String aFileID) {
/*  125 */     this.fileID = aFileID;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  129 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  133 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getDisplayName() {
/*  137 */     return this.displayName;
/*      */   }
/*      */ 
/*      */   public void setDisplayName(String aDisplayName) {
/*  141 */     this.displayName = aDisplayName;
/*      */   }
/*      */ 
/*      */   public String getFileDescription() {
/*  145 */     return this.fileDescription;
/*      */   }
/*      */ 
/*      */   public void setFileDescription(String aFileDescription) {
/*  149 */     this.fileDescription = aFileDescription;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  153 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  157 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  161 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  165 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getNodeID() {
/*  169 */     return this.nodeID;
/*      */   }
/*      */ 
/*      */   public void setNodeID(String aNodeID) {
/*  173 */     this.nodeID = aNodeID;
/*      */   }
/*      */ 
/*      */   public String getFileType() {
/*  177 */     return this.fileType;
/*      */   }
/*      */ 
/*      */   public void setFileType(String aFileType) {
/*  181 */     this.fileType = aFileType;
/*      */   }
/*      */ 
/*      */   public String getFilePath() {
/*  185 */     return this.filePath;
/*      */   }
/*      */ 
/*      */   public void setFilePath(String aFilePath) {
/*  189 */     this.filePath = aFilePath;
/*      */   }
/*      */ 
/*      */   public String getDocumentType() {
/*  193 */     return this.documentType;
/*      */   }
/*      */ 
/*      */   public void setDocumentType(String aDocumentType) {
/*  197 */     this.documentType = aDocumentType;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayDate() {
/*  201 */     if (this.startDisplayDate != null) {
/*  202 */       return this.fDate.getString(this.startDisplayDate);
/*      */     }
/*  204 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(Date aStartDisplayDate) {
/*  208 */     this.startDisplayDate = aStartDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(String aStartDisplayDate) {
/*  212 */     if ((aStartDisplayDate != null) && (!aStartDisplayDate.equals("")))
/*      */     {
/*  214 */       this.startDisplayDate = this.fDate.getDate(aStartDisplayDate);
/*      */     }
/*      */     else
/*  217 */       this.startDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayDate()
/*      */   {
/*  222 */     if (this.endDisplayDate != null) {
/*  223 */       return this.fDate.getString(this.endDisplayDate);
/*      */     }
/*  225 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(Date aEndDisplayDate) {
/*  229 */     this.endDisplayDate = aEndDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(String aEndDisplayDate) {
/*  233 */     if ((aEndDisplayDate != null) && (!aEndDisplayDate.equals("")))
/*      */     {
/*  235 */       this.endDisplayDate = this.fDate.getDate(aEndDisplayDate);
/*      */     }
/*      */     else
/*  238 */       this.endDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getMinDisplayGrade()
/*      */   {
/*  243 */     return this.minDisplayGrade;
/*      */   }
/*      */ 
/*      */   public void setMinDisplayGrade(String aMinDisplayGrade) {
/*  247 */     this.minDisplayGrade = aMinDisplayGrade;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayTime() {
/*  251 */     return this.startDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayTime(String aStartDisplayTime) {
/*  255 */     this.startDisplayTime = aStartDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayTime() {
/*  259 */     return this.endDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayTime(String aEndDisplayTime) {
/*  263 */     this.endDisplayTime = aEndDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  267 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  271 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  275 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  279 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  283 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  287 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  291 */     if (this.checkDate != null) {
/*  292 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  294 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  298 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  302 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  304 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  307 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  312 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  316 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  320 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  324 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  328 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  332 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  336 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  340 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  344 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  346 */       Integer tInteger = new Integer(aIF01);
/*  347 */       int i = tInteger.intValue();
/*  348 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  354 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  358 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  362 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  364 */       Double tDouble = new Double(aDF02);
/*  365 */       double d = tDouble.doubleValue();
/*  366 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  372 */     if (this.date01 != null) {
/*  373 */       return this.fDate.getString(this.date01);
/*      */     }
/*  375 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  379 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  383 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  385 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  388 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  393 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  397 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  401 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  405 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  409 */     if (this.makeDate != null) {
/*  410 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  412 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  416 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  420 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  422 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  425 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  430 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  434 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  438 */     if (this.modifyDate != null) {
/*  439 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  441 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  445 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  449 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  451 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  454 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  459 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  463 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  467 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String aState) {
/*  471 */     this.state = aState;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLibrarySchema aMLibrarySchema)
/*      */   {
/*  477 */     this.fileID = aMLibrarySchema.getFileID();
/*  478 */     this.name = aMLibrarySchema.getName();
/*  479 */     this.displayName = aMLibrarySchema.getDisplayName();
/*  480 */     this.fileDescription = aMLibrarySchema.getFileDescription();
/*  481 */     this.manageCom = aMLibrarySchema.getManageCom();
/*  482 */     this.branchType = aMLibrarySchema.getBranchType();
/*  483 */     this.nodeID = aMLibrarySchema.getNodeID();
/*  484 */     this.fileType = aMLibrarySchema.getFileType();
/*  485 */     this.filePath = aMLibrarySchema.getFilePath();
/*  486 */     this.documentType = aMLibrarySchema.getDocumentType();
/*  487 */     this.startDisplayDate = this.fDate.getDate(aMLibrarySchema.getStartDisplayDate());
/*  488 */     this.endDisplayDate = this.fDate.getDate(aMLibrarySchema.getEndDisplayDate());
/*  489 */     this.minDisplayGrade = aMLibrarySchema.getMinDisplayGrade();
/*  490 */     this.startDisplayTime = aMLibrarySchema.getStartDisplayTime();
/*  491 */     this.endDisplayTime = aMLibrarySchema.getEndDisplayTime();
/*  492 */     this.checkState = aMLibrarySchema.getCheckState();
/*  493 */     this.checkOperator = aMLibrarySchema.getCheckOperator();
/*  494 */     this.checkReason = aMLibrarySchema.getCheckReason();
/*  495 */     this.checkDate = this.fDate.getDate(aMLibrarySchema.getCheckDate());
/*  496 */     this.checkTime = aMLibrarySchema.getCheckTime();
/*  497 */     this.vF01 = aMLibrarySchema.getVF01();
/*  498 */     this.nF01 = aMLibrarySchema.getNF01();
/*  499 */     this.iF01 = aMLibrarySchema.getIF01();
/*  500 */     this.dF02 = aMLibrarySchema.getDF02();
/*  501 */     this.date01 = this.fDate.getDate(aMLibrarySchema.getDate01());
/*  502 */     this.modifyOperator = aMLibrarySchema.getModifyOperator();
/*  503 */     this.operator = aMLibrarySchema.getOperator();
/*  504 */     this.makeDate = this.fDate.getDate(aMLibrarySchema.getMakeDate());
/*  505 */     this.makeTime = aMLibrarySchema.getMakeTime();
/*  506 */     this.modifyDate = this.fDate.getDate(aMLibrarySchema.getModifyDate());
/*  507 */     this.modifyTime = aMLibrarySchema.getModifyTime();
/*  508 */     this.state = aMLibrarySchema.getState();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  517 */       if (rs.getString("FileID") == null)
/*  518 */         this.fileID = null;
/*      */       else {
/*  520 */         this.fileID = rs.getString("FileID").trim();
/*      */       }
/*  522 */       if (rs.getString("Name") == null)
/*  523 */         this.name = null;
/*      */       else {
/*  525 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  527 */       if (rs.getString("DisplayName") == null)
/*  528 */         this.displayName = null;
/*      */       else {
/*  530 */         this.displayName = rs.getString("DisplayName").trim();
/*      */       }
/*  532 */       if (rs.getString("FileDescription") == null)
/*  533 */         this.fileDescription = null;
/*      */       else {
/*  535 */         this.fileDescription = rs.getString("FileDescription").trim();
/*      */       }
/*  537 */       if (rs.getString("ManageCom") == null)
/*  538 */         this.manageCom = null;
/*      */       else {
/*  540 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  542 */       if (rs.getString("BranchType") == null)
/*  543 */         this.branchType = null;
/*      */       else {
/*  545 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  547 */       if (rs.getString("NodeID") == null)
/*  548 */         this.nodeID = null;
/*      */       else {
/*  550 */         this.nodeID = rs.getString("NodeID").trim();
/*      */       }
/*  552 */       if (rs.getString("FileType") == null)
/*  553 */         this.fileType = null;
/*      */       else {
/*  555 */         this.fileType = rs.getString("FileType").trim();
/*      */       }
/*  557 */       if (rs.getString("FilePath") == null)
/*  558 */         this.filePath = null;
/*      */       else {
/*  560 */         this.filePath = rs.getString("FilePath").trim();
/*      */       }
/*  562 */       if (rs.getString("DocumentType") == null)
/*  563 */         this.documentType = null;
/*      */       else {
/*  565 */         this.documentType = rs.getString("DocumentType").trim();
/*      */       }
/*  567 */       this.startDisplayDate = rs.getDate("StartDisplayDate");
/*  568 */       this.endDisplayDate = rs.getDate("EndDisplayDate");
/*  569 */       if (rs.getString("MinDisplayGrade") == null)
/*  570 */         this.minDisplayGrade = null;
/*      */       else {
/*  572 */         this.minDisplayGrade = rs.getString("MinDisplayGrade").trim();
/*      */       }
/*  574 */       if (rs.getString("StartDisplayTime") == null)
/*  575 */         this.startDisplayTime = null;
/*      */       else {
/*  577 */         this.startDisplayTime = rs.getString("StartDisplayTime").trim();
/*      */       }
/*  579 */       if (rs.getString("EndDisplayTime") == null)
/*  580 */         this.endDisplayTime = null;
/*      */       else {
/*  582 */         this.endDisplayTime = rs.getString("EndDisplayTime").trim();
/*      */       }
/*  584 */       if (rs.getString("CheckState") == null)
/*  585 */         this.checkState = null;
/*      */       else {
/*  587 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  589 */       if (rs.getString("CheckOperator") == null)
/*  590 */         this.checkOperator = null;
/*      */       else {
/*  592 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  594 */       if (rs.getString("CheckReason") == null)
/*  595 */         this.checkReason = null;
/*      */       else {
/*  597 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  599 */       this.checkDate = rs.getDate("CheckDate");
/*  600 */       if (rs.getString("CheckTime") == null)
/*  601 */         this.checkTime = null;
/*      */       else {
/*  603 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  605 */       if (rs.getString("VF01") == null)
/*  606 */         this.vF01 = null;
/*      */       else {
/*  608 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  610 */       if (rs.getString("NF01") == null)
/*  611 */         this.nF01 = null;
/*      */       else {
/*  613 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  615 */       this.iF01 = rs.getInt("IF01");
/*  616 */       this.dF02 = rs.getDouble("DF02");
/*  617 */       this.date01 = rs.getDate("Date01");
/*  618 */       if (rs.getString("ModifyOperator") == null)
/*  619 */         this.modifyOperator = null;
/*      */       else {
/*  621 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  623 */       if (rs.getString("Operator") == null)
/*  624 */         this.operator = null;
/*      */       else {
/*  626 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  628 */       this.makeDate = rs.getDate("MakeDate");
/*  629 */       if (rs.getString("MakeTime") == null)
/*  630 */         this.makeTime = null;
/*      */       else {
/*  632 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  634 */       this.modifyDate = rs.getDate("ModifyDate");
/*  635 */       if (rs.getString("ModifyTime") == null)
/*  636 */         this.modifyTime = null;
/*      */       else {
/*  638 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  640 */       if (rs.getString("State") == null)
/*  641 */         this.state = null;
/*      */       else {
/*  643 */         this.state = rs.getString("State").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  648 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLibrary\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  650 */       CError tError = new CError();
/*  651 */       tError.moduleName = "MLibrarySchema";
/*  652 */       tError.functionName = "setSchema";
/*  653 */       tError.errorMessage = sqle.toString();
/*  654 */       this.mErrors.addOneError(tError);
/*  655 */       return false;
/*      */     }
/*  657 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibrarySchema getSchema()
/*      */   {
/*  662 */     MLibrarySchema aMLibrarySchema = new MLibrarySchema();
/*  663 */     aMLibrarySchema.setSchema(this);
/*  664 */     return aMLibrarySchema;
/*      */   }
/*      */ 
/*      */   public MLibraryDB getDB()
/*      */   {
/*  669 */     MLibraryDB aDBOper = new MLibraryDB();
/*  670 */     aDBOper.setSchema(this);
/*  671 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  678 */     StringBuffer strReturn = new StringBuffer(256);
/*  679 */     strReturn.append(StrTool.cTrim(this.fileID)); strReturn.append("|");
/*  680 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  681 */     strReturn.append(StrTool.cTrim(this.displayName)); strReturn.append("|");
/*  682 */     strReturn.append(StrTool.cTrim(this.fileDescription)); strReturn.append("|");
/*  683 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  684 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  685 */     strReturn.append(StrTool.cTrim(this.nodeID)); strReturn.append("|");
/*  686 */     strReturn.append(StrTool.cTrim(this.fileType)); strReturn.append("|");
/*  687 */     strReturn.append(StrTool.cTrim(this.filePath)); strReturn.append("|");
/*  688 */     strReturn.append(StrTool.cTrim(this.documentType)); strReturn.append("|");
/*  689 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDisplayDate))); strReturn.append("|");
/*  690 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDisplayDate))); strReturn.append("|");
/*  691 */     strReturn.append(StrTool.cTrim(this.minDisplayGrade)); strReturn.append("|");
/*  692 */     strReturn.append(StrTool.cTrim(this.startDisplayTime)); strReturn.append("|");
/*  693 */     strReturn.append(StrTool.cTrim(this.endDisplayTime)); strReturn.append("|");
/*  694 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  695 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  696 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  697 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  698 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  699 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  700 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  701 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  702 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  703 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  704 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  705 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  706 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  707 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  708 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  709 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  710 */     strReturn.append(StrTool.cTrim(this.state));
/*  711 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  719 */       this.fileID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  720 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  721 */       this.displayName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  722 */       this.fileDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  723 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  724 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  725 */       this.nodeID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  726 */       this.fileType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  727 */       this.filePath = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  728 */       this.documentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  729 */       this.startDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
/*  730 */       this.endDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/*  731 */       this.minDisplayGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  732 */       this.startDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  733 */       this.endDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  734 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  735 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  736 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  737 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  738 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  739 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  740 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  741 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).intValue();
/*  742 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|"))).doubleValue();
/*  743 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  744 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  745 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  746 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
/*  747 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  748 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/*  749 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  750 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  755 */       CError tError = new CError();
/*  756 */       tError.moduleName = "MLibrarySchema";
/*  757 */       tError.functionName = "decode";
/*  758 */       tError.errorMessage = ex.toString();
/*  759 */       this.mErrors.addOneError(tError);
/*      */ 
/*  761 */       return false;
/*      */     }
/*  763 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  769 */     String strReturn = "";
/*  770 */     if (FCode.equalsIgnoreCase("fileID"))
/*      */     {
/*  772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileID));
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  778 */     if (FCode.equalsIgnoreCase("displayName"))
/*      */     {
/*  780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.displayName));
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("fileDescription"))
/*      */     {
/*  784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileDescription));
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/*  796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeID));
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("fileType"))
/*      */     {
/*  800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileType));
/*      */     }
/*  802 */     if (FCode.equalsIgnoreCase("filePath"))
/*      */     {
/*  804 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.filePath));
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("documentType"))
/*      */     {
/*  808 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.documentType));
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/*  812 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*      */     }
/*  814 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/*  816 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/*  820 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minDisplayGrade));
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/*  824 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDisplayTime));
/*      */     }
/*  826 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/*  828 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDisplayTime));
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  832 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  834 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  836 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  838 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  840 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  844 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  848 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  850 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  852 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  854 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  856 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  858 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  860 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  862 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  864 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  866 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  868 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  872 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  874 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  876 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  880 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  882 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  884 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  886 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  888 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  890 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  892 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  894 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/*  896 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*      */     }
/*  898 */     if (strReturn.equals(""))
/*      */     {
/*  900 */       strReturn = "null";
/*      */     }
/*      */ 
/*  903 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  910 */     String strFieldValue = "";
/*  911 */     switch (nFieldIndex) {
/*      */     case 0:
/*  913 */       strFieldValue = StrTool.GBKToUnicode(this.fileID);
/*  914 */       break;
/*      */     case 1:
/*  916 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  917 */       break;
/*      */     case 2:
/*  919 */       strFieldValue = StrTool.GBKToUnicode(this.displayName);
/*  920 */       break;
/*      */     case 3:
/*  922 */       strFieldValue = StrTool.GBKToUnicode(this.fileDescription);
/*  923 */       break;
/*      */     case 4:
/*  925 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  926 */       break;
/*      */     case 5:
/*  928 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  929 */       break;
/*      */     case 6:
/*  931 */       strFieldValue = StrTool.GBKToUnicode(this.nodeID);
/*  932 */       break;
/*      */     case 7:
/*  934 */       strFieldValue = StrTool.GBKToUnicode(this.fileType);
/*  935 */       break;
/*      */     case 8:
/*  937 */       strFieldValue = StrTool.GBKToUnicode(this.filePath);
/*  938 */       break;
/*      */     case 9:
/*  940 */       strFieldValue = StrTool.GBKToUnicode(this.documentType);
/*  941 */       break;
/*      */     case 10:
/*  943 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*  944 */       break;
/*      */     case 11:
/*  946 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*  947 */       break;
/*      */     case 12:
/*  949 */       strFieldValue = StrTool.GBKToUnicode(this.minDisplayGrade);
/*  950 */       break;
/*      */     case 13:
/*  952 */       strFieldValue = StrTool.GBKToUnicode(this.startDisplayTime);
/*  953 */       break;
/*      */     case 14:
/*  955 */       strFieldValue = StrTool.GBKToUnicode(this.endDisplayTime);
/*  956 */       break;
/*      */     case 15:
/*  958 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  959 */       break;
/*      */     case 16:
/*  961 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  962 */       break;
/*      */     case 17:
/*  964 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  965 */       break;
/*      */     case 18:
/*  967 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  968 */       break;
/*      */     case 19:
/*  970 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  971 */       break;
/*      */     case 20:
/*  973 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  974 */       break;
/*      */     case 21:
/*  976 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  977 */       break;
/*      */     case 22:
/*  979 */       strFieldValue = String.valueOf(this.iF01);
/*  980 */       break;
/*      */     case 23:
/*  982 */       strFieldValue = String.valueOf(this.dF02);
/*  983 */       break;
/*      */     case 24:
/*  985 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  986 */       break;
/*      */     case 25:
/*  988 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  989 */       break;
/*      */     case 26:
/*  991 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  992 */       break;
/*      */     case 27:
/*  994 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  995 */       break;
/*      */     case 28:
/*  997 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  998 */       break;
/*      */     case 29:
/* 1000 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1001 */       break;
/*      */     case 30:
/* 1003 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1004 */       break;
/*      */     case 31:
/* 1006 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/* 1007 */       break;
/*      */     default:
/* 1009 */       strFieldValue = "";
/*      */     }
/* 1011 */     if (strFieldValue.equals("")) {
/* 1012 */       strFieldValue = "null";
/*      */     }
/* 1014 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1020 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1021 */       return false;
/*      */     }
/* 1023 */     if (FCode.equalsIgnoreCase("fileID"))
/*      */     {
/* 1025 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1027 */         this.fileID = FValue.trim();
/*      */       }
/*      */       else
/* 1030 */         this.fileID = null;
/*      */     }
/* 1032 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1034 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1036 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1039 */         this.name = null;
/*      */     }
/* 1041 */     if (FCode.equalsIgnoreCase("displayName"))
/*      */     {
/* 1043 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1045 */         this.displayName = FValue.trim();
/*      */       }
/*      */       else
/* 1048 */         this.displayName = null;
/*      */     }
/* 1050 */     if (FCode.equalsIgnoreCase("fileDescription"))
/*      */     {
/* 1052 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1054 */         this.fileDescription = FValue.trim();
/*      */       }
/*      */       else
/* 1057 */         this.fileDescription = null;
/*      */     }
/* 1059 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1061 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1063 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1066 */         this.manageCom = null;
/*      */     }
/* 1068 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1070 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1072 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1075 */         this.branchType = null;
/*      */     }
/* 1077 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/* 1079 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1081 */         this.nodeID = FValue.trim();
/*      */       }
/*      */       else
/* 1084 */         this.nodeID = null;
/*      */     }
/* 1086 */     if (FCode.equalsIgnoreCase("fileType"))
/*      */     {
/* 1088 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1090 */         this.fileType = FValue.trim();
/*      */       }
/*      */       else
/* 1093 */         this.fileType = null;
/*      */     }
/* 1095 */     if (FCode.equalsIgnoreCase("filePath"))
/*      */     {
/* 1097 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1099 */         this.filePath = FValue.trim();
/*      */       }
/*      */       else
/* 1102 */         this.filePath = null;
/*      */     }
/* 1104 */     if (FCode.equalsIgnoreCase("documentType"))
/*      */     {
/* 1106 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1108 */         this.documentType = FValue.trim();
/*      */       }
/*      */       else
/* 1111 */         this.documentType = null;
/*      */     }
/* 1113 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/* 1115 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1117 */         this.startDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1120 */         this.startDisplayDate = null;
/*      */     }
/* 1122 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/* 1124 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1126 */         this.endDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1129 */         this.endDisplayDate = null;
/*      */     }
/* 1131 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/* 1133 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1135 */         this.minDisplayGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1138 */         this.minDisplayGrade = null;
/*      */     }
/* 1140 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/* 1142 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1144 */         this.startDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1147 */         this.startDisplayTime = null;
/*      */     }
/* 1149 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/* 1151 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1153 */         this.endDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1156 */         this.endDisplayTime = null;
/*      */     }
/* 1158 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1160 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1162 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1165 */         this.checkState = null;
/*      */     }
/* 1167 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1169 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1171 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1174 */         this.checkOperator = null;
/*      */     }
/* 1176 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1178 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1180 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1183 */         this.checkReason = null;
/*      */     }
/* 1185 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1187 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1189 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1192 */         this.checkDate = null;
/*      */     }
/* 1194 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1196 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1198 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1201 */         this.checkTime = null;
/*      */     }
/* 1203 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1205 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1207 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1210 */         this.vF01 = null;
/*      */     }
/* 1212 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1214 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1216 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1219 */         this.nF01 = null;
/*      */     }
/* 1221 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1223 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1225 */         Integer tInteger = new Integer(FValue);
/* 1226 */         int i = tInteger.intValue();
/* 1227 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1230 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1232 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1234 */         Double tDouble = new Double(FValue);
/* 1235 */         double d = tDouble.doubleValue();
/* 1236 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1239 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1241 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1243 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1246 */         this.date01 = null;
/*      */     }
/* 1248 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1250 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1252 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1255 */         this.modifyOperator = null;
/*      */     }
/* 1257 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1259 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1261 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1264 */         this.operator = null;
/*      */     }
/* 1266 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1268 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1270 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1273 */         this.makeDate = null;
/*      */     }
/* 1275 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1277 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1279 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1282 */         this.makeTime = null;
/*      */     }
/* 1284 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1286 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1288 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1291 */         this.modifyDate = null;
/*      */     }
/* 1293 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1295 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1297 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1300 */         this.modifyTime = null;
/*      */     }
/* 1302 */     if (FCode.equalsIgnoreCase("state"))
/*      */     {
/* 1304 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1306 */         this.state = FValue.trim();
/*      */       }
/*      */       else
/* 1309 */         this.state = null;
/*      */     }
/* 1311 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1316 */     if (otherObject == null) return false;
/* 1317 */     if (this == otherObject) return true;
/* 1318 */     if (getClass() != otherObject.getClass()) return false;
/* 1319 */     MLibrarySchema other = (MLibrarySchema)otherObject;
/* 1320 */     if ((this.fileID == null) && (other.getFileID() != null)) return false;
/* 1321 */     if ((this.fileID != null) && (!this.fileID.equals(other.getFileID()))) return false;
/* 1322 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1323 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1324 */     if ((this.displayName == null) && (other.getDisplayName() != null)) return false;
/* 1325 */     if ((this.displayName != null) && (!this.displayName.equals(other.getDisplayName()))) return false;
/* 1326 */     if ((this.fileDescription == null) && (other.getFileDescription() != null)) return false;
/* 1327 */     if ((this.fileDescription != null) && (!this.fileDescription.equals(other.getFileDescription()))) return false;
/* 1328 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1329 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1330 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1331 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1332 */     if ((this.nodeID == null) && (other.getNodeID() != null)) return false;
/* 1333 */     if ((this.nodeID != null) && (!this.nodeID.equals(other.getNodeID()))) return false;
/* 1334 */     if ((this.fileType == null) && (other.getFileType() != null)) return false;
/* 1335 */     if ((this.fileType != null) && (!this.fileType.equals(other.getFileType()))) return false;
/* 1336 */     if ((this.filePath == null) && (other.getFilePath() != null)) return false;
/* 1337 */     if ((this.filePath != null) && (!this.filePath.equals(other.getFilePath()))) return false;
/* 1338 */     if ((this.documentType == null) && (other.getDocumentType() != null)) return false;
/* 1339 */     if ((this.documentType != null) && (!this.documentType.equals(other.getDocumentType()))) return false;
/* 1340 */     if ((this.startDisplayDate == null) && (other.getStartDisplayDate() != null)) return false;
/* 1341 */     if ((this.startDisplayDate != null) && (!this.fDate.getString(this.startDisplayDate).equals(other.getStartDisplayDate()))) return false;
/* 1342 */     if ((this.endDisplayDate == null) && (other.getEndDisplayDate() != null)) return false;
/* 1343 */     if ((this.endDisplayDate != null) && (!this.fDate.getString(this.endDisplayDate).equals(other.getEndDisplayDate()))) return false;
/* 1344 */     if ((this.minDisplayGrade == null) && (other.getMinDisplayGrade() != null)) return false;
/* 1345 */     if ((this.minDisplayGrade != null) && (!this.minDisplayGrade.equals(other.getMinDisplayGrade()))) return false;
/* 1346 */     if ((this.startDisplayTime == null) && (other.getStartDisplayTime() != null)) return false;
/* 1347 */     if ((this.startDisplayTime != null) && (!this.startDisplayTime.equals(other.getStartDisplayTime()))) return false;
/* 1348 */     if ((this.endDisplayTime == null) && (other.getEndDisplayTime() != null)) return false;
/* 1349 */     if ((this.endDisplayTime != null) && (!this.endDisplayTime.equals(other.getEndDisplayTime()))) return false;
/* 1350 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1351 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1352 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1353 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1354 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1355 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1356 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1357 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1358 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1359 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1360 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1361 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1362 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1363 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1364 */     if (this.iF01 != other.getIF01()) return false;
/* 1365 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1366 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1367 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1368 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1369 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1370 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1371 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1372 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1373 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1374 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1375 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1376 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1377 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1378 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1379 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1380 */     if ((this.state == null) && (other.getState() != null)) return false;
/* 1381 */     return (this.state == null) || (this.state.equals(other.getState()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1388 */     return 32;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1394 */     if (strFieldName.equals("fileID")) {
/* 1395 */       return 0;
/*      */     }
/* 1397 */     if (strFieldName.equals("name")) {
/* 1398 */       return 1;
/*      */     }
/* 1400 */     if (strFieldName.equals("displayName")) {
/* 1401 */       return 2;
/*      */     }
/* 1403 */     if (strFieldName.equals("fileDescription")) {
/* 1404 */       return 3;
/*      */     }
/* 1406 */     if (strFieldName.equals("manageCom")) {
/* 1407 */       return 4;
/*      */     }
/* 1409 */     if (strFieldName.equals("branchType")) {
/* 1410 */       return 5;
/*      */     }
/* 1412 */     if (strFieldName.equals("nodeID")) {
/* 1413 */       return 6;
/*      */     }
/* 1415 */     if (strFieldName.equals("fileType")) {
/* 1416 */       return 7;
/*      */     }
/* 1418 */     if (strFieldName.equals("filePath")) {
/* 1419 */       return 8;
/*      */     }
/* 1421 */     if (strFieldName.equals("documentType")) {
/* 1422 */       return 9;
/*      */     }
/* 1424 */     if (strFieldName.equals("startDisplayDate")) {
/* 1425 */       return 10;
/*      */     }
/* 1427 */     if (strFieldName.equals("endDisplayDate")) {
/* 1428 */       return 11;
/*      */     }
/* 1430 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1431 */       return 12;
/*      */     }
/* 1433 */     if (strFieldName.equals("startDisplayTime")) {
/* 1434 */       return 13;
/*      */     }
/* 1436 */     if (strFieldName.equals("endDisplayTime")) {
/* 1437 */       return 14;
/*      */     }
/* 1439 */     if (strFieldName.equals("checkState")) {
/* 1440 */       return 15;
/*      */     }
/* 1442 */     if (strFieldName.equals("checkOperator")) {
/* 1443 */       return 16;
/*      */     }
/* 1445 */     if (strFieldName.equals("checkReason")) {
/* 1446 */       return 17;
/*      */     }
/* 1448 */     if (strFieldName.equals("checkDate")) {
/* 1449 */       return 18;
/*      */     }
/* 1451 */     if (strFieldName.equals("checkTime")) {
/* 1452 */       return 19;
/*      */     }
/* 1454 */     if (strFieldName.equals("vF01")) {
/* 1455 */       return 20;
/*      */     }
/* 1457 */     if (strFieldName.equals("nF01")) {
/* 1458 */       return 21;
/*      */     }
/* 1460 */     if (strFieldName.equals("iF01")) {
/* 1461 */       return 22;
/*      */     }
/* 1463 */     if (strFieldName.equals("dF02")) {
/* 1464 */       return 23;
/*      */     }
/* 1466 */     if (strFieldName.equals("date01")) {
/* 1467 */       return 24;
/*      */     }
/* 1469 */     if (strFieldName.equals("modifyOperator")) {
/* 1470 */       return 25;
/*      */     }
/* 1472 */     if (strFieldName.equals("operator")) {
/* 1473 */       return 26;
/*      */     }
/* 1475 */     if (strFieldName.equals("makeDate")) {
/* 1476 */       return 27;
/*      */     }
/* 1478 */     if (strFieldName.equals("makeTime")) {
/* 1479 */       return 28;
/*      */     }
/* 1481 */     if (strFieldName.equals("modifyDate")) {
/* 1482 */       return 29;
/*      */     }
/* 1484 */     if (strFieldName.equals("modifyTime")) {
/* 1485 */       return 30;
/*      */     }
/* 1487 */     if (strFieldName.equals("state")) {
/* 1488 */       return 31;
/*      */     }
/* 1490 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1496 */     String strFieldName = "";
/* 1497 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1499 */       strFieldName = "fileID";
/* 1500 */       break;
/*      */     case 1:
/* 1502 */       strFieldName = "name";
/* 1503 */       break;
/*      */     case 2:
/* 1505 */       strFieldName = "displayName";
/* 1506 */       break;
/*      */     case 3:
/* 1508 */       strFieldName = "fileDescription";
/* 1509 */       break;
/*      */     case 4:
/* 1511 */       strFieldName = "manageCom";
/* 1512 */       break;
/*      */     case 5:
/* 1514 */       strFieldName = "branchType";
/* 1515 */       break;
/*      */     case 6:
/* 1517 */       strFieldName = "nodeID";
/* 1518 */       break;
/*      */     case 7:
/* 1520 */       strFieldName = "fileType";
/* 1521 */       break;
/*      */     case 8:
/* 1523 */       strFieldName = "filePath";
/* 1524 */       break;
/*      */     case 9:
/* 1526 */       strFieldName = "documentType";
/* 1527 */       break;
/*      */     case 10:
/* 1529 */       strFieldName = "startDisplayDate";
/* 1530 */       break;
/*      */     case 11:
/* 1532 */       strFieldName = "endDisplayDate";
/* 1533 */       break;
/*      */     case 12:
/* 1535 */       strFieldName = "minDisplayGrade";
/* 1536 */       break;
/*      */     case 13:
/* 1538 */       strFieldName = "startDisplayTime";
/* 1539 */       break;
/*      */     case 14:
/* 1541 */       strFieldName = "endDisplayTime";
/* 1542 */       break;
/*      */     case 15:
/* 1544 */       strFieldName = "checkState";
/* 1545 */       break;
/*      */     case 16:
/* 1547 */       strFieldName = "checkOperator";
/* 1548 */       break;
/*      */     case 17:
/* 1550 */       strFieldName = "checkReason";
/* 1551 */       break;
/*      */     case 18:
/* 1553 */       strFieldName = "checkDate";
/* 1554 */       break;
/*      */     case 19:
/* 1556 */       strFieldName = "checkTime";
/* 1557 */       break;
/*      */     case 20:
/* 1559 */       strFieldName = "vF01";
/* 1560 */       break;
/*      */     case 21:
/* 1562 */       strFieldName = "nF01";
/* 1563 */       break;
/*      */     case 22:
/* 1565 */       strFieldName = "iF01";
/* 1566 */       break;
/*      */     case 23:
/* 1568 */       strFieldName = "dF02";
/* 1569 */       break;
/*      */     case 24:
/* 1571 */       strFieldName = "date01";
/* 1572 */       break;
/*      */     case 25:
/* 1574 */       strFieldName = "modifyOperator";
/* 1575 */       break;
/*      */     case 26:
/* 1577 */       strFieldName = "operator";
/* 1578 */       break;
/*      */     case 27:
/* 1580 */       strFieldName = "makeDate";
/* 1581 */       break;
/*      */     case 28:
/* 1583 */       strFieldName = "makeTime";
/* 1584 */       break;
/*      */     case 29:
/* 1586 */       strFieldName = "modifyDate";
/* 1587 */       break;
/*      */     case 30:
/* 1589 */       strFieldName = "modifyTime";
/* 1590 */       break;
/*      */     case 31:
/* 1592 */       strFieldName = "state";
/* 1593 */       break;
/*      */     default:
/* 1595 */       strFieldName = "";
/*      */     }
/* 1597 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1603 */     if (strFieldName.equals("fileID")) {
/* 1604 */       return 0;
/*      */     }
/* 1606 */     if (strFieldName.equals("name")) {
/* 1607 */       return 0;
/*      */     }
/* 1609 */     if (strFieldName.equals("displayName")) {
/* 1610 */       return 0;
/*      */     }
/* 1612 */     if (strFieldName.equals("fileDescription")) {
/* 1613 */       return 0;
/*      */     }
/* 1615 */     if (strFieldName.equals("manageCom")) {
/* 1616 */       return 0;
/*      */     }
/* 1618 */     if (strFieldName.equals("branchType")) {
/* 1619 */       return 0;
/*      */     }
/* 1621 */     if (strFieldName.equals("nodeID")) {
/* 1622 */       return 0;
/*      */     }
/* 1624 */     if (strFieldName.equals("fileType")) {
/* 1625 */       return 0;
/*      */     }
/* 1627 */     if (strFieldName.equals("filePath")) {
/* 1628 */       return 0;
/*      */     }
/* 1630 */     if (strFieldName.equals("documentType")) {
/* 1631 */       return 0;
/*      */     }
/* 1633 */     if (strFieldName.equals("startDisplayDate")) {
/* 1634 */       return 1;
/*      */     }
/* 1636 */     if (strFieldName.equals("endDisplayDate")) {
/* 1637 */       return 1;
/*      */     }
/* 1639 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1640 */       return 0;
/*      */     }
/* 1642 */     if (strFieldName.equals("startDisplayTime")) {
/* 1643 */       return 0;
/*      */     }
/* 1645 */     if (strFieldName.equals("endDisplayTime")) {
/* 1646 */       return 0;
/*      */     }
/* 1648 */     if (strFieldName.equals("checkState")) {
/* 1649 */       return 0;
/*      */     }
/* 1651 */     if (strFieldName.equals("checkOperator")) {
/* 1652 */       return 0;
/*      */     }
/* 1654 */     if (strFieldName.equals("checkReason")) {
/* 1655 */       return 0;
/*      */     }
/* 1657 */     if (strFieldName.equals("checkDate")) {
/* 1658 */       return 1;
/*      */     }
/* 1660 */     if (strFieldName.equals("checkTime")) {
/* 1661 */       return 0;
/*      */     }
/* 1663 */     if (strFieldName.equals("vF01")) {
/* 1664 */       return 0;
/*      */     }
/* 1666 */     if (strFieldName.equals("nF01")) {
/* 1667 */       return 0;
/*      */     }
/* 1669 */     if (strFieldName.equals("iF01")) {
/* 1670 */       return 3;
/*      */     }
/* 1672 */     if (strFieldName.equals("dF02")) {
/* 1673 */       return 4;
/*      */     }
/* 1675 */     if (strFieldName.equals("date01")) {
/* 1676 */       return 1;
/*      */     }
/* 1678 */     if (strFieldName.equals("modifyOperator")) {
/* 1679 */       return 0;
/*      */     }
/* 1681 */     if (strFieldName.equals("operator")) {
/* 1682 */       return 0;
/*      */     }
/* 1684 */     if (strFieldName.equals("makeDate")) {
/* 1685 */       return 1;
/*      */     }
/* 1687 */     if (strFieldName.equals("makeTime")) {
/* 1688 */       return 0;
/*      */     }
/* 1690 */     if (strFieldName.equals("modifyDate")) {
/* 1691 */       return 1;
/*      */     }
/* 1693 */     if (strFieldName.equals("modifyTime")) {
/* 1694 */       return 0;
/*      */     }
/* 1696 */     if (strFieldName.equals("state")) {
/* 1697 */       return 0;
/*      */     }
/* 1699 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1705 */     int nFieldType = -1;
/* 1706 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1708 */       nFieldType = 0;
/* 1709 */       break;
/*      */     case 1:
/* 1711 */       nFieldType = 0;
/* 1712 */       break;
/*      */     case 2:
/* 1714 */       nFieldType = 0;
/* 1715 */       break;
/*      */     case 3:
/* 1717 */       nFieldType = 0;
/* 1718 */       break;
/*      */     case 4:
/* 1720 */       nFieldType = 0;
/* 1721 */       break;
/*      */     case 5:
/* 1723 */       nFieldType = 0;
/* 1724 */       break;
/*      */     case 6:
/* 1726 */       nFieldType = 0;
/* 1727 */       break;
/*      */     case 7:
/* 1729 */       nFieldType = 0;
/* 1730 */       break;
/*      */     case 8:
/* 1732 */       nFieldType = 0;
/* 1733 */       break;
/*      */     case 9:
/* 1735 */       nFieldType = 0;
/* 1736 */       break;
/*      */     case 10:
/* 1738 */       nFieldType = 1;
/* 1739 */       break;
/*      */     case 11:
/* 1741 */       nFieldType = 1;
/* 1742 */       break;
/*      */     case 12:
/* 1744 */       nFieldType = 0;
/* 1745 */       break;
/*      */     case 13:
/* 1747 */       nFieldType = 0;
/* 1748 */       break;
/*      */     case 14:
/* 1750 */       nFieldType = 0;
/* 1751 */       break;
/*      */     case 15:
/* 1753 */       nFieldType = 0;
/* 1754 */       break;
/*      */     case 16:
/* 1756 */       nFieldType = 0;
/* 1757 */       break;
/*      */     case 17:
/* 1759 */       nFieldType = 0;
/* 1760 */       break;
/*      */     case 18:
/* 1762 */       nFieldType = 1;
/* 1763 */       break;
/*      */     case 19:
/* 1765 */       nFieldType = 0;
/* 1766 */       break;
/*      */     case 20:
/* 1768 */       nFieldType = 0;
/* 1769 */       break;
/*      */     case 21:
/* 1771 */       nFieldType = 0;
/* 1772 */       break;
/*      */     case 22:
/* 1774 */       nFieldType = 3;
/* 1775 */       break;
/*      */     case 23:
/* 1777 */       nFieldType = 4;
/* 1778 */       break;
/*      */     case 24:
/* 1780 */       nFieldType = 1;
/* 1781 */       break;
/*      */     case 25:
/* 1783 */       nFieldType = 0;
/* 1784 */       break;
/*      */     case 26:
/* 1786 */       nFieldType = 0;
/* 1787 */       break;
/*      */     case 27:
/* 1789 */       nFieldType = 1;
/* 1790 */       break;
/*      */     case 28:
/* 1792 */       nFieldType = 0;
/* 1793 */       break;
/*      */     case 29:
/* 1795 */       nFieldType = 1;
/* 1796 */       break;
/*      */     case 30:
/* 1798 */       nFieldType = 0;
/* 1799 */       break;
/*      */     case 31:
/* 1801 */       nFieldType = 0;
/* 1802 */       break;
/*      */     default:
/* 1804 */       nFieldType = -1;
/*      */     }
/* 1806 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLibrarySchema
 * JD-Core Version:    0.6.0
 */