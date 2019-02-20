package com.yay.mybatis.mapper;

import com.yay.mybatis.domain.XJKRedemptionMonthOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface XJKRedemptionMonthOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(XJKRedemptionMonthOrder record);

    XJKRedemptionMonthOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XJKRedemptionMonthOrder record);

    int updateByPrimaryKey(XJKRedemptionMonthOrder record);

    List<XJKRedemptionMonthOrder> getPersonalUpdateDatas(@Param("productCode") String productCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int updateHanddingAndInitDataById(@Param("id") long id, @Param("settleDate") Date settleDate, @Param("orderStatus") String orderStatus);


    List<XJKRedemptionMonthOrder> paginationPushData(@Param("productCode") String productCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("startIndex") int startIndex, @Param("perSize") int perSize);

    /***
     * 更新结算状态为 ‘结算成功’
     * @param settleDate
     * @param productCode
     * @return
     */
    int updateSettleStatusSuccess(@Param("settleDate") Date settleDate, @Param("productCode") String productCode,
                                  @Param("offset") Integer offset, @Param("limit") Integer limit);
}