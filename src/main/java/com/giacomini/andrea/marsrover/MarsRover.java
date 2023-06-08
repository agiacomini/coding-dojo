package com.giacomini.andrea.marsrover;

import java.util.Optional;

class MarsRover {

    private Grid grid;

    //    String direction = "N";
    Direction direction = Direction.NORTH;
    Coordinate coordinate = new Coordinate(0,0);

    public MarsRover(Grid grid) {
        this.grid = grid;
    }

    String execute(String commands) {
        System.out.println(commands.toCharArray());

        String obstacleString = "";
        for(char c : commands.toCharArray()){
            if(c == 'R'){
//                direction = rotateRight();
                direction = direction.right();
//                direction = eDirection.value();
            }
            if(c == 'L'){
//                direction = rotateLeft();
                direction = direction.left();
//                direction = eDirection.value();
            }
            if(c == 'M'){
//                coordinate = move();
//                grid = new Grid();

//                coordinate = grid.nextCoordinateFor(coordinate, direction);

                obstacleString = move();
            }
        }
//        return "0:0:" + direction;
//        return "0" + ":" + "0" + ":" + direction.value();

//        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();

        return obstacleString + coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }

    private String move() {
        Optional<Coordinate> nextCoordinate = grid.nextCoordinateFor(coordinate, direction);
        nextCoordinate.ifPresent(nc -> this.coordinate = nc);
        return nextCoordinate.isPresent() ? "" : "O:";
    }

    //    private String rotateLeft() {
////        throw new UnsupportedOperationException();
//        if(direction == "N") return "W";
//        if(direction == "W") return "S";
//        if(direction == "S") return "E";
//        return "N";
//    }

//    private String rotateRight() {
//        if(direction == "N") return "E";
//        if(direction == "E") return "S";
//        if(direction == "S") return "W";
//        else return "N";
//    }
}
