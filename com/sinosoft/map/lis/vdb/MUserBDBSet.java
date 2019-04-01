/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserBDBSet extends MUserBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUserB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUserB");
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
/*  49 */     tError.moduleName = "MUserBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUserB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MUserBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUserB SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getUserCode());
/*     */         }
/* 133 */         if ((get(i).getUserName() == null) || (get(i).getUserName().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getUserName());
/*     */         }
/* 138 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 143 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 148 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getPassword());
/*     */         }
/* 153 */         if ((get(i).getPwdModifyDate() == null) || (get(i).getPwdModifyDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
/*     */         }
/* 158 */         if ((get(i).getUserDescription() == null) || (get(i).getUserDescription().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getUserDescription());
/*     */         }
/* 163 */         if ((get(i).getUserState() == null) || (get(i).getUserState().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getUserState());
/*     */         }
/* 168 */         if ((get(i).getSuperPopedomFlag() == null) || (get(i).getSuperPopedomFlag().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getSuperPopedomFlag());
/*     */         }
/* 173 */         if ((get(i).getValidStartDate() == null) || (get(i).getValidStartDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
/*     */         }
/* 178 */         if ((get(i).getValidEndDate() == null) || (get(i).getValidEndDate().equals("null")))
/* 179 */           pstmt.setDate(11, null);
/*     */         else {
/* 181 */           pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
/*     */         }
/* 183 */         if ((get(i).getStuffNo() == null) || (get(i).getStuffNo().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getStuffNo());
/*     */         }
/* 188 */         if ((get(i).getOfficePhone() == null) || (get(i).getOfficePhone().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getOfficePhone());
/*     */         }
/* 193 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getPhone());
/*     */         }
/* 198 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getEMail());
/*     */         }
/* 203 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 208 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 213 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 214 */           pstmt.setDate(18, null);
/*     */         else {
/* 216 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 218 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 223 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 224 */           pstmt.setDate(20, null);
/*     */         else {
/* 226 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 228 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/* 233 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 234 */           pstmt.setString(22, null);
/*     */         else {
/* 236 */           pstmt.setString(22, get(i).getEdorNo());
/*     */         }
/* 238 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 239 */           pstmt.setString(23, null);
/*     */         else {
/* 241 */           pstmt.setString(23, get(i).getEdorType());
/*     */         }
/* 243 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 244 */           pstmt.setString(24, null);
/*     */         else {
/* 246 */           pstmt.setString(24, get(i).getEdorCase());
/*     */         }
/* 248 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 249 */           pstmt.setString(25, null);
/*     */         else {
/* 251 */           pstmt.setString(25, get(i).getOperator2());
/*     */         }
/* 253 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 254 */           pstmt.setDate(26, null);
/*     */         else {
/* 256 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 258 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 259 */           pstmt.setString(27, null);
/*     */         else {
/* 261 */           pstmt.setString(27, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 264 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 265 */           pstmt.setString(28, null);
/*     */         else {
/* 267 */           pstmt.setString(28, get(i).getEdorNo());
/*     */         }
/* 269 */         pstmt.addBatch();
/*     */       }
/* 271 */       pstmt.executeBatch();
/* 272 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 275 */       ex.printStackTrace();
/* 276 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 277 */       CError tError = new CError();
/* 278 */       tError.moduleName = "MUserBDBSet";
/* 279 */       tError.functionName = "update()";
/* 280 */       tError.errorMessage = ex.toString();
/* 281 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 284 */         pstmt.close(); } catch (Exception e) {
/* 285 */         e.printStackTrace();
/*     */       }
/* 287 */       if (!this.mflag) {
/*     */         try {
/* 289 */           this.con.close(); } catch (Exception e) {
/* 290 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 293 */       return false;
/*     */     }
/*     */ 
/* 296 */     if (!this.mflag) {
/*     */       try {
/* 298 */         this.con.close(); } catch (Exception e) {
/* 299 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 308 */     PreparedStatement pstmt = null;
/*     */ 
/* 310 */     if (!this.mflag) {
/* 311 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 316 */       int tCount = size();
/* 317 */       pstmt = this.con.prepareStatement("INSERT INTO MUserB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 318 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 320 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 321 */           pstmt.setString(1, null);
/*     */         else {
/* 323 */           pstmt.setString(1, get(i).getUserCode());
/*     */         }
/* 325 */         if ((get(i).getUserName() == null) || (get(i).getUserName().equals("null")))
/* 326 */           pstmt.setString(2, null);
/*     */         else {
/* 328 */           pstmt.setString(2, get(i).getUserName());
/*     */         }
/* 330 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 331 */           pstmt.setString(3, null);
/*     */         else {
/* 333 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 335 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 336 */           pstmt.setString(4, null);
/*     */         else {
/* 338 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 340 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 341 */           pstmt.setString(5, null);
/*     */         else {
/* 343 */           pstmt.setString(5, get(i).getPassword());
/*     */         }
/* 345 */         if ((get(i).getPwdModifyDate() == null) || (get(i).getPwdModifyDate().equals("null")))
/* 346 */           pstmt.setDate(6, null);
/*     */         else {
/* 348 */           pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
/*     */         }
/* 350 */         if ((get(i).getUserDescription() == null) || (get(i).getUserDescription().equals("null")))
/* 351 */           pstmt.setString(7, null);
/*     */         else {
/* 353 */           pstmt.setString(7, get(i).getUserDescription());
/*     */         }
/* 355 */         if ((get(i).getUserState() == null) || (get(i).getUserState().equals("null")))
/* 356 */           pstmt.setString(8, null);
/*     */         else {
/* 358 */           pstmt.setString(8, get(i).getUserState());
/*     */         }
/* 360 */         if ((get(i).getSuperPopedomFlag() == null) || (get(i).getSuperPopedomFlag().equals("null")))
/* 361 */           pstmt.setString(9, null);
/*     */         else {
/* 363 */           pstmt.setString(9, get(i).getSuperPopedomFlag());
/*     */         }
/* 365 */         if ((get(i).getValidStartDate() == null) || (get(i).getValidStartDate().equals("null")))
/* 366 */           pstmt.setDate(10, null);
/*     */         else {
/* 368 */           pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
/*     */         }
/* 370 */         if ((get(i).getValidEndDate() == null) || (get(i).getValidEndDate().equals("null")))
/* 371 */           pstmt.setDate(11, null);
/*     */         else {
/* 373 */           pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
/*     */         }
/* 375 */         if ((get(i).getStuffNo() == null) || (get(i).getStuffNo().equals("null")))
/* 376 */           pstmt.setString(12, null);
/*     */         else {
/* 378 */           pstmt.setString(12, get(i).getStuffNo());
/*     */         }
/* 380 */         if ((get(i).getOfficePhone() == null) || (get(i).getOfficePhone().equals("null")))
/* 381 */           pstmt.setString(13, null);
/*     */         else {
/* 383 */           pstmt.setString(13, get(i).getOfficePhone());
/*     */         }
/* 385 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 386 */           pstmt.setString(14, null);
/*     */         else {
/* 388 */           pstmt.setString(14, get(i).getPhone());
/*     */         }
/* 390 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 391 */           pstmt.setString(15, null);
/*     */         else {
/* 393 */           pstmt.setString(15, get(i).getEMail());
/*     */         }
/* 395 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 396 */           pstmt.setString(16, null);
/*     */         else {
/* 398 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 400 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 401 */           pstmt.setString(17, null);
/*     */         else {
/* 403 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 405 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 406 */           pstmt.setDate(18, null);
/*     */         else {
/* 408 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 410 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 411 */           pstmt.setString(19, null);
/*     */         else {
/* 413 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 415 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 416 */           pstmt.setDate(20, null);
/*     */         else {
/* 418 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 420 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 421 */           pstmt.setString(21, null);
/*     */         else {
/* 423 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/* 425 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 426 */           pstmt.setString(22, null);
/*     */         else {
/* 428 */           pstmt.setString(22, get(i).getEdorNo());
/*     */         }
/* 430 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 431 */           pstmt.setString(23, null);
/*     */         else {
/* 433 */           pstmt.setString(23, get(i).getEdorType());
/*     */         }
/* 435 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 436 */           pstmt.setString(24, null);
/*     */         else {
/* 438 */           pstmt.setString(24, get(i).getEdorCase());
/*     */         }
/* 440 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 441 */           pstmt.setString(25, null);
/*     */         else {
/* 443 */           pstmt.setString(25, get(i).getOperator2());
/*     */         }
/* 445 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 446 */           pstmt.setDate(26, null);
/*     */         else {
/* 448 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 450 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 451 */           pstmt.setString(27, null);
/*     */         else {
/* 453 */           pstmt.setString(27, get(i).getMakeTime2());
/*     */         }
/* 455 */         pstmt.addBatch();
/*     */       }
/* 457 */       pstmt.executeBatch();
/* 458 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 461 */       ex.printStackTrace();
/* 462 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 463 */       CError tError = new CError();
/* 464 */       tError.moduleName = "MUserBDBSet";
/* 465 */       tError.functionName = "insert()";
/* 466 */       tError.errorMessage = ex.toString();
/* 467 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 470 */         pstmt.close(); } catch (Exception e) {
/* 471 */         e.printStackTrace();
/*     */       }
/* 473 */       if (!this.mflag) {
/*     */         try {
/* 475 */           this.con.close(); } catch (Exception e) {
/* 476 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 479 */       return false;
/*     */     }
/*     */ 
/* 482 */     if (!this.mflag) {
/*     */       try {
/* 484 */         this.con.close(); } catch (Exception e) {
/* 485 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 488 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserBDBSet
 * JD-Core Version:    0.6.0
 */