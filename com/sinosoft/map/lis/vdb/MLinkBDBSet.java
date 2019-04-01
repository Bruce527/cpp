/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLinkBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLinkBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLinkBDBSet extends MLinkBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MLinkBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MLinkB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLinkBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MLinkB");
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
/*  49 */     tError.moduleName = "MLinkBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MLinkB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MLinkBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MLinkB SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , AgentCode = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getRefURL());
/*     */         }
/* 138 */         if ((get(i).getTarget() == null) || (get(i).getTarget().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getTarget());
/*     */         }
/* 143 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 148 */         pstmt.setInt(5, get(i).getLinkOrder());
/* 149 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 150 */           pstmt.setString(6, null);
/*     */         else {
/* 152 */           pstmt.setString(6, get(i).getState());
/*     */         }
/* 154 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getType());
/*     */         }
/* 159 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getAgentCode());
/*     */         }
/* 164 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getIcon());
/*     */         }
/* 169 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getManageCom());
/*     */         }
/* 174 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getBranchType());
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
/* 190 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 191 */           pstmt.setString(17, null);
/*     */         else {
/* 193 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 195 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 196 */           pstmt.setString(18, null);
/*     */         else {
/* 198 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 200 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 201 */           pstmt.setString(20, null);
/*     */         else {
/* 203 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 205 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 206 */           pstmt.setString(22, null);
/*     */         else {
/* 208 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/* 210 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 211 */           pstmt.setString(23, null);
/*     */         else {
/* 213 */           pstmt.setString(23, get(i).getDescription());
/*     */         }
/* 215 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 216 */           pstmt.setString(24, null);
/*     */         else {
/* 218 */           pstmt.setString(24, get(i).getEdorNo());
/*     */         }
/* 220 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 221 */           pstmt.setString(25, null);
/*     */         else {
/* 223 */           pstmt.setString(25, get(i).getEdorType());
/*     */         }
/* 225 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 226 */           pstmt.setString(26, null);
/*     */         else {
/* 228 */           pstmt.setString(26, get(i).getEdorCase());
/*     */         }
/* 230 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 231 */           pstmt.setString(27, null);
/*     */         else {
/* 233 */           pstmt.setString(27, get(i).getOperator2());
/*     */         }
/* 235 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 236 */           pstmt.setString(29, null);
/*     */         else {
/* 238 */           pstmt.setString(29, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 241 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 242 */           pstmt.setString(30, null);
/*     */         else {
/* 244 */           pstmt.setString(30, get(i).getEdorNo());
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
/* 255 */       tError.moduleName = "MLinkBDBSet";
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
/* 294 */       pstmt = this.con.prepareStatement("INSERT INTO MLinkB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 295 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 297 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 298 */           pstmt.setString(1, null);
/*     */         else {
/* 300 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 302 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 303 */           pstmt.setString(2, null);
/*     */         else {
/* 305 */           pstmt.setString(2, get(i).getRefURL());
/*     */         }
/* 307 */         if ((get(i).getTarget() == null) || (get(i).getTarget().equals("null")))
/* 308 */           pstmt.setString(3, null);
/*     */         else {
/* 310 */           pstmt.setString(3, get(i).getTarget());
/*     */         }
/* 312 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 313 */           pstmt.setString(4, null);
/*     */         else {
/* 315 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 317 */         pstmt.setInt(5, get(i).getLinkOrder());
/* 318 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 319 */           pstmt.setString(6, null);
/*     */         else {
/* 321 */           pstmt.setString(6, get(i).getState());
/*     */         }
/* 323 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 324 */           pstmt.setString(7, null);
/*     */         else {
/* 326 */           pstmt.setString(7, get(i).getType());
/*     */         }
/* 328 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 329 */           pstmt.setString(8, null);
/*     */         else {
/* 331 */           pstmt.setString(8, get(i).getAgentCode());
/*     */         }
/* 333 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 334 */           pstmt.setString(9, null);
/*     */         else {
/* 336 */           pstmt.setString(9, get(i).getIcon());
/*     */         }
/* 338 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 339 */           pstmt.setString(10, null);
/*     */         else {
/* 341 */           pstmt.setString(10, get(i).getManageCom());
/*     */         }
/* 343 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 344 */           pstmt.setString(11, null);
/*     */         else {
/* 346 */           pstmt.setString(11, get(i).getBranchType());
/*     */         }
/* 348 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 349 */           pstmt.setString(12, null);
/*     */         else {
/* 351 */           pstmt.setString(12, get(i).getVF01());
/*     */         }
/* 353 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 354 */           pstmt.setString(13, null);
/*     */         else {
/* 356 */           pstmt.setString(13, get(i).getNF01());
/*     */         }
/* 358 */         pstmt.setInt(14, get(i).getIF01());
/* 359 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 360 */           pstmt.setString(17, null);
/*     */         else {
/* 362 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 364 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 365 */           pstmt.setString(18, null);
/*     */         else {
/* 367 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 369 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 370 */           pstmt.setString(20, null);
/*     */         else {
/* 372 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 374 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 375 */           pstmt.setString(22, null);
/*     */         else {
/* 377 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/* 379 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 380 */           pstmt.setString(23, null);
/*     */         else {
/* 382 */           pstmt.setString(23, get(i).getDescription());
/*     */         }
/* 384 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 385 */           pstmt.setString(24, null);
/*     */         else {
/* 387 */           pstmt.setString(24, get(i).getEdorNo());
/*     */         }
/* 389 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 390 */           pstmt.setString(25, null);
/*     */         else {
/* 392 */           pstmt.setString(25, get(i).getEdorType());
/*     */         }
/* 394 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 395 */           pstmt.setString(26, null);
/*     */         else {
/* 397 */           pstmt.setString(26, get(i).getEdorCase());
/*     */         }
/* 399 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 400 */           pstmt.setString(27, null);
/*     */         else {
/* 402 */           pstmt.setString(27, get(i).getOperator2());
/*     */         }
/* 404 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 405 */           pstmt.setString(29, null);
/*     */         else {
/* 407 */           pstmt.setString(29, get(i).getMakeTime2());
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
/* 418 */       tError.moduleName = "MLinkBDBSet";
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
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLinkBDBSet
 * JD-Core Version:    0.6.0
 */