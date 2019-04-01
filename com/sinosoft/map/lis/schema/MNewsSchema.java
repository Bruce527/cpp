/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MNewsDB;
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
/*      */ public class MNewsSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String newsID;
/*      */   private String manageCom;
/*      */   private String branchType;
/*      */   private String newsType;
/*      */   private String title;
/*      */   private String subhead;
/*      */   private String brief;
/*      */   private String author;
/*      */   private Date startDisplayDate;
/*      */   private Date endDisplayDate;
/*      */   private String startDisplayTime;
/*      */   private String endDisplayTime;
/*      */   private String staticPageURL;
/*      */   private String minDisplayGrade;
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
/*      */   private int clickRate;
/*      */   private int fixedTop;
/*      */   public static final int FIELDNUM = 32;
/*      */   private static String[] PK;
/*   88 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MNewsSchema()
/*      */   {
/*   95 */     this.mErrors = new CErrors();
/*      */ 
/*   97 */     String[] pk = new String[1];
/*   98 */     pk[0] = "NewsID";
/*      */ 
/*  100 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  107 */     MNewsSchema cloned = (MNewsSchema)super.clone();
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
/*      */   public String getNewsID()
/*      */   {
/*  121 */     return this.newsID;
/*      */   }
/*      */ 
/*      */   public void setNewsID(String aNewsID) {
/*  125 */     this.newsID = aNewsID;
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
/*      */   public String getNewsType() {
/*  145 */     return this.newsType;
/*      */   }
/*      */ 
/*      */   public void setNewsType(String aNewsType) {
/*  149 */     this.newsType = aNewsType;
/*      */   }
/*      */ 
/*      */   public String getTitle() {
/*  153 */     return this.title;
/*      */   }
/*      */ 
/*      */   public void setTitle(String aTitle) {
/*  157 */     this.title = aTitle;
/*      */   }
/*      */ 
/*      */   public String getSubhead() {
/*  161 */     return this.subhead;
/*      */   }
/*      */ 
/*      */   public void setSubhead(String aSubhead) {
/*  165 */     this.subhead = aSubhead;
/*      */   }
/*      */ 
/*      */   public String getBrief() {
/*  169 */     return this.brief;
/*      */   }
/*      */ 
/*      */   public void setBrief(String aBrief) {
/*  173 */     this.brief = aBrief;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  177 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  181 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayDate() {
/*  185 */     if (this.startDisplayDate != null) {
/*  186 */       return this.fDate.getString(this.startDisplayDate);
/*      */     }
/*  188 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(Date aStartDisplayDate) {
/*  192 */     this.startDisplayDate = aStartDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(String aStartDisplayDate) {
/*  196 */     if ((aStartDisplayDate != null) && (!aStartDisplayDate.equals("")))
/*      */     {
/*  198 */       this.startDisplayDate = this.fDate.getDate(aStartDisplayDate);
/*      */     }
/*      */     else
/*  201 */       this.startDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayDate()
/*      */   {
/*  206 */     if (this.endDisplayDate != null) {
/*  207 */       return this.fDate.getString(this.endDisplayDate);
/*      */     }
/*  209 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(Date aEndDisplayDate) {
/*  213 */     this.endDisplayDate = aEndDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(String aEndDisplayDate) {
/*  217 */     if ((aEndDisplayDate != null) && (!aEndDisplayDate.equals("")))
/*      */     {
/*  219 */       this.endDisplayDate = this.fDate.getDate(aEndDisplayDate);
/*      */     }
/*      */     else
/*  222 */       this.endDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayTime()
/*      */   {
/*  227 */     return this.startDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayTime(String aStartDisplayTime) {
/*  231 */     this.startDisplayTime = aStartDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayTime() {
/*  235 */     return this.endDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayTime(String aEndDisplayTime) {
/*  239 */     this.endDisplayTime = aEndDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getStaticPageURL() {
/*  243 */     return this.staticPageURL;
/*      */   }
/*      */ 
/*      */   public void setStaticPageURL(String aStaticPageURL) {
/*  247 */     this.staticPageURL = aStaticPageURL;
/*      */   }
/*      */ 
/*      */   public String getMinDisplayGrade() {
/*  251 */     return this.minDisplayGrade;
/*      */   }
/*      */ 
/*      */   public void setMinDisplayGrade(String aMinDisplayGrade) {
/*  255 */     this.minDisplayGrade = aMinDisplayGrade;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  259 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  263 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  267 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  271 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  275 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  279 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  283 */     if (this.checkDate != null) {
/*  284 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  286 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  290 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  294 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  296 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  299 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  304 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  308 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  312 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  316 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  320 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  324 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  328 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  332 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  336 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  338 */       Integer tInteger = new Integer(aIF01);
/*  339 */       int i = tInteger.intValue();
/*  340 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  346 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  350 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  354 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  356 */       Double tDouble = new Double(aDF02);
/*  357 */       double d = tDouble.doubleValue();
/*  358 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  364 */     if (this.date01 != null) {
/*  365 */       return this.fDate.getString(this.date01);
/*      */     }
/*  367 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  371 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  375 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  377 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  380 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  385 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  389 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  393 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  397 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  401 */     if (this.makeDate != null) {
/*  402 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  404 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  408 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  412 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  414 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  417 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  422 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  426 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  430 */     if (this.modifyDate != null) {
/*  431 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  433 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  437 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  441 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  443 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  446 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  451 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  455 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getClickRate() {
/*  459 */     return this.clickRate;
/*      */   }
/*      */ 
/*      */   public void setClickRate(int aClickRate) {
/*  463 */     this.clickRate = aClickRate;
/*      */   }
/*      */ 
/*      */   public void setClickRate(String aClickRate) {
/*  467 */     if ((aClickRate != null) && (!aClickRate.equals("")))
/*      */     {
/*  469 */       Integer tInteger = new Integer(aClickRate);
/*  470 */       int i = tInteger.intValue();
/*  471 */       this.clickRate = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getFixedTop()
/*      */   {
/*  477 */     return this.fixedTop;
/*      */   }
/*      */ 
/*      */   public void setFixedTop(int aFixedTop) {
/*  481 */     this.fixedTop = aFixedTop;
/*      */   }
/*      */ 
/*      */   public void setFixedTop(String aFixedTop) {
/*  485 */     if ((aFixedTop != null) && (!aFixedTop.equals("")))
/*      */     {
/*  487 */       Integer tInteger = new Integer(aFixedTop);
/*  488 */       int i = tInteger.intValue();
/*  489 */       this.fixedTop = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(MNewsSchema aMNewsSchema)
/*      */   {
/*  497 */     this.newsID = aMNewsSchema.getNewsID();
/*  498 */     this.manageCom = aMNewsSchema.getManageCom();
/*  499 */     this.branchType = aMNewsSchema.getBranchType();
/*  500 */     this.newsType = aMNewsSchema.getNewsType();
/*  501 */     this.title = aMNewsSchema.getTitle();
/*  502 */     this.subhead = aMNewsSchema.getSubhead();
/*  503 */     this.brief = aMNewsSchema.getBrief();
/*  504 */     this.author = aMNewsSchema.getAuthor();
/*  505 */     this.startDisplayDate = this.fDate.getDate(aMNewsSchema.getStartDisplayDate());
/*  506 */     this.endDisplayDate = this.fDate.getDate(aMNewsSchema.getEndDisplayDate());
/*  507 */     this.startDisplayTime = aMNewsSchema.getStartDisplayTime();
/*  508 */     this.endDisplayTime = aMNewsSchema.getEndDisplayTime();
/*  509 */     this.staticPageURL = aMNewsSchema.getStaticPageURL();
/*  510 */     this.minDisplayGrade = aMNewsSchema.getMinDisplayGrade();
/*  511 */     this.checkState = aMNewsSchema.getCheckState();
/*  512 */     this.checkOperator = aMNewsSchema.getCheckOperator();
/*  513 */     this.checkReason = aMNewsSchema.getCheckReason();
/*  514 */     this.checkDate = this.fDate.getDate(aMNewsSchema.getCheckDate());
/*  515 */     this.checkTime = aMNewsSchema.getCheckTime();
/*  516 */     this.vF01 = aMNewsSchema.getVF01();
/*  517 */     this.nF01 = aMNewsSchema.getNF01();
/*  518 */     this.iF01 = aMNewsSchema.getIF01();
/*  519 */     this.dF02 = aMNewsSchema.getDF02();
/*  520 */     this.date01 = this.fDate.getDate(aMNewsSchema.getDate01());
/*  521 */     this.modifyOperator = aMNewsSchema.getModifyOperator();
/*  522 */     this.operator = aMNewsSchema.getOperator();
/*  523 */     this.makeDate = this.fDate.getDate(aMNewsSchema.getMakeDate());
/*  524 */     this.makeTime = aMNewsSchema.getMakeTime();
/*  525 */     this.modifyDate = this.fDate.getDate(aMNewsSchema.getModifyDate());
/*  526 */     this.modifyTime = aMNewsSchema.getModifyTime();
/*  527 */     this.clickRate = aMNewsSchema.getClickRate();
/*  528 */     this.fixedTop = aMNewsSchema.getFixedTop();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  537 */       if (rs.getString("NewsID") == null)
/*  538 */         this.newsID = null;
/*      */       else {
/*  540 */         this.newsID = rs.getString("NewsID").trim();
/*      */       }
/*  542 */       if (rs.getString("ManageCom") == null)
/*  543 */         this.manageCom = null;
/*      */       else {
/*  545 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  547 */       if (rs.getString("BranchType") == null)
/*  548 */         this.branchType = null;
/*      */       else {
/*  550 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  552 */       if (rs.getString("NewsType") == null)
/*  553 */         this.newsType = null;
/*      */       else {
/*  555 */         this.newsType = rs.getString("NewsType").trim();
/*      */       }
/*  557 */       if (rs.getString("Title") == null)
/*  558 */         this.title = null;
/*      */       else {
/*  560 */         this.title = rs.getString("Title").trim();
/*      */       }
/*  562 */       if (rs.getString("Subhead") == null)
/*  563 */         this.subhead = null;
/*      */       else {
/*  565 */         this.subhead = rs.getString("Subhead").trim();
/*      */       }
/*  567 */       if (rs.getString("Brief") == null)
/*  568 */         this.brief = null;
/*      */       else {
/*  570 */         this.brief = rs.getString("Brief").trim();
/*      */       }
/*  572 */       if (rs.getString("Author") == null)
/*  573 */         this.author = null;
/*      */       else {
/*  575 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  577 */       this.startDisplayDate = rs.getDate("StartDisplayDate");
/*  578 */       this.endDisplayDate = rs.getDate("EndDisplayDate");
/*  579 */       if (rs.getString("StartDisplayTime") == null)
/*  580 */         this.startDisplayTime = null;
/*      */       else {
/*  582 */         this.startDisplayTime = rs.getString("StartDisplayTime").trim();
/*      */       }
/*  584 */       if (rs.getString("EndDisplayTime") == null)
/*  585 */         this.endDisplayTime = null;
/*      */       else {
/*  587 */         this.endDisplayTime = rs.getString("EndDisplayTime").trim();
/*      */       }
/*  589 */       if (rs.getString("StaticPageURL") == null)
/*  590 */         this.staticPageURL = null;
/*      */       else {
/*  592 */         this.staticPageURL = rs.getString("StaticPageURL").trim();
/*      */       }
/*  594 */       if (rs.getString("MinDisplayGrade") == null)
/*  595 */         this.minDisplayGrade = null;
/*      */       else {
/*  597 */         this.minDisplayGrade = rs.getString("MinDisplayGrade").trim();
/*      */       }
/*  599 */       if (rs.getString("CheckState") == null)
/*  600 */         this.checkState = null;
/*      */       else {
/*  602 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  604 */       if (rs.getString("CheckOperator") == null)
/*  605 */         this.checkOperator = null;
/*      */       else {
/*  607 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  609 */       if (rs.getString("CheckReason") == null)
/*  610 */         this.checkReason = null;
/*      */       else {
/*  612 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  614 */       this.checkDate = rs.getDate("CheckDate");
/*  615 */       if (rs.getString("CheckTime") == null)
/*  616 */         this.checkTime = null;
/*      */       else {
/*  618 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  620 */       if (rs.getString("VF01") == null)
/*  621 */         this.vF01 = null;
/*      */       else {
/*  623 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  625 */       if (rs.getString("NF01") == null)
/*  626 */         this.nF01 = null;
/*      */       else {
/*  628 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  630 */       this.iF01 = rs.getInt("IF01");
/*  631 */       this.dF02 = rs.getDouble("DF02");
/*  632 */       this.date01 = rs.getDate("Date01");
/*  633 */       if (rs.getString("ModifyOperator") == null)
/*  634 */         this.modifyOperator = null;
/*      */       else {
/*  636 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  638 */       if (rs.getString("Operator") == null)
/*  639 */         this.operator = null;
/*      */       else {
/*  641 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  643 */       this.makeDate = rs.getDate("MakeDate");
/*  644 */       if (rs.getString("MakeTime") == null)
/*  645 */         this.makeTime = null;
/*      */       else {
/*  647 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  649 */       this.modifyDate = rs.getDate("ModifyDate");
/*  650 */       if (rs.getString("ModifyTime") == null)
/*  651 */         this.modifyTime = null;
/*      */       else {
/*  653 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  655 */       this.clickRate = rs.getInt("ClickRate");
/*  656 */       this.fixedTop = rs.getInt("FixedTop");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  660 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNews\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  662 */       CError tError = new CError();
/*  663 */       tError.moduleName = "MNewsSchema";
/*  664 */       tError.functionName = "setSchema";
/*  665 */       tError.errorMessage = sqle.toString();
/*  666 */       this.mErrors.addOneError(tError);
/*  667 */       return false;
/*      */     }
/*  669 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewsSchema getSchema()
/*      */   {
/*  674 */     MNewsSchema aMNewsSchema = new MNewsSchema();
/*  675 */     aMNewsSchema.setSchema(this);
/*  676 */     return aMNewsSchema;
/*      */   }
/*      */ 
/*      */   public MNewsDB getDB()
/*      */   {
/*  681 */     MNewsDB aDBOper = new MNewsDB();
/*  682 */     aDBOper.setSchema(this);
/*  683 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  690 */     StringBuffer strReturn = new StringBuffer(256);
/*  691 */     strReturn.append(StrTool.cTrim(this.newsID)); strReturn.append("|");
/*  692 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  693 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  694 */     strReturn.append(StrTool.cTrim(this.newsType)); strReturn.append("|");
/*  695 */     strReturn.append(StrTool.cTrim(this.title)); strReturn.append("|");
/*  696 */     strReturn.append(StrTool.cTrim(this.subhead)); strReturn.append("|");
/*  697 */     strReturn.append(StrTool.cTrim(this.brief)); strReturn.append("|");
/*  698 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  699 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDisplayDate))); strReturn.append("|");
/*  700 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDisplayDate))); strReturn.append("|");
/*  701 */     strReturn.append(StrTool.cTrim(this.startDisplayTime)); strReturn.append("|");
/*  702 */     strReturn.append(StrTool.cTrim(this.endDisplayTime)); strReturn.append("|");
/*  703 */     strReturn.append(StrTool.cTrim(this.staticPageURL)); strReturn.append("|");
/*  704 */     strReturn.append(StrTool.cTrim(this.minDisplayGrade)); strReturn.append("|");
/*  705 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  706 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  707 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  708 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  709 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  710 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  711 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  712 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  713 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  714 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  715 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  716 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  717 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  718 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  719 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  720 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  721 */     strReturn.append(ChgData.chgData(this.clickRate)); strReturn.append("|");
/*  722 */     strReturn.append(ChgData.chgData(this.fixedTop));
/*  723 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  731 */       this.newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  732 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  733 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  734 */       this.newsType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  735 */       this.title = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  736 */       this.subhead = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  737 */       this.brief = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  738 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  739 */       this.startDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/*  740 */       this.endDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/*  741 */       this.startDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  742 */       this.endDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  743 */       this.staticPageURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  744 */       this.minDisplayGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  745 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  746 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  747 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  748 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  749 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  750 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  751 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  752 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|"))).intValue();
/*  753 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|"))).doubleValue();
/*  754 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  755 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  756 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  757 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  758 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  759 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/*  760 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  761 */       this.clickRate = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).intValue();
/*  762 */       this.fixedTop = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).intValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  767 */       CError tError = new CError();
/*  768 */       tError.moduleName = "MNewsSchema";
/*  769 */       tError.functionName = "decode";
/*  770 */       tError.errorMessage = ex.toString();
/*  771 */       this.mErrors.addOneError(tError);
/*      */ 
/*  773 */       return false;
/*      */     }
/*  775 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  781 */     String strReturn = "";
/*  782 */     if (FCode.equalsIgnoreCase("newsID"))
/*      */     {
/*  784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsID));
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("newsType"))
/*      */     {
/*  796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsType));
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("title"))
/*      */     {
/*  800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.title));
/*      */     }
/*  802 */     if (FCode.equalsIgnoreCase("subhead"))
/*      */     {
/*  804 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subhead));
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("brief"))
/*      */     {
/*  808 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.brief));
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  812 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  814 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/*  816 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/*  820 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/*  824 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDisplayTime));
/*      */     }
/*  826 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/*  828 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDisplayTime));
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("staticPageURL"))
/*      */     {
/*  832 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.staticPageURL));
/*      */     }
/*  834 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/*  836 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minDisplayGrade));
/*      */     }
/*  838 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  840 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  844 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  848 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  850 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  852 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  854 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  856 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  858 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/*  860 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/*  862 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/*  864 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/*  866 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/*  868 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/*  872 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/*  874 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/*  876 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/*  878 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/*  880 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/*  882 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  884 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  886 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  888 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  890 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  892 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  894 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  896 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  898 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  900 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  902 */     if (FCode.equalsIgnoreCase("clickRate"))
/*      */     {
/*  904 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clickRate));
/*      */     }
/*  906 */     if (FCode.equalsIgnoreCase("fixedTop"))
/*      */     {
/*  908 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fixedTop));
/*      */     }
/*  910 */     if (strReturn.equals(""))
/*      */     {
/*  912 */       strReturn = "null";
/*      */     }
/*      */ 
/*  915 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  922 */     String strFieldValue = "";
/*  923 */     switch (nFieldIndex) {
/*      */     case 0:
/*  925 */       strFieldValue = StrTool.GBKToUnicode(this.newsID);
/*  926 */       break;
/*      */     case 1:
/*  928 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  929 */       break;
/*      */     case 2:
/*  931 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/*  932 */       break;
/*      */     case 3:
/*  934 */       strFieldValue = StrTool.GBKToUnicode(this.newsType);
/*  935 */       break;
/*      */     case 4:
/*  937 */       strFieldValue = StrTool.GBKToUnicode(this.title);
/*  938 */       break;
/*      */     case 5:
/*  940 */       strFieldValue = StrTool.GBKToUnicode(this.subhead);
/*  941 */       break;
/*      */     case 6:
/*  943 */       strFieldValue = StrTool.GBKToUnicode(this.brief);
/*  944 */       break;
/*      */     case 7:
/*  946 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/*  947 */       break;
/*      */     case 8:
/*  949 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*  950 */       break;
/*      */     case 9:
/*  952 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*  953 */       break;
/*      */     case 10:
/*  955 */       strFieldValue = StrTool.GBKToUnicode(this.startDisplayTime);
/*  956 */       break;
/*      */     case 11:
/*  958 */       strFieldValue = StrTool.GBKToUnicode(this.endDisplayTime);
/*  959 */       break;
/*      */     case 12:
/*  961 */       strFieldValue = StrTool.GBKToUnicode(this.staticPageURL);
/*  962 */       break;
/*      */     case 13:
/*  964 */       strFieldValue = StrTool.GBKToUnicode(this.minDisplayGrade);
/*  965 */       break;
/*      */     case 14:
/*  967 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/*  968 */       break;
/*      */     case 15:
/*  970 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/*  971 */       break;
/*      */     case 16:
/*  973 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/*  974 */       break;
/*      */     case 17:
/*  976 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*  977 */       break;
/*      */     case 18:
/*  979 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/*  980 */       break;
/*      */     case 19:
/*  982 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/*  983 */       break;
/*      */     case 20:
/*  985 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/*  986 */       break;
/*      */     case 21:
/*  988 */       strFieldValue = String.valueOf(this.iF01);
/*  989 */       break;
/*      */     case 22:
/*  991 */       strFieldValue = String.valueOf(this.dF02);
/*  992 */       break;
/*      */     case 23:
/*  994 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*  995 */       break;
/*      */     case 24:
/*  997 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/*  998 */       break;
/*      */     case 25:
/* 1000 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1001 */       break;
/*      */     case 26:
/* 1003 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1004 */       break;
/*      */     case 27:
/* 1006 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1007 */       break;
/*      */     case 28:
/* 1009 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1010 */       break;
/*      */     case 29:
/* 1012 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1013 */       break;
/*      */     case 30:
/* 1015 */       strFieldValue = String.valueOf(this.clickRate);
/* 1016 */       break;
/*      */     case 31:
/* 1018 */       strFieldValue = String.valueOf(this.fixedTop);
/* 1019 */       break;
/*      */     default:
/* 1021 */       strFieldValue = "";
/*      */     }
/* 1023 */     if (strFieldValue.equals("")) {
/* 1024 */       strFieldValue = "null";
/*      */     }
/* 1026 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1032 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1033 */       return false;
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("newsID"))
/*      */     {
/* 1037 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1039 */         this.newsID = FValue.trim();
/*      */       }
/*      */       else
/* 1042 */         this.newsID = null;
/*      */     }
/* 1044 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1046 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1048 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1051 */         this.manageCom = null;
/*      */     }
/* 1053 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1055 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1057 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1060 */         this.branchType = null;
/*      */     }
/* 1062 */     if (FCode.equalsIgnoreCase("newsType"))
/*      */     {
/* 1064 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1066 */         this.newsType = FValue.trim();
/*      */       }
/*      */       else
/* 1069 */         this.newsType = null;
/*      */     }
/* 1071 */     if (FCode.equalsIgnoreCase("title"))
/*      */     {
/* 1073 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1075 */         this.title = FValue.trim();
/*      */       }
/*      */       else
/* 1078 */         this.title = null;
/*      */     }
/* 1080 */     if (FCode.equalsIgnoreCase("subhead"))
/*      */     {
/* 1082 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1084 */         this.subhead = FValue.trim();
/*      */       }
/*      */       else
/* 1087 */         this.subhead = null;
/*      */     }
/* 1089 */     if (FCode.equalsIgnoreCase("brief"))
/*      */     {
/* 1091 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1093 */         this.brief = FValue.trim();
/*      */       }
/*      */       else
/* 1096 */         this.brief = null;
/*      */     }
/* 1098 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/* 1100 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1102 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/* 1105 */         this.author = null;
/*      */     }
/* 1107 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/* 1109 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1111 */         this.startDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1114 */         this.startDisplayDate = null;
/*      */     }
/* 1116 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/* 1118 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1120 */         this.endDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1123 */         this.endDisplayDate = null;
/*      */     }
/* 1125 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/* 1127 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1129 */         this.startDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1132 */         this.startDisplayTime = null;
/*      */     }
/* 1134 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/* 1136 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1138 */         this.endDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1141 */         this.endDisplayTime = null;
/*      */     }
/* 1143 */     if (FCode.equalsIgnoreCase("staticPageURL"))
/*      */     {
/* 1145 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1147 */         this.staticPageURL = FValue.trim();
/*      */       }
/*      */       else
/* 1150 */         this.staticPageURL = null;
/*      */     }
/* 1152 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/* 1154 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1156 */         this.minDisplayGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1159 */         this.minDisplayGrade = null;
/*      */     }
/* 1161 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1163 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1165 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1168 */         this.checkState = null;
/*      */     }
/* 1170 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1172 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1174 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1177 */         this.checkOperator = null;
/*      */     }
/* 1179 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1181 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1183 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1186 */         this.checkReason = null;
/*      */     }
/* 1188 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1190 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1192 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1195 */         this.checkDate = null;
/*      */     }
/* 1197 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1199 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1201 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1204 */         this.checkTime = null;
/*      */     }
/* 1206 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1208 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1210 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1213 */         this.vF01 = null;
/*      */     }
/* 1215 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1217 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1219 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1222 */         this.nF01 = null;
/*      */     }
/* 1224 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1226 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1228 */         Integer tInteger = new Integer(FValue);
/* 1229 */         int i = tInteger.intValue();
/* 1230 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1233 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1235 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1237 */         Double tDouble = new Double(FValue);
/* 1238 */         double d = tDouble.doubleValue();
/* 1239 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1242 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1244 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1246 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1249 */         this.date01 = null;
/*      */     }
/* 1251 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1253 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1255 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1258 */         this.modifyOperator = null;
/*      */     }
/* 1260 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1262 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1264 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1267 */         this.operator = null;
/*      */     }
/* 1269 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1271 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1273 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1276 */         this.makeDate = null;
/*      */     }
/* 1278 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1280 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1282 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1285 */         this.makeTime = null;
/*      */     }
/* 1287 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1289 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1291 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1294 */         this.modifyDate = null;
/*      */     }
/* 1296 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1298 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1300 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1303 */         this.modifyTime = null;
/*      */     }
/* 1305 */     if (FCode.equalsIgnoreCase("clickRate"))
/*      */     {
/* 1307 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1309 */         Integer tInteger = new Integer(FValue);
/* 1310 */         int i = tInteger.intValue();
/* 1311 */         this.clickRate = i;
/*      */       }
/*      */     }
/* 1314 */     if (FCode.equalsIgnoreCase("fixedTop"))
/*      */     {
/* 1316 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1318 */         Integer tInteger = new Integer(FValue);
/* 1319 */         int i = tInteger.intValue();
/* 1320 */         this.fixedTop = i;
/*      */       }
/*      */     }
/* 1323 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1328 */     if (otherObject == null) return false;
/* 1329 */     if (this == otherObject) return true;
/* 1330 */     if (getClass() != otherObject.getClass()) return false;
/* 1331 */     MNewsSchema other = (MNewsSchema)otherObject;
/* 1332 */     if ((this.newsID == null) && (other.getNewsID() != null)) return false;
/* 1333 */     if ((this.newsID != null) && (!this.newsID.equals(other.getNewsID()))) return false;
/* 1334 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1335 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1336 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1337 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1338 */     if ((this.newsType == null) && (other.getNewsType() != null)) return false;
/* 1339 */     if ((this.newsType != null) && (!this.newsType.equals(other.getNewsType()))) return false;
/* 1340 */     if ((this.title == null) && (other.getTitle() != null)) return false;
/* 1341 */     if ((this.title != null) && (!this.title.equals(other.getTitle()))) return false;
/* 1342 */     if ((this.subhead == null) && (other.getSubhead() != null)) return false;
/* 1343 */     if ((this.subhead != null) && (!this.subhead.equals(other.getSubhead()))) return false;
/* 1344 */     if ((this.brief == null) && (other.getBrief() != null)) return false;
/* 1345 */     if ((this.brief != null) && (!this.brief.equals(other.getBrief()))) return false;
/* 1346 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1347 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1348 */     if ((this.startDisplayDate == null) && (other.getStartDisplayDate() != null)) return false;
/* 1349 */     if ((this.startDisplayDate != null) && (!this.fDate.getString(this.startDisplayDate).equals(other.getStartDisplayDate()))) return false;
/* 1350 */     if ((this.endDisplayDate == null) && (other.getEndDisplayDate() != null)) return false;
/* 1351 */     if ((this.endDisplayDate != null) && (!this.fDate.getString(this.endDisplayDate).equals(other.getEndDisplayDate()))) return false;
/* 1352 */     if ((this.startDisplayTime == null) && (other.getStartDisplayTime() != null)) return false;
/* 1353 */     if ((this.startDisplayTime != null) && (!this.startDisplayTime.equals(other.getStartDisplayTime()))) return false;
/* 1354 */     if ((this.endDisplayTime == null) && (other.getEndDisplayTime() != null)) return false;
/* 1355 */     if ((this.endDisplayTime != null) && (!this.endDisplayTime.equals(other.getEndDisplayTime()))) return false;
/* 1356 */     if ((this.staticPageURL == null) && (other.getStaticPageURL() != null)) return false;
/* 1357 */     if ((this.staticPageURL != null) && (!this.staticPageURL.equals(other.getStaticPageURL()))) return false;
/* 1358 */     if ((this.minDisplayGrade == null) && (other.getMinDisplayGrade() != null)) return false;
/* 1359 */     if ((this.minDisplayGrade != null) && (!this.minDisplayGrade.equals(other.getMinDisplayGrade()))) return false;
/* 1360 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1361 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1362 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1363 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1364 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1365 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1366 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1367 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1368 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1369 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1370 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1371 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1372 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1373 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1374 */     if (this.iF01 != other.getIF01()) return false;
/* 1375 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1376 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1377 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1378 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1379 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1380 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1381 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1382 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1383 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1384 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1385 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1386 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1387 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1388 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1389 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1390 */     if (this.clickRate != other.getClickRate()) return false;
/* 1391 */     return this.fixedTop == other.getFixedTop();
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1398 */     return 32;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1404 */     if (strFieldName.equals("newsID")) {
/* 1405 */       return 0;
/*      */     }
/* 1407 */     if (strFieldName.equals("manageCom")) {
/* 1408 */       return 1;
/*      */     }
/* 1410 */     if (strFieldName.equals("branchType")) {
/* 1411 */       return 2;
/*      */     }
/* 1413 */     if (strFieldName.equals("newsType")) {
/* 1414 */       return 3;
/*      */     }
/* 1416 */     if (strFieldName.equals("title")) {
/* 1417 */       return 4;
/*      */     }
/* 1419 */     if (strFieldName.equals("subhead")) {
/* 1420 */       return 5;
/*      */     }
/* 1422 */     if (strFieldName.equals("brief")) {
/* 1423 */       return 6;
/*      */     }
/* 1425 */     if (strFieldName.equals("author")) {
/* 1426 */       return 7;
/*      */     }
/* 1428 */     if (strFieldName.equals("startDisplayDate")) {
/* 1429 */       return 8;
/*      */     }
/* 1431 */     if (strFieldName.equals("endDisplayDate")) {
/* 1432 */       return 9;
/*      */     }
/* 1434 */     if (strFieldName.equals("startDisplayTime")) {
/* 1435 */       return 10;
/*      */     }
/* 1437 */     if (strFieldName.equals("endDisplayTime")) {
/* 1438 */       return 11;
/*      */     }
/* 1440 */     if (strFieldName.equals("staticPageURL")) {
/* 1441 */       return 12;
/*      */     }
/* 1443 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1444 */       return 13;
/*      */     }
/* 1446 */     if (strFieldName.equals("checkState")) {
/* 1447 */       return 14;
/*      */     }
/* 1449 */     if (strFieldName.equals("checkOperator")) {
/* 1450 */       return 15;
/*      */     }
/* 1452 */     if (strFieldName.equals("checkReason")) {
/* 1453 */       return 16;
/*      */     }
/* 1455 */     if (strFieldName.equals("checkDate")) {
/* 1456 */       return 17;
/*      */     }
/* 1458 */     if (strFieldName.equals("checkTime")) {
/* 1459 */       return 18;
/*      */     }
/* 1461 */     if (strFieldName.equals("vF01")) {
/* 1462 */       return 19;
/*      */     }
/* 1464 */     if (strFieldName.equals("nF01")) {
/* 1465 */       return 20;
/*      */     }
/* 1467 */     if (strFieldName.equals("iF01")) {
/* 1468 */       return 21;
/*      */     }
/* 1470 */     if (strFieldName.equals("dF02")) {
/* 1471 */       return 22;
/*      */     }
/* 1473 */     if (strFieldName.equals("date01")) {
/* 1474 */       return 23;
/*      */     }
/* 1476 */     if (strFieldName.equals("modifyOperator")) {
/* 1477 */       return 24;
/*      */     }
/* 1479 */     if (strFieldName.equals("operator")) {
/* 1480 */       return 25;
/*      */     }
/* 1482 */     if (strFieldName.equals("makeDate")) {
/* 1483 */       return 26;
/*      */     }
/* 1485 */     if (strFieldName.equals("makeTime")) {
/* 1486 */       return 27;
/*      */     }
/* 1488 */     if (strFieldName.equals("modifyDate")) {
/* 1489 */       return 28;
/*      */     }
/* 1491 */     if (strFieldName.equals("modifyTime")) {
/* 1492 */       return 29;
/*      */     }
/* 1494 */     if (strFieldName.equals("clickRate")) {
/* 1495 */       return 30;
/*      */     }
/* 1497 */     if (strFieldName.equals("fixedTop")) {
/* 1498 */       return 31;
/*      */     }
/* 1500 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1506 */     String strFieldName = "";
/* 1507 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1509 */       strFieldName = "newsID";
/* 1510 */       break;
/*      */     case 1:
/* 1512 */       strFieldName = "manageCom";
/* 1513 */       break;
/*      */     case 2:
/* 1515 */       strFieldName = "branchType";
/* 1516 */       break;
/*      */     case 3:
/* 1518 */       strFieldName = "newsType";
/* 1519 */       break;
/*      */     case 4:
/* 1521 */       strFieldName = "title";
/* 1522 */       break;
/*      */     case 5:
/* 1524 */       strFieldName = "subhead";
/* 1525 */       break;
/*      */     case 6:
/* 1527 */       strFieldName = "brief";
/* 1528 */       break;
/*      */     case 7:
/* 1530 */       strFieldName = "author";
/* 1531 */       break;
/*      */     case 8:
/* 1533 */       strFieldName = "startDisplayDate";
/* 1534 */       break;
/*      */     case 9:
/* 1536 */       strFieldName = "endDisplayDate";
/* 1537 */       break;
/*      */     case 10:
/* 1539 */       strFieldName = "startDisplayTime";
/* 1540 */       break;
/*      */     case 11:
/* 1542 */       strFieldName = "endDisplayTime";
/* 1543 */       break;
/*      */     case 12:
/* 1545 */       strFieldName = "staticPageURL";
/* 1546 */       break;
/*      */     case 13:
/* 1548 */       strFieldName = "minDisplayGrade";
/* 1549 */       break;
/*      */     case 14:
/* 1551 */       strFieldName = "checkState";
/* 1552 */       break;
/*      */     case 15:
/* 1554 */       strFieldName = "checkOperator";
/* 1555 */       break;
/*      */     case 16:
/* 1557 */       strFieldName = "checkReason";
/* 1558 */       break;
/*      */     case 17:
/* 1560 */       strFieldName = "checkDate";
/* 1561 */       break;
/*      */     case 18:
/* 1563 */       strFieldName = "checkTime";
/* 1564 */       break;
/*      */     case 19:
/* 1566 */       strFieldName = "vF01";
/* 1567 */       break;
/*      */     case 20:
/* 1569 */       strFieldName = "nF01";
/* 1570 */       break;
/*      */     case 21:
/* 1572 */       strFieldName = "iF01";
/* 1573 */       break;
/*      */     case 22:
/* 1575 */       strFieldName = "dF02";
/* 1576 */       break;
/*      */     case 23:
/* 1578 */       strFieldName = "date01";
/* 1579 */       break;
/*      */     case 24:
/* 1581 */       strFieldName = "modifyOperator";
/* 1582 */       break;
/*      */     case 25:
/* 1584 */       strFieldName = "operator";
/* 1585 */       break;
/*      */     case 26:
/* 1587 */       strFieldName = "makeDate";
/* 1588 */       break;
/*      */     case 27:
/* 1590 */       strFieldName = "makeTime";
/* 1591 */       break;
/*      */     case 28:
/* 1593 */       strFieldName = "modifyDate";
/* 1594 */       break;
/*      */     case 29:
/* 1596 */       strFieldName = "modifyTime";
/* 1597 */       break;
/*      */     case 30:
/* 1599 */       strFieldName = "clickRate";
/* 1600 */       break;
/*      */     case 31:
/* 1602 */       strFieldName = "fixedTop";
/* 1603 */       break;
/*      */     default:
/* 1605 */       strFieldName = "";
/*      */     }
/* 1607 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1613 */     if (strFieldName.equals("newsID")) {
/* 1614 */       return 0;
/*      */     }
/* 1616 */     if (strFieldName.equals("manageCom")) {
/* 1617 */       return 0;
/*      */     }
/* 1619 */     if (strFieldName.equals("branchType")) {
/* 1620 */       return 0;
/*      */     }
/* 1622 */     if (strFieldName.equals("newsType")) {
/* 1623 */       return 0;
/*      */     }
/* 1625 */     if (strFieldName.equals("title")) {
/* 1626 */       return 0;
/*      */     }
/* 1628 */     if (strFieldName.equals("subhead")) {
/* 1629 */       return 0;
/*      */     }
/* 1631 */     if (strFieldName.equals("brief")) {
/* 1632 */       return 0;
/*      */     }
/* 1634 */     if (strFieldName.equals("author")) {
/* 1635 */       return 0;
/*      */     }
/* 1637 */     if (strFieldName.equals("startDisplayDate")) {
/* 1638 */       return 1;
/*      */     }
/* 1640 */     if (strFieldName.equals("endDisplayDate")) {
/* 1641 */       return 1;
/*      */     }
/* 1643 */     if (strFieldName.equals("startDisplayTime")) {
/* 1644 */       return 0;
/*      */     }
/* 1646 */     if (strFieldName.equals("endDisplayTime")) {
/* 1647 */       return 0;
/*      */     }
/* 1649 */     if (strFieldName.equals("staticPageURL")) {
/* 1650 */       return 0;
/*      */     }
/* 1652 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1653 */       return 0;
/*      */     }
/* 1655 */     if (strFieldName.equals("checkState")) {
/* 1656 */       return 0;
/*      */     }
/* 1658 */     if (strFieldName.equals("checkOperator")) {
/* 1659 */       return 0;
/*      */     }
/* 1661 */     if (strFieldName.equals("checkReason")) {
/* 1662 */       return 0;
/*      */     }
/* 1664 */     if (strFieldName.equals("checkDate")) {
/* 1665 */       return 1;
/*      */     }
/* 1667 */     if (strFieldName.equals("checkTime")) {
/* 1668 */       return 0;
/*      */     }
/* 1670 */     if (strFieldName.equals("vF01")) {
/* 1671 */       return 0;
/*      */     }
/* 1673 */     if (strFieldName.equals("nF01")) {
/* 1674 */       return 0;
/*      */     }
/* 1676 */     if (strFieldName.equals("iF01")) {
/* 1677 */       return 3;
/*      */     }
/* 1679 */     if (strFieldName.equals("dF02")) {
/* 1680 */       return 4;
/*      */     }
/* 1682 */     if (strFieldName.equals("date01")) {
/* 1683 */       return 1;
/*      */     }
/* 1685 */     if (strFieldName.equals("modifyOperator")) {
/* 1686 */       return 0;
/*      */     }
/* 1688 */     if (strFieldName.equals("operator")) {
/* 1689 */       return 0;
/*      */     }
/* 1691 */     if (strFieldName.equals("makeDate")) {
/* 1692 */       return 1;
/*      */     }
/* 1694 */     if (strFieldName.equals("makeTime")) {
/* 1695 */       return 0;
/*      */     }
/* 1697 */     if (strFieldName.equals("modifyDate")) {
/* 1698 */       return 1;
/*      */     }
/* 1700 */     if (strFieldName.equals("modifyTime")) {
/* 1701 */       return 0;
/*      */     }
/* 1703 */     if (strFieldName.equals("clickRate")) {
/* 1704 */       return 3;
/*      */     }
/* 1706 */     if (strFieldName.equals("fixedTop")) {
/* 1707 */       return 3;
/*      */     }
/* 1709 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1715 */     int nFieldType = -1;
/* 1716 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1718 */       nFieldType = 0;
/* 1719 */       break;
/*      */     case 1:
/* 1721 */       nFieldType = 0;
/* 1722 */       break;
/*      */     case 2:
/* 1724 */       nFieldType = 0;
/* 1725 */       break;
/*      */     case 3:
/* 1727 */       nFieldType = 0;
/* 1728 */       break;
/*      */     case 4:
/* 1730 */       nFieldType = 0;
/* 1731 */       break;
/*      */     case 5:
/* 1733 */       nFieldType = 0;
/* 1734 */       break;
/*      */     case 6:
/* 1736 */       nFieldType = 0;
/* 1737 */       break;
/*      */     case 7:
/* 1739 */       nFieldType = 0;
/* 1740 */       break;
/*      */     case 8:
/* 1742 */       nFieldType = 1;
/* 1743 */       break;
/*      */     case 9:
/* 1745 */       nFieldType = 1;
/* 1746 */       break;
/*      */     case 10:
/* 1748 */       nFieldType = 0;
/* 1749 */       break;
/*      */     case 11:
/* 1751 */       nFieldType = 0;
/* 1752 */       break;
/*      */     case 12:
/* 1754 */       nFieldType = 0;
/* 1755 */       break;
/*      */     case 13:
/* 1757 */       nFieldType = 0;
/* 1758 */       break;
/*      */     case 14:
/* 1760 */       nFieldType = 0;
/* 1761 */       break;
/*      */     case 15:
/* 1763 */       nFieldType = 0;
/* 1764 */       break;
/*      */     case 16:
/* 1766 */       nFieldType = 0;
/* 1767 */       break;
/*      */     case 17:
/* 1769 */       nFieldType = 1;
/* 1770 */       break;
/*      */     case 18:
/* 1772 */       nFieldType = 0;
/* 1773 */       break;
/*      */     case 19:
/* 1775 */       nFieldType = 0;
/* 1776 */       break;
/*      */     case 20:
/* 1778 */       nFieldType = 0;
/* 1779 */       break;
/*      */     case 21:
/* 1781 */       nFieldType = 3;
/* 1782 */       break;
/*      */     case 22:
/* 1784 */       nFieldType = 4;
/* 1785 */       break;
/*      */     case 23:
/* 1787 */       nFieldType = 1;
/* 1788 */       break;
/*      */     case 24:
/* 1790 */       nFieldType = 0;
/* 1791 */       break;
/*      */     case 25:
/* 1793 */       nFieldType = 0;
/* 1794 */       break;
/*      */     case 26:
/* 1796 */       nFieldType = 1;
/* 1797 */       break;
/*      */     case 27:
/* 1799 */       nFieldType = 0;
/* 1800 */       break;
/*      */     case 28:
/* 1802 */       nFieldType = 1;
/* 1803 */       break;
/*      */     case 29:
/* 1805 */       nFieldType = 0;
/* 1806 */       break;
/*      */     case 30:
/* 1808 */       nFieldType = 3;
/* 1809 */       break;
/*      */     case 31:
/* 1811 */       nFieldType = 3;
/* 1812 */       break;
/*      */     default:
/* 1814 */       nFieldType = -1;
/*      */     }
/* 1816 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewsSchema
 * JD-Core Version:    0.6.0
 */