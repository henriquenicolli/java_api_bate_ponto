package com.bateponto.app.util;

import java.text.Normalizer;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    private static final Map<String, Integer> MES_MAP = new HashMap<>();

    static {
        MES_MAP.put(normalize("Janeiro"), Month.JANUARY.getValue());
        MES_MAP.put(normalize("Fevereiro"), Month.FEBRUARY.getValue());
        MES_MAP.put(normalize("Março"), Month.MARCH.getValue());
        MES_MAP.put(normalize("Abril"), Month.APRIL.getValue());
        MES_MAP.put(normalize("Maio"), Month.MAY.getValue());
        MES_MAP.put(normalize("Junho"), Month.JUNE.getValue());
        MES_MAP.put(normalize("Julho"), Month.JULY.getValue());
        MES_MAP.put(normalize("Agosto"), Month.AUGUST.getValue());
        MES_MAP.put(normalize("Setembro"), Month.SEPTEMBER.getValue());
        MES_MAP.put(normalize("Outubro"), Month.OCTOBER.getValue());
        MES_MAP.put(normalize("Novembro"), Month.NOVEMBER.getValue());
        MES_MAP.put(normalize("Dezembro"), Month.DECEMBER.getValue());
    }

    public static int sanitize(String mes) {
        return MES_MAP.get(normalize(mes));
    }

    private static String normalize(String str) {
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[^\\p{ASCII}]", "");
        return normalized.toLowerCase();
    }

}
