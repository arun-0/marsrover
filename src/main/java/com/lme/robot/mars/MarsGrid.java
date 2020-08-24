package com.lme.robot.mars;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MarsGrid {
    private Grid maxGrid;
    private Set<Grid> scentedGrids = new HashSet<>();

    public MarsGrid(int x, int y) {
        this.maxGrid = new Grid(x, y);
    }

    public int getMaxX() {
        return maxGrid.getX();
    }

    public int getMaxY() {
        return maxGrid.getY();
    }

    public void addScentedGrid(int x, int y) {
        scentedGrids.add(new Grid(x, y));
    }

    public boolean isScented(int x, int y) {
        return scentedGrids.contains(new Grid(x, y));
    }

    class Grid {
        private int x;
        private int y;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Grid grid = (Grid) o;
            return x == grid.x &&
                    y == grid.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
