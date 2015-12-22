# Kamino
## OPS - Processamento Dados Abertos - CEAPS

Software para o processamento dos dados aberto do portal de transparência do governo brasileiro.

http://www12.senado.gov.br/transparencia/dados-abertos/dados-abertos-ceaps


# Libs
* [Commons CLI] - The Apache Commons CLI library provides an API for parsing command line options passed to programs.
* [Commons Lang] - The standard Java libraries fail to provide enough methods for manipulation of its core classes.
* [opencsv] - Opencsv is a very simple csv (comma-separated values) parser library for Java.


   [Commons CLI]: <https://commons.apache.org/proper/commons-cli/>
   [Commons Lang]: <https://commons.apache.org/proper/commons-lang/>
   [opencsv]: <http://opencsv.sourceforge.net/>

# Usage
```sh
$ java -jar -file_path /home/user/Downloads/2015.csv -host localhost -host_port 3306 -schema ops_kamino -user root -user_pass mypass
```
