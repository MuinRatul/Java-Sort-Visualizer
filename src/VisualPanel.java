import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class VisualPanel extends JPanel{

    private int currentIndex1 = -1;
    private int currentIndex2 = -1;
    private boolean done= false;

    int[] array ={87, 12, 45, 3, 99, 56, 23, 71, 8, 64, 
                31, 90, 14, 77, 42, 5, 68, 27, 81, 19, 
                53, 2, 95, 36, 74, 11, 60, 29, 84, 7, 
                48, 92, 16, 39, 66, 25, 79, 1, 58, 33, 
                88, 21, 70, 10, 44, 97, 6, 52, 18, 73, 
                42, 7, 91, 18, 63, 25, 84, 3, 56, 72,
                14, 100, 37, 61, 8, 45, 88, 29, 53, 11,
                76, 20, 67, 5, 94, 31, 58, 13, 80, 24,
                49, 2, 70, 35, 97, 16, 64, 9, 51, 27,
                83, 40, 6, 74, 22, 59, 1, 86, 33, 68};
        

    VisualPanel(){
        this.setPreferredSize(new Dimension(807,500));
        this.setBackground(Color.lightGray);
    }
    void sleep(){
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g ;

        int x = 5;
        for(int i = 0;i<array.length;i++)
        {
            int y = 500 - 500*array[i]/100;
            int bar_height = 500*array[i]/100;
            int bar_width = 6;

            g2.setStroke(new BasicStroke(1));
            //g2.setPaint(Color.gray);
            if(done){
                g2.setPaint(Color.white);
            }                
            else if(i == currentIndex1 ){
                g2.setPaint(Color.black);
            }
            else if(i == currentIndex2){
                g2.setPaint(Color.white);
            }
            else{
                g2.setPaint(Color.GRAY);
            }

            g2.fillRect(x, y, bar_width, bar_height);

            x = x+bar_width+2;
        }
    }
    public void bubbleSort() 
    {
        new Thread(() -> {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    currentIndex1 = j;
                    currentIndex2 = j + 1;
                    if (array[j] > array[j + 1]) {
                        // swap
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        // redraw screen
                        repaint();
                        // delay
                        sleep();
                    }
                }
            }
            currentIndex1 = -1;
            currentIndex2 = -1;
            done= true;
            repaint();
        }).start();
    }

    public void quickSort()
    {
        new Thread();
    }

    public void selectionSort()
    {
        new Thread(() -> 
        {
            for (int i = 0; i < array.length - 1; i++) {
                // Find the minimum element in the unsorted array
                int minIdx = i;
                for (int j = i + 1; j < array.length; j++) {
                    currentIndex1 = j;
                    currentIndex2 = minIdx;
                    if (array[j] < array[minIdx]) {
                        minIdx = j;
                    }
                }
                // Swap the found minimum element with the first element
                int temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;

                repaint();
                // delay
                sleep();
            }
            currentIndex1 = -1;
            currentIndex2 = -1;
            done = true;
            repaint();    
        }).start();
    }

    public void heapSort()
    {
        new Thread(() ->
        {
            int n = array.length;
            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(array, n, i);
            // One by one extract an element from heap
            for (int i = n - 1; i >= 0; i--) {
                // Move current root to end
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                repaint();
                // delay
                sleep();
                // call max heapify on the reduced heap
                heapify(array, i, 0); 
            }
            currentIndex1 = -1;
            currentIndex2 = -1;
            done= true;
            repaint();
        }).start();
    }

    void heapify(int arr[], int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2; 

        currentIndex1 = l;
        currentIndex2 = r;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            repaint();
            sleep();
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    void insertionSort()
    {
        new Thread(() ->
        {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j] > key) {
                    currentIndex1 = j;
                    currentIndex2 = j+1;
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                // Place the key in its correct sorted position
                array[j + 1] = key;
                repaint();
                sleep();
            }
            currentIndex1 = -1;
            currentIndex2 = -1;
            done = true;
            repaint();
        }).start();
    }
}
