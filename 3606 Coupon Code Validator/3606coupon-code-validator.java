import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

      
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&
                priority.containsKey(businessLine[i]) &&
                isValid(code[i])) {

                valid.add(new String[]{
                        String.valueOf(priority.get(businessLine[i])),
                        code[i]
                });
            }
        }

        Collections.sort(valid, (a, b) -> {
            if (!a[0].equals(b[0]))
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_')
                return false;
        }
        return true;
    }
}
