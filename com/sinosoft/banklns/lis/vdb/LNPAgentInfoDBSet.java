/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAgentInfoDBSet extends LNPAgentInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  24 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAgentInfoDBSet(Connection tConnection)
/*     */   {
/*  30 */     this.con = tConnection;
/*  31 */     this.db = new DBOper(this.con, "LNPAgentInfo");
/*  32 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAgentInfoDBSet()
/*     */   {
/*  37 */     this.db = new DBOper("LNPAgentInfo");
/*  38 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  43 */     if (this.db.deleteSQL(this))
/*     */     {
/*  45 */       return true;
/*     */     }
/*     */ 
/*  50 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  51 */     CError tError = new CError();
/*  52 */     tError.moduleName = "LNPAgentInfoDBSet";
/*  53 */     tError.functionName = "deleteSQL";
/*  54 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  55 */     this.mErrors.addOneError(tError);
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  63 */     PreparedStatement pstmt = null;
/*     */ 
/*  65 */     if (!this.mflag) {
/*  66 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  71 */       int tCount = size();
/*  72 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentInfo WHERE  ContNo = ? AND AgentOrder = ?");
/*  73 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  75 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  76 */           pstmt.setString(1, null);
/*     */         else {
/*  78 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  80 */         if ((get(i).getAgentOrder() == null) || (get(i).getAgentOrder().equals("null")))
/*  81 */           pstmt.setString(2, null);
/*     */         else {
/*  83 */           pstmt.setString(2, get(i).getAgentOrder());
/*     */         }
/*  85 */         pstmt.addBatch();
/*     */       }
/*  87 */       pstmt.executeBatch();
/*  88 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  91 */       ex.printStackTrace();
/*  92 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  93 */       CError tError = new CError();
/*  94 */       tError.moduleName = "LNPAgentInfoDBSet";
/*  95 */       tError.functionName = "delete()";
/*  96 */       tError.errorMessage = ex.toString();
/*  97 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 100 */         pstmt.close(); } catch (Exception e) {
/* 101 */         e.printStackTrace();
/*     */       }
/* 103 */       if (!this.mflag) {
/*     */         try {
/* 105 */           this.con.close(); } catch (Exception e) {
/* 106 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 109 */       return false;
/*     */     }
/*     */ 
/* 112 */     if (!this.mflag) {
/*     */       try {
/* 114 */         this.con.close(); } catch (Exception e) {
/* 115 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 124 */     PreparedStatement pstmt = null;
/*     */ 
/* 126 */     if (!this.mflag) {
/* 127 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 132 */       int tCount = size();
/* 133 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AgentOrder = ? , AgentName = ? , AgentCode = ? , BranchName = ? , BranchAttr = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? , PolPrintType = ?  WHERE  ContNo = ? AND AgentOrder = ?");
/* 134 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 136 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 137 */           pstmt.setString(1, null);
/*     */         else {
/* 139 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 141 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 142 */           pstmt.setString(2, null);
/*     */         else {
/* 144 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 146 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 147 */           pstmt.setString(3, null);
/*     */         else {
/* 149 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 151 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 152 */           pstmt.setString(4, null);
/*     */         else {
/* 154 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 156 */         if ((get(i).getAgentOrder() == null) || (get(i).getAgentOrder().equals("null")))
/* 157 */           pstmt.setString(5, null);
/*     */         else {
/* 159 */           pstmt.setString(5, get(i).getAgentOrder());
/*     */         }
/* 161 */         if ((get(i).getAgentName() == null) || (get(i).getAgentName().equals("null")))
/* 162 */           pstmt.setString(6, null);
/*     */         else {
/* 164 */           pstmt.setString(6, get(i).getAgentName());
/*     */         }
/* 166 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 167 */           pstmt.setString(7, null);
/*     */         else {
/* 169 */           pstmt.setString(7, get(i).getAgentCode());
/*     */         }
/* 171 */         if ((get(i).getBranchName() == null) || (get(i).getBranchName().equals("null")))
/* 172 */           pstmt.setString(8, null);
/*     */         else {
/* 174 */           pstmt.setString(8, get(i).getBranchName());
/*     */         }
/* 176 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/* 177 */           pstmt.setString(9, null);
/*     */         else {
/* 179 */           pstmt.setString(9, get(i).getBranchAttr());
/*     */         }
/* 181 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 182 */           pstmt.setString(10, null);
/*     */         else {
/* 184 */           pstmt.setString(10, get(i).getOperator());
/*     */         }
/* 186 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 187 */           pstmt.setDate(11, null);
/*     */         else {
/* 189 */           pstmt.setDate(11, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 191 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 192 */           pstmt.setString(12, null);
/*     */         else {
/* 194 */           pstmt.setString(12, get(i).getMakeTime());
/*     */         }
/* 196 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 197 */           pstmt.setDate(13, null);
/*     */         else {
/* 199 */           pstmt.setDate(13, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 201 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 202 */           pstmt.setString(14, null);
/*     */         else {
/* 204 */           pstmt.setString(14, get(i).getModifyTime());
/*     */         }
/* 206 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 207 */           pstmt.setString(15, null);
/*     */         else {
/* 209 */           pstmt.setString(15, get(i).getP2());
/*     */         }
/* 211 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 212 */           pstmt.setString(16, null);
/*     */         else {
/* 214 */           pstmt.setString(16, get(i).getP4());
/*     */         }
/* 216 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 217 */           pstmt.setString(17, null);
/*     */         else {
/* 219 */           pstmt.setString(17, get(i).getP3());
/*     */         }
/* 221 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 222 */           pstmt.setString(18, null);
/*     */         else {
/* 224 */           pstmt.setString(18, get(i).getP1());
/*     */         }
/* 226 */         if ((get(i).getPolPrintType() == null) || (get(i).getPolPrintType().equals("null")))
/* 227 */           pstmt.setString(19, null);
/*     */         else {
/* 229 */           pstmt.setString(19, get(i).getPolPrintType());
/*     */         }
/*     */ 
/* 232 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 233 */           pstmt.setString(20, null);
/*     */         else {
/* 235 */           pstmt.setString(20, get(i).getContNo());
/*     */         }
/* 237 */         if ((get(i).getAgentOrder() == null) || (get(i).getAgentOrder().equals("null")))
/* 238 */           pstmt.setString(21, null);
/*     */         else {
/* 240 */           pstmt.setString(21, get(i).getAgentOrder());
/*     */         }
/* 242 */         pstmt.addBatch();
/*     */       }
/* 244 */       pstmt.executeBatch();
/* 245 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 248 */       ex.printStackTrace();
/* 249 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 250 */       CError tError = new CError();
/* 251 */       tError.moduleName = "LNPAgentInfoDBSet";
/* 252 */       tError.functionName = "update()";
/* 253 */       tError.errorMessage = ex.toString();
/* 254 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 257 */         pstmt.close(); } catch (Exception e) {
/* 258 */         e.printStackTrace();
/*     */       }
/* 260 */       if (!this.mflag) {
/*     */         try {
/* 262 */           this.con.close(); } catch (Exception e) {
/* 263 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 266 */       return false;
/*     */     }
/*     */ 
/* 269 */     if (!this.mflag) {
/*     */       try {
/* 271 */         this.con.close(); } catch (Exception e) {
/* 272 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 281 */     PreparedStatement pstmt = null;
/*     */ 
/* 283 */     if (!this.mflag) {
/* 284 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 289 */       int tCount = size();
/* 290 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 291 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 293 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 294 */           pstmt.setString(1, null);
/*     */         else {
/* 296 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 298 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 299 */           pstmt.setString(2, null);
/*     */         else {
/* 301 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 303 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 304 */           pstmt.setString(3, null);
/*     */         else {
/* 306 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 308 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 309 */           pstmt.setString(4, null);
/*     */         else {
/* 311 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 313 */         if ((get(i).getAgentOrder() == null) || (get(i).getAgentOrder().equals("null")))
/* 314 */           pstmt.setString(5, null);
/*     */         else {
/* 316 */           pstmt.setString(5, get(i).getAgentOrder());
/*     */         }
/* 318 */         if ((get(i).getAgentName() == null) || (get(i).getAgentName().equals("null")))
/* 319 */           pstmt.setString(6, null);
/*     */         else {
/* 321 */           pstmt.setString(6, get(i).getAgentName());
/*     */         }
/* 323 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 324 */           pstmt.setString(7, null);
/*     */         else {
/* 326 */           pstmt.setString(7, get(i).getAgentCode());
/*     */         }
/* 328 */         if ((get(i).getBranchName() == null) || (get(i).getBranchName().equals("null")))
/* 329 */           pstmt.setString(8, null);
/*     */         else {
/* 331 */           pstmt.setString(8, get(i).getBranchName());
/*     */         }
/* 333 */         if ((get(i).getBranchAttr() == null) || (get(i).getBranchAttr().equals("null")))
/* 334 */           pstmt.setString(9, null);
/*     */         else {
/* 336 */           pstmt.setString(9, get(i).getBranchAttr());
/*     */         }
/* 338 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 339 */           pstmt.setString(10, null);
/*     */         else {
/* 341 */           pstmt.setString(10, get(i).getOperator());
/*     */         }
/* 343 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 344 */           pstmt.setDate(11, null);
/*     */         else {
/* 346 */           pstmt.setDate(11, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 348 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 349 */           pstmt.setString(12, null);
/*     */         else {
/* 351 */           pstmt.setString(12, get(i).getMakeTime());
/*     */         }
/* 353 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 354 */           pstmt.setDate(13, null);
/*     */         else {
/* 356 */           pstmt.setDate(13, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 358 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 359 */           pstmt.setString(14, null);
/*     */         else {
/* 361 */           pstmt.setString(14, get(i).getModifyTime());
/*     */         }
/* 363 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 364 */           pstmt.setString(15, null);
/*     */         else {
/* 366 */           pstmt.setString(15, get(i).getP2());
/*     */         }
/* 368 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 369 */           pstmt.setString(16, null);
/*     */         else {
/* 371 */           pstmt.setString(16, get(i).getP4());
/*     */         }
/* 373 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 374 */           pstmt.setString(17, null);
/*     */         else {
/* 376 */           pstmt.setString(17, get(i).getP3());
/*     */         }
/* 378 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 379 */           pstmt.setString(18, null);
/*     */         else {
/* 381 */           pstmt.setString(18, get(i).getP1());
/*     */         }
/* 383 */         if ((get(i).getPolPrintType() == null) || (get(i).getPolPrintType().equals("null")))
/* 384 */           pstmt.setString(19, null);
/*     */         else {
/* 386 */           pstmt.setString(19, get(i).getPolPrintType());
/*     */         }
/* 388 */         pstmt.addBatch();
/*     */       }
/* 390 */       pstmt.executeBatch();
/* 391 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 394 */       ex.printStackTrace();
/* 395 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 396 */       CError tError = new CError();
/* 397 */       tError.moduleName = "LNPAgentInfoDBSet";
/* 398 */       tError.functionName = "insert()";
/* 399 */       tError.errorMessage = ex.toString();
/* 400 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 403 */         pstmt.close(); } catch (Exception e) {
/* 404 */         e.printStackTrace();
/*     */       }
/* 406 */       if (!this.mflag) {
/*     */         try {
/* 408 */           this.con.close(); } catch (Exception e) {
/* 409 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 412 */       return false;
/*     */     }
/*     */ 
/* 415 */     if (!this.mflag) {
/*     */       try {
/* 417 */         this.con.close(); } catch (Exception e) {
/* 418 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 421 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAgentInfoDBSet
 * JD-Core Version:    0.6.0
 */