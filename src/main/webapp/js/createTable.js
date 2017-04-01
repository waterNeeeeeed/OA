/**
 * Created by lenovo on 2017/3/24.
 */
var salaryTableHead ={
    eid:"EID", name:"姓名", department:"部门", date:"日期",
    salary:"应发工资", basicSalary:"基本工资", checkSalary:"考核工资", floatingSalary:"浮动工资",
    festivalSalary:"节日", holidaySalary:"假日", nightSalary:"夜班费", subsidySalary:"保健、补助",
    totalSalary:"合计"
};
var socialsecurityTableHead = {
    eid:"EID", name:"姓名", department:"部门", date:"日期", basicSS:"缴费基数",
    endowmentInsuranceCompany:"养老(单位)",
    endowmentInsuranceIndividual:"养老(个人)",
    medicalInsuranceCompany:"医疗(单位)",
    medicalInsuranceIndividual:"医疗(个人)",
    unemploymentInsuranceCompany:"失业(单位)",
    unemploymentInsuranceIndividual:"失业(个人)",
    employmentInjuryInsuranceCompany:"工伤(单位)",
    employmentInjuryInsuranceIndividual:"工伤(个人)",
    maternityInsuranceCompany:"生育(单位)",
    maternityInsuranceIndividual:"生育(个人)",
    totalCompany:"合计(单位)",
    totalIndividual:"合计(个人)"
};
var employeesSalary = [
    {
        eid:"001", name:"巩涛", department:"经理办", date:"2017-02",
        salary:"20000", basicSalary:"5000", checkSalary:"5000", floatingSalary:"5000",
        festivalSalary:"200", holidaySalary:"200", nightSalary:"200", subsidySalary:"200",
        totalSalary:"20000"
    },
    {
        eid:"002", name:"张百成", department:"车间", date:"2017-02",
        salary:"20000", basicSalary:"5000", checkSalary:"5000", floatingSalary:"5000",
        festivalSalary:"200", holidaySalary:"200", nightSalary:"200", subsidySalary:"200",
        totalSalary:"20000"
    }
];
var employeesSalaryOffice =[
    {
        eid:"001", name:"巩涛", department:"经理办", date:"2017-02",
        salary:"20000", basicSalary:"5000", checkSalary:"5000", floatingSalary:"5000",
        festivalSalary:"200", holidaySalary:"200", nightSalary:"200", subsidySalary:"200",
        totalSalary:"20000"
    }
];
var employeesSS = [
    {
        eid:"001", name:"巩涛", department:"经理办", date:"2017-02", basicSS:"5000",
        endowmentInsuranceCompany:"5000",
        endowmentInsuranceIndividual:"5000",
        medicalInsuranceCompany:"5000",
        medicalInsuranceIndividual:"5000",
        unemploymentInsuranceCompany:"5000",
        unemploymentInsuranceIndividual:"5000",
        employmentInjuryInsuranceCompany:"5000",
        employmentInjuryInsuranceIndividual:"5000",
        maternityInsuranceCompany:"5000",
        maternityInsuranceIndividual:"5000",
        totalCompany:"5000",
        totalIndividual:"5000"
    },{
        eid:"002", name:"张百成", department:"车间", date:"2017-02", basicSS:"5000",
        endowmentInsuranceCompany:"5000",
        endowmentInsuranceIndividual:"5000",
        medicalInsuranceCompany:"5000",
        medicalInsuranceIndividual:"5000",
        unemploymentInsuranceCompany:"5000",
        unemploymentInsuranceIndividual:"5000",
        employmentInjuryInsuranceCompany:"5000",
        employmentInjuryInsuranceIndividual:"5000",
        maternityInsuranceCompany:"5000",
        maternityInsuranceIndividual:"5000",
        totalCompany:"5000",
        totalIndividual:"5000"
    }
];
var employeesSSOffice = [{
        eid:"001", name:"巩涛", department:"经理办", date:"2017-02", basicSS:"5000",
        endowmentInsuranceCompany:"5000",
        endowmentInsuranceIndividual:"5000",
        medicalInsuranceCompany:"5000",
        medicalInsuranceIndividual:"5000",
        unemploymentInsuranceCompany:"5000",
        unemploymentInsuranceIndividual:"5000",
        employmentInjuryInsuranceCompany:"5000",
        employmentInjuryInsuranceIndividual:"5000",
        maternityInsuranceCompany:"5000",
        maternityInsuranceIndividual:"5000",
        totalCompany:"5000",
        totalIndividual:"5000"
    }];

