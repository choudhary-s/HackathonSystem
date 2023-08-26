package entity;

import java.util.*;

public class User {
    public int id;
    public String name;
    public String department;
    public int score; //score of the user
    public Set<Problem> solvedProblems;
    public Map<Problem, Date> currentSolving;
    public Set<Problem> likedProblems;
    public User(String n, String d){
        name = n;
        department = d;
        score = 0;
        solvedProblems = new HashSet<>();
        currentSolving = new HashMap<>();
        likedProblems = new HashSet<>();
    }
    public void addToSolvedProblems(Problem p){
        solvedProblems.add(p);
        p.noOfUsersWhoSolved++;
    }
    public List<Problem> fetchSolvedProblems(){
        return new ArrayList<>(solvedProblems);
    }
    public void startSolving(Problem p){
        currentSolving.put(p, new Date());
    }
    public void markSolved(Problem p) throws Exception {
        if(!currentSolving.containsKey(p)){
            throw new Exception("Cannot mark solved to a problem that user hasn't started solving");
        }
        Date start = currentSolving.get(p);
        Date end = new Date();
        currentSolving.remove(p);
        long diffInMs = end.getTime()-start.getTime();
        System.out.println("Diff in ms: "+diffInMs);
        if(!solvedProblems.contains(p)){
            addToSolvedProblems(p);
            p.recomputeAvg(diffInMs);
            score += p.score;
        }
    }
    public void like(Problem p){
        if(!likedProblems.contains(p)){
            likedProblems.add(p);
            p.like();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && department.equals(user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }
}
