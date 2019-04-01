/*     */ package com.sinosoft.map.ec.utility;
/*     */ 
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ExpressionFactory;
/*     */ import javax.el.ValueExpression;
/*     */ import javax.faces.application.Application;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.application.ViewHandler;
/*     */ import javax.faces.component.UIViewRoot;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ 
/*     */ public class ECPubFun
/*     */ {
/*     */   protected static ClassLoader getCurrentClassLoader(Object defaultObject)
/*     */   {
/*  30 */     ClassLoader loader = Thread.currentThread().getContextClassLoader();
/*  31 */     if (loader == null) {
/*  32 */       loader = defaultObject.getClass().getClassLoader();
/*     */     }
/*  34 */     return loader;
/*     */   }
/*     */ 
/*     */   public static Locale getLocale()
/*     */   {
/*  39 */     return FacesContext.getCurrentInstance().getViewRoot().getLocale();
/*     */   }
/*     */ 
/*     */   public static String getDisplayString(String bundleName, String id, Object[] params)
/*     */   {
/*  46 */     String text = null;
/*     */     try
/*     */     {
/*  49 */       bundle = ResourceBundle.getBundle(bundleName, getLocale(), 
/*  50 */         getCurrentClassLoader(params));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       ResourceBundle bundle;
/*  52 */       return id;
/*     */     }
/*     */     try
/*     */     {
/*     */       ResourceBundle bundle;
/*  55 */       text = bundle.getString(id);
/*     */     } catch (MissingResourceException e) {
/*  57 */       text = "[" + id + "]";
/*     */     }
/*  59 */     if (params != null) {
/*  60 */       MessageFormat mf = new MessageFormat(text, getLocale());
/*  61 */       text = mf.format(params, new StringBuffer(), null).toString();
/*     */     }
/*  63 */     return text;
/*     */   }
/*     */ 
/*     */   public static void addMessage(String type, String bundleName, String id, Object[] params)
/*     */   {
/*  68 */     FacesContext facesContext = FacesContext.getCurrentInstance();
/*  69 */     String summary = getDisplayString(bundleName, type, null);
/*  70 */     String detail = getDisplayString(bundleName, id, params);
/*  71 */     FacesMessage message = null;
/*  72 */     if (type.equals("Info"))
/*  73 */       message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
/*  74 */     else if (type.equals("Warn"))
/*  75 */       message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
/*  76 */     else if (type.equals("Error"))
/*  77 */       message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
/*  78 */     else if (type.equals("Fatal")) {
/*  79 */       message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
/*     */     }
/*  81 */     facesContext.addMessage(null, message);
/*     */   }
/*     */ 
/*     */   public static void addInfoMessage(String bundleName, String id, Object[] params) {
/*  85 */     addMessage("Info", bundleName, id, params);
/*     */   }
/*     */   public static void addWarnMessage(String bundleName, String id, Object[] params) {
/*  88 */     addMessage("Warn", bundleName, id, params);
/*     */   }
/*     */   public static void addErrorMessage(String bundleName, String id, Object[] params) {
/*  91 */     addMessage("Error", bundleName, id, params);
/*     */   }
/*     */   public static void addFatalMessage(String bundleName, String id, Object[] params) {
/*  94 */     addMessage("Fatal", bundleName, id, params);
/*     */   }
/*     */ 
/*     */   public static void addInfoMessage(String bundleName, String id)
/*     */   {
/*  99 */     addMessage("Info", bundleName, id, null);
/*     */   }
/*     */   public static void addWarnMessage(String bundleName, String id) {
/* 102 */     addMessage("Warn", bundleName, id, null);
/*     */   }
/*     */   public static void addErrorMessage(String bundleName, String id) {
/* 105 */     addMessage("Error", bundleName, id, null);
/*     */   }
/*     */   public static void addFatalMessage(String bundleName, String id) {
/* 108 */     addMessage("Fatal", bundleName, id, null);
/*     */   }
/*     */   public static FacesContext getFacesContext() {
/* 111 */     return FacesContext.getCurrentInstance();
/*     */   }
/*     */   public static Application getApplication() {
/* 114 */     return getFacesContext().getApplication();
/*     */   }
/*     */ 
/*     */   public static ELContext getELContext()
/*     */   {
/* 119 */     return getFacesContext().getELContext();
/*     */   }
/*     */   public static void redirect(String uri) {
/* 122 */     FacesContext fc = getFacesContext();
/* 123 */     Application app = getApplication();
/* 124 */     UIViewRoot view = app.getViewHandler()
/* 125 */       .createView(fc, uri);
/* 126 */     fc.setViewRoot(view);
/* 127 */     fc.renderResponse();
/*     */   }
/*     */ 
/*     */   public static void redirect2(String uri) {
/*     */     try {
/* 132 */       String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
/* 133 */       FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + uri);
/*     */     } catch (Exception e) {
/* 135 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getCurrentDate()
/*     */   {
/* 141 */     Date nowDate = new Date();
/* 142 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 143 */     return sdf.format(nowDate);
/*     */   }
/*     */ 
/*     */   public static String getCurrentTime()
/*     */   {
/* 148 */     Date nowTime = new Date();
/* 149 */     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
/* 150 */     return sdf.format(nowTime);
/*     */   }
/*     */ 
/*     */   public static WebVisitor getWebVisitor()
/*     */   {
/* 155 */     WebVisitor visitor = null;
/*     */     try {
/* 157 */       Application app = FacesContext.getCurrentInstance().getApplication();
/* 158 */       ELContext elc = FacesContext.getCurrentInstance().getELContext();
/* 159 */       ExpressionFactory ef = app.getExpressionFactory();
/*     */ 
/* 161 */       ValueExpression ve = ef.createValueExpression(elc, 
/* 162 */         "#{webVisitor}", 
/* 163 */         WebVisitor.class);
/*     */       try
/*     */       {
/* 167 */         visitor = (WebVisitor)ve.getValue(elc); } catch (Exception e) {
/* 168 */         e.printStackTrace();
/*     */       }
/*     */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/*     */     }
/* 172 */     return visitor;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.ECPubFun
 * JD-Core Version:    0.6.0
 */