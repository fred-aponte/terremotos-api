package com.terremotospr.beans;
/*
 * @author Wilfredo Aponte Pomales
 */
public class CashBean extends PaymentMethodBean {
    private Long amountAvailable;

    public Long getAmountAvailable() { return amountAvailable; }

    public void setAmountAvailable(Long amountAvailable) { this.amountAvailable = amountAvailable; }
}
