package DSA.SearchingAlgorithms.FileHandling;

import java.io.*;

public class CompareStringAndReaderPerformance {
    public static void main(String[] args) {
        //Part 1: Compare StringBuilder and StringBuffer for Concatentation

        compareStringBuilderAndStringBuffer();

        //Part 2: Compare FileReader And InputStreamReader for Reading Files
        String filePath="C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\100mbexamplefile.txt";
        compareFileReaderAndInputStreamReader(filePath);
    }
    private  static void compareStringBuilderAndStringBuffer(){
        int iterations=1_000_000;
        String text="hello";

        StringBuilder stringBuilder=new StringBuilder();
        long startStringBuilder=System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endStringBuilder=System.nanoTime();
        System.out.println("StringBuilder took: "+(endStringBuilder-startStringBuilder)+" nanoseconds");

        StringBuffer stringBuffer=new StringBuffer();
        long startStringBuffer=System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endStringBuffer=System.nanoTime();
        System.out.println("StringBuffer took: "+(endStringBuffer-startStringBuffer)+" nanoseconds");

        if((endStringBuilder-startStringBuilder)<(endStringBuffer-startStringBuffer)){
            System.out.println("StringBuilder is faster for single-threaded operations.");
        }else{
            System.out.println("StringBuffer might be preferred for thred-safety, but it's slower in single-threaded scenarios.");
        }
    }

    private static void compareFileReaderAndInputStreamReader(String filePath){
        try(FileReader fileReader=new FileReader(filePath);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){

            long startFileReader=System.nanoTime();
            int wordCount=0;
            String line;
            while((line=bufferedReader.readLine())!=null){
                wordCount+=line.split("\\s+").length;
            }
            long endFileReader=System.nanoTime();
            System.out.println("FileReader Word Count: "+wordCount);
            System.out.println("FileReader took: "+(endFileReader-startFileReader)+" nanoseconds");
        } catch (IOException e) {
            System.out.println("Error using FileReader: "+e.getMessage());
        }

        try(FileInputStream fileInputStream=new FileInputStream(filePath);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader)){

            long startInputStreamReader=System.nanoTime();
            int wordCount=0;
            String line;
            while((line=bufferedReader.readLine())!=null){
                wordCount+=line.split("\\s+").length;
            }
            long endInputStreamReader=System.nanoTime();
            System.out.println("InputStreamReader word count: "+wordCount);
            System.out.println("InputStreamReader took: "+(endInputStreamReader-startInputStreamReader)+" nanoseconds");
        }catch (IOException e){
            System.out.println("Error using InputStreamReader: "+e.getMessage());
        }
    }
}
