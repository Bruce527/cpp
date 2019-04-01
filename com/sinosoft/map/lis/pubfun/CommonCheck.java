/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.CErrors;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class CommonCheck
/*    */ {
/*  9 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public boolean checknoempty(String name, Object ckobj)
/*    */   {
/* 13 */     if ((ckobj == null) || (ckobj.toString().equals("")))
/*    */     {
/* 15 */       this.mErrors.addOneError("\u53D1\u751F\u9519\u8BEF: " + name + " \u4E0D\u5141\u8BB8\u7A7A");
/* 16 */       return false;
/*    */     }
/* 18 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean checksingle(String name, Object ckobj, Vector source)
/*    */   {
/* 24 */     if (source == null)
/*    */     {
/* 26 */       return true;
/*    */     }
/* 28 */     for (int i = 0; i < source.size(); i++)
/*    */     {
/* 30 */       if (!ckobj.equals(source.elementAt(i)))
/*    */         continue;
/* 32 */       this.mErrors.addOneError("\u53D1\u751F\u9519\u8BEF: " + name + " \u5B58\u5728\u91CD\u590D\u503C");
/* 33 */       return false;
/*    */     }
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean checkmatch(String name, Object ckobj, Vector source)
/*    */   {
/* 42 */     if (source == null)
/*    */     {
/* 44 */       this.mErrors.addOneError("\u53D1\u751F\u9519\u8BEF: " + name + " \u4E0D\u5B58\u5728\u5339\u914D\u503C");
/* 45 */       return false;
/*    */     }
/* 47 */     for (int i = 0; i < source.size(); i++)
/*    */     {
/* 49 */       if (ckobj.equals(source.elementAt(i)))
/*    */       {
/* 51 */         return true;
/*    */       }
/*    */     }
/* 54 */     this.mErrors.addOneError("\u53D1\u751F\u9519\u8BEF: " + name + " \u4E0D\u5B58\u5728\u5339\u914D\u503C");
/* 55 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.CommonCheck
 * JD-Core Version:    0.6.0
 */