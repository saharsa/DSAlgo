package LeetCode;

public class LongestSubstringWithoutRepeatChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abceabcdebb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s.length()>0){
            String mSub = "";
            String lSub = ""+ s.charAt(0);
            int i=1, pos=0;
            int count = 0;
            while(i<s.length()){
                count++;
                if(lSub.contains(""+s.charAt(i))){
                    if(mSub.length()<lSub.length()){
                        mSub = lSub;
                    }
                    pos = pos + lSub.lastIndexOf(s.charAt(i))+1;
                    lSub = s.substring(pos, i+1);
                    i = pos+lSub.length()-1;
                }else{
                    lSub+=s.charAt(i);
                }
                i++;
            }

            if(mSub.length()<lSub.length()){
                mSub = lSub;
            }

            //System.out.println(count);
            return mSub.length();
        }
        return 0;

    }
}
