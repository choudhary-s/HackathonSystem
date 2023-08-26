package repository;

import entity.FilterCriteria;
import entity.Problem;
import entity.SortCriteria;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProblemLibrary {
    List<Problem> problems;
    public ProblemLibrary(){
        problems = new ArrayList<>();
    }
    public void addProblem(Problem p) throws Exception{
        if(problems.contains(p)){
            throw new Exception("This problem already exists");
        }
        problems.add(p);
    }
    private Comparator<Problem> getComparator(SortCriteria sc){
        Comparator<Problem> c = new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if(Objects.nonNull(sc) && sc.toString().compareTo(SortCriteria.DESC.toString())==0){
                    return o2.score-o1.score;
                }
                else{
                    return o1.score-o2.score;
                }
            }
        };
        return c;
    }
    public List<Problem> fetchProblems(FilterCriteria fc, String val, SortCriteria sc){
        Comparator<Problem> c = getComparator(sc);
        List<Problem> result;
//        result = problems.stream()
//                .filter(p->fc.filterPredicate.test(p,val))//can be done using BiPredicate
//                .collect(Collectors.toList());
        if(FilterCriteria.TAG.toString().compareTo(fc.toString())==0) {
            result = problems.stream()
                    .filter(p->p.tag.toString().equals(val))
                    .sorted(sc.comparator)//can be done using BiPredicate
                    .collect(Collectors.toList());
        }
        else if(FilterCriteria.DIFFICULTY.toString().compareTo(fc.toString())==0){
            result = problems.stream()
                    .filter(p->p.difficulty.toString().compareTo(val)==0)
                    .sorted(sc.comparator)
                    .collect(Collectors.toList());
        }
        else {
            result = new ArrayList<>(problems);
        }
//        Collections.sort(result, c);
        return result;
    }

//    private Predicate<Problem> getFilter(String val) {
//        return p -> p.tag.toString().compareTo(val) == 0;
//    }

    public List<Problem> getTopNProblem(int n){
        Comparator<Problem> c = getComparator(SortCriteria.DESC);
        Collections.sort(problems, c);
        //Collections.sort(problems, SortCriteria.DESC.comparator);
        List<Problem> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(problems.get(i));
        }
//        return problems.stream().sorted(SortCriteria.DESC.comparator).limit(n).collect(Collectors.toList());
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Problem p: problems){
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
