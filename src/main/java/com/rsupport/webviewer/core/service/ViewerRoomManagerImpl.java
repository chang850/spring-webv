package com.rsupport.webviewer.core.service;


import com.rsupport.webviewer.core.common.GenericManagerImpl;
import com.rsupport.webviewer.core.domain.ViewerRoom;
import com.rsupport.webviewer.core.repository.ViewerRoomRepo;
import com.rsupport.webviewer.core.repository.ViewerSessionRepo;
import com.rsupport.webviewer.core.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ViewerRoomManagerImpl extends GenericManagerImpl<ViewerRoom, String> implements ViewerRoomManager {

    private final ViewerRoomRepo viewerRoomRepo;

    public ViewerRoomManagerImpl(JpaRepository<ViewerRoom, String> repository, ViewerRoomRepo viewerRoomRepo) {
        super(repository);
        this.viewerRoomRepo = viewerRoomRepo;
    }

    @Override
    public ViewerRoom getSupportRoomByName(String name) {
        return viewerRoomRepo.findByName(name);
    }

    @Override
    public ResponseVO createGroup() {
        String accessCode = "77777";
        if (StringUtils.isNotBlank(accessCode)) {
//             supportRoom = new SupportRoom();
//            supportRoom.setAccessCode(accessCode);
//            supportRoom = supportRoomRepo.save(supportRoom);
//            SupportSession supportSession = new SupportSession();
//            supportSession.setSupportRoom(supportRoom);
//            supportSessionRepo.save(supportSession);
        }
        return new ResponseVO();
    }
}
