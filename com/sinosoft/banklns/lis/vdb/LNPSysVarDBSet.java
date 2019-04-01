/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPSysVarSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPSysVarSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPSysVarDBSet extends LNPSysVarSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPSysVarDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPSysVar");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPSysVarDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPSysVar");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPSysVarDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPSysVar WHERE  SysVar = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getSysVar() == null) || (get(i).getSysVar().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getSysVar());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPSysVarDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPSysVar SET  SysVar = ? , SysVarType = ? , SysVarValue = ? WHERE  SysVar = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getSysVar() == null) || (get(i).getSysVar().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getSysVar());
/*     */         }
/* 134 */         if ((get(i).getSysVarType() == null) || (get(i).getSysVarType().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getSysVarType());
/*     */         }
/* 139 */         if ((get(i).getSysVarValue() == null) || (get(i).getSysVarValue().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getSysVarValue());
/*     */         }
/*     */ 
/* 145 */         if ((get(i).getSysVar() == null) || (get(i).getSysVar().equals("null")))
/* 146 */           pstmt.setString(4, null);
/*     */         else {
/* 148 */           pstmt.setString(4, get(i).getSysVar());
/*     */         }
/* 150 */         pstmt.addBatch();
/*     */       }
/* 152 */       pstmt.executeBatch();
/* 153 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 156 */       ex.printStackTrace();
/* 157 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 158 */       CError tError = new CError();
/* 159 */       tError.moduleName = "LNPSysVarDBSet";
/* 160 */       tError.functionName = "update()";
/* 161 */       tError.errorMessage = ex.toString();
/* 162 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 165 */         pstmt.close(); } catch (Exception e) {
/* 166 */         e.printStackTrace();
/*     */       }
/* 168 */       if (!this.mflag) {
/*     */         try {
/* 170 */           this.con.close(); } catch (Exception e) {
/* 171 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 174 */       return false;
/*     */     }
/*     */ 
/* 177 */     if (!this.mflag) {
/*     */       try {
/* 179 */         this.con.close(); } catch (Exception e) {
/* 180 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 189 */     PreparedStatement pstmt = null;
/*     */ 
/* 191 */     if (!this.mflag) {
/* 192 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 197 */       int tCount = size();
/* 198 */       pstmt = this.con.prepareStatement("INSERT INTO LNPSysVar VALUES( ? , ? , ?)");
/* 199 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 201 */         if ((get(i).getSysVar() == null) || (get(i).getSysVar().equals("null")))
/* 202 */           pstmt.setString(1, null);
/*     */         else {
/* 204 */           pstmt.setString(1, get(i).getSysVar());
/*     */         }
/* 206 */         if ((get(i).getSysVarType() == null) || (get(i).getSysVarType().equals("null")))
/* 207 */           pstmt.setString(2, null);
/*     */         else {
/* 209 */           pstmt.setString(2, get(i).getSysVarType());
/*     */         }
/* 211 */         if ((get(i).getSysVarValue() == null) || (get(i).getSysVarValue().equals("null")))
/* 212 */           pstmt.setString(3, null);
/*     */         else {
/* 214 */           pstmt.setString(3, get(i).getSysVarValue());
/*     */         }
/* 216 */         pstmt.addBatch();
/*     */       }
/* 218 */       pstmt.executeBatch();
/* 219 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 222 */       ex.printStackTrace();
/* 223 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 224 */       CError tError = new CError();
/* 225 */       tError.moduleName = "LNPSysVarDBSet";
/* 226 */       tError.functionName = "insert()";
/* 227 */       tError.errorMessage = ex.toString();
/* 228 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 231 */         pstmt.close(); } catch (Exception e) {
/* 232 */         e.printStackTrace();
/*     */       }
/* 234 */       if (!this.mflag) {
/*     */         try {
/* 236 */           this.con.close(); } catch (Exception e) {
/* 237 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 240 */       return false;
/*     */     }
/*     */ 
/* 243 */     if (!this.mflag) {
/*     */       try {
/* 245 */         this.con.close(); } catch (Exception e) {
/* 246 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPSysVarDBSet
 * JD-Core Version:    0.6.0
 */