<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Date"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Welcome</title>
	<script>
		setInterval("go_time()", 1000);
		function go_time(){

			var now = new Date();

			var year = now.getFullYear(); 	// 년
			var month = now.getMonth()+1; 	// 월
			var day = now.getDate();  		// 일
			var hour = now.getHours();  	// 시
			var min = now.getMinutes();  	// 분
			var sec = now.getSeconds();  	// 초

			if(month < 10)
				month = "0" + month;
			if(day < 10)
				day = "0" + day;
			if (hour<10)
				hour = "0" + hour;
			if (min < 10)
				min = "0" + min;
			if (sec < 10)
				sec = "0" + sec;

			document.getElementById("time").innerHTML
					= year+"-"+ month+"-"+day+" "+hour+":"+min+":"+sec
		}
	</script>

</head>
<body>
	<%@ include file="menu.jsp"%>
	<%!String greeting = "웹 쇼핑몰에 오신 것을 환영합니다";
	String tagline = "Welcome to Web Market!";%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				<%=greeting%>
			</h1>
		</div>
	</div>	
	<div class="container">
		<div class="text-center">
			<h3>
				<%=tagline%>
			</h3>
			현재 접속 시각 : <span id="time"></span>
		</div>
		<hr>
	</div>	
	<%@ include file="footer.jsp"%>
</body>
</html>