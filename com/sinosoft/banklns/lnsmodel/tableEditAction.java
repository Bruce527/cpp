/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class tableEditAction
/*    */ {
/*  6 */   private List<EntImport> ents = new ArrayList();
/*    */ 
/*    */   public tableEditAction() {
/*  9 */     EntImport ent = new EntImport();
/* 10 */     ent.setDouble1("double12321312");
/* 11 */     ent.setLong1("long12321312");
/* 12 */     this.ents.add(ent);
/* 13 */     ent = new EntImport();
/* 14 */     ent.setDouble1("double22321312");
/* 15 */     ent.setLong1("long22321312");
/* 16 */     this.ents.add(ent);
/*    */   }
/*    */ 
/*    */   public void addOne() {
/* 20 */     System.out.println("add-----");
/* 21 */     EntImport ent = new EntImport();
/* 22 */     ent.setDouble1("double12321312");
/* 23 */     ent.setLong1("long12321312");
/* 24 */     this.ents.add(ent);
/*    */   }
/*    */   public void addSave() {
/* 27 */     System.out.println("save-----" + this.ents.size());
/* 28 */     this.ents.clear();
/*    */   }
/*    */   public List<EntImport> getEnts() {
/* 31 */     return this.ents;
/*    */   }
/*    */   public void setEnts(List<EntImport> ents) {
/* 34 */     this.ents = ents;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.tableEditAction
 * JD-Core Version:    0.6.0
 */