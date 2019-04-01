/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComGrpToComSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPComGrpToComDBSet extends LNPComGrpToComSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPComGrpToComDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPComGrpToCom");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPComGrpToCom");
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
/*  50 */     tError.moduleName = "LNPComGrpToComDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPComGrpToCom WHERE  ComGrpCode = ? AND ComCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getComGrpCode());
/*     */         }
/*  78 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getComCode());
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
/*  92 */       tError.moduleName = "LNPComGrpToComDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPComGrpToCom SET  ComGrpCode = ? , ComCode = ? , ComCodeType = ? WHERE  ComGrpCode = ? AND ComCode = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getComGrpCode());
/*     */         }
/* 139 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getComCode());
/*     */         }
/* 144 */         if ((get(i).getComCodeType() == null) || (get(i).getComCodeType().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getComCodeType());
/*     */         }
/*     */ 
/* 150 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 151 */           pstmt.setString(4, null);
/*     */         else {
/* 153 */           pstmt.setString(4, get(i).getComGrpCode());
/*     */         }
/* 155 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 156 */           pstmt.setString(5, null);
/*     */         else {
/* 158 */           pstmt.setString(5, get(i).getComCode());
/*     */         }
/* 160 */         pstmt.addBatch();
/*     */       }
/* 162 */       pstmt.executeBatch();
/* 163 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 166 */       ex.printStackTrace();
/* 167 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 168 */       CError tError = new CError();
/* 169 */       tError.moduleName = "LNPComGrpToComDBSet";
/* 170 */       tError.functionName = "update()";
/* 171 */       tError.errorMessage = ex.toString();
/* 172 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 175 */         pstmt.close(); } catch (Exception e) {
/* 176 */         e.printStackTrace();
/*     */       }
/* 178 */       if (!this.mflag) {
/*     */         try {
/* 180 */           this.con.close(); } catch (Exception e) {
/* 181 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 184 */       return false;
/*     */     }
/*     */ 
/* 187 */     if (!this.mflag) {
/*     */       try {
/* 189 */         this.con.close(); } catch (Exception e) {
/* 190 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 199 */     PreparedStatement pstmt = null;
/*     */ 
/* 201 */     if (!this.mflag) {
/* 202 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 207 */       int tCount = size();
/* 208 */       pstmt = this.con.prepareStatement("INSERT INTO LNPComGrpToCom VALUES( ? , ? , ?)");
/* 209 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 211 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 212 */           pstmt.setString(1, null);
/*     */         else {
/* 214 */           pstmt.setString(1, get(i).getComGrpCode());
/*     */         }
/* 216 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 217 */           pstmt.setString(2, null);
/*     */         else {
/* 219 */           pstmt.setString(2, get(i).getComCode());
/*     */         }
/* 221 */         if ((get(i).getComCodeType() == null) || (get(i).getComCodeType().equals("null")))
/* 222 */           pstmt.setString(3, null);
/*     */         else {
/* 224 */           pstmt.setString(3, get(i).getComCodeType());
/*     */         }
/* 226 */         pstmt.addBatch();
/*     */       }
/* 228 */       pstmt.executeBatch();
/* 229 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 232 */       ex.printStackTrace();
/* 233 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 234 */       CError tError = new CError();
/* 235 */       tError.moduleName = "LNPComGrpToComDBSet";
/* 236 */       tError.functionName = "insert()";
/* 237 */       tError.errorMessage = ex.toString();
/* 238 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 241 */         pstmt.close(); } catch (Exception e) {
/* 242 */         e.printStackTrace();
/*     */       }
/* 244 */       if (!this.mflag) {
/*     */         try {
/* 246 */           this.con.close(); } catch (Exception e) {
/* 247 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 250 */       return false;
/*     */     }
/*     */ 
/* 253 */     if (!this.mflag) {
/*     */       try {
/* 255 */         this.con.close(); } catch (Exception e) {
/* 256 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 259 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPComGrpToComDBSet
 * JD-Core Version:    0.6.0
 */