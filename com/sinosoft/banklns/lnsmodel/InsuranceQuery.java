/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCUWMasterDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPOperationRecordDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskAmountDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBnfBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCUWMasterBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentInfoBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPOperationRecordBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPaymentBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskAmountBSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPTransRcorsSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBnfBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBonusInfoBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCUWMasterBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPContBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPOperationRecordBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPOperationRecordSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPaymentBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPaymentSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPersonBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskAmountBSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.DBConn;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.Reflections;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import com.sinosoft.map.common.MainListener;
/*      */ import com.sinosoft.map.ec.utility.ECPubFun;
/*      */ import com.sinosoft.map.lis.excel.ExcelInfo;
/*      */ import com.sinosoft.map.lis.excel.ReportHelper;
/*      */ import com.sinosoft.map.lis.excel.SimpleWorkbook;
/*      */ import com.sinosoft.map.lis.pubfun.PubFun;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.sql.Connection;
/*      */ import java.sql.DriverManager;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.faces.model.SelectItem;
/*      */ import javax.servlet.http.HttpServletResponse;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class InsuranceQuery
/*      */ {
/*  113 */   private IGlobalInput tempGI = null;
/*      */ 
/*  115 */   private LNPContSchema queryContSch = new LNPContSchema();
/*      */   private String state;
/*      */   private String startDate;
/*      */   private String endDate;
/*      */   private String auditUser;
/*      */   private String auditUserID;
/*      */   private String kindcode;
/*      */   private String riskcode;
/*      */   private String entryUserID;
/*  124 */   private List<SelectItem> lnpManageComList = new ArrayList();
/*  125 */   private List<SelectItem> lnpStateList = new ArrayList();
/*  126 */   private List<SelectItem> kindcodeList = new ArrayList();
/*      */   private String manageCom;
/*      */   private String remark;
/*      */   private String excelPath;
/*      */   private String filename;
/*      */   private String[][] data;
/*  133 */   private static int totalSize = 200;
/*      */   private String auditDate;
/*      */   private String prem;
/*      */   private String contNo;
/*      */   private String message;
/*      */   private boolean alertFlag;
/*      */   private boolean cancelAbilityFlag;
/*      */   private BankPolicyState policyState;
/*  147 */   private boolean showErrorFlag = false;
/*      */ 
/*  150 */   private List<LNPContBean> lnpList = new ArrayList();
/*      */ 
/*  153 */   private static Map<String, String> ContStateMap = new HashMap();
/*      */ 
/*  155 */   private Map<String, String> ContRiskMap = new HashMap();
/*      */ 
/*  157 */   private Map<String, String> ContAgentComMap = new HashMap();
/*      */ 
/*  445 */   public String sql = null;
/*      */ 
/*  698 */   private boolean lock = true;
/*      */   private String rmvPolicy;
/*      */   private String rmvState;
/*      */ 
/*      */   public String getExcelPath()
/*      */   {
/*  169 */     return this.excelPath;
/*      */   }
/*      */ 
/*      */   public void setExcelPath(String excelPath) {
/*  173 */     this.excelPath = excelPath;
/*      */   }
/*      */ 
/*      */   public void report() {
/*  177 */     System.out.println("======== get report ===");
/*  178 */     DBConn con = DBConnPool.getConnection();
/*  179 */     this.excelPath = "";
/*  180 */     this.excelPath = printReportList(con);
/*      */   }
/*      */ 
/*      */   public String printReportList(DBConn con) {
/*  184 */     boolean flag = true;
/*  185 */     String currentDate = PubFun.getCurrentDate();
/*      */ 
/*  187 */     String templetFileName = "InsuranceQuery.xls";
/*  188 */     String reportFileName = ((this.manageCom == null) || ("".equals(this.manageCom)) ? this.tempGI.Operator : this.manageCom) + "_" + "InsuranceQuery_" + this.tempGI.Operator + 
/*  189 */       "_" + currentDate + ".xls";
/*  190 */     this.filename = reportFileName;
/*  191 */     long usefullLifeSec = 0L;
/*      */ 
/*  195 */     String rvFNStartWith = ((this.manageCom == null) || ("".equals(this.manageCom)) ? this.tempGI.Operator : this.manageCom) + "_" + "InsuranceQuery";
/*  196 */     long invalidationSec = usefullLifeSec * 2L;
/*      */ 
/*  200 */     ReportHelper helper = new ReportHelper(templetFileName, reportFileName, 
/*  201 */       usefullLifeSec, rvFNStartWith, invalidationSec);
/*  202 */     ExcelInfo info = helper.getInfo();
/*      */ 
/*  204 */     if (!info.exists()) {
/*  205 */       flag = getPrintData(con, helper);
/*      */     }
/*  207 */     if (flag) {
/*  208 */       ExcelInfo info2 = helper.getInfo();
/*  209 */       String Excelpath = info2.getReportPath();
/*  210 */       return Excelpath;
/*      */     }
/*      */ 
/*  213 */     ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u65E0\u6CD5\u6253\u5370\u62A5\u8868\uFF0C\u6CA1\u6709\u67E5\u8BE2\u5230\u7B26\u5408\u6761\u4EF6\u7684\u6570\u636E\uFF01");
/*  214 */     return "";
/*      */   }
/*      */ 
/*      */   private boolean getPrintData(DBConn con, ReportHelper helper)
/*      */   {
/*  221 */     if (("".equals(this.sql)) || (this.sql == null)) {
/*  222 */       return false;
/*      */     }
/*  224 */     querySql(con, "select * from " + this.sql, true);
/*  225 */     if ((this.data == null) || (this.data.length == 0)) return false;
/*  226 */     SimpleWorkbook workbook = helper.createWorkbook();
/*      */     try {
/*  228 */       if (this.data == null) {
/*  229 */         ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u8BB0\u5F55\u4E3A\u7A7A");
/*      */       }
/*  231 */       workbook.set("currentDate", PubFun.getCurrentDate());
/*  232 */       workbook.add(this.data);
/*  233 */       workbook = null;
/*      */     } catch (Exception e) {
/*  235 */       return false;
/*      */     } finally {
/*  237 */       if (workbook != null) {
/*      */         try {
/*  239 */           workbook.close();
/*      */         } catch (Exception e1) {
/*  241 */           e1.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*  245 */     return true;
/*      */   }
/*      */ 
/*      */   public void download() {
/*  249 */     FacesContext context = FacesContext.getCurrentInstance();
/*  250 */     HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
/*  251 */     response.reset();
/*  252 */     response.setContentType("application/OCTET-STREAM");
/*      */     try {
/*  254 */       response.setHeader("Content-disposition", "attachment;filename=" + new String(this.filename.getBytes(), "iso-8859-1"));
/*  255 */       ReportHelper.download(response.getOutputStream(), this.excelPath);
/*      */     } catch (UnsupportedEncodingException e) {
/*  257 */       e.printStackTrace();
/*      */     } catch (IOException e) {
/*  259 */       e.printStackTrace();
/*      */     } finally {
/*  261 */       context.responseComplete();
/*      */     }
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getLnpManageComList() {
/*  266 */     HttpSession session = (HttpSession)
/*  267 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  268 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*      */ 
/*  270 */     if (this.tempGI == null) {
/*  271 */       this.message = "\u767B\u5F55\u4EBA\u5458\u4FE1\u606F\u4E22\u5931\uFF0C\u8BF7\u91CD\u65B0\u767B\u9646\uFF01";
/*  272 */       this.alertFlag = true;
/*  273 */       return null;
/*      */     }
/*  275 */     if (this.lnpManageComList != null) {
/*  276 */       this.lnpManageComList.clear();
/*      */     }
/*  278 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  280 */     String sql = "select code,codename from lnpcode where codetype='lnpManageCom' and code like '" + this.tempGI.ManageCom + "%' order by code";
/*  281 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  282 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  283 */       this.lnpManageComList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*  285 */     return this.lnpManageComList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getKindcodeList()
/*      */   {
/*  291 */     HttpSession session = (HttpSession)
/*  292 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  293 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*      */ 
/*  295 */     if (this.tempGI == null) {
/*  296 */       this.message = "\u767B\u5F55\u4EBA\u5458\u4FE1\u606F\u4E22\u5931\uFF0C\u8BF7\u91CD\u65B0\u767B\u9646\uFF01";
/*  297 */       this.alertFlag = true;
/*  298 */       return null;
/*      */     }
/*  300 */     if (this.kindcodeList != null) {
/*  301 */       this.kindcodeList.clear();
/*      */     }
/*  303 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  305 */     String sql = "select code,codename from lnpcode where codetype='lnpRiskType' order by code";
/*  306 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  307 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  308 */       this.kindcodeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*  310 */     return this.kindcodeList;
/*      */   }
/*      */ 
/*      */   public void setKindcodeList(List<SelectItem> kindcodeList) {
/*  314 */     this.kindcodeList = kindcodeList;
/*      */   }
/*      */ 
/*      */   public void setLnpManageComList(List<SelectItem> lnpManageComList) {
/*  318 */     this.lnpManageComList = lnpManageComList;
/*      */   }
/*      */ 
/*      */   public String getAuditUserID() {
/*  322 */     return this.auditUserID;
/*      */   }
/*      */ 
/*      */   public void setAuditUserID(String auditUserID) {
/*  326 */     this.auditUserID = auditUserID;
/*      */   }
/*      */ 
/*      */   public String getKindcode() {
/*  330 */     return this.kindcode;
/*      */   }
/*      */ 
/*      */   public void setKindcode(String kindcode) {
/*  334 */     this.kindcode = kindcode;
/*      */   }
/*      */ 
/*      */   public String getRiskcode() {
/*  338 */     return this.riskcode;
/*      */   }
/*      */ 
/*      */   public void setRiskcode(String riskcode) {
/*  342 */     this.riskcode = riskcode;
/*      */   }
/*      */ 
/*      */   public String getEntryUserID() {
/*  346 */     return this.entryUserID;
/*      */   }
/*      */ 
/*      */   public void setEntryUserID(String entryUserID) {
/*  350 */     this.entryUserID = entryUserID;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getLnpStateList() {
/*  354 */     HttpSession session = (HttpSession)
/*  355 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  356 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*      */ 
/*  358 */     if (this.tempGI == null) {
/*  359 */       this.message = "\u767B\u5F55\u4EBA\u5458\u4FE1\u606F\u4E22\u5931\uFF0C\u8BF7\u91CD\u65B0\u767B\u9646\uFF01";
/*  360 */       this.alertFlag = true;
/*  361 */       return null;
/*      */     }
/*  363 */     if (this.lnpStateList != null) {
/*  364 */       this.lnpStateList.clear();
/*      */     }
/*  366 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  368 */     String sql = "select code,codename from lnpcode where codetype='lnpLangState'  order by code";
/*  369 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  370 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  371 */       this.lnpStateList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*  373 */     return this.lnpStateList;
/*      */   }
/*      */ 
/*      */   public void setLnpStateList(List<SelectItem> lnpStateList) {
/*  377 */     this.lnpStateList = lnpStateList;
/*      */   }
/*      */ 
/*      */   public String getManageCom() {
/*  381 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String manageCom) {
/*  385 */     this.manageCom = manageCom;
/*      */   }
/*      */ 
/*      */   public String getRemark() {
/*  389 */     return this.remark;
/*      */   }
/*      */ 
/*      */   public void setRemark(String remark) {
/*  393 */     this.remark = remark;
/*      */   }
/*      */ 
/*      */   public String getAuditUser() {
/*  397 */     return this.auditUser;
/*      */   }
/*      */ 
/*      */   public void setAuditUser(String auditUser) {
/*  401 */     this.auditUser = auditUser;
/*      */   }
/*      */ 
/*      */   public String getAuditDate() {
/*  405 */     return this.auditDate;
/*      */   }
/*      */ 
/*      */   public void setAuditDate(String auditDate) {
/*  409 */     this.auditDate = auditDate;
/*      */   }
/*      */ 
/*      */   public void init()
/*      */   {
/*  416 */     System.out.println("--  InsuranceQuery init --");
/*  417 */     this.queryContSch = new LNPContSchema();
/*  418 */     this.lnpList = new ArrayList();
/*  419 */     this.state = null;
/*  420 */     this.auditUserID = null;
/*  421 */     this.entryUserID = null;
/*  422 */     this.kindcode = null;
/*  423 */     this.riskcode = null;
/*  424 */     this.startDate = null;
/*  425 */     this.endDate = null;
/*  426 */     this.auditUser = null;
/*  427 */     this.manageCom = null;
/*  428 */     this.remark = null;
/*      */ 
/*  430 */     HttpSession session = (HttpSession)
/*  431 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  432 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*      */ 
/*  434 */     if (this.tempGI == null) {
/*  435 */       this.message = "\u767B\u5F55\u4EBA\u5458\u4FE1\u606F\u4E22\u5931\uFF0C\u8BF7\u91CD\u65B0\u767B\u9646\uFF01";
/*  436 */       this.alertFlag = true;
/*  437 */       return;
/*      */     }
/*      */ 
/*  440 */     this.cancelAbilityFlag = this.tempGI.LNPCancel;
/*      */   }
/*      */ 
/*      */   public void query()
/*      */   {
/*  447 */     DBConn con = DBConnPool.getConnection();
/*  448 */     this.sql = "";
/*      */ 
/*  450 */     System.out.println("-- query state--");
/*  451 */     this.alertFlag = false;
/*  452 */     this.showErrorFlag = false;
/*  453 */     if (this.lnpList != null) {
/*  454 */       this.lnpList.clear();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  459 */       if (this.tempGI == null) {
/*  460 */         this.message = "\u8BE5\u767B\u5F55\u4EBA\u5458\u6CA1\u6709\u6295\u4FDD\u4E66\u67E5\u8BE2\u6743\u9650\uFF01";
/*  461 */         this.alertFlag = true;
/*  462 */         return;
/*      */       }
/*      */ 
/*  465 */       this.sql = (this.sql + " lnpcont c where  c.signcom  like '" + this.tempGI.ManageCom + "%' " + " and c.SaleChnlDetail='3' ");
/*      */ 
/*  467 */       this.sql += editSql();
/*  468 */       this.sql += " order by c.makedate desc,c.maketime desc";
/*  469 */       querySql(con, "select * from " + this.sql, false);
/*      */     } catch (RuntimeException e) {
/*  471 */       e.printStackTrace();
/*      */     }
/*      */ 
/*  474 */     System.out.println("-- query end--");
/*      */   }
/*      */ 
/*      */   private void querySql(DBConn con, String sql, boolean isExcelExport)
/*      */   {
/*  479 */     System.out.println("--->execSQL:" + sql);
/*  480 */     LNPContDB db = new LNPContDB(con);
/*  481 */     LNPContSet reSet = db.executeQuery(sql);
/*  482 */     if (reSet.size() > 0)
/*      */     {
/*  484 */       if (reSet.size() >= totalSize)
/*      */       {
/*  486 */         ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u67E5\u8BE2\u7ED3\u679C\u5171\u3010" + reSet.size() + "\u3011\u6761\uFF0C\u53EA\u663E\u793A\u524D\u3010" + totalSize + "\u3011\u6761\uFF01");
/*  487 */         this.showErrorFlag = true;
/*      */       } else {
/*  489 */         System.out.println("\u6B64\u65F6\u4E00\u5171\u6709" + reSet.size() + "\u6761\u8BB0\u5F55\uFF01");
/*      */       }
/*  491 */       getRiskString(reSet, con);
/*  492 */       getNetcode(reSet, con);
/*  493 */       int lastTalSize = reSet.size() > totalSize ? totalSize : reSet.size();
/*  494 */       if (isExcelExport) {
/*  495 */         lastTalSize = reSet.size();
/*  496 */         this.data = new String[lastTalSize][14];
/*      */       }
/*  498 */       LNPContBean temp = new LNPContBean();
/*  499 */       for (int i = 1; i <= lastTalSize; i++) {
/*  500 */         temp = new LNPContBean();
/*  501 */         LNPContSchema schema = reSet.get(i);
/*  502 */         temp.setSchema(schema);
/*  503 */         System.out.println("idx:" + i + "----contno:" + temp.getSchema().getContNo());
/*  504 */         temp.setRiskList((String)this.ContRiskMap.get(temp.getSchema().getContNo()));
/*  505 */         temp.setShowState((String)ContStateMap.get(temp.getSchema().getState()));
/*  506 */         temp.setNetcode((String)this.ContAgentComMap.get(temp.getSchema().getContNo()));
/*  507 */         temp.setDisplay((this.cancelAbilityFlag) && (!"06".equals(temp.getSchema().getState())) ? "" : "none");
/*  508 */         if (isExcelExport) {
/*  509 */           this.data[(i - 1)][0] = i;
/*  510 */           this.data[(i - 1)][1] = temp.getSignCom();
/*  511 */           this.data[(i - 1)][2] = schema.getMakeDate();
/*  512 */           this.data[(i - 1)][3] = schema.getContNo();
/*  513 */           this.data[(i - 1)][4] = temp.getRiskList();
/*  514 */           this.data[(i - 1)][5] = schema.getAppntName();
/*  515 */           this.data[(i - 1)][6] = schema.getAppntIDNo();
/*  516 */           this.data[(i - 1)][7] = schema.getInsuredName();
/*  517 */           this.data[(i - 1)][8] = schema.getInsuredIDNo();
/*  518 */           this.data[(i - 1)][9] = temp.getPrem();
/*  519 */           this.data[(i - 1)][10] = temp.getNetcode();
/*  520 */           this.data[(i - 1)][11] = temp.getShowState();
/*  521 */           this.data[(i - 1)][12] = schema.getInputOperator();
/*  522 */           this.data[(i - 1)][13] = schema.getModifyDate();
/*      */         }
/*      */         else
/*      */         {
/*  526 */           this.lnpList.add(temp);
/*      */         }
/*      */       }
/*  528 */     } else if (!isExcelExport) {
/*  529 */       ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u6CA1\u6709\u7B26\u5408\u6761\u4EF6\u7684\u7ED3\u679C\uFF01");
/*  530 */       this.alertFlag = true;
/*      */     }
/*      */   }
/*      */ 
/*      */   private String getStateFromMap(LNPContSchema lnpcontschema)
/*      */   {
/*  538 */     String sql = "select codename from lnpcode where (codetype='lnpLangState' and code='" + 
/*  539 */       lnpcontschema.getState() + "') order by codetype";
/*  540 */     ExeSQL tExeSQL = new ExeSQL();
/*  541 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*  542 */     return tSSRS.GetText(1, 1);
/*      */   }
/*      */ 
/*      */   private void getNetcode(LNPContSet contSet, DBConn con)
/*      */   {
/*  547 */     this.ContAgentComMap.clear();
/*  548 */     if ((contSet != null) && (contSet.size() > 0)) {
/*  549 */       StringBuffer contnolist = new StringBuffer();
/*  550 */       for (int i = 1; i <= contSet.size(); i++) {
/*  551 */         if (i != contSet.size())
/*  552 */           contnolist.append("'" + contSet.get(i).getContNo() + "',");
/*      */         else {
/*  554 */           contnolist.append("'" + contSet.get(i).getContNo() + "'");
/*      */         }
/*      */       }
/*  557 */       String sql = "select contno,p2 from lnpagentinfo  where contno in (" + contnolist.toString() + ")";
/*  558 */       System.out.println("-->query contnoUNIONrisk sql:" + sql);
/*  559 */       ExeSQL tExeSQL = new ExeSQL(con);
/*  560 */       SSRS tSSRS = tExeSQL.execSQL(sql);
/*  561 */       for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  562 */         this.ContAgentComMap.put(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2));
/*      */       }
/*      */     }
/*      */ 
/*  566 */     System.out.println("-----------------------------------------------------");
/*  567 */     Set set = this.ContAgentComMap.entrySet();
/*  568 */     for (Iterator it = set.iterator(); it.hasNext(); ) {
/*  569 */       Map.Entry entry = (Map.Entry)it.next();
/*  570 */       System.out.println("\u4EE3\u7406\u7F51\u70B9\u6620\u5C04:" + (String)entry.getKey() + "--:--" + (String)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */   private void getRiskString(LNPContSet contSet, DBConn con)
/*      */   {
/*  577 */     this.ContRiskMap.clear();
/*  578 */     if ((contSet != null) && (contSet.size() > 0)) {
/*  579 */       StringBuffer contnolist = new StringBuffer();
/*  580 */       for (int i = 1; i <= contSet.size(); i++) {
/*  581 */         if (i != contSet.size())
/*  582 */           contnolist.append("'" + contSet.get(i).getContNo() + "',");
/*      */         else {
/*  584 */           contnolist.append("'" + contSet.get(i).getContNo() + "'");
/*      */         }
/*      */       }
/*  587 */       ExeSQL tExeSQL = new ExeSQL(con);
/*  588 */       String riskSQL1 = "select riskcode,subflag,contno from lnppol a where contno in (" + contnolist.toString() + ")";
/*  589 */       System.out.println("-->query contnoUNIONrisk sql:" + riskSQL1);
/*  590 */       SSRS tSSRS1 = tExeSQL.execSQL(riskSQL1);
/*  591 */       for (int i = 1; i <= tSSRS1.MaxRow; i++) {
/*  592 */         if (this.ContRiskMap.containsKey(tSSRS1.GetText(i, 3))) {
/*  593 */           String tRiskCode = (String)this.ContRiskMap.get(tSSRS1.GetText(i, 3));
/*  594 */           tRiskCode = tRiskCode + "," + tSSRS1.GetText(i, 1);
/*  595 */           this.ContRiskMap.put(tSSRS1.GetText(i, 3), tRiskCode);
/*      */         }
/*      */         else {
/*  598 */           this.ContRiskMap.put(tSSRS1.GetText(i, 3), tSSRS1.GetText(i, 1));
/*      */         }
/*      */       }
/*      */     }
/*  602 */     System.out.println("-----------------------------------------------------");
/*  603 */     Set set = this.ContRiskMap.entrySet();
/*  604 */     for (Iterator it = set.iterator(); it.hasNext(); ) {
/*  605 */       Map.Entry entry = (Map.Entry)it.next();
/*  606 */       System.out.println("\u4FDD\u5355\u9669\u79CD\u6620\u5C04:" + (String)entry.getKey() + "--:--" + (String)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */   private String editSql()
/*      */   {
/*  613 */     String sql = "";
/*      */ 
/*  619 */     if ((this.queryContSch.getContNo() != null) && (!this.queryContSch.getContNo().equals(""))) {
/*  620 */       sql = sql + " and c.contno like '%" + this.queryContSch.getContNo().toUpperCase() + "%' ";
/*      */     }
/*      */ 
/*  623 */     if ((this.state != null) && (!this.state.equals(""))) {
/*  624 */       sql = sql + " and c.state = '" + this.state + "' ";
/*      */     }
/*      */ 
/*  631 */     if ((this.queryContSch.getInsuredName() != null) && (!this.queryContSch.getInsuredName().equals(""))) {
/*  632 */       sql = sql + " and c.insuredname like '%" + this.queryContSch.getInsuredName() + "%' ";
/*      */     }
/*      */ 
/*  635 */     if ((this.queryContSch.getInsuredIDNo() != null) && (!this.queryContSch.getInsuredIDNo().equals(""))) {
/*  636 */       sql = sql + " and c.insuredidno like '%" + this.queryContSch.getInsuredIDNo() + "%' ";
/*      */     }
/*      */ 
/*  644 */     if ((this.startDate != null) && (!this.startDate.equals(""))) {
/*  645 */       sql = sql + " and c.makedate >= '" + this.startDate + "' ";
/*      */     }
/*      */ 
/*  648 */     if ((this.endDate != null) && (!this.endDate.equals(""))) {
/*  649 */       sql = sql + " and c.makedate <= '" + this.endDate + "' ";
/*      */     }
/*      */ 
/*  653 */     if ((this.manageCom != null) && (!"".equals(this.manageCom))) {
/*  654 */       sql = sql + " and c.managecom = '" + this.manageCom.toUpperCase() + "'";
/*      */     }
/*      */ 
/*  657 */     if ((this.entryUserID != null) && (!this.entryUserID.equals(""))) {
/*  658 */       sql = sql + " and c.contno in (select d.contno from lnpcont d where d.inputoperator = '" + 
/*  660 */         this.entryUserID + "' and d.state='01' " + 
/*  661 */         "union " + 
/*  662 */         "select e.contno from LNPOperationRecord e " + 
/*  663 */         "where e.Operatorcode='" + this.entryUserID + "'" + 
/*  664 */         "and  e.id=(select min(f.id) from LNPOperationRecord f where f.Varc2='02' and f.contno = e.contno ))";
/*      */     }
/*      */ 
/*  670 */     if ((this.auditUserID != null) && (!this.auditUserID.equals(""))) {
/*  671 */       sql = sql + " and c.contno in (select contno from lnpcont  where inputoperator = '" + this.auditUserID + "'  and state <>'01')";
/*      */     }
/*      */ 
/*  677 */     if ((this.kindcode != null) && (!this.kindcode.equals(""))) {
/*  678 */       sql = sql + " and c.contno in (select contno from lnppol where KindCode = '" + this.kindcode + "')";
/*      */     }
/*      */ 
/*  681 */     if ((this.riskcode != null) && (!this.riskcode.equals(""))) {
/*  682 */       sql = sql + " and c.contno in (select contno from lnppol where riskcode like '%" + this.riskcode + "%' and subflag='M')";
/*      */     }
/*      */ 
/*  695 */     return sql;
/*      */   }
/*      */ 
/*      */   public boolean isLock()
/*      */   {
/*  700 */     return this.lock;
/*      */   }
/*      */ 
/*      */   public void setLock(boolean lock) {
/*  704 */     this.lock = lock;
/*      */   }
/*      */ 
/*      */   public void goToEdit() {
/*  708 */     Boolean queryflag = Boolean.valueOf(true);
/*  709 */     System.out.println("++++++\u8FDB\u5165gotoedit");
/*      */     try {
/*  711 */       Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/*  712 */       this.contNo = ((String)requestMap.get("chooseContNo"));
/*  713 */       LNPContSchema lnpContSch = getMyLNPContByContNo(this.contNo);
/*  714 */       String date = PubFun.getCurrentDate();
/*  715 */       String time = PubFun.getCurrentTime();
/*  716 */       System.out.println("----\u9875\u9762\u8DF3\u8F6CcontNo" + this.contNo + "----");
/*  717 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  718 */       IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*  719 */       session.setAttribute("ContNo", this.contNo);
/*      */ 
/*  721 */       if ((tempGI.LNPRole == "0") || (tempGI.LNPRole.equals("0"))) {
/*  722 */         if (lnpContSch.getState().equals("01"))
/*  723 */           queryflag = Boolean.valueOf(true);
/*      */         else {
/*  725 */           queryflag = Boolean.valueOf(false);
/*      */         }
/*      */       }
/*      */ 
/*  729 */       if ((tempGI.LNPRole == "1") || (tempGI.LNPRole.equals("1"))) {
/*  730 */         if ((lnpContSch.getState().equals("01")) || (lnpContSch.getState().equals("05")) || (lnpContSch.getState().equals("06")))
/*  731 */           queryflag = Boolean.valueOf(false);
/*      */         else {
/*  733 */           queryflag = Boolean.valueOf(true);
/*      */         }
/*      */       }
/*      */ 
/*  737 */       if ((tempGI.LNPRole == "2") || (tempGI.LNPRole.equals("2"))) {
/*  738 */         if ((lnpContSch.getState().equals("05")) || (lnpContSch.getState().equals("06"))) {
/*  739 */           queryflag = Boolean.valueOf(false);
/*      */         }
/*      */         else {
/*  742 */           queryflag = Boolean.valueOf(true);
/*      */         }
/*      */       }
/*      */ 
/*  746 */       session.setAttribute("Queryflag", queryflag);
/*      */ 
/*  748 */       System.out.println("\u663E\u793A\u5F53\u524D\u662F\u5426\u53EF\u7F16\u8F91\u7684\u72B6\u6001" + queryflag);
/*  749 */       if (queryflag.booleanValue())
/*      */       {
/*  751 */         System.out.println("contno\u7684\u503C\u4E3A----------" + this.contNo);
/*      */ 
/*  753 */         String sqlTemp = "select AgentCode from lnpcont where contno='" + this.contNo + "'";
/*  754 */         ExeSQL tempExe = new ExeSQL();
/*  755 */         SSRS tempSSRS = tempExe.execSQL(sqlTemp);
/*      */ 
/*  757 */         if ((tempSSRS.GetText(1, 1) != null) && (!tempSSRS.GetText(1, 1).equals(""))) {
/*  758 */           if (tempGI.Operator.equals(tempSSRS.GetText(1, 1))) {
/*  759 */             this.lock = false;
/*      */ 
/*  761 */             sqlTemp = "select top 20 sessionid from MWebLoginLog where usercode='" + tempGI.Operator + "' order by id desc";
/*  762 */             SSRS tempSSRS2 = tempExe.execSQL(sqlTemp);
/*  763 */             for (int i = 2; i < tempSSRS2.MaxRow; i++) {
/*  764 */               if (!MainListener.sessionMap.containsKey(tempSSRS2.GetText(i, 1))) break;
/*  765 */               ((HttpSession)MainListener.sessionMap.get(tempSSRS2.GetText(i, 1))).setAttribute("CONTLOCK", "UNLOCKED");
/*      */             }
/*      */ 
/*  770 */             this.policyState = new BankPolicyState();
/*  771 */             this.policyState.savePolicyState(this.contNo, lnpContSch.getState(), "2", date, time);
/*      */           }
/*      */           else
/*      */           {
/*  775 */             this.lock = true;
/*  776 */             ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u5F53\u524D\u5355\u88AB" + tempSSRS.GetText(1, 1) + "\u7528\u6237\u4F7F\u7528\uFF01");
/*      */           }
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  782 */           System.out.println("\u6B64\u65F6\u4FDD\u5355\u672A\u88AB\u52A0\u9501");
/*      */ 
/*  784 */           this.policyState = new BankPolicyState();
/*  785 */           this.policyState.savePolicyState(this.contNo, lnpContSch.getState(), "2", date, time);
/*  786 */           this.lock = false;
/*      */         }
/*  788 */         System.out.println("\u5F53\u524Dlock\u7684\u503C=======" + this.lock);
/*  789 */         if (!this.lock)
/*      */         {
/*  791 */           lnpContSch.setAgentCode(tempGI.Operator);
/*  792 */           PubSubmit ps = new PubSubmit();
/*  793 */           MMap map = new MMap();
/*  794 */           map.put(lnpContSch, "UPDATE");
/*  795 */           VData vd = new VData();
/*  796 */           vd.add(map);
/*  797 */           if (!ps.submitData(vd, "")) {
/*  798 */             System.out.println("\u7F16\u8F91\u4EBA\u5458\u4FDD\u5B58\u5931\u8D25");
/*  799 */             ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "\u7F16\u8F91\u4EBA\u5458\u4FDD\u5B58\u5931\u8D25\uFF01");
/*      */           } else {
/*  801 */             System.out.println("\u7F16\u8F91\u4EBA\u5458\u4FDD\u5B58\u6210\u529F");
/*      */           }
/*      */ 
/*  804 */           session.setAttribute("CONTLOCK", "LOCKED");
/*      */         }
/*      */ 
/*  807 */         MainListener.sessionMap.put(session.getId(), session);
/*      */       }
/*      */       else {
/*  810 */         this.lock = false;
/*      */       }
/*      */     } catch (RuntimeException e) {
/*  813 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private LNPContSchema getMyLNPContByContNo(String contNo2) {
/*  818 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  819 */     LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
/*  820 */     return aLNPContSchema;
/*      */   }
/*      */ 
/*      */   public void RemovePolicy()
/*      */   {
/*      */     try
/*      */     {
/*  829 */       System.out.println("will remove policy:" + this.rmvPolicy + "|state:" + this.rmvState);
/*  830 */       if (!"06".equals(this.rmvState))
/*      */       {
/*  833 */         String curDate = PubFun.getCurrentDate();
/*  834 */         String curTime = PubFun.getCurrentTime();
/*      */ 
/*  836 */         VData cInputData = new VData();
/*  837 */         MMap mMap = new MMap();
/*  838 */         PubSubmit pubSubmit = new PubSubmit();
/*  839 */         Connection conn = null;
/*      */         try {
/*  841 */           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/*      */         }
/*      */         catch (ClassNotFoundException e1) {
/*  844 */           e1.printStackTrace();
/*  845 */           return;
/*      */         }
/*      */ 
/*  849 */         if (conn == null)
/*      */           try
/*      */           {
/*  852 */             conn = DriverManager.getConnection("jdbc:sqlserver://mdes-D.metlifechina.local\\SQLEXPRESS:1433;databasename=MDES", "mdesadmin", "password1");
/*      */           }
/*      */           catch (SQLException e1) {
/*  855 */             e1.printStackTrace();
/*  856 */             CError.buildErr(this, "\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25");
/*  857 */             return;
/*      */           }
/*  859 */         conn.setAutoCommit(false);
/*  860 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  861 */         String serialNumber = maxNoMap.CreateMaxNo1(conn, "OPERTRACENO", "");
/*  862 */         if (serialNumber == null) {
/*  863 */           conn.rollback();
/*  864 */           conn.close();
/*  865 */           return;
/*      */         }
/*      */ 
/*  868 */         LNPContDB tLnpContDB = new LNPContDB(conn);
/*  869 */         String sql = "select * from LNPCont where ContNo='" + this.rmvPolicy + "'";
/*  870 */         LNPContSet tLnpContSet = tLnpContDB.executeQuery(sql);
/*  871 */         LNPContBSet tLnpContBSet = new LNPContBSet();
/*  872 */         LNPContBSchema tLnpContBSchema = new LNPContBSchema();
/*  873 */         tLnpContBSet.add(tLnpContBSchema);
/*  874 */         Reflections reflections = new Reflections();
/*  875 */         reflections.transFields(tLnpContBSet, tLnpContSet);
/*  876 */         for (int i = 1; i <= tLnpContBSet.size(); i++) {
/*  877 */           tLnpContBSet.get(i).setEdorNo(serialNumber);
/*  878 */           tLnpContBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  880 */         tLnpContBSchema.setEdorNo(serialNumber);
/*  881 */         mMap.put(tLnpContSet, "DELETE");
/*  882 */         mMap.put(tLnpContBSet, "INSERT");
/*      */ 
/*  884 */         LNPPolDB tLNPPolDB = new LNPPolDB(conn);
/*  885 */         sql = "select * from LNPPol where ContNo='" + this.rmvPolicy + "'";
/*  886 */         LNPPolSet tLnpPolSet = tLNPPolDB.executeQuery(sql);
/*  887 */         LNPPolBSet tLnpPolBSet = new LNPPolBSet();
/*  888 */         LNPPolBSchema tLnpPolBSchema = new LNPPolBSchema();
/*  889 */         tLnpPolBSet.add(tLnpPolBSchema);
/*  890 */         reflections.transFields(tLnpPolBSet, tLnpPolSet);
/*  891 */         for (int i = 1; i <= tLnpPolBSet.size(); i++) {
/*  892 */           tLnpPolBSet.get(i).setEdorNo(serialNumber);
/*  893 */           tLnpPolBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  895 */         mMap.put(tLnpPolSet, "DELETE");
/*  896 */         mMap.put(tLnpPolBSet, "INSERT");
/*      */ 
/*  898 */         LNPBonusInfoDB tLnpBonusInfoDB = new LNPBonusInfoDB(conn);
/*  899 */         sql = "select * from LNPBonusInfo where ContNo='" + this.rmvPolicy + "'";
/*  900 */         LNPBonusInfoSet tBonusInfoSet = tLnpBonusInfoDB.executeQuery(sql);
/*  901 */         LNPBonusInfoBSet tBonusInfoBSet = new LNPBonusInfoBSet();
/*  902 */         LNPBonusInfoBSchema tLnpBonusInfoBSchema = new LNPBonusInfoBSchema();
/*  903 */         tBonusInfoBSet.add(tLnpBonusInfoBSchema);
/*  904 */         reflections.transFields(tBonusInfoBSet, tBonusInfoSet);
/*  905 */         for (int i = 1; i <= tBonusInfoBSet.size(); i++) {
/*  906 */           tBonusInfoBSet.get(i).setEdorNo(serialNumber);
/*  907 */           tBonusInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  909 */         mMap.put(tBonusInfoSet, "DELETE");
/*  910 */         mMap.put(tBonusInfoBSet, "INSERT");
/*      */ 
/*  912 */         LNPRiskAmountDB tLnpRiskAmountDB = new LNPRiskAmountDB(conn);
/*  913 */         sql = "select * from LNPRiskAmount where contno='" + this.rmvPolicy + "'";
/*  914 */         LNPRiskAmountSet tLnpRiskAmountSet = tLnpRiskAmountDB.executeQuery(sql);
/*  915 */         LNPRiskAmountBSet tLnpRiskAmountBSet = new LNPRiskAmountBSet();
/*  916 */         LNPRiskAmountBSchema tlnpRiskAmountBSchema = new LNPRiskAmountBSchema();
/*  917 */         tLnpRiskAmountBSet.add(tlnpRiskAmountBSchema);
/*  918 */         reflections.transFields(tLnpRiskAmountBSet, tLnpRiskAmountSet);
/*  919 */         for (int i = 1; i <= tLnpRiskAmountBSet.size(); i++) {
/*  920 */           tLnpRiskAmountBSet.get(i).setEdorNo(serialNumber);
/*  921 */           tLnpRiskAmountBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  923 */         mMap.put(tLnpRiskAmountSet, "DELETE");
/*  924 */         mMap.put(tLnpRiskAmountBSet, "INSERT");
/*      */ 
/*  926 */         LNPInvestmentInfoDB tInvestmentInfoDB = new LNPInvestmentInfoDB(conn);
/*  927 */         sql = "select * from LNPInvestmentInfo where ContNo='" + this.rmvPolicy + "'";
/*  928 */         LNPInvestmentInfoSet tlnpLnpInvestmentInfoSet = tInvestmentInfoDB.executeQuery(sql);
/*  929 */         LNPInvestmentInfoBSet tlnpInvestmentInfoBSet = new LNPInvestmentInfoBSet();
/*  930 */         LNPInvestmentInfoBSchema tlnpLnpInvestmentInfoBSchema = new LNPInvestmentInfoBSchema();
/*  931 */         tlnpInvestmentInfoBSet.add(tlnpLnpInvestmentInfoBSchema);
/*  932 */         reflections.transFields(tlnpInvestmentInfoBSet, tlnpLnpInvestmentInfoSet);
/*  933 */         for (int i = 1; i <= tlnpInvestmentInfoBSet.size(); i++) {
/*  934 */           tlnpInvestmentInfoBSet.get(i).setEdorNo(serialNumber);
/*  935 */           tlnpInvestmentInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  937 */         mMap.put(tlnpLnpInvestmentInfoSet, "DELETE");
/*  938 */         mMap.put(tlnpInvestmentInfoBSet, "INSERT");
/*      */ 
/*  940 */         LNPInvestmentAccountInfoDB tlnpInvestmentAccountInfoDB = new LNPInvestmentAccountInfoDB(conn);
/*  941 */         sql = "select * from LNPInvestmentAccountInfo where ContNo='" + this.rmvPolicy + "'";
/*  942 */         LNPInvestmentAccountInfoSet tlnpiLnpInvestmentAccountInfoSet = tlnpInvestmentAccountInfoDB.executeQuery(sql);
/*  943 */         LNPInvestmentAccountInfoBSet tLnpInvestmentAccountInfoBSet = new LNPInvestmentAccountInfoBSet();
/*  944 */         LNPInvestmentAccountInfoBSchema tlnLnpInvestmentAccountInfoBSchema = new LNPInvestmentAccountInfoBSchema();
/*  945 */         tLnpInvestmentAccountInfoBSet.add(tlnLnpInvestmentAccountInfoBSchema);
/*  946 */         reflections.transFields(tLnpInvestmentAccountInfoBSet, tlnpiLnpInvestmentAccountInfoSet);
/*  947 */         for (int i = 1; i <= tLnpInvestmentAccountInfoBSet.size(); i++) {
/*  948 */           tLnpInvestmentAccountInfoBSet.get(i).setEdorNo(serialNumber);
/*  949 */           tLnpInvestmentAccountInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  951 */         mMap.put(tlnpiLnpInvestmentAccountInfoSet, "DELETE");
/*  952 */         mMap.put(tLnpInvestmentAccountInfoBSet, "INSERT");
/*      */ 
/*  954 */         LNPAppntDB tLnpAppntDB = new LNPAppntDB(conn);
/*  955 */         sql = "select * from LNPAppnt where ContNo='" + this.rmvPolicy + "'";
/*  956 */         LNPAppntSet tLnpAppntSet = tLnpAppntDB.executeQuery(sql);
/*  957 */         LNPAppntBSet tlnpAppntBSet = new LNPAppntBSet();
/*  958 */         LNPAppntBSchema tlnAppntBSchema = new LNPAppntBSchema();
/*  959 */         tlnpAppntBSet.add(tlnAppntBSchema);
/*  960 */         reflections.transFields(tlnpAppntBSet, tLnpAppntSet);
/*  961 */         for (int i = 1; i <= tlnpAppntBSet.size(); i++) {
/*  962 */           tlnpAppntBSet.get(i).setEdorNo(serialNumber);
/*  963 */           tlnpAppntBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  965 */         mMap.put(tLnpAppntSet, "DELETE");
/*  966 */         mMap.put(tlnpAppntBSet, "INSERT");
/*      */ 
/*  968 */         LNPInsuredDB tLnpInsuredDB = new LNPInsuredDB(conn);
/*  969 */         sql = "select * from LNPInsured where ContNo='" + this.rmvPolicy + "'";
/*  970 */         LNPInsuredSet tlnInsuredSet = tLnpInsuredDB.executeQuery(sql);
/*  971 */         LNPInsuredBSet tlnpInsuredBSet = new LNPInsuredBSet();
/*  972 */         LNPInsuredBSchema tlnLnpInsuredBSchema = new LNPInsuredBSchema();
/*  973 */         tlnpInsuredBSet.add(tlnLnpInsuredBSchema);
/*  974 */         reflections.transFields(tlnpInsuredBSet, tlnInsuredSet);
/*  975 */         for (int i = 1; i <= tlnpInsuredBSet.size(); i++) {
/*  976 */           tlnpInsuredBSet.get(i).setEdorNo(serialNumber);
/*  977 */           tlnpInsuredBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  979 */         mMap.put(tlnInsuredSet, "DELETE");
/*  980 */         mMap.put(tlnpInsuredBSet, "INSERT");
/*      */ 
/*  982 */         LNPBnfDB tlnpbBnfDB = new LNPBnfDB(conn);
/*  983 */         sql = "select * from LNPBnf where ContNo='" + this.rmvPolicy + "'";
/*  984 */         LNPBnfSet tlnpbBnfSet = tlnpbBnfDB.executeQuery(sql);
/*  985 */         LNPBnfBSet tLnpBnfBSet = new LNPBnfBSet();
/*  986 */         LNPBnfBSchema tlnBnfBSchema = new LNPBnfBSchema();
/*  987 */         tLnpBnfBSet.add(tlnBnfBSchema);
/*  988 */         reflections.transFields(tLnpBnfBSet, tlnpbBnfSet);
/*  989 */         for (int i = 1; i <= tLnpBnfBSet.size(); i++) {
/*  990 */           tLnpBnfBSet.get(i).setEdorNo(serialNumber);
/*  991 */           tLnpBnfBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/*  993 */         mMap.put(tlnpbBnfSet, "DELETE");
/*      */ 
/*  996 */         LNPPersonDB tlnLnpPersonDB = new LNPPersonDB(conn);
/*  997 */         sql = "select * from LNPPerson b where exists (select 1 from LNPAppnt a where a.AppntId=b.CustomerId and a.ContNo='" + this.rmvPolicy + "')" + 
/*  998 */           "union all select * from LNPPerson b where exists (select 1 from LNPInsured a where a.InsuredId=b.CustomerId and a.ContNo='" + this.rmvPolicy + "')";
/*  999 */         LNPPersonSet tlnLnpPersonSet = tlnLnpPersonDB.executeQuery(sql);
/* 1000 */         LNPPersonBSet tlnLnpPersonBSet = new LNPPersonBSet();
/* 1001 */         LNPPersonBSchema tlnLnpPersonBSchema = new LNPPersonBSchema();
/* 1002 */         tlnLnpPersonBSet.add(tlnLnpPersonBSchema);
/* 1003 */         reflections.transFields(tlnLnpPersonBSet, tlnLnpPersonSet);
/* 1004 */         for (int i = 1; i <= tlnLnpPersonBSet.size(); i++) {
/* 1005 */           tlnLnpPersonBSet.get(i).setEdorNo(serialNumber);
/* 1006 */           tlnLnpPersonBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1008 */         mMap.put(tlnLnpPersonSet, "DELETE");
/* 1009 */         mMap.put(tlnLnpPersonBSet, "INSERT");
/*      */ 
/* 1011 */         LNPAddressDB tLnpAddressDB = new LNPAddressDB(conn);
/* 1012 */         sql = "select * from LNPAddress b where exists(select 1 from LNPAppnt a where a.AppntId=b.CustomerId and a.ContNo='" + this.rmvPolicy + "')" + 
/* 1013 */           "union all select * from LNPAddress b where exists(select 1 from LNPInsured a where a.InsuredId=b.CustomerId and a.ContNo='" + this.rmvPolicy + "')";
/* 1014 */         LNPAddressSet tLnpAddressSet = tLnpAddressDB.executeQuery(sql);
/* 1015 */         LNPAddressBSet tLnpAddressBSet = new LNPAddressBSet();
/* 1016 */         LNPAddressBSchema tLnpAddressBSchema = new LNPAddressBSchema();
/* 1017 */         tLnpAddressBSet.add(tLnpAddressBSchema);
/* 1018 */         reflections.transFields(tLnpAddressBSet, tLnpAddressSet);
/* 1019 */         for (int i = 1; i <= tLnpAddressBSet.size(); i++) {
/* 1020 */           tLnpAddressBSet.get(i).setEdorNo(serialNumber);
/* 1021 */           tLnpAddressBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1023 */         mMap.put(tLnpAddressSet, "DELETE");
/* 1024 */         mMap.put(tLnpAddressBSet, "INSERT");
/*      */ 
/* 1026 */         LNPCustImpResultDB tLnpCustImpResultDB = new LNPCustImpResultDB(conn);
/* 1027 */         sql = "select * from LNPCustImpResult where ContNo='" + this.rmvPolicy + "'";
/* 1028 */         LNPCustImpResultSet tCustImpResultSet = tLnpCustImpResultDB.executeQuery(sql);
/* 1029 */         LNPCustImpResultBSet tLnpCustImpResultBSet = new LNPCustImpResultBSet();
/* 1030 */         LNPCustImpResultBSchema tCustImpResultBSchema = new LNPCustImpResultBSchema();
/* 1031 */         tLnpCustImpResultBSet.add(tCustImpResultBSchema);
/* 1032 */         reflections.transFields(tLnpCustImpResultBSet, tCustImpResultSet);
/* 1033 */         for (int i = 1; i <= tLnpCustImpResultBSet.size(); i++) {
/* 1034 */           tLnpCustImpResultBSet.get(i).setEdorNo(serialNumber);
/* 1035 */           tLnpCustImpResultBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1037 */         mMap.put(tCustImpResultSet, "DELETE");
/* 1038 */         mMap.put(tLnpCustImpResultBSet, "INSERT");
/*      */ 
/* 1040 */         LNPPaymentDB tLnpPaymentDB = new LNPPaymentDB(conn);
/* 1041 */         sql = "select * from LNPPayment where ContNo='" + this.rmvPolicy + "'";
/* 1042 */         LNPPaymentSet tLnpPaymentSet = tLnpPaymentDB.executeQuery(sql);
/* 1043 */         LNPPaymentBSet tLnpPaymentBSet = new LNPPaymentBSet();
/* 1044 */         LNPPaymentBSchema tLnpPaymentBSchema = new LNPPaymentBSchema();
/* 1045 */         tLnpPaymentBSet.add(tLnpPaymentBSchema);
/* 1046 */         reflections.transFields(tLnpPaymentBSet, tLnpPaymentSet);
/* 1047 */         for (int i = 1; i <= tLnpPaymentBSet.size(); i++) {
/* 1048 */           tLnpPaymentBSet.get(i).setEdorNo(serialNumber);
/* 1049 */           tLnpPaymentBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1051 */         mMap.put(tLnpPaymentSet, "DELETE");
/*      */ 
/* 1054 */         LNPAgentInfoDB tLnpAgentInfoDB = new LNPAgentInfoDB(conn);
/* 1055 */         sql = "select * from LNPAgentInfo where ContNo='" + this.rmvPolicy + "'";
/* 1056 */         LNPAgentInfoSet tLnpAgentInfoSet = tLnpAgentInfoDB.executeQuery(sql);
/* 1057 */         LNPAgentInfoBSet tLnpAgentInfoBSet = new LNPAgentInfoBSet();
/* 1058 */         LNPAgentInfoBSchema tLnpAgentInfoBSchema = new LNPAgentInfoBSchema();
/* 1059 */         tLnpAgentInfoBSet.add(tLnpAgentInfoBSchema);
/* 1060 */         reflections.transFields(tLnpAgentInfoBSet, tLnpAgentInfoSet);
/* 1061 */         for (int i = 1; i <= tLnpAgentInfoBSet.size(); i++) {
/* 1062 */           tLnpAgentInfoBSet.get(i).setEdorNo(serialNumber);
/* 1063 */           tLnpAgentInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1065 */         mMap.put(tLnpAgentInfoSet, "DELETE");
/* 1066 */         mMap.put(tLnpAgentInfoBSet, "INSERT");
/*      */ 
/* 1068 */         LNPOperationRecordDB tLnpOperationRecordDB = new LNPOperationRecordDB(conn);
/* 1069 */         sql = "select * from LNPOperationRecord where ContNo='" + this.rmvPolicy + "'";
/* 1070 */         LNPOperationRecordSet tLnpOperationRecordSet = tLnpOperationRecordDB.executeQuery(sql);
/* 1071 */         LNPOperationRecordBSet tOperationRecordBSet = new LNPOperationRecordBSet();
/* 1072 */         LNPOperationRecordBSchema tLnpOperationRecordBSchema = new LNPOperationRecordBSchema();
/* 1073 */         tOperationRecordBSet.add(tLnpOperationRecordBSchema);
/* 1074 */         reflections.transFields(tOperationRecordBSet, tLnpOperationRecordSet);
/* 1075 */         for (int i = 1; i <= tOperationRecordBSet.size(); i++) {
/* 1076 */           tOperationRecordBSet.get(i).setEdorNo(serialNumber);
/* 1077 */           tOperationRecordBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1079 */         mMap.put(tLnpOperationRecordSet, "DELETE");
/* 1080 */         mMap.put(tOperationRecordBSet, "INSERT");
/*      */ 
/* 1082 */         LNPCUWMasterDB tLnpcuwMasterDB = new LNPCUWMasterDB(conn);
/* 1083 */         sql = "select * from LNPCUWMaster where ContNo='" + this.rmvPolicy + "'";
/* 1084 */         LNPCUWMasterSet tLnpcuwMasterSet = tLnpcuwMasterDB.executeQuery(sql);
/* 1085 */         LNPCUWMasterBSet tLnpcuwMasterBSet = new LNPCUWMasterBSet();
/* 1086 */         LNPCUWMasterBSchema tLnpcuwMasterBSchema = new LNPCUWMasterBSchema();
/* 1087 */         tLnpcuwMasterBSet.add(tLnpcuwMasterBSchema);
/* 1088 */         reflections.transFields(tLnpcuwMasterBSet, tLnpcuwMasterSet);
/* 1089 */         for (int i = 1; i <= tLnpcuwMasterBSet.size(); i++) {
/* 1090 */           tLnpcuwMasterBSet.get(i).setEdorNo(serialNumber);
/* 1091 */           tLnpcuwMasterBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
/*      */         }
/* 1093 */         mMap.put(tLnpcuwMasterSet, "DELETE");
/* 1094 */         mMap.put(tLnpcuwMasterBSet, "INSERT");
/*      */ 
/* 1097 */         LNPTransRcorsSchema tLnpTransRcorsSchema = new LNPTransRcorsSchema();
/* 1098 */         tLnpTransRcorsSchema.setEdorNo(serialNumber);
/* 1099 */         tLnpTransRcorsSchema.setserialNo(serialNumber);
/* 1100 */         tLnpTransRcorsSchema.setContNo(this.rmvPolicy);
/* 1101 */         tLnpTransRcorsSchema.setOperator(this.tempGI.Operator);
/* 1102 */         tLnpTransRcorsSchema.setMakeDate(curDate);
/* 1103 */         tLnpTransRcorsSchema.setMakeTime(curTime);
/* 1104 */         mMap.put(tLnpTransRcorsSchema, "INSERT");
/* 1105 */         cInputData.add(mMap);
/* 1106 */         pubSubmit.conn = conn;
/* 1107 */         if (!pubSubmit.submitData(cInputData, "")) {
/* 1108 */           System.out.println("\u5220\u9664\u6295\u4FDD\u4E66\u51FA\u9519~");
/* 1109 */           throw new Exception("\u5220\u9664\u6295\u4FDD\u4E66\u51FA\u9519~");
/*      */         }
/*      */ 
/* 1112 */         System.out.println("have removed policy:" + this.rmvPolicy);
/*      */       }
/*      */     } catch (Exception e) {
/* 1115 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void view()
/*      */   {
/*      */   }
/*      */ 
/*      */   public void repeatLnp()
/*      */   {
/*      */   }
/*      */ 
/*      */   public void repairLnp()
/*      */   {
/*      */   }
/*      */ 
/*      */   public void suggestToInsurance()
/*      */   {
/*      */   }
/*      */ 
/*      */   public List<LNPContBean> getLnpList()
/*      */   {
/* 1141 */     return this.lnpList;
/*      */   }
/*      */   public void setLnpList(List<LNPContBean> lnpList) {
/* 1144 */     this.lnpList = lnpList;
/*      */   }
/*      */   public LNPContSchema getQueryContSch() {
/* 1147 */     return this.queryContSch;
/*      */   }
/*      */   public void setQueryContSch(LNPContSchema queryContSch) {
/* 1150 */     this.queryContSch = queryContSch;
/*      */   }
/*      */   public String getState() {
/* 1153 */     return this.state;
/*      */   }
/*      */   public void setState(String state) {
/* 1156 */     this.state = state;
/*      */   }
/*      */   public String getEndDate() {
/* 1159 */     return formatDate(this.endDate, "YYYYMMDD");
/*      */   }
/*      */   public void setEndDate(String endDate) {
/* 1162 */     this.endDate = endDate;
/*      */   }
/*      */   public String getStartDate() {
/* 1165 */     return formatDate(this.startDate, "YYYYMMDD");
/*      */   }
/*      */   public void setStartDate(String startDate) {
/* 1168 */     this.startDate = startDate;
/*      */   }
/*      */ 
/*      */   public boolean isAlertFlag() {
/* 1172 */     return this.alertFlag;
/*      */   }
/*      */ 
/*      */   public void setAlertFlag(boolean alertFlag) {
/* 1176 */     this.alertFlag = alertFlag;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 1180 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message) {
/* 1184 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/* 1188 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/* 1192 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getPrem() {
/* 1196 */     return this.prem;
/*      */   }
/*      */ 
/*      */   public void setPrem(String prem) {
/* 1200 */     this.prem = prem;
/*      */   }
/*      */ 
/*      */   public boolean isShowErrorFlag() {
/* 1204 */     return this.showErrorFlag;
/*      */   }
/*      */ 
/*      */   public void setShowErrorFlag(boolean showErrorFlag) {
/* 1208 */     this.showErrorFlag = showErrorFlag;
/*      */   }
/*      */ 
/*      */   public String getRmvPolicy() {
/* 1212 */     return this.rmvPolicy;
/*      */   }
/*      */ 
/*      */   public void setRmvPolicy(String rmvPolicy) {
/* 1216 */     this.rmvPolicy = rmvPolicy;
/*      */   }
/*      */ 
/*      */   public String getRmvState() {
/* 1220 */     return this.rmvState;
/*      */   }
/*      */ 
/*      */   public void setRmvState(String rmvState) {
/* 1224 */     this.rmvState = rmvState;
/*      */   }
/*      */ 
/*      */   public boolean isCancelAbilityFlag() {
/* 1228 */     return this.cancelAbilityFlag;
/*      */   }
/*      */ 
/*      */   public void setCancelAbilityFlag(boolean cancelAbilityFlag) {
/* 1232 */     this.cancelAbilityFlag = cancelAbilityFlag;
/*      */   }
/*      */ 
/*      */   private String formatDate(String srcDate, String formate)
/*      */   {
/* 1242 */     String tDate = srcDate;
/* 1243 */     if ((srcDate != null) && (!"".equals(srcDate.trim()))) {
/* 1244 */       if (formate.indexOf("-") > 0)
/* 1245 */         tDate = srcDate.substring(0, 4) + "-" + srcDate.substring(4, 6) + "-" + srcDate.substring(6, 8);
/*      */       else {
/* 1247 */         tDate = srcDate.replaceAll("-", "");
/*      */       }
/*      */     }
/* 1250 */     return tDate;
/*      */   }
/*      */ 
/*      */   private static void initContStateMap()
/*      */   {
/* 1257 */     ContStateMap.clear();
/* 1258 */     ExeSQL tExeSQL = new ExeSQL();
/* 1259 */     String sql = "select code,codename from lnpcode where codetype='lnpLangState'";
/* 1260 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 1261 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 1262 */       ContStateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/* 1268 */     InsuranceQuery i = new InsuranceQuery();
/* 1269 */     i.setRmvPolicy("200141231231");
/* 1270 */     i.setRmvState("03");
/* 1271 */     IGlobalInput gi = new IGlobalInput();
/* 1272 */     gi.Operator = "Dadmin";
/* 1273 */     i.tempGI = gi;
/* 1274 */     i.RemovePolicy();
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.InsuranceQuery
 * JD-Core Version:    0.6.0
 */