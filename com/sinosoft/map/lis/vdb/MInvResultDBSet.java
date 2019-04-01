/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvResultSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvResultSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvResultDBSet extends MInvResultSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvResultDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvResult");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvResultDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvResult");
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
/*  49 */     tError.moduleName = "MInvResultDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvResult WHERE  ResultID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getResultID());
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
/*  86 */       tError.moduleName = "MInvResultDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvResult SET  ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getResultID());
/*     */         }
/* 133 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getTopicID());
/*     */         }
/* 138 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getQuestionID());
/*     */         }
/* 143 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getOptionID());
/*     */         }
/* 148 */         if ((get(i).getOtherAnswer() == null) || (get(i).getOtherAnswer().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getOtherAnswer());
/*     */         }
/* 153 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getAgentCode());
/*     */         }
/* 158 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 163 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getVF01());
/*     */         }
/* 168 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getNF01());
/*     */         }
/* 173 */         pstmt.setInt(10, get(i).getIF01());
/* 174 */         pstmt.setDouble(11, get(i).getDF02());
/* 175 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 176 */           pstmt.setDate(12, null);
/*     */         else {
/* 178 */           pstmt.setDate(12, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 180 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 181 */           pstmt.setString(13, null);
/*     */         else {
/* 183 */           pstmt.setString(13, get(i).getModifyOperator());
/*     */         }
/* 185 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getOperator());
/*     */         }
/* 190 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 191 */           pstmt.setDate(15, null);
/*     */         else {
/* 193 */           pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 195 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getMakeTime());
/*     */         }
/* 200 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 201 */           pstmt.setDate(17, null);
/*     */         else {
/* 203 */           pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 205 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 211 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/* 212 */           pstmt.setString(19, null);
/*     */         else {
/* 214 */           pstmt.setString(19, get(i).getResultID());
/*     */         }
/* 216 */         pstmt.addBatch();
/*     */       }
/* 218 */       pstmt.executeBatch();
/* 219 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 222 */       ex.printStackTrace();
/* 223 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 224 */       CError tError = new CError();
/* 225 */       tError.moduleName = "MInvResultDBSet";
/* 226 */       tError.functionName = "update()";
/* 227 */       tError.errorMessage = ex.toString();
/* 228 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 231 */         pstmt.close(); } catch (Exception e) {
/* 232 */         e.printStackTrace();
/*     */       }
/* 234 */       if (!this.mflag) {
/*     */         try {
/* 236 */           this.con.close(); } catch (Exception e) {
/* 237 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 240 */       return false;
/*     */     }
/*     */ 
/* 243 */     if (!this.mflag) {
/*     */       try {
/* 245 */         this.con.close(); } catch (Exception e) {
/* 246 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 255 */     PreparedStatement pstmt = null;
/*     */ 
/* 257 */     if (!this.mflag) {
/* 258 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 263 */       int tCount = size();
/* 264 */       pstmt = this.con.prepareStatement("INSERT INTO MInvResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 265 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 267 */         if ((get(i).getResultID() == null) || (get(i).getResultID().equals("null")))
/* 268 */           pstmt.setString(1, null);
/*     */         else {
/* 270 */           pstmt.setString(1, get(i).getResultID());
/*     */         }
/* 272 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 273 */           pstmt.setString(2, null);
/*     */         else {
/* 275 */           pstmt.setString(2, get(i).getTopicID());
/*     */         }
/* 277 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 278 */           pstmt.setString(3, null);
/*     */         else {
/* 280 */           pstmt.setString(3, get(i).getQuestionID());
/*     */         }
/* 282 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 283 */           pstmt.setString(4, null);
/*     */         else {
/* 285 */           pstmt.setString(4, get(i).getOptionID());
/*     */         }
/* 287 */         if ((get(i).getOtherAnswer() == null) || (get(i).getOtherAnswer().equals("null")))
/* 288 */           pstmt.setString(5, null);
/*     */         else {
/* 290 */           pstmt.setString(5, get(i).getOtherAnswer());
/*     */         }
/* 292 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 293 */           pstmt.setString(6, null);
/*     */         else {
/* 295 */           pstmt.setString(6, get(i).getAgentCode());
/*     */         }
/* 297 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 298 */           pstmt.setString(7, null);
/*     */         else {
/* 300 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 302 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 303 */           pstmt.setString(8, null);
/*     */         else {
/* 305 */           pstmt.setString(8, get(i).getVF01());
/*     */         }
/* 307 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 308 */           pstmt.setString(9, null);
/*     */         else {
/* 310 */           pstmt.setString(9, get(i).getNF01());
/*     */         }
/* 312 */         pstmt.setInt(10, get(i).getIF01());
/* 313 */         pstmt.setDouble(11, get(i).getDF02());
/* 314 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 315 */           pstmt.setDate(12, null);
/*     */         else {
/* 317 */           pstmt.setDate(12, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 319 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 320 */           pstmt.setString(13, null);
/*     */         else {
/* 322 */           pstmt.setString(13, get(i).getModifyOperator());
/*     */         }
/* 324 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 325 */           pstmt.setString(14, null);
/*     */         else {
/* 327 */           pstmt.setString(14, get(i).getOperator());
/*     */         }
/* 329 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 330 */           pstmt.setDate(15, null);
/*     */         else {
/* 332 */           pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 334 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 335 */           pstmt.setString(16, null);
/*     */         else {
/* 337 */           pstmt.setString(16, get(i).getMakeTime());
/*     */         }
/* 339 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 340 */           pstmt.setDate(17, null);
/*     */         else {
/* 342 */           pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 344 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 345 */           pstmt.setString(18, null);
/*     */         else {
/* 347 */           pstmt.setString(18, get(i).getModifyTime());
/*     */         }
/* 349 */         pstmt.addBatch();
/*     */       }
/* 351 */       pstmt.executeBatch();
/* 352 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 355 */       ex.printStackTrace();
/* 356 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 357 */       CError tError = new CError();
/* 358 */       tError.moduleName = "MInvResultDBSet";
/* 359 */       tError.functionName = "insert()";
/* 360 */       tError.errorMessage = ex.toString();
/* 361 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 364 */         pstmt.close(); } catch (Exception e) {
/* 365 */         e.printStackTrace();
/*     */       }
/* 367 */       if (!this.mflag) {
/*     */         try {
/* 369 */           this.con.close(); } catch (Exception e) {
/* 370 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 373 */       return false;
/*     */     }
/*     */ 
/* 376 */     if (!this.mflag) {
/*     */       try {
/* 378 */         this.con.close(); } catch (Exception e) {
/* 379 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 382 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvResultDBSet
 * JD-Core Version:    0.6.0
 */