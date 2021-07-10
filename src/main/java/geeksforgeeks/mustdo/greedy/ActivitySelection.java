package geeksforgeeks.mustdo.greedy;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1
public class ActivitySelection {

    public static void main(String[] args) {
        int start[] = {1, 3, 2, 5};
        int end[] = {2, 4, 3, 6};

         int count =activitySelection(start, end, start.length);
        System.out.println("Total Activities :" + count);
    }

    //Create one activity class and keep start time and end time
    //1 : add all the object in a list
    //2 : sort the object based on the end time
    //3 : Now compare the object 1st end time with next start time, if >= and increase the counter
    public static int activitySelection(int start[], int end[], int n) {
        int counter = 0;

        List<Activity> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Activity(start[i], end[i]));
        }

        list.sort(Comparator.comparingInt(a -> a.endTime));
        int i =0;
        for (int j = 1 ; j < list.size() ; j ++){
            if(list.get(j).startTime >= list.get(i).endTime){
               counter++;
               i=j;
            }
        }
        return counter;
    }

}

class Activity {
    int startTime;
    int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
