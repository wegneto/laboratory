package com.wegneto.newauction5.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.wegneto.newauction5.domain.Auction;
import com.wegneto.newauction5.persistence.AuctionDAO;

@BusinessController
public class AuctionBC extends DelegateCrud<Auction, Long, AuctionDAO> {

	public List<Auction> findNewest() {
		return getDelegate().findNewest();
	}

}
