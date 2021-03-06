package com.terremotospr.database.entities.paymentEntities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/26/2020
 */
public class PaysId implements Serializable {

    private Long paymentId;
    private Long orderId;

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysId paysId = (PaysId) o;
        return Objects.equals(paymentId, paysId.paymentId) &&
                Objects.equals(orderId, paysId.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, orderId);
    }
}
