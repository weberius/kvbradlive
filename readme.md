#KVB Rad Live

Dieser Service liest den aktuellen Standort der von den Kölner Verkehrsbetrieben betriebenen Fahrräder unter [Aktuelle Standorte Fahrraeder KVB-Rad](http://nextbike.net/maps/nextbike-live.xml?city=14) aus und deserialisisert sie in Java-Objekte. Hierfür wird die Bibliothek [FasterXML/jackson-dataformat-xml](https://github.com/FasterXML/jackson-dataformat-xml) verwendet. 

Zum Betrieb ist eine Postgres + Postgis notwendig. Wenn sich die Position eines Rades gegenüber dem letzten Aufruf geändert hat, wird das Ergebnis in die Datenbank geschrieben.

##Installation

mvn clean install