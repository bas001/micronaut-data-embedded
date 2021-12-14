package example.micronaut;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Embeddable;

import java.util.Objects;

@Embeddable
@Introspected
public class Bar {

    String bar1;
    @Nullable
    String bar2;

    public Bar(String bar1, @Nullable String bar2) {
        this.bar1 = bar1;
        this.bar2 = bar2;
    }

    public String getBar1() {
        return bar1;
    }

    public void setBar1(String inner1) {
        this.bar1 = inner1;
    }

    @Nullable
    public String getBar2() {
        return bar2;
    }

    public void setBar2(@Nullable String inner2) {
        this.bar2 = inner2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(bar1, bar.bar1) && Objects.equals(bar2, bar.bar2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bar1, bar2);
    }
}