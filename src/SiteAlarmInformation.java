import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siddimore on 8/8/16.
 */
public class SiteAlarmInformation {

    private Map<String, List<AlarmData>> siteInfo;
    private List<Map<String, List<AlarmData>>> allAlarms;

    public Map<String, List<AlarmData>> getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(Map<String, List<AlarmData>> siteInfo) {
        this.siteInfo = siteInfo;
    }

    public List<Map<String, List<AlarmData>>> getAllAlarms() {
        return allAlarms;
    }

    public void setAllAlarms(List<Map<String, List<AlarmData>>> allAlarms) {
        this.allAlarms = allAlarms;
    }

    public SiteAlarmInformation(){
        siteInfo = new HashMap<>();
        allAlarms = new ArrayList<>();
    }


}
