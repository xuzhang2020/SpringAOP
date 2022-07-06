package com.bfs.logindemo.exception.handle;

import com.bfs.logindemo.exception.UserNotFoundException;
import com.bfs.logindemo.tools.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseInfo<String> handlerUserNotFound(UserNotFoundException e){
        ResponseInfo<String> responseInfo = new ResponseInfo<>();
        responseInfo.setCode(ResponseInfo.ERROR);
        responseInfo.setMessage(e.getMessage()+" Not Found");

        log.error("UserNotFoundException occured:" + e.getMessage()+" Not Found");
        return responseInfo;
        //System.out.println("If UserNotFoundException throws, it will be intercepted by this handler");
        //return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()+" Not Found").build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseInfo<String> handlerException(Exception e){
        ResponseInfo<String> responseInfo = new ResponseInfo<>();
        responseInfo.setCode(ResponseInfo.ERROR);
        responseInfo.setMessage("General Exception:" + e.getMessage());
        log.error("General Exception occured:" + e.getMessage());
        return responseInfo;

        //return new ResponseEntity(ErrorMessage.builder().msg("General Exception"), HttpStatus.NOT_FOUND);
    }

}
