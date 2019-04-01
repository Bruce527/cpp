/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.BankBasicBL;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPOperationRecordSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class BankPolicyState extends BankBasicBL
/*     */ {
/*  28 */   private String contNo = "";
/*     */ 
/*  31 */   private List<String[]> policyStateList = new ArrayList();
/*  32 */   private String message = "";
/*     */   private IGlobalInput tempGI;
/*  35 */   private LNPContSchema contSch = new LNPContSchema();
/*     */ 
/*  37 */   private LNPOperationRecordSchema lnpPolicyStateSchema = new LNPOperationRecordSchema();
/*     */ 
/*     */   private void buildError(String msgErr) {
/*  40 */     this.message = msgErr;
/*  41 */     System.out.println("buildError:--after-------------" + this.message);
/*     */   }
/*     */ 
/*     */   private boolean getInfoFromSession(HttpSession session)
/*     */   {
/*  46 */     boolean flag = false;
/*     */     try {
/*  48 */       if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */ 
/*  50 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  51 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  52 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*  53 */         waitPolicyCommited(session, this.contNo);
/*  54 */         turnCurrPolicyLockFlag(session, this.contNo, "lock");
/*  55 */         flag = true;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  59 */       turnCurrPolicyLockFlag(session, this.contNo, "unlock");
/*  60 */       flag = false;
/*  61 */       buildError(e.getMessage());
/*     */     }
/*  63 */     return flag;
/*     */   }
/*     */ 
/*     */   public String queryPolicyState() {
/*  67 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */     try {
/*  69 */       if (getInfoFromSession(session)) {
/*  70 */         this.policyStateList.clear();
/*  71 */         System.out.println("--- queryPolicyState Start ---");
/*  72 */         String sql = "select distinct top 200";
/*  73 */         sql = sql + " lc.codename as '\u4FDD\u5355\u72B6\u6001',lnp.OperatorCode as '\u5904\u7406\u4EBA\u5458\u7F16\u7801',lnp.OperatorName as '\u5904\u7406\u4EBA\u5458',convert(varchar(10),lnp.OperationDate,120) as date ,lnp.OperationTime as time  from LNPOperationRecord lnp inner join lnpcode lc on lnp.Varc2 = lc.code where lnp.contno='" + 
/*  80 */           this.contNo + 
/*  81 */           "' and lc.codetype='lnpLangState' ";
/*  82 */         sql = sql + " order by date desc,time desc";
/*  83 */         System.out.println("queryPolicyState SQL_c : " + sql);
/*     */ 
/*  85 */         SSRS tSSRS = new SSRS();
/*  86 */         ExeSQL exeSQL = new ExeSQL();
/*  87 */         tSSRS = exeSQL.execSQL(sql);
/*     */ 
/*  89 */         System.out.println("\u5FAA\u73AF\u663E\u793A\u7ED3\u679C\u5217\u8868\u5F00\u59CB-------------");
/*  90 */         if ((tSSRS == null) || (tSSRS.getMaxRow() < 1)) {
/*  91 */           this.message = "\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C!";
/*  92 */           ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C!");
/*  93 */           System.out.println(this.message);
/*     */         } else {
/*  95 */           if (tSSRS.MaxRow == 200) {
/*  96 */             this.message = "\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u4EC5\u663E\u793A\u524D200\u6761\uFF01";
/*  97 */             ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", 
/*  98 */               "\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u4EC5\u663E\u793A\u524D200\u6761\uFF01");
/*  99 */             System.out.println(this.message);
/*     */           }
/*     */ 
/* 102 */           for (int i = 1; i <= tSSRS.MaxRow; i++) {
/* 103 */             String[] resultInfo = new String[tSSRS.MaxCol - 2];
/* 104 */             resultInfo[0] = tSSRS.GetText(i, 1);
/* 105 */             resultInfo[1] = (tSSRS.GetText(i, 2) + "-" + tSSRS.GetText(i, 3));
/* 106 */             resultInfo[2] = (tSSRS.GetText(i, 4) + " " + tSSRS.GetText(i, 5));
/* 107 */             this.policyStateList.add(resultInfo);
/*     */           }
/*     */ 
/* 110 */           System.out.println("\u5FAA\u73AF\u663E\u793A\u7ED3\u679C\u5217\u8868\u7ED3\u675F-------------");
/*     */         }
/*     */       }
/*     */       else {
/* 114 */         buildError("\u5168\u5C40\u6295\u4FDD\u4E66\u4FE1\u606F\u7F3A\u5931!");
/*     */       }
/*     */     } catch (Exception e) {
/* 117 */       e.printStackTrace();
/*     */     } finally {
/* 119 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*     */     }
/* 121 */     System.out.println("--- queryPolicyState End ---");
/* 122 */     return "success";
/*     */   }
/*     */ 
/*     */   public boolean savePolicyState(String contNo, String state, String recordFlag, String date, String time, String rstMsg)
/*     */   {
/* 127 */     System.out.println("saveOperRecord---start");
/* 128 */     LNPOperationRecordSchema operRecordSchema = new LNPOperationRecordSchema();
/*     */ 
/* 130 */     HttpSession session = (HttpSession)
/* 131 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 132 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*     */     try
/*     */     {
/* 135 */       if ((tempGI != null) && (date != null) && (!date.equals("")) && (time != null) && (!time.equals("")) && (recordFlag != null) && (!recordFlag.equals(""))) {
/* 136 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 137 */         operRecordSchema.setID(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 138 */         operRecordSchema.setContNo(contNo);
/* 139 */         operRecordSchema.setOperatorCode(tempGI.Operator);
/* 140 */         operRecordSchema.setOperatorName(getOperatorName(tempGI.Operator));
/* 141 */         operRecordSchema.setOperatorType("2");
/* 142 */         operRecordSchema.setOperationDate(date);
/* 143 */         operRecordSchema.setOperationTime(time);
/* 144 */         operRecordSchema.setOperation(recordFlag);
/*     */ 
/* 146 */         operRecordSchema.setVarc1(date + ' ' + time);
/* 147 */         operRecordSchema.setVarc3("07".equals(state) ? "\u53D1\u9001\u5931\u8D25" : "06".equals(state) ? "\u53D1\u9001\u6210\u529F" : "04".equals(state) ? "\u4FDD\u8D39\u8BA1\u7B97\u5931\u8D25" : "03".equals(state) ? "\u4FDD\u8D39\u8BA1\u7B97\u6210\u529F" : "--!");
/* 148 */         System.out.println(state + "<--->" + operRecordSchema.getVarc3());
/* 149 */         operRecordSchema.setVarc4(rstMsg);
/* 150 */         operRecordSchema.setVarc2(state);
/* 151 */         MMap map = new MMap();
/* 152 */         VData vd = new VData();
/* 153 */         PubSubmit ps = new PubSubmit();
/* 154 */         map.put(operRecordSchema, "INSERT");
/* 155 */         vd.add(map);
/* 156 */         if (!ps.submitData(vd, "")) {
/* 157 */           System.out.println("saveOperRecord error");
/* 158 */           return false;
/*     */         }
/* 160 */         System.out.println("saveOperRecord success");
/* 161 */         return true;
/*     */       }
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     catch (RuntimeException e) {
/* 167 */       e.printStackTrace();
/*     */     }
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean savePolicyState(String contNo, String state, String recordFlag, String date, String time) {
/* 173 */     System.out.println("saveOperRecord---start");
/* 174 */     LNPOperationRecordSchema operRecordSchema = new LNPOperationRecordSchema();
/*     */ 
/* 176 */     HttpSession session = (HttpSession)
/* 177 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 178 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*     */     try
/*     */     {
/* 181 */       if ((tempGI != null) && (date != null) && (!date.equals("")) && (time != null) && (!time.equals("")) && (recordFlag != null) && (!recordFlag.equals(""))) {
/* 182 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 183 */         operRecordSchema.setID(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 184 */         operRecordSchema.setContNo(contNo);
/* 185 */         operRecordSchema.setOperatorCode(tempGI.Operator);
/* 186 */         operRecordSchema.setOperatorName(getOperatorName(tempGI.Operator));
/* 187 */         operRecordSchema.setOperatorType("2");
/* 188 */         operRecordSchema.setOperationDate(date);
/* 189 */         operRecordSchema.setOperationTime(time);
/* 190 */         operRecordSchema.setOperation(recordFlag);
/*     */ 
/* 192 */         operRecordSchema.setVarc2(state);
/* 193 */         MMap map = new MMap();
/* 194 */         VData vd = new VData();
/* 195 */         PubSubmit ps = new PubSubmit();
/* 196 */         map.put(operRecordSchema, "INSERT");
/* 197 */         vd.add(map);
/* 198 */         if (!ps.submitData(vd, "")) {
/* 199 */           System.out.println("saveOperRecord error");
/* 200 */           return false;
/*     */         }
/* 202 */         System.out.println("saveOperRecord success");
/* 203 */         return true;
/*     */       }
/*     */ 
/* 206 */       return false;
/*     */     }
/*     */     catch (RuntimeException e) {
/* 209 */       e.printStackTrace();
/*     */     }
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */   private String getOperatorName(String operator) {
/* 215 */     if (operator != null) {
/* 216 */       ExeSQL exeSQL = new ExeSQL();
/* 217 */       String sqlStr = "";
/*     */ 
/* 223 */       sqlStr = "select username from MUser where UserCode = '" + 
/* 224 */         operator + "'";
/*     */ 
/* 226 */       SSRS tSSRS = exeSQL.execSQL(sqlStr);
/* 227 */       if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 228 */         return tSSRS.GetText(1, 1);
/*     */       }
/*     */     }
/* 231 */     return null;
/*     */   }
/*     */ 
/*     */   private String getComCode(String cno) {
/* 235 */     String com = "";
/* 236 */     ExeSQL tExeSql = new ExeSQL();
/* 237 */     String preSql = "select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '" + cno.substring(0, 2) + "'";
/* 238 */     SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
/* 239 */     if ((tSSRSfromCom != null) && (tSSRSfromCom.MaxRow > 0)) {
/* 240 */       com = tSSRSfromCom.GetText(1, 1);
/*     */     }
/* 242 */     return com;
/*     */   }
/*     */ 
/*     */   public String getContNo() {
/* 246 */     return this.contNo;
/*     */   }
/*     */ 
/*     */   public void setContNo(String contNo) {
/* 250 */     this.contNo = contNo;
/*     */   }
/*     */ 
/*     */   public List<String[]> getPolicyStateList() {
/* 254 */     return this.policyStateList;
/*     */   }
/*     */ 
/*     */   public void setPolicyStateList(List<String[]> policyStateList) {
/* 258 */     this.policyStateList = policyStateList;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 262 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 266 */     this.message = message;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankPolicyState
 * JD-Core Version:    0.6.0
 */