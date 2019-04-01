/*    */ package com.ibm.filenet.api.ce;
/*    */ 
/*    */ import com.filenet.api.collection.AccessPermissionList;
/*    */ import com.filenet.api.constants.AccessLevel;
/*    */ import com.filenet.api.constants.AccessType;
/*    */ import com.filenet.api.core.Factory.AccessPermission;
/*    */ import com.filenet.api.security.AccessPermission;
/*    */ 
/*    */ public class P8PermissionUtil
/*    */ {
/*    */   public static void addAccessPermission(AccessPermissionList apl, String granteeName, AccessType accessType, AccessLevel accessLevel)
/*    */   {
/* 13 */     AccessPermission ap = Factory.AccessPermission.createInstance();
/* 14 */     ap.set_GranteeName(granteeName);
/* 15 */     ap.set_AccessType(accessType);
/* 16 */     ap.set_AccessMask(Integer.valueOf(accessLevel.getValue()));
/* 17 */     apl.add(ap);
/*    */   }
/*    */ 
/*    */   public static void addAccessPermission(AccessPermissionList apl, String granteeName, int accessType, int accessMask)
/*    */   {
/* 22 */     AccessPermission ap = Factory.AccessPermission.createInstance();
/* 23 */     ap.set_GranteeName(granteeName);
/* 24 */     ap.set_AccessType(AccessType.getInstanceFromInt(accessType));
/* 25 */     ap.set_AccessMask(Integer.valueOf(accessMask));
/* 26 */     apl.add(ap);
/*    */   }
/*    */ 
/*    */   public static void removeAccessPermission(AccessPermissionList apl, String granteeName, String docId) {
/* 30 */     for (int i = 0; i < apl.size(); i++) {
/* 31 */       AccessPermission ap = (AccessPermission)apl.get(i);
/* 32 */       String temp = ap.get_GranteeName().split("@")[0];
/* 33 */       if ((temp.equals(granteeName)) || (ap.get_GranteeName().equals(granteeName)))
/* 34 */         apl.remove(i);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void removeAccessPermission(AccessPermissionList apl, String granteeName, AccessType accessType)
/*    */   {
/* 40 */     removeAccessPermission(apl, granteeName, accessType.getValue());
/*    */   }
/*    */ 
/*    */   public static void removeAccessPermission(AccessPermissionList apl, String granteeName, int accessType) {
/* 44 */     for (int i = 0; i < apl.size(); i++) {
/* 45 */       AccessPermission ap = (AccessPermission)apl.get(i);
/* 46 */       String temp = ap.get_GranteeName().split("@")[0];
/* 47 */       if (((temp.equals(granteeName)) || (ap.get_GranteeName().equals(granteeName))) && (ap.get_AccessType().equals(AccessType.getInstanceFromInt(accessType))))
/* 48 */         apl.remove(i);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.api.ce.P8PermissionUtil
 * JD-Core Version:    0.6.0
 */