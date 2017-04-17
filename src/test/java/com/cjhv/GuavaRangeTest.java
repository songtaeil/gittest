package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.assertj.core.util.Lists;
import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.Ranges;

public class GuavaRangeTest {

	@Test
	public void test() {
		ArrayList<Integer> numbers = Lists.newArrayList(4,3,10,30,20, 2);
		
		Range<Integer> range = Ranges.encloseAll(numbers);
		
		assertThat(range.lowerEndpoint()).isEqualTo(2);
	}

}
