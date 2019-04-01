/*    */ package com.sinosoft.banklns.lis.tree;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class TreeNode1
/*    */ {
/*  7 */   ArrayList childList = new ArrayList();
/*    */   OccupBean occupBean;
/*    */   int level;
/*    */   TreeNode1 parentNode;
/*    */ 
/*    */   public void addNode(TreeNode1 treeNode)
/*    */   {
/* 15 */     this.childList.add(treeNode);
/*    */   }
/*    */ 
/*    */   public ArrayList getChildList()
/*    */   {
/* 20 */     return this.childList;
/*    */   }
/*    */ 
/*    */   public void setBean(OccupBean occupBean) {
/* 24 */     this.occupBean = occupBean;
/*    */   }
/*    */ 
/*    */   public OccupBean getBean() {
/* 28 */     return this.occupBean;
/*    */   }
/*    */ 
/*    */   public boolean hasChildNode() {
/* 32 */     return this.childList.size() != 0;
/*    */   }
/*    */ 
/*    */   public void setLevel(int level) {
/* 36 */     this.level = level;
/*    */   }
/*    */ 
/*    */   public int getLevel() {
/* 40 */     return this.level;
/*    */   }
/*    */ 
/*    */   public void setParentNode(TreeNode1 parentNode)
/*    */   {
/* 45 */     this.parentNode = parentNode;
/*    */   }
/*    */ 
/*    */   public TreeNode1 getParentNode()
/*    */   {
/* 50 */     return this.parentNode;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.tree.TreeNode1
 * JD-Core Version:    0.6.0
 */