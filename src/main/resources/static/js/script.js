$(document).ready(function () {

    $("tr td .btn").click(function () {
        $("#updateUserId").val($(this).closest("tr").find("#tableId").text());
        $("#updateUserId").prop("disabled", true);

        $("#updateUserName").val($(this).closest("tr").find("#tableName").text());

        $("#updateUserPass").hide();
        $("#updateUserPass").val($(this).closest("tr").find("#tablePass").text());

        var role = $(this).closest("tr").find("#tableRole").text();
        var rol = role.substring(1, role.length - 1).toString();
        var admin = "admin";
        if (rol == admin) {
            $('#updateUserRole option:contains("admin")').prop("selected", true);
        } else {
            $('#updateUserRole option:contains("user")').prop("selected", true);
        }

        $("#updateUserMess").val($(this).closest("tr").find("#tableMess").text());
    });

    $("#addFormUser").click(function () {
        /*var name = this.closest("input").find("#name");
        var password = this.closest("input").find("#password");
        var role = this.closest("input").find("#role");
        var message = this.closest("input").find("#message");*/

        alert('Load was performed.');
       /* alert( "name:"+ this.closest("input").find("#name"),
            "name:"+ this.closest("input").find("#password"),
            "name:"+  this.closest("input").find("#role"),
            "name:"+  this.closest("input").find("#message"),
            this.closest("form").attr('method'),
            this.closest("form").attr('action'));*/

       /* $.ajax({
            url: '/admin/add',
            success: function(){
                alert('Load was performed.');
            }
        });*/


        /*var user = {
            name: this.closest("input").find("#name"),
            password: this.closest("input").find("#password"),
            role: this.closest("input").find("#role"),
            message: this.closest("input").find("#message")
        }

        var json = JSON.stringify(user);
        let request = new XMLHttpRequest();

       // request.open(this.closest("form").attr('method'), this.closest("form").attr('action'));
        request.open('POST', 'http://localhost:8080/admin/add');
       // request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        request.send(json);

        alert("qwertyui");*/
    });

});