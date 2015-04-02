package lab.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import lab.entity.Pessoa;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;

@Transactional
public class PessoaDAO {
 
    @Inject
    private EntityManager em;
 
    public static PessoaDAO getInstance() {
        return Beans.getReference(PessoaDAO.class);
    }
 
    public void insert(Pessoa pessoa) {
        em.persist(pessoa);
    }
    
    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }
    
    public Pessoa load(Integer id) {
        return em.find(Pessoa.class, id);
    }
}