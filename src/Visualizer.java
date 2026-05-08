import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Visualizer{
    private int height=550; 
    private int width=807;

    JFrame frame= new JFrame("Vizualization"); 
    VisualPanel disPanel = new VisualPanel();
    
    JPanel buttonPanel = new JPanel();

    Visualizer(String s){
        System.out.println("Visualizing");

        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.add(disPanel);
        frame.pack();
        frame.setVisible(true);

        if(s.replaceAll("\\s+", "").equalsIgnoreCase("bubbleSort")){
            frame.setTitle("Bubble Sort");
            disPanel.bubbleSort();
            
        }
        else if(s.replaceAll("\\s+", "").equalsIgnoreCase("selectionSort"))
        {   
            frame.setTitle("Selection Sort");
            disPanel.selectionSort();
        }
        else if(s.replaceAll("\\s+", "").equalsIgnoreCase("heapSort"))
        {   
            frame.setTitle("Heap Sort");
            disPanel.heapSort();
        }
         else if(s.replaceAll("\\s+", "").equalsIgnoreCase("insertionSort"))
        {   
            frame.setTitle("Insertion Sort");
            disPanel.insertionSort();;
        }
        else
        {
            frame.setTitle("Visualization");
        }
    }
}





// buttonPanel.setBackground(Color.WHITE);
//         frame.add(buttonPanel,BorderLayout.PAGE_END);

//         JButton button = new JButton();
//         button.setFont(new Font("Arial",Font.PLAIN,5));
//         button.setText("Heap Sort");
//         button.setFocusable(false);
//         //button.setBorder(new LineBorder(black));

//         buttonPanel.add(button);
//         button.addActionListener(e -> disPanel.heapSort());