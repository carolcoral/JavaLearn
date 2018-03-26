package cn.xdl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {
	
	/**
	 * 序列化方法
	 * @param obj 对象
	 * @return 字节数组
	 * @throws IOException 
	 */
	public static byte[] toSerialize(Object obj) throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		byte[] bytes = bos.toByteArray();
		oos.close();
		bos.close();
		return bytes;
	}
	
	/**
	 * 反序列化方法
	 * @param bytes 字节数组
	 * @return 对象
	 * @throws IOException 
	 */
	public static Object toObject(byte[] bytes) throws Exception{
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		bis.close();
		return obj;
	}
	
}
