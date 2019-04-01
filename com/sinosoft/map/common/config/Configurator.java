/*     */ package com.sinosoft.map.common.config;
/*     */ 
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import com.sinosoft.map.common.logs.ErrorsLog;
/*     */ import com.sinosoft.map.ec.datamodel.DisaccessIP;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.ec.utility.XmlParser;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ 
/*     */ public class Configurator
/*     */ {
/*     */   public Map<String, Boolean> loadDisplay()
/*     */   {
/*  29 */     Map displays = new HashMap(7);
/*     */     try {
/*  31 */       Document doc = XmlParser.getDocument(getAppConfig());
/*  32 */       Element root = doc.getDocumentElement();
/*  33 */       Element display = (Element)root
/*  34 */         .getElementsByTagName("display").item(0);
/*  35 */       Boolean register = Boolean.valueOf(display
/*  36 */         .getElementsByTagName("register").item(0).getTextContent().trim());
/*  37 */       Boolean login = Boolean.valueOf(display
/*  38 */         .getElementsByTagName("login").item(0).getTextContent().trim());
/*  39 */       Boolean emailRegister = Boolean.valueOf(display
/*  40 */         .getElementsByTagName("email-register").item(0).getTextContent().trim());
/*  41 */       Boolean validateRegister = Boolean.valueOf(display
/*  42 */         .getElementsByTagName("validate-register").item(0).getTextContent().trim());
/*  43 */       Boolean validateLogin = Boolean.valueOf(display
/*  44 */         .getElementsByTagName("validate-login").item(0).getTextContent().trim());
/*  45 */       Boolean upload = Boolean.valueOf(display
/*  46 */         .getElementsByTagName("upload").item(0).getTextContent().trim());
/*  47 */       Boolean webStatistics = Boolean.valueOf(display
/*  48 */         .getElementsByTagName("webStatistics").item(0).getTextContent().trim());
/*  49 */       displays.put("register", register);
/*  50 */       System.out.println(login + "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
/*  51 */       displays.put("login", login);
/*  52 */       displays.put("emailRegister", emailRegister);
/*  53 */       displays.put("validateRegister", validateRegister);
/*  54 */       displays.put("validateLogin", validateLogin);
/*  55 */       displays.put("upload", upload);
/*  56 */       displays.put("webStatistics", webStatistics);
/*     */     } catch (Exception e) {
/*  58 */       ErrorsLog.log("Exception:Configurator:loadDisplay:" + e.getMessage());
/*     */     }
/*  60 */     return displays;
/*     */   }
/*     */ 
/*     */   public void updateDisplay(Map<String, Boolean> displays)
/*     */   {
/*  65 */     Boolean register = (Boolean)displays.get("register");
/*  66 */     Boolean login = (Boolean)displays.get("login");
/*  67 */     Boolean emailRegister = (Boolean)displays.get("emailRegister");
/*  68 */     Boolean validateRegister = (Boolean)displays.get("validateRegister");
/*  69 */     Boolean validateLogin = (Boolean)displays.get("validateLogin");
/*  70 */     Boolean upload = (Boolean)displays.get("upload");
/*  71 */     Boolean webStatistics = (Boolean)displays.get("webStatistics");
/*     */     try {
/*  73 */       Document doc = XmlParser.getDocument(getAppConfig());
/*  74 */       Element root = doc.getDocumentElement();
/*  75 */       Element dis = (Element)root.getElementsByTagName("display").item(0);
/*  76 */       if (register != null) dis.getElementsByTagName("register")
/*  77 */           .item(0).setTextContent(String.valueOf(register));
/*  78 */       if (login != null) dis.getElementsByTagName("login")
/*  79 */           .item(0).setTextContent(String.valueOf(login));
/*  80 */       if (emailRegister != null) dis.getElementsByTagName("email-register")
/*  81 */           .item(0).setTextContent(String.valueOf(emailRegister));
/*  82 */       if (validateRegister != null) dis.getElementsByTagName("validate-register")
/*  83 */           .item(0).setTextContent(String.valueOf(validateRegister));
/*  84 */       if (validateLogin != null) dis.getElementsByTagName("validate-login")
/*  85 */           .item(0).setTextContent(String.valueOf(validateLogin));
/*  86 */       if (upload != null) dis.getElementsByTagName("upload")
/*  87 */           .item(0).setTextContent(String.valueOf(upload));
/*  88 */       if (webStatistics != null) dis.getElementsByTagName("webStatistics")
/*  89 */           .item(0).setTextContent(String.valueOf(webStatistics));
/*  90 */       XmlParser.saveDocument(doc, getAppConfig());
/*     */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*  93 */       ErrorsLog.log("Exception:Configurator:updateDisplay:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map<String, String> loadEmailConfig() {
/*  98 */     Map emailConfig = new HashMap(12);
/*     */     try {
/* 100 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 101 */       Element root = doc.getDocumentElement();
/* 102 */       Element email = (Element)root.getElementsByTagName("email-config")
/* 103 */         .item(0);
/* 104 */       String serverType = email.getElementsByTagName("server-type")
/* 105 */         .item(0).getTextContent().trim();
/* 106 */       String serverSend = email.getElementsByTagName("server-send")
/* 107 */         .item(0).getTextContent().trim();
/* 108 */       String serverReceive = email.getElementsByTagName("server-receive")
/* 109 */         .item(0).getTextContent().trim();
/* 110 */       String portSmtp = email.getElementsByTagName("port-smtp")
/* 111 */         .item(0).getTextContent().trim();
/* 112 */       String portPop = email.getElementsByTagName("port-pop")
/* 113 */         .item(0).getTextContent().trim();
/* 114 */       String isSSLSmtp = email.getElementsByTagName("is-ssl-smtp")
/* 115 */         .item(0).getTextContent().trim();
/* 116 */       String isSSLPop = email.getElementsByTagName("is-ssl-pop")
/* 117 */         .item(0).getTextContent().trim();
/* 118 */       String portSSLSmtp = email.getElementsByTagName("port-ssl-smtp")
/* 119 */         .item(0).getTextContent().trim();
/* 120 */       String portSSLPop = email.getElementsByTagName("port-ssl-pop")
/* 121 */         .item(0).getTextContent().trim();
/* 122 */       String address = email.getElementsByTagName("address")
/* 123 */         .item(0).getTextContent().trim();
/* 124 */       String user = email.getElementsByTagName("user")
/* 125 */         .item(0).getTextContent().trim();
/* 126 */       String password = email.getElementsByTagName("password")
/* 127 */         .item(0).getTextContent().trim();
/*     */ 
/* 129 */       emailConfig.put("serverType", serverType);
/* 130 */       emailConfig.put("serverSend", serverSend);
/* 131 */       emailConfig.put("serverReceive", serverReceive);
/* 132 */       emailConfig.put("portSmtp", portSmtp);
/* 133 */       emailConfig.put("portPop", portPop);
/* 134 */       emailConfig.put("isSSLSmtp", isSSLSmtp);
/* 135 */       emailConfig.put("isSSLPop", isSSLPop);
/* 136 */       emailConfig.put("portSSLSmtp", portSSLSmtp);
/* 137 */       emailConfig.put("portSSLPop", portSSLPop);
/* 138 */       emailConfig.put("address", address);
/* 139 */       emailConfig.put("user", user);
/* 140 */       emailConfig.put("password", password);
/*     */     } catch (Exception e) {
/* 142 */       ErrorsLog.log("Exception:Configurator:loadEmailConfig:" + e.getMessage());
/*     */     }
/* 144 */     return emailConfig;
/*     */   }
/*     */ 
/*     */   public void updateEmailConfig(Map<String, String> configs)
/*     */   {
/* 155 */     String serverType = (String)configs.get("serverType");
/* 156 */     String serverSend = (String)configs.get("serverSend");
/* 157 */     String serverReceive = (String)configs.get("serverReceive");
/* 158 */     String portSmtp = (String)configs.get("portSmtp");
/* 159 */     String portPop = (String)configs.get("portPop");
/* 160 */     String isSSLSmtp = (String)configs.get("isSSLSmtp");
/* 161 */     String isSSLPop = (String)configs.get("isSSLPop");
/* 162 */     String portSSLSmtp = (String)configs.get("portSSLSmtp");
/* 163 */     String portSSLPop = (String)configs.get("portSSLPop");
/* 164 */     String address = (String)configs.get("address");
/* 165 */     String user = (String)configs.get("user");
/* 166 */     String password = (String)configs.get("password");
/*     */     try {
/* 168 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 169 */       Element root = doc.getDocumentElement();
/* 170 */       Element email = (Element)root.getElementsByTagName("email-config").item(0);
/* 171 */       if (serverType != null) email.getElementsByTagName("server-type").item(0)
/* 172 */           .setTextContent(serverType);
/* 173 */       if (serverSend != null) email.getElementsByTagName("server-send").item(0)
/* 174 */           .setTextContent(serverSend);
/* 175 */       if (serverReceive != null) email.getElementsByTagName("server-receive").item(0)
/* 176 */           .setTextContent(serverReceive);
/* 177 */       if (portSmtp != null) email.getElementsByTagName("port-smtp").item(0)
/* 178 */           .setTextContent(portSmtp);
/* 179 */       if (portPop != null) email.getElementsByTagName("port-pop").item(0)
/* 180 */           .setTextContent(portPop);
/* 181 */       if (isSSLSmtp != null) email.getElementsByTagName("is-ssl-smtp").item(0)
/* 182 */           .setTextContent(isSSLSmtp);
/* 183 */       if (isSSLPop != null) email.getElementsByTagName("is-ssl-pop").item(0)
/* 184 */           .setTextContent(isSSLPop);
/* 185 */       if (portSSLSmtp != null) email.getElementsByTagName("port-ssl-smtp").item(0)
/* 186 */           .setTextContent(portSSLSmtp);
/* 187 */       if (portSSLPop != null) email.getElementsByTagName("port-ssl-pop").item(0)
/* 188 */           .setTextContent(portSSLPop);
/* 189 */       if (address != null) email.getElementsByTagName("address").item(0)
/* 190 */           .setTextContent(address);
/* 191 */       if (user != null) email.getElementsByTagName("user").item(0)
/* 192 */           .setTextContent(user);
/* 193 */       if (password != null) email.getElementsByTagName("password").item(0)
/* 194 */           .setTextContent(password);
/* 195 */       XmlParser.saveDocument(doc, getAppConfig());
/*     */     } catch (Exception e) {
/* 197 */       ErrorsLog.log("Exception:Configurator:updateEmailConfig:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<String> loadAdmins() {
/* 202 */     List admins = new ArrayList(2);
/*     */     try {
/* 204 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 205 */       Element root = doc.getDocumentElement();
/* 206 */       Element adminList = (Element)root.getElementsByTagName("admin-list").item(0);
/* 207 */       NodeList ads = adminList.getElementsByTagName("id");
/* 208 */       for (int i = 0; i < ads.getLength(); i++) {
/* 209 */         String admin = ads.item(i).getTextContent().trim();
/* 210 */         admins.add(admin);
/*     */       }
/*     */     } catch (Exception e) {
/* 213 */       ErrorsLog.log("Exception:Configurator:loadAdmins:" + e.getMessage());
/*     */     }
/* 215 */     return admins;
/*     */   }
/*     */ 
/*     */   public String loadURIPrefix()
/*     */   {
/* 223 */     String uriPrefix = "";
/*     */     try {
/* 225 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 226 */       Element root = doc.getDocumentElement();
/* 227 */       Element uriList = (Element)root.getElementsByTagName("init-uri").item(0);
/* 228 */       NodeList nl = uriList.getElementsByTagName("context");
/* 229 */       uriPrefix = nl.item(0).getTextContent().trim();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 233 */       ErrorsLog.log("Exception:ConfigOper:loadAdmins:" + e.getMessage());
/*     */     }
/* 235 */     return uriPrefix.trim();
/*     */   }
/*     */   public void loadWebConfig(WebConfig tWebConfig) {
/*     */     try {
/* 239 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 240 */       Element root = doc.getDocumentElement();
/* 241 */       Element setting = (Element)root.getElementsByTagName("webconfig")
/* 242 */         .item(0);
/* 243 */       String webname = setting.getElementsByTagName("webname")
/* 244 */         .item(0).getTextContent().trim();
/*     */ 
/* 246 */       String logo = setting.getElementsByTagName("logo")
/* 247 */         .item(0).getTextContent().trim();
/* 248 */       String banner = setting.getElementsByTagName("banner")
/* 249 */         .item(0).getTextContent().trim();
/* 250 */       String icp = setting.getElementsByTagName("icp")
/* 251 */         .item(0).getTextContent().trim();
/* 252 */       String comment = setting.getElementsByTagName("comment")
/* 253 */         .item(0).getTextContent().trim();
/* 254 */       tWebConfig.setBanner(banner);
/* 255 */       tWebConfig.setComment(comment);
/* 256 */       tWebConfig.setIcp(icp);
/* 257 */       tWebConfig.setLogo(logo);
/* 258 */       tWebConfig.setWebname(webname);
/*     */     } catch (Exception e) {
/* 260 */       ErrorsLog.log("Exception:Configurator:loadWebConfig:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateWebConfig(WebConfig tWebConfig)
/*     */   {
/*     */     try
/*     */     {
/* 269 */       String webname = tWebConfig.getWebname();
/* 270 */       String logo = tWebConfig.getLogo();
/* 271 */       String banner = tWebConfig.getBanner();
/* 272 */       String icp = tWebConfig.getIcp();
/* 273 */       String comment = tWebConfig.getComment();
/* 274 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 275 */       Element root = doc.getDocumentElement();
/* 276 */       Element mysetting = (Element)root.getElementsByTagName("mysetting").item(0);
/* 277 */       if ((webname != null) && (!webname.equals(""))) {
/* 278 */         mysetting.getElementsByTagName("webname").item(0).setTextContent(webname.trim());
/*     */       }
/* 280 */       if ((logo != null) && (!logo.equals(""))) {
/* 281 */         mysetting.getElementsByTagName("logo").item(0).setTextContent(logo.trim());
/*     */       }
/* 283 */       if (banner != null) {
/* 284 */         mysetting.getElementsByTagName("banner").item(0).setTextContent(banner.trim());
/*     */       }
/* 286 */       if ((icp != null) && (!icp.equals(""))) {
/* 287 */         mysetting.getElementsByTagName("icp").item(0).setTextContent(icp.trim());
/*     */       }
/* 289 */       if ((comment != null) && (!comment.equals(""))) {
/* 290 */         mysetting.getElementsByTagName("comment").item(0).setTextContent(comment.trim());
/*     */       }
/* 292 */       XmlParser.saveDocument(doc, getAppConfig());
/*     */     } catch (Exception e) {
/* 294 */       ErrorsLog.log("Exception:Configurator:updateWebConfig:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map<String, String> loadRelease() {
/* 299 */     Map release = new HashMap(5);
/*     */     try {
/* 301 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 302 */       Element root = doc.getDocumentElement();
/* 303 */       Element rel = (Element)root.getElementsByTagName("release").item(0);
/* 304 */       String version = rel.getElementsByTagName("version").item(0)
/* 305 */         .getTextContent().trim();
/* 306 */       String date = rel.getElementsByTagName("date").item(0)
/* 307 */         .getTextContent().trim();
/* 308 */       String author = rel.getElementsByTagName("author").item(0)
/* 309 */         .getTextContent().trim();
/* 310 */       String msn = rel.getElementsByTagName("msn").item(0)
/* 311 */         .getTextContent().trim();
/* 312 */       String homepage = rel.getElementsByTagName("homepage").item(0)
/* 313 */         .getTextContent().trim();
/* 314 */       release.put("version", version);
/* 315 */       release.put("date", date);
/* 316 */       release.put("author", author);
/* 317 */       release.put("msn", msn);
/* 318 */       release.put("homepage", homepage);
/*     */     } catch (Exception e) {
/* 320 */       ErrorsLog.log("Exception:Configurator:loadRelease:" + e.getMessage());
/*     */     }
/* 322 */     return release;
/*     */   }
/*     */ 
/*     */   public List<DisaccessIP> loadDisaccess()
/*     */   {
/* 330 */     List disallows = new ArrayList();
/*     */     try {
/* 332 */       String filePath = WebApplication.getInstance().getServletContextPath() + "/WEB-INF/config/common/disaccess.xml";
/* 333 */       Document doc = XmlParser.getDocument(filePath);
/* 334 */       Element root = doc.getDocumentElement();
/* 335 */       NodeList ips = root.getElementsByTagName("ip");
/* 336 */       for (int i = 0; i < ips.getLength(); i++)
/*     */       {
/* 338 */         String ip = ips.item(i).getTextContent().trim();
/* 339 */         NamedNodeMap attributes = ips.item(i).getAttributes();
/* 340 */         Node timeNode = attributes.getNamedItem("time");
/* 341 */         String time = timeNode.getTextContent();
/* 342 */         System.out.println("ip=" + ip + ",time=" + time);
/* 343 */         DisaccessIP tDisaccessIP = new DisaccessIP();
/* 344 */         tDisaccessIP.setIp(ip);
/* 345 */         tDisaccessIP.setTime(time);
/* 346 */         disallows.add(tDisaccessIP);
/*     */       }
/*     */     } catch (Exception e) {
/* 349 */       ErrorsLog.log("Exception:Configurator:loadDisaccesss:" + e.getMessage());
/*     */     }
/* 351 */     return disallows;
/*     */   }
/*     */ 
/*     */   public static synchronized void addDisaccess(String ip)
/*     */   {
/*     */     try
/*     */     {
/* 361 */       String filePath = WebApplication.getInstance().getServletContextPath() + 
/* 362 */         "/WEB-INF/config/common/disaccess.xml";
/* 363 */       Document doc = XmlParser.getDocument(filePath);
/* 364 */       Element root = doc.getDocumentElement();
/* 365 */       NodeList ips = root.getElementsByTagName("ip");
/* 366 */       for (int i = 0; i < ips.getLength(); i++) {
/* 367 */         Element temp = (Element)ips.item(i);
/* 368 */         if (temp.getTextContent().trim().equals(ip)) {
/* 369 */           return;
/*     */         }
/*     */       }
/* 372 */       Element eIP = doc.createElement("ip");
/* 373 */       Text eIP_text = doc.createTextNode(ip);
/* 374 */       eIP.appendChild(eIP_text);
/* 375 */       eIP.setAttribute("time", ECPubFun.getCurrentDate() + " " + ECPubFun.getCurrentTime());
/* 376 */       root.appendChild(eIP);
/*     */ 
/* 378 */       XmlParser.saveDocument(doc, filePath);
/*     */     } catch (Exception e) {
/* 380 */       ErrorsLog.log("Exception:addDisaccess::" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeDisaccess(String ip)
/*     */   {
/*     */     try
/*     */     {
/* 388 */       String filePath = WebApplication.getInstance().getServletContextPath() + 
/* 389 */         "/WEB-INF/config/common/disaccess.xml";
/* 390 */       Document doc = XmlParser.getDocument(filePath);
/* 391 */       Element root = doc.getDocumentElement();
/* 392 */       NodeList ips = root.getElementsByTagName("ip");
/* 393 */       for (int i = 0; i < ips.getLength(); i++) {
/* 394 */         Element temp = (Element)ips.item(i);
/* 395 */         if (temp.getTextContent().trim().equals(ip)) {
/* 396 */           root.removeChild(temp);
/* 397 */           break;
/*     */         }
/*     */       }
/* 400 */       XmlParser.saveDocument(doc, filePath);
/*     */     } catch (Exception e) {
/* 402 */       ErrorsLog.log("Exception:removeDisaccess:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<Map<String, String>> getConnectionConfig()
/*     */   {
/* 408 */     List conns = new ArrayList(2);
/*     */     try {
/* 410 */       String filePath = WebApplication.getInstance().getServletContextPath() + 
/* 411 */         "/WEB-INF/config/dbconn/dbconnection.xml";
/*     */ 
/* 413 */       filePath = "C:\\Kevin_File\\Java\\workspace\\MDES\\WebContent\\WEB-INF\\config\\dbconn\\dbconnection.xml";
/* 414 */       Document doc = XmlParser.getDocument(filePath);
/* 415 */       Element root = doc.getDocumentElement();
/* 416 */       NodeList dbs = root.getElementsByTagName("database");
/* 417 */       for (int i = 0; i < dbs.getLength(); i++)
/*     */       {
/* 419 */         Element db = (Element)dbs.item(i);
/* 420 */         String useto = db.getElementsByTagName("Useto").item(0).getTextContent().trim();
/* 421 */         String DBType = db.getElementsByTagName("DBType").item(0).getTextContent().trim();
/* 422 */         String IP = db.getElementsByTagName("IP").item(0).getTextContent().trim();
/* 423 */         String port = db.getElementsByTagName("Port").item(0).getTextContent().trim();
/* 424 */         String DBName = db.getElementsByTagName("DBName").item(0).getTextContent().trim();
/* 425 */         String userName = db.getElementsByTagName("UserName").item(0).getTextContent().trim();
/* 426 */         String passWord = db.getElementsByTagName("PassWord").item(0).getTextContent().trim();
/*     */ 
/* 428 */         Map dbm = new HashMap(5);
/* 429 */         dbm.put("useto", useto);
/* 430 */         dbm.put("DBType", DBType);
/* 431 */         dbm.put("IP", IP);
/* 432 */         dbm.put("port", port);
/* 433 */         dbm.put("DBName", DBName);
/* 434 */         dbm.put("userName", userName);
/* 435 */         dbm.put("passWord", passWord);
/* 436 */         conns.add(dbm);
/*     */       }
/*     */     } catch (Exception e) {
/* 439 */       ErrorsLog.log("Exception:ConfigOper:getConnection:" + e.getMessage());
/*     */     }
/* 441 */     return conns;
/*     */   }
/*     */ 
/*     */   private String getAppConfig()
/*     */   {
/* 446 */     return WebApplication.getInstance().getServletContextPath() + 
/* 447 */       "/WEB-INF/config/app-config.xml";
/*     */   }
/*     */ 
/*     */   public Map<String, String> loadDefaultPassword()
/*     */   {
/* 452 */     Map pwdConfig = new HashMap(2);
/*     */     try
/*     */     {
/* 456 */       Document doc = XmlParser.getDocument(getAppConfig());
/* 457 */       Element root = doc.getDocumentElement();
/* 458 */       Element topNode = (Element)root.getElementsByTagName("default-password").item(0);
/*     */ 
/* 460 */       String SysUserDefaultPwd = topNode.getElementsByTagName("SysUser").item(0).getTextContent().trim();
/* 461 */       String CommonUserDefaultPwd = topNode.getElementsByTagName("CommonUser").item(0).getTextContent().trim();
/*     */ 
/* 463 */       pwdConfig.put("SysUserDefaultPwd", SysUserDefaultPwd);
/* 464 */       pwdConfig.put("CommonUserDefaultPwd", CommonUserDefaultPwd);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 468 */       ErrorsLog.log("Exception:Configurator:loadDefaultPassword:" + ex.getMessage());
/*     */     }
/*     */ 
/* 471 */     return pwdConfig;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.Configurator
 * JD-Core Version:    0.6.0
 */