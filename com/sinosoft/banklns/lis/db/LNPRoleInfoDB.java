/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRoleInfoSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRoleInfoSet;
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
/*      */ public class LNPRoleInfoDB extends LNPRoleInfoSchema
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
/*      */   public LNPRoleInfoDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRoleInfo");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRoleInfo");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRoleInfoSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRoleInfoDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRoleInfoSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRoleInfoDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRoleInfo WHERE  ID = ?");
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
/*  108 */       tError.moduleName = "LNPRoleInfoDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPRoleInfo SET  ID = ? , RoleCode = ? , Name = ? , Describe = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/*  146 */       if ((getID() == null) || (getID().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getID());
/*      */       }
/*  151 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  156 */       if ((getName() == null) || (getName().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getName());
/*      */       }
/*  161 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getDescribe());
/*      */       }
/*  166 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getOperator());
/*      */       }
/*  171 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  172 */         pstmt.setNull(6, 91);
/*      */       else {
/*  174 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  176 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  181 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  182 */         pstmt.setNull(8, 91);
/*      */       else {
/*  184 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  186 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  191 */       pstmt.setInt(10, getInt1());
/*  192 */       pstmt.setInt(11, getInt2());
/*  193 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  194 */         pstmt.setNull(12, 12);
/*      */       else {
/*  196 */         pstmt.setString(12, getVarc1());
/*      */       }
/*  198 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  199 */         pstmt.setNull(13, 12);
/*      */       else {
/*  201 */         pstmt.setString(13, getVarc2());
/*      */       }
/*  203 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  204 */         pstmt.setNull(14, 12);
/*      */       else {
/*  206 */         pstmt.setString(14, getVarc3());
/*      */       }
/*      */ 
/*  209 */       if ((getID() == null) || (getID().equals("null")))
/*  210 */         pstmt.setNull(15, 12);
/*      */       else {
/*  212 */         pstmt.setString(15, getID());
/*      */       }
/*  214 */       pstmt.executeUpdate();
/*  215 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  218 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  219 */       CError tError = new CError();
/*  220 */       tError.moduleName = "LNPRoleInfoDB";
/*  221 */       tError.functionName = "update()";
/*  222 */       tError.errorMessage = ex.toString();
/*  223 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  226 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  229 */       if (!this.mflag)
/*      */         try {
/*  231 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  235 */       return false;
/*      */     }
/*      */ 
/*  238 */     if (!this.mflag)
/*      */       try {
/*  240 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  244 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  249 */     PreparedStatement pstmt = null;
/*      */ 
/*  251 */     if (!this.mflag) {
/*  252 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  257 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRoleInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  258 */       if ((getID() == null) || (getID().equals("null")))
/*  259 */         pstmt.setNull(1, 12);
/*      */       else {
/*  261 */         pstmt.setString(1, getID());
/*      */       }
/*  263 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  264 */         pstmt.setNull(2, 12);
/*      */       else {
/*  266 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  268 */       if ((getName() == null) || (getName().equals("null")))
/*  269 */         pstmt.setNull(3, 12);
/*      */       else {
/*  271 */         pstmt.setString(3, getName());
/*      */       }
/*  273 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  274 */         pstmt.setNull(4, 12);
/*      */       else {
/*  276 */         pstmt.setString(4, getDescribe());
/*      */       }
/*  278 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  279 */         pstmt.setNull(5, 12);
/*      */       else {
/*  281 */         pstmt.setString(5, getOperator());
/*      */       }
/*  283 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  284 */         pstmt.setNull(6, 91);
/*      */       else {
/*  286 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  288 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  289 */         pstmt.setNull(7, 12);
/*      */       else {
/*  291 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  293 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  294 */         pstmt.setNull(8, 91);
/*      */       else {
/*  296 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  298 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  299 */         pstmt.setNull(9, 12);
/*      */       else {
/*  301 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  303 */       pstmt.setInt(10, getInt1());
/*  304 */       pstmt.setInt(11, getInt2());
/*  305 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  306 */         pstmt.setNull(12, 12);
/*      */       else {
/*  308 */         pstmt.setString(12, getVarc1());
/*      */       }
/*  310 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  311 */         pstmt.setNull(13, 12);
/*      */       else {
/*  313 */         pstmt.setString(13, getVarc2());
/*      */       }
/*  315 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  316 */         pstmt.setNull(14, 12);
/*      */       else {
/*  318 */         pstmt.setString(14, getVarc3());
/*      */       }
/*      */ 
/*  321 */       pstmt.executeUpdate();
/*  322 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  325 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  326 */       CError tError = new CError();
/*  327 */       tError.moduleName = "LNPRoleInfoDB";
/*  328 */       tError.functionName = "insert()";
/*  329 */       tError.errorMessage = ex.toString();
/*  330 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  333 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  336 */       if (!this.mflag)
/*      */         try {
/*  338 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  342 */       return false;
/*      */     }
/*      */ 
/*  345 */     if (!this.mflag)
/*      */       try {
/*  347 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  351 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  356 */     PreparedStatement pstmt = null;
/*  357 */     ResultSet rs = null;
/*      */ 
/*  359 */     if (!this.mflag) {
/*  360 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  365 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRoleInfo WHERE  ID = ?", 
/*  366 */         1003, 1007);
/*  367 */       if ((getID() == null) || (getID().equals("null")))
/*  368 */         pstmt.setNull(1, 12);
/*      */       else {
/*  370 */         pstmt.setString(1, getID());
/*      */       }
/*  372 */       rs = pstmt.executeQuery();
/*  373 */       int i = 0;
/*  374 */       if (rs.next())
/*      */       {
/*  376 */         i++;
/*  377 */         if (!setSchema(rs, i))
/*      */         {
/*  380 */           CError tError = new CError();
/*  381 */           tError.moduleName = "LNPRoleInfoDB";
/*  382 */           tError.functionName = "getInfo";
/*  383 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  384 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  386 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  389 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  393 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  397 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  401 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  404 */       if (i == 0)
/*      */       {
/*  406 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  410 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  414 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  420 */       CError tError = new CError();
/*  421 */       tError.moduleName = "LNPRoleInfoDB";
/*  422 */       tError.functionName = "getInfo";
/*  423 */       tError.errorMessage = e.toString();
/*  424 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  426 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  429 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  433 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  437 */       return false;
/*      */     }
/*      */ 
/*  440 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  444 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  449 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoSet query()
/*      */   {
/*  454 */     Statement stmt = null;
/*  455 */     ResultSet rs = null;
/*  456 */     LNPRoleInfoSet aLNPRoleInfoSet = new LNPRoleInfoSet();
/*      */ 
/*  458 */     if (!this.mflag) {
/*  459 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  464 */       stmt = this.con.createStatement(1003, 1007);
/*  465 */       SQLString sqlObj = new SQLString("LNPRoleInfo");
/*  466 */       LNPRoleInfoSchema aSchema = getSchema();
/*  467 */       sqlObj.setSQL(5, aSchema);
/*  468 */       String sql = sqlObj.getSQL();
/*      */ 
/*  470 */       rs = stmt.executeQuery(sql);
/*  471 */       int i = 0;
/*  472 */       while (rs.next())
/*      */       {
/*  474 */         i++;
/*  475 */         LNPRoleInfoSchema s1 = new LNPRoleInfoSchema();
/*  476 */         s1.setSchema(rs, i);
/*  477 */         aLNPRoleInfoSet.add(s1);
/*      */       }try {
/*  479 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  485 */       CError tError = new CError();
/*  486 */       tError.moduleName = "LNPRoleInfoDB";
/*  487 */       tError.functionName = "query";
/*  488 */       tError.errorMessage = e.toString();
/*  489 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  491 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  494 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  498 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  504 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  508 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  513 */     return aLNPRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoSet executeQuery(String sql)
/*      */   {
/*  518 */     Statement stmt = null;
/*  519 */     ResultSet rs = null;
/*  520 */     LNPRoleInfoSet aLNPRoleInfoSet = new LNPRoleInfoSet();
/*      */ 
/*  522 */     if (!this.mflag) {
/*  523 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  528 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  530 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  531 */       int i = 0;
/*  532 */       while (rs.next())
/*      */       {
/*  534 */         i++;
/*  535 */         LNPRoleInfoSchema s1 = new LNPRoleInfoSchema();
/*  536 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  539 */           CError tError = new CError();
/*  540 */           tError.moduleName = "LNPRoleInfoDB";
/*  541 */           tError.functionName = "executeQuery";
/*  542 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  543 */           this.mErrors.addOneError(tError);
/*      */         }
/*  545 */         aLNPRoleInfoSet.add(s1);
/*      */       }try {
/*  547 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  553 */       CError tError = new CError();
/*  554 */       tError.moduleName = "LNPRoleInfoDB";
/*  555 */       tError.functionName = "executeQuery";
/*  556 */       tError.errorMessage = e.toString();
/*  557 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  559 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  562 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  566 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  572 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  576 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  581 */     return aLNPRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoSet query(int nStart, int nCount)
/*      */   {
/*  586 */     Statement stmt = null;
/*  587 */     ResultSet rs = null;
/*  588 */     LNPRoleInfoSet aLNPRoleInfoSet = new LNPRoleInfoSet();
/*      */ 
/*  590 */     if (!this.mflag) {
/*  591 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  596 */       stmt = this.con.createStatement(1003, 1007);
/*  597 */       SQLString sqlObj = new SQLString("LNPRoleInfo");
/*  598 */       LNPRoleInfoSchema aSchema = getSchema();
/*  599 */       sqlObj.setSQL(5, aSchema);
/*  600 */       String sql = sqlObj.getSQL();
/*      */ 
/*  602 */       rs = stmt.executeQuery(sql);
/*  603 */       int i = 0;
/*  604 */       while (rs.next())
/*      */       {
/*  606 */         i++;
/*      */ 
/*  608 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  612 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  616 */         LNPRoleInfoSchema s1 = new LNPRoleInfoSchema();
/*  617 */         s1.setSchema(rs, i);
/*  618 */         aLNPRoleInfoSet.add(s1);
/*      */       }try {
/*  620 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  626 */       CError tError = new CError();
/*  627 */       tError.moduleName = "LNPRoleInfoDB";
/*  628 */       tError.functionName = "query";
/*  629 */       tError.errorMessage = e.toString();
/*  630 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  632 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  635 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  639 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  645 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  649 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  654 */     return aLNPRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  659 */     Statement stmt = null;
/*  660 */     ResultSet rs = null;
/*  661 */     LNPRoleInfoSet aLNPRoleInfoSet = new LNPRoleInfoSet();
/*      */ 
/*  663 */     if (!this.mflag) {
/*  664 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  669 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  671 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  672 */       int i = 0;
/*  673 */       while (rs.next())
/*      */       {
/*  675 */         i++;
/*      */ 
/*  677 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  681 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  685 */         LNPRoleInfoSchema s1 = new LNPRoleInfoSchema();
/*  686 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  689 */           CError tError = new CError();
/*  690 */           tError.moduleName = "LNPRoleInfoDB";
/*  691 */           tError.functionName = "executeQuery";
/*  692 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  693 */           this.mErrors.addOneError(tError);
/*      */         }
/*  695 */         aLNPRoleInfoSet.add(s1);
/*      */       }try {
/*  697 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  703 */       CError tError = new CError();
/*  704 */       tError.moduleName = "LNPRoleInfoDB";
/*  705 */       tError.functionName = "executeQuery";
/*  706 */       tError.errorMessage = e.toString();
/*  707 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  709 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  712 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  716 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  722 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  726 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  731 */     return aLNPRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  736 */     Statement stmt = null;
/*      */ 
/*  738 */     if (!this.mflag) {
/*  739 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  744 */       stmt = this.con.createStatement(1003, 1007);
/*  745 */       SQLString sqlObj = new SQLString("LNPRoleInfo");
/*  746 */       LNPRoleInfoSchema aSchema = getSchema();
/*  747 */       sqlObj.setSQL(2, aSchema);
/*  748 */       String sql = "update LNPRoleInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  750 */       int operCount = stmt.executeUpdate(sql);
/*  751 */       if (operCount == 0)
/*      */       {
/*  754 */         CError tError = new CError();
/*  755 */         tError.moduleName = "LNPRoleInfoDB";
/*  756 */         tError.functionName = "update";
/*  757 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  758 */         this.mErrors.addOneError(tError);
/*      */ 
/*  760 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  764 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  768 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  774 */       CError tError = new CError();
/*  775 */       tError.moduleName = "LNPRoleInfoDB";
/*  776 */       tError.functionName = "update";
/*  777 */       tError.errorMessage = e.toString();
/*  778 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  780 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  782 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  786 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  790 */       return false;
/*      */     }
/*      */ 
/*  793 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  797 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  802 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  808 */     if (this.mResultSet != null)
/*      */     {
/*  811 */       CError tError = new CError();
/*  812 */       tError.moduleName = "LNPRoleInfoDB";
/*  813 */       tError.functionName = "prepareData";
/*  814 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  815 */       this.mErrors.addOneError(tError);
/*  816 */       return false;
/*      */     }
/*      */ 
/*  819 */     if (!this.mflag)
/*      */     {
/*  821 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  825 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  826 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  831 */       CError tError = new CError();
/*  832 */       tError.moduleName = "LNPRoleInfoDB";
/*  833 */       tError.functionName = "prepareData";
/*  834 */       tError.errorMessage = e.toString();
/*  835 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  838 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  844 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  848 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  852 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  857 */       return false;
/*      */     }
/*      */ 
/*  860 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  864 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  869 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  875 */     boolean flag = true;
/*  876 */     if (this.mResultSet == null)
/*      */     {
/*  878 */       CError tError = new CError();
/*  879 */       tError.moduleName = "LNPRoleInfoDB";
/*  880 */       tError.functionName = "hasMoreData";
/*  881 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  882 */       this.mErrors.addOneError(tError);
/*  883 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  887 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  891 */       CError tError = new CError();
/*  892 */       tError.moduleName = "LNPRoleInfoDB";
/*  893 */       tError.functionName = "hasMoreData";
/*  894 */       tError.errorMessage = ex.toString();
/*  895 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  898 */         this.mResultSet.close();
/*  899 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  905 */         this.mStatement.close();
/*  906 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  910 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  914 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  919 */       return false;
/*      */     }
/*  921 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRoleInfoSet getData()
/*      */   {
/*  926 */     int tCount = 0;
/*  927 */     LNPRoleInfoSet tLNPRoleInfoSet = new LNPRoleInfoSet();
/*  928 */     LNPRoleInfoSchema tLNPRoleInfoSchema = null;
/*  929 */     if (this.mResultSet == null)
/*      */     {
/*  931 */       CError tError = new CError();
/*  932 */       tError.moduleName = "LNPRoleInfoDB";
/*  933 */       tError.functionName = "getData";
/*  934 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  935 */       this.mErrors.addOneError(tError);
/*  936 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  940 */       tCount = 1;
/*  941 */       tLNPRoleInfoSchema = new LNPRoleInfoSchema();
/*  942 */       tLNPRoleInfoSchema.setSchema(this.mResultSet, 1);
/*  943 */       tLNPRoleInfoSet.add(tLNPRoleInfoSchema);
/*      */ 
/*  945 */       while (tCount++ < 5000)
/*      */       {
/*  947 */         if (!this.mResultSet.next())
/*      */           continue;
/*  949 */         tLNPRoleInfoSchema = new LNPRoleInfoSchema();
/*  950 */         tLNPRoleInfoSchema.setSchema(this.mResultSet, 1);
/*  951 */         tLNPRoleInfoSet.add(tLNPRoleInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  957 */       CError tError = new CError();
/*  958 */       tError.moduleName = "LNPRoleInfoDB";
/*  959 */       tError.functionName = "getData";
/*  960 */       tError.errorMessage = ex.toString();
/*  961 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  964 */         this.mResultSet.close();
/*  965 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  971 */         this.mStatement.close();
/*  972 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  976 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  980 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  985 */       return null;
/*      */     }
/*  987 */     return tLNPRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  992 */     boolean flag = true;
/*      */     try
/*      */     {
/*  995 */       if (this.mResultSet == null)
/*      */       {
/*  997 */         CError tError = new CError();
/*  998 */         tError.moduleName = "LNPRoleInfoDB";
/*  999 */         tError.functionName = "closeData";
/* 1000 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1001 */         this.mErrors.addOneError(tError);
/* 1002 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1006 */         this.mResultSet.close();
/* 1007 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1012 */       CError tError = new CError();
/* 1013 */       tError.moduleName = "LNPRoleInfoDB";
/* 1014 */       tError.functionName = "closeData";
/* 1015 */       tError.errorMessage = ex2.toString();
/* 1016 */       this.mErrors.addOneError(tError);
/* 1017 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1021 */       if (this.mStatement == null)
/*      */       {
/* 1023 */         CError tError = new CError();
/* 1024 */         tError.moduleName = "LNPRoleInfoDB";
/* 1025 */         tError.functionName = "closeData";
/* 1026 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1027 */         this.mErrors.addOneError(tError);
/* 1028 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1032 */         this.mStatement.close();
/* 1033 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1038 */       CError tError = new CError();
/* 1039 */       tError.moduleName = "LNPRoleInfoDB";
/* 1040 */       tError.functionName = "closeData";
/* 1041 */       tError.errorMessage = ex3.toString();
/* 1042 */       this.mErrors.addOneError(tError);
/* 1043 */       flag = false;
/*      */     }
/* 1045 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRoleInfoDB
 * JD-Core Version:    0.6.0
 */