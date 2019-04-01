/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewsContentBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsContentBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewsContentBDBSet extends MNewsContentBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewsContentBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNewsContentB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewsContentBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNewsContentB");
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
/*  49 */     tError.moduleName = "MNewsContentBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsContentB WHERE  EdorNo = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getEdorNo());
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
/*  86 */       tError.moduleName = "MNewsContentBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNewsContentB SET  ContentID = ? , NewsID = ? , Content = ? , ContOrder = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getContentID());
/*     */         }
/* 133 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getNewsID());
/*     */         }
/* 138 */         if ((get(i).getContent() == null) || (get(i).getContent().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getContent());
/*     */         }
/* 143 */         pstmt.setInt(4, get(i).getContOrder());
/* 144 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 145 */           pstmt.setString(5, null);
/*     */         else {
/* 147 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 149 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 150 */           pstmt.setDate(6, null);
/*     */         else {
/* 152 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 154 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 159 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 160 */           pstmt.setDate(8, null);
/*     */         else {
/* 162 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 164 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 169 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getEdorNo());
/*     */         }
/* 174 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getEdorType());
/*     */         }
/* 179 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getEdorCase());
/*     */         }
/* 184 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getOperator2());
/*     */         }
/* 189 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 190 */           pstmt.setDate(14, null);
/*     */         else {
/* 192 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 194 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 195 */           pstmt.setString(15, null);
/*     */         else {
/* 197 */           pstmt.setString(15, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 200 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getEdorNo());
/*     */         }
/* 205 */         pstmt.addBatch();
/*     */       }
/* 207 */       pstmt.executeBatch();
/* 208 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 211 */       ex.printStackTrace();
/* 212 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 213 */       CError tError = new CError();
/* 214 */       tError.moduleName = "MNewsContentBDBSet";
/* 215 */       tError.functionName = "update()";
/* 216 */       tError.errorMessage = ex.toString();
/* 217 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 220 */         pstmt.close(); } catch (Exception e) {
/* 221 */         e.printStackTrace();
/*     */       }
/* 223 */       if (!this.mflag) {
/*     */         try {
/* 225 */           this.con.close(); } catch (Exception e) {
/* 226 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     if (!this.mflag) {
/*     */       try {
/* 234 */         this.con.close(); } catch (Exception e) {
/* 235 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 244 */     PreparedStatement pstmt = null;
/*     */ 
/* 246 */     if (!this.mflag) {
/* 247 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 252 */       int tCount = size();
/* 253 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsContentB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 254 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 256 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/* 257 */           pstmt.setString(1, null);
/*     */         else {
/* 259 */           pstmt.setString(1, get(i).getContentID());
/*     */         }
/* 261 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 262 */           pstmt.setString(2, null);
/*     */         else {
/* 264 */           pstmt.setString(2, get(i).getNewsID());
/*     */         }
/* 266 */         if ((get(i).getContent() == null) || (get(i).getContent().equals("null")))
/* 267 */           pstmt.setString(3, null);
/*     */         else {
/* 269 */           pstmt.setString(3, get(i).getContent());
/*     */         }
/* 271 */         pstmt.setInt(4, get(i).getContOrder());
/* 272 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 273 */           pstmt.setString(5, null);
/*     */         else {
/* 275 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 277 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 278 */           pstmt.setDate(6, null);
/*     */         else {
/* 280 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 282 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 283 */           pstmt.setString(7, null);
/*     */         else {
/* 285 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 287 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 288 */           pstmt.setDate(8, null);
/*     */         else {
/* 290 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 292 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 293 */           pstmt.setString(9, null);
/*     */         else {
/* 295 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 297 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 298 */           pstmt.setString(10, null);
/*     */         else {
/* 300 */           pstmt.setString(10, get(i).getEdorNo());
/*     */         }
/* 302 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 303 */           pstmt.setString(11, null);
/*     */         else {
/* 305 */           pstmt.setString(11, get(i).getEdorType());
/*     */         }
/* 307 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 308 */           pstmt.setString(12, null);
/*     */         else {
/* 310 */           pstmt.setString(12, get(i).getEdorCase());
/*     */         }
/* 312 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 313 */           pstmt.setString(13, null);
/*     */         else {
/* 315 */           pstmt.setString(13, get(i).getOperator2());
/*     */         }
/* 317 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 318 */           pstmt.setDate(14, null);
/*     */         else {
/* 320 */           pstmt.setDate(14, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 322 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 323 */           pstmt.setString(15, null);
/*     */         else {
/* 325 */           pstmt.setString(15, get(i).getMakeTime2());
/*     */         }
/* 327 */         pstmt.addBatch();
/*     */       }
/* 329 */       pstmt.executeBatch();
/* 330 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 333 */       ex.printStackTrace();
/* 334 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 335 */       CError tError = new CError();
/* 336 */       tError.moduleName = "MNewsContentBDBSet";
/* 337 */       tError.functionName = "insert()";
/* 338 */       tError.errorMessage = ex.toString();
/* 339 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 342 */         pstmt.close(); } catch (Exception e) {
/* 343 */         e.printStackTrace();
/*     */       }
/* 345 */       if (!this.mflag) {
/*     */         try {
/* 347 */           this.con.close(); } catch (Exception e) {
/* 348 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 351 */       return false;
/*     */     }
/*     */ 
/* 354 */     if (!this.mflag) {
/*     */       try {
/* 356 */         this.con.close(); } catch (Exception e) {
/* 357 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 360 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewsContentBDBSet
 * JD-Core Version:    0.6.0
 */