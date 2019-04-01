/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserLoginLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserLoginLogSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserLoginLogDBSet extends MUserLoginLogSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserLoginLogDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUserLoginLog");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUserLoginLog");
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
/*  49 */     tError.moduleName = "MUserLoginLogDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUserLoginLog WHERE  ID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getID());
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
/*  86 */       tError.moduleName = "MUserLoginLogDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUserLoginLog SET  ID = ? , UserCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 138 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getUserType());
/*     */         }
/* 143 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getClientName());
/*     */         }
/* 148 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getClientType());
/*     */         }
/* 153 */         if ((get(i).getClientIP() == null) || (get(i).getClientIP().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getClientIP());
/*     */         }
/* 158 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 159 */           pstmt.setString(8, null);
/*     */         else {
/* 161 */           pstmt.setString(8, get(i).getLoginTime());
/*     */         }
/* 163 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 164 */           pstmt.setString(10, null);
/*     */         else {
/* 166 */           pstmt.setString(10, get(i).getLogoutTime());
/*     */         }
/*     */ 
/* 169 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 170 */           pstmt.setString(11, null);
/*     */         else {
/* 172 */           pstmt.setString(11, get(i).getID());
/*     */         }
/* 174 */         pstmt.addBatch();
/*     */       }
/* 176 */       pstmt.executeBatch();
/* 177 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 180 */       ex.printStackTrace();
/* 181 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 182 */       CError tError = new CError();
/* 183 */       tError.moduleName = "MUserLoginLogDBSet";
/* 184 */       tError.functionName = "update()";
/* 185 */       tError.errorMessage = ex.toString();
/* 186 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 189 */         pstmt.close(); } catch (Exception e) {
/* 190 */         e.printStackTrace();
/*     */       }
/* 192 */       if (!this.mflag) {
/*     */         try {
/* 194 */           this.con.close(); } catch (Exception e) {
/* 195 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 198 */       return false;
/*     */     }
/*     */ 
/* 201 */     if (!this.mflag) {
/*     */       try {
/* 203 */         this.con.close(); } catch (Exception e) {
/* 204 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 213 */     PreparedStatement pstmt = null;
/*     */ 
/* 215 */     if (!this.mflag) {
/* 216 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 221 */       int tCount = size();
/* 222 */       pstmt = this.con.prepareStatement("INSERT INTO MUserLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 223 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 225 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 226 */           pstmt.setString(1, null);
/*     */         else {
/* 228 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 230 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 231 */           pstmt.setString(2, null);
/*     */         else {
/* 233 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 235 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 236 */           pstmt.setString(3, null);
/*     */         else {
/* 238 */           pstmt.setString(3, get(i).getUserType());
/*     */         }
/* 240 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 241 */           pstmt.setString(4, null);
/*     */         else {
/* 243 */           pstmt.setString(4, get(i).getClientName());
/*     */         }
/* 245 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 246 */           pstmt.setString(5, null);
/*     */         else {
/* 248 */           pstmt.setString(5, get(i).getClientType());
/*     */         }
/* 250 */         if ((get(i).getClientIP() == null) || (get(i).getClientIP().equals("null")))
/* 251 */           pstmt.setString(6, null);
/*     */         else {
/* 253 */           pstmt.setString(6, get(i).getClientIP());
/*     */         }
/* 255 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 256 */           pstmt.setString(8, null);
/*     */         else {
/* 258 */           pstmt.setString(8, get(i).getLoginTime());
/*     */         }
/* 260 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 261 */           pstmt.setString(10, null);
/*     */         else {
/* 263 */           pstmt.setString(10, get(i).getLogoutTime());
/*     */         }
/* 265 */         pstmt.addBatch();
/*     */       }
/* 267 */       pstmt.executeBatch();
/* 268 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 271 */       ex.printStackTrace();
/* 272 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 273 */       CError tError = new CError();
/* 274 */       tError.moduleName = "MUserLoginLogDBSet";
/* 275 */       tError.functionName = "insert()";
/* 276 */       tError.errorMessage = ex.toString();
/* 277 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 280 */         pstmt.close(); } catch (Exception e) {
/* 281 */         e.printStackTrace();
/*     */       }
/* 283 */       if (!this.mflag) {
/*     */         try {
/* 285 */           this.con.close(); } catch (Exception e) {
/* 286 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 289 */       return false;
/*     */     }
/*     */ 
/* 292 */     if (!this.mflag) {
/*     */       try {
/* 294 */         this.con.close(); } catch (Exception e) {
/* 295 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserLoginLogDBSet
 * JD-Core Version:    0.6.0
 */