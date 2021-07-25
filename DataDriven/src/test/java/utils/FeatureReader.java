package utils;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;

public class FeatureReader {

    private String scenarioName;
    private String[] parameters;

    public void readFeatureFile(String directoryPath) {

        File dir = new File(directoryPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    boolean exampleFound = false;
                    while ( (line =  br.readLine()) != null){
                        if (line.contains("Scenario Outline")){
                            scenarioName = line.replaceAll("Scenario Outline", "").replaceAll(":","").trim();
                            System.out.println("Current Scenario: " + scenarioName);
                            continue;
                        }
                        if (line.contains("Examples")){
                            exampleFound = true;
                            continue;
                        }
                        if (exampleFound){
                            parameters = line.split("\\|");
                            System.out.println(Arrays.asList(parameters));
                            exampleFound = false;
                        }
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    private void testReadFeatureFile(){
        String dir = "src//test//resources//FeatureFiles";
        readFeatureFile(dir);
    }
}
