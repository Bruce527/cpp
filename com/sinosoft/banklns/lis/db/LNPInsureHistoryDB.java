/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
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
/*      */ public class LNPInsureHistoryDB extends LNPInsureHistorySchema
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
/*      */   public LNPInsureHistoryDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPInsureHistory");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistoryDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPInsureHistory");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPInsureHistorySchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPInsureHistoryDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPInsureHistorySchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPInsureHistoryDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       if ((getPolOrder() == null) || (getPolOrder().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getPolOrder());
/*      */       }
/*  107 */       pstmt.executeUpdate();
/*  108 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  112 */       CError tError = new CError();
/*  113 */       tError.moduleName = "LNPInsureHistoryDB";
/*  114 */       tError.functionName = "delete()";
/*  115 */       tError.errorMessage = ex.toString();
/*  116 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  119 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  122 */       if (!this.mflag)
/*      */         try {
/*  124 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  128 */       return false;
/*      */     }
/*      */ 
/*  131 */     if (!this.mflag)
/*      */       try {
/*  133 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  137 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  142 */     PreparedStatement pstmt = null;
/*      */ 
/*  144 */     if (!this.mflag) {
/*  145 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  150 */       pstmt = this.con.prepareStatement("UPDATE LNPInsureHistory SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , PolOrder = ? , ComName = ? , SumInsuredDeath = ? , SumInsuredDisease = ? , PolicyState = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ? AND PolOrder = ?");
/*  151 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  152 */         pstmt.setNull(1, 12);
/*      */       else {
/*  154 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  156 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  157 */         pstmt.setNull(2, 12);
/*      */       else {
/*  159 */         pstmt.setString(2, getContNo());
/*      */       }
/*  161 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  162 */         pstmt.setNull(3, 12);
/*      */       else {
/*  164 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  166 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  167 */         pstmt.setNull(4, 12);
/*      */       else {
/*  169 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  171 */       if ((getPolOrder() == null) || (getPolOrder().equals("null")))
/*  172 */         pstmt.setNull(5, 12);
/*      */       else {
/*  174 */         pstmt.setString(5, getPolOrder());
/*      */       }
/*  176 */       if ((getComName() == null) || (getComName().equals("null")))
/*  177 */         pstmt.setNull(6, 12);
/*      */       else {
/*  179 */         pstmt.setString(6, getComName());
/*      */       }
/*  181 */       pstmt.setDouble(7, getSumInsuredDeath());
/*  182 */       pstmt.setDouble(8, getSumInsuredDisease());
/*  183 */       if ((getPolicyState() == null) || (getPolicyState().equals("null")))
/*  184 */         pstmt.setNull(9, 12);
/*      */       else {
/*  186 */         pstmt.setString(9, getPolicyState());
/*      */       }
/*  188 */       if ((getState() == null) || (getState().equals("null")))
/*  189 */         pstmt.setNull(10, 12);
/*      */       else {
/*  191 */         pstmt.setString(10, getState());
/*      */       }
/*  193 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  194 */         pstmt.setNull(11, 12);
/*      */       else {
/*  196 */         pstmt.setString(11, getOperator());
/*      */       }
/*  198 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  199 */         pstmt.setNull(12, 91);
/*      */       else {
/*  201 */         pstmt.setDate(12, Date.valueOf(getMakeDate()));
/*      */       }
/*  203 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  204 */         pstmt.setNull(13, 12);
/*      */       else {
/*  206 */         pstmt.setString(13, getMakeTime());
/*      */       }
/*  208 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  209 */         pstmt.setNull(14, 91);
/*      */       else {
/*  211 */         pstmt.setDate(14, Date.valueOf(getModifyDate()));
/*      */       }
/*  213 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  214 */         pstmt.setNull(15, 12);
/*      */       else {
/*  216 */         pstmt.setString(15, getModifyTime());
/*      */       }
/*  218 */       if ((getP2() == null) || (getP2().equals("null")))
/*  219 */         pstmt.setNull(16, 12);
/*      */       else {
/*  221 */         pstmt.setString(16, getP2());
/*      */       }
/*  223 */       pstmt.setDouble(17, getP4());
/*  224 */       pstmt.setDouble(18, getP3());
/*  225 */       if ((getP1() == null) || (getP1().equals("null")))
/*  226 */         pstmt.setNull(19, 12);
/*      */       else {
/*  228 */         pstmt.setString(19, getP1());
/*      */       }
/*      */ 
/*  231 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  232 */         pstmt.setNull(20, 12);
/*      */       else {
/*  234 */         pstmt.setString(20, getContNo());
/*      */       }
/*  236 */       if ((getPolOrder() == null) || (getPolOrder().equals("null")))
/*  237 */         pstmt.setNull(21, 12);
/*      */       else {
/*  239 */         pstmt.setString(21, getPolOrder());
/*      */       }
/*  241 */       pstmt.executeUpdate();
/*  242 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  245 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  246 */       CError tError = new CError();
/*  247 */       tError.moduleName = "LNPInsureHistoryDB";
/*  248 */       tError.functionName = "update()";
/*  249 */       tError.errorMessage = ex.toString();
/*  250 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  253 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  256 */       if (!this.mflag)
/*      */         try {
/*  258 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  262 */       return false;
/*      */     }
/*      */ 
/*  265 */     if (!this.mflag)
/*      */       try {
/*  267 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  271 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  276 */     PreparedStatement pstmt = null;
/*      */ 
/*  278 */     if (!this.mflag) {
/*  279 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  284 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsureHistory VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  285 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  286 */         pstmt.setNull(1, 12);
/*      */       else {
/*  288 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  290 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  291 */         pstmt.setNull(2, 12);
/*      */       else {
/*  293 */         pstmt.setString(2, getContNo());
/*      */       }
/*  295 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  296 */         pstmt.setNull(3, 12);
/*      */       else {
/*  298 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  300 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  301 */         pstmt.setNull(4, 12);
/*      */       else {
/*  303 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  305 */       if ((getPolOrder() == null) || (getPolOrder().equals("null")))
/*  306 */         pstmt.setNull(5, 12);
/*      */       else {
/*  308 */         pstmt.setString(5, getPolOrder());
/*      */       }
/*  310 */       if ((getComName() == null) || (getComName().equals("null")))
/*  311 */         pstmt.setNull(6, 12);
/*      */       else {
/*  313 */         pstmt.setString(6, getComName());
/*      */       }
/*  315 */       pstmt.setDouble(7, getSumInsuredDeath());
/*  316 */       pstmt.setDouble(8, getSumInsuredDisease());
/*  317 */       if ((getPolicyState() == null) || (getPolicyState().equals("null")))
/*  318 */         pstmt.setNull(9, 12);
/*      */       else {
/*  320 */         pstmt.setString(9, getPolicyState());
/*      */       }
/*  322 */       if ((getState() == null) || (getState().equals("null")))
/*  323 */         pstmt.setNull(10, 12);
/*      */       else {
/*  325 */         pstmt.setString(10, getState());
/*      */       }
/*  327 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  328 */         pstmt.setNull(11, 12);
/*      */       else {
/*  330 */         pstmt.setString(11, getOperator());
/*      */       }
/*  332 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  333 */         pstmt.setNull(12, 91);
/*      */       else {
/*  335 */         pstmt.setDate(12, Date.valueOf(getMakeDate()));
/*      */       }
/*  337 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  338 */         pstmt.setNull(13, 12);
/*      */       else {
/*  340 */         pstmt.setString(13, getMakeTime());
/*      */       }
/*  342 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  343 */         pstmt.setNull(14, 91);
/*      */       else {
/*  345 */         pstmt.setDate(14, Date.valueOf(getModifyDate()));
/*      */       }
/*  347 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  348 */         pstmt.setNull(15, 12);
/*      */       else {
/*  350 */         pstmt.setString(15, getModifyTime());
/*      */       }
/*  352 */       if ((getP2() == null) || (getP2().equals("null")))
/*  353 */         pstmt.setNull(16, 12);
/*      */       else {
/*  355 */         pstmt.setString(16, getP2());
/*      */       }
/*  357 */       pstmt.setDouble(17, getP4());
/*  358 */       pstmt.setDouble(18, getP3());
/*  359 */       if ((getP1() == null) || (getP1().equals("null")))
/*  360 */         pstmt.setNull(19, 12);
/*      */       else {
/*  362 */         pstmt.setString(19, getP1());
/*      */       }
/*      */ 
/*  365 */       pstmt.executeUpdate();
/*  366 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  369 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  370 */       CError tError = new CError();
/*  371 */       tError.moduleName = "LNPInsureHistoryDB";
/*  372 */       tError.functionName = "insert()";
/*  373 */       tError.errorMessage = ex.toString();
/*  374 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  377 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  380 */       if (!this.mflag)
/*      */         try {
/*  382 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  386 */       return false;
/*      */     }
/*      */ 
/*  389 */     if (!this.mflag)
/*      */       try {
/*  391 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  395 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  400 */     PreparedStatement pstmt = null;
/*  401 */     ResultSet rs = null;
/*      */ 
/*  403 */     if (!this.mflag) {
/*  404 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  409 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?", 
/*  410 */         1003, 1007);
/*  411 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  412 */         pstmt.setNull(1, 12);
/*      */       else {
/*  414 */         pstmt.setString(1, getContNo());
/*      */       }
/*  416 */       if ((getPolOrder() == null) || (getPolOrder().equals("null")))
/*  417 */         pstmt.setNull(2, 12);
/*      */       else {
/*  419 */         pstmt.setString(2, getPolOrder());
/*      */       }
/*  421 */       rs = pstmt.executeQuery();
/*  422 */       int i = 0;
/*  423 */       if (rs.next())
/*      */       {
/*  425 */         i++;
/*  426 */         if (!setSchema(rs, i))
/*      */         {
/*  429 */           CError tError = new CError();
/*  430 */           tError.moduleName = "LNPInsureHistoryDB";
/*  431 */           tError.functionName = "getInfo";
/*  432 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  433 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  435 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  438 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  442 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  446 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  450 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  453 */       if (i == 0)
/*      */       {
/*  455 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  459 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  463 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  469 */       CError tError = new CError();
/*  470 */       tError.moduleName = "LNPInsureHistoryDB";
/*  471 */       tError.functionName = "getInfo";
/*  472 */       tError.errorMessage = e.toString();
/*  473 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  475 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  478 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  482 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  486 */       return false;
/*      */     }
/*      */ 
/*  489 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  493 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  498 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySet query()
/*      */   {
/*  503 */     Statement stmt = null;
/*  504 */     ResultSet rs = null;
/*  505 */     LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
/*      */ 
/*  507 */     if (!this.mflag) {
/*  508 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  513 */       stmt = this.con.createStatement(1003, 1007);
/*  514 */       SQLString sqlObj = new SQLString("LNPInsureHistory");
/*  515 */       LNPInsureHistorySchema aSchema = getSchema();
/*  516 */       sqlObj.setSQL(5, aSchema);
/*  517 */       String sql = sqlObj.getSQL();
/*      */ 
/*  519 */       rs = stmt.executeQuery(sql);
/*  520 */       int i = 0;
/*  521 */       while (rs.next())
/*      */       {
/*  523 */         i++;
/*  524 */         LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
/*  525 */         s1.setSchema(rs, i);
/*  526 */         aLNPInsureHistorySet.add(s1);
/*      */       }try {
/*  528 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  534 */       CError tError = new CError();
/*  535 */       tError.moduleName = "LNPInsureHistoryDB";
/*  536 */       tError.functionName = "query";
/*  537 */       tError.errorMessage = e.toString();
/*  538 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  540 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  543 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  547 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  553 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  557 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  562 */     return aLNPInsureHistorySet;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySet executeQuery(String sql)
/*      */   {
/*  567 */     Statement stmt = null;
/*  568 */     ResultSet rs = null;
/*  569 */     LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
/*      */ 
/*  571 */     if (!this.mflag) {
/*  572 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  577 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  579 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  580 */       int i = 0;
/*  581 */       while (rs.next())
/*      */       {
/*  583 */         i++;
/*  584 */         LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
/*  585 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  588 */           CError tError = new CError();
/*  589 */           tError.moduleName = "LNPInsureHistoryDB";
/*  590 */           tError.functionName = "executeQuery";
/*  591 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  592 */           this.mErrors.addOneError(tError);
/*      */         }
/*  594 */         aLNPInsureHistorySet.add(s1);
/*      */       }try {
/*  596 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  602 */       CError tError = new CError();
/*  603 */       tError.moduleName = "LNPInsureHistoryDB";
/*  604 */       tError.functionName = "executeQuery";
/*  605 */       tError.errorMessage = e.toString();
/*  606 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  608 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  611 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  615 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  621 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  625 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  630 */     return aLNPInsureHistorySet;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySet query(int nStart, int nCount)
/*      */   {
/*  635 */     Statement stmt = null;
/*  636 */     ResultSet rs = null;
/*  637 */     LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
/*      */ 
/*  639 */     if (!this.mflag) {
/*  640 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  645 */       stmt = this.con.createStatement(1003, 1007);
/*  646 */       SQLString sqlObj = new SQLString("LNPInsureHistory");
/*  647 */       LNPInsureHistorySchema aSchema = getSchema();
/*  648 */       sqlObj.setSQL(5, aSchema);
/*  649 */       String sql = sqlObj.getSQL();
/*      */ 
/*  651 */       rs = stmt.executeQuery(sql);
/*  652 */       int i = 0;
/*  653 */       while (rs.next())
/*      */       {
/*  655 */         i++;
/*      */ 
/*  657 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  661 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  665 */         LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
/*  666 */         s1.setSchema(rs, i);
/*  667 */         aLNPInsureHistorySet.add(s1);
/*      */       }try {
/*  669 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  675 */       CError tError = new CError();
/*  676 */       tError.moduleName = "LNPInsureHistoryDB";
/*  677 */       tError.functionName = "query";
/*  678 */       tError.errorMessage = e.toString();
/*  679 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  681 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  684 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  688 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  694 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  698 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  703 */     return aLNPInsureHistorySet;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  708 */     Statement stmt = null;
/*  709 */     ResultSet rs = null;
/*  710 */     LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
/*      */ 
/*  712 */     if (!this.mflag) {
/*  713 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  718 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  720 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  721 */       int i = 0;
/*  722 */       while (rs.next())
/*      */       {
/*  724 */         i++;
/*      */ 
/*  726 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  730 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  734 */         LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
/*  735 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  738 */           CError tError = new CError();
/*  739 */           tError.moduleName = "LNPInsureHistoryDB";
/*  740 */           tError.functionName = "executeQuery";
/*  741 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  742 */           this.mErrors.addOneError(tError);
/*      */         }
/*  744 */         aLNPInsureHistorySet.add(s1);
/*      */       }try {
/*  746 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  752 */       CError tError = new CError();
/*  753 */       tError.moduleName = "LNPInsureHistoryDB";
/*  754 */       tError.functionName = "executeQuery";
/*  755 */       tError.errorMessage = e.toString();
/*  756 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  758 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  761 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  765 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  771 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  775 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  780 */     return aLNPInsureHistorySet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  785 */     Statement stmt = null;
/*      */ 
/*  787 */     if (!this.mflag) {
/*  788 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  793 */       stmt = this.con.createStatement(1003, 1007);
/*  794 */       SQLString sqlObj = new SQLString("LNPInsureHistory");
/*  795 */       LNPInsureHistorySchema aSchema = getSchema();
/*  796 */       sqlObj.setSQL(2, aSchema);
/*  797 */       String sql = "update LNPInsureHistory " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  799 */       int operCount = stmt.executeUpdate(sql);
/*  800 */       if (operCount == 0)
/*      */       {
/*  803 */         CError tError = new CError();
/*  804 */         tError.moduleName = "LNPInsureHistoryDB";
/*  805 */         tError.functionName = "update";
/*  806 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  807 */         this.mErrors.addOneError(tError);
/*      */ 
/*  809 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  813 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  817 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  823 */       CError tError = new CError();
/*  824 */       tError.moduleName = "LNPInsureHistoryDB";
/*  825 */       tError.functionName = "update";
/*  826 */       tError.errorMessage = e.toString();
/*  827 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  829 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  831 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  835 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  839 */       return false;
/*      */     }
/*      */ 
/*  842 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  846 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  851 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  857 */     if (this.mResultSet != null)
/*      */     {
/*  860 */       CError tError = new CError();
/*  861 */       tError.moduleName = "LNPInsureHistoryDB";
/*  862 */       tError.functionName = "prepareData";
/*  863 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  864 */       this.mErrors.addOneError(tError);
/*  865 */       return false;
/*      */     }
/*      */ 
/*  868 */     if (!this.mflag)
/*      */     {
/*  870 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  874 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  875 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  880 */       CError tError = new CError();
/*  881 */       tError.moduleName = "LNPInsureHistoryDB";
/*  882 */       tError.functionName = "prepareData";
/*  883 */       tError.errorMessage = e.toString();
/*  884 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  887 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  893 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  897 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  901 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  906 */       return false;
/*      */     }
/*      */ 
/*  909 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  913 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  918 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  924 */     boolean flag = true;
/*  925 */     if (this.mResultSet == null)
/*      */     {
/*  927 */       CError tError = new CError();
/*  928 */       tError.moduleName = "LNPInsureHistoryDB";
/*  929 */       tError.functionName = "hasMoreData";
/*  930 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  931 */       this.mErrors.addOneError(tError);
/*  932 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  936 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  940 */       CError tError = new CError();
/*  941 */       tError.moduleName = "LNPInsureHistoryDB";
/*  942 */       tError.functionName = "hasMoreData";
/*  943 */       tError.errorMessage = ex.toString();
/*  944 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  947 */         this.mResultSet.close();
/*  948 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  954 */         this.mStatement.close();
/*  955 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  959 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  963 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  968 */       return false;
/*      */     }
/*  970 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPInsureHistorySet getData()
/*      */   {
/*  975 */     int tCount = 0;
/*  976 */     LNPInsureHistorySet tLNPInsureHistorySet = new LNPInsureHistorySet();
/*  977 */     LNPInsureHistorySchema tLNPInsureHistorySchema = null;
/*  978 */     if (this.mResultSet == null)
/*      */     {
/*  980 */       CError tError = new CError();
/*  981 */       tError.moduleName = "LNPInsureHistoryDB";
/*  982 */       tError.functionName = "getData";
/*  983 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  984 */       this.mErrors.addOneError(tError);
/*  985 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  989 */       tCount = 1;
/*  990 */       tLNPInsureHistorySchema = new LNPInsureHistorySchema();
/*  991 */       tLNPInsureHistorySchema.setSchema(this.mResultSet, 1);
/*  992 */       tLNPInsureHistorySet.add(tLNPInsureHistorySchema);
/*      */ 
/*  994 */       while (tCount++ < 5000)
/*      */       {
/*  996 */         if (!this.mResultSet.next())
/*      */           continue;
/*  998 */         tLNPInsureHistorySchema = new LNPInsureHistorySchema();
/*  999 */         tLNPInsureHistorySchema.setSchema(this.mResultSet, 1);
/* 1000 */         tLNPInsureHistorySet.add(tLNPInsureHistorySchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "LNPInsureHistoryDB";
/* 1008 */       tError.functionName = "getData";
/* 1009 */       tError.errorMessage = ex.toString();
/* 1010 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1013 */         this.mResultSet.close();
/* 1014 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1020 */         this.mStatement.close();
/* 1021 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1025 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1029 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1034 */       return null;
/*      */     }
/* 1036 */     return tLNPInsureHistorySet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1041 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1044 */       if (this.mResultSet == null)
/*      */       {
/* 1046 */         CError tError = new CError();
/* 1047 */         tError.moduleName = "LNPInsureHistoryDB";
/* 1048 */         tError.functionName = "closeData";
/* 1049 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1050 */         this.mErrors.addOneError(tError);
/* 1051 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1055 */         this.mResultSet.close();
/* 1056 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1061 */       CError tError = new CError();
/* 1062 */       tError.moduleName = "LNPInsureHistoryDB";
/* 1063 */       tError.functionName = "closeData";
/* 1064 */       tError.errorMessage = ex2.toString();
/* 1065 */       this.mErrors.addOneError(tError);
/* 1066 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1070 */       if (this.mStatement == null)
/*      */       {
/* 1072 */         CError tError = new CError();
/* 1073 */         tError.moduleName = "LNPInsureHistoryDB";
/* 1074 */         tError.functionName = "closeData";
/* 1075 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1076 */         this.mErrors.addOneError(tError);
/* 1077 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         this.mStatement.close();
/* 1082 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1087 */       CError tError = new CError();
/* 1088 */       tError.moduleName = "LNPInsureHistoryDB";
/* 1089 */       tError.functionName = "closeData";
/* 1090 */       tError.errorMessage = ex3.toString();
/* 1091 */       this.mErrors.addOneError(tError);
/* 1092 */       flag = false;
/*      */     }
/* 1094 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPInsureHistoryDB
 * JD-Core Version:    0.6.0
 */