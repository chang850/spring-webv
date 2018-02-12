package com.rsupport.webviewer.web.viewer;


import com.rsupport.webviewer.core.common.BaseException;
import com.rsupport.webviewer.core.common.ExceptionStatus;

public class ViewerNotFoundException extends BaseException {

    private static final long serialVersionUID = -5150438818964082855L;

    public ViewerNotFoundException() {
        super(ExceptionStatus.USER_TEAM_STATUS_CHANGE_IMPOSSIBLE);
    }
}
