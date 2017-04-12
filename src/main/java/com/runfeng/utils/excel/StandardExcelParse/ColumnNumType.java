package com.runfeng.utils.excel.StandardExcelParse;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.Internal;

/**
 * Created by lenovo on 2017/4/12.
 */
enum CellTypeOA{
    NONE,
    NUMBER,
    DATE,
    STRING,
    FORMULA,
    BLANK,
    BOOLEAN,
    ERROR;
}
public class ColumnNumType {
    private int columnNum;
    private CellTypeOA columnType;

    public ColumnNumType(int columnNum, CellTypeOA columnType) {
        this.columnNum = columnNum;
        this.columnType = columnType;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public CellTypeOA getColumnType() {
        return columnType;
    }

    public void setColumnType(CellTypeOA columnType) {
        this.columnType = columnType;
    }
}
