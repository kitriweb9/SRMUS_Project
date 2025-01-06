package org.kitri.services.common.file.txttoimg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.kitri.services.common.Setting;
import org.kitri.services.sales.repo.dto.ShqInbExpDto;
import org.kitri.services.store.repo.dto.SsmOrdSndDto;
import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SvcComTti {
	
	/*
	 * Type
	 *  - 0 : 본부 -> 매장
	 *  - 1 : 매장 -> 본부
	 */
	public boolean processTextToImage(Object object, int type, String storeId) {
		
		// Id 맞는 디렉토리 경로
		String directory = getDirectory(type, storeId);
		// 파일명 지정
		String filename = fileNameSave(object);
		// 텍스트를 이미지로 변환
		BufferedImage image = convertingTexttoImage(object);
		// 파일 이름 설정
		String file = directory + File.separator + filename + ".png";
		return saveImageToFile(image, file);
	}

	private String fileNameSave(Object object) {
		String filename = null;
		if (object instanceof SsmOrdSndDto) {
			SsmOrdSndDto ssmOrdSndDto = (SsmOrdSndDto) object;
			filename = "o" + ssmOrdSndDto.getOrderId();
		} else if (object instanceof SsmRtnSndDto) {
			SsmRtnSndDto ssmRtnSndDto = (SsmRtnSndDto) object;
			filename = "r" + ssmRtnSndDto.getReturnId();
		} else if (object instanceof ShqInbExpDto) {
			ShqInbExpDto shqInbExpDto = (ShqInbExpDto) object;
			filename = "i" + shqInbExpDto.getInboundId();
		} else {
			throw new IllegalArgumentException("지원되지 않는 객체 타입입니다: " + object.getClass().getName());
		}
		return filename;
	}
	
	
	private String getDirectory(int type, String storeId) {
		
		if(type == 0) { // 본부 -> 매장
			return Setting.getShqFileSendPath(storeId);
		} else if(type == 1) { // 매장 -> 본부
			return Setting.getSsmFileSendPath(storeId);
		}
		return null;
	}

	private BufferedImage convertingTexttoImage(Object object) {
		if (object instanceof SsmOrdSndDto) {
			return convertingSsmOrdSndDtoTexttoImage((SsmOrdSndDto) object);
		} else if (object instanceof SsmRtnSndDto) {
			return convertingSsmRtnSndDtoTexttoImage((SsmOrdSndDto) object);
		} else if (object instanceof ShqInbExpDto) {
			return convertingShqInbExpDtoTexttoImage((ShqInbExpDto) object);
		} else {
			throw new IllegalArgumentException("지원되지 않는 객체 타입입니다: " + object.getClass().getName());
		}
	}

	private BufferedImage convertingSsmOrdSndDtoTexttoImage(Object object) {
		SsmOrdSndDto dto = (SsmOrdSndDto) object;

		int width = 800;
		int height = 1000;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.lightGray);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Noto Sans", Font.PLAIN, 24));
		int yPosition = 50;
		yPosition += 50;
		g2d.drawString("TABLE1 = TB_SHQ_ORDER", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_STORE_ID = " + dto.getStoreId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_ORDER_ID = " + dto.getOrderId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_EMPLOYEE_ID = st001m", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_ORDER_CREATE_DATE = SYSDATE", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_ORDER_CONFIRM_STATUS = N", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2  = TB_SHQ_ORDER_DETAIL", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_ORDER_ID = " + dto.getOrderId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_GOODS_ID = " + dto.getGoodsId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_ORDER_QUANTITY = " + dto.getOrderQuantity(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.dispose();

		return image;
	}

	private BufferedImage convertingSsmRtnSndDtoTexttoImage(Object object) {
		SsmRtnSndDto dto = (SsmRtnSndDto) object;

		int width = 800;
		int height = 1000;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.lightGray);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Noto Sans", Font.PLAIN, 24));
		int yPosition = 50;
		yPosition += 50;
		g2d.drawString("TABLE1 = TB_SHQ_RETURN", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_RETURN_ID = " + dto.getReturnId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_STORE_ID = " + dto.getStoreId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_EMPLOYEE_ID = " + dto.getEmployeeId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_RETURN_REGISTER_DATE = SYSDATE", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_RETURN_STATE = " + dto.getReturnState(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2 = TB_SHQ_RETURN_DETAIL", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_RETURN_ID = " + dto.getReturnId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_GOODS_ID = " + dto.getGoodsId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_RETURN_QUANTITY = " + dto.getReturnQuantity(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.dispose();

		return image;
	}

	private BufferedImage convertingShqInbExpDtoTexttoImage(Object object) {
		ShqInbExpDto dto = (ShqInbExpDto) object;

		int width = 800;
		int height = 1000;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.lightGray);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Noto Sans", Font.PLAIN, 24));
		int yPosition = 50;
		yPosition += 50;
		g2d.drawString("TABLE1 = TB_SSM_INBOUND", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_INBOUND_ID = " + dto.getInboundId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_STORE_ID = " + dto.getStoreId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE1_INBOUND_DATE = " + dto.getInboundDate(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2 = TB_SSM_INBOUND_DETAIL", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_INBOUND_ID = " + dto.getInboundId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_GOODS_ID = " + dto.getGoodsId(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_INBOUND_QUANTITY = " + dto.getInboundQuantity(), 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.drawString("TABLE2_INBOUND_CONFIRM_STATUS = N  ", 20, yPosition);
		yPosition += 40;
		yPosition += 40;
		g2d.dispose();

		return image;
	}

	private boolean saveImageToFile(BufferedImage bufferedImage, String fileName) {
		File file = new File(fileName);
		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("이미지 저장 성공 파일 위치 : " + file.getAbsolutePath());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("이미지 저장 실패");
			return false;
		}

	}

}