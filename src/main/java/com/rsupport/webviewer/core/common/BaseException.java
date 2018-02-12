package com.rsupport.webviewer.core.common;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class BaseException extends RuntimeException {

    private final ExceptionStatus exceptionStatus;

    public BaseException(ExceptionStatus exceptionStatus) {
        super();
        this.exceptionStatus = exceptionStatus;
    }
}
