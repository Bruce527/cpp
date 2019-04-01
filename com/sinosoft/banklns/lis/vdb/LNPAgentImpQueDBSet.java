/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentImpQueSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpQueSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAgentImpQueDBSet extends LNPAgentImpQueSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAgentImpQueDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAgentImpQue");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAgentImpQueDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAgentImpQue");
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
/*  50 */     tError.moduleName = "LNPAgentImpQueDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentImpQue WHERE  Questionid = ? AND InnerOrder = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getQuestionid() == null) || (get(i).getQuestionid().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getQuestionid());
/*     */         }
/*  78 */         if ((get(i).getInnerOrder() == null) || (get(i).getInnerOrder().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getInnerOrder());
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
/*  92 */       tError.moduleName = "LNPAgentImpQueDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentImpQue SET  ImpartId = ? , Questionid = ? , QuestionType = ? , Content1 = ? , Content2 = ? , QueOrder = ? , InnerOrder = ? , OutQueId = ? , InnerQueNum = ? , ParentId = ? , ChildQueNum = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  Questionid = ? AND InnerOrder = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 139 */         if ((get(i).getQuestionid() == null) || (get(i).getQuestionid().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getQuestionid());
/*     */         }
/* 144 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getQuestionType());
/*     */         }
/* 149 */         if ((get(i).getContent1() == null) || (get(i).getContent1().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getContent1());
/*     */         }
/* 154 */         if ((get(i).getContent2() == null) || (get(i).getContent2().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getContent2());
/*     */         }
/* 159 */         if ((get(i).getQueOrder() == null) || (get(i).getQueOrder().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getQueOrder());
/*     */         }
/* 164 */         if ((get(i).getInnerOrder() == null) || (get(i).getInnerOrder().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getInnerOrder());
/*     */         }
/* 169 */         if ((get(i).getOutQueId() == null) || (get(i).getOutQueId().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getOutQueId());
/*     */         }
/* 174 */         if ((get(i).getInnerQueNum() == null) || (get(i).getInnerQueNum().equals("null")))
/* 175 */           pstmt.setString(9, null);
/*     */         else {
/* 177 */           pstmt.setString(9, get(i).getInnerQueNum());
/*     */         }
/* 179 */         if ((get(i).getParentId() == null) || (get(i).getParentId().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getParentId());
/*     */         }
/* 184 */         if ((get(i).getChildQueNum() == null) || (get(i).getChildQueNum().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getChildQueNum());
/*     */         }
/* 189 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 194 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getManageCom());
/*     */         }
/* 199 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 200 */           pstmt.setDate(14, null);
/*     */         else {
/* 202 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 204 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 205 */           pstmt.setString(15, null);
/*     */         else {
/* 207 */           pstmt.setString(15, get(i).getMakeTime());
/*     */         }
/* 209 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 210 */           pstmt.setDate(16, null);
/*     */         else {
/* 212 */           pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 214 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 215 */           pstmt.setString(17, null);
/*     */         else {
/* 217 */           pstmt.setString(17, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 220 */         if ((get(i).getQuestionid() == null) || (get(i).getQuestionid().equals("null")))
/* 221 */           pstmt.setString(18, null);
/*     */         else {
/* 223 */           pstmt.setString(18, get(i).getQuestionid());
/*     */         }
/* 225 */         if ((get(i).getInnerOrder() == null) || (get(i).getInnerOrder().equals("null")))
/* 226 */           pstmt.setString(19, null);
/*     */         else {
/* 228 */           pstmt.setString(19, get(i).getInnerOrder());
/*     */         }
/* 230 */         pstmt.addBatch();
/*     */       }
/* 232 */       pstmt.executeBatch();
/* 233 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 236 */       ex.printStackTrace();
/* 237 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 238 */       CError tError = new CError();
/* 239 */       tError.moduleName = "LNPAgentImpQueDBSet";
/* 240 */       tError.functionName = "update()";
/* 241 */       tError.errorMessage = ex.toString();
/* 242 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 245 */         pstmt.close(); } catch (Exception e) {
/* 246 */         e.printStackTrace();
/*     */       }
/* 248 */       if (!this.mflag) {
/*     */         try {
/* 250 */           this.con.close(); } catch (Exception e) {
/* 251 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 254 */       return false;
/*     */     }
/*     */ 
/* 257 */     if (!this.mflag) {
/*     */       try {
/* 259 */         this.con.close(); } catch (Exception e) {
/* 260 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 269 */     PreparedStatement pstmt = null;
/*     */ 
/* 271 */     if (!this.mflag) {
/* 272 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 277 */       int tCount = size();
/* 278 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentImpQue VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 279 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 281 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 282 */           pstmt.setString(1, null);
/*     */         else {
/* 284 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 286 */         if ((get(i).getQuestionid() == null) || (get(i).getQuestionid().equals("null")))
/* 287 */           pstmt.setString(2, null);
/*     */         else {
/* 289 */           pstmt.setString(2, get(i).getQuestionid());
/*     */         }
/* 291 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 292 */           pstmt.setString(3, null);
/*     */         else {
/* 294 */           pstmt.setString(3, get(i).getQuestionType());
/*     */         }
/* 296 */         if ((get(i).getContent1() == null) || (get(i).getContent1().equals("null")))
/* 297 */           pstmt.setString(4, null);
/*     */         else {
/* 299 */           pstmt.setString(4, get(i).getContent1());
/*     */         }
/* 301 */         if ((get(i).getContent2() == null) || (get(i).getContent2().equals("null")))
/* 302 */           pstmt.setString(5, null);
/*     */         else {
/* 304 */           pstmt.setString(5, get(i).getContent2());
/*     */         }
/* 306 */         if ((get(i).getQueOrder() == null) || (get(i).getQueOrder().equals("null")))
/* 307 */           pstmt.setString(6, null);
/*     */         else {
/* 309 */           pstmt.setString(6, get(i).getQueOrder());
/*     */         }
/* 311 */         if ((get(i).getInnerOrder() == null) || (get(i).getInnerOrder().equals("null")))
/* 312 */           pstmt.setString(7, null);
/*     */         else {
/* 314 */           pstmt.setString(7, get(i).getInnerOrder());
/*     */         }
/* 316 */         if ((get(i).getOutQueId() == null) || (get(i).getOutQueId().equals("null")))
/* 317 */           pstmt.setString(8, null);
/*     */         else {
/* 319 */           pstmt.setString(8, get(i).getOutQueId());
/*     */         }
/* 321 */         if ((get(i).getInnerQueNum() == null) || (get(i).getInnerQueNum().equals("null")))
/* 322 */           pstmt.setString(9, null);
/*     */         else {
/* 324 */           pstmt.setString(9, get(i).getInnerQueNum());
/*     */         }
/* 326 */         if ((get(i).getParentId() == null) || (get(i).getParentId().equals("null")))
/* 327 */           pstmt.setString(10, null);
/*     */         else {
/* 329 */           pstmt.setString(10, get(i).getParentId());
/*     */         }
/* 331 */         if ((get(i).getChildQueNum() == null) || (get(i).getChildQueNum().equals("null")))
/* 332 */           pstmt.setString(11, null);
/*     */         else {
/* 334 */           pstmt.setString(11, get(i).getChildQueNum());
/*     */         }
/* 336 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 337 */           pstmt.setString(12, null);
/*     */         else {
/* 339 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 341 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 342 */           pstmt.setString(13, null);
/*     */         else {
/* 344 */           pstmt.setString(13, get(i).getManageCom());
/*     */         }
/* 346 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 347 */           pstmt.setDate(14, null);
/*     */         else {
/* 349 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 351 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 352 */           pstmt.setString(15, null);
/*     */         else {
/* 354 */           pstmt.setString(15, get(i).getMakeTime());
/*     */         }
/* 356 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 357 */           pstmt.setDate(16, null);
/*     */         else {
/* 359 */           pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 361 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 362 */           pstmt.setString(17, null);
/*     */         else {
/* 364 */           pstmt.setString(17, get(i).getModifyTime());
/*     */         }
/* 366 */         pstmt.addBatch();
/*     */       }
/* 368 */       pstmt.executeBatch();
/* 369 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 372 */       ex.printStackTrace();
/* 373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "LNPAgentImpQueDBSet";
/* 376 */       tError.functionName = "insert()";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         pstmt.close(); } catch (Exception e) {
/* 382 */         e.printStackTrace();
/*     */       }
/* 384 */       if (!this.mflag) {
/*     */         try {
/* 386 */           this.con.close(); } catch (Exception e) {
/* 387 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 390 */       return false;
/*     */     }
/*     */ 
/* 393 */     if (!this.mflag) {
/*     */       try {
/* 395 */         this.con.close(); } catch (Exception e) {
/* 396 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 399 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAgentImpQueDBSet
 * JD-Core Version:    0.6.0
 */