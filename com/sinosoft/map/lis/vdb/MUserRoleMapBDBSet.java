/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserRoleMapBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserRoleMapBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserRoleMapBDBSet extends MUserRoleMapBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserRoleMapBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUserRoleMapB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserRoleMapBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUserRoleMapB");
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
/*  49 */     tError.moduleName = "MUserRoleMapBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUserRoleMapB WHERE  EdorNo = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getEdorNo());
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
/*  86 */       tError.moduleName = "MUserRoleMapBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUserRoleMapB SET  ID = ? , UserCode = ? , RoleID = ? , Type = ? , StartDate = ? , EndDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
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
/* 195 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getEdorNo());
/*     */         }
/* 200 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getEdorType());
/*     */         }
/* 205 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getEdorCase());
/*     */         }
/* 210 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getOperator2());
/*     */         }
/* 215 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 216 */           pstmt.setDate(20, null);
/*     */         else {
/* 218 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 220 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 221 */           pstmt.setString(21, null);
/*     */         else {
/* 223 */           pstmt.setString(21, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 226 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 227 */           pstmt.setString(22, null);
/*     */         else {
/* 229 */           pstmt.setString(22, get(i).getEdorNo());
/*     */         }
/* 231 */         pstmt.addBatch();
/*     */       }
/* 233 */       pstmt.executeBatch();
/* 234 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 237 */       ex.printStackTrace();
/* 238 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 239 */       CError tError = new CError();
/* 240 */       tError.moduleName = "MUserRoleMapBDBSet";
/* 241 */       tError.functionName = "update()";
/* 242 */       tError.errorMessage = ex.toString();
/* 243 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 246 */         pstmt.close(); } catch (Exception e) {
/* 247 */         e.printStackTrace();
/*     */       }
/* 249 */       if (!this.mflag) {
/*     */         try {
/* 251 */           this.con.close(); } catch (Exception e) {
/* 252 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 255 */       return false;
/*     */     }
/*     */ 
/* 258 */     if (!this.mflag) {
/*     */       try {
/* 260 */         this.con.close(); } catch (Exception e) {
/* 261 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 270 */     PreparedStatement pstmt = null;
/*     */ 
/* 272 */     if (!this.mflag) {
/* 273 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 278 */       int tCount = size();
/* 279 */       pstmt = this.con.prepareStatement("INSERT INTO MUserRoleMapB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 280 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 282 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 283 */           pstmt.setString(1, null);
/*     */         else {
/* 285 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 287 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 288 */           pstmt.setString(2, null);
/*     */         else {
/* 290 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 292 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 293 */           pstmt.setString(3, null);
/*     */         else {
/* 295 */           pstmt.setString(3, get(i).getRoleID());
/*     */         }
/* 297 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 298 */           pstmt.setString(4, null);
/*     */         else {
/* 300 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 302 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 303 */           pstmt.setDate(5, null);
/*     */         else {
/* 305 */           pstmt.setDate(5, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 307 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 308 */           pstmt.setDate(6, null);
/*     */         else {
/* 310 */           pstmt.setDate(6, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 312 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 313 */           pstmt.setString(7, null);
/*     */         else {
/* 315 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 317 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 318 */           pstmt.setDate(8, null);
/*     */         else {
/* 320 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 322 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 323 */           pstmt.setString(9, null);
/*     */         else {
/* 325 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 327 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 328 */           pstmt.setDate(10, null);
/*     */         else {
/* 330 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 332 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 333 */           pstmt.setString(11, null);
/*     */         else {
/* 335 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 337 */         pstmt.setInt(12, get(i).getInt1());
/* 338 */         pstmt.setInt(13, get(i).getInt2());
/* 339 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 340 */           pstmt.setString(14, null);
/*     */         else {
/* 342 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 344 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 345 */           pstmt.setString(15, null);
/*     */         else {
/* 347 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/* 349 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 350 */           pstmt.setString(16, null);
/*     */         else {
/* 352 */           pstmt.setString(16, get(i).getEdorNo());
/*     */         }
/* 354 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 355 */           pstmt.setString(17, null);
/*     */         else {
/* 357 */           pstmt.setString(17, get(i).getEdorType());
/*     */         }
/* 359 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 360 */           pstmt.setString(18, null);
/*     */         else {
/* 362 */           pstmt.setString(18, get(i).getEdorCase());
/*     */         }
/* 364 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 365 */           pstmt.setString(19, null);
/*     */         else {
/* 367 */           pstmt.setString(19, get(i).getOperator2());
/*     */         }
/* 369 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 370 */           pstmt.setDate(20, null);
/*     */         else {
/* 372 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 374 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 375 */           pstmt.setString(21, null);
/*     */         else {
/* 377 */           pstmt.setString(21, get(i).getMakeTime2());
/*     */         }
/* 379 */         pstmt.addBatch();
/*     */       }
/* 381 */       pstmt.executeBatch();
/* 382 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 385 */       ex.printStackTrace();
/* 386 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 387 */       CError tError = new CError();
/* 388 */       tError.moduleName = "MUserRoleMapBDBSet";
/* 389 */       tError.functionName = "insert()";
/* 390 */       tError.errorMessage = ex.toString();
/* 391 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 394 */         pstmt.close(); } catch (Exception e) {
/* 395 */         e.printStackTrace();
/*     */       }
/* 397 */       if (!this.mflag) {
/*     */         try {
/* 399 */           this.con.close(); } catch (Exception e) {
/* 400 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 403 */       return false;
/*     */     }
/*     */ 
/* 406 */     if (!this.mflag) {
/*     */       try {
/* 408 */         this.con.close(); } catch (Exception e) {
/* 409 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 412 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserRoleMapBDBSet
 * JD-Core Version:    0.6.0
 */