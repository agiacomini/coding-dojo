package com.giacomini.andrea.marsrover;

class MarsRover {

//    String direction = "N";
    Direction direction = Direction.NORTH;
    String execute(String commands) {

        System.out.println(commands.toCharArray());
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
        }
//        return "0:0:" + direction;
        return "0:0:" + direction.value();
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
