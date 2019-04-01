/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*    */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*    */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*    */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*    */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*    */ 
/*    */ public class PersonFunction
/*    */ {
/*    */   public LNPPersonSchema getLnpPersonByCustomerId(String customerid)
/*    */   {
/* 14 */     LNPPersonSchema aLNPPersonSchema = new LNPPersonSchema();
/*    */     try {
/* 16 */       LNPPersonDB lnpPersonDB = new LNPPersonDB();
/* 17 */       aLNPPersonSchema = new LNPPersonSchema();
/* 18 */       lnpPersonDB.setCustomerId(customerid);
/*    */ 
/* 20 */       LNPPersonSet personSet = lnpPersonDB.query();
/*    */ 
/* 22 */       if (personSet.size() > 0)
/*    */       {
/* 24 */         aLNPPersonSchema = personSet.get(1);
/*    */       }
/* 26 */       else aLNPPersonSchema = null;
/*    */     }
/*    */     catch (RuntimeException e)
/*    */     {
/* 30 */       e.printStackTrace();
/* 31 */       aLNPPersonSchema = null;
/*    */     }
/* 33 */     return aLNPPersonSchema;
/*    */   }
/*    */ 
/*    */   public LNPAddressSchema getLnpAddrByCustomerId(String customerid)
/*    */   {
/* 38 */     LNPAddressDB lnpAddressDB = new LNPAddressDB();
/* 39 */     LNPAddressSchema aLNPAddressSchema = new LNPAddressSchema();
/* 40 */     lnpAddressDB.setCustomerId(customerid);
/*    */ 
/* 42 */     LNPAddressSet addressSet = lnpAddressDB.query();
/*    */ 
/* 44 */     if (addressSet.size() > 0)
/* 45 */       aLNPAddressSchema = addressSet.get(1);
/*    */     else {
/* 47 */       aLNPAddressSchema = null;
/*    */     }
/*    */ 
/* 50 */     return aLNPAddressSchema;
/*    */   }
/*    */ 
/*    */   public LNPPersonSchema getCustomerExist(String name, String sex, String birthday, String idtype, String idno)
/*    */   {
/* 57 */     LNPPersonSchema rePersonSch = new LNPPersonSchema();
/*    */     try
/*    */     {
/* 60 */       LNPPersonDB db = new LNPPersonDB();
/* 61 */       db.setName(name);
/* 62 */       db.setSex(sex);
/* 63 */       db.setBirthday(birthday);
/* 64 */       db.setIDType(idtype);
/* 65 */       db.setIDNo(idno);
/*    */ 
/* 67 */       LNPPersonSet set = db.query();
/* 68 */       if (set.size() > 0)
/* 69 */         rePersonSch = set.get(1);
/*    */       else
/* 71 */         rePersonSch = null;
/*    */     }
/*    */     catch (RuntimeException e)
/*    */     {
/* 75 */       e.printStackTrace();
/* 76 */       rePersonSch = null;
/*    */     }
/*    */ 
/* 79 */     return rePersonSch;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.PersonFunction
 * JD-Core Version:    0.6.0
 */