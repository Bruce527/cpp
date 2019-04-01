/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MHelpSchema;
/*      */ import com.sinosoft.map.lis.vschema.MHelpSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MHelpDB extends MHelpSchema
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
/*      */   public MHelpDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MHelp");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MHelpDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MHelp");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MHelpSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MHelpDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MHelpSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MHelpDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MHelp WHERE  ID = ?");
/*   96 */       if ((getID() == null) || (getID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MHelpDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MHelp SET  ID = ? , ManageCom = ? , Application = ? , Person = ? , Email = ? , Tel = ? , VF1 = ? , VF2 = ? , VF3 = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  155 */       if ((getApplication() == null) || (getApplication().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getApplication());
/*      */       }
/*  160 */       if ((getPerson() == null) || (getPerson().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getPerson());
/*      */       }
/*  165 */       if ((getEmail() == null) || (getEmail().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getEmail());
/*      */       }
/*  170 */       if ((getTel() == null) || (getTel().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getTel());
/*      */       }
/*  175 */       if ((getVF1() == null) || (getVF1().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getVF1());
/*      */       }
/*  180 */       if ((getVF2() == null) || (getVF2().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getVF2());
/*      */       }
/*  185 */       if ((getVF3() == null) || (getVF3().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getVF3());
/*      */       }
/*      */ 
/*  191 */       if ((getID() == null) || (getID().equals("null")))
/*  192 */         pstmt.setNull(10, 12);
/*      */       else {
/*  194 */         pstmt.setString(10, getID());
/*      */       }
/*  196 */       pstmt.executeUpdate();
/*  197 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  200 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  201 */       CError tError = new CError();
/*  202 */       tError.moduleName = "MHelpDB";
/*  203 */       tError.functionName = "update()";
/*  204 */       tError.errorMessage = ex.toString();
/*  205 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  208 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  211 */       if (!this.mflag)
/*      */         try {
/*  213 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  217 */       return false;
/*      */     }
/*      */ 
/*  220 */     if (!this.mflag)
/*      */       try {
/*  222 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  226 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  231 */     PreparedStatement pstmt = null;
/*      */ 
/*  233 */     if (!this.mflag) {
/*  234 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  239 */       pstmt = this.con.prepareStatement("INSERT INTO MHelp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  240 */       if ((getID() == null) || (getID().equals("null")))
/*  241 */         pstmt.setNull(1, 12);
/*      */       else {
/*  243 */         pstmt.setString(1, getID());
/*      */       }
/*  245 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  246 */         pstmt.setNull(2, 12);
/*      */       else {
/*  248 */         pstmt.setString(2, getManageCom());
/*      */       }
/*  250 */       if ((getApplication() == null) || (getApplication().equals("null")))
/*  251 */         pstmt.setNull(3, 12);
/*      */       else {
/*  253 */         pstmt.setString(3, getApplication());
/*      */       }
/*  255 */       if ((getPerson() == null) || (getPerson().equals("null")))
/*  256 */         pstmt.setNull(4, 12);
/*      */       else {
/*  258 */         pstmt.setString(4, getPerson());
/*      */       }
/*  260 */       if ((getEmail() == null) || (getEmail().equals("null")))
/*  261 */         pstmt.setNull(5, 12);
/*      */       else {
/*  263 */         pstmt.setString(5, getEmail());
/*      */       }
/*  265 */       if ((getTel() == null) || (getTel().equals("null")))
/*  266 */         pstmt.setNull(6, 12);
/*      */       else {
/*  268 */         pstmt.setString(6, getTel());
/*      */       }
/*  270 */       if ((getVF1() == null) || (getVF1().equals("null")))
/*  271 */         pstmt.setNull(7, 12);
/*      */       else {
/*  273 */         pstmt.setString(7, getVF1());
/*      */       }
/*  275 */       if ((getVF2() == null) || (getVF2().equals("null")))
/*  276 */         pstmt.setNull(8, 12);
/*      */       else {
/*  278 */         pstmt.setString(8, getVF2());
/*      */       }
/*  280 */       if ((getVF3() == null) || (getVF3().equals("null")))
/*  281 */         pstmt.setNull(9, 12);
/*      */       else {
/*  283 */         pstmt.setString(9, getVF3());
/*      */       }
/*      */ 
/*  286 */       pstmt.executeUpdate();
/*  287 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  290 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  291 */       CError tError = new CError();
/*  292 */       tError.moduleName = "MHelpDB";
/*  293 */       tError.functionName = "insert()";
/*  294 */       tError.errorMessage = ex.toString();
/*  295 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  298 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  301 */       if (!this.mflag)
/*      */         try {
/*  303 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  307 */       return false;
/*      */     }
/*      */ 
/*  310 */     if (!this.mflag)
/*      */       try {
/*  312 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  316 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  321 */     PreparedStatement pstmt = null;
/*  322 */     ResultSet rs = null;
/*      */ 
/*  324 */     if (!this.mflag) {
/*  325 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  330 */       pstmt = this.con.prepareStatement("SELECT * FROM MHelp WHERE  ID = ?", 
/*  331 */         1003, 1007);
/*  332 */       if ((getID() == null) || (getID().equals("null")))
/*  333 */         pstmt.setNull(1, 12);
/*      */       else {
/*  335 */         pstmt.setString(1, getID());
/*      */       }
/*  337 */       rs = pstmt.executeQuery();
/*  338 */       int i = 0;
/*  339 */       if (rs.next())
/*      */       {
/*  341 */         i++;
/*  342 */         if (!setSchema(rs, i))
/*      */         {
/*  345 */           CError tError = new CError();
/*  346 */           tError.moduleName = "MHelpDB";
/*  347 */           tError.functionName = "getInfo";
/*  348 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  349 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  351 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  354 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  358 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  362 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  366 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  369 */       if (i == 0)
/*      */       {
/*  371 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  375 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  379 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  385 */       CError tError = new CError();
/*  386 */       tError.moduleName = "MHelpDB";
/*  387 */       tError.functionName = "getInfo";
/*  388 */       tError.errorMessage = e.toString();
/*  389 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  391 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  394 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  398 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  402 */       return false;
/*      */     }
/*      */ 
/*  405 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  409 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  414 */     return true;
/*      */   }
/*      */ 
/*      */   public MHelpSet query()
/*      */   {
/*  419 */     Statement stmt = null;
/*  420 */     ResultSet rs = null;
/*  421 */     MHelpSet aMHelpSet = new MHelpSet();
/*      */ 
/*  423 */     if (!this.mflag) {
/*  424 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  429 */       stmt = this.con.createStatement(1003, 1007);
/*  430 */       SQLString sqlObj = new SQLString("MHelp");
/*  431 */       MHelpSchema aSchema = getSchema();
/*  432 */       sqlObj.setSQL(5, aSchema);
/*  433 */       String sql = sqlObj.getSQL();
/*      */ 
/*  435 */       rs = stmt.executeQuery(sql);
/*  436 */       int i = 0;
/*  437 */       while (rs.next())
/*      */       {
/*  439 */         i++;
/*  440 */         MHelpSchema s1 = new MHelpSchema();
/*  441 */         s1.setSchema(rs, i);
/*  442 */         aMHelpSet.add(s1);
/*      */       }try {
/*  444 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  450 */       CError tError = new CError();
/*  451 */       tError.moduleName = "MHelpDB";
/*  452 */       tError.functionName = "query";
/*  453 */       tError.errorMessage = e.toString();
/*  454 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  456 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  459 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  463 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  469 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  473 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  478 */     return aMHelpSet;
/*      */   }
/*      */ 
/*      */   public MHelpSet executeQuery(String sql)
/*      */   {
/*  483 */     Statement stmt = null;
/*  484 */     ResultSet rs = null;
/*  485 */     MHelpSet aMHelpSet = new MHelpSet();
/*      */ 
/*  487 */     if (!this.mflag) {
/*  488 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  493 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  495 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  496 */       int i = 0;
/*  497 */       while (rs.next())
/*      */       {
/*  499 */         i++;
/*  500 */         MHelpSchema s1 = new MHelpSchema();
/*  501 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  504 */           CError tError = new CError();
/*  505 */           tError.moduleName = "MHelpDB";
/*  506 */           tError.functionName = "executeQuery";
/*  507 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  508 */           this.mErrors.addOneError(tError);
/*      */         }
/*  510 */         aMHelpSet.add(s1);
/*      */       }try {
/*  512 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  518 */       CError tError = new CError();
/*  519 */       tError.moduleName = "MHelpDB";
/*  520 */       tError.functionName = "executeQuery";
/*  521 */       tError.errorMessage = e.toString();
/*  522 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  524 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  527 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  531 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  537 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  541 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  546 */     return aMHelpSet;
/*      */   }
/*      */ 
/*      */   public MHelpSet query(int nStart, int nCount)
/*      */   {
/*  551 */     Statement stmt = null;
/*  552 */     ResultSet rs = null;
/*  553 */     MHelpSet aMHelpSet = new MHelpSet();
/*      */ 
/*  555 */     if (!this.mflag) {
/*  556 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  561 */       stmt = this.con.createStatement(1003, 1007);
/*  562 */       SQLString sqlObj = new SQLString("MHelp");
/*  563 */       MHelpSchema aSchema = getSchema();
/*  564 */       sqlObj.setSQL(5, aSchema);
/*  565 */       String sql = sqlObj.getSQL();
/*      */ 
/*  567 */       rs = stmt.executeQuery(sql);
/*  568 */       int i = 0;
/*  569 */       while (rs.next())
/*      */       {
/*  571 */         i++;
/*      */ 
/*  573 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  577 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  581 */         MHelpSchema s1 = new MHelpSchema();
/*  582 */         s1.setSchema(rs, i);
/*  583 */         aMHelpSet.add(s1);
/*      */       }try {
/*  585 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  591 */       CError tError = new CError();
/*  592 */       tError.moduleName = "MHelpDB";
/*  593 */       tError.functionName = "query";
/*  594 */       tError.errorMessage = e.toString();
/*  595 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  597 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  600 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  604 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  610 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  614 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  619 */     return aMHelpSet;
/*      */   }
/*      */ 
/*      */   public MHelpSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  624 */     Statement stmt = null;
/*  625 */     ResultSet rs = null;
/*  626 */     MHelpSet aMHelpSet = new MHelpSet();
/*      */ 
/*  628 */     if (!this.mflag) {
/*  629 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  634 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  636 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  637 */       int i = 0;
/*  638 */       while (rs.next())
/*      */       {
/*  640 */         i++;
/*      */ 
/*  642 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  646 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  650 */         MHelpSchema s1 = new MHelpSchema();
/*  651 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  654 */           CError tError = new CError();
/*  655 */           tError.moduleName = "MHelpDB";
/*  656 */           tError.functionName = "executeQuery";
/*  657 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  658 */           this.mErrors.addOneError(tError);
/*      */         }
/*  660 */         aMHelpSet.add(s1);
/*      */       }try {
/*  662 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  668 */       CError tError = new CError();
/*  669 */       tError.moduleName = "MHelpDB";
/*  670 */       tError.functionName = "executeQuery";
/*  671 */       tError.errorMessage = e.toString();
/*  672 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  674 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  677 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  681 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  687 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  691 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  696 */     return aMHelpSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  701 */     Statement stmt = null;
/*      */ 
/*  703 */     if (!this.mflag) {
/*  704 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  709 */       stmt = this.con.createStatement(1003, 1007);
/*  710 */       SQLString sqlObj = new SQLString("MHelp");
/*  711 */       MHelpSchema aSchema = getSchema();
/*  712 */       sqlObj.setSQL(2, aSchema);
/*  713 */       String sql = "update MHelp " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  715 */       int operCount = stmt.executeUpdate(sql);
/*  716 */       if (operCount == 0)
/*      */       {
/*  719 */         CError tError = new CError();
/*  720 */         tError.moduleName = "MHelpDB";
/*  721 */         tError.functionName = "update";
/*  722 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  723 */         this.mErrors.addOneError(tError);
/*      */ 
/*  725 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  729 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  733 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  739 */       CError tError = new CError();
/*  740 */       tError.moduleName = "MHelpDB";
/*  741 */       tError.functionName = "update";
/*  742 */       tError.errorMessage = e.toString();
/*  743 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  745 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  747 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  751 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  755 */       return false;
/*      */     }
/*      */ 
/*  758 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  762 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  767 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  773 */     if (this.mResultSet != null)
/*      */     {
/*  776 */       CError tError = new CError();
/*  777 */       tError.moduleName = "MHelpDB";
/*  778 */       tError.functionName = "prepareData";
/*  779 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  780 */       this.mErrors.addOneError(tError);
/*  781 */       return false;
/*      */     }
/*      */ 
/*  784 */     if (!this.mflag)
/*      */     {
/*  786 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  790 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  791 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  796 */       CError tError = new CError();
/*  797 */       tError.moduleName = "MHelpDB";
/*  798 */       tError.functionName = "prepareData";
/*  799 */       tError.errorMessage = e.toString();
/*  800 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  803 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  809 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  813 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  817 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  822 */       return false;
/*      */     }
/*      */ 
/*  825 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  829 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  834 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  840 */     boolean flag = true;
/*  841 */     if (this.mResultSet == null)
/*      */     {
/*  843 */       CError tError = new CError();
/*  844 */       tError.moduleName = "MHelpDB";
/*  845 */       tError.functionName = "hasMoreData";
/*  846 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  847 */       this.mErrors.addOneError(tError);
/*  848 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  852 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  856 */       CError tError = new CError();
/*  857 */       tError.moduleName = "MHelpDB";
/*  858 */       tError.functionName = "hasMoreData";
/*  859 */       tError.errorMessage = ex.toString();
/*  860 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  863 */         this.mResultSet.close();
/*  864 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  870 */         this.mStatement.close();
/*  871 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  875 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  879 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  884 */       return false;
/*      */     }
/*  886 */     return flag;
/*      */   }
/*      */ 
/*      */   public MHelpSet getData()
/*      */   {
/*  891 */     int tCount = 0;
/*  892 */     MHelpSet tMHelpSet = new MHelpSet();
/*  893 */     MHelpSchema tMHelpSchema = null;
/*  894 */     if (this.mResultSet == null)
/*      */     {
/*  896 */       CError tError = new CError();
/*  897 */       tError.moduleName = "MHelpDB";
/*  898 */       tError.functionName = "getData";
/*  899 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  900 */       this.mErrors.addOneError(tError);
/*  901 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  905 */       tCount = 1;
/*  906 */       tMHelpSchema = new MHelpSchema();
/*  907 */       tMHelpSchema.setSchema(this.mResultSet, 1);
/*  908 */       tMHelpSet.add(tMHelpSchema);
/*      */ 
/*  910 */       while (tCount++ < 5000)
/*      */       {
/*  912 */         if (!this.mResultSet.next())
/*      */           continue;
/*  914 */         tMHelpSchema = new MHelpSchema();
/*  915 */         tMHelpSchema.setSchema(this.mResultSet, 1);
/*  916 */         tMHelpSet.add(tMHelpSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  922 */       CError tError = new CError();
/*  923 */       tError.moduleName = "MHelpDB";
/*  924 */       tError.functionName = "getData";
/*  925 */       tError.errorMessage = ex.toString();
/*  926 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  929 */         this.mResultSet.close();
/*  930 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  936 */         this.mStatement.close();
/*  937 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  941 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  945 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  950 */       return null;
/*      */     }
/*  952 */     return tMHelpSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  957 */     boolean flag = true;
/*      */     try
/*      */     {
/*  960 */       if (this.mResultSet == null)
/*      */       {
/*  962 */         CError tError = new CError();
/*  963 */         tError.moduleName = "MHelpDB";
/*  964 */         tError.functionName = "closeData";
/*  965 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  966 */         this.mErrors.addOneError(tError);
/*  967 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  971 */         this.mResultSet.close();
/*  972 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "MHelpDB";
/*  979 */       tError.functionName = "closeData";
/*  980 */       tError.errorMessage = ex2.toString();
/*  981 */       this.mErrors.addOneError(tError);
/*  982 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/*  986 */       if (this.mStatement == null)
/*      */       {
/*  988 */         CError tError = new CError();
/*  989 */         tError.moduleName = "MHelpDB";
/*  990 */         tError.functionName = "closeData";
/*  991 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/*  992 */         this.mErrors.addOneError(tError);
/*  993 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  997 */         this.mStatement.close();
/*  998 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1003 */       CError tError = new CError();
/* 1004 */       tError.moduleName = "MHelpDB";
/* 1005 */       tError.functionName = "closeData";
/* 1006 */       tError.errorMessage = ex3.toString();
/* 1007 */       this.mErrors.addOneError(tError);
/* 1008 */       flag = false;
/*      */     }
/* 1010 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MHelpDB
 * JD-Core Version:    0.6.0
 */