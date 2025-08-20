package com.bsit.codegeneration.record;

public record LongTable(Long ID, String longColumn) {

    public static class Builder {

        private Long ID;

        private String longColumn;

        public Builder ID(Long ID) {
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
