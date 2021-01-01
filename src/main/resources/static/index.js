$(function () {

    if($('#messages').text()!=""){
        alert($('#messages').text());
    }

    if($('#boolean').text()!="" && $('#boolean').text()=="true"){
        doOtherthing(0);
    }else if($('#boolean').text()!="" && $('#boolean').text()=="false") {
        doOnething();
    }

    $('#information').click(function () {
        if($('#sno').text() == ""){
            alert("请登录！！！");
        }else {
            $('#tb1').empty();
            $('#t1').css("display","block");
            $('#t2').css("display","none");
            $('#t3').css("display","none");
            let a = $('#sno').text();
            $.post({
                url: "/selectMyInformation",
                data:{'sno':a},
                success: function (data) {
                    $('#tb1').append('<tr>');
                    $('#tb1').append('<td>' + data.sno + '</td>');
                    $('#tb1').append('<td>' + data.sname + '</td>');
                    $('#tb1').append('<td>' + data.ssex + '</td>');
                    $('#tb1').append('</tr>');
                }
            })
        }
    })

    $('#courses').click(function () {

        doOnething();

    })

    $('#selectCourse').click(function () {

        doOtherthing(0);

    })

    // $('#selectTname').click(function () {
    //     alert((this).value);
    //     return
    // })

    function doOnething() {

        if($('#sno').text() == ""){
            alert("请登录！！！");
        }else{
            $('#tb2').empty();
            $('#t1').css("display","none");
            $('#t2').css("display","block");
            $('#t3').css("display","none");
            $.get({
                url: "/selectAll",
                success: function (data) {
                    for (let i=0;i<data.length;i++){
                        $('#tb2').append('<tr>');
                        $('#tb2').append('<td>' + data[i].cno + '</td>');
                        $('#tb2').append('<td>' + data[i].cname + '</td>');
                        $('#tb2').append('<td><a id="b' + i + '" class="a" href="javaScript:void(0)">' + data[i].tno + '</a></td>');
                        $('#tb2').append('<td>' + data[i].credit + '</td>');
                        $('#tb2').append('<td><input name="cno" type="radio" value="'+ data[i].cno +'" /></td>');
                        $('#tb2').append('</tr>');
                        dontOnething(i);
                    }
                }
            })
        }

    }

    function doOtherthing(n) {
        if($('#sno').text() == ""){
            alert("请登录！！！");
        }else {
            $('#tb3').empty();
            $('#t1').css("display","none");
            $('#t2').css("display","none");
            $('#t3').css("display","block");
            let a = $('#sno').text();
            $.post({
                url: "/selectMySelectCourse",
                data:{'sno':a,'judge':n},
                success: function (data) {
                    for (let i=0;i<data.length;i++){
                        $('#tb3').append('<tr>');
                        $('#tb3').append('<td>' + data[i].sno + '</td>');
                        $('#tb3').append('<td><a id="c' + i + '" class="a" href="javaScript:void(0)">' + data[i].cno + '</a></td>');
                        $('#tb3').append('<td><a id="a' + i + '" class="a" href="javaScript:void(0)">' + data[i].tno + '</a></td>');
                        $('#tb3').append('<td id="semester' + i + '">' + data[i].semester + '</td>');
                        $('#tb3').append('<td>' + data[i].credit + '</td>');
                        $('#tb3').append('<td><button id="return' + i + '" type="button" value="' + data[i].cno + '">退课</button></td>');
                        $('#tb3').append('</tr>');
                        dontAnything(i);
                        dontSomething(i);
                        dontOtherthing(i);
                    }
                    doSomething(n);
                }
            })
        }
    }

    function doSomething(n) {
        let a = $('#sno').text();
        $.post({
            url: "/selectSumCreditBySno",
            data:{'sno':a,'judge':n},
            success: function (data) {
                $('#tb3').append('<tr>');
                $('#tb3').append('<td colspan="3"></td>');
                if(n==0){
                    $('#tb3').append('<td>总学分：</td>');
                }else if(n==1){
                    $('#tb3').append('<td>第一学期学分：</td>');
                }else{
                    $('#tb3').append('<td>第二学期学分：</td>');
                }
                $('#tb3').append('<td>' + (0+data) + '</td>');
                $('#tb3').append('</tr>');
            }
        })
    }

    $('#selectCredit').change(function () {
        doOtherthing($('#selectCredit').find('option:selected').val());
    })

    function dontSomething(n) {
        $('#return' + n).click(function () {
            let res = confirm('确定要退课吗？？？');
            if(res){
                let cno = $('#return' + n).val();
                let semester = 1;
                if($('#semester' + n).text() == "二"){
                    semester = 2;
                }
                $.post({
                    url:"/deleteMySelectCourse",
                    data:{"cno":cno,"judge":semester},
                    success:function (data){
                        if(data=1){
                            alert("退课成昆！！！！！");
                            doOtherthing(0);
                        }
                    }
                })
            }
        })
    }

    function dontOtherthing(n) {
        $('#a' + n).click(function () {
            let tno = $('#a' + n).text();
            $.post({
                url:"/selectTnameByTno",
                data:{"tno":tno},
                success:function (data){
                    alert("教师名字为" + data + "！！！");
                }
            })
        })
    }

    function dontOnething(n) {
        $('#b' + n).click(function () {
            let tno = $('#b' + n).text();
            $.post({
                url:"/selectTnameByTno",
                data:{"tno":tno},
                success:function (data){
                    alert("教师名字为" + data + "！！！");
                }
            })
        })
    }
    
    function dontAnything(n) {
        $('#c' + n).click(function () {
            let cno = $('#c' + n).text();
            $.post({
                url:"/selectCnameByCno",
                data:{"cno":cno},
                success:function (data){
                    alert("课程名称为" + data + "！！！");
                }
            })
        })
    }
    
})