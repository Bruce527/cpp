/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LAComDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LAComSchema
/*      */   implements Schema
/*      */ {
/*      */   private String AGENTCOM;
/*      */   private String MANAGECOM;
/*      */   private String AREATYPE;
/*      */   private String CHANNELTYPE;
/*      */   private String UPAGENTCOM;
/*      */   private String NAME;
/*      */   private String ADDRESS;
/*      */   private String ZIPCODE;
/*      */   private String PHONE;
/*      */   private String FAX;
/*      */   private String EMAIL;
/*      */   private String WEBADDRESS;
/*      */   private String LINKMAN;
/*      */   private String PASSWORD;
/*      */   private String CORPORATION;
/*      */   private String BANKCODE;
/*      */   private String BANKACCNO;
/*      */   private String BUSINESSTYPE;
/*      */   private String GRPNATURE;
/*      */   private String ACTYPE;
/*      */   private String SELLFLAG;
/*      */   private String OPERATOR;
/*      */   private String MAKEDATE;
/*      */   private String MAKETIME;
/*      */   private String MODIFYDATE;
/*      */   private String MODIFYTIME;
/*      */   private String BANKTYPE;
/*      */   private String CALFLAG;
/*      */   private String BUSILICENSECODE;
/*      */   private String INSUREID;
/*      */   private String INSUREPRINCIPAL;
/*      */   private String CHIEFBUSINESS;
/*      */   private String BUSIADDRESS;
/*      */   private String SUBSCRIBEMAN;
/*      */   private String SUBSCRIBEMANDUTY;
/*      */   private String LICENSENO;
/*      */   private String REGIONALISMCODE;
/*      */   private String APPAGENTCOM;
/*      */   private String STATE;
/*      */   private String NOTI;
/*      */   private String BUSINESSCODE;
/*      */   private String LICENSESTARTDATE;
/*      */   private String LICENSEENDDATE;
/*      */   private String COMTYPE;
/*      */   private String ETL_DATATIME;
/*      */   private String ETL_DATATYPE;
/*      */   public static final int FIELDNUM = 46;
/*      */   private static String[] PK;
/*  117 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LAComSchema()
/*      */   {
/*  124 */     this.mErrors = new CErrors();
/*      */ 
/*  126 */     String[] pk = new String[1];
/*  127 */     pk[0] = "AGENTCOM";
/*      */ 
/*  129 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  135 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getAGENTCOM()
/*      */   {
/*  140 */     if (this.AGENTCOM != null) this.AGENTCOM.equals("");
/*      */ 
/*  144 */     return this.AGENTCOM;
/*      */   }
/*      */ 
/*      */   public void setAGENTCOM(String aAGENTCOM) {
/*  148 */     this.AGENTCOM = aAGENTCOM;
/*      */   }
/*      */ 
/*      */   public String getMANAGECOM() {
/*  152 */     if (this.MANAGECOM != null) this.MANAGECOM.equals("");
/*      */ 
/*  156 */     return this.MANAGECOM;
/*      */   }
/*      */ 
/*      */   public void setMANAGECOM(String aMANAGECOM) {
/*  160 */     this.MANAGECOM = aMANAGECOM;
/*      */   }
/*      */ 
/*      */   public String getAREATYPE() {
/*  164 */     if (this.AREATYPE != null) this.AREATYPE.equals("");
/*      */ 
/*  168 */     return this.AREATYPE;
/*      */   }
/*      */ 
/*      */   public void setAREATYPE(String aAREATYPE) {
/*  172 */     this.AREATYPE = aAREATYPE;
/*      */   }
/*      */ 
/*      */   public String getCHANNELTYPE() {
/*  176 */     if (this.CHANNELTYPE != null) this.CHANNELTYPE.equals("");
/*      */ 
/*  180 */     return this.CHANNELTYPE;
/*      */   }
/*      */ 
/*      */   public void setCHANNELTYPE(String aCHANNELTYPE) {
/*  184 */     this.CHANNELTYPE = aCHANNELTYPE;
/*      */   }
/*      */ 
/*      */   public String getUPAGENTCOM() {
/*  188 */     if (this.UPAGENTCOM != null) this.UPAGENTCOM.equals("");
/*      */ 
/*  192 */     return this.UPAGENTCOM;
/*      */   }
/*      */ 
/*      */   public void setUPAGENTCOM(String aUPAGENTCOM) {
/*  196 */     this.UPAGENTCOM = aUPAGENTCOM;
/*      */   }
/*      */ 
/*      */   public String getNAME() {
/*  200 */     if (this.NAME != null) this.NAME.equals("");
/*      */ 
/*  204 */     return this.NAME;
/*      */   }
/*      */ 
/*      */   public void setNAME(String aNAME) {
/*  208 */     this.NAME = aNAME;
/*      */   }
/*      */ 
/*      */   public String getADDRESS() {
/*  212 */     if (this.ADDRESS != null) this.ADDRESS.equals("");
/*      */ 
/*  216 */     return this.ADDRESS;
/*      */   }
/*      */ 
/*      */   public void setADDRESS(String aADDRESS) {
/*  220 */     this.ADDRESS = aADDRESS;
/*      */   }
/*      */ 
/*      */   public String getZIPCODE() {
/*  224 */     if (this.ZIPCODE != null) this.ZIPCODE.equals("");
/*      */ 
/*  228 */     return this.ZIPCODE;
/*      */   }
/*      */ 
/*      */   public void setZIPCODE(String aZIPCODE) {
/*  232 */     this.ZIPCODE = aZIPCODE;
/*      */   }
/*      */ 
/*      */   public String getPHONE() {
/*  236 */     if (this.PHONE != null) this.PHONE.equals("");
/*      */ 
/*  240 */     return this.PHONE;
/*      */   }
/*      */ 
/*      */   public void setPHONE(String aPHONE) {
/*  244 */     this.PHONE = aPHONE;
/*      */   }
/*      */ 
/*      */   public String getFAX() {
/*  248 */     if (this.FAX != null) this.FAX.equals("");
/*      */ 
/*  252 */     return this.FAX;
/*      */   }
/*      */ 
/*      */   public void setFAX(String aFAX) {
/*  256 */     this.FAX = aFAX;
/*      */   }
/*      */ 
/*      */   public String getEMAIL() {
/*  260 */     if (this.EMAIL != null) this.EMAIL.equals("");
/*      */ 
/*  264 */     return this.EMAIL;
/*      */   }
/*      */ 
/*      */   public void setEMAIL(String aEMAIL) {
/*  268 */     this.EMAIL = aEMAIL;
/*      */   }
/*      */ 
/*      */   public String getWEBADDRESS() {
/*  272 */     if (this.WEBADDRESS != null) this.WEBADDRESS.equals("");
/*      */ 
/*  276 */     return this.WEBADDRESS;
/*      */   }
/*      */ 
/*      */   public void setWEBADDRESS(String aWEBADDRESS) {
/*  280 */     this.WEBADDRESS = aWEBADDRESS;
/*      */   }
/*      */ 
/*      */   public String getLINKMAN() {
/*  284 */     if (this.LINKMAN != null) this.LINKMAN.equals("");
/*      */ 
/*  288 */     return this.LINKMAN;
/*      */   }
/*      */ 
/*      */   public void setLINKMAN(String aLINKMAN) {
/*  292 */     this.LINKMAN = aLINKMAN;
/*      */   }
/*      */ 
/*      */   public String getPASSWORD() {
/*  296 */     if (this.PASSWORD != null) this.PASSWORD.equals("");
/*      */ 
/*  300 */     return this.PASSWORD;
/*      */   }
/*      */ 
/*      */   public void setPASSWORD(String aPASSWORD) {
/*  304 */     this.PASSWORD = aPASSWORD;
/*      */   }
/*      */ 
/*      */   public String getCORPORATION() {
/*  308 */     if (this.CORPORATION != null) this.CORPORATION.equals("");
/*      */ 
/*  312 */     return this.CORPORATION;
/*      */   }
/*      */ 
/*      */   public void setCORPORATION(String aCORPORATION) {
/*  316 */     this.CORPORATION = aCORPORATION;
/*      */   }
/*      */ 
/*      */   public String getBANKCODE() {
/*  320 */     if (this.BANKCODE != null) this.BANKCODE.equals("");
/*      */ 
/*  324 */     return this.BANKCODE;
/*      */   }
/*      */ 
/*      */   public void setBANKCODE(String aBANKCODE) {
/*  328 */     this.BANKCODE = aBANKCODE;
/*      */   }
/*      */ 
/*      */   public String getBANKACCNO() {
/*  332 */     if (this.BANKACCNO != null) this.BANKACCNO.equals("");
/*      */ 
/*  336 */     return this.BANKACCNO;
/*      */   }
/*      */ 
/*      */   public void setBANKACCNO(String aBANKACCNO) {
/*  340 */     this.BANKACCNO = aBANKACCNO;
/*      */   }
/*      */ 
/*      */   public String getBUSINESSTYPE() {
/*  344 */     if (this.BUSINESSTYPE != null) this.BUSINESSTYPE.equals("");
/*      */ 
/*  348 */     return this.BUSINESSTYPE;
/*      */   }
/*      */ 
/*      */   public void setBUSINESSTYPE(String aBUSINESSTYPE) {
/*  352 */     this.BUSINESSTYPE = aBUSINESSTYPE;
/*      */   }
/*      */ 
/*      */   public String getGRPNATURE() {
/*  356 */     if (this.GRPNATURE != null) this.GRPNATURE.equals("");
/*      */ 
/*  360 */     return this.GRPNATURE;
/*      */   }
/*      */ 
/*      */   public void setGRPNATURE(String aGRPNATURE) {
/*  364 */     this.GRPNATURE = aGRPNATURE;
/*      */   }
/*      */ 
/*      */   public String getACTYPE() {
/*  368 */     if (this.ACTYPE != null) this.ACTYPE.equals("");
/*      */ 
/*  372 */     return this.ACTYPE;
/*      */   }
/*      */ 
/*      */   public void setACTYPE(String aACTYPE) {
/*  376 */     this.ACTYPE = aACTYPE;
/*      */   }
/*      */ 
/*      */   public String getSELLFLAG() {
/*  380 */     if (this.SELLFLAG != null) this.SELLFLAG.equals("");
/*      */ 
/*  384 */     return this.SELLFLAG;
/*      */   }
/*      */ 
/*      */   public void setSELLFLAG(String aSELLFLAG) {
/*  388 */     this.SELLFLAG = aSELLFLAG;
/*      */   }
/*      */ 
/*      */   public String getOPERATOR() {
/*  392 */     if (this.OPERATOR != null) this.OPERATOR.equals("");
/*      */ 
/*  396 */     return this.OPERATOR;
/*      */   }
/*      */ 
/*      */   public void setOPERATOR(String aOPERATOR) {
/*  400 */     this.OPERATOR = aOPERATOR;
/*      */   }
/*      */ 
/*      */   public String getMAKEDATE() {
/*  404 */     if (this.MAKEDATE != null) this.MAKEDATE.equals("");
/*      */ 
/*  408 */     return this.MAKEDATE;
/*      */   }
/*      */ 
/*      */   public void setMAKEDATE(String aMAKEDATE) {
/*  412 */     this.MAKEDATE = aMAKEDATE;
/*      */   }
/*      */ 
/*      */   public String getMAKETIME() {
/*  416 */     if (this.MAKETIME != null) this.MAKETIME.equals("");
/*      */ 
/*  420 */     return this.MAKETIME;
/*      */   }
/*      */ 
/*      */   public void setMAKETIME(String aMAKETIME) {
/*  424 */     this.MAKETIME = aMAKETIME;
/*      */   }
/*      */ 
/*      */   public String getMODIFYDATE() {
/*  428 */     if (this.MODIFYDATE != null) this.MODIFYDATE.equals("");
/*      */ 
/*  432 */     return this.MODIFYDATE;
/*      */   }
/*      */ 
/*      */   public void setMODIFYDATE(String aMODIFYDATE) {
/*  436 */     this.MODIFYDATE = aMODIFYDATE;
/*      */   }
/*      */ 
/*      */   public String getMODIFYTIME() {
/*  440 */     if (this.MODIFYTIME != null) this.MODIFYTIME.equals("");
/*      */ 
/*  444 */     return this.MODIFYTIME;
/*      */   }
/*      */ 
/*      */   public void setMODIFYTIME(String aMODIFYTIME) {
/*  448 */     this.MODIFYTIME = aMODIFYTIME;
/*      */   }
/*      */ 
/*      */   public String getBANKTYPE() {
/*  452 */     if (this.BANKTYPE != null) this.BANKTYPE.equals("");
/*      */ 
/*  456 */     return this.BANKTYPE;
/*      */   }
/*      */ 
/*      */   public void setBANKTYPE(String aBANKTYPE) {
/*  460 */     this.BANKTYPE = aBANKTYPE;
/*      */   }
/*      */ 
/*      */   public String getCALFLAG() {
/*  464 */     if (this.CALFLAG != null) this.CALFLAG.equals("");
/*      */ 
/*  468 */     return this.CALFLAG;
/*      */   }
/*      */ 
/*      */   public void setCALFLAG(String aCALFLAG) {
/*  472 */     this.CALFLAG = aCALFLAG;
/*      */   }
/*      */ 
/*      */   public String getBUSILICENSECODE() {
/*  476 */     if (this.BUSILICENSECODE != null) this.BUSILICENSECODE.equals("");
/*      */ 
/*  480 */     return this.BUSILICENSECODE;
/*      */   }
/*      */ 
/*      */   public void setBUSILICENSECODE(String aBUSILICENSECODE) {
/*  484 */     this.BUSILICENSECODE = aBUSILICENSECODE;
/*      */   }
/*      */ 
/*      */   public String getINSUREID() {
/*  488 */     if (this.INSUREID != null) this.INSUREID.equals("");
/*      */ 
/*  492 */     return this.INSUREID;
/*      */   }
/*      */ 
/*      */   public void setINSUREID(String aINSUREID) {
/*  496 */     this.INSUREID = aINSUREID;
/*      */   }
/*      */ 
/*      */   public String getINSUREPRINCIPAL() {
/*  500 */     if (this.INSUREPRINCIPAL != null) this.INSUREPRINCIPAL.equals("");
/*      */ 
/*  504 */     return this.INSUREPRINCIPAL;
/*      */   }
/*      */ 
/*      */   public void setINSUREPRINCIPAL(String aINSUREPRINCIPAL) {
/*  508 */     this.INSUREPRINCIPAL = aINSUREPRINCIPAL;
/*      */   }
/*      */ 
/*      */   public String getCHIEFBUSINESS() {
/*  512 */     if (this.CHIEFBUSINESS != null) this.CHIEFBUSINESS.equals("");
/*      */ 
/*  516 */     return this.CHIEFBUSINESS;
/*      */   }
/*      */ 
/*      */   public void setCHIEFBUSINESS(String aCHIEFBUSINESS) {
/*  520 */     this.CHIEFBUSINESS = aCHIEFBUSINESS;
/*      */   }
/*      */ 
/*      */   public String getBUSIADDRESS() {
/*  524 */     if (this.BUSIADDRESS != null) this.BUSIADDRESS.equals("");
/*      */ 
/*  528 */     return this.BUSIADDRESS;
/*      */   }
/*      */ 
/*      */   public void setBUSIADDRESS(String aBUSIADDRESS) {
/*  532 */     this.BUSIADDRESS = aBUSIADDRESS;
/*      */   }
/*      */ 
/*      */   public String getSUBSCRIBEMAN() {
/*  536 */     if (this.SUBSCRIBEMAN != null) this.SUBSCRIBEMAN.equals("");
/*      */ 
/*  540 */     return this.SUBSCRIBEMAN;
/*      */   }
/*      */ 
/*      */   public void setSUBSCRIBEMAN(String aSUBSCRIBEMAN) {
/*  544 */     this.SUBSCRIBEMAN = aSUBSCRIBEMAN;
/*      */   }
/*      */ 
/*      */   public String getSUBSCRIBEMANDUTY() {
/*  548 */     if (this.SUBSCRIBEMANDUTY != null) this.SUBSCRIBEMANDUTY.equals("");
/*      */ 
/*  552 */     return this.SUBSCRIBEMANDUTY;
/*      */   }
/*      */ 
/*      */   public void setSUBSCRIBEMANDUTY(String aSUBSCRIBEMANDUTY) {
/*  556 */     this.SUBSCRIBEMANDUTY = aSUBSCRIBEMANDUTY;
/*      */   }
/*      */ 
/*      */   public String getLICENSENO() {
/*  560 */     if (this.LICENSENO != null) this.LICENSENO.equals("");
/*      */ 
/*  564 */     return this.LICENSENO;
/*      */   }
/*      */ 
/*      */   public void setLICENSENO(String aLICENSENO) {
/*  568 */     this.LICENSENO = aLICENSENO;
/*      */   }
/*      */ 
/*      */   public String getREGIONALISMCODE() {
/*  572 */     if (this.REGIONALISMCODE != null) this.REGIONALISMCODE.equals("");
/*      */ 
/*  576 */     return this.REGIONALISMCODE;
/*      */   }
/*      */ 
/*      */   public void setREGIONALISMCODE(String aREGIONALISMCODE) {
/*  580 */     this.REGIONALISMCODE = aREGIONALISMCODE;
/*      */   }
/*      */ 
/*      */   public String getAPPAGENTCOM() {
/*  584 */     if (this.APPAGENTCOM != null) this.APPAGENTCOM.equals("");
/*      */ 
/*  588 */     return this.APPAGENTCOM;
/*      */   }
/*      */ 
/*      */   public void setAPPAGENTCOM(String aAPPAGENTCOM) {
/*  592 */     this.APPAGENTCOM = aAPPAGENTCOM;
/*      */   }
/*      */ 
/*      */   public String getSTATE() {
/*  596 */     if (this.STATE != null) this.STATE.equals("");
/*      */ 
/*  600 */     return this.STATE;
/*      */   }
/*      */ 
/*      */   public void setSTATE(String aSTATE) {
/*  604 */     this.STATE = aSTATE;
/*      */   }
/*      */ 
/*      */   public String getNOTI() {
/*  608 */     if (this.NOTI != null) this.NOTI.equals("");
/*      */ 
/*  612 */     return this.NOTI;
/*      */   }
/*      */ 
/*      */   public void setNOTI(String aNOTI) {
/*  616 */     this.NOTI = aNOTI;
/*      */   }
/*      */ 
/*      */   public String getBUSINESSCODE() {
/*  620 */     if (this.BUSINESSCODE != null) this.BUSINESSCODE.equals("");
/*      */ 
/*  624 */     return this.BUSINESSCODE;
/*      */   }
/*      */ 
/*      */   public void setBUSINESSCODE(String aBUSINESSCODE) {
/*  628 */     this.BUSINESSCODE = aBUSINESSCODE;
/*      */   }
/*      */ 
/*      */   public String getLICENSESTARTDATE() {
/*  632 */     if (this.LICENSESTARTDATE != null) this.LICENSESTARTDATE.equals("");
/*      */ 
/*  636 */     return this.LICENSESTARTDATE;
/*      */   }
/*      */ 
/*      */   public void setLICENSESTARTDATE(String aLICENSESTARTDATE) {
/*  640 */     this.LICENSESTARTDATE = aLICENSESTARTDATE;
/*      */   }
/*      */ 
/*      */   public String getLICENSEENDDATE() {
/*  644 */     if (this.LICENSEENDDATE != null) this.LICENSEENDDATE.equals("");
/*      */ 
/*  648 */     return this.LICENSEENDDATE;
/*      */   }
/*      */ 
/*      */   public void setLICENSEENDDATE(String aLICENSEENDDATE) {
/*  652 */     this.LICENSEENDDATE = aLICENSEENDDATE;
/*      */   }
/*      */ 
/*      */   public String getCOMTYPE() {
/*  656 */     if (this.COMTYPE != null) this.COMTYPE.equals("");
/*      */ 
/*  660 */     return this.COMTYPE;
/*      */   }
/*      */ 
/*      */   public void setCOMTYPE(String aCOMTYPE) {
/*  664 */     this.COMTYPE = aCOMTYPE;
/*      */   }
/*      */ 
/*      */   public String getETL_DATATIME() {
/*  668 */     if (this.ETL_DATATIME != null) this.ETL_DATATIME.equals("");
/*      */ 
/*  672 */     return this.ETL_DATATIME;
/*      */   }
/*      */ 
/*      */   public void setETL_DATATIME(String aETL_DATATIME) {
/*  676 */     this.ETL_DATATIME = aETL_DATATIME;
/*      */   }
/*      */ 
/*      */   public String getETL_DATATYPE() {
/*  680 */     if (this.ETL_DATATYPE != null) this.ETL_DATATYPE.equals("");
/*      */ 
/*  684 */     return this.ETL_DATATYPE;
/*      */   }
/*      */ 
/*      */   public void setETL_DATATYPE(String aETL_DATATYPE) {
/*  688 */     this.ETL_DATATYPE = aETL_DATATYPE;
/*      */   }
/*      */ 
/*      */   public void setSchema(LAComSchema aLAComSchema)
/*      */   {
/*  694 */     this.AGENTCOM = aLAComSchema.getAGENTCOM();
/*  695 */     this.MANAGECOM = aLAComSchema.getMANAGECOM();
/*  696 */     this.AREATYPE = aLAComSchema.getAREATYPE();
/*  697 */     this.CHANNELTYPE = aLAComSchema.getCHANNELTYPE();
/*  698 */     this.UPAGENTCOM = aLAComSchema.getUPAGENTCOM();
/*  699 */     this.NAME = aLAComSchema.getNAME();
/*  700 */     this.ADDRESS = aLAComSchema.getADDRESS();
/*  701 */     this.ZIPCODE = aLAComSchema.getZIPCODE();
/*  702 */     this.PHONE = aLAComSchema.getPHONE();
/*  703 */     this.FAX = aLAComSchema.getFAX();
/*  704 */     this.EMAIL = aLAComSchema.getEMAIL();
/*  705 */     this.WEBADDRESS = aLAComSchema.getWEBADDRESS();
/*  706 */     this.LINKMAN = aLAComSchema.getLINKMAN();
/*  707 */     this.PASSWORD = aLAComSchema.getPASSWORD();
/*  708 */     this.CORPORATION = aLAComSchema.getCORPORATION();
/*  709 */     this.BANKCODE = aLAComSchema.getBANKCODE();
/*  710 */     this.BANKACCNO = aLAComSchema.getBANKACCNO();
/*  711 */     this.BUSINESSTYPE = aLAComSchema.getBUSINESSTYPE();
/*  712 */     this.GRPNATURE = aLAComSchema.getGRPNATURE();
/*  713 */     this.ACTYPE = aLAComSchema.getACTYPE();
/*  714 */     this.SELLFLAG = aLAComSchema.getSELLFLAG();
/*  715 */     this.OPERATOR = aLAComSchema.getOPERATOR();
/*  716 */     this.MAKEDATE = aLAComSchema.getMAKEDATE();
/*  717 */     this.MAKETIME = aLAComSchema.getMAKETIME();
/*  718 */     this.MODIFYDATE = aLAComSchema.getMODIFYDATE();
/*  719 */     this.MODIFYTIME = aLAComSchema.getMODIFYTIME();
/*  720 */     this.BANKTYPE = aLAComSchema.getBANKTYPE();
/*  721 */     this.CALFLAG = aLAComSchema.getCALFLAG();
/*  722 */     this.BUSILICENSECODE = aLAComSchema.getBUSILICENSECODE();
/*  723 */     this.INSUREID = aLAComSchema.getINSUREID();
/*  724 */     this.INSUREPRINCIPAL = aLAComSchema.getINSUREPRINCIPAL();
/*  725 */     this.CHIEFBUSINESS = aLAComSchema.getCHIEFBUSINESS();
/*  726 */     this.BUSIADDRESS = aLAComSchema.getBUSIADDRESS();
/*  727 */     this.SUBSCRIBEMAN = aLAComSchema.getSUBSCRIBEMAN();
/*  728 */     this.SUBSCRIBEMANDUTY = aLAComSchema.getSUBSCRIBEMANDUTY();
/*  729 */     this.LICENSENO = aLAComSchema.getLICENSENO();
/*  730 */     this.REGIONALISMCODE = aLAComSchema.getREGIONALISMCODE();
/*  731 */     this.APPAGENTCOM = aLAComSchema.getAPPAGENTCOM();
/*  732 */     this.STATE = aLAComSchema.getSTATE();
/*  733 */     this.NOTI = aLAComSchema.getNOTI();
/*  734 */     this.BUSINESSCODE = aLAComSchema.getBUSINESSCODE();
/*  735 */     this.LICENSESTARTDATE = aLAComSchema.getLICENSESTARTDATE();
/*  736 */     this.LICENSEENDDATE = aLAComSchema.getLICENSEENDDATE();
/*  737 */     this.COMTYPE = aLAComSchema.getCOMTYPE();
/*  738 */     this.ETL_DATATIME = aLAComSchema.getETL_DATATIME();
/*  739 */     this.ETL_DATATYPE = aLAComSchema.getETL_DATATYPE();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  748 */       if (rs.getString("AGENTCOM") == null)
/*  749 */         this.AGENTCOM = null;
/*      */       else {
/*  751 */         this.AGENTCOM = rs.getString("AGENTCOM").trim();
/*      */       }
/*  753 */       if (rs.getString("MANAGECOM") == null)
/*  754 */         this.MANAGECOM = null;
/*      */       else {
/*  756 */         this.MANAGECOM = rs.getString("MANAGECOM").trim();
/*      */       }
/*  758 */       if (rs.getString("AREATYPE") == null)
/*  759 */         this.AREATYPE = null;
/*      */       else {
/*  761 */         this.AREATYPE = rs.getString("AREATYPE").trim();
/*      */       }
/*  763 */       if (rs.getString("CHANNELTYPE") == null)
/*  764 */         this.CHANNELTYPE = null;
/*      */       else {
/*  766 */         this.CHANNELTYPE = rs.getString("CHANNELTYPE").trim();
/*      */       }
/*  768 */       if (rs.getString("UPAGENTCOM") == null)
/*  769 */         this.UPAGENTCOM = null;
/*      */       else {
/*  771 */         this.UPAGENTCOM = rs.getString("UPAGENTCOM").trim();
/*      */       }
/*  773 */       if (rs.getString("NAME") == null)
/*  774 */         this.NAME = null;
/*      */       else {
/*  776 */         this.NAME = rs.getString("NAME").trim();
/*      */       }
/*  778 */       if (rs.getString("ADDRESS") == null)
/*  779 */         this.ADDRESS = null;
/*      */       else {
/*  781 */         this.ADDRESS = rs.getString("ADDRESS").trim();
/*      */       }
/*  783 */       if (rs.getString("ZIPCODE") == null)
/*  784 */         this.ZIPCODE = null;
/*      */       else {
/*  786 */         this.ZIPCODE = rs.getString("ZIPCODE").trim();
/*      */       }
/*  788 */       if (rs.getString("PHONE") == null)
/*  789 */         this.PHONE = null;
/*      */       else {
/*  791 */         this.PHONE = rs.getString("PHONE").trim();
/*      */       }
/*  793 */       if (rs.getString("FAX") == null)
/*  794 */         this.FAX = null;
/*      */       else {
/*  796 */         this.FAX = rs.getString("FAX").trim();
/*      */       }
/*  798 */       if (rs.getString("EMAIL") == null)
/*  799 */         this.EMAIL = null;
/*      */       else {
/*  801 */         this.EMAIL = rs.getString("EMAIL").trim();
/*      */       }
/*  803 */       if (rs.getString("WEBADDRESS") == null)
/*  804 */         this.WEBADDRESS = null;
/*      */       else {
/*  806 */         this.WEBADDRESS = rs.getString("WEBADDRESS").trim();
/*      */       }
/*  808 */       if (rs.getString("LINKMAN") == null)
/*  809 */         this.LINKMAN = null;
/*      */       else {
/*  811 */         this.LINKMAN = rs.getString("LINKMAN").trim();
/*      */       }
/*  813 */       if (rs.getString("PASSWORD") == null)
/*  814 */         this.PASSWORD = null;
/*      */       else {
/*  816 */         this.PASSWORD = rs.getString("PASSWORD").trim();
/*      */       }
/*  818 */       if (rs.getString("CORPORATION") == null)
/*  819 */         this.CORPORATION = null;
/*      */       else {
/*  821 */         this.CORPORATION = rs.getString("CORPORATION").trim();
/*      */       }
/*  823 */       if (rs.getString("BANKCODE") == null)
/*  824 */         this.BANKCODE = null;
/*      */       else {
/*  826 */         this.BANKCODE = rs.getString("BANKCODE").trim();
/*      */       }
/*  828 */       if (rs.getString("BANKACCNO") == null)
/*  829 */         this.BANKACCNO = null;
/*      */       else {
/*  831 */         this.BANKACCNO = rs.getString("BANKACCNO").trim();
/*      */       }
/*  833 */       if (rs.getString("BUSINESSTYPE") == null)
/*  834 */         this.BUSINESSTYPE = null;
/*      */       else {
/*  836 */         this.BUSINESSTYPE = rs.getString("BUSINESSTYPE").trim();
/*      */       }
/*  838 */       if (rs.getString("GRPNATURE") == null)
/*  839 */         this.GRPNATURE = null;
/*      */       else {
/*  841 */         this.GRPNATURE = rs.getString("GRPNATURE").trim();
/*      */       }
/*  843 */       if (rs.getString("ACTYPE") == null)
/*  844 */         this.ACTYPE = null;
/*      */       else {
/*  846 */         this.ACTYPE = rs.getString("ACTYPE").trim();
/*      */       }
/*  848 */       if (rs.getString("SELLFLAG") == null)
/*  849 */         this.SELLFLAG = null;
/*      */       else {
/*  851 */         this.SELLFLAG = rs.getString("SELLFLAG").trim();
/*      */       }
/*  853 */       if (rs.getString("OPERATOR") == null)
/*  854 */         this.OPERATOR = null;
/*      */       else {
/*  856 */         this.OPERATOR = rs.getString("OPERATOR").trim();
/*      */       }
/*  858 */       if (rs.getString("MAKEDATE") == null)
/*  859 */         this.MAKEDATE = null;
/*      */       else {
/*  861 */         this.MAKEDATE = rs.getString("MAKEDATE").trim();
/*      */       }
/*  863 */       if (rs.getString("MAKETIME") == null)
/*  864 */         this.MAKETIME = null;
/*      */       else {
/*  866 */         this.MAKETIME = rs.getString("MAKETIME").trim();
/*      */       }
/*  868 */       if (rs.getString("MODIFYDATE") == null)
/*  869 */         this.MODIFYDATE = null;
/*      */       else {
/*  871 */         this.MODIFYDATE = rs.getString("MODIFYDATE").trim();
/*      */       }
/*  873 */       if (rs.getString("MODIFYTIME") == null)
/*  874 */         this.MODIFYTIME = null;
/*      */       else {
/*  876 */         this.MODIFYTIME = rs.getString("MODIFYTIME").trim();
/*      */       }
/*  878 */       if (rs.getString("BANKTYPE") == null)
/*  879 */         this.BANKTYPE = null;
/*      */       else {
/*  881 */         this.BANKTYPE = rs.getString("BANKTYPE").trim();
/*      */       }
/*  883 */       if (rs.getString("CALFLAG") == null)
/*  884 */         this.CALFLAG = null;
/*      */       else {
/*  886 */         this.CALFLAG = rs.getString("CALFLAG").trim();
/*      */       }
/*  888 */       if (rs.getString("BUSILICENSECODE") == null)
/*  889 */         this.BUSILICENSECODE = null;
/*      */       else {
/*  891 */         this.BUSILICENSECODE = rs.getString("BUSILICENSECODE").trim();
/*      */       }
/*  893 */       if (rs.getString("INSUREID") == null)
/*  894 */         this.INSUREID = null;
/*      */       else {
/*  896 */         this.INSUREID = rs.getString("INSUREID").trim();
/*      */       }
/*  898 */       if (rs.getString("INSUREPRINCIPAL") == null)
/*  899 */         this.INSUREPRINCIPAL = null;
/*      */       else {
/*  901 */         this.INSUREPRINCIPAL = rs.getString("INSUREPRINCIPAL").trim();
/*      */       }
/*  903 */       if (rs.getString("CHIEFBUSINESS") == null)
/*  904 */         this.CHIEFBUSINESS = null;
/*      */       else {
/*  906 */         this.CHIEFBUSINESS = rs.getString("CHIEFBUSINESS").trim();
/*      */       }
/*  908 */       if (rs.getString("BUSIADDRESS") == null)
/*  909 */         this.BUSIADDRESS = null;
/*      */       else {
/*  911 */         this.BUSIADDRESS = rs.getString("BUSIADDRESS").trim();
/*      */       }
/*  913 */       if (rs.getString("SUBSCRIBEMAN") == null)
/*  914 */         this.SUBSCRIBEMAN = null;
/*      */       else {
/*  916 */         this.SUBSCRIBEMAN = rs.getString("SUBSCRIBEMAN").trim();
/*      */       }
/*  918 */       if (rs.getString("SUBSCRIBEMANDUTY") == null)
/*  919 */         this.SUBSCRIBEMANDUTY = null;
/*      */       else {
/*  921 */         this.SUBSCRIBEMANDUTY = rs.getString("SUBSCRIBEMANDUTY").trim();
/*      */       }
/*  923 */       if (rs.getString("LICENSENO") == null)
/*  924 */         this.LICENSENO = null;
/*      */       else {
/*  926 */         this.LICENSENO = rs.getString("LICENSENO").trim();
/*      */       }
/*  928 */       if (rs.getString("REGIONALISMCODE") == null)
/*  929 */         this.REGIONALISMCODE = null;
/*      */       else {
/*  931 */         this.REGIONALISMCODE = rs.getString("REGIONALISMCODE").trim();
/*      */       }
/*  933 */       if (rs.getString("APPAGENTCOM") == null)
/*  934 */         this.APPAGENTCOM = null;
/*      */       else {
/*  936 */         this.APPAGENTCOM = rs.getString("APPAGENTCOM").trim();
/*      */       }
/*  938 */       if (rs.getString("STATE") == null)
/*  939 */         this.STATE = null;
/*      */       else {
/*  941 */         this.STATE = rs.getString("STATE").trim();
/*      */       }
/*  943 */       if (rs.getString("NOTI") == null)
/*  944 */         this.NOTI = null;
/*      */       else {
/*  946 */         this.NOTI = rs.getString("NOTI").trim();
/*      */       }
/*  948 */       if (rs.getString("BUSINESSCODE") == null)
/*  949 */         this.BUSINESSCODE = null;
/*      */       else {
/*  951 */         this.BUSINESSCODE = rs.getString("BUSINESSCODE").trim();
/*      */       }
/*  953 */       if (rs.getString("LICENSESTARTDATE") == null)
/*  954 */         this.LICENSESTARTDATE = null;
/*      */       else {
/*  956 */         this.LICENSESTARTDATE = rs.getString("LICENSESTARTDATE").trim();
/*      */       }
/*  958 */       if (rs.getString("LICENSEENDDATE") == null)
/*  959 */         this.LICENSEENDDATE = null;
/*      */       else {
/*  961 */         this.LICENSEENDDATE = rs.getString("LICENSEENDDATE").trim();
/*      */       }
/*  963 */       if (rs.getString("COMTYPE") == null)
/*  964 */         this.COMTYPE = null;
/*      */       else {
/*  966 */         this.COMTYPE = rs.getString("COMTYPE").trim();
/*      */       }
/*  968 */       if (rs.getString("ETL_DATATIME") == null)
/*  969 */         this.ETL_DATATIME = null;
/*      */       else {
/*  971 */         this.ETL_DATATIME = rs.getString("ETL_DATATIME").trim();
/*      */       }
/*  973 */       if (rs.getString("ETL_DATATYPE") == null)
/*  974 */         this.ETL_DATATYPE = null;
/*      */       else {
/*  976 */         this.ETL_DATATYPE = rs.getString("ETL_DATATYPE").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  982 */       CError tError = new CError();
/*  983 */       tError.moduleName = "LAComSchema";
/*  984 */       tError.functionName = "setSchema";
/*  985 */       tError.errorMessage = sqle.toString();
/*  986 */       this.mErrors.addOneError(tError);
/*      */ 
/*  988 */       return false;
/*      */     }
/*  990 */     return true;
/*      */   }
/*      */ 
/*      */   public LAComSchema getSchema()
/*      */   {
/*  995 */     LAComSchema aLAComSchema = new LAComSchema();
/*  996 */     aLAComSchema.setSchema(this);
/*  997 */     return aLAComSchema;
/*      */   }
/*      */ 
/*      */   public LAComDB getDB()
/*      */   {
/* 1002 */     LAComDB aDBOper = new LAComDB();
/* 1003 */     aDBOper.setSchema(this);
/* 1004 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/* 1011 */     String strReturn = "";
/* 1012 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.AGENTCOM)) + "|" + 
/* 1013 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MANAGECOM)) + "|" + 
/* 1014 */       StrTool.cTrim(StrTool.unicodeToGBK(this.AREATYPE)) + "|" + 
/* 1015 */       StrTool.cTrim(StrTool.unicodeToGBK(this.CHANNELTYPE)) + "|" + 
/* 1016 */       StrTool.cTrim(StrTool.unicodeToGBK(this.UPAGENTCOM)) + "|" + 
/* 1017 */       StrTool.cTrim(StrTool.unicodeToGBK(this.NAME)) + "|" + 
/* 1018 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ADDRESS)) + "|" + 
/* 1019 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ZIPCODE)) + "|" + 
/* 1020 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PHONE)) + "|" + 
/* 1021 */       StrTool.cTrim(StrTool.unicodeToGBK(this.FAX)) + "|" + 
/* 1022 */       StrTool.cTrim(StrTool.unicodeToGBK(this.EMAIL)) + "|" + 
/* 1023 */       StrTool.cTrim(StrTool.unicodeToGBK(this.WEBADDRESS)) + "|" + 
/* 1024 */       StrTool.cTrim(StrTool.unicodeToGBK(this.LINKMAN)) + "|" + 
/* 1025 */       StrTool.cTrim(StrTool.unicodeToGBK(this.PASSWORD)) + "|" + 
/* 1026 */       StrTool.cTrim(StrTool.unicodeToGBK(this.CORPORATION)) + "|" + 
/* 1027 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BANKCODE)) + "|" + 
/* 1028 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BANKACCNO)) + "|" + 
/* 1029 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BUSINESSTYPE)) + "|" + 
/* 1030 */       StrTool.cTrim(StrTool.unicodeToGBK(this.GRPNATURE)) + "|" + 
/* 1031 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ACTYPE)) + "|" + 
/* 1032 */       StrTool.cTrim(StrTool.unicodeToGBK(this.SELLFLAG)) + "|" + 
/* 1033 */       StrTool.cTrim(StrTool.unicodeToGBK(this.OPERATOR)) + "|" + 
/* 1034 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MAKEDATE)) + "|" + 
/* 1035 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MAKETIME)) + "|" + 
/* 1036 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MODIFYDATE)) + "|" + 
/* 1037 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MODIFYTIME)) + "|" + 
/* 1038 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BANKTYPE)) + "|" + 
/* 1039 */       StrTool.cTrim(StrTool.unicodeToGBK(this.CALFLAG)) + "|" + 
/* 1040 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BUSILICENSECODE)) + "|" + 
/* 1041 */       StrTool.cTrim(StrTool.unicodeToGBK(this.INSUREID)) + "|" + 
/* 1042 */       StrTool.cTrim(StrTool.unicodeToGBK(this.INSUREPRINCIPAL)) + "|" + 
/* 1043 */       StrTool.cTrim(StrTool.unicodeToGBK(this.CHIEFBUSINESS)) + "|" + 
/* 1044 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BUSIADDRESS)) + "|" + 
/* 1045 */       StrTool.cTrim(StrTool.unicodeToGBK(this.SUBSCRIBEMAN)) + "|" + 
/* 1046 */       StrTool.cTrim(StrTool.unicodeToGBK(this.SUBSCRIBEMANDUTY)) + "|" + 
/* 1047 */       StrTool.cTrim(StrTool.unicodeToGBK(this.LICENSENO)) + "|" + 
/* 1048 */       StrTool.cTrim(StrTool.unicodeToGBK(this.REGIONALISMCODE)) + "|" + 
/* 1049 */       StrTool.cTrim(StrTool.unicodeToGBK(this.APPAGENTCOM)) + "|" + 
/* 1050 */       StrTool.cTrim(StrTool.unicodeToGBK(this.STATE)) + "|" + 
/* 1051 */       StrTool.cTrim(StrTool.unicodeToGBK(this.NOTI)) + "|" + 
/* 1052 */       StrTool.cTrim(StrTool.unicodeToGBK(this.BUSINESSCODE)) + "|" + 
/* 1053 */       StrTool.cTrim(StrTool.unicodeToGBK(this.LICENSESTARTDATE)) + "|" + 
/* 1054 */       StrTool.cTrim(StrTool.unicodeToGBK(this.LICENSEENDDATE)) + "|" + 
/* 1055 */       StrTool.cTrim(StrTool.unicodeToGBK(this.COMTYPE)) + "|" + 
/* 1056 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ETL_DATATIME)) + "|" + 
/* 1057 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ETL_DATATYPE));
/* 1058 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/* 1066 */       this.AGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1067 */       this.MANAGECOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1068 */       this.AREATYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1069 */       this.CHANNELTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1070 */       this.UPAGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1071 */       this.NAME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1072 */       this.ADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1073 */       this.ZIPCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1074 */       this.PHONE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1075 */       this.FAX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1076 */       this.EMAIL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1077 */       this.WEBADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1078 */       this.LINKMAN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1079 */       this.PASSWORD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1080 */       this.CORPORATION = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1081 */       this.BANKCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1082 */       this.BANKACCNO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1083 */       this.BUSINESSTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1084 */       this.GRPNATURE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1085 */       this.ACTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1086 */       this.SELLFLAG = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1087 */       this.OPERATOR = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1088 */       this.MAKEDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1089 */       this.MAKETIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1090 */       this.MODIFYDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1091 */       this.MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1092 */       this.BANKTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1093 */       this.CALFLAG = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1094 */       this.BUSILICENSECODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1095 */       this.INSUREID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1096 */       this.INSUREPRINCIPAL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/* 1097 */       this.CHIEFBUSINESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/* 1098 */       this.BUSIADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/* 1099 */       this.SUBSCRIBEMAN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/* 1100 */       this.SUBSCRIBEMANDUTY = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/* 1101 */       this.LICENSENO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/* 1102 */       this.REGIONALISMCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/* 1103 */       this.APPAGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/* 1104 */       this.STATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/* 1105 */       this.NOTI = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/* 1106 */       this.BUSINESSCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
/* 1107 */       this.LICENSESTARTDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/* 1108 */       this.LICENSEENDDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
/* 1109 */       this.COMTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/* 1110 */       this.ETL_DATATIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
/* 1111 */       this.ETL_DATATYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1116 */       CError tError = new CError();
/* 1117 */       tError.moduleName = "LAComSchema";
/* 1118 */       tError.functionName = "decode";
/* 1119 */       tError.errorMessage = ex.toString();
/* 1120 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1122 */       return false;
/*      */     }
/* 1124 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/* 1130 */     String strReturn = "";
/* 1131 */     if (FCode.equals("AGENTCOM"))
/*      */     {
/* 1133 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AGENTCOM));
/*      */     }
/* 1135 */     if (FCode.equals("MANAGECOM"))
/*      */     {
/* 1137 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MANAGECOM));
/*      */     }
/* 1139 */     if (FCode.equals("AREATYPE"))
/*      */     {
/* 1141 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.AREATYPE));
/*      */     }
/* 1143 */     if (FCode.equals("CHANNELTYPE"))
/*      */     {
/* 1145 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CHANNELTYPE));
/*      */     }
/* 1147 */     if (FCode.equals("UPAGENTCOM"))
/*      */     {
/* 1149 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.UPAGENTCOM));
/*      */     }
/* 1151 */     if (FCode.equals("NAME"))
/*      */     {
/* 1153 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.NAME));
/*      */     }
/* 1155 */     if (FCode.equals("ADDRESS"))
/*      */     {
/* 1157 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ADDRESS));
/*      */     }
/* 1159 */     if (FCode.equals("ZIPCODE"))
/*      */     {
/* 1161 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ZIPCODE));
/*      */     }
/* 1163 */     if (FCode.equals("PHONE"))
/*      */     {
/* 1165 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PHONE));
/*      */     }
/* 1167 */     if (FCode.equals("FAX"))
/*      */     {
/* 1169 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.FAX));
/*      */     }
/* 1171 */     if (FCode.equals("EMAIL"))
/*      */     {
/* 1173 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EMAIL));
/*      */     }
/* 1175 */     if (FCode.equals("WEBADDRESS"))
/*      */     {
/* 1177 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.WEBADDRESS));
/*      */     }
/* 1179 */     if (FCode.equals("LINKMAN"))
/*      */     {
/* 1181 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.LINKMAN));
/*      */     }
/* 1183 */     if (FCode.equals("PASSWORD"))
/*      */     {
/* 1185 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.PASSWORD));
/*      */     }
/* 1187 */     if (FCode.equals("CORPORATION"))
/*      */     {
/* 1189 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CORPORATION));
/*      */     }
/* 1191 */     if (FCode.equals("BANKCODE"))
/*      */     {
/* 1193 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BANKCODE));
/*      */     }
/* 1195 */     if (FCode.equals("BANKACCNO"))
/*      */     {
/* 1197 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BANKACCNO));
/*      */     }
/* 1199 */     if (FCode.equals("BUSINESSTYPE"))
/*      */     {
/* 1201 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BUSINESSTYPE));
/*      */     }
/* 1203 */     if (FCode.equals("GRPNATURE"))
/*      */     {
/* 1205 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.GRPNATURE));
/*      */     }
/* 1207 */     if (FCode.equals("ACTYPE"))
/*      */     {
/* 1209 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ACTYPE));
/*      */     }
/* 1211 */     if (FCode.equals("SELLFLAG"))
/*      */     {
/* 1213 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.SELLFLAG));
/*      */     }
/* 1215 */     if (FCode.equals("OPERATOR"))
/*      */     {
/* 1217 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.OPERATOR));
/*      */     }
/* 1219 */     if (FCode.equals("MAKEDATE"))
/*      */     {
/* 1221 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MAKEDATE));
/*      */     }
/* 1223 */     if (FCode.equals("MAKETIME"))
/*      */     {
/* 1225 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MAKETIME));
/*      */     }
/* 1227 */     if (FCode.equals("MODIFYDATE"))
/*      */     {
/* 1229 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MODIFYDATE));
/*      */     }
/* 1231 */     if (FCode.equals("MODIFYTIME"))
/*      */     {
/* 1233 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MODIFYTIME));
/*      */     }
/* 1235 */     if (FCode.equals("BANKTYPE"))
/*      */     {
/* 1237 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BANKTYPE));
/*      */     }
/* 1239 */     if (FCode.equals("CALFLAG"))
/*      */     {
/* 1241 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CALFLAG));
/*      */     }
/* 1243 */     if (FCode.equals("BUSILICENSECODE"))
/*      */     {
/* 1245 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BUSILICENSECODE));
/*      */     }
/* 1247 */     if (FCode.equals("INSUREID"))
/*      */     {
/* 1249 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.INSUREID));
/*      */     }
/* 1251 */     if (FCode.equals("INSUREPRINCIPAL"))
/*      */     {
/* 1253 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.INSUREPRINCIPAL));
/*      */     }
/* 1255 */     if (FCode.equals("CHIEFBUSINESS"))
/*      */     {
/* 1257 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.CHIEFBUSINESS));
/*      */     }
/* 1259 */     if (FCode.equals("BUSIADDRESS"))
/*      */     {
/* 1261 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BUSIADDRESS));
/*      */     }
/* 1263 */     if (FCode.equals("SUBSCRIBEMAN"))
/*      */     {
/* 1265 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.SUBSCRIBEMAN));
/*      */     }
/* 1267 */     if (FCode.equals("SUBSCRIBEMANDUTY"))
/*      */     {
/* 1269 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.SUBSCRIBEMANDUTY));
/*      */     }
/* 1271 */     if (FCode.equals("LICENSENO"))
/*      */     {
/* 1273 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.LICENSENO));
/*      */     }
/* 1275 */     if (FCode.equals("REGIONALISMCODE"))
/*      */     {
/* 1277 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.REGIONALISMCODE));
/*      */     }
/* 1279 */     if (FCode.equals("APPAGENTCOM"))
/*      */     {
/* 1281 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.APPAGENTCOM));
/*      */     }
/* 1283 */     if (FCode.equals("STATE"))
/*      */     {
/* 1285 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.STATE));
/*      */     }
/* 1287 */     if (FCode.equals("NOTI"))
/*      */     {
/* 1289 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.NOTI));
/*      */     }
/* 1291 */     if (FCode.equals("BUSINESSCODE"))
/*      */     {
/* 1293 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.BUSINESSCODE));
/*      */     }
/* 1295 */     if (FCode.equals("LICENSESTARTDATE"))
/*      */     {
/* 1297 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.LICENSESTARTDATE));
/*      */     }
/* 1299 */     if (FCode.equals("LICENSEENDDATE"))
/*      */     {
/* 1301 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.LICENSEENDDATE));
/*      */     }
/* 1303 */     if (FCode.equals("COMTYPE"))
/*      */     {
/* 1305 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.COMTYPE));
/*      */     }
/* 1307 */     if (FCode.equals("ETL_DATATIME"))
/*      */     {
/* 1309 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ETL_DATATIME));
/*      */     }
/* 1311 */     if (FCode.equals("ETL_DATATYPE"))
/*      */     {
/* 1313 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ETL_DATATYPE));
/*      */     }
/* 1315 */     if (strReturn.equals(""))
/*      */     {
/* 1317 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1320 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1327 */     String strFieldValue = "";
/* 1328 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1330 */       strFieldValue = StrTool.GBKToUnicode(this.AGENTCOM);
/* 1331 */       break;
/*      */     case 1:
/* 1333 */       strFieldValue = StrTool.GBKToUnicode(this.MANAGECOM);
/* 1334 */       break;
/*      */     case 2:
/* 1336 */       strFieldValue = StrTool.GBKToUnicode(this.AREATYPE);
/* 1337 */       break;
/*      */     case 3:
/* 1339 */       strFieldValue = StrTool.GBKToUnicode(this.CHANNELTYPE);
/* 1340 */       break;
/*      */     case 4:
/* 1342 */       strFieldValue = StrTool.GBKToUnicode(this.UPAGENTCOM);
/* 1343 */       break;
/*      */     case 5:
/* 1345 */       strFieldValue = StrTool.GBKToUnicode(this.NAME);
/* 1346 */       break;
/*      */     case 6:
/* 1348 */       strFieldValue = StrTool.GBKToUnicode(this.ADDRESS);
/* 1349 */       break;
/*      */     case 7:
/* 1351 */       strFieldValue = StrTool.GBKToUnicode(this.ZIPCODE);
/* 1352 */       break;
/*      */     case 8:
/* 1354 */       strFieldValue = StrTool.GBKToUnicode(this.PHONE);
/* 1355 */       break;
/*      */     case 9:
/* 1357 */       strFieldValue = StrTool.GBKToUnicode(this.FAX);
/* 1358 */       break;
/*      */     case 10:
/* 1360 */       strFieldValue = StrTool.GBKToUnicode(this.EMAIL);
/* 1361 */       break;
/*      */     case 11:
/* 1363 */       strFieldValue = StrTool.GBKToUnicode(this.WEBADDRESS);
/* 1364 */       break;
/*      */     case 12:
/* 1366 */       strFieldValue = StrTool.GBKToUnicode(this.LINKMAN);
/* 1367 */       break;
/*      */     case 13:
/* 1369 */       strFieldValue = StrTool.GBKToUnicode(this.PASSWORD);
/* 1370 */       break;
/*      */     case 14:
/* 1372 */       strFieldValue = StrTool.GBKToUnicode(this.CORPORATION);
/* 1373 */       break;
/*      */     case 15:
/* 1375 */       strFieldValue = StrTool.GBKToUnicode(this.BANKCODE);
/* 1376 */       break;
/*      */     case 16:
/* 1378 */       strFieldValue = StrTool.GBKToUnicode(this.BANKACCNO);
/* 1379 */       break;
/*      */     case 17:
/* 1381 */       strFieldValue = StrTool.GBKToUnicode(this.BUSINESSTYPE);
/* 1382 */       break;
/*      */     case 18:
/* 1384 */       strFieldValue = StrTool.GBKToUnicode(this.GRPNATURE);
/* 1385 */       break;
/*      */     case 19:
/* 1387 */       strFieldValue = StrTool.GBKToUnicode(this.ACTYPE);
/* 1388 */       break;
/*      */     case 20:
/* 1390 */       strFieldValue = StrTool.GBKToUnicode(this.SELLFLAG);
/* 1391 */       break;
/*      */     case 21:
/* 1393 */       strFieldValue = StrTool.GBKToUnicode(this.OPERATOR);
/* 1394 */       break;
/*      */     case 22:
/* 1396 */       strFieldValue = StrTool.GBKToUnicode(this.MAKEDATE);
/* 1397 */       break;
/*      */     case 23:
/* 1399 */       strFieldValue = StrTool.GBKToUnicode(this.MAKETIME);
/* 1400 */       break;
/*      */     case 24:
/* 1402 */       strFieldValue = StrTool.GBKToUnicode(this.MODIFYDATE);
/* 1403 */       break;
/*      */     case 25:
/* 1405 */       strFieldValue = StrTool.GBKToUnicode(this.MODIFYTIME);
/* 1406 */       break;
/*      */     case 26:
/* 1408 */       strFieldValue = StrTool.GBKToUnicode(this.BANKTYPE);
/* 1409 */       break;
/*      */     case 27:
/* 1411 */       strFieldValue = StrTool.GBKToUnicode(this.CALFLAG);
/* 1412 */       break;
/*      */     case 28:
/* 1414 */       strFieldValue = StrTool.GBKToUnicode(this.BUSILICENSECODE);
/* 1415 */       break;
/*      */     case 29:
/* 1417 */       strFieldValue = StrTool.GBKToUnicode(this.INSUREID);
/* 1418 */       break;
/*      */     case 30:
/* 1420 */       strFieldValue = StrTool.GBKToUnicode(this.INSUREPRINCIPAL);
/* 1421 */       break;
/*      */     case 31:
/* 1423 */       strFieldValue = StrTool.GBKToUnicode(this.CHIEFBUSINESS);
/* 1424 */       break;
/*      */     case 32:
/* 1426 */       strFieldValue = StrTool.GBKToUnicode(this.BUSIADDRESS);
/* 1427 */       break;
/*      */     case 33:
/* 1429 */       strFieldValue = StrTool.GBKToUnicode(this.SUBSCRIBEMAN);
/* 1430 */       break;
/*      */     case 34:
/* 1432 */       strFieldValue = StrTool.GBKToUnicode(this.SUBSCRIBEMANDUTY);
/* 1433 */       break;
/*      */     case 35:
/* 1435 */       strFieldValue = StrTool.GBKToUnicode(this.LICENSENO);
/* 1436 */       break;
/*      */     case 36:
/* 1438 */       strFieldValue = StrTool.GBKToUnicode(this.REGIONALISMCODE);
/* 1439 */       break;
/*      */     case 37:
/* 1441 */       strFieldValue = StrTool.GBKToUnicode(this.APPAGENTCOM);
/* 1442 */       break;
/*      */     case 38:
/* 1444 */       strFieldValue = StrTool.GBKToUnicode(this.STATE);
/* 1445 */       break;
/*      */     case 39:
/* 1447 */       strFieldValue = StrTool.GBKToUnicode(this.NOTI);
/* 1448 */       break;
/*      */     case 40:
/* 1450 */       strFieldValue = StrTool.GBKToUnicode(this.BUSINESSCODE);
/* 1451 */       break;
/*      */     case 41:
/* 1453 */       strFieldValue = StrTool.GBKToUnicode(this.LICENSESTARTDATE);
/* 1454 */       break;
/*      */     case 42:
/* 1456 */       strFieldValue = StrTool.GBKToUnicode(this.LICENSEENDDATE);
/* 1457 */       break;
/*      */     case 43:
/* 1459 */       strFieldValue = StrTool.GBKToUnicode(this.COMTYPE);
/* 1460 */       break;
/*      */     case 44:
/* 1462 */       strFieldValue = StrTool.GBKToUnicode(this.ETL_DATATIME);
/* 1463 */       break;
/*      */     case 45:
/* 1465 */       strFieldValue = StrTool.GBKToUnicode(this.ETL_DATATYPE);
/* 1466 */       break;
/*      */     default:
/* 1468 */       strFieldValue = "";
/*      */     }
/* 1470 */     if (strFieldValue.equals("")) {
/* 1471 */       strFieldValue = "null";
/*      */     }
/* 1473 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1479 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1480 */       return false;
/*      */     }
/* 1482 */     if (FCode.equals("AGENTCOM"))
/*      */     {
/* 1484 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1486 */         this.AGENTCOM = FValue.trim();
/*      */       }
/*      */       else
/* 1489 */         this.AGENTCOM = null;
/*      */     }
/* 1491 */     if (FCode.equals("MANAGECOM"))
/*      */     {
/* 1493 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1495 */         this.MANAGECOM = FValue.trim();
/*      */       }
/*      */       else
/* 1498 */         this.MANAGECOM = null;
/*      */     }
/* 1500 */     if (FCode.equals("AREATYPE"))
/*      */     {
/* 1502 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1504 */         this.AREATYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1507 */         this.AREATYPE = null;
/*      */     }
/* 1509 */     if (FCode.equals("CHANNELTYPE"))
/*      */     {
/* 1511 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1513 */         this.CHANNELTYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1516 */         this.CHANNELTYPE = null;
/*      */     }
/* 1518 */     if (FCode.equals("UPAGENTCOM"))
/*      */     {
/* 1520 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1522 */         this.UPAGENTCOM = FValue.trim();
/*      */       }
/*      */       else
/* 1525 */         this.UPAGENTCOM = null;
/*      */     }
/* 1527 */     if (FCode.equals("NAME"))
/*      */     {
/* 1529 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1531 */         this.NAME = FValue.trim();
/*      */       }
/*      */       else
/* 1534 */         this.NAME = null;
/*      */     }
/* 1536 */     if (FCode.equals("ADDRESS"))
/*      */     {
/* 1538 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1540 */         this.ADDRESS = FValue.trim();
/*      */       }
/*      */       else
/* 1543 */         this.ADDRESS = null;
/*      */     }
/* 1545 */     if (FCode.equals("ZIPCODE"))
/*      */     {
/* 1547 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1549 */         this.ZIPCODE = FValue.trim();
/*      */       }
/*      */       else
/* 1552 */         this.ZIPCODE = null;
/*      */     }
/* 1554 */     if (FCode.equals("PHONE"))
/*      */     {
/* 1556 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1558 */         this.PHONE = FValue.trim();
/*      */       }
/*      */       else
/* 1561 */         this.PHONE = null;
/*      */     }
/* 1563 */     if (FCode.equals("FAX"))
/*      */     {
/* 1565 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1567 */         this.FAX = FValue.trim();
/*      */       }
/*      */       else
/* 1570 */         this.FAX = null;
/*      */     }
/* 1572 */     if (FCode.equals("EMAIL"))
/*      */     {
/* 1574 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1576 */         this.EMAIL = FValue.trim();
/*      */       }
/*      */       else
/* 1579 */         this.EMAIL = null;
/*      */     }
/* 1581 */     if (FCode.equals("WEBADDRESS"))
/*      */     {
/* 1583 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1585 */         this.WEBADDRESS = FValue.trim();
/*      */       }
/*      */       else
/* 1588 */         this.WEBADDRESS = null;
/*      */     }
/* 1590 */     if (FCode.equals("LINKMAN"))
/*      */     {
/* 1592 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1594 */         this.LINKMAN = FValue.trim();
/*      */       }
/*      */       else
/* 1597 */         this.LINKMAN = null;
/*      */     }
/* 1599 */     if (FCode.equals("PASSWORD"))
/*      */     {
/* 1601 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1603 */         this.PASSWORD = FValue.trim();
/*      */       }
/*      */       else
/* 1606 */         this.PASSWORD = null;
/*      */     }
/* 1608 */     if (FCode.equals("CORPORATION"))
/*      */     {
/* 1610 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1612 */         this.CORPORATION = FValue.trim();
/*      */       }
/*      */       else
/* 1615 */         this.CORPORATION = null;
/*      */     }
/* 1617 */     if (FCode.equals("BANKCODE"))
/*      */     {
/* 1619 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1621 */         this.BANKCODE = FValue.trim();
/*      */       }
/*      */       else
/* 1624 */         this.BANKCODE = null;
/*      */     }
/* 1626 */     if (FCode.equals("BANKACCNO"))
/*      */     {
/* 1628 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1630 */         this.BANKACCNO = FValue.trim();
/*      */       }
/*      */       else
/* 1633 */         this.BANKACCNO = null;
/*      */     }
/* 1635 */     if (FCode.equals("BUSINESSTYPE"))
/*      */     {
/* 1637 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1639 */         this.BUSINESSTYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1642 */         this.BUSINESSTYPE = null;
/*      */     }
/* 1644 */     if (FCode.equals("GRPNATURE"))
/*      */     {
/* 1646 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1648 */         this.GRPNATURE = FValue.trim();
/*      */       }
/*      */       else
/* 1651 */         this.GRPNATURE = null;
/*      */     }
/* 1653 */     if (FCode.equals("ACTYPE"))
/*      */     {
/* 1655 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1657 */         this.ACTYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1660 */         this.ACTYPE = null;
/*      */     }
/* 1662 */     if (FCode.equals("SELLFLAG"))
/*      */     {
/* 1664 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1666 */         this.SELLFLAG = FValue.trim();
/*      */       }
/*      */       else
/* 1669 */         this.SELLFLAG = null;
/*      */     }
/* 1671 */     if (FCode.equals("OPERATOR"))
/*      */     {
/* 1673 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1675 */         this.OPERATOR = FValue.trim();
/*      */       }
/*      */       else
/* 1678 */         this.OPERATOR = null;
/*      */     }
/* 1680 */     if (FCode.equals("MAKEDATE"))
/*      */     {
/* 1682 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1684 */         this.MAKEDATE = FValue.trim();
/*      */       }
/*      */       else
/* 1687 */         this.MAKEDATE = null;
/*      */     }
/* 1689 */     if (FCode.equals("MAKETIME"))
/*      */     {
/* 1691 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1693 */         this.MAKETIME = FValue.trim();
/*      */       }
/*      */       else
/* 1696 */         this.MAKETIME = null;
/*      */     }
/* 1698 */     if (FCode.equals("MODIFYDATE"))
/*      */     {
/* 1700 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1702 */         this.MODIFYDATE = FValue.trim();
/*      */       }
/*      */       else
/* 1705 */         this.MODIFYDATE = null;
/*      */     }
/* 1707 */     if (FCode.equals("MODIFYTIME"))
/*      */     {
/* 1709 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1711 */         this.MODIFYTIME = FValue.trim();
/*      */       }
/*      */       else
/* 1714 */         this.MODIFYTIME = null;
/*      */     }
/* 1716 */     if (FCode.equals("BANKTYPE"))
/*      */     {
/* 1718 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1720 */         this.BANKTYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1723 */         this.BANKTYPE = null;
/*      */     }
/* 1725 */     if (FCode.equals("CALFLAG"))
/*      */     {
/* 1727 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1729 */         this.CALFLAG = FValue.trim();
/*      */       }
/*      */       else
/* 1732 */         this.CALFLAG = null;
/*      */     }
/* 1734 */     if (FCode.equals("BUSILICENSECODE"))
/*      */     {
/* 1736 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1738 */         this.BUSILICENSECODE = FValue.trim();
/*      */       }
/*      */       else
/* 1741 */         this.BUSILICENSECODE = null;
/*      */     }
/* 1743 */     if (FCode.equals("INSUREID"))
/*      */     {
/* 1745 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1747 */         this.INSUREID = FValue.trim();
/*      */       }
/*      */       else
/* 1750 */         this.INSUREID = null;
/*      */     }
/* 1752 */     if (FCode.equals("INSUREPRINCIPAL"))
/*      */     {
/* 1754 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1756 */         this.INSUREPRINCIPAL = FValue.trim();
/*      */       }
/*      */       else
/* 1759 */         this.INSUREPRINCIPAL = null;
/*      */     }
/* 1761 */     if (FCode.equals("CHIEFBUSINESS"))
/*      */     {
/* 1763 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1765 */         this.CHIEFBUSINESS = FValue.trim();
/*      */       }
/*      */       else
/* 1768 */         this.CHIEFBUSINESS = null;
/*      */     }
/* 1770 */     if (FCode.equals("BUSIADDRESS"))
/*      */     {
/* 1772 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1774 */         this.BUSIADDRESS = FValue.trim();
/*      */       }
/*      */       else
/* 1777 */         this.BUSIADDRESS = null;
/*      */     }
/* 1779 */     if (FCode.equals("SUBSCRIBEMAN"))
/*      */     {
/* 1781 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1783 */         this.SUBSCRIBEMAN = FValue.trim();
/*      */       }
/*      */       else
/* 1786 */         this.SUBSCRIBEMAN = null;
/*      */     }
/* 1788 */     if (FCode.equals("SUBSCRIBEMANDUTY"))
/*      */     {
/* 1790 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1792 */         this.SUBSCRIBEMANDUTY = FValue.trim();
/*      */       }
/*      */       else
/* 1795 */         this.SUBSCRIBEMANDUTY = null;
/*      */     }
/* 1797 */     if (FCode.equals("LICENSENO"))
/*      */     {
/* 1799 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1801 */         this.LICENSENO = FValue.trim();
/*      */       }
/*      */       else
/* 1804 */         this.LICENSENO = null;
/*      */     }
/* 1806 */     if (FCode.equals("REGIONALISMCODE"))
/*      */     {
/* 1808 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1810 */         this.REGIONALISMCODE = FValue.trim();
/*      */       }
/*      */       else
/* 1813 */         this.REGIONALISMCODE = null;
/*      */     }
/* 1815 */     if (FCode.equals("APPAGENTCOM"))
/*      */     {
/* 1817 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1819 */         this.APPAGENTCOM = FValue.trim();
/*      */       }
/*      */       else
/* 1822 */         this.APPAGENTCOM = null;
/*      */     }
/* 1824 */     if (FCode.equals("STATE"))
/*      */     {
/* 1826 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1828 */         this.STATE = FValue.trim();
/*      */       }
/*      */       else
/* 1831 */         this.STATE = null;
/*      */     }
/* 1833 */     if (FCode.equals("NOTI"))
/*      */     {
/* 1835 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1837 */         this.NOTI = FValue.trim();
/*      */       }
/*      */       else
/* 1840 */         this.NOTI = null;
/*      */     }
/* 1842 */     if (FCode.equals("BUSINESSCODE"))
/*      */     {
/* 1844 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1846 */         this.BUSINESSCODE = FValue.trim();
/*      */       }
/*      */       else
/* 1849 */         this.BUSINESSCODE = null;
/*      */     }
/* 1851 */     if (FCode.equals("LICENSESTARTDATE"))
/*      */     {
/* 1853 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1855 */         this.LICENSESTARTDATE = FValue.trim();
/*      */       }
/*      */       else
/* 1858 */         this.LICENSESTARTDATE = null;
/*      */     }
/* 1860 */     if (FCode.equals("LICENSEENDDATE"))
/*      */     {
/* 1862 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1864 */         this.LICENSEENDDATE = FValue.trim();
/*      */       }
/*      */       else
/* 1867 */         this.LICENSEENDDATE = null;
/*      */     }
/* 1869 */     if (FCode.equals("COMTYPE"))
/*      */     {
/* 1871 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1873 */         this.COMTYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1876 */         this.COMTYPE = null;
/*      */     }
/* 1878 */     if (FCode.equals("ETL_DATATIME"))
/*      */     {
/* 1880 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1882 */         this.ETL_DATATIME = FValue.trim();
/*      */       }
/*      */       else
/* 1885 */         this.ETL_DATATIME = null;
/*      */     }
/* 1887 */     if (FCode.equals("ETL_DATATYPE"))
/*      */     {
/* 1889 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1891 */         this.ETL_DATATYPE = FValue.trim();
/*      */       }
/*      */       else
/* 1894 */         this.ETL_DATATYPE = null;
/*      */     }
/* 1896 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1901 */     if (this == otherObject) return true;
/* 1902 */     if (otherObject == null) return false;
/* 1903 */     if (getClass() != otherObject.getClass()) return false;
/* 1904 */     LAComSchema other = (LAComSchema)otherObject;
/* 1905 */     return 
/* 1906 */       (this.AGENTCOM.equals(other.getAGENTCOM())) && 
/* 1907 */       (this.MANAGECOM.equals(other.getMANAGECOM())) && 
/* 1908 */       (this.AREATYPE.equals(other.getAREATYPE())) && 
/* 1909 */       (this.CHANNELTYPE.equals(other.getCHANNELTYPE())) && 
/* 1910 */       (this.UPAGENTCOM.equals(other.getUPAGENTCOM())) && 
/* 1911 */       (this.NAME.equals(other.getNAME())) && 
/* 1912 */       (this.ADDRESS.equals(other.getADDRESS())) && 
/* 1913 */       (this.ZIPCODE.equals(other.getZIPCODE())) && 
/* 1914 */       (this.PHONE.equals(other.getPHONE())) && 
/* 1915 */       (this.FAX.equals(other.getFAX())) && 
/* 1916 */       (this.EMAIL.equals(other.getEMAIL())) && 
/* 1917 */       (this.WEBADDRESS.equals(other.getWEBADDRESS())) && 
/* 1918 */       (this.LINKMAN.equals(other.getLINKMAN())) && 
/* 1919 */       (this.PASSWORD.equals(other.getPASSWORD())) && 
/* 1920 */       (this.CORPORATION.equals(other.getCORPORATION())) && 
/* 1921 */       (this.BANKCODE.equals(other.getBANKCODE())) && 
/* 1922 */       (this.BANKACCNO.equals(other.getBANKACCNO())) && 
/* 1923 */       (this.BUSINESSTYPE.equals(other.getBUSINESSTYPE())) && 
/* 1924 */       (this.GRPNATURE.equals(other.getGRPNATURE())) && 
/* 1925 */       (this.ACTYPE.equals(other.getACTYPE())) && 
/* 1926 */       (this.SELLFLAG.equals(other.getSELLFLAG())) && 
/* 1927 */       (this.OPERATOR.equals(other.getOPERATOR())) && 
/* 1928 */       (this.MAKEDATE.equals(other.getMAKEDATE())) && 
/* 1929 */       (this.MAKETIME.equals(other.getMAKETIME())) && 
/* 1930 */       (this.MODIFYDATE.equals(other.getMODIFYDATE())) && 
/* 1931 */       (this.MODIFYTIME.equals(other.getMODIFYTIME())) && 
/* 1932 */       (this.BANKTYPE.equals(other.getBANKTYPE())) && 
/* 1933 */       (this.CALFLAG.equals(other.getCALFLAG())) && 
/* 1934 */       (this.BUSILICENSECODE.equals(other.getBUSILICENSECODE())) && 
/* 1935 */       (this.INSUREID.equals(other.getINSUREID())) && 
/* 1936 */       (this.INSUREPRINCIPAL.equals(other.getINSUREPRINCIPAL())) && 
/* 1937 */       (this.CHIEFBUSINESS.equals(other.getCHIEFBUSINESS())) && 
/* 1938 */       (this.BUSIADDRESS.equals(other.getBUSIADDRESS())) && 
/* 1939 */       (this.SUBSCRIBEMAN.equals(other.getSUBSCRIBEMAN())) && 
/* 1940 */       (this.SUBSCRIBEMANDUTY.equals(other.getSUBSCRIBEMANDUTY())) && 
/* 1941 */       (this.LICENSENO.equals(other.getLICENSENO())) && 
/* 1942 */       (this.REGIONALISMCODE.equals(other.getREGIONALISMCODE())) && 
/* 1943 */       (this.APPAGENTCOM.equals(other.getAPPAGENTCOM())) && 
/* 1944 */       (this.STATE.equals(other.getSTATE())) && 
/* 1945 */       (this.NOTI.equals(other.getNOTI())) && 
/* 1946 */       (this.BUSINESSCODE.equals(other.getBUSINESSCODE())) && 
/* 1947 */       (this.LICENSESTARTDATE.equals(other.getLICENSESTARTDATE())) && 
/* 1948 */       (this.LICENSEENDDATE.equals(other.getLICENSEENDDATE())) && 
/* 1949 */       (this.COMTYPE.equals(other.getCOMTYPE())) && 
/* 1950 */       (this.ETL_DATATIME.equals(other.getETL_DATATIME())) && 
/* 1951 */       (this.ETL_DATATYPE.equals(other.getETL_DATATYPE()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1957 */     return 46;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1963 */     if (strFieldName.equals("AGENTCOM")) {
/* 1964 */       return 0;
/*      */     }
/* 1966 */     if (strFieldName.equals("MANAGECOM")) {
/* 1967 */       return 1;
/*      */     }
/* 1969 */     if (strFieldName.equals("AREATYPE")) {
/* 1970 */       return 2;
/*      */     }
/* 1972 */     if (strFieldName.equals("CHANNELTYPE")) {
/* 1973 */       return 3;
/*      */     }
/* 1975 */     if (strFieldName.equals("UPAGENTCOM")) {
/* 1976 */       return 4;
/*      */     }
/* 1978 */     if (strFieldName.equals("NAME")) {
/* 1979 */       return 5;
/*      */     }
/* 1981 */     if (strFieldName.equals("ADDRESS")) {
/* 1982 */       return 6;
/*      */     }
/* 1984 */     if (strFieldName.equals("ZIPCODE")) {
/* 1985 */       return 7;
/*      */     }
/* 1987 */     if (strFieldName.equals("PHONE")) {
/* 1988 */       return 8;
/*      */     }
/* 1990 */     if (strFieldName.equals("FAX")) {
/* 1991 */       return 9;
/*      */     }
/* 1993 */     if (strFieldName.equals("EMAIL")) {
/* 1994 */       return 10;
/*      */     }
/* 1996 */     if (strFieldName.equals("WEBADDRESS")) {
/* 1997 */       return 11;
/*      */     }
/* 1999 */     if (strFieldName.equals("LINKMAN")) {
/* 2000 */       return 12;
/*      */     }
/* 2002 */     if (strFieldName.equals("PASSWORD")) {
/* 2003 */       return 13;
/*      */     }
/* 2005 */     if (strFieldName.equals("CORPORATION")) {
/* 2006 */       return 14;
/*      */     }
/* 2008 */     if (strFieldName.equals("BANKCODE")) {
/* 2009 */       return 15;
/*      */     }
/* 2011 */     if (strFieldName.equals("BANKACCNO")) {
/* 2012 */       return 16;
/*      */     }
/* 2014 */     if (strFieldName.equals("BUSINESSTYPE")) {
/* 2015 */       return 17;
/*      */     }
/* 2017 */     if (strFieldName.equals("GRPNATURE")) {
/* 2018 */       return 18;
/*      */     }
/* 2020 */     if (strFieldName.equals("ACTYPE")) {
/* 2021 */       return 19;
/*      */     }
/* 2023 */     if (strFieldName.equals("SELLFLAG")) {
/* 2024 */       return 20;
/*      */     }
/* 2026 */     if (strFieldName.equals("OPERATOR")) {
/* 2027 */       return 21;
/*      */     }
/* 2029 */     if (strFieldName.equals("MAKEDATE")) {
/* 2030 */       return 22;
/*      */     }
/* 2032 */     if (strFieldName.equals("MAKETIME")) {
/* 2033 */       return 23;
/*      */     }
/* 2035 */     if (strFieldName.equals("MODIFYDATE")) {
/* 2036 */       return 24;
/*      */     }
/* 2038 */     if (strFieldName.equals("MODIFYTIME")) {
/* 2039 */       return 25;
/*      */     }
/* 2041 */     if (strFieldName.equals("BANKTYPE")) {
/* 2042 */       return 26;
/*      */     }
/* 2044 */     if (strFieldName.equals("CALFLAG")) {
/* 2045 */       return 27;
/*      */     }
/* 2047 */     if (strFieldName.equals("BUSILICENSECODE")) {
/* 2048 */       return 28;
/*      */     }
/* 2050 */     if (strFieldName.equals("INSUREID")) {
/* 2051 */       return 29;
/*      */     }
/* 2053 */     if (strFieldName.equals("INSUREPRINCIPAL")) {
/* 2054 */       return 30;
/*      */     }
/* 2056 */     if (strFieldName.equals("CHIEFBUSINESS")) {
/* 2057 */       return 31;
/*      */     }
/* 2059 */     if (strFieldName.equals("BUSIADDRESS")) {
/* 2060 */       return 32;
/*      */     }
/* 2062 */     if (strFieldName.equals("SUBSCRIBEMAN")) {
/* 2063 */       return 33;
/*      */     }
/* 2065 */     if (strFieldName.equals("SUBSCRIBEMANDUTY")) {
/* 2066 */       return 34;
/*      */     }
/* 2068 */     if (strFieldName.equals("LICENSENO")) {
/* 2069 */       return 35;
/*      */     }
/* 2071 */     if (strFieldName.equals("REGIONALISMCODE")) {
/* 2072 */       return 36;
/*      */     }
/* 2074 */     if (strFieldName.equals("APPAGENTCOM")) {
/* 2075 */       return 37;
/*      */     }
/* 2077 */     if (strFieldName.equals("STATE")) {
/* 2078 */       return 38;
/*      */     }
/* 2080 */     if (strFieldName.equals("NOTI")) {
/* 2081 */       return 39;
/*      */     }
/* 2083 */     if (strFieldName.equals("BUSINESSCODE")) {
/* 2084 */       return 40;
/*      */     }
/* 2086 */     if (strFieldName.equals("LICENSESTARTDATE")) {
/* 2087 */       return 41;
/*      */     }
/* 2089 */     if (strFieldName.equals("LICENSEENDDATE")) {
/* 2090 */       return 42;
/*      */     }
/* 2092 */     if (strFieldName.equals("COMTYPE")) {
/* 2093 */       return 43;
/*      */     }
/* 2095 */     if (strFieldName.equals("ETL_DATATIME")) {
/* 2096 */       return 44;
/*      */     }
/* 2098 */     if (strFieldName.equals("ETL_DATATYPE")) {
/* 2099 */       return 45;
/*      */     }
/* 2101 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 2107 */     String strFieldName = "";
/* 2108 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2110 */       strFieldName = "AGENTCOM";
/* 2111 */       break;
/*      */     case 1:
/* 2113 */       strFieldName = "MANAGECOM";
/* 2114 */       break;
/*      */     case 2:
/* 2116 */       strFieldName = "AREATYPE";
/* 2117 */       break;
/*      */     case 3:
/* 2119 */       strFieldName = "CHANNELTYPE";
/* 2120 */       break;
/*      */     case 4:
/* 2122 */       strFieldName = "UPAGENTCOM";
/* 2123 */       break;
/*      */     case 5:
/* 2125 */       strFieldName = "NAME";
/* 2126 */       break;
/*      */     case 6:
/* 2128 */       strFieldName = "ADDRESS";
/* 2129 */       break;
/*      */     case 7:
/* 2131 */       strFieldName = "ZIPCODE";
/* 2132 */       break;
/*      */     case 8:
/* 2134 */       strFieldName = "PHONE";
/* 2135 */       break;
/*      */     case 9:
/* 2137 */       strFieldName = "FAX";
/* 2138 */       break;
/*      */     case 10:
/* 2140 */       strFieldName = "EMAIL";
/* 2141 */       break;
/*      */     case 11:
/* 2143 */       strFieldName = "WEBADDRESS";
/* 2144 */       break;
/*      */     case 12:
/* 2146 */       strFieldName = "LINKMAN";
/* 2147 */       break;
/*      */     case 13:
/* 2149 */       strFieldName = "PASSWORD";
/* 2150 */       break;
/*      */     case 14:
/* 2152 */       strFieldName = "CORPORATION";
/* 2153 */       break;
/*      */     case 15:
/* 2155 */       strFieldName = "BANKCODE";
/* 2156 */       break;
/*      */     case 16:
/* 2158 */       strFieldName = "BANKACCNO";
/* 2159 */       break;
/*      */     case 17:
/* 2161 */       strFieldName = "BUSINESSTYPE";
/* 2162 */       break;
/*      */     case 18:
/* 2164 */       strFieldName = "GRPNATURE";
/* 2165 */       break;
/*      */     case 19:
/* 2167 */       strFieldName = "ACTYPE";
/* 2168 */       break;
/*      */     case 20:
/* 2170 */       strFieldName = "SELLFLAG";
/* 2171 */       break;
/*      */     case 21:
/* 2173 */       strFieldName = "OPERATOR";
/* 2174 */       break;
/*      */     case 22:
/* 2176 */       strFieldName = "MAKEDATE";
/* 2177 */       break;
/*      */     case 23:
/* 2179 */       strFieldName = "MAKETIME";
/* 2180 */       break;
/*      */     case 24:
/* 2182 */       strFieldName = "MODIFYDATE";
/* 2183 */       break;
/*      */     case 25:
/* 2185 */       strFieldName = "MODIFYTIME";
/* 2186 */       break;
/*      */     case 26:
/* 2188 */       strFieldName = "BANKTYPE";
/* 2189 */       break;
/*      */     case 27:
/* 2191 */       strFieldName = "CALFLAG";
/* 2192 */       break;
/*      */     case 28:
/* 2194 */       strFieldName = "BUSILICENSECODE";
/* 2195 */       break;
/*      */     case 29:
/* 2197 */       strFieldName = "INSUREID";
/* 2198 */       break;
/*      */     case 30:
/* 2200 */       strFieldName = "INSUREPRINCIPAL";
/* 2201 */       break;
/*      */     case 31:
/* 2203 */       strFieldName = "CHIEFBUSINESS";
/* 2204 */       break;
/*      */     case 32:
/* 2206 */       strFieldName = "BUSIADDRESS";
/* 2207 */       break;
/*      */     case 33:
/* 2209 */       strFieldName = "SUBSCRIBEMAN";
/* 2210 */       break;
/*      */     case 34:
/* 2212 */       strFieldName = "SUBSCRIBEMANDUTY";
/* 2213 */       break;
/*      */     case 35:
/* 2215 */       strFieldName = "LICENSENO";
/* 2216 */       break;
/*      */     case 36:
/* 2218 */       strFieldName = "REGIONALISMCODE";
/* 2219 */       break;
/*      */     case 37:
/* 2221 */       strFieldName = "APPAGENTCOM";
/* 2222 */       break;
/*      */     case 38:
/* 2224 */       strFieldName = "STATE";
/* 2225 */       break;
/*      */     case 39:
/* 2227 */       strFieldName = "NOTI";
/* 2228 */       break;
/*      */     case 40:
/* 2230 */       strFieldName = "BUSINESSCODE";
/* 2231 */       break;
/*      */     case 41:
/* 2233 */       strFieldName = "LICENSESTARTDATE";
/* 2234 */       break;
/*      */     case 42:
/* 2236 */       strFieldName = "LICENSEENDDATE";
/* 2237 */       break;
/*      */     case 43:
/* 2239 */       strFieldName = "COMTYPE";
/* 2240 */       break;
/*      */     case 44:
/* 2242 */       strFieldName = "ETL_DATATIME";
/* 2243 */       break;
/*      */     case 45:
/* 2245 */       strFieldName = "ETL_DATATYPE";
/* 2246 */       break;
/*      */     default:
/* 2248 */       strFieldName = "";
/*      */     }
/* 2250 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2256 */     if (strFieldName.equals("AGENTCOM")) {
/* 2257 */       return 0;
/*      */     }
/* 2259 */     if (strFieldName.equals("MANAGECOM")) {
/* 2260 */       return 0;
/*      */     }
/* 2262 */     if (strFieldName.equals("AREATYPE")) {
/* 2263 */       return 0;
/*      */     }
/* 2265 */     if (strFieldName.equals("CHANNELTYPE")) {
/* 2266 */       return 0;
/*      */     }
/* 2268 */     if (strFieldName.equals("UPAGENTCOM")) {
/* 2269 */       return 0;
/*      */     }
/* 2271 */     if (strFieldName.equals("NAME")) {
/* 2272 */       return 0;
/*      */     }
/* 2274 */     if (strFieldName.equals("ADDRESS")) {
/* 2275 */       return 0;
/*      */     }
/* 2277 */     if (strFieldName.equals("ZIPCODE")) {
/* 2278 */       return 0;
/*      */     }
/* 2280 */     if (strFieldName.equals("PHONE")) {
/* 2281 */       return 0;
/*      */     }
/* 2283 */     if (strFieldName.equals("FAX")) {
/* 2284 */       return 0;
/*      */     }
/* 2286 */     if (strFieldName.equals("EMAIL")) {
/* 2287 */       return 0;
/*      */     }
/* 2289 */     if (strFieldName.equals("WEBADDRESS")) {
/* 2290 */       return 0;
/*      */     }
/* 2292 */     if (strFieldName.equals("LINKMAN")) {
/* 2293 */       return 0;
/*      */     }
/* 2295 */     if (strFieldName.equals("PASSWORD")) {
/* 2296 */       return 0;
/*      */     }
/* 2298 */     if (strFieldName.equals("CORPORATION")) {
/* 2299 */       return 0;
/*      */     }
/* 2301 */     if (strFieldName.equals("BANKCODE")) {
/* 2302 */       return 0;
/*      */     }
/* 2304 */     if (strFieldName.equals("BANKACCNO")) {
/* 2305 */       return 0;
/*      */     }
/* 2307 */     if (strFieldName.equals("BUSINESSTYPE")) {
/* 2308 */       return 0;
/*      */     }
/* 2310 */     if (strFieldName.equals("GRPNATURE")) {
/* 2311 */       return 0;
/*      */     }
/* 2313 */     if (strFieldName.equals("ACTYPE")) {
/* 2314 */       return 0;
/*      */     }
/* 2316 */     if (strFieldName.equals("SELLFLAG")) {
/* 2317 */       return 0;
/*      */     }
/* 2319 */     if (strFieldName.equals("OPERATOR")) {
/* 2320 */       return 0;
/*      */     }
/* 2322 */     if (strFieldName.equals("MAKEDATE")) {
/* 2323 */       return 0;
/*      */     }
/* 2325 */     if (strFieldName.equals("MAKETIME")) {
/* 2326 */       return 0;
/*      */     }
/* 2328 */     if (strFieldName.equals("MODIFYDATE")) {
/* 2329 */       return 0;
/*      */     }
/* 2331 */     if (strFieldName.equals("MODIFYTIME")) {
/* 2332 */       return 0;
/*      */     }
/* 2334 */     if (strFieldName.equals("BANKTYPE")) {
/* 2335 */       return 0;
/*      */     }
/* 2337 */     if (strFieldName.equals("CALFLAG")) {
/* 2338 */       return 0;
/*      */     }
/* 2340 */     if (strFieldName.equals("BUSILICENSECODE")) {
/* 2341 */       return 0;
/*      */     }
/* 2343 */     if (strFieldName.equals("INSUREID")) {
/* 2344 */       return 0;
/*      */     }
/* 2346 */     if (strFieldName.equals("INSUREPRINCIPAL")) {
/* 2347 */       return 0;
/*      */     }
/* 2349 */     if (strFieldName.equals("CHIEFBUSINESS")) {
/* 2350 */       return 0;
/*      */     }
/* 2352 */     if (strFieldName.equals("BUSIADDRESS")) {
/* 2353 */       return 0;
/*      */     }
/* 2355 */     if (strFieldName.equals("SUBSCRIBEMAN")) {
/* 2356 */       return 0;
/*      */     }
/* 2358 */     if (strFieldName.equals("SUBSCRIBEMANDUTY")) {
/* 2359 */       return 0;
/*      */     }
/* 2361 */     if (strFieldName.equals("LICENSENO")) {
/* 2362 */       return 0;
/*      */     }
/* 2364 */     if (strFieldName.equals("REGIONALISMCODE")) {
/* 2365 */       return 0;
/*      */     }
/* 2367 */     if (strFieldName.equals("APPAGENTCOM")) {
/* 2368 */       return 0;
/*      */     }
/* 2370 */     if (strFieldName.equals("STATE")) {
/* 2371 */       return 0;
/*      */     }
/* 2373 */     if (strFieldName.equals("NOTI")) {
/* 2374 */       return 0;
/*      */     }
/* 2376 */     if (strFieldName.equals("BUSINESSCODE")) {
/* 2377 */       return 0;
/*      */     }
/* 2379 */     if (strFieldName.equals("LICENSESTARTDATE")) {
/* 2380 */       return 0;
/*      */     }
/* 2382 */     if (strFieldName.equals("LICENSEENDDATE")) {
/* 2383 */       return 0;
/*      */     }
/* 2385 */     if (strFieldName.equals("COMTYPE")) {
/* 2386 */       return 0;
/*      */     }
/* 2388 */     if (strFieldName.equals("ETL_DATATIME")) {
/* 2389 */       return 0;
/*      */     }
/* 2391 */     if (strFieldName.equals("ETL_DATATYPE")) {
/* 2392 */       return 0;
/*      */     }
/* 2394 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2400 */     int nFieldType = -1;
/* 2401 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2403 */       nFieldType = 0;
/* 2404 */       break;
/*      */     case 1:
/* 2406 */       nFieldType = 0;
/* 2407 */       break;
/*      */     case 2:
/* 2409 */       nFieldType = 0;
/* 2410 */       break;
/*      */     case 3:
/* 2412 */       nFieldType = 0;
/* 2413 */       break;
/*      */     case 4:
/* 2415 */       nFieldType = 0;
/* 2416 */       break;
/*      */     case 5:
/* 2418 */       nFieldType = 0;
/* 2419 */       break;
/*      */     case 6:
/* 2421 */       nFieldType = 0;
/* 2422 */       break;
/*      */     case 7:
/* 2424 */       nFieldType = 0;
/* 2425 */       break;
/*      */     case 8:
/* 2427 */       nFieldType = 0;
/* 2428 */       break;
/*      */     case 9:
/* 2430 */       nFieldType = 0;
/* 2431 */       break;
/*      */     case 10:
/* 2433 */       nFieldType = 0;
/* 2434 */       break;
/*      */     case 11:
/* 2436 */       nFieldType = 0;
/* 2437 */       break;
/*      */     case 12:
/* 2439 */       nFieldType = 0;
/* 2440 */       break;
/*      */     case 13:
/* 2442 */       nFieldType = 0;
/* 2443 */       break;
/*      */     case 14:
/* 2445 */       nFieldType = 0;
/* 2446 */       break;
/*      */     case 15:
/* 2448 */       nFieldType = 0;
/* 2449 */       break;
/*      */     case 16:
/* 2451 */       nFieldType = 0;
/* 2452 */       break;
/*      */     case 17:
/* 2454 */       nFieldType = 0;
/* 2455 */       break;
/*      */     case 18:
/* 2457 */       nFieldType = 0;
/* 2458 */       break;
/*      */     case 19:
/* 2460 */       nFieldType = 0;
/* 2461 */       break;
/*      */     case 20:
/* 2463 */       nFieldType = 0;
/* 2464 */       break;
/*      */     case 21:
/* 2466 */       nFieldType = 0;
/* 2467 */       break;
/*      */     case 22:
/* 2469 */       nFieldType = 0;
/* 2470 */       break;
/*      */     case 23:
/* 2472 */       nFieldType = 0;
/* 2473 */       break;
/*      */     case 24:
/* 2475 */       nFieldType = 0;
/* 2476 */       break;
/*      */     case 25:
/* 2478 */       nFieldType = 0;
/* 2479 */       break;
/*      */     case 26:
/* 2481 */       nFieldType = 0;
/* 2482 */       break;
/*      */     case 27:
/* 2484 */       nFieldType = 0;
/* 2485 */       break;
/*      */     case 28:
/* 2487 */       nFieldType = 0;
/* 2488 */       break;
/*      */     case 29:
/* 2490 */       nFieldType = 0;
/* 2491 */       break;
/*      */     case 30:
/* 2493 */       nFieldType = 0;
/* 2494 */       break;
/*      */     case 31:
/* 2496 */       nFieldType = 0;
/* 2497 */       break;
/*      */     case 32:
/* 2499 */       nFieldType = 0;
/* 2500 */       break;
/*      */     case 33:
/* 2502 */       nFieldType = 0;
/* 2503 */       break;
/*      */     case 34:
/* 2505 */       nFieldType = 0;
/* 2506 */       break;
/*      */     case 35:
/* 2508 */       nFieldType = 0;
/* 2509 */       break;
/*      */     case 36:
/* 2511 */       nFieldType = 0;
/* 2512 */       break;
/*      */     case 37:
/* 2514 */       nFieldType = 0;
/* 2515 */       break;
/*      */     case 38:
/* 2517 */       nFieldType = 0;
/* 2518 */       break;
/*      */     case 39:
/* 2520 */       nFieldType = 0;
/* 2521 */       break;
/*      */     case 40:
/* 2523 */       nFieldType = 0;
/* 2524 */       break;
/*      */     case 41:
/* 2526 */       nFieldType = 0;
/* 2527 */       break;
/*      */     case 42:
/* 2529 */       nFieldType = 0;
/* 2530 */       break;
/*      */     case 43:
/* 2532 */       nFieldType = 0;
/* 2533 */       break;
/*      */     case 44:
/* 2535 */       nFieldType = 0;
/* 2536 */       break;
/*      */     case 45:
/* 2538 */       nFieldType = 0;
/* 2539 */       break;
/*      */     default:
/* 2541 */       nFieldType = -1;
/*      */     }
/* 2543 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LAComSchema
 * JD-Core Version:    0.6.0
 */