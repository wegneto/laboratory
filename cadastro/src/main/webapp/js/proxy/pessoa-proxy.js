var PessoaProxy = {

	url : "api/pessoas",

	inserir : function(_pessoa) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(_pessoa),
			contentType : "application/json"
		});
	},

	atualizar : function(id, pessoa) {
		return $.ajax({
			type : "PUT",
			url : this.url + "/" + id,
			data : JSON.stringify(pessoa),
			contentType : "application/json"
		})
	},

	atualizarParcial : function(id, pessoaPatch) {
		return $.ajax({
			type : "PATCH",
			url : this.url + "/" + id,
			data : JSON.stringify(pessoaPatch),
			contentType : "application/json"
		});
	},

	obter : function(id) {
		return $.ajax({
			type : "GET",
			url : this.url + "/" + id
		});
	},

	buscar : function(filtro, ordem) {
		return $.ajax({
			type : "GET",
			url : this.url,
			data : {"filtro" : filtro, "ordem" : ordem}
		});
	}

};
