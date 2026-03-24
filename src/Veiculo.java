public class Veiculo {

    String marca;
    String modelo;
    String placa;
    Proprietario proprietario;

    public Veiculo(String marca, String modelo, String placa, Proprietario proprietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.proprietario = proprietario;
    }
}
