package com.ishan.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculate {

    public int add(String s){
        final int[] sum = {0};
        if(s.equals(""))
       {
           return sum[0];
       }
       String delimiter = ",";
       String remain = s.trim();
       if(remain.startsWith("//")){
           delimiter = s.substring(2,3);
           remain = s.substring(4);
       }
       String[] s1 = remain.split("["+ delimiter +"\n]");
        List<Integer> nums = Arrays.stream(s1).map(s2 -> {
            try {
                return Integer.parseInt(s2);
            } catch (Exception e) {
                throw new RuntimeException("Not valid String");
            }
        }).collect(Collectors.toList());
        List<Integer> negativeNums = nums.stream().filter(n1 -> n1 < 0).collect(Collectors.toList());
        if(!negativeNums.isEmpty()){
            String exceptionMsg = negativeNums.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new RuntimeException("negatives not allowed "+ exceptionMsg);
        }
        sum[0] = nums.stream().reduce(0, (a,b) -> a+b);

//           Stream<String> stream = Arrays.stream(s1).filter(s2 -> !s2.equals(""));
//           stream.mapToInt(Integer::parseInt).forEach(n1 -> {
//               if(n1 < 0){
//                   negativeNumbers.add(n1);
//               }else{
//                   sum[0] +=n1;
//               }
//           });
//           if(!negativeNumbers.isEmpty()){
//               throw new RuntimeException("negatives not allowed "+negativeNumbers.toString());
//           }

        return sum[0];
    }

}
