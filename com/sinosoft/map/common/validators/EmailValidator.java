/*    */ package com.sinosoft.map.common.validators;
/*    */ 
/*    */ import com.sinosoft.map.ec.utility.ECPubFun;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.validator.Validator;
/*    */ import javax.faces.validator.ValidatorException;
/*    */ 
/*    */ public class EmailValidator extends ValidatorConfig
/*    */   implements Validator
/*    */ {
/*    */   public void validate(FacesContext context, UIComponent component, Object pvalue)
/*    */     throws ValidatorException
/*    */   {
/* 22 */     String value = (String)pvalue;
/*    */ 
/* 24 */     String emailPattern = "^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9-]+[\\.a-zA-Z]+$";
/*    */ 
/* 26 */     Pattern mask = Pattern.compile(emailPattern);
/*    */ 
/* 28 */     Matcher matcher = mask.matcher(value);
/*    */ 
/* 30 */     if (!matcher.find()) {
/* 31 */       FacesMessage message = new FacesMessage();
/* 32 */       message.setSummary(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_EmailInvalid", null));
/* 33 */       message.setDetail(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_EmailInvalid", null));
/* 34 */       message.setSeverity(FacesMessage.SEVERITY_ERROR);
/* 35 */       throw new ValidatorException(message);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.validators.EmailValidator
 * JD-Core Version:    0.6.0
 */