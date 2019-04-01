/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPFAndIImpOptionSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpOptionSet;
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
/*      */ public class LNPFAndIImpOptionDB extends LNPFAndIImpOptionSchema
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
/*      */   public LNPFAndIImpOptionDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPFAndIImpOption");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPFAndIImpOption");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPFAndIImpOptionSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPFAndIImpOptionDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPFAndIImpOptionSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPFAndIImpOptionDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPFAndIImpOption WHERE  OptionId = ?");
/*   97 */       if ((getOptionId() == null) || (getOptionId().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getOptionId());
/*      */       }
/*  102 */       pstmt.executeUpdate();
/*  103 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  107 */       CError tError = new CError();
/*  108 */       tError.moduleName = "LNPFAndIImpOptionDB";
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
/*  145 */       pstmt = this.con.prepareStatement("UPDATE LNPFAndIImpOption SET  ImpartId = ? , QuestionId = ? , OptionId = ? , OptionOrder = ? , OptionContent = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionId = ?");
/*  146 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  147 */         pstmt.setNull(1, 12);
/*      */       else {
/*  149 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  151 */       if ((getQuestionId() == null) || (getQuestionId().equals("null")))
/*  152 */         pstmt.setNull(2, 12);
/*      */       else {
/*  154 */         pstmt.setString(2, getQuestionId());
/*      */       }
/*  156 */       if ((getOptionId() == null) || (getOptionId().equals("null")))
/*  157 */         pstmt.setNull(3, 12);
/*      */       else {
/*  159 */         pstmt.setString(3, getOptionId());
/*      */       }
/*  161 */       if ((getOptionOrder() == null) || (getOptionOrder().equals("null")))
/*  162 */         pstmt.setNull(4, 12);
/*      */       else {
/*  164 */         pstmt.setString(4, getOptionOrder());
/*      */       }
/*  166 */       if ((getOptionContent() == null) || (getOptionContent().equals("null")))
/*  167 */         pstmt.setNull(5, 12);
/*      */       else {
/*  169 */         pstmt.setString(5, getOptionContent());
/*      */       }
/*  171 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  172 */         pstmt.setNull(6, 12);
/*      */       else {
/*  174 */         pstmt.setString(6, getOperator());
/*      */       }
/*  176 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  177 */         pstmt.setNull(7, 12);
/*      */       else {
/*  179 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  181 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  182 */         pstmt.setNull(8, 91);
/*      */       else {
/*  184 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  186 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  187 */         pstmt.setNull(9, 12);
/*      */       else {
/*  189 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  191 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  192 */         pstmt.setNull(10, 91);
/*      */       else {
/*  194 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  196 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  197 */         pstmt.setNull(11, 12);
/*      */       else {
/*  199 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*      */ 
/*  202 */       if ((getOptionId() == null) || (getOptionId().equals("null")))
/*  203 */         pstmt.setNull(12, 12);
/*      */       else {
/*  205 */         pstmt.setString(12, getOptionId());
/*      */       }
/*  207 */       pstmt.executeUpdate();
/*  208 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  211 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  212 */       CError tError = new CError();
/*  213 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  214 */       tError.functionName = "update()";
/*  215 */       tError.errorMessage = ex.toString();
/*  216 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  219 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  222 */       if (!this.mflag)
/*      */         try {
/*  224 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  228 */       return false;
/*      */     }
/*      */ 
/*  231 */     if (!this.mflag)
/*      */       try {
/*  233 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  237 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  242 */     PreparedStatement pstmt = null;
/*      */ 
/*  244 */     if (!this.mflag) {
/*  245 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  250 */       pstmt = this.con.prepareStatement("INSERT INTO LNPFAndIImpOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  251 */       if ((getImpartId() == null) || (getImpartId().equals("null")))
/*  252 */         pstmt.setNull(1, 12);
/*      */       else {
/*  254 */         pstmt.setString(1, getImpartId());
/*      */       }
/*  256 */       if ((getQuestionId() == null) || (getQuestionId().equals("null")))
/*  257 */         pstmt.setNull(2, 12);
/*      */       else {
/*  259 */         pstmt.setString(2, getQuestionId());
/*      */       }
/*  261 */       if ((getOptionId() == null) || (getOptionId().equals("null")))
/*  262 */         pstmt.setNull(3, 12);
/*      */       else {
/*  264 */         pstmt.setString(3, getOptionId());
/*      */       }
/*  266 */       if ((getOptionOrder() == null) || (getOptionOrder().equals("null")))
/*  267 */         pstmt.setNull(4, 12);
/*      */       else {
/*  269 */         pstmt.setString(4, getOptionOrder());
/*      */       }
/*  271 */       if ((getOptionContent() == null) || (getOptionContent().equals("null")))
/*  272 */         pstmt.setNull(5, 12);
/*      */       else {
/*  274 */         pstmt.setString(5, getOptionContent());
/*      */       }
/*  276 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  277 */         pstmt.setNull(6, 12);
/*      */       else {
/*  279 */         pstmt.setString(6, getOperator());
/*      */       }
/*  281 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  282 */         pstmt.setNull(7, 12);
/*      */       else {
/*  284 */         pstmt.setString(7, getManageCom());
/*      */       }
/*  286 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  287 */         pstmt.setNull(8, 91);
/*      */       else {
/*  289 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  291 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  292 */         pstmt.setNull(9, 12);
/*      */       else {
/*  294 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  296 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  297 */         pstmt.setNull(10, 91);
/*      */       else {
/*  299 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  301 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  302 */         pstmt.setNull(11, 12);
/*      */       else {
/*  304 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*      */ 
/*  307 */       pstmt.executeUpdate();
/*  308 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  311 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  312 */       CError tError = new CError();
/*  313 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  314 */       tError.functionName = "insert()";
/*  315 */       tError.errorMessage = ex.toString();
/*  316 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  319 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  322 */       if (!this.mflag)
/*      */         try {
/*  324 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  328 */       return false;
/*      */     }
/*      */ 
/*  331 */     if (!this.mflag)
/*      */       try {
/*  333 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  337 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  342 */     PreparedStatement pstmt = null;
/*  343 */     ResultSet rs = null;
/*      */ 
/*  345 */     if (!this.mflag) {
/*  346 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  351 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPFAndIImpOption WHERE  OptionId = ?", 
/*  352 */         1003, 1007);
/*  353 */       if ((getOptionId() == null) || (getOptionId().equals("null")))
/*  354 */         pstmt.setNull(1, 12);
/*      */       else {
/*  356 */         pstmt.setString(1, getOptionId());
/*      */       }
/*  358 */       rs = pstmt.executeQuery();
/*  359 */       int i = 0;
/*  360 */       if (rs.next())
/*      */       {
/*  362 */         i++;
/*  363 */         if (!setSchema(rs, i))
/*      */         {
/*  366 */           CError tError = new CError();
/*  367 */           tError.moduleName = "LNPFAndIImpOptionDB";
/*  368 */           tError.functionName = "getInfo";
/*  369 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  370 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  372 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  375 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  379 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  383 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  387 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  390 */       if (i == 0)
/*      */       {
/*  392 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  396 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  400 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  406 */       CError tError = new CError();
/*  407 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  408 */       tError.functionName = "getInfo";
/*  409 */       tError.errorMessage = e.toString();
/*  410 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  412 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  415 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  419 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  423 */       return false;
/*      */     }
/*      */ 
/*  426 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  430 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  435 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionSet query()
/*      */   {
/*  440 */     Statement stmt = null;
/*  441 */     ResultSet rs = null;
/*  442 */     LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
/*      */ 
/*  444 */     if (!this.mflag) {
/*  445 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  450 */       stmt = this.con.createStatement(1003, 1007);
/*  451 */       SQLString sqlObj = new SQLString("LNPFAndIImpOption");
/*  452 */       LNPFAndIImpOptionSchema aSchema = getSchema();
/*  453 */       sqlObj.setSQL(5, aSchema);
/*  454 */       String sql = sqlObj.getSQL();
/*      */ 
/*  456 */       rs = stmt.executeQuery(sql);
/*  457 */       int i = 0;
/*  458 */       while (rs.next())
/*      */       {
/*  460 */         i++;
/*  461 */         LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
/*  462 */         s1.setSchema(rs, i);
/*  463 */         aLNPFAndIImpOptionSet.add(s1);
/*      */       }try {
/*  465 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  471 */       CError tError = new CError();
/*  472 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  473 */       tError.functionName = "query";
/*  474 */       tError.errorMessage = e.toString();
/*  475 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  477 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  480 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  484 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  490 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  494 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  499 */     return aLNPFAndIImpOptionSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionSet executeQuery(String sql)
/*      */   {
/*  504 */     Statement stmt = null;
/*  505 */     ResultSet rs = null;
/*  506 */     LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
/*      */ 
/*  508 */     if (!this.mflag) {
/*  509 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  514 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  516 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  517 */       int i = 0;
/*  518 */       while (rs.next())
/*      */       {
/*  520 */         i++;
/*  521 */         LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
/*  522 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  525 */           CError tError = new CError();
/*  526 */           tError.moduleName = "LNPFAndIImpOptionDB";
/*  527 */           tError.functionName = "executeQuery";
/*  528 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  529 */           this.mErrors.addOneError(tError);
/*      */         }
/*  531 */         aLNPFAndIImpOptionSet.add(s1);
/*      */       }try {
/*  533 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  539 */       CError tError = new CError();
/*  540 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  541 */       tError.functionName = "executeQuery";
/*  542 */       tError.errorMessage = e.toString();
/*  543 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  545 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  548 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  552 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  558 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  562 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  567 */     return aLNPFAndIImpOptionSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionSet query(int nStart, int nCount)
/*      */   {
/*  572 */     Statement stmt = null;
/*  573 */     ResultSet rs = null;
/*  574 */     LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
/*      */ 
/*  576 */     if (!this.mflag) {
/*  577 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  582 */       stmt = this.con.createStatement(1003, 1007);
/*  583 */       SQLString sqlObj = new SQLString("LNPFAndIImpOption");
/*  584 */       LNPFAndIImpOptionSchema aSchema = getSchema();
/*  585 */       sqlObj.setSQL(5, aSchema);
/*  586 */       String sql = sqlObj.getSQL();
/*      */ 
/*  588 */       rs = stmt.executeQuery(sql);
/*  589 */       int i = 0;
/*  590 */       while (rs.next())
/*      */       {
/*  592 */         i++;
/*      */ 
/*  594 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  598 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  602 */         LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
/*  603 */         s1.setSchema(rs, i);
/*  604 */         aLNPFAndIImpOptionSet.add(s1);
/*      */       }try {
/*  606 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  612 */       CError tError = new CError();
/*  613 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  614 */       tError.functionName = "query";
/*  615 */       tError.errorMessage = e.toString();
/*  616 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  618 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  621 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  625 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  631 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  635 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  640 */     return aLNPFAndIImpOptionSet;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  645 */     Statement stmt = null;
/*  646 */     ResultSet rs = null;
/*  647 */     LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
/*      */ 
/*  649 */     if (!this.mflag) {
/*  650 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  655 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  657 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  658 */       int i = 0;
/*  659 */       while (rs.next())
/*      */       {
/*  661 */         i++;
/*      */ 
/*  663 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  667 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  671 */         LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
/*  672 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  675 */           CError tError = new CError();
/*  676 */           tError.moduleName = "LNPFAndIImpOptionDB";
/*  677 */           tError.functionName = "executeQuery";
/*  678 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  679 */           this.mErrors.addOneError(tError);
/*      */         }
/*  681 */         aLNPFAndIImpOptionSet.add(s1);
/*      */       }try {
/*  683 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  689 */       CError tError = new CError();
/*  690 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  691 */       tError.functionName = "executeQuery";
/*  692 */       tError.errorMessage = e.toString();
/*  693 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  695 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  698 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  702 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  708 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  712 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  717 */     return aLNPFAndIImpOptionSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  722 */     Statement stmt = null;
/*      */ 
/*  724 */     if (!this.mflag) {
/*  725 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  730 */       stmt = this.con.createStatement(1003, 1007);
/*  731 */       SQLString sqlObj = new SQLString("LNPFAndIImpOption");
/*  732 */       LNPFAndIImpOptionSchema aSchema = getSchema();
/*  733 */       sqlObj.setSQL(2, aSchema);
/*  734 */       String sql = "update LNPFAndIImpOption " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  736 */       int operCount = stmt.executeUpdate(sql);
/*  737 */       if (operCount == 0)
/*      */       {
/*  740 */         CError tError = new CError();
/*  741 */         tError.moduleName = "LNPFAndIImpOptionDB";
/*  742 */         tError.functionName = "update";
/*  743 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  744 */         this.mErrors.addOneError(tError);
/*      */ 
/*  746 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  750 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  754 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  760 */       CError tError = new CError();
/*  761 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  762 */       tError.functionName = "update";
/*  763 */       tError.errorMessage = e.toString();
/*  764 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  766 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  768 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  772 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  776 */       return false;
/*      */     }
/*      */ 
/*  779 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  783 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  788 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  794 */     if (this.mResultSet != null)
/*      */     {
/*  797 */       CError tError = new CError();
/*  798 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  799 */       tError.functionName = "prepareData";
/*  800 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  801 */       this.mErrors.addOneError(tError);
/*  802 */       return false;
/*      */     }
/*      */ 
/*  805 */     if (!this.mflag)
/*      */     {
/*  807 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  811 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  812 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  817 */       CError tError = new CError();
/*  818 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  819 */       tError.functionName = "prepareData";
/*  820 */       tError.errorMessage = e.toString();
/*  821 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  824 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  830 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  834 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  838 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  843 */       return false;
/*      */     }
/*      */ 
/*  846 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  850 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  855 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  861 */     boolean flag = true;
/*  862 */     if (this.mResultSet == null)
/*      */     {
/*  864 */       CError tError = new CError();
/*  865 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  866 */       tError.functionName = "hasMoreData";
/*  867 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  868 */       this.mErrors.addOneError(tError);
/*  869 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  873 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  877 */       CError tError = new CError();
/*  878 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  879 */       tError.functionName = "hasMoreData";
/*  880 */       tError.errorMessage = ex.toString();
/*  881 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  884 */         this.mResultSet.close();
/*  885 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  891 */         this.mStatement.close();
/*  892 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  896 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  900 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  905 */       return false;
/*      */     }
/*  907 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPFAndIImpOptionSet getData()
/*      */   {
/*  912 */     int tCount = 0;
/*  913 */     LNPFAndIImpOptionSet tLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
/*  914 */     LNPFAndIImpOptionSchema tLNPFAndIImpOptionSchema = null;
/*  915 */     if (this.mResultSet == null)
/*      */     {
/*  917 */       CError tError = new CError();
/*  918 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  919 */       tError.functionName = "getData";
/*  920 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  921 */       this.mErrors.addOneError(tError);
/*  922 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  926 */       tCount = 1;
/*  927 */       tLNPFAndIImpOptionSchema = new LNPFAndIImpOptionSchema();
/*  928 */       tLNPFAndIImpOptionSchema.setSchema(this.mResultSet, 1);
/*  929 */       tLNPFAndIImpOptionSet.add(tLNPFAndIImpOptionSchema);
/*      */ 
/*  931 */       while (tCount++ < 5000)
/*      */       {
/*  933 */         if (!this.mResultSet.next())
/*      */           continue;
/*  935 */         tLNPFAndIImpOptionSchema = new LNPFAndIImpOptionSchema();
/*  936 */         tLNPFAndIImpOptionSchema.setSchema(this.mResultSet, 1);
/*  937 */         tLNPFAndIImpOptionSet.add(tLNPFAndIImpOptionSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  943 */       CError tError = new CError();
/*  944 */       tError.moduleName = "LNPFAndIImpOptionDB";
/*  945 */       tError.functionName = "getData";
/*  946 */       tError.errorMessage = ex.toString();
/*  947 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  950 */         this.mResultSet.close();
/*  951 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  957 */         this.mStatement.close();
/*  958 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  962 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  966 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  971 */       return null;
/*      */     }
/*  973 */     return tLNPFAndIImpOptionSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  978 */     boolean flag = true;
/*      */     try
/*      */     {
/*  981 */       if (this.mResultSet == null)
/*      */       {
/*  983 */         CError tError = new CError();
/*  984 */         tError.moduleName = "LNPFAndIImpOptionDB";
/*  985 */         tError.functionName = "closeData";
/*  986 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/*  987 */         this.mErrors.addOneError(tError);
/*  988 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  992 */         this.mResultSet.close();
/*  993 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  998 */       CError tError = new CError();
/*  999 */       tError.moduleName = "LNPFAndIImpOptionDB";
/* 1000 */       tError.functionName = "closeData";
/* 1001 */       tError.errorMessage = ex2.toString();
/* 1002 */       this.mErrors.addOneError(tError);
/* 1003 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1007 */       if (this.mStatement == null)
/*      */       {
/* 1009 */         CError tError = new CError();
/* 1010 */         tError.moduleName = "LNPFAndIImpOptionDB";
/* 1011 */         tError.functionName = "closeData";
/* 1012 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1013 */         this.mErrors.addOneError(tError);
/* 1014 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1018 */         this.mStatement.close();
/* 1019 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1024 */       CError tError = new CError();
/* 1025 */       tError.moduleName = "LNPFAndIImpOptionDB";
/* 1026 */       tError.functionName = "closeData";
/* 1027 */       tError.errorMessage = ex3.toString();
/* 1028 */       this.mErrors.addOneError(tError);
/* 1029 */       flag = false;
/*      */     }
/* 1031 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPFAndIImpOptionDB
 * JD-Core Version:    0.6.0
 */