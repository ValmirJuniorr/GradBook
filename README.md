<h2>GradBook is a system of managerment of courses!</h2>

<h3>Enverioment</h3>
<ol>
	<li>JDK 8</li>
	<li>WildFly 10</li>
	<li>Postgresql 9.5</li>
</ol>

<h3>To run the aplication its necessary doing the next steeps:</h3>
<ol>
<li>

<p> 
   <datasource jta="true" jndi-name="java:jboss/datasources/GradBookDS" pool-name="GradBookDS" enabled="true" use-java-context="true"></datasource></br>
        <connection-url>jdbc:postgresql://localhost:5432/GradBook</connection-url></br>
        <driver>postgresql</driver></br>
        <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation></br>
        <pool></br>
                <min-pool-size>5</min-pool-size></br>
                <max-pool-size>10</max-pool-size></br>
        </pool></br>
        <security></br>
                <user-name>User of the Database</user-name></br>
                <password>Password of the Database</password></br>
        </security></br>
        <validation></br>
                <check-valid-connection-sql>SELECT 1</check-valid-connection-sql></br>
                <validate-on-match>false</validate-on-match></br>
                <background-validation>false</background-validation></br>
        </validation></br>
        <statement></br>
                <track-statements>true</track-statements></br>
                <share-prepared-statements>false</share-prepared-statements></br>
        </statement></br>
    </datasource></br>
</p>
</li>
<li>
	<p>So you have to create a Database naming with "GradBook" </p>
</li>
</ol>