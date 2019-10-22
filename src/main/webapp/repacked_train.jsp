<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./header.jsp"></jsp:include>




<jsp:include page="./sidebar.jsp"></jsp:include>


<main class="pt-5 mx-lg-5">
    <div class="container-fluid mt-5">

        <!-- Heading -->
        <div class="card mb-4 wow fadeIn">

            <!--Card content-->
            <div class="card-body d-sm-flex justify-content-between">

                <h4 class="mb-2 mb-sm-0 pt-1">
                    <a href="#" target="_blank">返回主页</a>
                    <span>/</span>
                    <span>训练数据集</span>
                </h4>

                <form class="d-flex justify-content-center">
                    <!-- Default input -->
                    <input type="search" placeholder="输入您想查找的内容" aria-label="Search" class="form-control">
                    <button class="btn btn-primary btn-sm my-0 p" type="submit">
                        <i class="fas fa-search"></i>
                    </button>

                </form>

            </div>

        </div>
        <!-- Heading -->

        <!--Grid row-->
        <div class="row wow fadeIn">

            <!--Grid column-->
            <div class="col-md-12 mb-4">

                <!--Card-->
                <div class="card">

                    <div class="card-header">选择良性apk路径</div>
                    <!--Card content-->
                    <div class="card-body">



                        <input id='good' class="form-control mb-4"type="text" placeholder="良性apk路径">


                    </div>

                </div>
                <!--/.Card-->

            </div>
            <!--Grid column-->



        </div>
        <!--Grid row-->

        <!--Grid row-->
        <div class="row wow fadeIn">

            <!--Grid column-->
            <div class="col-md-12 mb-4">

                <!--Card-->
                <div class="card">

                    <div class="card-header">选择恶意apk路径</div>
                    <!--Card content-->
                    <div class="card-body">



                        <input id='bad' type="text" class="form-control mb-4" placeholder="恶意apk路径">



                    </div>

                </div>
                <!--/.Card-->

            </div>
            <!--Grid column-->



        </div>
        <!--Grid row-->

        <!--Grid row-->

        <button id="train" class="btn btn-info btn-block my-4" type="submit">训练数据集</button>

    </div>
</main>
<!--Main layout-->

<!--Footer-->
<footer class="page-footer text-center font-small primary-color-dark darken-2 mt-4 wow fadeIn">

    <!--Call to action-->
    <div class="pt-4">
        <a class="btn btn-outline-white" href="repacked_detection.jsp" target="_blank"
           role="button">下载重构结果
            <i class="fas fa-download ml-2"></i>
        </a>
        <a class="btn btn-outline-white" href="repacked_detection.jsp" target="_blank" role="button">
            自动重构规范
            <i class="fas fa-graduation-cap ml-2"></i>
        </a>
    </div>
    <!--/.Call to action-->

    <hr class="my-4">

    <!-- Social icons -->
    <div class="pb-4">
        <a href="https://www.facebook.com/mdbootstrap" target="_blank">
            <i class="fab fa-facebook-f mr-3"></i>
        </a>

        <a href="https://twitter.com/MDBootstrap" target="_blank">
            <i class="fab fa-twitter mr-3"></i>
        </a>

        <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
            <i class="fab fa-youtube mr-3"></i>
        </a>

        <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
            <i class="fab fa-google-plus mr-3"></i>
        </a>

        <a href="https://dribbble.com/mdbootstrap" target="_blank">
            <i class="fab fa-dribbble mr-3"></i>
        </a>

        <a href="https://pinterest.com/mdbootstrap" target="_blank">
            <i class="fab fa-pinterest mr-3"></i>
        </a>

        <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
            <i class="fab fa-github mr-3"></i>
        </a>

        <a href="http://codepen.io/mdbootstrap/" target="_blank">
            <i class="fab fa-codepen mr-3"></i>
        </a>
    </div>
    <!-- Social icons -->

    <!--Copyright-->
    <div class="footer-copyright py-3">
        © 2019 Copyright:
        <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> 南京理工大学 </a>
    </div>
    <!--/.Copyright-->

</footer>
<!--/.Footer-->

<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Initializations -->
<script type="text/javascript">
    // Animations initialization
    new WOW().init();

</script>

<!-- Charts -->
<script>

    console.log("1");
    $(document).ready(function() {
        $('#train').click(function () {
            console.log("2");
            $.ajax({
                type: "POST",
                url: "apk/train",
                data: {
                    'goodUrl': $.trim($('#good').val()),
                    'badUrl': $.trim($('#bad').val())
                },
                dataType: "text",
                timeout: '1000',
                success: function (result) {

                    if ($.trim(result) === "success") {
                        console.log("yes");
                        window.location.href = 'repacked_train.jsp';
                    } else {
                        console.log("no");
                        window.location.href = 'repacked_train.jsp';
                    }
                }
            })
        })
    })

</script>





</body>
</html>