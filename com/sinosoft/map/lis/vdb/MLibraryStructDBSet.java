/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLibraryStructSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLibraryStructSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLibraryStructDBSet extends MLibraryStructSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MLibraryStructDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MLibraryStruct");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLibraryStructDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MLibraryStruct");
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
/*  49 */     tError.moduleName = "MLibraryStructDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryStruct WHERE  NodeID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getNodeID());
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
/*  86 */       tError.moduleName = "MLibraryStructDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MLibraryStruct SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNodeID());
/*     */         }
/* 133 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 138 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getParentID());
/*     */         }
/* 143 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getDiscription());
/*     */         }
/* 148 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 153 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 158 */         pstmt.setInt(7, get(i).getPosition());
/* 159 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getOperation());
/*     */         }
/* 164 */         if ((get(i).getDirFlag() == null) || (get(i).getDirFlag().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getDirFlag());
/*     */         }
/* 169 */         if ((get(i).getFileFlag() == null) || (get(i).getFileFlag().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getFileFlag());
/*     */         }
/* 174 */         pstmt.setInt(11, get(i).getChildDirNum());
/* 175 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 176 */           pstmt.setString(12, null);
/*     */         else {
/* 178 */           pstmt.setString(12, get(i).getCheckState());
/*     */         }
/* 180 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 181 */           pstmt.setString(13, null);
/*     */         else {
/* 183 */           pstmt.setString(13, get(i).getCheckOperator());
/*     */         }
/* 185 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getCheckReason());
/*     */         }
/* 190 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 191 */           pstmt.setDate(15, null);
/*     */         else {
/* 193 */           pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 195 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getCheckTime());
/*     */         }
/* 200 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 205 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 210 */         pstmt.setInt(19, get(i).getIF01());
/* 211 */         pstmt.setDouble(20, get(i).getDF02());
/* 212 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 213 */           pstmt.setDate(21, null);
/*     */         else {
/* 215 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 217 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 218 */           pstmt.setString(22, null);
/*     */         else {
/* 220 */           pstmt.setString(22, get(i).getModifyOperator());
/*     */         }
/* 222 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 223 */           pstmt.setString(23, null);
/*     */         else {
/* 225 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 227 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 228 */           pstmt.setDate(24, null);
/*     */         else {
/* 230 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 232 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 233 */           pstmt.setString(25, null);
/*     */         else {
/* 235 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 237 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 238 */           pstmt.setDate(26, null);
/*     */         else {
/* 240 */           pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 242 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 243 */           pstmt.setString(27, null);
/*     */         else {
/* 245 */           pstmt.setString(27, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 248 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 249 */           pstmt.setString(28, null);
/*     */         else {
/* 251 */           pstmt.setString(28, get(i).getNodeID());
/*     */         }
/* 253 */         pstmt.addBatch();
/*     */       }
/* 255 */       pstmt.executeBatch();
/* 256 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 259 */       ex.printStackTrace();
/* 260 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 261 */       CError tError = new CError();
/* 262 */       tError.moduleName = "MLibraryStructDBSet";
/* 263 */       tError.functionName = "update()";
/* 264 */       tError.errorMessage = ex.toString();
/* 265 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 268 */         pstmt.close(); } catch (Exception e) {
/* 269 */         e.printStackTrace();
/*     */       }
/* 271 */       if (!this.mflag) {
/*     */         try {
/* 273 */           this.con.close(); } catch (Exception e) {
/* 274 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 277 */       return false;
/*     */     }
/*     */ 
/* 280 */     if (!this.mflag) {
/*     */       try {
/* 282 */         this.con.close(); } catch (Exception e) {
/* 283 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 286 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 292 */     PreparedStatement pstmt = null;
/*     */ 
/* 294 */     if (!this.mflag) {
/* 295 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 300 */       int tCount = size();
/* 301 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryStruct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 302 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 304 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 305 */           pstmt.setString(1, null);
/*     */         else {
/* 307 */           pstmt.setString(1, get(i).getNodeID());
/*     */         }
/* 309 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 310 */           pstmt.setString(2, null);
/*     */         else {
/* 312 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 314 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 315 */           pstmt.setString(3, null);
/*     */         else {
/* 317 */           pstmt.setString(3, get(i).getParentID());
/*     */         }
/* 319 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 320 */           pstmt.setString(4, null);
/*     */         else {
/* 322 */           pstmt.setString(4, get(i).getDiscription());
/*     */         }
/* 324 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 325 */           pstmt.setString(5, null);
/*     */         else {
/* 327 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 329 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 330 */           pstmt.setString(6, null);
/*     */         else {
/* 332 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 334 */         pstmt.setInt(7, get(i).getPosition());
/* 335 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 336 */           pstmt.setString(8, null);
/*     */         else {
/* 338 */           pstmt.setString(8, get(i).getOperation());
/*     */         }
/* 340 */         if ((get(i).getDirFlag() == null) || (get(i).getDirFlag().equals("null")))
/* 341 */           pstmt.setString(9, null);
/*     */         else {
/* 343 */           pstmt.setString(9, get(i).getDirFlag());
/*     */         }
/* 345 */         if ((get(i).getFileFlag() == null) || (get(i).getFileFlag().equals("null")))
/* 346 */           pstmt.setString(10, null);
/*     */         else {
/* 348 */           pstmt.setString(10, get(i).getFileFlag());
/*     */         }
/* 350 */         pstmt.setInt(11, get(i).getChildDirNum());
/* 351 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 352 */           pstmt.setString(12, null);
/*     */         else {
/* 354 */           pstmt.setString(12, get(i).getCheckState());
/*     */         }
/* 356 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 357 */           pstmt.setString(13, null);
/*     */         else {
/* 359 */           pstmt.setString(13, get(i).getCheckOperator());
/*     */         }
/* 361 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 362 */           pstmt.setString(14, null);
/*     */         else {
/* 364 */           pstmt.setString(14, get(i).getCheckReason());
/*     */         }
/* 366 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 367 */           pstmt.setDate(15, null);
/*     */         else {
/* 369 */           pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 371 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 372 */           pstmt.setString(16, null);
/*     */         else {
/* 374 */           pstmt.setString(16, get(i).getCheckTime());
/*     */         }
/* 376 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 377 */           pstmt.setString(17, null);
/*     */         else {
/* 379 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 381 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 382 */           pstmt.setString(18, null);
/*     */         else {
/* 384 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 386 */         pstmt.setInt(19, get(i).getIF01());
/* 387 */         pstmt.setDouble(20, get(i).getDF02());
/* 388 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 389 */           pstmt.setDate(21, null);
/*     */         else {
/* 391 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 393 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 394 */           pstmt.setString(22, null);
/*     */         else {
/* 396 */           pstmt.setString(22, get(i).getModifyOperator());
/*     */         }
/* 398 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 399 */           pstmt.setString(23, null);
/*     */         else {
/* 401 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 403 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 404 */           pstmt.setDate(24, null);
/*     */         else {
/* 406 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 408 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 409 */           pstmt.setString(25, null);
/*     */         else {
/* 411 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 413 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 414 */           pstmt.setDate(26, null);
/*     */         else {
/* 416 */           pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 418 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 419 */           pstmt.setString(27, null);
/*     */         else {
/* 421 */           pstmt.setString(27, get(i).getModifyTime());
/*     */         }
/* 423 */         pstmt.addBatch();
/*     */       }
/* 425 */       pstmt.executeBatch();
/* 426 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 429 */       ex.printStackTrace();
/* 430 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 431 */       CError tError = new CError();
/* 432 */       tError.moduleName = "MLibraryStructDBSet";
/* 433 */       tError.functionName = "insert()";
/* 434 */       tError.errorMessage = ex.toString();
/* 435 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 438 */         pstmt.close(); } catch (Exception e) {
/* 439 */         e.printStackTrace();
/*     */       }
/* 441 */       if (!this.mflag) {
/*     */         try {
/* 443 */           this.con.close(); } catch (Exception e) {
/* 444 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 447 */       return false;
/*     */     }
/*     */ 
/* 450 */     if (!this.mflag) {
/*     */       try {
/* 452 */         this.con.close(); } catch (Exception e) {
/* 453 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 456 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLibraryStructDBSet
 * JD-Core Version:    0.6.0
 */