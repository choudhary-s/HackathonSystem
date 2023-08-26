package entity;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum FilterCriteria {
    TAG((p,val)->p.tag.toString().equals(val)),
    DIFFICULTY((p,val)->p.difficulty.toString().equals(val));

    public BiPredicate<Problem, String> filterPredicate;

    FilterCriteria(BiPredicate<Problem, String> filterPredicate) {
        this.filterPredicate = filterPredicate;
    }
}
