/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPUserRoleMapSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPUserRoleMapSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPUserRoleMapDB extends LNPUserRoleMapSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*   24 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   27 */   private ResultSet mResultSet = null;
/*   28 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPUserRoleMapDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPUserRoleMap");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPUserRoleMap");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPUserRoleMapSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPUserRoleMapDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPUserRoleMapSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPUserRoleMapDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   78 */       this.mErrors.addOneError(tError);
/*      */ 
/*   80 */       return -1;
/*      */     }
/*      */ 
/*   83 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   88 */     PreparedStatement pstmt = null;
/*      */ 
/*   90 */     if (!this.mflag) {
/*   91 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUserRoleMap WHERE  ID = ?");
/*   97 */       if ((getID() == null) || (getID().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getID());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPUserRoleMapDB";
/*  109 */       tError.functionName = "delete()";
/*  110 */       tError.errorMessage = ex.toString();
/*  111 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  114 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  117 */       if (!this.mflag)
/*      */         try {
/*  119 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  123 */       return false;
/*      */     }
/*      */ 
/*  126 */     if (!this.mflag)
/*      */       try {
/*  128 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  132 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  137 */     PreparedStatement pstmt = null;
/*      */ 
/*  139 */     if (!this.mflag) {
/*  140 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPUserRoleMap SET  ID = ? , UserCode = ? , RoleCode = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/*  146 */       if ((getID() == null) || (getID().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getID());
/*      */       }
/*  151 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  156 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getRoleCode());
/*      */       }
/*  161 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getOperator());
/*      */       }
/*  166 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  167 */         pstmt.setNull(5, 91);
/*      */       else {
/*  169 */         pstmt.setDate(5, Date.valueOf(getMakeDate()));
/*      */       }
/*  171 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getMakeTime());
/*      */       }
/*  176 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  177 */         pstmt.setNull(7, 91);
/*      */       else {
/*  179 */         pstmt.setDate(7, Date.valueOf(getModifyDate()));
/*      */       }
/*  181 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getModifyTime());
/*      */       }
/*  186 */       pstmt.setInt(9, getInt1());
/*  187 */       pstmt.setInt(10, getInt2());
/*  188 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  189 */         pstmt.setNull(11, 12);
/*      */       else {
/*  191 */         pstmt.setString(11, getVarc1());
/*      */       }
/*  193 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  194 */         pstmt.setNull(12, 12);
/*      */       else {
/*  196 */         pstmt.setString(12, getVarc2());
/*      */       }
/*  198 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  199 */         pstmt.setNull(13, 12);
/*      */       else {
/*  201 */         pstmt.setString(13, getVarc3());
/*      */       }
/*      */ 
/*  204 */       if ((getID() == null) || (getID().equals("null")))
/*  205 */         pstmt.setNull(14, 12);
/*      */       else {
/*  207 */         pstmt.setString(14, getID());
/*      */       }
/*  209 */       pstmt.executeUpdate();
/*  210 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  213 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  214 */       CError tError = new CError();
/*  215 */       tError.moduleName = "LNPUserRoleMapDB";
/*  216 */       tError.functionName = "update()";
/*  217 */       tError.errorMessage = ex.toString();
/*  218 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  221 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  224 */       if (!this.mflag)
/*      */         try {
/*  226 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  230 */       return false;
/*      */     }
/*      */ 
/*  233 */     if (!this.mflag)
/*      */       try {
/*  235 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  239 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  244 */     PreparedStatement pstmt = null;
/*      */ 
/*  246 */     if (!this.mflag) {
/*  247 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  252 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUserRoleMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  253 */       if ((getID() == null) || (getID().equals("null")))
/*  254 */         pstmt.setNull(1, 12);
/*      */       else {
/*  256 */         pstmt.setString(1, getID());
/*      */       }
/*  258 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  259 */         pstmt.setNull(2, 12);
/*      */       else {
/*  261 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  263 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  264 */         pstmt.setNull(3, 12);
/*      */       else {
/*  266 */         pstmt.setString(3, getRoleCode());
/*      */       }
/*  268 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  269 */         pstmt.setNull(4, 12);
/*      */       else {
/*  271 */         pstmt.setString(4, getOperator());
/*      */       }
/*  273 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  274 */         pstmt.setNull(5, 91);
/*      */       else {
/*  276 */         pstmt.setDate(5, Date.valueOf(getMakeDate()));
/*      */       }
/*  278 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  279 */         pstmt.setNull(6, 12);
/*      */       else {
/*  281 */         pstmt.setString(6, getMakeTime());
/*      */       }
/*  283 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  284 */         pstmt.setNull(7, 91);
/*      */       else {
/*  286 */         pstmt.setDate(7, Date.valueOf(getModifyDate()));
/*      */       }
/*  288 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  289 */         pstmt.setNull(8, 12);
/*      */       else {
/*  291 */         pstmt.setString(8, getModifyTime());
/*      */       }
/*  293 */       pstmt.setInt(9, getInt1());
/*  294 */       pstmt.setInt(10, getInt2());
/*  295 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  296 */         pstmt.setNull(11, 12);
/*      */       else {
/*  298 */         pstmt.setString(11, getVarc1());
/*      */       }
/*  300 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  301 */         pstmt.setNull(12, 12);
/*      */       else {
/*  303 */         pstmt.setString(12, getVarc2());
/*      */       }
/*  305 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  306 */         pstmt.setNull(13, 12);
/*      */       else {
/*  308 */         pstmt.setString(13, getVarc3());
/*      */       }
/*      */ 
/*  311 */       pstmt.executeUpdate();
/*  312 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  315 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  316 */       CError tError = new CError();
/*  317 */       tError.moduleName = "LNPUserRoleMapDB";
/*  318 */       tError.functionName = "insert()";
/*  319 */       tError.errorMessage = ex.toString();
/*  320 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  323 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  326 */       if (!this.mflag)
/*      */         try {
/*  328 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  332 */       return false;
/*      */     }
/*      */ 
/*  335 */     if (!this.mflag)
/*      */       try {
/*  337 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  341 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  346 */     PreparedStatement pstmt = null;
/*  347 */     ResultSet rs = null;
/*      */ 
/*  349 */     if (!this.mflag) {
/*  350 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  355 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPUserRoleMap WHERE  ID = ?", 
/*  356 */         1003, 1007);
/*  357 */       if ((getID() == null) || (getID().equals("null")))
/*  358 */         pstmt.setNull(1, 12);
/*      */       else {
/*  360 */         pstmt.setString(1, getID());
/*      */       }
/*  362 */       rs = pstmt.executeQuery();
/*  363 */       int i = 0;
/*  364 */       if (rs.next())
/*      */       {
/*  366 */         i++;
/*  367 */         if (!setSchema(rs, i))
/*      */         {
/*  370 */           CError tError = new CError();
/*  371 */           tError.moduleName = "LNPUserRoleMapDB";
/*  372 */           tError.functionName = "getInfo";
/*  373 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  374 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  376 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  379 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  383 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  387 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  391 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  394 */       if (i == 0)
/*      */       {
/*  396 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  400 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  404 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  410 */       CError tError = new CError();
/*  411 */       tError.moduleName = "LNPUserRoleMapDB";
/*  412 */       tError.functionName = "getInfo";
/*  413 */       tError.errorMessage = e.toString();
/*  414 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  416 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  419 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  423 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  427 */       return false;
/*      */     }
/*      */ 
/*  430 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  434 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  439 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapSet query()
/*      */   {
/*  444 */     Statement stmt = null;
/*  445 */     ResultSet rs = null;
/*  446 */     LNPUserRoleMapSet aLNPUserRoleMapSet = new LNPUserRoleMapSet();
/*      */ 
/*  448 */     if (!this.mflag) {
/*  449 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  454 */       stmt = this.con.createStatement(1003, 1007);
/*  455 */       SQLString sqlObj = new SQLString("LNPUserRoleMap");
/*  456 */       LNPUserRoleMapSchema aSchema = getSchema();
/*  457 */       sqlObj.setSQL(5, aSchema);
/*  458 */       String sql = sqlObj.getSQL();
/*      */ 
/*  460 */       rs = stmt.executeQuery(sql);
/*  461 */       int i = 0;
/*  462 */       while (rs.next())
/*      */       {
/*  464 */         i++;
/*  465 */         LNPUserRoleMapSchema s1 = new LNPUserRoleMapSchema();
/*  466 */         s1.setSchema(rs, i);
/*  467 */         aLNPUserRoleMapSet.add(s1);
/*      */       }try {
/*  469 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  475 */       CError tError = new CError();
/*  476 */       tError.moduleName = "LNPUserRoleMapDB";
/*  477 */       tError.functionName = "query";
/*  478 */       tError.errorMessage = e.toString();
/*  479 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  481 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  484 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  488 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  494 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  498 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  503 */     return aLNPUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapSet executeQuery(String sql)
/*      */   {
/*  508 */     Statement stmt = null;
/*  509 */     ResultSet rs = null;
/*  510 */     LNPUserRoleMapSet aLNPUserRoleMapSet = new LNPUserRoleMapSet();
/*      */ 
/*  512 */     if (!this.mflag) {
/*  513 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  518 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  520 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  521 */       int i = 0;
/*  522 */       while (rs.next())
/*      */       {
/*  524 */         i++;
/*  525 */         LNPUserRoleMapSchema s1 = new LNPUserRoleMapSchema();
/*  526 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  529 */           CError tError = new CError();
/*  530 */           tError.moduleName = "LNPUserRoleMapDB";
/*  531 */           tError.functionName = "executeQuery";
/*  532 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  533 */           this.mErrors.addOneError(tError);
/*      */         }
/*  535 */         aLNPUserRoleMapSet.add(s1);
/*      */       }try {
/*  537 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  543 */       CError tError = new CError();
/*  544 */       tError.moduleName = "LNPUserRoleMapDB";
/*  545 */       tError.functionName = "executeQuery";
/*  546 */       tError.errorMessage = e.toString();
/*  547 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  549 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  552 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  556 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  562 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  566 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  571 */     return aLNPUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapSet query(int nStart, int nCount)
/*      */   {
/*  576 */     Statement stmt = null;
/*  577 */     ResultSet rs = null;
/*  578 */     LNPUserRoleMapSet aLNPUserRoleMapSet = new LNPUserRoleMapSet();
/*      */ 
/*  580 */     if (!this.mflag) {
/*  581 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  586 */       stmt = this.con.createStatement(1003, 1007);
/*  587 */       SQLString sqlObj = new SQLString("LNPUserRoleMap");
/*  588 */       LNPUserRoleMapSchema aSchema = getSchema();
/*  589 */       sqlObj.setSQL(5, aSchema);
/*  590 */       String sql = sqlObj.getSQL();
/*      */ 
/*  592 */       rs = stmt.executeQuery(sql);
/*  593 */       int i = 0;
/*  594 */       while (rs.next())
/*      */       {
/*  596 */         i++;
/*      */ 
/*  598 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  602 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  606 */         LNPUserRoleMapSchema s1 = new LNPUserRoleMapSchema();
/*  607 */         s1.setSchema(rs, i);
/*  608 */         aLNPUserRoleMapSet.add(s1);
/*      */       }try {
/*  610 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  616 */       CError tError = new CError();
/*  617 */       tError.moduleName = "LNPUserRoleMapDB";
/*  618 */       tError.functionName = "query";
/*  619 */       tError.errorMessage = e.toString();
/*  620 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  622 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  625 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  629 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  635 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  639 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  644 */     return aLNPUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  649 */     Statement stmt = null;
/*  650 */     ResultSet rs = null;
/*  651 */     LNPUserRoleMapSet aLNPUserRoleMapSet = new LNPUserRoleMapSet();
/*      */ 
/*  653 */     if (!this.mflag) {
/*  654 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  659 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  661 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  662 */       int i = 0;
/*  663 */       while (rs.next())
/*      */       {
/*  665 */         i++;
/*      */ 
/*  667 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  671 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  675 */         LNPUserRoleMapSchema s1 = new LNPUserRoleMapSchema();
/*  676 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  679 */           CError tError = new CError();
/*  680 */           tError.moduleName = "LNPUserRoleMapDB";
/*  681 */           tError.functionName = "executeQuery";
/*  682 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  683 */           this.mErrors.addOneError(tError);
/*      */         }
/*  685 */         aLNPUserRoleMapSet.add(s1);
/*      */       }try {
/*  687 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  693 */       CError tError = new CError();
/*  694 */       tError.moduleName = "LNPUserRoleMapDB";
/*  695 */       tError.functionName = "executeQuery";
/*  696 */       tError.errorMessage = e.toString();
/*  697 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  699 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  702 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  706 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  712 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  716 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  721 */     return aLNPUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  726 */     Statement stmt = null;
/*      */ 
/*  728 */     if (!this.mflag) {
/*  729 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  734 */       stmt = this.con.createStatement(1003, 1007);
/*  735 */       SQLString sqlObj = new SQLString("LNPUserRoleMap");
/*  736 */       LNPUserRoleMapSchema aSchema = getSchema();
/*  737 */       sqlObj.setSQL(2, aSchema);
/*  738 */       String sql = "update LNPUserRoleMap " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  740 */       int operCount = stmt.executeUpdate(sql);
/*  741 */       if (operCount == 0)
/*      */       {
/*  744 */         CError tError = new CError();
/*  745 */         tError.moduleName = "LNPUserRoleMapDB";
/*  746 */         tError.functionName = "update";
/*  747 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  748 */         this.mErrors.addOneError(tError);
/*      */ 
/*  750 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  754 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  758 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  764 */       CError tError = new CError();
/*  765 */       tError.moduleName = "LNPUserRoleMapDB";
/*  766 */       tError.functionName = "update";
/*  767 */       tError.errorMessage = e.toString();
/*  768 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  770 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  772 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  776 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  780 */       return false;
/*      */     }
/*      */ 
/*  783 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  787 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  792 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  798 */     if (this.mResultSet != null)
/*      */     {
/*  801 */       CError tError = new CError();
/*  802 */       tError.moduleName = "LNPUserRoleMapDB";
/*  803 */       tError.functionName = "prepareData";
/*  804 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  805 */       this.mErrors.addOneError(tError);
/*  806 */       return false;
/*      */     }
/*      */ 
/*  809 */     if (!this.mflag)
/*      */     {
/*  811 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  815 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  816 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  821 */       CError tError = new CError();
/*  822 */       tError.moduleName = "LNPUserRoleMapDB";
/*  823 */       tError.functionName = "prepareData";
/*  824 */       tError.errorMessage = e.toString();
/*  825 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  828 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  834 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  838 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  842 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  847 */       return false;
/*      */     }
/*      */ 
/*  850 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  854 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  859 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  865 */     boolean flag = true;
/*  866 */     if (this.mResultSet == null)
/*      */     {
/*  868 */       CError tError = new CError();
/*  869 */       tError.moduleName = "LNPUserRoleMapDB";
/*  870 */       tError.functionName = "hasMoreData";
/*  871 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  872 */       this.mErrors.addOneError(tError);
/*  873 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  877 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  881 */       CError tError = new CError();
/*  882 */       tError.moduleName = "LNPUserRoleMapDB";
/*  883 */       tError.functionName = "hasMoreData";
/*  884 */       tError.errorMessage = ex.toString();
/*  885 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  888 */         this.mResultSet.close();
/*  889 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  895 */         this.mStatement.close();
/*  896 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  900 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  904 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  909 */       return false;
/*      */     }
/*  911 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPUserRoleMapSet getData()
/*      */   {
/*  916 */     int tCount = 0;
/*  917 */     LNPUserRoleMapSet tLNPUserRoleMapSet = new LNPUserRoleMapSet();
/*  918 */     LNPUserRoleMapSchema tLNPUserRoleMapSchema = null;
/*  919 */     if (this.mResultSet == null)
/*      */     {
/*  921 */       CError tError = new CError();
/*  922 */       tError.moduleName = "LNPUserRoleMapDB";
/*  923 */       tError.functionName = "getData";
/*  924 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  925 */       this.mErrors.addOneError(tError);
/*  926 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  930 */       tCount = 1;
/*  931 */       tLNPUserRoleMapSchema = new LNPUserRoleMapSchema();
/*  932 */       tLNPUserRoleMapSchema.setSchema(this.mResultSet, 1);
/*  933 */       tLNPUserRoleMapSet.add(tLNPUserRoleMapSchema);
/*      */ 
/*  935 */       while (tCount++ < 5000)
/*      */       {
/*  937 */         if (!this.mResultSet.next())
/*      */           continue;
/*  939 */         tLNPUserRoleMapSchema = new LNPUserRoleMapSchema();
/*  940 */         tLNPUserRoleMapSchema.setSchema(this.mResultSet, 1);
/*  941 */         tLNPUserRoleMapSet.add(tLNPUserRoleMapSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  947 */       CError tError = new CError();
/*  948 */       tError.moduleName = "LNPUserRoleMapDB";
/*  949 */       tError.functionName = "getData";
/*  950 */       tError.errorMessage = ex.toString();
/*  951 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  954 */         this.mResultSet.close();
/*  955 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  961 */         this.mStatement.close();
/*  962 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  966 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  970 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  975 */       return null;
/*      */     }
/*  977 */     return tLNPUserRoleMapSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  982 */     boolean flag = true;
/*      */     try
/*      */     {
/*  985 */       if (this.mResultSet == null)
/*      */       {
/*  987 */         CError tError = new CError();
/*  988 */         tError.moduleName = "LNPUserRoleMapDB";
/*  989 */         tError.functionName = "closeData";
/*  990 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  991 */         this.mErrors.addOneError(tError);
/*  992 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  996 */         this.mResultSet.close();
/*  997 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1002 */       CError tError = new CError();
/* 1003 */       tError.moduleName = "LNPUserRoleMapDB";
/* 1004 */       tError.functionName = "closeData";
/* 1005 */       tError.errorMessage = ex2.toString();
/* 1006 */       this.mErrors.addOneError(tError);
/* 1007 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1011 */       if (this.mStatement == null)
/*      */       {
/* 1013 */         CError tError = new CError();
/* 1014 */         tError.moduleName = "LNPUserRoleMapDB";
/* 1015 */         tError.functionName = "closeData";
/* 1016 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1017 */         this.mErrors.addOneError(tError);
/* 1018 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1022 */         this.mStatement.close();
/* 1023 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1028 */       CError tError = new CError();
/* 1029 */       tError.moduleName = "LNPUserRoleMapDB";
/* 1030 */       tError.functionName = "closeData";
/* 1031 */       tError.errorMessage = ex3.toString();
/* 1032 */       this.mErrors.addOneError(tError);
/* 1033 */       flag = false;
/*      */     }
/* 1035 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPUserRoleMapDB
 * JD-Core Version:    0.6.0
 */