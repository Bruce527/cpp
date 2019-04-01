/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.lis.excel.ExcelInfo;
/*     */ import com.sinosoft.map.lis.excel.ReportHelper;
/*     */ import com.sinosoft.map.lis.excel.SimpleWorkbook;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AuditPendingQuery
/*     */ {
/*     */   private String state;
/*     */   private String auditStartDate;
/*     */   private String auditEndDate;
/*     */   private String inputStartDate;
/*     */   private String inputEndDate;
/*     */   private String excelPath;
/*  28 */   private ArrayList<AuditPendingQueryTableBean> lnpList = new ArrayList();
/*  29 */   private boolean dataNullFlag = false;
/*     */ 
/*  48 */   private boolean showErrorFlag = false;
/*     */   private String filename;
/*     */   private String[][] data;
/* 114 */   private ExeSQL exsql = new ExeSQL();
/*     */   private IGlobalInput tempGI;
/*     */   private String sql;
/*     */ 
/*     */   public boolean isDataNullFlag()
/*     */   {
/*  32 */     return this.dataNullFlag;
/*     */   }
/*     */ 
/*     */   public void setDataNullFlag(boolean dataNullFlag) {
/*  36 */     this.dataNullFlag = dataNullFlag;
/*     */   }
/*     */ 
/*     */   public boolean isShowErrorFlag()
/*     */   {
/*  41 */     return this.showErrorFlag;
/*     */   }
/*     */ 
/*     */   public void setShowErrorFlag(boolean showErrorFlag) {
/*  45 */     this.showErrorFlag = showErrorFlag;
/*     */   }
/*     */ 
/*     */   public String getState()
/*     */   {
/*  50 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(String state) {
/*  54 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public void init() {
/*  58 */     HttpSession session = (HttpSession)
/*  59 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  60 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*     */   }
/*     */ 
/*     */   public ArrayList<AuditPendingQueryTableBean> getLnpList() {
/*  64 */     return this.lnpList;
/*     */   }
/*     */ 
/*     */   public void setLnpList(ArrayList<AuditPendingQueryTableBean> resultList) {
/*  68 */     this.lnpList = resultList;
/*     */   }
/*     */ 
/*     */   public String getAuditStartDate() {
/*  72 */     return this.auditStartDate;
/*     */   }
/*     */ 
/*     */   public void setAuditStartDate(String auditStartDate) {
/*  76 */     this.auditStartDate = auditStartDate;
/*     */   }
/*     */ 
/*     */   public String getAuditEndDate() {
/*  80 */     return this.auditEndDate;
/*     */   }
/*     */ 
/*     */   public void setAuditEndDate(String auditEndDate) {
/*  84 */     this.auditEndDate = auditEndDate;
/*     */   }
/*     */ 
/*     */   public String getInputStartDate() {
/*  88 */     return this.inputStartDate;
/*     */   }
/*     */ 
/*     */   public void setInputStartDate(String inputStartDate) {
/*  92 */     this.inputStartDate = inputStartDate;
/*     */   }
/*     */ 
/*     */   public String getInputEndDate() {
/*  96 */     return this.inputEndDate;
/*     */   }
/*     */ 
/*     */   public void setInputEndDate(String inputEndDate) {
/* 100 */     this.inputEndDate = inputEndDate;
/*     */   }
/*     */ 
/*     */   public String getExcelPath() {
/* 104 */     return this.excelPath;
/*     */   }
/*     */ 
/*     */   public void setExcelPath(String excelPath) {
/* 108 */     this.excelPath = excelPath;
/*     */   }
/*     */ 
/*     */   public void query()
/*     */   {
/* 116 */     if (!this.lnpList.isEmpty())
/* 117 */       this.lnpList.clear();
/* 118 */     this.sql = 
/* 161 */       (" ROW_NUMBER() OVER (ORDER BY a.contno) AS [AUTOID], b.codename,a.contno,c.operationdate,d.operationdate,e.branchattr,e.agentcode,j.codename,g.codename,h.riskcode,c.OperatorCode from lnpcont a left join lnpcode b on b.code=a.managecom and b.codetype='lnpManageCom' left join (select y.OperationDate,y.contno,y.operatorcode from (select max(r.OperationDate) as OperationDate,max(id) as id from LNPOperationRecord r where r.Varc2='01' group by r.contno) x,LNPOperationRecord y where x.operationdate=y.operationdate and x.id=y.id) c on c.contno=a.contno left join (select min(p.OperationDate) as OperationDate,p.contno from LNPOperationRecord p  where p.Varc2='02'  group by p.contno) d on d.contno=a.contno left join lnpAgentInfo e on e.contno=a.contno left join LNPPayment f on f.contno=a.contno left join lnpcode g on g.codetype='BankRenewal' and g.code=f.payment1 left join lnppol h on h.contno=a.contno and h.SubFlag='M' left join lnpcode j on j.code=a.state and j.codetype='lnpLangState' where a.managecom like '" + 
/* 161 */       this.tempGI.ManageCom + "%' ");
/*     */ 
/* 169 */     if ((this.state != "-1") && (!this.state.equals("-1"))) {
/* 170 */       if (("0".equals(this.state)) || (this.state == "0")) {
/* 171 */         this.sql += " and a.state='01'";
/*     */       }
/*     */ 
/* 174 */       if (("1".equals(this.state)) || (this.state == "1")) {
/* 175 */         this.sql += " and a.state in('02','03','04','05')";
/*     */       }
/* 177 */       if (("2".equals(this.state)) || (this.state == "2"))
/* 178 */         this.sql += " and a.state='07'";
/*     */     }
/*     */     else {
/* 181 */       this.sql += " and a.state <> '06'";
/*     */     }
/*     */ 
/* 184 */     if ((this.auditStartDate != null) && (!"".equals(this.auditStartDate))) {
/* 185 */       this.sql = (this.sql + " and d.operationdate>='" + this.auditStartDate + "' ");
/*     */     }
/* 187 */     if ((this.auditEndDate != null) && (!"".equals(this.auditEndDate))) {
/* 188 */       this.sql = (this.sql + " and d.operationdate<='" + this.auditEndDate + "' ");
/*     */     }
/*     */ 
/* 191 */     if ((this.inputStartDate != null) && (!"".equals(this.inputStartDate))) {
/* 192 */       this.sql = (this.sql + " and c.operationdate>='" + this.inputStartDate + "' ");
/*     */     }
/* 194 */     if ((this.inputEndDate != null) && (!"".equals(this.inputEndDate))) {
/* 195 */       this.sql = (this.sql + " and c.operationdate<='" + this.inputEndDate + "' ");
/*     */     }
/* 197 */     this.lnpList.clear();
/* 198 */     querySql("select distinct top 200" + this.sql, false);
/*     */   }
/*     */ 
/*     */   public void report() {
/* 202 */     this.excelPath = printReportList();
/*     */   }
/*     */ 
/*     */   public String printReportList()
/*     */   {
/* 207 */     boolean flag = true;
/* 208 */     String currentDate = PubFun.getCurrentDate();
/*     */ 
/* 210 */     String templetFileName = "AuditPendingQuery.xls";
/* 211 */     String reportFileName = this.tempGI.ManageCom + "_" + "auditPendingQuery_" + this.tempGI.Operator + 
/* 212 */       "_" + currentDate + ".xls";
/*     */ 
/* 214 */     this.filename = reportFileName;
/* 215 */     long usefullLifeSec = 0L;
/*     */ 
/* 219 */     String rvFNStartWith = this.tempGI.ManageCom + "_" + "auditPendingQuery";
/* 220 */     long invalidationSec = usefullLifeSec * 2L;
/*     */ 
/* 224 */     ReportHelper helper = new ReportHelper(templetFileName, reportFileName, 
/* 225 */       usefullLifeSec, rvFNStartWith, invalidationSec);
/* 226 */     ExcelInfo info = helper.getInfo();
/*     */ 
/* 228 */     if (!info.exists()) {
/* 229 */       flag = getPrintData(helper);
/*     */     }
/* 231 */     if (flag) {
/* 232 */       ExcelInfo info2 = helper.getInfo();
/* 233 */       String Excelpath = info2.getReportPath();
/* 234 */       return Excelpath;
/*     */     }
/*     */ 
/* 238 */     ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u65E0\u6CD5\u6253\u5370\u62A5\u8868\uFF0C\u6CA1\u6709\u67E5\u8BE2\u5230\u7B26\u5408\u6761\u4EF6\u7684\u6570\u636E\uFF01");
/* 239 */     return "";
/*     */   }
/*     */ 
/*     */   private boolean getPrintData(ReportHelper helper)
/*     */   {
/* 244 */     if (("".equals(this.sql)) || (this.sql == null))
/* 245 */       return false;
/* 246 */     this.data = null;
/* 247 */     querySql("select distinct " + this.sql, true);
/* 248 */     if ((this.data == null) || (this.data.length == 0)) return false;
/* 249 */     SimpleWorkbook workbook = helper.createWorkbook();
/*     */     try {
/* 251 */       if (this.data == null) {
/* 252 */         ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u8BB0\u5F55\u4E3A\u7A7A");
/*     */       }
/* 254 */       workbook.set("currentDate", PubFun.getCurrentDate());
/* 255 */       workbook.add(this.data);
/* 256 */       workbook = null;
/*     */     } catch (Exception e) {
/* 258 */       return false;
/*     */     } finally {
/* 260 */       if (workbook != null) {
/*     */         try {
/* 262 */           workbook.close();
/*     */         } catch (Exception e1) {
/* 264 */           e1.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 268 */     return true;
/*     */   }
/*     */ 
/*     */   private void querySql(String sql, boolean isExcelExport) {
/* 272 */     SSRS ssrs = this.exsql.execSQL(sql);
/* 273 */     System.out.println(sql);
/* 274 */     if ((ssrs.MaxRow >= 200) && (!isExcelExport)) {
/* 275 */       System.out.println("\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u8BF7\u60A8\u7EC6\u5316\u67E5\u8BE2\u6761\u4EF6\uFF01");
/* 276 */       ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", 
/* 277 */         "\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u8BF7\u60A8\u7EC6\u5316\u67E5\u8BE2\u6761\u4EF6\uFF01");
/* 278 */       this.showErrorFlag = true;
/*     */     } else {
/* 280 */       this.showErrorFlag = false;
/*     */     }
/* 282 */     if ((ssrs.MaxRow <= 0) && (!isExcelExport)) {
/* 283 */       this.dataNullFlag = true;
/* 284 */       System.out.println("\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C,\u8BF7\u5F55\u5165\u5176\u4ED6\u67E5\u8BE2\u6761\u4EF6\u91CD\u65B0\u67E5\u8BE2!");
/* 285 */       ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C,\u8BF7\u5F55\u5165\u5176\u4ED6\u67E5\u8BE2\u6761\u4EF6\u91CD\u65B0\u67E5\u8BE2!");
/*     */     } else {
/* 287 */       this.dataNullFlag = false;
/*     */     }
/* 289 */     for (int i = 0; i < ssrs.MaxRow; i++)
/*     */     {
/* 303 */       if (!isExcelExport)
/*     */       {
/* 306 */         AuditPendingQueryTableBean bean = new AuditPendingQueryTableBean();
/* 307 */         bean.manageCom = ssrs.GetText(i + 1, 2);
/* 308 */         bean.contNo = ssrs.GetText(i + 1, 3);
/* 309 */         bean.inputDate = ssrs.GetText(i + 1, 4);
/* 310 */         bean.auditDate = ssrs.GetText(i + 1, 5);
/* 311 */         bean.branchGroup = ssrs.GetText(i + 1, 6);
/* 312 */         bean.agentCode = ssrs.GetText(i + 1, 7);
/* 313 */         bean.state = ssrs.GetText(i + 1, 8);
/*     */ 
/* 315 */         bean.fistPayMethod = ssrs.GetText(i + 1, 9);
/* 316 */         bean.mainRiskCode = ssrs.GetText(i + 1, 10);
/* 317 */         bean.inputUser = ssrs.GetText(i + 1, 11);
/*     */ 
/* 326 */         this.lnpList.add(bean);
/*     */       }
/*     */       else
/*     */       {
/* 336 */         if (i == 0)
/* 337 */           this.data = new String[ssrs.MaxRow][11];
/* 338 */         this.data[i][0] = ssrs.GetText(i + 1, 1);
/* 339 */         this.data[i][1] = ssrs.GetText(i + 1, 2);
/* 340 */         this.data[i][2] = ssrs.GetText(i + 1, 3);
/* 341 */         this.data[i][3] = ssrs.GetText(i + 1, 4);
/* 342 */         this.data[i][4] = ssrs.GetText(i + 1, 5);
/* 343 */         this.data[i][5] = ssrs.GetText(i + 1, 6);
/* 344 */         this.data[i][6] = ssrs.GetText(i + 1, 7);
/* 345 */         this.data[i][7] = ssrs.GetText(i + 1, 8);
/* 346 */         this.data[i][8] = ssrs.GetText(i + 1, 9);
/* 347 */         this.data[i][9] = ssrs.GetText(i + 1, 10);
/* 348 */         this.data[i][10] = ssrs.GetText(i + 1, 11);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void download()
/*     */   {
/* 378 */     FacesContext context = FacesContext.getCurrentInstance();
/* 379 */     HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
/* 380 */     response.reset();
/* 381 */     response.setContentType("application/OCTET-STREAM");
/*     */     try {
/* 383 */       response.setHeader("Content-disposition", "attachment;filename=" + new String(this.filename.getBytes(), "iso-8859-1"));
/* 384 */       ReportHelper.download(response.getOutputStream(), this.excelPath);
/*     */     } catch (UnsupportedEncodingException e) {
/* 386 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 388 */       e.printStackTrace();
/*     */     } finally {
/* 390 */       context.responseComplete(); }  } 
/*     */   public class AuditPendingQueryTableBean { private String manageCom;
/*     */     private String contNo;
/*     */     private String inputDate;
/*     */     private String auditDate;
/*     */     private String branchGroup;
/*     */     private String agentCode;
/*     */     private String state;
/*     */     private String fistPayMethod;
/*     */     private String mainRiskCode;
/*     */     private String inputUser;
/*     */ 
/*     */     public AuditPendingQueryTableBean() {  } 
/* 406 */     public String getManageCom() { return this.manageCom; }
/*     */ 
/*     */     public void setManageCom(String manageCom) {
/* 409 */       this.manageCom = manageCom;
/*     */     }
/*     */     public String getContNo() {
/* 412 */       return this.contNo;
/*     */     }
/*     */     public void setContNo(String contNo) {
/* 415 */       this.contNo = contNo;
/*     */     }
/*     */     public String getInputDate() {
/* 418 */       return this.inputDate;
/*     */     }
/*     */     public void setInputDate(String inputDate) {
/* 421 */       this.inputDate = inputDate;
/*     */     }
/*     */     public String getAuditDate() {
/* 424 */       return this.auditDate;
/*     */     }
/*     */     public void setAuditDate(String auditDate) {
/* 427 */       this.auditDate = auditDate;
/*     */     }
/*     */     public String getBranchGroup() {
/* 430 */       return this.branchGroup;
/*     */     }
/*     */     public void setBranchGroup(String branchGroup) {
/* 433 */       this.branchGroup = branchGroup;
/*     */     }
/*     */     public String getAgentCode() {
/* 436 */       return this.agentCode;
/*     */     }
/*     */     public void setAgentCode(String agentCode) {
/* 439 */       this.agentCode = agentCode;
/*     */     }
/*     */     public String getState() {
/* 442 */       return this.state;
/*     */     }
/*     */     public void setState(String state) {
/* 445 */       this.state = state;
/*     */     }
/*     */     public String getFistPayMethod() {
/* 448 */       return this.fistPayMethod;
/*     */     }
/*     */     public void setFistPayMethod(String fistPayMethod) {
/* 451 */       this.fistPayMethod = fistPayMethod;
/*     */     }
/*     */     public String getMainRiskCode() {
/* 454 */       return this.mainRiskCode;
/*     */     }
/*     */     public void setMainRiskCode(String mainRiskCode) {
/* 457 */       this.mainRiskCode = mainRiskCode;
/*     */     }
/*     */     public String getInputUser() {
/* 460 */       return this.inputUser;
/*     */     }
/*     */     public void setInputUser(String inputUser) {
/* 463 */       this.inputUser = inputUser;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.AuditPendingQuery
 * JD-Core Version:    0.6.0
 */