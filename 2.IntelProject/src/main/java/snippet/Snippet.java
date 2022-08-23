package snippet;

public class Snippet {
	<!DOCTYPE html>
	<html>
	<head>
	<title>Intel</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script  src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
	    .jumbotron {
	      background-color: #3a2b58; 
	      color: #e5e4f4;
	    }
	    </style>
	</head>
	<body>
	    <div class="container  mt-3 text-center">
	           </div>
	    <div class="container mt-2 ">
	       <form class="form-control jumbotron" action="#"
	        th:action="@{/reports/save}"
	        th:object="${report}"
	         method="post">
	         <h2>Report data input</h2>
	            <div class="mb-3 mt-3 w-auto">
	                <label class="form-check-label w-25" for="level">Action level</label>
	                <input  type="number" th:field="*{level}" id="level"
	                    placeholder="Level">
	            </div>
	            <div class="mb-3 mt-3 w-auto">
	                <label class="form-check-label w-25" for="description">Description</label>
	                <input  type="text" th:field="*{description}" id="description"
	                    placeholder="Description">
	            </div>
	            <h3>Coordinates:</h3>
	            <div class="mb-3 mt-3 w-auto">
	                <label class="form-check-label w-25" for="lat">Lattitude</label>
	                <input  type="number" step="0.0000001" th:field="*{lat}" id="lat"
	                    placeholder="Lattitude">
	            </div>
	            <div class="mb-3 mt-3 w-auto">
	                <label class="form-check-label w-25" for="lng">Longitude</label>
	                <input  type="number" step="0.0000001" th:field="*{lng}" id="lng"
	                    placeholder="Longitude">
	            </div>
	            <a class="btn btn-primary" href="/reports">List of reports</a>
	            <a>                           </a>
	                <button type="submit" class="btn btn-primary" >Add</button>
	             
	            
	                <p></p>
	        
	                <div id="googleMap"  style="width:100%;height:400px;"></div>  
	        </form>
	        
	
	    </div>
	      
	   
		<script>
			function myMap() {
				var mapProp= {
	 			 center:new google.maps.LatLng(54.7028992,25.4148608),
	 			 zoom:10,
				};
			const mark = { lat: 54.7028, lng: 25.4148 };
			const labels = "Taikinys";
			let labelIndex = 5;
			var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
			var marker = new google.maps.Marker({position: mark, map: map, title: "Test1",});
			var marker2 = new google.maps.Marker({position: {lat: 54.6028, lng: 25.3148}, map: map,label: labels, title: "Test2",});
			}
		</script>
	    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDABAwC6MT_fLJhaTFmVIluNKPp5bc-vms&callback=myMap"></script>
	   
	</body>
	</html>
}

