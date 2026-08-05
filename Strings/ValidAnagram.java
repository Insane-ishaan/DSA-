package Strings;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }

        char ch[] = new char[27];

        for (int i = 0; i < len; i++) {
            ch[s.charAt(i) - 'a']++;
            ch[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
