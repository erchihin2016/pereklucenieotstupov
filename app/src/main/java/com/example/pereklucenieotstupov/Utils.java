package com.example.pereklucenieotstupov;

public class Utils {

    private static int sTheme;

    public final static int THEME_SMALL = 0;
    public final static int THEME_MIDDLE = 1;
    public final static int THEME_BIG = 2;

    public static void changeToTheme(MainActivity activity, int theme) {
        sTheme = theme;
        activity.recreate();
    }

    public static void onActivityCreateSetTheme(MainActivity activity) {
        switch (sTheme) {
            default:
            case THEME_SMALL:
                activity.setTheme(R.style.Margin1);
                break;
            case THEME_MIDDLE:
                activity.setTheme(R.style.Margin3);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.Margin10);
                break;
        }
    }
}
