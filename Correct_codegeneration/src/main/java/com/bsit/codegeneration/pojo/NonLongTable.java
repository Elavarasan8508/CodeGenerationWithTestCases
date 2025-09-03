package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class NonLongTable {

    private Integer ID;

    private java.math.BigDecimal price;

    public NonLongTable() {
    }

    public NonLongTable(Integer ID, java.math.BigDecimal price) {
        this.ID = ID;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    public static class Builder {

        private NonLongTable instance = new NonLongTable();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder price(java.math.BigDecimal price) {
            instance.setPrice(price);
            return this;
        }

        public NonLongTable build() {
            return instance;
        }
    }
}
