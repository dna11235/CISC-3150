// Nikita Dmitriev - Homework 4 - N-Queens Problem
// Run command: java NQueensProblem | tee HW4-Output.txt
// Reference: https://developers.google.com/optimization/puzzles/queens

import java.util.*;

class GameBoard{
    private int[][] coords;
    private int limit;
    private int solutions = 0;
    private int attempts = 0;

    GameBoard(int n){
        coords = new int[n][n];
        limit = n;
        resetBoard();
    }

    void resetBoard(){
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                coords[i][j] = 0;
            }
        }
    }

    void setQueen(int row, int col){
        coords[row][col] = 1;
    }
    void resetCell(int row, int col){
        coords[row][col] = 0;
    }

    int getCoord(int row, int col){
        return coords[row][col];
    }
    int getSolutions(){
        return solutions;
    }
    int getAttempts(){
        return attempts;
    }

    void printBoard(){
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                System.out.printf("%2d", coords[i][j]);
            }
            System.out.println();
        }
    }

    // For testing and coordination purposes.
    void printBoardCoordinates(){
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                System.out.printf("[%d,%d] ", i, j);
            }
            System.out.println();
        }
    }

    // Master call to check if cell is safe
    boolean checkDanger(int row, int col){
        return  checkHorizontal(row) &&
                checkVertical(col) &&
                checkDiagLeft(row, col);
    }

    // Check row for danger
    boolean checkHorizontal(int row){
        for (int i = 0; i<limit; i++){
            if (coords[row][i] == 1){
                return false;
            }
        }
        return true;
    }

    // Check column for danger
    boolean checkVertical(int col){
        for (int i = 0; i<limit; i++){
            if (coords[i][col] == 1){
                return false;
            }
        }
        return true;
    }
    // Check if there is danger on the left.
    // We are moving to the right, so nothing on the right yet.
    boolean checkDiagLeft(int row, int col){
        int i, j;
        for (i = row, j = col; i >= 0 && j >= 0; i-- , j--) {
            if (getCoord(i, j) == 1){
                return false;
            }
        }
        for (i = row, j = col ; i < limit && j >= 0; i++ , j--) {
            if (getCoord(i, j) == 1){
                return false;
            }
        }
        return true;
    }

    // Recursive solver with backtrack.
    // Is it even possible to find ALL solutions without backtrack?
    boolean solveGame(int col){
        if (col >= limit){
            return true;
        }
        for (int i=0;i<limit;i++){
            if (checkDanger(i, col)){
                setQueen(i,col);
                attempts++;
                if (solveGame(col+1)){
                    solutions++;
                    System.out.println("Solution: "+getSolutions());
                    printBoard();
                }
                resetCell(i, col);
            }
        }
        return false;
    }
}

public class NQueensProblem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("N-Queens Problem. Please enter number of Queens: ");
        n = Integer.parseInt(input.next());
        System.out.println("User input: "+n);

        GameBoard board = new GameBoard(n);

        board.solveGame(0);

        System.out.println("Total Solutions: "+board.getSolutions());
        System.out.println("Total attempts: "+board.getAttempts());
    }
}
