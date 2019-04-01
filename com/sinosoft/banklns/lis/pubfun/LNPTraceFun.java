/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPAgentTraceSchema;
/*    */ import com.sinosoft.banklns.lis.schema.LNPOperatorTraceSchema;
/*    */ import com.sinosoft.banklns.utility.VData;
/*    */ import com.sinosoft.map.lis.pubfun.PubFun;
/*    */ 
/*    */ public class LNPTraceFun
/*    */ {
/*    */   public static void doLNPAgentTrace(String contno, String operator, String operatorType)
/*    */   {
/* 12 */     MMap map = new MMap();
/* 13 */     VData vd = new VData();
/* 14 */     PubSubmit ps = new PubSubmit();
/* 15 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 16 */     String date = PubFun.getCurrentDate();
/* 17 */     String time = PubFun.getCurrentTime();
/* 18 */     LNPAgentTraceSchema aSchema = new LNPAgentTraceSchema();
/* 19 */     aSchema.setID(maxNoMap.CreateMaxNo("AgentTraceNo", ""));
/* 20 */     aSchema.setOperatorDate(date);
/* 21 */     aSchema.setOperatorTime(time);
/* 22 */     aSchema.setContno(contno);
/* 23 */     aSchema.setOperator(operator);
/* 24 */     aSchema.setOperatorType(operatorType);
/*    */ 
/* 26 */     map.put(aSchema, "INSERT");
/* 27 */     vd.add(map);
/* 28 */     ps.submitData(vd, "INSERT");
/*    */   }
/*    */ 
/*    */   public static void doLNPOperatorTrace(String contno, String operator, String operatorType)
/*    */   {
/* 34 */     MMap map = new MMap();
/* 35 */     VData vd = new VData();
/* 36 */     PubSubmit ps = new PubSubmit();
/* 37 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 38 */     String date = PubFun.getCurrentDate();
/* 39 */     String time = PubFun.getCurrentTime();
/* 40 */     LNPOperatorTraceSchema oSchema = new LNPOperatorTraceSchema();
/* 41 */     oSchema.setID(maxNoMap.CreateMaxNo("OperTraceNo", ""));
/* 42 */     oSchema.setOperatorDate(date);
/* 43 */     oSchema.setOperatorTime(time);
/* 44 */     oSchema.setContno(contno);
/* 45 */     oSchema.setOperator(operator);
/* 46 */     oSchema.setOperatorType(operatorType);
/*    */ 
/* 48 */     map.put(oSchema, "INSERT");
/* 49 */     vd.add(map);
/* 50 */     ps.submitData(vd, "INSERT");
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.LNPTraceFun
 * JD-Core Version:    0.6.0
 */