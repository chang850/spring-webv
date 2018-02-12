package com.rsupport.webviewer.core.common;


import com.rsupport.webviewer.core.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseVO> handNotContent(BaseException ex) {
        ResponseVO errorVO = new ResponseVO(String.valueOf(ex.getExceptionStatus().getCode()), ex.getExceptionStatus().getMesssage());
        return new ResponseEntity<>(errorVO, HttpStatus.OK);
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ModelAndView handNotContent(BaseException ex) {
//
//        ErrorVO errorVO = new ErrorVO(ex.getExceptionStatus().code(), ex.getExceptionStatus().message());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject(errorVO);
//        return modelAndView;
//    }
}
