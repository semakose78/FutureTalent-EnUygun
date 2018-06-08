package com.company;

public class FourtQuestion {
    private char[][] chessBoard;
    private int knightCount;

    public FourtQuestion() {
        chessBoard = new char[8][8];
        knightCount = 0;
        placeTheKnights();
    }

    private void placeTheKnights(){
        int start = 1;
        for (int i = 0; i <8 ; i++) {
            for (int j = start; j <8; j += 2) {
                chessBoard[i][j] = 'K';
                placeTheMoves(i, j);
            }
            if((i%2) == 0)
                start = 0;
            else
                start = 1;
        }
    }

    private void placeTheMoves(int i, int j){
        if(i-2 >= 0){
            if(j-1 >= 0)
                chessBoard[i-2][j-1] = '*';
            if(j+1 < 8)
                chessBoard[i-2][j+1] = '*';
        }
        if(j-2 >= 0){
            if(i-1 >= 0)
                chessBoard[i-1][j-2] = '*';
            if(i+1 < 8)
                chessBoard[i+1][j-2] = '*';
        }
        if(i+2 < 8){
            if(j-1 >= 0)
                chessBoard[i+2][j-1] = '*';
            if(j+1 < 8)
                chessBoard[i+2][j+1] = '*';
        }
        if(j+2 < 8){
            if(i-1 >= 0)
                chessBoard[i-1][j+2] = '*';
            if(i+1 < 8)
                chessBoard[i+1][j+2] = '*';
        }
    }

    public void printTheBoard(){
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    private void knightCount(){
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8; j++) {
                if(chessBoard[i][j] == 'K')
                    ++knightCount;
            }
        }
    }

    public int getKnightCount(){
        knightCount();
        return knightCount;
    }
}
