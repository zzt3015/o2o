package com.zt.o2o.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.File;

public class FileUtil {
     public static String seperator = System.getProperty("file.seperator");
     private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
 			"yyyyMMddHHmmss"); // 时间格式化的格式
     private static final Random r = new Random();
     public static String getImgeBasePath(){
    	 
    	 String os = System.getProperty("os.name");
    	 String basePath = "";
    	 if(os.toLowerCase().startsWith("win")){
    		 basePath = "D:/projectdev/image/";
    	 }else{
    		 basePath = "/home/xiangzepro/";
    	 }
//    	     basePath = basePath.replace("/", seperator);
    	 return basePath;
     }

	public static String getRandomFileName() {
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数 
		String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
		return nowTimeStr + rannum;
	}
     
	public static String getShopImagePath(long shopId) {
		StringBuilder shopImagePathBuilder = new StringBuilder();
		shopImagePathBuilder.append("upload/images/item/shop/");
		shopImagePathBuilder.append(shopId);
		shopImagePathBuilder.append("/");
//		String shopImagePath = shopImagePathBuilder.toString().replace("/",
//				seperator);
		return shopImagePathBuilder.toString();
	}

	
	public static void deleteShopImg(String path){
		File filePath = new File(getImgeBasePath() + path);
		if(filePath.exists()){
			if(filePath.isDirectory()){
				File[] files =filePath.listFiles();
				for(int i=0;i<files.length;i++){
					files[i].delete();
				}
			}
			filePath.delete();
		}
	}
}
