package com.fzz.service;

import com.fzz.entity.Task;
import com.fzz.entity.User;
import com.fzz.entity.global.Response;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzz on 2017/4/2.
 */

public interface TaskService {


    public Task add(
            String description,
            String creater_name,
            String[] operator_names

    );

    public Task modify(
            int task_id,
            String new_description,
            int[] new_operator_ids
    );

    public Task query(
            int task_id
    );

    public List<Task> getall();

    public List<Task> to_user_tasks(int touser_id);

    public Response delete(int taskid);

    public Page<Task> findbypage(int page,int size);

}
