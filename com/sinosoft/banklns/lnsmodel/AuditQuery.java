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
/*     */ public class AuditQuery
/*     */ {
/*     */   private String auditStartDate;
/*     */   private String auditEndDate;
/*     */   private String inputStartDate;
/*     */   private String inputEndDate;
/*     */   private String excelPath;
/*  27 */   private ArrayList<AuditQueryTableBean> lnpList = new ArrayList();
/*  28 */   private boolean dataNullFlag = false;
/*     */   private String filename;
/*     */   private String[][] data;
/*  95 */   private ExeSQL exsql = new ExeSQL();
/*     */   private IGlobalInput tempGI;
/*     */   private String sql;
/* 235 */   private boolean showErrorFlag = false;
/*     */ 
/*     */   public boolean isDataNullFlag()
/*     */   {
/*  31 */     return this.dataNullFlag;
/*     */   }
/*     */ 
/*     */   public void setDataNullFlag(boolean dataNullFlag) {
/*  35 */     this.dataNullFlag = dataNullFlag;
/*     */   }
/*     */ 
/*     */   public void init() {
/*  39 */     HttpSession session = (HttpSession)
/*  40 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  41 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*     */   }
/*     */ 
/*     */   public ArrayList<AuditQueryTableBean> getLnpList() {
/*  45 */     return this.lnpList;
/*     */   }
/*     */ 
/*     */   public void setLnpList(ArrayList<AuditQueryTableBean> resultList) {
/*  49 */     this.lnpList = resultList;
/*     */   }
/*     */ 
/*     */   public String getAuditStartDate() {
/*  53 */     return this.auditStartDate;
/*     */   }
/*     */ 
/*     */   public void setAuditStartDate(String auditStartDate) {
/*  57 */     this.auditStartDate = auditStartDate;
/*     */   }
/*     */ 
/*     */   public String getAuditEndDate() {
/*  61 */     return this.auditEndDate;
/*     */   }
/*     */ 
/*     */   public void setAuditEndDate(String auditEndDate) {
/*  65 */     this.auditEndDate = auditEndDate;
/*     */   }
/*     */ 
/*     */   public String getInputStartDate() {
/*  69 */     return this.inputStartDate;
/*     */   }
/*     */ 
/*     */   public void setInputStartDate(String inputStartDate) {
/*  73 */     this.inputStartDate = inputStartDate;
/*     */   }
/*     */ 
/*     */   public String getInputEndDate() {
/*  77 */     return this.inputEndDate;
/*     */   }
/*     */ 
/*     */   public void setInputEndDate(String inputEndDate) {
/*  81 */     this.inputEndDate = inputEndDate;
/*     */   }
/*     */ 
/*     */   public String getExcelPath() {
/*  85 */     return this.excelPath;
/*     */   }
/*     */ 
/*     */   public void setExcelPath(String excelPath) {
/*  89 */     this.excelPath = excelPath;
/*     */   }
/*     */ 
/*     */   public void query()
/*     */   {
/*  97 */     if (!this.lnpList.isEmpty())
/*  98 */       this.lnpList.clear();
/*  99 */     this.sql = 
/* 138 */       (" ROW_NUMBER() OVER (ORDER BY a.contno) AS [AUTOID], g.codename,op_1.OperationDate,op_2.OperationDate,op_5.OperationDate,op_1.operatorcode,a.contno,c.riskcode,op_3.OperationDate,op_4.OperationDate from lnpcont a left join (select e.OperationDate,e.contno,e.operatorcode from (select max(operationdate) as operationdate,max(id) as id from LNPOperationRecord f where f.Varc2 in('06','07')  and f.operation<>'2' group by f.contno) d,LNPOperationRecord e where d.operationdate=e.operationdate and d.id=e.id) op_1 on op_1.contno=a.contno left join (select min(g.OperationDate+' '+g.OperationTime) as OperationDate,g.contno from LNPOperationRecord g where g.Varc2 in ('03','04')  group by g.contno) op_2 on op_2.contno=a.contno left join (select max(p.OperationDate+' '+p.OperationTime) as OperationDate,p.contno from LNPOperationRecord p where p.Varc2='06' and p.operation<>'2' group by p.contno) op_5 on op_5.contno=a.contno left join (select min(r.OperationDate+' '+r.OperationTime) as OperationDate,r.contno from LNPOperationRecord r where r.Varc2='01'  group by r.contno) op_3 on op_3.contno=a.contno left join (select min(t.OperationDate+' '+t.OperationTime) as OperationDate,t.contno from LNPOperationRecord t where t.Varc2='02' and t.operation<>'2' group by t.contno) op_4 on op_4.contno=a.contno left join lnppol c on c.contno=a.contno and c.SubFlag='M' left join lnpcode g on g.code=a.managecom and g.codetype='lnpManageCom' where a.managecom like '" + 
/* 138 */       this.tempGI.ManageCom + "%'");
/*     */ 
/* 140 */     if ((this.auditStartDate != null) && (!"".equals(this.auditStartDate))) {
/* 141 */       this.sql = (this.sql + " and op_1.OperationDate>='" + this.auditStartDate + "' ");
/*     */     }
/* 143 */     if ((this.auditEndDate != null) && (!"".equals(this.auditEndDate))) {
/* 144 */       this.sql = (this.sql + " and op_1.OperationDate<='" + this.auditEndDate + "' ");
/*     */     }
/*     */ 
/* 147 */     if ((this.inputStartDate != null) && (!"".equals(this.inputStartDate))) {
/* 148 */       this.sql = (this.sql + " and substring(op_3.OperationDate,0,11)>='" + this.inputStartDate + "' ");
/*     */     }
/* 150 */     if ((this.inputEndDate != null) && (!"".equals(this.inputEndDate))) {
/* 151 */       this.sql = (this.sql + " and substring(op_3.OperationDate,0,11)<='" + this.inputEndDate + "' ");
/*     */     }
/* 153 */     this.lnpList.clear();
/* 154 */     querySql("select distinct top 200" + this.sql, false);
/*     */   }
/*     */ 
/*     */   public void report() {
/* 158 */     this.excelPath = printReportList();
/*     */   }
/*     */ 
/*     */   public String printReportList()
/*     */   {
/* 163 */     boolean flag = true;
/* 164 */     String currentDate = PubFun.getCurrentDate();
/*     */ 
/* 166 */     String templetFileName = "AuditQuery.xls";
/* 167 */     String reportFileName = this.tempGI.ManageCom + "_" + "AuditQuery_" + this.tempGI.Operator + 
/* 168 */       "_" + currentDate + ".xls";
/*     */ 
/* 170 */     this.filename = reportFileName;
/* 171 */     long usefullLifeSec = 0L;
/*     */ 
/* 175 */     String rvFNStartWith = this.tempGI.ManageCom + "_" + "AuditQuery";
/* 176 */     long invalidationSec = usefullLifeSec * 2L;
/*     */ 
/* 180 */     ReportHelper helper = new ReportHelper(templetFileName, reportFileName, 
/* 181 */       usefullLifeSec, rvFNStartWith, invalidationSec);
/* 182 */     ExcelInfo info = helper.getInfo();
/*     */ 
/* 184 */     if (!info.exists()) {
/* 185 */       flag = getPrintData(helper);
/*     */     }
/* 187 */     if (flag) {
/* 188 */       ExcelInfo info2 = helper.getInfo();
/* 189 */       String Excelpath = info2.getReportPath();
/* 190 */       return Excelpath;
/*     */     }
/*     */ 
/* 194 */     ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u65E0\u6CD5\u6253\u5370\u62A5\u8868\uFF0C\u6CA1\u6709\u67E5\u8BE2\u5230\u7B26\u5408\u6761\u4EF6\u7684\u6570\u636E\uFF01");
/* 195 */     return "";
/*     */   }
/*     */ 
/*     */   private boolean getPrintData(ReportHelper helper)
/*     */   {
/* 200 */     if (("".equals(this.sql)) || (this.sql == null))
/* 201 */       return false;
/* 202 */     this.data = null;
/* 203 */     querySql("select distinct " + this.sql, true);
/* 204 */     if ((this.data == null) || (this.data.length == 0)) return false;
/* 205 */     SimpleWorkbook workbook = helper.createWorkbook();
/*     */     try {
/* 207 */       if (this.data == null) {
/* 208 */         ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u8BB0\u5F55\u4E3A\u7A7A");
/*     */       }
/* 210 */       workbook.set("currentDate", PubFun.getCurrentDate());
/* 211 */       workbook.add(this.data);
/* 212 */       workbook = null;
/*     */     } catch (Exception e) {
/* 214 */       return false;
/*     */     } finally {
/* 216 */       if (workbook != null) {
/*     */         try {
/* 218 */           workbook.close();
/*     */         } catch (Exception e1) {
/* 220 */           e1.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isShowErrorFlag() {
/* 228 */     return this.showErrorFlag;
/*     */   }
/*     */ 
/*     */   public void setShowErrorFlag(boolean showErrorFlag) {
/* 232 */     this.showErrorFlag = showErrorFlag;
/*     */   }
/*     */ 
/*     */   private void querySql(String sql, boolean isExcelExport)
/*     */   {
/* 237 */     SSRS ssrs = this.exsql.execSQL(sql);
/* 238 */     System.out.println(sql);
/* 239 */     if ((ssrs.MaxRow >= 200) && (!isExcelExport)) {
/* 240 */       System.out.println("\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u8BF7\u60A8\u7EC6\u5316\u67E5\u8BE2\u6761\u4EF6\uFF01");
/* 241 */       ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", 
/* 242 */         "\u67E5\u8BE2\u8BB0\u5F55\u591A\u4E8E200\u6761\uFF0C\u8BF7\u60A8\u7EC6\u5316\u67E5\u8BE2\u6761\u4EF6\uFF01");
/* 243 */       this.showErrorFlag = true;
/*     */     } else {
/* 245 */       this.showErrorFlag = false;
/*     */     }
/* 247 */     if ((ssrs.MaxRow <= 0) && (!isExcelExport)) {
/* 248 */       this.dataNullFlag = true;
/* 249 */       System.out.println("\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C,\u8BF7\u5F55\u5165\u5176\u4ED6\u67E5\u8BE2\u6761\u4EF6\u91CD\u65B0\u67E5\u8BE2!");
/* 250 */       ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u67E5\u8BE2\u65E0\u8FD4\u56DE\u7ED3\u679C,\u8BF7\u5F55\u5165\u5176\u4ED6\u67E5\u8BE2\u6761\u4EF6\u91CD\u65B0\u67E5\u8BE2!");
/*     */     } else {
/* 252 */       this.dataNullFlag = false;
/* 253 */     }for (int i = 0; i < ssrs.MaxRow; i++)
/*     */       try
/*     */       {
/* 256 */         if (!isExcelExport)
/*     */         {
/* 259 */           AuditQueryTableBean bean = new AuditQueryTableBean();
/* 260 */           bean.manageCom = ssrs.GetText(i + 1, 2);
/* 261 */           bean.auditDate = ssrs.GetText(i + 1, 3);
/* 262 */           bean.auditStartDate = ssrs.GetText(i + 1, 4);
/* 263 */           bean.auditEndDate = ssrs.GetText(i + 1, 5);
/* 264 */           bean.auditUser = ssrs.GetText(i + 1, 6);
/* 265 */           bean.contNo = ssrs.GetText(i + 1, 7);
/* 266 */           bean.mainPolNo = ssrs.GetText(i + 1, 8);
/* 267 */           bean.inputDate = (ssrs.GetText(i + 1, 9).length() <= 10 ? ssrs.GetText(i + 1, 9) : ssrs.GetText(i + 1, 9).substring(0, 10));
/* 268 */           bean.inputStartDate = ssrs.GetText(i + 1, 9);
/* 269 */           bean.inputEndDate = ssrs.GetText(i + 1, 10);
/* 270 */           this.lnpList.add(bean);
/*     */         }
/*     */         else {
/* 273 */           if (i == 0) {
/* 274 */             this.data = new String[ssrs.MaxRow][11];
/*     */           }
/* 276 */           this.data[i][0] = ssrs.GetText(i + 1, 1);
/* 277 */           this.data[i][1] = ssrs.GetText(i + 1, 2);
/* 278 */           this.data[i][2] = ssrs.GetText(i + 1, 3);
/* 279 */           this.data[i][3] = ssrs.GetText(i + 1, 4);
/* 280 */           this.data[i][4] = ssrs.GetText(i + 1, 5);
/* 281 */           this.data[i][5] = ssrs.GetText(i + 1, 6);
/* 282 */           this.data[i][6] = ssrs.GetText(i + 1, 7);
/* 283 */           this.data[i][7] = ssrs.GetText(i + 1, 8);
/* 284 */           this.data[i][8] = (ssrs.GetText(i + 1, 9).length() <= 10 ? ssrs.GetText(i + 1, 9) : ssrs.GetText(i + 1, 9).substring(0, 10));
/* 285 */           this.data[i][9] = ssrs.GetText(i + 1, 9);
/* 286 */           this.data[i][10] = ssrs.GetText(i + 1, 10);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 291 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void download()
/*     */   {
/* 297 */     FacesContext context = FacesContext.getCurrentInstance();
/* 298 */     HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
/* 299 */     response.reset();
/* 300 */     response.setContentType("application/OCTET-STREAM");
/*     */     try {
/* 302 */       response.setHeader("Content-disposition", "attachment;filename=" + new String(this.filename.getBytes(), "iso-8859-1"));
/* 303 */       ReportHelper.download(response.getOutputStream(), this.excelPath);
/*     */     } catch (UnsupportedEncodingException e) {
/* 305 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 307 */       e.printStackTrace();
/*     */     } finally {
/* 309 */       context.responseComplete(); }  } 
/*     */   public class AuditQueryTableBean { private String manageCom;
/*     */     private String auditDate;
/*     */     private String auditStartDate;
/*     */     private String auditEndDate;
/*     */     private String auditUser;
/*     */     private String contNo;
/*     */     private String mainPolNo;
/*     */     private String inputDate;
/*     */     private String inputStartDate;
/*     */     private String inputEndDate;
/*     */ 
/*     */     public AuditQueryTableBean() {  } 
/* 325 */     public String getInputDate() { return this.inputDate; }
/*     */ 
/*     */     public void setInputDate(String inputDate) {
/* 328 */       this.inputDate = inputDate;
/*     */     }
/*     */     public String getInputStartDate() {
/* 331 */       return this.inputStartDate;
/*     */     }
/*     */     public void setInputStartDate(String inputStartDate) {
/* 334 */       this.inputStartDate = inputStartDate;
/*     */     }
/*     */     public String getInputEndDate() {
/* 337 */       return this.inputEndDate;
/*     */     }
/*     */     public void setInputEndDate(String inputEndDate) {
/* 340 */       this.inputEndDate = inputEndDate;
/*     */     }
/*     */     public String getContNo() {
/* 343 */       return this.contNo;
/*     */     }
/*     */     public void setContNo(String contNo) {
/* 346 */       this.contNo = contNo;
/*     */     }
/*     */     public String getManageCom() {
/* 349 */       return this.manageCom;
/*     */     }
/*     */     public void setManageCom(String manageCom) {
/* 352 */       this.manageCom = manageCom;
/*     */     }
/*     */     public String getAuditDate() {
/* 355 */       return this.auditDate;
/*     */     }
/*     */     public void setAuditDate(String auditDate) {
/* 358 */       this.auditDate = auditDate;
/*     */     }
/*     */     public String getAuditStartDate() {
/* 361 */       return this.auditStartDate;
/*     */     }
/*     */     public void setAuditStartDate(String auditStartDate) {
/* 364 */       this.auditStartDate = auditStartDate;
/*     */     }
/*     */     public String getAuditEndDate() {
/* 367 */       return this.auditEndDate;
/*     */     }
/*     */     public void setAuditEndDate(String auditEndDate) {
/* 370 */       this.auditEndDate = auditEndDate;
/*     */     }
/*     */     public String getAuditUser() {
/* 373 */       return this.auditUser;
/*     */     }
/*     */     public void setAuditUser(String auditUser) {
/* 376 */       this.auditUser = auditUser;
/*     */     }
/*     */     public String getMainPolNo() {
/* 379 */       return this.mainPolNo;
/*     */     }
/*     */     public void setMainPolNo(String mainPolNo) {
/* 382 */       this.mainPolNo = mainPolNo;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.AuditQuery
 * JD-Core Version:    0.6.0
 */