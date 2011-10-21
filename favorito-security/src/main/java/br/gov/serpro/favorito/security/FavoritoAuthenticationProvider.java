package br.gov.serpro.favorito.security;

import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Properties;
import java.util.logging.Logger;

import br.gov.component.demoiselle.security.auth.AuthException;
import br.gov.component.demoiselle.security.auth.Certificate;
import br.gov.component.demoiselle.security.auth.User;
import br.gov.component.demoiselle.security.auth.provider.IAuthenticationProvider;
import br.gov.component.demoiselle.security.auth.provider.implementation.SampleAuthenticationProvider;
import br.gov.component.demoiselle.security.message.ProviderMessageContext;

public class FavoritoAuthenticationProvider implements IAuthenticationProvider {

	private static Logger log = Logger.getLogger(SampleAuthenticationProvider.class.getName());

	public Principal authenticate(String user, String password) {
		if ("mensagem".equalsIgnoreCase(user)) {
			log.info("authenticate");
			ProviderMessageContext messageContext = ProviderMessageContext.getInstance();
			messageContext.addMessage("Sample authenticate Message");
			return new User(user);
		} else if ("demoiselle".equalsIgnoreCase(user)) {
			log.info("authenticate");
			log.info("user [" + user + "] password [" + password + "]");
			return new User(user);
		} else {
			log.info("dont authenticate");
			throw new AuthException("User fail");
		}
	}

	public Principal authenticate(String user, String password, String newPassword) {
		log.info("authenticate");
		log.info("user [" + user + "] password [" + password + "] new password [" + newPassword + "]");
		return new User(user);
	}

	public Principal authenticate(X509Certificate x509) {
		log.info("authenticate");
		log.info("certificate " + x509.getSubjectDN().getName());
		return new Certificate(x509);
	}

	public void initialize(Properties props) {
		log.info("initialize");
		log.info("properties " + props);
	}

}
