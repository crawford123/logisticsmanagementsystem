
$(function () {
    //�����ҳ��
    tcdPageCode();
    //��ʼ������
    IndexByPage();
})

function tcdPageCode() {
    $("#tcdPageCode").createPage({
        pageCount: 1,
        current: pageNo,
        backFn: function (num, type) {
            if (type != 'init') {
                pageNo = num;
                IndexByPage();
            }
        }
    });
}
var pageNo = 1;
var pageSize = 10;
//��Ҫ�����ѯ
function IndexByPage() {
    var datas = {};//��������
    datas["sort"] = "CreateOn";
    datas["direction"] = "DESC";
    datas["pager.pageNo"] = pageNo;//��nҳ
    datas["pager.pageSize"] = pageSize;//ÿҳ��С

    $.ajax({
        type: "POST",
        data: datas,
        url: "/News/IndexByPage",
        success: function (result) {
            console.info(result)
            var totalCount = 0;
            if (result != null && result.rows != undefined) {
                totalCount = result["pager.totalRows"];
            }
            if (totalCount > 0) {
                var conunt = 0;
                if (totalCount % pageSize == 0) {
                    conunt = totalCount / pageSize;
                }
                else {
                    conunt = Math.floor(totalCount / pageSize) + 1;
                }
                if (conunt == 0) {
                    conunt = 1;
                }
                $('#newsList').empty();
                $("#template").tmpl(result.rows).appendTo('#newsList');
                $("#tcdPageCode").createPage(
                               {
                                   current: pageNo,
                                   pageCount: conunt
                               });
            }
        }
    })
}

