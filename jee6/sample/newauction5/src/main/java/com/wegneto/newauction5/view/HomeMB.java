package com.wegneto.newauction5.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.wegneto.newauction5.business.AuctionBC;
import com.wegneto.newauction5.domain.Auction;

import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
public class HomeMB {
	
	@Inject
	private AuctionBC auctionBC;
	
	public List<Auction> getListNewest() {
		return auctionBC.findNewest();
	}

}
