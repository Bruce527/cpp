/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MC2BMessageSchema;
/*     */ import com.sinosoft.map.lis.vschema.MC2BMessageSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MC2BMessageDBSet extends MC2BMessageSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MC2BMessageDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MC2BMessage");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MC2BMessageDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MC2BMessage");
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
/*  49 */     tError.moduleName = "MC2BMessageDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MC2BMessage WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MC2BMessageDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MC2BMessage SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
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
/* 143 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getMessage());
/*     */         }
/* 148 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMessageType());
/*     */         }
/* 153 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getKeyData());
/*     */         }
/* 158 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getKeyData2());
/*     */         }
/* 163 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getKeyData3());
/*     */         }
/* 168 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getKeyData4());
/*     */         }
/* 173 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getURL());
/*     */         }
/* 178 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getType());
/*     */         }
/* 183 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getState());
/*     */         }
/* 188 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 189 */           pstmt.setDate(13, null);
/*     */         else {
/* 191 */           pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 193 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 194 */           pstmt.setDate(14, null);
/*     */         else {
/* 196 */           pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 198 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getStartTime());
/*     */         }
/* 203 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getEndTime());
/*     */         }
/* 208 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 213 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 218 */         pstmt.setInt(19, get(i).getIF01());
/* 219 */         pstmt.setDouble(20, get(i).getDF02());
/* 220 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 221 */           pstmt.setDate(21, null);
/*     */         else {
/* 223 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 225 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 226 */           pstmt.setString(22, null);
/*     */         else {
/* 228 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 230 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 231 */           pstmt.setDate(23, null);
/*     */         else {
/* 233 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 235 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 236 */           pstmt.setString(24, null);
/*     */         else {
/* 238 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/*     */ 
/* 241 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 242 */           pstmt.setString(25, null);
/*     */         else {
/* 244 */           pstmt.setString(25, get(i).getID());
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
/* 255 */       tError.moduleName = "MC2BMessageDBSet";
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
/* 294 */       pstmt = this.con.prepareStatement("INSERT INTO MC2BMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 295 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 297 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 298 */           pstmt.setString(1, null);
/*     */         else {
/* 300 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 302 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 303 */           pstmt.setString(2, null);
/*     */         else {
/* 305 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 307 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 308 */           pstmt.setString(3, null);
/*     */         else {
/* 310 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 312 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 313 */           pstmt.setString(4, null);
/*     */         else {
/* 315 */           pstmt.setString(4, get(i).getMessage());
/*     */         }
/* 317 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 318 */           pstmt.setString(5, null);
/*     */         else {
/* 320 */           pstmt.setString(5, get(i).getMessageType());
/*     */         }
/* 322 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 323 */           pstmt.setString(6, null);
/*     */         else {
/* 325 */           pstmt.setString(6, get(i).getKeyData());
/*     */         }
/* 327 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 328 */           pstmt.setString(7, null);
/*     */         else {
/* 330 */           pstmt.setString(7, get(i).getKeyData2());
/*     */         }
/* 332 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 333 */           pstmt.setString(8, null);
/*     */         else {
/* 335 */           pstmt.setString(8, get(i).getKeyData3());
/*     */         }
/* 337 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 338 */           pstmt.setString(9, null);
/*     */         else {
/* 340 */           pstmt.setString(9, get(i).getKeyData4());
/*     */         }
/* 342 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 343 */           pstmt.setString(10, null);
/*     */         else {
/* 345 */           pstmt.setString(10, get(i).getURL());
/*     */         }
/* 347 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 348 */           pstmt.setString(11, null);
/*     */         else {
/* 350 */           pstmt.setString(11, get(i).getType());
/*     */         }
/* 352 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 353 */           pstmt.setString(12, null);
/*     */         else {
/* 355 */           pstmt.setString(12, get(i).getState());
/*     */         }
/* 357 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 358 */           pstmt.setDate(13, null);
/*     */         else {
/* 360 */           pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 362 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 363 */           pstmt.setDate(14, null);
/*     */         else {
/* 365 */           pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 367 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 368 */           pstmt.setString(15, null);
/*     */         else {
/* 370 */           pstmt.setString(15, get(i).getStartTime());
/*     */         }
/* 372 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 373 */           pstmt.setString(16, null);
/*     */         else {
/* 375 */           pstmt.setString(16, get(i).getEndTime());
/*     */         }
/* 377 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 378 */           pstmt.setString(17, null);
/*     */         else {
/* 380 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 382 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 383 */           pstmt.setString(18, null);
/*     */         else {
/* 385 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 387 */         pstmt.setInt(19, get(i).getIF01());
/* 388 */         pstmt.setDouble(20, get(i).getDF02());
/* 389 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 390 */           pstmt.setDate(21, null);
/*     */         else {
/* 392 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 394 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 395 */           pstmt.setString(22, null);
/*     */         else {
/* 397 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 399 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 400 */           pstmt.setDate(23, null);
/*     */         else {
/* 402 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 404 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 405 */           pstmt.setString(24, null);
/*     */         else {
/* 407 */           pstmt.setString(24, get(i).getMakeTime());
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
/* 418 */       tError.moduleName = "MC2BMessageDBSet";
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
 * Qualified Name:     com.sinosoft.map.lis.vdb.MC2BMessageDBSet
 * JD-Core Version:    0.6.0
 */