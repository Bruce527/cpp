/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MRoleMenuMapBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MRoleMenuMapBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MRoleMenuMapBDBSet extends MRoleMenuMapBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MRoleMenuMapBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MRoleMenuMapB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MRoleMenuMapBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MRoleMenuMapB");
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
/*  49 */     tError.moduleName = "MRoleMenuMapBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleMenuMapB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MRoleMenuMapBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MRoleMenuMapB SET  ID = ? , RoleID = ? , MenuID = ? , Type = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getRoleID());
/*     */         }
/* 138 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getMenuID());
/*     */         }
/* 143 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 148 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 153 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 158 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 163 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 168 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 173 */         pstmt.setInt(10, get(i).getInt1());
/* 174 */         pstmt.setInt(11, get(i).getInt2());
/* 175 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 176 */           pstmt.setString(12, null);
/*     */         else {
/* 178 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 180 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 181 */           pstmt.setString(13, null);
/*     */         else {
/* 183 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/* 185 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getEdorNo());
/*     */         }
/* 190 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 191 */           pstmt.setString(15, null);
/*     */         else {
/* 193 */           pstmt.setString(15, get(i).getEdorType());
/*     */         }
/* 195 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getEdorCase());
/*     */         }
/* 200 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getOperator2());
/*     */         }
/* 205 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 206 */           pstmt.setDate(18, null);
/*     */         else {
/* 208 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 210 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 216 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 217 */           pstmt.setString(20, null);
/*     */         else {
/* 219 */           pstmt.setString(20, get(i).getEdorNo());
/*     */         }
/* 221 */         pstmt.addBatch();
/*     */       }
/* 223 */       pstmt.executeBatch();
/* 224 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 227 */       ex.printStackTrace();
/* 228 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 229 */       CError tError = new CError();
/* 230 */       tError.moduleName = "MRoleMenuMapBDBSet";
/* 231 */       tError.functionName = "update()";
/* 232 */       tError.errorMessage = ex.toString();
/* 233 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 236 */         pstmt.close(); } catch (Exception e) {
/* 237 */         e.printStackTrace();
/*     */       }
/* 239 */       if (!this.mflag) {
/*     */         try {
/* 241 */           this.con.close(); } catch (Exception e) {
/* 242 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 245 */       return false;
/*     */     }
/*     */ 
/* 248 */     if (!this.mflag) {
/*     */       try {
/* 250 */         this.con.close(); } catch (Exception e) {
/* 251 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 260 */     PreparedStatement pstmt = null;
/*     */ 
/* 262 */     if (!this.mflag) {
/* 263 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 268 */       int tCount = size();
/* 269 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleMenuMapB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 270 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 272 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 273 */           pstmt.setString(1, null);
/*     */         else {
/* 275 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 277 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 278 */           pstmt.setString(2, null);
/*     */         else {
/* 280 */           pstmt.setString(2, get(i).getRoleID());
/*     */         }
/* 282 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 283 */           pstmt.setString(3, null);
/*     */         else {
/* 285 */           pstmt.setString(3, get(i).getMenuID());
/*     */         }
/* 287 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 288 */           pstmt.setString(4, null);
/*     */         else {
/* 290 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 292 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 293 */           pstmt.setString(5, null);
/*     */         else {
/* 295 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 297 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 298 */           pstmt.setDate(6, null);
/*     */         else {
/* 300 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 302 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 303 */           pstmt.setString(7, null);
/*     */         else {
/* 305 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 307 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 308 */           pstmt.setDate(8, null);
/*     */         else {
/* 310 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 312 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 313 */           pstmt.setString(9, null);
/*     */         else {
/* 315 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 317 */         pstmt.setInt(10, get(i).getInt1());
/* 318 */         pstmt.setInt(11, get(i).getInt2());
/* 319 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 320 */           pstmt.setString(12, null);
/*     */         else {
/* 322 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 324 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 325 */           pstmt.setString(13, null);
/*     */         else {
/* 327 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/* 329 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 330 */           pstmt.setString(14, null);
/*     */         else {
/* 332 */           pstmt.setString(14, get(i).getEdorNo());
/*     */         }
/* 334 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 335 */           pstmt.setString(15, null);
/*     */         else {
/* 337 */           pstmt.setString(15, get(i).getEdorType());
/*     */         }
/* 339 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 340 */           pstmt.setString(16, null);
/*     */         else {
/* 342 */           pstmt.setString(16, get(i).getEdorCase());
/*     */         }
/* 344 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 345 */           pstmt.setString(17, null);
/*     */         else {
/* 347 */           pstmt.setString(17, get(i).getOperator2());
/*     */         }
/* 349 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 350 */           pstmt.setDate(18, null);
/*     */         else {
/* 352 */           pstmt.setDate(18, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 354 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 355 */           pstmt.setString(19, null);
/*     */         else {
/* 357 */           pstmt.setString(19, get(i).getMakeTime2());
/*     */         }
/* 359 */         pstmt.addBatch();
/*     */       }
/* 361 */       pstmt.executeBatch();
/* 362 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 365 */       ex.printStackTrace();
/* 366 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 367 */       CError tError = new CError();
/* 368 */       tError.moduleName = "MRoleMenuMapBDBSet";
/* 369 */       tError.functionName = "insert()";
/* 370 */       tError.errorMessage = ex.toString();
/* 371 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 374 */         pstmt.close(); } catch (Exception e) {
/* 375 */         e.printStackTrace();
/*     */       }
/* 377 */       if (!this.mflag) {
/*     */         try {
/* 379 */           this.con.close(); } catch (Exception e) {
/* 380 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 383 */       return false;
/*     */     }
/*     */ 
/* 386 */     if (!this.mflag) {
/*     */       try {
/* 388 */         this.con.close(); } catch (Exception e) {
/* 389 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 392 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MRoleMenuMapBDBSet
 * JD-Core Version:    0.6.0
 */