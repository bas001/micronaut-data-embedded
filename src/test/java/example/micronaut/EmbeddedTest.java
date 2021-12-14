package example.micronaut;


import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class EmbeddedTest {

    @Inject
    FooRepo repo;

    @Test
    void filledInnerCanBeRetrieved() {
        var saved = repo.save(new Foo(0, new Bar("1", "2")));
        var found = repo.findById(saved.id).get();
        assertThat(found.bar).isEqualTo(new Bar("1", "2"));
    }

    @Test
    void partiallyFilledInnerCanBeRetrieved() {
        var saved = repo.save(new Foo(0, new Bar("1", null)));
        var found = repo.findById(saved.id).get();
        // Fails with: Expecting actual not to be null
        assertThat(found.bar).isEqualTo(new Bar("1", null));
    }

}