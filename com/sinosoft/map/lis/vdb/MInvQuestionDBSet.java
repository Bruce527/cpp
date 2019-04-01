/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvQuestionSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvQuestionSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvQuestionDBSet extends MInvQuestionSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvQuestionDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvQuestion");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvQuestionDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvQuestion");
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
/*  49 */     tError.moduleName = "MInvQuestionDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvQuestion WHERE  QuestionID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getQuestionID());
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
/*  86 */       tError.moduleName = "MInvQuestionDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvQuestion SET  QuestionID = ? , TopicID = ? , Question = ? , Depiction = ? , QuestionType = ? , QuestionOrder = ? , ParentID = ? , State = ? , ChildFlag = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  QuestionID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getQuestionID());
/*     */         }
/* 133 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getTopicID());
/*     */         }
/* 138 */         if ((get(i).getQuestion() == null) || (get(i).getQuestion().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getQuestion());
/*     */         }
/* 143 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getDepiction());
/*     */         }
/* 148 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getQuestionType());
/*     */         }
/* 153 */         pstmt.setInt(6, get(i).getQuestionOrder());
/* 154 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getParentID());
/*     */         }
/* 159 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getState());
/*     */         }
/* 164 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getChildFlag());
/*     */         }
/* 169 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getVF01());
/*     */         }
/* 174 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getNF01());
/*     */         }
/* 179 */         pstmt.setInt(12, get(i).getIF01());
/* 180 */         pstmt.setDouble(13, get(i).getDF02());
/* 181 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 182 */           pstmt.setDate(14, null);
/*     */         else {
/* 184 */           pstmt.setDate(14, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 186 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 187 */           pstmt.setString(15, null);
/*     */         else {
/* 189 */           pstmt.setString(15, get(i).getModifyOperator());
/*     */         }
/* 191 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 192 */           pstmt.setString(16, null);
/*     */         else {
/* 194 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 196 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 197 */           pstmt.setDate(17, null);
/*     */         else {
/* 199 */           pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 201 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 202 */           pstmt.setString(18, null);
/*     */         else {
/* 204 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 206 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 207 */           pstmt.setDate(19, null);
/*     */         else {
/* 209 */           pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 211 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 212 */           pstmt.setString(20, null);
/*     */         else {
/* 214 */           pstmt.setString(20, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 217 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 218 */           pstmt.setString(21, null);
/*     */         else {
/* 220 */           pstmt.setString(21, get(i).getQuestionID());
/*     */         }
/* 222 */         pstmt.addBatch();
/*     */       }
/* 224 */       pstmt.executeBatch();
/* 225 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 228 */       ex.printStackTrace();
/* 229 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 230 */       CError tError = new CError();
/* 231 */       tError.moduleName = "MInvQuestionDBSet";
/* 232 */       tError.functionName = "update()";
/* 233 */       tError.errorMessage = ex.toString();
/* 234 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 237 */         pstmt.close(); } catch (Exception e) {
/* 238 */         e.printStackTrace();
/*     */       }
/* 240 */       if (!this.mflag) {
/*     */         try {
/* 242 */           this.con.close(); } catch (Exception e) {
/* 243 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 246 */       return false;
/*     */     }
/*     */ 
/* 249 */     if (!this.mflag) {
/*     */       try {
/* 251 */         this.con.close(); } catch (Exception e) {
/* 252 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 261 */     PreparedStatement pstmt = null;
/*     */ 
/* 263 */     if (!this.mflag) {
/* 264 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 269 */       int tCount = size();
/* 270 */       pstmt = this.con.prepareStatement("INSERT INTO MInvQuestion VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 271 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 273 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 274 */           pstmt.setString(1, null);
/*     */         else {
/* 276 */           pstmt.setString(1, get(i).getQuestionID());
/*     */         }
/* 278 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 279 */           pstmt.setString(2, null);
/*     */         else {
/* 281 */           pstmt.setString(2, get(i).getTopicID());
/*     */         }
/* 283 */         if ((get(i).getQuestion() == null) || (get(i).getQuestion().equals("null")))
/* 284 */           pstmt.setString(3, null);
/*     */         else {
/* 286 */           pstmt.setString(3, get(i).getQuestion());
/*     */         }
/* 288 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 289 */           pstmt.setString(4, null);
/*     */         else {
/* 291 */           pstmt.setString(4, get(i).getDepiction());
/*     */         }
/* 293 */         if ((get(i).getQuestionType() == null) || (get(i).getQuestionType().equals("null")))
/* 294 */           pstmt.setString(5, null);
/*     */         else {
/* 296 */           pstmt.setString(5, get(i).getQuestionType());
/*     */         }
/* 298 */         pstmt.setInt(6, get(i).getQuestionOrder());
/* 299 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 300 */           pstmt.setString(7, null);
/*     */         else {
/* 302 */           pstmt.setString(7, get(i).getParentID());
/*     */         }
/* 304 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 305 */           pstmt.setString(8, null);
/*     */         else {
/* 307 */           pstmt.setString(8, get(i).getState());
/*     */         }
/* 309 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 310 */           pstmt.setString(9, null);
/*     */         else {
/* 312 */           pstmt.setString(9, get(i).getChildFlag());
/*     */         }
/* 314 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 315 */           pstmt.setString(10, null);
/*     */         else {
/* 317 */           pstmt.setString(10, get(i).getVF01());
/*     */         }
/* 319 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 320 */           pstmt.setString(11, null);
/*     */         else {
/* 322 */           pstmt.setString(11, get(i).getNF01());
/*     */         }
/* 324 */         pstmt.setInt(12, get(i).getIF01());
/* 325 */         pstmt.setDouble(13, get(i).getDF02());
/* 326 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 327 */           pstmt.setDate(14, null);
/*     */         else {
/* 329 */           pstmt.setDate(14, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 331 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 332 */           pstmt.setString(15, null);
/*     */         else {
/* 334 */           pstmt.setString(15, get(i).getModifyOperator());
/*     */         }
/* 336 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 337 */           pstmt.setString(16, null);
/*     */         else {
/* 339 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 341 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 342 */           pstmt.setDate(17, null);
/*     */         else {
/* 344 */           pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 346 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 347 */           pstmt.setString(18, null);
/*     */         else {
/* 349 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 351 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 352 */           pstmt.setDate(19, null);
/*     */         else {
/* 354 */           pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 356 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 357 */           pstmt.setString(20, null);
/*     */         else {
/* 359 */           pstmt.setString(20, get(i).getModifyTime());
/*     */         }
/* 361 */         pstmt.addBatch();
/*     */       }
/* 363 */       pstmt.executeBatch();
/* 364 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 367 */       ex.printStackTrace();
/* 368 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 369 */       CError tError = new CError();
/* 370 */       tError.moduleName = "MInvQuestionDBSet";
/* 371 */       tError.functionName = "insert()";
/* 372 */       tError.errorMessage = ex.toString();
/* 373 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 376 */         pstmt.close(); } catch (Exception e) {
/* 377 */         e.printStackTrace();
/*     */       }
/* 379 */       if (!this.mflag) {
/*     */         try {
/* 381 */           this.con.close(); } catch (Exception e) {
/* 382 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 385 */       return false;
/*     */     }
/*     */ 
/* 388 */     if (!this.mflag) {
/*     */       try {
/* 390 */         this.con.close(); } catch (Exception e) {
/* 391 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 394 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvQuestionDBSet
 * JD-Core Version:    0.6.0
 */