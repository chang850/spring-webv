package com.rsupport.webviewer.core.common;


import com.rsupport.webviewer.core.domain.ViewerAgent;
import com.rsupport.webviewer.core.domain.ViewerAgentLog;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.*;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

//이런식으로 하면 Listener 를 두번 탈텐데.....
//@Component
public class LogWriterListener implements PostInsertEventListener, PostUpdateEventListener {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(new LogWriterListener());
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(new LogWriterListener());
    }

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        Object entity = postInsertEvent.getEntity();
        Session session = postInsertEvent.getSession().getSessionFactory().openSession();
        if (entity instanceof ViewerAgent) {
            ViewerAgentLog viewerAgentLog = new ViewerAgentLog();
            viewerAgentLog.setId("111111");
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(viewerAgentLog);
            tx.commit();
            session.close();
        }
    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {

        String temp = " changghee";
        String temp2 = "changhee3";
        return false;
    }
}
