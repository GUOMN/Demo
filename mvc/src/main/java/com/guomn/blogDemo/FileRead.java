package com.guomn.blogDemo;

import org.apache.commons.lang.ArrayUtils;

import java.io.*;

/**
 * Created by GuoMengnan on 2018/11/5.
 */

public class FileRead {
	private final static String PATH = "C:\\Users\\guome\\Downloads\\ctt5.vcf";


	/**
	 * 从本地路径加载读取文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFile(String path) throws IOException {
		File f = new File(path);
		InputStream inputStream = new FileInputStream(f);
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		inputStream.close();
		return bos.toByteArray();
	}

	public static void main(String[] args) {
		try {
			byte[] bytes = readFile(PATH);
			String result = new String(bytes);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
