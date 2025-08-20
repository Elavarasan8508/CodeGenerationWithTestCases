package com.bsit.codegeneration.record;

public record Extportdestination(String portOfDest, String description) {

    public static class Builder {

        private String portOfDest;

        private String description;

        public Builder portOfDest(String portOfDest) {
            this.portOfDest = portOfDest;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Extportdestination build() {
            return new Extportdestination(portOfDest, description);
        }
    }
}
