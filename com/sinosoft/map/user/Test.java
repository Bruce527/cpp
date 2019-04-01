/*    */ package com.sinosoft.map.user;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Test extends Thread
/*    */ {
/*    */   String[][] domain;
/*    */   int[] speed;
/* 17 */   int i = 1;
/*    */   Thread[] thread;
/* 51 */   List<String> test = new ArrayList();
/*    */ 
/*    */   public void run()
/*    */   {
/* 21 */     getDomain(this.i);
/*    */   }
/*    */   public void getDomain(int i) {
/* 24 */     String addrs = this.domain[(i - 1)][1];
/* 25 */     if ((addrs == null) || (addrs == "")) {
/* 26 */       System.out.println("syntax Error!");
/*    */     } else {
/* 28 */       String line = null;
/*    */       try {
/* 30 */         Process pro = Runtime.getRuntime().exec("ping " + addrs + " -l 1000 -n 4");
/* 31 */         BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
/* 32 */         while ((line = buf.readLine()) != null)
/*    */         {
/* 34 */           int position = 0;
/* 35 */           if ((position = line.indexOf("Average")) >= 0) {
/* 36 */             int time = line.lastIndexOf("ms");
/* 37 */             String value = line.substring(position + 10, line.lastIndexOf("ms"));
/* 38 */             int tspeed = 1000 / Integer.parseInt(value);
/* 39 */             this.speed[(i - 1)] = tspeed;
/*    */           }
/*    */ 
/*    */         }
/*    */ 
/*    */       }
/*    */       catch (Exception ex)
/*    */       {
/* 47 */         System.out.println(ex.getMessage());
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void query() {
/* 53 */     String strSQL = "select sysvartype,sysvarvalue from ldsysvar where sysvar='domainname' order by sysvartype";
/* 54 */     ExeSQL exeSQL = new ExeSQL();
/* 55 */     SSRS ssrs = exeSQL.execSQL(strSQL);
/* 56 */     if (ssrs.getMaxRow() > 0)
/* 57 */       for (int i = 1; i <= ssrs.MaxRow; i++)
/* 58 */         for (int j = 1; j <= ssrs.MaxCol; j++)
/* 59 */           this.domain[(i - 1)][(j - 1)] = ssrs.GetText(i, j);
/*    */   }
/*    */ 
/*    */   public void getThread()
/*    */   {
/* 66 */     for (int i = 0; i < this.domain.length; i++) {
/* 67 */       this.thread[i] = new Thread();
/* 68 */       this.thread[i].start();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.Test
 * JD-Core Version:    0.6.0
 */