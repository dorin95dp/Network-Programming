
public class MyThread extends Thread {
    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void run() {

        System.out.println(ID);
    }

}