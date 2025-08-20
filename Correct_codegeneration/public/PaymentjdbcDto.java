public class PaymentjdbcDto {

    private Integer paymentId;
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private String amount;
    private java.sql.Timestamp paymentDate;
    private java.sql.Timestamp lastUpdate;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public java.sql.Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(java.sql.Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public java.sql.Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
