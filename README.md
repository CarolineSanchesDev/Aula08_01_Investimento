## Atividade 1 da aula 8 de Java

Requisitos:

Utilizando SWING (JFrame, JLabel, JButton, JTextField e JComboBox), crie uma aplicação ("Aula08_01_Investimento") que calcule, para o usuário, qual o rendimento ele terá numa determinada aplicação financeira. Para isso, o sistema deverá ter:

1 JFrame;
4 JLabels (3 para exibir textos informativos para solicitar dados e 1 para dar a resposta);
2 JTextFields (1 para o valor a ser aplicado e outra para o prazo da aplicação, em meses)
1 JButton (com o texto "Calcular Rendimento", que fará a ação desejada);
1 JComboBox (com os textos de cada taxa a ser usada como indexador financeiro, como "Poupança", "CDI" e "Tesouro Direto");
De acordo com a taxa selecionada, os juros aplicados à fórmula são:

Poupança: 0.38% ao mês;
CDI: 0.53% ao mês;
Tesouro Direto: 0.65% ao mês.
Os cálculos deverão ficar num pacote à parte (chamado "business"), numa classe chamada "Aplicacao". Ela deverá implementar a interface "IAplicacao" especificada abaixo:

interface IAplicacao {
    void calcularRendimento(float valorAplicado, int prazo, float taxa);
}

Nota 1: Os juros estão acima dos valores reais apenas para facilitar a realização do cálculo.
Nota 2: para realizar a potência, pode ser utilizada a função Math.pow(base, pot);
Nota 3: pesquise como permitir apenas valores numéricos ou ponto (para decimal) nos JTextFields (utilizando o método "addKeyListener").
Nota 4: pesquise como utilizar o JComboBox.
Nota 5: a classe Principal e o JFrame deverão ficar num pacote chamado "view".
Nota 6: A fórmula de juros compostos para cálculo do investimento segue abaixo:

M = C * (1 + i)t, onde:
M: montante
C: capital inicial
t: tempo/prazo de aplicação
i: taxa (o valor deve ser dividido por 100)
