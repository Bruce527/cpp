/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MSysVarSchema;
/*     */ import com.sinosoft.map.lis.vschema.MSysVarSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MSysVarDBSet extends MSysVarSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MSysVarDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MSysVar");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MSysVarDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MSysVar");
/*  35 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  40 */     if (this.db.deleteSQL(this))
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */ 
/*  47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  48 */     CError tError = new CError();
/*  49 */     tError.moduleName = "MSysVarDBSet";
/*  50 */     tError.functionName = "deleteSQL";
/*  51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  52 */     this.mErrors.addOneError(tError);
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  60 */     PreparedStatement pstmt = null;
/*     */ 
/*  62 */     if (!this.mflag) {
/*  63 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       int tCount = size();
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MSysVar WHERE  VarType = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getVarType() == null) || (get(i).getVarType().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getVarType());
/*     */         }
/*  77 */         pstmt.addBatch();
/*     */       }
/*  79 */       pstmt.executeBatch();
/*  80 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  83 */       ex.printStackTrace();
/*  84 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  85 */       CError tError = new CError();
/*  86 */       tError.moduleName = "MSysVarDBSet";
/*  87 */       tError.functionName = "delete()";
/*  88 */       tError.errorMessage = ex.toString();
/*  89 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  92 */         pstmt.close(); } catch (Exception e) {
/*  93 */         e.printStackTrace();
/*     */       }
/*  95 */       if (!this.mflag) {
/*     */         try {
/*  97 */           this.con.close(); } catch (Exception e) {
/*  98 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 101 */       return false;
/*     */     }
/*     */ 
/* 104 */     if (!this.mflag) {
/*     */       try {
/* 106 */         this.con.close(); } catch (Exception e) {
/* 107 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 116 */     PreparedStatement pstmt = null;
/*     */ 
/* 118 */     if (!this.mflag) {
/* 119 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 124 */       int tCount = size();
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MSysVar SET  VarType = ? , VarValue = ? WHERE  VarType = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getVarType() == null) || (get(i).getVarType().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getVarType());
/*     */         }
/* 133 */         if ((get(i).getVarValue() == null) || (get(i).getVarValue().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getVarValue());
/*     */         }
/*     */ 
/* 139 */         if ((get(i).getVarType() == null) || (get(i).getVarType().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getVarType());
/*     */         }
/* 144 */         pstmt.addBatch();
/*     */       }
/* 146 */       pstmt.executeBatch();
/* 147 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 150 */       ex.printStackTrace();
/* 151 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 152 */       CError tError = new CError();
/* 153 */       tError.moduleName = "MSysVarDBSet";
/* 154 */       tError.functionName = "update()";
/* 155 */       tError.errorMessage = ex.toString();
/* 156 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 159 */         pstmt.close(); } catch (Exception e) {
/* 160 */         e.printStackTrace();
/*     */       }
/* 162 */       if (!this.mflag) {
/*     */         try {
/* 164 */           this.con.close(); } catch (Exception e) {
/* 165 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 168 */       return false;
/*     */     }
/*     */ 
/* 171 */     if (!this.mflag) {
/*     */       try {
/* 173 */         this.con.close(); } catch (Exception e) {
/* 174 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 183 */     PreparedStatement pstmt = null;
/*     */ 
/* 185 */     if (!this.mflag) {
/* 186 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 191 */       int tCount = size();
/* 192 */       pstmt = this.con.prepareStatement("INSERT INTO MSysVar VALUES( ? , ?)");
/* 193 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 195 */         if ((get(i).getVarType() == null) || (get(i).getVarType().equals("null")))
/* 196 */           pstmt.setString(1, null);
/*     */         else {
/* 198 */           pstmt.setString(1, get(i).getVarType());
/*     */         }
/* 200 */         if ((get(i).getVarValue() == null) || (get(i).getVarValue().equals("null")))
/* 201 */           pstmt.setString(2, null);
/*     */         else {
/* 203 */           pstmt.setString(2, get(i).getVarValue());
/*     */         }
/* 205 */         pstmt.addBatch();
/*     */       }
/* 207 */       pstmt.executeBatch();
/* 208 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 211 */       ex.printStackTrace();
/* 212 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 213 */       CError tError = new CError();
/* 214 */       tError.moduleName = "MSysVarDBSet";
/* 215 */       tError.functionName = "insert()";
/* 216 */       tError.errorMessage = ex.toString();
/* 217 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 220 */         pstmt.close(); } catch (Exception e) {
/* 221 */         e.printStackTrace();
/*     */       }
/* 223 */       if (!this.mflag) {
/*     */         try {
/* 225 */           this.con.close(); } catch (Exception e) {
/* 226 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     if (!this.mflag) {
/*     */       try {
/* 234 */         this.con.close(); } catch (Exception e) {
/* 235 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MSysVarDBSet
 * JD-Core Version:    0.6.0
 */