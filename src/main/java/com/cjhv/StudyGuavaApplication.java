package com.cjhv;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

@SpringBootApplication
public class StudyGuavaApplication {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(StudyGuavaApplication.class);
	
	public static void Function1(){
		Function<Country, String> upperCaseFunction = new Function<Country, String>(){
			public String apply(@Nullable Country country){
				if(country == null){
					return "";
				}
				return country.getName().toUpperCase() + ": " + country.getCapitalCity().toUpperCase();
			}
		};
		
		Function<String, String> reverseFunction = new Function<String, String>(){
			public String apply(String str){
				if(str == null){
					return null;
				}
				return new StringBuilder(str).reverse().toString();
			}
		};
		
		Function<Country, String> composedFunction = Functions.compose(reverseFunction,  upperCaseFunction); //first upper case and second reverse
		
		Collection<String> reversedCapitalCities = Collections2.transform(Country.getSomeCountries(), composedFunction);

		assertThat(reversedCapitalCities).contains("WASRAW :DNALOP", "DNALOP");
	};
	
	public static void Function2(){
		Map<String, String> map = Maps.newHashMap();
		map.put(Country.POLAND.getName(), Country.POLAND.getCapitalCity());
		map.put(Country.BELGIUM.getName(), Country.BELGIUM.getCapitalCity());
		map.put(Country.SPAIN.getName(), Country.SPAIN.getCapitalCity());
		map.put(Country.ENGLAND.getName(), Country.ENGLAND.getCapitalCity());
		
		Function<String, String> capitalCityFromCountryName = Functions.forMap(map); //default value forMap(target, "default value")
		
		List<String> countries = Lists.newArrayList();
		countries.add(Country.POLAND.getName());
		countries.add(Country.BELGIUM.getName());
		
		Collection<String> capitalCities = Collections2.transform(countries,  capitalCityFromCountryName); // (key, return will be value on map)
		
		assertThat(capitalCities).containsOnly(Country.POLAND.getCapitalCity());
	};
	
	public static void Function3(){
		Predicate<Country> contry_predic = new Predicate<Country>(){

			@Override
			public boolean apply(Country input) {
				// TODO Auto-generated method stub
				return !Strings.isNullOrEmpty(input.getCapitalCity());
			}
		};
		
		boolean allContryCheck = Iterables.all(Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.FINLAND_WITHOUT_CAPITAL_CITY), contry_predic);
		
		assertThat(allContryCheck);
	};
	
	public static void Function4() throws Exception{
		assertThat(Predicates.containsPattern("\\d\\d").apply("hello world")).isTrue();
		
	};

	public static void Function5() throws Exception{
		
		String ret = "";
		//assertThat(CharMatcher.noneOf("xZ").matchesAnyOf("anythingx")).isTrue();
		//assertThat(CharMatcher.DIGIT.or(CharMatcher.WHITESPACE).retainFrom("12345 6x")).isEqualTo("12345 6x");
		//assertThat(CharMatcher.DIGIT.countIn("x1f62g3h")).isEqualTo(3);
		//ret = CharMatcher.inRange('3', '6').removeFrom("123456789");
		ret = CharMatcher.is('$').trimFrom("$$$ this is $ a sign$$$");
		System.out.println("****************************\n[" + ret + "]\n****************************");
	};
	
	
	public static void Function6(){
		String ret = "";
		
		List<String> liststr = Arrays.asList("java", "c", null, "physon");
//		ret = Joiner.on("#").join( liststr);
//		System.out.println("****************************\n[" + ret + "]\n****************************");

		ret = Joiner.on("#").skipNulls().join( liststr);
		System.out.println("****************************\n[" + ret + "]\n****************************");
	
	};
	
	public static void Function7(){
		String ret = "";
		
		Map<String, String> map = Maps.newHashMap();
		map.put(Country.POLAND.getName(), Country.POLAND.getCapitalCity());
		map.put(Country.BELGIUM.getName(), Country.BELGIUM.getCapitalCity());
		map.put(Country.SPAIN.getName(), Country.SPAIN.getCapitalCity());
		map.put(Country.ENGLAND.getName(), Country.ENGLAND.getCapitalCity());
		

		ret = Joiner.on(" / ").withKeyValueSeparator("'s capital is ").join(map);
		System.out.println("****************************\n[" + ret + "]\n****************************");
	
	};
	
	public static void Function8(){
		Iterable<String> iter = Splitter.on(";").split("a;b;c;d;e");
		List<String> lString = Lists.newArrayList(iter.iterator());
		
		assertThat(lString.size()).isEqualTo(4);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudyGuavaApplication.class, args);
		System.out.println("===================== start =================");
		
		try{
			Function8();
		}catch(Exception e){
			System.out.println("=====================  =================");
		}
	}	
}
