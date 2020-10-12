package com.ljq.mutidatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MutiDatasource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContext.getDataSource();
    }
}
