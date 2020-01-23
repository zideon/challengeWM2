package com.workingminds.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SpiralMatrixGeneratorTest {

    @Test
    public void generateMatrixWithNEquals4() {

        int n = 4;
        Integer [][] resultExpect = {{ 1,  2,  3, 4},
                                    {12, 13, 14, 5},
                                    {11, 16, 15, 6},
                                    {10,  9,  8, 7}};


        Integer[][] result =  SpiralMatrixGenerator.generate(n);
        assertArrayEquals( resultExpect,result );
    }
    @Test
    public void generateMatrixWithNEquals3() {

        int n = 3;
        Integer [][] resultExpect = {{ 1,  2,  3},
                {8, 9, 4},
                {7, 6, 5}
        };


        Integer[][] result =  SpiralMatrixGenerator.generate(n);
        assertArrayEquals( resultExpect,result );
    }
    @Test
    public void generateMatrixWithNEquals2() {

        int n = 2;
        Integer [][] resultExpect = {{ 1,  2, },
                {4, 3}
        };


        Integer[][] result =  SpiralMatrixGenerator.generate(n);
        assertArrayEquals( resultExpect,result );
    }
    @Test
    public void generateMatrixWithNEquals1() {

        int n = 1;
        Integer [][] resultExpect = {{ 1 }};


        Integer[][] result =  SpiralMatrixGenerator.generate(n);
        assertArrayEquals( resultExpect,result );
    }
}
