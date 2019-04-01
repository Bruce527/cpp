/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.CError;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import java.io.Serializable;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class FDate
/*    */   implements Cloneable, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   public CErrors mErrors = new CErrors();
/*    */ 
/* 24 */   private final String pattern = "yyyy-MM-dd";
/* 25 */   private final String pattern1 = "yyyyMMdd";
/*    */   private SimpleDateFormat df;
/*    */   private SimpleDateFormat df1;
/*    */ 
/*    */   public FDate()
/*    */   {
/* 31 */     this.df = new SimpleDateFormat("yyyy-MM-dd");
/* 32 */     this.df1 = new SimpleDateFormat("yyyyMMdd");
/*    */   }
/*    */ 
/*    */   public Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 39 */     FDate cloned = (FDate)super.clone();
/*    */ 
/* 41 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/* 42 */     return cloned;
/*    */   }
/*    */ 
/*    */   public Date getDate(String dateString)
/*    */   {
/* 49 */     Date tDate = null;
/*    */     try
/*    */     {
/* 52 */       if (dateString.indexOf("-") != -1)
/*    */       {
/* 54 */         tDate = this.df.parse(dateString);
/*    */       }
/*    */       else
/*    */       {
/* 58 */         tDate = this.df1.parse(dateString);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 64 */       CError tError = new CError();
/* 65 */       tError.moduleName = "FDate";
/* 66 */       tError.functionName = "getDate";
/* 67 */       tError.errorMessage = e.toString();
/* 68 */       this.mErrors.addOneError(tError);
/*    */     }
/*    */ 
/* 71 */     return tDate;
/*    */   }
/*    */ 
/*    */   public String getString(Date mDate)
/*    */   {
/* 77 */     String tString = null;
/* 78 */     if (mDate != null)
/*    */     {
/* 80 */       tString = this.df.format(mDate);
/*    */     }
/* 82 */     return tString;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.FDate
 * JD-Core Version:    0.6.0
 */