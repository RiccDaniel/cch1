interface CarroBuilder {
    CarroBuilder marca(String marca);
    CarroBuilder modelo(String modelo);
    CarroBuilder ano(int ano);
    Carro build();
}

class Carro {
    private String marca;
    private String modelo;
    private int ano;

    private Carro() {}

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static CarroBuilder builder() {
        return new CarroBuilderImpl();
    }

    private static class CarroBuilderImpl implements CarroBuilder {
        private Carro carro = new Carro();

        public CarroBuilder marca(String marca) {
            carro.setMarca(marca);
            return this;
        }

        public CarroBuilder modelo(String modelo) {
            carro.setModelo(modelo);
            return this;
        }

        public CarroBuilder ano(int ano) {
            carro.setAno(ano);
            return this;
        }

        public Carro build() {
            return carro;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Carro meuCarro = Carro.builder()
            .marca("Toyota")
            .modelo("Corolla")
            .ano(2022)
            .build();

        System.out.println("Meu carro: " + meuCarro.getMarca() + " " + meuCarro.getModelo() + " " + meuCarro.getAno());
    }
}
