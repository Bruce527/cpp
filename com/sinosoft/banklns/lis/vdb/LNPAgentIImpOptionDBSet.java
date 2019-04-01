/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentIImpOptionSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentIImpOptionSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAgentIImpOptionDBSet extends LNPAgentIImpOptionSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAgentIImpOptionDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAgentIImpOption");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAgentIImpOptionDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAgentIImpOption");
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
/*  50 */     tError.moduleName = "LNPAgentIImpOptionDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentIImpOption WHERE  OptionId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getOptionId());
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
/*  87 */       tError.moduleName = "LNPAgentIImpOptionDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentIImpOption SET  ImpartId = ? , QuestionId = ? , OptionId = ? , OptionOrder = ? , OptionContent = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionId = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 134 */         if ((get(i).getQuestionId() == null) || (get(i).getQuestionId().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getQuestionId());
/*     */         }
/* 139 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getOptionId());
/*     */         }
/* 144 */         if ((get(i).getOptionOrder() == null) || (get(i).getOptionOrder().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getOptionOrder());
/*     */         }
/* 149 */         if ((get(i).getOptionContent() == null) || (get(i).getOptionContent().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getOptionContent());
/*     */         }
/* 154 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 159 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 164 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 165 */           pstmt.setDate(8, null);
/*     */         else {
/* 167 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 169 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 174 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 175 */           pstmt.setDate(10, null);
/*     */         else {
/* 177 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 179 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 185 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/* 186 */           pstmt.setString(12, null);
/*     */         else {
/* 188 */           pstmt.setString(12, get(i).getOptionId());
/*     */         }
/* 190 */         pstmt.addBatch();
/*     */       }
/* 192 */       pstmt.executeBatch();
/* 193 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 196 */       ex.printStackTrace();
/* 197 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 198 */       CError tError = new CError();
/* 199 */       tError.moduleName = "LNPAgentIImpOptionDBSet";
/* 200 */       tError.functionName = "update()";
/* 201 */       tError.errorMessage = ex.toString();
/* 202 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 205 */         pstmt.close(); } catch (Exception e) {
/* 206 */         e.printStackTrace();
/*     */       }
/* 208 */       if (!this.mflag) {
/*     */         try {
/* 210 */           this.con.close(); } catch (Exception e) {
/* 211 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 214 */       return false;
/*     */     }
/*     */ 
/* 217 */     if (!this.mflag) {
/*     */       try {
/* 219 */         this.con.close(); } catch (Exception e) {
/* 220 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 229 */     PreparedStatement pstmt = null;
/*     */ 
/* 231 */     if (!this.mflag) {
/* 232 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 237 */       int tCount = size();
/* 238 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentIImpOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 239 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 241 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 242 */           pstmt.setString(1, null);
/*     */         else {
/* 244 */           pstmt.setString(1, get(i).getImpartId());
/*     */         }
/* 246 */         if ((get(i).getQuestionId() == null) || (get(i).getQuestionId().equals("null")))
/* 247 */           pstmt.setString(2, null);
/*     */         else {
/* 249 */           pstmt.setString(2, get(i).getQuestionId());
/*     */         }
/* 251 */         if ((get(i).getOptionId() == null) || (get(i).getOptionId().equals("null")))
/* 252 */           pstmt.setString(3, null);
/*     */         else {
/* 254 */           pstmt.setString(3, get(i).getOptionId());
/*     */         }
/* 256 */         if ((get(i).getOptionOrder() == null) || (get(i).getOptionOrder().equals("null")))
/* 257 */           pstmt.setString(4, null);
/*     */         else {
/* 259 */           pstmt.setString(4, get(i).getOptionOrder());
/*     */         }
/* 261 */         if ((get(i).getOptionContent() == null) || (get(i).getOptionContent().equals("null")))
/* 262 */           pstmt.setString(5, null);
/*     */         else {
/* 264 */           pstmt.setString(5, get(i).getOptionContent());
/*     */         }
/* 266 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 267 */           pstmt.setString(6, null);
/*     */         else {
/* 269 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 271 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 272 */           pstmt.setString(7, null);
/*     */         else {
/* 274 */           pstmt.setString(7, get(i).getManageCom());
/*     */         }
/* 276 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 277 */           pstmt.setDate(8, null);
/*     */         else {
/* 279 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 281 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 282 */           pstmt.setString(9, null);
/*     */         else {
/* 284 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 286 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 287 */           pstmt.setDate(10, null);
/*     */         else {
/* 289 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 291 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 292 */           pstmt.setString(11, null);
/*     */         else {
/* 294 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 296 */         pstmt.addBatch();
/*     */       }
/* 298 */       pstmt.executeBatch();
/* 299 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 302 */       ex.printStackTrace();
/* 303 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 304 */       CError tError = new CError();
/* 305 */       tError.moduleName = "LNPAgentIImpOptionDBSet";
/* 306 */       tError.functionName = "insert()";
/* 307 */       tError.errorMessage = ex.toString();
/* 308 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 311 */         pstmt.close(); } catch (Exception e) {
/* 312 */         e.printStackTrace();
/*     */       }
/* 314 */       if (!this.mflag) {
/*     */         try {
/* 316 */           this.con.close(); } catch (Exception e) {
/* 317 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 320 */       return false;
/*     */     }
/*     */ 
/* 323 */     if (!this.mflag) {
/*     */       try {
/* 325 */         this.con.close(); } catch (Exception e) {
/* 326 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 329 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAgentIImpOptionDBSet
 * JD-Core Version:    0.6.0
 */