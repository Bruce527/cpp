/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHomePictureSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHomePictureSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHomePictureDBSet extends MHomePictureSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHomePictureDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHomePicture");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHomePictureDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHomePicture");
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
/*  49 */     tError.moduleName = "MHomePictureDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePicture WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MHomePictureDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHomePicture SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
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
/* 231 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 232 */           pstmt.setString(24, null);
/*     */         else {
/* 234 */           pstmt.setString(24, get(i).getDescription());
/*     */         }
/*     */ 
/* 237 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 238 */           pstmt.setString(25, null);
/*     */         else {
/* 240 */           pstmt.setString(25, get(i).getID());
/*     */         }
/* 242 */         pstmt.addBatch();
/*     */       }
/* 244 */       pstmt.executeBatch();
/* 245 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 248 */       ex.printStackTrace();
/* 249 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 250 */       CError tError = new CError();
/* 251 */       tError.moduleName = "MHomePictureDBSet";
/* 252 */       tError.functionName = "update()";
/* 253 */       tError.errorMessage = ex.toString();
/* 254 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 257 */         pstmt.close(); } catch (Exception e) {
/* 258 */         e.printStackTrace();
/*     */       }
/* 260 */       if (!this.mflag) {
/*     */         try {
/* 262 */           this.con.close(); } catch (Exception e) {
/* 263 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 266 */       return false;
/*     */     }
/*     */ 
/* 269 */     if (!this.mflag) {
/*     */       try {
/* 271 */         this.con.close(); } catch (Exception e) {
/* 272 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 281 */     PreparedStatement pstmt = null;
/*     */ 
/* 283 */     if (!this.mflag) {
/* 284 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 289 */       int tCount = size();
/* 290 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePicture VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 291 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 293 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 294 */           pstmt.setString(1, null);
/*     */         else {
/* 296 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 298 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 299 */           pstmt.setString(2, null);
/*     */         else {
/* 301 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 303 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 304 */           pstmt.setString(3, null);
/*     */         else {
/* 306 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 308 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 309 */           pstmt.setString(4, null);
/*     */         else {
/* 311 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 313 */         if ((get(i).getAlt() == null) || (get(i).getAlt().equals("null")))
/* 314 */           pstmt.setString(5, null);
/*     */         else {
/* 316 */           pstmt.setString(5, get(i).getAlt());
/*     */         }
/* 318 */         pstmt.setInt(6, get(i).getPicOrder());
/* 319 */         if ((get(i).getDisplayFlag() == null) || (get(i).getDisplayFlag().equals("null")))
/* 320 */           pstmt.setString(7, null);
/*     */         else {
/* 322 */           pstmt.setString(7, get(i).getDisplayFlag());
/*     */         }
/* 324 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 325 */           pstmt.setString(8, null);
/*     */         else {
/* 327 */           pstmt.setString(8, get(i).getCheckState());
/*     */         }
/* 329 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 330 */           pstmt.setString(9, null);
/*     */         else {
/* 332 */           pstmt.setString(9, get(i).getCheckOperator());
/*     */         }
/* 334 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 335 */           pstmt.setString(10, null);
/*     */         else {
/* 337 */           pstmt.setString(10, get(i).getCheckReason());
/*     */         }
/* 339 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 340 */           pstmt.setDate(11, null);
/*     */         else {
/* 342 */           pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 344 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 345 */           pstmt.setString(12, null);
/*     */         else {
/* 347 */           pstmt.setString(12, get(i).getCheckTime());
/*     */         }
/* 349 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 350 */           pstmt.setString(13, null);
/*     */         else {
/* 352 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 354 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 355 */           pstmt.setString(14, null);
/*     */         else {
/* 357 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 359 */         pstmt.setInt(15, get(i).getIF01());
/* 360 */         pstmt.setDouble(16, get(i).getDF02());
/* 361 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 362 */           pstmt.setDate(17, null);
/*     */         else {
/* 364 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 366 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 367 */           pstmt.setString(18, null);
/*     */         else {
/* 369 */           pstmt.setString(18, get(i).getModifyOperator());
/*     */         }
/* 371 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 372 */           pstmt.setString(19, null);
/*     */         else {
/* 374 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 376 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 377 */           pstmt.setDate(20, null);
/*     */         else {
/* 379 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 381 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 382 */           pstmt.setString(21, null);
/*     */         else {
/* 384 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 386 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 387 */           pstmt.setDate(22, null);
/*     */         else {
/* 389 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 391 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 392 */           pstmt.setString(23, null);
/*     */         else {
/* 394 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 396 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 397 */           pstmt.setString(24, null);
/*     */         else {
/* 399 */           pstmt.setString(24, get(i).getDescription());
/*     */         }
/* 401 */         pstmt.addBatch();
/*     */       }
/* 403 */       pstmt.executeBatch();
/* 404 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 407 */       ex.printStackTrace();
/* 408 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 409 */       CError tError = new CError();
/* 410 */       tError.moduleName = "MHomePictureDBSet";
/* 411 */       tError.functionName = "insert()";
/* 412 */       tError.errorMessage = ex.toString();
/* 413 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 416 */         pstmt.close(); } catch (Exception e) {
/* 417 */         e.printStackTrace();
/*     */       }
/* 419 */       if (!this.mflag) {
/*     */         try {
/* 421 */           this.con.close(); } catch (Exception e) {
/* 422 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 425 */       return false;
/*     */     }
/*     */ 
/* 428 */     if (!this.mflag) {
/*     */       try {
/* 430 */         this.con.close(); } catch (Exception e) {
/* 431 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHomePictureDBSet
 * JD-Core Version:    0.6.0
 */