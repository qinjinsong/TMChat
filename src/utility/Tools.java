package utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tools
{	
	public static byte[] getBytes(short data)
	{
		byte[] result = new byte[2];
		result[0] = (byte)((data & 0xff00) >> 8);
		result[1] = (byte)(data & 0xff);
		return result;
	}
	public static byte[] getBytes(char data)
	{
		byte[] result = new byte[2];
		result[0] = (byte)(data >> 8);
		result[1] = (byte)(data);
		return result;
	}
	public static byte[] getBytes(boolean data)
	{
		byte[] result = new byte[1];
		result[0] = (byte)(data ? 1 : 0);
		return result;
	}
	public static byte[] getBytes(int data)
	{
		byte[] result = new byte[4];
		result[0] = (byte) ((data & 0xff000000) >> 24);
		result[1] = (byte) ((data & 0xff0000) >> 16);
		result[2] = (byte) ((data & 0xff00) >> 8);
		result[3] = (byte) (data & 0xff);
		return result;
	}
	public static byte[] getBytes(long data)
	{
        byte[] result = new byte[8];
        result[0] = (byte) ((data >> 56) & 0xff);
        result[1] = (byte) ((data >> 48) & 0xff);
        result[2] = (byte) ((data >> 40) & 0xff);
        result[3] = (byte) ((data >> 32) & 0xff);
        result[4] = (byte) ((data >> 24) & 0xff);
        result[5] = (byte) ((data >> 16) & 0xff);
        result[6] = (byte) ((data >> 8) & 0xff);
        result[7] = (byte) (data & 0xff);
        return result;
    }
	 public static byte[] getBytes(float data)
	 {
	        int intBits = Float.floatToIntBits(data);
	        return getBytes(intBits);
	 }
	 public static byte[] getBytes(double data)
	 {
	        long longBits = Double.doubleToLongBits(data);
	        return getBytes(longBits);
     }
	 public static byte[] getBytes(String data)
	 {
		 if(data == null || data == "")
			 return null;
		 return data.getBytes();
	 }
	 public static byte[] getBytes(Object data)
	 {
		 byte[] result = null;
		 ByteArrayOutputStream bo = new ByteArrayOutputStream();
		 ObjectOutputStream oo = null;
		 try 
		 {
			 oo = new ObjectOutputStream(bo);
			 oo.writeObject(data);
			 result = bo.toByteArray();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 try {
				 bo.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
			 try {
				 oo.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }
	 public static boolean byte2Boolean(byte[] data)
	 {
		 return data[0] == 1;
	 }
	 public static short byte2Short(byte[] data)
	 {
		 return (short)((0xff00 & (data[0] << 8)) | (0xff & data[1]));
	 }
	 public static char byte2Char(byte[] data)
	 {
		 return (char)((0xff00 & (data[0] << 8)) | (0xff & data[1]));
	 }
	 public static int getInt(byte[] data)
	 {
	     return (0xff000000 & (data[0] << 24) |
	    		(0xff0000 & (data[1] << 16)) | 
	    		(0xff00 & (data[2] << 8)) |
	    		(0xff & data[3]));
	 }
	 public static long getLong(byte[] data)
	 {
         return (0xff00000000000000L & ((long) data[0] << 56) |
        	    (0xff000000000000L & ((long) data[1] << 48)) |
        	    (0xff0000000000L & ((long) data[2] << 40)) |
        	    (0xff00000000L & ((long) data[3] << 32)) |
        	    (0xff000000L & ((long) data[4] << 24)) |
        	    (0xff0000L & ((long) data[5] << 16)) |
        	    (0xff00L & ((long) data[6] << 8)) |
        	    (0xffL & (long) data[7]));
	 }
	 public static float getFloat(byte[] data)
	 {
         return Float.intBitsToFloat(getInt(data));
     }
	 public static double getDouble(byte[] data)
	 {
	     long value = getLong(data);
	     return Double.longBitsToDouble(value);
     }
	 public static String byte2String(byte[] data)
	 {
		 if(data == null)
			 return null;
		 return new String(data);
	 }
	 public static Object byte2Object(byte[] data)
	 {
		 Object result = null;
		 ByteArrayInputStream bi = new ByteArrayInputStream(data);
		 ObjectInputStream oi = null;
		 try
		 {
			 oi = new ObjectInputStream(bi);
			 result = oi.readObject();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 try {
				 bi.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
			 try {
				 oi.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }
}
