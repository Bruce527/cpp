/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMenuSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMenuSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MMenuDBSet extends MMenuSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MMenuDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MMenu");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMenuDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MMenu");
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
/*  49 */     tError.moduleName = "MMenuDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MMenu WHERE  NodeCode = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getNodeCode());
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
/*  86 */       tError.moduleName = "MMenuDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MMenu SET  NodeCode = ? , NodeName = ? , ParentNodeCode = ? , NodeLevel = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeCode = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNodeCode());
/*     */         }
/* 133 */         if ((get(i).getNodeName() == null) || (get(i).getNodeName().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getNodeName());
/*     */         }
/* 138 */         if ((get(i).getParentNodeCode() == null) || (get(i).getParentNodeCode().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getParentNodeCode());
/*     */         }
/* 143 */         if ((get(i).getNodeLevel() == null) || (get(i).getNodeLevel().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getNodeLevel());
/*     */         }
/* 148 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getChildFlag());
/*     */         }
/* 153 */         if ((get(i).getNodeKey() == null) || (get(i).getNodeKey().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getNodeKey());
/*     */         }
/* 158 */         if ((get(i).getRunScript() == null) || (get(i).getRunScript().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getRunScript());
/*     */         }
/* 163 */         if ((get(i).getNodeDesc() == null) || (get(i).getNodeDesc().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getNodeDesc());
/*     */         }
/* 168 */         if ((get(i).getNodeSign() == null) || (get(i).getNodeSign().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getNodeSign());
/*     */         }
/* 173 */         pstmt.setInt(10, get(i).getNodeOrder());
/* 174 */         pstmt.setInt(11, get(i).getInt1());
/* 175 */         pstmt.setInt(12, get(i).getInt2());
/* 176 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 177 */           pstmt.setString(13, null);
/*     */         else {
/* 179 */           pstmt.setString(13, get(i).getVarc1());
/*     */         }
/* 181 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 182 */           pstmt.setString(14, null);
/*     */         else {
/* 184 */           pstmt.setString(14, get(i).getVarc2());
/*     */         }
/* 186 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 187 */           pstmt.setString(15, null);
/*     */         else {
/* 189 */           pstmt.setString(15, get(i).getOperator());
/*     */         }
/* 191 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 192 */           pstmt.setDate(16, null);
/*     */         else {
/* 194 */           pstmt.setDate(16, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 196 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 197 */           pstmt.setString(17, null);
/*     */         else {
/* 199 */           pstmt.setString(17, get(i).getMakeTime());
/*     */         }
/* 201 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 202 */           pstmt.setDate(18, null);
/*     */         else {
/* 204 */           pstmt.setDate(18, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 206 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 207 */           pstmt.setString(19, null);
/*     */         else {
/* 209 */           pstmt.setString(19, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 212 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/* 213 */           pstmt.setString(20, null);
/*     */         else {
/* 215 */           pstmt.setString(20, get(i).getNodeCode());
/*     */         }
/* 217 */         pstmt.addBatch();
/*     */       }
/* 219 */       pstmt.executeBatch();
/* 220 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 223 */       ex.printStackTrace();
/* 224 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 225 */       CError tError = new CError();
/* 226 */       tError.moduleName = "MMenuDBSet";
/* 227 */       tError.functionName = "update()";
/* 228 */       tError.errorMessage = ex.toString();
/* 229 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 232 */         pstmt.close(); } catch (Exception e) {
/* 233 */         e.printStackTrace();
/*     */       }
/* 235 */       if (!this.mflag) {
/*     */         try {
/* 237 */           this.con.close(); } catch (Exception e) {
/* 238 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 241 */       return false;
/*     */     }
/*     */ 
/* 244 */     if (!this.mflag) {
/*     */       try {
/* 246 */         this.con.close(); } catch (Exception e) {
/* 247 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 256 */     PreparedStatement pstmt = null;
/*     */ 
/* 258 */     if (!this.mflag) {
/* 259 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 264 */       int tCount = size();
/* 265 */       pstmt = this.con.prepareStatement("INSERT INTO MMenu VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 266 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 268 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/* 269 */           pstmt.setString(1, null);
/*     */         else {
/* 271 */           pstmt.setString(1, get(i).getNodeCode());
/*     */         }
/* 273 */         if ((get(i).getNodeName() == null) || (get(i).getNodeName().equals("null")))
/* 274 */           pstmt.setString(2, null);
/*     */         else {
/* 276 */           pstmt.setString(2, get(i).getNodeName());
/*     */         }
/* 278 */         if ((get(i).getParentNodeCode() == null) || (get(i).getParentNodeCode().equals("null")))
/* 279 */           pstmt.setString(3, null);
/*     */         else {
/* 281 */           pstmt.setString(3, get(i).getParentNodeCode());
/*     */         }
/* 283 */         if ((get(i).getNodeLevel() == null) || (get(i).getNodeLevel().equals("null")))
/* 284 */           pstmt.setString(4, null);
/*     */         else {
/* 286 */           pstmt.setString(4, get(i).getNodeLevel());
/*     */         }
/* 288 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 289 */           pstmt.setString(5, null);
/*     */         else {
/* 291 */           pstmt.setString(5, get(i).getChildFlag());
/*     */         }
/* 293 */         if ((get(i).getNodeKey() == null) || (get(i).getNodeKey().equals("null")))
/* 294 */           pstmt.setString(6, null);
/*     */         else {
/* 296 */           pstmt.setString(6, get(i).getNodeKey());
/*     */         }
/* 298 */         if ((get(i).getRunScript() == null) || (get(i).getRunScript().equals("null")))
/* 299 */           pstmt.setString(7, null);
/*     */         else {
/* 301 */           pstmt.setString(7, get(i).getRunScript());
/*     */         }
/* 303 */         if ((get(i).getNodeDesc() == null) || (get(i).getNodeDesc().equals("null")))
/* 304 */           pstmt.setString(8, null);
/*     */         else {
/* 306 */           pstmt.setString(8, get(i).getNodeDesc());
/*     */         }
/* 308 */         if ((get(i).getNodeSign() == null) || (get(i).getNodeSign().equals("null")))
/* 309 */           pstmt.setString(9, null);
/*     */         else {
/* 311 */           pstmt.setString(9, get(i).getNodeSign());
/*     */         }
/* 313 */         pstmt.setInt(10, get(i).getNodeOrder());
/* 314 */         pstmt.setInt(11, get(i).getInt1());
/* 315 */         pstmt.setInt(12, get(i).getInt2());
/* 316 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 317 */           pstmt.setString(13, null);
/*     */         else {
/* 319 */           pstmt.setString(13, get(i).getVarc1());
/*     */         }
/* 321 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 322 */           pstmt.setString(14, null);
/*     */         else {
/* 324 */           pstmt.setString(14, get(i).getVarc2());
/*     */         }
/* 326 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 327 */           pstmt.setString(15, null);
/*     */         else {
/* 329 */           pstmt.setString(15, get(i).getOperator());
/*     */         }
/* 331 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 332 */           pstmt.setDate(16, null);
/*     */         else {
/* 334 */           pstmt.setDate(16, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 336 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 337 */           pstmt.setString(17, null);
/*     */         else {
/* 339 */           pstmt.setString(17, get(i).getMakeTime());
/*     */         }
/* 341 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 342 */           pstmt.setDate(18, null);
/*     */         else {
/* 344 */           pstmt.setDate(18, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 346 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 347 */           pstmt.setString(19, null);
/*     */         else {
/* 349 */           pstmt.setString(19, get(i).getModifyTime());
/*     */         }
/* 351 */         pstmt.addBatch();
/*     */       }
/* 353 */       pstmt.executeBatch();
/* 354 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 357 */       ex.printStackTrace();
/* 358 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 359 */       CError tError = new CError();
/* 360 */       tError.moduleName = "MMenuDBSet";
/* 361 */       tError.functionName = "insert()";
/* 362 */       tError.errorMessage = ex.toString();
/* 363 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 366 */         pstmt.close(); } catch (Exception e) {
/* 367 */         e.printStackTrace();
/*     */       }
/* 369 */       if (!this.mflag) {
/*     */         try {
/* 371 */           this.con.close(); } catch (Exception e) {
/* 372 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 375 */       return false;
/*     */     }
/*     */ 
/* 378 */     if (!this.mflag) {
/*     */       try {
/* 380 */         this.con.close(); } catch (Exception e) {
/* 381 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 384 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MMenuDBSet
 * JD-Core Version:    0.6.0
 */