/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MNewsContentBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MNewsContentBSet;
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
/*      */ public class MNewsContentBDB extends MNewsContentBSchema
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
/*      */   public MNewsContentBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MNewsContentB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MNewsContentBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MNewsContentB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MNewsContentBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MNewsContentBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MNewsContentBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MNewsContentBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsContentB WHERE  EdorNo = ?");
/*   96 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MNewsContentBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MNewsContentB SET  ContentID = ? , NewsID = ? , Content = ? , ContOrder = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getContentID());
/*      */       }
/*  150 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getNewsID());
/*      */       }
/*  155 */       if ((getContent() == null) || (getContent().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getContent());
/*      */       }
/*  160 */       pstmt.setInt(4, getContOrder());
/*  161 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  162 */         pstmt.setNull(5, 12);
/*      */       else {
/*  164 */         pstmt.setString(5, getOperator());
/*      */       }
/*  166 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  167 */         pstmt.setNull(6, 91);
/*      */       else {
/*  169 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  171 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  176 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  177 */         pstmt.setNull(8, 91);
/*      */       else {
/*  179 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  181 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  186 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getEdorNo());
/*      */       }
/*  191 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getEdorType());
/*      */       }
/*  196 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getEdorCase());
/*      */       }
/*  201 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getOperator2());
/*      */       }
/*  206 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  207 */         pstmt.setNull(14, 91);
/*      */       else {
/*  209 */         pstmt.setDate(14, Date.valueOf(getMakeDate2()));
/*      */       }
/*  211 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  212 */         pstmt.setNull(15, 12);
/*      */       else {
/*  214 */         pstmt.setString(15, getMakeTime2());
/*      */       }
/*      */ 
/*  217 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  218 */         pstmt.setNull(16, 12);
/*      */       else {
/*  220 */         pstmt.setString(16, getEdorNo());
/*      */       }
/*  222 */       pstmt.executeUpdate();
/*  223 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  226 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  227 */       CError tError = new CError();
/*  228 */       tError.moduleName = "MNewsContentBDB";
/*  229 */       tError.functionName = "update()";
/*  230 */       tError.errorMessage = ex.toString();
/*  231 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  234 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  237 */       if (!this.mflag)
/*      */         try {
/*  239 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  243 */       return false;
/*      */     }
/*      */ 
/*  246 */     if (!this.mflag)
/*      */       try {
/*  248 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  252 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  257 */     PreparedStatement pstmt = null;
/*      */ 
/*  259 */     if (!this.mflag) {
/*  260 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  265 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsContentB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  266 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  267 */         pstmt.setNull(1, 12);
/*      */       else {
/*  269 */         pstmt.setString(1, getContentID());
/*      */       }
/*  271 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  272 */         pstmt.setNull(2, 12);
/*      */       else {
/*  274 */         pstmt.setString(2, getNewsID());
/*      */       }
/*  276 */       if ((getContent() == null) || (getContent().equals("null")))
/*  277 */         pstmt.setNull(3, 12);
/*      */       else {
/*  279 */         pstmt.setString(3, getContent());
/*      */       }
/*  281 */       pstmt.setInt(4, getContOrder());
/*  282 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  283 */         pstmt.setNull(5, 12);
/*      */       else {
/*  285 */         pstmt.setString(5, getOperator());
/*      */       }
/*  287 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  288 */         pstmt.setNull(6, 91);
/*      */       else {
/*  290 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  292 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  293 */         pstmt.setNull(7, 12);
/*      */       else {
/*  295 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  297 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  298 */         pstmt.setNull(8, 91);
/*      */       else {
/*  300 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  302 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  303 */         pstmt.setNull(9, 12);
/*      */       else {
/*  305 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  307 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  308 */         pstmt.setNull(10, 12);
/*      */       else {
/*  310 */         pstmt.setString(10, getEdorNo());
/*      */       }
/*  312 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  313 */         pstmt.setNull(11, 12);
/*      */       else {
/*  315 */         pstmt.setString(11, getEdorType());
/*      */       }
/*  317 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  318 */         pstmt.setNull(12, 12);
/*      */       else {
/*  320 */         pstmt.setString(12, getEdorCase());
/*      */       }
/*  322 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  323 */         pstmt.setNull(13, 12);
/*      */       else {
/*  325 */         pstmt.setString(13, getOperator2());
/*      */       }
/*  327 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  328 */         pstmt.setNull(14, 91);
/*      */       else {
/*  330 */         pstmt.setDate(14, Date.valueOf(getMakeDate2()));
/*      */       }
/*  332 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  333 */         pstmt.setNull(15, 12);
/*      */       else {
/*  335 */         pstmt.setString(15, getMakeTime2());
/*      */       }
/*      */ 
/*  338 */       pstmt.executeUpdate();
/*  339 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  342 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  343 */       CError tError = new CError();
/*  344 */       tError.moduleName = "MNewsContentBDB";
/*  345 */       tError.functionName = "insert()";
/*  346 */       tError.errorMessage = ex.toString();
/*  347 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  350 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  353 */       if (!this.mflag)
/*      */         try {
/*  355 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  359 */       return false;
/*      */     }
/*      */ 
/*  362 */     if (!this.mflag)
/*      */       try {
/*  364 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  368 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  373 */     PreparedStatement pstmt = null;
/*  374 */     ResultSet rs = null;
/*      */ 
/*  376 */     if (!this.mflag) {
/*  377 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  382 */       pstmt = this.con.prepareStatement("SELECT * FROM MNewsContentB WHERE  EdorNo = ?", 
/*  383 */         1003, 1007);
/*  384 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  385 */         pstmt.setNull(1, 12);
/*      */       else {
/*  387 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  389 */       rs = pstmt.executeQuery();
/*  390 */       int i = 0;
/*  391 */       if (rs.next())
/*      */       {
/*  393 */         i++;
/*  394 */         if (!setSchema(rs, i))
/*      */         {
/*  397 */           CError tError = new CError();
/*  398 */           tError.moduleName = "MNewsContentBDB";
/*  399 */           tError.functionName = "getInfo";
/*  400 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  401 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  403 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  406 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  410 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  414 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  418 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  421 */       if (i == 0)
/*      */       {
/*  423 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  427 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  431 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  437 */       CError tError = new CError();
/*  438 */       tError.moduleName = "MNewsContentBDB";
/*  439 */       tError.functionName = "getInfo";
/*  440 */       tError.errorMessage = e.toString();
/*  441 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  443 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  446 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  450 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  454 */       return false;
/*      */     }
/*      */ 
/*  457 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  461 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  466 */     return true;
/*      */   }
/*      */ 
/*      */   public MNewsContentBSet query()
/*      */   {
/*  471 */     Statement stmt = null;
/*  472 */     ResultSet rs = null;
/*  473 */     MNewsContentBSet aMNewsContentBSet = new MNewsContentBSet();
/*      */ 
/*  475 */     if (!this.mflag) {
/*  476 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  481 */       stmt = this.con.createStatement(1003, 1007);
/*  482 */       SQLString sqlObj = new SQLString("MNewsContentB");
/*  483 */       MNewsContentBSchema aSchema = getSchema();
/*  484 */       sqlObj.setSQL(5, aSchema);
/*  485 */       String sql = sqlObj.getSQL();
/*      */ 
/*  487 */       rs = stmt.executeQuery(sql);
/*  488 */       int i = 0;
/*  489 */       while (rs.next())
/*      */       {
/*  491 */         i++;
/*  492 */         MNewsContentBSchema s1 = new MNewsContentBSchema();
/*  493 */         s1.setSchema(rs, i);
/*  494 */         aMNewsContentBSet.add(s1);
/*      */       }try {
/*  496 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  502 */       CError tError = new CError();
/*  503 */       tError.moduleName = "MNewsContentBDB";
/*  504 */       tError.functionName = "query";
/*  505 */       tError.errorMessage = e.toString();
/*  506 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  508 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  511 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  515 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  521 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  525 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  530 */     return aMNewsContentBSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentBSet executeQuery(String sql)
/*      */   {
/*  535 */     Statement stmt = null;
/*  536 */     ResultSet rs = null;
/*  537 */     MNewsContentBSet aMNewsContentBSet = new MNewsContentBSet();
/*      */ 
/*  539 */     if (!this.mflag) {
/*  540 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  545 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  547 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  548 */       int i = 0;
/*  549 */       while (rs.next())
/*      */       {
/*  551 */         i++;
/*  552 */         MNewsContentBSchema s1 = new MNewsContentBSchema();
/*  553 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  556 */           CError tError = new CError();
/*  557 */           tError.moduleName = "MNewsContentBDB";
/*  558 */           tError.functionName = "executeQuery";
/*  559 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  560 */           this.mErrors.addOneError(tError);
/*      */         }
/*  562 */         aMNewsContentBSet.add(s1);
/*      */       }try {
/*  564 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  570 */       CError tError = new CError();
/*  571 */       tError.moduleName = "MNewsContentBDB";
/*  572 */       tError.functionName = "executeQuery";
/*  573 */       tError.errorMessage = e.toString();
/*  574 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  576 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  579 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  583 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  589 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  593 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  598 */     return aMNewsContentBSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentBSet query(int nStart, int nCount)
/*      */   {
/*  603 */     Statement stmt = null;
/*  604 */     ResultSet rs = null;
/*  605 */     MNewsContentBSet aMNewsContentBSet = new MNewsContentBSet();
/*      */ 
/*  607 */     if (!this.mflag) {
/*  608 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  613 */       stmt = this.con.createStatement(1003, 1007);
/*  614 */       SQLString sqlObj = new SQLString("MNewsContentB");
/*  615 */       MNewsContentBSchema aSchema = getSchema();
/*  616 */       sqlObj.setSQL(5, aSchema);
/*  617 */       String sql = sqlObj.getSQL();
/*      */ 
/*  619 */       rs = stmt.executeQuery(sql);
/*  620 */       int i = 0;
/*  621 */       while (rs.next())
/*      */       {
/*  623 */         i++;
/*      */ 
/*  625 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  629 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  633 */         MNewsContentBSchema s1 = new MNewsContentBSchema();
/*  634 */         s1.setSchema(rs, i);
/*  635 */         aMNewsContentBSet.add(s1);
/*      */       }try {
/*  637 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  643 */       CError tError = new CError();
/*  644 */       tError.moduleName = "MNewsContentBDB";
/*  645 */       tError.functionName = "query";
/*  646 */       tError.errorMessage = e.toString();
/*  647 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  649 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  652 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  656 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  662 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  666 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  671 */     return aMNewsContentBSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  676 */     Statement stmt = null;
/*  677 */     ResultSet rs = null;
/*  678 */     MNewsContentBSet aMNewsContentBSet = new MNewsContentBSet();
/*      */ 
/*  680 */     if (!this.mflag) {
/*  681 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  686 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  688 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  689 */       int i = 0;
/*  690 */       while (rs.next())
/*      */       {
/*  692 */         i++;
/*      */ 
/*  694 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  698 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  702 */         MNewsContentBSchema s1 = new MNewsContentBSchema();
/*  703 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  706 */           CError tError = new CError();
/*  707 */           tError.moduleName = "MNewsContentBDB";
/*  708 */           tError.functionName = "executeQuery";
/*  709 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  710 */           this.mErrors.addOneError(tError);
/*      */         }
/*  712 */         aMNewsContentBSet.add(s1);
/*      */       }try {
/*  714 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  720 */       CError tError = new CError();
/*  721 */       tError.moduleName = "MNewsContentBDB";
/*  722 */       tError.functionName = "executeQuery";
/*  723 */       tError.errorMessage = e.toString();
/*  724 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  726 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  729 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  733 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  739 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  743 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  748 */     return aMNewsContentBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  753 */     Statement stmt = null;
/*      */ 
/*  755 */     if (!this.mflag) {
/*  756 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  761 */       stmt = this.con.createStatement(1003, 1007);
/*  762 */       SQLString sqlObj = new SQLString("MNewsContentB");
/*  763 */       MNewsContentBSchema aSchema = getSchema();
/*  764 */       sqlObj.setSQL(2, aSchema);
/*  765 */       String sql = "update MNewsContentB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  767 */       int operCount = stmt.executeUpdate(sql);
/*  768 */       if (operCount == 0)
/*      */       {
/*  771 */         CError tError = new CError();
/*  772 */         tError.moduleName = "MNewsContentBDB";
/*  773 */         tError.functionName = "update";
/*  774 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  775 */         this.mErrors.addOneError(tError);
/*      */ 
/*  777 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  781 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  785 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  791 */       CError tError = new CError();
/*  792 */       tError.moduleName = "MNewsContentBDB";
/*  793 */       tError.functionName = "update";
/*  794 */       tError.errorMessage = e.toString();
/*  795 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  797 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  799 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  803 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  807 */       return false;
/*      */     }
/*      */ 
/*  810 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  814 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  819 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  825 */     if (this.mResultSet != null)
/*      */     {
/*  828 */       CError tError = new CError();
/*  829 */       tError.moduleName = "MNewsContentBDB";
/*  830 */       tError.functionName = "prepareData";
/*  831 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  832 */       this.mErrors.addOneError(tError);
/*  833 */       return false;
/*      */     }
/*      */ 
/*  836 */     if (!this.mflag)
/*      */     {
/*  838 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  842 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  843 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  848 */       CError tError = new CError();
/*  849 */       tError.moduleName = "MNewsContentBDB";
/*  850 */       tError.functionName = "prepareData";
/*  851 */       tError.errorMessage = e.toString();
/*  852 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  855 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  861 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  865 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  869 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  874 */       return false;
/*      */     }
/*      */ 
/*  877 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  881 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  886 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  892 */     boolean flag = true;
/*  893 */     if (this.mResultSet == null)
/*      */     {
/*  895 */       CError tError = new CError();
/*  896 */       tError.moduleName = "MNewsContentBDB";
/*  897 */       tError.functionName = "hasMoreData";
/*  898 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  899 */       this.mErrors.addOneError(tError);
/*  900 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  904 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  908 */       CError tError = new CError();
/*  909 */       tError.moduleName = "MNewsContentBDB";
/*  910 */       tError.functionName = "hasMoreData";
/*  911 */       tError.errorMessage = ex.toString();
/*  912 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  915 */         this.mResultSet.close();
/*  916 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  922 */         this.mStatement.close();
/*  923 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  927 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  931 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  936 */       return false;
/*      */     }
/*  938 */     return flag;
/*      */   }
/*      */ 
/*      */   public MNewsContentBSet getData()
/*      */   {
/*  943 */     int tCount = 0;
/*  944 */     MNewsContentBSet tMNewsContentBSet = new MNewsContentBSet();
/*  945 */     MNewsContentBSchema tMNewsContentBSchema = null;
/*  946 */     if (this.mResultSet == null)
/*      */     {
/*  948 */       CError tError = new CError();
/*  949 */       tError.moduleName = "MNewsContentBDB";
/*  950 */       tError.functionName = "getData";
/*  951 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  952 */       this.mErrors.addOneError(tError);
/*  953 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  957 */       tCount = 1;
/*  958 */       tMNewsContentBSchema = new MNewsContentBSchema();
/*  959 */       tMNewsContentBSchema.setSchema(this.mResultSet, 1);
/*  960 */       tMNewsContentBSet.add(tMNewsContentBSchema);
/*      */ 
/*  962 */       while (tCount++ < 5000)
/*      */       {
/*  964 */         if (!this.mResultSet.next())
/*      */           continue;
/*  966 */         tMNewsContentBSchema = new MNewsContentBSchema();
/*  967 */         tMNewsContentBSchema.setSchema(this.mResultSet, 1);
/*  968 */         tMNewsContentBSet.add(tMNewsContentBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  974 */       CError tError = new CError();
/*  975 */       tError.moduleName = "MNewsContentBDB";
/*  976 */       tError.functionName = "getData";
/*  977 */       tError.errorMessage = ex.toString();
/*  978 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  981 */         this.mResultSet.close();
/*  982 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  988 */         this.mStatement.close();
/*  989 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  993 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  997 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1002 */       return null;
/*      */     }
/* 1004 */     return tMNewsContentBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1009 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1012 */       if (this.mResultSet == null)
/*      */       {
/* 1014 */         CError tError = new CError();
/* 1015 */         tError.moduleName = "MNewsContentBDB";
/* 1016 */         tError.functionName = "closeData";
/* 1017 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1018 */         this.mErrors.addOneError(tError);
/* 1019 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1023 */         this.mResultSet.close();
/* 1024 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1029 */       CError tError = new CError();
/* 1030 */       tError.moduleName = "MNewsContentBDB";
/* 1031 */       tError.functionName = "closeData";
/* 1032 */       tError.errorMessage = ex2.toString();
/* 1033 */       this.mErrors.addOneError(tError);
/* 1034 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1038 */       if (this.mStatement == null)
/*      */       {
/* 1040 */         CError tError = new CError();
/* 1041 */         tError.moduleName = "MNewsContentBDB";
/* 1042 */         tError.functionName = "closeData";
/* 1043 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1044 */         this.mErrors.addOneError(tError);
/* 1045 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1049 */         this.mStatement.close();
/* 1050 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1055 */       CError tError = new CError();
/* 1056 */       tError.moduleName = "MNewsContentBDB";
/* 1057 */       tError.functionName = "closeData";
/* 1058 */       tError.errorMessage = ex3.toString();
/* 1059 */       this.mErrors.addOneError(tError);
/* 1060 */       flag = false;
/*      */     }
/* 1062 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MNewsContentBDB
 * JD-Core Version:    0.6.0
 */