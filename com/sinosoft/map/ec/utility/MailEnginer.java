/*     */ package com.sinosoft.map.ec.utility;
/*     */ 
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sun.net.ssl.internal.ssl.Provider;
/*     */ import java.io.PrintStream;
/*     */ import java.security.Security;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import javax.mail.Folder;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Message.RecipientType;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Store;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.URLName;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ 
/*     */ public class MailEnginer extends BaseConfig
/*     */ {
/*     */   private String user;
/*     */   private String password;
/*     */   private String sendServer;
/*     */   private String sendSmtpPort;
/*     */   private String receiveServer;
/*     */   private String receivePort;
/*     */   private boolean isSSLSmtp;
/*     */   private boolean isSSLPop;
/*     */   private String portSSLSmtp;
/*     */   private String portSSLPop;
/*     */   private String serverType;
/*     */   private String from;
/*     */   private String to;
/*     */   private String subject;
/*     */   private Date sendDate;
/*     */   private String text;
/*     */ 
/*     */   public String getFrom()
/*     */   {
/*  47 */     return this.from;
/*     */   }
/*     */ 
/*     */   public void setFrom(String from)
/*     */   {
/*  55 */     this.from = from;
/*     */   }
/*     */ 
/*     */   public boolean isSSLPop()
/*     */   {
/*  63 */     return this.isSSLPop;
/*     */   }
/*     */ 
/*     */   public void setSSLPop(boolean isSSLPop)
/*     */   {
/*  71 */     this.isSSLPop = isSSLPop;
/*     */   }
/*     */ 
/*     */   public boolean isSSLSmtp()
/*     */   {
/*  79 */     return this.isSSLSmtp;
/*     */   }
/*     */ 
/*     */   public void setSSLSmtp(boolean isSSLSmtp)
/*     */   {
/*  87 */     this.isSSLSmtp = isSSLSmtp;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  95 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 103 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getPortSSLPop()
/*     */   {
/* 111 */     return this.portSSLPop;
/*     */   }
/*     */ 
/*     */   public void setPortSSLPop(String portSSLPop)
/*     */   {
/* 119 */     this.portSSLPop = portSSLPop;
/*     */   }
/*     */ 
/*     */   public String getPortSSLSmtp()
/*     */   {
/* 127 */     return this.portSSLSmtp;
/*     */   }
/*     */ 
/*     */   public void setPortSSLSmtp(String portSSLSmtp)
/*     */   {
/* 135 */     this.portSSLSmtp = portSSLSmtp;
/*     */   }
/*     */ 
/*     */   public String getReceivePort()
/*     */   {
/* 143 */     return this.receivePort;
/*     */   }
/*     */ 
/*     */   public void setReceivePort(String receivePort)
/*     */   {
/* 151 */     this.receivePort = receivePort;
/*     */   }
/*     */ 
/*     */   public String getReceiveServer()
/*     */   {
/* 159 */     return this.receiveServer;
/*     */   }
/*     */ 
/*     */   public void setReceiveServer(String receiveServer)
/*     */   {
/* 167 */     this.receiveServer = receiveServer;
/*     */   }
/*     */ 
/*     */   public String getSendServer()
/*     */   {
/* 175 */     return this.sendServer;
/*     */   }
/*     */ 
/*     */   public void setSendServer(String sendServer)
/*     */   {
/* 183 */     this.sendServer = sendServer;
/*     */   }
/*     */ 
/*     */   public String getSendSmtpPort()
/*     */   {
/* 191 */     return this.sendSmtpPort;
/*     */   }
/*     */ 
/*     */   public void setSendSmtpPort(String sendSmtpPort)
/*     */   {
/* 199 */     this.sendSmtpPort = sendSmtpPort;
/*     */   }
/*     */ 
/*     */   public Date getSendDate()
/*     */   {
/* 207 */     return this.sendDate;
/*     */   }
/*     */ 
/*     */   public void setSendDate(Date sendDate)
/*     */   {
/* 215 */     this.sendDate = sendDate;
/*     */   }
/*     */ 
/*     */   public String getServerType()
/*     */   {
/* 223 */     return this.serverType;
/*     */   }
/*     */ 
/*     */   public void setServerType(String serverType)
/*     */   {
/* 231 */     this.serverType = serverType;
/*     */   }
/*     */ 
/*     */   public String getSubject()
/*     */   {
/* 239 */     return this.subject;
/*     */   }
/*     */ 
/*     */   public void setSubject(String subject)
/*     */   {
/* 247 */     this.subject = subject;
/*     */   }
/*     */ 
/*     */   public String getText()
/*     */   {
/* 255 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/* 263 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getTo()
/*     */   {
/* 271 */     return this.to;
/*     */   }
/*     */ 
/*     */   public void setTo(String to)
/*     */   {
/* 279 */     this.to = to;
/*     */   }
/*     */ 
/*     */   public String getUser()
/*     */   {
/* 287 */     return this.user;
/*     */   }
/*     */ 
/*     */   public void setUser(String user)
/*     */   {
/* 295 */     this.user = user;
/*     */   }
/*     */ 
/*     */   public void receive()
/*     */   {
/*     */     try
/*     */     {
/* 305 */       Properties props = new Properties();
/* 306 */       Session session = null;
/* 307 */       Store store = null;
/* 308 */       Folder folder = null;
/* 309 */       if (this.isSSLPop) {
/* 310 */         Security.addProvider(new Provider());
/* 311 */         String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
/* 312 */         props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
/* 313 */         props.setProperty("mail.pop3.socketFactory.fallback", "false");
/* 314 */         props.setProperty("mail.pop3.port", this.portSSLPop);
/* 315 */         props.setProperty("mail.pop3.socketFactory.port", this.portSSLPop);
/*     */       }
/* 317 */       props.setProperty("mail.pop3.auth", "true");
/* 318 */       session = Session.getInstance(props);
/* 319 */       URLName urln = new URLName(this.serverType, this.receiveServer, 
/* 320 */         Integer.parseInt(this.receivePort), null, this.user, this.password);
/* 321 */       store = session.getStore(urln);
/* 322 */       store.connect();
/* 323 */       folder = store.getFolder("INBOX");
/* 324 */       if (folder != null) {
/* 325 */         folder.open(1);
/* 326 */         Message[] messages = folder.getMessages();
/*     */ 
/* 328 */         System.out.println("\u5171\u6709\u90AE\u4EF6\uFF1A[" + folder.getMessageCount() + "]\n");
/* 329 */         for (int i = 0; i < messages.length; i++) {
/* 330 */           System.out.println("--------Message:" + (i + 1) + "--------");
/* 331 */           messages[i].writeTo(System.out);
/*     */         }
/*     */       }
/* 334 */       folder.close(false);
/* 335 */       store.close();
/*     */     } catch (Exception err) {
/* 337 */       err.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean send()
/*     */   {
/* 343 */     Security.addProvider(new Provider());
/* 344 */     String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
/* 345 */     Properties props = System.getProperties();
/* 346 */     props.setProperty("mail.smtp.host", this.sendServer);
/* 347 */     if (this.isSSLSmtp) {
/* 348 */       props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
/* 349 */       props.setProperty("mail.smtp.socketFactory.fallback", "false");
/* 350 */       props.setProperty("mail.smtp.port", this.portSSLSmtp);
/* 351 */       props.setProperty("mail.smtp.socketFactory.port", this.portSSLSmtp);
/*     */     }
/* 353 */     props.put("mail.smtp.auth", "true");
/* 354 */     Session session = Session.getInstance(props, 
/* 355 */       new MailAuthenticator(this.user, this.password));
/*     */     try {
/* 357 */       MimeMessage mimeMess = new MimeMessage(session);
/* 358 */       mimeMess.setFrom(new InternetAddress(this.from));
/* 359 */       mimeMess.setRecipients(Message.RecipientType.TO, 
/* 360 */         InternetAddress.parse(this.to));
/* 361 */       mimeMess.setSubject(this.subject);
/* 362 */       mimeMess.setSentDate(this.sendDate);
/* 363 */       mimeMess.setText(this.text);
/* 364 */       Transport.send(mimeMess);
/* 365 */       return true;
/*     */     } catch (Exception e) {
/* 367 */       e.printStackTrace();
/* 368 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.MailEnginer
 * JD-Core Version:    0.6.0
 */