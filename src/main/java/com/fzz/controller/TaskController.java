package com.fzz.controller;

import com.fzz.config.Const;
import com.fzz.entity.Task;
import com.fzz.entity.global.Response;
import com.fzz.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tuyoo on 2017/4/3.
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;


    //creat a new task
    @RequestMapping("/creat")
    public Task creat(
            @RequestParam("creater_name")String creater_name,
            @RequestParam("description")String description,
            @RequestParam("operator_names")String[] operator_names
    ){
        System.out.println(operator_names.length);

        return taskService.add(description,creater_name,operator_names);
    }


    @RequestMapping("to/{userid}")
    public List<Task> touser(
            @PathVariable("userid")int userid
    ) {
                return taskService.to_user_tasks(userid);
    }
    @RequestMapping("/delete/{taskid}")
    public Response delete(
            @PathVariable("taskid")int taskid
    ){
                return taskService.delete(taskid);
    }

    @RequestMapping("/modify/{taskid}")
    public Task modify(
            @PathVariable("taskid")int taskid,
            @RequestParam("description")String description,
            @RequestParam("operator_id_list")int[] operator_id_list
    ){
                return taskService.modify(taskid,description,operator_id_list);
    }


    @RequestMapping("/show/{page}/{size}")
    public Page<Task> list(
            @PathVariable("page")int page,
            @PathVariable("size")int size
    ){

                return taskService.findbypage(page,size);
    }

    @RequestMapping("/to/me")
    public List<Task> tasktome(HttpSession httpSession) {
                int id=(int)httpSession.getAttribute(Const.LOGIN_SESSION);
                return taskService.to_user_tasks(id);
    }

}
