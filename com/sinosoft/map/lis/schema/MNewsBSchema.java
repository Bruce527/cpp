/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MNewsBDB;
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
/*      */ public class MNewsBSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String edorNo;
/*      */   private String edorType;
/*      */   private String edorCase;
/*      */   private String operator2;
/*      */   private Date makeDate2;
/*      */   private String makeTime2;
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
/*      */   public static final int FIELDNUM = 38;
/*      */   private static String[] PK;
/*  100 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MNewsBSchema()
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
/*  119 */     MNewsBSchema cloned = (MNewsBSchema)super.clone();
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
/*      */   public String getNewsID() {
/*  194 */     return this.newsID;
/*      */   }
/*      */ 
/*      */   public void setNewsID(String aNewsID) {
/*  198 */     this.newsID = aNewsID;
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
/*      */   public String getNewsType() {
/*  218 */     return this.newsType;
/*      */   }
/*      */ 
/*      */   public void setNewsType(String aNewsType) {
/*  222 */     this.newsType = aNewsType;
/*      */   }
/*      */ 
/*      */   public String getTitle() {
/*  226 */     return this.title;
/*      */   }
/*      */ 
/*      */   public void setTitle(String aTitle) {
/*  230 */     this.title = aTitle;
/*      */   }
/*      */ 
/*      */   public String getSubhead() {
/*  234 */     return this.subhead;
/*      */   }
/*      */ 
/*      */   public void setSubhead(String aSubhead) {
/*  238 */     this.subhead = aSubhead;
/*      */   }
/*      */ 
/*      */   public String getBrief() {
/*  242 */     return this.brief;
/*      */   }
/*      */ 
/*      */   public void setBrief(String aBrief) {
/*  246 */     this.brief = aBrief;
/*      */   }
/*      */ 
/*      */   public String getAuthor() {
/*  250 */     return this.author;
/*      */   }
/*      */ 
/*      */   public void setAuthor(String aAuthor) {
/*  254 */     this.author = aAuthor;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayDate() {
/*  258 */     if (this.startDisplayDate != null) {
/*  259 */       return this.fDate.getString(this.startDisplayDate);
/*      */     }
/*  261 */     return null;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(Date aStartDisplayDate) {
/*  265 */     this.startDisplayDate = aStartDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayDate(String aStartDisplayDate) {
/*  269 */     if ((aStartDisplayDate != null) && (!aStartDisplayDate.equals("")))
/*      */     {
/*  271 */       this.startDisplayDate = this.fDate.getDate(aStartDisplayDate);
/*      */     }
/*      */     else
/*  274 */       this.startDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayDate()
/*      */   {
/*  279 */     if (this.endDisplayDate != null) {
/*  280 */       return this.fDate.getString(this.endDisplayDate);
/*      */     }
/*  282 */     return null;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(Date aEndDisplayDate) {
/*  286 */     this.endDisplayDate = aEndDisplayDate;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayDate(String aEndDisplayDate) {
/*  290 */     if ((aEndDisplayDate != null) && (!aEndDisplayDate.equals("")))
/*      */     {
/*  292 */       this.endDisplayDate = this.fDate.getDate(aEndDisplayDate);
/*      */     }
/*      */     else
/*  295 */       this.endDisplayDate = null;
/*      */   }
/*      */ 
/*      */   public String getStartDisplayTime()
/*      */   {
/*  300 */     return this.startDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setStartDisplayTime(String aStartDisplayTime) {
/*  304 */     this.startDisplayTime = aStartDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getEndDisplayTime() {
/*  308 */     return this.endDisplayTime;
/*      */   }
/*      */ 
/*      */   public void setEndDisplayTime(String aEndDisplayTime) {
/*  312 */     this.endDisplayTime = aEndDisplayTime;
/*      */   }
/*      */ 
/*      */   public String getStaticPageURL() {
/*  316 */     return this.staticPageURL;
/*      */   }
/*      */ 
/*      */   public void setStaticPageURL(String aStaticPageURL) {
/*  320 */     this.staticPageURL = aStaticPageURL;
/*      */   }
/*      */ 
/*      */   public String getMinDisplayGrade() {
/*  324 */     return this.minDisplayGrade;
/*      */   }
/*      */ 
/*      */   public void setMinDisplayGrade(String aMinDisplayGrade) {
/*  328 */     this.minDisplayGrade = aMinDisplayGrade;
/*      */   }
/*      */ 
/*      */   public String getCheckState() {
/*  332 */     return this.checkState;
/*      */   }
/*      */ 
/*      */   public void setCheckState(String aCheckState) {
/*  336 */     this.checkState = aCheckState;
/*      */   }
/*      */ 
/*      */   public String getCheckOperator() {
/*  340 */     return this.checkOperator;
/*      */   }
/*      */ 
/*      */   public void setCheckOperator(String aCheckOperator) {
/*  344 */     this.checkOperator = aCheckOperator;
/*      */   }
/*      */ 
/*      */   public String getCheckReason() {
/*  348 */     return this.checkReason;
/*      */   }
/*      */ 
/*      */   public void setCheckReason(String aCheckReason) {
/*  352 */     this.checkReason = aCheckReason;
/*      */   }
/*      */ 
/*      */   public String getCheckDate() {
/*  356 */     if (this.checkDate != null) {
/*  357 */       return this.fDate.getString(this.checkDate);
/*      */     }
/*  359 */     return null;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(Date aCheckDate) {
/*  363 */     this.checkDate = aCheckDate;
/*      */   }
/*      */ 
/*      */   public void setCheckDate(String aCheckDate) {
/*  367 */     if ((aCheckDate != null) && (!aCheckDate.equals("")))
/*      */     {
/*  369 */       this.checkDate = this.fDate.getDate(aCheckDate);
/*      */     }
/*      */     else
/*  372 */       this.checkDate = null;
/*      */   }
/*      */ 
/*      */   public String getCheckTime()
/*      */   {
/*  377 */     return this.checkTime;
/*      */   }
/*      */ 
/*      */   public void setCheckTime(String aCheckTime) {
/*  381 */     this.checkTime = aCheckTime;
/*      */   }
/*      */ 
/*      */   public String getVF01() {
/*  385 */     return this.vF01;
/*      */   }
/*      */ 
/*      */   public void setVF01(String aVF01) {
/*  389 */     this.vF01 = aVF01;
/*      */   }
/*      */ 
/*      */   public String getNF01() {
/*  393 */     return this.nF01;
/*      */   }
/*      */ 
/*      */   public void setNF01(String aNF01) {
/*  397 */     this.nF01 = aNF01;
/*      */   }
/*      */ 
/*      */   public int getIF01() {
/*  401 */     return this.iF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(int aIF01) {
/*  405 */     this.iF01 = aIF01;
/*      */   }
/*      */ 
/*      */   public void setIF01(String aIF01) {
/*  409 */     if ((aIF01 != null) && (!aIF01.equals("")))
/*      */     {
/*  411 */       Integer tInteger = new Integer(aIF01);
/*  412 */       int i = tInteger.intValue();
/*  413 */       this.iF01 = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public double getDF02()
/*      */   {
/*  419 */     return this.dF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(double aDF02) {
/*  423 */     this.dF02 = aDF02;
/*      */   }
/*      */ 
/*      */   public void setDF02(String aDF02) {
/*  427 */     if ((aDF02 != null) && (!aDF02.equals("")))
/*      */     {
/*  429 */       Double tDouble = new Double(aDF02);
/*  430 */       double d = tDouble.doubleValue();
/*  431 */       this.dF02 = d;
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getDate01()
/*      */   {
/*  437 */     if (this.date01 != null) {
/*  438 */       return this.fDate.getString(this.date01);
/*      */     }
/*  440 */     return null;
/*      */   }
/*      */ 
/*      */   public void setDate01(Date aDate01) {
/*  444 */     this.date01 = aDate01;
/*      */   }
/*      */ 
/*      */   public void setDate01(String aDate01) {
/*  448 */     if ((aDate01 != null) && (!aDate01.equals("")))
/*      */     {
/*  450 */       this.date01 = this.fDate.getDate(aDate01);
/*      */     }
/*      */     else
/*  453 */       this.date01 = null;
/*      */   }
/*      */ 
/*      */   public String getModifyOperator()
/*      */   {
/*  458 */     return this.modifyOperator;
/*      */   }
/*      */ 
/*      */   public void setModifyOperator(String aModifyOperator) {
/*  462 */     this.modifyOperator = aModifyOperator;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  466 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  470 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  474 */     if (this.makeDate != null) {
/*  475 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  477 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  481 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  485 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  487 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  490 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  495 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  499 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  503 */     if (this.modifyDate != null) {
/*  504 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  506 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  510 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  514 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  516 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  519 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  524 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  528 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public int getClickRate() {
/*  532 */     return this.clickRate;
/*      */   }
/*      */ 
/*      */   public void setClickRate(int aClickRate) {
/*  536 */     this.clickRate = aClickRate;
/*      */   }
/*      */ 
/*      */   public void setClickRate(String aClickRate) {
/*  540 */     if ((aClickRate != null) && (!aClickRate.equals("")))
/*      */     {
/*  542 */       Integer tInteger = new Integer(aClickRate);
/*  543 */       int i = tInteger.intValue();
/*  544 */       this.clickRate = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getFixedTop()
/*      */   {
/*  550 */     return this.fixedTop;
/*      */   }
/*      */ 
/*      */   public void setFixedTop(int aFixedTop) {
/*  554 */     this.fixedTop = aFixedTop;
/*      */   }
/*      */ 
/*      */   public void setFixedTop(String aFixedTop) {
/*  558 */     if ((aFixedTop != null) && (!aFixedTop.equals("")))
/*      */     {
/*  560 */       Integer tInteger = new Integer(aFixedTop);
/*  561 */       int i = tInteger.intValue();
/*  562 */       this.fixedTop = i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setSchema(MNewsBSchema aMNewsBSchema)
/*      */   {
/*  570 */     this.edorNo = aMNewsBSchema.getEdorNo();
/*  571 */     this.edorType = aMNewsBSchema.getEdorType();
/*  572 */     this.edorCase = aMNewsBSchema.getEdorCase();
/*  573 */     this.operator2 = aMNewsBSchema.getOperator2();
/*  574 */     this.makeDate2 = this.fDate.getDate(aMNewsBSchema.getMakeDate2());
/*  575 */     this.makeTime2 = aMNewsBSchema.getMakeTime2();
/*  576 */     this.newsID = aMNewsBSchema.getNewsID();
/*  577 */     this.manageCom = aMNewsBSchema.getManageCom();
/*  578 */     this.branchType = aMNewsBSchema.getBranchType();
/*  579 */     this.newsType = aMNewsBSchema.getNewsType();
/*  580 */     this.title = aMNewsBSchema.getTitle();
/*  581 */     this.subhead = aMNewsBSchema.getSubhead();
/*  582 */     this.brief = aMNewsBSchema.getBrief();
/*  583 */     this.author = aMNewsBSchema.getAuthor();
/*  584 */     this.startDisplayDate = this.fDate.getDate(aMNewsBSchema.getStartDisplayDate());
/*  585 */     this.endDisplayDate = this.fDate.getDate(aMNewsBSchema.getEndDisplayDate());
/*  586 */     this.startDisplayTime = aMNewsBSchema.getStartDisplayTime();
/*  587 */     this.endDisplayTime = aMNewsBSchema.getEndDisplayTime();
/*  588 */     this.staticPageURL = aMNewsBSchema.getStaticPageURL();
/*  589 */     this.minDisplayGrade = aMNewsBSchema.getMinDisplayGrade();
/*  590 */     this.checkState = aMNewsBSchema.getCheckState();
/*  591 */     this.checkOperator = aMNewsBSchema.getCheckOperator();
/*  592 */     this.checkReason = aMNewsBSchema.getCheckReason();
/*  593 */     this.checkDate = this.fDate.getDate(aMNewsBSchema.getCheckDate());
/*  594 */     this.checkTime = aMNewsBSchema.getCheckTime();
/*  595 */     this.vF01 = aMNewsBSchema.getVF01();
/*  596 */     this.nF01 = aMNewsBSchema.getNF01();
/*  597 */     this.iF01 = aMNewsBSchema.getIF01();
/*  598 */     this.dF02 = aMNewsBSchema.getDF02();
/*  599 */     this.date01 = this.fDate.getDate(aMNewsBSchema.getDate01());
/*  600 */     this.modifyOperator = aMNewsBSchema.getModifyOperator();
/*  601 */     this.operator = aMNewsBSchema.getOperator();
/*  602 */     this.makeDate = this.fDate.getDate(aMNewsBSchema.getMakeDate());
/*  603 */     this.makeTime = aMNewsBSchema.getMakeTime();
/*  604 */     this.modifyDate = this.fDate.getDate(aMNewsBSchema.getModifyDate());
/*  605 */     this.modifyTime = aMNewsBSchema.getModifyTime();
/*  606 */     this.clickRate = aMNewsBSchema.getClickRate();
/*  607 */     this.fixedTop = aMNewsBSchema.getFixedTop();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  616 */       if (rs.getString("EdorNo") == null)
/*  617 */         this.edorNo = null;
/*      */       else {
/*  619 */         this.edorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  621 */       if (rs.getString("EdorType") == null)
/*  622 */         this.edorType = null;
/*      */       else {
/*  624 */         this.edorType = rs.getString("EdorType").trim();
/*      */       }
/*  626 */       if (rs.getString("EdorCase") == null)
/*  627 */         this.edorCase = null;
/*      */       else {
/*  629 */         this.edorCase = rs.getString("EdorCase").trim();
/*      */       }
/*  631 */       if (rs.getString("Operator2") == null)
/*  632 */         this.operator2 = null;
/*      */       else {
/*  634 */         this.operator2 = rs.getString("Operator2").trim();
/*      */       }
/*  636 */       this.makeDate2 = rs.getDate("MakeDate2");
/*  637 */       if (rs.getString("MakeTime2") == null)
/*  638 */         this.makeTime2 = null;
/*      */       else {
/*  640 */         this.makeTime2 = rs.getString("MakeTime2").trim();
/*      */       }
/*  642 */       if (rs.getString("NewsID") == null)
/*  643 */         this.newsID = null;
/*      */       else {
/*  645 */         this.newsID = rs.getString("NewsID").trim();
/*      */       }
/*  647 */       if (rs.getString("ManageCom") == null)
/*  648 */         this.manageCom = null;
/*      */       else {
/*  650 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  652 */       if (rs.getString("BranchType") == null)
/*  653 */         this.branchType = null;
/*      */       else {
/*  655 */         this.branchType = rs.getString("BranchType").trim();
/*      */       }
/*  657 */       if (rs.getString("NewsType") == null)
/*  658 */         this.newsType = null;
/*      */       else {
/*  660 */         this.newsType = rs.getString("NewsType").trim();
/*      */       }
/*  662 */       if (rs.getString("Title") == null)
/*  663 */         this.title = null;
/*      */       else {
/*  665 */         this.title = rs.getString("Title").trim();
/*      */       }
/*  667 */       if (rs.getString("Subhead") == null)
/*  668 */         this.subhead = null;
/*      */       else {
/*  670 */         this.subhead = rs.getString("Subhead").trim();
/*      */       }
/*  672 */       if (rs.getString("Brief") == null)
/*  673 */         this.brief = null;
/*      */       else {
/*  675 */         this.brief = rs.getString("Brief").trim();
/*      */       }
/*  677 */       if (rs.getString("Author") == null)
/*  678 */         this.author = null;
/*      */       else {
/*  680 */         this.author = rs.getString("Author").trim();
/*      */       }
/*  682 */       this.startDisplayDate = rs.getDate("StartDisplayDate");
/*  683 */       this.endDisplayDate = rs.getDate("EndDisplayDate");
/*  684 */       if (rs.getString("StartDisplayTime") == null)
/*  685 */         this.startDisplayTime = null;
/*      */       else {
/*  687 */         this.startDisplayTime = rs.getString("StartDisplayTime").trim();
/*      */       }
/*  689 */       if (rs.getString("EndDisplayTime") == null)
/*  690 */         this.endDisplayTime = null;
/*      */       else {
/*  692 */         this.endDisplayTime = rs.getString("EndDisplayTime").trim();
/*      */       }
/*  694 */       if (rs.getString("StaticPageURL") == null)
/*  695 */         this.staticPageURL = null;
/*      */       else {
/*  697 */         this.staticPageURL = rs.getString("StaticPageURL").trim();
/*      */       }
/*  699 */       if (rs.getString("MinDisplayGrade") == null)
/*  700 */         this.minDisplayGrade = null;
/*      */       else {
/*  702 */         this.minDisplayGrade = rs.getString("MinDisplayGrade").trim();
/*      */       }
/*  704 */       if (rs.getString("CheckState") == null)
/*  705 */         this.checkState = null;
/*      */       else {
/*  707 */         this.checkState = rs.getString("CheckState").trim();
/*      */       }
/*  709 */       if (rs.getString("CheckOperator") == null)
/*  710 */         this.checkOperator = null;
/*      */       else {
/*  712 */         this.checkOperator = rs.getString("CheckOperator").trim();
/*      */       }
/*  714 */       if (rs.getString("CheckReason") == null)
/*  715 */         this.checkReason = null;
/*      */       else {
/*  717 */         this.checkReason = rs.getString("CheckReason").trim();
/*      */       }
/*  719 */       this.checkDate = rs.getDate("CheckDate");
/*  720 */       if (rs.getString("CheckTime") == null)
/*  721 */         this.checkTime = null;
/*      */       else {
/*  723 */         this.checkTime = rs.getString("CheckTime").trim();
/*      */       }
/*  725 */       if (rs.getString("VF01") == null)
/*  726 */         this.vF01 = null;
/*      */       else {
/*  728 */         this.vF01 = rs.getString("VF01").trim();
/*      */       }
/*  730 */       if (rs.getString("NF01") == null)
/*  731 */         this.nF01 = null;
/*      */       else {
/*  733 */         this.nF01 = rs.getString("NF01").trim();
/*      */       }
/*  735 */       this.iF01 = rs.getInt("IF01");
/*  736 */       this.dF02 = rs.getDouble("DF02");
/*  737 */       this.date01 = rs.getDate("Date01");
/*  738 */       if (rs.getString("ModifyOperator") == null)
/*  739 */         this.modifyOperator = null;
/*      */       else {
/*  741 */         this.modifyOperator = rs.getString("ModifyOperator").trim();
/*      */       }
/*  743 */       if (rs.getString("Operator") == null)
/*  744 */         this.operator = null;
/*      */       else {
/*  746 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  748 */       this.makeDate = rs.getDate("MakeDate");
/*  749 */       if (rs.getString("MakeTime") == null)
/*  750 */         this.makeTime = null;
/*      */       else {
/*  752 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  754 */       this.modifyDate = rs.getDate("ModifyDate");
/*  755 */       if (rs.getString("ModifyTime") == null)
/*  756 */         this.modifyTime = null;
/*      */       else {
/*  758 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  760 */       this.clickRate = rs.getInt("ClickRate");
/*  761 */       this.fixedTop = rs.getInt("FixedTop");
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  765 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNewsB\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  767 */       CError tError = new CError();
/*  768 */       tError.moduleName = "MNewsBSchema";
/*  769 */       tError.functionName = "setSchema";
/*  770 */       tError.errorMessage = sqle.toString();
/*  771 */       this.mErrors.addOneError(tError);
/*  772 */       return false;
/*      */     }
/*  774 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewsBSchema getSchema()
/*      */   {
/*  779 */     MNewsBSchema aMNewsBSchema = new MNewsBSchema();
/*  780 */     aMNewsBSchema.setSchema(this);
/*  781 */     return aMNewsBSchema;
/*      */   }
/*      */ 
/*      */   public MNewsBDB getDB()
/*      */   {
/*  786 */     MNewsBDB aDBOper = new MNewsBDB();
/*  787 */     aDBOper.setSchema(this);
/*  788 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  795 */     StringBuffer strReturn = new StringBuffer(256);
/*  796 */     strReturn.append(StrTool.cTrim(this.edorNo)); strReturn.append("|");
/*  797 */     strReturn.append(StrTool.cTrim(this.edorType)); strReturn.append("|");
/*  798 */     strReturn.append(StrTool.cTrim(this.edorCase)); strReturn.append("|");
/*  799 */     strReturn.append(StrTool.cTrim(this.operator2)); strReturn.append("|");
/*  800 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate2))); strReturn.append("|");
/*  801 */     strReturn.append(StrTool.cTrim(this.makeTime2)); strReturn.append("|");
/*  802 */     strReturn.append(StrTool.cTrim(this.newsID)); strReturn.append("|");
/*  803 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  804 */     strReturn.append(StrTool.cTrim(this.branchType)); strReturn.append("|");
/*  805 */     strReturn.append(StrTool.cTrim(this.newsType)); strReturn.append("|");
/*  806 */     strReturn.append(StrTool.cTrim(this.title)); strReturn.append("|");
/*  807 */     strReturn.append(StrTool.cTrim(this.subhead)); strReturn.append("|");
/*  808 */     strReturn.append(StrTool.cTrim(this.brief)); strReturn.append("|");
/*  809 */     strReturn.append(StrTool.cTrim(this.author)); strReturn.append("|");
/*  810 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDisplayDate))); strReturn.append("|");
/*  811 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDisplayDate))); strReturn.append("|");
/*  812 */     strReturn.append(StrTool.cTrim(this.startDisplayTime)); strReturn.append("|");
/*  813 */     strReturn.append(StrTool.cTrim(this.endDisplayTime)); strReturn.append("|");
/*  814 */     strReturn.append(StrTool.cTrim(this.staticPageURL)); strReturn.append("|");
/*  815 */     strReturn.append(StrTool.cTrim(this.minDisplayGrade)); strReturn.append("|");
/*  816 */     strReturn.append(StrTool.cTrim(this.checkState)); strReturn.append("|");
/*  817 */     strReturn.append(StrTool.cTrim(this.checkOperator)); strReturn.append("|");
/*  818 */     strReturn.append(StrTool.cTrim(this.checkReason)); strReturn.append("|");
/*  819 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.checkDate))); strReturn.append("|");
/*  820 */     strReturn.append(StrTool.cTrim(this.checkTime)); strReturn.append("|");
/*  821 */     strReturn.append(StrTool.cTrim(this.vF01)); strReturn.append("|");
/*  822 */     strReturn.append(StrTool.cTrim(this.nF01)); strReturn.append("|");
/*  823 */     strReturn.append(ChgData.chgData(this.iF01)); strReturn.append("|");
/*  824 */     strReturn.append(ChgData.chgData(this.dF02)); strReturn.append("|");
/*  825 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.date01))); strReturn.append("|");
/*  826 */     strReturn.append(StrTool.cTrim(this.modifyOperator)); strReturn.append("|");
/*  827 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  828 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  829 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  830 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  831 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  832 */     strReturn.append(ChgData.chgData(this.clickRate)); strReturn.append("|");
/*  833 */     strReturn.append(ChgData.chgData(this.fixedTop));
/*  834 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  842 */       this.edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  843 */       this.edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  844 */       this.edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  845 */       this.operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  846 */       this.makeDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/*  847 */       this.makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  848 */       this.newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  849 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  850 */       this.branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  851 */       this.newsType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  852 */       this.title = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  853 */       this.subhead = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  854 */       this.brief = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  855 */       this.author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  856 */       this.startDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
/*  857 */       this.endDisplayDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
/*  858 */       this.startDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  859 */       this.endDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  860 */       this.staticPageURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  861 */       this.minDisplayGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  862 */       this.checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  863 */       this.checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  864 */       this.checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  865 */       this.checkDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  866 */       this.checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  867 */       this.vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  868 */       this.nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  869 */       this.iF01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|"))).intValue();
/*  870 */       this.dF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/*  871 */       this.date01 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
/*  872 */       this.modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  873 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  874 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
/*  875 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*  876 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|"));
/*  877 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/*  878 */       this.clickRate = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|"))).intValue();
/*  879 */       this.fixedTop = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).intValue();
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  884 */       CError tError = new CError();
/*  885 */       tError.moduleName = "MNewsBSchema";
/*  886 */       tError.functionName = "decode";
/*  887 */       tError.errorMessage = ex.toString();
/*  888 */       this.mErrors.addOneError(tError);
/*      */ 
/*  890 */       return false;
/*      */     }
/*  892 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  898 */     String strReturn = "";
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
/*  923 */     if (FCode.equalsIgnoreCase("newsID"))
/*      */     {
/*  925 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsID));
/*      */     }
/*  927 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/*  929 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/*  931 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/*  933 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchType));
/*      */     }
/*  935 */     if (FCode.equalsIgnoreCase("newsType"))
/*      */     {
/*  937 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsType));
/*      */     }
/*  939 */     if (FCode.equalsIgnoreCase("title"))
/*      */     {
/*  941 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.title));
/*      */     }
/*  943 */     if (FCode.equalsIgnoreCase("subhead"))
/*      */     {
/*  945 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.subhead));
/*      */     }
/*  947 */     if (FCode.equalsIgnoreCase("brief"))
/*      */     {
/*  949 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.brief));
/*      */     }
/*  951 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/*  953 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.author));
/*      */     }
/*  955 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/*  957 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/*      */     }
/*  959 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/*  961 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/*      */     }
/*  963 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/*  965 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.startDisplayTime));
/*      */     }
/*  967 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/*  969 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.endDisplayTime));
/*      */     }
/*  971 */     if (FCode.equalsIgnoreCase("staticPageURL"))
/*      */     {
/*  973 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.staticPageURL));
/*      */     }
/*  975 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/*  977 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.minDisplayGrade));
/*      */     }
/*  979 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/*  981 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkState));
/*      */     }
/*  983 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/*  985 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkOperator));
/*      */     }
/*  987 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/*  989 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkReason));
/*      */     }
/*  991 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/*  993 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/*      */     }
/*  995 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/*  997 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.checkTime));
/*      */     }
/*  999 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1001 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF01));
/*      */     }
/* 1003 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1005 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*      */     }
/* 1007 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1009 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iF01));
/*      */     }
/* 1011 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1013 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.dF02));
/*      */     }
/* 1015 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1017 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/*      */     }
/* 1019 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1021 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyOperator));
/*      */     }
/* 1023 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1025 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1027 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1029 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1031 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1033 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1035 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1037 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1039 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1041 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1043 */     if (FCode.equalsIgnoreCase("clickRate"))
/*      */     {
/* 1045 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clickRate));
/*      */     }
/* 1047 */     if (FCode.equalsIgnoreCase("fixedTop"))
/*      */     {
/* 1049 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fixedTop));
/*      */     }
/* 1051 */     if (strReturn.equals(""))
/*      */     {
/* 1053 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1056 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1063 */     String strFieldValue = "";
/* 1064 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1066 */       strFieldValue = StrTool.GBKToUnicode(this.edorNo);
/* 1067 */       break;
/*      */     case 1:
/* 1069 */       strFieldValue = StrTool.GBKToUnicode(this.edorType);
/* 1070 */       break;
/*      */     case 2:
/* 1072 */       strFieldValue = StrTool.GBKToUnicode(this.edorCase);
/* 1073 */       break;
/*      */     case 3:
/* 1075 */       strFieldValue = StrTool.GBKToUnicode(this.operator2);
/* 1076 */       break;
/*      */     case 4:
/* 1078 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
/* 1079 */       break;
/*      */     case 5:
/* 1081 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime2);
/* 1082 */       break;
/*      */     case 6:
/* 1084 */       strFieldValue = StrTool.GBKToUnicode(this.newsID);
/* 1085 */       break;
/*      */     case 7:
/* 1087 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1088 */       break;
/*      */     case 8:
/* 1090 */       strFieldValue = StrTool.GBKToUnicode(this.branchType);
/* 1091 */       break;
/*      */     case 9:
/* 1093 */       strFieldValue = StrTool.GBKToUnicode(this.newsType);
/* 1094 */       break;
/*      */     case 10:
/* 1096 */       strFieldValue = StrTool.GBKToUnicode(this.title);
/* 1097 */       break;
/*      */     case 11:
/* 1099 */       strFieldValue = StrTool.GBKToUnicode(this.subhead);
/* 1100 */       break;
/*      */     case 12:
/* 1102 */       strFieldValue = StrTool.GBKToUnicode(this.brief);
/* 1103 */       break;
/*      */     case 13:
/* 1105 */       strFieldValue = StrTool.GBKToUnicode(this.author);
/* 1106 */       break;
/*      */     case 14:
/* 1108 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
/* 1109 */       break;
/*      */     case 15:
/* 1111 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
/* 1112 */       break;
/*      */     case 16:
/* 1114 */       strFieldValue = StrTool.GBKToUnicode(this.startDisplayTime);
/* 1115 */       break;
/*      */     case 17:
/* 1117 */       strFieldValue = StrTool.GBKToUnicode(this.endDisplayTime);
/* 1118 */       break;
/*      */     case 18:
/* 1120 */       strFieldValue = StrTool.GBKToUnicode(this.staticPageURL);
/* 1121 */       break;
/*      */     case 19:
/* 1123 */       strFieldValue = StrTool.GBKToUnicode(this.minDisplayGrade);
/* 1124 */       break;
/*      */     case 20:
/* 1126 */       strFieldValue = StrTool.GBKToUnicode(this.checkState);
/* 1127 */       break;
/*      */     case 21:
/* 1129 */       strFieldValue = StrTool.GBKToUnicode(this.checkOperator);
/* 1130 */       break;
/*      */     case 22:
/* 1132 */       strFieldValue = StrTool.GBKToUnicode(this.checkReason);
/* 1133 */       break;
/*      */     case 23:
/* 1135 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
/* 1136 */       break;
/*      */     case 24:
/* 1138 */       strFieldValue = StrTool.GBKToUnicode(this.checkTime);
/* 1139 */       break;
/*      */     case 25:
/* 1141 */       strFieldValue = StrTool.GBKToUnicode(this.vF01);
/* 1142 */       break;
/*      */     case 26:
/* 1144 */       strFieldValue = StrTool.GBKToUnicode(this.nF01);
/* 1145 */       break;
/*      */     case 27:
/* 1147 */       strFieldValue = String.valueOf(this.iF01);
/* 1148 */       break;
/*      */     case 28:
/* 1150 */       strFieldValue = String.valueOf(this.dF02);
/* 1151 */       break;
/*      */     case 29:
/* 1153 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
/* 1154 */       break;
/*      */     case 30:
/* 1156 */       strFieldValue = StrTool.GBKToUnicode(this.modifyOperator);
/* 1157 */       break;
/*      */     case 31:
/* 1159 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1160 */       break;
/*      */     case 32:
/* 1162 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1163 */       break;
/*      */     case 33:
/* 1165 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1166 */       break;
/*      */     case 34:
/* 1168 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1169 */       break;
/*      */     case 35:
/* 1171 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1172 */       break;
/*      */     case 36:
/* 1174 */       strFieldValue = String.valueOf(this.clickRate);
/* 1175 */       break;
/*      */     case 37:
/* 1177 */       strFieldValue = String.valueOf(this.fixedTop);
/* 1178 */       break;
/*      */     default:
/* 1180 */       strFieldValue = "";
/*      */     }
/* 1182 */     if (strFieldValue.equals("")) {
/* 1183 */       strFieldValue = "null";
/*      */     }
/* 1185 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1191 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1192 */       return false;
/*      */     }
/* 1194 */     if (FCode.equalsIgnoreCase("edorNo"))
/*      */     {
/* 1196 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1198 */         this.edorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1201 */         this.edorNo = null;
/*      */     }
/* 1203 */     if (FCode.equalsIgnoreCase("edorType"))
/*      */     {
/* 1205 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1207 */         this.edorType = FValue.trim();
/*      */       }
/*      */       else
/* 1210 */         this.edorType = null;
/*      */     }
/* 1212 */     if (FCode.equalsIgnoreCase("edorCase"))
/*      */     {
/* 1214 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1216 */         this.edorCase = FValue.trim();
/*      */       }
/*      */       else
/* 1219 */         this.edorCase = null;
/*      */     }
/* 1221 */     if (FCode.equalsIgnoreCase("operator2"))
/*      */     {
/* 1223 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1225 */         this.operator2 = FValue.trim();
/*      */       }
/*      */       else
/* 1228 */         this.operator2 = null;
/*      */     }
/* 1230 */     if (FCode.equalsIgnoreCase("makeDate2"))
/*      */     {
/* 1232 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1234 */         this.makeDate2 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1237 */         this.makeDate2 = null;
/*      */     }
/* 1239 */     if (FCode.equalsIgnoreCase("makeTime2"))
/*      */     {
/* 1241 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1243 */         this.makeTime2 = FValue.trim();
/*      */       }
/*      */       else
/* 1246 */         this.makeTime2 = null;
/*      */     }
/* 1248 */     if (FCode.equalsIgnoreCase("newsID"))
/*      */     {
/* 1250 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1252 */         this.newsID = FValue.trim();
/*      */       }
/*      */       else
/* 1255 */         this.newsID = null;
/*      */     }
/* 1257 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1259 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1261 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1264 */         this.manageCom = null;
/*      */     }
/* 1266 */     if (FCode.equalsIgnoreCase("branchType"))
/*      */     {
/* 1268 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1270 */         this.branchType = FValue.trim();
/*      */       }
/*      */       else
/* 1273 */         this.branchType = null;
/*      */     }
/* 1275 */     if (FCode.equalsIgnoreCase("newsType"))
/*      */     {
/* 1277 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1279 */         this.newsType = FValue.trim();
/*      */       }
/*      */       else
/* 1282 */         this.newsType = null;
/*      */     }
/* 1284 */     if (FCode.equalsIgnoreCase("title"))
/*      */     {
/* 1286 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1288 */         this.title = FValue.trim();
/*      */       }
/*      */       else
/* 1291 */         this.title = null;
/*      */     }
/* 1293 */     if (FCode.equalsIgnoreCase("subhead"))
/*      */     {
/* 1295 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1297 */         this.subhead = FValue.trim();
/*      */       }
/*      */       else
/* 1300 */         this.subhead = null;
/*      */     }
/* 1302 */     if (FCode.equalsIgnoreCase("brief"))
/*      */     {
/* 1304 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1306 */         this.brief = FValue.trim();
/*      */       }
/*      */       else
/* 1309 */         this.brief = null;
/*      */     }
/* 1311 */     if (FCode.equalsIgnoreCase("author"))
/*      */     {
/* 1313 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1315 */         this.author = FValue.trim();
/*      */       }
/*      */       else
/* 1318 */         this.author = null;
/*      */     }
/* 1320 */     if (FCode.equalsIgnoreCase("startDisplayDate"))
/*      */     {
/* 1322 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1324 */         this.startDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1327 */         this.startDisplayDate = null;
/*      */     }
/* 1329 */     if (FCode.equalsIgnoreCase("endDisplayDate"))
/*      */     {
/* 1331 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1333 */         this.endDisplayDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1336 */         this.endDisplayDate = null;
/*      */     }
/* 1338 */     if (FCode.equalsIgnoreCase("startDisplayTime"))
/*      */     {
/* 1340 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1342 */         this.startDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1345 */         this.startDisplayTime = null;
/*      */     }
/* 1347 */     if (FCode.equalsIgnoreCase("endDisplayTime"))
/*      */     {
/* 1349 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1351 */         this.endDisplayTime = FValue.trim();
/*      */       }
/*      */       else
/* 1354 */         this.endDisplayTime = null;
/*      */     }
/* 1356 */     if (FCode.equalsIgnoreCase("staticPageURL"))
/*      */     {
/* 1358 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1360 */         this.staticPageURL = FValue.trim();
/*      */       }
/*      */       else
/* 1363 */         this.staticPageURL = null;
/*      */     }
/* 1365 */     if (FCode.equalsIgnoreCase("minDisplayGrade"))
/*      */     {
/* 1367 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1369 */         this.minDisplayGrade = FValue.trim();
/*      */       }
/*      */       else
/* 1372 */         this.minDisplayGrade = null;
/*      */     }
/* 1374 */     if (FCode.equalsIgnoreCase("checkState"))
/*      */     {
/* 1376 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1378 */         this.checkState = FValue.trim();
/*      */       }
/*      */       else
/* 1381 */         this.checkState = null;
/*      */     }
/* 1383 */     if (FCode.equalsIgnoreCase("checkOperator"))
/*      */     {
/* 1385 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1387 */         this.checkOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1390 */         this.checkOperator = null;
/*      */     }
/* 1392 */     if (FCode.equalsIgnoreCase("checkReason"))
/*      */     {
/* 1394 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1396 */         this.checkReason = FValue.trim();
/*      */       }
/*      */       else
/* 1399 */         this.checkReason = null;
/*      */     }
/* 1401 */     if (FCode.equalsIgnoreCase("checkDate"))
/*      */     {
/* 1403 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1405 */         this.checkDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1408 */         this.checkDate = null;
/*      */     }
/* 1410 */     if (FCode.equalsIgnoreCase("checkTime"))
/*      */     {
/* 1412 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1414 */         this.checkTime = FValue.trim();
/*      */       }
/*      */       else
/* 1417 */         this.checkTime = null;
/*      */     }
/* 1419 */     if (FCode.equalsIgnoreCase("vF01"))
/*      */     {
/* 1421 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1423 */         this.vF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1426 */         this.vF01 = null;
/*      */     }
/* 1428 */     if (FCode.equalsIgnoreCase("nF01"))
/*      */     {
/* 1430 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1432 */         this.nF01 = FValue.trim();
/*      */       }
/*      */       else
/* 1435 */         this.nF01 = null;
/*      */     }
/* 1437 */     if (FCode.equalsIgnoreCase("iF01"))
/*      */     {
/* 1439 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1441 */         Integer tInteger = new Integer(FValue);
/* 1442 */         int i = tInteger.intValue();
/* 1443 */         this.iF01 = i;
/*      */       }
/*      */     }
/* 1446 */     if (FCode.equalsIgnoreCase("dF02"))
/*      */     {
/* 1448 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1450 */         Double tDouble = new Double(FValue);
/* 1451 */         double d = tDouble.doubleValue();
/* 1452 */         this.dF02 = d;
/*      */       }
/*      */     }
/* 1455 */     if (FCode.equalsIgnoreCase("date01"))
/*      */     {
/* 1457 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1459 */         this.date01 = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1462 */         this.date01 = null;
/*      */     }
/* 1464 */     if (FCode.equalsIgnoreCase("modifyOperator"))
/*      */     {
/* 1466 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1468 */         this.modifyOperator = FValue.trim();
/*      */       }
/*      */       else
/* 1471 */         this.modifyOperator = null;
/*      */     }
/* 1473 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1475 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1477 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1480 */         this.operator = null;
/*      */     }
/* 1482 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1484 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1486 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1489 */         this.makeDate = null;
/*      */     }
/* 1491 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1493 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1495 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1498 */         this.makeTime = null;
/*      */     }
/* 1500 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1502 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1504 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1507 */         this.modifyDate = null;
/*      */     }
/* 1509 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1511 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1513 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1516 */         this.modifyTime = null;
/*      */     }
/* 1518 */     if (FCode.equalsIgnoreCase("clickRate"))
/*      */     {
/* 1520 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1522 */         Integer tInteger = new Integer(FValue);
/* 1523 */         int i = tInteger.intValue();
/* 1524 */         this.clickRate = i;
/*      */       }
/*      */     }
/* 1527 */     if (FCode.equalsIgnoreCase("fixedTop"))
/*      */     {
/* 1529 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1531 */         Integer tInteger = new Integer(FValue);
/* 1532 */         int i = tInteger.intValue();
/* 1533 */         this.fixedTop = i;
/*      */       }
/*      */     }
/* 1536 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1541 */     if (otherObject == null) return false;
/* 1542 */     if (this == otherObject) return true;
/* 1543 */     if (getClass() != otherObject.getClass()) return false;
/* 1544 */     MNewsBSchema other = (MNewsBSchema)otherObject;
/* 1545 */     if ((this.edorNo == null) && (other.getEdorNo() != null)) return false;
/* 1546 */     if ((this.edorNo != null) && (!this.edorNo.equals(other.getEdorNo()))) return false;
/* 1547 */     if ((this.edorType == null) && (other.getEdorType() != null)) return false;
/* 1548 */     if ((this.edorType != null) && (!this.edorType.equals(other.getEdorType()))) return false;
/* 1549 */     if ((this.edorCase == null) && (other.getEdorCase() != null)) return false;
/* 1550 */     if ((this.edorCase != null) && (!this.edorCase.equals(other.getEdorCase()))) return false;
/* 1551 */     if ((this.operator2 == null) && (other.getOperator2() != null)) return false;
/* 1552 */     if ((this.operator2 != null) && (!this.operator2.equals(other.getOperator2()))) return false;
/* 1553 */     if ((this.makeDate2 == null) && (other.getMakeDate2() != null)) return false;
/* 1554 */     if ((this.makeDate2 != null) && (!this.fDate.getString(this.makeDate2).equals(other.getMakeDate2()))) return false;
/* 1555 */     if ((this.makeTime2 == null) && (other.getMakeTime2() != null)) return false;
/* 1556 */     if ((this.makeTime2 != null) && (!this.makeTime2.equals(other.getMakeTime2()))) return false;
/* 1557 */     if ((this.newsID == null) && (other.getNewsID() != null)) return false;
/* 1558 */     if ((this.newsID != null) && (!this.newsID.equals(other.getNewsID()))) return false;
/* 1559 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1560 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1561 */     if ((this.branchType == null) && (other.getBranchType() != null)) return false;
/* 1562 */     if ((this.branchType != null) && (!this.branchType.equals(other.getBranchType()))) return false;
/* 1563 */     if ((this.newsType == null) && (other.getNewsType() != null)) return false;
/* 1564 */     if ((this.newsType != null) && (!this.newsType.equals(other.getNewsType()))) return false;
/* 1565 */     if ((this.title == null) && (other.getTitle() != null)) return false;
/* 1566 */     if ((this.title != null) && (!this.title.equals(other.getTitle()))) return false;
/* 1567 */     if ((this.subhead == null) && (other.getSubhead() != null)) return false;
/* 1568 */     if ((this.subhead != null) && (!this.subhead.equals(other.getSubhead()))) return false;
/* 1569 */     if ((this.brief == null) && (other.getBrief() != null)) return false;
/* 1570 */     if ((this.brief != null) && (!this.brief.equals(other.getBrief()))) return false;
/* 1571 */     if ((this.author == null) && (other.getAuthor() != null)) return false;
/* 1572 */     if ((this.author != null) && (!this.author.equals(other.getAuthor()))) return false;
/* 1573 */     if ((this.startDisplayDate == null) && (other.getStartDisplayDate() != null)) return false;
/* 1574 */     if ((this.startDisplayDate != null) && (!this.fDate.getString(this.startDisplayDate).equals(other.getStartDisplayDate()))) return false;
/* 1575 */     if ((this.endDisplayDate == null) && (other.getEndDisplayDate() != null)) return false;
/* 1576 */     if ((this.endDisplayDate != null) && (!this.fDate.getString(this.endDisplayDate).equals(other.getEndDisplayDate()))) return false;
/* 1577 */     if ((this.startDisplayTime == null) && (other.getStartDisplayTime() != null)) return false;
/* 1578 */     if ((this.startDisplayTime != null) && (!this.startDisplayTime.equals(other.getStartDisplayTime()))) return false;
/* 1579 */     if ((this.endDisplayTime == null) && (other.getEndDisplayTime() != null)) return false;
/* 1580 */     if ((this.endDisplayTime != null) && (!this.endDisplayTime.equals(other.getEndDisplayTime()))) return false;
/* 1581 */     if ((this.staticPageURL == null) && (other.getStaticPageURL() != null)) return false;
/* 1582 */     if ((this.staticPageURL != null) && (!this.staticPageURL.equals(other.getStaticPageURL()))) return false;
/* 1583 */     if ((this.minDisplayGrade == null) && (other.getMinDisplayGrade() != null)) return false;
/* 1584 */     if ((this.minDisplayGrade != null) && (!this.minDisplayGrade.equals(other.getMinDisplayGrade()))) return false;
/* 1585 */     if ((this.checkState == null) && (other.getCheckState() != null)) return false;
/* 1586 */     if ((this.checkState != null) && (!this.checkState.equals(other.getCheckState()))) return false;
/* 1587 */     if ((this.checkOperator == null) && (other.getCheckOperator() != null)) return false;
/* 1588 */     if ((this.checkOperator != null) && (!this.checkOperator.equals(other.getCheckOperator()))) return false;
/* 1589 */     if ((this.checkReason == null) && (other.getCheckReason() != null)) return false;
/* 1590 */     if ((this.checkReason != null) && (!this.checkReason.equals(other.getCheckReason()))) return false;
/* 1591 */     if ((this.checkDate == null) && (other.getCheckDate() != null)) return false;
/* 1592 */     if ((this.checkDate != null) && (!this.fDate.getString(this.checkDate).equals(other.getCheckDate()))) return false;
/* 1593 */     if ((this.checkTime == null) && (other.getCheckTime() != null)) return false;
/* 1594 */     if ((this.checkTime != null) && (!this.checkTime.equals(other.getCheckTime()))) return false;
/* 1595 */     if ((this.vF01 == null) && (other.getVF01() != null)) return false;
/* 1596 */     if ((this.vF01 != null) && (!this.vF01.equals(other.getVF01()))) return false;
/* 1597 */     if ((this.nF01 == null) && (other.getNF01() != null)) return false;
/* 1598 */     if ((this.nF01 != null) && (!this.nF01.equals(other.getNF01()))) return false;
/* 1599 */     if (this.iF01 != other.getIF01()) return false;
/* 1600 */     if (Double.doubleToLongBits(this.dF02) != Double.doubleToLongBits(other.getDF02())) return false;
/* 1601 */     if ((this.date01 == null) && (other.getDate01() != null)) return false;
/* 1602 */     if ((this.date01 != null) && (!this.fDate.getString(this.date01).equals(other.getDate01()))) return false;
/* 1603 */     if ((this.modifyOperator == null) && (other.getModifyOperator() != null)) return false;
/* 1604 */     if ((this.modifyOperator != null) && (!this.modifyOperator.equals(other.getModifyOperator()))) return false;
/* 1605 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1606 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1607 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1608 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1609 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1610 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1611 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1612 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1613 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1614 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1615 */     if (this.clickRate != other.getClickRate()) return false;
/* 1616 */     return this.fixedTop == other.getFixedTop();
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1623 */     return 38;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1629 */     if (strFieldName.equals("edorNo")) {
/* 1630 */       return 0;
/*      */     }
/* 1632 */     if (strFieldName.equals("edorType")) {
/* 1633 */       return 1;
/*      */     }
/* 1635 */     if (strFieldName.equals("edorCase")) {
/* 1636 */       return 2;
/*      */     }
/* 1638 */     if (strFieldName.equals("operator2")) {
/* 1639 */       return 3;
/*      */     }
/* 1641 */     if (strFieldName.equals("makeDate2")) {
/* 1642 */       return 4;
/*      */     }
/* 1644 */     if (strFieldName.equals("makeTime2")) {
/* 1645 */       return 5;
/*      */     }
/* 1647 */     if (strFieldName.equals("newsID")) {
/* 1648 */       return 6;
/*      */     }
/* 1650 */     if (strFieldName.equals("manageCom")) {
/* 1651 */       return 7;
/*      */     }
/* 1653 */     if (strFieldName.equals("branchType")) {
/* 1654 */       return 8;
/*      */     }
/* 1656 */     if (strFieldName.equals("newsType")) {
/* 1657 */       return 9;
/*      */     }
/* 1659 */     if (strFieldName.equals("title")) {
/* 1660 */       return 10;
/*      */     }
/* 1662 */     if (strFieldName.equals("subhead")) {
/* 1663 */       return 11;
/*      */     }
/* 1665 */     if (strFieldName.equals("brief")) {
/* 1666 */       return 12;
/*      */     }
/* 1668 */     if (strFieldName.equals("author")) {
/* 1669 */       return 13;
/*      */     }
/* 1671 */     if (strFieldName.equals("startDisplayDate")) {
/* 1672 */       return 14;
/*      */     }
/* 1674 */     if (strFieldName.equals("endDisplayDate")) {
/* 1675 */       return 15;
/*      */     }
/* 1677 */     if (strFieldName.equals("startDisplayTime")) {
/* 1678 */       return 16;
/*      */     }
/* 1680 */     if (strFieldName.equals("endDisplayTime")) {
/* 1681 */       return 17;
/*      */     }
/* 1683 */     if (strFieldName.equals("staticPageURL")) {
/* 1684 */       return 18;
/*      */     }
/* 1686 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1687 */       return 19;
/*      */     }
/* 1689 */     if (strFieldName.equals("checkState")) {
/* 1690 */       return 20;
/*      */     }
/* 1692 */     if (strFieldName.equals("checkOperator")) {
/* 1693 */       return 21;
/*      */     }
/* 1695 */     if (strFieldName.equals("checkReason")) {
/* 1696 */       return 22;
/*      */     }
/* 1698 */     if (strFieldName.equals("checkDate")) {
/* 1699 */       return 23;
/*      */     }
/* 1701 */     if (strFieldName.equals("checkTime")) {
/* 1702 */       return 24;
/*      */     }
/* 1704 */     if (strFieldName.equals("vF01")) {
/* 1705 */       return 25;
/*      */     }
/* 1707 */     if (strFieldName.equals("nF01")) {
/* 1708 */       return 26;
/*      */     }
/* 1710 */     if (strFieldName.equals("iF01")) {
/* 1711 */       return 27;
/*      */     }
/* 1713 */     if (strFieldName.equals("dF02")) {
/* 1714 */       return 28;
/*      */     }
/* 1716 */     if (strFieldName.equals("date01")) {
/* 1717 */       return 29;
/*      */     }
/* 1719 */     if (strFieldName.equals("modifyOperator")) {
/* 1720 */       return 30;
/*      */     }
/* 1722 */     if (strFieldName.equals("operator")) {
/* 1723 */       return 31;
/*      */     }
/* 1725 */     if (strFieldName.equals("makeDate")) {
/* 1726 */       return 32;
/*      */     }
/* 1728 */     if (strFieldName.equals("makeTime")) {
/* 1729 */       return 33;
/*      */     }
/* 1731 */     if (strFieldName.equals("modifyDate")) {
/* 1732 */       return 34;
/*      */     }
/* 1734 */     if (strFieldName.equals("modifyTime")) {
/* 1735 */       return 35;
/*      */     }
/* 1737 */     if (strFieldName.equals("clickRate")) {
/* 1738 */       return 36;
/*      */     }
/* 1740 */     if (strFieldName.equals("fixedTop")) {
/* 1741 */       return 37;
/*      */     }
/* 1743 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1749 */     String strFieldName = "";
/* 1750 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1752 */       strFieldName = "edorNo";
/* 1753 */       break;
/*      */     case 1:
/* 1755 */       strFieldName = "edorType";
/* 1756 */       break;
/*      */     case 2:
/* 1758 */       strFieldName = "edorCase";
/* 1759 */       break;
/*      */     case 3:
/* 1761 */       strFieldName = "operator2";
/* 1762 */       break;
/*      */     case 4:
/* 1764 */       strFieldName = "makeDate2";
/* 1765 */       break;
/*      */     case 5:
/* 1767 */       strFieldName = "makeTime2";
/* 1768 */       break;
/*      */     case 6:
/* 1770 */       strFieldName = "newsID";
/* 1771 */       break;
/*      */     case 7:
/* 1773 */       strFieldName = "manageCom";
/* 1774 */       break;
/*      */     case 8:
/* 1776 */       strFieldName = "branchType";
/* 1777 */       break;
/*      */     case 9:
/* 1779 */       strFieldName = "newsType";
/* 1780 */       break;
/*      */     case 10:
/* 1782 */       strFieldName = "title";
/* 1783 */       break;
/*      */     case 11:
/* 1785 */       strFieldName = "subhead";
/* 1786 */       break;
/*      */     case 12:
/* 1788 */       strFieldName = "brief";
/* 1789 */       break;
/*      */     case 13:
/* 1791 */       strFieldName = "author";
/* 1792 */       break;
/*      */     case 14:
/* 1794 */       strFieldName = "startDisplayDate";
/* 1795 */       break;
/*      */     case 15:
/* 1797 */       strFieldName = "endDisplayDate";
/* 1798 */       break;
/*      */     case 16:
/* 1800 */       strFieldName = "startDisplayTime";
/* 1801 */       break;
/*      */     case 17:
/* 1803 */       strFieldName = "endDisplayTime";
/* 1804 */       break;
/*      */     case 18:
/* 1806 */       strFieldName = "staticPageURL";
/* 1807 */       break;
/*      */     case 19:
/* 1809 */       strFieldName = "minDisplayGrade";
/* 1810 */       break;
/*      */     case 20:
/* 1812 */       strFieldName = "checkState";
/* 1813 */       break;
/*      */     case 21:
/* 1815 */       strFieldName = "checkOperator";
/* 1816 */       break;
/*      */     case 22:
/* 1818 */       strFieldName = "checkReason";
/* 1819 */       break;
/*      */     case 23:
/* 1821 */       strFieldName = "checkDate";
/* 1822 */       break;
/*      */     case 24:
/* 1824 */       strFieldName = "checkTime";
/* 1825 */       break;
/*      */     case 25:
/* 1827 */       strFieldName = "vF01";
/* 1828 */       break;
/*      */     case 26:
/* 1830 */       strFieldName = "nF01";
/* 1831 */       break;
/*      */     case 27:
/* 1833 */       strFieldName = "iF01";
/* 1834 */       break;
/*      */     case 28:
/* 1836 */       strFieldName = "dF02";
/* 1837 */       break;
/*      */     case 29:
/* 1839 */       strFieldName = "date01";
/* 1840 */       break;
/*      */     case 30:
/* 1842 */       strFieldName = "modifyOperator";
/* 1843 */       break;
/*      */     case 31:
/* 1845 */       strFieldName = "operator";
/* 1846 */       break;
/*      */     case 32:
/* 1848 */       strFieldName = "makeDate";
/* 1849 */       break;
/*      */     case 33:
/* 1851 */       strFieldName = "makeTime";
/* 1852 */       break;
/*      */     case 34:
/* 1854 */       strFieldName = "modifyDate";
/* 1855 */       break;
/*      */     case 35:
/* 1857 */       strFieldName = "modifyTime";
/* 1858 */       break;
/*      */     case 36:
/* 1860 */       strFieldName = "clickRate";
/* 1861 */       break;
/*      */     case 37:
/* 1863 */       strFieldName = "fixedTop";
/* 1864 */       break;
/*      */     default:
/* 1866 */       strFieldName = "";
/*      */     }
/* 1868 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1874 */     if (strFieldName.equals("edorNo")) {
/* 1875 */       return 0;
/*      */     }
/* 1877 */     if (strFieldName.equals("edorType")) {
/* 1878 */       return 0;
/*      */     }
/* 1880 */     if (strFieldName.equals("edorCase")) {
/* 1881 */       return 0;
/*      */     }
/* 1883 */     if (strFieldName.equals("operator2")) {
/* 1884 */       return 0;
/*      */     }
/* 1886 */     if (strFieldName.equals("makeDate2")) {
/* 1887 */       return 1;
/*      */     }
/* 1889 */     if (strFieldName.equals("makeTime2")) {
/* 1890 */       return 0;
/*      */     }
/* 1892 */     if (strFieldName.equals("newsID")) {
/* 1893 */       return 0;
/*      */     }
/* 1895 */     if (strFieldName.equals("manageCom")) {
/* 1896 */       return 0;
/*      */     }
/* 1898 */     if (strFieldName.equals("branchType")) {
/* 1899 */       return 0;
/*      */     }
/* 1901 */     if (strFieldName.equals("newsType")) {
/* 1902 */       return 0;
/*      */     }
/* 1904 */     if (strFieldName.equals("title")) {
/* 1905 */       return 0;
/*      */     }
/* 1907 */     if (strFieldName.equals("subhead")) {
/* 1908 */       return 0;
/*      */     }
/* 1910 */     if (strFieldName.equals("brief")) {
/* 1911 */       return 0;
/*      */     }
/* 1913 */     if (strFieldName.equals("author")) {
/* 1914 */       return 0;
/*      */     }
/* 1916 */     if (strFieldName.equals("startDisplayDate")) {
/* 1917 */       return 1;
/*      */     }
/* 1919 */     if (strFieldName.equals("endDisplayDate")) {
/* 1920 */       return 1;
/*      */     }
/* 1922 */     if (strFieldName.equals("startDisplayTime")) {
/* 1923 */       return 0;
/*      */     }
/* 1925 */     if (strFieldName.equals("endDisplayTime")) {
/* 1926 */       return 0;
/*      */     }
/* 1928 */     if (strFieldName.equals("staticPageURL")) {
/* 1929 */       return 0;
/*      */     }
/* 1931 */     if (strFieldName.equals("minDisplayGrade")) {
/* 1932 */       return 0;
/*      */     }
/* 1934 */     if (strFieldName.equals("checkState")) {
/* 1935 */       return 0;
/*      */     }
/* 1937 */     if (strFieldName.equals("checkOperator")) {
/* 1938 */       return 0;
/*      */     }
/* 1940 */     if (strFieldName.equals("checkReason")) {
/* 1941 */       return 0;
/*      */     }
/* 1943 */     if (strFieldName.equals("checkDate")) {
/* 1944 */       return 1;
/*      */     }
/* 1946 */     if (strFieldName.equals("checkTime")) {
/* 1947 */       return 0;
/*      */     }
/* 1949 */     if (strFieldName.equals("vF01")) {
/* 1950 */       return 0;
/*      */     }
/* 1952 */     if (strFieldName.equals("nF01")) {
/* 1953 */       return 0;
/*      */     }
/* 1955 */     if (strFieldName.equals("iF01")) {
/* 1956 */       return 3;
/*      */     }
/* 1958 */     if (strFieldName.equals("dF02")) {
/* 1959 */       return 4;
/*      */     }
/* 1961 */     if (strFieldName.equals("date01")) {
/* 1962 */       return 1;
/*      */     }
/* 1964 */     if (strFieldName.equals("modifyOperator")) {
/* 1965 */       return 0;
/*      */     }
/* 1967 */     if (strFieldName.equals("operator")) {
/* 1968 */       return 0;
/*      */     }
/* 1970 */     if (strFieldName.equals("makeDate")) {
/* 1971 */       return 1;
/*      */     }
/* 1973 */     if (strFieldName.equals("makeTime")) {
/* 1974 */       return 0;
/*      */     }
/* 1976 */     if (strFieldName.equals("modifyDate")) {
/* 1977 */       return 1;
/*      */     }
/* 1979 */     if (strFieldName.equals("modifyTime")) {
/* 1980 */       return 0;
/*      */     }
/* 1982 */     if (strFieldName.equals("clickRate")) {
/* 1983 */       return 3;
/*      */     }
/* 1985 */     if (strFieldName.equals("fixedTop")) {
/* 1986 */       return 3;
/*      */     }
/* 1988 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1994 */     int nFieldType = -1;
/* 1995 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1997 */       nFieldType = 0;
/* 1998 */       break;
/*      */     case 1:
/* 2000 */       nFieldType = 0;
/* 2001 */       break;
/*      */     case 2:
/* 2003 */       nFieldType = 0;
/* 2004 */       break;
/*      */     case 3:
/* 2006 */       nFieldType = 0;
/* 2007 */       break;
/*      */     case 4:
/* 2009 */       nFieldType = 1;
/* 2010 */       break;
/*      */     case 5:
/* 2012 */       nFieldType = 0;
/* 2013 */       break;
/*      */     case 6:
/* 2015 */       nFieldType = 0;
/* 2016 */       break;
/*      */     case 7:
/* 2018 */       nFieldType = 0;
/* 2019 */       break;
/*      */     case 8:
/* 2021 */       nFieldType = 0;
/* 2022 */       break;
/*      */     case 9:
/* 2024 */       nFieldType = 0;
/* 2025 */       break;
/*      */     case 10:
/* 2027 */       nFieldType = 0;
/* 2028 */       break;
/*      */     case 11:
/* 2030 */       nFieldType = 0;
/* 2031 */       break;
/*      */     case 12:
/* 2033 */       nFieldType = 0;
/* 2034 */       break;
/*      */     case 13:
/* 2036 */       nFieldType = 0;
/* 2037 */       break;
/*      */     case 14:
/* 2039 */       nFieldType = 1;
/* 2040 */       break;
/*      */     case 15:
/* 2042 */       nFieldType = 1;
/* 2043 */       break;
/*      */     case 16:
/* 2045 */       nFieldType = 0;
/* 2046 */       break;
/*      */     case 17:
/* 2048 */       nFieldType = 0;
/* 2049 */       break;
/*      */     case 18:
/* 2051 */       nFieldType = 0;
/* 2052 */       break;
/*      */     case 19:
/* 2054 */       nFieldType = 0;
/* 2055 */       break;
/*      */     case 20:
/* 2057 */       nFieldType = 0;
/* 2058 */       break;
/*      */     case 21:
/* 2060 */       nFieldType = 0;
/* 2061 */       break;
/*      */     case 22:
/* 2063 */       nFieldType = 0;
/* 2064 */       break;
/*      */     case 23:
/* 2066 */       nFieldType = 1;
/* 2067 */       break;
/*      */     case 24:
/* 2069 */       nFieldType = 0;
/* 2070 */       break;
/*      */     case 25:
/* 2072 */       nFieldType = 0;
/* 2073 */       break;
/*      */     case 26:
/* 2075 */       nFieldType = 0;
/* 2076 */       break;
/*      */     case 27:
/* 2078 */       nFieldType = 3;
/* 2079 */       break;
/*      */     case 28:
/* 2081 */       nFieldType = 4;
/* 2082 */       break;
/*      */     case 29:
/* 2084 */       nFieldType = 1;
/* 2085 */       break;
/*      */     case 30:
/* 2087 */       nFieldType = 0;
/* 2088 */       break;
/*      */     case 31:
/* 2090 */       nFieldType = 0;
/* 2091 */       break;
/*      */     case 32:
/* 2093 */       nFieldType = 1;
/* 2094 */       break;
/*      */     case 33:
/* 2096 */       nFieldType = 0;
/* 2097 */       break;
/*      */     case 34:
/* 2099 */       nFieldType = 1;
/* 2100 */       break;
/*      */     case 35:
/* 2102 */       nFieldType = 0;
/* 2103 */       break;
/*      */     case 36:
/* 2105 */       nFieldType = 3;
/* 2106 */       break;
/*      */     case 37:
/* 2108 */       nFieldType = 3;
/* 2109 */       break;
/*      */     default:
/* 2111 */       nFieldType = -1;
/*      */     }
/* 2113 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewsBSchema
 * JD-Core Version:    0.6.0
 */