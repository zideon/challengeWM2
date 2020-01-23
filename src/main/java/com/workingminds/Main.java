package com.workingminds;

import com.workingminds.util.SpiralMatrixGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        if(args.length==1){
            n = Integer.parseInt(args[0]);
        }
        Integer[][] generate = SpiralMatrixGenerator.generate(n);
        for(int i = 0; i< generate.length;i++){
            System.out.println(Arrays.toString(generate[i]));
        }
    }
}
