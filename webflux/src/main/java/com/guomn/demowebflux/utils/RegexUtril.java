package com.guomn.demowebflux.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.regex.Pattern;
/**
 * Created by GuoMengnan on 2018/8/30.
 * 正则表达式校验类
 */
@Configuration
public class RegexUtril {

	@Value("regexUtil.patternList")
	public static List<String> patternList;


//	public static void reload(){
//		list.clear();
//		String REGEX1 = "^[\\w]{4,}@t.email$";
//		list.add(REGEX1);
//	}

	/**
	 * 校验输入的temail地址及是否允许注册
	 * @param input temail地址
	 * @return false：不允许注册 true：允许注册
	 */
	public static boolean isMatch(String input) {
		return patternList.stream().anyMatch((regex) -> Pattern.matches(regex, input));
	}
}
