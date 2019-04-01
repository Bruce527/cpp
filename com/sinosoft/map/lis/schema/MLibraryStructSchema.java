/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MLibraryStructDB;
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
/*      */ public class MLibraryStructSchema
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
/*      */   public static final int FIELDNUM = 27;
/*      */   private static String[] PK;
/*   78 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MLibraryStructSchema()
/*      */   {
/*   85 */     this.mErrors = new CErrors();
/*      */ 
/*   87 */     String[] pk = new String[1];
/*   88 */     pk[0] = "NodeID";
/*      */ 
/*   90 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   97 */     MLibraryStructSchema cloned = (MLibraryStructSchema)super.clone();
/*   98 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   99 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  100 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  106 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getNodeID()
/*      */   {
/*  111 */     return this.nodeID;
/*      */   }
/*      */ 
/*      */   public void setNodeID(String aNodeID) {
/*  115 */     this.nodeID = aNodeID;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  119 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  123 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getParentID() {
/*  127 */     return this.parentID;
/*      */   }
/*      */ 
/*      */   public void setParentID(String aParentID) {
/*  131 */     this.parentID = aParentID;
/*      */   }
/*      */ 
/*      */   public String getDiscription() {
/*  135 */     return this.discription;
/*      */   }
/*      */ 
/*      */   public void setDiscription(String aDiscription) {
/*  139 */     this.discription = aDiscription;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  143 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  147 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  151 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  155 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public int getPosition() {
/*  159 */     return this.position;
/*      */   }
/*      */ 
/*      */   public void setPosition(int aPosition) {
/*  163 */     this.position = aPosition;
/*      */   }
/*      */ 
/*      */   public void setPosition(String aPosition) {
/*  167 */     if ((aPosition != null) && (!aPosition.equals("")))
/*      */     {
/*  169 */       Integer tInteger = new Integer(aPosition);
/*  170 */       int i = tInteger.intValue();
/*  171 */       this.position = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getOperation()
/*      */   {
/*  177 */     return this.operation;
/*      */   }
/*      */ 
/*      */   public void setOperation(String aOperation) {
/*  181 */     this.operation = aOperation;
/*      */   }
/*      */ 
/*      */   public String getDirFlag() {
/*  185 */     return this.dirFlag;
/*      */   }
/*      */ 
/*      */   public void setDirFlag(String aDirFlag) {
/*  189 */     this.dirFlag = aDirFlag;
/*      */   }
/*      */ 
/*      */   public String getFileFlag() {
/*  193 */     return this.fileFlag;
/*      */   }
/*      */ 
/*      */   public void setFileFlag(String aFileFlag) {
/*  197 */     this.fileFlag = aFileFlag;
/*      */   }
/*      */ 
/*      */   public int getChildDirNum() {
/*  201 */     return this.childDirNum;
/*      */   }
/*      */ 
/*      */   public void setChildDirNum(int aChildDirNum) {
/*  205 */     this.childDirNum = aChildDirNum;
/*      */   }
/*      */ 
/*      */   public void setChildDirNum(String aChildDirNum) {
/*  209 */     if ((aChildDirNum != null) && (!aChildDirNum.equals("")))
/*      */     {
/*  211 */       Integer tInteger = new Integer(aChildDirNum);
/*  212 */       int i = tInteger.intValue();
/*  213 */       this.childDirNum = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getCheckState()
/*      */   {
/*  219 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  223 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  227 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  231 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  235 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  239 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  243 */     if (this.checkDate != null) {
/*  244 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  246 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  250 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  254 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  256 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  259 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  264 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  268 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  272 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  276 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  280 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  284 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  288 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  292 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  296 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  298 */       Integer tInteger = new Integer(aIF01);
/*  299 */       int i = tInteger.intValue();
/*  300 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  306 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  310 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  314 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  316 */       Double tDouble = new Double(aDF02);
/*  317 */       double d = tDouble.doubleValue();
/*  318 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  324 */     if (this.date01 != null) {
/*  325 */       return this.fDate.getString(this.date01);
/*      */     }
/*  327 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  331 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  335 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  337 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  340 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  345 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  349 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  353 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  357 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  361 */     if (this.makeDate != null) {
/*  362 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  364 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  368 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  372 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  374 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  377 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  382 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  386 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  390 */     if (this.modifyDate != null) {
/*  391 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  393 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  397 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  401 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  403 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  406 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  411 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  415 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MLibraryStructSchema aMLibraryStructSchema)
/*      */   {
/*  421 */     this.nodeID = aMLibraryStructSchema.getNodeID();
/*  422 */     this.name = aMLibraryStructSchema.getName();
/*  423 */     this.parentID = aMLibraryStructSchema.getParentID();
/*  424 */     this.discription = aMLibraryStructSchema.getDiscription();
/*  425 */     this.manageCom = aMLibraryStructSchema.getManageCom();
/*  426 */     this.branchType = aMLibraryStructSchema.getBranchType();
/*  427 */     this.position = aMLibraryStructSchema.getPosition();
/*  428 */     this.operation = aMLibraryStructSchema.getOperation();
/*  429 */     this.dirFlag = aMLibraryStructSchema.getDirFlag();
/*  430 */     this.fileFlag = aMLibraryStructSchema.getFileFlag();
/*  431 */     this.childDirNum = aMLibraryStructSchema.getChildDirNum();
/*  432 */     this.checkState = aMLibraryStructSchema.getCheckState();
/*  433 */     this.checkOperator = aMLibraryStructSchema.getCheckOperator();
/*  434 */     this.checkReason = aMLibraryStructSchema.getCheckReason();
/*  435 */     this.checkDate = this.fDate.getDate(aMLibraryStructSchema.getCheckDate());
/*  436 */     this.checkTime = aMLibraryStructSchema.getCheckTime();
/*  437 */     this.vF01 = aMLibraryStructSchema.getVF01();
/*  438 */     this.nF01 = aMLibraryStructSchema.getNF01();
/*  439 */     this.iF01 = aMLibraryStructSchema.getIF01();
/*  440 */     this.dF02 = aMLibraryStructSchema.getDF02();
/*  441 */     this.date01 = this.fDate.getDate(aMLibraryStructSchema.getDate01());
/*  442 */     this.modifyOperator = aMLibraryStructSchema.getModifyOperator();
/*  443 */     this.operator = aMLibraryStructSchema.getOperator();
/*  444 */     this.makeDate = this.fDate.getDate(aMLibraryStructSchema.getMakeDate());
/*  445 */     this.makeTime = aMLibraryStructSchema.getMakeTime();
/*  446 */     this.modifyDate = this.fDate.getDate(aMLibraryStructSchema.getModifyDate());
/*  447 */     this.modifyTime = aMLibraryStructSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  456 */       if (rs.getString("NodeID") == null)
/*  457 */         this.nodeID = null;
/*      */       else {
/*  459 */         this.nodeID = rs.getString("NodeID").trim();
/*      */       }
/*  461 */       if (rs.getString("Name") == null)
/*  462 */         this.name = null;
/*      */       else {
/*  464 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  466 */       if (rs.getString("ParentID") == null)
/*  467 */         this.parentID = null;
/*      */       else {
/*  469 */         this.parentID = rs.getString("ParentID").trim();
/*      */       }
/*  471 */       if (rs.getString("Discription") == null)
/*  472 */         this.discription = null;
/*      */       else {
/*  474 */         this.discription = rs.getString("Discription").trim();
/*      */       }
/*  476 */       if (rs.getString("ManageCom") == null)
/*  477 */         this.manageCom = null;
/*      */       else {
/*  479 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  481 */       if (rs.getString("BranchType") == null)
/*  482 */         this.branchType = null;
/*      */       else {
/*  484 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  486 */       this.position = rs.getInt("Position");
/*  487 */       if (rs.getString("Operation") == null)
/*  488 */         this.operation = null;
/*      */       else {
/*  490 */         this.operation = rs.getString("Operation").trim();
/*      */       }
/*  492 */       if (rs.getString("DirFlag") == null)
/*  493 */         this.dirFlag = null;
/*      */       else {
/*  495 */         this.dirFlag = rs.getString("DirFlag").trim();
/*      */       }
/*  497 */       if (rs.getString("FileFlag") == null)
/*  498 */         this.fileFlag = null;
/*      */       else {
/*  500 */         this.fileFlag = rs.getString("FileFlag").trim();
/*      */       }
/*  502 */       this.childDirNum = rs.getInt("ChildDirNum");
/*  503 */       if (rs.getString("CheckState") == null)
/*  504 */         this.checkState = null;
/*      */       else {
/*  506 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  508 */       if (rs.getString("CheckOperator") == null)
/*  509 */         this.checkOperator = null;
/*      */       else {
/*  511 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  513 */       if (rs.getString("CheckReason") == null)
/*  514 */         this.checkReason = null;
/*      */       else {
/*  516 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  518 */       this.checkDate = rs.getDate("CheckDate");
/*  519 */       if (rs.getString("CheckTime") == null)
/*  520 */         this.checkTime = null;
/*      */       else {
/*  522 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  524 */       if (rs.getString("VF01") == null)
/*  525 */         this.vF01 = null;
/*      */       else {
/*  527 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  529 */       if (rs.getString("NF01") == null)
/*  530 */         this.nF01 = null;
/*      */       else {
/*  532 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  534 */       this.iF01 = rs.getInt("IF01");
/*  535 */       this.dF02 = rs.getDouble("DF02");
/*  536 */       this.date01 = rs.getDate("Date01");
/*  537 */       if (rs.getString("ModifyOperator") == null)
/*  538 */         this.modifyOperator = null;
/*      */       else {
/*  540 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  542 */       if (rs.getString("Operator") == null)
/*  543 */         this.operator = null;
/*      */       else {
/*  545 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  547 */       this.makeDate = rs.getDate("MakeDate");
/*  548 */       if (rs.getString("MakeTime") == null)
/*  549 */         this.makeTime = null;
/*      */       else {
/*  551 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  553 */       this.modifyDate = rs.getDate("ModifyDate");
/*  554 */       if (rs.getString("ModifyTime") == null)
/*  555 */         this.modifyTime = null;
/*      */       else {
/*  557 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  562 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLibraryStruct\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  564 */       CError tError = new CError();
/*  565 */       tError.moduleName = "MLibraryStructSchema";
/*  566 */       tError.functionName = "setSchema";
/*  567 */       tError.errorMessage = sqle.toString();
/*  568 */       this.mErrors.addOneError(tError);
/*  569 */       return false;
/*      */     }
/*  571 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSchema getSchema()
/*      */   {
/*  576 */     MLibraryStructSchema aMLibraryStructSchema = new MLibraryStructSchema();
/*  577 */     aMLibraryStructSchema.setSchema(this);
/*  578 */     return aMLibraryStructSchema;
/*      */   }
/*      */ 
/*      */   public MLibraryStructDB getDB()
/*      */   {
/*  583 */     MLibraryStructDB aDBOper = new MLibraryStructDB();
/*  584 */     aDBOper.setSchema(this);
/*  585 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  592 */     StringBuffer strReturn = new StringBuffer(256);
/*  593 */     strReturn.append(StrTool.cTrim(this.nodeID)); strReturn.append("|");
/*  594 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  595 */     strReturn.append(StrTool.cTrim(this.parentID)); strReturn.append("|");
/*  596 */     strReturn.append(StrTool.cTrim(this.discription)); strReturn.append("|");
/*  597 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  598 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  599 */     strReturn.append(ChgData.chgData(this.position)); strReturn.append("|");
/*  600 */     strReturn.append(StrTool.cTrim(this.operation)); strReturn.append("|");
/*  601 */     strReturn.append(StrTool.cTrim(this.dirFlag)); strReturn.append("|");
/*  602 */     strReturn.append(StrTool.cTrim(this.fileFlag)); strReturn.append("|");
/*  603 */     strReturn.append(ChgData.chgData(this.childDirNum)); strReturn.append("|");
/*  604 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  605 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  606 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  607 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  608 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  609 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  610 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  611 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  612 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  613 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  614 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  615 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  616 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  617 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  618 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  619 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  620 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  628 */       this.nodeID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  629 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  630 */       this.parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  631 */       this.discription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  632 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  633 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  634 */       this.position = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).intValue();
/*  635 */       this.operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  636 */       this.dirFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  637 */       this.fileFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  638 */       this.childDirNum = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).intValue();
/*  639 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  640 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  641 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  642 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  643 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  644 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  645 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  646 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|"))).intValue();
/*  647 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).doubleValue();
/*  648 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  649 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  650 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  651 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  652 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  653 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  654 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  659 */       CError tError = new CError();
/*  660 */       tError.moduleName = "MLibraryStructSchema";
/*  661 */       tError.functionName = "decode";
/*  662 */       tError.errorMessage = ex.toString();
/*  663 */       this.mErrors.addOneError(tError);
/*      */ 
/*  665 */       return false;
/*      */     }
/*  667 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  673 */     String strReturn = "";
/*  674 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nodeID));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.parentID));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("discription"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.discription));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.position));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("operation"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operation));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("dirFlag"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dirFlag));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("fileFlag"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileFlag));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("childDirNum"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.childDirNum));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  778 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  782 */     if (strReturn.equals(""))
/*      */     {
/*  784 */       strReturn = "null";
/*      */     }
/*      */ 
/*  787 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  794 */     String strFieldValue = "";
/*  795 */     switch (nFieldIndex) {
/*      */     case 0:
/*  797 */       strFieldValue = StrTool.GBKToUnicode(this.nodeID);
/*  798 */       break;
/*      */     case 1:
/*  800 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  801 */       break;
/*      */     case 2:
/*  803 */       strFieldValue = StrTool.GBKToUnicode(this.parentID);
/*  804 */       break;
/*      */     case 3:
/*  806 */       strFieldValue = StrTool.GBKToUnicode(this.discription);
/*  807 */       break;
/*      */     case 4:
/*  809 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  810 */       break;
/*      */     case 5:
/*  812 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  813 */       break;
/*      */     case 6:
/*  815 */       strFieldValue = String.valueOf(this.position);
/*  816 */       break;
/*      */     case 7:
/*  818 */       strFieldValue = StrTool.GBKToUnicode(this.operation);
/*  819 */       break;
/*      */     case 8:
/*  821 */       strFieldValue = StrTool.GBKToUnicode(this.dirFlag);
/*  822 */       break;
/*      */     case 9:
/*  824 */       strFieldValue = StrTool.GBKToUnicode(this.fileFlag);
/*  825 */       break;
/*      */     case 10:
/*  827 */       strFieldValue = String.valueOf(this.childDirNum);
/*  828 */       break;
/*      */     case 11:
/*  830 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  831 */       break;
/*      */     case 12:
/*  833 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  834 */       break;
/*      */     case 13:
/*  836 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  837 */       break;
/*      */     case 14:
/*  839 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  840 */       break;
/*      */     case 15:
/*  842 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  843 */       break;
/*      */     case 16:
/*  845 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  846 */       break;
/*      */     case 17:
/*  848 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  849 */       break;
/*      */     case 18:
/*  851 */       strFieldValue = String.valueOf(this.iF01);
/*  852 */       break;
/*      */     case 19:
/*  854 */       strFieldValue = String.valueOf(this.dF02);
/*  855 */       break;
/*      */     case 20:
/*  857 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  858 */       break;
/*      */     case 21:
/*  860 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  861 */       break;
/*      */     case 22:
/*  863 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  864 */       break;
/*      */     case 23:
/*  866 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  867 */       break;
/*      */     case 24:
/*  869 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  870 */       break;
/*      */     case 25:
/*  872 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  873 */       break;
/*      */     case 26:
/*  875 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  876 */       break;
/*      */     default:
/*  878 */       strFieldValue = "";
/*      */     }
/*  880 */     if (strFieldValue.equals("")) {
/*  881 */       strFieldValue = "null";
/*      */     }
/*  883 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  889 */     if (StrTool.cTrim(FCode).equals("")) {
/*  890 */       return false;
/*      */     }
/*  892 */     if (FCode.equalsIgnoreCase("nodeID"))
/*      */     {
/*  894 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  896 */         this.nodeID = FValue.trim();
/*      */       }
/*      */       else
/*  899 */         this.nodeID = null;
/*      */     }
/*  901 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  903 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  905 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  908 */         this.name = null;
/*      */     }
/*  910 */     if (FCode.equalsIgnoreCase("parentID"))
/*      */     {
/*  912 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  914 */         this.parentID = FValue.trim();
/*      */       }
/*      */       else
/*  917 */         this.parentID = null;
/*      */     }
/*  919 */     if (FCode.equalsIgnoreCase("discription"))
/*      */     {
/*  921 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  923 */         this.discription = FValue.trim();
/*      */       }
/*      */       else
/*  926 */         this.discription = null;
/*      */     }
/*  928 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  930 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  932 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  935 */         this.manageCom = null;
/*      */     }
/*  937 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  939 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  941 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  944 */         this.branchType = null;
/*      */     }
/*  946 */     if (FCode.equalsIgnoreCase("position"))
/*      */     {
/*  948 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  950 */         Integer tInteger = new Integer(FValue);
/*  951 */         int i = tInteger.intValue();
/*  952 */         this.position = i;
/*      */       }
/*      */     }
/*  955 */     if (FCode.equalsIgnoreCase("operation"))
/*      */     {
/*  957 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  959 */         this.operation = FValue.trim();
/*      */       }
/*      */       else
/*  962 */         this.operation = null;
/*      */     }
/*  964 */     if (FCode.equalsIgnoreCase("dirFlag"))
/*      */     {
/*  966 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  968 */         this.dirFlag = FValue.trim();
/*      */       }
/*      */       else
/*  971 */         this.dirFlag = null;
/*      */     }
/*  973 */     if (FCode.equalsIgnoreCase("fileFlag"))
/*      */     {
/*  975 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  977 */         this.fileFlag = FValue.trim();
/*      */       }
/*      */       else
/*  980 */         this.fileFlag = null;
/*      */     }
/*  982 */     if (FCode.equalsIgnoreCase("childDirNum"))
/*      */     {
/*  984 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  986 */         Integer tInteger = new Integer(FValue);
/*  987 */         int i = tInteger.intValue();
/*  988 */         this.childDirNum = i;
/*      */       }
/*      */     }
/*  991 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  993 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  995 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/*  998 */         this.checkState = null;
/*      */     }
/* 1000 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1002 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1004 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1007 */         this.checkOperator = null;
/*      */     }
/* 1009 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1011 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1013 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1016 */         this.checkReason = null;
/*      */     }
/* 1018 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1020 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1022 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1025 */         this.checkDate = null;
/*      */     }
/* 1027 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1029 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1031 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1034 */         this.checkTime = null;
/*      */     }
/* 1036 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1038 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1040 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1043 */         this.vF01 = null;
/*      */     }
/* 1045 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1047 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1049 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1052 */         this.nF01 = null;
/*      */     }
/* 1054 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1056 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1058 */         Integer tInteger = new Integer(FValue);
/* 1059 */         int i = tInteger.intValue();
/* 1060 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1063 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1065 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1067 */         Double tDouble = new Double(FValue);
/* 1068 */         double d = tDouble.doubleValue();
/* 1069 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1072 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1074 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1076 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1079 */         this.date01 = null;
/*      */     }
/* 1081 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1083 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1085 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1088 */         this.modifyOperator = null;
/*      */     }
/* 1090 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1092 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1094 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1097 */         this.operator = null;
/*      */     }
/* 1099 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1101 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1103 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1106 */         this.makeDate = null;
/*      */     }
/* 1108 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1110 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1112 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1115 */         this.makeTime = null;
/*      */     }
/* 1117 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1119 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1121 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1124 */         this.modifyDate = null;
/*      */     }
/* 1126 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1128 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1130 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1133 */         this.modifyTime = null;
/*      */     }
/* 1135 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1140 */     if (otherObject == null) return false;
/* 1141 */     if (this == otherObject) return true;
/* 1142 */     if (getClass() != otherObject.getClass()) return false;
/* 1143 */     MLibraryStructSchema other = (MLibraryStructSchema)otherObject;
/* 1144 */     if ((this.nodeID == null) && (other.getNodeID() != null)) return false;
/* 1145 */     if ((this.nodeID != null) && (!this.nodeID.equals(other.getNodeID()))) return false;
/* 1146 */     if ((this.name == null) && (other.getName() != null)) return false;
/* 1147 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/* 1148 */     if ((this.parentID == null) && (other.getParentID() != null)) return false;
/* 1149 */     if ((this.parentID != null) && (!this.parentID.equals(other.getParentID()))) return false;
/* 1150 */     if ((this.discription == null) && (other.getDiscription() != null)) return false;
/* 1151 */     if ((this.discription != null) && (!this.discription.equals(other.getDiscription()))) return false;
/* 1152 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1153 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1154 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1155 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1156 */     if (this.position != other.getPosition()) return false;
/* 1157 */     if ((this.operation == null) && (other.getOperation() != null)) return false;
/* 1158 */     if ((this.operation != null) && (!this.operation.equals(other.getOperation()))) return false;
/* 1159 */     if ((this.dirFlag == null) && (other.getDirFlag() != null)) return false;
/* 1160 */     if ((this.dirFlag != null) && (!this.dirFlag.equals(other.getDirFlag()))) return false;
/* 1161 */     if ((this.fileFlag == null) && (other.getFileFlag() != null)) return false;
/* 1162 */     if ((this.fileFlag != null) && (!this.fileFlag.equals(other.getFileFlag()))) return false;
/* 1163 */     if (this.childDirNum != other.getChildDirNum()) return false;
/* 1164 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1165 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1166 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1167 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1168 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1169 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1170 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1171 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1172 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1173 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1174 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1175 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1176 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1177 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1178 */     if (this.iF01 != other.getIF01()) return false;
/* 1179 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1180 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1181 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1182 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1183 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1184 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1185 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1186 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1187 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1188 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1189 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1190 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1191 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1192 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1193 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1200 */     return 27;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1206 */     if (strFieldName.equals("nodeID")) {
/* 1207 */       return 0;
/*      */     }
/* 1209 */     if (strFieldName.equals("name")) {
/* 1210 */       return 1;
/*      */     }
/* 1212 */     if (strFieldName.equals("parentID")) {
/* 1213 */       return 2;
/*      */     }
/* 1215 */     if (strFieldName.equals("discription")) {
/* 1216 */       return 3;
/*      */     }
/* 1218 */     if (strFieldName.equals("manageCom")) {
/* 1219 */       return 4;
/*      */     }
/* 1221 */     if (strFieldName.equals("branchType")) {
/* 1222 */       return 5;
/*      */     }
/* 1224 */     if (strFieldName.equals("position")) {
/* 1225 */       return 6;
/*      */     }
/* 1227 */     if (strFieldName.equals("operation")) {
/* 1228 */       return 7;
/*      */     }
/* 1230 */     if (strFieldName.equals("dirFlag")) {
/* 1231 */       return 8;
/*      */     }
/* 1233 */     if (strFieldName.equals("fileFlag")) {
/* 1234 */       return 9;
/*      */     }
/* 1236 */     if (strFieldName.equals("childDirNum")) {
/* 1237 */       return 10;
/*      */     }
/* 1239 */     if (strFieldName.equals("checkState")) {
/* 1240 */       return 11;
/*      */     }
/* 1242 */     if (strFieldName.equals("checkOperator")) {
/* 1243 */       return 12;
/*      */     }
/* 1245 */     if (strFieldName.equals("checkReason")) {
/* 1246 */       return 13;
/*      */     }
/* 1248 */     if (strFieldName.equals("checkDate")) {
/* 1249 */       return 14;
/*      */     }
/* 1251 */     if (strFieldName.equals("checkTime")) {
/* 1252 */       return 15;
/*      */     }
/* 1254 */     if (strFieldName.equals("vF01")) {
/* 1255 */       return 16;
/*      */     }
/* 1257 */     if (strFieldName.equals("nF01")) {
/* 1258 */       return 17;
/*      */     }
/* 1260 */     if (strFieldName.equals("iF01")) {
/* 1261 */       return 18;
/*      */     }
/* 1263 */     if (strFieldName.equals("dF02")) {
/* 1264 */       return 19;
/*      */     }
/* 1266 */     if (strFieldName.equals("date01")) {
/* 1267 */       return 20;
/*      */     }
/* 1269 */     if (strFieldName.equals("modifyOperator")) {
/* 1270 */       return 21;
/*      */     }
/* 1272 */     if (strFieldName.equals("operator")) {
/* 1273 */       return 22;
/*      */     }
/* 1275 */     if (strFieldName.equals("makeDate")) {
/* 1276 */       return 23;
/*      */     }
/* 1278 */     if (strFieldName.equals("makeTime")) {
/* 1279 */       return 24;
/*      */     }
/* 1281 */     if (strFieldName.equals("modifyDate")) {
/* 1282 */       return 25;
/*      */     }
/* 1284 */     if (strFieldName.equals("modifyTime")) {
/* 1285 */       return 26;
/*      */     }
/* 1287 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1293 */     String strFieldName = "";
/* 1294 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1296 */       strFieldName = "nodeID";
/* 1297 */       break;
/*      */     case 1:
/* 1299 */       strFieldName = "name";
/* 1300 */       break;
/*      */     case 2:
/* 1302 */       strFieldName = "parentID";
/* 1303 */       break;
/*      */     case 3:
/* 1305 */       strFieldName = "discription";
/* 1306 */       break;
/*      */     case 4:
/* 1308 */       strFieldName = "manageCom";
/* 1309 */       break;
/*      */     case 5:
/* 1311 */       strFieldName = "branchType";
/* 1312 */       break;
/*      */     case 6:
/* 1314 */       strFieldName = "position";
/* 1315 */       break;
/*      */     case 7:
/* 1317 */       strFieldName = "operation";
/* 1318 */       break;
/*      */     case 8:
/* 1320 */       strFieldName = "dirFlag";
/* 1321 */       break;
/*      */     case 9:
/* 1323 */       strFieldName = "fileFlag";
/* 1324 */       break;
/*      */     case 10:
/* 1326 */       strFieldName = "childDirNum";
/* 1327 */       break;
/*      */     case 11:
/* 1329 */       strFieldName = "checkState";
/* 1330 */       break;
/*      */     case 12:
/* 1332 */       strFieldName = "checkOperator";
/* 1333 */       break;
/*      */     case 13:
/* 1335 */       strFieldName = "checkReason";
/* 1336 */       break;
/*      */     case 14:
/* 1338 */       strFieldName = "checkDate";
/* 1339 */       break;
/*      */     case 15:
/* 1341 */       strFieldName = "checkTime";
/* 1342 */       break;
/*      */     case 16:
/* 1344 */       strFieldName = "vF01";
/* 1345 */       break;
/*      */     case 17:
/* 1347 */       strFieldName = "nF01";
/* 1348 */       break;
/*      */     case 18:
/* 1350 */       strFieldName = "iF01";
/* 1351 */       break;
/*      */     case 19:
/* 1353 */       strFieldName = "dF02";
/* 1354 */       break;
/*      */     case 20:
/* 1356 */       strFieldName = "date01";
/* 1357 */       break;
/*      */     case 21:
/* 1359 */       strFieldName = "modifyOperator";
/* 1360 */       break;
/*      */     case 22:
/* 1362 */       strFieldName = "operator";
/* 1363 */       break;
/*      */     case 23:
/* 1365 */       strFieldName = "makeDate";
/* 1366 */       break;
/*      */     case 24:
/* 1368 */       strFieldName = "makeTime";
/* 1369 */       break;
/*      */     case 25:
/* 1371 */       strFieldName = "modifyDate";
/* 1372 */       break;
/*      */     case 26:
/* 1374 */       strFieldName = "modifyTime";
/* 1375 */       break;
/*      */     default:
/* 1377 */       strFieldName = "";
/*      */     }
/* 1379 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1385 */     if (strFieldName.equals("nodeID")) {
/* 1386 */       return 0;
/*      */     }
/* 1388 */     if (strFieldName.equals("name")) {
/* 1389 */       return 0;
/*      */     }
/* 1391 */     if (strFieldName.equals("parentID")) {
/* 1392 */       return 0;
/*      */     }
/* 1394 */     if (strFieldName.equals("discription")) {
/* 1395 */       return 0;
/*      */     }
/* 1397 */     if (strFieldName.equals("manageCom")) {
/* 1398 */       return 0;
/*      */     }
/* 1400 */     if (strFieldName.equals("branchType")) {
/* 1401 */       return 0;
/*      */     }
/* 1403 */     if (strFieldName.equals("position")) {
/* 1404 */       return 3;
/*      */     }
/* 1406 */     if (strFieldName.equals("operation")) {
/* 1407 */       return 0;
/*      */     }
/* 1409 */     if (strFieldName.equals("dirFlag")) {
/* 1410 */       return 0;
/*      */     }
/* 1412 */     if (strFieldName.equals("fileFlag")) {
/* 1413 */       return 0;
/*      */     }
/* 1415 */     if (strFieldName.equals("childDirNum")) {
/* 1416 */       return 3;
/*      */     }
/* 1418 */     if (strFieldName.equals("checkState")) {
/* 1419 */       return 0;
/*      */     }
/* 1421 */     if (strFieldName.equals("checkOperator")) {
/* 1422 */       return 0;
/*      */     }
/* 1424 */     if (strFieldName.equals("checkReason")) {
/* 1425 */       return 0;
/*      */     }
/* 1427 */     if (strFieldName.equals("checkDate")) {
/* 1428 */       return 1;
/*      */     }
/* 1430 */     if (strFieldName.equals("checkTime")) {
/* 1431 */       return 0;
/*      */     }
/* 1433 */     if (strFieldName.equals("vF01")) {
/* 1434 */       return 0;
/*      */     }
/* 1436 */     if (strFieldName.equals("nF01")) {
/* 1437 */       return 0;
/*      */     }
/* 1439 */     if (strFieldName.equals("iF01")) {
/* 1440 */       return 3;
/*      */     }
/* 1442 */     if (strFieldName.equals("dF02")) {
/* 1443 */       return 4;
/*      */     }
/* 1445 */     if (strFieldName.equals("date01")) {
/* 1446 */       return 1;
/*      */     }
/* 1448 */     if (strFieldName.equals("modifyOperator")) {
/* 1449 */       return 0;
/*      */     }
/* 1451 */     if (strFieldName.equals("operator")) {
/* 1452 */       return 0;
/*      */     }
/* 1454 */     if (strFieldName.equals("makeDate")) {
/* 1455 */       return 1;
/*      */     }
/* 1457 */     if (strFieldName.equals("makeTime")) {
/* 1458 */       return 0;
/*      */     }
/* 1460 */     if (strFieldName.equals("modifyDate")) {
/* 1461 */       return 1;
/*      */     }
/* 1463 */     if (strFieldName.equals("modifyTime")) {
/* 1464 */       return 0;
/*      */     }
/* 1466 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1472 */     int nFieldType = -1;
/* 1473 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1475 */       nFieldType = 0;
/* 1476 */       break;
/*      */     case 1:
/* 1478 */       nFieldType = 0;
/* 1479 */       break;
/*      */     case 2:
/* 1481 */       nFieldType = 0;
/* 1482 */       break;
/*      */     case 3:
/* 1484 */       nFieldType = 0;
/* 1485 */       break;
/*      */     case 4:
/* 1487 */       nFieldType = 0;
/* 1488 */       break;
/*      */     case 5:
/* 1490 */       nFieldType = 0;
/* 1491 */       break;
/*      */     case 6:
/* 1493 */       nFieldType = 3;
/* 1494 */       break;
/*      */     case 7:
/* 1496 */       nFieldType = 0;
/* 1497 */       break;
/*      */     case 8:
/* 1499 */       nFieldType = 0;
/* 1500 */       break;
/*      */     case 9:
/* 1502 */       nFieldType = 0;
/* 1503 */       break;
/*      */     case 10:
/* 1505 */       nFieldType = 3;
/* 1506 */       break;
/*      */     case 11:
/* 1508 */       nFieldType = 0;
/* 1509 */       break;
/*      */     case 12:
/* 1511 */       nFieldType = 0;
/* 1512 */       break;
/*      */     case 13:
/* 1514 */       nFieldType = 0;
/* 1515 */       break;
/*      */     case 14:
/* 1517 */       nFieldType = 1;
/* 1518 */       break;
/*      */     case 15:
/* 1520 */       nFieldType = 0;
/* 1521 */       break;
/*      */     case 16:
/* 1523 */       nFieldType = 0;
/* 1524 */       break;
/*      */     case 17:
/* 1526 */       nFieldType = 0;
/* 1527 */       break;
/*      */     case 18:
/* 1529 */       nFieldType = 3;
/* 1530 */       break;
/*      */     case 19:
/* 1532 */       nFieldType = 4;
/* 1533 */       break;
/*      */     case 20:
/* 1535 */       nFieldType = 1;
/* 1536 */       break;
/*      */     case 21:
/* 1538 */       nFieldType = 0;
/* 1539 */       break;
/*      */     case 22:
/* 1541 */       nFieldType = 0;
/* 1542 */       break;
/*      */     case 23:
/* 1544 */       nFieldType = 1;
/* 1545 */       break;
/*      */     case 24:
/* 1547 */       nFieldType = 0;
/* 1548 */       break;
/*      */     case 25:
/* 1550 */       nFieldType = 1;
/* 1551 */       break;
/*      */     case 26:
/* 1553 */       nFieldType = 0;
/* 1554 */       break;
/*      */     default:
/* 1556 */       nFieldType = -1;
/*      */     }
/* 1558 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLibraryStructSchema
 * JD-Core Version:    0.6.0
 */