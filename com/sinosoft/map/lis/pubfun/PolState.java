/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.CError;
/*    */ import com.sinosoft.map.utility.CErrors;
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class PolState
/*    */ {
/* 13 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public boolean SetPolEnd()
/*    */   {
/* 24 */     String sql = "UPDATE lcpol SET polstate = '0303' || SUBSTR (polstate, 0, 4) WHERE polno IN ( SELECT polno FROM lcpol WHERE grppolno = '00000000000000000000'  AND SUBSTR (polstate, 0, 2) NOT IN ('03', '04')  AND (   (    EXISTS (SELECT riskcode FROM lmriskrnew                         WHERE riskcode = lcpol.riskcode)           AND to_date('" + 
/* 31 */       PubFun.getCurrentDate() + "','yyyy-mm-dd') > enddate + DECODE (rnewflag, '-1', 67, 0))" + 
/* 32 */       "        OR (    NOT EXISTS (SELECT riskcode FROM lmriskrnew" + 
/* 33 */       "                             WHERE riskcode = lcpol.riskcode)" + 
/* 34 */       "            AND to_date('" + PubFun.getCurrentDate() + "','yyyy-mm-dd') > enddate)" + 
/* 35 */       "        OR (    polstate LIKE '02%'" + 
/* 36 */       "            AND to_date('" + PubFun.getCurrentDate() + "','yyyy-mm-dd') > ADD_MONTHS (PayToDate, 24))" + 
/* 37 */       "       ))";
/* 38 */     System.out.println(sql);
/*    */ 
/* 40 */     ExeSQL tExeSQL = new ExeSQL();
/*    */ 
/* 42 */     if (!tExeSQL.execUpdateSQL(sql))
/*    */     {
/* 44 */       CError.buildErr(this, tExeSQL.mErrors.getFirstError(), this.mErrors);
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */ 
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.PolState
 * JD-Core Version:    0.6.0
 */