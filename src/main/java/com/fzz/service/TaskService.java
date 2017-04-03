package com.fzz.service;

import com.fzz.entity.Task;
import com.fzz.entity.User;
import org.springframework.stereotype.Service;

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
            String[] new_operator_names
    );

}
