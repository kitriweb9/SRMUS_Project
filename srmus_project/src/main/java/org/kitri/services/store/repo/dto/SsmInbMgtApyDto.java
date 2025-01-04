package org.kitri.services.store.repo.dto;

public class SsmInbMgtApyDto {
    private String storeId;     // 하드코딩 "ST001" 세팅
    private String inboundId;   // 정말 필요하면
    private String goodsId;
    private int inboundQuantity;

    public SsmInbMgtApyDto() {}

    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getInboundId() {
        return inboundId;
    }
    public void setInboundId(String inboundId) {
        this.inboundId = inboundId;
    }

    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getInboundQuantity() {
        return inboundQuantity;
    }
    public void setInboundQuantity(int inboundQuantity) {
        this.inboundQuantity = inboundQuantity;
    }
}
