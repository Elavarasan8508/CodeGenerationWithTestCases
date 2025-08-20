public class RentalDto {

    private Integer rentalId;
    private java.sql.Timestamp rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private java.sql.Timestamp returnDate;
    private Integer staffId;
    private java.sql.Timestamp lastUpdate;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public java.sql.Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(java.sql.Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public java.sql.Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.sql.Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public java.sql.Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
