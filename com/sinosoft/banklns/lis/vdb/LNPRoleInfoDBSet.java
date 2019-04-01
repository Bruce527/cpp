/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRoleInfoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRoleInfoSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRoleInfoDBSet extends LNPRoleInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRoleInfoDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRoleInfo");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRoleInfoDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRoleInfo");
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
/*  50 */     tError.moduleName = "LNPRoleInfoDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRoleInfo WHERE  ID = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getID());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPRoleInfoDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPRoleInfo SET  ID = ? , RoleCode = ? , Name = ? , Describe = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 134 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 139 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 144 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getDescribe());
/*     */         }
/* 149 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 154 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 155 */           pstmt.setDate(6, null);
/*     */         else {
/* 157 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 159 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 164 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 165 */           pstmt.setDate(8, null);
/*     */         else {
/* 167 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 169 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 174 */         pstmt.setInt(10, get(i).getInt1());
/* 175 */         pstmt.setInt(11, get(i).getInt2());
/* 176 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 177 */           pstmt.setString(12, null);
/*     */         else {
/* 179 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 181 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 182 */           pstmt.setString(13, null);
/*     */         else {
/* 184 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/* 186 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 187 */           pstmt.setString(14, null);
/*     */         else {
/* 189 */           pstmt.setString(14, get(i).getVarc3());
/*     */         }
/*     */ 
/* 192 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 193 */           pstmt.setString(15, null);
/*     */         else {
/* 195 */           pstmt.setString(15, get(i).getID());
/*     */         }
/* 197 */         pstmt.addBatch();
/*     */       }
/* 199 */       pstmt.executeBatch();
/* 200 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 203 */       ex.printStackTrace();
/* 204 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 205 */       CError tError = new CError();
/* 206 */       tError.moduleName = "LNPRoleInfoDBSet";
/* 207 */       tError.functionName = "update()";
/* 208 */       tError.errorMessage = ex.toString();
/* 209 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 212 */         pstmt.close(); } catch (Exception e) {
/* 213 */         e.printStackTrace();
/*     */       }
/* 215 */       if (!this.mflag) {
/*     */         try {
/* 217 */           this.con.close(); } catch (Exception e) {
/* 218 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 221 */       return false;
/*     */     }
/*     */ 
/* 224 */     if (!this.mflag) {
/*     */       try {
/* 226 */         this.con.close(); } catch (Exception e) {
/* 227 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 236 */     PreparedStatement pstmt = null;
/*     */ 
/* 238 */     if (!this.mflag) {
/* 239 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 244 */       int tCount = size();
/* 245 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRoleInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 246 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 248 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 249 */           pstmt.setString(1, null);
/*     */         else {
/* 251 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 253 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 254 */           pstmt.setString(2, null);
/*     */         else {
/* 256 */           pstmt.setString(2, get(i).getRoleCode());
/*     */         }
/* 258 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 259 */           pstmt.setString(3, null);
/*     */         else {
/* 261 */           pstmt.setString(3, get(i).getName());
/*     */         }
/* 263 */         if ((get(i).getDescribe() == null) || (get(i).getDescribe().equals("null")))
/* 264 */           pstmt.setString(4, null);
/*     */         else {
/* 266 */           pstmt.setString(4, get(i).getDescribe());
/*     */         }
/* 268 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 269 */           pstmt.setString(5, null);
/*     */         else {
/* 271 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 273 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 274 */           pstmt.setDate(6, null);
/*     */         else {
/* 276 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 278 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 279 */           pstmt.setString(7, null);
/*     */         else {
/* 281 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 283 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 284 */           pstmt.setDate(8, null);
/*     */         else {
/* 286 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 288 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 289 */           pstmt.setString(9, null);
/*     */         else {
/* 291 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 293 */         pstmt.setInt(10, get(i).getInt1());
/* 294 */         pstmt.setInt(11, get(i).getInt2());
/* 295 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 296 */           pstmt.setString(12, null);
/*     */         else {
/* 298 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 300 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 301 */           pstmt.setString(13, null);
/*     */         else {
/* 303 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/* 305 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 306 */           pstmt.setString(14, null);
/*     */         else {
/* 308 */           pstmt.setString(14, get(i).getVarc3());
/*     */         }
/* 310 */         pstmt.addBatch();
/*     */       }
/* 312 */       pstmt.executeBatch();
/* 313 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 316 */       ex.printStackTrace();
/* 317 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 318 */       CError tError = new CError();
/* 319 */       tError.moduleName = "LNPRoleInfoDBSet";
/* 320 */       tError.functionName = "insert()";
/* 321 */       tError.errorMessage = ex.toString();
/* 322 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 325 */         pstmt.close(); } catch (Exception e) {
/* 326 */         e.printStackTrace();
/*     */       }
/* 328 */       if (!this.mflag) {
/*     */         try {
/* 330 */           this.con.close(); } catch (Exception e) {
/* 331 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 334 */       return false;
/*     */     }
/*     */ 
/* 337 */     if (!this.mflag) {
/*     */       try {
/* 339 */         this.con.close(); } catch (Exception e) {
/* 340 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 343 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRoleInfoDBSet
 * JD-Core Version:    0.6.0
 */