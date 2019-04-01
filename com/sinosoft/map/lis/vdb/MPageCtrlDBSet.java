/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MPageCtrlSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPageCtrlSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MPageCtrlDBSet extends MPageCtrlSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MPageCtrlDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MPageCtrl");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MPageCtrlDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MPageCtrl");
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
/*  49 */     tError.moduleName = "MPageCtrlDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MPageCtrl WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MPageCtrlDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MPageCtrl SET  ID = ? , RoleID = ? , MenuID = ? , ButtonType = ? , ButtonID = ? , ButtonName = ? , ButtonSwitch = ? , ControlFlag = ? , ButtonDescription = ? WHERE  ID = ?");
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
/* 143 */         if ((get(i).getButtonType() == null) || (get(i).getButtonType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getButtonType());
/*     */         }
/* 148 */         if ((get(i).getButtonID() == null) || (get(i).getButtonID().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getButtonID());
/*     */         }
/* 153 */         if ((get(i).getButtonName() == null) || (get(i).getButtonName().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getButtonName());
/*     */         }
/* 158 */         pstmt.setInt(7, get(i).getButtonSwitch());
/* 159 */         if ((get(i).getControlFlag() == null) || (get(i).getControlFlag().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getControlFlag());
/*     */         }
/* 164 */         if ((get(i).getButtonDescription() == null) || (get(i).getButtonDescription().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getButtonDescription());
/*     */         }
/*     */ 
/* 170 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 171 */           pstmt.setString(10, null);
/*     */         else {
/* 173 */           pstmt.setString(10, get(i).getID());
/*     */         }
/* 175 */         pstmt.addBatch();
/*     */       }
/* 177 */       pstmt.executeBatch();
/* 178 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 181 */       ex.printStackTrace();
/* 182 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 183 */       CError tError = new CError();
/* 184 */       tError.moduleName = "MPageCtrlDBSet";
/* 185 */       tError.functionName = "update()";
/* 186 */       tError.errorMessage = ex.toString();
/* 187 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 190 */         pstmt.close(); } catch (Exception e) {
/* 191 */         e.printStackTrace();
/*     */       }
/* 193 */       if (!this.mflag) {
/*     */         try {
/* 195 */           this.con.close(); } catch (Exception e) {
/* 196 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 199 */       return false;
/*     */     }
/*     */ 
/* 202 */     if (!this.mflag) {
/*     */       try {
/* 204 */         this.con.close(); } catch (Exception e) {
/* 205 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 214 */     PreparedStatement pstmt = null;
/*     */ 
/* 216 */     if (!this.mflag) {
/* 217 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 222 */       int tCount = size();
/* 223 */       pstmt = this.con.prepareStatement("INSERT INTO MPageCtrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 224 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 226 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 227 */           pstmt.setString(1, null);
/*     */         else {
/* 229 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 231 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 232 */           pstmt.setString(2, null);
/*     */         else {
/* 234 */           pstmt.setString(2, get(i).getRoleID());
/*     */         }
/* 236 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 237 */           pstmt.setString(3, null);
/*     */         else {
/* 239 */           pstmt.setString(3, get(i).getMenuID());
/*     */         }
/* 241 */         if ((get(i).getButtonType() == null) || (get(i).getButtonType().equals("null")))
/* 242 */           pstmt.setString(4, null);
/*     */         else {
/* 244 */           pstmt.setString(4, get(i).getButtonType());
/*     */         }
/* 246 */         if ((get(i).getButtonID() == null) || (get(i).getButtonID().equals("null")))
/* 247 */           pstmt.setString(5, null);
/*     */         else {
/* 249 */           pstmt.setString(5, get(i).getButtonID());
/*     */         }
/* 251 */         if ((get(i).getButtonName() == null) || (get(i).getButtonName().equals("null")))
/* 252 */           pstmt.setString(6, null);
/*     */         else {
/* 254 */           pstmt.setString(6, get(i).getButtonName());
/*     */         }
/* 256 */         pstmt.setInt(7, get(i).getButtonSwitch());
/* 257 */         if ((get(i).getControlFlag() == null) || (get(i).getControlFlag().equals("null")))
/* 258 */           pstmt.setString(8, null);
/*     */         else {
/* 260 */           pstmt.setString(8, get(i).getControlFlag());
/*     */         }
/* 262 */         if ((get(i).getButtonDescription() == null) || (get(i).getButtonDescription().equals("null")))
/* 263 */           pstmt.setString(9, null);
/*     */         else {
/* 265 */           pstmt.setString(9, get(i).getButtonDescription());
/*     */         }
/* 267 */         pstmt.addBatch();
/*     */       }
/* 269 */       pstmt.executeBatch();
/* 270 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 273 */       ex.printStackTrace();
/* 274 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 275 */       CError tError = new CError();
/* 276 */       tError.moduleName = "MPageCtrlDBSet";
/* 277 */       tError.functionName = "insert()";
/* 278 */       tError.errorMessage = ex.toString();
/* 279 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 282 */         pstmt.close(); } catch (Exception e) {
/* 283 */         e.printStackTrace();
/*     */       }
/* 285 */       if (!this.mflag) {
/*     */         try {
/* 287 */           this.con.close(); } catch (Exception e) {
/* 288 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 291 */       return false;
/*     */     }
/*     */ 
/* 294 */     if (!this.mflag) {
/*     */       try {
/* 296 */         this.con.close(); } catch (Exception e) {
/* 297 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 300 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MPageCtrlDBSet
 * JD-Core Version:    0.6.0
 */