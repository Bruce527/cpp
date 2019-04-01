/*     */ package com.sinosoft.map.user;
/*     */ 
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.naming.NamingEnumeration;
/*     */ import javax.naming.directory.Attribute;
/*     */ import javax.naming.directory.Attributes;
/*     */ import javax.naming.directory.DirContext;
/*     */ import javax.naming.directory.SearchControls;
/*     */ import javax.naming.directory.SearchResult;
/*     */ 
/*     */ public class ADValidate
/*     */ {
/*     */   private static DirContext ctx;
/*     */ 
/*     */   public ADUser CheckUser(ADUser aduser)
/*     */   {
/*  28 */     ADUser resultADUser = new ADUser();
/*     */ 
/*  30 */     DirContext ctx = null;
/*     */     try
/*     */     {
/*  35 */       LdapHelper tLdapHelper = new LdapHelper();
/*     */ 
/*  37 */       ctx = tLdapHelper.getCtx(aduser.getUserCode(), aduser.getPassWord());
/*     */ 
/*  39 */       if (ctx != null)
/*     */       {
/*  41 */         System.out.println("\u8BA4\u8BC1\u6210\u529F-----1");
/*     */ 
/*  43 */         SearchControls constraints = new SearchControls();
/*  44 */         constraints.setSearchScope(2);
/*     */ 
/*  47 */         String cnStr = "cn=" + aduser.getUserCode();
/*  48 */         System.out.println("cnStr-----" + cnStr);
/*     */ 
/*  51 */         ExeSQL exeSQL = new ExeSQL();
/*  52 */         SSRS ssrs1 = new SSRS();
/*  53 */         String ldapsearchSql = "select varvalue from msysvar where vartype = 'ldapsearch'";
/*  54 */         ssrs1 = exeSQL.execSQL(ldapsearchSql);
/*  55 */         NamingEnumeration en = ctx.search(ssrs1.GetText(1, 1), cnStr, constraints);
/*     */ 
/*  58 */         System.out.println(en.hasMoreElements() + "---------");
/*     */ 
/*  60 */         if ((en != null) && (en.hasMoreElements()))
/*     */         {
/*  62 */           Object obj = en.nextElement();
/*  63 */           if ((obj instanceof SearchResult)) {
/*  64 */             SearchResult si = (SearchResult)obj;
/*  65 */             Attributes attrs = si.getAttributes();
/*  66 */             if (attrs == null) {
/*  67 */               System.out.println("No   attributes");
/*  68 */               return null;
/*     */             }
/*     */ 
/*  73 */             resultADUser.setUserCode(aduser.getUserCode());
/*     */ 
/*  75 */             Attribute attr = attrs.get("pwdLastSet");
/*  76 */             Object o = attr.get();
/*  77 */             System.out.println(o);
/*     */ 
/*  79 */             String pwd = (String)o;
/*  80 */             long lpwd = Long.parseLong(pwd);
/*     */ 
/*  83 */             int iYearsFrom1601to1970 = 369;
/*  84 */             int iDaysFrom1601to1970 = iYearsFrom1601to1970 * 365;
/*  85 */             iDaysFrom1601to1970 += iYearsFrom1601to1970 / 4;
/*  86 */             iDaysFrom1601to1970 -= 3;
/*  87 */             long iSecondsFrom1601to1970 = iDaysFrom1601to1970 * 24 * 60 * 60;
/*     */ 
/*  89 */             long iTotalSecondsSince1601 = (int)(lpwd / 10000000L);
/*     */ 
/*  91 */             long iTotalSecondsSince1970 = iTotalSecondsSince1601 - iSecondsFrom1601to1970;
/*  92 */             Date oDate = new Date(iTotalSecondsSince1970 * 1000L);
/*     */ 
/*  94 */             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  95 */             String rdate = sdf.format(oDate);
/*     */ 
/*  97 */             System.out.println("setPwdLastSetDate--------------------------" + rdate);
/*     */ 
/* 100 */             resultADUser.setPwdLastSetDate(rdate);
/* 101 */             resultADUser.setLogin(true);
/*     */ 
/* 103 */             return resultADUser;
/*     */           }
/*     */ 
/* 108 */           return null;
/*     */         }
/*     */ 
/* 111 */         ctx.close();
/*     */       }
/*     */       else
/*     */       {
/* 115 */         return null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 120 */       ex.printStackTrace();
/* 121 */       return null;
/*     */     }
/*     */ 
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */   public String ChangePassWord(ADUser adUser)
/*     */   {
/* 130 */     LdapHelper tLdapHelper = new LdapHelper();
/* 131 */     String result = tLdapHelper.updatePwdLdap(adUser.getUserCode(), adUser.getPassWord(), adUser.getNewPassWord());
/*     */ 
/* 133 */     if (result != null)
/*     */     {
/* 135 */       return result;
/*     */     }
/*     */ 
/* 139 */     return "3";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.ADValidate
 * JD-Core Version:    0.6.0
 */