/*     */ package com.sinosoft.map.communal;
/*     */ 
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sinosoft.map.common.logs.LogInfo;
/*     */ import com.sinosoft.map.common.logs.VisitorLog;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.news.NewsDataModel;
/*     */ import com.sinosoft.map.news.NewsDataModelSchema;
/*     */ import com.sinosoft.map.user.ADUser;
/*     */ import com.sinosoft.map.user.ADValidate;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ 
/*     */ public class CommonalityDataModel extends BaseConfig
/*     */ {
/*  29 */   private String operate = "";
/*     */   private List<NewsDataModelSchema> newsCompanyList;
/*     */   private List<NewsDataModelSchema> newsBranchList;
/*     */   private String initNewsCompanyList;
/*     */   private String initNewsBranchList;
/*     */   private String loginToNowDate;
/*  41 */   private boolean flag = false;
/*     */ 
/*  43 */   private String pwdCountDown = "";
/*     */ 
/*  45 */   private String oldPwd = "";
/*  46 */   private String newPwd = "";
/*  47 */   private String confirmPwd = "";
/*  48 */   private String isSuccess = "";
/*  49 */   private String finished = "";
/*     */ 
/*  51 */   private List<String[]> queList = new ArrayList();
/*     */ 
/*     */   public void queCheckAgent()
/*     */   {
/*  56 */     FacesContext ctx = FacesContext.getCurrentInstance();
/*  57 */     String topicid = (String)ctx.getExternalContext().getRequestParameterMap().get("topicid");
/*     */ 
/*  60 */     WebVisitor tWebVisitor = new WebVisitor();
/*  61 */     tWebVisitor = ECPubFun.getWebVisitor();
/*  62 */     UserModel user = tWebVisitor.getUser();
/*  63 */     String agentcode = user.getUserCode();
/*  64 */     String strSQL2 = "";
/*  65 */     strSQL2 = "select * from minvresult where topicid='" + topicid + "' and agentcode='" + agentcode + "'";
/*  66 */     SSRS tSSRS2 = new SSRS();
/*  67 */     ExeSQL tExeSql2 = new ExeSQL();
/*  68 */     tSSRS2 = tExeSql2.execSQL(strSQL2);
/*  69 */     if ((tSSRS2 != null) && (tSSRS2.getMaxRow() > 0))
/*     */     {
/*  71 */       this.finished = "false";
/*     */     }
/*     */     else
/*     */     {
/*  76 */       this.finished = topicid;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void changePassword()
/*     */   {
/*  86 */     ADUser aduser = new ADUser();
/*     */ 
/*  88 */     WebVisitor tWebVisitor = new WebVisitor();
/*  89 */     tWebVisitor = ECPubFun.getWebVisitor();
/*  90 */     UserModel user = tWebVisitor.getUser();
/*  91 */     aduser.setUserCode(user.getUserCode());
/*  92 */     aduser.setPassWord(this.oldPwd);
/*  93 */     aduser.setNewPassWord(this.newPwd);
/*  94 */     ADValidate tADValidate = new ADValidate();
/*     */ 
/*  96 */     this.isSuccess = tADValidate.ChangePassWord(aduser);
/*     */   }
/*     */ 
/*     */   public String getIsSuccess()
/*     */   {
/* 101 */     return this.isSuccess;
/*     */   }
/*     */ 
/*     */   public void setIsSuccess(String isSuccess) {
/* 105 */     this.isSuccess = isSuccess;
/*     */   }
/*     */ 
/*     */   public boolean isFlag()
/*     */   {
/* 110 */     ExeSQL exeSQL = new ExeSQL();
/* 111 */     String passinvalidaremindnum = null;
/* 112 */     String passvaliddatenum = null;
/*     */ 
/* 114 */     UserModel user = ECPubFun.getWebVisitor().getUser();
/* 115 */     String tDate = user.getPwdLastSetDate();
/* 116 */     System.out.println(tDate + "~~~~~~~~~~~~~~~~~~~~~");
/*     */ 
/* 118 */     String pwdsql1 = "select varvalue from msysvar where vartype='passinvalidaremindnum' ";
/* 119 */     SSRS ssrs = exeSQL.execSQL(pwdsql1);
/* 120 */     if (ssrs.MaxRow > 0) {
/* 121 */       passinvalidaremindnum = ssrs.GetText(1, 1);
/*     */     }
/* 123 */     String pwdsql2 = "select varvalue from msysvar where vartype='passvaliddatenum' ";
/* 124 */     ssrs = exeSQL.execSQL(pwdsql2);
/* 125 */     if (ssrs.MaxRow > 0) {
/* 126 */       passvaliddatenum = ssrs.GetText(1, 1);
/*     */     }
/* 128 */     Date date1 = null;
/*     */     try {
/* 130 */       date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tDate);
/*     */     }
/*     */     catch (ParseException e) {
/* 133 */       e.printStackTrace();
/*     */     }
/* 135 */     System.out.println(date1);
/* 136 */     Calendar pwdcalendar = Calendar.getInstance();
/* 137 */     pwdcalendar.setTime(date1);
/* 138 */     int adddays = Integer.parseInt(passvaliddatenum);
/*     */ 
/* 140 */     pwdcalendar.add(5, adddays);
/*     */ 
/* 142 */     System.out.println(pwdcalendar.getTime());
/* 143 */     Date date2 = pwdcalendar.getTime();
/* 144 */     Date today = new Date();
/*     */ 
/* 146 */     long countdown = (date2.getTime() - today.getTime()) / 86400000L;
/* 147 */     System.out.println(countdown);
/* 148 */     tDate = Long.toString(countdown);
/* 149 */     this.pwdCountDown = tDate;
/*     */ 
/* 151 */     if ((Integer.parseInt(tDate) < Integer.parseInt(passinvalidaremindnum)) && (ECPubFun.getWebVisitor().getUser().isPopupFlag()))
/* 152 */       this.flag = true;
/* 153 */     else this.flag = false;
/*     */ 
/* 156 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(boolean flag) {
/* 160 */     this.flag = flag;
/*     */   }
/*     */ 
/*     */   public String getPwdCountDown() {
/* 164 */     return this.pwdCountDown;
/*     */   }
/*     */ 
/*     */   public void setPwdCountDown(String pwdCountDown) {
/* 168 */     this.pwdCountDown = pwdCountDown;
/*     */   }
/*     */ 
/*     */   public String getLoginToNowDate() {
/* 172 */     WebVisitor tWebVisitor = new WebVisitor();
/* 173 */     tWebVisitor = ECPubFun.getWebVisitor();
/* 174 */     UserModel user = tWebVisitor.getUser();
/* 175 */     String loginTime = user.getLoginTime();
/* 176 */     loginTime = user.getLoginDate() + " " + loginTime;
/* 177 */     SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 178 */     String nowtime = d.format(new Date());
/*     */ 
/* 180 */     long resultDay = 0L;
/* 181 */     long resultMin = 0L;
/* 182 */     long resultSecond = 0L;
/* 183 */     String resultDayStr = "";
/* 184 */     String resultMinStr = "";
/* 185 */     String resultSecondStr = "";
/*     */     try
/*     */     {
/* 188 */       resultDay = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 3600000L;
/* 189 */       resultMin = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 60000L;
/* 190 */       resultSecond = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 1000L;
/*     */ 
/* 192 */       resultSecond %= 60L;
/* 193 */       resultDay %= 60L;
/* 194 */       resultMin %= 60L;
/*     */ 
/* 196 */       resultDayStr = String.valueOf(resultDay);
/* 197 */       if (resultDayStr.length() == 1)
/*     */       {
/* 199 */         resultDayStr = "0" + resultDayStr;
/*     */       }
/* 201 */       resultMinStr = String.valueOf(resultMin);
/* 202 */       if (resultMinStr.length() == 1)
/*     */       {
/* 204 */         resultMinStr = "0" + resultMinStr;
/*     */       }
/* 206 */       resultSecondStr = String.valueOf(resultSecond);
/* 207 */       if (resultSecondStr.length() == 1)
/*     */       {
/* 209 */         resultSecondStr = "0" + resultSecondStr;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (ParseException e)
/*     */     {
/* 215 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 218 */     this.loginToNowDate = String.valueOf(resultDayStr + ":" + resultMinStr + ":" + resultSecondStr);
/*     */ 
/* 220 */     return this.loginToNowDate;
/*     */   }
/*     */ 
/*     */   public void setLoginToNowDate(String loginToNowDate) {
/* 224 */     this.loginToNowDate = loginToNowDate;
/*     */   }
/*     */ 
/*     */   public String getInitNewsCompanyList() {
/* 228 */     return this.initNewsCompanyList;
/*     */   }
/*     */ 
/*     */   public void setInitNewsCompanyList(String initNewsCompanyList) {
/* 232 */     this.initNewsCompanyList = initNewsCompanyList;
/*     */ 
/* 234 */     NewsDataModel model = new NewsDataModel();
/*     */ 
/* 236 */     this.newsCompanyList = model.getNewsList("company");
/*     */   }
/*     */ 
/*     */   public String getInitNewsBranchList() {
/* 240 */     return this.initNewsBranchList;
/*     */   }
/*     */ 
/*     */   public void setInitNewsBranchList(String initNewsBranchList) {
/* 244 */     this.initNewsBranchList = initNewsBranchList;
/*     */ 
/* 246 */     NewsDataModel model = new NewsDataModel();
/*     */ 
/* 248 */     this.newsBranchList = model.getNewsList("branch");
/*     */   }
/*     */ 
/*     */   public void setInitNewsList1(String initNewsList1)
/*     */   {
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsCompanyList()
/*     */   {
/* 259 */     return this.newsCompanyList;
/*     */   }
/*     */ 
/*     */   public void setNewsCompanyList(List<NewsDataModelSchema> newsCompanyList) {
/* 263 */     this.newsCompanyList = newsCompanyList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsBranchList() {
/* 267 */     return this.newsBranchList;
/*     */   }
/*     */ 
/*     */   public void setNewsBranchList(List<NewsDataModelSchema> newsBranchList) {
/* 271 */     this.newsBranchList = newsBranchList;
/*     */   }
/*     */ 
/*     */   public String getOperate() {
/* 275 */     return this.operate;
/*     */   }
/*     */ 
/*     */   public void setOperate(String operate)
/*     */   {
/* 280 */     LogInfo tLogInfo = new LogInfo();
/*     */ 
/* 282 */     WebVisitor visitor = ECPubFun.getWebVisitor();
/* 283 */     tLogInfo.setUsercode(visitor.getUser().getUserCode());
/* 284 */     tLogInfo.setOperateStr(operate);
/* 285 */     tLogInfo.setOperateDate(ECPubFun.getCurrentDate());
/* 286 */     tLogInfo.setOperateTime(ECPubFun.getCurrentTime());
/* 287 */     VisitorLog.webOperateInfoList.add(tLogInfo);
/*     */ 
/* 289 */     System.out.println(VisitorLog.webOperateInfoList.size() + "===================");
/*     */   }
/*     */ 
/*     */   public String getOldPwd()
/*     */   {
/* 294 */     return this.oldPwd;
/*     */   }
/*     */ 
/*     */   public void setOldPwd(String oldPwd) {
/* 298 */     this.oldPwd = oldPwd;
/*     */   }
/*     */ 
/*     */   public String getNewPwd() {
/* 302 */     return this.newPwd;
/*     */   }
/*     */ 
/*     */   public void setNewPwd(String newPwd) {
/* 306 */     this.newPwd = newPwd;
/*     */   }
/*     */ 
/*     */   public String getConfirmPwd() {
/* 310 */     return this.confirmPwd;
/*     */   }
/*     */ 
/*     */   public void setConfirmPwd(String confirmPwd) {
/* 314 */     this.confirmPwd = confirmPwd;
/*     */   }
/*     */ 
/*     */   public String getFinished()
/*     */   {
/* 319 */     return this.finished;
/*     */   }
/*     */ 
/*     */   public void setFinished(String finished)
/*     */   {
/* 324 */     this.finished = finished;
/*     */   }
/*     */ 
/*     */   public List<String[]> getQueList()
/*     */   {
/* 331 */     this.queList.clear();
/*     */ 
/* 333 */     String strSQL = "";
/* 334 */     strSQL = "select  topic,managecom,author,population,topicid  from minvtopic where checkstate='2' and branchtype='" + ECPubFun.getWebVisitor().getUser().getBranchType() + "'" + 
/* 335 */       " and state='1' and invstate='2' and managecom in ('86','" + ECPubFun.getWebVisitor().getUser().getManageCom() + "') order by checkdate desc ";
/* 336 */     SSRS tSSRS1 = new SSRS();
/* 337 */     ExeSQL tExeSql = new ExeSQL();
/* 338 */     tSSRS1 = tExeSql.execSQL(strSQL);
/*     */ 
/* 342 */     if ((tSSRS1 == null) || (tSSRS1.getMaxRow() < 1))
/*     */     {
/* 344 */       return this.queList;
/*     */     }
/*     */ 
/* 350 */     for (int i = 1; i <= tSSRS1.MaxRow; i++)
/*     */     {
/* 352 */       String[] resultInfo = new String[tSSRS1.MaxCol];
/* 353 */       for (int j = 1; j <= tSSRS1.MaxCol; j++)
/*     */       {
/* 355 */         resultInfo[(j - 1)] = tSSRS1.GetText(i, j);
/*     */       }
/* 357 */       this.queList.add(resultInfo);
/*     */     }
/*     */ 
/* 362 */     return this.queList;
/*     */   }
/*     */ 
/*     */   public void setQueList(List<String[]> queList)
/*     */   {
/* 367 */     this.queList = queList;
/*     */   }
/*     */ 
/*     */   public void checkUserType()
/*     */   {
/* 372 */     this.isSuccess = "0";
/* 373 */     WebVisitor visitor = ECPubFun.getWebVisitor();
/* 374 */     String type = visitor.getUser().getUserType();
/* 375 */     if ((type != null) && (!"".equals(type)))
/*     */     {
/* 377 */       if (type.equals("LP"))
/*     */       {
/* 379 */         this.isSuccess = "1";
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.communal.CommonalityDataModel
 * JD-Core Version:    0.6.0
 */