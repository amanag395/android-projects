package craterzone.selectmultiplefromlist.thread;

/**
 * Created by aMAN GUPTA on 3/6/2017.
 */

public class AddCountryThread implements Runnable {
    //    private boolean isStart;
    AddCountryListner addCountryListner;

    public AddCountryThread(AddCountryListner addCountryListner) {
        this.addCountryListner = addCountryListner;
//        isStart = false;
    }

    @Override
    public void run() {
//        int i =0;
//        while (true){
//            if (isStart){
//                addCountryListner.addCountry(""+(i++));
//            }
//        }
    }

    public void add100Countries() {
        for (int i = 0; i < 10; i++) {
            addCountryListner.addCountry("Country" + i);
        }
    }

//    public void setStartStop(){
//        isStart = !isStart;
//    }

    public interface AddCountryListner {
        public void addCountry(String name);
    }
}
