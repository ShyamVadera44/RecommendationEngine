# RecommendationEngine

-This application is based on recomandation engine having limited data.


Technologies which have been used : Spring boot,Gradle,Java8,H2DB.


MAIN LOGIC OF RECOMMENDATION : 

select top 5 product_id ,product_name,count(product_name ) as PRODUCT_COUNT from testdata ----GET TOP 5 PRODUCTS WITH COUNT
where customer_ip in (select distinct customer_ip  from testdata where product_id =? )\n" + -FIND OTHER PRODUCTS WHICH PURCAHRE BY C_IP
            " and product_name not in(select distinct product_name  from testdata where product_id =?) -REMOVE EXISTING PROD. FROM LIST
            group by product_name  order by count(product_name) desc;  ---SHOW HIGHEST RECOMMENDED PRODUCTS

-User can directly use this apppliction, few steps for that..

  -get clone
  
  -setup in your IDE
  
  -you must have gradle in your system
  
  -run this Spring Boot application
  
  -pass data with product id as input, eg:
  
    http://localhost:8080/test/id_6667
    
    http://localhost:8080/test/id_6616
    
-YOU GET TOP 5 RECOMMANDATION BASED ON YOUR PRODUCT_ID.
