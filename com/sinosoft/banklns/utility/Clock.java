/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.awt.Canvas;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ class Clock extends Canvas
/*    */   implements Runnable
/*    */ {
/*    */   TestClock mf;
/*    */   Thread t;
/*    */   String time;
/*    */ 
/*    */   Clock(TestClock mf)
/*    */   {
/* 16 */     this.mf = mf;
/* 17 */     setSize(400, 40);
/* 18 */     setBackground(Color.white);
/* 19 */     this.t = new Thread(this);
/* 20 */     this.t.start();
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/*    */     while (true)
/*    */     {
/*    */       try {
/* 28 */         Thread.sleep(1000L);
/*    */       }
/*    */       catch (InterruptedException e)
/*    */       {
/* 32 */         System.out.println("\u951F\u5C4A\u5E38");
/*    */       }
/* 34 */       repaint(100L);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 39 */     Font f = new Font("\u951F\u65A4\u62F7\u951F\u65A4\u62F7", 1, 16);
/* 40 */     SimpleDateFormat SDF = new SimpleDateFormat("yyyy'\u951F\u65A4\u62F7'MM'\u951F\u65A4\u62F7'dd'\u951F\u65A4\u62F7'HH:mm:ss");
/* 41 */     Calendar now = Calendar.getInstance();
/* 42 */     this.time = SDF.format(now.getTime());
/* 43 */     g.setFont(f);
/* 44 */     g.setColor(Color.orange);
/* 45 */     g.drawString(this.time, 100, 25);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.Clock
 * JD-Core Version:    0.6.0
 */