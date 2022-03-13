# PostcodeApp
Java
I wrote the following classes:
Class Result- which holds the internal data of each post code
Class Validate- which holds for each postcode the status of finding this postcode in the api and Boolean indicator the indicate if there information for this post code, from the query GET /postcodes/{POSTCODE}/validate
Class PostcodeObject- which holds the status of finding this postcode and Result object( which again, is the internal data of each post code)- from the query GET /postcodes/{POSTCODE}
Class Nearest Postcodes- which holds the status of finding nearest postcodes from api query  and List of Result objects( list of nearest postcodes objects) from the query GET /postcodes/{POSTCODE}/nearest
Class PostcodeParser- this class manage the validation and the queries from api of relevant postcode data and it’s nearest postcodes information. 
Main Class: receive a postcode as an argument and print post code information (country and region) and Also the list of nearest postcodes information (country and region)
PostcodeTest Class- class for unit test which test the validation method from PostcodeParser,and  extracting all the relevant data for specific  postcode




