package Processing;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    @Expose
    public String time;
    public String day;
    public String answer;

    public Activities() {
    }

    public Activities(String time, String day, String answer) {
        this.time = time;
        this.day = day;
        this.answer = answer;
    }
    public String[] getActivity(){
        String[] activity = new String[3];
        activity[0]=this.time;
        activity[1]=this.day;
        activity[2]=this.answer;
        System.out.println(this.time);
        System.out.println(this.day);
        System.out.println(this.answer);
        return activity;
    }
    public String getAnswer(){
        return this.answer;
    }
    public String getDay(){
        return this.day;
    }
    public String getTime(){
        return this.time;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setDay(String day){
        this.day=day;
    }
    public void setAnswer(String answer){
        this.answer=answer;
    }

}
class Activitiess {
    @Expose
    List<Activities> activities = new ArrayList<>();

    public List<Activities> getActivity() {
        return activities;
    }

    public void addActivity(Activities activity) {
        this.activities.add(activity);
    }
}
