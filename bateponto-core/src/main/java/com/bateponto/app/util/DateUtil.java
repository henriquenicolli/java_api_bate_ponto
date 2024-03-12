package com.bateponto.app.util;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    private static final Map<String, Integer> MES_MAP = new HashMap<>();

    static {
        MES_MAP.put("Janeiro", Month.JANUARY.getValue());
        MES_MAP.put("Fevereiro", Month.FEBRUARY.getValue());
        MES_MAP.put("Março", Month.MARCH.getValue());
        MES_MAP.put("Abril", Month.APRIL.getValue());
        MES_MAP.put("Maio", Month.MAY.getValue());
        MES_MAP.put("Junho", Month.JUNE.getValue());
        MES_MAP.put("Julho", Month.JULY.getValue());
        MES_MAP.put("Agosto", Month.AUGUST.getValue());
        MES_MAP.put("Setembro", Month.SEPTEMBER.getValue());
        MES_MAP.put("Outubro", Month.OCTOBER.getValue());
        MES_MAP.put("Novembro", Month.NOVEMBER.getValue());
        MES_MAP.put("Dezembro", Month.DECEMBER.getValue());
    }

    public static int getMes(String mes) {
        return MES_MAP.get(mes);
    }


}
