package com.yay.mybatis.mapper;

import com.yay.mybatis.domain.XJKPurchaseMonthOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface XJKPurchaseMonthOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(XJKPurchaseMonthOrder record);

    int insertSelective(XJKPurchaseMonthOrder record);


    XJKPurchaseMonthOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XJKPurchaseMonthOrder record);

    int updateByPrimaryKey(XJKPurchaseMonthOrder record);

    int updateHanddingAndInitDataById(@Param("id") long id, @Param("settleDate") Date settleDate, @Param("orderStatus") String orderStatus);

    List<XJKPurchaseMonthOrder> paginationPushData(@Param("productCode") String productCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("startIndex") int startIndex, @Param("perSize") int perSize);

    List<XJKPurchaseMonthOrder> getPersonalUpdateDatas(@Param("productCode") String productCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int updateSettleStatusSuccess(@Param("settleDate") Date settleDate, @Param("productCode") String productCode,
                                  @Param("offset") Integer offset, @Param("limit") Integer limit);
}