package com.acspace.utils;

import java.util.List;

public class QueryParamUtil {

    public static <T> String listToString(List<T> paramList) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < paramList.size(); i++) {
            if (i == paramList.size() - 1) {
                result.append("'").append(paramList.get(i)).append("'");
            } else {
                result.append("'").append(paramList.get(i)).append("', ");
            }
        }
        return result.toString();
    }
}
