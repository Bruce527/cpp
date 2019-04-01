/*    */ package com.sinosoft.map.common;
/*    */ 
/*    */ import com.sinosoft.map.common.config.BaseConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import javax.faces.application.Application;
/*    */ import javax.faces.component.UIViewRoot;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.model.SelectItem;
/*    */ 
/*    */ public class LocaleBean extends BaseConfig
/*    */ {
/*    */   private String locale;
/*    */   private List<SelectItem> localeList;
/*    */ 
/*    */   public LocaleBean()
/*    */   {
/* 20 */     this.locale = getFacesContext().getViewRoot().getLocale().toString();
/*    */   }
/*    */ 
/*    */   public void setLocale(String locale)
/*    */   {
/* 25 */     this.locale = locale;
/*    */   }
/*    */ 
/*    */   public String getLocale()
/*    */   {
/* 30 */     return this.locale;
/*    */   }
/*    */ 
/*    */   public List getLocaleList()
/*    */   {
/* 35 */     this.localeList = new ArrayList();
/* 36 */     Application app = getApplication();
/* 37 */     Iterator locales = app.getSupportedLocales();
/* 38 */     while (locales.hasNext()) {
/* 39 */       Locale theLocale = (Locale)locales.next();
/* 40 */       this.localeList.add(new SelectItem(theLocale.toString(), getStringByID("language_" + theLocale.toString(), null)));
/*    */     }
/* 42 */     if (this.localeList.size() == 0) {
/* 43 */       Locale defaultLocale = app.getDefaultLocale();
/* 44 */       this.localeList.add(new SelectItem(defaultLocale.toString(), defaultLocale.getDisplayName()));
/*    */     }
/* 46 */     return this.localeList;
/*    */   }
/*    */ 
/*    */   public String selectLocale()
/*    */   {
/* 51 */     getFacesContext().getViewRoot().setLocale(new Locale(this.locale));
/* 52 */     return "success";
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.LocaleBean
 * JD-Core Version:    0.6.0
 */