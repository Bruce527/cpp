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
/*      */ public class ExeSQL
/*      */ {
/*      */   private Connection con;
/*   23 */   private boolean mflag = false;
/*      */ 
/*   25 */   private FDate fDate = new FDate();
/*   26 */   public CErrors mErrors = new CErrors();
/*      */ 
/*      */   public ExeSQL(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public ExeSQL()
/*      */   {
/*      */   }
/*      */ 
/*      */   public String getOneValue(String sql)
/*      */   {
/*   42 */     PreparedStatement pstmt = null;
/*   43 */     ResultSet rs = null;
/*   44 */     String mValue = "";
/*   45 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*   48 */     if (!this.mflag)
/*      */     {
/*   50 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   55 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*   56 */         1007);
/*   57 */       rs = pstmt.executeQuery();
/*   58 */       if (rs.next())
/*      */       {
/*   61 */         mValue = rs.getString(1);
/*      */       }
/*      */ 
/*   64 */       rs.close();
/*   65 */       pstmt.close();
/*      */ 
/*   67 */       if (!this.mflag)
/*      */       {
/*   69 */         this.con.close();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*   75 */       System.out.println("### Error ExeSQL at OneValue: " + sql);
/*   76 */       CError.buildErr(this, e.toString());
/*      */ 
/*   78 */       mValue = "";
/*      */       try
/*      */       {
/*   81 */         if (rs != null)
/*      */         {
/*   83 */           rs.close();
/*      */         }
/*   85 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*   90 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*   94 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  100 */               System.out.println("Sql's bug is very big: " + sql);
/*  101 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  100 */               System.out.println("Sql's bug is very big: " + sql);
/*  101 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  107 */         if (!this.mflag)
/*      */         {
/*  109 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  114 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/*  118 */     return StrTool.cTrim(mValue);
/*      */   }
/*      */ 
/*      */   private int getResultCount(String sql, PreparedStatement pstmt, ResultSet rs)
/*      */   {
/*  125 */     int iCount = 0;
/*      */ 
/*  127 */     sql = "select count(1) from (" + sql + ") rsc";
/*  128 */     System.out.println("getResultCount : " + sql);
/*      */     try
/*      */     {
/*  132 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  133 */         1007);
/*  134 */       rs = pstmt.executeQuery();
/*      */ 
/*  137 */       if (rs.next())
/*      */       {
/*  139 */         iCount = rs.getInt(1);
/*      */       }
/*      */ 
/*  142 */       rs.close();
/*  143 */       pstmt.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  147 */       e.printStackTrace();
/*      */ 
/*  149 */       CError.buildErr(this, e.toString());
/*  150 */       iCount = 0;
/*      */       try
/*      */       {
/*  153 */         if (rs != null)
/*      */         {
/*  155 */           rs.close();
/*      */         }
/*  157 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  162 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  166 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  172 */               System.out.println("Sql's bug is very big: " + sql);
/*  173 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  172 */               System.out.println("Sql's bug is very big: " + sql);
/*  173 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  179 */         if (!this.mflag)
/*      */         {
/*  181 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException localSQLException4)
/*      */       {
/*      */       }
/*      */     }
/*      */ 
/*  189 */     return iCount;
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql, int start)
/*      */   {
/*  195 */     PreparedStatement pstmt = null;
/*  196 */     ResultSet rs = null;
/*  197 */     ResultSetMetaData rsmd = null;
/*  198 */     StringBuffer mResult = new StringBuffer(256);
/*  199 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  202 */     if (start <= 0)
/*      */     {
/*  204 */       start = 1;
/*      */     }
/*      */ 
/*  208 */     if (!this.mflag)
/*      */     {
/*  210 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  215 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  216 */         1007);
/*  217 */       rs = pstmt.executeQuery();
/*  218 */       rsmd = rs.getMetaData();
/*      */ 
/*  220 */       int n = rsmd.getColumnCount();
/*      */ 
/*  222 */       int m = start + 200;
/*      */ 
/*  225 */       k = 0;
/*  226 */       while (rs.next())
/*      */       {
/*  228 */         k++;
/*  229 */         if ((k < start) || (k >= m)) {
/*      */           continue;
/*      */         }
/*  232 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  234 */           if (j == 1)
/*      */           {
/*  236 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  240 */             mResult.append("|" + 
/*  241 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  244 */         mResult.append("^");
/*      */       }
/*      */ 
/*  248 */       if (k >= start)
/*      */       {
/*  250 */         if (k > 10000)
/*      */         {
/*  252 */           System.out.println("\u5EFA\u8BAE\u91C7\u7528\u5927\u6279\u91CF\u6570\u636E\u67E5\u8BE2\u6A21\u5F0F\uFF01");
/*      */         }
/*      */ 
/*  255 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  256 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  260 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!");
/*      */       }
/*  262 */       rs.close();
/*  263 */       pstmt.close();
/*  264 */       if (!this.mflag)
/*      */       {
/*  266 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  271 */       System.out.println("### Error ExeSQL at getEncodedResult(String sql, int start): " + 
/*  272 */         sql);
/*  273 */       e.printStackTrace();
/*      */ 
/*  275 */       CError.buildErr(this, e.toString());
/*  276 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  279 */         if (rs != null)
/*      */         {
/*  281 */           rs.close();
/*      */         }
/*  283 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  288 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  292 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  298 */               System.out.println("Sql's bug is very big: " + sql);
/*  299 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  298 */               System.out.println("Sql's bug is very big: " + sql);
/*  299 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  305 */         if (!this.mflag)
/*      */         {
/*  307 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  312 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  315 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResultLarge(String sql, int start)
/*      */   {
/*  321 */     PreparedStatement pstmt = null;
/*  322 */     ResultSet rs = null;
/*  323 */     ResultSetMetaData rsmd = null;
/*  324 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  327 */     if (start <= 0)
/*      */     {
/*  329 */       start = 1;
/*      */     }
/*      */ 
/*  333 */     if (!this.mflag)
/*      */     {
/*  335 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*  339 */     int iCount = getResultCount(sql, pstmt, rs);
/*      */ 
/*  341 */     if (iCount <= 0)
/*      */     {
/*      */       try
/*      */       {
/*  345 */         if (!this.mflag)
/*      */         {
/*  347 */           this.con.close();
/*      */         }
/*      */ 
/*      */       }
/*      */       catch (SQLException localSQLException1)
/*      */       {
/*      */       }
/*      */ 
/*  355 */       return "100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!";
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  361 */       int m = start + 200;
/*      */ 
/*  364 */       StringBuffer tSBql = new StringBuffer();
/*  365 */       if ("ORACLE".equals("ORACLE"))
/*      */       {
/*  367 */         tSBql.append("select * from (select rownum rnm,rs.* from (");
/*  368 */         tSBql.append(sql);
/*  369 */         tSBql.append(") rs where rownum < ");
/*  370 */         tSBql.append(m);
/*  371 */         tSBql.append(") rss where rnm >= ");
/*  372 */         tSBql.append(start);
/*      */       }
/*      */       else
/*      */       {
/*  376 */         tSBql.append("select * from (select rownumber() OVER () rnm ,rs.* from (");
/*  377 */         tSBql.append(sql);
/*  378 */         tSBql.append(") rs) rss WHERE rnm BETWEEN ");
/*  379 */         tSBql.append(start);
/*  380 */         tSBql.append(" and ");
/*  381 */         tSBql.append(m - 1);
/*      */       }
/*      */ 
/*  384 */       System.out.println("ExecSQL : " + tSBql.toString());
/*      */ 
/*  386 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(tSBql.toString()), 
/*  387 */         1003, 1007);
/*      */ 
/*  389 */       rs = pstmt.executeQuery();
/*  390 */       rsmd = rs.getMetaData();
/*      */ 
/*  392 */       n = rsmd.getColumnCount();
/*      */ 
/*  394 */       int k = 0;
/*  395 */       while (rs.next())
/*      */       {
/*  397 */         k++;
/*      */ 
/*  399 */         for (int j = 2; j <= n; j++)
/*      */         {
/*  401 */           if (j == 2)
/*      */           {
/*  403 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  407 */             mResult.append("|" + 
/*  408 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  411 */         mResult.append("^");
/*      */       }
/*      */ 
/*  414 */       if (k > 0)
/*      */       {
/*  417 */         mResult.insert(0, "0|" + String.valueOf(iCount) + "^");
/*  418 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  422 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E!");
/*      */       }
/*  424 */       rs.close();
/*  425 */       pstmt.close();
/*  426 */       if (!this.mflag)
/*      */       {
/*  428 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  433 */       System.out.println("### Error ExeSQL at getEncodedResultLarge(String sql, int start): " + 
/*  434 */         sql);
/*  435 */       e.printStackTrace();
/*      */ 
/*  437 */       CError.buildErr(this, e.toString());
/*  438 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  441 */         if (rs != null)
/*      */         {
/*  443 */           rs.close();
/*      */         }
/*  445 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  450 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  454 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  460 */               System.out.println("Sql's bug is very big: " + sql);
/*  461 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  460 */               System.out.println("Sql's bug is very big: " + sql);
/*  461 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException3) {
/*      */             }
/*      */           }
/*      */         }
/*  467 */         if (!this.mflag)
/*      */         {
/*  469 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  474 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  477 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql)
/*      */   {
/*  483 */     PreparedStatement pstmt = null;
/*  484 */     ResultSet rs = null;
/*  485 */     ResultSetMetaData rsmd = null;
/*  486 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  488 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  490 */     if (!this.mflag)
/*      */     {
/*  492 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  496 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  497 */         1007);
/*      */ 
/*  499 */       pstmt.setFetchSize(500);
/*  500 */       rs = pstmt.executeQuery();
/*  501 */       rs.setFetchSize(500);
/*  502 */       rsmd = rs.getMetaData();
/*      */ 
/*  504 */       int n = rsmd.getColumnCount();
/*      */ 
/*  506 */       int k = 0;
/*      */ 
/*  508 */       while (rs.next())
/*      */       {
/*  510 */         k++;
/*  511 */         for (j = 1; j <= n; j++)
/*      */         {
/*  513 */           if (j == 1)
/*      */           {
/*  515 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  519 */             mResult.append("|");
/*  520 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  523 */         mResult.append("^");
/*      */       }
/*  525 */       if (k > 0)
/*      */       {
/*  528 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  529 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  533 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E\uFF01");
/*      */       }
/*  535 */       rs.close();
/*  536 */       pstmt.close();
/*  537 */       if (!this.mflag)
/*      */       {
/*  539 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  544 */       System.out.println("### Error ExeSQL at getEncodedResult(String sql): " + sql);
/*  545 */       e.printStackTrace();
/*      */ 
/*  547 */       CError.buildErr(this, e.toString());
/*  548 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  551 */         if (rs != null)
/*      */         {
/*  553 */           rs.close();
/*      */         }
/*  555 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  560 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  564 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  570 */               System.out.println("Sql's bug is very big: " + sql);
/*  571 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  570 */               System.out.println("Sql's bug is very big: " + sql);
/*  571 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  577 */         if (!this.mflag)
/*      */         {
/*  579 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  584 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  587 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getEncodedResult(String sql, int start, int nCount)
/*      */   {
/*  593 */     PreparedStatement pstmt = null;
/*  594 */     ResultSet rs = null;
/*  595 */     ResultSetMetaData rsmd = null;
/*  596 */     StringBuffer mResult = new StringBuffer(256);
/*      */ 
/*  598 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  600 */     if (start <= 0)
/*      */     {
/*  602 */       start = 1;
/*      */     }
/*  604 */     if (nCount <= 0)
/*      */     {
/*  606 */       nCount = 1;
/*      */     }
/*      */ 
/*  609 */     if (!this.mflag)
/*      */     {
/*  611 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  618 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  619 */         1007);
/*      */ 
/*  621 */       rs = pstmt.executeQuery();
/*  622 */       rsmd = rs.getMetaData();
/*  623 */       int n = rsmd.getColumnCount();
/*  624 */       int m = start + nCount;
/*      */ 
/*  626 */       k = 0;
/*  627 */       while (rs.next())
/*      */       {
/*  629 */         k++;
/*      */ 
/*  631 */         if (k >= m)
/*      */         {
/*      */           break;
/*      */         }
/*  635 */         if ((k < start) || (k >= m)) {
/*      */           continue;
/*      */         }
/*  638 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  640 */           if (j == 1)
/*      */           {
/*  642 */             mResult.append(getDataValue(rsmd, rs, j));
/*      */           }
/*      */           else
/*      */           {
/*  646 */             mResult.append("|").append(
/*  647 */               getDataValue(rsmd, rs, j));
/*      */           }
/*      */         }
/*  650 */         mResult.append("^");
/*      */       }
/*      */ 
/*  654 */       if (k >= start)
/*      */       {
/*  657 */         mResult.insert(0, "0|" + String.valueOf(k) + "^");
/*  658 */         mResult.delete(mResult.length() - 1, mResult.length());
/*      */       }
/*      */       else
/*      */       {
/*  662 */         mResult.append("100|\u672A\u67E5\u8BE2\u5230\u76F8\u5173\u6570\u636E\uFF01");
/*      */       }
/*  664 */       rs.close();
/*  665 */       pstmt.close();
/*  666 */       if (!this.mflag)
/*      */       {
/*  668 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  673 */       System.out.println(
/*  674 */         "### Error ExeSQL at getEncodedResult(String sql, int start, int nCount): " + 
/*  675 */         sql);
/*  676 */       e.printStackTrace();
/*      */ 
/*  678 */       CError.buildErr(this, e.toString());
/*  679 */       mResult.setLength(0);
/*      */       try
/*      */       {
/*  682 */         if (rs != null)
/*      */         {
/*  684 */           rs.close();
/*      */         }
/*  686 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  691 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  695 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  701 */               System.out.println("Sql's bug is very big: " + sql);
/*  702 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  701 */               System.out.println("Sql's bug is very big: " + sql);
/*  702 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  708 */         if (!this.mflag)
/*      */         {
/*  710 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  715 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*  718 */     return mResult.toString();
/*      */   }
/*      */ 
/*      */   public String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
/*      */   {
/*  724 */     String strValue = "";
/*      */     try
/*      */     {
/*  728 */       int dataType = rsmd.getColumnType(i);
/*  729 */       int dataScale = rsmd.getScale(i);
/*  730 */       int dataPrecision = rsmd.getPrecision(i);
/*      */ 
/*  732 */       if ((dataType == 1) || (dataType == 12))
/*      */       {
/*  736 */         strValue = rs.getString(i);
/*      */       }
/*  739 */       else if ((dataType == 93) || (dataType == 91))
/*      */       {
/*  741 */         strValue = this.fDate.getString(rs.getDate(i));
/*      */       }
/*  744 */       else if ((dataType == 3) || (dataType == 6))
/*      */       {
/*  748 */         strValue = String.valueOf(rs.getBigDecimal(i));
/*      */ 
/*  750 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*  753 */       else if ((dataType == 4) || (dataType == 5))
/*      */       {
/*  755 */         strValue = String.valueOf(rs.getInt(i));
/*  756 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*  759 */       else if (dataType == 2)
/*      */       {
/*  761 */         if (dataScale == 0)
/*      */         {
/*  763 */           if (dataPrecision == 0)
/*      */           {
/*  767 */             strValue = String.valueOf(rs.getBigDecimal(i));
/*      */           }
/*      */           else
/*      */           {
/*  771 */             strValue = String.valueOf(rs.getLong(i));
/*      */           }
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  778 */           strValue = String.valueOf(rs.getBigDecimal(i));
/*      */         }
/*  780 */         strValue = PubFun.getInt(strValue);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException ex)
/*      */     {
/*  786 */       ex.printStackTrace();
/*      */     }
/*  788 */     return StrTool.cTrim(strValue);
/*      */   }
/*      */ 
/*      */   public boolean execUpdateSQL(String sql)
/*      */   {
/*  794 */     PreparedStatement pstmt = null;
/*  795 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  798 */     if (!this.mflag)
/*      */     {
/*  800 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  806 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  807 */         1008);
/*      */ 
/*  809 */       pstmt.executeUpdate();
/*      */ 
/*  811 */       pstmt.close();
/*      */ 
/*  813 */       if (!this.mflag)
/*      */       {
/*  815 */         this.con.commit();
/*  816 */         this.con.close();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  822 */       System.out.println("### Error ExeSQL at execUpdateSQL: " + sql);
/*  823 */       CError.buildErr(this, e.toString());
/*      */       try
/*      */       {
/*  827 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  832 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  836 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  842 */               System.out.println("Sql's bug is very big: " + sql);
/*  843 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  842 */               System.out.println("Sql's bug is very big: " + sql);
/*  843 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  849 */         if (!this.mflag)
/*      */         {
/*  851 */           this.con.rollback();
/*  852 */           this.con.close();
/*      */         }
/*      */ 
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  858 */         ex.printStackTrace();
/*  859 */         return false;
/*      */       }
/*      */ 
/*  862 */       return false;
/*      */     }
/*      */ 
/*  865 */     return true;
/*      */   }
/*      */ 
/*      */   public SSRS execSQL(String sql)
/*      */   {
/*  871 */     PreparedStatement pstmt = null;
/*  872 */     ResultSet rs = null;
/*  873 */     ResultSetMetaData rsmd = null;
/*  874 */     SSRS tSSRS = null;
/*      */ 
/*  876 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  878 */     if (!this.mflag)
/*      */     {
/*  880 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  885 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  886 */         1007);
/*      */ 
/*  888 */       rs = pstmt.executeQuery();
/*  889 */       rsmd = rs.getMetaData();
/*      */ 
/*  891 */       int n = rsmd.getColumnCount();
/*  892 */       tSSRS = new SSRS(n);
/*      */ 
/*  895 */       while (rs.next())
/*      */       {
/*  897 */         for (int j = 1; j <= n; j++)
/*      */         {
/*  899 */           tSSRS.SetText(getDataValue(rsmd, rs, j));
/*      */         }
/*      */       }
/*      */ 
/*  903 */       rs.close();
/*  904 */       pstmt.close();
/*      */ 
/*  906 */       if (!this.mflag)
/*      */       {
/*  908 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  913 */       System.out.println("### Error ExeSQL at execSQL(String sql): " + sql);
/*  914 */       e.printStackTrace();
/*      */ 
/*  917 */       CError.buildErr(this, e.toString());
/*      */ 
/*  919 */       tSSRS = null;
/*      */       try
/*      */       {
/*  924 */         if (rs != null)
/*      */         {
/*  926 */           rs.close();
/*      */         }
/*  928 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/*  933 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/*  937 */             ex.printStackTrace();
/*      */             try
/*      */             {
/*  943 */               System.out.println("Sql's bug is very big: " + sql);
/*  944 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/*  943 */               System.out.println("Sql's bug is very big: " + sql);
/*  944 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/*  950 */         if (!this.mflag)
/*      */         {
/*  952 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/*  957 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/*  961 */     return tSSRS;
/*      */   }
/*      */ 
/*      */   public SSRS execSQL(String sql, int start, int nCount)
/*      */   {
/*  966 */     PreparedStatement pstmt = null;
/*  967 */     ResultSet rs = null;
/*  968 */     ResultSetMetaData rsmd = null;
/*  969 */     SSRS tSSRS = null;
/*      */ 
/*  971 */     System.out.println("ExecSQL : " + sql);
/*      */ 
/*  973 */     if (start <= 0)
/*      */     {
/*  975 */       start = 1;
/*      */     }
/*      */ 
/*  978 */     if (nCount <= 0)
/*      */     {
/*  980 */       nCount = 1;
/*      */     }
/*      */ 
/*  984 */     if (!this.mflag)
/*      */     {
/*  986 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  991 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 
/*  992 */         1007);
/*      */ 
/*  994 */       rs = pstmt.executeQuery();
/*  995 */       rsmd = rs.getMetaData();
/*      */ 
/*  997 */       int n = rsmd.getColumnCount();
/*  998 */       tSSRS = new SSRS(n);
/*      */ 
/* 1000 */       int m = start + nCount;
/* 1001 */       k = 0;
/*      */ 
/* 1004 */       while (rs.next())
/*      */       {
/* 1006 */         k++;
/*      */ 
/* 1009 */         if ((k < start) || (k >= m))
/*      */           continue;
/* 1011 */         for (int j = 1; j <= n; j++)
/*      */         {
/* 1013 */           tSSRS.SetText(getDataValue(rsmd, rs, j));
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1018 */       rs.close();
/* 1019 */       pstmt.close();
/*      */ 
/* 1021 */       if (!this.mflag)
/*      */       {
/* 1023 */         this.con.close();
/*      */       }
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/* 1028 */       System.out.println("### Error ExeSQL at execSQL(String sql, int start, int nCount): " + 
/* 1029 */         sql);
/* 1030 */       e.printStackTrace();
/*      */ 
/* 1033 */       CError.buildErr(this, e.toString());
/*      */ 
/* 1035 */       tSSRS = null;
/*      */       try
/*      */       {
/* 1039 */         if (rs != null)
/*      */         {
/* 1041 */           rs.close();
/*      */         }
/* 1043 */         if (pstmt != null)
/*      */         {
/*      */           try
/*      */           {
/* 1048 */             pstmt.close();
/*      */           }
/*      */           catch (SQLException ex)
/*      */           {
/* 1052 */             ex.printStackTrace();
/*      */             try
/*      */             {
/* 1058 */               System.out.println("Sql's bug is very big: " + sql);
/* 1059 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException1)
/*      */             {
/*      */             }
/*      */           }
/*      */           finally
/*      */           {
/*      */             try
/*      */             {
/* 1058 */               System.out.println("Sql's bug is very big: " + sql);
/* 1059 */               pstmt.close();
/*      */             }
/*      */             catch (SQLException localSQLException2) {
/*      */             }
/*      */           }
/*      */         }
/* 1065 */         if (!this.mflag)
/*      */         {
/* 1067 */           this.con.close();
/*      */         }
/*      */       }
/*      */       catch (SQLException ex)
/*      */       {
/* 1072 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/* 1076 */     return tSSRS;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/* 1090 */     DBConn conn = DBConnPool.getConnection();
/* 1091 */     System.out.println(conn);
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ExeSQL
 * JD-Core Version:    0.6.0
 */