package repository;

import entity.User;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UserDirectory {
    PriorityQueue<User> users;
    public UserDirectory(){
        Comparator<User> c = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u2.score,u1.score);//sort in DESC
            }
        };
//        Comparator<User> comp = (u1, u2)->Integer.compare(u2.score, u1.score);
        users = new PriorityQueue<>(c);
    }
    public void addUser(User u) throws Exception{
        if(users.contains(u)){
            throw new Exception("User already present");
        }
        users.add(u);
    }
    public User getLeader(){
        return users.peek();
    }
}
