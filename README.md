# SD_        T H O R . E N T

# RESUMO
O presente trabalho apresenta uma aplicação Java com web service RESTFUL, para rede P2P. Neste projeto, cada Peer atua como cliente e servidor (servente) onde eles recebem uma lista dos pares conectados a rede, através do tracker. 
O tracker recebe solitações de Peers que querem entrar na rede, eles informa seu ip e dados dos arquivos que possuem. 
O Peer então é capaz de fazer download dos arquivos de outros Peers conectados, através do hash do array de bytes que é gerado do arquivo original. Esse array é fragmentado em partes menores e cada peer que contem o arquivo original manda um fragmento para o peer requerente.
No fim, os fragmentos são inseridos em um array vazio do peer requerente e gera um hash para ser verificado com hash recido do tracker. Se o hash forem iguais então um arquivo é criado usado o array baixado.

# Sobre o Projeto
O projeto consiste no desenvolvimento de uma rede p2p, onde foram desenvolvidos um serviço web para o tracker e aplicação e serviço web para peers.

O Tracker tem a função de guardar as informações de todos os arquivos disponíveis nessa rede, sendo elas o hash do arquivo gerado através de seu vetor de bytes, o nome do arquivo, o tamanho do arquivo, o tamanho do seu vetor de bytes que será usado na métrica de divisão de pacotes e inclusive a informação de todos os Peers que hospedam aquele arquivo e disponibilizam para download.
Sempre que um Peer se conecta na rede, ele escaneia o diretório específico para armazenamento dos arquivos disponíveis e informa ao Tracker, em seguida ele requere do Tracker a lista de todos os arquivos disponíveis na rede, ou seja, os arquivos que os outros Peers também já informaram estar à disposição.

O Peer seleciona o arquivo desejado da lista, verifica os IPs que hospedam aquele arquivo e faz as solicitações de pacotes de bytes, que são a forma que esses arquivos são processados. A métrica para o tamanho de pacotes é dinâmica, varia sempre da quantidade de Peers que possuem o arquivo para envio. O Peer requerente abre uma Thread para cada solicitação e aguarda o pacote para armazenar em um vetor auxiliar que já aguarda na posição específica onde deve ser armazenado o pacote solicitado, porém a aplicação não espera que essa Thread se conclua para fazer uma nova solicitação, ela continua mandando solicitações para os Peers que já estiverem disponíveis. Dessa forma, o Peer que tiver maior poder de processamento para trabalhar o pacote solicitado e melhor latência para retornar mais rápido, estará mais vezes disponível na rede e será mais solicitado que um Peer de configuração menos robusta e em pior estado na rede, por exemplo.

Quando todas as solicitações já estiverem sido enviadas, a aplicação espera que todas as Threads abertas se concluam, garantindo que não falte nenhum pacote no vetor principal. Para garantir a integridade dos pacotes, é gerado um hash deste pacote e comparado com o hash original do pacote enviado junto no download. Após todas a Threads forem encerradas e o vetor principal for preenchido, é gerado um hash deste vetor e comparado com o hash do arquivo original informado pelo Tracker, quando os hashs forem iguais então a integridade do arquivo foi mantida, em seguida ele constrói o arquivo no diretório de download.
