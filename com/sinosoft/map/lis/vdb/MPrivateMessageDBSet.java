/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MPrivateMessageDBSet extends MPrivateMessageSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MPrivateMessageDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MPrivateMessage");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MPrivateMessageDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MPrivateMessage");
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
/*  49 */     tError.moduleName = "MPrivateMessageDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MPrivateMessage WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MPrivateMessageDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MPrivateMessage SET  ID = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getAgentCode());
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
/* 148 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMessage());
/*     */         }
/* 153 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMessageType());
/*     */         }
/* 158 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getKeyData());
/*     */         }
/* 163 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getKeyData2());
/*     */         }
/* 168 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getKeyData3());
/*     */         }
/* 173 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getKeyData4());
/*     */         }
/* 178 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getURL());
/*     */         }
/* 183 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 188 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getState());
/*     */         }
/* 193 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 194 */           pstmt.setDate(14, null);
/*     */         else {
/* 196 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 198 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 199 */           pstmt.setDate(15, null);
/*     */         else {
/* 201 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 203 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getStartTime());
/*     */         }
/* 208 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getEndTime());
/*     */         }
/* 213 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 218 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 223 */         pstmt.setInt(20, get(i).getIF01());
/* 224 */         pstmt.setDouble(21, get(i).getDF02());
/* 225 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 226 */           pstmt.setDate(22, null);
/*     */         else {
/* 228 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 230 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 231 */           pstmt.setString(23, null);
/*     */         else {
/* 233 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 235 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 236 */           pstmt.setDate(24, null);
/*     */         else {
/* 238 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 240 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/*     */ 
/* 246 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 247 */           pstmt.setString(26, null);
/*     */         else {
/* 249 */           pstmt.setString(26, get(i).getID());
/*     */         }
/* 251 */         pstmt.addBatch();
/*     */       }
/* 253 */       pstmt.executeBatch();
/* 254 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 257 */       ex.printStackTrace();
/* 258 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 259 */       CError tError = new CError();
/* 260 */       tError.moduleName = "MPrivateMessageDBSet";
/* 261 */       tError.functionName = "update()";
/* 262 */       tError.errorMessage = ex.toString();
/* 263 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 266 */         pstmt.close(); } catch (Exception e) {
/* 267 */         e.printStackTrace();
/*     */       }
/* 269 */       if (!this.mflag) {
/*     */         try {
/* 271 */           this.con.close(); } catch (Exception e) {
/* 272 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 275 */       return false;
/*     */     }
/*     */ 
/* 278 */     if (!this.mflag) {
/*     */       try {
/* 280 */         this.con.close(); } catch (Exception e) {
/* 281 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 290 */     PreparedStatement pstmt = null;
/*     */ 
/* 292 */     if (!this.mflag) {
/* 293 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 298 */       int tCount = size();
/* 299 */       pstmt = this.con.prepareStatement("INSERT INTO MPrivateMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 300 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 302 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 303 */           pstmt.setString(1, null);
/*     */         else {
/* 305 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 307 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 308 */           pstmt.setString(2, null);
/*     */         else {
/* 310 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 312 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 313 */           pstmt.setString(3, null);
/*     */         else {
/* 315 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 317 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 318 */           pstmt.setString(4, null);
/*     */         else {
/* 320 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 322 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 323 */           pstmt.setString(5, null);
/*     */         else {
/* 325 */           pstmt.setString(5, get(i).getMessage());
/*     */         }
/* 327 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 328 */           pstmt.setString(6, null);
/*     */         else {
/* 330 */           pstmt.setString(6, get(i).getMessageType());
/*     */         }
/* 332 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 333 */           pstmt.setString(7, null);
/*     */         else {
/* 335 */           pstmt.setString(7, get(i).getKeyData());
/*     */         }
/* 337 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 338 */           pstmt.setString(8, null);
/*     */         else {
/* 340 */           pstmt.setString(8, get(i).getKeyData2());
/*     */         }
/* 342 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 343 */           pstmt.setString(9, null);
/*     */         else {
/* 345 */           pstmt.setString(9, get(i).getKeyData3());
/*     */         }
/* 347 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 348 */           pstmt.setString(10, null);
/*     */         else {
/* 350 */           pstmt.setString(10, get(i).getKeyData4());
/*     */         }
/* 352 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 353 */           pstmt.setString(11, null);
/*     */         else {
/* 355 */           pstmt.setString(11, get(i).getURL());
/*     */         }
/* 357 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 358 */           pstmt.setString(12, null);
/*     */         else {
/* 360 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 362 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 363 */           pstmt.setString(13, null);
/*     */         else {
/* 365 */           pstmt.setString(13, get(i).getState());
/*     */         }
/* 367 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 368 */           pstmt.setDate(14, null);
/*     */         else {
/* 370 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 372 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 373 */           pstmt.setDate(15, null);
/*     */         else {
/* 375 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 377 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 378 */           pstmt.setString(16, null);
/*     */         else {
/* 380 */           pstmt.setString(16, get(i).getStartTime());
/*     */         }
/* 382 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 383 */           pstmt.setString(17, null);
/*     */         else {
/* 385 */           pstmt.setString(17, get(i).getEndTime());
/*     */         }
/* 387 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 388 */           pstmt.setString(18, null);
/*     */         else {
/* 390 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 392 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 393 */           pstmt.setString(19, null);
/*     */         else {
/* 395 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 397 */         pstmt.setInt(20, get(i).getIF01());
/* 398 */         pstmt.setDouble(21, get(i).getDF02());
/* 399 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 400 */           pstmt.setDate(22, null);
/*     */         else {
/* 402 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 404 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 405 */           pstmt.setString(23, null);
/*     */         else {
/* 407 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 409 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 410 */           pstmt.setDate(24, null);
/*     */         else {
/* 412 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 414 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 415 */           pstmt.setString(25, null);
/*     */         else {
/* 417 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 419 */         pstmt.addBatch();
/*     */       }
/* 421 */       pstmt.executeBatch();
/* 422 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 425 */       ex.printStackTrace();
/* 426 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 427 */       CError tError = new CError();
/* 428 */       tError.moduleName = "MPrivateMessageDBSet";
/* 429 */       tError.functionName = "insert()";
/* 430 */       tError.errorMessage = ex.toString();
/* 431 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 434 */         pstmt.close(); } catch (Exception e) {
/* 435 */         e.printStackTrace();
/*     */       }
/* 437 */       if (!this.mflag) {
/*     */         try {
/* 439 */           this.con.close(); } catch (Exception e) {
/* 440 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 443 */       return false;
/*     */     }
/*     */ 
/* 446 */     if (!this.mflag) {
/*     */       try {
/* 448 */         this.con.close(); } catch (Exception e) {
/* 449 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 452 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MPrivateMessageDBSet
 * JD-Core Version:    0.6.0
 */