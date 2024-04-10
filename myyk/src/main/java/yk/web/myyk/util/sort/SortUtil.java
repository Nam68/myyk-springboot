package yk.web.myyk.util.sort;

import org.springframework.data.domain.Sort;

public class SortUtil {

    public static Sort getRegisteredDateDesc() {
        return Sort.by(Sort.Order.desc("registeredDate"));
    }

    public static Sort getSortNoAsc() {
        return Sort.by(Sort.Order.asc("sortNo"));
    }
}
