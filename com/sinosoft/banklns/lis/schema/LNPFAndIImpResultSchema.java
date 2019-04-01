/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPFAndIImpResultDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPFAndIImpResultSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String resultId;
/*      */   private String grpContNo;
/*      */   private String contNo;
/*      */   private String proposalContNo;
/*      */   private String impartId;
/*      */   private String grouporder;
/*      */   private String qID01;
/*      */   private String a01;
/*      */   private String qID02;
/*      */   private String a02;
/*      */   private String qID03;
/*      */   private String a03;
/*      */   private String qID04;
/*      */   private String a04;
/*      */   private String qID05;
/*      */   private String a05;
/*      */   private String qID06;
/*      */   private String a06;
/*      */   private String qID07;
/*      */   private String a07;
/*      */   private String qID08;
/*      */   private String a08;
/*      */   private String qID09;
/*      */   private String a09;
/*      */   private String qID10;
/*      */   private String a10;
/*      */   private String qID11;
/*      */   private String a11;
/*      */   private String qID12;
/*      */   private String a12;
/*      */   private String qID13;
/*      */   private String a13;
/*      */   private String qID14;
/*      */   private String a14;
/*      */   private String qID15;
/*      */   private String a15;
/*      */   private String qID16;
/*      */   private String a16;
/*      */   private String operator;
/*      */   private String manageCom;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   public static final int FIELDNUM = 44;
/*      */   private static String[] PK;
/*  115 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPFAndIImpResultSchema()
/*      */   {
/*  122 */     this.mErrors = new CErrors();
/*      */ 
/*  124 */     String[] pk = new String[2];
/*  125 */     pk[0] = "ResultId";
/*  126 */     pk[1] = "Grouporder";
/*      */ 
/*  128 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  135 */     LNPFAndIImpResultSchema cloned = (LNPFAndIImpResultSchema)super.clone();
/*  136 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  137 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  138 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  144 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getResultId()
/*      */   {
/*  149 */     return this.resultId;
/*      */   }
/*      */ 
/*      */   public void setResultId(String aResultId) {
/*  153 */     this.resultId = aResultId;
/*      */   }
/*      */ 
/*      */   public String getGrpContNo() {
/*  157 */     return this.grpContNo;
/*      */   }
/*      */ 
/*      */   public void setGrpContNo(String aGrpContNo) {
/*  161 */     this.grpContNo = aGrpContNo;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  165 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String aContNo) {
/*  169 */     this.contNo = aContNo;
/*      */   }
/*      */ 
/*      */   public String getProposalContNo() {
/*  173 */     return this.proposalContNo;
/*      */   }
/*      */ 
/*      */   public void setProposalContNo(String aProposalContNo) {
/*  177 */     this.proposalContNo = aProposalContNo;
/*      */   }
/*      */ 
/*      */   public String getImpartId() {
/*  181 */     return this.impartId;
/*      */   }
/*      */ 
/*      */   public void setImpartId(String aImpartId) {
/*  185 */     this.impartId = aImpartId;
/*      */   }
/*      */ 
/*      */   public String getGrouporder() {
/*  189 */     return this.grouporder;
/*      */   }
/*      */ 
/*      */   public void setGrouporder(String aGrouporder) {
/*  193 */     this.grouporder = aGrouporder;
/*      */   }
/*      */ 
/*      */   public String getQID01() {
/*  197 */     return this.qID01;
/*      */   }
/*      */ 
/*      */   public void setQID01(String aQID01) {
/*  201 */     this.qID01 = aQID01;
/*      */   }
/*      */ 
/*      */   public String getA01() {
/*  205 */     return this.a01;
/*      */   }
/*      */ 
/*      */   public void setA01(String aA01) {
/*  209 */     this.a01 = aA01;
/*      */   }
/*      */ 
/*      */   public String getQID02() {
/*  213 */     return this.qID02;
/*      */   }
/*      */ 
/*      */   public void setQID02(String aQID02) {
/*  217 */     this.qID02 = aQID02;
/*      */   }
/*      */ 
/*      */   public String getA02() {
/*  221 */     return this.a02;
/*      */   }
/*      */ 
/*      */   public void setA02(String aA02) {
/*  225 */     this.a02 = aA02;
/*      */   }
/*      */ 
/*      */   public String getQID03() {
/*  229 */     return this.qID03;
/*      */   }
/*      */ 
/*      */   public void setQID03(String aQID03) {
/*  233 */     this.qID03 = aQID03;
/*      */   }
/*      */ 
/*      */   public String getA03() {
/*  237 */     return this.a03;
/*      */   }
/*      */ 
/*      */   public void setA03(String aA03) {
/*  241 */     this.a03 = aA03;
/*      */   }
/*      */ 
/*      */   public String getQID04() {
/*  245 */     return this.qID04;
/*      */   }
/*      */ 
/*      */   public void setQID04(String aQID04) {
/*  249 */     this.qID04 = aQID04;
/*      */   }
/*      */ 
/*      */   public String getA04() {
/*  253 */     return this.a04;
/*      */   }
/*      */ 
/*      */   public void setA04(String aA04) {
/*  257 */     this.a04 = aA04;
/*      */   }
/*      */ 
/*      */   public String getQID05() {
/*  261 */     return this.qID05;
/*      */   }
/*      */ 
/*      */   public void setQID05(String aQID05) {
/*  265 */     this.qID05 = aQID05;
/*      */   }
/*      */ 
/*      */   public String getA05() {
/*  269 */     return this.a05;
/*      */   }
/*      */ 
/*      */   public void setA05(String aA05) {
/*  273 */     this.a05 = aA05;
/*      */   }
/*      */ 
/*      */   public String getQID06() {
/*  277 */     return this.qID06;
/*      */   }
/*      */ 
/*      */   public void setQID06(String aQID06) {
/*  281 */     this.qID06 = aQID06;
/*      */   }
/*      */ 
/*      */   public String getA06() {
/*  285 */     return this.a06;
/*      */   }
/*      */ 
/*      */   public void setA06(String aA06) {
/*  289 */     this.a06 = aA06;
/*      */   }
/*      */ 
/*      */   public String getQID07() {
/*  293 */     return this.qID07;
/*      */   }
/*      */ 
/*      */   public void setQID07(String aQID07) {
/*  297 */     this.qID07 = aQID07;
/*      */   }
/*      */ 
/*      */   public String getA07() {
/*  301 */     return this.a07;
/*      */   }
/*      */ 
/*      */   public void setA07(String aA07) {
/*  305 */     this.a07 = aA07;
/*      */   }
/*      */ 
/*      */   public String getQID08() {
/*  309 */     return this.qID08;
/*      */   }
/*      */ 
/*      */   public void setQID08(String aQID08) {
/*  313 */     this.qID08 = aQID08;
/*      */   }
/*      */ 
/*      */   public String getA08() {
/*  317 */     return this.a08;
/*      */   }
/*      */ 
/*      */   public void setA08(String aA08) {
/*  321 */     this.a08 = aA08;
/*      */   }
/*      */ 
/*      */   public String getQID09() {
/*  325 */     return this.qID09;
/*      */   }
/*      */ 
/*      */   public void setQID09(String aQID09) {
/*  329 */     this.qID09 = aQID09;
/*      */   }
/*      */ 
/*      */   public String getA09() {
/*  333 */     return this.a09;
/*      */   }
/*      */ 
/*      */   public void setA09(String aA09) {
/*  337 */     this.a09 = aA09;
/*      */   }
/*      */ 
/*      */   public String getQID10() {
/*  341 */     return this.qID10;
/*      */   }
/*      */ 
/*      */   public void setQID10(String aQID10) {
/*  345 */     this.qID10 = aQID10;
/*      */   }
/*      */ 
/*      */   public String getA10() {
/*  349 */     return this.a10;
/*      */   }
/*      */ 
/*      */   public void setA10(String aA10) {
/*  353 */     this.a10 = aA10;
/*      */   }
/*      */ 
/*      */   public String getQID11() {
/*  357 */     return this.qID11;
/*      */   }
/*      */ 
/*      */   public void setQID11(String aQID11) {
/*  361 */     this.qID11 = aQID11;
/*      */   }
/*      */ 
/*      */   public String getA11() {
/*  365 */     return this.a11;
/*      */   }
/*      */ 
/*      */   public void setA11(String aA11) {
/*  369 */     this.a11 = aA11;
/*      */   }
/*      */ 
/*      */   public String getQID12() {
/*  373 */     return this.qID12;
/*      */   }
/*      */ 
/*      */   public void setQID12(String aQID12) {
/*  377 */     this.qID12 = aQID12;
/*      */   }
/*      */ 
/*      */   public String getA12() {
/*  381 */     return this.a12;
/*      */   }
/*      */ 
/*      */   public void setA12(String aA12) {
/*  385 */     this.a12 = aA12;
/*      */   }
/*      */ 
/*      */   public String getQID13() {
/*  389 */     return this.qID13;
/*      */   }
/*      */ 
/*      */   public void setQID13(String aQID13) {
/*  393 */     this.qID13 = aQID13;
/*      */   }
/*      */ 
/*      */   public String getA13() {
/*  397 */     return this.a13;
/*      */   }
/*      */ 
/*      */   public void setA13(String aA13) {
/*  401 */     this.a13 = aA13;
/*      */   }
/*      */ 
/*      */   public String getQID14() {
/*  405 */     return this.qID14;
/*      */   }
/*      */ 
/*      */   public void setQID14(String aQID14) {
/*  409 */     this.qID14 = aQID14;
/*      */   }
/*      */ 
/*      */   public String getA14() {
/*  413 */     return this.a14;
/*      */   }
/*      */ 
/*      */   public void setA14(String aA14) {
/*  417 */     this.a14 = aA14;
/*      */   }
/*      */ 
/*      */   public String getQID15() {
/*  421 */     return this.qID15;
/*      */   }
/*      */ 
/*      */   public void setQID15(String aQID15) {
/*  425 */     this.qID15 = aQID15;
/*      */   }
/*      */ 
/*      */   public String getA15() {
/*  429 */     return this.a15;
/*      */   }
/*      */ 
/*      */   public void setA15(String aA15) {
/*  433 */     this.a15 = aA15;
/*      */   }
/*      */ 
/*      */   public String getQID16() {
/*  437 */     return this.qID16;
/*      */   }
/*      */ 
/*      */   public void setQID16(String aQID16) {
/*  441 */     this.qID16 = aQID16;
/*      */   }
/*      */ 
/*      */   public String getA16() {
/*  445 */     return this.a16;
/*      */   }
/*      */ 
/*      */   public void setA16(String aA16) {
/*  449 */     this.a16 = aA16;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  453 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  457 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  461 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String aManageCom) {
/*  465 */     this.manageCom = aManageCom;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  469 */     if (this.makeDate != null) {
/*  470 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  472 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  476 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  480 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  482 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  485 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  490 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  494 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  498 */     if (this.modifyDate != null) {
/*  499 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  501 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  505 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  509 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  511 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  514 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  519 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  523 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPFAndIImpResultSchema aLNPFAndIImpResultSchema)
/*      */   {
/*  529 */     this.resultId = aLNPFAndIImpResultSchema.getResultId();
/*  530 */     this.grpContNo = aLNPFAndIImpResultSchema.getGrpContNo();
/*  531 */     this.contNo = aLNPFAndIImpResultSchema.getContNo();
/*  532 */     this.proposalContNo = aLNPFAndIImpResultSchema.getProposalContNo();
/*  533 */     this.impartId = aLNPFAndIImpResultSchema.getImpartId();
/*  534 */     this.grouporder = aLNPFAndIImpResultSchema.getGrouporder();
/*  535 */     this.qID01 = aLNPFAndIImpResultSchema.getQID01();
/*  536 */     this.a01 = aLNPFAndIImpResultSchema.getA01();
/*  537 */     this.qID02 = aLNPFAndIImpResultSchema.getQID02();
/*  538 */     this.a02 = aLNPFAndIImpResultSchema.getA02();
/*  539 */     this.qID03 = aLNPFAndIImpResultSchema.getQID03();
/*  540 */     this.a03 = aLNPFAndIImpResultSchema.getA03();
/*  541 */     this.qID04 = aLNPFAndIImpResultSchema.getQID04();
/*  542 */     this.a04 = aLNPFAndIImpResultSchema.getA04();
/*  543 */     this.qID05 = aLNPFAndIImpResultSchema.getQID05();
/*  544 */     this.a05 = aLNPFAndIImpResultSchema.getA05();
/*  545 */     this.qID06 = aLNPFAndIImpResultSchema.getQID06();
/*  546 */     this.a06 = aLNPFAndIImpResultSchema.getA06();
/*  547 */     this.qID07 = aLNPFAndIImpResultSchema.getQID07();
/*  548 */     this.a07 = aLNPFAndIImpResultSchema.getA07();
/*  549 */     this.qID08 = aLNPFAndIImpResultSchema.getQID08();
/*  550 */     this.a08 = aLNPFAndIImpResultSchema.getA08();
/*  551 */     this.qID09 = aLNPFAndIImpResultSchema.getQID09();
/*  552 */     this.a09 = aLNPFAndIImpResultSchema.getA09();
/*  553 */     this.qID10 = aLNPFAndIImpResultSchema.getQID10();
/*  554 */     this.a10 = aLNPFAndIImpResultSchema.getA10();
/*  555 */     this.qID11 = aLNPFAndIImpResultSchema.getQID11();
/*  556 */     this.a11 = aLNPFAndIImpResultSchema.getA11();
/*  557 */     this.qID12 = aLNPFAndIImpResultSchema.getQID12();
/*  558 */     this.a12 = aLNPFAndIImpResultSchema.getA12();
/*  559 */     this.qID13 = aLNPFAndIImpResultSchema.getQID13();
/*  560 */     this.a13 = aLNPFAndIImpResultSchema.getA13();
/*  561 */     this.qID14 = aLNPFAndIImpResultSchema.getQID14();
/*  562 */     this.a14 = aLNPFAndIImpResultSchema.getA14();
/*  563 */     this.qID15 = aLNPFAndIImpResultSchema.getQID15();
/*  564 */     this.a15 = aLNPFAndIImpResultSchema.getA15();
/*  565 */     this.qID16 = aLNPFAndIImpResultSchema.getQID16();
/*  566 */     this.a16 = aLNPFAndIImpResultSchema.getA16();
/*  567 */     this.operator = aLNPFAndIImpResultSchema.getOperator();
/*  568 */     this.manageCom = aLNPFAndIImpResultSchema.getManageCom();
/*  569 */     this.makeDate = this.fDate.getDate(aLNPFAndIImpResultSchema.getMakeDate());
/*  570 */     this.makeTime = aLNPFAndIImpResultSchema.getMakeTime();
/*  571 */     this.modifyDate = this.fDate.getDate(aLNPFAndIImpResultSchema.getModifyDate());
/*  572 */     this.modifyTime = aLNPFAndIImpResultSchema.getModifyTime();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  581 */       if (rs.getString("ResultId") == null)
/*  582 */         this.resultId = null;
/*      */       else {
/*  584 */         this.resultId = rs.getString("ResultId").trim();
/*      */       }
/*  586 */       if (rs.getString("GrpContNo") == null)
/*  587 */         this.grpContNo = null;
/*      */       else {
/*  589 */         this.grpContNo = rs.getString("GrpContNo").trim();
/*      */       }
/*  591 */       if (rs.getString("ContNo") == null)
/*  592 */         this.contNo = null;
/*      */       else {
/*  594 */         this.contNo = rs.getString("ContNo").trim();
/*      */       }
/*  596 */       if (rs.getString("ProposalContNo") == null)
/*  597 */         this.proposalContNo = null;
/*      */       else {
/*  599 */         this.proposalContNo = rs.getString("ProposalContNo").trim();
/*      */       }
/*  601 */       if (rs.getString("ImpartId") == null)
/*  602 */         this.impartId = null;
/*      */       else {
/*  604 */         this.impartId = rs.getString("ImpartId").trim();
/*      */       }
/*  606 */       if (rs.getString("Grouporder") == null)
/*  607 */         this.grouporder = null;
/*      */       else {
/*  609 */         this.grouporder = rs.getString("Grouporder").trim();
/*      */       }
/*  611 */       if (rs.getString("QID01") == null)
/*  612 */         this.qID01 = null;
/*      */       else {
/*  614 */         this.qID01 = rs.getString("QID01").trim();
/*      */       }
/*  616 */       if (rs.getString("A01") == null)
/*  617 */         this.a01 = null;
/*      */       else {
/*  619 */         this.a01 = rs.getString("A01").trim();
/*      */       }
/*  621 */       if (rs.getString("QID02") == null)
/*  622 */         this.qID02 = null;
/*      */       else {
/*  624 */         this.qID02 = rs.getString("QID02").trim();
/*      */       }
/*  626 */       if (rs.getString("A02") == null)
/*  627 */         this.a02 = null;
/*      */       else {
/*  629 */         this.a02 = rs.getString("A02").trim();
/*      */       }
/*  631 */       if (rs.getString("QID03") == null)
/*  632 */         this.qID03 = null;
/*      */       else {
/*  634 */         this.qID03 = rs.getString("QID03").trim();
/*      */       }
/*  636 */       if (rs.getString("A03") == null)
/*  637 */         this.a03 = null;
/*      */       else {
/*  639 */         this.a03 = rs.getString("A03").trim();
/*      */       }
/*  641 */       if (rs.getString("QID04") == null)
/*  642 */         this.qID04 = null;
/*      */       else {
/*  644 */         this.qID04 = rs.getString("QID04").trim();
/*      */       }
/*  646 */       if (rs.getString("A04") == null)
/*  647 */         this.a04 = null;
/*      */       else {
/*  649 */         this.a04 = rs.getString("A04").trim();
/*      */       }
/*  651 */       if (rs.getString("QID05") == null)
/*  652 */         this.qID05 = null;
/*      */       else {
/*  654 */         this.qID05 = rs.getString("QID05").trim();
/*      */       }
/*  656 */       if (rs.getString("A05") == null)
/*  657 */         this.a05 = null;
/*      */       else {
/*  659 */         this.a05 = rs.getString("A05").trim();
/*      */       }
/*  661 */       if (rs.getString("QID06") == null)
/*  662 */         this.qID06 = null;
/*      */       else {
/*  664 */         this.qID06 = rs.getString("QID06").trim();
/*      */       }
/*  666 */       if (rs.getString("A06") == null)
/*  667 */         this.a06 = null;
/*      */       else {
/*  669 */         this.a06 = rs.getString("A06").trim();
/*      */       }
/*  671 */       if (rs.getString("QID07") == null)
/*  672 */         this.qID07 = null;
/*      */       else {
/*  674 */         this.qID07 = rs.getString("QID07").trim();
/*      */       }
/*  676 */       if (rs.getString("A07") == null)
/*  677 */         this.a07 = null;
/*      */       else {
/*  679 */         this.a07 = rs.getString("A07").trim();
/*      */       }
/*  681 */       if (rs.getString("QID08") == null)
/*  682 */         this.qID08 = null;
/*      */       else {
/*  684 */         this.qID08 = rs.getString("QID08").trim();
/*      */       }
/*  686 */       if (rs.getString("A08") == null)
/*  687 */         this.a08 = null;
/*      */       else {
/*  689 */         this.a08 = rs.getString("A08").trim();
/*      */       }
/*  691 */       if (rs.getString("QID09") == null)
/*  692 */         this.qID09 = null;
/*      */       else {
/*  694 */         this.qID09 = rs.getString("QID09").trim();
/*      */       }
/*  696 */       if (rs.getString("A09") == null)
/*  697 */         this.a09 = null;
/*      */       else {
/*  699 */         this.a09 = rs.getString("A09").trim();
/*      */       }
/*  701 */       if (rs.getString("QID10") == null)
/*  702 */         this.qID10 = null;
/*      */       else {
/*  704 */         this.qID10 = rs.getString("QID10").trim();
/*      */       }
/*  706 */       if (rs.getString("A10") == null)
/*  707 */         this.a10 = null;
/*      */       else {
/*  709 */         this.a10 = rs.getString("A10").trim();
/*      */       }
/*  711 */       if (rs.getString("QID11") == null)
/*  712 */         this.qID11 = null;
/*      */       else {
/*  714 */         this.qID11 = rs.getString("QID11").trim();
/*      */       }
/*  716 */       if (rs.getString("A11") == null)
/*  717 */         this.a11 = null;
/*      */       else {
/*  719 */         this.a11 = rs.getString("A11").trim();
/*      */       }
/*  721 */       if (rs.getString("QID12") == null)
/*  722 */         this.qID12 = null;
/*      */       else {
/*  724 */         this.qID12 = rs.getString("QID12").trim();
/*      */       }
/*  726 */       if (rs.getString("A12") == null)
/*  727 */         this.a12 = null;
/*      */       else {
/*  729 */         this.a12 = rs.getString("A12").trim();
/*      */       }
/*  731 */       if (rs.getString("QID13") == null)
/*  732 */         this.qID13 = null;
/*      */       else {
/*  734 */         this.qID13 = rs.getString("QID13").trim();
/*      */       }
/*  736 */       if (rs.getString("A13") == null)
/*  737 */         this.a13 = null;
/*      */       else {
/*  739 */         this.a13 = rs.getString("A13").trim();
/*      */       }
/*  741 */       if (rs.getString("QID14") == null)
/*  742 */         this.qID14 = null;
/*      */       else {
/*  744 */         this.qID14 = rs.getString("QID14").trim();
/*      */       }
/*  746 */       if (rs.getString("A14") == null)
/*  747 */         this.a14 = null;
/*      */       else {
/*  749 */         this.a14 = rs.getString("A14").trim();
/*      */       }
/*  751 */       if (rs.getString("QID15") == null)
/*  752 */         this.qID15 = null;
/*      */       else {
/*  754 */         this.qID15 = rs.getString("QID15").trim();
/*      */       }
/*  756 */       if (rs.getString("A15") == null)
/*  757 */         this.a15 = null;
/*      */       else {
/*  759 */         this.a15 = rs.getString("A15").trim();
/*      */       }
/*  761 */       if (rs.getString("QID16") == null)
/*  762 */         this.qID16 = null;
/*      */       else {
/*  764 */         this.qID16 = rs.getString("QID16").trim();
/*      */       }
/*  766 */       if (rs.getString("A16") == null)
/*  767 */         this.a16 = null;
/*      */       else {
/*  769 */         this.a16 = rs.getString("A16").trim();
/*      */       }
/*  771 */       if (rs.getString("Operator") == null)
/*  772 */         this.operator = null;
/*      */       else {
/*  774 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  776 */       if (rs.getString("ManageCom") == null)
/*  777 */         this.manageCom = null;
/*      */       else {
/*  779 */         this.manageCom = rs.getString("ManageCom").trim();
/*      */       }
/*  781 */       this.makeDate = rs.getDate("MakeDate");
/*  782 */       if (rs.getString("MakeTime") == null)
/*  783 */         this.makeTime = null;
/*      */       else {
/*  785 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  787 */       this.modifyDate = rs.getDate("ModifyDate");
/*  788 */       if (rs.getString("ModifyTime") == null)
/*  789 */         this.modifyTime = null;
/*      */       else {
/*  791 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  796 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPFAndIImpResult\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*      */ 
/*  798 */       CError tError = new CError();
/*  799 */       tError.moduleName = "LNPFAndIImpResultSchema";
/*  800 */       tError.functionName = "setSchema";
/*  801 */       tError.errorMessage = sqle.toString();
/*  802 */       this.mErrors.addOneError(tError);
/*  803 */       return false;
/*      */     }
/*  805 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultSchema getSchema()
/*      */   {
/*  810 */     LNPFAndIImpResultSchema aLNPFAndIImpResultSchema = new LNPFAndIImpResultSchema();
/*  811 */     aLNPFAndIImpResultSchema.setSchema(this);
/*  812 */     return aLNPFAndIImpResultSchema;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpResultDB getDB()
/*      */   {
/*  817 */     LNPFAndIImpResultDB aDBOper = new LNPFAndIImpResultDB();
/*  818 */     aDBOper.setSchema(this);
/*  819 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  826 */     StringBuffer strReturn = new StringBuffer(256);
/*  827 */     strReturn.append(StrTool.cTrim(this.resultId)); strReturn.append("|");
/*  828 */     strReturn.append(StrTool.cTrim(this.grpContNo)); strReturn.append("|");
/*  829 */     strReturn.append(StrTool.cTrim(this.contNo)); strReturn.append("|");
/*  830 */     strReturn.append(StrTool.cTrim(this.proposalContNo)); strReturn.append("|");
/*  831 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/*  832 */     strReturn.append(StrTool.cTrim(this.grouporder)); strReturn.append("|");
/*  833 */     strReturn.append(StrTool.cTrim(this.qID01)); strReturn.append("|");
/*  834 */     strReturn.append(StrTool.cTrim(this.a01)); strReturn.append("|");
/*  835 */     strReturn.append(StrTool.cTrim(this.qID02)); strReturn.append("|");
/*  836 */     strReturn.append(StrTool.cTrim(this.a02)); strReturn.append("|");
/*  837 */     strReturn.append(StrTool.cTrim(this.qID03)); strReturn.append("|");
/*  838 */     strReturn.append(StrTool.cTrim(this.a03)); strReturn.append("|");
/*  839 */     strReturn.append(StrTool.cTrim(this.qID04)); strReturn.append("|");
/*  840 */     strReturn.append(StrTool.cTrim(this.a04)); strReturn.append("|");
/*  841 */     strReturn.append(StrTool.cTrim(this.qID05)); strReturn.append("|");
/*  842 */     strReturn.append(StrTool.cTrim(this.a05)); strReturn.append("|");
/*  843 */     strReturn.append(StrTool.cTrim(this.qID06)); strReturn.append("|");
/*  844 */     strReturn.append(StrTool.cTrim(this.a06)); strReturn.append("|");
/*  845 */     strReturn.append(StrTool.cTrim(this.qID07)); strReturn.append("|");
/*  846 */     strReturn.append(StrTool.cTrim(this.a07)); strReturn.append("|");
/*  847 */     strReturn.append(StrTool.cTrim(this.qID08)); strReturn.append("|");
/*  848 */     strReturn.append(StrTool.cTrim(this.a08)); strReturn.append("|");
/*  849 */     strReturn.append(StrTool.cTrim(this.qID09)); strReturn.append("|");
/*  850 */     strReturn.append(StrTool.cTrim(this.a09)); strReturn.append("|");
/*  851 */     strReturn.append(StrTool.cTrim(this.qID10)); strReturn.append("|");
/*  852 */     strReturn.append(StrTool.cTrim(this.a10)); strReturn.append("|");
/*  853 */     strReturn.append(StrTool.cTrim(this.qID11)); strReturn.append("|");
/*  854 */     strReturn.append(StrTool.cTrim(this.a11)); strReturn.append("|");
/*  855 */     strReturn.append(StrTool.cTrim(this.qID12)); strReturn.append("|");
/*  856 */     strReturn.append(StrTool.cTrim(this.a12)); strReturn.append("|");
/*  857 */     strReturn.append(StrTool.cTrim(this.qID13)); strReturn.append("|");
/*  858 */     strReturn.append(StrTool.cTrim(this.a13)); strReturn.append("|");
/*  859 */     strReturn.append(StrTool.cTrim(this.qID14)); strReturn.append("|");
/*  860 */     strReturn.append(StrTool.cTrim(this.a14)); strReturn.append("|");
/*  861 */     strReturn.append(StrTool.cTrim(this.qID15)); strReturn.append("|");
/*  862 */     strReturn.append(StrTool.cTrim(this.a15)); strReturn.append("|");
/*  863 */     strReturn.append(StrTool.cTrim(this.qID16)); strReturn.append("|");
/*  864 */     strReturn.append(StrTool.cTrim(this.a16)); strReturn.append("|");
/*  865 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  866 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/*  867 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  868 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  869 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  870 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/*  871 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  879 */       this.resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  880 */       this.grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  881 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  882 */       this.proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  883 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  884 */       this.grouporder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  885 */       this.qID01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  886 */       this.a01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  887 */       this.qID02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  888 */       this.a02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  889 */       this.qID03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  890 */       this.a03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  891 */       this.qID04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  892 */       this.a04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  893 */       this.qID05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  894 */       this.a05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  895 */       this.qID06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  896 */       this.a06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  897 */       this.qID07 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  898 */       this.a07 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  899 */       this.qID08 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  900 */       this.a08 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  901 */       this.qID09 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  902 */       this.a09 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  903 */       this.qID10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  904 */       this.a10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  905 */       this.qID11 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  906 */       this.a11 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  907 */       this.qID12 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/*  908 */       this.a12 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  909 */       this.qID13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  910 */       this.a13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  911 */       this.qID14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/*  912 */       this.a14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*  913 */       this.qID15 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
/*  914 */       this.a15 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
/*  915 */       this.qID16 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
/*  916 */       this.a16 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
/*  917 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
/*  918 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
/*  919 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
/*  920 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
/*  921 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
/*  922 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  927 */       CError tError = new CError();
/*  928 */       tError.moduleName = "LNPFAndIImpResultSchema";
/*  929 */       tError.functionName = "decode";
/*  930 */       tError.errorMessage = ex.toString();
/*  931 */       this.mErrors.addOneError(tError);
/*      */ 
/*  933 */       return false;
/*      */     }
/*  935 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  941 */     String strReturn = "";
/*  942 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/*  944 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.resultId));
/*      */     }
/*  946 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/*  948 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpContNo));
/*      */     }
/*  950 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/*  952 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  954 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/*  956 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.proposalContNo));
/*      */     }
/*  958 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/*  960 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*      */     }
/*  962 */     if (FCode.equalsIgnoreCase("grouporder"))
/*      */     {
/*  964 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grouporder));
/*      */     }
/*  966 */     if (FCode.equalsIgnoreCase("qID01"))
/*      */     {
/*  968 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID01));
/*      */     }
/*  970 */     if (FCode.equalsIgnoreCase("a01"))
/*      */     {
/*  972 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a01));
/*      */     }
/*  974 */     if (FCode.equalsIgnoreCase("qID02"))
/*      */     {
/*  976 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID02));
/*      */     }
/*  978 */     if (FCode.equalsIgnoreCase("a02"))
/*      */     {
/*  980 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a02));
/*      */     }
/*  982 */     if (FCode.equalsIgnoreCase("qID03"))
/*      */     {
/*  984 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID03));
/*      */     }
/*  986 */     if (FCode.equalsIgnoreCase("a03"))
/*      */     {
/*  988 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a03));
/*      */     }
/*  990 */     if (FCode.equalsIgnoreCase("qID04"))
/*      */     {
/*  992 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID04));
/*      */     }
/*  994 */     if (FCode.equalsIgnoreCase("a04"))
/*      */     {
/*  996 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a04));
/*      */     }
/*  998 */     if (FCode.equalsIgnoreCase("qID05"))
/*      */     {
/* 1000 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID05));
/*      */     }
/* 1002 */     if (FCode.equalsIgnoreCase("a05"))
/*      */     {
/* 1004 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a05));
/*      */     }
/* 1006 */     if (FCode.equalsIgnoreCase("qID06"))
/*      */     {
/* 1008 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID06));
/*      */     }
/* 1010 */     if (FCode.equalsIgnoreCase("a06"))
/*      */     {
/* 1012 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a06));
/*      */     }
/* 1014 */     if (FCode.equalsIgnoreCase("qID07"))
/*      */     {
/* 1016 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID07));
/*      */     }
/* 1018 */     if (FCode.equalsIgnoreCase("a07"))
/*      */     {
/* 1020 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a07));
/*      */     }
/* 1022 */     if (FCode.equalsIgnoreCase("qID08"))
/*      */     {
/* 1024 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID08));
/*      */     }
/* 1026 */     if (FCode.equalsIgnoreCase("a08"))
/*      */     {
/* 1028 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a08));
/*      */     }
/* 1030 */     if (FCode.equalsIgnoreCase("qID09"))
/*      */     {
/* 1032 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID09));
/*      */     }
/* 1034 */     if (FCode.equalsIgnoreCase("a09"))
/*      */     {
/* 1036 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a09));
/*      */     }
/* 1038 */     if (FCode.equalsIgnoreCase("qID10"))
/*      */     {
/* 1040 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID10));
/*      */     }
/* 1042 */     if (FCode.equalsIgnoreCase("a10"))
/*      */     {
/* 1044 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a10));
/*      */     }
/* 1046 */     if (FCode.equalsIgnoreCase("qID11"))
/*      */     {
/* 1048 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID11));
/*      */     }
/* 1050 */     if (FCode.equalsIgnoreCase("a11"))
/*      */     {
/* 1052 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a11));
/*      */     }
/* 1054 */     if (FCode.equalsIgnoreCase("qID12"))
/*      */     {
/* 1056 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID12));
/*      */     }
/* 1058 */     if (FCode.equalsIgnoreCase("a12"))
/*      */     {
/* 1060 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a12));
/*      */     }
/* 1062 */     if (FCode.equalsIgnoreCase("qID13"))
/*      */     {
/* 1064 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID13));
/*      */     }
/* 1066 */     if (FCode.equalsIgnoreCase("a13"))
/*      */     {
/* 1068 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a13));
/*      */     }
/* 1070 */     if (FCode.equalsIgnoreCase("qID14"))
/*      */     {
/* 1072 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID14));
/*      */     }
/* 1074 */     if (FCode.equalsIgnoreCase("a14"))
/*      */     {
/* 1076 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a14));
/*      */     }
/* 1078 */     if (FCode.equalsIgnoreCase("qID15"))
/*      */     {
/* 1080 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID15));
/*      */     }
/* 1082 */     if (FCode.equalsIgnoreCase("a15"))
/*      */     {
/* 1084 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a15));
/*      */     }
/* 1086 */     if (FCode.equalsIgnoreCase("qID16"))
/*      */     {
/* 1088 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.qID16));
/*      */     }
/* 1090 */     if (FCode.equalsIgnoreCase("a16"))
/*      */     {
/* 1092 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.a16));
/*      */     }
/* 1094 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1096 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/* 1098 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1100 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*      */     }
/* 1102 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1104 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/* 1106 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1108 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/* 1110 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1112 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/* 1114 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1116 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1118 */     if (strReturn.equals(""))
/*      */     {
/* 1120 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1123 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1130 */     String strFieldValue = "";
/* 1131 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1133 */       strFieldValue = StrTool.GBKToUnicode(this.resultId);
/* 1134 */       break;
/*      */     case 1:
/* 1136 */       strFieldValue = StrTool.GBKToUnicode(this.grpContNo);
/* 1137 */       break;
/*      */     case 2:
/* 1139 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/* 1140 */       break;
/*      */     case 3:
/* 1142 */       strFieldValue = StrTool.GBKToUnicode(this.proposalContNo);
/* 1143 */       break;
/*      */     case 4:
/* 1145 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/* 1146 */       break;
/*      */     case 5:
/* 1148 */       strFieldValue = StrTool.GBKToUnicode(this.grouporder);
/* 1149 */       break;
/*      */     case 6:
/* 1151 */       strFieldValue = StrTool.GBKToUnicode(this.qID01);
/* 1152 */       break;
/*      */     case 7:
/* 1154 */       strFieldValue = StrTool.GBKToUnicode(this.a01);
/* 1155 */       break;
/*      */     case 8:
/* 1157 */       strFieldValue = StrTool.GBKToUnicode(this.qID02);
/* 1158 */       break;
/*      */     case 9:
/* 1160 */       strFieldValue = StrTool.GBKToUnicode(this.a02);
/* 1161 */       break;
/*      */     case 10:
/* 1163 */       strFieldValue = StrTool.GBKToUnicode(this.qID03);
/* 1164 */       break;
/*      */     case 11:
/* 1166 */       strFieldValue = StrTool.GBKToUnicode(this.a03);
/* 1167 */       break;
/*      */     case 12:
/* 1169 */       strFieldValue = StrTool.GBKToUnicode(this.qID04);
/* 1170 */       break;
/*      */     case 13:
/* 1172 */       strFieldValue = StrTool.GBKToUnicode(this.a04);
/* 1173 */       break;
/*      */     case 14:
/* 1175 */       strFieldValue = StrTool.GBKToUnicode(this.qID05);
/* 1176 */       break;
/*      */     case 15:
/* 1178 */       strFieldValue = StrTool.GBKToUnicode(this.a05);
/* 1179 */       break;
/*      */     case 16:
/* 1181 */       strFieldValue = StrTool.GBKToUnicode(this.qID06);
/* 1182 */       break;
/*      */     case 17:
/* 1184 */       strFieldValue = StrTool.GBKToUnicode(this.a06);
/* 1185 */       break;
/*      */     case 18:
/* 1187 */       strFieldValue = StrTool.GBKToUnicode(this.qID07);
/* 1188 */       break;
/*      */     case 19:
/* 1190 */       strFieldValue = StrTool.GBKToUnicode(this.a07);
/* 1191 */       break;
/*      */     case 20:
/* 1193 */       strFieldValue = StrTool.GBKToUnicode(this.qID08);
/* 1194 */       break;
/*      */     case 21:
/* 1196 */       strFieldValue = StrTool.GBKToUnicode(this.a08);
/* 1197 */       break;
/*      */     case 22:
/* 1199 */       strFieldValue = StrTool.GBKToUnicode(this.qID09);
/* 1200 */       break;
/*      */     case 23:
/* 1202 */       strFieldValue = StrTool.GBKToUnicode(this.a09);
/* 1203 */       break;
/*      */     case 24:
/* 1205 */       strFieldValue = StrTool.GBKToUnicode(this.qID10);
/* 1206 */       break;
/*      */     case 25:
/* 1208 */       strFieldValue = StrTool.GBKToUnicode(this.a10);
/* 1209 */       break;
/*      */     case 26:
/* 1211 */       strFieldValue = StrTool.GBKToUnicode(this.qID11);
/* 1212 */       break;
/*      */     case 27:
/* 1214 */       strFieldValue = StrTool.GBKToUnicode(this.a11);
/* 1215 */       break;
/*      */     case 28:
/* 1217 */       strFieldValue = StrTool.GBKToUnicode(this.qID12);
/* 1218 */       break;
/*      */     case 29:
/* 1220 */       strFieldValue = StrTool.GBKToUnicode(this.a12);
/* 1221 */       break;
/*      */     case 30:
/* 1223 */       strFieldValue = StrTool.GBKToUnicode(this.qID13);
/* 1224 */       break;
/*      */     case 31:
/* 1226 */       strFieldValue = StrTool.GBKToUnicode(this.a13);
/* 1227 */       break;
/*      */     case 32:
/* 1229 */       strFieldValue = StrTool.GBKToUnicode(this.qID14);
/* 1230 */       break;
/*      */     case 33:
/* 1232 */       strFieldValue = StrTool.GBKToUnicode(this.a14);
/* 1233 */       break;
/*      */     case 34:
/* 1235 */       strFieldValue = StrTool.GBKToUnicode(this.qID15);
/* 1236 */       break;
/*      */     case 35:
/* 1238 */       strFieldValue = StrTool.GBKToUnicode(this.a15);
/* 1239 */       break;
/*      */     case 36:
/* 1241 */       strFieldValue = StrTool.GBKToUnicode(this.qID16);
/* 1242 */       break;
/*      */     case 37:
/* 1244 */       strFieldValue = StrTool.GBKToUnicode(this.a16);
/* 1245 */       break;
/*      */     case 38:
/* 1247 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1248 */       break;
/*      */     case 39:
/* 1250 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 1251 */       break;
/*      */     case 40:
/* 1253 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 1254 */       break;
/*      */     case 41:
/* 1256 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1257 */       break;
/*      */     case 42:
/* 1259 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 1260 */       break;
/*      */     case 43:
/* 1262 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1263 */       break;
/*      */     default:
/* 1265 */       strFieldValue = "";
/*      */     }
/* 1267 */     if (strFieldValue.equals("")) {
/* 1268 */       strFieldValue = "null";
/*      */     }
/* 1270 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1276 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1277 */       return false;
/*      */     }
/* 1279 */     if (FCode.equalsIgnoreCase("resultId"))
/*      */     {
/* 1281 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1283 */         this.resultId = FValue.trim();
/*      */       }
/*      */       else
/* 1286 */         this.resultId = null;
/*      */     }
/* 1288 */     if (FCode.equalsIgnoreCase("grpContNo"))
/*      */     {
/* 1290 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1292 */         this.grpContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1295 */         this.grpContNo = null;
/*      */     }
/* 1297 */     if (FCode.equalsIgnoreCase("contNo"))
/*      */     {
/* 1299 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1301 */         this.contNo = FValue.trim();
/*      */       }
/*      */       else
/* 1304 */         this.contNo = null;
/*      */     }
/* 1306 */     if (FCode.equalsIgnoreCase("proposalContNo"))
/*      */     {
/* 1308 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1310 */         this.proposalContNo = FValue.trim();
/*      */       }
/*      */       else
/* 1313 */         this.proposalContNo = null;
/*      */     }
/* 1315 */     if (FCode.equalsIgnoreCase("impartId"))
/*      */     {
/* 1317 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1319 */         this.impartId = FValue.trim();
/*      */       }
/*      */       else
/* 1322 */         this.impartId = null;
/*      */     }
/* 1324 */     if (FCode.equalsIgnoreCase("grouporder"))
/*      */     {
/* 1326 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1328 */         this.grouporder = FValue.trim();
/*      */       }
/*      */       else
/* 1331 */         this.grouporder = null;
/*      */     }
/* 1333 */     if (FCode.equalsIgnoreCase("qID01"))
/*      */     {
/* 1335 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1337 */         this.qID01 = FValue.trim();
/*      */       }
/*      */       else
/* 1340 */         this.qID01 = null;
/*      */     }
/* 1342 */     if (FCode.equalsIgnoreCase("a01"))
/*      */     {
/* 1344 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1346 */         this.a01 = FValue.trim();
/*      */       }
/*      */       else
/* 1349 */         this.a01 = null;
/*      */     }
/* 1351 */     if (FCode.equalsIgnoreCase("qID02"))
/*      */     {
/* 1353 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1355 */         this.qID02 = FValue.trim();
/*      */       }
/*      */       else
/* 1358 */         this.qID02 = null;
/*      */     }
/* 1360 */     if (FCode.equalsIgnoreCase("a02"))
/*      */     {
/* 1362 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1364 */         this.a02 = FValue.trim();
/*      */       }
/*      */       else
/* 1367 */         this.a02 = null;
/*      */     }
/* 1369 */     if (FCode.equalsIgnoreCase("qID03"))
/*      */     {
/* 1371 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1373 */         this.qID03 = FValue.trim();
/*      */       }
/*      */       else
/* 1376 */         this.qID03 = null;
/*      */     }
/* 1378 */     if (FCode.equalsIgnoreCase("a03"))
/*      */     {
/* 1380 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1382 */         this.a03 = FValue.trim();
/*      */       }
/*      */       else
/* 1385 */         this.a03 = null;
/*      */     }
/* 1387 */     if (FCode.equalsIgnoreCase("qID04"))
/*      */     {
/* 1389 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1391 */         this.qID04 = FValue.trim();
/*      */       }
/*      */       else
/* 1394 */         this.qID04 = null;
/*      */     }
/* 1396 */     if (FCode.equalsIgnoreCase("a04"))
/*      */     {
/* 1398 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1400 */         this.a04 = FValue.trim();
/*      */       }
/*      */       else
/* 1403 */         this.a04 = null;
/*      */     }
/* 1405 */     if (FCode.equalsIgnoreCase("qID05"))
/*      */     {
/* 1407 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1409 */         this.qID05 = FValue.trim();
/*      */       }
/*      */       else
/* 1412 */         this.qID05 = null;
/*      */     }
/* 1414 */     if (FCode.equalsIgnoreCase("a05"))
/*      */     {
/* 1416 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1418 */         this.a05 = FValue.trim();
/*      */       }
/*      */       else
/* 1421 */         this.a05 = null;
/*      */     }
/* 1423 */     if (FCode.equalsIgnoreCase("qID06"))
/*      */     {
/* 1425 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1427 */         this.qID06 = FValue.trim();
/*      */       }
/*      */       else
/* 1430 */         this.qID06 = null;
/*      */     }
/* 1432 */     if (FCode.equalsIgnoreCase("a06"))
/*      */     {
/* 1434 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1436 */         this.a06 = FValue.trim();
/*      */       }
/*      */       else
/* 1439 */         this.a06 = null;
/*      */     }
/* 1441 */     if (FCode.equalsIgnoreCase("qID07"))
/*      */     {
/* 1443 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1445 */         this.qID07 = FValue.trim();
/*      */       }
/*      */       else
/* 1448 */         this.qID07 = null;
/*      */     }
/* 1450 */     if (FCode.equalsIgnoreCase("a07"))
/*      */     {
/* 1452 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1454 */         this.a07 = FValue.trim();
/*      */       }
/*      */       else
/* 1457 */         this.a07 = null;
/*      */     }
/* 1459 */     if (FCode.equalsIgnoreCase("qID08"))
/*      */     {
/* 1461 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1463 */         this.qID08 = FValue.trim();
/*      */       }
/*      */       else
/* 1466 */         this.qID08 = null;
/*      */     }
/* 1468 */     if (FCode.equalsIgnoreCase("a08"))
/*      */     {
/* 1470 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1472 */         this.a08 = FValue.trim();
/*      */       }
/*      */       else
/* 1475 */         this.a08 = null;
/*      */     }
/* 1477 */     if (FCode.equalsIgnoreCase("qID09"))
/*      */     {
/* 1479 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1481 */         this.qID09 = FValue.trim();
/*      */       }
/*      */       else
/* 1484 */         this.qID09 = null;
/*      */     }
/* 1486 */     if (FCode.equalsIgnoreCase("a09"))
/*      */     {
/* 1488 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1490 */         this.a09 = FValue.trim();
/*      */       }
/*      */       else
/* 1493 */         this.a09 = null;
/*      */     }
/* 1495 */     if (FCode.equalsIgnoreCase("qID10"))
/*      */     {
/* 1497 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1499 */         this.qID10 = FValue.trim();
/*      */       }
/*      */       else
/* 1502 */         this.qID10 = null;
/*      */     }
/* 1504 */     if (FCode.equalsIgnoreCase("a10"))
/*      */     {
/* 1506 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1508 */         this.a10 = FValue.trim();
/*      */       }
/*      */       else
/* 1511 */         this.a10 = null;
/*      */     }
/* 1513 */     if (FCode.equalsIgnoreCase("qID11"))
/*      */     {
/* 1515 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1517 */         this.qID11 = FValue.trim();
/*      */       }
/*      */       else
/* 1520 */         this.qID11 = null;
/*      */     }
/* 1522 */     if (FCode.equalsIgnoreCase("a11"))
/*      */     {
/* 1524 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1526 */         this.a11 = FValue.trim();
/*      */       }
/*      */       else
/* 1529 */         this.a11 = null;
/*      */     }
/* 1531 */     if (FCode.equalsIgnoreCase("qID12"))
/*      */     {
/* 1533 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1535 */         this.qID12 = FValue.trim();
/*      */       }
/*      */       else
/* 1538 */         this.qID12 = null;
/*      */     }
/* 1540 */     if (FCode.equalsIgnoreCase("a12"))
/*      */     {
/* 1542 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1544 */         this.a12 = FValue.trim();
/*      */       }
/*      */       else
/* 1547 */         this.a12 = null;
/*      */     }
/* 1549 */     if (FCode.equalsIgnoreCase("qID13"))
/*      */     {
/* 1551 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1553 */         this.qID13 = FValue.trim();
/*      */       }
/*      */       else
/* 1556 */         this.qID13 = null;
/*      */     }
/* 1558 */     if (FCode.equalsIgnoreCase("a13"))
/*      */     {
/* 1560 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1562 */         this.a13 = FValue.trim();
/*      */       }
/*      */       else
/* 1565 */         this.a13 = null;
/*      */     }
/* 1567 */     if (FCode.equalsIgnoreCase("qID14"))
/*      */     {
/* 1569 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1571 */         this.qID14 = FValue.trim();
/*      */       }
/*      */       else
/* 1574 */         this.qID14 = null;
/*      */     }
/* 1576 */     if (FCode.equalsIgnoreCase("a14"))
/*      */     {
/* 1578 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1580 */         this.a14 = FValue.trim();
/*      */       }
/*      */       else
/* 1583 */         this.a14 = null;
/*      */     }
/* 1585 */     if (FCode.equalsIgnoreCase("qID15"))
/*      */     {
/* 1587 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1589 */         this.qID15 = FValue.trim();
/*      */       }
/*      */       else
/* 1592 */         this.qID15 = null;
/*      */     }
/* 1594 */     if (FCode.equalsIgnoreCase("a15"))
/*      */     {
/* 1596 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1598 */         this.a15 = FValue.trim();
/*      */       }
/*      */       else
/* 1601 */         this.a15 = null;
/*      */     }
/* 1603 */     if (FCode.equalsIgnoreCase("qID16"))
/*      */     {
/* 1605 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1607 */         this.qID16 = FValue.trim();
/*      */       }
/*      */       else
/* 1610 */         this.qID16 = null;
/*      */     }
/* 1612 */     if (FCode.equalsIgnoreCase("a16"))
/*      */     {
/* 1614 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1616 */         this.a16 = FValue.trim();
/*      */       }
/*      */       else
/* 1619 */         this.a16 = null;
/*      */     }
/* 1621 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1623 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1625 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1628 */         this.operator = null;
/*      */     }
/* 1630 */     if (FCode.equalsIgnoreCase("manageCom"))
/*      */     {
/* 1632 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1634 */         this.manageCom = FValue.trim();
/*      */       }
/*      */       else
/* 1637 */         this.manageCom = null;
/*      */     }
/* 1639 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1641 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1643 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1646 */         this.makeDate = null;
/*      */     }
/* 1648 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1650 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1652 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1655 */         this.makeTime = null;
/*      */     }
/* 1657 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1659 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1661 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1664 */         this.modifyDate = null;
/*      */     }
/* 1666 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1668 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1670 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1673 */         this.modifyTime = null;
/*      */     }
/* 1675 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1680 */     if (otherObject == null) return false;
/* 1681 */     if (this == otherObject) return true;
/* 1682 */     if (getClass() != otherObject.getClass()) return false;
/* 1683 */     LNPFAndIImpResultSchema other = (LNPFAndIImpResultSchema)otherObject;
/* 1684 */     if ((this.resultId == null) && (other.getResultId() != null)) return false;
/* 1685 */     if ((this.resultId != null) && (!this.resultId.equals(other.getResultId()))) return false;
/* 1686 */     if ((this.grpContNo == null) && (other.getGrpContNo() != null)) return false;
/* 1687 */     if ((this.grpContNo != null) && (!this.grpContNo.equals(other.getGrpContNo()))) return false;
/* 1688 */     if ((this.contNo == null) && (other.getContNo() != null)) return false;
/* 1689 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo()))) return false;
/* 1690 */     if ((this.proposalContNo == null) && (other.getProposalContNo() != null)) return false;
/* 1691 */     if ((this.proposalContNo != null) && (!this.proposalContNo.equals(other.getProposalContNo()))) return false;
/* 1692 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/* 1693 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/* 1694 */     if ((this.grouporder == null) && (other.getGrouporder() != null)) return false;
/* 1695 */     if ((this.grouporder != null) && (!this.grouporder.equals(other.getGrouporder()))) return false;
/* 1696 */     if ((this.qID01 == null) && (other.getQID01() != null)) return false;
/* 1697 */     if ((this.qID01 != null) && (!this.qID01.equals(other.getQID01()))) return false;
/* 1698 */     if ((this.a01 == null) && (other.getA01() != null)) return false;
/* 1699 */     if ((this.a01 != null) && (!this.a01.equals(other.getA01()))) return false;
/* 1700 */     if ((this.qID02 == null) && (other.getQID02() != null)) return false;
/* 1701 */     if ((this.qID02 != null) && (!this.qID02.equals(other.getQID02()))) return false;
/* 1702 */     if ((this.a02 == null) && (other.getA02() != null)) return false;
/* 1703 */     if ((this.a02 != null) && (!this.a02.equals(other.getA02()))) return false;
/* 1704 */     if ((this.qID03 == null) && (other.getQID03() != null)) return false;
/* 1705 */     if ((this.qID03 != null) && (!this.qID03.equals(other.getQID03()))) return false;
/* 1706 */     if ((this.a03 == null) && (other.getA03() != null)) return false;
/* 1707 */     if ((this.a03 != null) && (!this.a03.equals(other.getA03()))) return false;
/* 1708 */     if ((this.qID04 == null) && (other.getQID04() != null)) return false;
/* 1709 */     if ((this.qID04 != null) && (!this.qID04.equals(other.getQID04()))) return false;
/* 1710 */     if ((this.a04 == null) && (other.getA04() != null)) return false;
/* 1711 */     if ((this.a04 != null) && (!this.a04.equals(other.getA04()))) return false;
/* 1712 */     if ((this.qID05 == null) && (other.getQID05() != null)) return false;
/* 1713 */     if ((this.qID05 != null) && (!this.qID05.equals(other.getQID05()))) return false;
/* 1714 */     if ((this.a05 == null) && (other.getA05() != null)) return false;
/* 1715 */     if ((this.a05 != null) && (!this.a05.equals(other.getA05()))) return false;
/* 1716 */     if ((this.qID06 == null) && (other.getQID06() != null)) return false;
/* 1717 */     if ((this.qID06 != null) && (!this.qID06.equals(other.getQID06()))) return false;
/* 1718 */     if ((this.a06 == null) && (other.getA06() != null)) return false;
/* 1719 */     if ((this.a06 != null) && (!this.a06.equals(other.getA06()))) return false;
/* 1720 */     if ((this.qID07 == null) && (other.getQID07() != null)) return false;
/* 1721 */     if ((this.qID07 != null) && (!this.qID07.equals(other.getQID07()))) return false;
/* 1722 */     if ((this.a07 == null) && (other.getA07() != null)) return false;
/* 1723 */     if ((this.a07 != null) && (!this.a07.equals(other.getA07()))) return false;
/* 1724 */     if ((this.qID08 == null) && (other.getQID08() != null)) return false;
/* 1725 */     if ((this.qID08 != null) && (!this.qID08.equals(other.getQID08()))) return false;
/* 1726 */     if ((this.a08 == null) && (other.getA08() != null)) return false;
/* 1727 */     if ((this.a08 != null) && (!this.a08.equals(other.getA08()))) return false;
/* 1728 */     if ((this.qID09 == null) && (other.getQID09() != null)) return false;
/* 1729 */     if ((this.qID09 != null) && (!this.qID09.equals(other.getQID09()))) return false;
/* 1730 */     if ((this.a09 == null) && (other.getA09() != null)) return false;
/* 1731 */     if ((this.a09 != null) && (!this.a09.equals(other.getA09()))) return false;
/* 1732 */     if ((this.qID10 == null) && (other.getQID10() != null)) return false;
/* 1733 */     if ((this.qID10 != null) && (!this.qID10.equals(other.getQID10()))) return false;
/* 1734 */     if ((this.a10 == null) && (other.getA10() != null)) return false;
/* 1735 */     if ((this.a10 != null) && (!this.a10.equals(other.getA10()))) return false;
/* 1736 */     if ((this.qID11 == null) && (other.getQID11() != null)) return false;
/* 1737 */     if ((this.qID11 != null) && (!this.qID11.equals(other.getQID11()))) return false;
/* 1738 */     if ((this.a11 == null) && (other.getA11() != null)) return false;
/* 1739 */     if ((this.a11 != null) && (!this.a11.equals(other.getA11()))) return false;
/* 1740 */     if ((this.qID12 == null) && (other.getQID12() != null)) return false;
/* 1741 */     if ((this.qID12 != null) && (!this.qID12.equals(other.getQID12()))) return false;
/* 1742 */     if ((this.a12 == null) && (other.getA12() != null)) return false;
/* 1743 */     if ((this.a12 != null) && (!this.a12.equals(other.getA12()))) return false;
/* 1744 */     if ((this.qID13 == null) && (other.getQID13() != null)) return false;
/* 1745 */     if ((this.qID13 != null) && (!this.qID13.equals(other.getQID13()))) return false;
/* 1746 */     if ((this.a13 == null) && (other.getA13() != null)) return false;
/* 1747 */     if ((this.a13 != null) && (!this.a13.equals(other.getA13()))) return false;
/* 1748 */     if ((this.qID14 == null) && (other.getQID14() != null)) return false;
/* 1749 */     if ((this.qID14 != null) && (!this.qID14.equals(other.getQID14()))) return false;
/* 1750 */     if ((this.a14 == null) && (other.getA14() != null)) return false;
/* 1751 */     if ((this.a14 != null) && (!this.a14.equals(other.getA14()))) return false;
/* 1752 */     if ((this.qID15 == null) && (other.getQID15() != null)) return false;
/* 1753 */     if ((this.qID15 != null) && (!this.qID15.equals(other.getQID15()))) return false;
/* 1754 */     if ((this.a15 == null) && (other.getA15() != null)) return false;
/* 1755 */     if ((this.a15 != null) && (!this.a15.equals(other.getA15()))) return false;
/* 1756 */     if ((this.qID16 == null) && (other.getQID16() != null)) return false;
/* 1757 */     if ((this.qID16 != null) && (!this.qID16.equals(other.getQID16()))) return false;
/* 1758 */     if ((this.a16 == null) && (other.getA16() != null)) return false;
/* 1759 */     if ((this.a16 != null) && (!this.a16.equals(other.getA16()))) return false;
/* 1760 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1761 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1762 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 1763 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 1764 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1765 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1766 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1767 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1768 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1769 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1770 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1771 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1778 */     return 44;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1784 */     if (strFieldName.equals("resultId")) {
/* 1785 */       return 0;
/*      */     }
/* 1787 */     if (strFieldName.equals("grpContNo")) {
/* 1788 */       return 1;
/*      */     }
/* 1790 */     if (strFieldName.equals("contNo")) {
/* 1791 */       return 2;
/*      */     }
/* 1793 */     if (strFieldName.equals("proposalContNo")) {
/* 1794 */       return 3;
/*      */     }
/* 1796 */     if (strFieldName.equals("impartId")) {
/* 1797 */       return 4;
/*      */     }
/* 1799 */     if (strFieldName.equals("grouporder")) {
/* 1800 */       return 5;
/*      */     }
/* 1802 */     if (strFieldName.equals("qID01")) {
/* 1803 */       return 6;
/*      */     }
/* 1805 */     if (strFieldName.equals("a01")) {
/* 1806 */       return 7;
/*      */     }
/* 1808 */     if (strFieldName.equals("qID02")) {
/* 1809 */       return 8;
/*      */     }
/* 1811 */     if (strFieldName.equals("a02")) {
/* 1812 */       return 9;
/*      */     }
/* 1814 */     if (strFieldName.equals("qID03")) {
/* 1815 */       return 10;
/*      */     }
/* 1817 */     if (strFieldName.equals("a03")) {
/* 1818 */       return 11;
/*      */     }
/* 1820 */     if (strFieldName.equals("qID04")) {
/* 1821 */       return 12;
/*      */     }
/* 1823 */     if (strFieldName.equals("a04")) {
/* 1824 */       return 13;
/*      */     }
/* 1826 */     if (strFieldName.equals("qID05")) {
/* 1827 */       return 14;
/*      */     }
/* 1829 */     if (strFieldName.equals("a05")) {
/* 1830 */       return 15;
/*      */     }
/* 1832 */     if (strFieldName.equals("qID06")) {
/* 1833 */       return 16;
/*      */     }
/* 1835 */     if (strFieldName.equals("a06")) {
/* 1836 */       return 17;
/*      */     }
/* 1838 */     if (strFieldName.equals("qID07")) {
/* 1839 */       return 18;
/*      */     }
/* 1841 */     if (strFieldName.equals("a07")) {
/* 1842 */       return 19;
/*      */     }
/* 1844 */     if (strFieldName.equals("qID08")) {
/* 1845 */       return 20;
/*      */     }
/* 1847 */     if (strFieldName.equals("a08")) {
/* 1848 */       return 21;
/*      */     }
/* 1850 */     if (strFieldName.equals("qID09")) {
/* 1851 */       return 22;
/*      */     }
/* 1853 */     if (strFieldName.equals("a09")) {
/* 1854 */       return 23;
/*      */     }
/* 1856 */     if (strFieldName.equals("qID10")) {
/* 1857 */       return 24;
/*      */     }
/* 1859 */     if (strFieldName.equals("a10")) {
/* 1860 */       return 25;
/*      */     }
/* 1862 */     if (strFieldName.equals("qID11")) {
/* 1863 */       return 26;
/*      */     }
/* 1865 */     if (strFieldName.equals("a11")) {
/* 1866 */       return 27;
/*      */     }
/* 1868 */     if (strFieldName.equals("qID12")) {
/* 1869 */       return 28;
/*      */     }
/* 1871 */     if (strFieldName.equals("a12")) {
/* 1872 */       return 29;
/*      */     }
/* 1874 */     if (strFieldName.equals("qID13")) {
/* 1875 */       return 30;
/*      */     }
/* 1877 */     if (strFieldName.equals("a13")) {
/* 1878 */       return 31;
/*      */     }
/* 1880 */     if (strFieldName.equals("qID14")) {
/* 1881 */       return 32;
/*      */     }
/* 1883 */     if (strFieldName.equals("a14")) {
/* 1884 */       return 33;
/*      */     }
/* 1886 */     if (strFieldName.equals("qID15")) {
/* 1887 */       return 34;
/*      */     }
/* 1889 */     if (strFieldName.equals("a15")) {
/* 1890 */       return 35;
/*      */     }
/* 1892 */     if (strFieldName.equals("qID16")) {
/* 1893 */       return 36;
/*      */     }
/* 1895 */     if (strFieldName.equals("a16")) {
/* 1896 */       return 37;
/*      */     }
/* 1898 */     if (strFieldName.equals("operator")) {
/* 1899 */       return 38;
/*      */     }
/* 1901 */     if (strFieldName.equals("manageCom")) {
/* 1902 */       return 39;
/*      */     }
/* 1904 */     if (strFieldName.equals("makeDate")) {
/* 1905 */       return 40;
/*      */     }
/* 1907 */     if (strFieldName.equals("makeTime")) {
/* 1908 */       return 41;
/*      */     }
/* 1910 */     if (strFieldName.equals("modifyDate")) {
/* 1911 */       return 42;
/*      */     }
/* 1913 */     if (strFieldName.equals("modifyTime")) {
/* 1914 */       return 43;
/*      */     }
/* 1916 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1922 */     String strFieldName = "";
/* 1923 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1925 */       strFieldName = "resultId";
/* 1926 */       break;
/*      */     case 1:
/* 1928 */       strFieldName = "grpContNo";
/* 1929 */       break;
/*      */     case 2:
/* 1931 */       strFieldName = "contNo";
/* 1932 */       break;
/*      */     case 3:
/* 1934 */       strFieldName = "proposalContNo";
/* 1935 */       break;
/*      */     case 4:
/* 1937 */       strFieldName = "impartId";
/* 1938 */       break;
/*      */     case 5:
/* 1940 */       strFieldName = "grouporder";
/* 1941 */       break;
/*      */     case 6:
/* 1943 */       strFieldName = "qID01";
/* 1944 */       break;
/*      */     case 7:
/* 1946 */       strFieldName = "a01";
/* 1947 */       break;
/*      */     case 8:
/* 1949 */       strFieldName = "qID02";
/* 1950 */       break;
/*      */     case 9:
/* 1952 */       strFieldName = "a02";
/* 1953 */       break;
/*      */     case 10:
/* 1955 */       strFieldName = "qID03";
/* 1956 */       break;
/*      */     case 11:
/* 1958 */       strFieldName = "a03";
/* 1959 */       break;
/*      */     case 12:
/* 1961 */       strFieldName = "qID04";
/* 1962 */       break;
/*      */     case 13:
/* 1964 */       strFieldName = "a04";
/* 1965 */       break;
/*      */     case 14:
/* 1967 */       strFieldName = "qID05";
/* 1968 */       break;
/*      */     case 15:
/* 1970 */       strFieldName = "a05";
/* 1971 */       break;
/*      */     case 16:
/* 1973 */       strFieldName = "qID06";
/* 1974 */       break;
/*      */     case 17:
/* 1976 */       strFieldName = "a06";
/* 1977 */       break;
/*      */     case 18:
/* 1979 */       strFieldName = "qID07";
/* 1980 */       break;
/*      */     case 19:
/* 1982 */       strFieldName = "a07";
/* 1983 */       break;
/*      */     case 20:
/* 1985 */       strFieldName = "qID08";
/* 1986 */       break;
/*      */     case 21:
/* 1988 */       strFieldName = "a08";
/* 1989 */       break;
/*      */     case 22:
/* 1991 */       strFieldName = "qID09";
/* 1992 */       break;
/*      */     case 23:
/* 1994 */       strFieldName = "a09";
/* 1995 */       break;
/*      */     case 24:
/* 1997 */       strFieldName = "qID10";
/* 1998 */       break;
/*      */     case 25:
/* 2000 */       strFieldName = "a10";
/* 2001 */       break;
/*      */     case 26:
/* 2003 */       strFieldName = "qID11";
/* 2004 */       break;
/*      */     case 27:
/* 2006 */       strFieldName = "a11";
/* 2007 */       break;
/*      */     case 28:
/* 2009 */       strFieldName = "qID12";
/* 2010 */       break;
/*      */     case 29:
/* 2012 */       strFieldName = "a12";
/* 2013 */       break;
/*      */     case 30:
/* 2015 */       strFieldName = "qID13";
/* 2016 */       break;
/*      */     case 31:
/* 2018 */       strFieldName = "a13";
/* 2019 */       break;
/*      */     case 32:
/* 2021 */       strFieldName = "qID14";
/* 2022 */       break;
/*      */     case 33:
/* 2024 */       strFieldName = "a14";
/* 2025 */       break;
/*      */     case 34:
/* 2027 */       strFieldName = "qID15";
/* 2028 */       break;
/*      */     case 35:
/* 2030 */       strFieldName = "a15";
/* 2031 */       break;
/*      */     case 36:
/* 2033 */       strFieldName = "qID16";
/* 2034 */       break;
/*      */     case 37:
/* 2036 */       strFieldName = "a16";
/* 2037 */       break;
/*      */     case 38:
/* 2039 */       strFieldName = "operator";
/* 2040 */       break;
/*      */     case 39:
/* 2042 */       strFieldName = "manageCom";
/* 2043 */       break;
/*      */     case 40:
/* 2045 */       strFieldName = "makeDate";
/* 2046 */       break;
/*      */     case 41:
/* 2048 */       strFieldName = "makeTime";
/* 2049 */       break;
/*      */     case 42:
/* 2051 */       strFieldName = "modifyDate";
/* 2052 */       break;
/*      */     case 43:
/* 2054 */       strFieldName = "modifyTime";
/* 2055 */       break;
/*      */     default:
/* 2057 */       strFieldName = "";
/*      */     }
/* 2059 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 2065 */     if (strFieldName.equals("resultId")) {
/* 2066 */       return 0;
/*      */     }
/* 2068 */     if (strFieldName.equals("grpContNo")) {
/* 2069 */       return 0;
/*      */     }
/* 2071 */     if (strFieldName.equals("contNo")) {
/* 2072 */       return 0;
/*      */     }
/* 2074 */     if (strFieldName.equals("proposalContNo")) {
/* 2075 */       return 0;
/*      */     }
/* 2077 */     if (strFieldName.equals("impartId")) {
/* 2078 */       return 0;
/*      */     }
/* 2080 */     if (strFieldName.equals("grouporder")) {
/* 2081 */       return 0;
/*      */     }
/* 2083 */     if (strFieldName.equals("qID01")) {
/* 2084 */       return 0;
/*      */     }
/* 2086 */     if (strFieldName.equals("a01")) {
/* 2087 */       return 0;
/*      */     }
/* 2089 */     if (strFieldName.equals("qID02")) {
/* 2090 */       return 0;
/*      */     }
/* 2092 */     if (strFieldName.equals("a02")) {
/* 2093 */       return 0;
/*      */     }
/* 2095 */     if (strFieldName.equals("qID03")) {
/* 2096 */       return 0;
/*      */     }
/* 2098 */     if (strFieldName.equals("a03")) {
/* 2099 */       return 0;
/*      */     }
/* 2101 */     if (strFieldName.equals("qID04")) {
/* 2102 */       return 0;
/*      */     }
/* 2104 */     if (strFieldName.equals("a04")) {
/* 2105 */       return 0;
/*      */     }
/* 2107 */     if (strFieldName.equals("qID05")) {
/* 2108 */       return 0;
/*      */     }
/* 2110 */     if (strFieldName.equals("a05")) {
/* 2111 */       return 0;
/*      */     }
/* 2113 */     if (strFieldName.equals("qID06")) {
/* 2114 */       return 0;
/*      */     }
/* 2116 */     if (strFieldName.equals("a06")) {
/* 2117 */       return 0;
/*      */     }
/* 2119 */     if (strFieldName.equals("qID07")) {
/* 2120 */       return 0;
/*      */     }
/* 2122 */     if (strFieldName.equals("a07")) {
/* 2123 */       return 0;
/*      */     }
/* 2125 */     if (strFieldName.equals("qID08")) {
/* 2126 */       return 0;
/*      */     }
/* 2128 */     if (strFieldName.equals("a08")) {
/* 2129 */       return 0;
/*      */     }
/* 2131 */     if (strFieldName.equals("qID09")) {
/* 2132 */       return 0;
/*      */     }
/* 2134 */     if (strFieldName.equals("a09")) {
/* 2135 */       return 0;
/*      */     }
/* 2137 */     if (strFieldName.equals("qID10")) {
/* 2138 */       return 0;
/*      */     }
/* 2140 */     if (strFieldName.equals("a10")) {
/* 2141 */       return 0;
/*      */     }
/* 2143 */     if (strFieldName.equals("qID11")) {
/* 2144 */       return 0;
/*      */     }
/* 2146 */     if (strFieldName.equals("a11")) {
/* 2147 */       return 0;
/*      */     }
/* 2149 */     if (strFieldName.equals("qID12")) {
/* 2150 */       return 0;
/*      */     }
/* 2152 */     if (strFieldName.equals("a12")) {
/* 2153 */       return 0;
/*      */     }
/* 2155 */     if (strFieldName.equals("qID13")) {
/* 2156 */       return 0;
/*      */     }
/* 2158 */     if (strFieldName.equals("a13")) {
/* 2159 */       return 0;
/*      */     }
/* 2161 */     if (strFieldName.equals("qID14")) {
/* 2162 */       return 0;
/*      */     }
/* 2164 */     if (strFieldName.equals("a14")) {
/* 2165 */       return 0;
/*      */     }
/* 2167 */     if (strFieldName.equals("qID15")) {
/* 2168 */       return 0;
/*      */     }
/* 2170 */     if (strFieldName.equals("a15")) {
/* 2171 */       return 0;
/*      */     }
/* 2173 */     if (strFieldName.equals("qID16")) {
/* 2174 */       return 0;
/*      */     }
/* 2176 */     if (strFieldName.equals("a16")) {
/* 2177 */       return 0;
/*      */     }
/* 2179 */     if (strFieldName.equals("operator")) {
/* 2180 */       return 0;
/*      */     }
/* 2182 */     if (strFieldName.equals("manageCom")) {
/* 2183 */       return 0;
/*      */     }
/* 2185 */     if (strFieldName.equals("makeDate")) {
/* 2186 */       return 1;
/*      */     }
/* 2188 */     if (strFieldName.equals("makeTime")) {
/* 2189 */       return 0;
/*      */     }
/* 2191 */     if (strFieldName.equals("modifyDate")) {
/* 2192 */       return 1;
/*      */     }
/* 2194 */     if (strFieldName.equals("modifyTime")) {
/* 2195 */       return 0;
/*      */     }
/* 2197 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 2203 */     int nFieldType = -1;
/* 2204 */     switch (nFieldIndex) {
/*      */     case 0:
/* 2206 */       nFieldType = 0;
/* 2207 */       break;
/*      */     case 1:
/* 2209 */       nFieldType = 0;
/* 2210 */       break;
/*      */     case 2:
/* 2212 */       nFieldType = 0;
/* 2213 */       break;
/*      */     case 3:
/* 2215 */       nFieldType = 0;
/* 2216 */       break;
/*      */     case 4:
/* 2218 */       nFieldType = 0;
/* 2219 */       break;
/*      */     case 5:
/* 2221 */       nFieldType = 0;
/* 2222 */       break;
/*      */     case 6:
/* 2224 */       nFieldType = 0;
/* 2225 */       break;
/*      */     case 7:
/* 2227 */       nFieldType = 0;
/* 2228 */       break;
/*      */     case 8:
/* 2230 */       nFieldType = 0;
/* 2231 */       break;
/*      */     case 9:
/* 2233 */       nFieldType = 0;
/* 2234 */       break;
/*      */     case 10:
/* 2236 */       nFieldType = 0;
/* 2237 */       break;
/*      */     case 11:
/* 2239 */       nFieldType = 0;
/* 2240 */       break;
/*      */     case 12:
/* 2242 */       nFieldType = 0;
/* 2243 */       break;
/*      */     case 13:
/* 2245 */       nFieldType = 0;
/* 2246 */       break;
/*      */     case 14:
/* 2248 */       nFieldType = 0;
/* 2249 */       break;
/*      */     case 15:
/* 2251 */       nFieldType = 0;
/* 2252 */       break;
/*      */     case 16:
/* 2254 */       nFieldType = 0;
/* 2255 */       break;
/*      */     case 17:
/* 2257 */       nFieldType = 0;
/* 2258 */       break;
/*      */     case 18:
/* 2260 */       nFieldType = 0;
/* 2261 */       break;
/*      */     case 19:
/* 2263 */       nFieldType = 0;
/* 2264 */       break;
/*      */     case 20:
/* 2266 */       nFieldType = 0;
/* 2267 */       break;
/*      */     case 21:
/* 2269 */       nFieldType = 0;
/* 2270 */       break;
/*      */     case 22:
/* 2272 */       nFieldType = 0;
/* 2273 */       break;
/*      */     case 23:
/* 2275 */       nFieldType = 0;
/* 2276 */       break;
/*      */     case 24:
/* 2278 */       nFieldType = 0;
/* 2279 */       break;
/*      */     case 25:
/* 2281 */       nFieldType = 0;
/* 2282 */       break;
/*      */     case 26:
/* 2284 */       nFieldType = 0;
/* 2285 */       break;
/*      */     case 27:
/* 2287 */       nFieldType = 0;
/* 2288 */       break;
/*      */     case 28:
/* 2290 */       nFieldType = 0;
/* 2291 */       break;
/*      */     case 29:
/* 2293 */       nFieldType = 0;
/* 2294 */       break;
/*      */     case 30:
/* 2296 */       nFieldType = 0;
/* 2297 */       break;
/*      */     case 31:
/* 2299 */       nFieldType = 0;
/* 2300 */       break;
/*      */     case 32:
/* 2302 */       nFieldType = 0;
/* 2303 */       break;
/*      */     case 33:
/* 2305 */       nFieldType = 0;
/* 2306 */       break;
/*      */     case 34:
/* 2308 */       nFieldType = 0;
/* 2309 */       break;
/*      */     case 35:
/* 2311 */       nFieldType = 0;
/* 2312 */       break;
/*      */     case 36:
/* 2314 */       nFieldType = 0;
/* 2315 */       break;
/*      */     case 37:
/* 2317 */       nFieldType = 0;
/* 2318 */       break;
/*      */     case 38:
/* 2320 */       nFieldType = 0;
/* 2321 */       break;
/*      */     case 39:
/* 2323 */       nFieldType = 0;
/* 2324 */       break;
/*      */     case 40:
/* 2326 */       nFieldType = 1;
/* 2327 */       break;
/*      */     case 41:
/* 2329 */       nFieldType = 0;
/* 2330 */       break;
/*      */     case 42:
/* 2332 */       nFieldType = 1;
/* 2333 */       break;
/*      */     case 43:
/* 2335 */       nFieldType = 0;
/* 2336 */       break;
/*      */     default:
/* 2338 */       nFieldType = -1;
/*      */     }
/* 2340 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPFAndIImpResultSchema
 * JD-Core Version:    0.6.0
 */