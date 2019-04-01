/*     */ package com.sinosoft.map.common.config;
/*     */ 
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.logs.ErrorsLog;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ExpressionFactory;
/*     */ import javax.el.ValueExpression;
/*     */ import javax.faces.application.Application;
/*     */ import javax.faces.component.UIViewRoot;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public abstract class AbstractConfig
/*     */   implements Serializable
/*     */ {
/*     */   public void out(Object x)
/*     */   {
/*  29 */     System.out.println(x);
/*     */   }
/*     */ 
/*     */   public void printRequest()
/*     */   {
/*  34 */     HttpServletRequest request = (HttpServletRequest)
/*  35 */       getFacesContext().getExternalContext().getRequest();
/*  36 */     out("requestURI=" + request.getRequestURI());
/*  37 */     out("requestURL=" + request.getRequestURL().toString());
/*     */   }
/*     */ 
/*     */   public static FacesContext getFacesContext()
/*     */   {
/*  42 */     return FacesContext.getCurrentInstance();
/*     */   }
/*     */ 
/*     */   public static Application getApplication()
/*     */   {
/*  47 */     return getFacesContext().getApplication();
/*     */   }
/*     */ 
/*     */   public static ELContext getELContext()
/*     */   {
/*  52 */     return getFacesContext().getELContext();
/*     */   }
/*     */ 
/*     */   public HttpServletRequest getHttpServletRequest()
/*     */   {
/*  57 */     return (HttpServletRequest)getFacesContext().getExternalContext().getRequest();
/*     */   }
/*     */ 
/*     */   public String getContextPath()
/*     */   {
/*  62 */     return getFacesContext().getExternalContext().getRequestContextPath();
/*     */   }
/*     */ 
/*     */   public static WebApplication getWebApplication()
/*     */   {
/*  67 */     return WebApplication.getInstance();
/*     */   }
/*     */ 
/*     */   public static WebVisitor getVisitor()
/*     */   {
/*  73 */     Application app = getApplication();
/*  74 */     ELContext elc = getELContext();
/*  75 */     ExpressionFactory ef = app.getExpressionFactory();
/*  76 */     ValueExpression ve = ef.createValueExpression(elc, 
/*  77 */       "#{webVisitor}", 
/*  78 */       WebVisitor.class);
/*  79 */     WebVisitor visitor = (WebVisitor)ve.getValue(elc);
/*  80 */     if (visitor == null) {
/*  81 */       visitor = new WebVisitor();
/*  82 */       ve.setValue(elc, visitor);
/*     */     }
/*  84 */     return visitor;
/*     */   }
/*     */ 
/*     */   public String getParameter(String key)
/*     */   {
/*  89 */     String value = null;
/*  90 */     value = (String)getFacesContext().getExternalContext().getRequestParameterMap().get(key);
/*  91 */     return value;
/*     */   }
/*     */ 
/*     */   public ValueExpression getValueExpression(String name, String scope)
/*     */   {
/*  96 */     Application app = getApplication();
/*  97 */     ELContext elc = getELContext();
/*  98 */     ExpressionFactory ef = app.getExpressionFactory();
/*  99 */     ValueExpression ve = ef.createValueExpression(elc, 
/* 100 */       "#{" + scope + "." + name + "}", 
/* 101 */       Object.class);
/* 102 */     return ve;
/*     */   }
/*     */ 
/*     */   public Object getValue(String name, String scope)
/*     */   {
/* 108 */     ValueExpression ve = getValueExpression(name, scope);
/* 109 */     Object obj = ve.getValue(getELContext());
/* 110 */     return obj;
/*     */   }
/*     */ 
/*     */   public void redirect(String target)
/*     */   {
/*     */     try {
/* 116 */       FacesContext fc = getFacesContext();
/* 117 */       HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
/* 118 */       response.sendRedirect(target);
/*     */     } catch (IOException localIOException) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void redirectByContext(String target) {
/* 124 */     redirect(getContextPath() + target);
/*     */   }
/*     */ 
/*     */   public static Locale getRootLocale() {
/* 128 */     return FacesContext.getCurrentInstance().getViewRoot().getLocale();
/*     */   }
/*     */ 
/*     */   public String getBundleString(String bundleName, String sid, Object[] params)
/*     */   {
/* 133 */     String bundleString = "";
/*     */     try {
/* 135 */       ResourceBundle rb = ResourceBundle.getBundle(bundleName, getRootLocale());
/* 136 */       bundleString = rb.getString(sid);
/* 137 */       if (params != null)
/*     */       {
/* 139 */         bundleString = MessageFormat.format(bundleString, params);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 145 */       ErrorsLog.log("AbstractConfig:getBundleString:" + ex.getMessage());
/*     */     }
/* 147 */     return bundleString;
/*     */   }
/*     */ 
/*     */   public abstract String getBundle();
/*     */ 
/*     */   public abstract String getStringByID(String paramString, Object[] paramArrayOfObject);
/*     */ 
/*     */   public abstract String getDatabase();
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.config.AbstractConfig
 * JD-Core Version:    0.6.0
 */