<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>MIE350 Sample Web App - SearchPage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Date Picker Javascript -->
    <!-- https://jqueryui.com/datepicker/ -->
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <style>
        .goods-search {
            width: 100%;
            text-align: center;
        }

        .goods-table {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .goods-cell {
            width: calc(50% - 5px);
            height: 90px;
            margin-bottom: 10px;
        }

        .bg1 {
            background: url(img/188411.jpg);
        }

        .bg2 {
            background: url(img/book-textbook.png);
        }

        .bg3 {
            background: url(img/images.jpg);
        }

        .bg4 {
            background: url(img/custom-orders.jpg);
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <!-- You can put left sidebar links here if you want to. -->
        </div>
        <div class="col-sm-8 text-left">

            <div style="text-align: center;">
                <form method="POST" action='ListingsSearchController' name="ListingsSearchController">
                    Keyword: <input type="text" name="keyword" id = "ty" value=""/>
                    <input type="submit" class="btn btn-info" value="Search" id = "ty2"/>
                </form>
            </div>

            <div class="goods-table">
                <button class="goods-cell bg1" onclick="myFunction('Stationery');">Stationery</button>
                <button class="goods-cell bg2" onclick="myFunction('Textbooks');">Textbooks</button>
                <button class="goods-cell bg3" onclick="myFunction('Hardware');">Hardware</button>
                <button class="goods-cell bg4" onclick="myFunction('Other');">Other</button>

                <script type="text/javascript">
                    function myFunction(text) {
                        document.getElementById('ty').value = text;
                        document.getElementById("ty2").click();
                    }
                </script>

            </div>
        </div>
        <div class="col-sm-2 sidenav">
            <!-- You can put right sidebar links here if you want to. -->
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>