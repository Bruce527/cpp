/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPMaxNoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPMaxNoSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPMaxNoDBSet extends LNPMaxNoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPMaxNoDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPMaxNo");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPMaxNo");
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
/*  50 */     tError.moduleName = "LNPMaxNoDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPMaxNo WHERE  NoType = ? AND NoLimit = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/*  78 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPMaxNoDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPMaxNo SET  NoType = ? , NoLimit = ? , MaxNo = ? WHERE  NoType = ? AND NoLimit = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/* 139 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/* 144 */         pstmt.setInt(3, get(i).getMaxNo());
/*     */ 
/* 146 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 147 */           pstmt.setString(4, null);
/*     */         else {
/* 149 */           pstmt.setString(4, get(i).getNoType());
/*     */         }
/* 151 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 152 */           pstmt.setString(5, null);
/*     */         else {
/* 154 */           pstmt.setString(5, get(i).getNoLimit());
/*     */         }
/* 156 */         pstmt.addBatch();
/*     */       }
/* 158 */       pstmt.executeBatch();
/* 159 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 162 */       ex.printStackTrace();
/* 163 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 164 */       CError tError = new CError();
/* 165 */       tError.moduleName = "LNPMaxNoDBSet";
/* 166 */       tError.functionName = "update()";
/* 167 */       tError.errorMessage = ex.toString();
/* 168 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 171 */         pstmt.close(); } catch (Exception e) {
/* 172 */         e.printStackTrace();
/*     */       }
/* 174 */       if (!this.mflag) {
/*     */         try {
/* 176 */           this.con.close(); } catch (Exception e) {
/* 177 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 180 */       return false;
/*     */     }
/*     */ 
/* 183 */     if (!this.mflag) {
/*     */       try {
/* 185 */         this.con.close(); } catch (Exception e) {
/* 186 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 195 */     PreparedStatement pstmt = null;
/*     */ 
/* 197 */     if (!this.mflag) {
/* 198 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 203 */       int tCount = size();
/* 204 */       pstmt = this.con.prepareStatement("INSERT INTO LNPMaxNo VALUES( ? , ? , ?)");
/* 205 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 207 */         if ((get(i).getNoType() == null) || (get(i).getNoType().equals("null")))
/* 208 */           pstmt.setString(1, null);
/*     */         else {
/* 210 */           pstmt.setString(1, get(i).getNoType());
/*     */         }
/* 212 */         if ((get(i).getNoLimit() == null) || (get(i).getNoLimit().equals("null")))
/* 213 */           pstmt.setString(2, null);
/*     */         else {
/* 215 */           pstmt.setString(2, get(i).getNoLimit());
/*     */         }
/* 217 */         pstmt.setInt(3, get(i).getMaxNo());
/* 218 */         pstmt.addBatch();
/*     */       }
/* 220 */       pstmt.executeBatch();
/* 221 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 224 */       ex.printStackTrace();
/* 225 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 226 */       CError tError = new CError();
/* 227 */       tError.moduleName = "LNPMaxNoDBSet";
/* 228 */       tError.functionName = "insert()";
/* 229 */       tError.errorMessage = ex.toString();
/* 230 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 233 */         pstmt.close(); } catch (Exception e) {
/* 234 */         e.printStackTrace();
/*     */       }
/* 236 */       if (!this.mflag) {
/*     */         try {
/* 238 */           this.con.close(); } catch (Exception e) {
/* 239 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 242 */       return false;
/*     */     }
/*     */ 
/* 245 */     if (!this.mflag) {
/*     */       try {
/* 247 */         this.con.close(); } catch (Exception e) {
/* 248 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 251 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPMaxNoDBSet
 * JD-Core Version:    0.6.0
 */