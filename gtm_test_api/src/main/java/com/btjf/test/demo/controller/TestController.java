package com.btjf.test.demo.controller;

import com.btjf.business.common.exception.BusinessException;
import com.btjf.business.freshcar.certificate.bo.CertificateBo;
import com.btjf.business.freshcar.certificate.bo.CertificateOrderListBo;
import com.btjf.business.freshcar.certificate.domain.FreshCarCertificateDomain;
import com.btjf.common.page.Page;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gantianming on 2017/9/20.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private FreshCarCertificateDomain freshCarCertificateDomain;


    @ApiModelProperty(value = "获取订单合格证信息列表", notes = "获取订单合格证信息列表")
    @RequestMapping(value = "/getOrderCertificateList", method = RequestMethod.GET)
    public List<CertificateOrderListBo> getOrderCertificateList(@ApiParam("页面大小") Integer pageSize,
                                                                @ApiParam("当前页") Integer currentPage)throws BusinessException {
        if (null == currentPage) currentPage = 0;
        if (null == pageSize) pageSize = 20;

        Page page = new Page(pageSize, currentPage + 1);
        Page<CertificateOrderListBo> certificateOrderListBoPage = freshCarCertificateDomain.findListByCustID(68697,page);
        List<CertificateOrderListBo> certificateOrderListBos = certificateOrderListBoPage.getRows();
        return certificateOrderListBos;
    }

    @ApiModelProperty(value = "获取订单合格证信息列表", notes = "获取订单合格证信息列表")
    @RequestMapping(value = "/getOrderCertificateListPost", method = RequestMethod.POST)
    public List<CertificateOrderListBo> z(@ApiParam("页面大小") Integer pageSize,
                                                                @ApiParam("当前页") Integer currentPage)throws BusinessException {
        Page page = new Page(pageSize, currentPage + 1);
        Page<CertificateOrderListBo> certificateOrderListBoPage = freshCarCertificateDomain.findListByCustID(68697,page);
        List<CertificateOrderListBo> certificateOrderListBos = certificateOrderListBoPage.getRows();
        return certificateOrderListBos;
    }


    @ApiModelProperty(value = "获取订单合格证信息列表", notes = "获取订单合格证信息列表")
    @RequestMapping(value = "/saveCertifi", method = RequestMethod.POST)
    public void saveCertifi(@ApiParam("订单id") Integer orderID,
                            @ApiParam("商品id") Integer goodsID)throws BusinessException {
        List<CertificateBo> certificateBos = Lists.newArrayList();
        CertificateBo certificateBo = new CertificateBo();
        certificateBo.setOrderID(orderID);
        certificateBo.setGoodID(goodsID);
        certificateBos.add(certificateBo);
        freshCarCertificateDomain.save(certificateBos);
    }
}
