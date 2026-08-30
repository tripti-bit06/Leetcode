class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        String clean = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                clean = clean + s.charAt(i);
            }
        }

        String reverse = "";

        for (int i = clean.length() - 1; i >= 0; i--) {
            reverse = reverse + clean.charAt(i);
        }

        return clean.equals(reverse);
    }
}