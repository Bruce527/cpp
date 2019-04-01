/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredRelatedSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredRelatedSet;
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
/*      */ public class LNPInsuredRelatedDB extends LNPInsuredRelatedSchema
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
/*      */   public LNPInsuredRelatedDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPInsuredRelated");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPInsuredRelated");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPInsuredRelatedSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPInsuredRelatedDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPInsuredRelatedSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPInsuredRelatedDB";
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
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsuredRelated WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
/*   97 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  102 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getCustomerId());
/*      */       }
/*  107 */       if ((getMainCustomerNo() == null) || (getMainCustomerNo().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getMainCustomerNo());
/*      */       }
/*  112 */       pstmt.executeUpdate();
/*  113 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  116 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  117 */       CError tError = new CError();
/*  118 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  119 */       tError.functionName = "delete()";
/*  120 */       tError.errorMessage = ex.toString();
/*  121 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  124 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  127 */       if (!this.mflag)
/*      */         try {
/*  129 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  133 */       return false;
/*      */     }
/*      */ 
/*  136 */     if (!this.mflag)
/*      */       try {
/*  138 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  142 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  147 */     PreparedStatement pstmt = null;
/*      */ 
/*  149 */     if (!this.mflag) {
/*  150 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  155 */       pstmt = this.con.prepareStatement("UPDATE LNPInsuredRelated SET  PolNo = ? , CustomerId = ? , CustomerNo = ? , MainCustomerNo = ? , RelationToInsured = ? , AddressNo = ? , Name = ? , Sex = ? , Birthday = ? , IDType = ? , IDNo = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
/*  156 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  157 */         pstmt.setNull(1, 12);
/*      */       else {
/*  159 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  161 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  162 */         pstmt.setNull(2, 12);
/*      */       else {
/*  164 */         pstmt.setString(2, getCustomerId());
/*      */       }
/*  166 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  167 */         pstmt.setNull(3, 12);
/*      */       else {
/*  169 */         pstmt.setString(3, getCustomerNo());
/*      */       }
/*  171 */       if ((getMainCustomerNo() == null) || (getMainCustomerNo().equals("null")))
/*  172 */         pstmt.setNull(4, 12);
/*      */       else {
/*  174 */         pstmt.setString(4, getMainCustomerNo());
/*      */       }
/*  176 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  177 */         pstmt.setNull(5, 12);
/*      */       else {
/*  179 */         pstmt.setString(5, getRelationToInsured());
/*      */       }
/*  181 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  182 */         pstmt.setNull(6, 12);
/*      */       else {
/*  184 */         pstmt.setString(6, getAddressNo());
/*      */       }
/*  186 */       if ((getName() == null) || (getName().equals("null")))
/*  187 */         pstmt.setNull(7, 12);
/*      */       else {
/*  189 */         pstmt.setString(7, getName());
/*      */       }
/*  191 */       if ((getSex() == null) || (getSex().equals("null")))
/*  192 */         pstmt.setNull(8, 12);
/*      */       else {
/*  194 */         pstmt.setString(8, getSex());
/*      */       }
/*  196 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  197 */         pstmt.setNull(9, 91);
/*      */       else {
/*  199 */         pstmt.setDate(9, Date.valueOf(getBirthday()));
/*      */       }
/*  201 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  202 */         pstmt.setNull(10, 12);
/*      */       else {
/*  204 */         pstmt.setString(10, getIDType());
/*      */       }
/*  206 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  207 */         pstmt.setNull(11, 12);
/*      */       else {
/*  209 */         pstmt.setString(11, getIDNo());
/*      */       }
/*  211 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  212 */         pstmt.setNull(12, 12);
/*      */       else {
/*  214 */         pstmt.setString(12, getOperator());
/*      */       }
/*  216 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  217 */         pstmt.setNull(13, 91);
/*      */       else {
/*  219 */         pstmt.setDate(13, Date.valueOf(getMakeDate()));
/*      */       }
/*  221 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  222 */         pstmt.setNull(14, 12);
/*      */       else {
/*  224 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  226 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  227 */         pstmt.setNull(15, 91);
/*      */       else {
/*  229 */         pstmt.setDate(15, Date.valueOf(getModifyDate()));
/*      */       }
/*  231 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  232 */         pstmt.setNull(16, 12);
/*      */       else {
/*  234 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*      */ 
/*  237 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  238 */         pstmt.setNull(17, 12);
/*      */       else {
/*  240 */         pstmt.setString(17, getPolNo());
/*      */       }
/*  242 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  243 */         pstmt.setNull(18, 12);
/*      */       else {
/*  245 */         pstmt.setString(18, getCustomerId());
/*      */       }
/*  247 */       if ((getMainCustomerNo() == null) || (getMainCustomerNo().equals("null")))
/*  248 */         pstmt.setNull(19, 12);
/*      */       else {
/*  250 */         pstmt.setString(19, getMainCustomerNo());
/*      */       }
/*  252 */       pstmt.executeUpdate();
/*  253 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  256 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  257 */       CError tError = new CError();
/*  258 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  259 */       tError.functionName = "update()";
/*  260 */       tError.errorMessage = ex.toString();
/*  261 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  264 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  267 */       if (!this.mflag)
/*      */         try {
/*  269 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  273 */       return false;
/*      */     }
/*      */ 
/*  276 */     if (!this.mflag)
/*      */       try {
/*  278 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  282 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  287 */     PreparedStatement pstmt = null;
/*      */ 
/*  289 */     if (!this.mflag) {
/*  290 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  295 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsuredRelated VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  296 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  297 */         pstmt.setNull(1, 12);
/*      */       else {
/*  299 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  301 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  302 */         pstmt.setNull(2, 12);
/*      */       else {
/*  304 */         pstmt.setString(2, getCustomerId());
/*      */       }
/*  306 */       if ((getCustomerNo() == null) || (getCustomerNo().equals("null")))
/*  307 */         pstmt.setNull(3, 12);
/*      */       else {
/*  309 */         pstmt.setString(3, getCustomerNo());
/*      */       }
/*  311 */       if ((getMainCustomerNo() == null) || (getMainCustomerNo().equals("null")))
/*  312 */         pstmt.setNull(4, 12);
/*      */       else {
/*  314 */         pstmt.setString(4, getMainCustomerNo());
/*      */       }
/*  316 */       if ((getRelationToInsured() == null) || (getRelationToInsured().equals("null")))
/*  317 */         pstmt.setNull(5, 12);
/*      */       else {
/*  319 */         pstmt.setString(5, getRelationToInsured());
/*      */       }
/*  321 */       if ((getAddressNo() == null) || (getAddressNo().equals("null")))
/*  322 */         pstmt.setNull(6, 12);
/*      */       else {
/*  324 */         pstmt.setString(6, getAddressNo());
/*      */       }
/*  326 */       if ((getName() == null) || (getName().equals("null")))
/*  327 */         pstmt.setNull(7, 12);
/*      */       else {
/*  329 */         pstmt.setString(7, getName());
/*      */       }
/*  331 */       if ((getSex() == null) || (getSex().equals("null")))
/*  332 */         pstmt.setNull(8, 12);
/*      */       else {
/*  334 */         pstmt.setString(8, getSex());
/*      */       }
/*  336 */       if ((getBirthday() == null) || (getBirthday().equals("null")))
/*  337 */         pstmt.setNull(9, 91);
/*      */       else {
/*  339 */         pstmt.setDate(9, Date.valueOf(getBirthday()));
/*      */       }
/*  341 */       if ((getIDType() == null) || (getIDType().equals("null")))
/*  342 */         pstmt.setNull(10, 12);
/*      */       else {
/*  344 */         pstmt.setString(10, getIDType());
/*      */       }
/*  346 */       if ((getIDNo() == null) || (getIDNo().equals("null")))
/*  347 */         pstmt.setNull(11, 12);
/*      */       else {
/*  349 */         pstmt.setString(11, getIDNo());
/*      */       }
/*  351 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  352 */         pstmt.setNull(12, 12);
/*      */       else {
/*  354 */         pstmt.setString(12, getOperator());
/*      */       }
/*  356 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  357 */         pstmt.setNull(13, 91);
/*      */       else {
/*  359 */         pstmt.setDate(13, Date.valueOf(getMakeDate()));
/*      */       }
/*  361 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  362 */         pstmt.setNull(14, 12);
/*      */       else {
/*  364 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  366 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  367 */         pstmt.setNull(15, 91);
/*      */       else {
/*  369 */         pstmt.setDate(15, Date.valueOf(getModifyDate()));
/*      */       }
/*  371 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  372 */         pstmt.setNull(16, 12);
/*      */       else {
/*  374 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*      */ 
/*  377 */       pstmt.executeUpdate();
/*  378 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  381 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  382 */       CError tError = new CError();
/*  383 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  384 */       tError.functionName = "insert()";
/*  385 */       tError.errorMessage = ex.toString();
/*  386 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  389 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  392 */       if (!this.mflag)
/*      */         try {
/*  394 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  398 */       return false;
/*      */     }
/*      */ 
/*  401 */     if (!this.mflag)
/*      */       try {
/*  403 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  407 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  412 */     PreparedStatement pstmt = null;
/*  413 */     ResultSet rs = null;
/*      */ 
/*  415 */     if (!this.mflag) {
/*  416 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  421 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPInsuredRelated WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?", 
/*  422 */         1003, 1007);
/*  423 */       if ((getPolNo() == null) || (getPolNo().equals("null")))
/*  424 */         pstmt.setNull(1, 12);
/*      */       else {
/*  426 */         pstmt.setString(1, getPolNo());
/*      */       }
/*  428 */       if ((getCustomerId() == null) || (getCustomerId().equals("null")))
/*  429 */         pstmt.setNull(2, 12);
/*      */       else {
/*  431 */         pstmt.setString(2, getCustomerId());
/*      */       }
/*  433 */       if ((getMainCustomerNo() == null) || (getMainCustomerNo().equals("null")))
/*  434 */         pstmt.setNull(3, 12);
/*      */       else {
/*  436 */         pstmt.setString(3, getMainCustomerNo());
/*      */       }
/*  438 */       rs = pstmt.executeQuery();
/*  439 */       int i = 0;
/*  440 */       if (rs.next())
/*      */       {
/*  442 */         i++;
/*  443 */         if (!setSchema(rs, i))
/*      */         {
/*  446 */           CError tError = new CError();
/*  447 */           tError.moduleName = "LNPInsuredRelatedDB";
/*  448 */           tError.functionName = "getInfo";
/*  449 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/*  450 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  452 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  455 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  459 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  463 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  467 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  470 */       if (i == 0)
/*      */       {
/*  472 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  476 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  480 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  486 */       CError tError = new CError();
/*  487 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  488 */       tError.functionName = "getInfo";
/*  489 */       tError.errorMessage = e.toString();
/*  490 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  492 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  495 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  499 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  503 */       return false;
/*      */     }
/*      */ 
/*  506 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  510 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  515 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSet query()
/*      */   {
/*  520 */     Statement stmt = null;
/*  521 */     ResultSet rs = null;
/*  522 */     LNPInsuredRelatedSet aLNPInsuredRelatedSet = new LNPInsuredRelatedSet();
/*      */ 
/*  524 */     if (!this.mflag) {
/*  525 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  530 */       stmt = this.con.createStatement(1003, 1007);
/*  531 */       SQLString sqlObj = new SQLString("LNPInsuredRelated");
/*  532 */       LNPInsuredRelatedSchema aSchema = getSchema();
/*  533 */       sqlObj.setSQL(5, aSchema);
/*  534 */       String sql = sqlObj.getSQL();
/*      */ 
/*  536 */       rs = stmt.executeQuery(sql);
/*  537 */       int i = 0;
/*  538 */       while (rs.next())
/*      */       {
/*  540 */         i++;
/*  541 */         LNPInsuredRelatedSchema s1 = new LNPInsuredRelatedSchema();
/*  542 */         s1.setSchema(rs, i);
/*  543 */         aLNPInsuredRelatedSet.add(s1);
/*      */       }try {
/*  545 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  551 */       CError tError = new CError();
/*  552 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  553 */       tError.functionName = "query";
/*  554 */       tError.errorMessage = e.toString();
/*  555 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  557 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  560 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  564 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  570 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  574 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  579 */     return aLNPInsuredRelatedSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSet executeQuery(String sql)
/*      */   {
/*  584 */     Statement stmt = null;
/*  585 */     ResultSet rs = null;
/*  586 */     LNPInsuredRelatedSet aLNPInsuredRelatedSet = new LNPInsuredRelatedSet();
/*      */ 
/*  588 */     if (!this.mflag) {
/*  589 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  594 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  596 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  597 */       int i = 0;
/*  598 */       while (rs.next())
/*      */       {
/*  600 */         i++;
/*  601 */         LNPInsuredRelatedSchema s1 = new LNPInsuredRelatedSchema();
/*  602 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  605 */           CError tError = new CError();
/*  606 */           tError.moduleName = "LNPInsuredRelatedDB";
/*  607 */           tError.functionName = "executeQuery";
/*  608 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  609 */           this.mErrors.addOneError(tError);
/*      */         }
/*  611 */         aLNPInsuredRelatedSet.add(s1);
/*      */       }try {
/*  613 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  619 */       CError tError = new CError();
/*  620 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  621 */       tError.functionName = "executeQuery";
/*  622 */       tError.errorMessage = e.toString();
/*  623 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  625 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  628 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  632 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  638 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  642 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  647 */     return aLNPInsuredRelatedSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSet query(int nStart, int nCount)
/*      */   {
/*  652 */     Statement stmt = null;
/*  653 */     ResultSet rs = null;
/*  654 */     LNPInsuredRelatedSet aLNPInsuredRelatedSet = new LNPInsuredRelatedSet();
/*      */ 
/*  656 */     if (!this.mflag) {
/*  657 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  662 */       stmt = this.con.createStatement(1003, 1007);
/*  663 */       SQLString sqlObj = new SQLString("LNPInsuredRelated");
/*  664 */       LNPInsuredRelatedSchema aSchema = getSchema();
/*  665 */       sqlObj.setSQL(5, aSchema);
/*  666 */       String sql = sqlObj.getSQL();
/*      */ 
/*  668 */       rs = stmt.executeQuery(sql);
/*  669 */       int i = 0;
/*  670 */       while (rs.next())
/*      */       {
/*  672 */         i++;
/*      */ 
/*  674 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  678 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  682 */         LNPInsuredRelatedSchema s1 = new LNPInsuredRelatedSchema();
/*  683 */         s1.setSchema(rs, i);
/*  684 */         aLNPInsuredRelatedSet.add(s1);
/*      */       }try {
/*  686 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  692 */       CError tError = new CError();
/*  693 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  694 */       tError.functionName = "query";
/*  695 */       tError.errorMessage = e.toString();
/*  696 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  698 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  701 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  705 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  711 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  715 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  720 */     return aLNPInsuredRelatedSet;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  725 */     Statement stmt = null;
/*  726 */     ResultSet rs = null;
/*  727 */     LNPInsuredRelatedSet aLNPInsuredRelatedSet = new LNPInsuredRelatedSet();
/*      */ 
/*  729 */     if (!this.mflag) {
/*  730 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  735 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  737 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  738 */       int i = 0;
/*  739 */       while (rs.next())
/*      */       {
/*  741 */         i++;
/*      */ 
/*  743 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  747 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  751 */         LNPInsuredRelatedSchema s1 = new LNPInsuredRelatedSchema();
/*  752 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  755 */           CError tError = new CError();
/*  756 */           tError.moduleName = "LNPInsuredRelatedDB";
/*  757 */           tError.functionName = "executeQuery";
/*  758 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  759 */           this.mErrors.addOneError(tError);
/*      */         }
/*  761 */         aLNPInsuredRelatedSet.add(s1);
/*      */       }try {
/*  763 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  769 */       CError tError = new CError();
/*  770 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  771 */       tError.functionName = "executeQuery";
/*  772 */       tError.errorMessage = e.toString();
/*  773 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  775 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  778 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  782 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  788 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  792 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  797 */     return aLNPInsuredRelatedSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  802 */     Statement stmt = null;
/*      */ 
/*  804 */     if (!this.mflag) {
/*  805 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  810 */       stmt = this.con.createStatement(1003, 1007);
/*  811 */       SQLString sqlObj = new SQLString("LNPInsuredRelated");
/*  812 */       LNPInsuredRelatedSchema aSchema = getSchema();
/*  813 */       sqlObj.setSQL(2, aSchema);
/*  814 */       String sql = "update LNPInsuredRelated " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  816 */       int operCount = stmt.executeUpdate(sql);
/*  817 */       if (operCount == 0)
/*      */       {
/*  820 */         CError tError = new CError();
/*  821 */         tError.moduleName = "LNPInsuredRelatedDB";
/*  822 */         tError.functionName = "update";
/*  823 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/*  824 */         this.mErrors.addOneError(tError);
/*      */ 
/*  826 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  830 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  834 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  840 */       CError tError = new CError();
/*  841 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  842 */       tError.functionName = "update";
/*  843 */       tError.errorMessage = e.toString();
/*  844 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  846 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  848 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  852 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  856 */       return false;
/*      */     }
/*      */ 
/*  859 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  863 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  868 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  874 */     if (this.mResultSet != null)
/*      */     {
/*  877 */       CError tError = new CError();
/*  878 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  879 */       tError.functionName = "prepareData";
/*  880 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/*  881 */       this.mErrors.addOneError(tError);
/*  882 */       return false;
/*      */     }
/*      */ 
/*  885 */     if (!this.mflag)
/*      */     {
/*  887 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  891 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  892 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  897 */       CError tError = new CError();
/*  898 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  899 */       tError.functionName = "prepareData";
/*  900 */       tError.errorMessage = e.toString();
/*  901 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  904 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  910 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  914 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  918 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  923 */       return false;
/*      */     }
/*      */ 
/*  926 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  930 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  935 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  941 */     boolean flag = true;
/*  942 */     if (this.mResultSet == null)
/*      */     {
/*  944 */       CError tError = new CError();
/*  945 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  946 */       tError.functionName = "hasMoreData";
/*  947 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  948 */       this.mErrors.addOneError(tError);
/*  949 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  953 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  957 */       CError tError = new CError();
/*  958 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  959 */       tError.functionName = "hasMoreData";
/*  960 */       tError.errorMessage = ex.toString();
/*  961 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  964 */         this.mResultSet.close();
/*  965 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  971 */         this.mStatement.close();
/*  972 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  976 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  980 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  985 */       return false;
/*      */     }
/*  987 */     return flag;
/*      */   }
/*      */ 
/*      */   public LNPInsuredRelatedSet getData()
/*      */   {
/*  992 */     int tCount = 0;
/*  993 */     LNPInsuredRelatedSet tLNPInsuredRelatedSet = new LNPInsuredRelatedSet();
/*  994 */     LNPInsuredRelatedSchema tLNPInsuredRelatedSchema = null;
/*  995 */     if (this.mResultSet == null)
/*      */     {
/*  997 */       CError tError = new CError();
/*  998 */       tError.moduleName = "LNPInsuredRelatedDB";
/*  999 */       tError.functionName = "getData";
/* 1000 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 1001 */       this.mErrors.addOneError(tError);
/* 1002 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1006 */       tCount = 1;
/* 1007 */       tLNPInsuredRelatedSchema = new LNPInsuredRelatedSchema();
/* 1008 */       tLNPInsuredRelatedSchema.setSchema(this.mResultSet, 1);
/* 1009 */       tLNPInsuredRelatedSet.add(tLNPInsuredRelatedSchema);
/*      */ 
/* 1011 */       while (tCount++ < 5000)
/*      */       {
/* 1013 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1015 */         tLNPInsuredRelatedSchema = new LNPInsuredRelatedSchema();
/* 1016 */         tLNPInsuredRelatedSchema.setSchema(this.mResultSet, 1);
/* 1017 */         tLNPInsuredRelatedSet.add(tLNPInsuredRelatedSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1023 */       CError tError = new CError();
/* 1024 */       tError.moduleName = "LNPInsuredRelatedDB";
/* 1025 */       tError.functionName = "getData";
/* 1026 */       tError.errorMessage = ex.toString();
/* 1027 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1030 */         this.mResultSet.close();
/* 1031 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1037 */         this.mStatement.close();
/* 1038 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1042 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1046 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1051 */       return null;
/*      */     }
/* 1053 */     return tLNPInsuredRelatedSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1058 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1061 */       if (this.mResultSet == null)
/*      */       {
/* 1063 */         CError tError = new CError();
/* 1064 */         tError.moduleName = "LNPInsuredRelatedDB";
/* 1065 */         tError.functionName = "closeData";
/* 1066 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 1067 */         this.mErrors.addOneError(tError);
/* 1068 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1072 */         this.mResultSet.close();
/* 1073 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1078 */       CError tError = new CError();
/* 1079 */       tError.moduleName = "LNPInsuredRelatedDB";
/* 1080 */       tError.functionName = "closeData";
/* 1081 */       tError.errorMessage = ex2.toString();
/* 1082 */       this.mErrors.addOneError(tError);
/* 1083 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1087 */       if (this.mStatement == null)
/*      */       {
/* 1089 */         CError tError = new CError();
/* 1090 */         tError.moduleName = "LNPInsuredRelatedDB";
/* 1091 */         tError.functionName = "closeData";
/* 1092 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 1093 */         this.mErrors.addOneError(tError);
/* 1094 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1098 */         this.mStatement.close();
/* 1099 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1104 */       CError tError = new CError();
/* 1105 */       tError.moduleName = "LNPInsuredRelatedDB";
/* 1106 */       tError.functionName = "closeData";
/* 1107 */       tError.errorMessage = ex3.toString();
/* 1108 */       this.mErrors.addOneError(tError);
/* 1109 */       flag = false;
/*      */     }
/* 1111 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPInsuredRelatedDB
 * JD-Core Version:    0.6.0
 */