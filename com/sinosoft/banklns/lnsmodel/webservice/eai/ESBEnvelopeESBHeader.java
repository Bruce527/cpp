/*     */ package com.sinosoft.banklns.lnsmodel.webservice.eai;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ import org.apache.axis.types.Time;
/*     */ 
/*     */ public class ESBEnvelopeESBHeader
/*     */   implements Serializable
/*     */ {
/*     */   private String ESBHdVer;
/*     */   private Date srvDate;
/*     */   private Time srvTime;
/*     */   private String senderID;
/*     */   private String receiverID;
/*     */   private String srvOpName;
/*     */   private String srvOpVer;
/*     */   private String msgID;
/*     */   private String corrID;
/*     */   private String ESBRspCode;
/*     */   private String ESBRspDec;
/*     */   private String resField1;
/*     */   private String resField2;
/*     */   private String resField3;
/*     */   private String resField4;
/*     */   private String resField5;
/* 275 */   private Object __equalsCalc = null;
/*     */ 
/* 339 */   private boolean __hashCodeCalc = false;
/*     */ 
/* 400 */   private static TypeDesc typeDesc = new TypeDesc(ESBEnvelopeESBHeader.class, true);
/*     */ 
/*     */   static {
/* 403 */     typeDesc.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelope>ESBHeader"));
/* 404 */     ElementDesc elemField = new ElementDesc();
/* 405 */     elemField.setFieldName("ESBHdVer");
/* 406 */     elemField.setXmlName(new QName("", "ESBHdVer"));
/* 407 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 408 */     elemField.setMinOccurs(0);
/* 409 */     elemField.setNillable(false);
/* 410 */     typeDesc.addFieldDesc(elemField);
/* 411 */     elemField = new ElementDesc();
/* 412 */     elemField.setFieldName("srvDate");
/* 413 */     elemField.setXmlName(new QName("", "SrvDate"));
/* 414 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "date"));
/* 415 */     elemField.setNillable(false);
/* 416 */     typeDesc.addFieldDesc(elemField);
/* 417 */     elemField = new ElementDesc();
/* 418 */     elemField.setFieldName("srvTime");
/* 419 */     elemField.setXmlName(new QName("", "SrvTime"));
/* 420 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "time"));
/* 421 */     elemField.setNillable(false);
/* 422 */     typeDesc.addFieldDesc(elemField);
/* 423 */     elemField = new ElementDesc();
/* 424 */     elemField.setFieldName("senderID");
/* 425 */     elemField.setXmlName(new QName("", "SenderID"));
/* 426 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 427 */     elemField.setMinOccurs(0);
/* 428 */     elemField.setNillable(false);
/* 429 */     typeDesc.addFieldDesc(elemField);
/* 430 */     elemField = new ElementDesc();
/* 431 */     elemField.setFieldName("receiverID");
/* 432 */     elemField.setXmlName(new QName("", "ReceiverID"));
/* 433 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 434 */     elemField.setMinOccurs(0);
/* 435 */     elemField.setNillable(false);
/* 436 */     typeDesc.addFieldDesc(elemField);
/* 437 */     elemField = new ElementDesc();
/* 438 */     elemField.setFieldName("srvOpName");
/* 439 */     elemField.setXmlName(new QName("", "SrvOpName"));
/* 440 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 441 */     elemField.setMinOccurs(0);
/* 442 */     elemField.setNillable(false);
/* 443 */     typeDesc.addFieldDesc(elemField);
/* 444 */     elemField = new ElementDesc();
/* 445 */     elemField.setFieldName("srvOpVer");
/* 446 */     elemField.setXmlName(new QName("", "SrvOpVer"));
/* 447 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 448 */     elemField.setMinOccurs(0);
/* 449 */     elemField.setNillable(false);
/* 450 */     typeDesc.addFieldDesc(elemField);
/* 451 */     elemField = new ElementDesc();
/* 452 */     elemField.setFieldName("msgID");
/* 453 */     elemField.setXmlName(new QName("", "MsgID"));
/* 454 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 455 */     elemField.setMinOccurs(0);
/* 456 */     elemField.setNillable(false);
/* 457 */     typeDesc.addFieldDesc(elemField);
/* 458 */     elemField = new ElementDesc();
/* 459 */     elemField.setFieldName("corrID");
/* 460 */     elemField.setXmlName(new QName("", "CorrID"));
/* 461 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 462 */     elemField.setMinOccurs(0);
/* 463 */     elemField.setNillable(false);
/* 464 */     typeDesc.addFieldDesc(elemField);
/* 465 */     elemField = new ElementDesc();
/* 466 */     elemField.setFieldName("ESBRspCode");
/* 467 */     elemField.setXmlName(new QName("", "ESBRspCode"));
/* 468 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 469 */     elemField.setMinOccurs(0);
/* 470 */     elemField.setNillable(false);
/* 471 */     typeDesc.addFieldDesc(elemField);
/* 472 */     elemField = new ElementDesc();
/* 473 */     elemField.setFieldName("ESBRspDec");
/* 474 */     elemField.setXmlName(new QName("", "ESBRspDec"));
/* 475 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 476 */     elemField.setMinOccurs(0);
/* 477 */     elemField.setNillable(false);
/* 478 */     typeDesc.addFieldDesc(elemField);
/* 479 */     elemField = new ElementDesc();
/* 480 */     elemField.setFieldName("resField1");
/* 481 */     elemField.setXmlName(new QName("", "ResField1"));
/* 482 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 483 */     elemField.setMinOccurs(0);
/* 484 */     elemField.setNillable(false);
/* 485 */     typeDesc.addFieldDesc(elemField);
/* 486 */     elemField = new ElementDesc();
/* 487 */     elemField.setFieldName("resField2");
/* 488 */     elemField.setXmlName(new QName("", "ResField2"));
/* 489 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 490 */     elemField.setMinOccurs(0);
/* 491 */     elemField.setNillable(false);
/* 492 */     typeDesc.addFieldDesc(elemField);
/* 493 */     elemField = new ElementDesc();
/* 494 */     elemField.setFieldName("resField3");
/* 495 */     elemField.setXmlName(new QName("", "ResField3"));
/* 496 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 497 */     elemField.setMinOccurs(0);
/* 498 */     elemField.setNillable(false);
/* 499 */     typeDesc.addFieldDesc(elemField);
/* 500 */     elemField = new ElementDesc();
/* 501 */     elemField.setFieldName("resField4");
/* 502 */     elemField.setXmlName(new QName("", "ResField4"));
/* 503 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 504 */     elemField.setMinOccurs(0);
/* 505 */     elemField.setNillable(false);
/* 506 */     typeDesc.addFieldDesc(elemField);
/* 507 */     elemField = new ElementDesc();
/* 508 */     elemField.setFieldName("resField5");
/* 509 */     elemField.setXmlName(new QName("", "ResField5"));
/* 510 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.Default_ns, "string"));
/* 511 */     elemField.setMinOccurs(0);
/* 512 */     elemField.setNillable(false);
/* 513 */     typeDesc.addFieldDesc(elemField);
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeESBHeader()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeESBHeader(String ESBHdVer, Date srvDate, Time srvTime, String senderID, String receiverID, String srvOpName, String srvOpVer, String msgID, String corrID, String ESBRspCode, String ESBRspDec, String resField1, String resField2, String resField3, String resField4, String resField5)
/*     */   {
/*  65 */     this.ESBHdVer = ESBHdVer;
/*  66 */     this.srvDate = srvDate;
/*  67 */     this.srvTime = srvTime;
/*  68 */     this.senderID = senderID;
/*  69 */     this.receiverID = receiverID;
/*  70 */     this.srvOpName = srvOpName;
/*  71 */     this.srvOpVer = srvOpVer;
/*  72 */     this.msgID = msgID;
/*  73 */     this.corrID = corrID;
/*  74 */     this.ESBRspCode = ESBRspCode;
/*  75 */     this.ESBRspDec = ESBRspDec;
/*  76 */     this.resField1 = resField1;
/*  77 */     this.resField2 = resField2;
/*  78 */     this.resField3 = resField3;
/*  79 */     this.resField4 = resField4;
/*  80 */     this.resField5 = resField5;
/*     */   }
/*     */ 
/*     */   public String getESBHdVer()
/*     */   {
/*  86 */     return this.ESBHdVer;
/*     */   }
/*     */ 
/*     */   public void setESBHdVer(String ESBHdVer)
/*     */   {
/*  92 */     this.ESBHdVer = ESBHdVer;
/*     */   }
/*     */ 
/*     */   public Date getSrvDate()
/*     */   {
/*  98 */     return this.srvDate;
/*     */   }
/*     */ 
/*     */   public void setSrvDate(Date srvDate)
/*     */   {
/* 104 */     this.srvDate = srvDate;
/*     */   }
/*     */ 
/*     */   public Time getSrvTime()
/*     */   {
/* 110 */     return this.srvTime;
/*     */   }
/*     */ 
/*     */   public void setSrvTime(Time srvTime)
/*     */   {
/* 116 */     this.srvTime = srvTime;
/*     */   }
/*     */ 
/*     */   public String getSenderID()
/*     */   {
/* 122 */     return this.senderID;
/*     */   }
/*     */ 
/*     */   public void setSenderID(String senderID)
/*     */   {
/* 128 */     this.senderID = senderID;
/*     */   }
/*     */ 
/*     */   public String getReceiverID()
/*     */   {
/* 134 */     return this.receiverID;
/*     */   }
/*     */ 
/*     */   public void setReceiverID(String receiverID)
/*     */   {
/* 140 */     this.receiverID = receiverID;
/*     */   }
/*     */ 
/*     */   public String getSrvOpName()
/*     */   {
/* 146 */     return this.srvOpName;
/*     */   }
/*     */ 
/*     */   public void setSrvOpName(String srvOpName)
/*     */   {
/* 152 */     this.srvOpName = srvOpName;
/*     */   }
/*     */ 
/*     */   public String getSrvOpVer()
/*     */   {
/* 158 */     return this.srvOpVer;
/*     */   }
/*     */ 
/*     */   public void setSrvOpVer(String srvOpVer)
/*     */   {
/* 164 */     this.srvOpVer = srvOpVer;
/*     */   }
/*     */ 
/*     */   public String getMsgID()
/*     */   {
/* 170 */     return this.msgID;
/*     */   }
/*     */ 
/*     */   public void setMsgID(String msgID)
/*     */   {
/* 176 */     this.msgID = msgID;
/*     */   }
/*     */ 
/*     */   public String getCorrID()
/*     */   {
/* 182 */     return this.corrID;
/*     */   }
/*     */ 
/*     */   public void setCorrID(String corrID)
/*     */   {
/* 188 */     this.corrID = corrID;
/*     */   }
/*     */ 
/*     */   public String getESBRspCode()
/*     */   {
/* 194 */     return this.ESBRspCode;
/*     */   }
/*     */ 
/*     */   public void setESBRspCode(String ESBRspCode)
/*     */   {
/* 200 */     this.ESBRspCode = ESBRspCode;
/*     */   }
/*     */ 
/*     */   public String getESBRspDec()
/*     */   {
/* 206 */     return this.ESBRspDec;
/*     */   }
/*     */ 
/*     */   public void setESBRspDec(String ESBRspDec)
/*     */   {
/* 212 */     this.ESBRspDec = ESBRspDec;
/*     */   }
/*     */ 
/*     */   public String getResField1()
/*     */   {
/* 218 */     return this.resField1;
/*     */   }
/*     */ 
/*     */   public void setResField1(String resField1)
/*     */   {
/* 224 */     this.resField1 = resField1;
/*     */   }
/*     */ 
/*     */   public String getResField2()
/*     */   {
/* 230 */     return this.resField2;
/*     */   }
/*     */ 
/*     */   public void setResField2(String resField2)
/*     */   {
/* 236 */     this.resField2 = resField2;
/*     */   }
/*     */ 
/*     */   public String getResField3()
/*     */   {
/* 242 */     return this.resField3;
/*     */   }
/*     */ 
/*     */   public void setResField3(String resField3)
/*     */   {
/* 248 */     this.resField3 = resField3;
/*     */   }
/*     */ 
/*     */   public String getResField4()
/*     */   {
/* 254 */     return this.resField4;
/*     */   }
/*     */ 
/*     */   public void setResField4(String resField4)
/*     */   {
/* 260 */     this.resField4 = resField4;
/*     */   }
/*     */ 
/*     */   public String getResField5()
/*     */   {
/* 266 */     return this.resField5;
/*     */   }
/*     */ 
/*     */   public void setResField5(String resField5)
/*     */   {
/* 272 */     this.resField5 = resField5;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/* 277 */     if (!(obj instanceof ESBEnvelopeESBHeader)) return false;
/* 278 */     ESBEnvelopeESBHeader other = (ESBEnvelopeESBHeader)obj;
/* 279 */     if (obj == null) return false;
/* 280 */     if (this == obj) return true;
/* 281 */     if (this.__equalsCalc != null) {
/* 282 */       return this.__equalsCalc == obj;
/*     */     }
/* 284 */     this.__equalsCalc = obj;
/*     */ 
/* 286 */     boolean _equals = 
/* 287 */       ((this.ESBHdVer == null) && (other.getESBHdVer() == null)) || (
/* 288 */       (this.ESBHdVer != null) && 
/* 289 */       (this.ESBHdVer.equals(other.getESBHdVer())) && (
/* 290 */       ((this.srvDate == null) && (other.getSrvDate() == null)) || (
/* 291 */       (this.srvDate != null) && 
/* 292 */       (this.srvDate.equals(other.getSrvDate())) && (
/* 293 */       ((this.srvTime == null) && (other.getSrvTime() == null)) || (
/* 294 */       (this.srvTime != null) && 
/* 295 */       (this.srvTime.equals(other.getSrvTime())) && (
/* 296 */       ((this.senderID == null) && (other.getSenderID() == null)) || (
/* 297 */       (this.senderID != null) && 
/* 298 */       (this.senderID.equals(other.getSenderID())) && (
/* 299 */       ((this.receiverID == null) && (other.getReceiverID() == null)) || (
/* 300 */       (this.receiverID != null) && 
/* 301 */       (this.receiverID.equals(other.getReceiverID())) && (
/* 302 */       ((this.srvOpName == null) && (other.getSrvOpName() == null)) || (
/* 303 */       (this.srvOpName != null) && 
/* 304 */       (this.srvOpName.equals(other.getSrvOpName())) && (
/* 305 */       ((this.srvOpVer == null) && (other.getSrvOpVer() == null)) || (
/* 306 */       (this.srvOpVer != null) && 
/* 307 */       (this.srvOpVer.equals(other.getSrvOpVer())) && (
/* 308 */       ((this.msgID == null) && (other.getMsgID() == null)) || (
/* 309 */       (this.msgID != null) && 
/* 310 */       (this.msgID.equals(other.getMsgID())) && (
/* 311 */       ((this.corrID == null) && (other.getCorrID() == null)) || (
/* 312 */       (this.corrID != null) && 
/* 313 */       (this.corrID.equals(other.getCorrID())) && (
/* 314 */       ((this.ESBRspCode == null) && (other.getESBRspCode() == null)) || (
/* 315 */       (this.ESBRspCode != null) && 
/* 316 */       (this.ESBRspCode.equals(other.getESBRspCode())) && (
/* 317 */       ((this.ESBRspDec == null) && (other.getESBRspDec() == null)) || (
/* 318 */       (this.ESBRspDec != null) && 
/* 319 */       (this.ESBRspDec.equals(other.getESBRspDec())) && (
/* 320 */       ((this.resField1 == null) && (other.getResField1() == null)) || (
/* 321 */       (this.resField1 != null) && 
/* 322 */       (this.resField1.equals(other.getResField1())) && (
/* 323 */       ((this.resField2 == null) && (other.getResField2() == null)) || (
/* 324 */       (this.resField2 != null) && 
/* 325 */       (this.resField2.equals(other.getResField2())) && (
/* 326 */       ((this.resField3 == null) && (other.getResField3() == null)) || (
/* 327 */       (this.resField3 != null) && 
/* 328 */       (this.resField3.equals(other.getResField3())) && (
/* 329 */       ((this.resField4 == null) && (other.getResField4() == null)) || (
/* 330 */       (this.resField4 != null) && 
/* 331 */       (this.resField4.equals(other.getResField4())) && (
/* 332 */       ((this.resField5 == null) && (other.getResField5() == null)) || (
/* 333 */       (this.resField5 != null) && 
/* 334 */       (this.resField5.equals(other.getResField5())))))))))))))))))))))))))))))))));
/* 335 */     this.__equalsCalc = null;
/* 336 */     return _equals;
/*     */   }
/*     */ 
/*     */   public synchronized int hashCode()
/*     */   {
/* 341 */     if (this.__hashCodeCalc) {
/* 342 */       return 0;
/*     */     }
/* 344 */     this.__hashCodeCalc = true;
/* 345 */     int _hashCode = 1;
/* 346 */     if (getESBHdVer() != null) {
/* 347 */       _hashCode += getESBHdVer().hashCode();
/*     */     }
/* 349 */     if (getSrvDate() != null) {
/* 350 */       _hashCode += getSrvDate().hashCode();
/*     */     }
/* 352 */     if (getSrvTime() != null) {
/* 353 */       _hashCode += getSrvTime().hashCode();
/*     */     }
/* 355 */     if (getSenderID() != null) {
/* 356 */       _hashCode += getSenderID().hashCode();
/*     */     }
/* 358 */     if (getReceiverID() != null) {
/* 359 */       _hashCode += getReceiverID().hashCode();
/*     */     }
/* 361 */     if (getSrvOpName() != null) {
/* 362 */       _hashCode += getSrvOpName().hashCode();
/*     */     }
/* 364 */     if (getSrvOpVer() != null) {
/* 365 */       _hashCode += getSrvOpVer().hashCode();
/*     */     }
/* 367 */     if (getMsgID() != null) {
/* 368 */       _hashCode += getMsgID().hashCode();
/*     */     }
/* 370 */     if (getCorrID() != null) {
/* 371 */       _hashCode += getCorrID().hashCode();
/*     */     }
/* 373 */     if (getESBRspCode() != null) {
/* 374 */       _hashCode += getESBRspCode().hashCode();
/*     */     }
/* 376 */     if (getESBRspDec() != null) {
/* 377 */       _hashCode += getESBRspDec().hashCode();
/*     */     }
/* 379 */     if (getResField1() != null) {
/* 380 */       _hashCode += getResField1().hashCode();
/*     */     }
/* 382 */     if (getResField2() != null) {
/* 383 */       _hashCode += getResField2().hashCode();
/*     */     }
/* 385 */     if (getResField3() != null) {
/* 386 */       _hashCode += getResField3().hashCode();
/*     */     }
/* 388 */     if (getResField4() != null) {
/* 389 */       _hashCode += getResField4().hashCode();
/*     */     }
/* 391 */     if (getResField5() != null) {
/* 392 */       _hashCode += getResField5().hashCode();
/*     */     }
/* 394 */     this.__hashCodeCalc = false;
/* 395 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/* 518 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 526 */     return 
/* 527 */       new BeanSerializer(
/* 528 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 536 */     return 
/* 537 */       new BeanDeserializer(
/* 538 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeESBHeader
 * JD-Core Version:    0.6.0
 */