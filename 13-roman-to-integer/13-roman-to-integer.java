
class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        char[] array = s.toCharArray();
        int[] intArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if (array[i] == 'M')
                intArray[i] = 1000;
            else if(array[i] == 'D')
                intArray[i] = 500;
            else if(array[i] == 'C')
                intArray[i] = 100;
            else if(array[i] == 'L')
                intArray[i] = 50;
            else if(array[i] == 'X')
                intArray[i] = 10;
            else if(array[i] == 'V')
                intArray[i] = 5;
            else if(array[i] == 'I')
                intArray[i] = 1;
        }
        for(int i = 0; i < intArray.length; i++){
            if(i + 1 < intArray.length && intArray[i] < intArray[i + 1]){
                intArray[i] = intArray[i] * -1;
            }
        }
        for(int i = 0; i < intArray.length; i++){
            answer = answer + intArray[i];
        }
        return answer;
    }
}