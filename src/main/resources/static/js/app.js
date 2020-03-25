var app = (function(){
	var tab = function(err,data){
		if(err!=null){
			alert("error");
			return;
		}
		var tab = $("<table class='table'></table>");
		tab.append($("<tr><td>name</td><td>confirmed</td><td>deaths</td><td>recovereds</td><td>View</td></tr>"));
		data.countries.forEach(function(country){
			var row = $("<tr><td>"+country.name+"</td><td>"+country.confirmed+"</td><td>"+country.deads+"</td><td>"+country.recovereds+"</td><td><button name='"+country.name+"' id='but' class='btn btn-primary'>Ver</button></td></tr>");
			tab.append(row);
			row.click(function(){
				showCountry(country);
			});
		});
		$("#tabla").append(tab);
		
	};
	var showCountry = function(country){
		console.log(country);
		loadMap(country.name);
		//console.log(country);
		$("#countryname").html("<h1>Country name: "+country.name+"</h1>");
		$("#countryname").css("boder","1px");
		$("#countryname").css("boder-color","gray");
		var tab = $("<table class='table'></table>");
		tab.append($("<tr><td>province name</td><td>confirmed</td><td>deaths</td><td>recovereds</td></tr>"));
		country.provinces.forEach(function(province){
			var row = $("<tr><td>"+province.name+"</td><td>"+province.confirmed+"</td><td>"+province.deads+"</td><td>"+province.recovereds+"</td></tr>");
			tab.append(row);
		});
		$("#provinces").html("");
		$("#provinces").append(tab);
		tab  = $("<table class='table'></table>");
		var row = $("<tr><td>Name</td><td>Birth Date</td></tr>");
		tab.append(row);
		row = $("<tr><td>Num Deaths</td><td>"+country.deads+"</td></tr>");
		tab.append(row);
		row = $("<tr><td>Num Infected</td><td>"+country.confirmed+"</td></tr>");
		tab.append(row);
		row = $("<tr><td>Num Cured</td><td>"+country.recovereds+"</td></tr>");
		tab.append(row);
		$("#data").html("");
		$("#data").append(tab);
	};
	var drawMap = function(lat,lng,map){
		var marker = new google.maps.Marker({
			  position:new google.maps.LatLng(lat,lng)
			}); 
		marker.setMap(map);
	};
	var loadMap=function(nombre){
		console.log(nombre);
		var settings = {
				"async": true,
				"crossDomain": true,
				"url": "https://restcountries-v1.p.rapidapi.com/name/"+nombre,
				"method": "GET",
				"headers": {
					"x-rapidapi-host": "restcountries-v1.p.rapidapi.com",
					"x-rapidapi-key": "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513"
				}
			};
			$.ajax(settings).done(function (response) {
				//console.log(response);
				response.forEach(function(country){
					if(country.name==nombre || country.alpha2Code==nombre || country.alpha3Code==nombre){
						var lat = country.latlng[0];
						var lng = country.latlng[1];
						var mapProp= {
								  center:new google.maps.LatLng(lat,lng),
								  zoom:5,
								};
						var map = new google.maps.Map(document.getElementById("map"),mapProp);
						drawMap(lat,lng,map)
					}
				});
			});
	};
	return{
		getCountries:function(){
			apiclient.getCountries(tab)
		}
	}
})();