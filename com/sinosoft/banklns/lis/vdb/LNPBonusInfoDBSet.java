/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPBonusInfoDBSet extends LNPBonusInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPBonusInfoDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPBonusInfo");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPBonusInfoDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPBonusInfo");
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
/*  50 */     tError.moduleName = "LNPBonusInfoDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPBonusInfo WHERE  ContNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPBonusInfoDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPBonusInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , BonusType = ? , BonusWay = ? , AutoRepaid = ? , cutPayAll = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 134 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 139 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 144 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 149 */         if ((get(i).getBonusType() == null) || (get(i).getBonusType().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getBonusType());
/*     */         }
/* 154 */         if ((get(i).getBonusWay() == null) || (get(i).getBonusWay().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getBonusWay());
/*     */         }
/* 159 */         if ((get(i).getAutoRepaid() == null) || (get(i).getAutoRepaid().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getAutoRepaid());
/*     */         }
/* 164 */         if ((get(i).getCutPayAll() == null) || (get(i).getCutPayAll().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getCutPayAll());
/*     */         }
/* 169 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getOperator());
/*     */         }
/* 174 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 175 */           pstmt.setDate(10, null);
/*     */         else {
/* 177 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 179 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getMakeTime());
/*     */         }
/* 184 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 185 */           pstmt.setDate(12, null);
/*     */         else {
/* 187 */           pstmt.setDate(12, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 189 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 190 */           pstmt.setString(13, null);
/*     */         else {
/* 192 */           pstmt.setString(13, get(i).getModifyTime());
/*     */         }
/* 194 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 195 */           pstmt.setString(14, null);
/*     */         else {
/* 197 */           pstmt.setString(14, get(i).getP2());
/*     */         }
/* 199 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 200 */           pstmt.setString(15, null);
/*     */         else {
/* 202 */           pstmt.setString(15, get(i).getP4());
/*     */         }
/* 204 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 205 */           pstmt.setString(16, null);
/*     */         else {
/* 207 */           pstmt.setString(16, get(i).getP3());
/*     */         }
/* 209 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 210 */           pstmt.setString(17, null);
/*     */         else {
/* 212 */           pstmt.setString(17, get(i).getP1());
/*     */         }
/*     */ 
/* 215 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 216 */           pstmt.setString(18, null);
/*     */         else {
/* 218 */           pstmt.setString(18, get(i).getContNo());
/*     */         }
/* 220 */         pstmt.addBatch();
/*     */       }
/* 222 */       pstmt.executeBatch();
/* 223 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 226 */       ex.printStackTrace();
/* 227 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 228 */       CError tError = new CError();
/* 229 */       tError.moduleName = "LNPBonusInfoDBSet";
/* 230 */       tError.functionName = "update()";
/* 231 */       tError.errorMessage = ex.toString();
/* 232 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 235 */         pstmt.close(); } catch (Exception e) {
/* 236 */         e.printStackTrace();
/*     */       }
/* 238 */       if (!this.mflag) {
/*     */         try {
/* 240 */           this.con.close(); } catch (Exception e) {
/* 241 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 244 */       return false;
/*     */     }
/*     */ 
/* 247 */     if (!this.mflag) {
/*     */       try {
/* 249 */         this.con.close(); } catch (Exception e) {
/* 250 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 259 */     PreparedStatement pstmt = null;
/*     */ 
/* 261 */     if (!this.mflag) {
/* 262 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 267 */       int tCount = size();
/* 268 */       pstmt = this.con.prepareStatement("INSERT INTO LNPBonusInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 269 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 271 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 272 */           pstmt.setString(1, null);
/*     */         else {
/* 274 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 276 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 277 */           pstmt.setString(2, null);
/*     */         else {
/* 279 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 281 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 282 */           pstmt.setString(3, null);
/*     */         else {
/* 284 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 286 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 287 */           pstmt.setString(4, null);
/*     */         else {
/* 289 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 291 */         if ((get(i).getBonusType() == null) || (get(i).getBonusType().equals("null")))
/* 292 */           pstmt.setString(5, null);
/*     */         else {
/* 294 */           pstmt.setString(5, get(i).getBonusType());
/*     */         }
/* 296 */         if ((get(i).getBonusWay() == null) || (get(i).getBonusWay().equals("null")))
/* 297 */           pstmt.setString(6, null);
/*     */         else {
/* 299 */           pstmt.setString(6, get(i).getBonusWay());
/*     */         }
/* 301 */         if ((get(i).getAutoRepaid() == null) || (get(i).getAutoRepaid().equals("null")))
/* 302 */           pstmt.setString(7, null);
/*     */         else {
/* 304 */           pstmt.setString(7, get(i).getAutoRepaid());
/*     */         }
/* 306 */         if ((get(i).getCutPayAll() == null) || (get(i).getCutPayAll().equals("null")))
/* 307 */           pstmt.setString(8, null);
/*     */         else {
/* 309 */           pstmt.setString(8, get(i).getCutPayAll());
/*     */         }
/* 311 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 312 */           pstmt.setString(9, null);
/*     */         else {
/* 314 */           pstmt.setString(9, get(i).getOperator());
/*     */         }
/* 316 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 317 */           pstmt.setDate(10, null);
/*     */         else {
/* 319 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 321 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 322 */           pstmt.setString(11, null);
/*     */         else {
/* 324 */           pstmt.setString(11, get(i).getMakeTime());
/*     */         }
/* 326 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 327 */           pstmt.setDate(12, null);
/*     */         else {
/* 329 */           pstmt.setDate(12, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 331 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 332 */           pstmt.setString(13, null);
/*     */         else {
/* 334 */           pstmt.setString(13, get(i).getModifyTime());
/*     */         }
/* 336 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 337 */           pstmt.setString(14, null);
/*     */         else {
/* 339 */           pstmt.setString(14, get(i).getP2());
/*     */         }
/* 341 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 342 */           pstmt.setString(15, null);
/*     */         else {
/* 344 */           pstmt.setString(15, get(i).getP4());
/*     */         }
/* 346 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 347 */           pstmt.setString(16, null);
/*     */         else {
/* 349 */           pstmt.setString(16, get(i).getP3());
/*     */         }
/* 351 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 352 */           pstmt.setString(17, null);
/*     */         else {
/* 354 */           pstmt.setString(17, get(i).getP1());
/*     */         }
/* 356 */         pstmt.addBatch();
/*     */       }
/* 358 */       pstmt.executeBatch();
/* 359 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 362 */       ex.printStackTrace();
/* 363 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 364 */       CError tError = new CError();
/* 365 */       tError.moduleName = "LNPBonusInfoDBSet";
/* 366 */       tError.functionName = "insert()";
/* 367 */       tError.errorMessage = ex.toString();
/* 368 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 371 */         pstmt.close(); } catch (Exception e) {
/* 372 */         e.printStackTrace();
/*     */       }
/* 374 */       if (!this.mflag) {
/*     */         try {
/* 376 */           this.con.close(); } catch (Exception e) {
/* 377 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 380 */       return false;
/*     */     }
/*     */ 
/* 383 */     if (!this.mflag) {
/*     */       try {
/* 385 */         this.con.close(); } catch (Exception e) {
/* 386 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 389 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPBonusInfoDBSet
 * JD-Core Version:    0.6.0
 */