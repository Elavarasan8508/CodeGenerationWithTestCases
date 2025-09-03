package com.bsit.codegeneration.pojo;

public class QrtzCalendars {

    private String schedName;

    private String calendarName;

    private byte[] calendar;

    public QrtzCalendars() {
    }

    public QrtzCalendars(String schedName, String calendarName, byte[] calendar) {
        this.schedName = schedName;
        this.calendarName = calendarName;
        this.calendar = calendar;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public byte[] getCalendar() {
        return calendar;
    }

    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }

    public static class Builder {

        private QrtzCalendars instance = new QrtzCalendars();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder calendarName(String calendarName) {
            instance.setCalendarName(calendarName);
            return this;
        }

        public Builder calendar(byte[] calendar) {
            instance.setCalendar(calendar);
            return this;
        }

        public QrtzCalendars build() {
            return instance;
        }
    }
}
