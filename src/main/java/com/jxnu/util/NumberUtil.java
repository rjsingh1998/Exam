package com.jxnu.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 忽略无法转换成为Long型的字符串数组
 * @author puchunwei
 *
 */
public class NumberUtil {
	/**
     * 忽略无法转换为Long的字符串
     */
    public static List<Long> strArrayToLongList(String[] strArrays) {
        List<Long> longList = new ArrayList<Long>();
        if (null != strArrays && strArrays.length > 0) {
            for (int i = 0; i < strArrays.length; i++) {
                String s = strArrays[i].trim();
                if (!StringUtils.isNumeric(s)) {
                    System.out.println("忽略无法转换成为Long型的字符串"); //使用日志进行记录
                    continue;
                }
                longList.add(Long.parseLong(s));
            }
        }
        return longList;
    }
}
