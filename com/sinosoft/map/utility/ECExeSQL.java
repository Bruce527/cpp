/*      */ package com.sinosoft.map.utility;
/*      */ 
/*      */ import com.sinosoft.map.lis.pubfun.FDate;
/*      */ import com.sinosoft.map.lis.pubfun.PubFun;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class ECExeSQL
/*      */ {
/*      */   private Connection con;
/*   19 */   private boolean mflag = false;
/*      */ 
/*   21 */   private FDate fDate = new FDate();
/*   22 */   public CErrors mErrors = new CErrors();
/*      */ 
/*      */   public ECExeSQL(Connection tConnection)
/*      */   {
/*   27 */     this.con = tConnection;
/*   28 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public ECExeSQL()
/*      */   {
/*      */   }
/*      */ 
/*      */   public String getOneValue(String sql)
/*      */   {
/*   38 */     PreparedStatement pstmt = null;
/*   39 */     ResultSet rs = null;
/*   40 */     String mValue = "";
/*   41 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*   44 */     if (!this.mflag)
/*      */     {
/*   46 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   51 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*   52 */         1007);
/*   53 */       rs = pstmt.executeQuery();
/*   54 */       if (rs.next())
/*      */       {
/*   57 */         mValue = rs.getString(1);
/*      */       }
/*      */ 
/*   60 */       rs.close();
/*   61 */       pstmt.close();
/*      */ 
/*   63 */       if (!this.mflag)
/*      */       {
/*   65 */         this.con.close();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*   71 */       System.out.println("### Error ExeSQL at OneValue: " + sql);
/*   72 */       CError.buildErr(this, e.toString());
/*      */ 
/*   74 */       mValue = "";
/*      */       try
/*      */       {
/*   77 */         if (rs != null)
/*      */         {
/*   79 */           rs.close();
/*      */         }
/*   81 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*   86 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*   90 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*   96 */               System.out.println("Sql's bug is very big: " + sql);
/*   97 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*   96 */               System.out.println("Sql's bug is very big: " + sql);
/*   97 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  103 */         if (!this.mflag)
/*      */         {
/*  105 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  110 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/*  114 */     return StrTool.cTrim(mValue);
/*      */   }
/*      */ 
/*      */   private int getResultCount(String sql, PreparedStatement pstmt, ResultSet rs)
/*      */   {
/*  121 */     int iCount = 0;
/*      */ 
/*  123 */     sql = "select count(1) from (" + sql + ") rsc";
/*  124 */     System.out.println("getResultCount : " + sql);
/*      */     try
/*      */     {
/*  128 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  129 */         1007);
/*  130 */       rs = pstmt.executeQuery();
/*      */ 
/*  133 */       if (rs.next())
/*      */       {
/*  135 */         iCount = rs.getInt(1);
/*      */       }
/*      */ 
/*  138 */       rs.close();
/*  139 */       pstmt.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  143 */       e.printStackTrace();
/*      */ 
/*  145 */       CError.buildErr(this, e.toString());
/*  146 */       iCount = 0;
/*      */       try
/*      */       {
/*  149 */         if (rs != null)
/*      */         {
/*  151 */           rs.close();
/*      */         }
/*  153 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  158 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  162 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  168 */               System.out.println("Sql's bug is very big: " + sql);
/*  169 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  168 */               System.out.println("Sql's bug is very big: " + sql);
/*  169 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  175 */         if (!this.mflag)
/*      */         {
/*  177 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException localSQLException4)
/*      */       {
/*      */       }
/*      */     }
/*      */ 
/*  185 */     return iCount;
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql, int start)
/*      */   {
/*  191 */     PreparedStatement pstmt = null;
/*  192 */     ResultSet rs = null;
/*  193 */     ResultSetMetaData rsmd = null;
/*  194 */     StringBuffer mResult = new StringBuffer(256);
/*  195 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  198 */     if (start <= 0)
/*      */     {
/*  200 */       start = 1;
/*      */     }
/*      */ 
/*  204 */     if (!this.mflag)
/*      */     {
/*  206 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  211 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  212 */         1007);
/*  213 */       rs = pstmt.executeQuery();
/*  214 */       rsmd = rs.getMetaData();
/*      */ 
/*  216 */       int n = rsmd.getColumnCount();
/*      */ 
/*  218 */       int m = start + 200;
/*      */ 
/*  221 */       k = 0;
/*  222 */       while (rs.next())
/*      */       {
/*  224 */         k++;
/*  225 */         if ((k < start) || (k >= m)) {
/*      */           continue;
/*      */         }
/*  228 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  230 */           if (j == 1)
/*      */           {
/*  232 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  236 */             mResult.append("|" + 
/*  237 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  240 */         mResult.append("^");
/*      */       }
/*      */ 
/*  244 */       if (k >= start)
/*      */       {
/*  246 */         if (k > 10000)
/*      */         {
/*  248 */           System.out.println("\u5EFA\u8BAE\u91C7\u7528\u5927\u6279\u91CF\u6570\u636E\u67E5\u8BE2\u6A21\u5F0F\uFF01");
/*      */         }
/*      */ 
/*  251 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  252 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  256 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!");
/*      */       }
/*  258 */       rs.close();
/*  259 */       pstmt.close();
/*  260 */       if (!this.mflag)
/*      */       {
/*  262 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  267 */       System.out.println("### Error ExeSQL at getEncodedResult(String sql, int start): " + 
/*  268 */         sql);
/*  269 */       e.printStackTrace();
/*      */ 
/*  271 */       CError.buildErr(this, e.toString());
/*  272 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  275 */         if (rs != null)
/*      */         {
/*  277 */           rs.close();
/*      */         }
/*  279 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  284 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  288 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  294 */               System.out.println("Sql's bug is very big: " + sql);
/*  295 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  294 */               System.out.println("Sql's bug is very big: " + sql);
/*  295 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  301 */         if (!this.mflag)
/*      */         {
/*  303 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  308 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  311 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResultLarge(String sql, int start)
/*      */   {
/*  317 */     PreparedStatement pstmt = null;
/*  318 */     ResultSet rs = null;
/*  319 */     ResultSetMetaData rsmd = null;
/*  320 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  323 */     if (start <= 0)
/*      */     {
/*  325 */       start = 1;
/*      */     }
/*      */ 
/*  329 */     if (!this.mflag)
/*      */     {
/*  331 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*  335 */     int iCount = getResultCount(sql, pstmt, rs);
/*      */ 
/*  337 */     if (iCount <= 0)
/*      */     {
/*      */       try
/*      */       {
/*  341 */         if (!this.mflag)
/*      */         {
/*  343 */           this.con.close();
/*      */         }
/*      */ 
/*      */       }
/*      */       catch (SQLException localSQLException1)
/*      */       {
/*      */       }
/*      */ 
/*  351 */       return "100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!";
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  357 */       int m = start + 200;
/*      */ 
/*  360 */       StringBuffer tSBql = new StringBuffer();
/*  361 */       if ("ORACLE".equals("ORACLE"))
/*      */       {
/*  363 */         tSBql.append("select * from (select rownum rnm,rs.* from (");
/*  364 */         tSBql.append(sql);
/*  365 */         tSBql.append(") rs where rownum < ");
/*  366 */         tSBql.append(m);
/*  367 */         tSBql.append(") rss where rnm >= ");
/*  368 */         tSBql.append(start);
/*      */       }
/*      */       else
/*      */       {
/*  372 */         tSBql.append("select * from (select rownumber() OVER () rnm ,rs.* from (");
/*  373 */         tSBql.append(sql);
/*  374 */         tSBql.append(") rs) rss WHERE rnm BETWEEN ");
/*  375 */         tSBql.append(start);
/*  376 */         tSBql.append(" and ");
/*  377 */         tSBql.append(m - 1);
/*      */       }
/*      */ 
/*  380 */       System.out.println("ExecSQL : " + tSBql.toString());
/*      */ 
/*  382 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(tSBql.toString()), 
/*  383 */         1003, 1007);
/*      */ 
/*  385 */       rs = pstmt.executeQuery();
/*  386 */       rsmd = rs.getMetaData();
/*      */ 
/*  388 */       n = rsmd.getColumnCount();
/*      */ 
/*  390 */       int k = 0;
/*  391 */       while (rs.next())
/*      */       {
/*  393 */         k++;
/*      */ 
/*  395 */         for (int j = 2; j <= n; j++)
/*      */         {
/*  397 */           if (j == 2)
/*      */           {
/*  399 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  403 */             mResult.append("|" + 
/*  404 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  407 */         mResult.append("^");
/*      */       }
/*      */ 
/*  410 */       if (k > 0)
/*      */       {
/*  413 */         mResult.insert(0, "0|" + String.valueOf(iCount) + "^");
/*  414 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  418 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!");
/*      */       }
/*  420 */       rs.close();
/*  421 */       pstmt.close();
/*  422 */       if (!this.mflag)
/*      */       {
/*  424 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  429 */       System.out.println("### Error ExeSQL at getEncodedResultLarge(String sql, int start): " + 
/*  430 */         sql);
/*  431 */       e.printStackTrace();
/*      */ 
/*  433 */       CError.buildErr(this, e.toString());
/*  434 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  437 */         if (rs != null)
/*      */         {
/*  439 */           rs.close();
/*      */         }
/*  441 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  446 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  450 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  456 */               System.out.println("Sql's bug is very big: " + sql);
/*  457 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  456 */               System.out.println("Sql's bug is very big: " + sql);
/*  457 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException3) {
/*      */             }
/*      */           }
/*      */         }
/*  463 */         if (!this.mflag)
/*      */         {
/*  465 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  470 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  473 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql)
/*      */   {
/*  479 */     PreparedStatement pstmt = null;
/*  480 */     ResultSet rs = null;
/*  481 */     ResultSetMetaData rsmd = null;
/*  482 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  484 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  486 */     if (!this.mflag)
/*      */     {
/*  488 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */     try
/*      */     {
/*  492 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  493 */         1007);
/*      */ 
/*  495 */       pstmt.setFetchSize(500);
/*  496 */       rs = pstmt.executeQuery();
/*  497 */       rs.setFetchSize(500);
/*  498 */       rsmd = rs.getMetaData();
/*      */ 
/*  500 */       int n = rsmd.getColumnCount();
/*      */ 
/*  502 */       int k = 0;
/*      */ 
/*  504 */       while (rs.next())
/*      */       {
/*  506 */         k++;
/*  507 */         for (j = 1; j <= n; j++)
/*      */         {
/*  509 */           if (j == 1)
/*      */           {
/*  511 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  515 */             mResult.append("|");
/*  516 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  519 */         mResult.append("^");
/*      */       }
/*  521 */       if (k > 0)
/*      */       {
/*  524 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  525 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  529 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E\uFF01");
/*      */       }
/*  531 */       rs.close();
/*  532 */       pstmt.close();
/*  533 */       if (!this.mflag)
/*      */       {
/*  535 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  540 */       System.out.println("### Error ExeSQL at getEncodedResult(String sql): " + sql);
/*  541 */       e.printStackTrace();
/*      */ 
/*  543 */       CError.buildErr(this, e.toString());
/*  544 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  547 */         if (rs != null)
/*      */         {
/*  549 */           rs.close();
/*      */         }
/*  551 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  556 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  560 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  566 */               System.out.println("Sql's bug is very big: " + sql);
/*  567 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  566 */               System.out.println("Sql's bug is very big: " + sql);
/*  567 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  573 */         if (!this.mflag)
/*      */         {
/*  575 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  580 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  583 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql, int start, int nCount)
/*      */   {
/*  589 */     PreparedStatement pstmt = null;
/*  590 */     ResultSet rs = null;
/*  591 */     ResultSetMetaData rsmd = null;
/*  592 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  594 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  596 */     if (start <= 0)
/*      */     {
/*  598 */       start = 1;
/*      */     }
/*  600 */     if (nCount <= 0)
/*      */     {
/*  602 */       nCount = 1;
/*      */     }
/*      */ 
/*  605 */     if (!this.mflag)
/*      */     {
/*  607 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  614 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  615 */         1007);
/*      */ 
/*  617 */       rs = pstmt.executeQuery();
/*  618 */       rsmd = rs.getMetaData();
/*  619 */       int n = rsmd.getColumnCount();
/*  620 */       int m = start + nCount;
/*      */ 
/*  622 */       k = 0;
/*  623 */       while (rs.next())
/*      */       {
/*  625 */         k++;
/*      */ 
/*  627 */         if (k >= m)
/*      */         {
/*      */           break;
/*      */         }
/*  631 */         if ((k < start) || (k >= m)) {
/*      */           continue;
/*      */         }
/*  634 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  636 */           if (j == 1)
/*      */           {
/*  638 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  642 */             mResult.append("|").append(
/*  643 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  646 */         mResult.append("^");
/*      */       }
/*      */ 
/*  650 */       if (k >= start)
/*      */       {
/*  653 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  654 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  658 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E\uFF01");
/*      */       }
/*  660 */       rs.close();
/*  661 */       pstmt.close();
/*  662 */       if (!this.mflag)
/*      */       {
/*  664 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  669 */       System.out.println(
/*  670 */         "### Error ExeSQL at getEncodedResult(String sql, int start, int nCount): " + 
/*  671 */         sql);
/*  672 */       e.printStackTrace();
/*      */ 
/*  674 */       CError.buildErr(this, e.toString());
/*  675 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  678 */         if (rs != null)
/*      */         {
/*  680 */           rs.close();
/*      */         }
/*  682 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  687 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  691 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  697 */               System.out.println("Sql's bug is very big: " + sql);
/*  698 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  697 */               System.out.println("Sql's bug is very big: " + sql);
/*  698 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  704 */         if (!this.mflag)
/*      */         {
/*  706 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  711 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  714 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
/*      */   {
/*  720 */     String strValue = "";
/*      */     try
/*      */     {
/*  724 */       int dataType = rsmd.getColumnType(i);
/*  725 */       int dataScale = rsmd.getScale(i);
/*  726 */       int dataPrecision = rsmd.getPrecision(i);
/*      */ 
/*  728 */       if ((dataType == 1) || (dataType == 12))
/*      */       {
/*  732 */         strValue = rs.getString(i);
/*      */       }
/*  735 */       else if ((dataType == 93) || (dataType == 91))
/*      */       {
/*  737 */         strValue = this.fDate.getString(rs.getDate(i));
/*      */       }
/*  740 */       else if ((dataType == 3) || (dataType == 6))
/*      */       {
/*  744 */         strValue = String.valueOf(rs.getBigDecimal(i));
/*      */ 
/*  746 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*  749 */       else if ((dataType == 4) || (dataType == 5))
/*      */       {
/*  751 */         strValue = String.valueOf(rs.getInt(i));
/*  752 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*  755 */       else if (dataType == 2)
/*      */       {
/*  757 */         if (dataScale == 0)
/*      */         {
/*  759 */           if (dataPrecision == 0)
/*      */           {
/*  763 */             strValue = String.valueOf(rs.getBigDecimal(i));
/*      */           }
/*      */           else
/*      */           {
/*  767 */             strValue = String.valueOf(rs.getLong(i));
/*      */           }
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  774 */           strValue = String.valueOf(rs.getBigDecimal(i));
/*      */         }
/*  776 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException ex)
/*      */     {
/*  782 */       ex.printStackTrace();
/*      */     }
/*      */ 
/*  785 */     return StrTool.cTrim(strValue);
/*      */   }
/*      */ 
/*      */   public boolean execUpdateSQL(String sql)
/*      */   {
/*  791 */     PreparedStatement pstmt = null;
/*  792 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  795 */     if (!this.mflag)
/*      */     {
/*  797 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  803 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  804 */         1008);
/*      */ 
/*  806 */       pstmt.executeUpdate();
/*      */ 
/*  808 */       pstmt.close();
/*      */ 
/*  810 */       if (!this.mflag)
/*      */       {
/*  812 */         this.con.commit();
/*  813 */         this.con.close();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  819 */       System.out.println("### Error ExeSQL at execUpdateSQL: " + sql);
/*  820 */       CError.buildErr(this, e.toString());
/*      */       try
/*      */       {
/*  824 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  829 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  833 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  839 */               System.out.println("Sql's bug is very big: " + sql);
/*  840 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  839 */               System.out.println("Sql's bug is very big: " + sql);
/*  840 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  846 */         if (!this.mflag)
/*      */         {
/*  848 */           this.con.rollback();
/*  849 */           this.con.close();
/*      */         }
/*      */ 
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  855 */         ex.printStackTrace();
/*  856 */         return false;
/*      */       }
/*      */ 
/*  859 */       return false;
/*      */     }
/*      */ 
/*  862 */     return true;
/*      */   }
/*      */ 
/*      */   public SSRS execSQL(String sql)
/*      */   {
/*  868 */     PreparedStatement pstmt = null;
/*  869 */     ResultSet rs = null;
/*  870 */     ResultSetMetaData rsmd = null;
/*  871 */     SSRS tSSRS = null;
/*      */ 
/*  873 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  875 */     if (!this.mflag)
/*      */     {
/*  877 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  882 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  883 */         1007);
/*      */ 
/*  885 */       rs = pstmt.executeQuery();
/*  886 */       rsmd = rs.getMetaData();
/*      */ 
/*  888 */       int n = rsmd.getColumnCount();
/*  889 */       tSSRS = new SSRS(n);
/*      */ 
/*  892 */       while (rs.next())
/*      */       {
/*  894 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  896 */           tSSRS.SetText(getDataValue(rsmd, rs, j));
/*      */         }
/*      */       }
/*      */ 
/*  900 */       rs.close();
/*  901 */       pstmt.close();
/*      */ 
/*  903 */       if (!this.mflag)
/*      */       {
/*  905 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  910 */       System.out.println("### Error ExeSQL at execSQL(String sql): " + sql);
/*  911 */       e.printStackTrace();
/*      */ 
/*  914 */       CError.buildErr(this, e.toString());
/*      */ 
/*  916 */       tSSRS = null;
/*      */       try
/*      */       {
/*  921 */         if (rs != null)
/*      */         {
/*  923 */           rs.close();
/*      */         }
/*  925 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  930 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  934 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  940 */               System.out.println("Sql's bug is very big: " + sql);
/*  941 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  940 */               System.out.println("Sql's bug is very big: " + sql);
/*  941 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  947 */         if (!this.mflag)
/*      */         {
/*  949 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  954 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/*  958 */     return tSSRS;
/*      */   }
/*      */ 
/*      */   public SSRS execSQL(String sql, int start, int nCount)
/*      */   {
/*  963 */     PreparedStatement pstmt = null;
/*  964 */     ResultSet rs = null;
/*  965 */     ResultSetMetaData rsmd = null;
/*  966 */     SSRS tSSRS = null;
/*      */ 
/*  968 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  970 */     if (start <= 0)
/*      */     {
/*  972 */       start = 1;
/*      */     }
/*      */ 
/*  975 */     if (nCount <= 0)
/*      */     {
/*  977 */       nCount = 1;
/*      */     }
/*      */ 
/*  981 */     if (!this.mflag)
/*      */     {
/*  983 */       this.con = ECDBConnPool.getECConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  988 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  989 */         1007);
/*      */ 
/*  991 */       rs = pstmt.executeQuery();
/*  992 */       rsmd = rs.getMetaData();
/*      */ 
/*  994 */       int n = rsmd.getColumnCount();
/*  995 */       tSSRS = new SSRS(n);
/*      */ 
/*  997 */       int m = start + nCount;
/*  998 */       k = 0;
/*      */ 
/* 1001 */       while (rs.next())
/*      */       {
/* 1003 */         k++;
/*      */ 
/* 1006 */         if ((k < start) || (k >= m))
/*      */           continue;
/* 1008 */         for (int j = 1; j <= n; j++)
/*      */         {
/* 1010 */           tSSRS.SetText(getDataValue(rsmd, rs, j));
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1015 */       rs.close();
/* 1016 */       pstmt.close();
/*      */ 
/* 1018 */       if (!this.mflag)
/*      */       {
/* 1020 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/* 1025 */       System.out.println("### Error ExeSQL at execSQL(String sql, int start, int nCount): " + 
/* 1026 */         sql);
/* 1027 */       e.printStackTrace();
/*      */ 
/* 1030 */       CError.buildErr(this, e.toString());
/*      */ 
/* 1032 */       tSSRS = null;
/*      */       try
/*      */       {
/* 1036 */         if (rs != null)
/*      */         {
/* 1038 */           rs.close();
/*      */         }
/* 1040 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/* 1045 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/* 1049 */             ex.printStackTrace();
/*      */             try
/*      */             {
/* 1055 */               System.out.println("Sql's bug is very big: " + sql);
/* 1056 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/* 1055 */               System.out.println("Sql's bug is very big: " + sql);
/* 1056 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/* 1062 */         if (!this.mflag)
/*      */         {
/* 1064 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/* 1069 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/* 1073 */     return tSSRS;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/* 1079 */     ExeSQL tExeSQL = new ExeSQL();
/* 1080 */     for (int i = 1; i <= 70; i++);
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ECExeSQL
 * JD-Core Version:    0.6.0
 */