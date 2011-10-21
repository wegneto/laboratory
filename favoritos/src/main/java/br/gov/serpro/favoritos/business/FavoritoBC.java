package br.gov.serpro.favoritos.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.TransactionException;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.favoritos.config.FavoritoConfig;
import br.gov.serpro.favoritos.entity.Favorito;
import br.gov.serpro.favoritos.message.ErrorMessages;
import br.gov.serpro.favoritos.message.InfoMessages;
import br.gov.serpro.favoritos.persistence.FavoritoDAO;

@BusinessController
public class FavoritoBC extends DelegateCrud<Favorito, Long, FavoritoDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private FavoritoConfig config;

	@Inject
	private MessageContext messageContext;

	@Override
	@Transactional
	public void insert(Favorito favorito) {
		try {
			super.insert(favorito);
			messageContext.add(InfoMessages.FAVORITO_INSERT_OK, favorito.getDescricao());
		} catch (TransactionException te) {
			messageContext.add(ErrorMessages.FAVORITO_INSERT_NOK, te.getMessage(), SeverityType.ERROR);
		}
	}

	@Override
	@Transactional
	public void update(Favorito favorito) {
		try {
			super.update(favorito);
			messageContext.add(InfoMessages.FAVORITO_UPDATE_OK, favorito.getDescricao());
		} catch (TransactionException te) {
			messageContext.add(ErrorMessages.FAVORITO_UPDATE_NOK, te.getMessage(), SeverityType.ERROR);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		try {
			super.delete(id);
			messageContext.add(InfoMessages.FAVORITO_DELETE_OK, id);
		} catch (TransactionException te) {
			messageContext.add(ErrorMessages.FAVORITO_DELETE_NOK, te.getMessage(), SeverityType.ERROR);
		}
	}

	@Startup
	@Transactional
	public void load() {
		// Para ativar essa configuração modifique o valor em favoritos.config -> general.loadInitialData =
		// true
		if (config.isLoadInitialData()) {
			if (findAll().isEmpty()) {
				insert(new Favorito("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
				insert(new Favorito("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Blog", "http://blog.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Forum", "http://forum.frameworkdemoiselle.gov.br"));
				insert(new Favorito("SVN", "http://svn.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Maven", "http://repository.frameworkdemoiselle.gov.br"));
				insert(new Favorito("Downloads", "http://download.frameworkdemoiselle.gov.br"));
			}
		}
	}

}
