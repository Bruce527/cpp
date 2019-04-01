/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvResultBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvResultBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvResultBDBSet extends MInvResultBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvResultBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvResultB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvResultBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvResultB");
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
/*  49 */     tError.moduleName = "MInvResultBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvResultB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MInvResultBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvResultB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/* 158 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getResultID());
/*     */         }
/* 163 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getTopicID());
/*     */         }
/* 168 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getQuestionID());
/*     */         }
/* 173 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getOptionID());
/*     */         }
/* 178 */         if ((get(i).getOtherAnswer() == null) || (get(i).getOtherAnswer().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getOtherAnswer());
/*     */         }
/* 183 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getAgentCode());
/*     */         }
/* 188 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getManageCom());
/*     */         }
/* 193 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getVF01());
/*     */         }
/* 198 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getNF01());
/*     */         }
/* 203 */         pstmt.setInt(16, get(i).getIF01());
/* 204 */         pstmt.setDouble(17, get(i).getDF02());
/* 205 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 206 */           pstmt.setDate(18, null);
/*     */         else {
/* 208 */           pstmt.setDate(18, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 210 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getModifyOperator());
/*     */         }
/* 215 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 216 */           pstmt.setString(20, null);
/*     */         else {
/* 218 */           pstmt.setString(20, get(i).getOperator());
/*     */         }
/* 220 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 221 */           pstmt.setDate(21, null);
/*     */         else {
/* 223 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 225 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 226 */           pstmt.setString(22, null);
/*     */         else {
/* 228 */           pstmt.setString(22, get(i).getMakeTime());
/*     */         }
/* 230 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 231 */           pstmt.setDate(23, null);
/*     */         else {
/* 233 */           pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 235 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 236 */           pstmt.setString(24, null);
/*     */         else {
/* 238 */           pstmt.setString(24, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 241 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 242 */           pstmt.setString(25, null);
/*     */         else {
/* 244 */           pstmt.setString(25, get(i).getEdorNo());
/*     */         }
/* 246 */         pstmt.addBatch();
/*     */       }
/* 248 */       pstmt.executeBatch();
/* 249 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 252 */       ex.printStackTrace();
/* 253 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 254 */       CError tError = new CError();
/* 255 */       tError.moduleName = "MInvResultBDBSet";
/* 256 */       tError.functionName = "update()";
/* 257 */       tError.errorMessage = ex.toString();
/* 258 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 261 */         pstmt.close(); } catch (Exception e) {
/* 262 */         e.printStackTrace();
/*     */       }
/* 264 */       if (!this.mflag) {
/*     */         try {
/* 266 */           this.con.close(); } catch (Exception e) {
/* 267 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 270 */       return false;
/*     */     }
/*     */ 
/* 273 */     if (!this.mflag) {
/*     */       try {
/* 275 */         this.con.close(); } catch (Exception e) {
/* 276 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 285 */     PreparedStatement pstmt = null;
/*     */ 
/* 287 */     if (!this.mflag) {
/* 288 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 293 */       int tCount = size();
/* 294 */       pstmt = this.con.prepareStatement("INSERT INTO MInvResultB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 295 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 297 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 298 */           pstmt.setString(1, null);
/*     */         else {
/* 300 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 302 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 303 */           pstmt.setString(2, null);
/*     */         else {
/* 305 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 307 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 308 */           pstmt.setString(3, null);
/*     */         else {
/* 310 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 312 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 313 */           pstmt.setString(4, null);
/*     */         else {
/* 315 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 317 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 318 */           pstmt.setDate(5, null);
/*     */         else {
/* 320 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 322 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 323 */           pstmt.setString(6, null);
/*     */         else {
/* 325 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 327 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/* 328 */           pstmt.setString(7, null);
/*     */         else {
/* 330 */           pstmt.setString(7, get(i).getResultID());
/*     */         }
/* 332 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 333 */           pstmt.setString(8, null);
/*     */         else {
/* 335 */           pstmt.setString(8, get(i).getTopicID());
/*     */         }
/* 337 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 338 */           pstmt.setString(9, null);
/*     */         else {
/* 340 */           pstmt.setString(9, get(i).getQuestionID());
/*     */         }
/* 342 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 343 */           pstmt.setString(10, null);
/*     */         else {
/* 345 */           pstmt.setString(10, get(i).getOptionID());
/*     */         }
/* 347 */         if ((get(i).getOtherAnswer() == null) || (get(i).getOtherAnswer().equals("null")))
/* 348 */           pstmt.setString(11, null);
/*     */         else {
/* 350 */           pstmt.setString(11, get(i).getOtherAnswer());
/*     */         }
/* 352 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 353 */           pstmt.setString(12, null);
/*     */         else {
/* 355 */           pstmt.setString(12, get(i).getAgentCode());
/*     */         }
/* 357 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 358 */           pstmt.setString(13, null);
/*     */         else {
/* 360 */           pstmt.setString(13, get(i).getManageCom());
/*     */         }
/* 362 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 363 */           pstmt.setString(14, null);
/*     */         else {
/* 365 */           pstmt.setString(14, get(i).getVF01());
/*     */         }
/* 367 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 368 */           pstmt.setString(15, null);
/*     */         else {
/* 370 */           pstmt.setString(15, get(i).getNF01());
/*     */         }
/* 372 */         pstmt.setInt(16, get(i).getIF01());
/* 373 */         pstmt.setDouble(17, get(i).getDF02());
/* 374 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 375 */           pstmt.setDate(18, null);
/*     */         else {
/* 377 */           pstmt.setDate(18, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 379 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 380 */           pstmt.setString(19, null);
/*     */         else {
/* 382 */           pstmt.setString(19, get(i).getModifyOperator());
/*     */         }
/* 384 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 385 */           pstmt.setString(20, null);
/*     */         else {
/* 387 */           pstmt.setString(20, get(i).getOperator());
/*     */         }
/* 389 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 390 */           pstmt.setDate(21, null);
/*     */         else {
/* 392 */           pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 394 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 395 */           pstmt.setString(22, null);
/*     */         else {
/* 397 */           pstmt.setString(22, get(i).getMakeTime());
/*     */         }
/* 399 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 400 */           pstmt.setDate(23, null);
/*     */         else {
/* 402 */           pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 404 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 405 */           pstmt.setString(24, null);
/*     */         else {
/* 407 */           pstmt.setString(24, get(i).getModifyTime());
/*     */         }
/* 409 */         pstmt.addBatch();
/*     */       }
/* 411 */       pstmt.executeBatch();
/* 412 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 415 */       ex.printStackTrace();
/* 416 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 417 */       CError tError = new CError();
/* 418 */       tError.moduleName = "MInvResultBDBSet";
/* 419 */       tError.functionName = "insert()";
/* 420 */       tError.errorMessage = ex.toString();
/* 421 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 424 */         pstmt.close(); } catch (Exception e) {
/* 425 */         e.printStackTrace();
/*     */       }
/* 427 */       if (!this.mflag) {
/*     */         try {
/* 429 */           this.con.close(); } catch (Exception e) {
/* 430 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 433 */       return false;
/*     */     }
/*     */ 
/* 436 */     if (!this.mflag) {
/*     */       try {
/* 438 */         this.con.close(); } catch (Exception e) {
/* 439 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 442 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvResultBDBSet
 * JD-Core Version:    0.6.0
 */