/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.BankBasicBL;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class BankSysInfo extends BankBasicBL
/*     */ {
/*  20 */   private String contNo = "";
/*     */ 
/*  22 */   private List<String[]> sysInfoList = new ArrayList();
/*  23 */   private String message = "";
/*     */ 
/*  26 */   private IGlobalInput tempGI = null;
/*     */   private LNPContSchema contSch;
/*     */ 
/*     */   public void searchSysInfo()
/*     */   {
/*     */     try
/*     */     {
/*  31 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  32 */       if (getInfoFromSession(session)) {
/*  33 */         this.sysInfoList.clear();
/*  34 */         System.out.println("--- querySysInfo Start ---");
/*  35 */         String sql = "select top 200 * from";
/*  36 */         sql = sql + "(select distinct convert(varchar(10),lnp.Date1,120) as modifydate,lnp.Varc1,lnp.Varc3,lnp.Varc4 from LNPOperationRecord lnp  where lnp.contno='" + 
/*  41 */           this.contNo + "' " + 
/*  43 */           " and lnp.Varc2 in('03','04','06','07') " + 
/*  44 */           " and lnp.operation<>'2'";
/*  45 */         sql = sql + " ) a ";
/*  46 */         sql = sql + " order by a.modifydate desc";
/*  47 */         System.out.println("querySysInfo SQL_c : " + sql);
/*     */ 
/*  49 */         SSRS tSSRS = new SSRS();
/*  50 */         ExeSQL exeSQL = new ExeSQL();
/*  51 */         tSSRS = exeSQL.execSQL(sql);
/*  52 */         if ((tSSRS == null) || (tSSRS.getMaxRow() < 1)) {
/*  53 */           this.message = "\uFFFD\uFFFD\u046F\uFFFD\u07B7\uFFFD\uFFFD\u063D\uFFFD\uFFFD!";
/*  54 */           ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\uFFFD\uFFFD\u046F\uFFFD\u07B7\uFFFD\uFFFD\u063D\uFFFD\uFFFD!");
/*  55 */           System.out.println(this.message);
/*     */         }
/*     */         else {
/*  58 */           if (tSSRS.MaxRow == 200) {
/*  59 */             this.message = "\uFFFD\uFFFD\u046F\uFFFD\uFFFD\u00BC\uFFFD\uFFFD\uFFFD\uFFFD200\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02BE\u01F0200\uFFFD\uFFFD\uFFFD\uFFFD";
/*  60 */             ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", "\uFFFD\uFFFD\u046F\uFFFD\uFFFD\u00BC\uFFFD\uFFFD\uFFFD\uFFFD200\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02BE\u01F0200\uFFFD\uFFFD\uFFFD\uFFFD");
/*  61 */             System.out.println(this.message);
/*     */           }
/*  63 */           for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  64 */             String[] resultInfo = new String[tSSRS.MaxCol - 1];
/*  65 */             resultInfo[0] = (tSSRS.GetText(i, 1) + " " + tSSRS.GetText(i, 2));
/*  66 */             resultInfo[1] = tSSRS.GetText(i, 3);
/*  67 */             resultInfo[2] = tSSRS.GetText(i, 4);
/*  68 */             this.sysInfoList.add(resultInfo);
/*     */           }
/*  70 */           return;
/*     */         }
/*     */       }
/*     */       else {
/*  74 */         buildError("\u022B\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\u0231\u02A7!");
/*     */       }
/*     */     } catch (Exception e) {
/*  77 */       e.printStackTrace();
/*     */     } finally {
/*  79 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*     */     }
/*  81 */     System.out.println("--- querySysInfo End ---");
/*     */   }
/*     */ 
/*     */   private boolean getInfoFromSession(HttpSession session)
/*     */   {
/*  86 */     boolean flag = false;
/*     */     try {
/*  88 */       if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */ 
/*  90 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  91 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  92 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*  93 */         waitPolicyCommited(session, this.contNo);
/*  94 */         turnCurrPolicyLockFlag(session, this.contNo, "lock");
/*  95 */         flag = true;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  99 */       turnCurrPolicyLockFlag(session, this.contNo, "unlock");
/* 100 */       flag = false;
/* 101 */       buildError(e.getMessage());
/*     */     }
/* 103 */     return flag;
/*     */   }
/*     */ 
/*     */   private void buildError(String msgErr)
/*     */   {
/* 108 */     this.message = msgErr;
/* 109 */     System.out.println("buildError:--after-------------" + this.message);
/*     */   }
/*     */ 
/*     */   public String getContNo()
/*     */   {
/* 114 */     return this.contNo;
/*     */   }
/*     */ 
/*     */   public List<String[]> getSysInfoList() {
/* 118 */     return this.sysInfoList;
/*     */   }
/*     */ 
/*     */   public void setSysInfoList(List<String[]> sysInfoList) {
/* 122 */     this.sysInfoList = sysInfoList;
/*     */   }
/*     */ 
/*     */   public void setContNo(String contNo) {
/* 126 */     this.contNo = contNo;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 130 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 134 */     this.message = message;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankSysInfo
 * JD-Core Version:    0.6.0
 */