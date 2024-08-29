<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	let dataAry = [
		['user', 'count by user']
	];

	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'chartJson.do');
	xhtp.send();
	xhtp.onload = function () {
		let result = JSON.parse(xhtp.response)

		result.forEach(val => {
			dataAry.push([val.user_name, val.cnt])
		});

		google.charts.load("current", {
			packages: ["corechart"]
		});
		google.charts.setOnLoadCallback(drawChart);
	}

	function drawChart() {
		var data = google.visualization.arrayToDataTable(dataAry);

		var options = {
			title: '사용자별 게시글 작성건수',
			pieHole: 0.4,
		};

		var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
		chart.draw(data, options);
	}
</script>

<div id="donutchart" style="width: 700px; height: 500px;"></div>
