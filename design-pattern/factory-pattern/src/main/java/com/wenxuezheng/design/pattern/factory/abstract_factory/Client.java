package com.wenxuezheng.design.pattern.factory.abstract_factory;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 1:20 下午
 */
public class Client {

    public static void main(String[] args) {
        IFileFactory factory = new WpsFileFactory();
        factory.getWord();
        factory.getExcel();
        factory = new WpsFileFactory();
        factory.getWord();
        factory.getExcel();
    }
}
