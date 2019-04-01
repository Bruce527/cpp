/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCheckFieldDBSet extends LNPCheckFieldSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCheckFieldDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCheckField");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCheckFieldDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCheckField");
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
/*  50 */     tError.moduleName = "LNPCheckFieldDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/*  83 */         if ((get(i).getFieldName() == null) || (get(i).getFieldName().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getFieldName());
/*     */         }
/*  88 */         if ((get(i).getSerialNo() == null) || (get(i).getSerialNo().equals("null")))
/*  89 */           pstmt.setString(4, null);
/*     */         else {
/*  91 */           pstmt.setString(4, get(i).getSerialNo());
/*     */         }
/*  93 */         pstmt.addBatch();
/*     */       }
/*  95 */       pstmt.executeBatch();
/*  96 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  99 */       ex.printStackTrace();
/* 100 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "LNPCheckFieldDBSet";
/* 103 */       tError.functionName = "delete()";
/* 104 */       tError.errorMessage = ex.toString();
/* 105 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 108 */         pstmt.close(); } catch (Exception e) {
/* 109 */         e.printStackTrace();
/*     */       }
/* 111 */       if (!this.mflag) {
/*     */         try {
/* 113 */           this.con.close(); } catch (Exception e) {
/* 114 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 117 */       return false;
/*     */     }
/*     */ 
/* 120 */     if (!this.mflag) {
/*     */       try {
/* 122 */         this.con.close(); } catch (Exception e) {
/* 123 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 132 */     PreparedStatement pstmt = null;
/*     */ 
/* 134 */     if (!this.mflag) {
/* 135 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 140 */       int tCount = size();
/* 141 */       pstmt = this.con.prepareStatement("UPDATE LNPCheckField SET  RiskCode = ? , RiskVer = ? , FieldName = ? , SerialNo = ? , CalCode = ? , PageLocation = ? , Location = ? , Msg = ? , MsgFlag = ? , UpdFlag = ? , ValiFlag = ? , ReturnValiFlag = ? WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
/* 142 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 144 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 145 */           pstmt.setString(1, null);
/*     */         else {
/* 147 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 149 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 150 */           pstmt.setString(2, null);
/*     */         else {
/* 152 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 154 */         if ((get(i).getFieldName() == null) || (get(i).getFieldName().equals("null")))
/* 155 */           pstmt.setString(3, null);
/*     */         else {
/* 157 */           pstmt.setString(3, get(i).getFieldName());
/*     */         }
/* 159 */         if ((get(i).getSerialNo() == null) || (get(i).getSerialNo().equals("null")))
/* 160 */           pstmt.setString(4, null);
/*     */         else {
/* 162 */           pstmt.setString(4, get(i).getSerialNo());
/*     */         }
/* 164 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 165 */           pstmt.setString(5, null);
/*     */         else {
/* 167 */           pstmt.setString(5, get(i).getCalCode());
/*     */         }
/* 169 */         if ((get(i).getPageLocation() == null) || (get(i).getPageLocation().equals("null")))
/* 170 */           pstmt.setString(6, null);
/*     */         else {
/* 172 */           pstmt.setString(6, get(i).getPageLocation());
/*     */         }
/* 174 */         if ((get(i).getLocation() == null) || (get(i).getLocation().equals("null")))
/* 175 */           pstmt.setString(7, null);
/*     */         else {
/* 177 */           pstmt.setString(7, get(i).getLocation());
/*     */         }
/* 179 */         if ((get(i).getMsg() == null) || (get(i).getMsg().equals("null")))
/* 180 */           pstmt.setString(8, null);
/*     */         else {
/* 182 */           pstmt.setString(8, get(i).getMsg());
/*     */         }
/* 184 */         if ((get(i).getMsgFlag() == null) || (get(i).getMsgFlag().equals("null")))
/* 185 */           pstmt.setString(9, null);
/*     */         else {
/* 187 */           pstmt.setString(9, get(i).getMsgFlag());
/*     */         }
/* 189 */         if ((get(i).getUpdFlag() == null) || (get(i).getUpdFlag().equals("null")))
/* 190 */           pstmt.setString(10, null);
/*     */         else {
/* 192 */           pstmt.setString(10, get(i).getUpdFlag());
/*     */         }
/* 194 */         if ((get(i).getValiFlag() == null) || (get(i).getValiFlag().equals("null")))
/* 195 */           pstmt.setString(11, null);
/*     */         else {
/* 197 */           pstmt.setString(11, get(i).getValiFlag());
/*     */         }
/* 199 */         if ((get(i).getReturnValiFlag() == null) || (get(i).getReturnValiFlag().equals("null")))
/* 200 */           pstmt.setString(12, null);
/*     */         else {
/* 202 */           pstmt.setString(12, get(i).getReturnValiFlag());
/*     */         }
/*     */ 
/* 205 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 206 */           pstmt.setString(13, null);
/*     */         else {
/* 208 */           pstmt.setString(13, get(i).getRiskCode());
/*     */         }
/* 210 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 211 */           pstmt.setString(14, null);
/*     */         else {
/* 213 */           pstmt.setString(14, get(i).getRiskVer());
/*     */         }
/* 215 */         if ((get(i).getFieldName() == null) || (get(i).getFieldName().equals("null")))
/* 216 */           pstmt.setString(15, null);
/*     */         else {
/* 218 */           pstmt.setString(15, get(i).getFieldName());
/*     */         }
/* 220 */         if ((get(i).getSerialNo() == null) || (get(i).getSerialNo().equals("null")))
/* 221 */           pstmt.setString(16, null);
/*     */         else {
/* 223 */           pstmt.setString(16, get(i).getSerialNo());
/*     */         }
/* 225 */         pstmt.addBatch();
/*     */       }
/* 227 */       pstmt.executeBatch();
/* 228 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 231 */       ex.printStackTrace();
/* 232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 233 */       CError tError = new CError();
/* 234 */       tError.moduleName = "LNPCheckFieldDBSet";
/* 235 */       tError.functionName = "update()";
/* 236 */       tError.errorMessage = ex.toString();
/* 237 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 240 */         pstmt.close(); } catch (Exception e) {
/* 241 */         e.printStackTrace();
/*     */       }
/* 243 */       if (!this.mflag) {
/*     */         try {
/* 245 */           this.con.close(); } catch (Exception e) {
/* 246 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 249 */       return false;
/*     */     }
/*     */ 
/* 252 */     if (!this.mflag) {
/*     */       try {
/* 254 */         this.con.close(); } catch (Exception e) {
/* 255 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 264 */     PreparedStatement pstmt = null;
/*     */ 
/* 266 */     if (!this.mflag) {
/* 267 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 272 */       int tCount = size();
/* 273 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCheckField VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 274 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 276 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 277 */           pstmt.setString(1, null);
/*     */         else {
/* 279 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 281 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 282 */           pstmt.setString(2, null);
/*     */         else {
/* 284 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 286 */         if ((get(i).getFieldName() == null) || (get(i).getFieldName().equals("null")))
/* 287 */           pstmt.setString(3, null);
/*     */         else {
/* 289 */           pstmt.setString(3, get(i).getFieldName());
/*     */         }
/* 291 */         if ((get(i).getSerialNo() == null) || (get(i).getSerialNo().equals("null")))
/* 292 */           pstmt.setString(4, null);
/*     */         else {
/* 294 */           pstmt.setString(4, get(i).getSerialNo());
/*     */         }
/* 296 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 297 */           pstmt.setString(5, null);
/*     */         else {
/* 299 */           pstmt.setString(5, get(i).getCalCode());
/*     */         }
/* 301 */         if ((get(i).getPageLocation() == null) || (get(i).getPageLocation().equals("null")))
/* 302 */           pstmt.setString(6, null);
/*     */         else {
/* 304 */           pstmt.setString(6, get(i).getPageLocation());
/*     */         }
/* 306 */         if ((get(i).getLocation() == null) || (get(i).getLocation().equals("null")))
/* 307 */           pstmt.setString(7, null);
/*     */         else {
/* 309 */           pstmt.setString(7, get(i).getLocation());
/*     */         }
/* 311 */         if ((get(i).getMsg() == null) || (get(i).getMsg().equals("null")))
/* 312 */           pstmt.setString(8, null);
/*     */         else {
/* 314 */           pstmt.setString(8, get(i).getMsg());
/*     */         }
/* 316 */         if ((get(i).getMsgFlag() == null) || (get(i).getMsgFlag().equals("null")))
/* 317 */           pstmt.setString(9, null);
/*     */         else {
/* 319 */           pstmt.setString(9, get(i).getMsgFlag());
/*     */         }
/* 321 */         if ((get(i).getUpdFlag() == null) || (get(i).getUpdFlag().equals("null")))
/* 322 */           pstmt.setString(10, null);
/*     */         else {
/* 324 */           pstmt.setString(10, get(i).getUpdFlag());
/*     */         }
/* 326 */         if ((get(i).getValiFlag() == null) || (get(i).getValiFlag().equals("null")))
/* 327 */           pstmt.setString(11, null);
/*     */         else {
/* 329 */           pstmt.setString(11, get(i).getValiFlag());
/*     */         }
/* 331 */         if ((get(i).getReturnValiFlag() == null) || (get(i).getReturnValiFlag().equals("null")))
/* 332 */           pstmt.setString(12, null);
/*     */         else {
/* 334 */           pstmt.setString(12, get(i).getReturnValiFlag());
/*     */         }
/* 336 */         pstmt.addBatch();
/*     */       }
/* 338 */       pstmt.executeBatch();
/* 339 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 342 */       ex.printStackTrace();
/* 343 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 344 */       CError tError = new CError();
/* 345 */       tError.moduleName = "LNPCheckFieldDBSet";
/* 346 */       tError.functionName = "insert()";
/* 347 */       tError.errorMessage = ex.toString();
/* 348 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 351 */         pstmt.close(); } catch (Exception e) {
/* 352 */         e.printStackTrace();
/*     */       }
/* 354 */       if (!this.mflag) {
/*     */         try {
/* 356 */           this.con.close(); } catch (Exception e) {
/* 357 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 360 */       return false;
/*     */     }
/*     */ 
/* 363 */     if (!this.mflag) {
/*     */       try {
/* 365 */         this.con.close(); } catch (Exception e) {
/* 366 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 369 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCheckFieldDBSet
 * JD-Core Version:    0.6.0
 */