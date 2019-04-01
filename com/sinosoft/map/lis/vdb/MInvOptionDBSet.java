/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvOptionSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvOptionSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvOptionDBSet extends MInvOptionSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvOptionDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvOption");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvOptionDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvOption");
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
/*  49 */     tError.moduleName = "MInvOptionDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvOption WHERE  OptionID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getOptionID());
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
/*  86 */       tError.moduleName = "MInvOptionDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvOption SET  OptionID = ? , QuestionID = ? , Option = ? , OptionOrder = ? , State = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getOptionID());
/*     */         }
/* 133 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getQuestionID());
/*     */         }
/* 138 */         if ((get(i).getOption() == null) || (get(i).getOption().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getOption());
/*     */         }
/* 143 */         pstmt.setInt(4, get(i).getOptionOrder());
/* 144 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 145 */           pstmt.setString(5, null);
/*     */         else {
/* 147 */           pstmt.setString(5, get(i).getState());
/*     */         }
/* 149 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 150 */           pstmt.setString(6, null);
/*     */         else {
/* 152 */           pstmt.setString(6, get(i).getVF01());
/*     */         }
/* 154 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getNF01());
/*     */         }
/* 159 */         pstmt.setInt(8, get(i).getIF01());
/* 160 */         pstmt.setDouble(9, get(i).getDF02());
/* 161 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 162 */           pstmt.setDate(10, null);
/*     */         else {
/* 164 */           pstmt.setDate(10, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 166 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 167 */           pstmt.setString(11, null);
/*     */         else {
/* 169 */           pstmt.setString(11, get(i).getModifyOperator());
/*     */         }
/* 171 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 172 */           pstmt.setString(12, null);
/*     */         else {
/* 174 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 176 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 177 */           pstmt.setDate(13, null);
/*     */         else {
/* 179 */           pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 181 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 182 */           pstmt.setString(14, null);
/*     */         else {
/* 184 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 186 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 187 */           pstmt.setDate(15, null);
/*     */         else {
/* 189 */           pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 191 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 192 */           pstmt.setString(16, null);
/*     */         else {
/* 194 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 197 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 198 */           pstmt.setString(17, null);
/*     */         else {
/* 200 */           pstmt.setString(17, get(i).getOptionID());
/*     */         }
/* 202 */         pstmt.addBatch();
/*     */       }
/* 204 */       pstmt.executeBatch();
/* 205 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 208 */       ex.printStackTrace();
/* 209 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 210 */       CError tError = new CError();
/* 211 */       tError.moduleName = "MInvOptionDBSet";
/* 212 */       tError.functionName = "update()";
/* 213 */       tError.errorMessage = ex.toString();
/* 214 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 217 */         pstmt.close(); } catch (Exception e) {
/* 218 */         e.printStackTrace();
/*     */       }
/* 220 */       if (!this.mflag) {
/*     */         try {
/* 222 */           this.con.close(); } catch (Exception e) {
/* 223 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 226 */       return false;
/*     */     }
/*     */ 
/* 229 */     if (!this.mflag) {
/*     */       try {
/* 231 */         this.con.close(); } catch (Exception e) {
/* 232 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 235 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 241 */     PreparedStatement pstmt = null;
/*     */ 
/* 243 */     if (!this.mflag) {
/* 244 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 249 */       int tCount = size();
/* 250 */       pstmt = this.con.prepareStatement("INSERT INTO MInvOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 251 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 253 */         if ((get(i).getOptionID() == null) || (get(i).getOptionID().equals("null")))
/* 254 */           pstmt.setString(1, null);
/*     */         else {
/* 256 */           pstmt.setString(1, get(i).getOptionID());
/*     */         }
/* 258 */         if ((get(i).getQuestionID() == null) || (get(i).getQuestionID().equals("null")))
/* 259 */           pstmt.setString(2, null);
/*     */         else {
/* 261 */           pstmt.setString(2, get(i).getQuestionID());
/*     */         }
/* 263 */         if ((get(i).getOption() == null) || (get(i).getOption().equals("null")))
/* 264 */           pstmt.setString(3, null);
/*     */         else {
/* 266 */           pstmt.setString(3, get(i).getOption());
/*     */         }
/* 268 */         pstmt.setInt(4, get(i).getOptionOrder());
/* 269 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 270 */           pstmt.setString(5, null);
/*     */         else {
/* 272 */           pstmt.setString(5, get(i).getState());
/*     */         }
/* 274 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 275 */           pstmt.setString(6, null);
/*     */         else {
/* 277 */           pstmt.setString(6, get(i).getVF01());
/*     */         }
/* 279 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 280 */           pstmt.setString(7, null);
/*     */         else {
/* 282 */           pstmt.setString(7, get(i).getNF01());
/*     */         }
/* 284 */         pstmt.setInt(8, get(i).getIF01());
/* 285 */         pstmt.setDouble(9, get(i).getDF02());
/* 286 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 287 */           pstmt.setDate(10, null);
/*     */         else {
/* 289 */           pstmt.setDate(10, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 291 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 292 */           pstmt.setString(11, null);
/*     */         else {
/* 294 */           pstmt.setString(11, get(i).getModifyOperator());
/*     */         }
/* 296 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 297 */           pstmt.setString(12, null);
/*     */         else {
/* 299 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 301 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 302 */           pstmt.setDate(13, null);
/*     */         else {
/* 304 */           pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 306 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 307 */           pstmt.setString(14, null);
/*     */         else {
/* 309 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 311 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 312 */           pstmt.setDate(15, null);
/*     */         else {
/* 314 */           pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 316 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 317 */           pstmt.setString(16, null);
/*     */         else {
/* 319 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/* 321 */         pstmt.addBatch();
/*     */       }
/* 323 */       pstmt.executeBatch();
/* 324 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 327 */       ex.printStackTrace();
/* 328 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 329 */       CError tError = new CError();
/* 330 */       tError.moduleName = "MInvOptionDBSet";
/* 331 */       tError.functionName = "insert()";
/* 332 */       tError.errorMessage = ex.toString();
/* 333 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 336 */         pstmt.close(); } catch (Exception e) {
/* 337 */         e.printStackTrace();
/*     */       }
/* 339 */       if (!this.mflag) {
/*     */         try {
/* 341 */           this.con.close(); } catch (Exception e) {
/* 342 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 345 */       return false;
/*     */     }
/*     */ 
/* 348 */     if (!this.mflag) {
/*     */       try {
/* 350 */         this.con.close(); } catch (Exception e) {
/* 351 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 354 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvOptionDBSet
 * JD-Core Version:    0.6.0
 */