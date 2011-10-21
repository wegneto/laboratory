package br.gov.serpro.favoritos.message;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.Message;


public interface ErrorMessages {

	final Message FAVORITO_INSERT_NOK = new DefaultMessage("{favorito-insert-nok}");
	final Message FAVORITO_UPDATE_NOK = new DefaultMessage("{favorito-update-nok}");
	final Message FAVORITO_DELETE_NOK = new DefaultMessage("{favorito-delete-nok}");

}
