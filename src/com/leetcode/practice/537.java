class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aParts = a.split("+");
        String[] bParts = b.split("+");
        
        int a1 = Integer.parseInt(aParts[0]), a2 = Integer.parseInt(aParts[1].substring(0, aParts[1].length() - 1));
        int b1 = Integer.parseInt(bParts[0]), b2 = Integer.parseInt(bParts[1].substring(0, bParts[1].length() - 1));
        
        return a1 * b1 - a2 * b2 + "+" + (a1 * b2 + a2 * b1) + "i";
            
    }
}
