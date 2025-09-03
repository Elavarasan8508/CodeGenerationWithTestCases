package com.bsit.codegeneration.record;

import java.util.List;

public record LongTable(Integer ID, String longColumn) {

    public static class Builder {

        private Integer ID;

        private String longColumn;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder longColumn(String longColumn) {
            this.longColumn = longColumn;
            return this;
        }

        public LongTable build() {
            return new LongTable(ID, longColumn);
        }
    }
}
