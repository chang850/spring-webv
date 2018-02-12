package com.rsupport.webviewer.support;

import com.rsupport.webviewer.common.BaseRepositoryTest;
import com.rsupport.webviewer.core.repository.ViewerRoomRepo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SupportRoomBaseRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ViewerRoomRepo supportRoomRepo;

    @Ignore
    @Test
    public void Test() {
//        SupportRoom supportRoom = supportRoomRepo.findByName("4444");
//        supportRoom.setAge("989898");
//        entityManager.persist(supportRoom);
//        entityManager.flush();
    }


}
