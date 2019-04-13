package com.gopaoedu.strategyPattern.pay;

public class PayResult {

    private String code;
    private String data;
    private String message;

    public PayResult(String code, String data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 支付结果的显示
     * @return
     */
    @Override
    public String toString() {
        return ("支付状态：[" + code + "]" + ",交易详情：" + data + ","+message);
    }
}
