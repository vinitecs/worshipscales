package br.com.wrs.config.dialectConfig;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;
import java.util.UUID;

public class PostgresDialect95Config  extends PostgreSQL95Dialect {
    public PostgresDialect95Config(){
        super();
        registerFunction("any", new PostgreSQLAnyFunction());
        registerFunction("unnest", new PostgreSQLUnnestFunction());
        registerFunction("all", new PostgreSQLAllFunction());
        registerHibernateType(Types.OTHER, UUID.class.getName());

    }
}
