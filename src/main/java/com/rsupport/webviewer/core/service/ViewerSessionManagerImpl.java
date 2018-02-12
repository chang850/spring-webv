package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManagerImpl;
import com.rsupport.webviewer.core.domain.ViewerSession;
import com.rsupport.webviewer.core.repository.ViewerSessionRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewerSessionManagerImpl extends GenericManagerImpl<ViewerSession, String> implements ViewerSessionManager {

    private final ViewerSessionRepo viewerSessionRepo;

    public ViewerSessionManagerImpl(JpaRepository<ViewerSession, String> repository, ViewerSessionRepo viewerSessionRepo) {
        super(repository);
        this.viewerSessionRepo = viewerSessionRepo;
    }
}
