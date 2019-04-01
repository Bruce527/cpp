/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MNewsContentSchema;
/*      */ import com.sinosoft.map.lis.vschema.MNewsContentSet;
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
/*      */ public class MNewsContentDB extends MNewsContentSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   25 */   private ResultSet mResultSet = null;
/*   26 */   private Statement mStatement = null;
/*      */ 
/*      */   public MNewsContentDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MNewsContent");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MNewsContentDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MNewsContent");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MNewsContentSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MNewsContentDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MNewsContentSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MNewsContentDB";
/*   74 */       tError.functionName = "getCount";
/*   75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   76 */       this.mErrors.addOneError(tError);
/*      */ 
/*   78 */       return -1;
/*      */     }
/*      */ 
/*   81 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   86 */     PreparedStatement pstmt = null;
/*      */ 
/*   88 */     if (!this.mflag) {
/*   89 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsContent WHERE  ContentID = ?");
/*   95 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getContentID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MNewsContentDB";
/*  107 */       tError.functionName = "delete()";
/*  108 */       tError.errorMessage = ex.toString();
/*  109 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  112 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  115 */       if (!this.mflag)
/*      */         try {
/*  117 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  121 */       return false;
/*      */     }
/*      */ 
/*  124 */     if (!this.mflag)
/*      */       try {
/*  126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  135 */     PreparedStatement pstmt = null;
/*      */ 
/*  137 */     if (!this.mflag) {
/*  138 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MNewsContent SET  ContentID = ? , NewsID = ? , Content = ? , ContOrder = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContentID = ?");
/*  144 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getContentID());
/*      */       }
/*  149 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getNewsID());
/*      */       }
/*  154 */       if ((getContent() == null) || (getContent().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getContent());
/*      */       }
/*  159 */       pstmt.setInt(4, getContOrder());
/*  160 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  161 */         pstmt.setNull(5, 12);
/*      */       else {
/*  163 */         pstmt.setString(5, getOperator());
/*      */       }
/*  165 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  166 */         pstmt.setNull(6, 91);
/*      */       else {
/*  168 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  170 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  171 */         pstmt.setNull(7, 12);
/*      */       else {
/*  173 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  175 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  176 */         pstmt.setNull(8, 91);
/*      */       else {
/*  178 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  180 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  181 */         pstmt.setNull(9, 12);
/*      */       else {
/*  183 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*      */ 
/*  186 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getContentID());
/*      */       }
/*  191 */       pstmt.executeUpdate();
/*  192 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  195 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  196 */       CError tError = new CError();
/*  197 */       tError.moduleName = "MNewsContentDB";
/*  198 */       tError.functionName = "update()";
/*  199 */       tError.errorMessage = ex.toString();
/*  200 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  203 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  206 */       if (!this.mflag)
/*      */         try {
/*  208 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  212 */       return false;
/*      */     }
/*      */ 
/*  215 */     if (!this.mflag)
/*      */       try {
/*  217 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  221 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  226 */     PreparedStatement pstmt = null;
/*      */ 
/*  228 */     if (!this.mflag) {
/*  229 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  234 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsContent VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  235 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  236 */         pstmt.setNull(1, 12);
/*      */       else {
/*  238 */         pstmt.setString(1, getContentID());
/*      */       }
/*  240 */       if ((getNewsID() == null) || (getNewsID().equals("null")))
/*  241 */         pstmt.setNull(2, 12);
/*      */       else {
/*  243 */         pstmt.setString(2, getNewsID());
/*      */       }
/*  245 */       if ((getContent() == null) || (getContent().equals("null")))
/*  246 */         pstmt.setNull(3, 12);
/*      */       else {
/*  248 */         pstmt.setString(3, getContent());
/*      */       }
/*  250 */       pstmt.setInt(4, getContOrder());
/*  251 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  252 */         pstmt.setNull(5, 12);
/*      */       else {
/*  254 */         pstmt.setString(5, getOperator());
/*      */       }
/*  256 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  257 */         pstmt.setNull(6, 91);
/*      */       else {
/*  259 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  261 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  262 */         pstmt.setNull(7, 12);
/*      */       else {
/*  264 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  266 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  267 */         pstmt.setNull(8, 91);
/*      */       else {
/*  269 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  271 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  272 */         pstmt.setNull(9, 12);
/*      */       else {
/*  274 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*      */ 
/*  277 */       pstmt.executeUpdate();
/*  278 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  281 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  282 */       CError tError = new CError();
/*  283 */       tError.moduleName = "MNewsContentDB";
/*  284 */       tError.functionName = "insert()";
/*  285 */       tError.errorMessage = ex.toString();
/*  286 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  289 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  292 */       if (!this.mflag)
/*      */         try {
/*  294 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  298 */       return false;
/*      */     }
/*      */ 
/*  301 */     if (!this.mflag)
/*      */       try {
/*  303 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  307 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  312 */     PreparedStatement pstmt = null;
/*  313 */     ResultSet rs = null;
/*      */ 
/*  315 */     if (!this.mflag) {
/*  316 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  321 */       pstmt = this.con.prepareStatement("SELECT * FROM MNewsContent WHERE  ContentID = ?", 
/*  322 */         1003, 1007);
/*  323 */       if ((getContentID() == null) || (getContentID().equals("null")))
/*  324 */         pstmt.setNull(1, 12);
/*      */       else {
/*  326 */         pstmt.setString(1, getContentID());
/*      */       }
/*  328 */       rs = pstmt.executeQuery();
/*  329 */       int i = 0;
/*  330 */       if (rs.next())
/*      */       {
/*  332 */         i++;
/*  333 */         if (!setSchema(rs, i))
/*      */         {
/*  336 */           CError tError = new CError();
/*  337 */           tError.moduleName = "MNewsContentDB";
/*  338 */           tError.functionName = "getInfo";
/*  339 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
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
/*  377 */       tError.moduleName = "MNewsContentDB";
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
/*      */   public MNewsContentSet query()
/*      */   {
/*  410 */     Statement stmt = null;
/*  411 */     ResultSet rs = null;
/*  412 */     MNewsContentSet aMNewsContentSet = new MNewsContentSet();
/*      */ 
/*  414 */     if (!this.mflag) {
/*  415 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  420 */       stmt = this.con.createStatement(1003, 1007);
/*  421 */       SQLString sqlObj = new SQLString("MNewsContent");
/*  422 */       MNewsContentSchema aSchema = getSchema();
/*  423 */       sqlObj.setSQL(5, aSchema);
/*  424 */       String sql = sqlObj.getSQL();
/*      */ 
/*  426 */       rs = stmt.executeQuery(sql);
/*  427 */       int i = 0;
/*  428 */       while (rs.next())
/*      */       {
/*  430 */         i++;
/*  431 */         MNewsContentSchema s1 = new MNewsContentSchema();
/*  432 */         s1.setSchema(rs, i);
/*  433 */         aMNewsContentSet.add(s1);
/*      */       }try {
/*  435 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  441 */       CError tError = new CError();
/*  442 */       tError.moduleName = "MNewsContentDB";
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
/*  469 */     return aMNewsContentSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentSet executeQuery(String sql)
/*      */   {
/*  474 */     Statement stmt = null;
/*  475 */     ResultSet rs = null;
/*  476 */     MNewsContentSet aMNewsContentSet = new MNewsContentSet();
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
/*  491 */         MNewsContentSchema s1 = new MNewsContentSchema();
/*  492 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  495 */           CError tError = new CError();
/*  496 */           tError.moduleName = "MNewsContentDB";
/*  497 */           tError.functionName = "executeQuery";
/*  498 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  499 */           this.mErrors.addOneError(tError);
/*      */         }
/*  501 */         aMNewsContentSet.add(s1);
/*      */       }try {
/*  503 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  509 */       CError tError = new CError();
/*  510 */       tError.moduleName = "MNewsContentDB";
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
/*  537 */     return aMNewsContentSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentSet query(int nStart, int nCount)
/*      */   {
/*  542 */     Statement stmt = null;
/*  543 */     ResultSet rs = null;
/*  544 */     MNewsContentSet aMNewsContentSet = new MNewsContentSet();
/*      */ 
/*  546 */     if (!this.mflag) {
/*  547 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  552 */       stmt = this.con.createStatement(1003, 1007);
/*  553 */       SQLString sqlObj = new SQLString("MNewsContent");
/*  554 */       MNewsContentSchema aSchema = getSchema();
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
/*  572 */         MNewsContentSchema s1 = new MNewsContentSchema();
/*  573 */         s1.setSchema(rs, i);
/*  574 */         aMNewsContentSet.add(s1);
/*      */       }try {
/*  576 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  582 */       CError tError = new CError();
/*  583 */       tError.moduleName = "MNewsContentDB";
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
/*  610 */     return aMNewsContentSet;
/*      */   }
/*      */ 
/*      */   public MNewsContentSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  615 */     Statement stmt = null;
/*  616 */     ResultSet rs = null;
/*  617 */     MNewsContentSet aMNewsContentSet = new MNewsContentSet();
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
/*  641 */         MNewsContentSchema s1 = new MNewsContentSchema();
/*  642 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  645 */           CError tError = new CError();
/*  646 */           tError.moduleName = "MNewsContentDB";
/*  647 */           tError.functionName = "executeQuery";
/*  648 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  649 */           this.mErrors.addOneError(tError);
/*      */         }
/*  651 */         aMNewsContentSet.add(s1);
/*      */       }try {
/*  653 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  659 */       CError tError = new CError();
/*  660 */       tError.moduleName = "MNewsContentDB";
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
/*  687 */     return aMNewsContentSet;
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
/*  701 */       SQLString sqlObj = new SQLString("MNewsContent");
/*  702 */       MNewsContentSchema aSchema = getSchema();
/*  703 */       sqlObj.setSQL(2, aSchema);
/*  704 */       String sql = "update MNewsContent " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  706 */       int operCount = stmt.executeUpdate(sql);
/*  707 */       if (operCount == 0)
/*      */       {
/*  710 */         CError tError = new CError();
/*  711 */         tError.moduleName = "MNewsContentDB";
/*  712 */         tError.functionName = "update";
/*  713 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
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
/*  731 */       tError.moduleName = "MNewsContentDB";
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
/*  768 */       tError.moduleName = "MNewsContentDB";
/*  769 */       tError.functionName = "prepareData";
/*  770 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
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
/*  788 */       tError.moduleName = "MNewsContentDB";
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
/*  835 */       tError.moduleName = "MNewsContentDB";
/*  836 */       tError.functionName = "hasMoreData";
/*  837 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
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
/*  848 */       tError.moduleName = "MNewsContentDB";
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
/*      */   public MNewsContentSet getData()
/*      */   {
/*  882 */     int tCount = 0;
/*  883 */     MNewsContentSet tMNewsContentSet = new MNewsContentSet();
/*  884 */     MNewsContentSchema tMNewsContentSchema = null;
/*  885 */     if (this.mResultSet == null)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "MNewsContentDB";
/*  889 */       tError.functionName = "getData";
/*  890 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  891 */       this.mErrors.addOneError(tError);
/*  892 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  896 */       tCount = 1;
/*  897 */       tMNewsContentSchema = new MNewsContentSchema();
/*  898 */       tMNewsContentSchema.setSchema(this.mResultSet, 1);
/*  899 */       tMNewsContentSet.add(tMNewsContentSchema);
/*      */ 
/*  901 */       while (tCount++ < 5000)
/*      */       {
/*  903 */         if (!this.mResultSet.next())
/*      */           continue;
/*  905 */         tMNewsContentSchema = new MNewsContentSchema();
/*  906 */         tMNewsContentSchema.setSchema(this.mResultSet, 1);
/*  907 */         tMNewsContentSet.add(tMNewsContentSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  913 */       CError tError = new CError();
/*  914 */       tError.moduleName = "MNewsContentDB";
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
/*  943 */     return tMNewsContentSet;
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
/*  954 */         tError.moduleName = "MNewsContentDB";
/*  955 */         tError.functionName = "closeData";
/*  956 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
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
/*  969 */       tError.moduleName = "MNewsContentDB";
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
/*  980 */         tError.moduleName = "MNewsContentDB";
/*  981 */         tError.functionName = "closeData";
/*  982 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
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
/*  995 */       tError.moduleName = "MNewsContentDB";
/*  996 */       tError.functionName = "closeData";
/*  997 */       tError.errorMessage = ex3.toString();
/*  998 */       this.mErrors.addOneError(tError);
/*  999 */       flag = false;
/*      */     }
/* 1001 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MNewsContentDB
 * JD-Core Version:    0.6.0
 */