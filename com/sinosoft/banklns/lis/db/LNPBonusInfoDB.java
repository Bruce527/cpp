/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
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
/*      */ public class LNPBonusInfoDB extends LNPBonusInfoSchema
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
/*      */   public LNPBonusInfoDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPBonusInfo");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPBonusInfo");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPBonusInfoSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPBonusInfoDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPBonusInfoSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPBonusInfoDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPBonusInfo WHERE  ContNo = ?");
/*   97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getContNo());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPBonusInfoDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPBonusInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , BonusType = ? , BonusWay = ? , AutoRepaid = ? , cutPayAll = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ?");
/*  146 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  151 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getContNo());
/*      */       }
/*  156 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  161 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  166 */       if ((getBonusType() == null) || (getBonusType().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getBonusType());
/*      */       }
/*  171 */       if ((getBonusWay() == null) || (getBonusWay().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getBonusWay());
/*      */       }
/*  176 */       if ((getAutoRepaid() == null) || (getAutoRepaid().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getAutoRepaid());
/*      */       }
/*  181 */       if ((getCutPayAll() == null) || (getCutPayAll().equals("null")))
/*  182 */         pstmt.setNull(8, 12);
/*      */       else {
/*  184 */         pstmt.setString(8, getCutPayAll());
/*      */       }
/*  186 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getOperator());
/*      */       }
/*  191 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  192 */         pstmt.setNull(10, 91);
/*      */       else {
/*  194 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  196 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*  201 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  202 */         pstmt.setNull(12, 91);
/*      */       else {
/*  204 */         pstmt.setDate(12, Date.valueOf(getModifyDate()));
/*      */       }
/*  206 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getModifyTime());
/*      */       }
/*  211 */       if ((getP2() == null) || (getP2().equals("null")))
/*  212 */         pstmt.setNull(14, 12);
/*      */       else {
/*  214 */         pstmt.setString(14, getP2());
/*      */       }
/*  216 */       if ((getP4() == null) || (getP4().equals("null")))
/*  217 */         pstmt.setNull(15, 12);
/*      */       else {
/*  219 */         pstmt.setString(15, getP4());
/*      */       }
/*  221 */       if ((getP3() == null) || (getP3().equals("null")))
/*  222 */         pstmt.setNull(16, 12);
/*      */       else {
/*  224 */         pstmt.setString(16, getP3());
/*      */       }
/*  226 */       if ((getP1() == null) || (getP1().equals("null")))
/*  227 */         pstmt.setNull(17, 12);
/*      */       else {
/*  229 */         pstmt.setString(17, getP1());
/*      */       }
/*      */ 
/*  232 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  233 */         pstmt.setNull(18, 12);
/*      */       else {
/*  235 */         pstmt.setString(18, getContNo());
/*      */       }
/*  237 */       pstmt.executeUpdate();
/*  238 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  241 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  242 */       CError tError = new CError();
/*  243 */       tError.moduleName = "LNPBonusInfoDB";
/*  244 */       tError.functionName = "update()";
/*  245 */       tError.errorMessage = ex.toString();
/*  246 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  249 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  252 */       if (!this.mflag)
/*      */         try {
/*  254 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  258 */       return false;
/*      */     }
/*      */ 
/*  261 */     if (!this.mflag)
/*      */       try {
/*  263 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  267 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  272 */     PreparedStatement pstmt = null;
/*      */ 
/*  274 */     if (!this.mflag) {
/*  275 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  280 */       pstmt = this.con.prepareStatement("INSERT INTO LNPBonusInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  281 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  282 */         pstmt.setNull(1, 12);
/*      */       else {
/*  284 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  286 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  287 */         pstmt.setNull(2, 12);
/*      */       else {
/*  289 */         pstmt.setString(2, getContNo());
/*      */       }
/*  291 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  292 */         pstmt.setNull(3, 12);
/*      */       else {
/*  294 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  296 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  297 */         pstmt.setNull(4, 12);
/*      */       else {
/*  299 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  301 */       if ((getBonusType() == null) || (getBonusType().equals("null")))
/*  302 */         pstmt.setNull(5, 12);
/*      */       else {
/*  304 */         pstmt.setString(5, getBonusType());
/*      */       }
/*  306 */       if ((getBonusWay() == null) || (getBonusWay().equals("null")))
/*  307 */         pstmt.setNull(6, 12);
/*      */       else {
/*  309 */         pstmt.setString(6, getBonusWay());
/*      */       }
/*  311 */       if ((getAutoRepaid() == null) || (getAutoRepaid().equals("null")))
/*  312 */         pstmt.setNull(7, 12);
/*      */       else {
/*  314 */         pstmt.setString(7, getAutoRepaid());
/*      */       }
/*  316 */       if ((getCutPayAll() == null) || (getCutPayAll().equals("null")))
/*  317 */         pstmt.setNull(8, 12);
/*      */       else {
/*  319 */         pstmt.setString(8, getCutPayAll());
/*      */       }
/*  321 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  322 */         pstmt.setNull(9, 12);
/*      */       else {
/*  324 */         pstmt.setString(9, getOperator());
/*      */       }
/*  326 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  327 */         pstmt.setNull(10, 91);
/*      */       else {
/*  329 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  331 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  332 */         pstmt.setNull(11, 12);
/*      */       else {
/*  334 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*  336 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  337 */         pstmt.setNull(12, 91);
/*      */       else {
/*  339 */         pstmt.setDate(12, Date.valueOf(getModifyDate()));
/*      */       }
/*  341 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  342 */         pstmt.setNull(13, 12);
/*      */       else {
/*  344 */         pstmt.setString(13, getModifyTime());
/*      */       }
/*  346 */       if ((getP2() == null) || (getP2().equals("null")))
/*  347 */         pstmt.setNull(14, 12);
/*      */       else {
/*  349 */         pstmt.setString(14, getP2());
/*      */       }
/*  351 */       if ((getP4() == null) || (getP4().equals("null")))
/*  352 */         pstmt.setNull(15, 12);
/*      */       else {
/*  354 */         pstmt.setString(15, getP4());
/*      */       }
/*  356 */       if ((getP3() == null) || (getP3().equals("null")))
/*  357 */         pstmt.setNull(16, 12);
/*      */       else {
/*  359 */         pstmt.setString(16, getP3());
/*      */       }
/*  361 */       if ((getP1() == null) || (getP1().equals("null")))
/*  362 */         pstmt.setNull(17, 12);
/*      */       else {
/*  364 */         pstmt.setString(17, getP1());
/*      */       }
/*      */ 
/*  367 */       pstmt.executeUpdate();
/*  368 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  371 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  372 */       CError tError = new CError();
/*  373 */       tError.moduleName = "LNPBonusInfoDB";
/*  374 */       tError.functionName = "insert()";
/*  375 */       tError.errorMessage = ex.toString();
/*  376 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  379 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  382 */       if (!this.mflag)
/*      */         try {
/*  384 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  388 */       return false;
/*      */     }
/*      */ 
/*  391 */     if (!this.mflag)
/*      */       try {
/*  393 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  397 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  402 */     PreparedStatement pstmt = null;
/*  403 */     ResultSet rs = null;
/*      */ 
/*  405 */     if (!this.mflag) {
/*  406 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  411 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPBonusInfo WHERE  ContNo = ?", 
/*  412 */         1003, 1007);
/*  413 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  414 */         pstmt.setNull(1, 12);
/*      */       else {
/*  416 */         pstmt.setString(1, getContNo());
/*      */       }
/*  418 */       rs = pstmt.executeQuery();
/*  419 */       int i = 0;
/*  420 */       if (rs.next())
/*      */       {
/*  422 */         i++;
/*  423 */         if (!setSchema(rs, i))
/*      */         {
/*  426 */           CError tError = new CError();
/*  427 */           tError.moduleName = "LNPBonusInfoDB";
/*  428 */           tError.functionName = "getInfo";
/*  429 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  430 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  432 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  435 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  439 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  443 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  447 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  450 */       if (i == 0)
/*      */       {
/*  452 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  456 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  460 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  466 */       CError tError = new CError();
/*  467 */       tError.moduleName = "LNPBonusInfoDB";
/*  468 */       tError.functionName = "getInfo";
/*  469 */       tError.errorMessage = e.toString();
/*  470 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  472 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  475 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  479 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  483 */       return false;
/*      */     }
/*      */ 
/*  486 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  490 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  495 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSet query()
/*      */   {
/*  500 */     Statement stmt = null;
/*  501 */     ResultSet rs = null;
/*  502 */     LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
/*      */ 
/*  504 */     if (!this.mflag) {
/*  505 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  510 */       stmt = this.con.createStatement(1003, 1007);
/*  511 */       SQLString sqlObj = new SQLString("LNPBonusInfo");
/*  512 */       LNPBonusInfoSchema aSchema = getSchema();
/*  513 */       sqlObj.setSQL(5, aSchema);
/*  514 */       String sql = sqlObj.getSQL();
/*      */ 
/*  516 */       rs = stmt.executeQuery(sql);
/*  517 */       int i = 0;
/*  518 */       while (rs.next())
/*      */       {
/*  520 */         i++;
/*  521 */         LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
/*  522 */         s1.setSchema(rs, i);
/*  523 */         aLNPBonusInfoSet.add(s1);
/*      */       }try {
/*  525 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  531 */       CError tError = new CError();
/*  532 */       tError.moduleName = "LNPBonusInfoDB";
/*  533 */       tError.functionName = "query";
/*  534 */       tError.errorMessage = e.toString();
/*  535 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  537 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  540 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  544 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  550 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  554 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  559 */     return aLNPBonusInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSet executeQuery(String sql)
/*      */   {
/*  564 */     Statement stmt = null;
/*  565 */     ResultSet rs = null;
/*  566 */     LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
/*      */ 
/*  568 */     if (!this.mflag) {
/*  569 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  574 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  576 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  577 */       int i = 0;
/*  578 */       while (rs.next())
/*      */       {
/*  580 */         i++;
/*  581 */         LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
/*  582 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  585 */           CError tError = new CError();
/*  586 */           tError.moduleName = "LNPBonusInfoDB";
/*  587 */           tError.functionName = "executeQuery";
/*  588 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  589 */           this.mErrors.addOneError(tError);
/*      */         }
/*  591 */         aLNPBonusInfoSet.add(s1);
/*      */       }try {
/*  593 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  599 */       CError tError = new CError();
/*  600 */       tError.moduleName = "LNPBonusInfoDB";
/*  601 */       tError.functionName = "executeQuery";
/*  602 */       tError.errorMessage = e.toString();
/*  603 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  605 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  608 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  612 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  618 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  622 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  627 */     return aLNPBonusInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSet query(int nStart, int nCount)
/*      */   {
/*  632 */     Statement stmt = null;
/*  633 */     ResultSet rs = null;
/*  634 */     LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
/*      */ 
/*  636 */     if (!this.mflag) {
/*  637 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  642 */       stmt = this.con.createStatement(1003, 1007);
/*  643 */       SQLString sqlObj = new SQLString("LNPBonusInfo");
/*  644 */       LNPBonusInfoSchema aSchema = getSchema();
/*  645 */       sqlObj.setSQL(5, aSchema);
/*  646 */       String sql = sqlObj.getSQL();
/*      */ 
/*  648 */       rs = stmt.executeQuery(sql);
/*  649 */       int i = 0;
/*  650 */       while (rs.next())
/*      */       {
/*  652 */         i++;
/*      */ 
/*  654 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  658 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  662 */         LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
/*  663 */         s1.setSchema(rs, i);
/*  664 */         aLNPBonusInfoSet.add(s1);
/*      */       }try {
/*  666 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  672 */       CError tError = new CError();
/*  673 */       tError.moduleName = "LNPBonusInfoDB";
/*  674 */       tError.functionName = "query";
/*  675 */       tError.errorMessage = e.toString();
/*  676 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  678 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  681 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  685 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  691 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  695 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  700 */     return aLNPBonusInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  705 */     Statement stmt = null;
/*  706 */     ResultSet rs = null;
/*  707 */     LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
/*      */ 
/*  709 */     if (!this.mflag) {
/*  710 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  715 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  717 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  718 */       int i = 0;
/*  719 */       while (rs.next())
/*      */       {
/*  721 */         i++;
/*      */ 
/*  723 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  727 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  731 */         LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
/*  732 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  735 */           CError tError = new CError();
/*  736 */           tError.moduleName = "LNPBonusInfoDB";
/*  737 */           tError.functionName = "executeQuery";
/*  738 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  739 */           this.mErrors.addOneError(tError);
/*      */         }
/*  741 */         aLNPBonusInfoSet.add(s1);
/*      */       }try {
/*  743 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  749 */       CError tError = new CError();
/*  750 */       tError.moduleName = "LNPBonusInfoDB";
/*  751 */       tError.functionName = "executeQuery";
/*  752 */       tError.errorMessage = e.toString();
/*  753 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  755 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  758 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  762 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  768 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  772 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  777 */     return aLNPBonusInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  782 */     Statement stmt = null;
/*      */ 
/*  784 */     if (!this.mflag) {
/*  785 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  790 */       stmt = this.con.createStatement(1003, 1007);
/*  791 */       SQLString sqlObj = new SQLString("LNPBonusInfo");
/*  792 */       LNPBonusInfoSchema aSchema = getSchema();
/*  793 */       sqlObj.setSQL(2, aSchema);
/*  794 */       String sql = "update LNPBonusInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  796 */       int operCount = stmt.executeUpdate(sql);
/*  797 */       if (operCount == 0)
/*      */       {
/*  800 */         CError tError = new CError();
/*  801 */         tError.moduleName = "LNPBonusInfoDB";
/*  802 */         tError.functionName = "update";
/*  803 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  804 */         this.mErrors.addOneError(tError);
/*      */ 
/*  806 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  810 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  814 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  820 */       CError tError = new CError();
/*  821 */       tError.moduleName = "LNPBonusInfoDB";
/*  822 */       tError.functionName = "update";
/*  823 */       tError.errorMessage = e.toString();
/*  824 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  826 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  828 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  832 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  836 */       return false;
/*      */     }
/*      */ 
/*  839 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  843 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  848 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  854 */     if (this.mResultSet != null)
/*      */     {
/*  857 */       CError tError = new CError();
/*  858 */       tError.moduleName = "LNPBonusInfoDB";
/*  859 */       tError.functionName = "prepareData";
/*  860 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  861 */       this.mErrors.addOneError(tError);
/*  862 */       return false;
/*      */     }
/*      */ 
/*  865 */     if (!this.mflag)
/*      */     {
/*  867 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  871 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  872 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  877 */       CError tError = new CError();
/*  878 */       tError.moduleName = "LNPBonusInfoDB";
/*  879 */       tError.functionName = "prepareData";
/*  880 */       tError.errorMessage = e.toString();
/*  881 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  884 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  890 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  894 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  898 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  903 */       return false;
/*      */     }
/*      */ 
/*  906 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  910 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  915 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  921 */     boolean flag = true;
/*  922 */     if (this.mResultSet == null)
/*      */     {
/*  924 */       CError tError = new CError();
/*  925 */       tError.moduleName = "LNPBonusInfoDB";
/*  926 */       tError.functionName = "hasMoreData";
/*  927 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  928 */       this.mErrors.addOneError(tError);
/*  929 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  933 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  937 */       CError tError = new CError();
/*  938 */       tError.moduleName = "LNPBonusInfoDB";
/*  939 */       tError.functionName = "hasMoreData";
/*  940 */       tError.errorMessage = ex.toString();
/*  941 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  944 */         this.mResultSet.close();
/*  945 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  951 */         this.mStatement.close();
/*  952 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  956 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  960 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  965 */       return false;
/*      */     }
/*  967 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSet getData()
/*      */   {
/*  972 */     int tCount = 0;
/*  973 */     LNPBonusInfoSet tLNPBonusInfoSet = new LNPBonusInfoSet();
/*  974 */     LNPBonusInfoSchema tLNPBonusInfoSchema = null;
/*  975 */     if (this.mResultSet == null)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "LNPBonusInfoDB";
/*  979 */       tError.functionName = "getData";
/*  980 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  981 */       this.mErrors.addOneError(tError);
/*  982 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  986 */       tCount = 1;
/*  987 */       tLNPBonusInfoSchema = new LNPBonusInfoSchema();
/*  988 */       tLNPBonusInfoSchema.setSchema(this.mResultSet, 1);
/*  989 */       tLNPBonusInfoSet.add(tLNPBonusInfoSchema);
/*      */ 
/*  991 */       while (tCount++ < 5000)
/*      */       {
/*  993 */         if (!this.mResultSet.next())
/*      */           continue;
/*  995 */         tLNPBonusInfoSchema = new LNPBonusInfoSchema();
/*  996 */         tLNPBonusInfoSchema.setSchema(this.mResultSet, 1);
/*  997 */         tLNPBonusInfoSet.add(tLNPBonusInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1003 */       CError tError = new CError();
/* 1004 */       tError.moduleName = "LNPBonusInfoDB";
/* 1005 */       tError.functionName = "getData";
/* 1006 */       tError.errorMessage = ex.toString();
/* 1007 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1010 */         this.mResultSet.close();
/* 1011 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1017 */         this.mStatement.close();
/* 1018 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1022 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1026 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1031 */       return null;
/*      */     }
/* 1033 */     return tLNPBonusInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1038 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1041 */       if (this.mResultSet == null)
/*      */       {
/* 1043 */         CError tError = new CError();
/* 1044 */         tError.moduleName = "LNPBonusInfoDB";
/* 1045 */         tError.functionName = "closeData";
/* 1046 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1047 */         this.mErrors.addOneError(tError);
/* 1048 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1052 */         this.mResultSet.close();
/* 1053 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1058 */       CError tError = new CError();
/* 1059 */       tError.moduleName = "LNPBonusInfoDB";
/* 1060 */       tError.functionName = "closeData";
/* 1061 */       tError.errorMessage = ex2.toString();
/* 1062 */       this.mErrors.addOneError(tError);
/* 1063 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1067 */       if (this.mStatement == null)
/*      */       {
/* 1069 */         CError tError = new CError();
/* 1070 */         tError.moduleName = "LNPBonusInfoDB";
/* 1071 */         tError.functionName = "closeData";
/* 1072 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1073 */         this.mErrors.addOneError(tError);
/* 1074 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1078 */         this.mStatement.close();
/* 1079 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1084 */       CError tError = new CError();
/* 1085 */       tError.moduleName = "LNPBonusInfoDB";
/* 1086 */       tError.functionName = "closeData";
/* 1087 */       tError.errorMessage = ex3.toString();
/* 1088 */       this.mErrors.addOneError(tError);
/* 1089 */       flag = false;
/*      */     }
/* 1091 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPBonusInfoDB
 * JD-Core Version:    0.6.0
 */