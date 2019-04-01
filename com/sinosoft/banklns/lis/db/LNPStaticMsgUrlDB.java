/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPStaticMsgUrlSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPStaticMsgUrlSet;
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
/*      */ public class LNPStaticMsgUrlDB extends LNPStaticMsgUrlSchema
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
/*      */   public LNPStaticMsgUrlDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPStaticMsgUrl");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPStaticMsgUrl");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPStaticMsgUrlSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPStaticMsgUrlDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPStaticMsgUrlSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPStaticMsgUrlDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPStaticMsgUrl WHERE  StaMsgID = ?");
/*   97 */       pstmt.setInt(1, getStaMsgID());
/*   98 */       pstmt.executeUpdate();
/*   99 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  102 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  103 */       CError tError = new CError();
/*  104 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  105 */       tError.functionName = "delete()";
/*  106 */       tError.errorMessage = ex.toString();
/*  107 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  110 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  113 */       if (!this.mflag)
/*      */         try {
/*  115 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  119 */       return false;
/*      */     }
/*      */ 
/*  122 */     if (!this.mflag)
/*      */       try {
/*  124 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  128 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  133 */     PreparedStatement pstmt = null;
/*      */ 
/*  135 */     if (!this.mflag) {
/*  136 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  141 */       pstmt = this.con.prepareStatement("UPDATE LNPStaticMsgUrl SET  StaMsgID = ? , AssuranceCode = ? , MsgUrl = ? , flag = ? , Remarks = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  StaMsgID = ?");
/*  142 */       pstmt.setInt(1, getStaMsgID());
/*  143 */       if ((getAssuranceCode() == null) || (getAssuranceCode().equals("null")))
/*  144 */         pstmt.setNull(2, 12);
/*      */       else {
/*  146 */         pstmt.setString(2, getAssuranceCode());
/*      */       }
/*  148 */       if ((getMsgUrl() == null) || (getMsgUrl().equals("null")))
/*  149 */         pstmt.setNull(3, 12);
/*      */       else {
/*  151 */         pstmt.setString(3, getMsgUrl());
/*      */       }
/*  153 */       if ((getFlag() == null) || (getFlag().equals("null")))
/*  154 */         pstmt.setNull(4, 12);
/*      */       else {
/*  156 */         pstmt.setString(4, getFlag());
/*      */       }
/*  158 */       if ((getRemarks() == null) || (getRemarks().equals("null")))
/*  159 */         pstmt.setNull(5, 12);
/*      */       else {
/*  161 */         pstmt.setString(5, getRemarks());
/*      */       }
/*  163 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  164 */         pstmt.setNull(6, 12);
/*      */       else {
/*  166 */         pstmt.setString(6, getOperator());
/*      */       }
/*  168 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  169 */         pstmt.setNull(7, 91);
/*      */       else {
/*  171 */         pstmt.setDate(7, Date.valueOf(getMakeDate()));
/*      */       }
/*  173 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  174 */         pstmt.setNull(8, 91);
/*      */       else {
/*  176 */         pstmt.setDate(8, Date.valueOf(getMakeTime()));
/*      */       }
/*  178 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  179 */         pstmt.setNull(9, 91);
/*      */       else {
/*  181 */         pstmt.setDate(9, Date.valueOf(getModifyDate()));
/*      */       }
/*  183 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  184 */         pstmt.setNull(10, 91);
/*      */       else {
/*  186 */         pstmt.setDate(10, Date.valueOf(getModifyTime()));
/*      */       }
/*      */ 
/*  189 */       pstmt.setInt(11, getStaMsgID());
/*  190 */       pstmt.executeUpdate();
/*  191 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  194 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  195 */       CError tError = new CError();
/*  196 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  197 */       tError.functionName = "update()";
/*  198 */       tError.errorMessage = ex.toString();
/*  199 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  202 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  205 */       if (!this.mflag)
/*      */         try {
/*  207 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  211 */       return false;
/*      */     }
/*      */ 
/*  214 */     if (!this.mflag)
/*      */       try {
/*  216 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  220 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  225 */     PreparedStatement pstmt = null;
/*      */ 
/*  227 */     if (!this.mflag) {
/*  228 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  233 */       pstmt = this.con.prepareStatement("INSERT INTO LNPStaticMsgUrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  234 */       pstmt.setInt(1, getStaMsgID());
/*  235 */       if ((getAssuranceCode() == null) || (getAssuranceCode().equals("null")))
/*  236 */         pstmt.setNull(2, 12);
/*      */       else {
/*  238 */         pstmt.setString(2, getAssuranceCode());
/*      */       }
/*  240 */       if ((getMsgUrl() == null) || (getMsgUrl().equals("null")))
/*  241 */         pstmt.setNull(3, 12);
/*      */       else {
/*  243 */         pstmt.setString(3, getMsgUrl());
/*      */       }
/*  245 */       if ((getFlag() == null) || (getFlag().equals("null")))
/*  246 */         pstmt.setNull(4, 12);
/*      */       else {
/*  248 */         pstmt.setString(4, getFlag());
/*      */       }
/*  250 */       if ((getRemarks() == null) || (getRemarks().equals("null")))
/*  251 */         pstmt.setNull(5, 12);
/*      */       else {
/*  253 */         pstmt.setString(5, getRemarks());
/*      */       }
/*  255 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  256 */         pstmt.setNull(6, 12);
/*      */       else {
/*  258 */         pstmt.setString(6, getOperator());
/*      */       }
/*  260 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  261 */         pstmt.setNull(7, 91);
/*      */       else {
/*  263 */         pstmt.setDate(7, Date.valueOf(getMakeDate()));
/*      */       }
/*  265 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  266 */         pstmt.setNull(8, 91);
/*      */       else {
/*  268 */         pstmt.setDate(8, Date.valueOf(getMakeTime()));
/*      */       }
/*  270 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  271 */         pstmt.setNull(9, 91);
/*      */       else {
/*  273 */         pstmt.setDate(9, Date.valueOf(getModifyDate()));
/*      */       }
/*  275 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  276 */         pstmt.setNull(10, 91);
/*      */       else {
/*  278 */         pstmt.setDate(10, Date.valueOf(getModifyTime()));
/*      */       }
/*      */ 
/*  281 */       pstmt.executeUpdate();
/*  282 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  285 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  286 */       CError tError = new CError();
/*  287 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  288 */       tError.functionName = "insert()";
/*  289 */       tError.errorMessage = ex.toString();
/*  290 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  293 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  296 */       if (!this.mflag)
/*      */         try {
/*  298 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  302 */       return false;
/*      */     }
/*      */ 
/*  305 */     if (!this.mflag)
/*      */       try {
/*  307 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  311 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  316 */     PreparedStatement pstmt = null;
/*  317 */     ResultSet rs = null;
/*      */ 
/*  319 */     if (!this.mflag) {
/*  320 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  325 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPStaticMsgUrl WHERE  StaMsgID = ?", 
/*  326 */         1003, 1007);
/*  327 */       pstmt.setInt(1, getStaMsgID());
/*  328 */       rs = pstmt.executeQuery();
/*  329 */       int i = 0;
/*  330 */       if (rs.next())
/*      */       {
/*  332 */         i++;
/*  333 */         if (!setSchema(rs, i))
/*      */         {
/*  336 */           CError tError = new CError();
/*  337 */           tError.moduleName = "LNPStaticMsgUrlDB";
/*  338 */           tError.functionName = "getInfo";
/*  339 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  340 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  342 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  345 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  349 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  353 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  357 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  360 */       if (i == 0)
/*      */       {
/*  362 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  366 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  370 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  376 */       CError tError = new CError();
/*  377 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  378 */       tError.functionName = "getInfo";
/*  379 */       tError.errorMessage = e.toString();
/*  380 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  382 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  385 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  389 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  393 */       return false;
/*      */     }
/*      */ 
/*  396 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  400 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  405 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlSet query()
/*      */   {
/*  410 */     Statement stmt = null;
/*  411 */     ResultSet rs = null;
/*  412 */     LNPStaticMsgUrlSet aLNPStaticMsgUrlSet = new LNPStaticMsgUrlSet();
/*      */ 
/*  414 */     if (!this.mflag) {
/*  415 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  420 */       stmt = this.con.createStatement(1003, 1007);
/*  421 */       SQLString sqlObj = new SQLString("LNPStaticMsgUrl");
/*  422 */       LNPStaticMsgUrlSchema aSchema = getSchema();
/*  423 */       sqlObj.setSQL(5, aSchema);
/*  424 */       String sql = sqlObj.getSQL();
/*      */ 
/*  426 */       rs = stmt.executeQuery(sql);
/*  427 */       int i = 0;
/*  428 */       while (rs.next())
/*      */       {
/*  430 */         i++;
/*  431 */         LNPStaticMsgUrlSchema s1 = new LNPStaticMsgUrlSchema();
/*  432 */         s1.setSchema(rs, i);
/*  433 */         aLNPStaticMsgUrlSet.add(s1);
/*      */       }try {
/*  435 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  441 */       CError tError = new CError();
/*  442 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  443 */       tError.functionName = "query";
/*  444 */       tError.errorMessage = e.toString();
/*  445 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  447 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  450 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  454 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  460 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  464 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  469 */     return aLNPStaticMsgUrlSet;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlSet executeQuery(String sql)
/*      */   {
/*  474 */     Statement stmt = null;
/*  475 */     ResultSet rs = null;
/*  476 */     LNPStaticMsgUrlSet aLNPStaticMsgUrlSet = new LNPStaticMsgUrlSet();
/*      */ 
/*  478 */     if (!this.mflag) {
/*  479 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  484 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  486 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  487 */       int i = 0;
/*  488 */       while (rs.next())
/*      */       {
/*  490 */         i++;
/*  491 */         LNPStaticMsgUrlSchema s1 = new LNPStaticMsgUrlSchema();
/*  492 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  495 */           CError tError = new CError();
/*  496 */           tError.moduleName = "LNPStaticMsgUrlDB";
/*  497 */           tError.functionName = "executeQuery";
/*  498 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  499 */           this.mErrors.addOneError(tError);
/*      */         }
/*  501 */         aLNPStaticMsgUrlSet.add(s1);
/*      */       }try {
/*  503 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  509 */       CError tError = new CError();
/*  510 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  511 */       tError.functionName = "executeQuery";
/*  512 */       tError.errorMessage = e.toString();
/*  513 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  515 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  518 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  522 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  528 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  532 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  537 */     return aLNPStaticMsgUrlSet;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlSet query(int nStart, int nCount)
/*      */   {
/*  542 */     Statement stmt = null;
/*  543 */     ResultSet rs = null;
/*  544 */     LNPStaticMsgUrlSet aLNPStaticMsgUrlSet = new LNPStaticMsgUrlSet();
/*      */ 
/*  546 */     if (!this.mflag) {
/*  547 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  552 */       stmt = this.con.createStatement(1003, 1007);
/*  553 */       SQLString sqlObj = new SQLString("LNPStaticMsgUrl");
/*  554 */       LNPStaticMsgUrlSchema aSchema = getSchema();
/*  555 */       sqlObj.setSQL(5, aSchema);
/*  556 */       String sql = sqlObj.getSQL();
/*      */ 
/*  558 */       rs = stmt.executeQuery(sql);
/*  559 */       int i = 0;
/*  560 */       while (rs.next())
/*      */       {
/*  562 */         i++;
/*      */ 
/*  564 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  568 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  572 */         LNPStaticMsgUrlSchema s1 = new LNPStaticMsgUrlSchema();
/*  573 */         s1.setSchema(rs, i);
/*  574 */         aLNPStaticMsgUrlSet.add(s1);
/*      */       }try {
/*  576 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  582 */       CError tError = new CError();
/*  583 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  584 */       tError.functionName = "query";
/*  585 */       tError.errorMessage = e.toString();
/*  586 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  588 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  591 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  595 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  601 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  605 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  610 */     return aLNPStaticMsgUrlSet;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  615 */     Statement stmt = null;
/*  616 */     ResultSet rs = null;
/*  617 */     LNPStaticMsgUrlSet aLNPStaticMsgUrlSet = new LNPStaticMsgUrlSet();
/*      */ 
/*  619 */     if (!this.mflag) {
/*  620 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  625 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  627 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  628 */       int i = 0;
/*  629 */       while (rs.next())
/*      */       {
/*  631 */         i++;
/*      */ 
/*  633 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  637 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  641 */         LNPStaticMsgUrlSchema s1 = new LNPStaticMsgUrlSchema();
/*  642 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  645 */           CError tError = new CError();
/*  646 */           tError.moduleName = "LNPStaticMsgUrlDB";
/*  647 */           tError.functionName = "executeQuery";
/*  648 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  649 */           this.mErrors.addOneError(tError);
/*      */         }
/*  651 */         aLNPStaticMsgUrlSet.add(s1);
/*      */       }try {
/*  653 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  659 */       CError tError = new CError();
/*  660 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  661 */       tError.functionName = "executeQuery";
/*  662 */       tError.errorMessage = e.toString();
/*  663 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  665 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  668 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  672 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  678 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  682 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  687 */     return aLNPStaticMsgUrlSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  692 */     Statement stmt = null;
/*      */ 
/*  694 */     if (!this.mflag) {
/*  695 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  700 */       stmt = this.con.createStatement(1003, 1007);
/*  701 */       SQLString sqlObj = new SQLString("LNPStaticMsgUrl");
/*  702 */       LNPStaticMsgUrlSchema aSchema = getSchema();
/*  703 */       sqlObj.setSQL(2, aSchema);
/*  704 */       String sql = "update LNPStaticMsgUrl " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  706 */       int operCount = stmt.executeUpdate(sql);
/*  707 */       if (operCount == 0)
/*      */       {
/*  710 */         CError tError = new CError();
/*  711 */         tError.moduleName = "LNPStaticMsgUrlDB";
/*  712 */         tError.functionName = "update";
/*  713 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  714 */         this.mErrors.addOneError(tError);
/*      */ 
/*  716 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  720 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  724 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  730 */       CError tError = new CError();
/*  731 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  732 */       tError.functionName = "update";
/*  733 */       tError.errorMessage = e.toString();
/*  734 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  736 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  738 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  742 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  746 */       return false;
/*      */     }
/*      */ 
/*  749 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  753 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  758 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  764 */     if (this.mResultSet != null)
/*      */     {
/*  767 */       CError tError = new CError();
/*  768 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  769 */       tError.functionName = "prepareData";
/*  770 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  771 */       this.mErrors.addOneError(tError);
/*  772 */       return false;
/*      */     }
/*      */ 
/*  775 */     if (!this.mflag)
/*      */     {
/*  777 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  781 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  782 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  787 */       CError tError = new CError();
/*  788 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  789 */       tError.functionName = "prepareData";
/*  790 */       tError.errorMessage = e.toString();
/*  791 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  794 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  800 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  804 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  808 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  813 */       return false;
/*      */     }
/*      */ 
/*  816 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  820 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  825 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  831 */     boolean flag = true;
/*  832 */     if (this.mResultSet == null)
/*      */     {
/*  834 */       CError tError = new CError();
/*  835 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  836 */       tError.functionName = "hasMoreData";
/*  837 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  838 */       this.mErrors.addOneError(tError);
/*  839 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  843 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  847 */       CError tError = new CError();
/*  848 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  849 */       tError.functionName = "hasMoreData";
/*  850 */       tError.errorMessage = ex.toString();
/*  851 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  854 */         this.mResultSet.close();
/*  855 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  861 */         this.mStatement.close();
/*  862 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  866 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  870 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  875 */       return false;
/*      */     }
/*  877 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPStaticMsgUrlSet getData()
/*      */   {
/*  882 */     int tCount = 0;
/*  883 */     LNPStaticMsgUrlSet tLNPStaticMsgUrlSet = new LNPStaticMsgUrlSet();
/*  884 */     LNPStaticMsgUrlSchema tLNPStaticMsgUrlSchema = null;
/*  885 */     if (this.mResultSet == null)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  889 */       tError.functionName = "getData";
/*  890 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  891 */       this.mErrors.addOneError(tError);
/*  892 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  896 */       tCount = 1;
/*  897 */       tLNPStaticMsgUrlSchema = new LNPStaticMsgUrlSchema();
/*  898 */       tLNPStaticMsgUrlSchema.setSchema(this.mResultSet, 1);
/*  899 */       tLNPStaticMsgUrlSet.add(tLNPStaticMsgUrlSchema);
/*      */ 
/*  901 */       while (tCount++ < 5000)
/*      */       {
/*  903 */         if (!this.mResultSet.next())
/*      */           continue;
/*  905 */         tLNPStaticMsgUrlSchema = new LNPStaticMsgUrlSchema();
/*  906 */         tLNPStaticMsgUrlSchema.setSchema(this.mResultSet, 1);
/*  907 */         tLNPStaticMsgUrlSet.add(tLNPStaticMsgUrlSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  913 */       CError tError = new CError();
/*  914 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  915 */       tError.functionName = "getData";
/*  916 */       tError.errorMessage = ex.toString();
/*  917 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  920 */         this.mResultSet.close();
/*  921 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  927 */         this.mStatement.close();
/*  928 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  932 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  936 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  941 */       return null;
/*      */     }
/*  943 */     return tLNPStaticMsgUrlSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  948 */     boolean flag = true;
/*      */     try
/*      */     {
/*  951 */       if (this.mResultSet == null)
/*      */       {
/*  953 */         CError tError = new CError();
/*  954 */         tError.moduleName = "LNPStaticMsgUrlDB";
/*  955 */         tError.functionName = "closeData";
/*  956 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  957 */         this.mErrors.addOneError(tError);
/*  958 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  962 */         this.mResultSet.close();
/*  963 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  968 */       CError tError = new CError();
/*  969 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  970 */       tError.functionName = "closeData";
/*  971 */       tError.errorMessage = ex2.toString();
/*  972 */       this.mErrors.addOneError(tError);
/*  973 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  977 */       if (this.mStatement == null)
/*      */       {
/*  979 */         CError tError = new CError();
/*  980 */         tError.moduleName = "LNPStaticMsgUrlDB";
/*  981 */         tError.functionName = "closeData";
/*  982 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/*  983 */         this.mErrors.addOneError(tError);
/*  984 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  988 */         this.mStatement.close();
/*  989 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/*  994 */       CError tError = new CError();
/*  995 */       tError.moduleName = "LNPStaticMsgUrlDB";
/*  996 */       tError.functionName = "closeData";
/*  997 */       tError.errorMessage = ex3.toString();
/*  998 */       this.mErrors.addOneError(tError);
/*  999 */       flag = false;
/*      */     }
/* 1001 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPStaticMsgUrlDB
 * JD-Core Version:    0.6.0
 */