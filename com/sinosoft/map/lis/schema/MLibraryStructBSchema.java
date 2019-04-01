/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLibraryStructBDB;
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
/*      */ public class MLibraryStructBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String nodeID;
/*      */   private String name;
/*      */   private String parentID;
/*      */   private String discription;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private int position;
/*      */   private String operation;
/*      */   private String dirFlag;
/*      */   private String fileFlag;
/*      */   private int childDirNum;
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
/*      */   public static final int FIELDNUM = 33;
/*      */   private static String[] PK;
/*   90 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLibraryStructBSchema()
/*      */   {
/*   97 */     this.mErrors = new CErrors();
/*      */ 
/*   99 */     String[] pk = new String[1];
/*  100 */     pk[0] = "EdorNo";
/*      */ 
/*  102 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  109 */     MLibraryStructBSchema cloned = (MLibraryStructBSchema)super.clone();
/*  110 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  111 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  112 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  118 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getNodeID()
/*      */   {
/*  123 */     return this.nodeID;
/*      */   }
/*      */ 
/*      */   public void setNodeID(String aNodeID) {
/*  127 */     this.nodeID = aNodeID;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  131 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  135 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getParentID() {
/*  139 */     return this.parentID;
/*      */   }
/*      */ 
/*      */   public void setParentID(String aParentID) {
/*  143 */     this.parentID = aParentID;
/*      */   }
/*      */ 
/*      */   public String getDiscription() {
/*  147 */     return this.discription;
/*      */   }
/*      */ 
/*      */   public void setDiscription(String aDiscription) {
/*  151 */     this.discription = aDiscription;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  155 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  159 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  163 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  167 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public int getPosition() {
/*  171 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(int aPosition) {
/*  175 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  179 */     if ((aPosition != null) && (!aPosition.equals("")))
/*      */     {
/*  181 */       Integer tInteger = new Integer(aPosition);
/*  182 */       int i = tInteger.intValue();
/*  183 */       this.position = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOperation()
/*      */   {
/*  189 */     return this.operation;
/*      */   }
/*      */ 
/*      */   public void setOperation(String aOperation) {
/*  193 */     this.operation = aOperation;
/*      */   }
/*      */ 
/*      */   public String getDirFlag() {
/*  197 */     return this.dirFlag;
/*      */   }
/*      */ 
/*      */   public void setDirFlag(String aDirFlag) {
/*  201 */     this.dirFlag = aDirFlag;
/*      */   }
/*      */ 
/*      */   public String getFileFlag() {
/*  205 */     return this.fileFlag;
/*      */   }
/*      */ 
/*      */   public void setFileFlag(String aFileFlag) {
/*  209 */     this.fileFlag = aFileFlag;
/*      */   }
/*      */ 
/*      */   public int getChildDirNum() {
/*  213 */     return this.childDirNum;
/*      */   }
/*      */ 
/*      */   public void setChildDirNum(int aChildDirNum) {
/*  217 */     this.childDirNum = aChildDirNum;
/*      */   }
/*      */ 
/*      */   public void setChildDirNum(String aChildDirNum) {
/*  221 */     if ((aChildDirNum != null) && (!aChildDirNum.equals("")))
/*      */     {
/*  223 */       Integer tInteger = new Integer(aChildDirNum);
/*  224 */       int i = tInteger.intValue();
/*  225 */       this.childDirNum = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCheckState()
/*      */   {
/*  231 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  235 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  239 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  243 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  247 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  251 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  255 */     if (this.checkDate != null) {
/*  256 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  258 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  262 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  266 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  268 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  271 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  276 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  280 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  284 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  288 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  292 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  296 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  300 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  304 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  308 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  310 */       Integer tInteger = new Integer(aIF01);
/*  311 */       int i = tInteger.intValue();
/*  312 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  318 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  322 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  326 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  328 */       Double tDouble = new Double(aDF02);
/*  329 */       double d = tDouble.doubleValue();
/*  330 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  336 */     if (this.date01 != null) {
/*  337 */       return this.fDate.getString(this.date01);
/*      */     }
/*  339 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  343 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  347 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  349 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  352 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  357 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  361 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  365 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  369 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  373 */     if (this.makeDate != null) {
/*  374 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  376 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  380 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  384 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  386 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  389 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  394 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  398 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  402 */     if (this.modifyDate != null) {
/*  403 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  405 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  409 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  413 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  415 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  418 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  423 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  427 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getEdorNo() {
/*  431 */     return this.edorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  435 */     this.edorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getEdorType() {
/*  439 */     return this.edorType;
/*      */   }
/*      */ 
/*      */   public void setEdorType(String aEdorType) {
/*  443 */     this.edorType = aEdorType;
/*      */   }
/*      */ 
/*      */   public String getEdorCase() {
/*  447 */     return this.edorCase;
/*      */   }
/*      */ 
/*      */   public void setEdorCase(String aEdorCase) {
/*  451 */     this.edorCase = aEdorCase;
/*      */   }
/*      */ 
/*      */   public String getOperator2() {
/*  455 */     return this.operator2;
/*      */   }
/*      */ 
/*      */   public void setOperator2(String aOperator2) {
/*  459 */     this.operator2 = aOperator2;
/*      */   }
/*      */ 
/*      */   public String getMakeDate2() {
/*  463 */     if (this.makeDate2 != null) {
/*  464 */       return this.fDate.getString(this.makeDate2);
/*      */     }
/*  466 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(Date aMakeDate2) {
/*  470 */     this.makeDate2 = aMakeDate2;
/*      */   }
/*      */ 
/*      */   public void setMakeDate2(String aMakeDate2) {
/*  474 */     if ((aMakeDate2 != null) && (!aMakeDate2.equals("")))
/*      */     {
/*  476 */       this.makeDate2 = this.fDate.getDate(aMakeDate2);
/*      */     }
/*      */     else
/*  479 */       this.makeDate2 = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime2()
/*      */   {
/*  484 */     return this.makeTime2;
/*      */   }
/*      */ 
/*      */   public void setMakeTime2(String aMakeTime2) {
/*  488 */     this.makeTime2 = aMakeTime2;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLibraryStructBSchema aMLibraryStructBSchema)
/*      */   {
/*  494 */     this.nodeID = aMLibraryStructBSchema.getNodeID();
/*  495 */     this.name = aMLibraryStructBSchema.getName();
/*  496 */     this.parentID = aMLibraryStructBSchema.getParentID();
/*  497 */     this.discription = aMLibraryStructBSchema.getDiscription();
/*  498 */     this.manageCom = aMLibraryStructBSchema.getManageCom();
/*  499 */     this.branchType = aMLibraryStructBSchema.getBranchType();
/*  500 */     this.position = aMLibraryStructBSchema.getPosition();
/*  501 */     this.operation = aMLibraryStructBSchema.getOperation();
/*  502 */     this.dirFlag = aMLibraryStructBSchema.getDirFlag();
/*  503 */     this.fileFlag = aMLibraryStructBSchema.getFileFlag();
/*  504 */     this.childDirNum = aMLibraryStructBSchema.getChildDirNum();
/*  505 */     this.checkState = aMLibraryStructBSchema.getCheckState();
/*  506 */     this.checkOperator = aMLibraryStructBSchema.getCheckOperator();
/*  507 */     this.checkReason = aMLibraryStructBSchema.getCheckReason();
/*  508 */     this.checkDate = this.fDate.getDate(aMLibraryStructBSchema.getCheckDate());
/*  509 */     this.checkTime = aMLibraryStructBSchema.getCheckTime();
/*  510 */     this.vF01 = aMLibraryStructBSchema.getVF01();
/*  511 */     this.nF01 = aMLibraryStructBSchema.getNF01();
/*  512 */     this.iF01 = aMLibraryStructBSchema.getIF01();
/*  513 */     this.dF02 = aMLibraryStructBSchema.getDF02();
/*  514 */     this.date01 = this.fDate.getDate(aMLibraryStructBSchema.getDate01());
/*  515 */     this.modifyOperator = aMLibraryStructBSchema.getModifyOperator();
/*  516 */     this.operator = aMLibraryStructBSchema.getOperator();
/*  517 */     this.makeDate = this.fDate.getDate(aMLibraryStructBSchema.getMakeDate());
/*  518 */     this.makeTime = aMLibraryStructBSchema.getMakeTime();
/*  519 */     this.modifyDate = this.fDate.getDate(aMLibraryStructBSchema.getModifyDate());
/*  520 */     this.modifyTime = aMLibraryStructBSchema.getModifyTime();
/*  521 */     this.edorNo = aMLibraryStructBSchema.getEdorNo();
/*  522 */     this.edorType = aMLibraryStructBSchema.getEdorType();
/*  523 */     this.edorCase = aMLibraryStructBSchema.getEdorCase();
/*  524 */     this.operator2 = aMLibraryStructBSchema.getOperator2();
/*  525 */     this.makeDate2 = this.fDate.getDate(aMLibraryStructBSchema.getMakeDate2());
/*  526 */     this.makeTime2 = aMLibraryStructBSchema.getMakeTime2();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  535 */       if (rs.getString("NodeID") == null)
/*  536 */         this.nodeID = null;
/*      */       else {
/*  538 */         this.nodeID = rs.getString("NodeID").trim();
/*      */       }
/*  540 */       if (rs.getString("Name") == null)
/*  541 */         this.name = null;
/*      */       else {
/*  543 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  545 */       if (rs.getString("ParentID") == null)
/*  546 */         this.parentID = null;
/*      */       else {
/*  548 */         this.parentID = rs.getString("ParentID").trim();
/*      */       }
/*  550 */       if (rs.getString("Discription") == null)
/*  551 */         this.discription = null;
/*      */       else {
/*  553 */         this.discription = rs.getString("Discription").trim();
/*      */       }
/*  555 */       if (rs.getString("ManageCom") == null)
/*  556 */         this.manageCom = null;
/*      */       else {
/*  558 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  560 */       if (rs.getString("BranchType") == null)
/*  561 */         this.branchType = null;
/*      */       else {
/*  563 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  565 */       this.position = rs.getInt("Position");
/*  566 */       if (rs.getString("Operation") == null)
/*  567 */         this.operation = null;
/*      */       else {
/*  569 */         this.operation = rs.getString("Operation").trim();
/*      */       }
/*  571 */       if (rs.getString("DirFlag") == null)
/*  572 */         this.dirFlag = null;
/*      */       else {
/*  574 */         this.dirFlag = rs.getString("DirFlag").trim();
/*      */       }
/*  576 */       if (rs.getString("FileFlag") == null)
/*  577 */         this.fileFlag = null;
/*      */       else {
/*  579 */         this.fileFlag = rs.getString("FileFlag").trim();
/*      */       }
/*  581 */       this.childDirNum = rs.getInt("ChildDirNum");
/*  582 */       if (rs.getString("CheckState") == null)
/*  583 */         this.checkState = null;
/*      */       else {
/*  585 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  587 */       if (rs.getString("CheckOperator") == null)
/*  588 */         this.checkOperator = null;
/*      */       else {
/*  590 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  592 */       if (rs.getString("CheckReason") == null)
/*  593 */         this.checkReason = null;
/*      */       else {
/*  595 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  597 */       this.checkDate = rs.getDate("CheckDate");
/*  598 */       if (rs.getString("CheckTime") == null)
/*  599 */         this.checkTime = null;
/*      */       else {
/*  601 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  603 */       if (rs.getString("VF01") == null)
/*  604 */         this.vF01 = null;
/*      */       else {
/*  606 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  608 */       if (rs.getString("NF01") == null)
/*  609 */         this.nF01 = null;
/*      */       else {
/*  611 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  613 */       this.iF01 = rs.getInt("IF01");
/*  614 */       this.dF02 = rs.getDouble("DF02");
/*  615 */       this.date01 = rs.getDate("Date01");
/*  616 */       if (rs.getString("ModifyOperator") == null)
/*  617 */         this.modifyOperator = null;
/*      */       else {
/*  619 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  621 */       if (rs.getString("Operator") == null)
/*  622 */         this.operator = null;
/*      */       else {
/*  624 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  626 */       this.makeDate = rs.getDate("MakeDate");
/*  627 */       if (rs.getString("MakeTime") == null)
/*  628 */         this.makeTime = null;
/*      */       else {
/*  630 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  632 */       this.modifyDate = rs.getDate("ModifyDate");
/*  633 */       if (rs.getString("ModifyTime") == null)
/*  634 */         this.modifyTime = null;
/*      */       else {
/*  636 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  638 */       if (rs.getString("EdorNo") == null)
/*  639 */         this.edorNo = null;
/*      */       else {
/*  641 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  643 */       if (rs.getString("EdorType") == null)
/*  644 */         this.edorType = null;
/*      */       else {
/*  646 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  648 */       if (rs.getString("EdorCase") == null)
/*  649 */         this.edorCase = null;
/*      */       else {
/*  651 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  653 */       if (rs.getString("Operator2") == null)
/*  654 */         this.operator2 = null;
/*      */       else {
/*  656 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  658 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  659 */       if (rs.getString("MakeTime2") == null)
/*  660 */         this.makeTime2 = null;
/*      */       else {
/*  662 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  667 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLibraryStructB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  669 */       CError tError = new CError();
/*  670 */       tError.moduleName = "MLibraryStructBSchema";
/*  671 */       tError.functionName = "setSchema";
/*  672 */       tError.errorMessage = sqle.toString();
/*  673 */       this.mErrors.addOneError(tError);
/*  674 */       return false;
/*      */     }
/*  676 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBSchema getSchema()
/*      */   {
/*  681 */     MLibraryStructBSchema aMLibraryStructBSchema = new MLibraryStructBSchema();
/*  682 */     aMLibraryStructBSchema.setSchema(this);
/*  683 */     return aMLibraryStructBSchema;
/*      */   }
/*      */ 
/*      */   public MLibraryStructBDB getDB()
/*      */   {
/*  688 */     MLibraryStructBDB aDBOper = new MLibraryStructBDB();
/*  689 */     aDBOper.setSchema(this);
/*  690 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  697 */     StringBuffer strReturn = new StringBuffer(256);
/*  698 */     strReturn.append(StrTool.cTrim(this.nodeID)); strReturn.append("|");
/*  699 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  700 */     strReturn.append(StrTool.cTrim(this.parentID)); strReturn.append("|");
/*  701 */     strReturn.append(StrTool.cTrim(this.discription)); strReturn.append("|");
/*  702 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  703 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  704 */     strReturn.append(ChgData.chgData(this.position)); strReturn.append("|");
/*  705 */     strReturn.append(StrTool.cTrim(this.operation)); strReturn.append("|");
/*  706 */     strReturn.append(StrTool.cTrim(this.dirFlag)); strReturn.append("|");
/*  707 */     strReturn.append(StrTool.cTrim(this.fileFlag)); strReturn.append("|");
/*  708 */     strReturn.append(ChgData.chgData(this.childDirNum)); strReturn.append("|");
/*  709 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  710 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  711 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  712 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  713 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  714 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  715 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  716 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  717 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  718 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  719 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  720 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  721 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  722 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  723 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  724 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  725 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  726 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  727 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  728 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  729 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  730 */     strReturn.append(StrTool.cTrim(this.makeTime2));
/*  731 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  739 */       this.nodeID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  740 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  741 */       this.parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  742 */       this.discription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  743 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  744 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  745 */       this.position = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  746 */       this.operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  747 */       this.dirFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  748 */       this.fileFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  749 */       this.childDirNum = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  750 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  751 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  752 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  753 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  754 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  755 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  756 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  757 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).intValue();
/*  758 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/*  759 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  760 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  761 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  762 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  763 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  764 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  765 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  766 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  767 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  768 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  769 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  770 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|"));
/*  771 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  776 */       CError tError = new CError();
/*  777 */       tError.moduleName = "MLibraryStructBSchema";
/*  778 */       tError.functionName = "decode";
/*  779 */       tError.errorMessage = ex.toString();
/*  780 */       this.mErrors.addOneError(tError);
/*      */ 
/*  782 */       return false;
/*      */     }
/*  784 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  790 */     String strReturn = "";
/*  791 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/*  793 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeID));
/*      */     }
/*  795 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  797 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  799 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  801 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentID));
/*      */     }
/*  803 */     if (FCode.equalsIgnoreCase("discription"))
/*      */     {
/*  805 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.discription));
/*      */     }
/*  807 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  809 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  811 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  813 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  815 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/*  817 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("operation"))
/*      */     {
/*  821 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operation));
/*      */     }
/*  823 */     if (FCode.equalsIgnoreCase("dirFlag"))
/*      */     {
/*  825 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dirFlag));
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("fileFlag"))
/*      */     {
/*  829 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileFlag));
/*      */     }
/*  831 */     if (FCode.equalsIgnoreCase("childDirNum"))
/*      */     {
/*  833 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childDirNum));
/*      */     }
/*  835 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  837 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  839 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  841 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  843 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  845 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  847 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  849 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  853 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  857 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  859 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  861 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  863 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  865 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  867 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  869 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  871 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  873 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  875 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  877 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  879 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  881 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  883 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  885 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  889 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  891 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  893 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  895 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  897 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  899 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/*  901 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorNo));
/*      */     }
/*  903 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/*  905 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorType));
/*      */     }
/*  907 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/*  909 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.edorCase));
/*      */     }
/*  911 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/*  913 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator2));
/*      */     }
/*  915 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/*  917 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/*  921 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime2));
/*      */     }
/*  923 */     if (strReturn.equals(""))
/*      */     {
/*  925 */       strReturn = "null";
/*      */     }
/*      */ 
/*  928 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  935 */     String strFieldValue = "";
/*  936 */     switch (nFieldIndex) {
/*      */     case 0:
/*  938 */       strFieldValue = StrTool.GBKToUnicode(this.nodeID);
/*  939 */       break;
/*      */     case 1:
/*  941 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  942 */       break;
/*      */     case 2:
/*  944 */       strFieldValue = StrTool.GBKToUnicode(this.parentID);
/*  945 */       break;
/*      */     case 3:
/*  947 */       strFieldValue = StrTool.GBKToUnicode(this.discription);
/*  948 */       break;
/*      */     case 4:
/*  950 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  951 */       break;
/*      */     case 5:
/*  953 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  954 */       break;
/*      */     case 6:
/*  956 */       strFieldValue = String.valueOf(this.position);
/*  957 */       break;
/*      */     case 7:
/*  959 */       strFieldValue = StrTool.GBKToUnicode(this.operation);
/*  960 */       break;
/*      */     case 8:
/*  962 */       strFieldValue = StrTool.GBKToUnicode(this.dirFlag);
/*  963 */       break;
/*      */     case 9:
/*  965 */       strFieldValue = StrTool.GBKToUnicode(this.fileFlag);
/*  966 */       break;
/*      */     case 10:
/*  968 */       strFieldValue = String.valueOf(this.childDirNum);
/*  969 */       break;
/*      */     case 11:
/*  971 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  972 */       break;
/*      */     case 12:
/*  974 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  975 */       break;
/*      */     case 13:
/*  977 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  978 */       break;
/*      */     case 14:
/*  980 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  981 */       break;
/*      */     case 15:
/*  983 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  984 */       break;
/*      */     case 16:
/*  986 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  987 */       break;
/*      */     case 17:
/*  989 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  990 */       break;
/*      */     case 18:
/*  992 */       strFieldValue = String.valueOf(this.iF01);
/*  993 */       break;
/*      */     case 19:
/*  995 */       strFieldValue = String.valueOf(this.dF02);
/*  996 */       break;
/*      */     case 20:
/*  998 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  999 */       break;
/*      */     case 21:
/* 1001 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1002 */       break;
/*      */     case 22:
/* 1004 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1005 */       break;
/*      */     case 23:
/* 1007 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1008 */       break;
/*      */     case 24:
/* 1010 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1011 */       break;
/*      */     case 25:
/* 1013 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1014 */       break;
/*      */     case 26:
/* 1016 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1017 */       break;
/*      */     case 27:
/* 1019 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/* 1020 */       break;
/*      */     case 28:
/* 1022 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/* 1023 */       break;
/*      */     case 29:
/* 1025 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/* 1026 */       break;
/*      */     case 30:
/* 1028 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/* 1029 */       break;
/*      */     case 31:
/* 1031 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/* 1032 */       break;
/*      */     case 32:
/* 1034 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/* 1035 */       break;
/*      */     default:
/* 1037 */       strFieldValue = "";
/*      */     }
/* 1039 */     if (strFieldValue.equals("")) {
/* 1040 */       strFieldValue = "null";
/*      */     }
/* 1042 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1048 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1049 */       return false;
/*      */     }
/* 1051 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/* 1053 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1055 */         this.nodeID = FValue.trim();
/*      */       }
/*      */       else
/* 1058 */         this.nodeID = null;
/*      */     }
/* 1060 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/* 1062 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1064 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/* 1067 */         this.name = null;
/*      */     }
/* 1069 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/* 1071 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1073 */         this.parentID = FValue.trim();
/*      */       }
/*      */       else
/* 1076 */         this.parentID = null;
/*      */     }
/* 1078 */     if (FCode.equalsIgnoreCase("discription"))
/*      */     {
/* 1080 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1082 */         this.discription = FValue.trim();
/*      */       }
/*      */       else
/* 1085 */         this.discription = null;
/*      */     }
/* 1087 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1089 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1091 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1094 */         this.manageCom = null;
/*      */     }
/* 1096 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1098 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1100 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1103 */         this.branchType = null;
/*      */     }
/* 1105 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/* 1107 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1109 */         Integer tInteger = new Integer(FValue);
/* 1110 */         int i = tInteger.intValue();
/* 1111 */         this.position = i;
/*      */       }
/*      */     }
/* 1114 */     if (FCode.equalsIgnoreCase("operation"))
/*      */     {
/* 1116 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1118 */         this.operation = FValue.trim();
/*      */       }
/*      */       else
/* 1121 */         this.operation = null;
/*      */     }
/* 1123 */     if (FCode.equalsIgnoreCase("dirFlag"))
/*      */     {
/* 1125 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1127 */         this.dirFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1130 */         this.dirFlag = null;
/*      */     }
/* 1132 */     if (FCode.equalsIgnoreCase("fileFlag"))
/*      */     {
/* 1134 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1136 */         this.fileFlag = FValue.trim();
/*      */       }
/*      */       else
/* 1139 */         this.fileFlag = null;
/*      */     }
/* 1141 */     if (FCode.equalsIgnoreCase("childDirNum"))
/*      */     {
/* 1143 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1145 */         Integer tInteger = new Integer(FValue);
/* 1146 */         int i = tInteger.intValue();
/* 1147 */         this.childDirNum = i;
/*      */       }
/*      */     }
/* 1150 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1152 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1154 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1157 */         this.checkState = null;
/*      */     }
/* 1159 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1161 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1163 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1166 */         this.checkOperator = null;
/*      */     }
/* 1168 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1170 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1172 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1175 */         this.checkReason = null;
/*      */     }
/* 1177 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1179 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1181 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1184 */         this.checkDate = null;
/*      */     }
/* 1186 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1188 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1190 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1193 */         this.checkTime = null;
/*      */     }
/* 1195 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1197 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1199 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1202 */         this.vF01 = null;
/*      */     }
/* 1204 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1206 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1208 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1211 */         this.nF01 = null;
/*      */     }
/* 1213 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1215 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1217 */         Integer tInteger = new Integer(FValue);
/* 1218 */         int i = tInteger.intValue();
/* 1219 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1222 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1224 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1226 */         Double tDouble = new Double(FValue);
/* 1227 */         double d = tDouble.doubleValue();
/* 1228 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1231 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1233 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1235 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1238 */         this.date01 = null;
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1242 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1244 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1247 */         this.modifyOperator = null;
/*      */     }
/* 1249 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1251 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1253 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1256 */         this.operator = null;
/*      */     }
/* 1258 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1260 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1262 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1265 */         this.makeDate = null;
/*      */     }
/* 1267 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1269 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1271 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1274 */         this.makeTime = null;
/*      */     }
/* 1276 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1278 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1280 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1283 */         this.modifyDate = null;
/*      */     }
/* 1285 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1287 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1289 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1292 */         this.modifyTime = null;
/*      */     }
/* 1294 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1296 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1298 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1301 */         this.edorNo = null;
/*      */     }
/* 1303 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1305 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1307 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1310 */         this.edorType = null;
/*      */     }
/* 1312 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1314 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1316 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1319 */         this.edorCase = null;
/*      */     }
/* 1321 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1323 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1325 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1328 */         this.operator2 = null;
/*      */     }
/* 1330 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1332 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1334 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1337 */         this.makeDate2 = null;
/*      */     }
/* 1339 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1341 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1343 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1346 */         this.makeTime2 = null;
/*      */     }
/* 1348 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1353 */     if (otherObject == null) return false;
/* 1354 */     if (this == otherObject) return true;
/* 1355 */     if (getClass() != otherObject.getClass()) return false;
/* 1356 */     MLibraryStructBSchema other = (MLibraryStructBSchema)otherObject;
/* 1357 */     if ((this.nodeID == null) && (other.getNodeID() != null)) return false;
/* 1358 */     if ((this.nodeID != null) && (!this.nodeID.equals(other.getNodeID()))) return false;
/* 1359 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1360 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1361 */     if ((this.parentID == null) && (other.getParentID() != null)) return false;
/* 1362 */     if ((this.parentID != null) && (!this.parentID.equals(other.getParentID()))) return false;
/* 1363 */     if ((this.discription == null) && (other.getDiscription() != null)) return false;
/* 1364 */     if ((this.discription != null) && (!this.discription.equals(other.getDiscription()))) return false;
/* 1365 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1366 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1367 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1368 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1369 */     if (this.position != other.getPosition()) return false;
/* 1370 */     if ((this.operation == null) && (other.getOperation() != null)) return false;
/* 1371 */     if ((this.operation != null) && (!this.operation.equals(other.getOperation()))) return false;
/* 1372 */     if ((this.dirFlag == null) && (other.getDirFlag() != null)) return false;
/* 1373 */     if ((this.dirFlag != null) && (!this.dirFlag.equals(other.getDirFlag()))) return false;
/* 1374 */     if ((this.fileFlag == null) && (other.getFileFlag() != null)) return false;
/* 1375 */     if ((this.fileFlag != null) && (!this.fileFlag.equals(other.getFileFlag()))) return false;
/* 1376 */     if (this.childDirNum != other.getChildDirNum()) return false;
/* 1377 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1378 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1379 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1380 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1381 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1382 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1383 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1384 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1385 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1386 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1387 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1388 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1389 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1390 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1391 */     if (this.iF01 != other.getIF01()) return false;
/* 1392 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1393 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1394 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1395 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1396 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1397 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1398 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1399 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1400 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1401 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1402 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1403 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1404 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1405 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1406 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1407 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1408 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1409 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1410 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1411 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1412 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1413 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1414 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1415 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1416 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1417 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1418 */     return (this.makeTime2 == null) || (this.makeTime2.equals(other.getMakeTime2()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1425 */     return 33;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1431 */     if (strFieldName.equals("nodeID")) {
/* 1432 */       return 0;
/*      */     }
/* 1434 */     if (strFieldName.equals("name")) {
/* 1435 */       return 1;
/*      */     }
/* 1437 */     if (strFieldName.equals("parentID")) {
/* 1438 */       return 2;
/*      */     }
/* 1440 */     if (strFieldName.equals("discription")) {
/* 1441 */       return 3;
/*      */     }
/* 1443 */     if (strFieldName.equals("manageCom")) {
/* 1444 */       return 4;
/*      */     }
/* 1446 */     if (strFieldName.equals("branchType")) {
/* 1447 */       return 5;
/*      */     }
/* 1449 */     if (strFieldName.equals("position")) {
/* 1450 */       return 6;
/*      */     }
/* 1452 */     if (strFieldName.equals("operation")) {
/* 1453 */       return 7;
/*      */     }
/* 1455 */     if (strFieldName.equals("dirFlag")) {
/* 1456 */       return 8;
/*      */     }
/* 1458 */     if (strFieldName.equals("fileFlag")) {
/* 1459 */       return 9;
/*      */     }
/* 1461 */     if (strFieldName.equals("childDirNum")) {
/* 1462 */       return 10;
/*      */     }
/* 1464 */     if (strFieldName.equals("checkState")) {
/* 1465 */       return 11;
/*      */     }
/* 1467 */     if (strFieldName.equals("checkOperator")) {
/* 1468 */       return 12;
/*      */     }
/* 1470 */     if (strFieldName.equals("checkReason")) {
/* 1471 */       return 13;
/*      */     }
/* 1473 */     if (strFieldName.equals("checkDate")) {
/* 1474 */       return 14;
/*      */     }
/* 1476 */     if (strFieldName.equals("checkTime")) {
/* 1477 */       return 15;
/*      */     }
/* 1479 */     if (strFieldName.equals("vF01")) {
/* 1480 */       return 16;
/*      */     }
/* 1482 */     if (strFieldName.equals("nF01")) {
/* 1483 */       return 17;
/*      */     }
/* 1485 */     if (strFieldName.equals("iF01")) {
/* 1486 */       return 18;
/*      */     }
/* 1488 */     if (strFieldName.equals("dF02")) {
/* 1489 */       return 19;
/*      */     }
/* 1491 */     if (strFieldName.equals("date01")) {
/* 1492 */       return 20;
/*      */     }
/* 1494 */     if (strFieldName.equals("modifyOperator")) {
/* 1495 */       return 21;
/*      */     }
/* 1497 */     if (strFieldName.equals("operator")) {
/* 1498 */       return 22;
/*      */     }
/* 1500 */     if (strFieldName.equals("makeDate")) {
/* 1501 */       return 23;
/*      */     }
/* 1503 */     if (strFieldName.equals("makeTime")) {
/* 1504 */       return 24;
/*      */     }
/* 1506 */     if (strFieldName.equals("modifyDate")) {
/* 1507 */       return 25;
/*      */     }
/* 1509 */     if (strFieldName.equals("modifyTime")) {
/* 1510 */       return 26;
/*      */     }
/* 1512 */     if (strFieldName.equals("edorNo")) {
/* 1513 */       return 27;
/*      */     }
/* 1515 */     if (strFieldName.equals("edorType")) {
/* 1516 */       return 28;
/*      */     }
/* 1518 */     if (strFieldName.equals("edorCase")) {
/* 1519 */       return 29;
/*      */     }
/* 1521 */     if (strFieldName.equals("operator2")) {
/* 1522 */       return 30;
/*      */     }
/* 1524 */     if (strFieldName.equals("makeDate2")) {
/* 1525 */       return 31;
/*      */     }
/* 1527 */     if (strFieldName.equals("makeTime2")) {
/* 1528 */       return 32;
/*      */     }
/* 1530 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1536 */     String strFieldName = "";
/* 1537 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1539 */       strFieldName = "nodeID";
/* 1540 */       break;
/*      */     case 1:
/* 1542 */       strFieldName = "name";
/* 1543 */       break;
/*      */     case 2:
/* 1545 */       strFieldName = "parentID";
/* 1546 */       break;
/*      */     case 3:
/* 1548 */       strFieldName = "discription";
/* 1549 */       break;
/*      */     case 4:
/* 1551 */       strFieldName = "manageCom";
/* 1552 */       break;
/*      */     case 5:
/* 1554 */       strFieldName = "branchType";
/* 1555 */       break;
/*      */     case 6:
/* 1557 */       strFieldName = "position";
/* 1558 */       break;
/*      */     case 7:
/* 1560 */       strFieldName = "operation";
/* 1561 */       break;
/*      */     case 8:
/* 1563 */       strFieldName = "dirFlag";
/* 1564 */       break;
/*      */     case 9:
/* 1566 */       strFieldName = "fileFlag";
/* 1567 */       break;
/*      */     case 10:
/* 1569 */       strFieldName = "childDirNum";
/* 1570 */       break;
/*      */     case 11:
/* 1572 */       strFieldName = "checkState";
/* 1573 */       break;
/*      */     case 12:
/* 1575 */       strFieldName = "checkOperator";
/* 1576 */       break;
/*      */     case 13:
/* 1578 */       strFieldName = "checkReason";
/* 1579 */       break;
/*      */     case 14:
/* 1581 */       strFieldName = "checkDate";
/* 1582 */       break;
/*      */     case 15:
/* 1584 */       strFieldName = "checkTime";
/* 1585 */       break;
/*      */     case 16:
/* 1587 */       strFieldName = "vF01";
/* 1588 */       break;
/*      */     case 17:
/* 1590 */       strFieldName = "nF01";
/* 1591 */       break;
/*      */     case 18:
/* 1593 */       strFieldName = "iF01";
/* 1594 */       break;
/*      */     case 19:
/* 1596 */       strFieldName = "dF02";
/* 1597 */       break;
/*      */     case 20:
/* 1599 */       strFieldName = "date01";
/* 1600 */       break;
/*      */     case 21:
/* 1602 */       strFieldName = "modifyOperator";
/* 1603 */       break;
/*      */     case 22:
/* 1605 */       strFieldName = "operator";
/* 1606 */       break;
/*      */     case 23:
/* 1608 */       strFieldName = "makeDate";
/* 1609 */       break;
/*      */     case 24:
/* 1611 */       strFieldName = "makeTime";
/* 1612 */       break;
/*      */     case 25:
/* 1614 */       strFieldName = "modifyDate";
/* 1615 */       break;
/*      */     case 26:
/* 1617 */       strFieldName = "modifyTime";
/* 1618 */       break;
/*      */     case 27:
/* 1620 */       strFieldName = "edorNo";
/* 1621 */       break;
/*      */     case 28:
/* 1623 */       strFieldName = "edorType";
/* 1624 */       break;
/*      */     case 29:
/* 1626 */       strFieldName = "edorCase";
/* 1627 */       break;
/*      */     case 30:
/* 1629 */       strFieldName = "operator2";
/* 1630 */       break;
/*      */     case 31:
/* 1632 */       strFieldName = "makeDate2";
/* 1633 */       break;
/*      */     case 32:
/* 1635 */       strFieldName = "makeTime2";
/* 1636 */       break;
/*      */     default:
/* 1638 */       strFieldName = "";
/*      */     }
/* 1640 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1646 */     if (strFieldName.equals("nodeID")) {
/* 1647 */       return 0;
/*      */     }
/* 1649 */     if (strFieldName.equals("name")) {
/* 1650 */       return 0;
/*      */     }
/* 1652 */     if (strFieldName.equals("parentID")) {
/* 1653 */       return 0;
/*      */     }
/* 1655 */     if (strFieldName.equals("discription")) {
/* 1656 */       return 0;
/*      */     }
/* 1658 */     if (strFieldName.equals("manageCom")) {
/* 1659 */       return 0;
/*      */     }
/* 1661 */     if (strFieldName.equals("branchType")) {
/* 1662 */       return 0;
/*      */     }
/* 1664 */     if (strFieldName.equals("position")) {
/* 1665 */       return 3;
/*      */     }
/* 1667 */     if (strFieldName.equals("operation")) {
/* 1668 */       return 0;
/*      */     }
/* 1670 */     if (strFieldName.equals("dirFlag")) {
/* 1671 */       return 0;
/*      */     }
/* 1673 */     if (strFieldName.equals("fileFlag")) {
/* 1674 */       return 0;
/*      */     }
/* 1676 */     if (strFieldName.equals("childDirNum")) {
/* 1677 */       return 3;
/*      */     }
/* 1679 */     if (strFieldName.equals("checkState")) {
/* 1680 */       return 0;
/*      */     }
/* 1682 */     if (strFieldName.equals("checkOperator")) {
/* 1683 */       return 0;
/*      */     }
/* 1685 */     if (strFieldName.equals("checkReason")) {
/* 1686 */       return 0;
/*      */     }
/* 1688 */     if (strFieldName.equals("checkDate")) {
/* 1689 */       return 1;
/*      */     }
/* 1691 */     if (strFieldName.equals("checkTime")) {
/* 1692 */       return 0;
/*      */     }
/* 1694 */     if (strFieldName.equals("vF01")) {
/* 1695 */       return 0;
/*      */     }
/* 1697 */     if (strFieldName.equals("nF01")) {
/* 1698 */       return 0;
/*      */     }
/* 1700 */     if (strFieldName.equals("iF01")) {
/* 1701 */       return 3;
/*      */     }
/* 1703 */     if (strFieldName.equals("dF02")) {
/* 1704 */       return 4;
/*      */     }
/* 1706 */     if (strFieldName.equals("date01")) {
/* 1707 */       return 1;
/*      */     }
/* 1709 */     if (strFieldName.equals("modifyOperator")) {
/* 1710 */       return 0;
/*      */     }
/* 1712 */     if (strFieldName.equals("operator")) {
/* 1713 */       return 0;
/*      */     }
/* 1715 */     if (strFieldName.equals("makeDate")) {
/* 1716 */       return 1;
/*      */     }
/* 1718 */     if (strFieldName.equals("makeTime")) {
/* 1719 */       return 0;
/*      */     }
/* 1721 */     if (strFieldName.equals("modifyDate")) {
/* 1722 */       return 1;
/*      */     }
/* 1724 */     if (strFieldName.equals("modifyTime")) {
/* 1725 */       return 0;
/*      */     }
/* 1727 */     if (strFieldName.equals("edorNo")) {
/* 1728 */       return 0;
/*      */     }
/* 1730 */     if (strFieldName.equals("edorType")) {
/* 1731 */       return 0;
/*      */     }
/* 1733 */     if (strFieldName.equals("edorCase")) {
/* 1734 */       return 0;
/*      */     }
/* 1736 */     if (strFieldName.equals("operator2")) {
/* 1737 */       return 0;
/*      */     }
/* 1739 */     if (strFieldName.equals("makeDate2")) {
/* 1740 */       return 1;
/*      */     }
/* 1742 */     if (strFieldName.equals("makeTime2")) {
/* 1743 */       return 0;
/*      */     }
/* 1745 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1751 */     int nFieldType = -1;
/* 1752 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1754 */       nFieldType = 0;
/* 1755 */       break;
/*      */     case 1:
/* 1757 */       nFieldType = 0;
/* 1758 */       break;
/*      */     case 2:
/* 1760 */       nFieldType = 0;
/* 1761 */       break;
/*      */     case 3:
/* 1763 */       nFieldType = 0;
/* 1764 */       break;
/*      */     case 4:
/* 1766 */       nFieldType = 0;
/* 1767 */       break;
/*      */     case 5:
/* 1769 */       nFieldType = 0;
/* 1770 */       break;
/*      */     case 6:
/* 1772 */       nFieldType = 3;
/* 1773 */       break;
/*      */     case 7:
/* 1775 */       nFieldType = 0;
/* 1776 */       break;
/*      */     case 8:
/* 1778 */       nFieldType = 0;
/* 1779 */       break;
/*      */     case 9:
/* 1781 */       nFieldType = 0;
/* 1782 */       break;
/*      */     case 10:
/* 1784 */       nFieldType = 3;
/* 1785 */       break;
/*      */     case 11:
/* 1787 */       nFieldType = 0;
/* 1788 */       break;
/*      */     case 12:
/* 1790 */       nFieldType = 0;
/* 1791 */       break;
/*      */     case 13:
/* 1793 */       nFieldType = 0;
/* 1794 */       break;
/*      */     case 14:
/* 1796 */       nFieldType = 1;
/* 1797 */       break;
/*      */     case 15:
/* 1799 */       nFieldType = 0;
/* 1800 */       break;
/*      */     case 16:
/* 1802 */       nFieldType = 0;
/* 1803 */       break;
/*      */     case 17:
/* 1805 */       nFieldType = 0;
/* 1806 */       break;
/*      */     case 18:
/* 1808 */       nFieldType = 3;
/* 1809 */       break;
/*      */     case 19:
/* 1811 */       nFieldType = 4;
/* 1812 */       break;
/*      */     case 20:
/* 1814 */       nFieldType = 1;
/* 1815 */       break;
/*      */     case 21:
/* 1817 */       nFieldType = 0;
/* 1818 */       break;
/*      */     case 22:
/* 1820 */       nFieldType = 0;
/* 1821 */       break;
/*      */     case 23:
/* 1823 */       nFieldType = 1;
/* 1824 */       break;
/*      */     case 24:
/* 1826 */       nFieldType = 0;
/* 1827 */       break;
/*      */     case 25:
/* 1829 */       nFieldType = 1;
/* 1830 */       break;
/*      */     case 26:
/* 1832 */       nFieldType = 0;
/* 1833 */       break;
/*      */     case 27:
/* 1835 */       nFieldType = 0;
/* 1836 */       break;
/*      */     case 28:
/* 1838 */       nFieldType = 0;
/* 1839 */       break;
/*      */     case 29:
/* 1841 */       nFieldType = 0;
/* 1842 */       break;
/*      */     case 30:
/* 1844 */       nFieldType = 0;
/* 1845 */       break;
/*      */     case 31:
/* 1847 */       nFieldType = 1;
/* 1848 */       break;
/*      */     case 32:
/* 1850 */       nFieldType = 0;
/* 1851 */       break;
/*      */     default:
/* 1853 */       nFieldType = -1;
/*      */     }
/* 1855 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLibraryStructBSchema
 * JD-Core Version:    0.6.0
 */