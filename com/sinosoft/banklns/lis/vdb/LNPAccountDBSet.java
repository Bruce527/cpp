/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAccountSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAccountSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAccountDBSet extends LNPAccountSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAccountDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAccount");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAccountDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAccount");
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
/*  50 */     tError.moduleName = "LNPAccountDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAccount WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getCustomerNo());
/*     */         }
/*  78 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getBankCode());
/*     */         }
/*  83 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getBankAccNo());
/*     */         }
/*  88 */         pstmt.addBatch();
/*     */       }
/*  90 */       pstmt.executeBatch();
/*  91 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  94 */       ex.printStackTrace();
/*  95 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  96 */       CError tError = new CError();
/*  97 */       tError.moduleName = "LNPAccountDBSet";
/*  98 */       tError.functionName = "delete()";
/*  99 */       tError.errorMessage = ex.toString();
/* 100 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 103 */         pstmt.close(); } catch (Exception e) {
/* 104 */         e.printStackTrace();
/*     */       }
/* 106 */       if (!this.mflag) {
/*     */         try {
/* 108 */           this.con.close(); } catch (Exception e) {
/* 109 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 112 */       return false;
/*     */     }
/*     */ 
/* 115 */     if (!this.mflag) {
/*     */       try {
/* 117 */         this.con.close(); } catch (Exception e) {
/* 118 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 127 */     PreparedStatement pstmt = null;
/*     */ 
/* 129 */     if (!this.mflag) {
/* 130 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 135 */       int tCount = size();
/* 136 */       pstmt = this.con.prepareStatement("UPDATE LNPAccount SET  CustomerId = ? , CustomerNo = ? , AccKind = ? , BankCode = ? , BankAccNo = ? , AccName = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
/* 137 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 139 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 140 */           pstmt.setString(1, null);
/*     */         else {
/* 142 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 144 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 145 */           pstmt.setString(2, null);
/*     */         else {
/* 147 */           pstmt.setString(2, get(i).getCustomerNo());
/*     */         }
/* 149 */         if ((get(i).getAccKind() == null) || (get(i).getAccKind().equals("null")))
/* 150 */           pstmt.setString(3, null);
/*     */         else {
/* 152 */           pstmt.setString(3, get(i).getAccKind());
/*     */         }
/* 154 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 155 */           pstmt.setString(4, null);
/*     */         else {
/* 157 */           pstmt.setString(4, get(i).getBankCode());
/*     */         }
/* 159 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 160 */           pstmt.setString(5, null);
/*     */         else {
/* 162 */           pstmt.setString(5, get(i).getBankAccNo());
/*     */         }
/* 164 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 165 */           pstmt.setString(6, null);
/*     */         else {
/* 167 */           pstmt.setString(6, get(i).getAccName());
/*     */         }
/* 169 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 170 */           pstmt.setString(7, null);
/*     */         else {
/* 172 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 174 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 175 */           pstmt.setDate(8, null);
/*     */         else {
/* 177 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 179 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 180 */           pstmt.setString(9, null);
/*     */         else {
/* 182 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 184 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 185 */           pstmt.setDate(10, null);
/*     */         else {
/* 187 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 189 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 190 */           pstmt.setString(11, null);
/*     */         else {
/* 192 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 195 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 196 */           pstmt.setString(12, null);
/*     */         else {
/* 198 */           pstmt.setString(12, get(i).getCustomerNo());
/*     */         }
/* 200 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 201 */           pstmt.setString(13, null);
/*     */         else {
/* 203 */           pstmt.setString(13, get(i).getBankCode());
/*     */         }
/* 205 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 206 */           pstmt.setString(14, null);
/*     */         else {
/* 208 */           pstmt.setString(14, get(i).getBankAccNo());
/*     */         }
/* 210 */         pstmt.addBatch();
/*     */       }
/* 212 */       pstmt.executeBatch();
/* 213 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 216 */       ex.printStackTrace();
/* 217 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 218 */       CError tError = new CError();
/* 219 */       tError.moduleName = "LNPAccountDBSet";
/* 220 */       tError.functionName = "update()";
/* 221 */       tError.errorMessage = ex.toString();
/* 222 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 225 */         pstmt.close(); } catch (Exception e) {
/* 226 */         e.printStackTrace();
/*     */       }
/* 228 */       if (!this.mflag) {
/*     */         try {
/* 230 */           this.con.close(); } catch (Exception e) {
/* 231 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 234 */       return false;
/*     */     }
/*     */ 
/* 237 */     if (!this.mflag) {
/*     */       try {
/* 239 */         this.con.close(); } catch (Exception e) {
/* 240 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 243 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 249 */     PreparedStatement pstmt = null;
/*     */ 
/* 251 */     if (!this.mflag) {
/* 252 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 257 */       int tCount = size();
/* 258 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAccount VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 259 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 261 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 262 */           pstmt.setString(1, null);
/*     */         else {
/* 264 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 266 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 267 */           pstmt.setString(2, null);
/*     */         else {
/* 269 */           pstmt.setString(2, get(i).getCustomerNo());
/*     */         }
/* 271 */         if ((get(i).getAccKind() == null) || (get(i).getAccKind().equals("null")))
/* 272 */           pstmt.setString(3, null);
/*     */         else {
/* 274 */           pstmt.setString(3, get(i).getAccKind());
/*     */         }
/* 276 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 277 */           pstmt.setString(4, null);
/*     */         else {
/* 279 */           pstmt.setString(4, get(i).getBankCode());
/*     */         }
/* 281 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 282 */           pstmt.setString(5, null);
/*     */         else {
/* 284 */           pstmt.setString(5, get(i).getBankAccNo());
/*     */         }
/* 286 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 287 */           pstmt.setString(6, null);
/*     */         else {
/* 289 */           pstmt.setString(6, get(i).getAccName());
/*     */         }
/* 291 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 292 */           pstmt.setString(7, null);
/*     */         else {
/* 294 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 296 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 297 */           pstmt.setDate(8, null);
/*     */         else {
/* 299 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 301 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 302 */           pstmt.setString(9, null);
/*     */         else {
/* 304 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 306 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 307 */           pstmt.setDate(10, null);
/*     */         else {
/* 309 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 311 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 312 */           pstmt.setString(11, null);
/*     */         else {
/* 314 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 316 */         pstmt.addBatch();
/*     */       }
/* 318 */       pstmt.executeBatch();
/* 319 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 322 */       ex.printStackTrace();
/* 323 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 324 */       CError tError = new CError();
/* 325 */       tError.moduleName = "LNPAccountDBSet";
/* 326 */       tError.functionName = "insert()";
/* 327 */       tError.errorMessage = ex.toString();
/* 328 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 331 */         pstmt.close(); } catch (Exception e) {
/* 332 */         e.printStackTrace();
/*     */       }
/* 334 */       if (!this.mflag) {
/*     */         try {
/* 336 */           this.con.close(); } catch (Exception e) {
/* 337 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 340 */       return false;
/*     */     }
/*     */ 
/* 343 */     if (!this.mflag) {
/*     */       try {
/* 345 */         this.con.close(); } catch (Exception e) {
/* 346 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 349 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAccountDBSet
 * JD-Core Version:    0.6.0
 */