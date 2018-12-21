/**
 * Name: John Koga
 * Pennkey: johnkoga
 * Recitation: 205
 * 
 * File name: Twenty48.java
 * Execution: java Twenty48
 * Descrpition: Creates our 2048 game
 * and implements many different functions
 * to do so. Blood, sweat, and tears
 * were poured into this game and
 * to debug especially.
 * 
 */
public class Twenty48 {
    
    /* creates a boolean double array saying which
     * positions on the board are filled
     */
    
    public static boolean[][] isFilled(Tiles[][] tilearr) {
        boolean[][] isFilled = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tilearr[i][j].getValue() == 0) {
                    isFilled[i][j] = false;
                } else {
                    isFilled[i][j] = true;
                }
            }
        }
        return isFilled;
    }
    
    /*
     * moves all spaces up
     */
    
    public static void moveUp(Tiles[][] tilearr, Tiles tile, boolean[][] isFilled) {
        if (tile.getValue() == 0) {
            return;
        } else if (tile.getPosY() == 0) {
            return;
        } else if (tile.getPosY() == 1) {
            if (isFilled[0][tile.getPosX()]) {
                return;
            } else {
                tile.up();
                tilearr[0][tile.getPosX()] = tile;
                tilearr[1][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosY() == 2) {
            if (isFilled[0][tile.getPosX()] && isFilled[1][tile.getPosX()]) {
                return;
            } else if (isFilled[0][tile.getPosX()]) {
                tile.up();
                tilearr[1][tile.getPosX()] = tile;
                tilearr[2][tile.getPosX()] = new Tiles(0, 0, 0);
            } else {
                tile.up();
                tile.up();
                tilearr[0][tile.getPosX()] = tile;
                tilearr[2][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosY() == 3) {
            if (isFilled[0][tile.getPosX()] && isFilled[1][tile.getPosX()] && 
                isFilled[2][tile.getPosX()]) {
                return;
            } else if (isFilled[0][tile.getPosX()] && isFilled[1][tile.getPosX()]) {
                tile.up();
                tilearr[2][tile.getPosX()] = tile;
                tilearr[3][tile.getPosX()] = new Tiles(0, 0, 0);
            } else if (isFilled[0][tile.getPosX()]) {
                tile.up();
                tile.up();
                tilearr[1][tile.getPosX()] = tile;
                tilearr[3][tile.getPosX()] = new Tiles(0, 0, 0);
            } else {
                tile.up();
                tile.up();
                tile.up();
                tilearr[0][tile.getPosX()] = tile;
                tilearr[3][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        }
    }
    
    /*
     * moves all spaces down that should be moved down
     */
    
    public static void moveDown(Tiles[][] tilearr, Tiles tile, 
                                boolean[][] isFilled) {
        if (tile.getValue() == 0) {
            return;
        } else if (tile.getPosY() == 3) {
            return;
        } else if (tile.getPosY() == 2) {
            if (isFilled[3][tile.getPosX()]) {
                return;
            } else {
                tile.down();
                tilearr[3][tile.getPosX()] = tile;
                tilearr[2][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosY() == 1) {
            if (isFilled[3][tile.getPosX()] && isFilled[2][tile.getPosX()]) {
                return;
            } else if (isFilled[3][tile.getPosX()]) {
                tile.down();
                tilearr[2][tile.getPosX()] = tile;
                tilearr[1][tile.getPosX()] = new Tiles(0, 0, 0);
            } else {
                tile.down();
                tile.down();
                tilearr[3][tile.getPosX()] = tile;
                tilearr[1][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosY() == 0) {
            if (isFilled[3][tile.getPosX()] && isFilled[2][tile.getPosX()] &&
                isFilled[1][tile.getPosX()]) {
                return;
            } else if (isFilled[3][tile.getPosX()] && isFilled[2][tile.getPosX()]) {
                tile.down();
                tilearr[1][tile.getPosX()] = tile;
                tilearr[0][tile.getPosX()] = new Tiles(0, 0, 0);
            } else if (isFilled[3][tile.getPosX()]) {
                tile.down();
                tile.down();
                tilearr[2][tile.getPosX()] = tile;
                tilearr[0][tile.getPosX()] = new Tiles(0, 0, 0);
            } else {
                tile.down();
                tile.down();
                tile.down();
                tilearr[3][tile.getPosX()] = tile;
                tilearr[0][tile.getPosX()] = new Tiles(0, 0, 0);
            }
        }
    }
    
    /*
     * moves all spaces left that should be moved left
     */
    
    public static void moveLeft(Tiles[][] tilearr, Tiles tile, 
                                boolean[][] isFilled) {
        if (tile.getValue() == 0) {
            return;
        } else if (tile.getPosX() == 0) {
            return;
        } else if (tile.getPosX() == 1) {
            if (isFilled[tile.getPosY()][0]) {
                return;
            } else {
                tile.left();
                tilearr[tile.getPosY()][0] = tile;
                tilearr[tile.getPosY()][1] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosX() == 2) {
            if (isFilled[tile.getPosY()][0] && isFilled[tile.getPosY()][1]) {
                return;
            } else if (isFilled[tile.getPosY()][0]) {
                tile.left();
                tilearr[tile.getPosY()][1] = tile;
                tilearr[tile.getPosY()][2] = new Tiles(0, 0, 0);
            } else {
                tile.left();
                tile.left();
                tilearr[tile.getPosY()][0] = tile;
                tilearr[tile.getPosY()][2] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosX() == 3) {
            if (isFilled[tile.getPosY()][0] && isFilled[tile.getPosY()][1] &&
                isFilled[tile.getPosY()][2]) {
                return;
            } else if (isFilled[tile.getPosY()][0] && isFilled[tile.getPosY()][1]) {
                tile.left();
                tilearr[tile.getPosY()][2] = tile;
                tilearr[tile.getPosY()][3] = new Tiles(0, 0, 0);
            } else if (isFilled[tile.getPosY()][0]) {
                tile.left();
                tile.left();
                tilearr[tile.getPosY()][1] = tile;
                tilearr[tile.getPosY()][3] = new Tiles(0, 0, 0);
            } else {
                tile.left();
                tile.left();
                tile.left();
                tilearr[tile.getPosY()][0] = tile;
                tilearr[tile.getPosY()][3] = new Tiles(0, 0, 0);
            }
        }
    }
    
    /*
     * moves all spaces right in double array that should be moved right
     */
    
    public static void moveRight(Tiles[][] tilearr, Tiles tile, 
                                 boolean[][] isFilled) {
        if (tile.getValue() == 0) {
            return;
        } else if (tile.getPosX() == 3) {
            return;
        } else if (tile.getPosX() == 2) {
            if (isFilled[tile.getPosY()][3]) {
                return;
            } else {
                tile.right();
                tilearr[tile.getPosY()][3] = tile;
                tilearr[tile.getPosY()][2] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosX() == 1) {
            if (isFilled[tile.getPosY()][3] && isFilled[tile.getPosY()][2]) {
                return;
            } else if (isFilled[tile.getPosY()][3]) {
                tile.right();
                tilearr[tile.getPosY()][2] = tile;
                tilearr[tile.getPosY()][1] = new Tiles(0, 0, 0);
            } else {
                tile.right();
                tile.right();
                tilearr[tile.getPosY()][3] = tile;
                tilearr[tile.getPosY()][1] = new Tiles(0, 0, 0);
            }
        } else if (tile.getPosX() == 0) {
            if (isFilled[tile.getPosY()][3] && 
                isFilled[tile.getPosY()][2] &&
                isFilled[tile.getPosY()][1]) {
                return;
            } else if (isFilled[tile.getPosY()][3] && isFilled[tile.getPosY()][2]) {
                tile.right();
                tilearr[tile.getPosY()][1] = tile;
                tilearr[tile.getPosY()][0] = new Tiles(0, 0, 0);
            } else if (isFilled[tile.getPosY()][3]) {
                tile.right();
                tile.right();
                tilearr[tile.getPosY()][2] = tile;
                tilearr[tile.getPosY()][0] = new Tiles(0, 0, 0);
            } else {
                tile.right();
                tile.right();
                tile.right();
                tilearr[tile.getPosY()][3] = tile;
                tilearr[tile.getPosY()][0] = new Tiles(0, 0, 0);
            }
        }
    }
    
    /*
     * merges eligible tiles up
     */
    
    public static void mergeUp(Tiles[][] tilearr) {
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (tilearr[i - 1][j].getValue() == tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    tilearr[i - 1][j].setValue(tilearr[i - 1][j].getValue() * 2);
                    tilearr[i][j] = new Tiles(0, 0, 0);
                    if (i == 1) {
                        if (tilearr[3][j].getValue() == 
                            tilearr[2][j].getValue() && 
                            tilearr[3][j].getValue() != 0) {
                            tilearr[2][j].setValue(tilearr[2][j].getValue() * 2);
                            tilearr[2][j].up();
                            tilearr[i][j] = tilearr[2][j];
                            tilearr[2][j] = new Tiles(0, 0, 0);
                            tilearr[3][j] = new Tiles(0, 0, 0);
                        } else {
                            tilearr[2][j].up();
                            tilearr[i][j] = tilearr[2][j];
                            tilearr[3][j].up();
                            if (tilearr[2][j].getValue() == 0) {
                                tilearr[3][j].up();
                                tilearr[1][j] = tilearr[3][j];
                                tilearr[2][j] = new Tiles(0, 0, 0);
                                tilearr[3][j] = new Tiles(0, 0, 0);
                            } else {
                                tilearr[2][j] = tilearr[3][j];
                                tilearr[3][j] = new Tiles(0, 0, 0);
                            }
                        }
                        
                    } else if (i == 2) {
                        tilearr[3][j].up();
                        tilearr[2][j] = tilearr[3][j];
                        tilearr[3][j] = new Tiles(0, 0, 0);
                        
                    }
                }
            }
        }
    }
    
    /*
     * merges elegible tiles down
     */
    
    public static void mergeDown(Tiles[][] tilearr) {
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (tilearr[i + 1][j].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    tilearr[i + 1][j].setValue(tilearr[i + 1][j].getValue() * 2);
                    tilearr[i][j] = new Tiles(0, 0, 0);
                    if (i == 2) {
                        if (tilearr[0][j].getValue() == 
                            tilearr[1][j].getValue() &&
                            tilearr[0][j].getValue() != 0) {
                            tilearr[1][j].setValue(tilearr[1][j].getValue() * 2);
                            tilearr[1][j].down();
                            tilearr[i][j] = tilearr[1][j];
                            tilearr[1][j] = new Tiles(0, 0, 0);
                            tilearr[0][j] = new Tiles(0, 0, 0);
                        } else {
                            tilearr[1][j].down();
                            tilearr[i][j] = tilearr[1][j];
                            tilearr[0][j].down();
                            if (tilearr[1][j].getValue() == 0) {
                                tilearr[0][j].down();
                                tilearr[2][j] = tilearr[0][j];
                                tilearr[1][j] = new Tiles(0, 0, 0);
                                tilearr[0][j] = new Tiles(0, 0, 0);
                            } else {
                                tilearr[1][j] = tilearr[0][j];
                                tilearr[0][j] = new Tiles(0, 0, 0);
                            }
                            
                        }
                    } else if (i == 1) {
                        tilearr[0][j].down();
                        tilearr[1][j] = tilearr[0][j];
                        tilearr[0][j] = new Tiles(0, 0, 0);
                        
                        
                    }
                }
            }
        }
    }
    
    /*
     * merges elegible tiles left
     */
    
    public static void mergeLeft(Tiles[][] tilearr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (tilearr[i][j - 1].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    tilearr[i][j - 1].setValue(tilearr[i][j - 1].getValue() * 2);
                    tilearr[i][j] = new Tiles(0, 0, 0);
                    if (j == 1) {
                        if (tilearr[i][3].getValue() == 
                            tilearr[i][2].getValue() && 
                            tilearr[i][3].getValue() != 0) {
                            tilearr[i][2].setValue(tilearr[i][2].getValue() * 2);
                            tilearr[i][2].left();
                            tilearr[i][j] = tilearr[i][2];
                            tilearr[i][2] = new Tiles(0, 0, 0);
                            tilearr[i][3] = new Tiles(0, 0, 0);
                        } else {
                            tilearr[i][2].left();
                            tilearr[i][j] = tilearr[i][2];
                            tilearr[i][3].left();
                            if (tilearr[i][2].getValue() == 0) {
                                tilearr[i][3].left();
                                tilearr[i][1] = tilearr[i][3];
                                tilearr[i][2] = new Tiles(0, 0, 0);
                                tilearr[i][3] = new Tiles(0, 0, 0);
                            } else {
                                tilearr[i][2] = tilearr[i][3];
                                tilearr[i][3] = new Tiles(0, 0, 0);
                            }
                            
                            
                        }
                    } else if (j == 2) {
                        tilearr[i][3].left();
                        tilearr[i][2] = tilearr[i][3];
                        tilearr[i][3] = new Tiles(0, 0, 0);
                        
                        
                    }
                }
            }
        }
    }
    
    /*
     * merges elegible tiles Right
     */
    
    public static void mergeRight(Tiles[][] tilearr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (tilearr[i][j + 1].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    tilearr[i][j + 1].setValue(tilearr[i][j + 1].getValue() * 2);
                    tilearr[i][j] = new Tiles(0, 0, 0);
                    if (j == 2) {
                        if (tilearr[i][0].getValue() == 
                            tilearr[i][1].getValue() &&
                            tilearr[i][0].getValue() != 0) {
                            tilearr[i][1].setValue(tilearr[i][1].getValue() * 2);
                            tilearr[i][1].right();
                            tilearr[i][j] = tilearr[i][1];
                            tilearr[i][1] = new Tiles(0, 0, 0);
                            tilearr[i][0] = new Tiles(0, 0, 0);
                        } else {
                            tilearr[i][1].right();
                            tilearr[i][j] = tilearr[i][1];
                            tilearr[i][0].right();
                            if (tilearr[i][1].getValue() == 0) {
                                tilearr[i][0].right();
                                tilearr[i][2] = tilearr[i][0];
                                tilearr[i][1] = new Tiles(0, 0, 0);
                                tilearr[i][0] = new Tiles(0, 0, 0);
                            } else {
                                tilearr[i][1] = tilearr[i][0];
                                tilearr[i][0] = new Tiles(0, 0, 0);
                            }
                        }
                    } else if (j == 1) {
                        tilearr[i][0].right();
                        tilearr[i][1] = tilearr[i][0];
                        tilearr[i][0] = new Tiles(0, 0, 0);
                    }
                }
            }
        }
    }
    
    /*
     * tells us if there is at least one tile that can mergeup
     */
    
    public static boolean canMergeUp(Tiles[][] tilearr) {
        boolean canMergeUp = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (tilearr[i - 1][j].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    canMergeUp = true;
                }
            }
        }
        return canMergeUp;
    }
    
    /*
     * tells us if there is at least one tile that can merge down
     */
    
    public static boolean canMergeDown(Tiles[][] tilearr) {
        boolean canMergeDown = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (tilearr[i + 1][j].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    canMergeDown = true;
                }
            }
        }
        return canMergeDown;
    }
    
    /*
     * tells us if there is at least one tile that can Merge Left
     */
    
    public static boolean canMergeLeft(Tiles[][] tilearr) {
        boolean canMergeLeft = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (tilearr[i][j - 1].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    canMergeLeft = true;
                }
            }
        }
        return canMergeLeft;
    }
    
    /* 
     *  tells us if there is at least one tile that can Merge Right
     */
    
    public static boolean canMergeRight(Tiles[][] tilearr) {
        boolean canMergeRight = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (tilearr[i][j + 1].getValue() == 
                    tilearr[i][j].getValue() &&
                    tilearr[i][j].getValue() != 0) {
                    canMergeRight = true;
                }
            }
        }
        return canMergeRight;
    }
    
    /*
     * tells us if any tiles can move up
     */
    
    public static boolean canMoveUp(Tiles[][] tilearr) {
        boolean canMergeUp = canMergeUp(tilearr);
        boolean canMoveUp = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (tilearr[i - 1][j].getValue() == 0 && 
                    tilearr[i][j].getValue() != 0) {
                    canMoveUp = true;
                }
            }
        }
        if (canMergeUp) {
            canMoveUp = true;
        }
        
        return canMoveUp;
    }
    
    /*
     * tells us if any tiles can move down
     */
    
    public static boolean canMoveDown(Tiles[][] tilearr) {
        boolean canMergeDown = canMergeDown(tilearr);
        boolean canMoveDown = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (tilearr[i + 1][j].getValue() == 0 && 
                    tilearr[i][j].getValue() != 0) {
                    canMoveDown = true;
                }
            }
        }
        if (canMergeDown) {
            canMoveDown = true;
        }
        
        return canMoveDown;
    }
    /*
     * tells us if any tiles can move left
     */
    
    public static boolean canMoveLeft(Tiles[][] tilearr) {
        boolean canMergeLeft = canMergeLeft(tilearr);
        boolean canMoveLeft = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (tilearr[i][j - 1].getValue() == 0 && 
                    tilearr[i][j].getValue() != 0) {
                    canMoveLeft = true;
                }
            }
        }
        if (canMergeLeft) {
            canMoveLeft = true;
        }
        
        return canMoveLeft;
    }
    
    /*
     *  tells us if any tiles can move right
     */
    
    public static boolean canMoveRight(Tiles[][] tilearr) {
        boolean canMergeRight = canMergeRight(tilearr);
        boolean canMoveRight = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (tilearr[i][j + 1].getValue() == 0 && 
                    tilearr[i][j].getValue() != 0) {
                    canMoveRight = true;
                }
            }
        }
        if (canMergeRight) {
            canMoveRight = true;
        }
        
        return canMoveRight;
    }
    
    /*
     * function to pring out the current contents of the board
     * was extremely helpful for debugging
     */
    
    public static void printArray(Tiles[][] tilearr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tilearr[i][j].getPosY() + "," + 
                                 tilearr[i][j].getPosX() + " " +
                                 "value:" + 
                                 tilearr[i][j].getValue() + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    
    
    public static void main(String[] args) {
        boolean gameOver = false;
        boolean win = false;
        int moves = 0;
        
        //create our board
        PennDraw.setCanvasSize(400, 400);
        PennDraw.line(0, 0, 0, 1);
        PennDraw.line(0.25, 0, 0.25, 1);
        PennDraw.line(0.5, 0, 0.5, 1);
        PennDraw.line(0.75, 0, 0.75, 1);
        PennDraw.line(1, 0, 1, 0);
        PennDraw.line(0, 0, 1, 0);
        PennDraw.line(0, 0.25, 1, 0.25);
        PennDraw.line(0, 0.5, 1, 0.5);
        PennDraw.line(0, 0.75, 1, 0.75);
        PennDraw.line(0, 1, 1, 1);
        
        //Random generator for our initial tile
        int randomPosX = (int) (Math.random() * 4);
        int randomPosY = (int) (Math.random() * 4);
        double randomValuee = Math.random();
        int randomValue = 0;
        if (randomValuee < 0.5) {
            randomValue = 2;
        } else {
            randomValue = 4;
        }
        
        
        
        Tiles[][] tilearr = new Tiles[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tilearr[i][j] = new Tiles(0, 0, 0);
            }
        }
        
        
        Tiles placeholder1 = new Tiles(randomValue, randomPosX, randomPosY);
        tilearr[randomPosY][randomPosX] = placeholder1;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(tilearr[i][j].getValue() == 0)) {
                    tilearr[i][j].draw();
                }
            }
        }
        
        PennDraw.enableAnimation(30);
        
        printArray(tilearr);  
        while (!win || !gameOver) {
            
            // check if the user has typed a key; if so, process it   
            if (PennDraw.hasNextKeyTyped()) {
                //recreate board
                PennDraw.clear(PennDraw.WHITE);
                PennDraw.line(0, 0, 0, 1);
                PennDraw.line(0.25, 0, 0.25, 1);
                PennDraw.line(0.5, 0, 0.5, 1);
                PennDraw.line(0.75, 0, 0.75, 1);
                PennDraw.line(1, 0, 1, 0);
                PennDraw.line(0, 0, 1, 0);
                PennDraw.line(0, 0.25, 1, 0.25);
                PennDraw.line(0, 0.5, 1, 0.5);
                PennDraw.line(0, 0.75, 1, 0.75);
                PennDraw.line(0, 1, 1, 1);
                
                boolean createTile = false;
                
                char key = PennDraw.nextKeyTyped();  // which key was pressed?
                
                
                
                
                if (key == 'w' && canMoveUp(tilearr)) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            boolean[][] isFilledArray = isFilled(tilearr);
                            moveUp(tilearr, tilearr[i][j], isFilledArray);
                        }
                    }
                    
                    mergeUp(tilearr);
                    createTile = true;
                    moves++;
                } else if (key == 's' && canMoveDown(tilearr)) {
                    for (int i = 3; i >= 0; i--) {
                        for (int j = 0; j < 4; j++) {
                            boolean[][] isFilledArray = isFilled(tilearr);
                            moveDown(tilearr, tilearr[i][j], isFilledArray);
                        }
                    }
                    mergeDown(tilearr);
                    createTile = true;
                    moves++;
                }  else if (key == 'a' && canMoveLeft(tilearr)) {
                    for (int j = 0; j < 4; j++) {
                        for (int i = 0; i < 4; i++) {
                            boolean[][] isFilledArray = isFilled(tilearr);
                            moveLeft(tilearr, tilearr[i][j], isFilledArray);
                        }
                    }
                    mergeLeft(tilearr);
                    createTile = true;
                    moves++;
                }  else if (key == 'd' && canMoveRight(tilearr)) {
                    for (int j = 3; j >= 0; j--) {
                        for (int i = 0; i < 4; i++) {
                            boolean[][] isFilledArray = isFilled(tilearr);
                            moveRight(tilearr, tilearr[i][j], isFilledArray);
                        }
                    }
                    mergeRight(tilearr);
                    createTile = true;
                    moves++;
                }
                
                
                
                // we are adding a new Tile randomly here
                // in a space that that is empty (tile.value = 0)
                if (createTile) {
                    boolean spotFound = false;
                    while (!spotFound) {
                        int count = 0;
                        int randomPosition = (int) (16 * Math.random());
                        int randomValue2 = 0;
                        double randomValuee2 = Math.random();
                        if (randomValuee2 < 0.5) {
                            randomValue2 = 2;
                        } else {
                            randomValue2 = 4;
                        }
                        
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (tilearr[i][j].getValue() == 0) {
                                    count++;
                                    if (count == randomPosition) {
                                        Tiles placeholder = 
                                            new Tiles(randomValue2, j, i);
                                        tilearr[i][j] = placeholder;
                                        
                                        spotFound = true;
                                    }
                                }
                            }
                        }
                    }
                }
                
                
                // draw what is currently on the board
                
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (!(tilearr[i][j].getValue() == 0)) {
                            tilearr[i][j].draw();
                        }
                        
                    }
                }
                
                //did you lose
                if (!canMoveUp(tilearr) && !canMoveDown(tilearr) &&
                    !canMoveLeft(tilearr) && !canMoveRight(tilearr)) {
                    gameOver = true;
                    PennDraw.text(0.5, 0.5, "You lost!!");
                    PennDraw.text(0.5, 0.25, "moves: " + moves);
                }
                
                //did you win
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (tilearr[i][j].getValue() == 2048) {
                            win = true;
                            PennDraw.text(0.5, 0.5, "You win!!");
                            PennDraw.text(0.5, 0.25, "moves: " + moves);
                        }
                    }
                }
                
                printArray(tilearr);  
                PennDraw.advance();
                
            }   
            
        }
        PennDraw.disableAnimation();
        
        
        
    }
    
}




