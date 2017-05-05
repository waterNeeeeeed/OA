<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <title>员工信息管理</title>

    <script type="text/javascript" src="extJS6/ext-all.js"></script>
    <script type="text/javascript" src="extJS6/ext-all-debug.js"></script>
    <script type="text/javascript" src="extJS6/ext-bootstrap.js"></script>
    <script type="text/javascript" src="extJS6/locale-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all.css"/>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all_1.css"/>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all_2.css"/>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all-debug.css"/>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all-debug_1.css"/>
    <link rel="stylesheet" type="text/css" href="extJS6/theme-crisp-all-debug_2.css"/>

</head>

<body>
<script type="text/javascript">
    Ext.onReady(function () {
        Ext.define('Book',{
            extend:'Ext.data.Model',
            fields:[
                {name:'id', type:'int'},
                {name:'name', type:'string'},
                {name:'author', type:'string'},
                {name:'price', type:'float'},
                {name:'publishDate', type:'date'}
                ]
        });
        var bookStore = Ext.create('Ext.data.Store',
            {
                model:'Book',
                data:[
                    {"id":1, name:"fkJava", author:"ligang", price:100, publishDate:'2012'},
                    {"id":2, name:"JaveEE", author:"ligang", price:22, publishDate:'2012'},
                    {"id":3, name:"fkAjax", author:"ligang", price:33, publishDate:'2012'},
                ]
            });
        Ext.create('Ext.grid.Panel',{
            title:'查看图书',
            width:550,
            renderTo:Ext.getBody(),
            columns:[
                {text:'序号', xtype:'rownumberer', flex:1},
                {text:'书号', dataIndex:'id', flex:1},
                {text:'书名', dataIndex:'name', flex:1,
                        editor:{xtype:'textfield', allowPattern:false}},

                {text:'作者', dataIndex:'author', flex:1,
                    editor:{xtype:'textfield', allowPattern:false}},
                {text:'价格', dataIndex:'price', flex:1,
                    editor:{xtype:'numberfield', allowPattern:false}},
                {text:'出版时间', dataIndex:'publishDate',
                    xtype:'datecolumn', format:'Y-m-d', flex:1},
            ],
            selType:'cellmodel',
            plugins:[
                {
                    ptype:'cellediting',
                    clicksToEdit:1
                }
            ],
            store:bookStore
        });
    });
    /*Ext.onReady(function () {
        var con = Ext.create('Ext.panel.Panel',
            {
                layout:{
                    align:'center'
                },
                title:'查询',
                height:280,
                renderTo: Ext.getBody(),
                defaults:{
                    style:{
                        padding:'5px',
                    },
                    bodyPadding:5
                },
                tools:[
                    {
                        type:'refresh',
                        tooltip:'刷新页面',
                        handler:function (event, toolEl, panel) {
                            alert("111");
                        }
                    }
                ]
            })
    })*/
    /*Ext.onReady(function () {
        var bn = Ext.create('Ext.button.Button',
            {
                text:"click me",
                scale:"large",
                renderTo: Ext.getBody(),
                handler:function () {
                    Ext.fly("target")
                        .setHeight(80)
                        .setWidth(90)
                        .center()
                        .highlight()
                        .setStyle("background-color", "#f0f")
                        .setStyle("border", "2px solid back");
                }
            });
    })*/
    /*Ext.onReady(function () {
        var con = Ext.create('Ext.panel.Panel',
            {
                layout:{
                    type:'vbox',
                    align:'center'
                },
                width:300,
                height:160,
                renderTo: Ext.getBody(),
                style:{
                    border:'1px solid black',
                    backgroundColor:'#afa'
                },
                defaults:{
                    labelWidth:120,
                    flex:1
                },
                items:[{
                    xtype:'datefield',
                    name:'startDate',
                    fieldLabel:'开始日期'
                },{
                    xtype:'datefield',
                    name:'endDate',
                    fieldLabel:'结束日期'
                }, {
                    xtype:'button',
                    text:'确定',
                    width:100,
                    height:20,
                    padding:'0px',
                    margin:'10px',
                    flex:0
                }]
            })
    });*/
</script>


</body>
<div id="target">

</div>
</html>