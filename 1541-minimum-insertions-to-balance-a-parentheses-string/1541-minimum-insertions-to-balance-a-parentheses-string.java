class Solution{
    public int minInsertions(String s){
    int ans=0,needed=0;
    for(int i=0;i<s.length();i++){
    if(s.charAt(i)=='('){
    needed+=2;
    if(needed%2==1){
    ans++;
    needed--;
    }
    }else{
    needed--;
    if(needed<0){
    ans++;
    needed+=2;
    }
    }
    }
    return ans+needed;
    }
    }
