    create table nt_server (
        id varchar(255) not null,
        name varchar(255),
        port integer,
        port2 integer,
        private_host varchar(255),
        public_host varchar(255),
        server_type varchar(255),
        server_group_id varchar(255) not null,
        primary key (id)
    );

    create table nt_server_group (
        id varchar(255) not null,
        name varchar(255),
        primary key (id)
    );

    create table rt_viewer_agent (
        id varchar(255) not null,
        primary key (id)
    );

    create table rt_viewer_room (
        id varchar(255) not null,
        access_code varchar(255),
        primary key (id)
    );

    create table rt_viewer_session (
        id varchar(255) not null,
        agent_id varchar(255) not null,
        room_id varchar(255) not null,
        primary key (id)
    );

    alter table nt_server
        add constraint FK_f0movpkgo0ngtpqb1o6blwbo5
        foreign key (server_group_id)
        references nt_server_group (id);

    alter table rt_viewer_session
        add constraint FK_q31x8njl1wrn5qsguae4sikvb
        foreign key (agent_id)
        references rt_viewer_agent (id);

    alter table rt_viewer_session
        add constraint FK_j2lgxlskmkg60cd1v7dctgs72
        foreign key (room_id)
        references rt_viewer_room (id);
