/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ 
/*     */ public class LNPBnfDBSet extends LNPBnfSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  25 */   private boolean mflag = false;
/*     */ 
/*  27 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public LNPBnfDBSet(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPBnf");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPBnfDBSet()
/*     */   {
/*  39 */     this.db = new DBOper("LNPBnf");
/*  40 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/*  45 */     int n = size();
/*  46 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  48 */       LNPBnfSchema aSchema = new LNPBnfSchema();
/*  49 */       aSchema.setSchema(get(i));
/*  50 */       if (this.db.insert(aSchema)) {
/*     */         continue;
/*     */       }
/*  53 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  54 */       CError tError = new CError();
/*  55 */       tError.moduleName = "LNPBnfDBSet";
/*  56 */       tError.functionName = "insert";
/*  57 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  58 */       this.mErrors.addOneError(tError);
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */ 
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  68 */     int n = size();
/*  69 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  71 */       LNPBnfSchema aSchema = new LNPBnfSchema();
/*  72 */       aSchema.setSchema(get(i));
/*  73 */       if (this.db.update(aSchema)) {
/*     */         continue;
/*     */       }
/*  76 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  77 */       CError tError = new CError();
/*  78 */       tError.moduleName = "LNPBnfDBSet";
/*  79 */       tError.functionName = "update";
/*  80 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  81 */       this.mErrors.addOneError(tError);
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */ 
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  91 */     int n = size();
/*  92 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  94 */       LNPBnfSchema aSchema = new LNPBnfSchema();
/*  95 */       aSchema.setSchema(get(i));
/*  96 */       if (this.db.deleteSQL(aSchema)) {
/*     */         continue;
/*     */       }
/*  99 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 100 */       CError tError = new CError();
/* 101 */       tError.moduleName = "LNPBnfDBSet";
/* 102 */       tError.functionName = "deleteSQL";
/* 103 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 104 */       this.mErrors.addOneError(tError);
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */ 
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/* 114 */     int n = size();
/* 115 */     for (int i = 1; i <= n; i++)
/*     */     {
/* 117 */       LNPBnfSchema aSchema = new LNPBnfSchema();
/* 118 */       aSchema.setSchema(get(i));
/* 119 */       if (this.db.delete(aSchema)) {
/*     */         continue;
/*     */       }
/* 122 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 123 */       CError tError = new CError();
/* 124 */       tError.moduleName = "LNPBnfDBSet";
/* 125 */       tError.functionName = "delete";
/* 126 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 127 */       this.mErrors.addOneError(tError);
/*     */ 
/* 129 */       return false;
/*     */     }
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPBnfDBSet
 * JD-Core Version:    0.6.0
 */