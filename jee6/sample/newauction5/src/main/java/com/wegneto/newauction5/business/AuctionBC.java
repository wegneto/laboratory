package com.wegneto.newauction5.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.wegneto.newauction5.domain.Auction;
import com.wegneto.newauction5.domain.Status;
import com.wegneto.newauction5.persistence.AuctionDAO;

@BusinessController
public class AuctionBC extends DelegateCrud<Auction, Long, AuctionDAO> {

	public List<Auction> findNewest() {
		return getDelegate().findNewest();
	}

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {

			InputStreamReader input = new InputStreamReader(this.getClass().getResourceAsStream("sample-items.csv"));
			BufferedReader reader = new BufferedReader(input);

			String line = null;

			try {
				while ((line = reader.readLine()) != null) {
					String[] values = line.split(";");
					String description = values[1];

					insert(new Auction(description, getRandomPrice(1000), "History", "x days", Status.OPEN, Calendar
							.getInstance().getTime()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					input.close();
				} catch (IOException e) {
				}

				try {
					reader.close();
				} catch (IOException e) {
				}
			}

		}
	}

	private double getRandomPrice(double ceil) {
		int value = (int) (Math.random() * 100 * ceil);
		return value / 10.0;
	}

}
