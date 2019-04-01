/*     */ package com.sinosoft.map.user;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.WebVisitorEngine;
/*     */ import com.sinosoft.map.common.validators.ValidatorConfig;
/*     */ import com.sinosoft.map.ec.utility.BaseMapping;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.lis.encrypt.LisCompIDEA;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.sug.lis.pubfun.GlobalInput;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Hashtable;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ExpressionFactory;
/*     */ import javax.el.ValueExpression;
/*     */ import javax.faces.application.Application;
/*     */ import javax.faces.application.ViewHandler;
/*     */ import javax.faces.component.UIViewRoot;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.naming.AuthenticationException;
/*     */ import javax.naming.CommunicationException;
/*     */ import javax.naming.directory.DirContext;
/*     */ import javax.naming.directory.InitialDirContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AgentLogin extends ValidatorConfig
/*     */ {
/*     */   private static final long serialVersionUID = -2766674140338029918L;
/*     */   private String userCode;
/*     */   private String password;
/*     */   private String ManageCom;
/*     */   private String loginStr;
/*     */   private String loginAfterStr;
/*     */   private HttpSession session;
/*  45 */   private BaseMapping mBaseMapping = new BaseMapping();
/*  46 */   private String tempAgent = "";
/*  47 */   private String resTempAgent = "";
/*     */   private boolean hidden;
/*     */   private String validateCode;
/*     */   private String transNotice;
/*  94 */   private String isSuccess = "false";
/*  95 */   private String isUserValidateCode = "true";
/*     */ 
/*     */   public String getResTempAgent()
/*     */   {
/*  49 */     return this.resTempAgent;
/*     */   }
/*     */ 
/*     */   public void setResTempAgent(String resTempAgent) {
/*  53 */     this.resTempAgent = resTempAgent;
/*     */   }
/*     */ 
/*     */   public String getTempAgent() {
/*  57 */     return this.tempAgent;
/*     */   }
/*     */ 
/*     */   public void setTempAgent(String tempAgent) {
/*  61 */     this.tempAgent = tempAgent;
/*     */   }
/*     */ 
/*     */   public String getLoginStr() {
/*  65 */     return this.loginStr;
/*     */   }
/*     */ 
/*     */   public void setLoginStr(String loginStr)
/*     */   {
/*  70 */     login();
/*     */   }
/*     */ 
/*     */   public String getLoginAfterStr()
/*     */   {
/*  75 */     return this.loginAfterStr;
/*     */   }
/*     */ 
/*     */   public void setLoginAfterStr(String loginAfterStr) {
/*  79 */     this.loginAfterStr = loginAfterStr;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/*  83 */     return this.ManageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom) {
/*  87 */     this.ManageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public String login()
/*     */   {
/* 101 */     this.isUserValidateCode = "false";
/* 102 */     this.tempAgent = this.mBaseMapping.agentMapping(this.userCode);
/* 103 */     this.userCode = this.tempAgent;
/* 104 */     this.resTempAgent = this.mBaseMapping.resAgentMapping(this.userCode);
/* 105 */     System.out.println("username=" + this.userCode);
/*     */ 
/* 108 */     if ((this.userCode == null) || ("".equals(this.userCode))) {
/* 109 */       ECPubFun.addInfoMessage(getBundle(), "login_userCodeNotice");
/* 110 */       return "failure";
/*     */     }
/*     */ 
/* 113 */     if ((this.password == null) || ("".equals(this.password))) {
/* 114 */       this.userCode = this.resTempAgent;
/* 115 */       ECPubFun.addInfoMessage(getBundle(), "login_passwordNotice");
/* 116 */       return "failure";
/*     */     }
/*     */ 
/* 120 */     if ("true".equals(this.isUserValidateCode))
/*     */     {
/* 122 */       if ((this.validateCode == null) || ("".equals(this.validateCode)))
/*     */       {
/* 124 */         this.userCode = this.resTempAgent;
/* 125 */         ECPubFun.addInfoMessage(getBundle(), "login_validCodeNotice");
/* 126 */         return "failure";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 133 */     LoginModel user = existsUser();
/* 134 */     if ((user == null) || (!user.isVerifyResult())) {
/* 135 */       this.userCode = this.resTempAgent;
/* 136 */       ECPubFun.addErrorMessage(getBundle(), "login_userNotExists");
/* 137 */       return "failure";
/*     */     }
/*     */ 
/* 141 */     user = existsPwd(user);
/*     */ 
/* 144 */     if (!user.isVerifyResult()) {
/* 145 */       this.userCode = this.resTempAgent;
/* 146 */       ECPubFun.addErrorMessage(getBundle(), "login_failure");
/* 147 */       return "failure";
/*     */     }
/*     */ 
/* 159 */     setLogin(null, false);
/*     */ 
/* 161 */     this.isSuccess = "true";
/* 162 */     return "failure";
/*     */   }
/*     */ 
/*     */   public void disagree()
/*     */   {
/* 167 */     Application app = getApplication();
/* 168 */     ELContext elc = getELContext();
/* 169 */     ExpressionFactory ef = app.getExpressionFactory();
/*     */ 
/* 171 */     ValueExpression ve = ef.createValueExpression(elc, 
/* 172 */       "#{webVisitor}", 
/* 173 */       WebVisitor.class);
/*     */ 
/* 175 */     WebVisitor visitor = null;
/*     */     try {
/* 177 */       visitor = (WebVisitor)ve.getValue(elc); } catch (Exception localException) {
/*     */     }
/* 179 */     visitor.setHalfLogin(false);
/* 180 */     this.isSuccess = "false";
/*     */   }
/*     */ 
/*     */   public String loginAfter()
/*     */   {
/* 187 */     LoginModel user = existsUser();
/* 188 */     if ((user == null) || (!user.isVerifyResult())) {
/* 189 */       this.userCode = this.resTempAgent;
/* 190 */       ECPubFun.addErrorMessage(getBundle(), "login_userNotExists");
/* 191 */       return "failure";
/*     */     }
/*     */ 
/* 195 */     user = existsPwd(user);
/*     */ 
/* 197 */     if ((user == null) || (!user.isVerifyResult())) {
/* 198 */       this.userCode = this.resTempAgent;
/* 199 */       ECPubFun.addErrorMessage(getBundle(), "login_failure");
/* 200 */       return "failure";
/*     */     }
/*     */ 
/* 206 */     UserModel loginUser = getUser(user.getUserType(), user.getPwdLastSetDate());
/*     */ 
/* 209 */     setLogin(loginUser, false);
/*     */ 
/* 211 */     this.isSuccess = "true";
/*     */ 
/* 214 */     GlobalInput eGlobalInput = new GlobalInput();
/* 215 */     eGlobalInput.Operator = loginUser.getUserCode();
/* 216 */     eGlobalInput.ManageCom = loginUser.getManageCom();
/* 217 */     eGlobalInput.ComCode = loginUser.getManageCom();
/*     */ 
/* 219 */     eGlobalInput.PwdErrCount = 0;
/* 220 */     eGlobalInput.LastLogoTime = new Date().getTime();
/* 221 */     eGlobalInput.chanlesign = "I";
/* 222 */     eGlobalInput.riskSaleGroup = "000000";
/*     */ 
/* 224 */     eGlobalInput.logoflag = true;
/* 225 */     this.session = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true));
/* 226 */     this.session.setAttribute("GI", eGlobalInput);
/* 227 */     String ContNo = "";
/* 228 */     String SugState = "add";
/* 229 */     this.session.setAttribute("ContNo", ContNo);
/* 230 */     this.session.setAttribute("SugState", SugState);
/*     */ 
/* 235 */     IGlobalInput npGlobalInput = new IGlobalInput();
/*     */ 
/* 237 */     System.out.println("ddddddddddddddddddddnew");
/*     */ 
/* 240 */     npGlobalInput.Operator = loginUser.getUserCode();
/* 241 */     npGlobalInput.ManageCom = loginUser.getManageCom();
/* 242 */     npGlobalInput.ComCode = loginUser.getManageCom();
/* 243 */     npGlobalInput.BranchType = loginUser.getBranchType();
/*     */ 
/* 245 */     if (loginUser.getUserType().equals("LP")) {
/* 246 */       npGlobalInput.OperType = "1";
/* 247 */       npGlobalInput.LNPEntry = true;
/* 248 */       npGlobalInput.LNPAudit = false;
/* 249 */       npGlobalInput.LNPQuery = false;
/* 250 */       npGlobalInput.LNPCancel = false;
/* 251 */       npGlobalInput.LNPRole = "0";
/* 252 */     } else if (loginUser.getUserType().equals("SysUser"))
/*     */     {
/* 256 */       ExeSQL exeSQL = new ExeSQL();
/*     */ 
/* 260 */       String sql = "select rolecode,varc1,varc2,varc3 from lnpuserrolemap where usercode ='" + loginUser.getUserCode() + "';";
/*     */ 
/* 262 */       SSRS tSSRS = exeSQL.execSQL(sql);
/*     */ 
/* 264 */       if (tSSRS.getMaxRow() > 0) {
/* 265 */         if (tSSRS.GetText(1, 1).toLowerCase().equals("norsysuser")) {
/* 266 */           npGlobalInput.OperType = "2";
/* 267 */           npGlobalInput.LNPEntry = true;
/* 268 */           npGlobalInput.LNPRole = "0";
/* 269 */         } else if (tSSRS.GetText(1, 1).toLowerCase().equals("spesysuser")) {
/* 270 */           npGlobalInput.OperType = "3";
/* 271 */           npGlobalInput.LNPEntry = true;
/* 272 */           npGlobalInput.LNPRole = "0";
/*     */         }
/*     */         else {
/* 275 */           npGlobalInput.OperType = "";
/* 276 */           npGlobalInput.LNPEntry = false;
/*     */         }
/*     */ 
/* 279 */         if (tSSRS.GetText(1, 2).toLowerCase().endsWith("true")) {
/* 280 */           npGlobalInput.LNPAudit = true;
/* 281 */           npGlobalInput.LNPRole = "1";
/*     */         } else {
/* 283 */           npGlobalInput.LNPAudit = false;
/*     */         }
/*     */ 
/* 286 */         if (((tSSRS.GetText(1, 1).toLowerCase().equals("norsysuser")) || 
/* 287 */           (tSSRS.GetText(1, 1).toLowerCase().equals("spesysuser"))) && 
/* 288 */           (tSSRS.GetText(1, 2).toLowerCase().endsWith("true")))
/*     */         {
/* 290 */           npGlobalInput.LNPRole = "2";
/*     */         }
/*     */ 
/* 293 */         if (tSSRS.GetText(1, 3).toLowerCase().endsWith("true"))
/*     */         {
/* 295 */           npGlobalInput.LNPQuery = true;
/*     */         }
/* 297 */         else npGlobalInput.LNPQuery = false;
/*     */ 
/* 300 */         if (tSSRS.GetText(1, 4).toLowerCase().endsWith("true"))
/* 301 */           npGlobalInput.LNPCancel = true;
/*     */         else
/* 303 */           npGlobalInput.LNPCancel = false;
/*     */       }
/*     */       else
/*     */       {
/* 307 */         npGlobalInput.OperType = null;
/* 308 */         npGlobalInput.LNPEntry = false;
/* 309 */         npGlobalInput.LNPAudit = false;
/* 310 */         npGlobalInput.LNPQuery = false;
/*     */       }
/*     */     }
/* 313 */     npGlobalInput.OperType = "TEST_CH";
/* 314 */     System.out.println("-------\u94F6\u4FDD\u7528\u4E0D\u5230OperType\uFF0C\u8D4B\u503C''-------------" + npGlobalInput.OperType);
/* 315 */     System.out.println("------------------\u94F6\u4FDD\u5F53\u524D\u767B\u9646\u4EBA:" + npGlobalInput.Operator + "|\u5F55\u5165\u6743\u9650\uFF1A" + npGlobalInput.LNPEntry + "|\u5BA1\u6838\u6743\u9650\uFF1A" + npGlobalInput.LNPAudit + "|\u62A5\u8868\u6743\u9650\uFF1A" + npGlobalInput.LNPQuery + "|" + "|\u5220\u9664\u6743\u9650\uFF1A" + npGlobalInput.LNPCancel + "|LNPRole:" + npGlobalInput.LNPRole);
/*     */ 
/* 321 */     npGlobalInput.PwdErrCount = 0;
/* 322 */     npGlobalInput.LastLogoTime = new Date().getTime();
/* 323 */     npGlobalInput.chanlesign = loginUser.getBranchType();
/* 324 */     npGlobalInput.riskSaleGroup = "000000";
/*     */ 
/* 326 */     npGlobalInput.logoflag = true;
/* 327 */     this.session = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true));
/*     */ 
/* 329 */     String NpContNo = "";
/* 330 */     String NpState = "add";
/* 331 */     this.session.setAttribute("ContNo", NpContNo);
/* 332 */     this.session.setAttribute("NpState", NpState);
/* 333 */     this.session.setAttribute("NPGI", npGlobalInput);
/*     */ 
/* 335 */     return "success";
/*     */   }
/*     */ 
/*     */   private LoginModel existsUser()
/*     */   {
/* 343 */     System.out.println("\u9996\u5148\u6839\u636E\u7528\u6237\u7684UserCode\u5224\u65AD\u662F\u5426\u5B58\u5728\u8BE5\u7528\u6237");
/*     */ 
/* 345 */     LoginModel user = new LoginModel();
/*     */ 
/* 348 */     ExeSQL exeSQL = new ExeSQL();
/* 349 */     String userSQL1 = "select varvalue from msysvar where vartype='loginbranchtype'";
/* 350 */     SSRS ssrs = exeSQL.execSQL(userSQL1);
/*     */ 
/* 379 */     String[] abranchtype = ssrs.GetText(1, 1).split(",");
/* 380 */     String branchtype = "";
/* 381 */     for (int i = 0; i < abranchtype.length - 1; i++)
/*     */     {
/* 383 */       branchtype = branchtype + "'" + abranchtype[i] + "' , ";
/*     */     }
/* 385 */     branchtype = branchtype + "'" + abranchtype[(abranchtype.length - 1)] + "' ";
/*     */ 
/* 387 */     System.out.println(branchtype);
/*     */ 
/* 410 */     String userSQL2 = "select usercode from muser where usercode='" + this.userCode + "' and userState = '1' and branchtype in (" + branchtype + ") and ( validstartdate is null or validstartdate <= '" + ECPubFun.getCurrentDate() + "' ) and ( validenddate is null or validenddate >= '" + ECPubFun.getCurrentDate() + "' )";
/*     */ 
/* 412 */     ssrs = exeSQL.execSQL(userSQL2);
/*     */ 
/* 414 */     if ((ssrs != null) && (ssrs.MaxRow > 0))
/*     */     {
/* 416 */       user.setUserType("SysUser");
/* 417 */       user.setVerifyResult(true);
/* 418 */       return user;
/*     */     }
/*     */ 
/* 422 */     user.setVerifyResult(false);
/*     */ 
/* 424 */     return user;
/*     */   }
/*     */ 
/*     */   private UserModel getUser(String type, String tDate)
/*     */   {
/* 434 */     UserModel loginUser = null;
/* 435 */     ExeSQL exeSQL = new ExeSQL();
/* 436 */     SSRS ssrs = new SSRS();
/*     */ 
/* 438 */     String week = "";
/* 439 */     Calendar calendar = Calendar.getInstance();
/* 440 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 441 */     String d = sdf.format(calendar.getTime());
/* 442 */     Date date = null;
/*     */     try {
/* 444 */       date = sdf.parse(d);
/*     */     }
/*     */     catch (Exception e) {
/* 447 */       e.printStackTrace();
/*     */     }
/* 449 */     calendar.setTime(date);
/* 450 */     int dayOfWeek = calendar.get(7);
/*     */ 
/* 452 */     if (dayOfWeek == 2)
/* 453 */       week = "\u661F\u671F\u4E00";
/* 454 */     if (dayOfWeek == 3)
/* 455 */       week = "\u661F\u671F\u4E8C";
/* 456 */     if (dayOfWeek == 4)
/* 457 */       week = "\u661F\u671F\u4E09";
/* 458 */     if (dayOfWeek == 5)
/* 459 */       week = "\u661F\u671F\u56DB";
/* 460 */     if (dayOfWeek == 6)
/* 461 */       week = "\u661F\u671F\u4E94";
/* 462 */     if (dayOfWeek == 7)
/* 463 */       week = "\u661F\u671F\u516D";
/* 464 */     if (dayOfWeek == 1) {
/* 465 */       week = "\u661F\u671F\u65E5";
/*     */     }
/*     */ 
/* 468 */     if ((type != "") && (type.equals("LP")))
/*     */     {
/* 470 */       String branchType = "";
/* 471 */       String showAgentcode = "";
/* 472 */       String showBranchattr = "";
/* 473 */       String sql = "select a.agentcode,a.managecom,a.agentState,a.branchType,a.name from LAAgent a where 1=1 and a.agentcode = '" + this.userCode + "'";
/* 474 */       ssrs = exeSQL.execSQL(sql);
/* 475 */       if (ssrs.MaxRow > 0) {
/* 476 */         loginUser = new UserModel();
/* 477 */         loginUser.setUserCode(ssrs.GetText(1, 1));
/* 478 */         loginUser.setManageCom(ssrs.GetText(1, 2));
/* 479 */         loginUser.setUserState(ssrs.GetText(1, 3));
/*     */ 
/* 481 */         branchType = ssrs.GetText(1, 4);
/* 482 */         if ((branchType == null) || (branchType.equals("")))
/*     */         {
/* 484 */           branchType = "1";
/*     */         }
/* 486 */         loginUser.setBranchType(branchType);
/*     */ 
/* 488 */         loginUser.setLogin(true);
/* 489 */         loginUser.setName(ssrs.GetText(1, 5));
/*     */ 
/* 492 */         showAgentcode = this.mBaseMapping.resAgentMapping(ssrs.GetText(1, 1));
/* 493 */         loginUser.setShowUserCode(showAgentcode);
/*     */ 
/* 495 */         loginUser.setUserType("LP");
/*     */ 
/* 497 */         loginUser.setCalDate(PubFun.getCurrentDate());
/*     */ 
/* 499 */         loginUser.setCalWeek(week);
/* 500 */         loginUser.setLoginDate(PubFun.getCurrentDate());
/* 501 */         loginUser.setLoginTime(PubFun.getCurrentTime());
/*     */ 
/* 503 */         loginUser.setPwdLastSetDate(tDate);
/*     */ 
/* 505 */         sql = "select b.agentGrade,b.ecgrade,a.branchattr from labranchgroup a,latree b where 1=1 and a.agentgroup = b.agentgroup and b.agentcode = '" + this.userCode + "'";
/* 506 */         SSRS ssrs1 = new SSRS();
/* 507 */         ssrs1 = exeSQL.execSQL(sql);
/* 508 */         if (ssrs1.MaxRow > 0) {
/* 509 */           loginUser.setAgentGrade(ssrs1.GetText(1, 1));
/*     */ 
/* 511 */           if ((!"".equals(ssrs1.GetText(1, 1))) && (ssrs1.GetText(1, 1).compareTo("A30") > 0))
/*     */           {
/* 513 */             loginUser.setEcGrade("AM");
/*     */           }
/* 515 */           else if ((!"".equals(ssrs1.GetText(1, 1))) && (ssrs1.GetText(1, 1).compareTo("A20") > 0))
/*     */           {
/* 517 */             loginUser.setEcGrade("SM");
/*     */           }
/*     */           else
/*     */           {
/* 521 */             loginUser.setEcGrade(ssrs1.GetText(1, 2));
/*     */           }
/* 523 */           loginUser.setBranchAttr(ssrs1.GetText(1, 3));
/*     */ 
/* 526 */           showBranchattr = this.mBaseMapping.resBranchMapping(ssrs1.GetText(1, 3));
/* 527 */           loginUser.setShowBranchattr(showBranchattr);
/*     */         }
/*     */         else
/*     */         {
/* 532 */           loginUser.setAgentGrade("");
/* 533 */           loginUser.setEcGrade("");
/* 534 */           loginUser.setBranchAttr("");
/*     */ 
/* 536 */           loginUser.setShowBranchattr("");
/*     */         }
/*     */ 
/* 540 */         sql = "select magl.LoginDate,magl.LoginTime from MWebLoginLog magl where 1=1 and magl.usercode = '" + this.userCode + "' order by magl.LoginDate desc";
/* 541 */         ssrs1 = exeSQL.execSQL(sql);
/* 542 */         if (ssrs1.MaxRow > 0) {
/* 543 */           loginUser.setLastLoginDate(ssrs1.GetText(1, 1));
/* 544 */           loginUser.setLastLoginTime(ssrs1.GetText(1, 2));
/*     */         }
/*     */         else
/*     */         {
/* 548 */           loginUser.setLastLoginDate("");
/* 549 */           loginUser.setLastLoginTime("");
/*     */         }
/*     */ 
/* 552 */         sql = "select menuid from Mwebmenuctrl where 1=1  ";
/* 553 */         ssrs1 = exeSQL.execSQL(sql);
/* 554 */         if (ssrs1.MaxRow > 0) {
/* 555 */           String[] menus = new String[ssrs1.getMaxRow()];
/* 556 */           for (int i = 0; i < ssrs1.getMaxRow(); i++)
/*     */           {
/* 558 */             menus[i] = ssrs1.GetText(i + 1, 1);
/*     */           }
/* 560 */           loginUser.setMenus(menus);
/*     */         }
/*     */         else
/*     */         {
/* 564 */           String[] menus1 = { "1" };
/*     */ 
/* 566 */           loginUser.setMenus(menus1);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/* 572 */     else if ((type != "") && (type.equals("SysUser")))
/*     */     {
/* 574 */       String branchType = "";
/* 575 */       String sql = "select a.usercode,a.managecom,a.userState,a.branchType,a.username from muser a where 1=1 and a.usercode = '" + this.userCode + "'";
/* 576 */       ssrs = exeSQL.execSQL(sql);
/* 577 */       if (ssrs.MaxRow > 0) {
/* 578 */         loginUser = new UserModel();
/* 579 */         loginUser.setUserCode(ssrs.GetText(1, 1));
/* 580 */         loginUser.setManageCom(ssrs.GetText(1, 2));
/* 581 */         loginUser.setUserState(ssrs.GetText(1, 3));
/* 582 */         branchType = ssrs.GetText(1, 4);
/* 583 */         if ((branchType == null) || (branchType.equals("")))
/*     */         {
/* 585 */           branchType = "1";
/*     */         }
/* 587 */         loginUser.setBranchType(branchType);
/*     */ 
/* 589 */         loginUser.setLogin(true);
/* 590 */         loginUser.setName(ssrs.GetText(1, 5));
/*     */ 
/* 592 */         loginUser.setUserType("SysUser");
/*     */ 
/* 594 */         loginUser.setCalDate(PubFun.getCurrentDate());
/* 595 */         loginUser.setCalWeek(week);
/*     */ 
/* 597 */         loginUser.setLoginDate(PubFun.getCurrentDate());
/* 598 */         loginUser.setLoginTime(PubFun.getCurrentTime());
/*     */ 
/* 600 */         loginUser.setPwdLastSetDate(tDate);
/*     */ 
/* 602 */         loginUser.setAgentGrade("A99");
/* 603 */         loginUser.setEcGrade("");
/*     */ 
/* 605 */         SSRS ssrs1 = new SSRS();
/* 606 */         sql = "select mugl.LoginDate,mugl.LoginTime from MWebLoginLog mugl where 1=1 and mugl.usercode = '" + this.userCode + "' order by mugl.LoginDate desc";
/* 607 */         ssrs1 = exeSQL.execSQL(sql);
/* 608 */         if (ssrs1.MaxRow > 0) {
/* 609 */           loginUser.setLastLoginDate(ssrs1.GetText(1, 1));
/* 610 */           loginUser.setLastLoginTime(ssrs1.GetText(1, 2));
/*     */         }
/*     */         else
/*     */         {
/* 614 */           loginUser.setLastLoginDate("");
/* 615 */           loginUser.setLastLoginTime("");
/*     */         }
/*     */ 
/* 618 */         sql = "select menuid from Mwebmenuctrl  ";
/* 619 */         ssrs1 = exeSQL.execSQL(sql);
/* 620 */         if (ssrs1.MaxRow > 0) {
/* 621 */           String[] menus = new String[ssrs1.getMaxRow()];
/* 622 */           for (int i = 0; i < ssrs1.getMaxRow(); i++)
/*     */           {
/* 624 */             menus[i] = ssrs1.GetText(i + 1, 1);
/*     */           }
/* 626 */           loginUser.setMenus(menus);
/*     */         }
/*     */         else
/*     */         {
/* 630 */           String[] menus1 = { "1" };
/*     */ 
/* 632 */           loginUser.setMenus(menus1);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 639 */     return loginUser;
/*     */   }
/*     */ 
/*     */   private LoginModel existsPwd(LoginModel user)
/*     */   {
/* 646 */     String username = this.userCode;
/* 647 */     String password = this.password;
/* 648 */     System.out.println("\u57DF\u8D26\u53F7=" + username + "===\u57DF\u5BC6\u7801=" + password);
/* 649 */     if (!"dadmin".equalsIgnoreCase(this.userCode)) {
/* 650 */       if (!checkADLogin(username, password))
/* 651 */         user.setVerifyResult(false);
/*     */       else
/* 653 */         user.setVerifyResult(true);
/*     */     }
/*     */     else {
/* 656 */       System.out.println("&&&&\u7BA1\u7406\u5458\u8D26\u53F7");
/* 657 */       LisCompIDEA tLisCompIDEA = new LisCompIDEA();
/* 658 */       String pass = tLisCompIDEA.encryptString(password);
/*     */ 
/* 661 */       String sql = "select usercode,pwdmodifydate from muser a where 1=1 and a.usercode = '" + this.userCode + "' and a.password = '" + pass + "'";
/* 662 */       ExeSQL exeSQL = new ExeSQL();
/* 663 */       SSRS ssrs = new SSRS();
/* 664 */       ssrs = exeSQL.execSQL(sql);
/* 665 */       if ((ssrs != null) && (ssrs.MaxRow > 0))
/*     */       {
/* 667 */         user.setVerifyResult(true);
/* 668 */         user.setPwdLastSetDate(ssrs.GetText(1, 2));
/*     */       }
/*     */       else
/*     */       {
/* 672 */         user.setVerifyResult(false);
/*     */       }
/*     */     }
/* 675 */     return user;
/*     */   }
/*     */ 
/*     */   private void redirect()
/*     */   {
/* 836 */     FacesContext fc = getFacesContext();
/* 837 */     Application app = getApplication();
/* 838 */     UIViewRoot view = app.getViewHandler().createView(fc, 
/* 839 */       "/common/user/resendEmail.jsp");
/* 840 */     fc.setViewRoot(view);
/* 841 */     fc.renderResponse();
/*     */   }
/*     */ 
/*     */   public void setLogin(UserModel user, boolean hidden)
/*     */   {
/* 850 */     getWebApplication().getVisitorsOper().login(user, hidden);
/*     */   }
/*     */ 
/*     */   public void logout()
/*     */   {
/* 856 */     WebVisitor visitor = getVisitor();
/* 857 */     getWebApplication().getVisitorsOper().logout(visitor);
/* 858 */     ECPubFun.redirect2("/login.jsf");
/*     */   }
/*     */ 
/*     */   public String goToRegister()
/*     */   {
/* 864 */     return "register";
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/* 868 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String userCode) {
/* 872 */     this.userCode = userCode;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/* 876 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/* 880 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public boolean isHidden() {
/* 884 */     return this.hidden;
/*     */   }
/*     */ 
/*     */   public void setHidden(boolean hidden) {
/* 888 */     this.hidden = hidden;
/*     */   }
/*     */ 
/*     */   public String getValidateCode() {
/* 892 */     return this.validateCode;
/*     */   }
/*     */ 
/*     */   public void setValidateCode(String validateCode) {
/* 896 */     this.validateCode = validateCode;
/*     */   }
/*     */ 
/*     */   public String getTransNotice() {
/* 900 */     return this.transNotice;
/*     */   }
/*     */ 
/*     */   public void setTransNotice(String transNotice) {
/* 904 */     this.transNotice = transNotice;
/*     */   }
/*     */ 
/*     */   public String getIsSuccess() {
/* 908 */     return this.isSuccess;
/*     */   }
/*     */ 
/*     */   public void setIsUserValidateCode(String isUserValidateCode) {
/* 912 */     this.isUserValidateCode = isUserValidateCode;
/*     */   }
/*     */ 
/*     */   public String getIsUserValidateCode() {
/* 916 */     return this.isUserValidateCode;
/*     */   }
/*     */ 
/*     */   public String changePassword() {
/* 920 */     this.tempAgent = this.mBaseMapping.agentMapping(this.userCode);
/* 921 */     return this.tempAgent;
/*     */   }
/*     */ 
/*     */   public String resetPassword() {
/* 925 */     this.tempAgent = this.mBaseMapping.agentMapping(this.userCode);
/* 926 */     return this.tempAgent;
/*     */   }
/*     */ 
/*     */   private boolean checkADLogin(String username, String password)
/*     */   {
/* 938 */     boolean loginflag = false;
/* 939 */     ExeSQL exeSQL = new ExeSQL();
/* 940 */     SSRS ssrs1 = new SSRS();
/* 941 */     String ldaphostSql = "select varvalue from msysvar where vartype = 'ldap_host'";
/* 942 */     String ldapdomainSql = "select varvalue from msysvar where vartype = 'ldap_domain'";
/* 943 */     String ldapportSql = "select varvalue from msysvar where vartype = 'ldap_port'";
/* 944 */     ssrs1 = exeSQL.execSQL(ldaphostSql);
/* 945 */     String ldap_host = ssrs1.GetText(1, 1);
/*     */ 
/* 947 */     ssrs1 = exeSQL.execSQL(ldapdomainSql);
/* 948 */     String ldap_domain = ssrs1.GetText(1, 1);
/*     */ 
/* 950 */     ssrs1 = exeSQL.execSQL(ldapportSql);
/* 951 */     String ldap_port = ssrs1.GetText(1, 1);
/*     */ 
/* 956 */     String ldap_url = new String("ldap://" + ldap_host + ":" + ldap_port);
/* 957 */     String user = ldap_domain + "\\" + username;
/* 958 */     System.out.println("ldap_url--------" + ldap_url);
/* 959 */     Hashtable env = new Hashtable();
/* 960 */     DirContext ctx = null;
/* 961 */     env.put("java.naming.security.authentication", "simple");
/* 962 */     env.put("java.naming.security.principal", user);
/* 963 */     env.put("java.naming.security.credentials", password);
/* 964 */     env.put("java.naming.factory.initial", 
/* 965 */       "com.sun.jndi.ldap.LdapCtxFactory");
/* 966 */     env.put("java.naming.provider.url", ldap_url);
/*     */     try {
/* 968 */       ctx = new InitialDirContext(env);
/* 969 */       System.out.println("\u8EAB\u4EFD\u9A8C\u8BC1\u6210\u529F!");
/* 970 */       loginflag = true;
/*     */     } catch (AuthenticationException e) {
/* 972 */       System.out.println("\u8EAB\u4EFD\u9A8C\u8BC1\u5931\u8D25!");
/* 973 */       e.printStackTrace();
/*     */ 
/* 981 */       if (ctx != null)
/*     */         try {
/* 983 */           ctx.close();
/* 984 */           ctx = null;
/*     */         } catch (Exception e) {
/* 986 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     catch (CommunicationException e)
/*     */     {
/* 975 */       System.out.println("AD\u57DF\u8FDE\u63A5\u5931\u8D25!");
/* 976 */       e.printStackTrace();
/*     */ 
/* 981 */       if (ctx != null)
/*     */         try {
/* 983 */           ctx.close();
/* 984 */           ctx = null;
/*     */         } catch (Exception e) {
/* 986 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 978 */       System.out.println("\u8EAB\u4EFD\u9A8C\u8BC1\u672A\u77E5\u5F02\u5E38!");
/* 979 */       e.printStackTrace();
/*     */ 
/* 981 */       if (ctx != null)
/*     */         try {
/* 983 */           ctx.close();
/* 984 */           ctx = null;
/*     */         } catch (Exception e) {
/* 986 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     finally
/*     */     {
/* 981 */       if (ctx != null) {
/*     */         try {
/* 983 */           ctx.close();
/* 984 */           ctx = null;
/*     */         } catch (Exception e) {
/* 986 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 990 */     return loginflag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.AgentLogin
 * JD-Core Version:    0.6.0
 */