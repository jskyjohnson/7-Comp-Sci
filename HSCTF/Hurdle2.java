/**
 * Created with IntelliJ IDEA.
 * User: Jackson
 * Date: 5/19/15
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.*;

public class Hurdle2 {

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("track_star_testtest.txt"));
        String firstLine = f.readLine();
        String[] firstTokens = firstLine.split(" ");
        int rows = Integer.parseInt(firstTokens[0]);
        int lanes = Integer.parseInt(firstTokens[1]);
        int hurdles = Integer.parseInt(firstTokens[2]);

        Square[][] track = new Square[rows][lanes];
        for (int i = 0; i < hurdles; i++) {
            String line = f.readLine();
            String[] tokens = line.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int lane = Integer.parseInt(tokens[1]);
            Square s = new Square(row, lane, true);
            track[row][lane] = s;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lanes; j++) {
                if (track[i][j] == null) {
                    Square s = new Square(i, j, false);
                    track[i][j] = s;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < lanes; j++) {
                if (!track[i][j].hurdlePresent) {
                    addChildren(rows, lanes, track[i][j], track);
                    if (track[i][j].children.size() == 0 && (i != rows - 1)) {
                        track[i][j].hurdlePresent = true;
                    }
                }
            }

        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < lanes; j++) {
                if (!track[i][j].hurdlePresent) {
                    setTime(rows, lanes, track[i][j], track);
                }
            }

        }

        //        for (int i = 0; i < rows; i++) {
        //            System.out.println("[");
        //            for (int j = 0; j < lanes; j++) {
        //                System.out.print(track[i][j].hurdlePresent + " " + track[i][j].minTime + ",");
        //            }
        //            System.out.print("]");
        //        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < lanes; i++) {
            if (!track[0][i].hurdlePresent && track[0][i].minTime < min) {
                min = track[0][i].minTime;
            }
        }
        System.out.println(min);
    }

    public static void setTime(int rows, int lanes, Square parent, Square[][] map) {
        if (parent.row == rows - 1) {
            return;
        }
        else {
            long time = Integer.MAX_VALUE;
            for (Square child : parent.children) {
                if (child.lane != parent.lane) {
                    if (child.minTime + 1 < time) {
                        time = child.minTime + 1;
                    }
                }
                else {
                    if (child.minTime < time) {
                        time = child.minTime;
                    }
                }
            }
            parent.minTime = time;
            if (map[parent.row + 1][parent.lane].hurdlePresent) {
                parent.minTime++;
            }
        }
    }

    public static void addChildren(int rows, int lanes, Square parent, Square[][] map) {
        if (parent.row == rows - 1) {
            return;
        }
        if (parent.lane == 0) {
            if (!map[parent.row + 1][parent.lane].hurdlePresent){
                Square child = map[parent.row + 1][parent.lane];
                parent.children.add(child);
            }
            if (!map[parent.row + 1][parent.lane + 1].hurdlePresent) {
                Square child = map[parent.row + 1][parent.lane + 1];
                parent.children.add(child);
            }
        }
        else if (parent.lane == lanes - 1) {
            if (!map[parent.row + 1][parent.lane].hurdlePresent){
                Square child = map[parent.row + 1][parent.lane];
                parent.children.add(child);
            }
            if (!map[parent.row + 1][parent.lane - 1].hurdlePresent) {
                Square child = map[parent.row + 1][parent.lane - 1];
                parent.children.add(child);
            }
        }
        else {
            if (!map[parent.row + 1][parent.lane].hurdlePresent){
                Square child = map[parent.row + 1][parent.lane];
                parent.children.add(child);
            }
            if (!map[parent.row + 1][parent.lane - 1].hurdlePresent) {
                Square child = map[parent.row + 1][parent.lane - 1];
                parent.children.add(child);
            }
            if (!map[parent.row + 1][parent.lane + 1].hurdlePresent) {
                Square child = map[parent.row + 1][parent.lane + 1];
                parent.children.add(child);
            }
        }
    }

    private static class Square {
        private int row;
        private int lane;
        private boolean hurdlePresent;
        private long minTime;
        private List<Square> children;

        public Square(int row, int lane, boolean hurdlePresent) {
            this.row = row;
            this.lane = lane;
            this.hurdlePresent = hurdlePresent;
            this.children = new ArrayList<Square>();
            this.minTime = 0;
        }
    }
}