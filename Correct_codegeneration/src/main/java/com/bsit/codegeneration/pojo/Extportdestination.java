package com.bsit.codegeneration.pojo;

public class Extportdestination {

    private String portOfDest;

    private String description;

    public Extportdestination() {
    }

    public Extportdestination(String portOfDest, String description) {
        this.portOfDest = portOfDest;
        this.description = description;
    }

    public String getPortOfDest() {
        return portOfDest;
    }

    public void setPortOfDest(String portOfDest) {
        this.portOfDest = portOfDest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {

        private Extportdestination instance = new Extportdestination();

        public Builder portOfDest(String portOfDest) {
            instance.setPortOfDest(portOfDest);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Extportdestination build() {
            return instance;
        }
    }
}
