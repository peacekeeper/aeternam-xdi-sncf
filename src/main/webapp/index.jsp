<html>

<head>

<title>ÆTERNAM XDI Demo - ÖBB</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8"> 

<link rel="stylesheet" type="text/css" href="style.css"> 
 
<script type="text/javascript" src="jquery-2.0.3.min.js"></script>

<script type="text/javascript">

function viewticket() {

	$.post("/viewticket", {})
	.done(function(data) {
		$('#result').text(data);
	})
	.fail(function(err) {
		alert("error: " + JSON.stringify(err));
	});
}

function activateticket() {

	$.post("/activateticket", {})
	.done(function() {
		alert("success");
	})
	.fail(function(err) {
		alert("error: " + JSON.stringify(err));
	});
}

function deactivateticket() {

	$.post("/deactivateticket", {})
	.done(function() {
		alert("success");
	})
	.fail(function(err) {
		alert("error: " + JSON.stringify(err));
	});
}

</script>

</head>

<body>

<h1><img src="images/logo-oebb.png" height="60"><img src="images/logo-xdi-business.jpg" height="60"></h1>

<button onclick="viewticket();">VIEW TICKET</button>

<div style="float:right">
<button onclick="activateticket();">ACTIVATE TICKET</button>
<button onclick="deactivateticket();">DEACTIVATE TICKET</button>
</div>
<div style="clear:both;margin:20px;"></div>

<textarea id="result"></textarea>

</body>

</html>
