package com.rsupport.webviewer.core.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Table(name = "rt_viewer_agent")
@Entity
public class ViewerAgent {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "viewerAgent", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<ViewerSession> viewerSessions = new HashSet<>();
}
