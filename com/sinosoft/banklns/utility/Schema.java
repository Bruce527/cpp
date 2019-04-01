package com.sinosoft.banklns.utility;

public abstract interface Schema
{
  public static final int TYPE_NOFOUND = -1;
  public static final int TYPE_MIN = -1;
  public static final int TYPE_STRING = 0;
  public static final int TYPE_DATE = 1;
  public static final int TYPE_FLOAT = 2;
  public static final int TYPE_INT = 3;
  public static final int TYPE_DOUBLE = 4;
  public static final int TYPE_MAX = 5;

  public abstract String[] getPK();

  public abstract String getV(String paramString);

  public abstract String getV(int paramInt);

  public abstract int getFieldType(String paramString);

  public abstract int getFieldType(int paramInt);

  public abstract int getFieldCount();

  public abstract int getFieldIndex(String paramString);

  public abstract String getFieldName(int paramInt);

  public abstract boolean setV(String paramString1, String paramString2);
}

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.Schema
 * JD-Core Version:    0.6.0
 */