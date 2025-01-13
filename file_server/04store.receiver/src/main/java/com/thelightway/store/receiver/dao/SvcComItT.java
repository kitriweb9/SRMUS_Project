package com.thelightway.store.receiver.dao;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class SvcComItT {
	private final String TESS_DATA_PATH;
	
	public SvcComItT(String tessdataPath) {
		TESS_DATA_PATH = tessdataPath;
		System.out.println(tessdataPath);
	}
	public Map<String, String> extractTextFromImage(String imgpath) {
		Map<String, String> resultMap = new HashMap<String, String>();
		ITesseract tesseract = new Tesseract();
		File imageFile = new File(imgpath);
		String text = null;
		
		if (!imageFile.exists()) {
			System.out.println("이미지 파일 없음. 파일 위치 : " + imageFile.getAbsolutePath());
			return resultMap;
		}
		
		tesseract.setDatapath(TESS_DATA_PATH);
		tesseract.setLanguage("eng");


		
		try {
			text = tesseract.doOCR(imageFile);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultMap;
		}
		
		if(text != null) {
			String[] lines = text.split("\n");
			for(String line : lines) {
				String[] parts = line.split("=");
				if(parts.length == 2) {
					String key = parts[0].trim().replace("|", "I").replace("SOTE_", "STORE_");
					String value = parts[1].trim().replace("$T", "ST").replace("GD5","GDS").replace("St001m", "st001m").replaceAll("OO(\\d)", "00$1").replace("GDSOOZ", "GDS002").replace("GDSOOS", "GDS005").replace("GD8","GDS");
					resultMap.put(key, value);
				}
			}
		} else {
			System.out.println("올바른 형식이 아닙니다.");
		}

		return resultMap;
	}
}
