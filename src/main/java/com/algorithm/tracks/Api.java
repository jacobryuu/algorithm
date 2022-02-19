package com.algorithm.tracks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Api {

    public static final Integer EXEC_NUMBERS = 50;
    public static long startTime = 0L;
    public static final long HOUR = 60 * 60 * 1000;

    public static void main(String[] args) throws IOException {

        for (String arg : args) {
            System.out.println(arg);
        }

        if (args.length < 2) {
            System.out.println("More arguments needed");
            return;
        }

        if (!isInteger(args[1])) {
            System.out.println("arguments error");
            return;
        }
        fun(Integer.parseInt(args[1]));

    }

    private static Integer fun(Integer n) throws IOException {
        int apiCalls = 0;
        if (n == 0)
            return 0;
        if (n == 2)
            return 2;
        if (n % 2 == 0) {
            return fun(n - 1) + fun(n - 2) + fun(n - 3) + fun(n - 4);
        } else {
            apiCalls += 1;
            if (apiCalls == 1) {
                startTime = System.currentTimeMillis();
            }
            if (apiCalls < EXEC_NUMBERS
                    && System.currentTimeMillis() - startTime < HOUR) {
                if (System.currentTimeMillis() - startTime > HOUR) {
                    apiCalls = 0;
                    startTime = System.currentTimeMillis();
                }
                return askServer(n);
            }

        }

        return null;
    }

    private static Integer askServer(Integer n) throws IOException {
        String command = "curl http://challenge-server.code-check.io/api/recursive/generate?n=%d";
        Runtime run = Runtime.getRuntime();
        Process pro = run.exec(String.format(command, n));
        InputStream is = pro.getInputStream();
        String output = printInputStream(is);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ResultJson resultJson = gson.fromJson(output, ResultJson.class);

        return resultJson.getResult();
    }

    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    private static String printInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(is))) {
            for (; ; ) {
                String line = br.readLine();
                if (line == null)
                    break;
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException exception) {
            exception.printStackTrace();

        }
        return sb.toString();

    }

}

class ResultJson {
    private String seed;
    private int n;
    private int result;
    public String getSeed() {
        return seed;
    }
    public int getN() {
        return n;
    }
    public int getResult() {
        return result;
    }
    public void setSeed(String seed) {
        this.seed = seed;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void setResult(int result) {
        this.result = result;
    }
}

