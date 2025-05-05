import br.com.one.model.Conversion;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Conversion conversion = new Conversion();
        String typeCurrency;

        try {
            while (true) {
                System.out.println(
                        """
                                ---------------------------------------------------------------------------------------
                                |                               CONVERSOR DE MOEDA $                                  |
                                ---------------------------------------------------------------------------------------
                                |  1 - Real(BRL) -> Dólar(USD)           | |  6 - Peso Argentino(ARS) -> Real(BRL)    |
                                |  2 - Dólar(USD) -> Real(BRL)           | |  7 - Real(BRL) -> Yuan Chinês(CNY)       |
                                |  3 - Real(BRL) -> Euro(EUR)            | |  8 - Yuan Chinês(CNY) -> Real(BRL)       |
                                |  4 - Euro(EUR) -> Real(BRL)            | |  9 - Real(BRL) -> Iene Japonês(JPY)      |
                                |  5 - Real(BRL) -> Peso Argentino(ARS)  | |  10 - Iene Japonês(JPY) -> Real(BRL)     |
                                |                    11 - Real(BRL) -> ?     12 - ? -> Real(BRL)                      |
                                |                                  20 - Histórico                                     |
                                |                                     0 - sair                                        |
                                ---------------------------------------------------------------------------------------
                                Digite a sua escolha:
                        """);
                int choose = scanner.nextInt();
                if (choose == 0) {
                    System.out.println("Encerrado.");
                    break;
                }

                switch (choose){
                    case 1:
                        conversion.conversionPair("BRL", "USD");
                        break;
                    case 2:
                        conversion.conversionPair("USD", "BRL");
                        break;
                    case 3:
                        conversion.conversionPair("BRL","EUR");
                        break;
                    case 4:
                        conversion.conversionPair("EUR", "BRL");
                        break;
                    case 5:
                        conversion.conversionPair("BRL", "ARS");
                        break;
                    case 6:
                        conversion.conversionPair("ARS", "BRL");
                        break;
                    case 7:
                        conversion.conversionPair("BRL", "CNY");
                        break;
                    case 8:
                        conversion.conversionPair("CNY", "BRL");
                        break;
                    case 9:
                        conversion.conversionPair("BRL", "JPY");
                        break;
                    case 10:
                        conversion.conversionPair("JPY", "BRL");
                        break;
                    case 11:
                        System.out.println("Digite o código da moeda: (ex: GBP, RUB...)");
                        typeCurrency = scanner.next();
                        conversion.conversionPair("BRL", typeCurrency);
                        break;
                    case 12:
                        System.out.println("Digite o código da moeda: (ex: GBP, RUB...)");
                        typeCurrency = scanner.next();
                        conversion.conversionPair(typeCurrency, "BRL");
                        break;
                    case 20:
                        conversion.historyConversion();
                        break;
                    default:
                        System.out.println("Escolha Inválida!");
                }

            }
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
