/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class PubSubmit
/*     */ {
/*     */   private VData mInputData;
/*  18 */   public CErrors mErrors = new CErrors();
/*  19 */   public Connection conn = null;
/*  20 */   private boolean commitFlag = true;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  27 */     PubSubmit pubSubmit1 = new PubSubmit();
/*     */   }
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  32 */     this.mInputData = ((VData)cInputData.clone());
/*     */ 
/*  34 */     System.out.println("Start PubSubmit Submit...");
/*  35 */     if (!saveData())
/*  36 */       return false;
/*  37 */     System.out.println("End PubSubmit Submit...");
/*     */ 
/*  39 */     this.mInputData = null;
/*  40 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean saveData()
/*     */   {
/*  48 */     System.out.println("---Start Save---");
/*     */     try
/*     */     {
/*  57 */       String action = "";
/*  58 */       String className = "";
/*  59 */       Object o = null;
/*  60 */       Object DBObject = null;
/*  61 */       Method m = null;
/*  62 */       Constructor constructor = null;
/*  63 */       Class[] parameterC = new Class[1];
/*  64 */       Object[] parameterO = new Object[1];
/*  65 */       System.out.println("mInputData.size():" + this.mInputData.size());
/*  66 */       System.out.println("mInputData :" + this.mInputData);
/*     */ 
/*  68 */       MMap map = (MMap)this.mInputData.getObjectByObjectName("MMap", 0);
/*  69 */       if ((map != null) && (map.keySet().size() != 0))
/*     */       {
/*  71 */         Set set = map.keySet();
/*     */ 
/*  73 */         for (int j = 0; j < set.size(); j++) {
/*  74 */           o = map.getOrder().get(String.valueOf(j + 1));
/*  75 */           action = (String)map.get(o);
/*  76 */           if (action != null) {
/*  77 */             System.out.println("\n" + o.getClass().getName() + " Operate DB: " + action);
/*     */ 
/*  79 */             className = o.getClass().getName();
/*  80 */             System.out.println("className :" + className);
/*  81 */             System.out.println("action :" + action);
/*     */ 
/*  83 */             if (className.endsWith("String")) {
/*  84 */               if (action.equals("UPDATE")) {
/*  85 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/*  86 */                 String tSQL = (String)o;
/*  87 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/*  88 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/*  89 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/*  91 */                 CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25");
/*  92 */                 this.conn.rollback();
/*  93 */                 this.conn.close();
/*  94 */                 return false;
/*     */               }
/*     */ 
/*  98 */               if (action.equals("DELETE")) {
/*  99 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/* 100 */                 String tSQL = (String)o;
/* 101 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 102 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 103 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/* 105 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25");
/* 106 */                 this.conn.rollback();
/* 107 */                 this.conn.close();
/* 108 */                 return false;
/*     */               }
/*     */ 
/* 112 */               if (action.equals("INSERT")) {
/* 113 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/* 114 */                 String tSQL = (String)o;
/* 115 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 116 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 117 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/* 119 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25\u539F\u56E0\uFF1A" + tExeSQL.mErrors.getError(0).errorMessage);
/* 120 */                 this.conn.rollback();
/* 121 */                 this.conn.close();
/* 122 */                 return false;
/*     */               }
/*     */ 
/*     */             }
/* 127 */             else if (className.endsWith("Schema")) {
/* 128 */               className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/*     */             }
/* 130 */             else if (className.endsWith("BLSet")) {
/* 131 */               className = "com.sinosoft.banklns.lis.vdb." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("B")) + "DBSet";
/*     */             }
/* 133 */             else if (className.endsWith("Set")) {
/* 134 */               className = "com.sinosoft.banklns.lis.vdb." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DBSet";
/*     */             }
/* 136 */             Class DBClass = Class.forName(className);
/*     */ 
/* 138 */             parameterC[0] = Connection.class;
/* 139 */             constructor = DBClass.getConstructor(parameterC);
/* 140 */             parameterO[0] = this.conn;
/* 141 */             DBObject = constructor.newInstance(parameterO);
/*     */ 
/* 143 */             parameterC[0] = o.getClass();
/* 144 */             if (o.getClass().getName().endsWith("Schema")) {
/* 145 */               m = DBObject.getClass().getMethod("setSchema", parameterC);
/*     */             }
/* 147 */             else if (o.getClass().getName().endsWith("Set")) {
/* 148 */               m = DBObject.getClass().getMethod("set", parameterC);
/*     */             }
/* 150 */             parameterO[0] = o;
/* 151 */             m.invoke(DBObject, parameterO);
/*     */ 
/* 153 */             if (action.equals("INSERT")) {
/* 154 */               m = DBObject.getClass().getMethod("insert", null);
/* 155 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 157 */               if (!b.booleanValue()) {
/* 158 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException1) {
/* 160 */                 }this.conn.close();
/* 161 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 162 */                 return false;
/*     */               }
/*     */             }
/* 165 */             else if (action.equals("UPDATE")) {
/* 166 */               m = DBObject.getClass().getMethod("update", null);
/* 167 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 169 */               if (!b.booleanValue()) {
/* 170 */                 CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException2) {
/* 172 */                 }this.conn.close();
/* 173 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 174 */                 return false;
/*     */               }
/*     */             }
/* 177 */             else if (action.equals("DELETE")) {
/* 178 */               m = DBObject.getClass().getMethod("delete", null);
/* 179 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 181 */               if (!b.booleanValue()) {
/* 182 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException3) {
/* 184 */                 }this.conn.close();
/* 185 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 186 */                 return false;
/*     */               }
/*     */             } else {
/* 189 */               if (!action.equals("DELETE&INSERT"))
/*     */                 continue;
/* 191 */               m = DBObject.getClass().getMethod("delete", null);
/* 192 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 194 */               if (!b.booleanValue()) {
/* 195 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\uFF0C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException4) {
/* 197 */                 }this.conn.close();
/* 198 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 199 */                 return false;
/*     */               }
/*     */ 
/* 203 */               m = DBObject.getClass().getMethod("insert", null);
/* 204 */               b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 206 */               if (!b.booleanValue()) {
/* 207 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException5) {
/* 209 */                 }this.conn.close();
/* 210 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 211 */                 return false;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 217 */       if (this.commitFlag)
/*     */       {
/* 219 */         this.conn.rollback();
/*     */ 
/* 221 */         this.conn.close();
/* 222 */         System.out.println("---End Committed---");
/*     */       }
/*     */       else {
/* 225 */         System.out.println("---End Datebase Operation, but not Commit in AutoBLS---");
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 229 */       CError.buildErr(this, e.toString());
/*     */       try { this.conn.rollback(); this.conn.close(); } catch (Exception localException6) {
/* 231 */       }return false;
/*     */     }
/* 233 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.PubSubmit
 * JD-Core Version:    0.6.0
 */