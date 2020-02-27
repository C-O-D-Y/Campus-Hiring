<html>
<head>
<script>
	function hidediv() {
		var mydiv = document.getElementById("mydiv");
		if (mydiv == null) {
			alert("Sorry can't find your div");
			return;
		}
		//div found
		mydiv.style.visibility = "hidden";
	}

	function showdiv() {
		var mydiv = document.getElementById("mydiv");
		if (mydiv == null) {
			alert("Sorry can't find your div");
			return;
		}
		//div found
		mydiv.style.visibility = "visible";
	}
</script>
</head>

<body>

	<div style="align: center; width: 50%; margin-left: 25%">
		<div id="div1" style="background: red; color: white">
			<p>Top
		</div>
		<div id="mydiv" style="visibility: hidden">
			<p>Transient Middle
		</div>
		<div id="mydiv" style="background: blue; color: white">
			<p>Bottom
		</div>
	</div>

	<h3>Show/hide Using the Visibility tag</h3>
	<form>
		<input type="button" value="hide" onclick="hidediv()" /> <input
			type="button" value="show" onclick="showdiv()" />
	</form>

</body>
</html>
