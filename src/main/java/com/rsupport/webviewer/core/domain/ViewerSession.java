package com.rsupport.webviewer.core.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Table(name = "rt_viewer_session")
@Entity
public class ViewerSession {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "agent_id")
    private ViewerAgent viewerAgent;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id")
    private ViewerRoom viewerRoom;
}
