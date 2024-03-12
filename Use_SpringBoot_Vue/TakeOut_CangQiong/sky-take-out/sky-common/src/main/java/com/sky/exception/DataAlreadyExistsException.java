package com.sky.exception;


/**
 * 菜品分类名字重复
 */
public class DataAlreadyExistsException extends BaseException{
    public DataAlreadyExistsException(){

    }

    public DataAlreadyExistsException(String msg){
        super(msg);
    }
}
