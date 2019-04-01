/*     */ package com.sinosoft.banklns.utility;
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
/*  45 */         this.mSql.append("insert into ");
/*  46 */         this.mSql.append(this.TableName);
/*  47 */         this.mSql.append(" ");
/*  48 */         this.mSql.append(this.InsPart);
/*     */       }
/*  50 */       break;
/*     */     case 2:
/*  53 */       setUpdPart(s);
/*  54 */       setPKWherePart(s);
/*  55 */       if (this.UpdPart.equals(""))
/*     */       {
/*  58 */         this.mSql.setLength(0);
/*     */       }
/*     */       else
/*     */       {
/*  62 */         this.mSql.append("update ");
/*  63 */         this.mSql.append(this.TableName);
/*  64 */         this.mSql.append(" ");
/*  65 */         this.mSql.append(this.UpdPart);
/*  66 */         this.mSql.append(" ");
/*  67 */         this.mSql.append(this.PKWherePart);
/*     */       }
/*  69 */       break;
/*     */     case 3:
/*  72 */       setWherePart(s);
/*  73 */       this.mSql.append("delete from ");
/*  74 */       this.mSql.append(this.TableName);
/*  75 */       this.mSql.append(" ");
/*  76 */       this.mSql.append(this.WherePart);
/*  77 */       break;
/*     */     case 4:
/*  80 */       setPKWherePart(s);
/*  81 */       this.mSql.append("delete from ");
/*  82 */       this.mSql.append(this.TableName);
/*  83 */       this.mSql.append(" ");
/*  84 */       this.mSql.append(this.PKWherePart);
/*  85 */       break;
/*     */     case 5:
/*  88 */       setWherePart(s);
/*  89 */       this.mSql.append("select * from ");
/*  90 */       this.mSql.append(this.TableName);
/*  91 */       this.mSql.append(" ");
/*  92 */       this.mSql.append(this.WherePart);
/*  93 */       break;
/*     */     case 6:
/*  96 */       setPKWherePart(s);
/*  97 */       this.mSql.append("select * from ");
/*  98 */       this.mSql.append(this.TableName);
/*  99 */       this.mSql.append(" ");
/* 100 */       this.mSql.append(this.PKWherePart);
/* 101 */       break;
/*     */     case 7:
/* 104 */       setWherePart(s);
/* 105 */       this.mSql.append("select count(1) from ");
/* 106 */       this.mSql.append(this.TableName);
/* 107 */       this.mSql.append(" ");
/* 108 */       this.mSql.append(this.WherePart);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getSQL()
/*     */   {
/* 115 */     System.out.println("MDESSql is : " + this.mSql.toString());
/* 116 */     return this.mSql.toString();
/*     */   }
/*     */ 
/*     */   public String getSQL(int sqlFlag, Schema s)
/*     */   {
/* 121 */     if ((sqlFlag == 5) || (sqlFlag == 6))
/*     */     {
/* 123 */       setSQL(sqlFlag, s);
/*     */     }
/*     */     else
/*     */     {
/* 128 */       this.mSql.setLength(0);
/*     */     }
/* 130 */     System.out.println("MDES Sql: " + this.mSql.toString());
/* 131 */     return this.mSql.toString();
/*     */   }
/*     */ 
/*     */   public void setPKWherePart(Schema s)
/*     */   {
/* 139 */     this.PKWherePart.append("where");
/*     */ 
/* 141 */     String[] pk = s.getPK();
/* 142 */     int n = pk.length;
/*     */ 
/* 144 */     String strFieldName = "";
/* 145 */     StringBuffer strFieldValue = null;
/* 146 */     for (int i = 0; i < n; i++)
/*     */     {
/* 148 */       strFieldName = pk[i];
/*     */ 
/* 150 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 152 */       int nFieldType = s.getFieldType(strFieldName);
/*     */ 
/* 154 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 159 */         strFieldValue.append("'");
/* 160 */         strFieldValue.append(s.getV(strFieldName));
/* 161 */         strFieldValue.append("'");
/* 162 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 166 */         strFieldValue.append(s.getV(strFieldName));
/* 167 */         break;
/*     */       default:
/* 169 */         System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u5C4A\u5E38\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD");
/*     */       }
/*     */ 
/* 173 */       if (i != 0)
/*     */       {
/* 176 */         this.PKWherePart.append(" and");
/*     */       }
/*     */ 
/* 181 */       this.PKWherePart.append(" ");
/* 182 */       this.PKWherePart.append(strFieldName);
/* 183 */       this.PKWherePart.append("=");
/* 184 */       this.PKWherePart.append(strFieldValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getPKWherePart()
/*     */   {
/* 190 */     return this.PKWherePart.toString();
/*     */   }
/*     */ 
/*     */   public void setWherePart(Schema s)
/*     */   {
/* 198 */     this.WherePart.append("where");
/*     */ 
/* 200 */     int nFieldCount = s.getFieldCount();
/* 201 */     int j = 0;
/*     */ 
/* 203 */     String strFieldName = "";
/* 204 */     StringBuffer strFieldValue = null;
/* 205 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 207 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 209 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 211 */       int nFieldType = s.getFieldType(i);
/* 212 */       boolean bFlag = false;
/*     */ 
/* 214 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 223 */         if (s.getV(i).equals("null"))
/*     */         {
/* 225 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 229 */           strFieldValue.append("'");
/* 230 */           strFieldValue.append(s.getV(i));
/* 231 */           strFieldValue.append("'");
/* 232 */           bFlag = true;
/*     */         }
/* 234 */         break;
/*     */       case 4:
/* 238 */         if (s.getV(i).equals("0.0"))
/*     */           break;
/* 240 */         strFieldValue.append(s.getV(i));
/* 241 */         bFlag = true;
/*     */ 
/* 243 */         break;
/*     */       case 2:
/* 247 */         if (s.getV(i).equals("0.0"))
/*     */           break;
/* 249 */         strFieldValue.append(s.getV(i));
/* 250 */         bFlag = true;
/*     */ 
/* 252 */         break;
/*     */       case 3:
/* 256 */         if (s.getV(i).equals("0"))
/*     */           break;
/* 258 */         strFieldValue.append(s.getV(i));
/* 259 */         bFlag = true;
/*     */ 
/* 261 */         break;
/*     */       default:
/* 264 */         System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u5C4A\u5E38\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD");
/* 265 */         bFlag = false;
/*     */       }
/*     */ 
/* 269 */       if (!bFlag)
/*     */         continue;
/* 271 */       j++;
/*     */ 
/* 273 */       if (j != 1)
/*     */       {
/* 276 */         this.WherePart.append(" and");
/*     */       }
/*     */ 
/* 280 */       this.WherePart.append(" ");
/* 281 */       this.WherePart.append(strFieldName);
/* 282 */       this.WherePart.append("=");
/* 283 */       this.WherePart.append(strFieldValue);
/*     */     }
/*     */ 
/* 286 */     if (j == 0)
/*     */     {
/* 289 */       this.WherePart.setLength(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getWherePart()
/*     */   {
/* 295 */     return this.WherePart.toString();
/*     */   }
/*     */ 
/*     */   public void setUpdPart(Schema s)
/*     */   {
/* 303 */     this.UpdPart.append("set ");
/*     */ 
/* 305 */     int nFieldCount = s.getFieldCount();
/*     */ 
/* 307 */     String strFieldName = "";
/* 308 */     StringBuffer strFieldValue = null;
/* 309 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 311 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 313 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 315 */       int nFieldType = s.getFieldType(i);
/*     */ 
/* 317 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 326 */         if (s.getV(i).equals("null"))
/*     */         {
/* 328 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 332 */           strFieldValue.append("'");
/* 333 */           strFieldValue.append(s.getV(i));
/* 334 */           strFieldValue.append("'");
/*     */         }
/* 336 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 340 */         strFieldValue.append(s.getV(i));
/*     */ 
/* 343 */         break;
/*     */       default:
/* 345 */         System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u5C4A\u5E38\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD");
/*     */       }
/*     */ 
/* 350 */       if (i != 0)
/*     */       {
/* 353 */         this.UpdPart.append(",");
/*     */       }
/*     */ 
/* 357 */       this.UpdPart.append(strFieldName);
/* 358 */       this.UpdPart.append("=");
/* 359 */       this.UpdPart.append(strFieldValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getUpdPart()
/*     */   {
/* 365 */     return this.UpdPart.toString();
/*     */   }
/*     */ 
/*     */   public void setInsPart(Schema s)
/*     */   {
/* 374 */     StringBuffer ColPart = new StringBuffer(256);
/* 375 */     ColPart.append("( ");
/* 376 */     StringBuffer ValPart = new StringBuffer(256);
/* 377 */     ValPart.append("values ( ");
/*     */ 
/* 379 */     int nFieldCount = s.getFieldCount();
/* 380 */     int j = 0;
/*     */ 
/* 382 */     String strFieldName = "";
/* 383 */     StringBuffer strFieldValue = null;
/* 384 */     for (int i = 0; i < nFieldCount; i++)
/*     */     {
/* 386 */       strFieldName = s.getFieldName(i);
/*     */ 
/* 388 */       strFieldValue = new StringBuffer(100);
/*     */ 
/* 390 */       int nFieldType = s.getFieldType(i);
/* 391 */       boolean bFlag = false;
/* 392 */       switch (nFieldType)
/*     */       {
/*     */       case 0:
/*     */       case 1:
/* 401 */         if (s.getV(i).equals("null"))
/*     */         {
/* 403 */           strFieldValue.append(s.getV(i));
/*     */         }
/*     */         else
/*     */         {
/* 407 */           strFieldValue.append("'");
/* 408 */           strFieldValue.append(s.getV(i));
/* 409 */           strFieldValue.append("'");
/* 410 */           bFlag = true;
/*     */         }
/* 412 */         break;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 416 */         strFieldValue.append(s.getV(i));
/* 417 */         bFlag = true;
/* 418 */         break;
/*     */       default:
/* 420 */         bFlag = false;
/*     */       }
/*     */ 
/* 425 */       if (!bFlag)
/*     */         continue;
/* 427 */       j++;
/*     */ 
/* 429 */       if (j != 1)
/*     */       {
/* 433 */         ColPart.append(",");
/* 434 */         ValPart.append(",");
/*     */       }
/*     */ 
/* 438 */       ColPart.append(strFieldName);
/* 439 */       ValPart.append(strFieldValue);
/*     */     }
/*     */ 
/* 444 */     ColPart.append(" )");
/* 445 */     ValPart.append(" )");
/*     */ 
/* 448 */     this.InsPart.append(ColPart);
/* 449 */     this.InsPart.append(" ");
/* 450 */     this.InsPart.append(ValPart);
/* 451 */     if (j == 0)
/*     */     {
/* 454 */       this.InsPart.setLength(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getInsPart()
/*     */   {
/* 460 */     return this.InsPart.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.SQLString
 * JD-Core Version:    0.6.0
 */