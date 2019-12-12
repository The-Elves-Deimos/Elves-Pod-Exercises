package jwhester.Exercise3.week1;

public class Exercise3 {
    public static void average(double[] array){
        double total = 0;
        for (double num : array) {
            total += num;
        }
        double avg = total / array.length;
        System.out.println("The sum is " + total);
        System.out.println("The average is " + avg);

    }

    public static void main(String[] args) {
        double[] array = new double[5];
        for (int i = 0; i < array.length; i++) {
            double rd = (Math.random()*((10-1)+1));
            array[i] = Math.round(rd);
            System.out.println("#"+ i + " is " +array[i]);
        }
        average(array);
    }
}
