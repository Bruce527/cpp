/*    */ package com.sinosoft.map.common.converter;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ 
/*    */ public class NumberToStringConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
/*    */   {
/* 11 */     System.out.println("arg2=" + arg2);
/* 12 */     return arg2;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
/*    */   {
/* 17 */     System.out.println("arg1.getId()=" + arg1.getId());
/*    */ 
/* 19 */     System.out.println("arg2.toString()=" + arg2.toString());
/* 20 */     String str = arg2.toString();
/*    */ 
/* 22 */     if ((str != null) && (str.indexOf(".") > -1)) {
/* 23 */       System.out.println("AAAAAAAAAAAAAaaa=" + str.substring(0, str.indexOf(".")));
/* 24 */       if (("0".equals(str.substring(str.indexOf(".")))) || ("00".equals(str.substring(str.indexOf("."))))) {
/* 25 */         return str.substring(0, str.indexOf("."));
/*    */       }
/*    */     }
/* 28 */     return arg2.toString();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.converter.NumberToStringConverter
 * JD-Core Version:    0.6.0
 */