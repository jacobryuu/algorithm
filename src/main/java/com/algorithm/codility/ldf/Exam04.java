package com.algorithm.codility.ldf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Exam04 {

    public int[] solution(String[] A) {
        final String EVICT = "evict";
        final String ADD = "add";
        final String GET = "get";
        final String REMOVE = "remove";
        final String EXIT = "exit";

        int max = 0;
        List<Integer> resultList = new ArrayList<>();

        Map<Integer, Integer> operateMap = new ConcurrentHashMap<>();
        for (String op : A) {
            String[] operateArrays = op.split(" ");
            switch (operateArrays[0]) {
                case ADD:
                    operateMap.put(Integer.parseInt(operateArrays[1]),
                            Integer.parseInt(operateArrays[2]));
                    max = Integer.parseInt(operateArrays[1]);
                    break;
                case GET:
                    if (operateMap.get(Integer.parseInt(operateArrays[1]))
                            == null) {
                        resultList.add(-1);
                    } else {
                        resultList.add(operateMap.get(
                                Integer.parseInt(operateArrays[1])));
                    }
                    break;
                case REMOVE:
                    if (operateMap.get(Integer.parseInt(operateArrays[1]))
                            == null) {
                        resultList.add(-1);
                    } else {
                        resultList.add(operateMap.remove(
                                Integer.parseInt(operateArrays[1])));
                    }
                    break;
                case EXIT:
                    break;
                case EVICT:
                    operateMap.remove(max);
                    break;
                default:
                    break;

            }
        }
        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }
}
