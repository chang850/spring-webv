package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManger;
import com.rsupport.webviewer.core.domain.Server;
import com.rsupport.webviewer.core.domain.ServerGroup;
import com.rsupport.webviewer.web.viewer.ViewerMakeRoomResVO;

import java.util.List;
import java.util.Set;

public interface ServerGroupManager extends GenericManger<ServerGroup, String> {

    ViewerMakeRoomResVO getServer(String id);
}
