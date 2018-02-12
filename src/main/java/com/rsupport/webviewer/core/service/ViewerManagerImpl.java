package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManagerImpl;
import com.rsupport.webviewer.core.domain.ViewerAgent;
import com.rsupport.webviewer.core.domain.ViewerRoom;
import com.rsupport.webviewer.core.domain.ViewerSession;
import com.rsupport.webviewer.core.repository.ViewerAgentRepo;
import com.rsupport.webviewer.core.repository.ViewerRoomRepo;
import com.rsupport.webviewer.core.repository.ViewerSessionRepo;
import com.rsupport.webviewer.web.viewer.ViewerMakeRoomResVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewerManagerImpl extends GenericManagerImpl<ViewerAgent, String> implements ViewerManager {

    private final ViewerAgentRepo viewerAgentRepo;
    private final ViewerRoomRepo viewerRoomRepo;
    private final ViewerSessionRepo viewerSessionRepo;

    public ViewerManagerImpl(JpaRepository<ViewerAgent, String> repository,
                             ViewerAgentRepo viewerAgentRepo, ViewerRoomRepo viewerRoomRepo, ViewerSessionRepo viewerSessionRepo) {
        super(repository);
        this.viewerAgentRepo = viewerAgentRepo;
        this.viewerRoomRepo = viewerRoomRepo;
        this.viewerSessionRepo = viewerSessionRepo;
    }

    @Override
    public ViewerMakeRoomResVO makeGroup() {

        ViewerMakeRoomResVO resVO = new ViewerMakeRoomResVO();
        ViewerAgent viewerAgent = new ViewerAgent();
        viewerAgentRepo.save(viewerAgent);
        ViewerRoom viewerRoom = new ViewerRoom();
        ViewerSession viewerSession = new ViewerSession();
        viewerRoom.setAccessCode("77777");
        viewerRoomRepo.save(viewerRoom);
        viewerSession.setViewerAgent(viewerAgent);
        viewerSession.setViewerRoom(viewerRoom);
        viewerSessionRepo.save(viewerSession);
        resVO.setAccessCode(viewerRoom.getAccessCode());
        resVO.setViewerRoomId(viewerRoom.getId());
        resVO.setViewerSessionid(viewerSession.getId());

        return resVO;
    }

    //접속 번호 생성
    private String createAccessCode() {

        return null;
    }
}
