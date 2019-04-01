/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MRoleInfoBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MRoleInfoBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MRoleInfoBDBSet extends MRoleInfoBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MRoleInfoBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MRoleInfoB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MRoleInfoBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MRoleInfoB");
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
/*  49 */     tError.moduleName = "MRoleInfoBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleInfoB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MRoleInfoBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MRoleInfoB SET  ID = ? , RoleCode = ? , Name = ? , Parent = ? , Describe = ? , RoleState = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 138 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 143 */         if ((get(i).getParent() == null) || (get(i).getParent().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getParent());
/*     */         }
/* 148 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getDescribe());
/*     */         }
/* 153 */         if ((get(i).getRoleState() == null) || (get(i).getRoleState().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getRoleState());
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
/* 195 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getVarc3());
/*     */         }
/* 200 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getEdorNo());
/*     */         }
/* 205 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getEdorType());
/*     */         }
/* 210 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getEdorCase());
/*     */         }
/* 215 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 216 */           pstmt.setString(20, null);
/*     */         else {
/* 218 */           pstmt.setString(20, get(i).getOperator2());
/*     */         }
/* 220 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 221 */           pstmt.setDate(21, null);
/*     */         else {
/* 223 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 225 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 226 */           pstmt.setString(22, null);
/*     */         else {
/* 228 */           pstmt.setString(22, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 231 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 232 */           pstmt.setString(23, null);
/*     */         else {
/* 234 */           pstmt.setString(23, get(i).getEdorNo());
/*     */         }
/* 236 */         pstmt.addBatch();
/*     */       }
/* 238 */       pstmt.executeBatch();
/* 239 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 242 */       ex.printStackTrace();
/* 243 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 244 */       CError tError = new CError();
/* 245 */       tError.moduleName = "MRoleInfoBDBSet";
/* 246 */       tError.functionName = "update()";
/* 247 */       tError.errorMessage = ex.toString();
/* 248 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 251 */         pstmt.close(); } catch (Exception e) {
/* 252 */         e.printStackTrace();
/*     */       }
/* 254 */       if (!this.mflag) {
/*     */         try {
/* 256 */           this.con.close(); } catch (Exception e) {
/* 257 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 260 */       return false;
/*     */     }
/*     */ 
/* 263 */     if (!this.mflag) {
/*     */       try {
/* 265 */         this.con.close(); } catch (Exception e) {
/* 266 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 269 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 275 */     PreparedStatement pstmt = null;
/*     */ 
/* 277 */     if (!this.mflag) {
/* 278 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 283 */       int tCount = size();
/* 284 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleInfoB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 285 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 287 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 288 */           pstmt.setString(1, null);
/*     */         else {
/* 290 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 292 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 293 */           pstmt.setString(2, null);
/*     */         else {
/* 295 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 297 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 298 */           pstmt.setString(3, null);
/*     */         else {
/* 300 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 302 */         if ((get(i).getParent() == null) || (get(i).getParent().equals("null")))
/* 303 */           pstmt.setString(4, null);
/*     */         else {
/* 305 */           pstmt.setString(4, get(i).getParent());
/*     */         }
/* 307 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 308 */           pstmt.setString(5, null);
/*     */         else {
/* 310 */           pstmt.setString(5, get(i).getDescribe());
/*     */         }
/* 312 */         if ((get(i).getRoleState() == null) || (get(i).getRoleState().equals("null")))
/* 313 */           pstmt.setString(6, null);
/*     */         else {
/* 315 */           pstmt.setString(6, get(i).getRoleState());
/*     */         }
/* 317 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 318 */           pstmt.setString(7, null);
/*     */         else {
/* 320 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 322 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 323 */           pstmt.setDate(8, null);
/*     */         else {
/* 325 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 327 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 328 */           pstmt.setString(9, null);
/*     */         else {
/* 330 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 332 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 333 */           pstmt.setDate(10, null);
/*     */         else {
/* 335 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 337 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 338 */           pstmt.setString(11, null);
/*     */         else {
/* 340 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 342 */         pstmt.setInt(12, get(i).getInt1());
/* 343 */         pstmt.setInt(13, get(i).getInt2());
/* 344 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 345 */           pstmt.setString(14, null);
/*     */         else {
/* 347 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 349 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 350 */           pstmt.setString(15, null);
/*     */         else {
/* 352 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/* 354 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 355 */           pstmt.setString(16, null);
/*     */         else {
/* 357 */           pstmt.setString(16, get(i).getVarc3());
/*     */         }
/* 359 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 360 */           pstmt.setString(17, null);
/*     */         else {
/* 362 */           pstmt.setString(17, get(i).getEdorNo());
/*     */         }
/* 364 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 365 */           pstmt.setString(18, null);
/*     */         else {
/* 367 */           pstmt.setString(18, get(i).getEdorType());
/*     */         }
/* 369 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 370 */           pstmt.setString(19, null);
/*     */         else {
/* 372 */           pstmt.setString(19, get(i).getEdorCase());
/*     */         }
/* 374 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 375 */           pstmt.setString(20, null);
/*     */         else {
/* 377 */           pstmt.setString(20, get(i).getOperator2());
/*     */         }
/* 379 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 380 */           pstmt.setDate(21, null);
/*     */         else {
/* 382 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 384 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 385 */           pstmt.setString(22, null);
/*     */         else {
/* 387 */           pstmt.setString(22, get(i).getMakeTime2());
/*     */         }
/* 389 */         pstmt.addBatch();
/*     */       }
/* 391 */       pstmt.executeBatch();
/* 392 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 395 */       ex.printStackTrace();
/* 396 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 397 */       CError tError = new CError();
/* 398 */       tError.moduleName = "MRoleInfoBDBSet";
/* 399 */       tError.functionName = "insert()";
/* 400 */       tError.errorMessage = ex.toString();
/* 401 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 404 */         pstmt.close(); } catch (Exception e) {
/* 405 */         e.printStackTrace();
/*     */       }
/* 407 */       if (!this.mflag) {
/*     */         try {
/* 409 */           this.con.close(); } catch (Exception e) {
/* 410 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 413 */       return false;
/*     */     }
/*     */ 
/* 416 */     if (!this.mflag) {
/*     */       try {
/* 418 */         this.con.close(); } catch (Exception e) {
/* 419 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 422 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MRoleInfoBDBSet
 * JD-Core Version:    0.6.0
 */