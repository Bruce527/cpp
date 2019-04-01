/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserRoleMapSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserRoleMapSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserRoleMapDBSet extends MUserRoleMapSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserRoleMapDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUserRoleMap");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserRoleMapDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUserRoleMap");
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
/*  49 */     tError.moduleName = "MUserRoleMapDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUserRoleMap WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MUserRoleMapDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUserRoleMap SET  ID = ? , UserCode = ? , RoleID = ? , Type = ? , StartDate = ? , EndDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? WHERE  ID = ?");
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
/* 138 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getRoleID());
/*     */         }
/* 143 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 148 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 149 */           pstmt.setDate(5, null);
/*     */         else {
/* 151 */           pstmt.setDate(5, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 153 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 158 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 163 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 168 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 173 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 178 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 183 */         pstmt.setInt(12, get(i).getInt1());
/* 184 */         pstmt.setInt(13, get(i).getInt2());
/* 185 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 190 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 191 */           pstmt.setString(15, null);
/*     */         else {
/* 193 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/*     */ 
/* 196 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 197 */           pstmt.setString(16, null);
/*     */         else {
/* 199 */           pstmt.setString(16, get(i).getID());
/*     */         }
/* 201 */         pstmt.addBatch();
/*     */       }
/* 203 */       pstmt.executeBatch();
/* 204 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 207 */       ex.printStackTrace();
/* 208 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 209 */       CError tError = new CError();
/* 210 */       tError.moduleName = "MUserRoleMapDBSet";
/* 211 */       tError.functionName = "update()";
/* 212 */       tError.errorMessage = ex.toString();
/* 213 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 216 */         pstmt.close(); } catch (Exception e) {
/* 217 */         e.printStackTrace();
/*     */       }
/* 219 */       if (!this.mflag) {
/*     */         try {
/* 221 */           this.con.close(); } catch (Exception e) {
/* 222 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 225 */       return false;
/*     */     }
/*     */ 
/* 228 */     if (!this.mflag) {
/*     */       try {
/* 230 */         this.con.close(); } catch (Exception e) {
/* 231 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 240 */     PreparedStatement pstmt = null;
/*     */ 
/* 242 */     if (!this.mflag) {
/* 243 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 248 */       int tCount = size();
/* 249 */       pstmt = this.con.prepareStatement("INSERT INTO MUserRoleMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 250 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 252 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 253 */           pstmt.setString(1, null);
/*     */         else {
/* 255 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 257 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 258 */           pstmt.setString(2, null);
/*     */         else {
/* 260 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 262 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 263 */           pstmt.setString(3, null);
/*     */         else {
/* 265 */           pstmt.setString(3, get(i).getRoleID());
/*     */         }
/* 267 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 268 */           pstmt.setString(4, null);
/*     */         else {
/* 270 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 272 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 273 */           pstmt.setDate(5, null);
/*     */         else {
/* 275 */           pstmt.setDate(5, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 277 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 278 */           pstmt.setDate(6, null);
/*     */         else {
/* 280 */           pstmt.setDate(6, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 282 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 283 */           pstmt.setString(7, null);
/*     */         else {
/* 285 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 287 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 288 */           pstmt.setDate(8, null);
/*     */         else {
/* 290 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 292 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 293 */           pstmt.setString(9, null);
/*     */         else {
/* 295 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 297 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 298 */           pstmt.setDate(10, null);
/*     */         else {
/* 300 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 302 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 303 */           pstmt.setString(11, null);
/*     */         else {
/* 305 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 307 */         pstmt.setInt(12, get(i).getInt1());
/* 308 */         pstmt.setInt(13, get(i).getInt2());
/* 309 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 310 */           pstmt.setString(14, null);
/*     */         else {
/* 312 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 314 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 315 */           pstmt.setString(15, null);
/*     */         else {
/* 317 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/* 319 */         pstmt.addBatch();
/*     */       }
/* 321 */       pstmt.executeBatch();
/* 322 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 325 */       ex.printStackTrace();
/* 326 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 327 */       CError tError = new CError();
/* 328 */       tError.moduleName = "MUserRoleMapDBSet";
/* 329 */       tError.functionName = "insert()";
/* 330 */       tError.errorMessage = ex.toString();
/* 331 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 334 */         pstmt.close(); } catch (Exception e) {
/* 335 */         e.printStackTrace();
/*     */       }
/* 337 */       if (!this.mflag) {
/*     */         try {
/* 339 */           this.con.close(); } catch (Exception e) {
/* 340 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 343 */       return false;
/*     */     }
/*     */ 
/* 346 */     if (!this.mflag) {
/*     */       try {
/* 348 */         this.con.close(); } catch (Exception e) {
/* 349 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 352 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserRoleMapDBSet
 * JD-Core Version:    0.6.0
 */