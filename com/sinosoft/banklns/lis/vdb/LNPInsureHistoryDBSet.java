/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPInsureHistoryDBSet extends LNPInsureHistorySet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPInsureHistoryDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPInsureHistory");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPInsureHistoryDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPInsureHistory");
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
/*  50 */     tError.moduleName = "LNPInsureHistoryDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         if ((get(i).getPolOrder() == null) || (get(i).getPolOrder().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getPolOrder());
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
/*  92 */       tError.moduleName = "LNPInsureHistoryDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPInsureHistory SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , PolOrder = ? , ComName = ? , SumInsuredDeath = ? , SumInsuredDisease = ? , PolicyState = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ? AND PolOrder = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 139 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 144 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 149 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 154 */         if ((get(i).getPolOrder() == null) || (get(i).getPolOrder().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getPolOrder());
/*     */         }
/* 159 */         if ((get(i).getComName() == null) || (get(i).getComName().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getComName());
/*     */         }
/* 164 */         pstmt.setDouble(7, get(i).getSumInsuredDeath());
/* 165 */         pstmt.setDouble(8, get(i).getSumInsuredDisease());
/* 166 */         if ((get(i).getPolicyState() == null) || (get(i).getPolicyState().equals("null")))
/* 167 */           pstmt.setString(9, null);
/*     */         else {
/* 169 */           pstmt.setString(9, get(i).getPolicyState());
/*     */         }
/* 171 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 172 */           pstmt.setString(10, null);
/*     */         else {
/* 174 */           pstmt.setString(10, get(i).getState());
/*     */         }
/* 176 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 177 */           pstmt.setString(11, null);
/*     */         else {
/* 179 */           pstmt.setString(11, get(i).getOperator());
/*     */         }
/* 181 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 182 */           pstmt.setDate(12, null);
/*     */         else {
/* 184 */           pstmt.setDate(12, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 186 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 187 */           pstmt.setString(13, null);
/*     */         else {
/* 189 */           pstmt.setString(13, get(i).getMakeTime());
/*     */         }
/* 191 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 192 */           pstmt.setDate(14, null);
/*     */         else {
/* 194 */           pstmt.setDate(14, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 196 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 197 */           pstmt.setString(15, null);
/*     */         else {
/* 199 */           pstmt.setString(15, get(i).getModifyTime());
/*     */         }
/* 201 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 202 */           pstmt.setString(16, null);
/*     */         else {
/* 204 */           pstmt.setString(16, get(i).getP2());
/*     */         }
/* 206 */         pstmt.setDouble(17, get(i).getP4());
/* 207 */         pstmt.setDouble(18, get(i).getP3());
/* 208 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 209 */           pstmt.setString(19, null);
/*     */         else {
/* 211 */           pstmt.setString(19, get(i).getP1());
/*     */         }
/*     */ 
/* 214 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 215 */           pstmt.setString(20, null);
/*     */         else {
/* 217 */           pstmt.setString(20, get(i).getContNo());
/*     */         }
/* 219 */         if ((get(i).getPolOrder() == null) || (get(i).getPolOrder().equals("null")))
/* 220 */           pstmt.setString(21, null);
/*     */         else {
/* 222 */           pstmt.setString(21, get(i).getPolOrder());
/*     */         }
/* 224 */         pstmt.addBatch();
/*     */       }
/* 226 */       pstmt.executeBatch();
/* 227 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 230 */       ex.printStackTrace();
/* 231 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 232 */       CError tError = new CError();
/* 233 */       tError.moduleName = "LNPInsureHistoryDBSet";
/* 234 */       tError.functionName = "update()";
/* 235 */       tError.errorMessage = ex.toString();
/* 236 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 239 */         pstmt.close(); } catch (Exception e) {
/* 240 */         e.printStackTrace();
/*     */       }
/* 242 */       if (!this.mflag) {
/*     */         try {
/* 244 */           this.con.close(); } catch (Exception e) {
/* 245 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 248 */       return false;
/*     */     }
/*     */ 
/* 251 */     if (!this.mflag) {
/*     */       try {
/* 253 */         this.con.close(); } catch (Exception e) {
/* 254 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 257 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 263 */     PreparedStatement pstmt = null;
/*     */ 
/* 265 */     if (!this.mflag) {
/* 266 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 271 */       int tCount = size();
/* 272 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsureHistory VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 273 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 275 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 276 */           pstmt.setString(1, null);
/*     */         else {
/* 278 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 280 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 281 */           pstmt.setString(2, null);
/*     */         else {
/* 283 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 285 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 286 */           pstmt.setString(3, null);
/*     */         else {
/* 288 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 290 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 291 */           pstmt.setString(4, null);
/*     */         else {
/* 293 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 295 */         if ((get(i).getPolOrder() == null) || (get(i).getPolOrder().equals("null")))
/* 296 */           pstmt.setString(5, null);
/*     */         else {
/* 298 */           pstmt.setString(5, get(i).getPolOrder());
/*     */         }
/* 300 */         if ((get(i).getComName() == null) || (get(i).getComName().equals("null")))
/* 301 */           pstmt.setString(6, null);
/*     */         else {
/* 303 */           pstmt.setString(6, get(i).getComName());
/*     */         }
/* 305 */         pstmt.setDouble(7, get(i).getSumInsuredDeath());
/* 306 */         pstmt.setDouble(8, get(i).getSumInsuredDisease());
/* 307 */         if ((get(i).getPolicyState() == null) || (get(i).getPolicyState().equals("null")))
/* 308 */           pstmt.setString(9, null);
/*     */         else {
/* 310 */           pstmt.setString(9, get(i).getPolicyState());
/*     */         }
/* 312 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 313 */           pstmt.setString(10, null);
/*     */         else {
/* 315 */           pstmt.setString(10, get(i).getState());
/*     */         }
/* 317 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 318 */           pstmt.setString(11, null);
/*     */         else {
/* 320 */           pstmt.setString(11, get(i).getOperator());
/*     */         }
/* 322 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 323 */           pstmt.setDate(12, null);
/*     */         else {
/* 325 */           pstmt.setDate(12, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 327 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 328 */           pstmt.setString(13, null);
/*     */         else {
/* 330 */           pstmt.setString(13, get(i).getMakeTime());
/*     */         }
/* 332 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 333 */           pstmt.setDate(14, null);
/*     */         else {
/* 335 */           pstmt.setDate(14, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 337 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 338 */           pstmt.setString(15, null);
/*     */         else {
/* 340 */           pstmt.setString(15, get(i).getModifyTime());
/*     */         }
/* 342 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 343 */           pstmt.setString(16, null);
/*     */         else {
/* 345 */           pstmt.setString(16, get(i).getP2());
/*     */         }
/* 347 */         pstmt.setDouble(17, get(i).getP4());
/* 348 */         pstmt.setDouble(18, get(i).getP3());
/* 349 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 350 */           pstmt.setString(19, null);
/*     */         else {
/* 352 */           pstmt.setString(19, get(i).getP1());
/*     */         }
/* 354 */         pstmt.addBatch();
/*     */       }
/* 356 */       pstmt.executeBatch();
/* 357 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 360 */       ex.printStackTrace();
/* 361 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 362 */       CError tError = new CError();
/* 363 */       tError.moduleName = "LNPInsureHistoryDBSet";
/* 364 */       tError.functionName = "insert()";
/* 365 */       tError.errorMessage = ex.toString();
/* 366 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 369 */         pstmt.close(); } catch (Exception e) {
/* 370 */         e.printStackTrace();
/*     */       }
/* 372 */       if (!this.mflag) {
/*     */         try {
/* 374 */           this.con.close(); } catch (Exception e) {
/* 375 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 378 */       return false;
/*     */     }
/*     */ 
/* 381 */     if (!this.mflag) {
/*     */       try {
/* 383 */         this.con.close(); } catch (Exception e) {
/* 384 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 387 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPInsureHistoryDBSet
 * JD-Core Version:    0.6.0
 */