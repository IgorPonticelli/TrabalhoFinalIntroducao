import java.util.*;

// !!ESTE PROGRAMA SERA COMENTADO A PEDIDO DA PROFESSORA!!
public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //repede o menu enquanto o usuario desejar
        while(menu()){
        }
        
        System.out.println("Fim do programa");
    }

    //metodo responsavel por direcionar todas as funções do sistema
    public static boolean menu(){
        System.out.println(".---------------------------------------.");
        System.out.println("|              *MENU OPÇÕES*            |");
        System.out.println("|        Digite a opção desejada        |");
        System.out.println("|                                       |");
        System.out.println("| 1. Ver medicamentos                   |");
        System.out.println("|                                       |");
        System.out.println("| 2. Ver pacientes                      |");
        System.out.println("|                                       |");
        System.out.println("| 3. Adicionar paciente                 |");
        System.out.println("|                                       |");
        System.out.println("| 4. dar auta paciente                  |");
        System.out.println("|                                       |");
        System.out.println("| 5. acessar menu de desenvolvedor      |");
        System.out.println("|                                       |");
        System.out.println("| 6. Relatorio de doenças               |");
        System.out.println("|                                       |");
        System.out.println("| 7. Fechar o sistema                   |");
        System.out.println("'---------------------------------------'");
        //utilizado string para prevencao de erros do usuario
        String opcao = sc.next();
        switch (opcao) {
            case "1":
                //imprime a lista de remedios e estoque
                CadastroPacientes.verRemedio();

                //menu
                System.out.println("    \n MENU DE OPÇÕES   ");
                System.out.println("                        ");
                System.out.println("\n 1. Voltar para o menu");
                System.out.println("                        ");
                System.out.println("\n 2. Alterar o estoque   ");
                opcao = sc.next();
                switch(opcao){
                    case "1":
                        //volta para o menu
                        return true;

                    case "2":
                        //atualiza o estoque conforme os valores a serem passados
                        CadastroPacientes.atualizaRemedio();
                        return true;
                    
                    default:
                        //tratamento de erro, retorna ao menu principal
                        System.out.println("**Opção inválida**");
                        return true;
                }

            case "2":
                //imprime a lista com os nomes dos pacientes em ordem de chegada
                CadastroPacientes.verPacientes();

                System.out.println("            *MENU DE OPÇÕES*            ");
                System.out.println("                                        ");
                System.out.println("\n 1. Voltar ao menu                    ");
                System.out.println("                                        ");
                System.out.println("\n 2. Ordem alfabetica                  ");
                System.out.println("                                        ");
                System.out.println("\n 3. Ver lista detalhada dos pacientes ");
                opcao = sc.next();
                switch(opcao){
                    case "1":
                        //retorna ao menu
                        return true;

                    case "2":
                        //imprime os nomes dos pacientes em ordem alfabetica
                        for(int i=0; i<CadastroPacientes.quantiaPacientes(); i++){
                            System.out.println("Paciente n° "+(i)+":");
                            System.out.println(CadastroPacientes.ordemAlfabetica()[i]);
                        }
                        return true;

                    case "3":
                        //imprime a lista completa dos pacientes em ordem de chegada
                        CadastroPacientes.verDetalhadoPacientes();

                    default:
                        //tratamento de erro, retorna para o menu
                        System.out.println("**Opção invalida**");
                        return true;
                }
            
            case "3":
                //formulario para cadatro de novo paciente
                CadastroPacientes.cadastroPacientes();
                return true;

            case "4":
                //remove o paciente desejado e reorganiza o vetor
                CadastroPacientes.darAutaPaciente();
                return true;

            case "5":
                //opções solicitas pela professora que não se encaixavam muito bem no contexto da upa
                System.out.println("              *MENU DE OPÇÕES*          ");
                System.out.println("                                        ");
                System.out.println("\n 1. Escrever todo vetor               ");
                System.out.println("                                        ");
                System.out.println("\n 2. Escrever somente posições ocupadas");
                System.out.println("                                        ");
                System.out.println("\n 3. Voltar para o menu                ");
                opcao = sc.next();
                switch (opcao){
                    case "1": 
                        //escreve o vetor completo
                        CadastroPacientes.escreveTodoVetor();
                        return true;
                    case "2":
                        //escreve somente as opções ocupadas
                        //basicamente a mesma coisa de ver lista detalhada dos pacientes
                        CadastroPacientes.escreveOcupadosNoVetor();
                        return true;

                    case "3":
                        //retorna para o menu principal
                        return true;
                    default:
                        System.out.println("**Opção Invalida**");
                        return true;

                }
           
            case "6":
                //imprime o relatorio da quantia de doenças registradas
                CadastroPacientes.relatorioDoencas();
                return true;
            case "7":
                //encerra o programa
                return false;
    
            default:
                //tratamento de erro, retor
                System.out.println("**Opção invalida**");
                return true;
        }
    }
}