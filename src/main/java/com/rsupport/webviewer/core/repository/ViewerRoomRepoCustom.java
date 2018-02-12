package com.rsupport.webviewer.core.repository;


import com.rsupport.webviewer.core.domain.ViewerRoom;


public interface ViewerRoomRepoCustom {
    ViewerRoom findByName(String name);
    //SupportRoomListResponseVO getSupportRoomResponseVO(String name);
}
