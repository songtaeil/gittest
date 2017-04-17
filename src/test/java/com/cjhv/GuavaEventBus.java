package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class GuavaEventBus {

	@Test
	public void test() {
		EventBus eb = new EventBus("firstEvent");
		MyEventListener ml = new MyEventListener(); 
		eb.register(ml);
		eb.post(new MyEvent(99));
		
		assertThat(ml.getLastEvent().getId()).isEqualTo(98);
	}

}
