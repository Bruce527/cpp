/*    */ package com.sinosoft.map.common.validators;
/*    */ 
/*    */ import com.sinosoft.map.common.WebVisitor;
/*    */ import javax.el.ELContext;
/*    */ import javax.el.ExpressionFactory;
/*    */ import javax.el.ValueExpression;
/*    */ import javax.faces.application.Application;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.validator.Validator;
/*    */ import javax.faces.validator.ValidatorException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SysLoginValidator extends ValidatorConfig
/*    */   implements Validator
/*    */ {
/*    */   public void validate(FacesContext context, UIComponent arg1, Object arg2)
/*    */     throws ValidatorException
/*    */   {
/* 23 */     Application app = getApplication();
/* 24 */     ELContext elc = getELContext();
/* 25 */     ExpressionFactory ef = app.getExpressionFactory();
/*    */ 
/* 27 */     ValueExpression ve = ef.createValueExpression(elc, 
/* 28 */       "#{webVisitor}", 
/* 29 */       WebVisitor.class);
/* 30 */     WebVisitor visitor = null;
/*    */     try {
/* 32 */       visitor = (WebVisitor)ve.getValue(elc);
/*    */     } catch (Exception localException) {
/*    */     }
/* 35 */     if ((visitor != null) && (visitor.isHalfLogin()))
/*    */     {
/* 37 */       visitor.setHalfLogin(false);
/*    */     }
/* 43 */     else if ("sysloginvalidate".equals(arg1.getId()))
/* 44 */       validateCode(context, arg1, arg2);
/*    */   }
/*    */ 
/*    */   public void validateCode(FacesContext context, UIComponent arg1, Object arg2)
/*    */   {
/* 54 */     String tInputStr = (String)arg2;
/*    */ 
/* 56 */     FacesContext tFacesContext = getFacesContext();
/* 57 */     HttpServletRequest tHttpServletRequest = getHttpServletRequest();
/* 58 */     HttpSession tHttpSession = tHttpServletRequest.getSession();
/* 59 */     String tSessionCheckCode = (String)tHttpSession.getAttribute("validateCode");
/*    */ 
/* 62 */     if (!tSessionCheckCode.equalsIgnoreCase(tInputStr))
/*    */     {
/* 64 */       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, getStringByID("Error", null), getStringByID("login_validateCodeError", null));
/* 65 */       tFacesContext.addMessage(null, msg);
/* 66 */       throw new ValidatorException(msg);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.validators.SysLoginValidator
 * JD-Core Version:    0.6.0
 */