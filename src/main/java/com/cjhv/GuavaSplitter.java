package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;

import com.google.common.base.Splitter;

public class GuavaSplitter {

	public List<String> mySplit(){
		Iterable<String> iter = Splitter.on(";").split("a;b;c;d;e");
		List<String> lString = Lists.newArrayList(iter.iterator());
		return lString;
	}
}
