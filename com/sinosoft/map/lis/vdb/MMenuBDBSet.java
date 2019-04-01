/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMenuBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMenuBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MMenuBDBSet extends MMenuBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MMenuBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MMenuB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMenuBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MMenuB");
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
/*  49 */     tError.moduleName = "MMenuBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MMenuB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MMenuBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MMenuB SET  NodeCode = ? , ParentID = ? , NodeLevel = ? , NodeName = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNodeCode());
/*     */         }
/* 133 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getParentID());
/*     */         }
/* 138 */         if ((get(i).getNodeLevel() == null) || (get(i).getNodeLevel().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getNodeLevel());
/*     */         }
/* 143 */         if ((get(i).getNodeName() == null) || (get(i).getNodeName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getNodeName());
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
/* 211 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 212 */           pstmt.setString(20, null);
/*     */         else {
/* 214 */           pstmt.setString(20, get(i).getEdorNo());
/*     */         }
/* 216 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 217 */           pstmt.setString(21, null);
/*     */         else {
/* 219 */           pstmt.setString(21, get(i).getEdorType());
/*     */         }
/* 221 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 222 */           pstmt.setString(22, null);
/*     */         else {
/* 224 */           pstmt.setString(22, get(i).getEdorCase());
/*     */         }
/* 226 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 227 */           pstmt.setString(23, null);
/*     */         else {
/* 229 */           pstmt.setString(23, get(i).getOperator2());
/*     */         }
/* 231 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 232 */           pstmt.setDate(24, null);
/*     */         else {
/* 234 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 236 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 237 */           pstmt.setString(25, null);
/*     */         else {
/* 239 */           pstmt.setString(25, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 242 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 243 */           pstmt.setString(26, null);
/*     */         else {
/* 245 */           pstmt.setString(26, get(i).getEdorNo());
/*     */         }
/* 247 */         pstmt.addBatch();
/*     */       }
/* 249 */       pstmt.executeBatch();
/* 250 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 253 */       ex.printStackTrace();
/* 254 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 255 */       CError tError = new CError();
/* 256 */       tError.moduleName = "MMenuBDBSet";
/* 257 */       tError.functionName = "update()";
/* 258 */       tError.errorMessage = ex.toString();
/* 259 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 262 */         pstmt.close(); } catch (Exception e) {
/* 263 */         e.printStackTrace();
/*     */       }
/* 265 */       if (!this.mflag) {
/*     */         try {
/* 267 */           this.con.close(); } catch (Exception e) {
/* 268 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 271 */       return false;
/*     */     }
/*     */ 
/* 274 */     if (!this.mflag) {
/*     */       try {
/* 276 */         this.con.close(); } catch (Exception e) {
/* 277 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 280 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 286 */     PreparedStatement pstmt = null;
/*     */ 
/* 288 */     if (!this.mflag) {
/* 289 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 294 */       int tCount = size();
/* 295 */       pstmt = this.con.prepareStatement("INSERT INTO MMenuB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 296 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 298 */         if ((get(i).getNodeCode() == null) || (get(i).getNodeCode().equals("null")))
/* 299 */           pstmt.setString(1, null);
/*     */         else {
/* 301 */           pstmt.setString(1, get(i).getNodeCode());
/*     */         }
/* 303 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 304 */           pstmt.setString(2, null);
/*     */         else {
/* 306 */           pstmt.setString(2, get(i).getParentID());
/*     */         }
/* 308 */         if ((get(i).getNodeLevel() == null) || (get(i).getNodeLevel().equals("null")))
/* 309 */           pstmt.setString(3, null);
/*     */         else {
/* 311 */           pstmt.setString(3, get(i).getNodeLevel());
/*     */         }
/* 313 */         if ((get(i).getNodeName() == null) || (get(i).getNodeName().equals("null")))
/* 314 */           pstmt.setString(4, null);
/*     */         else {
/* 316 */           pstmt.setString(4, get(i).getNodeName());
/*     */         }
/* 318 */         if ((get(i).getChildFlag() == null) || (get(i).getChildFlag().equals("null")))
/* 319 */           pstmt.setString(5, null);
/*     */         else {
/* 321 */           pstmt.setString(5, get(i).getChildFlag());
/*     */         }
/* 323 */         if ((get(i).getNodeKey() == null) || (get(i).getNodeKey().equals("null")))
/* 324 */           pstmt.setString(6, null);
/*     */         else {
/* 326 */           pstmt.setString(6, get(i).getNodeKey());
/*     */         }
/* 328 */         if ((get(i).getRunScript() == null) || (get(i).getRunScript().equals("null")))
/* 329 */           pstmt.setString(7, null);
/*     */         else {
/* 331 */           pstmt.setString(7, get(i).getRunScript());
/*     */         }
/* 333 */         if ((get(i).getNodeDesc() == null) || (get(i).getNodeDesc().equals("null")))
/* 334 */           pstmt.setString(8, null);
/*     */         else {
/* 336 */           pstmt.setString(8, get(i).getNodeDesc());
/*     */         }
/* 338 */         if ((get(i).getNodeSign() == null) || (get(i).getNodeSign().equals("null")))
/* 339 */           pstmt.setString(9, null);
/*     */         else {
/* 341 */           pstmt.setString(9, get(i).getNodeSign());
/*     */         }
/* 343 */         pstmt.setInt(10, get(i).getNodeOrder());
/* 344 */         pstmt.setInt(11, get(i).getInt1());
/* 345 */         pstmt.setInt(12, get(i).getInt2());
/* 346 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 347 */           pstmt.setString(13, null);
/*     */         else {
/* 349 */           pstmt.setString(13, get(i).getVarc1());
/*     */         }
/* 351 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 352 */           pstmt.setString(14, null);
/*     */         else {
/* 354 */           pstmt.setString(14, get(i).getVarc2());
/*     */         }
/* 356 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 357 */           pstmt.setString(15, null);
/*     */         else {
/* 359 */           pstmt.setString(15, get(i).getOperator());
/*     */         }
/* 361 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 362 */           pstmt.setDate(16, null);
/*     */         else {
/* 364 */           pstmt.setDate(16, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 366 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 367 */           pstmt.setString(17, null);
/*     */         else {
/* 369 */           pstmt.setString(17, get(i).getMakeTime());
/*     */         }
/* 371 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 372 */           pstmt.setDate(18, null);
/*     */         else {
/* 374 */           pstmt.setDate(18, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 376 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 377 */           pstmt.setString(19, null);
/*     */         else {
/* 379 */           pstmt.setString(19, get(i).getModifyTime());
/*     */         }
/* 381 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 382 */           pstmt.setString(20, null);
/*     */         else {
/* 384 */           pstmt.setString(20, get(i).getEdorNo());
/*     */         }
/* 386 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 387 */           pstmt.setString(21, null);
/*     */         else {
/* 389 */           pstmt.setString(21, get(i).getEdorType());
/*     */         }
/* 391 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 392 */           pstmt.setString(22, null);
/*     */         else {
/* 394 */           pstmt.setString(22, get(i).getEdorCase());
/*     */         }
/* 396 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 397 */           pstmt.setString(23, null);
/*     */         else {
/* 399 */           pstmt.setString(23, get(i).getOperator2());
/*     */         }
/* 401 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 402 */           pstmt.setDate(24, null);
/*     */         else {
/* 404 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 406 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 407 */           pstmt.setString(25, null);
/*     */         else {
/* 409 */           pstmt.setString(25, get(i).getMakeTime2());
/*     */         }
/* 411 */         pstmt.addBatch();
/*     */       }
/* 413 */       pstmt.executeBatch();
/* 414 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 417 */       ex.printStackTrace();
/* 418 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 419 */       CError tError = new CError();
/* 420 */       tError.moduleName = "MMenuBDBSet";
/* 421 */       tError.functionName = "insert()";
/* 422 */       tError.errorMessage = ex.toString();
/* 423 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 426 */         pstmt.close(); } catch (Exception e) {
/* 427 */         e.printStackTrace();
/*     */       }
/* 429 */       if (!this.mflag) {
/*     */         try {
/* 431 */           this.con.close(); } catch (Exception e) {
/* 432 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 435 */       return false;
/*     */     }
/*     */ 
/* 438 */     if (!this.mflag) {
/*     */       try {
/* 440 */         this.con.close(); } catch (Exception e) {
/* 441 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 444 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MMenuBDBSet
 * JD-Core Version:    0.6.0
 */