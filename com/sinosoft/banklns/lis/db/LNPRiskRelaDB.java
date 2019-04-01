/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskRelaSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskRelaSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPRiskRelaDB extends LNPRiskRelaSchema
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
/*      */   public LNPRiskRelaDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPRiskRela");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPRiskRela");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPRiskRelaSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPRiskRelaDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPRiskRelaSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPRiskRelaDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskRela WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       if ((getRelaRiskCode() == null) || (getRelaRiskCode().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getRelaRiskCode());
/*      */       }
/*  107 */       if ((getRelaCode() == null) || (getRelaCode().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getRelaCode());
/*      */       }
/*  112 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  113 */         pstmt.setNull(4, 12);
/*      */       else {
/*  115 */         pstmt.setString(4, getManageComGrp());
/*      */       }
/*  117 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  118 */         pstmt.setNull(5, 12);
/*      */       else {
/*  120 */         pstmt.setString(5, getSaleChnl());
/*      */       }
/*  122 */       pstmt.executeUpdate();
/*  123 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  126 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  127 */       CError tError = new CError();
/*  128 */       tError.moduleName = "LNPRiskRelaDB";
/*  129 */       tError.functionName = "delete()";
/*  130 */       tError.errorMessage = ex.toString();
/*  131 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  134 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  137 */       if (!this.mflag)
/*      */         try {
/*  139 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  143 */       return false;
/*      */     }
/*      */ 
/*  146 */     if (!this.mflag)
/*      */       try {
/*  148 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  152 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  157 */     PreparedStatement pstmt = null;
/*      */ 
/*  159 */     if (!this.mflag) {
/*  160 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  165 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskRela SET  RiskCode = ? , RelaRiskCode = ? , RelaCode = ? , ManageComGrp = ? , SaleChnl = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*  166 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  167 */         pstmt.setNull(1, 12);
/*      */       else {
/*  169 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  171 */       if ((getRelaRiskCode() == null) || (getRelaRiskCode().equals("null")))
/*  172 */         pstmt.setNull(2, 12);
/*      */       else {
/*  174 */         pstmt.setString(2, getRelaRiskCode());
/*      */       }
/*  176 */       if ((getRelaCode() == null) || (getRelaCode().equals("null")))
/*  177 */         pstmt.setNull(3, 12);
/*      */       else {
/*  179 */         pstmt.setString(3, getRelaCode());
/*      */       }
/*  181 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  182 */         pstmt.setNull(4, 12);
/*      */       else {
/*  184 */         pstmt.setString(4, getManageComGrp());
/*      */       }
/*  186 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  187 */         pstmt.setNull(5, 12);
/*      */       else {
/*  189 */         pstmt.setString(5, getSaleChnl());
/*      */       }
/*  191 */       pstmt.setInt(6, getMinAppntAge());
/*  192 */       pstmt.setInt(7, getMaxAppntAge());
/*  193 */       pstmt.setInt(8, getMaxInsuredAge());
/*  194 */       pstmt.setInt(9, getMinInsuredAge());
/*      */ 
/*  196 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  197 */         pstmt.setNull(10, 12);
/*      */       else {
/*  199 */         pstmt.setString(10, getRiskCode());
/*      */       }
/*  201 */       if ((getRelaRiskCode() == null) || (getRelaRiskCode().equals("null")))
/*  202 */         pstmt.setNull(11, 12);
/*      */       else {
/*  204 */         pstmt.setString(11, getRelaRiskCode());
/*      */       }
/*  206 */       if ((getRelaCode() == null) || (getRelaCode().equals("null")))
/*  207 */         pstmt.setNull(12, 12);
/*      */       else {
/*  209 */         pstmt.setString(12, getRelaCode());
/*      */       }
/*  211 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  212 */         pstmt.setNull(13, 12);
/*      */       else {
/*  214 */         pstmt.setString(13, getManageComGrp());
/*      */       }
/*  216 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  217 */         pstmt.setNull(14, 12);
/*      */       else {
/*  219 */         pstmt.setString(14, getSaleChnl());
/*      */       }
/*  221 */       pstmt.executeUpdate();
/*  222 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  225 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  226 */       CError tError = new CError();
/*  227 */       tError.moduleName = "LNPRiskRelaDB";
/*  228 */       tError.functionName = "update()";
/*  229 */       tError.errorMessage = ex.toString();
/*  230 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  233 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  236 */       if (!this.mflag)
/*      */         try {
/*  238 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  242 */       return false;
/*      */     }
/*      */ 
/*  245 */     if (!this.mflag)
/*      */       try {
/*  247 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  251 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  256 */     PreparedStatement pstmt = null;
/*      */ 
/*  258 */     if (!this.mflag) {
/*  259 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  264 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskRela VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  265 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  266 */         pstmt.setNull(1, 12);
/*      */       else {
/*  268 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  270 */       if ((getRelaRiskCode() == null) || (getRelaRiskCode().equals("null")))
/*  271 */         pstmt.setNull(2, 12);
/*      */       else {
/*  273 */         pstmt.setString(2, getRelaRiskCode());
/*      */       }
/*  275 */       if ((getRelaCode() == null) || (getRelaCode().equals("null")))
/*  276 */         pstmt.setNull(3, 12);
/*      */       else {
/*  278 */         pstmt.setString(3, getRelaCode());
/*      */       }
/*  280 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  281 */         pstmt.setNull(4, 12);
/*      */       else {
/*  283 */         pstmt.setString(4, getManageComGrp());
/*      */       }
/*  285 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  286 */         pstmt.setNull(5, 12);
/*      */       else {
/*  288 */         pstmt.setString(5, getSaleChnl());
/*      */       }
/*  290 */       pstmt.setInt(6, getMinAppntAge());
/*  291 */       pstmt.setInt(7, getMaxAppntAge());
/*  292 */       pstmt.setInt(8, getMaxInsuredAge());
/*  293 */       pstmt.setInt(9, getMinInsuredAge());
/*      */ 
/*  295 */       pstmt.executeUpdate();
/*  296 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  299 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  300 */       CError tError = new CError();
/*  301 */       tError.moduleName = "LNPRiskRelaDB";
/*  302 */       tError.functionName = "insert()";
/*  303 */       tError.errorMessage = ex.toString();
/*  304 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  307 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  310 */       if (!this.mflag)
/*      */         try {
/*  312 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  316 */       return false;
/*      */     }
/*      */ 
/*  319 */     if (!this.mflag)
/*      */       try {
/*  321 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  325 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  330 */     PreparedStatement pstmt = null;
/*  331 */     ResultSet rs = null;
/*      */ 
/*  333 */     if (!this.mflag) {
/*  334 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  339 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskRela WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?", 
/*  340 */         1003, 1007);
/*  341 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  342 */         pstmt.setNull(1, 12);
/*      */       else {
/*  344 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  346 */       if ((getRelaRiskCode() == null) || (getRelaRiskCode().equals("null")))
/*  347 */         pstmt.setNull(2, 12);
/*      */       else {
/*  349 */         pstmt.setString(2, getRelaRiskCode());
/*      */       }
/*  351 */       if ((getRelaCode() == null) || (getRelaCode().equals("null")))
/*  352 */         pstmt.setNull(3, 12);
/*      */       else {
/*  354 */         pstmt.setString(3, getRelaCode());
/*      */       }
/*  356 */       if ((getManageComGrp() == null) || (getManageComGrp().equals("null")))
/*  357 */         pstmt.setNull(4, 12);
/*      */       else {
/*  359 */         pstmt.setString(4, getManageComGrp());
/*      */       }
/*  361 */       if ((getSaleChnl() == null) || (getSaleChnl().equals("null")))
/*  362 */         pstmt.setNull(5, 12);
/*      */       else {
/*  364 */         pstmt.setString(5, getSaleChnl());
/*      */       }
/*  366 */       rs = pstmt.executeQuery();
/*  367 */       int i = 0;
/*  368 */       if (rs.next())
/*      */       {
/*  370 */         i++;
/*  371 */         if (!setSchema(rs, i))
/*      */         {
/*  374 */           CError tError = new CError();
/*  375 */           tError.moduleName = "LNPRiskRelaDB";
/*  376 */           tError.functionName = "getInfo";
/*  377 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  378 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  380 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  383 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  387 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  391 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  395 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  398 */       if (i == 0)
/*      */       {
/*  400 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  404 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  408 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  414 */       CError tError = new CError();
/*  415 */       tError.moduleName = "LNPRiskRelaDB";
/*  416 */       tError.functionName = "getInfo";
/*  417 */       tError.errorMessage = e.toString();
/*  418 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  420 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  423 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  427 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  431 */       return false;
/*      */     }
/*      */ 
/*  434 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  438 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  443 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaSet query()
/*      */   {
/*  448 */     Statement stmt = null;
/*  449 */     ResultSet rs = null;
/*  450 */     LNPRiskRelaSet aLNPRiskRelaSet = new LNPRiskRelaSet();
/*      */ 
/*  452 */     if (!this.mflag) {
/*  453 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  458 */       stmt = this.con.createStatement(1003, 1007);
/*  459 */       SQLString sqlObj = new SQLString("LNPRiskRela");
/*  460 */       LNPRiskRelaSchema aSchema = getSchema();
/*  461 */       sqlObj.setSQL(5, aSchema);
/*  462 */       String sql = sqlObj.getSQL();
/*      */ 
/*  464 */       rs = stmt.executeQuery(sql);
/*  465 */       int i = 0;
/*  466 */       while (rs.next())
/*      */       {
/*  468 */         i++;
/*  469 */         LNPRiskRelaSchema s1 = new LNPRiskRelaSchema();
/*  470 */         s1.setSchema(rs, i);
/*  471 */         aLNPRiskRelaSet.add(s1);
/*      */       }try {
/*  473 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  479 */       CError tError = new CError();
/*  480 */       tError.moduleName = "LNPRiskRelaDB";
/*  481 */       tError.functionName = "query";
/*  482 */       tError.errorMessage = e.toString();
/*  483 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  485 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  488 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  492 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  498 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  502 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  507 */     return aLNPRiskRelaSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaSet executeQuery(String sql)
/*      */   {
/*  512 */     Statement stmt = null;
/*  513 */     ResultSet rs = null;
/*  514 */     LNPRiskRelaSet aLNPRiskRelaSet = new LNPRiskRelaSet();
/*      */ 
/*  516 */     if (!this.mflag) {
/*  517 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  522 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  524 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  525 */       int i = 0;
/*  526 */       while (rs.next())
/*      */       {
/*  528 */         i++;
/*  529 */         LNPRiskRelaSchema s1 = new LNPRiskRelaSchema();
/*  530 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  533 */           CError tError = new CError();
/*  534 */           tError.moduleName = "LNPRiskRelaDB";
/*  535 */           tError.functionName = "executeQuery";
/*  536 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  537 */           this.mErrors.addOneError(tError);
/*      */         }
/*  539 */         aLNPRiskRelaSet.add(s1);
/*      */       }try {
/*  541 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  547 */       CError tError = new CError();
/*  548 */       tError.moduleName = "LNPRiskRelaDB";
/*  549 */       tError.functionName = "executeQuery";
/*  550 */       tError.errorMessage = e.toString();
/*  551 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  553 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  556 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  560 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  566 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  570 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  575 */     return aLNPRiskRelaSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaSet query(int nStart, int nCount)
/*      */   {
/*  580 */     Statement stmt = null;
/*  581 */     ResultSet rs = null;
/*  582 */     LNPRiskRelaSet aLNPRiskRelaSet = new LNPRiskRelaSet();
/*      */ 
/*  584 */     if (!this.mflag) {
/*  585 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  590 */       stmt = this.con.createStatement(1003, 1007);
/*  591 */       SQLString sqlObj = new SQLString("LNPRiskRela");
/*  592 */       LNPRiskRelaSchema aSchema = getSchema();
/*  593 */       sqlObj.setSQL(5, aSchema);
/*  594 */       String sql = sqlObj.getSQL();
/*      */ 
/*  596 */       rs = stmt.executeQuery(sql);
/*  597 */       int i = 0;
/*  598 */       while (rs.next())
/*      */       {
/*  600 */         i++;
/*      */ 
/*  602 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  606 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  610 */         LNPRiskRelaSchema s1 = new LNPRiskRelaSchema();
/*  611 */         s1.setSchema(rs, i);
/*  612 */         aLNPRiskRelaSet.add(s1);
/*      */       }try {
/*  614 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  620 */       CError tError = new CError();
/*  621 */       tError.moduleName = "LNPRiskRelaDB";
/*  622 */       tError.functionName = "query";
/*  623 */       tError.errorMessage = e.toString();
/*  624 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  626 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  629 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  633 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  639 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  643 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  648 */     return aLNPRiskRelaSet;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  653 */     Statement stmt = null;
/*  654 */     ResultSet rs = null;
/*  655 */     LNPRiskRelaSet aLNPRiskRelaSet = new LNPRiskRelaSet();
/*      */ 
/*  657 */     if (!this.mflag) {
/*  658 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  663 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  665 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  666 */       int i = 0;
/*  667 */       while (rs.next())
/*      */       {
/*  669 */         i++;
/*      */ 
/*  671 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  675 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  679 */         LNPRiskRelaSchema s1 = new LNPRiskRelaSchema();
/*  680 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  683 */           CError tError = new CError();
/*  684 */           tError.moduleName = "LNPRiskRelaDB";
/*  685 */           tError.functionName = "executeQuery";
/*  686 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  687 */           this.mErrors.addOneError(tError);
/*      */         }
/*  689 */         aLNPRiskRelaSet.add(s1);
/*      */       }try {
/*  691 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  697 */       CError tError = new CError();
/*  698 */       tError.moduleName = "LNPRiskRelaDB";
/*  699 */       tError.functionName = "executeQuery";
/*  700 */       tError.errorMessage = e.toString();
/*  701 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  703 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  706 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  710 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  716 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  720 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  725 */     return aLNPRiskRelaSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  730 */     Statement stmt = null;
/*      */ 
/*  732 */     if (!this.mflag) {
/*  733 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  738 */       stmt = this.con.createStatement(1003, 1007);
/*  739 */       SQLString sqlObj = new SQLString("LNPRiskRela");
/*  740 */       LNPRiskRelaSchema aSchema = getSchema();
/*  741 */       sqlObj.setSQL(2, aSchema);
/*  742 */       String sql = "update LNPRiskRela " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  744 */       int operCount = stmt.executeUpdate(sql);
/*  745 */       if (operCount == 0)
/*      */       {
/*  748 */         CError tError = new CError();
/*  749 */         tError.moduleName = "LNPRiskRelaDB";
/*  750 */         tError.functionName = "update";
/*  751 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  752 */         this.mErrors.addOneError(tError);
/*      */ 
/*  754 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  758 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  762 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  768 */       CError tError = new CError();
/*  769 */       tError.moduleName = "LNPRiskRelaDB";
/*  770 */       tError.functionName = "update";
/*  771 */       tError.errorMessage = e.toString();
/*  772 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  774 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  776 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  780 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  784 */       return false;
/*      */     }
/*      */ 
/*  787 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  791 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  796 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  802 */     if (this.mResultSet != null)
/*      */     {
/*  805 */       CError tError = new CError();
/*  806 */       tError.moduleName = "LNPRiskRelaDB";
/*  807 */       tError.functionName = "prepareData";
/*  808 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  809 */       this.mErrors.addOneError(tError);
/*  810 */       return false;
/*      */     }
/*      */ 
/*  813 */     if (!this.mflag)
/*      */     {
/*  815 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  819 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  820 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  825 */       CError tError = new CError();
/*  826 */       tError.moduleName = "LNPRiskRelaDB";
/*  827 */       tError.functionName = "prepareData";
/*  828 */       tError.errorMessage = e.toString();
/*  829 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  832 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  838 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  842 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  846 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  851 */       return false;
/*      */     }
/*      */ 
/*  854 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  858 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  863 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  869 */     boolean flag = true;
/*  870 */     if (this.mResultSet == null)
/*      */     {
/*  872 */       CError tError = new CError();
/*  873 */       tError.moduleName = "LNPRiskRelaDB";
/*  874 */       tError.functionName = "hasMoreData";
/*  875 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  876 */       this.mErrors.addOneError(tError);
/*  877 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  881 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  885 */       CError tError = new CError();
/*  886 */       tError.moduleName = "LNPRiskRelaDB";
/*  887 */       tError.functionName = "hasMoreData";
/*  888 */       tError.errorMessage = ex.toString();
/*  889 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  892 */         this.mResultSet.close();
/*  893 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  899 */         this.mStatement.close();
/*  900 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  904 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  908 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  913 */       return false;
/*      */     }
/*  915 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPRiskRelaSet getData()
/*      */   {
/*  920 */     int tCount = 0;
/*  921 */     LNPRiskRelaSet tLNPRiskRelaSet = new LNPRiskRelaSet();
/*  922 */     LNPRiskRelaSchema tLNPRiskRelaSchema = null;
/*  923 */     if (this.mResultSet == null)
/*      */     {
/*  925 */       CError tError = new CError();
/*  926 */       tError.moduleName = "LNPRiskRelaDB";
/*  927 */       tError.functionName = "getData";
/*  928 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  929 */       this.mErrors.addOneError(tError);
/*  930 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  934 */       tCount = 1;
/*  935 */       tLNPRiskRelaSchema = new LNPRiskRelaSchema();
/*  936 */       tLNPRiskRelaSchema.setSchema(this.mResultSet, 1);
/*  937 */       tLNPRiskRelaSet.add(tLNPRiskRelaSchema);
/*      */ 
/*  939 */       while (tCount++ < 5000)
/*      */       {
/*  941 */         if (!this.mResultSet.next())
/*      */           continue;
/*  943 */         tLNPRiskRelaSchema = new LNPRiskRelaSchema();
/*  944 */         tLNPRiskRelaSchema.setSchema(this.mResultSet, 1);
/*  945 */         tLNPRiskRelaSet.add(tLNPRiskRelaSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  951 */       CError tError = new CError();
/*  952 */       tError.moduleName = "LNPRiskRelaDB";
/*  953 */       tError.functionName = "getData";
/*  954 */       tError.errorMessage = ex.toString();
/*  955 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  958 */         this.mResultSet.close();
/*  959 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  965 */         this.mStatement.close();
/*  966 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  970 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  974 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  979 */       return null;
/*      */     }
/*  981 */     return tLNPRiskRelaSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  986 */     boolean flag = true;
/*      */     try
/*      */     {
/*  989 */       if (this.mResultSet == null)
/*      */       {
/*  991 */         CError tError = new CError();
/*  992 */         tError.moduleName = "LNPRiskRelaDB";
/*  993 */         tError.functionName = "closeData";
/*  994 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  995 */         this.mErrors.addOneError(tError);
/*  996 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1000 */         this.mResultSet.close();
/* 1001 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1006 */       CError tError = new CError();
/* 1007 */       tError.moduleName = "LNPRiskRelaDB";
/* 1008 */       tError.functionName = "closeData";
/* 1009 */       tError.errorMessage = ex2.toString();
/* 1010 */       this.mErrors.addOneError(tError);
/* 1011 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1015 */       if (this.mStatement == null)
/*      */       {
/* 1017 */         CError tError = new CError();
/* 1018 */         tError.moduleName = "LNPRiskRelaDB";
/* 1019 */         tError.functionName = "closeData";
/* 1020 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1021 */         this.mErrors.addOneError(tError);
/* 1022 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1026 */         this.mStatement.close();
/* 1027 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "LNPRiskRelaDB";
/* 1034 */       tError.functionName = "closeData";
/* 1035 */       tError.errorMessage = ex3.toString();
/* 1036 */       this.mErrors.addOneError(tError);
/* 1037 */       flag = false;
/*      */     }
/* 1039 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskRelaDB
 * JD-Core Version:    0.6.0
 */