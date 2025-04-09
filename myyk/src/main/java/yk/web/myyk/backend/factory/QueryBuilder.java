package yk.web.myyk.backend.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import yk.web.myyk.backend.entity.BaseEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;

public class QueryBuilder {

    private EntityManager em;

    private Class<? extends BaseEntity> from;
    private Map<String, Class<? extends BaseEntity>> fromMap;

    private Map<String, Operator> whereMap;
    private Map<String, Order> orderMap;
    private Map<String, Object> parameterMap;

    private String jpql;
    private TypedQuery<? extends BaseEntity> query;

    public static QueryBuilder getQueryBuilder(EntityManager em) {
        return new QueryBuilder(em);
    }

    public QueryBuilder(EntityManager em) {
        clear();
        this.em = em;
    }

    public QueryBuilder setFrom(Class<? extends BaseEntity> entity) {
        String as = entity.getSimpleName().substring(0, 3).toLowerCase();
        setFrom(as, entity);
        return this;
    }

    public QueryBuilder setFrom(String as, Class<? extends BaseEntity> entity) {
        fromMap.clear(); // from은 2개가 될 수 없음
        fromMap.put(as, entity);
        return this;
    }

    public QueryBuilder where(String where) {
        whereMap.put(where, Operator.FIRST);
        return this;
    }

    public QueryBuilder andWhere(String where) {
        whereMap.put(where, Operator.AND);
        return this;
    }

    public QueryBuilder orWhere(String where) {
        whereMap.put(where, Operator.OR);
        return this;
    }

    public QueryBuilder addOrderBy(String orderBy, Order order) {
        orderMap.put(orderBy, order);
        return this;
    }

    public QueryBuilder setParameter(String key, String value) {
        parameterMap.put(key, value);
        return this;
    }

    public QueryBuilder setParameter(String key, int value) {
        parameterMap.put(key, value);
        return this;
    }

    public QueryBuilder setParameter(String key, long value) {
        parameterMap.put(key, value);
        return this;
    }

    public QueryBuilder setParameter(String key, boolean value) {
        parameterMap.put(key, value);
        return this;
    }

    public QueryBuilder setParameter(String key, Bool value) {
        parameterMap.put(key, value.getBool());
        return this;
    }

    public QueryBuilder setParameter(String key, List<Object> valueList) {
        String parameter = "";
        for (Object value : valueList) {
            if (value instanceof Integer) {
                parameter = value + ",";
            }
            else if (value instanceof Long) {
                parameter = value + ",";
            }
            else if (value instanceof String) {
                parameter = "'" + value + "',";
            }
        }
        parameterMap.put(key, parameter);
        return this;
    }

    public QueryBuilder notDeleted() {
        this.andWhere("deleted = :notDeleted");
        this.setParameter("notDeleted", false);
        return this;
    }

    public String getJpql() {
        // For Debug;
        return jpql;
    }

    public <T extends BaseEntity> T getSingleResult() {
        @SuppressWarnings("unchecked")
        T result = (T) query.getSingleResult();
        return result;
    }

    public <T extends BaseEntity> List<T> getResult() {
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>) query.getResultList();
        return result;
    }

    public QueryBuilder createQuery() throws AppException {

        try {
            // from
            Entry<String, Class<? extends BaseEntity>> fromEntry = fromMap.entrySet().iterator().next();
            String from = fromEntry.getValue().getSimpleName();
            String as = fromEntry.getKey();
            from += " " + as;

            // select
            String select = as;

            // where
            String where = "";
            boolean isFirstWhere = true;

            for (Entry<String, Operator> entry : whereMap.entrySet()) {
                String operator = isFirstWhere ? "" : entry.getValue().getOperator();
                where += operator + "(" + entry.getKey() + ")";
                isFirstWhere = false;
            }

            // order by
            String orderBy = "";
            boolean isFirstOrderBy = true;

            for (Entry<String, Order> entry : orderMap.entrySet()) {
                String operator = isFirstOrderBy ? "" : Operator.AND.getOperator();
                orderBy += operator + "(" + entry.getKey() + ")";
                isFirstOrderBy = false;
            }

            // set parameter

            String jpql = "select %select% from %from%";

            if (!where.isEmpty()) {
                jpql += " where %where%";
            }
            if (!orderBy.isEmpty()) {
                jpql += "order by %order by%";
            }

            jpql = jpql.replaceAll("%select%", select);
            jpql = jpql.replaceAll("%from%", from);
            jpql = jpql.replaceAll("%where%", where);
            jpql = jpql.replaceAll("%order by%", orderBy);
            this.jpql = jpql;

        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException(ErrorCode.QB_101);
        }

        try {
            this.query = em.createQuery(jpql, this.from);
            for (Entry<String, Object> parameter : parameterMap.entrySet()) {
                query.setParameter(parameter.getKey(), parameter.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException(ErrorCode.QB_102);
        }

        return this;
    }

    private void clear() {
        this.from = null;

        this.fromMap = new HashMap<>();
        this.whereMap = new HashMap<>();
        this.orderMap = new HashMap<>();
        this.parameterMap = new HashMap<>();

        this.jpql = "";
        this.query = null;
    }

    public enum Operator {
        OR(" or "),
        AND(" and "),
        FIRST(""),
        ;
        private String operator;
        private Operator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
    }

    public enum Order {
        ASC("asc"),
        DESC("desc"),
        ;
        private String order;
        private Order(String order) {
            this.order = order;
        }
        public String getOrder() {
            return order;
        }
    }

    public enum Bool {
        TRUE("1"),
        FALSE("0"),
        ;
        private String bool;
        private Bool(String bool) {
            this.bool = bool;
        }
        public String getBool() {
            return bool;
        }
    }
}
