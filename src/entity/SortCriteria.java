package entity;

import java.util.Comparator;

public enum SortCriteria {
    ASC((p1,p2)->p1.score-p2.score),
    DESC((p1,p2)->p2.score-p1.score);
    public Comparator<Problem> comparator;

    SortCriteria(Comparator<Problem> comparator) {
        this.comparator = comparator;
    }
}
