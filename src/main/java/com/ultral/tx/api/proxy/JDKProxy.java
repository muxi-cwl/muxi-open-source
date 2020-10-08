package com.ultral.tx.api.proxy;

import java.lang.reflect.Proxy;

public class JDKProxy {

    DocService docService;

     DocService getProxy(){

         DocService o =(DocService) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                 new Class[]{DocService.class}, new DocServiceHandler(docService));
         return o;
     }


    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        jdkProxy.docService = new DocServiceImpl();

        DocService proxy = jdkProxy.getProxy();

        proxy.create();
    }
}
