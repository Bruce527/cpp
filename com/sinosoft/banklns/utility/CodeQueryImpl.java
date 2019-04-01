/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*    */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class CodeQueryImpl
/*    */   implements CodeQueryIntf
/*    */ {
/*    */   public List getInfoByCodeType(String type)
/*    */   {
/* 13 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 14 */     if ((type == null) || (type.length() == 0)) {
/* 15 */       return null;
/*    */     }
/* 17 */     reLNPCodeDB.setCodeType(type);
/* 18 */     LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
/* 19 */     List list = new ArrayList();
/* 20 */     for (int i = 1; (reLNPCodeSet != null) && (i <= reLNPCodeSet.size()); i++) {
/* 21 */       LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
/* 22 */       list.add(tempLNPCodeSchema);
/*    */     }
/* 24 */     return list;
/*    */   }
/*    */ 
/*    */   public List getInfoByConditions(LNPCodeSchema tempLNPCodeSchema)
/*    */   {
/* 29 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 30 */     reLNPCodeDB.setSchema(tempLNPCodeSchema);
/* 31 */     LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
/* 32 */     List list = new ArrayList();
/* 33 */     for (int i = 1; (reLNPCodeSet != null) && (i <= reLNPCodeSet.size()); i++) {
/* 34 */       LNPCodeSchema quLNPCodeSchema = reLNPCodeSet.get(i);
/* 35 */       list.add(quLNPCodeSchema);
/*    */     }
/* 37 */     return list;
/*    */   }
/*    */ 
/*    */   public List getInfoBySql(String sql) throws Exception {
/* 41 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 42 */     if ((sql == null) || (sql.length() == 0)) {
/* 43 */       return null;
/*    */     }
/* 45 */     LNPCodeSet reLNPCodeSet = null;
/*    */     try {
/* 47 */       reLNPCodeSet = reLNPCodeDB.executeQuery(sql);
/*    */     } catch (Exception e) {
/* 49 */       e.printStackTrace();
/* 50 */       throw new Exception("\u951F\u65A4\u62F7\u8BE2\u5931\u951F\u65A4\u62F7.SQL\u4E3A\u951F\u65A4\u62F7" + sql);
/*    */     }
/*    */ 
/* 53 */     List list = new ArrayList();
/* 54 */     for (int i = 1; (reLNPCodeSet != null) && (i <= reLNPCodeSet.size()); i++) {
/* 55 */       LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
/* 56 */       list.add(tempLNPCodeSchema);
/*    */     }
/* 58 */     return list;
/*    */   }
/*    */ 
/*    */   public LNPCodeSchema getinfoById(String code, String type)
/*    */   {
/* 63 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 64 */     reLNPCodeDB.setCode(code);
/* 65 */     reLNPCodeDB.setCodeType(type);
/* 66 */     if (reLNPCodeDB.getInfo()) {
/* 67 */       return reLNPCodeDB;
/*    */     }
/* 69 */     return null;
/*    */   }
/*    */ 
/*    */   public String getTextByCodeAndType(String type, String code)
/*    */   {
/* 74 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 75 */     reLNPCodeDB.setCode(code);
/* 76 */     reLNPCodeDB.setCodeType(type);
/* 77 */     if (reLNPCodeDB.getInfo()) {
/* 78 */       return reLNPCodeDB.getCodeName();
/*    */     }
/* 80 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CodeQueryImpl
 * JD-Core Version:    0.6.0
 */