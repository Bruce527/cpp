/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredRelatedSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredRelatedSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPInsuredRelatedDBSet extends LNPInsuredRelatedSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPInsuredRelatedDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPInsuredRelated");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPInsuredRelatedDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPInsuredRelated");
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
/*  50 */     tError.moduleName = "LNPInsuredRelatedDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsuredRelated WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getPolNo());
/*     */         }
/*  78 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getCustomerId());
/*     */         }
/*  83 */         if ((get(i).getMainCustomerNo() == null) || (get(i).getMainCustomerNo().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getMainCustomerNo());
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
/*  97 */       tError.moduleName = "LNPInsuredRelatedDBSet";
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
/* 136 */       pstmt = this.con.prepareStatement("UPDATE LNPInsuredRelated SET  PolNo = ? , CustomerId = ? , CustomerNo = ? , MainCustomerNo = ? , RelationToInsured = ? , AddressNo = ? , Name = ? , Sex = ? , Birthday = ? , IDType = ? , IDNo = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
/* 137 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 139 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 140 */           pstmt.setString(1, null);
/*     */         else {
/* 142 */           pstmt.setString(1, get(i).getPolNo());
/*     */         }
/* 144 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 145 */           pstmt.setString(2, null);
/*     */         else {
/* 147 */           pstmt.setString(2, get(i).getCustomerId());
/*     */         }
/* 149 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 150 */           pstmt.setString(3, null);
/*     */         else {
/* 152 */           pstmt.setString(3, get(i).getCustomerNo());
/*     */         }
/* 154 */         if ((get(i).getMainCustomerNo() == null) || (get(i).getMainCustomerNo().equals("null")))
/* 155 */           pstmt.setString(4, null);
/*     */         else {
/* 157 */           pstmt.setString(4, get(i).getMainCustomerNo());
/*     */         }
/* 159 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 160 */           pstmt.setString(5, null);
/*     */         else {
/* 162 */           pstmt.setString(5, get(i).getRelationToInsured());
/*     */         }
/* 164 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 165 */           pstmt.setString(6, null);
/*     */         else {
/* 167 */           pstmt.setString(6, get(i).getAddressNo());
/*     */         }
/* 169 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 170 */           pstmt.setString(7, null);
/*     */         else {
/* 172 */           pstmt.setString(7, get(i).getName());
/*     */         }
/* 174 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 175 */           pstmt.setString(8, null);
/*     */         else {
/* 177 */           pstmt.setString(8, get(i).getSex());
/*     */         }
/* 179 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 180 */           pstmt.setDate(9, null);
/*     */         else {
/* 182 */           pstmt.setDate(9, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 184 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 185 */           pstmt.setString(10, null);
/*     */         else {
/* 187 */           pstmt.setString(10, get(i).getIDType());
/*     */         }
/* 189 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 190 */           pstmt.setString(11, null);
/*     */         else {
/* 192 */           pstmt.setString(11, get(i).getIDNo());
/*     */         }
/* 194 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 195 */           pstmt.setString(12, null);
/*     */         else {
/* 197 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 199 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 200 */           pstmt.setDate(13, null);
/*     */         else {
/* 202 */           pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 204 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 205 */           pstmt.setString(14, null);
/*     */         else {
/* 207 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 209 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 210 */           pstmt.setDate(15, null);
/*     */         else {
/* 212 */           pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 214 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 215 */           pstmt.setString(16, null);
/*     */         else {
/* 217 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 220 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 221 */           pstmt.setString(17, null);
/*     */         else {
/* 223 */           pstmt.setString(17, get(i).getPolNo());
/*     */         }
/* 225 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 226 */           pstmt.setString(18, null);
/*     */         else {
/* 228 */           pstmt.setString(18, get(i).getCustomerId());
/*     */         }
/* 230 */         if ((get(i).getMainCustomerNo() == null) || (get(i).getMainCustomerNo().equals("null")))
/* 231 */           pstmt.setString(19, null);
/*     */         else {
/* 233 */           pstmt.setString(19, get(i).getMainCustomerNo());
/*     */         }
/* 235 */         pstmt.addBatch();
/*     */       }
/* 237 */       pstmt.executeBatch();
/* 238 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 241 */       ex.printStackTrace();
/* 242 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 243 */       CError tError = new CError();
/* 244 */       tError.moduleName = "LNPInsuredRelatedDBSet";
/* 245 */       tError.functionName = "update()";
/* 246 */       tError.errorMessage = ex.toString();
/* 247 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 250 */         pstmt.close(); } catch (Exception e) {
/* 251 */         e.printStackTrace();
/*     */       }
/* 253 */       if (!this.mflag) {
/*     */         try {
/* 255 */           this.con.close(); } catch (Exception e) {
/* 256 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 259 */       return false;
/*     */     }
/*     */ 
/* 262 */     if (!this.mflag) {
/*     */       try {
/* 264 */         this.con.close(); } catch (Exception e) {
/* 265 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 268 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 274 */     PreparedStatement pstmt = null;
/*     */ 
/* 276 */     if (!this.mflag) {
/* 277 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 282 */       int tCount = size();
/* 283 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsuredRelated VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 284 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 286 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 287 */           pstmt.setString(1, null);
/*     */         else {
/* 289 */           pstmt.setString(1, get(i).getPolNo());
/*     */         }
/* 291 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 292 */           pstmt.setString(2, null);
/*     */         else {
/* 294 */           pstmt.setString(2, get(i).getCustomerId());
/*     */         }
/* 296 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 297 */           pstmt.setString(3, null);
/*     */         else {
/* 299 */           pstmt.setString(3, get(i).getCustomerNo());
/*     */         }
/* 301 */         if ((get(i).getMainCustomerNo() == null) || (get(i).getMainCustomerNo().equals("null")))
/* 302 */           pstmt.setString(4, null);
/*     */         else {
/* 304 */           pstmt.setString(4, get(i).getMainCustomerNo());
/*     */         }
/* 306 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 307 */           pstmt.setString(5, null);
/*     */         else {
/* 309 */           pstmt.setString(5, get(i).getRelationToInsured());
/*     */         }
/* 311 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 312 */           pstmt.setString(6, null);
/*     */         else {
/* 314 */           pstmt.setString(6, get(i).getAddressNo());
/*     */         }
/* 316 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 317 */           pstmt.setString(7, null);
/*     */         else {
/* 319 */           pstmt.setString(7, get(i).getName());
/*     */         }
/* 321 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 322 */           pstmt.setString(8, null);
/*     */         else {
/* 324 */           pstmt.setString(8, get(i).getSex());
/*     */         }
/* 326 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 327 */           pstmt.setDate(9, null);
/*     */         else {
/* 329 */           pstmt.setDate(9, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 331 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 332 */           pstmt.setString(10, null);
/*     */         else {
/* 334 */           pstmt.setString(10, get(i).getIDType());
/*     */         }
/* 336 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 337 */           pstmt.setString(11, null);
/*     */         else {
/* 339 */           pstmt.setString(11, get(i).getIDNo());
/*     */         }
/* 341 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 342 */           pstmt.setString(12, null);
/*     */         else {
/* 344 */           pstmt.setString(12, get(i).getOperator());
/*     */         }
/* 346 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 347 */           pstmt.setDate(13, null);
/*     */         else {
/* 349 */           pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 351 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 352 */           pstmt.setString(14, null);
/*     */         else {
/* 354 */           pstmt.setString(14, get(i).getMakeTime());
/*     */         }
/* 356 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 357 */           pstmt.setDate(15, null);
/*     */         else {
/* 359 */           pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 361 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 362 */           pstmt.setString(16, null);
/*     */         else {
/* 364 */           pstmt.setString(16, get(i).getModifyTime());
/*     */         }
/* 366 */         pstmt.addBatch();
/*     */       }
/* 368 */       pstmt.executeBatch();
/* 369 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 372 */       ex.printStackTrace();
/* 373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "LNPInsuredRelatedDBSet";
/* 376 */       tError.functionName = "insert()";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         pstmt.close(); } catch (Exception e) {
/* 382 */         e.printStackTrace();
/*     */       }
/* 384 */       if (!this.mflag) {
/*     */         try {
/* 386 */           this.con.close(); } catch (Exception e) {
/* 387 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 390 */       return false;
/*     */     }
/*     */ 
/* 393 */     if (!this.mflag) {
/*     */       try {
/* 395 */         this.con.close(); } catch (Exception e) {
/* 396 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 399 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPInsuredRelatedDBSet
 * JD-Core Version:    0.6.0
 */