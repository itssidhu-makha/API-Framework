package test.com.data.cleaning;

import org.testng.annotations.DataProvider;

public class NegativeDataProviders {

    @DataProvider(name="roomSizeNil")
    public Object[][] roomSizeNill_Negative(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [0, 0],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_ROOM_SIZE
                        }
                };
    }
    //multiRoomDimension
    @DataProvider(name="multiRoomDimension")
    public Object[][] multiDimensionsRoom(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5,3],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_ROOM_SIZE_MIN_PARAMS
                        }
                };
    }

    //yOutsideRoom
    @DataProvider(name="yOutsideRoom")
    public Object[][] yAxisOutsideRoom(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [2, 5.5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_ROBO_OUTSIDE_ROOM
                        }
                };
    }
    //positionNegative
    @DataProvider(name="positionNegative")
    public Object[][] positionNegative(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [-2, -5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_ROOM_SIZE
                        }
                };
    }

    @DataProvider(name="validDataTypesPosition")
    public Object[][] positionInvalidDataTypes(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [\"1\", \"2\"],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_INITIAL_COORDINATES_DATA_TYPE
                        }
                };
    }

    @DataProvider(name="roboAtMultiplePositions")
    public Object[][] canOneRoboSpanMultiplePositions(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [[1, 2],[2,3]],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.ERROR_ROBO_MULTIPLE_POSITIONS
                        }
                };
    }

    @DataProvider(name="pathAtTopRightCornerOfRoom")
    public Object[][] patch_TopRightCorner(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [5, 5],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1,2]"
                        }
                };
    }

    @DataProvider(name="robo_CannotClean_OutsideRoom")
    public Object[][] robo_CannotClean_OutsideRoom(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 2],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNNNNN\"\n" +
                                "}",
                                "/cleaning-sessions",ErrorsData.INSTRUCTIONS_ROBO_INSIDE_ROOM
                        }
                };
    }

    @DataProvider(name="timeStamp_InvalidTest")
    public Object[][] timeStamp_InvalidTest(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 2],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNEESS\"\n" +
                                "}",
                                "/cleaning-sessions"
                        }
                };
    }
}
