package example.micronaut;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

import static io.micronaut.data.model.query.builder.sql.Dialect.ORACLE;

@JdbcRepository(dialect = ORACLE)
interface FooRepo extends CrudRepository<Foo, Integer> {
}