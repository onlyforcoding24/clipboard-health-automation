package com.clipboard.logging;

import org.apache.log4j.Logger;

/**
 * @author jitendra.pisal
 */
public class OwnLogger {

    public OwnLogger(){}

    public void logInfo(Logger logger, String message){
        logger.info(message+"\n");
    }

    public void logError(Logger logger, String message){
        logger.error(message+"\n");
    }

    public void logWARN(Logger logger, String message){
        logger.warn(message+"\n");
    }

    public void logDebug(Logger logger, String message){
        logger.warn(message+"\n");
    }
}
