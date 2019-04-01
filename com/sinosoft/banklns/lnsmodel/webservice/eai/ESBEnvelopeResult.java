/*     */ package com.sinosoft.banklns.lnsmodel.webservice.eai;
/*     */ 
/*     */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*     */ import java.io.Serializable;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ 
/*     */ public class ESBEnvelopeResult
/*     */   implements Serializable
/*     */ {
/*     */   private ESBEnvelopeResultESBHeader ESBHeader;
/*     */   private ESBEnvelopeResultMsgBody msgBody;
/*  51 */   private Object __equalsCalc = null;
/*     */ 
/*  73 */   private boolean __hashCodeCalc = false;
/*     */ 
/*  92 */   private static TypeDesc typeDesc = new TypeDesc(ESBEnvelopeResult.class, true);
/*     */ 
/*     */   static {
/*  95 */     typeDesc.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">ESBEnvelopeResult"));
/*  96 */     ElementDesc elemField = new ElementDesc();
/*  97 */     elemField.setFieldName("ESBHeader");
/*  98 */     elemField.setXmlName(new QName("", "ESBHeader"));
/*  99 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelopeResult>ESBHeader"));
/* 100 */     elemField.setMinOccurs(0);
/* 101 */     elemField.setNillable(false);
/* 102 */     typeDesc.addFieldDesc(elemField);
/* 103 */     elemField = new ElementDesc();
/* 104 */     elemField.setFieldName("msgBody");
/* 105 */     elemField.setXmlName(new QName("", "MsgBody"));
/* 106 */     elemField.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelopeResult>MsgBody"));
/* 107 */     elemField.setMinOccurs(0);
/* 108 */     elemField.setNillable(false);
/* 109 */     typeDesc.addFieldDesc(elemField);
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeResult()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeResult(ESBEnvelopeResultESBHeader ESBHeader, ESBEnvelopeResultMsgBody msgBody)
/*     */   {
/*  23 */     this.ESBHeader = ESBHeader;
/*  24 */     this.msgBody = msgBody;
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeResultESBHeader getESBHeader()
/*     */   {
/*  30 */     return this.ESBHeader;
/*     */   }
/*     */ 
/*     */   public void setESBHeader(ESBEnvelopeResultESBHeader ESBHeader)
/*     */   {
/*  36 */     this.ESBHeader = ESBHeader;
/*     */   }
/*     */ 
/*     */   public ESBEnvelopeResultMsgBody getMsgBody()
/*     */   {
/*  42 */     return this.msgBody;
/*     */   }
/*     */ 
/*     */   public void setMsgBody(ESBEnvelopeResultMsgBody msgBody)
/*     */   {
/*  48 */     this.msgBody = msgBody;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/*  53 */     if (!(obj instanceof ESBEnvelopeResult)) return false;
/*  54 */     ESBEnvelopeResult other = (ESBEnvelopeResult)obj;
/*  55 */     if (obj == null) return false;
/*  56 */     if (this == obj) return true;
/*  57 */     if (this.__equalsCalc != null) {
/*  58 */       return this.__equalsCalc == obj;
/*     */     }
/*  60 */     this.__equalsCalc = obj;
/*     */ 
/*  62 */     boolean _equals = 
/*  63 */       ((this.ESBHeader == null) && (other.getESBHeader() == null)) || (
/*  64 */       (this.ESBHeader != null) && 
/*  65 */       (this.ESBHeader.equals(other.getESBHeader())) && (
/*  66 */       ((this.msgBody == null) && (other.getMsgBody() == null)) || (
/*  67 */       (this.msgBody != null) && 
/*  68 */       (this.msgBody.equals(other.getMsgBody())))));
/*  69 */     this.__equalsCalc = null;
/*  70 */     return _equals;
/*     */   }
/*     */ 
/*     */   public synchronized int hashCode()
/*     */   {
/*  75 */     if (this.__hashCodeCalc) {
/*  76 */       return 0;
/*     */     }
/*  78 */     this.__hashCodeCalc = true;
/*  79 */     int _hashCode = 1;
/*  80 */     if (getESBHeader() != null) {
/*  81 */       _hashCode += getESBHeader().hashCode();
/*     */     }
/*  83 */     if (getMsgBody() != null) {
/*  84 */       _hashCode += getMsgBody().hashCode();
/*     */     }
/*  86 */     this.__hashCodeCalc = false;
/*  87 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/* 114 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 122 */     return 
/* 123 */       new BeanSerializer(
/* 124 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 132 */     return 
/* 133 */       new BeanDeserializer(
/* 134 */       _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResult
 * JD-Core Version:    0.6.0
 */