package com.kwan.home.monster;

import com.kwan.home.Action;

public class MonsterController {

	public Action start(Action action) {
		System.out.println("go");

		action.setFlag(true);
		action.setPath("/WEB-INF/views/monster/list.jsp");

		return action;
	}

}
