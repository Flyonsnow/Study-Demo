package com.wenxuezheng.design.pattern.factory.abstract_factory;


/**
 * TODO
 *
 * @author    
 * @date 2021/7/1 1:51 下午
 */
public class OfficeFileFactory implements IFileFactory{

    @Override
    public IWord getWord() {
        return new OfficeWord();
    }

    @Override
    public IExcel getExcel() {
        return new OfficeExcel();
    }
}
