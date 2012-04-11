package com.wegneto.newauction5.persistence;

import java.util.List;

import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.wegneto.newauction5.domain.Auction;
import com.wegneto.newauction5.domain.Status;

@PersistenceController
public class AuctionDAO extends JPACrud<Auction, Long>{

	public List<Auction> findNewest() {
		String jpql = "select this from Auction this where status = :status order by creation desc";
		Query query = getEntityManager().createQuery(jpql);
		
		query.setParameter("status", Status.OPEN);
		
		List<Auction> result = query.getResultList();
		return result;
	}

}
