package com.bsit.codegeneration.record;

public record ServicelogBk(Long ID, String service, String operation, String zone, String branch, String sourcesystem, String targetsystem, String masterreference, String eventreference, String status, String processtime, String tirequest, String tiresponse, String bankrequest, String bankresponse, String tireqtime, String bankreqtime, String bankrestime, String tirestime, String transactionkey1, String statickey1, String narrative1, String narrative2, String isresubmitted, Long resubmittedcount, String resubmittedtime, String description, String typeflag, String node, java.time.LocalDateTime valuedate, Long number1) {

    public static class Builder {

        private Long ID;

        private String service;

        private String operation;

        private String zone;

        private String branch;

        private String sourcesystem;

        private String targetsystem;

        private String masterreference;

        private String eventreference;

        private String status;

        private String processtime;

        private String tirequest;

        private String tiresponse;

        private String bankrequest;

        private String bankresponse;

        private String tireqtime;

        private String bankreqtime;

        private String bankrestime;

        private String tirestime;

        private String transactionkey1;

        private String statickey1;

        private String narrative1;

        private String narrative2;

        private String isresubmitted;

        private Long resubmittedcount;

        private String resubmittedtime;

        private String description;

        private String typeflag;

        private String node;

        private java.time.LocalDateTime valuedate;

        private Long number1;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder service(String service) {
            this.service = service;
            return this;
        }

        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }

        public Builder zone(String zone) {
            this.zone = zone;
            return this;
        }

        public Builder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder sourcesystem(String sourcesystem) {
            this.sourcesystem = sourcesystem;
            return this;
        }

        public Builder targetsystem(String targetsystem) {
            this.targetsystem = targetsystem;
            return this;
        }

        public Builder masterreference(String masterreference) {
            this.masterreference = masterreference;
            return this;
        }

        public Builder eventreference(String eventreference) {
            this.eventreference = eventreference;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder processtime(String processtime) {
            this.processtime = processtime;
            return this;
        }

        public Builder tirequest(String tirequest) {
            this.tirequest = tirequest;
            return this;
        }

        public Builder tiresponse(String tiresponse) {
            this.tiresponse = tiresponse;
            return this;
        }

        public Builder bankrequest(String bankrequest) {
            this.bankrequest = bankrequest;
            return this;
        }

        public Builder bankresponse(String bankresponse) {
            this.bankresponse = bankresponse;
            return this;
        }

        public Builder tireqtime(String tireqtime) {
            this.tireqtime = tireqtime;
            return this;
        }

        public Builder bankreqtime(String bankreqtime) {
            this.bankreqtime = bankreqtime;
            return this;
        }

        public Builder bankrestime(String bankrestime) {
            this.bankrestime = bankrestime;
            return this;
        }

        public Builder tirestime(String tirestime) {
            this.tirestime = tirestime;
            return this;
        }

        public Builder transactionkey1(String transactionkey1) {
            this.transactionkey1 = transactionkey1;
            return this;
        }

        public Builder statickey1(String statickey1) {
            this.statickey1 = statickey1;
            return this;
        }

        public Builder narrative1(String narrative1) {
            this.narrative1 = narrative1;
            return this;
        }

        public Builder narrative2(String narrative2) {
            this.narrative2 = narrative2;
            return this;
        }

        public Builder isresubmitted(String isresubmitted) {
            this.isresubmitted = isresubmitted;
            return this;
        }

        public Builder resubmittedcount(Long resubmittedcount) {
            this.resubmittedcount = resubmittedcount;
            return this;
        }

        public Builder resubmittedtime(String resubmittedtime) {
            this.resubmittedtime = resubmittedtime;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder typeflag(String typeflag) {
            this.typeflag = typeflag;
            return this;
        }

        public Builder node(String node) {
            this.node = node;
            return this;
        }

        public Builder valuedate(java.time.LocalDateTime valuedate) {
            this.valuedate = valuedate;
            return this;
        }

        public Builder number1(Long number1) {
            this.number1 = number1;
            return this;
        }

        public ServicelogBk build() {
            return new ServicelogBk(ID, service, operation, zone, branch, sourcesystem, targetsystem, masterreference, eventreference, status, processtime, tirequest, tiresponse, bankrequest, bankresponse, tireqtime, bankreqtime, bankrestime, tirestime, transactionkey1, statickey1, narrative1, narrative2, isresubmitted, resubmittedcount, resubmittedtime, description, typeflag, node, valuedate, number1);
        }
    }
}
