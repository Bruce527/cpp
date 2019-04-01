/*     */ package com.sinosoft.map.common;
/*     */ 
/*     */ import com.sinosoft.map.common.config.AccessauthConfig;
/*     */ import com.sinosoft.map.common.config.Configurator;
/*     */ import com.sinosoft.map.common.config.WebConfig;
/*     */ import com.sinosoft.map.common.logs.ErrorsLog;
/*     */ import com.sinosoft.map.ec.datamodel.DisaccessIP;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ 
/*     */ public class WebApplication
/*     */   implements Serializable
/*     */ {
/*  25 */   private static WebApplication _webApplication = null;
/*     */   private String _servletContextPath;
/*     */   private boolean _register;
/*     */   private boolean _login;
/*     */   private boolean _emailRegister;
/*     */   private boolean _validateRegister;
/*     */   private boolean _validateLogin;
/*     */   private boolean _upload;
/*     */   private boolean _webStatistics;
/*     */   private String _sysUserDefultPwd;
/*     */   private String _commonUserDefultPwd;
/*     */   private Map<String, String> _conEmail;
/*     */   private List<String> _admins;
/*     */   private String adminList;
/*     */   private WebConfig _webConfig;
/*     */   private static Map<String, String> _release;
/*     */   private WebVisitorEngine _webVisitorEngine;
/*     */   private AccessauthConfig _authConf;
/*     */   private List<DisaccessIP> _disaccess;
/*     */   private Map<String, String> _disaccessHashMap;
/*     */   private Map<String, String> jdbcurl;
/*     */   private Map<String, String> jdbcurlbackup;
/*     */   private String _URIPrefix;
/*     */   private Map<String, String> _defaultPassword;
/*     */   private int _totalUser;
/*     */   private UserModel _lastRegister;
/*     */ 
/*     */   public static WebApplication getInstance()
/*     */   {
/*  70 */     if (_webApplication == null)
/*     */     {
/*  73 */       _webApplication = new WebApplication();
/*     */     }
/*  75 */     return _webApplication;
/*     */   }
/*     */ 
/*     */   public String getServletContextPath()
/*     */   {
/*  80 */     return this._servletContextPath;
/*     */   }
/*     */ 
/*     */   public String getHttpContextPath()
/*     */   {
/*  85 */     FacesContext fc = FacesContext.getCurrentInstance();
/*  86 */     ExternalContext ec = fc.getExternalContext();
/*  87 */     String host = (String)ec.getRequestHeaderMap().get("host");
/*  88 */     String cPath = ec.getRequestContextPath();
/*  89 */     return "http://" + host + cPath;
/*     */   }
/*     */ 
/*     */   private void out(Object obj) {
/*  93 */     System.out.println(obj);
/*     */   }
/*     */ 
/*     */   public void init(String servletContextPath)
/*     */   {
/* 100 */     System.out.println("====================\u521D\u59CB\u5316\u914D\u7F6E\u4FE1\u606F=================");
/* 101 */     this._servletContextPath = servletContextPath;
/* 102 */     initConnection();
/* 103 */     initURIPrefix();
/* 104 */     initConfigs();
/*     */ 
/* 106 */     initAdmins();
/* 107 */     initWebConfig();
/* 108 */     initRelease();
/* 109 */     initVisitors();
/* 110 */     initAccessauths();
/* 111 */     initDisaccess();
/* 112 */     initDisaccessHashMap();
/* 113 */     initDefaultPassword();
/*     */   }
/*     */ 
/*     */   public void initConnection()
/*     */   {
/*     */     try {
/* 119 */       out("---------------\u8BFB\u53D6\u6570\u636E\u5E93\u8FDE\u63A5\u914D\u7F6E---------------");
/* 120 */       Configurator conf = new Configurator();
/*     */ 
/* 122 */       List dbconninfos = conf.getConnectionConfig();
/*     */ 
/* 124 */       for (Map db : dbconninfos)
/*     */       {
/* 126 */         String dbType = (String)db.get("DBType");
/* 127 */         out("===" + dbType);
/* 128 */         String dbIP = (String)db.get("IP");
/* 129 */         out("IP=" + dbIP);
/* 130 */         String dbPort = (String)db.get("port");
/* 131 */         String dbName = (String)db.get("DBName");
/* 132 */         String dbUserName = (String)db.get("userName");
/* 133 */         out("dbUserName=" + dbIP);
/* 134 */         String dbPassword = (String)db.get("passWord");
/* 135 */         if (((String)db.get("useto")).equals("default"))
/*     */         {
/* 137 */           this.jdbcurl = new HashMap(6);
/*     */ 
/* 139 */           this.jdbcurl.put("dbType", dbType);
/* 140 */           this.jdbcurl.put("dbIP", dbIP);
/* 141 */           this.jdbcurl.put("dbPort", dbPort);
/* 142 */           this.jdbcurl.put("dbName", dbName);
/* 143 */           this.jdbcurl.put("dbUserName", dbUserName);
/* 144 */           this.jdbcurl.put("dbPassword", dbPassword);
/*     */         }
/* 148 */         else if (((String)db.get("useto")).equals("bak"))
/*     */         {
/* 150 */           this.jdbcurlbackup = new HashMap(6);
/* 151 */           this.jdbcurlbackup.put("dbType", dbType);
/* 152 */           this.jdbcurlbackup.put("dbIP", dbIP);
/* 153 */           this.jdbcurlbackup.put("dbPort", dbPort);
/* 154 */           this.jdbcurlbackup.put("dbName", dbName);
/* 155 */           this.jdbcurlbackup.put("dbUserName", dbUserName);
/* 156 */           this.jdbcurlbackup.put("dbPassword", dbPassword);
/* 157 */           out("dllllllllllllllllllll");
/*     */         }
/*     */         else
/*     */         {
/* 161 */           ErrorsLog.log("WebApplicaiton:initConnection:dbconneciton.xml\u914D\u7F6E\u9519\u8BEF!");
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       ErrorsLog.log("\u8FDE\u63A5\u6C60\u521B\u5EFA\u8FC7\u7A0B\u4E2D\u51FA\u73B0\u9519\u8BEF" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initConfigs()
/*     */   {
/* 175 */     out("---------------\u52A0\u8F7D\u7CFB\u7EDF\u5168\u5C40\u201C\u5F00\u5173\u201D---------------");
/* 176 */     Configurator conf = new Configurator();
/* 177 */     Map displays = conf.loadDisplay();
/* 178 */     this._register = ((Boolean)displays.get("register")).booleanValue();
/* 179 */     this._login = ((Boolean)displays.get("login")).booleanValue();
/* 180 */     this._emailRegister = ((Boolean)displays.get("emailRegister")).booleanValue();
/* 181 */     this._validateRegister = ((Boolean)displays.get("validateRegister")).booleanValue();
/* 182 */     this._validateLogin = ((Boolean)displays.get("validateLogin")).booleanValue();
/* 183 */     this._upload = ((Boolean)displays.get("upload")).booleanValue();
/* 184 */     this._webStatistics = ((Boolean)displays.get("webStatistics")).booleanValue();
/* 185 */     out("register:" + this._register);
/* 186 */     out("login:" + this._login);
/* 187 */     out("emailRegister:" + this._emailRegister);
/* 188 */     out("validateRegister:" + this._validateRegister);
/* 189 */     out("validateLogin:" + this._validateLogin);
/* 190 */     out("upload:" + this._upload);
/* 191 */     out("webStatistics:" + this._webStatistics);
/*     */   }
/*     */ 
/*     */   public void reloadConfigs()
/*     */   {
/* 196 */     initConfigs();
/*     */   }
/*     */ 
/*     */   public boolean isRegister()
/*     */   {
/* 201 */     return this._register;
/*     */   }
/*     */ 
/*     */   public boolean isLogin()
/*     */   {
/* 206 */     return this._login;
/*     */   }
/*     */ 
/*     */   public boolean isEmailRegister()
/*     */   {
/* 211 */     return this._emailRegister;
/*     */   }
/*     */ 
/*     */   public boolean isValidateRegister()
/*     */   {
/* 216 */     return this._validateRegister;
/*     */   }
/*     */ 
/*     */   public boolean isValidateLogin()
/*     */   {
/* 221 */     return this._validateLogin;
/*     */   }
/*     */ 
/*     */   public boolean isWebStatistics()
/*     */   {
/* 226 */     return this._webStatistics;
/*     */   }
/*     */ 
/*     */   public boolean isUpload()
/*     */   {
/* 231 */     return this._upload;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getConEmail()
/*     */   {
/* 237 */     return this._conEmail;
/*     */   }
/*     */ 
/*     */   private void initEmail()
/*     */   {
/* 242 */     out("---------------\u521D\u59CB\u5316email\u914D\u7F6E---------------");
/* 243 */     Configurator conf = new Configurator();
/* 244 */     this._conEmail = new HashMap(12);
/* 245 */     this._conEmail = conf.loadEmailConfig();
/* 246 */     Set keys = this._conEmail.keySet();
/* 247 */     for (String key : keys)
/* 248 */       out(key + ":" + (String)this._conEmail.get(key));
/*     */   }
/*     */ 
/*     */   public void reloadEmail()
/*     */   {
/* 254 */     initEmail();
/*     */   }
/*     */ 
/*     */   public List<String> getAdmins()
/*     */   {
/* 261 */     return this._admins;
/*     */   }
/*     */ 
/*     */   public String getAdminList() {
/* 265 */     this.adminList = "";
/* 266 */     for (String admin : this._admins) {
/* 267 */       this.adminList = (this.adminList + admin + " ");
/*     */     }
/* 269 */     return this.adminList;
/*     */   }
/*     */ 
/*     */   private void initAdmins() {
/* 273 */     out("---------------\u521D\u59CB\u5316\u7BA1\u7406\u5458\u5217\u8868---------------");
/* 274 */     Configurator conf = new Configurator();
/* 275 */     this._admins = conf.loadAdmins();
/* 276 */     for (String admin : this._admins)
/* 277 */       out("admin:" + admin);
/*     */   }
/*     */ 
/*     */   private void initURIPrefix()
/*     */   {
/* 282 */     out("---------------\u52A0\u8F7D\u5E94\u7528\u53D1\u5E03\u65F6\u7684URI\u524D\u7F00---------------");
/* 283 */     Configurator conf = new Configurator();
/* 284 */     this._URIPrefix = conf.loadURIPrefix();
/*     */ 
/* 286 */     out("URIPrefix:" + this._URIPrefix);
/*     */   }
/*     */ 
/*     */   public void reloadAdmins()
/*     */   {
/* 292 */     initAdmins();
/*     */   }
/*     */ 
/*     */   public boolean isAdmin(String userId)
/*     */   {
/* 297 */     if (!this._admins.isEmpty()) {
/* 298 */       return this._admins.contains(userId);
/*     */     }
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   private void initWebConfig()
/*     */   {
/* 307 */     out("--------------- \u521D\u59CB\u5316\u7CFB\u7EDF\u7684\u4E2A\u6027\u8BBE\u7F6E---------------");
/* 308 */     this._webConfig = new WebConfig();
/* 309 */     this._webConfig.loadWebConfig();
/* 310 */     out("webname:" + this._webConfig.getWebname());
/* 311 */     out("logo:" + this._webConfig.getLogo());
/* 312 */     out("banner:" + this._webConfig.getBanner());
/* 313 */     out("icp:" + this._webConfig.getIcp());
/* 314 */     out("comment:" + this._webConfig.getComment());
/*     */   }
/*     */ 
/*     */   public void reloadWebConfig()
/*     */   {
/* 319 */     initWebConfig();
/*     */   }
/*     */ 
/*     */   public WebConfig getWebConfig()
/*     */   {
/* 325 */     return this._webConfig;
/*     */   }
/*     */ 
/*     */   private void initRelease()
/*     */   {
/* 331 */     out("---------------\u8F7D\u5165\u7F51\u7AD9\u7CFB\u7EDF\u7248\u672C\u4FE1\u606F---------------");
/* 332 */     Configurator conf = new Configurator();
/* 333 */     _release = new HashMap(5);
/* 334 */     _release = conf.loadRelease();
/* 335 */     out("version:" + (String)_release.get("version"));
/* 336 */     out("date:" + (String)_release.get("date"));
/* 337 */     out("author:" + (String)_release.get("author"));
/* 338 */     out("msn:" + (String)_release.get("msn"));
/* 339 */     out("homepage:" + (String)_release.get("homepage"));
/*     */   }
/*     */ 
/*     */   public Map<String, String> getRelease()
/*     */   {
/* 344 */     return _release;
/*     */   }
/*     */ 
/*     */   private void initVisitors()
/*     */   {
/* 351 */     this._webVisitorEngine = new WebVisitorEngine();
/* 352 */     this._webVisitorEngine.start();
/*     */   }
/*     */ 
/*     */   public WebVisitorEngine getVisitorsOper() {
/* 356 */     return this._webVisitorEngine;
/*     */   }
/*     */ 
/*     */   private void initAccessauths()
/*     */   {
/* 363 */     out("---------------\u521D\u59CB\u5316\u76EE\u5F55\u53CA\u6587\u4EF6\u8BBF\u95EE\u6743\u9650\u914D\u7F6E---------------");
/* 364 */     String authPath = this._servletContextPath + "/WEB-INF/config/common/accessauth.xml";
/* 365 */     this._authConf = new AccessauthConfig(authPath);
/* 366 */     this._authConf.showState();
/*     */   }
/*     */ 
/*     */   public AccessauthConfig getAuthConf()
/*     */   {
/* 371 */     return this._authConf;
/*     */   }
/*     */ 
/*     */   private void initDisaccess()
/*     */   {
/* 377 */     out("---------------\u8F7D\u5165\u88AB\u7981\u6B62\u8BBF\u95EE\u7F51\u7AD9\u7684IP\u5730\u5740---------------");
/* 378 */     Configurator conf = new Configurator();
/* 379 */     this._disaccess = conf.loadDisaccess();
/* 380 */     initDisaccessHashMap();
/*     */   }
/*     */ 
/*     */   private void initDisaccessHashMap() {
/* 384 */     out("---------------\u8F7D\u5165\u88AB\u7981\u6B62\u8BBF\u95EE\u7F51\u7AD9\u7684IP\u5730\u5740---------------");
/* 385 */     Configurator conf = new Configurator();
/* 386 */     Iterator tDisaccess = conf.loadDisaccess().iterator();
/* 387 */     this._disaccessHashMap = new HashMap(conf.loadDisaccess().size());
/* 388 */     while (tDisaccess.hasNext())
/*     */     {
/* 390 */       DisaccessIP t = (DisaccessIP)tDisaccess.next();
/* 391 */       this._disaccessHashMap.put(t.getIp(), t.getIp());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void reloadDisaccess()
/*     */   {
/* 397 */     initDisaccess();
/*     */   }
/*     */ 
/*     */   public List<DisaccessIP> getDisaccess()
/*     */   {
/* 402 */     return this._disaccess;
/*     */   }
/*     */   public Map getDisaccessHashMap() {
/* 405 */     return this._disaccessHashMap;
/*     */   }
/*     */ 
/*     */   public int getTotalUser()
/*     */   {
/* 419 */     return this._totalUser;
/*     */   }
/*     */ 
/*     */   public UserModel getLastRegister()
/*     */   {
/* 425 */     return this._lastRegister;
/*     */   }
/*     */ 
/*     */   public void release()
/*     */   {
/*     */     try
/*     */     {
/* 432 */       this._servletContextPath = null;
/* 433 */       this._URIPrefix = null;
/* 434 */       this._conEmail = null;
/* 435 */       this._register = false;
/* 436 */       this._login = false;
/* 437 */       this._emailRegister = false;
/* 438 */       this._validateRegister = false;
/* 439 */       this._validateLogin = false;
/* 440 */       this._webStatistics = false;
/* 441 */       this._upload = false;
/* 442 */       this._conEmail = null;
/* 443 */       this._admins = null;
/* 444 */       this._webConfig = null;
/* 445 */       _release = null;
/* 446 */       this._webVisitorEngine.release();
/* 447 */       this._webVisitorEngine = null;
/* 448 */       this._authConf = null;
/* 449 */       this._disaccess = null;
/* 450 */       this._disaccessHashMap = null;
/*     */     } catch (Exception e) {
/* 452 */       ErrorsLog.log("Exception:on release WebApplication");
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map get_jdbcurl()
/*     */   {
/* 459 */     return this.jdbcurl;
/*     */   }
/*     */ 
/*     */   public Map get_jdbcurlbackup() {
/* 463 */     return this.jdbcurlbackup;
/*     */   }
/*     */   public String get_URIPrefix() {
/* 466 */     return this._URIPrefix;
/*     */   }
/*     */ 
/*     */   public WebVisitorEngine get_webVisitorEngine() {
/* 470 */     return this._webVisitorEngine;
/*     */   }
/*     */ 
/*     */   private void initDefaultPassword()
/*     */   {
/* 475 */     out("---------------\u8F7D\u5165\u7CFB\u7EDF\u9ED8\u8BA4\u5BC6\u7801---------------");
/* 476 */     Configurator conf = new Configurator();
/* 477 */     this._defaultPassword = new HashMap(2);
/* 478 */     this._defaultPassword = conf.loadDefaultPassword();
/* 479 */     this._sysUserDefultPwd = ((String)this._defaultPassword.get("SysUserDefaultPwd"));
/* 480 */     this._commonUserDefultPwd = ((String)this._defaultPassword.get("CommonUserDefaultPwd"));
/*     */   }
/*     */ 
/*     */   public String get_sysUserDefultPwd()
/*     */   {
/* 485 */     return this._sysUserDefultPwd;
/*     */   }
/*     */ 
/*     */   public String get_commonUserDefultPwd()
/*     */   {
/* 490 */     return this._commonUserDefultPwd;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.WebApplication
 * JD-Core Version:    0.6.0
 */