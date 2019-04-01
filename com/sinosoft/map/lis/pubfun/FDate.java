/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.CError;
/*    */ import com.sinosoft.map.utility.CErrors;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class FDate
/*    */   implements Cloneable
/*    */ {
/* 18 */   public CErrors mErrors = new CErrors();
/*    */ 
/* 20 */   private final String pattern = "yyyy-MM-dd";
/* 21 */   private final String pattern1 = "yyyyMMdd";
/*    */   private SimpleDateFormat df;
/*    */   private SimpleDateFormat df1;
/*    */ 
/*    */   public FDate()
/*    */   {
/* 27 */     this.df = new SimpleDateFormat("yyyy-MM-dd");
/* 28 */     this.df1 = new SimpleDateFormat("yyyyMMdd");
/*    */   }
/*    */ 
/*    */   public Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 35 */     FDate cloned = (FDate)super.clone();
/*    */ 
/* 37 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/* 38 */     return cloned;
/*    */   }
/*    */ 
/*    */   public Date getDate(String dateString)
/*    */   {
/* 45 */     Date tDate = null;
/*    */     try
/*    */     {
/* 48 */       if (dateString.indexOf("-") != -1)
/*    */       {
/* 50 */         tDate = this.df.parse(dateString);
/*    */       }
/*    */       else
/*    */       {
/* 54 */         tDate = this.df1.parse(dateString);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 60 */       CError tError = new CError();
/* 61 */       tError.moduleName = "FDate";
/* 62 */       tError.functionName = "getDate";
/* 63 */       tError.errorMessage = e.toString();
/* 64 */       this.mErrors.addOneError(tError);
/*    */     }
/*    */ 
/* 67 */     return tDate;
/*    */   }
/*    */ 
/*    */   public String getString(Date mDate)
/*    */   {
/* 73 */     String tString = null;
/* 74 */     if (mDate != null)
/*    */     {
/* 76 */       tString = this.df.format(mDate);
/*    */     }
/* 78 */     return tString;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.FDate
 * JD-Core Version:    0.6.0
 */