/*     */ package com.sinosoft.map.common;
/*     */ 
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ public class WebVisitor extends BaseConfig
/*     */ {
/*     */   private UserModel _user;
/*     */   private boolean _login;
/*     */   private boolean _hidden;
/*     */   private String _ip;
/*     */   private String _firstTime;
/*     */   private long _lastVisitTime;
/*     */   private boolean halfLogin;
/*     */   private String operateStr;
/*     */   private String operateDate;
/*     */   private String operateTime;
/*     */ 
/*     */   public String getOperateTime()
/*     */   {
/*  33 */     return this.operateTime;
/*     */   }
/*     */ 
/*     */   public void setOperateTime(String operateTime) {
/*  37 */     this.operateTime = operateTime;
/*     */   }
/*     */ 
/*     */   public String getOperateDate() {
/*  41 */     return this.operateDate;
/*     */   }
/*     */ 
/*     */   public void setOperateDate(String operateDate) {
/*  45 */     this.operateDate = operateDate;
/*     */   }
/*     */ 
/*     */   public String getOperateStr() {
/*  49 */     return this.operateStr;
/*     */   }
/*     */ 
/*     */   public void setOperateStr(String operateStr) {
/*  53 */     this.operateStr = operateStr;
/*     */   }
/*     */ 
/*     */   public boolean isHalfLogin() {
/*  57 */     return this.halfLogin;
/*     */   }
/*     */ 
/*     */   public void setHalfLogin(boolean halfLogin) {
/*  61 */     this.halfLogin = halfLogin;
/*     */   }
/*     */ 
/*     */   public WebVisitor()
/*     */   {
/*  66 */     FacesContext fc = FacesContext.getCurrentInstance();
/*  67 */     ExternalContext ec = fc.getExternalContext();
/*  68 */     HttpServletRequest hsr = (HttpServletRequest)ec.getRequest();
/*  69 */     this._ip = hsr.getRemoteAddr();
/*     */ 
/*  72 */     this._lastVisitTime = System.currentTimeMillis();
/*     */ 
/*  75 */     Date nowTime = new Date();
/*  76 */     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
/*  77 */     this._firstTime = sdf.format(nowTime);
/*     */   }
/*     */ 
/*     */   public String getVisitorKey()
/*     */   {
/*  82 */     return this._ip;
/*     */   }
/*     */ 
/*     */   public void setUser(UserModel user)
/*     */   {
/*  87 */     this._user = user;
/*     */   }
/*     */ 
/*     */   public UserModel getUser()
/*     */   {
/*  92 */     if (this._user == null) {
/*  93 */       this._user = new UserModel();
/*     */     }
/*  95 */     return this._user;
/*     */   }
/*     */ 
/*     */   public void setLogin(boolean login)
/*     */   {
/* 100 */     this._login = login;
/*     */   }
/*     */ 
/*     */   public boolean isLogin()
/*     */   {
/* 105 */     return this._login;
/*     */   }
/*     */ 
/*     */   public void setHidden(boolean hidden)
/*     */   {
/* 110 */     this._hidden = hidden;
/*     */   }
/*     */ 
/*     */   public boolean isHidden()
/*     */   {
/* 115 */     return this._hidden;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 122 */     return this._ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 128 */     this._ip = ip;
/*     */   }
/*     */ 
/*     */   public String getFirstTime() {
/* 132 */     return this._firstTime;
/*     */   }
/*     */ 
/*     */   public void setLastVisitTime(long lastVisitTime)
/*     */   {
/* 137 */     this._lastVisitTime = lastVisitTime;
/*     */   }
/*     */ 
/*     */   public long getLastVisitTime()
/*     */   {
/* 142 */     return this._lastVisitTime;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.WebVisitor
 * JD-Core Version:    0.6.0
 */