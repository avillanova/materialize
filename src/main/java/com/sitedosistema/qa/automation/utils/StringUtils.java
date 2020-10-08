package com.sitedosistema.qa.automation.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static String getActualTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyyHHmmss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
