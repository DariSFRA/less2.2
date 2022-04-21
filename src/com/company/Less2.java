package com.company;
import java.util.ArrayList;
import java.util.List;

public class Less2 {
    public static void main(String[] args) {
        String[][] normal = {
                {"11", "12", "22", "40"},
                {"22", "33", "44", "55"},
                {"66", "33", "88", "90"},
                {"65", "23", "78", "34"}
        };
        String[][] wrongSize = {
                {"56", "23", "67", "76"},
                {"37", "59", "83", "39"},
                {"75", "84", "94", "33"},
                {"56", "83", "77"}
        };
        String[][] otherWrongSize = {
                {"88", "74", "93", "93"},
                {"83", "74", "39", "83"},
                {"93", "93", "91", "29"}
        };
        String[][] wrongData = {
                {"11", "12", "22", "40"},
                {"22", "33", "44", "55"},
                {"66", "33", "88", "90"},
                {"65", "23", "78", "z"}
        };
        List<String[][]> inputs = new ArrayList<>(List.of(normal, wrongSize, wrongData, otherWrongSize));
        for (String[][] input : inputs) {
            try {
                System.out.printf("Сумма элементов массива = %s\n", sumArrayElements(input));
            } catch (MyArraySizeException e) {
                System.out.printf("Неверный размер массива. Массив должен соответствовать размеру 4x4");
            } catch (MyArrayDataException e) {
                System.out.printf("Элемент массива не распознан, проверьте данные %d x %d", e.i, e.j);
            }
        }
    }

        public static int sumArrayElements ( final String[][] inputArr) throws
        MyArraySizeException, MyArrayDataException {
            int sum = 0;
            if (inputArr.length != 4) {
                throw new MyArraySizeException("input array size must be 4x4");
            }
            for (int i = 0; i < inputArr.length; i++) {
                for (int j = 0; j < inputArr.length; j++) {
                    try {
                        sum += Integer.parseInt(inputArr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, "can't parse element of input array");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new MyArraySizeException("input array size must be 4x4");
                    }
                }
            }
            return sum;
        }
    }







