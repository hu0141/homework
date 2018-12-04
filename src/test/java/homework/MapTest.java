package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapTest {
	
	private Map<String, String> map ;
	private BiFunction<String, String, String> biFunction;
	
	private String key1 = "key1";
	private String key2 = "key2";
	private String key3 = "key3";
	private String key4 = "key4";
	private String change = "change";
	
	public MapTest() {
		testMerge();
		testCompute();
		testComputeIfAbsent();
		testComputeIfPresent();
	}
	public static void main(String[] args) {
		MapTest mapTest = new MapTest();
	}
	public void init() {
		//初始化map
		map = new HashMap<>();
		map.put(key1, "value1");
		map.put(key2, "value2");
		map.put(key3, "value3");
		System.out.println("********************************************");
		System.out.println("Map's initial value:" + map);
		System.out.println();
		//初始化Bifunction
		biFunction = new BiFunction<String, String, String>() {

			@Override
			public String apply(String t, String u) {
				System.out.println("t值=" + t);
				System.out.println("u值=" + u);
				return t + "_" + u;
			}
		};
	}
	public void testMerge() {
		this.init();
		map.merge(key1, change, biFunction);
		map.merge(key2, change, biFunction);
		map.merge(key4, change, biFunction);
		System.out.println("merge result:" + map);
	}
	public void testCompute() {
		this.init();
		map.compute(key1, biFunction);
		map.compute(key2, biFunction);
		map.compute(key4, biFunction);
		System.out.println("compute result:" + map);
	}
	public void testComputeIfAbsent() {
		this.init();
		map.computeIfAbsent(key1, k -> k + "_" + k);
		map.computeIfAbsent(key2, new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t + "_" + t;
			}
		});
		map.computeIfAbsent(key4, k -> k + "_" + k);
		System.out.println("ComputeIfAbsent result:" + map);
	}
	public void testComputeIfPresent() {
		this.init();
		map.computeIfPresent(key1, biFunction);
		map.computeIfPresent(key2, biFunction);
		map.computeIfPresent(key4, biFunction);
		System.out.println("ComputeIfPresent result:" + map);
	}
	
	
}
