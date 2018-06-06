
function  queryData() {
    var formElement = $("#form");
    formElement.prop("action", path+"/user/getSelectiveGeneralUsers");
    $.ajax({
        type : formElement.prop("method"),// 提交方式 get/post
        url : formElement.prop("action"),
        data : formElement.serialize(),
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code=="0000") {
                //tipsMsg(data.msg);
                var url=path+"/user/manageUser";
                //window.location.href=url;
                doAfterGetLists(data);
            }
            tipsMsg(data.msg);
        },
    });
}

function doAfterGetLists(data) {
    console.log("data的值为："+data);
    $("#detailLinkDiv").hide();
    var tbodyElement = $("#staffListTable tbody");
    tbodyElement.html("");
    var staffList = "";
    var object = data.page;
    if (object) {
        staffList = object.list;
        if(!staffList){
            staffList = "";
        }
    }
    var dataGird = "";
    for (var i = 0; i < staffList.length; i++) {
        var staffInfo = staffList[i];
        var trElement = "<tr><td><input class='childrenCheckBox' type='checkbox' value='"
            + staffInfo.userid
            + "'/></td>"
            + "<td>"
            + staffInfo.userid
            + "</td>"
            + "<td>"
            + staffInfo.username
            + "</td>"
            + "<td>"
            + staffInfo.phone
            + "</td>"
            + "<td>"
            + staffInfo.idnumber
            + "</td></tr>";
        dataGird += trElement;
    }
    tbodyElement.html(dataGird);

    var dbCallBack = function (val, isAdd) {
        doListByCheckBox(staffIdList, val, isAdd);
    }

    tbodyElement.find("tr").each(function () {
        var $trElement = $(this);
        var $tdElement = $trElement.children("td:not(:first)");
        $tdElement.click(function () {
            var $checkBox = $trElement.find("input[type='checkbox']");
            var isCheck = $checkBox.prop("checked");
            $checkBox.prop("checked", !isCheck);
            isCheck = $checkBox.prop("checked");
            if (isCheck) {
                var k = tbodyElement.find("input[type='checkbox']").index($checkBox);
                getStaffInfoDataForm(staffList[k]);
            }
            doListByCheckBox(staffIdList, $checkBox.val(), isCheck);
        });
    });
    checkBoxClick();

    var checkboxInPage = tbodyElement.find("input[type='checkbox']");
    checkboxInPage.click(function () {
        if ($(this).prop("checked")) {
            var k = checkboxInPage.index($(this));
            getStaffInfoDataForm(staffList[k]);
        }
    });
    $("#detailLinkDiv").show();
    var pageMsg = data.page;
    if (pageMsg) {
        laypage({
            cont: $('#pageDiv'), // 容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div
            pages: pageMsg.pages,// 总页数
            curr: pageMsg.pageNum,// 当前页
            skip: true, // 是否开启跳页，
            skipBtnName: skipBtnName,
            skipMsg: skipMsg,
            showPageMsg: true,// 开启页面信息
            total: pageMsg.total,// 总条目数
            pageMsg: pageMsgStr,// 页面信息内容展示，必须用中英文符号按照顺序写
            pageMsgFontSize: 13,
            btnType: "button",
            first: 1,
            last: 1,// $("input[class='navigatePages']").val(),
            prev: '<', // 若不显示，设置false即可
            next: '>', // 若不显示，设置false即可
            jump: function (obj, first) { // 触发分页后的回调
                if (first)
                    return;
                $("[name='pageNum']").val(obj.curr);
                queryData();
            }
        });
    }

}