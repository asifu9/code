/*
 * This js file contains the Subscription module related page formation code
 */

/*var Fitness = Backbone.Collection.extend({
	url: 'http://localhost:8080/health/rest/fitness/level1/'
});*/
var Fitness = Backbone.Collection.extend({
	initialize: function(models, options) {
		//this.url = '/subscription/' + options.id;
		this.url='http://localhost:8080/health/rest/fitness/level1/'+options.gender;
	}
});

var FitnessLevel1View = Backbone.View.extend({
	el: '#subPage',
	render: function (options) {
		var that = this;
		console.log(" gener is " + options.gender);
		var fitness = new Fitness([],{gender: options.gender});
		var path = '/level1/'+ options.gender;
		console.log("path " + path);
		fitness.urlRoot = path;
		fitness.fetch({
			success: function (fitness) {
				var blankTemplate = getTemplate("/fitness/fit-level1.html");
				console.log(fitness);
				
				var template = _.template(blankTemplate, {fitness : fitness.models});
				console.log(fitness);
				that.$el.html(template);
				/*that.$el.find('#cust-table').dataTable( {
					"aoColumns": [
					  null,null,null,null,null,
					  { "bSortable": false }
					] } );*/
			},

			error: function (model, response, options) {
				console.log(response.responseText);
			}
		});
	}
});

var fitnessLevel1View = new FitnessLevel1View();







