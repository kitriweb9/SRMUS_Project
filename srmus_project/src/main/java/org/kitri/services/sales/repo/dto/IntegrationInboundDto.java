package org.kitri.services.sales.repo.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class IntegrationInboundDto {
	private String inboundDate;
	private String goodsId;
	private String goodsName;
	private int inboundQty;
	private String confirmStatus;
	private String updateDate;
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public IntegrationInboundDto setInboundDate(Timestamp inboundDate) {
        this.inboundDate = inboundDate != null ? formatter.format(inboundDate) : null;
		return this;
	}

	public String getInboundDate() {
		return inboundDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public IntegrationInboundDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getInboundQty() {
		return inboundQty;
	}

	public IntegrationInboundDto setInboundQty(int inboundQty) {
		this.inboundQty = inboundQty;
		return this;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public IntegrationInboundDto setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
		return this;
	}

	public String getUpdateDate() {
        return updateDate;
    }

	public IntegrationInboundDto setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate != null ? formatter.format(updateDate) : null;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public IntegrationInboundDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}
}
