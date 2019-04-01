/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvTopicSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvTopicSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvTopicDBSet extends MInvTopicSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvTopicDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvTopic");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvTopicDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvTopic");
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
/*  49 */     tError.moduleName = "MInvTopicDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvTopic WHERE  TopicID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getTopicID());
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
/*  86 */       tError.moduleName = "MInvTopicDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvTopic SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  TopicID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getTopicID());
/*     */         }
/* 133 */         if ((get(i).getTopic() == null) || (get(i).getTopic().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getTopic());
/*     */         }
/* 138 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 143 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 148 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getDepiction());
/*     */         }
/* 153 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getAuthor());
/*     */         }
/* 158 */         pstmt.setInt(7, get(i).getPopulation());
/* 159 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 160 */           pstmt.setDate(8, null);
/*     */         else {
/* 162 */           pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 164 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 165 */           pstmt.setDate(9, null);
/*     */         else {
/* 167 */           pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 169 */         if ((get(i).getInvType() == null) || (get(i).getInvType().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getInvType());
/*     */         }
/* 174 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 179 */         if ((get(i).getInvState() == null) || (get(i).getInvState().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getInvState());
/*     */         }
/* 184 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getCheckState());
/*     */         }
/* 189 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getCheckOperator());
/*     */         }
/* 194 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 195 */           pstmt.setString(15, null);
/*     */         else {
/* 197 */           pstmt.setString(15, get(i).getCheckReason());
/*     */         }
/* 199 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 200 */           pstmt.setDate(16, null);
/*     */         else {
/* 202 */           pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 204 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 205 */           pstmt.setString(17, null);
/*     */         else {
/* 207 */           pstmt.setString(17, get(i).getCheckTime());
/*     */         }
/* 209 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 210 */           pstmt.setString(18, null);
/*     */         else {
/* 212 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 214 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 215 */           pstmt.setString(19, null);
/*     */         else {
/* 217 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 219 */         pstmt.setInt(20, get(i).getIF01());
/* 220 */         pstmt.setDouble(21, get(i).getDF02());
/* 221 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 222 */           pstmt.setDate(22, null);
/*     */         else {
/* 224 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 226 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 227 */           pstmt.setString(23, null);
/*     */         else {
/* 229 */           pstmt.setString(23, get(i).getModifyOperator());
/*     */         }
/* 231 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 232 */           pstmt.setString(24, null);
/*     */         else {
/* 234 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 236 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 237 */           pstmt.setDate(25, null);
/*     */         else {
/* 239 */           pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 241 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 242 */           pstmt.setString(26, null);
/*     */         else {
/* 244 */           pstmt.setString(26, get(i).getMakeTime());
/*     */         }
/* 246 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 247 */           pstmt.setDate(27, null);
/*     */         else {
/* 249 */           pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 251 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 252 */           pstmt.setString(28, null);
/*     */         else {
/* 254 */           pstmt.setString(28, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 257 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 258 */           pstmt.setString(29, null);
/*     */         else {
/* 260 */           pstmt.setString(29, get(i).getTopicID());
/*     */         }
/* 262 */         pstmt.addBatch();
/*     */       }
/* 264 */       pstmt.executeBatch();
/* 265 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 268 */       ex.printStackTrace();
/* 269 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 270 */       CError tError = new CError();
/* 271 */       tError.moduleName = "MInvTopicDBSet";
/* 272 */       tError.functionName = "update()";
/* 273 */       tError.errorMessage = ex.toString();
/* 274 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 277 */         pstmt.close(); } catch (Exception e) {
/* 278 */         e.printStackTrace();
/*     */       }
/* 280 */       if (!this.mflag) {
/*     */         try {
/* 282 */           this.con.close(); } catch (Exception e) {
/* 283 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 286 */       return false;
/*     */     }
/*     */ 
/* 289 */     if (!this.mflag) {
/*     */       try {
/* 291 */         this.con.close(); } catch (Exception e) {
/* 292 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 295 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 301 */     PreparedStatement pstmt = null;
/*     */ 
/* 303 */     if (!this.mflag) {
/* 304 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 309 */       int tCount = size();
/* 310 */       pstmt = this.con.prepareStatement("INSERT INTO MInvTopic VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 311 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 313 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 314 */           pstmt.setString(1, null);
/*     */         else {
/* 316 */           pstmt.setString(1, get(i).getTopicID());
/*     */         }
/* 318 */         if ((get(i).getTopic() == null) || (get(i).getTopic().equals("null")))
/* 319 */           pstmt.setString(2, null);
/*     */         else {
/* 321 */           pstmt.setString(2, get(i).getTopic());
/*     */         }
/* 323 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 324 */           pstmt.setString(3, null);
/*     */         else {
/* 326 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 328 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 329 */           pstmt.setString(4, null);
/*     */         else {
/* 331 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 333 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 334 */           pstmt.setString(5, null);
/*     */         else {
/* 336 */           pstmt.setString(5, get(i).getDepiction());
/*     */         }
/* 338 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 339 */           pstmt.setString(6, null);
/*     */         else {
/* 341 */           pstmt.setString(6, get(i).getAuthor());
/*     */         }
/* 343 */         pstmt.setInt(7, get(i).getPopulation());
/* 344 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 345 */           pstmt.setDate(8, null);
/*     */         else {
/* 347 */           pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 349 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 350 */           pstmt.setDate(9, null);
/*     */         else {
/* 352 */           pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 354 */         if ((get(i).getInvType() == null) || (get(i).getInvType().equals("null")))
/* 355 */           pstmt.setString(10, null);
/*     */         else {
/* 357 */           pstmt.setString(10, get(i).getInvType());
/*     */         }
/* 359 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 360 */           pstmt.setString(11, null);
/*     */         else {
/* 362 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 364 */         if ((get(i).getInvState() == null) || (get(i).getInvState().equals("null")))
/* 365 */           pstmt.setString(12, null);
/*     */         else {
/* 367 */           pstmt.setString(12, get(i).getInvState());
/*     */         }
/* 369 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 370 */           pstmt.setString(13, null);
/*     */         else {
/* 372 */           pstmt.setString(13, get(i).getCheckState());
/*     */         }
/* 374 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 375 */           pstmt.setString(14, null);
/*     */         else {
/* 377 */           pstmt.setString(14, get(i).getCheckOperator());
/*     */         }
/* 379 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 380 */           pstmt.setString(15, null);
/*     */         else {
/* 382 */           pstmt.setString(15, get(i).getCheckReason());
/*     */         }
/* 384 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 385 */           pstmt.setDate(16, null);
/*     */         else {
/* 387 */           pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 389 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 390 */           pstmt.setString(17, null);
/*     */         else {
/* 392 */           pstmt.setString(17, get(i).getCheckTime());
/*     */         }
/* 394 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 395 */           pstmt.setString(18, null);
/*     */         else {
/* 397 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 399 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 400 */           pstmt.setString(19, null);
/*     */         else {
/* 402 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 404 */         pstmt.setInt(20, get(i).getIF01());
/* 405 */         pstmt.setDouble(21, get(i).getDF02());
/* 406 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 407 */           pstmt.setDate(22, null);
/*     */         else {
/* 409 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 411 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 412 */           pstmt.setString(23, null);
/*     */         else {
/* 414 */           pstmt.setString(23, get(i).getModifyOperator());
/*     */         }
/* 416 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 417 */           pstmt.setString(24, null);
/*     */         else {
/* 419 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 421 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 422 */           pstmt.setDate(25, null);
/*     */         else {
/* 424 */           pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 426 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 427 */           pstmt.setString(26, null);
/*     */         else {
/* 429 */           pstmt.setString(26, get(i).getMakeTime());
/*     */         }
/* 431 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 432 */           pstmt.setDate(27, null);
/*     */         else {
/* 434 */           pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 436 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 437 */           pstmt.setString(28, null);
/*     */         else {
/* 439 */           pstmt.setString(28, get(i).getModifyTime());
/*     */         }
/* 441 */         pstmt.addBatch();
/*     */       }
/* 443 */       pstmt.executeBatch();
/* 444 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 447 */       ex.printStackTrace();
/* 448 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 449 */       CError tError = new CError();
/* 450 */       tError.moduleName = "MInvTopicDBSet";
/* 451 */       tError.functionName = "insert()";
/* 452 */       tError.errorMessage = ex.toString();
/* 453 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 456 */         pstmt.close(); } catch (Exception e) {
/* 457 */         e.printStackTrace();
/*     */       }
/* 459 */       if (!this.mflag) {
/*     */         try {
/* 461 */           this.con.close(); } catch (Exception e) {
/* 462 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 465 */       return false;
/*     */     }
/*     */ 
/* 468 */     if (!this.mflag) {
/*     */       try {
/* 470 */         this.con.close(); } catch (Exception e) {
/* 471 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 474 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvTopicDBSet
 * JD-Core Version:    0.6.0
 */