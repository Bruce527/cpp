/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvOptionBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvOptionBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvOptionBDBSet extends MInvOptionBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvOptionBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvOptionB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvOptionBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvOptionB");
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
/*  49 */     tError.moduleName = "MInvOptionBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvOptionB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MInvOptionBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvOptionB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , OptionID = ? , QuestionID = ? , Option = ? , OptionOrder = ? , State = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
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
/* 158 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getOptionID());
/*     */         }
/* 163 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getQuestionID());
/*     */         }
/* 168 */         if ((get(i).getOption() == null) || (get(i).getOption().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getOption());
/*     */         }
/* 173 */         pstmt.setInt(10, get(i).getOptionOrder());
/* 174 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 179 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getVF01());
/*     */         }
/* 184 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getNF01());
/*     */         }
/* 189 */         pstmt.setInt(14, get(i).getIF01());
/* 190 */         pstmt.setDouble(15, get(i).getDF02());
/* 191 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 192 */           pstmt.setDate(16, null);
/*     */         else {
/* 194 */           pstmt.setDate(16, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 196 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 197 */           pstmt.setString(17, null);
/*     */         else {
/* 199 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 201 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 202 */           pstmt.setString(18, null);
/*     */         else {
/* 204 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 206 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 207 */           pstmt.setDate(19, null);
/*     */         else {
/* 209 */           pstmt.setDate(19, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 211 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 212 */           pstmt.setString(20, null);
/*     */         else {
/* 214 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 216 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 217 */           pstmt.setDate(21, null);
/*     */         else {
/* 219 */           pstmt.setDate(21, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 221 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 222 */           pstmt.setString(22, null);
/*     */         else {
/* 224 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 227 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 228 */           pstmt.setString(23, null);
/*     */         else {
/* 230 */           pstmt.setString(23, get(i).getEdorNo());
/*     */         }
/* 232 */         pstmt.addBatch();
/*     */       }
/* 234 */       pstmt.executeBatch();
/* 235 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 238 */       ex.printStackTrace();
/* 239 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 240 */       CError tError = new CError();
/* 241 */       tError.moduleName = "MInvOptionBDBSet";
/* 242 */       tError.functionName = "update()";
/* 243 */       tError.errorMessage = ex.toString();
/* 244 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 247 */         pstmt.close(); } catch (Exception e) {
/* 248 */         e.printStackTrace();
/*     */       }
/* 250 */       if (!this.mflag) {
/*     */         try {
/* 252 */           this.con.close(); } catch (Exception e) {
/* 253 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 256 */       return false;
/*     */     }
/*     */ 
/* 259 */     if (!this.mflag) {
/*     */       try {
/* 261 */         this.con.close(); } catch (Exception e) {
/* 262 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 271 */     PreparedStatement pstmt = null;
/*     */ 
/* 273 */     if (!this.mflag) {
/* 274 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 279 */       int tCount = size();
/* 280 */       pstmt = this.con.prepareStatement("INSERT INTO MInvOptionB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 281 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 283 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 284 */           pstmt.setString(1, null);
/*     */         else {
/* 286 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 288 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 289 */           pstmt.setString(2, null);
/*     */         else {
/* 291 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 293 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 294 */           pstmt.setString(3, null);
/*     */         else {
/* 296 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 298 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 299 */           pstmt.setString(4, null);
/*     */         else {
/* 301 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 303 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 304 */           pstmt.setDate(5, null);
/*     */         else {
/* 306 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 308 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 309 */           pstmt.setString(6, null);
/*     */         else {
/* 311 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 313 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 314 */           pstmt.setString(7, null);
/*     */         else {
/* 316 */           pstmt.setString(7, get(i).getOptionID());
/*     */         }
/* 318 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 319 */           pstmt.setString(8, null);
/*     */         else {
/* 321 */           pstmt.setString(8, get(i).getQuestionID());
/*     */         }
/* 323 */         if ((get(i).getOption() == null) || (get(i).getOption().equals("null")))
/* 324 */           pstmt.setString(9, null);
/*     */         else {
/* 326 */           pstmt.setString(9, get(i).getOption());
/*     */         }
/* 328 */         pstmt.setInt(10, get(i).getOptionOrder());
/* 329 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 330 */           pstmt.setString(11, null);
/*     */         else {
/* 332 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 334 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 335 */           pstmt.setString(12, null);
/*     */         else {
/* 337 */           pstmt.setString(12, get(i).getVF01());
/*     */         }
/* 339 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 340 */           pstmt.setString(13, null);
/*     */         else {
/* 342 */           pstmt.setString(13, get(i).getNF01());
/*     */         }
/* 344 */         pstmt.setInt(14, get(i).getIF01());
/* 345 */         pstmt.setDouble(15, get(i).getDF02());
/* 346 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 347 */           pstmt.setDate(16, null);
/*     */         else {
/* 349 */           pstmt.setDate(16, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 351 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 352 */           pstmt.setString(17, null);
/*     */         else {
/* 354 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 356 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 357 */           pstmt.setString(18, null);
/*     */         else {
/* 359 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 361 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 362 */           pstmt.setDate(19, null);
/*     */         else {
/* 364 */           pstmt.setDate(19, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 366 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 367 */           pstmt.setString(20, null);
/*     */         else {
/* 369 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 371 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 372 */           pstmt.setDate(21, null);
/*     */         else {
/* 374 */           pstmt.setDate(21, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 376 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 377 */           pstmt.setString(22, null);
/*     */         else {
/* 379 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/* 381 */         pstmt.addBatch();
/*     */       }
/* 383 */       pstmt.executeBatch();
/* 384 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 387 */       ex.printStackTrace();
/* 388 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 389 */       CError tError = new CError();
/* 390 */       tError.moduleName = "MInvOptionBDBSet";
/* 391 */       tError.functionName = "insert()";
/* 392 */       tError.errorMessage = ex.toString();
/* 393 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 396 */         pstmt.close(); } catch (Exception e) {
/* 397 */         e.printStackTrace();
/*     */       }
/* 399 */       if (!this.mflag) {
/*     */         try {
/* 401 */           this.con.close(); } catch (Exception e) {
/* 402 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 405 */       return false;
/*     */     }
/*     */ 
/* 408 */     if (!this.mflag) {
/*     */       try {
/* 410 */         this.con.close(); } catch (Exception e) {
/* 411 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 414 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvOptionBDBSet
 * JD-Core Version:    0.6.0
 */