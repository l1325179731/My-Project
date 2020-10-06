package com.ljq.test_springboot.DynamicDataSource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDatasource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();


    public DynamicDatasource(DataSource defaultTargetDatasource, Map<Object, Object> targetDatasource) {
        super.setDefaultTargetDataSource(defaultTargetDatasource);
        super.setTargetDataSources(targetDatasource);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }
}
