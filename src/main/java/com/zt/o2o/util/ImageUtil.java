package com.zt.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

	public static String generateThumbnail(MultipartFile thumbnail, String targetAddr, String fileName) {

		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;

		File dest = new File(FileUtil.getImgeBasePath() + relativeAddr);
		try {
//			Thumbnails.of(( (MultipartFile) thumbnail).getInputStream()).size(200, 200).outputQuality(0.25f)
//					.toFile(dest);
			
			thumbnail.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  relativeAddr;
	}

	private static void makeDirPath(String targetAddr) {

		String dest = FileUtil.getImgeBasePath() + targetAddr;
		File fileDest = new File(dest);
		if (!fileDest.exists()) {
			fileDest.mkdirs();
		}

	}

	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	public static void main(String[] args) throws IOException {
		System.out.println(basePath);
		Thumbnails.of(new File("E:/456.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/123.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("D:\\image");
		
	}
}
