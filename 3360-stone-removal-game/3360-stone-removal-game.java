class Solution {
    public boolean canAliceWin(int n) {
      /*  int take = 10;
        int steps = 0;
        while(n >= take){
            n -= take;
            take -= 1; //from 10 it will come 9 then 8 then 7 so on....
            steps++;
        }
        if(take%2 == 1){
            return true;
        }
        else{
            return false;
        }
    }*/

        int k = (int) ((21.0 - Math.sqrt(441.0 - 8L * n)) / 2.0); // using the quadratic formula 

        return k % 2 == 1;
    }    
}