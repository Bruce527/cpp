/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.util.List;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ 
/*     */ public class dealXML
/*     */ {
/*  14 */   private String[][] mData = null;
/*  15 */   private String mTable = null;
/*  16 */   private int flag = 0;
/*     */ 
/*     */   public boolean parseXML(InputStream aIS, Connection conn)
/*     */   {
/*     */     try
/*     */     {
/*  22 */       int count = 0;
/*     */ 
/*  24 */       SAXBuilder builder = new SAXBuilder();
/*     */ 
/*  26 */       Document read_doc = builder.build(aIS);
/*     */ 
/*  28 */       Element stu = read_doc.getRootElement();
/*  29 */       this.mTable = stu.getAttributeValue("name");
/*  30 */       List list_row = stu.getChildren("row");
/*     */ 
/*  36 */       if (!delData(conn, this.mTable)) {
/*  37 */         return false;
/*     */       }
/*     */ 
/*  40 */       for (int i = 0; i < list_row.size(); i++)
/*     */       {
/*  42 */         Element e = (Element)list_row.get(i);
/*     */ 
/*  44 */         List list_col = e.getChildren("col");
/*  45 */         for (int j = 0; j < list_col.size(); j++) {
/*  46 */           if ((i == 0) && (j == 0) && (list_row.size() <= 1000))
/*  47 */             this.mData = new String[list_row.size()][list_col.size()];
/*  48 */           else if ((j == 0) && (list_row.size() > 1000)) {
/*  49 */             if ((count % 1000 == 0) && (j == 0) && 
/*  50 */               (list_row.size() - count <= 1000))
/*  51 */               this.mData = 
/*  52 */                 new String[list_row.size() - 
/*  52 */                 count][list_col.size()];
/*  53 */             else if ((count % 1000 == 0) && (j == 0) && 
/*  54 */               (list_row.size() - count > 1000)) {
/*  55 */               this.mData = new String[1000][list_col.size()];
/*     */             }
/*     */           }
/*  58 */           Element f = (Element)list_col.get(j);
/*  59 */           String value = f.getText();
/*  60 */           if (i < 1000)
/*  61 */             this.mData[i][j] = value;
/*     */           else {
/*  63 */             this.mData[(i % 1000)][j] = value;
/*     */           }
/*     */         }
/*  66 */         count++;
/*  67 */         if (count == list_row.size())
/*     */         {
/*  69 */           if (count <= 1000) {
/*  70 */             if (!insertData(conn, list_row.size(), this.mData))
/*  71 */               return false;
/*     */           }
/*  73 */           else if ((count > 1000) && 
/*  74 */             (!insertData(conn, count % 1000, this.mData)))
/*  75 */             return false;
/*     */         }
/*     */         else {
/*  78 */           if (count % 1000 != 0)
/*     */             continue;
/*  80 */           if (!insertData(conn, 1000, this.mData)) {
/*  81 */             return false;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  92 */       ex.printStackTrace();
/*  93 */       return false;
/*     */     }
/*     */ 
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean delData(Connection con, String tablename)
/*     */   {
/* 101 */     String sql = "delete from " + this.mTable;
/*     */     try {
/* 103 */       if (con == null) {
/* 104 */         return false;
/*     */       }
/*     */ 
/* 111 */       ExeSQL tExeSQL = new ExeSQL(con);
/* 112 */       if (!tExeSQL.execUpdateSQL(StrTool.GBKToUnicode(sql)))
/* 113 */         return false;
/*     */     }
/*     */     catch (Exception e) {
/* 116 */       System.out.println(e);
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean insertData(Connection con, int count, String[][] data)
/*     */   {
/* 126 */     String tInsSQL = null;
/* 127 */     String[] tSQL = new String[count];
/*     */ 
/* 130 */     ExeSQL tExeSQL = new ExeSQL(con);
/*     */ 
/* 133 */     for (int i = 0; i < data.length; i++) {
/* 134 */       tInsSQL = "insert into " + this.mTable + " values(";
/* 135 */       for (int j = 0; j < data[i].length; j++)
/*     */       {
/* 137 */         String tValue = data[i][j];
/* 138 */         tValue = StrTool.replace(tValue, "&amp;", "&");
/* 139 */         tValue = StrTool.replace(tValue, "&lt;", "<");
/* 140 */         tValue = StrTool.replace(tValue, "&gt;", ">");
/* 141 */         tValue = StrTool.replace(tValue, "&quot;", "\"");
/*     */ 
/* 146 */         tValue = StrTool.replace(tValue, "\\", "\\\\");
/* 147 */         tValue = StrTool.replace(tValue, "'", "\\'");
/* 148 */         tValue = StrTool.replace(tValue, "\"", "\\\"");
/*     */ 
/* 150 */         if (j == 0)
/* 151 */           tInsSQL = tInsSQL + "'" + tValue + "'";
/*     */         else {
/* 153 */           tInsSQL = tInsSQL + ",'" + tValue + "'";
/*     */         }
/*     */       }
/* 156 */       tSQL[i] = (tInsSQL + ")");
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 166 */       for (int a = 0; a < tSQL.length; a++) {
/* 167 */         if (!tExeSQL.execUpdateSQL(StrTool.GBKToUnicode(tSQL[a]))) {
/* 168 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 174 */       e.printStackTrace();
/* 175 */       return false;
/*     */     }
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 182 */     dealXML dealXML1 = new dealXML();
/*     */   }
/*     */ 
/*     */   public void setFlag(int i) {
/* 186 */     this.flag = i;
/*     */   }
/*     */ 
/*     */   public int getFlag() {
/* 190 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public boolean createTable(InputStream aIS, Connection conn)
/*     */   {
/*     */     try
/*     */     {
/* 197 */       String sql = "";
/*     */ 
/* 200 */       ExeSQL tExeSQL = new ExeSQL(conn);
/*     */ 
/* 202 */       SAXBuilder builder = new SAXBuilder();
/*     */ 
/* 204 */       Document read_doc = builder.build(aIS);
/*     */ 
/* 206 */       Element stu = read_doc.getRootElement();
/* 207 */       this.mTable = stu.getAttributeValue("name");
/* 208 */       List list_row = stu.getChildren("row");
/* 209 */       int count = list_row.size();
/* 210 */       for (int i = 0; i < list_row.size(); i++)
/*     */       {
/* 212 */         Element e = (Element)list_row.get(i);
/*     */ 
/* 214 */         List list_col = e.getChildren("col");
/* 215 */         for (int j = 0; j < list_col.size(); j++) {
/* 216 */           if ((i == 0) && (j == 0)) {
/* 217 */             this.mData = new String[list_row.size()][list_col.size()];
/*     */           }
/* 219 */           Element f = (Element)list_col.get(j);
/* 220 */           String tValue = f.getText();
/* 221 */           if (tValue.length() > 0) {
/* 222 */             tValue = StrTool.replace(tValue, "&amp;", "&");
/* 223 */             tValue = StrTool.replace(tValue, "&lt;", "<");
/* 224 */             tValue = StrTool.replace(tValue, "&gt;", ">");
/* 225 */             tValue = StrTool.replace(tValue, "&quot;", "\"");
/*     */ 
/* 230 */             tValue = StrTool.replace(tValue, "\\", "\\\\");
/* 231 */             tValue = StrTool.replace(tValue, "'", "\\'");
/* 232 */             tValue = StrTool.replace(tValue, "\"", "\\\"");
/*     */           }
/* 234 */           this.mData[i][j] = tValue;
/*     */         }
/*     */ 
/* 241 */         sql = 
/* 242 */           "select * from information_schema.tables where table_name='" + 
/* 243 */           this.mData[i][0] + "'";
/* 244 */         SSRS rs = tExeSQL.execSQL(sql);
/* 245 */         if (rs.getMaxRow() > 0) {
/* 246 */           tExeSQL.execUpdateSQL("drop table " + this.mData[i][0]);
/*     */         }
/* 248 */         tExeSQL.execUpdateSQL(this.mData[i][1]);
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 252 */       ex.printStackTrace();
/* 253 */       return false;
/*     */     }
/* 255 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.dealXML
 * JD-Core Version:    0.6.0
 */