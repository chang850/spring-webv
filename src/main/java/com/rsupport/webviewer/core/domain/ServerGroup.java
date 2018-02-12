package com.rsupport.webviewer.core.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@Entity
@Table(name = "nt_server_group")
@ToString(exclude = {"servers"})
public class ServerGroup {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "serverGroup")
    private Set<Server> servers = new HashSet<>();
}
