package com.ego.commons.pojo.exception;

/**
 * 数据库操作异常
 * @author Lin
 */
public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
