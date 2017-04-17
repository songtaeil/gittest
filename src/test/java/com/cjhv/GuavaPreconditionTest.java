package com.cjhv;

import static org.junit.Assert.*;

import org.assertj.core.util.Preconditions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class GuavaPreconditionTest {

	private String rootPath = "";
	private String ret = "";
	
//	@Before
//	public void before(){
//		rootPath = "//root/services";
//	}
	
	@Test
	public void test() {
		System.out.println("===== start test =========");;
		ret = Preconditions.checkNotNull(rootPath, "null�� �ݾ� �� �ٺ���!");
		System.out.println("===== check not null return =========" + ret);;
		Preconditions.checkArgument(StringUtils.isEmpty(rootPath), "�ƹ� �͵� ���ݾ� �ٺ���!");
	}

}
