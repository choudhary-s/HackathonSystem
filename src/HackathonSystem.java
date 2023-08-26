import entity.*;
import repository.ProblemLibrary;
import repository.UserDirectory;

import java.util.List;

public class HackathonSystem {
    public static void main(String[] args) throws InterruptedException {
        Problem p1 = new Problem("P1", "Problem 1", Tag.ARRAY, Difficulty.EASY, 100);
        Problem p2 = new Problem("P2", "Problem 2", Tag.DP, Difficulty.MEDIUM, 200);
        Problem p3 = new Problem("P3", "Problem 3", Tag.LINKEDLIST, Difficulty.HARD, 300);
        Problem p4 = new Problem("P4", "Problem 4", Tag.ARRAY, Difficulty.MEDIUM, 200);
        Problem p5 = new Problem("P5", "Problem 5", Tag.DP, Difficulty.HARD, 300);
        Problem p6 = new Problem("P6", "Problem 6", Tag.LINKEDLIST, Difficulty.EASY, 100);
        Problem p7 = new Problem("P7", "Problem 7", Tag.ARRAY, Difficulty.HARD, 300);
        Problem p8 = new Problem("P8", "Problem 8", Tag.DP, Difficulty.EASY, 100);
        Problem p9 = new Problem("P9", "Problem 9", Tag.LINKEDLIST, Difficulty.MEDIUM, 200);


        ProblemLibrary problemLibrary = new ProblemLibrary();
        try {
            problemLibrary.addProblem(p1);
            problemLibrary.addProblem(p2);
            problemLibrary.addProblem(p3);
            problemLibrary.addProblem(p4);
            problemLibrary.addProblem(p5);
            problemLibrary.addProblem(p6);
            problemLibrary.addProblem(p7);
            problemLibrary.addProblem(p8);
            problemLibrary.addProblem(p9);

        }
        catch (Exception ex){
            System.out.println("Cannot add duplicate problem");
        }

        User u1 = new User("U1", "D1");
        User u2 = new User("U2", "D2");
        User u3 = new User("U3", "D3");


        UserDirectory userDirectory = new UserDirectory();

        try{
            userDirectory.addUser(u1);
            userDirectory.addUser(u2);
            userDirectory.addUser(u3);
        }
        catch (Exception ex){
            System.out.println("Duplicate user cannot be added");
        }



        List<Problem> fetchedProblems = problemLibrary.fetchProblems(FilterCriteria.DIFFICULTY, Difficulty.MEDIUM.toString(), SortCriteria.DESC);
        System.out.println(fetchedProblems);

        Problem pu1 = fetchedProblems.get(0);
        System.out.println(pu1.name+" is selected");
        u1.like(pu1);
        u1.startSolving(pu1);

        fetchedProblems = problemLibrary.fetchProblems(FilterCriteria.TAG, Tag.ARRAY.toString(), SortCriteria.DESC);
        System.out.println(fetchedProblems);

        fetchedProblems = problemLibrary.fetchProblems(FilterCriteria.DIFFICULTY, Difficulty.MEDIUM.toString(), SortCriteria.DESC);
        System.out.println(fetchedProblems);

        Problem pu2 = fetchedProblems.get(0);
        System.out.println(pu2.name+" is selected");
        u2.like(pu2);
        u2.startSolving(pu2);

        Problem pu3 = fetchedProblems.get(1);
        System.out.println(pu3.name+" is selected");
        u3.like(pu3);
        u3.startSolving(pu3);

        Thread.sleep(1000);
        try {
            u1.markSolved(pu1);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try {
            u2.markSolved(pu2);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try {
            u3.markSolved(pu3);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(problemLibrary.toString());
        System.out.println("Printing top 5 problems:\n"+problemLibrary.getTopNProblem(5));
    }
}
