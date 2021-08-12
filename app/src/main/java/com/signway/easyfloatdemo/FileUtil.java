package com.signway.easyfloatdemo;


import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil{
	public static String readFile(String Path){
		String laststr = "";
		if(Path == null || "".equals(Path)){
			return laststr;
		}
		File f = new File(Path);
		if(!f.exists()){
			return laststr;
		}
		BufferedReader reader = null;

		try{
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				laststr += tempString;
				Log.i("FileUtil","readFile = " + tempString);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return laststr;
	}
}
