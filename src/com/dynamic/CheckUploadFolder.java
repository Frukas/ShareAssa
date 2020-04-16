package com.dynamic;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CheckUploadFolder {
	
	private String folderPath = "C:\\TestUpload";
	private File dir = new File(folderPath);
	private Map <String ,String> map = new HashMap<String , String>();
	private int index = 0;
	
	public Map<String ,String> checkFiles() throws UnsupportedEncodingException {
		File[] dir_contents = dir.listFiles();		
		
		for(File content : dir_contents) {
			map.put("Index"+ String.valueOf(index), content.getName());						
			index++;
		}
		map.size();
		return map;
	}
}
