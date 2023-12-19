package br.com.wrs.config;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;
import java.util.UUID;

public class MyPostgreSQLDialect  extends PostgreSQL95Dialect {

    public MyPostgreSQLDialect(){
        super();
        registerFunction("any", new PostgreSQLAnyFunction());
        registerFunction("unnest", new PostgreSQLUnnestFunction());
        registerFunction("all", new PostgreSQLAllFunction());
        registerHibernateType(Types.OTHER, UUID.class.getName());

    }
}
