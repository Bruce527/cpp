/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPFAndIImpartSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpartSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPFAndIImpartDBSet extends LNPFAndIImpartSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPFAndIImpartDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPFAndIImpart");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPFAndIImpartDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPFAndIImpart");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPFAndIImpartDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPFAndIImpart WHERE  ImpartId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPFAndIImpartDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPFAndIImpart SET  ImpartId = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 134 */         if ((get(i).getImpartName() == null) || (get(i).getImpartName().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getImpartName());
/*     */         }
/* 139 */         if ((get(i).getImpartVer() == null) || (get(i).getImpartVer().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getImpartVer());
/*     */         }
/* 144 */         if ((get(i).getImpartContent() == null) || (get(i).getImpartContent().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getImpartContent());
/*     */         }
/* 149 */         pstmt.setInt(5, get(i).getQuestionSum());
/* 150 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 151 */           pstmt.setString(6, null);
/*     */         else {
/* 153 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 155 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 156 */           pstmt.setString(7, null);
/*     */         else {
/* 158 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 160 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 161 */           pstmt.setString(8, null);
/*     */         else {
/* 163 */           pstmt.setString(8, get(i).getMakeTime());
/*     */         }
/* 165 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 166 */           pstmt.setDate(9, null);
/*     */         else {
/* 168 */           pstmt.setDate(9, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 170 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 171 */           pstmt.setDate(10, null);
/*     */         else {
/* 173 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 175 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 176 */           pstmt.setString(11, null);
/*     */         else {
/* 178 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 180 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 181 */           pstmt.setString(12, null);
/*     */         else {
/* 183 */           pstmt.setString(12, get(i).getP1());
/*     */         }
/* 185 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 186 */           pstmt.setString(13, null);
/*     */         else {
/* 188 */           pstmt.setString(13, get(i).getP2());
/*     */         }
/* 190 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 191 */           pstmt.setString(14, null);
/*     */         else {
/* 193 */           pstmt.setString(14, get(i).getP3());
/*     */         }
/* 195 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getP4());
/*     */         }
/*     */ 
/* 201 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 202 */           pstmt.setString(16, null);
/*     */         else {
/* 204 */           pstmt.setString(16, get(i).getImpartId());
/*     */         }
/* 206 */         pstmt.addBatch();
/*     */       }
/* 208 */       pstmt.executeBatch();
/* 209 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 212 */       ex.printStackTrace();
/* 213 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 214 */       CError tError = new CError();
/* 215 */       tError.moduleName = "LNPFAndIImpartDBSet";
/* 216 */       tError.functionName = "update()";
/* 217 */       tError.errorMessage = ex.toString();
/* 218 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 221 */         pstmt.close(); } catch (Exception e) {
/* 222 */         e.printStackTrace();
/*     */       }
/* 224 */       if (!this.mflag) {
/*     */         try {
/* 226 */           this.con.close(); } catch (Exception e) {
/* 227 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 230 */       return false;
/*     */     }
/*     */ 
/* 233 */     if (!this.mflag) {
/*     */       try {
/* 235 */         this.con.close(); } catch (Exception e) {
/* 236 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 245 */     PreparedStatement pstmt = null;
/*     */ 
/* 247 */     if (!this.mflag) {
/* 248 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 253 */       int tCount = size();
/* 254 */       pstmt = this.con.prepareStatement("INSERT INTO LNPFAndIImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 255 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 257 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 258 */           pstmt.setString(1, null);
/*     */         else {
/* 260 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 262 */         if ((get(i).getImpartName() == null) || (get(i).getImpartName().equals("null")))
/* 263 */           pstmt.setString(2, null);
/*     */         else {
/* 265 */           pstmt.setString(2, get(i).getImpartName());
/*     */         }
/* 267 */         if ((get(i).getImpartVer() == null) || (get(i).getImpartVer().equals("null")))
/* 268 */           pstmt.setString(3, null);
/*     */         else {
/* 270 */           pstmt.setString(3, get(i).getImpartVer());
/*     */         }
/* 272 */         if ((get(i).getImpartContent() == null) || (get(i).getImpartContent().equals("null")))
/* 273 */           pstmt.setString(4, null);
/*     */         else {
/* 275 */           pstmt.setString(4, get(i).getImpartContent());
/*     */         }
/* 277 */         pstmt.setInt(5, get(i).getQuestionSum());
/* 278 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 279 */           pstmt.setString(6, null);
/*     */         else {
/* 281 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 283 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 284 */           pstmt.setString(7, null);
/*     */         else {
/* 286 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 288 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 289 */           pstmt.setString(8, null);
/*     */         else {
/* 291 */           pstmt.setString(8, get(i).getMakeTime());
/*     */         }
/* 293 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 294 */           pstmt.setDate(9, null);
/*     */         else {
/* 296 */           pstmt.setDate(9, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 298 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 299 */           pstmt.setDate(10, null);
/*     */         else {
/* 301 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 303 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 304 */           pstmt.setString(11, null);
/*     */         else {
/* 306 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 308 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 309 */           pstmt.setString(12, null);
/*     */         else {
/* 311 */           pstmt.setString(12, get(i).getP1());
/*     */         }
/* 313 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 314 */           pstmt.setString(13, null);
/*     */         else {
/* 316 */           pstmt.setString(13, get(i).getP2());
/*     */         }
/* 318 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 319 */           pstmt.setString(14, null);
/*     */         else {
/* 321 */           pstmt.setString(14, get(i).getP3());
/*     */         }
/* 323 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 324 */           pstmt.setString(15, null);
/*     */         else {
/* 326 */           pstmt.setString(15, get(i).getP4());
/*     */         }
/* 328 */         pstmt.addBatch();
/*     */       }
/* 330 */       pstmt.executeBatch();
/* 331 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 334 */       ex.printStackTrace();
/* 335 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 336 */       CError tError = new CError();
/* 337 */       tError.moduleName = "LNPFAndIImpartDBSet";
/* 338 */       tError.functionName = "insert()";
/* 339 */       tError.errorMessage = ex.toString();
/* 340 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 343 */         pstmt.close(); } catch (Exception e) {
/* 344 */         e.printStackTrace();
/*     */       }
/* 346 */       if (!this.mflag) {
/*     */         try {
/* 348 */           this.con.close(); } catch (Exception e) {
/* 349 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 352 */       return false;
/*     */     }
/*     */ 
/* 355 */     if (!this.mflag) {
/*     */       try {
/* 357 */         this.con.close(); } catch (Exception e) {
/* 358 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 361 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPFAndIImpartDBSet
 * JD-Core Version:    0.6.0
 */