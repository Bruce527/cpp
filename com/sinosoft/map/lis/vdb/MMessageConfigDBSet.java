/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMessageConfigSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMessageConfigSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MMessageConfigDBSet extends MMessageConfigSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MMessageConfigDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MMessageConfig");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMessageConfigDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MMessageConfig");
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
/*  49 */     tError.moduleName = "MMessageConfigDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MMessageConfig WHERE  ID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getID());
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
/*  86 */       tError.moduleName = "MMessageConfigDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MMessageConfig SET  ID = ? , ManageCom = ? , BranchType = ? , MessageType = ? , MessageName = ? , MessageContent = ? , MessageContent2 = ? , MessageContent3 = ? , MessageContent4 = ? , MessageContent5 = ? , MessageContent6 = ? , BeforeDays = ? , StatDays = ? , StartDate = ? , EndDate = ? , StatCycle = ? , Script = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 138 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 143 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getMessageType());
/*     */         }
/* 148 */         if ((get(i).getMessageName() == null) || (get(i).getMessageName().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMessageName());
/*     */         }
/* 153 */         if ((get(i).getMessageContent() == null) || (get(i).getMessageContent().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMessageContent());
/*     */         }
/* 158 */         if ((get(i).getMessageContent2() == null) || (get(i).getMessageContent2().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getMessageContent2());
/*     */         }
/* 163 */         if ((get(i).getMessageContent3() == null) || (get(i).getMessageContent3().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getMessageContent3());
/*     */         }
/* 168 */         if ((get(i).getMessageContent4() == null) || (get(i).getMessageContent4().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getMessageContent4());
/*     */         }
/* 173 */         if ((get(i).getMessageContent5() == null) || (get(i).getMessageContent5().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getMessageContent5());
/*     */         }
/* 178 */         if ((get(i).getMessageContent6() == null) || (get(i).getMessageContent6().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getMessageContent6());
/*     */         }
/* 183 */         pstmt.setInt(12, get(i).getBeforeDays());
/* 184 */         pstmt.setInt(13, get(i).getStatDays());
/* 185 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 186 */           pstmt.setDate(14, null);
/*     */         else {
/* 188 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 190 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 191 */           pstmt.setDate(15, null);
/*     */         else {
/* 193 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 195 */         if ((get(i).getStatCycle() == null) || (get(i).getStatCycle().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getStatCycle());
/*     */         }
/* 200 */         if ((get(i).getScript() == null) || (get(i).getScript().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getScript());
/*     */         }
/* 205 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 210 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 215 */         pstmt.setInt(20, get(i).getIF01());
/* 216 */         pstmt.setDouble(21, get(i).getDF02());
/* 217 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 218 */           pstmt.setDate(22, null);
/*     */         else {
/* 220 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 222 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 223 */           pstmt.setString(23, null);
/*     */         else {
/* 225 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 227 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 228 */           pstmt.setDate(24, null);
/*     */         else {
/* 230 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 232 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 233 */           pstmt.setString(25, null);
/*     */         else {
/* 235 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/*     */ 
/* 238 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 239 */           pstmt.setString(26, null);
/*     */         else {
/* 241 */           pstmt.setString(26, get(i).getID());
/*     */         }
/* 243 */         pstmt.addBatch();
/*     */       }
/* 245 */       pstmt.executeBatch();
/* 246 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 249 */       ex.printStackTrace();
/* 250 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 251 */       CError tError = new CError();
/* 252 */       tError.moduleName = "MMessageConfigDBSet";
/* 253 */       tError.functionName = "update()";
/* 254 */       tError.errorMessage = ex.toString();
/* 255 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 258 */         pstmt.close(); } catch (Exception e) {
/* 259 */         e.printStackTrace();
/*     */       }
/* 261 */       if (!this.mflag) {
/*     */         try {
/* 263 */           this.con.close(); } catch (Exception e) {
/* 264 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 267 */       return false;
/*     */     }
/*     */ 
/* 270 */     if (!this.mflag) {
/*     */       try {
/* 272 */         this.con.close(); } catch (Exception e) {
/* 273 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 282 */     PreparedStatement pstmt = null;
/*     */ 
/* 284 */     if (!this.mflag) {
/* 285 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 290 */       int tCount = size();
/* 291 */       pstmt = this.con.prepareStatement("INSERT INTO MMessageConfig VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 292 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 294 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 295 */           pstmt.setString(1, null);
/*     */         else {
/* 297 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 299 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 300 */           pstmt.setString(2, null);
/*     */         else {
/* 302 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 304 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 305 */           pstmt.setString(3, null);
/*     */         else {
/* 307 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 309 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 310 */           pstmt.setString(4, null);
/*     */         else {
/* 312 */           pstmt.setString(4, get(i).getMessageType());
/*     */         }
/* 314 */         if ((get(i).getMessageName() == null) || (get(i).getMessageName().equals("null")))
/* 315 */           pstmt.setString(5, null);
/*     */         else {
/* 317 */           pstmt.setString(5, get(i).getMessageName());
/*     */         }
/* 319 */         if ((get(i).getMessageContent() == null) || (get(i).getMessageContent().equals("null")))
/* 320 */           pstmt.setString(6, null);
/*     */         else {
/* 322 */           pstmt.setString(6, get(i).getMessageContent());
/*     */         }
/* 324 */         if ((get(i).getMessageContent2() == null) || (get(i).getMessageContent2().equals("null")))
/* 325 */           pstmt.setString(7, null);
/*     */         else {
/* 327 */           pstmt.setString(7, get(i).getMessageContent2());
/*     */         }
/* 329 */         if ((get(i).getMessageContent3() == null) || (get(i).getMessageContent3().equals("null")))
/* 330 */           pstmt.setString(8, null);
/*     */         else {
/* 332 */           pstmt.setString(8, get(i).getMessageContent3());
/*     */         }
/* 334 */         if ((get(i).getMessageContent4() == null) || (get(i).getMessageContent4().equals("null")))
/* 335 */           pstmt.setString(9, null);
/*     */         else {
/* 337 */           pstmt.setString(9, get(i).getMessageContent4());
/*     */         }
/* 339 */         if ((get(i).getMessageContent5() == null) || (get(i).getMessageContent5().equals("null")))
/* 340 */           pstmt.setString(10, null);
/*     */         else {
/* 342 */           pstmt.setString(10, get(i).getMessageContent5());
/*     */         }
/* 344 */         if ((get(i).getMessageContent6() == null) || (get(i).getMessageContent6().equals("null")))
/* 345 */           pstmt.setString(11, null);
/*     */         else {
/* 347 */           pstmt.setString(11, get(i).getMessageContent6());
/*     */         }
/* 349 */         pstmt.setInt(12, get(i).getBeforeDays());
/* 350 */         pstmt.setInt(13, get(i).getStatDays());
/* 351 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 352 */           pstmt.setDate(14, null);
/*     */         else {
/* 354 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 356 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 357 */           pstmt.setDate(15, null);
/*     */         else {
/* 359 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 361 */         if ((get(i).getStatCycle() == null) || (get(i).getStatCycle().equals("null")))
/* 362 */           pstmt.setString(16, null);
/*     */         else {
/* 364 */           pstmt.setString(16, get(i).getStatCycle());
/*     */         }
/* 366 */         if ((get(i).getScript() == null) || (get(i).getScript().equals("null")))
/* 367 */           pstmt.setString(17, null);
/*     */         else {
/* 369 */           pstmt.setString(17, get(i).getScript());
/*     */         }
/* 371 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 372 */           pstmt.setString(18, null);
/*     */         else {
/* 374 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 376 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 377 */           pstmt.setString(19, null);
/*     */         else {
/* 379 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 381 */         pstmt.setInt(20, get(i).getIF01());
/* 382 */         pstmt.setDouble(21, get(i).getDF02());
/* 383 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 384 */           pstmt.setDate(22, null);
/*     */         else {
/* 386 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 388 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 389 */           pstmt.setString(23, null);
/*     */         else {
/* 391 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 393 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 394 */           pstmt.setDate(24, null);
/*     */         else {
/* 396 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 398 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 399 */           pstmt.setString(25, null);
/*     */         else {
/* 401 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 403 */         pstmt.addBatch();
/*     */       }
/* 405 */       pstmt.executeBatch();
/* 406 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 409 */       ex.printStackTrace();
/* 410 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 411 */       CError tError = new CError();
/* 412 */       tError.moduleName = "MMessageConfigDBSet";
/* 413 */       tError.functionName = "insert()";
/* 414 */       tError.errorMessage = ex.toString();
/* 415 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 418 */         pstmt.close(); } catch (Exception e) {
/* 419 */         e.printStackTrace();
/*     */       }
/* 421 */       if (!this.mflag) {
/*     */         try {
/* 423 */           this.con.close(); } catch (Exception e) {
/* 424 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 427 */       return false;
/*     */     }
/*     */ 
/* 430 */     if (!this.mflag) {
/*     */       try {
/* 432 */         this.con.close(); } catch (Exception e) {
/* 433 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 436 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MMessageConfigDBSet
 * JD-Core Version:    0.6.0
 */