import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class SolverObject{
    int minMoves = Integer.MAX_VALUE;
    Set<String> visited = new HashSet<>();
    Boolean possible = false;
    String finalMoves = "";
    int[] dirs = {0, 1, 0, -1, 0};
    Queue<String[]> q = new LinkedList<>();
    int[][] g;

    public SolverObject(int[][] g, String loc) {
        this.g = g;
        visited.add(loc);
        q.offer(new String[]{loc, ""});
    }
    public void startSearching(){
        while(!q.isEmpty() && !possible){
            String[] locMove = q.poll();
            solve(locMove[0], locMove[1]);
        }
        if(possible){
            System.out.println("Found solution in " + minMoves + " moves");
            String moveKeys = convert();
            System.out.println("Moves: " + moveKeys);
        }
        else{
            System.out.println("No solution found");
        }
    }
    public void solve(String locations, String moves) {
        char[] loc = locations.toCharArray();
        int r = Integer.parseInt(loc[0] + "", 36), c = Integer.parseInt(loc[1] + "", 36);
        int puzzlesFinished = 0;
        for(int i = 2; i < loc.length; i+=2){
            if(g[Integer.parseInt(loc[i]+"",36)][Integer.parseInt(loc[i+1]+"",36)] == 2){
                puzzlesFinished++;
            }
        }
        if(puzzlesFinished == locations.length()/2 - 1){
            possible = true;
            q = new LinkedList<>();
            minMoves = moves.length() / 2;
            finalMoves = moves;
            return;
        }
        outer:
        for(int i = 0; i < 4; i++){
            String newMoves = moves + "" + (dirs[i]+1) + "" + (dirs[i+1]+1);
            int nr = r + dirs[i];
            int nc = c + dirs[i+1];
            if(g[nr][nc] == 1){
                continue;
            }
            for(int j = 2; j < loc.length; j+=2){
                if((nr + '0' == loc[j] && nc + '0' == loc[j+1])){
                    int fr = nr + dirs[i];
                    int fc = nc + dirs[i+1];
                    for(int k = 2; k < loc.length; k+=2){
                        if((Integer.parseInt(loc[k]+"",36) == fr && Integer.parseInt(loc[k+1]+"",36) == fc)){
                            continue outer;
                        }
                    }
                    if(g[fr][fc] == 2 || (g[fr][fc] == 0 && (g[fr][fc+1] != 1 || (g[fr-1][fc] != 1 && g[fr+1][fc] != 1)) && (g[fr][fc-1] != 1 || (g[fr+1][fc] != 1 && g[fr-1][fc] != 1)))){
                        char[] s = locations.toCharArray();
                        s[0] = Integer.toString(nr, 36).charAt(0);
                        s[1] = Integer.toString(nc, 36).charAt(0);
                        s[j] = Integer.toString(fr, 36).charAt(0);
                        s[j+1] = Integer.toString(fc, 36).charAt(0);
                        String curLocation = new String(s);
                        if((!visited.contains(curLocation))){
                            visited.add(curLocation);
                            q.offer(new String[]{curLocation, newMoves});
                        }
                    }
                    continue outer;
                }
            }
            if(g[nr][nc] == 0 || g[nr][nc] == 2){
                char[] s = locations.toCharArray();
                s[0] = Integer.toString(nr, 36).charAt(0);
                s[1] = Integer.toString(nc, 36).charAt(0);
                String curLocation = new String(s);
                if((!visited.contains(curLocation))){
                    visited.add(curLocation);
                    q.offer(new String[]{curLocation, newMoves});
                }
            }
        }
    }
    public String convert(){
        char[] s = finalMoves.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i+=2){
            if(s[i] != '1'){
                if(s[i] == '2') sb.append("S");
                else sb.append("W");
            }
            else{
                if(s[i+1] == '2')  sb.append("D");
                else sb.append("A");
            }
        }
        return sb.toString();
    }
    public void keyPresser(String moves) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() != 1) return;
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(5000);
        
        char[] s = moves.toCharArray();
        try {
            Robot robot = new Robot();
            for(char c : s){
                System.out.println(minMoves-- + " moves left");
                robot.delay(350); // 0.35 seconds
                switch(c){
                    case 'W' -> {
                        robot.keyPress(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_UP);
                    }
                case 'A' -> {
                    robot.keyPress(KeyEvent.VK_LEFT);
                    robot.keyRelease(KeyEvent.VK_LEFT);
                    }
                case 'S' -> {
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    }
                case 'D' -> {
                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);
                    }
                default -> System.out.println("Unsupported key: " + c);
                }
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
        keyPresser(moves);
    }
}
