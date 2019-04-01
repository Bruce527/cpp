/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MRoleInfoSchema;
/*     */ import com.sinosoft.map.lis.vschema.MRoleInfoSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MRoleInfoDBSet extends MRoleInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MRoleInfoDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MRoleInfo");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MRoleInfoDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MRoleInfo");
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
/*  49 */     tError.moduleName = "MRoleInfoDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleInfo WHERE  ID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getID());
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
/*  86 */       tError.moduleName = "MRoleInfoDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MRoleInfo SET  ID = ? , RoleCode = ? , Name = ? , Parent = ? , Describe = ? , RoleState = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 138 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 143 */         if ((get(i).getParent() == null) || (get(i).getParent().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getParent());
/*     */         }
/* 148 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getDescribe());
/*     */         }
/* 153 */         if ((get(i).getRoleState() == null) || (get(i).getRoleState().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getRoleState());
/*     */         }
/* 158 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 163 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 168 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 173 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 178 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 183 */         pstmt.setInt(12, get(i).getInt1());
/* 184 */         pstmt.setInt(13, get(i).getInt2());
/* 185 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 190 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 191 */           pstmt.setString(15, null);
/*     */         else {
/* 193 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/* 195 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getVarc3());
/*     */         }
/*     */ 
/* 201 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 202 */           pstmt.setString(17, null);
/*     */         else {
/* 204 */           pstmt.setString(17, get(i).getID());
/*     */         }
/* 206 */         pstmt.addBatch();
/*     */       }
/* 208 */       pstmt.executeBatch();
/* 209 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 212 */       ex.printStackTrace();
/* 213 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 214 */       CError tError = new CError();
/* 215 */       tError.moduleName = "MRoleInfoDBSet";
/* 216 */       tError.functionName = "update()";
/* 217 */       tError.errorMessage = ex.toString();
/* 218 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 221 */         pstmt.close(); } catch (Exception e) {
/* 222 */         e.printStackTrace();
/*     */       }
/* 224 */       if (!this.mflag) {
/*     */         try {
/* 226 */           this.con.close(); } catch (Exception e) {
/* 227 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 230 */       return false;
/*     */     }
/*     */ 
/* 233 */     if (!this.mflag) {
/*     */       try {
/* 235 */         this.con.close(); } catch (Exception e) {
/* 236 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 245 */     PreparedStatement pstmt = null;
/*     */ 
/* 247 */     if (!this.mflag) {
/* 248 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 253 */       int tCount = size();
/* 254 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 255 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 257 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 258 */           pstmt.setString(1, null);
/*     */         else {
/* 260 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 262 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 263 */           pstmt.setString(2, null);
/*     */         else {
/* 265 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 267 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 268 */           pstmt.setString(3, null);
/*     */         else {
/* 270 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 272 */         if ((get(i).getParent() == null) || (get(i).getParent().equals("null")))
/* 273 */           pstmt.setString(4, null);
/*     */         else {
/* 275 */           pstmt.setString(4, get(i).getParent());
/*     */         }
/* 277 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 278 */           pstmt.setString(5, null);
/*     */         else {
/* 280 */           pstmt.setString(5, get(i).getDescribe());
/*     */         }
/* 282 */         if ((get(i).getRoleState() == null) || (get(i).getRoleState().equals("null")))
/* 283 */           pstmt.setString(6, null);
/*     */         else {
/* 285 */           pstmt.setString(6, get(i).getRoleState());
/*     */         }
/* 287 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 288 */           pstmt.setString(7, null);
/*     */         else {
/* 290 */           pstmt.setString(7, get(i).getOperator());
/*     */         }
/* 292 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 293 */           pstmt.setDate(8, null);
/*     */         else {
/* 295 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 297 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 298 */           pstmt.setString(9, null);
/*     */         else {
/* 300 */           pstmt.setString(9, get(i).getMakeTime());
/*     */         }
/* 302 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 303 */           pstmt.setDate(10, null);
/*     */         else {
/* 305 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 307 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 308 */           pstmt.setString(11, null);
/*     */         else {
/* 310 */           pstmt.setString(11, get(i).getModifyTime());
/*     */         }
/* 312 */         pstmt.setInt(12, get(i).getInt1());
/* 313 */         pstmt.setInt(13, get(i).getInt2());
/* 314 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 315 */           pstmt.setString(14, null);
/*     */         else {
/* 317 */           pstmt.setString(14, get(i).getVarc1());
/*     */         }
/* 319 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 320 */           pstmt.setString(15, null);
/*     */         else {
/* 322 */           pstmt.setString(15, get(i).getVarc2());
/*     */         }
/* 324 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 325 */           pstmt.setString(16, null);
/*     */         else {
/* 327 */           pstmt.setString(16, get(i).getVarc3());
/*     */         }
/* 329 */         pstmt.addBatch();
/*     */       }
/* 331 */       pstmt.executeBatch();
/* 332 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 335 */       ex.printStackTrace();
/* 336 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 337 */       CError tError = new CError();
/* 338 */       tError.moduleName = "MRoleInfoDBSet";
/* 339 */       tError.functionName = "insert()";
/* 340 */       tError.errorMessage = ex.toString();
/* 341 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 344 */         pstmt.close(); } catch (Exception e) {
/* 345 */         e.printStackTrace();
/*     */       }
/* 347 */       if (!this.mflag) {
/*     */         try {
/* 349 */           this.con.close(); } catch (Exception e) {
/* 350 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 353 */       return false;
/*     */     }
/*     */ 
/* 356 */     if (!this.mflag) {
/*     */       try {
/* 358 */         this.con.close(); } catch (Exception e) {
/* 359 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 362 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MRoleInfoDBSet
 * JD-Core Version:    0.6.0
 */