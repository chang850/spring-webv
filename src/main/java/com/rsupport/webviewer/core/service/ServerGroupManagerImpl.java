package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.CommonCodes;
import com.rsupport.webviewer.core.common.GenericManagerImpl;
import com.rsupport.webviewer.core.domain.Server;
import com.rsupport.webviewer.core.domain.ServerGroup;
import com.rsupport.webviewer.core.repository.ServerGroupRepo;
import com.rsupport.webviewer.web.viewer.ViewerMakeRoomResVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ServerGroupManagerImpl extends GenericManagerImpl<ServerGroup, String> implements ServerGroupManager {

    private final ServerGroupRepo serverGroupRepo;

    public ServerGroupManagerImpl(JpaRepository<ServerGroup, String> repository, ServerGroupRepo serverGroupRepo) {
        super(repository);
        this.serverGroupRepo = serverGroupRepo;
    }

    @Override
    public ViewerMakeRoomResVO getServer(String id) {
        ViewerMakeRoomResVO viewerMakeRoomResVO = new ViewerMakeRoomResVO();
        ServerGroup serverGroup = serverGroupRepo.findOne(id);


//        serverGroup.getServers().forEach(server -> {
//            if (CommonCodes.ServerType.PUSH.equals(server.getType())) {
//                viewerMakeRoomResVO.getPushServerList().add(new ViewerMakeRoomResVO.SupportServer(server.getId(), server.getPublicHost(), server.getPort()));
//            } else if (CommonCodes.ServerType.RSNET.equals(server.getType())) {
//                viewerMakeRoomResVO.getRsNetServerList().add(new ViewerMakeRoomResVO.SupportServer(server.getId(), server.getPublicHost(), server.getPort()));
//            }
//        });

        for (Server server : serverGroup.getServers()) {
            if (CommonCodes.ServerType.PUSH.equals(server.getType())) {
                viewerMakeRoomResVO.getPushServerList().add(new ViewerMakeRoomResVO.SupportServer(server.getId(), server.getPublicHost(), server.getPort2()));
            } else if (CommonCodes.ServerType.RSNET.equals(server.getType())) {
                viewerMakeRoomResVO.getRsNetServerList().add(new ViewerMakeRoomResVO.SupportServer(server.getId(), server.getPublicHost(), server.getPort2()));
            }
        }

        return viewerMakeRoomResVO;
    }
}
