/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MTrainInfoSchema;
/*     */ import com.sinosoft.map.lis.vschema.MTrainInfoSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MTrainInfoDBSet extends MTrainInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MTrainInfoDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MTrainInfo");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MTrainInfoDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MTrainInfo");
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
/*  49 */     tError.moduleName = "MTrainInfoDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MTrainInfo WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MTrainInfoDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MTrainInfo SET  ID = ? , AgentCode = ? , AgentName = ? , AgentGrade = ? , AgentGroup = ? , ManageCom = ? , BranchType = ? , CourseID = ? , TrainStart = ? , TrainEnd = ? , TrainAdd = ? , Hours = ? , Teacher = ? , PassFlag = ? , Score = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
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
/* 138 */         if ((get(i).getAgentName() == null) || (get(i).getAgentName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getAgentName());
/*     */         }
/* 143 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getAgentGrade());
/*     */         }
/* 148 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getAgentGroup());
/*     */         }
/* 153 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getManageCom());
/*     */         }
/* 158 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getBranchType());
/*     */         }
/* 163 */         if ((get(i).getCourseID() == null) || (get(i).getCourseID().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getCourseID());
/*     */         }
/* 168 */         if ((get(i).getTrainAdd() == null) || (get(i).getTrainAdd().equals("null")))
/* 169 */           pstmt.setString(11, null);
/*     */         else {
/* 171 */           pstmt.setString(11, get(i).getTrainAdd());
/*     */         }
/* 173 */         if ((get(i).getHours() == null) || (get(i).getHours().equals("null")))
/* 174 */           pstmt.setString(12, null);
/*     */         else {
/* 176 */           pstmt.setString(12, get(i).getHours());
/*     */         }
/* 178 */         if ((get(i).getTeacher() == null) || (get(i).getTeacher().equals("null")))
/* 179 */           pstmt.setString(13, null);
/*     */         else {
/* 181 */           pstmt.setString(13, get(i).getTeacher());
/*     */         }
/* 183 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 184 */           pstmt.setString(14, null);
/*     */         else {
/* 186 */           pstmt.setString(14, get(i).getPassFlag());
/*     */         }
/* 188 */         if ((get(i).getScore() == null) || (get(i).getScore().equals("null")))
/* 189 */           pstmt.setString(15, null);
/*     */         else {
/* 191 */           pstmt.setString(15, get(i).getScore());
/*     */         }
/* 193 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 194 */           pstmt.setString(16, null);
/*     */         else {
/* 196 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 198 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 199 */           pstmt.setString(18, null);
/*     */         else {
/* 201 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 203 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 204 */           pstmt.setString(20, null);
/*     */         else {
/* 206 */           pstmt.setString(20, get(i).getModifyTime());
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
/* 223 */       tError.moduleName = "MTrainInfoDBSet";
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
/* 262 */       pstmt = this.con.prepareStatement("INSERT INTO MTrainInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 263 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 265 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 266 */           pstmt.setString(1, null);
/*     */         else {
/* 268 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 270 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 271 */           pstmt.setString(2, null);
/*     */         else {
/* 273 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 275 */         if ((get(i).getAgentName() == null) || (get(i).getAgentName().equals("null")))
/* 276 */           pstmt.setString(3, null);
/*     */         else {
/* 278 */           pstmt.setString(3, get(i).getAgentName());
/*     */         }
/* 280 */         if ((get(i).getAgentGrade() == null) || (get(i).getAgentGrade().equals("null")))
/* 281 */           pstmt.setString(4, null);
/*     */         else {
/* 283 */           pstmt.setString(4, get(i).getAgentGrade());
/*     */         }
/* 285 */         if ((get(i).getAgentGroup() == null) || (get(i).getAgentGroup().equals("null")))
/* 286 */           pstmt.setString(5, null);
/*     */         else {
/* 288 */           pstmt.setString(5, get(i).getAgentGroup());
/*     */         }
/* 290 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 291 */           pstmt.setString(6, null);
/*     */         else {
/* 293 */           pstmt.setString(6, get(i).getManageCom());
/*     */         }
/* 295 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 296 */           pstmt.setString(7, null);
/*     */         else {
/* 298 */           pstmt.setString(7, get(i).getBranchType());
/*     */         }
/* 300 */         if ((get(i).getCourseID() == null) || (get(i).getCourseID().equals("null")))
/* 301 */           pstmt.setString(8, null);
/*     */         else {
/* 303 */           pstmt.setString(8, get(i).getCourseID());
/*     */         }
/* 305 */         if ((get(i).getTrainAdd() == null) || (get(i).getTrainAdd().equals("null")))
/* 306 */           pstmt.setString(11, null);
/*     */         else {
/* 308 */           pstmt.setString(11, get(i).getTrainAdd());
/*     */         }
/* 310 */         if ((get(i).getHours() == null) || (get(i).getHours().equals("null")))
/* 311 */           pstmt.setString(12, null);
/*     */         else {
/* 313 */           pstmt.setString(12, get(i).getHours());
/*     */         }
/* 315 */         if ((get(i).getTeacher() == null) || (get(i).getTeacher().equals("null")))
/* 316 */           pstmt.setString(13, null);
/*     */         else {
/* 318 */           pstmt.setString(13, get(i).getTeacher());
/*     */         }
/* 320 */         if ((get(i).getPassFlag() == null) || (get(i).getPassFlag().equals("null")))
/* 321 */           pstmt.setString(14, null);
/*     */         else {
/* 323 */           pstmt.setString(14, get(i).getPassFlag());
/*     */         }
/* 325 */         if ((get(i).getScore() == null) || (get(i).getScore().equals("null")))
/* 326 */           pstmt.setString(15, null);
/*     */         else {
/* 328 */           pstmt.setString(15, get(i).getScore());
/*     */         }
/* 330 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 331 */           pstmt.setString(16, null);
/*     */         else {
/* 333 */           pstmt.setString(16, get(i).getOperator());
/*     */         }
/* 335 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 336 */           pstmt.setString(18, null);
/*     */         else {
/* 338 */           pstmt.setString(18, get(i).getMakeTime());
/*     */         }
/* 340 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 341 */           pstmt.setString(20, null);
/*     */         else {
/* 343 */           pstmt.setString(20, get(i).getModifyTime());
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
/* 354 */       tError.moduleName = "MTrainInfoDBSet";
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
 * Qualified Name:     com.sinosoft.map.lis.vdb.MTrainInfoDBSet
 * JD-Core Version:    0.6.0
 */