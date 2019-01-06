package com.neuedu.web.util;

import java.sql.ResultSet;


public interface IRowMap<T> {
    public T rowMap(ResultSet rs);

}
