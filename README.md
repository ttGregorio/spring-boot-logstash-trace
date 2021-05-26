Este projeto tem como objetivo exemplificar a utilização do logstash em conjunto com o elastic para a gestão de logs do sistema, juntamente com o sleuth para o trace de transações e o zipkin para visualização de trace distribuído

Para montar o ambiente:

1 - baixe o elasticsearch (https://www.elastic.co/pt/downloads/elasticsearch), descompacte-o, e execute o elasticsearch.sh (elasticsearch.exe caso esteja no windows) na pasta bin, ou rode sua imagem docker (https://hub.docker.com/_/elasticsearch). Caso seja rodado com os dados padrões, ele subirá em seu http://localhost:9200

2 - baixe o kibana (https://www.elastic.co/pt/downloads/kibana), descompacte-o, e execute o kibana.sh (kibana.exe caso esteja no windows) na pasta bin, ou rode sua imagem docker (https://hub.docker.com/_/kibana). Caso seja rodado com os dados padrões, ele subirá em seu http://localhost:5601/

3 - baixe o logstash (https://www.elastic.co/pt/downloads/logstash), descompacte-o, crie um arquivo chamado logstash.conf na pasta conf com os seguintes dados

input {
  tcp {
    port => 9090
    host => localhost
  }
}

output {
  elasticsearch { hosts => ["localhost:9200"] }
  stdout { codec => rubydebug }
}

isso indicará que seu logstash será chamado pelo seu localhost, porta 9090, e enviará os dados para seu localhost, porta 9200.

4 - execute na pasta do seu logstash  ./bin/logstash -f config/logstash.conf * para inicializar seu logstash

*Não é obrigatório que o nome do arquivo seja logstash, ou que ele esteja na pasta config. Estes são apenas nomes utilizados para facilitar a localização, mas você pode colocar o nome e a pasta que quiser.




This project aims to exemplify the use of logstash in conjunction with elastic for the management of system logs, along with sleuth for transaction tracing and zipkin for distributed trace visualization.

To set up the environment:

1 - download elasticsearch (https://www.elastic.co/en/downloads/elasticsearch), unzip it, and run elasticsearch.sh (elasticsearch.exe if it is on windows) inside bin folder, or run your image docker (https://hub.docker.com/_/elasticsearch). If it is run with standard data, it will go up on your http: // localhost: 92001 - download elasticsearch (https://www.elastic.co/en/downloads/elasticsearch), unzip it, and run elasticsearch.sh (elasticsearch.exe if it is on windows) in the bin folder, or run your image docker (https://hub.docker.com/_/elasticsearch). If it is run with standard data, it will go up on your http://localhost:9200

2 - download kibana (https://www.elastic.co/pt/downloads/kibana), unzip it, and run kibana.sh (kibana.exe if it is on windows) inside bin folder, or run your image docker (https://hub.docker.com/_/kibana). If it is run with standard data, it will go up on your http://localhost:5601

3 - download the logstash (https://www.elastic.co/en/downloads/logstash), unzip it, create a file called logstash.conf in the conf folder with the following data

input {
  tcp {
    port => 9090
    host => localhost
  }
}

output {
  elasticsearch { hosts => ["localhost:9200"] }
  stdout { codec => rubydebug }
}

this will indicate that your logstash will be called by your localhost, port 9090, and will send the data to your localhost, port 9200.

4 - run in your logstash folder ./bin/logstash -f config / logstash.conf * to initialize your logstash

* It is not mandatory that the file name is logstash, or that it is in the config folder. These are just names used to make it easier to find, but you can enter any name and folder you want.