//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

/**
 * 字母异位词指的是字母的个数相同
 */
package com.train.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram242 {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram242().new Solution();
        solution.isAnagram("sddsssss", "sdssssds");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (Objects.isNull(s) && Objects.isNull(t)) {
                return true;
            }
            if (s.length() != t.length()) {
                return false;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Map<Character, Integer> smap = summary(sChars);
            Map<Character, Integer> tmap = summary(tChars);

/*            char start = 'A';
            char end = 'z';
            while (start <= end) {
                if (smap.getOrDefault(Character.valueOf(start), 0) != tmap.getOrDefault(Character.valueOf(start), 0)) {
                    return false;
                }
                start++;
            }*/

            for(Map.Entry<Character,Integer> entry:smap.entrySet()){
                char key = entry.getKey();
                int tValue = tmap.getOrDefault(key,0);
                if(entry.getValue()!=tValue){
                    return false;
                }
            }

            for(Map.Entry<Character,Integer> entry:tmap.entrySet()){
                char key = entry.getKey();
                int tValue = smap.getOrDefault(key,0);
                if(entry.getValue()!=tValue){
                    return false;
                }
            }

            return true;
        }

        public Map<Character, Integer> summary(char[] chars) {
            Map<Character, Integer> cnt = new HashMap<>();
            for (char ch : chars) {
                int value = cnt.getOrDefault(ch, 0);
                cnt.put(ch, value + 1);
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}