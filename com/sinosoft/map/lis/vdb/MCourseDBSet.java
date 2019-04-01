/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MCourseSchema;
/*     */ import com.sinosoft.map.lis.vschema.MCourseSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MCourseDBSet extends MCourseSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MCourseDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MCourse");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MCourseDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MCourse");
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
/*  49 */     tError.moduleName = "MCourseDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MCourse WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MCourseDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MCourse SET  ID = ? , CourseID = ? , CourseName = ? , ManageCom = ? , BranchType = ? , Hour = ? , DevelopBranch = ? , Developer = ? , DevelopeDate = ? , NoTi = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , course1 = ? , course2 = ? , course3 = ? , course4 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getCourseID() == null) || (get(i).getCourseID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getCourseID());
/*     */         }
/* 138 */         if ((get(i).getCourseName() == null) || (get(i).getCourseName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getCourseName());
/*     */         }
/* 143 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getManageCom());
/*     */         }
/* 148 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getBranchType());
/*     */         }
/* 153 */         if ((get(i).getHour() == null) || (get(i).getHour().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getHour());
/*     */         }
/* 158 */         if ((get(i).getDevelopBranch() == null) || (get(i).getDevelopBranch().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getDevelopBranch());
/*     */         }
/* 163 */         if ((get(i).getDeveloper() == null) || (get(i).getDeveloper().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getDeveloper());
/*     */         }
/* 168 */         if ((get(i).getNoTi() == null) || (get(i).getNoTi().equals("null")))
/* 169 */           pstmt.setString(10, null);
/*     */         else {
/* 171 */           pstmt.setString(10, get(i).getNoTi());
/*     */         }
/* 173 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 174 */           pstmt.setString(11, null);
/*     */         else {
/* 176 */           pstmt.setString(11, get(i).getOperator());
/*     */         }
/* 178 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 179 */           pstmt.setString(12, null);
/*     */         else {
/* 181 */           pstmt.setString(12, get(i).getModifyOperator());
/*     */         }
/* 183 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 184 */           pstmt.setString(14, null);
/*     */         else {
/* 186 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 188 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 189 */           pstmt.setString(16, null);
/*     */         else {
/* 191 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/* 193 */         if ((get(i).getCourse1() == null) || (get(i).getCourse1().equals("null")))
/* 194 */           pstmt.setString(17, null);
/*     */         else {
/* 196 */           pstmt.setString(17, get(i).getCourse1());
/*     */         }
/* 198 */         if ((get(i).getCourse2() == null) || (get(i).getCourse2().equals("null")))
/* 199 */           pstmt.setString(18, null);
/*     */         else {
/* 201 */           pstmt.setString(18, get(i).getCourse2());
/*     */         }
/* 203 */         if ((get(i).getCourse3() == null) || (get(i).getCourse3().equals("null")))
/* 204 */           pstmt.setString(19, null);
/*     */         else {
/* 206 */           pstmt.setString(19, get(i).getCourse3());
/*     */         }
/*     */ 
/* 209 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 210 */           pstmt.setString(21, null);
/*     */         else {
/* 212 */           pstmt.setString(21, get(i).getID());
/*     */         }
/* 214 */         pstmt.addBatch();
/*     */       }
/* 216 */       pstmt.executeBatch();
/* 217 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 220 */       ex.printStackTrace();
/* 221 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 222 */       CError tError = new CError();
/* 223 */       tError.moduleName = "MCourseDBSet";
/* 224 */       tError.functionName = "update()";
/* 225 */       tError.errorMessage = ex.toString();
/* 226 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 229 */         pstmt.close(); } catch (Exception e) {
/* 230 */         e.printStackTrace();
/*     */       }
/* 232 */       if (!this.mflag) {
/*     */         try {
/* 234 */           this.con.close(); } catch (Exception e) {
/* 235 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 238 */       return false;
/*     */     }
/*     */ 
/* 241 */     if (!this.mflag) {
/*     */       try {
/* 243 */         this.con.close(); } catch (Exception e) {
/* 244 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 253 */     PreparedStatement pstmt = null;
/*     */ 
/* 255 */     if (!this.mflag) {
/* 256 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 261 */       int tCount = size();
/* 262 */       pstmt = this.con.prepareStatement("INSERT INTO MCourse VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 263 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 265 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 266 */           pstmt.setString(1, null);
/*     */         else {
/* 268 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 270 */         if ((get(i).getCourseID() == null) || (get(i).getCourseID().equals("null")))
/* 271 */           pstmt.setString(2, null);
/*     */         else {
/* 273 */           pstmt.setString(2, get(i).getCourseID());
/*     */         }
/* 275 */         if ((get(i).getCourseName() == null) || (get(i).getCourseName().equals("null")))
/* 276 */           pstmt.setString(3, null);
/*     */         else {
/* 278 */           pstmt.setString(3, get(i).getCourseName());
/*     */         }
/* 280 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 281 */           pstmt.setString(4, null);
/*     */         else {
/* 283 */           pstmt.setString(4, get(i).getManageCom());
/*     */         }
/* 285 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 286 */           pstmt.setString(5, null);
/*     */         else {
/* 288 */           pstmt.setString(5, get(i).getBranchType());
/*     */         }
/* 290 */         if ((get(i).getHour() == null) || (get(i).getHour().equals("null")))
/* 291 */           pstmt.setString(6, null);
/*     */         else {
/* 293 */           pstmt.setString(6, get(i).getHour());
/*     */         }
/* 295 */         if ((get(i).getDevelopBranch() == null) || (get(i).getDevelopBranch().equals("null")))
/* 296 */           pstmt.setString(7, null);
/*     */         else {
/* 298 */           pstmt.setString(7, get(i).getDevelopBranch());
/*     */         }
/* 300 */         if ((get(i).getDeveloper() == null) || (get(i).getDeveloper().equals("null")))
/* 301 */           pstmt.setString(8, null);
/*     */         else {
/* 303 */           pstmt.setString(8, get(i).getDeveloper());
/*     */         }
/* 305 */         if ((get(i).getNoTi() == null) || (get(i).getNoTi().equals("null")))
/* 306 */           pstmt.setString(10, null);
/*     */         else {
/* 308 */           pstmt.setString(10, get(i).getNoTi());
/*     */         }
/* 310 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 311 */           pstmt.setString(11, null);
/*     */         else {
/* 313 */           pstmt.setString(11, get(i).getOperator());
/*     */         }
/* 315 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 316 */           pstmt.setString(12, null);
/*     */         else {
/* 318 */           pstmt.setString(12, get(i).getModifyOperator());
/*     */         }
/* 320 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 321 */           pstmt.setString(14, null);
/*     */         else {
/* 323 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 325 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 326 */           pstmt.setString(16, null);
/*     */         else {
/* 328 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/* 330 */         if ((get(i).getCourse1() == null) || (get(i).getCourse1().equals("null")))
/* 331 */           pstmt.setString(17, null);
/*     */         else {
/* 333 */           pstmt.setString(17, get(i).getCourse1());
/*     */         }
/* 335 */         if ((get(i).getCourse2() == null) || (get(i).getCourse2().equals("null")))
/* 336 */           pstmt.setString(18, null);
/*     */         else {
/* 338 */           pstmt.setString(18, get(i).getCourse2());
/*     */         }
/* 340 */         if ((get(i).getCourse3() == null) || (get(i).getCourse3().equals("null")))
/* 341 */           pstmt.setString(19, null);
/*     */         else {
/* 343 */           pstmt.setString(19, get(i).getCourse3());
/*     */         }
/* 345 */         pstmt.addBatch();
/*     */       }
/* 347 */       pstmt.executeBatch();
/* 348 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 351 */       ex.printStackTrace();
/* 352 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 353 */       CError tError = new CError();
/* 354 */       tError.moduleName = "MCourseDBSet";
/* 355 */       tError.functionName = "insert()";
/* 356 */       tError.errorMessage = ex.toString();
/* 357 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 360 */         pstmt.close(); } catch (Exception e) {
/* 361 */         e.printStackTrace();
/*     */       }
/* 363 */       if (!this.mflag) {
/*     */         try {
/* 365 */           this.con.close(); } catch (Exception e) {
/* 366 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 369 */       return false;
/*     */     }
/*     */ 
/* 372 */     if (!this.mflag) {
/*     */       try {
/* 374 */         this.con.close(); } catch (Exception e) {
/* 375 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 378 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MCourseDBSet
 * JD-Core Version:    0.6.0
 */