package com.rsupport.webviewer.core.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("webviewer")
@Getter
@Setter
public class WebViewerProperties {

    private String role;

    private final Project project = new Project();

    private final Team team = new Team();

    @Getter
    @Setter
    public static class Project {
        private String name;
    }

    @Getter
    @Setter
    public static class Team {
        private String part;
    }

}
