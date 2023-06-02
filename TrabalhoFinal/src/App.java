import java.util.*;

public class App {
    static String vDiagnostico[] = {"Covid", "Zica", "Chikungunya", "Dengue"};

    static Paciente pUm = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pDois = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pTres = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pQuatro = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pCinco = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pSeis = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pSete = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pOito = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pNove = new Paciente(null, null, null, 0, 0, 0);
    static Paciente pDez = new Paciente(null, null, null, 0, 0, 0);
    static Object vPacientes[] = {pUm, pDois,  pTres, pQuatro, pCinco, pSeis, pSete, pOito, pNove, pDez};
    
    static Medicamento rUm = new Medicamento("CovixUltra", 0);
    static Medicamento rDois = new Medicamento("Zicox", 0);
    static Medicamento rTres = new Medicamento("ChilkTop", 0);
    static Medicamento rQuatro = new Medicamento("enguit", 0);
    static Object vMedicamento[] = {rUm, rDois, rTres, rQuatro};

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(menu()){
            menu();
        }
        
        System.out.println("Fim do programa");
    }

    public static boolean menu(){
        System.out.println("\f");

        System.out.println("MENU OPCOES");
        System.out.println("Digite a opcao desejada");
        System.out.println("1. Ver medicamentos");
        System.out.println("2. Ver pacientes");

        System.out.println("10. Fechar o sistema");
        int opcao = sc.nextInt();
        System.out.println("\f");
        switch (opcao) {
            case 1:
                verRemedio();

                System.out.println("MENU DE OPCOES");
                System.out.println("1. Voltar para o menu");
                System.out.println("2. Alterar estoque");
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        return true;

                    case 2:
                        atualizaRemedio();
                        return true;
                    
                    default:
                        System.out.println("Opção invalida");
                        return true;
                }

            case 2:
                verPacientes();

                System.out.println("MENU DE OPCOES");
                System.out.println("1. Voltar para o menu");
                System.out.println("2. Adicionar paciente");
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        return true;

                    case 2:
                        cadastroPacientes();
                        return true;
                    
                    default:
                        System.out.println("Opção invalida");
                        return true;
                }

            case 10:
                return false;
    
            default:
                System.out.println("Opção invalida");
                return true;
        }
    }

    public static void verRemedio(){
        for(int i=0; i<4; i++){
            System.out.println(vMedicamento[i].toString());
        }
    }

    public static void atualizaRemedio(){
        int quant;
        for(int i=0; i<4; i++){
            System.out.println("\f");
            System.out.println(vMedicamento[i].toString());
            System.out.println("Digite a quantia atual:");
            quant = sc.nextInt();
            ((Medicamento) vMedicamento[i]).setQuantia(quant);
        }
    }

    public static int quantiaPacientes(){
        int cont = 0;
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                cont++;
            }
        }
        return cont;
    }

    public static void verPacientes(){
        int quantiaPacientes = quantiaPacientes();
        if(quantiaPacientes>0){
            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() != null){
                    System.out.println("Paciente n° "+(i+1)+": "+((Paciente) vPacientes[i]).getNome());
                }
            }
            if(quantiaPacientes>1){
                System.out.println(quantiaPacientes+" pacientes encontrados");
            }
            else{
                System.out.println(quantiaPacientes+" paciente encontrado");
            }
        }
        else{
            System.out.println("Nenhum paciente encontrado");
        }
    }

    public static void cadastroPacientes(){
        if(quantiaPacientes()<10){
            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() != null){
                    System.out.println("Digite o nome do paciente");
                    String nome = sc.nextLine();
                    ((Paciente) vPacientes[i]).setNome(nome);

                    System.out.println("Digite o numero correspondente ao diagnostico");
                    for(int j=0; j<4; j++){
                        System.out.println((j+1)+". "+vDiagnostico[j]);
                    }
                    int diagnostico = sc.nextInt()-1;
                    ((Paciente) vPacientes[i]).setDiagnostico(vDiagnostico[diagnostico]);
                    
                    System.out.println("Digite o numero correspondente ao medicamento");
                    for(int j=0; j<4; j++){
                        System.out.println((j+1)+". "+((Medicamento) vMedicamento[j]).getMedicamento());
                    }
                    int medicamento = sc.nextInt()-1;
                    ((Paciente) vPacientes[i]).setMedicamento(((Medicamento) vMedicamento[medicamento]).getRemedio());

                    int estoqueRemedio = ((Medicamento) vMedicamento[medicamento]).getQuantia();
                    System.out.println("Estoque disponivel de "+((Medicamento) vMedicamento[medicamento]).getRemedio()+": "+estoqueRemedio);
                    System.out.println("Digite o numero de caixas receitadas");
                    int caixas = sc.nextInt();
                    while(estoqueRemedio<caixas){
                        System.out.println("Estoque indisponivel, digite um valor valido");
                        System.out.println("Digite o numero de caixas receitadas");
                        caixas = sc.nextInt();
                    }

                    ((Paciente) vPacientes[i]).setCaixas(0);

                    ((Paciente) vPacientes[i]).setCpf(0);
                    ((Paciente) vPacientes[i]).setTelefone(0);
                    ((Paciente) vPacientes[i]).setCaixas(0);

                    break;
                }
            }
        }
        else{
            System.out.println("A upa esta lotada!!!");
        }
    }
}