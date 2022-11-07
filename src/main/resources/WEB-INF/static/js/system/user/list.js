

$(function () {
    myTable = initializeTable();
});

function initializeTable() {
    var dutyTable = $('#sampleTable').DataTable({
        "searching": false,
        "autoWidth": true,
        "rowId": 'id',
        "pagingType": "full_numbers",
        //获取数据
        "ajax": {
            "url": baseUrl + user.list,
            "type": 'POST',
            //绑定额外参数
            "data": function (data) {
                data.page=1;
                data.pageSize=10;
                return data;
            }
        },
        //设置数据
        "columns": [
            {"data": "id","className": "主键","width": 40},
            {"data": "username","className": "用户名"},
            {"data": "email"},
            {"data": "mobile"},
       ]
    });
}