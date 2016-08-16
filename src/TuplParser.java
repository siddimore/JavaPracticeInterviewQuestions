import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siddimore on 8/2/16.
 */
public class TuplParser {

    private String fileName;
    private static int count = 0;
    private static List<AlarmData> alarmList;
    private static SiteAlarmInformation siteInfo;
    private static Map<String, List<AlarmData>> siteToAlarmMap = new HashMap<>();

    //Delimiter used in CSV file

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "id,Region,Market,Date,PLMNID,Site,SiteType,AlarmCount,Cause,Severity";

    public TuplParser(String fileName) {
        this.fileName = fileName;
    }

    private static String AlarmCount(String inputString){

        Matcher noOfAlarms = Pattern.compile(Pattern.quote("active alarms are: ") + "(.*?)" + Pattern.quote(",")).matcher(inputString);
        if (noOfAlarms.find()) {
            String alarmCount = noOfAlarms.group(1);
            if (alarmCount.compareToIgnoreCase("0") != 0) {
                //alarmObject.setAlarmCount(Integer.parseInt(alarmCount));
                System.out.println("Alarm Count: "+alarmCount);
                return alarmCount;
                //Get information for all Alarms
            }
        }
        return null;
    }


    private static String Cause(String inputString){

        Matcher moCause = Pattern.compile(Pattern.quote("MO ") + "(.*?)" + Pattern.quote("Total:")).matcher(inputString);
        if (moCause.find()) {
            String cause = moCause.group(1);
            return cause;
        }

        return null;
    }

    private static void SubNetworkInfo(String inputString, AlarmData alarmObject){

        Matcher getSubNetworkInfo = Pattern.compile(Pattern.quote("(SubNetwork=") + "(.*?)" + Pattern.quote(")")).matcher(inputString);
        if (getSubNetworkInfo.find()) {
            String subNetworkInfo = getSubNetworkInfo.group(1);
            System.out.println("Network Info:" + subNetworkInfo);


            Matcher getSiteRat = Pattern.compile(Pattern.quote("MeContext=") + "(.*?)" + Pattern.quote(",")).matcher(subNetworkInfo);
            if(getSiteRat.find()) {
                String siteRat = getSiteRat.group(1);
                String siteType = "LTE";
                System.out.println("SiteRat:" + siteRat);
                //alarmObject.setSite(siteRat);
                if(!siteRat.contains("L2100")){
                    siteType = "Non-LTE";
                    System.out.println("Non-LTE Site");
                }

                if(Character.isDigit(siteRat.charAt(0))){
                    System.out.println("Indoor " + siteType +  " Site");
                    //alarmObject.setSiteType("Indoor");
                }
                else{
                    System.out.println("Outdoor " + siteType +  " Site");
                    //alarmObject.setSiteType("Outdoor");
                }
            }
        }
    }

    private static String AlarmType(String inputString){

        Matcher getAlarmType = Pattern.compile(Pattern.quote(">>>") + "(.*?)" + Pattern.quote(")")).matcher(inputString);
        if (getAlarmType.find()) {
            System.out.println("AlarmType: " + getAlarmType.group(1));
            String alarmType = getAlarmType.group(1);
            String[] spaceSeperated = alarmType.split(" ");
            Integer count = 0;
            for (String str : spaceSeperated) {
                if (str.equals("Major")) {
                    if (spaceSeperated[--count].compareTo("0") != 0){
                        return "Major";
                    }
                        //alarmObject.setSeverity("Major");

                }
                ++count;
            }
        }
        return "Minor";
    }

    private static String SubNetworkInfor(String inputString){

        Matcher getSubNetworkInfo = Pattern.compile(Pattern.quote("(SubNetwork=") + "(.*?)" + Pattern.quote(")")).matcher(inputString);
        if (getSubNetworkInfo.find()) {
            String subNetworkInfo = getSubNetworkInfo.group(1);
            System.out.println("Network Info:" + subNetworkInfo);
            return subNetworkInfo;
        }

        return null;
    }

    private static String SiteDetail(String inputString){

        Matcher getSiteRat = Pattern.compile(Pattern.quote("MeContext=") + "(.*?)" + Pattern.quote(",")).matcher(inputString);
        if(getSiteRat.find()) {
            String siteDetail = getSiteRat.group(1);
            return siteDetail;
        }

        return null;
    }

    private static String SiteType(String inputString){

        if(Character.isDigit(inputString.charAt(0))){
            return "Indoor";
        }
        else{
           return "Outdoor";
        }
    }

