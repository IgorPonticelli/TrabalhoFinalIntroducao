import java.util.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(menu()){
        }
        
        System.out.println("Fim do programa");
    }

    public static boolean menu(){
        System.out.println("\f");

        System.out.println(".---------------------------------------.");
        System.out.println("|              *MENU OPÇÕES*            |");
        System.out.println("|         Digite a opção desejada       |");
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
        System.out.println("| 10. Fechar o sistema                  |");
        System.out.println("'---------------------------------------'");
        int opcao = sc.nextInt();
        System.out.println("\f");
        switch (opcao) {
            case 1:
                CadastroPacientes.verRemedio();

                System.out.println("       MENU DE OPÇÕES   ");
                System.out.println("                        ");
                System.out.println("\n 1. Voltar para o menu");
                System.out.println("                        ");
                System.out.println("\n 2. Alterar o estoque   ");
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        return true;

                    case 2:
                        CadastroPacientes.atualizaRemedio();
                        return true;
                    
                    default:
                        System.out.println("**Opção inválida**");
                        return true;
                }

            case 2:
                CadastroPacientes.verPacientes();

                System.out.println("            *MENU DE OPÇÕES*            ");
                System.out.println("                                        ");
                System.out.println("\n 1. Voltar ao menu                    ");
                System.out.println("                                        ");
                System.out.println("\n 2. Ordem alfabetica                  ");
                System.out.println("                                        ");
                System.out.println("\n 3. Ver lista detalhada dos pacientes ");
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        return true;

                    case 2:
                        for(int i=0; i<CadastroPacientes.quantiaPacientes(); i++){
                            System.out.println("Paciente n° "+(i)+":");
                            System.out.println(CadastroPacientes.ordemAlfabetica()[i]);
                        }
                        return true;

                    case 3:
                        CadastroPacientes.verDetalhadoPacientes();
                        System.out.println("     MENU DE OPÇÕES");
                        System.out.println("\n 1. Voltar ao menu");
                        System.out.println("\n 2. ordem alfabetica");
                        opcao = sc.nextInt();

                        switch (opcao){
                            case 1:
                                return true;

                            case 2:
                                Object vAux[] = CadastroPacientes.ordemAlfabeticaDetalhada();
                                for(int i=0; i<CadastroPacientes.quantiaPacientes(); i++){
                                    System.out.println("Paciente n° "+(i)+":");
                                    System.out.print(((Paciente) vAux[i]).toString());
                                }
                                return true;
                        }
                        return true;
                    
                    default:
                    
                        System.out.println("**Opção invalida**");
                        return true;
                }
            
            case 3:
                CadastroPacientes.cadastroPacientes();
                return true;

            case 4:
                CadastroPacientes.darAutaPaciente();
                return true;

            case 5:
                System.out.println("              *MENU DE OPÇÕES*          ");
                System.out.println("                                        ");
                System.out.println("\n 1. Escrever todo vetor               ");
                System.out.println("                                        ");
                System.out.println("\n 2. Escrever somente posições ocupadas");
                System.out.println("                                        ");
                System.out.println("\n 3. Voltar para o menu                ");
                opcao = sc.nextInt();
                switch (opcao){
                    case 1: 
                        CadastroPacientes.escreveTodoVetor();
                        return true;
                    case 2:
                        CadastroPacientes.escreveOcupadosNoVetor();
                        return true;

                    case 3:
                        return true;
                    default:
                        System.out.println("**Opção Invalida**");
                        return true;

                }

            case 10:
                return false;
    
            default:
                System.out.println("**Opção invalida**");
                return true;
        }
    }
}