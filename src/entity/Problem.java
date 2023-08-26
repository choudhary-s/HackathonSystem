package entity;

import java.util.Objects;

public class Problem {
    public String name;
    public String description;
    public Tag tag;//Array, LinkedList, DP
    public Difficulty difficulty;
    public int score;
    public int likesCount;
    public int noOfUsersWhoSolved;
    public long avgSolveTime;
    public Problem(String n, String d, Tag t, Difficulty df, int score){
        name = n;
        description = d;
        tag = t;
        difficulty = df;
        this.score = score;
        likesCount = 0;
        noOfUsersWhoSolved = 0;
        avgSolveTime = 0;
    }
    public void solve(){
        noOfUsersWhoSolved++;
    }
    public void like(){
        likesCount++;
    }
    public void recomputeAvg(long ms){
        avgSolveTime = (avgSolveTime*noOfUsersWhoSolved+ms)/(noOfUsersWhoSolved+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return name.equals(problem.name) && description.equals(problem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tag=" + tag +
                ", difficulty=" + difficulty +
                ", score=" + score +
                ", likesCount=" + likesCount +
                ", noOfUsersWhoSolved=" + noOfUsersWhoSolved +
                ", avgSolveTime=" + avgSolveTime +
                '}';
    }
}
