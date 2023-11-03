// package Ch1;

// import RequestModel.Pet;
// import ResponseModels.PetResponse;
// import io.restassured.builder.RequestSpecBuilder;
// import io.restassured.builder.ResponseBuilder;
// import io.restassured.builder.ResponseSpecBuilder;
// import io.restassured.http.ContentType;
// import io.restassured.specification.RequestSpecification;
// import io.restassured.specification.ResponseSpecification;
// import org.testng.Assert;
// import org.testng.annotations.*;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.Matchers.*;


// public class First {
//     RequestSpecification requestSpecific;
//     ResponseSpecification responseSpecific;

//     /**
//      * ok into next method we will use the simple way to send a request
//      */
//     @Test
//     public void TestGetRequestToStartCourse(){
//         given().
//         when().
//             get("http://api.zippopotam.us/us/90210").
//         then().log().all().
//              assertThat().statusCode(200).
//              assertThat().body("places[0].'place name'", equalTo("Beverly Hills")).
// //             assertThat().body("post code",equalTo("90210")).
//              assertThat().body("places", hasSize(1)).
//              assertThat().body("places.'place name'",hasItem("Beverly Hills")).
//              assertThat().body("country",equalTo("United States")).
//              assertThat().contentType("application/json").
//              assertThat().contentType(ContentType.JSON).
//              assertThat().header("Server",equalTo("cloudflare"));


//     }
//     /**
//      * into attached we will use advanced way by
//      * 1- add @dataprovider testng annotation and provide java object into it
//      * 2- pass those value to our rest assured request using @Test(dataProvider = "dat provide method name")
//      * note if we are using junit we will give the provider @dataprovider and the test with @UsedDataProdiver under test annotation
//      */

//         @DataProvider
//         public Object[][] zipCodesAndPlaces() {
//             return new Object[][] {
//                     { "us", "90210", "Beverly Hills" },
//                     { "us", "12345", "Schenectady" },
//                     { "ca", "B2R", "Waverley" }
//             };
//         }
//     @Test(dataProvider = "zipCodesAndPlaces")
//     public void TestGetRequestToStartCourseAfterParametrizing(String zipCode , String id , String city){
//         given().
// //                pathParams("zipCode",zipCode).pathParams("id",id).
//                 when().
//                 get(endpoint(zipCode + "/" + id)).
//                 then().log().all().
//                 assertThat().statusCode(200).
//                 assertThat().body("places[0].'place name'", equalTo(city)).
//                 assertThat().body("places", hasSize(1)).
//                 assertThat().body("places.'place name'",hasItem(city)).
//                 assertThat().contentType("application/json").
//                 assertThat().contentType(ContentType.JSON).
//                 assertThat().header("Server",equalTo("cloudflare"));


//     }
//     @Test
//     public void P1_mayar(){
//         System.out.println("mayar");
//     }
//     public String endpoint(String endpoint){
//             return "http://api.zippopotam.us/" + endpoint;
//     }

//      @Test(dataProvider = "zipCodesAndPlaces")
//     public void TestGetRequestToStartCourseAfterParametrizing2(String zipCode , String id , String city){
//         given().
//                 when().
//                 get("http://api.zippopotam.us/" + zipCode + "/" + id).
//                 then().log().all().
//                 assertThat().statusCode(200).
//                 assertThat().body("places[0].'place name'", equalTo(city)).
//                 assertThat().body("places", hasSize(1)).
//                 assertThat().body("places.'place name'",hasItem(city)).
//                 assertThat().contentType("application/json").
//                 assertThat().contentType(ContentType.JSON).
//                 assertThat().header("Server",equalTo("cloudflare"));


//     }
//     /**
//      * now we will optimize it more
//      * 1- we will use requestSpecifications to set our base url to use it across test into before test method
//      * 2- we setBaseUri then build but we can set other things like auth , headers cookies or anything
//      * 3- to use it set it after giver using spec(object)
//      */
//     @BeforeClass
//     public void createRequestSpecifications(){
//          requestSpecific = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us/").build();

//     }
//     @Test(dataProvider = "zipCodesAndPlaces")
//     public void TestGetRequestToStartCourseAfterParametrizing3(String zipCode , String id , String city){
//         given().
//                 spec(requestSpecific).
//                 when().
//                 get(zipCode + "/" + id).
//                 then().log().all().
//                 assertThat().statusCode(200).
//                 assertThat().body("places[0].'place name'", equalTo(city)).
//                 assertThat().body("places", hasSize(1)).
//                 assertThat().body("places.'place name'",hasItem(city)).
//                 assertThat().contentType("application/json").
//                 assertThat().contentType(ContentType.JSON).
//                 assertThat().header("Server",equalTo("cloudflare"));


//     }
//     /**
//      * into the next we will provide response specification to assert on something for all requests like alle responses
//      * should be application/json , or all response status code should be 200
//      * we can do it using responseSpecifications
//      * if we need to add more assertions we can use .and
//      */
//     @BeforeTest
//     public void createResponseSpecifications(){
//         responseSpecific = new ResponseSpecBuilder().expectStatusCode(200).
//                 expectContentType(ContentType.JSON).build();
//     }
//     @Test(dataProvider = "zipCodesAndPlaces")
//     public void TestGetRequestToStartCourseAfterParametrizing4(String zipCode , String id , String city){
//         given().
//                 spec(requestSpecific).
//                 when().
//                 get(zipCode + "/" + id).
//                 then().
//                 spec(responseSpecific).and().
//                 assertThat().body("places[0].'place name'", equalTo(city)).
//                 assertThat().body("places", hasSize(1)).
//                 assertThat().body("places.'place name'",hasItem(city)).
//                 assertThat().contentType("application/json").
//                 assertThat().header("Server",equalTo("cloudflare"));

//     }
//     /**
//      * okay into next we will know how to extract specific value from response to reuse it
//      */
//     @Test(dataProvider = "zipCodesAndPlaces")
//     public void TestGetRequestToStartCourseAfterParametrizingExtractPlace(String zipCode , String id , String city){

//        String place =  given().
//                 spec(requestSpecific).
//                 when().
//                 get(zipCode + "/" + id).
//                 then().log().all().
//                 spec(responseSpecific).and().
//                 assertThat().body("places[0].'place name'", equalTo(city)).
//                 assertThat().body("places", hasSize(1)).
//                 assertThat().body("places.'place name'",hasItem(city)).
//                 assertThat().contentType("application/json").
//                 assertThat().header("Server",equalTo("cloudflare")).
//                 extract().path("places[0].'place name'");
//         System.out.println("here is the place ===========> " + place);

//     }

//     /**
//      *
//      * here we will implement POJO class to serialize and deserialize objects
//      */
//     @Test
//     public void TestGetRequestToStartCourseAfterPojo(){
//         Location location = given().
//                 when().get("http://api.zippopotam.us/us/90210").
//                 as(Location.class);
//         Assert.assertEquals("Beverly Hills",location.getPlaces().get(0).getPlaceName());

//     }
// //------------------------------------------Re-Use of POJO ---------------------------------------


//     @Test
//     public void createNewPet(){
//         String[] test =  new String[1];
//         test[0]="testt";

//         Pet pet = new Pet(0,0,"string","doggie",test,0,"string","available");
//         PetResponse petResponse = given().
//                 header("accept","application/json").
//                 header("Content-Type","application/json").
//                 body(pet).log().body().
//                 when().post("https://petstore.swagger.io/v2/pet").
//                 as(PetResponse.class);
//         Assert.assertEquals("string", petResponse.getCategory().getName());


//     }




// }
