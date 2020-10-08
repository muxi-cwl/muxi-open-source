package com.ultral.tx.api.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DocServiceHandler implements InvocationHandler {

    private DocService docService;

    DocServiceHandler(DocService docService){
        this.docService = docService;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is proxy.......");
        return method.invoke(docService,args);
    }
}
