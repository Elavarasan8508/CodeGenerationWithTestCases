package com.bsit.codegeneration.pojo;

import java.time.LocalDateTime;

public class DateDimension {

    private java.time.LocalDateTime presentDate;

    private java.time.LocalDateTime genericenddaterange;

    private Integer year;

    private String monthNum;

    private String dateDd;

    private Integer weekDay;

    private String week;

    private Integer genericweekdaystartonmonday;

    private String day;

    private String dayShort;

    private String month;

    private String monthShort;

    private String genericweeknumber;

    private String quarter;

    private java.time.LocalDateTime genericlastday;

    private Integer genericnumberconstant;

    private Integer genericdatecounter;

    public DateDimension() {
    }

    public DateDimension(java.time.LocalDateTime presentDate, java.time.LocalDateTime genericenddaterange, Integer year, String monthNum, String dateDd, Integer weekDay, String week, Integer genericweekdaystartonmonday, String day, String dayShort, String month, String monthShort, String genericweeknumber, String quarter, java.time.LocalDateTime genericlastday, Integer genericnumberconstant, Integer genericdatecounter) {
        this.presentDate = presentDate;
        this.genericenddaterange = genericenddaterange;
        this.year = year;
        this.monthNum = monthNum;
        this.dateDd = dateDd;
        this.weekDay = weekDay;
        this.week = week;
        this.genericweekdaystartonmonday = genericweekdaystartonmonday;
        this.day = day;
        this.dayShort = dayShort;
        this.month = month;
        this.monthShort = monthShort;
        this.genericweeknumber = genericweeknumber;
        this.quarter = quarter;
        this.genericlastday = genericlastday;
        this.genericnumberconstant = genericnumberconstant;
        this.genericdatecounter = genericdatecounter;
    }

    public java.time.LocalDateTime getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(java.time.LocalDateTime presentDate) {
        this.presentDate = presentDate;
    }

    public java.time.LocalDateTime getGenericenddaterange() {
        return genericenddaterange;
    }

    public void setGenericenddaterange(java.time.LocalDateTime genericenddaterange) {
        this.genericenddaterange = genericenddaterange;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(String monthNum) {
        this.monthNum = monthNum;
    }

    public String getDateDd() {
        return dateDd;
    }

    public void setDateDd(String dateDd) {
        this.dateDd = dateDd;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Integer getGenericweekdaystartonmonday() {
        return genericweekdaystartonmonday;
    }

    public void setGenericweekdaystartonmonday(Integer genericweekdaystartonmonday) {
        this.genericweekdaystartonmonday = genericweekdaystartonmonday;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayShort() {
        return dayShort;
    }

    public void setDayShort(String dayShort) {
        this.dayShort = dayShort;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonthShort() {
        return monthShort;
    }

    public void setMonthShort(String monthShort) {
        this.monthShort = monthShort;
    }

    public String getGenericweeknumber() {
        return genericweeknumber;
    }

    public void setGenericweeknumber(String genericweeknumber) {
        this.genericweeknumber = genericweeknumber;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public java.time.LocalDateTime getGenericlastday() {
        return genericlastday;
    }

    public void setGenericlastday(java.time.LocalDateTime genericlastday) {
        this.genericlastday = genericlastday;
    }

    public Integer getGenericnumberconstant() {
        return genericnumberconstant;
    }

    public void setGenericnumberconstant(Integer genericnumberconstant) {
        this.genericnumberconstant = genericnumberconstant;
    }

    public Integer getGenericdatecounter() {
        return genericdatecounter;
    }

    public void setGenericdatecounter(Integer genericdatecounter) {
        this.genericdatecounter = genericdatecounter;
    }

    public static class Builder {

        private DateDimension instance = new DateDimension();

        public Builder presentDate(java.time.LocalDateTime presentDate) {
            instance.setPresentDate(presentDate);
            return this;
        }

        public Builder genericenddaterange(java.time.LocalDateTime genericenddaterange) {
            instance.setGenericenddaterange(genericenddaterange);
            return this;
        }

        public Builder year(Integer year) {
            instance.setYear(year);
            return this;
        }

        public Builder monthNum(String monthNum) {
            instance.setMonthNum(monthNum);
            return this;
        }

        public Builder dateDd(String dateDd) {
            instance.setDateDd(dateDd);
            return this;
        }

        public Builder weekDay(Integer weekDay) {
            instance.setWeekDay(weekDay);
            return this;
        }

        public Builder week(String week) {
            instance.setWeek(week);
            return this;
        }

        public Builder genericweekdaystartonmonday(Integer genericweekdaystartonmonday) {
            instance.setGenericweekdaystartonmonday(genericweekdaystartonmonday);
            return this;
        }

        public Builder day(String day) {
            instance.setDay(day);
            return this;
        }

        public Builder dayShort(String dayShort) {
            instance.setDayShort(dayShort);
            return this;
        }

        public Builder month(String month) {
            instance.setMonth(month);
            return this;
        }

        public Builder monthShort(String monthShort) {
            instance.setMonthShort(monthShort);
            return this;
        }

        public Builder genericweeknumber(String genericweeknumber) {
            instance.setGenericweeknumber(genericweeknumber);
            return this;
        }

        public Builder quarter(String quarter) {
            instance.setQuarter(quarter);
            return this;
        }

        public Builder genericlastday(java.time.LocalDateTime genericlastday) {
            instance.setGenericlastday(genericlastday);
            return this;
        }

        public Builder genericnumberconstant(Integer genericnumberconstant) {
            instance.setGenericnumberconstant(genericnumberconstant);
            return this;
        }

        public Builder genericdatecounter(Integer genericdatecounter) {
            instance.setGenericdatecounter(genericdatecounter);
            return this;
        }

        public DateDimension build() {
            return instance;
        }
    }
}
