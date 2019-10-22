<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.min.css" rel="stylesheet">
</head>
<body>
<!-- Sidebar -->

<div class="sidebar-fixed position-fixed">
    <a class="logo-wrapper waves-effect">
        <img alt="MDB React Logo" class="img-fluid" src="/previews/free-templates/react-admin-dashboard/static/media/mdb-react.d3e3273c.png"></a>
            <ul class="list-group list-group-flush">
                <a class="activeClass" aria-current="page" href="/previews/free-templates/react-admin-dashboard/">
                    <li class="list-group-item">

                    <li class="list-group-item"><i class="fa fa-user mr-3"></i>训练数据</li></a><a href="repacked_train.jsp">
                    <li class="list-group-item"><i class="fa fa-table mr-3"></i>重打包检测</li></a><a href="repacked_detection.jsp">
                    <li class="list-group-item"><i class="fa fa-map mr-3"></i>其他</li></a><a href="">
                    <li class="list-group-item"><i class="fa fa-exclamation mr-3"></i>信息统计</li></a></ul>
</div>
<!-- Sidebar -->
<script>
    var $object=document.getElementById('one');
    var $object2=document.getElementById('dio');
    $object.onclick=function(){
        if($object2.style.display=="none"){
            $object2.style.display="";

        } else{
            $object2.style.display="none";
        }
    }
</script>
</body>
</html>
