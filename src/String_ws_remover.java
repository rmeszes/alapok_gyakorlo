public class String_ws_remover {
    public String remove_ws(String s) {
        System.out.println("A kapott string hossza: " + s.length());
        char[] tomb = s.toCharArray();
        int len = tomb.length;
        for (int i = 0; i < len; i++) {
            if(tomb[i] == ' ') {
                for(int j = i; j < len - 1; j++) {
                    tomb[j] = tomb[j+1];
                }
                tomb[len-1] = ' ';
                len--;
            }
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < len; i++) {
            ret.append(tomb[i]);
        }
        System.out.println("A kész string hossza: " + ret.length());
        return ret.toString();
    }

    public String regex_remove(String s) {
        s = s.replaceAll("\\s","");
        return s;
    }
}
