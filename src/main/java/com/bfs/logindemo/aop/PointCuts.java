package com.bfs.logindemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {

    @Pointcut("execution(* com.bfs.logindemo.dao.BookDAO.findAll(..))")
    //@Pointcut("execution(public * com.bfs.logindemo.dao.BookDAO.*(..))")
    public void inBookDAOFindAll() {}

    @Pointcut("within(com.bfs.logindemo.dao.UserDAO)")
    public void inUserDAOLayer() {}

    @Pointcut("bean(*myBookDAO)")
    public void inBookDAO(){}

    @Pointcut("within(com.bfs.logindemo.controller.*)")
    public void inWebLayer() {}



/*
    @Pointcut("within(com.bfs.demo.controller.*)")
    public void inWebLayer() {}

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void inWebLayer1(){}

    @Pointcut("within(com.bfs.demo.service..*)")
    public void inServiceLayer() {}

    @Pointcut("execution(* com.bfs.demo.service..*.*(..))")
    public void inServiceLayer1() {}

    @Pointcut("bean(*Service)")
    public void inServiceLayer2(){}

    @Pointcut("within(com.bfs.demo.dao..*)")
    public void inDataAccessLayer() {}

    @Pointcut("execution(* com.bfs.demo.dao.*.getUserName*(..))")
    public void dataAccessOperation() {}

    @Pointcut("args()")
    public void noParameter(){}

 */
}
