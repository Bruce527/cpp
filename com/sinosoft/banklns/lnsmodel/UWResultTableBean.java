/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class UWResultTableBean
/*     */ {
/*     */   List<String[]> uwResultMainList;
/*     */   List<String[]> uwResultList;
/*     */   int listlength;
/*     */   String contno;
/*     */ 
/*     */   public void init()
/*     */   {
/*     */     try
/*     */     {
/*  36 */       HttpSession session = (HttpSession)
/*  37 */         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  38 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  39 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  40 */         this.contno = ((String)session.getAttribute("ContNo"));
/*     */ 
/*  42 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  43 */         LNPContSchema mainSch = mainInfo.getContByContNo(this.contno);
/*  44 */         this.uwResultMainList = new ArrayList();
/*  45 */         this.uwResultList = new ArrayList();
/*  46 */         this.listlength = 0;
/*     */ 
/*  48 */         String sql = "select AppDecision,UWMessages from LNPCUWMaster where contno='" + this.contno + "' ;";
/*  49 */         ExeSQL tExeSQL = new ExeSQL();
/*  50 */         SSRS tSSRS = tExeSQL.execSQL(sql);
/*     */ 
/*  52 */         if ((mainSch != null) && (tSSRS != null) && (tSSRS.MaxRow > 0)) {
/*  53 */           if (tSSRS.GetText(1, 1) != null) {
/*  54 */             this.uwResultList.add(new String[] { "Overall Decision", tSSRS.GetText(1, 1) });
/*     */           }
/*  56 */           if ((tSSRS.GetText(1, 2) != null) && (!"".equals(tSSRS.GetText(1, 2).trim()))) {
/*  57 */             String[] mainmsg = tSSRS.GetText(1, 2).split("\\^");
/*  58 */             for (int i = 0; i < mainmsg.length; i++) {
/*  59 */               this.uwResultList.add(new String[] { "Message", mainmsg[i] });
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*  64 */           sql = "select uwmessages from  LNPIndUWMaster where contno='" + this.contno + "'";
/*  65 */           SSRS tinsuSSRS = tExeSQL.execSQL(sql);
/*  66 */           if ((tinsuSSRS != null) && (tinsuSSRS != null) && (tinsuSSRS.MaxRow > 0)) {
/*  67 */             for (int i = 1; i <= tinsuSSRS.MaxRow; i++) {
/*  68 */               if ((tinsuSSRS.GetText(i, 1) == null) || ("".equals(tinsuSSRS.GetText(i, 1).trim())))
/*     */                 continue;
/*  70 */               String[] mainmsg = tinsuSSRS.GetText(i, 1).split("\\^");
/*  71 */               for (int j = 0; j < mainmsg.length; j++) {
/*  72 */                 this.uwResultList.add(new String[] { "Message", mainmsg[j] });
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*  80 */           String lnpuwmasterSQL = "select  ridercode,ridername,uwdid,faceamount,healthdeb,healthfe,healthfed,OccupationFactor,OccupationFe,OccupationFed,exclusions,DeclinedCode,DeclinedReason from LNPUWMaster where contno='" + 
/*  82 */             this.contno + "' and plancode=ridercode " + 
/*  83 */             "union  all " + 
/*  84 */             "select  ridercode,ridername,uwdid,faceamount,healthdeb,healthfe" + 
/*  85 */             ",healthfed,OccupationFactor,OccupationFe,OccupationFed,exclusions," + 
/*  86 */             "DeclinedCode,DeclinedReason from LNPUWMaster where contno='" + this.contno + "' and plancode<>ridercode ";
/*  87 */           SSRS tSSRS2 = tExeSQL.execSQL(lnpuwmasterSQL);
/*     */ 
/*  90 */           if ((tSSRS2 != null) && (tSSRS2.MaxRow > 0)) {
/*  91 */             for (int i = 1; i <= tSSRS2.MaxRow; i++)
/*     */             {
/*  93 */               this.uwResultList.add(new String[] { "Product Code", tSSRS2.GetText(i, 1) });
/*  94 */               this.uwResultList.add(new String[] { "Product Name", tSSRS2.GetText(i, 2) });
/*  95 */               this.uwResultList.add(new String[] { "UWID", tSSRS2.GetText(i, 3) });
/*  96 */               this.uwResultList.add(new String[] { "FaceAmount", tSSRS2.GetText(i, 4) });
/*  97 */               this.uwResultList.add(new String[] { "health debit", tSSRS2.GetText(i, 5) });
/*  98 */               this.uwResultList.add(new String[] { "health flat extra", tSSRS2.GetText(i, 6) });
/*  99 */               this.uwResultList.add(new String[] { "health flat extra debit", tSSRS2.GetText(i, 7) });
/* 100 */               this.uwResultList.add(new String[] { "occupation factor", tSSRS2.GetText(i, 8) });
/* 101 */               this.uwResultList.add(new String[] { "occupation flat extra", tSSRS2.GetText(i, 9) });
/* 102 */               this.uwResultList.add(new String[] { "occupation flat extra debit", tSSRS2.GetText(i, 10) });
/* 103 */               String ExclusionNameString = tSSRS2.GetText(i, 11).replace("\\^", ",");
/* 104 */               this.uwResultList.add(new String[] { "Exclusion Name", ExclusionNameString });
/* 105 */               this.uwResultList.add(new String[] { "Exclusion Duration", "" });
/* 106 */               this.uwResultList.add(new String[] { "Declined Code", tSSRS2.GetText(i, 12) });
/* 107 */               this.uwResultList.add(new String[] { "Declined Reason", tSSRS2.GetText(i, 13) });
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 115 */           String testSQL = "select PEName from LNPIndUWPEMaster where ContNo = '" + this.contno + "'  " + 
/* 116 */             "and InsuredId='" + mainSch.getInsuredId() + "' order by UWPENo;";
/* 117 */           SSRS tSSRS3 = tExeSQL.execSQL(testSQL);
/*     */ 
/* 119 */           String testStr = "";
/* 120 */           if ((tSSRS3 != null) && (tSSRS3.MaxRow > 0))
/*     */           {
/* 122 */             testStr = tSSRS3.GetText(1, 1);
/* 123 */             for (int i = 2; i <= tSSRS3.MaxRow; i++) {
/* 124 */               testStr = testStr + "," + tSSRS3.GetText(i, 1);
/*     */             }
/*     */           }
/* 127 */           this.uwResultList.add(new String[] { "Test Reports Required", testStr });
/*     */         }
/* 129 */         this.listlength = this.uwResultList.size();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<String[]> getUwResultList() {
/* 138 */     return this.uwResultList;
/*     */   }
/*     */ 
/*     */   public void setUwResultList(List<String[]> uwResultList) {
/* 142 */     this.uwResultList = uwResultList;
/*     */   }
/*     */ 
/*     */   public int getListlength() {
/* 146 */     return this.listlength;
/*     */   }
/*     */ 
/*     */   public void setListlength(int listlength) {
/* 150 */     this.listlength = listlength;
/*     */   }
/*     */ 
/*     */   public List<String[]> getUwResultMainList() {
/* 154 */     return this.uwResultMainList;
/*     */   }
/*     */ 
/*     */   public void setUwResultMainList(List<String[]> uwResultMainList) {
/* 158 */     this.uwResultMainList = uwResultMainList;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.UWResultTableBean
 * JD-Core Version:    0.6.0
 */