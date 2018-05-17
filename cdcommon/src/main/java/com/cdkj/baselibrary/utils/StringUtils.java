package com.cdkj.baselibrary.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.cdkj.baselibrary.appmanager.MyCdConfig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cdkj on 2017/6/9.
 */

public class StringUtils {


    /**
     * 把一个对象序列化为json字符串 序列化操作应该进行线程处理
     *
     * @param object
     * @return
     */
    public static String getJsonToString(Object object) {

        if (object == null) {
            return "";
        }

        String jsonString = JSON.toJSONString(object);

//        LogUtil.BIGLOG("JSON 转换__:        " + jsonString);

        return jsonString;
    }


    public static boolean contains(String s, String b) {
        if (s == null || b == null) return false;
        return s.contains(b);
    }


    public static int parseInt(String s) {

        if (TextUtils.isEmpty(s)) {
            return 0;
        }

        return Integer.valueOf(s);

    }


    public static List<String> splitAsList(String s, String sp) {

        List<String> strings = new ArrayList<>();

        if (!TextUtils.isEmpty(s)) {
            strings = Arrays.asList(s.split(sp));
        }

        if (strings == null) {
            return new ArrayList<>();
        }

        return strings;
    }


    /**
     * 切割获取图片
     *
     * @param s
     * @return
     */
    public static List<String> splitAsPicList(String s) {
        return splitAsList(s, "\\|\\|");
    }

    /**
     * 切割获取图片
     *
     * @param s
     * @return
     */
    public static String getAsPicListIndexOne(String s) {
        List<String> strings = splitAsList(s, "\\|\\|");
        if (strings == null || strings.isEmpty()) {
            return s;
        }
        return strings.get(0);
    }

    public static String subString(String s, int start, int end) {

        try {
            if (s == null || s.length() <= 0 || end < start || end < 0 || start < 0) {

                return "";
            }
            return s.substring(start, end);
        } catch (Exception ex) {
            return "";
        }
    }

    public static String subStringEnd(String s, int start) {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return subString(s, start, s.length());
    }


    //int前面补零
    public static String frontCompWithZoreString(Object sourceDate, int formatLength) {
        try {
            String newString = String.format("%0" + formatLength + "d", sourceDate);
            return newString;
        } catch (Exception e) {
            return sourceDate.toString();
        }
    }
    /**
     * double 有小数时保留两位小数
     *
     * @return
     */
    public static String formatInteger(Double discount) {
        if (discount == null) return "00";
        NumberFormat nf = new DecimalFormat("#.##");
        return nf.format(discount);
    }

    /**
     * list装换为字符串
     *
     * @param list
     * @return
     */
    public static String listToString(List<?> list, String sep1) {

        if (list == null || list.size() == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null || list.get(i).equals("")) {
                    continue;
                }
                // 如果值是list类型则调用自己
                if (list.get(i) instanceof List) {
                    sb.append(listToString((List<?>) list.get(i), sep1));
                    if (i != list.size() - 1) {
                        sb.append(sep1);
                    }

                } /*else if (list.get(i) instanceof Map) {
                    sb.append(MapToString((Map<?, ?>) list.get(i)));
                    if (i != list.size() - 1) {
                        sb.append(sep1);
                    }

                }*/ else {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append(sep1);
                    }

                }
            }
        }
        return sb.toString();
    }


    //判断email格式是否正确
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 验证电话号码
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isTel(final CharSequence input) {
        return isMatch("^0\\d{2,3}[- ]?\\d{7,8}", input);
    }

    /**
     * 验证手机号（简单）
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMobileSimple(final CharSequence input) {
        return isMatch("^[1]\\d{10}$", input);
    }

    /**
     * 验证手机号（精确）
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMobileExact(final CharSequence input) {
        return isMatch("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,1,3,5-8])|(18[0-9])|(147))\\d{8}$", input);
    }


    //设置价格输入
    public static void editSetPriceInputState(EditText editText) {

        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(".") && dest.toString().length() == 0) {
                    return "0.";
                }
                if (dest.toString().contains(".")) {
                    int index = dest.toString().indexOf(".");
                    int mlength = dest.toString().substring(index).length();
                    if (mlength == 3) {
                        return "";
                    }
                }
                return null;
            }
        }});

    }



    /**
     * Map转换String
     *
     * @param map :需要转换的Map
     * @return String转换后的字符串
     */
/*    public static String MapToString(Map<?, ?> map) {
        StringBuffer sb = new StringBuffer();
        // 遍历map
        for (Object obj : map.keySet()) {
            if (obj == null) {
                continue;
            }
            Object key = obj;
            Object value = map.get(key);
            if (value instanceof List<?>) {
                sb.append(key.toString() + SEP1 + ListToString((List<?>) value));
                sb.append(SEP2);
            } else if (value instanceof Map<?, ?>) {
                sb.append(key.toString() + SEP1
                        + MapToString((Map<?, ?>) value));
                sb.append(SEP2);
            } else {
                sb.append(key.toString() + SEP3 + value.toString());
                sb.append(SEP2);
            }
        }
        return  sb.toString();
    }*/


    /**
     * 判断是否匹配正则
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMatch(final String regex, final CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    public static final String REGEX_IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

    /**
     * 验证IP地址
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isIP(final CharSequence input) {
        return isMatch(REGEX_IP, input);
    }


    public static void setEditMoneyInput(EditText edit) {

        //限制金额数据
        edit.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(".") && dest.toString().length() == 0) {
                    return "0.";
                }
                if (dest.toString().contains(".")) {
                    int index = dest.toString().indexOf(".");
                    int mlength = dest.toString().substring(index).length();
                    if (mlength == 3) {
                        return "";
                    }
                }
                return null;
            }
        }});

    }

    /**
     * 定义script的正则表达式
     */
    private static final String REGEX_SCRIPT = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    /**
     * 定义style的正则表达式
     */
    private static final String REGEX_STYLE = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    /**
     * 定义HTML标签的正则表达式
     */
    private static final String REGEX_HTML = "<[^>]+>";
    /**
     * 定义空格回车换行符
     */
    private static final String REGEX_SPACE = "\\s*|\t|\r|\n";

    /**
     * 去除htnl标签
     *
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {
        // 过滤script标签
        Pattern p_script = Pattern.compile(REGEX_SCRIPT, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        // 过滤style标签
        Pattern p_style = Pattern.compile(REGEX_STYLE, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        // 过滤html标签
        Pattern p_html = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        // 过滤空格回车标签
        Pattern p_space = Pattern.compile(REGEX_SPACE, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll("");
        return htmlStr.trim(); // 返回文本字符串
    }




}
