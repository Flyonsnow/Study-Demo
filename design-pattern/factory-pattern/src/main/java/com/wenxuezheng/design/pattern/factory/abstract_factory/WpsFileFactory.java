package com.wenxuezheng.design.pattern.factory.abstract_factory;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 1:51 下午
 */
public class WpsFileFactory implements IFileFactory {

    @Override
    public IWord getWord() {
        return new WpsWord();
    }

    @Override
    public IExcel getExcel() {
        return new WpsExcel();
    }
}
