#KVB Rad Live

Dieser Service liest den aktuellen Standort der von den Kölner Verkehrsbetrieben betriebenen Fahrräder unter [Aktuelle Standorte Fahrraeder KVB-Rad](http://nextbike.net/maps/nextbike-live.xml?city=14) aus und deserialisisert sie in Java-Objekte. Hierfür wird die Bibliothek [FasterXML/jackson-dataformat-xml](https://github.com/FasterXML/jackson-dataformat-xml) verwendet. 

Zum Betrieb ist eine Postgres + Postgis notwendig. Wenn sich die Position eines Rades gegenüber dem letzten Aufruf geändert hat, wird das Ergebnis in die Datenbank geschrieben.

## Installation

### Kommandozeile

    git clone https://github.com/codeforcologne/kvbradlive.git
    cd kvbradlive
    mvn clean install

### eclipse

Für die Entwicklung in eclipse wird das Projekt über 'Import/Check out Maven Project from SCM' in eclipse importiert. Danach kann mit 'mvn clean install' alle Abhängigkeiten aufgelöst werden.

## Datenbank

Dieser Service unterstellt, dass die Datenbankverbindung per JNDI gesetzt ist. Für den Server bedeutet dies, dass der Container für die Definition der DB-Verbindung zurständig ist. Dafür muss z.B. im Tomcat die Datei context.xml angepasst werden. Folgende Einstellungen müssen eingetragen werden.

### Entwicklung

Für die Erreichbarkeit der Datenbank werden zwei Bibliotheken benötigt: 
- [PostgreSQL JDBC Driver JDBC 4.1](http://mvnrepository.com/artifact/org.postgresql/postgresql/9.3-1100-jdbc41)
- [Postgis JDBC Driver](http://mvnrepository.com/artifact/net.postgis/postgis-jdbc/2.1.7.2)

Für die Übersetzung der Anwendung werden beide jar-Files mit scope 'provided' eingebunden. Für den Betrieb eines Servers z.B. innerhalb einer Entwicklungsumgebung bedeutet das, dass der entsprechende Server die Bibliotheken kennen muss. Hierfür müssen diese heruntergeladen und im tomcat/lib Verzeichnis abgelegt werden. Dann müssen diese unter 'launch configuration/ Classpath' dem Server bekannt gemacht werden.

### Connection

Folgende Parameter müssen im Server gesetzt sein, damit die Services die Datenbank erkennen können:

context.xml

    <Context>
        <ResourceLink 
             name="jdbc/kvbrad" 
             global="jdbc/kvbrad"
             type="javax.sql.DataSource" />
    </Context> 

server.xml

    <GlobalNamingResources>
        <Resource 
            name="jdbc/kvbrad"
            auth="Container"
            driverClassName="org.postgresql.Driver"
            maxTotal="25" 
            maxIdle="10"
            username="username"
            password="password"
            type="javax.sql.DataSource"
            url="jdbc:postgresql://localhost:5432/kvbrad"
            validationQuery="select 1"/>

### DB-Tabellen

Zur Zeit wird nur eine Tabelle verwendet; DDL:

	CREATE TABLE bike (
	    uid                          integer,
	    name         varchar(256),
	    bike         integer DEFAULT 0,
	    number       integer NOT NULL,
	    modtime      timestamp DEFAULT current_timestamp
	);
	SELECT AddGeometryColumn ('public','bike','geom',4326,'POINT',2);

Für das Logging der Abfragen wird folgende Tabelle benötigt:

    CREATE TABLE kvbradlive (
        numberofinsert      integer,
        modtime      timestamp DEFAULT current_timestamp
    );

## REST Endpoints

Folgende REST Endpoints stehen zur Verfügung

### /kvbradlive/service
### /kvbradlive/service/datatable
### /kvbradlive/service/bikesmap
### /kvbradlive/service/bike/&lt;number&gt;
### /kvbradlive/service/allbikeslatestposition/bikeslist

### /kvbradlive/service/put

Mit diesem REST-Endpoint wird das Auslesen der Schnittstelle ausgelöst und ggf. die Werte in die Datenbank eingefügt. Vorgehen:

1. AskForNextBikeLife
2. Get the Bikes
3. Insert Bikes to DB;
   check for existing bike before inserting

### /kvbradlive/service/delete

Mit diesem REST-Endpoint werden die Einträge der letzten 30 Tage gelöscht.

## Test

### Tests mit Datenbank

Da zur Zeit keine Integration Test Stage zur Verfügung steht, sind alle Tests, die eine Datenbank voraussetzt als main codiert. Um eine Datenbankverbindung hierfür zur Verfügung stellen zu können, muss die Datei src/test/resources/jndi.properties.template in src/test/resources/jndi.properties kopiert und die entsprechenden Parameter zur Datenbank gesetzt werden.

## License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.