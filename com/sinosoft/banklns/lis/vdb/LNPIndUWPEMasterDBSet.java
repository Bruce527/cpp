/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPIndUWPEMasterSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPIndUWPEMasterSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPIndUWPEMasterDBSet extends LNPIndUWPEMasterSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPIndUWPEMasterDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPIndUWPEMaster");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPIndUWPEMasterDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPIndUWPEMaster");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPIndUWPEMasterDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPIndUWPEMaster WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getInsuredId());
/*     */         }
/*  83 */         if ((get(i).getUWPENo() == null) || (get(i).getUWPENo().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getUWPENo());
/*     */         }
/*  88 */         pstmt.addBatch();
/*     */       }
/*  90 */       pstmt.executeBatch();
/*  91 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  94 */       ex.printStackTrace();
/*  95 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  96 */       CError tError = new CError();
/*  97 */       tError.moduleName = "LNPIndUWPEMasterDBSet";
/*  98 */       tError.functionName = "delete()";
/*  99 */       tError.errorMessage = ex.toString();
/* 100 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 103 */         pstmt.close(); } catch (Exception e) {
/* 104 */         e.printStackTrace();
/*     */       }
/* 106 */       if (!this.mflag) {
/*     */         try {
/* 108 */           this.con.close(); } catch (Exception e) {
/* 109 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 112 */       return false;
/*     */     }
/*     */ 
/* 115 */     if (!this.mflag) {
/*     */       try {
/* 117 */         this.con.close(); } catch (Exception e) {
/* 118 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 127 */     PreparedStatement pstmt = null;
/*     */ 
/* 129 */     if (!this.mflag) {
/* 130 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 135 */       int tCount = size();
/* 136 */       pstmt = this.con.prepareStatement("UPDATE LNPIndUWPEMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UMDate = ? , UMTime = ? , InsuredId = ? , UWPENo = ? , PEName = ? , PECode = ? , PEStatus = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
/* 137 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 139 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 140 */           pstmt.setString(1, null);
/*     */         else {
/* 142 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 144 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 145 */           pstmt.setString(2, null);
/*     */         else {
/* 147 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 149 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 150 */           pstmt.setString(3, null);
/*     */         else {
/* 152 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 154 */         pstmt.setInt(4, get(i).getUWNo());
/* 155 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 156 */           pstmt.setString(5, null);
/*     */         else {
/* 158 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 160 */         if ((get(i).getUMDate() == null) || (get(i).getUMDate().equals("null")))
/* 161 */           pstmt.setDate(6, null);
/*     */         else {
/* 163 */           pstmt.setDate(6, Date.valueOf(get(i).getUMDate()));
/*     */         }
/* 165 */         if ((get(i).getUMTime() == null) || (get(i).getUMTime().equals("null")))
/* 166 */           pstmt.setString(7, null);
/*     */         else {
/* 168 */           pstmt.setString(7, get(i).getUMTime());
/*     */         }
/* 170 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 171 */           pstmt.setString(8, null);
/*     */         else {
/* 173 */           pstmt.setString(8, get(i).getInsuredId());
/*     */         }
/* 175 */         if ((get(i).getUWPENo() == null) || (get(i).getUWPENo().equals("null")))
/* 176 */           pstmt.setString(9, null);
/*     */         else {
/* 178 */           pstmt.setString(9, get(i).getUWPENo());
/*     */         }
/* 180 */         if ((get(i).getPEName() == null) || (get(i).getPEName().equals("null")))
/* 181 */           pstmt.setString(10, null);
/*     */         else {
/* 183 */           pstmt.setString(10, get(i).getPEName());
/*     */         }
/* 185 */         if ((get(i).getPECode() == null) || (get(i).getPECode().equals("null")))
/* 186 */           pstmt.setString(11, null);
/*     */         else {
/* 188 */           pstmt.setString(11, get(i).getPECode());
/*     */         }
/* 190 */         if ((get(i).getPEStatus() == null) || (get(i).getPEStatus().equals("null")))
/* 191 */           pstmt.setString(12, null);
/*     */         else {
/* 193 */           pstmt.setString(12, get(i).getPEStatus());
/*     */         }
/* 195 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 196 */           pstmt.setString(13, null);
/*     */         else {
/* 198 */           pstmt.setString(13, get(i).getOperator());
/*     */         }
/* 200 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 201 */           pstmt.setDate(14, null);
/*     */         else {
/* 203 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 205 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 206 */           pstmt.setString(15, null);
/*     */         else {
/* 208 */           pstmt.setString(15, get(i).getMakeTime());
/*     */         }
/* 210 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 211 */           pstmt.setDate(16, null);
/*     */         else {
/* 213 */           pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 215 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 216 */           pstmt.setString(17, null);
/*     */         else {
/* 218 */           pstmt.setString(17, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 221 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 222 */           pstmt.setString(18, null);
/*     */         else {
/* 224 */           pstmt.setString(18, get(i).getContNo());
/*     */         }
/* 226 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 227 */           pstmt.setString(19, null);
/*     */         else {
/* 229 */           pstmt.setString(19, get(i).getInsuredId());
/*     */         }
/* 231 */         if ((get(i).getUWPENo() == null) || (get(i).getUWPENo().equals("null")))
/* 232 */           pstmt.setString(20, null);
/*     */         else {
/* 234 */           pstmt.setString(20, get(i).getUWPENo());
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
/* 245 */       tError.moduleName = "LNPIndUWPEMasterDBSet";
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
/* 284 */       pstmt = this.con.prepareStatement("INSERT INTO LNPIndUWPEMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 285 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 287 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 288 */           pstmt.setString(1, null);
/*     */         else {
/* 290 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 292 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 293 */           pstmt.setString(2, null);
/*     */         else {
/* 295 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 297 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 298 */           pstmt.setString(3, null);
/*     */         else {
/* 300 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 302 */         pstmt.setInt(4, get(i).getUWNo());
/* 303 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 304 */           pstmt.setString(5, null);
/*     */         else {
/* 306 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 308 */         if ((get(i).getUMDate() == null) || (get(i).getUMDate().equals("null")))
/* 309 */           pstmt.setDate(6, null);
/*     */         else {
/* 311 */           pstmt.setDate(6, Date.valueOf(get(i).getUMDate()));
/*     */         }
/* 313 */         if ((get(i).getUMTime() == null) || (get(i).getUMTime().equals("null")))
/* 314 */           pstmt.setString(7, null);
/*     */         else {
/* 316 */           pstmt.setString(7, get(i).getUMTime());
/*     */         }
/* 318 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 319 */           pstmt.setString(8, null);
/*     */         else {
/* 321 */           pstmt.setString(8, get(i).getInsuredId());
/*     */         }
/* 323 */         if ((get(i).getUWPENo() == null) || (get(i).getUWPENo().equals("null")))
/* 324 */           pstmt.setString(9, null);
/*     */         else {
/* 326 */           pstmt.setString(9, get(i).getUWPENo());
/*     */         }
/* 328 */         if ((get(i).getPEName() == null) || (get(i).getPEName().equals("null")))
/* 329 */           pstmt.setString(10, null);
/*     */         else {
/* 331 */           pstmt.setString(10, get(i).getPEName());
/*     */         }
/* 333 */         if ((get(i).getPECode() == null) || (get(i).getPECode().equals("null")))
/* 334 */           pstmt.setString(11, null);
/*     */         else {
/* 336 */           pstmt.setString(11, get(i).getPECode());
/*     */         }
/* 338 */         if ((get(i).getPEStatus() == null) || (get(i).getPEStatus().equals("null")))
/* 339 */           pstmt.setString(12, null);
/*     */         else {
/* 341 */           pstmt.setString(12, get(i).getPEStatus());
/*     */         }
/* 343 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 344 */           pstmt.setString(13, null);
/*     */         else {
/* 346 */           pstmt.setString(13, get(i).getOperator());
/*     */         }
/* 348 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 349 */           pstmt.setDate(14, null);
/*     */         else {
/* 351 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 353 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 354 */           pstmt.setString(15, null);
/*     */         else {
/* 356 */           pstmt.setString(15, get(i).getMakeTime());
/*     */         }
/* 358 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 359 */           pstmt.setDate(16, null);
/*     */         else {
/* 361 */           pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 363 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 364 */           pstmt.setString(17, null);
/*     */         else {
/* 366 */           pstmt.setString(17, get(i).getModifyTime());
/*     */         }
/* 368 */         pstmt.addBatch();
/*     */       }
/* 370 */       pstmt.executeBatch();
/* 371 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 374 */       ex.printStackTrace();
/* 375 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 376 */       CError tError = new CError();
/* 377 */       tError.moduleName = "LNPIndUWPEMasterDBSet";
/* 378 */       tError.functionName = "insert()";
/* 379 */       tError.errorMessage = ex.toString();
/* 380 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 383 */         pstmt.close(); } catch (Exception e) {
/* 384 */         e.printStackTrace();
/*     */       }
/* 386 */       if (!this.mflag) {
/*     */         try {
/* 388 */           this.con.close(); } catch (Exception e) {
/* 389 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 392 */       return false;
/*     */     }
/*     */ 
/* 395 */     if (!this.mflag) {
/*     */       try {
/* 397 */         this.con.close(); } catch (Exception e) {
/* 398 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 401 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPIndUWPEMasterDBSet
 * JD-Core Version:    0.6.0
 */