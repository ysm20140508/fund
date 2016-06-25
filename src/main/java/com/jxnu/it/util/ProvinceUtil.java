package com.jxnu.it.util;

import java.util.Collections;
import java.util.List;

public class ProvinceUtil {
	public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
		if (a.size() != b.size()) return false;
		Collections.sort(a);
		Collections.sort(b);
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).compareTo(b.get(i)) != 0)
				return false;
		}
		return true;
	}
}
