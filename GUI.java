import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.showSizeFrame(gui.grid);
    }

    String[][] grid;

    public GUI(){
    }

    private void showSizeFrame(String[][] grid){
        // Size Frame
        JFrame sizeFrame = new JFrame("Sokoban Solver");
        sizeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sizeFrame.setSize(400, 300);
        sizeFrame.setLayout(new GridLayout(3,2,2,5));
        JLabel rowLabel = new JLabel("Enter number of rows");
        JLabel colLabel = new JLabel("Enter number of columns");
        JTextField rowField = new JTextField();
        JTextField colField = new JTextField();
        JButton sizeButton = new JButton("Submit");
        sizeFrame.add(rowLabel);
        sizeFrame.add(rowField);
        sizeFrame.add(colLabel);
        sizeFrame.add(colField);
        sizeFrame.add(new JLabel());
        sizeFrame.add(sizeButton);
        sizeButton.addActionListener(e -> {
            int rows = Integer.parseInt(rowField.getText());
            int cols = Integer.parseInt(colField.getText());
            showPlacementFrame(rows, cols);
        });
        
        sizeFrame.setVisible(true);
    }
    private void showPlacementFrame(int rows, int cols){
        // Placement Frame
        JFrame placementFrame = new JFrame("Sokoban Solver");
        placementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placementFrame.setSize(400, 300);
        String message = "<html><b>W = Wall, B = Block, P = Player, H = Hole, BH = Block and Hole, PH = Player and Hole<br>" +
                 "Make Sure to Press ENTER Key before clicking Submit</b></html>";
        JLabel instructions = new JLabel(message);
        JButton placementButton = new JButton("Submit");
        placementFrame.add(instructions, BorderLayout.NORTH);
        JTable table = new JTable(rows, cols);
        placementFrame.add(new JScrollPane(table), BorderLayout.CENTER);
        placementFrame.add(placementButton, BorderLayout.SOUTH);
        placementButton.addActionListener(e -> {
            String[][] array = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Object value = table.getValueAt(i, j);
                    array[i][j] = value != null ? value.toString() : "";
                }
            }
            System.out.println(Arrays.toString(array[0]));
            grid = array;
            fillGrid();
            placementFrame.dispose();
        });
        placementFrame.setVisible(true);
    }
    private void fillGrid(){
        int m = grid.length;
        int n = grid[0].length;
        int[][] g = new int[m+2][n+2];
        String player = "";
        String blocks = "";
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                String s = grid[r][c].toLowerCase();
                switch(s){
                    case "w":
                        g[r+1][c+1] = 1;
                        break;
                    case "b":
                        blocks = blocks + "" + Integer.toString(r+1, 36) + "" + Integer.toString(c+1, 36);
                        break;
                    case "p":
                        if(player.length() > 0) {
                            JOptionPane.showMessageDialog(null, "Only 1 Player");
                            System.exit(1);
                        }
                        System.out.println("pre "+player);
                        player = "" + Integer.toString(r+1, 36) + "" + Integer.toString(c+1, 36);
                        System.out.println("post "+player);
                        break;
                    case "h":
                        g[r+1][c+1] = 2;
                        break;
                    case "bh":
                        blocks = blocks + "" + Integer.toString(r+1, 36) + "" + Integer.toString(c+1, 36);
                        g[r+1][c+1] = 2;
                        // handle block and hole
                        break;
                    case "ph":
                        g[r+1][c+1] = 2;
                        if(player.length() > 0) {
                            JOptionPane.showMessageDialog(null, "Only 1 Player");
                            System.exit(1);
                        }
                        player = "" + Integer.toString(r+1, 36) + "" + Integer.toString(c+1, 36);
                        break;
                    case "":
                        g[r+1][c+1] = 0; // empty space
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Input");
                        System.exit(1);
                        break;
                }
            }
        }
        Arrays.fill(g[0], 1);
        Arrays.fill(g[n+1], 1);
        for(int i = 1; i <= m; i++){
            g[i][0] = 1;
            g[i][n+1] = 1;
        }
        solveGame(g, player, blocks);
    }
    public void solveGame(int[][] g, String player, String blocks) {
        for(int[] row : g) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(player + " | " + blocks);
        System.out.println("hey");
        SolverObject solver = new SolverObject(g, player + "" + blocks);
        solver.startSearching();
    }
}
