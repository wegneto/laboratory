$(function() {

	var id = obterParametroDaUrlPorNome('id');
	$("#id").val(id)

	if (id) {
		PessoaProxy.obter(id).done(obterOk).fail(obterFalhou);
	}
	
	$("#nome, #email, #telefone").on('change', function(){
        $(this).parent().removeClass("has-error has-success");
        $(".text-danger").parent().removeClass("has-error");
        $(".text-danger").hide();
        var campo = this;
        if(id){
            switch(campo.id){
                case "nome":
                    var pessoaPatch = { nome : campo.value };
                    break;
                case "email":
                    var pessoaPatch = { email : campo.value };
                    break;
                case "telefone":
                    var pessoaPatch = { telefone : campo.value };
                    break;
            }
            PessoaProxy.atualizarParcial(id, pessoaPatch).done(function(){ atualizarParcialOk(campo.id) }).fail(atualizarFalhou);
        }
    });
 
    $("#nome, #email, #telefone").on('blur', function(){
        if($(this).parent().hasClass("has-error")){
            $(this).focus();
        }
    });

	$("form").submit(function(event) {
		/* Limpa as mensagens de erro */
		$("#global-message").removeClass("alert-danger alert-success").empty().hide();
		$(".control-label").parent().removeClass("has-success");
		$(".text-danger").parent().removeClass("has-error");
		$(".text-danger").hide();

		event.preventDefault();

		var pessoa = {
			nome : $("#nome").val(),
			email : $("#email").val(),
			telefone : $("#telefone").val()
		};

		if (id) {
			PessoaProxy.atualizar(id, pessoa).done(atualizarOk).fail(atualizarFalhou);
		} else {
			PessoaProxy.inserir(pessoa).done(inserirOk).fail(inserirFalhou);
		}

	});

});

function atualizarParcialOk(id){
    $("#" + id ).parent().addClass("has-success", {duration : 3000});
}

function obterParametroDaUrlPorNome(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function obterOk(data) {
	$("#nome").val(data.nome);
	$("#email").val(data.email);
	$("#telefone").val(data.telefone);
}

function obterFalhou(request) {
	switch (request.status) {
		case 404:
			alert("Você está tentando acessar um registro inexistente!");
			break;

		default:
			break;
	}
}

function inserirOk(data, textStatus, jqXHR) {
	$("#global-message").addClass("alert-success").text("Pessoa com id = " + data + " criado com sucesso.").show();
}

function atualizarOk(data, textStatus, jqXHR) {
	$("#global-message").addClass("alert-success").text("Pessoa atualizada com sucesso.").show();
}

function atualizarFalhou(request) {
	switch (request.status) {
		case 422:
			$($("form input").get().reverse()).each(function() {
				var id = $(this).attr('id');
				var message = null;

				$.each(request.responseJSON, function(index, value) {
					if (id == value.property) {
						message = value.message;
						return;
					}
				});

				if (message) {
					console.log($("#" + id).parent());
					$("#" + id).parent().addClass("has-error");
					$("#" + id + "-message").html(message).show();
					$(this).focus();
				} else {
					$("#" + id).parent().removeClass("has-error");
					$("#" + id + "-message").hide();
				}
			});
			break;

		default:
			$("#global-message").addClass("alert-danger").text("Erro ao atualizar pessoa.").show();
			break;
	}
}

function inserirFalhou(request) {
	switch (request.status) {
		case 422:
			$($("form input").get().reverse()).each(function() {
				var id = $(this).attr('id');
				var message = null;

				$.each(request.responseJSON, function(index, value) {
					if (id == value.property) {
						message = value.message;
						return;
					}
				});

				if (message) {
					console.log($("#" + id).parent());
					$("#" + id).parent().addClass("has-error");
					$("#" + id + "-message").html(message).show();
					$(this).focus();
				} else {
					$("#" + id).parent().removeClass("has-error");
					$("#" + id + "-message").hide();
				}
			});
			break;

		default:
			$("#global-message").addClass("alert-danger").text("Erro ao cadastrar pessoa.").show();
			break;
	}
}
