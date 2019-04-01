/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MUserDBSet extends MUserSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MUserDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MUser");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MUser");
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
/*  49 */     tError.moduleName = "MUserDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MUser WHERE  UserCode = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getUserCode());
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
/*  86 */       tError.moduleName = "MUserDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MUser SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  UserCode = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getUserCode());
/*     */         }
/* 133 */         if ((get(i).getUserName() == null) || (get(i).getUserName().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getUserName());
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
/* 148 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getPassword());
/*     */         }
/* 153 */         if ((get(i).getPwdModifyDate() == null) || (get(i).getPwdModifyDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
/*     */         }
/* 158 */         if ((get(i).getUserDescription() == null) || (get(i).getUserDescription().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getUserDescription());
/*     */         }
/* 163 */         if ((get(i).getUserState() == null) || (get(i).getUserState().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getUserState());
/*     */         }
/* 168 */         if ((get(i).getSuperPopedomFlag() == null) || (get(i).getSuperPopedomFlag().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getSuperPopedomFlag());
/*     */         }
/* 173 */         if ((get(i).getValidStartDate() == null) || (get(i).getValidStartDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
/*     */         }
/* 178 */         if ((get(i).getValidEndDate() == null) || (get(i).getValidEndDate().equals("null")))
/* 179 */           pstmt.setDate(11, null);
/*     */         else {
/* 181 */           pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
/*     */         }
/* 183 */         if ((get(i).getStuffNo() == null) || (get(i).getStuffNo().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getStuffNo());
/*     */         }
/* 188 */         if ((get(i).getOfficePhone() == null) || (get(i).getOfficePhone().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getOfficePhone());
/*     */         }
/* 193 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getPhone());
/*     */         }
/* 198 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getEMail());
/*     */         }
/* 203 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 208 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 213 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 214 */           pstmt.setDate(18, null);
/*     */         else {
/* 216 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 218 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 223 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 224 */           pstmt.setDate(20, null);
/*     */         else {
/* 226 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 228 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 234 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 235 */           pstmt.setString(22, null);
/*     */         else {
/* 237 */           pstmt.setString(22, get(i).getUserCode());
/*     */         }
/* 239 */         pstmt.addBatch();
/*     */       }
/* 241 */       pstmt.executeBatch();
/* 242 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 245 */       ex.printStackTrace();
/* 246 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 247 */       CError tError = new CError();
/* 248 */       tError.moduleName = "MUserDBSet";
/* 249 */       tError.functionName = "update()";
/* 250 */       tError.errorMessage = ex.toString();
/* 251 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 254 */         pstmt.close(); } catch (Exception e) {
/* 255 */         e.printStackTrace();
/*     */       }
/* 257 */       if (!this.mflag) {
/*     */         try {
/* 259 */           this.con.close(); } catch (Exception e) {
/* 260 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 263 */       return false;
/*     */     }
/*     */ 
/* 266 */     if (!this.mflag) {
/*     */       try {
/* 268 */         this.con.close(); } catch (Exception e) {
/* 269 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 272 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 278 */     PreparedStatement pstmt = null;
/*     */ 
/* 280 */     if (!this.mflag) {
/* 281 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 286 */       int tCount = size();
/* 287 */       pstmt = this.con.prepareStatement("INSERT INTO MUser VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 288 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 290 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 291 */           pstmt.setString(1, null);
/*     */         else {
/* 293 */           pstmt.setString(1, get(i).getUserCode());
/*     */         }
/* 295 */         if ((get(i).getUserName() == null) || (get(i).getUserName().equals("null")))
/* 296 */           pstmt.setString(2, null);
/*     */         else {
/* 298 */           pstmt.setString(2, get(i).getUserName());
/*     */         }
/* 300 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 301 */           pstmt.setString(3, null);
/*     */         else {
/* 303 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 305 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 306 */           pstmt.setString(4, null);
/*     */         else {
/* 308 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 310 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 311 */           pstmt.setString(5, null);
/*     */         else {
/* 313 */           pstmt.setString(5, get(i).getPassword());
/*     */         }
/* 315 */         if ((get(i).getPwdModifyDate() == null) || (get(i).getPwdModifyDate().equals("null")))
/* 316 */           pstmt.setDate(6, null);
/*     */         else {
/* 318 */           pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
/*     */         }
/* 320 */         if ((get(i).getUserDescription() == null) || (get(i).getUserDescription().equals("null")))
/* 321 */           pstmt.setString(7, null);
/*     */         else {
/* 323 */           pstmt.setString(7, get(i).getUserDescription());
/*     */         }
/* 325 */         if ((get(i).getUserState() == null) || (get(i).getUserState().equals("null")))
/* 326 */           pstmt.setString(8, null);
/*     */         else {
/* 328 */           pstmt.setString(8, get(i).getUserState());
/*     */         }
/* 330 */         if ((get(i).getSuperPopedomFlag() == null) || (get(i).getSuperPopedomFlag().equals("null")))
/* 331 */           pstmt.setString(9, null);
/*     */         else {
/* 333 */           pstmt.setString(9, get(i).getSuperPopedomFlag());
/*     */         }
/* 335 */         if ((get(i).getValidStartDate() == null) || (get(i).getValidStartDate().equals("null")))
/* 336 */           pstmt.setDate(10, null);
/*     */         else {
/* 338 */           pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
/*     */         }
/* 340 */         if ((get(i).getValidEndDate() == null) || (get(i).getValidEndDate().equals("null")))
/* 341 */           pstmt.setDate(11, null);
/*     */         else {
/* 343 */           pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
/*     */         }
/* 345 */         if ((get(i).getStuffNo() == null) || (get(i).getStuffNo().equals("null")))
/* 346 */           pstmt.setString(12, null);
/*     */         else {
/* 348 */           pstmt.setString(12, get(i).getStuffNo());
/*     */         }
/* 350 */         if ((get(i).getOfficePhone() == null) || (get(i).getOfficePhone().equals("null")))
/* 351 */           pstmt.setString(13, null);
/*     */         else {
/* 353 */           pstmt.setString(13, get(i).getOfficePhone());
/*     */         }
/* 355 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 356 */           pstmt.setString(14, null);
/*     */         else {
/* 358 */           pstmt.setString(14, get(i).getPhone());
/*     */         }
/* 360 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 361 */           pstmt.setString(15, null);
/*     */         else {
/* 363 */           pstmt.setString(15, get(i).getEMail());
/*     */         }
/* 365 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 366 */           pstmt.setString(16, null);
/*     */         else {
/* 368 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 370 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 371 */           pstmt.setString(17, null);
/*     */         else {
/* 373 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 375 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 376 */           pstmt.setDate(18, null);
/*     */         else {
/* 378 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 380 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 381 */           pstmt.setString(19, null);
/*     */         else {
/* 383 */           pstmt.setString(19, get(i).getMakeTime());
/*     */         }
/* 385 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 386 */           pstmt.setDate(20, null);
/*     */         else {
/* 388 */           pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 390 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 391 */           pstmt.setString(21, null);
/*     */         else {
/* 393 */           pstmt.setString(21, get(i).getModifyTime());
/*     */         }
/* 395 */         pstmt.addBatch();
/*     */       }
/* 397 */       pstmt.executeBatch();
/* 398 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 401 */       ex.printStackTrace();
/* 402 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 403 */       CError tError = new CError();
/* 404 */       tError.moduleName = "MUserDBSet";
/* 405 */       tError.functionName = "insert()";
/* 406 */       tError.errorMessage = ex.toString();
/* 407 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 410 */         pstmt.close(); } catch (Exception e) {
/* 411 */         e.printStackTrace();
/*     */       }
/* 413 */       if (!this.mflag) {
/*     */         try {
/* 415 */           this.con.close(); } catch (Exception e) {
/* 416 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 419 */       return false;
/*     */     }
/*     */ 
/* 422 */     if (!this.mflag) {
/*     */       try {
/* 424 */         this.con.close(); } catch (Exception e) {
/* 425 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 428 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MUserDBSet
 * JD-Core Version:    0.6.0
 */