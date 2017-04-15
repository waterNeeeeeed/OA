package com.runfeng.activiti;

import org.activiti.engine.*;
import org.activiti.engine.task.Task;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/4/15.
 */
public class ActivitiTestTest {
    @Test
    public void test() throws Exception {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

            RepositoryService repositoryService = processEngine.getRepositoryService();
            RuntimeService runtimeService = processEngine.getRuntimeService();

            TaskService taskService = processEngine.getTaskService();
            repositoryService.createDeployment().addClasspathResource("activiti/process.bpmn20.xml").deploy();

            runtimeService.startProcessInstanceByKey("process");

            Task task = taskService.createTaskQuery().singleResult();
            System.out.println("第一个任务完成前，当前任务名称:" + task.getName());
            taskService.complete(task.getId());
            task = taskService.createTaskQuery().singleResult();
            System.out.println("第二个任务完成前，当前任务名称:" + task.getName());
            taskService.complete(task.getId());
            task = taskService.createTaskQuery().singleResult();
            System.out.println("第三个任务完成前，当前任务名称:" + task.getName());
            taskService.complete(task.getId());

            task = taskService.createTaskQuery().singleResult();
            System.out.println("当前任务:" + task);


    }
}