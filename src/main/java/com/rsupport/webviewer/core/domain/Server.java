package com.rsupport.webviewer.core.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "nt_server")
@ToString(exclude = {"serverGroup"})
public class Server {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "server_group_id")
    private ServerGroup serverGroup;

    @Column(name = "server_type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "public_host")
    private String publicHost;

    @Column(name = "private_host")
    private String privateHost;

    @Column(name = "port")
    private Integer port;

    @Column(name = "port2")
    private Integer port2;
}
