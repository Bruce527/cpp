/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MCourseDB;
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
/*      */ public class MCourseSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String courseID;
/*      */   private String courseName;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String hour;
/*      */   private String developBranch;
/*      */   private String developer;
/*      */   private Date developeDate;
/*      */   private String noTi;
/*      */   private String operator;
/*      */   private String modifyOperator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String course1;
/*      */   private String course2;
/*      */   private String course3;
/*      */   private Date course4;
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*   64 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MCourseSchema()
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
/*   83 */     MCourseSchema cloned = (MCourseSchema)super.clone();
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
/*      */   public String getCourseID() {
/*  105 */     return this.courseID;
/*      */   }
/*      */ 
/*      */   public void setCourseID(String aCourseID) {
/*  109 */     this.courseID = aCourseID;
/*      */   }
/*      */ 
/*      */   public String getCourseName() {
/*  113 */     return this.courseName;
/*      */   }
/*      */ 
/*      */   public void setCourseName(String aCourseName) {
/*  117 */     this.courseName = aCourseName;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  121 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  125 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  129 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  133 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getHour() {
/*  137 */     return this.hour;
/*      */   }
/*      */ 
/*      */   public void setHour(String aHour) {
/*  141 */     this.hour = aHour;
/*      */   }
/*      */ 
/*      */   public String getDevelopBranch() {
/*  145 */     return this.developBranch;
/*      */   }
/*      */ 
/*      */   public void setDevelopBranch(String aDevelopBranch) {
/*  149 */     this.developBranch = aDevelopBranch;
/*      */   }
/*      */ 
/*      */   public String getDeveloper() {
/*  153 */     return this.developer;
/*      */   }
/*      */ 
/*      */   public void setDeveloper(String aDeveloper) {
/*  157 */     this.developer = aDeveloper;
/*      */   }
/*      */ 
/*      */   public String getDevelopeDate() {
/*  161 */     if (this.developeDate != null) {
/*  162 */       return this.fDate.getString(this.developeDate);
/*      */     }
/*  164 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDevelopeDate(Date aDevelopeDate) {
/*  168 */     this.developeDate = aDevelopeDate;
/*      */   }
/*      */ 
/*      */   public void setDevelopeDate(String aDevelopeDate) {
/*  172 */     if ((aDevelopeDate != null) && (!aDevelopeDate.equals("")))
/*      */     {
/*  174 */       this.developeDate = this.fDate.getDate(aDevelopeDate);
/*      */     }
/*      */     else
/*  177 */       this.developeDate = null;
/*      */   }
/*      */ 
/*      */   public String getNoTi()
/*      */   {
/*  182 */     return this.noTi;
/*      */   }
/*      */ 
/*      */   public void setNoTi(String aNoTi) {
/*  186 */     this.noTi = aNoTi;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  190 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  194 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator() {
/*  198 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  202 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  206 */     if (this.makeDate != null) {
/*  207 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  209 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  213 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  217 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  219 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  222 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  227 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  231 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  235 */     if (this.modifyDate != null) {
/*  236 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  238 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  242 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  246 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  248 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  251 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  256 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  260 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getCourse1() {
/*  264 */     return this.course1;
/*      */   }
/*      */ 
/*      */   public void setCourse1(String aCourse1) {
/*  268 */     this.course1 = aCourse1;
/*      */   }
/*      */ 
/*      */   public String getCourse2() {
/*  272 */     return this.course2;
/*      */   }
/*      */ 
/*      */   public void setCourse2(String aCourse2) {
/*  276 */     this.course2 = aCourse2;
/*      */   }
/*      */ 
/*      */   public String getCourse3() {
/*  280 */     return this.course3;
/*      */   }
/*      */ 
/*      */   public void setCourse3(String aCourse3) {
/*  284 */     this.course3 = aCourse3;
/*      */   }
/*      */ 
/*      */   public String getCourse4() {
/*  288 */     if (this.course4 != null) {
/*  289 */       return this.fDate.getString(this.course4);
/*      */     }
/*  291 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCourse4(Date aCourse4) {
/*  295 */     this.course4 = aCourse4;
/*      */   }
/*      */ 
/*      */   public void setCourse4(String aCourse4) {
/*  299 */     if ((aCourse4 != null) && (!aCourse4.equals("")))
/*      */     {
/*  301 */       this.course4 = this.fDate.getDate(aCourse4);
/*      */     }
/*      */     else
/*  304 */       this.course4 = null;
/*      */   }
/*      */ 
/*      */   public void setSchema(MCourseSchema aMCourseSchema)
/*      */   {
/*  311 */     this.iD = aMCourseSchema.getID();
/*  312 */     this.courseID = aMCourseSchema.getCourseID();
/*  313 */     this.courseName = aMCourseSchema.getCourseName();
/*  314 */     this.manageCom = aMCourseSchema.getManageCom();
/*  315 */     this.branchType = aMCourseSchema.getBranchType();
/*  316 */     this.hour = aMCourseSchema.getHour();
/*  317 */     this.developBranch = aMCourseSchema.getDevelopBranch();
/*  318 */     this.developer = aMCourseSchema.getDeveloper();
/*  319 */     this.developeDate = this.fDate.getDate(aMCourseSchema.getDevelopeDate());
/*  320 */     this.noTi = aMCourseSchema.getNoTi();
/*  321 */     this.operator = aMCourseSchema.getOperator();
/*  322 */     this.modifyOperator = aMCourseSchema.getModifyOperator();
/*  323 */     this.makeDate = this.fDate.getDate(aMCourseSchema.getMakeDate());
/*  324 */     this.makeTime = aMCourseSchema.getMakeTime();
/*  325 */     this.modifyDate = this.fDate.getDate(aMCourseSchema.getModifyDate());
/*  326 */     this.modifyTime = aMCourseSchema.getModifyTime();
/*  327 */     this.course1 = aMCourseSchema.getCourse1();
/*  328 */     this.course2 = aMCourseSchema.getCourse2();
/*  329 */     this.course3 = aMCourseSchema.getCourse3();
/*  330 */     this.course4 = this.fDate.getDate(aMCourseSchema.getCourse4());
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
/*  344 */       if (rs.getString("CourseID") == null)
/*  345 */         this.courseID = null;
/*      */       else {
/*  347 */         this.courseID = rs.getString("CourseID").trim();
/*      */       }
/*  349 */       if (rs.getString("CourseName") == null)
/*  350 */         this.courseName = null;
/*      */       else {
/*  352 */         this.courseName = rs.getString("CourseName").trim();
/*      */       }
/*  354 */       if (rs.getString("ManageCom") == null)
/*  355 */         this.manageCom = null;
/*      */       else {
/*  357 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  359 */       if (rs.getString("BranchType") == null)
/*  360 */         this.branchType = null;
/*      */       else {
/*  362 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  364 */       if (rs.getString("Hour") == null)
/*  365 */         this.hour = null;
/*      */       else {
/*  367 */         this.hour = rs.getString("Hour").trim();
/*      */       }
/*  369 */       if (rs.getString("DevelopBranch") == null)
/*  370 */         this.developBranch = null;
/*      */       else {
/*  372 */         this.developBranch = rs.getString("DevelopBranch").trim();
/*      */       }
/*  374 */       if (rs.getString("Developer") == null)
/*  375 */         this.developer = null;
/*      */       else {
/*  377 */         this.developer = rs.getString("Developer").trim();
/*      */       }
/*  379 */       this.developeDate = rs.getDate("DevelopeDate");
/*  380 */       if (rs.getString("NoTi") == null)
/*  381 */         this.noTi = null;
/*      */       else {
/*  383 */         this.noTi = rs.getString("NoTi").trim();
/*      */       }
/*  385 */       if (rs.getString("Operator") == null)
/*  386 */         this.operator = null;
/*      */       else {
/*  388 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  390 */       if (rs.getString("ModifyOperator") == null)
/*  391 */         this.modifyOperator = null;
/*      */       else {
/*  393 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  395 */       this.makeDate = rs.getDate("MakeDate");
/*  396 */       if (rs.getString("MakeTime") == null)
/*  397 */         this.makeTime = null;
/*      */       else {
/*  399 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  401 */       this.modifyDate = rs.getDate("ModifyDate");
/*  402 */       if (rs.getString("ModifyTime") == null)
/*  403 */         this.modifyTime = null;
/*      */       else {
/*  405 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  407 */       if (rs.getString("course1") == null)
/*  408 */         this.course1 = null;
/*      */       else {
/*  410 */         this.course1 = rs.getString("course1").trim();
/*      */       }
/*  412 */       if (rs.getString("course2") == null)
/*  413 */         this.course2 = null;
/*      */       else {
/*  415 */         this.course2 = rs.getString("course2").trim();
/*      */       }
/*  417 */       if (rs.getString("course3") == null)
/*  418 */         this.course3 = null;
/*      */       else {
/*  420 */         this.course3 = rs.getString("course3").trim();
/*      */       }
/*  422 */       this.course4 = rs.getDate("course4");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  426 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MCourse\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  428 */       CError tError = new CError();
/*  429 */       tError.moduleName = "MCourseSchema";
/*  430 */       tError.functionName = "setSchema";
/*  431 */       tError.errorMessage = sqle.toString();
/*  432 */       this.mErrors.addOneError(tError);
/*  433 */       return false;
/*      */     }
/*  435 */     return true;
/*      */   }
/*      */ 
/*      */   public MCourseSchema getSchema()
/*      */   {
/*  440 */     MCourseSchema aMCourseSchema = new MCourseSchema();
/*  441 */     aMCourseSchema.setSchema(this);
/*  442 */     return aMCourseSchema;
/*      */   }
/*      */ 
/*      */   public MCourseDB getDB()
/*      */   {
/*  447 */     MCourseDB aDBOper = new MCourseDB();
/*  448 */     aDBOper.setSchema(this);
/*  449 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  456 */     StringBuffer strReturn = new StringBuffer(256);
/*  457 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  458 */     strReturn.append(StrTool.cTrim(this.courseID)); strReturn.append("|");
/*  459 */     strReturn.append(StrTool.cTrim(this.courseName)); strReturn.append("|");
/*  460 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  461 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  462 */     strReturn.append(StrTool.cTrim(this.hour)); strReturn.append("|");
/*  463 */     strReturn.append(StrTool.cTrim(this.developBranch)); strReturn.append("|");
/*  464 */     strReturn.append(StrTool.cTrim(this.developer)); strReturn.append("|");
/*  465 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.developeDate))); strReturn.append("|");
/*  466 */     strReturn.append(StrTool.cTrim(this.noTi)); strReturn.append("|");
/*  467 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  468 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  469 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  470 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  471 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  472 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  473 */     strReturn.append(StrTool.cTrim(this.course1)); strReturn.append("|");
/*  474 */     strReturn.append(StrTool.cTrim(this.course2)); strReturn.append("|");
/*  475 */     strReturn.append(StrTool.cTrim(this.course3)); strReturn.append("|");
/*  476 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.course4)));
/*  477 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  485 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  486 */       this.courseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  487 */       this.courseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  488 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  489 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  490 */       this.hour = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  491 */       this.developBranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  492 */       this.developer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  493 */       this.developeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  494 */       this.noTi = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  495 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  496 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  497 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
/*  498 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  499 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  500 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  501 */       this.course1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  502 */       this.course2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  503 */       this.course3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  504 */       this.course4 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  509 */       CError tError = new CError();
/*  510 */       tError.moduleName = "MCourseSchema";
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
/*  528 */     if (FCode.equalsIgnoreCase("courseID"))
/*      */     {
/*  530 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.courseID));
/*      */     }
/*  532 */     if (FCode.equalsIgnoreCase("courseName"))
/*      */     {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.courseName));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  538 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  540 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  542 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  544 */     if (FCode.equalsIgnoreCase("hour"))
/*      */     {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.hour));
/*      */     }
/*  548 */     if (FCode.equalsIgnoreCase("developBranch"))
/*      */     {
/*  550 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.developBranch));
/*      */     }
/*  552 */     if (FCode.equalsIgnoreCase("developer"))
/*      */     {
/*  554 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.developer));
/*      */     }
/*  556 */     if (FCode.equalsIgnoreCase("developeDate"))
/*      */     {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDevelopeDate()));
/*      */     }
/*  560 */     if (FCode.equalsIgnoreCase("noTi"))
/*      */     {
/*  562 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noTi));
/*      */     }
/*  564 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  566 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  568 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  572 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  574 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  576 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  578 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  580 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  584 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  586 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  588 */     if (FCode.equalsIgnoreCase("course1"))
/*      */     {
/*  590 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.course1));
/*      */     }
/*  592 */     if (FCode.equalsIgnoreCase("course2"))
/*      */     {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.course2));
/*      */     }
/*  596 */     if (FCode.equalsIgnoreCase("course3"))
/*      */     {
/*  598 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.course3));
/*      */     }
/*  600 */     if (FCode.equalsIgnoreCase("course4"))
/*      */     {
/*  602 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCourse4()));
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
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.courseID);
/*  623 */       break;
/*      */     case 2:
/*  625 */       strFieldValue = StrTool.GBKToUnicode(this.courseName);
/*  626 */       break;
/*      */     case 3:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  629 */       break;
/*      */     case 4:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  632 */       break;
/*      */     case 5:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.hour);
/*  635 */       break;
/*      */     case 6:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.developBranch);
/*  638 */       break;
/*      */     case 7:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.developer);
/*  641 */       break;
/*      */     case 8:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDevelopeDate()));
/*  644 */       break;
/*      */     case 9:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(this.noTi);
/*  647 */       break;
/*      */     case 10:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  650 */       break;
/*      */     case 11:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  653 */       break;
/*      */     case 12:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  656 */       break;
/*      */     case 13:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  659 */       break;
/*      */     case 14:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  662 */       break;
/*      */     case 15:
/*  664 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  665 */       break;
/*      */     case 16:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(this.course1);
/*  668 */       break;
/*      */     case 17:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(this.course2);
/*  671 */       break;
/*      */     case 18:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(this.course3);
/*  674 */       break;
/*      */     case 19:
/*  676 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCourse4()));
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
/*  702 */     if (FCode.equalsIgnoreCase("courseID"))
/*      */     {
/*  704 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  706 */         this.courseID = FValue.trim();
/*      */       }
/*      */       else
/*  709 */         this.courseID = null;
/*      */     }
/*  711 */     if (FCode.equalsIgnoreCase("courseName"))
/*      */     {
/*  713 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  715 */         this.courseName = FValue.trim();
/*      */       }
/*      */       else
/*  718 */         this.courseName = null;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  722 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  724 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  727 */         this.manageCom = null;
/*      */     }
/*  729 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  731 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  733 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  736 */         this.branchType = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("hour"))
/*      */     {
/*  740 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  742 */         this.hour = FValue.trim();
/*      */       }
/*      */       else
/*  745 */         this.hour = null;
/*      */     }
/*  747 */     if (FCode.equalsIgnoreCase("developBranch"))
/*      */     {
/*  749 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  751 */         this.developBranch = FValue.trim();
/*      */       }
/*      */       else
/*  754 */         this.developBranch = null;
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("developer"))
/*      */     {
/*  758 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  760 */         this.developer = FValue.trim();
/*      */       }
/*      */       else
/*  763 */         this.developer = null;
/*      */     }
/*  765 */     if (FCode.equalsIgnoreCase("developeDate"))
/*      */     {
/*  767 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  769 */         this.developeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  772 */         this.developeDate = null;
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("noTi"))
/*      */     {
/*  776 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  778 */         this.noTi = FValue.trim();
/*      */       }
/*      */       else
/*  781 */         this.noTi = null;
/*      */     }
/*  783 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  785 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  787 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/*  790 */         this.operator = null;
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  794 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  796 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/*  799 */         this.modifyOperator = null;
/*      */     }
/*  801 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  803 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  805 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  808 */         this.makeDate = null;
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  812 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  814 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/*  817 */         this.makeTime = null;
/*      */     }
/*  819 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  821 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  823 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  826 */         this.modifyDate = null;
/*      */     }
/*  828 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  830 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  832 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/*  835 */         this.modifyTime = null;
/*      */     }
/*  837 */     if (FCode.equalsIgnoreCase("course1"))
/*      */     {
/*  839 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  841 */         this.course1 = FValue.trim();
/*      */       }
/*      */       else
/*  844 */         this.course1 = null;
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("course2"))
/*      */     {
/*  848 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  850 */         this.course2 = FValue.trim();
/*      */       }
/*      */       else
/*  853 */         this.course2 = null;
/*      */     }
/*  855 */     if (FCode.equalsIgnoreCase("course3"))
/*      */     {
/*  857 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  859 */         this.course3 = FValue.trim();
/*      */       }
/*      */       else
/*  862 */         this.course3 = null;
/*      */     }
/*  864 */     if (FCode.equalsIgnoreCase("course4"))
/*      */     {
/*  866 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  868 */         this.course4 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  871 */         this.course4 = null;
/*      */     }
/*  873 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  878 */     if (otherObject == null) return false;
/*  879 */     if (this == otherObject) return true;
/*  880 */     if (getClass() != otherObject.getClass()) return false;
/*  881 */     MCourseSchema other = (MCourseSchema)otherObject;
/*  882 */     if ((this.iD == null) && (other.getID() != null)) return false;
/*  883 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/*  884 */     if ((this.courseID == null) && (other.getCourseID() != null)) return false;
/*  885 */     if ((this.courseID != null) && (!this.courseID.equals(other.getCourseID()))) return false;
/*  886 */     if ((this.courseName == null) && (other.getCourseName() != null)) return false;
/*  887 */     if ((this.courseName != null) && (!this.courseName.equals(other.getCourseName()))) return false;
/*  888 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  889 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  890 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/*  891 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/*  892 */     if ((this.hour == null) && (other.getHour() != null)) return false;
/*  893 */     if ((this.hour != null) && (!this.hour.equals(other.getHour()))) return false;
/*  894 */     if ((this.developBranch == null) && (other.getDevelopBranch() != null)) return false;
/*  895 */     if ((this.developBranch != null) && (!this.developBranch.equals(other.getDevelopBranch()))) return false;
/*  896 */     if ((this.developer == null) && (other.getDeveloper() != null)) return false;
/*  897 */     if ((this.developer != null) && (!this.developer.equals(other.getDeveloper()))) return false;
/*  898 */     if ((this.developeDate == null) && (other.getDevelopeDate() != null)) return false;
/*  899 */     if ((this.developeDate != null) && (!this.fDate.getString(this.developeDate).equals(other.getDevelopeDate()))) return false;
/*  900 */     if ((this.noTi == null) && (other.getNoTi() != null)) return false;
/*  901 */     if ((this.noTi != null) && (!this.noTi.equals(other.getNoTi()))) return false;
/*  902 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  903 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  904 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/*  905 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/*  906 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  907 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  908 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  909 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  910 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  911 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  912 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  913 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/*  914 */     if ((this.course1 == null) && (other.getCourse1() != null)) return false;
/*  915 */     if ((this.course1 != null) && (!this.course1.equals(other.getCourse1()))) return false;
/*  916 */     if ((this.course2 == null) && (other.getCourse2() != null)) return false;
/*  917 */     if ((this.course2 != null) && (!this.course2.equals(other.getCourse2()))) return false;
/*  918 */     if ((this.course3 == null) && (other.getCourse3() != null)) return false;
/*  919 */     if ((this.course3 != null) && (!this.course3.equals(other.getCourse3()))) return false;
/*  920 */     if ((this.course4 == null) && (other.getCourse4() != null)) return false;
/*  921 */     return (this.course4 == null) || (this.fDate.getString(this.course4).equals(other.getCourse4()));
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
/*  937 */     if (strFieldName.equals("courseID")) {
/*  938 */       return 1;
/*      */     }
/*  940 */     if (strFieldName.equals("courseName")) {
/*  941 */       return 2;
/*      */     }
/*  943 */     if (strFieldName.equals("manageCom")) {
/*  944 */       return 3;
/*      */     }
/*  946 */     if (strFieldName.equals("branchType")) {
/*  947 */       return 4;
/*      */     }
/*  949 */     if (strFieldName.equals("hour")) {
/*  950 */       return 5;
/*      */     }
/*  952 */     if (strFieldName.equals("developBranch")) {
/*  953 */       return 6;
/*      */     }
/*  955 */     if (strFieldName.equals("developer")) {
/*  956 */       return 7;
/*      */     }
/*  958 */     if (strFieldName.equals("developeDate")) {
/*  959 */       return 8;
/*      */     }
/*  961 */     if (strFieldName.equals("noTi")) {
/*  962 */       return 9;
/*      */     }
/*  964 */     if (strFieldName.equals("operator")) {
/*  965 */       return 10;
/*      */     }
/*  967 */     if (strFieldName.equals("modifyOperator")) {
/*  968 */       return 11;
/*      */     }
/*  970 */     if (strFieldName.equals("makeDate")) {
/*  971 */       return 12;
/*      */     }
/*  973 */     if (strFieldName.equals("makeTime")) {
/*  974 */       return 13;
/*      */     }
/*  976 */     if (strFieldName.equals("modifyDate")) {
/*  977 */       return 14;
/*      */     }
/*  979 */     if (strFieldName.equals("modifyTime")) {
/*  980 */       return 15;
/*      */     }
/*  982 */     if (strFieldName.equals("course1")) {
/*  983 */       return 16;
/*      */     }
/*  985 */     if (strFieldName.equals("course2")) {
/*  986 */       return 17;
/*      */     }
/*  988 */     if (strFieldName.equals("course3")) {
/*  989 */       return 18;
/*      */     }
/*  991 */     if (strFieldName.equals("course4")) {
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
/* 1006 */       strFieldName = "courseID";
/* 1007 */       break;
/*      */     case 2:
/* 1009 */       strFieldName = "courseName";
/* 1010 */       break;
/*      */     case 3:
/* 1012 */       strFieldName = "manageCom";
/* 1013 */       break;
/*      */     case 4:
/* 1015 */       strFieldName = "branchType";
/* 1016 */       break;
/*      */     case 5:
/* 1018 */       strFieldName = "hour";
/* 1019 */       break;
/*      */     case 6:
/* 1021 */       strFieldName = "developBranch";
/* 1022 */       break;
/*      */     case 7:
/* 1024 */       strFieldName = "developer";
/* 1025 */       break;
/*      */     case 8:
/* 1027 */       strFieldName = "developeDate";
/* 1028 */       break;
/*      */     case 9:
/* 1030 */       strFieldName = "noTi";
/* 1031 */       break;
/*      */     case 10:
/* 1033 */       strFieldName = "operator";
/* 1034 */       break;
/*      */     case 11:
/* 1036 */       strFieldName = "modifyOperator";
/* 1037 */       break;
/*      */     case 12:
/* 1039 */       strFieldName = "makeDate";
/* 1040 */       break;
/*      */     case 13:
/* 1042 */       strFieldName = "makeTime";
/* 1043 */       break;
/*      */     case 14:
/* 1045 */       strFieldName = "modifyDate";
/* 1046 */       break;
/*      */     case 15:
/* 1048 */       strFieldName = "modifyTime";
/* 1049 */       break;
/*      */     case 16:
/* 1051 */       strFieldName = "course1";
/* 1052 */       break;
/*      */     case 17:
/* 1054 */       strFieldName = "course2";
/* 1055 */       break;
/*      */     case 18:
/* 1057 */       strFieldName = "course3";
/* 1058 */       break;
/*      */     case 19:
/* 1060 */       strFieldName = "course4";
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
/* 1074 */     if (strFieldName.equals("courseID")) {
/* 1075 */       return 0;
/*      */     }
/* 1077 */     if (strFieldName.equals("courseName")) {
/* 1078 */       return 0;
/*      */     }
/* 1080 */     if (strFieldName.equals("manageCom")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("branchType")) {
/* 1084 */       return 0;
/*      */     }
/* 1086 */     if (strFieldName.equals("hour")) {
/* 1087 */       return 0;
/*      */     }
/* 1089 */     if (strFieldName.equals("developBranch")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     if (strFieldName.equals("developer")) {
/* 1093 */       return 0;
/*      */     }
/* 1095 */     if (strFieldName.equals("developeDate")) {
/* 1096 */       return 1;
/*      */     }
/* 1098 */     if (strFieldName.equals("noTi")) {
/* 1099 */       return 0;
/*      */     }
/* 1101 */     if (strFieldName.equals("operator")) {
/* 1102 */       return 0;
/*      */     }
/* 1104 */     if (strFieldName.equals("modifyOperator")) {
/* 1105 */       return 0;
/*      */     }
/* 1107 */     if (strFieldName.equals("makeDate")) {
/* 1108 */       return 1;
/*      */     }
/* 1110 */     if (strFieldName.equals("makeTime")) {
/* 1111 */       return 0;
/*      */     }
/* 1113 */     if (strFieldName.equals("modifyDate")) {
/* 1114 */       return 1;
/*      */     }
/* 1116 */     if (strFieldName.equals("modifyTime")) {
/* 1117 */       return 0;
/*      */     }
/* 1119 */     if (strFieldName.equals("course1")) {
/* 1120 */       return 0;
/*      */     }
/* 1122 */     if (strFieldName.equals("course2")) {
/* 1123 */       return 0;
/*      */     }
/* 1125 */     if (strFieldName.equals("course3")) {
/* 1126 */       return 0;
/*      */     }
/* 1128 */     if (strFieldName.equals("course4")) {
/* 1129 */       return 1;
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
/* 1167 */       nFieldType = 0;
/* 1168 */       break;
/*      */     case 10:
/* 1170 */       nFieldType = 0;
/* 1171 */       break;
/*      */     case 11:
/* 1173 */       nFieldType = 0;
/* 1174 */       break;
/*      */     case 12:
/* 1176 */       nFieldType = 1;
/* 1177 */       break;
/*      */     case 13:
/* 1179 */       nFieldType = 0;
/* 1180 */       break;
/*      */     case 14:
/* 1182 */       nFieldType = 1;
/* 1183 */       break;
/*      */     case 15:
/* 1185 */       nFieldType = 0;
/* 1186 */       break;
/*      */     case 16:
/* 1188 */       nFieldType = 0;
/* 1189 */       break;
/*      */     case 17:
/* 1191 */       nFieldType = 0;
/* 1192 */       break;
/*      */     case 18:
/* 1194 */       nFieldType = 0;
/* 1195 */       break;
/*      */     case 19:
/* 1197 */       nFieldType = 1;
/* 1198 */       break;
/*      */     default:
/* 1200 */       nFieldType = -1;
/*      */     }
/* 1202 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MCourseSchema
 * JD-Core Version:    0.6.0
 */