package com.fzz.service.impl;

import com.fzz.dao.NativeSqlDao;
import com.fzz.dao.TaskDao;
import com.fzz.dao.UserDao;
import com.fzz.entity.Task;
import com.fzz.entity.User;
import com.fzz.entity.global.Response;
import com.fzz.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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

    @Autowired
    private NativeSqlDao nativeSqlDao;

    @Override
    public Page<Task> findbypage(int page, int size) {
        Pageable pageable=new PageRequest(page,size);
        return taskDao.findAll(pageable);
    }

    @Override

    public Task add(String description, String creater_name, String[] operator_names) {
        Task task=new Task();
        task.setCreater(userDao.findByUsername(creater_name));
        task.setDescription(description);

        List<String> usernames=new ArrayList<String>();
        for (String operator_name:operator_names
                ) {
            System.out.println(operator_name);
            usernames.add(operator_name);
        }

        System.out.println(userDao.findByUsernameIn(usernames).size());
        task.setOperator(userDao.findByUsernameIn(usernames));
        task.setCreatedate(new Date(System.currentTimeMillis()));

        return taskDao.save(task);

    }

    @Override
    public Task modify(int task_id, String new_description, int[] new_operator_ids) {

        Task task =taskDao.findOne(task_id);
        task.setOperator(userDao.findByIdIn(new_operator_ids));
        return taskDao.save(task);
    }

    @Override
    public List<Task> to_user_tasks(int touser_id) {
        StringBuilder sql=new StringBuilder();
        sql.append("SELECT * FROM task t JOIN user_task ut ON t.id=ut.task_id WHERE ut.operator_id= ");
        sql.append(touser_id);

        return nativeSqlDao.sqlObjList(sql.toString(),Task.class);
    }

    @Override
    public Task query(int task_id) {

        return taskDao.findOne(task_id);
    }

    @Override
    public Response delete(int taskid) {
        taskDao.delete(taskid);
        return new Response();
    }

    @Override
    public List<Task> getall() {
        return taskDao.findAll();
    }
}