var informationTableHead ={
    eid:"EID", name:"姓名", sex:"性别", department:"部门", post:"岗位", position:"职务", telephone:"电话", identification :"身份证号", nativeplace:"籍贯", educationalbackground:"学历", school:"学校", schoolform:"办学形式", major:"主修", contractid:"合同编号", contractstartdate:"合同开始日期", contractenddate:"合同结束日期", contractstate:"合同状态", positionstate:"岗位状态"
};
var employeesInfo = [
    {eid:"001", name:"巩涛", sex:"男", department:"经理办", post:"劳资科", position:"班长", telephone:"15953680098", identification :"370783198708256132", nativeplace:"山东潍坊", educationalbackground:"本科", school:"青岛大学", schoolform:"全日制", major:"电子信息工程", contractid:"JY0001", contractstartdate:"2013-08", contractenddate:"2016-08", contractstate:"江岳续签", positionstate:"在岗"},
    {eid:"002", name:"张百城", sex:"男", department:"车间", post:"三车间后段二班", position:"操作工", telephone:"", identification :"370783199408256132", nativeplace:"山东潍坊", educationalbackground:"高级技工", school:"潍柴", major:"汽车维修", schoolform:"全日制", contractid:"JY0002", contractstartdate:"2015-08", contractenddate:"2018-08", contractstate:"江岳签约", positionstate:"外派"}];
var employeesInfoOffice = [
    {eid:"001", name:"巩涛", sex:"男", department:"经理办", post:"劳资科", position:"班长", telephone:"15953680098", identification :"370783198708256132", nativeplace:"山东潍坊", educationalbackground:"本科", school:"青岛大学", schoolform:"全日制", major:"电子信息工程", contractid:"JY0001", contractstartdate:"2013-08", contractenddate:"2016-08", contractstate:"江岳续签", positionstate:"在岗"}
];
function createTable(document, tableID, tableHead, tableContent, tableHeadName) {
    var table = document.getElementById(tableID);
    var old_length = table.rows.length;
    //删除旧的表格
    for (var i=old_length-1; i>=0; i--){
        table.deleteRow(i);
    }
    //设置表头
    var nhead = 0;
    var ncell = 0;
    var th = table.insertRow(nhead);
    for (var a in tableHead){
        var td = th.insertCell(ncell);
        td.innerHTML = tableHead[a];
        ncell++;
    }
    var td = th.insertCell(ncell);
    td.innerHTML = "操作";
    th.setAttribute("style", "font-weight:bold");
    //设置表内容
    for (var i=0; i<tableContent.length; i++){
        var tr = table.insertRow(i+1);
        var ncell = 0;
        for (var b in tableContent[i]){
            var td = tr.insertCell(ncell);
            td.innerHTML = tableContent[i][b];
            //td.setAttribute("style", "white-space:nowrap");
            /*if (b == "date"){
                var date = new Date(tableContent[i][b]);
                td.innerHTML = date.getFullYear()+"-" + date.getMonth();
            }*/

            ncell++;
        }
        //最后增加操作项
        var td = tr.insertCell(ncell);
        td.innerHTML = "<button data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@getbootstrap\" onclick=\"createEmployeeInfoForm(document, this,'" + tableID + "','EmployeeInfoFormDiv','saveModificationBtn'," +tableHeadName +")\" value=\"" + (i+1) + "\" class=\"btn btn-success btn-sm\">修改</button>";
    }
}
function createEmployeeInfoForm(document, target, tableId, formId, saveBtnId, tableHead) {
    var rowsIndex = target.value;
    var table = document.getElementById(tableId);
    var formContent = document.getElementById(formId);
    var saveBtn = document.getElementById(saveBtnId);
    saveBtn.value = rowsIndex;
    //先清空旧有元素
    formContent.innerHTML = "";

    var cellsIndex = 0;
    for (var a in tableHead){
        var label = document.createElement("label");

        label.setAttribute("for", tableHead[a]);
        label.setAttribute("class", "control-label");
        label.innerHTML = tableHead[a];
        var input = document.createElement("input");
        input.setAttribute("type", "text");
        input.setAttribute("class", "form-control");
        input.setAttribute("id", tableHead[a]);
        input.setAttribute("value", table.rows[rowsIndex].cells[cellsIndex].innerHTML);
        //EID不可更改
        if (tableHead[a] == "EID" || tableHead[a] == "eid" || tableHead[a] == "日期"){
            input.setAttribute("disabled", "disabled");
        }
        formContent.appendChild(label);
        formContent.appendChild(input);
        cellsIndex++;
    }
}
//保存修改
function saveModification(document, tableId, formId, saveBtnId) {
    var table = document.getElementById(tableId);
    var formContent = document.getElementById(formId);
    var saveBtn = document.getElementById(saveBtnId);
    var content = formContent.getElementsByTagName("input");
    var rowsIndex = saveBtn.value;
    var n = 0;
    for (var a in content){
        table.rows[rowsIndex].cells[n].innerHTML = content[n].value;
        n++;
    }
}
//设置大标题
function setCaption(document, text) {
    var div = document.getElementById("captionTypeDiv");
    div.setAttribute("style", "text-align:center;font-weight:bold;font-size:26px;");
    div.innerHTML = text;
}