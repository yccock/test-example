package com.test;

import com.test.tools.util.JsonParse;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() throws Exception {
        String str = "{\"totalCount\":3697,\"current\":1,\"orderList\":[{\"orderId\":76120037,\"venderId\":134466,\"orderCreateTime\":\"2018-05-18 10:19\",\"paymentConfirmTime\":null,\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":27415591090,\"skuName\":\"test2 测试商品，请勿购买！ 浅黄色 默认1\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/27415591090.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"货到付款\",\"shouldPay\":5.01,\"freight\":5.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"wangsulan11\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":false,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":true,\"canWaitInnerShip\":true},{\"orderId\":7967210322,\"venderId\":4766,\"orderCreateTime\":\"2018-05-17 10:29\",\"paymentConfirmTime\":\"2018-05-17 10:37\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"xukenan198_m\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"(删除)等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":true,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":true,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":7952218619,\"venderId\":4766,\"orderCreateTime\":\"2018-05-17 10:18\",\"paymentConfirmTime\":\"2018-05-17 10:21\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试 请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"xukenan198_m\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"(删除)等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":751160688,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 20:13\",\"paymentConfirmTime\":\"2018-05-16 20:14\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试   请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"xukenan198_m\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"(删除)等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":true,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":true,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":942240345,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 18:33\",\"paymentConfirmTime\":\"2018-05-16 18:34\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"test_pop_sop\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[{\"logiCoprId\":2087,\"logiCoprName\":\"快递\",\"logiNoList\":[\"VA43927418872\"]}],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"等待确认收货\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":7394715,\"venderId\":4568,\"orderCreateTime\":\"2018-05-16 17:29\",\"paymentConfirmTime\":\"2018-05-16 17:29\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":2082490,\"skuName\":\"testtest1 wq UI自动化测试请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"yunyingshang011\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"(删除)等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":true,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":true,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":false,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":true,\"canWaitInnerShip\":true},{\"orderId\":740290105,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 17:26\",\"paymentConfirmTime\":\"2018-05-16 17:27\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试 请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"test_pop_sop\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[{\"logiCoprId\":2087,\"logiCoprName\":\"快递\",\"logiNoList\":[\"VA42952344142\"]}],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"等待确认收货\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":946296851,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 17:08\",\"paymentConfirmTime\":\"2018-05-16 17:08\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"test_pop_sop\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":true,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":false,\"canWaitInnerShip\":true},{\"orderId\":945880816,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 17:00\",\"paymentConfirmTime\":null,\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试  请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"货到付款\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"test_pop_sop\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":false,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":false,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":false,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":true,\"canWaitInnerShip\":true},{\"orderId\":944875516,\"venderId\":4766,\"orderCreateTime\":\"2018-05-16 16:15\",\"paymentConfirmTime\":\"2018-05-16 16:15\",\"orderCompleteTime\":null,\"orderItems\":[{\"wareId\":null,\"skuId\":20824902802,\"skuName\":\"testtest1 wq UI自动化测试   请勿修改！！！！ 深红色\",\"huoHao\":null,\"TestPrice\":0.01,\"skuNum\":1,\"skuImg\":null,\"url\":\"//item.test.com/20824902802.html\",\"serviceName\":\"\"}],\"paymentTypeName\":\"在线支付\",\"shouldPay\":0.01,\"freight\":0.0,\"serviceFee\":null,\"commission\":null,\"couponFlag\":false,\"userPin\":\"yunyingshang011\",\"userRemark\":null,\"consigneeInfo\":null,\"logiFlag\":true,\"logisticsInfos\":[],\"storeName\":\"全国仓\",\"codDT\":null,\"scDT\":null,\"orderStatusStrCN\":\"(删除)等待出库\",\"orderType\":22,\"customsModel\":null,\"customsName\":null,\"pauseTypeStrCN\":null,\"isDivShow\":true,\"isPhoneOrder\":false,\"isReturnOrder\":false,\"isPreSaleOrder\":false,\"isVenderSplitOrder\":false,\"isAuctionOrder\":false,\"isLargeAmountOrder\":false,\"isMicroShopOrder\":false,\"isRuralPromotionOrder\":false,\"isHkMacaoOrder\":false,\"isTaiWanOrder\":false,\"isOverseasOrder\":false,\"isDistributionOrder\":false,\"isTestDeliveryOrder\":true,\"isEclpOrder\":false,\"isYiPanHuoOrder\":false,\"isJingZunDaOrder\":false,\"isBrandMall\":false,\"bizLinkVo\":{\"showModifyFee\":true,\"showSingleOut\":true,\"showModifyAddr\":true,\"showDelayDeliveryRemind\":true,\"showSplitOrder\":true,\"showMoreLogisticsDelivery\":true,\"showMergeDelivery\":true,\"showInfoCheck\":true,\"showLivingAuth\":true},\"isOut\":true,\"isMultiLogisticsOutShow\":false,\"paimaiOrder\":0,\"cannotModifyProvinceAndCity\":true,\"canWaitInnerShip\":true}]}";
        JsonParse jsonParse = new JsonParse();
        Long start = System.currentTimeMillis();
        System.out.println(jsonParse.fastJsonParse(str));
        System.out.println(System.currentTimeMillis() - start);

        Long start2 = System.currentTimeMillis();
        System.out.println(jsonParse.gsonParse(str));
        System.out.println(System.currentTimeMillis() - start2);

        Long start3 = System.currentTimeMillis();
        System.out.println(jsonParse.jacksonParse(str));
        System.out.println(System.currentTimeMillis() - start3);
    }


}
