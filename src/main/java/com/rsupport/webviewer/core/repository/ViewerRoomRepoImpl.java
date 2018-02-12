package com.rsupport.webviewer.core.repository;

import com.rsupport.webviewer.core.domain.ViewerRoom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;


@Repository
public class ViewerRoomRepoImpl extends QueryDslRepositorySupport implements ViewerRoomRepoCustom {

    public ViewerRoomRepoImpl() {
        super(ViewerRoom.class);
    }

    @Override
    public ViewerRoom findByName(String name) {
//        QSupportRoom supportRoom = QSupportRoom.supportRoom;
//        SupportRoom result = from(supportRoom).where(supportRoom.name.eq(name)).fetchOne();

        return null;
    }


//    @Override
//    public SupportRoomListResponseVO getSupportRoomResponseVO(String name) {
//        SupportRoomListResponseVO listVO = new SupportRoomListResponseVO();
//        QSupportRoom supportRoom = QSupportRoom.supportRoom;
//        //List<SupportRoom> result = from(supportRoom).where(supportRoom.name.eq(name)).fetch();
//        //두가지 타입으로 사용 가능하다.......
//
//        listVO.setList(from(supportRoom).where(supportRoom.name.eq(name))
//                .select(Projections.bean(SupportRoomListResponseVO.class, supportRoom.age)).fetch());
//
////        listVO.setList(from(supportRoom).where(supportRoom.name.eq(name))
////                .select(new QSupportRoomResponseVO(
////                        supportRoom.age,
////                        supportRoom.name
////                )).fetch());
//
//        return listVO;
//    }

    /*@Override
    public SupportRoomResponseVO getSupportRoomResponseVO(String name) {
        SupportRoomResponseVO listVO = new SupportRoomResponseVO();
        QSupportRoom supportRoom = QSupportRoom.supportRoom;
        List<SupportRoom> result = from(supportRoom).where(supportRoom.name.eq(name)).fetch();

        listVO.setList(from(supportRoom).where(supportRoom.name.eq(name))
                .select(new QSupportRoomResponseVO(
                        supportRoom.age,
                        supportRoom.name
                )).fetch());


        return null;
    }*/

    /*@Override
    public Optional<SupportRoom> findByName(String name) {
        QSupportRoom supportRoom = QSupportRoom.supportRoom;
        SupportRoom result = from(supportRoom).where(supportRoom.name.eq(name)).fetchOne();

        return Optional.ofNullable(result);
    }*/
}
