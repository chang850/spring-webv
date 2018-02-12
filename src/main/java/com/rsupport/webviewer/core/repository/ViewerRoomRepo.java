package com.rsupport.webviewer.core.repository;

import com.rsupport.webviewer.core.domain.ViewerRoom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ViewerRoomRepo extends JpaRepository<ViewerRoom, String>, ViewerRoomRepoCustom {

}
