package com.rsupport.webviewer.core.service;

import com.rsupport.webviewer.core.common.GenericManagerImpl;
import com.rsupport.webviewer.core.domain.ViewerAgent;
import com.rsupport.webviewer.core.repository.ViewerAgentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ViewerAgentManagerImpl extends GenericManagerImpl<ViewerAgent, String> implements ViewerAgentManager {

    private final ViewerAgentRepo viewerRepo;

    public ViewerAgentManagerImpl(ViewerAgentRepo viewerRepo) {
        super(viewerRepo);
        this.viewerRepo = viewerRepo;
    }
}
