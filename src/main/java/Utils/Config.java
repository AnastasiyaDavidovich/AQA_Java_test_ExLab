package Utils;

import org.openqa.selenium.Dimension;

public class Config {
    public static final Integer THREAD_SLEEP = 1000;
    public static final Integer width = 1680;
    public static final Integer height = 1050;
    public static final Dimension DIMENSION = new Dimension(width, height);
    public static final Boolean ON_HEADLESS = false;
    public static final String BASE_URL = "http://test.exlab.team/";
}
