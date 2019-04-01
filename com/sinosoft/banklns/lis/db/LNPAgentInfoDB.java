/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
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
/*      */ public class LNPAgentInfoDB extends LNPAgentInfoSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   31 */   private boolean mflag = false;
/*      */ 
/*   33 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   36 */   private ResultSet mResultSet = null;
/*   37 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPAgentInfoDB(Connection tConnection)
/*      */   {
/*   41 */     this.con = tConnection;
/*   42 */     this.db = new DBOper(this.con, "LNPAgentInfo");
/*   43 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoDB()
/*      */   {
/*   48 */     this.con = null;
/*   49 */     this.db = new DBOper("LNPAgentInfo");
/*   50 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   56 */     LNPAgentInfoSchema tSchema = getSchema();
/*   57 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   59 */       return true;
/*      */     }
/*      */ 
/*   64 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   65 */     CError tError = new CError();
/*   66 */     tError.moduleName = "LNPAgentInfoDB";
/*   67 */     tError.functionName = "deleteSQL";
/*   68 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   69 */     this.mErrors.addOneError(tError);
/*   70 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   76 */     LNPAgentInfoSchema tSchema = getSchema();
/*      */ 
/*   78 */     int tCount = this.db.getCount(tSchema);
/*   79 */     if (tCount < 0)
/*      */     {
/*   82 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   83 */       CError tError = new CError();
/*   84 */       tError.moduleName = "LNPAgentInfoDB";
/*   85 */       tError.functionName = "getCount";
/*   86 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   87 */       this.mErrors.addOneError(tError);
/*      */ 
/*   89 */       return -1;
/*      */     }
/*      */ 
/*   92 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   97 */     PreparedStatement pstmt = null;
/*      */ 
/*   99 */     if (!this.mflag) {
/*  100 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  105 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentInfo WHERE  ContNo = ? AND AgentOrder = ?");
/*  106 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  107 */         pstmt.setNull(1, 12);
/*      */       else {
/*  109 */         pstmt.setString(1, getContNo());
/*      */       }
/*  111 */       if ((getAgentOrder() == null) || (getAgentOrder().equals("null")))
/*  112 */         pstmt.setNull(2, 12);
/*      */       else {
/*  114 */         pstmt.setString(2, getAgentOrder());
/*      */       }
/*  116 */       pstmt.executeUpdate();
/*  117 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  120 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  121 */       CError tError = new CError();
/*  122 */       tError.moduleName = "LNPAgentInfoDB";
/*  123 */       tError.functionName = "delete()";
/*  124 */       tError.errorMessage = ex.toString();
/*  125 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  128 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  131 */       if (!this.mflag)
/*      */         try {
/*  133 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  137 */       return false;
/*      */     }
/*      */ 
/*  140 */     if (!this.mflag)
/*      */       try {
/*  142 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  146 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  151 */     PreparedStatement pstmt = null;
/*      */ 
/*  153 */     if (!this.mflag) {
/*  154 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  159 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AgentOrder = ? , AgentName = ? , AgentCode = ? , BranchName = ? , BranchAttr = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? , PolPrintType = ?  WHERE  ContNo = ? AND AgentOrder = ?");
/*  160 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  161 */         pstmt.setNull(1, 12);
/*      */       else {
/*  163 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  165 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  166 */         pstmt.setNull(2, 12);
/*      */       else {
/*  168 */         pstmt.setString(2, getContNo());
/*      */       }
/*  170 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  171 */         pstmt.setNull(3, 12);
/*      */       else {
/*  173 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  175 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  176 */         pstmt.setNull(4, 12);
/*      */       else {
/*  178 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  180 */       if ((getAgentOrder() == null) || (getAgentOrder().equals("null")))
/*  181 */         pstmt.setNull(5, 12);
/*      */       else {
/*  183 */         pstmt.setString(5, getAgentOrder());
/*      */       }
/*  185 */       if ((getAgentName() == null) || (getAgentName().equals("null")))
/*  186 */         pstmt.setNull(6, 12);
/*      */       else {
/*  188 */         pstmt.setString(6, getAgentName());
/*      */       }
/*  190 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  191 */         pstmt.setNull(7, 12);
/*      */       else {
/*  193 */         pstmt.setString(7, getAgentCode());
/*      */       }
/*  195 */       if ((getBranchName() == null) || (getBranchName().equals("null")))
/*  196 */         pstmt.setNull(8, 12);
/*      */       else {
/*  198 */         pstmt.setString(8, getBranchName());
/*      */       }
/*  200 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  201 */         pstmt.setNull(9, 12);
/*      */       else {
/*  203 */         pstmt.setString(9, getBranchAttr());
/*      */       }
/*  205 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  206 */         pstmt.setNull(10, 12);
/*      */       else {
/*  208 */         pstmt.setString(10, getOperator());
/*      */       }
/*  210 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  211 */         pstmt.setNull(11, 91);
/*      */       else {
/*  213 */         pstmt.setDate(11, Date.valueOf(getMakeDate()));
/*      */       }
/*  215 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  216 */         pstmt.setNull(12, 12);
/*      */       else {
/*  218 */         pstmt.setString(12, getMakeTime());
/*      */       }
/*  220 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  221 */         pstmt.setNull(13, 91);
/*      */       else {
/*  223 */         pstmt.setDate(13, Date.valueOf(getModifyDate()));
/*      */       }
/*  225 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  226 */         pstmt.setNull(14, 12);
/*      */       else {
/*  228 */         pstmt.setString(14, getModifyTime());
/*      */       }
/*  230 */       if ((getP2() == null) || (getP2().equals("null")))
/*  231 */         pstmt.setNull(15, 12);
/*      */       else {
/*  233 */         pstmt.setString(15, getP2());
/*      */       }
/*  235 */       if ((getP4() == null) || (getP4().equals("null")))
/*  236 */         pstmt.setNull(16, 12);
/*      */       else {
/*  238 */         pstmt.setString(16, getP4());
/*      */       }
/*  240 */       if ((getP3() == null) || (getP3().equals("null")))
/*  241 */         pstmt.setNull(17, 12);
/*      */       else {
/*  243 */         pstmt.setString(17, getP3());
/*      */       }
/*  245 */       if ((getP1() == null) || (getP1().equals("null")))
/*  246 */         pstmt.setNull(18, 12);
/*      */       else {
/*  248 */         pstmt.setString(18, getP1());
/*      */       }
/*  250 */       if ((getPolPrintType() == null) || (getPolPrintType().equals("null")))
/*  251 */         pstmt.setNull(19, 12);
/*      */       else {
/*  253 */         pstmt.setString(19, getPolPrintType());
/*      */       }
/*      */ 
/*  256 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  257 */         pstmt.setNull(20, 12);
/*      */       else {
/*  259 */         pstmt.setString(20, getContNo());
/*      */       }
/*  261 */       if ((getAgentOrder() == null) || (getAgentOrder().equals("null")))
/*  262 */         pstmt.setNull(21, 12);
/*      */       else {
/*  264 */         pstmt.setString(21, getAgentOrder());
/*      */       }
/*  266 */       pstmt.executeUpdate();
/*  267 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  270 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  271 */       CError tError = new CError();
/*  272 */       tError.moduleName = "LNPAgentInfoDB";
/*  273 */       tError.functionName = "update()";
/*  274 */       tError.errorMessage = ex.toString();
/*  275 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  278 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  281 */       if (!this.mflag)
/*      */         try {
/*  283 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  287 */       return false;
/*      */     }
/*      */ 
/*  290 */     if (!this.mflag)
/*      */       try {
/*  292 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  296 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  301 */     PreparedStatement pstmt = null;
/*      */ 
/*  303 */     if (!this.mflag) {
/*  304 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  309 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  310 */       if ((getGrpContNo() == null) || (getGrpContNo().equals("null")))
/*  311 */         pstmt.setNull(1, 12);
/*      */       else {
/*  313 */         pstmt.setString(1, getGrpContNo());
/*      */       }
/*  315 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  316 */         pstmt.setNull(2, 12);
/*      */       else {
/*  318 */         pstmt.setString(2, getContNo());
/*      */       }
/*  320 */       if ((getProposalContNo() == null) || (getProposalContNo().equals("null")))
/*  321 */         pstmt.setNull(3, 12);
/*      */       else {
/*  323 */         pstmt.setString(3, getProposalContNo());
/*      */       }
/*  325 */       if ((getPrtNo() == null) || (getPrtNo().equals("null")))
/*  326 */         pstmt.setNull(4, 12);
/*      */       else {
/*  328 */         pstmt.setString(4, getPrtNo());
/*      */       }
/*  330 */       if ((getAgentOrder() == null) || (getAgentOrder().equals("null")))
/*  331 */         pstmt.setNull(5, 12);
/*      */       else {
/*  333 */         pstmt.setString(5, getAgentOrder());
/*      */       }
/*  335 */       if ((getAgentName() == null) || (getAgentName().equals("null")))
/*  336 */         pstmt.setNull(6, 12);
/*      */       else {
/*  338 */         pstmt.setString(6, getAgentName());
/*      */       }
/*  340 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  341 */         pstmt.setNull(7, 12);
/*      */       else {
/*  343 */         pstmt.setString(7, getAgentCode());
/*      */       }
/*  345 */       if ((getBranchName() == null) || (getBranchName().equals("null")))
/*  346 */         pstmt.setNull(8, 12);
/*      */       else {
/*  348 */         pstmt.setString(8, getBranchName());
/*      */       }
/*  350 */       if ((getBranchAttr() == null) || (getBranchAttr().equals("null")))
/*  351 */         pstmt.setNull(9, 12);
/*      */       else {
/*  353 */         pstmt.setString(9, getBranchAttr());
/*      */       }
/*  355 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  356 */         pstmt.setNull(10, 12);
/*      */       else {
/*  358 */         pstmt.setString(10, getOperator());
/*      */       }
/*  360 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  361 */         pstmt.setNull(11, 91);
/*      */       else {
/*  363 */         pstmt.setDate(11, Date.valueOf(getMakeDate()));
/*      */       }
/*  365 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  366 */         pstmt.setNull(12, 12);
/*      */       else {
/*  368 */         pstmt.setString(12, getMakeTime());
/*      */       }
/*  370 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  371 */         pstmt.setNull(13, 91);
/*      */       else {
/*  373 */         pstmt.setDate(13, Date.valueOf(getModifyDate()));
/*      */       }
/*  375 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  376 */         pstmt.setNull(14, 12);
/*      */       else {
/*  378 */         pstmt.setString(14, getModifyTime());
/*      */       }
/*  380 */       if ((getP2() == null) || (getP2().equals("null")))
/*  381 */         pstmt.setNull(15, 12);
/*      */       else {
/*  383 */         pstmt.setString(15, getP2());
/*      */       }
/*  385 */       if ((getP4() == null) || (getP4().equals("null")))
/*  386 */         pstmt.setNull(16, 12);
/*      */       else {
/*  388 */         pstmt.setString(16, getP4());
/*      */       }
/*  390 */       if ((getP3() == null) || (getP3().equals("null")))
/*  391 */         pstmt.setNull(17, 12);
/*      */       else {
/*  393 */         pstmt.setString(17, getP3());
/*      */       }
/*  395 */       if ((getP1() == null) || (getP1().equals("null")))
/*  396 */         pstmt.setNull(18, 12);
/*      */       else {
/*  398 */         pstmt.setString(18, getP1());
/*      */       }
/*      */ 
/*  401 */       if ((getPolPrintType() == null) || (getPolPrintType().equals("null")))
/*  402 */         pstmt.setNull(19, 12);
/*      */       else {
/*  404 */         pstmt.setString(19, getPolPrintType());
/*      */       }
/*      */ 
/*  407 */       pstmt.executeUpdate();
/*  408 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  411 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  412 */       CError tError = new CError();
/*  413 */       tError.moduleName = "LNPAgentInfoDB";
/*  414 */       tError.functionName = "insert()";
/*  415 */       tError.errorMessage = ex.toString();
/*  416 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  419 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  422 */       if (!this.mflag)
/*      */         try {
/*  424 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  428 */       return false;
/*      */     }
/*      */ 
/*  431 */     if (!this.mflag)
/*      */       try {
/*  433 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  437 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  442 */     PreparedStatement pstmt = null;
/*  443 */     ResultSet rs = null;
/*      */ 
/*  445 */     if (!this.mflag) {
/*  446 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  451 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPAgentInfo WHERE  ContNo = ? AND AgentOrder = ?", 
/*  452 */         1003, 1007);
/*  453 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  454 */         pstmt.setNull(1, 12);
/*      */       else {
/*  456 */         pstmt.setString(1, getContNo());
/*      */       }
/*  458 */       if ((getAgentOrder() == null) || (getAgentOrder().equals("null")))
/*  459 */         pstmt.setNull(2, 12);
/*      */       else {
/*  461 */         pstmt.setString(2, getAgentOrder());
/*      */       }
/*  463 */       rs = pstmt.executeQuery();
/*  464 */       int i = 0;
/*  465 */       if (rs.next())
/*      */       {
/*  467 */         i++;
/*  468 */         if (!setSchema(rs, i))
/*      */         {
/*  471 */           CError tError = new CError();
/*  472 */           tError.moduleName = "LNPAgentInfoDB";
/*  473 */           tError.functionName = "getInfo";
/*  474 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  475 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  477 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  480 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  484 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  488 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  492 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  495 */       if (i == 0)
/*      */       {
/*  497 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  501 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  505 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  511 */       CError tError = new CError();
/*  512 */       tError.moduleName = "LNPAgentInfoDB";
/*  513 */       tError.functionName = "getInfo";
/*  514 */       tError.errorMessage = e.toString();
/*  515 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  517 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  520 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  524 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  528 */       return false;
/*      */     }
/*      */ 
/*  531 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  535 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  540 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSet query()
/*      */   {
/*  545 */     Statement stmt = null;
/*  546 */     ResultSet rs = null;
/*  547 */     LNPAgentInfoSet aLNPAgentInfoSet = new LNPAgentInfoSet();
/*      */ 
/*  549 */     if (!this.mflag) {
/*  550 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  555 */       stmt = this.con.createStatement(1003, 1007);
/*  556 */       SQLString sqlObj = new SQLString("LNPAgentInfo");
/*  557 */       LNPAgentInfoSchema aSchema = getSchema();
/*  558 */       sqlObj.setSQL(5, aSchema);
/*  559 */       String sql = sqlObj.getSQL();
/*      */ 
/*  561 */       rs = stmt.executeQuery(sql);
/*  562 */       int i = 0;
/*  563 */       while (rs.next())
/*      */       {
/*  565 */         i++;
/*  566 */         LNPAgentInfoSchema s1 = new LNPAgentInfoSchema();
/*  567 */         s1.setSchema(rs, i);
/*  568 */         aLNPAgentInfoSet.add(s1);
/*      */       }try {
/*  570 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  576 */       CError tError = new CError();
/*  577 */       tError.moduleName = "LNPAgentInfoDB";
/*  578 */       tError.functionName = "query";
/*  579 */       tError.errorMessage = e.toString();
/*  580 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  582 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  585 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  589 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  595 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  599 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  604 */     return aLNPAgentInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSet executeQuery(String sql)
/*      */   {
/*  609 */     Statement stmt = null;
/*  610 */     ResultSet rs = null;
/*  611 */     LNPAgentInfoSet aLNPAgentInfoSet = new LNPAgentInfoSet();
/*      */ 
/*  613 */     if (!this.mflag) {
/*  614 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  619 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  621 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  622 */       int i = 0;
/*  623 */       while (rs.next())
/*      */       {
/*  625 */         i++;
/*  626 */         LNPAgentInfoSchema s1 = new LNPAgentInfoSchema();
/*  627 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  630 */           CError tError = new CError();
/*  631 */           tError.moduleName = "LNPAgentInfoDB";
/*  632 */           tError.functionName = "executeQuery";
/*  633 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  634 */           this.mErrors.addOneError(tError);
/*      */         }
/*  636 */         aLNPAgentInfoSet.add(s1);
/*      */       }try {
/*  638 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  644 */       CError tError = new CError();
/*  645 */       tError.moduleName = "LNPAgentInfoDB";
/*  646 */       tError.functionName = "executeQuery";
/*  647 */       tError.errorMessage = e.toString();
/*  648 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  650 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  653 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  657 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  663 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  667 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  672 */     return aLNPAgentInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSet query(int nStart, int nCount)
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     LNPAgentInfoSet aLNPAgentInfoSet = new LNPAgentInfoSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*  688 */       SQLString sqlObj = new SQLString("LNPAgentInfo");
/*  689 */       LNPAgentInfoSchema aSchema = getSchema();
/*  690 */       sqlObj.setSQL(5, aSchema);
/*  691 */       String sql = sqlObj.getSQL();
/*      */ 
/*  693 */       rs = stmt.executeQuery(sql);
/*  694 */       int i = 0;
/*  695 */       while (rs.next())
/*      */       {
/*  697 */         i++;
/*      */ 
/*  699 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  703 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  707 */         LNPAgentInfoSchema s1 = new LNPAgentInfoSchema();
/*  708 */         s1.setSchema(rs, i);
/*  709 */         aLNPAgentInfoSet.add(s1);
/*      */       }try {
/*  711 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  717 */       CError tError = new CError();
/*  718 */       tError.moduleName = "LNPAgentInfoDB";
/*  719 */       tError.functionName = "query";
/*  720 */       tError.errorMessage = e.toString();
/*  721 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  723 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  726 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  730 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  736 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  740 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  745 */     return aLNPAgentInfoSet;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  750 */     Statement stmt = null;
/*  751 */     ResultSet rs = null;
/*  752 */     LNPAgentInfoSet aLNPAgentInfoSet = new LNPAgentInfoSet();
/*      */ 
/*  754 */     if (!this.mflag) {
/*  755 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  760 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  762 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  763 */       int i = 0;
/*  764 */       while (rs.next())
/*      */       {
/*  766 */         i++;
/*      */ 
/*  768 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  772 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  776 */         LNPAgentInfoSchema s1 = new LNPAgentInfoSchema();
/*  777 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  780 */           CError tError = new CError();
/*  781 */           tError.moduleName = "LNPAgentInfoDB";
/*  782 */           tError.functionName = "executeQuery";
/*  783 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  784 */           this.mErrors.addOneError(tError);
/*      */         }
/*  786 */         aLNPAgentInfoSet.add(s1);
/*      */       }try {
/*  788 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  794 */       CError tError = new CError();
/*  795 */       tError.moduleName = "LNPAgentInfoDB";
/*  796 */       tError.functionName = "executeQuery";
/*  797 */       tError.errorMessage = e.toString();
/*  798 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  800 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  803 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  807 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  813 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  817 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  822 */     return aLNPAgentInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  827 */     Statement stmt = null;
/*      */ 
/*  829 */     if (!this.mflag) {
/*  830 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  835 */       stmt = this.con.createStatement(1003, 1007);
/*  836 */       SQLString sqlObj = new SQLString("LNPAgentInfo");
/*  837 */       LNPAgentInfoSchema aSchema = getSchema();
/*  838 */       sqlObj.setSQL(2, aSchema);
/*  839 */       String sql = "update LNPAgentInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  841 */       int operCount = stmt.executeUpdate(sql);
/*  842 */       if (operCount == 0)
/*      */       {
/*  845 */         CError tError = new CError();
/*  846 */         tError.moduleName = "LNPAgentInfoDB";
/*  847 */         tError.functionName = "update";
/*  848 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  849 */         this.mErrors.addOneError(tError);
/*      */ 
/*  851 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  855 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  859 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  865 */       CError tError = new CError();
/*  866 */       tError.moduleName = "LNPAgentInfoDB";
/*  867 */       tError.functionName = "update";
/*  868 */       tError.errorMessage = e.toString();
/*  869 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  871 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  873 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  877 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  881 */       return false;
/*      */     }
/*      */ 
/*  884 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  888 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  893 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  899 */     if (this.mResultSet != null)
/*      */     {
/*  902 */       CError tError = new CError();
/*  903 */       tError.moduleName = "LNPAgentInfoDB";
/*  904 */       tError.functionName = "prepareData";
/*  905 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  906 */       this.mErrors.addOneError(tError);
/*  907 */       return false;
/*      */     }
/*      */ 
/*  910 */     if (!this.mflag)
/*      */     {
/*  912 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  916 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  917 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  922 */       CError tError = new CError();
/*  923 */       tError.moduleName = "LNPAgentInfoDB";
/*  924 */       tError.functionName = "prepareData";
/*  925 */       tError.errorMessage = e.toString();
/*  926 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  929 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  935 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  939 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  943 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  948 */       return false;
/*      */     }
/*      */ 
/*  951 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  955 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  960 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  966 */     boolean flag = true;
/*  967 */     if (this.mResultSet == null)
/*      */     {
/*  969 */       CError tError = new CError();
/*  970 */       tError.moduleName = "LNPAgentInfoDB";
/*  971 */       tError.functionName = "hasMoreData";
/*  972 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  973 */       this.mErrors.addOneError(tError);
/*  974 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  978 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  982 */       CError tError = new CError();
/*  983 */       tError.moduleName = "LNPAgentInfoDB";
/*  984 */       tError.functionName = "hasMoreData";
/*  985 */       tError.errorMessage = ex.toString();
/*  986 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  989 */         this.mResultSet.close();
/*  990 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  996 */         this.mStatement.close();
/*  997 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1001 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1005 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1010 */       return false;
/*      */     }
/* 1012 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPAgentInfoSet getData()
/*      */   {
/* 1017 */     int tCount = 0;
/* 1018 */     LNPAgentInfoSet tLNPAgentInfoSet = new LNPAgentInfoSet();
/* 1019 */     LNPAgentInfoSchema tLNPAgentInfoSchema = null;
/* 1020 */     if (this.mResultSet == null)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "LNPAgentInfoDB";
/* 1024 */       tError.functionName = "getData";
/* 1025 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1026 */       this.mErrors.addOneError(tError);
/* 1027 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1031 */       tCount = 1;
/* 1032 */       tLNPAgentInfoSchema = new LNPAgentInfoSchema();
/* 1033 */       tLNPAgentInfoSchema.setSchema(this.mResultSet, 1);
/* 1034 */       tLNPAgentInfoSet.add(tLNPAgentInfoSchema);
/*      */ 
/* 1036 */       while (tCount++ < 5000)
/*      */       {
/* 1038 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1040 */         tLNPAgentInfoSchema = new LNPAgentInfoSchema();
/* 1041 */         tLNPAgentInfoSchema.setSchema(this.mResultSet, 1);
/* 1042 */         tLNPAgentInfoSet.add(tLNPAgentInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1048 */       CError tError = new CError();
/* 1049 */       tError.moduleName = "LNPAgentInfoDB";
/* 1050 */       tError.functionName = "getData";
/* 1051 */       tError.errorMessage = ex.toString();
/* 1052 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1055 */         this.mResultSet.close();
/* 1056 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1062 */         this.mStatement.close();
/* 1063 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1067 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1071 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1076 */       return null;
/*      */     }
/* 1078 */     return tLNPAgentInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1083 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1086 */       if (this.mResultSet == null)
/*      */       {
/* 1088 */         CError tError = new CError();
/* 1089 */         tError.moduleName = "LNPAgentInfoDB";
/* 1090 */         tError.functionName = "closeData";
/* 1091 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1092 */         this.mErrors.addOneError(tError);
/* 1093 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1097 */         this.mResultSet.close();
/* 1098 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1103 */       CError tError = new CError();
/* 1104 */       tError.moduleName = "LNPAgentInfoDB";
/* 1105 */       tError.functionName = "closeData";
/* 1106 */       tError.errorMessage = ex2.toString();
/* 1107 */       this.mErrors.addOneError(tError);
/* 1108 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1112 */       if (this.mStatement == null)
/*      */       {
/* 1114 */         CError tError = new CError();
/* 1115 */         tError.moduleName = "LNPAgentInfoDB";
/* 1116 */         tError.functionName = "closeData";
/* 1117 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1118 */         this.mErrors.addOneError(tError);
/* 1119 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1123 */         this.mStatement.close();
/* 1124 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1129 */       CError tError = new CError();
/* 1130 */       tError.moduleName = "LNPAgentInfoDB";
/* 1131 */       tError.functionName = "closeData";
/* 1132 */       tError.errorMessage = ex3.toString();
/* 1133 */       this.mErrors.addOneError(tError);
/* 1134 */       flag = false;
/*      */     }
/* 1136 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAgentInfoDB
 * JD-Core Version:    0.6.0
 */