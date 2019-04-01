/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MComSchema;
/*     */ import com.sinosoft.map.lis.vschema.MComSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MComDBSet extends MComSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MComDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MCom");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MComDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MCom");
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
/*  49 */     tError.moduleName = "MComDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MCom WHERE  ComCode = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getComCode());
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
/*  86 */       tError.moduleName = "MComDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE  ComCode = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getComCode());
/*     */         }
/* 133 */         if ((get(i).getOutComCode() == null) || (get(i).getOutComCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getOutComCode());
/*     */         }
/* 138 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 143 */         if ((get(i).getShortName() == null) || (get(i).getShortName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getShortName());
/*     */         }
/* 148 */         if ((get(i).getAddress() == null) || (get(i).getAddress().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getAddress());
/*     */         }
/* 153 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getZipCode());
/*     */         }
/* 158 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getPhone());
/*     */         }
/* 163 */         if ((get(i).getFax() == null) || (get(i).getFax().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getFax());
/*     */         }
/* 168 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getEMail());
/*     */         }
/* 173 */         if ((get(i).getWebAddress() == null) || (get(i).getWebAddress().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getWebAddress());
/*     */         }
/* 178 */         if ((get(i).getSatrapName() == null) || (get(i).getSatrapName().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getSatrapName());
/*     */         }
/* 183 */         if ((get(i).getInsuMonitorCode() == null) || (get(i).getInsuMonitorCode().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getInsuMonitorCode());
/*     */         }
/* 188 */         if ((get(i).getInsureID() == null) || (get(i).getInsureID().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getInsureID());
/*     */         }
/* 193 */         if ((get(i).getSignID() == null) || (get(i).getSignID().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getSignID());
/*     */         }
/* 198 */         if ((get(i).getCountry() == null) || (get(i).getCountry().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getCountry());
/*     */         }
/* 203 */         if ((get(i).getProvince() == null) || (get(i).getProvince().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getProvince());
/*     */         }
/* 208 */         if ((get(i).getCity() == null) || (get(i).getCity().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getCity());
/*     */         }
/* 213 */         if ((get(i).getComNature() == null) || (get(i).getComNature().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getComNature());
/*     */         }
/* 218 */         if ((get(i).getValidCode() == null) || (get(i).getValidCode().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getValidCode());
/*     */         }
/* 223 */         if ((get(i).getSign() == null) || (get(i).getSign().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getSign());
/*     */         }
/*     */ 
/* 229 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 230 */           pstmt.setString(21, null);
/*     */         else {
/* 232 */           pstmt.setString(21, get(i).getComCode());
/*     */         }
/* 234 */         pstmt.addBatch();
/*     */       }
/* 236 */       pstmt.executeBatch();
/* 237 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 240 */       ex.printStackTrace();
/* 241 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 242 */       CError tError = new CError();
/* 243 */       tError.moduleName = "MComDBSet";
/* 244 */       tError.functionName = "update()";
/* 245 */       tError.errorMessage = ex.toString();
/* 246 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 249 */         pstmt.close(); } catch (Exception e) {
/* 250 */         e.printStackTrace();
/*     */       }
/* 252 */       if (!this.mflag) {
/*     */         try {
/* 254 */           this.con.close(); } catch (Exception e) {
/* 255 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 258 */       return false;
/*     */     }
/*     */ 
/* 261 */     if (!this.mflag) {
/*     */       try {
/* 263 */         this.con.close(); } catch (Exception e) {
/* 264 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 273 */     PreparedStatement pstmt = null;
/*     */ 
/* 275 */     if (!this.mflag) {
/* 276 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 281 */       int tCount = size();
/* 282 */       pstmt = this.con.prepareStatement("INSERT INTO MCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 283 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 285 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 286 */           pstmt.setString(1, null);
/*     */         else {
/* 288 */           pstmt.setString(1, get(i).getComCode());
/*     */         }
/* 290 */         if ((get(i).getOutComCode() == null) || (get(i).getOutComCode().equals("null")))
/* 291 */           pstmt.setString(2, null);
/*     */         else {
/* 293 */           pstmt.setString(2, get(i).getOutComCode());
/*     */         }
/* 295 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 296 */           pstmt.setString(3, null);
/*     */         else {
/* 298 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 300 */         if ((get(i).getShortName() == null) || (get(i).getShortName().equals("null")))
/* 301 */           pstmt.setString(4, null);
/*     */         else {
/* 303 */           pstmt.setString(4, get(i).getShortName());
/*     */         }
/* 305 */         if ((get(i).getAddress() == null) || (get(i).getAddress().equals("null")))
/* 306 */           pstmt.setString(5, null);
/*     */         else {
/* 308 */           pstmt.setString(5, get(i).getAddress());
/*     */         }
/* 310 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 311 */           pstmt.setString(6, null);
/*     */         else {
/* 313 */           pstmt.setString(6, get(i).getZipCode());
/*     */         }
/* 315 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 316 */           pstmt.setString(7, null);
/*     */         else {
/* 318 */           pstmt.setString(7, get(i).getPhone());
/*     */         }
/* 320 */         if ((get(i).getFax() == null) || (get(i).getFax().equals("null")))
/* 321 */           pstmt.setString(8, null);
/*     */         else {
/* 323 */           pstmt.setString(8, get(i).getFax());
/*     */         }
/* 325 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 326 */           pstmt.setString(9, null);
/*     */         else {
/* 328 */           pstmt.setString(9, get(i).getEMail());
/*     */         }
/* 330 */         if ((get(i).getWebAddress() == null) || (get(i).getWebAddress().equals("null")))
/* 331 */           pstmt.setString(10, null);
/*     */         else {
/* 333 */           pstmt.setString(10, get(i).getWebAddress());
/*     */         }
/* 335 */         if ((get(i).getSatrapName() == null) || (get(i).getSatrapName().equals("null")))
/* 336 */           pstmt.setString(11, null);
/*     */         else {
/* 338 */           pstmt.setString(11, get(i).getSatrapName());
/*     */         }
/* 340 */         if ((get(i).getInsuMonitorCode() == null) || (get(i).getInsuMonitorCode().equals("null")))
/* 341 */           pstmt.setString(12, null);
/*     */         else {
/* 343 */           pstmt.setString(12, get(i).getInsuMonitorCode());
/*     */         }
/* 345 */         if ((get(i).getInsureID() == null) || (get(i).getInsureID().equals("null")))
/* 346 */           pstmt.setString(13, null);
/*     */         else {
/* 348 */           pstmt.setString(13, get(i).getInsureID());
/*     */         }
/* 350 */         if ((get(i).getSignID() == null) || (get(i).getSignID().equals("null")))
/* 351 */           pstmt.setString(14, null);
/*     */         else {
/* 353 */           pstmt.setString(14, get(i).getSignID());
/*     */         }
/* 355 */         if ((get(i).getCountry() == null) || (get(i).getCountry().equals("null")))
/* 356 */           pstmt.setString(15, null);
/*     */         else {
/* 358 */           pstmt.setString(15, get(i).getCountry());
/*     */         }
/* 360 */         if ((get(i).getProvince() == null) || (get(i).getProvince().equals("null")))
/* 361 */           pstmt.setString(16, null);
/*     */         else {
/* 363 */           pstmt.setString(16, get(i).getProvince());
/*     */         }
/* 365 */         if ((get(i).getCity() == null) || (get(i).getCity().equals("null")))
/* 366 */           pstmt.setString(17, null);
/*     */         else {
/* 368 */           pstmt.setString(17, get(i).getCity());
/*     */         }
/* 370 */         if ((get(i).getComNature() == null) || (get(i).getComNature().equals("null")))
/* 371 */           pstmt.setString(18, null);
/*     */         else {
/* 373 */           pstmt.setString(18, get(i).getComNature());
/*     */         }
/* 375 */         if ((get(i).getValidCode() == null) || (get(i).getValidCode().equals("null")))
/* 376 */           pstmt.setString(19, null);
/*     */         else {
/* 378 */           pstmt.setString(19, get(i).getValidCode());
/*     */         }
/* 380 */         if ((get(i).getSign() == null) || (get(i).getSign().equals("null")))
/* 381 */           pstmt.setString(20, null);
/*     */         else {
/* 383 */           pstmt.setString(20, get(i).getSign());
/*     */         }
/* 385 */         pstmt.addBatch();
/*     */       }
/* 387 */       pstmt.executeBatch();
/* 388 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 391 */       ex.printStackTrace();
/* 392 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 393 */       CError tError = new CError();
/* 394 */       tError.moduleName = "MComDBSet";
/* 395 */       tError.functionName = "insert()";
/* 396 */       tError.errorMessage = ex.toString();
/* 397 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 400 */         pstmt.close(); } catch (Exception e) {
/* 401 */         e.printStackTrace();
/*     */       }
/* 403 */       if (!this.mflag) {
/*     */         try {
/* 405 */           this.con.close(); } catch (Exception e) {
/* 406 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 409 */       return false;
/*     */     }
/*     */ 
/* 412 */     if (!this.mflag) {
/*     */       try {
/* 414 */         this.con.close(); } catch (Exception e) {
/* 415 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 418 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MComDBSet
 * JD-Core Version:    0.6.0
 */