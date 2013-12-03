package poker.helpers;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

import java.util.Arrays;
import java.util.Collection;

public class IterableContainsOnly extends TypeSafeMatcher<Iterable> {
    private Collection objects;

    public IterableContainsOnly(Object... objects) {
        this.objects = Arrays.asList(objects);
    }

    public IterableContainsOnly(Iterable iterable) {
        this.objects = Lists.newArrayList(iterable);
    }

    @Factory
    public static IterableContainsOnly containsOnly(Object... objects) {
        return new IterableContainsOnly(objects);
    }

    @Factory
    public static IterableContainsOnly containsOnly(Iterable iterable) {
        return new IterableContainsOnly(iterable);
    }

    @Override
    public boolean matchesSafely(Iterable iterable) {
        if (Iterables.size(iterable) != objects.size()) {
            return false;
        }

        return Iterables.all(iterable, Predicates.in(objects));
    }

    @Override
    public void describeTo(Description description) {
        description.appendValueList("should contain only ", ",", "", objects);
    }
}
