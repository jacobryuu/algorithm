package com.algorithm.tracks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        final String dropouts = "dropouts";
        final String topVsbotton = "top-vs-bottom";
        List<Student> grades = new ArrayList<>();
        boolean first = true;
        final int dropoutGrade = 49;

        Student student = null;
        try {
            File file = new File(args[1]);
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }
                int dropCount = 0;
                String[] studentArray = data.split(",");
                student = new Student();
                student.setId(studentArray[0]);
                student.setOrderId(
                        Integer.parseInt(studentArray[0].substring(1)));
                int math = Integer.parseInt(studentArray[1]);
                student.setMath(math);
                if (math <= dropoutGrade) {
                    dropCount += 1;
                }
                int science = Integer.parseInt(studentArray[2]);
                student.setScience(science);
                if (science <= dropoutGrade) {
                    dropCount += 1;
                }
                int english = Integer.parseInt(studentArray[3]);
                student.setEnglish(english);
                if (english <= dropoutGrade) {
                    dropCount += 1;
                }
                int japanese = Integer.parseInt(studentArray[4]);
                student.setJapanese(japanese);
                if (japanese <= dropoutGrade) {
                    dropCount += 1;
                }
                int history = Integer.parseInt(studentArray[5]);
                student.setHistory(history);
                if (history <= dropoutGrade) {
                    dropCount += 1;
                }
                int geography = Integer.parseInt(studentArray[6]);
                student.setGeography(geography);
                if (geography <= dropoutGrade) {
                    dropCount += 1;
                }
                float avg =
                        ((float) (math + science + english + japanese + history
                                + geography)) / 6;
                BigDecimal bd = new BigDecimal(avg);
                BigDecimal bdAvg = bd.setScale(2, RoundingMode.HALF_UP);
                student.setAvg(bdAvg);
                if (dropCount >= 2) {
                    student.setDropout(true);
                } else {
                    student.setDropout(false);
                }
                grades.add(student);
            }
            filereader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dropouts.equalsIgnoreCase(args[0])) {

            List<Student> studentOrderById = grades.stream()
                    .sorted(Comparator.comparing(Student::getOrderId))
                    .filter(Student::isDropout)
                    .collect(Collectors.toList());
            System.out.println("ID");
            studentOrderById.forEach(
                    student1 -> System.out.println(student1.getId()));

        } else if (topVsbotton.equalsIgnoreCase(args[0])) {
            List<Student> studentOrderByAvgAndId = grades.stream()
                    .sorted(Comparator.comparing(Student::getAvg)
                            .thenComparing(Student::getOrderId))
                    .collect(Collectors.toList());

            BigDecimal minAvg = studentOrderByAvgAndId.get(0).getAvg();
            BigDecimal maxAvg = studentOrderByAvgAndId.get(
                    studentOrderByAvgAndId.size() - 1).getAvg();

            List<Student> studentMinAndMax = studentOrderByAvgAndId.stream()
                    .filter(s -> s.getAvg() == minAvg || s.getAvg() == maxAvg)
                    .collect(Collectors.toList());
            System.out.print("ID,");
            System.out.println("Mean");
            studentMinAndMax.forEach(student1 -> {
                System.out.print(student1.getId() + ",");
                System.out.println(student1.getAvg());
            });

        }

    }
}

class Student {
    private String id;
    private int orderId;
    private int math;
    private int science;
    private int english;
    private int japanese;
    private int history;
    private int geography;
    private BigDecimal avg;
    private boolean dropout;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getScience() {
        return science;
    }
    public void setScience(int science) {
        this.science = science;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int getJapanese() {
        return japanese;
    }
    public void setJapanese(int japanese) {
        this.japanese = japanese;
    }
    public int getHistory() {
        return history;
    }
    public void setHistory(int history) {
        this.history = history;
    }
    public int getGeography() {
        return geography;
    }
    public void setGeography(int geography) {
        this.geography = geography;
    }

    public boolean isDropout() {
        return dropout;
    }
    public void setDropout(boolean dropout) {
        this.dropout = dropout;
    }
    public BigDecimal getAvg() {
        return avg;
    }
    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }
}
