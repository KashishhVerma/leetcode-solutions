/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int num=0;
        while(true){
            int row=rand7();
            int col=rand7();
            num=(row-1)*7+col;
            if(num<=40)break;
        }
        return 1+(num-1)%10;
    }
}