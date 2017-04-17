package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class GuavaMockTest {

	@Test
	public void test2() throws Exception{
		Ticker ticker = mock(Ticker.class);
		when(ticker.read()).thenReturn(0L, 2000000000L);
		Stopwatch sw = new Stopwatch(ticker);
		sw.start();
		sw.stop();
		assertThat(sw.elapsedTime(TimeUnit.MINUTES)).isEqualTo(12);
	};

	@Test
	public void test() throws Exception{
		@SuppressWarnings("unchecked")
		List<String> testMock = mock(ArrayList.class);
		testMock.add("1");
		testMock.add("2");
		testMock.add("3");

		// add()가 최소한 1번 이상 호출되었는지 검증
		verify(testMock, atLeast(3)).add(anyString());
	};

	@Test
	public void shouldAllowToPutExistingValueWithForcePut() throws Exception {
		BiMap<Integer, String> bimap = HashBiMap.create();

		// when
		bimap.put(1, "one");
		bimap.put(2, "two");
		bimap.put(10, "ten");
		bimap.forcePut(10, "one");

		assertThat(bimap.get(10)).isEqualTo("one");
		assertThat(bimap.get(1)).isNull();

	};

    @Test
    public void shouldRetainOnlySelectedKeys() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("ball");
        multiset.add("ball");
        multiset.add("cow");
        multiset.setCount("twelve", 12);

        // when
        multiset.retainAll(Arrays.asList("ball", "horse"));

        multiset.setCount("ball", 12);
        
        assertThat(multiset.count("ball")).isEqualTo(12);
        assertThat(multiset.count("twelve")).isEqualTo(0);
    }
	
}
