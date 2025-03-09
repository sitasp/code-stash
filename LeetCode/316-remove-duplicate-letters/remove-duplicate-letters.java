class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] instack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int[] counter = new int[26];
        for(char c: s.toCharArray()){
            counter[c-'a']++;
        }
        for(int i=0;i<n;i++){
            int x = s.charAt(i)-'a';
            counter[x]--;
            if(instack[x])
                continue;
            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && counter[stack.peek() - 'a'] > 0){
                char c = stack.pop();
                instack[c-'a'] = false;
            }
            stack.add(s.charAt(i));
            instack[s.charAt(i)-'a'] = true;
        }

        StringBuilder ansb = new StringBuilder();
        while(!stack.isEmpty()){
            ansb.append(stack.pop());
        }

        return ansb.reverse().toString();
    }
}