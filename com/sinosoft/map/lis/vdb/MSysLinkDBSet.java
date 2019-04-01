/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MSysLinkSchema;
/*     */ import com.sinosoft.map.lis.vschema.MSysLinkSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MSysLinkDBSet extends MSysLinkSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MSysLinkDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MSysLink");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MSysLinkDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MSysLink");
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
/*  49 */     tError.moduleName = "MSysLinkDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MSysLink WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MSysLinkDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MSysLink SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
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
/* 159 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getIcon());
/*     */         }
/* 164 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 169 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getBranchType());
/*     */         }
/* 174 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getVF01());
/*     */         }
/* 179 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getNF01());
/*     */         }
/* 184 */         pstmt.setInt(13, get(i).getIF01());
/* 185 */         pstmt.setDouble(14, get(i).getDF02());
/* 186 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 187 */           pstmt.setDate(15, null);
/*     */         else {
/* 189 */           pstmt.setDate(15, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 191 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 192 */           pstmt.setString(16, null);
/*     */         else {
/* 194 */           pstmt.setString(16, get(i).getModifyOperator());
/*     */         }
/* 196 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 197 */           pstmt.setString(17, null);
/*     */         else {
/* 199 */           pstmt.setString(17, get(i).getOperator());
/*     */         }
/* 201 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 202 */           pstmt.setDate(18, null);
/*     */         else {
/* 204 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 206 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 207 */           pstmt.setString(19, null);
/*     */         else {
/* 209 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 211 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 212 */           pstmt.setDate(20, null);
/*     */         else {
/* 214 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 216 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 217 */           pstmt.setString(21, null);
/*     */         else {
/* 219 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/* 221 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 222 */           pstmt.setString(22, null);
/*     */         else {
/* 224 */           pstmt.setString(22, get(i).getDescription());
/*     */         }
/*     */ 
/* 227 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 228 */           pstmt.setString(23, null);
/*     */         else {
/* 230 */           pstmt.setString(23, get(i).getID());
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
/* 241 */       tError.moduleName = "MSysLinkDBSet";
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
/* 280 */       pstmt = this.con.prepareStatement("INSERT INTO MSysLink VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 281 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 283 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 284 */           pstmt.setString(1, null);
/*     */         else {
/* 286 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 288 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 289 */           pstmt.setString(2, null);
/*     */         else {
/* 291 */           pstmt.setString(2, get(i).getRefURL());
/*     */         }
/* 293 */         if ((get(i).getTarget() == null) || (get(i).getTarget().equals("null")))
/* 294 */           pstmt.setString(3, null);
/*     */         else {
/* 296 */           pstmt.setString(3, get(i).getTarget());
/*     */         }
/* 298 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 299 */           pstmt.setString(4, null);
/*     */         else {
/* 301 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 303 */         pstmt.setInt(5, get(i).getLinkOrder());
/* 304 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 305 */           pstmt.setString(6, null);
/*     */         else {
/* 307 */           pstmt.setString(6, get(i).getState());
/*     */         }
/* 309 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 310 */           pstmt.setString(7, null);
/*     */         else {
/* 312 */           pstmt.setString(7, get(i).getType());
/*     */         }
/* 314 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 315 */           pstmt.setString(8, null);
/*     */         else {
/* 317 */           pstmt.setString(8, get(i).getIcon());
/*     */         }
/* 319 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 320 */           pstmt.setString(9, null);
/*     */         else {
/* 322 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 324 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 325 */           pstmt.setString(10, null);
/*     */         else {
/* 327 */           pstmt.setString(10, get(i).getBranchType());
/*     */         }
/* 329 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 330 */           pstmt.setString(11, null);
/*     */         else {
/* 332 */           pstmt.setString(11, get(i).getVF01());
/*     */         }
/* 334 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 335 */           pstmt.setString(12, null);
/*     */         else {
/* 337 */           pstmt.setString(12, get(i).getNF01());
/*     */         }
/* 339 */         pstmt.setInt(13, get(i).getIF01());
/* 340 */         pstmt.setDouble(14, get(i).getDF02());
/* 341 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 342 */           pstmt.setDate(15, null);
/*     */         else {
/* 344 */           pstmt.setDate(15, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 346 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 347 */           pstmt.setString(16, null);
/*     */         else {
/* 349 */           pstmt.setString(16, get(i).getModifyOperator());
/*     */         }
/* 351 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 352 */           pstmt.setString(17, null);
/*     */         else {
/* 354 */           pstmt.setString(17, get(i).getOperator());
/*     */         }
/* 356 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 357 */           pstmt.setDate(18, null);
/*     */         else {
/* 359 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 361 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 362 */           pstmt.setString(19, null);
/*     */         else {
/* 364 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 366 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 367 */           pstmt.setDate(20, null);
/*     */         else {
/* 369 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 371 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 372 */           pstmt.setString(21, null);
/*     */         else {
/* 374 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/* 376 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 377 */           pstmt.setString(22, null);
/*     */         else {
/* 379 */           pstmt.setString(22, get(i).getDescription());
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
/* 390 */       tError.moduleName = "MSysLinkDBSet";
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
 * Qualified Name:     com.sinosoft.map.lis.vdb.MSysLinkDBSet
 * JD-Core Version:    0.6.0
 */