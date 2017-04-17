package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.ObjectArrays;

public class GuavaObjectArrayTest {

	String[] array1 ={"1", "2", "3"};
	String[] array2 ={"4", "5"};
	
	@Test
	public void test() {
		String[] ret = ObjectArrays.concat(array1, array2, String.class);
		
		assertThat(ret.length).isEqualTo(5);
	}

}
