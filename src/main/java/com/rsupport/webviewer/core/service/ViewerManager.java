package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManger;
import com.rsupport.webviewer.core.domain.ViewerAgent;
import com.rsupport.webviewer.web.viewer.ViewerMakeRoomResVO;

public interface ViewerManager extends GenericManger<ViewerAgent, String> {

    ViewerMakeRoomResVO makeGroup();
}
