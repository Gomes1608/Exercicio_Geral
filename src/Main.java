import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int indexVeiculo;
    static Veiculo[] veiculo = new Veiculo[5];
    static Registro[] registros = new Registro[20];
    static int indexRegistro;

    public static void main(String[] args) {
        int opcao;

        do {

            System.out.println("----- Estacionamente ParkEasy -----");
            System.out.println("[1] Entrada de veículo");
            System.out.println("[2] Saída de veículo");
            System.out.println("[3] Imprimir veículos estacionados");
            System.out.println("[4] Imprimir a receita");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> registrarEntrada();
                case 2 -> registrarSaida();
                case 3 -> imprimirVeiculos();
                case 4 -> imprimirReceita();
                case 5 -> System.out.println("ParkEasy agradece !!!");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 5);
    }

    private static void imprimirReceita() {
        double valor=0;
        for (int i = 0; i < indexRegistro; i++) {
            if (registros[i].horaSaida != null){
                valor += registros[i].calcularValor();
            }
        }
        System.out.println("Receita total R$ "+valor);
    }

    private static void imprimirVeiculos() {
        for (int i = 0; i < indexRegistro; i++) {
            if (registros[i].horaSaida ==null){
                System.out.println(registros[i].veiculo.placa);
            }
        }
    }

    private static void registrarSaida() {
        String horaSaida;
        double valor;
        Registro registro = pesquisarRegistro();
        if (registro != null) {
            System.out.println("Hora de saída (hh:mm) --> ");
            horaSaida = sc.next();
            registro.horaSaida=horaSaida;
            valor = registro.calcularValor();
            System.out.println("Valor total a pagar R$ "+valor);
        }
    }
    private static Registro pesquisarRegistro() {
        String placa;
        System.out.println("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();
        for (int i = 0; i < indexRegistro; i++) {
            if (registros[i].veiculo.placa.equals(placa)){
                return registros[i];
            }
        }
        System.out.println("Veiculo não encontrado");
        return null;
    }


    private static void registrarEntrada() {
        String nome;
        String marca, modelo, placa;
        String cpf;
        String horaEntrada;

        Veiculo veiculoEncontrado = pesquisar();

        if (veiculoEncontrado == null) {
            System.out.println("Nome do proprietário --> ");
            nome = sc.next();
            System.out.println("CPF --> ");
            cpf = sc.next();
            System.out.println("Placa --> ");
            placa = sc.next().toUpperCase();
            System.out.println("Marca --> ");
            marca = sc.next();
            System.out.println("Modelo --> ");
            modelo = sc.next();
            Proprietario proprietario = new Proprietario(nome, cpf);
            veiculo[indexVeiculo] = new Veiculo(marca, modelo, placa, proprietario);
            veiculoEncontrado = veiculo[indexVeiculo];
            indexVeiculo++;
        }
            System.out.println("Hora de entrada (hh:mm) --> ");
            horaEntrada = sc.next();
            registros[indexRegistro]=new Registro(veiculoEncontrado, horaEntrada);
            indexRegistro++;

    }

    private static Veiculo pesquisar() {
        String placa;
        System.out.println("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();
        for (int i = 0; i < indexVeiculo; i++) {
            if (veiculo[i].placa.equals(placa)) {
                return veiculo[i];
            }
        }
        System.out.println("Veiculo não encontrado");
        return null;
    }
}
