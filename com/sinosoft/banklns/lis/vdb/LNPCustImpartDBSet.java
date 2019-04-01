/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCustImpartSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCustImpartSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCustImpartDBSet extends LNPCustImpartSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCustImpartDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCustImpart");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCustImpartDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCustImpart");
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
/*  50 */     tError.moduleName = "LNPCustImpartDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCustImpart WHERE  ImpartId = ?");
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
/*  87 */       tError.moduleName = "LNPCustImpartDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPCustImpart SET  ImpartId = ? , ProposalType = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 134 */         if ((get(i).getProposalType() == null) || (get(i).getProposalType().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getProposalType());
/*     */         }
/* 139 */         if ((get(i).getImpartName() == null) || (get(i).getImpartName().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getImpartName());
/*     */         }
/* 144 */         if ((get(i).getImpartVer() == null) || (get(i).getImpartVer().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getImpartVer());
/*     */         }
/* 149 */         if ((get(i).getImpartContent() == null) || (get(i).getImpartContent().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getImpartContent());
/*     */         }
/* 154 */         pstmt.setInt(6, get(i).getQuestionSum());
/* 155 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 156 */           pstmt.setString(7, null);
/*     */         else {
/* 158 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 160 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 161 */           pstmt.setString(8, null);
/*     */         else {
/* 163 */           pstmt.setString(8, get(i).getManageCom());
/*     */         }
/* 165 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 166 */           pstmt.setString(9, null);
/*     */         else {
/* 168 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 170 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 171 */           pstmt.setDate(10, null);
/*     */         else {
/* 173 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 175 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 176 */           pstmt.setDate(11, null);
/*     */         else {
/* 178 */           pstmt.setDate(11, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 180 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 181 */           pstmt.setString(12, null);
/*     */         else {
/* 183 */           pstmt.setString(12, get(i).getModifyTime());
/*     */         }
/* 185 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 186 */           pstmt.setString(13, null);
/*     */         else {
/* 188 */           pstmt.setString(13, get(i).getP1());
/*     */         }
/* 190 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 191 */           pstmt.setString(14, null);
/*     */         else {
/* 193 */           pstmt.setString(14, get(i).getP2());
/*     */         }
/* 195 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getP3());
/*     */         }
/* 200 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getP4());
/*     */         }
/*     */ 
/* 206 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 207 */           pstmt.setString(17, null);
/*     */         else {
/* 209 */           pstmt.setString(17, get(i).getImpartId());
/*     */         }
/* 211 */         pstmt.addBatch();
/*     */       }
/* 213 */       pstmt.executeBatch();
/* 214 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 217 */       ex.printStackTrace();
/* 218 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 219 */       CError tError = new CError();
/* 220 */       tError.moduleName = "LNPCustImpartDBSet";
/* 221 */       tError.functionName = "update()";
/* 222 */       tError.errorMessage = ex.toString();
/* 223 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 226 */         pstmt.close(); } catch (Exception e) {
/* 227 */         e.printStackTrace();
/*     */       }
/* 229 */       if (!this.mflag) {
/*     */         try {
/* 231 */           this.con.close(); } catch (Exception e) {
/* 232 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 235 */       return false;
/*     */     }
/*     */ 
/* 238 */     if (!this.mflag) {
/*     */       try {
/* 240 */         this.con.close(); } catch (Exception e) {
/* 241 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 244 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 250 */     PreparedStatement pstmt = null;
/*     */ 
/* 252 */     if (!this.mflag) {
/* 253 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 258 */       int tCount = size();
/* 259 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCustImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 260 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 262 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 263 */           pstmt.setString(1, null);
/*     */         else {
/* 265 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 267 */         if ((get(i).getProposalType() == null) || (get(i).getProposalType().equals("null")))
/* 268 */           pstmt.setString(2, null);
/*     */         else {
/* 270 */           pstmt.setString(2, get(i).getProposalType());
/*     */         }
/* 272 */         if ((get(i).getImpartName() == null) || (get(i).getImpartName().equals("null")))
/* 273 */           pstmt.setString(3, null);
/*     */         else {
/* 275 */           pstmt.setString(3, get(i).getImpartName());
/*     */         }
/* 277 */         if ((get(i).getImpartVer() == null) || (get(i).getImpartVer().equals("null")))
/* 278 */           pstmt.setString(4, null);
/*     */         else {
/* 280 */           pstmt.setString(4, get(i).getImpartVer());
/*     */         }
/* 282 */         if ((get(i).getImpartContent() == null) || (get(i).getImpartContent().equals("null")))
/* 283 */           pstmt.setString(5, null);
/*     */         else {
/* 285 */           pstmt.setString(5, get(i).getImpartContent());
/*     */         }
/* 287 */         pstmt.setInt(6, get(i).getQuestionSum());
/* 288 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 289 */           pstmt.setString(7, null);
/*     */         else {
/* 291 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 293 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 294 */           pstmt.setString(8, null);
/*     */         else {
/* 296 */           pstmt.setString(8, get(i).getManageCom());
/*     */         }
/* 298 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 299 */           pstmt.setString(9, null);
/*     */         else {
/* 301 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 303 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 304 */           pstmt.setDate(10, null);
/*     */         else {
/* 306 */           pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 308 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 309 */           pstmt.setDate(11, null);
/*     */         else {
/* 311 */           pstmt.setDate(11, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 313 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 314 */           pstmt.setString(12, null);
/*     */         else {
/* 316 */           pstmt.setString(12, get(i).getModifyTime());
/*     */         }
/* 318 */         if ((get(i).getP1() == null) || (get(i).getP1().equals("null")))
/* 319 */           pstmt.setString(13, null);
/*     */         else {
/* 321 */           pstmt.setString(13, get(i).getP1());
/*     */         }
/* 323 */         if ((get(i).getP2() == null) || (get(i).getP2().equals("null")))
/* 324 */           pstmt.setString(14, null);
/*     */         else {
/* 326 */           pstmt.setString(14, get(i).getP2());
/*     */         }
/* 328 */         if ((get(i).getP3() == null) || (get(i).getP3().equals("null")))
/* 329 */           pstmt.setString(15, null);
/*     */         else {
/* 331 */           pstmt.setString(15, get(i).getP3());
/*     */         }
/* 333 */         if ((get(i).getP4() == null) || (get(i).getP4().equals("null")))
/* 334 */           pstmt.setString(16, null);
/*     */         else {
/* 336 */           pstmt.setString(16, get(i).getP4());
/*     */         }
/* 338 */         pstmt.addBatch();
/*     */       }
/* 340 */       pstmt.executeBatch();
/* 341 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 344 */       ex.printStackTrace();
/* 345 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 346 */       CError tError = new CError();
/* 347 */       tError.moduleName = "LNPCustImpartDBSet";
/* 348 */       tError.functionName = "insert()";
/* 349 */       tError.errorMessage = ex.toString();
/* 350 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 353 */         pstmt.close(); } catch (Exception e) {
/* 354 */         e.printStackTrace();
/*     */       }
/* 356 */       if (!this.mflag) {
/*     */         try {
/* 358 */           this.con.close(); } catch (Exception e) {
/* 359 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 362 */       return false;
/*     */     }
/*     */ 
/* 365 */     if (!this.mflag) {
/*     */       try {
/* 367 */         this.con.close(); } catch (Exception e) {
/* 368 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 371 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCustImpartDBSet
 * JD-Core Version:    0.6.0
 */