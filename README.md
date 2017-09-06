# TargetRestPOC

We need MongoDB installed and used Spring Boot and Spring Data for this POC.
Used JSON Simple API to parse json string to find product name.
Used SpringBootTest for integration test.


Assumptions:
1. There are only two fields - product id & product price in a collection called Product in MongoDB. 
2. The product name is read from external rest service so it is defined as transient in data model/POJO.
3. Assumed for now that there will be only one product id will be passed as path variable instead of multiple ids at a time.
4. PUT method is implemented to update product price as it is the only field in the product table other than product id.
5. All products can be retrieved by GET - read all resource. Though it is not a real time scenario, it is implemented as part of the POC.
6. Assumed that name under item_type is the product name.
7. JSON parser is implemented little tediously as I’m in hurry to complete it but I can implement it in a better way.
8. Test cases are done for happy path but did not tested for negative scenarios.
