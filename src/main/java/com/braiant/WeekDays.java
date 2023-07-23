package com.braiant;

public enum WeekDays {
    MONDAY(2,"Trabajar"), TUESDAY(4,"GYM"), WEDNESDAY(5,"Cita Doc"),
    THURSDAY(9,"Trabajar"), FRIDAY(10,"Cena trabajo"),
    SATURDAY(10, "Party"), SUNDAY(1,"Reunion Fam");

    final int ranking;
    final String event;
    WeekDays(int ranking, String event) {
        this.ranking = ranking;
        this.event = event;
    }
}
