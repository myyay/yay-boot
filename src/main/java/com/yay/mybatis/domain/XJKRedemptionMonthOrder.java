package com.yay.mybatis.domain;

import java.math.BigDecimal;
import java.util.Date;

public class XJKRedemptionMonthOrder {
    private Long id;

    private Integer version;

    private String source;

    private String channel;

    private String tradeNo;

    private String productOrderNo;

    private String custAccNo;

    private String custName;

    private String orderNo;

    private String fundCode;

    private String productCode;

    private String identityCode;

    private BigDecimal orderAmt;

    private String orderStatus;

    private Date orderDate;

    private Date tradeDate;

    private Date settleDate;

    private String isSpeed;

    private String reconStatus;

    private Date reconTime;

    private String settleStatus;

    private Date settleTime;

    private String tradeError;

    private String reconError;

    private String reconOrderNo;

    private String borrowStatus;

    private String payerMerchantNo;

    private Date createdTime;

    private Date updateTime;

    private Boolean yn;

    private String remark;

    private String createOperator;

    private String updateOperator;

    private Long partId;

    private String isPersonalAcc;

    private EmOnlineOffLineChannel tradeOnline;

    private EmAdvanceBankCode adBankCode;

    private EmAdvancePayeeCode adMoneyReturn;

    private String busiCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getProductOrderNo() {
        return productOrderNo;
    }

    public void setProductOrderNo(String productOrderNo) {
        this.productOrderNo = productOrderNo == null ? null : productOrderNo.trim();
    }

    public String getCustAccNo() {
        return custAccNo;
    }

    public void setCustAccNo(String custAccNo) {
        this.custAccNo = custAccNo == null ? null : custAccNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode == null ? null : identityCode.trim();
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getIsSpeed() {
        return isSpeed;
    }

    public void setIsSpeed(String isSpeed) {
        this.isSpeed = isSpeed == null ? null : isSpeed.trim();
    }

    public String getReconStatus() {
        return reconStatus;
    }

    public void setReconStatus(String reconStatus) {
        this.reconStatus = reconStatus == null ? null : reconStatus.trim();
    }

    public Date getReconTime() {
        return reconTime;
    }

    public void setReconTime(Date reconTime) {
        this.reconTime = reconTime;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public String getTradeError() {
        return tradeError;
    }

    public void setTradeError(String tradeError) {
        this.tradeError = tradeError == null ? null : tradeError.trim();
    }

    public String getReconError() {
        return reconError;
    }

    public void setReconError(String reconError) {
        this.reconError = reconError == null ? null : reconError.trim();
    }

    public String getReconOrderNo() {
        return reconOrderNo;
    }

    public void setReconOrderNo(String reconOrderNo) {
        this.reconOrderNo = reconOrderNo == null ? null : reconOrderNo.trim();
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus == null ? null : borrowStatus.trim();
    }

    public String getPayerMerchantNo() {
        return payerMerchantNo;
    }

    public void setPayerMerchantNo(String payerMerchantNo) {
        this.payerMerchantNo = payerMerchantNo == null ? null : payerMerchantNo.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getYn() {
        return yn;
    }

    public void setYn(Boolean yn) {
        this.yn = yn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getIsPersonalAcc() {
        return isPersonalAcc;
    }

    public void setIsPersonalAcc(String isPersonalAcc) {
        this.isPersonalAcc = isPersonalAcc == null ? null : isPersonalAcc.trim();
    }

    public EmOnlineOffLineChannel getTradeOnline() {
        return tradeOnline;
    }

    public void setTradeOnline(EmOnlineOffLineChannel tradeOnline) {
        this.tradeOnline = tradeOnline;
    }

    public EmAdvanceBankCode getAdBankCode() {
        return adBankCode;
    }

    public void setAdBankCode(EmAdvanceBankCode adBankCode) {
        this.adBankCode = adBankCode;
    }

    public EmAdvancePayeeCode getAdMoneyReturn() {
        return adMoneyReturn;
    }

    public void setAdMoneyReturn(EmAdvancePayeeCode adMoneyReturn) {
        this.adMoneyReturn = adMoneyReturn;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode == null ? null : busiCode.trim();
    }
}