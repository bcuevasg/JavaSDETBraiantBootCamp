package com.braiant;

public class EnumExample {
    static final String URL = "www.pagina.com";
    static final String API = "www.pagina.com";

    public static void main(String[] args) {
        int today = WeekDays.WEDNESDAY.ranking;
        System.out.println(today);
        System.out.println("El sabado voy a tener "+ WeekDays.SATURDAY.event);
        System.out.println(selectBrowser(Browsers.FIREFOX));
    }

    private static String selectBrowser(Browsers b){
        String browserSelected = switch (b){
            case EDGE -> "Opening Edge Browser";
            case CHROME -> "Opening Google Chrome Browser";
            case FIREFOX -> "Opening FireFox Browser";
            default -> "Not Valid";
        };
        return browserSelected;
    }

}
