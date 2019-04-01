/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MTrainInfoDB;
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class MTrainInfoSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String agentCode;
/*      */   private String agentName;
/*      */   private String agentGrade;
/*      */   private String agentGroup;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String courseID;
/*      */   private Date trainStart;
/*      */   private Date trainEnd;
/*      */   private String trainAdd;
/*      */   private String hours;
/*      */   private String teacher;
/*      */   private String passFlag;
/*      */   private String score;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   64 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MTrainInfoSchema()
/*      */   {
/*   71 */     this.mErrors = new CErrors();
/*      */ 
/*   73 */     String[] pk = new String[1];
/*   74 */     pk[0] = "ID";
/*      */ 
/*   76 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   83 */     MTrainInfoSchema cloned = (MTrainInfoSchema)super.clone();
/*   84 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   85 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   86 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   92 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*   97 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  101 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getAgentCode() {
/*  105 */     return this.agentCode;
/*      */   }
/*      */ 
/*      */   public void setAgentCode(String aAgentCode) {
/*  109 */     this.agentCode = aAgentCode;
/*      */   }
/*      */ 
/*      */   public String getAgentName() {
/*  113 */     return this.agentName;
/*      */   }
/*      */ 
/*      */   public void setAgentName(String aAgentName) {
/*  117 */     this.agentName = aAgentName;
/*      */   }
/*      */ 
/*      */   public String getAgentGrade() {
/*  121 */     return this.agentGrade;
/*      */   }
/*      */ 
/*      */   public void setAgentGrade(String aAgentGrade) {
/*  125 */     this.agentGrade = aAgentGrade;
/*      */   }
/*      */ 
/*      */   public String getAgentGroup() {
/*  129 */     return this.agentGroup;
/*      */   }
/*      */ 
/*      */   public void setAgentGroup(String aAgentGroup) {
/*  133 */     this.agentGroup = aAgentGroup;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  137 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  141 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  145 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  149 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getCourseID() {
/*  153 */     return this.courseID;
/*      */   }
/*      */ 
/*      */   public void setCourseID(String aCourseID) {
/*  157 */     this.courseID = aCourseID;
/*      */   }
/*      */ 
/*      */   public String getTrainStart() {
/*  161 */     if (this.trainStart != null) {
/*  162 */       return this.fDate.getString(this.trainStart);
/*      */     }
/*  164 */     return null;
/*      */   }
/*      */ 
/*      */   public void setTrainStart(Date aTrainStart) {
/*  168 */     this.trainStart = aTrainStart;
/*      */   }
/*      */ 
/*      */   public void setTrainStart(String aTrainStart) {
/*  172 */     if ((aTrainStart != null) && (!aTrainStart.equals("")))
/*      */     {
/*  174 */       this.trainStart = this.fDate.getDate(aTrainStart);
/*      */     }
/*      */     else
/*  177 */       this.trainStart = null;
/*      */   }
/*      */ 
/*      */   public String getTrainEnd()
/*      */   {
/*  182 */     if (this.trainEnd != null) {
/*  183 */       return this.fDate.getString(this.trainEnd);
/*      */     }
/*  185 */     return null;
/*      */   }
/*      */ 
/*      */   public void setTrainEnd(Date aTrainEnd) {
/*  189 */     this.trainEnd = aTrainEnd;
/*      */   }
/*      */ 
/*      */   public void setTrainEnd(String aTrainEnd) {
/*  193 */     if ((aTrainEnd != null) && (!aTrainEnd.equals("")))
/*      */     {
/*  195 */       this.trainEnd = this.fDate.getDate(aTrainEnd);
/*      */     }
/*      */     else
/*  198 */       this.trainEnd = null;
/*      */   }
/*      */ 
/*      */   public String getTrainAdd()
/*      */   {
/*  203 */     return this.trainAdd;
/*      */   }
/*      */ 
/*      */   public void setTrainAdd(String aTrainAdd) {
/*  207 */     this.trainAdd = aTrainAdd;
/*      */   }
/*      */ 
/*      */   public String getHours() {
/*  211 */     return this.hours;
/*      */   }
/*      */ 
/*      */   public void setHours(String aHours) {
/*  215 */     this.hours = aHours;
/*      */   }
/*      */ 
/*      */   public String getTeacher() {
/*  219 */     return this.teacher;
/*      */   }
/*      */ 
/*      */   public void setTeacher(String aTeacher) {
/*  223 */     this.teacher = aTeacher;
/*      */   }
/*      */ 
/*      */   public String getPassFlag() {
/*  227 */     return this.passFlag;
/*      */   }
/*      */ 
/*      */   public void setPassFlag(String aPassFlag) {
/*  231 */     this.passFlag = aPassFlag;
/*      */   }
/*      */ 
/*      */   public String getScore() {
/*  235 */     return this.score;
/*      */   }
/*      */ 
/*      */   public void setScore(String aScore) {
/*  239 */     this.score = aScore;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  243 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  247 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  251 */     if (this.makeDate != null) {
/*  252 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  254 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  258 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  262 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  264 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  267 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  272 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  276 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  280 */     if (this.modifyDate != null) {
/*  281 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  283 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  287 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  291 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  293 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  296 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  301 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  305 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MTrainInfoSchema aMTrainInfoSchema)
/*      */   {
/*  311 */     this.iD = aMTrainInfoSchema.getID();
/*  312 */     this.agentCode = aMTrainInfoSchema.getAgentCode();
/*  313 */     this.agentName = aMTrainInfoSchema.getAgentName();
/*  314 */     this.agentGrade = aMTrainInfoSchema.getAgentGrade();
/*  315 */     this.agentGroup = aMTrainInfoSchema.getAgentGroup();
/*  316 */     this.manageCom = aMTrainInfoSchema.getManageCom();
/*  317 */     this.branchType = aMTrainInfoSchema.getBranchType();
/*  318 */     this.courseID = aMTrainInfoSchema.getCourseID();
/*  319 */     this.trainStart = this.fDate.getDate(aMTrainInfoSchema.getTrainStart());
/*  320 */     this.trainEnd = this.fDate.getDate(aMTrainInfoSchema.getTrainEnd());
/*  321 */     this.trainAdd = aMTrainInfoSchema.getTrainAdd();
/*  322 */     this.hours = aMTrainInfoSchema.getHours();
/*  323 */     this.teacher = aMTrainInfoSchema.getTeacher();
/*  324 */     this.passFlag = aMTrainInfoSchema.getPassFlag();
/*  325 */     this.score = aMTrainInfoSchema.getScore();
/*  326 */     this.operator = aMTrainInfoSchema.getOperator();
/*  327 */     this.makeDate = this.fDate.getDate(aMTrainInfoSchema.getMakeDate());
/*  328 */     this.makeTime = aMTrainInfoSchema.getMakeTime();
/*  329 */     this.modifyDate = this.fDate.getDate(aMTrainInfoSchema.getModifyDate());
/*  330 */     this.modifyTime = aMTrainInfoSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  339 */       if (rs.getString("ID") == null)
/*  340 */         this.iD = null;
/*      */       else {
/*  342 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  344 */       if (rs.getString("AgentCode") == null)
/*  345 */         this.agentCode = null;
/*      */       else {
/*  347 */         this.agentCode = rs.getString("AgentCode").trim();
/*      */       }
/*  349 */       if (rs.getString("AgentName") == null)
/*  350 */         this.agentName = null;
/*      */       else {
/*  352 */         this.agentName = rs.getString("AgentName").trim();
/*      */       }
/*  354 */       if (rs.getString("AgentGrade") == null)
/*  355 */         this.agentGrade = null;
/*      */       else {
/*  357 */         this.agentGrade = rs.getString("AgentGrade").trim();
/*      */       }
/*  359 */       if (rs.getString("AgentGroup") == null)
/*  360 */         this.agentGroup = null;
/*      */       else {
/*  362 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*      */       }
/*  364 */       if (rs.getString("ManageCom") == null)
/*  365 */         this.manageCom = null;
/*      */       else {
/*  367 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  369 */       if (rs.getString("BranchType") == null)
/*  370 */         this.branchType = null;
/*      */       else {
/*  372 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  374 */       if (rs.getString("CourseID") == null)
/*  375 */         this.courseID = null;
/*      */       else {
/*  377 */         this.courseID = rs.getString("CourseID").trim();
/*      */       }
/*  379 */       this.trainStart = rs.getDate("TrainStart");
/*  380 */       this.trainEnd = rs.getDate("TrainEnd");
/*  381 */       if (rs.getString("TrainAdd") == null)
/*  382 */         this.trainAdd = null;
/*      */       else {
/*  384 */         this.trainAdd = rs.getString("TrainAdd").trim();
/*      */       }
/*  386 */       if (rs.getString("Hours") == null)
/*  387 */         this.hours = null;
/*      */       else {
/*  389 */         this.hours = rs.getString("Hours").trim();
/*      */       }
/*  391 */       if (rs.getString("Teacher") == null)
/*  392 */         this.teacher = null;
/*      */       else {
/*  394 */         this.teacher = rs.getString("Teacher").trim();
/*      */       }
/*  396 */       if (rs.getString("PassFlag") == null)
/*  397 */         this.passFlag = null;
/*      */       else {
/*  399 */         this.passFlag = rs.getString("PassFlag").trim();
/*      */       }
/*  401 */       if (rs.getString("Score") == null)
/*  402 */         this.score = null;
/*      */       else {
/*  404 */         this.score = rs.getString("Score").trim();
/*      */       }
/*  406 */       if (rs.getString("Operator") == null)
/*  407 */         this.operator = null;
/*      */       else {
/*  409 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  411 */       this.makeDate = rs.getDate("MakeDate");
/*  412 */       if (rs.getString("MakeTime") == null)
/*  413 */         this.makeTime = null;
/*      */       else {
/*  415 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  417 */       this.modifyDate = rs.getDate("ModifyDate");
/*  418 */       if (rs.getString("ModifyTime") == null)
/*  419 */         this.modifyTime = null;
/*      */       else {
/*  421 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  426 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MTrainInfo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  428 */       CError tError = new CError();
/*  429 */       tError.moduleName = "MTrainInfoSchema";
/*  430 */       tError.functionName = "setSchema";
/*  431 */       tError.errorMessage = sqle.toString();
/*  432 */       this.mErrors.addOneError(tError);
/*  433 */       return false;
/*      */     }
/*  435 */     return true;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSchema getSchema()
/*      */   {
/*  440 */     MTrainInfoSchema aMTrainInfoSchema = new MTrainInfoSchema();
/*  441 */     aMTrainInfoSchema.setSchema(this);
/*  442 */     return aMTrainInfoSchema;
/*      */   }
/*      */ 
/*      */   public MTrainInfoDB getDB()
/*      */   {
/*  447 */     MTrainInfoDB aDBOper = new MTrainInfoDB();
/*  448 */     aDBOper.setSchema(this);
/*  449 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  456 */     StringBuffer strReturn = new StringBuffer(256);
/*  457 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  458 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  459 */     strReturn.append(StrTool.cTrim(this.agentName)); strReturn.append("|");
/*  460 */     strReturn.append(StrTool.cTrim(this.agentGrade)); strReturn.append("|");
/*  461 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/*  462 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  463 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  464 */     strReturn.append(StrTool.cTrim(this.courseID)); strReturn.append("|");
/*  465 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.trainStart))); strReturn.append("|");
/*  466 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.trainEnd))); strReturn.append("|");
/*  467 */     strReturn.append(StrTool.cTrim(this.trainAdd)); strReturn.append("|");
/*  468 */     strReturn.append(StrTool.cTrim(this.hours)); strReturn.append("|");
/*  469 */     strReturn.append(StrTool.cTrim(this.teacher)); strReturn.append("|");
/*  470 */     strReturn.append(StrTool.cTrim(this.passFlag)); strReturn.append("|");
/*  471 */     strReturn.append(StrTool.cTrim(this.score)); strReturn.append("|");
/*  472 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  473 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  474 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  475 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  476 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  477 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  485 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  486 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  487 */       this.agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  488 */       this.agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  489 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  490 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  491 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  492 */       this.courseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  493 */       this.trainStart = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  494 */       this.trainEnd = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  495 */       this.trainAdd = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  496 */       this.hours = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  497 */       this.teacher = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  498 */       this.passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  499 */       this.score = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  500 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  501 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
/*  502 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  503 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  504 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  509 */       CError tError = new CError();
/*  510 */       tError.moduleName = "MTrainInfoSchema";
/*  511 */       tError.functionName = "decode";
/*  512 */       tError.errorMessage = ex.toString();
/*  513 */       this.mErrors.addOneError(tError);
/*      */ 
/*  515 */       return false;
/*      */     }
/*  517 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  523 */     String strReturn = "";
/*  524 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  526 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  528 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*      */     }
/*  532 */     if (FCode.equalsIgnoreCase("agentName"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentName));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade));
/*      */     }
/*  540 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/*  542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*      */     }
/*  544 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  548 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  552 */     if (FCode.equalsIgnoreCase("courseID"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.courseID));
/*      */     }
/*  556 */     if (FCode.equalsIgnoreCase("trainStart"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getTrainStart()));
/*      */     }
/*  560 */     if (FCode.equalsIgnoreCase("trainEnd"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getTrainEnd()));
/*      */     }
/*  564 */     if (FCode.equalsIgnoreCase("trainAdd"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.trainAdd));
/*      */     }
/*  568 */     if (FCode.equalsIgnoreCase("hours"))
/*      */     {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.hours));
/*      */     }
/*  572 */     if (FCode.equalsIgnoreCase("teacher"))
/*      */     {
/*  574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.teacher));
/*      */     }
/*  576 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/*  578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.passFlag));
/*      */     }
/*  580 */     if (FCode.equalsIgnoreCase("score"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.score));
/*      */     }
/*  584 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  588 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  592 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  596 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  600 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  604 */     if (strReturn.equals(""))
/*      */     {
/*  606 */       strReturn = "null";
/*      */     }
/*      */ 
/*  609 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  616 */     String strFieldValue = "";
/*  617 */     switch (nFieldIndex) {
/*      */     case 0:
/*  619 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  620 */       break;
/*      */     case 1:
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  623 */       break;
/*      */     case 2:
/*  625 */       strFieldValue = StrTool.GBKToUnicode(this.agentName);
/*  626 */       break;
/*      */     case 3:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade);
/*  629 */       break;
/*      */     case 4:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/*  632 */       break;
/*      */     case 5:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  635 */       break;
/*      */     case 6:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  638 */       break;
/*      */     case 7:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.courseID);
/*  641 */       break;
/*      */     case 8:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getTrainStart()));
/*  644 */       break;
/*      */     case 9:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getTrainEnd()));
/*  647 */       break;
/*      */     case 10:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.trainAdd);
/*  650 */       break;
/*      */     case 11:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.hours);
/*  653 */       break;
/*      */     case 12:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(this.teacher);
/*  656 */       break;
/*      */     case 13:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.passFlag);
/*  659 */       break;
/*      */     case 14:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(this.score);
/*  662 */       break;
/*      */     case 15:
/*  664 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  665 */       break;
/*      */     case 16:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  668 */       break;
/*      */     case 17:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  671 */       break;
/*      */     case 18:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  674 */       break;
/*      */     case 19:
/*  676 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  677 */       break;
/*      */     default:
/*  679 */       strFieldValue = "";
/*      */     }
/*  681 */     if (strFieldValue.equals("")) {
/*  682 */       strFieldValue = "null";
/*      */     }
/*  684 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  690 */     if (StrTool.cTrim(FCode).equals("")) {
/*  691 */       return false;
/*      */     }
/*  693 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  695 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  697 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  700 */         this.iD = null;
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("agentCode"))
/*      */     {
/*  704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  706 */         this.agentCode = FValue.trim();
/*      */       }
/*      */       else
/*  709 */         this.agentCode = null;
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("agentName"))
/*      */     {
/*  713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  715 */         this.agentName = FValue.trim();
/*      */       }
/*      */       else
/*  718 */         this.agentName = null;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*      */     {
/*  722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  724 */         this.agentGrade = FValue.trim();
/*      */       }
/*      */       else
/*  727 */         this.agentGrade = null;
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*      */     {
/*  731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  733 */         this.agentGroup = FValue.trim();
/*      */       }
/*      */       else
/*  736 */         this.agentGroup = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  742 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  745 */         this.manageCom = null;
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  751 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  754 */         this.branchType = null;
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("courseID"))
/*      */     {
/*  758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  760 */         this.courseID = FValue.trim();
/*      */       }
/*      */       else
/*  763 */         this.courseID = null;
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("trainStart"))
/*      */     {
/*  767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  769 */         this.trainStart = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  772 */         this.trainStart = null;
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("trainEnd"))
/*      */     {
/*  776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  778 */         this.trainEnd = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  781 */         this.trainEnd = null;
/*      */     }
/*  783 */     if (FCode.equalsIgnoreCase("trainAdd"))
/*      */     {
/*  785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  787 */         this.trainAdd = FValue.trim();
/*      */       }
/*      */       else
/*  790 */         this.trainAdd = null;
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("hours"))
/*      */     {
/*  794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  796 */         this.hours = FValue.trim();
/*      */       }
/*      */       else
/*  799 */         this.hours = null;
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("teacher"))
/*      */     {
/*  803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  805 */         this.teacher = FValue.trim();
/*      */       }
/*      */       else
/*  808 */         this.teacher = null;
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("passFlag"))
/*      */     {
/*  812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  814 */         this.passFlag = FValue.trim();
/*      */       }
/*      */       else
/*  817 */         this.passFlag = null;
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("score"))
/*      */     {
/*  821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  823 */         this.score = FValue.trim();
/*      */       }
/*      */       else
/*  826 */         this.score = null;
/*      */     }
/*  828 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  832 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  835 */         this.operator = null;
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  841 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  844 */         this.makeDate = null;
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  850 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  853 */         this.makeTime = null;
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  859 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  862 */         this.modifyDate = null;
/*      */     }
/*  864 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  868 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  871 */         this.modifyTime = null;
/*      */     }
/*  873 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  878 */     if (otherObject == null) return false;
/*  879 */     if (this == otherObject) return true;
/*  880 */     if (getClass() != otherObject.getClass()) return false;
/*  881 */     MTrainInfoSchema other = (MTrainInfoSchema)otherObject;
/*  882 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  883 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  884 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/*  885 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/*  886 */     if ((this.agentName == null) && (other.getAgentName() != null)) return false;
/*  887 */     if ((this.agentName != null) && (!this.agentName.equals(other.getAgentName()))) return false;
/*  888 */     if ((this.agentGrade == null) && (other.getAgentGrade() != null)) return false;
/*  889 */     if ((this.agentGrade != null) && (!this.agentGrade.equals(other.getAgentGrade()))) return false;
/*  890 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/*  891 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/*  892 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  893 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  894 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/*  895 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/*  896 */     if ((this.courseID == null) && (other.getCourseID() != null)) return false;
/*  897 */     if ((this.courseID != null) && (!this.courseID.equals(other.getCourseID()))) return false;
/*  898 */     if ((this.trainStart == null) && (other.getTrainStart() != null)) return false;
/*  899 */     if ((this.trainStart != null) && (!this.fDate.getString(this.trainStart).equals(other.getTrainStart()))) return false;
/*  900 */     if ((this.trainEnd == null) && (other.getTrainEnd() != null)) return false;
/*  901 */     if ((this.trainEnd != null) && (!this.fDate.getString(this.trainEnd).equals(other.getTrainEnd()))) return false;
/*  902 */     if ((this.trainAdd == null) && (other.getTrainAdd() != null)) return false;
/*  903 */     if ((this.trainAdd != null) && (!this.trainAdd.equals(other.getTrainAdd()))) return false;
/*  904 */     if ((this.hours == null) && (other.getHours() != null)) return false;
/*  905 */     if ((this.hours != null) && (!this.hours.equals(other.getHours()))) return false;
/*  906 */     if ((this.teacher == null) && (other.getTeacher() != null)) return false;
/*  907 */     if ((this.teacher != null) && (!this.teacher.equals(other.getTeacher()))) return false;
/*  908 */     if ((this.passFlag == null) && (other.getPassFlag() != null)) return false;
/*  909 */     if ((this.passFlag != null) && (!this.passFlag.equals(other.getPassFlag()))) return false;
/*  910 */     if ((this.score == null) && (other.getScore() != null)) return false;
/*  911 */     if ((this.score != null) && (!this.score.equals(other.getScore()))) return false;
/*  912 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  913 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  914 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  915 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  916 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  917 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  918 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  919 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  920 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  921 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  928 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  934 */     if (strFieldName.equals("iD")) {
/*  935 */       return 0;
/*      */     }
/*  937 */     if (strFieldName.equals("agentCode")) {
/*  938 */       return 1;
/*      */     }
/*  940 */     if (strFieldName.equals("agentName")) {
/*  941 */       return 2;
/*      */     }
/*  943 */     if (strFieldName.equals("agentGrade")) {
/*  944 */       return 3;
/*      */     }
/*  946 */     if (strFieldName.equals("agentGroup")) {
/*  947 */       return 4;
/*      */     }
/*  949 */     if (strFieldName.equals("manageCom")) {
/*  950 */       return 5;
/*      */     }
/*  952 */     if (strFieldName.equals("branchType")) {
/*  953 */       return 6;
/*      */     }
/*  955 */     if (strFieldName.equals("courseID")) {
/*  956 */       return 7;
/*      */     }
/*  958 */     if (strFieldName.equals("trainStart")) {
/*  959 */       return 8;
/*      */     }
/*  961 */     if (strFieldName.equals("trainEnd")) {
/*  962 */       return 9;
/*      */     }
/*  964 */     if (strFieldName.equals("trainAdd")) {
/*  965 */       return 10;
/*      */     }
/*  967 */     if (strFieldName.equals("hours")) {
/*  968 */       return 11;
/*      */     }
/*  970 */     if (strFieldName.equals("teacher")) {
/*  971 */       return 12;
/*      */     }
/*  973 */     if (strFieldName.equals("passFlag")) {
/*  974 */       return 13;
/*      */     }
/*  976 */     if (strFieldName.equals("score")) {
/*  977 */       return 14;
/*      */     }
/*  979 */     if (strFieldName.equals("operator")) {
/*  980 */       return 15;
/*      */     }
/*  982 */     if (strFieldName.equals("makeDate")) {
/*  983 */       return 16;
/*      */     }
/*  985 */     if (strFieldName.equals("makeTime")) {
/*  986 */       return 17;
/*      */     }
/*  988 */     if (strFieldName.equals("modifyDate")) {
/*  989 */       return 18;
/*      */     }
/*  991 */     if (strFieldName.equals("modifyTime")) {
/*  992 */       return 19;
/*      */     }
/*  994 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1000 */     String strFieldName = "";
/* 1001 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1003 */       strFieldName = "iD";
/* 1004 */       break;
/*      */     case 1:
/* 1006 */       strFieldName = "agentCode";
/* 1007 */       break;
/*      */     case 2:
/* 1009 */       strFieldName = "agentName";
/* 1010 */       break;
/*      */     case 3:
/* 1012 */       strFieldName = "agentGrade";
/* 1013 */       break;
/*      */     case 4:
/* 1015 */       strFieldName = "agentGroup";
/* 1016 */       break;
/*      */     case 5:
/* 1018 */       strFieldName = "manageCom";
/* 1019 */       break;
/*      */     case 6:
/* 1021 */       strFieldName = "branchType";
/* 1022 */       break;
/*      */     case 7:
/* 1024 */       strFieldName = "courseID";
/* 1025 */       break;
/*      */     case 8:
/* 1027 */       strFieldName = "trainStart";
/* 1028 */       break;
/*      */     case 9:
/* 1030 */       strFieldName = "trainEnd";
/* 1031 */       break;
/*      */     case 10:
/* 1033 */       strFieldName = "trainAdd";
/* 1034 */       break;
/*      */     case 11:
/* 1036 */       strFieldName = "hours";
/* 1037 */       break;
/*      */     case 12:
/* 1039 */       strFieldName = "teacher";
/* 1040 */       break;
/*      */     case 13:
/* 1042 */       strFieldName = "passFlag";
/* 1043 */       break;
/*      */     case 14:
/* 1045 */       strFieldName = "score";
/* 1046 */       break;
/*      */     case 15:
/* 1048 */       strFieldName = "operator";
/* 1049 */       break;
/*      */     case 16:
/* 1051 */       strFieldName = "makeDate";
/* 1052 */       break;
/*      */     case 17:
/* 1054 */       strFieldName = "makeTime";
/* 1055 */       break;
/*      */     case 18:
/* 1057 */       strFieldName = "modifyDate";
/* 1058 */       break;
/*      */     case 19:
/* 1060 */       strFieldName = "modifyTime";
/* 1061 */       break;
/*      */     default:
/* 1063 */       strFieldName = "";
/*      */     }
/* 1065 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1071 */     if (strFieldName.equals("iD")) {
/* 1072 */       return 0;
/*      */     }
/* 1074 */     if (strFieldName.equals("agentCode")) {
/* 1075 */       return 0;
/*      */     }
/* 1077 */     if (strFieldName.equals("agentName")) {
/* 1078 */       return 0;
/*      */     }
/* 1080 */     if (strFieldName.equals("agentGrade")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("agentGroup")) {
/* 1084 */       return 0;
/*      */     }
/* 1086 */     if (strFieldName.equals("manageCom")) {
/* 1087 */       return 0;
/*      */     }
/* 1089 */     if (strFieldName.equals("branchType")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     if (strFieldName.equals("courseID")) {
/* 1093 */       return 0;
/*      */     }
/* 1095 */     if (strFieldName.equals("trainStart")) {
/* 1096 */       return 1;
/*      */     }
/* 1098 */     if (strFieldName.equals("trainEnd")) {
/* 1099 */       return 1;
/*      */     }
/* 1101 */     if (strFieldName.equals("trainAdd")) {
/* 1102 */       return 0;
/*      */     }
/* 1104 */     if (strFieldName.equals("hours")) {
/* 1105 */       return 0;
/*      */     }
/* 1107 */     if (strFieldName.equals("teacher")) {
/* 1108 */       return 0;
/*      */     }
/* 1110 */     if (strFieldName.equals("passFlag")) {
/* 1111 */       return 0;
/*      */     }
/* 1113 */     if (strFieldName.equals("score")) {
/* 1114 */       return 0;
/*      */     }
/* 1116 */     if (strFieldName.equals("operator")) {
/* 1117 */       return 0;
/*      */     }
/* 1119 */     if (strFieldName.equals("makeDate")) {
/* 1120 */       return 1;
/*      */     }
/* 1122 */     if (strFieldName.equals("makeTime")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("modifyDate")) {
/* 1126 */       return 1;
/*      */     }
/* 1128 */     if (strFieldName.equals("modifyTime")) {
/* 1129 */       return 0;
/*      */     }
/* 1131 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1137 */     int nFieldType = -1;
/* 1138 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1140 */       nFieldType = 0;
/* 1141 */       break;
/*      */     case 1:
/* 1143 */       nFieldType = 0;
/* 1144 */       break;
/*      */     case 2:
/* 1146 */       nFieldType = 0;
/* 1147 */       break;
/*      */     case 3:
/* 1149 */       nFieldType = 0;
/* 1150 */       break;
/*      */     case 4:
/* 1152 */       nFieldType = 0;
/* 1153 */       break;
/*      */     case 5:
/* 1155 */       nFieldType = 0;
/* 1156 */       break;
/*      */     case 6:
/* 1158 */       nFieldType = 0;
/* 1159 */       break;
/*      */     case 7:
/* 1161 */       nFieldType = 0;
/* 1162 */       break;
/*      */     case 8:
/* 1164 */       nFieldType = 1;
/* 1165 */       break;
/*      */     case 9:
/* 1167 */       nFieldType = 1;
/* 1168 */       break;
/*      */     case 10:
/* 1170 */       nFieldType = 0;
/* 1171 */       break;
/*      */     case 11:
/* 1173 */       nFieldType = 0;
/* 1174 */       break;
/*      */     case 12:
/* 1176 */       nFieldType = 0;
/* 1177 */       break;
/*      */     case 13:
/* 1179 */       nFieldType = 0;
/* 1180 */       break;
/*      */     case 14:
/* 1182 */       nFieldType = 0;
/* 1183 */       break;
/*      */     case 15:
/* 1185 */       nFieldType = 0;
/* 1186 */       break;
/*      */     case 16:
/* 1188 */       nFieldType = 1;
/* 1189 */       break;
/*      */     case 17:
/* 1191 */       nFieldType = 0;
/* 1192 */       break;
/*      */     case 18:
/* 1194 */       nFieldType = 1;
/* 1195 */       break;
/*      */     case 19:
/* 1197 */       nFieldType = 0;
/* 1198 */       break;
/*      */     default:
/* 1200 */       nFieldType = -1;
/*      */     }
/* 1202 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MTrainInfoSchema
 * JD-Core Version:    0.6.0
 */