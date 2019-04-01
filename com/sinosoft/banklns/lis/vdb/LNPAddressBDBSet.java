/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressBSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressBSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ 
/*     */ public class LNPAddressBDBSet extends LNPAddressBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  23 */   private boolean mflag = false;
/*     */ 
/*  25 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public LNPAddressBDBSet(Connection tConnection)
/*     */   {
/*  30 */     this.con = tConnection;
/*  31 */     this.db = new DBOper(this.con, "LNPAddressB");
/*  32 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAddressBDBSet()
/*     */   {
/*  37 */     this.db = new DBOper("LNPAddressB");
/*  38 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/*  43 */     int n = size();
/*  44 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  46 */       LNPAddressBSchema aSchema = new LNPAddressBSchema();
/*  47 */       aSchema.setSchema(get(i));
/*  48 */       if (this.db.insert(aSchema)) {
/*     */         continue;
/*     */       }
/*  51 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  52 */       CError tError = new CError();
/*  53 */       tError.moduleName = "LNPAddressBDBSet";
/*  54 */       tError.functionName = "insert";
/*  55 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  56 */       this.mErrors.addOneError(tError);
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */ 
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  66 */     int n = size();
/*  67 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  69 */       LNPAddressBSchema aSchema = new LNPAddressBSchema();
/*  70 */       aSchema.setSchema(get(i));
/*  71 */       if (this.db.update(aSchema)) {
/*     */         continue;
/*     */       }
/*  74 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  75 */       CError tError = new CError();
/*  76 */       tError.moduleName = "LNPAddressBDBSet";
/*  77 */       tError.functionName = "update";
/*  78 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  79 */       this.mErrors.addOneError(tError);
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */ 
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  89 */     int n = size();
/*  90 */     for (int i = 1; i <= n; i++)
/*     */     {
/*  92 */       LNPAddressBSchema aSchema = new LNPAddressBSchema();
/*  93 */       aSchema.setSchema(get(i));
/*  94 */       if (this.db.deleteSQL(aSchema)) {
/*     */         continue;
/*     */       }
/*  97 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  98 */       CError tError = new CError();
/*  99 */       tError.moduleName = "LNPAddressBDBSet";
/* 100 */       tError.functionName = "deleteSQL";
/* 101 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 102 */       this.mErrors.addOneError(tError);
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/* 112 */     int n = size();
/* 113 */     for (int i = 1; i <= n; i++)
/*     */     {
/* 115 */       LNPAddressBSchema aSchema = new LNPAddressBSchema();
/* 116 */       aSchema.setSchema(get(i));
/* 117 */       if (this.db.delete(aSchema)) {
/*     */         continue;
/*     */       }
/* 120 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 121 */       CError tError = new CError();
/* 122 */       tError.moduleName = "LNPAddressBDBSet";
/* 123 */       tError.functionName = "delete";
/* 124 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 125 */       this.mErrors.addOneError(tError);
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAddressBDBSet
 * JD-Core Version:    0.6.0
 */