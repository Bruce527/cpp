/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.CaseFileDownlLogSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class CaseFileDownlLogDB extends CaseFileDownlLogSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   26 */   private ResultSet mResultSet = null;
/*   27 */   private Statement mStatement = null;
/*      */ 
/*      */   public CaseFileDownlLogDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "CaseFileDownlLog");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("CaseFileDownlLog");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     CaseFileDownlLogSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "CaseFileDownlLogDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     CaseFileDownlLogSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "CaseFileDownlLogDB";
/*   75 */       tError.functionName = "getCount";
/*   76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   77 */       this.mErrors.addOneError(tError);
/*      */ 
/*   79 */       return -1;
/*      */     }
/*      */ 
/*   82 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   87 */     PreparedStatement pstmt = null;
/*      */ 
/*   89 */     if (!this.mflag) {
/*   90 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM CaseFileDownlLog WHERE  Id = ?");
/*   96 */       if ((getId() == null) || (getId().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getId());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "CaseFileDownlLogDB";
/*  108 */       tError.functionName = "delete()";
/*  109 */       tError.errorMessage = ex.toString();
/*  110 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  113 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  116 */       if (!this.mflag)
/*      */         try {
/*  118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  122 */       return false;
/*      */     }
/*      */ 
/*  125 */     if (!this.mflag)
/*      */       try {
/*  127 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  136 */     PreparedStatement pstmt = null;
/*      */ 
/*  138 */     if (!this.mflag) {
/*  139 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  144 */       pstmt = this.con.prepareStatement("UPDATE CaseFileDownlLog SET  Id = ? , FileDate = ? , FDownDate = ? , FDownTime = ? , Flag = ? , ModifyDate = ? , ModityTime = ? , LastOperator = ? , BY1 = ? , BY2 = ? , BY3 = ? , BY4 = ? WHERE  Id = ?");
/*  145 */       if ((getId() == null) || (getId().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getId());
/*      */       }
/*  150 */       if ((getFileDate() == null) || (getFileDate().equals("null")))
/*  151 */         pstmt.setNull(2, 91);
/*      */       else {
/*  153 */         pstmt.setDate(2, Date.valueOf(getFileDate()));
/*      */       }
/*  155 */       if ((getFDownDate() == null) || (getFDownDate().equals("null")))
/*  156 */         pstmt.setNull(3, 91);
/*      */       else {
/*  158 */         pstmt.setDate(3, Date.valueOf(getFDownDate()));
/*      */       }
/*  160 */       if ((getFDownTime() == null) || (getFDownTime().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getFDownTime());
/*      */       }
/*  165 */       if ((getFlag() == null) || (getFlag().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getFlag());
/*      */       }
/*  170 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  171 */         pstmt.setNull(6, 91);
/*      */       else {
/*  173 */         pstmt.setDate(6, Date.valueOf(getModifyDate()));
/*      */       }
/*  175 */       if ((getModityTime() == null) || (getModityTime().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getModityTime());
/*      */       }
/*  180 */       if ((getLastOperator() == null) || (getLastOperator().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getLastOperator());
/*      */       }
/*  185 */       if ((getBY1() == null) || (getBY1().equals("null")))
/*  186 */         pstmt.setNull(9, 91);
/*      */       else {
/*  188 */         pstmt.setDate(9, Date.valueOf(getBY1()));
/*      */       }
/*  190 */       if ((getBY2() == null) || (getBY2().equals("null")))
/*  191 */         pstmt.setNull(10, 91);
/*      */       else {
/*  193 */         pstmt.setDate(10, Date.valueOf(getBY2()));
/*      */       }
/*  195 */       if ((getBY3() == null) || (getBY3().equals("null")))
/*  196 */         pstmt.setNull(11, 12);
/*      */       else {
/*  198 */         pstmt.setString(11, getBY3());
/*      */       }
/*  200 */       if ((getBY4() == null) || (getBY4().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getBY4());
/*      */       }
/*      */ 
/*  206 */       if ((getId() == null) || (getId().equals("null")))
/*  207 */         pstmt.setNull(13, 12);
/*      */       else {
/*  209 */         pstmt.setString(13, getId());
/*      */       }
/*  211 */       pstmt.executeUpdate();
/*  212 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  215 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  216 */       CError tError = new CError();
/*  217 */       tError.moduleName = "CaseFileDownlLogDB";
/*  218 */       tError.functionName = "update()";
/*  219 */       tError.errorMessage = ex.toString();
/*  220 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  223 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  226 */       if (!this.mflag)
/*      */         try {
/*  228 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  232 */       return false;
/*      */     }
/*      */ 
/*  235 */     if (!this.mflag)
/*      */       try {
/*  237 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  241 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  246 */     PreparedStatement pstmt = null;
/*      */ 
/*  248 */     if (!this.mflag) {
/*  249 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  254 */       pstmt = this.con.prepareStatement("INSERT INTO CaseFileDownlLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  255 */       if ((getId() == null) || (getId().equals("null")))
/*  256 */         pstmt.setNull(1, 12);
/*      */       else {
/*  258 */         pstmt.setString(1, getId());
/*      */       }
/*  260 */       if ((getFileDate() == null) || (getFileDate().equals("null")))
/*  261 */         pstmt.setNull(2, 91);
/*      */       else {
/*  263 */         pstmt.setDate(2, Date.valueOf(getFileDate()));
/*      */       }
/*  265 */       if ((getFDownDate() == null) || (getFDownDate().equals("null")))
/*  266 */         pstmt.setNull(3, 91);
/*      */       else {
/*  268 */         pstmt.setDate(3, Date.valueOf(getFDownDate()));
/*      */       }
/*  270 */       if ((getFDownTime() == null) || (getFDownTime().equals("null")))
/*  271 */         pstmt.setNull(4, 12);
/*      */       else {
/*  273 */         pstmt.setString(4, getFDownTime());
/*      */       }
/*  275 */       if ((getFlag() == null) || (getFlag().equals("null")))
/*  276 */         pstmt.setNull(5, 12);
/*      */       else {
/*  278 */         pstmt.setString(5, getFlag());
/*      */       }
/*  280 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  281 */         pstmt.setNull(6, 91);
/*      */       else {
/*  283 */         pstmt.setDate(6, Date.valueOf(getModifyDate()));
/*      */       }
/*  285 */       if ((getModityTime() == null) || (getModityTime().equals("null")))
/*  286 */         pstmt.setNull(7, 12);
/*      */       else {
/*  288 */         pstmt.setString(7, getModityTime());
/*      */       }
/*  290 */       if ((getLastOperator() == null) || (getLastOperator().equals("null")))
/*  291 */         pstmt.setNull(8, 12);
/*      */       else {
/*  293 */         pstmt.setString(8, getLastOperator());
/*      */       }
/*  295 */       if ((getBY1() == null) || (getBY1().equals("null")))
/*  296 */         pstmt.setNull(9, 91);
/*      */       else {
/*  298 */         pstmt.setDate(9, Date.valueOf(getBY1()));
/*      */       }
/*  300 */       if ((getBY2() == null) || (getBY2().equals("null")))
/*  301 */         pstmt.setNull(10, 91);
/*      */       else {
/*  303 */         pstmt.setDate(10, Date.valueOf(getBY2()));
/*      */       }
/*  305 */       if ((getBY3() == null) || (getBY3().equals("null")))
/*  306 */         pstmt.setNull(11, 12);
/*      */       else {
/*  308 */         pstmt.setString(11, getBY3());
/*      */       }
/*  310 */       if ((getBY4() == null) || (getBY4().equals("null")))
/*  311 */         pstmt.setNull(12, 12);
/*      */       else {
/*  313 */         pstmt.setString(12, getBY4());
/*      */       }
/*      */ 
/*  316 */       pstmt.executeUpdate();
/*  317 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  320 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  321 */       CError tError = new CError();
/*  322 */       tError.moduleName = "CaseFileDownlLogDB";
/*  323 */       tError.functionName = "insert()";
/*  324 */       tError.errorMessage = ex.toString();
/*  325 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  328 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  331 */       if (!this.mflag)
/*      */         try {
/*  333 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  337 */       return false;
/*      */     }
/*      */ 
/*  340 */     if (!this.mflag)
/*      */       try {
/*  342 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  346 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  351 */     PreparedStatement pstmt = null;
/*  352 */     ResultSet rs = null;
/*      */ 
/*  354 */     if (!this.mflag) {
/*  355 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  360 */       pstmt = this.con.prepareStatement("SELECT * FROM CaseFileDownlLog WHERE  Id = ?", 
/*  361 */         1003, 1007);
/*  362 */       if ((getId() == null) || (getId().equals("null")))
/*  363 */         pstmt.setNull(1, 12);
/*      */       else {
/*  365 */         pstmt.setString(1, getId());
/*      */       }
/*  367 */       rs = pstmt.executeQuery();
/*  368 */       int i = 0;
/*  369 */       if (rs.next())
/*      */       {
/*  371 */         i++;
/*  372 */         if (!setSchema(rs, i))
/*      */         {
/*  375 */           CError tError = new CError();
/*  376 */           tError.moduleName = "CaseFileDownlLogDB";
/*  377 */           tError.functionName = "getInfo";
/*  378 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  379 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  381 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  384 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  388 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  392 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  396 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  399 */       if (i == 0)
/*      */       {
/*  401 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  405 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  409 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  415 */       CError tError = new CError();
/*  416 */       tError.moduleName = "CaseFileDownlLogDB";
/*  417 */       tError.functionName = "getInfo";
/*  418 */       tError.errorMessage = e.toString();
/*  419 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  421 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  424 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  428 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  432 */       return false;
/*      */     }
/*      */ 
/*  435 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  439 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  444 */     return true;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogSet query()
/*      */   {
/*  449 */     Statement stmt = null;
/*  450 */     ResultSet rs = null;
/*  451 */     CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
/*      */ 
/*  453 */     if (!this.mflag) {
/*  454 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  459 */       stmt = this.con.createStatement(1003, 1007);
/*  460 */       SQLString sqlObj = new SQLString("CaseFileDownlLog");
/*  461 */       CaseFileDownlLogSchema aSchema = getSchema();
/*  462 */       sqlObj.setSQL(5, aSchema);
/*  463 */       String sql = sqlObj.getSQL();
/*      */ 
/*  465 */       rs = stmt.executeQuery(sql);
/*  466 */       int i = 0;
/*  467 */       while (rs.next())
/*      */       {
/*  469 */         i++;
/*  470 */         CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
/*  471 */         s1.setSchema(rs, i);
/*  472 */         aCaseFileDownlLogSet.add(s1);
/*      */       }try {
/*  474 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  480 */       CError tError = new CError();
/*  481 */       tError.moduleName = "CaseFileDownlLogDB";
/*  482 */       tError.functionName = "query";
/*  483 */       tError.errorMessage = e.toString();
/*  484 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  486 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  489 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  493 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  499 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  503 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  508 */     return aCaseFileDownlLogSet;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogSet executeQuery(String sql)
/*      */   {
/*  513 */     Statement stmt = null;
/*  514 */     ResultSet rs = null;
/*  515 */     CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
/*      */ 
/*  517 */     if (!this.mflag) {
/*  518 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  523 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  525 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  526 */       int i = 0;
/*  527 */       while (rs.next())
/*      */       {
/*  529 */         i++;
/*  530 */         CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
/*  531 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  534 */           CError tError = new CError();
/*  535 */           tError.moduleName = "CaseFileDownlLogDB";
/*  536 */           tError.functionName = "executeQuery";
/*  537 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  538 */           this.mErrors.addOneError(tError);
/*      */         }
/*  540 */         aCaseFileDownlLogSet.add(s1);
/*      */       }try {
/*  542 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  548 */       CError tError = new CError();
/*  549 */       tError.moduleName = "CaseFileDownlLogDB";
/*  550 */       tError.functionName = "executeQuery";
/*  551 */       tError.errorMessage = e.toString();
/*  552 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  554 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  557 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  561 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  567 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  571 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  576 */     return aCaseFileDownlLogSet;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogSet query(int nStart, int nCount)
/*      */   {
/*  581 */     Statement stmt = null;
/*  582 */     ResultSet rs = null;
/*  583 */     CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
/*      */ 
/*  585 */     if (!this.mflag) {
/*  586 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  591 */       stmt = this.con.createStatement(1003, 1007);
/*  592 */       SQLString sqlObj = new SQLString("CaseFileDownlLog");
/*  593 */       CaseFileDownlLogSchema aSchema = getSchema();
/*  594 */       sqlObj.setSQL(5, aSchema);
/*  595 */       String sql = sqlObj.getSQL();
/*      */ 
/*  597 */       rs = stmt.executeQuery(sql);
/*  598 */       int i = 0;
/*  599 */       while (rs.next())
/*      */       {
/*  601 */         i++;
/*      */ 
/*  603 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  607 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  611 */         CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
/*  612 */         s1.setSchema(rs, i);
/*  613 */         aCaseFileDownlLogSet.add(s1);
/*      */       }try {
/*  615 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  621 */       CError tError = new CError();
/*  622 */       tError.moduleName = "CaseFileDownlLogDB";
/*  623 */       tError.functionName = "query";
/*  624 */       tError.errorMessage = e.toString();
/*  625 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  627 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  630 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  634 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  640 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  644 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  649 */     return aCaseFileDownlLogSet;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  654 */     Statement stmt = null;
/*  655 */     ResultSet rs = null;
/*  656 */     CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
/*      */ 
/*  658 */     if (!this.mflag) {
/*  659 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  664 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  666 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  667 */       int i = 0;
/*  668 */       while (rs.next())
/*      */       {
/*  670 */         i++;
/*      */ 
/*  672 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  676 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  680 */         CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
/*  681 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  684 */           CError tError = new CError();
/*  685 */           tError.moduleName = "CaseFileDownlLogDB";
/*  686 */           tError.functionName = "executeQuery";
/*  687 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  688 */           this.mErrors.addOneError(tError);
/*      */         }
/*  690 */         aCaseFileDownlLogSet.add(s1);
/*      */       }try {
/*  692 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  698 */       CError tError = new CError();
/*  699 */       tError.moduleName = "CaseFileDownlLogDB";
/*  700 */       tError.functionName = "executeQuery";
/*  701 */       tError.errorMessage = e.toString();
/*  702 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  704 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  707 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  711 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  717 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  721 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  726 */     return aCaseFileDownlLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  731 */     Statement stmt = null;
/*      */ 
/*  733 */     if (!this.mflag) {
/*  734 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  739 */       stmt = this.con.createStatement(1003, 1007);
/*  740 */       SQLString sqlObj = new SQLString("CaseFileDownlLog");
/*  741 */       CaseFileDownlLogSchema aSchema = getSchema();
/*  742 */       sqlObj.setSQL(2, aSchema);
/*  743 */       String sql = "update CaseFileDownlLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  745 */       int operCount = stmt.executeUpdate(sql);
/*  746 */       if (operCount == 0)
/*      */       {
/*  749 */         CError tError = new CError();
/*  750 */         tError.moduleName = "CaseFileDownlLogDB";
/*  751 */         tError.functionName = "update";
/*  752 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  753 */         this.mErrors.addOneError(tError);
/*      */ 
/*  755 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  759 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  763 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  769 */       CError tError = new CError();
/*  770 */       tError.moduleName = "CaseFileDownlLogDB";
/*  771 */       tError.functionName = "update";
/*  772 */       tError.errorMessage = e.toString();
/*  773 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  775 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  777 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  781 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  785 */       return false;
/*      */     }
/*      */ 
/*  788 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  792 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  797 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  803 */     if (this.mResultSet != null)
/*      */     {
/*  806 */       CError tError = new CError();
/*  807 */       tError.moduleName = "CaseFileDownlLogDB";
/*  808 */       tError.functionName = "prepareData";
/*  809 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  810 */       this.mErrors.addOneError(tError);
/*  811 */       return false;
/*      */     }
/*      */ 
/*  814 */     if (!this.mflag)
/*      */     {
/*  816 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  820 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  821 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  826 */       CError tError = new CError();
/*  827 */       tError.moduleName = "CaseFileDownlLogDB";
/*  828 */       tError.functionName = "prepareData";
/*  829 */       tError.errorMessage = e.toString();
/*  830 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  833 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  839 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  843 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  847 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  852 */       return false;
/*      */     }
/*      */ 
/*  855 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  859 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  864 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  870 */     boolean flag = true;
/*  871 */     if (this.mResultSet == null)
/*      */     {
/*  873 */       CError tError = new CError();
/*  874 */       tError.moduleName = "CaseFileDownlLogDB";
/*  875 */       tError.functionName = "hasMoreData";
/*  876 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  877 */       this.mErrors.addOneError(tError);
/*  878 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  882 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  886 */       CError tError = new CError();
/*  887 */       tError.moduleName = "CaseFileDownlLogDB";
/*  888 */       tError.functionName = "hasMoreData";
/*  889 */       tError.errorMessage = ex.toString();
/*  890 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  893 */         this.mResultSet.close();
/*  894 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  900 */         this.mStatement.close();
/*  901 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  905 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  909 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  914 */       return false;
/*      */     }
/*  916 */     return flag;
/*      */   }
/*      */ 
/*      */   public CaseFileDownlLogSet getData()
/*      */   {
/*  921 */     int tCount = 0;
/*  922 */     CaseFileDownlLogSet tCaseFileDownlLogSet = new CaseFileDownlLogSet();
/*  923 */     CaseFileDownlLogSchema tCaseFileDownlLogSchema = null;
/*  924 */     if (this.mResultSet == null)
/*      */     {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "CaseFileDownlLogDB";
/*  928 */       tError.functionName = "getData";
/*  929 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  930 */       this.mErrors.addOneError(tError);
/*  931 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  935 */       tCount = 1;
/*  936 */       tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/*  937 */       tCaseFileDownlLogSchema.setSchema(this.mResultSet, 1);
/*  938 */       tCaseFileDownlLogSet.add(tCaseFileDownlLogSchema);
/*      */ 
/*  940 */       while (tCount++ < 5000)
/*      */       {
/*  942 */         if (!this.mResultSet.next())
/*      */           continue;
/*  944 */         tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
/*  945 */         tCaseFileDownlLogSchema.setSchema(this.mResultSet, 1);
/*  946 */         tCaseFileDownlLogSet.add(tCaseFileDownlLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  952 */       CError tError = new CError();
/*  953 */       tError.moduleName = "CaseFileDownlLogDB";
/*  954 */       tError.functionName = "getData";
/*  955 */       tError.errorMessage = ex.toString();
/*  956 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  959 */         this.mResultSet.close();
/*  960 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  966 */         this.mStatement.close();
/*  967 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  971 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  975 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  980 */       return null;
/*      */     }
/*  982 */     return tCaseFileDownlLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  987 */     boolean flag = true;
/*      */     try
/*      */     {
/*  990 */       if (this.mResultSet == null)
/*      */       {
/*  992 */         CError tError = new CError();
/*  993 */         tError.moduleName = "CaseFileDownlLogDB";
/*  994 */         tError.functionName = "closeData";
/*  995 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  996 */         this.mErrors.addOneError(tError);
/*  997 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1001 */         this.mResultSet.close();
/* 1002 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1007 */       CError tError = new CError();
/* 1008 */       tError.moduleName = "CaseFileDownlLogDB";
/* 1009 */       tError.functionName = "closeData";
/* 1010 */       tError.errorMessage = ex2.toString();
/* 1011 */       this.mErrors.addOneError(tError);
/* 1012 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1016 */       if (this.mStatement == null)
/*      */       {
/* 1018 */         CError tError = new CError();
/* 1019 */         tError.moduleName = "CaseFileDownlLogDB";
/* 1020 */         tError.functionName = "closeData";
/* 1021 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1022 */         this.mErrors.addOneError(tError);
/* 1023 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1027 */         this.mStatement.close();
/* 1028 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1033 */       CError tError = new CError();
/* 1034 */       tError.moduleName = "CaseFileDownlLogDB";
/* 1035 */       tError.functionName = "closeData";
/* 1036 */       tError.errorMessage = ex3.toString();
/* 1037 */       this.mErrors.addOneError(tError);
/* 1038 */       flag = false;
/*      */     }
/* 1040 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.CaseFileDownlLogDB
 * JD-Core Version:    0.6.0
 */