package com.runfeng.utils.excel.StandardExcelParse;

import com.runfeng.hibernate.SalaryEntity.CAJiangYue;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.*;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

/**
 * Created by lenovo on 2017/4/12.
 */
public class StandardExcelParseTest {
    @Test
    public void readRowToEntityTest() throws Exception {
        Workbook workbook = WorkbookFactory
                .create(new File("江岳OA/考勤/2017年4月考勤表模板.xls"));

        String[] SheetName = {"公司领导", "经理办", "财务部", "设备工程部", "公用工程部", "生产部",
                                "质检部", "车间1", "车间2", "车间3"};
        List<CAJiangYue> caJiangYue = new ArrayList<>();
        //以后固定18行
        int[] rowStops = {21, 21, 21, 21, 21, 21, 21, 21, 21, 21};
        //固定不变
        int[] nums = {0, 1, 4, 5, 6, 7, 8, 19, 20, 18, 12, 11, 15};
        CellTypeOA[] cellTypeOAS = {CellTypeOA.NUMBER, CellTypeOA.STRING, CellTypeOA.NUMBER,
                CellTypeOA.NUMBER, CellTypeOA.NUMBER, CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER};
        ColumnNumType[] columnNumType = new ColumnNumType[nums.length];
        for (int i=0; i<cellTypeOAS.length; i++){
            columnNumType[i] = new ColumnNumType(nums[i], cellTypeOAS[i]);
        }

        for(int m=0; m<SheetName.length; m++){
            int rowStart = 4;
            int rowStop = rowStops[m];
            Sheet sheet = workbook.getSheet(SheetName[m]);
            int nameCellIndex = 1;
            for (int n=rowStart; n <= rowStop; n++){
                if(!StandardExcelParse.isCellNullOrBlank(sheet.getRow(n).getCell(nameCellIndex))){
                    caJiangYue.add(StandardExcelParse.readRowToEntity(CAJiangYue.class, workbook, sheet.getRow(n), columnNumType));
                }
            }

        }

        //将数据写入
        Map<String, CAJiangYue> caJiangYueMap = new LinkedHashMap<>();
        for (Iterator it=caJiangYue.iterator(); it.hasNext();){
            CAJiangYue caJiangYue1 = (CAJiangYue)it.next();
            caJiangYueMap.put(caJiangYue1.getName(), caJiangYue1);
        }
        workbook.close();
        Workbook wb = WorkbookFactory.create(new File("江岳OA/考勤/2017全员考勤表.xls"));
        Sheet sheet1 = wb.getSheet("2017-4");

        Field[] fields = CAJiangYue.class.getDeclaredFields();
        for(int i=2; i<118; i++){
            Row row = sheet1.getRow(i);
            Cell nameCell = row.getCell(2);
            if (StandardExcelParse.isCellNullOrBlank(nameCell) || !caJiangYueMap.containsKey(nameCell.getRichStringCellValue().getString())){
                continue;
            }
            String name = nameCell.getRichStringCellValue().getString();
            //考勤入表
            for(int cellNum=3; cellNum<14; cellNum++){
                String methodName = "get" + fields[cellNum-1].getName().substring(0,1).toUpperCase()
                        + fields[cellNum-1].getName().substring(1);
                int temp = (int)CAJiangYue.class.getMethod(methodName).invoke(caJiangYueMap.get(name));
                CellStyle newCellStyle = row.getCell(cellNum).getCellStyle();
                Cell newCell = row.createCell(cellNum);
                newCell.setCellStyle(newCellStyle);
                newCell.setCellValue(temp);
            }
            //计算结果
            for(int cellNum=18; cellNum<=23; cellNum++){
                Cell tempCell = row.getCell(cellNum);
                if (StandardExcelParse.isCellFormula(tempCell)){
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellValue cellValue = evaluator.evaluate(tempCell);
                    double result = 0;
                    if (cellValue.getCellType() == CELL_TYPE_NUMERIC){
                        result = cellValue.getNumberValue();
                    }
                    Cell oldCell = row.getCell(cellNum);
                    CellStyle newCellStyle = oldCell.getCellStyle();
                    String newCellFormula = oldCell.getCellFormula();

                    Cell newCell = row.createCell(cellNum);
                    newCell.setCellStyle(newCellStyle);
                    newCell.setCellValue(result);
                    newCell.setCellFormula(newCellFormula);
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File("江岳OA/考勤/2017全员考勤表_完整" + ".xls"));
        wb.write(fileOutputStream);
        wb.close();
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