    private static String SiteRat(String inputString){

        if(!inputString.contains("L2100")){
            System.out.println("Non-LTE Site");
            return "Non-LTE";
        }
        return "LTE";
    }
    private static void process() {

        alarmList = new ArrayList<>();
        String fileName = "/Users/siddimore/Documents/alarm.log";
        List<String> extractedData = new ArrayList<>();
        try {
            List<String> Lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            String data = Lines.toString();

            Matcher m = Pattern.compile(
                    Pattern.quote("alt")
                            + "(.*?)"
                            + Pattern.quote("Bye")
            ).matcher(data);

            //Get all Data between all occurences of Alt and Bye
            while (m.find()) {
                AlarmData alarmObject = new AlarmData();
                String match = m.group(1);

                //Get AlarmCount
                String alarmCount = AlarmCount(match);

                if(alarmCount != null) {
                    //Convert AlarmCount to Integer
                    if (alarmCount.compareToIgnoreCase("0") != 0) {
                        alarmObject.setAlarmCount(Integer.parseInt(alarmCount));

                        //Get information for all Alarms
                        Matcher moCause = Pattern.compile(Pattern.quote("MO ") + "(.*?)" + Pattern.quote("Total:")).matcher(match);
                        if (moCause.find()) {
                            String cause = moCause.group(1);
                            System.out.println();
                            ++count;
                            System.out.println("New Defect " + count);

                            //Get SubNetworkInfo
                            String subNetworkInfo = SubNetworkInfor(match);
                            if(subNetworkInfo != null)
                            {
                                String siteDetails = SiteDetail(subNetworkInfo);
                                if(siteDetails != null){
                                    String siteRat = SiteRat(siteDetails);
                                    alarmObject.setSite(siteRat);
                                    String siteType = SiteType(siteDetails);
                                    alarmObject.setSiteType(siteType);
                                }
                            }

                            //Get Alarm Description
                            Matcher parseCause = Pattern.compile(Pattern.quote("m ") + "(.*?)" + Pattern.quote(",")).matcher(cause);
                            if(parseCause.find()) {
                                alarmObject.setAlarmDescription(parseCause.group(1));
                                String alarmDetails = parseCause.group(1);
                            }

                            Matcher getCause = Pattern.compile(Pattern.quote("(Cause/AdditionalInfo)") + "(.*?)" + Pattern.quote(">>>")).matcher(cause);
                            if (getCause.find()) {
                                String alarmDetails = getCause.group(1);

                                //Block Check contains Date
                                {
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    Pattern p = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d");
                                    Matcher dateMatcher = p.matcher(alarmDetails);
                                    Date tempDate = null;
                                    int count = 0;
                                    while(dateMatcher.find())
                                    {
                                        System.out.println("START INDEX:" + dateMatcher.start());
                                        try {
                                            tempDate = format.parse(dateMatcher.group());
                                            System.out.println("Date: " + tempDate);
                                            alarmObject.setAlarmDate(tempDate);
                                        }
                                        catch(ParseException ex){
                                            ex.printStackTrace();
                                        }
                                    }
                                    ++count;
                                }

                                if (getCause.group(1).contains("PLMN ID-eNB")) {

                                    Matcher getPLMNID = Pattern.compile(Pattern.quote("33420") + "(.*?)" + Pattern.quote(")")).matcher(getCause.group(1));

                                    if (getPLMNID.find()) {
                                        String[] spaceSeperated = getPLMNID.group(1).split("-");
                                        for (String s : spaceSeperated) {
                                            System.out.println(s);
                                        }
                                    }
                                }
                            }

                            //Get Alarm Type Information Major, Minor or Critical
                            alarmObject.setAlarmType(AlarmType(match));
                            System.out.println("Alarm Type: " + alarmObject.getAlarmType());
                            //Add Alarm to List
                            alarmList.add(alarmObject);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToCSV() throws NullPointerException {

        if (alarmList == null) throw new NullPointerException("No Alarms were detected");
        String fileName = "/Users/siddimore/Documents/AlarmParsed.csv";
        int count = 1;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new student object list to the CSV file
            for (AlarmData data : alarmList) {
                fileWriter.append(String.valueOf(count));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Mexico");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Toluca");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(data.getAlarmDate()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("334-20");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(data.getSite()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(data.getSiteType()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(data.getAlarmCount()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data.getAlarmDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data.getSeverity());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                ++count;
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();

            }

        }
    }


    public static void main(String[] args) {
        process();
        writeToCSV();
    }
}
