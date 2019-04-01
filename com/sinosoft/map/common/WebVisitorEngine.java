/*     */ package com.sinosoft.map.common;
/*     */ 
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sinosoft.map.common.logs.VisitorLog;
/*     */ import com.sinosoft.map.common.logs.WebLoginLogDB;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ExpressionFactory;
/*     */ import javax.el.ValueExpression;
/*     */ import javax.faces.application.Application;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class WebVisitorEngine extends BaseConfig
/*     */ {
/*     */   private Map<String, WebVisitor> _visitors;
/*  24 */   private int _freeTime = 60;
/*  25 */   private long _interval = 30L;
/*     */   private Thread _vListener;
/*     */   private int _totalOnline;
/*     */   private int _totalUser;
/*     */   private int _totalHidden;
/*     */   private int _totalGuest;
/*     */   private VisitorLog _visitorLog;
/*     */ 
/*     */   public WebVisitorEngine()
/*     */   {
/*  35 */     this._visitors = new HashMap();
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/*  40 */     initVisitorLog();
/*     */   }
/*     */ 
/*     */   public Map<String, WebVisitor> getVisitors()
/*     */   {
/*  47 */     return this._visitors;
/*     */   }
/*     */ 
/*     */   public List<WebVisitor> getVisitorsList()
/*     */   {
/*  52 */     List visitors = new ArrayList();
/*  53 */     Set keys = this._visitors.keySet();
/*  54 */     for (String key : keys) {
/*  55 */       WebVisitor visitor = (WebVisitor)this._visitors.get(key);
/*  56 */       if (visitor.isLogin())
/*  57 */         visitors.add(0, visitor);
/*     */       else {
/*  59 */         visitors.add(visitor);
/*     */       }
/*     */     }
/*  62 */     return visitors;
/*     */   }
/*     */ 
/*     */   public int getTotalOnline()
/*     */   {
/*  67 */     return this._totalOnline;
/*     */   }
/*     */ 
/*     */   public void setTotalOnline(int totalOnline) {
/*  71 */     this._totalOnline = totalOnline;
/*     */   }
/*     */ 
/*     */   public int getTotalUser()
/*     */   {
/*  76 */     return this._totalUser;
/*     */   }
/*     */ 
/*     */   public int getTotalHidden()
/*     */   {
/*  81 */     return this._totalHidden;
/*     */   }
/*     */ 
/*     */   public int getTotalGuest()
/*     */   {
/*  86 */     return this._totalGuest;
/*     */   }
/*     */ 
/*     */   public boolean checkAllow(String ip)
/*     */   {
/*  91 */     HashMap disallows = (HashMap)getWebApplication().getDisaccessHashMap();
/*     */ 
/*  96 */     return disallows.get(ip) == null;
/*     */   }
/*     */ 
/*     */   public void checkVisitor(WebVisitor visitor)
/*     */   {
/* 105 */     if (visitor.isLogin())
/*     */     {
/* 108 */       addVisitor(visitor);
/*     */ 
/* 111 */       if (WebLoginLogDB.saveLoginLog(visitor))
/*     */       {
/* 113 */         System.out.println("\u6709\u7528\u6237\u767B\u9646,\u8BB0\u5F55\u5B8C\u6BD5");
/*     */       }
/*     */       else
/*     */       {
/* 117 */         System.out.println("\u6709\u7528\u6237\u767B\u9646,\u8BB0\u5F55\u51FA\u73B0\u5F02\u5E38");
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 126 */       System.out.println("\u65E0\u7528\u6237\u767B\u9646");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addVisitor(WebVisitor visitor)
/*     */   {
/* 133 */     HttpSession session = (HttpSession)getFacesContext().getExternalContext().getSession(false);
/*     */ 
/* 135 */     this._visitors.put(session.getId(), visitor);
/*     */ 
/* 137 */     this._totalOnline += 1;
/*     */   }
/*     */ 
/*     */   public void removeVisitor(WebVisitor visitor)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void login(UserModel user, boolean hidden)
/*     */   {
/* 156 */     Application app = getApplication();
/* 157 */     ELContext elc = getELContext();
/* 158 */     ExpressionFactory ef = app.getExpressionFactory();
/*     */ 
/* 160 */     ValueExpression ve = ef.createValueExpression(elc, 
/* 161 */       "#{webVisitor}", 
/* 162 */       WebVisitor.class);
/*     */ 
/* 164 */     WebVisitor visitor = null;
/*     */     try {
/* 166 */       visitor = (WebVisitor)ve.getValue(elc);
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/* 170 */     if (user != null)
/*     */     {
/* 174 */       if (visitor != null)
/*     */       {
/* 177 */         System.out.println("============webvisitor\u5DF2\u7ECF\u88AB\u52A0\u8F7D==========");
/*     */ 
/* 179 */         visitor.setUser(user);
/* 180 */         visitor.setLogin(true);
/* 181 */         visitor.setHidden(hidden);
/*     */       }
/*     */       else
/*     */       {
/* 187 */         System.out.println("============webvisitor\u5C1A\u672A\u52A0\u8F7D==========");
/*     */ 
/* 189 */         visitor = new WebVisitor();
/* 190 */         visitor.setUser(user);
/* 191 */         visitor.setLogin(true);
/* 192 */         visitor.setHidden(hidden);
/* 193 */         ve.setValue(elc, visitor);
/*     */       }
/*     */ 
/* 196 */       System.out.println("============checkVisitor==========");
/* 197 */       checkVisitor(visitor);
/*     */     }
/* 202 */     else if (visitor != null)
/*     */     {
/* 204 */       visitor.setHalfLogin(true);
/*     */     }
/*     */     else
/*     */     {
/* 210 */       visitor = new WebVisitor();
/* 211 */       visitor.setHalfLogin(true);
/* 212 */       ve.setValue(elc, visitor);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void logout(WebVisitor visitor)
/*     */   {
/* 230 */     WebLoginLogDB.saveLogoutLog(visitor);
/*     */ 
/* 232 */     HttpSession session = (HttpSession)getFacesContext()
/* 233 */       .getExternalContext().getSession(false);
/* 234 */     if (session != null)
/* 235 */       session.invalidate();
/*     */   }
/*     */ 
/*     */   public void showVisitors()
/*     */   {
/* 244 */     if (!this._visitors.isEmpty()) {
/* 245 */       Set keys = this._visitors.keySet();
/* 246 */       System.out.println("--------visitors state");
/* 247 */       for (String key : keys)
/* 248 */         System.out.println(key + ":" + ((WebVisitor)this._visitors.get(key)).getUser().getUserCode());
/*     */     }
/*     */     else {
/* 251 */       System.out.println("no visitors");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void showOnline()
/*     */   {
/* 257 */     System.out.println("totalOnline:" + this._totalOnline);
/* 258 */     System.out.println("totalUser:" + this._totalUser);
/* 259 */     System.out.println("totalHidden:" + this._totalHidden);
/* 260 */     System.out.println("totalGuest:" + this._totalGuest);
/*     */   }
/*     */ 
/*     */   private void initVisitorLog()
/*     */   {
/* 265 */     this._visitorLog = new VisitorLog();
/*     */   }
/*     */ 
/*     */   public VisitorLog getVlog()
/*     */   {
/* 270 */     return this._visitorLog;
/*     */   }
/*     */ 
/*     */   public void release() {
/* 274 */     this._vListener = null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.WebVisitorEngine
 * JD-Core Version:    0.6.0
 */