<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="gr__localhost"><head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

<style type="text/css">/* Chart.js */
@keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}.chartjs-render-monitor{animation:chartjs-render-animation 1ms}.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}</style><style type="text/css">/* Chart.js */
@keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}.chartjs-render-monitor{animation:chartjs-render-animation 1ms}.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}</style>
   
<script>
$(document).ready(function(){
  $(".btna").click(function(){
    var a = $(this).parent().parent().parent()
    while (a.next().attr('class')==="hide") {
        a.next().toggle();
        a = a.next();
    }
  });
});
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
    </head>

<body id="page-top" data-gr-c-s-loaded="true">
<%@include file="/WEB-INF/jspf/admin/nav.jspf" %>
  <div id="wrapper">

    <!-- Sidebar -->
    <%@include file="/WEB-INF/jspf/admin/thanhngang.jspf" %>

    <div id="content-wrapper">
        
        <div class="chartjs-wrapper"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
            <iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;">
                
            </iframe>
            <canvas id="chartjs-0" class="chartjs chartjs-render-monitor" width="1124" height="562" style="display: block; width: 1124px; height: 562px;">
                
            </canvas>
            <script>new Chart(document.getElementById("chartjs-0"),{"type":"line","data":{"labels":["${day6}","${day5}","${day4}","${day3}","${day2}","${day1}","Today"],"datasets":[{"label":"Số máy bán ra","data":[${dayago6},${dayago5},${dayago4},${dayago3},${dayago2},${dayago1},${today}],"fill":false,"borderColor":"rgb(75, 192, 192)","lineTension":0.1}]},"options":{}});
            </script>
        </div>
        
        
        
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
    <div>
<div style="
    width: 50%;
    float: right;
"><label>Tổng số đơn hàng: </label><p>${sumOrder}</p>
<label>Số máy bán ra: </label><p>${sumLaptop}</p>
<label style="
">Số đơn hàng hôm nay: </label><p>${sumOrderInDay}</p>
<label>Số máy bán ra hôm nay: </label><p>${sumLaptopInDay}</p></div><div style="
    margin-top: 30px;
    width: 50%;
"><div class="chartjs-wrapper" style="
"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div><iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe><canvas id="chartjs-4" class="chartjs chartjs-render-monitor" width="562" height="281" style="display: block; width: 562px; height: 281px;"></canvas>
<p align="center" style="
    margin-top: 10px;
    color: #666666;
">Top 3 nhãn hiệu bán chạy nhất</p><script>new Chart(document.getElementById("chartjs-4"),{"type":"doughnut","data":{"labels":["${top1Company}","${top2Company}","${top3Company}"],"datasets":[{"label":"My First Dataset","data":[${top1Quantity},${top2Quantity},${top3Quantity}],"backgroundColor":["rgb(255, 99, 132)","rgb(54, 162, 235)","rgb(255, 205, 86)"]}]}});</script></div></div>
    </div></div>
    <!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jspf/admin/footer.jspf" %>
</body></html>