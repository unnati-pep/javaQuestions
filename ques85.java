//MinesweeperGame

import java.util.*;

class Cell {
    boolean isMine;
    boolean isRevealed;
    int neighborMines;

    public Cell() {
        isMine = false;
        isRevealed = false;
        neighborMines = 0;
    }

    @Override
    public String toString() {
        if (!isRevealed) return "[ ]";
        if (isMine) return "[*]";
        return neighborMines == 0 ? "[ ]" : "[" + neighborMines + "]";
    }
}

class Board {
    private int rows;
    private int cols;
    private int totalMines;
    private Cell[][] grid;
    private boolean gameOver = false;

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.totalMines = mines;
        this.grid = new Cell[rows][cols];
        initBoard();
    }

    private void initBoard() {
        // Create empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }

        // Place mines randomly
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < totalMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!grid[r][c].isMine) {
                grid[r][c].isMine = true;
                placedMines++;
            }
        }

        // Calculate neighbor mine counts
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!grid[i][j].isMine) {
                    grid[i][j].neighborMines = countNeighborMines(i, j);
                }
            }
        }
    }

    private int countNeighborMines(int r, int c) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (isValidCell(i, j) && grid[i][j].isMine) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValidCell(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void revealCell(int r, int c) {
        if (!isValidCell(r, c) || grid[r][c].isRevealed) {
            System.out.println("Invalid or already revealed cell.");
            return;
        }

        grid[r][c].isRevealed = true;

        if (grid[r][c].isMine) {
            gameOver = true;
            revealAllMines();
            System.out.println("💥 You hit a mine! Game Over.");
        } else if (grid[r][c].neighborMines == 0) {
            // Auto-reveal surrounding cells
            for (int i = r - 1; i <= r + 1; i++) {
                for (int j = c - 1; j <= c + 1; j++) {
                    if (isValidCell(i, j) && !grid[i][j].isRevealed) {
                        revealCell(i, j);
                    }
                }
            }
        }
    }

    public void revealAllMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isMine) {
                    grid[i][j].isRevealed = true;
                }
            }
        }
    }

    public boolean hasWon() {
        int revealed = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isRevealed) {
                    revealed++;
                }
            }
        }
        return revealed == (rows * cols - totalMines);
    }

    public void printBoard() {
        System.out.print("   ");
        for (int j = 0; j < cols; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}

public class ques85 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 8;
        int cols = 8;
        int mines = 10;

        Board board = new Board(rows, cols, mines);
        System.out.println("🧨 Welcome to Minesweeper!");
        board.printBoard();

        while (!board.isGameOver()) {
            System.out.print("\nEnter row: ");
            int r = scanner.nextInt();
            System.out.print("Enter column: ");
            int c = scanner.nextInt();

            board.revealCell(r, c);
            board.printBoard();

            if (board.hasWon()) {
                System.out.println("🎉 Congratulations! You cleared the minefield!");
                break;
            }
        }

        scanner.close();
    }
}
