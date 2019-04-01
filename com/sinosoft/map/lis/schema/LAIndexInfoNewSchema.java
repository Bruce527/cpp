/*       */ package com.sinosoft.map.lis.schema;
/*       */ 
/*       */ import com.sinosoft.map.lis.db.LAIndexInfoNewDB;
/*       */ import com.sinosoft.map.lis.pubfun.FDate;
/*       */ import com.sinosoft.map.utility.CError;
/*       */ import com.sinosoft.map.utility.CErrors;
/*       */ import com.sinosoft.map.utility.ChgData;
/*       */ import com.sinosoft.map.utility.Schema;
/*       */ import com.sinosoft.map.utility.StrTool;
/*       */ import java.io.PrintStream;
/*       */ import java.sql.ResultSet;
/*       */ import java.sql.SQLException;
/*       */ import java.util.Date;
/*       */ 
/*       */ public class LAIndexInfoNewSchema
/*       */   implements Schema, Cloneable
/*       */ {
/*       */   private String indexCalNo;
/*       */   private String indexType;
/*       */   private String manageCom;
/*       */   private String agentGroup;
/*       */   private String branchAttr;
/*       */   private String agentCode;
/*       */   private String agentGrade;
/*       */   private String agentTitle;
/*       */   private int quaBgnMark;
/*       */   private int postMonths;
/*       */   private String assessMonth;
/*       */   private String agentGrade1;
/*       */   private String agentTitle1;
/*       */   private String agentGrade2;
/*       */   private String agentTitle2;
/*       */   private String agentGrade3;
/*       */   private String agentTitle3;
/*       */   private Date startDate;
/*       */   private Date startEnd;
/*       */   private Date startDate1;
/*       */   private Date startEnd1;
/*       */   private Date startDate2;
/*       */   private Date startEnd2;
/*       */   private Date startDate3;
/*       */   private Date startEnd3;
/*       */   private Date startEnd4;
/*       */   private Date startDate4;
/*       */   private int serverMonths;
/*       */   private double nT01;
/*       */   private double nT02;
/*       */   private double nT03;
/*       */   private double nT04;
/*       */   private double nT05;
/*       */   private double nT06;
/*       */   private double nT07;
/*       */   private double nT08;
/*       */   private double nT09;
/*       */   private double nT10;
/*       */   private double nT11;
/*       */   private double nT12;
/*       */   private double nT13;
/*       */   private double nT14;
/*       */   private double nT15;
/*       */   private double nT16;
/*       */   private double nT17;
/*       */   private double nT18;
/*       */   private double nT19;
/*       */   private double nT20;
/*       */   private double nT21;
/*       */   private double nT22;
/*       */   private double nT23;
/*       */   private double nT24;
/*       */   private double nT25;
/*       */   private double nT26;
/*       */   private double nT27;
/*       */   private double nT28;
/*       */   private double nT29;
/*       */   private double nT30;
/*       */   private double nT31;
/*       */   private double nT32;
/*       */   private double nT33;
/*       */   private double nT34;
/*       */   private double nT35;
/*       */   private double nT36;
/*       */   private double nT37;
/*       */   private double nT38;
/*       */   private double nT39;
/*       */   private double nT40;
/*       */   private double nT41;
/*       */   private double nT42;
/*       */   private double nT43;
/*       */   private double nT44;
/*       */   private double nT45;
/*       */   private double nT46;
/*       */   private double nT47;
/*       */   private double nT48;
/*       */   private double nT49;
/*       */   private double nT50;
/*       */   private double nT51;
/*       */   private double nT52;
/*       */   private double nT53;
/*       */   private double nT54;
/*       */   private double nT55;
/*       */   private double nT56;
/*       */   private double nT57;
/*       */   private double nT58;
/*       */   private double nT59;
/*       */   private double nT60;
/*       */   private double nT61;
/*       */   private double nT62;
/*       */   private double nT63;
/*       */   private double nT64;
/*       */   private double nT65;
/*       */   private double nT66;
/*       */   private double nT67;
/*       */   private double nT68;
/*       */   private double nT69;
/*       */   private double nT70;
/*       */   private double nT71;
/*       */   private double nT72;
/*       */   private double nT73;
/*       */   private double nT74;
/*       */   private double nT75;
/*       */   private double nT76;
/*       */   private double nT77;
/*       */   private double nT78;
/*       */   private double nT79;
/*       */   private double nT80;
/*       */   private double nF01;
/*       */   private double nF02;
/*       */   private double nF03;
/*       */   private double nF04;
/*       */   private double nF05;
/*       */   private double nF06;
/*       */   private double nF07;
/*       */   private double nF08;
/*       */   private double nF09;
/*       */   private double nF10;
/*       */   private double nS01;
/*       */   private double nS02;
/*       */   private double nS03;
/*       */   private double nS04;
/*       */   private double nS05;
/*       */   private double nS06;
/*       */   private double nS07;
/*       */   private double nS08;
/*       */   private double nS09;
/*       */   private double nS10;
/*       */   private int iNT01;
/*       */   private int iNT02;
/*       */   private int iNT03;
/*       */   private int iNT04;
/*       */   private int iNT05;
/*       */   private int iNT06;
/*       */   private int iNT07;
/*       */   private int iNT08;
/*       */   private int iNT09;
/*       */   private int iNT10;
/*       */   private int iNT11;
/*       */   private int iNT12;
/*       */   private int iNT13;
/*       */   private int iNT14;
/*       */   private int iNT15;
/*       */   private int iNT16;
/*       */   private int iNT17;
/*       */   private int iNT18;
/*       */   private int iNT19;
/*       */   private int iNT20;
/*       */   private int iNT21;
/*       */   private int iNT22;
/*       */   private int iNT23;
/*       */   private int iNT24;
/*       */   private int iNT25;
/*       */   private String v1;
/*       */   private String v2;
/*       */   private String v3;
/*       */   private String v4;
/*       */   private String v5;
/*       */   private String v6;
/*       */   private String v7;
/*       */   private String v8;
/*       */   private String v9;
/*       */   private String v10;
/*       */   private String v11;
/*       */   private String v12;
/*       */   private String v13;
/*       */   private String v14;
/*       */   private String v15;
/*       */   private String v16;
/*       */   private String v17;
/*       */   private String v18;
/*       */   private String v19;
/*       */   private String v20;
/*       */   private String vT1;
/*       */   private String vT2;
/*       */   private String vT3;
/*       */   private String vT4;
/*       */   private String vT5;
/*       */   private String vT6;
/*       */   private String vT7;
/*       */   private String vT8;
/*       */   private String vE1;
/*       */   private String vE2;
/*       */   private String vE3;
/*       */   private String vE4;
/*       */   private String vE5;
/*       */   private String vE6;
/*       */   private String vE7;
/*       */   private String vE8;
/*       */   private String vE9;
/*       */   private String vE10;
/*       */   private Date d1;
/*       */   private Date d2;
/*       */   private Date d3;
/*       */   private Date d4;
/*       */   private Date d5;
/*       */   private Date d6;
/*       */   private Date d7;
/*       */   private Date d8;
/*       */   private Date d9;
/*       */   private Date d10;
/*       */   private String state;
/*       */   private String operator;
/*       */   private Date makeDate;
/*       */   private String makeTime;
/*       */   private Date modifyDate;
/*       */   private String modifyTime;
/*       */   public static final int FIELDNUM = 207;
/*       */   private static String[] PK;
/*   438 */   private FDate fDate = new FDate();
/*       */   public CErrors mErrors;
/*       */ 
/*       */   public LAIndexInfoNewSchema()
/*       */   {
/*   445 */     this.mErrors = new CErrors();
/*       */ 
/*   447 */     String[] pk = new String[3];
/*   448 */     pk[0] = "IndexCalNo";
/*   449 */     pk[1] = "IndexType";
/*   450 */     pk[2] = "AgentCode";
/*       */ 
/*   452 */     PK = pk;
/*       */   }
/*       */ 
/*       */   public Object clone()
/*       */     throws CloneNotSupportedException
/*       */   {
/*   459 */     LAIndexInfoNewSchema cloned = (LAIndexInfoNewSchema)super.clone();
/*   460 */     cloned.fDate = ((FDate)this.fDate.clone());
/*   461 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   462 */     return cloned;
/*       */   }
/*       */ 
/*       */   public String[] getPK()
/*       */   {
/*   468 */     return PK;
/*       */   }
/*       */ 
/*       */   public String getIndexCalNo()
/*       */   {
/*   473 */     return this.indexCalNo;
/*       */   }
/*       */ 
/*       */   public void setIndexCalNo(String aIndexCalNo) {
/*   477 */     this.indexCalNo = aIndexCalNo;
/*       */   }
/*       */ 
/*       */   public String getIndexType() {
/*   481 */     return this.indexType;
/*       */   }
/*       */ 
/*       */   public void setIndexType(String aIndexType) {
/*   485 */     this.indexType = aIndexType;
/*       */   }
/*       */ 
/*       */   public String getManageCom() {
/*   489 */     return this.manageCom;
/*       */   }
/*       */ 
/*       */   public void setManageCom(String aManageCom) {
/*   493 */     this.manageCom = aManageCom;
/*       */   }
/*       */ 
/*       */   public String getAgentGroup() {
/*   497 */     return this.agentGroup;
/*       */   }
/*       */ 
/*       */   public void setAgentGroup(String aAgentGroup) {
/*   501 */     this.agentGroup = aAgentGroup;
/*       */   }
/*       */ 
/*       */   public String getBranchAttr() {
/*   505 */     return this.branchAttr;
/*       */   }
/*       */ 
/*       */   public void setBranchAttr(String aBranchAttr) {
/*   509 */     this.branchAttr = aBranchAttr;
/*       */   }
/*       */ 
/*       */   public String getAgentCode() {
/*   513 */     return this.agentCode;
/*       */   }
/*       */ 
/*       */   public void setAgentCode(String aAgentCode) {
/*   517 */     this.agentCode = aAgentCode;
/*       */   }
/*       */ 
/*       */   public String getAgentGrade() {
/*   521 */     return this.agentGrade;
/*       */   }
/*       */ 
/*       */   public void setAgentGrade(String aAgentGrade) {
/*   525 */     this.agentGrade = aAgentGrade;
/*       */   }
/*       */ 
/*       */   public String getAgentTitle() {
/*   529 */     return this.agentTitle;
/*       */   }
/*       */ 
/*       */   public void setAgentTitle(String aAgentTitle) {
/*   533 */     this.agentTitle = aAgentTitle;
/*       */   }
/*       */ 
/*       */   public int getQuaBgnMark() {
/*   537 */     return this.quaBgnMark;
/*       */   }
/*       */ 
/*       */   public void setQuaBgnMark(int aQuaBgnMark) {
/*   541 */     this.quaBgnMark = aQuaBgnMark;
/*       */   }
/*       */ 
/*       */   public void setQuaBgnMark(String aQuaBgnMark) {
/*   545 */     if ((aQuaBgnMark != null) && (!aQuaBgnMark.equals("")))
/*       */     {
/*   547 */       Integer tInteger = new Integer(aQuaBgnMark);
/*   548 */       int i = tInteger.intValue();
/*   549 */       this.quaBgnMark = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getPostMonths()
/*       */   {
/*   555 */     return this.postMonths;
/*       */   }
/*       */ 
/*       */   public void setPostMonths(int aPostMonths) {
/*   559 */     this.postMonths = aPostMonths;
/*       */   }
/*       */ 
/*       */   public void setPostMonths(String aPostMonths) {
/*   563 */     if ((aPostMonths != null) && (!aPostMonths.equals("")))
/*       */     {
/*   565 */       Integer tInteger = new Integer(aPostMonths);
/*   566 */       int i = tInteger.intValue();
/*   567 */       this.postMonths = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public String getAssessMonth()
/*       */   {
/*   573 */     return this.assessMonth;
/*       */   }
/*       */ 
/*       */   public void setAssessMonth(String aAssessMonth) {
/*   577 */     this.assessMonth = aAssessMonth;
/*       */   }
/*       */ 
/*       */   public String getAgentGrade1() {
/*   581 */     return this.agentGrade1;
/*       */   }
/*       */ 
/*       */   public void setAgentGrade1(String aAgentGrade1) {
/*   585 */     this.agentGrade1 = aAgentGrade1;
/*       */   }
/*       */ 
/*       */   public String getAgentTitle1() {
/*   589 */     return this.agentTitle1;
/*       */   }
/*       */ 
/*       */   public void setAgentTitle1(String aAgentTitle1) {
/*   593 */     this.agentTitle1 = aAgentTitle1;
/*       */   }
/*       */ 
/*       */   public String getAgentGrade2() {
/*   597 */     return this.agentGrade2;
/*       */   }
/*       */ 
/*       */   public void setAgentGrade2(String aAgentGrade2) {
/*   601 */     this.agentGrade2 = aAgentGrade2;
/*       */   }
/*       */ 
/*       */   public String getAgentTitle2() {
/*   605 */     return this.agentTitle2;
/*       */   }
/*       */ 
/*       */   public void setAgentTitle2(String aAgentTitle2) {
/*   609 */     this.agentTitle2 = aAgentTitle2;
/*       */   }
/*       */ 
/*       */   public String getAgentGrade3() {
/*   613 */     return this.agentGrade3;
/*       */   }
/*       */ 
/*       */   public void setAgentGrade3(String aAgentGrade3) {
/*   617 */     this.agentGrade3 = aAgentGrade3;
/*       */   }
/*       */ 
/*       */   public String getAgentTitle3() {
/*   621 */     return this.agentTitle3;
/*       */   }
/*       */ 
/*       */   public void setAgentTitle3(String aAgentTitle3) {
/*   625 */     this.agentTitle3 = aAgentTitle3;
/*       */   }
/*       */ 
/*       */   public String getStartDate() {
/*   629 */     if (this.startDate != null) {
/*   630 */       return this.fDate.getString(this.startDate);
/*       */     }
/*   632 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartDate(Date aStartDate) {
/*   636 */     this.startDate = aStartDate;
/*       */   }
/*       */ 
/*       */   public void setStartDate(String aStartDate) {
/*   640 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*       */     {
/*   642 */       this.startDate = this.fDate.getDate(aStartDate);
/*       */     }
/*       */     else
/*   645 */       this.startDate = null;
/*       */   }
/*       */ 
/*       */   public String getStartEnd()
/*       */   {
/*   650 */     if (this.startEnd != null) {
/*   651 */       return this.fDate.getString(this.startEnd);
/*       */     }
/*   653 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartEnd(Date aStartEnd) {
/*   657 */     this.startEnd = aStartEnd;
/*       */   }
/*       */ 
/*       */   public void setStartEnd(String aStartEnd) {
/*   661 */     if ((aStartEnd != null) && (!aStartEnd.equals("")))
/*       */     {
/*   663 */       this.startEnd = this.fDate.getDate(aStartEnd);
/*       */     }
/*       */     else
/*   666 */       this.startEnd = null;
/*       */   }
/*       */ 
/*       */   public String getStartDate1()
/*       */   {
/*   671 */     if (this.startDate1 != null) {
/*   672 */       return this.fDate.getString(this.startDate1);
/*       */     }
/*   674 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartDate1(Date aStartDate1) {
/*   678 */     this.startDate1 = aStartDate1;
/*       */   }
/*       */ 
/*       */   public void setStartDate1(String aStartDate1) {
/*   682 */     if ((aStartDate1 != null) && (!aStartDate1.equals("")))
/*       */     {
/*   684 */       this.startDate1 = this.fDate.getDate(aStartDate1);
/*       */     }
/*       */     else
/*   687 */       this.startDate1 = null;
/*       */   }
/*       */ 
/*       */   public String getStartEnd1()
/*       */   {
/*   692 */     if (this.startEnd1 != null) {
/*   693 */       return this.fDate.getString(this.startEnd1);
/*       */     }
/*   695 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartEnd1(Date aStartEnd1) {
/*   699 */     this.startEnd1 = aStartEnd1;
/*       */   }
/*       */ 
/*       */   public void setStartEnd1(String aStartEnd1) {
/*   703 */     if ((aStartEnd1 != null) && (!aStartEnd1.equals("")))
/*       */     {
/*   705 */       this.startEnd1 = this.fDate.getDate(aStartEnd1);
/*       */     }
/*       */     else
/*   708 */       this.startEnd1 = null;
/*       */   }
/*       */ 
/*       */   public String getStartDate2()
/*       */   {
/*   713 */     if (this.startDate2 != null) {
/*   714 */       return this.fDate.getString(this.startDate2);
/*       */     }
/*   716 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartDate2(Date aStartDate2) {
/*   720 */     this.startDate2 = aStartDate2;
/*       */   }
/*       */ 
/*       */   public void setStartDate2(String aStartDate2) {
/*   724 */     if ((aStartDate2 != null) && (!aStartDate2.equals("")))
/*       */     {
/*   726 */       this.startDate2 = this.fDate.getDate(aStartDate2);
/*       */     }
/*       */     else
/*   729 */       this.startDate2 = null;
/*       */   }
/*       */ 
/*       */   public String getStartEnd2()
/*       */   {
/*   734 */     if (this.startEnd2 != null) {
/*   735 */       return this.fDate.getString(this.startEnd2);
/*       */     }
/*   737 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartEnd2(Date aStartEnd2) {
/*   741 */     this.startEnd2 = aStartEnd2;
/*       */   }
/*       */ 
/*       */   public void setStartEnd2(String aStartEnd2) {
/*   745 */     if ((aStartEnd2 != null) && (!aStartEnd2.equals("")))
/*       */     {
/*   747 */       this.startEnd2 = this.fDate.getDate(aStartEnd2);
/*       */     }
/*       */     else
/*   750 */       this.startEnd2 = null;
/*       */   }
/*       */ 
/*       */   public String getStartDate3()
/*       */   {
/*   755 */     if (this.startDate3 != null) {
/*   756 */       return this.fDate.getString(this.startDate3);
/*       */     }
/*   758 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartDate3(Date aStartDate3) {
/*   762 */     this.startDate3 = aStartDate3;
/*       */   }
/*       */ 
/*       */   public void setStartDate3(String aStartDate3) {
/*   766 */     if ((aStartDate3 != null) && (!aStartDate3.equals("")))
/*       */     {
/*   768 */       this.startDate3 = this.fDate.getDate(aStartDate3);
/*       */     }
/*       */     else
/*   771 */       this.startDate3 = null;
/*       */   }
/*       */ 
/*       */   public String getStartEnd3()
/*       */   {
/*   776 */     if (this.startEnd3 != null) {
/*   777 */       return this.fDate.getString(this.startEnd3);
/*       */     }
/*   779 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartEnd3(Date aStartEnd3) {
/*   783 */     this.startEnd3 = aStartEnd3;
/*       */   }
/*       */ 
/*       */   public void setStartEnd3(String aStartEnd3) {
/*   787 */     if ((aStartEnd3 != null) && (!aStartEnd3.equals("")))
/*       */     {
/*   789 */       this.startEnd3 = this.fDate.getDate(aStartEnd3);
/*       */     }
/*       */     else
/*   792 */       this.startEnd3 = null;
/*       */   }
/*       */ 
/*       */   public String getStartEnd4()
/*       */   {
/*   797 */     if (this.startEnd4 != null) {
/*   798 */       return this.fDate.getString(this.startEnd4);
/*       */     }
/*   800 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartEnd4(Date aStartEnd4) {
/*   804 */     this.startEnd4 = aStartEnd4;
/*       */   }
/*       */ 
/*       */   public void setStartEnd4(String aStartEnd4) {
/*   808 */     if ((aStartEnd4 != null) && (!aStartEnd4.equals("")))
/*       */     {
/*   810 */       this.startEnd4 = this.fDate.getDate(aStartEnd4);
/*       */     }
/*       */     else
/*   813 */       this.startEnd4 = null;
/*       */   }
/*       */ 
/*       */   public String getStartDate4()
/*       */   {
/*   818 */     if (this.startDate4 != null) {
/*   819 */       return this.fDate.getString(this.startDate4);
/*       */     }
/*   821 */     return null;
/*       */   }
/*       */ 
/*       */   public void setStartDate4(Date aStartDate4) {
/*   825 */     this.startDate4 = aStartDate4;
/*       */   }
/*       */ 
/*       */   public void setStartDate4(String aStartDate4) {
/*   829 */     if ((aStartDate4 != null) && (!aStartDate4.equals("")))
/*       */     {
/*   831 */       this.startDate4 = this.fDate.getDate(aStartDate4);
/*       */     }
/*       */     else
/*   834 */       this.startDate4 = null;
/*       */   }
/*       */ 
/*       */   public int getServerMonths()
/*       */   {
/*   839 */     return this.serverMonths;
/*       */   }
/*       */ 
/*       */   public void setServerMonths(int aServerMonths) {
/*   843 */     this.serverMonths = aServerMonths;
/*       */   }
/*       */ 
/*       */   public void setServerMonths(String aServerMonths) {
/*   847 */     if ((aServerMonths != null) && (!aServerMonths.equals("")))
/*       */     {
/*   849 */       Integer tInteger = new Integer(aServerMonths);
/*   850 */       int i = tInteger.intValue();
/*   851 */       this.serverMonths = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT01()
/*       */   {
/*   857 */     return this.nT01;
/*       */   }
/*       */ 
/*       */   public void setNT01(double aNT01) {
/*   861 */     this.nT01 = aNT01;
/*       */   }
/*       */ 
/*       */   public void setNT01(String aNT01) {
/*   865 */     if ((aNT01 != null) && (!aNT01.equals("")))
/*       */     {
/*   867 */       Double tDouble = new Double(aNT01);
/*   868 */       double d = tDouble.doubleValue();
/*   869 */       this.nT01 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT02()
/*       */   {
/*   875 */     return this.nT02;
/*       */   }
/*       */ 
/*       */   public void setNT02(double aNT02) {
/*   879 */     this.nT02 = aNT02;
/*       */   }
/*       */ 
/*       */   public void setNT02(String aNT02) {
/*   883 */     if ((aNT02 != null) && (!aNT02.equals("")))
/*       */     {
/*   885 */       Double tDouble = new Double(aNT02);
/*   886 */       double d = tDouble.doubleValue();
/*   887 */       this.nT02 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT03()
/*       */   {
/*   893 */     return this.nT03;
/*       */   }
/*       */ 
/*       */   public void setNT03(double aNT03) {
/*   897 */     this.nT03 = aNT03;
/*       */   }
/*       */ 
/*       */   public void setNT03(String aNT03) {
/*   901 */     if ((aNT03 != null) && (!aNT03.equals("")))
/*       */     {
/*   903 */       Double tDouble = new Double(aNT03);
/*   904 */       double d = tDouble.doubleValue();
/*   905 */       this.nT03 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT04()
/*       */   {
/*   911 */     return this.nT04;
/*       */   }
/*       */ 
/*       */   public void setNT04(double aNT04) {
/*   915 */     this.nT04 = aNT04;
/*       */   }
/*       */ 
/*       */   public void setNT04(String aNT04) {
/*   919 */     if ((aNT04 != null) && (!aNT04.equals("")))
/*       */     {
/*   921 */       Double tDouble = new Double(aNT04);
/*   922 */       double d = tDouble.doubleValue();
/*   923 */       this.nT04 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT05()
/*       */   {
/*   929 */     return this.nT05;
/*       */   }
/*       */ 
/*       */   public void setNT05(double aNT05) {
/*   933 */     this.nT05 = aNT05;
/*       */   }
/*       */ 
/*       */   public void setNT05(String aNT05) {
/*   937 */     if ((aNT05 != null) && (!aNT05.equals("")))
/*       */     {
/*   939 */       Double tDouble = new Double(aNT05);
/*   940 */       double d = tDouble.doubleValue();
/*   941 */       this.nT05 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT06()
/*       */   {
/*   947 */     return this.nT06;
/*       */   }
/*       */ 
/*       */   public void setNT06(double aNT06) {
/*   951 */     this.nT06 = aNT06;
/*       */   }
/*       */ 
/*       */   public void setNT06(String aNT06) {
/*   955 */     if ((aNT06 != null) && (!aNT06.equals("")))
/*       */     {
/*   957 */       Double tDouble = new Double(aNT06);
/*   958 */       double d = tDouble.doubleValue();
/*   959 */       this.nT06 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT07()
/*       */   {
/*   965 */     return this.nT07;
/*       */   }
/*       */ 
/*       */   public void setNT07(double aNT07) {
/*   969 */     this.nT07 = aNT07;
/*       */   }
/*       */ 
/*       */   public void setNT07(String aNT07) {
/*   973 */     if ((aNT07 != null) && (!aNT07.equals("")))
/*       */     {
/*   975 */       Double tDouble = new Double(aNT07);
/*   976 */       double d = tDouble.doubleValue();
/*   977 */       this.nT07 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT08()
/*       */   {
/*   983 */     return this.nT08;
/*       */   }
/*       */ 
/*       */   public void setNT08(double aNT08) {
/*   987 */     this.nT08 = aNT08;
/*       */   }
/*       */ 
/*       */   public void setNT08(String aNT08) {
/*   991 */     if ((aNT08 != null) && (!aNT08.equals("")))
/*       */     {
/*   993 */       Double tDouble = new Double(aNT08);
/*   994 */       double d = tDouble.doubleValue();
/*   995 */       this.nT08 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT09()
/*       */   {
/*  1001 */     return this.nT09;
/*       */   }
/*       */ 
/*       */   public void setNT09(double aNT09) {
/*  1005 */     this.nT09 = aNT09;
/*       */   }
/*       */ 
/*       */   public void setNT09(String aNT09) {
/*  1009 */     if ((aNT09 != null) && (!aNT09.equals("")))
/*       */     {
/*  1011 */       Double tDouble = new Double(aNT09);
/*  1012 */       double d = tDouble.doubleValue();
/*  1013 */       this.nT09 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT10()
/*       */   {
/*  1019 */     return this.nT10;
/*       */   }
/*       */ 
/*       */   public void setNT10(double aNT10) {
/*  1023 */     this.nT10 = aNT10;
/*       */   }
/*       */ 
/*       */   public void setNT10(String aNT10) {
/*  1027 */     if ((aNT10 != null) && (!aNT10.equals("")))
/*       */     {
/*  1029 */       Double tDouble = new Double(aNT10);
/*  1030 */       double d = tDouble.doubleValue();
/*  1031 */       this.nT10 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT11()
/*       */   {
/*  1037 */     return this.nT11;
/*       */   }
/*       */ 
/*       */   public void setNT11(double aNT11) {
/*  1041 */     this.nT11 = aNT11;
/*       */   }
/*       */ 
/*       */   public void setNT11(String aNT11) {
/*  1045 */     if ((aNT11 != null) && (!aNT11.equals("")))
/*       */     {
/*  1047 */       Double tDouble = new Double(aNT11);
/*  1048 */       double d = tDouble.doubleValue();
/*  1049 */       this.nT11 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT12()
/*       */   {
/*  1055 */     return this.nT12;
/*       */   }
/*       */ 
/*       */   public void setNT12(double aNT12) {
/*  1059 */     this.nT12 = aNT12;
/*       */   }
/*       */ 
/*       */   public void setNT12(String aNT12) {
/*  1063 */     if ((aNT12 != null) && (!aNT12.equals("")))
/*       */     {
/*  1065 */       Double tDouble = new Double(aNT12);
/*  1066 */       double d = tDouble.doubleValue();
/*  1067 */       this.nT12 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT13()
/*       */   {
/*  1073 */     return this.nT13;
/*       */   }
/*       */ 
/*       */   public void setNT13(double aNT13) {
/*  1077 */     this.nT13 = aNT13;
/*       */   }
/*       */ 
/*       */   public void setNT13(String aNT13) {
/*  1081 */     if ((aNT13 != null) && (!aNT13.equals("")))
/*       */     {
/*  1083 */       Double tDouble = new Double(aNT13);
/*  1084 */       double d = tDouble.doubleValue();
/*  1085 */       this.nT13 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT14()
/*       */   {
/*  1091 */     return this.nT14;
/*       */   }
/*       */ 
/*       */   public void setNT14(double aNT14) {
/*  1095 */     this.nT14 = aNT14;
/*       */   }
/*       */ 
/*       */   public void setNT14(String aNT14) {
/*  1099 */     if ((aNT14 != null) && (!aNT14.equals("")))
/*       */     {
/*  1101 */       Double tDouble = new Double(aNT14);
/*  1102 */       double d = tDouble.doubleValue();
/*  1103 */       this.nT14 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT15()
/*       */   {
/*  1109 */     return this.nT15;
/*       */   }
/*       */ 
/*       */   public void setNT15(double aNT15) {
/*  1113 */     this.nT15 = aNT15;
/*       */   }
/*       */ 
/*       */   public void setNT15(String aNT15) {
/*  1117 */     if ((aNT15 != null) && (!aNT15.equals("")))
/*       */     {
/*  1119 */       Double tDouble = new Double(aNT15);
/*  1120 */       double d = tDouble.doubleValue();
/*  1121 */       this.nT15 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT16()
/*       */   {
/*  1127 */     return this.nT16;
/*       */   }
/*       */ 
/*       */   public void setNT16(double aNT16) {
/*  1131 */     this.nT16 = aNT16;
/*       */   }
/*       */ 
/*       */   public void setNT16(String aNT16) {
/*  1135 */     if ((aNT16 != null) && (!aNT16.equals("")))
/*       */     {
/*  1137 */       Double tDouble = new Double(aNT16);
/*  1138 */       double d = tDouble.doubleValue();
/*  1139 */       this.nT16 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT17()
/*       */   {
/*  1145 */     return this.nT17;
/*       */   }
/*       */ 
/*       */   public void setNT17(double aNT17) {
/*  1149 */     this.nT17 = aNT17;
/*       */   }
/*       */ 
/*       */   public void setNT17(String aNT17) {
/*  1153 */     if ((aNT17 != null) && (!aNT17.equals("")))
/*       */     {
/*  1155 */       Double tDouble = new Double(aNT17);
/*  1156 */       double d = tDouble.doubleValue();
/*  1157 */       this.nT17 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT18()
/*       */   {
/*  1163 */     return this.nT18;
/*       */   }
/*       */ 
/*       */   public void setNT18(double aNT18) {
/*  1167 */     this.nT18 = aNT18;
/*       */   }
/*       */ 
/*       */   public void setNT18(String aNT18) {
/*  1171 */     if ((aNT18 != null) && (!aNT18.equals("")))
/*       */     {
/*  1173 */       Double tDouble = new Double(aNT18);
/*  1174 */       double d = tDouble.doubleValue();
/*  1175 */       this.nT18 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT19()
/*       */   {
/*  1181 */     return this.nT19;
/*       */   }
/*       */ 
/*       */   public void setNT19(double aNT19) {
/*  1185 */     this.nT19 = aNT19;
/*       */   }
/*       */ 
/*       */   public void setNT19(String aNT19) {
/*  1189 */     if ((aNT19 != null) && (!aNT19.equals("")))
/*       */     {
/*  1191 */       Double tDouble = new Double(aNT19);
/*  1192 */       double d = tDouble.doubleValue();
/*  1193 */       this.nT19 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT20()
/*       */   {
/*  1199 */     return this.nT20;
/*       */   }
/*       */ 
/*       */   public void setNT20(double aNT20) {
/*  1203 */     this.nT20 = aNT20;
/*       */   }
/*       */ 
/*       */   public void setNT20(String aNT20) {
/*  1207 */     if ((aNT20 != null) && (!aNT20.equals("")))
/*       */     {
/*  1209 */       Double tDouble = new Double(aNT20);
/*  1210 */       double d = tDouble.doubleValue();
/*  1211 */       this.nT20 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT21()
/*       */   {
/*  1217 */     return this.nT21;
/*       */   }
/*       */ 
/*       */   public void setNT21(double aNT21) {
/*  1221 */     this.nT21 = aNT21;
/*       */   }
/*       */ 
/*       */   public void setNT21(String aNT21) {
/*  1225 */     if ((aNT21 != null) && (!aNT21.equals("")))
/*       */     {
/*  1227 */       Double tDouble = new Double(aNT21);
/*  1228 */       double d = tDouble.doubleValue();
/*  1229 */       this.nT21 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT22()
/*       */   {
/*  1235 */     return this.nT22;
/*       */   }
/*       */ 
/*       */   public void setNT22(double aNT22) {
/*  1239 */     this.nT22 = aNT22;
/*       */   }
/*       */ 
/*       */   public void setNT22(String aNT22) {
/*  1243 */     if ((aNT22 != null) && (!aNT22.equals("")))
/*       */     {
/*  1245 */       Double tDouble = new Double(aNT22);
/*  1246 */       double d = tDouble.doubleValue();
/*  1247 */       this.nT22 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT23()
/*       */   {
/*  1253 */     return this.nT23;
/*       */   }
/*       */ 
/*       */   public void setNT23(double aNT23) {
/*  1257 */     this.nT23 = aNT23;
/*       */   }
/*       */ 
/*       */   public void setNT23(String aNT23) {
/*  1261 */     if ((aNT23 != null) && (!aNT23.equals("")))
/*       */     {
/*  1263 */       Double tDouble = new Double(aNT23);
/*  1264 */       double d = tDouble.doubleValue();
/*  1265 */       this.nT23 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT24()
/*       */   {
/*  1271 */     return this.nT24;
/*       */   }
/*       */ 
/*       */   public void setNT24(double aNT24) {
/*  1275 */     this.nT24 = aNT24;
/*       */   }
/*       */ 
/*       */   public void setNT24(String aNT24) {
/*  1279 */     if ((aNT24 != null) && (!aNT24.equals("")))
/*       */     {
/*  1281 */       Double tDouble = new Double(aNT24);
/*  1282 */       double d = tDouble.doubleValue();
/*  1283 */       this.nT24 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT25()
/*       */   {
/*  1289 */     return this.nT25;
/*       */   }
/*       */ 
/*       */   public void setNT25(double aNT25) {
/*  1293 */     this.nT25 = aNT25;
/*       */   }
/*       */ 
/*       */   public void setNT25(String aNT25) {
/*  1297 */     if ((aNT25 != null) && (!aNT25.equals("")))
/*       */     {
/*  1299 */       Double tDouble = new Double(aNT25);
/*  1300 */       double d = tDouble.doubleValue();
/*  1301 */       this.nT25 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT26()
/*       */   {
/*  1307 */     return this.nT26;
/*       */   }
/*       */ 
/*       */   public void setNT26(double aNT26) {
/*  1311 */     this.nT26 = aNT26;
/*       */   }
/*       */ 
/*       */   public void setNT26(String aNT26) {
/*  1315 */     if ((aNT26 != null) && (!aNT26.equals("")))
/*       */     {
/*  1317 */       Double tDouble = new Double(aNT26);
/*  1318 */       double d = tDouble.doubleValue();
/*  1319 */       this.nT26 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT27()
/*       */   {
/*  1325 */     return this.nT27;
/*       */   }
/*       */ 
/*       */   public void setNT27(double aNT27) {
/*  1329 */     this.nT27 = aNT27;
/*       */   }
/*       */ 
/*       */   public void setNT27(String aNT27) {
/*  1333 */     if ((aNT27 != null) && (!aNT27.equals("")))
/*       */     {
/*  1335 */       Double tDouble = new Double(aNT27);
/*  1336 */       double d = tDouble.doubleValue();
/*  1337 */       this.nT27 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT28()
/*       */   {
/*  1343 */     return this.nT28;
/*       */   }
/*       */ 
/*       */   public void setNT28(double aNT28) {
/*  1347 */     this.nT28 = aNT28;
/*       */   }
/*       */ 
/*       */   public void setNT28(String aNT28) {
/*  1351 */     if ((aNT28 != null) && (!aNT28.equals("")))
/*       */     {
/*  1353 */       Double tDouble = new Double(aNT28);
/*  1354 */       double d = tDouble.doubleValue();
/*  1355 */       this.nT28 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT29()
/*       */   {
/*  1361 */     return this.nT29;
/*       */   }
/*       */ 
/*       */   public void setNT29(double aNT29) {
/*  1365 */     this.nT29 = aNT29;
/*       */   }
/*       */ 
/*       */   public void setNT29(String aNT29) {
/*  1369 */     if ((aNT29 != null) && (!aNT29.equals("")))
/*       */     {
/*  1371 */       Double tDouble = new Double(aNT29);
/*  1372 */       double d = tDouble.doubleValue();
/*  1373 */       this.nT29 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT30()
/*       */   {
/*  1379 */     return this.nT30;
/*       */   }
/*       */ 
/*       */   public void setNT30(double aNT30) {
/*  1383 */     this.nT30 = aNT30;
/*       */   }
/*       */ 
/*       */   public void setNT30(String aNT30) {
/*  1387 */     if ((aNT30 != null) && (!aNT30.equals("")))
/*       */     {
/*  1389 */       Double tDouble = new Double(aNT30);
/*  1390 */       double d = tDouble.doubleValue();
/*  1391 */       this.nT30 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT31()
/*       */   {
/*  1397 */     return this.nT31;
/*       */   }
/*       */ 
/*       */   public void setNT31(double aNT31) {
/*  1401 */     this.nT31 = aNT31;
/*       */   }
/*       */ 
/*       */   public void setNT31(String aNT31) {
/*  1405 */     if ((aNT31 != null) && (!aNT31.equals("")))
/*       */     {
/*  1407 */       Double tDouble = new Double(aNT31);
/*  1408 */       double d = tDouble.doubleValue();
/*  1409 */       this.nT31 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT32()
/*       */   {
/*  1415 */     return this.nT32;
/*       */   }
/*       */ 
/*       */   public void setNT32(double aNT32) {
/*  1419 */     this.nT32 = aNT32;
/*       */   }
/*       */ 
/*       */   public void setNT32(String aNT32) {
/*  1423 */     if ((aNT32 != null) && (!aNT32.equals("")))
/*       */     {
/*  1425 */       Double tDouble = new Double(aNT32);
/*  1426 */       double d = tDouble.doubleValue();
/*  1427 */       this.nT32 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT33()
/*       */   {
/*  1433 */     return this.nT33;
/*       */   }
/*       */ 
/*       */   public void setNT33(double aNT33) {
/*  1437 */     this.nT33 = aNT33;
/*       */   }
/*       */ 
/*       */   public void setNT33(String aNT33) {
/*  1441 */     if ((aNT33 != null) && (!aNT33.equals("")))
/*       */     {
/*  1443 */       Double tDouble = new Double(aNT33);
/*  1444 */       double d = tDouble.doubleValue();
/*  1445 */       this.nT33 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT34()
/*       */   {
/*  1451 */     return this.nT34;
/*       */   }
/*       */ 
/*       */   public void setNT34(double aNT34) {
/*  1455 */     this.nT34 = aNT34;
/*       */   }
/*       */ 
/*       */   public void setNT34(String aNT34) {
/*  1459 */     if ((aNT34 != null) && (!aNT34.equals("")))
/*       */     {
/*  1461 */       Double tDouble = new Double(aNT34);
/*  1462 */       double d = tDouble.doubleValue();
/*  1463 */       this.nT34 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT35()
/*       */   {
/*  1469 */     return this.nT35;
/*       */   }
/*       */ 
/*       */   public void setNT35(double aNT35) {
/*  1473 */     this.nT35 = aNT35;
/*       */   }
/*       */ 
/*       */   public void setNT35(String aNT35) {
/*  1477 */     if ((aNT35 != null) && (!aNT35.equals("")))
/*       */     {
/*  1479 */       Double tDouble = new Double(aNT35);
/*  1480 */       double d = tDouble.doubleValue();
/*  1481 */       this.nT35 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT36()
/*       */   {
/*  1487 */     return this.nT36;
/*       */   }
/*       */ 
/*       */   public void setNT36(double aNT36) {
/*  1491 */     this.nT36 = aNT36;
/*       */   }
/*       */ 
/*       */   public void setNT36(String aNT36) {
/*  1495 */     if ((aNT36 != null) && (!aNT36.equals("")))
/*       */     {
/*  1497 */       Double tDouble = new Double(aNT36);
/*  1498 */       double d = tDouble.doubleValue();
/*  1499 */       this.nT36 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT37()
/*       */   {
/*  1505 */     return this.nT37;
/*       */   }
/*       */ 
/*       */   public void setNT37(double aNT37) {
/*  1509 */     this.nT37 = aNT37;
/*       */   }
/*       */ 
/*       */   public void setNT37(String aNT37) {
/*  1513 */     if ((aNT37 != null) && (!aNT37.equals("")))
/*       */     {
/*  1515 */       Double tDouble = new Double(aNT37);
/*  1516 */       double d = tDouble.doubleValue();
/*  1517 */       this.nT37 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT38()
/*       */   {
/*  1523 */     return this.nT38;
/*       */   }
/*       */ 
/*       */   public void setNT38(double aNT38) {
/*  1527 */     this.nT38 = aNT38;
/*       */   }
/*       */ 
/*       */   public void setNT38(String aNT38) {
/*  1531 */     if ((aNT38 != null) && (!aNT38.equals("")))
/*       */     {
/*  1533 */       Double tDouble = new Double(aNT38);
/*  1534 */       double d = tDouble.doubleValue();
/*  1535 */       this.nT38 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT39()
/*       */   {
/*  1541 */     return this.nT39;
/*       */   }
/*       */ 
/*       */   public void setNT39(double aNT39) {
/*  1545 */     this.nT39 = aNT39;
/*       */   }
/*       */ 
/*       */   public void setNT39(String aNT39) {
/*  1549 */     if ((aNT39 != null) && (!aNT39.equals("")))
/*       */     {
/*  1551 */       Double tDouble = new Double(aNT39);
/*  1552 */       double d = tDouble.doubleValue();
/*  1553 */       this.nT39 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT40()
/*       */   {
/*  1559 */     return this.nT40;
/*       */   }
/*       */ 
/*       */   public void setNT40(double aNT40) {
/*  1563 */     this.nT40 = aNT40;
/*       */   }
/*       */ 
/*       */   public void setNT40(String aNT40) {
/*  1567 */     if ((aNT40 != null) && (!aNT40.equals("")))
/*       */     {
/*  1569 */       Double tDouble = new Double(aNT40);
/*  1570 */       double d = tDouble.doubleValue();
/*  1571 */       this.nT40 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT41()
/*       */   {
/*  1577 */     return this.nT41;
/*       */   }
/*       */ 
/*       */   public void setNT41(double aNT41) {
/*  1581 */     this.nT41 = aNT41;
/*       */   }
/*       */ 
/*       */   public void setNT41(String aNT41) {
/*  1585 */     if ((aNT41 != null) && (!aNT41.equals("")))
/*       */     {
/*  1587 */       Double tDouble = new Double(aNT41);
/*  1588 */       double d = tDouble.doubleValue();
/*  1589 */       this.nT41 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT42()
/*       */   {
/*  1595 */     return this.nT42;
/*       */   }
/*       */ 
/*       */   public void setNT42(double aNT42) {
/*  1599 */     this.nT42 = aNT42;
/*       */   }
/*       */ 
/*       */   public void setNT42(String aNT42) {
/*  1603 */     if ((aNT42 != null) && (!aNT42.equals("")))
/*       */     {
/*  1605 */       Double tDouble = new Double(aNT42);
/*  1606 */       double d = tDouble.doubleValue();
/*  1607 */       this.nT42 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT43()
/*       */   {
/*  1613 */     return this.nT43;
/*       */   }
/*       */ 
/*       */   public void setNT43(double aNT43) {
/*  1617 */     this.nT43 = aNT43;
/*       */   }
/*       */ 
/*       */   public void setNT43(String aNT43) {
/*  1621 */     if ((aNT43 != null) && (!aNT43.equals("")))
/*       */     {
/*  1623 */       Double tDouble = new Double(aNT43);
/*  1624 */       double d = tDouble.doubleValue();
/*  1625 */       this.nT43 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT44()
/*       */   {
/*  1631 */     return this.nT44;
/*       */   }
/*       */ 
/*       */   public void setNT44(double aNT44) {
/*  1635 */     this.nT44 = aNT44;
/*       */   }
/*       */ 
/*       */   public void setNT44(String aNT44) {
/*  1639 */     if ((aNT44 != null) && (!aNT44.equals("")))
/*       */     {
/*  1641 */       Double tDouble = new Double(aNT44);
/*  1642 */       double d = tDouble.doubleValue();
/*  1643 */       this.nT44 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT45()
/*       */   {
/*  1649 */     return this.nT45;
/*       */   }
/*       */ 
/*       */   public void setNT45(double aNT45) {
/*  1653 */     this.nT45 = aNT45;
/*       */   }
/*       */ 
/*       */   public void setNT45(String aNT45) {
/*  1657 */     if ((aNT45 != null) && (!aNT45.equals("")))
/*       */     {
/*  1659 */       Double tDouble = new Double(aNT45);
/*  1660 */       double d = tDouble.doubleValue();
/*  1661 */       this.nT45 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT46()
/*       */   {
/*  1667 */     return this.nT46;
/*       */   }
/*       */ 
/*       */   public void setNT46(double aNT46) {
/*  1671 */     this.nT46 = aNT46;
/*       */   }
/*       */ 
/*       */   public void setNT46(String aNT46) {
/*  1675 */     if ((aNT46 != null) && (!aNT46.equals("")))
/*       */     {
/*  1677 */       Double tDouble = new Double(aNT46);
/*  1678 */       double d = tDouble.doubleValue();
/*  1679 */       this.nT46 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT47()
/*       */   {
/*  1685 */     return this.nT47;
/*       */   }
/*       */ 
/*       */   public void setNT47(double aNT47) {
/*  1689 */     this.nT47 = aNT47;
/*       */   }
/*       */ 
/*       */   public void setNT47(String aNT47) {
/*  1693 */     if ((aNT47 != null) && (!aNT47.equals("")))
/*       */     {
/*  1695 */       Double tDouble = new Double(aNT47);
/*  1696 */       double d = tDouble.doubleValue();
/*  1697 */       this.nT47 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT48()
/*       */   {
/*  1703 */     return this.nT48;
/*       */   }
/*       */ 
/*       */   public void setNT48(double aNT48) {
/*  1707 */     this.nT48 = aNT48;
/*       */   }
/*       */ 
/*       */   public void setNT48(String aNT48) {
/*  1711 */     if ((aNT48 != null) && (!aNT48.equals("")))
/*       */     {
/*  1713 */       Double tDouble = new Double(aNT48);
/*  1714 */       double d = tDouble.doubleValue();
/*  1715 */       this.nT48 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT49()
/*       */   {
/*  1721 */     return this.nT49;
/*       */   }
/*       */ 
/*       */   public void setNT49(double aNT49) {
/*  1725 */     this.nT49 = aNT49;
/*       */   }
/*       */ 
/*       */   public void setNT49(String aNT49) {
/*  1729 */     if ((aNT49 != null) && (!aNT49.equals("")))
/*       */     {
/*  1731 */       Double tDouble = new Double(aNT49);
/*  1732 */       double d = tDouble.doubleValue();
/*  1733 */       this.nT49 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT50()
/*       */   {
/*  1739 */     return this.nT50;
/*       */   }
/*       */ 
/*       */   public void setNT50(double aNT50) {
/*  1743 */     this.nT50 = aNT50;
/*       */   }
/*       */ 
/*       */   public void setNT50(String aNT50) {
/*  1747 */     if ((aNT50 != null) && (!aNT50.equals("")))
/*       */     {
/*  1749 */       Double tDouble = new Double(aNT50);
/*  1750 */       double d = tDouble.doubleValue();
/*  1751 */       this.nT50 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT51()
/*       */   {
/*  1757 */     return this.nT51;
/*       */   }
/*       */ 
/*       */   public void setNT51(double aNT51) {
/*  1761 */     this.nT51 = aNT51;
/*       */   }
/*       */ 
/*       */   public void setNT51(String aNT51) {
/*  1765 */     if ((aNT51 != null) && (!aNT51.equals("")))
/*       */     {
/*  1767 */       Double tDouble = new Double(aNT51);
/*  1768 */       double d = tDouble.doubleValue();
/*  1769 */       this.nT51 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT52()
/*       */   {
/*  1775 */     return this.nT52;
/*       */   }
/*       */ 
/*       */   public void setNT52(double aNT52) {
/*  1779 */     this.nT52 = aNT52;
/*       */   }
/*       */ 
/*       */   public void setNT52(String aNT52) {
/*  1783 */     if ((aNT52 != null) && (!aNT52.equals("")))
/*       */     {
/*  1785 */       Double tDouble = new Double(aNT52);
/*  1786 */       double d = tDouble.doubleValue();
/*  1787 */       this.nT52 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT53()
/*       */   {
/*  1793 */     return this.nT53;
/*       */   }
/*       */ 
/*       */   public void setNT53(double aNT53) {
/*  1797 */     this.nT53 = aNT53;
/*       */   }
/*       */ 
/*       */   public void setNT53(String aNT53) {
/*  1801 */     if ((aNT53 != null) && (!aNT53.equals("")))
/*       */     {
/*  1803 */       Double tDouble = new Double(aNT53);
/*  1804 */       double d = tDouble.doubleValue();
/*  1805 */       this.nT53 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT54()
/*       */   {
/*  1811 */     return this.nT54;
/*       */   }
/*       */ 
/*       */   public void setNT54(double aNT54) {
/*  1815 */     this.nT54 = aNT54;
/*       */   }
/*       */ 
/*       */   public void setNT54(String aNT54) {
/*  1819 */     if ((aNT54 != null) && (!aNT54.equals("")))
/*       */     {
/*  1821 */       Double tDouble = new Double(aNT54);
/*  1822 */       double d = tDouble.doubleValue();
/*  1823 */       this.nT54 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT55()
/*       */   {
/*  1829 */     return this.nT55;
/*       */   }
/*       */ 
/*       */   public void setNT55(double aNT55) {
/*  1833 */     this.nT55 = aNT55;
/*       */   }
/*       */ 
/*       */   public void setNT55(String aNT55) {
/*  1837 */     if ((aNT55 != null) && (!aNT55.equals("")))
/*       */     {
/*  1839 */       Double tDouble = new Double(aNT55);
/*  1840 */       double d = tDouble.doubleValue();
/*  1841 */       this.nT55 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT56()
/*       */   {
/*  1847 */     return this.nT56;
/*       */   }
/*       */ 
/*       */   public void setNT56(double aNT56) {
/*  1851 */     this.nT56 = aNT56;
/*       */   }
/*       */ 
/*       */   public void setNT56(String aNT56) {
/*  1855 */     if ((aNT56 != null) && (!aNT56.equals("")))
/*       */     {
/*  1857 */       Double tDouble = new Double(aNT56);
/*  1858 */       double d = tDouble.doubleValue();
/*  1859 */       this.nT56 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT57()
/*       */   {
/*  1865 */     return this.nT57;
/*       */   }
/*       */ 
/*       */   public void setNT57(double aNT57) {
/*  1869 */     this.nT57 = aNT57;
/*       */   }
/*       */ 
/*       */   public void setNT57(String aNT57) {
/*  1873 */     if ((aNT57 != null) && (!aNT57.equals("")))
/*       */     {
/*  1875 */       Double tDouble = new Double(aNT57);
/*  1876 */       double d = tDouble.doubleValue();
/*  1877 */       this.nT57 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT58()
/*       */   {
/*  1883 */     return this.nT58;
/*       */   }
/*       */ 
/*       */   public void setNT58(double aNT58) {
/*  1887 */     this.nT58 = aNT58;
/*       */   }
/*       */ 
/*       */   public void setNT58(String aNT58) {
/*  1891 */     if ((aNT58 != null) && (!aNT58.equals("")))
/*       */     {
/*  1893 */       Double tDouble = new Double(aNT58);
/*  1894 */       double d = tDouble.doubleValue();
/*  1895 */       this.nT58 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT59()
/*       */   {
/*  1901 */     return this.nT59;
/*       */   }
/*       */ 
/*       */   public void setNT59(double aNT59) {
/*  1905 */     this.nT59 = aNT59;
/*       */   }
/*       */ 
/*       */   public void setNT59(String aNT59) {
/*  1909 */     if ((aNT59 != null) && (!aNT59.equals("")))
/*       */     {
/*  1911 */       Double tDouble = new Double(aNT59);
/*  1912 */       double d = tDouble.doubleValue();
/*  1913 */       this.nT59 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT60()
/*       */   {
/*  1919 */     return this.nT60;
/*       */   }
/*       */ 
/*       */   public void setNT60(double aNT60) {
/*  1923 */     this.nT60 = aNT60;
/*       */   }
/*       */ 
/*       */   public void setNT60(String aNT60) {
/*  1927 */     if ((aNT60 != null) && (!aNT60.equals("")))
/*       */     {
/*  1929 */       Double tDouble = new Double(aNT60);
/*  1930 */       double d = tDouble.doubleValue();
/*  1931 */       this.nT60 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT61()
/*       */   {
/*  1937 */     return this.nT61;
/*       */   }
/*       */ 
/*       */   public void setNT61(double aNT61) {
/*  1941 */     this.nT61 = aNT61;
/*       */   }
/*       */ 
/*       */   public void setNT61(String aNT61) {
/*  1945 */     if ((aNT61 != null) && (!aNT61.equals("")))
/*       */     {
/*  1947 */       Double tDouble = new Double(aNT61);
/*  1948 */       double d = tDouble.doubleValue();
/*  1949 */       this.nT61 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT62()
/*       */   {
/*  1955 */     return this.nT62;
/*       */   }
/*       */ 
/*       */   public void setNT62(double aNT62) {
/*  1959 */     this.nT62 = aNT62;
/*       */   }
/*       */ 
/*       */   public void setNT62(String aNT62) {
/*  1963 */     if ((aNT62 != null) && (!aNT62.equals("")))
/*       */     {
/*  1965 */       Double tDouble = new Double(aNT62);
/*  1966 */       double d = tDouble.doubleValue();
/*  1967 */       this.nT62 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT63()
/*       */   {
/*  1973 */     return this.nT63;
/*       */   }
/*       */ 
/*       */   public void setNT63(double aNT63) {
/*  1977 */     this.nT63 = aNT63;
/*       */   }
/*       */ 
/*       */   public void setNT63(String aNT63) {
/*  1981 */     if ((aNT63 != null) && (!aNT63.equals("")))
/*       */     {
/*  1983 */       Double tDouble = new Double(aNT63);
/*  1984 */       double d = tDouble.doubleValue();
/*  1985 */       this.nT63 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT64()
/*       */   {
/*  1991 */     return this.nT64;
/*       */   }
/*       */ 
/*       */   public void setNT64(double aNT64) {
/*  1995 */     this.nT64 = aNT64;
/*       */   }
/*       */ 
/*       */   public void setNT64(String aNT64) {
/*  1999 */     if ((aNT64 != null) && (!aNT64.equals("")))
/*       */     {
/*  2001 */       Double tDouble = new Double(aNT64);
/*  2002 */       double d = tDouble.doubleValue();
/*  2003 */       this.nT64 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT65()
/*       */   {
/*  2009 */     return this.nT65;
/*       */   }
/*       */ 
/*       */   public void setNT65(double aNT65) {
/*  2013 */     this.nT65 = aNT65;
/*       */   }
/*       */ 
/*       */   public void setNT65(String aNT65) {
/*  2017 */     if ((aNT65 != null) && (!aNT65.equals("")))
/*       */     {
/*  2019 */       Double tDouble = new Double(aNT65);
/*  2020 */       double d = tDouble.doubleValue();
/*  2021 */       this.nT65 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT66()
/*       */   {
/*  2027 */     return this.nT66;
/*       */   }
/*       */ 
/*       */   public void setNT66(double aNT66) {
/*  2031 */     this.nT66 = aNT66;
/*       */   }
/*       */ 
/*       */   public void setNT66(String aNT66) {
/*  2035 */     if ((aNT66 != null) && (!aNT66.equals("")))
/*       */     {
/*  2037 */       Double tDouble = new Double(aNT66);
/*  2038 */       double d = tDouble.doubleValue();
/*  2039 */       this.nT66 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT67()
/*       */   {
/*  2045 */     return this.nT67;
/*       */   }
/*       */ 
/*       */   public void setNT67(double aNT67) {
/*  2049 */     this.nT67 = aNT67;
/*       */   }
/*       */ 
/*       */   public void setNT67(String aNT67) {
/*  2053 */     if ((aNT67 != null) && (!aNT67.equals("")))
/*       */     {
/*  2055 */       Double tDouble = new Double(aNT67);
/*  2056 */       double d = tDouble.doubleValue();
/*  2057 */       this.nT67 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT68()
/*       */   {
/*  2063 */     return this.nT68;
/*       */   }
/*       */ 
/*       */   public void setNT68(double aNT68) {
/*  2067 */     this.nT68 = aNT68;
/*       */   }
/*       */ 
/*       */   public void setNT68(String aNT68) {
/*  2071 */     if ((aNT68 != null) && (!aNT68.equals("")))
/*       */     {
/*  2073 */       Double tDouble = new Double(aNT68);
/*  2074 */       double d = tDouble.doubleValue();
/*  2075 */       this.nT68 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT69()
/*       */   {
/*  2081 */     return this.nT69;
/*       */   }
/*       */ 
/*       */   public void setNT69(double aNT69) {
/*  2085 */     this.nT69 = aNT69;
/*       */   }
/*       */ 
/*       */   public void setNT69(String aNT69) {
/*  2089 */     if ((aNT69 != null) && (!aNT69.equals("")))
/*       */     {
/*  2091 */       Double tDouble = new Double(aNT69);
/*  2092 */       double d = tDouble.doubleValue();
/*  2093 */       this.nT69 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT70()
/*       */   {
/*  2099 */     return this.nT70;
/*       */   }
/*       */ 
/*       */   public void setNT70(double aNT70) {
/*  2103 */     this.nT70 = aNT70;
/*       */   }
/*       */ 
/*       */   public void setNT70(String aNT70) {
/*  2107 */     if ((aNT70 != null) && (!aNT70.equals("")))
/*       */     {
/*  2109 */       Double tDouble = new Double(aNT70);
/*  2110 */       double d = tDouble.doubleValue();
/*  2111 */       this.nT70 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT71()
/*       */   {
/*  2117 */     return this.nT71;
/*       */   }
/*       */ 
/*       */   public void setNT71(double aNT71) {
/*  2121 */     this.nT71 = aNT71;
/*       */   }
/*       */ 
/*       */   public void setNT71(String aNT71) {
/*  2125 */     if ((aNT71 != null) && (!aNT71.equals("")))
/*       */     {
/*  2127 */       Double tDouble = new Double(aNT71);
/*  2128 */       double d = tDouble.doubleValue();
/*  2129 */       this.nT71 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT72()
/*       */   {
/*  2135 */     return this.nT72;
/*       */   }
/*       */ 
/*       */   public void setNT72(double aNT72) {
/*  2139 */     this.nT72 = aNT72;
/*       */   }
/*       */ 
/*       */   public void setNT72(String aNT72) {
/*  2143 */     if ((aNT72 != null) && (!aNT72.equals("")))
/*       */     {
/*  2145 */       Double tDouble = new Double(aNT72);
/*  2146 */       double d = tDouble.doubleValue();
/*  2147 */       this.nT72 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT73()
/*       */   {
/*  2153 */     return this.nT73;
/*       */   }
/*       */ 
/*       */   public void setNT73(double aNT73) {
/*  2157 */     this.nT73 = aNT73;
/*       */   }
/*       */ 
/*       */   public void setNT73(String aNT73) {
/*  2161 */     if ((aNT73 != null) && (!aNT73.equals("")))
/*       */     {
/*  2163 */       Double tDouble = new Double(aNT73);
/*  2164 */       double d = tDouble.doubleValue();
/*  2165 */       this.nT73 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT74()
/*       */   {
/*  2171 */     return this.nT74;
/*       */   }
/*       */ 
/*       */   public void setNT74(double aNT74) {
/*  2175 */     this.nT74 = aNT74;
/*       */   }
/*       */ 
/*       */   public void setNT74(String aNT74) {
/*  2179 */     if ((aNT74 != null) && (!aNT74.equals("")))
/*       */     {
/*  2181 */       Double tDouble = new Double(aNT74);
/*  2182 */       double d = tDouble.doubleValue();
/*  2183 */       this.nT74 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT75()
/*       */   {
/*  2189 */     return this.nT75;
/*       */   }
/*       */ 
/*       */   public void setNT75(double aNT75) {
/*  2193 */     this.nT75 = aNT75;
/*       */   }
/*       */ 
/*       */   public void setNT75(String aNT75) {
/*  2197 */     if ((aNT75 != null) && (!aNT75.equals("")))
/*       */     {
/*  2199 */       Double tDouble = new Double(aNT75);
/*  2200 */       double d = tDouble.doubleValue();
/*  2201 */       this.nT75 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT76()
/*       */   {
/*  2207 */     return this.nT76;
/*       */   }
/*       */ 
/*       */   public void setNT76(double aNT76) {
/*  2211 */     this.nT76 = aNT76;
/*       */   }
/*       */ 
/*       */   public void setNT76(String aNT76) {
/*  2215 */     if ((aNT76 != null) && (!aNT76.equals("")))
/*       */     {
/*  2217 */       Double tDouble = new Double(aNT76);
/*  2218 */       double d = tDouble.doubleValue();
/*  2219 */       this.nT76 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT77()
/*       */   {
/*  2225 */     return this.nT77;
/*       */   }
/*       */ 
/*       */   public void setNT77(double aNT77) {
/*  2229 */     this.nT77 = aNT77;
/*       */   }
/*       */ 
/*       */   public void setNT77(String aNT77) {
/*  2233 */     if ((aNT77 != null) && (!aNT77.equals("")))
/*       */     {
/*  2235 */       Double tDouble = new Double(aNT77);
/*  2236 */       double d = tDouble.doubleValue();
/*  2237 */       this.nT77 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT78()
/*       */   {
/*  2243 */     return this.nT78;
/*       */   }
/*       */ 
/*       */   public void setNT78(double aNT78) {
/*  2247 */     this.nT78 = aNT78;
/*       */   }
/*       */ 
/*       */   public void setNT78(String aNT78) {
/*  2251 */     if ((aNT78 != null) && (!aNT78.equals("")))
/*       */     {
/*  2253 */       Double tDouble = new Double(aNT78);
/*  2254 */       double d = tDouble.doubleValue();
/*  2255 */       this.nT78 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT79()
/*       */   {
/*  2261 */     return this.nT79;
/*       */   }
/*       */ 
/*       */   public void setNT79(double aNT79) {
/*  2265 */     this.nT79 = aNT79;
/*       */   }
/*       */ 
/*       */   public void setNT79(String aNT79) {
/*  2269 */     if ((aNT79 != null) && (!aNT79.equals("")))
/*       */     {
/*  2271 */       Double tDouble = new Double(aNT79);
/*  2272 */       double d = tDouble.doubleValue();
/*  2273 */       this.nT79 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNT80()
/*       */   {
/*  2279 */     return this.nT80;
/*       */   }
/*       */ 
/*       */   public void setNT80(double aNT80) {
/*  2283 */     this.nT80 = aNT80;
/*       */   }
/*       */ 
/*       */   public void setNT80(String aNT80) {
/*  2287 */     if ((aNT80 != null) && (!aNT80.equals("")))
/*       */     {
/*  2289 */       Double tDouble = new Double(aNT80);
/*  2290 */       double d = tDouble.doubleValue();
/*  2291 */       this.nT80 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF01()
/*       */   {
/*  2297 */     return this.nF01;
/*       */   }
/*       */ 
/*       */   public void setNF01(double aNF01) {
/*  2301 */     this.nF01 = aNF01;
/*       */   }
/*       */ 
/*       */   public void setNF01(String aNF01) {
/*  2305 */     if ((aNF01 != null) && (!aNF01.equals("")))
/*       */     {
/*  2307 */       Double tDouble = new Double(aNF01);
/*  2308 */       double d = tDouble.doubleValue();
/*  2309 */       this.nF01 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF02()
/*       */   {
/*  2315 */     return this.nF02;
/*       */   }
/*       */ 
/*       */   public void setNF02(double aNF02) {
/*  2319 */     this.nF02 = aNF02;
/*       */   }
/*       */ 
/*       */   public void setNF02(String aNF02) {
/*  2323 */     if ((aNF02 != null) && (!aNF02.equals("")))
/*       */     {
/*  2325 */       Double tDouble = new Double(aNF02);
/*  2326 */       double d = tDouble.doubleValue();
/*  2327 */       this.nF02 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF03()
/*       */   {
/*  2333 */     return this.nF03;
/*       */   }
/*       */ 
/*       */   public void setNF03(double aNF03) {
/*  2337 */     this.nF03 = aNF03;
/*       */   }
/*       */ 
/*       */   public void setNF03(String aNF03) {
/*  2341 */     if ((aNF03 != null) && (!aNF03.equals("")))
/*       */     {
/*  2343 */       Double tDouble = new Double(aNF03);
/*  2344 */       double d = tDouble.doubleValue();
/*  2345 */       this.nF03 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF04()
/*       */   {
/*  2351 */     return this.nF04;
/*       */   }
/*       */ 
/*       */   public void setNF04(double aNF04) {
/*  2355 */     this.nF04 = aNF04;
/*       */   }
/*       */ 
/*       */   public void setNF04(String aNF04) {
/*  2359 */     if ((aNF04 != null) && (!aNF04.equals("")))
/*       */     {
/*  2361 */       Double tDouble = new Double(aNF04);
/*  2362 */       double d = tDouble.doubleValue();
/*  2363 */       this.nF04 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF05()
/*       */   {
/*  2369 */     return this.nF05;
/*       */   }
/*       */ 
/*       */   public void setNF05(double aNF05) {
/*  2373 */     this.nF05 = aNF05;
/*       */   }
/*       */ 
/*       */   public void setNF05(String aNF05) {
/*  2377 */     if ((aNF05 != null) && (!aNF05.equals("")))
/*       */     {
/*  2379 */       Double tDouble = new Double(aNF05);
/*  2380 */       double d = tDouble.doubleValue();
/*  2381 */       this.nF05 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF06()
/*       */   {
/*  2387 */     return this.nF06;
/*       */   }
/*       */ 
/*       */   public void setNF06(double aNF06) {
/*  2391 */     this.nF06 = aNF06;
/*       */   }
/*       */ 
/*       */   public void setNF06(String aNF06) {
/*  2395 */     if ((aNF06 != null) && (!aNF06.equals("")))
/*       */     {
/*  2397 */       Double tDouble = new Double(aNF06);
/*  2398 */       double d = tDouble.doubleValue();
/*  2399 */       this.nF06 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF07()
/*       */   {
/*  2405 */     return this.nF07;
/*       */   }
/*       */ 
/*       */   public void setNF07(double aNF07) {
/*  2409 */     this.nF07 = aNF07;
/*       */   }
/*       */ 
/*       */   public void setNF07(String aNF07) {
/*  2413 */     if ((aNF07 != null) && (!aNF07.equals("")))
/*       */     {
/*  2415 */       Double tDouble = new Double(aNF07);
/*  2416 */       double d = tDouble.doubleValue();
/*  2417 */       this.nF07 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF08()
/*       */   {
/*  2423 */     return this.nF08;
/*       */   }
/*       */ 
/*       */   public void setNF08(double aNF08) {
/*  2427 */     this.nF08 = aNF08;
/*       */   }
/*       */ 
/*       */   public void setNF08(String aNF08) {
/*  2431 */     if ((aNF08 != null) && (!aNF08.equals("")))
/*       */     {
/*  2433 */       Double tDouble = new Double(aNF08);
/*  2434 */       double d = tDouble.doubleValue();
/*  2435 */       this.nF08 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF09()
/*       */   {
/*  2441 */     return this.nF09;
/*       */   }
/*       */ 
/*       */   public void setNF09(double aNF09) {
/*  2445 */     this.nF09 = aNF09;
/*       */   }
/*       */ 
/*       */   public void setNF09(String aNF09) {
/*  2449 */     if ((aNF09 != null) && (!aNF09.equals("")))
/*       */     {
/*  2451 */       Double tDouble = new Double(aNF09);
/*  2452 */       double d = tDouble.doubleValue();
/*  2453 */       this.nF09 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNF10()
/*       */   {
/*  2459 */     return this.nF10;
/*       */   }
/*       */ 
/*       */   public void setNF10(double aNF10) {
/*  2463 */     this.nF10 = aNF10;
/*       */   }
/*       */ 
/*       */   public void setNF10(String aNF10) {
/*  2467 */     if ((aNF10 != null) && (!aNF10.equals("")))
/*       */     {
/*  2469 */       Double tDouble = new Double(aNF10);
/*  2470 */       double d = tDouble.doubleValue();
/*  2471 */       this.nF10 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS01()
/*       */   {
/*  2477 */     return this.nS01;
/*       */   }
/*       */ 
/*       */   public void setNS01(double aNS01) {
/*  2481 */     this.nS01 = aNS01;
/*       */   }
/*       */ 
/*       */   public void setNS01(String aNS01) {
/*  2485 */     if ((aNS01 != null) && (!aNS01.equals("")))
/*       */     {
/*  2487 */       Double tDouble = new Double(aNS01);
/*  2488 */       double d = tDouble.doubleValue();
/*  2489 */       this.nS01 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS02()
/*       */   {
/*  2495 */     return this.nS02;
/*       */   }
/*       */ 
/*       */   public void setNS02(double aNS02) {
/*  2499 */     this.nS02 = aNS02;
/*       */   }
/*       */ 
/*       */   public void setNS02(String aNS02) {
/*  2503 */     if ((aNS02 != null) && (!aNS02.equals("")))
/*       */     {
/*  2505 */       Double tDouble = new Double(aNS02);
/*  2506 */       double d = tDouble.doubleValue();
/*  2507 */       this.nS02 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS03()
/*       */   {
/*  2513 */     return this.nS03;
/*       */   }
/*       */ 
/*       */   public void setNS03(double aNS03) {
/*  2517 */     this.nS03 = aNS03;
/*       */   }
/*       */ 
/*       */   public void setNS03(String aNS03) {
/*  2521 */     if ((aNS03 != null) && (!aNS03.equals("")))
/*       */     {
/*  2523 */       Double tDouble = new Double(aNS03);
/*  2524 */       double d = tDouble.doubleValue();
/*  2525 */       this.nS03 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS04()
/*       */   {
/*  2531 */     return this.nS04;
/*       */   }
/*       */ 
/*       */   public void setNS04(double aNS04) {
/*  2535 */     this.nS04 = aNS04;
/*       */   }
/*       */ 
/*       */   public void setNS04(String aNS04) {
/*  2539 */     if ((aNS04 != null) && (!aNS04.equals("")))
/*       */     {
/*  2541 */       Double tDouble = new Double(aNS04);
/*  2542 */       double d = tDouble.doubleValue();
/*  2543 */       this.nS04 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS05()
/*       */   {
/*  2549 */     return this.nS05;
/*       */   }
/*       */ 
/*       */   public void setNS05(double aNS05) {
/*  2553 */     this.nS05 = aNS05;
/*       */   }
/*       */ 
/*       */   public void setNS05(String aNS05) {
/*  2557 */     if ((aNS05 != null) && (!aNS05.equals("")))
/*       */     {
/*  2559 */       Double tDouble = new Double(aNS05);
/*  2560 */       double d = tDouble.doubleValue();
/*  2561 */       this.nS05 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS06()
/*       */   {
/*  2567 */     return this.nS06;
/*       */   }
/*       */ 
/*       */   public void setNS06(double aNS06) {
/*  2571 */     this.nS06 = aNS06;
/*       */   }
/*       */ 
/*       */   public void setNS06(String aNS06) {
/*  2575 */     if ((aNS06 != null) && (!aNS06.equals("")))
/*       */     {
/*  2577 */       Double tDouble = new Double(aNS06);
/*  2578 */       double d = tDouble.doubleValue();
/*  2579 */       this.nS06 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS07()
/*       */   {
/*  2585 */     return this.nS07;
/*       */   }
/*       */ 
/*       */   public void setNS07(double aNS07) {
/*  2589 */     this.nS07 = aNS07;
/*       */   }
/*       */ 
/*       */   public void setNS07(String aNS07) {
/*  2593 */     if ((aNS07 != null) && (!aNS07.equals("")))
/*       */     {
/*  2595 */       Double tDouble = new Double(aNS07);
/*  2596 */       double d = tDouble.doubleValue();
/*  2597 */       this.nS07 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS08()
/*       */   {
/*  2603 */     return this.nS08;
/*       */   }
/*       */ 
/*       */   public void setNS08(double aNS08) {
/*  2607 */     this.nS08 = aNS08;
/*       */   }
/*       */ 
/*       */   public void setNS08(String aNS08) {
/*  2611 */     if ((aNS08 != null) && (!aNS08.equals("")))
/*       */     {
/*  2613 */       Double tDouble = new Double(aNS08);
/*  2614 */       double d = tDouble.doubleValue();
/*  2615 */       this.nS08 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS09()
/*       */   {
/*  2621 */     return this.nS09;
/*       */   }
/*       */ 
/*       */   public void setNS09(double aNS09) {
/*  2625 */     this.nS09 = aNS09;
/*       */   }
/*       */ 
/*       */   public void setNS09(String aNS09) {
/*  2629 */     if ((aNS09 != null) && (!aNS09.equals("")))
/*       */     {
/*  2631 */       Double tDouble = new Double(aNS09);
/*  2632 */       double d = tDouble.doubleValue();
/*  2633 */       this.nS09 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public double getNS10()
/*       */   {
/*  2639 */     return this.nS10;
/*       */   }
/*       */ 
/*       */   public void setNS10(double aNS10) {
/*  2643 */     this.nS10 = aNS10;
/*       */   }
/*       */ 
/*       */   public void setNS10(String aNS10) {
/*  2647 */     if ((aNS10 != null) && (!aNS10.equals("")))
/*       */     {
/*  2649 */       Double tDouble = new Double(aNS10);
/*  2650 */       double d = tDouble.doubleValue();
/*  2651 */       this.nS10 = d;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT01()
/*       */   {
/*  2657 */     return this.iNT01;
/*       */   }
/*       */ 
/*       */   public void setINT01(int aINT01) {
/*  2661 */     this.iNT01 = aINT01;
/*       */   }
/*       */ 
/*       */   public void setINT01(String aINT01) {
/*  2665 */     if ((aINT01 != null) && (!aINT01.equals("")))
/*       */     {
/*  2667 */       Integer tInteger = new Integer(aINT01);
/*  2668 */       int i = tInteger.intValue();
/*  2669 */       this.iNT01 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT02()
/*       */   {
/*  2675 */     return this.iNT02;
/*       */   }
/*       */ 
/*       */   public void setINT02(int aINT02) {
/*  2679 */     this.iNT02 = aINT02;
/*       */   }
/*       */ 
/*       */   public void setINT02(String aINT02) {
/*  2683 */     if ((aINT02 != null) && (!aINT02.equals("")))
/*       */     {
/*  2685 */       Integer tInteger = new Integer(aINT02);
/*  2686 */       int i = tInteger.intValue();
/*  2687 */       this.iNT02 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT03()
/*       */   {
/*  2693 */     return this.iNT03;
/*       */   }
/*       */ 
/*       */   public void setINT03(int aINT03) {
/*  2697 */     this.iNT03 = aINT03;
/*       */   }
/*       */ 
/*       */   public void setINT03(String aINT03) {
/*  2701 */     if ((aINT03 != null) && (!aINT03.equals("")))
/*       */     {
/*  2703 */       Integer tInteger = new Integer(aINT03);
/*  2704 */       int i = tInteger.intValue();
/*  2705 */       this.iNT03 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT04()
/*       */   {
/*  2711 */     return this.iNT04;
/*       */   }
/*       */ 
/*       */   public void setINT04(int aINT04) {
/*  2715 */     this.iNT04 = aINT04;
/*       */   }
/*       */ 
/*       */   public void setINT04(String aINT04) {
/*  2719 */     if ((aINT04 != null) && (!aINT04.equals("")))
/*       */     {
/*  2721 */       Integer tInteger = new Integer(aINT04);
/*  2722 */       int i = tInteger.intValue();
/*  2723 */       this.iNT04 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT05()
/*       */   {
/*  2729 */     return this.iNT05;
/*       */   }
/*       */ 
/*       */   public void setINT05(int aINT05) {
/*  2733 */     this.iNT05 = aINT05;
/*       */   }
/*       */ 
/*       */   public void setINT05(String aINT05) {
/*  2737 */     if ((aINT05 != null) && (!aINT05.equals("")))
/*       */     {
/*  2739 */       Integer tInteger = new Integer(aINT05);
/*  2740 */       int i = tInteger.intValue();
/*  2741 */       this.iNT05 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT06()
/*       */   {
/*  2747 */     return this.iNT06;
/*       */   }
/*       */ 
/*       */   public void setINT06(int aINT06) {
/*  2751 */     this.iNT06 = aINT06;
/*       */   }
/*       */ 
/*       */   public void setINT06(String aINT06) {
/*  2755 */     if ((aINT06 != null) && (!aINT06.equals("")))
/*       */     {
/*  2757 */       Integer tInteger = new Integer(aINT06);
/*  2758 */       int i = tInteger.intValue();
/*  2759 */       this.iNT06 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT07()
/*       */   {
/*  2765 */     return this.iNT07;
/*       */   }
/*       */ 
/*       */   public void setINT07(int aINT07) {
/*  2769 */     this.iNT07 = aINT07;
/*       */   }
/*       */ 
/*       */   public void setINT07(String aINT07) {
/*  2773 */     if ((aINT07 != null) && (!aINT07.equals("")))
/*       */     {
/*  2775 */       Integer tInteger = new Integer(aINT07);
/*  2776 */       int i = tInteger.intValue();
/*  2777 */       this.iNT07 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT08()
/*       */   {
/*  2783 */     return this.iNT08;
/*       */   }
/*       */ 
/*       */   public void setINT08(int aINT08) {
/*  2787 */     this.iNT08 = aINT08;
/*       */   }
/*       */ 
/*       */   public void setINT08(String aINT08) {
/*  2791 */     if ((aINT08 != null) && (!aINT08.equals("")))
/*       */     {
/*  2793 */       Integer tInteger = new Integer(aINT08);
/*  2794 */       int i = tInteger.intValue();
/*  2795 */       this.iNT08 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT09()
/*       */   {
/*  2801 */     return this.iNT09;
/*       */   }
/*       */ 
/*       */   public void setINT09(int aINT09) {
/*  2805 */     this.iNT09 = aINT09;
/*       */   }
/*       */ 
/*       */   public void setINT09(String aINT09) {
/*  2809 */     if ((aINT09 != null) && (!aINT09.equals("")))
/*       */     {
/*  2811 */       Integer tInteger = new Integer(aINT09);
/*  2812 */       int i = tInteger.intValue();
/*  2813 */       this.iNT09 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT10()
/*       */   {
/*  2819 */     return this.iNT10;
/*       */   }
/*       */ 
/*       */   public void setINT10(int aINT10) {
/*  2823 */     this.iNT10 = aINT10;
/*       */   }
/*       */ 
/*       */   public void setINT10(String aINT10) {
/*  2827 */     if ((aINT10 != null) && (!aINT10.equals("")))
/*       */     {
/*  2829 */       Integer tInteger = new Integer(aINT10);
/*  2830 */       int i = tInteger.intValue();
/*  2831 */       this.iNT10 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT11()
/*       */   {
/*  2837 */     return this.iNT11;
/*       */   }
/*       */ 
/*       */   public void setINT11(int aINT11) {
/*  2841 */     this.iNT11 = aINT11;
/*       */   }
/*       */ 
/*       */   public void setINT11(String aINT11) {
/*  2845 */     if ((aINT11 != null) && (!aINT11.equals("")))
/*       */     {
/*  2847 */       Integer tInteger = new Integer(aINT11);
/*  2848 */       int i = tInteger.intValue();
/*  2849 */       this.iNT11 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT12()
/*       */   {
/*  2855 */     return this.iNT12;
/*       */   }
/*       */ 
/*       */   public void setINT12(int aINT12) {
/*  2859 */     this.iNT12 = aINT12;
/*       */   }
/*       */ 
/*       */   public void setINT12(String aINT12) {
/*  2863 */     if ((aINT12 != null) && (!aINT12.equals("")))
/*       */     {
/*  2865 */       Integer tInteger = new Integer(aINT12);
/*  2866 */       int i = tInteger.intValue();
/*  2867 */       this.iNT12 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT13()
/*       */   {
/*  2873 */     return this.iNT13;
/*       */   }
/*       */ 
/*       */   public void setINT13(int aINT13) {
/*  2877 */     this.iNT13 = aINT13;
/*       */   }
/*       */ 
/*       */   public void setINT13(String aINT13) {
/*  2881 */     if ((aINT13 != null) && (!aINT13.equals("")))
/*       */     {
/*  2883 */       Integer tInteger = new Integer(aINT13);
/*  2884 */       int i = tInteger.intValue();
/*  2885 */       this.iNT13 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT14()
/*       */   {
/*  2891 */     return this.iNT14;
/*       */   }
/*       */ 
/*       */   public void setINT14(int aINT14) {
/*  2895 */     this.iNT14 = aINT14;
/*       */   }
/*       */ 
/*       */   public void setINT14(String aINT14) {
/*  2899 */     if ((aINT14 != null) && (!aINT14.equals("")))
/*       */     {
/*  2901 */       Integer tInteger = new Integer(aINT14);
/*  2902 */       int i = tInteger.intValue();
/*  2903 */       this.iNT14 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT15()
/*       */   {
/*  2909 */     return this.iNT15;
/*       */   }
/*       */ 
/*       */   public void setINT15(int aINT15) {
/*  2913 */     this.iNT15 = aINT15;
/*       */   }
/*       */ 
/*       */   public void setINT15(String aINT15) {
/*  2917 */     if ((aINT15 != null) && (!aINT15.equals("")))
/*       */     {
/*  2919 */       Integer tInteger = new Integer(aINT15);
/*  2920 */       int i = tInteger.intValue();
/*  2921 */       this.iNT15 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT16()
/*       */   {
/*  2927 */     return this.iNT16;
/*       */   }
/*       */ 
/*       */   public void setINT16(int aINT16) {
/*  2931 */     this.iNT16 = aINT16;
/*       */   }
/*       */ 
/*       */   public void setINT16(String aINT16) {
/*  2935 */     if ((aINT16 != null) && (!aINT16.equals("")))
/*       */     {
/*  2937 */       Integer tInteger = new Integer(aINT16);
/*  2938 */       int i = tInteger.intValue();
/*  2939 */       this.iNT16 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT17()
/*       */   {
/*  2945 */     return this.iNT17;
/*       */   }
/*       */ 
/*       */   public void setINT17(int aINT17) {
/*  2949 */     this.iNT17 = aINT17;
/*       */   }
/*       */ 
/*       */   public void setINT17(String aINT17) {
/*  2953 */     if ((aINT17 != null) && (!aINT17.equals("")))
/*       */     {
/*  2955 */       Integer tInteger = new Integer(aINT17);
/*  2956 */       int i = tInteger.intValue();
/*  2957 */       this.iNT17 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT18()
/*       */   {
/*  2963 */     return this.iNT18;
/*       */   }
/*       */ 
/*       */   public void setINT18(int aINT18) {
/*  2967 */     this.iNT18 = aINT18;
/*       */   }
/*       */ 
/*       */   public void setINT18(String aINT18) {
/*  2971 */     if ((aINT18 != null) && (!aINT18.equals("")))
/*       */     {
/*  2973 */       Integer tInteger = new Integer(aINT18);
/*  2974 */       int i = tInteger.intValue();
/*  2975 */       this.iNT18 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT19()
/*       */   {
/*  2981 */     return this.iNT19;
/*       */   }
/*       */ 
/*       */   public void setINT19(int aINT19) {
/*  2985 */     this.iNT19 = aINT19;
/*       */   }
/*       */ 
/*       */   public void setINT19(String aINT19) {
/*  2989 */     if ((aINT19 != null) && (!aINT19.equals("")))
/*       */     {
/*  2991 */       Integer tInteger = new Integer(aINT19);
/*  2992 */       int i = tInteger.intValue();
/*  2993 */       this.iNT19 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT20()
/*       */   {
/*  2999 */     return this.iNT20;
/*       */   }
/*       */ 
/*       */   public void setINT20(int aINT20) {
/*  3003 */     this.iNT20 = aINT20;
/*       */   }
/*       */ 
/*       */   public void setINT20(String aINT20) {
/*  3007 */     if ((aINT20 != null) && (!aINT20.equals("")))
/*       */     {
/*  3009 */       Integer tInteger = new Integer(aINT20);
/*  3010 */       int i = tInteger.intValue();
/*  3011 */       this.iNT20 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT21()
/*       */   {
/*  3017 */     return this.iNT21;
/*       */   }
/*       */ 
/*       */   public void setINT21(int aINT21) {
/*  3021 */     this.iNT21 = aINT21;
/*       */   }
/*       */ 
/*       */   public void setINT21(String aINT21) {
/*  3025 */     if ((aINT21 != null) && (!aINT21.equals("")))
/*       */     {
/*  3027 */       Integer tInteger = new Integer(aINT21);
/*  3028 */       int i = tInteger.intValue();
/*  3029 */       this.iNT21 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT22()
/*       */   {
/*  3035 */     return this.iNT22;
/*       */   }
/*       */ 
/*       */   public void setINT22(int aINT22) {
/*  3039 */     this.iNT22 = aINT22;
/*       */   }
/*       */ 
/*       */   public void setINT22(String aINT22) {
/*  3043 */     if ((aINT22 != null) && (!aINT22.equals("")))
/*       */     {
/*  3045 */       Integer tInteger = new Integer(aINT22);
/*  3046 */       int i = tInteger.intValue();
/*  3047 */       this.iNT22 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT23()
/*       */   {
/*  3053 */     return this.iNT23;
/*       */   }
/*       */ 
/*       */   public void setINT23(int aINT23) {
/*  3057 */     this.iNT23 = aINT23;
/*       */   }
/*       */ 
/*       */   public void setINT23(String aINT23) {
/*  3061 */     if ((aINT23 != null) && (!aINT23.equals("")))
/*       */     {
/*  3063 */       Integer tInteger = new Integer(aINT23);
/*  3064 */       int i = tInteger.intValue();
/*  3065 */       this.iNT23 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT24()
/*       */   {
/*  3071 */     return this.iNT24;
/*       */   }
/*       */ 
/*       */   public void setINT24(int aINT24) {
/*  3075 */     this.iNT24 = aINT24;
/*       */   }
/*       */ 
/*       */   public void setINT24(String aINT24) {
/*  3079 */     if ((aINT24 != null) && (!aINT24.equals("")))
/*       */     {
/*  3081 */       Integer tInteger = new Integer(aINT24);
/*  3082 */       int i = tInteger.intValue();
/*  3083 */       this.iNT24 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public int getINT25()
/*       */   {
/*  3089 */     return this.iNT25;
/*       */   }
/*       */ 
/*       */   public void setINT25(int aINT25) {
/*  3093 */     this.iNT25 = aINT25;
/*       */   }
/*       */ 
/*       */   public void setINT25(String aINT25) {
/*  3097 */     if ((aINT25 != null) && (!aINT25.equals("")))
/*       */     {
/*  3099 */       Integer tInteger = new Integer(aINT25);
/*  3100 */       int i = tInteger.intValue();
/*  3101 */       this.iNT25 = i;
/*       */     }
/*       */   }
/*       */ 
/*       */   public String getV1()
/*       */   {
/*  3107 */     return this.v1;
/*       */   }
/*       */ 
/*       */   public void setV1(String aV1) {
/*  3111 */     this.v1 = aV1;
/*       */   }
/*       */ 
/*       */   public String getV2() {
/*  3115 */     return this.v2;
/*       */   }
/*       */ 
/*       */   public void setV2(String aV2) {
/*  3119 */     this.v2 = aV2;
/*       */   }
/*       */ 
/*       */   public String getV3() {
/*  3123 */     return this.v3;
/*       */   }
/*       */ 
/*       */   public void setV3(String aV3) {
/*  3127 */     this.v3 = aV3;
/*       */   }
/*       */ 
/*       */   public String getV4() {
/*  3131 */     return this.v4;
/*       */   }
/*       */ 
/*       */   public void setV4(String aV4) {
/*  3135 */     this.v4 = aV4;
/*       */   }
/*       */ 
/*       */   public String getV5() {
/*  3139 */     return this.v5;
/*       */   }
/*       */ 
/*       */   public void setV5(String aV5) {
/*  3143 */     this.v5 = aV5;
/*       */   }
/*       */ 
/*       */   public String getV6() {
/*  3147 */     return this.v6;
/*       */   }
/*       */ 
/*       */   public void setV6(String aV6) {
/*  3151 */     this.v6 = aV6;
/*       */   }
/*       */ 
/*       */   public String getV7() {
/*  3155 */     return this.v7;
/*       */   }
/*       */ 
/*       */   public void setV7(String aV7) {
/*  3159 */     this.v7 = aV7;
/*       */   }
/*       */ 
/*       */   public String getV8() {
/*  3163 */     return this.v8;
/*       */   }
/*       */ 
/*       */   public void setV8(String aV8) {
/*  3167 */     this.v8 = aV8;
/*       */   }
/*       */ 
/*       */   public String getV9() {
/*  3171 */     return this.v9;
/*       */   }
/*       */ 
/*       */   public void setV9(String aV9) {
/*  3175 */     this.v9 = aV9;
/*       */   }
/*       */ 
/*       */   public String getV10() {
/*  3179 */     return this.v10;
/*       */   }
/*       */ 
/*       */   public void setV10(String aV10) {
/*  3183 */     this.v10 = aV10;
/*       */   }
/*       */ 
/*       */   public String getV11() {
/*  3187 */     return this.v11;
/*       */   }
/*       */ 
/*       */   public void setV11(String aV11) {
/*  3191 */     this.v11 = aV11;
/*       */   }
/*       */ 
/*       */   public String getV12() {
/*  3195 */     return this.v12;
/*       */   }
/*       */ 
/*       */   public void setV12(String aV12) {
/*  3199 */     this.v12 = aV12;
/*       */   }
/*       */ 
/*       */   public String getV13() {
/*  3203 */     return this.v13;
/*       */   }
/*       */ 
/*       */   public void setV13(String aV13) {
/*  3207 */     this.v13 = aV13;
/*       */   }
/*       */ 
/*       */   public String getV14() {
/*  3211 */     return this.v14;
/*       */   }
/*       */ 
/*       */   public void setV14(String aV14) {
/*  3215 */     this.v14 = aV14;
/*       */   }
/*       */ 
/*       */   public String getV15() {
/*  3219 */     return this.v15;
/*       */   }
/*       */ 
/*       */   public void setV15(String aV15) {
/*  3223 */     this.v15 = aV15;
/*       */   }
/*       */ 
/*       */   public String getV16() {
/*  3227 */     return this.v16;
/*       */   }
/*       */ 
/*       */   public void setV16(String aV16) {
/*  3231 */     this.v16 = aV16;
/*       */   }
/*       */ 
/*       */   public String getV17() {
/*  3235 */     return this.v17;
/*       */   }
/*       */ 
/*       */   public void setV17(String aV17) {
/*  3239 */     this.v17 = aV17;
/*       */   }
/*       */ 
/*       */   public String getV18() {
/*  3243 */     return this.v18;
/*       */   }
/*       */ 
/*       */   public void setV18(String aV18) {
/*  3247 */     this.v18 = aV18;
/*       */   }
/*       */ 
/*       */   public String getV19() {
/*  3251 */     return this.v19;
/*       */   }
/*       */ 
/*       */   public void setV19(String aV19) {
/*  3255 */     this.v19 = aV19;
/*       */   }
/*       */ 
/*       */   public String getV20() {
/*  3259 */     return this.v20;
/*       */   }
/*       */ 
/*       */   public void setV20(String aV20) {
/*  3263 */     this.v20 = aV20;
/*       */   }
/*       */ 
/*       */   public String getVT1() {
/*  3267 */     return this.vT1;
/*       */   }
/*       */ 
/*       */   public void setVT1(String aVT1) {
/*  3271 */     this.vT1 = aVT1;
/*       */   }
/*       */ 
/*       */   public String getVT2() {
/*  3275 */     return this.vT2;
/*       */   }
/*       */ 
/*       */   public void setVT2(String aVT2) {
/*  3279 */     this.vT2 = aVT2;
/*       */   }
/*       */ 
/*       */   public String getVT3() {
/*  3283 */     return this.vT3;
/*       */   }
/*       */ 
/*       */   public void setVT3(String aVT3) {
/*  3287 */     this.vT3 = aVT3;
/*       */   }
/*       */ 
/*       */   public String getVT4() {
/*  3291 */     return this.vT4;
/*       */   }
/*       */ 
/*       */   public void setVT4(String aVT4) {
/*  3295 */     this.vT4 = aVT4;
/*       */   }
/*       */ 
/*       */   public String getVT5() {
/*  3299 */     return this.vT5;
/*       */   }
/*       */ 
/*       */   public void setVT5(String aVT5) {
/*  3303 */     this.vT5 = aVT5;
/*       */   }
/*       */ 
/*       */   public String getVT6() {
/*  3307 */     return this.vT6;
/*       */   }
/*       */ 
/*       */   public void setVT6(String aVT6) {
/*  3311 */     this.vT6 = aVT6;
/*       */   }
/*       */ 
/*       */   public String getVT7() {
/*  3315 */     return this.vT7;
/*       */   }
/*       */ 
/*       */   public void setVT7(String aVT7) {
/*  3319 */     this.vT7 = aVT7;
/*       */   }
/*       */ 
/*       */   public String getVT8() {
/*  3323 */     return this.vT8;
/*       */   }
/*       */ 
/*       */   public void setVT8(String aVT8) {
/*  3327 */     this.vT8 = aVT8;
/*       */   }
/*       */ 
/*       */   public String getVE1() {
/*  3331 */     return this.vE1;
/*       */   }
/*       */ 
/*       */   public void setVE1(String aVE1) {
/*  3335 */     this.vE1 = aVE1;
/*       */   }
/*       */ 
/*       */   public String getVE2() {
/*  3339 */     return this.vE2;
/*       */   }
/*       */ 
/*       */   public void setVE2(String aVE2) {
/*  3343 */     this.vE2 = aVE2;
/*       */   }
/*       */ 
/*       */   public String getVE3() {
/*  3347 */     return this.vE3;
/*       */   }
/*       */ 
/*       */   public void setVE3(String aVE3) {
/*  3351 */     this.vE3 = aVE3;
/*       */   }
/*       */ 
/*       */   public String getVE4() {
/*  3355 */     return this.vE4;
/*       */   }
/*       */ 
/*       */   public void setVE4(String aVE4) {
/*  3359 */     this.vE4 = aVE4;
/*       */   }
/*       */ 
/*       */   public String getVE5() {
/*  3363 */     return this.vE5;
/*       */   }
/*       */ 
/*       */   public void setVE5(String aVE5) {
/*  3367 */     this.vE5 = aVE5;
/*       */   }
/*       */ 
/*       */   public String getVE6() {
/*  3371 */     return this.vE6;
/*       */   }
/*       */ 
/*       */   public void setVE6(String aVE6) {
/*  3375 */     this.vE6 = aVE6;
/*       */   }
/*       */ 
/*       */   public String getVE7() {
/*  3379 */     return this.vE7;
/*       */   }
/*       */ 
/*       */   public void setVE7(String aVE7) {
/*  3383 */     this.vE7 = aVE7;
/*       */   }
/*       */ 
/*       */   public String getVE8() {
/*  3387 */     return this.vE8;
/*       */   }
/*       */ 
/*       */   public void setVE8(String aVE8) {
/*  3391 */     this.vE8 = aVE8;
/*       */   }
/*       */ 
/*       */   public String getVE9() {
/*  3395 */     return this.vE9;
/*       */   }
/*       */ 
/*       */   public void setVE9(String aVE9) {
/*  3399 */     this.vE9 = aVE9;
/*       */   }
/*       */ 
/*       */   public String getVE10() {
/*  3403 */     return this.vE10;
/*       */   }
/*       */ 
/*       */   public void setVE10(String aVE10) {
/*  3407 */     this.vE10 = aVE10;
/*       */   }
/*       */ 
/*       */   public String getD1() {
/*  3411 */     if (this.d1 != null) {
/*  3412 */       return this.fDate.getString(this.d1);
/*       */     }
/*  3414 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD1(Date aD1) {
/*  3418 */     this.d1 = aD1;
/*       */   }
/*       */ 
/*       */   public void setD1(String aD1) {
/*  3422 */     if ((aD1 != null) && (!aD1.equals("")))
/*       */     {
/*  3424 */       this.d1 = this.fDate.getDate(aD1);
/*       */     }
/*       */     else
/*  3427 */       this.d1 = null;
/*       */   }
/*       */ 
/*       */   public String getD2()
/*       */   {
/*  3432 */     if (this.d2 != null) {
/*  3433 */       return this.fDate.getString(this.d2);
/*       */     }
/*  3435 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD2(Date aD2) {
/*  3439 */     this.d2 = aD2;
/*       */   }
/*       */ 
/*       */   public void setD2(String aD2) {
/*  3443 */     if ((aD2 != null) && (!aD2.equals("")))
/*       */     {
/*  3445 */       this.d2 = this.fDate.getDate(aD2);
/*       */     }
/*       */     else
/*  3448 */       this.d2 = null;
/*       */   }
/*       */ 
/*       */   public String getD3()
/*       */   {
/*  3453 */     if (this.d3 != null) {
/*  3454 */       return this.fDate.getString(this.d3);
/*       */     }
/*  3456 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD3(Date aD3) {
/*  3460 */     this.d3 = aD3;
/*       */   }
/*       */ 
/*       */   public void setD3(String aD3) {
/*  3464 */     if ((aD3 != null) && (!aD3.equals("")))
/*       */     {
/*  3466 */       this.d3 = this.fDate.getDate(aD3);
/*       */     }
/*       */     else
/*  3469 */       this.d3 = null;
/*       */   }
/*       */ 
/*       */   public String getD4()
/*       */   {
/*  3474 */     if (this.d4 != null) {
/*  3475 */       return this.fDate.getString(this.d4);
/*       */     }
/*  3477 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD4(Date aD4) {
/*  3481 */     this.d4 = aD4;
/*       */   }
/*       */ 
/*       */   public void setD4(String aD4) {
/*  3485 */     if ((aD4 != null) && (!aD4.equals("")))
/*       */     {
/*  3487 */       this.d4 = this.fDate.getDate(aD4);
/*       */     }
/*       */     else
/*  3490 */       this.d4 = null;
/*       */   }
/*       */ 
/*       */   public String getD5()
/*       */   {
/*  3495 */     if (this.d5 != null) {
/*  3496 */       return this.fDate.getString(this.d5);
/*       */     }
/*  3498 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD5(Date aD5) {
/*  3502 */     this.d5 = aD5;
/*       */   }
/*       */ 
/*       */   public void setD5(String aD5) {
/*  3506 */     if ((aD5 != null) && (!aD5.equals("")))
/*       */     {
/*  3508 */       this.d5 = this.fDate.getDate(aD5);
/*       */     }
/*       */     else
/*  3511 */       this.d5 = null;
/*       */   }
/*       */ 
/*       */   public String getD6()
/*       */   {
/*  3516 */     if (this.d6 != null) {
/*  3517 */       return this.fDate.getString(this.d6);
/*       */     }
/*  3519 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD6(Date aD6) {
/*  3523 */     this.d6 = aD6;
/*       */   }
/*       */ 
/*       */   public void setD6(String aD6) {
/*  3527 */     if ((aD6 != null) && (!aD6.equals("")))
/*       */     {
/*  3529 */       this.d6 = this.fDate.getDate(aD6);
/*       */     }
/*       */     else
/*  3532 */       this.d6 = null;
/*       */   }
/*       */ 
/*       */   public String getD7()
/*       */   {
/*  3537 */     if (this.d7 != null) {
/*  3538 */       return this.fDate.getString(this.d7);
/*       */     }
/*  3540 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD7(Date aD7) {
/*  3544 */     this.d7 = aD7;
/*       */   }
/*       */ 
/*       */   public void setD7(String aD7) {
/*  3548 */     if ((aD7 != null) && (!aD7.equals("")))
/*       */     {
/*  3550 */       this.d7 = this.fDate.getDate(aD7);
/*       */     }
/*       */     else
/*  3553 */       this.d7 = null;
/*       */   }
/*       */ 
/*       */   public String getD8()
/*       */   {
/*  3558 */     if (this.d8 != null) {
/*  3559 */       return this.fDate.getString(this.d8);
/*       */     }
/*  3561 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD8(Date aD8) {
/*  3565 */     this.d8 = aD8;
/*       */   }
/*       */ 
/*       */   public void setD8(String aD8) {
/*  3569 */     if ((aD8 != null) && (!aD8.equals("")))
/*       */     {
/*  3571 */       this.d8 = this.fDate.getDate(aD8);
/*       */     }
/*       */     else
/*  3574 */       this.d8 = null;
/*       */   }
/*       */ 
/*       */   public String getD9()
/*       */   {
/*  3579 */     if (this.d9 != null) {
/*  3580 */       return this.fDate.getString(this.d9);
/*       */     }
/*  3582 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD9(Date aD9) {
/*  3586 */     this.d9 = aD9;
/*       */   }
/*       */ 
/*       */   public void setD9(String aD9) {
/*  3590 */     if ((aD9 != null) && (!aD9.equals("")))
/*       */     {
/*  3592 */       this.d9 = this.fDate.getDate(aD9);
/*       */     }
/*       */     else
/*  3595 */       this.d9 = null;
/*       */   }
/*       */ 
/*       */   public String getD10()
/*       */   {
/*  3600 */     if (this.d10 != null) {
/*  3601 */       return this.fDate.getString(this.d10);
/*       */     }
/*  3603 */     return null;
/*       */   }
/*       */ 
/*       */   public void setD10(Date aD10) {
/*  3607 */     this.d10 = aD10;
/*       */   }
/*       */ 
/*       */   public void setD10(String aD10) {
/*  3611 */     if ((aD10 != null) && (!aD10.equals("")))
/*       */     {
/*  3613 */       this.d10 = this.fDate.getDate(aD10);
/*       */     }
/*       */     else
/*  3616 */       this.d10 = null;
/*       */   }
/*       */ 
/*       */   public String getState()
/*       */   {
/*  3621 */     return this.state;
/*       */   }
/*       */ 
/*       */   public void setState(String aState) {
/*  3625 */     this.state = aState;
/*       */   }
/*       */ 
/*       */   public String getOperator() {
/*  3629 */     return this.operator;
/*       */   }
/*       */ 
/*       */   public void setOperator(String aOperator) {
/*  3633 */     this.operator = aOperator;
/*       */   }
/*       */ 
/*       */   public String getMakeDate() {
/*  3637 */     if (this.makeDate != null) {
/*  3638 */       return this.fDate.getString(this.makeDate);
/*       */     }
/*  3640 */     return null;
/*       */   }
/*       */ 
/*       */   public void setMakeDate(Date aMakeDate) {
/*  3644 */     this.makeDate = aMakeDate;
/*       */   }
/*       */ 
/*       */   public void setMakeDate(String aMakeDate) {
/*  3648 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*       */     {
/*  3650 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*       */     }
/*       */     else
/*  3653 */       this.makeDate = null;
/*       */   }
/*       */ 
/*       */   public String getMakeTime()
/*       */   {
/*  3658 */     return this.makeTime;
/*       */   }
/*       */ 
/*       */   public void setMakeTime(String aMakeTime) {
/*  3662 */     this.makeTime = aMakeTime;
/*       */   }
/*       */ 
/*       */   public String getModifyDate() {
/*  3666 */     if (this.modifyDate != null) {
/*  3667 */       return this.fDate.getString(this.modifyDate);
/*       */     }
/*  3669 */     return null;
/*       */   }
/*       */ 
/*       */   public void setModifyDate(Date aModifyDate) {
/*  3673 */     this.modifyDate = aModifyDate;
/*       */   }
/*       */ 
/*       */   public void setModifyDate(String aModifyDate) {
/*  3677 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*       */     {
/*  3679 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*       */     }
/*       */     else
/*  3682 */       this.modifyDate = null;
/*       */   }
/*       */ 
/*       */   public String getModifyTime()
/*       */   {
/*  3687 */     return this.modifyTime;
/*       */   }
/*       */ 
/*       */   public void setModifyTime(String aModifyTime) {
/*  3691 */     this.modifyTime = aModifyTime;
/*       */   }
/*       */ 
/*       */   public void setSchema(LAIndexInfoNewSchema aLAIndexInfoNewSchema)
/*       */   {
/*  3697 */     this.indexCalNo = aLAIndexInfoNewSchema.getIndexCalNo();
/*  3698 */     this.indexType = aLAIndexInfoNewSchema.getIndexType();
/*  3699 */     this.manageCom = aLAIndexInfoNewSchema.getManageCom();
/*  3700 */     this.agentGroup = aLAIndexInfoNewSchema.getAgentGroup();
/*  3701 */     this.branchAttr = aLAIndexInfoNewSchema.getBranchAttr();
/*  3702 */     this.agentCode = aLAIndexInfoNewSchema.getAgentCode();
/*  3703 */     this.agentGrade = aLAIndexInfoNewSchema.getAgentGrade();
/*  3704 */     this.agentTitle = aLAIndexInfoNewSchema.getAgentTitle();
/*  3705 */     this.quaBgnMark = aLAIndexInfoNewSchema.getQuaBgnMark();
/*  3706 */     this.postMonths = aLAIndexInfoNewSchema.getPostMonths();
/*  3707 */     this.assessMonth = aLAIndexInfoNewSchema.getAssessMonth();
/*  3708 */     this.agentGrade1 = aLAIndexInfoNewSchema.getAgentGrade1();
/*  3709 */     this.agentTitle1 = aLAIndexInfoNewSchema.getAgentTitle1();
/*  3710 */     this.agentGrade2 = aLAIndexInfoNewSchema.getAgentGrade2();
/*  3711 */     this.agentTitle2 = aLAIndexInfoNewSchema.getAgentTitle2();
/*  3712 */     this.agentGrade3 = aLAIndexInfoNewSchema.getAgentGrade3();
/*  3713 */     this.agentTitle3 = aLAIndexInfoNewSchema.getAgentTitle3();
/*  3714 */     this.startDate = this.fDate.getDate(aLAIndexInfoNewSchema.getStartDate());
/*  3715 */     this.startEnd = this.fDate.getDate(aLAIndexInfoNewSchema.getStartEnd());
/*  3716 */     this.startDate1 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartDate1());
/*  3717 */     this.startEnd1 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartEnd1());
/*  3718 */     this.startDate2 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartDate2());
/*  3719 */     this.startEnd2 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartEnd2());
/*  3720 */     this.startDate3 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartDate3());
/*  3721 */     this.startEnd3 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartEnd3());
/*  3722 */     this.startEnd4 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartEnd4());
/*  3723 */     this.startDate4 = this.fDate.getDate(aLAIndexInfoNewSchema.getStartDate4());
/*  3724 */     this.serverMonths = aLAIndexInfoNewSchema.getServerMonths();
/*  3725 */     this.nT01 = aLAIndexInfoNewSchema.getNT01();
/*  3726 */     this.nT02 = aLAIndexInfoNewSchema.getNT02();
/*  3727 */     this.nT03 = aLAIndexInfoNewSchema.getNT03();
/*  3728 */     this.nT04 = aLAIndexInfoNewSchema.getNT04();
/*  3729 */     this.nT05 = aLAIndexInfoNewSchema.getNT05();
/*  3730 */     this.nT06 = aLAIndexInfoNewSchema.getNT06();
/*  3731 */     this.nT07 = aLAIndexInfoNewSchema.getNT07();
/*  3732 */     this.nT08 = aLAIndexInfoNewSchema.getNT08();
/*  3733 */     this.nT09 = aLAIndexInfoNewSchema.getNT09();
/*  3734 */     this.nT10 = aLAIndexInfoNewSchema.getNT10();
/*  3735 */     this.nT11 = aLAIndexInfoNewSchema.getNT11();
/*  3736 */     this.nT12 = aLAIndexInfoNewSchema.getNT12();
/*  3737 */     this.nT13 = aLAIndexInfoNewSchema.getNT13();
/*  3738 */     this.nT14 = aLAIndexInfoNewSchema.getNT14();
/*  3739 */     this.nT15 = aLAIndexInfoNewSchema.getNT15();
/*  3740 */     this.nT16 = aLAIndexInfoNewSchema.getNT16();
/*  3741 */     this.nT17 = aLAIndexInfoNewSchema.getNT17();
/*  3742 */     this.nT18 = aLAIndexInfoNewSchema.getNT18();
/*  3743 */     this.nT19 = aLAIndexInfoNewSchema.getNT19();
/*  3744 */     this.nT20 = aLAIndexInfoNewSchema.getNT20();
/*  3745 */     this.nT21 = aLAIndexInfoNewSchema.getNT21();
/*  3746 */     this.nT22 = aLAIndexInfoNewSchema.getNT22();
/*  3747 */     this.nT23 = aLAIndexInfoNewSchema.getNT23();
/*  3748 */     this.nT24 = aLAIndexInfoNewSchema.getNT24();
/*  3749 */     this.nT25 = aLAIndexInfoNewSchema.getNT25();
/*  3750 */     this.nT26 = aLAIndexInfoNewSchema.getNT26();
/*  3751 */     this.nT27 = aLAIndexInfoNewSchema.getNT27();
/*  3752 */     this.nT28 = aLAIndexInfoNewSchema.getNT28();
/*  3753 */     this.nT29 = aLAIndexInfoNewSchema.getNT29();
/*  3754 */     this.nT30 = aLAIndexInfoNewSchema.getNT30();
/*  3755 */     this.nT31 = aLAIndexInfoNewSchema.getNT31();
/*  3756 */     this.nT32 = aLAIndexInfoNewSchema.getNT32();
/*  3757 */     this.nT33 = aLAIndexInfoNewSchema.getNT33();
/*  3758 */     this.nT34 = aLAIndexInfoNewSchema.getNT34();
/*  3759 */     this.nT35 = aLAIndexInfoNewSchema.getNT35();
/*  3760 */     this.nT36 = aLAIndexInfoNewSchema.getNT36();
/*  3761 */     this.nT37 = aLAIndexInfoNewSchema.getNT37();
/*  3762 */     this.nT38 = aLAIndexInfoNewSchema.getNT38();
/*  3763 */     this.nT39 = aLAIndexInfoNewSchema.getNT39();
/*  3764 */     this.nT40 = aLAIndexInfoNewSchema.getNT40();
/*  3765 */     this.nT41 = aLAIndexInfoNewSchema.getNT41();
/*  3766 */     this.nT42 = aLAIndexInfoNewSchema.getNT42();
/*  3767 */     this.nT43 = aLAIndexInfoNewSchema.getNT43();
/*  3768 */     this.nT44 = aLAIndexInfoNewSchema.getNT44();
/*  3769 */     this.nT45 = aLAIndexInfoNewSchema.getNT45();
/*  3770 */     this.nT46 = aLAIndexInfoNewSchema.getNT46();
/*  3771 */     this.nT47 = aLAIndexInfoNewSchema.getNT47();
/*  3772 */     this.nT48 = aLAIndexInfoNewSchema.getNT48();
/*  3773 */     this.nT49 = aLAIndexInfoNewSchema.getNT49();
/*  3774 */     this.nT50 = aLAIndexInfoNewSchema.getNT50();
/*  3775 */     this.nT51 = aLAIndexInfoNewSchema.getNT51();
/*  3776 */     this.nT52 = aLAIndexInfoNewSchema.getNT52();
/*  3777 */     this.nT53 = aLAIndexInfoNewSchema.getNT53();
/*  3778 */     this.nT54 = aLAIndexInfoNewSchema.getNT54();
/*  3779 */     this.nT55 = aLAIndexInfoNewSchema.getNT55();
/*  3780 */     this.nT56 = aLAIndexInfoNewSchema.getNT56();
/*  3781 */     this.nT57 = aLAIndexInfoNewSchema.getNT57();
/*  3782 */     this.nT58 = aLAIndexInfoNewSchema.getNT58();
/*  3783 */     this.nT59 = aLAIndexInfoNewSchema.getNT59();
/*  3784 */     this.nT60 = aLAIndexInfoNewSchema.getNT60();
/*  3785 */     this.nT61 = aLAIndexInfoNewSchema.getNT61();
/*  3786 */     this.nT62 = aLAIndexInfoNewSchema.getNT62();
/*  3787 */     this.nT63 = aLAIndexInfoNewSchema.getNT63();
/*  3788 */     this.nT64 = aLAIndexInfoNewSchema.getNT64();
/*  3789 */     this.nT65 = aLAIndexInfoNewSchema.getNT65();
/*  3790 */     this.nT66 = aLAIndexInfoNewSchema.getNT66();
/*  3791 */     this.nT67 = aLAIndexInfoNewSchema.getNT67();
/*  3792 */     this.nT68 = aLAIndexInfoNewSchema.getNT68();
/*  3793 */     this.nT69 = aLAIndexInfoNewSchema.getNT69();
/*  3794 */     this.nT70 = aLAIndexInfoNewSchema.getNT70();
/*  3795 */     this.nT71 = aLAIndexInfoNewSchema.getNT71();
/*  3796 */     this.nT72 = aLAIndexInfoNewSchema.getNT72();
/*  3797 */     this.nT73 = aLAIndexInfoNewSchema.getNT73();
/*  3798 */     this.nT74 = aLAIndexInfoNewSchema.getNT74();
/*  3799 */     this.nT75 = aLAIndexInfoNewSchema.getNT75();
/*  3800 */     this.nT76 = aLAIndexInfoNewSchema.getNT76();
/*  3801 */     this.nT77 = aLAIndexInfoNewSchema.getNT77();
/*  3802 */     this.nT78 = aLAIndexInfoNewSchema.getNT78();
/*  3803 */     this.nT79 = aLAIndexInfoNewSchema.getNT79();
/*  3804 */     this.nT80 = aLAIndexInfoNewSchema.getNT80();
/*  3805 */     this.nF01 = aLAIndexInfoNewSchema.getNF01();
/*  3806 */     this.nF02 = aLAIndexInfoNewSchema.getNF02();
/*  3807 */     this.nF03 = aLAIndexInfoNewSchema.getNF03();
/*  3808 */     this.nF04 = aLAIndexInfoNewSchema.getNF04();
/*  3809 */     this.nF05 = aLAIndexInfoNewSchema.getNF05();
/*  3810 */     this.nF06 = aLAIndexInfoNewSchema.getNF06();
/*  3811 */     this.nF07 = aLAIndexInfoNewSchema.getNF07();
/*  3812 */     this.nF08 = aLAIndexInfoNewSchema.getNF08();
/*  3813 */     this.nF09 = aLAIndexInfoNewSchema.getNF09();
/*  3814 */     this.nF10 = aLAIndexInfoNewSchema.getNF10();
/*  3815 */     this.nS01 = aLAIndexInfoNewSchema.getNS01();
/*  3816 */     this.nS02 = aLAIndexInfoNewSchema.getNS02();
/*  3817 */     this.nS03 = aLAIndexInfoNewSchema.getNS03();
/*  3818 */     this.nS04 = aLAIndexInfoNewSchema.getNS04();
/*  3819 */     this.nS05 = aLAIndexInfoNewSchema.getNS05();
/*  3820 */     this.nS06 = aLAIndexInfoNewSchema.getNS06();
/*  3821 */     this.nS07 = aLAIndexInfoNewSchema.getNS07();
/*  3822 */     this.nS08 = aLAIndexInfoNewSchema.getNS08();
/*  3823 */     this.nS09 = aLAIndexInfoNewSchema.getNS09();
/*  3824 */     this.nS10 = aLAIndexInfoNewSchema.getNS10();
/*  3825 */     this.iNT01 = aLAIndexInfoNewSchema.getINT01();
/*  3826 */     this.iNT02 = aLAIndexInfoNewSchema.getINT02();
/*  3827 */     this.iNT03 = aLAIndexInfoNewSchema.getINT03();
/*  3828 */     this.iNT04 = aLAIndexInfoNewSchema.getINT04();
/*  3829 */     this.iNT05 = aLAIndexInfoNewSchema.getINT05();
/*  3830 */     this.iNT06 = aLAIndexInfoNewSchema.getINT06();
/*  3831 */     this.iNT07 = aLAIndexInfoNewSchema.getINT07();
/*  3832 */     this.iNT08 = aLAIndexInfoNewSchema.getINT08();
/*  3833 */     this.iNT09 = aLAIndexInfoNewSchema.getINT09();
/*  3834 */     this.iNT10 = aLAIndexInfoNewSchema.getINT10();
/*  3835 */     this.iNT11 = aLAIndexInfoNewSchema.getINT11();
/*  3836 */     this.iNT12 = aLAIndexInfoNewSchema.getINT12();
/*  3837 */     this.iNT13 = aLAIndexInfoNewSchema.getINT13();
/*  3838 */     this.iNT14 = aLAIndexInfoNewSchema.getINT14();
/*  3839 */     this.iNT15 = aLAIndexInfoNewSchema.getINT15();
/*  3840 */     this.iNT16 = aLAIndexInfoNewSchema.getINT16();
/*  3841 */     this.iNT17 = aLAIndexInfoNewSchema.getINT17();
/*  3842 */     this.iNT18 = aLAIndexInfoNewSchema.getINT18();
/*  3843 */     this.iNT19 = aLAIndexInfoNewSchema.getINT19();
/*  3844 */     this.iNT20 = aLAIndexInfoNewSchema.getINT20();
/*  3845 */     this.iNT21 = aLAIndexInfoNewSchema.getINT21();
/*  3846 */     this.iNT22 = aLAIndexInfoNewSchema.getINT22();
/*  3847 */     this.iNT23 = aLAIndexInfoNewSchema.getINT23();
/*  3848 */     this.iNT24 = aLAIndexInfoNewSchema.getINT24();
/*  3849 */     this.iNT25 = aLAIndexInfoNewSchema.getINT25();
/*  3850 */     this.v1 = aLAIndexInfoNewSchema.getV1();
/*  3851 */     this.v2 = aLAIndexInfoNewSchema.getV2();
/*  3852 */     this.v3 = aLAIndexInfoNewSchema.getV3();
/*  3853 */     this.v4 = aLAIndexInfoNewSchema.getV4();
/*  3854 */     this.v5 = aLAIndexInfoNewSchema.getV5();
/*  3855 */     this.v6 = aLAIndexInfoNewSchema.getV6();
/*  3856 */     this.v7 = aLAIndexInfoNewSchema.getV7();
/*  3857 */     this.v8 = aLAIndexInfoNewSchema.getV8();
/*  3858 */     this.v9 = aLAIndexInfoNewSchema.getV9();
/*  3859 */     this.v10 = aLAIndexInfoNewSchema.getV10();
/*  3860 */     this.v11 = aLAIndexInfoNewSchema.getV11();
/*  3861 */     this.v12 = aLAIndexInfoNewSchema.getV12();
/*  3862 */     this.v13 = aLAIndexInfoNewSchema.getV13();
/*  3863 */     this.v14 = aLAIndexInfoNewSchema.getV14();
/*  3864 */     this.v15 = aLAIndexInfoNewSchema.getV15();
/*  3865 */     this.v16 = aLAIndexInfoNewSchema.getV16();
/*  3866 */     this.v17 = aLAIndexInfoNewSchema.getV17();
/*  3867 */     this.v18 = aLAIndexInfoNewSchema.getV18();
/*  3868 */     this.v19 = aLAIndexInfoNewSchema.getV19();
/*  3869 */     this.v20 = aLAIndexInfoNewSchema.getV20();
/*  3870 */     this.vT1 = aLAIndexInfoNewSchema.getVT1();
/*  3871 */     this.vT2 = aLAIndexInfoNewSchema.getVT2();
/*  3872 */     this.vT3 = aLAIndexInfoNewSchema.getVT3();
/*  3873 */     this.vT4 = aLAIndexInfoNewSchema.getVT4();
/*  3874 */     this.vT5 = aLAIndexInfoNewSchema.getVT5();
/*  3875 */     this.vT6 = aLAIndexInfoNewSchema.getVT6();
/*  3876 */     this.vT7 = aLAIndexInfoNewSchema.getVT7();
/*  3877 */     this.vT8 = aLAIndexInfoNewSchema.getVT8();
/*  3878 */     this.vE1 = aLAIndexInfoNewSchema.getVE1();
/*  3879 */     this.vE2 = aLAIndexInfoNewSchema.getVE2();
/*  3880 */     this.vE3 = aLAIndexInfoNewSchema.getVE3();
/*  3881 */     this.vE4 = aLAIndexInfoNewSchema.getVE4();
/*  3882 */     this.vE5 = aLAIndexInfoNewSchema.getVE5();
/*  3883 */     this.vE6 = aLAIndexInfoNewSchema.getVE6();
/*  3884 */     this.vE7 = aLAIndexInfoNewSchema.getVE7();
/*  3885 */     this.vE8 = aLAIndexInfoNewSchema.getVE8();
/*  3886 */     this.vE9 = aLAIndexInfoNewSchema.getVE9();
/*  3887 */     this.vE10 = aLAIndexInfoNewSchema.getVE10();
/*  3888 */     this.d1 = this.fDate.getDate(aLAIndexInfoNewSchema.getD1());
/*  3889 */     this.d2 = this.fDate.getDate(aLAIndexInfoNewSchema.getD2());
/*  3890 */     this.d3 = this.fDate.getDate(aLAIndexInfoNewSchema.getD3());
/*  3891 */     this.d4 = this.fDate.getDate(aLAIndexInfoNewSchema.getD4());
/*  3892 */     this.d5 = this.fDate.getDate(aLAIndexInfoNewSchema.getD5());
/*  3893 */     this.d6 = this.fDate.getDate(aLAIndexInfoNewSchema.getD6());
/*  3894 */     this.d7 = this.fDate.getDate(aLAIndexInfoNewSchema.getD7());
/*  3895 */     this.d8 = this.fDate.getDate(aLAIndexInfoNewSchema.getD8());
/*  3896 */     this.d9 = this.fDate.getDate(aLAIndexInfoNewSchema.getD9());
/*  3897 */     this.d10 = this.fDate.getDate(aLAIndexInfoNewSchema.getD10());
/*  3898 */     this.state = aLAIndexInfoNewSchema.getState();
/*  3899 */     this.operator = aLAIndexInfoNewSchema.getOperator();
/*  3900 */     this.makeDate = this.fDate.getDate(aLAIndexInfoNewSchema.getMakeDate());
/*  3901 */     this.makeTime = aLAIndexInfoNewSchema.getMakeTime();
/*  3902 */     this.modifyDate = this.fDate.getDate(aLAIndexInfoNewSchema.getModifyDate());
/*  3903 */     this.modifyTime = aLAIndexInfoNewSchema.getModifyTime();
/*       */   }
/*       */ 
/*       */   public boolean setSchema(ResultSet rs, int i)
/*       */   {
/*       */     try
/*       */     {
/*  3912 */       if (rs.getString("IndexCalNo") == null)
/*  3913 */         this.indexCalNo = null;
/*       */       else {
/*  3915 */         this.indexCalNo = rs.getString("IndexCalNo").trim();
/*       */       }
/*  3917 */       if (rs.getString("IndexType") == null)
/*  3918 */         this.indexType = null;
/*       */       else {
/*  3920 */         this.indexType = rs.getString("IndexType").trim();
/*       */       }
/*  3922 */       if (rs.getString("ManageCom") == null)
/*  3923 */         this.manageCom = null;
/*       */       else {
/*  3925 */         this.manageCom = rs.getString("ManageCom").trim();
/*       */       }
/*  3927 */       if (rs.getString("AgentGroup") == null)
/*  3928 */         this.agentGroup = null;
/*       */       else {
/*  3930 */         this.agentGroup = rs.getString("AgentGroup").trim();
/*       */       }
/*  3932 */       if (rs.getString("BranchAttr") == null)
/*  3933 */         this.branchAttr = null;
/*       */       else {
/*  3935 */         this.branchAttr = rs.getString("BranchAttr").trim();
/*       */       }
/*  3937 */       if (rs.getString("AgentCode") == null)
/*  3938 */         this.agentCode = null;
/*       */       else {
/*  3940 */         this.agentCode = rs.getString("AgentCode").trim();
/*       */       }
/*  3942 */       if (rs.getString("AgentGrade") == null)
/*  3943 */         this.agentGrade = null;
/*       */       else {
/*  3945 */         this.agentGrade = rs.getString("AgentGrade").trim();
/*       */       }
/*  3947 */       if (rs.getString("AgentTitle") == null)
/*  3948 */         this.agentTitle = null;
/*       */       else {
/*  3950 */         this.agentTitle = rs.getString("AgentTitle").trim();
/*       */       }
/*  3952 */       this.quaBgnMark = rs.getInt("QuaBgnMark");
/*  3953 */       this.postMonths = rs.getInt("PostMonths");
/*  3954 */       if (rs.getString("AssessMonth") == null)
/*  3955 */         this.assessMonth = null;
/*       */       else {
/*  3957 */         this.assessMonth = rs.getString("AssessMonth").trim();
/*       */       }
/*  3959 */       if (rs.getString("AgentGrade1") == null)
/*  3960 */         this.agentGrade1 = null;
/*       */       else {
/*  3962 */         this.agentGrade1 = rs.getString("AgentGrade1").trim();
/*       */       }
/*  3964 */       if (rs.getString("AgentTitle1") == null)
/*  3965 */         this.agentTitle1 = null;
/*       */       else {
/*  3967 */         this.agentTitle1 = rs.getString("AgentTitle1").trim();
/*       */       }
/*  3969 */       if (rs.getString("AgentGrade2") == null)
/*  3970 */         this.agentGrade2 = null;
/*       */       else {
/*  3972 */         this.agentGrade2 = rs.getString("AgentGrade2").trim();
/*       */       }
/*  3974 */       if (rs.getString("AgentTitle2") == null)
/*  3975 */         this.agentTitle2 = null;
/*       */       else {
/*  3977 */         this.agentTitle2 = rs.getString("AgentTitle2").trim();
/*       */       }
/*  3979 */       if (rs.getString("AgentGrade3") == null)
/*  3980 */         this.agentGrade3 = null;
/*       */       else {
/*  3982 */         this.agentGrade3 = rs.getString("AgentGrade3").trim();
/*       */       }
/*  3984 */       if (rs.getString("AgentTitle3") == null)
/*  3985 */         this.agentTitle3 = null;
/*       */       else {
/*  3987 */         this.agentTitle3 = rs.getString("AgentTitle3").trim();
/*       */       }
/*  3989 */       this.startDate = rs.getDate("StartDate");
/*  3990 */       this.startEnd = rs.getDate("StartEnd");
/*  3991 */       this.startDate1 = rs.getDate("StartDate1");
/*  3992 */       this.startEnd1 = rs.getDate("StartEnd1");
/*  3993 */       this.startDate2 = rs.getDate("StartDate2");
/*  3994 */       this.startEnd2 = rs.getDate("StartEnd2");
/*  3995 */       this.startDate3 = rs.getDate("StartDate3");
/*  3996 */       this.startEnd3 = rs.getDate("StartEnd3");
/*  3997 */       this.startEnd4 = rs.getDate("StartEnd4");
/*  3998 */       this.startDate4 = rs.getDate("StartDate4");
/*  3999 */       this.serverMonths = rs.getInt("ServerMonths");
/*  4000 */       this.nT01 = rs.getDouble("NT01");
/*  4001 */       this.nT02 = rs.getDouble("NT02");
/*  4002 */       this.nT03 = rs.getDouble("NT03");
/*  4003 */       this.nT04 = rs.getDouble("NT04");
/*  4004 */       this.nT05 = rs.getDouble("NT05");
/*  4005 */       this.nT06 = rs.getDouble("NT06");
/*  4006 */       this.nT07 = rs.getDouble("NT07");
/*  4007 */       this.nT08 = rs.getDouble("NT08");
/*  4008 */       this.nT09 = rs.getDouble("NT09");
/*  4009 */       this.nT10 = rs.getDouble("NT10");
/*  4010 */       this.nT11 = rs.getDouble("NT11");
/*  4011 */       this.nT12 = rs.getDouble("NT12");
/*  4012 */       this.nT13 = rs.getDouble("NT13");
/*  4013 */       this.nT14 = rs.getDouble("NT14");
/*  4014 */       this.nT15 = rs.getDouble("NT15");
/*  4015 */       this.nT16 = rs.getDouble("NT16");
/*  4016 */       this.nT17 = rs.getDouble("NT17");
/*  4017 */       this.nT18 = rs.getDouble("NT18");
/*  4018 */       this.nT19 = rs.getDouble("NT19");
/*  4019 */       this.nT20 = rs.getDouble("NT20");
/*  4020 */       this.nT21 = rs.getDouble("NT21");
/*  4021 */       this.nT22 = rs.getDouble("NT22");
/*  4022 */       this.nT23 = rs.getDouble("NT23");
/*  4023 */       this.nT24 = rs.getDouble("NT24");
/*  4024 */       this.nT25 = rs.getDouble("NT25");
/*  4025 */       this.nT26 = rs.getDouble("NT26");
/*  4026 */       this.nT27 = rs.getDouble("NT27");
/*  4027 */       this.nT28 = rs.getDouble("NT28");
/*  4028 */       this.nT29 = rs.getDouble("NT29");
/*  4029 */       this.nT30 = rs.getDouble("NT30");
/*  4030 */       this.nT31 = rs.getDouble("NT31");
/*  4031 */       this.nT32 = rs.getDouble("NT32");
/*  4032 */       this.nT33 = rs.getDouble("NT33");
/*  4033 */       this.nT34 = rs.getDouble("NT34");
/*  4034 */       this.nT35 = rs.getDouble("NT35");
/*  4035 */       this.nT36 = rs.getDouble("NT36");
/*  4036 */       this.nT37 = rs.getDouble("NT37");
/*  4037 */       this.nT38 = rs.getDouble("NT38");
/*  4038 */       this.nT39 = rs.getDouble("NT39");
/*  4039 */       this.nT40 = rs.getDouble("NT40");
/*  4040 */       this.nT41 = rs.getDouble("NT41");
/*  4041 */       this.nT42 = rs.getDouble("NT42");
/*  4042 */       this.nT43 = rs.getDouble("NT43");
/*  4043 */       this.nT44 = rs.getDouble("NT44");
/*  4044 */       this.nT45 = rs.getDouble("NT45");
/*  4045 */       this.nT46 = rs.getDouble("NT46");
/*  4046 */       this.nT47 = rs.getDouble("NT47");
/*  4047 */       this.nT48 = rs.getDouble("NT48");
/*  4048 */       this.nT49 = rs.getDouble("NT49");
/*  4049 */       this.nT50 = rs.getDouble("NT50");
/*  4050 */       this.nT51 = rs.getDouble("NT51");
/*  4051 */       this.nT52 = rs.getDouble("NT52");
/*  4052 */       this.nT53 = rs.getDouble("NT53");
/*  4053 */       this.nT54 = rs.getDouble("NT54");
/*  4054 */       this.nT55 = rs.getDouble("NT55");
/*  4055 */       this.nT56 = rs.getDouble("NT56");
/*  4056 */       this.nT57 = rs.getDouble("NT57");
/*  4057 */       this.nT58 = rs.getDouble("NT58");
/*  4058 */       this.nT59 = rs.getDouble("NT59");
/*  4059 */       this.nT60 = rs.getDouble("NT60");
/*  4060 */       this.nT61 = rs.getDouble("NT61");
/*  4061 */       this.nT62 = rs.getDouble("NT62");
/*  4062 */       this.nT63 = rs.getDouble("NT63");
/*  4063 */       this.nT64 = rs.getDouble("NT64");
/*  4064 */       this.nT65 = rs.getDouble("NT65");
/*  4065 */       this.nT66 = rs.getDouble("NT66");
/*  4066 */       this.nT67 = rs.getDouble("NT67");
/*  4067 */       this.nT68 = rs.getDouble("NT68");
/*  4068 */       this.nT69 = rs.getDouble("NT69");
/*  4069 */       this.nT70 = rs.getDouble("NT70");
/*  4070 */       this.nT71 = rs.getDouble("NT71");
/*  4071 */       this.nT72 = rs.getDouble("NT72");
/*  4072 */       this.nT73 = rs.getDouble("NT73");
/*  4073 */       this.nT74 = rs.getDouble("NT74");
/*  4074 */       this.nT75 = rs.getDouble("NT75");
/*  4075 */       this.nT76 = rs.getDouble("NT76");
/*  4076 */       this.nT77 = rs.getDouble("NT77");
/*  4077 */       this.nT78 = rs.getDouble("NT78");
/*  4078 */       this.nT79 = rs.getDouble("NT79");
/*  4079 */       this.nT80 = rs.getDouble("NT80");
/*  4080 */       this.nF01 = rs.getDouble("NF01");
/*  4081 */       this.nF02 = rs.getDouble("NF02");
/*  4082 */       this.nF03 = rs.getDouble("NF03");
/*  4083 */       this.nF04 = rs.getDouble("NF04");
/*  4084 */       this.nF05 = rs.getDouble("NF05");
/*  4085 */       this.nF06 = rs.getDouble("NF06");
/*  4086 */       this.nF07 = rs.getDouble("NF07");
/*  4087 */       this.nF08 = rs.getDouble("NF08");
/*  4088 */       this.nF09 = rs.getDouble("NF09");
/*  4089 */       this.nF10 = rs.getDouble("NF10");
/*  4090 */       this.nS01 = rs.getDouble("NS01");
/*  4091 */       this.nS02 = rs.getDouble("NS02");
/*  4092 */       this.nS03 = rs.getDouble("NS03");
/*  4093 */       this.nS04 = rs.getDouble("NS04");
/*  4094 */       this.nS05 = rs.getDouble("NS05");
/*  4095 */       this.nS06 = rs.getDouble("NS06");
/*  4096 */       this.nS07 = rs.getDouble("NS07");
/*  4097 */       this.nS08 = rs.getDouble("NS08");
/*  4098 */       this.nS09 = rs.getDouble("NS09");
/*  4099 */       this.nS10 = rs.getDouble("NS10");
/*  4100 */       this.iNT01 = rs.getInt("INT01");
/*  4101 */       this.iNT02 = rs.getInt("INT02");
/*  4102 */       this.iNT03 = rs.getInt("INT03");
/*  4103 */       this.iNT04 = rs.getInt("INT04");
/*  4104 */       this.iNT05 = rs.getInt("INT05");
/*  4105 */       this.iNT06 = rs.getInt("INT06");
/*  4106 */       this.iNT07 = rs.getInt("INT07");
/*  4107 */       this.iNT08 = rs.getInt("INT08");
/*  4108 */       this.iNT09 = rs.getInt("INT09");
/*  4109 */       this.iNT10 = rs.getInt("INT10");
/*  4110 */       this.iNT11 = rs.getInt("INT11");
/*  4111 */       this.iNT12 = rs.getInt("INT12");
/*  4112 */       this.iNT13 = rs.getInt("INT13");
/*  4113 */       this.iNT14 = rs.getInt("INT14");
/*  4114 */       this.iNT15 = rs.getInt("INT15");
/*  4115 */       this.iNT16 = rs.getInt("INT16");
/*  4116 */       this.iNT17 = rs.getInt("INT17");
/*  4117 */       this.iNT18 = rs.getInt("INT18");
/*  4118 */       this.iNT19 = rs.getInt("INT19");
/*  4119 */       this.iNT20 = rs.getInt("INT20");
/*  4120 */       this.iNT21 = rs.getInt("INT21");
/*  4121 */       this.iNT22 = rs.getInt("INT22");
/*  4122 */       this.iNT23 = rs.getInt("INT23");
/*  4123 */       this.iNT24 = rs.getInt("INT24");
/*  4124 */       this.iNT25 = rs.getInt("INT25");
/*  4125 */       if (rs.getString("V1") == null)
/*  4126 */         this.v1 = null;
/*       */       else {
/*  4128 */         this.v1 = rs.getString("V1").trim();
/*       */       }
/*  4130 */       if (rs.getString("V2") == null)
/*  4131 */         this.v2 = null;
/*       */       else {
/*  4133 */         this.v2 = rs.getString("V2").trim();
/*       */       }
/*  4135 */       if (rs.getString("V3") == null)
/*  4136 */         this.v3 = null;
/*       */       else {
/*  4138 */         this.v3 = rs.getString("V3").trim();
/*       */       }
/*  4140 */       if (rs.getString("V4") == null)
/*  4141 */         this.v4 = null;
/*       */       else {
/*  4143 */         this.v4 = rs.getString("V4").trim();
/*       */       }
/*  4145 */       if (rs.getString("V5") == null)
/*  4146 */         this.v5 = null;
/*       */       else {
/*  4148 */         this.v5 = rs.getString("V5").trim();
/*       */       }
/*  4150 */       if (rs.getString("V6") == null)
/*  4151 */         this.v6 = null;
/*       */       else {
/*  4153 */         this.v6 = rs.getString("V6").trim();
/*       */       }
/*  4155 */       if (rs.getString("V7") == null)
/*  4156 */         this.v7 = null;
/*       */       else {
/*  4158 */         this.v7 = rs.getString("V7").trim();
/*       */       }
/*  4160 */       if (rs.getString("V8") == null)
/*  4161 */         this.v8 = null;
/*       */       else {
/*  4163 */         this.v8 = rs.getString("V8").trim();
/*       */       }
/*  4165 */       if (rs.getString("V9") == null)
/*  4166 */         this.v9 = null;
/*       */       else {
/*  4168 */         this.v9 = rs.getString("V9").trim();
/*       */       }
/*  4170 */       if (rs.getString("V10") == null)
/*  4171 */         this.v10 = null;
/*       */       else {
/*  4173 */         this.v10 = rs.getString("V10").trim();
/*       */       }
/*  4175 */       if (rs.getString("V11") == null)
/*  4176 */         this.v11 = null;
/*       */       else {
/*  4178 */         this.v11 = rs.getString("V11").trim();
/*       */       }
/*  4180 */       if (rs.getString("V12") == null)
/*  4181 */         this.v12 = null;
/*       */       else {
/*  4183 */         this.v12 = rs.getString("V12").trim();
/*       */       }
/*  4185 */       if (rs.getString("V13") == null)
/*  4186 */         this.v13 = null;
/*       */       else {
/*  4188 */         this.v13 = rs.getString("V13").trim();
/*       */       }
/*  4190 */       if (rs.getString("V14") == null)
/*  4191 */         this.v14 = null;
/*       */       else {
/*  4193 */         this.v14 = rs.getString("V14").trim();
/*       */       }
/*  4195 */       if (rs.getString("V15") == null)
/*  4196 */         this.v15 = null;
/*       */       else {
/*  4198 */         this.v15 = rs.getString("V15").trim();
/*       */       }
/*  4200 */       if (rs.getString("V16") == null)
/*  4201 */         this.v16 = null;
/*       */       else {
/*  4203 */         this.v16 = rs.getString("V16").trim();
/*       */       }
/*  4205 */       if (rs.getString("V17") == null)
/*  4206 */         this.v17 = null;
/*       */       else {
/*  4208 */         this.v17 = rs.getString("V17").trim();
/*       */       }
/*  4210 */       if (rs.getString("V18") == null)
/*  4211 */         this.v18 = null;
/*       */       else {
/*  4213 */         this.v18 = rs.getString("V18").trim();
/*       */       }
/*  4215 */       if (rs.getString("V19") == null)
/*  4216 */         this.v19 = null;
/*       */       else {
/*  4218 */         this.v19 = rs.getString("V19").trim();
/*       */       }
/*  4220 */       if (rs.getString("V20") == null)
/*  4221 */         this.v20 = null;
/*       */       else {
/*  4223 */         this.v20 = rs.getString("V20").trim();
/*       */       }
/*  4225 */       if (rs.getString("VT1") == null)
/*  4226 */         this.vT1 = null;
/*       */       else {
/*  4228 */         this.vT1 = rs.getString("VT1").trim();
/*       */       }
/*  4230 */       if (rs.getString("VT2") == null)
/*  4231 */         this.vT2 = null;
/*       */       else {
/*  4233 */         this.vT2 = rs.getString("VT2").trim();
/*       */       }
/*  4235 */       if (rs.getString("VT3") == null)
/*  4236 */         this.vT3 = null;
/*       */       else {
/*  4238 */         this.vT3 = rs.getString("VT3").trim();
/*       */       }
/*  4240 */       if (rs.getString("VT4") == null)
/*  4241 */         this.vT4 = null;
/*       */       else {
/*  4243 */         this.vT4 = rs.getString("VT4").trim();
/*       */       }
/*  4245 */       if (rs.getString("VT5") == null)
/*  4246 */         this.vT5 = null;
/*       */       else {
/*  4248 */         this.vT5 = rs.getString("VT5").trim();
/*       */       }
/*  4250 */       if (rs.getString("VT6") == null)
/*  4251 */         this.vT6 = null;
/*       */       else {
/*  4253 */         this.vT6 = rs.getString("VT6").trim();
/*       */       }
/*  4255 */       if (rs.getString("VT7") == null)
/*  4256 */         this.vT7 = null;
/*       */       else {
/*  4258 */         this.vT7 = rs.getString("VT7").trim();
/*       */       }
/*  4260 */       if (rs.getString("VT8") == null)
/*  4261 */         this.vT8 = null;
/*       */       else {
/*  4263 */         this.vT8 = rs.getString("VT8").trim();
/*       */       }
/*  4265 */       if (rs.getString("VE1") == null)
/*  4266 */         this.vE1 = null;
/*       */       else {
/*  4268 */         this.vE1 = rs.getString("VE1").trim();
/*       */       }
/*  4270 */       if (rs.getString("VE2") == null)
/*  4271 */         this.vE2 = null;
/*       */       else {
/*  4273 */         this.vE2 = rs.getString("VE2").trim();
/*       */       }
/*  4275 */       if (rs.getString("VE3") == null)
/*  4276 */         this.vE3 = null;
/*       */       else {
/*  4278 */         this.vE3 = rs.getString("VE3").trim();
/*       */       }
/*  4280 */       if (rs.getString("VE4") == null)
/*  4281 */         this.vE4 = null;
/*       */       else {
/*  4283 */         this.vE4 = rs.getString("VE4").trim();
/*       */       }
/*  4285 */       if (rs.getString("VE5") == null)
/*  4286 */         this.vE5 = null;
/*       */       else {
/*  4288 */         this.vE5 = rs.getString("VE5").trim();
/*       */       }
/*  4290 */       if (rs.getString("VE6") == null)
/*  4291 */         this.vE6 = null;
/*       */       else {
/*  4293 */         this.vE6 = rs.getString("VE6").trim();
/*       */       }
/*  4295 */       if (rs.getString("VE7") == null)
/*  4296 */         this.vE7 = null;
/*       */       else {
/*  4298 */         this.vE7 = rs.getString("VE7").trim();
/*       */       }
/*  4300 */       if (rs.getString("VE8") == null)
/*  4301 */         this.vE8 = null;
/*       */       else {
/*  4303 */         this.vE8 = rs.getString("VE8").trim();
/*       */       }
/*  4305 */       if (rs.getString("VE9") == null)
/*  4306 */         this.vE9 = null;
/*       */       else {
/*  4308 */         this.vE9 = rs.getString("VE9").trim();
/*       */       }
/*  4310 */       if (rs.getString("VE10") == null)
/*  4311 */         this.vE10 = null;
/*       */       else {
/*  4313 */         this.vE10 = rs.getString("VE10").trim();
/*       */       }
/*  4315 */       this.d1 = rs.getDate("D1");
/*  4316 */       this.d2 = rs.getDate("D2");
/*  4317 */       this.d3 = rs.getDate("D3");
/*  4318 */       this.d4 = rs.getDate("D4");
/*  4319 */       this.d5 = rs.getDate("D5");
/*  4320 */       this.d6 = rs.getDate("D6");
/*  4321 */       this.d7 = rs.getDate("D7");
/*  4322 */       this.d8 = rs.getDate("D8");
/*  4323 */       this.d9 = rs.getDate("D9");
/*  4324 */       this.d10 = rs.getDate("D10");
/*  4325 */       if (rs.getString("State") == null)
/*  4326 */         this.state = null;
/*       */       else {
/*  4328 */         this.state = rs.getString("State").trim();
/*       */       }
/*  4330 */       if (rs.getString("Operator") == null)
/*  4331 */         this.operator = null;
/*       */       else {
/*  4333 */         this.operator = rs.getString("Operator").trim();
/*       */       }
/*  4335 */       this.makeDate = rs.getDate("MakeDate");
/*  4336 */       if (rs.getString("MakeTime") == null)
/*  4337 */         this.makeTime = null;
/*       */       else {
/*  4339 */         this.makeTime = rs.getString("MakeTime").trim();
/*       */       }
/*  4341 */       this.modifyDate = rs.getDate("ModifyDate");
/*  4342 */       if (rs.getString("ModifyTime") == null)
/*  4343 */         this.modifyTime = null;
/*       */       else {
/*  4345 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*       */       }
/*       */     }
/*       */     catch (SQLException sqle)
/*       */     {
/*  4350 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684LAIndexInfoNew\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*       */ 
/*  4352 */       CError tError = new CError();
/*  4353 */       tError.moduleName = "LAIndexInfoNewSchema";
/*  4354 */       tError.functionName = "setSchema";
/*  4355 */       tError.errorMessage = sqle.toString();
/*  4356 */       this.mErrors.addOneError(tError);
/*  4357 */       return false;
/*       */     }
/*  4359 */     return true;
/*       */   }
/*       */ 
/*       */   public LAIndexInfoNewSchema getSchema()
/*       */   {
/*  4364 */     LAIndexInfoNewSchema aLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
/*  4365 */     aLAIndexInfoNewSchema.setSchema(this);
/*  4366 */     return aLAIndexInfoNewSchema;
/*       */   }
/*       */ 
/*       */   public LAIndexInfoNewDB getDB()
/*       */   {
/*  4371 */     LAIndexInfoNewDB aDBOper = new LAIndexInfoNewDB();
/*  4372 */     aDBOper.setSchema(this);
/*  4373 */     return aDBOper;
/*       */   }
/*       */ 
/*       */   public String encode()
/*       */   {
/*  4380 */     StringBuffer strReturn = new StringBuffer(256);
/*  4381 */     strReturn.append(StrTool.cTrim(this.indexCalNo)); strReturn.append("|");
/*  4382 */     strReturn.append(StrTool.cTrim(this.indexType)); strReturn.append("|");
/*  4383 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  4384 */     strReturn.append(StrTool.cTrim(this.agentGroup)); strReturn.append("|");
/*  4385 */     strReturn.append(StrTool.cTrim(this.branchAttr)); strReturn.append("|");
/*  4386 */     strReturn.append(StrTool.cTrim(this.agentCode)); strReturn.append("|");
/*  4387 */     strReturn.append(StrTool.cTrim(this.agentGrade)); strReturn.append("|");
/*  4388 */     strReturn.append(StrTool.cTrim(this.agentTitle)); strReturn.append("|");
/*  4389 */     strReturn.append(ChgData.chgData(this.quaBgnMark)); strReturn.append("|");
/*  4390 */     strReturn.append(ChgData.chgData(this.postMonths)); strReturn.append("|");
/*  4391 */     strReturn.append(StrTool.cTrim(this.assessMonth)); strReturn.append("|");
/*  4392 */     strReturn.append(StrTool.cTrim(this.agentGrade1)); strReturn.append("|");
/*  4393 */     strReturn.append(StrTool.cTrim(this.agentTitle1)); strReturn.append("|");
/*  4394 */     strReturn.append(StrTool.cTrim(this.agentGrade2)); strReturn.append("|");
/*  4395 */     strReturn.append(StrTool.cTrim(this.agentTitle2)); strReturn.append("|");
/*  4396 */     strReturn.append(StrTool.cTrim(this.agentGrade3)); strReturn.append("|");
/*  4397 */     strReturn.append(StrTool.cTrim(this.agentTitle3)); strReturn.append("|");
/*  4398 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/*  4399 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd))); strReturn.append("|");
/*  4400 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate1))); strReturn.append("|");
/*  4401 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd1))); strReturn.append("|");
/*  4402 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate2))); strReturn.append("|");
/*  4403 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd2))); strReturn.append("|");
/*  4404 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate3))); strReturn.append("|");
/*  4405 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd3))); strReturn.append("|");
/*  4406 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startEnd4))); strReturn.append("|");
/*  4407 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate4))); strReturn.append("|");
/*  4408 */     strReturn.append(ChgData.chgData(this.serverMonths)); strReturn.append("|");
/*  4409 */     strReturn.append(ChgData.chgData(this.nT01)); strReturn.append("|");
/*  4410 */     strReturn.append(ChgData.chgData(this.nT02)); strReturn.append("|");
/*  4411 */     strReturn.append(ChgData.chgData(this.nT03)); strReturn.append("|");
/*  4412 */     strReturn.append(ChgData.chgData(this.nT04)); strReturn.append("|");
/*  4413 */     strReturn.append(ChgData.chgData(this.nT05)); strReturn.append("|");
/*  4414 */     strReturn.append(ChgData.chgData(this.nT06)); strReturn.append("|");
/*  4415 */     strReturn.append(ChgData.chgData(this.nT07)); strReturn.append("|");
/*  4416 */     strReturn.append(ChgData.chgData(this.nT08)); strReturn.append("|");
/*  4417 */     strReturn.append(ChgData.chgData(this.nT09)); strReturn.append("|");
/*  4418 */     strReturn.append(ChgData.chgData(this.nT10)); strReturn.append("|");
/*  4419 */     strReturn.append(ChgData.chgData(this.nT11)); strReturn.append("|");
/*  4420 */     strReturn.append(ChgData.chgData(this.nT12)); strReturn.append("|");
/*  4421 */     strReturn.append(ChgData.chgData(this.nT13)); strReturn.append("|");
/*  4422 */     strReturn.append(ChgData.chgData(this.nT14)); strReturn.append("|");
/*  4423 */     strReturn.append(ChgData.chgData(this.nT15)); strReturn.append("|");
/*  4424 */     strReturn.append(ChgData.chgData(this.nT16)); strReturn.append("|");
/*  4425 */     strReturn.append(ChgData.chgData(this.nT17)); strReturn.append("|");
/*  4426 */     strReturn.append(ChgData.chgData(this.nT18)); strReturn.append("|");
/*  4427 */     strReturn.append(ChgData.chgData(this.nT19)); strReturn.append("|");
/*  4428 */     strReturn.append(ChgData.chgData(this.nT20)); strReturn.append("|");
/*  4429 */     strReturn.append(ChgData.chgData(this.nT21)); strReturn.append("|");
/*  4430 */     strReturn.append(ChgData.chgData(this.nT22)); strReturn.append("|");
/*  4431 */     strReturn.append(ChgData.chgData(this.nT23)); strReturn.append("|");
/*  4432 */     strReturn.append(ChgData.chgData(this.nT24)); strReturn.append("|");
/*  4433 */     strReturn.append(ChgData.chgData(this.nT25)); strReturn.append("|");
/*  4434 */     strReturn.append(ChgData.chgData(this.nT26)); strReturn.append("|");
/*  4435 */     strReturn.append(ChgData.chgData(this.nT27)); strReturn.append("|");
/*  4436 */     strReturn.append(ChgData.chgData(this.nT28)); strReturn.append("|");
/*  4437 */     strReturn.append(ChgData.chgData(this.nT29)); strReturn.append("|");
/*  4438 */     strReturn.append(ChgData.chgData(this.nT30)); strReturn.append("|");
/*  4439 */     strReturn.append(ChgData.chgData(this.nT31)); strReturn.append("|");
/*  4440 */     strReturn.append(ChgData.chgData(this.nT32)); strReturn.append("|");
/*  4441 */     strReturn.append(ChgData.chgData(this.nT33)); strReturn.append("|");
/*  4442 */     strReturn.append(ChgData.chgData(this.nT34)); strReturn.append("|");
/*  4443 */     strReturn.append(ChgData.chgData(this.nT35)); strReturn.append("|");
/*  4444 */     strReturn.append(ChgData.chgData(this.nT36)); strReturn.append("|");
/*  4445 */     strReturn.append(ChgData.chgData(this.nT37)); strReturn.append("|");
/*  4446 */     strReturn.append(ChgData.chgData(this.nT38)); strReturn.append("|");
/*  4447 */     strReturn.append(ChgData.chgData(this.nT39)); strReturn.append("|");
/*  4448 */     strReturn.append(ChgData.chgData(this.nT40)); strReturn.append("|");
/*  4449 */     strReturn.append(ChgData.chgData(this.nT41)); strReturn.append("|");
/*  4450 */     strReturn.append(ChgData.chgData(this.nT42)); strReturn.append("|");
/*  4451 */     strReturn.append(ChgData.chgData(this.nT43)); strReturn.append("|");
/*  4452 */     strReturn.append(ChgData.chgData(this.nT44)); strReturn.append("|");
/*  4453 */     strReturn.append(ChgData.chgData(this.nT45)); strReturn.append("|");
/*  4454 */     strReturn.append(ChgData.chgData(this.nT46)); strReturn.append("|");
/*  4455 */     strReturn.append(ChgData.chgData(this.nT47)); strReturn.append("|");
/*  4456 */     strReturn.append(ChgData.chgData(this.nT48)); strReturn.append("|");
/*  4457 */     strReturn.append(ChgData.chgData(this.nT49)); strReturn.append("|");
/*  4458 */     strReturn.append(ChgData.chgData(this.nT50)); strReturn.append("|");
/*  4459 */     strReturn.append(ChgData.chgData(this.nT51)); strReturn.append("|");
/*  4460 */     strReturn.append(ChgData.chgData(this.nT52)); strReturn.append("|");
/*  4461 */     strReturn.append(ChgData.chgData(this.nT53)); strReturn.append("|");
/*  4462 */     strReturn.append(ChgData.chgData(this.nT54)); strReturn.append("|");
/*  4463 */     strReturn.append(ChgData.chgData(this.nT55)); strReturn.append("|");
/*  4464 */     strReturn.append(ChgData.chgData(this.nT56)); strReturn.append("|");
/*  4465 */     strReturn.append(ChgData.chgData(this.nT57)); strReturn.append("|");
/*  4466 */     strReturn.append(ChgData.chgData(this.nT58)); strReturn.append("|");
/*  4467 */     strReturn.append(ChgData.chgData(this.nT59)); strReturn.append("|");
/*  4468 */     strReturn.append(ChgData.chgData(this.nT60)); strReturn.append("|");
/*  4469 */     strReturn.append(ChgData.chgData(this.nT61)); strReturn.append("|");
/*  4470 */     strReturn.append(ChgData.chgData(this.nT62)); strReturn.append("|");
/*  4471 */     strReturn.append(ChgData.chgData(this.nT63)); strReturn.append("|");
/*  4472 */     strReturn.append(ChgData.chgData(this.nT64)); strReturn.append("|");
/*  4473 */     strReturn.append(ChgData.chgData(this.nT65)); strReturn.append("|");
/*  4474 */     strReturn.append(ChgData.chgData(this.nT66)); strReturn.append("|");
/*  4475 */     strReturn.append(ChgData.chgData(this.nT67)); strReturn.append("|");
/*  4476 */     strReturn.append(ChgData.chgData(this.nT68)); strReturn.append("|");
/*  4477 */     strReturn.append(ChgData.chgData(this.nT69)); strReturn.append("|");
/*  4478 */     strReturn.append(ChgData.chgData(this.nT70)); strReturn.append("|");
/*  4479 */     strReturn.append(ChgData.chgData(this.nT71)); strReturn.append("|");
/*  4480 */     strReturn.append(ChgData.chgData(this.nT72)); strReturn.append("|");
/*  4481 */     strReturn.append(ChgData.chgData(this.nT73)); strReturn.append("|");
/*  4482 */     strReturn.append(ChgData.chgData(this.nT74)); strReturn.append("|");
/*  4483 */     strReturn.append(ChgData.chgData(this.nT75)); strReturn.append("|");
/*  4484 */     strReturn.append(ChgData.chgData(this.nT76)); strReturn.append("|");
/*  4485 */     strReturn.append(ChgData.chgData(this.nT77)); strReturn.append("|");
/*  4486 */     strReturn.append(ChgData.chgData(this.nT78)); strReturn.append("|");
/*  4487 */     strReturn.append(ChgData.chgData(this.nT79)); strReturn.append("|");
/*  4488 */     strReturn.append(ChgData.chgData(this.nT80)); strReturn.append("|");
/*  4489 */     strReturn.append(ChgData.chgData(this.nF01)); strReturn.append("|");
/*  4490 */     strReturn.append(ChgData.chgData(this.nF02)); strReturn.append("|");
/*  4491 */     strReturn.append(ChgData.chgData(this.nF03)); strReturn.append("|");
/*  4492 */     strReturn.append(ChgData.chgData(this.nF04)); strReturn.append("|");
/*  4493 */     strReturn.append(ChgData.chgData(this.nF05)); strReturn.append("|");
/*  4494 */     strReturn.append(ChgData.chgData(this.nF06)); strReturn.append("|");
/*  4495 */     strReturn.append(ChgData.chgData(this.nF07)); strReturn.append("|");
/*  4496 */     strReturn.append(ChgData.chgData(this.nF08)); strReturn.append("|");
/*  4497 */     strReturn.append(ChgData.chgData(this.nF09)); strReturn.append("|");
/*  4498 */     strReturn.append(ChgData.chgData(this.nF10)); strReturn.append("|");
/*  4499 */     strReturn.append(ChgData.chgData(this.nS01)); strReturn.append("|");
/*  4500 */     strReturn.append(ChgData.chgData(this.nS02)); strReturn.append("|");
/*  4501 */     strReturn.append(ChgData.chgData(this.nS03)); strReturn.append("|");
/*  4502 */     strReturn.append(ChgData.chgData(this.nS04)); strReturn.append("|");
/*  4503 */     strReturn.append(ChgData.chgData(this.nS05)); strReturn.append("|");
/*  4504 */     strReturn.append(ChgData.chgData(this.nS06)); strReturn.append("|");
/*  4505 */     strReturn.append(ChgData.chgData(this.nS07)); strReturn.append("|");
/*  4506 */     strReturn.append(ChgData.chgData(this.nS08)); strReturn.append("|");
/*  4507 */     strReturn.append(ChgData.chgData(this.nS09)); strReturn.append("|");
/*  4508 */     strReturn.append(ChgData.chgData(this.nS10)); strReturn.append("|");
/*  4509 */     strReturn.append(ChgData.chgData(this.iNT01)); strReturn.append("|");
/*  4510 */     strReturn.append(ChgData.chgData(this.iNT02)); strReturn.append("|");
/*  4511 */     strReturn.append(ChgData.chgData(this.iNT03)); strReturn.append("|");
/*  4512 */     strReturn.append(ChgData.chgData(this.iNT04)); strReturn.append("|");
/*  4513 */     strReturn.append(ChgData.chgData(this.iNT05)); strReturn.append("|");
/*  4514 */     strReturn.append(ChgData.chgData(this.iNT06)); strReturn.append("|");
/*  4515 */     strReturn.append(ChgData.chgData(this.iNT07)); strReturn.append("|");
/*  4516 */     strReturn.append(ChgData.chgData(this.iNT08)); strReturn.append("|");
/*  4517 */     strReturn.append(ChgData.chgData(this.iNT09)); strReturn.append("|");
/*  4518 */     strReturn.append(ChgData.chgData(this.iNT10)); strReturn.append("|");
/*  4519 */     strReturn.append(ChgData.chgData(this.iNT11)); strReturn.append("|");
/*  4520 */     strReturn.append(ChgData.chgData(this.iNT12)); strReturn.append("|");
/*  4521 */     strReturn.append(ChgData.chgData(this.iNT13)); strReturn.append("|");
/*  4522 */     strReturn.append(ChgData.chgData(this.iNT14)); strReturn.append("|");
/*  4523 */     strReturn.append(ChgData.chgData(this.iNT15)); strReturn.append("|");
/*  4524 */     strReturn.append(ChgData.chgData(this.iNT16)); strReturn.append("|");
/*  4525 */     strReturn.append(ChgData.chgData(this.iNT17)); strReturn.append("|");
/*  4526 */     strReturn.append(ChgData.chgData(this.iNT18)); strReturn.append("|");
/*  4527 */     strReturn.append(ChgData.chgData(this.iNT19)); strReturn.append("|");
/*  4528 */     strReturn.append(ChgData.chgData(this.iNT20)); strReturn.append("|");
/*  4529 */     strReturn.append(ChgData.chgData(this.iNT21)); strReturn.append("|");
/*  4530 */     strReturn.append(ChgData.chgData(this.iNT22)); strReturn.append("|");
/*  4531 */     strReturn.append(ChgData.chgData(this.iNT23)); strReturn.append("|");
/*  4532 */     strReturn.append(ChgData.chgData(this.iNT24)); strReturn.append("|");
/*  4533 */     strReturn.append(ChgData.chgData(this.iNT25)); strReturn.append("|");
/*  4534 */     strReturn.append(StrTool.cTrim(this.v1)); strReturn.append("|");
/*  4535 */     strReturn.append(StrTool.cTrim(this.v2)); strReturn.append("|");
/*  4536 */     strReturn.append(StrTool.cTrim(this.v3)); strReturn.append("|");
/*  4537 */     strReturn.append(StrTool.cTrim(this.v4)); strReturn.append("|");
/*  4538 */     strReturn.append(StrTool.cTrim(this.v5)); strReturn.append("|");
/*  4539 */     strReturn.append(StrTool.cTrim(this.v6)); strReturn.append("|");
/*  4540 */     strReturn.append(StrTool.cTrim(this.v7)); strReturn.append("|");
/*  4541 */     strReturn.append(StrTool.cTrim(this.v8)); strReturn.append("|");
/*  4542 */     strReturn.append(StrTool.cTrim(this.v9)); strReturn.append("|");
/*  4543 */     strReturn.append(StrTool.cTrim(this.v10)); strReturn.append("|");
/*  4544 */     strReturn.append(StrTool.cTrim(this.v11)); strReturn.append("|");
/*  4545 */     strReturn.append(StrTool.cTrim(this.v12)); strReturn.append("|");
/*  4546 */     strReturn.append(StrTool.cTrim(this.v13)); strReturn.append("|");
/*  4547 */     strReturn.append(StrTool.cTrim(this.v14)); strReturn.append("|");
/*  4548 */     strReturn.append(StrTool.cTrim(this.v15)); strReturn.append("|");
/*  4549 */     strReturn.append(StrTool.cTrim(this.v16)); strReturn.append("|");
/*  4550 */     strReturn.append(StrTool.cTrim(this.v17)); strReturn.append("|");
/*  4551 */     strReturn.append(StrTool.cTrim(this.v18)); strReturn.append("|");
/*  4552 */     strReturn.append(StrTool.cTrim(this.v19)); strReturn.append("|");
/*  4553 */     strReturn.append(StrTool.cTrim(this.v20)); strReturn.append("|");
/*  4554 */     strReturn.append(StrTool.cTrim(this.vT1)); strReturn.append("|");
/*  4555 */     strReturn.append(StrTool.cTrim(this.vT2)); strReturn.append("|");
/*  4556 */     strReturn.append(StrTool.cTrim(this.vT3)); strReturn.append("|");
/*  4557 */     strReturn.append(StrTool.cTrim(this.vT4)); strReturn.append("|");
/*  4558 */     strReturn.append(StrTool.cTrim(this.vT5)); strReturn.append("|");
/*  4559 */     strReturn.append(StrTool.cTrim(this.vT6)); strReturn.append("|");
/*  4560 */     strReturn.append(StrTool.cTrim(this.vT7)); strReturn.append("|");
/*  4561 */     strReturn.append(StrTool.cTrim(this.vT8)); strReturn.append("|");
/*  4562 */     strReturn.append(StrTool.cTrim(this.vE1)); strReturn.append("|");
/*  4563 */     strReturn.append(StrTool.cTrim(this.vE2)); strReturn.append("|");
/*  4564 */     strReturn.append(StrTool.cTrim(this.vE3)); strReturn.append("|");
/*  4565 */     strReturn.append(StrTool.cTrim(this.vE4)); strReturn.append("|");
/*  4566 */     strReturn.append(StrTool.cTrim(this.vE5)); strReturn.append("|");
/*  4567 */     strReturn.append(StrTool.cTrim(this.vE6)); strReturn.append("|");
/*  4568 */     strReturn.append(StrTool.cTrim(this.vE7)); strReturn.append("|");
/*  4569 */     strReturn.append(StrTool.cTrim(this.vE8)); strReturn.append("|");
/*  4570 */     strReturn.append(StrTool.cTrim(this.vE9)); strReturn.append("|");
/*  4571 */     strReturn.append(StrTool.cTrim(this.vE10)); strReturn.append("|");
/*  4572 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d1))); strReturn.append("|");
/*  4573 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d2))); strReturn.append("|");
/*  4574 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d3))); strReturn.append("|");
/*  4575 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d4))); strReturn.append("|");
/*  4576 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d5))); strReturn.append("|");
/*  4577 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d6))); strReturn.append("|");
/*  4578 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d7))); strReturn.append("|");
/*  4579 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d8))); strReturn.append("|");
/*  4580 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d9))); strReturn.append("|");
/*  4581 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.d10))); strReturn.append("|");
/*  4582 */     strReturn.append(StrTool.cTrim(this.state)); strReturn.append("|");
/*  4583 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  4584 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  4585 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  4586 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  4587 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  4588 */     return strReturn.toString();
/*       */   }
/*       */ 
/*       */   public boolean decode(String strMessage)
/*       */   {
/*       */     try
/*       */     {
/*  4596 */       this.indexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  4597 */       this.indexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  4598 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  4599 */       this.agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  4600 */       this.branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  4601 */       this.agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  4602 */       this.agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  4603 */       this.agentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  4604 */       this.quaBgnMark = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).intValue();
/*  4605 */       this.postMonths = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).intValue();
/*  4606 */       this.assessMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  4607 */       this.agentGrade1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  4608 */       this.agentTitle1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  4609 */       this.agentGrade2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  4610 */       this.agentTitle2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  4611 */       this.agentGrade3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  4612 */       this.agentTitle3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  4613 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
/*  4614 */       this.startEnd = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
/*  4615 */       this.startDate1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
/*  4616 */       this.startEnd1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
/*  4617 */       this.startDate2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
/*  4618 */       this.startEnd2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
/*  4619 */       this.startDate3 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
/*  4620 */       this.startEnd3 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
/*  4621 */       this.startEnd4 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
/*  4622 */       this.startDate4 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  4623 */       this.serverMonths = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|"))).intValue();
/*  4624 */       this.nT01 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|"))).doubleValue();
/*  4625 */       this.nT02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|"))).doubleValue();
/*  4626 */       this.nT03 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|"))).doubleValue();
/*  4627 */       this.nT04 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|"))).doubleValue();
/*  4628 */       this.nT05 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|"))).doubleValue();
/*  4629 */       this.nT06 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|"))).doubleValue();
/*  4630 */       this.nT07 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|"))).doubleValue();
/*  4631 */       this.nT08 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|"))).doubleValue();
/*  4632 */       this.nT09 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|"))).doubleValue();
/*  4633 */       this.nT10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|"))).doubleValue();
/*  4634 */       this.nT11 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|"))).doubleValue();
/*  4635 */       this.nT12 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 40, "|"))).doubleValue();
/*  4636 */       this.nT13 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|"))).doubleValue();
/*  4637 */       this.nT14 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 42, "|"))).doubleValue();
/*  4638 */       this.nT15 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|"))).doubleValue();
/*  4639 */       this.nT16 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 44, "|"))).doubleValue();
/*  4640 */       this.nT17 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|"))).doubleValue();
/*  4641 */       this.nT18 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|"))).doubleValue();
/*  4642 */       this.nT19 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|"))).doubleValue();
/*  4643 */       this.nT20 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 48, "|"))).doubleValue();
/*  4644 */       this.nT21 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|"))).doubleValue();
/*  4645 */       this.nT22 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|"))).doubleValue();
/*  4646 */       this.nT23 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|"))).doubleValue();
/*  4647 */       this.nT24 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|"))).doubleValue();
/*  4648 */       this.nT25 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|"))).doubleValue();
/*  4649 */       this.nT26 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|"))).doubleValue();
/*  4650 */       this.nT27 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|"))).doubleValue();
/*  4651 */       this.nT28 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|"))).doubleValue();
/*  4652 */       this.nT29 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|"))).doubleValue();
/*  4653 */       this.nT30 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|"))).doubleValue();
/*  4654 */       this.nT31 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|"))).doubleValue();
/*  4655 */       this.nT32 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|"))).doubleValue();
/*  4656 */       this.nT33 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|"))).doubleValue();
/*  4657 */       this.nT34 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|"))).doubleValue();
/*  4658 */       this.nT35 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|"))).doubleValue();
/*  4659 */       this.nT36 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|"))).doubleValue();
/*  4660 */       this.nT37 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|"))).doubleValue();
/*  4661 */       this.nT38 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|"))).doubleValue();
/*  4662 */       this.nT39 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|"))).doubleValue();
/*  4663 */       this.nT40 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|"))).doubleValue();
/*  4664 */       this.nT41 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|"))).doubleValue();
/*  4665 */       this.nT42 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|"))).doubleValue();
/*  4666 */       this.nT43 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|"))).doubleValue();
/*  4667 */       this.nT44 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|"))).doubleValue();
/*  4668 */       this.nT45 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|"))).doubleValue();
/*  4669 */       this.nT46 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|"))).doubleValue();
/*  4670 */       this.nT47 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|"))).doubleValue();
/*  4671 */       this.nT48 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 76, "|"))).doubleValue();
/*  4672 */       this.nT49 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 77, "|"))).doubleValue();
/*  4673 */       this.nT50 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 78, "|"))).doubleValue();
/*  4674 */       this.nT51 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 79, "|"))).doubleValue();
/*  4675 */       this.nT52 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 80, "|"))).doubleValue();
/*  4676 */       this.nT53 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 81, "|"))).doubleValue();
/*  4677 */       this.nT54 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 82, "|"))).doubleValue();
/*  4678 */       this.nT55 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 83, "|"))).doubleValue();
/*  4679 */       this.nT56 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 84, "|"))).doubleValue();
/*  4680 */       this.nT57 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 85, "|"))).doubleValue();
/*  4681 */       this.nT58 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 86, "|"))).doubleValue();
/*  4682 */       this.nT59 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 87, "|"))).doubleValue();
/*  4683 */       this.nT60 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 88, "|"))).doubleValue();
/*  4684 */       this.nT61 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 89, "|"))).doubleValue();
/*  4685 */       this.nT62 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 90, "|"))).doubleValue();
/*  4686 */       this.nT63 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 91, "|"))).doubleValue();
/*  4687 */       this.nT64 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 92, "|"))).doubleValue();
/*  4688 */       this.nT65 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 93, "|"))).doubleValue();
/*  4689 */       this.nT66 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 94, "|"))).doubleValue();
/*  4690 */       this.nT67 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|"))).doubleValue();
/*  4691 */       this.nT68 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 96, "|"))).doubleValue();
/*  4692 */       this.nT69 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|"))).doubleValue();
/*  4693 */       this.nT70 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 98, "|"))).doubleValue();
/*  4694 */       this.nT71 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 99, "|"))).doubleValue();
/*  4695 */       this.nT72 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 100, "|"))).doubleValue();
/*  4696 */       this.nT73 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 101, "|"))).doubleValue();
/*  4697 */       this.nT74 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 102, "|"))).doubleValue();
/*  4698 */       this.nT75 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 103, "|"))).doubleValue();
/*  4699 */       this.nT76 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 104, "|"))).doubleValue();
/*  4700 */       this.nT77 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 105, "|"))).doubleValue();
/*  4701 */       this.nT78 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 106, "|"))).doubleValue();
/*  4702 */       this.nT79 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 107, "|"))).doubleValue();
/*  4703 */       this.nT80 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 108, "|"))).doubleValue();
/*  4704 */       this.nF01 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 109, "|"))).doubleValue();
/*  4705 */       this.nF02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 110, "|"))).doubleValue();
/*  4706 */       this.nF03 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 111, "|"))).doubleValue();
/*  4707 */       this.nF04 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 112, "|"))).doubleValue();
/*  4708 */       this.nF05 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 113, "|"))).doubleValue();
/*  4709 */       this.nF06 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 114, "|"))).doubleValue();
/*  4710 */       this.nF07 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 115, "|"))).doubleValue();
/*  4711 */       this.nF08 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 116, "|"))).doubleValue();
/*  4712 */       this.nF09 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 117, "|"))).doubleValue();
/*  4713 */       this.nF10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 118, "|"))).doubleValue();
/*  4714 */       this.nS01 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 119, "|"))).doubleValue();
/*  4715 */       this.nS02 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 120, "|"))).doubleValue();
/*  4716 */       this.nS03 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 121, "|"))).doubleValue();
/*  4717 */       this.nS04 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 122, "|"))).doubleValue();
/*  4718 */       this.nS05 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 123, "|"))).doubleValue();
/*  4719 */       this.nS06 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 124, "|"))).doubleValue();
/*  4720 */       this.nS07 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 125, "|"))).doubleValue();
/*  4721 */       this.nS08 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 126, "|"))).doubleValue();
/*  4722 */       this.nS09 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 127, "|"))).doubleValue();
/*  4723 */       this.nS10 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 128, "|"))).doubleValue();
/*  4724 */       this.iNT01 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 129, "|"))).intValue();
/*  4725 */       this.iNT02 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 130, "|"))).intValue();
/*  4726 */       this.iNT03 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 131, "|"))).intValue();
/*  4727 */       this.iNT04 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 132, "|"))).intValue();
/*  4728 */       this.iNT05 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 133, "|"))).intValue();
/*  4729 */       this.iNT06 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 134, "|"))).intValue();
/*  4730 */       this.iNT07 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 135, "|"))).intValue();
/*  4731 */       this.iNT08 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 136, "|"))).intValue();
/*  4732 */       this.iNT09 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 137, "|"))).intValue();
/*  4733 */       this.iNT10 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 138, "|"))).intValue();
/*  4734 */       this.iNT11 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 139, "|"))).intValue();
/*  4735 */       this.iNT12 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 140, "|"))).intValue();
/*  4736 */       this.iNT13 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 141, "|"))).intValue();
/*  4737 */       this.iNT14 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 142, "|"))).intValue();
/*  4738 */       this.iNT15 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 143, "|"))).intValue();
/*  4739 */       this.iNT16 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 144, "|"))).intValue();
/*  4740 */       this.iNT17 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 145, "|"))).intValue();
/*  4741 */       this.iNT18 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 146, "|"))).intValue();
/*  4742 */       this.iNT19 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 147, "|"))).intValue();
/*  4743 */       this.iNT20 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 148, "|"))).intValue();
/*  4744 */       this.iNT21 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 149, "|"))).intValue();
/*  4745 */       this.iNT22 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 150, "|"))).intValue();
/*  4746 */       this.iNT23 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 151, "|"))).intValue();
/*  4747 */       this.iNT24 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 152, "|"))).intValue();
/*  4748 */       this.iNT25 = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 153, "|"))).intValue();
/*  4749 */       this.v1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 154, "|");
/*  4750 */       this.v2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 155, "|");
/*  4751 */       this.v3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 156, "|");
/*  4752 */       this.v4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 157, "|");
/*  4753 */       this.v5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 158, "|");
/*  4754 */       this.v6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 159, "|");
/*  4755 */       this.v7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 160, "|");
/*  4756 */       this.v8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 161, "|");
/*  4757 */       this.v9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 162, "|");
/*  4758 */       this.v10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 163, "|");
/*  4759 */       this.v11 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 164, "|");
/*  4760 */       this.v12 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 165, "|");
/*  4761 */       this.v13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 166, "|");
/*  4762 */       this.v14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 167, "|");
/*  4763 */       this.v15 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 168, "|");
/*  4764 */       this.v16 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 169, "|");
/*  4765 */       this.v17 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 170, "|");
/*  4766 */       this.v18 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 171, "|");
/*  4767 */       this.v19 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 172, "|");
/*  4768 */       this.v20 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 173, "|");
/*  4769 */       this.vT1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 174, "|");
/*  4770 */       this.vT2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 175, "|");
/*  4771 */       this.vT3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 176, "|");
/*  4772 */       this.vT4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 177, "|");
/*  4773 */       this.vT5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 178, "|");
/*  4774 */       this.vT6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 179, "|");
/*  4775 */       this.vT7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 180, "|");
/*  4776 */       this.vT8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 181, "|");
/*  4777 */       this.vE1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 182, "|");
/*  4778 */       this.vE2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 183, "|");
/*  4779 */       this.vE3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 184, "|");
/*  4780 */       this.vE4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 185, "|");
/*  4781 */       this.vE5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 186, "|");
/*  4782 */       this.vE6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 187, "|");
/*  4783 */       this.vE7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 188, "|");
/*  4784 */       this.vE8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 189, "|");
/*  4785 */       this.vE9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 190, "|");
/*  4786 */       this.vE10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 191, "|");
/*  4787 */       this.d1 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 192, "|"));
/*  4788 */       this.d2 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 193, "|"));
/*  4789 */       this.d3 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 194, "|"));
/*  4790 */       this.d4 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 195, "|"));
/*  4791 */       this.d5 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 196, "|"));
/*  4792 */       this.d6 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 197, "|"));
/*  4793 */       this.d7 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 198, "|"));
/*  4794 */       this.d8 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 199, "|"));
/*  4795 */       this.d9 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 200, "|"));
/*  4796 */       this.d10 = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 201, "|"));
/*  4797 */       this.state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 202, "|");
/*  4798 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 203, "|");
/*  4799 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 204, "|"));
/*  4800 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 205, "|");
/*  4801 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 206, "|"));
/*  4802 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 207, "|");
/*       */     }
/*       */     catch (NumberFormatException ex)
/*       */     {
/*  4807 */       CError tError = new CError();
/*  4808 */       tError.moduleName = "LAIndexInfoNewSchema";
/*  4809 */       tError.functionName = "decode";
/*  4810 */       tError.errorMessage = ex.toString();
/*  4811 */       this.mErrors.addOneError(tError);
/*       */ 
/*  4813 */       return false;
/*       */     }
/*  4815 */     return true;
/*       */   }
/*       */ 
/*       */   public String getV(String FCode)
/*       */   {
/*  4821 */     String strReturn = "";
/*  4822 */     if (FCode.equalsIgnoreCase("indexCalNo"))
/*       */     {
/*  4824 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indexCalNo));
/*       */     }
/*  4826 */     if (FCode.equalsIgnoreCase("indexType"))
/*       */     {
/*  4828 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.indexType));
/*       */     }
/*  4830 */     if (FCode.equalsIgnoreCase("manageCom"))
/*       */     {
/*  4832 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*       */     }
/*  4834 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*       */     {
/*  4836 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGroup));
/*       */     }
/*  4838 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*       */     {
/*  4840 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.branchAttr));
/*       */     }
/*  4842 */     if (FCode.equalsIgnoreCase("agentCode"))
/*       */     {
/*  4844 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentCode));
/*       */     }
/*  4846 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*       */     {
/*  4848 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade));
/*       */     }
/*  4850 */     if (FCode.equalsIgnoreCase("agentTitle"))
/*       */     {
/*  4852 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentTitle));
/*       */     }
/*  4854 */     if (FCode.equalsIgnoreCase("quaBgnMark"))
/*       */     {
/*  4856 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.quaBgnMark));
/*       */     }
/*  4858 */     if (FCode.equalsIgnoreCase("postMonths"))
/*       */     {
/*  4860 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postMonths));
/*       */     }
/*  4862 */     if (FCode.equalsIgnoreCase("assessMonth"))
/*       */     {
/*  4864 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.assessMonth));
/*       */     }
/*  4866 */     if (FCode.equalsIgnoreCase("agentGrade1"))
/*       */     {
/*  4868 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade1));
/*       */     }
/*  4870 */     if (FCode.equalsIgnoreCase("agentTitle1"))
/*       */     {
/*  4872 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentTitle1));
/*       */     }
/*  4874 */     if (FCode.equalsIgnoreCase("agentGrade2"))
/*       */     {
/*  4876 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade2));
/*       */     }
/*  4878 */     if (FCode.equalsIgnoreCase("agentTitle2"))
/*       */     {
/*  4880 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentTitle2));
/*       */     }
/*  4882 */     if (FCode.equalsIgnoreCase("agentGrade3"))
/*       */     {
/*  4884 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentGrade3));
/*       */     }
/*  4886 */     if (FCode.equalsIgnoreCase("agentTitle3"))
/*       */     {
/*  4888 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.agentTitle3));
/*       */     }
/*  4890 */     if (FCode.equalsIgnoreCase("startDate"))
/*       */     {
/*  4892 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*       */     }
/*  4894 */     if (FCode.equalsIgnoreCase("startEnd"))
/*       */     {
/*  4896 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
/*       */     }
/*  4898 */     if (FCode.equalsIgnoreCase("startDate1"))
/*       */     {
/*  4900 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate1()));
/*       */     }
/*  4902 */     if (FCode.equalsIgnoreCase("startEnd1"))
/*       */     {
/*  4904 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd1()));
/*       */     }
/*  4906 */     if (FCode.equalsIgnoreCase("startDate2"))
/*       */     {
/*  4908 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate2()));
/*       */     }
/*  4910 */     if (FCode.equalsIgnoreCase("startEnd2"))
/*       */     {
/*  4912 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd2()));
/*       */     }
/*  4914 */     if (FCode.equalsIgnoreCase("startDate3"))
/*       */     {
/*  4916 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate3()));
/*       */     }
/*  4918 */     if (FCode.equalsIgnoreCase("startEnd3"))
/*       */     {
/*  4920 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd3()));
/*       */     }
/*  4922 */     if (FCode.equalsIgnoreCase("startEnd4"))
/*       */     {
/*  4924 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd4()));
/*       */     }
/*  4926 */     if (FCode.equalsIgnoreCase("startDate4"))
/*       */     {
/*  4928 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate4()));
/*       */     }
/*  4930 */     if (FCode.equalsIgnoreCase("serverMonths"))
/*       */     {
/*  4932 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serverMonths));
/*       */     }
/*  4934 */     if (FCode.equalsIgnoreCase("nT01"))
/*       */     {
/*  4936 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT01));
/*       */     }
/*  4938 */     if (FCode.equalsIgnoreCase("nT02"))
/*       */     {
/*  4940 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT02));
/*       */     }
/*  4942 */     if (FCode.equalsIgnoreCase("nT03"))
/*       */     {
/*  4944 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT03));
/*       */     }
/*  4946 */     if (FCode.equalsIgnoreCase("nT04"))
/*       */     {
/*  4948 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT04));
/*       */     }
/*  4950 */     if (FCode.equalsIgnoreCase("nT05"))
/*       */     {
/*  4952 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT05));
/*       */     }
/*  4954 */     if (FCode.equalsIgnoreCase("nT06"))
/*       */     {
/*  4956 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT06));
/*       */     }
/*  4958 */     if (FCode.equalsIgnoreCase("nT07"))
/*       */     {
/*  4960 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT07));
/*       */     }
/*  4962 */     if (FCode.equalsIgnoreCase("nT08"))
/*       */     {
/*  4964 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT08));
/*       */     }
/*  4966 */     if (FCode.equalsIgnoreCase("nT09"))
/*       */     {
/*  4968 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT09));
/*       */     }
/*  4970 */     if (FCode.equalsIgnoreCase("nT10"))
/*       */     {
/*  4972 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT10));
/*       */     }
/*  4974 */     if (FCode.equalsIgnoreCase("nT11"))
/*       */     {
/*  4976 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT11));
/*       */     }
/*  4978 */     if (FCode.equalsIgnoreCase("nT12"))
/*       */     {
/*  4980 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT12));
/*       */     }
/*  4982 */     if (FCode.equalsIgnoreCase("nT13"))
/*       */     {
/*  4984 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT13));
/*       */     }
/*  4986 */     if (FCode.equalsIgnoreCase("nT14"))
/*       */     {
/*  4988 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT14));
/*       */     }
/*  4990 */     if (FCode.equalsIgnoreCase("nT15"))
/*       */     {
/*  4992 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT15));
/*       */     }
/*  4994 */     if (FCode.equalsIgnoreCase("nT16"))
/*       */     {
/*  4996 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT16));
/*       */     }
/*  4998 */     if (FCode.equalsIgnoreCase("nT17"))
/*       */     {
/*  5000 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT17));
/*       */     }
/*  5002 */     if (FCode.equalsIgnoreCase("nT18"))
/*       */     {
/*  5004 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT18));
/*       */     }
/*  5006 */     if (FCode.equalsIgnoreCase("nT19"))
/*       */     {
/*  5008 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT19));
/*       */     }
/*  5010 */     if (FCode.equalsIgnoreCase("nT20"))
/*       */     {
/*  5012 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT20));
/*       */     }
/*  5014 */     if (FCode.equalsIgnoreCase("nT21"))
/*       */     {
/*  5016 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT21));
/*       */     }
/*  5018 */     if (FCode.equalsIgnoreCase("nT22"))
/*       */     {
/*  5020 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT22));
/*       */     }
/*  5022 */     if (FCode.equalsIgnoreCase("nT23"))
/*       */     {
/*  5024 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT23));
/*       */     }
/*  5026 */     if (FCode.equalsIgnoreCase("nT24"))
/*       */     {
/*  5028 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT24));
/*       */     }
/*  5030 */     if (FCode.equalsIgnoreCase("nT25"))
/*       */     {
/*  5032 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT25));
/*       */     }
/*  5034 */     if (FCode.equalsIgnoreCase("nT26"))
/*       */     {
/*  5036 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT26));
/*       */     }
/*  5038 */     if (FCode.equalsIgnoreCase("nT27"))
/*       */     {
/*  5040 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT27));
/*       */     }
/*  5042 */     if (FCode.equalsIgnoreCase("nT28"))
/*       */     {
/*  5044 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT28));
/*       */     }
/*  5046 */     if (FCode.equalsIgnoreCase("nT29"))
/*       */     {
/*  5048 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT29));
/*       */     }
/*  5050 */     if (FCode.equalsIgnoreCase("nT30"))
/*       */     {
/*  5052 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT30));
/*       */     }
/*  5054 */     if (FCode.equalsIgnoreCase("nT31"))
/*       */     {
/*  5056 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT31));
/*       */     }
/*  5058 */     if (FCode.equalsIgnoreCase("nT32"))
/*       */     {
/*  5060 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT32));
/*       */     }
/*  5062 */     if (FCode.equalsIgnoreCase("nT33"))
/*       */     {
/*  5064 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT33));
/*       */     }
/*  5066 */     if (FCode.equalsIgnoreCase("nT34"))
/*       */     {
/*  5068 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT34));
/*       */     }
/*  5070 */     if (FCode.equalsIgnoreCase("nT35"))
/*       */     {
/*  5072 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT35));
/*       */     }
/*  5074 */     if (FCode.equalsIgnoreCase("nT36"))
/*       */     {
/*  5076 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT36));
/*       */     }
/*  5078 */     if (FCode.equalsIgnoreCase("nT37"))
/*       */     {
/*  5080 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT37));
/*       */     }
/*  5082 */     if (FCode.equalsIgnoreCase("nT38"))
/*       */     {
/*  5084 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT38));
/*       */     }
/*  5086 */     if (FCode.equalsIgnoreCase("nT39"))
/*       */     {
/*  5088 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT39));
/*       */     }
/*  5090 */     if (FCode.equalsIgnoreCase("nT40"))
/*       */     {
/*  5092 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT40));
/*       */     }
/*  5094 */     if (FCode.equalsIgnoreCase("nT41"))
/*       */     {
/*  5096 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT41));
/*       */     }
/*  5098 */     if (FCode.equalsIgnoreCase("nT42"))
/*       */     {
/*  5100 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT42));
/*       */     }
/*  5102 */     if (FCode.equalsIgnoreCase("nT43"))
/*       */     {
/*  5104 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT43));
/*       */     }
/*  5106 */     if (FCode.equalsIgnoreCase("nT44"))
/*       */     {
/*  5108 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT44));
/*       */     }
/*  5110 */     if (FCode.equalsIgnoreCase("nT45"))
/*       */     {
/*  5112 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT45));
/*       */     }
/*  5114 */     if (FCode.equalsIgnoreCase("nT46"))
/*       */     {
/*  5116 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT46));
/*       */     }
/*  5118 */     if (FCode.equalsIgnoreCase("nT47"))
/*       */     {
/*  5120 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT47));
/*       */     }
/*  5122 */     if (FCode.equalsIgnoreCase("nT48"))
/*       */     {
/*  5124 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT48));
/*       */     }
/*  5126 */     if (FCode.equalsIgnoreCase("nT49"))
/*       */     {
/*  5128 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT49));
/*       */     }
/*  5130 */     if (FCode.equalsIgnoreCase("nT50"))
/*       */     {
/*  5132 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT50));
/*       */     }
/*  5134 */     if (FCode.equalsIgnoreCase("nT51"))
/*       */     {
/*  5136 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT51));
/*       */     }
/*  5138 */     if (FCode.equalsIgnoreCase("nT52"))
/*       */     {
/*  5140 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT52));
/*       */     }
/*  5142 */     if (FCode.equalsIgnoreCase("nT53"))
/*       */     {
/*  5144 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT53));
/*       */     }
/*  5146 */     if (FCode.equalsIgnoreCase("nT54"))
/*       */     {
/*  5148 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT54));
/*       */     }
/*  5150 */     if (FCode.equalsIgnoreCase("nT55"))
/*       */     {
/*  5152 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT55));
/*       */     }
/*  5154 */     if (FCode.equalsIgnoreCase("nT56"))
/*       */     {
/*  5156 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT56));
/*       */     }
/*  5158 */     if (FCode.equalsIgnoreCase("nT57"))
/*       */     {
/*  5160 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT57));
/*       */     }
/*  5162 */     if (FCode.equalsIgnoreCase("nT58"))
/*       */     {
/*  5164 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT58));
/*       */     }
/*  5166 */     if (FCode.equalsIgnoreCase("nT59"))
/*       */     {
/*  5168 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT59));
/*       */     }
/*  5170 */     if (FCode.equalsIgnoreCase("nT60"))
/*       */     {
/*  5172 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT60));
/*       */     }
/*  5174 */     if (FCode.equalsIgnoreCase("nT61"))
/*       */     {
/*  5176 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT61));
/*       */     }
/*  5178 */     if (FCode.equalsIgnoreCase("nT62"))
/*       */     {
/*  5180 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT62));
/*       */     }
/*  5182 */     if (FCode.equalsIgnoreCase("nT63"))
/*       */     {
/*  5184 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT63));
/*       */     }
/*  5186 */     if (FCode.equalsIgnoreCase("nT64"))
/*       */     {
/*  5188 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT64));
/*       */     }
/*  5190 */     if (FCode.equalsIgnoreCase("nT65"))
/*       */     {
/*  5192 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT65));
/*       */     }
/*  5194 */     if (FCode.equalsIgnoreCase("nT66"))
/*       */     {
/*  5196 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT66));
/*       */     }
/*  5198 */     if (FCode.equalsIgnoreCase("nT67"))
/*       */     {
/*  5200 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT67));
/*       */     }
/*  5202 */     if (FCode.equalsIgnoreCase("nT68"))
/*       */     {
/*  5204 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT68));
/*       */     }
/*  5206 */     if (FCode.equalsIgnoreCase("nT69"))
/*       */     {
/*  5208 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT69));
/*       */     }
/*  5210 */     if (FCode.equalsIgnoreCase("nT70"))
/*       */     {
/*  5212 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT70));
/*       */     }
/*  5214 */     if (FCode.equalsIgnoreCase("nT71"))
/*       */     {
/*  5216 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT71));
/*       */     }
/*  5218 */     if (FCode.equalsIgnoreCase("nT72"))
/*       */     {
/*  5220 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT72));
/*       */     }
/*  5222 */     if (FCode.equalsIgnoreCase("nT73"))
/*       */     {
/*  5224 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT73));
/*       */     }
/*  5226 */     if (FCode.equalsIgnoreCase("nT74"))
/*       */     {
/*  5228 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT74));
/*       */     }
/*  5230 */     if (FCode.equalsIgnoreCase("nT75"))
/*       */     {
/*  5232 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT75));
/*       */     }
/*  5234 */     if (FCode.equalsIgnoreCase("nT76"))
/*       */     {
/*  5236 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT76));
/*       */     }
/*  5238 */     if (FCode.equalsIgnoreCase("nT77"))
/*       */     {
/*  5240 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT77));
/*       */     }
/*  5242 */     if (FCode.equalsIgnoreCase("nT78"))
/*       */     {
/*  5244 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT78));
/*       */     }
/*  5246 */     if (FCode.equalsIgnoreCase("nT79"))
/*       */     {
/*  5248 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT79));
/*       */     }
/*  5250 */     if (FCode.equalsIgnoreCase("nT80"))
/*       */     {
/*  5252 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nT80));
/*       */     }
/*  5254 */     if (FCode.equalsIgnoreCase("nF01"))
/*       */     {
/*  5256 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF01));
/*       */     }
/*  5258 */     if (FCode.equalsIgnoreCase("nF02"))
/*       */     {
/*  5260 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF02));
/*       */     }
/*  5262 */     if (FCode.equalsIgnoreCase("nF03"))
/*       */     {
/*  5264 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF03));
/*       */     }
/*  5266 */     if (FCode.equalsIgnoreCase("nF04"))
/*       */     {
/*  5268 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF04));
/*       */     }
/*  5270 */     if (FCode.equalsIgnoreCase("nF05"))
/*       */     {
/*  5272 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF05));
/*       */     }
/*  5274 */     if (FCode.equalsIgnoreCase("nF06"))
/*       */     {
/*  5276 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF06));
/*       */     }
/*  5278 */     if (FCode.equalsIgnoreCase("nF07"))
/*       */     {
/*  5280 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF07));
/*       */     }
/*  5282 */     if (FCode.equalsIgnoreCase("nF08"))
/*       */     {
/*  5284 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF08));
/*       */     }
/*  5286 */     if (FCode.equalsIgnoreCase("nF09"))
/*       */     {
/*  5288 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF09));
/*       */     }
/*  5290 */     if (FCode.equalsIgnoreCase("nF10"))
/*       */     {
/*  5292 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nF10));
/*       */     }
/*  5294 */     if (FCode.equalsIgnoreCase("nS01"))
/*       */     {
/*  5296 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS01));
/*       */     }
/*  5298 */     if (FCode.equalsIgnoreCase("nS02"))
/*       */     {
/*  5300 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS02));
/*       */     }
/*  5302 */     if (FCode.equalsIgnoreCase("nS03"))
/*       */     {
/*  5304 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS03));
/*       */     }
/*  5306 */     if (FCode.equalsIgnoreCase("nS04"))
/*       */     {
/*  5308 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS04));
/*       */     }
/*  5310 */     if (FCode.equalsIgnoreCase("nS05"))
/*       */     {
/*  5312 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS05));
/*       */     }
/*  5314 */     if (FCode.equalsIgnoreCase("nS06"))
/*       */     {
/*  5316 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS06));
/*       */     }
/*  5318 */     if (FCode.equalsIgnoreCase("nS07"))
/*       */     {
/*  5320 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS07));
/*       */     }
/*  5322 */     if (FCode.equalsIgnoreCase("nS08"))
/*       */     {
/*  5324 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS08));
/*       */     }
/*  5326 */     if (FCode.equalsIgnoreCase("nS09"))
/*       */     {
/*  5328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS09));
/*       */     }
/*  5330 */     if (FCode.equalsIgnoreCase("nS10"))
/*       */     {
/*  5332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.nS10));
/*       */     }
/*  5334 */     if (FCode.equalsIgnoreCase("iNT01"))
/*       */     {
/*  5336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT01));
/*       */     }
/*  5338 */     if (FCode.equalsIgnoreCase("iNT02"))
/*       */     {
/*  5340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT02));
/*       */     }
/*  5342 */     if (FCode.equalsIgnoreCase("iNT03"))
/*       */     {
/*  5344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT03));
/*       */     }
/*  5346 */     if (FCode.equalsIgnoreCase("iNT04"))
/*       */     {
/*  5348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT04));
/*       */     }
/*  5350 */     if (FCode.equalsIgnoreCase("iNT05"))
/*       */     {
/*  5352 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT05));
/*       */     }
/*  5354 */     if (FCode.equalsIgnoreCase("iNT06"))
/*       */     {
/*  5356 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT06));
/*       */     }
/*  5358 */     if (FCode.equalsIgnoreCase("iNT07"))
/*       */     {
/*  5360 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT07));
/*       */     }
/*  5362 */     if (FCode.equalsIgnoreCase("iNT08"))
/*       */     {
/*  5364 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT08));
/*       */     }
/*  5366 */     if (FCode.equalsIgnoreCase("iNT09"))
/*       */     {
/*  5368 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT09));
/*       */     }
/*  5370 */     if (FCode.equalsIgnoreCase("iNT10"))
/*       */     {
/*  5372 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT10));
/*       */     }
/*  5374 */     if (FCode.equalsIgnoreCase("iNT11"))
/*       */     {
/*  5376 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT11));
/*       */     }
/*  5378 */     if (FCode.equalsIgnoreCase("iNT12"))
/*       */     {
/*  5380 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT12));
/*       */     }
/*  5382 */     if (FCode.equalsIgnoreCase("iNT13"))
/*       */     {
/*  5384 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT13));
/*       */     }
/*  5386 */     if (FCode.equalsIgnoreCase("iNT14"))
/*       */     {
/*  5388 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT14));
/*       */     }
/*  5390 */     if (FCode.equalsIgnoreCase("iNT15"))
/*       */     {
/*  5392 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT15));
/*       */     }
/*  5394 */     if (FCode.equalsIgnoreCase("iNT16"))
/*       */     {
/*  5396 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT16));
/*       */     }
/*  5398 */     if (FCode.equalsIgnoreCase("iNT17"))
/*       */     {
/*  5400 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT17));
/*       */     }
/*  5402 */     if (FCode.equalsIgnoreCase("iNT18"))
/*       */     {
/*  5404 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT18));
/*       */     }
/*  5406 */     if (FCode.equalsIgnoreCase("iNT19"))
/*       */     {
/*  5408 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT19));
/*       */     }
/*  5410 */     if (FCode.equalsIgnoreCase("iNT20"))
/*       */     {
/*  5412 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT20));
/*       */     }
/*  5414 */     if (FCode.equalsIgnoreCase("iNT21"))
/*       */     {
/*  5416 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT21));
/*       */     }
/*  5418 */     if (FCode.equalsIgnoreCase("iNT22"))
/*       */     {
/*  5420 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT22));
/*       */     }
/*  5422 */     if (FCode.equalsIgnoreCase("iNT23"))
/*       */     {
/*  5424 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT23));
/*       */     }
/*  5426 */     if (FCode.equalsIgnoreCase("iNT24"))
/*       */     {
/*  5428 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT24));
/*       */     }
/*  5430 */     if (FCode.equalsIgnoreCase("iNT25"))
/*       */     {
/*  5432 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iNT25));
/*       */     }
/*  5434 */     if (FCode.equalsIgnoreCase("v1"))
/*       */     {
/*  5436 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v1));
/*       */     }
/*  5438 */     if (FCode.equalsIgnoreCase("v2"))
/*       */     {
/*  5440 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v2));
/*       */     }
/*  5442 */     if (FCode.equalsIgnoreCase("v3"))
/*       */     {
/*  5444 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v3));
/*       */     }
/*  5446 */     if (FCode.equalsIgnoreCase("v4"))
/*       */     {
/*  5448 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v4));
/*       */     }
/*  5450 */     if (FCode.equalsIgnoreCase("v5"))
/*       */     {
/*  5452 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v5));
/*       */     }
/*  5454 */     if (FCode.equalsIgnoreCase("v6"))
/*       */     {
/*  5456 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v6));
/*       */     }
/*  5458 */     if (FCode.equalsIgnoreCase("v7"))
/*       */     {
/*  5460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v7));
/*       */     }
/*  5462 */     if (FCode.equalsIgnoreCase("v8"))
/*       */     {
/*  5464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v8));
/*       */     }
/*  5466 */     if (FCode.equalsIgnoreCase("v9"))
/*       */     {
/*  5468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v9));
/*       */     }
/*  5470 */     if (FCode.equalsIgnoreCase("v10"))
/*       */     {
/*  5472 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v10));
/*       */     }
/*  5474 */     if (FCode.equalsIgnoreCase("v11"))
/*       */     {
/*  5476 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v11));
/*       */     }
/*  5478 */     if (FCode.equalsIgnoreCase("v12"))
/*       */     {
/*  5480 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v12));
/*       */     }
/*  5482 */     if (FCode.equalsIgnoreCase("v13"))
/*       */     {
/*  5484 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v13));
/*       */     }
/*  5486 */     if (FCode.equalsIgnoreCase("v14"))
/*       */     {
/*  5488 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v14));
/*       */     }
/*  5490 */     if (FCode.equalsIgnoreCase("v15"))
/*       */     {
/*  5492 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v15));
/*       */     }
/*  5494 */     if (FCode.equalsIgnoreCase("v16"))
/*       */     {
/*  5496 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v16));
/*       */     }
/*  5498 */     if (FCode.equalsIgnoreCase("v17"))
/*       */     {
/*  5500 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v17));
/*       */     }
/*  5502 */     if (FCode.equalsIgnoreCase("v18"))
/*       */     {
/*  5504 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v18));
/*       */     }
/*  5506 */     if (FCode.equalsIgnoreCase("v19"))
/*       */     {
/*  5508 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v19));
/*       */     }
/*  5510 */     if (FCode.equalsIgnoreCase("v20"))
/*       */     {
/*  5512 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.v20));
/*       */     }
/*  5514 */     if (FCode.equalsIgnoreCase("vT1"))
/*       */     {
/*  5516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT1));
/*       */     }
/*  5518 */     if (FCode.equalsIgnoreCase("vT2"))
/*       */     {
/*  5520 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT2));
/*       */     }
/*  5522 */     if (FCode.equalsIgnoreCase("vT3"))
/*       */     {
/*  5524 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT3));
/*       */     }
/*  5526 */     if (FCode.equalsIgnoreCase("vT4"))
/*       */     {
/*  5528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT4));
/*       */     }
/*  5530 */     if (FCode.equalsIgnoreCase("vT5"))
/*       */     {
/*  5532 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT5));
/*       */     }
/*  5534 */     if (FCode.equalsIgnoreCase("vT6"))
/*       */     {
/*  5536 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT6));
/*       */     }
/*  5538 */     if (FCode.equalsIgnoreCase("vT7"))
/*       */     {
/*  5540 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT7));
/*       */     }
/*  5542 */     if (FCode.equalsIgnoreCase("vT8"))
/*       */     {
/*  5544 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vT8));
/*       */     }
/*  5546 */     if (FCode.equalsIgnoreCase("vE1"))
/*       */     {
/*  5548 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE1));
/*       */     }
/*  5550 */     if (FCode.equalsIgnoreCase("vE2"))
/*       */     {
/*  5552 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE2));
/*       */     }
/*  5554 */     if (FCode.equalsIgnoreCase("vE3"))
/*       */     {
/*  5556 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE3));
/*       */     }
/*  5558 */     if (FCode.equalsIgnoreCase("vE4"))
/*       */     {
/*  5560 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE4));
/*       */     }
/*  5562 */     if (FCode.equalsIgnoreCase("vE5"))
/*       */     {
/*  5564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE5));
/*       */     }
/*  5566 */     if (FCode.equalsIgnoreCase("vE6"))
/*       */     {
/*  5568 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE6));
/*       */     }
/*  5570 */     if (FCode.equalsIgnoreCase("vE7"))
/*       */     {
/*  5572 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE7));
/*       */     }
/*  5574 */     if (FCode.equalsIgnoreCase("vE8"))
/*       */     {
/*  5576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE8));
/*       */     }
/*  5578 */     if (FCode.equalsIgnoreCase("vE9"))
/*       */     {
/*  5580 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE9));
/*       */     }
/*  5582 */     if (FCode.equalsIgnoreCase("vE10"))
/*       */     {
/*  5584 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vE10));
/*       */     }
/*  5586 */     if (FCode.equalsIgnoreCase("d1"))
/*       */     {
/*  5588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD1()));
/*       */     }
/*  5590 */     if (FCode.equalsIgnoreCase("d2"))
/*       */     {
/*  5592 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD2()));
/*       */     }
/*  5594 */     if (FCode.equalsIgnoreCase("d3"))
/*       */     {
/*  5596 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD3()));
/*       */     }
/*  5598 */     if (FCode.equalsIgnoreCase("d4"))
/*       */     {
/*  5600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD4()));
/*       */     }
/*  5602 */     if (FCode.equalsIgnoreCase("d5"))
/*       */     {
/*  5604 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD5()));
/*       */     }
/*  5606 */     if (FCode.equalsIgnoreCase("d6"))
/*       */     {
/*  5608 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD6()));
/*       */     }
/*  5610 */     if (FCode.equalsIgnoreCase("d7"))
/*       */     {
/*  5612 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD7()));
/*       */     }
/*  5614 */     if (FCode.equalsIgnoreCase("d8"))
/*       */     {
/*  5616 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD8()));
/*       */     }
/*  5618 */     if (FCode.equalsIgnoreCase("d9"))
/*       */     {
/*  5620 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD9()));
/*       */     }
/*  5622 */     if (FCode.equalsIgnoreCase("d10"))
/*       */     {
/*  5624 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getD10()));
/*       */     }
/*  5626 */     if (FCode.equalsIgnoreCase("state"))
/*       */     {
/*  5628 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.state));
/*       */     }
/*  5630 */     if (FCode.equalsIgnoreCase("operator"))
/*       */     {
/*  5632 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*       */     }
/*  5634 */     if (FCode.equalsIgnoreCase("makeDate"))
/*       */     {
/*  5636 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*       */     }
/*  5638 */     if (FCode.equalsIgnoreCase("makeTime"))
/*       */     {
/*  5640 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*       */     }
/*  5642 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*       */     {
/*  5644 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*       */     }
/*  5646 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*       */     {
/*  5648 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*       */     }
/*  5650 */     if (strReturn.equals(""))
/*       */     {
/*  5652 */       strReturn = "null";
/*       */     }
/*       */ 
/*  5655 */     return strReturn;
/*       */   }
/*       */ 
/*       */   public String getV(int nFieldIndex)
/*       */   {
/*  5662 */     String strFieldValue = "";
/*  5663 */     switch (nFieldIndex) {
/*       */     case 0:
/*  5665 */       strFieldValue = StrTool.GBKToUnicode(this.indexCalNo);
/*  5666 */       break;
/*       */     case 1:
/*  5668 */       strFieldValue = StrTool.GBKToUnicode(this.indexType);
/*  5669 */       break;
/*       */     case 2:
/*  5671 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/*  5672 */       break;
/*       */     case 3:
/*  5674 */       strFieldValue = StrTool.GBKToUnicode(this.agentGroup);
/*  5675 */       break;
/*       */     case 4:
/*  5677 */       strFieldValue = StrTool.GBKToUnicode(this.branchAttr);
/*  5678 */       break;
/*       */     case 5:
/*  5680 */       strFieldValue = StrTool.GBKToUnicode(this.agentCode);
/*  5681 */       break;
/*       */     case 6:
/*  5683 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade);
/*  5684 */       break;
/*       */     case 7:
/*  5686 */       strFieldValue = StrTool.GBKToUnicode(this.agentTitle);
/*  5687 */       break;
/*       */     case 8:
/*  5689 */       strFieldValue = String.valueOf(this.quaBgnMark);
/*  5690 */       break;
/*       */     case 9:
/*  5692 */       strFieldValue = String.valueOf(this.postMonths);
/*  5693 */       break;
/*       */     case 10:
/*  5695 */       strFieldValue = StrTool.GBKToUnicode(this.assessMonth);
/*  5696 */       break;
/*       */     case 11:
/*  5698 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade1);
/*  5699 */       break;
/*       */     case 12:
/*  5701 */       strFieldValue = StrTool.GBKToUnicode(this.agentTitle1);
/*  5702 */       break;
/*       */     case 13:
/*  5704 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade2);
/*  5705 */       break;
/*       */     case 14:
/*  5707 */       strFieldValue = StrTool.GBKToUnicode(this.agentTitle2);
/*  5708 */       break;
/*       */     case 15:
/*  5710 */       strFieldValue = StrTool.GBKToUnicode(this.agentGrade3);
/*  5711 */       break;
/*       */     case 16:
/*  5713 */       strFieldValue = StrTool.GBKToUnicode(this.agentTitle3);
/*  5714 */       break;
/*       */     case 17:
/*  5716 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*  5717 */       break;
/*       */     case 18:
/*  5719 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
/*  5720 */       break;
/*       */     case 19:
/*  5722 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate1()));
/*  5723 */       break;
/*       */     case 20:
/*  5725 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd1()));
/*  5726 */       break;
/*       */     case 21:
/*  5728 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate2()));
/*  5729 */       break;
/*       */     case 22:
/*  5731 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd2()));
/*  5732 */       break;
/*       */     case 23:
/*  5734 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate3()));
/*  5735 */       break;
/*       */     case 24:
/*  5737 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd3()));
/*  5738 */       break;
/*       */     case 25:
/*  5740 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd4()));
/*  5741 */       break;
/*       */     case 26:
/*  5743 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate4()));
/*  5744 */       break;
/*       */     case 27:
/*  5746 */       strFieldValue = String.valueOf(this.serverMonths);
/*  5747 */       break;
/*       */     case 28:
/*  5749 */       strFieldValue = String.valueOf(this.nT01);
/*  5750 */       break;
/*       */     case 29:
/*  5752 */       strFieldValue = String.valueOf(this.nT02);
/*  5753 */       break;
/*       */     case 30:
/*  5755 */       strFieldValue = String.valueOf(this.nT03);
/*  5756 */       break;
/*       */     case 31:
/*  5758 */       strFieldValue = String.valueOf(this.nT04);
/*  5759 */       break;
/*       */     case 32:
/*  5761 */       strFieldValue = String.valueOf(this.nT05);
/*  5762 */       break;
/*       */     case 33:
/*  5764 */       strFieldValue = String.valueOf(this.nT06);
/*  5765 */       break;
/*       */     case 34:
/*  5767 */       strFieldValue = String.valueOf(this.nT07);
/*  5768 */       break;
/*       */     case 35:
/*  5770 */       strFieldValue = String.valueOf(this.nT08);
/*  5771 */       break;
/*       */     case 36:
/*  5773 */       strFieldValue = String.valueOf(this.nT09);
/*  5774 */       break;
/*       */     case 37:
/*  5776 */       strFieldValue = String.valueOf(this.nT10);
/*  5777 */       break;
/*       */     case 38:
/*  5779 */       strFieldValue = String.valueOf(this.nT11);
/*  5780 */       break;
/*       */     case 39:
/*  5782 */       strFieldValue = String.valueOf(this.nT12);
/*  5783 */       break;
/*       */     case 40:
/*  5785 */       strFieldValue = String.valueOf(this.nT13);
/*  5786 */       break;
/*       */     case 41:
/*  5788 */       strFieldValue = String.valueOf(this.nT14);
/*  5789 */       break;
/*       */     case 42:
/*  5791 */       strFieldValue = String.valueOf(this.nT15);
/*  5792 */       break;
/*       */     case 43:
/*  5794 */       strFieldValue = String.valueOf(this.nT16);
/*  5795 */       break;
/*       */     case 44:
/*  5797 */       strFieldValue = String.valueOf(this.nT17);
/*  5798 */       break;
/*       */     case 45:
/*  5800 */       strFieldValue = String.valueOf(this.nT18);
/*  5801 */       break;
/*       */     case 46:
/*  5803 */       strFieldValue = String.valueOf(this.nT19);
/*  5804 */       break;
/*       */     case 47:
/*  5806 */       strFieldValue = String.valueOf(this.nT20);
/*  5807 */       break;
/*       */     case 48:
/*  5809 */       strFieldValue = String.valueOf(this.nT21);
/*  5810 */       break;
/*       */     case 49:
/*  5812 */       strFieldValue = String.valueOf(this.nT22);
/*  5813 */       break;
/*       */     case 50:
/*  5815 */       strFieldValue = String.valueOf(this.nT23);
/*  5816 */       break;
/*       */     case 51:
/*  5818 */       strFieldValue = String.valueOf(this.nT24);
/*  5819 */       break;
/*       */     case 52:
/*  5821 */       strFieldValue = String.valueOf(this.nT25);
/*  5822 */       break;
/*       */     case 53:
/*  5824 */       strFieldValue = String.valueOf(this.nT26);
/*  5825 */       break;
/*       */     case 54:
/*  5827 */       strFieldValue = String.valueOf(this.nT27);
/*  5828 */       break;
/*       */     case 55:
/*  5830 */       strFieldValue = String.valueOf(this.nT28);
/*  5831 */       break;
/*       */     case 56:
/*  5833 */       strFieldValue = String.valueOf(this.nT29);
/*  5834 */       break;
/*       */     case 57:
/*  5836 */       strFieldValue = String.valueOf(this.nT30);
/*  5837 */       break;
/*       */     case 58:
/*  5839 */       strFieldValue = String.valueOf(this.nT31);
/*  5840 */       break;
/*       */     case 59:
/*  5842 */       strFieldValue = String.valueOf(this.nT32);
/*  5843 */       break;
/*       */     case 60:
/*  5845 */       strFieldValue = String.valueOf(this.nT33);
/*  5846 */       break;
/*       */     case 61:
/*  5848 */       strFieldValue = String.valueOf(this.nT34);
/*  5849 */       break;
/*       */     case 62:
/*  5851 */       strFieldValue = String.valueOf(this.nT35);
/*  5852 */       break;
/*       */     case 63:
/*  5854 */       strFieldValue = String.valueOf(this.nT36);
/*  5855 */       break;
/*       */     case 64:
/*  5857 */       strFieldValue = String.valueOf(this.nT37);
/*  5858 */       break;
/*       */     case 65:
/*  5860 */       strFieldValue = String.valueOf(this.nT38);
/*  5861 */       break;
/*       */     case 66:
/*  5863 */       strFieldValue = String.valueOf(this.nT39);
/*  5864 */       break;
/*       */     case 67:
/*  5866 */       strFieldValue = String.valueOf(this.nT40);
/*  5867 */       break;
/*       */     case 68:
/*  5869 */       strFieldValue = String.valueOf(this.nT41);
/*  5870 */       break;
/*       */     case 69:
/*  5872 */       strFieldValue = String.valueOf(this.nT42);
/*  5873 */       break;
/*       */     case 70:
/*  5875 */       strFieldValue = String.valueOf(this.nT43);
/*  5876 */       break;
/*       */     case 71:
/*  5878 */       strFieldValue = String.valueOf(this.nT44);
/*  5879 */       break;
/*       */     case 72:
/*  5881 */       strFieldValue = String.valueOf(this.nT45);
/*  5882 */       break;
/*       */     case 73:
/*  5884 */       strFieldValue = String.valueOf(this.nT46);
/*  5885 */       break;
/*       */     case 74:
/*  5887 */       strFieldValue = String.valueOf(this.nT47);
/*  5888 */       break;
/*       */     case 75:
/*  5890 */       strFieldValue = String.valueOf(this.nT48);
/*  5891 */       break;
/*       */     case 76:
/*  5893 */       strFieldValue = String.valueOf(this.nT49);
/*  5894 */       break;
/*       */     case 77:
/*  5896 */       strFieldValue = String.valueOf(this.nT50);
/*  5897 */       break;
/*       */     case 78:
/*  5899 */       strFieldValue = String.valueOf(this.nT51);
/*  5900 */       break;
/*       */     case 79:
/*  5902 */       strFieldValue = String.valueOf(this.nT52);
/*  5903 */       break;
/*       */     case 80:
/*  5905 */       strFieldValue = String.valueOf(this.nT53);
/*  5906 */       break;
/*       */     case 81:
/*  5908 */       strFieldValue = String.valueOf(this.nT54);
/*  5909 */       break;
/*       */     case 82:
/*  5911 */       strFieldValue = String.valueOf(this.nT55);
/*  5912 */       break;
/*       */     case 83:
/*  5914 */       strFieldValue = String.valueOf(this.nT56);
/*  5915 */       break;
/*       */     case 84:
/*  5917 */       strFieldValue = String.valueOf(this.nT57);
/*  5918 */       break;
/*       */     case 85:
/*  5920 */       strFieldValue = String.valueOf(this.nT58);
/*  5921 */       break;
/*       */     case 86:
/*  5923 */       strFieldValue = String.valueOf(this.nT59);
/*  5924 */       break;
/*       */     case 87:
/*  5926 */       strFieldValue = String.valueOf(this.nT60);
/*  5927 */       break;
/*       */     case 88:
/*  5929 */       strFieldValue = String.valueOf(this.nT61);
/*  5930 */       break;
/*       */     case 89:
/*  5932 */       strFieldValue = String.valueOf(this.nT62);
/*  5933 */       break;
/*       */     case 90:
/*  5935 */       strFieldValue = String.valueOf(this.nT63);
/*  5936 */       break;
/*       */     case 91:
/*  5938 */       strFieldValue = String.valueOf(this.nT64);
/*  5939 */       break;
/*       */     case 92:
/*  5941 */       strFieldValue = String.valueOf(this.nT65);
/*  5942 */       break;
/*       */     case 93:
/*  5944 */       strFieldValue = String.valueOf(this.nT66);
/*  5945 */       break;
/*       */     case 94:
/*  5947 */       strFieldValue = String.valueOf(this.nT67);
/*  5948 */       break;
/*       */     case 95:
/*  5950 */       strFieldValue = String.valueOf(this.nT68);
/*  5951 */       break;
/*       */     case 96:
/*  5953 */       strFieldValue = String.valueOf(this.nT69);
/*  5954 */       break;
/*       */     case 97:
/*  5956 */       strFieldValue = String.valueOf(this.nT70);
/*  5957 */       break;
/*       */     case 98:
/*  5959 */       strFieldValue = String.valueOf(this.nT71);
/*  5960 */       break;
/*       */     case 99:
/*  5962 */       strFieldValue = String.valueOf(this.nT72);
/*  5963 */       break;
/*       */     case 100:
/*  5965 */       strFieldValue = String.valueOf(this.nT73);
/*  5966 */       break;
/*       */     case 101:
/*  5968 */       strFieldValue = String.valueOf(this.nT74);
/*  5969 */       break;
/*       */     case 102:
/*  5971 */       strFieldValue = String.valueOf(this.nT75);
/*  5972 */       break;
/*       */     case 103:
/*  5974 */       strFieldValue = String.valueOf(this.nT76);
/*  5975 */       break;
/*       */     case 104:
/*  5977 */       strFieldValue = String.valueOf(this.nT77);
/*  5978 */       break;
/*       */     case 105:
/*  5980 */       strFieldValue = String.valueOf(this.nT78);
/*  5981 */       break;
/*       */     case 106:
/*  5983 */       strFieldValue = String.valueOf(this.nT79);
/*  5984 */       break;
/*       */     case 107:
/*  5986 */       strFieldValue = String.valueOf(this.nT80);
/*  5987 */       break;
/*       */     case 108:
/*  5989 */       strFieldValue = String.valueOf(this.nF01);
/*  5990 */       break;
/*       */     case 109:
/*  5992 */       strFieldValue = String.valueOf(this.nF02);
/*  5993 */       break;
/*       */     case 110:
/*  5995 */       strFieldValue = String.valueOf(this.nF03);
/*  5996 */       break;
/*       */     case 111:
/*  5998 */       strFieldValue = String.valueOf(this.nF04);
/*  5999 */       break;
/*       */     case 112:
/*  6001 */       strFieldValue = String.valueOf(this.nF05);
/*  6002 */       break;
/*       */     case 113:
/*  6004 */       strFieldValue = String.valueOf(this.nF06);
/*  6005 */       break;
/*       */     case 114:
/*  6007 */       strFieldValue = String.valueOf(this.nF07);
/*  6008 */       break;
/*       */     case 115:
/*  6010 */       strFieldValue = String.valueOf(this.nF08);
/*  6011 */       break;
/*       */     case 116:
/*  6013 */       strFieldValue = String.valueOf(this.nF09);
/*  6014 */       break;
/*       */     case 117:
/*  6016 */       strFieldValue = String.valueOf(this.nF10);
/*  6017 */       break;
/*       */     case 118:
/*  6019 */       strFieldValue = String.valueOf(this.nS01);
/*  6020 */       break;
/*       */     case 119:
/*  6022 */       strFieldValue = String.valueOf(this.nS02);
/*  6023 */       break;
/*       */     case 120:
/*  6025 */       strFieldValue = String.valueOf(this.nS03);
/*  6026 */       break;
/*       */     case 121:
/*  6028 */       strFieldValue = String.valueOf(this.nS04);
/*  6029 */       break;
/*       */     case 122:
/*  6031 */       strFieldValue = String.valueOf(this.nS05);
/*  6032 */       break;
/*       */     case 123:
/*  6034 */       strFieldValue = String.valueOf(this.nS06);
/*  6035 */       break;
/*       */     case 124:
/*  6037 */       strFieldValue = String.valueOf(this.nS07);
/*  6038 */       break;
/*       */     case 125:
/*  6040 */       strFieldValue = String.valueOf(this.nS08);
/*  6041 */       break;
/*       */     case 126:
/*  6043 */       strFieldValue = String.valueOf(this.nS09);
/*  6044 */       break;
/*       */     case 127:
/*  6046 */       strFieldValue = String.valueOf(this.nS10);
/*  6047 */       break;
/*       */     case 128:
/*  6049 */       strFieldValue = String.valueOf(this.iNT01);
/*  6050 */       break;
/*       */     case 129:
/*  6052 */       strFieldValue = String.valueOf(this.iNT02);
/*  6053 */       break;
/*       */     case 130:
/*  6055 */       strFieldValue = String.valueOf(this.iNT03);
/*  6056 */       break;
/*       */     case 131:
/*  6058 */       strFieldValue = String.valueOf(this.iNT04);
/*  6059 */       break;
/*       */     case 132:
/*  6061 */       strFieldValue = String.valueOf(this.iNT05);
/*  6062 */       break;
/*       */     case 133:
/*  6064 */       strFieldValue = String.valueOf(this.iNT06);
/*  6065 */       break;
/*       */     case 134:
/*  6067 */       strFieldValue = String.valueOf(this.iNT07);
/*  6068 */       break;
/*       */     case 135:
/*  6070 */       strFieldValue = String.valueOf(this.iNT08);
/*  6071 */       break;
/*       */     case 136:
/*  6073 */       strFieldValue = String.valueOf(this.iNT09);
/*  6074 */       break;
/*       */     case 137:
/*  6076 */       strFieldValue = String.valueOf(this.iNT10);
/*  6077 */       break;
/*       */     case 138:
/*  6079 */       strFieldValue = String.valueOf(this.iNT11);
/*  6080 */       break;
/*       */     case 139:
/*  6082 */       strFieldValue = String.valueOf(this.iNT12);
/*  6083 */       break;
/*       */     case 140:
/*  6085 */       strFieldValue = String.valueOf(this.iNT13);
/*  6086 */       break;
/*       */     case 141:
/*  6088 */       strFieldValue = String.valueOf(this.iNT14);
/*  6089 */       break;
/*       */     case 142:
/*  6091 */       strFieldValue = String.valueOf(this.iNT15);
/*  6092 */       break;
/*       */     case 143:
/*  6094 */       strFieldValue = String.valueOf(this.iNT16);
/*  6095 */       break;
/*       */     case 144:
/*  6097 */       strFieldValue = String.valueOf(this.iNT17);
/*  6098 */       break;
/*       */     case 145:
/*  6100 */       strFieldValue = String.valueOf(this.iNT18);
/*  6101 */       break;
/*       */     case 146:
/*  6103 */       strFieldValue = String.valueOf(this.iNT19);
/*  6104 */       break;
/*       */     case 147:
/*  6106 */       strFieldValue = String.valueOf(this.iNT20);
/*  6107 */       break;
/*       */     case 148:
/*  6109 */       strFieldValue = String.valueOf(this.iNT21);
/*  6110 */       break;
/*       */     case 149:
/*  6112 */       strFieldValue = String.valueOf(this.iNT22);
/*  6113 */       break;
/*       */     case 150:
/*  6115 */       strFieldValue = String.valueOf(this.iNT23);
/*  6116 */       break;
/*       */     case 151:
/*  6118 */       strFieldValue = String.valueOf(this.iNT24);
/*  6119 */       break;
/*       */     case 152:
/*  6121 */       strFieldValue = String.valueOf(this.iNT25);
/*  6122 */       break;
/*       */     case 153:
/*  6124 */       strFieldValue = StrTool.GBKToUnicode(this.v1);
/*  6125 */       break;
/*       */     case 154:
/*  6127 */       strFieldValue = StrTool.GBKToUnicode(this.v2);
/*  6128 */       break;
/*       */     case 155:
/*  6130 */       strFieldValue = StrTool.GBKToUnicode(this.v3);
/*  6131 */       break;
/*       */     case 156:
/*  6133 */       strFieldValue = StrTool.GBKToUnicode(this.v4);
/*  6134 */       break;
/*       */     case 157:
/*  6136 */       strFieldValue = StrTool.GBKToUnicode(this.v5);
/*  6137 */       break;
/*       */     case 158:
/*  6139 */       strFieldValue = StrTool.GBKToUnicode(this.v6);
/*  6140 */       break;
/*       */     case 159:
/*  6142 */       strFieldValue = StrTool.GBKToUnicode(this.v7);
/*  6143 */       break;
/*       */     case 160:
/*  6145 */       strFieldValue = StrTool.GBKToUnicode(this.v8);
/*  6146 */       break;
/*       */     case 161:
/*  6148 */       strFieldValue = StrTool.GBKToUnicode(this.v9);
/*  6149 */       break;
/*       */     case 162:
/*  6151 */       strFieldValue = StrTool.GBKToUnicode(this.v10);
/*  6152 */       break;
/*       */     case 163:
/*  6154 */       strFieldValue = StrTool.GBKToUnicode(this.v11);
/*  6155 */       break;
/*       */     case 164:
/*  6157 */       strFieldValue = StrTool.GBKToUnicode(this.v12);
/*  6158 */       break;
/*       */     case 165:
/*  6160 */       strFieldValue = StrTool.GBKToUnicode(this.v13);
/*  6161 */       break;
/*       */     case 166:
/*  6163 */       strFieldValue = StrTool.GBKToUnicode(this.v14);
/*  6164 */       break;
/*       */     case 167:
/*  6166 */       strFieldValue = StrTool.GBKToUnicode(this.v15);
/*  6167 */       break;
/*       */     case 168:
/*  6169 */       strFieldValue = StrTool.GBKToUnicode(this.v16);
/*  6170 */       break;
/*       */     case 169:
/*  6172 */       strFieldValue = StrTool.GBKToUnicode(this.v17);
/*  6173 */       break;
/*       */     case 170:
/*  6175 */       strFieldValue = StrTool.GBKToUnicode(this.v18);
/*  6176 */       break;
/*       */     case 171:
/*  6178 */       strFieldValue = StrTool.GBKToUnicode(this.v19);
/*  6179 */       break;
/*       */     case 172:
/*  6181 */       strFieldValue = StrTool.GBKToUnicode(this.v20);
/*  6182 */       break;
/*       */     case 173:
/*  6184 */       strFieldValue = StrTool.GBKToUnicode(this.vT1);
/*  6185 */       break;
/*       */     case 174:
/*  6187 */       strFieldValue = StrTool.GBKToUnicode(this.vT2);
/*  6188 */       break;
/*       */     case 175:
/*  6190 */       strFieldValue = StrTool.GBKToUnicode(this.vT3);
/*  6191 */       break;
/*       */     case 176:
/*  6193 */       strFieldValue = StrTool.GBKToUnicode(this.vT4);
/*  6194 */       break;
/*       */     case 177:
/*  6196 */       strFieldValue = StrTool.GBKToUnicode(this.vT5);
/*  6197 */       break;
/*       */     case 178:
/*  6199 */       strFieldValue = StrTool.GBKToUnicode(this.vT6);
/*  6200 */       break;
/*       */     case 179:
/*  6202 */       strFieldValue = StrTool.GBKToUnicode(this.vT7);
/*  6203 */       break;
/*       */     case 180:
/*  6205 */       strFieldValue = StrTool.GBKToUnicode(this.vT8);
/*  6206 */       break;
/*       */     case 181:
/*  6208 */       strFieldValue = StrTool.GBKToUnicode(this.vE1);
/*  6209 */       break;
/*       */     case 182:
/*  6211 */       strFieldValue = StrTool.GBKToUnicode(this.vE2);
/*  6212 */       break;
/*       */     case 183:
/*  6214 */       strFieldValue = StrTool.GBKToUnicode(this.vE3);
/*  6215 */       break;
/*       */     case 184:
/*  6217 */       strFieldValue = StrTool.GBKToUnicode(this.vE4);
/*  6218 */       break;
/*       */     case 185:
/*  6220 */       strFieldValue = StrTool.GBKToUnicode(this.vE5);
/*  6221 */       break;
/*       */     case 186:
/*  6223 */       strFieldValue = StrTool.GBKToUnicode(this.vE6);
/*  6224 */       break;
/*       */     case 187:
/*  6226 */       strFieldValue = StrTool.GBKToUnicode(this.vE7);
/*  6227 */       break;
/*       */     case 188:
/*  6229 */       strFieldValue = StrTool.GBKToUnicode(this.vE8);
/*  6230 */       break;
/*       */     case 189:
/*  6232 */       strFieldValue = StrTool.GBKToUnicode(this.vE9);
/*  6233 */       break;
/*       */     case 190:
/*  6235 */       strFieldValue = StrTool.GBKToUnicode(this.vE10);
/*  6236 */       break;
/*       */     case 191:
/*  6238 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD1()));
/*  6239 */       break;
/*       */     case 192:
/*  6241 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD2()));
/*  6242 */       break;
/*       */     case 193:
/*  6244 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD3()));
/*  6245 */       break;
/*       */     case 194:
/*  6247 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD4()));
/*  6248 */       break;
/*       */     case 195:
/*  6250 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD5()));
/*  6251 */       break;
/*       */     case 196:
/*  6253 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD6()));
/*  6254 */       break;
/*       */     case 197:
/*  6256 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD7()));
/*  6257 */       break;
/*       */     case 198:
/*  6259 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD8()));
/*  6260 */       break;
/*       */     case 199:
/*  6262 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD9()));
/*  6263 */       break;
/*       */     case 200:
/*  6265 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD10()));
/*  6266 */       break;
/*       */     case 201:
/*  6268 */       strFieldValue = StrTool.GBKToUnicode(this.state);
/*  6269 */       break;
/*       */     case 202:
/*  6271 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  6272 */       break;
/*       */     case 203:
/*  6274 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  6275 */       break;
/*       */     case 204:
/*  6277 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  6278 */       break;
/*       */     case 205:
/*  6280 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  6281 */       break;
/*       */     case 206:
/*  6283 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  6284 */       break;
/*       */     default:
/*  6286 */       strFieldValue = "";
/*       */     }
/*  6288 */     if (strFieldValue.equals("")) {
/*  6289 */       strFieldValue = "null";
/*       */     }
/*  6291 */     return strFieldValue;
/*       */   }
/*       */ 
/*       */   public boolean setV(String FCode, String FValue)
/*       */   {
/*  6297 */     if (StrTool.cTrim(FCode).equals("")) {
/*  6298 */       return false;
/*       */     }
/*  6300 */     if (FCode.equalsIgnoreCase("indexCalNo"))
/*       */     {
/*  6302 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6304 */         this.indexCalNo = FValue.trim();
/*       */       }
/*       */       else
/*  6307 */         this.indexCalNo = null;
/*       */     }
/*  6309 */     if (FCode.equalsIgnoreCase("indexType"))
/*       */     {
/*  6311 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6313 */         this.indexType = FValue.trim();
/*       */       }
/*       */       else
/*  6316 */         this.indexType = null;
/*       */     }
/*  6318 */     if (FCode.equalsIgnoreCase("manageCom"))
/*       */     {
/*  6320 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6322 */         this.manageCom = FValue.trim();
/*       */       }
/*       */       else
/*  6325 */         this.manageCom = null;
/*       */     }
/*  6327 */     if (FCode.equalsIgnoreCase("agentGroup"))
/*       */     {
/*  6329 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6331 */         this.agentGroup = FValue.trim();
/*       */       }
/*       */       else
/*  6334 */         this.agentGroup = null;
/*       */     }
/*  6336 */     if (FCode.equalsIgnoreCase("branchAttr"))
/*       */     {
/*  6338 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6340 */         this.branchAttr = FValue.trim();
/*       */       }
/*       */       else
/*  6343 */         this.branchAttr = null;
/*       */     }
/*  6345 */     if (FCode.equalsIgnoreCase("agentCode"))
/*       */     {
/*  6347 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6349 */         this.agentCode = FValue.trim();
/*       */       }
/*       */       else
/*  6352 */         this.agentCode = null;
/*       */     }
/*  6354 */     if (FCode.equalsIgnoreCase("agentGrade"))
/*       */     {
/*  6356 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6358 */         this.agentGrade = FValue.trim();
/*       */       }
/*       */       else
/*  6361 */         this.agentGrade = null;
/*       */     }
/*  6363 */     if (FCode.equalsIgnoreCase("agentTitle"))
/*       */     {
/*  6365 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6367 */         this.agentTitle = FValue.trim();
/*       */       }
/*       */       else
/*  6370 */         this.agentTitle = null;
/*       */     }
/*  6372 */     if (FCode.equalsIgnoreCase("quaBgnMark"))
/*       */     {
/*  6374 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6376 */         Integer tInteger = new Integer(FValue);
/*  6377 */         int i = tInteger.intValue();
/*  6378 */         this.quaBgnMark = i;
/*       */       }
/*       */     }
/*  6381 */     if (FCode.equalsIgnoreCase("postMonths"))
/*       */     {
/*  6383 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6385 */         Integer tInteger = new Integer(FValue);
/*  6386 */         int i = tInteger.intValue();
/*  6387 */         this.postMonths = i;
/*       */       }
/*       */     }
/*  6390 */     if (FCode.equalsIgnoreCase("assessMonth"))
/*       */     {
/*  6392 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6394 */         this.assessMonth = FValue.trim();
/*       */       }
/*       */       else
/*  6397 */         this.assessMonth = null;
/*       */     }
/*  6399 */     if (FCode.equalsIgnoreCase("agentGrade1"))
/*       */     {
/*  6401 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6403 */         this.agentGrade1 = FValue.trim();
/*       */       }
/*       */       else
/*  6406 */         this.agentGrade1 = null;
/*       */     }
/*  6408 */     if (FCode.equalsIgnoreCase("agentTitle1"))
/*       */     {
/*  6410 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6412 */         this.agentTitle1 = FValue.trim();
/*       */       }
/*       */       else
/*  6415 */         this.agentTitle1 = null;
/*       */     }
/*  6417 */     if (FCode.equalsIgnoreCase("agentGrade2"))
/*       */     {
/*  6419 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6421 */         this.agentGrade2 = FValue.trim();
/*       */       }
/*       */       else
/*  6424 */         this.agentGrade2 = null;
/*       */     }
/*  6426 */     if (FCode.equalsIgnoreCase("agentTitle2"))
/*       */     {
/*  6428 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6430 */         this.agentTitle2 = FValue.trim();
/*       */       }
/*       */       else
/*  6433 */         this.agentTitle2 = null;
/*       */     }
/*  6435 */     if (FCode.equalsIgnoreCase("agentGrade3"))
/*       */     {
/*  6437 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6439 */         this.agentGrade3 = FValue.trim();
/*       */       }
/*       */       else
/*  6442 */         this.agentGrade3 = null;
/*       */     }
/*  6444 */     if (FCode.equalsIgnoreCase("agentTitle3"))
/*       */     {
/*  6446 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6448 */         this.agentTitle3 = FValue.trim();
/*       */       }
/*       */       else
/*  6451 */         this.agentTitle3 = null;
/*       */     }
/*  6453 */     if (FCode.equalsIgnoreCase("startDate"))
/*       */     {
/*  6455 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6457 */         this.startDate = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6460 */         this.startDate = null;
/*       */     }
/*  6462 */     if (FCode.equalsIgnoreCase("startEnd"))
/*       */     {
/*  6464 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6466 */         this.startEnd = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6469 */         this.startEnd = null;
/*       */     }
/*  6471 */     if (FCode.equalsIgnoreCase("startDate1"))
/*       */     {
/*  6473 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6475 */         this.startDate1 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6478 */         this.startDate1 = null;
/*       */     }
/*  6480 */     if (FCode.equalsIgnoreCase("startEnd1"))
/*       */     {
/*  6482 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6484 */         this.startEnd1 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6487 */         this.startEnd1 = null;
/*       */     }
/*  6489 */     if (FCode.equalsIgnoreCase("startDate2"))
/*       */     {
/*  6491 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6493 */         this.startDate2 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6496 */         this.startDate2 = null;
/*       */     }
/*  6498 */     if (FCode.equalsIgnoreCase("startEnd2"))
/*       */     {
/*  6500 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6502 */         this.startEnd2 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6505 */         this.startEnd2 = null;
/*       */     }
/*  6507 */     if (FCode.equalsIgnoreCase("startDate3"))
/*       */     {
/*  6509 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6511 */         this.startDate3 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6514 */         this.startDate3 = null;
/*       */     }
/*  6516 */     if (FCode.equalsIgnoreCase("startEnd3"))
/*       */     {
/*  6518 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6520 */         this.startEnd3 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6523 */         this.startEnd3 = null;
/*       */     }
/*  6525 */     if (FCode.equalsIgnoreCase("startEnd4"))
/*       */     {
/*  6527 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6529 */         this.startEnd4 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6532 */         this.startEnd4 = null;
/*       */     }
/*  6534 */     if (FCode.equalsIgnoreCase("startDate4"))
/*       */     {
/*  6536 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6538 */         this.startDate4 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  6541 */         this.startDate4 = null;
/*       */     }
/*  6543 */     if (FCode.equalsIgnoreCase("serverMonths"))
/*       */     {
/*  6545 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6547 */         Integer tInteger = new Integer(FValue);
/*  6548 */         int i = tInteger.intValue();
/*  6549 */         this.serverMonths = i;
/*       */       }
/*       */     }
/*  6552 */     if (FCode.equalsIgnoreCase("nT01"))
/*       */     {
/*  6554 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6556 */         Double tDouble = new Double(FValue);
/*  6557 */         double d = tDouble.doubleValue();
/*  6558 */         this.nT01 = d;
/*       */       }
/*       */     }
/*  6561 */     if (FCode.equalsIgnoreCase("nT02"))
/*       */     {
/*  6563 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6565 */         Double tDouble = new Double(FValue);
/*  6566 */         double d = tDouble.doubleValue();
/*  6567 */         this.nT02 = d;
/*       */       }
/*       */     }
/*  6570 */     if (FCode.equalsIgnoreCase("nT03"))
/*       */     {
/*  6572 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6574 */         Double tDouble = new Double(FValue);
/*  6575 */         double d = tDouble.doubleValue();
/*  6576 */         this.nT03 = d;
/*       */       }
/*       */     }
/*  6579 */     if (FCode.equalsIgnoreCase("nT04"))
/*       */     {
/*  6581 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6583 */         Double tDouble = new Double(FValue);
/*  6584 */         double d = tDouble.doubleValue();
/*  6585 */         this.nT04 = d;
/*       */       }
/*       */     }
/*  6588 */     if (FCode.equalsIgnoreCase("nT05"))
/*       */     {
/*  6590 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6592 */         Double tDouble = new Double(FValue);
/*  6593 */         double d = tDouble.doubleValue();
/*  6594 */         this.nT05 = d;
/*       */       }
/*       */     }
/*  6597 */     if (FCode.equalsIgnoreCase("nT06"))
/*       */     {
/*  6599 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6601 */         Double tDouble = new Double(FValue);
/*  6602 */         double d = tDouble.doubleValue();
/*  6603 */         this.nT06 = d;
/*       */       }
/*       */     }
/*  6606 */     if (FCode.equalsIgnoreCase("nT07"))
/*       */     {
/*  6608 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6610 */         Double tDouble = new Double(FValue);
/*  6611 */         double d = tDouble.doubleValue();
/*  6612 */         this.nT07 = d;
/*       */       }
/*       */     }
/*  6615 */     if (FCode.equalsIgnoreCase("nT08"))
/*       */     {
/*  6617 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6619 */         Double tDouble = new Double(FValue);
/*  6620 */         double d = tDouble.doubleValue();
/*  6621 */         this.nT08 = d;
/*       */       }
/*       */     }
/*  6624 */     if (FCode.equalsIgnoreCase("nT09"))
/*       */     {
/*  6626 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6628 */         Double tDouble = new Double(FValue);
/*  6629 */         double d = tDouble.doubleValue();
/*  6630 */         this.nT09 = d;
/*       */       }
/*       */     }
/*  6633 */     if (FCode.equalsIgnoreCase("nT10"))
/*       */     {
/*  6635 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6637 */         Double tDouble = new Double(FValue);
/*  6638 */         double d = tDouble.doubleValue();
/*  6639 */         this.nT10 = d;
/*       */       }
/*       */     }
/*  6642 */     if (FCode.equalsIgnoreCase("nT11"))
/*       */     {
/*  6644 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6646 */         Double tDouble = new Double(FValue);
/*  6647 */         double d = tDouble.doubleValue();
/*  6648 */         this.nT11 = d;
/*       */       }
/*       */     }
/*  6651 */     if (FCode.equalsIgnoreCase("nT12"))
/*       */     {
/*  6653 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6655 */         Double tDouble = new Double(FValue);
/*  6656 */         double d = tDouble.doubleValue();
/*  6657 */         this.nT12 = d;
/*       */       }
/*       */     }
/*  6660 */     if (FCode.equalsIgnoreCase("nT13"))
/*       */     {
/*  6662 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6664 */         Double tDouble = new Double(FValue);
/*  6665 */         double d = tDouble.doubleValue();
/*  6666 */         this.nT13 = d;
/*       */       }
/*       */     }
/*  6669 */     if (FCode.equalsIgnoreCase("nT14"))
/*       */     {
/*  6671 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6673 */         Double tDouble = new Double(FValue);
/*  6674 */         double d = tDouble.doubleValue();
/*  6675 */         this.nT14 = d;
/*       */       }
/*       */     }
/*  6678 */     if (FCode.equalsIgnoreCase("nT15"))
/*       */     {
/*  6680 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6682 */         Double tDouble = new Double(FValue);
/*  6683 */         double d = tDouble.doubleValue();
/*  6684 */         this.nT15 = d;
/*       */       }
/*       */     }
/*  6687 */     if (FCode.equalsIgnoreCase("nT16"))
/*       */     {
/*  6689 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6691 */         Double tDouble = new Double(FValue);
/*  6692 */         double d = tDouble.doubleValue();
/*  6693 */         this.nT16 = d;
/*       */       }
/*       */     }
/*  6696 */     if (FCode.equalsIgnoreCase("nT17"))
/*       */     {
/*  6698 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6700 */         Double tDouble = new Double(FValue);
/*  6701 */         double d = tDouble.doubleValue();
/*  6702 */         this.nT17 = d;
/*       */       }
/*       */     }
/*  6705 */     if (FCode.equalsIgnoreCase("nT18"))
/*       */     {
/*  6707 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6709 */         Double tDouble = new Double(FValue);
/*  6710 */         double d = tDouble.doubleValue();
/*  6711 */         this.nT18 = d;
/*       */       }
/*       */     }
/*  6714 */     if (FCode.equalsIgnoreCase("nT19"))
/*       */     {
/*  6716 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6718 */         Double tDouble = new Double(FValue);
/*  6719 */         double d = tDouble.doubleValue();
/*  6720 */         this.nT19 = d;
/*       */       }
/*       */     }
/*  6723 */     if (FCode.equalsIgnoreCase("nT20"))
/*       */     {
/*  6725 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6727 */         Double tDouble = new Double(FValue);
/*  6728 */         double d = tDouble.doubleValue();
/*  6729 */         this.nT20 = d;
/*       */       }
/*       */     }
/*  6732 */     if (FCode.equalsIgnoreCase("nT21"))
/*       */     {
/*  6734 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6736 */         Double tDouble = new Double(FValue);
/*  6737 */         double d = tDouble.doubleValue();
/*  6738 */         this.nT21 = d;
/*       */       }
/*       */     }
/*  6741 */     if (FCode.equalsIgnoreCase("nT22"))
/*       */     {
/*  6743 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6745 */         Double tDouble = new Double(FValue);
/*  6746 */         double d = tDouble.doubleValue();
/*  6747 */         this.nT22 = d;
/*       */       }
/*       */     }
/*  6750 */     if (FCode.equalsIgnoreCase("nT23"))
/*       */     {
/*  6752 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6754 */         Double tDouble = new Double(FValue);
/*  6755 */         double d = tDouble.doubleValue();
/*  6756 */         this.nT23 = d;
/*       */       }
/*       */     }
/*  6759 */     if (FCode.equalsIgnoreCase("nT24"))
/*       */     {
/*  6761 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6763 */         Double tDouble = new Double(FValue);
/*  6764 */         double d = tDouble.doubleValue();
/*  6765 */         this.nT24 = d;
/*       */       }
/*       */     }
/*  6768 */     if (FCode.equalsIgnoreCase("nT25"))
/*       */     {
/*  6770 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6772 */         Double tDouble = new Double(FValue);
/*  6773 */         double d = tDouble.doubleValue();
/*  6774 */         this.nT25 = d;
/*       */       }
/*       */     }
/*  6777 */     if (FCode.equalsIgnoreCase("nT26"))
/*       */     {
/*  6779 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6781 */         Double tDouble = new Double(FValue);
/*  6782 */         double d = tDouble.doubleValue();
/*  6783 */         this.nT26 = d;
/*       */       }
/*       */     }
/*  6786 */     if (FCode.equalsIgnoreCase("nT27"))
/*       */     {
/*  6788 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6790 */         Double tDouble = new Double(FValue);
/*  6791 */         double d = tDouble.doubleValue();
/*  6792 */         this.nT27 = d;
/*       */       }
/*       */     }
/*  6795 */     if (FCode.equalsIgnoreCase("nT28"))
/*       */     {
/*  6797 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6799 */         Double tDouble = new Double(FValue);
/*  6800 */         double d = tDouble.doubleValue();
/*  6801 */         this.nT28 = d;
/*       */       }
/*       */     }
/*  6804 */     if (FCode.equalsIgnoreCase("nT29"))
/*       */     {
/*  6806 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6808 */         Double tDouble = new Double(FValue);
/*  6809 */         double d = tDouble.doubleValue();
/*  6810 */         this.nT29 = d;
/*       */       }
/*       */     }
/*  6813 */     if (FCode.equalsIgnoreCase("nT30"))
/*       */     {
/*  6815 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6817 */         Double tDouble = new Double(FValue);
/*  6818 */         double d = tDouble.doubleValue();
/*  6819 */         this.nT30 = d;
/*       */       }
/*       */     }
/*  6822 */     if (FCode.equalsIgnoreCase("nT31"))
/*       */     {
/*  6824 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6826 */         Double tDouble = new Double(FValue);
/*  6827 */         double d = tDouble.doubleValue();
/*  6828 */         this.nT31 = d;
/*       */       }
/*       */     }
/*  6831 */     if (FCode.equalsIgnoreCase("nT32"))
/*       */     {
/*  6833 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6835 */         Double tDouble = new Double(FValue);
/*  6836 */         double d = tDouble.doubleValue();
/*  6837 */         this.nT32 = d;
/*       */       }
/*       */     }
/*  6840 */     if (FCode.equalsIgnoreCase("nT33"))
/*       */     {
/*  6842 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6844 */         Double tDouble = new Double(FValue);
/*  6845 */         double d = tDouble.doubleValue();
/*  6846 */         this.nT33 = d;
/*       */       }
/*       */     }
/*  6849 */     if (FCode.equalsIgnoreCase("nT34"))
/*       */     {
/*  6851 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6853 */         Double tDouble = new Double(FValue);
/*  6854 */         double d = tDouble.doubleValue();
/*  6855 */         this.nT34 = d;
/*       */       }
/*       */     }
/*  6858 */     if (FCode.equalsIgnoreCase("nT35"))
/*       */     {
/*  6860 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6862 */         Double tDouble = new Double(FValue);
/*  6863 */         double d = tDouble.doubleValue();
/*  6864 */         this.nT35 = d;
/*       */       }
/*       */     }
/*  6867 */     if (FCode.equalsIgnoreCase("nT36"))
/*       */     {
/*  6869 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6871 */         Double tDouble = new Double(FValue);
/*  6872 */         double d = tDouble.doubleValue();
/*  6873 */         this.nT36 = d;
/*       */       }
/*       */     }
/*  6876 */     if (FCode.equalsIgnoreCase("nT37"))
/*       */     {
/*  6878 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6880 */         Double tDouble = new Double(FValue);
/*  6881 */         double d = tDouble.doubleValue();
/*  6882 */         this.nT37 = d;
/*       */       }
/*       */     }
/*  6885 */     if (FCode.equalsIgnoreCase("nT38"))
/*       */     {
/*  6887 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6889 */         Double tDouble = new Double(FValue);
/*  6890 */         double d = tDouble.doubleValue();
/*  6891 */         this.nT38 = d;
/*       */       }
/*       */     }
/*  6894 */     if (FCode.equalsIgnoreCase("nT39"))
/*       */     {
/*  6896 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6898 */         Double tDouble = new Double(FValue);
/*  6899 */         double d = tDouble.doubleValue();
/*  6900 */         this.nT39 = d;
/*       */       }
/*       */     }
/*  6903 */     if (FCode.equalsIgnoreCase("nT40"))
/*       */     {
/*  6905 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6907 */         Double tDouble = new Double(FValue);
/*  6908 */         double d = tDouble.doubleValue();
/*  6909 */         this.nT40 = d;
/*       */       }
/*       */     }
/*  6912 */     if (FCode.equalsIgnoreCase("nT41"))
/*       */     {
/*  6914 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6916 */         Double tDouble = new Double(FValue);
/*  6917 */         double d = tDouble.doubleValue();
/*  6918 */         this.nT41 = d;
/*       */       }
/*       */     }
/*  6921 */     if (FCode.equalsIgnoreCase("nT42"))
/*       */     {
/*  6923 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6925 */         Double tDouble = new Double(FValue);
/*  6926 */         double d = tDouble.doubleValue();
/*  6927 */         this.nT42 = d;
/*       */       }
/*       */     }
/*  6930 */     if (FCode.equalsIgnoreCase("nT43"))
/*       */     {
/*  6932 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6934 */         Double tDouble = new Double(FValue);
/*  6935 */         double d = tDouble.doubleValue();
/*  6936 */         this.nT43 = d;
/*       */       }
/*       */     }
/*  6939 */     if (FCode.equalsIgnoreCase("nT44"))
/*       */     {
/*  6941 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6943 */         Double tDouble = new Double(FValue);
/*  6944 */         double d = tDouble.doubleValue();
/*  6945 */         this.nT44 = d;
/*       */       }
/*       */     }
/*  6948 */     if (FCode.equalsIgnoreCase("nT45"))
/*       */     {
/*  6950 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6952 */         Double tDouble = new Double(FValue);
/*  6953 */         double d = tDouble.doubleValue();
/*  6954 */         this.nT45 = d;
/*       */       }
/*       */     }
/*  6957 */     if (FCode.equalsIgnoreCase("nT46"))
/*       */     {
/*  6959 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6961 */         Double tDouble = new Double(FValue);
/*  6962 */         double d = tDouble.doubleValue();
/*  6963 */         this.nT46 = d;
/*       */       }
/*       */     }
/*  6966 */     if (FCode.equalsIgnoreCase("nT47"))
/*       */     {
/*  6968 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6970 */         Double tDouble = new Double(FValue);
/*  6971 */         double d = tDouble.doubleValue();
/*  6972 */         this.nT47 = d;
/*       */       }
/*       */     }
/*  6975 */     if (FCode.equalsIgnoreCase("nT48"))
/*       */     {
/*  6977 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6979 */         Double tDouble = new Double(FValue);
/*  6980 */         double d = tDouble.doubleValue();
/*  6981 */         this.nT48 = d;
/*       */       }
/*       */     }
/*  6984 */     if (FCode.equalsIgnoreCase("nT49"))
/*       */     {
/*  6986 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6988 */         Double tDouble = new Double(FValue);
/*  6989 */         double d = tDouble.doubleValue();
/*  6990 */         this.nT49 = d;
/*       */       }
/*       */     }
/*  6993 */     if (FCode.equalsIgnoreCase("nT50"))
/*       */     {
/*  6995 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  6997 */         Double tDouble = new Double(FValue);
/*  6998 */         double d = tDouble.doubleValue();
/*  6999 */         this.nT50 = d;
/*       */       }
/*       */     }
/*  7002 */     if (FCode.equalsIgnoreCase("nT51"))
/*       */     {
/*  7004 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7006 */         Double tDouble = new Double(FValue);
/*  7007 */         double d = tDouble.doubleValue();
/*  7008 */         this.nT51 = d;
/*       */       }
/*       */     }
/*  7011 */     if (FCode.equalsIgnoreCase("nT52"))
/*       */     {
/*  7013 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7015 */         Double tDouble = new Double(FValue);
/*  7016 */         double d = tDouble.doubleValue();
/*  7017 */         this.nT52 = d;
/*       */       }
/*       */     }
/*  7020 */     if (FCode.equalsIgnoreCase("nT53"))
/*       */     {
/*  7022 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7024 */         Double tDouble = new Double(FValue);
/*  7025 */         double d = tDouble.doubleValue();
/*  7026 */         this.nT53 = d;
/*       */       }
/*       */     }
/*  7029 */     if (FCode.equalsIgnoreCase("nT54"))
/*       */     {
/*  7031 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7033 */         Double tDouble = new Double(FValue);
/*  7034 */         double d = tDouble.doubleValue();
/*  7035 */         this.nT54 = d;
/*       */       }
/*       */     }
/*  7038 */     if (FCode.equalsIgnoreCase("nT55"))
/*       */     {
/*  7040 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7042 */         Double tDouble = new Double(FValue);
/*  7043 */         double d = tDouble.doubleValue();
/*  7044 */         this.nT55 = d;
/*       */       }
/*       */     }
/*  7047 */     if (FCode.equalsIgnoreCase("nT56"))
/*       */     {
/*  7049 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7051 */         Double tDouble = new Double(FValue);
/*  7052 */         double d = tDouble.doubleValue();
/*  7053 */         this.nT56 = d;
/*       */       }
/*       */     }
/*  7056 */     if (FCode.equalsIgnoreCase("nT57"))
/*       */     {
/*  7058 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7060 */         Double tDouble = new Double(FValue);
/*  7061 */         double d = tDouble.doubleValue();
/*  7062 */         this.nT57 = d;
/*       */       }
/*       */     }
/*  7065 */     if (FCode.equalsIgnoreCase("nT58"))
/*       */     {
/*  7067 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7069 */         Double tDouble = new Double(FValue);
/*  7070 */         double d = tDouble.doubleValue();
/*  7071 */         this.nT58 = d;
/*       */       }
/*       */     }
/*  7074 */     if (FCode.equalsIgnoreCase("nT59"))
/*       */     {
/*  7076 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7078 */         Double tDouble = new Double(FValue);
/*  7079 */         double d = tDouble.doubleValue();
/*  7080 */         this.nT59 = d;
/*       */       }
/*       */     }
/*  7083 */     if (FCode.equalsIgnoreCase("nT60"))
/*       */     {
/*  7085 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7087 */         Double tDouble = new Double(FValue);
/*  7088 */         double d = tDouble.doubleValue();
/*  7089 */         this.nT60 = d;
/*       */       }
/*       */     }
/*  7092 */     if (FCode.equalsIgnoreCase("nT61"))
/*       */     {
/*  7094 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7096 */         Double tDouble = new Double(FValue);
/*  7097 */         double d = tDouble.doubleValue();
/*  7098 */         this.nT61 = d;
/*       */       }
/*       */     }
/*  7101 */     if (FCode.equalsIgnoreCase("nT62"))
/*       */     {
/*  7103 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7105 */         Double tDouble = new Double(FValue);
/*  7106 */         double d = tDouble.doubleValue();
/*  7107 */         this.nT62 = d;
/*       */       }
/*       */     }
/*  7110 */     if (FCode.equalsIgnoreCase("nT63"))
/*       */     {
/*  7112 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7114 */         Double tDouble = new Double(FValue);
/*  7115 */         double d = tDouble.doubleValue();
/*  7116 */         this.nT63 = d;
/*       */       }
/*       */     }
/*  7119 */     if (FCode.equalsIgnoreCase("nT64"))
/*       */     {
/*  7121 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7123 */         Double tDouble = new Double(FValue);
/*  7124 */         double d = tDouble.doubleValue();
/*  7125 */         this.nT64 = d;
/*       */       }
/*       */     }
/*  7128 */     if (FCode.equalsIgnoreCase("nT65"))
/*       */     {
/*  7130 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7132 */         Double tDouble = new Double(FValue);
/*  7133 */         double d = tDouble.doubleValue();
/*  7134 */         this.nT65 = d;
/*       */       }
/*       */     }
/*  7137 */     if (FCode.equalsIgnoreCase("nT66"))
/*       */     {
/*  7139 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7141 */         Double tDouble = new Double(FValue);
/*  7142 */         double d = tDouble.doubleValue();
/*  7143 */         this.nT66 = d;
/*       */       }
/*       */     }
/*  7146 */     if (FCode.equalsIgnoreCase("nT67"))
/*       */     {
/*  7148 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7150 */         Double tDouble = new Double(FValue);
/*  7151 */         double d = tDouble.doubleValue();
/*  7152 */         this.nT67 = d;
/*       */       }
/*       */     }
/*  7155 */     if (FCode.equalsIgnoreCase("nT68"))
/*       */     {
/*  7157 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7159 */         Double tDouble = new Double(FValue);
/*  7160 */         double d = tDouble.doubleValue();
/*  7161 */         this.nT68 = d;
/*       */       }
/*       */     }
/*  7164 */     if (FCode.equalsIgnoreCase("nT69"))
/*       */     {
/*  7166 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7168 */         Double tDouble = new Double(FValue);
/*  7169 */         double d = tDouble.doubleValue();
/*  7170 */         this.nT69 = d;
/*       */       }
/*       */     }
/*  7173 */     if (FCode.equalsIgnoreCase("nT70"))
/*       */     {
/*  7175 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7177 */         Double tDouble = new Double(FValue);
/*  7178 */         double d = tDouble.doubleValue();
/*  7179 */         this.nT70 = d;
/*       */       }
/*       */     }
/*  7182 */     if (FCode.equalsIgnoreCase("nT71"))
/*       */     {
/*  7184 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7186 */         Double tDouble = new Double(FValue);
/*  7187 */         double d = tDouble.doubleValue();
/*  7188 */         this.nT71 = d;
/*       */       }
/*       */     }
/*  7191 */     if (FCode.equalsIgnoreCase("nT72"))
/*       */     {
/*  7193 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7195 */         Double tDouble = new Double(FValue);
/*  7196 */         double d = tDouble.doubleValue();
/*  7197 */         this.nT72 = d;
/*       */       }
/*       */     }
/*  7200 */     if (FCode.equalsIgnoreCase("nT73"))
/*       */     {
/*  7202 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7204 */         Double tDouble = new Double(FValue);
/*  7205 */         double d = tDouble.doubleValue();
/*  7206 */         this.nT73 = d;
/*       */       }
/*       */     }
/*  7209 */     if (FCode.equalsIgnoreCase("nT74"))
/*       */     {
/*  7211 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7213 */         Double tDouble = new Double(FValue);
/*  7214 */         double d = tDouble.doubleValue();
/*  7215 */         this.nT74 = d;
/*       */       }
/*       */     }
/*  7218 */     if (FCode.equalsIgnoreCase("nT75"))
/*       */     {
/*  7220 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7222 */         Double tDouble = new Double(FValue);
/*  7223 */         double d = tDouble.doubleValue();
/*  7224 */         this.nT75 = d;
/*       */       }
/*       */     }
/*  7227 */     if (FCode.equalsIgnoreCase("nT76"))
/*       */     {
/*  7229 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7231 */         Double tDouble = new Double(FValue);
/*  7232 */         double d = tDouble.doubleValue();
/*  7233 */         this.nT76 = d;
/*       */       }
/*       */     }
/*  7236 */     if (FCode.equalsIgnoreCase("nT77"))
/*       */     {
/*  7238 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7240 */         Double tDouble = new Double(FValue);
/*  7241 */         double d = tDouble.doubleValue();
/*  7242 */         this.nT77 = d;
/*       */       }
/*       */     }
/*  7245 */     if (FCode.equalsIgnoreCase("nT78"))
/*       */     {
/*  7247 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7249 */         Double tDouble = new Double(FValue);
/*  7250 */         double d = tDouble.doubleValue();
/*  7251 */         this.nT78 = d;
/*       */       }
/*       */     }
/*  7254 */     if (FCode.equalsIgnoreCase("nT79"))
/*       */     {
/*  7256 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7258 */         Double tDouble = new Double(FValue);
/*  7259 */         double d = tDouble.doubleValue();
/*  7260 */         this.nT79 = d;
/*       */       }
/*       */     }
/*  7263 */     if (FCode.equalsIgnoreCase("nT80"))
/*       */     {
/*  7265 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7267 */         Double tDouble = new Double(FValue);
/*  7268 */         double d = tDouble.doubleValue();
/*  7269 */         this.nT80 = d;
/*       */       }
/*       */     }
/*  7272 */     if (FCode.equalsIgnoreCase("nF01"))
/*       */     {
/*  7274 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7276 */         Double tDouble = new Double(FValue);
/*  7277 */         double d = tDouble.doubleValue();
/*  7278 */         this.nF01 = d;
/*       */       }
/*       */     }
/*  7281 */     if (FCode.equalsIgnoreCase("nF02"))
/*       */     {
/*  7283 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7285 */         Double tDouble = new Double(FValue);
/*  7286 */         double d = tDouble.doubleValue();
/*  7287 */         this.nF02 = d;
/*       */       }
/*       */     }
/*  7290 */     if (FCode.equalsIgnoreCase("nF03"))
/*       */     {
/*  7292 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7294 */         Double tDouble = new Double(FValue);
/*  7295 */         double d = tDouble.doubleValue();
/*  7296 */         this.nF03 = d;
/*       */       }
/*       */     }
/*  7299 */     if (FCode.equalsIgnoreCase("nF04"))
/*       */     {
/*  7301 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7303 */         Double tDouble = new Double(FValue);
/*  7304 */         double d = tDouble.doubleValue();
/*  7305 */         this.nF04 = d;
/*       */       }
/*       */     }
/*  7308 */     if (FCode.equalsIgnoreCase("nF05"))
/*       */     {
/*  7310 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7312 */         Double tDouble = new Double(FValue);
/*  7313 */         double d = tDouble.doubleValue();
/*  7314 */         this.nF05 = d;
/*       */       }
/*       */     }
/*  7317 */     if (FCode.equalsIgnoreCase("nF06"))
/*       */     {
/*  7319 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7321 */         Double tDouble = new Double(FValue);
/*  7322 */         double d = tDouble.doubleValue();
/*  7323 */         this.nF06 = d;
/*       */       }
/*       */     }
/*  7326 */     if (FCode.equalsIgnoreCase("nF07"))
/*       */     {
/*  7328 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7330 */         Double tDouble = new Double(FValue);
/*  7331 */         double d = tDouble.doubleValue();
/*  7332 */         this.nF07 = d;
/*       */       }
/*       */     }
/*  7335 */     if (FCode.equalsIgnoreCase("nF08"))
/*       */     {
/*  7337 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7339 */         Double tDouble = new Double(FValue);
/*  7340 */         double d = tDouble.doubleValue();
/*  7341 */         this.nF08 = d;
/*       */       }
/*       */     }
/*  7344 */     if (FCode.equalsIgnoreCase("nF09"))
/*       */     {
/*  7346 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7348 */         Double tDouble = new Double(FValue);
/*  7349 */         double d = tDouble.doubleValue();
/*  7350 */         this.nF09 = d;
/*       */       }
/*       */     }
/*  7353 */     if (FCode.equalsIgnoreCase("nF10"))
/*       */     {
/*  7355 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7357 */         Double tDouble = new Double(FValue);
/*  7358 */         double d = tDouble.doubleValue();
/*  7359 */         this.nF10 = d;
/*       */       }
/*       */     }
/*  7362 */     if (FCode.equalsIgnoreCase("nS01"))
/*       */     {
/*  7364 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7366 */         Double tDouble = new Double(FValue);
/*  7367 */         double d = tDouble.doubleValue();
/*  7368 */         this.nS01 = d;
/*       */       }
/*       */     }
/*  7371 */     if (FCode.equalsIgnoreCase("nS02"))
/*       */     {
/*  7373 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7375 */         Double tDouble = new Double(FValue);
/*  7376 */         double d = tDouble.doubleValue();
/*  7377 */         this.nS02 = d;
/*       */       }
/*       */     }
/*  7380 */     if (FCode.equalsIgnoreCase("nS03"))
/*       */     {
/*  7382 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7384 */         Double tDouble = new Double(FValue);
/*  7385 */         double d = tDouble.doubleValue();
/*  7386 */         this.nS03 = d;
/*       */       }
/*       */     }
/*  7389 */     if (FCode.equalsIgnoreCase("nS04"))
/*       */     {
/*  7391 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7393 */         Double tDouble = new Double(FValue);
/*  7394 */         double d = tDouble.doubleValue();
/*  7395 */         this.nS04 = d;
/*       */       }
/*       */     }
/*  7398 */     if (FCode.equalsIgnoreCase("nS05"))
/*       */     {
/*  7400 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7402 */         Double tDouble = new Double(FValue);
/*  7403 */         double d = tDouble.doubleValue();
/*  7404 */         this.nS05 = d;
/*       */       }
/*       */     }
/*  7407 */     if (FCode.equalsIgnoreCase("nS06"))
/*       */     {
/*  7409 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7411 */         Double tDouble = new Double(FValue);
/*  7412 */         double d = tDouble.doubleValue();
/*  7413 */         this.nS06 = d;
/*       */       }
/*       */     }
/*  7416 */     if (FCode.equalsIgnoreCase("nS07"))
/*       */     {
/*  7418 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7420 */         Double tDouble = new Double(FValue);
/*  7421 */         double d = tDouble.doubleValue();
/*  7422 */         this.nS07 = d;
/*       */       }
/*       */     }
/*  7425 */     if (FCode.equalsIgnoreCase("nS08"))
/*       */     {
/*  7427 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7429 */         Double tDouble = new Double(FValue);
/*  7430 */         double d = tDouble.doubleValue();
/*  7431 */         this.nS08 = d;
/*       */       }
/*       */     }
/*  7434 */     if (FCode.equalsIgnoreCase("nS09"))
/*       */     {
/*  7436 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7438 */         Double tDouble = new Double(FValue);
/*  7439 */         double d = tDouble.doubleValue();
/*  7440 */         this.nS09 = d;
/*       */       }
/*       */     }
/*  7443 */     if (FCode.equalsIgnoreCase("nS10"))
/*       */     {
/*  7445 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7447 */         Double tDouble = new Double(FValue);
/*  7448 */         double d = tDouble.doubleValue();
/*  7449 */         this.nS10 = d;
/*       */       }
/*       */     }
/*  7452 */     if (FCode.equalsIgnoreCase("iNT01"))
/*       */     {
/*  7454 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7456 */         Integer tInteger = new Integer(FValue);
/*  7457 */         int i = tInteger.intValue();
/*  7458 */         this.iNT01 = i;
/*       */       }
/*       */     }
/*  7461 */     if (FCode.equalsIgnoreCase("iNT02"))
/*       */     {
/*  7463 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7465 */         Integer tInteger = new Integer(FValue);
/*  7466 */         int i = tInteger.intValue();
/*  7467 */         this.iNT02 = i;
/*       */       }
/*       */     }
/*  7470 */     if (FCode.equalsIgnoreCase("iNT03"))
/*       */     {
/*  7472 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7474 */         Integer tInteger = new Integer(FValue);
/*  7475 */         int i = tInteger.intValue();
/*  7476 */         this.iNT03 = i;
/*       */       }
/*       */     }
/*  7479 */     if (FCode.equalsIgnoreCase("iNT04"))
/*       */     {
/*  7481 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7483 */         Integer tInteger = new Integer(FValue);
/*  7484 */         int i = tInteger.intValue();
/*  7485 */         this.iNT04 = i;
/*       */       }
/*       */     }
/*  7488 */     if (FCode.equalsIgnoreCase("iNT05"))
/*       */     {
/*  7490 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7492 */         Integer tInteger = new Integer(FValue);
/*  7493 */         int i = tInteger.intValue();
/*  7494 */         this.iNT05 = i;
/*       */       }
/*       */     }
/*  7497 */     if (FCode.equalsIgnoreCase("iNT06"))
/*       */     {
/*  7499 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7501 */         Integer tInteger = new Integer(FValue);
/*  7502 */         int i = tInteger.intValue();
/*  7503 */         this.iNT06 = i;
/*       */       }
/*       */     }
/*  7506 */     if (FCode.equalsIgnoreCase("iNT07"))
/*       */     {
/*  7508 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7510 */         Integer tInteger = new Integer(FValue);
/*  7511 */         int i = tInteger.intValue();
/*  7512 */         this.iNT07 = i;
/*       */       }
/*       */     }
/*  7515 */     if (FCode.equalsIgnoreCase("iNT08"))
/*       */     {
/*  7517 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7519 */         Integer tInteger = new Integer(FValue);
/*  7520 */         int i = tInteger.intValue();
/*  7521 */         this.iNT08 = i;
/*       */       }
/*       */     }
/*  7524 */     if (FCode.equalsIgnoreCase("iNT09"))
/*       */     {
/*  7526 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7528 */         Integer tInteger = new Integer(FValue);
/*  7529 */         int i = tInteger.intValue();
/*  7530 */         this.iNT09 = i;
/*       */       }
/*       */     }
/*  7533 */     if (FCode.equalsIgnoreCase("iNT10"))
/*       */     {
/*  7535 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7537 */         Integer tInteger = new Integer(FValue);
/*  7538 */         int i = tInteger.intValue();
/*  7539 */         this.iNT10 = i;
/*       */       }
/*       */     }
/*  7542 */     if (FCode.equalsIgnoreCase("iNT11"))
/*       */     {
/*  7544 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7546 */         Integer tInteger = new Integer(FValue);
/*  7547 */         int i = tInteger.intValue();
/*  7548 */         this.iNT11 = i;
/*       */       }
/*       */     }
/*  7551 */     if (FCode.equalsIgnoreCase("iNT12"))
/*       */     {
/*  7553 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7555 */         Integer tInteger = new Integer(FValue);
/*  7556 */         int i = tInteger.intValue();
/*  7557 */         this.iNT12 = i;
/*       */       }
/*       */     }
/*  7560 */     if (FCode.equalsIgnoreCase("iNT13"))
/*       */     {
/*  7562 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7564 */         Integer tInteger = new Integer(FValue);
/*  7565 */         int i = tInteger.intValue();
/*  7566 */         this.iNT13 = i;
/*       */       }
/*       */     }
/*  7569 */     if (FCode.equalsIgnoreCase("iNT14"))
/*       */     {
/*  7571 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7573 */         Integer tInteger = new Integer(FValue);
/*  7574 */         int i = tInteger.intValue();
/*  7575 */         this.iNT14 = i;
/*       */       }
/*       */     }
/*  7578 */     if (FCode.equalsIgnoreCase("iNT15"))
/*       */     {
/*  7580 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7582 */         Integer tInteger = new Integer(FValue);
/*  7583 */         int i = tInteger.intValue();
/*  7584 */         this.iNT15 = i;
/*       */       }
/*       */     }
/*  7587 */     if (FCode.equalsIgnoreCase("iNT16"))
/*       */     {
/*  7589 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7591 */         Integer tInteger = new Integer(FValue);
/*  7592 */         int i = tInteger.intValue();
/*  7593 */         this.iNT16 = i;
/*       */       }
/*       */     }
/*  7596 */     if (FCode.equalsIgnoreCase("iNT17"))
/*       */     {
/*  7598 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7600 */         Integer tInteger = new Integer(FValue);
/*  7601 */         int i = tInteger.intValue();
/*  7602 */         this.iNT17 = i;
/*       */       }
/*       */     }
/*  7605 */     if (FCode.equalsIgnoreCase("iNT18"))
/*       */     {
/*  7607 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7609 */         Integer tInteger = new Integer(FValue);
/*  7610 */         int i = tInteger.intValue();
/*  7611 */         this.iNT18 = i;
/*       */       }
/*       */     }
/*  7614 */     if (FCode.equalsIgnoreCase("iNT19"))
/*       */     {
/*  7616 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7618 */         Integer tInteger = new Integer(FValue);
/*  7619 */         int i = tInteger.intValue();
/*  7620 */         this.iNT19 = i;
/*       */       }
/*       */     }
/*  7623 */     if (FCode.equalsIgnoreCase("iNT20"))
/*       */     {
/*  7625 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7627 */         Integer tInteger = new Integer(FValue);
/*  7628 */         int i = tInteger.intValue();
/*  7629 */         this.iNT20 = i;
/*       */       }
/*       */     }
/*  7632 */     if (FCode.equalsIgnoreCase("iNT21"))
/*       */     {
/*  7634 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7636 */         Integer tInteger = new Integer(FValue);
/*  7637 */         int i = tInteger.intValue();
/*  7638 */         this.iNT21 = i;
/*       */       }
/*       */     }
/*  7641 */     if (FCode.equalsIgnoreCase("iNT22"))
/*       */     {
/*  7643 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7645 */         Integer tInteger = new Integer(FValue);
/*  7646 */         int i = tInteger.intValue();
/*  7647 */         this.iNT22 = i;
/*       */       }
/*       */     }
/*  7650 */     if (FCode.equalsIgnoreCase("iNT23"))
/*       */     {
/*  7652 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7654 */         Integer tInteger = new Integer(FValue);
/*  7655 */         int i = tInteger.intValue();
/*  7656 */         this.iNT23 = i;
/*       */       }
/*       */     }
/*  7659 */     if (FCode.equalsIgnoreCase("iNT24"))
/*       */     {
/*  7661 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7663 */         Integer tInteger = new Integer(FValue);
/*  7664 */         int i = tInteger.intValue();
/*  7665 */         this.iNT24 = i;
/*       */       }
/*       */     }
/*  7668 */     if (FCode.equalsIgnoreCase("iNT25"))
/*       */     {
/*  7670 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7672 */         Integer tInteger = new Integer(FValue);
/*  7673 */         int i = tInteger.intValue();
/*  7674 */         this.iNT25 = i;
/*       */       }
/*       */     }
/*  7677 */     if (FCode.equalsIgnoreCase("v1"))
/*       */     {
/*  7679 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7681 */         this.v1 = FValue.trim();
/*       */       }
/*       */       else
/*  7684 */         this.v1 = null;
/*       */     }
/*  7686 */     if (FCode.equalsIgnoreCase("v2"))
/*       */     {
/*  7688 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7690 */         this.v2 = FValue.trim();
/*       */       }
/*       */       else
/*  7693 */         this.v2 = null;
/*       */     }
/*  7695 */     if (FCode.equalsIgnoreCase("v3"))
/*       */     {
/*  7697 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7699 */         this.v3 = FValue.trim();
/*       */       }
/*       */       else
/*  7702 */         this.v3 = null;
/*       */     }
/*  7704 */     if (FCode.equalsIgnoreCase("v4"))
/*       */     {
/*  7706 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7708 */         this.v4 = FValue.trim();
/*       */       }
/*       */       else
/*  7711 */         this.v4 = null;
/*       */     }
/*  7713 */     if (FCode.equalsIgnoreCase("v5"))
/*       */     {
/*  7715 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7717 */         this.v5 = FValue.trim();
/*       */       }
/*       */       else
/*  7720 */         this.v5 = null;
/*       */     }
/*  7722 */     if (FCode.equalsIgnoreCase("v6"))
/*       */     {
/*  7724 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7726 */         this.v6 = FValue.trim();
/*       */       }
/*       */       else
/*  7729 */         this.v6 = null;
/*       */     }
/*  7731 */     if (FCode.equalsIgnoreCase("v7"))
/*       */     {
/*  7733 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7735 */         this.v7 = FValue.trim();
/*       */       }
/*       */       else
/*  7738 */         this.v7 = null;
/*       */     }
/*  7740 */     if (FCode.equalsIgnoreCase("v8"))
/*       */     {
/*  7742 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7744 */         this.v8 = FValue.trim();
/*       */       }
/*       */       else
/*  7747 */         this.v8 = null;
/*       */     }
/*  7749 */     if (FCode.equalsIgnoreCase("v9"))
/*       */     {
/*  7751 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7753 */         this.v9 = FValue.trim();
/*       */       }
/*       */       else
/*  7756 */         this.v9 = null;
/*       */     }
/*  7758 */     if (FCode.equalsIgnoreCase("v10"))
/*       */     {
/*  7760 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7762 */         this.v10 = FValue.trim();
/*       */       }
/*       */       else
/*  7765 */         this.v10 = null;
/*       */     }
/*  7767 */     if (FCode.equalsIgnoreCase("v11"))
/*       */     {
/*  7769 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7771 */         this.v11 = FValue.trim();
/*       */       }
/*       */       else
/*  7774 */         this.v11 = null;
/*       */     }
/*  7776 */     if (FCode.equalsIgnoreCase("v12"))
/*       */     {
/*  7778 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7780 */         this.v12 = FValue.trim();
/*       */       }
/*       */       else
/*  7783 */         this.v12 = null;
/*       */     }
/*  7785 */     if (FCode.equalsIgnoreCase("v13"))
/*       */     {
/*  7787 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7789 */         this.v13 = FValue.trim();
/*       */       }
/*       */       else
/*  7792 */         this.v13 = null;
/*       */     }
/*  7794 */     if (FCode.equalsIgnoreCase("v14"))
/*       */     {
/*  7796 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7798 */         this.v14 = FValue.trim();
/*       */       }
/*       */       else
/*  7801 */         this.v14 = null;
/*       */     }
/*  7803 */     if (FCode.equalsIgnoreCase("v15"))
/*       */     {
/*  7805 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7807 */         this.v15 = FValue.trim();
/*       */       }
/*       */       else
/*  7810 */         this.v15 = null;
/*       */     }
/*  7812 */     if (FCode.equalsIgnoreCase("v16"))
/*       */     {
/*  7814 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7816 */         this.v16 = FValue.trim();
/*       */       }
/*       */       else
/*  7819 */         this.v16 = null;
/*       */     }
/*  7821 */     if (FCode.equalsIgnoreCase("v17"))
/*       */     {
/*  7823 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7825 */         this.v17 = FValue.trim();
/*       */       }
/*       */       else
/*  7828 */         this.v17 = null;
/*       */     }
/*  7830 */     if (FCode.equalsIgnoreCase("v18"))
/*       */     {
/*  7832 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7834 */         this.v18 = FValue.trim();
/*       */       }
/*       */       else
/*  7837 */         this.v18 = null;
/*       */     }
/*  7839 */     if (FCode.equalsIgnoreCase("v19"))
/*       */     {
/*  7841 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7843 */         this.v19 = FValue.trim();
/*       */       }
/*       */       else
/*  7846 */         this.v19 = null;
/*       */     }
/*  7848 */     if (FCode.equalsIgnoreCase("v20"))
/*       */     {
/*  7850 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7852 */         this.v20 = FValue.trim();
/*       */       }
/*       */       else
/*  7855 */         this.v20 = null;
/*       */     }
/*  7857 */     if (FCode.equalsIgnoreCase("vT1"))
/*       */     {
/*  7859 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7861 */         this.vT1 = FValue.trim();
/*       */       }
/*       */       else
/*  7864 */         this.vT1 = null;
/*       */     }
/*  7866 */     if (FCode.equalsIgnoreCase("vT2"))
/*       */     {
/*  7868 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7870 */         this.vT2 = FValue.trim();
/*       */       }
/*       */       else
/*  7873 */         this.vT2 = null;
/*       */     }
/*  7875 */     if (FCode.equalsIgnoreCase("vT3"))
/*       */     {
/*  7877 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7879 */         this.vT3 = FValue.trim();
/*       */       }
/*       */       else
/*  7882 */         this.vT3 = null;
/*       */     }
/*  7884 */     if (FCode.equalsIgnoreCase("vT4"))
/*       */     {
/*  7886 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7888 */         this.vT4 = FValue.trim();
/*       */       }
/*       */       else
/*  7891 */         this.vT4 = null;
/*       */     }
/*  7893 */     if (FCode.equalsIgnoreCase("vT5"))
/*       */     {
/*  7895 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7897 */         this.vT5 = FValue.trim();
/*       */       }
/*       */       else
/*  7900 */         this.vT5 = null;
/*       */     }
/*  7902 */     if (FCode.equalsIgnoreCase("vT6"))
/*       */     {
/*  7904 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7906 */         this.vT6 = FValue.trim();
/*       */       }
/*       */       else
/*  7909 */         this.vT6 = null;
/*       */     }
/*  7911 */     if (FCode.equalsIgnoreCase("vT7"))
/*       */     {
/*  7913 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7915 */         this.vT7 = FValue.trim();
/*       */       }
/*       */       else
/*  7918 */         this.vT7 = null;
/*       */     }
/*  7920 */     if (FCode.equalsIgnoreCase("vT8"))
/*       */     {
/*  7922 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7924 */         this.vT8 = FValue.trim();
/*       */       }
/*       */       else
/*  7927 */         this.vT8 = null;
/*       */     }
/*  7929 */     if (FCode.equalsIgnoreCase("vE1"))
/*       */     {
/*  7931 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7933 */         this.vE1 = FValue.trim();
/*       */       }
/*       */       else
/*  7936 */         this.vE1 = null;
/*       */     }
/*  7938 */     if (FCode.equalsIgnoreCase("vE2"))
/*       */     {
/*  7940 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7942 */         this.vE2 = FValue.trim();
/*       */       }
/*       */       else
/*  7945 */         this.vE2 = null;
/*       */     }
/*  7947 */     if (FCode.equalsIgnoreCase("vE3"))
/*       */     {
/*  7949 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7951 */         this.vE3 = FValue.trim();
/*       */       }
/*       */       else
/*  7954 */         this.vE3 = null;
/*       */     }
/*  7956 */     if (FCode.equalsIgnoreCase("vE4"))
/*       */     {
/*  7958 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7960 */         this.vE4 = FValue.trim();
/*       */       }
/*       */       else
/*  7963 */         this.vE4 = null;
/*       */     }
/*  7965 */     if (FCode.equalsIgnoreCase("vE5"))
/*       */     {
/*  7967 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7969 */         this.vE5 = FValue.trim();
/*       */       }
/*       */       else
/*  7972 */         this.vE5 = null;
/*       */     }
/*  7974 */     if (FCode.equalsIgnoreCase("vE6"))
/*       */     {
/*  7976 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7978 */         this.vE6 = FValue.trim();
/*       */       }
/*       */       else
/*  7981 */         this.vE6 = null;
/*       */     }
/*  7983 */     if (FCode.equalsIgnoreCase("vE7"))
/*       */     {
/*  7985 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7987 */         this.vE7 = FValue.trim();
/*       */       }
/*       */       else
/*  7990 */         this.vE7 = null;
/*       */     }
/*  7992 */     if (FCode.equalsIgnoreCase("vE8"))
/*       */     {
/*  7994 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  7996 */         this.vE8 = FValue.trim();
/*       */       }
/*       */       else
/*  7999 */         this.vE8 = null;
/*       */     }
/*  8001 */     if (FCode.equalsIgnoreCase("vE9"))
/*       */     {
/*  8003 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8005 */         this.vE9 = FValue.trim();
/*       */       }
/*       */       else
/*  8008 */         this.vE9 = null;
/*       */     }
/*  8010 */     if (FCode.equalsIgnoreCase("vE10"))
/*       */     {
/*  8012 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8014 */         this.vE10 = FValue.trim();
/*       */       }
/*       */       else
/*  8017 */         this.vE10 = null;
/*       */     }
/*  8019 */     if (FCode.equalsIgnoreCase("d1"))
/*       */     {
/*  8021 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8023 */         this.d1 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8026 */         this.d1 = null;
/*       */     }
/*  8028 */     if (FCode.equalsIgnoreCase("d2"))
/*       */     {
/*  8030 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8032 */         this.d2 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8035 */         this.d2 = null;
/*       */     }
/*  8037 */     if (FCode.equalsIgnoreCase("d3"))
/*       */     {
/*  8039 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8041 */         this.d3 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8044 */         this.d3 = null;
/*       */     }
/*  8046 */     if (FCode.equalsIgnoreCase("d4"))
/*       */     {
/*  8048 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8050 */         this.d4 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8053 */         this.d4 = null;
/*       */     }
/*  8055 */     if (FCode.equalsIgnoreCase("d5"))
/*       */     {
/*  8057 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8059 */         this.d5 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8062 */         this.d5 = null;
/*       */     }
/*  8064 */     if (FCode.equalsIgnoreCase("d6"))
/*       */     {
/*  8066 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8068 */         this.d6 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8071 */         this.d6 = null;
/*       */     }
/*  8073 */     if (FCode.equalsIgnoreCase("d7"))
/*       */     {
/*  8075 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8077 */         this.d7 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8080 */         this.d7 = null;
/*       */     }
/*  8082 */     if (FCode.equalsIgnoreCase("d8"))
/*       */     {
/*  8084 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8086 */         this.d8 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8089 */         this.d8 = null;
/*       */     }
/*  8091 */     if (FCode.equalsIgnoreCase("d9"))
/*       */     {
/*  8093 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8095 */         this.d9 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8098 */         this.d9 = null;
/*       */     }
/*  8100 */     if (FCode.equalsIgnoreCase("d10"))
/*       */     {
/*  8102 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8104 */         this.d10 = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8107 */         this.d10 = null;
/*       */     }
/*  8109 */     if (FCode.equalsIgnoreCase("state"))
/*       */     {
/*  8111 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8113 */         this.state = FValue.trim();
/*       */       }
/*       */       else
/*  8116 */         this.state = null;
/*       */     }
/*  8118 */     if (FCode.equalsIgnoreCase("operator"))
/*       */     {
/*  8120 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8122 */         this.operator = FValue.trim();
/*       */       }
/*       */       else
/*  8125 */         this.operator = null;
/*       */     }
/*  8127 */     if (FCode.equalsIgnoreCase("makeDate"))
/*       */     {
/*  8129 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8131 */         this.makeDate = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8134 */         this.makeDate = null;
/*       */     }
/*  8136 */     if (FCode.equalsIgnoreCase("makeTime"))
/*       */     {
/*  8138 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8140 */         this.makeTime = FValue.trim();
/*       */       }
/*       */       else
/*  8143 */         this.makeTime = null;
/*       */     }
/*  8145 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*       */     {
/*  8147 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8149 */         this.modifyDate = this.fDate.getDate(FValue);
/*       */       }
/*       */       else
/*  8152 */         this.modifyDate = null;
/*       */     }
/*  8154 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*       */     {
/*  8156 */       if ((FValue != null) && (!FValue.equals("")))
/*       */       {
/*  8158 */         this.modifyTime = FValue.trim();
/*       */       }
/*       */       else
/*  8161 */         this.modifyTime = null;
/*       */     }
/*  8163 */     return true;
/*       */   }
/*       */ 
/*       */   public boolean equals(Object otherObject)
/*       */   {
/*  8168 */     if (otherObject == null) return false;
/*  8169 */     if (this == otherObject) return true;
/*  8170 */     if (getClass() != otherObject.getClass()) return false;
/*  8171 */     LAIndexInfoNewSchema other = (LAIndexInfoNewSchema)otherObject;
/*  8172 */     if ((this.indexCalNo == null) && (other.getIndexCalNo() != null)) return false;
/*  8173 */     if ((this.indexCalNo != null) && (!this.indexCalNo.equals(other.getIndexCalNo()))) return false;
/*  8174 */     if ((this.indexType == null) && (other.getIndexType() != null)) return false;
/*  8175 */     if ((this.indexType != null) && (!this.indexType.equals(other.getIndexType()))) return false;
/*  8176 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/*  8177 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/*  8178 */     if ((this.agentGroup == null) && (other.getAgentGroup() != null)) return false;
/*  8179 */     if ((this.agentGroup != null) && (!this.agentGroup.equals(other.getAgentGroup()))) return false;
/*  8180 */     if ((this.branchAttr == null) && (other.getBranchAttr() != null)) return false;
/*  8181 */     if ((this.branchAttr != null) && (!this.branchAttr.equals(other.getBranchAttr()))) return false;
/*  8182 */     if ((this.agentCode == null) && (other.getAgentCode() != null)) return false;
/*  8183 */     if ((this.agentCode != null) && (!this.agentCode.equals(other.getAgentCode()))) return false;
/*  8184 */     if ((this.agentGrade == null) && (other.getAgentGrade() != null)) return false;
/*  8185 */     if ((this.agentGrade != null) && (!this.agentGrade.equals(other.getAgentGrade()))) return false;
/*  8186 */     if ((this.agentTitle == null) && (other.getAgentTitle() != null)) return false;
/*  8187 */     if ((this.agentTitle != null) && (!this.agentTitle.equals(other.getAgentTitle()))) return false;
/*  8188 */     if (this.quaBgnMark != other.getQuaBgnMark()) return false;
/*  8189 */     if (this.postMonths != other.getPostMonths()) return false;
/*  8190 */     if ((this.assessMonth == null) && (other.getAssessMonth() != null)) return false;
/*  8191 */     if ((this.assessMonth != null) && (!this.assessMonth.equals(other.getAssessMonth()))) return false;
/*  8192 */     if ((this.agentGrade1 == null) && (other.getAgentGrade1() != null)) return false;
/*  8193 */     if ((this.agentGrade1 != null) && (!this.agentGrade1.equals(other.getAgentGrade1()))) return false;
/*  8194 */     if ((this.agentTitle1 == null) && (other.getAgentTitle1() != null)) return false;
/*  8195 */     if ((this.agentTitle1 != null) && (!this.agentTitle1.equals(other.getAgentTitle1()))) return false;
/*  8196 */     if ((this.agentGrade2 == null) && (other.getAgentGrade2() != null)) return false;
/*  8197 */     if ((this.agentGrade2 != null) && (!this.agentGrade2.equals(other.getAgentGrade2()))) return false;
/*  8198 */     if ((this.agentTitle2 == null) && (other.getAgentTitle2() != null)) return false;
/*  8199 */     if ((this.agentTitle2 != null) && (!this.agentTitle2.equals(other.getAgentTitle2()))) return false;
/*  8200 */     if ((this.agentGrade3 == null) && (other.getAgentGrade3() != null)) return false;
/*  8201 */     if ((this.agentGrade3 != null) && (!this.agentGrade3.equals(other.getAgentGrade3()))) return false;
/*  8202 */     if ((this.agentTitle3 == null) && (other.getAgentTitle3() != null)) return false;
/*  8203 */     if ((this.agentTitle3 != null) && (!this.agentTitle3.equals(other.getAgentTitle3()))) return false;
/*  8204 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/*  8205 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/*  8206 */     if ((this.startEnd == null) && (other.getStartEnd() != null)) return false;
/*  8207 */     if ((this.startEnd != null) && (!this.fDate.getString(this.startEnd).equals(other.getStartEnd()))) return false;
/*  8208 */     if ((this.startDate1 == null) && (other.getStartDate1() != null)) return false;
/*  8209 */     if ((this.startDate1 != null) && (!this.fDate.getString(this.startDate1).equals(other.getStartDate1()))) return false;
/*  8210 */     if ((this.startEnd1 == null) && (other.getStartEnd1() != null)) return false;
/*  8211 */     if ((this.startEnd1 != null) && (!this.fDate.getString(this.startEnd1).equals(other.getStartEnd1()))) return false;
/*  8212 */     if ((this.startDate2 == null) && (other.getStartDate2() != null)) return false;
/*  8213 */     if ((this.startDate2 != null) && (!this.fDate.getString(this.startDate2).equals(other.getStartDate2()))) return false;
/*  8214 */     if ((this.startEnd2 == null) && (other.getStartEnd2() != null)) return false;
/*  8215 */     if ((this.startEnd2 != null) && (!this.fDate.getString(this.startEnd2).equals(other.getStartEnd2()))) return false;
/*  8216 */     if ((this.startDate3 == null) && (other.getStartDate3() != null)) return false;
/*  8217 */     if ((this.startDate3 != null) && (!this.fDate.getString(this.startDate3).equals(other.getStartDate3()))) return false;
/*  8218 */     if ((this.startEnd3 == null) && (other.getStartEnd3() != null)) return false;
/*  8219 */     if ((this.startEnd3 != null) && (!this.fDate.getString(this.startEnd3).equals(other.getStartEnd3()))) return false;
/*  8220 */     if ((this.startEnd4 == null) && (other.getStartEnd4() != null)) return false;
/*  8221 */     if ((this.startEnd4 != null) && (!this.fDate.getString(this.startEnd4).equals(other.getStartEnd4()))) return false;
/*  8222 */     if ((this.startDate4 == null) && (other.getStartDate4() != null)) return false;
/*  8223 */     if ((this.startDate4 != null) && (!this.fDate.getString(this.startDate4).equals(other.getStartDate4()))) return false;
/*  8224 */     if (this.serverMonths != other.getServerMonths()) return false;
/*  8225 */     if (Double.doubleToLongBits(this.nT01) != Double.doubleToLongBits(other.getNT01())) return false;
/*  8226 */     if (Double.doubleToLongBits(this.nT02) != Double.doubleToLongBits(other.getNT02())) return false;
/*  8227 */     if (Double.doubleToLongBits(this.nT03) != Double.doubleToLongBits(other.getNT03())) return false;
/*  8228 */     if (Double.doubleToLongBits(this.nT04) != Double.doubleToLongBits(other.getNT04())) return false;
/*  8229 */     if (Double.doubleToLongBits(this.nT05) != Double.doubleToLongBits(other.getNT05())) return false;
/*  8230 */     if (Double.doubleToLongBits(this.nT06) != Double.doubleToLongBits(other.getNT06())) return false;
/*  8231 */     if (Double.doubleToLongBits(this.nT07) != Double.doubleToLongBits(other.getNT07())) return false;
/*  8232 */     if (Double.doubleToLongBits(this.nT08) != Double.doubleToLongBits(other.getNT08())) return false;
/*  8233 */     if (Double.doubleToLongBits(this.nT09) != Double.doubleToLongBits(other.getNT09())) return false;
/*  8234 */     if (Double.doubleToLongBits(this.nT10) != Double.doubleToLongBits(other.getNT10())) return false;
/*  8235 */     if (Double.doubleToLongBits(this.nT11) != Double.doubleToLongBits(other.getNT11())) return false;
/*  8236 */     if (Double.doubleToLongBits(this.nT12) != Double.doubleToLongBits(other.getNT12())) return false;
/*  8237 */     if (Double.doubleToLongBits(this.nT13) != Double.doubleToLongBits(other.getNT13())) return false;
/*  8238 */     if (Double.doubleToLongBits(this.nT14) != Double.doubleToLongBits(other.getNT14())) return false;
/*  8239 */     if (Double.doubleToLongBits(this.nT15) != Double.doubleToLongBits(other.getNT15())) return false;
/*  8240 */     if (Double.doubleToLongBits(this.nT16) != Double.doubleToLongBits(other.getNT16())) return false;
/*  8241 */     if (Double.doubleToLongBits(this.nT17) != Double.doubleToLongBits(other.getNT17())) return false;
/*  8242 */     if (Double.doubleToLongBits(this.nT18) != Double.doubleToLongBits(other.getNT18())) return false;
/*  8243 */     if (Double.doubleToLongBits(this.nT19) != Double.doubleToLongBits(other.getNT19())) return false;
/*  8244 */     if (Double.doubleToLongBits(this.nT20) != Double.doubleToLongBits(other.getNT20())) return false;
/*  8245 */     if (Double.doubleToLongBits(this.nT21) != Double.doubleToLongBits(other.getNT21())) return false;
/*  8246 */     if (Double.doubleToLongBits(this.nT22) != Double.doubleToLongBits(other.getNT22())) return false;
/*  8247 */     if (Double.doubleToLongBits(this.nT23) != Double.doubleToLongBits(other.getNT23())) return false;
/*  8248 */     if (Double.doubleToLongBits(this.nT24) != Double.doubleToLongBits(other.getNT24())) return false;
/*  8249 */     if (Double.doubleToLongBits(this.nT25) != Double.doubleToLongBits(other.getNT25())) return false;
/*  8250 */     if (Double.doubleToLongBits(this.nT26) != Double.doubleToLongBits(other.getNT26())) return false;
/*  8251 */     if (Double.doubleToLongBits(this.nT27) != Double.doubleToLongBits(other.getNT27())) return false;
/*  8252 */     if (Double.doubleToLongBits(this.nT28) != Double.doubleToLongBits(other.getNT28())) return false;
/*  8253 */     if (Double.doubleToLongBits(this.nT29) != Double.doubleToLongBits(other.getNT29())) return false;
/*  8254 */     if (Double.doubleToLongBits(this.nT30) != Double.doubleToLongBits(other.getNT30())) return false;
/*  8255 */     if (Double.doubleToLongBits(this.nT31) != Double.doubleToLongBits(other.getNT31())) return false;
/*  8256 */     if (Double.doubleToLongBits(this.nT32) != Double.doubleToLongBits(other.getNT32())) return false;
/*  8257 */     if (Double.doubleToLongBits(this.nT33) != Double.doubleToLongBits(other.getNT33())) return false;
/*  8258 */     if (Double.doubleToLongBits(this.nT34) != Double.doubleToLongBits(other.getNT34())) return false;
/*  8259 */     if (Double.doubleToLongBits(this.nT35) != Double.doubleToLongBits(other.getNT35())) return false;
/*  8260 */     if (Double.doubleToLongBits(this.nT36) != Double.doubleToLongBits(other.getNT36())) return false;
/*  8261 */     if (Double.doubleToLongBits(this.nT37) != Double.doubleToLongBits(other.getNT37())) return false;
/*  8262 */     if (Double.doubleToLongBits(this.nT38) != Double.doubleToLongBits(other.getNT38())) return false;
/*  8263 */     if (Double.doubleToLongBits(this.nT39) != Double.doubleToLongBits(other.getNT39())) return false;
/*  8264 */     if (Double.doubleToLongBits(this.nT40) != Double.doubleToLongBits(other.getNT40())) return false;
/*  8265 */     if (Double.doubleToLongBits(this.nT41) != Double.doubleToLongBits(other.getNT41())) return false;
/*  8266 */     if (Double.doubleToLongBits(this.nT42) != Double.doubleToLongBits(other.getNT42())) return false;
/*  8267 */     if (Double.doubleToLongBits(this.nT43) != Double.doubleToLongBits(other.getNT43())) return false;
/*  8268 */     if (Double.doubleToLongBits(this.nT44) != Double.doubleToLongBits(other.getNT44())) return false;
/*  8269 */     if (Double.doubleToLongBits(this.nT45) != Double.doubleToLongBits(other.getNT45())) return false;
/*  8270 */     if (Double.doubleToLongBits(this.nT46) != Double.doubleToLongBits(other.getNT46())) return false;
/*  8271 */     if (Double.doubleToLongBits(this.nT47) != Double.doubleToLongBits(other.getNT47())) return false;
/*  8272 */     if (Double.doubleToLongBits(this.nT48) != Double.doubleToLongBits(other.getNT48())) return false;
/*  8273 */     if (Double.doubleToLongBits(this.nT49) != Double.doubleToLongBits(other.getNT49())) return false;
/*  8274 */     if (Double.doubleToLongBits(this.nT50) != Double.doubleToLongBits(other.getNT50())) return false;
/*  8275 */     if (Double.doubleToLongBits(this.nT51) != Double.doubleToLongBits(other.getNT51())) return false;
/*  8276 */     if (Double.doubleToLongBits(this.nT52) != Double.doubleToLongBits(other.getNT52())) return false;
/*  8277 */     if (Double.doubleToLongBits(this.nT53) != Double.doubleToLongBits(other.getNT53())) return false;
/*  8278 */     if (Double.doubleToLongBits(this.nT54) != Double.doubleToLongBits(other.getNT54())) return false;
/*  8279 */     if (Double.doubleToLongBits(this.nT55) != Double.doubleToLongBits(other.getNT55())) return false;
/*  8280 */     if (Double.doubleToLongBits(this.nT56) != Double.doubleToLongBits(other.getNT56())) return false;
/*  8281 */     if (Double.doubleToLongBits(this.nT57) != Double.doubleToLongBits(other.getNT57())) return false;
/*  8282 */     if (Double.doubleToLongBits(this.nT58) != Double.doubleToLongBits(other.getNT58())) return false;
/*  8283 */     if (Double.doubleToLongBits(this.nT59) != Double.doubleToLongBits(other.getNT59())) return false;
/*  8284 */     if (Double.doubleToLongBits(this.nT60) != Double.doubleToLongBits(other.getNT60())) return false;
/*  8285 */     if (Double.doubleToLongBits(this.nT61) != Double.doubleToLongBits(other.getNT61())) return false;
/*  8286 */     if (Double.doubleToLongBits(this.nT62) != Double.doubleToLongBits(other.getNT62())) return false;
/*  8287 */     if (Double.doubleToLongBits(this.nT63) != Double.doubleToLongBits(other.getNT63())) return false;
/*  8288 */     if (Double.doubleToLongBits(this.nT64) != Double.doubleToLongBits(other.getNT64())) return false;
/*  8289 */     if (Double.doubleToLongBits(this.nT65) != Double.doubleToLongBits(other.getNT65())) return false;
/*  8290 */     if (Double.doubleToLongBits(this.nT66) != Double.doubleToLongBits(other.getNT66())) return false;
/*  8291 */     if (Double.doubleToLongBits(this.nT67) != Double.doubleToLongBits(other.getNT67())) return false;
/*  8292 */     if (Double.doubleToLongBits(this.nT68) != Double.doubleToLongBits(other.getNT68())) return false;
/*  8293 */     if (Double.doubleToLongBits(this.nT69) != Double.doubleToLongBits(other.getNT69())) return false;
/*  8294 */     if (Double.doubleToLongBits(this.nT70) != Double.doubleToLongBits(other.getNT70())) return false;
/*  8295 */     if (Double.doubleToLongBits(this.nT71) != Double.doubleToLongBits(other.getNT71())) return false;
/*  8296 */     if (Double.doubleToLongBits(this.nT72) != Double.doubleToLongBits(other.getNT72())) return false;
/*  8297 */     if (Double.doubleToLongBits(this.nT73) != Double.doubleToLongBits(other.getNT73())) return false;
/*  8298 */     if (Double.doubleToLongBits(this.nT74) != Double.doubleToLongBits(other.getNT74())) return false;
/*  8299 */     if (Double.doubleToLongBits(this.nT75) != Double.doubleToLongBits(other.getNT75())) return false;
/*  8300 */     if (Double.doubleToLongBits(this.nT76) != Double.doubleToLongBits(other.getNT76())) return false;
/*  8301 */     if (Double.doubleToLongBits(this.nT77) != Double.doubleToLongBits(other.getNT77())) return false;
/*  8302 */     if (Double.doubleToLongBits(this.nT78) != Double.doubleToLongBits(other.getNT78())) return false;
/*  8303 */     if (Double.doubleToLongBits(this.nT79) != Double.doubleToLongBits(other.getNT79())) return false;
/*  8304 */     if (Double.doubleToLongBits(this.nT80) != Double.doubleToLongBits(other.getNT80())) return false;
/*  8305 */     if (Double.doubleToLongBits(this.nF01) != Double.doubleToLongBits(other.getNF01())) return false;
/*  8306 */     if (Double.doubleToLongBits(this.nF02) != Double.doubleToLongBits(other.getNF02())) return false;
/*  8307 */     if (Double.doubleToLongBits(this.nF03) != Double.doubleToLongBits(other.getNF03())) return false;
/*  8308 */     if (Double.doubleToLongBits(this.nF04) != Double.doubleToLongBits(other.getNF04())) return false;
/*  8309 */     if (Double.doubleToLongBits(this.nF05) != Double.doubleToLongBits(other.getNF05())) return false;
/*  8310 */     if (Double.doubleToLongBits(this.nF06) != Double.doubleToLongBits(other.getNF06())) return false;
/*  8311 */     if (Double.doubleToLongBits(this.nF07) != Double.doubleToLongBits(other.getNF07())) return false;
/*  8312 */     if (Double.doubleToLongBits(this.nF08) != Double.doubleToLongBits(other.getNF08())) return false;
/*  8313 */     if (Double.doubleToLongBits(this.nF09) != Double.doubleToLongBits(other.getNF09())) return false;
/*  8314 */     if (Double.doubleToLongBits(this.nF10) != Double.doubleToLongBits(other.getNF10())) return false;
/*  8315 */     if (Double.doubleToLongBits(this.nS01) != Double.doubleToLongBits(other.getNS01())) return false;
/*  8316 */     if (Double.doubleToLongBits(this.nS02) != Double.doubleToLongBits(other.getNS02())) return false;
/*  8317 */     if (Double.doubleToLongBits(this.nS03) != Double.doubleToLongBits(other.getNS03())) return false;
/*  8318 */     if (Double.doubleToLongBits(this.nS04) != Double.doubleToLongBits(other.getNS04())) return false;
/*  8319 */     if (Double.doubleToLongBits(this.nS05) != Double.doubleToLongBits(other.getNS05())) return false;
/*  8320 */     if (Double.doubleToLongBits(this.nS06) != Double.doubleToLongBits(other.getNS06())) return false;
/*  8321 */     if (Double.doubleToLongBits(this.nS07) != Double.doubleToLongBits(other.getNS07())) return false;
/*  8322 */     if (Double.doubleToLongBits(this.nS08) != Double.doubleToLongBits(other.getNS08())) return false;
/*  8323 */     if (Double.doubleToLongBits(this.nS09) != Double.doubleToLongBits(other.getNS09())) return false;
/*  8324 */     if (Double.doubleToLongBits(this.nS10) != Double.doubleToLongBits(other.getNS10())) return false;
/*  8325 */     if (this.iNT01 != other.getINT01()) return false;
/*  8326 */     if (this.iNT02 != other.getINT02()) return false;
/*  8327 */     if (this.iNT03 != other.getINT03()) return false;
/*  8328 */     if (this.iNT04 != other.getINT04()) return false;
/*  8329 */     if (this.iNT05 != other.getINT05()) return false;
/*  8330 */     if (this.iNT06 != other.getINT06()) return false;
/*  8331 */     if (this.iNT07 != other.getINT07()) return false;
/*  8332 */     if (this.iNT08 != other.getINT08()) return false;
/*  8333 */     if (this.iNT09 != other.getINT09()) return false;
/*  8334 */     if (this.iNT10 != other.getINT10()) return false;
/*  8335 */     if (this.iNT11 != other.getINT11()) return false;
/*  8336 */     if (this.iNT12 != other.getINT12()) return false;
/*  8337 */     if (this.iNT13 != other.getINT13()) return false;
/*  8338 */     if (this.iNT14 != other.getINT14()) return false;
/*  8339 */     if (this.iNT15 != other.getINT15()) return false;
/*  8340 */     if (this.iNT16 != other.getINT16()) return false;
/*  8341 */     if (this.iNT17 != other.getINT17()) return false;
/*  8342 */     if (this.iNT18 != other.getINT18()) return false;
/*  8343 */     if (this.iNT19 != other.getINT19()) return false;
/*  8344 */     if (this.iNT20 != other.getINT20()) return false;
/*  8345 */     if (this.iNT21 != other.getINT21()) return false;
/*  8346 */     if (this.iNT22 != other.getINT22()) return false;
/*  8347 */     if (this.iNT23 != other.getINT23()) return false;
/*  8348 */     if (this.iNT24 != other.getINT24()) return false;
/*  8349 */     if (this.iNT25 != other.getINT25()) return false;
/*  8350 */     if ((this.v1 == null) && (other.getV1() != null)) return false;
/*  8351 */     if ((this.v1 != null) && (!this.v1.equals(other.getV1()))) return false;
/*  8352 */     if ((this.v2 == null) && (other.getV2() != null)) return false;
/*  8353 */     if ((this.v2 != null) && (!this.v2.equals(other.getV2()))) return false;
/*  8354 */     if ((this.v3 == null) && (other.getV3() != null)) return false;
/*  8355 */     if ((this.v3 != null) && (!this.v3.equals(other.getV3()))) return false;
/*  8356 */     if ((this.v4 == null) && (other.getV4() != null)) return false;
/*  8357 */     if ((this.v4 != null) && (!this.v4.equals(other.getV4()))) return false;
/*  8358 */     if ((this.v5 == null) && (other.getV5() != null)) return false;
/*  8359 */     if ((this.v5 != null) && (!this.v5.equals(other.getV5()))) return false;
/*  8360 */     if ((this.v6 == null) && (other.getV6() != null)) return false;
/*  8361 */     if ((this.v6 != null) && (!this.v6.equals(other.getV6()))) return false;
/*  8362 */     if ((this.v7 == null) && (other.getV7() != null)) return false;
/*  8363 */     if ((this.v7 != null) && (!this.v7.equals(other.getV7()))) return false;
/*  8364 */     if ((this.v8 == null) && (other.getV8() != null)) return false;
/*  8365 */     if ((this.v8 != null) && (!this.v8.equals(other.getV8()))) return false;
/*  8366 */     if ((this.v9 == null) && (other.getV9() != null)) return false;
/*  8367 */     if ((this.v9 != null) && (!this.v9.equals(other.getV9()))) return false;
/*  8368 */     if ((this.v10 == null) && (other.getV10() != null)) return false;
/*  8369 */     if ((this.v10 != null) && (!this.v10.equals(other.getV10()))) return false;
/*  8370 */     if ((this.v11 == null) && (other.getV11() != null)) return false;
/*  8371 */     if ((this.v11 != null) && (!this.v11.equals(other.getV11()))) return false;
/*  8372 */     if ((this.v12 == null) && (other.getV12() != null)) return false;
/*  8373 */     if ((this.v12 != null) && (!this.v12.equals(other.getV12()))) return false;
/*  8374 */     if ((this.v13 == null) && (other.getV13() != null)) return false;
/*  8375 */     if ((this.v13 != null) && (!this.v13.equals(other.getV13()))) return false;
/*  8376 */     if ((this.v14 == null) && (other.getV14() != null)) return false;
/*  8377 */     if ((this.v14 != null) && (!this.v14.equals(other.getV14()))) return false;
/*  8378 */     if ((this.v15 == null) && (other.getV15() != null)) return false;
/*  8379 */     if ((this.v15 != null) && (!this.v15.equals(other.getV15()))) return false;
/*  8380 */     if ((this.v16 == null) && (other.getV16() != null)) return false;
/*  8381 */     if ((this.v16 != null) && (!this.v16.equals(other.getV16()))) return false;
/*  8382 */     if ((this.v17 == null) && (other.getV17() != null)) return false;
/*  8383 */     if ((this.v17 != null) && (!this.v17.equals(other.getV17()))) return false;
/*  8384 */     if ((this.v18 == null) && (other.getV18() != null)) return false;
/*  8385 */     if ((this.v18 != null) && (!this.v18.equals(other.getV18()))) return false;
/*  8386 */     if ((this.v19 == null) && (other.getV19() != null)) return false;
/*  8387 */     if ((this.v19 != null) && (!this.v19.equals(other.getV19()))) return false;
/*  8388 */     if ((this.v20 == null) && (other.getV20() != null)) return false;
/*  8389 */     if ((this.v20 != null) && (!this.v20.equals(other.getV20()))) return false;
/*  8390 */     if ((this.vT1 == null) && (other.getVT1() != null)) return false;
/*  8391 */     if ((this.vT1 != null) && (!this.vT1.equals(other.getVT1()))) return false;
/*  8392 */     if ((this.vT2 == null) && (other.getVT2() != null)) return false;
/*  8393 */     if ((this.vT2 != null) && (!this.vT2.equals(other.getVT2()))) return false;
/*  8394 */     if ((this.vT3 == null) && (other.getVT3() != null)) return false;
/*  8395 */     if ((this.vT3 != null) && (!this.vT3.equals(other.getVT3()))) return false;
/*  8396 */     if ((this.vT4 == null) && (other.getVT4() != null)) return false;
/*  8397 */     if ((this.vT4 != null) && (!this.vT4.equals(other.getVT4()))) return false;
/*  8398 */     if ((this.vT5 == null) && (other.getVT5() != null)) return false;
/*  8399 */     if ((this.vT5 != null) && (!this.vT5.equals(other.getVT5()))) return false;
/*  8400 */     if ((this.vT6 == null) && (other.getVT6() != null)) return false;
/*  8401 */     if ((this.vT6 != null) && (!this.vT6.equals(other.getVT6()))) return false;
/*  8402 */     if ((this.vT7 == null) && (other.getVT7() != null)) return false;
/*  8403 */     if ((this.vT7 != null) && (!this.vT7.equals(other.getVT7()))) return false;
/*  8404 */     if ((this.vT8 == null) && (other.getVT8() != null)) return false;
/*  8405 */     if ((this.vT8 != null) && (!this.vT8.equals(other.getVT8()))) return false;
/*  8406 */     if ((this.vE1 == null) && (other.getVE1() != null)) return false;
/*  8407 */     if ((this.vE1 != null) && (!this.vE1.equals(other.getVE1()))) return false;
/*  8408 */     if ((this.vE2 == null) && (other.getVE2() != null)) return false;
/*  8409 */     if ((this.vE2 != null) && (!this.vE2.equals(other.getVE2()))) return false;
/*  8410 */     if ((this.vE3 == null) && (other.getVE3() != null)) return false;
/*  8411 */     if ((this.vE3 != null) && (!this.vE3.equals(other.getVE3()))) return false;
/*  8412 */     if ((this.vE4 == null) && (other.getVE4() != null)) return false;
/*  8413 */     if ((this.vE4 != null) && (!this.vE4.equals(other.getVE4()))) return false;
/*  8414 */     if ((this.vE5 == null) && (other.getVE5() != null)) return false;
/*  8415 */     if ((this.vE5 != null) && (!this.vE5.equals(other.getVE5()))) return false;
/*  8416 */     if ((this.vE6 == null) && (other.getVE6() != null)) return false;
/*  8417 */     if ((this.vE6 != null) && (!this.vE6.equals(other.getVE6()))) return false;
/*  8418 */     if ((this.vE7 == null) && (other.getVE7() != null)) return false;
/*  8419 */     if ((this.vE7 != null) && (!this.vE7.equals(other.getVE7()))) return false;
/*  8420 */     if ((this.vE8 == null) && (other.getVE8() != null)) return false;
/*  8421 */     if ((this.vE8 != null) && (!this.vE8.equals(other.getVE8()))) return false;
/*  8422 */     if ((this.vE9 == null) && (other.getVE9() != null)) return false;
/*  8423 */     if ((this.vE9 != null) && (!this.vE9.equals(other.getVE9()))) return false;
/*  8424 */     if ((this.vE10 == null) && (other.getVE10() != null)) return false;
/*  8425 */     if ((this.vE10 != null) && (!this.vE10.equals(other.getVE10()))) return false;
/*  8426 */     if ((this.d1 == null) && (other.getD1() != null)) return false;
/*  8427 */     if ((this.d1 != null) && (!this.fDate.getString(this.d1).equals(other.getD1()))) return false;
/*  8428 */     if ((this.d2 == null) && (other.getD2() != null)) return false;
/*  8429 */     if ((this.d2 != null) && (!this.fDate.getString(this.d2).equals(other.getD2()))) return false;
/*  8430 */     if ((this.d3 == null) && (other.getD3() != null)) return false;
/*  8431 */     if ((this.d3 != null) && (!this.fDate.getString(this.d3).equals(other.getD3()))) return false;
/*  8432 */     if ((this.d4 == null) && (other.getD4() != null)) return false;
/*  8433 */     if ((this.d4 != null) && (!this.fDate.getString(this.d4).equals(other.getD4()))) return false;
/*  8434 */     if ((this.d5 == null) && (other.getD5() != null)) return false;
/*  8435 */     if ((this.d5 != null) && (!this.fDate.getString(this.d5).equals(other.getD5()))) return false;
/*  8436 */     if ((this.d6 == null) && (other.getD6() != null)) return false;
/*  8437 */     if ((this.d6 != null) && (!this.fDate.getString(this.d6).equals(other.getD6()))) return false;
/*  8438 */     if ((this.d7 == null) && (other.getD7() != null)) return false;
/*  8439 */     if ((this.d7 != null) && (!this.fDate.getString(this.d7).equals(other.getD7()))) return false;
/*  8440 */     if ((this.d8 == null) && (other.getD8() != null)) return false;
/*  8441 */     if ((this.d8 != null) && (!this.fDate.getString(this.d8).equals(other.getD8()))) return false;
/*  8442 */     if ((this.d9 == null) && (other.getD9() != null)) return false;
/*  8443 */     if ((this.d9 != null) && (!this.fDate.getString(this.d9).equals(other.getD9()))) return false;
/*  8444 */     if ((this.d10 == null) && (other.getD10() != null)) return false;
/*  8445 */     if ((this.d10 != null) && (!this.fDate.getString(this.d10).equals(other.getD10()))) return false;
/*  8446 */     if ((this.state == null) && (other.getState() != null)) return false;
/*  8447 */     if ((this.state != null) && (!this.state.equals(other.getState()))) return false;
/*  8448 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/*  8449 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/*  8450 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/*  8451 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/*  8452 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/*  8453 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/*  8454 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/*  8455 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/*  8456 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/*  8457 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*       */   }
/*       */ 
/*       */   public int getFieldCount()
/*       */   {
/*  8464 */     return 207;
/*       */   }
/*       */ 
/*       */   public int getFieldIndex(String strFieldName)
/*       */   {
/*  8470 */     if (strFieldName.equals("indexCalNo")) {
/*  8471 */       return 0;
/*       */     }
/*  8473 */     if (strFieldName.equals("indexType")) {
/*  8474 */       return 1;
/*       */     }
/*  8476 */     if (strFieldName.equals("manageCom")) {
/*  8477 */       return 2;
/*       */     }
/*  8479 */     if (strFieldName.equals("agentGroup")) {
/*  8480 */       return 3;
/*       */     }
/*  8482 */     if (strFieldName.equals("branchAttr")) {
/*  8483 */       return 4;
/*       */     }
/*  8485 */     if (strFieldName.equals("agentCode")) {
/*  8486 */       return 5;
/*       */     }
/*  8488 */     if (strFieldName.equals("agentGrade")) {
/*  8489 */       return 6;
/*       */     }
/*  8491 */     if (strFieldName.equals("agentTitle")) {
/*  8492 */       return 7;
/*       */     }
/*  8494 */     if (strFieldName.equals("quaBgnMark")) {
/*  8495 */       return 8;
/*       */     }
/*  8497 */     if (strFieldName.equals("postMonths")) {
/*  8498 */       return 9;
/*       */     }
/*  8500 */     if (strFieldName.equals("assessMonth")) {
/*  8501 */       return 10;
/*       */     }
/*  8503 */     if (strFieldName.equals("agentGrade1")) {
/*  8504 */       return 11;
/*       */     }
/*  8506 */     if (strFieldName.equals("agentTitle1")) {
/*  8507 */       return 12;
/*       */     }
/*  8509 */     if (strFieldName.equals("agentGrade2")) {
/*  8510 */       return 13;
/*       */     }
/*  8512 */     if (strFieldName.equals("agentTitle2")) {
/*  8513 */       return 14;
/*       */     }
/*  8515 */     if (strFieldName.equals("agentGrade3")) {
/*  8516 */       return 15;
/*       */     }
/*  8518 */     if (strFieldName.equals("agentTitle3")) {
/*  8519 */       return 16;
/*       */     }
/*  8521 */     if (strFieldName.equals("startDate")) {
/*  8522 */       return 17;
/*       */     }
/*  8524 */     if (strFieldName.equals("startEnd")) {
/*  8525 */       return 18;
/*       */     }
/*  8527 */     if (strFieldName.equals("startDate1")) {
/*  8528 */       return 19;
/*       */     }
/*  8530 */     if (strFieldName.equals("startEnd1")) {
/*  8531 */       return 20;
/*       */     }
/*  8533 */     if (strFieldName.equals("startDate2")) {
/*  8534 */       return 21;
/*       */     }
/*  8536 */     if (strFieldName.equals("startEnd2")) {
/*  8537 */       return 22;
/*       */     }
/*  8539 */     if (strFieldName.equals("startDate3")) {
/*  8540 */       return 23;
/*       */     }
/*  8542 */     if (strFieldName.equals("startEnd3")) {
/*  8543 */       return 24;
/*       */     }
/*  8545 */     if (strFieldName.equals("startEnd4")) {
/*  8546 */       return 25;
/*       */     }
/*  8548 */     if (strFieldName.equals("startDate4")) {
/*  8549 */       return 26;
/*       */     }
/*  8551 */     if (strFieldName.equals("serverMonths")) {
/*  8552 */       return 27;
/*       */     }
/*  8554 */     if (strFieldName.equals("nT01")) {
/*  8555 */       return 28;
/*       */     }
/*  8557 */     if (strFieldName.equals("nT02")) {
/*  8558 */       return 29;
/*       */     }
/*  8560 */     if (strFieldName.equals("nT03")) {
/*  8561 */       return 30;
/*       */     }
/*  8563 */     if (strFieldName.equals("nT04")) {
/*  8564 */       return 31;
/*       */     }
/*  8566 */     if (strFieldName.equals("nT05")) {
/*  8567 */       return 32;
/*       */     }
/*  8569 */     if (strFieldName.equals("nT06")) {
/*  8570 */       return 33;
/*       */     }
/*  8572 */     if (strFieldName.equals("nT07")) {
/*  8573 */       return 34;
/*       */     }
/*  8575 */     if (strFieldName.equals("nT08")) {
/*  8576 */       return 35;
/*       */     }
/*  8578 */     if (strFieldName.equals("nT09")) {
/*  8579 */       return 36;
/*       */     }
/*  8581 */     if (strFieldName.equals("nT10")) {
/*  8582 */       return 37;
/*       */     }
/*  8584 */     if (strFieldName.equals("nT11")) {
/*  8585 */       return 38;
/*       */     }
/*  8587 */     if (strFieldName.equals("nT12")) {
/*  8588 */       return 39;
/*       */     }
/*  8590 */     if (strFieldName.equals("nT13")) {
/*  8591 */       return 40;
/*       */     }
/*  8593 */     if (strFieldName.equals("nT14")) {
/*  8594 */       return 41;
/*       */     }
/*  8596 */     if (strFieldName.equals("nT15")) {
/*  8597 */       return 42;
/*       */     }
/*  8599 */     if (strFieldName.equals("nT16")) {
/*  8600 */       return 43;
/*       */     }
/*  8602 */     if (strFieldName.equals("nT17")) {
/*  8603 */       return 44;
/*       */     }
/*  8605 */     if (strFieldName.equals("nT18")) {
/*  8606 */       return 45;
/*       */     }
/*  8608 */     if (strFieldName.equals("nT19")) {
/*  8609 */       return 46;
/*       */     }
/*  8611 */     if (strFieldName.equals("nT20")) {
/*  8612 */       return 47;
/*       */     }
/*  8614 */     if (strFieldName.equals("nT21")) {
/*  8615 */       return 48;
/*       */     }
/*  8617 */     if (strFieldName.equals("nT22")) {
/*  8618 */       return 49;
/*       */     }
/*  8620 */     if (strFieldName.equals("nT23")) {
/*  8621 */       return 50;
/*       */     }
/*  8623 */     if (strFieldName.equals("nT24")) {
/*  8624 */       return 51;
/*       */     }
/*  8626 */     if (strFieldName.equals("nT25")) {
/*  8627 */       return 52;
/*       */     }
/*  8629 */     if (strFieldName.equals("nT26")) {
/*  8630 */       return 53;
/*       */     }
/*  8632 */     if (strFieldName.equals("nT27")) {
/*  8633 */       return 54;
/*       */     }
/*  8635 */     if (strFieldName.equals("nT28")) {
/*  8636 */       return 55;
/*       */     }
/*  8638 */     if (strFieldName.equals("nT29")) {
/*  8639 */       return 56;
/*       */     }
/*  8641 */     if (strFieldName.equals("nT30")) {
/*  8642 */       return 57;
/*       */     }
/*  8644 */     if (strFieldName.equals("nT31")) {
/*  8645 */       return 58;
/*       */     }
/*  8647 */     if (strFieldName.equals("nT32")) {
/*  8648 */       return 59;
/*       */     }
/*  8650 */     if (strFieldName.equals("nT33")) {
/*  8651 */       return 60;
/*       */     }
/*  8653 */     if (strFieldName.equals("nT34")) {
/*  8654 */       return 61;
/*       */     }
/*  8656 */     if (strFieldName.equals("nT35")) {
/*  8657 */       return 62;
/*       */     }
/*  8659 */     if (strFieldName.equals("nT36")) {
/*  8660 */       return 63;
/*       */     }
/*  8662 */     if (strFieldName.equals("nT37")) {
/*  8663 */       return 64;
/*       */     }
/*  8665 */     if (strFieldName.equals("nT38")) {
/*  8666 */       return 65;
/*       */     }
/*  8668 */     if (strFieldName.equals("nT39")) {
/*  8669 */       return 66;
/*       */     }
/*  8671 */     if (strFieldName.equals("nT40")) {
/*  8672 */       return 67;
/*       */     }
/*  8674 */     if (strFieldName.equals("nT41")) {
/*  8675 */       return 68;
/*       */     }
/*  8677 */     if (strFieldName.equals("nT42")) {
/*  8678 */       return 69;
/*       */     }
/*  8680 */     if (strFieldName.equals("nT43")) {
/*  8681 */       return 70;
/*       */     }
/*  8683 */     if (strFieldName.equals("nT44")) {
/*  8684 */       return 71;
/*       */     }
/*  8686 */     if (strFieldName.equals("nT45")) {
/*  8687 */       return 72;
/*       */     }
/*  8689 */     if (strFieldName.equals("nT46")) {
/*  8690 */       return 73;
/*       */     }
/*  8692 */     if (strFieldName.equals("nT47")) {
/*  8693 */       return 74;
/*       */     }
/*  8695 */     if (strFieldName.equals("nT48")) {
/*  8696 */       return 75;
/*       */     }
/*  8698 */     if (strFieldName.equals("nT49")) {
/*  8699 */       return 76;
/*       */     }
/*  8701 */     if (strFieldName.equals("nT50")) {
/*  8702 */       return 77;
/*       */     }
/*  8704 */     if (strFieldName.equals("nT51")) {
/*  8705 */       return 78;
/*       */     }
/*  8707 */     if (strFieldName.equals("nT52")) {
/*  8708 */       return 79;
/*       */     }
/*  8710 */     if (strFieldName.equals("nT53")) {
/*  8711 */       return 80;
/*       */     }
/*  8713 */     if (strFieldName.equals("nT54")) {
/*  8714 */       return 81;
/*       */     }
/*  8716 */     if (strFieldName.equals("nT55")) {
/*  8717 */       return 82;
/*       */     }
/*  8719 */     if (strFieldName.equals("nT56")) {
/*  8720 */       return 83;
/*       */     }
/*  8722 */     if (strFieldName.equals("nT57")) {
/*  8723 */       return 84;
/*       */     }
/*  8725 */     if (strFieldName.equals("nT58")) {
/*  8726 */       return 85;
/*       */     }
/*  8728 */     if (strFieldName.equals("nT59")) {
/*  8729 */       return 86;
/*       */     }
/*  8731 */     if (strFieldName.equals("nT60")) {
/*  8732 */       return 87;
/*       */     }
/*  8734 */     if (strFieldName.equals("nT61")) {
/*  8735 */       return 88;
/*       */     }
/*  8737 */     if (strFieldName.equals("nT62")) {
/*  8738 */       return 89;
/*       */     }
/*  8740 */     if (strFieldName.equals("nT63")) {
/*  8741 */       return 90;
/*       */     }
/*  8743 */     if (strFieldName.equals("nT64")) {
/*  8744 */       return 91;
/*       */     }
/*  8746 */     if (strFieldName.equals("nT65")) {
/*  8747 */       return 92;
/*       */     }
/*  8749 */     if (strFieldName.equals("nT66")) {
/*  8750 */       return 93;
/*       */     }
/*  8752 */     if (strFieldName.equals("nT67")) {
/*  8753 */       return 94;
/*       */     }
/*  8755 */     if (strFieldName.equals("nT68")) {
/*  8756 */       return 95;
/*       */     }
/*  8758 */     if (strFieldName.equals("nT69")) {
/*  8759 */       return 96;
/*       */     }
/*  8761 */     if (strFieldName.equals("nT70")) {
/*  8762 */       return 97;
/*       */     }
/*  8764 */     if (strFieldName.equals("nT71")) {
/*  8765 */       return 98;
/*       */     }
/*  8767 */     if (strFieldName.equals("nT72")) {
/*  8768 */       return 99;
/*       */     }
/*  8770 */     if (strFieldName.equals("nT73")) {
/*  8771 */       return 100;
/*       */     }
/*  8773 */     if (strFieldName.equals("nT74")) {
/*  8774 */       return 101;
/*       */     }
/*  8776 */     if (strFieldName.equals("nT75")) {
/*  8777 */       return 102;
/*       */     }
/*  8779 */     if (strFieldName.equals("nT76")) {
/*  8780 */       return 103;
/*       */     }
/*  8782 */     if (strFieldName.equals("nT77")) {
/*  8783 */       return 104;
/*       */     }
/*  8785 */     if (strFieldName.equals("nT78")) {
/*  8786 */       return 105;
/*       */     }
/*  8788 */     if (strFieldName.equals("nT79")) {
/*  8789 */       return 106;
/*       */     }
/*  8791 */     if (strFieldName.equals("nT80")) {
/*  8792 */       return 107;
/*       */     }
/*  8794 */     if (strFieldName.equals("nF01")) {
/*  8795 */       return 108;
/*       */     }
/*  8797 */     if (strFieldName.equals("nF02")) {
/*  8798 */       return 109;
/*       */     }
/*  8800 */     if (strFieldName.equals("nF03")) {
/*  8801 */       return 110;
/*       */     }
/*  8803 */     if (strFieldName.equals("nF04")) {
/*  8804 */       return 111;
/*       */     }
/*  8806 */     if (strFieldName.equals("nF05")) {
/*  8807 */       return 112;
/*       */     }
/*  8809 */     if (strFieldName.equals("nF06")) {
/*  8810 */       return 113;
/*       */     }
/*  8812 */     if (strFieldName.equals("nF07")) {
/*  8813 */       return 114;
/*       */     }
/*  8815 */     if (strFieldName.equals("nF08")) {
/*  8816 */       return 115;
/*       */     }
/*  8818 */     if (strFieldName.equals("nF09")) {
/*  8819 */       return 116;
/*       */     }
/*  8821 */     if (strFieldName.equals("nF10")) {
/*  8822 */       return 117;
/*       */     }
/*  8824 */     if (strFieldName.equals("nS01")) {
/*  8825 */       return 118;
/*       */     }
/*  8827 */     if (strFieldName.equals("nS02")) {
/*  8828 */       return 119;
/*       */     }
/*  8830 */     if (strFieldName.equals("nS03")) {
/*  8831 */       return 120;
/*       */     }
/*  8833 */     if (strFieldName.equals("nS04")) {
/*  8834 */       return 121;
/*       */     }
/*  8836 */     if (strFieldName.equals("nS05")) {
/*  8837 */       return 122;
/*       */     }
/*  8839 */     if (strFieldName.equals("nS06")) {
/*  8840 */       return 123;
/*       */     }
/*  8842 */     if (strFieldName.equals("nS07")) {
/*  8843 */       return 124;
/*       */     }
/*  8845 */     if (strFieldName.equals("nS08")) {
/*  8846 */       return 125;
/*       */     }
/*  8848 */     if (strFieldName.equals("nS09")) {
/*  8849 */       return 126;
/*       */     }
/*  8851 */     if (strFieldName.equals("nS10")) {
/*  8852 */       return 127;
/*       */     }
/*  8854 */     if (strFieldName.equals("iNT01")) {
/*  8855 */       return 128;
/*       */     }
/*  8857 */     if (strFieldName.equals("iNT02")) {
/*  8858 */       return 129;
/*       */     }
/*  8860 */     if (strFieldName.equals("iNT03")) {
/*  8861 */       return 130;
/*       */     }
/*  8863 */     if (strFieldName.equals("iNT04")) {
/*  8864 */       return 131;
/*       */     }
/*  8866 */     if (strFieldName.equals("iNT05")) {
/*  8867 */       return 132;
/*       */     }
/*  8869 */     if (strFieldName.equals("iNT06")) {
/*  8870 */       return 133;
/*       */     }
/*  8872 */     if (strFieldName.equals("iNT07")) {
/*  8873 */       return 134;
/*       */     }
/*  8875 */     if (strFieldName.equals("iNT08")) {
/*  8876 */       return 135;
/*       */     }
/*  8878 */     if (strFieldName.equals("iNT09")) {
/*  8879 */       return 136;
/*       */     }
/*  8881 */     if (strFieldName.equals("iNT10")) {
/*  8882 */       return 137;
/*       */     }
/*  8884 */     if (strFieldName.equals("iNT11")) {
/*  8885 */       return 138;
/*       */     }
/*  8887 */     if (strFieldName.equals("iNT12")) {
/*  8888 */       return 139;
/*       */     }
/*  8890 */     if (strFieldName.equals("iNT13")) {
/*  8891 */       return 140;
/*       */     }
/*  8893 */     if (strFieldName.equals("iNT14")) {
/*  8894 */       return 141;
/*       */     }
/*  8896 */     if (strFieldName.equals("iNT15")) {
/*  8897 */       return 142;
/*       */     }
/*  8899 */     if (strFieldName.equals("iNT16")) {
/*  8900 */       return 143;
/*       */     }
/*  8902 */     if (strFieldName.equals("iNT17")) {
/*  8903 */       return 144;
/*       */     }
/*  8905 */     if (strFieldName.equals("iNT18")) {
/*  8906 */       return 145;
/*       */     }
/*  8908 */     if (strFieldName.equals("iNT19")) {
/*  8909 */       return 146;
/*       */     }
/*  8911 */     if (strFieldName.equals("iNT20")) {
/*  8912 */       return 147;
/*       */     }
/*  8914 */     if (strFieldName.equals("iNT21")) {
/*  8915 */       return 148;
/*       */     }
/*  8917 */     if (strFieldName.equals("iNT22")) {
/*  8918 */       return 149;
/*       */     }
/*  8920 */     if (strFieldName.equals("iNT23")) {
/*  8921 */       return 150;
/*       */     }
/*  8923 */     if (strFieldName.equals("iNT24")) {
/*  8924 */       return 151;
/*       */     }
/*  8926 */     if (strFieldName.equals("iNT25")) {
/*  8927 */       return 152;
/*       */     }
/*  8929 */     if (strFieldName.equals("v1")) {
/*  8930 */       return 153;
/*       */     }
/*  8932 */     if (strFieldName.equals("v2")) {
/*  8933 */       return 154;
/*       */     }
/*  8935 */     if (strFieldName.equals("v3")) {
/*  8936 */       return 155;
/*       */     }
/*  8938 */     if (strFieldName.equals("v4")) {
/*  8939 */       return 156;
/*       */     }
/*  8941 */     if (strFieldName.equals("v5")) {
/*  8942 */       return 157;
/*       */     }
/*  8944 */     if (strFieldName.equals("v6")) {
/*  8945 */       return 158;
/*       */     }
/*  8947 */     if (strFieldName.equals("v7")) {
/*  8948 */       return 159;
/*       */     }
/*  8950 */     if (strFieldName.equals("v8")) {
/*  8951 */       return 160;
/*       */     }
/*  8953 */     if (strFieldName.equals("v9")) {
/*  8954 */       return 161;
/*       */     }
/*  8956 */     if (strFieldName.equals("v10")) {
/*  8957 */       return 162;
/*       */     }
/*  8959 */     if (strFieldName.equals("v11")) {
/*  8960 */       return 163;
/*       */     }
/*  8962 */     if (strFieldName.equals("v12")) {
/*  8963 */       return 164;
/*       */     }
/*  8965 */     if (strFieldName.equals("v13")) {
/*  8966 */       return 165;
/*       */     }
/*  8968 */     if (strFieldName.equals("v14")) {
/*  8969 */       return 166;
/*       */     }
/*  8971 */     if (strFieldName.equals("v15")) {
/*  8972 */       return 167;
/*       */     }
/*  8974 */     if (strFieldName.equals("v16")) {
/*  8975 */       return 168;
/*       */     }
/*  8977 */     if (strFieldName.equals("v17")) {
/*  8978 */       return 169;
/*       */     }
/*  8980 */     if (strFieldName.equals("v18")) {
/*  8981 */       return 170;
/*       */     }
/*  8983 */     if (strFieldName.equals("v19")) {
/*  8984 */       return 171;
/*       */     }
/*  8986 */     if (strFieldName.equals("v20")) {
/*  8987 */       return 172;
/*       */     }
/*  8989 */     if (strFieldName.equals("vT1")) {
/*  8990 */       return 173;
/*       */     }
/*  8992 */     if (strFieldName.equals("vT2")) {
/*  8993 */       return 174;
/*       */     }
/*  8995 */     if (strFieldName.equals("vT3")) {
/*  8996 */       return 175;
/*       */     }
/*  8998 */     if (strFieldName.equals("vT4")) {
/*  8999 */       return 176;
/*       */     }
/*  9001 */     if (strFieldName.equals("vT5")) {
/*  9002 */       return 177;
/*       */     }
/*  9004 */     if (strFieldName.equals("vT6")) {
/*  9005 */       return 178;
/*       */     }
/*  9007 */     if (strFieldName.equals("vT7")) {
/*  9008 */       return 179;
/*       */     }
/*  9010 */     if (strFieldName.equals("vT8")) {
/*  9011 */       return 180;
/*       */     }
/*  9013 */     if (strFieldName.equals("vE1")) {
/*  9014 */       return 181;
/*       */     }
/*  9016 */     if (strFieldName.equals("vE2")) {
/*  9017 */       return 182;
/*       */     }
/*  9019 */     if (strFieldName.equals("vE3")) {
/*  9020 */       return 183;
/*       */     }
/*  9022 */     if (strFieldName.equals("vE4")) {
/*  9023 */       return 184;
/*       */     }
/*  9025 */     if (strFieldName.equals("vE5")) {
/*  9026 */       return 185;
/*       */     }
/*  9028 */     if (strFieldName.equals("vE6")) {
/*  9029 */       return 186;
/*       */     }
/*  9031 */     if (strFieldName.equals("vE7")) {
/*  9032 */       return 187;
/*       */     }
/*  9034 */     if (strFieldName.equals("vE8")) {
/*  9035 */       return 188;
/*       */     }
/*  9037 */     if (strFieldName.equals("vE9")) {
/*  9038 */       return 189;
/*       */     }
/*  9040 */     if (strFieldName.equals("vE10")) {
/*  9041 */       return 190;
/*       */     }
/*  9043 */     if (strFieldName.equals("d1")) {
/*  9044 */       return 191;
/*       */     }
/*  9046 */     if (strFieldName.equals("d2")) {
/*  9047 */       return 192;
/*       */     }
/*  9049 */     if (strFieldName.equals("d3")) {
/*  9050 */       return 193;
/*       */     }
/*  9052 */     if (strFieldName.equals("d4")) {
/*  9053 */       return 194;
/*       */     }
/*  9055 */     if (strFieldName.equals("d5")) {
/*  9056 */       return 195;
/*       */     }
/*  9058 */     if (strFieldName.equals("d6")) {
/*  9059 */       return 196;
/*       */     }
/*  9061 */     if (strFieldName.equals("d7")) {
/*  9062 */       return 197;
/*       */     }
/*  9064 */     if (strFieldName.equals("d8")) {
/*  9065 */       return 198;
/*       */     }
/*  9067 */     if (strFieldName.equals("d9")) {
/*  9068 */       return 199;
/*       */     }
/*  9070 */     if (strFieldName.equals("d10")) {
/*  9071 */       return 200;
/*       */     }
/*  9073 */     if (strFieldName.equals("state")) {
/*  9074 */       return 201;
/*       */     }
/*  9076 */     if (strFieldName.equals("operator")) {
/*  9077 */       return 202;
/*       */     }
/*  9079 */     if (strFieldName.equals("makeDate")) {
/*  9080 */       return 203;
/*       */     }
/*  9082 */     if (strFieldName.equals("makeTime")) {
/*  9083 */       return 204;
/*       */     }
/*  9085 */     if (strFieldName.equals("modifyDate")) {
/*  9086 */       return 205;
/*       */     }
/*  9088 */     if (strFieldName.equals("modifyTime")) {
/*  9089 */       return 206;
/*       */     }
/*  9091 */     return -1;
/*       */   }
/*       */ 
/*       */   public String getFieldName(int nFieldIndex)
/*       */   {
/*  9097 */     String strFieldName = "";
/*  9098 */     switch (nFieldIndex) {
/*       */     case 0:
/*  9100 */       strFieldName = "indexCalNo";
/*  9101 */       break;
/*       */     case 1:
/*  9103 */       strFieldName = "indexType";
/*  9104 */       break;
/*       */     case 2:
/*  9106 */       strFieldName = "manageCom";
/*  9107 */       break;
/*       */     case 3:
/*  9109 */       strFieldName = "agentGroup";
/*  9110 */       break;
/*       */     case 4:
/*  9112 */       strFieldName = "branchAttr";
/*  9113 */       break;
/*       */     case 5:
/*  9115 */       strFieldName = "agentCode";
/*  9116 */       break;
/*       */     case 6:
/*  9118 */       strFieldName = "agentGrade";
/*  9119 */       break;
/*       */     case 7:
/*  9121 */       strFieldName = "agentTitle";
/*  9122 */       break;
/*       */     case 8:
/*  9124 */       strFieldName = "quaBgnMark";
/*  9125 */       break;
/*       */     case 9:
/*  9127 */       strFieldName = "postMonths";
/*  9128 */       break;
/*       */     case 10:
/*  9130 */       strFieldName = "assessMonth";
/*  9131 */       break;
/*       */     case 11:
/*  9133 */       strFieldName = "agentGrade1";
/*  9134 */       break;
/*       */     case 12:
/*  9136 */       strFieldName = "agentTitle1";
/*  9137 */       break;
/*       */     case 13:
/*  9139 */       strFieldName = "agentGrade2";
/*  9140 */       break;
/*       */     case 14:
/*  9142 */       strFieldName = "agentTitle2";
/*  9143 */       break;
/*       */     case 15:
/*  9145 */       strFieldName = "agentGrade3";
/*  9146 */       break;
/*       */     case 16:
/*  9148 */       strFieldName = "agentTitle3";
/*  9149 */       break;
/*       */     case 17:
/*  9151 */       strFieldName = "startDate";
/*  9152 */       break;
/*       */     case 18:
/*  9154 */       strFieldName = "startEnd";
/*  9155 */       break;
/*       */     case 19:
/*  9157 */       strFieldName = "startDate1";
/*  9158 */       break;
/*       */     case 20:
/*  9160 */       strFieldName = "startEnd1";
/*  9161 */       break;
/*       */     case 21:
/*  9163 */       strFieldName = "startDate2";
/*  9164 */       break;
/*       */     case 22:
/*  9166 */       strFieldName = "startEnd2";
/*  9167 */       break;
/*       */     case 23:
/*  9169 */       strFieldName = "startDate3";
/*  9170 */       break;
/*       */     case 24:
/*  9172 */       strFieldName = "startEnd3";
/*  9173 */       break;
/*       */     case 25:
/*  9175 */       strFieldName = "startEnd4";
/*  9176 */       break;
/*       */     case 26:
/*  9178 */       strFieldName = "startDate4";
/*  9179 */       break;
/*       */     case 27:
/*  9181 */       strFieldName = "serverMonths";
/*  9182 */       break;
/*       */     case 28:
/*  9184 */       strFieldName = "nT01";
/*  9185 */       break;
/*       */     case 29:
/*  9187 */       strFieldName = "nT02";
/*  9188 */       break;
/*       */     case 30:
/*  9190 */       strFieldName = "nT03";
/*  9191 */       break;
/*       */     case 31:
/*  9193 */       strFieldName = "nT04";
/*  9194 */       break;
/*       */     case 32:
/*  9196 */       strFieldName = "nT05";
/*  9197 */       break;
/*       */     case 33:
/*  9199 */       strFieldName = "nT06";
/*  9200 */       break;
/*       */     case 34:
/*  9202 */       strFieldName = "nT07";
/*  9203 */       break;
/*       */     case 35:
/*  9205 */       strFieldName = "nT08";
/*  9206 */       break;
/*       */     case 36:
/*  9208 */       strFieldName = "nT09";
/*  9209 */       break;
/*       */     case 37:
/*  9211 */       strFieldName = "nT10";
/*  9212 */       break;
/*       */     case 38:
/*  9214 */       strFieldName = "nT11";
/*  9215 */       break;
/*       */     case 39:
/*  9217 */       strFieldName = "nT12";
/*  9218 */       break;
/*       */     case 40:
/*  9220 */       strFieldName = "nT13";
/*  9221 */       break;
/*       */     case 41:
/*  9223 */       strFieldName = "nT14";
/*  9224 */       break;
/*       */     case 42:
/*  9226 */       strFieldName = "nT15";
/*  9227 */       break;
/*       */     case 43:
/*  9229 */       strFieldName = "nT16";
/*  9230 */       break;
/*       */     case 44:
/*  9232 */       strFieldName = "nT17";
/*  9233 */       break;
/*       */     case 45:
/*  9235 */       strFieldName = "nT18";
/*  9236 */       break;
/*       */     case 46:
/*  9238 */       strFieldName = "nT19";
/*  9239 */       break;
/*       */     case 47:
/*  9241 */       strFieldName = "nT20";
/*  9242 */       break;
/*       */     case 48:
/*  9244 */       strFieldName = "nT21";
/*  9245 */       break;
/*       */     case 49:
/*  9247 */       strFieldName = "nT22";
/*  9248 */       break;
/*       */     case 50:
/*  9250 */       strFieldName = "nT23";
/*  9251 */       break;
/*       */     case 51:
/*  9253 */       strFieldName = "nT24";
/*  9254 */       break;
/*       */     case 52:
/*  9256 */       strFieldName = "nT25";
/*  9257 */       break;
/*       */     case 53:
/*  9259 */       strFieldName = "nT26";
/*  9260 */       break;
/*       */     case 54:
/*  9262 */       strFieldName = "nT27";
/*  9263 */       break;
/*       */     case 55:
/*  9265 */       strFieldName = "nT28";
/*  9266 */       break;
/*       */     case 56:
/*  9268 */       strFieldName = "nT29";
/*  9269 */       break;
/*       */     case 57:
/*  9271 */       strFieldName = "nT30";
/*  9272 */       break;
/*       */     case 58:
/*  9274 */       strFieldName = "nT31";
/*  9275 */       break;
/*       */     case 59:
/*  9277 */       strFieldName = "nT32";
/*  9278 */       break;
/*       */     case 60:
/*  9280 */       strFieldName = "nT33";
/*  9281 */       break;
/*       */     case 61:
/*  9283 */       strFieldName = "nT34";
/*  9284 */       break;
/*       */     case 62:
/*  9286 */       strFieldName = "nT35";
/*  9287 */       break;
/*       */     case 63:
/*  9289 */       strFieldName = "nT36";
/*  9290 */       break;
/*       */     case 64:
/*  9292 */       strFieldName = "nT37";
/*  9293 */       break;
/*       */     case 65:
/*  9295 */       strFieldName = "nT38";
/*  9296 */       break;
/*       */     case 66:
/*  9298 */       strFieldName = "nT39";
/*  9299 */       break;
/*       */     case 67:
/*  9301 */       strFieldName = "nT40";
/*  9302 */       break;
/*       */     case 68:
/*  9304 */       strFieldName = "nT41";
/*  9305 */       break;
/*       */     case 69:
/*  9307 */       strFieldName = "nT42";
/*  9308 */       break;
/*       */     case 70:
/*  9310 */       strFieldName = "nT43";
/*  9311 */       break;
/*       */     case 71:
/*  9313 */       strFieldName = "nT44";
/*  9314 */       break;
/*       */     case 72:
/*  9316 */       strFieldName = "nT45";
/*  9317 */       break;
/*       */     case 73:
/*  9319 */       strFieldName = "nT46";
/*  9320 */       break;
/*       */     case 74:
/*  9322 */       strFieldName = "nT47";
/*  9323 */       break;
/*       */     case 75:
/*  9325 */       strFieldName = "nT48";
/*  9326 */       break;
/*       */     case 76:
/*  9328 */       strFieldName = "nT49";
/*  9329 */       break;
/*       */     case 77:
/*  9331 */       strFieldName = "nT50";
/*  9332 */       break;
/*       */     case 78:
/*  9334 */       strFieldName = "nT51";
/*  9335 */       break;
/*       */     case 79:
/*  9337 */       strFieldName = "nT52";
/*  9338 */       break;
/*       */     case 80:
/*  9340 */       strFieldName = "nT53";
/*  9341 */       break;
/*       */     case 81:
/*  9343 */       strFieldName = "nT54";
/*  9344 */       break;
/*       */     case 82:
/*  9346 */       strFieldName = "nT55";
/*  9347 */       break;
/*       */     case 83:
/*  9349 */       strFieldName = "nT56";
/*  9350 */       break;
/*       */     case 84:
/*  9352 */       strFieldName = "nT57";
/*  9353 */       break;
/*       */     case 85:
/*  9355 */       strFieldName = "nT58";
/*  9356 */       break;
/*       */     case 86:
/*  9358 */       strFieldName = "nT59";
/*  9359 */       break;
/*       */     case 87:
/*  9361 */       strFieldName = "nT60";
/*  9362 */       break;
/*       */     case 88:
/*  9364 */       strFieldName = "nT61";
/*  9365 */       break;
/*       */     case 89:
/*  9367 */       strFieldName = "nT62";
/*  9368 */       break;
/*       */     case 90:
/*  9370 */       strFieldName = "nT63";
/*  9371 */       break;
/*       */     case 91:
/*  9373 */       strFieldName = "nT64";
/*  9374 */       break;
/*       */     case 92:
/*  9376 */       strFieldName = "nT65";
/*  9377 */       break;
/*       */     case 93:
/*  9379 */       strFieldName = "nT66";
/*  9380 */       break;
/*       */     case 94:
/*  9382 */       strFieldName = "nT67";
/*  9383 */       break;
/*       */     case 95:
/*  9385 */       strFieldName = "nT68";
/*  9386 */       break;
/*       */     case 96:
/*  9388 */       strFieldName = "nT69";
/*  9389 */       break;
/*       */     case 97:
/*  9391 */       strFieldName = "nT70";
/*  9392 */       break;
/*       */     case 98:
/*  9394 */       strFieldName = "nT71";
/*  9395 */       break;
/*       */     case 99:
/*  9397 */       strFieldName = "nT72";
/*  9398 */       break;
/*       */     case 100:
/*  9400 */       strFieldName = "nT73";
/*  9401 */       break;
/*       */     case 101:
/*  9403 */       strFieldName = "nT74";
/*  9404 */       break;
/*       */     case 102:
/*  9406 */       strFieldName = "nT75";
/*  9407 */       break;
/*       */     case 103:
/*  9409 */       strFieldName = "nT76";
/*  9410 */       break;
/*       */     case 104:
/*  9412 */       strFieldName = "nT77";
/*  9413 */       break;
/*       */     case 105:
/*  9415 */       strFieldName = "nT78";
/*  9416 */       break;
/*       */     case 106:
/*  9418 */       strFieldName = "nT79";
/*  9419 */       break;
/*       */     case 107:
/*  9421 */       strFieldName = "nT80";
/*  9422 */       break;
/*       */     case 108:
/*  9424 */       strFieldName = "nF01";
/*  9425 */       break;
/*       */     case 109:
/*  9427 */       strFieldName = "nF02";
/*  9428 */       break;
/*       */     case 110:
/*  9430 */       strFieldName = "nF03";
/*  9431 */       break;
/*       */     case 111:
/*  9433 */       strFieldName = "nF04";
/*  9434 */       break;
/*       */     case 112:
/*  9436 */       strFieldName = "nF05";
/*  9437 */       break;
/*       */     case 113:
/*  9439 */       strFieldName = "nF06";
/*  9440 */       break;
/*       */     case 114:
/*  9442 */       strFieldName = "nF07";
/*  9443 */       break;
/*       */     case 115:
/*  9445 */       strFieldName = "nF08";
/*  9446 */       break;
/*       */     case 116:
/*  9448 */       strFieldName = "nF09";
/*  9449 */       break;
/*       */     case 117:
/*  9451 */       strFieldName = "nF10";
/*  9452 */       break;
/*       */     case 118:
/*  9454 */       strFieldName = "nS01";
/*  9455 */       break;
/*       */     case 119:
/*  9457 */       strFieldName = "nS02";
/*  9458 */       break;
/*       */     case 120:
/*  9460 */       strFieldName = "nS03";
/*  9461 */       break;
/*       */     case 121:
/*  9463 */       strFieldName = "nS04";
/*  9464 */       break;
/*       */     case 122:
/*  9466 */       strFieldName = "nS05";
/*  9467 */       break;
/*       */     case 123:
/*  9469 */       strFieldName = "nS06";
/*  9470 */       break;
/*       */     case 124:
/*  9472 */       strFieldName = "nS07";
/*  9473 */       break;
/*       */     case 125:
/*  9475 */       strFieldName = "nS08";
/*  9476 */       break;
/*       */     case 126:
/*  9478 */       strFieldName = "nS09";
/*  9479 */       break;
/*       */     case 127:
/*  9481 */       strFieldName = "nS10";
/*  9482 */       break;
/*       */     case 128:
/*  9484 */       strFieldName = "iNT01";
/*  9485 */       break;
/*       */     case 129:
/*  9487 */       strFieldName = "iNT02";
/*  9488 */       break;
/*       */     case 130:
/*  9490 */       strFieldName = "iNT03";
/*  9491 */       break;
/*       */     case 131:
/*  9493 */       strFieldName = "iNT04";
/*  9494 */       break;
/*       */     case 132:
/*  9496 */       strFieldName = "iNT05";
/*  9497 */       break;
/*       */     case 133:
/*  9499 */       strFieldName = "iNT06";
/*  9500 */       break;
/*       */     case 134:
/*  9502 */       strFieldName = "iNT07";
/*  9503 */       break;
/*       */     case 135:
/*  9505 */       strFieldName = "iNT08";
/*  9506 */       break;
/*       */     case 136:
/*  9508 */       strFieldName = "iNT09";
/*  9509 */       break;
/*       */     case 137:
/*  9511 */       strFieldName = "iNT10";
/*  9512 */       break;
/*       */     case 138:
/*  9514 */       strFieldName = "iNT11";
/*  9515 */       break;
/*       */     case 139:
/*  9517 */       strFieldName = "iNT12";
/*  9518 */       break;
/*       */     case 140:
/*  9520 */       strFieldName = "iNT13";
/*  9521 */       break;
/*       */     case 141:
/*  9523 */       strFieldName = "iNT14";
/*  9524 */       break;
/*       */     case 142:
/*  9526 */       strFieldName = "iNT15";
/*  9527 */       break;
/*       */     case 143:
/*  9529 */       strFieldName = "iNT16";
/*  9530 */       break;
/*       */     case 144:
/*  9532 */       strFieldName = "iNT17";
/*  9533 */       break;
/*       */     case 145:
/*  9535 */       strFieldName = "iNT18";
/*  9536 */       break;
/*       */     case 146:
/*  9538 */       strFieldName = "iNT19";
/*  9539 */       break;
/*       */     case 147:
/*  9541 */       strFieldName = "iNT20";
/*  9542 */       break;
/*       */     case 148:
/*  9544 */       strFieldName = "iNT21";
/*  9545 */       break;
/*       */     case 149:
/*  9547 */       strFieldName = "iNT22";
/*  9548 */       break;
/*       */     case 150:
/*  9550 */       strFieldName = "iNT23";
/*  9551 */       break;
/*       */     case 151:
/*  9553 */       strFieldName = "iNT24";
/*  9554 */       break;
/*       */     case 152:
/*  9556 */       strFieldName = "iNT25";
/*  9557 */       break;
/*       */     case 153:
/*  9559 */       strFieldName = "v1";
/*  9560 */       break;
/*       */     case 154:
/*  9562 */       strFieldName = "v2";
/*  9563 */       break;
/*       */     case 155:
/*  9565 */       strFieldName = "v3";
/*  9566 */       break;
/*       */     case 156:
/*  9568 */       strFieldName = "v4";
/*  9569 */       break;
/*       */     case 157:
/*  9571 */       strFieldName = "v5";
/*  9572 */       break;
/*       */     case 158:
/*  9574 */       strFieldName = "v6";
/*  9575 */       break;
/*       */     case 159:
/*  9577 */       strFieldName = "v7";
/*  9578 */       break;
/*       */     case 160:
/*  9580 */       strFieldName = "v8";
/*  9581 */       break;
/*       */     case 161:
/*  9583 */       strFieldName = "v9";
/*  9584 */       break;
/*       */     case 162:
/*  9586 */       strFieldName = "v10";
/*  9587 */       break;
/*       */     case 163:
/*  9589 */       strFieldName = "v11";
/*  9590 */       break;
/*       */     case 164:
/*  9592 */       strFieldName = "v12";
/*  9593 */       break;
/*       */     case 165:
/*  9595 */       strFieldName = "v13";
/*  9596 */       break;
/*       */     case 166:
/*  9598 */       strFieldName = "v14";
/*  9599 */       break;
/*       */     case 167:
/*  9601 */       strFieldName = "v15";
/*  9602 */       break;
/*       */     case 168:
/*  9604 */       strFieldName = "v16";
/*  9605 */       break;
/*       */     case 169:
/*  9607 */       strFieldName = "v17";
/*  9608 */       break;
/*       */     case 170:
/*  9610 */       strFieldName = "v18";
/*  9611 */       break;
/*       */     case 171:
/*  9613 */       strFieldName = "v19";
/*  9614 */       break;
/*       */     case 172:
/*  9616 */       strFieldName = "v20";
/*  9617 */       break;
/*       */     case 173:
/*  9619 */       strFieldName = "vT1";
/*  9620 */       break;
/*       */     case 174:
/*  9622 */       strFieldName = "vT2";
/*  9623 */       break;
/*       */     case 175:
/*  9625 */       strFieldName = "vT3";
/*  9626 */       break;
/*       */     case 176:
/*  9628 */       strFieldName = "vT4";
/*  9629 */       break;
/*       */     case 177:
/*  9631 */       strFieldName = "vT5";
/*  9632 */       break;
/*       */     case 178:
/*  9634 */       strFieldName = "vT6";
/*  9635 */       break;
/*       */     case 179:
/*  9637 */       strFieldName = "vT7";
/*  9638 */       break;
/*       */     case 180:
/*  9640 */       strFieldName = "vT8";
/*  9641 */       break;
/*       */     case 181:
/*  9643 */       strFieldName = "vE1";
/*  9644 */       break;
/*       */     case 182:
/*  9646 */       strFieldName = "vE2";
/*  9647 */       break;
/*       */     case 183:
/*  9649 */       strFieldName = "vE3";
/*  9650 */       break;
/*       */     case 184:
/*  9652 */       strFieldName = "vE4";
/*  9653 */       break;
/*       */     case 185:
/*  9655 */       strFieldName = "vE5";
/*  9656 */       break;
/*       */     case 186:
/*  9658 */       strFieldName = "vE6";
/*  9659 */       break;
/*       */     case 187:
/*  9661 */       strFieldName = "vE7";
/*  9662 */       break;
/*       */     case 188:
/*  9664 */       strFieldName = "vE8";
/*  9665 */       break;
/*       */     case 189:
/*  9667 */       strFieldName = "vE9";
/*  9668 */       break;
/*       */     case 190:
/*  9670 */       strFieldName = "vE10";
/*  9671 */       break;
/*       */     case 191:
/*  9673 */       strFieldName = "d1";
/*  9674 */       break;
/*       */     case 192:
/*  9676 */       strFieldName = "d2";
/*  9677 */       break;
/*       */     case 193:
/*  9679 */       strFieldName = "d3";
/*  9680 */       break;
/*       */     case 194:
/*  9682 */       strFieldName = "d4";
/*  9683 */       break;
/*       */     case 195:
/*  9685 */       strFieldName = "d5";
/*  9686 */       break;
/*       */     case 196:
/*  9688 */       strFieldName = "d6";
/*  9689 */       break;
/*       */     case 197:
/*  9691 */       strFieldName = "d7";
/*  9692 */       break;
/*       */     case 198:
/*  9694 */       strFieldName = "d8";
/*  9695 */       break;
/*       */     case 199:
/*  9697 */       strFieldName = "d9";
/*  9698 */       break;
/*       */     case 200:
/*  9700 */       strFieldName = "d10";
/*  9701 */       break;
/*       */     case 201:
/*  9703 */       strFieldName = "state";
/*  9704 */       break;
/*       */     case 202:
/*  9706 */       strFieldName = "operator";
/*  9707 */       break;
/*       */     case 203:
/*  9709 */       strFieldName = "makeDate";
/*  9710 */       break;
/*       */     case 204:
/*  9712 */       strFieldName = "makeTime";
/*  9713 */       break;
/*       */     case 205:
/*  9715 */       strFieldName = "modifyDate";
/*  9716 */       break;
/*       */     case 206:
/*  9718 */       strFieldName = "modifyTime";
/*  9719 */       break;
/*       */     default:
/*  9721 */       strFieldName = "";
/*       */     }
/*  9723 */     return strFieldName;
/*       */   }
/*       */ 
/*       */   public int getFieldType(String strFieldName)
/*       */   {
/*  9729 */     if (strFieldName.equals("indexCalNo")) {
/*  9730 */       return 0;
/*       */     }
/*  9732 */     if (strFieldName.equals("indexType")) {
/*  9733 */       return 0;
/*       */     }
/*  9735 */     if (strFieldName.equals("manageCom")) {
/*  9736 */       return 0;
/*       */     }
/*  9738 */     if (strFieldName.equals("agentGroup")) {
/*  9739 */       return 0;
/*       */     }
/*  9741 */     if (strFieldName.equals("branchAttr")) {
/*  9742 */       return 0;
/*       */     }
/*  9744 */     if (strFieldName.equals("agentCode")) {
/*  9745 */       return 0;
/*       */     }
/*  9747 */     if (strFieldName.equals("agentGrade")) {
/*  9748 */       return 0;
/*       */     }
/*  9750 */     if (strFieldName.equals("agentTitle")) {
/*  9751 */       return 0;
/*       */     }
/*  9753 */     if (strFieldName.equals("quaBgnMark")) {
/*  9754 */       return 3;
/*       */     }
/*  9756 */     if (strFieldName.equals("postMonths")) {
/*  9757 */       return 3;
/*       */     }
/*  9759 */     if (strFieldName.equals("assessMonth")) {
/*  9760 */       return 0;
/*       */     }
/*  9762 */     if (strFieldName.equals("agentGrade1")) {
/*  9763 */       return 0;
/*       */     }
/*  9765 */     if (strFieldName.equals("agentTitle1")) {
/*  9766 */       return 0;
/*       */     }
/*  9768 */     if (strFieldName.equals("agentGrade2")) {
/*  9769 */       return 0;
/*       */     }
/*  9771 */     if (strFieldName.equals("agentTitle2")) {
/*  9772 */       return 0;
/*       */     }
/*  9774 */     if (strFieldName.equals("agentGrade3")) {
/*  9775 */       return 0;
/*       */     }
/*  9777 */     if (strFieldName.equals("agentTitle3")) {
/*  9778 */       return 0;
/*       */     }
/*  9780 */     if (strFieldName.equals("startDate")) {
/*  9781 */       return 1;
/*       */     }
/*  9783 */     if (strFieldName.equals("startEnd")) {
/*  9784 */       return 1;
/*       */     }
/*  9786 */     if (strFieldName.equals("startDate1")) {
/*  9787 */       return 1;
/*       */     }
/*  9789 */     if (strFieldName.equals("startEnd1")) {
/*  9790 */       return 1;
/*       */     }
/*  9792 */     if (strFieldName.equals("startDate2")) {
/*  9793 */       return 1;
/*       */     }
/*  9795 */     if (strFieldName.equals("startEnd2")) {
/*  9796 */       return 1;
/*       */     }
/*  9798 */     if (strFieldName.equals("startDate3")) {
/*  9799 */       return 1;
/*       */     }
/*  9801 */     if (strFieldName.equals("startEnd3")) {
/*  9802 */       return 1;
/*       */     }
/*  9804 */     if (strFieldName.equals("startEnd4")) {
/*  9805 */       return 1;
/*       */     }
/*  9807 */     if (strFieldName.equals("startDate4")) {
/*  9808 */       return 1;
/*       */     }
/*  9810 */     if (strFieldName.equals("serverMonths")) {
/*  9811 */       return 3;
/*       */     }
/*  9813 */     if (strFieldName.equals("nT01")) {
/*  9814 */       return 4;
/*       */     }
/*  9816 */     if (strFieldName.equals("nT02")) {
/*  9817 */       return 4;
/*       */     }
/*  9819 */     if (strFieldName.equals("nT03")) {
/*  9820 */       return 4;
/*       */     }
/*  9822 */     if (strFieldName.equals("nT04")) {
/*  9823 */       return 4;
/*       */     }
/*  9825 */     if (strFieldName.equals("nT05")) {
/*  9826 */       return 4;
/*       */     }
/*  9828 */     if (strFieldName.equals("nT06")) {
/*  9829 */       return 4;
/*       */     }
/*  9831 */     if (strFieldName.equals("nT07")) {
/*  9832 */       return 4;
/*       */     }
/*  9834 */     if (strFieldName.equals("nT08")) {
/*  9835 */       return 4;
/*       */     }
/*  9837 */     if (strFieldName.equals("nT09")) {
/*  9838 */       return 4;
/*       */     }
/*  9840 */     if (strFieldName.equals("nT10")) {
/*  9841 */       return 4;
/*       */     }
/*  9843 */     if (strFieldName.equals("nT11")) {
/*  9844 */       return 4;
/*       */     }
/*  9846 */     if (strFieldName.equals("nT12")) {
/*  9847 */       return 4;
/*       */     }
/*  9849 */     if (strFieldName.equals("nT13")) {
/*  9850 */       return 4;
/*       */     }
/*  9852 */     if (strFieldName.equals("nT14")) {
/*  9853 */       return 4;
/*       */     }
/*  9855 */     if (strFieldName.equals("nT15")) {
/*  9856 */       return 4;
/*       */     }
/*  9858 */     if (strFieldName.equals("nT16")) {
/*  9859 */       return 4;
/*       */     }
/*  9861 */     if (strFieldName.equals("nT17")) {
/*  9862 */       return 4;
/*       */     }
/*  9864 */     if (strFieldName.equals("nT18")) {
/*  9865 */       return 4;
/*       */     }
/*  9867 */     if (strFieldName.equals("nT19")) {
/*  9868 */       return 4;
/*       */     }
/*  9870 */     if (strFieldName.equals("nT20")) {
/*  9871 */       return 4;
/*       */     }
/*  9873 */     if (strFieldName.equals("nT21")) {
/*  9874 */       return 4;
/*       */     }
/*  9876 */     if (strFieldName.equals("nT22")) {
/*  9877 */       return 4;
/*       */     }
/*  9879 */     if (strFieldName.equals("nT23")) {
/*  9880 */       return 4;
/*       */     }
/*  9882 */     if (strFieldName.equals("nT24")) {
/*  9883 */       return 4;
/*       */     }
/*  9885 */     if (strFieldName.equals("nT25")) {
/*  9886 */       return 4;
/*       */     }
/*  9888 */     if (strFieldName.equals("nT26")) {
/*  9889 */       return 4;
/*       */     }
/*  9891 */     if (strFieldName.equals("nT27")) {
/*  9892 */       return 4;
/*       */     }
/*  9894 */     if (strFieldName.equals("nT28")) {
/*  9895 */       return 4;
/*       */     }
/*  9897 */     if (strFieldName.equals("nT29")) {
/*  9898 */       return 4;
/*       */     }
/*  9900 */     if (strFieldName.equals("nT30")) {
/*  9901 */       return 4;
/*       */     }
/*  9903 */     if (strFieldName.equals("nT31")) {
/*  9904 */       return 4;
/*       */     }
/*  9906 */     if (strFieldName.equals("nT32")) {
/*  9907 */       return 4;
/*       */     }
/*  9909 */     if (strFieldName.equals("nT33")) {
/*  9910 */       return 4;
/*       */     }
/*  9912 */     if (strFieldName.equals("nT34")) {
/*  9913 */       return 4;
/*       */     }
/*  9915 */     if (strFieldName.equals("nT35")) {
/*  9916 */       return 4;
/*       */     }
/*  9918 */     if (strFieldName.equals("nT36")) {
/*  9919 */       return 4;
/*       */     }
/*  9921 */     if (strFieldName.equals("nT37")) {
/*  9922 */       return 4;
/*       */     }
/*  9924 */     if (strFieldName.equals("nT38")) {
/*  9925 */       return 4;
/*       */     }
/*  9927 */     if (strFieldName.equals("nT39")) {
/*  9928 */       return 4;
/*       */     }
/*  9930 */     if (strFieldName.equals("nT40")) {
/*  9931 */       return 4;
/*       */     }
/*  9933 */     if (strFieldName.equals("nT41")) {
/*  9934 */       return 4;
/*       */     }
/*  9936 */     if (strFieldName.equals("nT42")) {
/*  9937 */       return 4;
/*       */     }
/*  9939 */     if (strFieldName.equals("nT43")) {
/*  9940 */       return 4;
/*       */     }
/*  9942 */     if (strFieldName.equals("nT44")) {
/*  9943 */       return 4;
/*       */     }
/*  9945 */     if (strFieldName.equals("nT45")) {
/*  9946 */       return 4;
/*       */     }
/*  9948 */     if (strFieldName.equals("nT46")) {
/*  9949 */       return 4;
/*       */     }
/*  9951 */     if (strFieldName.equals("nT47")) {
/*  9952 */       return 4;
/*       */     }
/*  9954 */     if (strFieldName.equals("nT48")) {
/*  9955 */       return 4;
/*       */     }
/*  9957 */     if (strFieldName.equals("nT49")) {
/*  9958 */       return 4;
/*       */     }
/*  9960 */     if (strFieldName.equals("nT50")) {
/*  9961 */       return 4;
/*       */     }
/*  9963 */     if (strFieldName.equals("nT51")) {
/*  9964 */       return 4;
/*       */     }
/*  9966 */     if (strFieldName.equals("nT52")) {
/*  9967 */       return 4;
/*       */     }
/*  9969 */     if (strFieldName.equals("nT53")) {
/*  9970 */       return 4;
/*       */     }
/*  9972 */     if (strFieldName.equals("nT54")) {
/*  9973 */       return 4;
/*       */     }
/*  9975 */     if (strFieldName.equals("nT55")) {
/*  9976 */       return 4;
/*       */     }
/*  9978 */     if (strFieldName.equals("nT56")) {
/*  9979 */       return 4;
/*       */     }
/*  9981 */     if (strFieldName.equals("nT57")) {
/*  9982 */       return 4;
/*       */     }
/*  9984 */     if (strFieldName.equals("nT58")) {
/*  9985 */       return 4;
/*       */     }
/*  9987 */     if (strFieldName.equals("nT59")) {
/*  9988 */       return 4;
/*       */     }
/*  9990 */     if (strFieldName.equals("nT60")) {
/*  9991 */       return 4;
/*       */     }
/*  9993 */     if (strFieldName.equals("nT61")) {
/*  9994 */       return 4;
/*       */     }
/*  9996 */     if (strFieldName.equals("nT62")) {
/*  9997 */       return 4;
/*       */     }
/*  9999 */     if (strFieldName.equals("nT63")) {
/* 10000 */       return 4;
/*       */     }
/* 10002 */     if (strFieldName.equals("nT64")) {
/* 10003 */       return 4;
/*       */     }
/* 10005 */     if (strFieldName.equals("nT65")) {
/* 10006 */       return 4;
/*       */     }
/* 10008 */     if (strFieldName.equals("nT66")) {
/* 10009 */       return 4;
/*       */     }
/* 10011 */     if (strFieldName.equals("nT67")) {
/* 10012 */       return 4;
/*       */     }
/* 10014 */     if (strFieldName.equals("nT68")) {
/* 10015 */       return 4;
/*       */     }
/* 10017 */     if (strFieldName.equals("nT69")) {
/* 10018 */       return 4;
/*       */     }
/* 10020 */     if (strFieldName.equals("nT70")) {
/* 10021 */       return 4;
/*       */     }
/* 10023 */     if (strFieldName.equals("nT71")) {
/* 10024 */       return 4;
/*       */     }
/* 10026 */     if (strFieldName.equals("nT72")) {
/* 10027 */       return 4;
/*       */     }
/* 10029 */     if (strFieldName.equals("nT73")) {
/* 10030 */       return 4;
/*       */     }
/* 10032 */     if (strFieldName.equals("nT74")) {
/* 10033 */       return 4;
/*       */     }
/* 10035 */     if (strFieldName.equals("nT75")) {
/* 10036 */       return 4;
/*       */     }
/* 10038 */     if (strFieldName.equals("nT76")) {
/* 10039 */       return 4;
/*       */     }
/* 10041 */     if (strFieldName.equals("nT77")) {
/* 10042 */       return 4;
/*       */     }
/* 10044 */     if (strFieldName.equals("nT78")) {
/* 10045 */       return 4;
/*       */     }
/* 10047 */     if (strFieldName.equals("nT79")) {
/* 10048 */       return 4;
/*       */     }
/* 10050 */     if (strFieldName.equals("nT80")) {
/* 10051 */       return 4;
/*       */     }
/* 10053 */     if (strFieldName.equals("nF01")) {
/* 10054 */       return 4;
/*       */     }
/* 10056 */     if (strFieldName.equals("nF02")) {
/* 10057 */       return 4;
/*       */     }
/* 10059 */     if (strFieldName.equals("nF03")) {
/* 10060 */       return 4;
/*       */     }
/* 10062 */     if (strFieldName.equals("nF04")) {
/* 10063 */       return 4;
/*       */     }
/* 10065 */     if (strFieldName.equals("nF05")) {
/* 10066 */       return 4;
/*       */     }
/* 10068 */     if (strFieldName.equals("nF06")) {
/* 10069 */       return 4;
/*       */     }
/* 10071 */     if (strFieldName.equals("nF07")) {
/* 10072 */       return 4;
/*       */     }
/* 10074 */     if (strFieldName.equals("nF08")) {
/* 10075 */       return 4;
/*       */     }
/* 10077 */     if (strFieldName.equals("nF09")) {
/* 10078 */       return 4;
/*       */     }
/* 10080 */     if (strFieldName.equals("nF10")) {
/* 10081 */       return 4;
/*       */     }
/* 10083 */     if (strFieldName.equals("nS01")) {
/* 10084 */       return 4;
/*       */     }
/* 10086 */     if (strFieldName.equals("nS02")) {
/* 10087 */       return 4;
/*       */     }
/* 10089 */     if (strFieldName.equals("nS03")) {
/* 10090 */       return 4;
/*       */     }
/* 10092 */     if (strFieldName.equals("nS04")) {
/* 10093 */       return 4;
/*       */     }
/* 10095 */     if (strFieldName.equals("nS05")) {
/* 10096 */       return 4;
/*       */     }
/* 10098 */     if (strFieldName.equals("nS06")) {
/* 10099 */       return 4;
/*       */     }
/* 10101 */     if (strFieldName.equals("nS07")) {
/* 10102 */       return 4;
/*       */     }
/* 10104 */     if (strFieldName.equals("nS08")) {
/* 10105 */       return 4;
/*       */     }
/* 10107 */     if (strFieldName.equals("nS09")) {
/* 10108 */       return 4;
/*       */     }
/* 10110 */     if (strFieldName.equals("nS10")) {
/* 10111 */       return 4;
/*       */     }
/* 10113 */     if (strFieldName.equals("iNT01")) {
/* 10114 */       return 3;
/*       */     }
/* 10116 */     if (strFieldName.equals("iNT02")) {
/* 10117 */       return 3;
/*       */     }
/* 10119 */     if (strFieldName.equals("iNT03")) {
/* 10120 */       return 3;
/*       */     }
/* 10122 */     if (strFieldName.equals("iNT04")) {
/* 10123 */       return 3;
/*       */     }
/* 10125 */     if (strFieldName.equals("iNT05")) {
/* 10126 */       return 3;
/*       */     }
/* 10128 */     if (strFieldName.equals("iNT06")) {
/* 10129 */       return 3;
/*       */     }
/* 10131 */     if (strFieldName.equals("iNT07")) {
/* 10132 */       return 3;
/*       */     }
/* 10134 */     if (strFieldName.equals("iNT08")) {
/* 10135 */       return 3;
/*       */     }
/* 10137 */     if (strFieldName.equals("iNT09")) {
/* 10138 */       return 3;
/*       */     }
/* 10140 */     if (strFieldName.equals("iNT10")) {
/* 10141 */       return 3;
/*       */     }
/* 10143 */     if (strFieldName.equals("iNT11")) {
/* 10144 */       return 3;
/*       */     }
/* 10146 */     if (strFieldName.equals("iNT12")) {
/* 10147 */       return 3;
/*       */     }
/* 10149 */     if (strFieldName.equals("iNT13")) {
/* 10150 */       return 3;
/*       */     }
/* 10152 */     if (strFieldName.equals("iNT14")) {
/* 10153 */       return 3;
/*       */     }
/* 10155 */     if (strFieldName.equals("iNT15")) {
/* 10156 */       return 3;
/*       */     }
/* 10158 */     if (strFieldName.equals("iNT16")) {
/* 10159 */       return 3;
/*       */     }
/* 10161 */     if (strFieldName.equals("iNT17")) {
/* 10162 */       return 3;
/*       */     }
/* 10164 */     if (strFieldName.equals("iNT18")) {
/* 10165 */       return 3;
/*       */     }
/* 10167 */     if (strFieldName.equals("iNT19")) {
/* 10168 */       return 3;
/*       */     }
/* 10170 */     if (strFieldName.equals("iNT20")) {
/* 10171 */       return 3;
/*       */     }
/* 10173 */     if (strFieldName.equals("iNT21")) {
/* 10174 */       return 3;
/*       */     }
/* 10176 */     if (strFieldName.equals("iNT22")) {
/* 10177 */       return 3;
/*       */     }
/* 10179 */     if (strFieldName.equals("iNT23")) {
/* 10180 */       return 3;
/*       */     }
/* 10182 */     if (strFieldName.equals("iNT24")) {
/* 10183 */       return 3;
/*       */     }
/* 10185 */     if (strFieldName.equals("iNT25")) {
/* 10186 */       return 3;
/*       */     }
/* 10188 */     if (strFieldName.equals("v1")) {
/* 10189 */       return 0;
/*       */     }
/* 10191 */     if (strFieldName.equals("v2")) {
/* 10192 */       return 0;
/*       */     }
/* 10194 */     if (strFieldName.equals("v3")) {
/* 10195 */       return 0;
/*       */     }
/* 10197 */     if (strFieldName.equals("v4")) {
/* 10198 */       return 0;
/*       */     }
/* 10200 */     if (strFieldName.equals("v5")) {
/* 10201 */       return 0;
/*       */     }
/* 10203 */     if (strFieldName.equals("v6")) {
/* 10204 */       return 0;
/*       */     }
/* 10206 */     if (strFieldName.equals("v7")) {
/* 10207 */       return 0;
/*       */     }
/* 10209 */     if (strFieldName.equals("v8")) {
/* 10210 */       return 0;
/*       */     }
/* 10212 */     if (strFieldName.equals("v9")) {
/* 10213 */       return 0;
/*       */     }
/* 10215 */     if (strFieldName.equals("v10")) {
/* 10216 */       return 0;
/*       */     }
/* 10218 */     if (strFieldName.equals("v11")) {
/* 10219 */       return 0;
/*       */     }
/* 10221 */     if (strFieldName.equals("v12")) {
/* 10222 */       return 0;
/*       */     }
/* 10224 */     if (strFieldName.equals("v13")) {
/* 10225 */       return 0;
/*       */     }
/* 10227 */     if (strFieldName.equals("v14")) {
/* 10228 */       return 0;
/*       */     }
/* 10230 */     if (strFieldName.equals("v15")) {
/* 10231 */       return 0;
/*       */     }
/* 10233 */     if (strFieldName.equals("v16")) {
/* 10234 */       return 0;
/*       */     }
/* 10236 */     if (strFieldName.equals("v17")) {
/* 10237 */       return 0;
/*       */     }
/* 10239 */     if (strFieldName.equals("v18")) {
/* 10240 */       return 0;
/*       */     }
/* 10242 */     if (strFieldName.equals("v19")) {
/* 10243 */       return 0;
/*       */     }
/* 10245 */     if (strFieldName.equals("v20")) {
/* 10246 */       return 0;
/*       */     }
/* 10248 */     if (strFieldName.equals("vT1")) {
/* 10249 */       return 0;
/*       */     }
/* 10251 */     if (strFieldName.equals("vT2")) {
/* 10252 */       return 0;
/*       */     }
/* 10254 */     if (strFieldName.equals("vT3")) {
/* 10255 */       return 0;
/*       */     }
/* 10257 */     if (strFieldName.equals("vT4")) {
/* 10258 */       return 0;
/*       */     }
/* 10260 */     if (strFieldName.equals("vT5")) {
/* 10261 */       return 0;
/*       */     }
/* 10263 */     if (strFieldName.equals("vT6")) {
/* 10264 */       return 0;
/*       */     }
/* 10266 */     if (strFieldName.equals("vT7")) {
/* 10267 */       return 0;
/*       */     }
/* 10269 */     if (strFieldName.equals("vT8")) {
/* 10270 */       return 0;
/*       */     }
/* 10272 */     if (strFieldName.equals("vE1")) {
/* 10273 */       return 0;
/*       */     }
/* 10275 */     if (strFieldName.equals("vE2")) {
/* 10276 */       return 0;
/*       */     }
/* 10278 */     if (strFieldName.equals("vE3")) {
/* 10279 */       return 0;
/*       */     }
/* 10281 */     if (strFieldName.equals("vE4")) {
/* 10282 */       return 0;
/*       */     }
/* 10284 */     if (strFieldName.equals("vE5")) {
/* 10285 */       return 0;
/*       */     }
/* 10287 */     if (strFieldName.equals("vE6")) {
/* 10288 */       return 0;
/*       */     }
/* 10290 */     if (strFieldName.equals("vE7")) {
/* 10291 */       return 0;
/*       */     }
/* 10293 */     if (strFieldName.equals("vE8")) {
/* 10294 */       return 0;
/*       */     }
/* 10296 */     if (strFieldName.equals("vE9")) {
/* 10297 */       return 0;
/*       */     }
/* 10299 */     if (strFieldName.equals("vE10")) {
/* 10300 */       return 0;
/*       */     }
/* 10302 */     if (strFieldName.equals("d1")) {
/* 10303 */       return 1;
/*       */     }
/* 10305 */     if (strFieldName.equals("d2")) {
/* 10306 */       return 1;
/*       */     }
/* 10308 */     if (strFieldName.equals("d3")) {
/* 10309 */       return 1;
/*       */     }
/* 10311 */     if (strFieldName.equals("d4")) {
/* 10312 */       return 1;
/*       */     }
/* 10314 */     if (strFieldName.equals("d5")) {
/* 10315 */       return 1;
/*       */     }
/* 10317 */     if (strFieldName.equals("d6")) {
/* 10318 */       return 1;
/*       */     }
/* 10320 */     if (strFieldName.equals("d7")) {
/* 10321 */       return 1;
/*       */     }
/* 10323 */     if (strFieldName.equals("d8")) {
/* 10324 */       return 1;
/*       */     }
/* 10326 */     if (strFieldName.equals("d9")) {
/* 10327 */       return 1;
/*       */     }
/* 10329 */     if (strFieldName.equals("d10")) {
/* 10330 */       return 1;
/*       */     }
/* 10332 */     if (strFieldName.equals("state")) {
/* 10333 */       return 0;
/*       */     }
/* 10335 */     if (strFieldName.equals("operator")) {
/* 10336 */       return 0;
/*       */     }
/* 10338 */     if (strFieldName.equals("makeDate")) {
/* 10339 */       return 1;
/*       */     }
/* 10341 */     if (strFieldName.equals("makeTime")) {
/* 10342 */       return 0;
/*       */     }
/* 10344 */     if (strFieldName.equals("modifyDate")) {
/* 10345 */       return 1;
/*       */     }
/* 10347 */     if (strFieldName.equals("modifyTime")) {
/* 10348 */       return 0;
/*       */     }
/* 10350 */     return -1;
/*       */   }
/*       */ 
/*       */   public int getFieldType(int nFieldIndex)
/*       */   {
/* 10356 */     int nFieldType = -1;
/* 10357 */     switch (nFieldIndex) {
/*       */     case 0:
/* 10359 */       nFieldType = 0;
/* 10360 */       break;
/*       */     case 1:
/* 10362 */       nFieldType = 0;
/* 10363 */       break;
/*       */     case 2:
/* 10365 */       nFieldType = 0;
/* 10366 */       break;
/*       */     case 3:
/* 10368 */       nFieldType = 0;
/* 10369 */       break;
/*       */     case 4:
/* 10371 */       nFieldType = 0;
/* 10372 */       break;
/*       */     case 5:
/* 10374 */       nFieldType = 0;
/* 10375 */       break;
/*       */     case 6:
/* 10377 */       nFieldType = 0;
/* 10378 */       break;
/*       */     case 7:
/* 10380 */       nFieldType = 0;
/* 10381 */       break;
/*       */     case 8:
/* 10383 */       nFieldType = 3;
/* 10384 */       break;
/*       */     case 9:
/* 10386 */       nFieldType = 3;
/* 10387 */       break;
/*       */     case 10:
/* 10389 */       nFieldType = 0;
/* 10390 */       break;
/*       */     case 11:
/* 10392 */       nFieldType = 0;
/* 10393 */       break;
/*       */     case 12:
/* 10395 */       nFieldType = 0;
/* 10396 */       break;
/*       */     case 13:
/* 10398 */       nFieldType = 0;
/* 10399 */       break;
/*       */     case 14:
/* 10401 */       nFieldType = 0;
/* 10402 */       break;
/*       */     case 15:
/* 10404 */       nFieldType = 0;
/* 10405 */       break;
/*       */     case 16:
/* 10407 */       nFieldType = 0;
/* 10408 */       break;
/*       */     case 17:
/* 10410 */       nFieldType = 1;
/* 10411 */       break;
/*       */     case 18:
/* 10413 */       nFieldType = 1;
/* 10414 */       break;
/*       */     case 19:
/* 10416 */       nFieldType = 1;
/* 10417 */       break;
/*       */     case 20:
/* 10419 */       nFieldType = 1;
/* 10420 */       break;
/*       */     case 21:
/* 10422 */       nFieldType = 1;
/* 10423 */       break;
/*       */     case 22:
/* 10425 */       nFieldType = 1;
/* 10426 */       break;
/*       */     case 23:
/* 10428 */       nFieldType = 1;
/* 10429 */       break;
/*       */     case 24:
/* 10431 */       nFieldType = 1;
/* 10432 */       break;
/*       */     case 25:
/* 10434 */       nFieldType = 1;
/* 10435 */       break;
/*       */     case 26:
/* 10437 */       nFieldType = 1;
/* 10438 */       break;
/*       */     case 27:
/* 10440 */       nFieldType = 3;
/* 10441 */       break;
/*       */     case 28:
/* 10443 */       nFieldType = 4;
/* 10444 */       break;
/*       */     case 29:
/* 10446 */       nFieldType = 4;
/* 10447 */       break;
/*       */     case 30:
/* 10449 */       nFieldType = 4;
/* 10450 */       break;
/*       */     case 31:
/* 10452 */       nFieldType = 4;
/* 10453 */       break;
/*       */     case 32:
/* 10455 */       nFieldType = 4;
/* 10456 */       break;
/*       */     case 33:
/* 10458 */       nFieldType = 4;
/* 10459 */       break;
/*       */     case 34:
/* 10461 */       nFieldType = 4;
/* 10462 */       break;
/*       */     case 35:
/* 10464 */       nFieldType = 4;
/* 10465 */       break;
/*       */     case 36:
/* 10467 */       nFieldType = 4;
/* 10468 */       break;
/*       */     case 37:
/* 10470 */       nFieldType = 4;
/* 10471 */       break;
/*       */     case 38:
/* 10473 */       nFieldType = 4;
/* 10474 */       break;
/*       */     case 39:
/* 10476 */       nFieldType = 4;
/* 10477 */       break;
/*       */     case 40:
/* 10479 */       nFieldType = 4;
/* 10480 */       break;
/*       */     case 41:
/* 10482 */       nFieldType = 4;
/* 10483 */       break;
/*       */     case 42:
/* 10485 */       nFieldType = 4;
/* 10486 */       break;
/*       */     case 43:
/* 10488 */       nFieldType = 4;
/* 10489 */       break;
/*       */     case 44:
/* 10491 */       nFieldType = 4;
/* 10492 */       break;
/*       */     case 45:
/* 10494 */       nFieldType = 4;
/* 10495 */       break;
/*       */     case 46:
/* 10497 */       nFieldType = 4;
/* 10498 */       break;
/*       */     case 47:
/* 10500 */       nFieldType = 4;
/* 10501 */       break;
/*       */     case 48:
/* 10503 */       nFieldType = 4;
/* 10504 */       break;
/*       */     case 49:
/* 10506 */       nFieldType = 4;
/* 10507 */       break;
/*       */     case 50:
/* 10509 */       nFieldType = 4;
/* 10510 */       break;
/*       */     case 51:
/* 10512 */       nFieldType = 4;
/* 10513 */       break;
/*       */     case 52:
/* 10515 */       nFieldType = 4;
/* 10516 */       break;
/*       */     case 53:
/* 10518 */       nFieldType = 4;
/* 10519 */       break;
/*       */     case 54:
/* 10521 */       nFieldType = 4;
/* 10522 */       break;
/*       */     case 55:
/* 10524 */       nFieldType = 4;
/* 10525 */       break;
/*       */     case 56:
/* 10527 */       nFieldType = 4;
/* 10528 */       break;
/*       */     case 57:
/* 10530 */       nFieldType = 4;
/* 10531 */       break;
/*       */     case 58:
/* 10533 */       nFieldType = 4;
/* 10534 */       break;
/*       */     case 59:
/* 10536 */       nFieldType = 4;
/* 10537 */       break;
/*       */     case 60:
/* 10539 */       nFieldType = 4;
/* 10540 */       break;
/*       */     case 61:
/* 10542 */       nFieldType = 4;
/* 10543 */       break;
/*       */     case 62:
/* 10545 */       nFieldType = 4;
/* 10546 */       break;
/*       */     case 63:
/* 10548 */       nFieldType = 4;
/* 10549 */       break;
/*       */     case 64:
/* 10551 */       nFieldType = 4;
/* 10552 */       break;
/*       */     case 65:
/* 10554 */       nFieldType = 4;
/* 10555 */       break;
/*       */     case 66:
/* 10557 */       nFieldType = 4;
/* 10558 */       break;
/*       */     case 67:
/* 10560 */       nFieldType = 4;
/* 10561 */       break;
/*       */     case 68:
/* 10563 */       nFieldType = 4;
/* 10564 */       break;
/*       */     case 69:
/* 10566 */       nFieldType = 4;
/* 10567 */       break;
/*       */     case 70:
/* 10569 */       nFieldType = 4;
/* 10570 */       break;
/*       */     case 71:
/* 10572 */       nFieldType = 4;
/* 10573 */       break;
/*       */     case 72:
/* 10575 */       nFieldType = 4;
/* 10576 */       break;
/*       */     case 73:
/* 10578 */       nFieldType = 4;
/* 10579 */       break;
/*       */     case 74:
/* 10581 */       nFieldType = 4;
/* 10582 */       break;
/*       */     case 75:
/* 10584 */       nFieldType = 4;
/* 10585 */       break;
/*       */     case 76:
/* 10587 */       nFieldType = 4;
/* 10588 */       break;
/*       */     case 77:
/* 10590 */       nFieldType = 4;
/* 10591 */       break;
/*       */     case 78:
/* 10593 */       nFieldType = 4;
/* 10594 */       break;
/*       */     case 79:
/* 10596 */       nFieldType = 4;
/* 10597 */       break;
/*       */     case 80:
/* 10599 */       nFieldType = 4;
/* 10600 */       break;
/*       */     case 81:
/* 10602 */       nFieldType = 4;
/* 10603 */       break;
/*       */     case 82:
/* 10605 */       nFieldType = 4;
/* 10606 */       break;
/*       */     case 83:
/* 10608 */       nFieldType = 4;
/* 10609 */       break;
/*       */     case 84:
/* 10611 */       nFieldType = 4;
/* 10612 */       break;
/*       */     case 85:
/* 10614 */       nFieldType = 4;
/* 10615 */       break;
/*       */     case 86:
/* 10617 */       nFieldType = 4;
/* 10618 */       break;
/*       */     case 87:
/* 10620 */       nFieldType = 4;
/* 10621 */       break;
/*       */     case 88:
/* 10623 */       nFieldType = 4;
/* 10624 */       break;
/*       */     case 89:
/* 10626 */       nFieldType = 4;
/* 10627 */       break;
/*       */     case 90:
/* 10629 */       nFieldType = 4;
/* 10630 */       break;
/*       */     case 91:
/* 10632 */       nFieldType = 4;
/* 10633 */       break;
/*       */     case 92:
/* 10635 */       nFieldType = 4;
/* 10636 */       break;
/*       */     case 93:
/* 10638 */       nFieldType = 4;
/* 10639 */       break;
/*       */     case 94:
/* 10641 */       nFieldType = 4;
/* 10642 */       break;
/*       */     case 95:
/* 10644 */       nFieldType = 4;
/* 10645 */       break;
/*       */     case 96:
/* 10647 */       nFieldType = 4;
/* 10648 */       break;
/*       */     case 97:
/* 10650 */       nFieldType = 4;
/* 10651 */       break;
/*       */     case 98:
/* 10653 */       nFieldType = 4;
/* 10654 */       break;
/*       */     case 99:
/* 10656 */       nFieldType = 4;
/* 10657 */       break;
/*       */     case 100:
/* 10659 */       nFieldType = 4;
/* 10660 */       break;
/*       */     case 101:
/* 10662 */       nFieldType = 4;
/* 10663 */       break;
/*       */     case 102:
/* 10665 */       nFieldType = 4;
/* 10666 */       break;
/*       */     case 103:
/* 10668 */       nFieldType = 4;
/* 10669 */       break;
/*       */     case 104:
/* 10671 */       nFieldType = 4;
/* 10672 */       break;
/*       */     case 105:
/* 10674 */       nFieldType = 4;
/* 10675 */       break;
/*       */     case 106:
/* 10677 */       nFieldType = 4;
/* 10678 */       break;
/*       */     case 107:
/* 10680 */       nFieldType = 4;
/* 10681 */       break;
/*       */     case 108:
/* 10683 */       nFieldType = 4;
/* 10684 */       break;
/*       */     case 109:
/* 10686 */       nFieldType = 4;
/* 10687 */       break;
/*       */     case 110:
/* 10689 */       nFieldType = 4;
/* 10690 */       break;
/*       */     case 111:
/* 10692 */       nFieldType = 4;
/* 10693 */       break;
/*       */     case 112:
/* 10695 */       nFieldType = 4;
/* 10696 */       break;
/*       */     case 113:
/* 10698 */       nFieldType = 4;
/* 10699 */       break;
/*       */     case 114:
/* 10701 */       nFieldType = 4;
/* 10702 */       break;
/*       */     case 115:
/* 10704 */       nFieldType = 4;
/* 10705 */       break;
/*       */     case 116:
/* 10707 */       nFieldType = 4;
/* 10708 */       break;
/*       */     case 117:
/* 10710 */       nFieldType = 4;
/* 10711 */       break;
/*       */     case 118:
/* 10713 */       nFieldType = 4;
/* 10714 */       break;
/*       */     case 119:
/* 10716 */       nFieldType = 4;
/* 10717 */       break;
/*       */     case 120:
/* 10719 */       nFieldType = 4;
/* 10720 */       break;
/*       */     case 121:
/* 10722 */       nFieldType = 4;
/* 10723 */       break;
/*       */     case 122:
/* 10725 */       nFieldType = 4;
/* 10726 */       break;
/*       */     case 123:
/* 10728 */       nFieldType = 4;
/* 10729 */       break;
/*       */     case 124:
/* 10731 */       nFieldType = 4;
/* 10732 */       break;
/*       */     case 125:
/* 10734 */       nFieldType = 4;
/* 10735 */       break;
/*       */     case 126:
/* 10737 */       nFieldType = 4;
/* 10738 */       break;
/*       */     case 127:
/* 10740 */       nFieldType = 4;
/* 10741 */       break;
/*       */     case 128:
/* 10743 */       nFieldType = 3;
/* 10744 */       break;
/*       */     case 129:
/* 10746 */       nFieldType = 3;
/* 10747 */       break;
/*       */     case 130:
/* 10749 */       nFieldType = 3;
/* 10750 */       break;
/*       */     case 131:
/* 10752 */       nFieldType = 3;
/* 10753 */       break;
/*       */     case 132:
/* 10755 */       nFieldType = 3;
/* 10756 */       break;
/*       */     case 133:
/* 10758 */       nFieldType = 3;
/* 10759 */       break;
/*       */     case 134:
/* 10761 */       nFieldType = 3;
/* 10762 */       break;
/*       */     case 135:
/* 10764 */       nFieldType = 3;
/* 10765 */       break;
/*       */     case 136:
/* 10767 */       nFieldType = 3;
/* 10768 */       break;
/*       */     case 137:
/* 10770 */       nFieldType = 3;
/* 10771 */       break;
/*       */     case 138:
/* 10773 */       nFieldType = 3;
/* 10774 */       break;
/*       */     case 139:
/* 10776 */       nFieldType = 3;
/* 10777 */       break;
/*       */     case 140:
/* 10779 */       nFieldType = 3;
/* 10780 */       break;
/*       */     case 141:
/* 10782 */       nFieldType = 3;
/* 10783 */       break;
/*       */     case 142:
/* 10785 */       nFieldType = 3;
/* 10786 */       break;
/*       */     case 143:
/* 10788 */       nFieldType = 3;
/* 10789 */       break;
/*       */     case 144:
/* 10791 */       nFieldType = 3;
/* 10792 */       break;
/*       */     case 145:
/* 10794 */       nFieldType = 3;
/* 10795 */       break;
/*       */     case 146:
/* 10797 */       nFieldType = 3;
/* 10798 */       break;
/*       */     case 147:
/* 10800 */       nFieldType = 3;
/* 10801 */       break;
/*       */     case 148:
/* 10803 */       nFieldType = 3;
/* 10804 */       break;
/*       */     case 149:
/* 10806 */       nFieldType = 3;
/* 10807 */       break;
/*       */     case 150:
/* 10809 */       nFieldType = 3;
/* 10810 */       break;
/*       */     case 151:
/* 10812 */       nFieldType = 3;
/* 10813 */       break;
/*       */     case 152:
/* 10815 */       nFieldType = 3;
/* 10816 */       break;
/*       */     case 153:
/* 10818 */       nFieldType = 0;
/* 10819 */       break;
/*       */     case 154:
/* 10821 */       nFieldType = 0;
/* 10822 */       break;
/*       */     case 155:
/* 10824 */       nFieldType = 0;
/* 10825 */       break;
/*       */     case 156:
/* 10827 */       nFieldType = 0;
/* 10828 */       break;
/*       */     case 157:
/* 10830 */       nFieldType = 0;
/* 10831 */       break;
/*       */     case 158:
/* 10833 */       nFieldType = 0;
/* 10834 */       break;
/*       */     case 159:
/* 10836 */       nFieldType = 0;
/* 10837 */       break;
/*       */     case 160:
/* 10839 */       nFieldType = 0;
/* 10840 */       break;
/*       */     case 161:
/* 10842 */       nFieldType = 0;
/* 10843 */       break;
/*       */     case 162:
/* 10845 */       nFieldType = 0;
/* 10846 */       break;
/*       */     case 163:
/* 10848 */       nFieldType = 0;
/* 10849 */       break;
/*       */     case 164:
/* 10851 */       nFieldType = 0;
/* 10852 */       break;
/*       */     case 165:
/* 10854 */       nFieldType = 0;
/* 10855 */       break;
/*       */     case 166:
/* 10857 */       nFieldType = 0;
/* 10858 */       break;
/*       */     case 167:
/* 10860 */       nFieldType = 0;
/* 10861 */       break;
/*       */     case 168:
/* 10863 */       nFieldType = 0;
/* 10864 */       break;
/*       */     case 169:
/* 10866 */       nFieldType = 0;
/* 10867 */       break;
/*       */     case 170:
/* 10869 */       nFieldType = 0;
/* 10870 */       break;
/*       */     case 171:
/* 10872 */       nFieldType = 0;
/* 10873 */       break;
/*       */     case 172:
/* 10875 */       nFieldType = 0;
/* 10876 */       break;
/*       */     case 173:
/* 10878 */       nFieldType = 0;
/* 10879 */       break;
/*       */     case 174:
/* 10881 */       nFieldType = 0;
/* 10882 */       break;
/*       */     case 175:
/* 10884 */       nFieldType = 0;
/* 10885 */       break;
/*       */     case 176:
/* 10887 */       nFieldType = 0;
/* 10888 */       break;
/*       */     case 177:
/* 10890 */       nFieldType = 0;
/* 10891 */       break;
/*       */     case 178:
/* 10893 */       nFieldType = 0;
/* 10894 */       break;
/*       */     case 179:
/* 10896 */       nFieldType = 0;
/* 10897 */       break;
/*       */     case 180:
/* 10899 */       nFieldType = 0;
/* 10900 */       break;
/*       */     case 181:
/* 10902 */       nFieldType = 0;
/* 10903 */       break;
/*       */     case 182:
/* 10905 */       nFieldType = 0;
/* 10906 */       break;
/*       */     case 183:
/* 10908 */       nFieldType = 0;
/* 10909 */       break;
/*       */     case 184:
/* 10911 */       nFieldType = 0;
/* 10912 */       break;
/*       */     case 185:
/* 10914 */       nFieldType = 0;
/* 10915 */       break;
/*       */     case 186:
/* 10917 */       nFieldType = 0;
/* 10918 */       break;
/*       */     case 187:
/* 10920 */       nFieldType = 0;
/* 10921 */       break;
/*       */     case 188:
/* 10923 */       nFieldType = 0;
/* 10924 */       break;
/*       */     case 189:
/* 10926 */       nFieldType = 0;
/* 10927 */       break;
/*       */     case 190:
/* 10929 */       nFieldType = 0;
/* 10930 */       break;
/*       */     case 191:
/* 10932 */       nFieldType = 1;
/* 10933 */       break;
/*       */     case 192:
/* 10935 */       nFieldType = 1;
/* 10936 */       break;
/*       */     case 193:
/* 10938 */       nFieldType = 1;
/* 10939 */       break;
/*       */     case 194:
/* 10941 */       nFieldType = 1;
/* 10942 */       break;
/*       */     case 195:
/* 10944 */       nFieldType = 1;
/* 10945 */       break;
/*       */     case 196:
/* 10947 */       nFieldType = 1;
/* 10948 */       break;
/*       */     case 197:
/* 10950 */       nFieldType = 1;
/* 10951 */       break;
/*       */     case 198:
/* 10953 */       nFieldType = 1;
/* 10954 */       break;
/*       */     case 199:
/* 10956 */       nFieldType = 1;
/* 10957 */       break;
/*       */     case 200:
/* 10959 */       nFieldType = 1;
/* 10960 */       break;
/*       */     case 201:
/* 10962 */       nFieldType = 0;
/* 10963 */       break;
/*       */     case 202:
/* 10965 */       nFieldType = 0;
/* 10966 */       break;
/*       */     case 203:
/* 10968 */       nFieldType = 1;
/* 10969 */       break;
/*       */     case 204:
/* 10971 */       nFieldType = 0;
/* 10972 */       break;
/*       */     case 205:
/* 10974 */       nFieldType = 1;
/* 10975 */       break;
/*       */     case 206:
/* 10977 */       nFieldType = 0;
/* 10978 */       break;
/*       */     default:
/* 10980 */       nFieldType = -1;
/*       */     }
/* 10982 */     return nFieldType;
/*       */   }
/*       */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.LAIndexInfoNewSchema
 * JD-Core Version:    0.6.0
 */