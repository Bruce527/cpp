/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewsClickCountSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsClickCountSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewsClickCountDBSet extends MNewsClickCountSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewsClickCountDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNewsClickCount");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewsClickCountDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNewsClickCount");
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
/*  49 */     tError.moduleName = "MNewsClickCountDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsClickCount WHERE  NewsID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getNewsID());
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
/*  86 */       tError.moduleName = "MNewsClickCountDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNewsClickCount SET  NewsID = ? , ClickRate = ? WHERE  NewsID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNewsID());
/*     */         }
/* 133 */         pstmt.setDouble(2, get(i).getClickRate());
/*     */ 
/* 135 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 136 */           pstmt.setString(3, null);
/*     */         else {
/* 138 */           pstmt.setString(3, get(i).getNewsID());
/*     */         }
/* 140 */         pstmt.addBatch();
/*     */       }
/* 142 */       pstmt.executeBatch();
/* 143 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 146 */       ex.printStackTrace();
/* 147 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 148 */       CError tError = new CError();
/* 149 */       tError.moduleName = "MNewsClickCountDBSet";
/* 150 */       tError.functionName = "update()";
/* 151 */       tError.errorMessage = ex.toString();
/* 152 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 155 */         pstmt.close(); } catch (Exception e) {
/* 156 */         e.printStackTrace();
/*     */       }
/* 158 */       if (!this.mflag) {
/*     */         try {
/* 160 */           this.con.close(); } catch (Exception e) {
/* 161 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 164 */       return false;
/*     */     }
/*     */ 
/* 167 */     if (!this.mflag) {
/*     */       try {
/* 169 */         this.con.close(); } catch (Exception e) {
/* 170 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 179 */     PreparedStatement pstmt = null;
/*     */ 
/* 181 */     if (!this.mflag) {
/* 182 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 187 */       int tCount = size();
/* 188 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsClickCount VALUES( ? , ?)");
/* 189 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 191 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 192 */           pstmt.setString(1, null);
/*     */         else {
/* 194 */           pstmt.setString(1, get(i).getNewsID());
/*     */         }
/* 196 */         pstmt.setDouble(2, get(i).getClickRate());
/* 197 */         pstmt.addBatch();
/*     */       }
/* 199 */       pstmt.executeBatch();
/* 200 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 203 */       ex.printStackTrace();
/* 204 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 205 */       CError tError = new CError();
/* 206 */       tError.moduleName = "MNewsClickCountDBSet";
/* 207 */       tError.functionName = "insert()";
/* 208 */       tError.errorMessage = ex.toString();
/* 209 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 212 */         pstmt.close(); } catch (Exception e) {
/* 213 */         e.printStackTrace();
/*     */       }
/* 215 */       if (!this.mflag) {
/*     */         try {
/* 217 */           this.con.close(); } catch (Exception e) {
/* 218 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 221 */       return false;
/*     */     }
/*     */ 
/* 224 */     if (!this.mflag) {
/*     */       try {
/* 226 */         this.con.close(); } catch (Exception e) {
/* 227 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 230 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewsClickCountDBSet
 * JD-Core Version:    0.6.0
 */