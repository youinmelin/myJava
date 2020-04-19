package demo06String;
/*
把数组{1，2，3}按照如下格式拼接成字符串[word1#word2#word3]
*/
public class String08Practice {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        String ret = conStr(intArray,"word", "|");
        System.out.println(ret);
    }
    private static String conStr(int[] array, String addStr, String splitStr) {
        String newString = "[";
        for ( int i = 0; i < array.length; i++) {
            if (i < array.length - 1){
                newString += addStr + array[i] + splitStr;
            }else{
                newString += addStr + array[i];
            }
        }
        newString += "]";
        return newString;
    }
}