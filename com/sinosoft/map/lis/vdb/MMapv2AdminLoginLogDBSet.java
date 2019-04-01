/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMapv2AdminLoginLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMapv2AdminLoginLogSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MMapv2AdminLoginLogDBSet extends MMapv2AdminLoginLogSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MMapv2AdminLoginLogDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MMapv2AdminLoginLog");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMapv2AdminLoginLogDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MMapv2AdminLoginLog");
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
/*  49 */     tError.moduleName = "MMapv2AdminLoginLogDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MMapv2AdminLoginLog WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MMapv2AdminLoginLogDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MMapv2AdminLoginLog SET  ID = ? , AgentCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getAgentCode());
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
/* 158 */         if ((get(i).getLoginDate() == null) || (get(i).getLoginDate().equals("null")))
/* 159 */           pstmt.setDate(7, null);
/*     */         else {
/* 161 */           pstmt.setDate(7, Date.valueOf(get(i).getLoginDate()));
/*     */         }
/* 163 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getLoginTime());
/*     */         }
/* 168 */         if ((get(i).getLogoutDate() == null) || (get(i).getLogoutDate().equals("null")))
/* 169 */           pstmt.setDate(9, null);
/*     */         else {
/* 171 */           pstmt.setDate(9, Date.valueOf(get(i).getLogoutDate()));
/*     */         }
/* 173 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getLogoutTime());
/*     */         }
/*     */ 
/* 179 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getID());
/*     */         }
/* 184 */         pstmt.addBatch();
/*     */       }
/* 186 */       pstmt.executeBatch();
/* 187 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 190 */       ex.printStackTrace();
/* 191 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 192 */       CError tError = new CError();
/* 193 */       tError.moduleName = "MMapv2AdminLoginLogDBSet";
/* 194 */       tError.functionName = "update()";
/* 195 */       tError.errorMessage = ex.toString();
/* 196 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 199 */         pstmt.close(); } catch (Exception e) {
/* 200 */         e.printStackTrace();
/*     */       }
/* 202 */       if (!this.mflag) {
/*     */         try {
/* 204 */           this.con.close(); } catch (Exception e) {
/* 205 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 208 */       return false;
/*     */     }
/*     */ 
/* 211 */     if (!this.mflag) {
/*     */       try {
/* 213 */         this.con.close(); } catch (Exception e) {
/* 214 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 223 */     PreparedStatement pstmt = null;
/*     */ 
/* 225 */     if (!this.mflag) {
/* 226 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 231 */       int tCount = size();
/* 232 */       pstmt = this.con.prepareStatement("INSERT INTO MMapv2AdminLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 233 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 235 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 236 */           pstmt.setString(1, null);
/*     */         else {
/* 238 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 240 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 241 */           pstmt.setString(2, null);
/*     */         else {
/* 243 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 245 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 246 */           pstmt.setString(3, null);
/*     */         else {
/* 248 */           pstmt.setString(3, get(i).getUserType());
/*     */         }
/* 250 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 251 */           pstmt.setString(4, null);
/*     */         else {
/* 253 */           pstmt.setString(4, get(i).getClientName());
/*     */         }
/* 255 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 256 */           pstmt.setString(5, null);
/*     */         else {
/* 258 */           pstmt.setString(5, get(i).getClientType());
/*     */         }
/* 260 */         if ((get(i).getClientIP() == null) || (get(i).getClientIP().equals("null")))
/* 261 */           pstmt.setString(6, null);
/*     */         else {
/* 263 */           pstmt.setString(6, get(i).getClientIP());
/*     */         }
/* 265 */         if ((get(i).getLoginDate() == null) || (get(i).getLoginDate().equals("null")))
/* 266 */           pstmt.setDate(7, null);
/*     */         else {
/* 268 */           pstmt.setDate(7, Date.valueOf(get(i).getLoginDate()));
/*     */         }
/* 270 */         if ((get(i).getLoginTime() == null) || (get(i).getLoginTime().equals("null")))
/* 271 */           pstmt.setString(8, null);
/*     */         else {
/* 273 */           pstmt.setString(8, get(i).getLoginTime());
/*     */         }
/* 275 */         if ((get(i).getLogoutDate() == null) || (get(i).getLogoutDate().equals("null")))
/* 276 */           pstmt.setDate(9, null);
/*     */         else {
/* 278 */           pstmt.setDate(9, Date.valueOf(get(i).getLogoutDate()));
/*     */         }
/* 280 */         if ((get(i).getLogoutTime() == null) || (get(i).getLogoutTime().equals("null")))
/* 281 */           pstmt.setString(10, null);
/*     */         else {
/* 283 */           pstmt.setString(10, get(i).getLogoutTime());
/*     */         }
/* 285 */         pstmt.addBatch();
/*     */       }
/* 287 */       pstmt.executeBatch();
/* 288 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 291 */       ex.printStackTrace();
/* 292 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 293 */       CError tError = new CError();
/* 294 */       tError.moduleName = "MMapv2AdminLoginLogDBSet";
/* 295 */       tError.functionName = "insert()";
/* 296 */       tError.errorMessage = ex.toString();
/* 297 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 300 */         pstmt.close(); } catch (Exception e) {
/* 301 */         e.printStackTrace();
/*     */       }
/* 303 */       if (!this.mflag) {
/*     */         try {
/* 305 */           this.con.close(); } catch (Exception e) {
/* 306 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 309 */       return false;
/*     */     }
/*     */ 
/* 312 */     if (!this.mflag) {
/*     */       try {
/* 314 */         this.con.close(); } catch (Exception e) {
/* 315 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 318 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MMapv2AdminLoginLogDBSet
 * JD-Core Version:    0.6.0
 */