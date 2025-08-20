package com.bsit.codegeneration.record;

public record QrtzCalendars(String schedName, String calendarName, String calendar) {

    public static class Builder {

        private String schedName;

        private String calendarName;

        private String calendar;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder calendarName(String calendarName) {
            this.calendarName = calendarName;
            return this;
        }

        public Builder calendar(String calendar) {
            this.calendar = calendar;
            return this;
        }

        public QrtzCalendars build() {
            return new QrtzCalendars(schedName, calendarName, calendar);
        }
    }
}
