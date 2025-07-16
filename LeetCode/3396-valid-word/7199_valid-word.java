class Solution {

    Set<Character> vowels = new HashSet<>();

    public boolean isValid(String word) {
        vowels.addAll(List.of('a', 'e', 'i', 'o', 'u'));
        if(word.length() < 3){
            return false;
        }
        for(char c: word.toCharArray()){
            if(isNumber(c)){
                continue;
            }
            if(isEnglish(c)){
                continue;
            }
            return false;
        }
        boolean oneVowel = false;
        boolean oneConsonant = false;
        for(char c: word.toCharArray()){
            if(isNumber(c))
                continue;
            if(vowels.contains(Character.toLowerCase(c))){
                oneVowel = true;
                //break;
            }
            else {
                oneConsonant = true;
                //break;
            }
        }

        if(!(oneVowel && oneConsonant)){
            return false;
        }

        return true;
    }

    boolean isNumber(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

    boolean isEnglish(char c){
        if(c>='a' && c<='z'){
            return true;
        }
        if(c>='A' && c<='Z'){
            return true;
        }
        return false;
    }
}