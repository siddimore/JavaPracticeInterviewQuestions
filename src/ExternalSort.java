import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by MoreFamily on 5/28/2016.
 */
public class ExternalSort {

    static int MaxFileSize = 2000000;
    static int MaxMemorySize = 1000000;

    public static void externalSort(String fileName){

        String tFile = "temp-file-";
        int[] buffer = new int[MaxFileSize < MaxMemorySize ? MaxFileSize : MaxMemorySize];

        try{

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int slices = (int) Math.ceil((double) MaxFileSize/MaxMemorySize);

            int i,j;

            i = j =0;

            //Iterate through the elements in file
            for(i = 0; i < slices; i++){

                // Read M-element chunk at a time from the file
                for (j = 0; j < (MaxFileSize < MaxMemorySize ? MaxFileSize : MaxMemorySize); j++)
                {
                    String t = br.readLine();
                    if (t != null)
                        buffer[j] = Integer.parseInt(t);
                    else
                        break;
                }
                // Sort M elements
                Arrays.sort(buffer);


                // Write the sorted numbers to temp file
                FileWriter fw = new FileWriter("C:\\test\\" + tFile + Integer.toString(i) + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int k = 0; k < j; k++)
                    pw.println(buffer[k]);

                pw.close();
                fw.close();
            }
            br.close();
            fr.close();

            // Now open each file and merge them, then write back to disk
            int[] topNums = new int[slices];
            BufferedReader[] brs = new BufferedReader[slices];

            for (i = 0; i < slices; i++)
            {
                brs[i] = new BufferedReader(new FileReader("C:\\test\\" +tFile + Integer.toString(i) + ".txt"));
                String t = brs[i].readLine();
                if (t != null)
                    topNums[i] = Integer.parseInt(t);
                else
                    topNums[i] = Integer.MAX_VALUE;
            }

            FileWriter fw = new FileWriter("C:\\test\\external-sorted.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (i = 0; i < MaxMemorySize; i++)
            {
                int min = topNums[0];
                int minFile = 0;

                for (j = 0; j < slices; j++)
                {
                    if (min > topNums[j])
                    {
                        min = topNums[j];
                        minFile = j;
                    }
                }

                pw.println(min);
                String t = brs[minFile].readLine();
                if (t != null)
                    topNums[minFile] = Integer.parseInt(t);
                else
                    topNums[minFile] = Integer.MAX_VALUE;

            }
            for (i = 0; i < slices; i++)
                brs[i].close();

            pw.close();
            fw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            }catch(IOException ex){
//
//        }
    }

    static String generateInput(int n)
    {
        String fileName = "external-unsort.txt";
        Random rand = new Random();

        try
        {
            FileWriter fw = new FileWriter("C:\\test\\" +fileName);
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(101));

            pw.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "C:\\test\\" +fileName;
    }

    public static void main(String[] args)
    {
        String fileName = generateInput(MaxMemorySize);
        externalSort(fileName);
    }
}
