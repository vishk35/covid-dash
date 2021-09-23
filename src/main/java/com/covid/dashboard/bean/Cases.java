package com.covid.dashboard.bean;

import java.util.ArrayList;
import java.util.List;

public class Cases {

	private List<Case> cases;

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		if(cases==null) {
			this.cases = new ArrayList<>();
		}
		this.cases = cases;
	}
}
