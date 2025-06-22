import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class SolverFullBfs{
    static int minMoves = Integer.MAX_VALUE;
    static Set<String> visited = new HashSet<>();
    static Boolean possible = false;
    static String finalMoves = "";
    static int[] dirs = {0, 1, 0, -1, 0};
    static Queue<String[]> q = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {
        // // MathIsFun Sokoban Level 2
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 1}
        // , {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1}
        // , {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 2, 2, 1}
        // , {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // };
        // visited.add("8c254537487275");
        // q.offer(new String[]{"8c254537487275", ""});
        // MathIsFun Sokoban Level 17
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1}
        // , {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}
        // , {1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1}
        // , {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1}
        // , {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 2, 1}
        // , {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 2, 1}
        // , {1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 1, 1, 2, 1}
        // , {1, 1, 1, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1}
        // , {1, 1, 1, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1}
        // , {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        // };
        // visited.add("5343443246564a6a6873858897a9b4b5");
        // q.offer(new String[]{"5343443246564a6a6873858897a9b4b5", ""});

        // level 2 https://cariboutests.com/games/sokoban.php
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 0, 0, 0, 1, 1, 1, 1, 1}
        // , {1, 0, 1, 0, 0, 0, 0, 0, 1}
        // , {1, 0, 2, 2, 1, 0, 0, 0, 1}
        // , {1, 1, 0, 2, 0, 0, 0, 1, 1}
        // , {1, 1, 0, 0, 1, 0, 0, 1, 1}
        // , {1, 1, 1, 1, 1, 1, 1, 1, 1}
        
        // };
        // visited.add("56452426");
        // q.offer(new String[]{"56452426", ""});
        // /level 2 brain break
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1, 1, 1}
        // , {1, 1, 1, 0, 0, 1, 1, 1}
        // , {1, 1, 1, 0, 0, 1, 1, 1}
        // , {1, 0, 0, 2, 2, 0, 0, 1}
        // , {1, 0, 0, 0, 0, 0, 0, 1}
        // , {1, 1, 1, 1, 1, 1, 1, 1}
        // };
        // visited.add("313233");
        // q.offer(new String[]{"313233", ""});
        // brain break level 14
        int[][] g = {
          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
        , {1, 0, 0, 0, 1, 0, 0, 1, 1, 1,}
        , {1, 0, 0, 0, 0, 0, 0, 0, 1, 1,}
        , {1, 1, 0, 1, 1, 2, 2, 0, 1, 1,}
        , {1, 1, 0, 1, 1, 0, 2, 0, 1, 1,}
        , {1, 1, 0, 2, 0, 1, 1, 0, 1, 1,}
        , {1, 1, 0, 0, 2, 1, 1, 0, 1, 1,}
        , {1, 1, 0, 0, 0, 0, 0, 0, 0, 1,}
        , {1, 1, 1, 0, 0, 1, 0, 0, 0, 1,}
        , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
        };

        visited.add("422437576275");
        q.offer(new String[]{"422437576275", ""});

        // brainbreak level 8
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
        // , {1, 2, 2, 0, 2, 0, 2, 0, 2, 2, 1,}
        // , {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,}
        // , {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1,}
        // , {1, 0, 0, 2, 1, 1, 1, 2, 0, 0, 1,}
        // , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
        // };
        // visited.add("252223242627283238");
        // q.offer(new String[]{"212223", ""});
        // reddit puzzle https://claude.ai/public/artifacts/496b056e-6247-4e21-8707-c2dbf43b33eb
        // int[][] g = {
        //   {1, 1, 1, 1, 1, 1}
        // , {1, 2, 0, 0, 1, 1}
        // , {1, 0, 0, 0, 0, 1}
        // , {1, 1, 0, 0, 0, 1}
        // , {1, 1, 1, 0, 0, 1}
        // , {1, 1, 1, 1, 2, 1}
        // , {1, 1, 1, 1, 1, 1}};
        // visited.add("212223");
        // q.offer(new String[]{"212223", ""});
        int attempts = 0;
        while(!q.isEmpty() && !possible){
            if(attempts++ % 10_000 == 0) System.out.println(attempts-1);;
            String[] locMove = q.poll();
            solve(g, locMove[0], locMove[1]);
        }
        
        System.out.println(possible);
        System.out.println(finalMoves);
        String englishMoves = convert();
        System.out.println(englishMoves);
        System.out.println(visited.size());
        keyPresser(englishMoves);
        // }
    }
    public static void solve(int[][] g, String locations, String moves) {
        // System.out.println("Moves made " + moves.length() /2);
        // System.out.println("-----" + locations + "------");
        char[] loc = locations.toCharArray();
        int r = Integer.parseInt(loc[0] + "", 36), c = Integer.parseInt(loc[1] + "", 36);
        int puzzlesFinished = 0;
        for(int i = 2; i < loc.length; i+=2){
            // if(i >= loc.length - 6) System.out.println(i);
            if(g[Integer.parseInt(loc[i]+"",36)][Integer.parseInt(loc[i+1]+"",36)] == 2){
                puzzlesFinished++;
                // if(puzzlesFinished > 8) System.out.println("in place " + puzzlesFinished + " " + locations);
            }
        }
        if(puzzlesFinished == locations.length()/2 - 1){
            possible = true;
            // System.out.println("Found in " + moves.length()/2 + " moves");
            q = new LinkedList<>();
            minMoves = moves.length() / 2;
            finalMoves = moves;
            return;
        }
        outer:
        for(int i = 0; i < 4; i++){
            String newMoves = moves + "" + (dirs[i]+1) + "" + (dirs[i+1]+1);
            // if(dirs[i] == 0){
            //     if(dirs[i+1] == 1) System.out.println("Moving right");
            //     else System.out.println("Moving Left");
            // }
            // else{
            //     if(dirs[i] == 1) System.out.println("Moving down");
            //     else System.out.println("Moving up");
            // }
            int nr = r + dirs[i];
            int nc = c + dirs[i+1];
            // System.out.println("Moves made " + movesMade);
            // System.out.println("new row, new col " + nr + " " + nc);
            if(g[nr][nc] == 1){
                // System.out.println("continue");
                continue;
            }
            for(int j = 2; j < loc.length; j+=2){
                if((nr + '0' == loc[j] && nc + '0' == loc[j+1])){
                    // System.out.println("Obstacle next to player!");
                    int fr = nr + dirs[i];
                    int fc = nc + dirs[i+1];
                    // System.out.println("Furthest row, furthest col " + fr + " " + fc);
                    for(int k = 2; k < loc.length; k+=2){
                        if((Integer.parseInt(loc[k]+"",36) == fr && Integer.parseInt(loc[k+1]+"",36) == fc)){
                            // System.out.println("ball behind another ball, continue");
                            continue outer;
                        }
                    }
                    // System.out.println("further row, futher col " + fr + " " + fc);
                    if(g[fr][fc] == 2 || (g[fr][fc] == 0 && (g[fr][fc+1] != 1 || (g[fr-1][fc] != 1 && g[fr+1][fc] != 1)) && (g[fr][fc-1] != 1 || (g[fr+1][fc] != 1 && g[fr-1][fc] != 1)))){
                        char[] s = locations.toCharArray();
                        s[0] = Integer.toString(nr, 36).charAt(0);
                        s[1] = Integer.toString(nc, 36).charAt(0);
                        // for(int k = 2; k < loc.length; k+=2){
                        //     if(nr + '0' == loc[k] && nc + '0' == loc[k+1]){
                        s[j] = Integer.toString(fr, 36).charAt(0);
                        s[j+1] = Integer.toString(fc, 36).charAt(0);
                        //     }
                        // }
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
    public static String convert(){
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
    public static void keyPresser(String moves) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 to start");
        if(sc.nextInt() != 1) return;
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Starting in 5 seconds");
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
