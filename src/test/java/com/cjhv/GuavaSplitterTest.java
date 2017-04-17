package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GuavaSplitterTest {

	@Test
	public void test() {
		GuavaSplitter gs = new GuavaSplitter();
		List<String> ret = gs.mySplit();
		assertThat(ret.get(2)).isEqualTo("c");
	}

}
