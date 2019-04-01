/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MMessageConfigDB;
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
/*      */ public class MMessageConfigSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String iD;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String messageType;
/*      */   private String messageName;
/*      */   private String messageContent;
/*      */   private String messageContent2;
/*      */   private String messageContent3;
/*      */   private String messageContent4;
/*      */   private String messageContent5;
/*      */   private String messageContent6;
/*      */   private int beforeDays;
/*      */   private int statDays;
/*      */   private Date startDate;
/*      */   private Date endDate;
/*      */   private String statCycle;
/*      */   private String script;
/*      */   private String vF01;
/*      */   private String nF01;
/*      */   private int iF01;
/*      */   private double dF02;
/*      */   private Date date01;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   public static final int FIELDNUM = 25;
/*      */   private static String[] PK;
/*   74 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MMessageConfigSchema()
/*      */   {
/*   81 */     this.mErrors = new CErrors();
/*      */ 
/*   83 */     String[] pk = new String[1];
/*   84 */     pk[0] = "ID";
/*      */ 
/*   86 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   93 */     MMessageConfigSchema cloned = (MMessageConfigSchema)super.clone();
/*   94 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   95 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   96 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  102 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getID()
/*      */   {
/*  107 */     return this.iD;
/*      */   }
/*      */ 
/*      */   public void setID(String aID) {
/*  111 */     this.iD = aID;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  115 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  119 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getBranchType() {
/*  123 */     return this.branchType;
/*      */   }
/*      */ 
/*      */   public void setBranchType(String aBranchType) {
/*  127 */     this.branchType = aBranchType;
/*      */   }
/*      */ 
/*      */   public String getMessageType() {
/*  131 */     return this.messageType;
/*      */   }
/*      */ 
/*      */   public void setMessageType(String aMessageType) {
/*  135 */     this.messageType = aMessageType;
/*      */   }
/*      */ 
/*      */   public String getMessageName() {
/*  139 */     return this.messageName;
/*      */   }
/*      */ 
/*      */   public void setMessageName(String aMessageName) {
/*  143 */     this.messageName = aMessageName;
/*      */   }
/*      */ 
/*      */   public String getMessageContent() {
/*  147 */     return this.messageContent;
/*      */   }
/*      */ 
/*      */   public void setMessageContent(String aMessageContent) {
/*  151 */     this.messageContent = aMessageContent;
/*      */   }
/*      */ 
/*      */   public String getMessageContent2() {
/*  155 */     return this.messageContent2;
/*      */   }
/*      */ 
/*      */   public void setMessageContent2(String aMessageContent2) {
/*  159 */     this.messageContent2 = aMessageContent2;
/*      */   }
/*      */ 
/*      */   public String getMessageContent3() {
/*  163 */     return this.messageContent3;
/*      */   }
/*      */ 
/*      */   public void setMessageContent3(String aMessageContent3) {
/*  167 */     this.messageContent3 = aMessageContent3;
/*      */   }
/*      */ 
/*      */   public String getMessageContent4() {
/*  171 */     return this.messageContent4;
/*      */   }
/*      */ 
/*      */   public void setMessageContent4(String aMessageContent4) {
/*  175 */     this.messageContent4 = aMessageContent4;
/*      */   }
/*      */ 
/*      */   public String getMessageContent5() {
/*  179 */     return this.messageContent5;
/*      */   }
/*      */ 
/*      */   public void setMessageContent5(String aMessageContent5) {
/*  183 */     this.messageContent5 = aMessageContent5;
/*      */   }
/*      */ 
/*      */   public String getMessageContent6() {
/*  187 */     return this.messageContent6;
/*      */   }
/*      */ 
/*      */   public void setMessageContent6(String aMessageContent6) {
/*  191 */     this.messageContent6 = aMessageContent6;
/*      */   }
/*      */ 
/*      */   public int getBeforeDays() {
/*  195 */     return this.beforeDays;
/*      */   }
/*      */ 
/*      */   public void setBeforeDays(int aBeforeDays) {
/*  199 */     this.beforeDays = aBeforeDays;
/*      */   }
/*      */ 
/*      */   public void setBeforeDays(String aBeforeDays) {
/*  203 */     if ((aBeforeDays != null) && (!aBeforeDays.equals("")))
/*      */     {
/*  205 */       Integer tInteger = new Integer(aBeforeDays);
/*  206 */       int i = tInteger.intValue();
/*  207 */       this.beforeDays = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getStatDays()
/*      */   {
/*  213 */     return this.statDays;
/*      */   }
/*      */ 
/*      */   public void setStatDays(int aStatDays) {
/*  217 */     this.statDays = aStatDays;
/*      */   }
/*      */ 
/*      */   public void setStatDays(String aStatDays) {
/*  221 */     if ((aStatDays != null) && (!aStatDays.equals("")))
/*      */     {
/*  223 */       Integer tInteger = new Integer(aStatDays);
/*  224 */       int i = tInteger.intValue();
/*  225 */       this.statDays = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  231 */     if (this.startDate != null) {
/*  232 */       return this.fDate.getString(this.startDate);
/*      */     }
/*  234 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDate(Date aStartDate) {
/*  238 */     this.startDate = aStartDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String aStartDate) {
/*  242 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*      */     {
/*  244 */       this.startDate = this.fDate.getDate(aStartDate);
/*      */     }
/*      */     else
/*  247 */       this.startDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  252 */     if (this.endDate != null) {
/*  253 */       return this.fDate.getString(this.endDate);
/*      */     }
/*  255 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDate(Date aEndDate) {
/*  259 */     this.endDate = aEndDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String aEndDate) {
/*  263 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*      */     {
/*  265 */       this.endDate = this.fDate.getDate(aEndDate);
/*      */     }
/*      */     else
/*  268 */       this.endDate = null;
/*      */   }
/*      */ 
/*      */   public String getStatCycle()
/*      */   {
/*  273 */     return this.statCycle;
/*      */   }
/*      */ 
/*      */   public void setStatCycle(String aStatCycle) {
/*  277 */     this.statCycle = aStatCycle;
/*      */   }
/*      */ 
/*      */   public String getScript() {
/*  281 */     return this.script;
/*      */   }
/*      */ 
/*      */   public void setScript(String aScript) {
/*  285 */     this.script = aScript;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  289 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  293 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  297 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  301 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  305 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  309 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  313 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  315 */       Integer tInteger = new Integer(aIF01);
/*  316 */       int i = tInteger.intValue();
/*  317 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  323 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  327 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  331 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  333 */       Double tDouble = new Double(aDF02);
/*  334 */       double d = tDouble.doubleValue();
/*  335 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  341 */     if (this.date01 != null) {
/*  342 */       return this.fDate.getString(this.date01);
/*      */     }
/*  344 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  348 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  352 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  354 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  357 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  362 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  366 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  370 */     if (this.makeDate != null) {
/*  371 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  373 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  377 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  381 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  383 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  386 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  391 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  395 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(MMessageConfigSchema aMMessageConfigSchema)
/*      */   {
/*  401 */     this.iD = aMMessageConfigSchema.getID();
/*  402 */     this.manageCom = aMMessageConfigSchema.getManageCom();
/*  403 */     this.branchType = aMMessageConfigSchema.getBranchType();
/*  404 */     this.messageType = aMMessageConfigSchema.getMessageType();
/*  405 */     this.messageName = aMMessageConfigSchema.getMessageName();
/*  406 */     this.messageContent = aMMessageConfigSchema.getMessageContent();
/*  407 */     this.messageContent2 = aMMessageConfigSchema.getMessageContent2();
/*  408 */     this.messageContent3 = aMMessageConfigSchema.getMessageContent3();
/*  409 */     this.messageContent4 = aMMessageConfigSchema.getMessageContent4();
/*  410 */     this.messageContent5 = aMMessageConfigSchema.getMessageContent5();
/*  411 */     this.messageContent6 = aMMessageConfigSchema.getMessageContent6();
/*  412 */     this.beforeDays = aMMessageConfigSchema.getBeforeDays();
/*  413 */     this.statDays = aMMessageConfigSchema.getStatDays();
/*  414 */     this.startDate = this.fDate.getDate(aMMessageConfigSchema.getStartDate());
/*  415 */     this.endDate = this.fDate.getDate(aMMessageConfigSchema.getEndDate());
/*  416 */     this.statCycle = aMMessageConfigSchema.getStatCycle();
/*  417 */     this.script = aMMessageConfigSchema.getScript();
/*  418 */     this.vF01 = aMMessageConfigSchema.getVF01();
/*  419 */     this.nF01 = aMMessageConfigSchema.getNF01();
/*  420 */     this.iF01 = aMMessageConfigSchema.getIF01();
/*  421 */     this.dF02 = aMMessageConfigSchema.getDF02();
/*  422 */     this.date01 = this.fDate.getDate(aMMessageConfigSchema.getDate01());
/*  423 */     this.operator = aMMessageConfigSchema.getOperator();
/*  424 */     this.makeDate = this.fDate.getDate(aMMessageConfigSchema.getMakeDate());
/*  425 */     this.makeTime = aMMessageConfigSchema.getMakeTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  434 */       if (rs.getString("ID") == null)
/*  435 */         this.iD = null;
/*      */       else {
/*  437 */         this.iD = rs.getString("ID").trim();
/*      */       }
/*  439 */       if (rs.getString("ManageCom") == null)
/*  440 */         this.manageCom = null;
/*      */       else {
/*  442 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  444 */       if (rs.getString("BranchType") == null)
/*  445 */         this.branchType = null;
/*      */       else {
/*  447 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  449 */       if (rs.getString("MessageType") == null)
/*  450 */         this.messageType = null;
/*      */       else {
/*  452 */         this.messageType = rs.getString("MessageType").trim();
/*      */       }
/*  454 */       if (rs.getString("MessageName") == null)
/*  455 */         this.messageName = null;
/*      */       else {
/*  457 */         this.messageName = rs.getString("MessageName").trim();
/*      */       }
/*  459 */       if (rs.getString("MessageContent") == null)
/*  460 */         this.messageContent = null;
/*      */       else {
/*  462 */         this.messageContent = rs.getString("MessageContent").trim();
/*      */       }
/*  464 */       if (rs.getString("MessageContent2") == null)
/*  465 */         this.messageContent2 = null;
/*      */       else {
/*  467 */         this.messageContent2 = rs.getString("MessageContent2").trim();
/*      */       }
/*  469 */       if (rs.getString("MessageContent3") == null)
/*  470 */         this.messageContent3 = null;
/*      */       else {
/*  472 */         this.messageContent3 = rs.getString("MessageContent3").trim();
/*      */       }
/*  474 */       if (rs.getString("MessageContent4") == null)
/*  475 */         this.messageContent4 = null;
/*      */       else {
/*  477 */         this.messageContent4 = rs.getString("MessageContent4").trim();
/*      */       }
/*  479 */       if (rs.getString("MessageContent5") == null)
/*  480 */         this.messageContent5 = null;
/*      */       else {
/*  482 */         this.messageContent5 = rs.getString("MessageContent5").trim();
/*      */       }
/*  484 */       if (rs.getString("MessageContent6") == null)
/*  485 */         this.messageContent6 = null;
/*      */       else {
/*  487 */         this.messageContent6 = rs.getString("MessageContent6").trim();
/*      */       }
/*  489 */       this.beforeDays = rs.getInt("BeforeDays");
/*  490 */       this.statDays = rs.getInt("StatDays");
/*  491 */       this.startDate = rs.getDate("StartDate");
/*  492 */       this.endDate = rs.getDate("EndDate");
/*  493 */       if (rs.getString("StatCycle") == null)
/*  494 */         this.statCycle = null;
/*      */       else {
/*  496 */         this.statCycle = rs.getString("StatCycle").trim();
/*      */       }
/*  498 */       if (rs.getString("Script") == null)
/*  499 */         this.script = null;
/*      */       else {
/*  501 */         this.script = rs.getString("Script").trim();
/*      */       }
/*  503 */       if (rs.getString("VF01") == null)
/*  504 */         this.vF01 = null;
/*      */       else {
/*  506 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  508 */       if (rs.getString("NF01") == null)
/*  509 */         this.nF01 = null;
/*      */       else {
/*  511 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  513 */       this.iF01 = rs.getInt("IF01");
/*  514 */       this.dF02 = rs.getDouble("DF02");
/*  515 */       this.date01 = rs.getDate("Date01");
/*  516 */       if (rs.getString("Operator") == null)
/*  517 */         this.operator = null;
/*      */       else {
/*  519 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  521 */       this.makeDate = rs.getDate("MakeDate");
/*  522 */       if (rs.getString("MakeTime") == null)
/*  523 */         this.makeTime = null;
/*      */       else {
/*  525 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  530 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MMessageConfig\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  532 */       CError tError = new CError();
/*  533 */       tError.moduleName = "MMessageConfigSchema";
/*  534 */       tError.functionName = "setSchema";
/*  535 */       tError.errorMessage = sqle.toString();
/*  536 */       this.mErrors.addOneError(tError);
/*  537 */       return false;
/*      */     }
/*  539 */     return true;
/*      */   }
/*      */ 
/*      */   public MMessageConfigSchema getSchema()
/*      */   {
/*  544 */     MMessageConfigSchema aMMessageConfigSchema = new MMessageConfigSchema();
/*  545 */     aMMessageConfigSchema.setSchema(this);
/*  546 */     return aMMessageConfigSchema;
/*      */   }
/*      */ 
/*      */   public MMessageConfigDB getDB()
/*      */   {
/*  551 */     MMessageConfigDB aDBOper = new MMessageConfigDB();
/*  552 */     aDBOper.setSchema(this);
/*  553 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  560 */     StringBuffer strReturn = new StringBuffer(256);
/*  561 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/*  562 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  563 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  564 */     strReturn.append(StrTool.cTrim(this.messageType)); strReturn.append("|");
/*  565 */     strReturn.append(StrTool.cTrim(this.messageName)); strReturn.append("|");
/*  566 */     strReturn.append(StrTool.cTrim(this.messageContent)); strReturn.append("|");
/*  567 */     strReturn.append(StrTool.cTrim(this.messageContent2)); strReturn.append("|");
/*  568 */     strReturn.append(StrTool.cTrim(this.messageContent3)); strReturn.append("|");
/*  569 */     strReturn.append(StrTool.cTrim(this.messageContent4)); strReturn.append("|");
/*  570 */     strReturn.append(StrTool.cTrim(this.messageContent5)); strReturn.append("|");
/*  571 */     strReturn.append(StrTool.cTrim(this.messageContent6)); strReturn.append("|");
/*  572 */     strReturn.append(ChgData.chgData(this.beforeDays)); strReturn.append("|");
/*  573 */     strReturn.append(ChgData.chgData(this.statDays)); strReturn.append("|");
/*  574 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  575 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/*  576 */     strReturn.append(StrTool.cTrim(this.statCycle)); strReturn.append("|");
/*  577 */     strReturn.append(StrTool.cTrim(this.script)); strReturn.append("|");
/*  578 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  579 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  580 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  581 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  582 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  583 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  584 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  585 */     strReturn.append(StrTool.cTrim(this.makeTime));
/*  586 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  594 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  595 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  596 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  597 */       this.messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  598 */       this.messageName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  599 */       this.messageContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  600 */       this.messageContent2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  601 */       this.messageContent3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  602 */       this.messageContent4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  603 */       this.messageContent5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  604 */       this.messageContent6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  605 */       this.beforeDays = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|"))).intValue();
/*  606 */       this.statDays = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|"))).intValue();
/*  607 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
/*  608 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  609 */       this.statCycle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  610 */       this.script = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  611 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  612 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  613 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|"))).intValue();
/*  614 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|"))).doubleValue();
/*  615 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  616 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  617 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  618 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  623 */       CError tError = new CError();
/*  624 */       tError.moduleName = "MMessageConfigSchema";
/*  625 */       tError.functionName = "decode";
/*  626 */       tError.errorMessage = ex.toString();
/*  627 */       this.mErrors.addOneError(tError);
/*      */ 
/*  629 */       return false;
/*      */     }
/*  631 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  637 */     String strReturn = "";
/*  638 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*      */     }
/*  642 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  646 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  650 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  652 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageType));
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("messageName"))
/*      */     {
/*  656 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageName));
/*      */     }
/*  658 */     if (FCode.equalsIgnoreCase("messageContent"))
/*      */     {
/*  660 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent));
/*      */     }
/*  662 */     if (FCode.equalsIgnoreCase("messageContent2"))
/*      */     {
/*  664 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent2));
/*      */     }
/*  666 */     if (FCode.equalsIgnoreCase("messageContent3"))
/*      */     {
/*  668 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent3));
/*      */     }
/*  670 */     if (FCode.equalsIgnoreCase("messageContent4"))
/*      */     {
/*  672 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent4));
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("messageContent5"))
/*      */     {
/*  676 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent5));
/*      */     }
/*  678 */     if (FCode.equalsIgnoreCase("messageContent6"))
/*      */     {
/*  680 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.messageContent6));
/*      */     }
/*  682 */     if (FCode.equalsIgnoreCase("beforeDays"))
/*      */     {
/*  684 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.beforeDays));
/*      */     }
/*  686 */     if (FCode.equalsIgnoreCase("statDays"))
/*      */     {
/*  688 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statDays));
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  692 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*      */     }
/*  694 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  696 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*      */     }
/*  698 */     if (FCode.equalsIgnoreCase("statCycle"))
/*      */     {
/*  700 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.statCycle));
/*      */     }
/*  702 */     if (FCode.equalsIgnoreCase("script"))
/*      */     {
/*  704 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.script));
/*      */     }
/*  706 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  708 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  712 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  714 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  716 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  718 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  720 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  722 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  724 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  738 */     if (strReturn.equals(""))
/*      */     {
/*  740 */       strReturn = "null";
/*      */     }
/*      */ 
/*  743 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  750 */     String strFieldValue = "";
/*  751 */     switch (nFieldIndex) {
/*      */     case 0:
/*  753 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/*  754 */       break;
/*      */     case 1:
/*  756 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  757 */       break;
/*      */     case 2:
/*  759 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  760 */       break;
/*      */     case 3:
/*  762 */       strFieldValue = StrTool.GBKToUnicode(this.messageType);
/*  763 */       break;
/*      */     case 4:
/*  765 */       strFieldValue = StrTool.GBKToUnicode(this.messageName);
/*  766 */       break;
/*      */     case 5:
/*  768 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent);
/*  769 */       break;
/*      */     case 6:
/*  771 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent2);
/*  772 */       break;
/*      */     case 7:
/*  774 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent3);
/*  775 */       break;
/*      */     case 8:
/*  777 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent4);
/*  778 */       break;
/*      */     case 9:
/*  780 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent5);
/*  781 */       break;
/*      */     case 10:
/*  783 */       strFieldValue = StrTool.GBKToUnicode(this.messageContent6);
/*  784 */       break;
/*      */     case 11:
/*  786 */       strFieldValue = String.valueOf(this.beforeDays);
/*  787 */       break;
/*      */     case 12:
/*  789 */       strFieldValue = String.valueOf(this.statDays);
/*  790 */       break;
/*      */     case 13:
/*  792 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  793 */       break;
/*      */     case 14:
/*  795 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*  796 */       break;
/*      */     case 15:
/*  798 */       strFieldValue = StrTool.GBKToUnicode(this.statCycle);
/*  799 */       break;
/*      */     case 16:
/*  801 */       strFieldValue = StrTool.GBKToUnicode(this.script);
/*  802 */       break;
/*      */     case 17:
/*  804 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  805 */       break;
/*      */     case 18:
/*  807 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  808 */       break;
/*      */     case 19:
/*  810 */       strFieldValue = String.valueOf(this.iF01);
/*  811 */       break;
/*      */     case 20:
/*  813 */       strFieldValue = String.valueOf(this.dF02);
/*  814 */       break;
/*      */     case 21:
/*  816 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  817 */       break;
/*      */     case 22:
/*  819 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  820 */       break;
/*      */     case 23:
/*  822 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  823 */       break;
/*      */     case 24:
/*  825 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  826 */       break;
/*      */     default:
/*  828 */       strFieldValue = "";
/*      */     }
/*  830 */     if (strFieldValue.equals("")) {
/*  831 */       strFieldValue = "null";
/*      */     }
/*  833 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  839 */     if (StrTool.cTrim(FCode).equals("")) {
/*  840 */       return false;
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("iD"))
/*      */     {
/*  844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  846 */         this.iD = FValue.trim();
/*      */       }
/*      */       else
/*  849 */         this.iD = null;
/*      */     }
/*  851 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  855 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/*  858 */         this.manageCom = null;
/*      */     }
/*  860 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  864 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/*  867 */         this.branchType = null;
/*      */     }
/*  869 */     if (FCode.equalsIgnoreCase("messageType"))
/*      */     {
/*  871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  873 */         this.messageType = FValue.trim();
/*      */       }
/*      */       else
/*  876 */         this.messageType = null;
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("messageName"))
/*      */     {
/*  880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  882 */         this.messageName = FValue.trim();
/*      */       }
/*      */       else
/*  885 */         this.messageName = null;
/*      */     }
/*  887 */     if (FCode.equalsIgnoreCase("messageContent"))
/*      */     {
/*  889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  891 */         this.messageContent = FValue.trim();
/*      */       }
/*      */       else
/*  894 */         this.messageContent = null;
/*      */     }
/*  896 */     if (FCode.equalsIgnoreCase("messageContent2"))
/*      */     {
/*  898 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  900 */         this.messageContent2 = FValue.trim();
/*      */       }
/*      */       else
/*  903 */         this.messageContent2 = null;
/*      */     }
/*  905 */     if (FCode.equalsIgnoreCase("messageContent3"))
/*      */     {
/*  907 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  909 */         this.messageContent3 = FValue.trim();
/*      */       }
/*      */       else
/*  912 */         this.messageContent3 = null;
/*      */     }
/*  914 */     if (FCode.equalsIgnoreCase("messageContent4"))
/*      */     {
/*  916 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  918 */         this.messageContent4 = FValue.trim();
/*      */       }
/*      */       else
/*  921 */         this.messageContent4 = null;
/*      */     }
/*  923 */     if (FCode.equalsIgnoreCase("messageContent5"))
/*      */     {
/*  925 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  927 */         this.messageContent5 = FValue.trim();
/*      */       }
/*      */       else
/*  930 */         this.messageContent5 = null;
/*      */     }
/*  932 */     if (FCode.equalsIgnoreCase("messageContent6"))
/*      */     {
/*  934 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  936 */         this.messageContent6 = FValue.trim();
/*      */       }
/*      */       else
/*  939 */         this.messageContent6 = null;
/*      */     }
/*  941 */     if (FCode.equalsIgnoreCase("beforeDays"))
/*      */     {
/*  943 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  945 */         Integer tInteger = new Integer(FValue);
/*  946 */         int i = tInteger.intValue();
/*  947 */         this.beforeDays = i;
/*      */       }
/*      */     }
/*  950 */     if (FCode.equalsIgnoreCase("statDays"))
/*      */     {
/*  952 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  954 */         Integer tInteger = new Integer(FValue);
/*  955 */         int i = tInteger.intValue();
/*  956 */         this.statDays = i;
/*      */       }
/*      */     }
/*  959 */     if (FCode.equalsIgnoreCase("startDate"))
/*      */     {
/*  961 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  963 */         this.startDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  966 */         this.startDate = null;
/*      */     }
/*  968 */     if (FCode.equalsIgnoreCase("endDate"))
/*      */     {
/*  970 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  972 */         this.endDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/*  975 */         this.endDate = null;
/*      */     }
/*  977 */     if (FCode.equalsIgnoreCase("statCycle"))
/*      */     {
/*  979 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  981 */         this.statCycle = FValue.trim();
/*      */       }
/*      */       else
/*  984 */         this.statCycle = null;
/*      */     }
/*  986 */     if (FCode.equalsIgnoreCase("script"))
/*      */     {
/*  988 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  990 */         this.script = FValue.trim();
/*      */       }
/*      */       else
/*  993 */         this.script = null;
/*      */     }
/*  995 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  997 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  999 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1002 */         this.vF01 = null;
/*      */     }
/* 1004 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1006 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1008 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1011 */         this.nF01 = null;
/*      */     }
/* 1013 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1015 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1017 */         Integer tInteger = new Integer(FValue);
/* 1018 */         int i = tInteger.intValue();
/* 1019 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1022 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1024 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1026 */         Double tDouble = new Double(FValue);
/* 1027 */         double d = tDouble.doubleValue();
/* 1028 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1031 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1033 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1035 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1038 */         this.date01 = null;
/*      */     }
/* 1040 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1042 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1044 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1047 */         this.operator = null;
/*      */     }
/* 1049 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1051 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1053 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1056 */         this.makeDate = null;
/*      */     }
/* 1058 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1060 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1062 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1065 */         this.makeTime = null;
/*      */     }
/* 1067 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1072 */     if (otherObject == null) return false;
/* 1073 */     if (this == otherObject) return true;
/* 1074 */     if (getClass() != otherObject.getClass()) return false;
/* 1075 */     MMessageConfigSchema other = (MMessageConfigSchema)otherObject;
/* 1076 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 1077 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 1078 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1079 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1080 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1081 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1082 */     if ((this.messageType == null) && (other.getMessageType() != null)) return false;
/* 1083 */     if ((this.messageType != null) && (!this.messageType.equals(other.getMessageType()))) return false;
/* 1084 */     if ((this.messageName == null) && (other.getMessageName() != null)) return false;
/* 1085 */     if ((this.messageName != null) && (!this.messageName.equals(other.getMessageName()))) return false;
/* 1086 */     if ((this.messageContent == null) && (other.getMessageContent() != null)) return false;
/* 1087 */     if ((this.messageContent != null) && (!this.messageContent.equals(other.getMessageContent()))) return false;
/* 1088 */     if ((this.messageContent2 == null) && (other.getMessageContent2() != null)) return false;
/* 1089 */     if ((this.messageContent2 != null) && (!this.messageContent2.equals(other.getMessageContent2()))) return false;
/* 1090 */     if ((this.messageContent3 == null) && (other.getMessageContent3() != null)) return false;
/* 1091 */     if ((this.messageContent3 != null) && (!this.messageContent3.equals(other.getMessageContent3()))) return false;
/* 1092 */     if ((this.messageContent4 == null) && (other.getMessageContent4() != null)) return false;
/* 1093 */     if ((this.messageContent4 != null) && (!this.messageContent4.equals(other.getMessageContent4()))) return false;
/* 1094 */     if ((this.messageContent5 == null) && (other.getMessageContent5() != null)) return false;
/* 1095 */     if ((this.messageContent5 != null) && (!this.messageContent5.equals(other.getMessageContent5()))) return false;
/* 1096 */     if ((this.messageContent6 == null) && (other.getMessageContent6() != null)) return false;
/* 1097 */     if ((this.messageContent6 != null) && (!this.messageContent6.equals(other.getMessageContent6()))) return false;
/* 1098 */     if (this.beforeDays != other.getBeforeDays()) return false;
/* 1099 */     if (this.statDays != other.getStatDays()) return false;
/* 1100 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 1101 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 1102 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 1103 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 1104 */     if ((this.statCycle == null) && (other.getStatCycle() != null)) return false;
/* 1105 */     if ((this.statCycle != null) && (!this.statCycle.equals(other.getStatCycle()))) return false;
/* 1106 */     if ((this.script == null) && (other.getScript() != null)) return false;
/* 1107 */     if ((this.script != null) && (!this.script.equals(other.getScript()))) return false;
/* 1108 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1109 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1110 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1111 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1112 */     if (this.iF01 != other.getIF01()) return false;
/* 1113 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1114 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1115 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1116 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1117 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1118 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1119 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1120 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1121 */     return (this.makeTime == null) || (this.makeTime.equals(other.getMakeTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1128 */     return 25;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1134 */     if (strFieldName.equals("iD")) {
/* 1135 */       return 0;
/*      */     }
/* 1137 */     if (strFieldName.equals("manageCom")) {
/* 1138 */       return 1;
/*      */     }
/* 1140 */     if (strFieldName.equals("branchType")) {
/* 1141 */       return 2;
/*      */     }
/* 1143 */     if (strFieldName.equals("messageType")) {
/* 1144 */       return 3;
/*      */     }
/* 1146 */     if (strFieldName.equals("messageName")) {
/* 1147 */       return 4;
/*      */     }
/* 1149 */     if (strFieldName.equals("messageContent")) {
/* 1150 */       return 5;
/*      */     }
/* 1152 */     if (strFieldName.equals("messageContent2")) {
/* 1153 */       return 6;
/*      */     }
/* 1155 */     if (strFieldName.equals("messageContent3")) {
/* 1156 */       return 7;
/*      */     }
/* 1158 */     if (strFieldName.equals("messageContent4")) {
/* 1159 */       return 8;
/*      */     }
/* 1161 */     if (strFieldName.equals("messageContent5")) {
/* 1162 */       return 9;
/*      */     }
/* 1164 */     if (strFieldName.equals("messageContent6")) {
/* 1165 */       return 10;
/*      */     }
/* 1167 */     if (strFieldName.equals("beforeDays")) {
/* 1168 */       return 11;
/*      */     }
/* 1170 */     if (strFieldName.equals("statDays")) {
/* 1171 */       return 12;
/*      */     }
/* 1173 */     if (strFieldName.equals("startDate")) {
/* 1174 */       return 13;
/*      */     }
/* 1176 */     if (strFieldName.equals("endDate")) {
/* 1177 */       return 14;
/*      */     }
/* 1179 */     if (strFieldName.equals("statCycle")) {
/* 1180 */       return 15;
/*      */     }
/* 1182 */     if (strFieldName.equals("script")) {
/* 1183 */       return 16;
/*      */     }
/* 1185 */     if (strFieldName.equals("vF01")) {
/* 1186 */       return 17;
/*      */     }
/* 1188 */     if (strFieldName.equals("nF01")) {
/* 1189 */       return 18;
/*      */     }
/* 1191 */     if (strFieldName.equals("iF01")) {
/* 1192 */       return 19;
/*      */     }
/* 1194 */     if (strFieldName.equals("dF02")) {
/* 1195 */       return 20;
/*      */     }
/* 1197 */     if (strFieldName.equals("date01")) {
/* 1198 */       return 21;
/*      */     }
/* 1200 */     if (strFieldName.equals("operator")) {
/* 1201 */       return 22;
/*      */     }
/* 1203 */     if (strFieldName.equals("makeDate")) {
/* 1204 */       return 23;
/*      */     }
/* 1206 */     if (strFieldName.equals("makeTime")) {
/* 1207 */       return 24;
/*      */     }
/* 1209 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1215 */     String strFieldName = "";
/* 1216 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1218 */       strFieldName = "iD";
/* 1219 */       break;
/*      */     case 1:
/* 1221 */       strFieldName = "manageCom";
/* 1222 */       break;
/*      */     case 2:
/* 1224 */       strFieldName = "branchType";
/* 1225 */       break;
/*      */     case 3:
/* 1227 */       strFieldName = "messageType";
/* 1228 */       break;
/*      */     case 4:
/* 1230 */       strFieldName = "messageName";
/* 1231 */       break;
/*      */     case 5:
/* 1233 */       strFieldName = "messageContent";
/* 1234 */       break;
/*      */     case 6:
/* 1236 */       strFieldName = "messageContent2";
/* 1237 */       break;
/*      */     case 7:
/* 1239 */       strFieldName = "messageContent3";
/* 1240 */       break;
/*      */     case 8:
/* 1242 */       strFieldName = "messageContent4";
/* 1243 */       break;
/*      */     case 9:
/* 1245 */       strFieldName = "messageContent5";
/* 1246 */       break;
/*      */     case 10:
/* 1248 */       strFieldName = "messageContent6";
/* 1249 */       break;
/*      */     case 11:
/* 1251 */       strFieldName = "beforeDays";
/* 1252 */       break;
/*      */     case 12:
/* 1254 */       strFieldName = "statDays";
/* 1255 */       break;
/*      */     case 13:
/* 1257 */       strFieldName = "startDate";
/* 1258 */       break;
/*      */     case 14:
/* 1260 */       strFieldName = "endDate";
/* 1261 */       break;
/*      */     case 15:
/* 1263 */       strFieldName = "statCycle";
/* 1264 */       break;
/*      */     case 16:
/* 1266 */       strFieldName = "script";
/* 1267 */       break;
/*      */     case 17:
/* 1269 */       strFieldName = "vF01";
/* 1270 */       break;
/*      */     case 18:
/* 1272 */       strFieldName = "nF01";
/* 1273 */       break;
/*      */     case 19:
/* 1275 */       strFieldName = "iF01";
/* 1276 */       break;
/*      */     case 20:
/* 1278 */       strFieldName = "dF02";
/* 1279 */       break;
/*      */     case 21:
/* 1281 */       strFieldName = "date01";
/* 1282 */       break;
/*      */     case 22:
/* 1284 */       strFieldName = "operator";
/* 1285 */       break;
/*      */     case 23:
/* 1287 */       strFieldName = "makeDate";
/* 1288 */       break;
/*      */     case 24:
/* 1290 */       strFieldName = "makeTime";
/* 1291 */       break;
/*      */     default:
/* 1293 */       strFieldName = "";
/*      */     }
/* 1295 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1301 */     if (strFieldName.equals("iD")) {
/* 1302 */       return 0;
/*      */     }
/* 1304 */     if (strFieldName.equals("manageCom")) {
/* 1305 */       return 0;
/*      */     }
/* 1307 */     if (strFieldName.equals("branchType")) {
/* 1308 */       return 0;
/*      */     }
/* 1310 */     if (strFieldName.equals("messageType")) {
/* 1311 */       return 0;
/*      */     }
/* 1313 */     if (strFieldName.equals("messageName")) {
/* 1314 */       return 0;
/*      */     }
/* 1316 */     if (strFieldName.equals("messageContent")) {
/* 1317 */       return 0;
/*      */     }
/* 1319 */     if (strFieldName.equals("messageContent2")) {
/* 1320 */       return 0;
/*      */     }
/* 1322 */     if (strFieldName.equals("messageContent3")) {
/* 1323 */       return 0;
/*      */     }
/* 1325 */     if (strFieldName.equals("messageContent4")) {
/* 1326 */       return 0;
/*      */     }
/* 1328 */     if (strFieldName.equals("messageContent5")) {
/* 1329 */       return 0;
/*      */     }
/* 1331 */     if (strFieldName.equals("messageContent6")) {
/* 1332 */       return 0;
/*      */     }
/* 1334 */     if (strFieldName.equals("beforeDays")) {
/* 1335 */       return 3;
/*      */     }
/* 1337 */     if (strFieldName.equals("statDays")) {
/* 1338 */       return 3;
/*      */     }
/* 1340 */     if (strFieldName.equals("startDate")) {
/* 1341 */       return 1;
/*      */     }
/* 1343 */     if (strFieldName.equals("endDate")) {
/* 1344 */       return 1;
/*      */     }
/* 1346 */     if (strFieldName.equals("statCycle")) {
/* 1347 */       return 0;
/*      */     }
/* 1349 */     if (strFieldName.equals("script")) {
/* 1350 */       return 0;
/*      */     }
/* 1352 */     if (strFieldName.equals("vF01")) {
/* 1353 */       return 0;
/*      */     }
/* 1355 */     if (strFieldName.equals("nF01")) {
/* 1356 */       return 0;
/*      */     }
/* 1358 */     if (strFieldName.equals("iF01")) {
/* 1359 */       return 3;
/*      */     }
/* 1361 */     if (strFieldName.equals("dF02")) {
/* 1362 */       return 4;
/*      */     }
/* 1364 */     if (strFieldName.equals("date01")) {
/* 1365 */       return 1;
/*      */     }
/* 1367 */     if (strFieldName.equals("operator")) {
/* 1368 */       return 0;
/*      */     }
/* 1370 */     if (strFieldName.equals("makeDate")) {
/* 1371 */       return 1;
/*      */     }
/* 1373 */     if (strFieldName.equals("makeTime")) {
/* 1374 */       return 0;
/*      */     }
/* 1376 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1382 */     int nFieldType = -1;
/* 1383 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1385 */       nFieldType = 0;
/* 1386 */       break;
/*      */     case 1:
/* 1388 */       nFieldType = 0;
/* 1389 */       break;
/*      */     case 2:
/* 1391 */       nFieldType = 0;
/* 1392 */       break;
/*      */     case 3:
/* 1394 */       nFieldType = 0;
/* 1395 */       break;
/*      */     case 4:
/* 1397 */       nFieldType = 0;
/* 1398 */       break;
/*      */     case 5:
/* 1400 */       nFieldType = 0;
/* 1401 */       break;
/*      */     case 6:
/* 1403 */       nFieldType = 0;
/* 1404 */       break;
/*      */     case 7:
/* 1406 */       nFieldType = 0;
/* 1407 */       break;
/*      */     case 8:
/* 1409 */       nFieldType = 0;
/* 1410 */       break;
/*      */     case 9:
/* 1412 */       nFieldType = 0;
/* 1413 */       break;
/*      */     case 10:
/* 1415 */       nFieldType = 0;
/* 1416 */       break;
/*      */     case 11:
/* 1418 */       nFieldType = 3;
/* 1419 */       break;
/*      */     case 12:
/* 1421 */       nFieldType = 3;
/* 1422 */       break;
/*      */     case 13:
/* 1424 */       nFieldType = 1;
/* 1425 */       break;
/*      */     case 14:
/* 1427 */       nFieldType = 1;
/* 1428 */       break;
/*      */     case 15:
/* 1430 */       nFieldType = 0;
/* 1431 */       break;
/*      */     case 16:
/* 1433 */       nFieldType = 0;
/* 1434 */       break;
/*      */     case 17:
/* 1436 */       nFieldType = 0;
/* 1437 */       break;
/*      */     case 18:
/* 1439 */       nFieldType = 0;
/* 1440 */       break;
/*      */     case 19:
/* 1442 */       nFieldType = 3;
/* 1443 */       break;
/*      */     case 20:
/* 1445 */       nFieldType = 4;
/* 1446 */       break;
/*      */     case 21:
/* 1448 */       nFieldType = 1;
/* 1449 */       break;
/*      */     case 22:
/* 1451 */       nFieldType = 0;
/* 1452 */       break;
/*      */     case 23:
/* 1454 */       nFieldType = 1;
/* 1455 */       break;
/*      */     case 24:
/* 1457 */       nFieldType = 0;
/* 1458 */       break;
/*      */     default:
/* 1460 */       nFieldType = -1;
/*      */     }
/* 1462 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MMessageConfigSchema
 * JD-Core Version:    0.6.0
 */