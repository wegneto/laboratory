package com.wegneto.newauction5.persistence;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.util.Beans;

import com.wegneto.newauction5.domain.Auction;
import com.wegneto.newauction5.domain.Status;

@RunWith(DemoiselleRunner.class)
public class AuctionDAOTest {
	
	@Inject
	private AuctionDAO dao;
	
	@BeforeClass
	public static void load() {
		AuctionDAO loadDao = Beans.getReference(AuctionDAO.class);
		
		loadDao.insert(new Auction(Status.OPEN, new Date()));
		loadDao.insert(new Auction(Status.OPEN, new Date()));
		loadDao.insert(new Auction(Status.CANCELLED, new Date()));
		loadDao.insert(new Auction(Status.OPEN, new Date()));
	}
	
	@Test
	public void findNewest() {
		Assert.assertEquals(dao.findNewest().size(), 3);
	}
	
	@Test
	public void findMostOfferedAuctions() {
		Assert.assertEquals(dao.findNewest().size(), 3);
	}
	
}
