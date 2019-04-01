/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class SQLString
/*     */ {
/*     */   private String TableName;
/*  19 */   private StringBuffer WherePart = new StringBuffer(256);
/*     */ 
/*  21 */   private StringBuffer PKWherePart = new StringBuffer(256);
/*     */ 
/*  23 */   private StringBuffer UpdPart = new StringBuffer(256);
/*     */ 
/*  25 */   private StringBuffer InsPart = new StringBuffer(256);
/*     */ 
/*  27 */   private StringBuffer mSql = new StringBuffer(256);
/*     */   private static final String mark = "'";
/*     */ 
/*     */   public SQLString(String t)
/*     */   {
/*  13 */     this.TableName = t;
/*     */   }
/*     */ 
/*     */   public void setSQL(int flag, Schema s)
/*     */   {
/*  33 */     switch (flag)
/*     */     {
/*     */     case 1:
/*  37 */       setInsPart(s);
/*  38 */       if (this.InsPart.equals(""))
/*     */       {
/*  41 */         this.mSql.setLength(0);
/*     */       }
/*     */       else
/*     */       {
/*  46 */         this.mSql.append("insert into ");
/*  47 */         this.mSql.append(this.TableName);
/*  48 */         this.mSql.append(" ");
/*  49 */         this.mSql.append(this.InsPart);
/*     */       }
/*  51 */       break;
/*     */     case 2:
/*  54 */       setUpdPart(s);
/*  55 */       setPKWherePart(s);
/*  56 */       if (this.UpdPart.equals(""))
/*     */       {
/*  59 */         this.mSql.setLength(0);
/*     */       }
/*     */       else
/*     */       {
/*  64 */         this.mSql.append("update ");
/*  65 */         this.mSql.append(this.TableName);
/*  66 */         this.mSql.append(" ");
/*  67 */         this.mSql.append(this.UpdPart);
/*  68 */         this.mSql.append(" ");
/*  69 */         this.mSql.append(this.PKWherePart);
/*     */       }
/*  71 */       break;
/*     */     case 3:
/*  74 */       setWherePart(s);
/*     */ 
/*  76 */       this.mSql.append("delete from ");
/*  77 */       this.mSql.append(this.TableName);
/*  78 */       this.mSql.append(" ");
/*  79 */       this.mSql.append(this.WherePart);
/*  80 */       break;
/*     */     case 4:
/*  83 */       setPKWherePart(s);
/*     */ 
/*  85 */       this.mSql.append("delete from ");
/*  86 */       this.mSql.append(this.TableName);
/*  87 */       this.mSql.append(" ");
/*  88 */       this.mSql.append(this.PKWherePart);
/*  89 */       break;
/*     */     case 5:
/*  92 */       setWherePart(s);
/*     */ 
/*  94 */       this.mSql.append("select * from ");
/*  95 */       this.mSql.append(this.TableName);
/*  96 */       this.mSql.append(" ");
/*  97 */       this.mSql.append(this.WherePart);
/*  98 */       break;
/*     */     case 6:
/* 101 */       setPKWherePart(s);
/*     */ 
/* 103 */       this.mSql.append("select * from ");
/* 104 */       this.mSql.append(this.TableName);
/* 105 */       this.mSql.append(" ");
/* 106 */       this.mSql.append(this.PKWherePart);
/* 107 */       break;
/*     */     case 7:
/* 110 */       setWherePart(s);
/*     */ 
/* 112 */       this.mSql.append("select count(1) from ");
/* 113 */       this.mSql.append(this.TableName);
/* 114 */       this.mSql.append(" ");
/* 115 */       this.mSql.append(this.WherePart);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getSQL()
/*     */   {
/* 122 */     System.out.println("mSql: " + this.mSql.toString());
/* 123 */     return this.mSql.toString();
/*     */   }
/*     */ 
/*     */   public String getSQL(int sqlFlag, Schema s)
/*     */   {
/* 128 */     if ((sqlFlag == 5) || (sqlFlag == 6))
/*     */     {
/* 130 */       setSQL(sqlFlag, s);
/*     */     }
/*     */     else
/*     */     {
/* 135 */       this.mSql.setLength(0);
/*     */     }
/* 137 */     System.out.println("mSql: " + this.mSql.toString());
/* 138 */     return this.mSql.toString();
/*     */   }
/*     */ 
/*     */   public void setPKWherePart(Schema s)
/*     */   {
/* 144 */     System.out.println("\u8FDB\u5165\u66F4\u65B0\u540E\u7684setPKWherePart");
/*     */ 
/* 146 */     this.PKWherePart.append("where");
/*     */ 
/* 148 */     String[] pk = s.getPK();
/* 149 */     int n = pk.length;
/*     */ 
/* 151 */     String strFieldName = "";
/* 152 */     StringBuffer strFieldValue = null;
/* 153 */     for (int i = 0; i < n; i++)
/*     */     {
/* 155 */       strFieldName = pk[i];
/*     */ 
/* 157 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 159 */       int nFieldType = s.getFieldType(strFieldName);
/*     */ 
/* 161 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 166 */         strFieldValue.append("'");
/* 167 */         strFieldValue.append(s.getV(strFieldName));
/* 168 */         strFieldValue.append("'");
/* 169 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 173 */         strFieldValue.append(s.getV(strFieldName));
/* 174 */         break;
/*     */       default:
/* 176 */         System.out.println("\u51FA\u73B0\u5F02\u5E38\u6570\u636E\u7C7B\u578B");
/*     */       }
/*     */ 
/* 180 */       if (i != 0)
/*     */       {
/* 183 */         this.PKWherePart.append(" and");
/*     */       }
/*     */ 
/* 188 */       this.PKWherePart.append(" ");
/* 189 */       this.PKWherePart.append(strFieldName);
/* 190 */       this.PKWherePart.append("=");
/* 191 */       this.PKWherePart.append(strFieldValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getPKWherePart()
/*     */   {
/* 197 */     return this.PKWherePart.toString();
/*     */   }
/*     */ 
/*     */   public void setWherePart(Schema s)
/*     */   {
/* 203 */     System.out.println("\u8FDB\u5165\u66F4\u65B0\u540E\u7684setWherePart");
/*     */ 
/* 205 */     this.WherePart.append("where");
/*     */ 
/* 207 */     int nFieldCount = s.getFieldCount();
/* 208 */     int j = 0;
/*     */ 
/* 210 */     String strFieldName = "";
/* 211 */     StringBuffer strFieldValue = null;
/* 212 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 214 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 216 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 218 */       int nFieldType = s.getFieldType(i);
/* 219 */       boolean bFlag = false;
/*     */ 
/* 221 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 230 */         if (s.getV(i).equals("null"))
/*     */         {
/* 232 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 236 */           strFieldValue.append("'");
/* 237 */           strFieldValue.append(s.getV(i));
/* 238 */           strFieldValue.append("'");
/* 239 */           bFlag = true;
/*     */         }
/* 241 */         break;
/*     */       case 4:
/* 245 */         if (s.getV(i).equals("0.0"))
/*     */           break;
/* 247 */         strFieldValue.append(s.getV(i));
/* 248 */         bFlag = true;
/*     */ 
/* 250 */         break;
/*     */       case 2:
/* 254 */         if (s.getV(i).equals("0.0"))
/*     */           break;
/* 256 */         strFieldValue.append(s.getV(i));
/* 257 */         bFlag = true;
/*     */ 
/* 259 */         break;
/*     */       case 3:
/* 263 */         if (s.getV(i).equals("0"))
/*     */           break;
/* 265 */         strFieldValue.append(s.getV(i));
/* 266 */         bFlag = true;
/*     */ 
/* 268 */         break;
/*     */       default:
/* 271 */         System.out.println("\u51FA\u73B0\u5F02\u5E38\u6570\u636E\u7C7B\u578B");
/* 272 */         bFlag = false;
/*     */       }
/*     */ 
/* 276 */       if (!bFlag)
/*     */         continue;
/* 278 */       j++;
/*     */ 
/* 280 */       if (j != 1)
/*     */       {
/* 283 */         this.WherePart.append(" and");
/*     */       }
/*     */ 
/* 287 */       this.WherePart.append(" ");
/* 288 */       this.WherePart.append(strFieldName);
/* 289 */       this.WherePart.append("=");
/* 290 */       this.WherePart.append(strFieldValue);
/*     */     }
/*     */ 
/* 293 */     if (j == 0)
/*     */     {
/* 296 */       this.WherePart.setLength(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getWherePart()
/*     */   {
/* 302 */     return this.WherePart.toString();
/*     */   }
/*     */ 
/*     */   public void setUpdPart(Schema s)
/*     */   {
/* 309 */     System.out.println("\u8FDB\u5165\u66F4\u65B0\u540E\u7684UpdPart");
/* 310 */     this.UpdPart.append("set ");
/*     */ 
/* 312 */     int nFieldCount = s.getFieldCount();
/*     */ 
/* 314 */     String strFieldName = "";
/* 315 */     StringBuffer strFieldValue = null;
/* 316 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 318 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 320 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 322 */       int nFieldType = s.getFieldType(i);
/*     */ 
/* 324 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 333 */         if (s.getV(i).equals("null"))
/*     */         {
/* 335 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 339 */           strFieldValue.append("'");
/* 340 */           strFieldValue.append(s.getV(i));
/* 341 */           strFieldValue.append("'");
/*     */         }
/* 343 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 347 */         strFieldValue.append(s.getV(i));
/*     */ 
/* 349 */         break;
/*     */       default:
/* 351 */         System.out.println("\u51FA\u73B0\u5F02\u5E38\u6570\u636E\u7C7B\u578B");
/*     */       }
/*     */ 
/* 356 */       if (i != 0)
/*     */       {
/* 359 */         this.UpdPart.append(",");
/*     */       }
/*     */ 
/* 363 */       this.UpdPart.append(strFieldName);
/* 364 */       this.UpdPart.append("=");
/* 365 */       this.UpdPart.append(strFieldValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getUpdPart()
/*     */   {
/* 371 */     return this.UpdPart.toString();
/*     */   }
/*     */ 
/*     */   public void setInsPart(Schema s)
/*     */   {
/* 377 */     System.out.println("\u8FDB\u5165\u66F4\u65B0\u540E\u7684InsPart");
/*     */ 
/* 380 */     StringBuffer ColPart = new StringBuffer(256);
/* 381 */     ColPart.append("( ");
/* 382 */     StringBuffer ValPart = new StringBuffer(256);
/* 383 */     ValPart.append("values ( ");
/*     */ 
/* 385 */     int nFieldCount = s.getFieldCount();
/* 386 */     int j = 0;
/*     */ 
/* 388 */     String strFieldName = "";
/* 389 */     StringBuffer strFieldValue = null;
/* 390 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 392 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 394 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 396 */       int nFieldType = s.getFieldType(i);
/* 397 */       boolean bFlag = false;
/* 398 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 407 */         if (s.getV(i).equals("null"))
/*     */         {
/* 409 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 413 */           strFieldValue.append("'");
/* 414 */           strFieldValue.append(s.getV(i));
/* 415 */           strFieldValue.append("'");
/* 416 */           bFlag = true;
/*     */         }
/* 418 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 422 */         strFieldValue.append(s.getV(i));
/* 423 */         bFlag = true;
/* 424 */         break;
/*     */       default:
/* 426 */         bFlag = false;
/*     */       }
/*     */ 
/* 430 */       if (!bFlag)
/*     */         continue;
/* 432 */       j++;
/*     */ 
/* 434 */       if (j != 1)
/*     */       {
/* 438 */         ColPart.append(",");
/* 439 */         ValPart.append(",");
/*     */       }
/*     */ 
/* 443 */       ColPart.append(strFieldName);
/* 444 */       ValPart.append(strFieldValue);
/*     */     }
/*     */ 
/* 449 */     ColPart.append(" )");
/* 450 */     ValPart.append(" )");
/*     */ 
/* 453 */     this.InsPart.append(ColPart);
/* 454 */     this.InsPart.append(" ");
/* 455 */     this.InsPart.append(ValPart);
/* 456 */     if (j == 0)
/*     */     {
/* 459 */       this.InsPart.setLength(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getInsPart()
/*     */   {
/* 465 */     return this.InsPart.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.SQLString
 * JD-Core Version:    0.6.0
 */