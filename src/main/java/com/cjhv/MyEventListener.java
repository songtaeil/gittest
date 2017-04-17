package com.cjhv;

import com.google.common.eventbus.Subscribe;

public class MyEventListener {

	MyEvent me;
	
	@Subscribe
	public void mylisten(MyEvent mEvent){
		me = mEvent;
	};
	
	public MyEvent getLastEvent(){
		return me;
	};
}
