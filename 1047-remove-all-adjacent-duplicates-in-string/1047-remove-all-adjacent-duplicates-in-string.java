class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int len = sb.length();
            // If the last character in sb is the same as the current character, remove it
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                // Otherwise, append the current character
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}