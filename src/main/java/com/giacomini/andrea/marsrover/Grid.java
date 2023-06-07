package com.giacomini.andrea.marsrover;

public class Grid {
    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    public Coordinate nextCoordinateFor(Coordinate coordinate, Direction direction) {
//        throw new UnsupportedOperationException();
        int x = coordinate.x();
        int y = coordinate.y();

        if (direction == Direction.NORTH) {
            y = (y + 1) % MAX_HEIGHT;
        }
        if (direction == Direction.EAST) {
            x = (x + 1) % MAX_WIDTH;
        }
        if (direction == Direction.SOUTH) {
//            x = (x == 0) ? 9 : x - 1;
            y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
        }
        if (direction == Direction.WEST) {
//            x = (x == 0) ? 9 : x - 1;
            x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
        }

        return new Coordinate(x, y);
    }
}
