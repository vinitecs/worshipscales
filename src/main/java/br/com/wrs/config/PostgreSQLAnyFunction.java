package br.com.wrs.config;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import java.util.List;

public class PostgreSQLAnyFunction implements SQLFunction {

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return true;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) throws QueryException {
        return firstArgumentType;
    }

    @Override
    public String render(Type firstArgumentType, List args, SessionFactoryImplementor factory) throws QueryException {
        return "any(" + args.get(0) + ")";
    }
}
