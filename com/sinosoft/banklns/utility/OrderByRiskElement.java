/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPRiskScreenDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
/*    */ import com.sinosoft.banklns.lis.vdb.LNPRiskScreenDBSet;
/*    */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
/*    */ 
/*    */ public class OrderByRiskElement
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 14 */     String fssql = "select * from lNPriskscreen group by riskcode";
/* 15 */     LNPRiskScreenDB redLNPRiskScreenDB = new LNPRiskScreenDB();
/* 16 */     LNPRiskScreenSet tereLNPRiskAppSet = redLNPRiskScreenDB.executeQuery(fssql);
/*    */ 
/* 18 */     if ((tereLNPRiskAppSet != null) && (tereLNPRiskAppSet.size() > 0))
/* 19 */       for (int i = 1; i <= tereLNPRiskAppSet.size(); i++) {
/* 20 */         LNPRiskScreenDB reLNPRiskScreenDB = new LNPRiskScreenDB();
/* 21 */         reLNPRiskScreenDB.setRiskCode(tereLNPRiskAppSet.get(i).getRiskCode());
/* 22 */         LNPRiskScreenSet reLNPRiskScreenSet = reLNPRiskScreenDB.query();
/* 23 */         if ((reLNPRiskScreenSet != null) && (reLNPRiskScreenSet.size() > 0)) {
/* 24 */           LNPRiskScreenSet tempreLNPRiskScreenSet = new LNPRiskScreenSet();
/* 25 */           for (int j = 1; j <= reLNPRiskScreenSet.size(); j++) {
/* 26 */             LNPRiskScreenSchema tLNPRiskScreenSchema = reLNPRiskScreenSet.get(j);
/* 27 */             if (tLNPRiskScreenSchema.getCtrlCode().equals("Mult"))
/* 28 */               tLNPRiskScreenSchema.setCtrlIndex(1);
/* 29 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("DutyCode"))
/* 30 */               tLNPRiskScreenSchema.setCtrlIndex(2);
/* 31 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("Amnt"))
/* 32 */               tLNPRiskScreenSchema.setCtrlIndex(3);
/* 33 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("Prem"))
/* 34 */               tLNPRiskScreenSchema.setCtrlIndex(4);
/* 35 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("PayIntv"))
/* 36 */               tLNPRiskScreenSchema.setCtrlIndex(5);
/* 37 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("InsuYearFlag"))
/* 38 */               tLNPRiskScreenSchema.setCtrlIndex(6);
/* 39 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("InsuYear"))
/* 40 */               tLNPRiskScreenSchema.setCtrlIndex(7);
/* 41 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("PayEndYearFlag"))
/* 42 */               tLNPRiskScreenSchema.setCtrlIndex(8);
/* 43 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("PayEndYear"))
/* 44 */               tLNPRiskScreenSchema.setCtrlIndex(9);
/* 45 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("GetYearFlag"))
/* 46 */               tLNPRiskScreenSchema.setCtrlIndex(10);
/* 47 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("GetYear"))
/* 48 */               tLNPRiskScreenSchema.setCtrlIndex(11);
/* 49 */             else if (tLNPRiskScreenSchema.getCtrlCode().equals("BonusGetMode")) {
/* 50 */               tLNPRiskScreenSchema.setCtrlIndex(12);
/*    */             }
/* 52 */             tempreLNPRiskScreenSet.add(tLNPRiskScreenSchema);
/*    */           }
/* 54 */           String sql = "delete from lNPriskScreen where riskcode='" + tereLNPRiskAppSet.get(i).getRiskCode() + "'";
/* 55 */           ExeSQL reExeSQL = new ExeSQL();
/* 56 */           reExeSQL.execUpdateSQL(sql);
/* 57 */           LNPRiskScreenDBSet reLMRiskScreenDBSet = new LNPRiskScreenDBSet();
/* 58 */           reLMRiskScreenDBSet.set(tempreLNPRiskScreenSet);
/* 59 */           reLMRiskScreenDBSet.insert();
/*    */         }
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.OrderByRiskElement
 * JD-Core Version:    0.6.0
 */