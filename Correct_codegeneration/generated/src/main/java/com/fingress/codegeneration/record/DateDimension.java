package com.bsit.codegeneration.record;

public record DateDimension(java.time.LocalDateTime presentDate, java.time.LocalDateTime genericenddaterange, String year, String monthNum, String dateDd, Long weekDay, String week, Long genericweekdaystartonmonday, String day, String dayShort, String month, String monthShort, String genericweeknumber, String quarter, java.time.LocalDateTime genericlastday, Long genericnumberconstant, Long genericdatecounter) {

    public static class Builder {

        private java.time.LocalDateTime presentDate;

        private java.time.LocalDateTime genericenddaterange;

        private String year;

        private String monthNum;

        private String dateDd;

        private Long weekDay;

        private String week;

        private Long genericweekdaystartonmonday;

        private String day;

        private String dayShort;

        private String month;

        private String monthShort;

        private String genericweeknumber;

        private String quarter;

        private java.time.LocalDateTime genericlastday;

        private Long genericnumberconstant;

        private Long genericdatecounter;

        public Builder presentDate(java.time.LocalDateTime presentDate) {
            this.presentDate = presentDate;
            return this;
        }

        public Builder genericenddaterange(java.time.LocalDateTime genericenddaterange) {
            this.genericenddaterange = genericenddaterange;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder monthNum(String monthNum) {
            this.monthNum = monthNum;
            return this;
        }

        public Builder dateDd(String dateDd) {
            this.dateDd = dateDd;
            return this;
        }

        public Builder weekDay(Long weekDay) {
            this.weekDay = weekDay;
            return this;
        }

        public Builder week(String week) {
            this.week = week;
            return this;
        }

        public Builder genericweekdaystartonmonday(Long genericweekdaystartonmonday) {
            this.genericweekdaystartonmonday = genericweekdaystartonmonday;
            return this;
        }

        public Builder day(String day) {
            this.day = day;
            return this;
        }

        public Builder dayShort(String dayShort) {
            this.dayShort = dayShort;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder monthShort(String monthShort) {
            this.monthShort = monthShort;
            return this;
        }

        public Builder genericweeknumber(String genericweeknumber) {
            this.genericweeknumber = genericweeknumber;
            return this;
        }

        public Builder quarter(String quarter) {
            this.quarter = quarter;
            return this;
        }

        public Builder genericlastday(java.time.LocalDateTime genericlastday) {
            this.genericlastday = genericlastday;
            return this;
        }

        public Builder genericnumberconstant(Long genericnumberconstant) {
            this.genericnumberconstant = genericnumberconstant;
            return this;
        }

        public Builder genericdatecounter(Long genericdatecounter) {
            this.genericdatecounter = genericdatecounter;
            return this;
        }

        public DateDimension build() {
            return new DateDimension(presentDate, genericenddaterange, year, monthNum, dateDd, weekDay, week, genericweekdaystartonmonday, day, dayShort, month, monthShort, genericweeknumber, quarter, genericlastday, genericnumberconstant, genericdatecounter);
        }
    }
}
