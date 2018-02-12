package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManger;
import com.rsupport.webviewer.core.domain.ViewerRoom;
import com.rsupport.webviewer.core.vo.ResponseVO;

public interface ViewerRoomManager extends GenericManger<ViewerRoom, String> {
    ViewerRoom getSupportRoomByName(String name);

    ResponseVO createGroup();
}
