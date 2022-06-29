package com.godofparking.jeogida.service;

import com.godofparking.jeogida.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 1;
    static {
        users.add(new User(1, "aaaaaaa@naver.com", "홍깅동", "qwerty", new Date(), new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user: users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if (user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }


}