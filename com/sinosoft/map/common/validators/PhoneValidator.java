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
/*    */ public class PhoneValidator extends ValidatorConfig
/*    */   implements Validator
/*    */ {
/*    */   public void validate(FacesContext context, UIComponent component, Object pvalue)
/*    */     throws ValidatorException
/*    */   {
/* 19 */     String value = (String)pvalue;
/*    */ 
/* 21 */     String num = "^[0-9]*";
/* 22 */     String ex = "(|-|,|/)?[0-9]*$";
/*    */ 
/* 24 */     Pattern mask = Pattern.compile(num + ex);
/*    */ 
/* 26 */     Matcher matcher = mask.matcher(value);
/*    */ 
/* 28 */     if (!matcher.find()) {
/* 29 */       FacesMessage message = new FacesMessage();
/* 30 */       message.setSummary(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_PhoneInvalid", null));
/* 31 */       message.setDetail(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_PhoneInvalid", null));
/* 32 */       message.setSeverity(FacesMessage.SEVERITY_ERROR);
/* 33 */       throw new ValidatorException(message);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.validators.PhoneValidator
 * JD-Core Version:    0.6.0
 */