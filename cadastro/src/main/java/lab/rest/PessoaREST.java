package lab.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import lab.entity.Pessoa;
import lab.persistence.PessoaDAO;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("pessoas")
public class PessoaREST {

	@GET
	@Produces("application/json")
	public List<PessoaListBody> buscar(@QueryParam("filtro") String filtro, @QueryParam("ordem") String ordem)
			throws Exception {
		List<PessoaListBody> result = new ArrayList<PessoaListBody>();
		List<Pessoa> pessoas;

		try {
			pessoas = PessoaDAO.getInstance().find(filtro, ordem);
		} catch (IllegalArgumentException cause) {
			throw new BadRequestException();
		}

		for (Pessoa pessoa : pessoas) {
			PessoaListBody body = new PessoaListBody();
			body.id = pessoa.getId();
			body.nome = pessoa.getNome();
			body.email = pessoa.getEmail();
			body.telefone = pessoa.getTelefone();

			result.add(body);
		}

		return result.isEmpty() ? null : result;
	}

	@GET
	@Path("{id}")
	@Transactional
	@Produces("application/json")
	public PessoaBody obter(@PathParam("id") Integer id) throws Exception {
		Pessoa pessoa = PessoaDAO.getInstance().load(id);

		if (pessoa == null) {
			throw new NotFoundException();
		}

		PessoaBody body = new PessoaBody();
		body.nome = pessoa.getNome();
		body.email = pessoa.getEmail();
		body.telefone = pessoa.getTelefone();

		return body;
	}

	@POST
	@Transactional
	@ValidatePayload
	@Consumes("application/json")
	@Produces("text/plain")
	public Response inserir(PessoaBody body) {
		Pessoa entity = new Pessoa();
		entity.setNome(body.nome);
		entity.setEmail(body.email);
		entity.setTelefone(body.telefone);

		PessoaDAO.getInstance().insert(entity);

		Integer id = entity.getId();
		String url = "http://localhost:8080/cadastro/api/pessoas/" + id;
		return Response.status(201).header("Location", url).entity(id).build();
	}

	@PUT
	@Path("{id}")
	@Transactional
	@ValidatePayload
	@Consumes("application/json")
	public void atualizar(@PathParam("id") Integer id, PessoaBody body) throws Exception {
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		Pessoa pessoa = pessoaDAO.load(id);

		if (pessoa == null) {
			throw new NotFoundException();
		}

		pessoa.setNome(body.nome);
		pessoa.setEmail(body.email);
		pessoa.setTelefone(body.telefone);
		pessoaDAO.update(pessoa);
	}

	@PATCH
	@Path("{id}")
	@Transactional
	@ValidatePayload
	@Consumes("application/json")
	public void atualizarParcial(@PathParam("id") Integer id, PessoaPatchBody body) throws Exception {
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		Pessoa pessoa = pessoaDAO.load(id);

		if (pessoa == null) {
			throw new NotFoundException();
		}

		if (body.nome != null) {
			pessoa.setNome(body.nome);
		}

		if (body.email != null) {
			pessoa.setEmail(body.email);
		}

		if (body.telefone != null) {
			pessoa.setTelefone(body.telefone);
		}

		pessoaDAO.update(pessoa);
	}

	public static class PessoaListBody {

		public Integer id;

		public String nome;

		public String email;

		public String telefone;
	}

	public static class PessoaPatchBody {

		@Size(min = 3, max = 50)
		public String nome;

		@Email
		@Size(max = 255)
		public String email;

		@Size(max = 15)
		public String telefone;
	}

	public static class PessoaBody {

		@NotEmpty
		@Size(min = 3, max = 50)
		public String nome;

		@Email
		@NotEmpty
		@Size(max = 255)
		public String email;

		@Size(max = 15)
		public String telefone;
	}
}
