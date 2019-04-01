/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.utility.DateConvert;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.component.UIComponent;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.validator.Validator;
/*     */ import javax.faces.validator.ValidatorException;
/*     */ 
/*     */ public class LNPValidator
/*     */   implements Validator
/*     */ {
/*     */   public void validate(FacesContext context, UIComponent component, Object obj)
/*     */     throws ValidatorException
/*     */   {
/*  23 */     String password = (String)obj;
/*  24 */     System.out.println("password=" + password);
/*     */ 
/*  26 */     if (!ValidateTools.isValidString1(password)) {
/*  27 */       System.out.println("\u8BE5\u503C\u8F93\u5165\u9519\u8BEF\uFF0C\u53EF\u4EE5\u5305\u542B\u4E2D\u82F1\u6587\uFF0C\u6570\u5B57\u53CA\u201C-\u201D\u201C_\u201D\u201C#\u201D\u7B49\u5B57\u7B26");
/*  28 */       FacesMessage message = new FacesMessage(
/*  29 */         FacesMessage.SEVERITY_ERROR, 
/*  30 */         "\u8BE5\u503C\u8F93\u5165\u9519\u8BEF\uFF0C\u53EF\u4EE5\u5305\u542B\u4E2D\u82F1\u6587\uFF0C\u6570\u5B57\u53CA\u201C-\u201D\u201C_\u201D\u201C#\u201D\u7B49\u5B57\u7B26", 
/*  31 */         "\u8BE5\u503C\u8F93\u5165\u9519\u8BEF\uFF0C\u53EF\u4EE5\u5305\u542B\u4E2D\u82F1\u6587\uFF0C\u6570\u5B57\u53CA\u201C-\u201D\u201C_\u201D\u201C#\u201D\u7B49\u5B57\u7B26");
/*  32 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validateNumber(FacesContext context, UIComponent component, Object obj)
/*     */     throws ValidatorException
/*     */   {
/*  42 */     int age = ((Integer)obj).intValue();
/*  43 */     if (age < 18) {
/*  44 */       System.out.println("\u5BA2\u6237\u5E74\u9F84\u5C0F\u4E8E18");
/*  45 */       FacesMessage message = new FacesMessage(
/*  46 */         FacesMessage.SEVERITY_ERROR, "\u5BA2\u6237\u5E74\u9F84\u5C0F\u4E8E18", "\u5BA2\u6237\u5E74\u9F84\u4E0D\u5F97\u5C0F\u4E8E18");
/*  47 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validateDate(FacesContext context, UIComponent component, Object obj) throws ValidatorException
/*     */   {
/*  53 */     Date date = (Date)obj;
/*  54 */     String tempDate = DateConvert.dateToStr(date);
/*  55 */     if ((!"".equals(tempDate)) && 
/*  56 */       (!ValidateTools.isValidDate(tempDate))) {
/*  57 */       System.out.println("\u8F93\u5165\u7684\u6709\u6548\u65E5\u671F\u5927\u4E8E\u5F53\u524D\u7684\u65F6\u95F4");
/*  58 */       FacesMessage message = new FacesMessage(
/*  59 */         FacesMessage.SEVERITY_ERROR, "\u8F93\u5165\u7684\u6709\u6548\u65E5\u671F\u5927\u4E8E\u5F53\u524D\u7684\u65F6\u95F4", 
/*  60 */         "\u8F93\u5165\u7684\u6709\u6548\u65E5\u671F\u5927\u4E8E\u5F53\u524D\u7684\u65F6\u95F4");
/*  61 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isValidString1(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
/*  66 */     String temp = (String)obj;
/*  67 */     if ((!"".equals(temp)) && 
/*  68 */       (!ValidateTools.isValidString1(temp))) {
/*  69 */       System.out.println("\u5B57\u7B26\u4E32\u7531\u82F1\u6587\uFF0C\u4E2D\u6587\u548C\u6570\u5B57\u53CA-_#.\u7EC4\u6210");
/*  70 */       FacesMessage message = new FacesMessage(
/*  71 */         FacesMessage.SEVERITY_ERROR, "\u5B57\u7B26\u4E32\u7531\u82F1\u6587\uFF0C\u4E2D\u6587\u548C\u6570\u5B57\u53CA-_#.\u7EC4\u6210", 
/*  72 */         "\u5B57\u7B26\u4E32\u7531\u82F1\u6587\uFF0C\u4E2D\u6587\u548C\u6570\u5B57\u53CA-_#.\u7EC4\u6210");
/*  73 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isValidString2(FacesContext context, UIComponent component, Object obj) throws ValidatorException
/*     */   {
/*  79 */     String temp = (String)obj;
/*  80 */     if ((!"".equals(temp)) && 
/*  81 */       (!ValidateTools.isValidString2(temp))) {
/*  82 */       System.out.println("\u5B57\u7B26\u4E32\u7531\u82F1\u6587\u548C\u6570\u5B57\u7EC4\u6210");
/*  83 */       FacesMessage message = new FacesMessage(
/*  84 */         FacesMessage.SEVERITY_ERROR, "\u5B57\u7B26\u4E32\u7531\u82F1\u6587\u548C\u6570\u5B57\u7EC4\u6210", 
/*  85 */         "\u5B57\u7B26\u4E32\u7531\u82F1\u6587\u548C\u6570\u5B57\u7EC4\u6210");
/*  86 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isValidEMail(FacesContext context, UIComponent component, Object obj)
/*     */     throws ValidatorException
/*     */   {
/*  94 */     String temp = (String)obj;
/*  95 */     if ((!"".equals(temp)) && 
/*  96 */       (!ValidateTools.isValidEMail(temp))) {
/*  97 */       System.out.println("E-mail\u5730\u5740\u9519\u8BEF\uFF0C\u6B63\u786E\u5982***@***.***");
/*  98 */       FacesMessage message = new FacesMessage(
/*  99 */         FacesMessage.SEVERITY_ERROR, "E-mail\u5730\u5740\u9519\u8BEF\uFF0C\u6B63\u786E\u5982***@***.***", 
/* 100 */         "E-mail\u5730\u5740\u9519\u8BEF\uFF0C\u6B63\u786E\u5982***@***.***");
/* 101 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isNumeric(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
/* 106 */     String temp = (String)obj;
/* 107 */     if (!isValidTelCode2(temp)) {
/* 108 */       System.out.println("\u7535\u8BDD\u53F7\u7801\u957F\u5EA6\u4E3A7-18\u4F4D\u6570\u5B57");
/* 109 */       FacesMessage message = new FacesMessage(
/* 110 */         FacesMessage.SEVERITY_ERROR, "\u7535\u8BDD\u53F7\u7801\u957F\u5EA6\u4E3A7-18\u4F4D\u6570\u5B57", 
/* 111 */         "\u7535\u8BDD\u53F7\u7801\u957F\u5EA6\u4E3A7-18\u4F4D\u6570\u5B57");
/* 112 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isNumeric2(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
/* 117 */     double temp = ((Double)obj).doubleValue();
/* 118 */     if (!ValidateTools.isNumeric(String.valueOf(temp))) {
/* 119 */       System.out.println("\u5BA2\u6237\u5E74\u6536\u5165\u5F55\u5165\u9519\u8BEF,\u53EA\u80FD\u4E3A\u6570\u5B57");
/* 120 */       FacesMessage message = new FacesMessage(
/* 121 */         FacesMessage.SEVERITY_ERROR, "\u5BA2\u6237\u5E74\u6536\u5165\u5F55\u5165\u9519\u8BEF,\u53EA\u80FD\u4E3A\u6570\u5B57", 
/* 122 */         "\u5BA2\u6237\u5E74\u6536\u5165\u5F55\u5165\u9519\u8BEF,\u53EA\u80FD\u4E3A\u6570\u5B57");
/* 123 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isValidZipCode(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
/* 128 */     String temp = (String)obj;
/* 129 */     if (!ValidateTools.isValidZipCode(temp)) {
/* 130 */       System.out.println("\u90AE\u7F16\u8F93\u5165\u5E94\u8BE5\u4E3A6\u4F4D\u6570\u5B57");
/* 131 */       FacesMessage message = new FacesMessage(
/* 132 */         FacesMessage.SEVERITY_ERROR, "\u90AE\u7F16\u8F93\u5165\u5E94\u8BE5\u4E3A6\u4F4D\u6570\u5B57", 
/* 133 */         "\u90AE\u7F16\u8F93\u5165\u5E94\u8BE5\u4E3A6\u4F4D\u6570\u5B57");
/* 134 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void isValidTelCode(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
/* 139 */     String temp = (String)obj;
/* 140 */     if (!isValidTelCode1(temp)) {
/* 141 */       System.out.println("\u79FB\u52A8\u7535\u8BDD\u5E94\u8BE5\u4E3A11\u4F4D\u6570\u5B57");
/* 142 */       FacesMessage message = new FacesMessage(
/* 143 */         FacesMessage.SEVERITY_ERROR, "\u79FB\u52A8\u7535\u8BDD\u5E94\u8BE5\u4E3A11\u4F4D\u6570\u5B57", 
/* 144 */         "\u79FB\u52A8\u7535\u8BDD\u5E94\u8BE5\u4E3A11\u4F4D\u6570\u5B57");
/* 145 */       throw new ValidatorException(message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean isValidTelCode1(String aValue) {
/* 150 */     if (aValue == null)
/* 151 */       return false;
/* 152 */     if (!"".equals(aValue)) {
/* 153 */       Pattern pattern = Pattern.compile("[1-9]\\d{10}");
/* 154 */       Matcher isZipCode = pattern.matcher(aValue);
/*     */ 
/* 156 */       return isZipCode.matches();
/*     */     }
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isValidTelCode2(String aValue) {
/* 165 */     if (aValue == null)
/* 166 */       return false;
/* 167 */     if (!"".equals(aValue)) {
/* 168 */       Pattern pattern = Pattern.compile("[1-9]\\d{6,19}");
/* 169 */       Matcher isZipCode = pattern.matcher(aValue);
/*     */ 
/* 171 */       return isZipCode.matches();
/*     */     }
/*     */ 
/* 176 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.LNPValidator
 * JD-Core Version:    0.6.0
 */