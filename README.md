### Welcome to MyMoney
MyMoney is a simple web app for entering and tracking spending details.
It allows you to create accounts (for example Cash or Checking) and enter transactions associated
with those accounts.

The app is (usually!) running at http://mymoney.shaunabram.cloudbees.net
(Note that it may be a little slow to load first time as I'm using the free account from the
CloudBees service, which means the server is hibernated when not in use).

I created it as a way to get more familiar with certain technologies, rather than as a serious app.
It uses JSP/CSS on the front end, Java & Spring MVC on the server with a MySQL database accessed via
Hibernate (as well as the in-memory HSQLDB database for tests).

It also utilizes Continuous Integration. Any new check-ins are automatically tested and built (using
maven) and deployed using Jenkins and CloudBees.

Although there is a bunch more I could do with it, I am not planning to work on it anymore since it
served its purpose of getting more up to speed on the aforementioned technologies.

###Run locally
To run locally:
* Checkout from GitHub (https://github.com/sabram/MyMoney)
* Setup a local MySQL database and set up the schema by doing something like
      mysql -u root -p mymoney < mymoney.sql
* To run in dev mode, set an system property such as mymoney.env=dev. It defaults to running in prod mode.
(see the dev.hibernate.cfg.xml and hibernate.cfg.xml files for more details)
* Build via maven (e.g. mvn package) and deploy to your app server of choice (I used tomcat7).

### Authors and Contributors
@sabram
