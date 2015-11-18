Código está também em https://github.com/LuizFelipeh/ces28l4

O diagrama UML está anexado.

No pacote demos, temos um demo (SellableDemo) mostrando a funcionalidade da base de dados de produtos de venda (Sellable).
E outro demo (InvoiceDemo) mostrando o funcionamento do sistema da Nota Fiscal (Invoice) e da aplicação de Impostos (Tax).

Mocks e Demos: pacotes demos e databases.
Produção: pacotes sellable (relativo aos produtos e serviços),
                  invoice (relativo diretamente a nota fiscal e sua validação)
                  taxes (relativo à aplicação de impostos)

Conceitos: (classes representadas entre parentesis)

1: Nota Fiscal (Invoice) contém Itens de Venda (Item).
2: ---
3: Item de Venda (Item) associado à um produto ou serviço existente (Sellable).
4: Produtos e Serviços que podem ser vendidos (Product e Service).
5: Imposto (Tax) define taxas (TaxRule). Produtos específicos (TributaryCategory) podem ser taxados de forma diferente.
6: Validador de NF (InvoiceValidator). Ao validar a NF o InvoiceValidator chama aplica as taxas, gera um ID único ao salvar na base de dados (InvoiceDatabaseSaver) e torna a NF imutável (explicado no requisito referente a isso).

Restrições e Requisitos:

1: No construtor da NF (Invoice), é lançada uma exceção caso não seja passado nenhum IV como parâmetro (nenhum ItemInfo no caso).

2: O IV (Item) é criado apenas dentro da NF (Invoice) através de sua informação (ItemInfo). Portanto, um IV está associado a apenas uma NF.

3: Um IV contém exatamente um produto ou serviço (Sellable/Product/Service).

4: Um P/S (Sellable/Product/Service) pertence sempre a um IV (Item), pois ele é criado dentro do IV (Item) através dos seus dados (ItemInfo). Podem pertencer a outro P/S como será visto a seguir.

5: P/S (Sellable/Product/Service) são criados a partir de uma info (SellableInfo) que só é gerada pela factory (SellableFactory) que pega as informações do banco de dados (SellableDatabase). Essa info inclui a categoria tributária.

6: Usando o DP State, a NF (Invoice) possui dois estados, em elaboração (OpenInvoiceState) e validada (ClosedInvoiceState). Ela é criada com o estado Open e, quando validada, muda para o estado Closed. O método toString() dos estados cuida para que a impressão da NF contenha essa informação. 

7: A NF pode ser validada (método validate() que invoca o InvoiceValidator). Esse último calcula os impostos que foram configurados nele através do addTax() e armazena no BD:NF (InvoiceDatabaseSaver). A NF então passa para o estado validada indicado em [6]. O estado validada (ClosedInvoiceState) não permite alterações na NF. O BD:NF deve gerar IDs únicos como no Demo (databases.MockInvoiceDatabase).

8: O validador (InvoiceValidator) possui vários impostos (List<Tax>). O imposto possui uma aliquota/regra default (defaultTaxRule) que pode ser modificada ou não-utilizada. As categorias de P/S podem ser taxadas de forma diferente através da implementação de diferentes regras para o imposto (TaxRule). A categoria tributaria (TributaryCategory) que veio do BD:PS não pode ser alterada.

9: Para incluir um novo imposto, basta instanciar uma nova (Tax). Os cálculos das taxas podem ser implementados em diferentes regras (TaxRule) que compõe o imposto. Essas regras recebem elementos passíveis de taxação (Taxable) e portanto só tem acesso a quantidade, preço e categoria tributária.

10: Um imposto (Tax/TaxRule) recebe toda a lista de IV da NF (List<Taxable>), portanto a regra implementada pode utilizar a sequência dos IV durante o processamento.

11: A NF validada recebe um ID do BD:NF através do método save(). Esse ID aparece na impressão.

12: ---

13: Existe um enum (TributaryCategory), que contém a categoria dos produtos e serviços. A lista do enum pode ser facilmente modificada.

14: NF (Invoice) contém métodos addItem(), modifyItem() e removeItem(). São os únicos métodos que mexem na lista dos items.

15: BD está em um pacote a parte (databases). As duas DBs implementadas (de sellable e invoice) são Singleton.

16: Os impostos estão no pacote taxes. A criação de novos impostos consiste em implementar novas regras, isto é, classes que herdam de TaxRule. Essas modificações não alteram os pacotes do sistema.

17: Os P/S retirados do BD vem como Info's, que sao imutaveis; não possuem métodos que modificam. A NF validada tem o estado ClosedInvoiceState, que não permite modificações [lança exceções].

18: P/S pode conter uma lista de serviços no qual é subdividido. Pode ter vários níveis inclusive [Composite]. 

19: As regras de impostos (TaxRule) recebem um TaxData, composto pela lista dos IV da NF e ainda uma lista de TaxHistoryObject, que contém informações de NF's anteriores. No demo, há impostos que utilizam esse histórico. O TaxHistoryObject pode ser modificado para conter todas informações requeridas pelo owner.

extra[12]: A solução aqui é criar uma nova Invoice (ex: ClientInvoice), que herda de Invoice e contém mais informações, por exemplo, uma ClientInfo a ser criada. Assim, a impressão de ClientInvoice pode imprimir seus campos adicionais e depois chamar a impressão da classe mãe.















