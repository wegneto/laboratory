package lab.rest;

import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import lab.entity.Pessoa;
import lab.persistence.PessoaDAO;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("pessoas")
public class PessoaREST {
	
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