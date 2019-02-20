package com.yay.mybatis;

import com.yay.mybatis.domain.*;
import com.yay.mybatis.mapper.XJKPurchaseMonthOrderMapper;
import com.yay.mybatis.mapper.XJKRedemptionMonthOrderMapper;
import com.yay.utils.DateUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/6 20:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MyBatisTests {

    @Autowired
    private XJKPurchaseMonthOrderMapper xjkPurchaseMonthOrderMapper;

    @Autowired
    private XJKRedemptionMonthOrderMapper xjkRedemptionMonthOrderMapper;

    @Test
    public void testMybatis() {

        /*List<XJKPurchaseMonthOrder> list = xjkPurchaseMonthOrderMapper
                .paginationPushData("J50060000", DateUtils.parseDate("2017-03-01"), DateUtils.parseDate("2017-03-31"),0,10);

        for (XJKPurchaseMonthOrder xjkPurchaseMonthOrder : list) {
            System.out.println(JsonUtils.toJson(xjkPurchaseMonthOrder));

        }


        XJKPurchaseMonthOrder xjkPurchaseMonthOrder = xjkPurchaseMonthOrderMapper.selectByPrimaryKey(2300L);
        System.out.println(JsonUtils.toJson(xjkPurchaseMonthOrder));*/

        for (int i = 0; i < 100; i++) {

            XJKPurchaseMonthOrder purchaseOrder = createPurchaseOrder();
            xjkPurchaseMonthOrderMapper.insert(purchaseOrder);
        }
        System.out.println("插入完成");
    }

    @Test
    public void testInsert() {

        /*List<XJKPurchaseMonthOrder> list = xjkPurchaseMonthOrderMapper
                .paginationPushData("J50060000", DateUtils.parseDate("2017-03-01"), DateUtils.parseDate("2017-03-31"),0,10);

        for (XJKPurchaseMonthOrder xjkPurchaseMonthOrder : list) {
            System.out.println(JsonUtils.toJson(xjkPurchaseMonthOrder));

        }


        XJKPurchaseMonthOrder xjkPurchaseMonthOrder = xjkPurchaseMonthOrderMapper.selectByPrimaryKey(2300L);
        System.out.println(JsonUtils.toJson(xjkPurchaseMonthOrder));*/

        for (int i = 0; i < 100; i++) {

            XJKRedemptionMonthOrder redemptionOrder = createRedemptionOrder();
            xjkRedemptionMonthOrderMapper.insert(redemptionOrder);
        }
        System.out.println("插入完成");
    }

    @Test
    public void updatePurchasePage() {
        // 产品代码
        String productCode = "J50060000";
        // 结算日期
        Date settleDate = DateUtils.parseDate("2017-11-07");
        // 更新月表中的结算状态为 ： 结算完成
        //分页更新
        int i = 0;
        int pageSize = 1000;
        int updateCount = pageSize;
        while (updateCount == pageSize) {
            updateCount = xjkPurchaseMonthOrderMapper.updateSettleStatusSuccess(settleDate, productCode, i * pageSize, pageSize);
            System.out.println("更新条数：" + updateCount);
            i++;
        }
    }

    @Test
    public void updateRedemptionPage() {

    }


    private XJKPurchaseMonthOrder createPurchaseOrder() {
        XJKPurchaseMonthOrder order = new XJKPurchaseMonthOrder();

        order.setVersion(1);
        order.setSource("JDJR_PC");
        order.setChannel("JDJR_PC");
        order.setMerNo("110019914001");
        order.setCustName("小白");
        order.setCustAccNo("360000000000198398010003");
        String orderNo = RandomStringUtils.randomAlphanumeric(10) + System.currentTimeMillis();
        order.setTradeNo(orderNo);
        order.setProductOrderNo("wy" + orderNo);
        order.setOrderNo(orderNo);
        order.setFundCode("000569");
        order.setProductCode("J50060000");
        order.setIdentityCode("067739");
        order.setOrderAmt(BigDecimal.TEN);
        order.setOrderStatus("SUCCESS");
        Date date = new Date();
        order.setOrderDate(date);
        order.setTradeDate(date);
        order.setSettleDate(DateUtils.parseDate("2016-12-31"));
        order.setReconStatus("NO_RECON");
        order.setSettleStatus("NO_SETTLE");
        order.setCreatedTime(date);
        order.setUpdateTime(date);
        order.setYn((byte) 1);
        return order;

    }


    private XJKRedemptionMonthOrder createRedemptionOrder() {
        XJKRedemptionMonthOrder order = new XJKRedemptionMonthOrder();

        order.setVersion(1);
        order.setSource("JDJR_PC");
        order.setChannel("JDJR_PC");
        order.setCustName("小白");
        order.setCustAccNo("360000000000198398010003");
        order.setIsSpeed("true");
        String orderNo = RandomStringUtils.randomAlphanumeric(10) + System.currentTimeMillis();
        order.setTradeNo(orderNo);
        order.setProductOrderNo("wy" + orderNo);
        order.setOrderNo(orderNo);
        order.setFundCode("000569");
        order.setProductCode("J50060000");
        order.setIdentityCode("067739");
        order.setOrderAmt(BigDecimal.TEN);
        order.setOrderStatus("SUCCESS");
        Date date = new Date();
        order.setOrderDate(date);
        order.setTradeDate(date);
        order.setSettleDate(DateUtils.parseDate("2016-12-31"));
        order.setReconStatus("NO_RECON");
        order.setSettleStatus("NO_SETTLE");
        order.setCreatedTime(date);
        order.setUpdateTime(date);
        order.setYn(Boolean.TRUE);
        order.setBorrowStatus("BORROWED");
        order.setPayerMerchantNo(orderNo);
        order.setTradeOnline(EmOnlineOffLineChannel.online);
        order.setAdBankCode(EmAdvanceBankCode.CIB);
        order.setAdMoneyReturn(EmAdvancePayeeCode.JD);
        order.setBusiCode(order.getTradeOnline().getCode() + order.getAdBankCode().getCode() + order.getAdMoneyReturn().getCode());

        return order;

    }


}
