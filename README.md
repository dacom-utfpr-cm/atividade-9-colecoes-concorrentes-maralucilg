# Atividade 9 - Coleções Concorrentes

1. Implemente duas versões do problema do produtor/consumidor com M
produtores e N consumidores usando ArrayBlockingQueue e
LinkedBlockingQueue. Compare o desempenho das duas
implementações.

2. Implemente o problema do produtor/consumidor para uma estrutura com
os seguintes campos: número, simbolo, naipe, que representa uma carta
de baralho. A implementação deve possibilitar que após 10 cartas
produzidas por dois produtores, outros dois consumidores pegarão
somente as maiores cartas. Os produtores somente devem produzir mais
cartas após os consumidores removerem 3 cartas cada um. As cartas
remanescentes podem continuar na estrutura. Use a ordenação do
baralho da menor para maior: A, 2, ..., 10, Q, J, K.
