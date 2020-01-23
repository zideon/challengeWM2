package com.workingminds.util;


import java.util.Arrays;
import java.util.stream.IntStream;

public class SpiralMatrixGenerator {

    public static Integer[][] generate(int n) {
        boolean direction = true;
        Integer[][] matrix = new Integer[n][n];
        fillBorder(1, 0, matrix);

        return matrix;
    }

    private static Integer[][] fillBorder(int ind, int subMatrixIndex, Integer[][] matrix) {

        if (ind > matrix.length * matrix.length) {
            return matrix;
        }

        for (MatrixLineEnum line : MatrixLineEnum.values()) {
            ind = fillLine(ind, subMatrixIndex, line, matrix);
        }

        return fillBorder(ind, subMatrixIndex + 1, matrix);
    }

    private static int fillLine(int ind, int subMatrixIndex, MatrixLineEnum lineEnum, Integer[][] matrix) {
        int[] indexes =getIndexes(lineEnum,subMatrixIndex,matrix.length);
        for (int i: indexes) {
            ind = fillElement(ind,lineEnum,i, subMatrixIndex,matrix);
        }
        return ind;
    }

    private static int[] getIndexes(MatrixLineEnum lineEnum,int subMatrixIndex, int size){
        int max = size - subMatrixIndex;
        if (lineEnum == MatrixLineEnum.LINE_UP || lineEnum==MatrixLineEnum.LINE_RIGHT) {
            return IntStream.iterate(subMatrixIndex, i -> i+1).limit(max).toArray();
        }
        if (lineEnum == MatrixLineEnum.LINE_LEFT || lineEnum==MatrixLineEnum.LINE_DOWN) {
            return IntStream.iterate((size - 1) - subMatrixIndex, i -> i-1).limit(max).toArray();
        }
        return null;
    }

    private static int fillElement(int ind,MatrixLineEnum line, int i,  int subMatrixIndex, Integer[][] matrix) {
        int first = subMatrixIndex;
        int last = (matrix.length- 1)- subMatrixIndex;
        switch (line) {
            case LINE_UP:
                if(matrix[first][i]==null)matrix[first][i] = ind++;
                break;
            case LINE_RIGHT:
                if( matrix[i][last]==null)matrix[i][last] = ind++;
                break;
            case LINE_DOWN:
                if(matrix[last][i]==null)matrix[last][i] = ind++;
                break;
            case LINE_LEFT:
                if( matrix[i][first]==null)matrix[i][first] = ind++;
                break;
        }
        return ind;
    }

    private enum MatrixLineEnum {
        LINE_UP, LINE_RIGHT, LINE_DOWN, LINE_LEFT;
    }
}
