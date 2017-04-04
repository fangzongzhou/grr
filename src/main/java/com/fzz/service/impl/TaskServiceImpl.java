package com.fzz.service.impl;

import com.fzz.dao.TaskDao;
import com.fzz.dao.UserDao;
import com.fzz.entity.Task;
import com.fzz.entity.User;
import com.fzz.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tuyoo on 2017/4/3.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;

    @Override

    public Task add(String description, String creater_name, String[] operator_names) {
        Task task=new Task();
        task.setCreater(userDao.findByUsername(creater_name));
        task.setDescription(description);
//        List<User> users=new ArrayList<User>();
//        for (String operator_name:operator_names
//             ) {
//            System.out.println(operator_name);
//            users.add(userDao.findByUsername(operator_name));
//            System.out.println("OOOOOO");
//        }
//
//        System.out.println(users.size());
//        task.setOperator(users);
//
//        return taskDao.save(task);
        List<String> usernames=new ArrayList<String>();
        for (String operator_name:operator_names
                ) {
            System.out.println(operator_name);
            usernames.add(operator_name);
            System.out.println("OOOOOO");
        }

        System.out.println(userDao.findByUsernameIn(usernames).size());
        task.setOperator(userDao.findByUsernameIn(usernames));

        return taskDao.save(task);

    }

    @Override
    public Task modify(int task_id, String new_description, String[] new_operator_names) {

        return null;
    }
}
