package com.ultral.tx.api.proxy;

public class DocServiceImpl implements DocService {
    @Override
    public void create() {
        System.out.println("this is real method create");
    }

    @Override
    public void update() {
        System.out.println("this is real method update");
    }

    @Override
    public void getDraft() {
        System.out.println("this is real method getDraft");
    }
}
