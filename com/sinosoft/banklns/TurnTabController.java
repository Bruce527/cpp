/*    */ package com.sinosoft.banklns;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ import com.sinosoft.banklns.utility.SSRS;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class TurnTabController
/*    */ {
/*    */   private String _FToO;
/*    */   private String _fromView;
/*    */   private String _outCome;
/*    */   private String _suc_target;
/*    */   private String _err_target;
/*    */   private String _lastID;
/*    */ 
/*    */   public String turnTabAction()
/*    */   {
/* 20 */     System.out.println("------------>|request_suc:" + this._suc_target + " | failed:" + this._err_target + " | fromTabId:" + this._fromView + " | toTabId:" + this._outCome);
/*    */     try {
/* 22 */       save();
/* 23 */       return this._suc_target;
/*    */     } catch (Exception e) {
/* 25 */       e.printStackTrace();
/* 26 */     }return this._err_target;
/*    */   }
/*    */ 
/*    */   public void save()
/*    */   {
/* 31 */     ExeSQL exeSql = new ExeSQL();
/* 32 */     String sql = "update lnpcont set handler='" + this._fromView + "',remark='" + this._outCome + "',bankaccno='" + this._suc_target + "',accname='" + this._err_target + "' where ContNo='098766213213'";
/* 33 */     exeSql.execUpdateSQL(sql);
/*    */   }
/*    */ 
/*    */   public void query()
/*    */   {
/* 38 */     ExeSQL exeSql = new ExeSQL();
/* 39 */     String sql = "select handler,remark,bankaccno,accname from lnpcont where ContNo='098766213213'";
/* 40 */     SSRS ssrs = exeSql.execSQL(sql);
/* 41 */     for (int i = 1; i <= ssrs.MaxRow; i++)
/*    */     {
/* 43 */       this._lastID = ssrs.GetText(i, 2);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String get_suc_target()
/*    */   {
/* 49 */     return this._suc_target;
/*    */   }
/*    */   public void set_suc_target(String sucTarget) {
/* 52 */     this._suc_target = sucTarget;
/*    */   }
/*    */   public String get_err_target() {
/* 55 */     return this._err_target;
/*    */   }
/*    */   public void set_err_target(String errTarget) {
/* 58 */     this._err_target = errTarget;
/*    */   }
/*    */ 
/*    */   public String get_fromView()
/*    */   {
/* 64 */     return this._fromView;
/*    */   }
/*    */ 
/*    */   public void set_fromView(String fromView) {
/* 68 */     this._fromView = fromView;
/*    */   }
/*    */ 
/*    */   public String get_outCome() {
/* 72 */     return this._outCome;
/*    */   }
/*    */ 
/*    */   public void set_outCome(String outCome) {
/* 76 */     this._outCome = outCome;
/*    */   }
/*    */ 
/*    */   public String get_FToO() {
/* 80 */     return this._FToO;
/*    */   }
/*    */   public void set_FToO(String fToO) {
/* 83 */     this._FToO = fToO;
/*    */   }
/*    */   public String get_lastID() {
/* 86 */     query();
/* 87 */     return this._lastID;
/*    */   }
/*    */ 
/*    */   public void set_lastID(String lastID) {
/* 91 */     this._lastID = lastID;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.TurnTabController
 * JD-Core Version:    0.6.0
 */