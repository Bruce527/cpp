/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvQuestionBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvQuestionBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvQuestionBDBSet extends MInvQuestionBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvQuestionBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvQuestionB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvQuestionBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvQuestionB");
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
/*  49 */     tError.moduleName = "MInvQuestionBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvQuestionB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MInvQuestionBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvQuestionB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , QuestionID = ? , TopicID = ? , Question = ? , Depiction = ? , QuestionType = ? , QuestionOrder = ? , ParentID = ? , State = ? , ChildFlag = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 133 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 138 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 143 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 148 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 149 */           pstmt.setDate(5, null);
/*     */         else {
/* 151 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 153 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 158 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getQuestionID());
/*     */         }
/* 163 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getTopicID());
/*     */         }
/* 168 */         if ((get(i).getQuestion() == null) || (get(i).getQuestion().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getQuestion());
/*     */         }
/* 173 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getDepiction());
/*     */         }
/* 178 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getQuestionType());
/*     */         }
/* 183 */         pstmt.setInt(12, get(i).getQuestionOrder());
/* 184 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getParentID());
/*     */         }
/* 189 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getState());
/*     */         }
/* 194 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 195 */           pstmt.setString(15, null);
/*     */         else {
/* 197 */           pstmt.setString(15, get(i).getChildFlag());
/*     */         }
/* 199 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 200 */           pstmt.setString(16, null);
/*     */         else {
/* 202 */           pstmt.setString(16, get(i).getVF01());
/*     */         }
/* 204 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 205 */           pstmt.setString(17, null);
/*     */         else {
/* 207 */           pstmt.setString(17, get(i).getNF01());
/*     */         }
/* 209 */         pstmt.setInt(18, get(i).getIF01());
/* 210 */         pstmt.setDouble(19, get(i).getDF02());
/* 211 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 212 */           pstmt.setDate(20, null);
/*     */         else {
/* 214 */           pstmt.setDate(20, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 216 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 217 */           pstmt.setString(21, null);
/*     */         else {
/* 219 */           pstmt.setString(21, get(i).getModifyOperator());
/*     */         }
/* 221 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 222 */           pstmt.setString(22, null);
/*     */         else {
/* 224 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 226 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 227 */           pstmt.setDate(23, null);
/*     */         else {
/* 229 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 231 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 232 */           pstmt.setString(24, null);
/*     */         else {
/* 234 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 236 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 237 */           pstmt.setDate(25, null);
/*     */         else {
/* 239 */           pstmt.setDate(25, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 241 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 242 */           pstmt.setString(26, null);
/*     */         else {
/* 244 */           pstmt.setString(26, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 247 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 248 */           pstmt.setString(27, null);
/*     */         else {
/* 250 */           pstmt.setString(27, get(i).getEdorNo());
/*     */         }
/* 252 */         pstmt.addBatch();
/*     */       }
/* 254 */       pstmt.executeBatch();
/* 255 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 258 */       ex.printStackTrace();
/* 259 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 260 */       CError tError = new CError();
/* 261 */       tError.moduleName = "MInvQuestionBDBSet";
/* 262 */       tError.functionName = "update()";
/* 263 */       tError.errorMessage = ex.toString();
/* 264 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 267 */         pstmt.close(); } catch (Exception e) {
/* 268 */         e.printStackTrace();
/*     */       }
/* 270 */       if (!this.mflag) {
/*     */         try {
/* 272 */           this.con.close(); } catch (Exception e) {
/* 273 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 276 */       return false;
/*     */     }
/*     */ 
/* 279 */     if (!this.mflag) {
/*     */       try {
/* 281 */         this.con.close(); } catch (Exception e) {
/* 282 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 285 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 291 */     PreparedStatement pstmt = null;
/*     */ 
/* 293 */     if (!this.mflag) {
/* 294 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 299 */       int tCount = size();
/* 300 */       pstmt = this.con.prepareStatement("INSERT INTO MInvQuestionB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 301 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 303 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 304 */           pstmt.setString(1, null);
/*     */         else {
/* 306 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 308 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 309 */           pstmt.setString(2, null);
/*     */         else {
/* 311 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 313 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 314 */           pstmt.setString(3, null);
/*     */         else {
/* 316 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 318 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 319 */           pstmt.setString(4, null);
/*     */         else {
/* 321 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 323 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 324 */           pstmt.setDate(5, null);
/*     */         else {
/* 326 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 328 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 329 */           pstmt.setString(6, null);
/*     */         else {
/* 331 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 333 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 334 */           pstmt.setString(7, null);
/*     */         else {
/* 336 */           pstmt.setString(7, get(i).getQuestionID());
/*     */         }
/* 338 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 339 */           pstmt.setString(8, null);
/*     */         else {
/* 341 */           pstmt.setString(8, get(i).getTopicID());
/*     */         }
/* 343 */         if ((get(i).getQuestion() == null) || (get(i).getQuestion().equals("null")))
/* 344 */           pstmt.setString(9, null);
/*     */         else {
/* 346 */           pstmt.setString(9, get(i).getQuestion());
/*     */         }
/* 348 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 349 */           pstmt.setString(10, null);
/*     */         else {
/* 351 */           pstmt.setString(10, get(i).getDepiction());
/*     */         }
/* 353 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 354 */           pstmt.setString(11, null);
/*     */         else {
/* 356 */           pstmt.setString(11, get(i).getQuestionType());
/*     */         }
/* 358 */         pstmt.setInt(12, get(i).getQuestionOrder());
/* 359 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 360 */           pstmt.setString(13, null);
/*     */         else {
/* 362 */           pstmt.setString(13, get(i).getParentID());
/*     */         }
/* 364 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 365 */           pstmt.setString(14, null);
/*     */         else {
/* 367 */           pstmt.setString(14, get(i).getState());
/*     */         }
/* 369 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 370 */           pstmt.setString(15, null);
/*     */         else {
/* 372 */           pstmt.setString(15, get(i).getChildFlag());
/*     */         }
/* 374 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 375 */           pstmt.setString(16, null);
/*     */         else {
/* 377 */           pstmt.setString(16, get(i).getVF01());
/*     */         }
/* 379 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 380 */           pstmt.setString(17, null);
/*     */         else {
/* 382 */           pstmt.setString(17, get(i).getNF01());
/*     */         }
/* 384 */         pstmt.setInt(18, get(i).getIF01());
/* 385 */         pstmt.setDouble(19, get(i).getDF02());
/* 386 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 387 */           pstmt.setDate(20, null);
/*     */         else {
/* 389 */           pstmt.setDate(20, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 391 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 392 */           pstmt.setString(21, null);
/*     */         else {
/* 394 */           pstmt.setString(21, get(i).getModifyOperator());
/*     */         }
/* 396 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 397 */           pstmt.setString(22, null);
/*     */         else {
/* 399 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 401 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 402 */           pstmt.setDate(23, null);
/*     */         else {
/* 404 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 406 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 407 */           pstmt.setString(24, null);
/*     */         else {
/* 409 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 411 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 412 */           pstmt.setDate(25, null);
/*     */         else {
/* 414 */           pstmt.setDate(25, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 416 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 417 */           pstmt.setString(26, null);
/*     */         else {
/* 419 */           pstmt.setString(26, get(i).getModifyTime());
/*     */         }
/* 421 */         pstmt.addBatch();
/*     */       }
/* 423 */       pstmt.executeBatch();
/* 424 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 427 */       ex.printStackTrace();
/* 428 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 429 */       CError tError = new CError();
/* 430 */       tError.moduleName = "MInvQuestionBDBSet";
/* 431 */       tError.functionName = "insert()";
/* 432 */       tError.errorMessage = ex.toString();
/* 433 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 436 */         pstmt.close(); } catch (Exception e) {
/* 437 */         e.printStackTrace();
/*     */       }
/* 439 */       if (!this.mflag) {
/*     */         try {
/* 441 */           this.con.close(); } catch (Exception e) {
/* 442 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 445 */       return false;
/*     */     }
/*     */ 
/* 448 */     if (!this.mflag) {
/*     */       try {
/* 450 */         this.con.close(); } catch (Exception e) {
/* 451 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 454 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvQuestionBDBSet
 * JD-Core Version:    0.6.0
 */