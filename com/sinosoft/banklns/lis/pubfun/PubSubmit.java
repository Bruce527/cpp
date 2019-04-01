/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
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
/*  17 */   public CErrors mErrors = new CErrors();
/*  18 */   public Connection conn = null;
/*  19 */   private boolean commitFlag = true;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  26 */     PubSubmit pubSubmit1 = new PubSubmit();
/*     */   }
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  31 */     this.mInputData = ((VData)cInputData.clone());
/*     */ 
/*  33 */     System.out.println("Start PubSubmit Submit...");
/*  34 */     if (!saveData())
/*  35 */       return false;
/*  36 */     System.out.println("End PubSubmit Submit...");
/*     */ 
/*  38 */     this.mInputData = null;
/*  39 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean saveData()
/*     */   {
/*  47 */     System.out.println("---Start Save---");
/*     */     try
/*     */     {
/*  56 */       String action = "";
/*  57 */       String className = "";
/*  58 */       Object o = null;
/*  59 */       Object DBObject = null;
/*  60 */       Method m = null;
/*  61 */       Constructor constructor = null;
/*  62 */       Class[] parameterC = new Class[1];
/*  63 */       Object[] parameterO = new Object[1];
/*  64 */       System.out.println("mInputData.size():" + this.mInputData.size());
/*  65 */       System.out.println("mInputData :" + this.mInputData);
/*     */ 
/*  67 */       MMap map = (MMap)this.mInputData.getObjectByObjectName("MMap", 0);
/*  68 */       if ((map != null) && (map.keySet().size() != 0))
/*     */       {
/*  70 */         Set set = map.keySet();
/*     */ 
/*  72 */         for (int j = 0; j < set.size(); j++) {
/*  73 */           o = map.getOrder().get(String.valueOf(j + 1));
/*  74 */           action = (String)map.get(o);
/*  75 */           if (action != null) {
/*  76 */             System.out.println("\n" + o.getClass().getName() + " Operate DB: " + action);
/*     */ 
/*  78 */             className = o.getClass().getName();
/*  79 */             System.out.println("className :" + className);
/*  80 */             System.out.println("action :" + action);
/*     */ 
/*  82 */             if (className.endsWith("String")) {
/*  83 */               if (action.equals("UPDATE")) {
/*  84 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/*  85 */                 String tSQL = (String)o;
/*  86 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/*  87 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/*  88 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/*  90 */                 CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25");
/*  91 */                 this.conn.rollback();
/*  92 */                 this.conn.close();
/*  93 */                 return false;
/*     */               }
/*     */ 
/*  97 */               if (action.equals("DELETE")) {
/*  98 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/*  99 */                 String tSQL = (String)o;
/* 100 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 101 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 102 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/* 104 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25");
/* 105 */                 this.conn.rollback();
/* 106 */                 this.conn.close();
/* 107 */                 return false;
/*     */               }
/*     */ 
/* 111 */               if (action.equals("INSERT")) {
/* 112 */                 className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/* 113 */                 String tSQL = (String)o;
/* 114 */                 ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 115 */                 System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 116 */                 if (tExeSQL.execUpdateSQL(tSQL))
/*     */                   continue;
/* 118 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25\u539F\u56E0\uFF1A" + tExeSQL.mErrors.getError(0).errorMessage);
/* 119 */                 this.conn.rollback();
/* 120 */                 this.conn.close();
/* 121 */                 return false;
/*     */               }
/*     */ 
/*     */             }
/* 126 */             else if (className.endsWith("Schema")) {
/* 127 */               className = "com.sinosoft.banklns.lis.db." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DB";
/*     */             }
/* 129 */             else if (className.endsWith("BLSet")) {
/* 130 */               className = "com.sinosoft.banklns.lis.vdb." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("B")) + "DBSet";
/*     */             }
/* 132 */             else if (className.endsWith("Set")) {
/* 133 */               className = "com.sinosoft.banklns.lis.vdb." + className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S")) + "DBSet";
/*     */             }
/* 135 */             Class DBClass = Class.forName(className);
/*     */ 
/* 137 */             parameterC[0] = Connection.class;
/* 138 */             constructor = DBClass.getConstructor(parameterC);
/* 139 */             parameterO[0] = this.conn;
/* 140 */             DBObject = constructor.newInstance(parameterO);
/*     */ 
/* 142 */             parameterC[0] = o.getClass();
/* 143 */             if (o.getClass().getName().endsWith("Schema")) {
/* 144 */               m = DBObject.getClass().getMethod("setSchema", parameterC);
/*     */             }
/* 146 */             else if (o.getClass().getName().endsWith("Set")) {
/* 147 */               m = DBObject.getClass().getMethod("set", parameterC);
/*     */             }
/* 149 */             parameterO[0] = o;
/* 150 */             m.invoke(DBObject, parameterO);
/*     */ 
/* 152 */             if (action.equals("INSERT")) {
/* 153 */               m = DBObject.getClass().getMethod("insert", null);
/* 154 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 156 */               if (!b.booleanValue()) {
/* 157 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException1) {
/* 159 */                 }this.conn.close();
/* 160 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 161 */                 return false;
/*     */               }
/*     */             }
/* 164 */             else if (action.equals("UPDATE")) {
/* 165 */               m = DBObject.getClass().getMethod("update", null);
/* 166 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 168 */               if (!b.booleanValue()) {
/* 169 */                 CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException2) {
/* 171 */                 }this.conn.close();
/* 172 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 173 */                 return false;
/*     */               }
/*     */             }
/* 176 */             else if (action.equals("DELETE")) {
/* 177 */               m = DBObject.getClass().getMethod("delete", null);
/* 178 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 180 */               if (!b.booleanValue()) {
/* 181 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException3) {
/* 183 */                 }this.conn.close();
/* 184 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 185 */                 return false;
/*     */               }
/*     */             } else {
/* 188 */               if (!action.equals("DELETE&INSERT"))
/*     */                 continue;
/* 190 */               m = DBObject.getClass().getMethod("delete", null);
/* 191 */               Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 193 */               if (!b.booleanValue()) {
/* 194 */                 CError.buildErr(this, "\u6267\u884C\u5220\u9664\uFF0C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException4) {
/* 196 */                 }this.conn.close();
/* 197 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 198 */                 return false;
/*     */               }
/*     */ 
/* 202 */               m = DBObject.getClass().getMethod("insert", null);
/* 203 */               b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 205 */               if (!b.booleanValue()) {
/* 206 */                 CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25");
/*     */                 try { this.conn.rollback(); } catch (Exception localException5) {
/* 208 */                 }this.conn.close();
/* 209 */                 System.out.println(DBObject.getClass().getName() + " " + action + " Failed");
/* 210 */                 return false;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 216 */       if (this.commitFlag)
/*     */       {
/* 218 */         this.conn.commit();
/* 219 */         this.conn.close();
/* 220 */         System.out.println("---End Committed---");
/*     */       }
/*     */       else {
/* 223 */         System.out.println("---End Datebase Operation, but not Commit in AutoBLS---");
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 227 */       CError.buildErr(this, e.toString());
/*     */       try { this.conn.rollback(); this.conn.close(); } catch (Exception localException6) {
/* 229 */       }return false;
/*     */     }
/* 231 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.PubSubmit
 * JD-Core Version:    0.6.0
 */