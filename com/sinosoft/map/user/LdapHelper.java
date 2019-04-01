/*     */ package com.sinosoft.map.user;
/*     */ 
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Hashtable;
/*     */ import javax.naming.AuthenticationException;
/*     */ import javax.naming.NamingException;
/*     */ import javax.naming.directory.BasicAttribute;
/*     */ import javax.naming.directory.DirContext;
/*     */ import javax.naming.directory.ModificationItem;
/*     */ import javax.naming.ldap.InitialLdapContext;
/*     */ import javax.naming.ldap.LdapContext;
/*     */ 
/*     */ public class LdapHelper
/*     */ {
/*     */   private LdapContext ctx;
/*     */ 
/*     */   public DirContext getCtx(String usercode, String password)
/*     */   {
/*  40 */     System.out.println("usercode-----" + usercode);
/*  41 */     System.out.println("password-----" + password);
/*     */ 
/*  43 */     ExeSQL exeSQL = new ExeSQL();
/*  44 */     SSRS ssrs1 = new SSRS();
/*  45 */     SSRS ssrs2 = new SSRS();
/*  46 */     String ldapurlSql = "select varvalue from msysvar where vartype = 'ldapurl'";
/*  47 */     String ldapprincipalSql = "select varvalue from msysvar where vartype = 'ldapprincipal'";
/*     */ 
/*  49 */     ssrs1 = exeSQL.execSQL(ldapurlSql);
/*  50 */     ssrs2 = exeSQL.execSQL(ldapprincipalSql);
/*     */ 
/*  52 */     String ldapurl = ssrs1.GetText(1, 1);
/*  53 */     String ldapprincipal = ssrs2.GetText(1, 1);
/*     */ 
/*  55 */     System.out.println("=====================LDAP=============================");
/*  56 */     System.out.println(ldapurl);
/*  57 */     System.out.println(ldapprincipal);
/*     */ 
/*  59 */     Hashtable env = new Hashtable(100);
/*  60 */     env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
/*     */ 
/*  62 */     env.put("java.naming.provider.url", ldapurl);
/*     */ 
/*  65 */     env.put("java.naming.security.principal", usercode + ldapprincipal);
/*  66 */     env.put("java.naming.security.credentials", password);
/*  67 */     env.put("java.naming.referral", "throw");
/*     */     try
/*     */     {
/*  73 */       this.ctx = new InitialLdapContext(env, null);
/*  74 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u951F\u7F34\u7678\u62F7-------1");
/*     */     } catch (AuthenticationException e) {
/*  76 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u5931\u951F\u65A4\u62F7-------2");
/*  77 */       e.printStackTrace();
/*  78 */       this.ctx = null;
/*     */     } catch (Exception e) {
/*  80 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u951F\u65A4\u62F7?--------3");
/*  81 */       e.printStackTrace();
/*  82 */       this.ctx = null;
/*     */     }
/*  84 */     return this.ctx;
/*     */   }
/*     */ 
/*     */   public DirContext getCtxSSL(String usercode, String password)
/*     */   {
/*  90 */     ExeSQL exeSQL = new ExeSQL();
/*  91 */     SSRS ssrs1 = new SSRS();
/*  92 */     SSRS ssrs2 = new SSRS();
/*  93 */     String ldapurlSql = "select varvalue from msysvar where vartype = 'ldapsslurl'";
/*  94 */     String ldapprincipalSql = "select varvalue from msysvar where vartype = 'ldapprincipal'";
/*     */ 
/*  96 */     ssrs1 = exeSQL.execSQL(ldapurlSql);
/*  97 */     ssrs2 = exeSQL.execSQL(ldapprincipalSql);
/*     */ 
/*  99 */     String ldapurl = ssrs1.GetText(1, 1);
/* 100 */     String ldapprincipal = ssrs2.GetText(1, 1);
/*     */ 
/* 102 */     System.out.println("=====================LDAP-SSL=============================");
/* 103 */     System.out.println(ldapurl);
/* 104 */     System.out.println(ldapprincipal);
/*     */ 
/* 108 */     String keystoreSql = "select varvalue from msysvar where vartype = 'keystore'";
/* 109 */     ssrs1 = exeSQL.execSQL(keystoreSql);
/* 110 */     String keystore = ssrs1.GetText(1, 1);
/* 111 */     File ff = new File(keystore);
/* 112 */     if (ff.exists())
/*     */     {
/* 114 */       System.out.println("File OK1 ===========================");
/*     */     }
/*     */ 
/* 118 */     System.setProperty("javax.net.ssl.trustStore", keystore);
/*     */ 
/* 120 */     Hashtable env = new Hashtable(100);
/*     */ 
/* 122 */     env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
/*     */ 
/* 124 */     env.put("java.naming.provider.url", ldapurl);
/*     */ 
/* 126 */     env.put("java.naming.security.authentication", "simple");
/*     */ 
/* 128 */     env.put("java.naming.security.principal", usercode + ldapprincipal);
/* 129 */     env.put("java.naming.security.credentials", password);
/* 130 */     env.put("java.naming.referral", "throw");
/* 131 */     env.put("java.naming.security.protocol", "ssl");
/*     */     try
/*     */     {
/* 136 */       this.ctx = new InitialLdapContext(env, null);
/* 137 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u951F\u7F34\u7678\u62F7-------1");
/*     */     } catch (AuthenticationException e) {
/* 139 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u5931\u951F\u65A4\u62F7-------2");
/* 140 */       e.printStackTrace();
/* 141 */       this.ctx = null;
/*     */     } catch (Exception e) {
/* 143 */       System.out.println("\u951F\u65A4\u62F7\u8BC1\u951F\u65A4\u62F7?--------3");
/* 144 */       e.printStackTrace();
/* 145 */       this.ctx = null;
/*     */     }
/* 147 */     return this.ctx;
/*     */   }
/*     */ 
/*     */   public String updatePwdLdap(String usercode, String password, String newPassword)
/*     */   {
/* 156 */     DirContext ctx = null;
/* 157 */     LdapHelper tLdapHelper = new LdapHelper();
/*     */     try
/*     */     {
/* 161 */       ctx = tLdapHelper.getCtxSSL(usercode, password);
/*     */ 
/* 163 */       if (ctx != null)
/*     */       {
/* 165 */         String newQuotedPassword = "\"" + newPassword + "\"";
/* 166 */         String oldQuotedPassword = "\"" + password + "\"";
/*     */ 
/* 168 */         byte[] newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
/* 169 */         byte[] oldUnicodePassword = oldQuotedPassword.getBytes("UTF-16LE");
/*     */ 
/* 171 */         ExeSQL exeSQL = new ExeSQL();
/* 172 */         SSRS ssrs1 = new SSRS();
/* 173 */         String ldapnameSql = "select varvalue from msysvar where vartype = 'ldapname'";
/* 174 */         ssrs1 = exeSQL.execSQL(ldapnameSql);
/* 175 */         String ldapname = ssrs1.GetText(1, 1);
/*     */ 
/* 178 */         String userName = "CN=" + usercode + "," + ldapname;
/*     */ 
/* 181 */         ModificationItem[] mods = new ModificationItem[2];
/*     */ 
/* 183 */         mods[0] = new ModificationItem(3, new BasicAttribute("unicodePwd", oldUnicodePassword));
/* 184 */         mods[1] = new ModificationItem(1, new BasicAttribute("unicodePwd", newUnicodePassword));
/*     */ 
/* 187 */         ctx.modifyAttributes(userName, mods);
/*     */ 
/* 189 */         ctx.close();
/* 190 */         return "1";
/*     */       }
/*     */ 
/* 195 */       return "2";
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 200 */       ex.printStackTrace();
/*     */       try {
/* 202 */         if (ctx != null) {
/* 203 */           ctx.close();
/* 204 */           return "3";
/*     */         }
/*     */       } catch (NamingException namingException) {
/* 207 */         namingException.printStackTrace();
/* 208 */         return "3";
/*     */       }
/*     */     }
/* 211 */     return "3";
/*     */   }
/*     */ 
/*     */   public static Calendar dateToCalendar(int date)
/*     */   {
/* 217 */     int day = date % 100;
/* 218 */     int month = date / 100 % 100 - 1;
/* 219 */     int year = date / 10000;
/* 220 */     Calendar cal = Calendar.getInstance();
/*     */ 
/* 222 */     cal.set(year, month, day);
/*     */ 
/* 226 */     return cal;
/*     */   }
/*     */ 
/*     */   public static int calendarToDate(Calendar cal) {
/* 230 */     int day = cal.get(5);
/*     */ 
/* 232 */     int month = cal.get(2) + 2;
/* 233 */     int year = cal.get(1);
/*     */ 
/* 235 */     return year * 10000 + month * 100 + day;
/*     */   }
/*     */ 
/*     */   public static String getCurrentDate()
/*     */   {
/* 241 */     Date today = new Date();
/* 242 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 243 */     String datenewformat = sdf.format(today);
/* 244 */     return datenewformat;
/*     */   }
/*     */ 
/*     */   public static String getDate(Date today)
/*     */   {
/* 250 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 251 */     String datenewformat = sdf.format(today);
/* 252 */     return datenewformat;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 260 */     long ll = Long.parseLong("128950056732968750");
/* 261 */     String qq = "128950056732968750";
/*     */ 
/* 263 */     long DateInUserDefinedFormat = ll - -717324288L;
/* 264 */     DateInUserDefinedFormat /= 10000L;
/* 265 */     Date theDate = new Date(DateInUserDefinedFormat);
/* 266 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/* 267 */     String forDate1 = formatter.format(theDate);
/*     */ 
/* 269 */     int intFormatterValue = Integer.parseInt(forDate1);
/* 270 */     Calendar cal = dateToCalendar(intFormatterValue);
/* 271 */     cal.add(5, 60);
/* 272 */     int date2 = calendarToDate(cal);
/*     */ 
/* 274 */     System.out.println(theDate);
/*     */ 
/* 279 */     int iYearsFrom1601to1970 = 369;
/* 280 */     int iDaysFrom1601to1970 = iYearsFrom1601to1970 * 365;
/* 281 */     iDaysFrom1601to1970 += iYearsFrom1601to1970 / 4;
/* 282 */     iDaysFrom1601to1970 -= 3;
/* 283 */     long iSecondsFrom1601to1970 = iDaysFrom1601to1970 * 24 * 60 * 60;
/*     */ 
/* 285 */     long iTotalSecondsSince1601 = 1010221262L;
/*     */ 
/* 287 */     long iTotalSecondsSince1970 = iTotalSecondsSince1601 - iSecondsFrom1601to1970;
/* 288 */     Date oDate = new Date(iTotalSecondsSince1970 * 1000L);
/* 289 */     System.out.println(oDate);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.LdapHelper
 * JD-Core Version:    0.6.0
 */