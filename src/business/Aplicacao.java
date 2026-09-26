package business;

public class Aplicacao implements IAplicacao {
    private double montanteFinal;

    @Override
    public void calcularRendimento(float valorAplicado, int prazo, float taxa) {
        
        // pra transformar a taxa em porcento
        double i = taxa / 100.0;
        
        //fórmula de juros compostos
        this.montanteFinal = valorAplicado * Math.pow((1 + i), prazo);
    }

    public double getMontanteFinal() {
        return this.montanteFinal;
    }
}