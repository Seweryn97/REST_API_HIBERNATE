package com.example.demo.Controller;

import com.example.demo.TaskConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private DataSourceProperties dataSource;
    private TaskConfiguration myProp;

    InfoController( final  TaskConfiguration myProp,DataSourceProperties dataSource){
        this.dataSource = dataSource;
        this.myProp = myProp;

    }

    @GetMapping("/info/url")
    String url(){
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp(){
        return myProp.getTemplate().isAllowMultipleTasksFromTemplate();
    }
}
