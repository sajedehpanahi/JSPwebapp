package util;

import org.apache.log4j.Logger;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger("MyLogger");

    public static Logger getLogger(){
        return  logger;
    }
}
