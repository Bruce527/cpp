/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserLogSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserLogDBSet extends MUserLogSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserLogDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUserLog");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserLogDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUserLog");
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
/*  49 */     tError.moduleName = "MUserLogDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUserLog WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MUserLogDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUserLog SET  ID = ? , UserCode = ? , UserType = ? , TraceType = ? , MenuID = ? , MenuName = ? , Operation = ? , Discription = ? , CientIP = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
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
/* 143 */         if ((get(i).getTraceType() == null) || (get(i).getTraceType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getTraceType());
/*     */         }
/* 148 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMenuID());
/*     */         }
/* 153 */         if ((get(i).getMenuName() == null) || (get(i).getMenuName().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMenuName());
/*     */         }
/* 158 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getOperation());
/*     */         }
/* 163 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getDiscription());
/*     */         }
/* 168 */         if ((get(i).getCientIP() == null) || (get(i).getCientIP().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getCientIP());
/*     */         }
/* 173 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 178 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getMakeTime());
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
/* 198 */       tError.moduleName = "MUserLogDBSet";
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
/* 237 */       pstmt = this.con.prepareStatement("INSERT INTO MUserLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 238 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 240 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 241 */           pstmt.setString(1, null);
/*     */         else {
/* 243 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 245 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 246 */           pstmt.setString(2, null);
/*     */         else {
/* 248 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 250 */         if ((get(i).getUserType() == null) || (get(i).getUserType().equals("null")))
/* 251 */           pstmt.setString(3, null);
/*     */         else {
/* 253 */           pstmt.setString(3, get(i).getUserType());
/*     */         }
/* 255 */         if ((get(i).getTraceType() == null) || (get(i).getTraceType().equals("null")))
/* 256 */           pstmt.setString(4, null);
/*     */         else {
/* 258 */           pstmt.setString(4, get(i).getTraceType());
/*     */         }
/* 260 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 261 */           pstmt.setString(5, null);
/*     */         else {
/* 263 */           pstmt.setString(5, get(i).getMenuID());
/*     */         }
/* 265 */         if ((get(i).getMenuName() == null) || (get(i).getMenuName().equals("null")))
/* 266 */           pstmt.setString(6, null);
/*     */         else {
/* 268 */           pstmt.setString(6, get(i).getMenuName());
/*     */         }
/* 270 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 271 */           pstmt.setString(7, null);
/*     */         else {
/* 273 */           pstmt.setString(7, get(i).getOperation());
/*     */         }
/* 275 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 276 */           pstmt.setString(8, null);
/*     */         else {
/* 278 */           pstmt.setString(8, get(i).getDiscription());
/*     */         }
/* 280 */         if ((get(i).getCientIP() == null) || (get(i).getCientIP().equals("null")))
/* 281 */           pstmt.setString(9, null);
/*     */         else {
/* 283 */           pstmt.setString(9, get(i).getCientIP());
/*     */         }
/* 285 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 286 */           pstmt.setDate(10, null);
/*     */         else {
/* 288 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 290 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 291 */           pstmt.setString(11, null);
/*     */         else {
/* 293 */           pstmt.setString(11, get(i).getMakeTime());
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
/* 304 */       tError.moduleName = "MUserLogDBSet";
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
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserLogDBSet
 * JD-Core Version:    0.6.0
 */