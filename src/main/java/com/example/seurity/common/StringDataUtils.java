package com.example.seurity.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 10:20 2019/1/27
 * @des:
 */
public class StringDataUtils {

    /**
     * @des: 根据传入的字符串集合输出  以pattern分隔的字符串 可传入前缀 和后缀
     */
    public static String commaSpliceStr(List<String> strs,String prefix,String suffix,String pattern) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(prefix+str+suffix+pattern);

        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
