package example.micronaut;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@Introspected
public class Foo {

    @Id
    int id;

    // If not marked as @Nullable object creation fails
    @Nullable
    @Embedded
    Bar bar;

    public Foo(int id, @Nullable Bar bar) {
        this.id = id;
        this.bar = bar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public Bar getBar() {
        return bar;
    }

    public void setBar(@Nullable Bar bar) {
        this.bar = bar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return id == foo.id && Objects.equals(bar, foo.bar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bar);
    }
}