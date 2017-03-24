/**
 * Created by lenovo on 2017/3/24.
 */
var informationTableHead ={
    eid:"EID", name:"姓名", sex:"性别", department:"部门", position:"职务", identification :"身份证号", hiredate:"入职日期"
};
var employees = [
    {eid:"001", name:"巩涛", sex:"男", department:"经理办", position:"班长", identification :"370783198708256132", hiredate:"2013-08"},
    {eid:"002", name:"张百城", sex:"男", department:"车间", position:"操作工", identification :"370783199408256132", hiredate:"2015-08"}];

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
        if (tableHead[a] == "EID" || tableHead[a] == "eid"){
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