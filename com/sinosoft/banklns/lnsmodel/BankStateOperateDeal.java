/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public abstract class BankStateOperateDeal
/*     */   implements BankStateOperateDealIface
/*     */ {
/*     */   public boolean checkOperate(String state, String editState, int buttonType)
/*     */   {
/*  12 */     boolean flag = false;
/*  13 */     switch (buttonType) {
/*     */     case 1:
/*  15 */       flag = checkSubmitViewOperate(state, editState);
/*  16 */       break;
/*     */     case 2:
/*  18 */       flag = checkCalculateOperate(state, editState);
/*  19 */       break;
/*     */     case 3:
/*  21 */       flag = checkSendOperate(state, editState);
/*  22 */       break;
/*     */     case 4:
/*  24 */       flag = checkCancelOperate(state, editState);
/*  25 */       break;
/*     */     case 5:
/*  27 */       flag = checkResumeOperate(state, editState);
/*     */     }
/*     */ 
/*  30 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkSubmitViewOperate(String state, String editState) {
/*  34 */     boolean flag = false;
/*  35 */     String regex = "^[1]{4}\\d{6}\\d*$";
/*     */ 
/*  37 */     flag = ("01".equals(state)) && (Pattern.matches(regex, editState));
/*  38 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkCalculateOperate(String state, String editState) {
/*  42 */     boolean flag = false;
/*  43 */     String regex = "^[1]{4}\\d{2}[1]{1}[^1]{1}\\d*$";
/*     */ 
/*  47 */     flag = ("02".equals(state)) && (Pattern.matches(regex, editState));
/*  48 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkSendOperate(String state, String editState) {
/*  52 */     boolean flag = false;
/*  53 */     String regex = "^[1]{4}\\d{3}[^(0|2)]{1}[^1]{1}\\d*$";
/*     */ 
/*  55 */     flag = ("03".equals(state)) && (Pattern.matches(regex, editState));
/*  56 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkCancelOperate(String state, String editState) {
/*  60 */     boolean flag = false;
/*  61 */     String regex = "^[1]{4}\\d{4}[^1]{2}\\d*$";
/*     */ 
/*  63 */     flag = (!"06".equals(state)) && (!"05".equals(state)) && (!"01".equals(state)) && (Pattern.matches(regex, editState));
/*  64 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkResumeOperate(String state, String editState) {
/*  68 */     boolean flag = false;
/*  69 */     String regex = "^[1]{4}\\d{4}[^1]{1}[1]{1}\\d*$";
/*     */ 
/*  71 */     flag = ("05".equals(state)) && (Pattern.matches(regex, editState));
/*  72 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean checkEditOperate(String state, String editState, String sheetType, String userType, String contNo)
/*     */   {
/*  79 */     boolean flag = false;
/*  80 */     if ("0".equals(userType)) {
/*  81 */       if ((("01".equals(sheetType)) || ("02".equals(sheetType)) || ("03".equals(sheetType)) || ("04".equals(sheetType))) && 
/*  82 */         ("01".indexOf(state) >= 0))
/*     */       {
/*  84 */         flag = true;
/*     */       }
/*  86 */     } else if ("1".equals(userType)) {
/*  87 */       if (("01".equals(sheetType)) || ("02".equals(sheetType)) || ("03".equals(sheetType)) || ("04".equals(sheetType)))
/*     */       {
/*  89 */         if ("02,03,04,07".indexOf(state) >= 0)
/*  90 */           flag = true;
/*     */       }
/*  92 */     } else if (("2".equals(userType)) && 
/*  93 */       (("01".equals(sheetType)) || ("02".equals(sheetType)) || ("03".equals(sheetType)) || ("04".equals(sheetType))) && 
/*  94 */       ("01,02,03,04,07".indexOf(state) >= 0)) {
/*  95 */       flag = true;
/*     */     }
/*     */ 
/*  99 */     return flag;
/*     */   }
/*     */ 
/*     */   public List<String> infoOprate(String state, String editState, String operateType, String infoType)
/*     */   {
/* 105 */     System.out.println("BankStateOperateDeal(old)");
/* 106 */     if ("modify".equals(operateType))
/* 107 */       return addInfoOperate(state, editState, infoType);
/* 108 */     if ("delete".equals(operateType)) {
/* 109 */       return deleteInfoOperate(state, editState, infoType);
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */   private List<String> addInfoOperate(String state, String editState, String infoType)
/*     */   {
/* 116 */     String tState = state;
/* 117 */     String tEditState = "";
/* 118 */     List arrays = new ArrayList();
/* 119 */     String[] editStateArray = new String[editState.length()];
/* 120 */     for (int i = 0; i < editState.length(); i++)
/* 121 */       editStateArray[i] = editState.substring(i, i + 1);
/*     */     int infoTypeNo;
/*     */     int infoTypeNo;
/* 125 */     if (infoType.startsWith("0"))
/* 126 */       infoTypeNo = Integer.parseInt(infoType.substring(1));
/*     */     else {
/* 128 */       infoTypeNo = Integer.parseInt(infoType);
/*     */     }
/* 130 */     if (infoTypeNo <= 6) {
/* 131 */       switch (infoTypeNo) {
/*     */       case 1:
/* 133 */         editStateArray[0] = "1";
/* 134 */         break;
/*     */       case 2:
/* 136 */         editStateArray[1] = "1";
/* 137 */         break;
/*     */       case 3:
/* 139 */         editStateArray[2] = "1";
/* 140 */         break;
/*     */       case 4:
/* 142 */         editStateArray[3] = "1";
/* 143 */         break;
/*     */       case 5:
/* 145 */         editStateArray[4] = "1";
/* 146 */         break;
/*     */       case 6:
/* 148 */         editStateArray[5] = "1";
/*     */       default:
/* 151 */         break;
/*     */       } } else {
/* 152 */       int[] arry = new int[2];
/* 153 */       arry[0] = Integer.parseInt(infoType.substring(0, 1));
/* 154 */       arry[1] = Integer.parseInt(infoType.substring(1, 2));
/* 155 */       switch (arry[0]) {
/*     */       case 7:
/* 157 */         editStateArray[6] = (arry[1] > 0 ? "1" : "2");
/* 158 */         break;
/*     */       case 8:
/* 160 */         editStateArray[7] = (arry[1] > 0 ? "1" : "2");
/* 161 */         break;
/*     */       case 9:
/* 163 */         editStateArray[8] = (arry[1] > 0 ? "1" : "2");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 168 */     List list = modifySateByEditState(state, editStateArray);
/* 169 */     tState = (String)list.get(0);
/* 170 */     editStateArray = (String[])list.get(1);
/*     */ 
/* 172 */     for (int i = 0; i < editStateArray.length; i++) {
/* 173 */       tEditState = tEditState + editStateArray[i];
/*     */     }
/*     */ 
/* 176 */     arrays.add(tState);
/* 177 */     arrays.add(tEditState);
/* 178 */     return arrays;
/*     */   }
/*     */ 
/*     */   private List<String> deleteInfoOperate(String state, String editState, String infoType)
/*     */   {
/* 183 */     String tState = state;
/* 184 */     String tEditState = "";
/* 185 */     List arrays = new ArrayList();
/* 186 */     String[] editStateArray = new String[editState.length()];
/* 187 */     for (int i = 0; i < editState.length(); i++) {
/* 188 */       editStateArray[i] = editState.substring(i, i + 1);
/*     */     }
/*     */ 
/* 192 */     if (infoType.startsWith("A")) {
/* 193 */       int infoTypeNo = Integer.parseInt(infoType.substring(1));
/* 194 */       switch (infoTypeNo) {
/*     */       case 10:
/* 196 */         editStateArray[9] = "0";
/* 197 */         break;
/*     */       case 11:
/* 199 */         editStateArray[9] = "1";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 205 */     List list = modifySateByEditState(state, editStateArray);
/* 206 */     tState = (String)list.get(0);
/* 207 */     editStateArray = (String[])list.get(1);
/*     */ 
/* 209 */     for (int i = 0; i < editStateArray.length; i++) {
/* 210 */       tEditState = tEditState + editStateArray[i];
/*     */     }
/*     */ 
/* 213 */     arrays.add(tState);
/* 214 */     arrays.add(tEditState);
/* 215 */     return arrays;
/*     */   }
/*     */ 
/*     */   public List modifySateByEditState(String state, String[] editStateArry) {
/* 219 */     String tState = state;
/* 220 */     boolean tFlag = true;
/* 221 */     List list = new ArrayList();
/*     */ 
/* 223 */     if ("01".equals(state)) {
/* 224 */       for (int i = 0; i < 4; i++) {
/* 225 */         if (!"1".equals(editStateArry[i])) {
/* 226 */           tFlag = false;
/* 227 */           break;
/*     */         }
/*     */       }
/*     */ 
/* 231 */       if ((tFlag) && ("1".equals(editStateArry[6]))) tState = "02";
/*     */     }
/*     */ 
/* 234 */     if (("02".equals(state)) && ("1".equals(editStateArry[6])) && 
/* 235 */       (!"0".equals(editStateArry[7]))) {
/* 236 */       if ("1".equals(editStateArry[7])) { tState = "03";
/*     */       } else {
/* 238 */         tState = "04";
/* 239 */         editStateArry[7] = "2";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 244 */     if (("03".equals(state)) && ("1".equals(editStateArry[7])) && 
/* 245 */       (!"0".equals(editStateArry[8]))) {
/* 246 */       if ("1".equals(editStateArry[8])) { tState = "06";
/*     */       } else {
/* 248 */         tState = "07";
/* 249 */         editStateArry[8] = "2";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 254 */     if ((!"05".equals(state)) && (!"06".equals(state)) && 
/* 255 */       ("1".equals(editStateArry[9]))) {
/* 256 */       tState = "05";
/*     */     }
/*     */ 
/* 259 */     if (("05".equals(state)) && ("0".equals(editStateArry[9]))) {
/* 260 */       tState = "02";
/* 261 */       editStateArry[7] = "0";
/* 262 */       editStateArry[8] = "0";
/*     */     }
/*     */ 
/* 268 */     if ((("02".equals(state)) || ("04".equals(state))) && ("2".equals(editStateArry[7])) && (!"1".equals(editStateArry[9]))) {
/* 269 */       if ("1".equals(editStateArry[7])) {
/* 270 */         tState = "03";
/* 271 */         editStateArry[7] = "1";
/*     */       } else {
/* 273 */         tState = "04";
/* 274 */         editStateArry[7] = "2";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 279 */     if ((("02".equals(state)) || ("07".equals(state))) && ("2".equals(editStateArry[8])) && (!"1".equals(editStateArry[9]))) {
/* 280 */       if ("1".equals(editStateArry[8])) {
/* 281 */         tState = "06";
/* 282 */         editStateArry[8] = "1";
/*     */       } else {
/* 284 */         tState = "07";
/* 285 */         editStateArry[8] = "2";
/*     */       }
/*     */     }
/*     */ 
/* 289 */     list.add(tState);
/* 290 */     list.add(editStateArry);
/* 291 */     return list;
/*     */   }
/*     */ 
/*     */   public String updateEditStateDone(String editstate, int index) {
/* 295 */     String reEditState = editstate.substring(0, index - 1) + "1" + editstate.substring(index);
/* 296 */     return reEditState;
/*     */   }
/*     */ 
/*     */   public String updateEditStateUNDone(String editstate, int index) {
/* 300 */     String reEditState = editstate.substring(0, index - 1) + "0" + editstate.substring(index);
/* 301 */     return reEditState;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankStateOperateDeal
 * JD-Core Version:    0.6.0
 */