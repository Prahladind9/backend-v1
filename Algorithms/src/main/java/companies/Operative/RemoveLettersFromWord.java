package companies.Operative;

import java.util.HashMap;

public class RemoveLettersFromWord {
    //https://www.linkedin.com/jobs/view/1845668809/?refId=198c131a-2471-4507-8fde-81c4b8a84444&trk=flagship3_job_home_appliedjobs

    public static void main(String[] args) {
        RemoveLettersFromWord removeLettersFromWord = new RemoveLettersFromWord();
//        String s = "BAONXXOLL";
        String s = "BAONXXLL";

        System.out.println(removeLettersFromWord.solution(s));
        System.out.println();
    }

    public int solution(String S) {

        // write your code in Java SE 8
        //B A L L O O N
        //can delete '7' letters from word S
        //A(1), B(1), L(2) , N(1), O(2)
        // 1 : 1 : 2 : 1 : 2

        //1) 1 comb (7)
        //2) 2 comb (14)
        //3) 0 comb ( no 2 Ls)
        //4) 1 comb

        //


        if(S.length() < 7)
            return 0;

        char[] chars = S.toCharArray();
//        Arrays.sort(chars);
        HashMap<Character,Integer> hashMap = new HashMap();
        hashMap.put('A',0);
        hashMap.put('B',0);
        hashMap.put('L',0);
        hashMap.put('N',0);
        hashMap.put('O',0);

        for(char val : chars){
            if(val == 'A' || val == 'B' ||val == 'L' ||val == 'N' ||val == 'O' )
            hashMap.put(val,hashMap.get(val) + 1);
        }

        int moves = 0;

        while (checkRatio(hashMap)){
            moves = moves + 1;
        }

        return moves;
    }

    private boolean checkRatio(HashMap<Character,Integer> hashMap){
        if(hashMap.get('A') - 1 >=0 ){
            hashMap.put('A',hashMap.get('A') - 1);
        }else{
            return false;
        }
        if(hashMap.get('B') - 1 >=0 ){
            hashMap.put('B',hashMap.get('B') - 1);
        }else{
            return false;
        }

        if(hashMap.get('L') - 2 >=0 ){
            hashMap.put('L',hashMap.get('L') - 2);
        }else{
            return false;
        }

        if(hashMap.get('N') - 1 >=0 ){
            hashMap.put('N',hashMap.get('N') - 1);
        }else{
            return false;
        }

        if(hashMap.get('O') - 2 >=0 ){
            hashMap.put('O',hashMap.get('O') - 2);
        }else{
            return false;
        }

        return true;
    }
}
