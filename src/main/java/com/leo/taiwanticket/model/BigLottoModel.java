package com.leo.taiwanticket.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BigLottoModel {

    int nums = 49;
    int choose = 6;

    //{
    //             1, 2, 3, 4, 5, 6, 7, 8, 9,10,
    //            11,12,13,14,15,16,17,18,19,20,
    //            21,22,23,24,25,26,27,28,29,30,
    //            31,32,33,34,35,36,37,38,39,40,
    //            41,42,43,44,45,46,47,48,49,
    //    }

    //隨機產生一組樂透號碼 並且轉為字串
    public String getRandomNum(){
        Set<Integer> integerSet = new HashSet<>();
        while(integerSet.size() < choose){
            int random = (int)(Math.random() * nums + 1);
            integerSet.add(random);
        }
        //Set 轉 int[]
        int[] newNums = integerSet.stream().mapToInt(x -> x).toArray();
        Arrays.sort(newNums);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < newNums.length; i++){
            if(newNums[i] < 10)
                sb.append("0");
            sb.append(newNums[i]);
        }
        return sb.toString();
    }
}
