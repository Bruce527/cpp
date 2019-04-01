/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHonorCheckSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHonorCheckSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHonorCheckDBSet extends MHonorCheckSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHonorCheckDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHonorCheck");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHonorCheckDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHonorCheck");
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
/*  49 */     tError.moduleName = "MHonorCheckDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHonorCheck WHERE  CheckID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getCheckID());
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
/*  86 */       tError.moduleName = "MHonorCheckDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHonorCheck SET  CheckID = ? , DataType = ? , StatYear = ? , ManageCom = ? , BranchType = ? , StatBatch = ? , StartDate = ? , EndDate = ? , CheckState = ? , InputState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CheckID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getCheckID());
/*     */         }
/* 133 */         if ((get(i).getDataType() == null) || (get(i).getDataType().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getDataType());
/*     */         }
/* 138 */         if ((get(i).getStatYear() == null) || (get(i).getStatYear().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getStatYear());
/*     */         }
/* 143 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getManageCom());
/*     */         }
/* 148 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getBranchType());
/*     */         }
/* 153 */         if ((get(i).getStatBatch() == null) || (get(i).getStatBatch().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getStatBatch());
/*     */         }
/* 158 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 159 */           pstmt.setDate(7, null);
/*     */         else {
/* 161 */           pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 163 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 168 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getCheckState());
/*     */         }
/* 173 */         if ((get(i).getInputState() == null) || (get(i).getInputState().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getInputState());
/*     */         }
/* 178 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getCheckOperator());
/*     */         }
/* 183 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getCheckReason());
/*     */         }
/* 188 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 189 */           pstmt.setDate(13, null);
/*     */         else {
/* 191 */           pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 193 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getCheckTime());
/*     */         }
/* 198 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getModifyOperator());
/*     */         }
/* 203 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 208 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 209 */           pstmt.setDate(17, null);
/*     */         else {
/* 211 */           pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 213 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 218 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 219 */           pstmt.setDate(19, null);
/*     */         else {
/* 221 */           pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 223 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 229 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/* 230 */           pstmt.setString(21, null);
/*     */         else {
/* 232 */           pstmt.setString(21, get(i).getCheckID());
/*     */         }
/* 234 */         pstmt.addBatch();
/*     */       }
/* 236 */       pstmt.executeBatch();
/* 237 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 240 */       ex.printStackTrace();
/* 241 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 242 */       CError tError = new CError();
/* 243 */       tError.moduleName = "MHonorCheckDBSet";
/* 244 */       tError.functionName = "update()";
/* 245 */       tError.errorMessage = ex.toString();
/* 246 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 249 */         pstmt.close(); } catch (Exception e) {
/* 250 */         e.printStackTrace();
/*     */       }
/* 252 */       if (!this.mflag) {
/*     */         try {
/* 254 */           this.con.close(); } catch (Exception e) {
/* 255 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 258 */       return false;
/*     */     }
/*     */ 
/* 261 */     if (!this.mflag) {
/*     */       try {
/* 263 */         this.con.close(); } catch (Exception e) {
/* 264 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 273 */     PreparedStatement pstmt = null;
/*     */ 
/* 275 */     if (!this.mflag) {
/* 276 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 281 */       int tCount = size();
/* 282 */       pstmt = this.con.prepareStatement("INSERT INTO MHonorCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 283 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 285 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/* 286 */           pstmt.setString(1, null);
/*     */         else {
/* 288 */           pstmt.setString(1, get(i).getCheckID());
/*     */         }
/* 290 */         if ((get(i).getDataType() == null) || (get(i).getDataType().equals("null")))
/* 291 */           pstmt.setString(2, null);
/*     */         else {
/* 293 */           pstmt.setString(2, get(i).getDataType());
/*     */         }
/* 295 */         if ((get(i).getStatYear() == null) || (get(i).getStatYear().equals("null")))
/* 296 */           pstmt.setString(3, null);
/*     */         else {
/* 298 */           pstmt.setString(3, get(i).getStatYear());
/*     */         }
/* 300 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 301 */           pstmt.setString(4, null);
/*     */         else {
/* 303 */           pstmt.setString(4, get(i).getManageCom());
/*     */         }
/* 305 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 306 */           pstmt.setString(5, null);
/*     */         else {
/* 308 */           pstmt.setString(5, get(i).getBranchType());
/*     */         }
/* 310 */         if ((get(i).getStatBatch() == null) || (get(i).getStatBatch().equals("null")))
/* 311 */           pstmt.setString(6, null);
/*     */         else {
/* 313 */           pstmt.setString(6, get(i).getStatBatch());
/*     */         }
/* 315 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 316 */           pstmt.setDate(7, null);
/*     */         else {
/* 318 */           pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 320 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 321 */           pstmt.setDate(8, null);
/*     */         else {
/* 323 */           pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 325 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 326 */           pstmt.setString(9, null);
/*     */         else {
/* 328 */           pstmt.setString(9, get(i).getCheckState());
/*     */         }
/* 330 */         if ((get(i).getInputState() == null) || (get(i).getInputState().equals("null")))
/* 331 */           pstmt.setString(10, null);
/*     */         else {
/* 333 */           pstmt.setString(10, get(i).getInputState());
/*     */         }
/* 335 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 336 */           pstmt.setString(11, null);
/*     */         else {
/* 338 */           pstmt.setString(11, get(i).getCheckOperator());
/*     */         }
/* 340 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 341 */           pstmt.setString(12, null);
/*     */         else {
/* 343 */           pstmt.setString(12, get(i).getCheckReason());
/*     */         }
/* 345 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 346 */           pstmt.setDate(13, null);
/*     */         else {
/* 348 */           pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 350 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 351 */           pstmt.setString(14, null);
/*     */         else {
/* 353 */           pstmt.setString(14, get(i).getCheckTime());
/*     */         }
/* 355 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 356 */           pstmt.setString(15, null);
/*     */         else {
/* 358 */           pstmt.setString(15, get(i).getModifyOperator());
/*     */         }
/* 360 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 361 */           pstmt.setString(16, null);
/*     */         else {
/* 363 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 365 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 366 */           pstmt.setDate(17, null);
/*     */         else {
/* 368 */           pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 370 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 371 */           pstmt.setString(18, null);
/*     */         else {
/* 373 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 375 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 376 */           pstmt.setDate(19, null);
/*     */         else {
/* 378 */           pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 380 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 381 */           pstmt.setString(20, null);
/*     */         else {
/* 383 */           pstmt.setString(20, get(i).getModifyTime());
/*     */         }
/* 385 */         pstmt.addBatch();
/*     */       }
/* 387 */       pstmt.executeBatch();
/* 388 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 391 */       ex.printStackTrace();
/* 392 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 393 */       CError tError = new CError();
/* 394 */       tError.moduleName = "MHonorCheckDBSet";
/* 395 */       tError.functionName = "insert()";
/* 396 */       tError.errorMessage = ex.toString();
/* 397 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 400 */         pstmt.close(); } catch (Exception e) {
/* 401 */         e.printStackTrace();
/*     */       }
/* 403 */       if (!this.mflag) {
/*     */         try {
/* 405 */           this.con.close(); } catch (Exception e) {
/* 406 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 409 */       return false;
/*     */     }
/*     */ 
/* 412 */     if (!this.mflag) {
/*     */       try {
/* 414 */         this.con.close(); } catch (Exception e) {
/* 415 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 418 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHonorCheckDBSet
 * JD-Core Version:    0.6.0
 */