/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ public class DBPack
/*    */ {
/*  9 */   private DBOper db = null;
/*    */ 
/* 12 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public DBPack()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DBPack(String aSchName)
/*    */   {
/* 20 */     this.db = new DBOper(aSchName);
/*    */   }
/*    */ 
/*    */   public boolean update(Schema s)
/*    */   {
/* 25 */     if (!this.db.update(s))
/*    */     {
/* 27 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 28 */       return false;
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 35 */     DBPack DBPack1 = new DBPack();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DBPack
 * JD-Core Version:    0.6.0
 */