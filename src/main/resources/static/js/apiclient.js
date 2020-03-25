var apiclient = (function(){
	return{
		getCountries:function(callback){
			var prom = $.get({
				url:"/coronavirusapi/country"
			});
			prom.then(function(data){
				callback(null,data);
			},function(err){
				callback(err,null);
			});
		}
	};
})();