package test.com.data.cleaning;

public interface ErrorsData {
    String ERROR_ROOM_SIZE = "Room size cannot be negative or nil.";
    String ERROR_ROOM_SIZE_MIN_PARAMS = "Room size must contain two elements.";
    String BAD_REQUEST = "Bad request";
    String ERROR_ROBO_OUTSIDE_ROOM="Robot must placed inside the room.";
    String ERROR_INITIAL_COORDINATES_DATA_TYPE="Inputs to starting position should be a numeric value";
    String ERROR_ROBO_MULTIPLE_POSITIONS = "One Robot cannot be at 2 positions at same time";
    String ERROR_COORDS_MIN_PARAMS="Coordinates must contain two elements.";
    String INSTRUCTIONS_ROBO_INSIDE_ROOM="Robot cannot be intructed to clean outside the room area walls";
    String ERROR_INTRUCTIONS_INVALID_SEQUENCE="Invalid instructions sequence:";
    String ERROR_INTRUCTIONS_NILL="No instructions have been provided.";
    String ERROR_PATCHES_INSIDE_ROOM = "Patches must be placed inside the room.";
    String ERROR_UNSUPPORTED_MEDIA="{\n" +
            "    \"timestamp\": \"2021-09-15T16:05:50.106+00:00\",\n" +
            "    \"status\": 415,\n" +
            "    \"error\": \"Unsupported Media Type\",\n" +
            "    \"path\": \"/v1/cleaning-sessions\"\n" +
            "}";
    String ERROR_METHOD_NOT_ALLOWED="{\n" +
            "    \"timestamp\": \"2021-09-15T16:07:39.931+00:00\",\n" +
            "    \"status\": 405,\n" +
            "    \"error\": \"Method Not Allowed\",\n" +
            "    \"path\": \"/v1/cleaning-sessions\"\n" +
            "}";



}
