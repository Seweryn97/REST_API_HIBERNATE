package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfiguration {
    private Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public static class Template{
        private boolean allowMultipleTasks;

        public boolean isAllowMultipleTasksFromTemplate() {
            return allowMultipleTasks;
        }

        public void setAllowMultipleTasksFromTemplate(boolean allowMultipleTasksFromTemplate) {
            this.allowMultipleTasks = allowMultipleTasksFromTemplate;
        }
    }


}
