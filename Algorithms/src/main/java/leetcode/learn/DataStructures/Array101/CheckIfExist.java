package leetcode.learn.DataStructures.Array101;

public class CheckIfExist {
    public static void main(String[] args) {
        CheckIfExist checkIfExist = new CheckIfExist();
        System.out.println(checkIfExist.checkIfExist(new int[]{10,2,5,3}));
//        System.out.println(checkIfExist.checkIfExist(new int[]{-10,12,-20,-8,15}));
//        System.out.println(checkIfExist.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }



    public boolean checkIfExist(int[] arr) {
        if(arr.length == 0){
            return false;
        }
        //Arrays.sort(arr); --> Not required as searching for all the elements
        //Edge Case --> _ve Values and zero values

        //2 arrays
        //for first array element check if * 2 value exist in the loop of 2nd array

        for(int i =0; i < arr.length;i++){
                for(int k = 0; k < arr.length; k++){
                    if(arr[i] * 2 == arr[k] && i != k){
                        return true;
                    }
                }
        }

        return false;
    }
}
