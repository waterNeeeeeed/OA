package com.runfeng.utils.excel.StandardExcelParse;

import com.runfeng.hibernate.SalaryEntity.CAJiangYue;
import com.runfeng.utils.JsonUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/4/12.
 */
public class StandardExcelParseTest {
    @Test
    public void readRowToEntityTest() throws Exception {
        Workbook workbook = WorkbookFactory
                .create(new File("江岳OA/考勤/2017年3月考勤表模板.xls"));

        String[] SheetName = {"公司领导", "经理办", "财务部", "设备工程部", "公用工程部", "生产部",
                                "质检部", "车间"};
        List<CAJiangYue> caJiangYue = new ArrayList<>();
        int[] rowStops = {9, 13, 5, 12, 21, 6, 10, 57};
        for(int m=0; m<8; m++){
            int rowStart = 4;
            int rowStop = rowStops[m];


            Sheet sheet = workbook.getSheet(SheetName[m]);

            //固定不变
            int[] nums = {0, 1, 4, 5, 6, 7, 8, 19, 20, 18, 18, 12, 11, 15};
            CellTypeOA[] cellTypeOAS = {CellTypeOA.NUMBER, CellTypeOA.STRING, CellTypeOA.NUMBER,
                    CellTypeOA.NUMBER, CellTypeOA.NUMBER, CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                    CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                    CellTypeOA.NUMBER,CellTypeOA.NUMBER};
            ColumnNumType[] columnNumType = new ColumnNumType[14];

            for (int i=0; i<14; i++){
                columnNumType[i] = new ColumnNumType(nums[i], cellTypeOAS[i]);
            }

            for (int n=rowStart; n <= rowStop; n++){
                caJiangYue.add(StandardExcelParse.readRowToEntity(CAJiangYue.class, workbook, sheet.getRow(n), columnNumType));
            }
            //JsonUtil.toJson(caJiangYue);

        }
        workbook.close();

    }

/* 0, 1, 4, 5, 6, 7, 8, 19, 20, 18, 18, 12, 11, 15
0    private int orderNum;
1    private int name;
4    private int nightShiftFull;
5    private int nightShiftBig;
6    private int nightShiftLittle;
7    private int festival;
8    private int holiday;
19    private int attendenceEstimated;
20    private int attendenceActual;
18    private int maritalLeave;
18    private int funeralLeave;
12    private int affairLeave;
11    private int sickLeave;
15    private int maternityLeave;
        * */
}