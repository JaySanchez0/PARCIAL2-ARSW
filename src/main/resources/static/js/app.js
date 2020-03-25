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
		$("#countryname").html("<h1>Nombre:"+country.name+"</h1>");
		var tab = $("<table class='table'></table>");
		tab.append($("<tr><td>province name</td><td>confirmed</td><td>deaths</td><td>recovereds</td></tr>"));
		country.provinces.forEach(function(province){
			var row = $("<tr><td>"+province.name+"</td><td>"+province.confirmed+"</td><td>"+country.deads+"</td><td>"+province.recovereds+"</td></tr>");
			tab.append(row);
		});
		$("#provinces").append(tab);
	};
	return{
		getCountries:function(){
			apiclient.getCountries(tab)
		}
	}
})();