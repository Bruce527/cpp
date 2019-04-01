/*    */ package com.sinosoft.map.common.converter;
/*    */ 
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ 
/*    */ public class DateToStringConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
/*    */   {
/* 11 */     return arg2;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
/* 15 */     return arg2.toString();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.converter.DateToStringConverter
 * JD-Core Version:    0.6.0
 */