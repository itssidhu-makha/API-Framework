package test.com.data.cleaning;

import org.testng.annotations.DataProvider;

public class PositiveDataProviders {

    @DataProvider(name="baseData")
    public Object[][] getBaseCaseData(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1,3]","1"
                        }
                };
    }

    //rectangleRoom
    @DataProvider(name="rectangleRoom")
    public Object[][] getRectangularRoom(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [10, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1,3]","1"
                        }
                };
    }

    //positionDecimals
    @DataProvider(name="positionDecimals")
    public Object[][] getIntermediatePosition(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [10, 5],\n" +
                                "  \"coords\" : [1.2, 2.3],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1.1,3.1]","1"
                        }
                };
    }

    //repeatedPatches
    @DataProvider(name="repeatedPatches")
    public Object[][] repeatedPatchesTest(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [10, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2, 2],\n" +
                                "    [2, 3],\n" +
                                "    [2, 3],\n" +
                                "    [2, 3],\n" +
                                "    [2, 3],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1,3]","1"
                        }
                };
    }

    //decimalPatches
    @DataProvider(name="decimalPatches")
    public Object[][] decimalPatches(){
        return new Object[][]
                {
                        {"{\n" +
                                "  \"roomSize\" : [5, 5],\n" +
                                "  \"coords\" : [1, 2],\n" +
                                "  \"patches\" : [\n" +
                                "    [1, 0],\n" +
                                "    [2.3, 2.4],\n" +
                                "    [2, 3]\n" +
                                "  ],\n" +
                                "  \"instructions\" : \"NNESEESWNWW\"\n" +
                                "}",
                                "/cleaning-sessions","[1,3]","1"
                        }
                };
    }

}
