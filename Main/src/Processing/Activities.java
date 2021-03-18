package Processing;

public class Activities {
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

}
