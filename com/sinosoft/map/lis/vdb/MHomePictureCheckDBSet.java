/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHomePictureCheckSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHomePictureCheckSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHomePictureCheckDBSet extends MHomePictureCheckSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHomePictureCheckDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHomePictureCheck");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHomePictureCheckDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHomePictureCheck");
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
/*  49 */     tError.moduleName = "MHomePictureCheckDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePictureCheck WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MHomePictureCheckDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHomePictureCheck SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 138 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 143 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 148 */         if ((get(i).getAlt() == null) || (get(i).getAlt().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getAlt());
/*     */         }
/* 153 */         pstmt.setInt(6, get(i).getPicOrder());
/* 154 */         if ((get(i).getDisplayFlag() == null) || (get(i).getDisplayFlag().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getDisplayFlag());
/*     */         }
/* 159 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getCheckState());
/*     */         }
/* 164 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getCheckOperator());
/*     */         }
/* 169 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getCheckReason());
/*     */         }
/* 174 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 175 */           pstmt.setDate(11, null);
/*     */         else {
/* 177 */           pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 179 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getCheckTime());
/*     */         }
/* 184 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 189 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 194 */         pstmt.setInt(15, get(i).getIF01());
/* 195 */         pstmt.setDouble(16, get(i).getDF02());
/* 196 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 197 */           pstmt.setDate(17, null);
/*     */         else {
/* 199 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 201 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 202 */           pstmt.setString(18, null);
/*     */         else {
/* 204 */           pstmt.setString(18, get(i).getModifyOperator());
/*     */         }
/* 206 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 207 */           pstmt.setString(19, null);
/*     */         else {
/* 209 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 211 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 212 */           pstmt.setDate(20, null);
/*     */         else {
/* 214 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 216 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 217 */           pstmt.setString(21, null);
/*     */         else {
/* 219 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 221 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 222 */           pstmt.setDate(22, null);
/*     */         else {
/* 224 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 226 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 227 */           pstmt.setString(23, null);
/*     */         else {
/* 229 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 232 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 233 */           pstmt.setString(24, null);
/*     */         else {
/* 235 */           pstmt.setString(24, get(i).getID());
/*     */         }
/* 237 */         pstmt.addBatch();
/*     */       }
/* 239 */       pstmt.executeBatch();
/* 240 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 243 */       ex.printStackTrace();
/* 244 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 245 */       CError tError = new CError();
/* 246 */       tError.moduleName = "MHomePictureCheckDBSet";
/* 247 */       tError.functionName = "update()";
/* 248 */       tError.errorMessage = ex.toString();
/* 249 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 252 */         pstmt.close(); } catch (Exception e) {
/* 253 */         e.printStackTrace();
/*     */       }
/* 255 */       if (!this.mflag) {
/*     */         try {
/* 257 */           this.con.close(); } catch (Exception e) {
/* 258 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 261 */       return false;
/*     */     }
/*     */ 
/* 264 */     if (!this.mflag) {
/*     */       try {
/* 266 */         this.con.close(); } catch (Exception e) {
/* 267 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 276 */     PreparedStatement pstmt = null;
/*     */ 
/* 278 */     if (!this.mflag) {
/* 279 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 284 */       int tCount = size();
/* 285 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePictureCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 286 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 288 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 289 */           pstmt.setString(1, null);
/*     */         else {
/* 291 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 293 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 294 */           pstmt.setString(2, null);
/*     */         else {
/* 296 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 298 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 299 */           pstmt.setString(3, null);
/*     */         else {
/* 301 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 303 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 304 */           pstmt.setString(4, null);
/*     */         else {
/* 306 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 308 */         if ((get(i).getAlt() == null) || (get(i).getAlt().equals("null")))
/* 309 */           pstmt.setString(5, null);
/*     */         else {
/* 311 */           pstmt.setString(5, get(i).getAlt());
/*     */         }
/* 313 */         pstmt.setInt(6, get(i).getPicOrder());
/* 314 */         if ((get(i).getDisplayFlag() == null) || (get(i).getDisplayFlag().equals("null")))
/* 315 */           pstmt.setString(7, null);
/*     */         else {
/* 317 */           pstmt.setString(7, get(i).getDisplayFlag());
/*     */         }
/* 319 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 320 */           pstmt.setString(8, null);
/*     */         else {
/* 322 */           pstmt.setString(8, get(i).getCheckState());
/*     */         }
/* 324 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 325 */           pstmt.setString(9, null);
/*     */         else {
/* 327 */           pstmt.setString(9, get(i).getCheckOperator());
/*     */         }
/* 329 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 330 */           pstmt.setString(10, null);
/*     */         else {
/* 332 */           pstmt.setString(10, get(i).getCheckReason());
/*     */         }
/* 334 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 335 */           pstmt.setDate(11, null);
/*     */         else {
/* 337 */           pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 339 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 340 */           pstmt.setString(12, null);
/*     */         else {
/* 342 */           pstmt.setString(12, get(i).getCheckTime());
/*     */         }
/* 344 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 345 */           pstmt.setString(13, null);
/*     */         else {
/* 347 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 349 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 350 */           pstmt.setString(14, null);
/*     */         else {
/* 352 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 354 */         pstmt.setInt(15, get(i).getIF01());
/* 355 */         pstmt.setDouble(16, get(i).getDF02());
/* 356 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 357 */           pstmt.setDate(17, null);
/*     */         else {
/* 359 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 361 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 362 */           pstmt.setString(18, null);
/*     */         else {
/* 364 */           pstmt.setString(18, get(i).getModifyOperator());
/*     */         }
/* 366 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 367 */           pstmt.setString(19, null);
/*     */         else {
/* 369 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 371 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 372 */           pstmt.setDate(20, null);
/*     */         else {
/* 374 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 376 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 377 */           pstmt.setString(21, null);
/*     */         else {
/* 379 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 381 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 382 */           pstmt.setDate(22, null);
/*     */         else {
/* 384 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 386 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 387 */           pstmt.setString(23, null);
/*     */         else {
/* 389 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 391 */         pstmt.addBatch();
/*     */       }
/* 393 */       pstmt.executeBatch();
/* 394 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 397 */       ex.printStackTrace();
/* 398 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 399 */       CError tError = new CError();
/* 400 */       tError.moduleName = "MHomePictureCheckDBSet";
/* 401 */       tError.functionName = "insert()";
/* 402 */       tError.errorMessage = ex.toString();
/* 403 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 406 */         pstmt.close(); } catch (Exception e) {
/* 407 */         e.printStackTrace();
/*     */       }
/* 409 */       if (!this.mflag) {
/*     */         try {
/* 411 */           this.con.close(); } catch (Exception e) {
/* 412 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 415 */       return false;
/*     */     }
/*     */ 
/* 418 */     if (!this.mflag) {
/*     */       try {
/* 420 */         this.con.close(); } catch (Exception e) {
/* 421 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 424 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHomePictureCheckDBSet
 * JD-Core Version:    0.6.0
 */