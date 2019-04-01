/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ public class DBPack
/*    */ {
/* 10 */   private DBOper db = null;
/*    */ 
/* 13 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public DBPack()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DBPack(String aSchName)
/*    */   {
/* 21 */     this.db = new DBOper(aSchName);
/*    */   }
/*    */ 
/*    */   public boolean update(Schema s)
/*    */   {
/* 26 */     if (!this.db.update(s))
/*    */     {
/* 28 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 29 */       return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 36 */     DBPack DBPack1 = new DBPack();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBPack
 * JD-Core Version:    0.6.0
 */