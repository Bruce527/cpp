/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAgentImpResultDBSet extends LNPAgentImpResultSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAgentImpResultDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAgentImpResult");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAgentImpResultDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAgentImpResult");
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
/*  50 */     tError.moduleName = "LNPAgentImpResultDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentImpResult WHERE  ResultId = ? AND Grouporder = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/*  78 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getGrouporder());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPAgentImpResultDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 139 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getGrpContNo());
/*     */         }
/* 144 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getContNo());
/*     */         }
/* 149 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getProposalContNo());
/*     */         }
/* 154 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getImpartId());
/*     */         }
/* 159 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getGrouporder());
/*     */         }
/* 164 */         if ((get(i).getQID01() == null) || (get(i).getQID01().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getQID01());
/*     */         }
/* 169 */         if ((get(i).getA01() == null) || (get(i).getA01().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getA01());
/*     */         }
/* 174 */         if ((get(i).getQID02() == null) || (get(i).getQID02().equals("null")))
/* 175 */           pstmt.setString(9, null);
/*     */         else {
/* 177 */           pstmt.setString(9, get(i).getQID02());
/*     */         }
/* 179 */         if ((get(i).getA02() == null) || (get(i).getA02().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getA02());
/*     */         }
/* 184 */         if ((get(i).getQID03() == null) || (get(i).getQID03().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getQID03());
/*     */         }
/* 189 */         if ((get(i).getA03() == null) || (get(i).getA03().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getA03());
/*     */         }
/* 194 */         if ((get(i).getQID04() == null) || (get(i).getQID04().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getQID04());
/*     */         }
/* 199 */         if ((get(i).getA04() == null) || (get(i).getA04().equals("null")))
/* 200 */           pstmt.setString(14, null);
/*     */         else {
/* 202 */           pstmt.setString(14, get(i).getA04());
/*     */         }
/* 204 */         if ((get(i).getQID05() == null) || (get(i).getQID05().equals("null")))
/* 205 */           pstmt.setString(15, null);
/*     */         else {
/* 207 */           pstmt.setString(15, get(i).getQID05());
/*     */         }
/* 209 */         if ((get(i).getA05() == null) || (get(i).getA05().equals("null")))
/* 210 */           pstmt.setString(16, null);
/*     */         else {
/* 212 */           pstmt.setString(16, get(i).getA05());
/*     */         }
/* 214 */         if ((get(i).getQID06() == null) || (get(i).getQID06().equals("null")))
/* 215 */           pstmt.setString(17, null);
/*     */         else {
/* 217 */           pstmt.setString(17, get(i).getQID06());
/*     */         }
/* 219 */         if ((get(i).getA06() == null) || (get(i).getA06().equals("null")))
/* 220 */           pstmt.setString(18, null);
/*     */         else {
/* 222 */           pstmt.setString(18, get(i).getA06());
/*     */         }
/* 224 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 225 */           pstmt.setString(19, null);
/*     */         else {
/* 227 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 229 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 230 */           pstmt.setString(20, null);
/*     */         else {
/* 232 */           pstmt.setString(20, get(i).getManageCom());
/*     */         }
/* 234 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 235 */           pstmt.setDate(21, null);
/*     */         else {
/* 237 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 239 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 240 */           pstmt.setString(22, null);
/*     */         else {
/* 242 */           pstmt.setString(22, get(i).getMakeTime());
/*     */         }
/* 244 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 245 */           pstmt.setDate(23, null);
/*     */         else {
/* 247 */           pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 249 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 250 */           pstmt.setString(24, null);
/*     */         else {
/* 252 */           pstmt.setString(24, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 255 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 256 */           pstmt.setString(25, null);
/*     */         else {
/* 258 */           pstmt.setString(25, get(i).getResultId());
/*     */         }
/* 260 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 261 */           pstmt.setString(26, null);
/*     */         else {
/* 263 */           pstmt.setString(26, get(i).getGrouporder());
/*     */         }
/* 265 */         pstmt.addBatch();
/*     */       }
/* 267 */       pstmt.executeBatch();
/* 268 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 271 */       ex.printStackTrace();
/* 272 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 273 */       CError tError = new CError();
/* 274 */       tError.moduleName = "LNPAgentImpResultDBSet";
/* 275 */       tError.functionName = "update()";
/* 276 */       tError.errorMessage = ex.toString();
/* 277 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 280 */         pstmt.close(); } catch (Exception e) {
/* 281 */         e.printStackTrace();
/*     */       }
/* 283 */       if (!this.mflag) {
/*     */         try {
/* 285 */           this.con.close(); } catch (Exception e) {
/* 286 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 289 */       return false;
/*     */     }
/*     */ 
/* 292 */     if (!this.mflag) {
/*     */       try {
/* 294 */         this.con.close(); } catch (Exception e) {
/* 295 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 304 */     PreparedStatement pstmt = null;
/*     */ 
/* 306 */     if (!this.mflag) {
/* 307 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 312 */       int tCount = size();
/* 313 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 314 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 316 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 317 */           pstmt.setString(1, null);
/*     */         else {
/* 319 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 321 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 322 */           pstmt.setString(2, null);
/*     */         else {
/* 324 */           pstmt.setString(2, get(i).getGrpContNo());
/*     */         }
/* 326 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 327 */           pstmt.setString(3, null);
/*     */         else {
/* 329 */           pstmt.setString(3, get(i).getContNo());
/*     */         }
/* 331 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 332 */           pstmt.setString(4, null);
/*     */         else {
/* 334 */           pstmt.setString(4, get(i).getProposalContNo());
/*     */         }
/* 336 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 337 */           pstmt.setString(5, null);
/*     */         else {
/* 339 */           pstmt.setString(5, get(i).getImpartId());
/*     */         }
/* 341 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 342 */           pstmt.setString(6, null);
/*     */         else {
/* 344 */           pstmt.setString(6, get(i).getGrouporder());
/*     */         }
/* 346 */         if ((get(i).getQID01() == null) || (get(i).getQID01().equals("null")))
/* 347 */           pstmt.setString(7, null);
/*     */         else {
/* 349 */           pstmt.setString(7, get(i).getQID01());
/*     */         }
/* 351 */         if ((get(i).getA01() == null) || (get(i).getA01().equals("null")))
/* 352 */           pstmt.setString(8, null);
/*     */         else {
/* 354 */           pstmt.setString(8, get(i).getA01());
/*     */         }
/* 356 */         if ((get(i).getQID02() == null) || (get(i).getQID02().equals("null")))
/* 357 */           pstmt.setString(9, null);
/*     */         else {
/* 359 */           pstmt.setString(9, get(i).getQID02());
/*     */         }
/* 361 */         if ((get(i).getA02() == null) || (get(i).getA02().equals("null")))
/* 362 */           pstmt.setString(10, null);
/*     */         else {
/* 364 */           pstmt.setString(10, get(i).getA02());
/*     */         }
/* 366 */         if ((get(i).getQID03() == null) || (get(i).getQID03().equals("null")))
/* 367 */           pstmt.setString(11, null);
/*     */         else {
/* 369 */           pstmt.setString(11, get(i).getQID03());
/*     */         }
/* 371 */         if ((get(i).getA03() == null) || (get(i).getA03().equals("null")))
/* 372 */           pstmt.setString(12, null);
/*     */         else {
/* 374 */           pstmt.setString(12, get(i).getA03());
/*     */         }
/* 376 */         if ((get(i).getQID04() == null) || (get(i).getQID04().equals("null")))
/* 377 */           pstmt.setString(13, null);
/*     */         else {
/* 379 */           pstmt.setString(13, get(i).getQID04());
/*     */         }
/* 381 */         if ((get(i).getA04() == null) || (get(i).getA04().equals("null")))
/* 382 */           pstmt.setString(14, null);
/*     */         else {
/* 384 */           pstmt.setString(14, get(i).getA04());
/*     */         }
/* 386 */         if ((get(i).getQID05() == null) || (get(i).getQID05().equals("null")))
/* 387 */           pstmt.setString(15, null);
/*     */         else {
/* 389 */           pstmt.setString(15, get(i).getQID05());
/*     */         }
/* 391 */         if ((get(i).getA05() == null) || (get(i).getA05().equals("null")))
/* 392 */           pstmt.setString(16, null);
/*     */         else {
/* 394 */           pstmt.setString(16, get(i).getA05());
/*     */         }
/* 396 */         if ((get(i).getQID06() == null) || (get(i).getQID06().equals("null")))
/* 397 */           pstmt.setString(17, null);
/*     */         else {
/* 399 */           pstmt.setString(17, get(i).getQID06());
/*     */         }
/* 401 */         if ((get(i).getA06() == null) || (get(i).getA06().equals("null")))
/* 402 */           pstmt.setString(18, null);
/*     */         else {
/* 404 */           pstmt.setString(18, get(i).getA06());
/*     */         }
/* 406 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 407 */           pstmt.setString(19, null);
/*     */         else {
/* 409 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 411 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 412 */           pstmt.setString(20, null);
/*     */         else {
/* 414 */           pstmt.setString(20, get(i).getManageCom());
/*     */         }
/* 416 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 417 */           pstmt.setDate(21, null);
/*     */         else {
/* 419 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 421 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 422 */           pstmt.setString(22, null);
/*     */         else {
/* 424 */           pstmt.setString(22, get(i).getMakeTime());
/*     */         }
/* 426 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 427 */           pstmt.setDate(23, null);
/*     */         else {
/* 429 */           pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 431 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 432 */           pstmt.setString(24, null);
/*     */         else {
/* 434 */           pstmt.setString(24, get(i).getModifyTime());
/*     */         }
/* 436 */         pstmt.addBatch();
/*     */       }
/* 438 */       pstmt.executeBatch();
/* 439 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 442 */       ex.printStackTrace();
/* 443 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 444 */       CError tError = new CError();
/* 445 */       tError.moduleName = "LNPAgentImpResultDBSet";
/* 446 */       tError.functionName = "insert()";
/* 447 */       tError.errorMessage = ex.toString();
/* 448 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 451 */         pstmt.close(); } catch (Exception e) {
/* 452 */         e.printStackTrace();
/*     */       }
/* 454 */       if (!this.mflag) {
/*     */         try {
/* 456 */           this.con.close(); } catch (Exception e) {
/* 457 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 460 */       return false;
/*     */     }
/*     */ 
/* 463 */     if (!this.mflag) {
/*     */       try {
/* 465 */         this.con.close(); } catch (Exception e) {
/* 466 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 469 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAgentImpResultDBSet
 * JD-Core Version:    0.6.0
 */