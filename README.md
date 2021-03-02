# Synerzip-casestudy.pharmacy
In this case study I have created seperate packages for each functionality.

com.saurabh.medicalpharmacy package contains:
  i) Main file(Test.java)
  ii) XML config file(jdbcconfig.xml)
  iii) Property file(Pharmacy.properties)
  
Other packages are:
  i)com.saurabh.entities (contains pojo classes)
  ii)com.saurabh.services (contains interface for each dao)
  iii)com.saurabh.dao (contains data access object for each entity)
  iv)com.saurabh.rowmapper (contains rowmapper classes to fetch data from db)

I also included db file which is in database folder, if you want to run the project in your machine then import the db file in your mysql.
