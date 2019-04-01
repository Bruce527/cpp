/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MWebLoginLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MWebLoginLogSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MWebLoginLogDBSet extends MWebLoginLogSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MWebLoginLogDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MWebLoginLog");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MWebLoginLogDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MWebLoginLog");
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
/*  49 */     tError.moduleName = "MWebLoginLogDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MWebLoginLog WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MWebLoginLogDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MWebLoginLog SET  ID = ? , SessionId = ? , UserCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getSessionId() == null) || (get(i).getSessionId().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getSessionId());
/*     */         }
/* 138 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getUserCode());
/*     */         }
/* 143 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getUserType());
/*     */         }
/* 148 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getClientName());
/*     */         }
/* 153 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getClientType());
/*     */         }
/* 158 */         if ((get(i).getClientIP() == null) || (get(i).getClientIP().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getClientIP());
/*     */         }
/* 163 */         if ((get(i).getLoginDate() == null) || (get(i).getLoginDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getLoginDate()));
/*     */         }
/* 168 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getLoginTime());
/*     */         }
/* 173 */         if ((get(i).getLogoutDate() == null) || (get(i).getLogoutDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getLogoutDate()));
/*     */         }
/* 178 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getLogoutTime());
/*     */         }
/*     */ 
/* 184 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getID());
/*     */         }
/* 189 */         pstmt.addBatch();
/*     */       }
/* 191 */       pstmt.executeBatch();
/* 192 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 195 */       ex.printStackTrace();
/* 196 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 197 */       CError tError = new CError();
/* 198 */       tError.moduleName = "MWebLoginLogDBSet";
/* 199 */       tError.functionName = "update()";
/* 200 */       tError.errorMessage = ex.toString();
/* 201 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 204 */         pstmt.close(); } catch (Exception e) {
/* 205 */         e.printStackTrace();
/*     */       }
/* 207 */       if (!this.mflag) {
/*     */         try {
/* 209 */           this.con.close(); } catch (Exception e) {
/* 210 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 213 */       return false;
/*     */     }
/*     */ 
/* 216 */     if (!this.mflag) {
/*     */       try {
/* 218 */         this.con.close(); } catch (Exception e) {
/* 219 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 228 */     PreparedStatement pstmt = null;
/*     */ 
/* 230 */     if (!this.mflag) {
/* 231 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 236 */       int tCount = size();
/* 237 */       pstmt = this.con.prepareStatement("INSERT INTO MWebLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 238 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 240 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 241 */           pstmt.setString(1, null);
/*     */         else {
/* 243 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 245 */         if ((get(i).getSessionId() == null) || (get(i).getSessionId().equals("null")))
/* 246 */           pstmt.setString(2, null);
/*     */         else {
/* 248 */           pstmt.setString(2, get(i).getSessionId());
/*     */         }
/* 250 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 251 */           pstmt.setString(3, null);
/*     */         else {
/* 253 */           pstmt.setString(3, get(i).getUserCode());
/*     */         }
/* 255 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 256 */           pstmt.setString(4, null);
/*     */         else {
/* 258 */           pstmt.setString(4, get(i).getUserType());
/*     */         }
/* 260 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 261 */           pstmt.setString(5, null);
/*     */         else {
/* 263 */           pstmt.setString(5, get(i).getClientName());
/*     */         }
/* 265 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 266 */           pstmt.setString(6, null);
/*     */         else {
/* 268 */           pstmt.setString(6, get(i).getClientType());
/*     */         }
/* 270 */         if ((get(i).getClientIP() == null) || (get(i).getClientIP().equals("null")))
/* 271 */           pstmt.setString(7, null);
/*     */         else {
/* 273 */           pstmt.setString(7, get(i).getClientIP());
/*     */         }
/* 275 */         if ((get(i).getLoginDate() == null) || (get(i).getLoginDate().equals("null")))
/* 276 */           pstmt.setDate(8, null);
/*     */         else {
/* 278 */           pstmt.setDate(8, Date.valueOf(get(i).getLoginDate()));
/*     */         }
/* 280 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 281 */           pstmt.setString(9, null);
/*     */         else {
/* 283 */           pstmt.setString(9, get(i).getLoginTime());
/*     */         }
/* 285 */         if ((get(i).getLogoutDate() == null) || (get(i).getLogoutDate().equals("null")))
/* 286 */           pstmt.setDate(10, null);
/*     */         else {
/* 288 */           pstmt.setDate(10, Date.valueOf(get(i).getLogoutDate()));
/*     */         }
/* 290 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 291 */           pstmt.setString(11, null);
/*     */         else {
/* 293 */           pstmt.setString(11, get(i).getLogoutTime());
/*     */         }
/* 295 */         pstmt.addBatch();
/*     */       }
/* 297 */       pstmt.executeBatch();
/* 298 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 301 */       ex.printStackTrace();
/* 302 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 303 */       CError tError = new CError();
/* 304 */       tError.moduleName = "MWebLoginLogDBSet";
/* 305 */       tError.functionName = "insert()";
/* 306 */       tError.errorMessage = ex.toString();
/* 307 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 310 */         pstmt.close(); } catch (Exception e) {
/* 311 */         e.printStackTrace();
/*     */       }
/* 313 */       if (!this.mflag) {
/*     */         try {
/* 315 */           this.con.close(); } catch (Exception e) {
/* 316 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 319 */       return false;
/*     */     }
/*     */ 
/* 322 */     if (!this.mflag) {
/*     */       try {
/* 324 */         this.con.close(); } catch (Exception e) {
/* 325 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MWebLoginLogDBSet
 * JD-Core Version:    0.6.0
 */